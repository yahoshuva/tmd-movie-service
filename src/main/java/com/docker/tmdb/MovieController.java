package com.docker.tmdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/movies")
@Slf4j
public class MovieController {
	
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long id){
		Movie movie = movieService.read(id);
		log.info("Returned movie with id:{}",id);
		
		return ResponseEntity.ok(movie);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
		Movie createMovie = movieService.create(movie);
	
		log.info("Created movie with id:{}",createMovie.getId());
		
		return ResponseEntity.ok(createMovie);
	
	}
	
	@PutMapping("/{id}")
	public void updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		movieService.update(id, movie);
		
		log.info("Updated movie with id:{}",id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id) {
		movieService.delete(id);
		log.info("Deleted movie with id:{}",id);

	}

}

package org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math.exception.NotPositiveException;
import org.apache.commons.math.exception.NumberIsTooLargeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListPopulation implements Population {
    private List<Chromosome> chromosomes;
    private int populationLimit;

    public ListPopulation(List<Chromosome> chromosomes, int populationLimit) {
        if (chromosomes.size() > populationLimit) goto L10;
        if (populationLimit < 0) goto L8;
        this.chromosomes = chromosomes;
        this.populationLimit = populationLimit;
        return;
    L8:
        throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, Integer.valueOf(populationLimit));
    L10:
        throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(chromosomes.size()), Integer.valueOf(populationLimit), false);
    }

    public ListPopulation(int populationLimit) {
        if (populationLimit < 0) goto L7;
        this.populationLimit = populationLimit;
        this.chromosomes = new ArrayList(populationLimit);
        return;
    L7:
        throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, Integer.valueOf(populationLimit));
    }

    public void setChromosomes(List<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    public List<Chromosome> getChromosomes() {
        return this.chromosomes;
    }

    @Override // org.apache.commons.math.genetics.Population
    public void addChromosome(Chromosome chromosome) {
        this.chromosomes.add(chromosome);
    }

    @Override // org.apache.commons.math.genetics.Population
    public Chromosome getFittestChromosome() {
        Chromosome bestChromosome = this.chromosomes.get(0);
        Iterator<Chromosome> r1 = this.chromosomes.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Chromosome chromosome = r1.next();
        if (chromosome.compareTo2(bestChromosome) <= 0) goto L4;
        bestChromosome = chromosome;
        goto L4
    L9:
        return bestChromosome;
    }

    @Override // org.apache.commons.math.genetics.Population
    public int getPopulationLimit() {
        return this.populationLimit;
    }

    public void setPopulationLimit(int populationLimit) {
        this.populationLimit = populationLimit;
    }

    @Override // org.apache.commons.math.genetics.Population
    public int getPopulationSize() {
        return this.chromosomes.size();
    }

    public String toString() {
        return this.chromosomes.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<Chromosome> iterator() {
        return this.chromosomes.iterator();
    }
}

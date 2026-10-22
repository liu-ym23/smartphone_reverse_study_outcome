package org.apache.commons.math.genetics;

/* JADX INFO: loaded from: classes3.dex */
public interface Population extends Iterable<Chromosome> {
    void addChromosome(Chromosome r1);

    Chromosome getFittestChromosome();

    int getPopulationLimit();

    int getPopulationSize();

    Population nextGeneration();
}

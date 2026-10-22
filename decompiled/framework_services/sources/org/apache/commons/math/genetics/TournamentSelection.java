package org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TournamentSelection implements SelectionPolicy {
    private int arity;

    public TournamentSelection(int arity) {
        this.arity = arity;
    }

    @Override // org.apache.commons.math.genetics.SelectionPolicy
    public ChromosomePair select(Population population) {
        return new ChromosomePair(tournament((ListPopulation) population), tournament((ListPopulation) population));
    }

    private Chromosome tournament(ListPopulation population) {
        if (population.getPopulationSize() < this.arity) goto L11;
        final int r1 = this.arity;
        ListPopulation tournamentPopulation = new AnonymousClass1(this, r1);
        List<Chromosome> chromosomes = new ArrayList(population.getChromosomes());
        int i = 0;
    L6:
        if (i >= this.arity) goto L9;
        int rind = GeneticAlgorithm.getRandomGenerator().nextInt(chromosomes.size());
        tournamentPopulation.addChromosome(chromosomes.get(rind));
        chromosomes.remove(rind);
        i = i + 1;
        goto L6
    L9:
        return tournamentPopulation.getFittestChromosome();
    L11:
        throw new IllegalArgumentException("Tournament arity cannot be bigger than population size.");
    }

    public int getArity() {
        return this.arity;
    }

    public void setArity(int arity) {
        this.arity = arity;
    }
}

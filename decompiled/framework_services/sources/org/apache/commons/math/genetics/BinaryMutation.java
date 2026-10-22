package org.apache.commons.math.genetics;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class BinaryMutation implements MutationPolicy {
    public BinaryMutation() {
    }

    @Override // org.apache.commons.math.genetics.MutationPolicy
    public Chromosome mutate(Chromosome original) {
        if ((original instanceof BinaryChromosome) == false) goto L11;
        BinaryChromosome origChrom = (BinaryChromosome) original;
        ArrayList r1 = new ArrayList(origChrom.getRepresentation());
        int geneIndex = GeneticAlgorithm.getRandomGenerator().nextInt(origChrom.getLength());
        if (origChrom.getRepresentation().get(geneIndex).intValue() != 0) goto L7;
        int r3 = 1;
    L8:
        r1.set(geneIndex, Integer.valueOf(r3));
        Chromosome newChrom = origChrom.newFixedLengthChromosome(r1);
        return newChrom;
    L7:
        r3 = 0;
        goto L8
    L11:
        throw new IllegalArgumentException("Binary mutation works on BinaryChromosome only.");
    }
}

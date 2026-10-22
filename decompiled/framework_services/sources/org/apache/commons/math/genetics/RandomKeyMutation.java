package org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class RandomKeyMutation implements MutationPolicy {
    public RandomKeyMutation() {
    }

    @Override // org.apache.commons.math.genetics.MutationPolicy
    public Chromosome mutate(Chromosome original) {
        if ((original instanceof RandomKey) == false) goto L7;
        RandomKey<?> originalRk = (RandomKey) original;
        List<?> r1 = originalRk.getRepresentation();
        int rInd = GeneticAlgorithm.getRandomGenerator().nextInt(r1.size());
        List<Double> newRepr = new ArrayList(r1);
        newRepr.set(rInd, Double.valueOf(GeneticAlgorithm.getRandomGenerator().nextDouble()));
        return originalRk.newFixedLengthChromosome(newRepr);
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.RANDOMKEY_MUTATION_WRONG_CLASS, new Object[]{original.getClass().getSimpleName()});
    }
}

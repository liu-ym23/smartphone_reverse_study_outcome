package org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RandomKey<T> extends AbstractListChromosome<Double> implements PermutationChromosome<T> {
    private final List<Integer> baseSeqPermutation;
    private final List<Double> sortedRepresentation;

    public RandomKey(List<Double> representation) {
        super(representation);
        List<Double> sortedRepr = new ArrayList(getRepresentation());
        Collections.sort(sortedRepr);
        this.sortedRepresentation = Collections.unmodifiableList(sortedRepr);
        this.baseSeqPermutation = Collections.unmodifiableList(decodeGeneric(baseSequence(getLength()), getRepresentation(), this.sortedRepresentation));
    }

    public RandomKey(Double[] representation) {
        this(Arrays.asList(representation));
    }

    @Override // org.apache.commons.math.genetics.PermutationChromosome
    public List<T> decode(List<T> sequence) {
        return decodeGeneric(sequence, getRepresentation(), this.sortedRepresentation);
    }

    private static <S> List<S> decodeGeneric(List<S> sequence, List<Double> representation, List<Double> sortedRepr) {
        int l = sequence.size();
        if (representation.size() != l) goto L14;
        if (representation.size() != sortedRepr.size()) goto L12;
        List<Double> reprCopy = new ArrayList(representation);
        List<S> res = new ArrayList(l);
        int i = 0;
    L7:
        if (i >= l) goto L10;
        int index = reprCopy.indexOf(sortedRepr.get(i));
        res.add(sequence.get(index));
        reprCopy.set(index, null);
        i = i + 1;
        goto L7
    L10:
        return res;
    L12:
        throw new IllegalArgumentException(String.format("Representation and sortedRepr must have same sizes, %d != %d", new Object[]{Integer.valueOf(representation.size()), Integer.valueOf(sortedRepr.size())}));
    L14:
        throw new IllegalArgumentException(String.format("Length of sequence for decoding (%s) has to be equal to the length of the RandomKey (%s)", new Object[]{Integer.valueOf(l), Integer.valueOf(representation.size())}));
    }

    @Override // org.apache.commons.math.genetics.Chromosome
    protected boolean isSame(Chromosome another) {
        if ((another instanceof RandomKey) == true) goto L5;
        return false;
    L5:
        RandomKey<?> anotherRk = (RandomKey) another;
        if (getLength() == anotherRk.getLength()) goto L8;
        return false;
    L8:
        List<Integer> thisPerm = this.baseSeqPermutation;
        List<Integer> anotherPerm = anotherRk.baseSeqPermutation;
        int i = 0;
    L10:
        if (i >= getLength()) goto L15;
        if (thisPerm.get(i) != anotherPerm.get(i)) goto L13;
        i = i + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    @Override // org.apache.commons.math.genetics.AbstractListChromosome
    protected void checkValidity(List<Double> chromosomeRepresentation) throws InvalidRepresentationException {
        Iterator<Double> r0 = chromosomeRepresentation.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        double val = r0.next().doubleValue();
        if (val < 0.0d) goto L11;
        if (val <= 1.0d) goto L4;
    L11:
        throw new InvalidRepresentationException("Values of representation must be in [0,1] interval");
    }

    public static final List<Double> randomPermutation(int l) {
        List<Double> repr = new ArrayList(l);
        int i = 0;
    L3:
        if (i >= l) goto L6;
        repr.add(Double.valueOf(GeneticAlgorithm.getRandomGenerator().nextDouble()));
        i = i + 1;
        goto L3
    L6:
        return repr;
    }

    public static final List<Double> identityPermutation(int l) {
        List<Double> repr = new ArrayList(l);
        int i = 0;
    L3:
        if (i >= l) goto L6;
        repr.add(Double.valueOf(((double) i) / ((double) l)));
        i = i + 1;
        goto L3
    L6:
        return repr;
    }

    public static <S> List<Double> comparatorPermutation(List<S> data, Comparator<S> comparator) {
        List<S> sortedData = new ArrayList(data);
        Collections.sort(sortedData, comparator);
        return inducedPermutation(data, sortedData);
    }

    public static <S> List<Double> inducedPermutation(List<S> originalData, List<S> permutedData) throws IllegalArgumentException {
        if (originalData.size() != permutedData.size()) goto L14;
        int l = originalData.size();
        List<S> origDataCopy = new ArrayList(originalData);
        Double[] res = new Double[l];
        int i = 0;
    L5:
        if (i >= l) goto L12;
        int index = origDataCopy.indexOf(permutedData.get(i));
        if (index == (-1)) goto L10;
        res[index] = Double.valueOf(((double) i) / ((double) l));
        origDataCopy.set(index, null);
        i = i + 1;
        goto L5
    L10:
        throw new IllegalArgumentException("originalData and permutedData must contain the same objects.");
    L12:
        return Arrays.asList(res);
    L14:
        throw new IllegalArgumentException("originalData and permutedData must have same length");
    }

    @Override // org.apache.commons.math.genetics.AbstractListChromosome
    public String toString() {
        return String.format("(f=%s pi=(%s))", new Object[]{Double.valueOf(getFitness()), this.baseSeqPermutation});
    }

    private static List<Integer> baseSequence(int l) {
        List<Integer> baseSequence = new ArrayList(l);
        int i = 0;
    L3:
        if (i >= l) goto L6;
        baseSequence.add(Integer.valueOf(i));
        i = i + 1;
        goto L3
    L6:
        return baseSequence;
    }
}

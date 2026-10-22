package org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BinaryChromosome extends AbstractListChromosome<Integer> {
    public BinaryChromosome(List<Integer> representation) {
        super(representation);
    }

    public BinaryChromosome(Integer[] representation) {
        super(representation);
    }

    @Override // org.apache.commons.math.genetics.AbstractListChromosome
    protected void checkValidity(List<Integer> chromosomeRepresentation) throws InvalidRepresentationException {
        Iterator<Integer> r0 = chromosomeRepresentation.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        int i = r0.next().intValue();
        if (i < 0) goto L11;
        if (i <= 1) goto L4;
    L11:
        throw new InvalidRepresentationException("Elements can be only 0 or 1.");
    }

    public static List<Integer> randomBinaryRepresentation(int length) {
        List<Integer> rList = new ArrayList(length);
        int j = 0;
    L3:
        if (j >= length) goto L6;
        rList.add(Integer.valueOf(GeneticAlgorithm.getRandomGenerator().nextInt(2)));
        j = j + 1;
        goto L3
    L6:
        return rList;
    }

    @Override // org.apache.commons.math.genetics.Chromosome
    protected boolean isSame(Chromosome another) {
        if ((another instanceof BinaryChromosome) == true) goto L5;
        return false;
    L5:
        BinaryChromosome anotherBc = (BinaryChromosome) another;
        if (getLength() == anotherBc.getLength()) goto L8;
        return false;
    L8:
        int i = 0;
    L10:
        if (i >= getRepresentation().size()) goto L15;
        if (getRepresentation().get(i).equals(anotherBc.getRepresentation().get(i)) == false) goto L13;
        i = i + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }
}

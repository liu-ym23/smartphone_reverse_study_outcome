package org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractListChromosome<T> extends Chromosome {
    private final List<T> representation;

    protected abstract void checkValidity(List<T> r1) throws InvalidRepresentationException;

    public abstract AbstractListChromosome<T> newFixedLengthChromosome(List<T> r1);

    public AbstractListChromosome(List<T> representation) {
        checkValidity(representation);     // Catch: InvalidRepresentationException -> L6
        this.representation = Collections.unmodifiableList(new ArrayList(representation));
        return;
    L6:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Invalid representation for %s", new Object[]{getClass().getSimpleName()}), e);
    }

    public AbstractListChromosome(T[] representation) {
        this(Arrays.asList(representation));
    }

    protected List<T> getRepresentation() {
        return this.representation;
    }

    public int getLength() {
        return getRepresentation().size();
    }

    public String toString() {
        return String.format("(f=%s %s)", new Object[]{Double.valueOf(getFitness()), getRepresentation()});
    }
}

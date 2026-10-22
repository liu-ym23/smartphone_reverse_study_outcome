package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableList<Comparator<? super T>> comparators;

    CompoundOrdering(Comparator<? super T> r1, Comparator<? super T> r2) {
        this.comparators = ImmutableList.of(r1, r2);
    }

    CompoundOrdering(Iterable<? extends Comparator<? super T>> r1) {
        this.comparators = ImmutableList.copyOf(r1);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r5, T r6) {
        int r0 = this.comparators.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        int r3 = this.comparators.get(r2).compare(r5, r6);
        if (r3 != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof CompoundOrdering) == true) goto L8;
        return false;
    L8:
        return this.comparators.equals(((CompoundOrdering) r2).comparators);
    }

    public int hashCode() {
        return this.comparators.hashCode();
    }

    public String toString() {
        return "Ordering.compound(" + this.comparators + ")";
    }
}

package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    public CompoundOrdering(Comparator<? super T> r10, Comparator<? super T> r11) {
        this.comparators = new Comparator[]{r10, r11};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r10, T r11) {
        int r12 = 0;
    L3:
        Comparator<? super T>[] r13 = this.comparators;
        if (r12 >= r13.length) goto L9;
        int r14 = r13[r12].compare(r10, r11);
        if (r14 != 0) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return r14;
    L9:
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof CompoundOrdering) == true) goto L8;
        return false;
    L8:
        return Arrays.equals(this.comparators, ((CompoundOrdering) r10).comparators);
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.comparators) + ")";
    }

    public CompoundOrdering(Iterable<? extends Comparator<? super T>> r10) {
        this.comparators = (Comparator[]) Iterables.toArray(r10, new Comparator[0]);
    }
}

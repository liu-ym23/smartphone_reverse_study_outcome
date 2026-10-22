package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> ordering;

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this;
    }

    NullsFirstOrdering(Ordering<? super T> r1) {
        this.ordering = r1;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@Nullable T r1, @Nullable T r2) {
        if (r1 != r2) goto L5;
        return 0;
    L5:
        if (r1 != null) goto L8;
        return -1;
    L8:
        if (r2 != null) goto L12;
        return 1;
    L12:
        return this.ordering.compare(r1, r2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsLast();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof NullsFirstOrdering) == true) goto L8;
        return false;
    L8:
        return this.ordering.equals(((NullsFirstOrdering) r2).ordering);
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    public String toString() {
        return this.ordering + ".nullsFirst()";
    }
}

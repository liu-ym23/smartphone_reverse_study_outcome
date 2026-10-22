package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    @MonotonicNonNullDecl
    private transient Ordering<Comparable> nullsFirst;

    @MonotonicNonNullDecl
    private transient Ordering<Comparable> nullsLast;

    static {
        INSTANCE = new NaturalOrdering();
    }

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
        return compare((Comparable) r10, (Comparable) r11);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> r10 = (Ordering<S>) this.nullsFirst;
        if (r10 != null) goto L6;
        Ordering<S> r11 = super.nullsFirst();
        this.nullsFirst = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> r10 = (Ordering<S>) this.nullsLast;
        if (r10 != null) goto L6;
        Ordering<S> r11 = super.nullsLast();
        this.nullsLast = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    public int compare(Comparable r10, Comparable r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return r10.compareTo(r11);
    }
}

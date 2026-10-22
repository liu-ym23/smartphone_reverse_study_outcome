package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
        return compare((Comparable) r1, (Comparable) r2);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterable r1) {
        return max(r1);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Object r1, Object r2) {
        return max((Comparable) r1, (Comparable) r2);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Object r1, Object r2, Object r3, Object[] r4) {
        return max((Comparable) r1, (Comparable) r2, (Comparable) r3, (Comparable[]) r4);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterator r1) {
        return max(r1);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterable r1) {
        return min(r1);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Object r1, Object r2) {
        return min((Comparable) r1, (Comparable) r2);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Object r1, Object r2, Object r3, Object[] r4) {
        return min((Comparable) r1, (Comparable) r2, (Comparable) r3, (Comparable[]) r4);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterator r1) {
        return min(r1);
    }

    static {
        INSTANCE = new ReverseNaturalOrdering();
    }

    public int compare(Comparable r1, Comparable r2) {
        Preconditions.checkNotNull(r1);
        if (r1 != r2) goto L7;
        return 0;
    L7:
        return r2.compareTo(r1);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public <E extends Comparable> E min(E r1, E r2) {
        return (E) NaturalOrdering.INSTANCE.max(r1, r2);
    }

    public <E extends Comparable> E min(E r1, E r2, E r3, E... r4) {
        return (E) NaturalOrdering.INSTANCE.max(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> r1) {
        return (E) NaturalOrdering.INSTANCE.max(r1);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> r1) {
        return (E) NaturalOrdering.INSTANCE.max(r1);
    }

    public <E extends Comparable> E max(E r1, E r2) {
        return (E) NaturalOrdering.INSTANCE.min(r1, r2);
    }

    public <E extends Comparable> E max(E r1, E r2, E r3, E... r4) {
        return (E) NaturalOrdering.INSTANCE.min(r1, r2, r3, r4);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> r1) {
        return (E) NaturalOrdering.INSTANCE.min(r1);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> r1) {
        return (E) NaturalOrdering.INSTANCE.min(r1);
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private ReverseNaturalOrdering() {
    }
}

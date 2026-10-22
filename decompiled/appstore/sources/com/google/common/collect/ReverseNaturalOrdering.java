package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new ReverseNaturalOrdering();
    }

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
        return compare((Comparable) r10, (Comparable) r11);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterable r10) {
        return max(r10);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterable r10) {
        return min(r10);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    public int compare(Comparable r10, Comparable r11) {
        Preconditions.checkNotNull(r10);
        if (r10 != r11) goto L7;
        return 0;
    L7:
        return r11.compareTo(r10);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Object r10, Object r11) {
        return max((Comparable) r10, (Comparable) r11);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Object r10, Object r11) {
        return min((Comparable) r10, (Comparable) r11);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Object r10, Object r11, Object r12, Object[] r13) {
        return max((Comparable) r10, (Comparable) r11, (Comparable) r12, (Comparable[]) r13);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Object r10, Object r11, Object r12, Object[] r13) {
        return min((Comparable) r10, (Comparable) r11, (Comparable) r12, (Comparable[]) r13);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object max(Iterator r10) {
        return max(r10);
    }

    @Override // com.google.common.collect.Ordering
    public /* bridge */ /* synthetic */ Object min(Iterator r10) {
        return min(r10);
    }

    public <E extends Comparable> E max(E r10, E r11) {
        return (E) NaturalOrdering.INSTANCE.min(r10, r11);
    }

    public <E extends Comparable> E min(E r10, E r11) {
        return (E) NaturalOrdering.INSTANCE.max(r10, r11);
    }

    public <E extends Comparable> E max(E r10, E r11, E r12, E... r13) {
        return (E) NaturalOrdering.INSTANCE.min(r10, r11, r12, r13);
    }

    public <E extends Comparable> E min(E r10, E r11, E r12, E... r13) {
        return (E) NaturalOrdering.INSTANCE.max(r10, r11, r12, r13);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> r10) {
        return (E) NaturalOrdering.INSTANCE.min(r10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> r10) {
        return (E) NaturalOrdering.INSTANCE.max(r10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> r10) {
        return (E) NaturalOrdering.INSTANCE.min(r10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> r10) {
        return (E) NaturalOrdering.INSTANCE.max(r10);
    }
}

package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> r10) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r10, T r11) {
        return this.forwardOrder.compare(r11, r10);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ReverseOrdering) == true) goto L8;
        return false;
    L8:
        return this.forwardOrder.equals(((ReverseOrdering) r10).forwardOrder);
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E r10, E r11) {
        return (E) this.forwardOrder.min(r10, r11);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E r10, E r11) {
        return (E) this.forwardOrder.max(r10, r11);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E r10, E r11, E r12, E... r13) {
        return (E) this.forwardOrder.min(r10, r11, r12, r13);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E r10, E r11, E r12, E... r13) {
        return (E) this.forwardOrder.max(r10, r11, r12, r13);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> r10) {
        return (E) this.forwardOrder.min(r10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> r10) {
        return (E) this.forwardOrder.max(r10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> r10) {
        return (E) this.forwardOrder.min(r10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> r10) {
        return (E) this.forwardOrder.max(r10);
    }
}

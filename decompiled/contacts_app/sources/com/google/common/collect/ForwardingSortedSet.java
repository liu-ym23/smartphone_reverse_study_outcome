package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract SortedSet<E> delegate();

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    protected ForwardingSortedSet() {
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(E r1) {
        return delegate().headSet(r1);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    public SortedSet<E> subSet(E r1, E r2) {
        return delegate().subSet(r1, r2);
    }

    public SortedSet<E> tailSet(E r1) {
        return delegate().tailSet(r1);
    }

    private int unsafeCompare(Object r1, Object r2) {
        Comparator<? super E> r0 = comparator();
        if (r0 != null) goto L6;
        return ((Comparable) r1).compareTo(r2);
    L6:
        return r0.compare(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardContains(@Nullable Object r3) {
        if (unsafeCompare(tailSet(r3).first(), r3) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemove(@Nullable Object r4) {
        Iterator<E> r1 = tailSet(r4).iterator();     // Catch: Throwable -> L11
        if (r1.hasNext() == false) goto L10;
        if (unsafeCompare(r1.next(), r4) != 0) goto L10;
        r1.remove();     // Catch: Throwable -> L11
        return true;
    L10:
        return false;
    }

    protected SortedSet<E> standardSubSet(E r1, E r2) {
        return tailSet(r1).headSet(r2);
    }
}

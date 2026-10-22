package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    public ForwardingSortedSet() {
    }

    private int unsafeCompare(@NullableDecl Object r10, @NullableDecl Object r11) {
        Comparator<? super E> r12 = comparator();
        if (r12 != null) goto L6;
        return ((Comparable) r10).compareTo(r11);
    L6:
        return r12.compare(r10, r11);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E r10) {
        return delegate().headSet(r10);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardContains(@NullableDecl Object r10) {
        if (unsafeCompare(tailSet(r10).first(), r10) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardRemove(@NullableDecl Object r10) {
        Iterator<E> r11 = tailSet(r10).iterator();     // Catch: Throwable -> L11
        if (r11.hasNext() == false) goto L10;
        if (unsafeCompare(r11.next(), r10) != 0) goto L10;
        r11.remove();     // Catch: Throwable -> L11
        return true;
    L10:
        return false;
    }

    @Beta
    public SortedSet<E> standardSubSet(E r10, E r11) {
        return tailSet(r10).headSet(r11);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E r10, E r11) {
        return delegate().subSet(r10, r11);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E r10) {
        return delegate().tailSet(r10);
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }
}

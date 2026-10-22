package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
final class EdgesConnecting<E> extends AbstractSet<E> {
    private final Map<?, E> nodeToOutEdge;
    private final Object targetNode;

    public EdgesConnecting(Map<?, E> r10, Object r11) {
        this.nodeToOutEdge = (Map) Preconditions.checkNotNull(r10);
        this.targetNode = Preconditions.checkNotNull(r11);
    }

    @NullableDecl
    private E getConnectingEdge() {
        return this.nodeToOutEdge.get(this.targetNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object r10) {
        E r11 = getConnectingEdge();
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.equals(r10) == false) goto L7;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (getConnectingEdge() != null) goto L5;
        return 0;
    L5:
        return 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        E r10 = getConnectingEdge();
        if (r10 != null) goto L6;
        return ImmutableSet.of().iterator();
    L6:
        return Iterators.singletonIterator(r10);
    }
}

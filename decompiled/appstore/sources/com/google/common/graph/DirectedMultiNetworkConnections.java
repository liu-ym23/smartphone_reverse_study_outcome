package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {

    @LazyInit
    private transient Reference<Multiset<N>> predecessorsReference;

    @LazyInit
    private transient Reference<Multiset<N>> successorsReference;

    private DirectedMultiNetworkConnections(Map<E, N> r10, Map<E, N> r11, int r12) {
        super(r10, r11, r12);
    }

    public static /* synthetic */ Multiset access$000(DirectedMultiNetworkConnections r10) {
        return r10.successorsMultiset();
    }

    @NullableDecl
    private static <T> T getReference(@NullableDecl Reference<T> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.get();
    }

    public static <N, E> DirectedMultiNetworkConnections<N, E> of() {
        return new DirectedMultiNetworkConnections(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    public static <N, E> DirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> r10, Map<E, N> r11, int r12) {
        return new DirectedMultiNetworkConnections(ImmutableMap.copyOf(r10), ImmutableMap.copyOf(r11), r12);
    }

    private Multiset<N> predecessorsMultiset() {
        Multiset<N> r10 = (Multiset) getReference(this.predecessorsReference);
        if (r10 != null) goto L6;
        HashMultiset r11 = HashMultiset.create(this.inEdgeMap.values());
        this.predecessorsReference = new SoftReference(r11);
        return r11;
    L6:
        return r10;
    }

    private Multiset<N> successorsMultiset() {
        Multiset<N> r10 = (Multiset) getReference(this.successorsReference);
        if (r10 != null) goto L6;
        HashMultiset r11 = HashMultiset.create(this.outEdgeMap.values());
        this.successorsReference = new SoftReference(r11);
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addInEdge(E r10, N r11, boolean r12) {
        super.addInEdge(r10, r11, r12);
        Multiset r13 = (Multiset) getReference(this.predecessorsReference);
        if (r13 == null) goto L6;
        Preconditions.checkState(r13.add(r11));
        return;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addOutEdge(E r10, N r11) {
        super.addOutEdge(r10, r11);
        Multiset r12 = (Multiset) getReference(this.successorsReference);
        if (r12 == null) goto L6;
        Preconditions.checkState(r12.add(r11));
        return;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(final N r10) {
        final Map<E, N> r11 = this.outEdgeMap;
        return new AnonymousClass1(this, r11, r10, r10);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeInEdge(E r10, boolean r11) {
        N r12 = (N) super.removeInEdge(r10, r11);
        Multiset r13 = (Multiset) getReference(this.predecessorsReference);
        if (r13 == null) goto L5;
        Preconditions.checkState(r13.remove(r12));
    L5:
        return r12;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeOutEdge(E r10) {
        N r11 = (N) super.removeOutEdge(r10);
        Multiset r12 = (Multiset) getReference(this.successorsReference);
        if (r12 == null) goto L5;
        Preconditions.checkState(r12.remove(r11));
    L5:
        return r11;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return Collections.unmodifiableSet(successorsMultiset().elementSet());
    }
}

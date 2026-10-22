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
final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {

    @LazyInit
    private transient Reference<Multiset<N>> adjacentNodesReference;

    private UndirectedMultiNetworkConnections(Map<E, N> r10) {
        super(r10);
    }

    public static /* synthetic */ Multiset access$000(UndirectedMultiNetworkConnections r10) {
        return r10.adjacentNodesMultiset();
    }

    private Multiset<N> adjacentNodesMultiset() {
        Multiset<N> r10 = (Multiset) getReference(this.adjacentNodesReference);
        if (r10 != null) goto L6;
        HashMultiset r11 = HashMultiset.create(this.incidentEdgeMap.values());
        this.adjacentNodesReference = new SoftReference(r11);
        return r11;
    L6:
        return r10;
    }

    @NullableDecl
    private static <T> T getReference(@NullableDecl Reference<T> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.get();
    }

    public static <N, E> UndirectedMultiNetworkConnections<N, E> of() {
        return new UndirectedMultiNetworkConnections(new HashMap(2, 1.0f));
    }

    public static <N, E> UndirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> r10) {
        return new UndirectedMultiNetworkConnections(ImmutableMap.copyOf(r10));
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addInEdge(E r10, N r11, boolean r12) {
        if (r12 == true) goto L5;
        addOutEdge(r10, r11);
        return;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addOutEdge(E r10, N r11) {
        super.addOutEdge(r10, r11);
        Multiset r12 = (Multiset) getReference(this.adjacentNodesReference);
        if (r12 == null) goto L6;
        Preconditions.checkState(r12.add(r11));
        return;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(final N r10) {
        final Map<E, N> r11 = this.incidentEdgeMap;
        return new AnonymousClass1(this, r11, r10, r10);
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeInEdge(E r10, boolean r11) {
        if (r11 == false) goto L4;
        return null;
    L4:
        return removeOutEdge(r10);
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeOutEdge(E r10) {
        N r11 = (N) super.removeOutEdge(r10);
        Multiset r12 = (Multiset) getReference(this.adjacentNodesReference);
        if (r12 == null) goto L5;
        Preconditions.checkState(r12.remove(r11));
    L5:
        return r11;
    }
}

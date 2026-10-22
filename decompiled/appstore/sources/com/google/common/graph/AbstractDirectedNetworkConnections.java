package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    protected final Map<E, N> inEdgeMap;
    protected final Map<E, N> outEdgeMap;
    private int selfLoopCount;

    public AbstractDirectedNetworkConnections(Map<E, N> r10, Map<E, N> r11, int r12) {
        this.inEdgeMap = (Map) Preconditions.checkNotNull(r10);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(r11);
        this.selfLoopCount = Graphs.checkNonNegative(r12);
        if (r12 <= r10.size()) goto L5;
    L7:
        boolean r13 = false;
    L8:
        Preconditions.checkState(r13);
        return;
    L5:
        if (r12 > r11.size()) goto L7;
        r13 = true;
        goto L8
    }

    public static /* synthetic */ int access$000(AbstractDirectedNetworkConnections r10) {
        return r10.selfLoopCount;
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E r10, N r11, boolean r12) {
        boolean r13 = true;
        if (r12 == false) goto L6;
        int r14 = this.selfLoopCount + 1;
        this.selfLoopCount = r14;
        Graphs.checkPositive(r14);
    L6:
        if (this.inEdgeMap.put(r10, r11) == null) goto L9;
        r13 = false;
    L9:
        Preconditions.checkState(r13);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E r10, N r11) {
        if (this.outEdgeMap.put(r10, r11) != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E r10) {
        return (N) Preconditions.checkNotNull(this.outEdgeMap.get(r10));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeInEdge(E r10, boolean r11) {
        if (r11 == false) goto L5;
        int r12 = this.selfLoopCount - 1;
        this.selfLoopCount = r12;
        Graphs.checkNonNegative(r12);
    L5:
        return (N) Preconditions.checkNotNull(this.inEdgeMap.remove(r10));
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E r10) {
        return (N) Preconditions.checkNotNull(this.outEdgeMap.remove(r10));
    }
}

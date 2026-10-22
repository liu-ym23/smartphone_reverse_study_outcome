package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    protected final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> r10) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E r10, N r11, boolean r12) {
        if (r12 == true) goto L5;
        addOutEdge(r10, r11);
        return;
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E r10, N r11) {
        if (this.incidentEdgeMap.put(r10, r11) != null) goto L5;
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
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.get(r10));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeInEdge(E r10, boolean r11) {
        if (r11 == false) goto L4;
        return null;
    L4:
        return removeOutEdge(r10);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E r10) {
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.remove(r10));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return adjacentNodes();
    }
}

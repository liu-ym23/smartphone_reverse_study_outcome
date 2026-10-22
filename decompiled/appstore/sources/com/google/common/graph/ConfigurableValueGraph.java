package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    protected long edgeCount;
    private final boolean isDirected;
    protected final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> r10) {
        this(r10, r10.nodeOrder.createMap(r10.expectedNodeCount.or(10).intValue()), 0);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N r10) {
        return checkedConnections(r10).adjacentNodes();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final GraphConnections<N, V> checkedConnections(N r10) {
        GraphConnections<N, V> r11 = this.nodeConnections.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Preconditions.checkNotNull(r10);
        throw new IllegalArgumentException("Node " + r10 + " is not an element of this graph.");
    }

    public final boolean containsNode(@NullableDecl N r10) {
        return this.nodeConnections.containsKey(r10);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    public long edgeCount() {
        return this.edgeCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(N r10, N r11, @NullableDecl V r12) {
        return (V) edgeValueOrDefault_internal(Preconditions.checkNotNull(r10), Preconditions.checkNotNull(r11), r12);
    }

    public final V edgeValueOrDefault_internal(N r10, N r11, V r12) {
        GraphConnections<N, V> r13 = this.nodeConnections.get(r10);
        if (r13 != null) goto L5;
        V r14 = null;
    L6:
        if (r14 != null) goto L9;
        return r12;
    L9:
        return r14;
    L5:
        r14 = r13.value(r11);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N r10, N r11) {
        return hasEdgeConnecting_internal(Preconditions.checkNotNull(r10), Preconditions.checkNotNull(r11));
    }

    public final boolean hasEdgeConnecting_internal(N r10, N r11) {
        GraphConnections<N, V> r12 = this.nodeConnections.get(r10);
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.successors().contains(r11) == false) goto L7;
        return true;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object r10) {
        return predecessors(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object r10) {
        return successors(r10);
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> r10, @NullableDecl V r11) {
        validateEndpoints(r10);
        return edgeValueOrDefault_internal(r10.nodeU(), r10.nodeV(), r11);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> r10) {
        Preconditions.checkNotNull(r10);
        if (isOrderingCompatible(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (hasEdgeConnecting_internal(r10.nodeU(), r10.nodeV()) == false) goto L7;
        return true;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N r10) {
        return checkedConnections(r10).predecessors();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N r10) {
        return checkedConnections(r10).successors();
    }

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> r10, Map<N, GraphConnections<N, V>> r11, long r12) {
        this.isDirected = r10.directed;
        this.allowsSelfLoops = r10.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) r10.nodeOrder.cast();
        if ((r11 instanceof TreeMap) == false) goto L5;
        MapIteratorCache<N, GraphConnections<N, V>> r13 = new MapRetrievalCache(r11);
    L6:
        this.nodeConnections = r13;
        this.edgeCount = Graphs.checkNonNegative(r12);
        return;
    L5:
        r13 = new MapIteratorCache(r11);
        goto L6
    }
}

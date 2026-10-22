package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
class ConfigurableNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    protected final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    protected final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> r10) {
        this(r10, r10.nodeOrder.createMap(r10.expectedNodeCount.or(10).intValue()), r10.edgeOrder.createMap(r10.expectedEdgeCount.or(20).intValue()));
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N r10) {
        return checkedConnections(r10).adjacentNodes();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final NetworkConnections<N, E> checkedConnections(N r10) {
        NetworkConnections<N, E> r11 = this.nodeConnections.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Preconditions.checkNotNull(r10);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[]{r10}));
    }

    public final N checkedReferenceNode(E r10) {
        N r11 = this.edgeToReferenceNode.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Preconditions.checkNotNull(r10);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[]{r10}));
    }

    public final boolean containsEdge(@NullableDecl E r10) {
        return this.edgeToReferenceNode.containsKey(r10);
    }

    public final boolean containsNode(@NullableDecl N r10) {
        return this.nodeConnections.containsKey(r10);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N r10, N r11) {
        NetworkConnections<N, E> r12 = checkedConnections(r10);
        if (this.allowsSelfLoops == true) goto L7;
        if (r10 != r11) goto L7;
        return ImmutableSet.of();
    L7:
        Preconditions.checkArgument(containsNode(r11), "Node %s is not an element of this graph.", r11);
        return r12.edgesConnecting(r11);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N r10) {
        return checkedConnections(r10).inEdges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N r10) {
        return checkedConnections(r10).incidentEdges();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E r10) {
        N r11 = checkedReferenceNode(r10);
        return EndpointPair.of(this, r11, this.nodeConnections.get(r11).adjacentNode(r10));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N r10) {
        return checkedConnections(r10).outEdges();
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

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N r10) {
        return checkedConnections(r10).predecessors();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N r10) {
        return checkedConnections(r10).successors();
    }

    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> r10, Map<N, NetworkConnections<N, E>> r11, Map<E, N> r12) {
        this.isDirected = r10.directed;
        this.allowsParallelEdges = r10.allowsParallelEdges;
        this.allowsSelfLoops = r10.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) r10.nodeOrder.cast();
        this.edgeOrder = (ElementOrder<E>) r10.edgeOrder.cast();
        if ((r11 instanceof TreeMap) == false) goto L5;
        MapIteratorCache<N, NetworkConnections<N, E>> r13 = new MapRetrievalCache(r11);
    L6:
        this.nodeConnections = r13;
        this.edgeToReferenceNode = new MapIteratorCache(r12);
        return;
    L5:
        r13 = new MapIteratorCache(r11);
        goto L6
    }
}

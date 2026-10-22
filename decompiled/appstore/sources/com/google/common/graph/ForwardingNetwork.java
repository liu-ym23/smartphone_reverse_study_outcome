package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    public ForwardingNetwork() {
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> adjacentEdges(E r10) {
        return delegate().adjacentEdges(r10);
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N r10) {
        return delegate().adjacentNodes(r10);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N r10) {
        return delegate().degree(r10);
    }

    public abstract Network<N, E> delegate();

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(N r10, N r11) {
        return delegate().edgeConnectingOrNull(r10, r11);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return delegate().edges();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N r10, N r11) {
        return delegate().edgesConnecting(r10, r11);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(N r10, N r11) {
        return delegate().hasEdgeConnecting(r10, r11);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int inDegree(N r10) {
        return delegate().inDegree(r10);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N r10) {
        return delegate().inEdges(r10);
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N r10) {
        return delegate().incidentEdges(r10);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E r10) {
        return delegate().incidentNodes(r10);
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int outDegree(N r10) {
        return delegate().outDegree(r10);
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N r10) {
        return delegate().outEdges(r10);
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

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(EndpointPair<N> r10) {
        return delegate().edgeConnectingOrNull(r10);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> r10) {
        return delegate().edgesConnecting(r10);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> r10) {
        return delegate().hasEdgeConnecting(r10);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N r10) {
        return delegate().predecessors(r10);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N r10) {
        return delegate().successors(r10);
    }
}

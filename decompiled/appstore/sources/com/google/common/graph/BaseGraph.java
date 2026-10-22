package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N r10);

    boolean allowsSelfLoops();

    int degree(N r10);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(EndpointPair<N> r10);

    boolean hasEdgeConnecting(N r10, N r11);

    int inDegree(N r10);

    Set<EndpointPair<N>> incidentEdges(N r10);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N r10);

    Set<N> predecessors(N r10);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N r10);
}

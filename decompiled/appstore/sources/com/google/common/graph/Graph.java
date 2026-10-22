package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface Graph<N> extends BaseGraph<N> {
    Set<N> adjacentNodes(N r10);

    boolean allowsSelfLoops();

    @Override // com.google.common.graph.BaseGraph
    int degree(N r10);

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> edges();

    boolean equals(@NullableDecl Object r10);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(EndpointPair<N> r10);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(N r10, N r11);

    int hashCode();

    @Override // com.google.common.graph.BaseGraph
    int inDegree(N r10);

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> incidentEdges(N r10);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    @Override // com.google.common.graph.BaseGraph
    int outDegree(N r10);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N r10);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    Set<N> successors(N r10);
}

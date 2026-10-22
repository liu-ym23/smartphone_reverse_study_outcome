package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E r10);

    Set<N> adjacentNodes(N r10);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N r10);

    @NullableDecl
    E edgeConnectingOrNull(EndpointPair<N> r10);

    @NullableDecl
    E edgeConnectingOrNull(N r10, N r11);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> r10);

    Set<E> edgesConnecting(N r10, N r11);

    boolean equals(@NullableDecl Object r10);

    boolean hasEdgeConnecting(EndpointPair<N> r10);

    boolean hasEdgeConnecting(N r10, N r11);

    int hashCode();

    int inDegree(N r10);

    Set<E> inEdges(N r10);

    Set<E> incidentEdges(N r10);

    EndpointPair<N> incidentNodes(E r10);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N r10);

    Set<E> outEdges(N r10);

    Set<N> predecessors(N r10);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N r10);
}

package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
interface NetworkConnections<N, E> {
    void addInEdge(E r10, N r11, boolean r12);

    void addOutEdge(E r10, N r11);

    N adjacentNode(E r10);

    Set<N> adjacentNodes();

    Set<E> edgesConnecting(N r10);

    Set<E> inEdges();

    Set<E> incidentEdges();

    Set<E> outEdges();

    Set<N> predecessors();

    @CanIgnoreReturnValue
    N removeInEdge(E r10, boolean r11);

    @CanIgnoreReturnValue
    N removeOutEdge(E r10);

    Set<N> successors();
}

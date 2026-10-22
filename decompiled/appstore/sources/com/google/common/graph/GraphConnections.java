package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
interface GraphConnections<N, V> {
    void addPredecessor(N r10, V r11);

    @CanIgnoreReturnValue
    V addSuccessor(N r10, V r11);

    Set<N> adjacentNodes();

    Set<N> predecessors();

    void removePredecessor(N r10);

    @CanIgnoreReturnValue
    V removeSuccessor(N r10);

    Set<N> successors();

    @NullableDecl
    V value(N r10);
}

package com.google.common.graph;

import com.google.common.base.Optional;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractGraphBuilder<N> {
    boolean allowsSelfLoops;
    final boolean directed;
    Optional<Integer> expectedNodeCount;
    ElementOrder<N> nodeOrder;

    public AbstractGraphBuilder(boolean r10) {
        this.allowsSelfLoops = false;
        this.nodeOrder = ElementOrder.insertion();
        this.expectedNodeCount = Optional.absent();
        this.directed = r10;
    }
}

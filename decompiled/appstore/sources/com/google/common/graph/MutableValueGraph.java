package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N r10);

    @CanIgnoreReturnValue
    V putEdgeValue(EndpointPair<N> r10, V r11);

    @CanIgnoreReturnValue
    V putEdgeValue(N r10, N r11, V r12);

    @CanIgnoreReturnValue
    V removeEdge(EndpointPair<N> r10);

    @CanIgnoreReturnValue
    V removeEdge(N r10, N r11);

    @CanIgnoreReturnValue
    boolean removeNode(N r10);
}

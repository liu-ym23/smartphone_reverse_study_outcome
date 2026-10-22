package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface MutableGraph<N> extends Graph<N> {
    @CanIgnoreReturnValue
    boolean addNode(N r10);

    @CanIgnoreReturnValue
    boolean putEdge(EndpointPair<N> r10);

    @CanIgnoreReturnValue
    boolean putEdge(N r10, N r11);

    @CanIgnoreReturnValue
    boolean removeEdge(EndpointPair<N> r10);

    @CanIgnoreReturnValue
    boolean removeEdge(N r10, N r11);

    @CanIgnoreReturnValue
    boolean removeNode(N r10);
}

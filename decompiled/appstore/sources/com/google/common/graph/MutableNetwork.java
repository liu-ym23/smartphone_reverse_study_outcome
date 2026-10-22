package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean addEdge(EndpointPair<N> r10, E r11);

    @CanIgnoreReturnValue
    boolean addEdge(N r10, N r11, E r12);

    @CanIgnoreReturnValue
    boolean addNode(N r10);

    @CanIgnoreReturnValue
    boolean removeEdge(E r10);

    @CanIgnoreReturnValue
    boolean removeNode(N r10);
}

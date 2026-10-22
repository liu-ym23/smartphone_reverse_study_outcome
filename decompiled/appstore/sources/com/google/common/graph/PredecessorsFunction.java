package com.google.common.graph;

import com.google.common.annotations.Beta;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface PredecessorsFunction<N> {
    Iterable<? extends N> predecessors(N r10);
}

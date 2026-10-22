package com.bytedance.android.ec.window.base.common.taskgraph.context.processor.impl;

import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<PipelineNode<?, ?>, Long> f49213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<PipelineNode<?, ?>, Long> f49214b;

    public d() {
        this.f49213a = new ConcurrentHashMap();
        this.f49214b = new ConcurrentHashMap();
    }
}

package com.bytedance.android.ec.window.base.common.taskgraph.context.processor.impl;

import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f49207a = null;

    static {
        int[] r100 = new int[NodeType.values().length];
        f49207a = r100;
        r100[NodeType.SOURCE.ordinal()] = 1;
        r100[NodeType.SINK.ordinal()] = 2;
        r100[NodeType.NORMAL.ordinal()] = 3;
        r100[NodeType.LINK.ordinal()] = 4;
        r100[NodeType.COLLECTOR.ordinal()] = 5;
    }
}

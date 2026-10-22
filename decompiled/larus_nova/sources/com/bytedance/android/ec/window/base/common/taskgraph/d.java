package com.bytedance.android.ec.window.base.common.taskgraph;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d<IN, OUT> extends eo.a<IN, OUT> {
    public d(ao.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Intrinsics.checkNotNullParameter(r101, "taskAction");
        super(r100, r101, null);
    }
}

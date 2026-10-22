package com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector;

import com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f<I, P> extends LinkerReceiverNode<P> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e<I> f49195j;

    public f(String r100, e<I> r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Intrinsics.checkNotNullParameter(r101, "collectorNode");
        super(r100, r101);
        this.f49195j = r101;
    }

    @Override // com.bytedance.android.ec.window.base.common.taskgraph.collector.staticcollector.LinkerReceiverNode
    public final Object h(ao.a r100, Continuation<? super Unit> r101) {
        I r102 = this.f49195j.h();
        if (r102 == null) goto L5;
        com.bytedance.android.ec.window.base.common.taskgraph.receiver.a r103 = new com.bytedance.android.ec.window.base.common.taskgraph.receiver.a(this.f49195j.g(), r102);
        e<I> r104 = this.f49195j;
        r104.getClass();
        Object r105 = ProcessorNode.e(r104, r103, r102, r100, r101);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r105;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}

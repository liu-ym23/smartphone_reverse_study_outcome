package com.bytedance.android.ec.window.base.common.taskgraph.collector.stub;

import com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes44.dex */
public final class TimePointProcessorNode<IN, OUT> extends ProcessorNode<IN, OUT> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<OUT> f49197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Semaphore f49198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c<IN, OUT> f49199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a<IN, OUT> f49200k;

    public TimePointProcessorNode() {
        throw null;
    }

    public final void g() {
        a<IN, OUT> r100 = this.f49200k;
        Function1<IN, OUT> r101 = new TimePointProcessorNode$begin$1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "realAction");
        r100.f49201a = r101;
        r100.f49202b.release();
    }

    public TimePointProcessorNode(c r100) {
        a<IN, OUT> r101 = new a(Dispatchers.getDefault());
        Intrinsics.checkNotNullParameter(r100, "timePointNodeId");
        Intrinsics.checkNotNullParameter(r101, "actionStub");
        super(r100, r101, null);
        this.f49199j = r100;
        this.f49200k = r101;
        this.f49197h = new AtomicReference();
        this.f49198i = new Semaphore(0);
    }
}

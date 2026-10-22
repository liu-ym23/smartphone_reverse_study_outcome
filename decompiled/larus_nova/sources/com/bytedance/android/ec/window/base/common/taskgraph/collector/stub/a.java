package com.bytedance.android.ec.window.base.common.taskgraph.collector.stub;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes44.dex */
public final class a<IN, OUT> implements Function1<IN, OUT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super IN, ? extends OUT> f49201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f49202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<OUT> f49203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineContext f49204d;

    public a(CoroutineDispatcher r100) {
        this.f49204d = r100;
        this.f49202b = new Semaphore(0);
        this.f49203c = new AtomicReference();
    }

    @Override // kotlin.jvm.functions.Function1
    public final OUT invoke(IN r100) {
        if (this.f49203c.get() != null) goto L16;
        Function1<? super IN, ? extends OUT> r101 = this.f49201a;
        if (r101 != null) goto L11;
        if (r101 != null) goto L10;
        this.f49202b.acquire();
    L10:
        r101 = this.f49201a;
    L11:
        CoroutineContext r102 = this.f49204d;
        if (r102 != null) goto L14;
        r102 = EmptyCoroutineContext.INSTANCE;
    L14:
        OUT r103 = (OUT) BuildersKt.runBlocking(r102, new ActionStub$execute$out$1(r101, r100, null));
        this.f49203c.set(r103);
        return r103;
    L16:
        return this.f49203c.get();
    }
}

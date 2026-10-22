package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ResourceDownloader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<x, d.x> f30690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f30691b;

    public static /* synthetic */ d.x lambda$8RGBLTQsojXALCUD4kE41RLyFMA() {
        return b();
    }

    public w(d.h.a.b<? super x, d.x> r3) {
        d.h.a.b<x, d.x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "callback");
        this.f30690a = r4;
        this.f30691b = new AtomicBoolean(false);
    }

    public static /* synthetic */ void a(w r1, x r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = $$Lambda$w$8RGBLTQsojXALCUD4kE41RLyFMA.INSTANCE;
    L5:
        r1.a(r2, r6);
    }

    private static final d.x b() {
        return d.x.f38692a;
    }

    public final void a(x r4, d.h.a.a<d.x> r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "result");
        d.h.b.o.e(r6, "beforeCallback");
        if (this.f30691b.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        r6.invoke();     // Catch: Throwable -> L8
        this.f30690a.invoke(r4);
        return;
    L8:
        th = move-exception;
        this.f30690a.invoke(r4);
        throw th;
    }

    public final boolean a() {
        return this.f30691b.get();
    }
}

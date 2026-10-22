package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes46.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f76894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ih0.c f76895b;

    public b0(i r100, ih0.c r101) {
        this.f76894a = r100;
        this.f76895b = r101;
    }

    public final void a() {
        this.f76894a.f77044c = System.currentTimeMillis();
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card start");
        ih0.c r100 = this.f76895b;
        if (r100 == null) goto L5;
        ih0.c.a.a(r100, null, null, 7);
    L5:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card end");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

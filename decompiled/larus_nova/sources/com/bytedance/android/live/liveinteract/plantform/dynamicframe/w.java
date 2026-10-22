package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0.c f77158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f77159b;

    public w(ih0.c r100, Map r101) {
        this.f77158a = r100;
        this.f77159b = r101;
    }

    public final void a() {
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card start");
        ih0.c r100 = this.f77158a;
        if (r100 == null) goto L5;
        ih0.c.a.a(r100, null, this.f77159b, 3);
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

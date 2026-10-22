package com.bytedance.android.livesdk.livecommerce.opt;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f149773a;

    public b(String r100) {
        this.f149773a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, com.bytedance.android.ec.core.monitor.a> r100 = com.bytedance.android.ec.core.monitor.c.f45142a;     // Catch: Throwable -> L4
        com.bytedance.android.ec.core.monitor.c.d(this.f149773a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

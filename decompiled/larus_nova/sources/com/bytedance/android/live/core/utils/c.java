package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f66120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f66121b;

    public c(Runnable r100, String r101) {
        this.f66120a = r100;
        this.f66121b = r101;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        this.f66120a.run();
        ALogger.i("AnchorMainPostOptUtils", "run " + this.f66121b + " = " + (System.currentTimeMillis() - r100));
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

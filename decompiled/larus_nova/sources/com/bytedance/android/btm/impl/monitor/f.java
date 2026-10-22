package com.bytedance.android.btm.impl.monitor;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f42206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f42207b;

    public f(Function0 r100) {
        this.f42206a = r100;
        this.f42207b = "btm_error";
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = String.valueOf(this.f42206a.invoke());     // Catch: Throwable -> L7
        BtmHostDependManager r101 = BtmHostDependManager.F;     // Catch: Throwable -> L7
        r101.getClass();     // Catch: Throwable -> L7
        zc.f r102 = (zc.f) BtmHostDependManager.f41942j.getValue(r101, BtmHostDependManager.f41933a[8]);     // Catch: Throwable -> L7
        if (r102 == null) goto L5;
        r102.e(this.f42207b, r100);     // Catch: Throwable -> L7
    L5:
        g r103 = g.f42208a;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}

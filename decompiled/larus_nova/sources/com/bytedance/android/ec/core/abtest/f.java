package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.core.utils.b2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f43641a;

    public f(g r100) {
        this.f43641a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = this.f43641a;     // Catch: Throwable -> L6
        r100.getClass();     // Catch: Throwable -> L6
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_ec_settings_preload");     // Catch: Throwable -> L6
        if (r100.f43642a == true) goto L9;
        r100.f43642a = true;     // Catch: Throwable -> L6
        b2.b(ECSettingsManager$onECSdkInit$action$1$doPreload$1.INSTANCE);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

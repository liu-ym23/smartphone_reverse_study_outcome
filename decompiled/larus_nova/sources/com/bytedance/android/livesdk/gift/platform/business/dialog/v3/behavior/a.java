package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f127118a;

    public a(HashMap r100) {
        this.f127118a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        qm0.b r100 = om0.c.g();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.sendLog("livesdk_use_behavior_analysis", this.f127118a, new Object[0]);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

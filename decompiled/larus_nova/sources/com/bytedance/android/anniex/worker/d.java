package com.bytedance.android.anniex.worker;

import android.app.Application;
import com.bytedance.ies.bullet.service.base.m0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements Runnable {
    public d(String r100, Application r101) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        s26.d r100 = s26.d.f540305c;     // Catch: Throwable -> L6
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.a0();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

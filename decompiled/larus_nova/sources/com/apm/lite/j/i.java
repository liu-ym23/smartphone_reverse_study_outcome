package com.apm.lite.j;

import com.larus.apm.impl.protector.RunnableProtector;
import r1.m;

/* JADX INFO: loaded from: classes39.dex */
public final class i implements Runnable {
    public i() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.b();     // Catch: Throwable -> L6
        if (j.a() == false) goto L9;
        a.f29922b = 40;     // Catch: Throwable -> L6
        m.a().a(a.f29921a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

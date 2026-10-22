package com.bytedance.apm.launch.evil;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {
    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

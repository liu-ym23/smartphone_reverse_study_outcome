package com.bytedance.apm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        ApmAgent.storeLogBypass("Apm#init", "Apm init");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b() {
    }
}

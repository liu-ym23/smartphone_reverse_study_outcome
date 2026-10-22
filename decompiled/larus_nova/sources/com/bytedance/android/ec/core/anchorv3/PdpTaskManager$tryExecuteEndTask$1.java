package com.bytedance.android.ec.core.anchorv3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class PdpTaskManager$tryExecuteEndTask$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpTaskManager f43796a;

    public PdpTaskManager$tryExecuteEndTask$1(PdpTaskManager r100) {
        this.f43796a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PdpTaskManager.d(this.f43796a, 4, new AnonymousClass1(this), 2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

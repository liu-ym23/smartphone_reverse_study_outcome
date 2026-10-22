package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f84889a;

    public g(f r100) {
        this.f84889a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f84889a.c(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

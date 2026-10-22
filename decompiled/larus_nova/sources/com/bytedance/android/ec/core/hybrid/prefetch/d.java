package com.bytedance.android.ec.core.hybrid.prefetch;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Job f44235a;

    public d(Job r100) {
        this.f44235a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Job.DefaultImpls.cancel$default(this.f44235a, null, 1, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

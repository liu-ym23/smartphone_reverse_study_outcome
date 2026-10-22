package com.bytedance.android.shopping.anchorv4.video.p007float;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b.C2529a f167601a;

    public b(a.b.C2529a r100) {
        this.f167601a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f167601a.f167599a.f167598d.f167593i.a(false, "pause");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

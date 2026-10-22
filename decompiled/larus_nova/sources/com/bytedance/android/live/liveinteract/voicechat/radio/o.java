package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f80578a;

    public o(p r100) {
        this.f80578a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.h(this.f80578a.f80579a);     // Catch: Throwable -> L4
        this.f80578a.f80579a.f80571d++;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

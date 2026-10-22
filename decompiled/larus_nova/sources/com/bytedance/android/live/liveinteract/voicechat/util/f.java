package com.bytedance.android.live.liveinteract.voicechat.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f80854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f80855b;

    public f(int r100, int r101) {
        this.f80854a = r100;
        this.f80855b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = j.f80863a;     // Catch: Throwable -> L4
        j.b(this.f80854a, this.f80855b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

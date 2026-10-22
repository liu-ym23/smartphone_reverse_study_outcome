package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.larus.apm.impl.protector.RunnableProtector;
import fq1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoMetrics f118125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f118126b;

    public g(ReplayVideoMetrics r100, long r101) {
        this.f118125a = r100;
        this.f118126b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f118125a.f118075b.c(j.a().J(), "watcher kit out", this.f118126b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

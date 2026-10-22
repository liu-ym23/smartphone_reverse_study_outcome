package com.bytedance.android.livesdk.chatroom.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FansRankListAnimationWidget f118772a;

    public d0(FansRankListAnimationWidget r100) {
        this.f118772a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FansRankListAnimationWidget r100 = this.f118772a;     // Catch: Throwable -> L4
        int r101 = FansRankListAnimationWidget.f118489o;     // Catch: Throwable -> L4
        r100.wq();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

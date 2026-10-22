package com.bytedance.android.livesdk.feed.drawerfeed.autoplay;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerFeedPreviewHelper.b f123721a;

    public b(DrawerFeedPreviewHelper.b r100) {
        this.f123721a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f123721a.f123714a.c();     // Catch: Throwable -> L4
        this.f123721a.f123714a.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

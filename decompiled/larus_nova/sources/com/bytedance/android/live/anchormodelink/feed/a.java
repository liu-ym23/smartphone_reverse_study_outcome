package com.bytedance.android.live.anchormodelink.feed;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorModeDynamicFeedPreview f58631a;

    public a(AnchorModeDynamicFeedPreview r100) {
        this.f58631a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnchorModeDynamicFeedPreview r100 = this.f58631a;     // Catch: Throwable -> L4
        int r101 = AnchorModeDynamicFeedPreview.f58579r;     // Catch: Throwable -> L4
        r100.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

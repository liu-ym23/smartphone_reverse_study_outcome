package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import com.bytedance.android.live.media.impl.ParentTouchScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTitleDetailWidget f64711a;

    public c(LiveTitleDetailWidget r100) {
        this.f64711a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final LiveTitleDetailWidget r100 = this.f64711a;     // Catch: Throwable -> L6
        ParentTouchScrollView r101 = r100.f64689e;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.setGetContentBottom(new LiveTitleDetailWidget$setScrollViewBottom$1(r100));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

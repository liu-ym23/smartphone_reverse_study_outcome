package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.media.impl.ParentTouchScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class t2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSLiveDetailWidget f162150a;

    public t2(VSLiveDetailWidget r100) {
        this.f162150a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final VSLiveDetailWidget r100 = this.f162150a;     // Catch: Throwable -> L6
        ParentTouchScrollView r101 = r100.f161382e;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.setGetContentBottom(new VSLiveDetailWidget$setScrollViewBottom$1(r100));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

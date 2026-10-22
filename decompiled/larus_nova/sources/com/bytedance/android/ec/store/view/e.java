package com.bytedance.android.ec.store.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopLivePlayerView f48931a;

    public e(ECShopLivePlayerView r100) {
        this.f48931a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LifecycleOwner r100 = this.f48931a.f48781i;     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        Lifecycle r101 = r100.getLifecycle();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.addObserver(this.f48931a);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}

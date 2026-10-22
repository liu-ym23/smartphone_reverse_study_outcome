package com.bytedance.android.livesdk.feed.openui.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleLiveView f124277a;

    public i(SimpleLiveView r100) {
        this.f124277a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleLiveView.b(this.f124277a, false, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

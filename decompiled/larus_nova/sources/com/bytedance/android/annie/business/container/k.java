package com.bytedance.android.annie.business.container;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f38996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f38997b;

    public k(i r100, WebView r101) {
        this.f38996a = r100;
        this.f38997b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f38996a.f(this.f38997b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

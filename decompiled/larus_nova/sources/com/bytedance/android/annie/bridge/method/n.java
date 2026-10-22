package com.bytedance.android.annie.bridge.method;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadFileMethod f38729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DownloadFileMethod.DownloadFileResModel f38730b;

    public n(DownloadFileMethod r100, DownloadFileMethod.DownloadFileResModel r101) {
        this.f38729a = r100;
        this.f38730b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f38729a.finishWithResult(this.f38730b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

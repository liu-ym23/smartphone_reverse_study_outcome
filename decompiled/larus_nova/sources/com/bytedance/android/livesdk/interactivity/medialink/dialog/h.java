package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaAnchorLinkUserListFragment f138112a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f138112a.f138037i.g();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(MediaAnchorLinkUserListFragment r100) {
        this.f138112a = r100;
    }
}

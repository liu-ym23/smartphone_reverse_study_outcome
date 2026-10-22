package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class h1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShowCountDownWidget f113411a;

    public h1(ShowCountDownWidget r100) {
        this.f113411a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ShowCountDownWidget.wq(this.f113411a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

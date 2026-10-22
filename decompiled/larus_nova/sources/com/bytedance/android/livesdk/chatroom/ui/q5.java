package com.bytedance.android.livesdk.chatroom.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class q5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraTransitionViewHolder f113910a;

    public q5(CameraTransitionViewHolder r100) {
        this.f113910a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraTransitionViewHolder r100 = this.f113910a;     // Catch: Throwable -> L4
        CameraTransitionViewHolder.State r101 = CameraTransitionViewHolder.State.IDLE;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

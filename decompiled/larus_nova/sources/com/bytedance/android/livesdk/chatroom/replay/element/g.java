package com.bytedance.android.livesdk.chatroom.replay.element;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayLoadingWidget.g f108551a;

    public g(ReplayLoadingWidget.g r100) {
        this.f108551a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReplayLoadingWidget.wq(this.f108551a.f108401a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

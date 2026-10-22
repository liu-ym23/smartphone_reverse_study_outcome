package com.bytedance.android.livesdk.chatroom.replay.element;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayLoadingWidget.b f108550a;

    public f(ReplayLoadingWidget.b r100) {
        this.f108550a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReplayLoadingWidget.Aq(this.f108550a.f108395a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

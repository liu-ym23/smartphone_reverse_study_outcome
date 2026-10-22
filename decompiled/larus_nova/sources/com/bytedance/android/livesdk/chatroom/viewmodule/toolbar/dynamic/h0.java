package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class h0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f116113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ToolbarOperateManager f116114b;

    public h0(s r100, ToolbarOperateManager r101) {
        this.f116113a = r100;
        this.f116114b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f116114b.a(this.f116113a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

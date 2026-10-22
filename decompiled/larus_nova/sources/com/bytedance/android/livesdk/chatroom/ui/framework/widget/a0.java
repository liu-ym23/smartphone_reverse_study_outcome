package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkDelegateWidget f113297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IRoom f113298b;

    public a0(LinkDelegateWidget r100, IRoom r101) {
        this.f113297a = r100;
        this.f113298b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        kc0.r r100 = this.f113297a.f113133a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.p3(this.f113298b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

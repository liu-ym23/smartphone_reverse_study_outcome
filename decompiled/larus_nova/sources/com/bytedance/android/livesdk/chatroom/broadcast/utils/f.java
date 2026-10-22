package com.bytedance.android.livesdk.chatroom.broadcast.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kc0.r;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkWidgetDelegate f105399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vc0.a f105400b;

    public f(LinkWidgetDelegate r100, vc0.a r101) {
        this.f105399a = r100;
        this.f105400b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r r100 = this.f105399a.f105380a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.q3(this.f105400b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

package com.bytedance.android.livesdk.chatroom.broadcast.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kc0.r;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkWidgetDelegate f105395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f105396b;

    public d(LinkWidgetDelegate r100, String r101) {
        this.f105395a = r100;
        this.f105396b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r r100 = this.f105395a.f105380a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onSei(this.f105396b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

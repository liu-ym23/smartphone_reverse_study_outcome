package com.bytedance.android.livesdk.chatroom.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f119249a;

    public v(u r100) {
        this.f119249a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u r100 = this.f119249a;     // Catch: Throwable -> L4
        r100.m(r100.f119202n);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

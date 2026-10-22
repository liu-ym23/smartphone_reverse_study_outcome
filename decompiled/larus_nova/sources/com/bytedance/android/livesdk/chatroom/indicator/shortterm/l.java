package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f106648a;

    public l(m r100) {
        this.f106648a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a(this.f106648a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

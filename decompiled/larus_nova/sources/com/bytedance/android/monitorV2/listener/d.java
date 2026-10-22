package com.bytedance.android.monitorV2.listener;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EventWatchTools f163124a;

    public d(EventWatchTools r100) {
        this.f163124a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EventWatchTools.a(this.f163124a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.bytedance.android.anniex.scene.handler.idle;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IdleSignalCenter.a f41196a;

    public a(IdleSignalCenter.a r100) {
        this.f41196a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IdleSignalCenter r100 = IdleSignalCenter.f41188a;     // Catch: Throwable -> L13
        IdleSignalCenter.a r101 = this.f41196a;     // Catch: Throwable -> L13
        monitor-enter(r100);     // Catch: Throwable -> L13
        if (((ArrayList) IdleSignalCenter.f41189b).remove(r101) == true) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}

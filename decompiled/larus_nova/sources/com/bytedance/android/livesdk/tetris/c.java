package com.bytedance.android.livesdk.tetris;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MoveDownMaskManager f158571a;

    public c(MoveDownMaskManager r100) {
        this.f158571a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoveDownMaskManager r100 = this.f158571a;     // Catch: Throwable -> L6
        if (r100.f158529i == false) goto L9;
        r100.c(MoveDownMaskManager.UpdateSource.GiftTrayPlayingStateChange);     // Catch: Throwable -> L6
        this.f158571a.f158529i = false;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerBlock f164989a;

    public l(PlayerBlock r100) {
        this.f164989a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f164989a.Q(100.0f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

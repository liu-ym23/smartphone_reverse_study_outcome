package com.bytedance.android.live.platformplayer.panel;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f85764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ds0.b f85765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f85766c;

    public g(o r100, ds0.b r101, View r102) {
        this.f85764a = r100;
        this.f85765b = r101;
        this.f85766c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ds0.b r100 = this.f85765b;     // Catch: Throwable -> L4
        r100.f469806c = this.f85766c.getHeight();     // Catch: Throwable -> L4
        o r101 = this.f85764a;     // Catch: Throwable -> L4
        ds0.b r102 = this.f85765b;     // Catch: Throwable -> L4
        r101.f85780d.c(r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

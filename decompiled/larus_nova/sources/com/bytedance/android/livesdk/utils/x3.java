package com.bytedance.android.livesdk.utils;

import android.view.View;
import android.view.Window;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class x3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f159206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Window f159207b;

    public x3(View r100, Window r101) {
        this.f159206a = r100;
        this.f159207b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Window r100 = this.f159207b;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.addFlags(201327616);     // Catch: Throwable -> L7
    L5:
        View r101 = this.f159206a;     // Catch: Throwable -> L7
        int r102 = r101.getSystemUiVisibility() | 4;     // Catch: Throwable -> L7
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();     // Catch: Throwable -> L7
        r101.setSystemUiVisibility(((r102 | 1024) | 2) | 512);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}

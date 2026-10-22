package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f71242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f71243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f71244c;

    public s(n r100, HSImageView r101, FrameLayout r102) {
        this.f71242a = r100;
        this.f71243b = r101;
        this.f71244c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HSImageView r100 = this.f71243b;     // Catch: Throwable -> L4
        this.f71244c.removeView(r100);     // Catch: Throwable -> L4
        this.f71242a.f71221k.a(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IconMoveAnimationTasklet f71207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f71208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f71209c;

    public k(IconMoveAnimationTasklet r100, HSImageView r101, FrameLayout r102) {
        this.f71207a = r100;
        this.f71208b = r101;
        this.f71209c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HSImageView r100 = this.f71208b;     // Catch: Throwable -> L4
        this.f71209c.removeView(r100);     // Catch: Throwable -> L4
        this.f71207a.f71131n.a(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

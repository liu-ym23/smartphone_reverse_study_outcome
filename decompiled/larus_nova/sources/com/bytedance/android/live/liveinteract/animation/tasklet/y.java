package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PathEffectAnimationTasklet f71262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HSImageView f71263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f71264c;

    public y(PathEffectAnimationTasklet r100, HSImageView r101, FrameLayout r102) {
        this.f71262a = r100;
        this.f71263b = r101;
        this.f71264c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HSImageView r100 = this.f71263b;     // Catch: Throwable -> L4
        this.f71264c.removeView(r100);     // Catch: Throwable -> L4
        this.f71262a.f71149o.a(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f139351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ZoomableControllerImp f139352b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f139352b.f139322q.removeAllUpdateListeners();
        this.f139352b.f139322q.removeAllListeners();
        Runnable r101 = this.f139351a;
        if (r101 == null) goto L6;
        r101.run();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f139352b.f139322q.removeAllUpdateListeners();
        this.f139352b.f139322q.removeAllListeners();
        Runnable r101 = this.f139351a;
        if (r101 == null) goto L6;
        r101.run();
        return;
    }

    public j(ZoomableControllerImp r100, Runnable r101) {
        this.f139352b = r100;
        this.f139351a = r101;
    }
}

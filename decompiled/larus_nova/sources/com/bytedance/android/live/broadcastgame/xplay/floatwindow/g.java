package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayFloatWindowView.ViewHolder f62158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObjectAnimator f62159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f62160c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f62161a;

        public a(g r100) {
            this.f62161a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f62161a.f62159b.start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        NoMoreSpaceTextView r101 = this.f62158a.f62098d;
        a r102 = new a(this);
        if (this.f62160c == false) goto L5;
        long r103 = 500;
    L6:
        r101.postDelayed(r102, r103);
        return;
    L5:
        r103 = 1000;
        goto L6
    }

    public g(XplayFloatWindowView.ViewHolder r100, ObjectAnimator r101, boolean r102) {
        this.f62158a = r100;
        this.f62159b = r101;
        this.f62160c = r102;
    }
}

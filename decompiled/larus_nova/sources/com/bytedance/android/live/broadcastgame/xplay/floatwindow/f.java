package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayFloatWindowView.ViewHolder f62155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f62156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f62157c;

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
        this.f62156b.invoke();
        if (this.f62157c == true) goto L6;
        this.f62155a.f62098d.setVisibility(8);
        this.f62155a.f62112r = false;
        return;
    }

    public f(XplayFloatWindowView.ViewHolder r100, Function0 r101, boolean r102) {
        this.f62155a = r100;
        this.f62156b = r101;
        this.f62157c = r102;
    }
}

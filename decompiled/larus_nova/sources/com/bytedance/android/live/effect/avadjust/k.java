package com.bytedance.android.live.effect.avadjust;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveColorAdjustFragment f66847a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public k(LiveColorAdjustFragment r100) {
        this.f66847a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        LiveColorAdjustFragment r101 = this.f66847a;
        int r102 = LiveColorAdjustFragment.f66807r;
        r101.T90();
    }
}

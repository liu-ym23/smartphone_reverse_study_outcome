package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBeautySecondLevelFragment f67721a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public p(LiveBeautySecondLevelFragment r100) {
        this.f67721a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        LiveBeautySecondLevelFragment r101 = this.f67721a;
        int r102 = LiveBeautySecondLevelFragment.C;
        r101.U90();
    }
}

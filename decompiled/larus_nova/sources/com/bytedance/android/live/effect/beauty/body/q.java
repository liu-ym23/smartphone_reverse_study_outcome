package com.bytedance.android.live.effect.beauty.body;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBodyBeautyListFragment f67210a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public q(LiveBodyBeautyListFragment r100) {
        this.f67210a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        LiveBodyBeautyListFragment r101 = this.f67210a;
        int r102 = LiveBodyBeautyListFragment.f67145y;
        r101.T90();
    }
}

package com.amap.api.maps;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes28.dex */
class a implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f28626a;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation r100) {
        this.f28626a.run();
    }

    public a(c r100, Runnable r101) {
        this.f28626a = r101;
    }
}

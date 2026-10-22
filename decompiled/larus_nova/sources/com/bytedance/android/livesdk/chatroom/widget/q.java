package com.bytedance.android.livesdk.chatroom.widget;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes8.dex */
public final class q implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownView.a f119160a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public q(CountDownView.a r100) {
        this.f119160a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f119160a.f118484e.setVisibility(8);
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f117653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f117654b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f117654b.setVisibility(8);
        this.f117653a.f117658d.invoke();
    }

    public f(g r100, View r101) {
        this.f117653a = r100;
        this.f117654b = r101;
    }
}

package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.b f113903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f113904b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        MaterialProgressDrawable.b r101 = this.f113903a;
        r101.f113858l = r101.f113851e;
        r101.f113859m = r101.f113852f;
        r101.f113860n = r101.f113853g;
        r101.b((r101.f113857k + 1) % r101.f113856j.length);
        MaterialProgressDrawable.b r102 = this.f113903a;
        r102.f113851e = r102.f113852f;
        r102.a();
        MaterialProgressDrawable r103 = this.f113904b;
        if (r103.f113845j == false) goto L7;
        r103.f113845j = false;
        r100.setDuration(1332);
        MaterialProgressDrawable.b r104 = this.f113903a;
        if (r104.f113861o == false) goto L9;
        r104.f113861o = false;
        r104.a();
        return;
    L9:
        return;
    L7:
        r103.f113842g = (r103.f113842g + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f113904b.f113842g = 0.0f;
    }

    public b(MaterialProgressDrawable r100, MaterialProgressDrawable.b r101) {
        this.f113904b = r100;
        this.f113903a = r101;
    }
}

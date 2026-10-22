package com.bytedance.android.live.uikit.refresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.c f102404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f102405b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        MaterialProgressDrawable.c r101 = this.f102404a;
        r101.f102390l = r101.f102383e;
        float r102 = r101.f102384f;
        r101.f102391m = r102;
        r101.f102392n = r101.f102385g;
        r101.f102389k = (r101.f102389k + 1) % r101.f102388j.length;
        r101.f102383e = r102;
        r101.a();
        MaterialProgressDrawable r103 = this.f102405b;
        if (r103.f102377j == false) goto L7;
        r103.f102377j = false;
        r100.setDuration(1333);
        MaterialProgressDrawable.c r104 = this.f102404a;
        if (r104.f102393o == false) goto L9;
        r104.f102393o = false;
        r104.a();
        return;
    L9:
        return;
    L7:
        r103.f102374g = (r103.f102374g + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f102405b.f102374g = 0.0f;
    }

    public b(MaterialProgressDrawable r100, MaterialProgressDrawable.c r101) {
        this.f102405b = r100;
        this.f102404a = r101;
    }
}

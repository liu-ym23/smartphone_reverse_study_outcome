package com.bytedance.android.gamecp.common.ui.pullrefresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.b f57124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f57125b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        MaterialProgressDrawable.b r101 = this.f57124a;
        r101.f57079l = r101.f57072e;
        float r102 = r101.f57073f;
        r101.f57080m = r102;
        r101.f57081n = r101.f57074g;
        int r103 = r101.f57078k + 1;
        int[] r104 = r101.f57077j;
        int r105 = r103 % r104.length;
        r101.f57078k = r105;
        r101.f57091x = r104[r105];
        r101.f57072e = r102;
        r101.a();
        MaterialProgressDrawable r106 = this.f57125b;
        if (r106.f57066i == false) goto L7;
        r106.f57066i = false;
        r100.setDuration(1332);
        MaterialProgressDrawable.b r107 = this.f57124a;
        if (r107.f57082o == false) goto L9;
        r107.f57082o = false;
        r107.a();
        return;
    L9:
        return;
    L7:
        r106.f57063f = (r106.f57063f + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f57125b.f57063f = 0.0f;
    }

    public b(MaterialProgressDrawable r100, MaterialProgressDrawable.b r101) {
        this.f57125b = r100;
        this.f57124a = r101;
    }
}

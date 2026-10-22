package com.bytedance.android.gamecp.common.ui;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f56958a;

    public a(CircularProgressView r100) {
        this.f56958a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f56958a;
        r101.f56873j = ((Float) r100.getAnimatedValue()).floatValue();
        this.f56958a.invalidate();
    }
}

package com.bytedance.android.gamecp.common.ui;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f56980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f56981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f56982c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f56982c;
        r101.f56879p = ((Float) r100.getAnimatedValue()).floatValue();
        CircularProgressView r102 = this.f56982c;
        r102.f56873j = (this.f56980a - r102.f56879p) + this.f56981b;
        r102.invalidate();
    }

    public c(CircularProgressView r100, float r101, float r102) {
        this.f56982c = r100;
        this.f56980a = r101;
        this.f56981b = r102;
    }
}

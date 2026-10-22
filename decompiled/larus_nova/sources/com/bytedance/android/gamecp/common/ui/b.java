package com.bytedance.android.gamecp.common.ui;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f56979a;

    public b(CircularProgressView r100) {
        this.f56979a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f56979a;
        r101.f56874k = ((Float) r100.getAnimatedValue()).floatValue();
    }
}

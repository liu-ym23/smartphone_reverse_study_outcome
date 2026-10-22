package com.bytedance.android.gamecp.common.ui;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f56983a;

    public d(CircularProgressView r100) {
        this.f56983a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f56983a;
        r101.f56874k = ((Float) r100.getAnimatedValue()).floatValue();
    }
}

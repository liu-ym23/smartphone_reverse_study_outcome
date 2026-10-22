package com.bytedance.android.ec.core.sku;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonMarqueeView f45323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f45324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f45325c;

    public b(CommonMarqueeView r100, View r101, View r102) {
        this.f45323a = r100;
        this.f45324b = r101;
        this.f45325c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L10;
        int r102 = ((Integer) r101).intValue();
        if (this.f45323a.f45309a == false) goto L7;
        this.f45324b.setTranslationY(-r102);
        this.f45325c.setTranslationY((this.f45324b.getHeight() + this.f45323a.f45310b) - r102);
        return;
    L7:
        this.f45324b.setTranslationX(-r102);
        this.f45325c.setTranslationX((this.f45324b.getWidth() + this.f45323a.f45310b) - r102);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}

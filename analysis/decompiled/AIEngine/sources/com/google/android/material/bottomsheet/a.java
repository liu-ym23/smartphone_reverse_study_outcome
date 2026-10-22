package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import y4.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f4712a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f4712a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        y4.g gVar = this.f4712a.f4688l;
        if (gVar != null) {
            g.c cVar = gVar.f14023b;
            if (cVar.f14052j != fFloatValue) {
                cVar.f14052j = fFloatValue;
                gVar.h = true;
                gVar.f14027j = true;
                gVar.invalidateSelf();
            }
        }
    }
}

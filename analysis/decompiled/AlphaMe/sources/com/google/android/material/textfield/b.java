package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10998a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f10999b;

    public /* synthetic */ b(o oVar, int i4) {
        this.f10998a = i4;
        this.f10999b = oVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f10998a;
        o oVar = this.f10999b;
        switch (i4) {
            case 0:
                d dVar = (d) oVar;
                dVar.getClass();
                dVar.f11060d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 1:
                d dVar2 = (d) oVar;
                dVar2.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CheckableImageButton checkableImageButton = dVar2.f11060d;
                checkableImageButton.setScaleX(fFloatValue);
                checkableImageButton.setScaleY(fFloatValue);
                break;
            default:
                k kVar = (k) oVar;
                kVar.getClass();
                kVar.f11060d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}

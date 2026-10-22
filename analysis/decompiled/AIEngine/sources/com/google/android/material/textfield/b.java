package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.internal.CheckableImageButton;
import v0.j0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5233a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5234b;

    public /* synthetic */ b(c cVar, int i10) {
        this.f5233a = i10;
        this.f5234b = cVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f5233a;
        Object obj = this.f5234b;
        switch (i10) {
            case 0:
                c cVar = (c) obj;
                cVar.getClass();
                cVar.f5289d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 1:
                c cVar2 = (c) obj;
                cVar2.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CheckableImageButton checkableImageButton = cVar2.f5289d;
                checkableImageButton.setScaleX(fFloatValue);
                checkableImageButton.setScaleY(fFloatValue);
                break;
            default:
                ((j0) obj).a();
                break;
        }
    }

    public /* synthetic */ b(j0 j0Var, View view) {
        this.f5233a = 2;
        this.f5234b = j0Var;
    }
}

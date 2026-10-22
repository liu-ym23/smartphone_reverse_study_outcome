package de;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8492a;

    public c(d dVar) {
        this.f8492a = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        d dVar = this.f8492a;
        dVar.f8498d = iIntValue;
        if (dVar.f8501g <= iIntValue) {
            dVar.f8500f = false;
            if (!dVar.f8507n && dVar.f8510q) {
                dVar.b();
            }
        }
        dVar.invalidateSelf();
    }
}

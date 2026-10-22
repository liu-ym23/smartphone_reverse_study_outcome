package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import stepos.support.v7.widget.s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2370a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2371b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2372c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        g gVar;
        int iIntValue;
        int i;
        int animatedFraction;
        switch (this.f2370a) {
            case 0:
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) this.f2372c;
                androidx.coordinatorlayout.widget.a aVar = stepOSAppBarBehavior.f2320n;
                if (aVar != null && (gVar = stepOSAppBarBehavior.f2321o) != null) {
                    stepOSAppBarBehavior.k(aVar, gVar, ((Integer) ((s0) this.f2371b).getAnimatedValue()).intValue());
                    break;
                }
                break;
            default:
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                com.stepos.common.widget.d dVar = (com.stepos.common.widget.d) this.f2372c;
                int i3 = dVar.f2668c;
                int i10 = dVar.f2669d;
                if (i3 > i10) {
                    iIntValue = (i3 - num.intValue()) / 2;
                    i = dVar.f2668c - iIntValue;
                    animatedFraction = (int) (valueAnimator.getAnimatedFraction() * dVar.f2677m);
                } else {
                    iIntValue = (i10 - num.intValue()) / 2;
                    i = dVar.f2669d - iIntValue;
                    float f5 = dVar.f2677m;
                    animatedFraction = (int) (f5 - (valueAnimator.getAnimatedFraction() * f5));
                }
                ((GradientDrawable) this.f2371b).setBounds(iIntValue + animatedFraction, animatedFraction, (i - animatedFraction) - 1, (dVar.f2678n.getHeight() - animatedFraction) - 1);
                dVar.f2681q.invalidate();
                break;
        }
    }
}

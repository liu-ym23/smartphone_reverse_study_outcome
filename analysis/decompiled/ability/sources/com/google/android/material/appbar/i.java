package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.common.widget.C1104i;
import stepos.support.v7.widget.C1978a0;

/* loaded from: classes3.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2293a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ i(int i, Object obj, Object obj2) {
        this.f2293a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppBarLayout appBarLayout;
        int iIntValue;
        int i;
        int animatedFraction;
        switch (this.f2293a) {
            case 0:
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) this.c;
                CoordinatorLayout coordinatorLayout = stepOSAppBarBehavior.n;
                if (coordinatorLayout != null && (appBarLayout = stepOSAppBarBehavior.o) != null) {
                    stepOSAppBarBehavior.e(coordinatorLayout, appBarLayout, ((Integer) ((C1978a0) this.b).getAnimatedValue()).intValue());
                    break;
                }
                break;
            default:
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                C1104i c1104i = (C1104i) this.c;
                int i6 = c1104i.c;
                int i10 = c1104i.d;
                if (i6 > i10) {
                    iIntValue = (i6 - num.intValue()) / 2;
                    i = c1104i.c - iIntValue;
                    animatedFraction = (int) (valueAnimator.getAnimatedFraction() * c1104i.m);
                } else {
                    iIntValue = (i10 - num.intValue()) / 2;
                    i = c1104i.d - iIntValue;
                    float f = c1104i.m;
                    animatedFraction = (int) (f - (valueAnimator.getAnimatedFraction() * f));
                }
                ((GradientDrawable) this.b).setBounds(iIntValue + animatedFraction, animatedFraction, (i - animatedFraction) - 1, (c1104i.n.getHeight() - animatedFraction) - 1);
                c1104i.f3807q.invalidate();
                break;
        }
    }
}

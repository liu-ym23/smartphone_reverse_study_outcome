package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.common.widget.C0490f;
import stepos.support.v7.widget.T;

/* loaded from: classes.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10328a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10329b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10330c;

    public /* synthetic */ k(int i4, Object obj, Object obj2) {
        this.f10328a = i4;
        this.f10330c = obj;
        this.f10329b = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        h hVar;
        int iIntValue;
        int i4;
        int animatedFraction;
        int i5 = this.f10328a;
        Object obj = this.f10329b;
        Object obj2 = this.f10330c;
        switch (i5) {
            case 0:
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) obj2;
                CoordinatorLayout coordinatorLayout = stepOSAppBarBehavior.f10275n;
                if (coordinatorLayout != null && (hVar = stepOSAppBarBehavior.f10276o) != null) {
                    stepOSAppBarBehavior.e(coordinatorLayout, hVar, ((Integer) ((T) obj).getAnimatedValue()).intValue());
                    break;
                }
                break;
            default:
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                C0490f c0490f = (C0490f) obj2;
                int i6 = c0490f.f11896c;
                int i7 = c0490f.f11897d;
                if (i6 > i7) {
                    iIntValue = (i6 - num.intValue()) / 2;
                    i4 = c0490f.f11896c - iIntValue;
                    animatedFraction = (int) (valueAnimator.getAnimatedFraction() * c0490f.f11906m);
                } else {
                    iIntValue = (i7 - num.intValue()) / 2;
                    i4 = c0490f.f11897d - iIntValue;
                    float f4 = c0490f.f11906m;
                    animatedFraction = (int) (f4 - (valueAnimator.getAnimatedFraction() * f4));
                }
                ((GradientDrawable) obj).setBounds(iIntValue + animatedFraction, animatedFraction, (i4 - animatedFraction) - 1, (c0490f.f11907n.getHeight() - animatedFraction) - 1);
                c0490f.f11910q.invalidate();
                break;
        }
    }
}

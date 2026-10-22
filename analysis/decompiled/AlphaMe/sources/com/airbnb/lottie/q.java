package com.airbnb.lottie;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.alphame.utils.Property;
import com.stepos.common.widget.CircularProgressButton;
import com.stepos.common.widget.StepOSRatingBar;
import java.util.Iterator;
import stepos.support.v7.widget.AbstractC0904y;
import stepos.support.v7.widget.j0;

/* loaded from: classes.dex */
public final class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4565a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4566b;

    public /* synthetic */ q(int i4, Object obj) {
        this.f4565a = i4;
        this.f4566b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i4 = this.f4565a;
        int i5 = 0;
        Object obj = this.f4566b;
        switch (i4) {
            case 0:
                v vVar = (v) obj;
                M0.c cVar = vVar.f4583j;
                if (cVar != null) {
                    cVar.o(vVar.f4576c.c());
                    return;
                }
                return;
            case 1:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                y1.j jVar = ((BottomSheetBehavior) obj).f10445i;
                if (jVar != null) {
                    y1.h hVar = jVar.f16234b;
                    if (hVar.f16213k != fFloatValue) {
                        hVar.f16213k = fFloatValue;
                        jVar.f16238f = true;
                        jVar.f16239g = true;
                        jVar.invalidateSelf();
                        return;
                    }
                    return;
                }
                return;
            case 2:
                ((TextInputLayout) obj).f10930G0.m(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            case 3:
                CircularProgressButton circularProgressButton = (CircularProgressButton) obj;
                circularProgressButton.f11469W = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                circularProgressButton.invalidate();
                return;
            case 4:
                float fIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                while (true) {
                    StepOSRatingBar stepOSRatingBar = (StepOSRatingBar) obj;
                    if (i5 >= stepOSRatingBar.getNumStars()) {
                        stepOSRatingBar.invalidate();
                        return;
                    } else {
                        stepOSRatingBar.f11817l[i5] = Math.min(Math.max(Property.DEFAULT_FLOAT_VALUE, (stepOSRatingBar.f11818m[i5] + fIntValue) - (i5 * 16.0f)), stepOSRatingBar.f11819n + stepOSRatingBar.f11820o);
                        i5++;
                    }
                }
            case 5:
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                J3.c cVar2 = (J3.c) obj;
                cVar2.f906d = iIntValue;
                if (cVar2.f909g <= iIntValue) {
                    cVar2.f908f = false;
                    if (!cVar2.f916n && cVar2.f919q) {
                        cVar2.b();
                    }
                }
                cVar2.invalidateSelf();
                return;
            case 6:
                ((AbstractC0904y) obj).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
            default:
                Iterator it = ((j0) obj).f15088a.values().iterator();
                if (it.hasNext()) {
                    B0.g.y(it.next());
                    throw null;
                }
                return;
        }
    }
}

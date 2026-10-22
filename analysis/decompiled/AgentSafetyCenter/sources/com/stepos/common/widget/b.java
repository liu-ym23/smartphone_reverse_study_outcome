package com.stepos.common.widget;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2662a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2663b;

    public /* synthetic */ b(int i) {
        this.f2662a = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2662a) {
            case 0:
                CircularProgressButton circularProgressButton = (CircularProgressButton) this.f2663b;
                circularProgressButton.f2562d0 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                circularProgressButton.invalidate();
                break;
            case 1:
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                pe.c cVar = (pe.c) this.f2663b;
                cVar.f10050d = iIntValue;
                if (cVar.f10053g <= iIntValue) {
                    cVar.f10052f = false;
                    if (!cVar.f10059n && cVar.f10062q) {
                        cVar.b();
                    }
                }
                cVar.invalidateSelf();
                break;
            default:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                f7.i iVar = ((BottomSheetBehavior) this.f2663b).i;
                if (iVar != null) {
                    f7.g gVar = iVar.f3954f;
                    if (gVar.f3944j != fFloatValue) {
                        gVar.f3944j = fFloatValue;
                        iVar.f3957j = true;
                        iVar.f3958k = true;
                        iVar.invalidateSelf();
                        break;
                    }
                }
                break;
        }
    }
}

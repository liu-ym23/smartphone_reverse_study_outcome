package J3;

import android.animation.ValueAnimator;

/* loaded from: classes2.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f899a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f900b;

    public b(c cVar, float f4) {
        this.f900b = cVar;
        this.f899a = f4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        c cVar = this.f900b;
        if (cVar.f920r) {
            cVar.f906d = iIntValue;
        }
        if (cVar.f907e >= iIntValue) {
            cVar.f908f = false;
        }
        if (cVar.f915m) {
            float f4 = this.f899a;
            int i4 = (int) (cVar.f914l * (((iIntValue / cVar.f909g) - f4) / (1.0f - f4)));
            cVar.f904b.setAlpha(i4);
            cVar.f905c.setAlpha(i4 / 2);
        }
        cVar.invalidateSelf();
    }
}

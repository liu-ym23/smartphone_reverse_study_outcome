package Sa;

import android.animation.ValueAnimator;

/* loaded from: classes4.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f1185a;
    public final /* synthetic */ c b;

    public b(c cVar, float f) {
        this.b = cVar;
        this.f1185a = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        c cVar = this.b;
        if (cVar.f1191r) {
            cVar.d = iIntValue;
        }
        if (cVar.e >= iIntValue) {
            cVar.f = false;
        }
        if (cVar.m) {
            float f = this.f1185a;
            int i = (int) (cVar.l * (((iIntValue / cVar.g) - f) / (1.0f - f)));
            cVar.b.setAlpha(i);
            cVar.c.setAlpha(i / 2);
        }
        cVar.invalidateSelf();
    }
}

package pe;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ float f10043a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ c f10044b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        c cVar = this.f10044b;
        if (cVar.f10063r) {
            cVar.f10050d = iIntValue;
        }
        if (cVar.f10051e >= iIntValue) {
            cVar.f10052f = false;
        }
        if (cVar.f10058m) {
            float f5 = this.f10043a;
            int i = (int) (cVar.f10057l * (((iIntValue / cVar.f10053g) - f5) / (1.0f - f5)));
            cVar.f10048b.setAlpha(i);
            cVar.f10049c.setAlpha(i / 2);
        }
        cVar.invalidateSelf();
    }
}

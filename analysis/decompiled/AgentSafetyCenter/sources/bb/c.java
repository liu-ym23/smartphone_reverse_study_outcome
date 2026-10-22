package bb;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ e f2050a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ float f2051b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ float f2052c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f2053d;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        e eVar = this.f2050a;
        float f5 = this.f2051b;
        float f10 = this.f2052c;
        int i = this.f2053d;
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        float fFloatValue = ((Float) animatedValue).floatValue();
        eVar.f2066l = k0.a.f(f10, f5, fFloatValue, f5);
        eVar.f2062g.setAlpha((int) ((1.0f - fFloatValue) * i));
        eVar.invalidateSelf();
    }
}

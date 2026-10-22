package bb;

import android.animation.ValueAnimator;
import n3.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2048a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2049b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.f2048a;
        Object obj = this.f2049b;
        switch (i) {
            case 0:
                e eVar = (e) obj;
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                eVar.f2066l = ((Float) animatedValue).floatValue();
                eVar.invalidateSelf();
                break;
            default:
                ((q0) obj).h();
                break;
        }
    }
}

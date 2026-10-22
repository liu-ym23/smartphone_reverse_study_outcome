package stepos.support.v7.widget;

import android.animation.ValueAnimator;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12891a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12892b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f12891a) {
            case 0:
                ((y) this.f12892b).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
            default:
                Iterator it = ((k1) this.f12892b).f12764a.values().iterator();
                if (it.hasNext()) {
                    throw androidx.activity.b.g(it);
                }
                return;
        }
    }
}

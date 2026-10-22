package stepos.support.v7.widget;

import android.animation.ValueAnimator;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class B implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6445a;
    public final /* synthetic */ Object b;

    public /* synthetic */ B(Object obj, int i) {
        this.f6445a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6445a) {
            case 0:
                ((D) this.b).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
            default:
                Iterator it = ((r0) this.b).f6628a.values().iterator();
                if (it.hasNext()) {
                    throw B7.a.f(it);
                }
                return;
        }
    }
}

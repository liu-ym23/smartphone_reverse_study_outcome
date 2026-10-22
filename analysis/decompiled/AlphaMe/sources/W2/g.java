package W2;

import android.animation.ValueAnimator;
import com.stepos.textinputlayout.TextInputLayout;

/* loaded from: classes.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f2029a;

    public g(e eVar) {
        this.f2029a = eVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        e eVar = this.f2029a;
        ((TextInputLayout) eVar.f2026a.f9664b).f12403o.e(((B0.f) eVar.f2027b.f9664b).w());
    }
}

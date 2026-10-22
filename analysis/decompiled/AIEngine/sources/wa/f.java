package wa;

import android.animation.ValueAnimator;
import com.stepos.textinputlayout.TextInputLayout;
import wa.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a.InterfaceC0162a f13651a;

    public f(e.a.InterfaceC0162a interfaceC0162a) {
        this.f13651a = interfaceC0162a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        d dVar = (d) this.f13651a;
        TextInputLayout.this.r.e(((Float) dVar.f13649b.f13650a.f13652a.getAnimatedValue()).floatValue());
    }
}

package stepos.support.v7.widget;

import android.animation.ValueAnimator;
import java.util.Iterator;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView.p f12869a;

    public x(StepOSRecyclerView.p pVar) {
        this.f12869a = pVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Iterator<StepOSRecyclerView.o> it = this.f12869a.f12629a.values().iterator();
        while (it.hasNext()) {
            it.next().getClass();
            ((Float) valueAnimator.getAnimatedValue()).getClass();
        }
    }
}

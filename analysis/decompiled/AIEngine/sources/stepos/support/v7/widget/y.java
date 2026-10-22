package stepos.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.Iterator;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class y extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView.p f12870a;

    public y(StepOSRecyclerView.p pVar) {
        this.f12870a = pVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        StepOSRecyclerView.p pVar = this.f12870a;
        pVar.f12635g = true;
        Iterator<StepOSRecyclerView.o> it = pVar.f12629a.values().iterator();
        while (it.hasNext()) {
            it.next().getClass();
            boolean z = StepOSRecyclerView.f12573t0;
        }
        boolean z3 = pVar.f12635g;
        if (z3) {
            pVar.f12633e = 3;
        }
        if (z3) {
            boolean z10 = StepOSRecyclerView.f12573t0;
        }
    }
}

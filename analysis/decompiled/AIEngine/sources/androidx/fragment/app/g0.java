package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g0 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2135a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2136b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2137c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2138d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f0 f2139e;

    public g0(f0 f0Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f2139e = f0Var;
        this.f2135a = obj;
        this.f2136b = arrayList;
        this.f2137c = obj2;
        this.f2138d = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        f0 f0Var = this.f2139e;
        Object obj = this.f2135a;
        if (obj != null) {
            f0Var.t(obj, this.f2136b, null);
        }
        Object obj2 = this.f2137c;
        if (obj2 != null) {
            f0Var.t(obj2, this.f2138d, null);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }
}

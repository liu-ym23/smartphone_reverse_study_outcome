package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i0 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3764a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3765b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3766c = null;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3767d = null;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3768e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3769f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f3770g;

    public i0(k0 k0Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f3770g = k0Var;
        this.f3764a = obj;
        this.f3765b = arrayList;
        this.f3768e = obj2;
        this.f3769f = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        k0 k0Var = this.f3770g;
        Object obj = this.f3764a;
        if (obj != null) {
            k0Var.t(obj, this.f3765b, null);
        }
        Object obj2 = this.f3766c;
        if (obj2 != null) {
            k0Var.t(obj2, this.f3767d, null);
        }
        Object obj3 = this.f3768e;
        if (obj3 != null) {
            k0Var.t(obj3, this.f3769f, null);
        }
    }
}

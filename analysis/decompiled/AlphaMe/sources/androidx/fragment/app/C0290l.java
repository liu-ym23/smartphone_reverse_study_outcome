package androidx.fragment.app;

import android.transition.Transition;

/* renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0290l extends AbstractC0289k {

    /* renamed from: c, reason: collision with root package name */
    public final Object f3777c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3778d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f3779e;

    public C0290l(q0 q0Var, G.c cVar, boolean z4, boolean z5) {
        super(q0Var, cVar);
        int i4 = q0Var.f3801a;
        D d4 = q0Var.f3803c;
        if (i4 == 2) {
            this.f3777c = z4 ? d4.getReenterTransition() : d4.getEnterTransition();
            this.f3778d = z4 ? d4.getAllowReturnTransitionOverlap() : d4.getAllowEnterTransitionOverlap();
        } else {
            this.f3777c = z4 ? d4.getReturnTransition() : d4.getExitTransition();
            this.f3778d = true;
        }
        if (!z5) {
            this.f3779e = null;
        } else if (z4) {
            this.f3779e = d4.getSharedElementReturnTransition();
        } else {
            this.f3779e = d4.getSharedElementEnterTransition();
        }
    }

    public final m0 c(Object obj) {
        if (obj == null) {
            return null;
        }
        k0 k0Var = f0.f3749a;
        if (obj instanceof Transition) {
            return k0Var;
        }
        m0 m0Var = f0.f3750b;
        if (m0Var != null && m0Var.e(obj)) {
            return m0Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f3775a.f3803c + " is not a valid framework Transition or AndroidX Transition");
    }
}

package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g0 implements o {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f2269a;

    public g0(k0 k0Var) {
        this.f2269a = k0Var;
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            qVar.getLifecycle().c(this);
            this.f2269a.b();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}

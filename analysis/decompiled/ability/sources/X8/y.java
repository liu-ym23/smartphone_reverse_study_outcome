package X8;

import java.util.List;

/* loaded from: classes4.dex */
public final class y extends w {
    public final W8.l b;
    public final S7.a c;
    public final W8.h d;

    public y(W8.l storageManager, S7.a aVar) {
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        this.b = storageManager;
        this.c = aVar;
        this.d = new W8.h((W8.i) storageManager, aVar);
    }

    @Override // X8.w
    public final List L() {
        return f0().L();
    }

    @Override // X8.w
    public final H M() {
        return f0().M();
    }

    @Override // X8.w
    public final K Q() {
        return f0().Q();
    }

    @Override // X8.w
    public final boolean W() {
        return f0().W();
    }

    @Override // X8.w
    /* renamed from: Y */
    public final w j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new y(this.b, new J4.e(4, kotlinTypeRefiner, this));
    }

    @Override // X8.w
    public final U Z() {
        w wVarF0 = f0();
        while (wVarF0 instanceof y) {
            wVarF0 = ((y) wVarF0).f0();
        }
        kotlin.jvm.internal.k.d(wVarF0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (U) wVarF0;
    }

    public final w f0() {
        return (w) this.d.invoke();
    }

    public final String toString() {
        return this.d.b() ? f0().toString() : "<Not computed yet>";
    }

    @Override // X8.w
    public final Q8.o w() {
        return f0().w();
    }
}

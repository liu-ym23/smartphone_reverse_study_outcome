package androidx.lifecycle;

import androidx.lifecycle.AbstractC0533m;

/* loaded from: classes.dex */
public final class K implements InterfaceC0537q {

    /* renamed from: a, reason: collision with root package name */
    private final N f10819a;

    public K(N n5) {
        j4.k.g(n5, "provider");
        this.f10819a = n5;
    }

    @Override // androidx.lifecycle.InterfaceC0537q
    public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        j4.k.g(interfaceC0539t, "source");
        j4.k.g(aVar, "event");
        if (aVar == AbstractC0533m.a.ON_CREATE) {
            interfaceC0539t.getLifecycle().d(this);
            this.f10819a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}

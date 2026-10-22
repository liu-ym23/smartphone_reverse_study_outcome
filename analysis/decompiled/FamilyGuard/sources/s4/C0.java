package s4;

import V3.n;

/* loaded from: classes.dex */
final class C0<T> extends t0 {

    /* renamed from: e, reason: collision with root package name */
    private final C1082l<T> f20293e;

    /* JADX WARN: Multi-variable type inference failed */
    public C0(C1082l<? super T> c1082l) {
        this.f20293e = c1082l;
    }

    @Override // s4.InterfaceC1081k0
    public void a(Throwable th) {
        Object objB0 = v().b0();
        if (objB0 instanceof C1096y) {
            C1082l<T> c1082l = this.f20293e;
            n.a aVar = V3.n.f5531a;
            c1082l.resumeWith(V3.n.a(V3.o.a(((C1096y) objB0).f20398a)));
        } else {
            C1082l<T> c1082l2 = this.f20293e;
            n.a aVar2 = V3.n.f5531a;
            c1082l2.resumeWith(V3.n.a(v0.h(objB0)));
        }
    }
}

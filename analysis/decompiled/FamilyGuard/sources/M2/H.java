package M2;

import L2.j;
import i4.InterfaceC0772l;

/* loaded from: classes.dex */
final class H implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final j.c f4016a;

    public H(j.c cVar) {
        j4.k.g(cVar, "token");
        this.f4016a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(C0378o c0378o, j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.x0(c0378o.h());
        aVar.H0(c0378o.i());
        aVar.V(c0378o.g() ? 3 : 2);
        aVar.U(c0378o.e());
        aVar.m0(c0378o.f());
        aVar.I0(c0378o.j());
        if (c0378o instanceof C) {
            C c6 = (C) c0378o;
            aVar.X(c6.s().d());
            aVar.Y(c6.u());
            aVar.d0(c6.w());
            aVar.a0(c6.v());
            aVar.Z(c6.t());
            aVar.b0(c6.r());
            aVar.c0(C0376m.b(c6));
        } else {
            aVar.X(0);
            aVar.Y(0.0f);
            aVar.d0(0);
            aVar.a0(0);
            aVar.Z(0);
            aVar.b0(0.5f);
            aVar.c0(0);
        }
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        j.c.d(this.f4016a, null, 1, null);
    }

    public void c(K2.E e6) {
        j4.k.g(e6, "params");
        final C0378o c0378o = e6 instanceof C0378o ? (C0378o) e6 : null;
        if (c0378o == null) {
            return;
        }
        this.f4016a.b(new InterfaceC0772l() { // from class: M2.G
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return H.d(c0378o, (j.a) obj);
            }
        });
    }
}

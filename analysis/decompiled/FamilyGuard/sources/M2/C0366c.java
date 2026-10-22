package M2;

import L2.j;
import i4.InterfaceC0772l;

/* renamed from: M2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0366c implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final j.c f4060a;

    public C0366c(j.c cVar) {
        j4.k.g(cVar, "token");
        this.f4060a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.o0(false);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(M m5, j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.o0(m5.f());
        aVar.n0(m5.e());
        aVar.s0(m5.j());
        aVar.q0(m5.h());
        aVar.r0(m5.i());
        aVar.p0(m5.g());
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4060a.c(new InterfaceC0772l() { // from class: M2.a
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0366c.d((j.a) obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        final M m5 = e6 instanceof M ? (M) e6 : null;
        if (m5 == null) {
            return;
        }
        this.f4060a.b(new InterfaceC0772l() { // from class: M2.b
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0366c.f(m5, (j.a) obj);
            }
        });
    }
}

package M2;

import L2.j;
import W3.C0403n;
import i4.InterfaceC0772l;

/* loaded from: classes.dex */
final class F implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final j.c f4014a;

    public F(j.c cVar) {
        j4.k.g(cVar, "token");
        this.f4014a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.W(C0403n.h());
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(C0374k c0374k, j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.W(C0403n.R(c0374k.e(), 4));
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4014a.c(new InterfaceC0772l() { // from class: M2.E
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return F.d((j.a) obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        final C0374k c0374k = e6 instanceof C0374k ? (C0374k) e6 : null;
        if (c0374k == null) {
            return;
        }
        this.f4014a.b(new InterfaceC0772l() { // from class: M2.D
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return F.f(c0374k, (j.a) obj);
            }
        });
    }
}

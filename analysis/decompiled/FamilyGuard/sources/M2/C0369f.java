package M2;

import L2.j;
import i4.InterfaceC0772l;

/* renamed from: M2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0369f implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final j.c f4062a;

    public C0369f(j.c cVar) {
        j4.k.g(cVar, "token");
        this.f4062a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.y0(false);
        aVar.j0(0.0f);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(T t5, j.a aVar) {
        j4.k.g(aVar, "c");
        aVar.y0(t5.g());
        aVar.z0(S.c(t5.h()));
        aVar.A0(S.d(t5.i()));
        aVar.j0(t5.f());
        aVar.i0(t5.e());
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4062a.c(new InterfaceC0772l() { // from class: M2.e
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0369f.d((j.a) obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        final T t5 = e6 instanceof T ? (T) e6 : null;
        if (t5 == null) {
            return;
        }
        this.f4062a.b(new InterfaceC0772l() { // from class: M2.d
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0369f.f(t5, (j.a) obj);
            }
        });
    }
}

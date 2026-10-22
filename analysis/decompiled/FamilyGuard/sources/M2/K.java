package M2;

import L2.e;
import i4.InterfaceC0772l;

/* loaded from: classes.dex */
final class K implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final e.c f4018a;

    public K(e.c cVar) {
        j4.k.g(cVar, "token");
        this.f4018a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(Object obj) {
        j4.k.g(obj, "d");
        L2.e eVar = L2.e.f3817a;
        Class<?>[] clsArr = {eVar.j(), eVar.l(), eVar.k(), eVar.k(), eVar.k(), eVar.k()};
        Boolean bool = Boolean.FALSE;
        Float fValueOf = Float.valueOf(0.0f);
        eVar.g(obj, "setInnerShadow", clsArr, bool, 0, fValueOf, fValueOf, fValueOf, fValueOf);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(M m5, Object obj) {
        j4.k.g(obj, "d");
        L2.e eVar = L2.e.f3817a;
        eVar.g(obj, "setInnerShadow", new Class[]{eVar.j(), eVar.l(), eVar.k(), eVar.k(), eVar.k(), eVar.k()}, Boolean.valueOf(m5.f()), Integer.valueOf(m5.e()), Float.valueOf(m5.j()), Float.valueOf(m5.h()), Float.valueOf(m5.i()), Float.valueOf(m5.g()));
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4018a.c(new InterfaceC0772l() { // from class: M2.I
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return K.d(obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        final M m5 = e6 instanceof M ? (M) e6 : null;
        if (m5 == null) {
            return;
        }
        this.f4018a.b(new InterfaceC0772l() { // from class: M2.J
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return K.f(m5, obj);
            }
        });
    }
}

package M2;

import L2.e;
import i4.InterfaceC0772l;

/* loaded from: classes.dex */
final class P implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final e.c f4027a;

    public P(e.c cVar) {
        j4.k.g(cVar, "token");
        this.f4027a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(Object obj) {
        j4.k.g(obj, "d");
        L2.e eVar = L2.e.f3817a;
        Class<?>[] clsArr = {eVar.j(), eVar.k(), eVar.k()};
        Boolean bool = Boolean.FALSE;
        Float fValueOf = Float.valueOf(0.0f);
        eVar.g(obj, "setRefraction", clsArr, bool, fValueOf, fValueOf);
        eVar.g(obj, "setDispersion", new Class[]{eVar.k()}, fValueOf);
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v f(T t5, Object obj) {
        j4.k.g(obj, "d");
        L2.e eVar = L2.e.f3817a;
        eVar.g(obj, "setRefraction", new Class[]{eVar.j(), eVar.k(), eVar.k()}, Boolean.valueOf(t5.g()), Float.valueOf(S.c(t5.h())), Float.valueOf(S.d(t5.i())));
        eVar.g(obj, "setRefractionDepth", new Class[]{eVar.k()}, Float.valueOf(t5.e()));
        eVar.g(obj, "setDispersion", new Class[]{eVar.k()}, Float.valueOf(t5.f()));
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        this.f4027a.c(new InterfaceC0772l() { // from class: M2.N
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return P.d(obj);
            }
        });
    }

    public void e(K2.E e6) {
        j4.k.g(e6, "params");
        final T t5 = e6 instanceof T ? (T) e6 : null;
        if (t5 == null) {
            return;
        }
        this.f4027a.b(new InterfaceC0772l() { // from class: M2.O
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return P.f(t5, obj);
            }
        });
    }
}

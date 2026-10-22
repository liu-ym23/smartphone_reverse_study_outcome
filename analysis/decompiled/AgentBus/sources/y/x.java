package y;

/* loaded from: classes.dex */
public final class x extends q7.m implements p7.o {

    /* renamed from: g, reason: collision with root package name */
    public static final x f11536g = new x(3);

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        i1.m0 m0Var = (i1.m0) obj;
        long j2 = ((d2.a) obj3).f2778a;
        int iY = m0Var.y(y.f11537a);
        int i2 = iY * 2;
        g1.s sVarB = ((g1.o) obj2).b(d2.b.h(j2, 0, i2));
        int i10 = sVarB.f3757g - i2;
        return m0Var.l0(sVarB.f3756f, i10, d7.a0.f2944f, new w(sVarB, iY));
    }
}

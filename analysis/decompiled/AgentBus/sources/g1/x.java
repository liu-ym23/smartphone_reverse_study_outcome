package g1;

import i1.l0;
import i1.m0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class x extends i1.c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x f3770a = new x();

    @Override // g1.p
    public final l0 b(m0 m0Var, List list, long j2) {
        int size = list.size();
        d7.a0 a0Var = d7.a0.f2944f;
        if (size == 0) {
            return m0Var.l0(d2.a.j(j2), d2.a.i(j2), a0Var, t.f3762i);
        }
        if (size == 1) {
            s sVarB = ((o) list.get(0)).b(j2);
            return m0Var.l0(d2.b.f(sVarB.f3756f, j2), d2.b.e(sVarB.f3757g, j2), a0Var, new v(sVarB, 0));
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            s sVarB2 = ((o) list.get(i2)).b(j2);
            iMax = Math.max(sVarB2.f3756f, iMax);
            iMax2 = Math.max(sVarB2.f3757g, iMax2);
            arrayList.add(sVarB2);
        }
        return m0Var.l0(d2.b.f(iMax, j2), d2.b.e(iMax2, j2), a0Var, new w(0, arrayList));
    }
}

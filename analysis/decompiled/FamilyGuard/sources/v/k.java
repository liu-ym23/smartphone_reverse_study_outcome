package v;

import v.e;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f23199a = new boolean[3];

    static void a(f fVar, s.d dVar, e eVar) {
        eVar.f23094t = -1;
        eVar.f23096u = -1;
        e.b bVar = fVar.f23055Z[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.f23055Z[0] == e.b.MATCH_PARENT) {
            int i5 = eVar.f23044O.f23005g;
            int iW = fVar.W() - eVar.f23046Q.f23005g;
            d dVar2 = eVar.f23044O;
            dVar2.f23007i = dVar.q(dVar2);
            d dVar3 = eVar.f23046Q;
            dVar3.f23007i = dVar.q(dVar3);
            dVar.f(eVar.f23044O.f23007i, i5);
            dVar.f(eVar.f23046Q.f23007i, iW);
            eVar.f23094t = 2;
            eVar.O0(i5, iW);
        }
        if (fVar.f23055Z[1] == bVar2 || eVar.f23055Z[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i6 = eVar.f23045P.f23005g;
        int iX = fVar.x() - eVar.f23047R.f23005g;
        d dVar4 = eVar.f23045P;
        dVar4.f23007i = dVar.q(dVar4);
        d dVar5 = eVar.f23047R;
        dVar5.f23007i = dVar.q(dVar5);
        dVar.f(eVar.f23045P.f23007i, i6);
        dVar.f(eVar.f23047R.f23007i, iX);
        if (eVar.f23079l0 > 0 || eVar.V() == 8) {
            d dVar6 = eVar.f23048S;
            dVar6.f23007i = dVar.q(dVar6);
            dVar.f(eVar.f23048S.f23007i, eVar.f23079l0 + i6);
        }
        eVar.f23096u = 2;
        eVar.f1(i6, iX);
    }

    public static final boolean b(int i5, int i6) {
        return (i5 & i6) == i6;
    }
}

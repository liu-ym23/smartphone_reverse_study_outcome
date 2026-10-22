package h1;

import i1.a1;
import i1.f0;
import i1.j;
import i1.k;
import i1.u1;
import n0.l;

/* loaded from: classes.dex */
public interface d extends e, j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [h1.d, i1.j] */
    /* JADX WARN: Type inference failed for: r8v3, types: [p7.a, q7.m] */
    @Override // h1.e
    default Object a(f fVar) {
        a1 a1Var;
        l lVar = (l) this;
        if (!lVar.f6797f.f6810s) {
            f1.a.a("ModifierLocal accessed from an unattached node");
        }
        if (!lVar.f6797f.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        l lVar2 = lVar.f6797f.f6801j;
        f0 f0VarU = i1.l.u(this);
        while (f0VarU != null) {
            if ((((l) f0VarU.H.f4404j).f6800i & 32) != 0) {
                while (lVar2 != null) {
                    if ((lVar2.f6799h & 32) != 0) {
                        k kVarE = lVar2;
                        ?? eVar = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof d) {
                                d dVar = (d) kVarE;
                                if (dVar.h().j(fVar)) {
                                    return dVar.h().s(fVar);
                                }
                            } else if ((kVarE.f6799h & 32) != 0 && (kVarE instanceof k)) {
                                l lVar3 = kVarE.f4514u;
                                int i2 = 0;
                                kVarE = kVarE;
                                eVar = eVar;
                                while (lVar3 != null) {
                                    if ((lVar3.f6799h & 32) != 0) {
                                        i2++;
                                        eVar = eVar;
                                        if (i2 == 1) {
                                            kVarE = lVar3;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new d0.e(new l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar.b(lVar3);
                                        }
                                    }
                                    lVar3 = lVar3.f6802k;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                }
                                if (i2 == 1) {
                                }
                            }
                            kVarE = i1.l.e(eVar);
                        }
                    }
                    lVar2 = lVar2.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar2 = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
        return fVar.f4073a.c();
    }

    default s7.a h() {
        return b.f4066b;
    }
}

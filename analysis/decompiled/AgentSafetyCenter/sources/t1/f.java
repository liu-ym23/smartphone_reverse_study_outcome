package t1;

import u1.c1;
import u1.g0;
import u1.l;
import u1.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface f extends h, l {
    default e R() {
        return b.f13127b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [t1.f, u1.l] */
    /* JADX WARN: Type inference failed for: r8v3, types: [xb.a, yb.l] */
    @Override // t1.h
    default Object d(i iVar) {
        c1 c1Var;
        w0.l lVar = (w0.l) this;
        if (!lVar.f15114c.f15126r) {
            r1.a.a("ModifierLocal accessed from an unattached node");
        }
        if (!lVar.f15114c.f15126r) {
            r1.a.b("visitAncestors called on an unattached node");
        }
        w0.l lVar2 = lVar.f15114c.i;
        g0 g0VarU = u1.f.u(this);
        while (g0VarU != null) {
            if ((g0VarU.H.f13746f.f15117h & 32) != 0) {
                while (lVar2 != null) {
                    if ((lVar2.f15116g & 32) != 0) {
                        m mVarE = lVar2;
                        ?? eVar = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof f) {
                                f fVar = (f) mVarE;
                                if (fVar.R().d(iVar)) {
                                    return fVar.R().h(iVar);
                                }
                            } else if ((mVarE.f15116g & 32) != 0 && (mVarE instanceof m)) {
                                w0.l lVar3 = mVarE.f13866t;
                                int i = 0;
                                mVarE = mVarE;
                                eVar = eVar;
                                while (lVar3 != null) {
                                    if ((lVar3.f15116g & 32) != 0) {
                                        i++;
                                        eVar = eVar;
                                        if (i == 1) {
                                            mVarE = lVar3;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar.b(lVar3);
                                        }
                                    }
                                    lVar3 = lVar3.f15118j;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                }
                                if (i == 1) {
                                }
                            }
                            mVarE = u1.f.e(eVar);
                        }
                    }
                    lVar2 = lVar2.i;
                }
            }
            g0VarU = g0VarU.t();
            lVar2 = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
        }
        return iVar.f13135a.invoke();
    }
}

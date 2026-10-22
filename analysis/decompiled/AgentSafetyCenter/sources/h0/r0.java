package h0;

import k0.s2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class r0 {
    static {
        new s2(a0.f4908k);
    }

    public static final void a(z zVar, l1 l1Var, v1 v1Var, s0.c cVar, k0.s sVar, int i) {
        l1 l1Var2;
        l1 l1Var3;
        sVar.Z(-2127166334);
        if (((i | (sVar.f(zVar) ? 4 : 2) | 16) & 1171) == 1170 && sVar.B()) {
            sVar.S();
            l1Var3 = l1Var;
        } else {
            sVar.U();
            if ((i & 1) == 0 || sVar.z()) {
                l1Var2 = (l1) sVar.j(m1.f5070a);
            } else {
                sVar.S();
                l1Var2 = l1Var;
            }
            sVar.r();
            t.n0 n0VarA = c1.a(sVar);
            long j10 = zVar.f5244a;
            boolean zE = sVar.e(j10);
            Object objM = sVar.M();
            if (zE || objM == k0.m.f6974a) {
                objM = new d0.c(j10, d1.p.c(0.4f, j10));
                sVar.i0(objM);
            }
            k0.z.b(new k0.t1[]{b0.f4919a.a(zVar), androidx.compose.foundation.c.f862a.a(n0VarA), g0.t.f4187a.a(c0.f4927a), m1.f5070a.a(l1Var2), d0.d.f2952a.a((d0.c) objM), w1.f5235a.a(v1Var)}, s0.h.d(-1066563262, new k(2, v1Var, cVar), sVar), sVar, 56);
            l1Var3 = l1Var2;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new q0(zVar, l1Var3, v1Var, cVar, i, 0);
        }
    }
}

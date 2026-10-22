package s1;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;
import k0.v1;
import u1.g1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f11317a = new i0(4);

    public static final o a(String str) {
        o oVar = new o(1);
        oVar.f11276f = str;
        oVar.f11272b = new n(1, null);
        oVar.f11273c = new n(0, null);
        oVar.f11274d = new n(1, null);
        oVar.f11275e = new n(0, null);
        VarHandle.storeStoreFence();
        return oVar;
    }

    public static final void b(y0 y0Var, w0.m mVar, xb.p pVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-511989831);
        if ((i & 6) == 0) {
            i3 = (sVar.h(y0Var) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.f(mVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.h(pVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if (sVar.P(i3 & 1, (i3 & 147) != 146)) {
            int iHashCode = Long.hashCode(sVar.T);
            k0.p pVarY = k0.z.y(sVar);
            w0.m mVarM = t.o.m(sVar, mVar);
            s0.g gVarL = sVar.l();
            sVar.b0();
            if (sVar.S) {
                sVar.k(u1.z.f13976c);
            } else {
                sVar.l0();
            }
            k0.z.B(y0Var, sVar, y0Var.f11333c);
            k0.z.B(pVarY, sVar, y0Var.f11334d);
            k0.z.B(pVar, sVar, y0Var.f11335e);
            u1.j.f13840e.getClass();
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            sVar.q(true);
            if (sVar.B()) {
                sVar.X(-1259216055);
                sVar.q(false);
            } else {
                sVar.X(-1259274676);
                boolean zH = sVar.h(y0Var);
                Object objM = sVar.M();
                if (zH || objM == k0.m.f6974a) {
                    objM = new ad.l(y0Var, 21);
                    sVar.i0(objM);
                }
                k0.z.j((xb.a) objM, sVar);
                sVar.q(false);
            }
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.u(y0Var, mVar, pVar, i, 1);
        }
    }

    public static final void c(w0.m mVar, xb.p pVar, k0.s sVar, int i, int i3) {
        int i10;
        sVar.Z(-1298353104);
        int i11 = i3 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (sVar.f(mVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= sVar.h(pVar) ? 32 : 16;
        }
        if (sVar.P(i10 & 1, (i10 & 19) != 18)) {
            if (i11 != 0) {
                mVar = w0.j.f15113c;
            }
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = new y0(i0.f11258f);
                sVar.i0(objM);
            }
            b((y0) objM, mVar, pVar, sVar, (i10 << 3) & 1008);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new u0(mVar, pVar, i, i3);
        }
    }

    public static final float d(long j10, long j11) {
        return Math.min(Float.intBitsToFloat((int) (j11 >> 32)) / Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j11 & 4294967295L)) / Float.intBitsToFloat((int) (j10 & 4294967295L)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float e(s1.n0 r6, boolean r7, s1.n[] r8, float r9) {
        /*
            int r0 = r8.length
            r1 = 2143289344(0x7fc00000, float:NaN)
            r2 = 0
            r3 = r2
        L5:
            if (r3 >= r0) goto L20
            r4 = r8[r3]
            float r4 = r6.c(r4)
            boolean r5 = java.lang.Float.isNaN(r1)
            if (r5 != 0) goto L1c
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 <= 0) goto L19
            r5 = 1
            goto L1a
        L19:
            r5 = r2
        L1a:
            if (r7 != r5) goto L1d
        L1c:
            r1 = r4
        L1d:
            int r3 = r3 + 1
            goto L5
        L20:
            boolean r6 = java.lang.Float.isNaN(r1)
            if (r6 == 0) goto L27
            return r9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.v0.e(s1.n0, boolean, s1.n[], float):float");
    }

    public static final c1.c f(q qVar) {
        q qVarW = qVar.w();
        return qVarW != null ? qVarW.g(qVar, true) : new c1.c(0.0f, 0.0f, (int) (qVar.l() >> 32), (int) (qVar.l() & 4294967295L));
    }

    public static final c1.c g(g1 g1Var) {
        q qVarI = i(g1Var);
        float fL = (int) (qVarI.l() >> 32);
        float fL2 = (int) (qVarI.l() & 4294967295L);
        c1.c cVarG = qVarI.g(g1Var, true);
        float f5 = cVarG.f2167a;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > fL) {
            f5 = fL;
        }
        float f10 = cVarG.f2168b;
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > fL2) {
            f10 = fL2;
        }
        float f11 = cVarG.f2169c;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 <= fL) {
            fL = f11;
        }
        float f12 = cVarG.f2170d;
        float f13 = f12 >= 0.0f ? f12 : 0.0f;
        if (f13 <= fL2) {
            fL2 = f13;
        }
        if (f5 == fL || f10 == fL2) {
            return c1.c.f2166e;
        }
        long jC = qVarI.c((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f10) & 4294967295L));
        long jC2 = qVarI.c((Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(fL) << 32));
        long jC3 = qVarI.c((Float.floatToRawIntBits(fL) << 32) | (Float.floatToRawIntBits(fL2) & 4294967295L));
        long jC4 = qVarI.c((Float.floatToRawIntBits(fL2) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jC >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jC2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jC4 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jC3 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jC & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jC2 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jC4 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jC3 & 4294967295L));
        return new c1.c(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    public static final boolean h(long j10, long j11) {
        return j10 == j11;
    }

    public static final q i(q qVar) {
        q qVar2;
        q qVarW = qVar.w();
        while (true) {
            q qVar3 = qVarW;
            qVar2 = qVar;
            qVar = qVar3;
            if (qVar == null) {
                break;
            }
            qVarW = qVar.w();
        }
        g1 g1Var = qVar2 instanceof g1 ? (g1) qVar2 : null;
        if (g1Var == null) {
            return qVar2;
        }
        g1 g1Var2 = g1Var.f13812u;
        while (true) {
            g1 g1Var3 = g1Var2;
            g1 g1Var4 = g1Var;
            g1Var = g1Var3;
            if (g1Var == null) {
                return g1Var4;
            }
            g1Var2 = g1Var.f13812u;
        }
    }

    public static final u1.p0 j(u1.p0 p0Var) {
        u1.g0 g0Var = p0Var.f13889s.f13810s;
        while (true) {
            u1.g0 g0VarT = g0Var.t();
            u1.g0 g0Var2 = null;
            if ((g0VarT != null ? g0VarT.f13794k : null) == null) {
                u1.p0 p0VarF0 = g0Var.H.f13744d.F0();
                p0VarF0.getClass();
                return p0VarF0;
            }
            u1.g0 g0VarT2 = g0Var.t();
            if (g0VarT2 != null) {
                g0Var2 = g0VarT2.f13794k;
            }
            g0Var2.getClass();
            u1.g0 g0VarT3 = g0Var.t();
            g0VarT3.getClass();
            g0Var = g0VarT3.f13794k;
            g0Var.getClass();
        }
    }

    public static final o k(o... oVarArr) {
        int i = 0;
        o oVar = new o(i);
        oVar.f11276f = oVarArr;
        int length = oVarArr.length;
        n[] nVarArr = new n[length];
        for (int i3 = 0; i3 < length; i3++) {
            nVarArr[i3] = oVarArr[i3].b();
        }
        int i10 = 1;
        oVar.f11272b = new n(1, new b1(nVarArr, i));
        int length2 = oVarArr.length;
        n[] nVarArr2 = new n[length2];
        for (int i11 = 0; i11 < length2; i11++) {
            nVarArr2[i11] = oVarArr[i11].d();
        }
        oVar.f11273c = new n(0, new m(nVarArr2, i));
        int length3 = oVarArr.length;
        n[] nVarArr3 = new n[length3];
        for (int i12 = 0; i12 < length3; i12++) {
            nVarArr3[i12] = oVarArr[i12].c();
        }
        oVar.f11274d = new n(1, new b1(nVarArr3, i10));
        int length4 = oVarArr.length;
        n[] nVarArr4 = new n[length4];
        for (int i13 = 0; i13 < length4; i13++) {
            nVarArr4[i13] = oVarArr[i13].a();
        }
        oVar.f11275e = new n(0, new m(nVarArr4, i10));
        VarHandle.storeStoreFence();
        return oVar;
    }

    public static final long l(long j10, long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) * Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) * Float.intBitsToFloat((int) (j10 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }
}

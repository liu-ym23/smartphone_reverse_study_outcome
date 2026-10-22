package h0;

import android.R;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0.g f4921a = new g0.g(0.16f, 0.1f, 0.08f, 0.1f);

    public static final void a(xb.a aVar, s0.c cVar, w0.m mVar, xb.p pVar, xb.p pVar2, xb.p pVar3, d1.j0 j0Var, long j10, long j11, long j12, long j13, float f5, s2.k kVar, k0.s sVar, int i) {
        long j14;
        float f10;
        s2.k kVar2;
        long j15;
        d1.j0 j0Var2;
        long j16;
        w0.m mVar2;
        long j17;
        w0.m mVar3;
        d1.j0 j0Var3;
        long j18;
        long j19;
        long j20;
        long j21;
        float f11;
        s2.k kVar3;
        sVar.Z(-2081346864);
        if (((i | 306209152) & 306783379) == 306783378 && sVar.B()) {
            sVar.S();
            mVar3 = mVar;
            j0Var3 = j0Var;
            j18 = j10;
            j19 = j11;
            j20 = j12;
            j21 = j13;
            f11 = f5;
            kVar3 = kVar;
        } else {
            sVar.U();
            if ((i & 1) == 0 || sVar.z()) {
                float f12 = a.f4903a;
                d1.j0 j0VarA = m1.a(j0.c.f6421a, sVar);
                long jE = b0.e(38, sVar);
                long jE2 = b0.e(j0.c.f6426f, sVar);
                long jE3 = b0.e(j0.c.f6422b, sVar);
                long jE4 = b0.e(j0.c.f6424d, sVar);
                float f13 = a.f4903a;
                j14 = jE4;
                f10 = f13;
                kVar2 = new s2.k();
                j15 = jE2;
                j0Var2 = j0VarA;
                j16 = jE;
                mVar2 = w0.j.f15113c;
                j17 = jE3;
            } else {
                sVar.S();
                mVar2 = mVar;
                j0Var2 = j0Var;
                j16 = j10;
                j15 = j11;
                j17 = j12;
                j14 = j13;
                f10 = f5;
                kVar2 = kVar;
            }
            sVar.r();
            m.c(aVar, cVar, mVar2, pVar, pVar2, pVar3, j0Var2, j16, j15, j17, j14, f10, kVar2, sVar, 1797558, 3456);
            mVar3 = mVar2;
            j0Var3 = j0Var2;
            j18 = j16;
            j19 = j15;
            j20 = j17;
            j21 = j14;
            f11 = f10;
            kVar3 = kVar2;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new n(aVar, cVar, mVar3, pVar, pVar2, pVar3, j0Var3, j18, j19, j20, j21, f11, kVar3, i);
        }
    }

    public static final void b(xb.a aVar, w0.m mVar, boolean z10, d1.j0 j0Var, o oVar, b1 b1Var, td.h hVar, w.l0 l0Var, s0.c cVar, k0.s sVar, int i) {
        xb.a aVar2;
        int i3;
        sVar.Z(650121315);
        if ((i & 6) == 0) {
            aVar2 = aVar;
            i3 = (sVar.h(aVar2) ? 4 : 2) | i;
        } else {
            aVar2 = aVar;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.f(mVar) ? 32 : 16;
        }
        int i10 = i & 384;
        int i11 = ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
        if (i10 == 0) {
            if (!sVar.g(z10)) {
                i11 = 128;
            }
            i3 |= i11;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar.f(j0Var) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= sVar.f(oVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= sVar.f(b1Var) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= sVar.f(hVar) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= sVar.f(l0Var) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= sVar.f(null) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= sVar.h(cVar) ? 536870912 : 268435456;
        }
        if ((306783379 & i3) == 306783378 && sVar.B()) {
            sVar.S();
        } else {
            sVar.U();
            if ((i & 1) != 0 && !sVar.z()) {
                sVar.S();
            }
            sVar.r();
            sVar.X(-239156623);
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = t0.a.a();
                sVar.i0(objM);
            }
            v.k kVar = (v.k) objM;
            sVar.q(false);
            long j10 = z10 ? oVar.f5088a : oVar.f5090c;
            long j11 = z10 ? oVar.f5089b : oVar.f5091d;
            sVar.X(-239150048);
            sVar.q(false);
            q1.b(aVar2, a2.l.a(mVar, false, r.f5119f), z10, j0Var, j10, j11, 0, hVar, kVar, s0.h.d(956488494, new s(j11, l0Var, cVar), sVar), sVar, ((i3 << 6) & 234881024) | (i3 & 8078), 64);
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new t(aVar, mVar, z10, j0Var, oVar, b1Var, hVar, l0Var, cVar, i);
        }
    }

    public static final void c(w0.m mVar, d1.j0 j0Var, v vVar, w wVar, s0.c cVar, k0.s sVar, int i) {
        w0.m mVar2;
        w0.m mVar3;
        sVar.Z(1179621553);
        int i3 = i | 6 | (sVar.f(j0Var) ? 32 : 16) | (sVar.f(vVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.f(wVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | 24576;
        if ((74899 & i3) == 74898 && sVar.B()) {
            sVar.S();
            mVar3 = mVar;
        } else {
            sVar.U();
            if ((i & 1) == 0 || sVar.z()) {
                mVar2 = w0.j.f15113c;
            } else {
                sVar.S();
                mVar2 = mVar;
            }
            sVar.r();
            long j10 = vVar.f5201a;
            long j11 = vVar.f5202b;
            float f5 = wVar.f5226a;
            sVar.X(-1763481333);
            sVar.X(-734838460);
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = k0.z.v(o2.f.a(f5));
                sVar.i0(objM);
            }
            sVar.q(false);
            sVar.q(false);
            q1.a(mVar2, j0Var, j10, j11, 0.0f, ((o2.f) ((k0.c1) objM).getValue()).f9114c, s0.h.d(664103990, new g(cVar), sVar), sVar, (i3 & 112) | 14155782, 16);
            mVar3 = mVar2;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new x(mVar3, j0Var, vVar, wVar, cVar, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(w0.m r9, float r10, long r11, k0.s r13, int r14, int r15) {
        /*
            r2 = 75144485(0x47a9d25, float:2.9459516E-36)
            r13.Z(r2)
            r2 = r14 & 6
            if (r2 != 0) goto L15
            boolean r2 = r13.f(r9)
            if (r2 == 0) goto L12
            r2 = 4
            goto L13
        L12:
            r2 = 2
        L13:
            r2 = r2 | r14
            goto L16
        L15:
            r2 = r14
        L16:
            r3 = r15 & 2
            r4 = 32
            if (r3 == 0) goto L1f
            r2 = r2 | 48
            goto L2e
        L1f:
            r5 = r14 & 48
            if (r5 != 0) goto L2e
            boolean r6 = r13.c(r10)
            if (r6 == 0) goto L2b
            r6 = r4
            goto L2d
        L2b:
            r6 = 16
        L2d:
            r2 = r2 | r6
        L2e:
            r6 = r2 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            if (r6 != r7) goto L40
            boolean r6 = r13.B()
            if (r6 != 0) goto L3b
            goto L40
        L3b:
            r13.S()
            r2 = r10
            goto L84
        L40:
            r13.U()
            r6 = r14 & 1
            if (r6 == 0) goto L53
            boolean r6 = r13.z()
            if (r6 == 0) goto L4e
            goto L53
        L4e:
            r13.S()
        L51:
            r3 = r10
            goto L57
        L53:
            if (r3 == 0) goto L51
            float r3 = h0.i0.f5013a
        L57:
            r13.r()
            r5 = 1065353216(0x3f800000, float:1.0)
            w0.m r5 = androidx.compose.foundation.layout.c.b(r9, r5)
            w0.m r5 = androidx.compose.foundation.layout.c.c(r5, r3)
            r2 = r2 & 112(0x70, float:1.57E-43)
            r6 = 0
            if (r2 != r4) goto L6b
            r2 = 1
            goto L6c
        L6b:
            r2 = r6
        L6c:
            java.lang.Object r4 = r13.M()
            if (r2 != 0) goto L76
            k0.y0 r2 = k0.m.f6974a
            if (r4 != r2) goto L7e
        L76:
            h0.j0 r4 = new h0.j0
            r4.<init>(r3, r11)
            r13.i0(r4)
        L7e:
            xb.l r4 = (xb.l) r4
            t.n.a(r5, r4, r13, r6)
            r2 = r3
        L84:
            k0.v1 r8 = r13.s()
            if (r8 == 0) goto L95
            h0.k0 r0 = new h0.k0
            r1 = r9
            r3 = r11
            r5 = r14
            r6 = r15
            r0.<init>(r1, r2, r3, r5, r6)
            r8.f7091d = r0
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.b1.d(w0.m, float, long, k0.s, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(xb.a r21, w0.m r22, boolean r23, d1.j0 r24, h0.o r25, w.l0 r26, s0.c r27, k0.s r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.b1.e(xb.a, w0.m, boolean, d1.j0, h0.o, w.l0, s0.c, k0.s, int, int):void");
    }

    public static final u1 f(Context context) {
        y yVar = y.f5242a;
        yVar.a(context, R.color.system_neutral1_0);
        yVar.a(context, R.color.system_neutral1_10);
        g(98.0f, yVar.a(context, R.color.system_neutral1_600));
        g(96.0f, yVar.a(context, R.color.system_neutral1_600));
        yVar.a(context, R.color.system_neutral1_50);
        g(94.0f, yVar.a(context, R.color.system_neutral1_600));
        g(92.0f, yVar.a(context, R.color.system_neutral1_600));
        yVar.a(context, R.color.system_neutral1_100);
        g(87.0f, yVar.a(context, R.color.system_neutral1_600));
        yVar.a(context, R.color.system_neutral1_200);
        yVar.a(context, R.color.system_neutral1_300);
        yVar.a(context, R.color.system_neutral1_400);
        yVar.a(context, R.color.system_neutral1_500);
        yVar.a(context, R.color.system_neutral1_600);
        yVar.a(context, R.color.system_neutral1_700);
        g(24.0f, yVar.a(context, R.color.system_neutral1_600));
        g(22.0f, yVar.a(context, R.color.system_neutral1_600));
        yVar.a(context, R.color.system_neutral1_800);
        g(17.0f, yVar.a(context, R.color.system_neutral1_600));
        g(12.0f, yVar.a(context, R.color.system_neutral1_600));
        yVar.a(context, R.color.system_neutral1_900);
        g(6.0f, yVar.a(context, R.color.system_neutral1_600));
        g(4.0f, yVar.a(context, R.color.system_neutral1_600));
        yVar.a(context, R.color.system_neutral1_1000);
        long jA = yVar.a(context, R.color.system_neutral2_0);
        yVar.a(context, R.color.system_neutral2_10);
        long jG = g(98.0f, yVar.a(context, R.color.system_neutral2_600));
        long jG2 = g(96.0f, yVar.a(context, R.color.system_neutral2_600));
        long jA2 = yVar.a(context, R.color.system_neutral2_50);
        long jG3 = g(94.0f, yVar.a(context, R.color.system_neutral2_600));
        long jG4 = g(92.0f, yVar.a(context, R.color.system_neutral2_600));
        long jA3 = yVar.a(context, R.color.system_neutral2_100);
        long jG5 = g(87.0f, yVar.a(context, R.color.system_neutral2_600));
        long jA4 = yVar.a(context, R.color.system_neutral2_200);
        yVar.a(context, R.color.system_neutral2_300);
        long jA5 = yVar.a(context, R.color.system_neutral2_400);
        long jA6 = yVar.a(context, R.color.system_neutral2_500);
        yVar.a(context, R.color.system_neutral2_600);
        long jA7 = yVar.a(context, R.color.system_neutral2_700);
        long jG6 = g(24.0f, yVar.a(context, R.color.system_neutral2_600));
        long jG7 = g(22.0f, yVar.a(context, R.color.system_neutral2_600));
        long jA8 = yVar.a(context, R.color.system_neutral2_800);
        long jG8 = g(17.0f, yVar.a(context, R.color.system_neutral2_600));
        long jG9 = g(12.0f, yVar.a(context, R.color.system_neutral2_600));
        long jA9 = yVar.a(context, R.color.system_neutral2_900);
        long jG10 = g(6.0f, yVar.a(context, R.color.system_neutral2_600));
        long jG11 = g(4.0f, yVar.a(context, R.color.system_neutral2_600));
        long jA10 = yVar.a(context, R.color.system_neutral2_1000);
        long jA11 = yVar.a(context, R.color.system_accent1_0);
        yVar.a(context, R.color.system_accent1_10);
        yVar.a(context, R.color.system_accent1_50);
        long jA12 = yVar.a(context, R.color.system_accent1_100);
        long jA13 = yVar.a(context, R.color.system_accent1_200);
        yVar.a(context, R.color.system_accent1_300);
        yVar.a(context, R.color.system_accent1_400);
        yVar.a(context, R.color.system_accent1_500);
        long jA14 = yVar.a(context, R.color.system_accent1_600);
        long jA15 = yVar.a(context, R.color.system_accent1_700);
        long jA16 = yVar.a(context, R.color.system_accent1_800);
        long jA17 = yVar.a(context, R.color.system_accent1_900);
        yVar.a(context, R.color.system_accent1_1000);
        long jA18 = yVar.a(context, R.color.system_accent2_0);
        yVar.a(context, R.color.system_accent2_10);
        yVar.a(context, R.color.system_accent2_50);
        long jA19 = yVar.a(context, R.color.system_accent2_100);
        long jA20 = yVar.a(context, R.color.system_accent2_200);
        yVar.a(context, R.color.system_accent2_300);
        yVar.a(context, R.color.system_accent2_400);
        yVar.a(context, R.color.system_accent2_500);
        long jA21 = yVar.a(context, R.color.system_accent2_600);
        long jA22 = yVar.a(context, R.color.system_accent2_700);
        long jA23 = yVar.a(context, R.color.system_accent2_800);
        long jA24 = yVar.a(context, R.color.system_accent2_900);
        yVar.a(context, R.color.system_accent2_1000);
        long jA25 = yVar.a(context, R.color.system_accent3_0);
        yVar.a(context, R.color.system_accent3_10);
        yVar.a(context, R.color.system_accent3_50);
        long jA26 = yVar.a(context, R.color.system_accent3_100);
        long jA27 = yVar.a(context, R.color.system_accent3_200);
        yVar.a(context, R.color.system_accent3_300);
        yVar.a(context, R.color.system_accent3_400);
        yVar.a(context, R.color.system_accent3_500);
        long jA28 = yVar.a(context, R.color.system_accent3_600);
        long jA29 = yVar.a(context, R.color.system_accent3_700);
        long jA30 = yVar.a(context, R.color.system_accent3_800);
        long jA31 = yVar.a(context, R.color.system_accent3_900);
        yVar.a(context, R.color.system_accent3_1000);
        u1 u1Var = new u1();
        u1Var.f5176a = jA;
        u1Var.f5177b = jG;
        u1Var.f5178c = jG2;
        u1Var.f5179d = jA2;
        u1Var.f5180e = jG3;
        u1Var.f5181f = jG4;
        u1Var.f5182g = jA3;
        u1Var.f5183h = jG5;
        u1Var.i = jA4;
        u1Var.f5184j = jA5;
        u1Var.f5185k = jA6;
        u1Var.f5186l = jA7;
        u1Var.f5187m = jG6;
        u1Var.f5188n = jG7;
        u1Var.f5189o = jA8;
        u1Var.f5190p = jG8;
        u1Var.f5191q = jG9;
        u1Var.f5192r = jA9;
        u1Var.f5193s = jG10;
        u1Var.f5194t = jG11;
        u1Var.f5195u = jA10;
        u1Var.f5196v = jA11;
        u1Var.f5197w = jA12;
        u1Var.f5198x = jA13;
        u1Var.f5199y = jA14;
        u1Var.f5200z = jA15;
        u1Var.A = jA16;
        u1Var.B = jA17;
        u1Var.C = jA18;
        u1Var.D = jA19;
        u1Var.E = jA20;
        u1Var.F = jA21;
        u1Var.G = jA22;
        u1Var.H = jA23;
        u1Var.I = jA24;
        u1Var.J = jA25;
        u1Var.K = jA26;
        u1Var.L = jA27;
        u1Var.M = jA28;
        u1Var.N = jA29;
        u1Var.O = jA30;
        u1Var.P = jA31;
        VarHandle.storeStoreFence();
        return u1Var;
    }

    public static final long g(float f5, long j10) {
        double d7 = f5;
        if (!(d7 < 1.0E-4d) && !(d7 > 99.9999d)) {
            e1.k kVar = e1.d.f3360t;
            long jB = d1.p.b(j10, kVar);
            return d1.p.b(d1.f0.a(f5, d1.p.h(jB), d1.p.f(jB), 1.0f, kVar), e1.d.f3346e);
        }
        float f10 = 100;
        float f11 = 16;
        float f12 = 116;
        float f13 = (f5 + f11) / f12;
        float f14 = f13 * f13 * f13;
        if (f14 <= 0.008856452f) {
            f14 = ((f12 * f13) - f11) / 903.2963f;
        }
        double d10 = (f14 * f10) / f10;
        int iJ = td.h.j(ac.a.P((d10 <= 0.0031308d ? d10 * 12.92d : (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d), 0, 255);
        return d1.f0.d(iJ, iJ, iJ);
    }
}

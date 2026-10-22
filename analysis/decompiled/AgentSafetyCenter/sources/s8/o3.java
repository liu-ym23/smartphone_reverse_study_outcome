package s8;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o3 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11843a = d1.f0.c(4294309367L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f11844b = d1.f0.c(4287532691L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f11845c = d1.p.c(0.45f, d1.f0.c(4293651445L));

    /* renamed from: d, reason: collision with root package name */
    public static final long f11846d = d1.f0.c(4284111454L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f11847e = d1.f0.c(4287532691L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f11848f = d1.f0.c(4294924890L);

    /* renamed from: g, reason: collision with root package name */
    public static final long f11849g = d1.f0.c(4282196520L);

    /* renamed from: h, reason: collision with root package name */
    public static final long f11850h = d1.f0.c(4294924890L);
    public static final long i = d1.f0.c(4282196520L);

    /* renamed from: j, reason: collision with root package name */
    public static final float f11851j = 16;

    /* renamed from: k, reason: collision with root package name */
    public static final float f11852k;

    /* renamed from: l, reason: collision with root package name */
    public static final float f11853l;

    static {
        float f5 = 18;
        f11852k = f5;
        f11853l = f5 + 10;
    }

    public static final void a(String str, k0.s sVar, int i3) {
        str.getClass();
        sVar.Z(855761142);
        int i10 = 4;
        int i11 = 2;
        int i12 = i3 | (sVar.f(str) ? 4 : 2);
        if (sVar.P(i12 & 1, (i12 & 3) != 2)) {
            boolean zEquals = str.equals("已拦截");
            long j10 = f11850h;
            long j11 = f11849g;
            jb.g gVar = (zEquals || hc.h.X(str, "不可逆", false) || hc.h.X(str, "已拦截", false) || hc.h.X(str, "被拦下", false) || hc.h.X(str, "拦截", false)) ? new jb.g(d1.p.a(j11), d1.p.a(j10)) : hc.h.X(str, "自主", false) ? new jb.g(d1.p.a(d1.f0.c(4279904842L)), d1.p.a(d1.f0.c(4284194815L))) : (hc.h.X(str, "外发", false) || hc.h.X(str, "外部", false)) ? new jb.g(d1.p.a(d1.f0.c(4279907120L)), d1.p.a(d1.f0.c(4283283104L))) : (hc.h.X(str, "金钱", false) || hc.h.X(str, "分析", false)) ? new jb.g(d1.p.a(d1.f0.c(4282201112L)), d1.p.a(d1.f0.c(4293310541L))) : hc.h.X(str, "需关注", false) ? new jb.g(d1.p.a(d1.f0.c(4280953390L)), d1.p.a(d1.f0.c(4287532691L))) : hc.h.X(str, "批量", false) ? new jb.g(d1.p.a(d1.f0.c(4279909682L)), d1.p.a(d1.f0.c(4283283104L))) : hc.h.X(str, "越界", false) ? new jb.g(d1.p.a(j11), d1.p.a(j10)) : hc.h.X(str, "触碰凭据", false) ? new jb.g(d1.p.a(d1.f0.c(4280951360L)), d1.p.a(d1.f0.c(4289961435L))) : new jb.g(d1.p.a(d1.f0.c(4280953390L)), d1.p.a(d1.f0.c(4287532691L)));
            long j12 = ((d1.p) gVar.f6759c).f3026a;
            long j13 = ((d1.p) gVar.f6760f).f3026a;
            a0.d dVarA = a0.e.a(6);
            float f5 = 0;
            o8.c cVar = new o8.c(i11);
            cVar.f9301f = str;
            cVar.f9302g = j13;
            VarHandle.storeStoreFence();
            h0.q1.a(null, dVarA, j12, 0L, f5, f5, s0.h.d(-300307951, cVar, sVar), sVar, 12804096, 73);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            e9.d0 d0Var = new e9.d0(i10);
            d0Var.f3637f = str;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = d0Var;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0280  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r33v0, types: [java.lang.Object, xb.l] */
    /* JADX WARN: Type inference failed for: r35v0, types: [k0.s] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(java.util.List r31, s0.c r32, xb.l r33, boolean r34, k0.s r35, int r36) {
        /*
            Method dump skipped, instructions count: 981
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.o3.b(java.util.List, s0.c, xb.l, boolean, k0.s, int):void");
    }

    public static final void c(boolean z10, float f5, w0.m mVar, k0.s sVar, int i3) {
        float f10;
        k0.v1 v1VarS;
        k3 k3Var;
        sVar.Z(-46201634);
        int i10 = i3 | (sVar.g(z10) ? 4 : 2) | 48 | (sVar.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar.P(i10 & 1, (i10 & 147) != 146)) {
            f10 = 12;
            if (!z10) {
                v1VarS = sVar.s();
                if (v1VarS != null) {
                    k3Var = new k3(0);
                    k3Var.f11732f = z10;
                    k3Var.f11733g = f10;
                    k3Var.f11734h = mVar;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = k3Var;
                }
                return;
            }
            float f11 = 1;
            w0.m mVarF = androidx.compose.foundation.layout.b.f(androidx.compose.foundation.layout.c.b(mVar, 1.0f), f11);
            s1.f0 f0VarE = w.p.e(w0.b.f15089c, false);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarF);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(f0VarE, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            float f12 = f10 - f11;
            float f13 = 0;
            w0.m mVarG = com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.a.f901a.a(w0.j.f15113c, w0.b.f15093j).d(androidx.compose.foundation.layout.c.f903b), 0.45f), a0.e.c(0.0f, ((o2.f) p5.f.n(o2.f.a(f12), o2.f.a(f13))).f9114c, ((o2.f) p5.f.n(o2.f.a(f12), o2.f.a(f13))).f9114c, 9));
            List listF = ac.a.F(d1.p.a(d1.p.f3023f), d1.p.a(d1.p.c(0.85f, i)));
            d1.y yVar = new d1.y();
            yVar.f3032d = listF;
            yVar.f3033e = (Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L);
            yVar.f3034f = (Float.floatToRawIntBits(Float.POSITIVE_INFINITY) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L);
            VarHandle.storeStoreFence();
            w.p.a(androidx.compose.foundation.a.a(mVarG, yVar), sVar, 0);
            sVar.q(true);
        } else {
            sVar.S();
            f10 = f5;
        }
        v1VarS = sVar.s();
        if (v1VarS != null) {
            k3Var = new k3(1);
            k3Var.f11732f = z10;
            k3Var.f11733g = f10;
            k3Var.f11734h = mVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = k3Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x04f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(s8.p3 r44, xb.q r45, boolean r46, boolean r47, k0.s r48, int r49) {
        /*
            Method dump skipped, instructions count: 1418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.o3.d(s8.p3, xb.q, boolean, boolean, k0.s, int):void");
    }

    public static final void e(p3 p3Var, xb.a aVar, k0.s sVar, int i3) {
        int i10;
        int i11;
        k0.s sVar2 = sVar;
        p3Var.getClass();
        u8.p pVar = p3Var.f11899z;
        sVar2.Z(-1500868631);
        if ((i3 & 6) == 0) {
            i10 = (sVar2.h(p3Var) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        if ((i3 & 48) == 0) {
            i10 |= sVar2.h(aVar) ? 32 : 16;
        }
        int i12 = i10;
        if (sVar2.P(i12 & 1, (i12 & 19) != 18)) {
            List listB = x0.b(p3Var);
            List list = p3Var.C;
            boolean z10 = pVar == u8.p.f14244f || !listB.isEmpty();
            boolean z11 = pVar == u8.p.f14245g || !list.isEmpty();
            w0.j jVar = w0.j.f15113c;
            if (!z10 || x0.h(p3Var) || listB.isEmpty()) {
                sVar2.X(-1781678119);
            } else {
                sVar2.X(-1767357638);
                t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, 8));
                l1.d(listB, null, 0, sVar2, 0);
            }
            sVar2.q(false);
            if (!z11 || x0.h(p3Var) || list.isEmpty()) {
                sVar2.X(-1781678119);
            } else {
                sVar2.X(-1767204157);
                t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, 8));
                i2.f(list, null, 0, sVar2, 0);
            }
            sVar2.q(false);
            if (x0.h(p3Var)) {
                k0.v1 v1VarS = sVar2.s();
                if (v1VarS != null) {
                    n3 n3Var = new n3(0);
                    n3Var.f11825f = p3Var;
                    n3Var.f11826g = aVar;
                    n3Var.f11827h = i3;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = n3Var;
                    return;
                }
                return;
            }
            if (z10 || z11) {
                i11 = -1781678119;
                sVar2.X(-1781678119);
            } else {
                sVar2.X(-1767038307);
                List listC = x0.c(p3Var);
                if (e3.g(listC).isEmpty()) {
                    sVar2.X(-1781678119);
                } else {
                    sVar2.X(-1766891894);
                    t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, 8));
                    e3.d(listC, null, sVar2, 0);
                }
                sVar2.q(false);
                if (listC.isEmpty()) {
                    i11 = -1781678119;
                    sVar2.X(-1781678119);
                    sVar2.q(false);
                } else {
                    Iterator it = listC.iterator();
                    while (it.hasNext()) {
                        if (e3.f(e3.h((String) it.next()))) {
                            sVar2.X(-1766705026);
                            t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, 8));
                            i11 = -1781678119;
                            e3.b(listC, p3Var.f11891r, p3Var.f11892s, null, 0, sVar2, 0, 24);
                            break;
                        }
                    }
                    i11 = -1781678119;
                    sVar2.X(-1781678119);
                    sVar2.q(false);
                }
            }
            sVar2.q(false);
            if (p3Var.f11882h == z8.g.f16512h) {
                sVar2.X(-1766404202);
                t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, 10));
                h0.t1.b(t2.a.o(R.string.undo_state_expired_hint, sVar2), null, ((h0.z) sVar2.j(h0.b0.f4919a)).f5261s, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar2.j(h0.w1.f5235a)).f5222l, sVar, 0, 0, 65530);
                sVar2 = sVar;
                sVar2.q(false);
            } else {
                if (!x0.t(p3Var) || aVar == null) {
                    sVar2.X(i11);
                } else {
                    sVar2.X(-1766089738);
                    t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, 10));
                    x2.i(aVar, null, sVar2, (i12 >> 3) & 14);
                }
                sVar2.q(false);
            }
        } else {
            sVar2.S();
        }
        k0.v1 v1VarS2 = sVar2.s();
        if (v1VarS2 != null) {
            n3 n3Var2 = new n3(1);
            n3Var2.f11825f = p3Var;
            n3Var2.f11826g = aVar;
            n3Var2.f11827h = i3;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = n3Var2;
        }
    }
}

package h0;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final float f5269a;

    /* renamed from: b, reason: collision with root package name */
    public static final float f5270b;

    /* renamed from: c, reason: collision with root package name */
    public static final s.r f5271c;

    static {
        float f5 = 10;
        f5269a = f5;
        androidx.compose.foundation.layout.b.h(a2.l.a(androidx.compose.ui.layout.a.a(w0.j.f15113c, y0.f5243c), true, r.f5120g), 0.0f, f5, 1);
        f5270b = j0.k.f6467b - (j0.k.f6466a * 2);
        new s.r(0.2f, 0.0f, 0.8f);
        new s.r(0.4f, 0.0f, 1.0f);
        new s.r(0.0f, 0.0f, 0.65f);
        new s.r(0.1f, 0.0f, 0.45f);
        f5271c = new s.r(0.4f, 0.0f, 0.2f);
    }

    public static final void a(w0.m mVar, long j10, float f5, long j11, int i, k0.s sVar, int i3) {
        float f10;
        long j12;
        int i10;
        w0.m mVar2;
        float f11;
        w0.m mVar3;
        long j13;
        float f12;
        int i11;
        Float fValueOf = Float.valueOf(290.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        sVar.Z(-115871647);
        if (((i3 | 25990) & 9363) == 9362 && sVar.B()) {
            sVar.S();
            mVar3 = mVar;
            f12 = f5;
            j13 = j11;
            i11 = i;
        } else {
            sVar.U();
            if ((i3 & 1) == 0 || sVar.z()) {
                float f13 = u0.f5174a;
                long j14 = d1.p.f3023f;
                f10 = f13;
                j12 = j14;
                i10 = u0.f5175b;
                mVar2 = w0.j.f15113c;
            } else {
                sVar.S();
                mVar2 = mVar;
                f10 = f5;
                j12 = j11;
                i10 = i;
            }
            sVar.r();
            f1.g gVar = new f1.g(((o2.c) sVar.j(v1.a1.f14363h)).X(f10), 0.0f, i10, 0, null, 26);
            int i12 = i10;
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            Object obj2 = objM;
            if (objM == obj) {
                s.e0 e0Var = new s.e0();
                e0Var.f10985a = new m0.e(new s.c0[16]);
                e0Var.f10986b = k0.z.v(Boolean.FALSE);
                e0Var.f10987c = Long.MIN_VALUE;
                e0Var.f10988d = k0.z.v(Boolean.TRUE);
                VarHandle.storeStoreFence();
                sVar.i0(e0Var);
                obj2 = e0Var;
            }
            s.e0 e0Var2 = (s.e0) obj2;
            e0Var2.a(0, sVar);
            n6.a aVar = s.i1.f11027b;
            od.f fVar = s.w.f11153b;
            s.c0 c0VarG = s.d.g(e0Var2, 0, 5, aVar, s.d.l(s.d.n(6660, 2, fVar)), sVar, 33208);
            s.c0 c0VarE = s.d.e(e0Var2, 286.0f, s.d.l(s.d.n(1332, 2, fVar)), sVar);
            wd.a aVar2 = new wd.a(8);
            aVar2.f15389f = 300;
            p.u uVar = p.k.f9586a;
            aVar2.f15390g = new p.u();
            aVar2.f15389f = 1332;
            s.g0 g0VarB = aVar2.b(0, fValueOf2);
            s.r rVar = f5271c;
            g0VarB.f11014b = rVar;
            aVar2.b(666, fValueOf);
            s.h0 h0Var = new s.h0();
            h0Var.f11016a = aVar2;
            VarHandle.storeStoreFence();
            s.c0 c0VarE2 = s.d.e(e0Var2, 290.0f, s.d.l(h0Var), sVar);
            wd.a aVar3 = new wd.a(8);
            aVar3.f15389f = 300;
            aVar3.f15390g = new p.u();
            aVar3.f15389f = 1332;
            aVar3.b(666, fValueOf2).f11014b = rVar;
            aVar3.b(aVar3.f15389f, fValueOf);
            s.h0 h0Var2 = new s.h0();
            h0Var2.f11016a = aVar3;
            VarHandle.storeStoreFence();
            s.c0 c0VarE3 = s.d.e(e0Var2, 290.0f, s.d.l(h0Var2), sVar);
            w0.m mVarF = androidx.compose.foundation.layout.c.f(a2.l.a(mVar2, true, t.j.f13015h), f5270b);
            boolean zE = sVar.e(j12) | sVar.h(gVar) | sVar.f(c0VarG) | sVar.f(c0VarE2) | sVar.f(c0VarE3) | sVar.f(c0VarE);
            Object objM2 = sVar.M();
            if (zE || objM2 == obj) {
                f11 = f10;
                Object v0Var = new v0(j12, gVar, c0VarG, c0VarE2, c0VarE3, c0VarE, f11, j10);
                sVar.i0(v0Var);
                objM2 = v0Var;
            } else {
                f11 = f10;
            }
            t.n.a(mVarF, (xb.l) objM2, sVar, 0);
            mVar3 = mVar2;
            j13 = j12;
            f12 = f11;
            i11 = i12;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new w0(mVar3, j10, f12, j13, i11, i3);
        }
    }

    public static final void b(f1.d dVar, float f5, float f10, long j10, f1.g gVar) {
        float f11 = 2;
        float f12 = gVar.f3865e / f11;
        float fE = c1.e.e(dVar.e()) - (f11 * f12);
        dVar.n0(j10, f5, f10, id.k.d(f12, f12), a.a.e(fE, fE), gVar);
    }
}

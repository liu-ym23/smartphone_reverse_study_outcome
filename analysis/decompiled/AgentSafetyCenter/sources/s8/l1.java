package s8;

import android.content.Context;
import androidx.compose.foundation.BorderModifierNodeElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l1 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11758a = d1.f0.c(4294309367L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f11759b = d1.f0.c(4287532691L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f11760c = d1.f0.c(4281084974L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f11761d = d1.f0.c(4282006076L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f11762e = d1.f0.c(4280032286L);

    /* renamed from: f, reason: collision with root package name */
    public static final List f11763f = ac.a.F(d1.p.a(d1.f0.c(4293310541L)), d1.p.a(d1.f0.c(4294924890L)), d1.p.a(d1.f0.c(4281303295L)), d1.p.a(d1.f0.c(4283283104L)));

    public static final void a(String str, String str2, w0.m mVar, k0.s sVar, int i) {
        int i3;
        k0.s sVar2 = sVar;
        sVar2.Z(959294193);
        if ((i & 6) == 0) {
            i3 = (sVar2.f(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar2.f(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar2.d(28) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar2.f(mVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        int i10 = 0;
        if (sVar2.P(i3 & 1, (i3 & 1171) != 1170)) {
            Context context = (Context) sVar2.j(AndroidCompositionLocals_androidKt.f982b);
            int i11 = i3 & 112;
            boolean zH = (i11 == 32) | sVar2.h(context);
            Object objM = sVar2.M();
            k0.y0 y0Var = k0.m.f6974a;
            if (zH || objM == y0Var) {
                objM = new k1(context, str2, null, i10);
                sVar2.i0(objM);
            }
            k0.c1 c1VarW = k0.z.w(str2, (xb.p) objM, sVar2, i11 | 6);
            int i12 = i3 & 14;
            boolean z10 = i12 == 4;
            Object objM2 = sVar2.M();
            if (z10 || objM2 == y0Var) {
                objM2 = f(str);
                sVar2.i0(objM2);
            }
            String str3 = (String) objM2;
            boolean z11 = i12 == 4;
            Object objM3 = sVar2.M();
            if (z11 || objM3 == y0Var) {
                int iHashCode = str.hashCode() & Reader.READ_DONE;
                List list = f11763f;
                objM3 = d1.p.a(((d1.p) list.get(iHashCode % list.size())).f3026a);
                sVar2.i0(objM3);
            }
            long j10 = ((d1.p) objM3).f3026a;
            float f5 = 28;
            w0.m mVarF = androidx.compose.foundation.layout.c.f(mVar, f5);
            a0.d dVar = a0.e.f7a;
            d1.l0 l0Var = new d1.l0(f11762e);
            BorderModifierNodeElement borderModifierNodeElement = new BorderModifierNodeElement();
            borderModifierNodeElement.f840c = (float) 1.5d;
            borderModifierNodeElement.f841f = l0Var;
            borderModifierNodeElement.f842g = dVar;
            VarHandle.storeStoreFence();
            w0.m mVarB = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(mVarF.d(borderModifierNodeElement), dVar), j10, d1.f0.f2972a);
            s1.f0 f0VarE = w.p.e(w0.b.i, false);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarB);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(f0VarE, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar2, iHashCode2, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            d1.e eVar = (d1.e) c1VarW.getValue();
            if (eVar != null) {
                sVar2.X(-360512101);
                FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
                s1.j.f11260d.getClass();
                t.m0.c(eVar, fillElement, sVar2, 25008, 232);
                sVar2.q(false);
            } else {
                sVar2.X(-360287320);
                h0.t1.b(str3, null, d1.p.f3020c, com.stepos.statsrpk.h.C(f5 * 0.36f, 4294967296L), g2.k.f4253h, 0L, null, 0L, 0, false, 1, 0, null, sVar, 196992, 3072, 122834);
                sVar2 = sVar;
                sVar2.q(false);
            }
            sVar2.q(true);
        } else {
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            e9.a0 a0Var = new e9.a0(2);
            a0Var.f3614g = str;
            a0Var.f3615h = str2;
            a0Var.i = mVar;
            a0Var.f3613f = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = a0Var;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static final void b(List list, w0.m mVar, int i, int i3, k0.s sVar, int i10) {
        ?? r02;
        w0.m mVar2;
        int i11;
        int i12;
        k0.s sVar2;
        w0.j jVar;
        int i13;
        boolean z10;
        boolean z11;
        int i14;
        k0.s sVar3;
        k0.s sVar4 = sVar;
        sVar4.Z(-683897024);
        int i15 = i10 | (sVar4.h(list) ? 4 : 2) | 3504;
        if (sVar4.P(i15 & 1, (i15 & 1171) != 1170)) {
            boolean zIsEmpty = list.isEmpty();
            w0.j jVar2 = w0.j.f15113c;
            if (zIsEmpty) {
                k0.v1 v1VarS = sVar4.s();
                if (v1VarS != null) {
                    i1 i1Var = new i1(0);
                    i1Var.f11660f = list;
                    i1Var.f11661g = jVar2;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = i1Var;
                    return;
                }
                return;
            }
            boolean z12 = list.size() > 6;
            List listJ0 = z12 ? kb.l.J0(list, 6) : list;
            w.r0 r0VarA = w.p0.a(w.k.e(-8), w0.b.f15098o, sVar4, 54);
            int iHashCode = Long.hashCode(sVar4.T);
            s0.g gVarL = sVar4.l();
            w0.m mVarM = t.o.m(sVar4, jVar2);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar4.b0();
            if (sVar4.S) {
                sVar4.k(zVar);
            } else {
                sVar4.l0();
            }
            k0.z.B(r0VarA, sVar4, u1.i.f13836e);
            k0.z.B(gVarL, sVar4, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar4.S || !yb.k.a(sVar4.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar4, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar4, u1.i.f13834c);
            sVar4.X(-636763013);
            int i16 = 0;
            for (Object obj : listJ0) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    ac.a.a0();
                    throw null;
                }
                u8.a aVar = (u8.a) obj;
                a(aVar.f14185a, aVar.f14187c, t.m0.l(jVar2, i16), sVar4, 384);
                i16 = i17;
            }
            sVar4.q(false);
            if (z12) {
                sVar4.X(1735506595);
                w0.m mVarF = androidx.compose.foundation.layout.c.f(t.m0.l(jVar2, listJ0.size()), 28);
                a0.d dVar = a0.e.f7a;
                d1.l0 l0Var = new d1.l0(f11762e);
                BorderModifierNodeElement borderModifierNodeElement = new BorderModifierNodeElement();
                borderModifierNodeElement.f840c = (float) 1.5d;
                borderModifierNodeElement.f841f = l0Var;
                borderModifierNodeElement.f842g = dVar;
                VarHandle.storeStoreFence();
                w0.m mVarB = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(mVarF.d(borderModifierNodeElement), dVar), f11761d, d1.f0.f2972a);
                s1.f0 f0VarE = w.p.e(w0.b.i, false);
                int iHashCode2 = Long.hashCode(sVar4.T);
                s0.g gVarL2 = sVar4.l();
                w0.m mVarM2 = t.o.m(sVar4, mVarB);
                u1.j.f13840e.getClass();
                u1.z zVar2 = u1.i.f13833b;
                sVar4.b0();
                if (sVar4.S) {
                    sVar4.k(zVar2);
                } else {
                    sVar4.l0();
                }
                k0.z.B(f0VarE, sVar4, u1.i.f13836e);
                k0.z.B(gVarL2, sVar4, u1.i.f13835d);
                u1.h hVar2 = u1.i.f13837f;
                if (sVar4.S || !yb.k.a(sVar4.M(), Integer.valueOf(iHashCode2))) {
                    k0.a.y(iHashCode2, sVar4, iHashCode2, hVar2);
                }
                k0.z.B(mVarM2, sVar4, u1.i.f13834c);
                jVar = jVar2;
                i13 = 6;
                i14 = 28;
                z10 = true;
                h0.t1.b(k0.a.j(list.size(), "+"), null, f11759b, com.stepos.statsrpk.h.t(10), g2.k.f4253h, 0L, null, 0L, 0, false, 1, 0, null, sVar, 200064, 3072, 122834);
                k0.s sVar5 = sVar;
                sVar5.q(true);
                z11 = false;
                sVar3 = sVar5;
            } else {
                jVar = jVar2;
                i13 = 6;
                z10 = true;
                z11 = false;
                i14 = 28;
                sVar4.X(1726866182);
                sVar3 = sVar4;
            }
            sVar3.q(z11);
            sVar3.q(z10);
            mVar2 = jVar;
            i11 = i13;
            i12 = i14;
            r02 = z10;
            sVar2 = sVar3;
        } else {
            r02 = 1;
            sVar4.S();
            mVar2 = mVar;
            i11 = i;
            i12 = i3;
            sVar2 = sVar4;
        }
        k0.v1 v1VarS2 = sVar2.s();
        if (v1VarS2 != null) {
            o0 o0Var = new o0(r02);
            o0Var.i = list;
            o0Var.f11833f = mVar2;
            o0Var.f11834g = i11;
            o0Var.f11835h = i12;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = o0Var;
        }
    }

    public static final void c(u8.a aVar, w0.m mVar, k0.s sVar, int i) {
        k0.s sVar2;
        aVar.getClass();
        sVar.Z(797796659);
        int i3 = i | (sVar.h(aVar) ? 4 : 2) | 48;
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            a0.d dVarA = a0.e.a(12);
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            e9.m mVar2 = new e9.m(11);
            mVar2.f3688f = aVar;
            VarHandle.storeStoreFence();
            sVar2 = sVar;
            h0.q1.a(mVarB, dVarA, f11760c, 0L, 0.0f, 0.0f, s0.h.d(-1288548018, mVar2, sVar), sVar2, 12583296, 120);
            mVar = jVar;
        } else {
            sVar2 = sVar;
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            j9.i iVar = new j9.i(7);
            iVar.f6671f = aVar;
            iVar.f6672g = mVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = iVar;
        }
    }

    public static final void d(List list, w0.m mVar, int i, k0.s sVar, int i3) {
        int i10;
        w0.m mVar2;
        int i11;
        list.getClass();
        sVar.Z(1276756562);
        int i12 = 2;
        int i13 = i3 | (sVar.h(list) ? 4 : 2) | 432;
        int i14 = 0;
        if (!sVar.P(i13 & 1, (i13 & 147) != 146)) {
            i10 = 1;
            sVar.S();
            mVar2 = mVar;
            i11 = i;
        } else {
            if (list.isEmpty()) {
                k0.v1 v1VarS = sVar.s();
                if (v1VarS != null) {
                    hc.p pVar = new hc.p(i12);
                    pVar.f5466f = list;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = pVar;
                    return;
                }
                return;
            }
            boolean zD = sVar.d(list.size());
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            if (zD || objM == obj) {
                objM = k0.z.v(Boolean.FALSE);
                sVar.i0(objM);
            }
            k0.c1 c1Var = (k0.c1) objM;
            List listJ0 = (((Boolean) c1Var.getValue()).booleanValue() || list.size() <= 3) ? list : kb.l.J0(list, 3);
            int size = list.size() - listJ0.size();
            if (size < 0) {
                size = 0;
            }
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            w.v vVarA = w.u.a(w.k.e(8), w0.b.f15100q, sVar, 6);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarB);
            u1.j.f13840e.getClass();
            xb.a aVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(aVar);
            } else {
                sVar.l0();
            }
            k0.z.B(vVarA, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            sVar.X(2120782981);
            Iterator it = listJ0.iterator();
            while (it.hasNext()) {
                c((u8.a) it.next(), null, sVar, 0);
            }
            sVar.q(false);
            if (size > 0) {
                sVar.X(1319866947);
                a0.d dVarA = a0.e.a(12);
                w0.m mVarB2 = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
                boolean zF = sVar.f(c1Var);
                Object objM2 = sVar.M();
                Object obj2 = objM2;
                if (zF || objM2 == obj) {
                    e9.s sVar2 = new e9.s(8);
                    sVar2.f3721f = c1Var;
                    VarHandle.storeStoreFence();
                    sVar.i0(sVar2);
                    obj2 = sVar2;
                }
                w0.m mVarE = androidx.compose.foundation.a.e(mVarB2, false, null, (xb.a) obj2, 7);
                h1 h1Var = new h1(i14);
                h1Var.f11642f = size;
                VarHandle.storeStoreFence();
                mVar2 = jVar;
                h0.q1.a(mVarE, dVarA, f11761d, 0L, 0.0f, 0.0f, s0.h.d(1855505958, h1Var, sVar), sVar, 12583296, 120);
            } else {
                mVar2 = jVar;
                sVar.X(1313335526);
            }
            sVar.q(false);
            i10 = 1;
            sVar.q(true);
            i11 = 3;
        }
        k0.v1 v1VarS2 = sVar.s();
        if (v1VarS2 != null) {
            l9.e eVar = new l9.e(i10);
            eVar.f7774f = list;
            eVar.f7775g = mVar2;
            eVar.f7776h = i11;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = eVar;
        }
    }

    public static final void e(String str, String str2, String str3, w0.m mVar, k0.s sVar, int i) {
        String str4;
        int i3;
        u1.h hVar;
        u1.h hVar2;
        u1.h hVar3;
        u1.z zVar;
        w0.j jVar;
        int i10;
        u1.h hVar4;
        boolean z10;
        k0.s sVar2 = sVar;
        sVar2.Z(707118462);
        int i11 = i | (sVar2.f(str) ? 4 : 2) | (sVar2.f(str2) ? 32 : 16) | (sVar2.f(str3) ? 256 : 128);
        int i12 = 1;
        if (sVar2.P(i11 & 1, (i11 & 1171) != 1170)) {
            Context context = (Context) sVar2.j(AndroidCompositionLocals_androidKt.f982b);
            boolean zH = ((i11 & 896) == 256) | sVar2.h(context);
            Object objM = sVar2.M();
            k0.y0 y0Var = k0.m.f6974a;
            if (zH || objM == y0Var) {
                objM = new k1(context, str3, null, i12);
                sVar2.i0(objM);
            }
            int i13 = i11 >> 3;
            k0.c1 c1VarW = k0.z.w(str3, (xb.p) objM, sVar2, (i13 & 112) | 6);
            int i14 = i11 & 14;
            boolean z11 = i14 == 4;
            Object objM2 = sVar2.M();
            if (z11 || objM2 == y0Var) {
                objM2 = f(str);
                sVar2.i0(objM2);
            }
            String str5 = (String) objM2;
            boolean z12 = i14 == 4;
            Object objM3 = sVar2.M();
            if (z12 || objM3 == y0Var) {
                int iHashCode = str.hashCode() & Reader.READ_DONE;
                List list = f11763f;
                objM3 = d1.p.a(((d1.p) list.get(iHashCode % list.size())).f3026a);
                sVar2.i0(objM3);
            }
            long j10 = ((d1.p) objM3).f3026a;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(mVar, 1.0f);
            w.r0 r0VarA = w.p0.a(w.k.f14990a, w0.b.f15098o, sVar2, 48);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarB);
            u1.j.f13840e.getClass();
            u1.z zVar2 = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar2);
            } else {
                sVar2.l0();
            }
            u1.h hVar5 = u1.i.f13836e;
            k0.z.B(r0VarA, sVar2, hVar5);
            u1.h hVar6 = u1.i.f13835d;
            k0.z.B(gVarL, sVar2, hVar6);
            u1.h hVar7 = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar2, iHashCode2, hVar7);
            }
            u1.h hVar8 = u1.i.f13834c;
            k0.z.B(mVarM, sVar2, hVar8);
            w0.j jVar2 = w0.j.f15113c;
            w0.m mVarB2 = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.f(jVar2, 40), a0.e.f7a), j10, d1.f0.f2972a);
            s1.f0 f0VarE = w.p.e(w0.b.i, false);
            int iHashCode3 = Long.hashCode(sVar2.T);
            s0.g gVarL2 = sVar2.l();
            w0.m mVarM2 = t.o.m(sVar2, mVarB2);
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar2);
            } else {
                sVar2.l0();
            }
            k0.z.B(f0VarE, sVar2, hVar5);
            k0.z.B(gVarL2, sVar2, hVar6);
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode3))) {
                k0.a.y(iHashCode3, sVar2, iHashCode3, hVar7);
            }
            k0.z.B(mVarM2, sVar2, hVar8);
            d1.e eVar = (d1.e) c1VarW.getValue();
            if (eVar != null) {
                sVar2.X(-32964682);
                FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
                s1.j.f11260d.getClass();
                t.m0.c(eVar, fillElement, sVar2, 25008, 232);
                sVar2.q(false);
                hVar2 = hVar8;
                zVar = zVar2;
                hVar4 = hVar6;
                hVar3 = hVar5;
                jVar = jVar2;
                i10 = 0;
                hVar = hVar7;
            } else {
                sVar2.X(-32712435);
                hVar = hVar7;
                hVar2 = hVar8;
                hVar3 = hVar5;
                zVar = zVar2;
                jVar = jVar2;
                i10 = 0;
                hVar4 = hVar6;
                h0.t1.b(str5, null, d1.p.f3020c, com.stepos.statsrpk.h.t(13), g2.k.f4253h, 0L, null, 0L, 0, false, 1, 0, null, sVar, 200064, 3072, 122834);
                sVar2 = sVar;
                sVar2.q(false);
            }
            sVar2.q(true);
            t0.a.b(sVar2, androidx.compose.foundation.layout.c.h(jVar, 10));
            w0.m mVarA = w.s0.a();
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, i10);
            int iHashCode4 = Long.hashCode(sVar2.T);
            s0.g gVarL3 = sVar2.l();
            w0.m mVarM3 = t.o.m(sVar2, mVarA);
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(vVarA, sVar2, hVar3);
            k0.z.B(gVarL3, sVar2, hVar4);
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode4))) {
                k0.a.y(iHashCode4, sVar2, iHashCode4, hVar);
            }
            k0.z.B(mVarM3, sVar2, hVar2);
            k0.s2 s2Var = h0.w1.f5235a;
            h0.t1.b(str, null, f11758a, 0L, g2.k.f4253h, 0L, null, 0L, 2, false, 1, 0, ((h0.v1) sVar2.j(s2Var)).f5221k, sVar, i14 | 196992, 3120, 55258);
            sVar2 = sVar;
            if (str2 == null || hc.h.g0(str2)) {
                str4 = str2;
                z10 = false;
                sVar2.X(432350270);
            } else {
                sVar2.X(437258903);
                str4 = str2;
                h0.t1.b(str4, null, f11759b, 0L, null, 0L, null, 0L, 2, false, 1, 0, ((h0.v1) sVar2.j(s2Var)).f5224n, sVar, (i13 & 14) | 384, 3120, 55290);
                sVar2 = sVar;
                z10 = false;
            }
            sVar2.q(z10);
            i3 = 1;
            sVar2.q(true);
            sVar2.q(true);
        } else {
            str4 = str2;
            i3 = 1;
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            j9.v vVar = new j9.v(i3);
            vVar.f6723f = str;
            vVar.f6725h = str4;
            vVar.i = str3;
            vVar.f6724g = mVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = vVar;
        }
    }

    public static final String f(String str) {
        str.getClass();
        String string = hc.h.w0(str).toString();
        return string.length() == 0 ? "?" : string.length() == 1 ? string : hc.h.u0(2, string);
    }
}

package j9;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import d1.e0;
import d1.f0;
import d1.l0;
import e9.d0;
import h0.o0;
import h0.q1;
import h0.t1;
import i1.h0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import k0.v1;
import w.p0;
import w.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f6633a = f0.c(4278190080L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f6634b = f0.c(4280032286L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f6635c = f0.c(4294309367L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f6636d = f0.c(4287532691L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f6637e = f0.c(4287532691L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f6638f = f0.c(4281303295L);

    /* renamed from: g, reason: collision with root package name */
    public static final long f6639g = f0.c(4281648985L);

    /* renamed from: h, reason: collision with root package name */
    public static final long f6640h = f0.c(4294924890L);
    public static final long i = f0.c(4281084974L);

    /* renamed from: j, reason: collision with root package name */
    public static final long f6641j = f0.c(4284703590L);

    /* renamed from: k, reason: collision with root package name */
    public static final long f6642k = f0.c(4282927178L);

    /* renamed from: l, reason: collision with root package name */
    public static final long f6643l = f0.c(2566914048L);

    /* renamed from: m, reason: collision with root package name */
    public static final long f6644m = f0.c(4281084974L);

    /* renamed from: n, reason: collision with root package name */
    public static final ArrayList f6645n;

    /* renamed from: o, reason: collision with root package name */
    public static final long f6646o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f6647p;

    static {
        ec.b bVar = new ec.b('A', 'Z');
        ArrayList arrayList = new ArrayList(kb.m.m0(bVar, 10));
        Iterator it = bVar.iterator();
        while (true) {
            ec.a aVar = (ec.a) it;
            boolean z10 = aVar.f3752h;
            if (!z10) {
                f6645n = kb.l.G0(arrayList, "#");
                f6646o = f0.c(4282006076L);
                f6647p = f0.c(3429065574L);
                return;
            }
            int i3 = aVar.i;
            if (i3 != aVar.f3751g) {
                aVar.i = aVar.f3750f + i3;
            } else {
                if (!z10) {
                    g5.f.k();
                    return;
                }
                aVar.f3752h = false;
            }
            arrayList.add(String.valueOf((char) i3));
        }
    }

    public static final void a(String str, xb.a aVar, w0.m mVar, k0.s sVar, int i3) {
        int i10;
        w0.m mVar2;
        str.getClass();
        aVar.getClass();
        sVar.Z(1873016068);
        int i11 = i3 | (sVar.f(str) ? 4 : 2) | (sVar.h(aVar) ? 32 : 16) | 384;
        int i12 = 1;
        if (sVar.P(i11 & 1, (i11 & 147) != 146)) {
            a0.d dVarA = a0.e.a(999);
            d0 d0Var = new d0(i12);
            d0Var.f3637f = str;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(1108041177, d0Var, sVar);
            int i13 = ((i11 >> 3) & 14) | 24624;
            mVar2 = w0.j.f15113c;
            i10 = 2;
            q1.b(aVar, mVar2, false, dVarA, f6638f, 0L, 0.0f, null, null, cVarD, sVar, i13, 996);
        } else {
            i10 = 2;
            sVar.S();
            mVar2 = mVar;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            n nVar = new n(i10);
            nVar.f6692f = str;
            nVar.f6693g = aVar;
            nVar.f6694h = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = nVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0217  */
    /* JADX WARN: Type inference failed for: r7v10, types: [int] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(java.lang.String r40, xb.l r41, xb.l r42, w0.m r43, k0.s r44, int r45) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.b0.b(java.lang.String, xb.l, xb.l, w0.m, k0.s, int):void");
    }

    public static final void c(boolean z10, xb.a aVar, xb.a aVar2, w0.m mVar, k0.s sVar, int i3) {
        aVar.getClass();
        aVar2.getClass();
        sVar.Z(-568263921);
        int i10 = i3 | (sVar.g(z10) ? 4 : 2) | (sVar.h(aVar2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        int i11 = 0;
        int i12 = 1;
        if (sVar.P(i10 & 1, (i10 & 1171) != 1170)) {
            s sVar2 = new s(i11);
            sVar2.f6715f = aVar;
            sVar2.f6716g = aVar2;
            VarHandle.storeStoreFence();
            n9.c.a(z10, aVar, mVar, f6643l, false, s0.h.d(-995736319, sVar2, sVar), sVar, (i10 & 14) | 200112, 16);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            e9.f0 f0Var = new e9.f0(i12);
            f0Var.f3647f = z10;
            f0Var.f3648g = aVar;
            f0Var.i = aVar2;
            f0Var.f3649h = mVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = f0Var;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v10 */
    public static final void d(String str, boolean z10, boolean z11, xb.a aVar, k0.s sVar, int i3) {
        String str2;
        boolean z12;
        ?? r13;
        k0.s sVar2;
        boolean z13;
        k0.s sVar3 = sVar;
        w0.e eVar = w0.b.i;
        str.getClass();
        aVar.getClass();
        sVar3.Z(-1638132585);
        int i10 = i3 | (sVar3.f(str) ? 4 : 2) | (sVar3.g(z10) ? 32 : 16) | (sVar3.g(z11) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar3.h(aVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024);
        if (sVar3.P(i10 & 1, (i10 & 1171) != 1170)) {
            float f5 = z11 ? 1.0f : 0.38f;
            w0.j jVar = w0.j.f15113c;
            float f10 = 14;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(ac.a.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), f5).d(z11 ? l9.a.g(jVar, aVar) : jVar), 16, f10);
            r0 r0VarA = p0.a(w.k.f14994e, w0.b.f15098o, sVar3, 54);
            int iHashCode = Long.hashCode(sVar3.T);
            s0.g gVarL = sVar3.l();
            w0.m mVarM = t.o.m(sVar3, mVarG);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar3.b0();
            if (sVar3.S) {
                sVar3.k(zVar);
            } else {
                sVar3.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(r0VarA, sVar3, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar3, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar3.S || !yb.k.a(sVar3.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar3, iHashCode, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar3, hVar4);
            t1.b(str, null, f6635c, com.stepos.statsrpk.h.t(17), null, 0L, null, 0L, 0, false, 0, 0, null, sVar, (i10 & 14) | 3456, 0, 131058);
            str2 = str;
            k0.s sVar4 = sVar;
            e0 e0Var = f0.f2972a;
            z12 = z10;
            if (z12) {
                sVar4.X(1825775593);
                w0.m mVarB = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.f(jVar, 22), a0.e.f7a), f6638f, e0Var);
                s1.f0 f0VarE = w.p.e(eVar, false);
                int iHashCode2 = Long.hashCode(sVar4.T);
                s0.g gVarL2 = sVar4.l();
                w0.m mVarM2 = t.o.m(sVar4, mVarB);
                sVar4.b0();
                if (sVar4.S) {
                    sVar4.k(zVar);
                } else {
                    sVar4.l0();
                }
                k0.z.B(f0VarE, sVar4, hVar);
                k0.z.B(gVarL2, sVar4, hVar2);
                if (sVar4.S || !yb.k.a(sVar4.M(), Integer.valueOf(iHashCode2))) {
                    k0.a.y(iHashCode2, sVar4, iHashCode2, hVar3);
                }
                k0.z.B(mVarM2, sVar4, hVar4);
                o0.b(a.a.B(), androidx.compose.foundation.layout.c.f(jVar, f10), d1.p.f3020c, sVar4, 3504);
                z13 = true;
                sVar4.q(true);
                sVar4.q(false);
            } else {
                sVar4.X(1826268121);
                w0.m mVarF = androidx.compose.foundation.layout.c.f(jVar, 22);
                a0.d dVar = a0.e.f7a;
                w0.m mVarB2 = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.b.f(androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(mVarF, dVar), f6634b, e0Var), 2), dVar), d1.p.f3023f, e0Var);
                s1.f0 f0VarE2 = w.p.e(eVar, false);
                int iHashCode3 = Long.hashCode(sVar4.T);
                s0.g gVarL3 = sVar4.l();
                w0.m mVarM3 = t.o.m(sVar4, mVarB2);
                sVar4.b0();
                if (sVar4.S) {
                    sVar4.k(zVar);
                } else {
                    sVar4.l0();
                }
                k0.z.B(f0VarE2, sVar4, hVar);
                k0.z.B(gVarL3, sVar4, hVar2);
                if (sVar4.S || !yb.k.a(sVar4.M(), Integer.valueOf(iHashCode3))) {
                    k0.a.y(iHashCode3, sVar4, iHashCode3, hVar3);
                }
                k0.z.B(mVarM3, sVar4, hVar4);
                w.p.a(androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.f(jVar, 18), dVar), d1.p.c(0.5f, f6642k), e0Var), sVar4, 0);
                z13 = true;
                sVar4.q(true);
                sVar4.q(false);
            }
            sVar4.q(z13);
            sVar2 = sVar4;
            r13 = z13;
        } else {
            str2 = str;
            z12 = z10;
            r13 = 1;
            sVar3.S();
            sVar2 = sVar3;
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            b bVar = new b(r13);
            bVar.f6632h = str2;
            bVar.f6630f = z12;
            bVar.f6631g = z11;
            bVar.i = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = bVar;
        }
    }

    public static final void e(String str, w0.m mVar, k0.s sVar, int i3) {
        w0.m mVar2;
        str.getClass();
        sVar.Z(-49632713);
        int i10 = i3 | (sVar.f(str) ? 4 : 2) | 48;
        if (sVar.P(i10 & 1, (i10 & 19) != 18)) {
            w0.j jVar = w0.j.f15113c;
            t1.b(str, androidx.compose.foundation.layout.b.j(jVar, 4, 0.0f, 0.0f, 8, 6), f6637e, com.stepos.statsrpk.h.t(13), null, 0L, null, 0L, 0, false, 0, 0, null, sVar, (i10 & 14) | 3456, 0, 131056);
            mVar2 = jVar;
        } else {
            sVar.S();
            mVar2 = mVar;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            w wVar = new w(0);
            wVar.f6727f = str;
            wVar.f6728g = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = wVar;
        }
    }

    public static final void f(boolean z10, boolean z11, xb.a aVar, w0.m mVar, k0.s sVar, int i3) {
        int i10;
        w0.m mVar2;
        i1.f fVarD;
        aVar.getClass();
        sVar.Z(2014951689);
        if ((i3 & 6) == 0) {
            i10 = (sVar.g(z10) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        if ((i3 & 48) == 0) {
            i10 |= sVar.g(z11) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i10 |= sVar.h(aVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        int i11 = i10 | 3072;
        if (sVar.P(i11 & 1, (i11 & 1171) != 1170)) {
            long j10 = z10 ? f6640h : f6639g;
            float f5 = z11 ? 1.0f : 0.45f;
            mVar2 = w0.j.f15113c;
            w0.m mVarD = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(ac.a.g(androidx.compose.foundation.layout.c.f(mVar2, 28), f5), a0.e.f7a), j10, f0.f2972a).d(z11 ? androidx.compose.foundation.a.e(mVar2, false, null, aVar, 7) : mVar2);
            s1.f0 f0VarE = w.p.e(w0.b.i, false);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarD);
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
            if (z10) {
                fVarD = p5.f.f9724a;
                if (fVarD == null) {
                    i1.e eVar = new i1.e("Filled.Remove", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i12 = h0.f5700a;
                    l0 l0Var = new l0(d1.p.f3019b);
                    ArrayList arrayList = new ArrayList(32);
                    arrayList.add(new i1.n(19.0f, 13.0f));
                    arrayList.add(new i1.l(5.0f));
                    arrayList.add(new i1.z(-2.0f));
                    arrayList.add(new i1.t(14.0f));
                    arrayList.add(new i1.z(2.0f));
                    arrayList.add(i1.j.f5707c);
                    eVar.a(arrayList, 0, "", l0Var, 1.0f, null, 1.0f, 1.0f, 0, 2, 1.0f, 0.0f, 1.0f, 0.0f);
                    fVarD = eVar.d();
                    p5.f.f9724a = fVarD;
                }
            } else {
                i1.f fVarD2 = td.h.f13309c;
                if (fVarD2 == null) {
                    i1.e eVar2 = new i1.e("Filled.Add", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i13 = h0.f5700a;
                    l0 l0Var2 = new l0(d1.p.f3019b);
                    ha.c cVar = new ha.c();
                    ArrayList arrayList2 = cVar.f5430a;
                    cVar.f(19.0f, 13.0f);
                    cVar.d(-6.0f);
                    cVar.g(6.0f);
                    cVar.d(-2.0f);
                    cVar.g(-6.0f);
                    arrayList2.add(new i1.l(5.0f));
                    cVar.g(-2.0f);
                    cVar.d(6.0f);
                    arrayList2.add(new i1.a0(5.0f));
                    cVar.d(2.0f);
                    cVar.g(6.0f);
                    cVar.d(6.0f);
                    cVar.g(2.0f);
                    cVar.b();
                    eVar2.a(arrayList2, 0, "", l0Var2, 1.0f, null, 1.0f, 1.0f, 0, 2, 1.0f, 0.0f, 1.0f, 0.0f);
                    fVarD2 = eVar2.d();
                    td.h.f13309c = fVarD2;
                }
                fVarD = fVarD2;
            }
            o0.b(fVarD, androidx.compose.foundation.layout.c.f(mVar2, 16), d1.p.f3020c, sVar, 3504);
            sVar.q(true);
        } else {
            sVar.S();
            mVar2 = mVar;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            r rVar = new r(0);
            rVar.f6710f = z10;
            rVar.f6712h = z11;
            rVar.f6713j = aVar;
            rVar.f6711g = mVar2;
            rVar.i = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = rVar;
        }
    }
}

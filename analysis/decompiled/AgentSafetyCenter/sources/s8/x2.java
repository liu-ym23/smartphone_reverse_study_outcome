package s8;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class x2 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f12100a = d1.f0.c(4280032286L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f12101b = d1.f0.c(4281084974L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f12102c = d1.f0.c(4294309367L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f12103d = d1.f0.c(4287532691L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f12104e = d1.f0.c(4293256682L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f12105f = d1.f0.c(4281303295L);

    /* renamed from: g, reason: collision with root package name */
    public static final long f12106g = d1.f0.c(4294924890L);

    /* renamed from: h, reason: collision with root package name */
    public static final long f12107h = d1.f0.c(4282006076L);
    public static final long i = d1.f0.c(4282927178L);

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f12108j = 0;

    public static final void a(y2 y2Var, w0.m mVar, boolean z10, k0.s sVar, int i3) {
        int i10;
        boolean z11;
        k0.s sVar2 = sVar;
        sVar2.Z(1213235439);
        int i11 = i3 | (sVar2.h(y2Var) ? 4 : 2);
        if ((i3 & 48) == 0) {
            i11 |= sVar2.f(mVar) ? 32 : 16;
        }
        int i12 = i11 | 384;
        if (sVar2.P(i12 & 1, (i12 & 147) != 146)) {
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVar);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(vVarA, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            sVar2.X(882641215);
            String str = y2Var.f12125b;
            k0.s2 s2Var = h0.w1.f5235a;
            i10 = 0;
            h0.t1.b(str, null, f12102c, 0L, g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar2.j(s2Var)).f5221k, sVar, 196992, 0, 65498);
            sVar.q(false);
            List list = y2Var.f12138p;
            boolean zIsEmpty = list.isEmpty();
            w0.j jVar = w0.j.f15113c;
            if (zIsEmpty) {
                sVar.X(872207421);
            } else {
                sVar.X(882930445);
                t0.a.b(sVar, androidx.compose.foundation.layout.c.c(jVar, 10));
                l1.b(list, null, 0, 0, sVar, 0);
            }
            sVar.q(false);
            t0.a.b(sVar, androidx.compose.foundation.layout.c.c(jVar, 8));
            h0.t1.b(y2Var.f12126c, null, f12103d, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar.j(s2Var)).f5224n, sVar, 384, 0, 65530);
            sVar2 = sVar;
            z11 = true;
            sVar2.q(true);
        } else {
            i10 = 0;
            sVar2.S();
            z11 = z10;
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            n2 n2Var = new n2(i10);
            n2Var.f11821f = y2Var;
            n2Var.f11822g = mVar;
            n2Var.f11823h = z11;
            n2Var.i = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = n2Var;
        }
    }

    public static final void b(String str, long j10, boolean z10, w0.m mVar, xb.a aVar, k0.s sVar, int i3) {
        sVar.Z(-886542811);
        int i10 = i3 | (sVar.f(str) ? 4 : 2) | (sVar.g(z10) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.f(mVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(aVar) ? 16384 : 8192);
        if (sVar.P(i10 & 1, (i10 & 9363) != 9362)) {
            a0.d dVarA = a0.e.a(14);
            w0.m mVarE = androidx.compose.foundation.a.e(androidx.compose.foundation.layout.c.c(mVar, 48), z10, null, aVar, 6);
            o2 o2Var = new o2();
            o2Var.f11840c = z10;
            o2Var.f11841f = j10;
            o2Var.f11842g = str;
            VarHandle.storeStoreFence();
            h0.q1.a(mVarE, dVarA, f12107h, 0L, 0.0f, 0.0f, s0.h.d(124467904, o2Var, sVar), sVar, 12583296, 120);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            p2 p2Var = new p2();
            p2Var.f11871c = str;
            p2Var.f11872f = j10;
            p2Var.f11873g = z10;
            p2Var.f11874h = mVar;
            p2Var.i = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = p2Var;
        }
    }

    public static final void c(y2 y2Var, w0.m mVar, boolean z10, k0.s sVar, int i3) {
        int i10;
        boolean z11;
        k0.s sVar2 = sVar;
        sVar2.Z(-361257891);
        int i11 = i3 | (sVar2.h(y2Var) ? 4 : 2);
        if ((i3 & 48) == 0) {
            i11 |= sVar2.f(mVar) ? 32 : 16;
        }
        int i12 = i11 | 384;
        if (sVar2.P(i12 & 1, (i12 & 147) != 146)) {
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVar);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(vVarA, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            sVar2.X(-677054019);
            h0.t1.b(y2Var.f12125b, null, f12102c, 0L, g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar2.j(h0.w1.f5235a)).f5221k, sVar, 196992, 0, 65498);
            sVar.q(false);
            String strO = t2.a.o(R.string.home_note_image_collection_title, sVar);
            List<u8.k> list = y2Var.f12139q;
            ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
            for (u8.k kVar : list) {
                String string = hc.h.w0(kVar.f14219a).toString();
                if (string.length() == 0) {
                    string = hc.h.w0(kVar.f14220b).toString();
                }
                if (string.length() == 0) {
                    int iOrdinal = kVar.f14224f.ordinal();
                    string = (iOrdinal == 3 || iOrdinal == 4) ? strO : "";
                }
                arrayList.add(string);
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList.get(i13);
                i13++;
                if (!hc.h.g0((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            List listL0 = kb.l.L0(kb.l.N0(arrayList2));
            boolean zIsEmpty = listL0.isEmpty();
            w0.j jVar = w0.j.f15113c;
            if (zIsEmpty) {
                sVar.X(-688342917);
            } else {
                sVar.X(-676199256);
                t0.a.b(sVar, androidx.compose.foundation.layout.c.c(jVar, 10));
                d(listL0, null, sVar, 0);
            }
            sVar.q(false);
            t0.a.b(sVar, androidx.compose.foundation.layout.c.c(jVar, 8));
            h0.t1.b(y2Var.f12126c, null, f12103d, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar.j(h0.w1.f5235a)).f5224n, sVar, 384, 0, 65530);
            sVar2 = sVar;
            i10 = 1;
            sVar2.q(true);
            z11 = true;
        } else {
            i10 = 1;
            sVar2.S();
            z11 = z10;
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            n2 n2Var = new n2(i10);
            n2Var.f11821f = y2Var;
            n2Var.f11822g = mVar;
            n2Var.f11823h = z11;
            n2Var.i = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = n2Var;
        }
    }

    public static final void d(List list, w0.m mVar, k0.s sVar, int i3) {
        w0.m mVar2;
        sVar.Z(-108181837);
        int i10 = 4;
        int i11 = i3 | (sVar.h(list) ? 4 : 2) | 48;
        if (!sVar.P(i11 & 1, (i11 & 19) != 18)) {
            sVar.S();
            mVar2 = mVar;
        } else {
            if (list.isEmpty()) {
                k0.v1 v1VarS = sVar.s();
                if (v1VarS != null) {
                    hc.p pVar = new hc.p(i10);
                    pVar.f5466f = list;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = pVar;
                    return;
                }
                return;
            }
            float f5 = 8;
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            Object objM = sVar.M();
            Object obj = objM;
            if (objM == k0.m.f6974a) {
                v2 v2Var = new v2();
                v2Var.f12028a = f5;
                v2Var.f12029b = f5;
                VarHandle.storeStoreFence();
                sVar.i0(v2Var);
                obj = v2Var;
            }
            s1.f0 f0Var = (s1.f0) obj;
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
            k0.z.B(f0Var, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            sVar.X(1034185347);
            int i12 = 0;
            for (Object obj2 : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    ac.a.a0();
                    throw null;
                }
                String str = (String) obj2;
                Integer numValueOf = Integer.valueOf(i12);
                k0.e2 e2Var = sVar.G;
                int i14 = e2Var.f6888g;
                Object objF = k0.t.f(i14 < e2Var.f6889h ? e2Var.p(e2Var.f6883b, i14) : null, numValueOf, str);
                if (objF == null) {
                    objF = new k0.u0(numValueOf, str);
                }
                sVar.T(objF, -1904367158, 0, null);
                w0.j jVar2 = jVar;
                a0.d dVarA = a0.e.a(f5);
                e9.d0 d0Var = new e9.d0(3);
                d0Var.f3637f = str;
                VarHandle.storeStoreFence();
                h0.q1.a(null, dVarA, f12107h, 0L, 0.0f, 0.0f, s0.h.d(1807063432, d0Var, sVar), sVar, 12583296, 121);
                sVar.q(false);
                i12 = i13;
                jVar = jVar2;
            }
            sVar.q(false);
            sVar.q(true);
            mVar2 = jVar;
        }
        k0.v1 v1VarS2 = sVar.s();
        if (v1VarS2 != null) {
            i1 i1Var = new i1(1);
            i1Var.f11660f = list;
            i1Var.f11661g = mVar2;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = i1Var;
        }
    }

    public static final void e(int i3, xb.a aVar, w0.m mVar, k0.s sVar, int i10) {
        int i11;
        w0.m mVar2;
        aVar.getClass();
        sVar.Z(223240797);
        int i12 = i10 | (sVar.d(i3) ? 4 : 2) | (sVar.h(aVar) ? 32 : 16) | 384;
        if (sVar.P(i12 & 1, (i12 & 147) != 146)) {
            String strP = t2.a.p(R.string.action_list_undo_all_actions, new Object[]{Integer.valueOf(i3)}, sVar);
            d2.l0 l0Var = ((h0.v1) sVar.j(h0.w1.f5235a)).f5223m;
            g2.k kVar = g2.k.f4253h;
            w0.j jVar = w0.j.f15113c;
            i11 = 1;
            h0.t1.b(strP, androidx.compose.foundation.layout.b.h(androidx.compose.foundation.a.e(jVar, false, null, aVar, 7), 0.0f, 8, 1), f12105f, 0L, kVar, 0L, null, 0L, 0, false, 0, 0, l0Var, sVar, 196992, 0, 65496);
            mVar2 = jVar;
        } else {
            i11 = 1;
            sVar.S();
            mVar2 = mVar;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            m2 m2Var = new m2(i11);
            m2Var.f11801f = i3;
            m2Var.f11802g = aVar;
            m2Var.f11803h = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = m2Var;
        }
    }

    public static final void f(y2 y2Var, boolean z10, xb.a aVar, k0.s sVar, int i3) {
        sVar.Z(333939926);
        int i10 = i3 | (sVar.h(y2Var) ? 4 : 2) | (sVar.g(z10) ? 32 : 16) | (sVar.h(aVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        int i11 = 0;
        int i12 = 1;
        if (sVar.P(i10 & 1, (i10 & 147) != 146)) {
            a0.d dVarA = a0.e.a(16);
            w0.m mVarB = androidx.compose.foundation.layout.c.b(w0.j.f15113c, 1.0f);
            q2 q2Var = new q2(i11);
            q2Var.f11907g = z10;
            q2Var.f11908h = aVar;
            q2Var.f11906f = y2Var;
            VarHandle.storeStoreFence();
            h0.q1.a(mVarB, dVarA, f12101b, 0L, 0.0f, 0.0f, s0.h.d(1329070939, q2Var, sVar), sVar, 12583302, 120);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            q2 q2Var2 = new q2(i12);
            q2Var2.f11906f = y2Var;
            q2Var2.f11907g = z10;
            q2Var2.f11908h = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = q2Var2;
        }
    }

    public static final void g(a3 a3Var, boolean z10, xb.a aVar, xb.l lVar, w0.m mVar, k0.s sVar, int i3) {
        int i10;
        k0.v1 v1VarS;
        r2 r2Var;
        aVar.getClass();
        lVar.getClass();
        sVar.Z(-1660434683);
        int i11 = 2;
        if ((i3 & 6) == 0) {
            i10 = (sVar.h(a3Var) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        if ((i3 & 48) == 0) {
            i10 |= sVar.g(z10) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i10 |= sVar.h(aVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i3 & 3072) == 0) {
            i10 |= sVar.h(lVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i3 & 24576) == 0) {
            i10 |= sVar.f(mVar) ? 16384 : 8192;
        }
        int i12 = 0;
        int i13 = 1;
        if (sVar.P(i10 & 1, (i10 & 9363) != 9362)) {
            boolean zH = sVar.h(a3Var);
            Object objM = sVar.M();
            k0.y0 y0Var = k0.m.f6974a;
            nb.c cVar = null;
            if (zH || objM == y0Var) {
                objM = new k8.f(a3Var, cVar, i11);
                sVar.i0(objM);
            }
            k0.z.h(a3Var, sVar, (xb.p) objM);
            Object objM2 = sVar.M();
            if (objM2 == y0Var) {
                objM2 = k0.z.v(null);
                sVar.i0(objM2);
            }
            k0.c1 c1Var = (k0.c1) objM2;
            if (a3Var != null) {
                c1Var.setValue(a3Var);
            }
            a3 a3Var2 = (a3) c1Var.getValue();
            if (a3Var2 == null) {
                v1VarS = sVar.s();
                if (v1VarS != null) {
                    r2Var = new r2(i12);
                    r2Var.f11925f = a3Var;
                    r2Var.f11926g = z10;
                    r2Var.f11927h = aVar;
                    r2Var.i = lVar;
                    r2Var.f11928j = mVar;
                    r2Var.f11929k = i3;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = r2Var;
                }
                return;
            }
            int i14 = i10;
            boolean z11 = a3Var != null;
            s2 s2Var = new s2(0);
            s2Var.f11960f = a3Var2;
            s2Var.f11961g = z10;
            s2Var.f11962h = aVar;
            s2Var.i = lVar;
            VarHandle.storeStoreFence();
            n9.c.a(z11, aVar, mVar, 0L, !z10, s0.h.d(1291719251, s2Var, sVar), sVar, ((i14 >> 3) & 112) | 196608 | ((i14 >> 6) & 896), 8);
        } else {
            sVar.S();
        }
        v1VarS = sVar.s();
        if (v1VarS != null) {
            r2Var = new r2(i13);
            r2Var.f11925f = a3Var;
            r2Var.f11926g = z10;
            r2Var.f11927h = aVar;
            r2Var.i = lVar;
            r2Var.f11928j = mVar;
            r2Var.f11929k = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = r2Var;
        }
    }

    public static final void h(a3 a3Var, boolean z10, xb.a aVar, xb.l lVar, k0.s sVar, int i3) {
        xb.l lVar2;
        int i10;
        xb.a aVar2;
        k0.s sVar2;
        int i11;
        int i12;
        boolean z11;
        String strO;
        k0.c1 c1Var;
        k0.y0 y0Var;
        int i13;
        boolean z12;
        w0.j jVar;
        int i14;
        k0.s sVar3;
        float f5;
        int i15;
        k0.s sVar4;
        k0.s sVar5;
        Object obj;
        String strO2;
        Object obj2;
        k0.y0 y0Var2;
        Object obj3;
        k0.s sVar6 = sVar;
        sVar6.Z(-1409635379);
        int i16 = i3 | (sVar6.h(a3Var) ? 4 : 2) | (sVar6.g(z10) ? 32 : 16) | (sVar6.h(aVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar6.h(lVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024);
        if (sVar6.P(i16 & 1, (i16 & 1171) != 1170)) {
            boolean zF = sVar6.f(a3Var);
            Object objM = sVar6.M();
            k0.y0 y0Var3 = k0.m.f6974a;
            Object obj4 = objM;
            if (zF || objM == y0Var3) {
                k0.k1 k1VarV = k0.z.v(a3Var.f11452b);
                sVar6.i0(k1VarV);
                obj4 = k1VarV;
            }
            k0.c1 c1Var2 = (k0.c1) obj4;
            List list = (List) c1Var2.getValue();
            if (list == null || !list.isEmpty()) {
                Iterator it = list.iterator();
                int i17 = 0;
                while (it.hasNext()) {
                    if (((y2) it.next()).f12140r && (i17 = i17 + 1) < 0) {
                        ac.a.Z();
                        throw null;
                    }
                }
                i11 = i17;
            } else {
                i11 = 0;
            }
            w0.j jVar2 = w0.j.f15113c;
            float f10 = 12;
            float f11 = 20;
            w0.m mVarB = androidx.compose.foundation.a.b(com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.b.g(t2.a.l(androidx.compose.foundation.layout.c.b(jVar2, 1.0f)), f10, f10), a0.e.a(f11)), f12100a, d1.f0.f2972a);
            Object objM2 = sVar6.M();
            Object obj5 = objM2;
            if (objM2 == y0Var3) {
                v.k kVarA = t0.a.a();
                sVar6.i0(kVarA);
                obj5 = kVarA;
            }
            v.k kVar = (v.k) obj5;
            Object objM3 = sVar6.M();
            Object obj6 = objM3;
            if (objM3 == y0Var3) {
                androidx.room.c cVar = new androidx.room.c(17);
                sVar6.i0(cVar);
                obj6 = cVar;
            }
            w0.m mVarD = androidx.compose.foundation.a.d(mVarB, kVar, null, false, null, (xb.a) obj6, 28);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar6, 0);
            int iHashCode = Long.hashCode(sVar6.T);
            s0.g gVarL = sVar6.l();
            w0.m mVarM = t.o.m(sVar6, mVarD);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar6.b0();
            if (sVar6.S) {
                sVar6.k(zVar);
            } else {
                sVar6.l0();
            }
            k0.z.B(vVarA, sVar6, u1.i.f13836e);
            k0.z.B(gVarL, sVar6, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar6.S || !yb.k.a(sVar6.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar6, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar6, u1.i.f13834c);
            z2 z2Var = a3Var.f11451a;
            int iOrdinal = z2Var.ordinal();
            if (iOrdinal != 0) {
                i12 = 1;
                if (iOrdinal != 1) {
                    sVar6.X(1518925378);
                    sVar6.q(false);
                    g5.f.a();
                    return;
                } else {
                    sVar6.X(1518930293);
                    strO = t2.a.o(R.string.revoke_dialog_title_batch, sVar6);
                    z11 = false;
                    sVar6.q(false);
                }
            } else {
                i12 = 1;
                z11 = false;
                sVar6.X(1518927286);
                strO = t2.a.o(R.string.revoke_dialog_title_single, sVar6);
                sVar6.q(false);
            }
            w0.m mVarG = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), f11, f11);
            k0.s2 s2Var = h0.w1.f5235a;
            int i18 = i12;
            h0.t1.b(strO, mVarG, f12102c, 0L, g2.k.i, 0L, n2.k.a(3), 0L, 0, false, 0, 0, ((h0.v1) sVar6.j(s2Var)).f5219h, sVar, 197040, 0, 64984);
            k0.s sVar7 = sVar;
            int iOrdinal2 = z2Var.ordinal();
            if (iOrdinal2 == 0) {
                c1Var = c1Var2;
                y0Var = y0Var3;
                sVar7.X(-157295406);
                y2 y2Var = (y2) kb.l.x0((List) c1Var.getValue());
                if (y2Var != null) {
                    u8.p pVar = y2Var.f12134l;
                    sVar7.X(-157216077);
                    if (pVar == u8.p.f14244f || !y2Var.f12138p.isEmpty() || y2Var.f12135m != null) {
                        i13 = i16;
                        z12 = false;
                        jVar = jVar2;
                        i14 = 16;
                        sVar7.X(-157215488);
                        float f12 = 16;
                        a(y2Var, androidx.compose.foundation.layout.b.j(androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.b(jVar, 1.0f), f12, 0.0f, 2), 0.0f, 0.0f, 0.0f, f12, 7), false, sVar7, 48);
                        sVar7.q(false);
                        sVar3 = sVar7;
                    } else if (pVar == u8.p.f14245g || !y2Var.f12139q.isEmpty()) {
                        i13 = i16;
                        z12 = false;
                        jVar = jVar2;
                        i14 = 16;
                        sVar7.X(-156838621);
                        float f13 = 16;
                        c(y2Var, androidx.compose.foundation.layout.b.j(androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.b(jVar, 1.0f), f13, 0.0f, 2), 0.0f, 0.0f, 0.0f, f13, 7), false, sVar7, 48);
                        sVar7.q(false);
                        sVar3 = sVar7;
                    } else {
                        sVar7.X(-156465133);
                        i13 = i16;
                        jVar = jVar2;
                        h0.t1.b(y2Var.f12126c, androidx.compose.foundation.layout.b.j(androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), f11, 0.0f, 2), 0.0f, 0.0f, 0.0f, f10, 7), f12103d, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar7.j(s2Var)).f5221k, sVar, 432, 0, 65528);
                        k0.s sVar8 = sVar;
                        List listR = g1.r(y2Var);
                        if (listR.isEmpty()) {
                            i15 = -162890689;
                            i14 = 16;
                            z12 = false;
                        } else {
                            Iterator it2 = listR.iterator();
                            while (it2.hasNext()) {
                                if (e3.f(e3.h((String) it2.next()))) {
                                    sVar8.X(-155938226);
                                    e3.b(g1.r(y2Var), y2Var.f12130g, y2Var.f12131h, androidx.compose.foundation.layout.b.h(jVar, f11, 0.0f, 2), 72, sVar, 27648, 0);
                                    k0.s sVar9 = sVar;
                                    i14 = 16;
                                    t0.a.b(sVar9, androidx.compose.foundation.layout.c.c(jVar, 16));
                                    z12 = false;
                                    sVar4 = sVar9;
                                    break;
                                }
                            }
                            i14 = 16;
                            z12 = false;
                            i15 = -162890689;
                        }
                        sVar8.X(i15);
                        sVar4 = sVar8;
                        sVar4.q(z12);
                        sVar4.q(z12);
                        sVar3 = sVar4;
                    }
                } else {
                    i13 = i16;
                    z12 = false;
                    jVar = jVar2;
                    i14 = 16;
                    sVar7.X(-162890689);
                    sVar3 = sVar7;
                }
                sVar3.q(z12);
                sVar3.q(z12);
                f5 = 1.0f;
                sVar5 = sVar3;
            } else {
                if (iOrdinal2 != i18) {
                    sVar7.X(1518945687);
                    sVar7.q(false);
                    g5.f.a();
                    return;
                }
                sVar7.X(-155339802);
                w0.m mVarH = androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.d(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), 0.0f, 360, i18), 16, 0.0f, 2);
                w.g gVarE = w.k.e(f10);
                int i19 = (sVar7.f(c1Var2) ? 1 : 0) | ((i16 & 112) == 32 ? i18 : 0);
                Object objM4 = sVar7.M();
                if (i19 == 0) {
                    y0Var2 = y0Var3;
                    obj3 = objM4;
                    if (objM4 == y0Var2) {
                    }
                    c1Var = c1Var2;
                    y0Var = y0Var2;
                    f5 = 1.0f;
                    t1.e.a(24582, 238, sVar, null, gVarE, null, null, mVarH, null, (xb.l) obj3, false);
                    k0.s sVar10 = sVar;
                    sVar10.q(false);
                    i13 = i16;
                    z12 = false;
                    jVar = jVar2;
                    i14 = 16;
                    sVar5 = sVar10;
                } else {
                    y0Var2 = y0Var3;
                }
                t2 t2Var = new t2();
                t2Var.f11982c = c1Var2;
                t2Var.f11983f = z10;
                VarHandle.storeStoreFence();
                sVar7.i0(t2Var);
                obj3 = t2Var;
                c1Var = c1Var2;
                y0Var = y0Var2;
                f5 = 1.0f;
                t1.e.a(24582, 238, sVar, null, gVarE, null, null, mVarH, null, (xb.l) obj3, false);
                k0.s sVar102 = sVar;
                sVar102.q(false);
                i13 = i16;
                z12 = false;
                jVar = jVar2;
                i14 = 16;
                sVar5 = sVar102;
            }
            w0.m mVarB2 = androidx.compose.foundation.layout.c.b(jVar, f5);
            float f14 = i14;
            w0.m mVarG2 = androidx.compose.foundation.layout.b.g(mVarB2, f14, f14);
            w.r0 r0VarA = w.p0.a(w.k.e(f10), w0.b.f15097n, sVar5, 6);
            int iHashCode2 = Long.hashCode(sVar5.T);
            s0.g gVarL2 = sVar5.l();
            w0.m mVarM2 = t.o.m(sVar5, mVarG2);
            u1.j.f13840e.getClass();
            u1.z zVar2 = u1.i.f13833b;
            sVar5.b0();
            if (sVar5.S) {
                sVar5.k(zVar2);
            } else {
                sVar5.l0();
            }
            k0.z.B(r0VarA, sVar5, u1.i.f13836e);
            k0.z.B(gVarL2, sVar5, u1.i.f13835d);
            u1.h hVar2 = u1.i.f13837f;
            if (sVar5.S || !yb.k.a(sVar5.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar5, iHashCode2, hVar2);
            }
            k0.z.B(mVarM2, sVar5, u1.i.f13834c);
            String strO3 = t2.a.o(R.string.revoke_dialog_cancel, sVar5);
            boolean z13 = !z10;
            w0.m mVarA = w.s0.a();
            int i20 = i13;
            boolean z14 = (i20 & 896) == 256 ? true : z12;
            Object objM5 = sVar5.M();
            k0.y0 y0Var4 = y0Var;
            if (z14 || objM5 == y0Var4) {
                ab.e eVar = new ab.e(13);
                aVar2 = aVar;
                eVar.f393f = aVar2;
                VarHandle.storeStoreFence();
                sVar5.i0(eVar);
                obj = eVar;
            } else {
                aVar2 = aVar;
                obj = objM5;
            }
            b(strO3, f12105f, z13, mVarA, (xb.a) obj, sVar5, 48);
            int iOrdinal3 = z2Var.ordinal();
            if (iOrdinal3 == 0) {
                sVar5.X(297687797);
                strO2 = t2.a.o(R.string.revoke_dialog_confirm, sVar5);
                sVar5.q(z12);
            } else if (iOrdinal3 != 1) {
                sVar5.X(297685814);
                sVar5.q(z12);
                g5.f.a();
                return;
            } else {
                sVar5.X(297691562);
                strO2 = t2.a.p(R.string.revoke_dialog_confirm_batch, new Object[]{Integer.valueOf(i11)}, sVar5);
                sVar5.q(z12);
            }
            String str = strO2;
            boolean z15 = (z10 || i11 <= 0) ? z12 : true;
            w0.m mVarA2 = w.s0.a();
            k0.c1 c1Var3 = c1Var;
            boolean zF2 = sVar5.f(c1Var3) | ((i20 & 7168) == 2048 ? true : z12);
            Object objM6 = sVar5.M();
            if (zF2 || objM6 == y0Var4) {
                e9.j jVar3 = new e9.j(14);
                lVar2 = lVar;
                jVar3.f3666f = lVar2;
                jVar3.f3667g = c1Var3;
                VarHandle.storeStoreFence();
                sVar5.i0(jVar3);
                obj2 = jVar3;
            } else {
                lVar2 = lVar;
                obj2 = objM6;
            }
            b(str, f12106g, z15, mVarA2, (xb.a) obj2, sVar5, 48);
            i10 = 1;
            sVar5.q(true);
            sVar5.q(true);
            sVar2 = sVar5;
        } else {
            lVar2 = lVar;
            i10 = 1;
            aVar2 = aVar;
            sVar6.S();
            sVar2 = sVar6;
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            s2 s2Var2 = new s2(i10);
            s2Var2.f11960f = a3Var;
            s2Var2.f11961g = z10;
            s2Var2.f11962h = aVar2;
            s2Var2.i = lVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = s2Var2;
        }
    }

    public static final void i(xb.a aVar, w0.m mVar, k0.s sVar, int i3) {
        int i10;
        w0.m mVar2;
        sVar.Z(36166099);
        if ((i3 & 6) == 0) {
            i10 = (sVar.h(aVar) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        int i11 = i10 | 48;
        if (sVar.P(i11 & 1, (i11 & 19) != 18)) {
            a0.d dVarA = a0.e.a(20);
            mVar2 = w0.j.f15113c;
            h0.q1.a(androidx.compose.foundation.a.e(mVar2, false, null, aVar, 7), dVarA, f12105f, 0L, 0.0f, 0.0f, g1.f11618d, sVar, 12583296, 120);
        } else {
            sVar.S();
            mVar2 = mVar;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            m2 m2Var = new m2(0);
            m2Var.f11802g = aVar;
            m2Var.f11803h = mVar2;
            m2Var.f11801f = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = m2Var;
        }
    }
}

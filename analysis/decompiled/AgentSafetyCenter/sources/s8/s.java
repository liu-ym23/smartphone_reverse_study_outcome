package s8;

import androidx.compose.foundation.layout.FillElement;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11931a = d1.f0.c(4278913804L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f11932b = d1.f0.c(4280032286L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f11933c = d1.f0.c(4294309367L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f11934d = d1.f0.c(4287532691L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f11935e = d1.f0.c(4290098618L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f11936f = d1.f0.c(4281303295L);

    /* renamed from: g, reason: collision with root package name */
    public static final long f11937g = d1.f0.c(4280756010L);

    /* renamed from: h, reason: collision with root package name */
    public static final long f11938h = d1.f0.c(4284374627L);
    public static final d2.l0 i = new d2.l0(0, com.stepos.statsrpk.h.t(14), g2.k.f4253h, 0, com.stepos.statsrpk.h.t(20), 16646137);

    /* renamed from: j, reason: collision with root package name */
    public static final float f11939j = 88;

    /* renamed from: k, reason: collision with root package name */
    public static final float f11940k = 40;

    /* JADX WARN: Removed duplicated region for block: B:115:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(s8.t r31, java.util.List r32, java.util.Set r33, java.time.ZoneId r34, s8.n1 r35, xb.p r36, xb.l r37, xb.l r38, k0.s r39, int r40) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.s.a(s8.t, java.util.List, java.util.Set, java.time.ZoneId, s8.n1, xb.p, xb.l, xb.l, k0.s, int):void");
    }

    public static final void b(String str, String str2, k0.s sVar, int i3) {
        String str3;
        boolean z10;
        k0.s sVar2 = sVar;
        sVar2.Z(975542572);
        int i10 = i3 | (sVar2.f(str) ? 4 : 2);
        if ((i3 & 48) == 0) {
            i10 |= sVar2.f(str2) ? 32 : 16;
        }
        int i11 = i10;
        if (sVar2.P(i11 & 1, (i11 & 19) != 18)) {
            w0.j jVar = w0.j.f15113c;
            float f5 = 4;
            w0.m mVarJ = androidx.compose.foundation.layout.b.j(androidx.compose.foundation.layout.c.b(jVar, 1.0f), 0.0f, f5, 0.0f, 8, 5);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarJ);
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
            k0.s2 s2Var = h0.w1.f5235a;
            h0.t1.b(str, null, f11933c, 0L, g2.k.i, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar2.j(s2Var)).i, sVar, (i11 & 14) | 196992, 0, 65498);
            sVar2 = sVar;
            if (str2 != null) {
                sVar2.X(1201496997);
                t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, f5));
                str3 = str2;
                h0.t1.b(str3, null, f11934d, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar2.j(s2Var)).f5224n, sVar, ((i11 >> 3) & 14) | 384, 0, 65530);
                sVar2 = sVar;
                z10 = false;
            } else {
                str3 = str2;
                z10 = false;
                sVar2.X(1190566304);
            }
            sVar2.q(z10);
            sVar2.q(true);
        } else {
            str3 = str2;
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            k0.a0 a0Var = new k0.a0(3);
            a0Var.f6862g = str;
            a0Var.f6863h = str3;
            a0Var.f6861f = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = a0Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(java.lang.String r21, k0.s r22, int r23, int r24) {
        /*
            r0 = r22
            r1 = 1463226669(0x5737112d, float:2.012844E14)
            r0.Z(r1)
            r1 = r24 & 1
            r2 = 2
            if (r1 != 0) goto L17
            r1 = r21
            boolean r3 = r0.f(r1)
            if (r3 == 0) goto L19
            r3 = 4
            goto L1a
        L17:
            r1 = r21
        L19:
            r3 = r2
        L1a:
            r3 = r23 | r3
            r4 = r3 & 3
            r5 = 0
            r6 = 1
            if (r4 == r2) goto L24
            r2 = r6
            goto L25
        L24:
            r2 = r5
        L25:
            r4 = r3 & 1
            boolean r2 = r0.P(r4, r2)
            if (r2 == 0) goto L94
            r0.U()
            r2 = r23 & 1
            if (r2 == 0) goto L45
            boolean r2 = r0.z()
            if (r2 == 0) goto L3b
            goto L45
        L3b:
            r0.S()
            r2 = r24 & 1
            if (r2 == 0) goto L51
        L42:
            r3 = r3 & (-15)
            goto L51
        L45:
            r2 = r24 & 1
            if (r2 == 0) goto L51
            r1 = 2131951721(0x7f130069, float:1.9539865E38)
            java.lang.String r1 = t2.a.o(r1, r0)
            goto L42
        L51:
            r0.r()
            k0.s2 r2 = h0.w1.f5235a
            java.lang.Object r2 = r0.j(r2)
            h0.v1 r2 = (h0.v1) r2
            d2.l0 r2 = r2.f5221k
            r4 = 24
            float r4 = (float) r4
            w0.j r6 = w0.j.f15113c
            w0.m r4 = androidx.compose.foundation.layout.b.f(r6, r4)
            r3 = r3 & 14
            r3 = r3 | 432(0x1b0, float:6.05E-43)
            r19 = 0
            r20 = 65528(0xfff8, float:9.1824E-41)
            r16 = r2
            r18 = r3
            long r2 = s8.s.f11934d
            r0 = r1
            r1 = r4
            r6 = r5
            r4 = 0
            r7 = r6
            r6 = 0
            r9 = r7
            r7 = 0
            r10 = r9
            r9 = 0
            r12 = r10
            r10 = 0
            r13 = r12
            r12 = 0
            r14 = r13
            r13 = 0
            r15 = r14
            r14 = 0
            r17 = r15
            r15 = 0
            r17 = r22
            h0.t1.b(r0, r1, r2, r4, r6, r7, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L98
        L94:
            r22.S()
            r0 = r1
        L98:
            k0.v1 r1 = r22.s()
            if (r1 == 0) goto Laf
            s8.g r2 = new s8.g
            r12 = 0
            r2.<init>(r12)
            r2.f11609g = r0
            r0 = r24
            r2.f11608f = r0
            java.lang.invoke.VarHandle.storeStoreFence()
            r1.f7091d = r2
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.s.c(java.lang.String, k0.s, int, int):void");
    }

    public static final void d(t tVar, List list, ZoneId zoneId, n1 n1Var, Set set, x.r rVar, xb.p pVar, k0.s sVar, int i3) {
        int i10;
        sVar.Z(-1226935815);
        int i11 = i3 | (sVar.h(tVar) ? 4 : 2) | (sVar.h(list) ? 32 : 16) | (sVar.h(zoneId) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.h(n1Var) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(set) ? 16384 : 8192) | (sVar.f(rVar) ? 131072 : 65536) | (sVar.h(pVar) ? 1048576 : 524288);
        if (sVar.P(i11 & 1, (599187 & i11) != 599186)) {
            boolean zF = sVar.f(tVar.f11966d) | sVar.f(list) | sVar.f(set) | sVar.f(zoneId) | sVar.f(n1Var);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            Object obj2 = objM;
            if (zF || objM == obj) {
                Object objJ = j(tVar, list, set, zoneId, n1Var);
                sVar.i0(objJ);
                obj2 = objJ;
            }
            List list2 = (List) obj2;
            if (list2.isEmpty()) {
                sVar.X(-1472405291);
                c(null, sVar, 0, 1);
                sVar.q(false);
                k0.v1 v1VarS = sVar.s();
                if (v1VarS != null) {
                    d dVar = new d(i);
                    dVar.f11512f = tVar;
                    dVar.f11513g = list;
                    dVar.f11514h = zoneId;
                    dVar.i = n1Var;
                    dVar.f11515j = set;
                    dVar.f11516k = rVar;
                    dVar.f11517l = pVar;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = dVar;
                    return;
                }
                return;
            }
            sVar.X(-1488832439);
            sVar.q(false);
            w.g gVarE = w.k.e(12);
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            int i12 = (sVar.h(list2) ? 1 : 0) | (sVar.h(tVar) ? 1 : 0) | (sVar.h(set) ? 1 : 0) | ((i11 & 3670016) == 1048576 ? 1 : 0);
            Object objM2 = sVar.M();
            Object obj3 = objM2;
            if (i12 != 0 || objM2 == obj) {
                e9.k kVar = new e9.k(3);
                kVar.f3680h = list2;
                kVar.f3679g = tVar;
                kVar.i = set;
                kVar.f3678f = pVar;
                VarHandle.storeStoreFence();
                sVar.i0(kVar);
                obj3 = kVar;
            }
            i10 = 1;
            t1.e.a(((i11 >> 12) & 112) | 24582, 236, sVar, null, gVarE, null, null, fillElement, rVar, (xb.l) obj3, false);
        } else {
            i10 = 1;
            sVar.S();
        }
        k0.v1 v1VarS2 = sVar.s();
        if (v1VarS2 != null) {
            d dVar2 = new d(i10);
            dVar2.f11512f = tVar;
            dVar2.f11513g = list;
            dVar2.f11514h = zoneId;
            dVar2.i = n1Var;
            dVar2.f11515j = set;
            dVar2.f11516k = rVar;
            dVar2.f11517l = pVar;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = dVar2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v6, types: [e9.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r26v0, types: [k0.s] */
    public static final void e(List list, k8.b bVar, xb.l lVar, k0.s sVar, int i3) {
        sVar.Z(-617140235);
        int i10 = i3 | (sVar.h(list) ? 4 : 2) | (sVar.d(bVar.ordinal()) ? 32 : 16);
        boolean zH = sVar.h(lVar);
        int i11 = ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
        int i12 = i10 | (zH ? 256 : 128);
        if (sVar.P(i12 & 1, (i12 & 147) != 146)) {
            w.r0 r0VarA = w.p0.a(w.k.e(8), w0.b.f15098o, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.j jVar = w0.j.f15113c;
            w0.m mVarM = t.o.m(sVar, jVar);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(r0VarA, sVar, u1.i.f13836e);
            k0.z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar, u1.i.f13834c);
            sVar.X(1739229006);
            qb.b bVar2 = k8.b.i;
            bVar2.getClass();
            kb.b bVar3 = new kb.b(bVar2);
            int i13 = 0;
            while (bVar3.hasNext()) {
                Object next = bVar3.next();
                int i14 = i13 + 1;
                if (i13 < 0) {
                    ac.a.a0();
                    throw null;
                }
                k8.b bVar4 = (k8.b) next;
                boolean z10 = bVar == bVar4;
                float f5 = 20;
                a0.d dVarA = a0.e.a(f5);
                long j10 = z10 ? f11936f : f11937g;
                w0.m mVarG = com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.c(androidx.compose.foundation.layout.c.h(jVar, f11939j), f11940k), a0.e.a(f5));
                boolean zD = ((i12 & 896) == i11) | sVar.d(bVar4.ordinal());
                ?? M = sVar.M();
                if (zD || M == k0.m.f6974a) {
                    M = new e9.j(10);
                    M.f3666f = lVar;
                    M.f3667g = bVar4;
                    VarHandle.storeStoreFence();
                    sVar.i0(M);
                }
                w0.m mVarE = androidx.compose.foundation.a.e(mVarG, false, null, (xb.a) M, 7);
                m mVar = new m();
                mVar.f11781c = list;
                mVar.f11782f = i13;
                mVar.f11783g = z10;
                VarHandle.storeStoreFence();
                h0.q1.a(mVarE, dVarA, j10, 0L, 0.0f, 0.0f, s0.h.d(-2022340732, mVar, sVar), sVar, 12582912, 120);
                i13 = i14;
                i12 = i12;
                bVar3 = bVar3;
                jVar = jVar;
                i11 = ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
            }
            sVar.q(false);
            sVar.q(true);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            j9.n nVar = new j9.n(3);
            nVar.f6692f = list;
            nVar.f6693g = bVar;
            nVar.f6694h = lVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = nVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x029a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(s8.t r24, boolean r25, k8.b r26, boolean r27, k8.b r28, k8.a r29, java.util.Set r30, xb.a r31, xb.q r32, xb.l r33, xb.l r34, xb.a r35, w0.m r36, k0.s r37, int r38) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.s.f(s8.t, boolean, k8.b, boolean, k8.b, k8.a, java.util.Set, xb.a, xb.q, xb.l, xb.l, xb.a, w0.m, k0.s, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(s8.t r22, s8.j3 r23, java.util.Set r24, s0.c r25, boolean r26, boolean r27, java.lang.Integer r28, xb.a r29, xb.a r30, k0.s r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.s.g(s8.t, s8.j3, java.util.Set, s0.c, boolean, boolean, java.lang.Integer, xb.a, xb.a, k0.s, int, int):void");
    }

    public static final void h(List list, t tVar, Set set, k8.a aVar, ZoneId zoneId, n1 n1Var, xb.p pVar, xb.l lVar, xb.l lVar2, k0.s sVar, int i3) {
        int i10;
        int i11;
        Object obj;
        int i12;
        int i13;
        Object obj2;
        sVar.Z(-1980935461);
        int i14 = i3 | (sVar.h(list) ? 4 : 2) | (sVar.h(tVar) ? 32 : 16) | (sVar.h(set) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.f(aVar) ? 2048 : 1024) | (sVar.h(zoneId) ? 16384 : 8192) | (sVar.h(n1Var) ? 131072 : 65536) | (sVar.h(pVar) ? 1048576 : 524288) | (sVar.h(lVar) ? 8388608 : 4194304) | (sVar.h(lVar2) ? 67108864 : 33554432);
        if (sVar.P(i14 & 1, (38347923 & i14) != 38347922)) {
            boolean zF = sVar.f(list) | ((i14 & 7168) == 2048) | sVar.f(zoneId) | sVar.f(n1Var);
            Object objM = sVar.M();
            Object obj3 = k0.m.f6974a;
            if (zF || objM == obj3) {
                List listL = g1.l(list, aVar, zoneId);
                if (listL.isEmpty()) {
                    i11 = i14;
                    objM = kb.s.f7404c;
                    obj = obj3;
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj4 : listL) {
                        Long lValueOf = Long.valueOf(g1.q((j3) obj4, zoneId));
                        Object obj5 = linkedHashMap.get(lValueOf);
                        if (obj5 == null) {
                            i12 = i14;
                            ArrayList arrayList = new ArrayList();
                            linkedHashMap.put(lValueOf, arrayList);
                            obj5 = arrayList;
                        } else {
                            i12 = i14;
                        }
                        ((List) obj5).add(obj4);
                        i14 = i12;
                    }
                    i11 = i14;
                    List listI0 = kb.l.I0(kb.w.P(linkedHashMap), new r(4));
                    lb.c cVarO = ac.a.o();
                    Iterator it = listI0.iterator();
                    while (it.hasNext()) {
                        jb.g gVar = (jb.g) it.next();
                        Object obj6 = obj3;
                        long jLongValue = ((Number) gVar.f6759c).longValue();
                        List list2 = (List) gVar.f6760f;
                        Iterator it2 = it;
                        String strK = k(jLongValue, zoneId, n1Var);
                        q3 q3Var = new q3();
                        q3Var.f11909a = jLongValue;
                        q3Var.f11910b = strK;
                        VarHandle.storeStoreFence();
                        cVarO.add(q3Var);
                        for (j3 j3Var : kb.l.I0(list2, new r(5))) {
                            j3Var.getClass();
                            r3 r3Var = new r3();
                            r3Var.f11930a = j3Var;
                            VarHandle.storeStoreFence();
                            cVarO.add(r3Var);
                        }
                        it = it2;
                        obj3 = obj6;
                    }
                    obj = obj3;
                    objM = ac.a.k(cVarO);
                }
                sVar.i0(objM);
            } else {
                i11 = i14;
                obj = obj3;
            }
            List list3 = (List) objM;
            if (list3.isEmpty()) {
                sVar.X(-1197099783);
                c(t2.a.o(R.string.action_list_empty_undoable, sVar), sVar, 0, 0);
                sVar.q(false);
                k0.v1 v1VarS = sVar.s();
                if (v1VarS != null) {
                    l lVar3 = new l(0);
                    lVar3.f11736f = list;
                    lVar3.f11737g = tVar;
                    lVar3.f11738h = set;
                    lVar3.i = aVar;
                    lVar3.f11739j = zoneId;
                    lVar3.f11740k = n1Var;
                    lVar3.f11741l = pVar;
                    lVar3.f11742m = lVar;
                    lVar3.f11743n = lVar2;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = lVar3;
                    return;
                }
                return;
            }
            sVar.X(-1216329145);
            sVar.q(false);
            b bVar = new b(1);
            bVar.f11454f = lVar;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(-1132616387, bVar, sVar);
            w.g gVarE = w.k.e(12);
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            boolean zH = ((i11 & 234881024) == 67108864) | sVar.h(list3) | sVar.h(tVar) | sVar.h(set) | ((i11 & 3670016) == 1048576);
            Object objM2 = sVar.M();
            if (zH || objM2 == obj) {
                i13 = 1;
                c cVar = new c(i13);
                cVar.f11469f = list3;
                cVar.f11470g = tVar;
                cVar.f11471h = set;
                cVar.i = cVarD;
                cVar.f11472j = lVar2;
                cVar.f11473k = pVar;
                VarHandle.storeStoreFence();
                sVar.i0(cVar);
                obj2 = cVar;
            } else {
                i13 = 1;
                obj2 = objM2;
            }
            i10 = i13;
            t1.e.a(24582, 238, sVar, null, gVarE, null, null, fillElement, null, (xb.l) obj2, false);
        } else {
            i10 = 1;
            sVar.S();
        }
        k0.v1 v1VarS2 = sVar.s();
        if (v1VarS2 != null) {
            l lVar4 = new l(i10);
            lVar4.f11736f = list;
            lVar4.f11737g = tVar;
            lVar4.f11738h = set;
            lVar4.i = aVar;
            lVar4.f11739j = zoneId;
            lVar4.f11740k = n1Var;
            lVar4.f11741l = pVar;
            lVar4.f11742m = lVar;
            lVar4.f11743n = lVar2;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = lVar4;
        }
    }

    public static final int i(j3 j3Var) {
        List list = j3Var.f11702e;
        int i3 = 0;
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (x0.t((p3) it.next()) && (i3 = i3 + 1) < 0) {
                ac.a.Z();
                throw null;
            }
        }
        return i3;
    }

    public static final lb.c j(t tVar, List list, Set set, ZoneId zoneId, n1 n1Var) {
        int i3;
        String str;
        lb.c cVarO = ac.a.o();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            j3 j3VarA = null;
            if (!it.hasNext()) {
                break;
            }
            j3 j3Var = (j3) it.next();
            List list2 = j3Var.f11702e;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                if (((p3) obj).f11880f) {
                    arrayList2.add(obj);
                }
            }
            List listR = g1.R(arrayList2);
            if (!listR.isEmpty()) {
                List listR2 = g1.R(listR);
                jb.g gVar = listR2.isEmpty() ? new jb.g(kb.s.f7404c, 0) : listR2.size() <= 3 ? new jb.g(listR2, 0) : new jb.g(kb.l.J0(listR2, 3), Integer.valueOf(listR2.size() - 3));
                List list3 = (List) gVar.f6759c;
                int iIntValue = ((Number) gVar.f6760f).intValue();
                p3 p3Var = (p3) kb.l.x0(listR);
                if (p3Var == null || (str = p3Var.f11877c) == null) {
                    str = j3Var.f11705h;
                }
                j3VarA = j3.a(j3Var, list3, iIntValue, listR.size(), listR, str, 865);
            }
            if (j3VarA != null) {
                arrayList.add(j3VarA);
            }
        }
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(kb.m.m0(arrayList, 10));
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                j3 j3Var2 = (j3) obj2;
                DateTimeFormatter dateTimeFormatter = x0.f12068a;
                boolean zE = x0.e(j3Var2, tVar, set, j3Var2.f11702e);
                c2 c2Var = new c2();
                c2Var.f11502a = j3Var2;
                c2Var.f11503b = zE;
                VarHandle.storeStoreFence();
                arrayList3.add(c2Var);
            }
            if (!arrayList3.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size2 = arrayList3.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj3 = arrayList3.get(i11);
                    i11++;
                    Long lValueOf = Long.valueOf(g1.q(((c2) obj3).f11502a, zoneId));
                    Object arrayList4 = linkedHashMap.get(lValueOf);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                        linkedHashMap.put(lValueOf, arrayList4);
                    }
                    ((List) arrayList4).add(obj3);
                }
                for (jb.g gVar2 : kb.l.I0(kb.w.P(linkedHashMap), new r(2))) {
                    long jLongValue = ((Number) gVar2.f6759c).longValue();
                    List list4 = (List) gVar2.f6760f;
                    Iterator it2 = list4.iterator();
                    int i12 = 0;
                    while (it2.hasNext()) {
                        List list5 = ((c2) it2.next()).f11502a.f11702e;
                        if (list5.isEmpty()) {
                            i3 = 0;
                        } else {
                            Iterator it3 = list5.iterator();
                            i3 = 0;
                            while (it3.hasNext()) {
                                if (((p3) it3.next()).f11880f && (i3 = i3 + 1) < 0) {
                                    ac.a.Z();
                                    throw null;
                                }
                            }
                        }
                        i12 += i3;
                    }
                    String strK = k(jLongValue, zoneId, n1Var);
                    d2 d2Var = new d2();
                    d2Var.f11543a = jLongValue;
                    d2Var.f11544b = strK;
                    d2Var.f11545c = i12;
                    VarHandle.storeStoreFence();
                    cVarO.add(d2Var);
                    Iterator it4 = kb.l.I0(list4, new r(3)).iterator();
                    while (it4.hasNext()) {
                        cVarO.add((c2) it4.next());
                    }
                }
            }
        }
        return ac.a.k(cVarO);
    }

    public static final String k(long j10, ZoneId zoneId, n1 n1Var) {
        LocalDate localDate = Instant.ofEpochMilli(j10).atZone(zoneId).toLocalDate();
        LocalDate localDateNow = LocalDate.now(zoneId);
        if (yb.k.a(localDate, localDateNow)) {
            return n1Var.f11817a;
        }
        if (yb.k.a(localDate, localDateNow.minusDays(1L))) {
            return n1Var.f11818b;
        }
        String str = localDate.format(n1Var.f11819c);
        str.getClass();
        return str;
    }
}

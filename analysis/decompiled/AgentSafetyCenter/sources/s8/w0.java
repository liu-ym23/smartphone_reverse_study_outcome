package s8;

import androidx.compose.foundation.layout.WithAlignmentLineElement;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f12037a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f12038b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f12039c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f12040d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f12041e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f12042f;

    /* renamed from: g, reason: collision with root package name */
    public static final float f12043g;

    /* renamed from: h, reason: collision with root package name */
    public static final float f12044h;
    public static final float i;

    /* renamed from: j, reason: collision with root package name */
    public static final float f12045j;

    /* renamed from: k, reason: collision with root package name */
    public static final float f12046k;

    /* renamed from: l, reason: collision with root package name */
    public static final float f12047l;

    /* renamed from: m, reason: collision with root package name */
    public static final float f12048m;

    /* renamed from: n, reason: collision with root package name */
    public static final float f12049n;

    /* renamed from: o, reason: collision with root package name */
    public static final float f12050o;

    /* renamed from: p, reason: collision with root package name */
    public static final float f12051p;

    /* renamed from: q, reason: collision with root package name */
    public static final float f12052q;

    /* renamed from: r, reason: collision with root package name */
    public static final long f12053r;

    /* renamed from: s, reason: collision with root package name */
    public static final long f12054s;

    /* renamed from: t, reason: collision with root package name */
    public static final long f12055t;

    /* renamed from: u, reason: collision with root package name */
    public static final long f12056u;

    static {
        d1.f0.c(4278913804L);
        d1.f0.c(4280032286L);
        f12037a = x1.f12092s;
        long j10 = x1.f12093t;
        f12038b = j10;
        f12039c = j10;
        f12040d = d1.f0.c(4281545526L);
        f12041e = d1.f0.c(4281084974L);
        d1.f0.c(4280953388L);
        f12042f = j10;
        f12043g = 64;
        float f5 = 6;
        f12044h = f5;
        i = 144;
        f12045j = 8;
        f12046k = 3;
        float f10 = 16;
        f12047l = f10;
        f12048m = f10;
        f12049n = 13;
        f12050o = f5;
        f12051p = 104;
        f12052q = f5;
        f12053r = com.stepos.statsrpk.h.t(8);
        f12054s = com.stepos.statsrpk.h.t(10);
        d1.f0.c(4290098618L);
        new d2.l0(0L, com.stepos.statsrpk.h.t(14), g2.k.f4253h, com.stepos.statsrpk.h.t(0), com.stepos.statsrpk.h.t(20), 16645977);
        d1.f0.c(4294924890L);
        d1.f0.c(4280950048L);
        d1.f0.c(4287532691L);
        f12055t = x1.f12096w;
        f12056u = d1.f0.c(4281253714L);
        d1.f0.c(4288595455L);
        d1.f0.c(4287532691L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v32, types: [kb.s] */
    /* JADX WARN: Type inference failed for: r6v36, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v38, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v39, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v40, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v45 */
    public static final void a(final t tVar, final boolean z10, final int i3, final List list, final xb.a aVar, final xb.l lVar, final xb.l lVar2, final xb.l lVar3, final List list2, final int i10, final String str, final m8.l0 l0Var, final d1 d1Var, final int i11, final xb.l lVar4, final xb.l lVar5, final xb.p pVar, final xb.a aVar2, final xb.p pVar2, final xb.l lVar6, final xb.l lVar7, final xb.p pVar3, final xb.l lVar8, final xb.l lVar9, final xb.l lVar10, final xb.a aVar3, final xb.a aVar4, final xb.a aVar5, final boolean z11, final List list3, final List list4, final xb.l lVar11, final xb.l lVar12, final b2 b2Var, final xb.l lVar13, final w0.m mVar, k0.s sVar, final int i12) {
        Object objA;
        Object k0Var;
        d1 d1Var2;
        List list5;
        Object objPrevious;
        long jW;
        Object obj;
        ZoneId zoneId;
        Object obj2;
        List list6;
        Object k0Var2;
        ZoneId zoneId2;
        d1 d1Var3;
        int i13;
        xb.l lVar14;
        int i14;
        List list7;
        m8.l0 l0Var2;
        Object obj3;
        m1 m1Var;
        final int i15;
        Object obj4;
        xb.l lVar15;
        Object obj5;
        Object obj6;
        tVar.getClass();
        List list8 = tVar.f11965c;
        aVar2.getClass();
        pVar3.getClass();
        lVar13.getClass();
        sVar.Z(1550491824);
        int i16 = i12 | (sVar.h(tVar) ? 4 : 2) | (sVar.g(z10) ? 32 : 16) | (sVar.d(i3) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.h(list) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(aVar) ? 16384 : 8192) | (sVar.h(lVar) ? 131072 : 65536) | (sVar.h(lVar2) ? 1048576 : 524288) | (sVar.h(lVar3) ? 8388608 : 4194304) | (sVar.h(list2) ? 67108864 : 33554432) | (sVar.d(i10) ? 536870912 : 268435456);
        int i17 = (sVar.f(str) ? 4 : 2) | (sVar.d(l0Var == null ? -1 : l0Var.ordinal()) ? 32 : 16) | (sVar.d(d1Var != null ? d1Var.ordinal() : -1) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.d(i11) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(lVar4) ? 16384 : 8192) | (sVar.h(lVar5) ? 131072 : 65536) | (sVar.h(pVar) ? 1048576 : 524288) | (sVar.h(aVar2) ? 8388608 : 4194304) | (sVar.h(pVar2) ? 67108864 : 33554432) | (sVar.h(lVar6) ? 536870912 : 268435456);
        int i18 = '0' | (sVar.h(lVar7) ? (char) 4 : (char) 2) | (sVar.h(lVar8) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.h(lVar9) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(lVar10) ? 16384 : 8192) | (sVar.h(aVar5) ? 8388608 : 4194304) | (sVar.h(list3) ? 536870912 : 268435456);
        if (sVar.P(i16 & 1, ((i16 & 306783379) == 306783378 && (i17 & 306783379) == 306783378 && (i18 & 306783379) == 306783378 && (((((((((((sVar.h(list4) ? (char) 4 : (char) 2) | (sVar.h(lVar11) ? ' ' : (char) 16)) | (sVar.h(lVar12) ? (char) 256 : (char) 128)) | (sVar.h(b2Var) ? (char) 2048 : (char) 1024)) | (sVar.h(lVar13) ? (char) 16384 : (char) 8192)) | (sVar.g(false) ? (char) 0 : (char) 0)) | (sVar.d(0) ? (char) 0 : (char) 0)) | (sVar.g(false) ? (char) 0 : (char) 0)) | (sVar.h(null) ? (char) 0 : (char) 0)) | (sVar.h(null) ? (char) 0 : (char) 0)) & 306783379) == 306783378) ? false : true)) {
            sVar.U();
            if ((i12 & 1) != 0 && !sVar.z()) {
                sVar.S();
            }
            sVar.r();
            Object objM = sVar.M();
            Object obj7 = k0.m.f6974a;
            Object obj8 = objM;
            if (objM == obj7) {
                Object objSystemDefault = ZoneId.systemDefault();
                sVar.i0(objSystemDefault);
                obj8 = objSystemDefault;
            }
            ZoneId zoneId3 = (ZoneId) obj8;
            String strO = t2.a.o(R.string.chart_day_today, sVar);
            String strO2 = t2.a.o(R.string.chart_day_yesterday, sVar);
            boolean zF = sVar.f(list8) | sVar.f(zoneId3) | sVar.f(strO) | sVar.f(strO2);
            Object objM2 = sVar.M();
            if (zF || objM2 == obj7) {
                if (list8.isEmpty()) {
                    LocalDate localDateNow = LocalDate.now(zoneId3);
                    localDateNow.getClass();
                    zoneId3.getClass();
                    objA = q1.a(localDateNow, zoneId3, kb.s.f7404c, strO, strO2, false, 0, null, null, null);
                } else {
                    objA = list8;
                }
                sVar.i0(objA);
                objM2 = objA;
            }
            List list9 = (List) objM2;
            int i19 = i17 & 896;
            boolean zH = (i19 == 256) | sVar.h(list3) | sVar.h(lVar11) | sVar.h(list4) | sVar.h(lVar12);
            Object objM3 = sVar.M();
            if (zH || objM3 == obj7) {
                k0Var = new androidx.lifecycle.k0(d1Var, list3, lVar11, list4, lVar12, null, 2);
                d1Var2 = d1Var;
                sVar.i0(k0Var);
            } else {
                k0Var = objM3;
                d1Var2 = d1Var;
            }
            k0.z.f(d1Var2, list3, list4, (xb.p) k0Var, sVar);
            boolean zF2 = sVar.f(list9) | sVar.f(zoneId3);
            Object objM4 = sVar.M();
            if (zF2 || objM4 == obj7) {
                ListIterator listIterator = list9.listIterator(list9.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        list5 = list9;
                        objPrevious = null;
                        break;
                    } else {
                        objPrevious = listIterator.previous();
                        list5 = list9;
                        if (((m1) objPrevious).f11794c) {
                            break;
                        } else {
                            list9 = list5;
                        }
                    }
                }
                m1 m1Var2 = (m1) objPrevious;
                if (m1Var2 != null) {
                    jW = m1Var2.f11795d;
                } else {
                    zoneId3.getClass();
                    jW = g1.W(zoneId3);
                }
                Object objValueOf = Long.valueOf(jW);
                sVar.i0(objValueOf);
                obj = objValueOf;
            } else {
                list5 = list9;
                obj = objM4;
            }
            long jLongValue = ((Number) obj).longValue();
            Object objM5 = sVar.M();
            if (objM5 == obj7) {
                ArrayList arrayList = new ArrayList(24);
                zoneId = zoneId3;
                int i20 = 0;
                for (int i21 = 24; i20 < i21; i21 = 24) {
                    arrayList.add("");
                    i20++;
                }
                sVar.i0(arrayList);
                obj2 = arrayList;
            } else {
                zoneId = zoneId3;
                obj2 = objM5;
            }
            List list10 = (List) obj2;
            Object objM6 = sVar.M();
            Object obj9 = objM6;
            if (objM6 == obj7) {
                ArrayList arrayList2 = new ArrayList(24);
                int i22 = 0;
                for (int i23 = 24; i22 < i23; i23 = 24) {
                    arrayList2.add(g1.V(i22));
                    i22++;
                }
                sVar.i0(arrayList2);
                obj9 = arrayList2;
            }
            List list11 = (List) obj9;
            boolean zF3 = sVar.f(tVar) | sVar.e(jLongValue) | sVar.f(list10) | sVar.f(list11);
            Object objM7 = sVar.M();
            Object obj10 = objM7;
            if (zF3 || objM7 == obj7) {
                Object objK = g1.k(tVar, jLongValue, list10, list11);
                sVar.i0(objK);
                obj10 = objK;
            }
            final ArrayList arrayList3 = (List) obj10;
            int iOrdinal = d1Var.ordinal();
            if (iOrdinal == 0) {
                list6 = arrayList3;
            } else if (iOrdinal == 1) {
                list6 = list5;
            } else if (iOrdinal == 2) {
                list6 = list3;
            } else {
                if (iOrdinal != 3) {
                    throw new androidx.fragment.app.d();
                }
                list6 = list4;
            }
            List list12 = list6;
            ZoneId zoneId4 = zoneId;
            List list13 = list5;
            Object[] objArr = {d1Var, list13, zoneId4, list3, list4, Integer.valueOf(i11)};
            int i24 = i17 & 7168;
            int i25 = i17 & 458752;
            boolean zH2 = (i19 == 256) | (i24 == 2048) | sVar.h(zoneId4) | sVar.h(list13) | sVar.h(list3) | sVar.h(list4) | (i25 == 131072);
            Object objM8 = sVar.M();
            if (zH2 || objM8 == obj7) {
                zoneId2 = zoneId4;
                k0Var2 = new s.k0(i11, d1Var, zoneId2, list13, list3, list4, lVar5, null);
                d1Var3 = d1Var;
                sVar.i0(k0Var2);
            } else {
                k0Var2 = objM8;
                zoneId2 = zoneId4;
                d1Var3 = d1Var;
            }
            k0.z.i(objArr, (xb.p) k0Var2, sVar);
            boolean zH3 = sVar.h(list13) | ((i17 & 3670016) == 1048576) | ((i17 & 112) == 32);
            Object objM9 = sVar.M();
            if (zH3 || objM9 == obj7) {
                i13 = i11;
                lVar14 = lVar5;
                i14 = i24;
                Object f0Var = new g9.f0(list13, pVar, l0Var, null, 4);
                list7 = list13;
                l0Var2 = l0Var;
                sVar.i0(f0Var);
                objM9 = f0Var;
            } else {
                i13 = i11;
                lVar14 = lVar5;
                i14 = i24;
                list7 = list13;
                l0Var2 = l0Var;
            }
            k0.z.f(l0Var2, d1Var3, list7, (xb.p) objM9, sVar);
            Integer numValueOf = Integer.valueOf(list12.size());
            Integer numValueOf2 = Integer.valueOf(i13);
            boolean zH4 = sVar.h(list12) | (i14 == 2048) | (i25 == 131072);
            Object objM10 = sVar.M();
            if (zH4 || objM10 == obj7) {
                Object h0Var = new androidx.lifecycle.h0(list12, i13, lVar14, (nb.c) null);
                sVar.i0(h0Var);
                obj3 = h0Var;
            } else {
                obj3 = objM10;
            }
            k0.z.g(numValueOf, numValueOf2, (xb.p) obj3, sVar);
            int iX = ac.a.x(list12);
            if (iX < 0) {
                iX = 0;
            }
            final int iQ = p5.f.q(i13, 0, iX);
            boolean zF4 = sVar.f(tVar.b()) | (i19 == 256) | sVar.d(iQ) | sVar.f(list12);
            Object objM11 = sVar.M();
            Object obj11 = objM11;
            if (zF4 || objM11 == obj7) {
                boolean zIsEmpty = list12.isEmpty();
                Object arrayList4 = kb.s.f7404c;
                if (!zIsEmpty && (m1Var = (m1) kb.l.y0(iQ, list12)) != null) {
                    long j10 = m1Var.f11795d;
                    int iOrdinal2 = d1Var3.ordinal();
                    if (iOrdinal2 == 0) {
                        int iQ2 = p5.f.q(iQ, 0, 23);
                        if (j10 == 0) {
                            List listB = tVar.b();
                            arrayList4 = new ArrayList();
                            Iterator it = listB.iterator();
                            while (it.hasNext()) {
                                j3 j3VarB = b(iQ2, (j3) it.next());
                                if (j3VarB != null) {
                                    arrayList4.add(j3VarB);
                                }
                            }
                        } else {
                            List listB2 = tVar.b();
                            ArrayList arrayList5 = new ArrayList();
                            for (Object obj12 : listB2) {
                                long j11 = ((j3) obj12).i;
                                if (j11 == 0 || j11 == j10) {
                                    arrayList5.add(obj12);
                                }
                            }
                            arrayList4 = new ArrayList();
                            int size = arrayList5.size();
                            int i26 = 0;
                            while (i26 < size) {
                                Object obj13 = arrayList5.get(i26);
                                i26++;
                                j3 j3VarB2 = b(iQ2, (j3) obj13);
                                if (j3VarB2 != null) {
                                    arrayList4.add(j3VarB2);
                                }
                            }
                        }
                    } else if (iOrdinal2 != 1) {
                        if (iOrdinal2 != 2 && iOrdinal2 != 3) {
                            throw new androidx.fragment.app.d();
                        }
                        if (j10 > 0) {
                            long j12 = m1Var.f11799h;
                            Long lValueOf = j12 > 0 ? Long.valueOf(j12) : null;
                            long jLongValue2 = lValueOf != null ? lValueOf.longValue() : j10;
                            List listB3 = tVar.b();
                            ArrayList arrayList6 = new ArrayList();
                            Iterator it2 = listB3.iterator();
                            while (it2.hasNext()) {
                                Object next = it2.next();
                                Iterator it3 = it2;
                                long j13 = ((j3) next).i;
                                if (j13 == 0 || (jLongValue2 <= j13 && j13 <= j10)) {
                                    arrayList6.add(next);
                                }
                                it2 = it3;
                            }
                            arrayList4 = arrayList6;
                        }
                    } else if (j10 == 0) {
                        arrayList4 = tVar.b();
                    } else {
                        List listB4 = tVar.b();
                        arrayList4 = new ArrayList();
                        for (Object obj14 : listB4) {
                            long j14 = ((j3) obj14).i;
                            if (j14 == 0 || j14 == j10) {
                                arrayList4.add(obj14);
                            }
                        }
                    }
                }
                sVar.i0(arrayList4);
                obj11 = arrayList4;
            }
            final List list14 = (List) obj11;
            final t.h1 h1VarK = t.c1.k(sVar);
            Object objM12 = sVar.M();
            Object obj15 = objM12;
            if (objM12 == obj7) {
                Object objO = k0.z.o(sVar);
                sVar.i0(objO);
                obj15 = objO;
            }
            final kc.t tVar2 = (kc.t) obj15;
            boolean zH5 = sVar.h(tVar2) | ((i18 & 896) == 256) | sVar.h(lVar13);
            Object objM13 = sVar.M();
            if (zH5 || objM13 == obj7) {
                i15 = 0;
                Object obj16 = new xb.a() { // from class: s8.y
                    @Override // xb.a
                    public final Object invoke() {
                        switch (i15) {
                            case 0:
                                kc.w.u(tVar2, null, null, new r0(lVar8, lVar13, null, 1), 3);
                                break;
                            default:
                                kc.w.u(tVar2, null, null, new r0(lVar8, lVar13, null, 4), 3);
                                break;
                        }
                        return jb.v.f6774a;
                    }
                };
                sVar.i0(obj16);
                obj4 = obj16;
            } else {
                i15 = 0;
                obj4 = objM13;
            }
            final xb.a aVar6 = (xb.a) obj4;
            final List list15 = list7;
            int i27 = ((i16 & 458752) == 131072 ? 1 : i15) | (sVar.h(list2) ? 1 : 0) | (sVar.h(tVar2) ? 1 : 0) | ((i18 & 7168) == 2048 ? 1 : i15) | (sVar.h(lVar13) ? 1 : 0);
            Object objM14 = sVar.M();
            if (i27 != 0 || objM14 == obj7) {
                Object sVar2 = new k8.s(lVar, list2, tVar2, lVar9, lVar13);
                sVar.i0(sVar2);
                objM14 = sVar2;
            }
            final xb.a aVar7 = (xb.a) objM14;
            int i28 = ((i16 & 57344) == 16384 ? 1 : i15) | (sVar.h(tVar2) ? 1 : 0) | ((57344 & i18) == 16384 ? 1 : i15) | (sVar.h(lVar13) ? 1 : 0);
            Object objM15 = sVar.M();
            if (i28 != 0 || objM15 == obj7) {
                lVar15 = lVar10;
                Object dVar = new e9.d(aVar, tVar2, lVar15, lVar13);
                sVar.i0(dVar);
                obj5 = dVar;
            } else {
                lVar15 = lVar10;
                obj5 = objM15;
            }
            final xb.a aVar8 = (xb.a) obj5;
            boolean zH6 = sVar.h(tVar2) | ((i16 & 29360128) == 8388608) | sVar.h(lVar13);
            Object objM16 = sVar.M();
            if (zH6 || objM16 == obj7) {
                final int i29 = 1;
                Object obj17 = new xb.a() { // from class: s8.y
                    @Override // xb.a
                    public final Object invoke() {
                        switch (i29) {
                            case 0:
                                kc.w.u(tVar2, null, null, new r0(lVar3, lVar13, null, 1), 3);
                                break;
                            default:
                                kc.w.u(tVar2, null, null, new r0(lVar3, lVar13, null, 4), 3);
                                break;
                        }
                        return jb.v.f6774a;
                    }
                };
                sVar.i0(obj17);
                obj6 = obj17;
            } else {
                obj6 = objM16;
            }
            final xb.a aVar9 = (xb.a) obj6;
            final int iT = g1.T(tVar);
            int size2 = list.size();
            if (size2 < 0) {
                size2 = 0;
            }
            final o1 o1Var = size2 > 2 ? o1.f11838g : z10 ? o1.f11837f : o1.f11836c;
            final xb.l lVar16 = lVar15;
            final xb.l lVar17 = lVar14;
            final ZoneId zoneId5 = zoneId2;
            final int i30 = size2;
            l9.a.d(t2.a.o(R.string.screen_ai_agent_security, sVar), aVar2, mVar, x1.a(), false, null, null, s0.h.d(-170303973, new xb.q(str, o1Var, iT, i3, i30, aVar9, list, list2, i10, aVar8, aVar7, lVar2, tVar, pVar3, tVar2, lVar16, lVar13, lVar7, lVar6, d1Var, lVar4, zoneId5, arrayList3, list15, list3, list4, l0Var, b2Var, iQ, aVar6, lVar17, pVar2, aVar3, aVar4, aVar5, z11, list14, mVar) { // from class: s8.z
                public final /* synthetic */ ZoneId A;
                public final /* synthetic */ List B;
                public final /* synthetic */ List C;
                public final /* synthetic */ List D;
                public final /* synthetic */ List E;
                public final /* synthetic */ m8.l0 F;
                public final /* synthetic */ b2 G;
                public final /* synthetic */ int H;
                public final /* synthetic */ xb.a I;
                public final /* synthetic */ xb.l J;
                public final /* synthetic */ xb.p K;
                public final /* synthetic */ xb.a L;
                public final /* synthetic */ xb.a M;
                public final /* synthetic */ xb.a N;
                public final /* synthetic */ boolean O;
                public final /* synthetic */ List P;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ String f12143f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ o1 f12144g;

                /* renamed from: h, reason: collision with root package name */
                public final /* synthetic */ int f12145h;
                public final /* synthetic */ int i;

                /* renamed from: j, reason: collision with root package name */
                public final /* synthetic */ int f12146j;

                /* renamed from: k, reason: collision with root package name */
                public final /* synthetic */ xb.a f12147k;

                /* renamed from: l, reason: collision with root package name */
                public final /* synthetic */ List f12148l;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ Object f12149m;

                /* renamed from: n, reason: collision with root package name */
                public final /* synthetic */ int f12150n;

                /* renamed from: o, reason: collision with root package name */
                public final /* synthetic */ xb.a f12151o;

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ xb.a f12152p;

                /* renamed from: q, reason: collision with root package name */
                public final /* synthetic */ xb.l f12153q;

                /* renamed from: r, reason: collision with root package name */
                public final /* synthetic */ t f12154r;

                /* renamed from: s, reason: collision with root package name */
                public final /* synthetic */ xb.p f12155s;

                /* renamed from: t, reason: collision with root package name */
                public final /* synthetic */ kc.t f12156t;

                /* renamed from: u, reason: collision with root package name */
                public final /* synthetic */ xb.l f12157u;

                /* renamed from: v, reason: collision with root package name */
                public final /* synthetic */ xb.l f12158v;

                /* renamed from: w, reason: collision with root package name */
                public final /* synthetic */ xb.l f12159w;

                /* renamed from: x, reason: collision with root package name */
                public final /* synthetic */ xb.l f12160x;

                /* renamed from: y, reason: collision with root package name */
                public final /* synthetic */ d1 f12161y;

                /* renamed from: z, reason: collision with root package name */
                public final /* synthetic */ xb.l f12162z;

                @Override // xb.q
                public final Object invoke(Object obj18, Object obj19, Object obj20) {
                    w.l0 l0Var3 = (w.l0) obj18;
                    k0.s sVar3 = (k0.s) obj19;
                    int iIntValue = ((Integer) obj20).intValue();
                    l0Var3.getClass();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= sVar3.f(l0Var3) ? 4 : 2;
                    }
                    if (sVar3.P(iIntValue & 1, (iIntValue & 19) != 18)) {
                        w0.m mVarJ = androidx.compose.foundation.layout.b.j(androidx.compose.foundation.layout.c.f904c, 0.0f, 0.0f, 0.0f, l0Var3.a(), 7);
                        c0 c0Var = new c0();
                        c0Var.f11474c = this.f12142c;
                        c0Var.f11475f = l0Var3;
                        c0Var.f11476g = this.f12143f;
                        c0Var.f11477h = this.f12144g;
                        c0Var.i = this.f12145h;
                        c0Var.f11478j = this.i;
                        c0Var.f11479k = this.f12146j;
                        c0Var.f11480l = this.f12147k;
                        c0Var.f11481m = this.f12148l;
                        c0Var.f11482n = this.f12149m;
                        c0Var.f11483o = this.f12150n;
                        c0Var.f11484p = this.f12151o;
                        c0Var.f11485q = this.f12152p;
                        c0Var.f11486r = this.f12153q;
                        c0Var.f11487s = this.f12154r;
                        c0Var.f11488t = this.f12155s;
                        c0Var.f11489u = this.f12156t;
                        c0Var.f11490v = this.f12157u;
                        c0Var.f11491w = this.f12158v;
                        c0Var.f11492x = this.f12159w;
                        c0Var.f11493y = this.f12160x;
                        c0Var.f11494z = this.f12161y;
                        c0Var.A = this.f12162z;
                        c0Var.B = this.A;
                        c0Var.C = this.B;
                        c0Var.D = this.C;
                        c0Var.E = this.D;
                        c0Var.F = this.E;
                        c0Var.G = this.F;
                        c0Var.H = this.G;
                        c0Var.I = this.H;
                        c0Var.J = this.I;
                        c0Var.K = this.J;
                        c0Var.L = this.K;
                        c0Var.M = this.L;
                        c0Var.N = this.M;
                        c0Var.O = this.N;
                        c0Var.P = this.O;
                        c0Var.Q = this.P;
                        VarHandle.storeStoreFence();
                        t.m0.a(mVarJ, null, s0.h.d(-1674808315, c0Var, sVar3), sVar3, 3072);
                    } else {
                        sVar3.S();
                    }
                    return jb.v.f6774a;
                }
            }, sVar), sVar, ((i17 >> 18) & 112) | 12586368, 112);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new xb.p(z10, i3, list, aVar, lVar, lVar2, lVar3, list2, i10, str, l0Var, d1Var, i11, lVar4, lVar5, pVar, aVar2, pVar2, lVar6, lVar7, pVar3, lVar8, lVar9, lVar10, aVar3, aVar4, aVar5, z11, list3, list4, lVar11, lVar12, b2Var, lVar13, mVar, i12) { // from class: s8.a0
                public final /* synthetic */ xb.l A;
                public final /* synthetic */ xb.l B;
                public final /* synthetic */ xb.l C;
                public final /* synthetic */ xb.a D;
                public final /* synthetic */ xb.a E;
                public final /* synthetic */ xb.a F;
                public final /* synthetic */ boolean G;
                public final /* synthetic */ List H;
                public final /* synthetic */ List I;
                public final /* synthetic */ xb.l J;
                public final /* synthetic */ xb.l K;
                public final /* synthetic */ b2 L;
                public final /* synthetic */ xb.l M;
                public final /* synthetic */ w0.m N;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ boolean f11428f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ int f11429g;

                /* renamed from: h, reason: collision with root package name */
                public final /* synthetic */ List f11430h;
                public final /* synthetic */ xb.a i;

                /* renamed from: j, reason: collision with root package name */
                public final /* synthetic */ xb.l f11431j;

                /* renamed from: k, reason: collision with root package name */
                public final /* synthetic */ xb.l f11432k;

                /* renamed from: l, reason: collision with root package name */
                public final /* synthetic */ xb.l f11433l;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ Object f11434m;

                /* renamed from: n, reason: collision with root package name */
                public final /* synthetic */ int f11435n;

                /* renamed from: o, reason: collision with root package name */
                public final /* synthetic */ String f11436o;

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ m8.l0 f11437p;

                /* renamed from: q, reason: collision with root package name */
                public final /* synthetic */ d1 f11438q;

                /* renamed from: r, reason: collision with root package name */
                public final /* synthetic */ int f11439r;

                /* renamed from: s, reason: collision with root package name */
                public final /* synthetic */ xb.l f11440s;

                /* renamed from: t, reason: collision with root package name */
                public final /* synthetic */ xb.l f11441t;

                /* renamed from: u, reason: collision with root package name */
                public final /* synthetic */ xb.p f11442u;

                /* renamed from: v, reason: collision with root package name */
                public final /* synthetic */ xb.a f11443v;

                /* renamed from: w, reason: collision with root package name */
                public final /* synthetic */ xb.p f11444w;

                /* renamed from: x, reason: collision with root package name */
                public final /* synthetic */ xb.l f11445x;

                /* renamed from: y, reason: collision with root package name */
                public final /* synthetic */ xb.l f11446y;

                /* renamed from: z, reason: collision with root package name */
                public final /* synthetic */ xb.p f11447z;

                /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, java.util.List] */
                @Override // xb.p
                public final Object invoke(Object obj18, Object obj19) {
                    ((Integer) obj19).getClass();
                    int iD = k0.z.D(1);
                    w0.a(this.f11427c, this.f11428f, this.f11429g, this.f11430h, this.i, this.f11431j, this.f11432k, this.f11433l, this.f11434m, this.f11435n, this.f11436o, this.f11437p, this.f11438q, this.f11439r, this.f11440s, this.f11441t, this.f11442u, this.f11443v, this.f11444w, this.f11445x, this.f11446y, this.f11447z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, (k0.s) obj18, iD);
                    return jb.v.f6774a;
                }
            };
        }
    }

    public static final j3 b(int i3, j3 j3Var) {
        String str;
        List list = j3Var.f11702e;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (g1.D(((p3) obj).f11877c) == i3) {
                arrayList.add(obj);
            }
        }
        List listR = g1.R(arrayList);
        if (listR.isEmpty()) {
            return null;
        }
        List listR2 = g1.R(listR);
        jb.g gVar = listR2.isEmpty() ? new jb.g(kb.s.f7404c, 0) : listR2.size() <= 3 ? new jb.g(listR2, 0) : new jb.g(kb.l.J0(listR2, 3), Integer.valueOf(listR2.size() - 3));
        List list2 = (List) gVar.f6759c;
        int iIntValue = ((Number) gVar.f6760f).intValue();
        int size = listR.size();
        p3 p3Var = (p3) kb.l.x0(listR);
        if (p3Var == null || (str = p3Var.f11877c) == null) {
            str = j3Var.f11705h;
        }
        return j3.a(j3Var, list2, iIntValue, size, listR, str, 865);
    }

    public static final void c(m1 m1Var, boolean z10, float f5, float f10, float f11, k0.s sVar, int i3) {
        sVar.Z(399971688);
        int i10 = i3 | (sVar.f(m1Var) ? 4 : 2) | (sVar.g(z10) ? 32 : 16) | (sVar.c(f5) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.c(f11) ? 16384 : 8192);
        if (sVar.P(i10 & 1, (i10 & 9363) != 9362)) {
            w0.j jVar = w0.j.f15113c;
            w0.m mVarD = androidx.compose.foundation.layout.c.h(jVar, f5).d(androidx.compose.foundation.layout.c.f903b);
            s1.f0 f0VarE = w.p.e(w0.b.f15095l, false);
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
            if (m1Var.f11793b > 0.0f) {
                sVar.X(-1494842616);
                w.p.a(androidx.compose.foundation.a.b(androidx.compose.foundation.layout.c.c(androidx.compose.foundation.layout.c.h(jVar, f11), ((o2.f) p5.f.s(o2.f.a(m1Var.f11793b * f10), o2.f.a(f11), o2.f.a(f10))).f9114c), z10 ? f12056u : f12055t, a0.e.a(f11 / 2)), sVar, 0);
            } else {
                sVar.X(-1559594796);
            }
            sVar.q(false);
            sVar.q(true);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            x xVar = new x();
            xVar.f12064c = m1Var;
            xVar.f12065f = z10;
            xVar.f12066g = f5;
            xVar.f12067h = f10;
            xVar.i = f11;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = xVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(boolean r7, float r8, float r9, c1.c r10, k0.s r11, int r12) {
        /*
            r0 = 429778687(0x199de6ff, float:1.6326718E-23)
            r11.Z(r0)
            boolean r0 = r11.g(r7)
            if (r0 == 0) goto Lf
            r0 = 32
            goto L11
        Lf:
            r0 = 16
        L11:
            r12 = r12 | r0
            boolean r0 = r11.c(r8)
            r1 = 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L1c
            r0 = r1
            goto L1e
        L1c:
            r0 = 128(0x80, float:1.8E-43)
        L1e:
            r12 = r12 | r0
            boolean r0 = r11.c(r9)
            r2 = 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L29
            r0 = r2
            goto L2b
        L29:
            r0 = 1024(0x400, float:1.435E-42)
        L2b:
            r12 = r12 | r0
            boolean r0 = r11.f(r10)
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L36
            r0 = r3
            goto L38
        L36:
            r0 = 8192(0x2000, float:1.148E-41)
        L38:
            r12 = r12 | r0
            r0 = r12 & 9361(0x2491, float:1.3118E-41)
            r4 = 9360(0x2490, float:1.3116E-41)
            r5 = 0
            r6 = 1
            if (r0 == r4) goto L43
            r0 = r6
            goto L44
        L43:
            r0 = r5
        L44:
            r4 = r12 & 1
            boolean r0 = r11.P(r4, r0)
            if (r0 == 0) goto Lb1
            if (r7 == 0) goto L98
            if (r10 == 0) goto L98
            r0 = 0
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 > 0) goto L56
            goto L98
        L56:
            androidx.compose.foundation.layout.FillElement r0 = androidx.compose.foundation.layout.c.f904c
            r4 = 1073741824(0x40000000, float:2.0)
            w0.m r0 = t.m0.l(r0, r4)
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r12
            if (r4 != r3) goto L66
            r3 = r6
            goto L67
        L66:
            r3 = r5
        L67:
            r4 = r12 & 896(0x380, float:1.256E-42)
            if (r4 != r1) goto L6d
            r1 = r6
            goto L6e
        L6d:
            r1 = r5
        L6e:
            r1 = r1 | r3
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != r2) goto L74
            r5 = r6
        L74:
            r12 = r1 | r5
            java.lang.Object r1 = r11.M()
            if (r12 != 0) goto L80
            k0.y0 r12 = k0.m.f6974a
            if (r1 != r12) goto L91
        L80:
            s8.i0 r1 = new s8.i0
            r1.<init>()
            r1.f11656c = r10
            r1.f11657f = r8
            r1.f11658g = r9
            java.lang.invoke.VarHandle.storeStoreFence()
            r11.i0(r1)
        L91:
            xb.l r1 = (xb.l) r1
            r12 = 6
            t.n.a(r0, r1, r11, r12)
            goto Lb4
        L98:
            k0.v1 r11 = r11.s()
            if (r11 == 0) goto Lc0
            s8.h0 r12 = new s8.h0
            r12.<init>(r5)
        La3:
            r12.f11638f = r7
            r12.f11639g = r8
            r12.f11640h = r9
            r12.i = r10
            java.lang.invoke.VarHandle.storeStoreFence()
            r11.f7091d = r12
            return
        Lb1:
            r11.S()
        Lb4:
            k0.v1 r11 = r11.s()
            if (r11 == 0) goto Lc0
            s8.h0 r12 = new s8.h0
            r12.<init>(r6)
            goto La3
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.w0.d(boolean, float, float, c1.c, k0.s, int):void");
    }

    public static final void e(int i3, String str, w0.m mVar, k0.s sVar, int i10) {
        String str2 = str;
        k0.s sVar2 = sVar;
        sVar2.Z(1905279028);
        int i11 = i10 | (sVar2.d(i3) ? 4 : 2) | (sVar2.f(str2) ? 32 : 16) | (sVar2.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar2.P(i11 & 1, (i11 & 147) != 146)) {
            float f5 = 1;
            w0.m mVarH = androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.i(mVar, 0, 0.0f, 2), f5, 0.0f, 2);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 48);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarH);
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
            p1 p1VarX = g1.x(i3);
            String strN = p1VarX.f11869a;
            String str3 = p1VarX.f11870b;
            if (str3 != null && str3.length() != 0) {
                strN = k0.a.n(strN, str3);
            }
            String str4 = strN;
            long jT = com.stepos.statsrpk.h.t(14);
            long jT2 = com.stepos.statsrpk.h.t(16);
            g2.k kVar = g2.k.f4254j;
            w0.j jVar = w0.j.f15113c;
            h0.t1.b(str4, androidx.compose.foundation.layout.c.b(jVar, 1.0f), f12037a, jT, kVar, 0L, n2.k.a(5), jT2, 0, false, 1, 0, null, sVar, 200112, 3078, 121296);
            t0.a.b(sVar, androidx.compose.foundation.layout.c.c(jVar, f5));
            d2.l0 l0Var = ((h0.v1) sVar.j(h0.w1.f5235a)).f5225o;
            str2 = str;
            h0.t1.b(str2, androidx.compose.foundation.layout.c.b(jVar, 1.0f), f12038b, com.stepos.statsrpk.h.t(9), g2.k.f4252g, 0L, n2.k.a(5), com.stepos.statsrpk.h.t(11), 2, false, 2, 0, l0Var, sVar, ((i11 >> 3) & 14) | 200112, 3126, 53712);
            sVar2 = sVar;
            sVar2.q(true);
        } else {
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            k0.a0 a0Var = new k0.a0(4);
            a0Var.f6861f = i3;
            a0Var.f6862g = str2;
            a0Var.f6863h = mVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = a0Var;
        }
    }

    public static final void f(d1 d1Var, xb.l lVar, k0.s sVar, int i3) {
        sVar.Z(81837221);
        int i10 = 4;
        int i11 = (sVar.d(d1Var.ordinal()) ? 4 : 2) | i3 | (sVar.h(lVar) ? 32 : 16);
        if (sVar.P(i11 & 1, (i11 & 19) != 18)) {
            List listF = ac.a.F(new jb.g(d1.f11539c, Integer.valueOf(R.string.chart_period_day_short)), new jb.g(d1.f11540f, Integer.valueOf(R.string.chart_period_week_short)), new jb.g(d1.f11541g, Integer.valueOf(R.string.chart_period_month_short)), new jb.g(d1.f11542h, Integer.valueOf(R.string.chart_period_all_short)));
            a0.d dVarA = a0.e.a(x1.B);
            long j10 = x1.f12098y;
            float f5 = 0;
            j9.n nVar = new j9.n(i10);
            nVar.f6692f = listF;
            nVar.f6693g = d1Var;
            nVar.f6694h = lVar;
            VarHandle.storeStoreFence();
            h0.q1.a(null, dVarA, j10, 0L, f5, f5, s0.h.d(-1374966294, nVar, sVar), sVar, 12804480, 73);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            j9.i iVar = new j9.i(6);
            iVar.f6671f = d1Var;
            iVar.f6672g = lVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = iVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public static final void g(int i3, String str, w0.m mVar, k0.s sVar, int i10) {
        int i11;
        ?? r12;
        k0.s sVar2;
        boolean z10;
        boolean z11;
        k0.s sVar3;
        k0.s sVar4 = sVar;
        sVar4.Z(-1017009454);
        if ((i10 & 6) == 0) {
            i11 = (sVar4.d(i3) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= sVar4.f(str) ? 32 : 16;
        }
        if ((i10 & 384) == 0) {
            i11 |= sVar4.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        int i12 = i11;
        if (sVar4.P(i12 & 1, (i12 & 147) != 146)) {
            p1 p1VarX = g1.x(i3);
            w0.m mVarJ = androidx.compose.foundation.layout.b.j(mVar, 0.0f, 10, 0.0f, 0.0f, 13);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15101r, sVar4, 48);
            int iHashCode = Long.hashCode(sVar4.T);
            s0.g gVarL = sVar4.l();
            w0.m mVarM = t.o.m(sVar4, mVarJ);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar4.b0();
            if (sVar4.S) {
                sVar4.k(zVar);
            } else {
                sVar4.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(vVarA, sVar4, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar4, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar4.S || !yb.k.a(sVar4.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar4, iHashCode, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar4, hVar4);
            long j10 = x1.U;
            long j11 = x1.V;
            g2.k kVar = x1.W;
            long j12 = x1.f12095v;
            w0.j jVar = w0.j.f15113c;
            h0.t1.b(str, androidx.compose.foundation.layout.c.b(jVar, 1.0f), j12, j10, kVar, 0L, n2.k.a(3), j11, 2, false, 2, 0, null, sVar, ((i12 >> 3) & 14) | 200112, 3126, 119248);
            t0.a.b(sVar, androidx.compose.foundation.layout.c.c(jVar, 2));
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            w.r0 r0VarA = w.p0.a(w.k.f14993d, w0.b.f15097n, sVar, 6);
            int iHashCode2 = Long.hashCode(sVar.T);
            s0.g gVarL2 = sVar.l();
            w0.m mVarM2 = t.o.m(sVar, mVarB);
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(r0VarA, sVar, hVar);
            k0.z.B(gVarL2, sVar, hVar2);
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar, iHashCode2, hVar3);
            }
            k0.z.B(mVarM2, sVar, hVar4);
            String str2 = p1VarX.f11869a;
            long j13 = x1.X;
            long j14 = x1.Y;
            g2.k kVar2 = x1.Z;
            long j15 = x1.f12092s;
            s1.l lVar = s1.c.f11219a;
            WithAlignmentLineElement withAlignmentLineElement = new WithAlignmentLineElement();
            withAlignmentLineElement.f897c = lVar;
            VarHandle.storeStoreFence();
            h0.t1.b(str2, withAlignmentLineElement, j15, j13, kVar2, 0L, n2.k.a(3), j14, 0, false, 0, 0, null, sVar, 200064, 6, 129488);
            k0.s sVar5 = sVar;
            if (p1VarX.f11870b != null) {
                sVar5.X(412711320);
                String str3 = p1VarX.f11870b;
                long jT = com.stepos.statsrpk.h.t(11);
                long jT2 = com.stepos.statsrpk.h.t(16);
                g2.k kVar3 = g2.k.f4252g;
                z10 = true;
                w0.m mVarJ2 = androidx.compose.foundation.layout.b.j(jVar, 1, 0.0f, 0.0f, 0.0f, 14);
                WithAlignmentLineElement withAlignmentLineElement2 = new WithAlignmentLineElement();
                withAlignmentLineElement2.f897c = lVar;
                VarHandle.storeStoreFence();
                h0.t1.b(str3, mVarJ2.d(withAlignmentLineElement2), j15, jT, kVar3, 0L, null, jT2, 0, false, 0, 0, null, sVar, 200064, 6, 130000);
                sVar3 = sVar;
                z11 = false;
            } else {
                z10 = true;
                z11 = false;
                sVar5.X(325768534);
                sVar3 = sVar5;
            }
            sVar3.q(z11);
            sVar3.q(z10);
            sVar3.q(z10);
            r12 = z11;
            sVar2 = sVar3;
        } else {
            r12 = 0;
            sVar4.S();
            sVar2 = sVar4;
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            o0 o0Var = new o0(r12);
            o0Var.f11834g = i3;
            o0Var.i = str;
            o0Var.f11833f = mVar;
            o0Var.f11835h = i10;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = o0Var;
        }
    }

    public static final void h(int i3, int i10, int i11, k0.s sVar, int i12) {
        sVar.Z(-2079541075);
        int i13 = i12 | (sVar.d(i3) ? 4 : 2) | (sVar.d(i10) ? 32 : 16) | (sVar.d(i11) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar.P(i13 & 1, (i13 & 147) != 146)) {
            w0.m mVarH = androidx.compose.foundation.layout.b.h(androidx.compose.foundation.layout.c.d(androidx.compose.foundation.layout.c.b(w0.j.f15113c, 1.0f), 62, 0.0f, 2), 16, 0.0f, 2);
            w.r0 r0VarA = w.p0.a(w.k.e(8), w0.b.f15097n, sVar, 54);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarH);
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
            g(i3, t2.a.o(R.string.chart_tooltip_metric_ops, sVar), w.s0.a(), sVar, i13 & 14);
            g(i10, t2.a.o(R.string.chart_tooltip_metric_intercepted, sVar), w.s0.a(), sVar, (i13 >> 3) & 14);
            g(i11, t2.a.o(R.string.chart_tooltip_metric_revocable, sVar), w.s0.a(), sVar, (i13 >> 6) & 14);
            sVar.q(true);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            k0 k0Var = new k0();
            k0Var.f11719c = i3;
            k0Var.f11720f = i10;
            k0Var.f11721g = i11;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = k0Var;
        }
    }

    public static final void i(m1 m1Var, String str, float f5, float f10, float f11, float f12, xb.l lVar, k0.s sVar, int i3) {
        sVar.Z(1796137862);
        int i10 = i3 | (sVar.f(m1Var) ? 32 : 16) | (sVar.f(str) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.c(f5) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.c(f10) ? 16384 : 8192) | (sVar.c(f11) ? 131072 : 65536) | (sVar.c(f12) ? 1048576 : 524288);
        if (sVar.P(i10 & 1, (4793491 & i10) != 4793490)) {
            o2.c cVar = (o2.c) sVar.j(v1.a1.f14363h);
            float fT = cVar.T();
            float f13 = i;
            float fX = cVar.X(f13);
            float f14 = f5 - (fX / 2.0f);
            float f15 = f11 - fX;
            if (f15 < f10) {
                f15 = f10;
            }
            float fM = cVar.M(p5.f.p(f14, f10, f15));
            float fP = p5.f.p(fT, 1.0f, 1.4f);
            float f16 = f12043g;
            float fX2 = cVar.X(fP * f16);
            float fX3 = cVar.X(f12044h);
            float fX4 = cVar.X(6);
            float f17 = (f12 - fX3) - fX2;
            if (f17 >= fX4) {
                fX4 = f17;
            }
            float fM2 = cVar.M(fX4);
            a0.d dVarA = a0.e.a(f12045j);
            float f18 = 0;
            w0.m mVarD = androidx.compose.foundation.layout.c.d(androidx.compose.foundation.layout.c.h(androidx.compose.foundation.layout.b.d(androidx.compose.foundation.layout.a.f901a.a(t.m0.l(w0.j.f15113c, 10.0f), w0.b.f15089c), fM, fM2), f13), f16, 0.0f, 2);
            Object objM = sVar.M();
            Object obj = objM;
            if (objM == k0.m.f6974a) {
                l9.l lVar2 = new l9.l(1);
                lVar2.f7807f = lVar;
                VarHandle.storeStoreFence();
                sVar.i0(lVar2);
                obj = lVar2;
            }
            w0.m mVarB = androidx.compose.ui.layout.a.b(mVarD, (xb.l) obj);
            j9.i iVar = new j9.i(5);
            iVar.f6671f = str;
            iVar.f6672g = m1Var;
            VarHandle.storeStoreFence();
            h0.q1.a(mVarB, dVarA, f12041e, 0L, f18, f12046k, s0.h.d(132927265, iVar, sVar), sVar, 12804480, 72);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            j0 j0Var = new j0();
            j0Var.f11685c = m1Var;
            j0Var.f11686f = str;
            j0Var.f11687g = f5;
            j0Var.f11688h = f10;
            j0Var.i = f11;
            j0Var.f11689j = f12;
            j0Var.f11690k = lVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = j0Var;
        }
    }

    public static final void j(xb.a aVar, xb.a aVar2, xb.a aVar3, boolean z10, k0.s sVar, int i3) {
        xb.a aVar4;
        xb.a aVar5;
        sVar.Z(1869617707);
        int i10 = i3 | (sVar.h(aVar) ? 4 : 2) | (sVar.h(aVar2) ? 32 : 16) | (sVar.h(aVar3) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.g(z10) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024);
        if (sVar.P(i10 & 1, (i10 & 1171) != 1170)) {
            int i11 = (int) x1.C;
            sVar.X(1406298992);
            lb.c cVarO = ac.a.o();
            aVar4 = aVar;
            cVarO.add(new l9.f("permission", t2.a.o(R.string.home_nav_permission_manager, sVar), Integer.valueOf(R.drawable.ic_home_entry_permission), Integer.valueOf(i11), aVar, 36));
            cVarO.add(new l9.f("screen_perception", t2.a.o(R.string.home_nav_screen_perception, sVar), Integer.valueOf(R.drawable.ic_home_entry_screen_perception), Integer.valueOf(i11), aVar2, 36));
            if (z10) {
                sVar.X(1963431491);
                aVar5 = aVar3;
                cVarO.add(new l9.f("operate_phone", t2.a.o(R.string.home_nav_operate_phone, sVar), null, null, aVar5, 60));
            } else {
                aVar5 = aVar3;
                sVar.X(700471079);
            }
            sVar.q(false);
            lb.c cVarK = ac.a.k(cVarO);
            sVar.q(false);
            l9.a.c(cVarK, null, 0, sVar, 0);
        } else {
            aVar4 = aVar;
            aVar5 = aVar3;
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            e9.f0 f0Var = new e9.f0(2);
            f0Var.f3648g = aVar4;
            f0Var.i = aVar2;
            f0Var.f3649h = aVar5;
            f0Var.f3647f = z10;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = f0Var;
        }
    }

    public static final void k(int i3, k0.s sVar) {
        sVar.Z(1806674374);
        int i10 = 1;
        if (sVar.P(i3 & 1, i3 != 0)) {
            List listF = ac.a.F(new jb.g(Integer.valueOf(R.drawable.ic_home_footer_encrypt), Integer.valueOf(R.string.home_security_footer_encrypt)), new jb.g(Integer.valueOf(R.drawable.ic_home_footer_protect), Integer.valueOf(R.string.home_security_footer_protect)), new jb.g(Integer.valueOf(R.drawable.ic_home_footer_gateway), Integer.valueOf(R.string.home_security_footer_gateway)));
            k0.s2 s2Var = v1.a1.f14363h;
            o2.c cVar = (o2.c) sVar.j(s2Var);
            boolean zC = sVar.c(cVar.a()) | sVar.c(cVar.T());
            Object objM = sVar.M();
            if (zC || objM == k0.m.f6974a) {
                float fA = cVar.a();
                float fT = cVar.T();
                if (fT > 1.2f) {
                    fT = 1.2f;
                }
                objM = p5.f.b(fA, fT);
                sVar.i0(objM);
            }
            k0.t1 t1VarA = s2Var.a((o2.c) objM);
            hc.p pVar = new hc.p(i10);
            pVar.f5466f = listF;
            VarHandle.storeStoreFence();
            k0.z.a(t1VarA, s0.h.d(1002626310, pVar, sVar), sVar, 56);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            k8.d dVar = new k8.d(16);
            VarHandle.storeStoreFence();
            v1VarS.f7091d = dVar;
        }
    }

    public static final void l(b2 b2Var, k0.s sVar, int i3) {
        k0.s sVar2 = sVar;
        sVar2.Z(283774180);
        int i10 = i3 | (sVar2.h(b2Var) ? 4 : 2);
        if (sVar2.P(i10 & 1, (i10 & 3) != 2)) {
            w0.j jVar = w0.j.f15113c;
            float f5 = 12;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), 16, f5);
            w.r0 r0VarA = w.p0.a(w.k.e(f5), w0.b.f15098o, sVar2, 54);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarG);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(r0VarA, sVar2, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar2, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar2, hVar4);
            h1.b bVarO = t1.e.o(R.drawable.ic_home_security_report, sVar2);
            s1.j.f11260d.getClass();
            t.m0.b(bVarO, androidx.compose.foundation.layout.c.f(jVar, x1.C), null, s1.i.f11255c, 0.0f, sVar2, 25008, 104);
            w.v vVarA = w.u.a(w.k.e(2), w0.b.f15100q, sVar2, 6);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL2 = sVar2.l();
            w0.m mVarM2 = t.o.m(sVar2, jVar);
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(vVarA, sVar2, hVar);
            k0.z.B(gVarL2, sVar2, hVar2);
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar2, iHashCode2, hVar3);
            }
            k0.z.B(mVarM2, sVar2, hVar4);
            String strP = t2.a.p(R.string.home_security_report_title, new Object[]{Integer.valueOf(b2Var.f11462b)}, sVar2);
            long j10 = x1.f12070a0;
            long j11 = x1.f12072b0;
            g2.k kVar = x1.f12074c0;
            long j12 = x1.f12092s;
            h0.t1.b(strP, null, j12, j10, kVar, 0L, null, j11, 0, false, 0, 0, null, sVar, 200064, 6, 130002);
            h0.t1.b(t2.a.p(R.string.home_security_report_subtitle, new Object[]{g1.y(b2Var.f11461a), g1.y(b2Var.f11463c)}, sVar), null, d1.p.c(0.6f, j12), x1.f12076d0, x1.f0, 0L, null, x1.e0, 0, false, 0, 0, null, sVar, 200064, 6, 130002);
            sVar2 = sVar;
            sVar2.q(true);
            sVar2.q(true);
        } else {
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            e9.m mVar = new e9.m(10);
            mVar.f3688f = b2Var;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = mVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(s8.d1 r45, java.util.List r46, int r47, boolean r48, xb.l r49, xb.l r50, xb.l r51, xb.l r52, xb.l r53, k0.s r54, int r55) {
        /*
            Method dump skipped, instructions count: 1314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.w0.m(s8.d1, java.util.List, int, boolean, xb.l, xb.l, xb.l, xb.l, xb.l, k0.s, int):void");
    }

    public static final void n(float f5, int i3, List list, xb.l lVar, float f10, long j10, k0.s sVar, int i10) {
        long j11;
        int i11;
        k0.s sVar2;
        v vVar;
        k0.v1 v1VarS;
        sVar.Z(-416686326);
        int i12 = i10 | (sVar.c(f5) ? 4 : 2) | (sVar.d(i3) ? 32 : 16) | (sVar.h(list) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.h(lVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.c(f10) ? 16384 : 8192);
        if (!sVar.P(i12 & 1, (74899 & i12) != 74898)) {
            j11 = j10;
            i11 = i3;
            sVar2 = sVar;
            sVar2.S();
        } else {
            if (i3 <= 0 || list.isEmpty()) {
                j11 = j10;
                i11 = i3;
                v1VarS = sVar.s();
                if (v1VarS != null) {
                    vVar = new v(0);
                    vVar.f12015f = f5;
                    vVar.f12016g = i11;
                    vVar.f12017h = list;
                    vVar.i = lVar;
                    vVar.f12018j = f10;
                    vVar.f12019k = j11;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = vVar;
                }
                return;
            }
            boolean zS = s(sVar);
            j11 = j10;
            d2.l0 l0VarA = d2.l0.a(((h0.v1) sVar.j(h0.w1.f5235a)).f5225o, f12039c, j11, g2.k.f4252g, null, 0L, com.stepos.statsrpk.h.t(13), null, 16646136);
            float f11 = zS ? 56 : 48;
            w0.m mVarD = androidx.compose.foundation.layout.c.d(androidx.compose.foundation.layout.c.h(w0.j.f15113c, f5), f10, 0.0f, 2);
            w wVar = new w();
            wVar.f12032c = list;
            wVar.f12033f = lVar;
            i11 = i3;
            wVar.f12034g = i11;
            wVar.f12035h = f11 / 2;
            wVar.i = f11;
            wVar.f12036j = l0VarA;
            VarHandle.storeStoreFence();
            sVar2 = sVar;
            t.m0.a(mVarD, null, s0.h.d(-1762819212, wVar, sVar2), sVar2, 3072);
        }
        v1VarS = sVar2.s();
        if (v1VarS != null) {
            vVar = new v(1);
            vVar.f12015f = f5;
            vVar.f12016g = i11;
            vVar.f12017h = list;
            vVar.i = lVar;
            vVar.f12018j = f10;
            vVar.f12019k = j11;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = vVar;
        }
    }

    public static final void o(float f5, float f10, long j10, k0.s sVar, int i3) {
        sVar.Z(604374071);
        int i10 = i3 | (sVar.c(f5) ? 4 : 2) | (sVar.c(f10) ? 32 : 16);
        if (sVar.P(i10 & 1, (i10 & 147) != 146)) {
            boolean zS = s(sVar);
            d2.l0 l0VarA = d2.l0.a(((h0.v1) sVar.j(h0.w1.f5235a)).f5225o, f12039c, j10, g2.k.f4252g, null, 0L, com.stepos.statsrpk.h.t(13), null, 16646136);
            float f11 = zS ? 56 : 44;
            w0.m mVarD = androidx.compose.foundation.layout.c.d(androidx.compose.foundation.layout.c.h(w0.j.f15113c, f5), f10, 0.0f, 2);
            p0 p0Var = new p0();
            p0Var.f11865c = zS;
            p0Var.f11866f = f11 / 2;
            p0Var.f11867g = f11;
            p0Var.f11868h = l0VarA;
            VarHandle.storeStoreFence();
            t.m0.a(mVarD, null, s0.h.d(-211996275, p0Var, sVar), sVar, 3072);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            q0 q0Var = new q0();
            q0Var.f11902c = f5;
            q0Var.f11903f = f10;
            q0Var.f11904g = j10;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = q0Var;
        }
    }

    public static final void p(d1 d1Var, xb.l lVar, ZoneId zoneId, List list, List list2, List list3, List list4, m8.l0 l0Var, b2 b2Var, int i3, xb.a aVar, xb.p pVar, k0.s sVar, int i10) {
        xb.a aVar2;
        k0.c1 c1Var;
        k0.c1 c1Var2;
        xb.l lVar2;
        k0.c1 c1Var3;
        k0.c1 c1Var4;
        k0.c1 c1Var5;
        k0.c1 c1Var6;
        k0.c1 c1Var7;
        k0.c1 c1Var8;
        k0.c1 c1Var9;
        xb.l lVar3 = lVar;
        ZoneId zoneId2 = zoneId;
        b2 b2Var2 = b2Var;
        int i11 = i3;
        xb.p pVar2 = pVar;
        sVar.Z(1043328707);
        int i12 = i10 | (sVar.d(d1Var.ordinal()) ? 4 : 2) | (sVar.h(lVar3) ? 32 : 16) | (sVar.h(zoneId2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.h(list) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(list2) ? 16384 : 8192) | (sVar.h(list3) ? 131072 : 65536) | (sVar.h(list4) ? 1048576 : 524288) | (sVar.d(l0Var.ordinal()) ? 8388608 : 4194304) | (sVar.h(b2Var2) ? 67108864 : 33554432) | (sVar.d(i11) ? 536870912 : 268435456);
        if (sVar.P(i12 & 1, ((306783379 & i12) == 306783378 && (((sVar.h(aVar) ? (char) 4 : (char) 2) | (sVar.h(pVar2) ? ' ' : (char) 16)) & 19) == 18) ? false : true)) {
            String strO = t2.a.o(R.string.date_format_month_day, sVar);
            boolean zF = sVar.f(zoneId2) | sVar.f(strO);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            Object obj2 = objM;
            if (zF || objM == obj) {
                DateTimeFormatter dateTimeFormatterWithZone = DateTimeFormatter.ofPattern(strO, Locale.getDefault()).withZone(zoneId2);
                a9.e eVar = new a9.e(13);
                eVar.f257f = dateTimeFormatterWithZone;
                VarHandle.storeStoreFence();
                sVar.i0(eVar);
                obj2 = eVar;
            }
            xb.l lVar4 = (xb.l) obj2;
            Object objM2 = sVar.M();
            if (objM2 == obj) {
                objM2 = k0.z.v(null);
                sVar.i0(objM2);
            }
            k0.c1 c1Var10 = (k0.c1) objM2;
            Object objM3 = sVar.M();
            if (objM3 == obj) {
                objM3 = new k0.h1(0);
                sVar.i0(objM3);
            }
            k0.h1 h1Var = (k0.h1) objM3;
            Object objM4 = sVar.M();
            if (objM4 == obj) {
                objM4 = k0.z.v(null);
                sVar.i0(objM4);
            }
            k0.c1 c1Var11 = (k0.c1) objM4;
            Object objM5 = sVar.M();
            if (objM5 == obj) {
                objM5 = k0.z.v(null);
                sVar.i0(objM5);
            }
            k0.c1 c1Var12 = (k0.c1) objM5;
            Object objM6 = sVar.M();
            if (objM6 == obj) {
                objM6 = k0.z.v(c1.b.a(0L));
                sVar.i0(objM6);
            }
            k0.c1 c1Var13 = (k0.c1) objM6;
            Object objM7 = sVar.M();
            if (objM7 == obj) {
                objM7 = k0.z.v(new e1());
                sVar.i0(objM7);
            }
            k0.c1 c1Var14 = (k0.c1) objM7;
            Object objM8 = sVar.M();
            if (objM8 == obj) {
                objM8 = k0.z.v(null);
                sVar.i0(objM8);
            }
            k0.c1 c1Var15 = (k0.c1) objM8;
            Object objM9 = sVar.M();
            if (objM9 == obj) {
                objM9 = k0.z.v(null);
                sVar.i0(objM9);
            }
            k0.c1 c1Var16 = (k0.c1) objM9;
            k0.s1 s1Var = v1.a1.f14363h;
            float fX = ((o2.c) sVar.j(s1Var)).X(f12051p);
            o2.c cVar = (o2.c) sVar.j(s1Var);
            List listN = g1.n(d1Var, list, list2, list3, list4);
            boolean z10 = d1Var != d1.f11542h && (l0Var != m8.l0.f8440c || d1Var == d1.f11541g || (d1Var == d1.f11540f && !list2.isEmpty()));
            Integer num = (Integer) c1Var10.getValue();
            Integer numValueOf = Integer.valueOf(h1Var.g());
            Object objM10 = sVar.M();
            if (objM10 == obj) {
                objM10 = new s0(c1Var10, c1Var16, null);
                sVar.i0(objM10);
            }
            k0.z.g(num, numValueOf, (xb.p) objM10, sVar);
            Object objM11 = sVar.M();
            if (objM11 == obj) {
                c1Var = c1Var10;
                objM11 = new g9.y(c1Var, c1Var16, c1Var14, c1Var15, null, 4);
                sVar.i0(objM11);
            } else {
                c1Var = c1Var10;
            }
            k0.z.h(d1Var, sVar, (xb.p) objM11);
            Integer num2 = (Integer) c1Var.getValue();
            s1.q qVar = (s1.q) c1Var12.getValue();
            s1.q qVar2 = (s1.q) c1Var15.getValue();
            Object objM12 = sVar.M();
            if (objM12 == obj) {
                lVar2 = lVar4;
                objM12 = new t0(c1Var, c1Var11, c1Var12, c1Var13, c1Var15, c1Var14, null);
                c1Var5 = c1Var11;
                c1Var7 = c1Var13;
                c1Var4 = c1Var15;
                c1Var3 = c1Var14;
                c1Var2 = c1Var16;
                c1Var6 = c1Var12;
                sVar.i0(objM12);
            } else {
                c1Var2 = c1Var16;
                lVar2 = lVar4;
                c1Var3 = c1Var14;
                c1Var4 = c1Var15;
                c1Var5 = c1Var11;
                c1Var6 = c1Var12;
                c1Var7 = c1Var13;
            }
            k0.z.f(num2, qVar, qVar2, (xb.p) objM12, sVar);
            Integer num3 = (Integer) c1Var.getValue();
            boolean zH = sVar.h(listN);
            Object objM13 = sVar.M();
            if (zH || objM13 == obj) {
                k0.c1 c1Var17 = c1Var2;
                k0.c1 c1Var18 = c1Var;
                objM13 = new g9.f0(listN, c1Var18, c1Var17, null, 5);
                c1Var8 = c1Var18;
                c1Var9 = c1Var17;
                sVar.i0(objM13);
            } else {
                c1Var8 = c1Var;
                c1Var9 = c1Var2;
            }
            k0.z.g(listN, num3, (xb.p) objM13, sVar);
            a0.d dVarA = a0.e.a(x1.D);
            long j10 = x1.E;
            float f5 = 0;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(w0.j.f15113c, 1.0f);
            d0 d0Var = new d0();
            d0Var.f11518c = dVarA;
            d0Var.f11519f = c1Var5;
            d0Var.f11520g = c1Var6;
            d0Var.f11521h = c1Var7;
            d0Var.i = c1Var4;
            d0Var.f11522j = c1Var3;
            d0Var.f11523k = d1Var;
            d0Var.f11524l = z10;
            d0Var.f11525m = listN;
            d0Var.f11526n = fX;
            d0Var.f11527o = cVar;
            d0Var.f11528p = lVar2;
            i11 = i3;
            d0Var.f11529q = i11;
            b2Var2 = b2Var;
            d0Var.f11530r = b2Var2;
            zoneId2 = zoneId;
            d0Var.f11531s = zoneId2;
            pVar2 = pVar;
            d0Var.f11532t = pVar2;
            d0Var.f11533u = d1Var;
            lVar3 = lVar;
            d0Var.f11534v = lVar3;
            aVar2 = aVar;
            d0Var.f11535w = aVar2;
            d0Var.f11536x = c1Var8;
            d0Var.f11537y = h1Var;
            d0Var.f11538z = c1Var9;
            VarHandle.storeStoreFence();
            h0.q1.a(mVarB, dVarA, j10, 0L, f5, f5, s0.h.d(146511966, d0Var, sVar), sVar, 12804486, 72);
        } else {
            aVar2 = aVar;
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            e0 e0Var = new e0();
            e0Var.f11555c = d1Var;
            e0Var.f11556f = lVar3;
            e0Var.f11557g = zoneId2;
            e0Var.f11558h = list;
            e0Var.i = list2;
            e0Var.f11559j = list3;
            e0Var.f11560k = list4;
            e0Var.f11561l = l0Var;
            e0Var.f11562m = b2Var2;
            e0Var.f11563n = i11;
            e0Var.f11564o = aVar2;
            e0Var.f11565p = pVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = e0Var;
        }
    }

    public static final void q(k0.c1 c1Var, k0.c1 c1Var2, k0.c1 c1Var3) {
        s1.q qVar;
        s1.q qVar2 = (s1.q) c1Var.getValue();
        if (qVar2 != null && (qVar = (s1.q) c1Var2.getValue()) != null && qVar2.k() && qVar.k()) {
            try {
                long jB = qVar2.B(qVar, 0L);
                long j10 = ((c1.b) c1Var3.getValue()).f2165a;
                if (c1.b.c(j10, 0L) || c1.b.d(c1.b.g(jB, j10)) > 0.5f) {
                    c1Var3.setValue(c1.b.a(jB));
                }
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public static final void r(k0.c1 c1Var, k0.c1 c1Var2, k0.c1 c1Var3) {
        s1.q qVar;
        Object objL;
        s1.q qVar2 = (s1.q) c1Var.getValue();
        if (qVar2 != null && (qVar = (s1.q) c1Var2.getValue()) != null && qVar2.k() && qVar.k() && ((int) (qVar.l() >> 32)) > 0) {
            try {
                long jB = qVar2.B(qVar, 0L);
                int i3 = (int) (jB >> 32);
                objL = new jb.l(Float.valueOf(Float.intBitsToFloat(i3)), Float.valueOf(Float.intBitsToFloat(i3) + ((int) (qVar.l() >> 32))), Float.valueOf(Float.intBitsToFloat((int) (jB & 4294967295L))));
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            if (objL instanceof jb.h) {
                objL = null;
            }
            jb.l lVar = (jb.l) objL;
            if (lVar == null) {
                return;
            }
            float fFloatValue = ((Number) lVar.f6769c).floatValue();
            float fFloatValue2 = ((Number) lVar.f6770f).floatValue();
            float fFloatValue3 = ((Number) lVar.f6771g).floatValue();
            if (fFloatValue2 <= fFloatValue) {
                return;
            }
            c1Var3.setValue(new e1(fFloatValue, fFloatValue2, fFloatValue3));
        }
    }

    public static final boolean s(k0.s sVar) {
        return ((o2.c) sVar.j(v1.a1.f14363h)).T() >= 1.15f;
    }

    public static final w0.m t(w0.m mVar, int i3, float f5, xb.l lVar, xb.l lVar2, xb.l lVar3, xb.l lVar4) {
        Integer numValueOf = Integer.valueOf(i3);
        o2.f fVarA = o2.f.a(f5);
        v0 v0Var = new v0();
        v0Var.f12020c = i3;
        v0Var.f12021f = f5;
        v0Var.f12022g = lVar;
        v0Var.f12023h = lVar3;
        v0Var.i = lVar4;
        v0Var.f12024j = lVar2;
        VarHandle.storeStoreFence();
        o1.j jVar = o1.d0.f9016a;
        return mVar.d(new SuspendPointerInputElement(numValueOf, fVarA, v0Var, 4));
    }
}

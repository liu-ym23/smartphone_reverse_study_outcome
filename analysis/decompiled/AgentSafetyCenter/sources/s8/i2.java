package s8;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i2 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11662a = d1.f0.c(4294309367L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f11663b = d1.f0.c(4287532691L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f11664c = d1.f0.c(4281084974L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f11665d = d1.f0.c(4282006076L);

    /* renamed from: e, reason: collision with root package name */
    public static final DateTimeFormatter f11666e;

    static {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("M月d日 HH:mm");
        dateTimeFormatterOfPattern.getClass();
        f11666e = dateTimeFormatterOfPattern;
    }

    public static final void a(String str, u8.k kVar, w0.m mVar, k0.s sVar, int i) {
        int i3;
        int i10;
        boolean z10;
        k0.s sVar2 = sVar;
        sVar2.Z(1945116825);
        if ((i & 6) == 0) {
            i3 = (sVar2.f(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar2.f(kVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar2.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if (!sVar2.P(i3 & 1, (i3 & 147) != 146)) {
            i10 = 1;
            sVar2.S();
        } else {
            if (str.length() == 0 && !g(kVar)) {
                k0.v1 v1VarS = sVar2.s();
                if (v1VarS != null) {
                    h2 h2Var = new h2(0);
                    h2Var.f11644f = str;
                    h2Var.f11645g = kVar;
                    h2Var.f11646h = mVar;
                    h2Var.i = i;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = h2Var;
                    return;
                }
                return;
            }
            w0.m mVarB = androidx.compose.foundation.layout.c.b(mVar, 1.0f);
            w.r0 r0VarA = w.p0.a(w.k.f14990a, w0.b.f15098o, sVar2, 54);
            int iHashCode = Long.hashCode(sVar2.T);
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
            k0.z.B(r0VarA, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            if (g(kVar)) {
                sVar2.X(122812459);
                c(kVar, sVar2, (i3 >> 3) & 14);
            } else {
                sVar2.X(115922213);
            }
            sVar2.q(false);
            if (str.length() > 0) {
                sVar2.X(122914852);
                if (g(kVar)) {
                    sVar2.X(122945790);
                    t0.a.b(sVar2, androidx.compose.foundation.layout.c.h(w0.j.f15113c, 8));
                } else {
                    sVar2.X(115922213);
                }
                sVar2.q(false);
                h0.t1.b(str, null, f11663b, 0L, null, 0L, null, 0L, 0, false, 1, 0, ((h0.v1) sVar2.j(h0.w1.f5235a)).f5224n, sVar, (i3 & 14) | 384, 3072, 57338);
                sVar2 = sVar;
                z10 = false;
            } else {
                z10 = false;
                sVar2.X(115922213);
            }
            sVar2.q(z10);
            i10 = 1;
            sVar2.q(true);
        }
        k0.v1 v1VarS2 = sVar2.s();
        if (v1VarS2 != null) {
            h2 h2Var2 = new h2(i10);
            h2Var2.f11644f = str;
            h2Var2.f11645g = kVar;
            h2Var2.f11646h = mVar;
            h2Var2.i = i;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = h2Var2;
        }
    }

    public static final void b(u8.k kVar, String str, k0.s sVar, int i) {
        String str2;
        int i3;
        w0.j jVar;
        boolean z10;
        k0.s sVar2 = sVar;
        sVar2.Z(1853126013);
        int i10 = i | (sVar2.f(kVar) ? 4 : 2) | (sVar2.f(str) ? 32 : 16);
        if (sVar2.P(i10 & 1, (i10 & 19) != 18)) {
            int i11 = kVar.f14227j;
            int i12 = i11 < 1 ? 1 : i11;
            int i13 = kVar.f14224f == w8.b.i ? R.drawable.img_note_placeholder_multi : R.drawable.img_note_placeholder_single;
            w0.j jVar2 = w0.j.f15113c;
            w0.m mVarF = androidx.compose.foundation.layout.b.f(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), 12);
            w.r0 r0VarA = w.p0.a(w.k.f14990a, w0.b.f15098o, sVar2, 48);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarF);
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
            w0.m mVarA = w.s0.a();
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL2 = sVar2.l();
            w0.m mVarM2 = t.o.m(sVar2, mVarA);
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
            sVar2.X(872053260);
            String string = hc.h.w0(kVar.f14219a).toString();
            if (string.length() == 0) {
                string = t2.a.o(R.string.home_note_image_collection_title, sVar2);
            }
            sVar2.q(false);
            k0.s2 s2Var = h0.w1.f5235a;
            int i14 = i13;
            h0.t1.b(string, null, f11662a, 0L, g2.k.f4253h, 0L, null, 0L, 2, false, 1, 0, ((h0.v1) sVar2.j(s2Var)).f5221k, sVar, 196992, 3120, 55258);
            String strP = t2.a.p(R.string.home_note_image_count, new Object[]{Integer.valueOf(i12)}, sVar);
            d2.l0 l0Var = ((h0.v1) sVar.j(s2Var)).f5224n;
            float f5 = 4;
            w0.m mVarJ = androidx.compose.foundation.layout.b.j(jVar2, 0.0f, f5, 0.0f, 0.0f, 13);
            long j10 = f11663b;
            h0.t1.b(strP, mVarJ, j10, 0L, null, 0L, null, 0L, 2, false, 1, 0, l0Var, sVar, 432, 3120, 55288);
            sVar2 = sVar;
            if (str.length() > 0) {
                sVar2.X(1264588434);
                jVar = jVar2;
                h0.t1.b(str, androidx.compose.foundation.layout.b.j(jVar2, 0.0f, f5, 0.0f, 0.0f, 13), j10, 0L, null, 0L, null, 0L, 0, false, 1, 0, ((h0.v1) sVar2.j(s2Var)).f5224n, sVar, ((i10 >> 3) & 14) | 432, 3072, 57336);
                str2 = str;
                sVar2 = sVar;
                z10 = false;
            } else {
                str2 = str;
                jVar = jVar2;
                z10 = false;
                sVar2.X(1258750111);
            }
            sVar2.q(z10);
            i3 = 1;
            sVar2.q(true);
            t0.a.b(sVar2, androidx.compose.foundation.layout.c.h(jVar, 10));
            h1.b bVarO = t1.e.o(i14, sVar2);
            w0.m mVarG = com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.f(jVar, 56), a0.e.a(8));
            s1.j.f11260d.getClass();
            t.m0.b(bVarO, mVarG, null, s1.i.f11254b, 0.0f, sVar2, 24624, 104);
            sVar2.q(true);
        } else {
            str2 = str;
            i3 = 1;
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            g2 g2Var = new g2(i3);
            g2Var.f11620f = kVar;
            g2Var.f11621g = str2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = g2Var;
        }
    }

    public static final void c(u8.k kVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-1971607636);
        if ((i & 6) == 0) {
            i3 = (sVar.f(kVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (sVar.P(i3 & 1, (i3 & 3) != 2)) {
            w.r0 r0VarA = w.p0.a(w.k.e(6), w0.b.f15098o, sVar, 54);
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
            if (kVar.f14225g) {
                sVar.X(-140847001);
                t.m0.b(t1.e.o(R.drawable.ic_note_badge_image, sVar), androidx.compose.foundation.layout.c.f(jVar, 14), null, null, 0.0f, sVar, 432, 120);
            } else {
                sVar.X(-148536582);
            }
            sVar.q(false);
            if (kVar.f14226h) {
                sVar.X(-140601977);
                t.m0.b(t1.e.o(R.drawable.ic_note_badge_audio, sVar), androidx.compose.foundation.layout.c.f(jVar, 14), null, null, 0.0f, sVar, 432, 120);
            } else {
                sVar.X(-148536582);
            }
            sVar.q(false);
            if (kVar.i) {
                sVar.X(-140357976);
                t.m0.b(t1.e.o(R.drawable.ic_note_badge_file, sVar), androidx.compose.foundation.layout.c.f(jVar, 14), null, null, 0.0f, sVar, 432, 120);
            } else {
                sVar.X(-148536582);
            }
            sVar.q(false);
            sVar.q(true);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            g gVar = new g(2);
            gVar.f11609g = kVar;
            gVar.f11608f = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = gVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static final void d(u8.k kVar, String str, k0.s sVar, int i) {
        u8.k kVar2;
        String str2;
        k0.s sVar2;
        String str3;
        ?? r02;
        w0.j jVar;
        k0.s sVar3;
        int i3;
        k0.s sVar4;
        int i10;
        float f5;
        k0.s sVar5 = sVar;
        sVar5.Z(-441787513);
        int i11 = i | (sVar5.f(kVar) ? 4 : 2) | (sVar5.f(str) ? 32 : 16);
        if (sVar5.P(i11 & 1, (i11 & 19) != 18)) {
            w8.b bVar = kVar.f14224f;
            String str4 = kVar.f14220b;
            String str5 = kVar.f14219a;
            boolean z10 = (bVar == w8.b.f15374g || bVar == w8.b.f15376j || hc.h.g0(str5)) ? false : true;
            int iOrdinal = kVar.f14224f.ordinal();
            boolean z11 = iOrdinal != 1 && (iOrdinal == 5 ? !hc.h.g0(str4) : !hc.h.g0(str4));
            w0.j jVar2 = w0.j.f15113c;
            w0.m mVarF = androidx.compose.foundation.layout.b.f(androidx.compose.foundation.layout.c.b(jVar2, 1.0f), 12);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar5, 0);
            int iHashCode = Long.hashCode(sVar5.T);
            s0.g gVarL = sVar5.l();
            w0.m mVarM = t.o.m(sVar5, mVarF);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar5.b0();
            if (sVar5.S) {
                sVar5.k(zVar);
            } else {
                sVar5.l0();
            }
            k0.z.B(vVarA, sVar5, u1.i.f13836e);
            k0.z.B(gVarL, sVar5, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar5.S || !yb.k.a(sVar5.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar5, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar5, u1.i.f13834c);
            if (z10) {
                sVar5.X(-494838992);
                str3 = str4;
                r02 = 0;
                jVar = jVar2;
                h0.t1.b(str5, null, f11662a, 0L, g2.k.f4253h, 0L, null, 0L, 2, false, 1, 0, ((h0.v1) sVar5.j(h0.w1.f5235a)).f5221k, sVar, 196992, 3120, 55258);
                sVar3 = sVar;
            } else {
                str3 = str4;
                r02 = 0;
                jVar = jVar2;
                sVar5.X(-498493179);
                sVar3 = sVar5;
            }
            sVar3.q(r02);
            if (z11) {
                sVar3.X(-494508470);
                d2.l0 l0Var = ((h0.v1) sVar3.j(h0.w1.f5235a)).f5224n;
                if (z10) {
                    i10 = 4;
                    f5 = 4;
                } else {
                    i10 = 4;
                    f5 = (float) r02;
                }
                k0.s sVar6 = sVar3;
                i3 = i10;
                h0.t1.b(str3, androidx.compose.foundation.layout.b.j(jVar, 0.0f, f5, 0.0f, 0.0f, 13), f11663b, 0L, null, 0L, null, 0L, 2, false, 1, 0, l0Var, sVar6, 384, 3120, 55288);
                sVar4 = sVar6;
            } else {
                i3 = 4;
                sVar3.X(-498493179);
                sVar4 = sVar3;
            }
            sVar4.q(r02);
            kVar2 = kVar;
            str2 = str;
            a(str2, kVar2, androidx.compose.foundation.layout.b.j(jVar, 0.0f, i3, 0.0f, 0.0f, 13), sVar4, ((i11 >> 3) & 14) | 384 | ((i11 << 3) & 112));
            sVar4.q(true);
            sVar2 = sVar4;
        } else {
            kVar2 = kVar;
            str2 = str;
            sVar5.S();
            sVar2 = sVar5;
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            g2 g2Var = new g2(2);
            g2Var.f11620f = kVar2;
            g2Var.f11621g = str2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = g2Var;
        }
    }

    public static final void e(u8.k kVar, w0.m mVar, k0.s sVar, int i) {
        w0.m mVar2;
        String str;
        kVar.getClass();
        long j10 = kVar.f14221c;
        sVar.Z(1321624761);
        int i3 = i | (sVar.f(kVar) ? 4 : 2) | 48;
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            boolean zE = sVar.e(j10);
            Object objM = sVar.M();
            if (zE || objM == k0.m.f6974a) {
                ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
                zoneIdSystemDefault.getClass();
                if (j10 <= 0) {
                    str = "";
                } else {
                    str = Instant.ofEpochMilli(j10).atZone(zoneIdSystemDefault).format(f11666e);
                    str.getClass();
                }
                objM = str;
                sVar.i0(objM);
            }
            a0.d dVarA = a0.e.a(12);
            mVar2 = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(mVar2, 1.0f);
            g2 g2Var = new g2(0);
            g2Var.f11620f = kVar;
            g2Var.f11621g = (String) objM;
            VarHandle.storeStoreFence();
            h0.q1.a(mVarB, dVarA, f11664c, 0L, 0.0f, 0.0f, s0.h.d(1952834110, g2Var, sVar), sVar, 12583296, 120);
        } else {
            sVar.S();
            mVar2 = mVar;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            j9.i iVar = new j9.i(9);
            iVar.f6671f = kVar;
            iVar.f6672g = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = iVar;
        }
    }

    public static final void f(List list, w0.m mVar, int i, k0.s sVar, int i3) {
        w0.m mVar2;
        int i10;
        w0.j jVar;
        list.getClass();
        sVar.Z(-759917936);
        int i11 = i3 | (sVar.h(list) ? 4 : 2) | 432;
        int i12 = 1;
        if (sVar.P(i11 & 1, (i11 & 147) != 146)) {
            int i13 = 3;
            if (list.isEmpty()) {
                k0.v1 v1VarS = sVar.s();
                if (v1VarS != null) {
                    hc.p pVar = new hc.p(i13);
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
            w0.j jVar2 = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar2, 1.0f);
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
            sVar.X(1648741568);
            Iterator it = listJ0.iterator();
            while (it.hasNext()) {
                e((u8.k) it.next(), null, sVar, 0);
            }
            sVar.q(false);
            if (size > 0) {
                sVar.X(-428517882);
                a0.d dVarA = a0.e.a(12);
                w0.m mVarB2 = androidx.compose.foundation.layout.c.b(jVar2, 1.0f);
                boolean zF = sVar.f(c1Var);
                Object objM2 = sVar.M();
                Object obj2 = objM2;
                if (zF || objM2 == obj) {
                    e9.s sVar2 = new e9.s(9);
                    sVar2.f3721f = c1Var;
                    VarHandle.storeStoreFence();
                    sVar.i0(sVar2);
                    obj2 = sVar2;
                }
                w0.m mVarE = androidx.compose.foundation.a.e(mVarB2, false, null, (xb.a) obj2, 7);
                h1 h1Var = new h1(i12);
                h1Var.f11642f = size;
                VarHandle.storeStoreFence();
                jVar = jVar2;
                i10 = 3;
                h0.q1.a(mVarE, dVarA, f11665d, 0L, 0.0f, 0.0f, s0.h.d(1919419748, h1Var, sVar), sVar, 12583296, 120);
            } else {
                jVar = jVar2;
                i10 = 3;
                sVar.X(-437656248);
            }
            sVar.q(false);
            sVar.q(true);
            mVar2 = jVar;
        } else {
            sVar.S();
            mVar2 = mVar;
            i10 = i;
        }
        k0.v1 v1VarS2 = sVar.s();
        if (v1VarS2 != null) {
            l9.e eVar = new l9.e(2);
            eVar.f7774f = list;
            eVar.f7775g = mVar2;
            eVar.f7776h = i10;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = eVar;
        }
    }

    public static final boolean g(u8.k kVar) {
        return kVar.f14225g || kVar.f14226h || kVar.i;
    }
}

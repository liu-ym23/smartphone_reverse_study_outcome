package s8;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class z1 {

    /* renamed from: a, reason: collision with root package name */
    public static final float f12164a = 140;

    public static final void a(o1 o1Var, int i, int i3, int i10, xb.a aVar, w0.m mVar, k0.s sVar, int i11) {
        w0.m mVar2;
        a2 a2Var;
        int i12;
        long j10;
        k0.s sVar2 = sVar;
        sVar2.Z(-423011446);
        int i13 = i11 | (sVar2.d(o1Var.ordinal()) ? 4 : 2) | (sVar2.d(i) ? 32 : 16) | (sVar2.d(i3) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar2.d(i10) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar2.h(aVar) ? 16384 : 8192) | 196608;
        if (sVar2.P(i13 & 1, (74899 & i13) != 74898)) {
            int iOrdinal = o1Var.ordinal();
            if (iOrdinal == 0) {
                a2Var = new a2(R.string.home_hero_title_safe, R.string.home_hero_body_safe, R.drawable.ic_home_hero_safe);
            } else if (iOrdinal == 1) {
                a2Var = new a2(R.string.home_hero_title_running, R.string.home_hero_body_running, R.drawable.ic_home_hero_safe);
            } else {
                if (iOrdinal != 2) {
                    g5.f.a();
                    return;
                }
                a2Var = new a2(R.string.home_hero_title_attention, R.string.home_hero_body_attention, R.drawable.ic_home_hero_attention);
            }
            int iOrdinal2 = o1Var.ordinal();
            if (iOrdinal2 == 0) {
                i12 = i;
            } else if (iOrdinal2 == 1) {
                i12 = i3;
            } else {
                if (iOrdinal2 != 2) {
                    g5.f.a();
                    return;
                }
                i12 = i10;
            }
            if (i12 < 0) {
                i12 = 0;
            }
            String strValueOf = String.valueOf(i12);
            String strP = t2.a.p(a2Var.f11449b, new Object[]{Integer.valueOf(i12)}, sVar2);
            int iE0 = hc.h.e0(strP, strValueOf, 0, false, 6);
            int iOrdinal3 = o1Var.ordinal();
            if (iOrdinal3 == 0 || iOrdinal3 == 1) {
                j10 = x1.f12096w;
            } else {
                if (iOrdinal3 != 2) {
                    g5.f.a();
                    return;
                }
                j10 = x1.f12097x;
            }
            long j11 = j10;
            d2.d dVar = new d2.d();
            dVar.f3071c.append(strP);
            if (iE0 >= 0) {
                dVar.a(new d2.e0(j11, 0L, g2.k.i, (g2.i) null, (g2.j) null, (g2.q) null, (String) null, 0L, (n2.a) null, (n2.p) null, (j2.b) null, 0L, (n2.l) null, (d1.i0) null, 65530), iE0, strValueOf.length() + iE0);
            }
            d2.g gVarE = dVar.e();
            xb.a aVar2 = o1Var == o1.f11838g ? aVar : null;
            String strO = t2.a.o(R.string.cd_open_intercepted_records, sVar2);
            w0.j jVar = w0.j.f15113c;
            w0.m mVarD = androidx.compose.foundation.layout.c.d(androidx.compose.foundation.layout.c.b(jVar, 1.0f), x1.f12090q, 0.0f, 2).d(aVar2 != null ? androidx.compose.foundation.a.e(jVar, false, strO, aVar2, 5) : jVar);
            w0.e eVar = w0.b.f15089c;
            s1.f0 f0VarE = w.p.e(eVar, false);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarD);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(f0VarE, sVar2, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar2, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar2, hVar4);
            androidx.compose.foundation.layout.a aVar3 = androidx.compose.foundation.layout.a.f901a;
            w0.m mVarI = androidx.compose.foundation.layout.b.i(aVar3.a(jVar, eVar), 16, x1.f12091r, 156, 12);
            w.v vVarA = w.u.a(w.k.e(4), w0.b.f15100q, sVar2, 6);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL2 = sVar2.l();
            w0.m mVarM2 = t.o.m(sVar2, mVarI);
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
            mVar2 = jVar;
            a2 a2Var2 = a2Var;
            h0.t1.b(t2.a.o(a2Var.f11448a, sVar2), null, x1.f12092s, x1.G, x1.H, 0L, null, x1.I, 0, false, 0, 0, null, sVar, 200064, 6, 130002);
            h0.t1.c(gVarE, null, o1Var == o1.f11837f ? x1.f12096w : x1.f12094u, x1.J, x1.K, 0L, x1.L, 0, false, 0, 0, null, null, null, sVar, 199680);
            sVar2 = sVar;
            sVar2.q(true);
            h1.b bVarO = t1.e.o(a2Var2.f11450c, sVar2);
            s1.j.f11260d.getClass();
            t.m0.b(bVarO, androidx.compose.foundation.layout.c.f(aVar3.a(mVar2, w0.b.f15093j), f12164a), null, s1.i.f11255c, 0.0f, sVar2, 24624, 104);
            sVar2.q(true);
        } else {
            sVar2.S();
            mVar2 = mVar;
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            y1 y1Var = new y1();
            y1Var.f12119c = o1Var;
            y1Var.f12120f = i;
            y1Var.f12121g = i3;
            y1Var.f12122h = i10;
            y1Var.i = aVar;
            y1Var.f12123j = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = y1Var;
        }
    }
}

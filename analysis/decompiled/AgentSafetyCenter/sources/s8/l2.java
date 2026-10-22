package s8;

import android.content.Context;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l2 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11764a = d1.f0.c(4278913804L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f11765b = d1.f0.c(4280032286L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f11766c = d1.f0.c(4293783021L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f11767d = d1.f0.c(4294309367L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f11768e = d1.f0.c(4287532691L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f11769f = d1.f0.c(4287532691L);

    /* renamed from: g, reason: collision with root package name */
    public static final long f11770g = d1.f0.c(4284374627L);

    /* renamed from: h, reason: collision with root package name */
    public static final long f11771h = d1.f0.c(4281084974L);
    public static final long i = d1.f0.c(4287532691L);

    /* renamed from: j, reason: collision with root package name */
    public static final long f11772j = d1.f0.c(4281303295L);

    /* renamed from: k, reason: collision with root package name */
    public static final long f11773k = d1.f0.b(858751231);

    /* renamed from: l, reason: collision with root package name */
    public static final long f11774l = d1.f0.c(4282006076L);

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f11775m = 0;

    public static final void a(xb.a aVar, w0.m mVar, k0.s sVar, int i3) {
        aVar.getClass();
        sVar.Z(649599015);
        int i10 = i3 | (sVar.h(aVar) ? 4 : 2) | 48;
        if (sVar.P(i10 & 1, (i10 & 19) != 18)) {
            Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            if (objM == obj) {
                objM = g9.p0.f4573h.b(context);
                sVar.i0(objM);
            }
            g9.p0 p0Var = (g9.p0) objM;
            k0.c1 c1VarS = h5.t.s(p0Var.f4579f, sVar);
            Object objM2 = sVar.M();
            if (objM2 == obj) {
                objM2 = (g9.f1) g9.k1.f4513a.getValue();
                sVar.i0(objM2);
            }
            Object obj2 = (g9.f1) objM2;
            Object objM3 = sVar.M();
            if (objM3 == obj) {
                objM3 = k0.z.o(sVar);
                sVar.i0(objM3);
            }
            kc.t tVar = (kc.t) objM3;
            Object objM4 = sVar.M();
            if (objM4 == obj) {
                objM4 = k0.z.v(null);
                sVar.i0(objM4);
            }
            k0.c1 c1Var = (k0.c1) objM4;
            boolean zH = sVar.h(obj2);
            Object objM5 = sVar.M();
            Object obj3 = objM5;
            if (zH || objM5 == obj) {
                e9.j jVar = new e9.j(12);
                jVar.f3666f = c1Var;
                jVar.f3667g = obj2;
                VarHandle.storeStoreFence();
                sVar.i0(jVar);
                obj3 = jVar;
            }
            xb.a aVar2 = (xb.a) obj3;
            boolean zH2 = sVar.h(p0Var);
            Object objM6 = sVar.M();
            if (zH2 || objM6 == obj) {
                objM6 = new androidx.room.e(p0Var, null, 9);
                sVar.i0(objM6);
            }
            k0.z.h(jb.v.f6774a, sVar, (xb.p) objM6);
            boolean z10 = ((g9.o1) c1Var.getValue()) != null;
            j9.v vVar = new j9.v(2);
            vVar.f6723f = aVar;
            vVar.f6725h = c1VarS;
            vVar.i = obj2;
            vVar.f6724g = c1Var;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(2066092801, vVar, sVar);
            e9.o oVar = new e9.o(1);
            oVar.i = obj2;
            oVar.f3700f = tVar;
            oVar.f3703j = p0Var;
            oVar.f3701g = aVar2;
            oVar.f3702h = c1Var;
            VarHandle.storeStoreFence();
            s0.c cVarD2 = s0.h.d(-2059730720, oVar, sVar);
            w0.j jVar2 = w0.j.f15113c;
            a.a.d(z10, aVar2, jVar2, false, cVarD, cVarD2, sVar, 221568);
            mVar = jVar2;
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            e9.p pVar = new e9.p(2);
            pVar.f3705f = aVar;
            pVar.f3706g = mVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = pVar;
        }
    }

    public static final void b(g9.o1 o1Var, xb.p pVar, xb.a aVar, k0.s sVar, int i3) {
        k0.v1 v1VarS;
        k2 k2Var;
        sVar.Z(1781066739);
        int i10 = (sVar.h(o1Var) ? 4 : 2) | i3 | (sVar.h(pVar) ? 32 : 16) | (sVar.h(aVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar.P(i10 & 1, (i10 & 147) != 146)) {
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = k0.z.v(null);
                sVar.i0(objM);
            }
            k0.c1 c1Var = (k0.c1) objM;
            if (o1Var != null) {
                c1Var.setValue(o1Var);
            }
            g9.o1 o1Var2 = (g9.o1) c1Var.getValue();
            if (o1Var2 == null) {
                v1VarS = sVar.s();
                if (v1VarS != null) {
                    k2Var = new k2(0);
                    k2Var.f11728f = o1Var;
                    k2Var.f11729g = pVar;
                    k2Var.f11730h = aVar;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = k2Var;
                }
                return;
            }
            boolean z10 = o1Var != null;
            FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
            k2 k2Var2 = new k2(1);
            k2Var2.f11728f = o1Var2;
            k2Var2.f11729g = pVar;
            k2Var2.f11730h = aVar;
            VarHandle.storeStoreFence();
            n9.c.a(z10, aVar, fillElement, 0L, false, s0.h.d(746518465, k2Var2, sVar), sVar, ((i10 >> 3) & 112) | 196992, 24);
        } else {
            sVar.S();
        }
        v1VarS = sVar.s();
        if (v1VarS != null) {
            k2Var = new k2(2);
            k2Var.f11728f = o1Var;
            k2Var.f11729g = pVar;
            k2Var.f11730h = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = k2Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x036c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(g9.o1 r58, xb.l r59, xb.a r60, k0.s r61, int r62) {
        /*
            Method dump skipped, instructions count: 1285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.l2.c(g9.o1, xb.l, xb.a, k0.s, int):void");
    }

    public static final void d(g9.o1 o1Var, int i3, xb.a aVar, k0.s sVar, int i10) {
        k0.s sVar2 = sVar;
        sVar2.Z(-1888438866);
        int i11 = i10 | (sVar2.h(o1Var) ? 4 : 2) | (sVar2.d(i3) ? 32 : 16) | (sVar2.h(aVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar2.P(i11 & 1, (i11 & 147) != 146)) {
            w0.j jVar = w0.j.f15113c;
            float f5 = 14;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(l9.a.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), aVar), f5, 12);
            w.r0 r0VarA = w.p0.a(w.k.f14990a, w0.b.f15098o, sVar2, 48);
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
            h0.o0.a(t1.e.o(o1Var.f4569g, sVar2), null, androidx.compose.foundation.layout.c.f(jVar, 28), f11766c, sVar, 3504);
            t0.a.b(sVar, androidx.compose.foundation.layout.c.f(jVar, f5));
            w0.m mVarA = w.s0.a();
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar, 0);
            int iHashCode2 = Long.hashCode(sVar.T);
            s0.g gVarL2 = sVar.l();
            w0.m mVarM2 = t.o.m(sVar, mVarA);
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(vVarA, sVar, hVar);
            k0.z.B(gVarL2, sVar, hVar2);
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar, iHashCode2, hVar3);
            }
            k0.z.B(mVarM2, sVar, hVar4);
            String strE = e(o1Var, sVar);
            k0.s2 s2Var = h0.w1.f5235a;
            h0.t1.b(strE, null, f11767d, 0L, g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar.j(s2Var)).f5220j, sVar, 196992, 0, 65498);
            t0.a.b(sVar, androidx.compose.foundation.layout.c.c(jVar, 4));
            h0.t1.b(t2.a.o(i3, sVar), null, f11769f, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar.j(s2Var)).f5222l, sVar, 384, 0, 65530);
            sVar2 = sVar;
            sVar2.q(true);
            l9.a.a(androidx.compose.foundation.layout.c.f(jVar, 22), f11770g, null, sVar2, 438);
            sVar2.q(true);
        } else {
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            k0.a0 a0Var = new k0.a0(5);
            a0Var.f6862g = o1Var;
            a0Var.f6861f = i3;
            a0Var.f6863h = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = a0Var;
        }
    }

    public static final String e(g9.o1 o1Var, k0.s sVar) {
        sVar.X(-1481750461);
        int i3 = o1Var.f4566d;
        if (i3 != 0) {
            sVar.X(846104088);
            String strO = t2.a.o(i3, sVar);
            sVar.q(false);
            sVar.q(false);
            return strO;
        }
        sVar.X(836887199);
        sVar.q(false);
        String string = hc.h.w0(o1Var.f4565c).toString();
        if (string.length() > 0) {
            sVar.q(false);
            return string;
        }
        String str = o1Var.f4564b;
        sVar.q(false);
        return str;
    }
}

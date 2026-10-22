package e9;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import h0.t1;
import java.lang.invoke.VarHandle;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k0.c1;
import k0.v1;
import w.p0;
import w.r0;
import w.s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final s0.c f3616a = new s0.c(-1484166887, false, new a(0));

    public static final void a(xb.l lVar, k0.s sVar, int i) {
        sVar.Z(-1190448296);
        int i3 = i | (sVar.f(null) ? 4 : 2) | (sVar.h(lVar) ? 32 : 16);
        int i10 = 0;
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = context.getPackageManager();
                sVar.i0(objM);
            }
            throw null;
        }
        sVar.S();
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            m mVar = new m(i10);
            mVar.f3688f = lVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = mVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(java.lang.String r35, java.lang.String r36, xb.a r37, k0.s r38, int r39) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.b.b(java.lang.String, java.lang.String, xb.a, k0.s, int):void");
    }

    public static final void c(xb.a aVar, w0.m mVar, k0.s sVar, int i) {
        w0.m mVar2;
        boolean z10;
        aVar.getClass();
        sVar.Z(1937500436);
        int i3 = i | (sVar.h(aVar) ? 4 : 2) | 48;
        int i10 = 0;
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            if (objM == obj) {
                objM = h.f3655f.l(context);
                sVar.i0(objM);
            }
            h hVar = (h) objM;
            Object objM2 = sVar.M();
            if (objM2 == obj) {
                objM2 = k0.z.o(sVar);
                sVar.i0(objM2);
            }
            kc.t tVar = (kc.t) objM2;
            x.r rVarA = x.u.a(sVar);
            c1 c1VarR = h5.t.r(hVar.f3661e, new z(7), sVar);
            Object objM3 = sVar.M();
            if (objM3 == obj) {
                objM3 = k0.z.v(Boolean.FALSE);
                sVar.i0(objM3);
            }
            c1 c1Var = (c1) objM3;
            Object objM4 = sVar.M();
            nb.c cVar = null;
            if (objM4 == obj) {
                objM4 = k0.z.v(null);
                sVar.i0(objM4);
            }
            c1 c1Var2 = (c1) objM4;
            Object objM5 = sVar.M();
            Object obj2 = objM5;
            if (objM5 == obj) {
                i iVar = new i(0);
                iVar.f3663f = c1Var;
                iVar.f3664g = c1Var2;
                VarHandle.storeStoreFence();
                sVar.i0(iVar);
                obj2 = iVar;
            }
            xb.a aVar2 = (xb.a) obj2;
            if (((Boolean) c1Var.getValue()).booleanValue()) {
                z10 = true;
            } else {
                if (c1Var2.getValue() != null) {
                    od.f.j();
                    return;
                }
                z10 = false;
            }
            boolean zH = sVar.h(hVar);
            Object objM6 = sVar.M();
            if (zH || objM6 == obj) {
                objM6 = new t(hVar, cVar, i10);
                sVar.i0(objM6);
            }
            k0.z.h(jb.v.f6774a, sVar, (xb.p) objM6);
            boolean zH2 = sVar.h(hVar);
            Object objM7 = sVar.M();
            if (zH2 || objM7 == obj) {
                objM7 = new t(hVar, cVar, 1);
                sVar.i0(objM7);
            }
            k0.z.h(hVar, sVar, (xb.p) objM7);
            Object objM8 = sVar.M();
            if (objM8 == obj) {
                objM8 = Collator.getInstance(Locale.getDefault());
                sVar.i0(objM8);
            }
            Object obj3 = (Collator) objM8;
            boolean zF = sVar.f(((z) c1VarR.getValue()).f3742c) | sVar.f(obj3) | sVar.f(context);
            Object objM9 = sVar.M();
            if (zF || objM9 == obj) {
                List list = ((z) c1VarR.getValue()).f3742c;
                ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    throw androidx.activity.b.g(it);
                }
                obj3.getClass();
                a9.n nVar = new a9.n(3);
                VarHandle.storeStoreFence();
                objM9 = kb.l.I0(arrayList, nVar);
                sVar.i0(objM9);
            }
            String strO = t2.a.o(R.string.operate_phone_ai_terms_link, sVar);
            String strO2 = t2.a.o(R.string.operate_phone_ai_terms_title, sVar);
            n nVar2 = new n();
            nVar2.f3689c = aVar;
            nVar2.f3690f = c1VarR;
            nVar2.f3691g = rVarA;
            nVar2.f3692h = (List) objM9;
            nVar2.i = tVar;
            nVar2.f3693j = hVar;
            nVar2.f3694k = strO;
            nVar2.f3695l = context;
            nVar2.f3696m = strO2;
            nVar2.f3697n = c1Var;
            nVar2.f3698o = c1Var2;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(486462062, nVar2, sVar);
            o oVar = new o(i10);
            oVar.f3700f = tVar;
            oVar.i = hVar;
            oVar.f3701g = aVar2;
            oVar.f3702h = c1Var;
            oVar.f3703j = c1Var2;
            VarHandle.storeStoreFence();
            s0.c cVarD2 = s0.h.d(-1931236339, oVar, sVar);
            mVar2 = w0.j.f15113c;
            a.a.d(z10, aVar2, mVar2, false, cVarD, cVarD2, sVar, 221616);
        } else {
            sVar.S();
            mVar2 = mVar;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            p pVar = new p(0);
            pVar.f3705f = aVar;
            pVar.f3706g = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = pVar;
        }
    }

    public static final void d(String str, String str2, boolean z10, xb.l lVar, String str3, xb.a aVar, k0.s sVar, int i, int i3) {
        String str4;
        int i10;
        xb.a aVar2;
        int i11;
        String str5;
        boolean z11;
        xb.l lVar2;
        xb.a aVar3;
        String str6;
        k0.s sVar2 = sVar;
        sVar2.Z(1377010771);
        int i12 = i | (sVar2.f(str) ? 4 : 2) | (sVar2.f(str2) ? 32 : 16) | (sVar2.g(z10) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar2.h(lVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024);
        int i13 = i3 & 16;
        if (i13 != 0) {
            i10 = i12 | 24576;
            str4 = str3;
        } else {
            str4 = str3;
            i10 = i12 | (sVar2.f(str4) ? 16384 : 8192);
        }
        int i14 = i3 & 32;
        if (i14 != 0) {
            i11 = i10 | 196608;
            aVar2 = aVar;
        } else {
            aVar2 = aVar;
            i11 = i10 | (sVar2.h(aVar2) ? 131072 : 65536);
        }
        int i15 = i11;
        if (sVar2.P(i15 & 1, (i15 & 74899) != 74898)) {
            if (i13 != 0) {
                str4 = null;
            }
            if (i14 != 0) {
                aVar2 = null;
            }
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            r0 r0VarA = p0.a(w.k.f14990a, w0.b.f15098o, sVar2, 48);
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
            w0.m mVarA = s0.a();
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
            String str7 = str4;
            xb.a aVar4 = aVar2;
            t1.b(str, null, j9.b0.f6635c, com.stepos.statsrpk.h.t(17), g2.k.f4253h, 0L, null, 0L, 0, false, 0, 0, null, sVar, (i15 & 14) | 200064, 0, 131026);
            sVar2 = sVar;
            t0.a.b(sVar2, androidx.compose.foundation.layout.c.c(jVar, 6));
            if (str7 == null || aVar4 == null) {
                sVar2.X(-1825632453);
                aVar3 = aVar4;
                str6 = str7;
                t1.b(str2, null, j9.b0.f6636d, com.stepos.statsrpk.h.t(13), null, 0L, null, com.stepos.statsrpk.h.t(18), 0, false, 0, 0, null, sVar, ((i15 >> 3) & 14) | 3456, 6, 130034);
                str5 = str2;
                sVar2 = sVar;
                sVar2.q(false);
            } else {
                sVar2.X(-1825855622);
                int i16 = i15 >> 9;
                b(str2, str7, aVar4, sVar2, ((i15 >> 3) & 14) | (i16 & 112) | (i16 & 896));
                sVar2.q(false);
                str6 = str7;
                aVar3 = aVar4;
                str5 = str2;
            }
            sVar2.q(true);
            z11 = z10;
            lVar2 = lVar;
            l9.a.e(z11, lVar2, null, false, sVar2, (i15 >> 6) & 126);
            sVar2.q(true);
            str4 = str6;
            aVar2 = aVar3;
        } else {
            str5 = str2;
            z11 = z10;
            lVar2 = lVar;
            sVar2.S();
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            l lVar3 = new l();
            lVar3.f3681c = str;
            lVar3.f3682f = str5;
            lVar3.f3683g = z11;
            lVar3.f3684h = lVar2;
            lVar3.i = str4;
            lVar3.f3685j = aVar2;
            lVar3.f3686k = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = lVar3;
        }
    }
}

package j9;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.l0;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import h0.t1;
import i9.d0;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k0.c1;
import k0.v1;
import k0.y0;
import t.m0;
import w.p0;
import w.r0;
import w.s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final s0.c f6622a = new s0.c(-623493760, false, new e9.a(1));

    /* renamed from: b, reason: collision with root package name */
    public static final s0.c f6623b = new s0.c(-1779536374, false, new e9.a(2));

    /* renamed from: c, reason: collision with root package name */
    public static final s0.c f6624c = new s0.c(915737267, false, new e9.a(3));

    public static final void a(String str, xb.a aVar, k0.s sVar, int i) {
        int i3;
        Bitmap bitmapO;
        k0.s sVar2 = sVar;
        sVar2.Z(-479640902);
        int i10 = i | (sVar2.f(str) ? 4 : 2) | (sVar2.h(aVar) ? 32 : 16);
        if (sVar2.P(i10 & 1, (i10 & 19) != 18)) {
            Context context = (Context) sVar2.j(AndroidCompositionLocals_androidKt.f982b);
            int i11 = i10 & 14;
            boolean z10 = i11 == 4;
            Object objM = sVar2.M();
            y0 y0Var = k0.m.f6974a;
            if (z10 || objM == y0Var) {
                objM = td.h.F(context, str);
                sVar2.i0(objM);
            }
            jb.g gVar = (jb.g) objM;
            String str2 = (String) gVar.f6759c;
            Drawable drawable = (Drawable) gVar.f6760f;
            boolean zF = (i11 == 4) | sVar2.f(drawable);
            Object objM2 = sVar2.M();
            if (zF || objM2 == y0Var) {
                objM2 = (drawable == null || (bitmapO = td.h.O(drawable)) == null) ? null : new d1.e(bitmapO);
                sVar2.i0(objM2);
            }
            d1.e eVar = (d1.e) objM2;
            w0.j jVar = w0.j.f15113c;
            float f5 = 12;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), 16, f5);
            r0 r0VarA = p0.a(w.k.e(f5), w0.b.f15098o, sVar2, 54);
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
            k0.z.B(r0VarA, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            if (eVar != null) {
                sVar2.X(2098177123);
                m0.c(eVar, com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.f(jVar, 40), a0.e.f7a), sVar2, 48, 248);
                sVar2.q(false);
            } else {
                sVar2.X(2098408600);
                t0.a.b(sVar2, androidx.compose.foundation.layout.c.f(jVar, 40));
                sVar2.q(false);
            }
            t1.b(str2, s0.a(), b0.f6635c, com.stepos.statsrpk.h.t(17), null, 0L, null, 0L, 0, false, 0, 0, null, sVar, 3456, 0, 131056);
            i3 = 0;
            sVar2 = sVar;
            b0.f(true, true, aVar, null, sVar2, ((i10 << 3) & 896) | 54);
            sVar2.q(true);
        } else {
            i3 = 0;
            sVar2.S();
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            i iVar = new i(i3);
            iVar.f6671f = str;
            iVar.f6672g = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = iVar;
        }
    }

    public static final void b(i9.c cVar, boolean z10, boolean z11, xb.l lVar, k0.s sVar, int i) {
        int i3;
        k0.s sVar2;
        k0.s sVar3 = sVar;
        String str = cVar.f5844a;
        sVar3.Z(532903489);
        int i10 = i | (sVar3.f(cVar) ? 4 : 2) | (sVar3.g(z10) ? 32 : 16) | (sVar3.g(z11) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar3.P(i10 & 1, (i10 & 1171) != 1170)) {
            Context context = (Context) sVar3.j(AndroidCompositionLocals_androidKt.f982b);
            Object objM = sVar3.M();
            y0 y0Var = k0.m.f6974a;
            if (objM == y0Var) {
                objM = context.getPackageManager();
                sVar3.i0(objM);
            }
            PackageManager packageManager = (PackageManager) objM;
            boolean zF = sVar3.f(str);
            Object objM2 = sVar3.M();
            if (zF || objM2 == y0Var) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
                    applicationInfo.getClass();
                    Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
                    applicationIcon.getClass();
                    objM2 = new d1.e(td.h.O(applicationIcon));
                } catch (PackageManager.NameNotFoundException | Exception unused) {
                    objM2 = null;
                }
                sVar3.i0(objM2);
            }
            d1.e eVar = (d1.e) objM2;
            w0.j jVar = w0.j.f15113c;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), 16, 10);
            r0 r0VarA = p0.a(w.k.e(12), w0.b.f15098o, sVar3, 54);
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
            k0.z.B(r0VarA, sVar3, u1.i.f13836e);
            k0.z.B(gVarL, sVar3, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar3.S || !yb.k.a(sVar3.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar3, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar3, u1.i.f13834c);
            if (eVar != null) {
                sVar3.X(449289934);
                m0.c(eVar, com.stepos.statsrpk.h.g(androidx.compose.foundation.layout.c.f(jVar, 44), a0.e.a(6)), sVar3, 48, 248);
                sVar3.q(false);
            } else {
                sVar3.X(449527177);
                t0.a.b(sVar3, androidx.compose.foundation.layout.c.f(jVar, 44));
                sVar3.q(false);
            }
            t1.b(cVar.f5845b, s0.a(), b0.f6635c, com.stepos.statsrpk.h.t(17), null, 0L, null, 0L, 0, false, 0, 0, null, sVar3, 3456, 0, 131056);
            boolean z12 = (i10 & 14) == 4;
            Object objM3 = sVar3.M();
            Object obj = objM3;
            if (z12 || objM3 == y0Var) {
                e9.j jVar2 = new e9.j(2);
                jVar2.f3666f = lVar;
                jVar2.f3667g = cVar;
                VarHandle.storeStoreFence();
                sVar3.i0(jVar2);
                obj = jVar2;
            }
            k0.s sVar4 = sVar3;
            i3 = 0;
            b0.f(z10, z11, (xb.a) obj, null, sVar4, (i10 >> 3) & 126);
            sVar4.q(true);
            sVar2 = sVar4;
        } else {
            i3 = 0;
            sVar3.S();
            sVar2 = sVar3;
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            b bVar = new b(i3);
            bVar.f6632h = cVar;
            bVar.f6630f = z10;
            bVar.f6631g = z11;
            bVar.i = lVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = bVar;
        }
    }

    public static final void c(xb.a aVar, w0.m mVar, k0.s sVar, int i) {
        w0.m mVar2;
        List list;
        c1 c1Var;
        c1 c1Var2;
        aVar.getClass();
        sVar.Z(84017471);
        int i3 = i | 48;
        int i10 = 1;
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            if (objM == obj) {
                objM = i9.b0.f5839d.m(context);
                sVar.i0(objM);
            }
            i9.b0 b0Var = (i9.b0) objM;
            Object objM2 = sVar.M();
            if (objM2 == obj) {
                objM2 = k0.z.o(sVar);
                sVar.i0(objM2);
            }
            Object obj2 = (kc.t) objM2;
            x.r rVarA = x.u.a(sVar);
            nc.g gVar = b0Var.f5843c;
            long jCurrentTimeMillis = System.currentTimeMillis();
            i9.b bVar = i9.b.f5834g;
            kb.u uVar = kb.u.f7406c;
            c1 c1VarR = h5.t.r(gVar, new d0(false, bVar, null, uVar, jCurrentTimeMillis), sVar);
            Object objM3 = sVar.M();
            if (objM3 == obj) {
                objM3 = k0.z.v(kb.s.f7404c);
                sVar.i0(objM3);
            }
            c1 c1Var3 = (c1) objM3;
            Object objM4 = sVar.M();
            if (objM4 == obj) {
                objM4 = k0.z.v(uVar);
                sVar.i0(objM4);
            }
            c1 c1Var4 = (c1) objM4;
            Object objM5 = sVar.M();
            nb.c cVar = null;
            if (objM5 == obj) {
                objM5 = k0.z.v(null);
                sVar.i0(objM5);
            }
            c1 c1Var5 = (c1) objM5;
            Object objM6 = sVar.M();
            if (objM6 == obj) {
                objM6 = k0.z.v(Boolean.FALSE);
                sVar.i0(objM6);
            }
            c1 c1Var6 = (c1) objM6;
            boolean zH = sVar.h(context);
            Object objM7 = sVar.M();
            if (zH || objM7 == obj) {
                objM7 = new l0(context, c1Var3, cVar, 7);
                sVar.i0(objM7);
            }
            k0.z.h(jb.v.f6774a, sVar, (xb.p) objM7);
            boolean zF = sVar.f((List) c1Var3.getValue());
            Object objM8 = sVar.M();
            if (zF || objM8 == obj) {
                List list2 = (List) c1Var3.getValue();
                i9.e eVar = new i9.e(2, i9.a.f5826a, i9.a.class, "compareLabels", "compareLabels(Ljava/lang/String;Ljava/lang/String;)I", 0, 0, 1);
                a2.y yVar = new a2.y(2);
                yVar.f149f = eVar;
                VarHandle.storeStoreFence();
                a2.a0 a0Var = new a2.a0(2);
                a0Var.f32f = yVar;
                VarHandle.storeStoreFence();
                objM8 = kb.l.I0(list2, a0Var);
                sVar.i0(objM8);
            }
            List list3 = (List) objM8;
            boolean zF2 = sVar.f(list3);
            Object objM9 = sVar.M();
            if (zF2 || objM9 == obj) {
                lb.f fVar = new lb.f();
                int i11 = 0;
                for (Object obj3 : list3) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        ac.a.a0();
                        throw null;
                    }
                    String strI = p5.f.I(((i9.c) obj3).f5845b);
                    if (!fVar.containsKey(strI)) {
                        fVar.put(strI, Integer.valueOf(i11));
                    }
                    i11 = i12;
                }
                objM9 = fVar.b();
                sVar.i0(objM9);
            }
            Object obj4 = (Map) objM9;
            Integer numValueOf = Integer.valueOf(rVarA.g());
            Boolean bool = (Boolean) c1Var6.getValue();
            bool.booleanValue();
            boolean zH2 = sVar.h(list3) | sVar.f(rVarA);
            Object objM10 = sVar.M();
            if (zH2 || objM10 == obj) {
                objM10 = new g9.y(list3, rVarA, c1Var6, c1Var5, null, 1);
                list = list3;
                c1Var = c1Var6;
                c1Var2 = c1Var5;
                sVar.i0(objM10);
            } else {
                list = list3;
                c1Var = c1Var6;
                c1Var2 = c1Var5;
            }
            k0.z.f(numValueOf, list, bool, (xb.p) objM10, sVar);
            boolean zH3 = sVar.h(obj4) | sVar.h(obj2) | sVar.f(rVarA);
            Object objM11 = sVar.M();
            Object obj5 = objM11;
            if (zH3 || objM11 == obj) {
                e9.k kVar = new e9.k(i10);
                kVar.f3680h = obj4;
                kVar.f3678f = c1Var2;
                kVar.f3679g = obj2;
                kVar.i = rVarA;
                VarHandle.storeStoreFence();
                sVar.i0(kVar);
                obj5 = kVar;
            }
            boolean z10 = !((Set) c1Var4.getValue()).isEmpty();
            String strO = t2.a.o(R.string.screen_perception_add_apps_title, sVar);
            long j10 = b0.f6633a;
            c cVar2 = new c(0);
            cVar2.f6649f = z10;
            cVar2.f6650g = obj2;
            cVar2.f6651h = b0Var;
            cVar2.i = aVar;
            cVar2.f6652j = c1Var4;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(1474676441, cVar2, sVar);
            d dVar = new d();
            dVar.f6653c = rVarA;
            dVar.f6654f = list;
            dVar.f6655g = c1VarR;
            dVar.f6656h = (xb.l) obj5;
            dVar.i = c1Var4;
            dVar.f6657j = c1Var2;
            dVar.f6658k = c1Var;
            VarHandle.storeStoreFence();
            s0.c cVarD2 = s0.h.d(-67884812, dVar, sVar);
            mVar2 = w0.j.f15113c;
            l9.a.d(strO, aVar, mVar2, j10, false, cVarD, null, cVarD2, sVar, 12783024, 80);
        } else {
            sVar.S();
            mVar2 = mVar;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            e9.p pVar = new e9.p(1);
            pVar.f3705f = aVar;
            pVar.f3706g = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = pVar;
        }
    }

    public static final void d(xb.a aVar, xb.a aVar2, w0.m mVar, k0.s sVar, int i) {
        w0.m mVar2;
        aVar.getClass();
        aVar2.getClass();
        sVar.Z(-1855902469);
        int i3 = i | (sVar.h(aVar) ? 4 : 2) | (sVar.h(aVar2) ? 32 : 16) | 384;
        int i10 = 0;
        int i11 = 1;
        if (sVar.P(i3 & 1, (i3 & 147) != 146)) {
            Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            if (objM == obj) {
                objM = i9.b0.f5839d.m(context);
                sVar.i0(objM);
            }
            i9.b0 b0Var = (i9.b0) objM;
            Object objM2 = sVar.M();
            if (objM2 == obj) {
                objM2 = k0.z.o(sVar);
                sVar.i0(objM2);
            }
            kc.t tVar = (kc.t) objM2;
            c1 c1VarR = h5.t.r(b0Var.f5843c, new d0(false, i9.b.f5834g, null, kb.u.f7406c, System.currentTimeMillis()), sVar);
            boolean zH = sVar.h(b0Var);
            Object objM3 = sVar.M();
            if (zH || objM3 == obj) {
                objM3 = new q(b0Var, null, 0);
                sVar.i0(objM3);
            }
            k0.z.h(b0Var, sVar, (xb.p) objM3);
            Object objM4 = sVar.M();
            if (objM4 == obj) {
                objM4 = k0.z.v(null);
                sVar.i0(objM4);
            }
            c1 c1Var = (c1) objM4;
            boolean z10 = ((String) c1Var.getValue()) != null;
            Object objM5 = sVar.M();
            Object obj2 = objM5;
            if (objM5 == obj) {
                e9.s sVar2 = new e9.s(3);
                sVar2.f3721f = c1Var;
                VarHandle.storeStoreFence();
                sVar.i0(sVar2);
                obj2 = sVar2;
            }
            m mVar3 = new m(i10);
            mVar3.f6685f = aVar;
            mVar3.f6687h = c1VarR;
            mVar3.f6688j = tVar;
            mVar3.f6689k = b0Var;
            mVar3.f6686g = aVar2;
            mVar3.f6690l = context;
            mVar3.i = c1Var;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(1997319649, mVar3, sVar);
            n nVar = new n(i10);
            nVar.f6692f = tVar;
            nVar.f6693g = b0Var;
            nVar.f6694h = c1Var;
            VarHandle.storeStoreFence();
            s0.c cVarD2 = s0.h.d(301296290, nVar, sVar);
            mVar2 = w0.j.f15113c;
            a.a.d(z10, (xb.a) obj2, mVar2, false, cVarD, cVarD2, sVar, 221616);
        } else {
            sVar.S();
            mVar2 = mVar;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            n nVar2 = new n(i11);
            nVar2.f6692f = aVar;
            nVar2.f6693g = aVar2;
            nVar2.f6694h = mVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = nVar2;
        }
    }
}

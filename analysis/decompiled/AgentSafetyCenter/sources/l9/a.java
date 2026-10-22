package l9;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import h0.o0;
import j9.r;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.WeakHashMap;
import k0.c1;
import k0.s;
import k0.v1;
import k0.z;
import k8.q;
import s1.f0;
import s8.x1;
import t.o;
import v1.a1;
import v1.j1;
import w.p;
import w.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final s0.c f7762a = new s0.c(1145893236, false, new k8.d(5));

    public static final void a(w0.m mVar, long j10, String str, s sVar, int i) {
        int i3;
        w0.m mVar2;
        long j11;
        String str2;
        s sVar2;
        sVar.Z(1643498858);
        if ((i & 6) == 0) {
            i3 = (sVar.f(mVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.e(j10) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.f(str) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if (sVar.P(i3 & 1, (i3 & 147) != 146)) {
            int i10 = (i3 >> 3) & 112;
            int i11 = i3 << 6;
            mVar2 = mVar;
            j11 = j10;
            str2 = str;
            sVar2 = sVar;
            o0.a(t1.e.o(R.drawable.stepos_icon_arrow_right, sVar), str2, mVar2, j11, sVar2, i10 | (i11 & 896) | (i11 & 7168));
        } else {
            mVar2 = mVar;
            j11 = j10;
            str2 = str;
            sVar2 = sVar;
            sVar2.S();
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            b bVar = new b();
            bVar.f7763c = mVar2;
            bVar.f7764f = j11;
            bVar.f7765g = str2;
            bVar.f7766h = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = bVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(w0.m r15, float r16, float r17, k0.s r18, int r19, int r20) {
        /*
            r4 = r18
            r7 = r19
            r8 = r20
            r0 = -783116816(0xffffffffd15295f0, float:-5.6528667E10)
            r4.Z(r0)
            r0 = r7 | 6
            r1 = r8 & 2
            r2 = 16
            if (r1 == 0) goto L19
            r0 = r7 | 54
        L16:
            r3 = r16
            goto L2a
        L19:
            r3 = r7 & 48
            if (r3 != 0) goto L16
            r3 = r16
            boolean r5 = r4.c(r3)
            if (r5 == 0) goto L28
            r5 = 32
            goto L29
        L28:
            r5 = r2
        L29:
            r0 = r0 | r5
        L2a:
            r0 = r0 | 384(0x180, float:5.38E-43)
            r5 = r0 & 147(0x93, float:2.06E-43)
            r6 = 146(0x92, float:2.05E-43)
            r9 = 1
            if (r5 == r6) goto L35
            r5 = r9
            goto L36
        L35:
            r5 = 0
        L36:
            r0 = r0 & r9
            boolean r0 = r4.P(r0, r5)
            if (r0 == 0) goto L62
            if (r1 == 0) goto L42
            float r15 = (float) r2
            r10 = r15
            goto L43
        L42:
            r10 = r3
        L43:
            float r12 = (float) r2
            r13 = 0
            r14 = 10
            w0.j r9 = w0.j.f15113c
            r11 = 0
            w0.m r0 = androidx.compose.foundation.layout.b.j(r9, r10, r11, r12, r13, r14)
            r1 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            float r1 = (float) r1
            long r2 = d1.p.f3020c
            r15 = 1039726841(0x3df8f8f9, float:0.12156863)
            long r2 = d1.p.c(r15, r2)
            r5 = 432(0x1b0, float:6.05E-43)
            r6 = 0
            h0.b1.d(r0, r1, r2, r4, r5, r6)
            r15 = r9
            goto L68
        L62:
            r18.S()
            r12 = r17
            r10 = r3
        L68:
            k0.v1 r0 = r18.s()
            if (r0 == 0) goto L82
            l9.c r1 = new l9.c
            r1.<init>()
            r1.f7767c = r15
            r1.f7768f = r10
            r1.f7769g = r12
            r1.f7770h = r7
            r1.i = r8
            java.lang.invoke.VarHandle.storeStoreFence()
            r0.f7091d = r1
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.a.b(w0.m, float, float, k0.s, int, int):void");
    }

    public static final void c(List list, w0.m mVar, int i, s sVar, int i3) {
        s sVar2;
        list.getClass();
        sVar.Z(12358597);
        int i10 = i3 | (sVar.h(list) ? 4 : 2) | 432;
        int i11 = 0;
        if (sVar.P(i10 & 1, (i10 & 147) != 146)) {
            Context context = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
            boolean zF = sVar.f(context);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            if (zF || objM == obj) {
                objM = h(context);
                sVar.i0(objM);
            }
            Context context2 = (Context) objM;
            Object obj2 = (o2.c) sVar.j(a1.f14363h);
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            boolean zH = sVar.h(context2);
            Object objM2 = sVar.M();
            Object obj3 = objM2;
            if (zH || objM2 == obj) {
                d dVar = new d(i11);
                dVar.f7772f = context2;
                VarHandle.storeStoreFence();
                sVar.i0(dVar);
                obj3 = dVar;
            }
            xb.l lVar = (xb.l) obj3;
            boolean zH2 = sVar.h(list) | sVar.h(context2) | sVar.f(obj2);
            Object objM3 = sVar.M();
            Object obj4 = objM3;
            if (zH2 || objM3 == obj) {
                aa.j jVar2 = new aa.j(6);
                jVar2.f326f = list;
                jVar2.f327g = context2;
                jVar2.f328h = obj2;
                VarHandle.storeStoreFence();
                sVar.i0(jVar2);
                obj4 = jVar2;
            }
            sVar2 = sVar;
            androidx.compose.ui.viewinterop.a.b(lVar, mVarB, (xb.l) obj4, sVar2, 0, 0);
            mVar = jVar;
            i = 1;
        } else {
            sVar2 = sVar;
            sVar2.S();
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            e eVar = new e(0);
            eVar.f7774f = list;
            eVar.f7775g = mVar;
            eVar.f7776h = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = eVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(java.lang.String r18, xb.a r19, w0.m r20, long r21, boolean r23, xb.p r24, w.y0 r25, s0.c r26, k0.s r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.a.d(java.lang.String, xb.a, w0.m, long, boolean, xb.p, w.y0, s0.c, k0.s, int, int):void");
    }

    public static final void e(boolean z10, xb.l lVar, w0.m mVar, boolean z11, s sVar, int i) {
        int i3;
        int i10;
        w0.m mVar2;
        boolean z12;
        lVar.getClass();
        sVar.Z(-1219830255);
        if ((i & 6) == 0) {
            i3 = (sVar.g(z10) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.h(lVar) ? 32 : 16;
        }
        int i11 = i3 | 3456;
        if (sVar.P(i11 & 1, (i11 & 1171) != 1170)) {
            int i12 = i11 & 14;
            c1 c1VarZ = z.z(Boolean.valueOf(z10), sVar);
            c1 c1VarZ2 = z.z(lVar, sVar);
            mVar2 = w0.j.f15113c;
            w0.m mVarJ = androidx.compose.foundation.layout.c.j(mVar2);
            f0 f0VarE = p.e(w0.b.f15089c, false);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = o.m(sVar, mVarJ);
            u1.j.f13840e.getClass();
            xb.a aVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(aVar);
            } else {
                sVar.l0();
            }
            z.B(f0VarE, sVar, u1.i.f13836e);
            z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            z.B(mVarM, sVar, u1.i.f13834c);
            int i13 = i11 & 7168;
            boolean z13 = (i12 == 4) | (i13 == 2048);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            Object obj2 = objM;
            if (z13 || objM == obj) {
                g gVar = new g(0);
                gVar.f7783f = z10;
                VarHandle.storeStoreFence();
                sVar.i0(gVar);
                obj2 = gVar;
            }
            xb.l lVar2 = (xb.l) obj2;
            boolean z14 = (i13 == 2048) | (i12 == 4);
            Object objM2 = sVar.M();
            Object obj3 = objM2;
            if (z14 || objM2 == obj) {
                g gVar2 = new g(1);
                gVar2.f7783f = z10;
                VarHandle.storeStoreFence();
                sVar.i0(gVar2);
                obj3 = gVar2;
            }
            androidx.compose.ui.viewinterop.a.b(lVar2, null, (xb.l) obj3, sVar, 0, 2);
            w0.m mVarB = androidx.compose.foundation.layout.a.f901a.b();
            Object objM3 = sVar.M();
            if (objM3 == obj) {
                objM3 = t0.a.a();
                sVar.i0(objM3);
            }
            v.k kVar = (v.k) objM3;
            a2.g gVar3 = new a2.g();
            gVar3.f45a = 2;
            VarHandle.storeStoreFence();
            boolean zF = sVar.f(c1VarZ2) | sVar.f(c1VarZ);
            Object objM4 = sVar.M();
            Object obj4 = objM4;
            if (zF || objM4 == obj) {
                e9.i iVar = new e9.i(5);
                iVar.f3663f = c1VarZ2;
                iVar.f3664g = c1VarZ;
                VarHandle.storeStoreFence();
                sVar.i0(iVar);
                obj4 = iVar;
            }
            p.a(androidx.compose.foundation.a.d(mVarB, kVar, null, true, gVar3, (xb.a) obj4, 8), sVar, 0);
            i10 = 1;
            sVar.q(true);
            z12 = true;
        } else {
            i10 = 1;
            sVar.S();
            mVar2 = mVar;
            z12 = z11;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            r rVar = new r(i10);
            rVar.f6710f = z10;
            rVar.f6713j = lVar;
            rVar.f6711g = mVar2;
            rVar.f6712h = z12;
            rVar.i = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = rVar;
        }
    }

    public static final void f(String str, xb.a aVar, w0.m mVar, boolean z10, xb.l lVar, s sVar, int i) {
        v1 v1VarS;
        k kVar;
        str.getClass();
        aVar.getClass();
        sVar.Z(-817096186);
        int i3 = i | (sVar.f(str) ? 4 : 2) | (sVar.h(aVar) ? 32 : 16) | (sVar.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.g(z10) ? 2048 : 1024);
        int i10 = 0;
        if (sVar.P(i3 & 1, (i3 & 9363) != 9362)) {
            boolean zBooleanValue = ((Boolean) sVar.j(j1.f14483a)).booleanValue();
            WeakHashMap weakHashMap = z0.f15068u;
            int i11 = w.c.e(sVar).f15074f.e().f3901b;
            Object objZ = z.z(aVar, sVar);
            Object objO = t2.a.o(R.string.cd_back, sVar);
            if (zBooleanValue) {
                sVar.X(1762631462);
                p.a(androidx.compose.foundation.a.b(androidx.compose.foundation.layout.c.b(mVar, 1.0f), d1.p.c(0.88f, x1.f12069a), d1.f0.f2972a), sVar, 0);
                sVar.q(false);
                v1VarS = sVar.s();
                if (v1VarS != null) {
                    kVar = new k(i10);
                    kVar.f7802f = str;
                    kVar.f7803g = aVar;
                    kVar.f7804h = mVar;
                    kVar.i = z10;
                    kVar.f7805j = lVar;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = kVar;
                }
                return;
            }
            sVar.X(1760113084);
            sVar.q(false);
            w0.m mVarB = androidx.compose.foundation.layout.c.b(mVar, 1.0f);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            Object obj2 = objM;
            if (objM == obj) {
                l lVar2 = new l(0);
                lVar2.f7807f = lVar;
                VarHandle.storeStoreFence();
                sVar.i0(lVar2);
                obj2 = lVar2;
            }
            w0.m mVarC = androidx.compose.ui.layout.a.c(mVarB, (xb.l) obj2);
            boolean zF = sVar.f(objO) | sVar.f(objZ);
            Object objM2 = sVar.M();
            Object obj3 = objM2;
            if (zF || objM2 == obj) {
                aa.g gVar = new aa.g(7);
                gVar.f319f = objO;
                gVar.f320g = objZ;
                VarHandle.storeStoreFence();
                sVar.i0(gVar);
                obj3 = gVar;
            }
            xb.l lVar3 = (xb.l) obj3;
            boolean zD = ((i3 & 14) == 4) | sVar.d(i11) | ((i3 & 7168) == 2048);
            Object objM3 = sVar.M();
            Object obj4 = objM3;
            if (zD || objM3 == obj) {
                m mVar2 = new m();
                mVar2.f7808c = str;
                mVar2.f7809f = i11;
                mVar2.f7810g = z10;
                VarHandle.storeStoreFence();
                sVar.i0(mVar2);
                obj4 = mVar2;
            }
            androidx.compose.ui.viewinterop.a.b(lVar3, mVarC, (xb.l) obj4, sVar, 0, 0);
        } else {
            sVar.S();
        }
        v1VarS = sVar.s();
        if (v1VarS != null) {
            kVar = new k(1);
            kVar.f7802f = str;
            kVar.f7803g = aVar;
            kVar.f7804h = mVar;
            kVar.i = z10;
            kVar.f7805j = lVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = kVar;
        }
    }

    public static w0.m g(w0.m mVar, xb.a aVar) {
        mVar.getClass();
        aVar.getClass();
        q qVar = new q(2);
        qVar.f7337f = d1.f0.f2972a;
        qVar.f7338g = aVar;
        VarHandle.storeStoreFence();
        w0.h hVar = new w0.h();
        hVar.f15111f = qVar;
        VarHandle.storeStoreFence();
        return mVar.d(hVar);
    }

    public static final Context h(Context context) {
        context.getClass();
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.uiMode = (configuration.uiMode & (-49)) | 32;
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        contextCreateConfigurationContext.getClass();
        return contextCreateConfigurationContext;
    }
}

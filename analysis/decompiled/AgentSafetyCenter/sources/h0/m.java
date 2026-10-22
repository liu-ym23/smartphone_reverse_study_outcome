package h0;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final float f5059a = 280;

    /* renamed from: b, reason: collision with root package name */
    public static final float f5060b = 560;

    /* renamed from: c, reason: collision with root package name */
    public static final float f5061c = 8;

    /* renamed from: d, reason: collision with root package name */
    public static final float f5062d = 12;

    /* renamed from: e, reason: collision with root package name */
    public static final w.l0 f5063e;

    /* renamed from: f, reason: collision with root package name */
    public static final w.l0 f5064f;

    /* renamed from: g, reason: collision with root package name */
    public static final w.l0 f5065g;

    static {
        float f5 = 24;
        f5063e = new w.l0(f5, f5, f5, f5);
        float f10 = 16;
        androidx.compose.foundation.layout.b.b(f10);
        f5064f = androidx.compose.foundation.layout.b.b(f10);
        f5065g = androidx.compose.foundation.layout.b.b(f5);
    }

    public static final void a(s0.c cVar, w0.m mVar, xb.p pVar, xb.p pVar2, d1.j0 j0Var, long j10, float f5, long j11, long j12, long j13, long j14, k0.s sVar, int i) {
        w0.m mVar2;
        sVar.Z(1522575799);
        int i3 = i | 48 | (sVar.h(null) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.h(pVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(pVar2) ? 16384 : 8192) | (sVar.f(j0Var) ? 131072 : 65536) | (sVar.e(j10) ? 1048576 : 524288) | (sVar.c(f5) ? 8388608 : 4194304) | (sVar.e(j11) ? 67108864 : 33554432) | (sVar.e(j12) ? 536870912 : 268435456);
        int i10 = (sVar.e(j13) ? (char) 4 : (char) 2) | (sVar.e(j14) ? ' ' : (char) 16);
        if ((i3 & 306783379) == 306783378 && (i10 & 19) == 18 && sVar.B()) {
            sVar.S();
            mVar2 = mVar;
        } else {
            s0.c cVarD = s0.h.d(-2126308228, new c(pVar, pVar2, j12, j13, j14, j11, cVar), sVar);
            int i11 = i3 >> 12;
            int i12 = (i11 & 896) | (i11 & 112) | 12582918 | ((i3 >> 9) & 57344);
            w0.j jVar = w0.j.f15113c;
            q1.a(jVar, j0Var, j10, 0L, f5, 0.0f, cVarD, sVar, i12, 104);
            mVar2 = jVar;
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new d(cVar, mVar2, pVar, pVar2, j0Var, j10, f5, j11, j12, j13, j14, i);
        }
    }

    public static final void b(s0.c cVar, k0.s sVar, int i) {
        sVar.Z(586821353);
        if ((i & 147) == 146 && sVar.B()) {
            sVar.S();
        } else {
            Object objM = sVar.M();
            if (objM == k0.m.f6974a) {
                objM = new f();
                VarHandle.storeStoreFence();
                sVar.i0(objM);
            }
            s1.f0 f0Var = (s1.f0) objM;
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, w0.j.f15113c);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
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
            cVar.invoke(sVar, 6);
            sVar.q(true);
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new g(cVar, i, 0);
        }
    }

    public static final void c(xb.a aVar, s0.c cVar, w0.m mVar, xb.p pVar, xb.p pVar2, xb.p pVar3, d1.j0 j0Var, long j10, long j11, long j12, long j13, float f5, s2.k kVar, k0.s sVar, int i, int i3) {
        int i10;
        s0.c cVar2;
        xb.p pVar4;
        int i11;
        sVar.Z(-919826268);
        if ((i & 6) == 0) {
            i10 = (sVar.h(aVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            cVar2 = cVar;
            i10 |= sVar.h(cVar2) ? 32 : 16;
        } else {
            cVar2 = cVar;
        }
        if ((i & 384) == 0) {
            i10 |= sVar.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            pVar4 = pVar;
            i10 |= sVar.h(pVar4) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        } else {
            pVar4 = pVar;
        }
        if ((i & 24576) == 0) {
            i10 |= sVar.h(null) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i10 |= sVar.h(pVar2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i10 |= sVar.h(pVar3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i10 |= sVar.f(j0Var) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i10 |= sVar.e(j10) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i10 |= sVar.e(j11) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i11 = i3 | (sVar.e(j12) ? 4 : 2);
        } else {
            i11 = i3;
        }
        if ((i3 & 48) == 0) {
            i11 |= sVar.e(j13) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i11 |= sVar.c(f5) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i3 & 3072) == 0) {
            i11 |= sVar.f(kVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        int i12 = i11;
        if ((i10 & 306783379) == 306783378 && (i12 & 1171) == 1170 && sVar.B()) {
            sVar.S();
        } else {
            d(aVar, mVar, kVar, s0.h.d(-1852840226, new i(pVar2, pVar3, j0Var, j10, f5, j11, j12, j13, pVar4, cVar2), sVar), sVar, (i10 & 14) | 3072 | ((i10 >> 3) & 112) | ((i12 >> 3) & 896));
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new j(aVar, cVar, mVar, pVar, pVar2, pVar3, j0Var, j10, j11, j12, j13, f5, kVar, i, i3);
        }
    }

    public static final void d(xb.a aVar, w0.m mVar, s2.k kVar, s0.c cVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-1922902937);
        if ((i & 6) == 0) {
            i3 = (sVar.h(aVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.f(mVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.f(kVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar.h(cVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i3 & 1171) == 1170 && sVar.B()) {
            sVar.S();
        } else {
            id.c.b(aVar, kVar, s0.h.d(905289008, new k(0, mVar, cVar), sVar), sVar, ((i3 >> 3) & 112) | (i3 & 14) | 384);
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new l(aVar, mVar, kVar, cVar, i);
        }
    }
}

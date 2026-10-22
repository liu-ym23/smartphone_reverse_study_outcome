package i1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.view.ViewParent;
import fi.iki.elonen.NanoHTTPD;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d1 extends m0 implements g1.o, g1.k, l1 {
    public static final u0.a0 O;
    public static final t P;
    public static final b1 Q;
    public static final b1 R;
    public d2.l A;
    public l0 C;
    public k.y D;
    public float F;
    public t0.a G;
    public t H;
    public x0.b I;
    public u0.l J;
    public h9.b K;
    public boolean M;
    public j1 N;

    /* renamed from: t, reason: collision with root package name */
    public final f0 f4437t;

    /* renamed from: u, reason: collision with root package name */
    public d1 f4438u;

    /* renamed from: v, reason: collision with root package name */
    public d1 f4439v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4440w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4441x;

    /* renamed from: y, reason: collision with root package name */
    public p7.k f4442y;

    /* renamed from: z, reason: collision with root package name */
    public d2.c f4443z;
    public float B = 0.8f;
    public long E = 0;
    public final c1 L = new c1(this, 1);

    static {
        u0.a0 a0Var = new u0.a0();
        a0Var.f9873g = 1.0f;
        a0Var.f9874h = 1.0f;
        a0Var.f9875i = 1.0f;
        long j2 = u0.q.f9922a;
        a0Var.f9877k = j2;
        a0Var.f9878l = j2;
        a0Var.f9879m = 8.0f;
        a0Var.f9880n = u0.f0.f9906a;
        a0Var.f9881o = u0.z.f9929a;
        a0Var.f9883q = 9205357640488583168L;
        a0Var.f9884r = new d2.d(1.0f, 1.0f);
        a0Var.f9885s = d2.l.f2793f;
        a0Var.f9886t = 3;
        O = a0Var;
        P = new t();
        Q = new b1(0);
        R = new b1(1);
    }

    public d1(f0 f0Var) {
        this.f4437t = f0Var;
        this.f4443z = f0Var.A;
        this.A = f0Var.B;
    }

    public final n0.l A0(int i2) {
        boolean zG = e1.g(i2);
        n0.l lVarZ0 = z0();
        if (!zG && (lVarZ0 = lVarZ0.f6801j) == null) {
            return null;
        }
        for (n0.l lVarB0 = B0(zG); lVarB0 != null && (lVarB0.f6800i & i2) != 0; lVarB0 = lVarB0.f6802k) {
            if ((lVarB0.f6799h & i2) != 0) {
                return lVarB0;
            }
            if (lVarB0 == lVarZ0) {
                return null;
            }
        }
        return null;
    }

    @Override // g1.k
    public final t0.c B(g1.k kVar, boolean z4) {
        d1 d1Var;
        if (!z0().f6810s) {
            f1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!kVar.v()) {
            f1.a.b("LayoutCoordinates " + kVar + " is not attached!");
        }
        g1.n nVar = kVar instanceof g1.n ? (g1.n) kVar : null;
        if (nVar == null || (d1Var = nVar.f3753f.f4544t) == null) {
            d1Var = (d1) kVar;
        }
        d1Var.K0();
        d1 d1VarV0 = v0(d1Var);
        t0.a aVar = this.G;
        if (aVar == null) {
            aVar = new t0.a();
            this.G = aVar;
        }
        aVar.f9650a = 0.0f;
        aVar.f9651b = 0.0f;
        aVar.f9652c = (int) (kVar.x() >> 32);
        aVar.f9653d = (int) (kVar.x() & 4294967295L);
        while (d1Var != d1VarV0) {
            d1Var.R0(aVar, z4, false);
            if (aVar.b()) {
                return t0.c.f9655e;
            }
            d1Var = d1Var.f4439v;
            q7.k.b(d1Var);
        }
        o0(d1VarV0, aVar, z4);
        return new t0.c(aVar.f9650a, aVar.f9651b, aVar.f9652c, aVar.f9653d);
    }

    public final n0.l B0(boolean z4) {
        n0.l lVarZ0;
        a1 a1Var = this.f4437t.H;
        if (((d1) a1Var.f4402h) == this) {
            return (n0.l) a1Var.f4404j;
        }
        if (!z4) {
            d1 d1Var = this.f4439v;
            if (d1Var != null) {
                return d1Var.z0();
            }
            return null;
        }
        d1 d1Var2 = this.f4439v;
        if (d1Var2 == null || (lVarZ0 = d1Var2.z0()) == null) {
            return null;
        }
        return lVarZ0.f6802k;
    }

    public final void C0(n0.l lVar, b1 b1Var, long j2, p pVar, int i2, boolean z4) {
        if (lVar == null) {
            F0(b1Var, j2, pVar, i2, z4);
            return;
        }
        int i10 = pVar.f4561h;
        k.z zVar = pVar.f4559f;
        pVar.f(i10 + 1, zVar.f5557b);
        pVar.f4561h++;
        zVar.a(lVar);
        pVar.f4560g.a(l.a(-1.0f, z4, false));
        C0(l.d(lVar, b1Var.b()), b1Var, j2, pVar, i2, z4);
        pVar.f4561h = i10;
    }

    public final void D0(n0.l lVar, b1 b1Var, long j2, p pVar, int i2, boolean z4, float f10) throws Throwable {
        if (lVar == null) {
            F0(b1Var, j2, pVar, i2, z4);
            return;
        }
        int i10 = pVar.f4561h;
        k.z zVar = pVar.f4559f;
        pVar.f(i10 + 1, zVar.f5557b);
        pVar.f4561h++;
        zVar.a(lVar);
        pVar.f4560g.a(l.a(f10, z4, false));
        O0(l.d(lVar, b1Var.b()), b1Var, j2, pVar, i2, z4, f10, true);
        pVar.f4561h = i10;
    }

    public final void E0(b1 b1Var, long j2, p pVar, int i2, boolean z4) {
        boolean z10;
        boolean z11;
        n0.l lVarA0 = A0(b1Var.b());
        if (!Y0(j2)) {
            if (i2 == 1) {
                float fR0 = r0(j2, y0());
                if ((Float.floatToRawIntBits(fR0) & Integer.MAX_VALUE) < 2139095040) {
                    if (pVar.f4561h != d7.s.t0(pVar)) {
                        if (l.g(pVar.a(), l.a(fR0, false, false)) <= 0) {
                            return;
                        }
                    }
                    D0(lVarA0, b1Var, j2, pVar, i2, false, fR0);
                    return;
                }
                return;
            }
            return;
        }
        if (lVarA0 == null) {
            F0(b1Var, j2, pVar, i2, z4);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        if (fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < G() && fIntBitsToFloat2 < E()) {
            C0(lVarA0, b1Var, j2, pVar, i2, z4);
            return;
        }
        float fR02 = i2 == 1 ? r0(j2, y0()) : Float.POSITIVE_INFINITY;
        if ((Float.floatToRawIntBits(fR02) & Integer.MAX_VALUE) < 2139095040) {
            if (pVar.f4561h != d7.s.t0(pVar)) {
                z10 = z4;
                if (l.g(pVar.a(), l.a(fR02, z10, false)) > 0) {
                }
                O0(lVarA0, b1Var, j2, pVar, i2, z10, fR02, z11);
            }
            z10 = z4;
            z11 = true;
            O0(lVarA0, b1Var, j2, pVar, i2, z10, fR02, z11);
        }
        z10 = z4;
        z11 = false;
        O0(lVarA0, b1Var, j2, pVar, i2, z10, fR02, z11);
    }

    public void F0(b1 b1Var, long j2, p pVar, int i2, boolean z4) {
        d1 d1Var = this.f4438u;
        if (d1Var != null) {
            d1Var.E0(b1Var, d1Var.w0(j2), pVar, i2, z4);
        }
    }

    public final void G0() {
        j1 j1Var = this.N;
        if (j1Var != null) {
            j1Var.invalidate();
            return;
        }
        d1 d1Var = this.f4439v;
        if (d1Var != null) {
            d1Var.G0();
        }
    }

    public final boolean H0() {
        if (this.N != null && this.B <= 0.0f) {
            return true;
        }
        d1 d1Var = this.f4439v;
        if (d1Var != null) {
            return d1Var.H0();
        }
        return false;
    }

    public final long I0(g1.k kVar, long j2) {
        d1 d1Var;
        boolean z4 = kVar instanceof g1.n;
        if (z4) {
            g1.n nVar = (g1.n) kVar;
            nVar.f3753f.f4544t.K0();
            return nVar.c(this, j2 ^ (-9223372034707292160L)) ^ (-9223372034707292160L);
        }
        g1.n nVar2 = z4 ? (g1.n) kVar : null;
        if (nVar2 == null || (d1Var = nVar2.f3753f.f4544t) == null) {
            q7.k.c(kVar, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
            d1Var = (d1) kVar;
        }
        d1Var.K0();
        d1 d1VarV0 = v0(d1Var);
        while (d1Var != d1VarV0) {
            j2 = d1Var.U0(j2);
            d1Var = d1Var.f4439v;
            q7.k.b(d1Var);
        }
        return p0(d1VarV0, j2);
    }

    public final long J0(long j2) {
        if (!z0().f6810s) {
            f1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        K0();
        while (this != null) {
            j2 = this.U0(j2);
            this = this.f4439v;
        }
        return j2;
    }

    public final void K0() {
        this.f4437t.I.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r7v7, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void L0() {
        n0.l lVarZ0;
        boolean zG = e1.g(128);
        n0.l lVarB0 = B0(zG);
        if (lVarB0 == null || (lVarB0.f6797f.f6800i & 128) == 0) {
            return;
        }
        l0.f fVar = (l0.f) l0.m.f5773b.z();
        p7.k kVarE = fVar != null ? fVar.e() : null;
        l0.f fVarF = l0.r.f(fVar);
        try {
            if (!zG) {
                lVarZ0 = z0().f6801j;
                if (lVarZ0 == null) {
                }
            }
            lVarZ0 = z0();
            for (n0.l lVarB02 = B0(zG); lVarB02 != null; lVarB02 = lVarB02.f6802k) {
                if ((lVarB02.f6800i & 128) == 0) {
                    break;
                }
                if ((lVarB02.f6799h & 128) != 0) {
                    k kVarE2 = lVarB02;
                    ?? eVar = 0;
                    while (kVarE2 != 0) {
                        if (kVarE2 instanceof u) {
                            ((u) kVarE2).m(this.f3758h);
                        } else if ((kVarE2.f6799h & 128) != 0 && (kVarE2 instanceof k)) {
                            n0.l lVar = kVarE2.f4514u;
                            int i2 = 0;
                            kVarE2 = kVarE2;
                            eVar = eVar;
                            while (lVar != null) {
                                if ((lVar.f6799h & 128) != 0) {
                                    i2++;
                                    eVar = eVar;
                                    if (i2 == 1) {
                                        kVarE2 = lVar;
                                    } else {
                                        if (eVar == 0) {
                                            eVar = new d0.e(new n0.l[16]);
                                        }
                                        if (kVarE2 != 0) {
                                            eVar.b(kVarE2);
                                            kVarE2 = 0;
                                        }
                                        eVar.b(lVar);
                                    }
                                }
                                lVar = lVar.f6802k;
                                kVarE2 = kVarE2;
                                eVar = eVar;
                            }
                            if (i2 == 1) {
                            }
                        }
                        kVarE2 = l.e(eVar);
                    }
                }
                if (lVarB02 == lVarZ0) {
                    break;
                }
            }
        } finally {
            l0.r.i(fVar, fVarF, kVarE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void M0() {
        boolean zG = e1.g(128);
        n0.l lVarZ0 = z0();
        if (!zG && (lVarZ0 = lVarZ0.f6801j) == null) {
            return;
        }
        for (n0.l lVarB0 = B0(zG); lVarB0 != null && (lVarB0.f6800i & 128) != 0; lVarB0 = lVarB0.f6802k) {
            if ((lVarB0.f6799h & 128) != 0) {
                k kVarE = lVarB0;
                ?? eVar = 0;
                while (kVarE != 0) {
                    if (kVarE instanceof u) {
                        ((u) kVarE).l(this);
                    } else if ((kVarE.f6799h & 128) != 0 && (kVarE instanceof k)) {
                        n0.l lVar = kVarE.f4514u;
                        int i2 = 0;
                        kVarE = kVarE;
                        eVar = eVar;
                        while (lVar != null) {
                            if ((lVar.f6799h & 128) != 0) {
                                i2++;
                                eVar = eVar;
                                if (i2 == 1) {
                                    kVarE = lVar;
                                } else {
                                    if (eVar == 0) {
                                        eVar = new d0.e(new n0.l[16]);
                                    }
                                    if (kVarE != 0) {
                                        eVar.b(kVarE);
                                        kVarE = 0;
                                    }
                                    eVar.b(lVar);
                                }
                            }
                            lVar = lVar.f6802k;
                            kVarE = kVarE;
                            eVar = eVar;
                        }
                        if (i2 == 1) {
                        }
                    }
                    kVarE = l.e(eVar);
                }
            }
            if (lVarB0 == lVarZ0) {
                return;
            }
        }
    }

    public final void N0() {
        this.f4440w = true;
        this.L.c();
        S0();
        if (d2.i.a(this.E, 0L)) {
            return;
        }
        this.f4437t.F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ce A[PHI: r8
      0x01ce: PHI (r8v6 d0.e) = (r8v1 d0.e), (r8v1 d0.e), (r8v8 d0.e) binds: [B:56:0x0193, B:58:0x0197, B:72:0x01c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O0(n0.l r22, i1.b1 r23, long r24, i1.p r26, int r27, boolean r28, float r29, boolean r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.d1.O0(n0.l, i1.b1, long, i1.p, int, boolean, float, boolean):void");
    }

    public abstract void P0(u0.l lVar, x0.b bVar);

    public final void Q0(long j2, float f10, p7.k kVar) {
        W0(kVar, false);
        boolean zA = d2.i.a(this.E, j2);
        f0 f0Var = this.f4437t;
        if (!zA) {
            ((j1.y) l.w(f0Var)).F(-4.0f);
            this.E = j2;
            f0Var.I.f4507o.T();
            j1 j1Var = this.N;
            if (j1Var != null) {
                ((j1.n1) j1Var).d(j2);
            } else {
                d1 d1Var = this.f4439v;
                if (d1Var != null) {
                    d1Var.G0();
                }
            }
            f0Var.F();
            m0.i0(this);
            k1 k1Var = f0Var.f4464r;
            if (k1Var != null) {
                ((j1.y) k1Var).t(f0Var);
            }
        }
        this.F = f10;
        if (!this.f4532p) {
            V(e0());
        }
        if (this == ((d1) f0Var.H.f4402h)) {
            ((j1.y) l.w(f0Var)).getRectManager().g(f0Var, !f0Var.I.f4507o.f4612p);
        }
    }

    public final void R0(t0.a aVar, boolean z4, boolean z10) {
        j1 j1Var = this.N;
        if (j1Var != null) {
            if (this.f4441x) {
                if (z10) {
                    long jY0 = y0();
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jY0 >> 32)) / 2.0f;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jY0 & 4294967295L)) / 2.0f;
                    long j2 = this.f3758h;
                    aVar.a(-fIntBitsToFloat, -fIntBitsToFloat2, ((int) (j2 >> 32)) + fIntBitsToFloat, ((int) (j2 & 4294967295L)) + fIntBitsToFloat2);
                } else if (z4) {
                    long j4 = this.f3758h;
                    aVar.a(0.0f, 0.0f, (int) (j4 >> 32), (int) (j4 & 4294967295L));
                }
                if (aVar.b()) {
                    return;
                }
            }
            j1.n1 n1Var = (j1.n1) j1Var;
            float[] fArrB = n1Var.b();
            if (!n1Var.f5280x) {
                if (fArrB == null) {
                    aVar.f9650a = 0.0f;
                    aVar.f9651b = 0.0f;
                    aVar.f9652c = 0.0f;
                    aVar.f9653d = 0.0f;
                } else {
                    u0.z.k(fArrB, aVar);
                }
            }
        }
        long j10 = this.E;
        float f10 = (int) (j10 >> 32);
        aVar.f9650a += f10;
        aVar.f9652c += f10;
        float f11 = (int) (j10 & 4294967295L);
        aVar.f9651b += f11;
        aVar.f9653d += f11;
    }

    public final void S0() {
        if (this.N != null) {
            W0(null, false);
            this.f4437t.L(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [d0.e] */
    public final void T0(l0 l0Var) {
        d1 d1Var;
        l0 l0Var2 = this.C;
        if (l0Var != l0Var2) {
            this.C = l0Var;
            f0 f0Var = this.f4437t;
            int i2 = 0;
            if (l0Var2 == null || l0Var.d() != l0Var2.d() || l0Var.b() != l0Var2.b()) {
                int iD = l0Var.d();
                int iB = l0Var.b();
                j1 j1Var = this.N;
                if (j1Var != null) {
                    ((j1.n1) j1Var).e((iD << 32) | (iB & 4294967295L));
                } else if (f0Var.C() && (d1Var = this.f4439v) != null) {
                    d1Var.G0();
                }
                N((iB & 4294967295L) | (iD << 32));
                if (this.f4442y != null) {
                    X0(false);
                }
                boolean zG = e1.g(4);
                n0.l lVarZ0 = z0();
                if (zG || (lVarZ0 = lVarZ0.f6801j) != null) {
                    for (n0.l lVarB0 = B0(zG); lVarB0 != null && (lVarB0.f6800i & 4) != 0; lVarB0 = lVarB0.f6802k) {
                        if ((lVarB0.f6799h & 4) != 0) {
                            k kVarE = lVarB0;
                            ?? eVar = 0;
                            while (kVarE != 0) {
                                if (kVarE instanceof m) {
                                    ((m) kVarE).T();
                                } else if ((kVarE.f6799h & 4) != 0 && (kVarE instanceof k)) {
                                    n0.l lVar = kVarE.f4514u;
                                    int i10 = 0;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                    while (lVar != null) {
                                        if ((lVar.f6799h & 4) != 0) {
                                            i10++;
                                            eVar = eVar;
                                            if (i10 == 1) {
                                                kVarE = lVar;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new d0.e(new n0.l[16]);
                                                }
                                                if (kVarE != 0) {
                                                    eVar.b(kVarE);
                                                    kVarE = 0;
                                                }
                                                eVar.b(lVar);
                                            }
                                        }
                                        lVar = lVar.f6802k;
                                        kVarE = kVarE;
                                        eVar = eVar;
                                    }
                                    if (i10 == 1) {
                                    }
                                }
                                kVarE = l.e(eVar);
                            }
                        }
                        if (lVarB0 == lVarZ0) {
                            break;
                        }
                    }
                }
                k1 k1Var = f0Var.f4464r;
                if (k1Var != null) {
                    ((j1.y) k1Var).t(f0Var);
                }
            }
            k.y yVar = this.D;
            if ((yVar == null || yVar.f5554e == 0) && l0Var.a().isEmpty()) {
                return;
            }
            k.y yVar2 = this.D;
            Map mapA = l0Var.a();
            if (yVar2 != null && yVar2.f5554e == mapA.size()) {
                Object[] objArr = yVar2.f5551b;
                int[] iArr = yVar2.f5552c;
                long[] jArr = yVar2.f5550a;
                int length = jArr.length - 2;
                if (length < 0) {
                    return;
                }
                int i11 = 0;
                loop0: while (true) {
                    long j2 = jArr[i11];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = i2; i13 < i12; i13++) {
                            if ((255 & j2) < 128) {
                                int i14 = (i11 << 3) + i13;
                                Object obj = objArr[i14];
                                int i15 = iArr[i14];
                                Integer num = (Integer) mapA.get((g1.f) obj);
                                if (num == null || num.intValue() != i15) {
                                    break loop0;
                                }
                            }
                            j2 >>= 8;
                        }
                        if (i12 != 8) {
                            return;
                        }
                    }
                    if (i11 == length) {
                        return;
                    }
                    i11++;
                    i2 = 0;
                }
            }
            f0Var.I.f4507o.A.f();
            k.y yVar3 = this.D;
            if (yVar3 == null) {
                k.y yVar4 = k.e0.f5483a;
                yVar3 = new k.y();
                this.D = yVar3;
            }
            yVar3.a();
            for (Map.Entry entry : l0Var.a().entrySet()) {
                yVar3.h(((Number) entry.getValue()).intValue(), entry.getKey());
            }
        }
    }

    public final long U0(long j2) {
        j1 j1Var = this.N;
        if (j1Var != null) {
            j2 = ((j1.n1) j1Var).c(j2, false);
        }
        long j4 = this.E;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) + ((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) + ((int) (j4 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public final t0.c V0() {
        if (z0().f6810s) {
            g1.k kVarW = ib.k.w(this);
            t0.a aVar = this.G;
            if (aVar == null) {
                aVar = new t0.a();
                this.G = aVar;
            }
            long jQ0 = q0(y0());
            int i2 = (int) (jQ0 >> 32);
            aVar.f9650a = -Float.intBitsToFloat(i2);
            int i10 = (int) (jQ0 & 4294967295L);
            aVar.f9651b = -Float.intBitsToFloat(i10);
            aVar.f9652c = Float.intBitsToFloat(i2) + G();
            aVar.f9653d = Float.intBitsToFloat(i10) + E();
            while (this != kVarW) {
                this.R0(aVar, false, true);
                if (!aVar.b()) {
                    this = this.f4439v;
                    q7.k.b(this);
                }
            }
            return new t0.c(aVar.f9650a, aVar.f9651b, aVar.f9652c, aVar.f9653d);
        }
        return t0.c.f9655e;
    }

    public final void W0(p7.k kVar, boolean z4) {
        k1 k1Var;
        d0.e eVar;
        Reference referencePoll;
        h9.b bVar;
        d0.e eVar2;
        Reference referencePoll2;
        Object obj;
        f0 f0Var = this.f4437t;
        boolean z10 = (!z4 && this.f4442y == kVar && q7.k.a(this.f4443z, f0Var.A) && this.A == f0Var.B) ? false : true;
        this.f4443z = f0Var.A;
        this.A = f0Var.B;
        boolean zB = f0Var.B();
        c1 c1Var = this.L;
        if (!zB || kVar == null) {
            this.f4442y = null;
            j1 j1Var = this.N;
            if (j1Var != null) {
                j1.n1 n1Var = (j1.n1) j1Var;
                j1.y yVar = n1Var.f5264h;
                if (!u0.z.h(n1Var.b())) {
                    f0Var.F();
                }
                n1Var.f5265i = null;
                n1Var.f5266j = null;
                n1Var.f5268l = true;
                if (n1Var.f5271o) {
                    n1Var.f5271o = false;
                    yVar.r(n1Var, false);
                }
                u0.p pVar = n1Var.f5263g;
                if (pVar != null) {
                    pVar.a(n1Var.f5262f);
                    q6.b bVar2 = yVar.f5389w0;
                    do {
                        ReferenceQueue referenceQueue = (ReferenceQueue) bVar2.f8787g;
                        eVar = (d0.e) bVar2.f8788h;
                        referencePoll = referenceQueue.poll();
                        if (referencePoll != null) {
                            eVar.i(referencePoll);
                        }
                    } while (referencePoll != null);
                    eVar.b(new WeakReference(n1Var, (ReferenceQueue) bVar2.f8787g));
                    yVar.C.remove(n1Var);
                }
                f0Var.K = true;
                c1Var.c();
                if (z0().f6810s && f0Var.C() && (k1Var = f0Var.f4464r) != null) {
                    ((j1.y) k1Var).t(f0Var);
                }
            }
            this.N = null;
            this.M = false;
            return;
        }
        this.f4442y = kVar;
        if (this.N != null) {
            if (z10 && X0(true)) {
                f0Var.F();
                ((j1.y) l.w(f0Var)).getRectManager().f(f0Var);
                return;
            }
            return;
        }
        k1 k1VarW = l.w(f0Var);
        h9.b bVar3 = this.K;
        if (bVar3 == null) {
            h9.b bVar4 = new h9.b(1, this, new c1(this, 0));
            this.K = bVar4;
            bVar = bVar4;
        } else {
            bVar = bVar3;
        }
        j1.y yVar2 = (j1.y) k1VarW;
        q6.b bVar5 = yVar2.f5389w0;
        do {
            ReferenceQueue referenceQueue2 = (ReferenceQueue) bVar5.f8787g;
            eVar2 = (d0.e) bVar5.f8788h;
            referencePoll2 = referenceQueue2.poll();
            if (referencePoll2 != null) {
                eVar2.i(referencePoll2);
            }
        } while (referencePoll2 != null);
        while (true) {
            int i2 = eVar2.f2751h;
            if (i2 == 0) {
                obj = null;
                break;
            } else {
                obj = ((Reference) eVar2.j(i2 - 1)).get();
                if (obj != null) {
                    break;
                }
            }
        }
        j1 n1Var2 = (j1) obj;
        if (n1Var2 != null) {
            j1.n1 n1Var3 = (j1.n1) n1Var2;
            u0.p pVar2 = n1Var3.f5263g;
            if (pVar2 == null) {
                throw m.x.i("currently reuse is only supported when we manage the layer lifecycle");
            }
            if (!n1Var3.f5262f.f11081s) {
                f1.a.a("layer should have been released before reuse");
            }
            n1Var3.f5262f = pVar2.b();
            n1Var3.f5268l = false;
            n1Var3.f5265i = bVar;
            n1Var3.f5266j = c1Var;
            n1Var3.f5278v = false;
            n1Var3.f5279w = false;
            n1Var3.f5280x = true;
            u0.z.l(n1Var3.f5269m);
            float[] fArr = n1Var3.f5270n;
            if (fArr != null) {
                u0.z.l(fArr);
            }
            n1Var3.f5276t = u0.f0.f9906a;
            n1Var3.f5281y = false;
            long j2 = Integer.MAX_VALUE;
            n1Var3.f5267k = (j2 & 4294967295L) | (j2 << 32);
            n1Var3.f5277u = null;
            n1Var3.f5275s = 0;
        } else {
            n1Var2 = new j1.n1(yVar2.getGraphicsContext().b(), yVar2.getGraphicsContext(), yVar2, bVar, c1Var);
        }
        j1.n1 n1Var4 = (j1.n1) n1Var2;
        n1Var4.e(this.f3758h);
        n1Var4.d(this.E);
        this.N = n1Var2;
        X0(true);
        f0Var.K = true;
        c1Var.c();
    }

    public final boolean X0(boolean z4) {
        boolean z10;
        k1 k1Var;
        p7.a aVar;
        p7.a aVar2;
        j1 j1Var = this.N;
        if (j1Var == null) {
            if (this.f4442y == null) {
                return false;
            }
            f1.a.b("null layer with a non-null layerBlock");
            return false;
        }
        p7.k kVar = this.f4442y;
        if (kVar == null) {
            throw m.x.i("updateLayerParameters requires a non-null layerBlock");
        }
        u0.a0 a0Var = O;
        a0Var.b(1.0f);
        a0Var.e(1.0f);
        a0Var.a(1.0f);
        if (a0Var.f9876j != 0.0f) {
            a0Var.f9872f |= 32;
            a0Var.f9876j = 0.0f;
        }
        long j2 = u0.q.f9922a;
        if (!u0.m.c(a0Var.f9877k, j2)) {
            a0Var.f9872f |= 64;
            a0Var.f9877k = j2;
        }
        if (!u0.m.c(a0Var.f9878l, j2)) {
            a0Var.f9872f |= 128;
            a0Var.f9878l = j2;
        }
        if (a0Var.f9879m != 8.0f) {
            a0Var.f9872f |= 2048;
            a0Var.f9879m = 8.0f;
        }
        long j4 = u0.f0.f9906a;
        a0Var.f(j4);
        u0.c0 c0Var = a0Var.f9881o;
        u0.y yVar = u0.z.f9929a;
        if (!q7.k.a(c0Var, yVar)) {
            a0Var.f9872f |= NanoHTTPD.HTTPSession.BUFSIZE;
            a0Var.f9881o = yVar;
        }
        if (a0Var.f9882p) {
            a0Var.f9872f |= 16384;
            a0Var.f9882p = false;
        }
        if (a0Var.f9886t != 3) {
            a0Var.f9872f |= 524288;
            a0Var.f9886t = 3;
        }
        a0Var.f9883q = 9205357640488583168L;
        a0Var.f9887u = null;
        a0Var.f9872f = 0;
        f0 f0Var = this.f4437t;
        a0Var.f9884r = f0Var.A;
        a0Var.f9885s = f0Var.B;
        a0Var.f9883q = ib.k.W(this.f3758h);
        ((j1.y) l.w(f0Var)).getSnapshotObserver().a(this, d.f4423k, new a8.c(11, kVar));
        t tVar = this.H;
        if (tVar == null) {
            tVar = new t();
            this.H = tVar;
        }
        t tVar2 = P;
        tVar2.getClass();
        tVar2.f4591a = tVar.f4591a;
        tVar2.f4592b = tVar.f4592b;
        tVar2.f4593c = tVar.f4593c;
        tVar2.f4594d = tVar.f4594d;
        float f10 = a0Var.f9873g;
        tVar.f4591a = f10;
        tVar.f4592b = a0Var.f9874h;
        tVar.f4593c = a0Var.f9879m;
        long j10 = a0Var.f9880n;
        tVar.f4594d = j10;
        j1.n1 n1Var = (j1.n1) j1Var;
        j1.y yVar2 = n1Var.f5264h;
        int i2 = n1Var.f5275s | a0Var.f9872f;
        n1Var.f5273q = a0Var.f9885s;
        n1Var.f5272p = a0Var.f9884r;
        int i10 = i2 & 4096;
        if (i10 != 0) {
            n1Var.f5276t = j10;
        }
        if ((i2 & 1) != 0) {
            x0.c cVar = n1Var.f5262f.f11063a;
            if (cVar.f11096j != f10) {
                cVar.f11096j = f10;
                cVar.f11089c.setScaleX(f10);
            }
        }
        if ((i2 & 2) != 0) {
            x0.b bVar = n1Var.f5262f;
            float f11 = a0Var.f9874h;
            x0.c cVar2 = bVar.f11063a;
            if (cVar2.f11097k != f11) {
                cVar2.f11097k = f11;
                cVar2.f11089c.setScaleY(f11);
            }
        }
        if ((i2 & 4) != 0) {
            x0.b bVar2 = n1Var.f5262f;
            float f12 = a0Var.f9875i;
            x0.c cVar3 = bVar2.f11063a;
            if (cVar3.f11094h != f12) {
                cVar3.f11094h = f12;
                cVar3.f11089c.setAlpha(f12);
            }
        }
        if ((i2 & 8) != 0) {
            x0.c cVar4 = n1Var.f5262f.f11063a;
        }
        if ((i2 & 16) != 0) {
            x0.c cVar5 = n1Var.f5262f.f11063a;
        }
        if ((i2 & 32) != 0) {
            x0.b bVar3 = n1Var.f5262f;
            float f13 = a0Var.f9876j;
            x0.c cVar6 = bVar3.f11063a;
            if (cVar6.f11098l != f13) {
                cVar6.f11098l = f13;
                cVar6.f11089c.setElevation(f13);
                bVar3.f11069g = true;
                bVar3.a();
            }
            if (a0Var.f9876j > 0.0f && !n1Var.f5281y && (aVar2 = n1Var.f5266j) != null) {
                aVar2.c();
            }
        }
        if ((i2 & 64) != 0) {
            x0.b bVar4 = n1Var.f5262f;
            long j11 = a0Var.f9877k;
            x0.c cVar7 = bVar4.f11063a;
            if (!u0.m.c(j11, cVar7.f11099m)) {
                cVar7.f11099m = j11;
                cVar7.f11089c.setAmbientShadowColor(u0.z.o(j11));
            }
        }
        if ((i2 & 128) != 0) {
            x0.b bVar5 = n1Var.f5262f;
            long j12 = a0Var.f9878l;
            x0.c cVar8 = bVar5.f11063a;
            if (!u0.m.c(j12, cVar8.f11100n)) {
                cVar8.f11100n = j12;
                cVar8.f11089c.setSpotShadowColor(u0.z.o(j12));
            }
        }
        if ((i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
            x0.c cVar9 = n1Var.f5262f.f11063a;
        }
        if ((i2 & 256) != 0) {
            x0.c cVar10 = n1Var.f5262f.f11063a;
        }
        if ((i2 & 512) != 0) {
            x0.c cVar11 = n1Var.f5262f.f11063a;
        }
        if ((i2 & 2048) != 0) {
            x0.b bVar6 = n1Var.f5262f;
            float f14 = a0Var.f9879m;
            x0.c cVar12 = bVar6.f11063a;
            if (cVar12.f11101o != f14) {
                cVar12.f11101o = f14;
                cVar12.f11089c.setCameraDistance(f14);
            }
        }
        if (i10 != 0) {
            if (n1Var.f5276t == j4) {
                x0.b bVar7 = n1Var.f5262f;
                if (!t0.b.b(bVar7.f11084v, 9205357640488583168L)) {
                    bVar7.f11084v = 9205357640488583168L;
                    bVar7.f11063a.f11089c.resetPivot();
                }
            } else {
                x0.b bVar8 = n1Var.f5262f;
                long jFloatToRawIntBits = (Float.floatToRawIntBits(u0.f0.b(n1Var.f5276t) * ((int) (n1Var.f5267k & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(u0.f0.a(r14) * ((int) (n1Var.f5267k >> 32))) << 32);
                if (!t0.b.b(bVar8.f11084v, jFloatToRawIntBits)) {
                    bVar8.f11084v = jFloatToRawIntBits;
                    RenderNode renderNode = bVar8.f11063a.f11089c;
                    if ((9223372034707292159L & jFloatToRawIntBits) == 9205357640488583168L) {
                        renderNode.resetPivot();
                    } else {
                        renderNode.setPivotX(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)));
                        renderNode.setPivotY(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)));
                    }
                }
            }
        }
        if ((i2 & 16384) != 0) {
            x0.b bVar9 = n1Var.f5262f;
            boolean z11 = a0Var.f9882p;
            if (bVar9.f11085w != z11) {
                bVar9.f11085w = z11;
                bVar9.f11069g = true;
                bVar9.a();
            }
        }
        if ((131072 & i2) != 0) {
            x0.c cVar13 = n1Var.f5262f.f11063a;
        }
        if ((262144 & i2) != 0) {
            x0.c cVar14 = n1Var.f5262f.f11063a;
        }
        if ((i2 & 524288) != 0) {
            x0.b bVar10 = n1Var.f5262f;
            int i11 = a0Var.f9886t;
            x0.c cVar15 = bVar10.f11063a;
            if (cVar15.f11095i != i11) {
                cVar15.f11095i = i11;
                Paint paint = cVar15.f11091e;
                if (paint == null) {
                    paint = new Paint();
                    cVar15.f11091e = paint;
                }
                paint.setBlendMode(u0.z.m(i11));
                cVar15.d();
            }
        }
        if ((32768 & i2) != 0) {
            x0.c cVar16 = n1Var.f5262f.f11063a;
            if (cVar16.f11105s != 0) {
                cVar16.f11105s = 0;
                cVar16.d();
            }
        }
        if ((i2 & 7963) != 0) {
            n1Var.f5278v = true;
            n1Var.f5279w = true;
        }
        if (q7.k.a(n1Var.f5277u, a0Var.f9887u)) {
            z10 = false;
        } else {
            u0.w wVar = a0Var.f9887u;
            n1Var.f5277u = wVar;
            if (wVar != null) {
                x0.b bVar11 = n1Var.f5262f;
                if (wVar instanceof u0.u) {
                    t0.c cVar17 = ((u0.u) wVar).f9925a;
                    float f15 = cVar17.f9656a;
                    float f16 = cVar17.f9657b;
                    bVar11.f((Float.floatToRawIntBits(f15) << 32) | (Float.floatToRawIntBits(f16) & 4294967295L), (Float.floatToRawIntBits(cVar17.f9658c - f15) << 32) | (Float.floatToRawIntBits(cVar17.f9659d - f16) & 4294967295L), 0.0f);
                } else if (wVar instanceof u0.t) {
                    u0.f fVar = ((u0.t) wVar).f9924a;
                    bVar11.f11073k = null;
                    bVar11.f11071i = 9205357640488583168L;
                    bVar11.f11070h = 0L;
                    bVar11.f11072j = 0.0f;
                    bVar11.f11069g = true;
                    bVar11.f11076n = false;
                    bVar11.f11074l = fVar;
                    bVar11.a();
                } else {
                    if (!(wVar instanceof u0.v)) {
                        throw new a4.u();
                    }
                    u0.v vVar = (u0.v) wVar;
                    u0.f fVar2 = vVar.f9927b;
                    if (fVar2 != null) {
                        bVar11.f11073k = null;
                        bVar11.f11071i = 9205357640488583168L;
                        bVar11.f11070h = 0L;
                        bVar11.f11072j = 0.0f;
                        bVar11.f11069g = true;
                        bVar11.f11076n = false;
                        bVar11.f11074l = fVar2;
                        bVar11.a();
                    } else {
                        bVar11.f((Float.floatToRawIntBits(r8.f9661b) & 4294967295L) | (Float.floatToRawIntBits(r8.f9660a) << 32), (Float.floatToRawIntBits(r8.b()) << 32) | (Float.floatToRawIntBits(r8.a()) & 4294967295L), Float.intBitsToFloat((int) (vVar.f9926a.f9667h >> 32)));
                    }
                }
                if ((wVar instanceof u0.t) && Build.VERSION.SDK_INT < 33 && (aVar = n1Var.f5266j) != null) {
                    aVar.c();
                }
            }
            z10 = true;
        }
        n1Var.f5275s = a0Var.f9872f;
        if (i2 != 0 || z10) {
            ViewParent parent = yVar2.getParent();
            if (parent != null) {
                parent.onDescendantInvalidated(yVar2, yVar2);
            }
            if (yVar2.f5364k) {
                yVar2.F(0.0f);
            }
        }
        boolean z12 = this.f4441x;
        boolean z13 = a0Var.f9882p;
        this.f4441x = z13;
        this.B = a0Var.f9875i;
        boolean z14 = tVar2.f4591a == tVar.f4591a && tVar2.f4592b == tVar.f4592b && tVar2.f4593c == tVar.f4593c && tVar2.f4594d == tVar.f4594d;
        boolean z15 = !z14;
        if (z4 && ((!z14 || z12 != z13) && (k1Var = f0Var.f4464r) != null)) {
            ((j1.y) k1Var).t(f0Var);
        }
        return z15;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Y0(long r24) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.d1.Y0(long):boolean");
    }

    @Override // i1.m0
    public final m0 Z() {
        return this.f4438u;
    }

    @Override // g1.k
    public final long a(long j2) {
        if (!z0().f6810s) {
            f1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return ((j1.y) l.w(this.f4437t)).p(J0(j2));
    }

    @Override // i1.m0
    public final g1.k a0() {
        return this;
    }

    @Override // i1.m0
    public final boolean b0() {
        return this.C != null;
    }

    @Override // d2.c
    public final float c() {
        return this.f4437t.A.c();
    }

    @Override // i1.m0
    public final d2.l c0() {
        return this.f4437t.B;
    }

    @Override // i1.m0
    public final f0 d0() {
        return this.f4437t;
    }

    @Override // g1.k
    public final long e(g1.k kVar, long j2) {
        return I0(kVar, j2);
    }

    @Override // i1.m0
    public final l0 e0() {
        l0 l0Var = this.C;
        if (l0Var != null) {
            return l0Var;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier");
    }

    @Override // g1.k
    public final long f(long j2) {
        long jJ0 = J0(j2);
        j1.y yVar = (j1.y) l.w(this.f4437t);
        yVar.x();
        return u0.z.j(yVar.U, jJ0);
    }

    @Override // i1.m0
    public final m0 f0() {
        return this.f4439v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // g1.s, g1.o
    public final Object g() {
        f0 f0Var = this.f4437t;
        if (!f0Var.H.h(64)) {
            return null;
        }
        z0();
        Object objS = null;
        for (n0.l lVar = (u1) f0Var.H.f4403i; lVar != null; lVar = lVar.f6801j) {
            if ((lVar.f6799h & 64) != 0) {
                k kVarE = lVar;
                ?? eVar = 0;
                while (kVarE != 0) {
                    if (kVarE instanceof n1) {
                        objS = ((n1) kVarE).S(objS);
                    } else if ((kVarE.f6799h & 64) != 0 && (kVarE instanceof k)) {
                        n0.l lVar2 = kVarE.f4514u;
                        int i2 = 0;
                        kVarE = kVarE;
                        eVar = eVar;
                        while (lVar2 != null) {
                            if ((lVar2.f6799h & 64) != 0) {
                                i2++;
                                eVar = eVar;
                                if (i2 == 1) {
                                    kVarE = lVar2;
                                } else {
                                    if (eVar == 0) {
                                        eVar = new d0.e(new n0.l[16]);
                                    }
                                    if (kVarE != 0) {
                                        eVar.b(kVarE);
                                        kVarE = 0;
                                    }
                                    eVar.b(lVar2);
                                }
                            }
                            lVar2 = lVar2.f6802k;
                            kVarE = kVarE;
                            eVar = eVar;
                        }
                        if (i2 == 1) {
                        }
                    }
                    kVarE = l.e(eVar);
                }
            }
        }
        return objS;
    }

    @Override // i1.m0
    public final long g0() {
        return this.E;
    }

    @Override // g1.k
    public final g1.k h() {
        if (!z0().f6810s) {
            f1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        K0();
        return ((d1) this.f4437t.H.f4402h).f4439v;
    }

    @Override // d2.c
    public final float j() {
        return this.f4437t.A.j();
    }

    @Override // i1.m0
    public final void n0() {
        M(this.E, this.F, this.f4442y);
    }

    public final void o0(d1 d1Var, t0.a aVar, boolean z4) {
        if (d1Var == this) {
            return;
        }
        d1 d1Var2 = this.f4439v;
        if (d1Var2 != null) {
            d1Var2.o0(d1Var, aVar, z4);
        }
        long j2 = this.E;
        float f10 = (int) (j2 >> 32);
        aVar.f9650a -= f10;
        aVar.f9652c -= f10;
        float f11 = (int) (j2 & 4294967295L);
        aVar.f9651b -= f11;
        aVar.f9653d -= f11;
        j1 j1Var = this.N;
        if (j1Var != null) {
            j1.n1 n1Var = (j1.n1) j1Var;
            float[] fArrA = n1Var.a();
            if (!n1Var.f5280x) {
                if (fArrA == null) {
                    aVar.f9650a = 0.0f;
                    aVar.f9651b = 0.0f;
                    aVar.f9652c = 0.0f;
                    aVar.f9653d = 0.0f;
                } else {
                    u0.z.k(fArrA, aVar);
                }
            }
            if (this.f4441x && z4) {
                long j4 = this.f3758h;
                aVar.a(0.0f, 0.0f, (int) (j4 >> 32), (int) (j4 & 4294967295L));
            }
        }
    }

    @Override // i1.l1
    public final boolean p() {
        return (this.N == null || this.f4440w || !this.f4437t.B()) ? false : true;
    }

    public final long p0(d1 d1Var, long j2) {
        if (d1Var == this) {
            return j2;
        }
        d1 d1Var2 = this.f4439v;
        return (d1Var2 == null || q7.k.a(d1Var, d1Var2)) ? w0(j2) : w0(d1Var2.p0(d1Var, j2));
    }

    public final long q0(long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - G();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) - E();
        float fMax = Math.max(0.0f, fIntBitsToFloat / 2.0f);
        float fMax2 = Math.max(0.0f, fIntBitsToFloat2 / 2.0f);
        return (Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax2) & 4294967295L);
    }

    public final float r0(long j2, long j4) {
        if (G() >= Float.intBitsToFloat((int) (j4 >> 32)) && E() >= Float.intBitsToFloat((int) (j4 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jQ0 = q0(j4);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jQ0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jQ0 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j2 >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat3 < 0.0f ? -fIntBitsToFloat3 : fIntBitsToFloat3 - G());
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (j2 & 4294967295L)) < 0.0f ? -r9 : r9 - E())) & 4294967295L);
        if (fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) {
            int i2 = (int) (jFloatToRawIntBits >> 32);
            if (Float.intBitsToFloat(i2) <= fIntBitsToFloat) {
                int i10 = (int) (jFloatToRawIntBits & 4294967295L);
                if (Float.intBitsToFloat(i10) <= fIntBitsToFloat2) {
                    float fIntBitsToFloat4 = Float.intBitsToFloat(i2);
                    float fIntBitsToFloat5 = Float.intBitsToFloat(i10);
                    return (fIntBitsToFloat5 * fIntBitsToFloat5) + (fIntBitsToFloat4 * fIntBitsToFloat4);
                }
            }
        }
        return Float.POSITIVE_INFINITY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [i1.d1] */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4, types: [float] */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    public final void s0(u0.l lVar, x0.b bVar) {
        long j2;
        char c10;
        Canvas canvas;
        RenderNode renderNode;
        Canvas canvas2;
        boolean z4;
        boolean z10;
        float f10;
        float f11;
        j1 j1Var = this.N;
        if (j1Var == null) {
            long j4 = this.E;
            float f12 = (int) (j4 >> 32);
            float f13 = (int) (j4 & 4294967295L);
            lVar.f(f12, f13);
            t0(lVar, bVar);
            lVar.f(-f12, -f13);
            return;
        }
        j1.n1 n1Var = (j1.n1) j1Var;
        w0.b bVar2 = n1Var.f5274r;
        n1Var.f();
        n1Var.f5281y = n1Var.f5262f.f11063a.f11098l > 0.0f;
        u5.h hVar = bVar2.f10630g;
        u5.h hVar2 = bVar2.f10630g;
        hVar.g(lVar);
        hVar.f10130b = bVar;
        x0.b bVar3 = n1Var.f5262f;
        u0.l lVarA = hVar2.a();
        x0.b bVar4 = (x0.b) hVar2.f10130b;
        x0.c cVar = bVar3.f11063a;
        if (bVar3.f11081s) {
            return;
        }
        bVar3.a();
        RenderNode renderNode2 = cVar.f11089c;
        if (renderNode2.hasDisplayList()) {
            this = 0;
            j2 = 4294967295L;
            c10 = ' ';
        } else {
            try {
                x0.c cVar2 = bVar3.f11063a;
                d2.c cVar3 = bVar3.f11064b;
                d2.l lVar2 = bVar3.f11065c;
                r8.c cVar4 = bVar3.f11067e;
                w0.b bVar5 = cVar2.f11088b;
                j2 = 4294967295L;
                try {
                    RenderNode renderNode3 = cVar2.f11089c;
                    RecordingCanvas recordingCanvasBeginRecording = renderNode3.beginRecording();
                    c10 = ' ';
                    try {
                        try {
                            o4.d0 d0Var = cVar2.f11087a;
                            this = 0;
                            try {
                                u0.a aVar = (u0.a) d0Var.f7326g;
                                Canvas canvas3 = aVar.f9869a;
                                aVar.f9869a = recordingCanvasBeginRecording;
                                u5.h hVar3 = bVar5.f10630g;
                                hVar3.h(cVar3);
                                hVar3.i(lVar2);
                                hVar3.f10130b = bVar3;
                                hVar3.j(cVar2.f11090d);
                                hVar3.g(aVar);
                                cVar4.invoke(bVar5);
                                ((u0.a) d0Var.f7326g).f9869a = canvas3;
                                renderNode3.endRecording();
                            } catch (Throwable th) {
                                th = th;
                                renderNode3.endRecording();
                                throw th;
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable unused2) {
                    this = 0;
                }
            } catch (Throwable unused3) {
            }
        }
        boolean z11 = cVar.f11098l > this;
        if (z11) {
            lVarA.m();
        }
        Canvas canvasA = u0.b.a(lVarA);
        boolean zIsHardwareAccelerated = canvasA.isHardwareAccelerated();
        if (zIsHardwareAccelerated) {
            canvas = canvasA;
        } else {
            long j10 = bVar3.f11082t;
            float f14 = (int) (j10 >> c10);
            float f15 = (int) (j10 & j2);
            long j11 = bVar3.f11083u;
            float f16 = f14 + ((int) (j11 >> c10));
            float f17 = f15 + ((int) (j11 & j2));
            float f18 = cVar.f11094h;
            int i2 = cVar.f11095i;
            if (f18 < 1.0f || i2 != 3 || cVar.f11105s == 1) {
                h4.s sVarE = bVar3.f11078p;
                if (sVarE == null) {
                    sVarE = u0.z.e();
                    bVar3.f11078p = sVarE;
                }
                sVarE.c(f18);
                sVarE.d(i2);
                sVarE.f(null);
                canvasA.saveLayer(f14, f15, f16, f17, (Paint) sVarE.f4155g);
                f10 = f14;
                f11 = f15;
            } else {
                canvasA.save();
                f11 = f15;
                f10 = f14;
            }
            canvas = canvasA;
            canvas.translate(f10, f11);
            Matrix matrix = cVar.f11092f;
            if (matrix == null) {
                matrix = new Matrix();
                cVar.f11092f = matrix;
            }
            renderNode2.getMatrix(matrix);
            canvas.concat(matrix);
        }
        boolean z12 = !zIsHardwareAccelerated && bVar3.f11085w;
        if (z12) {
            lVarA.h();
            u0.w wVarD = bVar3.d();
            if (wVarD instanceof u0.u) {
                t0.c cVar5 = ((u0.u) wVarD).f9925a;
                renderNode = renderNode2;
                lVarA.e(cVar5.f9656a, cVar5.f9657b, cVar5.f9658c, cVar5.f9659d, 1);
            } else {
                renderNode = renderNode2;
                if (wVarD instanceof u0.v) {
                    u0.f fVarA = bVar3.f11075m;
                    if (fVarA != null) {
                        fVarA.f9903a.rewind();
                    } else {
                        fVarA = u0.h.a();
                        bVar3.f11075m = fVarA;
                    }
                    u0.f.b(fVarA, ((u0.v) wVarD).f9926a);
                    lVarA.a(fVarA);
                } else {
                    if (!(wVarD instanceof u0.t)) {
                        throw new a4.u();
                    }
                    lVarA.a(((u0.t) wVarD).f9924a);
                }
            }
        } else {
            renderNode = renderNode2;
        }
        if (bVar4 != null) {
            c1.o oVar = bVar4.f11080r;
            if (!oVar.f1833a) {
                u0.s.a("Only add dependencies during a tracking");
            }
            k.b0 b0Var = (k.b0) oVar.f1836d;
            if (b0Var != null) {
                b0Var.a(bVar3);
            } else if (((x0.b) oVar.f1834b) != null) {
                int i10 = k.h0.f5493a;
                k.b0 b0Var2 = new k.b0();
                x0.b bVar6 = (x0.b) oVar.f1834b;
                q7.k.b(bVar6);
                b0Var2.a(bVar6);
                b0Var2.a(bVar3);
                oVar.f1836d = b0Var2;
                oVar.f1834b = null;
            } else {
                oVar.f1834b = bVar3;
            }
            k.b0 b0Var3 = (k.b0) oVar.f1837e;
            if (b0Var3 != null) {
                z10 = !b0Var3.k(bVar3);
            } else if (((x0.b) oVar.f1835c) != bVar3) {
                z10 = true;
            } else {
                oVar.f1835c = null;
                z10 = false;
            }
            if (z10) {
                bVar3.f11079q++;
            }
        }
        if (u0.b.a(lVarA).isHardwareAccelerated()) {
            canvas2 = canvas;
            z4 = z12;
            u0.b.a(lVarA).drawRenderNode(renderNode);
        } else {
            w0.b bVar7 = bVar3.f11077o;
            if (bVar7 == null) {
                bVar7 = new w0.b();
                bVar3.f11077o = bVar7;
            }
            u5.h hVar4 = bVar7.f10630g;
            d2.c cVar6 = bVar3.f11064b;
            d2.l lVar3 = bVar3.f11065c;
            long jW = ib.k.W(bVar3.f11083u);
            w0.a aVar2 = ((w0.b) hVar4.f10131c).f10629f;
            d2.c cVar7 = aVar2.f10625a;
            d2.l lVar4 = aVar2.f10626b;
            u0.l lVarA2 = hVar4.a();
            canvas2 = canvas;
            z4 = z12;
            long jB = hVar4.b();
            x0.b bVar8 = (x0.b) hVar4.f10130b;
            hVar4.h(cVar6);
            hVar4.i(lVar3);
            hVar4.g(lVarA);
            hVar4.j(jW);
            hVar4.f10130b = bVar3;
            lVarA.h();
            try {
                bVar3.c(bVar7);
            } finally {
                lVarA.g();
                hVar4.h(cVar7);
                hVar4.i(lVar4);
                hVar4.g(lVarA2);
                hVar4.j(jB);
                hVar4.f10130b = bVar8;
            }
        }
        if (z4) {
            lVarA.g();
        }
        if (z11) {
            lVarA.i();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        canvas2.restore();
    }

    public final void t0(u0.l lVar, x0.b bVar) {
        d1 d1Var;
        u0.l lVar2;
        x0.b bVar2;
        n0.l lVarA0 = A0(4);
        if (lVarA0 == null) {
            P0(lVar, bVar);
            return;
        }
        f0 f0Var = this.f4437t;
        f0Var.getClass();
        h0 sharedDrawScope = ((j1.y) l.w(f0Var)).getSharedDrawScope();
        long jW = ib.k.W(this.f3758h);
        sharedDrawScope.getClass();
        d0.e eVar = null;
        while (lVarA0 != null) {
            if (lVarA0 instanceof m) {
                d1Var = this;
                lVar2 = lVar;
                bVar2 = bVar;
                sharedDrawScope.b(lVar2, jW, d1Var, (m) lVarA0, bVar2);
            } else {
                d1Var = this;
                lVar2 = lVar;
                bVar2 = bVar;
                if ((lVarA0.f6799h & 4) != 0 && (lVarA0 instanceof k)) {
                    int i2 = 0;
                    for (n0.l lVar3 = ((k) lVarA0).f4514u; lVar3 != null; lVar3 = lVar3.f6802k) {
                        if ((lVar3.f6799h & 4) != 0) {
                            i2++;
                            if (i2 == 1) {
                                lVarA0 = lVar3;
                            } else {
                                if (eVar == null) {
                                    eVar = new d0.e(new n0.l[16]);
                                }
                                if (lVarA0 != null) {
                                    eVar.b(lVarA0);
                                    lVarA0 = null;
                                }
                                eVar.b(lVar3);
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
                lVar = lVar2;
                this = d1Var;
                bVar = bVar2;
            }
            lVarA0 = l.e(eVar);
            lVar = lVar2;
            this = d1Var;
            bVar = bVar2;
        }
    }

    public abstract void u0();

    @Override // g1.k
    public final boolean v() {
        return z0().f6810s;
    }

    public final d1 v0(d1 d1Var) {
        f0 f0VarN = d1Var.f4437t;
        f0 f0Var = this.f4437t;
        if (f0VarN == f0Var) {
            n0.l lVarZ0 = d1Var.z0();
            n0.l lVarZ02 = z0();
            if (!lVarZ02.f6797f.f6810s) {
                f1.a.b("visitLocalAncestors called on an unattached node");
            }
            for (n0.l lVar = lVarZ02.f6797f.f6801j; lVar != null; lVar = lVar.f6801j) {
                if ((lVar.f6799h & 2) != 0 && lVar == lVarZ0) {
                    return d1Var;
                }
            }
            return this;
        }
        while (f0VarN.f4465s > f0Var.f4465s) {
            f0VarN = f0VarN.n();
            q7.k.b(f0VarN);
        }
        f0 f0VarN2 = f0Var;
        while (f0VarN2.f4465s > f0VarN.f4465s) {
            f0VarN2 = f0VarN2.n();
            q7.k.b(f0VarN2);
        }
        while (f0VarN != f0VarN2) {
            f0VarN = f0VarN.n();
            f0VarN2 = f0VarN2.n();
            if (f0VarN == null || f0VarN2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (f0VarN2 != f0Var) {
            if (f0VarN != d1Var.f4437t) {
                return (r) f0VarN.H.f4401g;
            }
            return d1Var;
        }
        return this;
    }

    public final long w0(long j2) {
        long j4 = this.E;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - ((int) (j4 >> 32));
        long jFloatToRawIntBits = (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) - ((int) (j4 & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        j1 j1Var = this.N;
        return j1Var != null ? ((j1.n1) j1Var).c(jFloatToRawIntBits, true) : jFloatToRawIntBits;
    }

    @Override // g1.k
    public final long x() {
        return this.f3758h;
    }

    public abstract n0 x0();

    public final long y0() {
        return this.f4443z.F(this.f4437t.C.c());
    }

    public abstract n0.l z0();
}

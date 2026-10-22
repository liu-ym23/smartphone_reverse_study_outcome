package u1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RenderNode;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g1 extends o0 implements s1.e0, s1.q, o1 {
    public static final d1.g0 N;
    public static final u O;
    public static final d P;
    public static final d Q;
    public s1.g0 B;
    public p.z C;
    public float E;
    public c1.a F;
    public u G;
    public g1.b H;
    public d1.o I;
    public h0.k J;
    public boolean L;
    public m1 M;

    /* renamed from: s, reason: collision with root package name */
    public final g0 f13810s;

    /* renamed from: t, reason: collision with root package name */
    public g1 f13811t;

    /* renamed from: u, reason: collision with root package name */
    public g1 f13812u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13813v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13814w;

    /* renamed from: x, reason: collision with root package name */
    public xb.l f13815x;

    /* renamed from: y, reason: collision with root package name */
    public o2.c f13816y;

    /* renamed from: z, reason: collision with root package name */
    public o2.l f13817z;
    public float A = 0.8f;
    public long D = 0;
    public final d1 K = new d1(this, 1);

    static {
        d1.g0 g0Var = new d1.g0();
        g0Var.f2976f = 1.0f;
        g0Var.f2977g = 1.0f;
        g0Var.f2978h = 1.0f;
        long j10 = d1.v.f3030a;
        g0Var.f2979j = j10;
        g0Var.f2980k = j10;
        g0Var.f2981l = 8.0f;
        g0Var.f2982m = d1.m0.f3015b;
        g0Var.f2983n = d1.f0.f2972a;
        g0Var.f2985p = 9205357640488583168L;
        g0Var.f2986q = p5.f.b(1.0f, 1.0f);
        g0Var.f2987r = o2.l.f9123c;
        g0Var.f2988s = 3;
        N = g0Var;
        O = new u();
        P = new d(1);
        Q = new d(2);
    }

    public g1(g0 g0Var) {
        this.f13810s = g0Var;
        this.f13816y = g0Var.A;
        this.f13817z = g0Var.B;
    }

    public final void A0(d1.o oVar, g1.b bVar) {
        Object obj;
        boolean z10;
        boolean z11;
        float f5;
        float f10;
        m1 m1Var = this.M;
        if (m1Var == null) {
            long j10 = this.D;
            float f11 = (int) (j10 >> 32);
            float f12 = (int) (j10 & 4294967295L);
            oVar.n(f11, f12);
            B0(oVar, bVar);
            oVar.n(-f11, -f12);
            return;
        }
        v1.h1 h1Var = (v1.h1) m1Var;
        f1.b bVar2 = h1Var.f14464q;
        h1Var.g();
        h1Var.f14471x = h1Var.f14453c.f4201a.f4234l > 0.0f;
        p5.m mVar = bVar2.f3859f;
        mVar.O(oVar);
        mVar.f9742g = bVar;
        g1.b bVar3 = h1Var.f14453c;
        d1.o oVarY = bVar2.a0().y();
        g1.b bVar4 = (g1.b) bVar2.a0().f9742g;
        g1.c cVar = bVar3.f4201a;
        g1.c cVar2 = bVar3.f4201a;
        RenderNode renderNode = cVar.f4226c;
        if (bVar3.f4218s) {
            return;
        }
        bVar3.a();
        if (!renderNode.hasDisplayList()) {
            try {
                bVar3.f();
            } catch (Throwable unused) {
            }
        }
        boolean z12 = cVar2.f4234l > 0.0f;
        if (z12) {
            oVarY.p();
        }
        Canvas canvasA = d1.b.a(oVarY);
        boolean zIsHardwareAccelerated = canvasA.isHardwareAccelerated();
        if (zIsHardwareAccelerated) {
            obj = null;
        } else {
            long j11 = bVar3.f4219t;
            float f13 = (int) (j11 >> 32);
            float f14 = (int) (j11 & 4294967295L);
            long j12 = bVar3.f4220u;
            float f15 = f13 + ((int) (j12 >> 32));
            float f16 = f14 + ((int) (j12 & 4294967295L));
            float f17 = cVar2.f4231h;
            int i = cVar.i;
            if (f17 < 1.0f || i != 3 || cVar.f4241s == 1) {
                d1.f fVarF = bVar3.f4215p;
                if (fVarF == null) {
                    fVarF = d1.f0.f();
                    bVar3.f4215p = fVarF;
                }
                fVarF.c(f17);
                fVarF.d(i);
                obj = null;
                fVarF.f(null);
                f5 = f13;
                f10 = f14;
                canvasA.saveLayer(f5, f10, f15, f16, (Paint) fVarF.f2968b);
            } else {
                canvasA.save();
                f5 = f13;
                f10 = f14;
                obj = null;
            }
            canvasA.translate(f5, f10);
            Matrix matrix = cVar.f4229f;
            if (matrix == null) {
                matrix = new Matrix();
                cVar.f4229f = matrix;
            }
            renderNode.getMatrix(matrix);
            canvasA.concat(matrix);
        }
        boolean z13 = !zIsHardwareAccelerated && bVar3.f4222w;
        if (z13) {
            oVarY.i();
            d1.c0 c0VarD = bVar3.d();
            if (c0VarD instanceof d1.a0) {
                d1.o.e(oVarY, ((d1.a0) c0VarD).f2957a);
            } else if (c0VarD instanceof d1.b0) {
                d1.h hVarA = bVar3.f4212m;
                if (hVarA != null) {
                    hVarA.f2990a.rewind();
                } else {
                    hVarA = d1.k.a();
                    bVar3.f4212m = hVarA;
                }
                d1.h.a(hVarA, ((d1.b0) c0VarD).f2959a);
                oVarY.a(hVarA);
            } else {
                if (!(c0VarD instanceof d1.z)) {
                    g5.f.a();
                    return;
                }
                oVarY.a(((d1.z) c0VarD).f3035a);
            }
        }
        if (bVar4 != null) {
            ed.e eVar = bVar4.f4217r;
            if (!eVar.f3783a) {
                d1.x.a("Only add dependencies during a tracking");
            }
            p.g0 g0Var = (p.g0) eVar.f3786d;
            if (g0Var != null) {
                g0Var.a(bVar3);
            } else if (((g1.b) eVar.f3784b) != null) {
                int i3 = p.o0.f9601a;
                p.g0 g0Var2 = new p.g0();
                g1.b bVar5 = (g1.b) eVar.f3784b;
                bVar5.getClass();
                g0Var2.a(bVar5);
                g0Var2.a(bVar3);
                eVar.f3786d = g0Var2;
                eVar.f3784b = obj;
            } else {
                eVar.f3784b = bVar3;
            }
            p.g0 g0Var3 = (p.g0) eVar.f3787e;
            if (g0Var3 != null) {
                z11 = !g0Var3.k(bVar3);
            } else if (((g1.b) eVar.f3785c) != bVar3) {
                z11 = true;
            } else {
                eVar.f3785c = obj;
                z11 = false;
            }
            if (z11) {
                bVar3.f4216q++;
            }
        }
        d1.a aVar = (d1.a) oVarY;
        if (aVar.f2954a.isHardwareAccelerated()) {
            z10 = z12;
            aVar.f2954a.drawRenderNode(renderNode);
        } else {
            f1.b bVar6 = bVar3.f4214o;
            if (bVar6 == null) {
                bVar6 = new f1.b();
                bVar3.f4214o = bVar6;
            }
            p5.m mVar2 = bVar6.f3859f;
            o2.c cVar3 = bVar3.f4202b;
            o2.l lVar = bVar3.f4203c;
            long jI0 = ac.a.i0(bVar3.f4220u);
            f1.a aVar2 = ((f1.b) mVar2.f9743h).f3858c;
            o2.c cVar4 = aVar2.f3854a;
            o2.l lVar2 = aVar2.f3855b;
            d1.o oVarY2 = mVar2.y();
            long jD = mVar2.D();
            z10 = z12;
            g1.b bVar7 = (g1.b) mVar2.f9742g;
            mVar2.P(cVar3);
            mVar2.Q(lVar);
            mVar2.O(oVarY);
            mVar2.R(jI0);
            mVar2.f9742g = bVar3;
            oVarY.i();
            try {
                bVar3.c(bVar6);
            } finally {
                oVarY.o();
                mVar2.P(cVar4);
                mVar2.Q(lVar2);
                mVar2.O(oVarY2);
                mVar2.R(jD);
                mVar2.f9742g = bVar7;
            }
        }
        if (z13) {
            oVarY.o();
        }
        if (z10) {
            oVarY.j();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        canvasA.restore();
    }

    @Override // s1.q
    public final long B(s1.q qVar, long j10) {
        return Q0(qVar, j10);
    }

    public final void B0(d1.o oVar, g1.b bVar) {
        g1 g1Var;
        d1.o oVar2;
        g1.b bVar2;
        w0.l lVarI0 = I0(4);
        if (lVarI0 == null) {
            V0(oVar, bVar);
            return;
        }
        g0 g0Var = this.f13810s;
        g0Var.getClass();
        i0 sharedDrawScope = ((v1.t) j0.a(g0Var)).getSharedDrawScope();
        long jI0 = ac.a.i0(this.f11279g);
        sharedDrawScope.getClass();
        m0.e eVar = null;
        while (lVarI0 != null) {
            if (lVarI0 instanceof n) {
                g1Var = this;
                oVar2 = oVar;
                bVar2 = bVar;
                sharedDrawScope.c(oVar2, jI0, g1Var, (n) lVarI0, bVar2);
            } else {
                g1Var = this;
                oVar2 = oVar;
                bVar2 = bVar;
                if ((lVarI0.f15116g & 4) != 0 && (lVarI0 instanceof m)) {
                    int i = 0;
                    for (w0.l lVar = ((m) lVarI0).f13866t; lVar != null; lVar = lVar.f15118j) {
                        if ((lVar.f15116g & 4) != 0) {
                            i++;
                            if (i == 1) {
                                lVarI0 = lVar;
                            } else {
                                if (eVar == null) {
                                    eVar = new m0.e(new w0.l[16]);
                                }
                                if (lVarI0 != null) {
                                    eVar.b(lVarI0);
                                    lVarI0 = null;
                                }
                                eVar.b(lVar);
                            }
                        }
                    }
                    if (i == 1) {
                    }
                }
                oVar = oVar2;
                this = g1Var;
                bVar = bVar2;
            }
            lVarI0 = f.e(eVar);
            oVar = oVar2;
            this = g1Var;
            bVar = bVar2;
        }
    }

    public abstract void C0();

    @Override // s1.q
    public final long D(long j10) {
        if (!H0().f15126r) {
            r1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        R0();
        while (this != null) {
            m1 m1Var = this.M;
            if (m1Var != null) {
                v1.h1 h1Var = (v1.h1) m1Var;
                float[] fArrB = h1Var.b();
                if (!h1Var.f14470w) {
                    j10 = d1.f0.l(fArrB, j10);
                }
            }
            j10 = td.h.C(j10, this.D);
            this = this.f13812u;
        }
        return j10;
    }

    public final g1 D0(g1 g1Var) {
        g0 g0VarT = g1Var.f13810s;
        g0 g0Var = this.f13810s;
        if (g0VarT == g0Var) {
            w0.l lVarH0 = g1Var.H0();
            w0.l lVarH02 = H0();
            if (!lVarH02.f15114c.f15126r) {
                r1.a.b("visitLocalAncestors called on an unattached node");
            }
            for (w0.l lVar = lVarH02.f15114c.i; lVar != null; lVar = lVar.i) {
                if ((lVar.f15116g & 2) != 0 && lVar == lVarH0) {
                    return g1Var;
                }
            }
            return this;
        }
        while (g0VarT.f13802s > g0Var.f13802s) {
            g0VarT = g0VarT.t();
            g0VarT.getClass();
        }
        g0 g0VarT2 = g0Var;
        while (g0VarT2.f13802s > g0VarT.f13802s) {
            g0VarT2 = g0VarT2.t();
            g0VarT2.getClass();
        }
        while (g0VarT != g0VarT2) {
            g0VarT = g0VarT.t();
            g0VarT2 = g0VarT2.t();
            if (g0VarT == null || g0VarT2 == null) {
                g5.f.s("layouts are not part of the same hierarchy");
                return null;
            }
        }
        if (g0VarT2 != g0Var) {
            if (g0VarT != g1Var.f13810s) {
                return g0VarT.H.f13743c;
            }
            return g1Var;
        }
        return this;
    }

    public final long E0(long j10) {
        long j11 = this.D;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) - ((int) (j11 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) - ((int) (j11 & 4294967295L));
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        m1 m1Var = this.M;
        if (m1Var != null) {
            v1.h1 h1Var = (v1.h1) m1Var;
            float[] fArrA = h1Var.a();
            if (fArrA == null) {
                return 9187343241974906880L;
            }
            if (!h1Var.f14470w) {
                return d1.f0.l(fArrA, jFloatToRawIntBits);
            }
        }
        return jFloatToRawIntBits;
    }

    public abstract p0 F0();

    public final long G0() {
        return this.f13816y.j0(this.f13810s.C.c());
    }

    public abstract w0.l H0();

    public final w0.l I0(int i) {
        boolean zG = h1.g(i);
        w0.l lVarH0 = H0();
        if (!zG && (lVarH0 = lVarH0.i) == null) {
            return null;
        }
        for (w0.l lVarJ0 = J0(zG); lVarJ0 != null && (lVarJ0.f15117h & i) != 0; lVarJ0 = lVarJ0.f15118j) {
            if ((lVarJ0.f15116g & i) != 0) {
                return lVarJ0;
            }
            if (lVarJ0 == lVarH0) {
                return null;
            }
        }
        return null;
    }

    public final w0.l J0(boolean z10) {
        w0.l lVarH0;
        c1 c1Var = this.f13810s.H;
        if (c1Var.f13744d == this) {
            return c1Var.f13746f;
        }
        g1 g1Var = this.f13812u;
        if (!z10) {
            if (g1Var != null) {
                return g1Var.H0();
            }
            return null;
        }
        if (g1Var == null || (lVarH0 = g1Var.H0()) == null) {
            return null;
        }
        return lVarH0.f15118j;
    }

    public final void K0(w0.l lVar, d dVar, long j10, q qVar, int i, boolean z10) {
        if (lVar == null) {
            N0(dVar, j10, qVar, i, z10);
            return;
        }
        int i3 = qVar.f13905g;
        p.a0 a0Var = qVar.f13903c;
        qVar.b(i3 + 1, a0Var.f9517b);
        qVar.f13905g++;
        a0Var.a(lVar);
        qVar.f13904f.a(f.a(-1.0f, z10, false));
        K0(f.d(lVar, dVar.b()), dVar, j10, qVar, i, z10);
        qVar.f13905g = i3;
    }

    public final void L0(w0.l lVar, d dVar, long j10, q qVar, int i, boolean z10, float f5) {
        if (lVar == null) {
            N0(dVar, j10, qVar, i, z10);
            return;
        }
        int i3 = qVar.f13905g;
        p.a0 a0Var = qVar.f13903c;
        qVar.b(i3 + 1, a0Var.f9517b);
        qVar.f13905g++;
        a0Var.a(lVar);
        qVar.f13904f.a(f.a(f5, z10, false));
        U0(f.d(lVar, dVar.b()), dVar, j10, qVar, i, z10, f5, true);
        qVar.f13905g = i3;
    }

    public final void M0(d dVar, long j10, q qVar, int i, boolean z10) {
        boolean z11;
        boolean z12;
        w0.l lVarI0 = I0(dVar.b());
        if (!d1(j10)) {
            if (i == 1) {
                float fZ0 = z0(j10, G0());
                if ((Float.floatToRawIntBits(fZ0) & Reader.READ_DONE) < 2139095040) {
                    if (qVar.f13905g != qVar.f13903c.f9517b - 1) {
                        if (f.g(qVar.a(), f.a(fZ0, false, false)) <= 0) {
                            return;
                        }
                    }
                    L0(lVarI0, dVar, j10, qVar, i, false, fZ0);
                    return;
                }
                return;
            }
            return;
        }
        if (lVarI0 == null) {
            N0(dVar, j10, qVar, i, z10);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        if (fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < L() && fIntBitsToFloat2 < I()) {
            K0(lVarI0, dVar, j10, qVar, i, z10);
            return;
        }
        float fZ02 = i == 1 ? z0(j10, G0()) : Float.POSITIVE_INFINITY;
        if ((Float.floatToRawIntBits(fZ02) & Reader.READ_DONE) < 2139095040) {
            if (qVar.f13905g != qVar.f13903c.f9517b - 1) {
                z11 = z10;
                if (f.g(qVar.a(), f.a(fZ02, z11, false)) > 0) {
                }
                U0(lVarI0, dVar, j10, qVar, i, z11, fZ02, z12);
            }
            z11 = z10;
            z12 = true;
            U0(lVarI0, dVar, j10, qVar, i, z11, fZ02, z12);
        }
        z11 = z10;
        z12 = false;
        U0(lVarI0, dVar, j10, qVar, i, z11, fZ02, z12);
    }

    public void N0(d dVar, long j10, q qVar, int i, boolean z10) {
        g1 g1Var = this.f13811t;
        if (g1Var != null) {
            g1Var.M0(dVar, g1Var.E0(j10), qVar, i, z10);
        }
    }

    public final void O0() {
        m1 m1Var = this.M;
        if (m1Var != null) {
            ((v1.h1) m1Var).c();
            return;
        }
        g1 g1Var = this.f13812u;
        if (g1Var != null) {
            g1Var.O0();
        }
    }

    public final boolean P0() {
        if (this.M != null && this.A <= 0.0f) {
            return true;
        }
        g1 g1Var = this.f13812u;
        if (g1Var != null) {
            return g1Var.P0();
        }
        return false;
    }

    public final long Q0(s1.q qVar, long j10) {
        g1 g1Var;
        boolean z10 = qVar instanceof s1.d0;
        if (z10) {
            s1.d0 d0Var = (s1.d0) qVar;
            d0Var.f11232c.f13889s.R0();
            return d0Var.b(this, j10 ^ (-9223372034707292160L)) ^ (-9223372034707292160L);
        }
        s1.d0 d0Var2 = z10 ? (s1.d0) qVar : null;
        if (d0Var2 == null || (g1Var = d0Var2.f11232c.f13889s) == null) {
            qVar.getClass();
            g1Var = (g1) qVar;
        }
        g1Var.R0();
        g1 g1VarD0 = D0(g1Var);
        while (g1Var != g1VarD0) {
            m1 m1Var = g1Var.M;
            if (m1Var != null) {
                v1.h1 h1Var = (v1.h1) m1Var;
                float[] fArrB = h1Var.b();
                if (!h1Var.f14470w) {
                    j10 = d1.f0.l(fArrB, j10);
                }
            }
            j10 = td.h.C(j10, g1Var.D);
            g1Var = g1Var.f13812u;
            g1Var.getClass();
        }
        return x0(g1VarD0, j10);
    }

    public final void R0() {
        this.f13810s.I.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void S0() {
        w0.l lVarH0;
        boolean zG = h1.g(128);
        w0.l lVarJ0 = J0(zG);
        if (lVarJ0 == null || (lVarJ0.f15114c.f15117h & 128) == 0) {
            return;
        }
        u0.f fVarD = u0.r.d();
        xb.l lVarE = fVarD != null ? fVarD.e() : null;
        u0.f fVarG = u0.r.g(fVarD);
        try {
            if (!zG) {
                lVarH0 = H0().i;
                if (lVarH0 == null) {
                }
            }
            lVarH0 = H0();
            for (w0.l lVarJ02 = J0(zG); lVarJ02 != null; lVarJ02 = lVarJ02.f15118j) {
                if ((lVarJ02.f15117h & 128) == 0) {
                    break;
                }
                if ((lVarJ02.f15116g & 128) != 0) {
                    m mVarE = lVarJ02;
                    ?? eVar = 0;
                    while (mVarE != 0) {
                        if (mVarE instanceof v) {
                            ((v) mVarE).m(this.f11279g);
                        } else if ((mVarE.f15116g & 128) != 0 && (mVarE instanceof m)) {
                            w0.l lVar = mVarE.f13866t;
                            int i = 0;
                            mVarE = mVarE;
                            eVar = eVar;
                            while (lVar != null) {
                                if ((lVar.f15116g & 128) != 0) {
                                    i++;
                                    eVar = eVar;
                                    if (i == 1) {
                                        mVarE = lVar;
                                    } else {
                                        if (eVar == 0) {
                                            eVar = new m0.e(new w0.l[16]);
                                        }
                                        if (mVarE != 0) {
                                            eVar.b(mVarE);
                                            mVarE = 0;
                                        }
                                        eVar.b(lVar);
                                    }
                                }
                                lVar = lVar.f15118j;
                                mVarE = mVarE;
                                eVar = eVar;
                            }
                            if (i == 1) {
                            }
                        }
                        mVarE = f.e(eVar);
                    }
                }
                if (lVarJ02 == lVarH0) {
                    break;
                }
            }
        } finally {
            u0.r.j(fVarD, fVarG, lVarE);
        }
    }

    @Override // o2.c
    public final float T() {
        return this.f13810s.A.T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [w0.l] */
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
    /* JADX WARN: Type inference failed for: r5v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void T0() {
        boolean zG = h1.g(128);
        w0.l lVarH0 = H0();
        if (!zG && (lVarH0 = lVarH0.i) == null) {
            return;
        }
        for (w0.l lVarJ0 = J0(zG); lVarJ0 != null && (lVarJ0.f15117h & 128) != 0; lVarJ0 = lVarJ0.f15118j) {
            if ((lVarJ0.f15116g & 128) != 0) {
                m mVarE = lVarJ0;
                ?? eVar = 0;
                while (mVarE != 0) {
                    if (mVarE instanceof v) {
                        ((v) mVarE).Z(this);
                    } else if ((mVarE.f15116g & 128) != 0 && (mVarE instanceof m)) {
                        w0.l lVar = mVarE.f13866t;
                        int i = 0;
                        mVarE = mVarE;
                        eVar = eVar;
                        while (lVar != null) {
                            if ((lVar.f15116g & 128) != 0) {
                                i++;
                                eVar = eVar;
                                if (i == 1) {
                                    mVarE = lVar;
                                } else {
                                    if (eVar == 0) {
                                        eVar = new m0.e(new w0.l[16]);
                                    }
                                    if (mVarE != 0) {
                                        eVar.b(mVarE);
                                        mVarE = 0;
                                    }
                                    eVar.b(lVar);
                                }
                            }
                            lVar = lVar.f15118j;
                            mVarE = mVarE;
                            eVar = eVar;
                        }
                        if (i == 1) {
                        }
                    }
                    mVarE = f.e(eVar);
                }
            }
            if (lVarJ0 == lVarH0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0189 A[PHI: r5
      0x0189: PHI (r5v6 m0.e) = (r5v1 m0.e), (r5v1 m0.e), (r5v8 m0.e) binds: [B:52:0x0155, B:54:0x0159, B:68:0x0183] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(w0.l r18, u1.d r19, long r20, u1.q r22, int r23, boolean r24, float r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.g1.U0(w0.l, u1.d, long, u1.q, int, boolean, float, boolean):void");
    }

    public abstract void V0(d1.o oVar, g1.b bVar);

    public final void W0(long j10, float f5, xb.l lVar) {
        b1(lVar, false);
        boolean zB = o2.i.b(this.D, j10);
        g0 g0Var = this.f13810s;
        if (!zB) {
            ((v1.t) j0.a(g0Var)).I(-4.0f);
            this.D = j10;
            g0Var.I.f13857p.d0();
            m1 m1Var = this.M;
            if (m1Var != null) {
                ((v1.h1) m1Var).d(j10);
            } else {
                g1 g1Var = this.f13812u;
                if (g1Var != null) {
                    g1Var.O0();
                }
            }
            m0.e eVarX = g0Var.x();
            Object[] objArr = eVarX.f8158c;
            int i = eVarX.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                ((g0) objArr[i3]).D();
            }
            o0.t0(this);
            n1 n1Var = g0Var.f13800q;
            if (n1Var != null) {
                ((v1.t) n1Var).w(g0Var);
            }
        }
        this.E = f5;
        if (!this.f13882o) {
            d0(p0());
        }
        if (this == g0Var.H.f13744d) {
            ((v1.t) j0.a(g0Var)).getRectManager().f(g0Var, !g0Var.I.f13857p.f13961o);
        }
    }

    public final void X0(c1.a aVar, boolean z10, boolean z11) {
        m1 m1Var = this.M;
        if (m1Var != null) {
            if (this.f13814w) {
                if (z11) {
                    long jG0 = G0();
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jG0 >> 32)) / 2.0f;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jG0 & 4294967295L)) / 2.0f;
                    long j10 = this.f11279g;
                    aVar.a(-fIntBitsToFloat, -fIntBitsToFloat2, ((int) (j10 >> 32)) + fIntBitsToFloat, ((int) (j10 & 4294967295L)) + fIntBitsToFloat2);
                } else if (z10) {
                    long j11 = this.f11279g;
                    aVar.a(0.0f, 0.0f, (int) (j11 >> 32), (int) (j11 & 4294967295L));
                }
                if (aVar.b()) {
                    return;
                }
            }
            v1.h1 h1Var = (v1.h1) m1Var;
            float[] fArrB = h1Var.b();
            if (!h1Var.f14470w) {
                if (fArrB == null) {
                    aVar.f2161a = 0.0f;
                    aVar.f2162b = 0.0f;
                    aVar.f2163c = 0.0f;
                    aVar.f2164d = 0.0f;
                } else {
                    d1.f0.m(fArrB, aVar);
                }
            }
        }
        long j12 = this.D;
        float f5 = (int) (j12 >> 32);
        aVar.f2161a += f5;
        aVar.f2163c += f5;
        float f10 = (int) (j12 & 4294967295L);
        aVar.f2162b += f10;
        aVar.f2164d += f10;
    }

    public final void Y0() {
        if (this.M != null) {
            b1(null, false);
            this.f13810s.U(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [w0.l] */
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
    /* JADX WARN: Type inference failed for: r9v5, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [m0.e] */
    public final void Z0(s1.g0 g0Var) {
        g1 g1Var;
        s1.g0 g0Var2 = this.B;
        if (g0Var != g0Var2) {
            this.B = g0Var;
            g0 g0Var3 = this.f13810s;
            int i = 0;
            if (g0Var2 == null || g0Var.e() != g0Var2.e() || g0Var.d() != g0Var2.d()) {
                int iE = g0Var.e();
                int iD = g0Var.d();
                m1 m1Var = this.M;
                if (m1Var != null) {
                    ((v1.h1) m1Var).e((iE << 32) | (iD & 4294967295L));
                } else if (g0Var3.H() && (g1Var = this.f13812u) != null) {
                    g1Var.O0();
                }
                S((iD & 4294967295L) | (iE << 32));
                if (this.f13815x != null) {
                    c1(false);
                }
                boolean zG = h1.g(4);
                w0.l lVarH0 = H0();
                if (zG || (lVarH0 = lVarH0.i) != null) {
                    for (w0.l lVarJ0 = J0(zG); lVarJ0 != null && (lVarJ0.f15117h & 4) != 0; lVarJ0 = lVarJ0.f15118j) {
                        if ((lVarJ0.f15116g & 4) != 0) {
                            m mVarE = lVarJ0;
                            ?? eVar = 0;
                            while (mVarE != 0) {
                                if (mVarE instanceof n) {
                                    ((n) mVarE).H();
                                } else if ((mVarE.f15116g & 4) != 0 && (mVarE instanceof m)) {
                                    w0.l lVar = mVarE.f13866t;
                                    int i3 = 0;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                    while (lVar != null) {
                                        if ((lVar.f15116g & 4) != 0) {
                                            i3++;
                                            eVar = eVar;
                                            if (i3 == 1) {
                                                mVarE = lVar;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new m0.e(new w0.l[16]);
                                                }
                                                if (mVarE != 0) {
                                                    eVar.b(mVarE);
                                                    mVarE = 0;
                                                }
                                                eVar.b(lVar);
                                            }
                                        }
                                        lVar = lVar.f15118j;
                                        mVarE = mVarE;
                                        eVar = eVar;
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                mVarE = f.e(eVar);
                            }
                        }
                        if (lVarJ0 == lVarH0) {
                            break;
                        }
                    }
                }
                n1 n1Var = g0Var3.f13800q;
                if (n1Var != null) {
                    ((v1.t) n1Var).w(g0Var3);
                }
            }
            p.z zVar = this.C;
            if ((zVar == null || zVar.f9654e == 0) && g0Var.b().isEmpty()) {
                return;
            }
            p.z zVar2 = this.C;
            Map mapB = g0Var.b();
            if (zVar2 != null && zVar2.f9654e == mapB.size()) {
                Object[] objArr = zVar2.f9651b;
                int[] iArr = zVar2.f9652c;
                long[] jArr = zVar2.f9650a;
                int length = jArr.length - 2;
                if (length < 0) {
                    return;
                }
                int i10 = 0;
                loop0: while (true) {
                    long j10 = jArr[i10];
                    if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i11 = 8 - ((~(i10 - length)) >>> 31);
                        for (int i12 = i; i12 < i11; i12++) {
                            if ((255 & j10) < 128) {
                                int i13 = (i10 << 3) + i12;
                                Object obj = objArr[i13];
                                int i14 = iArr[i13];
                                Integer num = (Integer) mapB.get((s1.l) obj);
                                if (num == null || num.intValue() != i14) {
                                    break loop0;
                                }
                            }
                            j10 >>= 8;
                        }
                        if (i11 != 8) {
                            return;
                        }
                    }
                    if (i10 == length) {
                        return;
                    }
                    i10++;
                    i = 0;
                }
            }
            g0Var3.I.f13857p.B.f();
            p.z zVar3 = this.C;
            if (zVar3 == null) {
                p.z zVar4 = p.j0.f9585a;
                zVar3 = new p.z();
                this.C = zVar3;
            }
            zVar3.a();
            for (Map.Entry entry : g0Var.b().entrySet()) {
                zVar3.h(((Number) entry.getValue()).intValue(), entry.getKey());
            }
        }
    }

    @Override // o2.c
    public final float a() {
        return this.f13810s.A.a();
    }

    public final c1.c a1() {
        if (H0().f15126r) {
            s1.q qVarI = s1.v0.i(this);
            c1.a aVar = this.F;
            if (aVar == null) {
                aVar = new c1.a();
                this.F = aVar;
            }
            long jY0 = y0(G0());
            int i = (int) (jY0 >> 32);
            aVar.f2161a = -Float.intBitsToFloat(i);
            int i3 = (int) (jY0 & 4294967295L);
            aVar.f2162b = -Float.intBitsToFloat(i3);
            aVar.f2163c = Float.intBitsToFloat(i) + L();
            aVar.f2164d = Float.intBitsToFloat(i3) + I();
            while (this != qVarI) {
                this.X0(aVar, false, true);
                if (!aVar.b()) {
                    this = this.f13812u;
                    this.getClass();
                }
            }
            return new c1.c(aVar.f2161a, aVar.f2162b, aVar.f2163c, aVar.f2164d);
        }
        return c1.c.f2166e;
    }

    public final void b1(xb.l lVar, boolean z10) {
        n1 n1Var;
        m0.e eVar;
        Reference referencePoll;
        h0.k kVar;
        m0.e eVar2;
        Reference referencePoll2;
        Object obj;
        g0 g0Var = this.f13810s;
        boolean z11 = (!z10 && this.f13815x == lVar && yb.k.a(this.f13816y, g0Var.A) && this.f13817z == g0Var.B) ? false : true;
        this.f13816y = g0Var.A;
        this.f13817z = g0Var.B;
        boolean zG = g0Var.G();
        d1 d1Var = this.K;
        if (!zG || lVar == null) {
            this.f13815x = null;
            m1 m1Var = this.M;
            if (m1Var != null) {
                v1.h1 h1Var = (v1.h1) m1Var;
                h1Var.f14456h = null;
                h1Var.i = null;
                h1Var.f14458k = true;
                h1Var.f(false);
                d1.u uVar = h1Var.f14454f;
                if (uVar != null) {
                    uVar.a(h1Var.f14453c);
                    v1.t tVar = h1Var.f14455g;
                    p5.l lVar2 = tVar.f14572w0;
                    do {
                        ReferenceQueue referenceQueue = (ReferenceQueue) lVar2.f9739f;
                        eVar = (m0.e) lVar2.f9738c;
                        referencePoll = referenceQueue.poll();
                        if (referencePoll != null) {
                            eVar.j(referencePoll);
                        }
                    } while (referencePoll != null);
                    eVar.b(new WeakReference(h1Var, (ReferenceQueue) lVar2.f9739f));
                    tVar.B.remove(h1Var);
                }
                g0Var.L = true;
                d1Var.invoke();
                if (H0().f15126r && g0Var.H() && (n1Var = g0Var.f13800q) != null) {
                    ((v1.t) n1Var).w(g0Var);
                }
            }
            this.M = null;
            this.L = false;
            return;
        }
        this.f13815x = lVar;
        if (this.M != null) {
            if (z11 && c1(true)) {
                ((v1.t) j0.a(g0Var)).getRectManager().e(g0Var);
                return;
            }
            return;
        }
        n1 n1VarA = j0.a(g0Var);
        h0.k kVar2 = this.J;
        if (kVar2 == null) {
            h0.k kVar3 = new h0.k(6, this, new d1(this, 0));
            this.J = kVar3;
            kVar = kVar3;
        } else {
            kVar = kVar2;
        }
        v1.t tVar2 = (v1.t) n1VarA;
        p5.l lVar3 = tVar2.f14572w0;
        do {
            ReferenceQueue referenceQueue2 = (ReferenceQueue) lVar3.f9739f;
            eVar2 = (m0.e) lVar3.f9738c;
            referencePoll2 = referenceQueue2.poll();
            if (referencePoll2 != null) {
                eVar2.j(referencePoll2);
            }
        } while (referencePoll2 != null);
        while (true) {
            int i = eVar2.f8160g;
            if (i == 0) {
                obj = null;
                break;
            } else {
                obj = ((Reference) eVar2.k(i - 1)).get();
                if (obj != null) {
                    break;
                }
            }
        }
        m1 h1Var2 = (m1) obj;
        if (h1Var2 != null) {
            v1.h1 h1Var3 = (v1.h1) h1Var2;
            d1.u uVar2 = h1Var3.f14454f;
            if (uVar2 == null) {
                throw w2.c.a("currently reuse is only supported when we manage the layer lifecycle");
            }
            if (!h1Var3.f14453c.f4218s) {
                r1.a.a("layer should have been released before reuse");
            }
            h1Var3.f14453c = uVar2.b();
            h1Var3.f14458k = false;
            h1Var3.f14456h = kVar;
            h1Var3.i = d1Var;
            h1Var3.f14468u = false;
            h1Var3.f14469v = false;
            h1Var3.f14470w = true;
            d1.f0.n(h1Var3.f14459l);
            float[] fArr = h1Var3.f14460m;
            if (fArr != null) {
                d1.f0.n(fArr);
            }
            h1Var3.f14466s = d1.m0.f3015b;
            h1Var3.f14471x = false;
            long j10 = Reader.READ_DONE;
            h1Var3.f14457j = (j10 & 4294967295L) | (j10 << 32);
            h1Var3.f14467t = null;
            h1Var3.f14465r = 0;
        } else {
            h1Var2 = new v1.h1(tVar2.getGraphicsContext().b(), tVar2.getGraphicsContext(), tVar2, kVar, d1Var);
        }
        v1.h1 h1Var4 = (v1.h1) h1Var2;
        h1Var4.e(this.f11279g);
        h1Var4.d(this.D);
        this.M = h1Var2;
        c1(true);
        g0Var.L = true;
        d1Var.invoke();
    }

    @Override // s1.q
    public final long c(long j10) {
        long jD = D(j10);
        v1.t tVar = (v1.t) j0.a(this.f13810s);
        tVar.A();
        return d1.f0.l(tVar.U, jD);
    }

    public final boolean c1(boolean z10) {
        long j10;
        boolean z11;
        n1 n1Var;
        xb.a aVar;
        m1 m1Var = this.M;
        xb.l lVar = this.f13815x;
        if (m1Var == null) {
            if (lVar == null) {
                return false;
            }
            r1.a.b("null layer with a non-null layerBlock");
            return false;
        }
        if (lVar == null) {
            throw w2.c.a("updateLayerParameters requires a non-null layerBlock");
        }
        d1.g0 g0Var = N;
        g0Var.c(1.0f);
        g0Var.d(1.0f);
        g0Var.b(1.0f);
        if (g0Var.i != 0.0f) {
            g0Var.f2975c |= 32;
            g0Var.i = 0.0f;
        }
        long j11 = d1.v.f3030a;
        if (!d1.p.d(g0Var.f2979j, j11)) {
            g0Var.f2975c |= 64;
            g0Var.f2979j = j11;
        }
        if (!d1.p.d(g0Var.f2980k, j11)) {
            g0Var.f2975c |= 128;
            g0Var.f2980k = j11;
        }
        if (g0Var.f2981l != 8.0f) {
            g0Var.f2975c |= RecyclerView.ItemAnimator.FLAG_MOVED;
            g0Var.f2981l = 8.0f;
        }
        long j12 = d1.m0.f3015b;
        g0Var.f(j12);
        d1.j0 j0Var = g0Var.f2983n;
        d1.e0 e0Var = d1.f0.f2972a;
        if (!yb.k.a(j0Var, e0Var)) {
            g0Var.f2975c |= 8192;
            g0Var.f2983n = e0Var;
        }
        if (g0Var.f2984o) {
            g0Var.f2975c |= 16384;
            g0Var.f2984o = false;
        }
        if (g0Var.f2988s != 3) {
            g0Var.f2975c |= 524288;
            g0Var.f2988s = 3;
        }
        g0Var.f2985p = 9205357640488583168L;
        g0Var.f2989t = null;
        g0Var.f2975c = 0;
        g0 g0Var2 = this.f13810s;
        g0Var.f2986q = g0Var2.A;
        g0Var.f2987r = g0Var2.B;
        g0Var.f2985p = ac.a.i0(this.f11279g);
        ((v1.t) j0.a(g0Var2)).getSnapshotObserver().a(this, e.i, new ad.l(lVar, 26));
        u uVar = this.G;
        if (uVar == null) {
            uVar = new u();
            this.G = uVar;
        }
        u uVar2 = O;
        uVar2.getClass();
        uVar2.f13938a = uVar.f13938a;
        uVar2.f13939b = uVar.f13939b;
        uVar2.f13940c = uVar.f13940c;
        uVar2.f13941d = uVar.f13941d;
        float f5 = g0Var.f2976f;
        uVar.f13938a = f5;
        uVar.f13939b = g0Var.f2977g;
        uVar.f13940c = g0Var.f2981l;
        long j13 = g0Var.f2982m;
        uVar.f13941d = j13;
        v1.h1 h1Var = (v1.h1) m1Var;
        v1.t tVar = h1Var.f14455g;
        int i = h1Var.f14465r | g0Var.f2975c;
        h1Var.f14463p = g0Var.f2987r;
        h1Var.f14462o = g0Var.f2986q;
        int i3 = i & 4096;
        if (i3 != 0) {
            h1Var.f14466s = j13;
        }
        if ((i & 1) != 0) {
            g1.c cVar = h1Var.f14453c.f4201a;
            if (cVar.f4232j != f5) {
                cVar.f4232j = f5;
                cVar.f4226c.setScaleX(f5);
            }
        }
        if ((i & 2) != 0) {
            g1.b bVar = h1Var.f14453c;
            float f10 = g0Var.f2977g;
            g1.c cVar2 = bVar.f4201a;
            if (cVar2.f4233k != f10) {
                cVar2.f4233k = f10;
                cVar2.f4226c.setScaleY(f10);
            }
        }
        if ((i & 4) != 0) {
            g1.b bVar2 = h1Var.f14453c;
            float f11 = g0Var.f2978h;
            g1.c cVar3 = bVar2.f4201a;
            if (cVar3.f4231h != f11) {
                cVar3.f4231h = f11;
                cVar3.f4226c.setAlpha(f11);
            }
        }
        if ((i & 8) != 0) {
            g1.c cVar4 = h1Var.f14453c.f4201a;
        }
        if ((i & 16) != 0) {
            g1.c cVar5 = h1Var.f14453c.f4201a;
        }
        if ((i & 32) != 0) {
            g1.b bVar3 = h1Var.f14453c;
            float f12 = g0Var.i;
            g1.c cVar6 = bVar3.f4201a;
            if (cVar6.f4234l != f12) {
                cVar6.f4234l = f12;
                cVar6.f4226c.setElevation(f12);
                bVar3.f4207g = true;
                bVar3.a();
            }
            if (g0Var.i > 0.0f && !h1Var.f14471x && (aVar = h1Var.i) != null) {
                aVar.invoke();
            }
        }
        if ((i & 64) != 0) {
            g1.b bVar4 = h1Var.f14453c;
            long j14 = g0Var.f2979j;
            g1.c cVar7 = bVar4.f4201a;
            if (!d1.p.d(j14, cVar7.f4235m)) {
                cVar7.f4235m = j14;
                cVar7.f4226c.setAmbientShadowColor(d1.f0.r(j14));
            }
        }
        if ((i & 128) != 0) {
            g1.b bVar5 = h1Var.f14453c;
            long j15 = g0Var.f2980k;
            g1.c cVar8 = bVar5.f4201a;
            if (!d1.p.d(j15, cVar8.f4236n)) {
                cVar8.f4236n = j15;
                cVar8.f4226c.setSpotShadowColor(d1.f0.r(j15));
            }
        }
        if ((i & 1024) != 0) {
            g1.c cVar9 = h1Var.f14453c.f4201a;
        }
        if ((i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0) {
            g1.c cVar10 = h1Var.f14453c.f4201a;
        }
        if ((i & 512) != 0) {
            g1.c cVar11 = h1Var.f14453c.f4201a;
        }
        if ((i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
            g1.b bVar6 = h1Var.f14453c;
            float f13 = g0Var.f2981l;
            g1.c cVar12 = bVar6.f4201a;
            if (cVar12.f4237o != f13) {
                cVar12.f4237o = f13;
                cVar12.f4226c.setCameraDistance(f13);
            }
        }
        if (i3 != 0) {
            boolean zB = d1.m0.b(h1Var.f14466s, j12);
            g1.b bVar7 = h1Var.f14453c;
            if (zB) {
                bVar7.g(9205357640488583168L);
                j10 = 4294967295L;
            } else {
                j10 = 4294967295L;
                bVar7.g((Float.floatToRawIntBits(Float.intBitsToFloat((int) (h1Var.f14466s & 4294967295L)) * ((int) (h1Var.f14457j & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (h1Var.f14466s >> 32)) * ((int) (h1Var.f14457j >> 32))) << 32));
            }
        } else {
            j10 = 4294967295L;
        }
        if ((i & 16384) != 0) {
            g1.b bVar8 = h1Var.f14453c;
            boolean z12 = g0Var.f2984o;
            if (bVar8.f4222w != z12) {
                bVar8.f4222w = z12;
                bVar8.f4207g = true;
                bVar8.a();
            }
        }
        if ((131072 & i) != 0) {
            g1.c cVar13 = h1Var.f14453c.f4201a;
        }
        if ((262144 & i) != 0) {
            g1.c cVar14 = h1Var.f14453c.f4201a;
        }
        if ((i & 524288) != 0) {
            g1.b bVar9 = h1Var.f14453c;
            int i10 = g0Var.f2988s;
            g1.c cVar15 = bVar9.f4201a;
            if (cVar15.i != i10) {
                cVar15.i = i10;
                Paint paint = cVar15.f4228e;
                if (paint == null) {
                    paint = new Paint();
                    cVar15.f4228e = paint;
                }
                paint.setBlendMode(d1.f0.p(i10));
                cVar15.c();
            }
        }
        if ((32768 & i) != 0) {
            g1.c cVar16 = h1Var.f14453c.f4201a;
            if (cVar16.f4241s != 0) {
                cVar16.f4241s = 0;
                cVar16.c();
            }
        }
        if ((i & 7963) != 0) {
            h1Var.f14468u = true;
            h1Var.f14469v = true;
        }
        if (yb.k.a(h1Var.f14467t, g0Var.f2989t)) {
            z11 = false;
        } else {
            d1.c0 c0Var = g0Var.f2989t;
            h1Var.f14467t = c0Var;
            if (c0Var != null) {
                g1.b bVar10 = h1Var.f14453c;
                if (c0Var instanceof d1.a0) {
                    c1.c cVar17 = ((d1.a0) c0Var).f2957a;
                    float f14 = cVar17.f2167a;
                    float f15 = cVar17.f2168b;
                    bVar10.i((Float.floatToRawIntBits(f14) << 32) | (Float.floatToRawIntBits(f15) & j10), (Float.floatToRawIntBits(cVar17.f2169c - f14) << 32) | (Float.floatToRawIntBits(cVar17.f2170d - f15) & j10), 0.0f);
                } else if (c0Var instanceof d1.z) {
                    d1.h hVar = ((d1.z) c0Var).f3035a;
                    bVar10.f4210k = null;
                    bVar10.i = 9205357640488583168L;
                    bVar10.f4208h = 0L;
                    bVar10.f4209j = 0.0f;
                    bVar10.f4207g = true;
                    bVar10.f4213n = false;
                    bVar10.f4211l = hVar;
                    bVar10.a();
                } else {
                    if (!(c0Var instanceof d1.b0)) {
                        g5.f.a();
                        return false;
                    }
                    d1.b0 b0Var = (d1.b0) c0Var;
                    d1.h hVar2 = b0Var.f2960b;
                    if (hVar2 != null) {
                        bVar10.f4210k = null;
                        bVar10.i = 9205357640488583168L;
                        bVar10.f4208h = 0L;
                        bVar10.f4209j = 0.0f;
                        bVar10.f4207g = true;
                        bVar10.f4213n = false;
                        bVar10.f4211l = hVar2;
                        bVar10.a();
                    } else {
                        c1.d dVar = b0Var.f2959a;
                        float f16 = dVar.f2172b;
                        float f17 = dVar.f2171a;
                        bVar10.i((Float.floatToRawIntBits(f17) << 32) | (Float.floatToRawIntBits(f16) & j10), (Float.floatToRawIntBits(dVar.f2173c - f17) << 32) | (Float.floatToRawIntBits(dVar.f2174d - f16) & j10), Float.intBitsToFloat((int) (dVar.f2178h >> 32)));
                    }
                }
            }
            z11 = true;
        }
        h1Var.f14465r = g0Var.f2975c;
        if (i != 0 || z11) {
            ViewParent parent = tVar.getParent();
            if (parent != null) {
                parent.onDescendantInvalidated(tVar, tVar);
            }
            if (tVar.f14545j) {
                tVar.I(0.0f);
            }
        }
        boolean z13 = this.f13814w;
        this.f13814w = g0Var.f2984o;
        this.A = g0Var.f2978h;
        boolean z14 = uVar2.f13938a == uVar.f13938a && uVar2.f13939b == uVar.f13939b && uVar2.f13940c == uVar.f13940c && d1.m0.b(uVar2.f13941d, uVar.f13941d);
        boolean z15 = !z14;
        if (z10 && ((!z14 || z13 != this.f13814w) && (n1Var = g0Var2.f13800q) != null)) {
            ((v1.t) n1Var).w(g0Var2);
        }
        return z15;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d1(long r24) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.g1.d1(long):boolean");
    }

    @Override // u1.o0
    public final o0 f0() {
        return this.f13811t;
    }

    @Override // s1.q
    public final c1.c g(s1.q qVar, boolean z10) {
        g1 g1Var;
        if (!H0().f15126r) {
            r1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!qVar.k()) {
            r1.a.b("LayoutCoordinates " + qVar + " is not attached!");
        }
        s1.d0 d0Var = qVar instanceof s1.d0 ? (s1.d0) qVar : null;
        if (d0Var == null || (g1Var = d0Var.f11232c.f13889s) == null) {
            g1Var = (g1) qVar;
        }
        g1Var.R0();
        g1 g1VarD0 = D0(g1Var);
        c1.a aVar = this.F;
        if (aVar == null) {
            aVar = new c1.a();
            this.F = aVar;
        }
        aVar.f2161a = 0.0f;
        aVar.f2162b = 0.0f;
        aVar.f2163c = (int) (qVar.l() >> 32);
        aVar.f2164d = (int) (qVar.l() & 4294967295L);
        while (g1Var != g1VarD0) {
            g1Var.X0(aVar, z10, false);
            if (aVar.b()) {
                return c1.c.f2166e;
            }
            g1Var = g1Var.f13812u;
            g1Var.getClass();
        }
        w0(g1VarD0, aVar, z10);
        return new c1.c(aVar.f2161a, aVar.f2162b, aVar.f2163c, aVar.f2164d);
    }

    @Override // s1.h0
    public final o2.l getLayoutDirection() {
        return this.f13810s.B;
    }

    @Override // s1.q
    public final boolean k() {
        return H0().f15126r;
    }

    @Override // s1.q
    public final long l() {
        return this.f11279g;
    }

    @Override // u1.o0
    public final boolean l0() {
        return this.B != null;
    }

    @Override // s1.q
    public final long m(long j10) {
        if (!H0().f15126r) {
            r1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return ((v1.t) j0.a(this.f13810s)).s(D(j10));
    }

    @Override // u1.o1
    public final boolean o() {
        return (this.M == null || this.f13813v || !this.f13810s.G()) ? false : true;
    }

    @Override // u1.o0
    public final g0 o0() {
        return this.f13810s;
    }

    @Override // u1.o0
    public final s1.g0 p0() {
        s1.g0 g0Var = this.B;
        if (g0Var != null) {
            return g0Var;
        }
        od.f.e("Asking for measurement result of unmeasured layout modifier");
        return null;
    }

    @Override // u1.o0
    public final o0 q0() {
        return this.f13812u;
    }

    @Override // u1.o0
    public final long r0() {
        return this.D;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // s1.o0, s1.e0
    public final Object v() {
        g0 g0Var = this.f13810s;
        if (!g0Var.H.d(64)) {
            return null;
        }
        H0();
        Object objB0 = null;
        for (w0.l lVar = g0Var.H.f13745e; lVar != null; lVar = lVar.i) {
            if ((lVar.f15116g & 64) != 0) {
                m mVarE = lVar;
                ?? eVar = 0;
                while (mVarE != 0) {
                    if (mVarE instanceof q1) {
                        objB0 = ((q1) mVarE).b0(g0Var.A, objB0);
                    } else if ((mVarE.f15116g & 64) != 0 && (mVarE instanceof m)) {
                        w0.l lVar2 = mVarE.f13866t;
                        int i = 0;
                        mVarE = mVarE;
                        eVar = eVar;
                        while (lVar2 != null) {
                            if ((lVar2.f15116g & 64) != 0) {
                                i++;
                                eVar = eVar;
                                if (i == 1) {
                                    mVarE = lVar2;
                                } else {
                                    if (eVar == 0) {
                                        eVar = new m0.e(new w0.l[16]);
                                    }
                                    if (mVarE != 0) {
                                        eVar.b(mVarE);
                                        mVarE = 0;
                                    }
                                    eVar.b(lVar2);
                                }
                            }
                            lVar2 = lVar2.f15118j;
                            mVarE = mVarE;
                            eVar = eVar;
                        }
                        if (i == 1) {
                        }
                    }
                    mVarE = f.e(eVar);
                }
            }
        }
        return objB0;
    }

    @Override // u1.o0
    public final void v0() {
        R(this.D, this.E, this.f13815x);
    }

    @Override // s1.q
    public final s1.q w() {
        if (!H0().f15126r) {
            r1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        R0();
        return this.f13810s.H.f13744d.f13812u;
    }

    public final void w0(g1 g1Var, c1.a aVar, boolean z10) {
        if (g1Var == this) {
            return;
        }
        g1 g1Var2 = this.f13812u;
        if (g1Var2 != null) {
            g1Var2.w0(g1Var, aVar, z10);
        }
        long j10 = this.D;
        float f5 = (int) (j10 >> 32);
        aVar.f2161a -= f5;
        aVar.f2163c -= f5;
        float f10 = (int) (j10 & 4294967295L);
        aVar.f2162b -= f10;
        aVar.f2164d -= f10;
        m1 m1Var = this.M;
        if (m1Var != null) {
            v1.h1 h1Var = (v1.h1) m1Var;
            float[] fArrA = h1Var.a();
            if (!h1Var.f14470w) {
                if (fArrA == null) {
                    aVar.f2161a = 0.0f;
                    aVar.f2162b = 0.0f;
                    aVar.f2163c = 0.0f;
                    aVar.f2164d = 0.0f;
                } else {
                    d1.f0.m(fArrA, aVar);
                }
            }
            if (this.f13814w && z10) {
                long j11 = this.f11279g;
                aVar.a(0.0f, 0.0f, (int) (j11 >> 32), (int) (j11 & 4294967295L));
            }
        }
    }

    public final long x0(g1 g1Var, long j10) {
        if (g1Var == this) {
            return j10;
        }
        g1 g1Var2 = this.f13812u;
        return (g1Var2 == null || yb.k.a(g1Var, g1Var2)) ? E0(j10) : E0(g1Var2.x0(g1Var, j10));
    }

    public final long y0(long j10) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) - L();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) - I();
        float fMax = Math.max(0.0f, fIntBitsToFloat / 2.0f);
        float fMax2 = Math.max(0.0f, fIntBitsToFloat2 / 2.0f);
        return (Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax2) & 4294967295L);
    }

    public final float z0(long j10, long j11) {
        if (L() >= Float.intBitsToFloat((int) (j11 >> 32)) && I() >= Float.intBitsToFloat((int) (j11 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jY0 = y0(j11);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jY0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jY0 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j10 >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat3 < 0.0f ? -fIntBitsToFloat3 : fIntBitsToFloat3 - L());
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (j10 & 4294967295L)) < 0.0f ? -r9 : r9 - I())) & 4294967295L);
        if (fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) {
            int i = (int) (jFloatToRawIntBits >> 32);
            if (Float.intBitsToFloat(i) <= fIntBitsToFloat) {
                int i3 = (int) (jFloatToRawIntBits & 4294967295L);
                if (Float.intBitsToFloat(i3) <= fIntBitsToFloat2) {
                    float fIntBitsToFloat4 = Float.intBitsToFloat(i);
                    float fIntBitsToFloat5 = Float.intBitsToFloat(i3);
                    return (fIntBitsToFloat5 * fIntBitsToFloat5) + (fIntBitsToFloat4 * fIntBitsToFloat4);
                }
            }
        }
        return Float.POSITIVE_INFINITY;
    }

    @Override // u1.o0
    public final s1.q h0() {
        return this;
    }
}

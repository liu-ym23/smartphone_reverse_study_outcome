package c0;

import a2.u;
import a2.x;
import d1.f0;
import d1.o;
import d1.p;
import d2.e0;
import d2.l0;
import d2.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import u1.i0;
import u1.n;
import u1.v1;
import u1.w;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends l implements w, n, v1 {
    public List A;
    public xb.l B;
    public xb.l C;
    public Map D;
    public d E;
    public g F;
    public f G;

    /* renamed from: s, reason: collision with root package name */
    public d2.g f2139s;

    /* renamed from: t, reason: collision with root package name */
    public l0 f2140t;

    /* renamed from: u, reason: collision with root package name */
    public g2.d f2141u;

    /* renamed from: v, reason: collision with root package name */
    public xb.l f2142v;

    /* renamed from: w, reason: collision with root package name */
    public int f2143w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2144x;

    /* renamed from: y, reason: collision with root package name */
    public int f2145y;

    /* renamed from: z, reason: collision with root package name */
    public int f2146z;

    @Override // u1.v1
    public final boolean B() {
        return true;
    }

    public final d B0() {
        if (this.E == null) {
            this.E = new d(this.f2139s, this.f2140t, this.f2141u, this.f2143w, this.f2144x, this.f2145y, this.f2146z, this.A);
        }
        d dVar = this.E;
        dVar.getClass();
        return dVar;
    }

    @Override // u1.n
    public final void b(i0 i0Var) {
        d dVarB0;
        if (!this.f15126r) {
            return;
        }
        o oVarY = i0Var.f13838c.f3859f.y();
        f fVar = this.G;
        if (fVar == null || !fVar.f2135c || (dVarB0 = fVar.f2136d) == null) {
            dVarB0 = B0();
            dVarB0.a(i0Var);
        } else {
            dVarB0.a(i0Var);
        }
        d2.i0 i0Var2 = dVarB0.f2117n;
        if (i0Var2 == null) {
            od.f.e("You must call layoutWithConstraints first");
            return;
        }
        d2.o oVar = i0Var2.f3123b;
        long j10 = i0Var2.f3124c;
        boolean z10 = true;
        boolean z11 = (((float) ((int) (j10 >> 32))) < oVar.f3152d || oVar.f3151c || ((float) ((int) (j10 & 4294967295L))) < oVar.f3153e) && this.f2143w != 3;
        if (z11) {
            c1.c cVarD = p5.f.d(0L, a.a.e((int) (j10 >> 32), (int) (j10 & 4294967295L)));
            oVarY.i();
            o.e(oVarY, cVarD);
        }
        try {
            e0 e0Var = this.f2140t.f3140a;
            n2.l lVar = e0Var.f3092m;
            if (lVar == null) {
                lVar = n2.l.f8663b;
            }
            n2.l lVar2 = lVar;
            d1.i0 i0Var3 = e0Var.f3093n;
            if (i0Var3 == null) {
                i0Var3 = d1.i0.f2997d;
            }
            d1.i0 i0Var4 = i0Var3;
            td.h hVar = e0Var.f3094o;
            if (hVar == null) {
                hVar = f1.f.f3864e;
            }
            td.h hVar2 = hVar;
            f0 f0VarB = e0Var.f3081a.b();
            if (f0VarB != null) {
                d2.o.a(oVar, oVarY, f0VarB, this.f2140t.f3140a.f3081a.c(), i0Var4, lVar2, hVar2);
            } else {
                long jB = p.f3024g;
                if (jB == 16) {
                    jB = this.f2140t.b() != 16 ? this.f2140t.b() : p.f3019b;
                }
                oVarY.i();
                ArrayList arrayList = oVar.f3156h;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    q qVar = (q) arrayList.get(i);
                    qVar.f3159a.e(oVarY, jB, i0Var4, lVar2, hVar2);
                    oVarY.n(0.0f, qVar.f3159a.b());
                }
                oVarY.o();
            }
            if (z11) {
                oVarY.o();
            }
            f fVar2 = this.G;
            if (!((fVar2 == null || !fVar2.f2135c) ? ac.a.z(this.f2139s) : false)) {
                List list = this.A;
                if (list != null && !list.isEmpty()) {
                    z10 = false;
                }
                if (z10) {
                    return;
                }
            }
            i0Var.b();
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    @Override // u1.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.g0 f(u1.o0 r20, s1.e0 r21, long r22) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.f(u1.o0, s1.e0, long):s1.g0");
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        g gVar = this.F;
        if (gVar == null) {
            gVar = new g(this, 0);
            this.F = gVar;
        }
        d2.g gVar2 = this.f2139s;
        fc.c[] cVarArr = a2.w.f144a;
        kVar.d(u.f141z, ac.a.E(gVar2));
        f fVar = this.G;
        if (fVar != null) {
            d2.g gVar3 = fVar.f2134b;
            x xVar = u.A;
            fc.c[] cVarArr2 = a2.w.f144a;
            fc.c cVar = cVarArr2[15];
            kVar.d(xVar, gVar3);
            boolean z10 = fVar.f2135c;
            x xVar2 = u.B;
            fc.c cVar2 = cVarArr2[16];
            kVar.d(xVar2, Boolean.valueOf(z10));
        }
        kVar.d(a2.j.f59k, new a2.a(null, new g(this, 1)));
        kVar.d(a2.j.f60l, new a2.a(null, new g(this, 2)));
        kVar.d(a2.j.f61m, new a2.a(null, new ad.l(this, 6)));
        kVar.d(a2.j.f50a, new a2.a(null, gVar));
    }
}

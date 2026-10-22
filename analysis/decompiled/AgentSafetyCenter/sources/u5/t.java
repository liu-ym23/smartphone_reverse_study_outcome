package u5;

import android.os.SystemClock;
import k0.g1;
import k0.h1;
import k0.k1;
import s1.v0;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends h1.b {
    public h1.b i;

    /* renamed from: j, reason: collision with root package name */
    public h1.b f14095j;

    /* renamed from: k, reason: collision with root package name */
    public s1.j f14096k;

    /* renamed from: l, reason: collision with root package name */
    public int f14097l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14098m;

    /* renamed from: n, reason: collision with root package name */
    public h1 f14099n;

    /* renamed from: o, reason: collision with root package name */
    public long f14100o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14101p;

    /* renamed from: q, reason: collision with root package name */
    public g1 f14102q;

    /* renamed from: r, reason: collision with root package name */
    public k1 f14103r;

    @Override // h1.b
    public final void d(float f5) {
        this.f14102q.h(f5);
    }

    @Override // h1.b
    public final void e(d1.l lVar) {
        this.f14103r.setValue(lVar);
    }

    @Override // h1.b
    public final long h() {
        h1.b bVar = this.i;
        long jH = bVar != null ? bVar.h() : 0L;
        h1.b bVar2 = this.f14095j;
        long jH2 = bVar2 != null ? bVar2.h() : 0L;
        boolean z10 = jH != 9205357640488583168L;
        boolean z11 = jH2 != 9205357640488583168L;
        if (z10 && z11) {
            return a.a.e(Math.max(c1.e.e(jH), c1.e.e(jH2)), Math.max(c1.e.c(jH), c1.e.c(jH2)));
        }
        return 9205357640488583168L;
    }

    @Override // h1.b
    public final void i(i0 i0Var) {
        h1 h1Var = this.f14099n;
        h1.b bVar = this.f14095j;
        g1 g1Var = this.f14102q;
        if (this.f14101p) {
            j(i0Var, bVar, g1Var.g());
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f14100o == -1) {
            this.f14100o = jUptimeMillis;
        }
        float f5 = (jUptimeMillis - this.f14100o) / this.f14097l;
        float fG = g1Var.g() * p5.f.p(f5, 0.0f, 1.0f);
        float fG2 = this.f14098m ? g1Var.g() - fG : g1Var.g();
        this.f14101p = f5 >= 1.0f;
        j(i0Var, this.i, fG2);
        j(i0Var, bVar, fG);
        if (this.f14101p) {
            this.i = null;
        } else {
            h1Var.h(h1Var.g() + 1);
        }
    }

    public final void j(i0 i0Var, h1.b bVar, float f5) {
        k1 k1Var = this.f14103r;
        f1.b bVar2 = i0Var.f13838c;
        if (bVar == null || f5 <= 0.0f) {
            return;
        }
        long jE = bVar2.e();
        long jH = bVar.h();
        long jL = (jH == 9205357640488583168L || c1.e.f(jH) || jE == 9205357640488583168L || c1.e.f(jE)) ? jE : v0.l(jH, this.f14096k.a(jH, jE));
        if (jE == 9205357640488583168L || c1.e.f(jE)) {
            bVar.g(i0Var, jL, f5, (d1.l) k1Var.getValue());
            return;
        }
        long j10 = jL;
        float f10 = 2;
        float fE = (c1.e.e(jE) - c1.e.e(j10)) / f10;
        float fC = (c1.e.c(jE) - c1.e.c(j10)) / f10;
        ((a1.g) bVar2.f3859f.f9741f).s(fE, fC, fE, fC);
        bVar.g(i0Var, j10, f5, (d1.l) k1Var.getValue());
        float f11 = -fE;
        float f12 = -fC;
        ((a1.g) bVar2.f3859f.f9741f).s(f11, f12, f11, f12);
    }
}

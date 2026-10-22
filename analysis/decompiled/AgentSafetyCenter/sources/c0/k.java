package c0;

import a2.u;
import a2.x;
import d1.f0;
import d1.o;
import d1.p;
import d2.e0;
import d2.l0;
import java.util.Map;
import u1.i0;
import u1.n;
import u1.v1;
import u1.w;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends l implements w, n, v1 {
    public e A;
    public j B;
    public i C;

    /* renamed from: s, reason: collision with root package name */
    public String f2153s;

    /* renamed from: t, reason: collision with root package name */
    public l0 f2154t;

    /* renamed from: u, reason: collision with root package name */
    public g2.d f2155u;

    /* renamed from: v, reason: collision with root package name */
    public int f2156v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2157w;

    /* renamed from: x, reason: collision with root package name */
    public int f2158x;

    /* renamed from: y, reason: collision with root package name */
    public int f2159y;

    /* renamed from: z, reason: collision with root package name */
    public Map f2160z;

    public final e B0() {
        if (this.A == null) {
            this.A = new e(this.f2153s, this.f2154t, this.f2155u, this.f2156v, this.f2157w, this.f2158x, this.f2159y);
        }
        e eVar = this.A;
        eVar.getClass();
        return eVar;
    }

    @Override // u1.n
    public final void b(i0 i0Var) {
        e eVarB0;
        if (!this.f15126r) {
            return;
        }
        i iVar = this.C;
        if (iVar == null || !iVar.f2149c || (eVarB0 = iVar.f2150d) == null) {
            eVarB0 = B0();
            eVarB0.b(i0Var);
        } else {
            eVarB0.b(i0Var);
        }
        d2.a aVar = eVarB0.f2126j;
        if (aVar == null) {
            StringBuilder sb2 = new StringBuilder("no paragraph (layoutCache=");
            sb2.append(this.A);
            i iVar2 = this.C;
            sb2.append(", textSubstitution=");
            sb2.append(iVar2);
            sb2.append(')');
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        o oVarY = i0Var.f13838c.f3859f.y();
        boolean z10 = eVarB0.f2127k;
        if (z10) {
            long j10 = eVarB0.f2128l;
            oVarY.i();
            oVarY.m(0.0f, 0.0f, (int) (j10 >> 32), (int) (j10 & 4294967295L), 1);
        }
        try {
            e0 e0Var = this.f2154t.f3140a;
            n2.l lVar = e0Var.f3092m;
            if (lVar == null) {
                lVar = n2.l.f8663b;
            }
            n2.l lVar2 = lVar;
            d1.i0 i0Var2 = e0Var.f3093n;
            if (i0Var2 == null) {
                i0Var2 = d1.i0.f2997d;
            }
            d1.i0 i0Var3 = i0Var2;
            td.h hVar = e0Var.f3094o;
            if (hVar == null) {
                hVar = f1.f.f3864e;
            }
            td.h hVar2 = hVar;
            f0 f0VarB = e0Var.f3081a.b();
            if (f0VarB != null) {
                aVar.f(oVarY, f0VarB, this.f2154t.f3140a.f3081a.c(), i0Var3, lVar2, hVar2);
            } else {
                long jB = p.f3024g;
                if (jB == 16) {
                    jB = this.f2154t.b() != 16 ? this.f2154t.b() : p.f3019b;
                }
                aVar.e(oVarY, jB, i0Var3, lVar2, hVar2);
            }
            if (z10) {
                oVarY.o();
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a2  */
    @Override // u1.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.g0 f(u1.o0 r23, s1.e0 r24, long r25) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.k.f(u1.o0, s1.e0, long):s1.g0");
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        j jVar = this.B;
        if (jVar == null) {
            jVar = new j(this, 0);
            this.B = jVar;
        }
        d2.g gVar = new d2.g(this.f2153s);
        fc.c[] cVarArr = a2.w.f144a;
        kVar.d(u.f141z, ac.a.E(gVar));
        i iVar = this.C;
        if (iVar != null) {
            boolean z10 = iVar.f2149c;
            x xVar = u.B;
            fc.c[] cVarArr2 = a2.w.f144a;
            fc.c cVar = cVarArr2[16];
            kVar.d(xVar, Boolean.valueOf(z10));
            d2.g gVar2 = new d2.g(iVar.f2148b);
            x xVar2 = u.A;
            fc.c cVar2 = cVarArr2[15];
            kVar.d(xVar2, gVar2);
        }
        kVar.d(a2.j.f59k, new a2.a(null, new j(this, 1)));
        kVar.d(a2.j.f60l, new a2.a(null, new j(this, 2)));
        kVar.d(a2.j.f61m, new a2.a(null, new ad.l(this, 7)));
        kVar.d(a2.j.f50a, new a2.a(null, jVar));
    }
}

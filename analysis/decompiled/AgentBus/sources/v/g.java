package v;

import i1.m;
import i1.s1;
import i1.v;
import java.util.Map;
import n0.l;
import p1.h;
import p1.i;
import p1.s;
import p1.u;
import q7.k;
import s1.a0;
import s1.h0;
import u0.b0;
import u0.z;
import w7.t;

/* loaded from: classes.dex */
public final class g extends l implements v, m, s1 {
    public Map A;
    public d B;
    public f C;
    public e D;

    /* renamed from: t, reason: collision with root package name */
    public String f10255t;

    /* renamed from: u, reason: collision with root package name */
    public h0 f10256u;

    /* renamed from: v, reason: collision with root package name */
    public v1.d f10257v;

    /* renamed from: w, reason: collision with root package name */
    public int f10258w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10259x;

    /* renamed from: y, reason: collision with root package name */
    public int f10260y;

    /* renamed from: z, reason: collision with root package name */
    public int f10261z;

    /* JADX WARN: Removed duplicated region for block: B:131:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0289  */
    @Override // i1.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i1.l0 G(i1.m0 r23, g1.o r24, long r25) {
        /*
            Method dump skipped, instructions count: 745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.g.G(i1.m0, g1.o, long):i1.l0");
    }

    @Override // i1.m
    public final void e(i1.h0 h0Var) {
        d dVarL0;
        if (!this.f6810s) {
            return;
        }
        e eVar = this.D;
        if (eVar == null || !eVar.f10251c || (dVarL0 = eVar.f10252d) == null) {
            dVarL0 = l0();
            dVarL0.b(h0Var);
        } else {
            dVarL0.b(h0Var);
        }
        s1.a aVar = dVarL0.f10242j;
        if (aVar == null) {
            throw new IllegalArgumentException(("no paragraph (layoutCache=" + this.B + ", textSubstitution=" + this.D + ')').toString());
        }
        u0.l lVarA = h0Var.f4489f.f10630g.a();
        boolean z4 = dVarL0.f10243k;
        if (z4) {
            long j2 = dVarL0.f10244l;
            lVarA.h();
            lVarA.e(0.0f, 0.0f, (int) (j2 >> 32), (int) (j2 & 4294967295L), 1);
        }
        try {
            a0 a0Var = this.f10256u.f9272a;
            c2.l lVar = a0Var.f9222m;
            if (lVar == null) {
                lVar = c2.l.f1875b;
            }
            b0 b0Var = a0Var.f9223n;
            if (b0Var == null) {
                b0Var = b0.f9889d;
            }
            w0.c cVar = a0Var.f9224o;
            if (cVar == null) {
                cVar = w0.f.f10635b;
            }
            z zVarB = a0Var.f9210a.b();
            if (zVarB != null) {
                float fC = this.f10256u.f9272a.f9210a.c();
                z1.e eVar2 = aVar.f9204a.f11764l;
                int i2 = eVar2.f11772c;
                eVar2.c(zVarB, (Float.floatToRawIntBits(aVar.b()) & 4294967295L) | (Float.floatToRawIntBits(aVar.c()) << 32), fC);
                eVar2.f(b0Var);
                eVar2.g(lVar);
                eVar2.e(cVar);
                eVar2.b(3);
                aVar.d(lVarA);
                eVar2.b(i2);
            } else {
                long jB = u0.m.f9916f;
                if (jB == 16) {
                    jB = this.f10256u.b() != 16 ? this.f10256u.b() : u0.m.f9912b;
                }
                z1.e eVar3 = aVar.f9204a.f11764l;
                int i10 = eVar3.f11772c;
                eVar3.d(jB);
                eVar3.f(b0Var);
                eVar3.g(lVar);
                eVar3.e(cVar);
                eVar3.b(3);
                aVar.d(lVarA);
                eVar3.b(i10);
            }
            if (z4) {
                lVarA.g();
            }
        } finally {
        }
    }

    public final d l0() {
        if (this.B == null) {
            this.B = new d(this.f10255t, this.f10256u, this.f10257v, this.f10258w, this.f10259x, this.f10260y, this.f10261z);
        }
        d dVar = this.B;
        k.b(dVar);
        return dVar;
    }

    @Override // i1.s1
    public final void u(i iVar) {
        f fVar = this.C;
        if (fVar == null) {
            fVar = new f(this, 0);
            this.C = fVar;
        }
        s1.e eVar = new s1.e(this.f10255t);
        t[] tVarArr = u.f8372a;
        iVar.i(s.f8368y, a.a.S(eVar));
        e eVar2 = this.D;
        if (eVar2 != null) {
            boolean z4 = eVar2.f10251c;
            p1.v vVar = s.A;
            t[] tVarArr2 = u.f8372a;
            t tVar = tVarArr2[16];
            vVar.a(iVar, Boolean.valueOf(z4));
            s1.e eVar3 = new s1.e(eVar2.f10250b);
            p1.v vVar2 = s.f8369z;
            t tVar2 = tVarArr2[15];
            vVar2.a(iVar, eVar3);
        }
        iVar.i(h.f8287j, new p1.a(null, new f(this, 1)));
        iVar.i(h.f8288k, new p1.a(null, new f(this, 2)));
        iVar.i(h.f8289l, new p1.a(null, new t9.h(3, this)));
        iVar.i(h.f8278a, new p1.a(null, fVar));
    }
}

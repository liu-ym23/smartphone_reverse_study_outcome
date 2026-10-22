package o;

import android.view.KeyEvent;
import i1.p1;
import i1.s1;
import i1.x1;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class r extends i1.k implements p1, a1.d, s0.d, s1, x1 {
    public static final q0 K = new q0();
    public final b0 A;
    public c1.x B;
    public i1.j C;
    public q.k D;
    public q.f E;
    public q.i H;
    public boolean I;
    public final q0 J;

    /* renamed from: v, reason: collision with root package name */
    public q.i f7118v;

    /* renamed from: w, reason: collision with root package name */
    public m0 f7119w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7120x;

    /* renamed from: y, reason: collision with root package name */
    public p7.a f7121y;

    /* renamed from: z, reason: collision with root package name */
    public final z f7122z = new z();
    public final LinkedHashMap F = new LinkedHashMap();
    public long G = 0;

    public r(q.i iVar, m0 m0Var, boolean z4, p7.a aVar) {
        this.f7118v = iVar;
        this.f7119w = m0Var;
        this.f7120x = z4;
        this.f7121y = aVar;
        this.A = new b0(iVar);
        q.i iVar2 = this.f7118v;
        this.H = iVar2;
        this.I = iVar2 == null && this.f7119w != null;
        this.J = K;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    @Override // a1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(android.view.KeyEvent r13) {
        /*
            r12 = this;
            r12.p0()
            boolean r0 = r12.f7120x
            r1 = 3
            r2 = 160(0xa0, float:2.24E-43)
            r3 = 66
            r4 = 23
            r5 = 32
            r6 = 0
            r7 = 1
            r8 = 0
            java.util.LinkedHashMap r9 = r12.F
            if (r0 == 0) goto L6a
            int r0 = o.s.f7126b
            int r0 = a.a.Q(r13)
            r10 = 2
            if (r0 != r10) goto L6a
            int r0 = r13.getKeyCode()
            long r10 = ib.c.a(r0)
            long r10 = r10 >> r5
            int r0 = (int) r10
            if (r0 == r4) goto L2f
            if (r0 == r3) goto L2f
            if (r0 == r2) goto L2f
            goto L6a
        L2f:
            int r0 = r13.getKeyCode()
            long r2 = ib.c.a(r0)
            a1.b r0 = new a1.b
            r0.<init>(r2)
            boolean r0 = r9.containsKey(r0)
            if (r0 != 0) goto Lb2
            q.k r0 = new q.k
            long r2 = r12.G
            r0.<init>(r2)
            int r13 = r13.getKeyCode()
            long r2 = ib.c.a(r13)
            a1.b r13 = new a1.b
            r13.<init>(r2)
            r9.put(r13, r0)
            q.i r13 = r12.f7118v
            if (r13 == 0) goto L69
            ia.b0 r13 = r12.Z()
            o.c r2 = new o.c
            r2.<init>(r12, r0, r8, r6)
            ia.d0.s(r13, r8, r8, r2, r1)
        L69:
            return r7
        L6a:
            boolean r0 = r12.f7120x
            if (r0 == 0) goto Lb2
            int r0 = o.s.f7126b
            int r0 = a.a.Q(r13)
            if (r0 != r7) goto Lb2
            int r0 = r13.getKeyCode()
            long r10 = ib.c.a(r0)
            long r10 = r10 >> r5
            int r0 = (int) r10
            if (r0 == r4) goto L87
            if (r0 == r3) goto L87
            if (r0 == r2) goto L87
            return r6
        L87:
            int r13 = r13.getKeyCode()
            long r2 = ib.c.a(r13)
            a1.b r13 = new a1.b
            r13.<init>(r2)
            java.lang.Object r13 = r9.remove(r13)
            q.k r13 = (q.k) r13
            if (r13 == 0) goto Lac
            q.i r0 = r12.f7118v
            if (r0 == 0) goto Lac
            ia.b0 r0 = r12.Z()
            o.c r2 = new o.c
            r2.<init>(r12, r13, r8, r7)
            ia.d0.s(r0, r8, r8, r2, r1)
        Lac:
            p7.a r12 = r12.f7121y
            r12.c()
            return r7
        Lb2:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o.r.B(android.view.KeyEvent):boolean");
    }

    @Override // i1.p1
    public final void C(c1.f fVar, c1.g gVar, long j2) {
        long j4 = ((j2 >> 33) << 32) | (((j2 << 32) >> 33) & 4294967295L);
        this.G = n7.b.b((int) (j4 >> 32), (int) (j4 & 4294967295L));
        p0();
        g7.d dVar = null;
        if (this.f7120x && gVar == c1.g.f1798g) {
            int i2 = fVar.f1796b;
            if (i2 == 4) {
                ia.d0.s(Z(), null, null, new d(this, dVar, 0), 3);
            } else if (i2 == 5) {
                ia.d0.s(Z(), null, null, new d(this, dVar, 1), 3);
            }
        }
        if (this.B == null) {
            a5.b bVar = new a5.b(this, dVar, 18);
            c1.f fVar2 = c1.t.f1840a;
            c1.x xVar = new c1.x(null, null, c1.u.f1841a);
            xVar.f1852v = bVar;
            l0(xVar);
            this.B = xVar;
        }
        c1.x xVar2 = this.B;
        if (xVar2 != null) {
            xVar2.C(fVar, gVar, j2);
        }
    }

    @Override // i1.p1
    public final void M() {
        q.f fVar;
        q.i iVar = this.f7118v;
        if (iVar != null && (fVar = this.E) != null) {
            iVar.b(new q.g(fVar));
        }
        this.E = null;
        c1.x xVar = this.B;
        if (xVar != null) {
            xVar.M();
        }
    }

    @Override // i1.s1
    public final boolean Q() {
        return true;
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // n0.l
    public final void d0() {
        if (!this.I) {
            p0();
        }
        if (this.f7120x) {
            l0(this.f7122z);
            l0(this.A);
        }
    }

    @Override // n0.l
    public final void e0() {
        o0();
        if (this.H == null) {
            this.f7118v = null;
        }
        i1.j jVar = this.C;
        if (jVar != null) {
            m0(jVar);
        }
        this.C = null;
    }

    @Override // s0.d
    public final void f(s0.p pVar) {
        if (pVar.a()) {
            p0();
        }
        if (this.f7120x) {
            this.A.f(pVar);
        }
    }

    @Override // a1.d
    public final boolean i(KeyEvent keyEvent) {
        return false;
    }

    @Override // i1.x1
    public final Object k() {
        return this.J;
    }

    public final void o0() {
        q.i iVar = this.f7118v;
        LinkedHashMap linkedHashMap = this.F;
        if (iVar != null) {
            q.k kVar = this.D;
            if (kVar != null) {
                iVar.b(new q.j(kVar));
            }
            q.f fVar = this.E;
            if (fVar != null) {
                iVar.b(new q.g(fVar));
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                iVar.b(new q.j((q.k) it.next()));
            }
        }
        this.D = null;
        this.E = null;
        linkedHashMap.clear();
    }

    public final void p0() {
        m0 m0Var;
        if (this.C == null && (m0Var = this.f7119w) != null) {
            if (this.f7118v == null) {
                this.f7118v = new q.i();
            }
            this.A.o0(this.f7118v);
            q.i iVar = this.f7118v;
            q7.k.b(iVar);
            i1.j jVarB = m0Var.b(iVar);
            l0(jVarB);
            this.C = jVarB;
        }
    }

    @Override // i1.s1
    public final void u(p1.i iVar) {
        a8.c cVar = new a8.c(16, this);
        w7.t[] tVarArr = p1.u.f8372a;
        iVar.i(p1.h.f8279b, new p1.a(null, cVar));
        if (this.f7120x) {
            this.A.u(iVar);
        } else {
            iVar.i(p1.s.f8352i, c7.r.f1986a);
        }
    }
}

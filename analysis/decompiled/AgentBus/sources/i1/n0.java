package i1;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class n0 extends m0 implements g1.o {

    /* renamed from: t, reason: collision with root package name */
    public final d1 f4544t;

    /* renamed from: v, reason: collision with root package name */
    public LinkedHashMap f4546v;

    /* renamed from: x, reason: collision with root package name */
    public l0 f4548x;

    /* renamed from: y, reason: collision with root package name */
    public final k.y f4549y;

    /* renamed from: u, reason: collision with root package name */
    public long f4545u = 0;

    /* renamed from: w, reason: collision with root package name */
    public final g1.n f4547w = new g1.n(this);

    public n0(d1 d1Var) {
        this.f4544t = d1Var;
        k.y yVar = k.e0.f5483a;
        this.f4549y = new k.y();
    }

    public static final void o0(n0 n0Var, l0 l0Var) {
        LinkedHashMap linkedHashMap;
        if (l0Var != null) {
            n0Var.N((l0Var.b() & 4294967295L) | (l0Var.d() << 32));
        } else {
            n0Var.N(0L);
        }
        if (!q7.k.a(n0Var.f4548x, l0Var) && l0Var != null && ((((linkedHashMap = n0Var.f4546v) != null && !linkedHashMap.isEmpty()) || !l0Var.a().isEmpty()) && !q7.k.a(l0Var.a(), n0Var.f4546v))) {
            r0 r0Var = n0Var.f4544t.f4437t.I.f4508p;
            q7.k.b(r0Var);
            r0Var.f4578v.f();
            LinkedHashMap linkedHashMap2 = n0Var.f4546v;
            if (linkedHashMap2 == null) {
                linkedHashMap2 = new LinkedHashMap();
                n0Var.f4546v = linkedHashMap2;
            }
            linkedHashMap2.clear();
            linkedHashMap2.putAll(l0Var.a());
        }
        n0Var.f4548x = l0Var;
    }

    @Override // g1.s
    public final void M(long j2, float f10, p7.k kVar) {
        q0(j2);
        if (this.f4531o) {
            return;
        }
        p0();
    }

    @Override // i1.m0
    public final m0 Z() {
        d1 d1Var = this.f4544t.f4438u;
        if (d1Var != null) {
            return d1Var.x0();
        }
        return null;
    }

    @Override // i1.m0
    public final g1.k a0() {
        return this.f4547w;
    }

    @Override // i1.m0
    public final boolean b0() {
        return this.f4548x != null;
    }

    @Override // d2.c
    public final float c() {
        return this.f4544t.c();
    }

    @Override // i1.m0
    public final d2.l c0() {
        return this.f4544t.f4437t.B;
    }

    @Override // i1.m0
    public final f0 d0() {
        return this.f4544t.f4437t;
    }

    @Override // i1.m0
    public final l0 e0() {
        l0 l0Var = this.f4548x;
        if (l0Var != null) {
            return l0Var;
        }
        throw m.x.i("LookaheadDelegate has not been measured yet when measureResult is requested.");
    }

    @Override // i1.m0
    public final m0 f0() {
        d1 d1Var = this.f4544t.f4439v;
        if (d1Var != null) {
            return d1Var.x0();
        }
        return null;
    }

    @Override // g1.s, g1.o
    public final Object g() {
        return this.f4544t.g();
    }

    @Override // i1.m0
    public final long g0() {
        return this.f4545u;
    }

    @Override // d2.c
    public final float j() {
        return this.f4544t.j();
    }

    @Override // i1.m0
    public final boolean j0() {
        return true;
    }

    @Override // i1.m0
    public final void n0() {
        M(this.f4545u, 0.0f, null);
    }

    public void p0() {
        e0().e();
    }

    public final void q0(long j2) {
        if (!d2.i.a(this.f4545u, j2)) {
            this.f4545u = j2;
            d1 d1Var = this.f4544t;
            r0 r0Var = d1Var.f4437t.I.f4508p;
            if (r0Var != null) {
                r0Var.T();
            }
            m0.i0(d1Var);
        }
        if (this.f4532p) {
            return;
        }
        V(e0());
    }

    public final long r0(n0 n0Var, boolean z4) {
        long jC = 0;
        while (!this.equals(n0Var)) {
            if (!this.f4530n || !z4) {
                jC = d2.i.c(jC, this.f4545u);
            }
            d1 d1Var = this.f4544t.f4439v;
            q7.k.b(d1Var);
            this = d1Var.x0();
            q7.k.b(this);
        }
        return jC;
    }
}

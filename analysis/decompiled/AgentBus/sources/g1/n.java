package g1;

import i1.d1;
import i1.n0;

/* loaded from: classes.dex */
public final class n implements k {

    /* renamed from: f, reason: collision with root package name */
    public final n0 f3753f;

    public n(n0 n0Var) {
        this.f3753f = n0Var;
    }

    @Override // g1.k
    public final t0.c B(k kVar, boolean z4) {
        return this.f3753f.f4544t.B(kVar, z4);
    }

    @Override // g1.k
    public final long a(long j2) {
        return this.f3753f.f4544t.a(t0.b.g(0L, b()));
    }

    public final long b() {
        n0 n0Var = this.f3753f;
        n0 n0VarW = s7.a.w(n0Var);
        return t0.b.f(c(n0VarW.f4547w, 0L), n0Var.f4544t.I0(n0VarW.f4544t, 0L));
    }

    public final long c(k kVar, long j2) {
        boolean z4 = kVar instanceof n;
        n0 n0Var = this.f3753f;
        if (!z4) {
            n0 n0VarW = s7.a.w(n0Var);
            d1 d1Var = n0VarW.f4544t;
            long jC = c(n0VarW.f4547w, j2);
            float f10 = (int) (n0VarW.f4545u & 4294967295L);
            long jF = t0.b.f(jC, (4294967295L & Float.floatToRawIntBits(f10)) | (Float.floatToRawIntBits((int) (r5 >> 32)) << 32));
            if (!d1Var.z0().f6810s) {
                f1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
            }
            d1Var.K0();
            d1 d1Var2 = d1Var.f4439v;
            if (d1Var2 != null) {
                d1Var = d1Var2;
            }
            return t0.b.g(jF, d1Var.I0(kVar, 0L));
        }
        n0 n0Var2 = ((n) kVar).f3753f;
        d1 d1Var3 = n0Var2.f4544t;
        d1Var3.K0();
        n0 n0VarX0 = n0Var.f4544t.v0(d1Var3).x0();
        if (n0VarX0 != null) {
            long jB = d2.i.b(d2.i.c(n0Var2.r0(n0VarX0, false), a.a.i0(j2)), n0Var.r0(n0VarX0, false));
            return (Float.floatToRawIntBits((int) (jB >> 32)) << 32) | (Float.floatToRawIntBits((int) (jB & 4294967295L)) & 4294967295L);
        }
        n0 n0VarW2 = s7.a.w(n0Var2);
        long jC2 = d2.i.c(d2.i.c(n0Var2.r0(n0VarW2, false), n0VarW2.f4545u), a.a.i0(j2));
        n0 n0VarW3 = s7.a.w(n0Var);
        long jB2 = d2.i.b(jC2, d2.i.c(n0Var.r0(n0VarW3, false), n0VarW3.f4545u));
        long jFloatToRawIntBits = Float.floatToRawIntBits((int) (jB2 >> 32));
        long jFloatToRawIntBits2 = Float.floatToRawIntBits((int) (jB2 & 4294967295L)) & 4294967295L;
        d1 d1Var4 = n0VarW3.f4544t.f4439v;
        q7.k.b(d1Var4);
        d1 d1Var5 = n0VarW2.f4544t.f4439v;
        q7.k.b(d1Var5);
        return d1Var4.I0(d1Var5, jFloatToRawIntBits2 | (jFloatToRawIntBits << 32));
    }

    @Override // g1.k
    public final long e(k kVar, long j2) {
        return c(kVar, j2);
    }

    @Override // g1.k
    public final long f(long j2) {
        return this.f3753f.f4544t.f(t0.b.g(j2, b()));
    }

    @Override // g1.k
    public final k h() {
        n0 n0VarX0;
        if (!v()) {
            f1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        d1 d1Var = ((d1) this.f3753f.f4544t.f4437t.H.f4402h).f4439v;
        if (d1Var == null || (n0VarX0 = d1Var.x0()) == null) {
            return null;
        }
        return n0VarX0.f4547w;
    }

    @Override // g1.k
    public final boolean v() {
        return this.f3753f.f4544t.z0().f6810s;
    }

    @Override // g1.k
    public final long x() {
        n0 n0Var = this.f3753f;
        return (n0Var.f3756f << 32) | (n0Var.f3757g & 4294967295L);
    }
}

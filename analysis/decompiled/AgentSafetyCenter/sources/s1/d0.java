package s1;

import u1.g1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 implements q {

    /* renamed from: c, reason: collision with root package name */
    public u1.p0 f11232c;

    @Override // s1.q
    public final long B(q qVar, long j10) {
        return b(qVar, j10);
    }

    @Override // s1.q
    public final long D(long j10) {
        return this.f11232c.f13889s.D(c1.b.h(0L, a()));
    }

    public final long a() {
        u1.p0 p0Var = this.f11232c;
        u1.p0 p0VarJ = v0.j(p0Var);
        return c1.b.g(b(p0VarJ.f13892v, 0L), p0Var.f13889s.Q0(p0VarJ.f13889s, 0L));
    }

    public final long b(q qVar, long j10) {
        u1.p0 p0Var = this.f11232c;
        if (!(qVar instanceof d0)) {
            u1.p0 p0VarJ = v0.j(p0Var);
            g1 g1Var = p0VarJ.f13889s;
            long jB = b(p0VarJ.f13892v, j10);
            float f5 = (int) (p0VarJ.f13890t & 4294967295L);
            long jG = c1.b.g(jB, (4294967295L & Float.floatToRawIntBits(f5)) | (Float.floatToRawIntBits((int) (r5 >> 32)) << 32));
            if (!g1Var.H0().f15126r) {
                r1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
            }
            g1Var.R0();
            g1 g1Var2 = g1Var.f13812u;
            if (g1Var2 != null) {
                g1Var = g1Var2;
            }
            return c1.b.h(jG, g1Var.Q0(qVar, 0L));
        }
        u1.p0 p0Var2 = ((d0) qVar).f11232c;
        g1 g1Var3 = p0Var2.f13889s;
        g1Var3.R0();
        u1.p0 p0VarF0 = p0Var.f13889s.D0(g1Var3).F0();
        if (p0VarF0 != null) {
            long jC = o2.i.c(o2.i.d(p0Var2.z0(p0VarF0, false), td.h.H(j10)), p0Var.z0(p0VarF0, false));
            return (Float.floatToRawIntBits((int) (jC >> 32)) << 32) | (Float.floatToRawIntBits((int) (jC & 4294967295L)) & 4294967295L);
        }
        u1.p0 p0VarJ2 = v0.j(p0Var2);
        long jD = o2.i.d(o2.i.d(p0Var2.z0(p0VarJ2, false), p0VarJ2.f13890t), td.h.H(j10));
        u1.p0 p0VarJ3 = v0.j(p0Var);
        long jC2 = o2.i.c(jD, o2.i.d(p0Var.z0(p0VarJ3, false), p0VarJ3.f13890t));
        long jFloatToRawIntBits = Float.floatToRawIntBits((int) (jC2 >> 32));
        long jFloatToRawIntBits2 = Float.floatToRawIntBits((int) (jC2 & 4294967295L)) & 4294967295L;
        g1 g1Var4 = p0VarJ3.f13889s.f13812u;
        g1Var4.getClass();
        g1 g1Var5 = p0VarJ2.f13889s.f13812u;
        g1Var5.getClass();
        return g1Var4.Q0(g1Var5, jFloatToRawIntBits2 | (jFloatToRawIntBits << 32));
    }

    @Override // s1.q
    public final long c(long j10) {
        return this.f11232c.f13889s.c(c1.b.h(j10, a()));
    }

    @Override // s1.q
    public final c1.c g(q qVar, boolean z10) {
        return this.f11232c.f13889s.g(qVar, z10);
    }

    @Override // s1.q
    public final boolean k() {
        return this.f11232c.f13889s.H0().f15126r;
    }

    @Override // s1.q
    public final long l() {
        u1.p0 p0Var = this.f11232c;
        return (p0Var.f11277c << 32) | (p0Var.f11278f & 4294967295L);
    }

    @Override // s1.q
    public final long m(long j10) {
        return this.f11232c.f13889s.m(c1.b.h(0L, a()));
    }

    @Override // s1.q
    public final q w() {
        u1.p0 p0VarF0;
        if (!k()) {
            r1.a.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        g1 g1Var = this.f11232c.f13889s.f13810s.H.f13744d.f13812u;
        if (g1Var == null || (p0VarF0 = g1Var.F0()) == null) {
            return null;
        }
        return p0VarF0.f13892v;
    }
}

package u1;

import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class p0 extends o0 implements s1.e0 {

    /* renamed from: s, reason: collision with root package name */
    public final g1 f13889s;

    /* renamed from: t, reason: collision with root package name */
    public long f13890t = 0;

    /* renamed from: u, reason: collision with root package name */
    public LinkedHashMap f13891u;

    /* renamed from: v, reason: collision with root package name */
    public final s1.d0 f13892v;

    /* renamed from: w, reason: collision with root package name */
    public s1.g0 f13893w;

    /* renamed from: x, reason: collision with root package name */
    public final p.z f13894x;

    public p0(g1 g1Var) {
        this.f13889s = g1Var;
        s1.d0 d0Var = new s1.d0();
        d0Var.f11232c = this;
        VarHandle.storeStoreFence();
        this.f13892v = d0Var;
        p.z zVar = p.j0.f9585a;
        this.f13894x = new p.z();
    }

    public static final void w0(p0 p0Var, s1.g0 g0Var) {
        LinkedHashMap linkedHashMap;
        if (g0Var != null) {
            p0Var.S((g0Var.d() & 4294967295L) | (g0Var.e() << 32));
        } else {
            p0Var.S(0L);
        }
        if (!yb.k.a(p0Var.f13893w, g0Var) && g0Var != null && ((((linkedHashMap = p0Var.f13891u) != null && !linkedHashMap.isEmpty()) || !g0Var.b().isEmpty()) && !yb.k.a(g0Var.b(), p0Var.f13891u))) {
            t0 t0Var = p0Var.f13889s.f13810s.I.f13858q;
            t0Var.getClass();
            t0Var.f13933v.f();
            LinkedHashMap linkedHashMap2 = p0Var.f13891u;
            if (linkedHashMap2 == null) {
                linkedHashMap2 = new LinkedHashMap();
                p0Var.f13891u = linkedHashMap2;
            }
            linkedHashMap2.clear();
            linkedHashMap2.putAll(g0Var.b());
        }
        p0Var.f13893w = g0Var;
    }

    @Override // s1.o0
    public final void R(long j10, float f5, xb.l lVar) {
        y0(j10);
        if (this.f13881n) {
            return;
        }
        x0();
    }

    @Override // o2.c
    public final float T() {
        return this.f13889s.T();
    }

    @Override // u1.o0, s1.h0
    public final boolean V() {
        return true;
    }

    @Override // o2.c
    public final float a() {
        return this.f13889s.a();
    }

    @Override // u1.o0
    public final o0 f0() {
        g1 g1Var = this.f13889s.f13811t;
        if (g1Var != null) {
            return g1Var.F0();
        }
        return null;
    }

    @Override // s1.h0
    public final o2.l getLayoutDirection() {
        return this.f13889s.f13810s.B;
    }

    @Override // u1.o0
    public final s1.q h0() {
        return this.f13892v;
    }

    @Override // u1.o0
    public final boolean l0() {
        return this.f13893w != null;
    }

    @Override // u1.o0
    public final g0 o0() {
        return this.f13889s.f13810s;
    }

    @Override // u1.o0
    public final s1.g0 p0() {
        s1.g0 g0Var = this.f13893w;
        if (g0Var != null) {
            return g0Var;
        }
        throw w2.c.a("LookaheadDelegate has not been measured yet when measureResult is requested.");
    }

    @Override // u1.o0
    public final o0 q0() {
        g1 g1Var = this.f13889s.f13812u;
        if (g1Var != null) {
            return g1Var.F0();
        }
        return null;
    }

    @Override // u1.o0
    public final long r0() {
        return this.f13890t;
    }

    @Override // s1.o0, s1.e0
    public final Object v() {
        return this.f13889s.v();
    }

    @Override // u1.o0
    public final void v0() {
        R(this.f13890t, 0.0f, null);
    }

    public void x0() {
        p0().c();
    }

    public final void y0(long j10) {
        if (!o2.i.b(this.f13890t, j10)) {
            this.f13890t = j10;
            g1 g1Var = this.f13889s;
            t0 t0Var = g1Var.f13810s.I.f13858q;
            if (t0Var != null) {
                t0Var.c0();
            }
            o0.t0(g1Var);
        }
        if (this.f13882o) {
            return;
        }
        d0(p0());
    }

    public final long z0(p0 p0Var, boolean z10) {
        long jD = 0;
        while (!this.equals(p0Var)) {
            if (!this.f13880m || !z10) {
                jD = o2.i.d(jD, this.f13890t);
            }
            g1 g1Var = this.f13889s.f13812u;
            g1Var.getClass();
            this = g1Var.F0();
            this.getClass();
        }
        return jD;
    }
}

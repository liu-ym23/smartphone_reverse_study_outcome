package z7;

import java.util.Collection;

/* loaded from: classes.dex */
public final class s0 extends e0 {

    /* renamed from: g, reason: collision with root package name */
    public final Class f11952g;

    /* renamed from: h, reason: collision with root package name */
    public final r1 f11953h;

    public s0(Class cls) {
        q7.k.e(cls, "jClass");
        this.f11952g = cls;
        this.f11953h = new r1(new n0(this, 1));
    }

    @Override // z7.e0
    public final Class B() {
        r1 r1Var = ((q0) this.f11953h.c()).f11939e;
        w7.t tVar = q0.f11936g[2];
        Class cls = (Class) r1Var.c();
        return cls == null ? this.f11952g : cls;
    }

    @Override // z7.e0
    public final Collection C(e9.f fVar) {
        q1 q1Var = ((q0) this.f11953h.c()).f11938d;
        w7.t tVar = q0.f11936g[1];
        Object objC = q1Var.c();
        q7.k.d(objC, "<get-scope>(...)");
        return ((o9.n) objC).a(fVar, n8.c.f6878g);
    }

    @Override // q7.d
    public final Class c() {
        return this.f11952g;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s0) {
            return q7.k.a(this.f11952g, ((s0) obj).f11952g);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11952g.hashCode();
    }

    public final String toString() {
        return "file class " + l8.d.a(this.f11952g).b();
    }

    @Override // z7.e0
    public final Collection x() {
        return d7.z.f2978f;
    }

    @Override // z7.e0
    public final Collection y(e9.f fVar) {
        q1 q1Var = ((q0) this.f11953h.c()).f11938d;
        w7.t tVar = q0.f11936g[1];
        Object objC = q1Var.c();
        q7.k.d(objC, "<get-scope>(...)");
        return ((o9.n) objC).f(fVar, n8.c.f6878g);
    }

    @Override // z7.e0
    public final f8.l0 z(int i2) {
        r1 r1Var = ((q0) this.f11953h.c()).f11940f;
        w7.t tVar = q0.f11936g[3];
        c7.p pVar = (c7.p) r1Var.c();
        if (pVar == null) {
            return null;
        }
        d9.g gVar = (d9.g) pVar.f1982f;
        z8.b0 b0Var = (z8.b0) pVar.f1983g;
        d9.f fVar = (d9.f) pVar.f1984h;
        f9.n nVar = c9.l.f2175n;
        q7.k.d(nVar, "packageLocalVariable");
        z8.f0 f0Var = (z8.f0) w7.e0.B(b0Var, nVar, i2);
        if (f0Var == null) {
            return null;
        }
        z8.v0 v0Var = b0Var.f12041l;
        q7.k.d(v0Var, "packageProto.typeTable");
        return (f8.l0) x1.f(this.f11952g, f0Var, gVar, new b9.g(v0Var), fVar, r0.f11945n);
    }
}

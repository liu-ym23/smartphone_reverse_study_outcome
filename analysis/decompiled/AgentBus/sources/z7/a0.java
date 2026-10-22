package z7;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class a0 extends e0 implements w7.d, b0, o1 {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f11831i = 0;

    /* renamed from: g, reason: collision with root package name */
    public final Class f11832g;

    /* renamed from: h, reason: collision with root package name */
    public final r1 f11833h;

    public a0(Class cls) {
        q7.k.e(cls, "jClass");
        this.f11832g = cls;
        this.f11833h = new r1(new u(this, 8));
    }

    @Override // z7.e0
    public final Collection C(e9.f fVar) {
        o9.n nVarV0 = a().k().v0();
        n8.c cVar = n8.c.f6878g;
        Collection collectionA = nVarV0.a(fVar, cVar);
        o9.n nVarL0 = a().l0();
        q7.k.d(nVarL0, "descriptor.staticScope");
        return d7.r.c1(collectionA, nVarL0.a(fVar, cVar));
    }

    public final e9.b H() {
        c8.j jVarD;
        e9.b bVar = v1.f11972a;
        Class cls = this.f11832g;
        q7.k.e(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            q7.k.d(componentType, "klass.componentType");
            jVarD = componentType.isPrimitive() ? m9.c.b(componentType.getSimpleName()).d() : null;
            return jVarD != null ? new e9.b(c8.n.f2066k, jVarD.f2017g) : e9.b.j(c8.m.f2036g.g());
        }
        if (cls.equals(Void.TYPE)) {
            return v1.f11972a;
        }
        jVarD = cls.isPrimitive() ? m9.c.b(cls.getSimpleName()).d() : null;
        if (jVarD != null) {
            return new e9.b(c8.n.f2066k, jVarD.f2016f);
        }
        e9.b bVarA = l8.d.a(cls);
        if (!bVarA.f3186c) {
            String str = e8.d.f3123a;
            e9.b bVar2 = (e9.b) e8.d.f3130h.get(bVarA.b().i());
            if (bVar2 != null) {
                return bVar2;
            }
        }
        return bVarA;
    }

    @Override // z7.b0
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final f8.e a() {
        return ((x) this.f11833h.c()).a();
    }

    @Override // q7.d
    public final Class c() {
        return this.f11832g;
    }

    @Override // w7.d
    public final String d() {
        q1 q1Var = ((x) this.f11833h.c()).f11979e;
        w7.t tVar = x.f11976n[3];
        return (String) q1Var.c();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a0) && nb.i.u(this).equals(nb.i.u((w7.d) obj));
    }

    public final int hashCode() {
        return nb.i.u(this).hashCode();
    }

    @Override // w7.d
    public final boolean i() {
        return a().i() == 2;
    }

    @Override // w7.d
    public final boolean l() {
        return a().l();
    }

    @Override // w7.d
    public final boolean m() {
        return a().m();
    }

    @Override // w7.d
    public final boolean r(Object obj) {
        List list = l8.d.f5857a;
        Class cls = this.f11832g;
        q7.k.e(cls, "<this>");
        Integer num = (Integer) l8.d.f5860d.get(cls);
        if (num != null) {
            return q7.z.d(num.intValue(), obj);
        }
        Class cls2 = (Class) l8.d.f5859c.get(cls);
        if (cls2 != null) {
            cls = cls2;
        }
        return cls.isInstance(obj);
    }

    @Override // w7.d
    public final boolean s() {
        return a().i() == 4;
    }

    @Override // w7.d
    public final String t() {
        q1 q1Var = ((x) this.f11833h.c()).f11978d;
        w7.t tVar = x.f11976n[2];
        return (String) q1Var.c();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("class ");
        e9.b bVarH = H();
        e9.c cVarG = bVarH.g();
        q7.k.d(cVarG, "classId.packageFqName");
        String strConcat = cVarG.d() ? "" : cVarG.b().concat(".");
        sb2.append(strConcat + ga.r.d0(bVarH.h().b(), '.', '$'));
        return sb2.toString();
    }

    @Override // w7.d
    public final Object v() {
        r1 r1Var = ((x) this.f11833h.c()).f11981g;
        w7.t tVar = x.f11976n[6];
        return r1Var.c();
    }

    @Override // w7.b
    public final List w() {
        throw null;
    }

    @Override // z7.e0
    public final Collection x() {
        f8.e eVarA = a();
        if (eVarA.B() == 2 || eVarA.B() == 6) {
            return d7.z.f2978f;
        }
        Collection collectionE = eVarA.E();
        q7.k.d(collectionE, "descriptor.constructors");
        return collectionE;
    }

    @Override // z7.e0
    public final Collection y(e9.f fVar) {
        o9.n nVarV0 = a().k().v0();
        n8.c cVar = n8.c.f6878g;
        Collection collectionF = nVarV0.f(fVar, cVar);
        o9.n nVarL0 = a().l0();
        q7.k.d(nVarL0, "descriptor.staticScope");
        return d7.r.c1(collectionF, nVarL0.f(fVar, cVar));
    }

    @Override // z7.e0
    public final f8.l0 z(int i2) {
        Class<?> declaringClass;
        Class cls = this.f11832g;
        if (cls.getSimpleName().equals("DefaultImpls") && (declaringClass = cls.getDeclaringClass()) != null && declaringClass.isInterface()) {
            return ((a0) nb.i.x(declaringClass)).z(i2);
        }
        f8.e eVarA = a();
        t9.i iVar = eVarA instanceof t9.i ? (t9.i) eVarA : null;
        if (iVar != null) {
            z8.i iVar2 = iVar.f9802j;
            f9.n nVar = c9.l.f2171j;
            q7.k.d(nVar, "classLocalVariable");
            z8.f0 f0Var = (z8.f0) w7.e0.B(iVar2, nVar, i2);
            if (f0Var != null) {
                r9.k kVar = iVar.f9809q;
                return (f8.l0) x1.f(this.f11832g, f0Var, (b9.f) kVar.f9071g, (b9.g) kVar.f9073i, iVar.f9803k, z.f11993n);
            }
        }
        return null;
    }
}

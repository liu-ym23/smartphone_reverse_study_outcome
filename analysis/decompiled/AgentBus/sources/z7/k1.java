package z7;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* loaded from: classes.dex */
public abstract class k1 extends s implements w7.t {

    /* renamed from: p, reason: collision with root package name */
    public static final Object f11893p = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final e0 f11894j;

    /* renamed from: k, reason: collision with root package name */
    public final String f11895k;

    /* renamed from: l, reason: collision with root package name */
    public final String f11896l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f11897m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f11898n;

    /* renamed from: o, reason: collision with root package name */
    public final q1 f11899o;

    public k1(e0 e0Var, String str, String str2, f8.l0 l0Var, Object obj) {
        this.f11894j = e0Var;
        this.f11895k = str;
        this.f11896l = str2;
        this.f11897m = obj;
        this.f11898n = s7.a.G(c7.h.f1970f, new j1(this, 1));
        this.f11899o = s1.l(l0Var, new j1(this, 0));
    }

    @Override // z7.s
    public final a8.h A() {
        G().getClass();
        return null;
    }

    @Override // z7.s
    public final boolean D() {
        return !q7.k.a(this.f11897m, q7.b.f8796f);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [c7.f, java.lang.Object] */
    public final Member E() {
        if (!B().b0()) {
            return null;
        }
        e9.b bVar = v1.f11972a;
        s1 s1VarB = v1.b(B());
        if (s1VarB instanceof n) {
            n nVar = (n) s1VarB;
            b9.f fVar = nVar.f11915j;
            c9.f fVar2 = nVar.f11914i;
            if ((fVar2.f2117g & 16) == 16) {
                c9.d dVar = fVar2.f2122l;
                int i2 = dVar.f2103g;
                if ((i2 & 1) != 1 || (i2 & 2) != 2) {
                    return null;
                }
                return this.f11894j.u(fVar.getString(dVar.f2104h), fVar.getString(dVar.f2105i));
            }
        }
        return (Field) this.f11898n.getValue();
    }

    @Override // z7.s
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final f8.l0 B() {
        Object objC = this.f11899o.c();
        q7.k.d(objC, "_descriptor()");
        return (f8.l0) objC;
    }

    public abstract g1 G();

    public final boolean equals(Object obj) {
        k1 k1VarC = x1.c(obj);
        return k1VarC != null && q7.k.a(this.f11894j, k1VarC.f11894j) && q7.k.a(this.f11895k, k1VarC.f11895k) && q7.k.a(this.f11896l, k1VarC.f11896l) && q7.k.a(this.f11897m, k1VarC.f11897m);
    }

    @Override // w7.c
    public final String getName() {
        return this.f11895k;
    }

    public final int hashCode() {
        return this.f11896l.hashCode() + m.x.g(this.f11895k, this.f11894j.hashCode() * 31, 31);
    }

    @Override // w7.c
    public final boolean o() {
        return false;
    }

    public final String toString() {
        g9.g gVar = u1.f11967a;
        return u1.c(B());
    }

    @Override // z7.s
    public final a8.h y() {
        return G().y();
    }

    @Override // z7.s
    public final e0 z() {
        return this.f11894j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k1(e0 e0Var, String str, String str2, Object obj) {
        this(e0Var, str, str2, null, obj);
        q7.k.e(str, "name");
        q7.k.e(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k1(e0 e0Var, f8.l0 l0Var) {
        q7.k.e(l0Var, "descriptor");
        String strB = l0Var.getName().b();
        q7.k.d(strB, "descriptor.name.asString()");
        this(e0Var, strB, v1.b(l0Var).f(), l0Var, q7.b.f8796f);
    }
}

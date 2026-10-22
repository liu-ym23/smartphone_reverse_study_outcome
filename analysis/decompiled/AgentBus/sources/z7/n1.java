package z7;

/* loaded from: classes.dex */
public final class n1 implements w7.v, b0 {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f11920i;

    /* renamed from: f, reason: collision with root package name */
    public final f8.q0 f11921f;

    /* renamed from: g, reason: collision with root package name */
    public final q1 f11922g = s1.l(null, new t9.h(19, this));

    /* renamed from: h, reason: collision with root package name */
    public final o1 f11923h;

    static {
        q7.x xVar = q7.w.f8821a;
        f11920i = new w7.t[]{xVar.f(new q7.p(xVar.b(n1.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }

    public n1(o1 o1Var, f8.q0 q0Var) {
        Class cls;
        a0 a0VarC;
        Object objP;
        this.f11921f = q0Var;
        if (o1Var == null) {
            f8.j jVarP = q0Var.p();
            q7.k.d(jVarP, "descriptor.containingDeclaration");
            if (jVarP instanceof f8.e) {
                objP = c((f8.e) jVarP);
            } else {
                if (!(jVarP instanceof f8.c)) {
                    throw new c7.i("Unknown type parameter container: " + jVarP, 3);
                }
                f8.j jVarP2 = ((f8.c) jVarP).p();
                q7.k.d(jVarP2, "declaration.containingDeclaration");
                if (jVarP2 instanceof f8.e) {
                    a0VarC = c((f8.e) jVarP2);
                } else {
                    t9.k kVar = jVarP instanceof t9.k ? (t9.k) jVarP : null;
                    if (kVar == null) {
                        throw new c7.i("Non-class callable descriptor must be deserialized: " + jVarP, 3);
                    }
                    t9.j jVarU = kVar.u();
                    x8.f fVar = jVarU instanceof x8.f ? (x8.f) jVarU : null;
                    k8.c cVar = fVar != null ? fVar.f11260h : null;
                    k8.c cVar2 = cVar instanceof k8.c ? cVar : null;
                    if (cVar2 == null || (cls = cVar2.f5652a) == null) {
                        throw new c7.i("Container of deserialized member is not resolved: " + kVar, 3);
                    }
                    a0VarC = (a0) nb.i.x(cls);
                }
                objP = jVarP.P(new o4.d0(24, a0VarC), c7.r.f1986a);
            }
            q7.k.d(objP, "when (val declaration = … $declaration\")\n        }");
            o1Var = (o1) objP;
        }
        this.f11923h = o1Var;
    }

    public static a0 c(f8.e eVar) {
        Class clsJ = x1.j(eVar);
        a0 a0Var = (a0) (clsJ != null ? nb.i.x(clsJ) : null);
        if (a0Var != null) {
            return a0Var;
        }
        throw new c7.i("Type parameter container is not resolved: " + eVar.p(), 3);
    }

    @Override // z7.b0
    public final f8.g a() {
        return this.f11921f;
    }

    public final String b() {
        String strB = this.f11921f.getName().b();
        q7.k.d(strB, "descriptor.name.asString()");
        return strB;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return q7.k.a(this.f11923h, n1Var.f11923h) && b().equals(n1Var.b());
    }

    public final int hashCode() {
        return b().hashCode() + (this.f11923h.hashCode() * 31);
    }

    public final String toString() {
        w7.y yVar;
        StringBuilder sb2 = new StringBuilder();
        int iD = n.f.d(this.f11921f.a0());
        if (iD == 0) {
            yVar = w7.y.f10877f;
        } else if (iD == 1) {
            yVar = w7.y.f10878g;
        } else {
            if (iD != 2) {
                throw new a4.u();
            }
            yVar = w7.y.f10879h;
        }
        int iOrdinal = yVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                sb2.append("in ");
            } else {
                if (iOrdinal != 2) {
                    throw new a4.u();
                }
                sb2.append("out ");
            }
        }
        sb2.append(b());
        return sb2.toString();
    }
}

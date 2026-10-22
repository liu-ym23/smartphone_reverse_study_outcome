package z7;

import java.lang.reflect.Array;
import java.util.List;

/* loaded from: classes.dex */
public final class m1 implements q7.l {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f11907j;

    /* renamed from: f, reason: collision with root package name */
    public final v9.v f11908f;

    /* renamed from: g, reason: collision with root package name */
    public final q1 f11909g;

    /* renamed from: h, reason: collision with root package name */
    public final q1 f11910h;

    /* renamed from: i, reason: collision with root package name */
    public final q1 f11911i;

    static {
        q7.x xVar = q7.w.f8821a;
        f11907j = new w7.t[]{xVar.f(new q7.p(xVar.b(m1.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), xVar.f(new q7.p(xVar.b(m1.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public m1(v9.v vVar, p7.a aVar) {
        q7.k.e(vVar, "type");
        this.f11908f = vVar;
        q1 q1Var = aVar instanceof q1 ? (q1) aVar : null;
        this.f11909g = q1Var == null ? aVar != null ? s1.l(null, aVar) : null : q1Var;
        this.f11910h = s1.l(null, new l1(this, 1));
        this.f11911i = s1.l(null, new a8.e(24, this, aVar));
    }

    public final w7.e a(v9.v vVar) {
        v9.v vVarB;
        f8.g gVarC = vVar.E0().c();
        if (gVarC instanceof f8.e) {
            Class clsJ = x1.j((f8.e) gVarC);
            if (clsJ != null) {
                if (!clsJ.isArray()) {
                    if (v9.x0.e(vVar)) {
                        return new a0(clsJ);
                    }
                    Class cls = (Class) l8.d.f5858b.get(clsJ);
                    if (cls != null) {
                        clsJ = cls;
                    }
                    return new a0(clsJ);
                }
                v9.p0 p0Var = (v9.p0) d7.r.h1(vVar.C0());
                if (p0Var == null || (vVarB = p0Var.b()) == null) {
                    return new a0(clsJ);
                }
                w7.e eVarA = a(vVarB);
                if (eVarA != null) {
                    return new a0(Array.newInstance((Class<?>) nb.i.t(n7.b.m(eVarA)), 0).getClass());
                }
                throw new c7.i("Cannot determine classifier for array element type: " + this, 3);
            }
        } else {
            if (gVarC instanceof f8.q0) {
                return new n1(null, (f8.q0) gVarC);
            }
            if (gVarC instanceof t9.s) {
                throw new c7.i("An operation is not implemented: Type alias classifiers are not yet supported");
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return q7.k.a(this.f11908f, m1Var.f11908f) && q7.k.a(q(), m1Var.q()) && k().equals(m1Var.k());
    }

    public final int hashCode() {
        int iHashCode = this.f11908f.hashCode() * 31;
        w7.e eVarQ = q();
        return k().hashCode() + ((iHashCode + (eVarQ != null ? eVarQ.hashCode() : 0)) * 31);
    }

    @Override // w7.u
    public final List k() {
        w7.t tVar = f11907j[1];
        Object objC = this.f11911i.c();
        q7.k.d(objC, "<get-arguments>(...)");
        return (List) objC;
    }

    @Override // w7.u
    public final boolean p() {
        return this.f11908f.F0();
    }

    @Override // w7.u
    public final w7.e q() {
        w7.t tVar = f11907j[0];
        return (w7.e) this.f11910h.c();
    }

    public final String toString() {
        g9.g gVar = u1.f11967a;
        return u1.d(this.f11908f);
    }

    @Override // w7.b
    public final List w() {
        throw null;
    }
}

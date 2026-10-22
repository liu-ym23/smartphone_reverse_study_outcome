package z7;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class v1 {

    /* renamed from: a, reason: collision with root package name */
    public static final e9.b f11972a = e9.b.j(new e9.c("java.lang.Void"));

    /* JADX WARN: Multi-variable type inference failed */
    public static k a(f8.t tVar) {
        String strW = nb.i.w(tVar);
        if (strW == null) {
            if (tVar instanceof i8.j0) {
                String strB = l9.d.k(tVar).getName().b();
                q7.k.d(strB, "descriptor.propertyIfAccessor.name.asString()");
                strW = o8.w.a(strB);
            } else if (tVar instanceof i8.k0) {
                String strB2 = l9.d.k(tVar).getName().b();
                q7.k.d(strB2, "descriptor.propertyIfAccessor.name.asString()");
                strW = o8.w.b(strB2);
            } else {
                strW = ((i8.m) tVar).getName().b();
                q7.k.d(strW, "descriptor.name.asString()");
            }
        }
        return new k(new d9.e(strW, nb.i.m(tVar, 1)));
    }

    public static s1 b(f8.l0 l0Var) {
        q7.k.e(l0Var, "possiblyOverriddenProperty");
        f8.l0 l0VarA = ((f8.l0) h9.f.t(l0Var)).a();
        q7.k.d(l0VarA, "unwrapFakeOverride(possi…rriddenProperty).original");
        if (l0VarA instanceof t9.q) {
            t9.q qVar = (t9.q) l0VarA;
            z8.f0 f0Var = qVar.F;
            f9.n nVar = c9.l.f2165d;
            q7.k.d(nVar, "propertySignature");
            c9.f fVar = (c9.f) w7.e0.A(f0Var, nVar);
            if (fVar != null) {
                return new n(l0VarA, f0Var, fVar, qVar.G, qVar.H);
            }
        } else if (l0VarA instanceof q8.f) {
            f8.n0 n0VarQ = ((q8.f) l0VarA).q();
            k8.g gVar = n0VarQ instanceof k8.g ? (k8.g) n0VarQ : null;
            l8.s sVar = gVar != null ? gVar.f5659f : null;
            if (sVar instanceof l8.u) {
                return new l(((l8.u) sVar).f5884a);
            }
            if (!(sVar instanceof l8.x)) {
                throw new c7.i("Incorrect resolution sequence for Java field " + l0VarA + " (source = " + sVar + ')', 3);
            }
            Method method = ((l8.x) sVar).f5886a;
            i8.k0 k0VarG = l0VarA.g();
            f8.n0 n0VarQ2 = k0VarG != null ? k0VarG.q() : null;
            k8.g gVar2 = n0VarQ2 instanceof k8.g ? (k8.g) n0VarQ2 : null;
            l8.s sVar2 = gVar2 != null ? gVar2.f5659f : null;
            l8.x xVar = sVar2 instanceof l8.x ? (l8.x) sVar2 : null;
            return new m(method, xVar != null ? xVar.f5886a : null);
        }
        i8.j0 j0VarB = l0VarA.b();
        q7.k.b(j0VarB);
        k kVarA = a(j0VarB);
        i8.k0 k0VarG2 = l0VarA.g();
        return new o(kVarA, k0VarG2 != null ? a(k0VarG2) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s1 c(f8.t tVar) {
        Method method;
        q7.k.e(tVar, "possiblySubstitutedFunction");
        f8.t tVarA = ((f8.t) h9.f.t(tVar)).a();
        q7.k.d(tVarA, "unwrapFakeOverride(possi…titutedFunction).original");
        if (tVarA instanceof t9.b) {
            t9.b bVar = (t9.b) tVarA;
            f9.a aVarL = bVar.L();
            if (aVarL instanceof z8.x) {
                f9.h hVar = d9.h.f3015a;
                d9.e eVarC = d9.h.c((z8.x) aVarL, bVar.z0(), bVar.m0());
                if (eVarC != null) {
                    return new k(eVarC);
                }
            }
            if (aVarL instanceof z8.k) {
                f9.h hVar2 = d9.h.f3015a;
                d9.e eVarA = d9.h.a((z8.k) aVarL, bVar.z0(), bVar.m0());
                if (eVarA != null) {
                    f8.j jVarP = tVar.p();
                    q7.k.d(jVarP, "possiblySubstitutedFunction.containingDeclaration");
                    return h9.h.b(jVarP) ? new k(eVarA) : new j(eVarA);
                }
            }
            return a(tVarA);
        }
        if (tVarA instanceof q8.e) {
            f8.n0 n0VarQ = ((q8.e) tVarA).q();
            k8.g gVar = n0VarQ instanceof k8.g ? (k8.g) n0VarQ : null;
            l8.s sVar = gVar != null ? gVar.f5659f : null;
            l8.x xVar = sVar instanceof l8.x ? (l8.x) sVar : null;
            if (xVar != null && (method = xVar.f5886a) != null) {
                return new i(method);
            }
            throw new c7.i("Incorrect resolution sequence for Java method " + tVarA, 3);
        }
        if (!(tVarA instanceof q8.b)) {
            i8.m mVar = (i8.m) tVarA;
            if ((mVar.getName().equals(c8.n.f2058c) && h9.m.n(tVarA)) || ((mVar.getName().equals(c8.n.f2056a) && h9.m.n(tVarA)) || (q7.k.a(mVar.getName(), e8.a.f3118e) && tVarA.x0().isEmpty()))) {
                return a(tVarA);
            }
            throw new c7.i("Unknown origin of " + tVarA + " (" + tVarA.getClass() + ')', 3);
        }
        f8.n0 n0VarQ2 = ((q8.b) tVarA).q();
        k8.g gVar2 = n0VarQ2 instanceof k8.g ? (k8.g) n0VarQ2 : null;
        Object obj = gVar2 != null ? gVar2.f5659f : null;
        if (obj instanceof l8.r) {
            return new h(((l8.r) obj).f5882a);
        }
        if (obj instanceof l8.o) {
            Class cls = ((l8.o) obj).f5878a;
            if (cls.isAnnotation()) {
                return new g(cls);
            }
        }
        throw new c7.i("Incorrect resolution sequence for Java constructor " + tVarA + " (" + obj + ')', 3);
    }
}

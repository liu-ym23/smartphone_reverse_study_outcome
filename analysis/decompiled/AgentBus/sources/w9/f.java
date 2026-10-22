package w9;

import f8.q0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q7.w;
import v9.k0;
import v9.m0;
import v9.p0;
import v9.v;
import v9.x0;
import v9.z;
import v9.z0;

/* loaded from: classes.dex */
public final class f implements c {

    /* renamed from: f, reason: collision with root package name */
    public static final f f10931f = new f();

    /* renamed from: g, reason: collision with root package name */
    public static final f f10932g = new f();

    /* JADX WARN: Multi-variable type inference failed */
    public static z w(z zVar) {
        v vVarB;
        m0 m0VarE0 = zVar.E0();
        q0 q0Var = null;
        if (m0VarE0 instanceof i9.c) {
            i9.c cVar = (i9.c) m0VarE0;
            p0 p0Var = cVar.f4911a;
            p0 p0Var2 = p0Var.a() == 2 ? p0Var : null;
            z0 z0VarH0 = (p0Var2 == null || (vVarB = p0Var2.b()) == null) ? null : vVarB.H0();
            if (cVar.f4912b == null) {
                Collection collectionD = cVar.d();
                ArrayList arrayList = new ArrayList(d7.t.A0(collectionD, 10));
                Iterator it = collectionD.iterator();
                while (it.hasNext()) {
                    arrayList.add(((v) it.next()).H0());
                }
                cVar.f4912b = new j(p0Var, new t9.d(1, arrayList), q0Var, 8);
            }
            j jVar = cVar.f4912b;
            q7.k.b(jVar);
            return new i(y9.b.f11723f, jVar, z0VarH0, zVar.D0(), zVar.F0(), 32);
        }
        if (!(m0VarE0 instanceof v9.u) || !zVar.F0()) {
            return zVar;
        }
        v9.u uVar = (v9.u) m0VarE0;
        LinkedHashSet<v> linkedHashSet = uVar.f10592b;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(linkedHashSet, 10));
        boolean z4 = false;
        for (v vVar : linkedHashSet) {
            q7.k.e(vVar, "<this>");
            arrayList2.add(x0.g(vVar, true));
            z4 = true;
        }
        if (z4) {
            v vVar2 = uVar.f10591a;
            z0 z0VarG = vVar2 != null ? x0.g(vVar2, true) : null;
            arrayList2.isEmpty();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList2);
            linkedHashSet2.hashCode();
            v9.u uVar2 = new v9.u(linkedHashSet2);
            uVar2.f10591a = z0VarG;
            q0Var = uVar2;
        }
        if (q0Var != null) {
            uVar = q0Var;
        }
        return uVar.e();
    }

    @Override // w9.c
    public y9.j A(y9.j jVar, boolean z4) {
        return a.withNullability((c) this, jVar, z4);
    }

    @Override // w9.c
    public y9.j B(y9.j jVar) {
        y9.j jVarOriginal;
        q7.k.e(jVar, "<this>");
        y9.e eVarAsDefinitelyNotNullType = a.asDefinitelyNotNullType(this, jVar);
        return (eVarAsDefinitelyNotNullType == null || (jVarOriginal = a.original(this, eVarAsDefinitelyNotNullType)) == null) ? jVar : jVarOriginal;
    }

    @Override // w9.c
    public boolean C(z zVar) {
        return a.isSingleClassifierType(this, zVar);
    }

    @Override // w9.c
    public boolean D(y9.m mVar) {
        return a.isDenotable(this, mVar);
    }

    @Override // w9.c
    public boolean F(y9.h hVar) {
        q7.k.e(hVar, "<this>");
        y9.j jVarAsSimpleType = a.asSimpleType(this, hVar);
        return (jVarAsSimpleType != null ? a.asDefinitelyNotNullType(this, jVarAsSimpleType) : null) != null;
    }

    @Override // w9.c
    public Collection G(y9.m mVar) {
        return a.supertypes(this, mVar);
    }

    @Override // w9.c
    public k0 H(y9.j jVar) {
        return a.substitutionSupertypePolicy(this, jVar);
    }

    @Override // w9.c
    public y9.j J(y9.g gVar) {
        return a.upperBound(this, gVar);
    }

    @Override // w9.c
    public Collection K(y9.j jVar) {
        return a.possibleIntegerTypes(this, jVar);
    }

    @Override // w9.c
    public boolean L(y9.j jVar) {
        return a.isError(this, jVar);
    }

    @Override // w9.c
    public boolean N(y9.m mVar) {
        return a.isAnyConstructor(this, mVar);
    }

    @Override // w9.c
    public y9.e O(y9.j jVar) {
        return a.asDefinitelyNotNullType(this, jVar);
    }

    @Override // w9.c
    public y9.j P(y9.h hVar) {
        y9.j jVarLowerBound;
        q7.k.e(hVar, "<this>");
        y9.g gVarAsFlexibleType = a.asFlexibleType(this, hVar);
        if (gVarAsFlexibleType != null && (jVarLowerBound = a.lowerBound(this, gVarAsFlexibleType)) != null) {
            return jVarLowerBound;
        }
        y9.j jVarAsSimpleType = a.asSimpleType(this, hVar);
        q7.k.b(jVarAsSimpleType);
        return jVarAsSimpleType;
    }

    @Override // w9.c
    public boolean Q(z0 z0Var) {
        q7.k.e(z0Var, "<this>");
        return a.isMarkedNullable(this, P(z0Var)) != a.isMarkedNullable(this, l0(z0Var));
    }

    @Override // w9.c
    public boolean R(y9.l lVar) {
        return a.isStarProjection(this, lVar);
    }

    @Override // w9.c
    public int S(y9.k kVar) {
        q7.k.e(kVar, "<this>");
        if (kVar instanceof y9.j) {
            return a.argumentsCount(this, (y9.h) kVar);
        }
        if (kVar instanceof y9.a) {
            return ((y9.a) kVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + w.f8821a.b(kVar.getClass())).toString());
    }

    @Override // w9.c
    public boolean T(y9.m mVar) {
        return a.isIntegerLiteralTypeConstructor(this, mVar);
    }

    @Override // w9.c
    public boolean U(y9.d dVar) {
        return a.isProjectionNotNull(this, dVar);
    }

    @Override // w9.c
    public y9.l V(y9.h hVar, int i2) {
        return a.getArgument(this, hVar, i2);
    }

    @Override // w9.c
    public y9.m W(y9.h hVar) {
        q7.k.e(hVar, "<this>");
        y9.j jVarAsSimpleType = a.asSimpleType(this, hVar);
        if (jVarAsSimpleType == null) {
            jVarAsSimpleType = P(hVar);
        }
        return a.typeConstructor(this, jVarAsSimpleType);
    }

    @Override // w9.c
    public y9.p X(y9.n nVar) {
        return a.getVariance(this, nVar);
    }

    @Override // w9.c
    public boolean Y(y9.j jVar) {
        return a.isStubType(this, jVar);
    }

    @Override // w9.c
    public y9.h Z(y9.l lVar) {
        return a.getType(this, lVar);
    }

    public y9.h a(y9.h hVar) {
        y9.j jVarWithNullability;
        q7.k.e(hVar, "<this>");
        y9.j jVarAsSimpleType = a.asSimpleType(this, hVar);
        return (jVarAsSimpleType == null || (jVarWithNullability = a.withNullability((c) this, jVarAsSimpleType, true)) == null) ? hVar : jVarWithNullability;
    }

    @Override // w9.c
    public y9.c b(y9.d dVar) {
        return a.typeConstructor((c) this, dVar);
    }

    @Override // w9.c
    public y9.n b0(y9.m mVar, int i2) {
        return a.getParameter(this, mVar, i2);
    }

    @Override // w9.c
    public int c(y9.h hVar) {
        return a.argumentsCount(this, hVar);
    }

    @Override // w9.c
    public void c0(y9.j jVar, y9.m mVar) {
    }

    @Override // w9.c
    public int d(y9.m mVar) {
        return a.parametersCount(this, mVar);
    }

    @Override // w9.c
    public boolean d0(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        return a.isClassTypeConstructor(this, a.typeConstructor(this, jVar));
    }

    @Override // w9.c
    public y9.j e(y9.h hVar) {
        return a.asSimpleType(this, hVar);
    }

    @Override // w9.c
    public y9.l e0(y9.h hVar) {
        return a.asTypeArgument(this, hVar);
    }

    public z0 f(y9.h hVar) {
        z0 z0VarJ;
        q7.k.e(hVar, "type");
        if (!(hVar instanceof v)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        z0 z0VarH0 = ((v) hVar).H0();
        if (z0VarH0 instanceof z) {
            z0VarJ = w((z) z0VarH0);
        } else {
            if (!(z0VarH0 instanceof v9.p)) {
                throw new a4.u();
            }
            v9.p pVar = (v9.p) z0VarH0;
            z zVar = pVar.f10581h;
            z zVar2 = pVar.f10580g;
            z zVarW = w(zVar2);
            z zVarW2 = w(zVar);
            z0VarJ = (zVarW == zVar2 && zVarW2 == zVar) ? z0VarH0 : v9.d.j(zVarW, zVarW2);
        }
        v vVarE = v9.c.e(z0VarH0);
        return v9.c.z(z0VarJ, vVarE != null ? f(vVarE) : null);
    }

    @Override // w9.c
    public boolean f0(y9.j jVar) {
        return a.isMarkedNullable(this, jVar);
    }

    @Override // w9.c
    public void g(y9.h hVar) {
        q7.k.e(hVar, "<this>");
        y9.g gVarAsFlexibleType = a.asFlexibleType(this, hVar);
        if (gVarAsFlexibleType != null) {
            a.asDynamicType(this, gVarAsFlexibleType);
        }
    }

    @Override // w9.c
    public boolean g0(y9.m mVar) {
        return a.isIntersection(this, mVar);
    }

    @Override // w9.c
    public boolean h(y9.n nVar, y9.m mVar) {
        return a.hasRecursiveBounds(this, nVar, mVar);
    }

    @Override // w9.c
    public y9.b h0(y9.d dVar) {
        return a.captureStatus(this, dVar);
    }

    @Override // w9.c
    public y9.k i(y9.j jVar) {
        return a.asArgumentList(this, jVar);
    }

    @Override // w9.c
    public boolean i0(y9.m mVar, y9.m mVar2) {
        return a.areEqualTypeConstructors(this, mVar, mVar2);
    }

    @Override // w9.c
    public y9.h j(y9.h hVar) {
        return a.makeDefinitelyNotNullOrNotNull(this, hVar);
    }

    @Override // w9.c
    public boolean j0(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        return a.isNothingConstructor(this, W(jVar)) && !a.isNullableType(this, jVar);
    }

    @Override // w9.c
    public boolean k(y9.m mVar) {
        return a.isClassTypeConstructor(this, mVar);
    }

    @Override // w9.c
    public boolean k0(y9.m mVar) {
        return a.isNothingConstructor(this, mVar);
    }

    @Override // w9.c
    public y9.p l(y9.l lVar) {
        return a.getVariance(this, lVar);
    }

    @Override // w9.c
    public y9.j l0(y9.h hVar) {
        y9.j jVarUpperBound;
        q7.k.e(hVar, "<this>");
        y9.g gVarAsFlexibleType = a.asFlexibleType(this, hVar);
        if (gVarAsFlexibleType != null && (jVarUpperBound = a.upperBound(this, gVarAsFlexibleType)) != null) {
            return jVarUpperBound;
        }
        y9.j jVarAsSimpleType = a.asSimpleType(this, hVar);
        q7.k.b(jVarAsSimpleType);
        return jVarAsSimpleType;
    }

    @Override // w9.c
    public y9.j m(y9.j jVar) {
        return a.captureFromArguments(this, jVar, y9.b.f11723f);
    }

    @Override // w9.c
    public y9.g m0(y9.h hVar) {
        return a.asFlexibleType(this, hVar);
    }

    @Override // w9.c
    public y9.j n(y9.e eVar) {
        return a.original(this, eVar);
    }

    @Override // w9.c
    public y9.j n0(y9.g gVar) {
        return a.lowerBound(this, gVar);
    }

    @Override // w9.c
    public y9.m o(y9.j jVar) {
        return a.typeConstructor(this, jVar);
    }

    @Override // w9.c
    public boolean o0(y9.j jVar, y9.j jVar2) {
        return a.identicalArguments(this, jVar, jVar2);
    }

    @Override // w9.c
    public y9.d p(y9.j jVar) {
        return a.asCapturedType(this, jVar);
    }

    @Override // w9.c
    public boolean p0(y9.h hVar) {
        return a.isNotNullTypeParameter(this, hVar);
    }

    @Override // w9.c
    public y9.h q(y9.d dVar) {
        return a.lowerType(this, dVar);
    }

    @Override // w9.c
    public boolean q0(y9.j jVar) {
        return a.isStubTypeForBuilderInference(this, jVar);
    }

    @Override // w9.c
    public y9.l r(y9.j jVar, int i2) {
        q7.k.e(jVar, "<this>");
        if (i2 < 0 || i2 >= a.argumentsCount(this, jVar)) {
            return null;
        }
        return a.getArgument(this, jVar, i2);
    }

    @Override // w9.c
    public y9.h s(y9.h hVar) {
        return a.withNullability((c) this, hVar, true);
    }

    @Override // w9.c
    public y9.h t(ArrayList arrayList) {
        return a.intersectTypes(this, arrayList);
    }

    @Override // w9.c
    public y9.l t0(y9.c cVar) {
        return a.projection(this, cVar);
    }

    @Override // w9.c
    public y9.h u(y9.j jVar, y9.j jVar2) {
        return a.createFlexibleType(this, jVar, jVar2);
    }

    @Override // w9.c
    public boolean u0(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        y9.j jVarAsSimpleType = a.asSimpleType(this, jVar);
        return (jVarAsSimpleType != null ? a.asCapturedType(this, jVarAsSimpleType) : null) != null;
    }

    @Override // w9.c
    public boolean v(y9.m mVar) {
        return a.isCommonFinalClassConstructor(this, mVar);
    }

    @Override // w9.c
    public y9.l v0(y9.k kVar, int i2) {
        q7.k.e(kVar, "<this>");
        if (kVar instanceof y9.j) {
            return a.getArgument(this, (y9.h) kVar, i2);
        }
        if (kVar instanceof y9.a) {
            E e10 = ((y9.a) kVar).get(i2);
            q7.k.d(e10, "get(index)");
            return (y9.l) e10;
        }
        throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + w.f8821a.b(kVar.getClass())).toString());
    }

    @Override // w9.c
    public boolean y(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        return a.isIntegerLiteralTypeConstructor(this, a.typeConstructor(this, jVar));
    }

    @Override // w9.c
    public boolean z(y9.d dVar) {
        return a.isOldCapturedType(this, dVar);
    }
}

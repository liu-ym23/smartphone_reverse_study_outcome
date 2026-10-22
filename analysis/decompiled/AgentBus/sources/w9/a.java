package w9;

import f8.q0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m.x;
import q7.w;
import v9.c0;
import v9.i0;
import v9.k0;
import v9.l0;
import v9.m0;
import v9.n0;
import v9.p0;
import v9.v;
import v9.v0;
import v9.x0;
import v9.z;
import v9.z0;

/* loaded from: classes.dex */
public abstract class a {
    public static boolean areEqualTypeConstructors(c cVar, y9.m mVar, y9.m mVar2) {
        q7.k.e(mVar, "c1");
        q7.k.e(mVar2, "c2");
        if (!(mVar instanceof m0)) {
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(mVar);
            sb2.append(", ");
            throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
        }
        if (mVar2 instanceof m0) {
            return mVar.equals(mVar2);
        }
        StringBuilder sb3 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb3.append(mVar2);
        sb3.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar2.getClass(), sb3).toString());
    }

    public static int argumentsCount(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            return ((v) hVar).C0().size();
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static y9.k asArgumentList(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof z) {
            return (y9.k) jVar;
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static y9.d asCapturedType(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (!(jVar instanceof z)) {
            StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
            throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
        }
        if (jVar instanceof c0) {
            return cVar.p(((c0) jVar).f10539g);
        }
        if (jVar instanceof i) {
            return (i) jVar;
        }
        return null;
    }

    public static y9.e asDefinitelyNotNullType(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof z) {
            if (jVar instanceof v9.l) {
                return (v9.l) jVar;
            }
            return null;
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static y9.f asDynamicType(c cVar, y9.g gVar) {
        q7.k.e(gVar, "$receiver");
        if (gVar instanceof v9.p) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(gVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, gVar.getClass(), sb2).toString());
    }

    public static y9.g asFlexibleType(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            z0 z0VarH0 = ((v) hVar).H0();
            if (z0VarH0 instanceof v9.p) {
                return (v9.p) z0VarH0;
            }
            return null;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static y9.i asRawType(c cVar, y9.g gVar) {
        q7.k.e(gVar, "$receiver");
        if (gVar instanceof v9.p) {
            if (gVar instanceof t8.f) {
                return (t8.f) gVar;
            }
            return null;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(gVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, gVar.getClass(), sb2).toString());
    }

    public static y9.j asSimpleType(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            z0 z0VarH0 = ((v) hVar).H0();
            if (z0VarH0 instanceof z) {
                return (z) z0VarH0;
            }
            return null;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static y9.l asTypeArgument(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            return n7.m.f((v) hVar);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static y9.j captureFromArguments(c cVar, y9.j jVar, y9.b bVar) {
        List listC0;
        ArrayList arrayList;
        q7.k.e(jVar, "type");
        q7.k.e(bVar, "status");
        if (!(jVar instanceof z)) {
            throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ")).toString());
        }
        z zVar = (z) jVar;
        f fVar = f.f10931f;
        t9.d dVar = null;
        if (zVar.C0().size() == zVar.E0().getParameters().size() && ((listC0 = zVar.C0()) == null || !listC0.isEmpty())) {
            Iterator it = listC0.iterator();
            while (it.hasNext()) {
                if (((p0) it.next()).a() != 1) {
                    List parameters = zVar.E0().getParameters();
                    q7.k.d(parameters, "type.constructor.parameters");
                    ArrayList arrayListS1 = d7.r.s1(listC0, parameters);
                    arrayList = new ArrayList(d7.t.A0(arrayListS1, 10));
                    Iterator it2 = arrayListS1.iterator();
                    while (it2.hasNext()) {
                        c7.j jVar2 = (c7.j) it2.next();
                        p0 p0VarF = (p0) jVar2.f1973f;
                        q0 q0Var = (q0) jVar2.f1974g;
                        if (p0VarF.a() != 1) {
                            z0 z0VarH0 = (p0VarF.c() || p0VarF.a() != 2) ? null : p0VarF.b().H0();
                            q7.k.d(q0Var, "parameter");
                            p0VarF = n7.m.f(new i(bVar, new j(p0VarF, dVar, q0Var, 6), z0VarH0, (i0) null, false, 56));
                        }
                        arrayList.add(p0VarF);
                    }
                    v0 v0Var = new v0(n0.f10575b.f(zVar.E0(), arrayList));
                    int size = listC0.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        p0 p0Var = (p0) listC0.get(i2);
                        p0 p0Var2 = (p0) arrayList.get(i2);
                        if (p0Var.a() != 1) {
                            List upperBounds = ((q0) zVar.E0().getParameters().get(i2)).getUpperBounds();
                            q7.k.d(upperBounds, "type.constructor.parameters[index].upperBounds");
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it3 = upperBounds.iterator();
                            while (it3.hasNext()) {
                                arrayList2.add(fVar.f(v0Var.g(1, (v) it3.next()).H0()));
                            }
                            if (!p0Var.c() && p0Var.a() == 3) {
                                arrayList2.add(fVar.f(p0Var.b().H0()));
                            }
                            v vVarB = p0Var2.b();
                            q7.k.c(vVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            j jVar3 = ((i) vVarB).f10936h;
                            jVar3.getClass();
                            jVar3.f10942b = new t9.d(2, arrayList2);
                        }
                    }
                }
            }
            arrayList = null;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            return v9.d.r(arrayList, zVar.D0(), zVar.E0(), zVar.F0());
        }
        return null;
    }

    public static y9.b captureStatus(c cVar, y9.d dVar) {
        q7.k.e(dVar, "$receiver");
        if (dVar instanceof i) {
            return ((i) dVar).f10935g;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(dVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, dVar.getClass(), sb2).toString());
    }

    public static y9.h createFlexibleType(c cVar, y9.j jVar, y9.j jVar2) {
        q7.k.e(jVar, "lowerBound");
        q7.k.e(jVar2, "upperBound");
        if (!(jVar instanceof z)) {
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(cVar);
            sb2.append(", ");
            throw new IllegalArgumentException(x.o(w.f8821a, cVar.getClass(), sb2).toString());
        }
        if (jVar2 instanceof z) {
            return v9.d.j((z) jVar, (z) jVar2);
        }
        StringBuilder sb3 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb3.append(cVar);
        sb3.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, cVar.getClass(), sb3).toString());
    }

    public static y9.l getArgument(c cVar, y9.h hVar, int i2) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            return (y9.l) ((v) hVar).C0().get(i2);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static List<y9.l> getArguments(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            return ((v) hVar).C0();
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static e9.e getClassFqNameUnsafe(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            f8.g gVarC = ((m0) mVar).c();
            q7.k.c(gVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return l9.d.h((f8.e) gVarC);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static y9.n getParameter(c cVar, y9.m mVar, int i2) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            Object obj = ((m0) mVar).getParameters().get(i2);
            q7.k.d(obj, "this.parameters[index]");
            return (y9.n) obj;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static List<y9.n> getParameters(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            List<y9.n> parameters = ((m0) mVar).getParameters();
            q7.k.d(parameters, "this.parameters");
            return parameters;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static c8.j getPrimitiveArrayType(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            f8.g gVarC = ((m0) mVar).c();
            q7.k.c(gVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return c8.h.r((f8.e) gVarC);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static c8.j getPrimitiveType(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            f8.g gVarC = ((m0) mVar).c();
            q7.k.c(gVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return c8.h.t((f8.e) gVarC);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static y9.h getRepresentativeUpperBound(c cVar, y9.n nVar) {
        q7.k.e(nVar, "$receiver");
        if (nVar instanceof q0) {
            return n7.m.x((q0) nVar);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(nVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, nVar.getClass(), sb2).toString());
    }

    public static y9.h getType(c cVar, y9.l lVar) {
        q7.k.e(lVar, "$receiver");
        if (lVar instanceof p0) {
            return ((p0) lVar).b().H0();
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(lVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, lVar.getClass(), sb2).toString());
    }

    public static y9.n getTypeParameter(c cVar, y9.o oVar) {
        q7.k.e(oVar, "$receiver");
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(oVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, oVar.getClass(), sb2).toString());
    }

    public static y9.n getTypeParameterClassifier(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            f8.g gVarC = ((m0) mVar).c();
            if (gVarC instanceof q0) {
                return (q0) gVarC;
            }
            return null;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static y9.h getUnsubstitutedUnderlyingType(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            return h9.h.f((v) hVar);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static List<y9.h> getUpperBounds(c cVar, y9.n nVar) {
        q7.k.e(nVar, "$receiver");
        if (nVar instanceof q0) {
            List<y9.h> upperBounds = ((q0) nVar).getUpperBounds();
            q7.k.d(upperBounds, "this.upperBounds");
            return upperBounds;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(nVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, nVar.getClass(), sb2).toString());
    }

    public static y9.p getVariance(c cVar, y9.l lVar) {
        q7.k.e(lVar, "$receiver");
        if (lVar instanceof p0) {
            int iA = ((p0) lVar).a();
            x.y(iA, "this.projectionKind");
            return n7.o.f(iA);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(lVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, lVar.getClass(), sb2).toString());
    }

    public static boolean hasAnnotation(c cVar, y9.h hVar, e9.c cVar2) {
        q7.k.e(hVar, "$receiver");
        q7.k.e(cVar2, "fqName");
        if (hVar instanceof v) {
            return ((v) hVar).getAnnotations().g(cVar2);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static boolean hasRecursiveBounds(c cVar, y9.n nVar, y9.m mVar) {
        q7.k.e(nVar, "$receiver");
        if (!(nVar instanceof q0)) {
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(nVar);
            sb2.append(", ");
            throw new IllegalArgumentException(x.o(w.f8821a, nVar.getClass(), sb2).toString());
        }
        if (mVar == null ? true : mVar instanceof m0) {
            return n7.m.y((q0) nVar, (m0) mVar, null);
        }
        StringBuilder sb3 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb3.append(nVar);
        sb3.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, nVar.getClass(), sb3).toString());
    }

    public static boolean identicalArguments(c cVar, y9.j jVar, y9.j jVar2) {
        q7.k.e(jVar, "a");
        q7.k.e(jVar2, "b");
        if (!(jVar instanceof z)) {
            throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ")).toString());
        }
        if (jVar2 instanceof z) {
            return ((z) jVar).C0() == ((z) jVar2).C0();
        }
        throw new IllegalArgumentException(x.o(w.f8821a, jVar2.getClass(), x.q("ClassicTypeSystemContext couldn't handle: ", jVar2, ", ")).toString());
    }

    public static y9.h intersectTypes(c cVar, List<? extends y9.h> list) {
        z zVar;
        q7.k.e(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (z0) d7.r.f1(list);
        }
        ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
        Iterator<T> it = list.iterator();
        boolean z4 = false;
        boolean z10 = false;
        while (it.hasNext()) {
            z0 z0Var = (z0) it.next();
            z4 = z4 || v9.c.i(z0Var);
            if (z0Var instanceof z) {
                zVar = (z) z0Var;
            } else {
                if (!(z0Var instanceof v9.p)) {
                    throw new a4.u();
                }
                zVar = ((v9.p) z0Var).f10580g;
                z10 = true;
            }
            arrayList.add(zVar);
        }
        if (z4) {
            return x9.i.c(x9.h.C, list.toString());
        }
        u uVar = u.f10959a;
        if (!z10) {
            return uVar.b(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(v9.c.x((z0) it2.next()));
        }
        return v9.d.j(uVar.b(arrayList), uVar.b(arrayList2));
    }

    public static boolean isAnyConstructor(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            return c8.h.H((m0) mVar, c8.m.f2027a);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isClassTypeConstructor(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            return ((m0) mVar).c() instanceof f8.e;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isCommonFinalClassConstructor(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            f8.g gVarC = ((m0) mVar).c();
            f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
            return (eVar == null || eVar.i() != 1 || eVar.B() == 3 || eVar.B() == 4 || eVar.B() == 5) ? false : true;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isDenotable(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            return ((m0) mVar).a();
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isError(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            return v9.c.i((v) hVar);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static boolean isInlineClass(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            f8.g gVarC = ((m0) mVar).c();
            f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
            return (eVar != null ? eVar.i0() : null) instanceof f8.u;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isIntegerLiteralTypeConstructor(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            return mVar instanceof j9.n;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isIntersection(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            return mVar instanceof v9.u;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isMarkedNullable(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof z) {
            return ((z) jVar).F0();
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static boolean isNotNullTypeParameter(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        return hVar instanceof w8.g;
    }

    public static boolean isNothingConstructor(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            return c8.h.H((m0) mVar, c8.m.f2029b);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static boolean isNullableType(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof v) {
            return x0.e((v) hVar);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static boolean isOldCapturedType(c cVar, y9.d dVar) {
        q7.k.e(dVar, "$receiver");
        return dVar instanceof i9.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isPrimitiveType(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof v) {
            return c8.h.F((v) jVar);
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static boolean isProjectionNotNull(c cVar, y9.d dVar) {
        q7.k.e(dVar, "$receiver");
        if (dVar instanceof i) {
            return ((i) dVar).f10940l;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(dVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, dVar.getClass(), sb2).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isSingleClassifierType(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (!(jVar instanceof z)) {
            throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ")).toString());
        }
        if (v9.c.i((v) jVar)) {
            return false;
        }
        z zVar = (z) jVar;
        if (zVar.E0().c() instanceof t9.s) {
            return false;
        }
        return zVar.E0().c() != null || (jVar instanceof i9.a) || (jVar instanceof i) || (jVar instanceof v9.l) || (zVar.E0() instanceof j9.n) || isSingleClassifierTypeWithEnhancement(cVar, jVar);
    }

    private static boolean isSingleClassifierTypeWithEnhancement(c cVar, y9.j jVar) {
        return (jVar instanceof c0) && cVar.C(((c0) jVar).f10539g);
    }

    public static boolean isStarProjection(c cVar, y9.l lVar) {
        q7.k.e(lVar, "$receiver");
        if (lVar instanceof p0) {
            return ((p0) lVar).c();
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(lVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, lVar.getClass(), sb2).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isStubType(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof z) {
            return false;
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isStubTypeForBuilderInference(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof z) {
            return false;
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static boolean isTypeVariableType(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (!(hVar instanceof z0)) {
            return false;
        }
        ((z0) hVar).E0();
        return false;
    }

    public static boolean isUnderKotlinPackage(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            f8.g gVarC = ((m0) mVar).c();
            return gVarC != null && c8.h.I(gVarC);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static y9.j lowerBound(c cVar, y9.g gVar) {
        q7.k.e(gVar, "$receiver");
        if (gVar instanceof v9.p) {
            return ((v9.p) gVar).f10580g;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(gVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, gVar.getClass(), sb2).toString());
    }

    public static y9.h lowerType(c cVar, y9.d dVar) {
        q7.k.e(dVar, "$receiver");
        if (dVar instanceof i) {
            return ((i) dVar).f10937i;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(dVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, dVar.getClass(), sb2).toString());
    }

    public static y9.h makeDefinitelyNotNullOrNotNull(c cVar, y9.h hVar) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof z0) {
            return v9.c.l((z0) hVar, false);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(hVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, hVar.getClass(), sb2).toString());
    }

    public static l0 newTypeCheckerState(c cVar, boolean z4, boolean z10) {
        return h.b(z4, z10, cVar, null, 24);
    }

    public static y9.j original(c cVar, y9.e eVar) {
        q7.k.e(eVar, "$receiver");
        if (eVar instanceof v9.l) {
            return ((v9.l) eVar).f10564g;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(eVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, eVar.getClass(), sb2).toString());
    }

    public static int parametersCount(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            return ((m0) mVar).getParameters().size();
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static Collection<y9.h> possibleIntegerTypes(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        y9.m mVarO = cVar.o(jVar);
        if (mVarO instanceof j9.n) {
            return ((j9.n) mVarO).f5413a;
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static y9.l projection(c cVar, y9.c cVar2) {
        q7.k.e(cVar2, "$receiver");
        if (cVar2 instanceof j) {
            return ((j) cVar2).f10941a;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(cVar2);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, cVar2.getClass(), sb2).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static k0 substitutionSupertypePolicy(c cVar, y9.j jVar) {
        q7.k.e(jVar, "type");
        if (!(jVar instanceof z)) {
            StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
            throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
        }
        v vVar = (v) jVar;
        return new b(cVar, new v0(n0.f10575b.f(vVar.E0(), vVar.C0())));
    }

    public static Collection<y9.h> supertypes(c cVar, y9.m mVar) {
        q7.k.e(mVar, "$receiver");
        if (mVar instanceof m0) {
            Collection<y9.h> collectionD = ((m0) mVar).d();
            q7.k.d(collectionD, "this.supertypes");
            return collectionD;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(mVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, mVar.getClass(), sb2).toString());
    }

    public static y9.m typeConstructor(c cVar, y9.j jVar) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof z) {
            return ((z) jVar).E0();
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static y9.j upperBound(c cVar, y9.g gVar) {
        q7.k.e(gVar, "$receiver");
        if (gVar instanceof v9.p) {
            return ((v9.p) gVar).f10581h;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(gVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, gVar.getClass(), sb2).toString());
    }

    public static y9.j withNullability(c cVar, y9.j jVar, boolean z4) {
        q7.k.e(jVar, "$receiver");
        if (jVar instanceof z) {
            return ((z) jVar).I0(z4);
        }
        StringBuilder sbQ = x.q("ClassicTypeSystemContext couldn't handle: ", jVar, ", ");
        throw new IllegalArgumentException(x.o(w.f8821a, jVar.getClass(), sbQ).toString());
    }

    public static y9.p getVariance(c cVar, y9.n nVar) {
        q7.k.e(nVar, "$receiver");
        if (nVar instanceof q0) {
            int iA0 = ((q0) nVar).a0();
            x.y(iA0, "this.variance");
            return n7.o.f(iA0);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(nVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, nVar.getClass(), sb2).toString());
    }

    public static y9.c typeConstructor(c cVar, y9.d dVar) {
        q7.k.e(dVar, "$receiver");
        if (dVar instanceof i) {
            return ((i) dVar).f10936h;
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(dVar);
        sb2.append(", ");
        throw new IllegalArgumentException(x.o(w.f8821a, dVar.getClass(), sb2).toString());
    }

    public static y9.h withNullability(c cVar, y9.h hVar, boolean z4) {
        q7.k.e(hVar, "$receiver");
        if (hVar instanceof y9.j) {
            return cVar.A((y9.j) hVar, z4);
        }
        if (!(hVar instanceof y9.g)) {
            throw new IllegalStateException("sealed");
        }
        y9.g gVar = (y9.g) hVar;
        return cVar.u(cVar.A(cVar.n0(gVar), z4), cVar.A(cVar.J(gVar), z4));
    }
}

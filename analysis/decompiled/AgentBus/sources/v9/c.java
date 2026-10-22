package v9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c {
    public static /* synthetic */ void a(int i2) {
        String str = i2 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 4 ? 3 : 2];
        switch (i2) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i2 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static final z b(v vVar) {
        q7.k.e(vVar, "<this>");
        z0 z0VarH0 = vVar.H0();
        z zVar = z0VarH0 instanceof z ? (z) z0VarH0 : null;
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalStateException(("This is should be simple type: " + vVar).toString());
    }

    public static final v c(ArrayList arrayList, List list, c8.h hVar) {
        v vVarI = new v0(new f0(0, arrayList)).i(3, (v) d7.r.N0(list));
        return vVarI == null ? hVar.m() : vVarI;
    }

    public static final y9.h d(y9.h hVar, HashSet hashSet) {
        y9.h hVarD;
        w9.f fVar = w9.f.f10932g;
        y9.m mVarW = fVar.W(hVar);
        if (!hashSet.add(mVarW)) {
            return null;
        }
        y9.n typeParameterClassifier = w9.a.getTypeParameterClassifier(fVar, mVarW);
        if (typeParameterClassifier != null) {
            y9.h representativeUpperBound = w9.a.getRepresentativeUpperBound(fVar, typeParameterClassifier);
            y9.h hVarD2 = d(representativeUpperBound, hashSet);
            if (hVarD2 != null) {
                return ((hVarD2 instanceof y9.j) && w9.a.isPrimitiveType(fVar, (y9.j) hVarD2) && w9.a.isNullableType(fVar, hVar) && (w9.a.isInlineClass(fVar, fVar.W(representativeUpperBound)) || ((representativeUpperBound instanceof y9.j) && w9.a.isPrimitiveType(fVar, (y9.j) representativeUpperBound)))) ? fVar.a(representativeUpperBound) : (!w9.a.isNullableType(fVar, hVarD2) && (hVar instanceof y9.j) && w9.a.isMarkedNullable(fVar, (y9.j) hVar)) ? fVar.a(hVarD2) : hVarD2;
            }
            return null;
        }
        if (!w9.a.isInlineClass(fVar, mVarW)) {
            return hVar;
        }
        y9.h unsubstitutedUnderlyingType = w9.a.getUnsubstitutedUnderlyingType(fVar, hVar);
        if (unsubstitutedUnderlyingType == null || (hVarD = d(unsubstitutedUnderlyingType, hashSet)) == null) {
            return null;
        }
        return !w9.a.isNullableType(fVar, hVar) ? hVarD : w9.a.isNullableType(fVar, hVarD) ? hVar : ((hVarD instanceof y9.j) && w9.a.isPrimitiveType(fVar, (y9.j) hVarD)) ? hVar : fVar.a(hVarD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final v e(v vVar) {
        q7.k.e(vVar, "<this>");
        if (vVar instanceof y0) {
            return ((y0) vVar).T();
        }
        return null;
    }

    public static boolean f(l0 l0Var, y9.j jVar, k0 k0Var) {
        j0 j0Var = j0.f10560c;
        q7.k.e(l0Var, "<this>");
        q7.k.e(jVar, "type");
        w9.c cVar = l0Var.f10568c;
        if ((cVar.d0(jVar) && !cVar.f0(jVar)) || cVar.F(jVar)) {
            return true;
        }
        l0Var.b();
        ArrayDeque arrayDeque = l0Var.f10572g;
        q7.k.b(arrayDeque);
        ea.h hVar = l0Var.f10573h;
        q7.k.b(hVar);
        arrayDeque.push(jVar);
        while (!arrayDeque.isEmpty()) {
            if (hVar.f3239g > 1000) {
                StringBuilder sbQ = m.x.q("Too many supertypes for type: ", jVar, ". Supertypes = ");
                sbQ.append(d7.r.U0(hVar, null, null, null, null, 63));
                throw new IllegalStateException(sbQ.toString().toString());
            }
            y9.j jVar2 = (y9.j) arrayDeque.pop();
            q7.k.d(jVar2, "current");
            if (hVar.add(jVar2)) {
                k0 k0Var2 = cVar.f0(jVar2) ? j0Var : k0Var;
                if (k0Var2.equals(j0Var)) {
                    k0Var2 = null;
                }
                if (k0Var2 == null) {
                    continue;
                } else {
                    Iterator it = cVar.G(cVar.o(jVar2)).iterator();
                    while (it.hasNext()) {
                        y9.j jVarA = k0Var2.a(l0Var, (y9.h) it.next());
                        if ((cVar.d0(jVarA) && !cVar.f0(jVarA)) || cVar.F(jVarA)) {
                            l0Var.a();
                            return true;
                        }
                        arrayDeque.add(jVarA);
                    }
                }
            }
        }
        l0Var.a();
        return false;
    }

    public static final z0 g(z0 z0Var, v vVar) {
        q7.k.e(z0Var, "<this>");
        q7.k.e(vVar, "origin");
        return z(z0Var, e(vVar));
    }

    public static boolean h(l0 l0Var, y9.j jVar, y9.m mVar) {
        w9.c cVar = l0Var.f10568c;
        if (cVar.j0(jVar)) {
            return true;
        }
        if (cVar.f0(jVar)) {
            return false;
        }
        if (l0Var.f10567b && cVar.Y(jVar)) {
            return true;
        }
        return cVar.i0(cVar.o(jVar), mVar);
    }

    public static final boolean i(v vVar) {
        q7.k.e(vVar, "<this>");
        z0 z0VarH0 = vVar.H0();
        if (z0VarH0 instanceof x9.f) {
            return true;
        }
        return (z0VarH0 instanceof p) && (((p) z0VarH0).L0() instanceof x9.f);
    }

    public static final boolean j(v vVar) {
        q7.k.e(vVar, "<this>");
        return vVar.H0() instanceof p;
    }

    public static final z k(v vVar) {
        q7.k.e(vVar, "<this>");
        z0 z0VarH0 = vVar.H0();
        if (z0VarH0 instanceof p) {
            return ((p) z0VarH0).f10580g;
        }
        if (z0VarH0 instanceof z) {
            return (z) z0VarH0;
        }
        throw new a4.u();
    }

    public static final z0 l(z0 z0Var, boolean z4) {
        q7.k.e(z0Var, "<this>");
        l lVarP = d.p(z0Var, z4);
        if (lVarP != null) {
            return lVarP;
        }
        z zVarM = m(z0Var);
        return zVarM != null ? zVarM : z0Var.I0(false);
    }

    public static final z m(z0 z0Var) {
        u uVar;
        m0 m0VarE0 = z0Var.E0();
        u uVar2 = m0VarE0 instanceof u ? (u) m0VarE0 : null;
        if (uVar2 != null) {
            LinkedHashSet<v> linkedHashSet = uVar2.f10592b;
            ArrayList arrayList = new ArrayList(d7.t.A0(linkedHashSet, 10));
            boolean z4 = false;
            for (v vVarL : linkedHashSet) {
                if (x0.e(vVarL)) {
                    vVarL = l(vVarL.H0(), false);
                    z4 = true;
                }
                arrayList.add(vVarL);
            }
            if (z4) {
                v vVarL2 = uVar2.f10591a;
                if (vVarL2 == null) {
                    vVarL2 = null;
                } else if (x0.e(vVarL2)) {
                    vVarL2 = l(vVarL2.H0(), false);
                }
                arrayList.isEmpty();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList);
                linkedHashSet2.hashCode();
                uVar = new u(linkedHashSet2);
                uVar.f10591a = vVarL2;
            } else {
                uVar = null;
            }
            if (uVar != null) {
                return uVar.e();
            }
        }
        return null;
    }

    public static final z n(z zVar, List list, i0 i0Var) {
        q7.k.e(zVar, "<this>");
        q7.k.e(list, "newArguments");
        q7.k.e(i0Var, "newAttributes");
        if (list.isEmpty() && i0Var == zVar.D0()) {
            return zVar;
        }
        if (list.isEmpty()) {
            return zVar.K0(i0Var);
        }
        if (!(zVar instanceof x9.f)) {
            return d.r(list, i0Var, zVar.E0(), zVar.F0());
        }
        x9.f fVar = (x9.f) zVar;
        m0 m0Var = fVar.f11292g;
        x9.e eVar = fVar.f11293h;
        x9.h hVar = fVar.f11294i;
        boolean z4 = fVar.f11296k;
        String[] strArr = fVar.f11297l;
        return new x9.f(m0Var, eVar, hVar, list, z4, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static v o(v vVar, List list, g8.j jVar, int i2) {
        if ((i2 & 2) != 0) {
            jVar = vVar.getAnnotations();
        }
        q7.k.e(vVar, "<this>");
        if ((list.isEmpty() || list == vVar.C0()) && jVar == vVar.getAnnotations()) {
            return vVar;
        }
        i0 i0VarD0 = vVar.D0();
        if ((jVar instanceof g8.n) && jVar.isEmpty()) {
            jVar = g8.h.f3888a;
        }
        i0 i0VarQ = q(i0VarD0, jVar);
        z0 z0VarH0 = vVar.H0();
        if (z0VarH0 instanceof p) {
            p pVar = (p) z0VarH0;
            return d.j(n(pVar.f10580g, list, i0VarQ), n(pVar.f10581h, list, i0VarQ));
        }
        if (z0VarH0 instanceof z) {
            return n((z) z0VarH0, list, i0VarQ);
        }
        throw new a4.u();
    }

    public static /* synthetic */ z p(z zVar, List list, i0 i0Var, int i2) {
        if ((i2 & 1) != 0) {
            list = zVar.C0();
        }
        if ((i2 & 2) != 0) {
            i0Var = zVar.D0();
        }
        return n(zVar, list, i0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final v9.i0 q(v9.i0 r5, g8.j r6) {
        /*
            java.lang.String r0 = "<this>"
            q7.k.e(r5, r0)
            g8.j r0 = v9.h.a(r5)
            if (r0 != r6) goto Lc
            return r5
        Lc:
            ba.q r0 = v9.h.f10553b
            w7.t[] r1 = v9.h.f10552a
            r2 = 0
            r1 = r1[r2]
            r0.getClass()
            java.lang.String r2 = "property"
            q7.k.e(r1, r2)
            ba.a r1 = r5.f1594f
            int r0 = r0.f1623a
            java.lang.Object r0 = r1.get(r0)
            v9.g r0 = (v9.g) r0
            if (r0 == 0) goto L6b
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L2e
            goto L5c
        L2e:
            ba.a r1 = r5.f1594f
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L39:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L50
            java.lang.Object r3 = r1.next()
            r4 = r3
            v9.g r4 = (v9.g) r4
            boolean r4 = q7.k.a(r4, r0)
            if (r4 != 0) goto L39
            r2.add(r3)
            goto L39
        L50:
            int r0 = r2.size()
            ba.a r1 = r5.f1594f
            int r1 = r1.a()
            if (r0 != r1) goto L5e
        L5c:
            r0 = r5
            goto L67
        L5e:
            nb.f r0 = v9.i0.f10557g
            r0.getClass()
            v9.i0 r0 = nb.f.q(r2)
        L67:
            if (r0 != 0) goto L6a
            goto L6b
        L6a:
            r5 = r0
        L6b:
            java.util.Iterator r0 = r6.iterator()
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L7c
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L7c
            goto L97
        L7c:
            v9.g r0 = new v9.g
            r0.<init>(r6)
            nb.f r6 = v9.i0.f10557g
            java.lang.Class<v9.g> r1 = v9.g.class
            q7.x r2 = q7.w.f8821a
            w7.d r1 = r2.b(r1)
            int r6 = r6.A(r1)
            ba.a r1 = r5.f1594f
            java.lang.Object r6 = r1.get(r6)
            if (r6 == 0) goto L98
        L97:
            return r5
        L98:
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto La8
            v9.i0 r5 = new v9.i0
            java.util.List r6 = a.a.S(r0)
            r5.<init>(r6)
            return r5
        La8:
            java.util.List r5 = d7.r.m1(r5)
            java.util.ArrayList r5 = d7.r.d1(r5, r0)
            v9.i0 r5 = nb.f.q(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.c.q(v9.i0, g8.j):v9.i0");
    }

    public static final v r(f8.q0 q0Var) {
        q7.k.e(q0Var, "<this>");
        f8.j jVarP = q0Var.p();
        q7.k.d(jVarP, "this.containingDeclaration");
        if (jVarP instanceof f8.h) {
            List parameters = ((f8.h) jVarP).h().getParameters();
            q7.k.d(parameters, "descriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(d7.t.A0(parameters, 10));
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                m0 m0VarH = ((f8.q0) it.next()).h();
                q7.k.d(m0VarH, "it.typeConstructor");
                arrayList.add(m0VarH);
            }
            List upperBounds = q0Var.getUpperBounds();
            q7.k.d(upperBounds, "upperBounds");
            return c(arrayList, upperBounds, l9.d.e(q0Var));
        }
        if (!(jVarP instanceof f8.t)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List typeParameters = ((f8.t) jVarP).getTypeParameters();
        q7.k.d(typeParameters, "descriptor.typeParameters");
        ArrayList arrayList2 = new ArrayList(d7.t.A0(typeParameters, 10));
        Iterator it2 = typeParameters.iterator();
        while (it2.hasNext()) {
            m0 m0VarH2 = ((f8.q0) it2.next()).h();
            q7.k.d(m0VarH2, "it.typeConstructor");
            arrayList2.add(m0VarH2);
        }
        List upperBounds2 = q0Var.getUpperBounds();
        q7.k.d(upperBounds2, "upperBounds");
        return c(arrayList2, upperBounds2, l9.d.e(q0Var));
    }

    public static boolean s(w9.c cVar, y9.j jVar, y9.j jVar2) {
        if (cVar.c(jVar) == cVar.c(jVar2) && cVar.f0(jVar) == cVar.f0(jVar2)) {
            if ((cVar.O(jVar) == null) == (cVar.O(jVar2) == null) && cVar.i0(cVar.o(jVar), cVar.o(jVar2))) {
                if (!cVar.o0(jVar, jVar2)) {
                    int iC = cVar.c(jVar);
                    for (int i2 = 0; i2 < iC; i2++) {
                        y9.l lVarV = cVar.V(jVar, i2);
                        y9.l lVarV2 = cVar.V(jVar2, i2);
                        if (cVar.R(lVarV) == cVar.R(lVarV2) && (cVar.R(lVarV) || (cVar.l(lVarV) == cVar.l(lVarV2) && t(cVar, cVar.Z(lVarV), cVar.Z(lVarV2))))) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean t(w9.c cVar, y9.h hVar, y9.h hVar2) {
        if (hVar == hVar2) {
            return true;
        }
        y9.j jVarE = cVar.e(hVar);
        y9.j jVarE2 = cVar.e(hVar2);
        if (jVarE != null && jVarE2 != null) {
            return s(cVar, jVarE, jVarE2);
        }
        y9.g gVarM0 = cVar.m0(hVar);
        y9.g gVarM02 = cVar.m0(hVar2);
        return gVarM0 != null && gVarM02 != null && s(cVar, cVar.n0(gVarM0), cVar.n0(gVarM02)) && s(cVar, cVar.J(gVarM0), cVar.J(gVarM02));
    }

    public static v0 u(List list, s0 s0Var, f8.j jVar, ArrayList arrayList) {
        if (s0Var == null) {
            a(1);
            throw null;
        }
        if (jVar == null) {
            a(2);
            throw null;
        }
        if (arrayList == null) {
            a(3);
            throw null;
        }
        v0 v0VarV = v(list, s0Var, jVar, arrayList, null);
        if (v0VarV != null) {
            return v0VarV;
        }
        throw new AssertionError("Substitution failed");
    }

    public static v0 v(List list, s0 s0Var, f8.j jVar, List list2, boolean[] zArr) {
        if (s0Var == null) {
            a(6);
            throw null;
        }
        if (jVar == null) {
            a(7);
            throw null;
        }
        if (list2 == null) {
            a(8);
            throw null;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            f8.q0 q0Var = (f8.q0) it.next();
            i8.p0 p0VarI0 = i8.p0.I0(jVar, q0Var.getAnnotations(), q0Var.N(), q0Var.a0(), q0Var.getName(), i2, q0Var.A());
            map.put(q0Var.h(), new q0(1, p0VarI0.k()));
            map2.put(q0Var, p0VarI0);
            list2.add(p0VarI0);
            i2++;
        }
        f0 f0Var = new f0(1, map);
        v0 v0VarE = v0.e(s0Var, f0Var);
        v0 v0VarE2 = v0.e(new i9.d(s0Var, 1), f0Var);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            f8.q0 q0Var2 = (f8.q0) it2.next();
            i8.p0 p0Var = (i8.p0) map2.get(q0Var2);
            for (v vVar : q0Var2.getUpperBounds()) {
                f8.g gVarC = vVar.E0().c();
                v vVarI = (((gVarC instanceof f8.q0) && n7.m.y((f8.q0) gVarC, null, null)) ? v0VarE : v0VarE2).i(3, vVar);
                if (vVarI == null) {
                    return null;
                }
                if (vVarI != vVar && zArr != null) {
                    zArr[0] = true;
                }
                if (p0Var.f4835q) {
                    throw new IllegalStateException("Type parameter descriptor is already initialized: " + p0Var.K0());
                }
                if (!i(vVarI)) {
                    p0Var.f4834p.add(vVarI);
                }
            }
            if (p0Var.f4835q) {
                throw new IllegalStateException("Type parameter descriptor is already initialized: " + p0Var.K0());
            }
            p0Var.f4835q = true;
        }
        return v0VarE;
    }

    public static final i0 w(g8.j jVar) {
        q7.k.e(jVar, "<this>");
        return g0.toAttributes$default(k.f10563a, jVar, null, null, 6, null);
    }

    public static final z x(v vVar) {
        q7.k.e(vVar, "<this>");
        z0 z0VarH0 = vVar.H0();
        if (z0VarH0 instanceof p) {
            return ((p) z0VarH0).f10581h;
        }
        if (z0VarH0 instanceof z) {
            return (z) z0VarH0;
        }
        throw new a4.u();
    }

    public static final z y(z zVar, z zVar2) {
        q7.k.e(zVar, "<this>");
        q7.k.e(zVar2, "abbreviatedType");
        return i(zVar) ? zVar : new a(zVar, zVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final z0 z(z0 z0Var, v vVar) {
        q7.k.e(z0Var, "<this>");
        if (z0Var instanceof y0) {
            return z(((y0) z0Var).u0(), vVar);
        }
        if (vVar == null || vVar.equals(z0Var)) {
            return z0Var;
        }
        if (z0Var instanceof z) {
            return new c0((z) z0Var, vVar);
        }
        if (z0Var instanceof p) {
            return new r((p) z0Var, vVar);
        }
        throw new a4.u();
    }
}

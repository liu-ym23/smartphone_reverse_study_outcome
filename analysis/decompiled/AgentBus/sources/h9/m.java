package h9;

import c1.w;
import com.google.protobuf.a1;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import d7.r;
import f8.l0;
import f8.n0;
import f8.o;
import f8.t;
import f8.x;
import i8.i0;
import i8.j0;
import i8.k0;
import i8.r0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import o9.n;
import o9.p;
import t9.s;
import v9.m0;
import v9.q0;
import v9.v;
import v9.z;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final x f4246a = new x("ResolutionAnchorProvider", 0);

    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 12 || i2 == 23 || i2 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 12 || i2 == 23 || i2 == 25) ? 2 : 3];
        switch (i2) {
            case 1:
            case 4:
            case 8:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 33:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[0] = "source";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 24:
            case 26:
                objArr[0] = "enumClass";
                break;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
                objArr[0] = "descriptor";
                break;
            case 30:
            case 32:
            case 34:
                objArr[0] = "owner";
                break;
        }
        if (i2 == 12) {
            objArr[1] = "createSetter";
        } else if (i2 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i2 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 25:
                break;
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[2] = "createDefaultGetter";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[2] = "createGetter";
                break;
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 28:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 29:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case 33:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 34:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 12 && i2 != 23 && i2 != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static final void c(f8.e eVar, LinkedHashSet linkedHashSet, n nVar, boolean z4) {
        for (f8.j jVar : p.getContributedDescriptors$default(nVar, o9.f.f7912o, null, 2, null)) {
            if (jVar instanceof f8.e) {
                f8.e eVarG0 = (f8.e) jVar;
                if (eVarG0.Z()) {
                    e9.f name = eVarG0.getName();
                    q7.k.d(name, "descriptor.name");
                    f8.g gVarB = nVar.b(name, n8.c.f6880i);
                    eVarG0 = gVarB instanceof f8.e ? (f8.e) gVarB : gVarB instanceof s ? ((s) gVarB).G0() : null;
                }
                if (eVarG0 != null) {
                    int i2 = f.f4236a;
                    Iterator it = eVarG0.h().d().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (f.p((v) it.next(), eVar.a())) {
                                linkedHashSet.add(eVarG0);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z4) {
                        n nVarH0 = eVarG0.h0();
                        q7.k.d(nVarH0, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        c(eVar, linkedHashSet, nVarH0, z4);
                    }
                }
            }
        }
    }

    public static i8.v e(f8.b bVar, v vVar, e9.f fVar, g8.j jVar, int i2) {
        if (jVar == null) {
            a(33);
            throw null;
        }
        if (vVar == null) {
            return null;
        }
        p9.a aVar = new p9.a(bVar, vVar, fVar);
        ga.i iVar = e9.g.f3199a;
        return new i8.v(bVar, aVar, jVar, e9.f.e("_context_receiver_" + i2));
    }

    public static j0 f(l0 l0Var, g8.j jVar) {
        return l(l0Var, jVar, true, l0Var.q());
    }

    public static k0 g(l0 l0Var, g8.j jVar) {
        n0 n0VarQ = l0Var.q();
        if (n0VarQ != null) {
            return m(l0Var, jVar, g8.h.f3888a, true, l0Var.c(), n0VarQ);
        }
        a(6);
        throw null;
    }

    public static i0 h(i8.b bVar) {
        if (bVar == null) {
            a(26);
            throw null;
        }
        f8.e eVarD = f8.v.d(f.d(bVar), e9.i.f3226t);
        if (eVarD == null) {
            return null;
        }
        f8.n nVar = o.f3492e;
        i0 i0VarH0 = i0.H0(bVar, 1, nVar, false, c8.n.f2057b, 4, bVar.q());
        j0 j0Var = new j0(i0VarH0, g8.h.f3888a, 1, nVar, false, false, false, 4, null, bVar.q());
        i0VarH0.K0(j0Var, null, null, null);
        v9.i0.f10557g.getClass();
        v9.i0 i0Var = v9.i0.f10558h;
        m0 m0VarH = eVarD.h();
        List listSingletonList = Collections.singletonList(new q0(1, bVar.k()));
        q7.k.e(i0Var, "attributes");
        q7.k.e(m0VarH, "constructor");
        q7.k.e(listSingletonList, "arguments");
        z zVarR = v9.d.r(listSingletonList, i0Var, m0VarH, false);
        List list = Collections.EMPTY_LIST;
        i0VarH0.N0(zVarR, list, null, null, list);
        j0Var.J0(i0VarH0.f());
        return i0VarH0;
    }

    public static i8.l0 i(i8.b bVar) {
        if (bVar == null) {
            a(24);
            throw null;
        }
        i8.l0 l0VarR0 = i8.l0.R0(bVar, c8.n.f2058c, 4, bVar.q());
        r0 r0Var = new r0(l0VarR0, null, 0, g8.h.f3888a, e9.f.e("value"), l9.d.e(bVar).u(), false, false, false, null, bVar.q());
        List list = Collections.EMPTY_LIST;
        return l0VarR0.L0(null, null, list, list, Collections.singletonList(r0Var), bVar.k(), 1, o.f3492e);
    }

    public static i8.l0 j(i8.b bVar) {
        if (bVar == null) {
            a(22);
            throw null;
        }
        i8.l0 l0VarR0 = i8.l0.R0(bVar, c8.n.f2056a, 4, bVar.q());
        List list = Collections.EMPTY_LIST;
        return l0VarR0.L0(null, null, list, list, list, l9.d.e(bVar).h(bVar.k()), 1, o.f3492e);
    }

    public static i8.v k(f8.b bVar, v vVar, g8.j jVar) {
        if (vVar == null) {
            return null;
        }
        return new i8.v(bVar, new p9.b(bVar, vVar), jVar);
    }

    public static j0 l(l0 l0Var, g8.j jVar, boolean z4, n0 n0Var) {
        if (jVar == null) {
            a(18);
            throw null;
        }
        if (n0Var != null) {
            return new j0(l0Var, jVar, l0Var.i(), l0Var.c(), z4, false, false, 1, null, n0Var);
        }
        a(19);
        throw null;
    }

    public static k0 m(l0 l0Var, g8.j jVar, g8.j jVar2, boolean z4, f8.n nVar, n0 n0Var) {
        if (jVar == null) {
            a(8);
            throw null;
        }
        if (jVar2 == null) {
            a(9);
            throw null;
        }
        if (nVar == null) {
            a(10);
            throw null;
        }
        if (n0Var == null) {
            a(11);
            throw null;
        }
        k0 k0Var = new k0(l0Var, jVar, l0Var.i(), nVar, z4, false, false, 1, null, n0Var);
        k0Var.f4821r = k0.I0(k0Var, l0Var.getType(), jVar2);
        return k0Var;
    }

    public static boolean n(t tVar) {
        return tVar.getKind() == 4 && f.n(tVar.p(), 3);
    }

    public static final Collection o(Collection collection, p7.k kVar) {
        q7.k.e(collection, "<this>");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        ea.h hVar = new ea.h();
        while (!linkedList.isEmpty()) {
            Object objN0 = r.N0(linkedList);
            ea.h hVar2 = new ea.h();
            ArrayList arrayListG = l.g(objN0, linkedList, kVar, new w(2, hVar2));
            if (arrayListG.size() == 1 && hVar2.isEmpty()) {
                Object objE1 = r.e1(arrayListG);
                q7.k.d(objE1, "overridableGroup.single()");
                hVar.add(objE1);
            } else {
                Object objS = l.s(arrayListG, kVar);
                f8.b bVar = (f8.b) kVar.invoke(objS);
                Iterator it = arrayListG.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    q7.k.d(next, "it");
                    if (!l.k(bVar, (f8.b) kVar.invoke(next))) {
                        hVar2.add(next);
                    }
                }
                if (!hVar2.isEmpty()) {
                    hVar.addAll(hVar2);
                }
                hVar.add(objS);
            }
        }
        return hVar;
    }

    public abstract void b(f8.c cVar);

    public abstract void d(f8.c cVar, f8.c cVar2);

    public void p(f8.c cVar, Collection collection) {
        q7.k.e(cVar, "member");
        cVar.d0(collection);
    }
}

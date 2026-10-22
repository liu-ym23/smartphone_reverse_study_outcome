package C9;

import C9.o;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ma.AbstractC4927g;
import ma.x;
import ya.AbstractC5990d0;
import ya.B0;
import ya.S;
import ya.V;
import ya.t0;

/* loaded from: classes5.dex */
public final class i {
    public static final int a(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        F9.c cVarD = s10.getAnnotations().d(o.a.f1852D);
        if (cVarD == null) {
            return 0;
        }
        AbstractC4927g abstractC4927g = (AbstractC4927g) kotlin.collections.a.j(cVarD.a(), o.f1836q);
        kotlin.jvm.internal.p.g(abstractC4927g, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((ma.n) abstractC4927g).b().intValue();
    }

    public static final AbstractC5990d0 b(j builtIns, F9.g annotations, S s10, List<? extends S> contextReceiverTypes, List<? extends S> parameterTypes, List<ga.e> list, S returnType, boolean z10) {
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(contextReceiverTypes, "contextReceiverTypes");
        kotlin.jvm.internal.p.i(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.p.i(returnType, "returnType");
        List<B0> listG = g(s10, contextReceiverTypes, parameterTypes, list, returnType, builtIns);
        InterfaceC0797b interfaceC0797bF = f(builtIns, parameterTypes.size() + contextReceiverTypes.size() + (s10 == null ? 0 : 1), z10);
        if (s10 != null) {
            annotations = v(annotations, builtIns);
        }
        if (!contextReceiverTypes.isEmpty()) {
            annotations = u(annotations, builtIns, contextReceiverTypes.size());
        }
        return V.h(t0.b(annotations), interfaceC0797bF, listG);
    }

    public static final ga.e d(S s10) {
        String strB;
        kotlin.jvm.internal.p.i(s10, "<this>");
        F9.c cVarD = s10.getAnnotations().d(o.a.f1854E);
        if (cVarD == null) {
            return null;
        }
        Object objY0 = F.Y0(cVarD.a().values());
        x xVar = objY0 instanceof x ? (x) objY0 : null;
        if (xVar != null && (strB = xVar.b()) != null) {
            if (!ga.e.l(strB)) {
                strB = null;
            }
            if (strB != null) {
                return ga.e.j(strB);
            }
        }
        return null;
    }

    public static final List<S> e(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        p(s10);
        int iA = a(s10);
        if (iA == 0) {
            return C1173v.m();
        }
        List<B0> listSubList = s10.F0().subList(0, iA);
        ArrayList arrayList = new ArrayList(C1174w.x(listSubList, 10));
        Iterator<T> it = listSubList.iterator();
        while (it.hasNext()) {
            arrayList.add(((B0) it.next()).getType());
        }
        return arrayList;
    }

    public static final InterfaceC0797b f(j builtIns, int i10, boolean z10) {
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        InterfaceC0797b interfaceC0797bY = z10 ? builtIns.Y(i10) : builtIns.D(i10);
        kotlin.jvm.internal.p.f(interfaceC0797bY);
        return interfaceC0797bY;
    }

    public static final List<B0> g(S s10, List<? extends S> contextReceiverTypes, List<? extends S> parameterTypes, List<ga.e> list, S returnType, j builtIns) {
        ga.e eVar;
        j jVar;
        kotlin.jvm.internal.p.i(contextReceiverTypes, "contextReceiverTypes");
        kotlin.jvm.internal.p.i(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.p.i(returnType, "returnType");
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        int i10 = 0;
        ArrayList arrayList = new ArrayList(parameterTypes.size() + contextReceiverTypes.size() + (s10 != null ? 1 : 0) + 1);
        List<? extends S> list2 = contextReceiverTypes;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(Da.d.d((S) it.next()));
        }
        arrayList.addAll(arrayList2);
        Ia.a.a(arrayList, s10 != null ? Da.d.d(s10) : null);
        for (Object obj : parameterTypes) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            S sC = (S) obj;
            if (list == null || (eVar = list.get(i10)) == null || eVar.k()) {
                eVar = null;
            }
            if (eVar != null) {
                ga.c cVar = o.a.f1854E;
                ga.e eVar2 = o.f1832m;
                String strB = eVar.b();
                kotlin.jvm.internal.p.h(strB, "asString(...)");
                Map mapF = Q.f(Y8.j.a(eVar2, new x(strB)));
                jVar = builtIns;
                sC = Da.d.C(sC, F9.g.f2609m0.a(F.Q0(sC.getAnnotations(), new F9.k(jVar, cVar, mapF, false, 8, null))));
            } else {
                jVar = builtIns;
            }
            arrayList.add(Da.d.d(sC));
            i10 = i11;
            builtIns = jVar;
        }
        arrayList.add(Da.d.d(returnType));
        return arrayList;
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.e h(InterfaceC0803h interfaceC0803h) {
        kotlin.jvm.internal.p.i(interfaceC0803h, "<this>");
        if ((interfaceC0803h instanceof InterfaceC0797b) && j.C0(interfaceC0803h)) {
            return i(DescriptorUtilsKt.p(interfaceC0803h));
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.e i(ga.d dVar) {
        if (!dVar.f() || dVar.e()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.builtins.functions.f fVarA = kotlin.reflect.jvm.internal.impl.builtins.functions.f.f34972c.a();
        ga.c cVarD = dVar.m().d();
        String strB = dVar.j().b();
        kotlin.jvm.internal.p.h(strB, "asString(...)");
        return fVarA.b(cVarD, strB);
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.e j(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD != null) {
            return h(interfaceC0799dD);
        }
        return null;
    }

    public static final S k(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        p(s10);
        if (!t(s10)) {
            return null;
        }
        return s10.F0().get(a(s10)).getType();
    }

    public static final S l(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        p(s10);
        S type = ((B0) F.C0(s10.F0())).getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        return type;
    }

    public static final List<B0> m(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        p(s10);
        return s10.F0().subList(a(s10) + (n(s10) ? 1 : 0), r0.size() - 1);
    }

    public static final boolean n(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        return p(s10) && t(s10);
    }

    public static final boolean o(InterfaceC0803h interfaceC0803h) {
        kotlin.jvm.internal.p.i(interfaceC0803h, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.functions.e eVarH = h(interfaceC0803h);
        return kotlin.jvm.internal.p.d(eVarH, e.a.f34968f) || kotlin.jvm.internal.p.d(eVarH, e.d.f34971f);
    }

    public static final boolean p(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        return interfaceC0799dD != null && o(interfaceC0799dD);
    }

    public static final boolean q(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        return kotlin.jvm.internal.p.d(j(s10), e.a.f34968f);
    }

    public static final boolean r(ga.d fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return fqName.l(o.f1809A) && kotlin.jvm.internal.p.d(i(fqName), e.a.f34968f);
    }

    public static final boolean s(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        return kotlin.jvm.internal.p.d(j(s10), e.d.f34971f);
    }

    public static final boolean t(S s10) {
        return s10.getAnnotations().d(o.a.f1850C) != null;
    }

    public static final F9.g u(F9.g gVar, j builtIns, int i10) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        ga.c cVar = o.a.f1852D;
        return gVar.E(cVar) ? gVar : F9.g.f2609m0.a(F.Q0(gVar, new F9.k(builtIns, cVar, Q.f(Y8.j.a(o.f1836q, new ma.n(i10))), false, 8, null)));
    }

    public static final F9.g v(F9.g gVar, j builtIns) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        ga.c cVar = o.a.f1850C;
        return gVar.E(cVar) ? gVar : F9.g.f2609m0.a(F.Q0(gVar, new F9.k(builtIns, cVar, kotlin.collections.a.i(), false, 8, null)));
    }
}

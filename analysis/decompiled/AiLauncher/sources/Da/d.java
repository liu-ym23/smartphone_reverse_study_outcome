package Da;

import C9.j;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0800e;
import E9.a0;
import E9.b0;
import F9.g;
import Z8.C1174w;
import Z8.F;
import Z8.IndexedValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import p9.InterfaceC5074l;
import ya.AbstractC5974I;
import ya.AbstractC5989d;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C6004k0;
import ya.C6017x;
import ya.D0;
import ya.F0;
import ya.H0;
import ya.J0;
import ya.K0;
import ya.S;
import ya.V;
import ya.m0;
import ya.t0;
import ya.v0;

/* loaded from: classes5.dex */
public final class d {
    public static final S A(S s10) {
        p.i(s10, "<this>");
        S sN = H0.n(s10);
        p.h(sN, "makeNotNullable(...)");
        return sN;
    }

    public static final S B(S s10) {
        p.i(s10, "<this>");
        S sO = H0.o(s10);
        p.h(sO, "makeNullable(...)");
        return sO;
    }

    public static final S C(S s10, g newAnnotations) {
        p.i(s10, "<this>");
        p.i(newAnnotations, "newAnnotations");
        return (s10.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? s10 : s10.K0().N0(t0.a(s10.G0(), newAnnotations));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [ya.K0] */
    public static final S D(S s10) {
        AbstractC5990d0 abstractC5990d0F;
        p.i(s10, "<this>");
        K0 K02 = s10.K0();
        if (K02 instanceof AbstractC5974I) {
            AbstractC5974I abstractC5974I = (AbstractC5974I) K02;
            AbstractC5990d0 abstractC5990d0P0 = abstractC5974I.P0();
            if (!abstractC5990d0P0.H0().getParameters().isEmpty() && abstractC5990d0P0.H0().d() != null) {
                List<b0> parameters = abstractC5990d0P0.H0().getParameters();
                p.h(parameters, "getParameters(...)");
                List<b0> list = parameters;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C6004k0((b0) it.next()));
                }
                abstractC5990d0P0 = F0.f(abstractC5990d0P0, arrayList, null, 2, null);
            }
            AbstractC5990d0 abstractC5990d0Q0 = abstractC5974I.Q0();
            if (!abstractC5990d0Q0.H0().getParameters().isEmpty() && abstractC5990d0Q0.H0().d() != null) {
                List<b0> parameters2 = abstractC5990d0Q0.H0().getParameters();
                p.h(parameters2, "getParameters(...)");
                List<b0> list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new C6004k0((b0) it2.next()));
                }
                abstractC5990d0Q0 = F0.f(abstractC5990d0Q0, arrayList2, null, 2, null);
            }
            abstractC5990d0F = V.e(abstractC5990d0P0, abstractC5990d0Q0);
        } else {
            if (!(K02 instanceof AbstractC5990d0)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC5990d0 abstractC5990d0 = (AbstractC5990d0) K02;
            boolean zIsEmpty = abstractC5990d0.H0().getParameters().isEmpty();
            abstractC5990d0F = abstractC5990d0;
            if (!zIsEmpty) {
                InterfaceC0799d interfaceC0799dD = abstractC5990d0.H0().d();
                abstractC5990d0F = abstractC5990d0;
                if (interfaceC0799dD != null) {
                    List<b0> parameters3 = abstractC5990d0.H0().getParameters();
                    p.h(parameters3, "getParameters(...)");
                    List<b0> list3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(C1174w.x(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new C6004k0((b0) it3.next()));
                    }
                    abstractC5990d0F = F0.f(abstractC5990d0, arrayList3, null, 2, null);
                }
            }
        }
        return J0.b(abstractC5990d0F, K02);
    }

    public static final boolean E(S s10) {
        p.i(s10, "<this>");
        return e(s10, c.f2323a);
    }

    public static final boolean F(K0 it) {
        p.i(it, "it");
        InterfaceC0799d interfaceC0799dD = it.H0().d();
        if (interfaceC0799dD != null) {
            return (interfaceC0799dD instanceof a0) || (interfaceC0799dD instanceof b0);
        }
        return false;
    }

    public static final B0 d(S s10) {
        p.i(s10, "<this>");
        return new D0(s10);
    }

    public static final boolean e(S s10, InterfaceC5074l<? super K0, Boolean> predicate) {
        p.i(s10, "<this>");
        p.i(predicate, "predicate");
        return H0.c(s10, predicate);
    }

    public static final boolean f(S s10, v0 v0Var, Set<? extends b0> set) {
        boolean zF;
        if (p.d(s10.H0(), v0Var)) {
            return true;
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        InterfaceC0800e interfaceC0800e = interfaceC0799dD instanceof InterfaceC0800e ? (InterfaceC0800e) interfaceC0799dD : null;
        List<b0> listO = interfaceC0800e != null ? interfaceC0800e.o() : null;
        Iterable<IndexedValue> iterableU1 = F.u1(s10.F0());
        if ((iterableU1 instanceof Collection) && ((Collection) iterableU1).isEmpty()) {
            return false;
        }
        for (IndexedValue indexedValue : iterableU1) {
            int index = indexedValue.getIndex();
            B0 b02 = (B0) indexedValue.b();
            b0 b0Var = listO != null ? (b0) F.t0(listO, index) : null;
            if ((b0Var == null || set == null || !set.contains(b0Var)) && !b02.b()) {
                S type = b02.getType();
                p.h(type, "getType(...)");
                zF = f(type, v0Var, set);
            } else {
                zF = false;
            }
            if (zF) {
                return true;
            }
        }
        return false;
    }

    public static final boolean g(S s10) {
        p.i(s10, "<this>");
        return e(s10, b.f2322a);
    }

    public static final boolean h(K0 it) {
        p.i(it, "it");
        InterfaceC0799d interfaceC0799dD = it.H0().d();
        if (interfaceC0799dD != null) {
            return x(interfaceC0799dD);
        }
        return false;
    }

    public static final boolean i(S s10) {
        p.i(s10, "<this>");
        return H0.c(s10, a.f2321a);
    }

    public static final Boolean j(K0 k02) {
        return Boolean.valueOf(H0.m(k02));
    }

    public static final B0 k(S type, Variance projectionKind, b0 b0Var) {
        p.i(type, "type");
        p.i(projectionKind, "projectionKind");
        if ((b0Var != null ? b0Var.l() : null) == projectionKind) {
            projectionKind = Variance.INVARIANT;
        }
        return new D0(projectionKind, type);
    }

    public static final Set<b0> l(S s10, Set<? extends b0> set) {
        p.i(s10, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m(s10, s10, linkedHashSet, set);
        return linkedHashSet;
    }

    public static final void m(S s10, S s11, Set<b0> set, Set<? extends b0> set2) {
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD instanceof b0) {
            if (!p.d(s10.H0(), s11.H0())) {
                set.add(interfaceC0799dD);
                return;
            }
            for (S s12 : ((b0) interfaceC0799dD).getUpperBounds()) {
                p.f(s12);
                m(s12, s11, set, set2);
            }
            return;
        }
        InterfaceC0799d interfaceC0799dD2 = s10.H0().d();
        InterfaceC0800e interfaceC0800e = interfaceC0799dD2 instanceof InterfaceC0800e ? (InterfaceC0800e) interfaceC0799dD2 : null;
        List<b0> listO = interfaceC0800e != null ? interfaceC0800e.o() : null;
        int i10 = 0;
        for (B0 b02 : s10.F0()) {
            int i11 = i10 + 1;
            b0 b0Var = listO != null ? (b0) F.t0(listO, i10) : null;
            if ((b0Var == null || set2 == null || !set2.contains(b0Var)) && !b02.b() && !F.f0(set, b02.getType().H0().d()) && !p.d(b02.getType().H0(), s11.H0())) {
                S type = b02.getType();
                p.h(type, "getType(...)");
                m(type, s11, set, set2);
            }
            i10 = i11;
        }
    }

    public static final j n(S s10) {
        p.i(s10, "<this>");
        j jVarG = s10.H0().g();
        p.h(jVarG, "getBuiltIns(...)");
        return jVarG;
    }

    public static final S o(b0 b0Var) {
        Object obj;
        p.i(b0Var, "<this>");
        List<S> upperBounds = b0Var.getUpperBounds();
        p.h(upperBounds, "getUpperBounds(...)");
        upperBounds.isEmpty();
        List<S> upperBounds2 = b0Var.getUpperBounds();
        p.h(upperBounds2, "getUpperBounds(...)");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC0799d interfaceC0799dD = ((S) next).H0().d();
            InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
            if (interfaceC0797b != null && interfaceC0797b.getKind() != ClassKind.INTERFACE && interfaceC0797b.getKind() != ClassKind.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        S s10 = (S) obj;
        if (s10 != null) {
            return s10;
        }
        List<S> upperBounds3 = b0Var.getUpperBounds();
        p.h(upperBounds3, "getUpperBounds(...)");
        Object objQ0 = F.q0(upperBounds3);
        p.h(objQ0, "first(...)");
        return (S) objQ0;
    }

    public static final boolean p(b0 typeParameter) {
        p.i(typeParameter, "typeParameter");
        return r(typeParameter, null, null, 6, null);
    }

    public static final boolean q(b0 typeParameter, v0 v0Var, Set<? extends b0> set) {
        p.i(typeParameter, "typeParameter");
        List<S> upperBounds = typeParameter.getUpperBounds();
        p.h(upperBounds, "getUpperBounds(...)");
        List<S> list = upperBounds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (S s10 : list) {
            p.f(s10);
            if (f(s10, typeParameter.n().H0(), set) && (v0Var == null || p.d(s10.H0(), v0Var))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean r(b0 b0Var, v0 v0Var, Set set, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            v0Var = null;
        }
        if ((i10 & 4) != 0) {
            set = null;
        }
        return q(b0Var, v0Var, set);
    }

    public static final boolean s(S s10) {
        p.i(s10, "<this>");
        return j.g0(s10);
    }

    public static final boolean t(S s10) {
        p.i(s10, "<this>");
        return j.o0(s10);
    }

    public static final boolean u(S s10) {
        p.i(s10, "<this>");
        if (s10 instanceof AbstractC5989d) {
            return true;
        }
        return (s10 instanceof C6017x) && (((C6017x) s10).T0() instanceof AbstractC5989d);
    }

    public static final boolean v(S s10) {
        p.i(s10, "<this>");
        if (s10 instanceof m0) {
            return true;
        }
        return (s10 instanceof C6017x) && (((C6017x) s10).T0() instanceof m0);
    }

    public static final boolean w(S s10, S superType) {
        p.i(s10, "<this>");
        p.i(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a.b(s10, superType);
    }

    public static final boolean x(InterfaceC0799d interfaceC0799d) {
        p.i(interfaceC0799d, "<this>");
        return (interfaceC0799d instanceof b0) && (((b0) interfaceC0799d).b() instanceof a0);
    }

    public static final boolean y(S s10) {
        p.i(s10, "<this>");
        return H0.m(s10);
    }

    public static final boolean z(S type) {
        p.i(type, "type");
        return (type instanceof Aa.g) && ((Aa.g) type).R0().isUnresolved();
    }
}

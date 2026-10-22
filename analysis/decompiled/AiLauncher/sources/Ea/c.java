package Ea;

import C9.j;
import E9.b0;
import Z8.C1174w;
import Z8.F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import la.C4882e;
import la.InterfaceC4879b;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5977L;
import ya.D0;
import ya.F0;
import ya.H0;
import ya.J0;
import ya.K0;
import ya.S;
import ya.V;
import ya.v0;
import ya.w0;

/* loaded from: classes5.dex */
public final class c {

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2496a;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2496a = iArr;
        }
    }

    public static final class b extends w0 {
        @Override // ya.w0
        public B0 k(v0 key) {
            p.i(key, "key");
            InterfaceC4879b interfaceC4879b = key instanceof InterfaceC4879b ? (InterfaceC4879b) key : null;
            if (interfaceC4879b == null) {
                return null;
            }
            return interfaceC4879b.c().b() ? new D0(Variance.OUT_VARIANCE, interfaceC4879b.c().getType()) : interfaceC4879b.c();
        }
    }

    public static final Ea.a<S> b(S type) {
        Object objG;
        p.i(type, "type");
        if (C5977L.b(type)) {
            Ea.a<S> aVarB = b(C5977L.c(type));
            Ea.a<S> aVarB2 = b(C5977L.d(type));
            return new Ea.a<>(J0.b(V.e(C5977L.c(aVarB.c()), C5977L.d(aVarB2.c())), type), J0.b(V.e(C5977L.c(aVarB.d()), C5977L.d(aVarB2.d())), type));
        }
        v0 v0VarH0 = type.H0();
        if (C4882e.f(type)) {
            p.g(v0VarH0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            B0 b0C = ((InterfaceC4879b) v0VarH0).c();
            S type2 = b0C.getType();
            p.h(type2, "getType(...)");
            S sC = c(type2, type);
            int i10 = a.f2496a[b0C.c().ordinal()];
            if (i10 == 2) {
                return new Ea.a<>(sC, Da.d.n(type).J());
            }
            if (i10 == 3) {
                AbstractC5990d0 abstractC5990d0I = Da.d.n(type).I();
                p.h(abstractC5990d0I, "getNothingType(...)");
                return new Ea.a<>(c(abstractC5990d0I, type), sC);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + b0C);
        }
        if (type.F0().isEmpty() || type.F0().size() != v0VarH0.getParameters().size()) {
            return new Ea.a<>(type, type);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<B0> listF0 = type.F0();
        List<b0> parameters = v0VarH0.getParameters();
        p.h(parameters, "getParameters(...)");
        for (Pair pair : F.w1(listF0, parameters)) {
            B0 b02 = (B0) pair.a();
            b0 b0Var = (b0) pair.b();
            p.f(b0Var);
            d dVarI = i(b02, b0Var);
            if (b02.b()) {
                arrayList.add(dVarI);
                arrayList2.add(dVarI);
            } else {
                Ea.a<d> aVarF = f(dVarI);
                d dVarA = aVarF.a();
                d dVarB = aVarF.b();
                arrayList.add(dVarA);
                arrayList2.add(dVarB);
            }
        }
        boolean z10 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!((d) it.next()).d()) {
                    z10 = true;
                    break;
                }
            }
        }
        if (z10) {
            objG = Da.d.n(type).I();
            p.h(objG, "getNothingType(...)");
        } else {
            objG = g(type, arrayList);
        }
        return new Ea.a<>(objG, g(type, arrayList2));
    }

    public static final S c(S s10, S s11) {
        S sQ = H0.q(s10, s11.I0());
        p.h(sQ, "makeNullableIfNeeded(...)");
        return sQ;
    }

    public static final B0 d(B0 b02, boolean z10) {
        if (b02 == null) {
            return null;
        }
        if (!b02.b()) {
            S type = b02.getType();
            p.h(type, "getType(...)");
            if (H0.c(type, Ea.b.f2495a)) {
                Variance varianceC = b02.c();
                p.h(varianceC, "getProjectionKind(...)");
                return varianceC == Variance.OUT_VARIANCE ? new D0(varianceC, b(type).d()) : z10 ? new D0(varianceC, b(type).c()) : h(b02);
            }
        }
        return b02;
    }

    public static final Boolean e(K0 k02) {
        p.f(k02);
        return Boolean.valueOf(C4882e.f(k02));
    }

    public static final Ea.a<d> f(d dVar) {
        Ea.a<S> aVarB = b(dVar.a());
        S sA = aVarB.a();
        S sB = aVarB.b();
        Ea.a<S> aVarB2 = b(dVar.b());
        return new Ea.a<>(new d(dVar.c(), sB, aVarB2.a()), new d(dVar.c(), sA, aVarB2.b()));
    }

    public static final S g(S s10, List<d> list) {
        s10.F0().size();
        list.size();
        List<d> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(j((d) it.next()));
        }
        return F0.e(s10, arrayList, null, null, 6, null);
    }

    public static final B0 h(B0 b02) {
        TypeSubstitutor typeSubstitutorH = TypeSubstitutor.h(new b());
        p.h(typeSubstitutorH, "create(...)");
        return typeSubstitutorH.u(b02);
    }

    public static final d i(B0 b02, b0 b0Var) {
        int i10 = a.f2496a[TypeSubstitutor.d(b0Var.l(), b02).ordinal()];
        if (i10 == 1) {
            S type = b02.getType();
            p.h(type, "getType(...)");
            S type2 = b02.getType();
            p.h(type2, "getType(...)");
            return new d(b0Var, type, type2);
        }
        if (i10 == 2) {
            S type3 = b02.getType();
            p.h(type3, "getType(...)");
            AbstractC5990d0 abstractC5990d0J = DescriptorUtilsKt.m(b0Var).J();
            p.h(abstractC5990d0J, "getNullableAnyType(...)");
            return new d(b0Var, type3, abstractC5990d0J);
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC5990d0 abstractC5990d0I = DescriptorUtilsKt.m(b0Var).I();
        p.h(abstractC5990d0I, "getNothingType(...)");
        S type4 = b02.getType();
        p.h(type4, "getType(...)");
        return new d(b0Var, abstractC5990d0I, type4);
    }

    public static final B0 j(d dVar) {
        dVar.d();
        if (!p.d(dVar.a(), dVar.b())) {
            Variance varianceL = dVar.c().l();
            Variance variance = Variance.IN_VARIANCE;
            if (varianceL != variance) {
                if ((!j.o0(dVar.a()) || dVar.c().l() == variance) && j.q0(dVar.b())) {
                    return new D0(k(dVar, variance), dVar.a());
                }
                return new D0(k(dVar, Variance.OUT_VARIANCE), dVar.b());
            }
        }
        return new D0(dVar.a());
    }

    public static final Variance k(d dVar, Variance variance) {
        return variance == dVar.c().l() ? Variance.INVARIANT : variance;
    }
}

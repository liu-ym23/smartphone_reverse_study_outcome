package ya;

import E9.InterfaceC0799d;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ra.InterfaceC5238k;
import ya.p0;

/* loaded from: classes5.dex */
public final class n0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f44104c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final n0 f44105d = new n0(p0.a.f44120a, false);

    /* renamed from: a, reason: collision with root package name */
    public final p0 f44106a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f44107b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void b(int i10, E9.a0 a0Var) {
            if (i10 <= 100) {
                return;
            }
            throw new AssertionError("Too deep recursion while expanding type alias " + a0Var.getName());
        }

        public a() {
        }
    }

    public n0(p0 reportStrategy, boolean z10) {
        kotlin.jvm.internal.p.i(reportStrategy, "reportStrategy");
        this.f44106a = reportStrategy;
        this.f44107b = z10;
    }

    public final void a(F9.g gVar, F9.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<F9.c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().f());
        }
        for (F9.c cVar : gVar2) {
            if (hashSet.contains(cVar.f())) {
                this.f44106a.c(cVar);
            }
        }
    }

    public final void b(S s10, S s11) {
        TypeSubstitutor typeSubstitutorG = TypeSubstitutor.g(s11);
        kotlin.jvm.internal.p.h(typeSubstitutorG, "create(...)");
        int i10 = 0;
        for (Object obj : s11.F0()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            B0 b02 = (B0) obj;
            if (!b02.b()) {
                S type = b02.getType();
                kotlin.jvm.internal.p.h(type, "getType(...)");
                if (!Da.d.g(type)) {
                    B0 b03 = s10.F0().get(i10);
                    E9.b0 b0Var = s10.H0().getParameters().get(i10);
                    if (this.f44107b) {
                        p0 p0Var = this.f44106a;
                        S type2 = b03.getType();
                        kotlin.jvm.internal.p.h(type2, "getType(...)");
                        S type3 = b02.getType();
                        kotlin.jvm.internal.p.h(type3, "getType(...)");
                        kotlin.jvm.internal.p.f(b0Var);
                        p0Var.a(typeSubstitutorG, type2, type3, b0Var);
                    }
                }
            }
            i10 = i11;
        }
    }

    public final C5969D c(C5969D c5969d, s0 s0Var) {
        return c5969d.N0(h(c5969d, s0Var));
    }

    public final AbstractC5990d0 d(AbstractC5990d0 abstractC5990d0, s0 s0Var) {
        return W.a(abstractC5990d0) ? abstractC5990d0 : F0.f(abstractC5990d0, null, h(abstractC5990d0, s0Var), 1, null);
    }

    public final AbstractC5990d0 e(AbstractC5990d0 abstractC5990d0, S s10) {
        AbstractC5990d0 abstractC5990d0R = H0.r(abstractC5990d0, s10.I0());
        kotlin.jvm.internal.p.h(abstractC5990d0R, "makeNullableIfNeeded(...)");
        return abstractC5990d0R;
    }

    public final AbstractC5990d0 f(AbstractC5990d0 abstractC5990d0, S s10) {
        return d(e(abstractC5990d0, s10), s10.G0());
    }

    public final AbstractC5990d0 g(o0 o0Var, s0 s0Var, boolean z10) {
        v0 v0VarJ = o0Var.b().j();
        kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
        return V.o(s0Var, v0VarJ, o0Var.a(), z10, InterfaceC5238k.b.f38898b);
    }

    public final s0 h(S s10, s0 s0Var) {
        return W.a(s10) ? s10.G0() : s0Var.k(s10.G0());
    }

    public final AbstractC5990d0 i(o0 typeAliasExpansion, s0 attributes) {
        kotlin.jvm.internal.p.i(typeAliasExpansion, "typeAliasExpansion");
        kotlin.jvm.internal.p.i(attributes, "attributes");
        return k(typeAliasExpansion, attributes, false, 0, true);
    }

    public final B0 j(B0 b02, o0 o0Var, int i10) {
        K0 K02 = b02.getType().K0();
        if (!C5970E.a(K02)) {
            AbstractC5990d0 abstractC5990d0A = F0.a(K02);
            if (!W.a(abstractC5990d0A) && Da.d.E(abstractC5990d0A)) {
                v0 v0VarH0 = abstractC5990d0A.H0();
                InterfaceC0799d interfaceC0799dD = v0VarH0.d();
                v0VarH0.getParameters().size();
                abstractC5990d0A.F0().size();
                if (!(interfaceC0799dD instanceof E9.b0)) {
                    if (!(interfaceC0799dD instanceof E9.a0)) {
                        AbstractC5990d0 abstractC5990d0M = m(abstractC5990d0A, o0Var, i10);
                        b(abstractC5990d0A, abstractC5990d0M);
                        return new D0(b02.c(), abstractC5990d0M);
                    }
                    E9.a0 a0Var = (E9.a0) interfaceC0799dD;
                    if (o0Var.d(a0Var)) {
                        this.f44106a.b(a0Var);
                        Variance variance = Variance.INVARIANT;
                        ErrorTypeKind errorTypeKind = ErrorTypeKind.RECURSIVE_TYPE_ALIAS;
                        String string = a0Var.getName().toString();
                        kotlin.jvm.internal.p.h(string, "toString(...)");
                        return new D0(variance, Aa.i.d(errorTypeKind, string));
                    }
                    List<B0> listF0 = abstractC5990d0A.F0();
                    ArrayList arrayList = new ArrayList(C1174w.x(listF0, 10));
                    int i11 = 0;
                    for (Object obj : listF0) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            C1173v.w();
                        }
                        arrayList.add(l((B0) obj, o0Var, v0VarH0.getParameters().get(i11), i10 + 1));
                        i11 = i12;
                    }
                    AbstractC5990d0 abstractC5990d0K = k(o0.f44115e.a(o0Var, a0Var, arrayList), abstractC5990d0A.G0(), abstractC5990d0A.I0(), i10 + 1, false);
                    AbstractC5990d0 abstractC5990d0M2 = m(abstractC5990d0A, o0Var, i10);
                    if (!C5970E.a(abstractC5990d0K)) {
                        abstractC5990d0K = C5998h0.j(abstractC5990d0K, abstractC5990d0M2);
                    }
                    return new D0(b02.c(), abstractC5990d0K);
                }
            }
        }
        return b02;
    }

    public final AbstractC5990d0 k(o0 o0Var, s0 s0Var, boolean z10, int i10, boolean z11) {
        B0 b0L = l(new D0(Variance.INVARIANT, o0Var.b().n0()), o0Var, null, i10);
        S type = b0L.getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        AbstractC5990d0 abstractC5990d0A = F0.a(type);
        if (W.a(abstractC5990d0A)) {
            return abstractC5990d0A;
        }
        b0L.c();
        a(abstractC5990d0A.getAnnotations(), C6012s.a(s0Var));
        AbstractC5990d0 abstractC5990d0R = H0.r(d(abstractC5990d0A, s0Var), z10);
        kotlin.jvm.internal.p.h(abstractC5990d0R, "let(...)");
        return z11 ? C5998h0.j(abstractC5990d0R, g(o0Var, s0Var, z10)) : abstractC5990d0R;
    }

    public final B0 l(B0 b02, o0 o0Var, E9.b0 b0Var, int i10) {
        Variance varianceL;
        Variance variance;
        Variance variance2;
        f44104c.b(i10, o0Var.b());
        if (b02.b()) {
            kotlin.jvm.internal.p.f(b0Var);
            B0 b0S = H0.s(b0Var);
            kotlin.jvm.internal.p.h(b0S, "makeStarProjection(...)");
            return b0S;
        }
        S type = b02.getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        B0 b0C = o0Var.c(type.H0());
        if (b0C == null) {
            return j(b02, o0Var, i10);
        }
        if (b0C.b()) {
            kotlin.jvm.internal.p.f(b0Var);
            B0 b0S2 = H0.s(b0Var);
            kotlin.jvm.internal.p.h(b0S2, "makeStarProjection(...)");
            return b0S2;
        }
        K0 K02 = b0C.getType().K0();
        Variance varianceC = b0C.c();
        kotlin.jvm.internal.p.h(varianceC, "getProjectionKind(...)");
        Variance varianceC2 = b02.c();
        kotlin.jvm.internal.p.h(varianceC2, "getProjectionKind(...)");
        if (varianceC2 != varianceC && varianceC2 != (variance2 = Variance.INVARIANT)) {
            if (varianceC == variance2) {
                varianceC = varianceC2;
            } else {
                this.f44106a.d(o0Var.b(), b0Var, K02);
            }
        }
        if (b0Var == null || (varianceL = b0Var.l()) == null) {
            varianceL = Variance.INVARIANT;
        }
        if (varianceL != varianceC && varianceL != (variance = Variance.INVARIANT)) {
            if (varianceC == variance) {
                varianceC = variance;
            } else {
                this.f44106a.d(o0Var.b(), b0Var, K02);
            }
        }
        a(type.getAnnotations(), K02.getAnnotations());
        return new D0(varianceC, K02 instanceof C5969D ? c((C5969D) K02, type.G0()) : f(F0.a(K02), type));
    }

    public final AbstractC5990d0 m(AbstractC5990d0 abstractC5990d0, o0 o0Var, int i10) {
        v0 v0VarH0 = abstractC5990d0.H0();
        List<B0> listF0 = abstractC5990d0.F0();
        ArrayList arrayList = new ArrayList(C1174w.x(listF0, 10));
        int i11 = 0;
        for (Object obj : listF0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            B0 b02 = (B0) obj;
            B0 b0L = l(b02, o0Var, v0VarH0.getParameters().get(i11), i10 + 1);
            if (!b0L.b()) {
                b0L = new D0(b0L.c(), H0.q(b0L.getType(), b02.getType().I0()));
            }
            arrayList.add(b0L);
            i11 = i12;
        }
        return F0.f(abstractC5990d0, arrayList, null, 2, null);
    }
}

package X9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.b0;
import F9.n;
import S9.O;
import V9.k;
import V9.p;
import Z8.C1172u;
import Z8.C1174w;
import Z8.F;
import Z9.A;
import Z9.C;
import Z9.v;
import Z9.x;
import Z9.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.A0;
import ya.AbstractC5990d0;
import ya.B0;
import ya.D0;
import ya.H0;
import ya.S;
import ya.V;
import ya.Y;
import ya.s0;
import ya.t0;
import ya.v0;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final k f6877a;

    /* renamed from: b, reason: collision with root package name */
    public final p f6878b;

    /* renamed from: c, reason: collision with root package name */
    public final f f6879c;

    /* renamed from: d, reason: collision with root package name */
    public final A0 f6880d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(k c10, p typeParameterResolver) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(typeParameterResolver, "typeParameterResolver");
        this.f6877a = c10;
        this.f6878b = typeParameterResolver;
        f fVar = new f();
        this.f6879c = fVar;
        this.f6880d = new A0(fVar, null, 2, 0 == true ? 1 : 0);
    }

    public static final S e(d dVar, b0 b0Var, a aVar, v0 v0Var, Z9.j jVar) {
        A0 a02 = dVar.f6880d;
        InterfaceC0799d interfaceC0799dD = v0Var.d();
        return a02.e(b0Var, aVar.k(interfaceC0799dD != null ? interfaceC0799dD.n() : null).j(jVar.t()));
    }

    public static /* synthetic */ S m(d dVar, Z9.f fVar, a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return dVar.l(fVar, aVar, z10);
    }

    public static final Aa.g o(Z9.j jVar) {
        return Aa.i.d(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, jVar.B());
    }

    public final boolean b(Z9.j jVar, InterfaceC0797b interfaceC0797b) {
        Variance varianceL;
        if (!A.a((x) F.E0(jVar.x()))) {
            return false;
        }
        List<b0> parameters = D9.b.f2290a.b(interfaceC0797b).j().getParameters();
        kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
        b0 b0Var = (b0) F.E0(parameters);
        return (b0Var == null || (varianceL = b0Var.l()) == null || varianceL == Variance.OUT_VARIANCE) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<ya.B0> c(Z9.j r10, X9.a r11, ya.v0 r12) {
        /*
            r9 = this;
            boolean r0 = r10.t()
            java.lang.String r1 = "getParameters(...)"
            if (r0 != 0) goto L24
            java.util.List r0 = r10.x()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L22
            java.util.List r0 = r12.getParameters()
            kotlin.jvm.internal.p.h(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L22
            goto L24
        L22:
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            java.util.List r2 = r12.getParameters()
            kotlin.jvm.internal.p.h(r2, r1)
            if (r0 == 0) goto L33
            java.util.List r9 = r9.d(r10, r2, r12, r11)
            return r9
        L33:
            int r11 = r2.size()
            java.util.List r12 = r10.x()
            int r12 = r12.size()
            r0 = 10
            if (r11 == r12) goto L83
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = Z8.C1174w.x(r2, r0)
            r9.<init>(r10)
            java.util.Iterator r10 = r2.iterator()
        L52:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L7e
            java.lang.Object r11 = r10.next()
            E9.b0 r11 = (E9.b0) r11
            ya.D0 r12 = new ya.D0
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER
            ga.e r11 = r11.getName()
            java.lang.String r11 = r11.b()
            java.lang.String r1 = "asString(...)"
            kotlin.jvm.internal.p.h(r11, r1)
            java.lang.String[] r11 = new java.lang.String[]{r11}
            Aa.g r11 = Aa.i.d(r0, r11)
            r12.<init>(r11)
            r9.add(r12)
            goto L52
        L7e:
            java.util.List r9 = Z8.F.m1(r9)
            return r9
        L83:
            java.util.List r10 = r10.x()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.lang.Iterable r10 = Z8.F.u1(r10)
            java.util.ArrayList r11 = new java.util.ArrayList
            int r12 = Z8.C1174w.x(r10, r0)
            r11.<init>(r12)
            java.util.Iterator r10 = r10.iterator()
        L9a:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto Lcf
            java.lang.Object r12 = r10.next()
            Z8.J r12 = (Z8.IndexedValue) r12
            int r0 = r12.getIndex()
            java.lang.Object r12 = r12.b()
            Z9.x r12 = (Z9.x) r12
            r2.size()
            java.lang.Object r0 = r2.get(r0)
            E9.b0 r0 = (E9.b0) r0
            kotlin.reflect.jvm.internal.impl.types.TypeUsage r3 = kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON
            r7 = 7
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            X9.a r1 = X9.b.b(r3, r4, r5, r6, r7, r8)
            kotlin.jvm.internal.p.f(r0)
            ya.B0 r12 = r9.q(r12, r1, r0)
            r11.add(r12)
            goto L9a
        Lcf:
            java.util.List r9 = Z8.F.m1(r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X9.d.c(Z9.j, X9.a, ya.v0):java.util.List");
    }

    public final List<B0> d(Z9.j jVar, List<? extends b0> list, v0 v0Var, a aVar) {
        d dVar;
        Z9.j jVar2;
        v0 v0Var2;
        a aVar2;
        B0 b0A;
        List<? extends b0> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (b0 b0Var : list2) {
            if (Da.d.q(b0Var, null, aVar.c())) {
                b0A = H0.t(b0Var, aVar);
                dVar = this;
                jVar2 = jVar;
                v0Var2 = v0Var;
                aVar2 = aVar;
            } else {
                dVar = this;
                jVar2 = jVar;
                v0Var2 = v0Var;
                aVar2 = aVar;
                b0A = dVar.f6879c.a(b0Var, aVar2.j(jVar2.t()), dVar.f6880d, new Y(this.f6877a.e(), new c(dVar, b0Var, aVar2, v0Var2, jVar2)));
            }
            arrayList.add(b0A);
            this = dVar;
            aVar = aVar2;
            v0Var = v0Var2;
            jVar = jVar2;
        }
        return arrayList;
    }

    public final AbstractC5990d0 f(Z9.j jVar, a aVar, AbstractC5990d0 abstractC5990d0) {
        Z9.j jVar2;
        s0 s0VarB;
        if (abstractC5990d0 == null || (s0VarB = abstractC5990d0.G0()) == null) {
            jVar2 = jVar;
            s0VarB = t0.b(new V9.g(this.f6877a, jVar2, false, 4, null));
        } else {
            jVar2 = jVar;
        }
        s0 s0Var = s0VarB;
        v0 v0VarG = g(jVar2, aVar);
        if (v0VarG == null) {
            return null;
        }
        boolean zJ = j(aVar);
        return (kotlin.jvm.internal.p.d(abstractC5990d0 != null ? abstractC5990d0.H0() : null, v0VarG) && !jVar2.t() && zJ) ? abstractC5990d0.L0(true) : V.m(s0Var, v0VarG, c(jVar2, aVar, v0VarG), zJ, null, 16, null);
    }

    public final v0 g(Z9.j jVar, a aVar) {
        v0 v0VarJ;
        Z9.i iVarC = jVar.c();
        if (iVarC == null) {
            return h(jVar);
        }
        if (!(iVarC instanceof Z9.g)) {
            if (iVarC instanceof y) {
                b0 b0VarA = this.f6878b.a((y) iVarC);
                if (b0VarA != null) {
                    return b0VarA.j();
                }
                return null;
            }
            throw new IllegalStateException("Unknown classifier kind: " + iVarC);
        }
        Z9.g gVar = (Z9.g) iVarC;
        ga.c cVarF = gVar.f();
        if (cVarF != null) {
            InterfaceC0797b interfaceC0797bK = k(jVar, aVar, cVarF);
            if (interfaceC0797bK == null) {
                interfaceC0797bK = this.f6877a.a().n().a(gVar);
            }
            return (interfaceC0797bK == null || (v0VarJ = interfaceC0797bK.j()) == null) ? h(jVar) : v0VarJ;
        }
        throw new AssertionError("Class type should have a FQ name: " + iVarC);
    }

    public final v0 h(Z9.j jVar) {
        v0 v0VarJ = this.f6877a.a().b().f().r().d(ga.b.f32721d.c(new ga.c(jVar.D())), C1172u.e(0)).j();
        kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
        return v0VarJ;
    }

    public final boolean i(Variance variance, b0 b0Var) {
        return (b0Var.l() == Variance.INVARIANT || variance == b0Var.l()) ? false : true;
    }

    public final boolean j(a aVar) {
        return (aVar.g() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.h() || aVar.b() == TypeUsage.SUPERTYPE) ? false : true;
    }

    public final InterfaceC0797b k(Z9.j jVar, a aVar, ga.c cVar) {
        if (aVar.h() && kotlin.jvm.internal.p.d(cVar, e.f6881a)) {
            return this.f6877a.a().p().d();
        }
        D9.b bVar = D9.b.f2290a;
        InterfaceC0797b interfaceC0797bF = D9.b.f(bVar, cVar, this.f6877a.d().g(), null, 4, null);
        if (interfaceC0797bF == null) {
            return null;
        }
        return (bVar.d(interfaceC0797bF) && (aVar.g() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.b() == TypeUsage.SUPERTYPE || b(jVar, interfaceC0797bF))) ? bVar.b(interfaceC0797bF) : interfaceC0797bF;
    }

    public final S l(Z9.f arrayType, a attr, boolean z10) {
        kotlin.jvm.internal.p.i(arrayType, "arrayType");
        kotlin.jvm.internal.p.i(attr, "attr");
        x xVarN = arrayType.n();
        v vVar = xVarN instanceof v ? (v) xVarN : null;
        PrimitiveType type = vVar != null ? vVar.getType() : null;
        V9.g gVar = new V9.g(this.f6877a, arrayType, true);
        if (type != null) {
            AbstractC5990d0 abstractC5990d0P = this.f6877a.d().g().P(type);
            kotlin.jvm.internal.p.f(abstractC5990d0P);
            S sC = Da.d.C(abstractC5990d0P, new n(abstractC5990d0P.getAnnotations(), gVar));
            kotlin.jvm.internal.p.g(sC, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            AbstractC5990d0 abstractC5990d0 = (AbstractC5990d0) sC;
            return attr.h() ? abstractC5990d0 : V.e(abstractC5990d0, abstractC5990d0.L0(true));
        }
        S sP = p(xVarN, b.b(TypeUsage.COMMON, attr.h(), false, null, 6, null));
        if (attr.h()) {
            AbstractC5990d0 abstractC5990d0N = this.f6877a.d().g().n(z10 ? Variance.OUT_VARIANCE : Variance.INVARIANT, sP, gVar);
            kotlin.jvm.internal.p.h(abstractC5990d0N, "getArrayType(...)");
            return abstractC5990d0N;
        }
        AbstractC5990d0 abstractC5990d0N2 = this.f6877a.d().g().n(Variance.INVARIANT, sP, gVar);
        kotlin.jvm.internal.p.h(abstractC5990d0N2, "getArrayType(...)");
        return V.e(abstractC5990d0N2, this.f6877a.d().g().n(Variance.OUT_VARIANCE, sP, gVar).L0(true));
    }

    public final S n(Z9.j jVar, a aVar) {
        AbstractC5990d0 abstractC5990d0F;
        boolean z10 = (aVar.h() || aVar.b() == TypeUsage.SUPERTYPE) ? false : true;
        boolean zT = jVar.t();
        if (!zT && !z10) {
            AbstractC5990d0 abstractC5990d0F2 = f(jVar, aVar, null);
            return abstractC5990d0F2 != null ? abstractC5990d0F2 : o(jVar);
        }
        AbstractC5990d0 abstractC5990d0F3 = f(jVar, aVar.l(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (abstractC5990d0F3 != null && (abstractC5990d0F = f(jVar, aVar.l(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), abstractC5990d0F3)) != null) {
            return zT ? new j(abstractC5990d0F3, abstractC5990d0F) : V.e(abstractC5990d0F3, abstractC5990d0F);
        }
        return o(jVar);
    }

    public final S p(x xVar, a attr) {
        S sP;
        kotlin.jvm.internal.p.i(attr, "attr");
        if (xVar instanceof v) {
            PrimitiveType type = ((v) xVar).getType();
            AbstractC5990d0 abstractC5990d0S = type != null ? this.f6877a.d().g().S(type) : this.f6877a.d().g().a0();
            kotlin.jvm.internal.p.f(abstractC5990d0S);
            return abstractC5990d0S;
        }
        if (xVar instanceof Z9.j) {
            return n((Z9.j) xVar, attr);
        }
        if (xVar instanceof Z9.f) {
            return m(this, (Z9.f) xVar, attr, false, 4, null);
        }
        if (xVar instanceof C) {
            x bound = ((C) xVar).getBound();
            if (bound != null && (sP = p(bound, attr)) != null) {
                return sP;
            }
            AbstractC5990d0 abstractC5990d0Z = this.f6877a.d().g().z();
            kotlin.jvm.internal.p.h(abstractC5990d0Z, "getDefaultBound(...)");
            return abstractC5990d0Z;
        }
        if (xVar == null) {
            AbstractC5990d0 abstractC5990d0Z2 = this.f6877a.d().g().z();
            kotlin.jvm.internal.p.h(abstractC5990d0Z2, "getDefaultBound(...)");
            return abstractC5990d0Z2;
        }
        throw new UnsupportedOperationException("Unsupported type: " + xVar);
    }

    public final B0 q(x xVar, a aVar, b0 b0Var) {
        if (!(xVar instanceof C)) {
            return new D0(Variance.INVARIANT, p(xVar, aVar));
        }
        C c10 = (C) xVar;
        x bound = c10.getBound();
        Variance variance = c10.I() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        if (bound == null || i(variance, b0Var)) {
            B0 b0T = H0.t(b0Var, aVar);
            kotlin.jvm.internal.p.h(b0T, "makeStarProjection(...)");
            return b0T;
        }
        F9.c cVarA = O.a(this.f6877a, c10);
        S sP = p(bound, b.b(TypeUsage.COMMON, false, false, null, 7, null));
        if (cVarA != null) {
            sP = Da.d.C(sP, F9.g.f2609m0.a(F.Q0(sP.getAnnotations(), cVarA)));
        }
        return Da.d.k(sP, variance, b0Var);
    }
}

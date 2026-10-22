package ka;

import Ca.v;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import ya.AbstractC5990d0;
import ya.S;
import ya.v0;
import za.InterfaceC6455a;

/* renamed from: ka.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4833m implements InterfaceC6455a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<v0, v0> f34657a;

    /* renamed from: b, reason: collision with root package name */
    public final b.a f34658b;

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.types.checker.c f34659c;

    /* renamed from: d, reason: collision with root package name */
    public final KotlinTypePreparator f34660d;

    /* renamed from: e, reason: collision with root package name */
    public final p9.p<S, S, Boolean> f34661e;

    /* renamed from: ka.m$a */
    public static final class a extends TypeCheckerState {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ C4833m f34662l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, boolean z11, boolean z12, C4833m c4833m, KotlinTypePreparator kotlinTypePreparator, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
            super(z10, z11, z12, true, c4833m, kotlinTypePreparator, cVar);
            this.f34662l = c4833m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState
        public boolean f(Ca.g subType, Ca.g superType) {
            kotlin.jvm.internal.p.i(subType, "subType");
            kotlin.jvm.internal.p.i(superType, "superType");
            if (!(subType instanceof S)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (superType instanceof S) {
                return ((Boolean) this.f34662l.f34661e.invoke(subType, superType)).booleanValue();
            }
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C4833m(Map<v0, ? extends v0> map, b.a equalityAxioms, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner, KotlinTypePreparator kotlinTypePreparator, p9.p<? super S, ? super S, Boolean> pVar) {
        kotlin.jvm.internal.p.i(equalityAxioms, "equalityAxioms");
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.jvm.internal.p.i(kotlinTypePreparator, "kotlinTypePreparator");
        this.f34657a = map;
        this.f34658b = equalityAxioms;
        this.f34659c = kotlinTypeRefiner;
        this.f34660d = kotlinTypePreparator;
        this.f34661e = pVar;
    }

    @Override // Ca.q
    public /* bridge */ boolean A(Ca.h hVar) {
        return InterfaceC6455a.C0567a.d0(this, hVar);
    }

    @Override // Ca.u
    public /* bridge */ boolean A0(Ca.h hVar, Ca.h hVar2) {
        return InterfaceC6455a.C0567a.G(this, hVar, hVar2);
    }

    @Override // Ca.q
    public /* bridge */ Ca.g B(Ca.b bVar) {
        return InterfaceC6455a.C0567a.i0(this, bVar);
    }

    @Override // ya.G0
    public /* bridge */ Ca.g B0(Ca.o oVar) {
        return InterfaceC6455a.C0567a.v(this, oVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean C(Ca.g gVar) {
        return InterfaceC6455a.C0567a.f0(this, gVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean C0(Ca.g gVar) {
        return InterfaceC6455a.C0567a.N(this, gVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean D(Ca.n nVar) {
        return InterfaceC6455a.C0567a.K(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ TypeVariance D0(Ca.k kVar) {
        return InterfaceC6455a.C0567a.C(this, kVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.h E(Ca.g gVar) {
        return q1(gVar);
    }

    @Override // Ca.q
    public /* bridge */ List<Ca.o> E0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.s(this, nVar);
    }

    @Override // ya.G0
    public /* bridge */ Ca.i F(Ca.g gVar) {
        return InterfaceC6455a.C0567a.c(this, gVar);
    }

    @Override // Ca.q
    public /* bridge */ TypeVariance F0(Ca.o oVar) {
        return InterfaceC6455a.C0567a.D(this, oVar);
    }

    @Override // Ca.q
    public /* bridge */ CaptureStatus G(Ca.b bVar) {
        return InterfaceC6455a.C0567a.l(this, bVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean G0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.U(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.g H(Collection<? extends Ca.g> collection) {
        return InterfaceC6455a.C0567a.H(this, collection);
    }

    @Override // Ca.q
    public /* bridge */ Ca.c H0(Ca.h hVar) {
        return InterfaceC6455a.C0567a.f(this, hVar);
    }

    @Override // ya.G0
    public /* bridge */ Ca.g I(Ca.g gVar) {
        return m1(gVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean I0(Ca.g gVar) {
        return InterfaceC6455a.C0567a.Z(this, gVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.g J(Ca.g gVar) {
        return l1(gVar);
    }

    @Override // ya.G0
    public /* bridge */ boolean J0(Ca.g gVar) {
        return InterfaceC6455a.C0567a.J(this, gVar);
    }

    @Override // Ca.t
    public /* bridge */ boolean K() {
        return InterfaceC6455a.C0567a.R(this);
    }

    @Override // Ca.q
    public /* bridge */ Collection<Ca.g> K0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.s0(this, nVar);
    }

    @Override // ya.G0
    public /* bridge */ boolean L(Ca.n nVar) {
        return InterfaceC6455a.C0567a.g0(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.g L0(Ca.k kVar) {
        return InterfaceC6455a.C0567a.w(this, kVar);
    }

    @Override // Ca.q
    public /* bridge */ List<Ca.k> M(Ca.g gVar) {
        return InterfaceC6455a.C0567a.o(this, gVar);
    }

    @Override // Ca.m
    public TypeCheckerState M0(boolean z10, boolean z11, boolean z12) {
        if (this.f34661e != null) {
            return new a(z10, z11, z12, this, this.f34660d, this.f34659c);
        }
        return kotlin.reflect.jvm.internal.impl.types.checker.a.a(z10, z11, this, this.f34660d, this.f34659c);
    }

    @Override // Ca.q
    public /* bridge */ boolean N(Ca.g gVar) {
        return InterfaceC6455a.C0567a.S(this, gVar);
    }

    @Override // Ca.q
    public /* bridge */ int N0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.n0(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.k O(Ca.a aVar) {
        return InterfaceC6455a.C0567a.p0(this, aVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean O0(Ca.g gVar) {
        return a1(gVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean P(Ca.g gVar) {
        return b1(gVar);
    }

    @Override // ya.G0
    public /* bridge */ PrimitiveType P0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.t(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.k Q(Ca.j jVar, int i10) {
        return Y0(jVar, i10);
    }

    @Override // Ca.q
    public /* bridge */ Ca.g Q0(Ca.g gVar, boolean z10) {
        return InterfaceC6455a.C0567a.j0(this, gVar, z10);
    }

    @Override // ya.G0
    public /* bridge */ PrimitiveType R(Ca.n nVar) {
        return InterfaceC6455a.C0567a.u(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.d R0(Ca.e eVar) {
        return InterfaceC6455a.C0567a.g(this, eVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.a S(Ca.b bVar) {
        return InterfaceC6455a.C0567a.t0(this, bVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean S0(Ca.g gVar) {
        return InterfaceC6455a.C0567a.T(this, gVar);
    }

    @Override // ya.G0
    public /* bridge */ Ca.p T(Map<Ca.n, ? extends Ca.g> map) {
        return InterfaceC6455a.C0567a.v0(this, map);
    }

    @Override // ya.G0
    public /* bridge */ Ca.g U(Ca.g gVar) {
        return InterfaceC6455a.C0567a.A(this, gVar);
    }

    public final boolean U0(v0 v0Var, v0 v0Var2) {
        if (this.f34658b.a(v0Var, v0Var2)) {
            return true;
        }
        Map<v0, v0> map = this.f34657a;
        if (map == null) {
            return false;
        }
        v0 v0Var3 = map.get(v0Var);
        v0 v0Var4 = this.f34657a.get(v0Var2);
        return (v0Var3 != null && kotlin.jvm.internal.p.d(v0Var3, v0Var2)) || (v0Var4 != null && kotlin.jvm.internal.p.d(v0Var4, v0Var));
    }

    @Override // Ca.q
    public /* bridge */ Ca.n V(Ca.g gVar) {
        return p1(gVar);
    }

    @Override // Ca.q
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public /* bridge */ AbstractC5990d0 k(Ca.h hVar, CaptureStatus captureStatus) {
        return InterfaceC6455a.C0567a.k(this, hVar, captureStatus);
    }

    @Override // Ca.q
    public /* bridge */ boolean W(Ca.o oVar, Ca.n nVar) {
        return InterfaceC6455a.C0567a.F(this, oVar, nVar);
    }

    public Ca.b W0(Ca.h hVar) {
        kotlin.jvm.internal.p.i(hVar, "<this>");
        return c(f0(hVar));
    }

    @Override // Ca.q
    public /* bridge */ Ca.e X(Ca.g gVar) {
        return InterfaceC6455a.C0567a.h(this, gVar);
    }

    public List<Ca.i> X0(Ca.h hVar, Ca.n constructor) {
        kotlin.jvm.internal.p.i(hVar, "<this>");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        return null;
    }

    @Override // Ca.q
    public /* bridge */ Ca.j Y(Ca.h hVar) {
        return InterfaceC6455a.C0567a.d(this, hVar);
    }

    public Ca.k Y0(Ca.j jVar, int i10) {
        kotlin.jvm.internal.p.i(jVar, "<this>");
        if (jVar instanceof Ca.i) {
            return x0((Ca.g) jVar, i10);
        }
        if (jVar instanceof ArgumentList) {
            Ca.k kVar = ((ArgumentList) jVar).get(i10);
            kotlin.jvm.internal.p.h(kVar, "get(...)");
            return kVar;
        }
        throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + kotlin.jvm.internal.t.b(jVar.getClass())).toString());
    }

    @Override // Ca.q
    public /* bridge */ Ca.g Z(Ca.g gVar, boolean z10) {
        return InterfaceC6455a.C0567a.x0(this, gVar, z10);
    }

    public Ca.k Z0(Ca.h hVar, int i10) {
        kotlin.jvm.internal.p.i(hVar, "<this>");
        if (i10 < 0 || i10 >= k0(hVar)) {
            return null;
        }
        return x0(hVar, i10);
    }

    @Override // za.InterfaceC6455a, Ca.q
    public /* bridge */ boolean a(Ca.h hVar) {
        return InterfaceC6455a.C0567a.a0(this, hVar);
    }

    @Override // ya.G0
    public /* bridge */ ga.d a0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.q(this, nVar);
    }

    public boolean a1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return N(z0(gVar)) != N(E(gVar));
    }

    @Override // Ca.q
    public /* bridge */ Ca.o b0(v vVar) {
        return InterfaceC6455a.C0567a.y(this, vVar);
    }

    public boolean b1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        Ca.h hVarF = f(gVar);
        return (hVarF != null ? l0(hVarF) : null) != null;
    }

    @Override // za.InterfaceC6455a, Ca.q
    public /* bridge */ Ca.b c(Ca.i iVar) {
        return InterfaceC6455a.C0567a.e(this, iVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean c0(Ca.b bVar) {
        return InterfaceC6455a.C0567a.Y(this, bVar);
    }

    public boolean c1(Ca.h hVar) {
        kotlin.jvm.internal.p.i(hVar, "<this>");
        return D(e(hVar));
    }

    @Override // Ca.q
    public /* bridge */ List<Ca.g> d0(Ca.o oVar) {
        return InterfaceC6455a.C0567a.B(this, oVar);
    }

    public boolean d1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        Ca.h hVarF = f(gVar);
        return (hVarF != null ? H0(hVarF) : null) != null;
    }

    @Override // za.InterfaceC6455a, Ca.q
    public /* bridge */ Ca.n e(Ca.h hVar) {
        return InterfaceC6455a.C0567a.u0(this, hVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean e0(Ca.g gVar) {
        return h1(gVar);
    }

    public boolean e1(Ca.h hVar) {
        kotlin.jvm.internal.p.i(hVar, "<this>");
        return H0(hVar) != null;
    }

    @Override // Ca.q
    public /* bridge */ Ca.i f0(Ca.h hVar) {
        return n1(hVar);
    }

    public boolean f1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        Ca.e eVarX = X(gVar);
        return (eVarX != null ? R0(eVarX) : null) != null;
    }

    @Override // za.InterfaceC6455a
    public /* bridge */ C9.j g() {
        return InterfaceC6455a.C0567a.p(this);
    }

    @Override // Ca.q
    public /* bridge */ Ca.n g0(Ca.o oVar) {
        return InterfaceC6455a.C0567a.x(this, oVar);
    }

    public boolean g1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return X(gVar) != null;
    }

    @Override // za.InterfaceC6455a, Ca.q
    public /* bridge */ boolean h(Ca.k kVar) {
        return InterfaceC6455a.C0567a.c0(this, kVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean h0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.I(this, nVar);
    }

    public boolean h1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return !kotlin.jvm.internal.p.d(e(z0(gVar)), e(E(gVar)));
    }

    @Override // ya.G0
    public /* bridge */ Ca.i i0() {
        return InterfaceC6455a.C0567a.l0(this);
    }

    public boolean i1(Ca.h hVar) {
        kotlin.jvm.internal.p.i(hVar, "<this>");
        return q(e(hVar));
    }

    @Override // Ca.q
    public /* bridge */ boolean j(Ca.h hVar) {
        return c1(hVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean j0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.M(this, nVar);
    }

    public boolean j1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return G0(V(gVar)) && !p(gVar);
    }

    @Override // Ca.q
    public /* bridge */ int k0(Ca.g gVar) {
        return InterfaceC6455a.C0567a.b(this, gVar);
    }

    public Ca.h k1(Ca.g gVar) {
        Ca.h hVarD;
        kotlin.jvm.internal.p.i(gVar, "<this>");
        Ca.e eVarX = X(gVar);
        if (eVarX != null && (hVarD = d(eVarX)) != null) {
            return hVarD;
        }
        Ca.h hVarF = f(gVar);
        kotlin.jvm.internal.p.f(hVarF);
        return hVarF;
    }

    @Override // Ca.q
    public /* bridge */ boolean l(Ca.g gVar) {
        return g1(gVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.b l0(Ca.h hVar) {
        return W0(hVar);
    }

    public Ca.g l1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return Q0(gVar, false);
    }

    @Override // Ca.q
    public /* bridge */ boolean m(Ca.n nVar) {
        return InterfaceC6455a.C0567a.Q(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean m0(Ca.n nVar) {
        return InterfaceC6455a.C0567a.L(this, nVar);
    }

    public Ca.g m1(Ca.g gVar) {
        Ca.h hVarB;
        kotlin.jvm.internal.p.i(gVar, "<this>");
        Ca.h hVarF = f(gVar);
        return (hVarF == null || (hVarB = b(hVarF, true)) == null) ? gVar : hVarB;
    }

    @Override // Ca.q
    public /* bridge */ boolean n(Ca.b bVar) {
        return InterfaceC6455a.C0567a.W(this, bVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.i n0(Ca.c cVar) {
        return InterfaceC6455a.C0567a.m0(this, cVar);
    }

    public Ca.i n1(Ca.h hVar) {
        Ca.i iVarN0;
        kotlin.jvm.internal.p.i(hVar, "<this>");
        Ca.c cVarH0 = H0(hVar);
        return (cVarH0 == null || (iVarN0 = n0(cVarH0)) == null) ? (Ca.i) hVar : iVarN0;
    }

    @Override // Ca.q
    public /* bridge */ boolean o(Ca.g gVar) {
        return d1(gVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean o0(Ca.h hVar) {
        return i1(hVar);
    }

    public int o1(Ca.j jVar) {
        kotlin.jvm.internal.p.i(jVar, "<this>");
        if (jVar instanceof Ca.h) {
            return k0((Ca.g) jVar);
        }
        if (jVar instanceof ArgumentList) {
            return ((ArgumentList) jVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + kotlin.jvm.internal.t.b(jVar.getClass())).toString());
    }

    @Override // Ca.q
    public /* bridge */ boolean p(Ca.g gVar) {
        return InterfaceC6455a.C0567a.V(this, gVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.k p0(Ca.g gVar) {
        return InterfaceC6455a.C0567a.j(this, gVar);
    }

    public Ca.n p1(Ca.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        Ca.h hVarF = f(gVar);
        if (hVarF == null) {
            hVarF = z0(gVar);
        }
        return e(hVarF);
    }

    @Override // Ca.q
    public /* bridge */ boolean q(Ca.n nVar) {
        return InterfaceC6455a.C0567a.P(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ TypeCheckerState.b q0(Ca.h hVar) {
        return InterfaceC6455a.C0567a.r0(this, hVar);
    }

    public Ca.h q1(Ca.g gVar) {
        Ca.h hVarI;
        kotlin.jvm.internal.p.i(gVar, "<this>");
        Ca.e eVarX = X(gVar);
        if (eVarX != null && (hVarI = i(eVarX)) != null) {
            return hVarI;
        }
        Ca.h hVarF = f(gVar);
        kotlin.jvm.internal.p.f(hVarF);
        return hVarF;
    }

    @Override // Ca.q
    public /* bridge */ Ca.o r(Ca.n nVar) {
        return InterfaceC6455a.C0567a.z(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean r0(Ca.i iVar) {
        return InterfaceC6455a.C0567a.X(this, iVar);
    }

    @Override // ya.G0
    public /* bridge */ boolean s(Ca.n nVar) {
        return InterfaceC6455a.C0567a.O(this, nVar);
    }

    @Override // Ca.q
    public /* bridge */ List<Ca.i> s0(Ca.h hVar, Ca.n nVar) {
        return X0(hVar, nVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean t(Ca.h hVar) {
        return InterfaceC6455a.C0567a.e0(this, hVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.g t0(Ca.p pVar, Ca.g gVar) {
        return InterfaceC6455a.C0567a.q0(this, pVar, gVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.k u(Ca.h hVar, int i10) {
        return Z0(hVar, i10);
    }

    @Override // ya.G0
    public /* bridge */ boolean u0(Ca.g gVar, ga.c cVar) {
        return InterfaceC6455a.C0567a.E(this, gVar, cVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.o v(Ca.n nVar, int i10) {
        return InterfaceC6455a.C0567a.r(this, nVar, i10);
    }

    @Override // Ca.q
    public /* bridge */ Collection<Ca.g> v0(Ca.h hVar) {
        return InterfaceC6455a.C0567a.o0(this, hVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean w(Ca.g gVar) {
        return f1(gVar);
    }

    @Override // za.InterfaceC6455a
    public /* bridge */ Ca.g w0(Ca.h hVar, Ca.h hVar2) {
        return InterfaceC6455a.C0567a.m(this, hVar, hVar2);
    }

    @Override // Ca.q
    public /* bridge */ int x(Ca.j jVar) {
        return o1(jVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.k x0(Ca.g gVar, int i10) {
        return InterfaceC6455a.C0567a.n(this, gVar, i10);
    }

    @Override // Ca.q
    public boolean y(Ca.n c12, Ca.n c22) {
        kotlin.jvm.internal.p.i(c12, "c1");
        kotlin.jvm.internal.p.i(c22, "c2");
        if (!(c12 instanceof v0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (c22 instanceof v0) {
            return InterfaceC6455a.C0567a.a(this, c12, c22) || U0((v0) c12, (v0) c22);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // Ca.q
    public /* bridge */ boolean y0(Ca.g gVar) {
        return j1(gVar);
    }

    @Override // Ca.q
    public /* bridge */ boolean z(Ca.h hVar) {
        return e1(hVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.h z0(Ca.g gVar) {
        return k1(gVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.i b(Ca.h hVar, boolean z10) {
        return InterfaceC6455a.C0567a.y0(this, hVar, z10);
    }

    @Override // Ca.q
    public /* bridge */ Ca.i d(Ca.e eVar) {
        return InterfaceC6455a.C0567a.h0(this, eVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.i f(Ca.g gVar) {
        return InterfaceC6455a.C0567a.i(this, gVar);
    }

    @Override // Ca.q
    public /* bridge */ Ca.i i(Ca.e eVar) {
        return InterfaceC6455a.C0567a.w0(this, eVar);
    }
}

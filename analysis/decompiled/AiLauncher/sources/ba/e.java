package ba;

import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.P;
import E9.a0;
import E9.b0;
import La.D;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import ka.C4829i;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5973H;
import ya.C5982Q;
import ya.H0;
import ya.S;
import ya.v0;
import za.C6468n;
import za.InterfaceC6455a;

/* loaded from: classes5.dex */
public final class e {

    public static final class a implements InterfaceC6455a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y<T> f15327a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(y<? extends T> yVar) {
            this.f15327a = yVar;
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
        public Ca.h E(Ca.g gVar) {
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
        public Ca.g I(Ca.g gVar) {
            Ca.h hVarB;
            kotlin.jvm.internal.p.i(gVar, "<this>");
            Ca.h hVarF = f(gVar);
            return (hVarF == null || (hVarB = b(hVarF, true)) == null) ? gVar : hVarB;
        }

        @Override // Ca.q
        public /* bridge */ boolean I0(Ca.g gVar) {
            return InterfaceC6455a.C0567a.Z(this, gVar);
        }

        @Override // Ca.q
        public Ca.g J(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return Q0(gVar, false);
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
        public /* bridge */ TypeCheckerState M0(boolean z10, boolean z11, boolean z12) {
            return InterfaceC6455a.C0567a.k0(this, z10, z11, z12);
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
        public boolean O0(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return N(z0(gVar)) != N(E(gVar));
        }

        @Override // Ca.q
        public boolean P(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            Ca.h hVarF = f(gVar);
            return (hVarF != null ? l0(hVarF) : null) != null;
        }

        @Override // ya.G0
        public /* bridge */ PrimitiveType P0(Ca.n nVar) {
            return InterfaceC6455a.C0567a.t(this, nVar);
        }

        @Override // Ca.q
        public Ca.k Q(Ca.j jVar, int i10) {
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

        @Override // Ca.q
        /* renamed from: T0, reason: merged with bridge method [inline-methods] */
        public /* bridge */ AbstractC5990d0 k(Ca.h hVar, CaptureStatus captureStatus) {
            return InterfaceC6455a.C0567a.k(this, hVar, captureStatus);
        }

        @Override // ya.G0
        public /* bridge */ Ca.g U(Ca.g gVar) {
            return InterfaceC6455a.C0567a.A(this, gVar);
        }

        @Override // Ca.q
        public Ca.n V(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            Ca.h hVarF = f(gVar);
            if (hVarF == null) {
                hVarF = z0(gVar);
            }
            return e(hVarF);
        }

        @Override // Ca.q
        public /* bridge */ boolean W(Ca.o oVar, Ca.n nVar) {
            return InterfaceC6455a.C0567a.F(this, oVar, nVar);
        }

        @Override // Ca.q
        public /* bridge */ Ca.e X(Ca.g gVar) {
            return InterfaceC6455a.C0567a.h(this, gVar);
        }

        @Override // Ca.q
        public /* bridge */ Ca.j Y(Ca.h hVar) {
            return InterfaceC6455a.C0567a.d(this, hVar);
        }

        @Override // Ca.q
        public /* bridge */ Ca.g Z(Ca.g gVar, boolean z10) {
            return InterfaceC6455a.C0567a.x0(this, gVar, z10);
        }

        @Override // za.InterfaceC6455a, Ca.q
        public /* bridge */ boolean a(Ca.h hVar) {
            return InterfaceC6455a.C0567a.a0(this, hVar);
        }

        @Override // ya.G0
        public /* bridge */ ga.d a0(Ca.n nVar) {
            return InterfaceC6455a.C0567a.q(this, nVar);
        }

        @Override // Ca.q
        public /* bridge */ Ca.o b0(Ca.v vVar) {
            return InterfaceC6455a.C0567a.y(this, vVar);
        }

        @Override // za.InterfaceC6455a, Ca.q
        public /* bridge */ Ca.b c(Ca.i iVar) {
            return InterfaceC6455a.C0567a.e(this, iVar);
        }

        @Override // Ca.q
        public /* bridge */ boolean c0(Ca.b bVar) {
            return InterfaceC6455a.C0567a.Y(this, bVar);
        }

        @Override // Ca.q
        public /* bridge */ List<Ca.g> d0(Ca.o oVar) {
            return InterfaceC6455a.C0567a.B(this, oVar);
        }

        @Override // za.InterfaceC6455a, Ca.q
        public /* bridge */ Ca.n e(Ca.h hVar) {
            return InterfaceC6455a.C0567a.u0(this, hVar);
        }

        @Override // Ca.q
        public boolean e0(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return !kotlin.jvm.internal.p.d(e(z0(gVar)), e(E(gVar)));
        }

        @Override // Ca.q
        public Ca.i f0(Ca.h hVar) {
            Ca.i iVarN0;
            kotlin.jvm.internal.p.i(hVar, "<this>");
            Ca.c cVarH0 = H0(hVar);
            return (cVarH0 == null || (iVarN0 = n0(cVarH0)) == null) ? (Ca.i) hVar : iVarN0;
        }

        @Override // za.InterfaceC6455a
        public C9.j g() {
            C9.j jVarG = this.f15327a.g();
            return jVarG == null ? InterfaceC6455a.C0567a.p(this) : jVarG;
        }

        @Override // Ca.q
        public /* bridge */ Ca.n g0(Ca.o oVar) {
            return InterfaceC6455a.C0567a.x(this, oVar);
        }

        @Override // za.InterfaceC6455a, Ca.q
        public /* bridge */ boolean h(Ca.k kVar) {
            return InterfaceC6455a.C0567a.c0(this, kVar);
        }

        @Override // Ca.q
        public /* bridge */ boolean h0(Ca.n nVar) {
            return InterfaceC6455a.C0567a.I(this, nVar);
        }

        @Override // ya.G0
        public /* bridge */ Ca.i i0() {
            return InterfaceC6455a.C0567a.l0(this);
        }

        @Override // Ca.q
        public boolean j(Ca.h hVar) {
            kotlin.jvm.internal.p.i(hVar, "<this>");
            return D(e(hVar));
        }

        @Override // Ca.q
        public /* bridge */ boolean j0(Ca.n nVar) {
            return InterfaceC6455a.C0567a.M(this, nVar);
        }

        @Override // Ca.q
        public /* bridge */ int k0(Ca.g gVar) {
            return InterfaceC6455a.C0567a.b(this, gVar);
        }

        @Override // Ca.q
        public boolean l(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return X(gVar) != null;
        }

        @Override // Ca.q
        public Ca.b l0(Ca.h hVar) {
            kotlin.jvm.internal.p.i(hVar, "<this>");
            return c(f0(hVar));
        }

        @Override // Ca.q
        public /* bridge */ boolean m(Ca.n nVar) {
            return InterfaceC6455a.C0567a.Q(this, nVar);
        }

        @Override // Ca.q
        public /* bridge */ boolean m0(Ca.n nVar) {
            return InterfaceC6455a.C0567a.L(this, nVar);
        }

        @Override // Ca.q
        public /* bridge */ boolean n(Ca.b bVar) {
            return InterfaceC6455a.C0567a.W(this, bVar);
        }

        @Override // Ca.q
        public /* bridge */ Ca.i n0(Ca.c cVar) {
            return InterfaceC6455a.C0567a.m0(this, cVar);
        }

        @Override // Ca.q
        public boolean o(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            Ca.h hVarF = f(gVar);
            return (hVarF != null ? H0(hVarF) : null) != null;
        }

        @Override // Ca.q
        public boolean o0(Ca.h hVar) {
            kotlin.jvm.internal.p.i(hVar, "<this>");
            return q(e(hVar));
        }

        @Override // Ca.q
        public /* bridge */ boolean p(Ca.g gVar) {
            return InterfaceC6455a.C0567a.V(this, gVar);
        }

        @Override // Ca.q
        public /* bridge */ Ca.k p0(Ca.g gVar) {
            return InterfaceC6455a.C0567a.j(this, gVar);
        }

        @Override // Ca.q
        public /* bridge */ boolean q(Ca.n nVar) {
            return InterfaceC6455a.C0567a.P(this, nVar);
        }

        @Override // Ca.q
        public /* bridge */ TypeCheckerState.b q0(Ca.h hVar) {
            return InterfaceC6455a.C0567a.r0(this, hVar);
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
        public List<Ca.i> s0(Ca.h hVar, Ca.n constructor) {
            kotlin.jvm.internal.p.i(hVar, "<this>");
            kotlin.jvm.internal.p.i(constructor, "constructor");
            return null;
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
        public Ca.k u(Ca.h hVar, int i10) {
            kotlin.jvm.internal.p.i(hVar, "<this>");
            if (i10 < 0 || i10 >= k0(hVar)) {
                return null;
            }
            return x0(hVar, i10);
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
        public boolean w(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            Ca.e eVarX = X(gVar);
            return (eVarX != null ? R0(eVarX) : null) != null;
        }

        @Override // za.InterfaceC6455a
        public /* bridge */ Ca.g w0(Ca.h hVar, Ca.h hVar2) {
            return InterfaceC6455a.C0567a.m(this, hVar, hVar2);
        }

        @Override // Ca.q
        public int x(Ca.j jVar) {
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
        public /* bridge */ Ca.k x0(Ca.g gVar, int i10) {
            return InterfaceC6455a.C0567a.n(this, gVar, i10);
        }

        @Override // Ca.q
        public /* bridge */ boolean y(Ca.n nVar, Ca.n nVar2) {
            return InterfaceC6455a.C0567a.a(this, nVar, nVar2);
        }

        @Override // Ca.q
        public boolean y0(Ca.g gVar) {
            kotlin.jvm.internal.p.i(gVar, "<this>");
            return G0(V(gVar)) && !p(gVar);
        }

        @Override // Ca.q
        public boolean z(Ca.h hVar) {
            kotlin.jvm.internal.p.i(hVar, "<this>");
            return H0(hVar) != null;
        }

        @Override // Ca.q
        public Ca.h z0(Ca.g gVar) {
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

    public static final String a(InterfaceC0797b klass, y<?> typeMappingConfiguration) {
        kotlin.jvm.internal.p.i(klass, "klass");
        kotlin.jvm.internal.p.i(typeMappingConfiguration, "typeMappingConfiguration");
        String strC = typeMappingConfiguration.c(klass);
        if (strC != null) {
            return strC;
        }
        InterfaceC0803h interfaceC0803hB = klass.b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        String strE = ga.g.b(klass.getName()).e();
        kotlin.jvm.internal.p.h(strE, "getIdentifier(...)");
        if (interfaceC0803hB instanceof E) {
            ga.c cVarF = ((E) interfaceC0803hB).f();
            if (cVarF.c()) {
                return strE;
            }
            return D.S(cVarF.a(), '.', JsonPointer.SEPARATOR, false, 4, null) + JsonPointer.SEPARATOR + strE;
        }
        InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
        if (interfaceC0797b == null) {
            throw new IllegalArgumentException("Unexpected container: " + interfaceC0803hB + " for " + klass);
        }
        String strE2 = typeMappingConfiguration.e(interfaceC0797b);
        if (strE2 == null) {
            strE2 = a(interfaceC0797b, typeMappingConfiguration);
        }
        return strE2 + '$' + strE;
    }

    public static /* synthetic */ String b(InterfaceC0797b interfaceC0797b, y yVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            yVar = z.f15369a;
        }
        return a(interfaceC0797b, yVar);
    }

    public static final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.a descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
            return true;
        }
        S returnType = descriptor.getReturnType();
        kotlin.jvm.internal.p.f(returnType);
        if (!C9.j.D0(returnType)) {
            return false;
        }
        S returnType2 = descriptor.getReturnType();
        kotlin.jvm.internal.p.f(returnType2);
        return (H0.l(returnType2) || (descriptor instanceof P)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v33, types: [T, java.lang.Object] */
    public static final <T> T d(S kotlinType, n<T> factory, C1463A mode, y<? extends T> typeMappingConfiguration, k<T> kVar, p9.q<? super S, ? super T, ? super C1463A, Y8.t> writeGenericType) {
        T t10;
        S s10;
        Object objD;
        kotlin.jvm.internal.p.i(kotlinType, "kotlinType");
        kotlin.jvm.internal.p.i(factory, "factory");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(typeMappingConfiguration, "typeMappingConfiguration");
        kotlin.jvm.internal.p.i(writeGenericType, "writeGenericType");
        S sA = typeMappingConfiguration.a(kotlinType);
        if (sA != null) {
            return (T) d(sA, factory, mode, typeMappingConfiguration, kVar, writeGenericType);
        }
        if (C9.i.s(kotlinType)) {
            return (T) d(C9.p.a(kotlinType), factory, mode, typeMappingConfiguration, kVar, writeGenericType);
        }
        Object objB = B.b(C6468n.f45422a, kotlinType, factory, mode);
        if (objB != null) {
            ?? r82 = (Object) B.a(factory, objB, mode.d());
            writeGenericType.invoke(kotlinType, r82, mode);
            return r82;
        }
        v0 v0VarH0 = kotlinType.H0();
        if (v0VarH0 instanceof C5982Q) {
            C5982Q c5982q = (C5982Q) v0VarH0;
            S sN = c5982q.n();
            if (sN == null) {
                sN = typeMappingConfiguration.f(c5982q.e());
            }
            return (T) d(Da.d.D(sN), factory, mode, typeMappingConfiguration, kVar, writeGenericType);
        }
        InterfaceC0799d interfaceC0799dD = v0VarH0.d();
        if (interfaceC0799dD == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        if (Aa.i.m(interfaceC0799dD)) {
            T t11 = (T) factory.e("error/NonExistentClass");
            typeMappingConfiguration.b(kotlinType, (InterfaceC0797b) interfaceC0799dD);
            return t11;
        }
        boolean z10 = interfaceC0799dD instanceof InterfaceC0797b;
        if (z10 && C9.j.d0(kotlinType)) {
            if (kotlinType.F0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            B0 b02 = kotlinType.F0().get(0);
            S type = b02.getType();
            kotlin.jvm.internal.p.h(type, "getType(...)");
            if (b02.c() == Variance.IN_VARIANCE) {
                objD = factory.e("java/lang/Object");
            } else {
                Variance varianceC = b02.c();
                kotlin.jvm.internal.p.h(varianceC, "getProjectionKind(...)");
                objD = d(type, factory, mode.f(varianceC, true), typeMappingConfiguration, kVar, writeGenericType);
            }
            return (T) factory.a('[' + factory.d(objD));
        }
        if (!z10) {
            if (interfaceC0799dD instanceof b0) {
                S sO = Da.d.o((b0) interfaceC0799dD);
                if (kotlinType.I0()) {
                    sO = Da.d.B(sO);
                }
                return (T) d(sO, factory, mode, typeMappingConfiguration, null, Ia.i.l());
            }
            if ((interfaceC0799dD instanceof a0) && mode.b()) {
                return (T) d(((a0) interfaceC0799dD).E(), factory, mode, typeMappingConfiguration, kVar, writeGenericType);
            }
            throw new UnsupportedOperationException("Unknown type " + kotlinType);
        }
        if (C4829i.b(interfaceC0799dD) && !mode.c() && (s10 = (S) C5973H.c(new a(typeMappingConfiguration), kotlinType)) != null) {
            return (T) d(s10, factory, mode.g(), typeMappingConfiguration, kVar, writeGenericType);
        }
        if (mode.e() && C9.j.m0((InterfaceC0797b) interfaceC0799dD)) {
            t10 = (Object) factory.f();
        } else {
            InterfaceC0797b interfaceC0797b = (InterfaceC0797b) interfaceC0799dD;
            InterfaceC0797b interfaceC0797bA = interfaceC0797b.a();
            kotlin.jvm.internal.p.h(interfaceC0797bA, "getOriginal(...)");
            T tD = typeMappingConfiguration.d(interfaceC0797bA);
            if (tD == null) {
                if (interfaceC0797b.getKind() == ClassKind.ENUM_ENTRY) {
                    InterfaceC0803h interfaceC0803hB = interfaceC0797b.b();
                    kotlin.jvm.internal.p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    interfaceC0797b = (InterfaceC0797b) interfaceC0803hB;
                }
                InterfaceC0797b interfaceC0797bA2 = interfaceC0797b.a();
                kotlin.jvm.internal.p.h(interfaceC0797bA2, "getOriginal(...)");
                t10 = (Object) factory.e(a(interfaceC0797bA2, typeMappingConfiguration));
            } else {
                t10 = (Object) tD;
            }
        }
        writeGenericType.invoke(kotlinType, t10, mode);
        return t10;
    }

    public static /* synthetic */ Object e(S s10, n nVar, C1463A c1463a, y yVar, k kVar, p9.q qVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            qVar = Ia.i.l();
        }
        return d(s10, nVar, c1463a, yVar, kVar, qVar);
    }
}

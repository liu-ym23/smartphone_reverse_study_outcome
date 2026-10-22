package C9;

import C9.o;
import E9.C0809n;
import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import E9.L;
import E9.O;
import E9.P;
import E9.Q;
import G9.a;
import G9.c;
import H9.F;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;
import xa.InterfaceC5863f;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.D0;
import ya.H0;
import ya.S;
import ya.V;
import ya.t0;
import ya.v0;

/* loaded from: classes5.dex */
public abstract class j {

    /* renamed from: g, reason: collision with root package name */
    public static final ga.e f1778g = ga.e.m("<built-ins module>");

    /* renamed from: a, reason: collision with root package name */
    public F f1779a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC5865h<F> f1780b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5865h<e> f1781c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h<Collection<L>> f1782d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5863f<ga.e, InterfaceC0797b> f1783e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5869l f1784f;

    public class a implements InterfaceC5063a<Collection<L>> {
        public a() {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<L> invoke() {
            return Arrays.asList(j.this.s().f0(o.f1810B), j.this.s().f0(o.f1812D), j.this.s().f0(o.f1813E), j.this.s().f0(o.f1811C));
        }
    }

    public class b implements InterfaceC5063a<e> {
        public b() {
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e invoke() {
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                AbstractC5990d0 abstractC5990d0R = j.this.r(primitiveType.getTypeName().b());
                AbstractC5990d0 abstractC5990d0R2 = j.this.r(primitiveType.getArrayTypeName().b());
                enumMap.put((EnumMap) primitiveType, (PrimitiveType) abstractC5990d0R2);
                map.put(abstractC5990d0R, abstractC5990d0R2);
                map2.put(abstractC5990d0R2, abstractC5990d0R);
            }
            return new e(enumMap, map, map2, null);
        }
    }

    public class c implements InterfaceC5074l<ga.e, InterfaceC0797b> {
        public c() {
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC0797b invoke(ga.e eVar) {
            InterfaceC0799d interfaceC0799dD = j.this.t().d(eVar, NoLookupLocation.FROM_BUILTINS);
            if (interfaceC0799dD == null) {
                throw new AssertionError("Built-in class " + o.f1810B.b(eVar) + " is not found");
            }
            if (interfaceC0799dD instanceof InterfaceC0797b) {
                return (InterfaceC0797b) interfaceC0799dD;
            }
            throw new AssertionError("Must be a class descriptor " + eVar + ", but was " + interfaceC0799dD);
        }
    }

    public class d implements InterfaceC5063a<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ F f1788a;

        public d(F f10) {
            this.f1788a = f10;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke() {
            if (j.this.f1779a == null) {
                j.this.f1779a = this.f1788a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + j.this.f1779a + " (attempting to reset to " + this.f1788a + ")");
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Map<PrimitiveType, AbstractC5990d0> f1790a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<S, AbstractC5990d0> f1791b;

        /* renamed from: c, reason: collision with root package name */
        public final Map<AbstractC5990d0, AbstractC5990d0> f1792c;

        public /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        public static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i10 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public e(Map<PrimitiveType, AbstractC5990d0> map, Map<S, AbstractC5990d0> map2, Map<AbstractC5990d0, AbstractC5990d0> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.f1790a = map;
            this.f1791b = map2;
            this.f1792c = map3;
        }
    }

    public j(InterfaceC5869l interfaceC5869l) {
        if (interfaceC5869l == null) {
            a(0);
        }
        this.f1784f = interfaceC5869l;
        this.f1782d = interfaceC5869l.i(new a());
        this.f1781c = interfaceC5869l.i(new b());
        this.f1783e = interfaceC5869l.c(new c());
    }

    public static boolean A0(S s10) {
        if (s10 == null) {
            a(131);
        }
        return j0(s10, o.a.f1867K0.i());
    }

    public static S B(S s10, InterfaceC0819y interfaceC0819y) {
        ga.b bVarN;
        ga.b bVarA;
        InterfaceC0797b interfaceC0797bB;
        if (s10 == null) {
            a(71);
        }
        if (interfaceC0819y == null) {
            a(72);
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD == null) {
            return null;
        }
        q qVar = q.f1947a;
        if (!qVar.b(interfaceC0799dD.getName()) || (bVarN = DescriptorUtilsKt.n(interfaceC0799dD)) == null || (bVarA = qVar.a(bVarN)) == null || (interfaceC0797bB = FindClassInModuleKt.b(interfaceC0819y, bVarA)) == null) {
            return null;
        }
        return interfaceC0797bB.n();
    }

    public static boolean B0(S s10) {
        if (s10 == null) {
            a(129);
        }
        return j0(s10, o.a.f1863I0.i());
    }

    public static boolean C0(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(10);
        }
        while (interfaceC0803h != null) {
            if (interfaceC0803h instanceof E) {
                return ((E) interfaceC0803h).f().h(o.f1809A);
            }
            interfaceC0803h = interfaceC0803h.b();
        }
        return false;
    }

    public static boolean D0(S s10) {
        if (s10 == null) {
            a(142);
        }
        return n0(s10, o.a.f1904f);
    }

    public static boolean E0(S s10) {
        if (s10 == null) {
            a(132);
        }
        return y0(s10) || B0(s10) || z0(s10) || A0(s10);
    }

    public static PrimitiveType O(S s10) {
        if (s10 == null) {
            a(92);
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD == null) {
            return null;
        }
        return Q(interfaceC0799dD);
    }

    public static PrimitiveType Q(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(77);
        }
        if (o.a.f1885T0.contains(interfaceC0803h.getName())) {
            return o.a.f1889V0.get(C4828h.m(interfaceC0803h));
        }
        return null;
    }

    public static PrimitiveType T(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(76);
        }
        if (o.a.f1883S0.contains(interfaceC0803h.getName())) {
            return o.a.f1887U0.get(C4828h.m(interfaceC0803h));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r23) {
        /*
            Method dump skipped, instructions count: 2222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C9.j.a(int):void");
    }

    public static boolean b0(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(108);
        }
        return e(interfaceC0797b, o.a.f1896b);
    }

    public static boolean c0(S s10) {
        if (s10 == null) {
            a(139);
        }
        return i0(s10, o.a.f1896b);
    }

    public static boolean d0(S s10) {
        if (s10 == null) {
            a(88);
        }
        return i0(s10, o.a.f1910i);
    }

    public static boolean e(InterfaceC0799d interfaceC0799d, ga.d dVar) {
        if (interfaceC0799d == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return interfaceC0799d.getName().equals(dVar.j()) && dVar.equals(C4828h.m(interfaceC0799d));
    }

    public static boolean e0(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(89);
        }
        return e(interfaceC0797b, o.a.f1910i) || Q(interfaceC0797b) != null;
    }

    public static boolean f0(S s10) {
        if (s10 == null) {
            a(90);
        }
        return d0(s10) || r0(s10);
    }

    public static boolean g0(S s10) {
        if (s10 == null) {
            a(110);
        }
        return j0(s10, o.a.f1912j);
    }

    public static boolean h0(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(9);
        }
        return C4828h.r(interfaceC0803h, C9.c.class, false) != null;
    }

    public static boolean i0(S s10, ga.d dVar) {
        if (s10 == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return x0(s10.H0(), dVar);
    }

    public static boolean j0(S s10, ga.d dVar) {
        if (s10 == null) {
            a(134);
        }
        if (dVar == null) {
            a(135);
        }
        return i0(s10, dVar) && !s10.I0();
    }

    public static boolean k0(S s10) {
        if (s10 == null) {
            a(141);
        }
        return q0(s10);
    }

    public static boolean l0(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME);
        }
        if (interfaceC0803h.a().getAnnotations().E(o.a.f1942y)) {
            return true;
        }
        if (interfaceC0803h instanceof O) {
            O o10 = (O) interfaceC0803h;
            boolean zJ = o10.J();
            P getter = o10.getGetter();
            Q setter = o10.getSetter();
            if (getter != null && l0(getter) && (!zJ || (setter != null && l0(setter)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m0(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(158);
        }
        return e(interfaceC0797b, o.a.f1917l0);
    }

    public static boolean n0(S s10, ga.d dVar) {
        if (s10 == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !s10.I0() && i0(s10, dVar);
    }

    public static boolean o0(S s10) {
        if (s10 == null) {
            a(136);
        }
        return p0(s10) && !H0.l(s10);
    }

    public static boolean p0(S s10) {
        if (s10 == null) {
            a(138);
        }
        return i0(s10, o.a.f1898c);
    }

    public static boolean q0(S s10) {
        if (s10 == null) {
            a(140);
        }
        return c0(s10) && s10.I0();
    }

    public static boolean r0(S s10) {
        if (s10 == null) {
            a(91);
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        return (interfaceC0799dD == null || Q(interfaceC0799dD) == null) ? false : true;
    }

    public static boolean s0(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(96);
        }
        return T(interfaceC0797b) != null;
    }

    public static boolean t0(S s10) {
        if (s10 == null) {
            a(94);
        }
        return !s10.I0() && u0(s10);
    }

    public static boolean u0(S s10) {
        if (s10 == null) {
            a(95);
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        return (interfaceC0799dD instanceof InterfaceC0797b) && s0((InterfaceC0797b) interfaceC0799dD);
    }

    public static boolean v0(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(107);
        }
        return e(interfaceC0797b, o.a.f1896b) || e(interfaceC0797b, o.a.f1898c);
    }

    public static boolean w0(S s10) {
        return s10 != null && n0(s10, o.a.f1908h);
    }

    public static boolean x0(v0 v0Var, ga.d dVar) {
        if (v0Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        InterfaceC0799d interfaceC0799dD = v0Var.d();
        return (interfaceC0799dD instanceof InterfaceC0797b) && e(interfaceC0799dD, dVar);
    }

    public static boolean y0(S s10) {
        if (s10 == null) {
            a(128);
        }
        return j0(s10, o.a.f1861H0.i());
    }

    public static boolean z0(S s10) {
        if (s10 == null) {
            a(130);
        }
        return j0(s10, o.a.f1865J0.i());
    }

    public AbstractC5990d0 A() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.DOUBLE);
        if (abstractC5990d0S == null) {
            a(62);
        }
        return abstractC5990d0S;
    }

    public AbstractC5990d0 C() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.FLOAT);
        if (abstractC5990d0S == null) {
            a(61);
        }
        return abstractC5990d0S;
    }

    public InterfaceC0797b D(int i10) {
        return q(o.b(i10));
    }

    public AbstractC5990d0 E() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.INT);
        if (abstractC5990d0S == null) {
            a(59);
        }
        return abstractC5990d0S;
    }

    public InterfaceC0797b F() {
        InterfaceC0797b interfaceC0797bP = p(o.a.f1917l0.m());
        if (interfaceC0797bP == null) {
            a(21);
        }
        return interfaceC0797bP;
    }

    public void F0(F f10) {
        if (f10 == null) {
            a(1);
        }
        this.f1784f.b(new d(f10));
    }

    public AbstractC5990d0 G() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.LONG);
        if (abstractC5990d0S == null) {
            a(60);
        }
        return abstractC5990d0S;
    }

    public InterfaceC0797b H() {
        return q("Nothing");
    }

    public AbstractC5990d0 I() {
        AbstractC5990d0 abstractC5990d0N = H().n();
        if (abstractC5990d0N == null) {
            a(49);
        }
        return abstractC5990d0N;
    }

    public AbstractC5990d0 J() {
        AbstractC5990d0 abstractC5990d0O0 = i().L0(true);
        if (abstractC5990d0O0 == null) {
            a(52);
        }
        return abstractC5990d0O0;
    }

    public AbstractC5990d0 K() {
        AbstractC5990d0 abstractC5990d0O0 = I().L0(true);
        if (abstractC5990d0O0 == null) {
            a(50);
        }
        return abstractC5990d0O0;
    }

    public InterfaceC0797b L() {
        return q("Number");
    }

    public AbstractC5990d0 M() {
        AbstractC5990d0 abstractC5990d0N = L().n();
        if (abstractC5990d0N == null) {
            a(56);
        }
        return abstractC5990d0N;
    }

    public G9.c N() {
        c.b bVar = c.b.f2869a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    public AbstractC5990d0 P(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(73);
        }
        AbstractC5990d0 abstractC5990d0 = this.f1781c.invoke().f1790a.get(primitiveType);
        if (abstractC5990d0 == null) {
            a(74);
        }
        return abstractC5990d0;
    }

    public final InterfaceC0797b R(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(16);
        }
        return q(primitiveType.getTypeName().b());
    }

    public AbstractC5990d0 S(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(54);
        }
        AbstractC5990d0 abstractC5990d0N = R(primitiveType).n();
        if (abstractC5990d0N == null) {
            a(55);
        }
        return abstractC5990d0N;
    }

    public AbstractC5990d0 U() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.SHORT);
        if (abstractC5990d0S == null) {
            a(58);
        }
        return abstractC5990d0S;
    }

    public InterfaceC5869l V() {
        InterfaceC5869l interfaceC5869l = this.f1784f;
        if (interfaceC5869l == null) {
            a(6);
        }
        return interfaceC5869l;
    }

    public InterfaceC0797b W() {
        return q("String");
    }

    public AbstractC5990d0 X() {
        AbstractC5990d0 abstractC5990d0N = W().n();
        if (abstractC5990d0N == null) {
            a(66);
        }
        return abstractC5990d0N;
    }

    public InterfaceC0797b Y(int i10) {
        InterfaceC0797b interfaceC0797bP = p(o.f1838s.b(ga.e.j(o.d(i10))));
        if (interfaceC0797bP == null) {
            a(18);
        }
        return interfaceC0797bP;
    }

    public InterfaceC0797b Z() {
        return q("Unit");
    }

    public AbstractC5990d0 a0() {
        AbstractC5990d0 abstractC5990d0N = Z().n();
        if (abstractC5990d0N == null) {
            a(65);
        }
        return abstractC5990d0N;
    }

    public void f(boolean z10) {
        F f10 = new F(f1778g, this.f1784f, this, null);
        this.f1779a = f10;
        f10.I0(C9.b.f1770a.c().a(this.f1784f, this.f1779a, w(), N(), g(), z10));
        F f11 = this.f1779a;
        f11.Q0(f11);
    }

    public G9.a g() {
        a.C0039a c0039a = a.C0039a.f2867a;
        if (c0039a == null) {
            a(3);
        }
        return c0039a;
    }

    public InterfaceC0797b h() {
        return q("Any");
    }

    public AbstractC5990d0 i() {
        AbstractC5990d0 abstractC5990d0N = h().n();
        if (abstractC5990d0N == null) {
            a(51);
        }
        return abstractC5990d0N;
    }

    public InterfaceC0797b j() {
        return q("Array");
    }

    public S k(S s10) {
        if (s10 == null) {
            a(68);
        }
        S sL = l(s10);
        if (sL != null) {
            return sL;
        }
        throw new IllegalStateException("not array: " + s10);
    }

    public S l(S s10) {
        S sB;
        if (s10 == null) {
            a(70);
        }
        if (d0(s10)) {
            if (s10.F0().size() != 1) {
                return null;
            }
            return s10.F0().get(0).getType();
        }
        S sN = H0.n(s10);
        AbstractC5990d0 abstractC5990d0 = this.f1781c.invoke().f1792c.get(sN);
        if (abstractC5990d0 != null) {
            return abstractC5990d0;
        }
        InterfaceC0819y interfaceC0819yI = C4828h.i(sN);
        if (interfaceC0819yI == null || (sB = B(sN, interfaceC0819yI)) == null) {
            return null;
        }
        return sB;
    }

    public AbstractC5990d0 m(Variance variance, S s10) {
        if (variance == null) {
            a(82);
        }
        if (s10 == null) {
            a(83);
        }
        AbstractC5990d0 abstractC5990d0N = n(variance, s10, F9.g.f2609m0.b());
        if (abstractC5990d0N == null) {
            a(84);
        }
        return abstractC5990d0N;
    }

    public AbstractC5990d0 n(Variance variance, S s10, F9.g gVar) {
        if (variance == null) {
            a(78);
        }
        if (s10 == null) {
            a(79);
        }
        if (gVar == null) {
            a(80);
        }
        AbstractC5990d0 abstractC5990d0H = V.h(t0.b(gVar), j(), Collections.singletonList(new D0(variance, s10)));
        if (abstractC5990d0H == null) {
            a(81);
        }
        return abstractC5990d0H;
    }

    public AbstractC5990d0 o() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.BOOLEAN);
        if (abstractC5990d0S == null) {
            a(64);
        }
        return abstractC5990d0S;
    }

    public InterfaceC0797b p(ga.c cVar) {
        if (cVar == null) {
            a(12);
        }
        InterfaceC0797b interfaceC0797bD = C0809n.d(s(), cVar, NoLookupLocation.FROM_BUILTINS);
        if (interfaceC0797bD == null) {
            a(13);
        }
        return interfaceC0797bD;
    }

    public final InterfaceC0797b q(String str) {
        if (str == null) {
            a(14);
        }
        InterfaceC0797b interfaceC0797bInvoke = this.f1783e.invoke(ga.e.j(str));
        if (interfaceC0797bInvoke == null) {
            a(15);
        }
        return interfaceC0797bInvoke;
    }

    public final AbstractC5990d0 r(String str) {
        if (str == null) {
            a(47);
        }
        AbstractC5990d0 abstractC5990d0N = q(str).n();
        if (abstractC5990d0N == null) {
            a(48);
        }
        return abstractC5990d0N;
    }

    public F s() {
        if (this.f1779a == null) {
            this.f1779a = this.f1780b.invoke();
        }
        F f10 = this.f1779a;
        if (f10 == null) {
            a(7);
        }
        return f10;
    }

    public InterfaceC5238k t() {
        InterfaceC5238k interfaceC5238kM = s().f0(o.f1810B).m();
        if (interfaceC5238kM == null) {
            a(11);
        }
        return interfaceC5238kM;
    }

    public AbstractC5990d0 u() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.BYTE);
        if (abstractC5990d0S == null) {
            a(57);
        }
        return abstractC5990d0S;
    }

    public AbstractC5990d0 v() {
        AbstractC5990d0 abstractC5990d0S = S(PrimitiveType.CHAR);
        if (abstractC5990d0S == null) {
            a(63);
        }
        return abstractC5990d0S;
    }

    public Iterable<G9.b> w() {
        List listSingletonList = Collections.singletonList(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(this.f1784f, s()));
        if (listSingletonList == null) {
            a(5);
        }
        return listSingletonList;
    }

    public InterfaceC0797b x() {
        InterfaceC0797b interfaceC0797bP = p(o.a.f1891X);
        if (interfaceC0797bP == null) {
            a(35);
        }
        return interfaceC0797bP;
    }

    public InterfaceC0797b y() {
        return q("Comparable");
    }

    public AbstractC5990d0 z() {
        AbstractC5990d0 abstractC5990d0J = J();
        if (abstractC5990d0J == null) {
            a(53);
        }
        return abstractC5990d0J;
    }
}

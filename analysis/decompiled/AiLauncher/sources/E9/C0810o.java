package E9;

import E9.l0;
import Fa.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import sa.InterfaceC5460g;
import sa.InterfaceC5461h;
import sa.InterfaceC5462i;
import ya.C5970E;

/* renamed from: E9.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0810o {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC0811p f2469a;

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC0811p f2470b;

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC0811p f2471c;

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC0811p f2472d;

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC0811p f2473e;

    /* renamed from: f, reason: collision with root package name */
    public static final AbstractC0811p f2474f;

    /* renamed from: g, reason: collision with root package name */
    public static final AbstractC0811p f2475g;

    /* renamed from: h, reason: collision with root package name */
    public static final AbstractC0811p f2476h;

    /* renamed from: i, reason: collision with root package name */
    public static final AbstractC0811p f2477i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set<AbstractC0811p> f2478j;

    /* renamed from: k, reason: collision with root package name */
    public static final Map<AbstractC0811p, Integer> f2479k;

    /* renamed from: l, reason: collision with root package name */
    public static final AbstractC0811p f2480l;

    /* renamed from: m, reason: collision with root package name */
    public static final InterfaceC5460g f2481m;

    /* renamed from: n, reason: collision with root package name */
    public static final InterfaceC5460g f2482n;

    /* renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final InterfaceC5460g f2483o;

    /* renamed from: p, reason: collision with root package name */
    public static final Fa.l f2484p;

    /* renamed from: q, reason: collision with root package name */
    public static final Map<m0, AbstractC0811p> f2485q;

    /* renamed from: E9.o$a */
    public static class a implements InterfaceC5460g {
        @Override // sa.InterfaceC5460g
        public ya.S getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* renamed from: E9.o$b */
    public static class b implements InterfaceC5460g {
        @Override // sa.InterfaceC5460g
        public ya.S getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* renamed from: E9.o$c */
    public static class c implements InterfaceC5460g {
        @Override // sa.InterfaceC5460g
        public ya.S getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* renamed from: E9.o$d */
    public static class d extends AbstractC0808m {
        public d(m0 m0Var) {
            super(m0Var);
        }

        public static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "what";
            } else if (i10 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [E9.h, E9.l] */
        /* JADX WARN: Type inference failed for: r3v1, types: [E9.h] */
        /* JADX WARN: Type inference failed for: r3v2, types: [E9.h] */
        /* JADX WARN: Type inference failed for: r3v4, types: [E9.h] */
        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == 0) {
                g(1);
            }
            if (interfaceC0803h == null) {
                g(2);
            }
            if (C4828h.J(interfaceC0807l) && h(interfaceC0803h)) {
                return C0810o.f(interfaceC0807l, interfaceC0803h);
            }
            if (interfaceC0807l instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
                InterfaceC0800e interfaceC0800eB = ((kotlin.reflect.jvm.internal.impl.descriptors.c) interfaceC0807l).b();
                if (z10 && C4828h.G(interfaceC0800eB) && C4828h.J(interfaceC0800eB) && (interfaceC0803h instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) && C4828h.J(interfaceC0803h.b()) && C0810o.f(interfaceC0807l, interfaceC0803h)) {
                    return true;
                }
            }
            while (interfaceC0807l != 0) {
                interfaceC0807l = interfaceC0807l.b();
                if (((interfaceC0807l instanceof InterfaceC0797b) && !C4828h.x(interfaceC0807l)) || (interfaceC0807l instanceof E)) {
                    break;
                }
            }
            if (interfaceC0807l == 0) {
                return false;
            }
            while (interfaceC0803h != null) {
                if (interfaceC0807l == interfaceC0803h) {
                    return true;
                }
                if (interfaceC0803h instanceof E) {
                    return (interfaceC0807l instanceof E) && interfaceC0807l.f().equals(((E) interfaceC0803h).f()) && C4828h.b(interfaceC0803h, interfaceC0807l);
                }
                interfaceC0803h = interfaceC0803h.b();
            }
            return false;
        }

        public final boolean h(InterfaceC0803h interfaceC0803h) {
            if (interfaceC0803h == null) {
                g(0);
            }
            return C4828h.j(interfaceC0803h) != X.f2445a;
        }
    }

    /* renamed from: E9.o$e */
    public static class e extends AbstractC0808m {
        public e(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            InterfaceC0803h interfaceC0803hQ;
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            if (!C0810o.f2469a.e(interfaceC5460g, interfaceC0807l, interfaceC0803h, z10)) {
                return false;
            }
            if (interfaceC5460g == C0810o.f2482n) {
                return true;
            }
            if (interfaceC5460g == C0810o.f2481m || (interfaceC0803hQ = C4828h.q(interfaceC0807l, InterfaceC0797b.class)) == null || !(interfaceC5460g instanceof InterfaceC5462i)) {
                return false;
            }
            return ((InterfaceC5462i) interfaceC5460g).r().a().equals(interfaceC0803hQ.a());
        }
    }

    /* renamed from: E9.o$f */
    public static class f extends AbstractC0808m {
        public f(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "from";
            } else if (i10 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i10 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i10 == 2 || i10 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            InterfaceC0797b interfaceC0797b;
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            InterfaceC0797b interfaceC0797b2 = (InterfaceC0797b) C4828h.q(interfaceC0807l, InterfaceC0797b.class);
            InterfaceC0797b interfaceC0797b3 = (InterfaceC0797b) C4828h.r(interfaceC0803h, InterfaceC0797b.class, false);
            if (interfaceC0797b3 == null) {
                return false;
            }
            if (interfaceC0797b2 != null && C4828h.x(interfaceC0797b2) && (interfaceC0797b = (InterfaceC0797b) C4828h.q(interfaceC0797b2, InterfaceC0797b.class)) != null && C4828h.H(interfaceC0797b3, interfaceC0797b)) {
                return true;
            }
            InterfaceC0807l interfaceC0807lM = C4828h.M(interfaceC0807l);
            InterfaceC0797b interfaceC0797b4 = (InterfaceC0797b) C4828h.q(interfaceC0807lM, InterfaceC0797b.class);
            if (interfaceC0797b4 == null) {
                return false;
            }
            if (C4828h.H(interfaceC0797b3, interfaceC0797b4) && h(interfaceC5460g, interfaceC0807lM, interfaceC0797b3)) {
                return true;
            }
            return e(interfaceC5460g, interfaceC0807l, interfaceC0797b3.b(), z10);
        }

        public final boolean h(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0797b interfaceC0797b) {
            if (interfaceC0807l == null) {
                g(2);
            }
            if (interfaceC0797b == null) {
                g(3);
            }
            if (interfaceC5460g == C0810o.f2483o) {
                return false;
            }
            if (!(interfaceC0807l instanceof CallableMemberDescriptor) || (interfaceC0807l instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) || interfaceC5460g == C0810o.f2482n) {
                return true;
            }
            if (interfaceC5460g == C0810o.f2481m || interfaceC5460g == null) {
                return false;
            }
            ya.S sB = interfaceC5460g instanceof InterfaceC5461h ? ((InterfaceC5461h) interfaceC5460g).b() : interfaceC5460g.getType();
            return C4828h.I(sB, interfaceC0797b) || C5970E.a(sB);
        }
    }

    /* renamed from: E9.o$g */
    public static class g extends AbstractC0808m {
        public g(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            if (C4828h.g(interfaceC0803h).u(C4828h.g(interfaceC0807l))) {
                return C0810o.f2484p.a(interfaceC0807l, interfaceC0803h);
            }
            return false;
        }
    }

    /* renamed from: E9.o$h */
    public static class h extends AbstractC0808m {
        public h(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            return true;
        }
    }

    /* renamed from: E9.o$i */
    public static class i extends AbstractC0808m {
        public i(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* renamed from: E9.o$j */
    public static class j extends AbstractC0808m {
        public j(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* renamed from: E9.o$k */
    public static class k extends AbstractC0808m {
        public k(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            return false;
        }
    }

    /* renamed from: E9.o$l */
    public static class l extends AbstractC0808m {
        public l(m0 m0Var) {
            super(m0Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // E9.AbstractC0811p
        public boolean e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
            if (interfaceC0807l == null) {
                g(0);
            }
            if (interfaceC0803h == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        d dVar = new d(l0.e.f2461c);
        f2469a = dVar;
        e eVar = new e(l0.f.f2462c);
        f2470b = eVar;
        f fVar = new f(l0.g.f2463c);
        f2471c = fVar;
        g gVar = new g(l0.b.f2458c);
        f2472d = gVar;
        h hVar = new h(l0.h.f2464c);
        f2473e = hVar;
        i iVar = new i(l0.d.f2460c);
        f2474f = iVar;
        j jVar = new j(l0.a.f2457c);
        f2475g = jVar;
        k kVar = new k(l0.c.f2459c);
        f2476h = kVar;
        l lVar = new l(l0.i.f2465c);
        f2477i = lVar;
        f2478j = Collections.unmodifiableSet(Z8.Y.j(dVar, eVar, gVar, iVar));
        HashMap mapE = Ia.a.e(4);
        mapE.put(eVar, 0);
        mapE.put(dVar, 0);
        mapE.put(gVar, 1);
        mapE.put(fVar, 1);
        mapE.put(hVar, 2);
        f2479k = Collections.unmodifiableMap(mapE);
        f2480l = hVar;
        f2481m = new a();
        f2482n = new b();
        f2483o = new c();
        Iterator it = ServiceLoader.load(Fa.l.class, Fa.l.class.getClassLoader()).iterator();
        f2484p = it.hasNext() ? (Fa.l) it.next() : l.a.f2655a;
        f2485q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r3
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: E9.C0810o.a(int):void");
    }

    public static Integer d(AbstractC0811p abstractC0811p, AbstractC0811p abstractC0811p2) {
        if (abstractC0811p == null) {
            a(12);
        }
        if (abstractC0811p2 == null) {
            a(13);
        }
        Integer numA = abstractC0811p.a(abstractC0811p2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = abstractC0811p2.a(abstractC0811p);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static InterfaceC0807l e(InterfaceC5460g interfaceC5460g, InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
        InterfaceC0807l interfaceC0807lE;
        if (interfaceC0807l == null) {
            a(8);
        }
        if (interfaceC0803h == null) {
            a(9);
        }
        for (InterfaceC0807l interfaceC0807l2 = (InterfaceC0807l) interfaceC0807l.a(); interfaceC0807l2 != null && interfaceC0807l2.getVisibility() != f2474f; interfaceC0807l2 = (InterfaceC0807l) C4828h.q(interfaceC0807l2, InterfaceC0807l.class)) {
            if (!interfaceC0807l2.getVisibility().e(interfaceC5460g, interfaceC0807l2, interfaceC0803h, z10)) {
                return interfaceC0807l2;
            }
        }
        if (!(interfaceC0807l instanceof H9.Q) || (interfaceC0807lE = e(interfaceC5460g, ((H9.Q) interfaceC0807l).N(), interfaceC0803h, z10)) == null) {
            return null;
        }
        return interfaceC0807lE;
    }

    public static boolean f(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        if (interfaceC0803h == null) {
            a(6);
        }
        if (interfaceC0803h2 == null) {
            a(7);
        }
        X xJ = C4828h.j(interfaceC0803h2);
        if (xJ != X.f2445a) {
            return xJ.equals(C4828h.j(interfaceC0803h));
        }
        return false;
    }

    public static boolean g(AbstractC0811p abstractC0811p) {
        if (abstractC0811p == null) {
            a(14);
        }
        return abstractC0811p == f2469a || abstractC0811p == f2470b;
    }

    public static boolean h(InterfaceC0807l interfaceC0807l, InterfaceC0803h interfaceC0803h, boolean z10) {
        if (interfaceC0807l == null) {
            a(2);
        }
        if (interfaceC0803h == null) {
            a(3);
        }
        return e(f2482n, interfaceC0807l, interfaceC0803h, z10) == null;
    }

    public static void i(AbstractC0811p abstractC0811p) {
        f2485q.put(abstractC0811p.b(), abstractC0811p);
    }

    public static AbstractC0811p j(m0 m0Var) {
        if (m0Var == null) {
            a(15);
        }
        AbstractC0811p abstractC0811p = f2485q.get(m0Var);
        if (abstractC0811p != null) {
            return abstractC0811p;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + m0Var);
    }
}

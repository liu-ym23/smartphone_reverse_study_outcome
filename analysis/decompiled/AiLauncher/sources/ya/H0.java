package ya;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;
import za.InterfaceC6465k;

/* loaded from: classes5.dex */
public class H0 {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC5990d0 f44023a = Aa.i.d(ErrorTypeKind.DONT_CARE, new String[0]);

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC5990d0 f44024b = Aa.i.d(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC5990d0 f44025c = new a("NO_EXPECTED_TYPE");

    /* renamed from: d, reason: collision with root package name */
    public static final AbstractC5990d0 f44026d = new a("UNIT_EXPECTED_TYPE");

    public static class a extends AbstractC6019z {

        /* renamed from: b, reason: collision with root package name */
        public final String f44027b;

        public a(String str) {
            this.f44027b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void T0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = r3
                goto L14
            L13:
                r5 = r4
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAttributes"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAttributes"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ya.H0.a.T0(int):void");
        }

        @Override // ya.K0
        /* renamed from: O0, reason: merged with bridge method [inline-methods] */
        public AbstractC5990d0 L0(boolean z10) {
            throw new IllegalStateException(this.f44027b);
        }

        @Override // ya.K0
        /* renamed from: P0, reason: merged with bridge method [inline-methods] */
        public AbstractC5990d0 N0(s0 s0Var) {
            if (s0Var == null) {
                T0(0);
            }
            throw new IllegalStateException(this.f44027b);
        }

        @Override // ya.AbstractC6019z
        public AbstractC5990d0 Q0() {
            throw new IllegalStateException(this.f44027b);
        }

        @Override // ya.AbstractC6019z
        public AbstractC6019z S0(AbstractC5990d0 abstractC5990d0) {
            if (abstractC5990d0 == null) {
                T0(2);
            }
            throw new IllegalStateException(this.f44027b);
        }

        @Override // ya.AbstractC6019z
        /* renamed from: U0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a R0(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
            if (cVar == null) {
                T0(3);
            }
            return this;
        }

        @Override // ya.AbstractC5990d0
        public String toString() {
            String str = this.f44027b;
            if (str == null) {
                T0(1);
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.H0.a(int):void");
    }

    public static boolean b(S s10) {
        if (s10 == null) {
            a(28);
        }
        if (s10.I0()) {
            return true;
        }
        return C5977L.b(s10) && b(C5977L.a(s10).Q0());
    }

    public static boolean c(S s10, InterfaceC5074l<K0, Boolean> interfaceC5074l) {
        if (interfaceC5074l == null) {
            a(43);
        }
        return d(s10, interfaceC5074l, null);
    }

    public static boolean d(S s10, InterfaceC5074l<K0, Boolean> interfaceC5074l, Ia.k<S> kVar) {
        if (interfaceC5074l == null) {
            a(44);
        }
        if (s10 == null) {
            return false;
        }
        K0 K02 = s10.K0();
        if (w(s10)) {
            return interfaceC5074l.invoke(K02).booleanValue();
        }
        if (kVar != null && kVar.contains(s10)) {
            return false;
        }
        if (interfaceC5074l.invoke(K02).booleanValue()) {
            return true;
        }
        if (kVar == null) {
            kVar = Ia.k.c();
        }
        kVar.add(s10);
        AbstractC5974I abstractC5974I = K02 instanceof AbstractC5974I ? (AbstractC5974I) K02 : null;
        if (abstractC5974I != null && (d(abstractC5974I.P0(), interfaceC5074l, kVar) || d(abstractC5974I.Q0(), interfaceC5074l, kVar))) {
            return true;
        }
        if ((K02 instanceof C6017x) && d(((C6017x) K02).T0(), interfaceC5074l, kVar)) {
            return true;
        }
        v0 v0VarH0 = s10.H0();
        if (v0VarH0 instanceof C5982Q) {
            Iterator<S> it = ((C5982Q) v0VarH0).e().iterator();
            while (it.hasNext()) {
                if (d(it.next(), interfaceC5074l, kVar)) {
                    return true;
                }
            }
            return false;
        }
        for (B0 b02 : s10.F0()) {
            if (!b02.b() && d(b02.getType(), interfaceC5074l, kVar)) {
                return true;
            }
        }
        return false;
    }

    public static S e(S s10, S s11, TypeSubstitutor typeSubstitutor) {
        if (s10 == null) {
            a(20);
        }
        if (s11 == null) {
            a(21);
        }
        if (typeSubstitutor == null) {
            a(22);
        }
        S sQ = typeSubstitutor.q(s11, Variance.INVARIANT);
        if (sQ != null) {
            return q(sQ, s10.I0());
        }
        return null;
    }

    public static InterfaceC0797b f(S s10) {
        if (s10 == null) {
            a(30);
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD;
        }
        return null;
    }

    public static List<B0> g(List<E9.b0> list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<E9.b0> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new D0(it.next().n()));
        }
        List<B0> listM1 = Z8.F.m1(arrayList);
        if (listM1 == null) {
            a(17);
        }
        return listM1;
    }

    public static List<S> h(S s10) {
        if (s10 == null) {
            a(18);
        }
        TypeSubstitutor typeSubstitutorG = TypeSubstitutor.g(s10);
        Collection<S> collectionE = s10.H0().e();
        ArrayList arrayList = new ArrayList(collectionE.size());
        Iterator<S> it = collectionE.iterator();
        while (it.hasNext()) {
            S sE = e(s10, it.next(), typeSubstitutorG);
            if (sE != null) {
                arrayList.add(sE);
            }
        }
        return arrayList;
    }

    public static E9.b0 i(S s10) {
        if (s10 == null) {
            a(63);
        }
        if (s10.H0().d() instanceof E9.b0) {
            return (E9.b0) s10.H0().d();
        }
        return null;
    }

    public static boolean j(S s10) {
        if (s10 == null) {
            a(29);
        }
        if (s10.H0().d() instanceof InterfaceC0797b) {
            return false;
        }
        Iterator<S> it = h(s10).iterator();
        while (it.hasNext()) {
            if (l(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(S s10) {
        return s10 != null && s10.H0() == f44023a.H0();
    }

    public static boolean l(S s10) {
        if (s10 == null) {
            a(27);
        }
        if (s10.I0()) {
            return true;
        }
        if (C5977L.b(s10) && l(C5977L.a(s10).Q0())) {
            return true;
        }
        if (C5998h0.c(s10)) {
            return false;
        }
        if (m(s10)) {
            return j(s10);
        }
        if (s10 instanceof AbstractC5989d) {
            E9.b0 b0VarB = ((AbstractC5989d) s10).Q0().b();
            return b0VarB == null || j(b0VarB.n());
        }
        v0 v0VarH0 = s10.H0();
        if (v0VarH0 instanceof C5982Q) {
            Iterator<S> it = v0VarH0.e().iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(S s10) {
        if (s10 == null) {
            a(60);
        }
        return i(s10) != null || (s10.H0() instanceof InterfaceC6465k);
    }

    public static S n(S s10) {
        if (s10 == null) {
            a(2);
        }
        return p(s10, false);
    }

    public static S o(S s10) {
        if (s10 == null) {
            a(1);
        }
        return p(s10, true);
    }

    public static S p(S s10, boolean z10) {
        if (s10 == null) {
            a(3);
        }
        K0 k0L0 = s10.K0().L0(z10);
        if (k0L0 == null) {
            a(4);
        }
        return k0L0;
    }

    public static S q(S s10, boolean z10) {
        if (s10 == null) {
            a(8);
        }
        if (z10) {
            return o(s10);
        }
        if (s10 == null) {
            a(9);
        }
        return s10;
    }

    public static AbstractC5990d0 r(AbstractC5990d0 abstractC5990d0, boolean z10) {
        if (abstractC5990d0 == null) {
            a(5);
        }
        if (!z10) {
            if (abstractC5990d0 == null) {
                a(7);
            }
            return abstractC5990d0;
        }
        AbstractC5990d0 abstractC5990d0L0 = abstractC5990d0.L0(true);
        if (abstractC5990d0L0 == null) {
            a(6);
        }
        return abstractC5990d0L0;
    }

    public static B0 s(E9.b0 b0Var) {
        if (b0Var == null) {
            a(45);
        }
        return new C6004k0(b0Var);
    }

    public static B0 t(E9.b0 b0Var, C5972G c5972g) {
        if (b0Var == null) {
            a(46);
        }
        return c5972g.b() == TypeUsage.SUPERTYPE ? new D0(C6006l0.b(b0Var)) : new C6004k0(b0Var);
    }

    public static AbstractC5990d0 u(InterfaceC0799d interfaceC0799d, InterfaceC5238k interfaceC5238k, InterfaceC5074l<kotlin.reflect.jvm.internal.impl.types.checker.c, AbstractC5990d0> interfaceC5074l) {
        if (!Aa.i.m(interfaceC0799d)) {
            return v(interfaceC0799d.j(), interfaceC5238k, interfaceC5074l);
        }
        Aa.g gVarD = Aa.i.d(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, interfaceC0799d.toString());
        if (gVarD == null) {
            a(11);
        }
        return gVarD;
    }

    public static AbstractC5990d0 v(v0 v0Var, InterfaceC5238k interfaceC5238k, InterfaceC5074l<kotlin.reflect.jvm.internal.impl.types.checker.c, AbstractC5990d0> interfaceC5074l) {
        if (v0Var == null) {
            a(12);
        }
        if (interfaceC5238k == null) {
            a(13);
        }
        if (interfaceC5074l == null) {
            a(14);
        }
        AbstractC5990d0 abstractC5990d0P = V.p(s0.f44124b.k(), v0Var, g(v0Var.getParameters()), false, interfaceC5238k, interfaceC5074l);
        if (abstractC5990d0P == null) {
            a(15);
        }
        return abstractC5990d0P;
    }

    public static boolean w(S s10) {
        if (s10 == null) {
            a(0);
        }
        return s10 == f44025c || s10 == f44026d;
    }
}

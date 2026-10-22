package aa;

import E9.InterfaceC0799d;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import p9.InterfaceC5074l;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5977L;
import ya.C5998h0;
import ya.H0;
import ya.K0;
import ya.s0;
import ya.t0;
import ya.v0;

/* renamed from: aa.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1260h {

    /* renamed from: a, reason: collision with root package name */
    public final V9.e f8135a;

    /* renamed from: aa.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ya.S f8136a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8137b;

        public a(ya.S s10, int i10) {
            this.f8136a = s10;
            this.f8137b = i10;
        }

        public final int a() {
            return this.f8137b;
        }

        public final ya.S b() {
            return this.f8136a;
        }
    }

    /* renamed from: aa.h$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC5990d0 f8138a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8139b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f8140c;

        public b(AbstractC5990d0 abstractC5990d0, int i10, boolean z10) {
            this.f8138a = abstractC5990d0;
            this.f8139b = i10;
            this.f8140c = z10;
        }

        public final boolean a() {
            return this.f8140c;
        }

        public final int b() {
            return this.f8139b;
        }

        public final AbstractC5990d0 c() {
            return this.f8138a;
        }
    }

    public C1260h(V9.e javaResolverSettings) {
        kotlin.jvm.internal.p.i(javaResolverSettings, "javaResolverSettings");
        this.f8135a = javaResolverSettings;
    }

    public static /* synthetic */ b c(C1260h c1260h, AbstractC5990d0 abstractC5990d0, InterfaceC5074l interfaceC5074l, int i10, TypeComponentPosition typeComponentPosition, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        return c1260h.b(abstractC5990d0, interfaceC5074l, i10, typeComponentPosition, z10, z11);
    }

    public final ya.S a(ya.S s10, InterfaceC5074l<? super Integer, C1261i> qualifiers, boolean z10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        kotlin.jvm.internal.p.i(qualifiers, "qualifiers");
        return d(s10.K0(), qualifiers, 0, z10).b();
    }

    public final b b(AbstractC5990d0 abstractC5990d0, InterfaceC5074l<? super Integer, C1261i> interfaceC5074l, int i10, TypeComponentPosition typeComponentPosition, boolean z10, boolean z11) {
        InterfaceC0799d interfaceC0799dD;
        v0 v0VarH0;
        Boolean bool;
        a aVar;
        B0 b0S;
        InterfaceC5074l<? super Integer, C1261i> interfaceC5074l2 = interfaceC5074l;
        boolean zA = o0.a(typeComponentPosition);
        boolean z12 = (z11 && z10) ? false : true;
        ya.S s10 = null;
        if ((zA || !abstractC5990d0.F0().isEmpty()) && (interfaceC0799dD = abstractC5990d0.H0().d()) != null) {
            C1261i c1261iInvoke = interfaceC5074l2.invoke(Integer.valueOf(i10));
            InterfaceC0799d interfaceC0799dF = q0.f(interfaceC0799dD, c1261iInvoke, typeComponentPosition);
            Boolean boolH = q0.h(c1261iInvoke, typeComponentPosition);
            if (interfaceC0799dF == null || (v0VarH0 = interfaceC0799dF.j()) == null) {
                v0VarH0 = abstractC5990d0.H0();
            }
            v0 v0Var = v0VarH0;
            int iA = i10 + 1;
            List<B0> listF0 = abstractC5990d0.F0();
            List<E9.b0> parameters = v0Var.getParameters();
            kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
            List<E9.b0> list = parameters;
            Iterator<T> it = listF0.iterator();
            Iterator<T> it2 = list.iterator();
            ArrayList arrayList = new ArrayList(Math.min(C1174w.x(listF0, 10), C1174w.x(list, 10)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                E9.b0 b0Var = (E9.b0) it2.next();
                B0 b02 = (B0) next;
                if (z12) {
                    bool = boolH;
                    if (!b02.b()) {
                        aVar = d(b02.getType().K0(), interfaceC5074l2, iA, z11);
                    } else if (interfaceC5074l2.invoke(Integer.valueOf(iA)).f() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                        K0 K02 = b02.getType().K0();
                        aVar = new a(ya.V.e(C5977L.c(K02).L0(false), C5977L.d(K02).L0(true)), 1);
                    } else {
                        aVar = new a(null, 1);
                    }
                } else {
                    bool = boolH;
                    aVar = new a(s10, 0);
                }
                iA += aVar.a();
                if (aVar.b() != null) {
                    ya.S sB = aVar.b();
                    Variance varianceC = b02.c();
                    kotlin.jvm.internal.p.h(varianceC, "getProjectionKind(...)");
                    b0S = Da.d.k(sB, varianceC, b0Var);
                } else if (interfaceC0799dF == null || b02.b()) {
                    b0S = interfaceC0799dF != null ? H0.s(b0Var) : null;
                } else {
                    ya.S type = b02.getType();
                    kotlin.jvm.internal.p.h(type, "getType(...)");
                    Variance varianceC2 = b02.c();
                    kotlin.jvm.internal.p.h(varianceC2, "getProjectionKind(...)");
                    b0S = Da.d.k(type, varianceC2, b0Var);
                }
                arrayList.add(b0S);
                interfaceC5074l2 = interfaceC5074l;
                boolH = bool;
                s10 = null;
            }
            Boolean bool2 = boolH;
            int i11 = iA - i10;
            if (interfaceC0799dF == null && bool2 == null) {
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        if (((B0) it3.next()) == null) {
                        }
                    }
                }
                return new b(null, i11, false);
            }
            F9.g annotations = abstractC5990d0.getAnnotations();
            C1259g c1259g = q0.f8176b;
            if (interfaceC0799dF == null) {
                c1259g = null;
            }
            s0 s0VarB = t0.b(q0.e(C1173v.r(annotations, c1259g, bool2 != null ? q0.g() : null)));
            List<B0> listF02 = abstractC5990d0.F0();
            Iterator it4 = arrayList.iterator();
            Iterator<T> it5 = listF02.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(C1174w.x(arrayList, 10), C1174w.x(listF02, 10)));
            while (it4.hasNext() && it5.hasNext()) {
                Object next2 = it4.next();
                B0 b03 = (B0) it5.next();
                B0 b04 = (B0) next2;
                if (b04 != null) {
                    b03 = b04;
                }
                arrayList2.add(b03);
            }
            AbstractC5990d0 abstractC5990d0M = ya.V.m(s0VarB, v0Var, arrayList2, bool2 != null ? bool2.booleanValue() : abstractC5990d0.I0(), null, 16, null);
            if (c1261iInvoke.d()) {
                abstractC5990d0M = e(abstractC5990d0M);
            }
            return new b(abstractC5990d0M, i11, bool2 != null && c1261iInvoke.g());
        }
        return new b(null, 1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final aa.C1260h.a d(ya.K0 r21, p9.InterfaceC5074l<? super java.lang.Integer, aa.C1261i> r22, int r23, boolean r24) {
        /*
            r20 = this;
            r0 = r21
            boolean r1 = ya.W.a(r0)
            r2 = 0
            if (r1 == 0) goto L10
            aa.h$a r0 = new aa.h$a
            r1 = 1
            r0.<init>(r2, r1)
            return r0
        L10:
            boolean r1 = r0 instanceof ya.AbstractC5974I
            if (r1 == 0) goto Lb2
            boolean r8 = r0 instanceof ya.InterfaceC5988c0
            r1 = r0
            ya.I r1 = (ya.AbstractC5974I) r1
            ya.d0 r4 = r1.P0()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r3 = r20
            r5 = r22
            r6 = r23
            r9 = r24
            aa.h$b r10 = r3.b(r4, r5, r6, r7, r8, r9)
            ya.d0 r4 = r1.Q0()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            aa.h$b r3 = r3.b(r4, r5, r6, r7, r8, r9)
            r10.b()
            r3.b()
            ya.d0 r4 = r10.c()
            if (r4 != 0) goto L48
            ya.d0 r4 = r3.c()
            if (r4 != 0) goto L48
            goto La8
        L48:
            boolean r2 = r10.a()
            if (r2 != 0) goto L8a
            boolean r2 = r3.a()
            if (r2 == 0) goto L55
            goto L8a
        L55:
            if (r8 == 0) goto L71
            X9.j r2 = new X9.j
            ya.d0 r0 = r10.c()
            if (r0 != 0) goto L63
            ya.d0 r0 = r1.P0()
        L63:
            ya.d0 r3 = r3.c()
            if (r3 != 0) goto L6d
            ya.d0 r3 = r1.Q0()
        L6d:
            r2.<init>(r0, r3)
            goto La8
        L71:
            ya.d0 r0 = r10.c()
            if (r0 != 0) goto L7b
            ya.d0 r0 = r1.P0()
        L7b:
            ya.d0 r2 = r3.c()
            if (r2 != 0) goto L85
            ya.d0 r2 = r1.Q0()
        L85:
            ya.K0 r2 = ya.V.e(r0, r2)
            goto La8
        L8a:
            ya.d0 r1 = r3.c()
            if (r1 == 0) goto L9d
            ya.d0 r2 = r10.c()
            if (r2 != 0) goto L97
            r2 = r1
        L97:
            ya.K0 r1 = ya.V.e(r2, r1)
            if (r1 != 0) goto La4
        L9d:
            ya.d0 r1 = r10.c()
            kotlin.jvm.internal.p.f(r1)
        La4:
            ya.K0 r2 = ya.J0.d(r0, r1)
        La8:
            aa.h$a r0 = new aa.h$a
            int r1 = r10.b()
            r0.<init>(r2, r1)
            return r0
        Lb2:
            boolean r1 = r0 instanceof ya.AbstractC5990d0
            if (r1 == 0) goto Lea
            r12 = r0
            ya.d0 r12 = (ya.AbstractC5990d0) r12
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r15 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r18 = 8
            r19 = 0
            r16 = 0
            r11 = r20
            r13 = r22
            r14 = r23
            r17 = r24
            aa.h$b r1 = c(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            aa.h$a r2 = new aa.h$a
            boolean r3 = r1.a()
            if (r3 == 0) goto Lde
            ya.d0 r3 = r1.c()
            ya.K0 r0 = ya.J0.d(r0, r3)
            goto Le2
        Lde:
            ya.d0 r0 = r1.c()
        Le2:
            int r1 = r1.b()
            r2.<init>(r0, r1)
            return r2
        Lea:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.C1260h.d(ya.K0, p9.l, int, boolean):aa.h$a");
    }

    public final AbstractC5990d0 e(AbstractC5990d0 abstractC5990d0) {
        return this.f8135a.a() ? C5998h0.h(abstractC5990d0, true) : new C1262j(abstractC5990d0);
    }
}

package b8;

import h8.AbstractC1532o;
import h8.InterfaceC1522e;
import h8.InterfaceC1536s;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k8.AbstractC1644m;
import k8.C1640i;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;

/* renamed from: b8.E, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0832E extends AbstractC0857s implements kotlin.jvm.internal.h, Z7.g, InterfaceC0844e {
    public static final /* synthetic */ Z7.t[] m;
    public final AbstractC0830C g;
    public final String h;
    public final Object i;

    /* renamed from: j, reason: collision with root package name */
    public final p0 f2019j;
    public final Object k;
    public final Object l;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        m = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(C0832E.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;"))};
    }

    public C0832E(AbstractC0830C abstractC0830C, String str, String str2, InterfaceC1536s interfaceC1536s, Object obj) {
        this.g = abstractC0830C;
        this.h = str2;
        this.i = obj;
        this.f2019j = N9.j.E(interfaceC1536s, new J4.e(6, this, str));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.k = kotlin.a.b(lazyThreadSafetyMode, new C0831D(this, 0));
        this.l = kotlin.a.b(lazyThreadSafetyMode, new C0831D(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // b8.AbstractC0857s
    public final c8.e d() {
        return (c8.e) this.k.getF4884a();
    }

    @Override // b8.AbstractC0857s
    public final AbstractC0830C e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        C0832E c0832eB = v0.b(obj);
        return c0832eB != null && kotlin.jvm.internal.k.b(this.g, c0832eB.g) && getName().equals(c0832eB.getName()) && kotlin.jvm.internal.k.b(this.h, c0832eB.h) && kotlin.jvm.internal.k.b(this.i, c0832eB.i);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // b8.AbstractC0857s
    public final c8.e f() {
        return (c8.e) this.l.getF4884a();
    }

    @Override // kotlin.jvm.internal.h
    public final int getArity() {
        return z2.l.y(d());
    }

    @Override // Z7.c
    public final String getName() {
        String strB = ((AbstractC1644m) g()).getName().b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        return strB;
    }

    public final int hashCode() {
        return this.h.hashCode() + ((getName().hashCode() + (this.g.hashCode() * 31)) * 31);
    }

    @Override // S7.a
    public final Object invoke() {
        return call(new Object[0]);
    }

    @Override // Z7.g
    public final boolean isExternal() {
        return g().isExternal();
    }

    @Override // Z7.g
    public final boolean isInfix() {
        return g().isInfix();
    }

    @Override // Z7.g
    public final boolean isInline() {
        return g().isInline();
    }

    @Override // Z7.g
    public final boolean isOperator() {
        return g().isOperator();
    }

    @Override // Z7.c
    public final boolean isSuspend() {
        return g().isSuspend();
    }

    @Override // b8.AbstractC0857s
    public final boolean n() {
        return this.i != CallableReference.NO_RECEIVER;
    }

    public final c8.v o(Constructor constructor, InterfaceC1536s interfaceC1536s, boolean z10) {
        Object obj = this.i;
        Class cls = null;
        if (!z10) {
            C1640i c1640i = interfaceC1536s instanceof C1640i ? (C1640i) interfaceC1536s : null;
            if (c1640i != null) {
                C1640i c1640i2 = c1640i;
                if (!AbstractC1532o.e(c1640i2.getVisibility())) {
                    InterfaceC1522e interfaceC1522eB0 = c1640i.b0();
                    kotlin.jvm.internal.k.e(interfaceC1522eB0, "getConstructedClass(...)");
                    if (!J8.g.f(interfaceC1522eB0) && !J8.e.q(c1640i.b0())) {
                        List listX = c1640i2.x();
                        kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
                        List list = listX;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                X8.w type = ((k8.Q) it.next()).getType();
                                kotlin.jvm.internal.k.e(type, "getType(...)");
                                if (U7.a.S(type)) {
                                    if (n()) {
                                        return new c8.f(constructor, H4.o.u(obj, g()), 0);
                                    }
                                    kotlin.jvm.internal.k.f(constructor, "constructor");
                                    Class declaringClass = constructor.getDeclaringClass();
                                    kotlin.jvm.internal.k.e(declaringClass, "getDeclaringClass(...)");
                                    Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                                    kotlin.jvm.internal.k.e(genericParameterTypes, "getGenericParameterTypes(...)");
                                    return new c8.g(constructor, declaringClass, cls, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : D7.q.d0(genericParameterTypes, 0, genericParameterTypes.length - 1)), 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (n()) {
            return new c8.f(constructor, H4.o.u(obj, g()), 1);
        }
        kotlin.jvm.internal.k.f(constructor, "constructor");
        Class declaringClass2 = constructor.getDeclaringClass();
        kotlin.jvm.internal.k.e(declaringClass2, "getDeclaringClass(...)");
        Class declaringClass3 = constructor.getDeclaringClass();
        Class<?> declaringClass4 = declaringClass3.getDeclaringClass();
        Class<?> cls2 = (declaringClass4 == null || Modifier.isStatic(declaringClass3.getModifiers())) ? null : declaringClass4;
        Type[] genericParameterTypes2 = constructor.getGenericParameterTypes();
        kotlin.jvm.internal.k.e(genericParameterTypes2, "getGenericParameterTypes(...)");
        return new c8.g(constructor, declaringClass2, cls2, genericParameterTypes2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c8.u p(java.lang.reflect.Method r6) {
        /*
            r5 = this;
            boolean r0 = r5.n()
            if (r0 == 0) goto L43
            c8.r r0 = new c8.r
            h8.s r1 = r5.g()
            k8.u r1 = r1.E()
            java.lang.Object r2 = r5.i
            if (r1 == 0) goto L37
            X8.w r1 = r1.getType()
            boolean r1 = J8.g.c(r1)
            r3 = 1
            if (r1 != r3) goto L37
            java.lang.Class[] r1 = r6.getParameterTypes()
            java.lang.String r4 = "getParameterTypes(...)"
            kotlin.jvm.internal.k.e(r1, r4)
            java.lang.Object r1 = D7.q.n0(r1)
            java.lang.Class r1 = (java.lang.Class) r1
            if (r1 == 0) goto L37
            boolean r1 = r1.isInterface()
            if (r1 != r3) goto L37
            goto L3f
        L37:
            h8.s r5 = r5.g()
            java.lang.Object r2 = H4.o.u(r2, r5)
        L3f:
            r0.<init>(r6, r2)
            return r0
        L43:
            c8.t r5 = new c8.t
            r0 = 2
            r5.<init>(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.C0832E.p(java.lang.reflect.Method):c8.u");
    }

    @Override // b8.AbstractC0857s
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final InterfaceC1536s g() {
        Z7.t tVar = m[0];
        Object objInvoke = this.f2019j.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
        return (InterfaceC1536s) objInvoke;
    }

    public final String toString() {
        I8.g gVar = s0.f2054a;
        return s0.b(g());
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return call(obj);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return call(obj, obj2);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return call(obj, obj2, obj3);
    }

    @Override // S7.p
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return call(obj, obj2, obj3, obj4);
    }

    @Override // S7.q
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return call(obj, obj2, obj3, obj4, obj5);
    }

    @Override // S7.r
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return call(obj, obj2, obj3, obj4, obj5, obj6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public C0832E(AbstractC0830C abstractC0830C, InterfaceC1536s descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        String strB = ((AbstractC1644m) descriptor).getName().b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        this(abstractC0830C, strB, t0.c(descriptor).z(), descriptor, CallableReference.NO_RECEIVER);
    }

    @Override // S7.s
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // S7.t
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // S7.u
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // S7.b
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // S7.c
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // S7.d
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // S7.e
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // S7.f
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // S7.g
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // S7.h
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // S7.i
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // S7.j
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // S7.l
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // S7.m
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }
}

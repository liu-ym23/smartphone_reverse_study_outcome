package z7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class g0 extends s implements q7.g, w7.g, f {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f11866p;

    /* renamed from: j, reason: collision with root package name */
    public final e0 f11867j;

    /* renamed from: k, reason: collision with root package name */
    public final String f11868k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f11869l;

    /* renamed from: m, reason: collision with root package name */
    public final q1 f11870m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f11871n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f11872o;

    static {
        q7.x xVar = q7.w.f8821a;
        f11866p = new w7.t[]{xVar.f(new q7.p(xVar.b(g0.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;"))};
    }

    public g0(e0 e0Var, String str, String str2, f8.t tVar, Object obj) {
        this.f11867j = e0Var;
        this.f11868k = str2;
        this.f11869l = obj;
        this.f11870m = s1.l(tVar, new a8.e(23, this, str));
        c7.h hVar = c7.h.f1970f;
        this.f11871n = s7.a.G(hVar, new f0(this, 0));
        this.f11872o = s7.a.G(hVar, new f0(this, 1));
    }

    public static final a8.w E(g0 g0Var, Constructor constructor, f8.t tVar, boolean z4) {
        Object obj = g0Var.f11869l;
        if (!z4) {
            i8.i iVar = tVar instanceof i8.i ? (i8.i) tVar : null;
            if (iVar != null) {
                i8.i iVar2 = iVar;
                if (!f8.o.e(iVar2.c())) {
                    f8.e eVarH = iVar.H();
                    q7.k.d(eVarH, "constructorDescriptor.constructedClass");
                    if (!h9.h.b(eVarH) && !h9.f.q(iVar.H())) {
                        List listX0 = iVar2.x0();
                        q7.k.d(listX0, "constructorDescriptor.valueParameters");
                        if (!listX0.isEmpty()) {
                            Iterator it = listX0.iterator();
                            while (it.hasNext()) {
                                v9.v type = ((i8.r0) it.next()).getType();
                                q7.k.d(type, "it.type");
                                if (s7.a.T(type)) {
                                    if (g0Var.D()) {
                                        return new a8.i(constructor, ib.k.p(obj, g0Var.B()), 0);
                                    }
                                    Class declaringClass = constructor.getDeclaringClass();
                                    q7.k.d(declaringClass, "constructor.declaringClass");
                                    Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                                    q7.k.d(genericParameterTypes, "constructor.genericParameterTypes");
                                    return new a8.j(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : d7.n.c0(genericParameterTypes, 0, genericParameterTypes.length - 1)), 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (g0Var.D()) {
            return new a8.i(constructor, ib.k.p(obj, g0Var.B()), 1);
        }
        Class declaringClass2 = constructor.getDeclaringClass();
        q7.k.d(declaringClass2, "constructor.declaringClass");
        Class declaringClass3 = constructor.getDeclaringClass();
        Class<?> declaringClass4 = declaringClass3.getDeclaringClass();
        Class<?> cls = (declaringClass4 == null || Modifier.isStatic(declaringClass3.getModifiers())) ? null : declaringClass4;
        Type[] genericParameterTypes2 = constructor.getGenericParameterTypes();
        q7.k.d(genericParameterTypes2, "constructor.genericParameterTypes");
        return new a8.j(constructor, declaringClass2, cls, genericParameterTypes2, 1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // z7.s
    public final a8.h A() {
        return (a8.h) this.f11872o.getValue();
    }

    @Override // z7.s
    public final boolean D() {
        return !q7.k.a(this.f11869l, q7.b.f8796f);
    }

    @Override // z7.s
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final f8.t B() {
        w7.t tVar = f11866p[0];
        Object objC = this.f11870m.c();
        q7.k.d(objC, "<get-descriptor>(...)");
        return (f8.t) objC;
    }

    @Override // p7.a
    public final Object c() {
        return e.invoke(this);
    }

    public final boolean equals(Object obj) {
        g0 g0VarB = x1.b(obj);
        return g0VarB != null && q7.k.a(this.f11867j, g0VarB.f11867j) && getName().equals(g0VarB.getName()) && q7.k.a(this.f11868k, g0VarB.f11868k) && q7.k.a(this.f11869l, g0VarB.f11869l);
    }

    @Override // q7.g
    public final int getArity() {
        return ib.c.A(y());
    }

    @Override // w7.c
    public final String getName() {
        String strB = ((i8.m) B()).getName().b();
        q7.k.d(strB, "descriptor.name.asString()");
        return strB;
    }

    public final int hashCode() {
        return this.f11868k.hashCode() + ((getName().hashCode() + (this.f11867j.hashCode() * 31)) * 31);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        return e.invoke(this, obj);
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        return e.invoke(this, obj, obj2, obj3);
    }

    @Override // w7.c
    public final boolean o() {
        return B().o();
    }

    public final String toString() {
        g9.g gVar = u1.f11967a;
        return u1.b(B());
    }

    @Override // p7.p
    public final Object u(Object obj, Object obj2, Object obj3, Object obj4) {
        return e.invoke(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // z7.s
    public final a8.h y() {
        return (a8.h) this.f11871n.getValue();
    }

    @Override // z7.s
    public final e0 z() {
        return this.f11867j;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return e.invoke(this, obj, obj2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public g0(e0 e0Var, f8.t tVar) {
        q7.k.e(tVar, "descriptor");
        String strB = ((i8.m) tVar).getName().b();
        q7.k.d(strB, "descriptor.name.asString()");
        this(e0Var, strB, v1.c(tVar).f(), tVar, q7.b.f8796f);
    }
}

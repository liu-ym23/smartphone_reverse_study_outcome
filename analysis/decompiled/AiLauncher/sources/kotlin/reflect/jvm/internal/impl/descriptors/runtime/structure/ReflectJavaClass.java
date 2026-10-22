package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import E9.l0;
import E9.m0;
import I9.a;
import I9.b;
import K9.C;
import K9.C0921b;
import K9.C0925f;
import K9.C0926g;
import K9.E;
import K9.j;
import K9.k;
import K9.n;
import K9.o;
import K9.s;
import K9.t;
import K9.v;
import K9.y;
import K9.z;
import La.H;
import Z8.C1173v;
import Z8.C1174w;
import Z8.r;
import Z9.InterfaceC1178a;
import Z9.g;
import Z9.w;
import ga.c;
import ga.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes5.dex */
public final class ReflectJavaClass extends t implements j, z, g {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f35011a;

    public ReflectJavaClass(Class<?> klass) {
        p.i(klass, "klass");
        this.f35011a = klass;
    }

    public static final boolean M(Class cls) {
        String simpleName = cls.getSimpleName();
        p.h(simpleName, "getSimpleName(...)");
        return simpleName.length() == 0;
    }

    public static final e N(Class cls) {
        String simpleName = cls.getSimpleName();
        if (!e.l(simpleName)) {
            simpleName = null;
        }
        if (simpleName != null) {
            return e.j(simpleName);
        }
        return null;
    }

    public static final boolean O(ReflectJavaClass reflectJavaClass, Method method) {
        if (method.isSynthetic()) {
            return false;
        }
        if (!reflectJavaClass.v()) {
            return true;
        }
        p.f(method);
        return !reflectJavaClass.Y(method);
    }

    @Override // Z9.d
    public boolean A() {
        return false;
    }

    @Override // Z9.g
    public boolean F() {
        return this.f35011a.isInterface();
    }

    @Override // Z9.g
    public LightClassOriginKind G() {
        return null;
    }

    @Override // Z9.g
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<s> h() throws SecurityException {
        Constructor<?>[] declaredConstructors = this.f35011a.getDeclaredConstructors();
        p.h(declaredConstructors, "getDeclaredConstructors(...)");
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.G(r.M(declaredConstructors), ReflectJavaClass$constructors$1.f35012a), ReflectJavaClass$constructors$2.f35013a));
    }

    @Override // K9.j
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public Class<?> s() {
        return this.f35011a;
    }

    @Override // Z9.g
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public List<v> getFields() {
        Field[] declaredFields = this.f35011a.getDeclaredFields();
        p.h(declaredFields, "getDeclaredFields(...)");
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.G(r.M(declaredFields), ReflectJavaClass$fields$1.f35014a), ReflectJavaClass$fields$2.f35015a));
    }

    @Override // Z9.g
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public List<e> y() {
        Class<?>[] declaredClasses = this.f35011a.getDeclaredClasses();
        p.h(declaredClasses, "getDeclaredClasses(...)");
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.S(SequencesKt___SequencesKt.G(r.M(declaredClasses), n.f4184a), o.f4185a));
    }

    @Override // Z9.g
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public List<y> z() throws SecurityException {
        Method[] declaredMethods = this.f35011a.getDeclaredMethods();
        p.h(declaredMethods, "getDeclaredMethods(...)");
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(r.M(declaredMethods), new K9.p(this)), ReflectJavaClass$methods$2.f35016a));
    }

    @Override // Z9.g
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public ReflectJavaClass l() {
        Class<?> declaringClass = this.f35011a.getDeclaringClass();
        if (declaringClass != null) {
            return new ReflectJavaClass(declaringClass);
        }
        return null;
    }

    public final boolean Y(Method method) {
        String name = method.getName();
        if (p.d(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            p.h(parameterTypes, "getParameterTypes(...)");
            return parameterTypes.length == 0;
        }
        if (p.d(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // Z9.d
    public /* bridge */ /* synthetic */ InterfaceC1178a d(c cVar) {
        return d(cVar);
    }

    @Override // Z9.g
    public Collection<Z9.j> e() {
        Class cls;
        cls = Object.class;
        if (p.d(this.f35011a, cls)) {
            return C1173v.m();
        }
        x xVar = new x(2);
        Object genericSuperclass = this.f35011a.getGenericSuperclass();
        xVar.a(genericSuperclass != null ? genericSuperclass : Object.class);
        xVar.b(this.f35011a.getGenericInterfaces());
        List listP = C1173v.p(xVar.d(new Type[xVar.c()]));
        ArrayList arrayList = new ArrayList(C1174w.x(listP, 10));
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            arrayList.add(new K9.r((Type) it.next()));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaClass) && p.d(this.f35011a, ((ReflectJavaClass) obj).f35011a);
    }

    @Override // Z9.g
    public c f() {
        return C0925f.e(this.f35011a).a();
    }

    @Override // Z9.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // K9.z
    public int getModifiers() {
        return this.f35011a.getModifiers();
    }

    @Override // Z9.t
    public e getName() {
        if (!this.f35011a.isAnonymousClass()) {
            e eVarJ = e.j(this.f35011a.getSimpleName());
            p.f(eVarJ);
            return eVarJ;
        }
        String name = this.f35011a.getName();
        p.h(name, "getName(...)");
        e eVarJ2 = e.j(H.t1(name, ".", null, 2, null));
        p.f(eVarJ2);
        return eVarJ2;
    }

    @Override // Z9.z
    public List<E> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.f35011a.getTypeParameters();
        p.h(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new E(typeVariable));
        }
        return arrayList;
    }

    @Override // Z9.s
    public m0 getVisibility() {
        int modifiers = getModifiers();
        return Modifier.isPublic(modifiers) ? l0.h.f2464c : Modifier.isPrivate(modifiers) ? l0.e.f2461c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? I9.c.f3397c : b.f3396c : a.f3395c;
    }

    public int hashCode() {
        return this.f35011a.hashCode();
    }

    @Override // Z9.s
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // Z9.s
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // Z9.s
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // Z9.g
    public Collection<w> m() {
        Object[] objArrD = C0921b.f4159a.d(this.f35011a);
        if (objArrD == null) {
            objArrD = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArrD.length);
        for (Object obj : objArrD) {
            arrayList.add(new C(obj));
        }
        return arrayList;
    }

    @Override // Z9.g
    public boolean o() {
        return this.f35011a.isAnnotation();
    }

    @Override // Z9.g
    public boolean q() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Boolean boolE = C0921b.f4159a.e(this.f35011a);
        if (boolE != null) {
            return boolE.booleanValue();
        }
        return false;
    }

    @Override // Z9.g
    public boolean r() {
        return false;
    }

    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.f35011a;
    }

    @Override // Z9.g
    public boolean v() {
        return this.f35011a.isEnum();
    }

    @Override // Z9.g
    public boolean w() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Boolean boolF = C0921b.f4159a.f(this.f35011a);
        if (boolF != null) {
            return boolF.booleanValue();
        }
        return false;
    }

    @Override // K9.j, Z9.d
    public C0926g d(c fqName) {
        Annotation[] declaredAnnotations;
        p.i(fqName, "fqName");
        AnnotatedElement annotatedElementS = s();
        if (annotatedElementS == null || (declaredAnnotations = annotatedElementS.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    @Override // K9.j, Z9.d
    public List<C0926g> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<C0926g> listB;
        AnnotatedElement annotatedElementS = s();
        return (annotatedElementS == null || (declaredAnnotations = annotatedElementS.getDeclaredAnnotations()) == null || (listB = k.b(declaredAnnotations)) == null) ? C1173v.m() : listB;
    }
}

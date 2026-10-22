package J9;

import C9.o;
import K9.C0925f;
import Z8.r;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import ma.C4926f;
import o9.C5013a;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f3791a = new c();

    public final C4926f a(Class<?> cls) {
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
            p.h(cls, "getComponentType(...)");
        }
        if (cls.isPrimitive()) {
            if (p.d(cls, Void.TYPE)) {
                return new C4926f(ga.b.f32721d.c(o.a.f1904f.m()), i10);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            p.h(primitiveType, "getPrimitiveType(...)");
            return i10 > 0 ? new C4926f(ga.b.f32721d.c(primitiveType.getArrayTypeFqName()), i10 - 1) : new C4926f(ga.b.f32721d.c(primitiveType.getTypeFqName()), i10);
        }
        ga.b bVarE = C0925f.e(cls);
        ga.b bVarM = D9.a.f2270a.m(bVarE.a());
        if (bVarM != null) {
            bVarE = bVarM;
        }
        return new C4926f(bVarE, i10);
    }

    public final void b(Class<?> klass, f.c visitor) {
        p.i(klass, "klass");
        p.i(visitor, "visitor");
        Annotation[] declaredAnnotations = klass.getDeclaredAnnotations();
        p.h(declaredAnnotations, "getDeclaredAnnotations(...)");
        for (Annotation annotation : declaredAnnotations) {
            p.f(annotation);
            f(visitor, annotation);
        }
        visitor.a();
    }

    public final void c(Class<?> cls, f.d dVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] constructorArr;
        int i10;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        p.h(declaredConstructors, "getDeclaredConstructors(...)");
        int length = declaredConstructors.length;
        int i11 = 0;
        while (i11 < length) {
            Constructor<?> constructor = declaredConstructors[i11];
            ga.e eVar = ga.g.f32750j;
            m mVar = m.f3805a;
            p.f(constructor);
            f.e eVarA = dVar.a(eVar, mVar.a(constructor));
            if (eVarA == null) {
                constructorArr = declaredConstructors;
                i10 = length;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                p.h(declaredAnnotations, "getDeclaredAnnotations(...)");
                for (Annotation annotation : declaredAnnotations) {
                    p.f(annotation);
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                p.f(parameterAnnotations);
                if (!(parameterAnnotations.length == 0)) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i12 = 0; i12 < length3; i12++) {
                        Annotation[] annotationArr = parameterAnnotations[i12];
                        p.f(annotationArr);
                        int length4 = annotationArr.length;
                        int i13 = 0;
                        while (i13 < length4) {
                            Annotation annotation2 = annotationArr[i13];
                            Class<?> clsB = C5013a.b(C5013a.a(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            ga.b bVarE = C0925f.e(clsB);
                            int i14 = length;
                            p.f(annotation2);
                            f.a aVarC = eVarA.c(i12 + length2, bVarE, new b(annotation2));
                            if (aVarC != null) {
                                f3791a.h(aVarC, annotation2, clsB);
                            }
                            i13++;
                            declaredConstructors = constructorArr2;
                            length = i14;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                i10 = length;
                eVarA.a();
            }
            i11++;
            declaredConstructors = constructorArr;
            length = i10;
        }
    }

    public final void d(Class<?> cls, f.d dVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Field[] declaredFields = cls.getDeclaredFields();
        p.h(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            ga.e eVarJ = ga.e.j(field.getName());
            p.h(eVarJ, "identifier(...)");
            m mVar = m.f3805a;
            p.f(field);
            f.c cVarB = dVar.b(eVarJ, mVar.b(field), null);
            if (cVarB != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                p.h(declaredAnnotations, "getDeclaredAnnotations(...)");
                for (Annotation annotation : declaredAnnotations) {
                    p.f(annotation);
                    f(cVarB, annotation);
                }
                cVarB.a();
            }
        }
    }

    public final void e(Class<?> cls, f.d dVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        p.h(declaredMethods, "getDeclaredMethods(...)");
        for (Method method : declaredMethods) {
            ga.e eVarJ = ga.e.j(method.getName());
            p.h(eVarJ, "identifier(...)");
            m mVar = m.f3805a;
            p.f(method);
            f.e eVarA = dVar.a(eVarJ, mVar.c(method));
            if (eVarA != null) {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                p.h(declaredAnnotations, "getDeclaredAnnotations(...)");
                for (Annotation annotation : declaredAnnotations) {
                    p.f(annotation);
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                p.h(parameterAnnotations, "getParameterAnnotations(...)");
                Annotation[][] annotationArr = parameterAnnotations;
                int length = annotationArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    Annotation[] annotationArr2 = annotationArr[i10];
                    p.f(annotationArr2);
                    for (Annotation annotation2 : annotationArr2) {
                        Class<?> clsB = C5013a.b(C5013a.a(annotation2));
                        ga.b bVarE = C0925f.e(clsB);
                        p.f(annotation2);
                        f.a aVarC = eVarA.c(i10, bVarE, new b(annotation2));
                        if (aVarC != null) {
                            f3791a.h(aVarC, annotation2, clsB);
                        }
                    }
                }
                eVarA.a();
            }
        }
    }

    public final void f(f.c cVar, Annotation annotation) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> clsB = C5013a.b(C5013a.a(annotation));
        f.a aVarB = cVar.b(C0925f.e(clsB), new b(annotation));
        if (aVarB != null) {
            f3791a.h(aVarB, annotation, clsB);
        }
    }

    public final void g(f.a aVar, ga.e eVar, Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> enclosingClass = obj.getClass();
        if (p.d(enclosingClass, Class.class)) {
            p.g(obj, "null cannot be cast to non-null type java.lang.Class<*>");
            aVar.d(eVar, a((Class) obj));
            return;
        }
        if (i.f3798a.contains(enclosingClass)) {
            aVar.c(eVar, obj);
            return;
        }
        if (C0925f.l(enclosingClass)) {
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            p.f(enclosingClass);
            ga.b bVarE = C0925f.e(enclosingClass);
            p.g(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
            ga.e eVarJ = ga.e.j(((Enum) obj).name());
            p.h(eVarJ, "identifier(...)");
            aVar.b(eVar, bVarE, eVarJ);
            return;
        }
        if (Annotation.class.isAssignableFrom(enclosingClass)) {
            Class<?>[] interfaces = enclosingClass.getInterfaces();
            p.h(interfaces, "getInterfaces(...)");
            Class<?> cls = (Class) r.E0(interfaces);
            p.f(cls);
            f.a aVarF = aVar.f(eVar, C0925f.e(cls));
            if (aVarF == null) {
                return;
            }
            p.g(obj, "null cannot be cast to non-null type kotlin.Annotation");
            h(aVarF, (Annotation) obj, cls);
            return;
        }
        if (!enclosingClass.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + obj);
        }
        f.b bVarE2 = aVar.e(eVar);
        if (bVarE2 == null) {
            return;
        }
        Class<?> componentType = enclosingClass.getComponentType();
        int i10 = 0;
        if (componentType.isEnum()) {
            p.f(componentType);
            ga.b bVarE3 = C0925f.e(componentType);
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i10 < length) {
                Object obj2 = objArr[i10];
                p.g(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                ga.e eVarJ2 = ga.e.j(((Enum) obj2).name());
                p.h(eVarJ2, "identifier(...)");
                bVarE2.c(bVarE3, eVarJ2);
                i10++;
            }
        } else if (p.d(componentType, Class.class)) {
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            while (i10 < length2) {
                Object obj3 = objArr2[i10];
                p.g(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                bVarE2.b(a((Class) obj3));
                i10++;
            }
        } else if (Annotation.class.isAssignableFrom(componentType)) {
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr3 = (Object[]) obj;
            int length3 = objArr3.length;
            while (i10 < length3) {
                Object obj4 = objArr3[i10];
                p.f(componentType);
                f.a aVarD = bVarE2.d(C0925f.e(componentType));
                if (aVarD != null) {
                    p.g(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                    h(aVarD, (Annotation) obj4, componentType);
                }
                i10++;
            }
        } else {
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr4 = (Object[]) obj;
            int length4 = objArr4.length;
            while (i10 < length4) {
                bVarE2.e(objArr4[i10]);
                i10++;
            }
        }
        bVarE2.a();
    }

    public final void h(f.a aVar, Annotation annotation, Class<?> cls) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        p.h(declaredMethods, "getDeclaredMethods(...)");
        for (Method method : declaredMethods) {
            try {
                Object objInvoke = method.invoke(annotation, null);
                p.f(objInvoke);
                ga.e eVarJ = ga.e.j(method.getName());
                p.h(eVarJ, "identifier(...)");
                g(aVar, eVarJ, objInvoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void i(Class<?> klass, f.d memberVisitor) {
        p.i(klass, "klass");
        p.i(memberVisitor, "memberVisitor");
        e(klass, memberVisitor);
        c(klass, memberVisitor);
        d(klass, memberVisitor);
    }
}

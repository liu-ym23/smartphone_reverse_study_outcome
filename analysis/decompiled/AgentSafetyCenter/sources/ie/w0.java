package ie;

import java.lang.annotation.Annotation;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Type[] f6096a = new Type[0];

    public static ad.g0 c(ad.h0 h0Var) {
        od.i iVar = new od.i();
        h0Var.g().k(iVar);
        ad.s sVarE = h0Var.e();
        long jD = h0Var.d();
        ad.g0 g0Var = new ad.g0();
        g0Var.f506h = sVarE;
        g0Var.f505g = jD;
        g0Var.i = iVar;
        VarHandle.storeStoreFence();
        return g0Var;
    }

    public static void d(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            od.f.b();
        }
    }

    public static boolean e(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return e(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type f(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return f(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return f(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type g(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i >= 0 && i < actualTypeArguments.length) {
            Type type = actualTypeArguments[i];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        StringBuilder sbT = k0.a.t(i, "Index ", " not in range [0,");
        sbT.append(actualTypeArguments.length);
        sbT.append(") for ");
        sbT.append(parameterizedType);
        throw new IllegalArgumentException(sbT.toString());
    }

    public static Class h(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            od.f.b();
            return null;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        StringBuilder sb2 = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        sb2.append(type);
        g5.f.j(sb2, "> is of type ", type.getClass().getName());
        return null;
    }

    public static Type i(Type type, Class cls) {
        if (Map.class.isAssignableFrom(cls)) {
            return p(type, cls, f(type, cls, Map.class));
        }
        od.f.b();
        return null;
    }

    public static boolean j(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (!(type instanceof ParameterizedType)) {
            if (type instanceof GenericArrayType) {
                return j(((GenericArrayType) type).getGenericComponentType());
            }
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            g5.f.h("Expected a Class, ParameterizedType, or GenericArrayType, but <", type, "> is of type ", type == null ? "null" : type.getClass().getName());
            return false;
        }
        for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
            if (j(type2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(Annotation[] annotationArr, Class cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static IllegalArgumentException m(Method method, Exception exc, String str, Object... objArr) {
        StringBuilder sbV = k0.a.v(String.format(str, objArr), "\n    for method ");
        sbV.append(method.getDeclaringClass().getSimpleName());
        sbV.append(".");
        sbV.append(method.getName());
        return new IllegalArgumentException(sbV.toString(), exc);
    }

    public static IllegalArgumentException n(Method method, int i, String str, Object... objArr) {
        StringBuilder sbV = k0.a.v(str, " (parameter #");
        sbV.append(i + 1);
        sbV.append(")");
        return m(method, null, sbV.toString(), objArr);
    }

    public static IllegalArgumentException o(Method method, Exception exc, int i, String str, Object... objArr) {
        StringBuilder sbV = k0.a.v(str, " (parameter #");
        sbV.append(i + 1);
        sbV.append(")");
        return m(method, exc, sbV.toString(), objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type p(java.lang.reflect.Type r8, java.lang.Class r9, java.lang.reflect.Type r10) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ie.w0.p(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(java.lang.Exception r5, nb.c r6) {
        /*
            boolean r0 = r6 instanceof ie.r
            if (r0 == 0) goto L13
            r0 = r6
            ie.r r0 = (ie.r) r0
            int r1 = r0.f6073f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6073f = r1
            goto L18
        L13:
            ie.r r0 = new ie.r
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f6072c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f6073f
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            id.c.I(r6)
            jb.v r5 = jb.v.f6774a
            return r5
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L30:
            id.c.I(r6)
            r0.f6073f = r3
            rc.e r6 = kc.e0.f7430a
            nb.g r2 = r0.getContext()
            com.stepos.statsrpk.service.d r3 = new com.stepos.statsrpk.service.d
            r4 = 3
            r3.<init>(r4)
            r3.f2885f = r0
            r3.f2886g = r5
            java.lang.invoke.VarHandle.storeStoreFence()
            r6.M(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ie.w0.q(java.lang.Exception, nb.c):java.lang.Object");
    }

    public static void r(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public abstract void a(l0 l0Var, Object obj);

    public x b() {
        x xVar = new x(1);
        xVar.f6098c = this;
        VarHandle.storeStoreFence();
        return xVar;
    }

    public x l() {
        x xVar = new x(0);
        xVar.f6098c = this;
        VarHandle.storeStoreFence();
        return xVar;
    }
}

package com.fasterxml.jackson.databind.type;

import b3.d;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.a;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TypeFactory implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final JavaType[] f4467c = new JavaType[0];

    /* renamed from: d, reason: collision with root package name */
    public static final TypeFactory f4468d = new TypeFactory();

    /* renamed from: e, reason: collision with root package name */
    public static final TypeBindings f4469e = TypeBindings.f4452j;
    public static final Class<?> h = String.class;

    /* renamed from: j, reason: collision with root package name */
    public static final Class<?> f4470j = Object.class;

    /* renamed from: k, reason: collision with root package name */
    public static final Class<?> f4471k = Comparable.class;

    /* renamed from: l, reason: collision with root package name */
    public static final Class<?> f4472l = Class.class;

    /* renamed from: m, reason: collision with root package name */
    public static final Class<?> f4473m = Enum.class;

    /* renamed from: n, reason: collision with root package name */
    public static final Class<?> f4474n = d.class;

    /* renamed from: o, reason: collision with root package name */
    public static final Class<?> f4475o;

    /* renamed from: p, reason: collision with root package name */
    public static final Class<?> f4476p;

    /* renamed from: q, reason: collision with root package name */
    public static final Class<?> f4477q;
    public static final SimpleType r;

    /* renamed from: s, reason: collision with root package name */
    public static final SimpleType f4478s;

    /* renamed from: t, reason: collision with root package name */
    public static final SimpleType f4479t;

    /* renamed from: u, reason: collision with root package name */
    public static final SimpleType f4480u;

    /* renamed from: v, reason: collision with root package name */
    public static final SimpleType f4481v;

    /* renamed from: w, reason: collision with root package name */
    public static final SimpleType f4482w;

    /* renamed from: x, reason: collision with root package name */
    public static final SimpleType f4483x;

    /* renamed from: y, reason: collision with root package name */
    public static final SimpleType f4484y;
    public static final SimpleType z;

    /* renamed from: a, reason: collision with root package name */
    public final LRUMap f4485a = new LRUMap(16, 200);

    /* renamed from: b, reason: collision with root package name */
    public final TypeParser f4486b = new TypeParser(this);

    static {
        Class<?> cls = Boolean.TYPE;
        f4475o = cls;
        Class<?> cls2 = Integer.TYPE;
        f4476p = cls2;
        Class<?> cls3 = Long.TYPE;
        f4477q = cls3;
        r = new SimpleType(cls);
        f4478s = new SimpleType(cls2);
        f4479t = new SimpleType(cls3);
        f4480u = new SimpleType(String.class);
        f4481v = new SimpleType(Object.class);
        f4482w = new SimpleType(Comparable.class);
        f4483x = new SimpleType(Enum.class);
        f4484y = new SimpleType(Class.class);
        z = new SimpleType(d.class);
    }

    private TypeFactory() {
    }

    public static SimpleType a(Class cls) {
        if (cls.isPrimitive()) {
            if (cls == f4475o) {
                return r;
            }
            if (cls == f4476p) {
                return f4478s;
            }
            if (cls == f4477q) {
                return f4479t;
            }
            return null;
        }
        if (cls == h) {
            return f4480u;
        }
        if (cls == f4470j) {
            return f4481v;
        }
        if (cls == f4474n) {
            return z;
        }
        return null;
    }

    public static boolean e(JavaType javaType, JavaType javaType2) {
        if (javaType2 instanceof PlaceholderForType) {
            ((PlaceholderForType) javaType2).f4444n = javaType;
            return true;
        }
        if (javaType.f3690a == javaType2.f3690a) {
            List<JavaType> listE = javaType.j().e();
            List<JavaType> listE2 = javaType2.j().e();
            int size = listE.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (e(listE.get(i10), listE2.get(i10))) {
                }
            }
            return true;
        }
        return false;
    }

    public static JavaType g(JavaType javaType, Class cls) {
        Class<?> cls2 = javaType.f3690a;
        if (cls2 == cls) {
            return javaType;
        }
        JavaType javaTypeI = javaType.i(cls);
        if (javaTypeI != null) {
            return javaTypeI;
        }
        if (cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), javaType));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), javaType));
    }

    public static Class k(String str) throws ClassNotFoundException {
        Throwable thQ = null;
        if (str.indexOf(46) < 0) {
            Class cls = "int".equals(str) ? Integer.TYPE : "long".equals(str) ? Long.TYPE : "float".equals(str) ? Float.TYPE : "double".equals(str) ? Double.TYPE : "boolean".equals(str) ? Boolean.TYPE : "byte".equals(str) ? Byte.TYPE : "char".equals(str) ? Character.TYPE : "short".equals(str) ? Short.TYPE : "void".equals(str) ? Void.TYPE : null;
            if (cls != null) {
                return cls;
            }
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Exception e10) {
                thQ = a.q(e10);
            }
        }
        try {
            return Class.forName(str);
        } catch (Exception e11) {
            if (thQ == null) {
                thQ = a.q(e11);
            }
            a.D(thQ);
            throw new ClassNotFoundException(thQ.getMessage(), thQ);
        }
    }

    public static JavaType[] l(JavaType javaType, Class cls) {
        JavaType javaTypeI = javaType.i(cls);
        return javaTypeI == null ? f4467c : javaTypeI.j().f4454b;
    }

    @Deprecated
    public static void m(Class cls) {
        TypeBindings typeBindings = f4469e;
        if (!typeBindings.f() || a(cls) == null) {
            new SimpleType(cls, typeBindings, null, null);
        }
    }

    public static SimpleType n() {
        f4468d.getClass();
        return f4481v;
    }

    public final JavaType b(e0.a aVar, Type type, TypeBindings typeBindings) {
        JavaType javaType;
        Type[] bounds;
        JavaType javaType2;
        TypeBindings typeBindingsC;
        if (type instanceof Class) {
            return c(aVar, (Class) type, f4469e);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<?> cls = (Class) parameterizedType.getRawType();
            if (cls == f4473m) {
                return f4483x;
            }
            if (cls == f4471k) {
                return f4482w;
            }
            if (cls == f4472l) {
                return f4484y;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
            if (length == 0) {
                typeBindingsC = f4469e;
            } else {
                JavaType[] javaTypeArr = new JavaType[length];
                for (int i10 = 0; i10 < length; i10++) {
                    javaTypeArr[i10] = b(aVar, actualTypeArguments[i10], typeBindings);
                }
                typeBindingsC = TypeBindings.c(cls, javaTypeArr);
            }
            return c(aVar, cls, typeBindingsC);
        }
        if (type instanceof JavaType) {
            return (JavaType) type;
        }
        if (type instanceof GenericArrayType) {
            JavaType javaTypeB = b(aVar, ((GenericArrayType) type).getGenericComponentType(), typeBindings);
            int i11 = ArrayType.f4421o;
            return new ArrayType(javaTypeB, typeBindings, Array.newInstance(javaTypeB.f3690a, 0), null, null, false);
        }
        if (!(type instanceof TypeVariable)) {
            if (type instanceof WildcardType) {
                return b(aVar, ((WildcardType) type).getUpperBounds()[0], typeBindings);
            }
            StringBuilder sb2 = new StringBuilder("Unrecognized Type: ");
            sb2.append(type == null ? "[null]" : type.toString());
            throw new IllegalArgumentException(sb2.toString());
        }
        TypeVariable typeVariable = (TypeVariable) type;
        String name = typeVariable.getName();
        if (typeBindings == null) {
            throw new IllegalArgumentException(a0.a.k("Null `bindings` passed (type variable \"", name, "\")"));
        }
        String[] strArr = typeBindings.f4453a;
        int length2 = strArr.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length2) {
                javaType = null;
                break;
            }
            if (name.equals(strArr[i12])) {
                javaType = typeBindings.f4454b[i12];
                if ((javaType instanceof ResolvedRecursiveType) && (javaType2 = ((ResolvedRecursiveType) javaType).f4447m) != null) {
                    javaType = javaType2;
                }
            } else {
                i12++;
            }
        }
        if (javaType != null) {
            return javaType;
        }
        String[] strArr2 = typeBindings.f4455c;
        if (strArr2 != null) {
            int length3 = strArr2.length;
            do {
                length3--;
                if (length3 >= 0) {
                }
            } while (!name.equals(strArr2[length3]));
            return f4481v;
        }
        String[] strArr3 = typeBindings.f4455c;
        int length4 = strArr3 == null ? 0 : strArr3.length;
        String[] strArr4 = length4 == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr3, length4 + 1);
        strArr4[length4] = name;
        TypeBindings typeBindings2 = new TypeBindings(typeBindings.f4453a, typeBindings.f4454b, strArr4);
        synchronized (typeVariable) {
            bounds = typeVariable.getBounds();
        }
        return b(aVar, bounds[0], typeBindings2);
    }

    public final JavaType c(e0.a aVar, Class<?> cls, TypeBindings typeBindings) {
        e0.a aVar2;
        TypeBindings typeBindings2;
        e0.a aVar3;
        JavaType javaTypeB;
        JavaType[] javaTypeArrD;
        JavaType[] javaTypeArr;
        JavaType javaTypeF;
        JavaType javaType;
        TypeBindings typeBindings3;
        Class<?> cls2;
        TypeBindings typeBindings4;
        Class<?> cls3;
        JavaType javaType2;
        JavaType javaType3;
        Class<?> cls4 = cls;
        SimpleType simpleTypeA = a(cls4);
        if (simpleTypeA != null) {
            return simpleTypeA;
        }
        Object aVar4 = (typeBindings == null || typeBindings.f()) ? cls4 : new TypeBindings.a(cls4, typeBindings.f4454b, typeBindings.f4456d);
        LRUMap lRUMap = this.f4485a;
        JavaType javaType4 = (JavaType) lRUMap.f4509b.get(aVar4);
        if (javaType4 != null) {
            return javaType4;
        }
        TypeBindings typeBindings5 = f4469e;
        if (aVar == null) {
            aVar3 = new e0.a(null, cls4);
            typeBindings2 = typeBindings5;
        } else {
            if (((Class) aVar.f8516c) != cls4) {
                Object obj = aVar.f8515b;
                while (true) {
                    e0.a aVar5 = (e0.a) obj;
                    if (aVar5 == null) {
                        aVar2 = null;
                        break;
                    }
                    if (((Class) aVar5.f8516c) == cls4) {
                        aVar2 = aVar5;
                        break;
                    }
                    obj = aVar5.f8515b;
                }
            } else {
                aVar2 = aVar;
            }
            if (aVar2 != null) {
                ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(cls, typeBindings5, null, null, 0, null, null, false);
                if (((ArrayList) aVar2.f8517d) == null) {
                    aVar2.f8517d = new ArrayList();
                }
                ((ArrayList) aVar2.f8517d).add(resolvedRecursiveType);
                return resolvedRecursiveType;
            }
            typeBindings2 = typeBindings5;
            aVar3 = new e0.a(aVar, cls4);
        }
        int i10 = 0;
        if (cls4.isArray()) {
            JavaType javaTypeB2 = b(aVar3, cls4.getComponentType(), typeBindings);
            int i11 = ArrayType.f4421o;
            javaTypeF = new ArrayType(javaTypeB2, typeBindings, Array.newInstance(javaTypeB2.f3690a, 0), null, null, false);
        } else {
            if (cls4.isInterface()) {
                javaTypeArrD = d(aVar3, cls4, typeBindings);
                javaTypeB = null;
            } else {
                Annotation[] annotationArr = a.f4529a;
                Type genericSuperclass = cls4.getGenericSuperclass();
                javaTypeB = genericSuperclass == null ? null : b(aVar3, genericSuperclass, typeBindings);
                javaTypeArrD = d(aVar3, cls4, typeBindings);
            }
            JavaType javaType5 = f4480u;
            if (cls4 == Properties.class) {
                javaTypeArr = javaTypeArrD;
                javaType = javaTypeB;
                cls2 = Properties.class;
                javaTypeF = new MapType(cls4, typeBindings, javaType, javaTypeArr, javaType5, javaType5, null, null, false);
                cls4 = cls4;
                typeBindings3 = typeBindings;
            } else {
                javaTypeArr = javaTypeArrD;
                javaTypeF = javaType4;
                javaType = javaTypeB;
                typeBindings3 = typeBindings;
                cls2 = Properties.class;
                if (javaType != null) {
                    javaTypeF = javaType.F(cls4, typeBindings3, javaType, javaTypeArr);
                }
            }
            if (javaTypeF == null) {
                if (typeBindings3 != null) {
                    typeBindings2 = typeBindings3;
                }
                JavaType javaType6 = f4481v;
                if (cls4 != Map.class) {
                    typeBindings4 = typeBindings3;
                    cls3 = cls4;
                    TypeBindings typeBindings6 = typeBindings2;
                    if (cls3 == Collection.class) {
                        List<JavaType> listE = typeBindings6.e();
                        if (!listE.isEmpty()) {
                            if (listE.size() != 1) {
                                throw new IllegalArgumentException("Strange Collection type " + cls3.getName() + ": cannot determine type parameters");
                            }
                            javaType6 = listE.get(0);
                        }
                        javaTypeF = new CollectionType(cls3, typeBindings6, javaType, javaTypeArr, javaType6, null, null, false);
                    } else if (cls3 == AtomicReference.class) {
                        List<JavaType> listE2 = typeBindings6.e();
                        if (!listE2.isEmpty()) {
                            if (listE2.size() != 1) {
                                throw new IllegalArgumentException("Strange Reference type " + cls3.getName() + ": cannot determine type parameters");
                            }
                            javaType6 = listE2.get(0);
                        }
                        javaTypeF = new ReferenceType(cls3, typeBindings6, javaType, javaTypeArr, javaType6, null, null, null, false);
                    } else {
                        javaTypeF = null;
                    }
                } else if (cls4 != cls2) {
                    List<JavaType> listE3 = typeBindings2.e();
                    int size = listE3.size();
                    if (size == 0) {
                        javaType5 = javaType6;
                        javaType3 = javaType5;
                        typeBindings4 = typeBindings3;
                        cls3 = cls4;
                        javaTypeF = new MapType(cls3, typeBindings2, javaType, javaTypeArr, javaType5, javaType3, null, null, false);
                    } else {
                        if (size != 2) {
                            throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", a.y(cls4), Integer.valueOf(size), size == 1 ? "" : "s", typeBindings2));
                        }
                        javaType5 = listE3.get(0);
                        javaType3 = listE3.get(1);
                        typeBindings4 = typeBindings3;
                        cls3 = cls4;
                        javaTypeF = new MapType(cls3, typeBindings2, javaType, javaTypeArr, javaType5, javaType3, null, null, false);
                    }
                } else {
                    javaType3 = javaType5;
                    typeBindings4 = typeBindings3;
                    cls3 = cls4;
                    javaTypeF = new MapType(cls3, typeBindings2, javaType, javaTypeArr, javaType5, javaType3, null, null, false);
                }
                if (javaTypeF == null) {
                    int length = javaTypeArr.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length) {
                            javaType2 = null;
                            break;
                        }
                        JavaType javaTypeF2 = javaTypeArr[i12].F(cls3, typeBindings4, javaType, javaTypeArr);
                        if (javaTypeF2 != null) {
                            javaType2 = javaTypeF2;
                            break;
                        }
                        i12++;
                    }
                    javaTypeF = javaType2 == null ? new SimpleType(cls3, typeBindings4, javaType, javaTypeArr) : javaType2;
                }
            }
        }
        ArrayList arrayList = (ArrayList) aVar3.f8517d;
        if (arrayList != null) {
            int size2 = arrayList.size();
            while (i10 < size2) {
                Object obj2 = arrayList.get(i10);
                i10++;
                ResolvedRecursiveType resolvedRecursiveType2 = (ResolvedRecursiveType) obj2;
                if (resolvedRecursiveType2.f4447m != null) {
                    throw new IllegalStateException("Trying to re-set self reference; old value = " + resolvedRecursiveType2.f4447m + ", new = " + javaTypeF);
                }
                resolvedRecursiveType2.f4447m = javaTypeF;
            }
        }
        if (!javaTypeF.t()) {
            lRUMap.b(javaTypeF, aVar4);
        }
        return javaTypeF;
    }

    public final JavaType[] d(e0.a aVar, Class<?> cls, TypeBindings typeBindings) {
        Annotation[] annotationArr = a.f4529a;
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return f4467c;
        }
        int length = genericInterfaces.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i10 = 0; i10 < length; i10++) {
            javaTypeArr[i10] = b(aVar, genericInterfaces[i10], typeBindings);
        }
        return javaTypeArr;
    }

    public final CollectionType f(JavaType javaType, Class cls) {
        TypeBindings typeBindings;
        String[] strArr = TypeBindings.f4451e;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 0) {
            typeBindings = TypeBindings.f4452j;
        } else {
            if (length != 1) {
                throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + length);
            }
            typeBindings = new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaType}, null);
        }
        CollectionType collectionType = (CollectionType) c(null, cls, typeBindings);
        if (typeBindings.f() && javaType != null) {
            JavaType javaTypeK = collectionType.i(Collection.class).k();
            if (!javaTypeK.equals(javaType)) {
                throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", a.y(cls), javaType, javaTypeK));
            }
        }
        return collectionType;
    }

    public final MapType h(Class<? extends Map> cls, JavaType javaType, JavaType javaType2) {
        TypeBindings typeBindings;
        JavaType[] javaTypeArr = {javaType, javaType2};
        String[] strArr = TypeBindings.f4451e;
        TypeVariable<Class<? extends Map>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            typeBindings = TypeBindings.f4452j;
        } else {
            int length = typeParameters.length;
            String[] strArr2 = new String[length];
            for (int i10 = 0; i10 < length; i10++) {
                strArr2[i10] = typeParameters[i10].getName();
            }
            if (length != 2) {
                throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 2 type parameters: class expects " + length);
            }
            typeBindings = new TypeBindings(strArr2, javaTypeArr, null);
        }
        MapType mapType = (MapType) c(null, cls, typeBindings);
        if (typeBindings.f()) {
            JavaType javaTypeI = mapType.i(Map.class);
            JavaType javaTypeO = javaTypeI.o();
            if (!javaTypeO.equals(javaType)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", a.y(cls), javaType, javaTypeO));
            }
            JavaType javaTypeK = javaTypeI.k();
            if (!javaTypeK.equals(javaType2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", a.y(cls), javaType2, javaTypeK));
            }
        }
        return mapType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r3 == java.util.EnumSet.class) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.JavaType i(com.fasterxml.jackson.databind.JavaType r17, java.lang.Class<?> r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.type.TypeFactory.i(com.fasterxml.jackson.databind.JavaType, java.lang.Class, boolean):com.fasterxml.jackson.databind.JavaType");
    }

    public final JavaType j(Type type) {
        return b(null, type, f4469e);
    }
}

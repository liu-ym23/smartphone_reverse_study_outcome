package com.fasterxml.jackson.databind.util;

import c3.i;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Annotation[] f4529a = new Annotation[0];

    /* renamed from: b, reason: collision with root package name */
    public static final C0034a[] f4530b = new C0034a[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Iterator<?> f4531c = Collections.emptyIterator();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.fasterxml.jackson.databind.util.a$a, reason: collision with other inner class name */
    public static final class C0034a {

        /* renamed from: a, reason: collision with root package name */
        public final Constructor<?> f4532a;

        /* renamed from: b, reason: collision with root package name */
        public transient Annotation[] f4533b;

        /* renamed from: c, reason: collision with root package name */
        public transient Annotation[][] f4534c;

        /* renamed from: d, reason: collision with root package name */
        public int f4535d = -1;

        public C0034a(Constructor<?> constructor) {
            this.f4532a = constructor;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f4536c = new b();

        /* renamed from: a, reason: collision with root package name */
        public final Field f4537a = a(EnumSet.class);

        /* renamed from: b, reason: collision with root package name */
        public final Field f4538b = a(EnumMap.class);

        public static Field a(Class cls) {
            Field field;
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i10];
                if ("elementType".equals(field.getName()) && field.getType() == Class.class) {
                    break;
                }
                i10++;
            }
            if (field == null) {
                for (Field field2 : declaredFields) {
                    if (field2.getType() == Class.class) {
                        if (field != null) {
                            return null;
                        }
                        field = field2;
                    }
                }
            }
            if (field != null) {
                try {
                    field.setAccessible(true);
                } catch (Throwable unused) {
                }
            }
            return field;
        }
    }

    public static void A(DeserializationContext deserializationContext, IOException iOException) throws JsonMappingException {
        if (iOException instanceof JsonMappingException) {
            throw ((JsonMappingException) iOException);
        }
        JsonMappingException jsonMappingException = new JsonMappingException(deserializationContext.h, iOException.getMessage());
        jsonMappingException.initCause(iOException);
        throw jsonMappingException;
    }

    public static void B(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    public static void C(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
    }

    public static void D(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
    }

    public static void E(Class cls, Serializable serializable, String str) {
        if (serializable.getClass() != cls) {
            throw new IllegalStateException(ai.onnxruntime.a.o(ai.onnxruntime.a.s("Sub-class ", serializable.getClass().getName(), " (of class ", cls.getName(), ") must override method '"), str, "'"));
        }
    }

    public static Class<?> F(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static void a(Class cls, Class cls2, ArrayList arrayList) {
        if (cls == cls2 || cls == null || cls == Object.class || arrayList.contains(cls)) {
            return;
        }
        arrayList.add(cls);
        for (Class<?> cls3 : cls.getInterfaces()) {
            a(cls3, cls2, arrayList);
        }
        a(cls.getSuperclass(), cls2, arrayList);
    }

    public static void b(Class cls, Throwable th) {
        String name = cls.getName();
        String name2 = th.getClass().getName();
        String message = th.getMessage();
        StringBuilder sbS = ai.onnxruntime.a.s("Failed on call to `getDeclaredMethods()` on class `", name, "`, problem: (", name2, ") ");
        sbS.append(message);
        throw new IllegalArgumentException(sbS.toString(), th);
    }

    public static String c(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 2);
        sb2.append('\'');
        sb2.append(str);
        sb2.append('\'');
        return sb2.toString();
    }

    public static String d(Class<?> cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(Member member, boolean z) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        if (!z) {
            try {
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return;
                }
            } catch (SecurityException e10) {
                if (accessibleObject.isAccessible()) {
                    return;
                }
                throw new IllegalArgumentException("Cannot access " + member + " (from class " + member.getDeclaringClass().getName() + "; failed to set access: " + e10.getMessage());
            }
        }
        accessibleObject.setAccessible(true);
    }

    public static String f(Object obj) {
        if (obj == null) {
            return "[null]";
        }
        return y(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static void g(y2.b bVar, Closeable closeable, Exception exc) throws IOException {
        if (bVar != null) {
            bVar.n1(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
            try {
                bVar.close();
            } catch (Exception e10) {
                exc.addSuppressed(e10);
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e11) {
                exc.addSuppressed(e11);
            }
        }
        C(exc);
        D(exc);
        throw new RuntimeException(exc);
    }

    public static <T> T h(Class<T> cls, boolean z) throws NoSuchMethodException, SecurityException {
        Constructor constructorK = k(cls, z);
        if (constructorK == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
        try {
            return (T) constructorK.newInstance(null);
        } catch (Exception e10) {
            String str = "Failed to instantiate class " + cls.getName() + ", problem: " + e10.getMessage();
            Throwable thQ = q(e10);
            D(thQ);
            B(thQ);
            throw new IllegalArgumentException(str, thQ);
        }
    }

    public static String i(Throwable th) {
        return th instanceof JsonProcessingException ? ((JsonProcessingException) th).b() : th.getMessage();
    }

    public static Annotation[] j(Class<?> cls) {
        return w(cls) ? f4529a : cls.getDeclaredAnnotations();
    }

    public static <T> Constructor<T> k(Class<T> cls, boolean z) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (z) {
                e(declaredConstructor, z);
                return declaredConstructor;
            }
            if (Modifier.isPublic(declaredConstructor.getModifiers())) {
                return declaredConstructor;
            }
            throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (Exception e10) {
            String str = "Failed to find default constructor of class " + cls.getName() + ", problem: " + e10.getMessage();
            Throwable thQ = q(e10);
            D(thQ);
            B(thQ);
            throw new IllegalArgumentException(str, thQ);
        }
    }

    public static ArrayList l(Class cls, Class cls2, boolean z) {
        ArrayList arrayList = new ArrayList(8);
        if (cls != null && cls != cls2) {
            if (z) {
                arrayList.add(cls);
            }
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls == cls2) {
                    break;
                }
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    public static String m(Object obj) {
        return y(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static Method[] n(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                throw null;
            }
            try {
                try {
                    return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
                } finally {
                }
            } catch (ClassNotFoundException e11) {
                e10.addSuppressed(e11);
                throw null;
            }
        } finally {
        }
    }

    public static C0034a[] o(Class<?> cls) throws SecurityException {
        if (cls.isInterface() || w(cls)) {
            return f4530b;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        C0034a[] c0034aArr = new C0034a[length];
        for (int i10 = 0; i10 < length; i10++) {
            c0034aArr[i10] = new C0034a(declaredConstructors[i10]);
        }
        return c0034aArr;
    }

    public static Class<?> p(Class<?> cls) {
        if (!Modifier.isStatic(cls.getModifiers())) {
            try {
                if (((w(cls) || cls.getEnclosingMethod() == null) ? false : true) || w(cls)) {
                    return null;
                }
                return cls.getEnclosingClass();
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    public static Throwable q(Exception exc) {
        Exception cause = exc;
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause;
    }

    public static String r(JavaType javaType) {
        if (javaType == null) {
            return "[null]";
        }
        StringBuilder sb2 = new StringBuilder(80);
        sb2.append('`');
        sb2.append(javaType.e());
        sb2.append('`');
        return sb2.toString();
    }

    public static boolean s(Class cls, Object obj) {
        return obj != null && obj.getClass() == cls;
    }

    public static boolean t(Class<?> cls) {
        return cls == Void.class || cls == Void.TYPE || cls == i.class;
    }

    public static boolean u(Class<?> cls) {
        String name = cls.getName();
        return name.startsWith("java.") || name.startsWith("javax.");
    }

    public static boolean v(Object obj) {
        return obj == null || obj.getClass().getAnnotation(c3.a.class) != null;
    }

    public static boolean w(Class<?> cls) {
        return cls == Object.class || cls.isPrimitive();
    }

    public static String x(String str) {
        return str == null ? "[null]" : c(str);
    }

    public static String y(Class<?> cls) {
        if (cls == null) {
            return "[null]";
        }
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
        }
        String simpleName = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (i10 > 0) {
            StringBuilder sb2 = new StringBuilder(simpleName);
            do {
                sb2.append("[]");
                i10--;
            } while (i10 > 0);
            simpleName = sb2.toString();
        }
        if (simpleName == null) {
            return "[null]";
        }
        StringBuilder sb3 = new StringBuilder(simpleName.length() + 2);
        sb3.append('`');
        sb3.append(simpleName);
        sb3.append('`');
        return sb3.toString();
    }

    public static Class<?> z(Class<?> cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return null;
    }
}

package com.fasterxml.jackson.databind.l;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f13017a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Annotation[] f13018b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a[] f13019c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Iterator<?> f13020d = null;

    /* JADX INFO: compiled from: ClassUtil.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Constructor<?> f13021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Annotation[] f13022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient Annotation[][] f13023c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13024d;

        public a(Constructor<?> r2) {
            this.f13024d = -1;
            this.f13021a = r2;
        }

        public Constructor<?> a() {
            return this.f13021a;
        }

        public int b() {
            int r0 = this.f13024d;
            if (r0 >= 0) goto L6;
            int r1 = this.f13021a.getParameterTypes().length;
            this.f13024d = r1;
            return r1;
        L6:
            return r0;
        }

        public Class<?> c() {
            return this.f13021a.getDeclaringClass();
        }

        public Annotation[] d() {
            Annotation[] r0 = this.f13022b;
            if (r0 != null) goto L6;
            Annotation[] r1 = this.f13021a.getDeclaredAnnotations();
            this.f13022b = r1;
            return r1;
        L6:
            return r0;
        }

        public Annotation[][] e() {
            Annotation[][] r0 = this.f13023c;
            if (r0 != null) goto L6;
            Annotation[][] r1 = this.f13021a.getParameterAnnotations();
            this.f13023c = r1;
            return r1;
        L6:
            return r0;
        }
    }

    /* JADX INFO: compiled from: ClassUtil.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f13025a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Field f13026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Field f13027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f13028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f13029e;

        static {
            f13025a = new b();
        }

        private b() {
            Field r0 = null;
            Field r1 = a(EnumSet.class, "elementType", Class.class);     // Catch: Exception -> L5
            String r2 = null;
        L7:
            this.f13026b = r1;
            this.f13028d = r2;
            String r3 = null;
            r0 = a(EnumMap.class, "keyType", Class.class);     // Catch: Exception -> L10
        L12:
            this.f13027c = r0;
            this.f13029e = r3;
            return;
        L10:
            e = move-exception;
            r3 = e.toString();
        L5:
            e = move-exception;
            r2 = e.toString();
            r1 = null;
            goto L7
        }

        public Class<? extends Enum<?>> a(EnumSet<?> r3) {
            Field r0 = this.f13026b;
            if (r0 == null) goto L7;
            return (Class) ZeusTransformUtils.preCheckCast(a(r3, r0), Class.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("Cannot figure out type parameter for `EnumSet` (odd JDK platform?), problem: " + this.f13028d);
        }

        public Class<? extends Enum<?>> a(EnumMap<?, ?> r3) {
            Field r0 = this.f13027c;
            if (r0 == null) goto L7;
            return (Class) ZeusTransformUtils.preCheckCast(a(r3, r0), Class.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("Cannot figure out type parameter for `EnumMap` (odd JDK platform?), problem: " + this.f13029e);
        }

        private Object a(Object r1, Field r2) {
            return r2.get(r1);
        L4:
            e = move-exception;
            throw new IllegalArgumentException(e);
        }

        private static Field a(Class<?> r7, String r8, Class<?> r9) {
            Field[] r0 = r7.getDeclaredFields();
            int r1 = r0.length;
            int r3 = 0;
        L4:
            if (r3 >= r1) goto L14;
            Field r5 = r0[r3];
            if (r8.equals(r5.getName()) == false) goto L12;
            if (r5.getType() != r9) goto L12;
            r5.setAccessible(true);
            return r5;
        L12:
            r3 = r3 + 1;
            goto L4
        L14:
            throw new IllegalStateException(String.format("No field named '%s' in class '%s'", new Object[]{r8, r7.getName()}));
        }
    }

    public static <T> T a(T r0, T r1) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static String a(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    static {
        f13017a = Object.class;
        f13018b = new Annotation[0];
        f13019c = new a[0];
        f13020d = Collections.emptyIterator();
    }

    public static <T> Iterator<T> a() {
        return (Iterator<T>) f13020d;
    }

    public static List<Class<?>> a(Class<?> r2, Class<?> r3, boolean r4) {
        if (r2 == null) goto L10;
        if (r2 == r3) goto L10;
        if (r2 == Object.class) goto L10;
        ArrayList r0 = new ArrayList(8);
        a(r2, r3, r0, r4);
        return r0;
    L10:
        return Collections.emptyList();
    }

    public static List<Class<?>> b(Class<?> r2, Class<?> r3, boolean r4) {
        ArrayList r0 = new ArrayList(8);
        if (r2 == null) goto L12;
        if (r2 == r3) goto L12;
        if (r4 == false) goto L7;
        r0.add(r2);
    L7:
        r2 = r2.getSuperclass();
        if (r2 == null) goto L12;
        if (r2 == r3) goto L12;
        r0.add(r2);
    L12:
        return r0;
    }

    private static void a(Class<?> r4, Class<?> r5, Collection<Class<?>> r6, boolean r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r4 == r5) goto L20;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4 == Object.class) goto L22;
        if (r7 == true) goto L10;
    L13:
        Class<?>[] r9 = x(r4);
        int r0 = r9.length;
        int r1 = 0;
    L15:
        if (r1 >= r0) goto L17;
        a(r9[r1], r5, r8, true);
        r1 = r1 + 1;
        goto L15
    L17:
        a(r4.getSuperclass(), r5, r8, true);
        return;
    L10:
        if (r8.contains(r4) == false) goto L12;
        return;
    L12:
        r8.add(r4);
        goto L13
    L22:
        return;
    }

    public static String a(Class<?> r1) {
        if (r1.isAnnotation() == false) goto L7;
        return "annotation";
    L7:
        if (r1.isArray() == false) goto L11;
        return "array";
    L11:
        if (Enum.class.isAssignableFrom(r1) == false) goto L15;
        return "enum";
    L15:
        if (r1.isPrimitive() == false) goto L18;
        return "primitive";
    L18:
        return null;
    }

    public static String a(Class<?> r2, boolean r3) {
        boolean r0 = Modifier.isStatic(r2.getModifiers());     // Catch: Throwable -> L16
        if (r0 == false) goto L5;
    L8:
        if (r3 == true) goto L14;
        if (r0 == true) goto L19;
        if (w(r2) == null) goto L20;
        return "non-static member class";
    L20:
        return null;
    L19:
        return null;
    L14:
        return null;
    L5:
        if (q(r2) == false) goto L8;
        return "local/anonymous";
    L21:
        return null;
    }

    public static Class<?> b(Class<?> r2) {
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L11;
    L9:
        return null;
    L11:
        if (q(r2) == false) goto L7;
        return null;
    L7:
        return w(r2);
    }

    public static boolean c(Class<?> r1) {
        String r2 = r1.getName();
        if (r2.startsWith("net.sf.cglib.proxy.") == false) goto L5;
        return true;
    L5:
        if (r2.startsWith("org.hibernate.proxy.") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean d(Class<?> r0) {
        if ((r0.getModifiers() & 1536) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(Class<?> r1) {
        if (r1 != Void.class) goto L5;
    L10:
        return true;
    L5:
        if (r1 == Void.TYPE) goto L10;
        if (r1 == NoClass.class) goto L10;
        return false;
    }

    public static boolean f(Class<?> r1) {
        Class<? super Object> r2 = r1.getSuperclass();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if ("java.lang.Record".equals(r2.getName()) == false) goto L7;
        return true;
    }

    public static boolean g(Class<?> r1) {
        if (r1 != f13017a) goto L5;
    L8:
        return true;
    L5:
        if (r1.isPrimitive() == true) goto L8;
        return false;
    }

    public static boolean a(Object r0, Class<?> r1) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.getClass() != r1) goto L6;
        return true;
    }

    public static void a(Class<?> r3, Object r4, String r5) {
        if (r4.getClass() != r3) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", new Object[]{r4.getClass().getName(), r3.getName(), r5}));
    }

    public static Throwable a(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, Error.class) == true) goto L6;
        return r2;
    L6:
        throw ((Error) ZeusTransformUtils.preCheckCast(r2, Error.class, "com.obric.aiagent.plugin"));
    }

    public static Throwable b(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, RuntimeException.class) == true) goto L6;
        return r2;
    L6:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(r2, RuntimeException.class, "com.obric.aiagent.plugin"));
    }

    public static Throwable c(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, IOException.class) == true) goto L6;
        return r2;
    L6:
        throw ((IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin"));
    }

    public static Throwable d(Throwable r1) {
    L3:
        if (r1.getCause() == null) goto L5;
        r1 = r1.getCause();
        goto L3
    L5:
        return r1;
    }

    public static Throwable e(Throwable r0) {
        return c(d(r0));
    }

    public static void f(Throwable r1) {
        a(r1, r1.getMessage());
    }

    public static void a(Throwable r1, String r2) {
        b(r1);
        a(r1);
        throw new IllegalArgumentException(r2, r1);
    }

    public static <T> T a(com.fasterxml.jackson.databind.h r1, IOException r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.fasterxml.jackson.databind.m.class) == false) goto L7;
        throw ((com.fasterxml.jackson.databind.m) ZeusTransformUtils.preCheckCast(r2, com.fasterxml.jackson.databind.m.class, "com.obric.aiagent.plugin"));
    L7:
        throw com.fasterxml.jackson.databind.m.a(r1, r2.getMessage()).a(r2);
    }

    public static void g(Throwable r0) {
        f(d(r0));
    }

    public static void b(Throwable r0, String r1) {
        a(d(r0), r1);
    }

    public static void a(com.fasterxml.jackson.a.h r1, Exception r2) {
        r1.a(com.fasterxml.jackson.a.h.a.f12083b);
        r1.close();     // Catch: Exception -> L5
    L7:
        c(r2);
        b(r2);
        throw new RuntimeException(r2);
    L5:
        e = move-exception;
        r2.addSuppressed(e);
        goto L7
    }

    public static void a(com.fasterxml.jackson.a.h r2, Closeable r3, Exception r4) {
        Closeable r5 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r2.a(com.fasterxml.jackson.a.h.a.f12083b);
        r2.close();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        r4.addSuppressed(e);
    L9:
        if (r5 != null) goto L16;
    L14:
        c(r4);
        b(r4);
        throw new RuntimeException(r4);
    L16:
        r5.close();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        r4.addSuppressed(e);
        goto L14
    }

    public static <T> T b(Class<T> r2, boolean r3) {
        Constructor r4 = c(r2, r3);
        if (r4 == null) goto L11;
        return (T) r4.newInstance(new Object[0]);
    L7:
        e = move-exception;
        b(e, "Failed to instantiate class " + r2.getName() + ", problem: " + e.getMessage());
        return null;
    L11:
        throw new IllegalArgumentException("Class " + r2.getName() + " has no default (no arg) constructor");
    }

    public static <T> Constructor<T> c(Class<T> r2, boolean r3) {
        Constructor<T> r0 = r2.getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L11 NoSuchMethodException -> L15
        if (r3 == false) goto L7;
        a(r0, r3);     // Catch: Exception -> L11 NoSuchMethodException -> L15
    L8:
        return r0;
    L7:
        if (Modifier.isPublic(r0.getModifiers()) == true) goto L8;
        throw new IllegalArgumentException("Default constructor for " + r2.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");     // Catch: Exception -> L11 NoSuchMethodException -> L15
    L11:
        e = move-exception;
        b(e, "Failed to find default constructor of class " + r2.getName() + ", problem: " + e.getMessage());
        return null;
    L17:
        return null;
    }

    public static Class<?> a(Object r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getClass();
    }

    public static Class<?> a(com.fasterxml.jackson.databind.k r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.e();
    }

    public static String b(Object r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public static String a(Object r1, String r2) {
        if (r1 != null) goto L5;
        return r2;
    L5:
        return String.format("\"%s\"", new Object[]{r1});
    }

    public static String c(Object r2) {
        if (r2 != null) goto L6;
        return SensitiveType.UNKNOWN;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L8;
        Class<?> r3 = (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.aiagent.plugin");
    L10:
        return h(r3);
    L8:
        r3 = r2.getClass();
        goto L10
    }

    public static String b(com.fasterxml.jackson.databind.k r2) {
        if (r2 != null) goto L5;
        return "[null]";
    L5:
        StringBuilder r0 = new StringBuilder(80).append('`');
        r0.append(r2.c());
        return r0.append('`').toString();
    }

    public static String d(Object r2) {
        if (r2 != null) goto L6;
        return "[null]";
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L8;
        Class<?> r3 = (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.aiagent.plugin");
    L10:
        return h(r3);
    L8:
        r3 = r2.getClass();
        goto L10
    }

    public static String h(Class<?> r2) {
        if (r2 != null) goto L5;
        return "[null]";
    L5:
        int r0 = 0;
    L7:
        if (r2.isArray() == false) goto L10;
        r0 = r0 + 1;
        r2 = r2.getComponentType();
        goto L7
    L10:
        if (r2.isPrimitive() == false) goto L12;
        String r3 = r2.getSimpleName();
    L13:
        if (r0 <= 0) goto L19;
        StringBuilder r1 = new StringBuilder(r3);
    L15:
        r1.append("[]");
        r0 = r0 - 1;
        if (r0 > 0) goto L15;
        r3 = r1.toString();
    L19:
        return c(r3);
    L12:
        r3 = r2.getName();
        goto L13
    }

    public static String a(r r2) {
        r r3 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return "[null]";
    L7:
        return d(r3.a());
    }

    public static String b(String r0) {
        if (r0 != null) goto L6;
        return "[null]";
    L6:
        return d(r0);
    }

    public static String a(com.fasterxml.jackson.databind.x r0) {
        if (r0 != null) goto L6;
        return "[null]";
    L6:
        return d(r0.b());
    }

    public static String c(String r2) {
        if (r2 != null) goto L6;
        return "[null]";
    L6:
        return new StringBuilder(r2.length() + 2).append('`').append(r2).append('`').toString();
    }

    public static String d(String r2) {
        if (r2 != null) goto L6;
        return "[null]";
    L6:
        return new StringBuilder(r2.length() + 2).append('\'').append(r2).append('\'').toString();
    }

    public static String h(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.fasterxml.jackson.a.e.class) == false) goto L7;
        return ((com.fasterxml.jackson.a.e) ZeusTransformUtils.preCheckCast(r2, com.fasterxml.jackson.a.e.class, "com.obric.aiagent.plugin")).b();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, InvocationTargetException.class) == false) goto L13;
        if (r2.getCause() == null) goto L13;
        return r2.getCause().getMessage();
    L13:
        return r2.getMessage();
    }

    public static Object i(Class<?> r3) {
        if (r3 != Integer.TYPE) goto L7;
        return 0;
    L7:
        if (r3 != Long.TYPE) goto L11;
        return 0L;
    L11:
        if (r3 != Boolean.TYPE) goto L15;
        return Boolean.FALSE;
    L15:
        if (r3 != Double.TYPE) goto L19;
        return Double.valueOf(0.0d);
    L19:
        if (r3 != Float.TYPE) goto L23;
        return Float.valueOf(0.0f);
    L23:
        if (r3 != Byte.TYPE) goto L27;
        return (byte) 0;
    L27:
        if (r3 != Short.TYPE) goto L31;
        return (short) 0;
    L31:
        if (r3 != Character.TYPE) goto L35;
        return (char) 0;
    L35:
        throw new IllegalArgumentException("Class " + r3.getName() + " is not a primitive type");
    }

    public static Class<?> j(Class<?> r3) {
        if (r3 != Integer.TYPE) goto L7;
        return Integer.class;
    L7:
        if (r3 != Long.TYPE) goto L11;
        return Long.class;
    L11:
        if (r3 != Boolean.TYPE) goto L15;
        return Boolean.class;
    L15:
        if (r3 != Double.TYPE) goto L19;
        return Double.class;
    L19:
        if (r3 != Float.TYPE) goto L23;
        return Float.class;
    L23:
        if (r3 != Byte.TYPE) goto L27;
        return Byte.class;
    L27:
        if (r3 != Short.TYPE) goto L31;
        return Short.class;
    L31:
        if (r3 != Character.TYPE) goto L35;
        return Character.class;
    L35:
        throw new IllegalArgumentException("Class " + r3.getName() + " is not a primitive type");
    }

    public static Class<?> k(Class<?> r1) {
        if (r1.isPrimitive() == false) goto L6;
        return r1;
    L6:
        if (r1 != Integer.class) goto L10;
        return Integer.TYPE;
    L10:
        if (r1 != Long.class) goto L14;
        return Long.TYPE;
    L14:
        if (r1 != Boolean.class) goto L18;
        return Boolean.TYPE;
    L18:
        if (r1 != Double.class) goto L22;
        return Double.TYPE;
    L22:
        if (r1 != Float.class) goto L26;
        return Float.TYPE;
    L26:
        if (r1 != Byte.class) goto L30;
        return Byte.TYPE;
    L30:
        if (r1 != Short.class) goto L34;
        return Short.TYPE;
    L34:
        if (r1 == Character.class) goto L36;
        return null;
    L36:
        return Character.TYPE;
    }

    public static void a(Member r5, boolean r6) {
        Member r7 = (Member) ZeusTransformUtils.wrapperContextForParams(r5, Member.class, "com.obric.aiagent.plugin");
        AccessibleObject r0 = (AccessibleObject) ZeusTransformUtils.preCheckCast(r7, AccessibleObject.class, "com.obric.aiagent.plugin");
        Class<?> r3 = r7.getDeclaringClass();     // Catch: RuntimeException -> L15 SecurityException -> L21
        if (Modifier.isPublic(r7.getModifiers()) == true) goto L6;
    L8:
        boolean r4 = false;
    L9:
        if (r4 == false) goto L13;
        if (r6 == true) goto L12;
        return;
    L12:
        if (o(r3) == false) goto L13;
        return;
    L13:
        r0.setAccessible(true);     // Catch: RuntimeException -> L15 SecurityException -> L21
    L31:
        return;
    L6:
        if (Modifier.isPublic(r3.getModifiers()) == false) goto L8;
        r4 = true;
    L21:
        e = move-exception;
        if (r0.isAccessible() == false) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("Cannot access " + r7 + " (from class " + r7.getDeclaringClass().getName() + "; failed to set access: " + e.getMessage());
    L15:
        e = move-exception;
        if ("InaccessibleObjectException".equals(e.getClass().getSimpleName()) == true) goto L19;
        throw e;
    L19:
        throw new IllegalArgumentException(String.format("Failed to call `setAccess()` on %s '%s' (of class %s) due to `%s`, problem: %s", new Object[]{r7.getClass().getSimpleName(), r7.getName(), h(r7.getDeclaringClass()), e.getClass().getName(), e.getMessage()}), e);
    }

    public static boolean l(Class<?> r1) {
        return Enum.class.isAssignableFrom(r1);
    }

    public static Class<? extends Enum<?>> a(EnumSet<?> r2) {
        if (r2.isEmpty() == true) goto L7;
        return a((Enum) ZeusTransformUtils.preCheckCast(r2.iterator().next(), Enum.class, "com.obric.aiagent.plugin"));
    L7:
        return b.f13025a.a(r2);
    }

    public static Class<? extends Enum<?>> a(EnumMap<?, ?> r2) {
        if (r2.isEmpty() == true) goto L7;
        return a((Enum) ZeusTransformUtils.preCheckCast(r2.keySet().iterator().next(), Enum.class, "com.obric.aiagent.plugin"));
    L7:
        return b.f13025a.a(r2);
    }

    public static Class<? extends Enum<?>> a(Enum<?> r0) {
        return r0.getDeclaringClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Class<? extends Enum<?>> m(Class<?> r2) {
        if (r2.getSuperclass() != Enum.class) goto L5;
        return r2;
    L5:
        return r2.getSuperclass();
    }

    public static <T extends Annotation> Enum<?> a(Class<Enum<?>> r10, Class<T> r11) {
        Field[] r0 = r10.getDeclaredFields();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        Field r4 = r0[r3];
        if (r4.isEnumConstant() == false) goto L14;
        if (r4.getAnnotation(r11) == null) goto L14;
        String r5 = r4.getName();
        Enum<?>[] r6 = (Enum[]) ZeusTransformUtils.preCheckCast(r10.getEnumConstants(), Enum[].class, "com.obric.aiagent.plugin");
        int r7 = r6.length;
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L14;
        Enum<?> r9 = r6[r8];
        if (r5.equals(r9.name()) == true) goto L12;
        r8 = r8 + 1;
        goto L9
    L12:
        return r9;
    L14:
        r3 = r3 + 1;
        goto L3
    L15:
        return null;
    }

    public static boolean e(Object r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (n(r0.getClass()) == true) goto L7;
        return false;
    }

    public static boolean n(Class<?> r1) {
        if (r1.getAnnotation(JacksonStdImpl.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean o(Class<?> r1) {
        String r2 = r1.getName();
        if (r2.startsWith("java.") == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.startsWith("javax.") == true) goto L8;
        return false;
    }

    public static boolean p(Class<?> r1) {
        if (Modifier.isStatic(r1.getModifiers()) == false) goto L5;
    L7:
        return false;
    L5:
        if (w(r1) == null) goto L7;
        return true;
    }

    public static boolean q(Class<?> r1) {
        if (g(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.getEnclosingMethod() == null) goto L7;
        return true;
    }

    public static Annotation[] r(Class<?> r1) {
        if (g(r1) == false) goto L7;
        return f13018b;
    L7:
        return r1.getDeclaredAnnotations();
    }

    public static Method[] s(Class<?> r3) {
        return r3.getDeclaredMethods();
    L7:
        e = move-exception;
        ClassLoader r1 = Thread.currentThread().getContextClassLoader();
        if (r1 == null) goto L11;
        return r1.loadClass(r3.getName()).getDeclaredMethods();
    L15:
        th = move-exception;
        return a(r3, th);
    L18:
        e = move-exception;
        e.addSuppressed(e);
        return a(r3, e);
    L11:
        return a(r3, e);
    L4:
        th = move-exception;
        return a(r3, th);
    }

    private static Method[] a(Class<?> r3, Throwable r4) {
        throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", new Object[]{r3.getName(), r4.getClass().getName(), r4.getMessage()}), r4);
    }

    public static a[] t(Class<?> r5) {
        if (r5.isInterface() == true) goto L12;
        if (g(r5) == true) goto L12;
        Constructor<?>[] r6 = r5.getDeclaredConstructors();
        int r0 = r6.length;
        a[] r1 = new a[r0];
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L10;
        r1[r2] = new a(r6[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L12:
        return f13019c;
    }

    public static Type u(Class<?> r0) {
        return r0.getGenericSuperclass();
    }

    public static Type[] v(Class<?> r0) {
        return r0.getGenericInterfaces();
    }

    public static Class<?> w(Class<?> r1) {
        if (g(r1) == false) goto L6;
        return null;
    L6:
        return r1.getEnclosingClass();
    }

    private static Class<?>[] x(Class<?> r0) {
        return r0.getInterfaces();
    }
}

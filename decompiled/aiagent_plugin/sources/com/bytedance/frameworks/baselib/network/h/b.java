package com.bytedance.frameworks.baselib.network.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TTReflect.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f8118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Method> f8119b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, Constructor<?>> f8120c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f8121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f8122e;

    /* JADX INFO: compiled from: TTReflect.java */
    private static class a {
        private a() {
        }
    }

    static {
        f8118a = new ConcurrentHashMap();
        f8119b = new ConcurrentHashMap();
        f8120c = new ConcurrentHashMap();
    }

    public static b a(String r0) {
        return a(b(r0));
    }

    public static b a(Class<?> r1) {
        if (r1 == null) goto L6;
        return new b(r1);
    L6:
        throw new c("Class object cannot be null");
    }

    public static b a(Object r1) {
        if (r1 == null) goto L6;
        return new b(r1);
    L6:
        throw new c("Instance object cannot be null");
    }

    public static <T extends AccessibleObject> T a(T r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Member.class) == false) goto L20;
        Member r0 = (Member) ZeusTransformUtils.preCheckCast(r5, Member.class, "com.obric.aiagent.plugin");
        if (Modifier.isPublic(r0.getModifiers()) == false) goto L20;
        if (Modifier.isPublic(r0.getDeclaringClass().getModifiers()) == false) goto L20;
        return r5;
    L20:
    L17:
        e = move-exception;
        throw new c("Failed to set accessible for " + r5, e, new String[]{r5.getClass().getSimpleName()});
    L14:
        if (r5.isAccessible() == true) goto L16;
        r5.setAccessible(true);     // Catch: SecurityException -> L17
    L16:
        return r5;
    }

    private b(Class<?> r1) {
        this.f8121d = r1;
        this.f8122e = true;
    }

    private b(Object r1) {
        this.f8121d = r1;
        this.f8122e = false;
    }

    public <T> T a() {
        return (T) this.f8121d;
    }

    public b call(String r2) {
        return call(r2, new Object[0]);
    }

    public b call(String r2, Object... r3) {
        return call(r2, a(r3), r3);
    }

    public b call(String r5, Class<?>[] r6, Object... r7) {
        return a(a(r5, r6), r7);
    L4:
        return a(b(r5, r6), r7);
    L6:
        e = move-exception;
        throw new c("No method found: " + r5, e, new String[]{c(), r5, Arrays.toString(r6)});
    }

    private Method a(String r5, Class<?>[] r6) {
        String r0 = a(c(), r5, r6);
        Method r1 = (Method) ZeusTransformUtils.preCheckCast(f8119b.get(r0), Method.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        Class<?> r4 = b();
        Method r2 = null;
    L6:
        if (r4 == null) goto L13;
        if (r2 != null) goto L13;
        r2 = r4.getMethod(r5, r6);     // Catch: NoSuchMethodException -> L10
    L10:
        r2 = r4.getDeclaredMethod(r5, r6);     // Catch: NoSuchMethodException -> L12
    L12:
        r4 = r4.getSuperclass();
    L13:
        if (r2 == null) goto L17;
        a(r2);
        f8119b.put(r0, r2);
        return r2;
    L17:
        throw new NoSuchMethodException();
    }

    private Method b(String r9, Class<?>[] r10) {
        Class<?> r0 = b();
        Method r1 = null;
    L3:
        if (r0 == null) goto L17;
        if (r1 != null) goto L17;
        Method[] r2 = r0.getDeclaredMethods();
        int r3 = r2.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L15;
        Method r5 = r2[r4];
        if (r5.getName().equals(r9) == false) goto L14;
        if (r5.getParameterTypes().length != r10.length) goto L14;
        if (a(r5.getParameterTypes(), r10) == false) goto L14;
        r1 = r5;
    L14:
        r4 = r4 + 1;
    L15:
        if (r1 != null) goto L3;
        r0 = r0.getSuperclass();
    L17:
        if (r1 == null) goto L21;
        a(r1);
        String r8 = a(c(), r9, r10);
        f8119b.put(r8, r1);
        return r1;
    L21:
        throw new NoSuchMethodException();
    }

    private b a(Method r5, Object... r6) {
        a(r5);     // Catch: Exception -> L7
        Object r7 = r5.invoke(this.f8121d, r6);     // Catch: Exception -> L7
        if (r5.getReturnType() == Void.TYPE) goto L12;
        return a(r7);
    L12:
        return this;
    L7:
        e = move-exception;
        throw new c("Failed to invoke method: " + r5.getName(), e, new String[]{c(), r5.getName(), Arrays.toString(r5.getParameterTypes())});
    }

    private String a(String r1, String r2, Class<?>... r3) {
        StringBuilder r0 = new StringBuilder(r1).append("#").append(r2);
        if (r3 == null) goto L19;
        if (r3.length <= 0) goto L19;
        r0.append("[");
        int r4 = 0;
    L8:
        if (r4 >= r3.length) goto L17;
        Class<?> r5 = r3[r4];
        if (r5 == null) goto L12;
        String r6 = r5.getName();
    L13:
        r0.append(r6);
        if (r4 == (r3.length - 1)) goto L16;
        r0.append(",");
    L16:
        r4 = r4 + 1;
        goto L8
    L12:
        r6 = "null";
        goto L13
    L17:
        r0.append("]");
    L19:
        return r0.toString();
    }

    private boolean a(Class<?>[] r5, Class<?>[] r6) {
        if (r5.length == r6.length) goto L5;
        return false;
    L5:
        int r4 = 0;
    L7:
        if (r4 >= r5.length) goto L18;
        Class<?> r0 = b(r5[r4]);
        if (r6[r4] != a.class) goto L11;
        Class<?> r2 = null;
    L12:
        if (r2 == null) goto L17;
        if (r0.isAssignableFrom(r2) == true) goto L17;
        return false;
    L17:
        r4 = r4 + 1;
        goto L7
    L11:
        r2 = b(r6[r4]);
        goto L12
    L18:
        return true;
    }

    private Class<?>[] a(Object... r3) {
        int r2 = 0;
        if (r3 == null) goto L5;
        Class<?>[] r0 = new Class[r3.length];
    L8:
        if (r2 >= r3.length) goto L14;
        Object r1 = r3[r2];
        if (r1 != null) goto L12;
        Class<?> r4 = a.class;
    L13:
        r0[r2] = r4;
        r2 = r2 + 1;
        goto L8
    L12:
        r4 = r1.getClass();
        goto L13
    L14:
        return r0;
    L5:
        return new Class[0];
    }

    private static Class<?> b(String r6) {
        return ZeusTransformUtils.forName(r6, "com.obric.aiagent.plugin");
    L8:
        e = move-exception;
        throw new c("Class not found: " + r6, e, new String[]{r6});
    L5:
        e = move-exception;
        throw new c("Failed to load class: " + r6, e, new String[]{r6});
    }

    public Class<?> b() {
        boolean r0 = this.f8122e;
        Object r2 = this.f8121d;
        if (r0 == false) goto L6;
        return (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.aiagent.plugin");
    L6:
        return r2.getClass();
    }

    private String c() {
        return b().getName();
    }

    public static Class<?> b(Class<?> r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.isPrimitive() == true) goto L8;
        return r1;
    L8:
        if (Boolean.TYPE != r1) goto L12;
        return Boolean.class;
    L12:
        if (Byte.TYPE != r1) goto L16;
        return Byte.class;
    L16:
        if (Character.TYPE != r1) goto L20;
        return Character.class;
    L20:
        if (Double.TYPE != r1) goto L24;
        return Double.class;
    L24:
        if (Float.TYPE != r1) goto L28;
        return Float.class;
    L28:
        if (Integer.TYPE != r1) goto L32;
        return Integer.class;
    L32:
        if (Long.TYPE != r1) goto L36;
        return Long.class;
    L36:
        if (Short.TYPE != r1) goto L40;
        return Short.class;
    L40:
        if (Void.TYPE != r1) goto L44;
        return Void.class;
    L44:
        return r1;
    }

    public int hashCode() {
        return this.f8121d.hashCode();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() != r3.getClass()) goto L13;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
        return this.f8121d.equals(r4.f8121d);
    L13:
        return false;
    }

    public String toString() {
        return "TTReflect{target=" + this.f8121d + ", isClassTarget=" + this.f8122e + ", targetClass=" + c() + '}';
    }
}

package com.ttnet.org.chromium.base;

import com.bytedance.librarian.LibrarianImpl;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18333b;

    public static class a {
    }

    public m(Object r10) {
        this.f18332a = r10;
        this.f18333b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AccessibleObject a(AccessibleObject r10) {
        if (r10 != 0) goto L6;
        return null;
    L6:
        if ((r10 instanceof Member) == false) goto L13;
        Member r11 = (Member) r10;
        if (Modifier.isPublic(r11.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r11.getDeclaringClass().getModifiers()) == false) goto L13;
        return r10;
    L13:
        if (r10.isAccessible() == true) goto L15;
        r10.setAccessible(true);
    L15:
        return r10;
    }

    public static m i(Object r10) {
        return new m(r10);
    }

    public static m j(Method r10, Object r11, Object... r12) {
        a(r10);     // Catch: Exception -> L6
        if (r10.getReturnType() != Void.TYPE) goto L9;
        r10.invoke(r11, r12);     // Catch: Exception -> L6
        return i(r11);
    L9:
        return i(r10.invoke(r11, r12));
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public static Object n(Object r10) {
        if ((r10 instanceof m) == true) goto L5;
        return r10;
    L5:
        return ((m) r10).f();
    }

    public static Class o(Class r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isPrimitive() == true) goto L8;
        return r10;
    L8:
        if (Boolean.TYPE != r10) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r10) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r10) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r10) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r10) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r10) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r10) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r10) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r10) goto L44;
        return Void.class;
    L44:
        return r10;
    }

    public m b(String r10) {
        return c(r10, null, new Object[0]);
    }

    public m c(String r10, Class[] r11, Object... r12) {
        return j(d(r10, r11, r12), this.f18332a, r12);
    L4:
        return j(l(r10, r11), this.f18332a, r12);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Method d(String r13, Class[] r14, Object... r15) {
        Class r16 = m();
        return r16.getMethod(r13, r14);
    L28:
        return r16.getDeclaredMethod(r13, r14);
    L7:
        r16 = r16.getSuperclass();
        if (r16 != null) goto L28;
        Class r12 = this.m();
        Method[] r17 = r12.getMethods();
        int r10 = r17.length;
        int r11 = 0;
    L10:
        if (r11 >= r10) goto L24;
        Method r18 = r17[r11];
        if (r13.equals(r18.getName()) == false) goto L22;
        Class<?>[] r19 = r18.getParameterTypes();
        if (k.b() == false) goto L18;
        int r20 = r19.length;
        int r21 = 0;
        int r22 = 1;
    L16:
        if (r21 >= r20) goto L18;
        k.a("Plugin", "Reflect type = " + r12 + " method = " + r13 + " paramTypes " + r22 + " = " + r19[r21].getName());
        r22 = r22 + 1;
        r21 = r21 + 1;
    L18:
        if (r19 == null) goto L22;
        if (r19.length != r14.length) goto L22;
        return r18;
    L22:
        r11 = r11 + 1;
        goto L10
    L24:
        throw new NoSuchMethodException();
    }

    public final Field e(String r10, Class... r11) {
        Class r12 = m();
        if (r11 != null) goto L5;
    L37:
        return r12.getField(r10);
    L24:
        e = move-exception;
    L35:
        return (Field) a(r12.getDeclaredField(r10));
    L27:
        r12 = r12.getSuperclass();
        if (r12 != null) goto L35;
        throw new ReflectException(e);
    L5:
        if (r11.length <= 0) goto L37;
    L33:
        Field[] r13 = r12.getDeclaredFields();     // Catch: Exception -> L32
        int r14 = r13.length;     // Catch: Exception -> L32
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L17;
        Field r16 = r13[r15];     // Catch: Exception -> L32
        Class<?> r17 = r16.getType();     // Catch: Exception -> L32
        if (r17 == null) goto L16;
        if (r17.getName().equals(r11[0].getName()) == false) goto L16;
        if (r16.getName().equals(r10) == false) goto L16;
        return (Field) a(r16);
    L16:
        r15 = r15 + 1;
    L17:
        r12 = r12.getSuperclass();
        if (r12 != null) goto L33;
        throw new ReflectException("NoSuchFieldException");
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof m) == true) goto L5;
        return false;
    L5:
        return this.f18332a.equals(((m) r10).f());
    }

    public Object f() {
        return this.f18332a;
    }

    public final boolean g(Method r10, String r11, Class[] r12) {
        if (r10.getName().equals(r11) == true) goto L5;
    L7:
        return false;
    L5:
        if (h(r10.getParameterTypes(), r12) == false) goto L7;
        return true;
    }

    public final boolean h(Class[] r10, Class[] r11) {
        if (r10.length != r11.length) goto L16;
        int r12 = 0;
    L6:
        if (r12 >= r11.length) goto L14;
        if (r11[r12] == a.class) goto L12;
        if (o(r10[r12]).isAssignableFrom(o(r11[r12])) == true) goto L12;
        return false;
    L12:
        r12 = r12 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return this.f18332a.hashCode();
    }

    public m k(String r10, Object r11) {
        e(r10, new Class[0]).set(this.f18332a, n(r11));     // Catch: Exception -> L5
        return this;
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    public final Method l(String r10, Class[] r11) {
        Class r12 = m();
        Method[] r13 = r12.getMethods();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        Method r16 = r13[r15];
        if (g(r16, r10, r11) == true) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        Method[] r17 = r12.getDeclaredMethods();
        int r18 = r17.length;
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L14;
        Method r20 = r17[r19];
        if (g(r20, r10, r11) == true) goto L12;
        r19 = r19 + 1;
        goto L9
    L12:
        return r20;
    L14:
        r12 = r12.getSuperclass();
        if (r12 != null) goto L8;
        throw new NoSuchMethodException("No similar method " + r10 + " with params " + Arrays.toString(r11) + " could be found on type " + m() + LibrarianImpl.Constants.DOT);
    }

    public Class m() {
        if (this.f18333b == false) goto L7;
        return (Class) this.f18332a;
    L7:
        return this.f18332a.getClass();
    }

    public String toString() {
        return this.f18332a.toString();
    }
}

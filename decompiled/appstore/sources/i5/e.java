package i5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class[] f20510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f20511b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f20512c = null;

    static {
        Class r10 = Byte.TYPE;
        Class r11 = Short.TYPE;
        Class r12 = Character.TYPE;
        Class r13 = Integer.TYPE;
        Class r14 = Long.TYPE;
        Class r15 = Float.TYPE;
        Class r16 = Double.TYPE;
        f20510a = new Class[]{r10, r11, r12, r13, r14, r15, r16};
        HashMap r17 = new HashMap();
        f20511b = r17;
        f20512c = new HashMap();
        r17.put(r10, Byte.class);
        r17.put(Boolean.TYPE, Boolean.class);
        r17.put(r11, Short.class);
        r17.put(r12, Character.class);
        r17.put(r14, Long.class);
        r17.put(r13, Integer.class);
        r17.put(r15, Float.class);
        r17.put(r16, Double.class);
        Class r18 = Void.TYPE;
        r17.put(r18, r18);
        Iterator r19 = r17.keySet().iterator();
    L4:
        if (r19.hasNext() == false) goto L8;
        Class r20 = (Class) r19.next();
        Class r21 = (Class) f20511b.get(r20);
        if (r20.equals(r21) == true) goto L4;
        f20512c.put(r21, r20);
        goto L4
    }

    public static int a(Class[] r10, Class[] r11, Class[] r12) {
        float r13 = d(r12, r10);
        float r14 = d(r12, r11);
        if (r13 >= r14) goto L6;
        return -1;
    L6:
        if (r14 >= r13) goto L8;
        return 1;
    L8:
        return 0;
    }

    public static float b(Class r10, Class r11) {
        if (r11.isPrimitive() == true) goto L5;
        float r12 = 0.0f;
    L7:
        if (r10 == null) goto L16;
        if (r11.equals(r10) == true) goto L16;
        if (r11.isInterface() == false) goto L15;
        if (f(r10, r11) == false) goto L15;
        r12 = r12 + 0.25f;
    L15:
        r12 = r12 + 1.0f;
        r10 = r10.getSuperclass();
    L16:
        if (r10 == null) goto L18;
        return r12;
    L18:
        return r12 + 1.5f;
    L5:
        return c(r10, r11);
    }

    public static float c(Class r10, Class r11) {
        if (r10.isPrimitive() == true) goto L5;
        r10 = m(r10);
        float r12 = 0.1f;
    L6:
        int r13 = 0;
    L7:
        if (r10 == r11) goto L16;
        Class[] r14 = f20510a;
        if (r13 >= r14.length) goto L16;
        if (r10 != r14[r13]) goto L15;
        r12 = r12 + 0.1f;
        if (r13 >= (r14.length - 1)) goto L15;
        r10 = r14[r13 + 1];
    L15:
        r13 = r13 + 1;
    L16:
        return r12;
    L5:
        r12 = 0.0f;
        goto L6
    }

    public static float d(Class[] r10, Class[] r11) {
        float r12 = 0.0f;
        int r13 = 0;
    L4:
        if (r13 >= r10.length) goto L6;
        r12 = r12 + b(r10[r13], r11[r13]);
        r13 = r13 + 1;
        goto L4
    L6:
        return r12;
    }

    public static boolean e(Member r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (Modifier.isPublic(r10.getModifiers()) == false) goto L8;
        if (r10.isSynthetic() == true) goto L8;
        return true;
    }

    public static boolean f(Class r10, Class r11) {
        return g(r10, r11, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean g(Class r10, Class r11, boolean r12) {
        if (r11 != 0) goto L6;
        return false;
    L6:
        if (r10 == null) goto L8;
        if (r12 == false) goto L25;
        if (r10.isPrimitive() == false) goto L18;
        if (r11.isPrimitive() == true) goto L18;
        r10 = k(r10);
        if (r10 != null) goto L18;
        return false;
    L18:
        if (r11.isPrimitive() == false) goto L25;
        if (r10.isPrimitive() == true) goto L25;
        r10 = m(r10);
        if (r10 != null) goto L25;
        return false;
    L25:
        if (r10.equals(r11) == false) goto L28;
        return true;
    L28:
        if (r10.isPrimitive() == false) goto L32;
        return i(r10, r11);
    L32:
        return r11.isAssignableFrom(r10);
    L8:
        return !r11.isPrimitive();
    }

    public static boolean h(Class[] r10, Class[] r11, boolean r12) {
        if (c.a(r10, r11) == true) goto L5;
        return false;
    L5:
        if (r10 != null) goto L7;
        r10 = c.f20508a;
    L7:
        if (r11 != null) goto L9;
        r11 = c.f20508a;
    L9:
        int r13 = 0;
    L11:
        if (r13 >= r10.length) goto L16;
        if (g(r10[r13], r11[r13], r12) == false) goto L14;
        r13 = r13 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    }

    public static boolean i(Class r10, Class r11) {
        if (r11.isPrimitive() == true) goto L5;
        return false;
    L5:
        Class r12 = Integer.TYPE;
        if (r12.equals(r10) == true) goto L8;
        Class r13 = Long.TYPE;
        if (r13.equals(r10) == false) goto L24;
        if (Float.TYPE.equals(r11) == true) goto L22;
        if (Double.TYPE.equals(r11) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        if (Boolean.TYPE.equals(r10) == true) goto L56;
        Class r14 = Double.TYPE;
        if (r14.equals(r10) == true) goto L56;
        Class r15 = Float.TYPE;
        if (r15.equals(r10) == false) goto L33;
        return r14.equals(r11);
    L33:
        if (r12.equals(r11) == false) goto L35;
    L42:
        boolean r16 = true;
    L44:
        if (Character.TYPE.equals(r10) == true) goto L55;
        Class r17 = Short.TYPE;
        if (r17.equals(r10) == true) goto L55;
        if (Byte.TYPE.equals(r10) == true) goto L51;
        return false;
    L51:
        if (r17.equals(r11) == true) goto L54;
        if (r16 == true) goto L54;
        return false;
    L54:
        return true;
    L55:
        return r16;
    L35:
        if (r13.equals(r11) == true) goto L42;
        if (r15.equals(r11) == true) goto L42;
        if (r14.equals(r11) == true) goto L42;
        r16 = false;
    L56:
        return false;
    L8:
        if (Long.TYPE.equals(r11) == true) goto L14;
        if (Float.TYPE.equals(r11) == true) goto L14;
        if (Double.TYPE.equals(r11) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean j(int r10) {
        if ((r10 & 7) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Class k(Class r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.isPrimitive() == true) goto L6;
        return r10;
    L6:
        return (Class) f20511b.get(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean l(AccessibleObject r10) {
        if (r10 != 0) goto L5;
    L16:
        return false;
    L5:
        if (r10.isAccessible() == true) goto L16;
        Member r11 = (Member) r10;
        if (r10.isAccessible() == true) goto L16;
        if (Modifier.isPublic(r11.getModifiers()) == false) goto L16;
        if (j(r11.getDeclaringClass().getModifiers()) == false) goto L16;
        r10.setAccessible(true);     // Catch: Exception -> L17
        return true;
    }

    public static Class m(Class r10) {
        return (Class) f20512c.get(r10);
    }
}

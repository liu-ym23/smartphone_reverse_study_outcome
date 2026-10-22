package j5;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f20904a = null;

    static {
        HashMap r10 = new HashMap();
        f20904a = r10;
        Class r11 = Boolean.TYPE;
        r10.put(Boolean.class, r11);
        Class r12 = Byte.TYPE;
        r10.put(Byte.class, r12);
        Class r13 = Character.TYPE;
        r10.put(Character.class, r13);
        Class r14 = Short.TYPE;
        r10.put(Short.class, r14);
        Class r15 = Integer.TYPE;
        r10.put(Integer.class, r15);
        Class r16 = Float.TYPE;
        r10.put(Float.class, r16);
        Class r17 = Long.TYPE;
        r10.put(Long.class, r17);
        Class r18 = Double.TYPE;
        r10.put(Double.class, r18);
        r10.put(r11, r11);
        r10.put(r12, r12);
        r10.put(r13, r13);
        r10.put(r14, r14);
        r10.put(r15, r15);
        r10.put(r16, r16);
        r10.put(r17, r17);
        r10.put(r18, r18);
    }

    public static Object a(String r10, String r11, Object... r12) {
        return b(Class.forName(r10), r11, r12);
    L4:
        e = move-exception;
        Log.w("JavaCalls", "Meet exception when call Method '" + r11 + "' in " + r10, e);
        return null;
    }

    public static Object b(Class r10, String r11, Object... r12) {
        return e(r10, r11, f(r12)).invoke(null, g(r12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Class[] r10, Class[] r11) {
        if (r10 != 0) goto L10;
        if (r11 != null) goto L6;
        return true;
    L6:
        if (r11.length != 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r11 != null) goto L17;
        if (r10.length != 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (r10.length == r11.length) goto L19;
        return false;
    L19:
        int r12 = 0;
    L21:
        if (r12 >= r10.length) goto L30;
        if (r10[r12].isAssignableFrom(r11[r12]) == true) goto L29;
        Map r13 = f20904a;
        if (r13.containsKey(r10[r12]) == false) goto L28;
        if (((Class) r13.get(r10[r12])).equals(r13.get(r11[r12])) == true) goto L29;
    L28:
        return false;
    L29:
        r12 = r12 + 1;
        goto L21
    L30:
        return true;
    }

    public static Method d(Method[] r10, String r11, Class[] r12) {
        if (r11 == null) goto L14;
        int r13 = r10.length;
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L11;
        Method r15 = r10[r14];
        if (r15.getName().equals(r11) == false) goto L10;
        if (c(r15.getParameterTypes(), r12) == false) goto L10;
        return r15;
    L10:
        r14 = r14 + 1;
        goto L4
    L11:
        return null;
    L14:
        throw new NullPointerException("Method name must not be null.");
    }

    public static Method e(Class r10, String r11, Class... r12) {
        Method r13 = d(r10.getDeclaredMethods(), r11, r12);
        if (r13 == null) goto L5;
        r13.setAccessible(true);
        return r13;
    L5:
        if (r10.getSuperclass() == null) goto L9;
        return e(r10.getSuperclass(), r11, r12);
    L9:
        throw new NoSuchMethodException();
    }

    public static Class[] f(Object... r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length <= 0) goto L20;
        Class[] r11 = new Class[r10.length];
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L15;
        Object r13 = r10[r12];
        if (r13 != null) goto L12;
        Class<?> r14 = null;
    L13:
        r11[r12] = r14;
        r12 = r12 + 1;
        goto L8
    L12:
        r14 = r13.getClass();
        goto L13
    L15:
        return r11;
    L20:
        return null;
    }

    public static Object[] g(Object... r10) {
        if (r10 != null) goto L4;
    L9:
        return null;
    L4:
        if (r10.length <= 0) goto L9;
        Object[] r11 = new Object[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L12;
        r11[r12] = r10[r12];
        r12 = r12 + 1;
        goto L7
    L12:
        return r11;
    }
}

package d6;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f19099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f19100b = null;

    static {
        f19099a = new HashMap();
        HashMap r10 = new HashMap();
        f19100b = r10;
        r10.put(Boolean.TYPE, Boolean.class);
        r10.put(Byte.TYPE, Byte.class);
        r10.put(Character.TYPE, Character.class);
        r10.put(Short.TYPE, Short.class);
        r10.put(Integer.TYPE, Integer.class);
        r10.put(Long.TYPE, Long.class);
        r10.put(Double.TYPE, Double.class);
        r10.put(Float.TYPE, Float.class);
        r10.put(Void.TYPE, Void.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method a(Class r13, String r14, Class... r15) {
        f.b(r13, "The class must not be null");
        f.c(!TextUtils.isEmpty(r14), "The method name must not be blank");
        String r10 = b(r13, r14, r15);
        Map r11 = f19099a;
        monitor-enter(r11);
        Method r12 = (Method) f19099a.get(r10);     // Catch: Throwable -> L55
        monitor-exit(r11);     // Catch: Throwable -> L55
        if (r12 != null) goto L8;
    L11:
        if (r13 == null) goto L53;
        if (e.a() == true) goto L15;
    L19:
        r12 = r13.getDeclaredMethod(r14, r15);     // Catch: NoSuchMethodException -> L58
        goto L20
    L15:
        if (c.a() == null) goto L19;
        r12 = c.a().getMethod(r13, r14, r15);     // Catch: NoSuchMethodException -> L58
        if (r12 != null) goto L20;
        r12 = r13.getDeclaredMethod(r14, r15);     // Catch: NoSuchMethodException -> L58
    L20:
        if (r12 != null) goto L43;
        Method[] r16 = r13.getDeclaredMethods();
        if (r16 == null) goto L43;
        int r17 = r16.length;
        int r18 = 0;
    L24:
        if (r18 >= r17) goto L43;
        Method r19 = r16[r18];
        if (r19 == null) goto L42;
        if (TextUtils.equals(r19.getName(), r14) == false) goto L42;
        Class<?>[] r20 = r19.getParameterTypes();
        if (r15 == null) goto L42;
        if (r15.length != r20.length) goto L42;
        boolean r110 = true;
        int r21 = 0;
    L35:
        if (r21 >= r15.length) goto L40;
        if (e(r15[r21], r20[r21]) == true) goto L39;
        r110 = false;
    L39:
        r21 = r21 + 1;
        goto L35
    L40:
        if (r110 == false) goto L42;
        r12 = r19;
    L42:
        r18 = r18 + 1;
    L43:
        if (r12 != null) goto L44;
        r13 = r13.getSuperclass();
        goto L11
    L44:
        r12.setAccessible(true);
        Map r22 = f19099a;
        monitor-enter(r22);
        f19099a.put(r10, r12);     // Catch: Throwable -> L49
        monitor-exit(r22);     // Catch: Throwable -> L49
        return r12;
    L49:
        th = move-exception;
        throw th;
    L53:
        return null;
    L8:
        if (r12.isAccessible() == true) goto L10;
        r12.setAccessible(true);
    L10:
        return r12;
    L55:
        th = move-exception;
        throw th;
    }

    public static String b(Class r10, String r11, Class... r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append(r10.toString());
        r13.append("#");
        r13.append(r11);
        if (r12 != null) goto L5;
    L9:
        r13.append(Void.class.toString());
    L11:
        return r13.toString();
    L5:
        if (r12.length <= 0) goto L9;
        int r14 = r12.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L11;
        r13.append(r12[r15].toString());
        r13.append("#");
        r15 = r15 + 1;
        goto L7
    }

    public static Object c(Class r10, String r11, Object... r12) {
        Object[] r13 = b.b(r12);
        return d(r10, r11, r13, b.c(r13));
    }

    public static Object d(Class r10, String r11, Object[] r12, Class[] r13) {
        Class[] r14 = b.a(r13);
        Object[] r15 = b.b(r12);
        Method r16 = a(r10, r11, r14);
        if (r16 != null) goto L5;
        return null;
    L5:
        return r16.invoke(null, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(Class r10, Class r11) {
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r10 != null) goto L9;
        return !r11.isPrimitive();
    L9:
        if (r10.isPrimitive() == true) goto L11;
    L13:
        boolean r12 = r11.isPrimitive();
        Class r13 = r11;
        if (r12 == false) goto L19;
        r13 = r11;
        if (r10.isPrimitive() == true) goto L19;
        r13 = (Class) f19100b.get(r11);
    L19:
        return r13.isAssignableFrom(r10);
    L11:
        if (r11.isPrimitive() == true) goto L13;
        r10 = (Class) f19100b.get(r10);
        goto L13
    }
}

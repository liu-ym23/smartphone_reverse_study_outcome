package ai4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f3767a = null;

    public static class a<T> {
    }

    static {
        HashMap r100 = new HashMap();
        f3767a = r100;
        Class r101 = Boolean.TYPE;
        r100.put(Boolean.class, r101);
        r100.put(Byte.class, Byte.TYPE);
        r100.put(Character.class, Character.TYPE);
        r100.put(Short.class, Short.TYPE);
        Class r102 = Integer.TYPE;
        r100.put(Integer.class, r102);
        Class r103 = Float.TYPE;
        r100.put(Float.class, r103);
        Class r104 = Long.TYPE;
        r100.put(Long.class, r104);
        r100.put(Double.class, Double.TYPE);
        r100.put(r101, r101);
        Class r105 = Byte.TYPE;
        r100.put(r105, r105);
        Class r106 = Character.TYPE;
        r100.put(r106, r106);
        Class r107 = Short.TYPE;
        r100.put(r107, r107);
        r100.put(r102, r102);
        r100.put(r103, r103);
        r100.put(r104, r104);
        Class r108 = Double.TYPE;
        r100.put(r108, r108);
    }

    public static Object a(Object r100, Object... r101) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class<?> r102 = r100.getClass();
        int r103 = 0;
        Object[] r104 = null;
        if (r101.length <= 0) goto L17;
        Class[] r105 = new Class[r101.length];
        int r106 = 0;
    L6:
        if (r106 >= r101.length) goto L18;
        Object r107 = r101[r106];
        if (r107 != null) goto L10;
    L12:
        if (r107 != null) goto L14;
        Class<?> r108 = null;
    L15:
        r105[r106] = r108;
    L16:
        r106 = r106 + 1;
        goto L6
    L14:
        r108 = r107.getClass();
        goto L15
    L10:
        if ((r107 instanceof a) == false) goto L12;
        a r109 = (a) r107;
        r105[r106] = null;
    L18:
        Method r110 = b(r102, r105);
        if (r101.length <= 0) goto L32;
        Object[] r111 = new Object[r101.length];
    L22:
        if (r103 >= r101.length) goto L30;
        Object r112 = r101[r103];
        if (r112 != null) goto L26;
    L28:
        r111[r103] = r112;
    L29:
        r103 = r103 + 1;
        goto L22
    L26:
        if ((r112 instanceof a) == false) goto L28;
        a r113 = (a) r112;
        r111[r103] = null;
        goto L29
    L30:
        r104 = r111;
    L32:
        return r110.invoke(r100, r104);
    L17:
        r105 = null;
        goto L18
    }

    public static Method b(Class r100, Class... r101) throws NoSuchMethodException, SecurityException {
        Method r102 = r100.getDeclaredMethod("getSubReason", r101);     // Catch: Throwable -> L9 NoSuchMethodException -> L11
        if (r102 == null) goto L8;
        r102.setAccessible(true);
        return r102;
    L8:
        throw new NoSuchMethodException();
    L12:
        if (r100.getSuperclass() == null) goto L16;
        return b(r100.getSuperclass(), r101);
    L16:
        throw new NoSuchMethodException();
    L10:
        throw new NoSuchMethodException();
    }
}

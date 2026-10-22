package com.baidu.bbalbscesium.i;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes39.dex */
public class i {

    public static class a extends Exception {
        public a(String r100) {
            super(r100);
        }

        public a(String r100, Throwable r101) {
            super(r100, r101);
        }

        public a(Throwable r100) {
            super(r100);
        }
    }

    public i() {
    }

    private static Class a(Class r100) {
        if (r100 != Character.TYPE) goto L7;
        return Character.class;
    L7:
        if (r100 != Boolean.TYPE) goto L11;
        return Boolean.class;
    L11:
        if (r100 != Long.TYPE) goto L15;
        return Long.class;
    L15:
        if (r100 != Integer.TYPE) goto L19;
        return Integer.class;
    L19:
        if (r100 != Short.TYPE) goto L23;
        return Short.class;
    L23:
        if (r100 != Byte.TYPE) goto L27;
        return Byte.class;
    L27:
        if (r100 != Float.TYPE) goto L31;
        return Float.class;
    L31:
        if (r100 != Double.TYPE) goto L35;
        return Double.class;
    L35:
        throw new IllegalArgumentException(String.format("Don't know the wrapper type for primitive type %s.", new Object[]{r100}));
    }

    private static Object a(Class r110, Object[] r111) throws Exception {
        Constructor<?>[] r112 = r110.getConstructors();
        int r100 = r112.length;
        Constructor<?> r101 = null;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L38;
        Constructor<?> r103 = r112[r102];
        Class<?>[] r104 = r103.getParameterTypes();
        if (r104.length < r111.length) goto L37;
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r105 >= r111.length) goto L26;
        Object r107 = r111[r105];
    L11:
        if (r107 == null) goto L22;
        if (r106 >= r104.length) goto L22;
        Class<?> r113 = r104[r106];
        if (r113.isPrimitive() == false) goto L18;
        r113 = a(r113);
    L18:
        if (r113.isInstance(r107) == true) goto L22;
        r106 = r106 + 1;
    L22:
        if (r106 == r104.length) goto L26;
        r106 = r106 + 1;
        r105 = r105 + 1;
    L26:
        if (r105 != r111.length) goto L37;
        if (r101 != null) goto L29;
    L36:
        r101 = r103;
        goto L37
    L29:
        if (r104.length < r101.getParameterTypes().length) goto L36;
        if (r104.length != r101.getParameterTypes().length) goto L37;
        throw new IllegalArgumentException("Multiple consturctors match parameters");
    L37:
        r102 = r102 + 1;
        goto L3
    L38:
        if (r101 != null) goto L40;
        return null;
    L40:
        return r101.newInstance(r111);
    }

    public static String a(byte[] r100) throws Exception {
        byte[] r101 = com.baidu.bbalbscesium.k.a.g.a();
        return new String(com.baidu.bbalbscesium.k.a.c.a(r101, r101, r100));
    }

    public static Method a(Class r100, String r101, Class[] r102) throws NoSuchMethodException {
        Method r103 = r100.getDeclaredMethod(r101, r102);
        r103.setAccessible(true);
        return r103;
    }

    public static Object b(Class r100, Object[] r101) throws Exception {
        if (r101 == null) goto L8;
        if (r101.length <= 0) goto L8;
        return a(r100, r101);
    L8:
        return r100.newInstance();
    }
}

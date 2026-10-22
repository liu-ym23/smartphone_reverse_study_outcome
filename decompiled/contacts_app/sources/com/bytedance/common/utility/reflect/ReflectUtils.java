package com.bytedance.common.utility.reflect;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    private ReflectUtils() {
    }

    public static Method getMethod(Class<?> r5, String r6, Class<?>[] r7) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (StringUtils.isEmpty(r6) == true) goto L19;
        Logger.d(TAG, "thread id : " + Thread.currentThread().getName());     // Catch: Throwable -> L9
        return r5.getMethod(r6, r7);
    L9:
        th = move-exception;
        Logger.e(TAG, "exception in getMethod, pkg : " + r5.getName() + ", function : " + r6 + ", " + th.toString());
        return r5.getDeclaredMethod(r6, r7);
    L21:
        return null;
    L19:
        return null;
    }

    public static Object invokeMethod(Class<?> r1, String r2, Object... r3) {
        return invokeMethod(r1, r2, null, null, r3);
    }

    public static Object invokeMethod(Class<?> r3, String r4, Class<?>[] r5, Object[] r6, Object... r7) {
        if (r3 != null) goto L5;
    L25:
        return null;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L25;
        if (r5 != null) goto L10;
        r5 = new Class[0];
    L10:
        if (r6 != null) goto L26;
        r6 = new Object[0];
    L26:
        Method r8 = getMethod(r3, r4, r5);     // Catch: Throwable -> L23
        if (r8 != null) goto L15;
        return null;
    L15:
        r8.setAccessible(true);     // Catch: Throwable -> L23
        if (r7 == null) goto L22;
        if (r7.length <= 0) goto L22;
        return r8.invoke(r7[0], r6);
    L22:
        return r8.invoke(null, r6);
    L23:
        th = move-exception;
        Logger.e(TAG, "exception in invokeMethod, pkg : " + r3.getName() + ", function : " + r4 + ", " + th.toString());
        goto L25
    }

    public static Object getFiledValue(Object r5, Class<?> r6) {
        if (r5 == null) goto L16;
        if (r6 == null) goto L16;
        Field[] r1 = r5.getClass().getDeclaredFields();     // Catch: Throwable -> L14
        int r2 = 0;
    L8:
        if (r2 >= r1.length) goto L16;
        r1[r2].setAccessible(true);     // Catch: Throwable -> L14
        if (r1[r2].getType().getName().equals(r6.getName()) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r1[r2].get(r5);
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        return null;
    }
}

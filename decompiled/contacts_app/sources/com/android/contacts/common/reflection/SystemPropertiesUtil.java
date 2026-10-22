package com.android.contacts.common.reflection;

import com.GlobalProxyLancet;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SystemPropertiesUtil {
    public SystemPropertiesUtil() {
    }

    public static final int getInt(String r5, int r6) {
        Integer r7 = (Integer) reflect("getInt", new Class[]{String.class, Integer.TYPE}, new Object[]{r5, Integer.valueOf(r6)});
        if (r7 != null) goto L5;
        return r6;
    L5:
        return r7.intValue();
    }

    private static Object reflect(String r2) {
        return reflect(r2, null, new Object[0]);
    }

    private static Object reflect(String r1, Class[] r2, Object... r3) {
        Class<?> r0 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L8
        if (r0 == null) goto L14;
        Method r4 = r0.getMethod(r1, r2);     // Catch: Exception -> L8
        if (r4 == null) goto L15;
        return r4.invoke(r0, r3);
    L15:
        return null;
    L14:
        return null;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("SystemPropertiesUtil", "Failed to reflect " + r1 + " with ex: " + e);
        return null;
    }
}

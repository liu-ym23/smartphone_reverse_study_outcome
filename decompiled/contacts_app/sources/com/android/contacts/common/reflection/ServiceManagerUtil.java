package com.android.contacts.common.reflection;

import android.os.IBinder;
import com.GlobalProxyLancet;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManagerUtil {
    public ServiceManagerUtil() {
    }

    public static final IBinder getService(String r4) {
        return (IBinder) reflect("getService", new Class[]{String.class, Integer.TYPE}, new Object[]{r4});
    }

    private static Object reflect(String r2) {
        return reflect(r2, null, new Object[0]);
    }

    private static Object reflect(String r1, Class[] r2, Object... r3) {
        Class<?> r0 = Class.forName("android.os.ServiceManager");     // Catch: Exception -> L8
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
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ServiceManagerUtil", "Failed to reflect " + r1 + " with ex: " + e);
        return null;
    }
}

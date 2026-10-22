package com.android.contacts.common.reflection;

import com.GlobalProxyLancet;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SubscriptionManagerUtil {
    public SubscriptionManagerUtil() {
    }

    public static final int[] getSubId(int r4) {
        return (int[]) reflect("getSubId", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r4)});
    }

    private static Object reflect(String r2) {
        return reflect(r2, null, new Object[0]);
    }

    private static Object reflect(String r1, Class[] r2, Object... r3) {
        Class<?> r0 = Class.forName("android.telephony.SubscriptionManager");     // Catch: Exception -> L8
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
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("SubscriptionManagerUtil", "Failed to reflect " + r1 + " with ex: " + e);
        return null;
    }
}

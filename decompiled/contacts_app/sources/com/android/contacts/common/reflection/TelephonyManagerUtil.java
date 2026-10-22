package com.android.contacts.common.reflection;

import android.telephony.TelephonyManager;
import com.GlobalProxyLancet;
import com.android.contacts.common.compat.TelephonyManagerCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerUtil {
    public TelephonyManagerUtil() {
    }

    public static final TelephonyManager getDefault() {
        return (TelephonyManager) reflect("getDefault", new Class[]{Void.TYPE}, new Object[0]);
    }

    public static boolean isMultiSimEnabled() {
        Class[] r0 = new Class[1];
        Class r1 = Void.TYPE;
        Boolean r2 = (Boolean) reflect("isMultiSimEnabled");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }

    private static Object reflect(String r2) {
        return reflect(r2, null, new Object[0]);
    }

    private static Object reflect(String r1, Class[] r2, Object... r3) {
        Class<?> r0 = Class.forName(TelephonyManagerCompat.TELEPHONY_MANAGER_CLASS);     // Catch: Exception -> L8
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
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TelephonyManagerUtil", "Failed to reflect " + r1 + " with ex: " + e);
        return null;
    }
}

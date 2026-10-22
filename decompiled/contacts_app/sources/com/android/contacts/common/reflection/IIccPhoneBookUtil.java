package com.android.contacts.common.reflection;

import android.os.IBinder;
import com.GlobalProxyLancet;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IIccPhoneBookUtil {
    public static final int EF_ADN = 28474;
    private static final String PHONEBOOK_SERVICE = "simphonebook";
    private static final String TAG = "IIccPhoneBookUtil";

    public IIccPhoneBookUtil() {
    }

    private static Object getIccPhoneBookProxy() {
        Method r1 = Class.forName("com.android.internal.telephony.IIccPhoneBook$Stub").getMethod("asInterface", new Class[]{IBinder.class});     // Catch: Exception -> L8
        IBinder r2 = ServiceManagerUtil.getService(PHONEBOOK_SERVICE);     // Catch: Exception -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return r1.invoke(null, new Object[]{r2});
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getIccPhoneBookProxy failed", e);
        return null;
    }

    public static List<?> getAdnRecordsInEf(int r7) {
        Object r0 = getIccPhoneBookProxy();     // Catch: Exception -> L11
        if (r0 == null) goto L5;
        Object r8 = r0.getClass().getMethod("getAdnRecordsInEf", new Class[]{Integer.TYPE}).invoke(r0, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L11
        if ((r8 instanceof List) == false) goto L10;
        return (List) r8;
    L10:
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getAdnRecordsInEf failed", e);
        return Collections.emptyList();
    }

    public static Object getAdnRecordsCapacity() {
        Object r1 = getIccPhoneBookProxy();     // Catch: Exception -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getClass().getMethod("getAdnRecordsCapacity", new Class[0]).invoke(r1, new Object[0]);
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getAdnRecordsCapacity failed", e);
        return null;
    }

    public static Object getAdnRecordsCapacityForSubscriber(int r8) {
        Object r1 = getIccPhoneBookProxy();     // Catch: Exception -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getClass().getMethod("getAdnRecordsCapacityForSubscriber", new Class[]{Integer.TYPE}).invoke(r1, new Object[]{Integer.valueOf(r8)});
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getAdnRecordsCapacityForSubscriber failed", e);
        return null;
    }

    public static int readCapacityInt(Object r3, String r4) {
        if (r3 != null) goto L12;
        return 0;
    L12:
        Object r5 = r3.getClass().getMethod(r4, new Class[0]).invoke(r3, new Object[0]);     // Catch: Exception -> L9
        if ((r5 instanceof Integer) == false) goto L14;
        return ((Integer) r5).intValue();
    L14:
        return 0;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "readCapacityInt " + r4 + " failed", e);
        return 0;
    }
}

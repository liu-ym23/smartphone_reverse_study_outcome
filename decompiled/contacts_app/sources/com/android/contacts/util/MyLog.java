package com.android.contacts.util;

import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes2.dex */
public final class MyLog {
    private static final String TAG = "XContacts";
    private static boolean openLog = false;

    static {
    }

    public MyLog() {
    }

    public static void d(String r1) {
        if (openLog == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }

    public static void v(String r1) {
        if (openLog == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, r1);
        return;
    }

    public static void e(String r1) {
        if (openLog == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r1);
        return;
    }

    public static void i(String r1) {
        if (openLog == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r1);
        return;
    }

    public static void w(String r1) {
        if (openLog == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, r1);
        return;
    }
}

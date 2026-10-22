package com.android.contacts.util;

import android.content.Context;
import android.os.SystemProperties;
import android.provider.Settings;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes2.dex */
public class ProductUtils {
    public static final String PROPERTY_TNT_INCALLUI_SUPPORT = "ro.product.tnt_incallui_support";
    private static final String TAG = "ProductUtils";
    public static final String TALKBACK_PACKAGE_NAME = "com.google.android.marvin.talkback.TalkBackService";

    public static boolean isSim1InLeft() {
        return true;
    }

    public ProductUtils() {
    }

    public static boolean isOpenTalkBack(Context r2) {
        if (r2 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "isOpenTalkBack context is null");
        return false;
    L6:
        String r3 = Settings.Secure.getString(r2.getContentResolver(), "enabled_accessibility_services");
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.contains(TALKBACK_PACKAGE_NAME) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isSupportDialInExtDisplay() {
        return SystemProperties.getBoolean(PROPERTY_TNT_INCALLUI_SUPPORT, false);
    }
}

package com.android.contacts.common.compat;

import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.common.model.CPOWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class CompatUtils {
    private static final String TAG = "CompatUtils";
    public static final int TYPE_ASSERT = 4;
    public static final int TYPE_DELETE = 3;
    public static final int TYPE_INSERT = 1;
    public static final int TYPE_UPDATE = 2;

    static {
    }

    public static boolean isNCompatible() {
        return true;
    }

    public CompatUtils() {
    }

    public static boolean isInsertCompat(CPOWrapper r2) {
        if (SdkVersionOverride.getSdkVersion(23) < 23) goto L7;
        return r2.getOperation().isInsert();
    L7:
        if (r2.getType() == 1) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isUpdateCompat(CPOWrapper r2) {
        if (SdkVersionOverride.getSdkVersion(23) < 23) goto L7;
        return r2.getOperation().isUpdate();
    L7:
        if (r2.getType() != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isDeleteCompat(CPOWrapper r2) {
        if (SdkVersionOverride.getSdkVersion(23) < 23) goto L7;
        return r2.getOperation().isDelete();
    L7:
        if (r2.getType() != 3) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isAssertQueryCompat(CPOWrapper r2) {
        if (SdkVersionOverride.getSdkVersion(23) < 23) goto L7;
        return r2.getOperation().isAssertQuery();
    L7:
        if (r2.getType() != 4) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean hasPrioritizedMimeType() {
        if (SdkVersionOverride.getSdkVersion(23) < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMSIMCompatible() {
        if (SdkVersionOverride.getSdkVersion(21) < 22) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVideoCompatible() {
        if (SdkVersionOverride.getSdkVersion(21) < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVideoPresenceCompatible() {
        if (SdkVersionOverride.getSdkVersion(23) <= 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isCallSubjectCompatible() {
        if (SdkVersionOverride.getSdkVersion(21) < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDefaultDialerCompatible() {
        return isMarshmallowCompatible();
    }

    public static boolean isLollipopMr1Compatible() {
        if (SdkVersionOverride.getSdkVersion(22) < 22) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMarshmallowCompatible() {
        if (SdkVersionOverride.getSdkVersion(21) < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isClassAvailable(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L12;
        return false;
    L12:
        Class.forName(r5);     // Catch: Throwable -> L8 ClassNotFoundException -> L11
        return true;
    L8:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unexpected exception when checking if class:" + r5 + " exists at runtime", th);
    L10:
        return false;
    }

    public static boolean isMethodAvailable(String r5, String r6, Class<?>... r7) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        Class.forName(r5).getMethod(r6, r7);     // Catch: Throwable -> L10 Throwable -> L13
        return true;
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "Could not find method: " + r5 + ContactsUtils.CHAR_POUND + r6);
    L10:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unexpected exception when checking if method: " + r5 + ContactsUtils.CHAR_POUND + r6 + " exists at runtime", th);
        return false;
    }

    public static Object invokeMethod(Object r4, String r5, Class<?>[] r6, Object[] r7) {
        if (r4 != null) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        String r2 = r4.getClass().getName();
        return Class.forName(r2).getMethod(r5, r6).invoke(r4, r7);
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "Could not invoke method: " + r2 + ContactsUtils.CHAR_POUND + r5);
    L10:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unexpected exception when invoking method: " + r2 + ContactsUtils.CHAR_POUND + r5 + " at runtime", th);
        return null;
    }

    public static boolean isLollipopCompatible() {
        if (SdkVersionOverride.getSdkVersion(21) < 21) goto L5;
        return true;
    L5:
        return false;
    }
}

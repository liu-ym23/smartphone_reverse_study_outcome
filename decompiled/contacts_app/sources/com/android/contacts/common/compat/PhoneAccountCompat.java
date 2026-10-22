package com.android.contacts.common.compat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.telecom.PhoneAccount;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class PhoneAccountCompat {
    private static final String TAG = "PhoneAccountCompat";

    static {
    }

    public PhoneAccountCompat() {
    }

    public static Icon getIcon(PhoneAccount r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (CompatUtils.isMarshmallowCompatible() == true) goto L8;
        return null;
    L8:
        return r2.getIcon();
    }

    public static Drawable createIconDrawable(PhoneAccount r2, Context r3) {
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        if (CompatUtils.isMarshmallowCompatible() == false) goto L11;
        return createIconDrawableMarshmallow(r2, r3);
    L11:
        if (CompatUtils.isLollipopMr1Compatible() == false) goto L14;
        return createIconDrawableLollipopMr1(r2, r3);
    L14:
        return null;
    }

    private static Drawable createIconDrawableMarshmallow(PhoneAccount r0, Context r1) {
        Icon r2 = getIcon(r0);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.loadDrawable(r1);
    }

    private static Drawable createIconDrawableLollipopMr1(PhoneAccount r7, Context r8) {
        return (Drawable) PhoneAccount.class.getMethod("createIconDrawable", new Class[]{Context.class}).invoke(r7, new Object[]{r8});
    L5:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unexpected exception when attempting to call android.telecom.PhoneAccount#createIconDrawable", th);
    L7:
        return null;
    }
}

package com.android.contacts.util;

import android.content.Context;
import android.telecom.TelecomManager;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TelecomUtil {
    private static final String TAG = "TelecomUtil";
    private static TelecomUtilImpl instance = null;
    private static boolean warningLogged = false;

    public static class TelecomUtilImpl {
        public TelecomUtilImpl() {
        }

        public boolean isInManagedCall(Context r2) {
            if (TelecomUtil.hasReadPhoneStatePermission(r2) == false) goto L9;
            TelecomManager r1 = TelecomUtil.access$000(r2);
            if (r1 != null) goto L8;
            return false;
        L8:
            return r1.isInManagedCall();
        L9:
            return false;
        }

        public boolean isInCall(Context r1) {
            if (TelecomUtil.hasReadPhoneStatePermission(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (TelecomUtil.access$000(r1).isInCall() == false) goto L7;
            return true;
        }

        public boolean hasPermission(Context r1, String r2) {
            if (ContextCompat.checkSelfPermission(r1, r2) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public TelecomUtil() {
    }

    static /* synthetic */ TelecomManager access$000(Context r0) {
        return getTelecomManager(r0);
    }

    static {
        instance = new TelecomUtilImpl();
    }

    public static boolean isInManagedCall(Context r1) {
        return instance.isInManagedCall(r1);
    }

    public static boolean isInCall(Context r1) {
        return instance.isInCall(r1);
    }

    private static boolean hasPermission(Context r1, String r2) {
        return instance.hasPermission(r1, r2);
    }

    public static boolean hasReadPhoneStatePermission(Context r1) {
        return hasPermission(r1, "android.permission.READ_PHONE_STATE");
    }

    private static TelecomManager getTelecomManager(Context r1) {
        return (TelecomManager) r1.getSystemService("telecom");
    }
}

package com.android.contacts.common.compat;

import android.telecom.Call;

/* JADX INFO: loaded from: classes.dex */
public class CallSdkCompat {

    public static class Details {
        public static final int CAPABILITY_CANNOT_DOWNGRADE_VIDEO_TO_AUDIO = 4194304;
        public static final int CAPABILITY_CAN_PULL_CALL = 8388608;
        public static final int PROPERTY_ENTERPRISE_CALL = 32;
        public static final int PROPERTY_IS_EXTERNAL_CALL = 64;

        public Details() {
        }
    }

    public CallSdkCompat() {
    }

    public static void pullExternalCall(Call r4) {
        if (CompatUtils.isNCompatible() == true) goto L9;
        return;
    L9:
        Call.class.getDeclaredMethod("pullExternalCall", new Class[0]).invoke(r4, new Object[0]);     // Catch: Throwable -> L8
        return;
    }
}

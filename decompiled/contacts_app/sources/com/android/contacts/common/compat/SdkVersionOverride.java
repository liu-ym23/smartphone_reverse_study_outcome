package com.android.contacts.common.compat;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class SdkVersionOverride {
    private static final boolean ALLOW_OVERRIDE_VERSION = false;

    private SdkVersionOverride() {
    }

    public static int getSdkVersion(int r0) {
        return Build.VERSION.SDK_INT;
    }
}

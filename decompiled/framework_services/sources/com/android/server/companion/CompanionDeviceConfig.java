package com.android.server.companion;

import android.os.Binder;
import android.provider.DeviceConfig;

/* JADX INFO: loaded from: classes.dex */
public class CompanionDeviceConfig {
    public static final String ENABLE_CONTEXT_SYNC_TELECOM = "enable_context_sync_telecom";
    private static final String NAMESPACE_COMPANION = "companion";

    public CompanionDeviceConfig() {
    }

    public static boolean isEnabled(String flag) {
        long token = Binder.clearCallingIdentity();
        boolean r2 = DeviceConfig.getBoolean(NAMESPACE_COMPANION, flag, false);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public static boolean isEnabled(String flag, boolean defaultValue) {
        return DeviceConfig.getBoolean(NAMESPACE_COMPANION, flag, defaultValue);
    }
}

package com.android.server.wm;

import android.app.compat.CompatChanges;
import android.provider.DeviceConfig;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
class ActivitySecurityModelFeatureFlags {
    static final int ASM_VERSION = 11;
    private static final int DEFAULT_VALUE = 0;
    static final String DOC_LINK = "go/android-asm";
    private static final String KEY_ASM_PREFIX = "ActivitySecurity__";
    private static final String KEY_ASM_RESTRICTIONS_ENABLED = "ActivitySecurity__asm_restrictions_enabled";
    private static final String KEY_ASM_TOASTS_ENABLED = "ActivitySecurity__asm_toasts_enabled";
    private static final String NAMESPACE = "window_manager";
    private static final int VALUE_DISABLE = 0;
    private static final int VALUE_ENABLE_FOR_ALL = 2;
    private static final int VALUE_ENABLE_FOR_V = 1;
    private static int sAsmRestrictionsEnabled;
    private static int sAsmToastsEnabled;

    public static /* synthetic */ void $r8$lambda$QiVgC5LLKqJS3j_2a23AqYQ8xhE(DeviceConfig.Properties r0) {
        lambda$initialize$0(r0);
    }

    ActivitySecurityModelFeatureFlags() {
    }

    static void initialize(Executor executor) {
        updateFromDeviceConfig();
        DeviceConfig.addOnPropertiesChangedListener(NAMESPACE, executor, new ActivitySecurityModelFeatureFlags$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ void lambda$initialize$0(DeviceConfig.Properties properties) {
        updateFromDeviceConfig();
    }

    static boolean shouldShowToast(int uid) {
        if (sAsmToastsEnabled != 2) goto L5;
        return true;
    L5:
        if (sAsmToastsEnabled == 1) goto L7;
    L9:
        return false;
    L7:
        if (CompatChanges.isChangeEnabled(230590090, uid) == false) goto L9;
        return true;
    }

    static boolean shouldRestrictActivitySwitch(int uid) {
        if (CompatChanges.isChangeEnabled(230590090, uid) == false) goto L5;
    L8:
        return true;
    L5:
        if (asmRestrictionsEnabledForAll() == true) goto L8;
        return false;
    }

    static boolean asmRestrictionsEnabledForAll() {
        if (sAsmRestrictionsEnabled != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static void updateFromDeviceConfig() {
        sAsmToastsEnabled = DeviceConfig.getInt(NAMESPACE, KEY_ASM_TOASTS_ENABLED, 0);
        sAsmRestrictionsEnabled = DeviceConfig.getInt(NAMESPACE, KEY_ASM_RESTRICTIONS_ENABLED, 0);
    }
}

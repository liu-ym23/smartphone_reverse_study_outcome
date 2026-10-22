package com.android.aconfig_new_storage;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_BLUETOOTH_FLAG_VALUE_BUG_FIX = "com.android.aconfig_new_storage.bluetooth_flag_value_bug_fix";
    public static final String FLAG_ENABLE_ACONFIGD_FROM_MAINLINE = "com.android.aconfig_new_storage.enable_aconfigd_from_mainline";
    public static final String FLAG_ENABLE_ACONFIG_STORAGE_DAEMON = "com.android.aconfig_new_storage.enable_aconfig_storage_daemon";
    public static final String FLAG_ENABLE_FULL_RUST_SYSTEM_ACONFIGD = "com.android.aconfig_new_storage.enable_full_rust_system_aconfigd";
    public static final String FLAG_SUPPORT_CLEAR_LOCAL_OVERRIDES_IMMEDIATELY = "com.android.aconfig_new_storage.support_clear_local_overrides_immediately";
    public static final String FLAG_SUPPORT_IMMEDIATE_LOCAL_OVERRIDES = "com.android.aconfig_new_storage.support_immediate_local_overrides";

    public Flags() {
    }

    public static boolean bluetoothFlagValueBugFix() {
        return true;
    }

    public static boolean enableAconfigStorageDaemon() {
        return true;
    }

    public static boolean enableAconfigdFromMainline() {
        return true;
    }

    public static boolean enableFullRustSystemAconfigd() {
        return true;
    }

    public static boolean supportClearLocalOverridesImmediately() {
        return true;
    }

    public static boolean supportImmediateLocalOverrides() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

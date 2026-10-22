package com.android.server.usage;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ADJUST_DEFAULT_BUCKET_ELEVATION_PARAMS = "com.android.server.usage.adjust_default_bucket_elevation_params";
    public static final String FLAG_AVOID_IDLE_CHECK = "com.android.server.usage.avoid_idle_check";
    public static final String FLAG_PERSIST_RESTORE_TO_RARE_APPS_LIST = "com.android.server.usage.persist_restore_to_rare_apps_list";
    public static final String FLAG_SCREEN_TIME_BYPASS = "com.android.server.usage.screen_time_bypass";

    public Flags() {
    }

    public static boolean adjustDefaultBucketElevationParams() {
        return true;
    }

    public static boolean avoidIdleCheck() {
        return true;
    }

    public static boolean persistRestoreToRareAppsList() {
        return true;
    }

    public static boolean screenTimeBypass() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

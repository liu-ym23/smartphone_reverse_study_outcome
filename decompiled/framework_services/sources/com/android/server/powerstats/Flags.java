package com.android.server.powerstats;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ALARM_BASED_POWERSTATS_LOGGING = "com.android.server.powerstats.alarm_based_powerstats_logging";
    public static final String FLAG_VERIFY_NON_NULL_ARGUMENTS = "com.android.server.powerstats.verify_non_null_arguments";

    public Flags() {
    }

    public static boolean alarmBasedPowerstatsLogging() {
        return false;
    }

    public static boolean verifyNonNullArguments() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

package com.android.server.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ANR_TIMER_FREEZER = "com.android.server.utils.anr_timer_freezer";
    public static final String FLAG_ANR_TIMER_SERVICE = "com.android.server.utils.anr_timer_service";
    public static final String FLAG_ANR_TIMER_TRACE = "com.android.server.utils.anr_timer_trace";

    public Flags() {
    }

    public static boolean anrTimerFreezer() {
        return true;
    }

    public static boolean anrTimerService() {
        return true;
    }

    public static boolean anrTimerTrace() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

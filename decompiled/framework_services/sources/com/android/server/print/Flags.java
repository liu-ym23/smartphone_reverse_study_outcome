package com.android.server.print;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_DO_NOT_INCLUDE_CAPABILITIES = "com.android.server.print.do_not_include_capabilities";

    public Flags() {
    }

    public static boolean doNotIncludeCapabilities() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

package com.android.server.policy;

/* JADX INFO: loaded from: classes2.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_SUPPORT_INPUT_WAKEUP_DELEGATE = "com.android.server.policy.support_input_wakeup_delegate";

    public Flags() {
    }

    public static boolean supportInputWakeupDelegate() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

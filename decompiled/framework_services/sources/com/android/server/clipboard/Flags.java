package com.android.server.clipboard;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_CLIPBOARD_GET_EVENT_LOGGING = "com.android.server.clipboard.clipboard_get_event_logging";

    public Flags() {
    }

    public static boolean clipboardGetEventLogging() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

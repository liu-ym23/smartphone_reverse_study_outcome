package com.android.server.os;

/* JADX INFO: loaded from: classes2.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ASYNC_START_BUGREPORT = "com.android.server.os.async_start_bugreport";
    public static final String FLAG_PROTO_TOMBSTONE = "com.android.server.os.proto_tombstone";

    public Flags() {
    }

    public static boolean asyncStartBugreport() {
        return false;
    }

    public static boolean protoTombstone() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

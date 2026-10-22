package com.android.server.connectivity;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_REPLACE_VPN_PROFILE_STORE = "com.android.server.connectivity.replace_vpn_profile_store";

    public Flags() {
    }

    public static boolean replaceVpnProfileStore() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

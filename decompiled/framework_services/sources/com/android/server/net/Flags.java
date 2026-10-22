package com.android.server.net;

/* JADX INFO: loaded from: classes2.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_NEVER_APPLY_RULES_TO_CORE_UIDS = "com.android.server.net.never_apply_rules_to_core_uids";
    public static final String FLAG_USE_DIFFERENT_DELAYS_FOR_BACKGROUND_CHAIN = "com.android.server.net.use_different_delays_for_background_chain";
    public static final String FLAG_USE_METERED_FIREWALL_CHAINS = "com.android.server.net.use_metered_firewall_chains";

    public Flags() {
    }

    public static boolean neverApplyRulesToCoreUids() {
        return true;
    }

    public static boolean useDifferentDelaysForBackgroundChain() {
        return false;
    }

    public static boolean useMeteredFirewallChains() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

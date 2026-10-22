package com.android.server.net;

/* JADX INFO: loaded from: classes2.dex */
public interface FeatureFlags {
    boolean neverApplyRulesToCoreUids();

    boolean useDifferentDelaysForBackgroundChain();

    boolean useMeteredFirewallChains();
}

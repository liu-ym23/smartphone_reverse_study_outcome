package com.android.server.stats;

/* JADX INFO: loaded from: classes3.dex */
public interface FeatureFlags {
    boolean accumulateNetworkStatsSinceBoot();

    boolean addMobileBytesTransferByProcStatePuller();

    boolean addPressureStallInformationPuller();

    boolean applyNetworkStatsPollRateLimit();

    boolean netstatsUseAddEntries();
}

package com.android.server.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.utils.FeatureFlags
    public boolean anrTimerFreezer() {
        return true;
    }

    @Override // com.android.server.utils.FeatureFlags
    public boolean anrTimerService() {
        return true;
    }

    @Override // com.android.server.utils.FeatureFlags
    public boolean anrTimerTrace() {
        return false;
    }
}

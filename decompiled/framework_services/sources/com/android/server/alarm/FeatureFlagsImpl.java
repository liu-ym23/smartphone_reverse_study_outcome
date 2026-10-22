package com.android.server.alarm;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.alarm.FeatureFlags
    public boolean acquireWakelockBeforeSend() {
        return false;
    }

    @Override // com.android.server.alarm.FeatureFlags
    public boolean startUserBeforeScheduledAlarms() {
        return true;
    }
}

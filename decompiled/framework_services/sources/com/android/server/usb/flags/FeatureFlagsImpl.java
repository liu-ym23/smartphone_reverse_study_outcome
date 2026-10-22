package com.android.server.usb.flags;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean allowRestrictionOfOverlayActivities() {
        return true;
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean checkUserActionUnlocked() {
        return true;
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean enableBindToMtpService() {
        return true;
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean maximizeUsbAudioVolumeWhenConnecting() {
        return true;
    }

    @Override // com.android.server.usb.flags.FeatureFlags
    public boolean waitForAlsaScanResultsIfHasAudioInterface() {
        return false;
    }
}

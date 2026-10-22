package com.android.media.audio;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean absVolumeIndexFix() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean alarmMinVolumeZero() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean asDeviceConnectionFailure() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean audioEraserEffect() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean audioserverPermissions() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean bluetoothMacAddressAnonymization() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean deferWearPermissionUpdates() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean disablePrescaleAbsoluteVolume() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean dsaOverBtLeAudio() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean equalScoLeaVcIndexRange() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningImpl() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningPartial() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningPartialVolume() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningStrict() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean musicFxEdgeToEdge() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean optimizeBtDeviceSwitch() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean portToPiidSimplification() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean replaceStreamBtSco() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean ringMyCar() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean ringerModeAffectsAlarm() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean setStreamVolumeOrder() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean spatializerOffload() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean spatializerUpmix() {
        return false;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean stereoSpatialization() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean vgsVssSyncMuteOrder() {
        return true;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean volumeRefactoring() {
        return false;
    }
}

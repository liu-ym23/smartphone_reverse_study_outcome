package com.android.media.audio;

/* JADX INFO: loaded from: classes.dex */
public interface FeatureFlags {
    boolean absVolumeIndexFix();

    boolean alarmMinVolumeZero();

    boolean asDeviceConnectionFailure();

    boolean audioEraserEffect();

    boolean audioserverPermissions();

    boolean bluetoothMacAddressAnonymization();

    boolean deferWearPermissionUpdates();

    boolean disablePrescaleAbsoluteVolume();

    boolean dsaOverBtLeAudio();

    boolean equalScoLeaVcIndexRange();

    boolean hardeningImpl();

    boolean hardeningPartial();

    boolean hardeningPartialVolume();

    boolean hardeningStrict();

    boolean musicFxEdgeToEdge();

    boolean optimizeBtDeviceSwitch();

    boolean portToPiidSimplification();

    boolean replaceStreamBtSco();

    boolean ringMyCar();

    boolean ringerModeAffectsAlarm();

    boolean setStreamVolumeOrder();

    boolean spatializerOffload();

    boolean spatializerUpmix();

    boolean stereoSpatialization();

    boolean vgsVssSyncMuteOrder();

    boolean volumeRefactoring();
}

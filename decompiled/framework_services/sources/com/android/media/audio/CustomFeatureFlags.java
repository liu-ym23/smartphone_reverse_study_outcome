package com.android.media.audio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ABS_VOLUME_INDEX_FIX, Flags.FLAG_ALARM_MIN_VOLUME_ZERO, Flags.FLAG_AS_DEVICE_CONNECTION_FAILURE, Flags.FLAG_AUDIO_ERASER_EFFECT, Flags.FLAG_AUDIOSERVER_PERMISSIONS, Flags.FLAG_BLUETOOTH_MAC_ADDRESS_ANONYMIZATION, Flags.FLAG_DEFER_WEAR_PERMISSION_UPDATES, Flags.FLAG_DISABLE_PRESCALE_ABSOLUTE_VOLUME, Flags.FLAG_DSA_OVER_BT_LE_AUDIO, Flags.FLAG_EQUAL_SCO_LEA_VC_INDEX_RANGE, Flags.FLAG_HARDENING_IMPL, Flags.FLAG_HARDENING_PARTIAL, Flags.FLAG_HARDENING_PARTIAL_VOLUME, Flags.FLAG_HARDENING_STRICT, Flags.FLAG_MUSIC_FX_EDGE_TO_EDGE, Flags.FLAG_OPTIMIZE_BT_DEVICE_SWITCH, Flags.FLAG_PORT_TO_PIID_SIMPLIFICATION, Flags.FLAG_REPLACE_STREAM_BT_SCO, Flags.FLAG_RING_MY_CAR, Flags.FLAG_RINGER_MODE_AFFECTS_ALARM, Flags.FLAG_SET_STREAM_VOLUME_ORDER, Flags.FLAG_SPATIALIZER_OFFLOAD, Flags.FLAG_SPATIALIZER_UPMIX, Flags.FLAG_STEREO_SPATIALIZATION, Flags.FLAG_VGS_VSS_SYNC_MUTE_ORDER, Flags.FLAG_VOLUME_REFACTORING, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean absVolumeIndexFix() {
        return getValue(Flags.FLAG_ABS_VOLUME_INDEX_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean alarmMinVolumeZero() {
        return getValue(Flags.FLAG_ALARM_MIN_VOLUME_ZERO, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean asDeviceConnectionFailure() {
        return getValue(Flags.FLAG_AS_DEVICE_CONNECTION_FAILURE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean audioEraserEffect() {
        return getValue(Flags.FLAG_AUDIO_ERASER_EFFECT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean audioserverPermissions() {
        return getValue(Flags.FLAG_AUDIOSERVER_PERMISSIONS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean bluetoothMacAddressAnonymization() {
        return getValue(Flags.FLAG_BLUETOOTH_MAC_ADDRESS_ANONYMIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean deferWearPermissionUpdates() {
        return getValue(Flags.FLAG_DEFER_WEAR_PERMISSION_UPDATES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean disablePrescaleAbsoluteVolume() {
        return getValue(Flags.FLAG_DISABLE_PRESCALE_ABSOLUTE_VOLUME, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean dsaOverBtLeAudio() {
        return getValue(Flags.FLAG_DSA_OVER_BT_LE_AUDIO, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean equalScoLeaVcIndexRange() {
        return getValue(Flags.FLAG_EQUAL_SCO_LEA_VC_INDEX_RANGE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningImpl() {
        return getValue(Flags.FLAG_HARDENING_IMPL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningPartial() {
        return getValue(Flags.FLAG_HARDENING_PARTIAL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningPartialVolume() {
        return getValue(Flags.FLAG_HARDENING_PARTIAL_VOLUME, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean hardeningStrict() {
        return getValue(Flags.FLAG_HARDENING_STRICT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean musicFxEdgeToEdge() {
        return getValue(Flags.FLAG_MUSIC_FX_EDGE_TO_EDGE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean optimizeBtDeviceSwitch() {
        return getValue(Flags.FLAG_OPTIMIZE_BT_DEVICE_SWITCH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean portToPiidSimplification() {
        return getValue(Flags.FLAG_PORT_TO_PIID_SIMPLIFICATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean replaceStreamBtSco() {
        return getValue(Flags.FLAG_REPLACE_STREAM_BT_SCO, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean ringMyCar() {
        return getValue(Flags.FLAG_RING_MY_CAR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean ringerModeAffectsAlarm() {
        return getValue(Flags.FLAG_RINGER_MODE_AFFECTS_ALARM, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean setStreamVolumeOrder() {
        return getValue(Flags.FLAG_SET_STREAM_VOLUME_ORDER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean spatializerOffload() {
        return getValue(Flags.FLAG_SPATIALIZER_OFFLOAD, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean spatializerUpmix() {
        return getValue(Flags.FLAG_SPATIALIZER_UPMIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean stereoSpatialization() {
        return getValue(Flags.FLAG_STEREO_SPATIALIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean vgsVssSyncMuteOrder() {
        return getValue(Flags.FLAG_VGS_VSS_SYNC_MUTE_ORDER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.media.audio.FeatureFlags
    public boolean volumeRefactoring() {
        return getValue(Flags.FLAG_VOLUME_REFACTORING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    public boolean isFlagReadOnlyOptimized(String flagName) {
        if (this.mReadOnlyFlagsSet.contains(flagName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isOptimizationEnabled() {
        return false;
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_ABS_VOLUME_INDEX_FIX, Flags.FLAG_ALARM_MIN_VOLUME_ZERO, Flags.FLAG_AS_DEVICE_CONNECTION_FAILURE, Flags.FLAG_AUDIO_ERASER_EFFECT, Flags.FLAG_AUDIOSERVER_PERMISSIONS, Flags.FLAG_BLUETOOTH_MAC_ADDRESS_ANONYMIZATION, Flags.FLAG_DEFER_WEAR_PERMISSION_UPDATES, Flags.FLAG_DISABLE_PRESCALE_ABSOLUTE_VOLUME, Flags.FLAG_DSA_OVER_BT_LE_AUDIO, Flags.FLAG_EQUAL_SCO_LEA_VC_INDEX_RANGE, Flags.FLAG_HARDENING_IMPL, Flags.FLAG_HARDENING_PARTIAL, Flags.FLAG_HARDENING_PARTIAL_VOLUME, Flags.FLAG_HARDENING_STRICT, Flags.FLAG_MUSIC_FX_EDGE_TO_EDGE, Flags.FLAG_OPTIMIZE_BT_DEVICE_SWITCH, Flags.FLAG_PORT_TO_PIID_SIMPLIFICATION, Flags.FLAG_REPLACE_STREAM_BT_SCO, Flags.FLAG_RING_MY_CAR, Flags.FLAG_RINGER_MODE_AFFECTS_ALARM, Flags.FLAG_SET_STREAM_VOLUME_ORDER, Flags.FLAG_SPATIALIZER_OFFLOAD, Flags.FLAG_SPATIALIZER_UPMIX, Flags.FLAG_STEREO_SPATIALIZATION, Flags.FLAG_VGS_VSS_SYNC_MUTE_ORDER, Flags.FLAG_VOLUME_REFACTORING});
    }
}

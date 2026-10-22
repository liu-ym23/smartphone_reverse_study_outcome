package com.android.media.audio;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ABS_VOLUME_INDEX_FIX = "com.android.media.audio.abs_volume_index_fix";
    public static final String FLAG_ALARM_MIN_VOLUME_ZERO = "com.android.media.audio.alarm_min_volume_zero";
    public static final String FLAG_AS_DEVICE_CONNECTION_FAILURE = "com.android.media.audio.as_device_connection_failure";
    public static final String FLAG_AUDIOSERVER_PERMISSIONS = "com.android.media.audio.audioserver_permissions";
    public static final String FLAG_AUDIO_ERASER_EFFECT = "com.android.media.audio.audio_eraser_effect";
    public static final String FLAG_BLUETOOTH_MAC_ADDRESS_ANONYMIZATION = "com.android.media.audio.bluetooth_mac_address_anonymization";
    public static final String FLAG_DEFER_WEAR_PERMISSION_UPDATES = "com.android.media.audio.defer_wear_permission_updates";
    public static final String FLAG_DISABLE_PRESCALE_ABSOLUTE_VOLUME = "com.android.media.audio.disable_prescale_absolute_volume";
    public static final String FLAG_DSA_OVER_BT_LE_AUDIO = "com.android.media.audio.dsa_over_bt_le_audio";
    public static final String FLAG_EQUAL_SCO_LEA_VC_INDEX_RANGE = "com.android.media.audio.equal_sco_lea_vc_index_range";
    public static final String FLAG_HARDENING_IMPL = "com.android.media.audio.hardening_impl";
    public static final String FLAG_HARDENING_PARTIAL = "com.android.media.audio.hardening_partial";
    public static final String FLAG_HARDENING_PARTIAL_VOLUME = "com.android.media.audio.hardening_partial_volume";
    public static final String FLAG_HARDENING_STRICT = "com.android.media.audio.hardening_strict";
    public static final String FLAG_MUSIC_FX_EDGE_TO_EDGE = "com.android.media.audio.music_fx_edge_to_edge";
    public static final String FLAG_OPTIMIZE_BT_DEVICE_SWITCH = "com.android.media.audio.optimize_bt_device_switch";
    public static final String FLAG_PORT_TO_PIID_SIMPLIFICATION = "com.android.media.audio.port_to_piid_simplification";
    public static final String FLAG_REPLACE_STREAM_BT_SCO = "com.android.media.audio.replace_stream_bt_sco";
    public static final String FLAG_RINGER_MODE_AFFECTS_ALARM = "com.android.media.audio.ringer_mode_affects_alarm";
    public static final String FLAG_RING_MY_CAR = "com.android.media.audio.ring_my_car";
    public static final String FLAG_SET_STREAM_VOLUME_ORDER = "com.android.media.audio.set_stream_volume_order";
    public static final String FLAG_SPATIALIZER_OFFLOAD = "com.android.media.audio.spatializer_offload";
    public static final String FLAG_SPATIALIZER_UPMIX = "com.android.media.audio.spatializer_upmix";
    public static final String FLAG_STEREO_SPATIALIZATION = "com.android.media.audio.stereo_spatialization";
    public static final String FLAG_VGS_VSS_SYNC_MUTE_ORDER = "com.android.media.audio.vgs_vss_sync_mute_order";
    public static final String FLAG_VOLUME_REFACTORING = "com.android.media.audio.volume_refactoring";

    public Flags() {
    }

    public static boolean absVolumeIndexFix() {
        return true;
    }

    public static boolean alarmMinVolumeZero() {
        return true;
    }

    public static boolean asDeviceConnectionFailure() {
        return false;
    }

    public static boolean audioEraserEffect() {
        return false;
    }

    public static boolean audioserverPermissions() {
        return true;
    }

    public static boolean bluetoothMacAddressAnonymization() {
        return true;
    }

    public static boolean deferWearPermissionUpdates() {
        return true;
    }

    public static boolean disablePrescaleAbsoluteVolume() {
        return true;
    }

    public static boolean dsaOverBtLeAudio() {
        return true;
    }

    public static boolean equalScoLeaVcIndexRange() {
        return true;
    }

    public static boolean hardeningImpl() {
        return true;
    }

    public static boolean hardeningPartial() {
        return false;
    }

    public static boolean hardeningPartialVolume() {
        return false;
    }

    public static boolean hardeningStrict() {
        return false;
    }

    public static boolean musicFxEdgeToEdge() {
        return true;
    }

    public static boolean optimizeBtDeviceSwitch() {
        return false;
    }

    public static boolean portToPiidSimplification() {
        return true;
    }

    public static boolean replaceStreamBtSco() {
        return true;
    }

    public static boolean ringMyCar() {
        return false;
    }

    public static boolean ringerModeAffectsAlarm() {
        return true;
    }

    public static boolean setStreamVolumeOrder() {
        return true;
    }

    public static boolean spatializerOffload() {
        return false;
    }

    public static boolean spatializerUpmix() {
        return false;
    }

    public static boolean stereoSpatialization() {
        return true;
    }

    public static boolean vgsVssSyncMuteOrder() {
        return true;
    }

    public static boolean volumeRefactoring() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

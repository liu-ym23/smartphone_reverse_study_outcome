package com.android.server.usb.flags;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ALLOW_RESTRICTION_OF_OVERLAY_ACTIVITIES = "com.android.server.usb.flags.allow_restriction_of_overlay_activities";
    public static final String FLAG_CHECK_USER_ACTION_UNLOCKED = "com.android.server.usb.flags.check_user_action_unlocked";
    public static final String FLAG_ENABLE_BIND_TO_MTP_SERVICE = "com.android.server.usb.flags.enable_bind_to_mtp_service";
    public static final String FLAG_MAXIMIZE_USB_AUDIO_VOLUME_WHEN_CONNECTING = "com.android.server.usb.flags.maximize_usb_audio_volume_when_connecting";
    public static final String FLAG_WAIT_FOR_ALSA_SCAN_RESULTS_IF_HAS_AUDIO_INTERFACE = "com.android.server.usb.flags.wait_for_alsa_scan_results_if_has_audio_interface";

    public Flags() {
    }

    public static boolean allowRestrictionOfOverlayActivities() {
        return true;
    }

    public static boolean checkUserActionUnlocked() {
        return true;
    }

    public static boolean enableBindToMtpService() {
        return true;
    }

    public static boolean maximizeUsbAudioVolumeWhenConnecting() {
        return true;
    }

    public static boolean waitForAlsaScanResultsIfHasAudioInterface() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

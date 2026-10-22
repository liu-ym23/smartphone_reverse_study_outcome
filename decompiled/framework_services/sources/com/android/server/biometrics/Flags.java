package com.android.server.biometrics;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_FACE_VHAL_FEATURE = "com.android.server.biometrics.face_vhal_feature";
    public static final String FLAG_FRR_DIALOG_IMPROVEMENT = "com.android.server.biometrics.frr_dialog_improvement";
    public static final String FLAG_NOTIFY_FINGERPRINTS_LOE = "com.android.server.biometrics.notify_fingerprints_loe";
    public static final String FLAG_SET_IGNORE_SPEED_UP = "com.android.server.biometrics.set_ignore_speed_up";
    public static final String FLAG_USE_VHAL_FOR_TESTING = "com.android.server.biometrics.use_vhal_for_testing";

    public Flags() {
    }

    public static boolean faceVhalFeature() {
        return false;
    }

    public static boolean frrDialogImprovement() {
        return false;
    }

    public static boolean notifyFingerprintsLoe() {
        return true;
    }

    public static boolean setIgnoreSpeedUp() {
        return true;
    }

    public static boolean useVhalForTesting() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

package android.mmd.flags;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_MMD_ENABLED = "android.mmd.flags.mmd_enabled";

    public Flags() {
    }

    public static boolean mmdEnabled() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

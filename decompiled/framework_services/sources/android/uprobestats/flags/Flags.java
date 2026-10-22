package android.uprobestats.flags;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ENABLE_UPROBESTATS = "android.uprobestats.flags.enable_uprobestats";
    public static final String FLAG_EXECUTABLE_METHOD_FILE_OFFSETS = "android.uprobestats.flags.executable_method_file_offsets";
    public static final String FLAG_UPROBESTATS_SUPPORT_UPDATE_DEVICE_IDLE_TEMP_ALLOWLIST = "android.uprobestats.flags.uprobestats_support_update_device_idle_temp_allowlist";

    public Flags() {
    }

    public static boolean enableUprobestats() {
        return false;
    }

    public static boolean executableMethodFileOffsets() {
        return true;
    }

    public static boolean uprobestatsSupportUpdateDeviceIdleTempAllowlist() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

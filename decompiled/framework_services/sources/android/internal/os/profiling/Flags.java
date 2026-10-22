package android.internal.os.profiling;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_PERSIST_QUEUE = "android.internal.os.profiling.persist_queue";
    public static final String FLAG_REDACTION_ENABLED = "android.internal.os.profiling.redaction_enabled";
    public static final String FLAG_SYSTEM_TRIGGERED_PROFILING_NEW = "android.internal.os.profiling.system_triggered_profiling_new";
    public static final String FLAG_TELEMETRY_APIS = "android.internal.os.profiling.telemetry_apis";

    public Flags() {
    }

    public static boolean persistQueue() {
        return FEATURE_FLAGS.persistQueue();
    }

    public static boolean redactionEnabled() {
        return true;
    }

    public static boolean systemTriggeredProfilingNew() {
        return FEATURE_FLAGS.systemTriggeredProfilingNew();
    }

    public static boolean telemetryApis() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}

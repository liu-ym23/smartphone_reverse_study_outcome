package android.internal.os.profiling;

import android.os.flagging.AconfigPackage;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    private static final String TAG = "FeatureFlagsImplExport";
    private static volatile boolean isCached;
    private static boolean persistQueue;
    private static boolean redactionEnabled;
    private static boolean systemTriggeredProfilingNew;
    private static boolean telemetryApis;

    public FeatureFlagsImpl() {
    }

    static {
        isCached = false;
        persistQueue = false;
        redactionEnabled = false;
        systemTriggeredProfilingNew = false;
        telemetryApis = false;
    }

    private void init() {
        AconfigPackage reader = AconfigPackage.load("android.os.profiling");     // Catch: LinkageError -> L5 Exception -> L7
        persistQueue = reader.getBooleanFlagValue("persist_queue", false);     // Catch: LinkageError -> L5 Exception -> L7
        redactionEnabled = true;     // Catch: LinkageError -> L5 Exception -> L7
        systemTriggeredProfilingNew = reader.getBooleanFlagValue("system_triggered_profiling_new", false);     // Catch: LinkageError -> L5 Exception -> L7
        telemetryApis = true;     // Catch: LinkageError -> L5 Exception -> L7
    L11:
        isCached = true;
        return;
    L7:
        e = move-exception;
        Log.e(TAG, e.toString());
    L5:
        e = move-exception;
        Log.w(TAG, e.toString());
        goto L11
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean persistQueue() {
        if (isCached == true) goto L6;
        init();
    L6:
        return persistQueue;
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean redactionEnabled() {
        if (isCached == true) goto L6;
        init();
    L6:
        return redactionEnabled;
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean systemTriggeredProfilingNew() {
        if (isCached == true) goto L6;
        init();
    L6:
        return systemTriggeredProfilingNew;
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean telemetryApis() {
        if (isCached == true) goto L6;
        init();
    L6:
        return telemetryApis;
    }
}

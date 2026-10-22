package com.android.server.appop;

import android.app.AppOpsManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.DeviceConfig;
import android.util.IntArray;
import android.util.Slog;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class DiscreteOpsRegistry {
    static final int[] ADDITIONAL_DISCRETE_OPS = null;
    static final boolean DEBUG_LOG = false;
    static final long DEFAULT_DISCRETE_HISTORY_CUTOFF = 0;
    static final long DEFAULT_DISCRETE_HISTORY_QUANTIZATION = 0;
    static final int[] IMPORTANT_OPS_FOR_SECURITY = null;
    private static final String LEGACY_OPS = "1,0,147,26,27,100,101,120,136,149,152,150,141";
    static final long MAXIMUM_DISCRETE_HISTORY_CUTOFF = 0;
    static final int OP_FLAGS_DISCRETE = 11;
    static final String PROPERTY_DISCRETE_FLAGS = "discrete_history_op_flags";
    static final String PROPERTY_DISCRETE_HISTORY_CUTOFF = "discrete_history_cutoff_millis";
    static final String PROPERTY_DISCRETE_HISTORY_QUANTIZATION = "discrete_history_quantization_millis";
    static final String PROPERTY_DISCRETE_OPS_LIST = "discrete_history_ops_cslist";
    private static final String TAG = null;
    static int sDiscreteFlags;
    static long sDiscreteHistoryCutoff;
    static long sDiscreteHistoryQuantization;
    static int[] sDiscreteOps;
    boolean mDebugMode;

    /* JADX INFO: renamed from: $r8$lambda$-POzhrtzjSSLkwb74LtsON-5_4M, reason: not valid java name */
    public static /* synthetic */ void m1769$r8$lambda$POzhrtzjSSLkwb74LtsON5_4M(DiscreteOpsRegistry r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$0(r1);
    }

    abstract void addFilteredDiscreteOpsToHistoricalOps(AppOpsManager.HistoricalOps r1, long r2, long r4, int r6, int r7, String r8, String[] r9, String r10, int r11, Set<String> r12);

    abstract void clearHistory();

    abstract void clearHistory(int r1, String r2);

    abstract void dump(PrintWriter r1, int r2, String r3, String r4, int r5, int r6, SimpleDateFormat r7, Date r8, String r9, int r10);

    abstract void offsetHistory(long r1);

    abstract void recordDiscreteAccess(int r1, String r2, String r3, int r4, String r5, int r6, int r7, long r8, long r10, int r12, int r13);

    abstract void writeAndClearOldAccessHistory();

    DiscreteOpsRegistry() {
        this.mDebugMode = false;
    }

    static {
        TAG = DiscreteOpsRegistry.class.getSimpleName();
        IMPORTANT_OPS_FOR_SECURITY = new int[]{2, 25, 63, 73, 88, 89, 42, 41};
        ADDITIONAL_DISCRETE_OPS = new int[]{100, 120, 136, 101, 147, 141};
        DEFAULT_DISCRETE_HISTORY_CUTOFF = Duration.ofDays(7).toMillis();
        MAXIMUM_DISCRETE_HISTORY_CUTOFF = Duration.ofDays(30).toMillis();
        DEFAULT_DISCRETE_HISTORY_QUANTIZATION = Duration.ofMinutes(1).toMillis();
        sDiscreteOps = new int[0];
    }

    void systemReady() {
        DeviceConfig.addOnPropertiesChangedListener("privacy", AsyncTask.THREAD_POOL_EXECUTOR, new DiscreteOpsRegistry$$ExternalSyntheticLambda0(this));
        setDiscreteHistoryParameters(DeviceConfig.getProperties("privacy", new String[0]));
    }

    private /* synthetic */ void lambda$systemReady$0(DeviceConfig.Properties p) {
        setDiscreteHistoryParameters(p);
    }

    void shutdown() {
    }

    void setDebugMode(boolean debugMode) {
        this.mDebugMode = debugMode;
    }

    static long discretizeTimeStamp(long timeStamp) {
        return (timeStamp / sDiscreteHistoryQuantization) * sDiscreteHistoryQuantization;
    }

    static long discretizeDuration(long duration) {
        if (duration != (-1)) goto L6;
        return -1;
    L6:
        return (((sDiscreteHistoryQuantization + duration) - 1) / sDiscreteHistoryQuantization) * sDiscreteHistoryQuantization;
    }

    static boolean isDiscreteOp(int op, int flags) {
        if (Arrays.binarySearch(sDiscreteOps, op) >= 0) goto L6;
        return false;
    L6:
        if ((sDiscreteFlags & flags) != 0) goto L8;
        return false;
    L8:
        return true;
    }

    private void setDiscreteHistoryParameters(DeviceConfig.Properties p) {
        if (p.getKeyset().contains(PROPERTY_DISCRETE_HISTORY_CUTOFF) == false) goto L9;
        sDiscreteHistoryCutoff = p.getLong(PROPERTY_DISCRETE_HISTORY_CUTOFF, DEFAULT_DISCRETE_HISTORY_CUTOFF);
        if (Build.IS_DEBUGGABLE == true) goto L11;
        if (this.mDebugMode == true) goto L11;
        sDiscreteHistoryCutoff = Long.min(MAXIMUM_DISCRETE_HISTORY_CUTOFF, sDiscreteHistoryCutoff);
    L11:
        if (p.getKeyset().contains(PROPERTY_DISCRETE_HISTORY_QUANTIZATION) == false) goto L17;
        sDiscreteHistoryQuantization = p.getLong(PROPERTY_DISCRETE_HISTORY_QUANTIZATION, DEFAULT_DISCRETE_HISTORY_QUANTIZATION);
        if (Build.IS_DEBUGGABLE == false) goto L15;
    L18:
        int r2 = 11;
        if (p.getKeyset().contains(PROPERTY_DISCRETE_FLAGS) == false) goto L22;
        r2 = p.getInt(PROPERTY_DISCRETE_FLAGS, 11);
    L22:
        sDiscreteFlags = r2;
        String opsListConfig = p.getString(PROPERTY_DISCRETE_OPS_LIST, null);
        if (opsListConfig != null) goto L25;
        int[] r1 = getDefaultOpsList();
    L26:
        sDiscreteOps = r1;
        Arrays.sort(sDiscreteOps);
        return;
    L25:
        r1 = parseOpsList(opsListConfig);
        goto L26
    L15:
        if (this.mDebugMode == true) goto L18;
        sDiscreteHistoryQuantization = Math.max(DEFAULT_DISCRETE_HISTORY_QUANTIZATION, sDiscreteHistoryQuantization);
        goto L18
    L17:
        sDiscreteHistoryQuantization = DEFAULT_DISCRETE_HISTORY_QUANTIZATION;
        goto L18
    L9:
        sDiscreteHistoryCutoff = DEFAULT_DISCRETE_HISTORY_CUTOFF;
        goto L11
    }

    private static IntArray getRuntimePermissionOps() {
        IntArray runtimeOps = new IntArray();
        int op = 0;
    L4:
        if (op >= 166) goto L10;
        if (AppOpsManager.opIsRuntimePermission(op) == false) goto L8;
        runtimeOps.add(op);
    L8:
        op = op + 1;
        goto L4
    L10:
        return runtimeOps;
    }

    private static int[] getDefaultOpsList() {
        return getDefaultLegacyOps();
    }

    private static int[] getDefaultLegacyOps() {
        return parseOpsList(LEGACY_OPS);
    }

    private static int[] parseOpsList(String opsList) {
        if (opsList.isEmpty() == false) goto L5;
        String[] strArr = new String[0];
    L6:
        int nOps = strArr.length;
        int[] result = new int[nOps];
        int i = 0;
    L7:
        if (i >= nOps) goto L14;
        result[i] = Integer.parseInt(strArr[i]);     // Catch: NumberFormatException -> L10
        i = i + 1;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to parse Discrete ops list: " + e.getMessage());
        return getDefaultOpsList();
    L14:
        return result;
    L5:
        strArr = opsList.split(",");
        goto L6
    }
}

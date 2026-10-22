package com.android.server.am.trace;

import android.os.Process;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Slog;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SmartTraceUtils {
    public static final int DUMP_MAX_COUNT = 10;
    private static final String PROP_DUMP_CMD = "sys.smtrace.cmd";
    public static final String PROP_DUMP_CMDLINES = "persist.sys.smtrace.dump.cmdlines.extra";
    public static final String PROP_ENABLE_DUMP_PREDEFINED_PIDS = "persist.sys.smtrace.dump.predefined_pids.enable";
    public static final String PROP_ENABLE_ON_BG_APP = "persist.sys.smtrace.bgapp.enable";
    public static final String PROP_ENABLE_PERFETTO_DUMP = "persist.sys.perfetto_dump.enable";
    public static final String PROP_ENABLE_PERFETTO_ON_BG_APP = "persist.sys.perfetto.bgapp.enable";
    public static final String PROP_ENABLE_RECURSIVE_MODE = "persist.sys.smtrace.recursivemode.enable";
    public static final String PROP_ENABLE_SMART_TRACE = "persist.sys.smtrace.enable";
    private static final String PROP_PERFETTO_COMMAND = "sys.perfetto.cmd";
    private static final String PROP_PERFETTO_MAX_TRACE_COUNT = "persist.sys.perfetto.max_trace_count";
    private static final String TAG = "SmartTraceUtils";
    private static final String TRACE_DIRECTORY = "/data/misc/perfetto-traces/";

    public static /* synthetic */ void $r8$lambda$F3purdbEiJj5ZMSkrHE2Iel_s8c(StringBuilder r0, Integer r1) {
        lambda$dumpStackTraces$0(r0, r1);
    }

    public SmartTraceUtils() {
    }

    public static boolean isSmartTraceEnabled() {
        return SystemProperties.getBoolean(PROP_ENABLE_SMART_TRACE, false);
    }

    public static boolean isSmartTraceEnabledOnBgApp() {
        return SystemProperties.getBoolean(PROP_ENABLE_ON_BG_APP, true);
    }

    public static boolean isDumpPredefinedPidsEnabled() {
        return SystemProperties.getBoolean(PROP_ENABLE_DUMP_PREDEFINED_PIDS, false);
    }

    public static boolean isPerfettoDumpEnabled() {
        return SystemProperties.getBoolean(PROP_ENABLE_PERFETTO_DUMP, false);
    }

    public static boolean isPerfettoDumpEnabledOnBgApp() {
        return SystemProperties.getBoolean(PROP_ENABLE_PERFETTO_ON_BG_APP, true);
    }

    public static boolean isRecursiveModeEnabled() {
        return SystemProperties.getBoolean(PROP_ENABLE_RECURSIVE_MODE, true);
    }

    public static void dumpStackTraces(int pid, ArrayList<Integer> firstPids, ArrayList<Integer> nativePids, File outputFile) {
        if (isSmartTraceEnabled() == true) goto L6;
        return;
    L6:
        if (isDumpingOn() == false) goto L9;
        Slog.e(TAG, "Attempting to run smart trace dump but trace is already in progress, skip it");
        return;
    L9:
        Set<Integer> pidSet = getTargetPidsStuckInBinder(pid, firstPids, nativePids, outputFile);
        if (pidSet != null) goto L12;
        return;
    L12:
        if (pidSet.size() == 0) goto L16;
        final StringBuilder sb = new StringBuilder();
        sb.append(pid);
        pidSet.forEach(new SmartTraceUtils$$ExternalSyntheticLambda0(sb));
        sb.append(":" + outputFile.getPath());
        SystemProperties.set(PROP_DUMP_CMD, sb.toString());
        Slog.i(TAG, "Start collect stack trace for " + sb.toString());
        return;
    }

    private static /* synthetic */ void lambda$dumpStackTraces$0(StringBuilder sb, Integer p) {
        sb.append(",");
        sb.append(p);
    }

    public static boolean traceStart() {
        if (isTracingOn() == false) goto L6;
        Slog.e(TAG, "Attempting to start perfetto trace but trace is already in progress, skip it");
        return false;
    L6:
        Slog.i(TAG, "Perfetto trace start..");
        SystemProperties.set(PROP_PERFETTO_COMMAND, "START");
        return true;
    }

    private static boolean isDumpingOn() {
        return !TextUtils.isEmpty(SystemProperties.get(PROP_DUMP_CMD, ""));
    }

    private static boolean isTracingOn() {
        return !TextUtils.isEmpty(SystemProperties.get(PROP_PERFETTO_COMMAND, ""));
    }

    private static Set<Integer> getTargetPidsStuckInBinder(int pid, ArrayList<Integer> firstPids, ArrayList<Integer> nativePids, File outputFile) {
        BinderTransactions transactions = new BinderTransactions(isRecursiveModeEnabled());
        transactions.binderStateRead(outputFile);
        Set<Integer> pidSet = transactions.getTargetPidsStuckInBinder(pid);
        pidSet.removeAll(firstPids);
        if (nativePids == null) goto L5;
        pidSet.removeAll(nativePids);
    L5:
        int[] extraPids = readExtraCmdlinesFromProperty();
        if (extraPids == null) goto L11;
        int r3 = extraPids.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L11;
        int p = extraPids[r4];
        pidSet.add(Integer.valueOf(p));
        r4 = r4 + 1;
    L11:
        return pidSet;
    }

    private static int[] readExtraCmdlinesFromProperty() {
        String cmdlines = SystemProperties.get(PROP_DUMP_CMDLINES, "");
        if (TextUtils.isEmpty(cmdlines) == false) goto L14;
        return null;
    L14:
        return Process.getPidsForCommands(cmdlines.split(","));
    L9:
        e = move-exception;
        Slog.e(TAG, "Exception get pid for commonds " + cmdlines, e);
    L13:
        return null;
    L7:
        e = move-exception;
        Slog.e(TAG, "Out of Memory when get pid for commonds " + cmdlines, e);
        goto L13
    }
}

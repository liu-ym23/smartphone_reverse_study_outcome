package com.android.server.am;

import android.os.Build;
import android.os.Debug;
import android.os.FileUtils;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.os.ProcessCpuTracker;
import com.android.internal.os.anr.AnrLatencyTracker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class StackTracesDumpHelper {
    private static final SimpleDateFormat ANR_FILE_DATE_FORMAT = null;
    static final String ANR_FILE_PREFIX = "anr_";
    public static final String ANR_TRACE_DIR = "/data/anr";
    private static final int JAVA_DUMP_MINIMUM_SIZE = 100;
    private static final int NATIVE_DUMP_TIMEOUT_MS = 0;
    static final String TAG = "ActivityManager";

    public static /* synthetic */ ArrayList $r8$lambda$2_q5NUHgU36R91F13viImtf0R_c(ProcessCpuTracker r0, SparseBooleanArray r1, AnrLatencyTracker r2) {
        return lambda$dumpStackTraces$0(r0, r1, r2);
    }

    public StackTracesDumpHelper() {
    }

    static {
        ANR_FILE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        NATIVE_DUMP_TIMEOUT_MS = Build.HW_TIMEOUT_MULTIPLIER * 3000;
    }

    public static File dumpStackTraces(ArrayList<Integer> firstPids, ProcessCpuTracker processCpuTracker, SparseBooleanArray lastPids, Future<ArrayList<Integer>> nativePidsFuture, StringWriter logExceptionCreatingFile, Executor auxiliaryTaskExecutor, AnrLatencyTracker latencyTracker) {
        return dumpStackTraces(firstPids, processCpuTracker, lastPids, nativePidsFuture, logExceptionCreatingFile, null, null, null, null, auxiliaryTaskExecutor, latencyTracker);
    }

    public static File dumpStackTraces(ArrayList<Integer> firstPids, ProcessCpuTracker processCpuTracker, SparseBooleanArray lastPids, Future<ArrayList<Integer>> nativePidsFuture, StringWriter logExceptionCreatingFile, String subject, String criticalEventSection, LinkedHashMap<String, String> extraHeaders, Executor auxiliaryTaskExecutor, AnrLatencyTracker latencyTracker) {
        return dumpStackTraces(firstPids, processCpuTracker, lastPids, nativePidsFuture, logExceptionCreatingFile, null, subject, criticalEventSection, extraHeaders, auxiliaryTaskExecutor, latencyTracker);
    }

    static File dumpStackTraces(ArrayList<Integer> firstPids, final ProcessCpuTracker processCpuTracker, final SparseBooleanArray lastPids, Future<ArrayList<Integer>> nativePidsFuture, StringWriter logExceptionCreatingFile, AtomicLong firstPidEndOffset, String subject, String criticalEventSection, LinkedHashMap<String, String> extraHeaders, Executor auxiliaryTaskExecutor, final AnrLatencyTracker latencyTracker) {
        if (latencyTracker != null) goto L73;
    L7:
        Slog.i(TAG, "dumpStackTraces pids=" + lastPids);     // Catch: Throwable -> L5
        if (processCpuTracker == null) goto L11;
        Supplier<ArrayList<Integer>> r0 = new StackTracesDumpHelper$$ExternalSyntheticLambda1(processCpuTracker, lastPids, latencyTracker);     // Catch: Throwable -> L5
    L12:
        Supplier<ArrayList<Integer>> extraPidsSupplier = r0;
        if (extraPidsSupplier != null) goto L75;
        Future<ArrayList<Integer>> extraPidsFuture = null;
    L19:
        File tracesDir = new File(ANR_TRACE_DIR);     // Catch: Throwable -> L16
        File tracesFile = createAnrDumpFile(tracesDir);     // Catch: Throwable -> L16 IOException -> L58
        if (extraHeaders != null) goto L24;
    L26:
        boolean extraHeadersExist = false;
    L28:
        if (subject != null) goto L33;
        if (criticalEventSection != null) goto L33;
        if (extraHeadersExist == true) goto L33;
        tracesFile = tracesFile;
    L46:
        long firstPidEndPos = dumpStackTraces(tracesFile.getAbsolutePath(), firstPids, nativePidsFuture, extraPidsFuture, latencyTracker);     // Catch: Throwable -> L51
        if (firstPidEndOffset == null) goto L54;
        firstPidEndOffset.set(firstPidEndPos);     // Catch: Throwable -> L51
    L54:
        maybePruneOldTraces(tracesDir);     // Catch: Throwable -> L51
        if (latencyTracker == null) goto L57;
        latencyTracker.dumpStackTracesEnded();
    L57:
        return tracesFile;
    L16:
        e = th;
    L69:
        if (latencyTracker == null) goto L71;
        latencyTracker.dumpStackTracesEnded();
    L71:
        throw e;
    L33:
        String r8 = tracesFile.getAbsolutePath();     // Catch: Throwable -> L16
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L16
        String r14 = "";
        if (subject == null) goto L37;
        String r1 = "Subject: " + subject + "\n";     // Catch: Throwable -> L16
    L38:
        r13.append(r1);     // Catch: Throwable -> L16
        if (extraHeadersExist == false) goto L41;
        String r2 = stringifyHeaders(extraHeaders) + "\n\n";     // Catch: Throwable -> L16
    L42:
        r13.append(r2);     // Catch: Throwable -> L16
        if (criticalEventSection == null) goto L45;
        r14 = criticalEventSection;
    L45:
        r13.append(r14);     // Catch: Throwable -> L16
        appendtoANRFile(r8, r13.toString());     // Catch: Throwable -> L16
        goto L46
    L41:
        r2 = "";
        goto L42
    L37:
        r1 = "";
        goto L38
    L24:
        if (extraHeaders.isEmpty() == true) goto L26;
        extraHeadersExist = true;
        goto L28
    L51:
        e = th;
    L58:
        e = move-exception;
        Slog.w(TAG, "Exception creating ANR dump file:", e);     // Catch: Throwable -> L51
        if (logExceptionCreatingFile == null) goto L63;
        logExceptionCreatingFile.append("----- Exception creating ANR dump file -----\n");     // Catch: Throwable -> L51
        e.printStackTrace(new PrintWriter(logExceptionCreatingFile));     // Catch: Throwable -> L51
    L63:
        if (latencyTracker == null) goto L66;
        latencyTracker.anrSkippedDumpStackTraces();     // Catch: Throwable -> L51
    L66:
        if (latencyTracker == null) goto L68;
        latencyTracker.dumpStackTracesEnded();
    L68:
        return null;
    L75:
        extraPidsFuture = CompletableFuture.supplyAsync(extraPidsSupplier, auxiliaryTaskExecutor);     // Catch: Throwable -> L16
    L5:
        e = th;
        goto L69
    L11:
        r0 = null;
        goto L12
    L73:
        latencyTracker.dumpStackTracesStarted();     // Catch: Throwable -> L5
        goto L7
    }

    private static /* synthetic */ ArrayList lambda$dumpStackTraces$0(ProcessCpuTracker processCpuTracker, SparseBooleanArray lastPids, AnrLatencyTracker latencyTracker) {
        return getExtraPids(processCpuTracker, lastPids, latencyTracker);
    }

    public static long dumpStackTraces(String tracesFile, ArrayList<Integer> firstPids, Future<ArrayList<Integer>> nativePidsFuture, Future<ArrayList<Integer>> extraPidsFuture, AnrLatencyTracker latencyTracker) {
        Slog.i(TAG, "Dumping to " + tracesFile);
        long remainingTime = (long) (Build.HW_TIMEOUT_MULTIPLIER * 20000);
        long firstPidEnd = -1;
        if (firstPids == null) goto L31;
        if (latencyTracker == null) goto L6;
        latencyTracker.dumpingFirstPidsStarted();
    L6:
        int num = firstPids.size();
        int i = 0;
    L7:
        if (i >= num) goto L27;
        int pid = firstPids.get(i).intValue();
        if (i == 0) goto L11;
    L13:
        boolean firstPid = false;
    L14:
        int num2 = num;
        StringBuilder r0 = new StringBuilder();
        long firstPidEnd2 = firstPidEnd;
        r0.append("Collecting stacks for pid ");
        r0.append(pid);
        Slog.i(TAG, r0.toString());
        long timeTaken = dumpJavaTracesTombstoned(pid, tracesFile, remainingTime, latencyTracker);
        long remainingTime2 = remainingTime - timeTaken;
        if (remainingTime2 <= 0) goto L16;
        if (firstPid == false) goto L23;
        firstPidEnd2 = new File(tracesFile).length();
        if (latencyTracker == null) goto L23;
        appendtoANRFile(tracesFile, latencyTracker.dumpAsCommaSeparatedArrayWithHeader());
    L23:
        if (ActivityManagerDebugConfig.DEBUG_ANR == false) goto L26;
        Slog.d(TAG, "Done with pid " + firstPids.get(i) + " in " + timeTaken + "ms");
    L26:
        i = i + 1;
        num = num2;
        firstPidEnd = firstPidEnd2;
        remainingTime = remainingTime2;
        goto L7
    L16:
        Slog.e(TAG, "Aborting stack trace dump (current firstPid=" + pid + "); deadline exceeded.");
        return firstPidEnd2;
    L11:
        if (ActivityManagerService.MY_PID == pid) goto L13;
        firstPid = true;
        goto L14
    L27:
        long firstPidEnd3 = firstPidEnd;
        long r17 = 0;
        if (latencyTracker == null) goto L30;
        latencyTracker.dumpingFirstPidsEnded();
    L30:
        firstPidEnd = firstPidEnd3;
    L32:
        ArrayList<Integer> nativePids = collectPids(nativePidsFuture, "native pids");
        Slog.i(TAG, "dumpStackTraces nativepids=" + nativePids);
        if (nativePids == null) goto L57;
        if (latencyTracker == null) goto L36;
        latencyTracker.dumpingNativePidsStarted();
    L36:
        Iterator<Integer> r1 = nativePids.iterator();
    L38:
        if (r1.hasNext() == false) goto L53;
        int pid2 = r1.next().intValue();
        Iterator<Integer> r16 = r1;
        Slog.i(TAG, "Collecting stacks for native pid " + pid2);
        long firstPidEnd4 = firstPidEnd;
        long nativeDumpTimeoutMs = Math.min((long) NATIVE_DUMP_TIMEOUT_MS, remainingTime);
        if (latencyTracker == null) goto L42;
        latencyTracker.dumpingPidStarted(pid2);
    L42:
        long start = SystemClock.elapsedRealtime();
        long remainingTime3 = remainingTime;
        Debug.dumpNativeBacktraceToFileTimeout(pid2, tracesFile, (int) (nativeDumpTimeoutMs / 1000));
        long timeTaken2 = SystemClock.elapsedRealtime() - start;
        if (latencyTracker == null) goto L45;
        latencyTracker.dumpingPidEnded();
    L45:
        long remainingTime4 = remainingTime3 - timeTaken2;
        if (remainingTime4 <= r17) goto L47;
        if (ActivityManagerDebugConfig.DEBUG_ANR == false) goto L52;
        Slog.d(TAG, "Done with native pid " + pid2 + " in " + timeTaken2 + "ms");
    L52:
        r1 = r16;
        firstPidEnd = firstPidEnd4;
        remainingTime = remainingTime4;
        goto L38
    L47:
        Slog.e(TAG, "Aborting stack trace dump (current native pid=" + pid2 + "); deadline exceeded.");
        return firstPidEnd4;
    L53:
        long remainingTime5 = remainingTime;
        long firstPidEnd5 = firstPidEnd;
        if (latencyTracker == null) goto L56;
        latencyTracker.dumpingNativePidsEnded();
    L56:
        remainingTime = remainingTime5;
    L58:
        ArrayList<Integer> extraPids = collectPids(extraPidsFuture, "extra pids");
        if (extraPidsFuture != null) goto L91;
    L69:
        Slog.i(TAG, "dumpStackTraces extraPids=" + extraPids);
        if (extraPids == null) goto L89;
        if (latencyTracker == null) goto L73;
        latencyTracker.dumpingExtraPidsStarted();
    L73:
        Iterator<Integer> r2 = extraPids.iterator();
    L75:
        if (r2.hasNext() == false) goto L86;
        int pid3 = r2.next().intValue();
        Slog.i(TAG, "Collecting stacks for extra pid " + pid3);
        ArrayList<Integer> extraPids2 = extraPids;
        long timeTaken3 = dumpJavaTracesTombstoned(pid3, tracesFile, remainingTime, latencyTracker);
        remainingTime = remainingTime - timeTaken3;
        if (remainingTime <= r17) goto L78;
        if (ActivityManagerDebugConfig.DEBUG_ANR == false) goto L84;
        Slog.d(TAG, "Done with extra pid " + pid3 + " in " + timeTaken3 + "ms");
    L84:
        extraPids = extraPids2;
        r2 = r2;
        goto L75
    L78:
        Slog.e(TAG, "Aborting stack trace dump (current extra pid=" + pid3 + "); deadline exceeded.");
        return firstPidEnd5;
    L86:
        if (latencyTracker == null) goto L89;
        latencyTracker.dumpingExtraPidsEnded();
    L89:
        appendtoANRFile(tracesFile, "----- dumping ended at " + SystemClock.uptimeMillis() + "\n");
        Slog.i(TAG, "Done dumping");
        return firstPidEnd5;
    L91:
        extraPids = extraPidsFuture.get();     // Catch: InterruptedException -> L63 ExecutionException -> L65
        goto L69
    L63:
        e = move-exception;
        Slog.w(TAG, "Interrupted while collecting extra pids", e);
    L65:
        e = move-exception;
        Slog.w(TAG, "Failed to collect extra pids", e.getCause());
        goto L69
    L57:
        firstPidEnd5 = firstPidEnd;
        goto L58
    L31:
        r17 = 0;
        goto L32
    }

    private static synchronized File createAnrDumpFile(File tracesDir) throws IOException {
        monitor-enter(StackTracesDumpHelper.class);
        String formattedDate = ANR_FILE_DATE_FORMAT.format(new Date());     // Catch: Throwable -> L9
        File anrFile = new File(tracesDir, ANR_FILE_PREFIX + formattedDate);     // Catch: Throwable -> L9
        if (anrFile.createNewFile() == false) goto L12;
        FileUtils.setPermissions(anrFile.getAbsolutePath(), 420, -1, -1);     // Catch: Throwable -> L9
        monitor-exit(StackTracesDumpHelper.class);
        return anrFile;
    L12:
        throw new IOException("Unable to create ANR dump file: createNewFile failed");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static ArrayList<Integer> getExtraPids(ProcessCpuTracker processCpuTracker, SparseBooleanArray lastPids, AnrLatencyTracker latencyTracker) {
        if (latencyTracker == null) goto L4;
        latencyTracker.processCpuTrackerMethodsCalled();
    L4:
        ArrayList<Integer> extraPids = new ArrayList();
        monitor-enter(processCpuTracker);
        processCpuTracker.init();     // Catch: Throwable -> L33
        monitor-exit(processCpuTracker);     // Catch: Throwable -> L33
        Thread.sleep(200);     // Catch: InterruptedException -> L11
    L12:
        monitor-enter(processCpuTracker);
        processCpuTracker.update();     // Catch: Throwable -> L22
        int workingStatsNumber = processCpuTracker.countWorkingStats();     // Catch: Throwable -> L22
        int i = 0;
    L14:
        if (i >= workingStatsNumber) goto L27;
        if (extraPids.size() >= 2) goto L27;
        ProcessCpuTracker.Stats stats = processCpuTracker.getWorkingStats(i);     // Catch: Throwable -> L22
        if (lastPids.indexOfKey(stats.pid) >= 0) goto L20;
        Slog.i(TAG, "Skipping next CPU consuming process, not a java proc: " + stats.pid);     // Catch: Throwable -> L22
    L26:
        i = i + 1;     // Catch: Throwable -> L22
        goto L14
    L20:
        if (ActivityManagerDebugConfig.DEBUG_ANR == false) goto L24;
        Slog.d(TAG, "Collecting stacks for extra pid " + stats.pid);     // Catch: Throwable -> L22
    L24:
        extraPids.add(Integer.valueOf(stats.pid));     // Catch: Throwable -> L22
    L27:
        monitor-exit(processCpuTracker);     // Catch: Throwable -> L22
        if (latencyTracker == null) goto L30;
        latencyTracker.processCpuTrackerMethodsReturned();
    L30:
        return extraPids;
    L22:
        th = move-exception;
        throw th;
    L33:
        th = move-exception;
        throw th;
    }

    private static void maybePruneOldTraces(File tracesDir) {
        File[] files = tracesDir.listFiles();
        if (files != null) goto L5;
        return;
    L5:
        int max = SystemProperties.getInt("tombstoned.max_anr_count", 64);
        long now = System.currentTimeMillis();
        Arrays.sort(files, Comparator.comparingLong(new StackTracesDumpHelper$$ExternalSyntheticLambda0()).reversed());     // Catch: IllegalArgumentException -> L13
        int i = 0;
    L7:
        if (i >= files.length) goto L28;
        if (i > max) goto L16;
        if ((now - files[i].lastModified()) > 86400000) goto L16;
    L18:
        i = i + 1;
    L16:
        if (files[i].delete() == true) goto L18;
        Slog.w(TAG, "Unable to prune stale trace file: " + files[i]);     // Catch: IllegalArgumentException -> L13
        goto L18
    L28:
        return;
    L13:
        e = move-exception;
        Slog.w(TAG, "tombstone modification times changed while sorting; not pruning", e);
    }

    private static long dumpJavaTracesTombstoned(int pid, String fileName, long timeoutMs, AnrLatencyTracker latencyTracker) {
        if (latencyTracker != null) goto L13;
    L6:
        long r0 = dumpJavaTracesTombstoned(pid, fileName, timeoutMs);     // Catch: Throwable -> L4
        if (latencyTracker == null) goto L9;
        latencyTracker.dumpingPidEnded();
    L9:
        return r0;
    L4:
        th = move-exception;
        if (latencyTracker == null) goto L12;
        latencyTracker.dumpingPidEnded();
    L12:
        throw th;
    L13:
        latencyTracker.dumpingPidStarted(pid);     // Catch: Throwable -> L4
        goto L6
    }

    private static long dumpJavaTracesTombstoned(int pid, String fileName, long timeoutMs) {
        long timeStart = SystemClock.elapsedRealtime();
        int headerSize = writeUptimeStartHeaderForPid(pid, fileName);
        boolean javaSuccess = Debug.dumpJavaBacktraceToFileTimeout(pid, fileName, (int) (timeoutMs / 1000));
        if (javaSuccess == false) goto L13;
        long size = new File(fileName).length();     // Catch: Exception -> L8
        if ((size - ((long) headerSize)) >= 100) goto L13;
        Slog.w(TAG, "Successfully created Java ANR file is empty!");     // Catch: Exception -> L8
        javaSuccess = false;
    L8:
        e = move-exception;
        Slog.w(TAG, "Unable to get ANR file size", e);
        javaSuccess = false;
    L13:
        if (shouldTriggerNativeFallback(javaSuccess) == false) goto L25;
        Slog.w(TAG, "Dumping Java threads failed, initiating native stack dump.");
        boolean nativeSuccess = Debug.dumpNativeBacktraceToFileTimeout(pid, fileName, NATIVE_DUMP_TIMEOUT_MS / 1000);
        if (shouldSendMainThreadSignalFallback(nativeSuccess) == false) goto L25;
        if (pid == Process.myPid()) goto L25;
        Process.sendSigToTid(pid, pid, 55);     // Catch: Exception -> L21
        Slog.w(TAG, "Native stack dump failed, fallback to sendSigToTid for pid " + pid);     // Catch: Exception -> L21
    L23:
        Slog.w(TAG, "Native stack dump failed!");
    L21:
        e = move-exception;
        Slog.w(TAG, "Native stack dump failed, sendSigToTid fallback also failed for pid " + pid, e);
    L25:
        return SystemClock.elapsedRealtime() - timeStart;
    }

    static boolean shouldTriggerNativeFallback(boolean javaSuccess) {
        return !javaSuccess;
    }

    static boolean shouldSendMainThreadSignalFallback(boolean nativeSuccess) {
        return !nativeSuccess;
    }

    private static int appendtoANRFile(String fileName, String text) {
        FileOutputStream fos = new FileOutputStream(fileName, true);     // Catch: IOException -> L6
        byte[] header = text.getBytes(StandardCharsets.UTF_8);     // Catch: Throwable -> L8
        fos.write(header);     // Catch: Throwable -> L8
        int r2 = header.length;     // Catch: Throwable -> L8
        fos.close();     // Catch: IOException -> L6
        return r2;
    L8:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: IOException -> L6
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        Slog.w(TAG, "Exception writing to ANR dump file:", e);
        return 0;
    }

    private static int writeUptimeStartHeaderForPid(int pid, String fileName) {
        return appendtoANRFile(fileName, "----- dumping pid: " + pid + " at " + SystemClock.uptimeMillis() + "\n");
    }

    private static ArrayList<Integer> collectPids(Future<ArrayList<Integer>> pidsFuture, String logName) {
        if (pidsFuture != null) goto L15;
        return null;
    L15:
        ArrayList<Integer> pids = pidsFuture.get();     // Catch: InterruptedException -> L8 ExecutionException -> L10
    L17:
        return pids;
    L8:
        e = move-exception;
        Slog.w(TAG, "Interrupted while collecting " + logName, e);
        return null;
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to collect " + logName, e.getCause());
        return null;
    }

    private static String stringifyHeaders(LinkedHashMap<String, String> headers) {
        StringBuilder headersString = new StringBuilder();
        Iterator<Map.Entry<String, String>> r1 = headers.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, String> entry = r1.next();
        headersString.append(entry.getKey());
        headersString.append(": ");
        headersString.append(entry.getValue());
        headersString.append("\n");
        goto L4
    L7:
        return headersString.toString();
    }
}

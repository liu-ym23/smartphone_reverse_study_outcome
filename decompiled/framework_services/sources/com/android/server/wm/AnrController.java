package com.android.server.wm;

import android.app.ActivityManagerInternal;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.StabTrace;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputApplicationHandle;
import com.android.internal.os.TimeoutRecord;
import com.android.server.FgThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.am.FreezeErrorData;
import com.android.server.am.StackTracesDumpHelper;
import com.android.server.criticalevents.CriticalEventLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class AnrController {
    private static final long PRE_DUMP_MIN_INTERVAL_MS = 0;
    private static final long PRE_DUMP_MONITOR_TIMEOUT_MS = 0;
    private boolean mDisablePreDump;
    private volatile long mLastPreDumpTimeMs;
    private final WindowManagerService mService;
    private final SparseArray<ActivityRecord> mUnresponsiveAppByDisplay;

    /* JADX INFO: renamed from: $r8$lambda$8q4-0vxIBkii72YOst4vidozj0Y, reason: not valid java name */
    public static /* synthetic */ void m9702$r8$lambda$8q40vxIBkii72YOst4vidozj0Y(AnrController r0, ActivityRecord r1, WindowState r2, String r3) {
        r0.lambda$dumpAnrStateAsync$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPRE_DUMP_MONITOR_TIMEOUT_MS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9703$$Nest$sfgetPRE_DUMP_MONITOR_TIMEOUT_MS() {
        return PRE_DUMP_MONITOR_TIMEOUT_MS;
    }

    static {
        PRE_DUMP_MIN_INTERVAL_MS = TimeUnit.SECONDS.toMillis(20);
        PRE_DUMP_MONITOR_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(1);
    }

    AnrController(WindowManagerService service) {
        this.mUnresponsiveAppByDisplay = new SparseArray();
        this.mService = service;
        this.mDisablePreDump = SystemProperties.getBoolean("persist.sys.predump.disab", true);
    }

    void notifyAppUnresponsive(InputApplicationHandle applicationHandle, TimeoutRecord timeoutRecord) {
        timeoutRecord.mLatencyTracker.notifyAppUnresponsiveStarted();     // Catch: Throwable -> L6
        timeoutRecord.mLatencyTracker.preDumpIfLockTooSlowStarted();     // Catch: Throwable -> L6
        preDumpIfLockTooSlow();     // Catch: Throwable -> L6
        timeoutRecord.mLatencyTracker.preDumpIfLockTooSlowEnded();     // Catch: Throwable -> L6
        timeoutRecord.mLatencyTracker.waitingOnGlobalLockStarted();     // Catch: Throwable -> L6
        long beginTime = 0;
        if (StabTrace.isEnable() == false) goto L8;
        beginTime = Process.getCpuClocks();     // Catch: Throwable -> L6
    L8:
        WindowManagerGlobalLock r9 = this.mService.mGlobalLock;     // Catch: Throwable -> L6
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L6
        monitor-enter(r9);     // Catch: Throwable -> L6
        timeoutRecord.mLatencyTracker.waitingOnGlobalLockEnded();     // Catch: Throwable -> L16
        ActivityRecord activity = ActivityRecord.forTokenLocked(applicationHandle.token);     // Catch: Throwable -> L16
        if (activity != null) goto L19;
        Slog.e("WindowManager", "Unknown app appToken:" + applicationHandle.name + ". Dropping notifyNoFocusedWindowAnr request");     // Catch: Throwable -> L16
        monitor-exit(r9);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        timeoutRecord.mLatencyTracker.notifyAppUnresponsiveEnded();
        return;
    L19:
        if (activity.mAppStopped == false) goto L25;
        Slog.d("WindowManager", "App is in stopped state:" + applicationHandle.name + ". Dropping notifyNoFocusedWindowAnr request");     // Catch: Throwable -> L16
        monitor-exit(r9);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        timeoutRecord.mLatencyTracker.notifyAppUnresponsiveEnded();
        return;
    L25:
        if (activity.isState(ActivityRecord.State.STOPPED, ActivityRecord.State.STOPPING) == false) goto L31;
        Slog.i("WindowManager", "App is in stopped state:" + applicationHandle.name + ". Dropping notifyNoFocusedWindowAnr request...");     // Catch: Throwable -> L16
        monitor-exit(r9);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        timeoutRecord.mLatencyTracker.notifyAppUnresponsiveEnded();
        return;
    L31:
        if (activity.mTaskSupervisor.mStoppingActivities.contains(activity) == false) goto L36;
        Slog.i("WindowManager", "App will be in stopped state:" + applicationHandle.name + ". Dropping notifyNoFocusedWindowAnr reques");     // Catch: Throwable -> L16
        monitor-exit(r9);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        timeoutRecord.mLatencyTracker.notifyAppUnresponsiveEnded();
        return;
    L36:
        DisplayContent display = this.mService.mRoot.getDisplayContent(activity.getDisplayId());     // Catch: Throwable -> L16
        if (display == null) goto L40;
        IBinder focusToken = display.getInputMonitor().mInputFocus;     // Catch: Throwable -> L16
    L78:
        InputTarget focusTarget = this.mService.getInputTargetFromToken(focusToken);     // Catch: Throwable -> L49
        if (focusTarget == null) goto L51;
        WindowState targetWindowState = focusTarget.getWindowState();     // Catch: Throwable -> L49
        if ((SystemClock.uptimeMillis() - display.getInputMonitor().mInputFocusRequestTimeMillis) < ActivityTaskManagerService.getInputDispatchingTimeoutMillisLocked(targetWindowState.getActivityRecord())) goto L47;
        boolean blamePendingFocusRequest = true;
    L48:
        WindowState targetWindowState2 = targetWindowState;
    L52:
        if (blamePendingFocusRequest == false) goto L75;
    L56:
        monitor-exit(r9);     // Catch: Throwable -> L54
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L6
        SysOptBridge.getFactory().getApplicationFreezer().checkProcessFreezeState(new FreezeErrorData(FreezeErrorData.ErrorType.INPUT_ANR, activity.getUid(), activity.getPid(), activity.getProcessName(), "ANR in " + activity.getName() + ".  Reason: " + timeoutRecord.mReason));     // Catch: Throwable -> L6
        if (StabTrace.isEnable() == false) goto L61;
        if (blamePendingFocusRequest == true) goto L61;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L6
        long currentTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L6
        String formattedDate = sdf.format(new Date(currentTimeMillis));     // Catch: Throwable -> L6
        StringBuilder sb = new StringBuilder(250);     // Catch: Throwable -> L6
        sb.append(formattedDate);     // Catch: Throwable -> L6
        sb.append(" notifyAppUnresponsive ");     // Catch: Throwable -> L6
        sb.append(activity.getProcessName());     // Catch: Throwable -> L6
        sb.append(" pid=");     // Catch: Throwable -> L6
        sb.append(activity.getPid());     // Catch: Throwable -> L6
        sb.append(" occur ANR ");     // Catch: Throwable -> L6
        StabTrace.traceInfo(1, sb.toString(), beginTime, Process.getCpuClocks());     // Catch: Throwable -> L6
    L61:
        if (blamePendingFocusRequest == true) goto L63;
    L65:
        activity.inputDispatchingTimedOut(timeoutRecord, -1);     // Catch: Throwable -> L6
    L66:
        if (blamePendingFocusRequest == true) goto L68;
        dumpAnrStateAsync(activity, null, timeoutRecord.mReason);     // Catch: Throwable -> L6
    L68:
        timeoutRecord.mLatencyTracker.notifyAppUnresponsiveEnded();
        return;
    L63:
        if (notifyWindowUnresponsive(focusToken, timeoutRecord) == false) goto L65;
        Slog.i("WindowManager", "Blamed " + targetWindowState2.getName() + " using pending focus request. Focused activity: " + activity.getName());     // Catch: Throwable -> L6
    L54:
        th = th;
    L70:
        monitor-exit(r9);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L75:
        Slog.i("WindowManager", "ANR in " + activity.getName() + ".  Reason: " + timeoutRecord.mReason);     // Catch: Throwable -> L54
        this.mUnresponsiveAppByDisplay.put(activity.getDisplayId(), activity);     // Catch: Throwable -> L54
        goto L56
    L47:
        blamePendingFocusRequest = false;
        goto L48
    L51:
        blamePendingFocusRequest = false;
        targetWindowState2 = null;
    L49:
        th = th;
        goto L70
    L40:
        focusToken = null;
    L16:
        th = th;
    L6:
        th = move-exception;
        timeoutRecord.mLatencyTracker.notifyAppUnresponsiveEnded();
        throw th;
    }

    void notifyWindowUnresponsive(IBinder token, OptionalInt pid, TimeoutRecord timeoutRecord) {
        timeoutRecord.mLatencyTracker.notifyWindowUnresponsiveStarted();     // Catch: Throwable -> L11
        if (notifyWindowUnresponsive(token, timeoutRecord) == false) goto L7;
        timeoutRecord.mLatencyTracker.notifyWindowUnresponsiveEnded();
        return;
    L7:
        if (pid.isPresent() == true) goto L15;
        Slog.w("WindowManager", "Failed to notify that window token=" + token + " was unresponsive.");     // Catch: Throwable -> L11
        timeoutRecord.mLatencyTracker.notifyWindowUnresponsiveEnded();
        return;
    L15:
        if (StabTrace.isEnable() == false) goto L17;
        long beginTime = Process.getCpuClocks();     // Catch: Throwable -> L11
        long beginTime2 = beginTime;
    L18:
        notifyWindowUnresponsive(pid.getAsInt(), timeoutRecord);     // Catch: Throwable -> L11
        if (StabTrace.isEnable() == false) goto L21;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L11
        long currentTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L11
        String formattedDate = sdf.format(new Date(currentTimeMillis));     // Catch: Throwable -> L11
        StringBuilder sb = new StringBuilder(250);     // Catch: Throwable -> L11
        sb.append(formattedDate);     // Catch: Throwable -> L11
        sb.append(" notifyWindowUnresponsive ");     // Catch: Throwable -> L11
        sb.append(" pid=");     // Catch: Throwable -> L11
        sb.append(pid.getAsInt());     // Catch: Throwable -> L11
        sb.append(" occur ANR ");     // Catch: Throwable -> L11
        StabTrace.traceInfo(1, sb.toString(), beginTime2, Process.getCpuClocks());     // Catch: Throwable -> L11
    L21:
        timeoutRecord.mLatencyTracker.notifyWindowUnresponsiveEnded();
        return;
    L17:
        beginTime2 = 0;
    L11:
        th = move-exception;
        timeoutRecord.mLatencyTracker.notifyWindowUnresponsiveEnded();
        throw th;
    }

    private boolean notifyWindowUnresponsive(IBinder inputToken, TimeoutRecord timeoutRecord) {
        timeoutRecord.mLatencyTracker.preDumpIfLockTooSlowStarted();
        preDumpIfLockTooSlow();
        timeoutRecord.mLatencyTracker.preDumpIfLockTooSlowEnded();
        if (StabTrace.isEnable() == false) goto L5;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L6:
        timeoutRecord.mLatencyTracker.waitingOnGlobalLockStarted();
        WindowManagerGlobalLock r4 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        timeoutRecord.mLatencyTracker.waitingOnGlobalLockEnded();     // Catch: Throwable -> L13
        InputTarget target = this.mService.getInputTargetFromToken(inputToken);     // Catch: Throwable -> L13
        if (target != null) goto L15;
        monitor-exit(r4);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L15:
        WindowState windowState = target.getWindowState();     // Catch: Throwable -> L13
        int pid = target.getPid();     // Catch: Throwable -> L13
        if (windowState.mInputChannelToken != inputToken) goto L18;
        ActivityRecord r6 = windowState.mActivityRecord;     // Catch: Throwable -> L13
    L19:
        ActivityRecord activity = r6;
        Slog.i("WindowManager", "ANR in " + target + ". Reason:" + timeoutRecord.mReason);     // Catch: Throwable -> L13
        boolean aboveSystem = isWindowAboveSystem(windowState);     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        if (StabTrace.isEnable() == false) goto L28;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long currentTimeMillis = System.currentTimeMillis();
        String formattedDate = sdf.format(new Date(currentTimeMillis));
        StringBuilder sb = new StringBuilder(250);
        sb.append(formattedDate);
        sb.append(" notifyWindowUnresponsive ");
        if (activity == null) goto L26;
        String r11 = activity.getProcessName();
    L27:
        sb.append(r11);
        sb.append(" pid=");
        sb.append(pid);
        sb.append(" occur ANR ");
        StabTrace.traceInfo(1, sb.toString(), beginTime2, Process.getCpuClocks());
        goto L28
    L26:
        r11 = "unkown";
    L28:
        if (activity == null) goto L30;
        activity.inputDispatchingTimedOut(timeoutRecord, pid);
    L31:
        dumpAnrStateAsync(activity, windowState, timeoutRecord.mReason);
        return true;
    L30:
        this.mService.mAmInternal.inputDispatchingTimedOut(pid, aboveSystem, timeoutRecord);
        goto L31
    L18:
        r6 = null;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        beginTime2 = 0;
        goto L6
    }

    private void notifyWindowUnresponsive(int pid, TimeoutRecord timeoutRecord) {
        Slog.i("WindowManager", "ANR in input window owned by pid=" + pid + ". Reason: " + timeoutRecord.mReason);
        this.mService.mAmInternal.inputDispatchingTimedOut(pid, true, timeoutRecord);
        dumpAnrStateAsync(null, null, timeoutRecord.mReason);
    }

    void notifyWindowResponsive(IBinder token, OptionalInt pid) {
        if (notifyWindowResponsive(token) == false) goto L6;
        return;
    L6:
        if (pid.isPresent() == true) goto L9;
        Slog.w("WindowManager", "Failed to notify that window token=" + token + " was responsive.");
        return;
    L9:
        notifyWindowResponsive(pid.getAsInt());
    }

    private boolean notifyWindowResponsive(IBinder inputToken) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        InputTarget target = this.mService.getInputTargetFromToken(inputToken);     // Catch: Throwable -> L9
        if (target != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L11:
        int pid = target.getPid();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mService.mAmInternal.inputDispatchingResumed(pid);
        return true;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void notifyWindowResponsive(int pid) {
        this.mService.mAmInternal.inputDispatchingResumed(pid);
    }

    void onFocusChanged(WindowState newFocus) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord unresponsiveApp = this.mUnresponsiveAppByDisplay.get(newFocus.getDisplayId());     // Catch: Throwable -> L12
        if (unresponsiveApp == null) goto L14;
        if (unresponsiveApp != newFocus.mActivityRecord) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mService.mAmInternal.inputDispatchingResumed(unresponsiveApp.getPid());
        this.mUnresponsiveAppByDisplay.remove(newFocus.getDisplayId());
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void preDumpIfLockTooSlow() {
        int r8 = 0;
        if (Build.IS_DEBUGGABLE == true) goto L5;
        return;
    L5:
        if (this.mDisablePreDump == true) goto L50;
        final long now = SystemClock.uptimeMillis();
        if (this.mLastPreDumpTimeMs > 0) goto L10;
    L12:
        Trace.traceBegin(64, "preDumpIfLockTooSlow()");
        final boolean[] shouldDumpSf = {true};     // Catch: Throwable -> L18
        ArrayMap<String, Runnable> monitors = new ArrayMap(2);     // Catch: Throwable -> L18
        final WindowManagerService r0 = this.mService;     // Catch: Throwable -> L18
        r0.getClass();     // Catch: Throwable -> L18
        monitors.put("WindowManager", new AnrController$$ExternalSyntheticLambda1(r0));     // Catch: Throwable -> L18
        final ActivityManagerInternal r2 = this.mService.mAmInternal;     // Catch: Throwable -> L18
        r2.getClass();     // Catch: Throwable -> L18
        monitors.put("ActivityManager", new AnrController$$ExternalSyntheticLambda2(r2));     // Catch: Throwable -> L18
        final CountDownLatch latch = new CountDownLatch(monitors.size());     // Catch: Throwable -> L18
        int i = 0;
    L15:
        if (i >= monitors.size()) goto L47;
        final String name = monitors.keyAt(i);     // Catch: Throwable -> L18
        final Runnable monitor = monitors.valueAt(i);     // Catch: Throwable -> L18
        new AnonymousClass1(this, monitor, latch, now, name, shouldDumpSf).start();     // Catch: Throwable -> L18
        i = i + 1;
        goto L15
    L47:
        if (latch.await(PRE_DUMP_MONITOR_TIMEOUT_MS, TimeUnit.MILLISECONDS) == false) goto L28;
        Trace.traceEnd(64);
        return;
    L28:
        this.mLastPreDumpTimeMs = now;     // Catch: Throwable -> L18
        Slog.i("WindowManager", "Pre-dump for unresponsive");     // Catch: Throwable -> L18
        ArrayList<Integer> firstPids = new ArrayList(1);     // Catch: Throwable -> L18
        firstPids.add(Integer.valueOf(WindowManagerService.MY_PID));     // Catch: Throwable -> L18
        ArrayList<Integer> nativePids = null;
        if (shouldDumpSf[0] == false) goto L31;
        int[] pids = Process.getPidsForCommands(new String[]{"/system/bin/surfaceflinger"});     // Catch: Throwable -> L18
    L33:
        if (pids == null) goto L37;
        nativePids = new ArrayList(1);     // Catch: Throwable -> L18
        int r6 = pids.length;     // Catch: Throwable -> L18
    L35:
        if (r8 >= r6) goto L37;
        int pid = pids[r8];     // Catch: Throwable -> L18
        nativePids.add(Integer.valueOf(pid));     // Catch: Throwable -> L18
        r8 = r8 + 1;     // Catch: Throwable -> L18
    L37:
        String criticalEvents = CriticalEventLog.getInstance().logLinesForSystemServerTraceFile();     // Catch: Throwable -> L18
        File tracesFile = StackTracesDumpHelper.dumpStackTraces(firstPids, null, null, CompletableFuture.completedFuture(nativePids), null, "Pre-dump", criticalEvents, null, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), null);     // Catch: Throwable -> L18
        if (tracesFile == null) goto L40;
        tracesFile.renameTo(new File(tracesFile.getParent(), tracesFile.getName() + "_pre"));     // Catch: Throwable -> L18
    L40:
        Trace.traceEnd(64);
        return;
    L31:
        pids = null;
    L18:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    L10:
        if ((now - this.mLastPreDumpTimeMs) >= PRE_DUMP_MIN_INTERVAL_MS) goto L12;
        return;
    }

    private void dumpAnrStateAsync(final ActivityRecord activity, final WindowState windowState, final String reason) {
        FgThread.getExecutor().execute(new AnrController$$ExternalSyntheticLambda0(this, activity, windowState, reason));
    }

    private /* synthetic */ void lambda$dumpAnrStateAsync$0(ActivityRecord activity, WindowState windowState, String reason) {
        Trace.traceBegin(64, "dumpAnrStateLocked()");     // Catch: Throwable -> L10
        WindowManagerGlobalLock r2 = this.mService.mGlobalLock;     // Catch: Throwable -> L10
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        this.mService.saveANRStateLocked(activity, windowState, reason);     // Catch: Throwable -> L12
        this.mService.mAtmService.saveANRState(activity, reason);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Trace.traceEnd(64);
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    private boolean isWindowAboveSystem(WindowState windowState) {
        int systemAlertLayer = this.mService.mPolicy.getWindowLayerFromTypeLw(2038, windowState.mOwnerCanAddInternalSystemWindow);
        if (windowState.mBaseLayer <= systemAlertLayer) goto L5;
        return true;
    L5:
        return false;
    }
}

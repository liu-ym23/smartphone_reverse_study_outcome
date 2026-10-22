package com.android.server.vibrator;

import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.os.Trace;
import android.os.WorkSource;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
final class VibrationThread extends Thread {
    static final boolean DEBUG = false;
    static final String TAG = "VibrationThread";
    private boolean mCalledVibrationCompleteCallback;
    private VibrationStepConductor mExecutingConductor;
    private final Object mLock;
    private VibrationStepConductor mRequestedActiveConductor;
    private final VibratorManagerHooks mVibratorManagerHooks;
    private final PowerManager.WakeLock mWakeLock;

    interface VibratorManagerHooks {
        void cancelSyncedVibration();

        void noteVibratorOff(int r1);

        void noteVibratorOn(int r1, long r2);

        void onVibrationThreadReleased(long r1);

        boolean prepareSyncedVibration(long r1, int[] r3);

        boolean triggerSyncedVibration(long r1);
    }

    static {
        DEBUG = VibratorDebugUtils.isDebuggable(TAG);
    }

    VibrationThread(PowerManager.WakeLock wakeLock, VibratorManagerHooks vibratorManagerHooks) {
        this.mLock = new Object();
        this.mCalledVibrationCompleteCallback = false;
        this.mWakeLock = wakeLock;
        this.mVibratorManagerHooks = vibratorManagerHooks;
    }

    boolean runVibrationOnVibrationThread(VibrationStepConductor conductor) {
        Trace.traceBegin(8388608, "runVibrationOnVibrationThread");
        Object r0 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r0);     // Catch: Throwable -> L19
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.mRequestedActiveConductor == null) goto L13;
        Slog.wtf(TAG, "Attempt to start vibration when one already running");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Trace.traceEnd(8388608);
        return false;
    L13:
        this.mRequestedActiveConductor = conductor;     // Catch: Throwable -> L11
        this.mLock.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Trace.traceEnd(8388608);
        return true;
    L19:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(-8);
    L3:
        VibrationStepConductor r0 = waitForVibrationRequest();
        r0.getClass();
        this.mExecutingConductor = r0;
        this.mCalledVibrationCompleteCallback = false;
        runCurrentVibrationWithWakeLock();
        if (this.mExecutingConductor.isFinished() == true) goto L6;
        Slog.wtf(TAG, "VibrationThread terminated with unfinished vibration");
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mRequestedActiveConductor = null;     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        this.mVibratorManagerHooks.onVibrationThreadReleased(this.mExecutingConductor.getVibration().id);
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mLock.notifyAll();     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        this.mExecutingConductor = null;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    }

    public boolean waitForThreadIdle(long maxWaitMillis) {
        long now = SystemClock.elapsedRealtime();
        long deadline = now + maxWaitMillis;
        Object r4 = this.mLock;
        monitor-enter(r4);
    L23:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRequestedActiveConductor == null) goto L6;
        if (now >= deadline) goto L13;
        this.mLock.wait(deadline - now);     // Catch: Throwable -> L9 InterruptedException -> L18
    L20:
        now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L19:
        Slog.w(TAG, "VibrationThread interrupted waiting to stop, continuing");     // Catch: Throwable -> L9
        goto L20
    L13:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return false;
    L6:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return true;
    }

    private VibrationStepConductor waitForVibrationRequest() {
    L2:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRequestedActiveConductor != null) goto L6;
        this.mLock.wait();     // Catch: Throwable -> L9 InterruptedException -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        goto L2
    L14:
        Slog.w(TAG, "VibrationThread interrupted waiting to start, continuing");     // Catch: Throwable -> L9
        goto L15
    L6:
        VibrationStepConductor r1 = this.mRequestedActiveConductor;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    boolean isRunningVibrationId(long id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRequestedActiveConductor != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mRequestedActiveConductor.getVibration().id != id) goto L11;
        r1 = true;
        goto L12
    }

    private void runCurrentVibrationWithWakeLock() {
        WorkSource workSource = new WorkSource(this.mExecutingConductor.getVibration().callerInfo.uid);
        this.mWakeLock.setWorkSource(workSource);
        this.mWakeLock.acquire();
        playVibration();     // Catch: Throwable -> L9
        clientVibrationCompleteIfNotAlready(new Vibration.EndInfo(VibrationSession.Status.FINISHED_UNEXPECTED));     // Catch: Throwable -> L7
        this.mWakeLock.release();
        this.mWakeLock.setWorkSource(null);
        return;
    L7:
        th = move-exception;
        this.mWakeLock.release();
        this.mWakeLock.setWorkSource(null);
        throw th;
    L9:
        th = move-exception;
        clientVibrationCompleteIfNotAlready(new Vibration.EndInfo(VibrationSession.Status.FINISHED_UNEXPECTED));     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    }

    private void clientVibrationCompleteIfNotAlready(Vibration.EndInfo vibrationEndInfo) {
        if (this.mCalledVibrationCompleteCallback == true) goto L10;
        this.mCalledVibrationCompleteCallback = true;
        Trace.traceBegin(8388608, "notifyVibrationComplete");
        this.mExecutingConductor.notifyVibrationComplete(vibrationEndInfo);     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return;
    L7:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    private void playVibration() {
        Trace.traceBegin(8388608, "playVibration");
    L8:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    L4:
        if (this.mExecutingConductor.prepareToStart() == true) goto L11;
        clientVibrationCompleteIfNotAlready(new Vibration.EndInfo(VibrationSession.Status.IGNORED_UNSUPPORTED));     // Catch: Throwable -> L8
        Trace.traceEnd(8388608);
        return;
    L11:
        if (this.mExecutingConductor.isFinished() == true) goto L21;
        boolean readyToRun = this.mExecutingConductor.waitUntilNextStepIsDue();     // Catch: Throwable -> L8
        if (readyToRun == false) goto L16;
        this.mExecutingConductor.runNextStep();     // Catch: Throwable -> L8
    L16:
        if (this.mCalledVibrationCompleteCallback == true) goto L11;
        Vibration.EndInfo vibrationEndInfo = this.mExecutingConductor.calculateVibrationEndInfo();     // Catch: Throwable -> L8
        if (vibrationEndInfo == null) goto L11;
        clientVibrationCompleteIfNotAlready(vibrationEndInfo);     // Catch: Throwable -> L8
        goto L11
    L21:
        Trace.traceEnd(8388608);
    }
}

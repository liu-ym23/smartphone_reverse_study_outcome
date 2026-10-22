package com.android.server.timedetector;

import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.server.AlarmManagerInternal;
import com.android.server.LocalServices;
import com.android.server.SystemClockTime;
import java.time.Duration;
import java.time.Instant;

/* JADX INFO: loaded from: classes3.dex */
final class EnvironmentImpl implements TimeDetectorStrategyImpl.Environment {
    private static final String LOG_TAG = "time_detector";
    private final AlarmManagerInternal mAlarmManagerInternal;
    private final Handler mHandler;
    private final PowerManager.WakeLock mWakeLock;

    EnvironmentImpl(Context context, Handler handler) {
        handler.getClass();
        this.mHandler = handler;
        PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
        PowerManager.WakeLock r1 = powerManager.newWakeLock(1, LOG_TAG);
        r1.getClass();
        this.mWakeLock = r1;
        AlarmManagerInternal r2 = (AlarmManagerInternal) LocalServices.getService(AlarmManagerInternal.class);
        r2.getClass();
        this.mAlarmManagerInternal = r2;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public void acquireWakeLock() {
        if (this.mWakeLock.isHeld() == false) goto L5;
        Slog.wtf(LOG_TAG, "WakeLock " + this.mWakeLock + " already held");
    L5:
        this.mWakeLock.acquire();
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public long elapsedRealtimeMillis() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public long systemClockMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public int systemClockConfidence() {
        return SystemClockTime.getTimeConfidence();
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public void setSystemClock(long newTimeMillis, int confidence, String logMsg) {
        checkWakeLockHeld();
        this.mAlarmManagerInternal.setTime(newTimeMillis, confidence, logMsg);
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public void setSystemClockConfidence(int confidence, String logMsg) {
        checkWakeLockHeld();
        SystemClockTime.setConfidence(confidence, logMsg);
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public void releaseWakeLock() {
        checkWakeLockHeld();
        this.mWakeLock.release();
    }

    private void checkWakeLockHeld() {
        if (this.mWakeLock.isHeld() == true) goto L6;
        Slog.wtf(LOG_TAG, "WakeLock " + this.mWakeLock + " not held");
        return;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public void addDebugLogEntry(String logMsg) {
        SystemClockTime.addDebugLogEntry(logMsg);
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public void dumpDebugLog(IndentingPrintWriter pw) {
        long elapsedRealtimeMillis = elapsedRealtimeMillis();
        pw.printf("elapsedRealtimeMillis()=%s (%s)\n", new Object[]{Duration.ofMillis(elapsedRealtimeMillis), Long.valueOf(elapsedRealtimeMillis)});
        long systemClockMillis = systemClockMillis();
        pw.printf("systemClockMillis()=%s (%s)\n", new Object[]{Instant.ofEpochMilli(systemClockMillis), Long.valueOf(systemClockMillis)});
        pw.println("systemClockConfidence()=" + systemClockConfidence());
        pw.println("SystemClockTime debug log:");
        pw.increaseIndent();
        SystemClockTime.dump(pw);
        pw.decreaseIndent();
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategyImpl.Environment
    public void runAsync(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}

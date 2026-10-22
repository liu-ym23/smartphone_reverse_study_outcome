package com.android.server.power.batterysaver;

import android.os.BatteryManagerInternal;
import android.os.SystemClock;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class BatterySavingStats {
    private static final boolean DEBUG = true;
    private static final int STATE_NOT_INITIALIZED = -1;
    private static final String TAG = "BatterySavingStats";
    private int mAdaptiveBatterySaverEnabledCount;
    private BatteryManagerInternal mBatteryManagerInternal;
    private int mBatterySaverEnabledCount;
    private int mCurrentState;
    private long mLastAdaptiveBatterySaverDisabledTime;
    private long mLastAdaptiveBatterySaverEnabledTime;
    private long mLastBatterySaverDisabledTime;
    private long mLastBatterySaverEnabledTime;
    private final Object mLock;
    final SparseArray<Stat> mStats;

    interface BatterySaverState {
        public static final int ADAPTIVE = 2;
        public static final int BITS = 2;
        public static final int MASK = 3;
        public static final int OFF = 0;
        public static final int ON = 1;
        public static final int SHIFT = 0;

        static int fromIndex(int index) {
            return (index >> 0) & 3;
        }
    }

    interface DozeState {
        public static final int BITS = 2;
        public static final int DEEP = 2;
        public static final int LIGHT = 1;
        public static final int MASK = 3;
        public static final int NOT_DOZING = 0;
        public static final int SHIFT = 3;

        static int fromIndex(int index) {
            return (index >> 3) & 3;
        }
    }

    interface InteractiveState {
        public static final int BITS = 1;
        public static final int INTERACTIVE = 1;
        public static final int MASK = 1;
        public static final int NON_INTERACTIVE = 0;
        public static final int SHIFT = 2;

        static int fromIndex(int index) {
            return (index >> 2) & 1;
        }
    }

    interface PlugState {
        public static final int BITS = 1;
        public static final int MASK = 1;
        public static final int PLUGGED = 1;
        public static final int SHIFT = 5;
        public static final int UNPLUGGED = 0;

        static int fromIndex(int index) {
            return (index >> 5) & 1;
        }
    }

    static class Stat {
        public int endBatteryLevel;
        public int endBatteryPercent;
        public long endTime;
        public int startBatteryLevel;
        public int startBatteryPercent;
        public long startTime;
        public int totalBatteryDrain;
        public int totalBatteryDrainPercent;
        public long totalTimeMillis;

        Stat() {
        }

        public long totalMinutes() {
            return this.totalTimeMillis / 60000;
        }

        public double drainPerHour() {
            if (this.totalTimeMillis != 0) goto L7;
            return 0.0d;
        L7:
            return ((double) this.totalBatteryDrain) / (this.totalTimeMillis / 3600000.0d);
        }

        public double drainPercentPerHour() {
            if (this.totalTimeMillis != 0) goto L7;
            return 0.0d;
        L7:
            return ((double) this.totalBatteryDrainPercent) / (this.totalTimeMillis / 3600000.0d);
        }

        String toStringForTest() {
            return "{" + totalMinutes() + "m," + this.totalBatteryDrain + "," + String.format("%.2f", new Object[]{Double.valueOf(drainPerHour())}) + "uA/H," + String.format("%.2f", new Object[]{Double.valueOf(drainPercentPerHour())}) + "%}";
        }
    }

    public BatterySavingStats(Object lock) {
        this.mCurrentState = -1;
        this.mStats = new SparseArray();
        this.mBatterySaverEnabledCount = 0;
        this.mLastBatterySaverEnabledTime = 0;
        this.mLastBatterySaverDisabledTime = 0;
        this.mAdaptiveBatterySaverEnabledCount = 0;
        this.mLastAdaptiveBatterySaverEnabledTime = 0;
        this.mLastAdaptiveBatterySaverDisabledTime = 0;
        this.mLock = lock;
        this.mBatteryManagerInternal = (BatteryManagerInternal) LocalServices.getService(BatteryManagerInternal.class);
    }

    private BatteryManagerInternal getBatteryManagerInternal() {
        if (this.mBatteryManagerInternal != null) goto L8;
        this.mBatteryManagerInternal = (BatteryManagerInternal) LocalServices.getService(BatteryManagerInternal.class);
        if (this.mBatteryManagerInternal != null) goto L8;
        Slog.wtf(TAG, "BatteryManagerInternal not initialized");
    L8:
        return this.mBatteryManagerInternal;
    }

    static int statesToIndex(int batterySaverState, int interactiveState, int dozeState, int plugState) {
        int ret = batterySaverState & 3;
        return ((ret | ((interactiveState & 1) << 2)) | ((dozeState & 3) << 3)) | ((plugState & 1) << 5);
    }

    static String stateToString(int state) {
        switch(state) {
            case -1: goto L5;
            default: goto L4;
        };
    L5:
        return "NotInitialized";
    L4:
        return "BS=" + BatterySaverState.fromIndex(state) + ",I=" + InteractiveState.fromIndex(state) + ",D=" + DozeState.fromIndex(state) + ",P=" + PlugState.fromIndex(state);
    }

    Stat getStat(int stateIndex) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Stat stat = this.mStats.get(stateIndex);     // Catch: Throwable -> L7
        if (stat != null) goto L9;
        stat = new Stat();     // Catch: Throwable -> L7
        this.mStats.put(stateIndex, stat);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return stat;
    L7:
        th = move-exception;
        throw th;
    }

    private Stat getStat(int batterySaverState, int interactiveState, int dozeState, int plugState) {
        return getStat(statesToIndex(batterySaverState, interactiveState, dozeState, plugState));
    }

    long injectCurrentTime() {
        return SystemClock.elapsedRealtime();
    }

    int injectBatteryLevel() {
        BatteryManagerInternal bmi = getBatteryManagerInternal();
        if (bmi != null) goto L7;
        return 0;
    L7:
        return bmi.getBatteryChargeCounter();
    }

    int injectBatteryPercent() {
        BatteryManagerInternal bmi = getBatteryManagerInternal();
        if (bmi != null) goto L7;
        return 0;
    L7:
        return bmi.getBatteryLevel();
    }

    void transitionState(int batterySaverState, int interactiveState, int dozeState, int plugState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int newState = statesToIndex(batterySaverState, interactiveState, dozeState, plugState);     // Catch: Throwable -> L7
        transitionStateLocked(newState);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void transitionStateLocked(int newState) {
        if (this.mCurrentState != newState) goto L5;
        return;
    L5:
        long now = injectCurrentTime();
        int batteryLevel = injectBatteryLevel();
        int batteryPercent = injectBatteryPercent();
        int r1 = 0;
        if (this.mCurrentState >= 0) goto L8;
        int oldBatterySaverState = 0;
    L9:
        if (newState < 0) goto L12;
        r1 = BatterySaverState.fromIndex(newState);
    L12:
        int newBatterySaverState = r1;
        if (oldBatterySaverState != newBatterySaverState) goto L15;
    L26:
        endLastStateLocked(now, batteryLevel, batteryPercent);
        startNewStateLocked(newState, now, batteryLevel, batteryPercent);
        return;
    L15:
        switch(newBatterySaverState) {
            case 0: goto L23;
            case 1: goto L20;
            case 2: goto L17;
            default: goto L26;
        };
    L17:
        this.mAdaptiveBatterySaverEnabledCount++;
        this.mLastAdaptiveBatterySaverEnabledTime = now;
        if (oldBatterySaverState != 1) goto L26;
        this.mLastBatterySaverDisabledTime = now;
        goto L26
    L20:
        this.mBatterySaverEnabledCount++;
        this.mLastBatterySaverEnabledTime = now;
        if (oldBatterySaverState != 2) goto L26;
        this.mLastAdaptiveBatterySaverDisabledTime = now;
        goto L26
    L23:
        if (oldBatterySaverState != 1) goto L25;
        this.mLastBatterySaverDisabledTime = now;
        goto L26
    L25:
        this.mLastAdaptiveBatterySaverDisabledTime = now;
        goto L26
    L8:
        oldBatterySaverState = BatterySaverState.fromIndex(this.mCurrentState);
        goto L9
    }

    private void endLastStateLocked(long now, int batteryLevel, int batteryPercent) {
        if (this.mCurrentState >= 0) goto L5;
        return;
    L5:
        Stat stat = getStat(this.mCurrentState);
        stat.endBatteryLevel = batteryLevel;
        stat.endBatteryPercent = batteryPercent;
        stat.endTime = now;
        long deltaTime = stat.endTime - stat.startTime;
        int deltaDrain = stat.startBatteryLevel - stat.endBatteryLevel;
        int deltaPercent = stat.startBatteryPercent - stat.endBatteryPercent;
        stat.totalTimeMillis += deltaTime;
        stat.totalBatteryDrain += deltaDrain;
        stat.totalBatteryDrainPercent += deltaPercent;
        Slog.d(TAG, "State summary: " + stateToString(this.mCurrentState) + ": " + (deltaTime / 1000) + "s Start level: " + stat.startBatteryLevel + "uA End level: " + stat.endBatteryLevel + "uA Start percent: " + stat.startBatteryPercent + "% End percent: " + stat.endBatteryPercent + "% Drain " + deltaDrain + "uA");
        EventLogTags.writeBatterySavingStats(BatterySaverState.fromIndex(this.mCurrentState), InteractiveState.fromIndex(this.mCurrentState), DozeState.fromIndex(this.mCurrentState), deltaTime, deltaDrain, deltaPercent, stat.totalTimeMillis, stat.totalBatteryDrain, stat.totalBatteryDrainPercent);
    }

    private void startNewStateLocked(int newState, long now, int batteryLevel, int batteryPercent) {
        Slog.d(TAG, "New state: " + stateToString(newState));
        this.mCurrentState = newState;
        if (this.mCurrentState >= 0) goto L5;
        return;
    L5:
        Stat stat = getStat(this.mCurrentState);
        stat.startBatteryLevel = batteryLevel;
        stat.startBatteryPercent = batteryPercent;
        stat.startTime = now;
        stat.endTime = 0;
    }

    public void dump(IndentingPrintWriter pw) {
        pw.println("Battery saving stats:");
        pw.increaseIndent();
        Object r7 = this.mLock;
        monitor-enter(r7);
        long now = System.currentTimeMillis();     // Catch: Throwable -> L8
        long nowElapsed = injectCurrentTime();     // Catch: Throwable -> L8
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L8
        pw.print("Battery Saver is currently: ");     // Catch: Throwable -> L8
        switch(BatterySaverState.fromIndex(this.mCurrentState)) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L7;
            default: goto L12;
        };     // Catch: Throwable -> L8
    L7:
        pw.println("ADAPTIVE");     // Catch: Throwable -> L8
        goto L12
    L10:
        pw.println("ON");     // Catch: Throwable -> L8
        goto L12
    L11:
        pw.println("OFF");     // Catch: Throwable -> L8
    L12:
        pw.increaseIndent();     // Catch: Throwable -> L8
        if (this.mLastBatterySaverEnabledTime <= 0) goto L16;
        pw.print("Last ON time: ");     // Catch: Throwable -> L8
        pw.print(sdf.format(new Date((now - nowElapsed) + this.mLastBatterySaverEnabledTime)));     // Catch: Throwable -> L8
        pw.print(" ");     // Catch: Throwable -> L8
        TimeUtils.formatDuration(this.mLastBatterySaverEnabledTime, nowElapsed, pw);     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
    L16:
        if (this.mLastBatterySaverDisabledTime <= 0) goto L18;
        pw.print("Last OFF time: ");     // Catch: Throwable -> L8
        pw.print(sdf.format(new Date((now - nowElapsed) + this.mLastBatterySaverDisabledTime)));     // Catch: Throwable -> L8
        pw.print(" ");     // Catch: Throwable -> L8
        TimeUtils.formatDuration(this.mLastBatterySaverDisabledTime, nowElapsed, pw);     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
    L18:
        pw.print("Times full enabled: ");     // Catch: Throwable -> L8
        pw.println(this.mBatterySaverEnabledCount);     // Catch: Throwable -> L8
        if (this.mLastAdaptiveBatterySaverEnabledTime <= 0) goto L22;
        pw.print("Last ADAPTIVE ON time: ");     // Catch: Throwable -> L8
        pw.print(sdf.format(new Date((now - nowElapsed) + this.mLastAdaptiveBatterySaverEnabledTime)));     // Catch: Throwable -> L8
        pw.print(" ");     // Catch: Throwable -> L8
        TimeUtils.formatDuration(this.mLastAdaptiveBatterySaverEnabledTime, nowElapsed, pw);     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
    L22:
        if (this.mLastAdaptiveBatterySaverDisabledTime <= 0) goto L24;
        pw.print("Last ADAPTIVE OFF time: ");     // Catch: Throwable -> L8
        pw.print(sdf.format(new Date((now - nowElapsed) + this.mLastAdaptiveBatterySaverDisabledTime)));     // Catch: Throwable -> L8
        pw.print(" ");     // Catch: Throwable -> L8
        TimeUtils.formatDuration(this.mLastAdaptiveBatterySaverDisabledTime, nowElapsed, pw);     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
    L24:
        pw.print("Times adaptive enabled: ");     // Catch: Throwable -> L8
        pw.println(this.mAdaptiveBatterySaverEnabledCount);     // Catch: Throwable -> L8
        pw.decreaseIndent();     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
        pw.println("Drain stats:");     // Catch: Throwable -> L8
        pw.println("                   Battery saver OFF                          ON");     // Catch: Throwable -> L8
        dumpLineLocked(pw, 0, "NonIntr", 0, "NonDoze");     // Catch: Throwable -> L8
        dumpLineLocked(pw, 1, "   Intr", 0, "       ");     // Catch: Throwable -> L8
        dumpLineLocked(pw, 0, "NonIntr", 2, "Deep   ");     // Catch: Throwable -> L8
        dumpLineLocked(pw, 1, "   Intr", 2, "       ");     // Catch: Throwable -> L8
        dumpLineLocked(pw, 0, "NonIntr", 1, "Light  ");     // Catch: Throwable -> L8
        dumpLineLocked(pw, 1, "   Intr", 1, "       ");     // Catch: Throwable -> L8
        monitor-exit(r7);     // Catch: Throwable -> L8
        pw.decreaseIndent();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void dumpLineLocked(IndentingPrintWriter pw, int interactiveState, String interactiveLabel, int dozeState, String dozeLabel) {
        pw.print(dozeLabel);
        pw.print(" ");
        pw.print(interactiveLabel);
        pw.print(": ");
        Stat offStat = getStat(0, interactiveState, dozeState, 0);
        Stat onStat = getStat(1, interactiveState, dozeState, 0);
        pw.println(String.format("%6dm %6dmAh(%3d%%) %8.1fmAh/h     %6dm %6dmAh(%3d%%) %8.1fmAh/h", new Object[]{Long.valueOf(offStat.totalMinutes()), Integer.valueOf(offStat.totalBatteryDrain / 1000), Integer.valueOf(offStat.totalBatteryDrainPercent), Double.valueOf(offStat.drainPerHour() / 1000.0d), Long.valueOf(onStat.totalMinutes()), Integer.valueOf(onStat.totalBatteryDrain / 1000), Integer.valueOf(onStat.totalBatteryDrainPercent), Double.valueOf(onStat.drainPerHour() / 1000.0d)}));
    }
}

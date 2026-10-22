package com.android.server.job.controllers.idle;

import android.R;
import android.app.AlarmManager;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.provider.DeviceConfig;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.HostingRecord;
import com.android.server.job.JobSchedulerService;
import java.io.PrintWriter;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceIdlenessTracker extends BroadcastReceiver implements IdlenessTracker {
    private static final boolean DEBUG = false;
    private static final String IC_DIT_CONSTANT_PREFIX = "ic_dit_";
    private static final String KEY_IDLE_WINDOW_SLOP_MS = "ic_dit_idle_window_slop_ms";
    static final String KEY_INACTIVITY_IDLE_THRESHOLD_MS = "ic_dit_inactivity_idle_threshold_ms";
    static final String KEY_INACTIVITY_STABLE_POWER_IDLE_THRESHOLD_MS = "ic_dit_inactivity_idle_stable_power_threshold_ms";
    private static final String TAG = "JobScheduler.DeviceIdlenessTracker";
    private AlarmManager mAlarm;
    private boolean mDockIdle;
    private boolean mIdle;
    private AlarmManager.OnAlarmListener mIdleAlarmListener;
    private IdlenessListener mIdleListener;
    private long mIdleStartElapsed;
    private long mIdleWindowSlop;
    private long mIdlenessCheckScheduledElapsed;
    private long mInactivityIdleThreshold;
    private long mInactivityStablePowerIdleThreshold;
    private boolean mIsStablePower;
    private final UiModeManager.OnProjectionStateChangedListener mOnProjectionStateChangedListener;
    private PowerManager mPowerManager;
    private boolean mProjectionActive;
    private boolean mScreenOn;

    /* JADX INFO: renamed from: $r8$lambda$Qbs8rP1wYv-82O2aKiZ7U8AYc2s, reason: not valid java name */
    public static /* synthetic */ void m5093$r8$lambda$Qbs8rP1wYv82O2aKiZ7U8AYc2s(DeviceIdlenessTracker r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$iCTrxU5c_OgpA1h-eZcNPXa6EJk, reason: not valid java name */
    public static /* synthetic */ void m5094$r8$lambda$iCTrxU5c_OgpA1heZcNPXa6EJk(DeviceIdlenessTracker r0, int r1, Set r2) {
        r0.onProjectionStateChanged(r1, r2);
    }

    static {
        if (JobSchedulerService.DEBUG == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG = r0;
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    private /* synthetic */ void lambda$new$0() {
        handleIdleTrigger();
    }

    public DeviceIdlenessTracker() {
        this.mIdlenessCheckScheduledElapsed = -1;
        this.mIdleStartElapsed = Long.MAX_VALUE;
        this.mOnProjectionStateChangedListener = new DeviceIdlenessTracker$$ExternalSyntheticLambda0(this);
        this.mIdleAlarmListener = new DeviceIdlenessTracker$$ExternalSyntheticLambda1(this);
        this.mScreenOn = true;
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public boolean isIdle() {
        return this.mIdle;
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void startTracking(Context context, JobSchedulerService service, IdlenessListener listener) {
        this.mIdleListener = listener;
        this.mInactivityIdleThreshold = context.getResources().getInteger(R.integer.config_letterboxDefaultPositionForVerticalReachability);
        this.mInactivityStablePowerIdleThreshold = context.getResources().getInteger(R.integer.config_lidKeyboardAccessibility);
        this.mIdleWindowSlop = context.getResources().getInteger(R.integer.config_letterboxDefaultPositionForTabletopModeReachability);
        this.mAlarm = (AlarmManager) context.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.DREAMING_STARTED");
        filter.addAction("android.intent.action.DREAMING_STOPPED");
        filter.addAction(ActivityManagerService.ACTION_TRIGGER_IDLE);
        filter.addAction("android.intent.action.DOCK_IDLE");
        filter.addAction("android.intent.action.DOCK_ACTIVE");
        context.registerReceiver(this, filter, null, AppSchedulingModuleThread.getHandler());
        ((UiModeManager) context.getSystemService(UiModeManager.class)).addOnProjectionStateChangedListener(-1, AppSchedulingModuleThread.getExecutor(), this.mOnProjectionStateChangedListener);
        if (service.isBatteryCharging() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.mIsStablePower = r1;
        return;
    L5:
        if (service.isBatteryNotLow() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void processConstant(DeviceConfig.Properties properties, String key) {
        switch(key.hashCode()) {
            case -365017934: goto L12;
            case -165204881: goto L9;
            case 500388387: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L16:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            default: goto L24;
        };
    L18:
        this.mIdleWindowSlop = Math.max(60000, Math.min(HeartbeatStats.MAX_NAT_TIME_MS, properties.getLong(key, this.mIdleWindowSlop)));
        return;
    L19:
        this.mInactivityStablePowerIdleThreshold = Math.max(60000, Math.min(14400000, properties.getLong(key, this.mInactivityStablePowerIdleThreshold)));
        return;
    L20:
        this.mInactivityIdleThreshold = Math.max(60000, Math.min(14400000, properties.getLong(key, this.mInactivityIdleThreshold)));
        return;
    L24:
        return;
    L6:
        if (key.equals(KEY_INACTIVITY_STABLE_POWER_IDLE_THRESHOLD_MS) == false) goto L14;
        r0 = 1;
        goto L16
    L9:
        if (key.equals(KEY_INACTIVITY_IDLE_THRESHOLD_MS) == false) goto L14;
        r0 = 0;
        goto L16
    L12:
        if (key.equals(KEY_IDLE_WINDOW_SLOP_MS) == false) goto L14;
        r0 = 2;
        goto L16
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void onBatteryStateChanged(boolean isCharging, boolean isBatteryNotLow) {
        if (isCharging == false) goto L5;
        if (isBatteryNotLow == false) goto L5;
        boolean isStablePower = true;
    L7:
        if (this.mIsStablePower == isStablePower) goto L10;
        this.mIsStablePower = isStablePower;
        maybeScheduleIdlenessCheck("stable power changed");
        return;
    L10:
        return;
    L5:
        isStablePower = false;
        goto L7
    }

    private void onProjectionStateChanged(int activeProjectionTypes, Set<String> projectingPackages) {
        if (activeProjectionTypes == 0) goto L4;
        boolean projectionActive = true;
    L6:
        if (this.mProjectionActive != projectionActive) goto L9;
        return;
    L9:
        if (DEBUG == false) goto L11;
        Slog.v(TAG, "Projection state changed: " + projectionActive);
    L11:
        this.mProjectionActive = projectionActive;
        if (this.mProjectionActive == false) goto L14;
        exitIdle();
        return;
    L14:
        maybeScheduleIdlenessCheck("Projection ended");
        return;
    L4:
        projectionActive = false;
        goto L6
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void dump(PrintWriter pw) {
        pw.print("  mIdle: ");
        pw.println(this.mIdle);
        pw.print("  mScreenOn: ");
        pw.println(this.mScreenOn);
        pw.print("  mIsStablePower: ");
        pw.println(this.mIsStablePower);
        pw.print("  mDockIdle: ");
        pw.println(this.mDockIdle);
        pw.print("  mProjectionActive: ");
        pw.println(this.mProjectionActive);
        pw.print("  mIdlenessCheckScheduledElapsed: ");
        pw.println(this.mIdlenessCheckScheduledElapsed);
        pw.print("  mIdleStartElapsed: ");
        pw.println(this.mIdleStartElapsed);
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void dump(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        long diToken = proto.start(1146756268033L);
        proto.write(1133871366145L, this.mIdle);
        proto.write(1133871366146L, this.mScreenOn);
        proto.write(1133871366147L, this.mDockIdle);
        proto.write(1133871366149L, this.mProjectionActive);
        proto.end(diToken);
        proto.end(token);
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void dumpConstants(IndentingPrintWriter pw) {
        pw.println("DeviceIdlenessTracker:");
        pw.increaseIndent();
        pw.print(KEY_INACTIVITY_IDLE_THRESHOLD_MS, Long.valueOf(this.mInactivityIdleThreshold)).println();
        pw.print(KEY_INACTIVITY_STABLE_POWER_IDLE_THRESHOLD_MS, Long.valueOf(this.mInactivityStablePowerIdleThreshold)).println();
        pw.print(KEY_IDLE_WINDOW_SLOP_MS, Long.valueOf(this.mIdleWindowSlop)).println();
        pw.decreaseIndent();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (DEBUG == false) goto L6;
        Slog.v(TAG, "Received action: " + action);
    L6:
        switch(action.hashCode()) {
            case -2128145023: goto L27;
            case -1454123155: goto L24;
            case -905264325: goto L21;
            case 244891622: goto L18;
            case 257757490: goto L15;
            case 1456569541: goto L12;
            case 1689632941: goto L9;
            default: goto L29;
        };
    L29:
        byte r1 = -1;
    L30:
        switch(r1) {
            case 0: goto L42;
            case 1: goto L45;
            case 2: goto L47;
            case 3: goto L34;
            case 4: goto L34;
            case 5: goto L34;
            case 6: goto L32;
            default: goto L54;
        };
    L32:
        handleIdleTrigger();
        return;
    L47:
        this.mScreenOn = true;
        this.mDockIdle = false;
        if (DEBUG == false) goto L50;
        Slog.v(TAG, "exiting idle");
    L50:
        exitIdle();
        return;
    L54:
        return;
    L34:
        if (action.equals("android.intent.action.DOCK_IDLE") == true) goto L36;
        this.mScreenOn = false;
        this.mDockIdle = false;
    L40:
        maybeScheduleIdlenessCheck(action);
        return;
    L36:
        if (this.mScreenOn == true) goto L38;
        return;
    L38:
        this.mDockIdle = true;
        goto L40
    L42:
        if (this.mScreenOn == true) goto L45;
        return;
    L45:
        if (this.mPowerManager.isInteractive() == true) goto L47;
        return;
    L9:
        if (action.equals("android.intent.action.DOCK_ACTIVE") == false) goto L29;
        r1 = 0;
        goto L30
    L12:
        if (action.equals(ActivityManagerService.ACTION_TRIGGER_IDLE) == false) goto L29;
        r1 = 6;
        goto L30
    L15:
        if (action.equals("android.intent.action.DREAMING_STOPPED") == false) goto L29;
        r1 = 1;
        goto L30
    L18:
        if (action.equals("android.intent.action.DREAMING_STARTED") == false) goto L29;
        r1 = 4;
        goto L30
    L21:
        if (action.equals("android.intent.action.DOCK_IDLE") == false) goto L29;
        r1 = 5;
        goto L30
    L24:
        if (action.equals("android.intent.action.SCREEN_ON") == false) goto L29;
        r1 = 2;
        goto L30
    L27:
        if (action.equals("android.intent.action.SCREEN_OFF") == false) goto L29;
        r1 = 3;
        goto L30
    }

    private void maybeScheduleIdlenessCheck(String reason) {
        if (this.mIdle == false) goto L9;
        if (DEBUG == false) goto L39;
        Slog.w(TAG, "Already idle. Redundant reason=" + reason);
        return;
    L39:
        return;
    L9:
        if (this.mScreenOn == false) goto L13;
        if (this.mDockIdle == true) goto L13;
        return;
    L13:
        if (this.mProjectionActive == true) goto L42;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.mIsStablePower == false) goto L17;
        long inactivityThresholdMs = this.mInactivityStablePowerIdleThreshold;
    L19:
        if (this.mIdlenessCheckScheduledElapsed >= 0) goto L21;
        this.mIdlenessCheckScheduledElapsed = nowElapsed;
    L28:
        long when = this.mIdlenessCheckScheduledElapsed + inactivityThresholdMs;
        if (when == this.mIdleStartElapsed) goto L31;
        this.mIdleStartElapsed = when;
        if (DEBUG == false) goto L37;
        Slog.v(TAG, "Scheduling idle : " + reason + " now:" + nowElapsed + " checkElapsed=" + this.mIdlenessCheckScheduledElapsed + " when=" + this.mIdleStartElapsed);
    L37:
        this.mAlarm.setWindow(2, this.mIdleStartElapsed, this.mIdleWindowSlop, "JS idleness", AppSchedulingModuleThread.getExecutor(), this.mIdleAlarmListener);
        return;
    L31:
        if (DEBUG == false) goto L40;
        Slog.i(TAG, "No change to idle start time");
        return;
    L40:
        return;
    L21:
        if ((this.mIdlenessCheckScheduledElapsed + inactivityThresholdMs) > nowElapsed) goto L28;
        if (DEBUG == false) goto L25;
        Slog.v(TAG, "Previous idle check @ " + this.mIdlenessCheckScheduledElapsed + " allows device to be idle now");
    L25:
        handleIdleTrigger();
        return;
    L17:
        inactivityThresholdMs = this.mInactivityIdleThreshold;
        goto L19
    }

    private void exitIdle() {
        this.mAlarm.cancel(this.mIdleAlarmListener);
        this.mIdlenessCheckScheduledElapsed = -1;
        this.mIdleStartElapsed = Long.MAX_VALUE;
        if (this.mIdle == false) goto L6;
        this.mIdle = false;
        this.mIdleListener.reportNewIdleState(false);
        return;
    }

    private void handleIdleTrigger() {
        if (this.mIdle == true) goto L15;
        if (this.mScreenOn == false) goto L9;
        if (this.mDockIdle == false) goto L15;
    L9:
        if (this.mProjectionActive == true) goto L15;
        if (DEBUG == false) goto L13;
        Slog.v(TAG, "Idle trigger fired @ " + JobSchedulerService.sElapsedRealtimeClock.millis());
    L13:
        this.mIdle = true;
        this.mIdleListener.reportNewIdleState(this.mIdle);
        return;
    L15:
        if (DEBUG == false) goto L19;
        Slog.v(TAG, "TRIGGER_IDLE received but not changing state; idle=" + this.mIdle + " screen=" + this.mScreenOn + " projection=" + this.mProjectionActive);
        return;
    }
}

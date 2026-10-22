package com.android.server.job.controllers.idle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.DeviceConfig;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.am.ActivityManagerService;
import com.android.server.job.JobSchedulerService;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class CarIdlenessTracker extends BroadcastReceiver implements IdlenessTracker {
    public static final String ACTION_FORCE_IDLE = "com.android.server.jobscheduler.FORCE_IDLE";
    public static final String ACTION_GARAGE_MODE_OFF = "com.android.server.jobscheduler.GARAGE_MODE_OFF";
    public static final String ACTION_GARAGE_MODE_ON = "com.android.server.jobscheduler.GARAGE_MODE_ON";
    public static final String ACTION_UNFORCE_IDLE = "com.android.server.jobscheduler.UNFORCE_IDLE";
    private static final boolean DEBUG = false;
    private static final String TAG = "JobScheduler.CarIdlenessTracker";
    private boolean mForced;
    private boolean mGarageModeOn;
    private boolean mIdle;
    private IdlenessListener mIdleListener;
    private boolean mScreenOn;

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

    public CarIdlenessTracker() {
        this.mIdle = false;
        this.mGarageModeOn = false;
        this.mForced = false;
        this.mScreenOn = true;
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public boolean isIdle() {
        return this.mIdle;
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void startTracking(Context context, JobSchedulerService service, IdlenessListener listener) {
        this.mIdleListener = listener;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction(ACTION_GARAGE_MODE_ON);
        filter.addAction(ACTION_GARAGE_MODE_OFF);
        filter.addAction(ACTION_FORCE_IDLE);
        filter.addAction(ACTION_UNFORCE_IDLE);
        filter.addAction(ActivityManagerService.ACTION_TRIGGER_IDLE);
        context.registerReceiver(this, filter, null, AppSchedulingModuleThread.getHandler());
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void processConstant(DeviceConfig.Properties properties, String key) {
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void onBatteryStateChanged(boolean isCharging, boolean isBatteryNotLow) {
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void dump(PrintWriter pw) {
        pw.print("  mIdle: ");
        pw.println(this.mIdle);
        pw.print("  mGarageModeOn: ");
        pw.println(this.mGarageModeOn);
        pw.print("  mForced: ");
        pw.println(this.mForced);
        pw.print("  mScreenOn: ");
        pw.println(this.mScreenOn);
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void dump(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        long ciToken = proto.start(1146756268034L);
        proto.write(1133871366145L, this.mIdle);
        proto.write(1133871366146L, this.mGarageModeOn);
        proto.end(ciToken);
        proto.end(token);
    }

    @Override // com.android.server.job.controllers.idle.IdlenessTracker
    public void dumpConstants(IndentingPrintWriter pw) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        logIfDebug("Received action: " + action);
        if (action.equals(ACTION_FORCE_IDLE) == false) goto L6;
        logIfDebug("Forcing idle...");
        setForceIdleState(true);
        return;
    L6:
        if (action.equals(ACTION_UNFORCE_IDLE) == false) goto L9;
        logIfDebug("Unforcing idle...");
        setForceIdleState(false);
        return;
    L9:
        if (action.equals("android.intent.action.SCREEN_ON") == false) goto L12;
        logIfDebug("Screen is on...");
        handleScreenOn();
        return;
    L12:
        if (action.equals("android.intent.action.SCREEN_OFF") == false) goto L15;
        logIfDebug("Screen is off...");
        this.mScreenOn = false;
        return;
    L15:
        if (action.equals(ACTION_GARAGE_MODE_ON) == false) goto L18;
        logIfDebug("GarageMode is on...");
        this.mGarageModeOn = true;
        updateIdlenessState();
        return;
    L18:
        if (action.equals(ACTION_GARAGE_MODE_OFF) == false) goto L21;
        logIfDebug("GarageMode is off...");
        this.mGarageModeOn = false;
        updateIdlenessState();
        return;
    L21:
        if (action.equals(ActivityManagerService.ACTION_TRIGGER_IDLE) == true) goto L23;
        return;
    L23:
        if (this.mGarageModeOn == true) goto L25;
        logIfDebug("Idle trigger fired...");
        triggerIdleness();
        return;
    L25:
        logIfDebug("TRIGGER_IDLE received but not changing state; mIdle=" + this.mIdle + " mGarageModeOn=" + this.mGarageModeOn);
    }

    private void setForceIdleState(boolean forced) {
        this.mForced = forced;
        updateIdlenessState();
    }

    private void updateIdlenessState() {
        if (this.mForced == false) goto L5;
    L8:
        boolean newState = true;
    L10:
        if (this.mIdle == newState) goto L12;
        logIfDebug("Device idleness changed. New idle=" + newState);
        this.mIdle = newState;
        this.mIdleListener.reportNewIdleState(this.mIdle);
        return;
    L12:
        logIfDebug("Device idleness is the same. Current idle=" + newState);
        return;
    L5:
        if (this.mGarageModeOn == true) goto L8;
        newState = false;
        goto L10
    }

    private void triggerIdleness() {
        if (this.mIdle == false) goto L6;
        logIfDebug("Device is already idle");
        return;
    L6:
        if (this.mScreenOn == true) goto L8;
        logIfDebug("Device is going idle");
        this.mIdle = true;
        this.mIdleListener.reportNewIdleState(this.mIdle);
        return;
    L8:
        logIfDebug("TRIGGER_IDLE received but not changing state: mIdle = " + this.mIdle + ", mScreenOn = " + this.mScreenOn);
    }

    private void handleScreenOn() {
        this.mScreenOn = true;
        if (this.mForced == false) goto L5;
    L11:
        logIfDebug("Screen is on, but device cannot exit idle");
        return;
    L5:
        if (this.mGarageModeOn == true) goto L11;
        if (this.mIdle == false) goto L10;
        logIfDebug("Device is exiting idle");
        this.mIdle = false;
        this.mIdleListener.reportNewIdleState(this.mIdle);
        return;
    L10:
        logIfDebug("Device is already non-idle");
    }

    private static void logIfDebug(String msg) {
        if (DEBUG == false) goto L6;
        Slog.v(TAG, msg);
        return;
    }
}

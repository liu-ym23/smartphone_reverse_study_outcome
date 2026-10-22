package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class CommandHandler implements ExecutionListener {
    static final String ACTION_CONSTRAINTS_CHANGED = "ACTION_CONSTRAINTS_CHANGED";
    static final String ACTION_DELAY_MET = "ACTION_DELAY_MET";
    static final String ACTION_EXECUTION_COMPLETED = "ACTION_EXECUTION_COMPLETED";
    static final String ACTION_RESCHEDULE = "ACTION_RESCHEDULE";
    static final String ACTION_SCHEDULE_WORK = "ACTION_SCHEDULE_WORK";
    static final String ACTION_STOP_WORK = "ACTION_STOP_WORK";
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = null;
    static final long WORK_PROCESSING_TIME_IN_MS = 600000;
    private final Context mContext;
    private final Object mLock;
    private final Map<String, ExecutionListener> mPendingDelayMet;

    static {
        TAG = Logger.tagWithPrefix("CommandHandler");
    }

    public boolean hasPendingCommands() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingDelayMet.isEmpty() == true) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public CommandHandler(Context r100) {
        this.mContext = r100;
        this.mPendingDelayMet = new HashMap();
        this.mLock = new Object();
    }

    public static Intent createConstraintsChangedIntent(Context r100) {
        Intent r101 = new Intent(r100, SystemAlarmService.class);
        r101.setAction(ACTION_CONSTRAINTS_CHANGED);
        return r101;
    }

    public static Intent createRescheduleIntent(Context r100) {
        Intent r101 = new Intent(r100, SystemAlarmService.class);
        r101.setAction(ACTION_RESCHEDULE);
        return r101;
    }

    public static Intent createDelayMetIntent(Context r100, String r101) {
        Intent r102 = new Intent(r100, SystemAlarmService.class);
        r102.setAction(ACTION_DELAY_MET);
        r102.putExtra(KEY_WORKSPEC_ID, r101);
        return r102;
    }

    public static Intent createScheduleWorkIntent(Context r100, String r101) {
        Intent r102 = new Intent(r100, SystemAlarmService.class);
        r102.setAction(ACTION_SCHEDULE_WORK);
        r102.putExtra(KEY_WORKSPEC_ID, r101);
        return r102;
    }

    public static Intent createStopWorkIntent(Context r100, String r101) {
        Intent r102 = new Intent(r100, SystemAlarmService.class);
        r102.setAction(ACTION_STOP_WORK);
        r102.putExtra(KEY_WORKSPEC_ID, r101);
        return r102;
    }

    private void handleExecutionCompleted(Intent r100, int r101) {
        Bundle r102 = r100.getExtras();
        String r103 = r102.getString(KEY_WORKSPEC_ID);
        boolean r104 = r102.getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, String.format("Handling onExecutionCompleted %s, %s", new Object[]{r100, Integer.valueOf(r101)}), new Throwable[0]);
        onExecuted(r103, r104);
    }

    private void handleStopWork(Intent r100, SystemAlarmDispatcher r101) {
        String r102 = r100.getExtras().getString(KEY_WORKSPEC_ID);
        Logger.get().debug(TAG, String.format("Handing stopWork work for %s", new Object[]{r102}), new Throwable[0]);
        r101.getWorkManager().stopWork(r102);
        Alarms.cancelAlarm(this.mContext, r101.getWorkManager(), r102);
        r101.onExecuted(r102, false);
    }

    private static boolean hasKeys(Bundle r100, String... r101) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L15;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        if (r100.get(r101[r103]) == null) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String r100, boolean r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        ExecutionListener r103 = this.mPendingDelayMet.remove(r100);     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.onExecuted(r100, r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static Intent createExecutionCompletedIntent(Context r100, String r101, boolean r102) {
        Intent r103 = new Intent(r100, SystemAlarmService.class);
        r103.setAction(ACTION_EXECUTION_COMPLETED);
        r103.putExtra(KEY_WORKSPEC_ID, r101);
        r103.putExtra(KEY_NEEDS_RESCHEDULE, r102);
        return r103;
    }

    private void handleConstraintsChanged(Intent r100, int r101, SystemAlarmDispatcher r102) {
        Logger.get().debug(TAG, String.format("Handling constraints changed %s", new Object[]{r100}), new Throwable[0]);
        new ConstraintsCommandHandler(this.mContext, r101, r102).handleConstraintsChanged();
    }

    private void handleDelayMet(Intent r100, int r101, SystemAlarmDispatcher r110) {
        Bundle r102 = r100.getExtras();
        Object r103 = this.mLock;
        monitor-enter(r103);
        String r104 = r102.getString(KEY_WORKSPEC_ID);     // Catch: Throwable -> L10
        Logger r105 = Logger.get();     // Catch: Throwable -> L10
        String r106 = TAG;     // Catch: Throwable -> L10
        r105.debug(r106, String.format("Handing delay met for %s", new Object[]{r104}), new Throwable[0]);     // Catch: Throwable -> L10
        if (this.mPendingDelayMet.containsKey(r104) == true) goto L7;
        DelayMetCommandHandler r107 = new DelayMetCommandHandler(this.mContext, r101, r104, r110);     // Catch: Throwable -> L10
        this.mPendingDelayMet.put(r104, r107);     // Catch: Throwable -> L10
        r107.handleProcessWork();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L7:
        Logger.get().debug(r106, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{r104}), new Throwable[0]);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void handleReschedule(Intent r100, int r101, SystemAlarmDispatcher r102) {
        Logger.get().debug(TAG, String.format("Handling reschedule %s, %s", new Object[]{r100, Integer.valueOf(r101)}), new Throwable[0]);
        r102.getWorkManager().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(Intent r110, int r111, SystemAlarmDispatcher r112) {
        String r113 = r110.getExtras().getString(KEY_WORKSPEC_ID);
        Logger r100 = Logger.get();
        String r101 = TAG;
        r100.debug(r101, String.format("Handling schedule work for %s", new Object[]{r113}), new Throwable[0]);
        WorkDatabase r102 = r112.getWorkManager().getWorkDatabase();
        r102.beginTransaction();
        WorkSpec r103 = r102.workSpecDao().getWorkSpec(r113);     // Catch: Throwable -> L21
        if (r103 != null) goto L10;
        Logger.get().warning(r101, "Skipping scheduling " + r113 + " because it's no longer in the DB", new Throwable[0]);     // Catch: Throwable -> L21
        r102.endTransaction();
        return;
    L10:
        if (r103.state.isFinished() == false) goto L14;
        Logger.get().warning(r101, "Skipping scheduling " + r113 + "because it is finished.", new Throwable[0]);     // Catch: Throwable -> L21
        r102.endTransaction();
        return;
    L14:
        long r104 = r103.calculateNextRunTime();     // Catch: Throwable -> L21
        if (r103.hasConstraints() == true) goto L17;
        Logger.get().debug(r101, String.format("Setting up Alarms for %s at %s", new Object[]{r113, Long.valueOf(r104)}), new Throwable[0]);     // Catch: Throwable -> L21
        Alarms.setAlarm(this.mContext, r112.getWorkManager(), r113, r104);     // Catch: Throwable -> L21
    L18:
        r102.setTransactionSuccessful();     // Catch: Throwable -> L21
        r102.endTransaction();
        return;
    L17:
        Logger.get().debug(r101, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{r113, Long.valueOf(r104)}), new Throwable[0]);     // Catch: Throwable -> L21
        Alarms.setAlarm(this.mContext, r112.getWorkManager(), r113, r104);     // Catch: Throwable -> L21
        r112.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(r112, createConstraintsChangedIntent(this.mContext), r111));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r102.endTransaction();
        throw th;
    }

    public void onHandleIntent(Intent r100, int r101, SystemAlarmDispatcher r102) {
        String r103 = r100.getAction();
        if (ACTION_CONSTRAINTS_CHANGED.equals(r103) == false) goto L6;
        handleConstraintsChanged(r100, r101, r102);
        return;
    L6:
        if (ACTION_RESCHEDULE.equals(r103) == false) goto L9;
        handleReschedule(r100, r101, r102);
        return;
    L9:
        if (hasKeys(r100.getExtras(), new String[]{KEY_WORKSPEC_ID}) == true) goto L12;
        Logger.get().error(TAG, String.format("Invalid request for %s, requires %s.", new Object[]{r103, KEY_WORKSPEC_ID}), new Throwable[0]);
        return;
    L12:
        if (ACTION_SCHEDULE_WORK.equals(r103) == false) goto L15;
        handleScheduleWorkIntent(r100, r101, r102);
        return;
    L15:
        if (ACTION_DELAY_MET.equals(r103) == false) goto L18;
        handleDelayMet(r100, r101, r102);
        return;
    L18:
        if (ACTION_STOP_WORK.equals(r103) == false) goto L21;
        handleStopWork(r100, r102);
        return;
    L21:
        if (ACTION_EXECUTION_COMPLETED.equals(r103) == false) goto L23;
        handleExecutionCompleted(r100, r101);
        return;
    L23:
        Logger.get().warning(TAG, String.format("Ignoring intent %s", new Object[]{r100}), new Throwable[0]);
    }
}

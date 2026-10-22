package com.android.server.notification;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.notification.Condition;
import android.service.notification.ScheduleCalendar;
import android.service.notification.ZenModeConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.am.HostingRecord;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ScheduleConditionProvider extends SystemConditionProviderService {
    private static final String ACTION_EVALUATE = null;
    static final boolean DEBUG = false;
    private static final String EXTRA_TIME = "time";
    private static final String NOT_SHOWN = "...";
    private static final int REQUEST_CODE_EVALUATE = 1;
    private static final String SCP_SETTING = "snoozed_schedule_condition_provider";
    private static final String SEPARATOR = ";";
    private static final String SIMPLE_NAME = null;
    static final String TAG = "ConditionProviders.SCP";
    private AlarmManager mAlarmManager;
    private final Clock mClock;
    private boolean mConnected;
    private final Context mContext;
    private long mNextAlarmTime;
    private final BroadcastReceiver mReceiver;
    private boolean mRegistered;
    private final ArraySet<Uri> mSnoozedForAlarm;
    private final ArrayMap<Uri, ScheduleCalendar> mSubscriptions;

    /* JADX INFO: renamed from: -$$Nest$fgetmSubscriptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m6278$$Nest$fgetmSubscriptions(ScheduleConditionProvider r0) {
        return r0.mSubscriptions;
    }

    /* JADX INFO: renamed from: -$$Nest$mevaluateSubscriptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6279$$Nest$mevaluateSubscriptions(ScheduleConditionProvider r0) {
        r0.evaluateSubscriptions();
    }

    static {
        DEBUG = true;
        SIMPLE_NAME = ScheduleConditionProvider.class.getSimpleName();
        ACTION_EVALUATE = SIMPLE_NAME + ".EVALUATE";
    }

    public ScheduleConditionProvider() {
        this(Clock.systemUTC());
    }

    ScheduleConditionProvider(Clock clock) {
        this.mContext = this;
        this.mSubscriptions = new ArrayMap();
        this.mSnoozedForAlarm = new ArraySet();
        this.mReceiver = new AnonymousClass1(this);
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "new " + SIMPLE_NAME + "()");
    L5:
        this.mClock = clock;
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public boolean isValidConditionId(Uri id) {
        return ZenModeConfig.isValidScheduleConditionId(id);
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void dump(PrintWriter pw, NotificationManagerService.DumpFilter filter) {
        pw.print("    ");
        pw.print(SIMPLE_NAME);
        pw.println(":");
        pw.print("      mConnected=");
        pw.println(this.mConnected);
        pw.print("      mRegistered=");
        pw.println(this.mRegistered);
        pw.println("      mSubscriptions=");
        long now = this.mClock.millis();
        ArrayMap<Uri, ScheduleCalendar> r1 = this.mSubscriptions;
        monitor-enter(r1);
        Iterator<Uri> r0 = this.mSubscriptions.keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r0.hasNext() == false) goto L14;
        Uri conditionId = r0.next();     // Catch: Throwable -> L10
        pw.print("        ");     // Catch: Throwable -> L10
        if (meetsSchedule(this.mSubscriptions.get(conditionId), now) == false) goto L12;
        String r3 = "* ";
    L13:
        pw.print(r3);     // Catch: Throwable -> L10
        pw.println(conditionId);     // Catch: Throwable -> L10
        pw.print("            ");     // Catch: Throwable -> L10
        pw.println(this.mSubscriptions.get(conditionId).toString());     // Catch: Throwable -> L10
        goto L6
    L12:
        r3 = "  ";
        goto L13
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        ArraySet<Uri> r2 = this.mSnoozedForAlarm;
        monitor-enter(r2);
        pw.println("      snoozed due to alarm: " + TextUtils.join(SEPARATOR, this.mSnoozedForAlarm));     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        SystemConditionProviderService.dumpUpcomingTime(pw, "mNextAlarmTime", this.mNextAlarmTime, now);
        return;
    L21:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.service.notification.ConditionProviderService
    public void onConnected() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "onConnected");
    L5:
        this.mConnected = true;
        readSnoozed();
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onBootComplete() {
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onUserSwitched(UserHandle user) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "onDestroy");
    L5:
        this.mConnected = false;
    }

    @Override // android.service.notification.ConditionProviderService
    public void onSubscribe(Uri conditionId) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "onSubscribe " + conditionId);
    L6:
        if (ZenModeConfig.isValidScheduleConditionId(conditionId) == true) goto L9;
        notifyCondition(createCondition(conditionId, 3, "invalidId"));
        return;
    L9:
        ArrayMap<Uri, ScheduleCalendar> r0 = this.mSubscriptions;
        monitor-enter(r0);
        this.mSubscriptions.put(conditionId, ZenModeConfig.toScheduleCalendar(conditionId));     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        evaluateSubscriptions();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.service.notification.ConditionProviderService
    public void onUnsubscribe(Uri conditionId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "onUnsubscribe " + conditionId);
    L5:
        ArrayMap<Uri, ScheduleCalendar> r0 = this.mSubscriptions;
        monitor-enter(r0);
        this.mSubscriptions.remove(conditionId);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        removeSnoozed(conditionId);
        evaluateSubscriptions();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void evaluateSubscriptions() {
        long now = this.mClock.millis();
        this.mNextAlarmTime = 0;
        long nextUserAlarmTime = getNextAlarmClockAlarm();
        List<Condition> conditionsToNotify = new ArrayList();
        ArrayMap<Uri, ScheduleCalendar> r9 = this.mSubscriptions;
        monitor-enter(r9);
    L16:
        th = th;
    L25:
        monitor-exit(r9);     // Catch: Throwable -> L16
        throw th;
    L19:
        th = th;
        goto L25
    L5:
        if (this.mSubscriptions.isEmpty() == true) goto L7;
        boolean r0 = true;
    L8:
        setRegistered(r0);     // Catch: Throwable -> L19
        Iterator<Uri> r1 = this.mSubscriptions.keySet().iterator();     // Catch: Throwable -> L19
    L10:
        if (r1.hasNext() == false) goto L22;
        Uri conditionId = r1.next();     // Catch: Throwable -> L19
        Condition condition = evaluateSubscriptionLocked(conditionId, this.mSubscriptions.get(conditionId), now, nextUserAlarmTime);     // Catch: Throwable -> L16
        if (condition == null) goto L10;
        conditionsToNotify.add(condition);     // Catch: Throwable -> L16
        goto L10
    L22:
        monitor-exit(r9);     // Catch: Throwable -> L16
        notifyConditions((Condition[]) conditionsToNotify.toArray(new Condition[conditionsToNotify.size()]));
        updateAlarm(now, this.mNextAlarmTime);
        return;
    L7:
        r0 = false;
        goto L8
    }

    Condition evaluateSubscriptionLocked(Uri conditionId, ScheduleCalendar cal, long now, long nextUserAlarmTime) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, String.format("evaluateSubscriptionLocked cal=%s, now=%s, nextUserAlarmTime=%s", new Object[]{cal, SystemConditionProviderService.ts(now), SystemConditionProviderService.ts(nextUserAlarmTime)}));
    L5:
        if (cal != null) goto L9;
        Condition condition = createCondition(conditionId, 3, "!invalidId");
        removeSnoozed(conditionId);
        return condition;
    L9:
        if (cal.isInSchedule(now) == true) goto L11;
        Condition condition2 = createCondition(conditionId, 0, "!meetsSchedule");
        removeSnoozed(conditionId);
    L18:
        cal.maybeSetNextAlarm(now, nextUserAlarmTime);
        long nextChangeTime = cal.getNextChangeTime(now);
        if (nextChangeTime > 0) goto L21;
    L27:
        return condition2;
    L21:
        if (nextChangeTime <= now) goto L27;
        if (this.mNextAlarmTime != 0) goto L25;
    L26:
        this.mNextAlarmTime = nextChangeTime;
        goto L27
    L25:
        if (nextChangeTime >= this.mNextAlarmTime) goto L27;
    L11:
        if (conditionSnoozed(conditionId) == false) goto L14;
        condition2 = createCondition(conditionId, 0, "snoozed");
        goto L18
    L14:
        if (cal.shouldExitForAlarm(now) == false) goto L16;
        condition2 = createCondition(conditionId, 0, "alarmCanceled");
        addSnoozed(conditionId);
        goto L18
    L16:
        condition2 = createCondition(conditionId, 1, "meetsSchedule");
        goto L18
    }

    private void updateAlarm(long now, long time) {
        AlarmManager alarms = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        PendingIntent pendingIntent = getPendingIntent(time);
        alarms.cancel(pendingIntent);
        if (time <= now) goto L9;
        if (DEBUG == false) goto L7;
        Slog.d(TAG, String.format("Scheduling evaluate for %s, in %s, now=%s", new Object[]{SystemConditionProviderService.ts(time), SystemConditionProviderService.formatDuration(time - now), SystemConditionProviderService.ts(now)}));
    L7:
        alarms.setExact(0, time, pendingIntent);
        return;
    L9:
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Not scheduling evaluate");
        return;
    }

    PendingIntent getPendingIntent(long time) {
        return PendingIntent.getBroadcast(this.mContext, 1, new Intent(ACTION_EVALUATE).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).addFlags(268435456).putExtra(EXTRA_TIME, time), AudioFormat.DTS_HD);
    }

    private long getNextAlarmClockAlarm() {
        if (this.mAlarmManager != null) goto L5;
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
    L5:
        AlarmManager.AlarmClockInfo info = this.mAlarmManager.getNextAlarmClock(ActivityManager.getCurrentUser());
        if (info != null) goto L10;
        return 0;
    L10:
        return info.getTriggerTime();
    }

    private boolean meetsSchedule(ScheduleCalendar cal, long time) {
        if (cal != null) goto L4;
    L6:
        return false;
    L4:
        if (cal.isInSchedule(time) == false) goto L6;
        return true;
    }

    private void setRegistered(boolean registered) {
        if (this.mRegistered != registered) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "setRegistered " + registered);
    L8:
        this.mRegistered = registered;
        if (this.mRegistered == false) goto L11;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.TIME_SET");
        filter.addAction("android.intent.action.TIMEZONE_CHANGED");
        filter.addAction(ACTION_EVALUATE);
        filter.addAction("android.app.action.NEXT_ALARM_CLOCK_CHANGED");
        registerReceiverForAllUsers(this.mReceiver, filter, null, null);
        return;
    L11:
        unregisterReceiver(this.mReceiver);
    }

    private Condition createCondition(Uri id, int state, String reason) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "notifyCondition " + id + " " + Condition.stateToString(state) + " reason=" + reason);
    L6:
        return new Condition(id, NOT_SHOWN, NOT_SHOWN, NOT_SHOWN, 0, state, 2);
    }

    private boolean conditionSnoozed(Uri conditionId) {
        ArraySet<Uri> r0 = this.mSnoozedForAlarm;
        monitor-enter(r0);
        boolean r1 = this.mSnoozedForAlarm.contains(conditionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void addSnoozed(Uri conditionId) {
        ArraySet<Uri> r0 = this.mSnoozedForAlarm;
        monitor-enter(r0);
        this.mSnoozedForAlarm.add(conditionId);     // Catch: Throwable -> L7
        saveSnoozedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeSnoozed(Uri conditionId) {
        ArraySet<Uri> r0 = this.mSnoozedForAlarm;
        monitor-enter(r0);
        this.mSnoozedForAlarm.remove(conditionId);     // Catch: Throwable -> L7
        saveSnoozedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void saveSnoozedLocked() {
        String setting = TextUtils.join(SEPARATOR, this.mSnoozedForAlarm);
        int currentUser = ActivityManager.getCurrentUser();
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), SCP_SETTING, setting, currentUser);
    }

    private void readSnoozed() {
        ArraySet<Uri> r0 = this.mSnoozedForAlarm;
        monitor-enter(r0);
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L23
        String setting = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), SCP_SETTING, ActivityManager.getCurrentUser());     // Catch: Throwable -> L13
        if (setting == null) goto L20;
        String[] tokens = setting.split(SEPARATOR);     // Catch: Throwable -> L13
        int i = 0;
    L8:
        if (i >= tokens.length) goto L20;
        String token = tokens[i];     // Catch: Throwable -> L13
        if (token == null) goto L16;
        token = token.trim();     // Catch: Throwable -> L13
    L16:
        if (TextUtils.isEmpty(token) == true) goto L19;
        this.mSnoozedForAlarm.add(Uri.parse(token));     // Catch: Throwable -> L13
    L19:
        i = i + 1;
        goto L8
    L20:
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public ArrayMap<Uri, ScheduleCalendar> getSubscriptions() {
        return this.mSubscriptions;
    }
}

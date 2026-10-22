package com.android.server.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.UserInfo;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.UserHandle;
import android.os.UserManager;
import android.service.notification.Condition;
import android.service.notification.ZenModeConfig;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.am.HostingRecord;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EventConditionProvider extends SystemConditionProviderService {
    private static final String ACTION_EVALUATE = null;
    private static final long CHANGE_DELAY = 2000;
    private static final boolean DEBUG = false;
    private static final String EXTRA_TIME = "time";
    private static final String NOT_SHOWN = "...";
    private static final int REQUEST_CODE_EVALUATE = 1;
    private static final String SIMPLE_NAME = null;
    private static final String TAG = "ConditionProviders.ECP";
    private boolean mBootComplete;
    private boolean mConnected;
    Context mContext;
    private UserHandle mCurrentUser;
    private final Runnable mEvaluateSubscriptionsW;
    private long mNextAlarmTime;
    private final BroadcastReceiver mReceiver;
    private boolean mRegistered;
    private final ArraySet<Uri> mSubscriptions;
    private final HandlerThread mThread;
    private final CalendarTracker.Callback mTrackerCallback;
    private final SparseArray<CalendarTracker> mTrackers;
    private final Handler mWorker;

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserHandle m6046$$Nest$fgetmCurrentUser(EventConditionProvider r0) {
        return r0.mCurrentUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEvaluateSubscriptionsW, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m6047$$Nest$fgetmEvaluateSubscriptionsW(EventConditionProvider r0) {
        return r0.mEvaluateSubscriptionsW;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWorker, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6048$$Nest$fgetmWorker(EventConditionProvider r0) {
        return r0.mWorker;
    }

    /* JADX INFO: renamed from: -$$Nest$mevaluateSubscriptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6049$$Nest$mevaluateSubscriptions(EventConditionProvider r0) {
        r0.evaluateSubscriptions();
    }

    /* JADX INFO: renamed from: -$$Nest$mevaluateSubscriptionsW, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6050$$Nest$mevaluateSubscriptionsW(EventConditionProvider r0) {
        r0.evaluateSubscriptionsW();
    }

    /* JADX INFO: renamed from: -$$Nest$mreloadTrackers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6051$$Nest$mreloadTrackers(EventConditionProvider r0, UserHandle r1) {
        r0.reloadTrackers(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6052$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable("ConditionProviders", 3);
        SIMPLE_NAME = EventConditionProvider.class.getSimpleName();
        ACTION_EVALUATE = SIMPLE_NAME + ".EVALUATE";
    }

    public EventConditionProvider() {
        this.mContext = this;
        this.mSubscriptions = new ArraySet();
        this.mTrackers = new SparseArray();
        this.mCurrentUser = UserHandle.SYSTEM;
        this.mTrackerCallback = new AnonymousClass2(this);
        this.mReceiver = new AnonymousClass3(this);
        this.mEvaluateSubscriptionsW = new AnonymousClass4(this);
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "new " + SIMPLE_NAME + "()");
    L5:
        this.mThread = new HandlerThread(TAG, 10);
        this.mThread.start();
        this.mWorker = new Handler(this.mThread.getLooper());
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public boolean isValidConditionId(Uri id) {
        return ZenModeConfig.isValidEventConditionId(id);
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
        pw.print("      mBootComplete=");
        pw.println(this.mBootComplete);
        SystemConditionProviderService.dumpUpcomingTime(pw, "mNextAlarmTime", this.mNextAlarmTime, System.currentTimeMillis());
        ArraySet<Uri> r8 = this.mSubscriptions;
        monitor-enter(r8);
        pw.println("      mSubscriptions=");     // Catch: Throwable -> L8
        Iterator<Uri> r0 = this.mSubscriptions.iterator();     // Catch: Throwable -> L8
    L6:
        if (r0.hasNext() == false) goto L10;
        Uri conditionId = r0.next();     // Catch: Throwable -> L8
        pw.print("        ");     // Catch: Throwable -> L8
        pw.println(conditionId);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L8
        pw.println("      mTrackers=");
        int i = 0;
    L13:
        if (i >= this.mTrackers.size()) goto L16;
        pw.print("        user=");
        pw.println(this.mTrackers.keyAt(i));
        this.mTrackers.valueAt(i).dump("          ", pw);
        i = i + 1;
        goto L13
    L16:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onBootComplete() {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "onBootComplete");
    L6:
        if (this.mBootComplete == false) goto L8;
        return;
    L8:
        this.mBootComplete = true;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
        filter.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        this.mContext.registerReceiver(new AnonymousClass1(this), filter);
        reloadTrackers(UserHandle.SYSTEM);
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onUserSwitched(UserHandle user) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "onUserSwitched: " + user);
    L6:
        if (this.mCurrentUser.getIdentifier() == user.getIdentifier()) goto L9;
        this.mCurrentUser = user;
        reloadTrackers(user);
        return;
    }

    @Override // android.service.notification.ConditionProviderService
    public void onConnected() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "onConnected");
    L5:
        this.mConnected = true;
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
        if (ZenModeConfig.isValidEventConditionId(conditionId) == true) goto L9;
        notifyCondition(createCondition(conditionId, 0));
        return;
    L9:
        ArraySet<Uri> r0 = this.mSubscriptions;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L12:
        if (this.mSubscriptions.add(conditionId) == false) goto L16;
        evaluateSubscriptions();     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    @Override // android.service.notification.ConditionProviderService
    public void onUnsubscribe(Uri conditionId) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "onUnsubscribe " + conditionId);
    L5:
        ArraySet<Uri> r0 = this.mSubscriptions;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mSubscriptions.remove(conditionId) == false) goto L12;
        evaluateSubscriptions();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private void reloadTrackers(UserHandle user) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "reloadTrackers user=" + user);
    L5:
        int i = 0;
    L7:
        if (i >= this.mTrackers.size()) goto L9;
        this.mTrackers.valueAt(i).setCallback(null);
        i = i + 1;
        goto L7
    L9:
        this.mTrackers.clear();
        UserManager userManager = UserManager.get(this.mContext);
        UserHandle possibleParent = userManager.getProfileParent(user);
        if (possibleParent == null) goto L12;
        Slog.wtf(TAG, "reloadTrackers should not be called with profile " + user + "; continuing with parent " + possibleParent);
        user = possibleParent;
    L12:
        Iterator r3 = userManager.getProfiles(user.getIdentifier()).iterator();
    L14:
        if (r3.hasNext() == false) goto L19;
        UserInfo profile = (UserInfo) r3.next();
        Context profileContext = getContextForUser(this.mContext, profile.getUserHandle());
        if (profileContext == null) goto L17;
        this.mTrackers.put(profile.id, new CalendarTracker(this.mContext, profileContext));
        goto L14
    L17:
        Slog.w(TAG, "Unable to create context for profile " + profile.id + " of user " + user.getIdentifier());
        goto L14
    L19:
        evaluateSubscriptions();
    }

    @Deprecated
    private void reloadTrackers() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "reloadTrackers");
    L5:
        Slog.wtf(TAG, "Shouldn't call reloadTrackers() without user in MODES_HSUM", new Exception());
        int i = 0;
    L7:
        if (i >= this.mTrackers.size()) goto L9;
        this.mTrackers.valueAt(i).setCallback(null);
        i = i + 1;
        goto L7
    L9:
        this.mTrackers.clear();
        Iterator<UserHandle> r0 = UserManager.get(this.mContext).getUserProfiles().iterator();
    L11:
        if (r0.hasNext() == false) goto L19;
        UserHandle user = r0.next();
        if (user.isSystem() == false) goto L15;
        Context context = this.mContext;
    L16:
        if (context == null) goto L17;
        this.mTrackers.put(user.getIdentifier(), new CalendarTracker(this.mContext, context));
        goto L11
    L17:
        Slog.w(TAG, "Unable to create context for user " + user.getIdentifier());
        goto L11
    L15:
        context = getContextForUser(this.mContext, user);
        goto L16
    L19:
        evaluateSubscriptions();
    }

    private void evaluateSubscriptions() {
        if (this.mWorker.hasCallbacks(this.mEvaluateSubscriptionsW) == true) goto L6;
        this.mWorker.post(this.mEvaluateSubscriptionsW);
        return;
    }

    private void evaluateSubscriptionsW() {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "evaluateSubscriptions");
    L6:
        if (this.mBootComplete == false) goto L8;
        long now = System.currentTimeMillis();
        List<Condition> conditionsToNotify = new ArrayList();
        ArraySet<Uri> r5 = this.mSubscriptions;
        monitor-enter(r5);
        int i = 0;
    L78:
    L21:
        th = move-exception;
        throw th;
    L15:
        if (i >= this.mTrackers.size()) goto L23;
        CalendarTracker r6 = this.mTrackers.valueAt(i);     // Catch: Throwable -> L21
        if (this.mSubscriptions.isEmpty() == false) goto L19;
        CalendarTracker.Callback r7 = null;
    L20:
        r6.setCallback(r7);     // Catch: Throwable -> L21
        i = i + 1;     // Catch: Throwable -> L21
        goto L78
    L19:
        r7 = this.mTrackerCallback;     // Catch: Throwable -> L21
        goto L20
    L23:
        int r8 = 0;
        if (this.mSubscriptions.isEmpty() == true) goto L26;
        boolean r0 = true;
    L27:
        setRegistered(r0);     // Catch: Throwable -> L21
        long reevaluateAt = 0;
        Iterator<Uri> r1 = this.mSubscriptions.iterator();     // Catch: Throwable -> L21
    L29:
        if (r1.hasNext() == false) goto L63;
        Uri conditionId = r1.next();     // Catch: Throwable -> L21
        ZenModeConfig.EventInfo event = ZenModeConfig.tryParseEventConditionId(conditionId);     // Catch: Throwable -> L21
        if (event == null) goto L32;
        CalendarTracker.CheckEventResult result = null;
        if (event.calName != null) goto L44;
        int i2 = 0;
    L37:
        if (i2 >= this.mTrackers.size()) goto L48;
        CalendarTracker.CheckEventResult r = this.mTrackers.valueAt(i2).checkEvent(event, now);     // Catch: Throwable -> L21
        if (result != null) goto L41;
        result = r;
    L42:
        i2 = i2 + 1;     // Catch: Throwable -> L21
        goto L37
    L41:
        result.inEvent |= r.inEvent;     // Catch: Throwable -> L21
        result.recheckAt = Math.min(result.recheckAt, r.recheckAt);     // Catch: Throwable -> L21
    L48:
        if (result == null) goto L49;
        if (result.recheckAt == 0) goto L59;
        if (reevaluateAt != 0) goto L56;
    L57:
        reevaluateAt = result.recheckAt;     // Catch: Throwable -> L21
        goto L59
    L56:
        if (result.recheckAt < reevaluateAt) goto L57;
    L59:
        if (result.inEvent == true) goto L61;
        int r13 = 0;
        conditionsToNotify.add(createCondition(conditionId, 0));     // Catch: Throwable -> L21
    L62:
        r8 = r13;
        goto L29
    L61:
        r13 = 0;
        conditionsToNotify.add(createCondition(conditionId, 1));     // Catch: Throwable -> L21
        goto L62
    L49:
        Slog.e(TAG, "No CheckEventResult for userId=" + event.userId + ", calId=" + event.calendarId + ", calName=" + event.calName + "; trackers count is " + this.mTrackers.size());     // Catch: Throwable -> L21
        conditionsToNotify.add(createCondition(conditionId, 0));     // Catch: Throwable -> L21
    L50:
        r8 = 0;
        goto L29
    L44:
        int userId = ZenModeConfig.EventInfo.resolveUserId(event.userId);     // Catch: Throwable -> L21
        CalendarTracker tracker = this.mTrackers.get(userId);     // Catch: Throwable -> L21
        if (tracker == null) goto L46;
        result = tracker.checkEvent(event, now);     // Catch: Throwable -> L21
        goto L48
    L46:
        Slog.w(TAG, "No calendar tracker found for user " + userId + " and calendar = " + event.calName);     // Catch: Throwable -> L21
        conditionsToNotify.add(createCondition(conditionId, 0));     // Catch: Throwable -> L21
        goto L50
    L32:
        conditionsToNotify.add(createCondition(conditionId, r8));     // Catch: Throwable -> L21
        goto L50
    L63:
        rescheduleAlarm(now, reevaluateAt);     // Catch: Throwable -> L21
        monitor-exit(r5);     // Catch: Throwable -> L21
        Iterator<Condition> r2 = conditionsToNotify.iterator();
    L67:
        if (r2.hasNext() == false) goto L73;
        Condition condition = r2.next();
        if (condition == null) goto L67;
        notifyCondition(condition);
        goto L67
    L73:
        if (DEBUG == false) goto L100;
        Slog.d(TAG, "evaluateSubscriptions took " + (System.currentTimeMillis() - now));
        return;
    L100:
        return;
    L26:
        r0 = false;
        goto L27
    L8:
        if (DEBUG == false) goto L99;
        Slog.d(TAG, "Skipping evaluate before boot complete");
        return;
    }

    private void rescheduleAlarm(long now, long time) {
        this.mNextAlarmTime = time;
        AlarmManager alarms = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        PendingIntent pendingIntent = getPendingIntent(time);
        alarms.cancel(pendingIntent);
        if (time == 0) goto L13;
        if (time < now) goto L13;
        if (DEBUG == false) goto L10;
        Slog.d(TAG, String.format("Scheduling evaluate for %s, in %s, now=%s", new Object[]{SystemConditionProviderService.ts(time), SystemConditionProviderService.formatDuration(time - now), SystemConditionProviderService.ts(now)}));
    L10:
        alarms.setExact(0, time, pendingIntent);
        return;
    L13:
        if (DEBUG == false) goto L20;
        StringBuilder r4 = new StringBuilder();
        r4.append("Not scheduling evaluate: ");
        if (time != 0) goto L17;
        String r2 = "no time specified";
    L18:
        r4.append(r2);
        Slog.d(TAG, r4.toString());
        return;
    L17:
        r2 = "specified time in the past";
        goto L18
    }

    PendingIntent getPendingIntent(long time) {
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mContext, 1, new Intent(ACTION_EVALUATE).addFlags(268435456).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).putExtra(EXTRA_TIME, time), AudioFormat.DTS_HD);
        return pendingIntent;
    }

    private Condition createCondition(Uri id, int state) {
        return new Condition(id, NOT_SHOWN, NOT_SHOWN, NOT_SHOWN, 0, state, 2);
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
        registerReceiver(this.mReceiver, filter, 2);
        return;
    L11:
        unregisterReceiver(this.mReceiver);
    }

    private static Context getContextForUser(Context context, UserHandle user) {
        return context.createPackageContextAsUser(context.getPackageName(), 0, user);
    L5:
        return null;
    }

    public SparseArray<CalendarTracker> getTrackers() {
        return this.mTrackers;
    }
}

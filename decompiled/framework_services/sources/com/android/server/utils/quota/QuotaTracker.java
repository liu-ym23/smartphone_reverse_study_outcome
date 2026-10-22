package com.android.server.utils.quota;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.BackgroundThread;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemServiceManager;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.pm.Settings;
import com.android.server.utils.AlarmQueue;

/* JADX INFO: loaded from: classes3.dex */
abstract class QuotaTracker {
    private static final String ALARM_TAG_QUOTA_CHECK = null;
    private static final boolean DEBUG = false;
    static final long MAX_WINDOW_SIZE_MS = 2592000000L;
    static final long MIN_WINDOW_SIZE_MS = 20000;
    private static final String TAG = null;
    private final AlarmManager mAlarmManager;
    private final BroadcastReceiver mBroadcastReceiver;
    final Categorizer mCategorizer;
    protected final Context mContext;
    private final SparseArrayMap<String, Boolean> mFreeQuota;
    private final InQuotaAlarmQueue mInQuotaAlarmQueue;
    protected final Injector mInjector;
    private boolean mIsEnabled;
    private boolean mIsQuotaFree;
    final Object mLock;
    private final ArraySet<QuotaChangeListener> mQuotaChangeListeners;

    private class InQuotaAlarmQueue extends AlarmQueue<Uptc> {
        final /* synthetic */ QuotaTracker this$0;

        /* JADX INFO: renamed from: $r8$lambda$4pOdpDJSR-9AVbQJEXB5QhQBpl8, reason: not valid java name */
        public static /* synthetic */ void m9283$r8$lambda$4pOdpDJSR9AVbQJEXB5QhQBpl8(InQuotaAlarmQueue r0, Uptc r1) {
            r0.lambda$processExpiredAlarms$1(r1);
        }

        public static /* synthetic */ boolean $r8$lambda$v3ty9CuYpDoQ30a57kEe2S_BmBg(int r0, String r1, Uptc r2) {
            return lambda$removeAlarms$0(r0, r1, r2);
        }

        /* synthetic */ InQuotaAlarmQueue(QuotaTracker r1, Context r2, Looper r3, QuotaTrackerIA r4) {
            this(r1, r2, r3);
        }

        @Override // com.android.server.utils.AlarmQueue
        protected /* bridge */ /* synthetic */ boolean isForUser(Uptc r1, int r2) {
            return isForUser2(r1, r2);
        }

        private InQuotaAlarmQueue(QuotaTracker r9, Context context, Looper looper) {
            this.this$0 = r9;
            super(context, looper, QuotaTracker.m9281$$Nest$sfgetALARM_TAG_QUOTA_CHECK(), "In quota", false, 0);
        }

        /* JADX INFO: renamed from: isForUser, reason: avoid collision after fix types in other method */
        protected boolean isForUser2(Uptc uptc, int userId) {
            if (userId != uptc.userId) goto L5;
            return true;
        L5:
            return false;
        }

        private static /* synthetic */ boolean lambda$removeAlarms$0(int userId, String packageName, Uptc uptc) {
            if (userId == uptc.userId) goto L5;
        L7:
            return false;
        L5:
            if (packageName.equals(uptc.packageName) == false) goto L7;
            return true;
        }

        void removeAlarms(final int userId, final String packageName) {
            removeAlarmsIf(new QuotaTracker$InQuotaAlarmQueue$$ExternalSyntheticLambda0(userId, packageName));
        }

        @Override // com.android.server.utils.AlarmQueue
        protected void processExpiredAlarms(ArraySet<Uptc> expired) {
            int i = 0;
        L4:
            if (i >= expired.size()) goto L7;
            final Uptc uptc = expired.valueAt(i);
            this.this$0.getHandler().post(new QuotaTracker$InQuotaAlarmQueue$$ExternalSyntheticLambda1(this, uptc));
            i = i + 1;
            goto L4
        }

        private /* synthetic */ void lambda$processExpiredAlarms$1(Uptc uptc) {
            this.this$0.maybeUpdateQuotaStatus(uptc.userId, uptc.packageName, uptc.tag);
        }
    }

    static class Injector {
        Injector() {
        }

        long getElapsedRealtime() {
            return SystemClock.elapsedRealtime();
        }

        boolean isAlarmManagerReady() {
            return ((SystemServiceManager) LocalServices.getService(SystemServiceManager.class)).isBootCompleted();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7_jWEDO3BU-RIo1JOMCtrF_brqU, reason: not valid java name */
    public static /* synthetic */ void m9278$r8$lambda$7_jWEDO3BURIo1JOMCtrF_brqU(QuotaTracker r0, int r1, long r2, String r4, AlarmManager.OnAlarmListener r5) {
        r0.lambda$scheduleAlarm$0(r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$U4zSWg65aSbW-ydRweJjzvRSa4Q, reason: not valid java name */
    public static /* synthetic */ void m9279$r8$lambda$U4zSWg65aSbWydRweJjzvRSa4Q(QuotaTracker r0, AlarmManager.OnAlarmListener r1) {
        r0.lambda$cancelAlarm$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$gDyWE2X6raWuOUuH3yuUOT3FGxU(QuotaTracker r0, int r1, String r2, String r3) {
        r0.lambda$postQuotaStatusChanged$3(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$zqw0r2J0L3v3iTYTnBHhbM_aIAc(QuotaTracker r0) {
        r0.lambda$scheduleQuotaCheck$2();
    }

    /* JADX INFO: renamed from: -$$Nest$monUserRemovedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9280$$Nest$monUserRemovedLocked(QuotaTracker r0, int r1) {
        r0.onUserRemovedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetALARM_TAG_QUOTA_CHECK, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9281$$Nest$sfgetALARM_TAG_QUOTA_CHECK() {
        return ALARM_TAG_QUOTA_CHECK;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9282$$Nest$sfgetTAG() {
        return TAG;
    }

    abstract void dropEverythingLocked();

    abstract Handler getHandler();

    abstract long getInQuotaTimeElapsedLocked(int r1, String r2, String r3);

    abstract void handleRemovedAppLocked(int r1, String r2);

    abstract void handleRemovedUserLocked(int r1);

    abstract boolean isWithinQuotaLocked(int r1, String r2, String r3);

    abstract void maybeUpdateAllQuotaStatusLocked();

    abstract void maybeUpdateQuotaStatus(int r1, String r2, String r3);

    abstract void onQuotaFreeChangedLocked(int r1, String r2, boolean r3);

    abstract void onQuotaFreeChangedLocked(boolean r1);

    static {
        TAG = QuotaTracker.class.getSimpleName();
        ALARM_TAG_QUOTA_CHECK = SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER + TAG + ".quota_check*";
    }

    QuotaTracker(Context context, Categorizer categorizer, Injector injector) {
        this.mLock = new Object();
        this.mQuotaChangeListeners = new ArraySet();
        this.mFreeQuota = new SparseArrayMap();
        this.mIsEnabled = true;
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mCategorizer = categorizer;
        this.mContext = context;
        this.mInjector = injector;
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        this.mInQuotaAlarmQueue = new InQuotaAlarmQueue(this, this.mContext, FgThread.getHandler().getLooper(), null);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        context.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, BackgroundThread.getHandler());
        IntentFilter userFilter = new IntentFilter("android.intent.action.USER_REMOVED");
        context.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, userFilter, null, BackgroundThread.getHandler());
    }

    public void clear() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInQuotaAlarmQueue.removeAllAlarms();     // Catch: Throwable -> L7
        this.mFreeQuota.clear();     // Catch: Throwable -> L7
        dropEverythingLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isWithinQuota(int userId, String packageName, String tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = isWithinQuotaLocked(userId, packageName, tag);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setQuotaFree(int userId, String packageName, boolean isFree) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean wasFree = ((Boolean) this.mFreeQuota.getOrDefault(userId, packageName, Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L7
        if (wasFree == isFree) goto L9;
        this.mFreeQuota.add(userId, packageName, Boolean.valueOf(isFree));     // Catch: Throwable -> L7
        onQuotaFreeChangedLocked(userId, packageName, isFree);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setQuotaFree(boolean isFree) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsQuotaFree != isFree) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsQuotaFree = isFree;     // Catch: Throwable -> L8
        if (this.mIsEnabled == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        onQuotaFreeChangedLocked(this.mIsQuotaFree);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        scheduleQuotaCheck();
    }

    public void registerQuotaChangeListener(QuotaChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mQuotaChangeListeners.add(listener) == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mQuotaChangeListeners.size() != 1) goto L11;
        scheduleQuotaCheck();     // Catch: Throwable -> L9
        goto L11
    }

    public void unregisterQuotaChangeListener(QuotaChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mQuotaChangeListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setEnabled(boolean enable) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsEnabled != enable) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsEnabled = enable;     // Catch: Throwable -> L8
        if (this.mIsEnabled == true) goto L13;
        clear();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    boolean isEnabledLocked() {
        return this.mIsEnabled;
    }

    boolean isQuotaFreeLocked() {
        return this.mIsQuotaFree;
    }

    boolean isQuotaFreeLocked(int userId, String packageName) {
        if (this.mIsQuotaFree == false) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) this.mFreeQuota.getOrDefault(userId, packageName, Boolean.FALSE)).booleanValue() == true) goto L8;
        return false;
    }

    boolean isIndividualQuotaFreeLocked(int userId, String packageName) {
        return ((Boolean) this.mFreeQuota.getOrDefault(userId, packageName, Boolean.FALSE)).booleanValue();
    }

    void scheduleAlarm(final int type, final long triggerAtMillis, final String tag, final AlarmManager.OnAlarmListener listener) {
        FgThread.getHandler().post(new QuotaTracker$$ExternalSyntheticLambda2(this, type, triggerAtMillis, tag, listener));
    }

    private /* synthetic */ void lambda$scheduleAlarm$0(int type, long triggerAtMillis, String tag, AlarmManager.OnAlarmListener listener) {
        if (this.mInjector.isAlarmManagerReady() == false) goto L5;
        this.mAlarmManager.set(type, triggerAtMillis, tag, listener, getHandler());
        return;
    L5:
        Slog.w(TAG, "Alarm not scheduled because boot isn't completed");
    }

    void cancelAlarm(final AlarmManager.OnAlarmListener listener) {
        FgThread.getHandler().post(new QuotaTracker$$ExternalSyntheticLambda0(this, listener));
    }

    private /* synthetic */ void lambda$cancelAlarm$1(AlarmManager.OnAlarmListener listener) {
        if (this.mInjector.isAlarmManagerReady() == false) goto L5;
        this.mAlarmManager.cancel(listener);
        return;
    L5:
        Slog.w(TAG, "Alarm not cancelled because boot isn't completed");
    }

    void scheduleQuotaCheck() {
        BackgroundThread.getHandler().post(new QuotaTracker$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$scheduleQuotaCheck$2() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mQuotaChangeListeners.size() <= 0) goto L9;
        maybeUpdateAllQuotaStatusLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void onAppRemovedLocked(int userId, String packageName) {
        if (packageName != null) goto L5;
        Slog.wtf(TAG, "Told app removed but given null package name.");
        return;
    L5:
        this.mInQuotaAlarmQueue.removeAlarms(userId, packageName);
        this.mFreeQuota.delete(userId, packageName);
        handleRemovedAppLocked(userId, packageName);
    }

    private void onUserRemovedLocked(int userId) {
        this.mInQuotaAlarmQueue.removeAlarmsForUserId(userId);
        this.mFreeQuota.delete(userId);
        handleRemovedUserLocked(userId);
    }

    void postQuotaStatusChanged(final int userId, final String packageName, final String tag) {
        BackgroundThread.getHandler().post(new QuotaTracker$$ExternalSyntheticLambda1(this, userId, packageName, tag));
    }

    private /* synthetic */ void lambda$postQuotaStatusChanged$3(int userId, String packageName, String tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        QuotaChangeListener[] listeners = (QuotaChangeListener[]) this.mQuotaChangeListeners.toArray(new QuotaChangeListener[this.mQuotaChangeListeners.size()]);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        int r1 = listeners.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        QuotaChangeListener listener = listeners[r2];
        listener.onQuotaStateChanged(userId, packageName, tag);
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void maybeScheduleStartAlarmLocked(int userId, String packageName, String tag) {
        if (this.mQuotaChangeListeners.size() != 0) goto L5;
        return;
    L5:
        Uptc.string(userId, packageName, tag);
        if (isWithinQuota(userId, packageName, tag) == false) goto L9;
        this.mInQuotaAlarmQueue.removeAlarmForKey(new Uptc(userId, packageName, tag));
        maybeUpdateQuotaStatus(userId, packageName, tag);
        return;
    L9:
        this.mInQuotaAlarmQueue.addAlarm(new Uptc(userId, packageName, tag), getInQuotaTimeElapsedLocked(userId, packageName, tag));
    }

    void cancelScheduledStartAlarmLocked(int userId, String packageName, String tag) {
        this.mInQuotaAlarmQueue.removeAlarmForKey(new Uptc(userId, packageName, tag));
    }

    public void dump(IndentingPrintWriter pw) {
        pw.println("QuotaTracker:");
        pw.increaseIndent();
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Is enabled: " + this.mIsEnabled);     // Catch: Throwable -> L11
        pw.println("Is global quota free: " + this.mIsQuotaFree);     // Catch: Throwable -> L11
        pw.println("Current elapsed time: " + this.mInjector.getElapsedRealtime());     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        this.mInQuotaAlarmQueue.dump(pw);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Per-app free quota:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int u = 0;
    L6:
        if (u >= this.mFreeQuota.numMaps()) goto L14;
        int userId = this.mFreeQuota.keyAt(u);     // Catch: Throwable -> L11
        int p = 0;
    L9:
        if (p >= this.mFreeQuota.numElementsForKey(userId)) goto L13;
        String pkgName = (String) this.mFreeQuota.keyAt(u, p);     // Catch: Throwable -> L11
        pw.print(Uptc.string(userId, pkgName, null));     // Catch: Throwable -> L11
        pw.print(": ");     // Catch: Throwable -> L11
        pw.println(this.mFreeQuota.get(userId, pkgName));     // Catch: Throwable -> L11
        p = p + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        u = u + 1;     // Catch: Throwable -> L11
        goto L6
    L14:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        pw.decreaseIndent();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void dump(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        Object r2 = this.mLock;
        monitor-enter(r2);
        proto.write(1133871366145L, this.mIsEnabled);     // Catch: Throwable -> L8
        proto.write(1133871366146L, this.mIsQuotaFree);     // Catch: Throwable -> L8
        proto.write(1112396529667L, this.mInjector.getElapsedRealtime());     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        proto.end(token);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}

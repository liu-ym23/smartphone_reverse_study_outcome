package com.android.server.usage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.usage.UsageStatsManagerInternal;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class AppTimeLimitController {
    private static final boolean DEBUG = false;
    private static final long MAX_OBSERVER_PER_UID = 1000;
    private static final Integer ONE = null;
    private static final long ONE_MINUTE = 60000;
    private static final String TAG = "AppTimeLimitController";
    private AlarmManager mAlarmManager;
    private final Context mContext;
    private final MyHandler mHandler;
    private TimeLimitCallbackListener mListener;
    private final Lock mLock;
    private final SparseArray<ObserverAppData> mObserverApps;
    private final SparseArray<UserData> mUsers;

    class AppUsageGroup extends UsageGroup {
        public AppUsageGroup(AppTimeLimitController this$0, UserData user, ObserverAppData observerApp, int observerId, String[] observed, long timeLimitMs, PendingIntent limitReachedCallback) {
            super(this$0, user, observerApp, observerId, observed, timeLimitMs, limitReachedCallback);
        }

        @Override // com.android.server.usage.AppTimeLimitController.UsageGroup
        public void remove() {
            super.remove();
            ObserverAppData observerApp = this.mObserverAppRef.get();
            if (observerApp == null) goto L6;
            observerApp.removeAppUsageGroup(this.mObserverId);
            return;
        }

        @Override // com.android.server.usage.AppTimeLimitController.UsageGroup
        public void onLimitReached() {
            super.onLimitReached();
            remove();
        }
    }

    class AppUsageLimitGroup extends UsageGroup {
        final /* synthetic */ AppTimeLimitController this$0;

        public AppUsageLimitGroup(AppTimeLimitController this$0, UserData user, ObserverAppData observerApp, int observerId, String[] observed, long timeLimitMs, long timeUsedMs, PendingIntent limitReachedCallback) {
            this.this$0 = this$0;
            super(this$0, user, observerApp, observerId, observed, timeLimitMs, limitReachedCallback);
            this.mUsageTimeMs = timeUsedMs;
        }

        @Override // com.android.server.usage.AppTimeLimitController.UsageGroup
        public void remove() {
            super.remove();
            ObserverAppData observerApp = this.mObserverAppRef.get();
            if (observerApp == null) goto L6;
            observerApp.removeAppUsageLimitGroup(this.mObserverId);
            return;
        }

        long getTotaUsageLimit() {
            return this.mTimeLimitMs;
        }

        long getUsageRemaining() {
            if (this.mActives <= 0) goto L7;
            return (this.mTimeLimitMs - this.mUsageTimeMs) - (this.this$0.getElapsedRealtime() - this.mLastKnownUsageTimeMs);
        L7:
            return this.mTimeLimitMs - this.mUsageTimeMs;
        }
    }

    private static class Lock {
        /* synthetic */ Lock(AppTimeLimitControllerIA r1) {
            this();
        }

        private Lock() {
        }
    }

    private class MyHandler extends Handler {
        static final int MSG_CHECK_TIMEOUT = 1;
        static final int MSG_INFORM_LIMIT_REACHED_LISTENER = 2;
        final /* synthetic */ AppTimeLimitController this$0;

        MyHandler(AppTimeLimitController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L13;
                case 2: goto L5;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L5:
            Lock r0 = AppTimeLimitController.m9087$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            ((UsageGroup) msg.obj).onLimitReached();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            Lock r1 = AppTimeLimitController.m9087$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            ((UsageGroup) msg.obj).checkTimeout(this.this$0.getElapsedRealtime());     // Catch: Throwable -> L18
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        }
    }

    private class ObserverAppData {
        SparseArray<AppUsageGroup> appUsageGroups;
        SparseArray<AppUsageLimitGroup> appUsageLimitGroups;
        SparseArray<SessionUsageGroup> sessionUsageGroups;
        private int uid;

        /* synthetic */ ObserverAppData(AppTimeLimitController r1, int r2, AppTimeLimitControllerIA r3) {
            this(r1, r2);
        }

        private ObserverAppData(AppTimeLimitController r1, int uid) {
            this.appUsageGroups = new SparseArray();
            this.sessionUsageGroups = new SparseArray();
            this.appUsageLimitGroups = new SparseArray();
            this.uid = uid;
        }

        void removeAppUsageGroup(int observerId) {
            this.appUsageGroups.remove(observerId);
        }

        void removeSessionUsageGroup(int observerId) {
            this.sessionUsageGroups.remove(observerId);
        }

        void removeAppUsageLimitGroup(int observerId) {
            this.appUsageLimitGroups.remove(observerId);
        }

        void dump(PrintWriter pw) {
            pw.print(" uid=");
            pw.println(this.uid);
            pw.println("    App Usage Groups:");
            int nAppUsageGroups = this.appUsageGroups.size();
            int i = 0;
        L3:
            if (i >= nAppUsageGroups) goto L5;
            this.appUsageGroups.valueAt(i).dump(pw);
            pw.println();
            i = i + 1;
            goto L3
        L5:
            pw.println("    Session Usage Groups:");
            int nSessionUsageGroups = this.sessionUsageGroups.size();
            int i2 = 0;
        L6:
            if (i2 >= nSessionUsageGroups) goto L8;
            this.sessionUsageGroups.valueAt(i2).dump(pw);
            pw.println();
            i2 = i2 + 1;
            goto L6
        L8:
            pw.println("    App Usage Limit Groups:");
            int nAppUsageLimitGroups = this.appUsageLimitGroups.size();
            int i3 = 0;
        L9:
            if (i3 >= nAppUsageLimitGroups) goto L12;
            this.appUsageLimitGroups.valueAt(i3).dump(pw);
            pw.println();
            i3 = i3 + 1;
            goto L9
        }
    }

    class SessionUsageGroup extends UsageGroup implements AlarmManager.OnAlarmListener {
        private long mNewSessionThresholdMs;
        private PendingIntent mSessionEndCallback;
        final /* synthetic */ AppTimeLimitController this$0;

        public SessionUsageGroup(AppTimeLimitController this$0, UserData user, ObserverAppData observerApp, int observerId, String[] observed, long timeLimitMs, PendingIntent limitReachedCallback, long newSessionThresholdMs, PendingIntent sessionEndCallback) {
            this.this$0 = this$0;
            super(this$0, user, observerApp, observerId, observed, timeLimitMs, limitReachedCallback);
            this.mNewSessionThresholdMs = newSessionThresholdMs;
            this.mSessionEndCallback = sessionEndCallback;
        }

        @Override // com.android.server.usage.AppTimeLimitController.UsageGroup
        public void remove() {
            super.remove();
            ObserverAppData observerApp = this.mObserverAppRef.get();
            if (observerApp == null) goto L5;
            observerApp.removeSessionUsageGroup(this.mObserverId);
        L5:
            this.mSessionEndCallback = null;
        }

        @Override // com.android.server.usage.AppTimeLimitController.UsageGroup
        public void noteUsageStart(long startTimeMs, long currentTimeMs) {
            if (this.mActives == 0) goto L5;
        L8:
            super.noteUsageStart(startTimeMs, currentTimeMs);
            return;
        L5:
            if ((startTimeMs - this.mLastUsageEndTimeMs) <= this.mNewSessionThresholdMs) goto L7;
            this.mUsageTimeMs = 0;
        L7:
            this.this$0.getAlarmManager().cancel(this);
            goto L8
        }

        @Override // com.android.server.usage.AppTimeLimitController.UsageGroup
        public void noteUsageStop(long stopTimeMs) {
            super.noteUsageStop(stopTimeMs);
            if (this.mActives == 0) goto L5;
            return;
        L5:
            if (this.mUsageTimeMs < this.mTimeLimitMs) goto L9;
            this.this$0.getAlarmManager().setExact(3, this.this$0.getElapsedRealtime() + this.mNewSessionThresholdMs, AppTimeLimitController.TAG, this, AppTimeLimitController.m9085$$Nest$fgetmHandler(this.this$0));
            return;
        }

        public void onSessionEnd() {
            UserData user = this.mUserRef.get();
            if (user != null) goto L6;
            return;
        L6:
            if (AppTimeLimitController.m9086$$Nest$fgetmListener(this.this$0) == null) goto L9;
            AppTimeLimitController.m9086$$Nest$fgetmListener(this.this$0).onSessionEnd(this.mObserverId, UserData.m9091$$Nest$fgetuserId(user), this.mUsageTimeMs, this.mSessionEndCallback);
            return;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            Lock r0 = AppTimeLimitController.m9087$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            onSessionEnd();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.usage.AppTimeLimitController.UsageGroup
        void dump(PrintWriter pw) {
            super.dump(pw);
            pw.print(" lastUsageEndTime=");
            pw.print(this.mLastUsageEndTimeMs);
            pw.print(" newSessionThreshold=");
            pw.print(this.mNewSessionThresholdMs);
        }
    }

    public interface TimeLimitCallbackListener {
        void onLimitReached(int r1, int r2, long r3, long r5, PendingIntent r7);

        void onSessionEnd(int r1, int r2, long r3, PendingIntent r5);
    }

    abstract class UsageGroup {
        protected int mActives;
        protected long mLastKnownUsageTimeMs;
        protected long mLastUsageEndTimeMs;
        protected PendingIntent mLimitReachedCallback;
        protected String[] mObserved;
        protected WeakReference<ObserverAppData> mObserverAppRef;
        protected int mObserverId;
        protected long mTimeLimitMs;
        protected long mUsageTimeMs;
        protected WeakReference<UserData> mUserRef;
        final /* synthetic */ AppTimeLimitController this$0;

        UsageGroup(AppTimeLimitController this$0, UserData user, ObserverAppData observerApp, int observerId, String[] observed, long timeLimitMs, PendingIntent limitReachedCallback) {
            this.this$0 = this$0;
            this.mUserRef = new WeakReference(user);
            this.mObserverAppRef = new WeakReference(observerApp);
            this.mObserverId = observerId;
            this.mObserved = observed;
            this.mTimeLimitMs = timeLimitMs;
            this.mLimitReachedCallback = limitReachedCallback;
        }

        public long getTimeLimitMs() {
            return this.mTimeLimitMs;
        }

        public long getUsageTimeMs() {
            return this.mUsageTimeMs;
        }

        public void remove() {
            UserData user = this.mUserRef.get();
            if (user == null) goto L5;
            user.removeUsageGroup(this);
        L5:
            this.mLimitReachedCallback = null;
        }

        void noteUsageStart(long startTimeMs) {
            noteUsageStart(startTimeMs, startTimeMs);
        }

        void noteUsageStart(long startTimeMs, long currentTimeMs) {
            int r0 = this.mActives;
            this.mActives = r0 + 1;
            if (r0 != 0) goto L13;
            if (this.mLastUsageEndTimeMs <= startTimeMs) goto L7;
            long r1 = this.mLastUsageEndTimeMs;
        L8:
            long startTimeMs2 = r1;
            this.mLastKnownUsageTimeMs = startTimeMs2;
            long timeRemaining = ((this.mTimeLimitMs - this.mUsageTimeMs) - currentTimeMs) + startTimeMs2;
            if (timeRemaining <= 0) goto L21;
            AppTimeLimitController.m9089$$Nest$mpostCheckTimeoutLocked(this.this$0, this, timeRemaining);
            return;
        L21:
            return;
        L7:
            r1 = startTimeMs;
            goto L8
        L13:
            if (this.mActives <= this.mObserved.length) goto L19;
            this.mActives = this.mObserved.length;
            UserData user = this.mUserRef.get();
            if (user != null) goto L17;
            return;
        L17:
            Object[] array = user.currentlyActive.keySet().toArray();
            Slog.e(AppTimeLimitController.TAG, "Too many noted usage starts! Observed entities: " + Arrays.toString(this.mObserved) + "   Active Entities: " + Arrays.toString(array));
            return;
        }

        void noteUsageStop(long stopTimeMs) {
            boolean limitNotCrossed = true;
            int r0 = this.mActives - 1;
            this.mActives = r0;
            if (r0 != 0) goto L15;
            if (this.mUsageTimeMs < this.mTimeLimitMs) goto L8;
            limitNotCrossed = false;
        L8:
            this.mUsageTimeMs += stopTimeMs - this.mLastKnownUsageTimeMs;
            this.mLastUsageEndTimeMs = stopTimeMs;
            if (limitNotCrossed == true) goto L11;
        L13:
            AppTimeLimitController.m9088$$Nest$mcancelCheckTimeoutLocked(this.this$0, this);
            return;
        L11:
            if (this.mUsageTimeMs < this.mTimeLimitMs) goto L13;
            AppTimeLimitController.m9090$$Nest$mpostInformLimitReachedListenerLocked(this.this$0, this);
            goto L13
        L15:
            if (this.mActives >= 0) goto L22;
            this.mActives = 0;
            UserData user = this.mUserRef.get();
            if (user != null) goto L19;
            return;
        L19:
            Object[] array = user.currentlyActive.keySet().toArray();
            Slog.e(AppTimeLimitController.TAG, "Too many noted usage stops! Observed entities: " + Arrays.toString(this.mObserved) + "   Active Entities: " + Arrays.toString(array));
            return;
        }

        void checkTimeout(long currentTimeMs) {
            UserData user = this.mUserRef.get();
            if (user != null) goto L5;
            return;
        L5:
            long timeRemainingMs = this.mTimeLimitMs - this.mUsageTimeMs;
            if (timeRemainingMs > 0) goto L9;
            return;
        L9:
            if (user.isActive(this.mObserved) == false) goto L15;
            long timeUsedMs = currentTimeMs - this.mLastKnownUsageTimeMs;
            if (timeRemainingMs > timeUsedMs) goto L13;
            this.mUsageTimeMs += timeUsedMs;
            this.mLastKnownUsageTimeMs = currentTimeMs;
            AppTimeLimitController.m9090$$Nest$mpostInformLimitReachedListenerLocked(this.this$0, this);
            return;
        L13:
            AppTimeLimitController.m9089$$Nest$mpostCheckTimeoutLocked(this.this$0, this, timeRemainingMs - timeUsedMs);
            return;
        }

        public void onLimitReached() {
            UserData user = this.mUserRef.get();
            if (user != null) goto L6;
            return;
        L6:
            if (AppTimeLimitController.m9086$$Nest$fgetmListener(this.this$0) == null) goto L9;
            AppTimeLimitController.m9086$$Nest$fgetmListener(this.this$0).onLimitReached(this.mObserverId, UserData.m9091$$Nest$fgetuserId(user), this.mTimeLimitMs, this.mUsageTimeMs, this.mLimitReachedCallback);
            return;
        }

        void dump(PrintWriter pw) {
            pw.print("        Group id=");
            pw.print(this.mObserverId);
            pw.print(" timeLimit=");
            pw.print(this.mTimeLimitMs);
            pw.print(" used=");
            pw.print(this.mUsageTimeMs);
            pw.print(" lastKnownUsage=");
            pw.print(this.mLastKnownUsageTimeMs);
            pw.print(" mActives=");
            pw.print(this.mActives);
            pw.print(" observed=");
            pw.print(Arrays.toString(this.mObserved));
        }
    }

    private class UserData {
        public final ArrayMap<String, Integer> currentlyActive;
        public final ArrayMap<String, ArrayList<UsageGroup>> observedMap;
        private int userId;

        /* JADX INFO: renamed from: -$$Nest$fgetuserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9091$$Nest$fgetuserId(UserData r0) {
            return r0.userId;
        }

        /* synthetic */ UserData(AppTimeLimitController r1, int r2, AppTimeLimitControllerIA r3) {
            this(r1, r2);
        }

        private UserData(AppTimeLimitController r1, int userId) {
            this.currentlyActive = new ArrayMap();
            this.observedMap = new ArrayMap();
            this.userId = userId;
        }

        boolean isActive(String[] entities) {
            int size = entities.length;
            int i = 0;
        L3:
            if (i >= size) goto L9;
            if (this.currentlyActive.containsKey(entities[i]) == true) goto L6;
            i = i + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        void addUsageGroup(UsageGroup group) {
            int size = group.mObserved.length;
            int i = 0;
        L3:
            if (i >= size) goto L9;
            ArrayList<UsageGroup> list = this.observedMap.get(group.mObserved[i]);
            if (list != null) goto L7;
            list = new ArrayList();
            this.observedMap.put(group.mObserved[i], list);
        L7:
            list.add(group);
            i = i + 1;
            goto L3
        }

        void removeUsageGroup(UsageGroup group) {
            int size = group.mObserved.length;
            int i = 0;
        L3:
            if (i >= size) goto L11;
            String observed = group.mObserved[i];
            ArrayList<UsageGroup> list = this.observedMap.get(observed);
            if (list == null) goto L9;
            list.remove(group);
            if (list.isEmpty() == false) goto L9;
            this.observedMap.remove(observed);
        L9:
            i = i + 1;
            goto L3
        }

        void dump(PrintWriter pw) {
            pw.print(" userId=");
            pw.println(this.userId);
            pw.print(" Currently Active:");
            int nActive = this.currentlyActive.size();
            int i = 0;
        L4:
            if (i >= nActive) goto L6;
            pw.print(this.currentlyActive.keyAt(i));
            pw.print(", ");
            i = i + 1;
            goto L4
        L6:
            pw.println();
            pw.print(" Observed Entities:");
            int nEntities = this.observedMap.size();
            int i2 = 0;
        L7:
            if (i2 >= nEntities) goto L9;
            pw.print(this.observedMap.keyAt(i2));
            pw.print(", ");
            i2 = i2 + 1;
            goto L7
        L9:
            pw.println();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MyHandler m9085$$Nest$fgetmHandler(AppTimeLimitController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ TimeLimitCallbackListener m9086$$Nest$fgetmListener(AppTimeLimitController r0) {
        return r0.mListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Lock m9087$$Nest$fgetmLock(AppTimeLimitController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelCheckTimeoutLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9088$$Nest$mcancelCheckTimeoutLocked(AppTimeLimitController r0, UsageGroup r1) {
        r0.cancelCheckTimeoutLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostCheckTimeoutLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9089$$Nest$mpostCheckTimeoutLocked(AppTimeLimitController r0, UsageGroup r1, long r2) {
        r0.postCheckTimeoutLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostInformLimitReachedListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9090$$Nest$mpostInformLimitReachedListenerLocked(AppTimeLimitController r0, UsageGroup r1) {
        r0.postInformLimitReachedListenerLocked(r1);
    }

    static {
        ONE = new Integer(1);
    }

    public AppTimeLimitController(Context context, TimeLimitCallbackListener listener, Looper looper) {
        this.mLock = new Lock(null);
        this.mUsers = new SparseArray();
        this.mObserverApps = new SparseArray();
        this.mContext = context;
        this.mHandler = new MyHandler(this, looper);
        this.mListener = listener;
    }

    protected AlarmManager getAlarmManager() {
        if (this.mAlarmManager != null) goto L6;
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
    L6:
        return this.mAlarmManager;
    }

    protected long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    protected long getAppUsageObserverPerUidLimit() {
        return 1000;
    }

    protected long getUsageSessionObserverPerUidLimit() {
        return 1000;
    }

    protected long getAppUsageLimitObserverPerUidLimit() {
        return 1000;
    }

    protected long getMinTimeLimit() {
        return 60000;
    }

    AppUsageGroup getAppUsageGroup(int observerAppUid, int observerId) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        AppUsageGroup r1 = getOrCreateObserverAppDataLocked(observerAppUid).appUsageGroups.get(observerId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    SessionUsageGroup getSessionUsageGroup(int observerAppUid, int observerId) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        SessionUsageGroup r1 = getOrCreateObserverAppDataLocked(observerAppUid).sessionUsageGroups.get(observerId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    AppUsageLimitGroup getAppUsageLimitGroup(int observerAppUid, int observerId) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        AppUsageLimitGroup r1 = getOrCreateObserverAppDataLocked(observerAppUid).appUsageLimitGroups.get(observerId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public UsageStatsManagerInternal.AppUsageLimitData getAppUsageLimit(String packageName, UserHandle user) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        UserData userData = getOrCreateUserDataLocked(user.getIdentifier());     // Catch: Throwable -> L8
        if (userData != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        ArrayList<UsageGroup> usageGroups = userData.observedMap.get(packageName);     // Catch: Throwable -> L8
        if (usageGroups == null) goto L42;
        if (usageGroups.isEmpty() == true) goto L42;
        ArraySet<AppUsageLimitGroup> usageLimitGroups = new ArraySet();     // Catch: Throwable -> L8
        int i = 0;
    L17:
        if (i >= usageGroups.size()) goto L29;
        if ((usageGroups.get(i) instanceof AppUsageLimitGroup) == false) goto L27;
        AppUsageLimitGroup group = (AppUsageLimitGroup) usageGroups.get(i);     // Catch: Throwable -> L8
        int j = 0;
    L22:
        if (j >= group.mObserved.length) goto L27;
        if (group.mObserved[j].equals(packageName) == true) goto L25;
        j = j + 1;     // Catch: Throwable -> L8
        goto L22
    L25:
        usageLimitGroups.add(group);     // Catch: Throwable -> L8
    L27:
        i = i + 1;     // Catch: Throwable -> L8
        goto L17
    L29:
        if (usageLimitGroups.isEmpty() == false) goto L32;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L32:
        AppUsageLimitGroup smallestGroup = usageLimitGroups.valueAt(0);     // Catch: Throwable -> L8
        int i2 = 1;
    L34:
        if (i2 >= usageLimitGroups.size()) goto L39;
        AppUsageLimitGroup otherGroup = usageLimitGroups.valueAt(i2);     // Catch: Throwable -> L8
        if (otherGroup.getUsageRemaining() >= smallestGroup.getUsageRemaining()) goto L38;
        smallestGroup = otherGroup;
    L38:
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L34
    L39:
        UsageStatsManagerInternal.AppUsageLimitData r5 = new UsageStatsManagerInternal.AppUsageLimitData(smallestGroup.getTotaUsageLimit(), smallestGroup.getUsageRemaining());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r5;
    L42:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    private UserData getOrCreateUserDataLocked(int userId) {
        UserData userData = this.mUsers.get(userId);
        if (userData != null) goto L6;
        UserData userData2 = new UserData(this, userId, null);
        this.mUsers.put(userId, userData2);
        return userData2;
    L6:
        return userData;
    }

    private ObserverAppData getOrCreateObserverAppDataLocked(int uid) {
        ObserverAppData appData = this.mObserverApps.get(uid);
        if (appData != null) goto L6;
        ObserverAppData appData2 = new ObserverAppData(this, uid, null);
        this.mObserverApps.put(uid, appData2);
        return appData2;
    L6:
        return appData;
    }

    public void onUserRemoved(int userId) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        this.mUsers.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void noteActiveLocked(UserData user, UsageGroup group, long currentTimeMs) {
        int size = group.mObserved.length;
        int i = 0;
    L3:
        if (i >= size) goto L9;
        if (user.currentlyActive.containsKey(group.mObserved[i]) == false) goto L7;
        group.noteUsageStart(currentTimeMs);
    L7:
        i = i + 1;
        goto L3
    }

    public void addAppUsageObserver(int requestingUid, int observerId, String[] observed, long timeLimit, PendingIntent callbackIntent, int userId) {
        if (timeLimit < getMinTimeLimit()) goto L22;
        Lock r1 = this.mLock;
        monitor-enter(r1);
        UserData user = getOrCreateUserDataLocked(userId);     // Catch: Throwable -> L10
        ObserverAppData observerApp = getOrCreateObserverAppDataLocked(requestingUid);     // Catch: Throwable -> L10
        AppUsageGroup group = observerApp.appUsageGroups.get(observerId);     // Catch: Throwable -> L10
        if (group == null) goto L12;
        group.remove();     // Catch: Throwable -> L10
    L12:
        int observerIdCount = observerApp.appUsageGroups.size();     // Catch: Throwable -> L10
        if (observerIdCount >= getAppUsageObserverPerUidLimit()) goto L18;
        AppUsageGroup group2 = new AppUsageGroup(this, user, observerApp, observerId, observed, timeLimit, callbackIntent);     // Catch: Throwable -> L10
        observerApp.appUsageGroups.append(observerId, group2);     // Catch: Throwable -> L10
        user.addUsageGroup(group2);     // Catch: Throwable -> L10
        noteActiveLocked(user, group2, getElapsedRealtime());     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L18:
        throw new IllegalStateException("Too many app usage observers added by uid " + requestingUid);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L22:
        throw new IllegalArgumentException("Time limit must be >= " + getMinTimeLimit());
    }

    public void removeAppUsageObserver(int requestingUid, int observerId, int userId) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        ObserverAppData observerApp = getOrCreateObserverAppDataLocked(requestingUid);     // Catch: Throwable -> L7
        AppUsageGroup group = observerApp.appUsageGroups.get(observerId);     // Catch: Throwable -> L7
        if (group == null) goto L9;
        group.remove();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addUsageSessionObserver(int requestingUid, int observerId, String[] observed, long timeLimit, long sessionThresholdTime, PendingIntent limitReachedCallbackIntent, PendingIntent sessionEndCallbackIntent, int userId) {
        if (timeLimit < getMinTimeLimit()) goto L25;
        Lock r12 = this.mLock;
        monitor-enter(r12);
        UserData user = getOrCreateUserDataLocked(userId);     // Catch: Throwable -> L10
        ObserverAppData observerApp = getOrCreateObserverAppDataLocked(requestingUid);     // Catch: Throwable -> L10
        SessionUsageGroup group = observerApp.sessionUsageGroups.get(observerId);     // Catch: Throwable -> L10
        if (group == null) goto L12;
        group.remove();     // Catch: Throwable -> L10
    L12:
        int observerIdCount = observerApp.sessionUsageGroups.size();     // Catch: Throwable -> L10
        if (observerIdCount >= getUsageSessionObserverPerUidLimit()) goto L17;
        SessionUsageGroup group2 = new SessionUsageGroup(this, user, observerApp, observerId, observed, timeLimit, limitReachedCallbackIntent, sessionThresholdTime, sessionEndCallbackIntent);     // Catch: Throwable -> L10
        observerApp.sessionUsageGroups.append(observerId, group2);     // Catch: Throwable -> L10
        user.addUsageGroup(group2);     // Catch: Throwable -> L10
        noteActiveLocked(user, group2, getElapsedRealtime());     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L17:
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L10
        r5.append("Too many app usage observers added by uid ");     // Catch: Throwable -> L10
        r5.append(requestingUid);     // Catch: Throwable -> L21
        throw new IllegalStateException(r5.toString());     // Catch: Throwable -> L21
    L21:
        th = th;
    L22:
        monitor-exit(r12);     // Catch: Throwable -> L21
        throw th;
    L10:
        th = th;
        goto L22
    L25:
        throw new IllegalArgumentException("Time limit must be >= " + getMinTimeLimit());
    }

    public void removeUsageSessionObserver(int requestingUid, int observerId, int userId) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        ObserverAppData observerApp = getOrCreateObserverAppDataLocked(requestingUid);     // Catch: Throwable -> L7
        SessionUsageGroup group = observerApp.sessionUsageGroups.get(observerId);     // Catch: Throwable -> L7
        if (group == null) goto L9;
        group.remove();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAppUsageLimitObserver(int requestingUid, int observerId, String[] observed, long timeLimit, long timeUsed, PendingIntent callbackIntent, int userId) {
        if (timeLimit < getMinTimeLimit()) goto L29;
        Lock r11 = this.mLock;
        monitor-enter(r11);
        UserData user = getOrCreateUserDataLocked(userId);     // Catch: Throwable -> L10
        ObserverAppData observerApp = getOrCreateObserverAppDataLocked(requestingUid);     // Catch: Throwable -> L10
        AppUsageLimitGroup group = observerApp.appUsageLimitGroups.get(observerId);     // Catch: Throwable -> L10
        if (group == null) goto L12;
        group.remove();     // Catch: Throwable -> L10
    L12:
        int observerIdCount = observerApp.appUsageLimitGroups.size();     // Catch: Throwable -> L10
        if (observerIdCount < getAppUsageLimitObserverPerUidLimit()) goto L15;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L10
        r5.append("Too many app usage observers added by uid ");     // Catch: Throwable -> L10
        r5.append(requestingUid);     // Catch: Throwable -> L25
        throw new IllegalStateException(r5.toString());     // Catch: Throwable -> L25
    L15:
        if (timeUsed < timeLimit) goto L17;
        PendingIntent r10 = null;
    L18:
        AppUsageLimitGroup group2 = new AppUsageLimitGroup(this, user, observerApp, observerId, observed, timeLimit, timeUsed, r10);     // Catch: Throwable -> L10
        observerApp.appUsageLimitGroups.append(observerId, group2);     // Catch: Throwable -> L10
        user.addUsageGroup(group2);     // Catch: Throwable -> L10
        noteActiveLocked(user, group2, getElapsedRealtime());     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L17:
        r10 = callbackIntent;
    L10:
        th = th;
    L26:
        monitor-exit(r11);     // Catch: Throwable -> L25
        throw th;
    L25:
        th = th;
        goto L26
    L29:
        throw new IllegalArgumentException("Time limit must be >= " + getMinTimeLimit());
    }

    public void removeAppUsageLimitObserver(int requestingUid, int observerId, int userId) {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        ObserverAppData observerApp = getOrCreateObserverAppDataLocked(requestingUid);     // Catch: Throwable -> L7
        AppUsageLimitGroup group = observerApp.appUsageLimitGroups.get(observerId);     // Catch: Throwable -> L7
        if (group == null) goto L9;
        group.remove();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteUsageStart(String name, int userId, long timeAgoMs) throws IllegalArgumentException {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        UserData user = getOrCreateUserDataLocked(userId);     // Catch: Throwable -> L11
        int index = user.currentlyActive.indexOfKey(name);     // Catch: Throwable -> L11
        if (index < 0) goto L13;
        Integer count = user.currentlyActive.valueAt(index);     // Catch: Throwable -> L11
        if (count == null) goto L13;
        user.currentlyActive.setValueAt(index, Integer.valueOf(count.intValue() + 1));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        long currentTime = getElapsedRealtime();     // Catch: Throwable -> L11
        user.currentlyActive.put(name, ONE);     // Catch: Throwable -> L11
        ArrayList<UsageGroup> groups = user.observedMap.get(name);     // Catch: Throwable -> L11
        if (groups != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L17:
        int size = groups.size();     // Catch: Throwable -> L11
        int i = 0;
    L18:
        if (i >= size) goto L21;
        UsageGroup group = groups.get(i);     // Catch: Throwable -> L11
        group.noteUsageStart(currentTime - timeAgoMs, currentTime);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L18
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void noteUsageStart(String name, int userId) throws IllegalArgumentException {
        noteUsageStart(name, userId, 0);
    }

    public void noteUsageStop(String name, int userId) throws IllegalArgumentException {
        Lock r0 = this.mLock;
        monitor-enter(r0);
        UserData user = getOrCreateUserDataLocked(userId);     // Catch: Throwable -> L11
        int index = user.currentlyActive.indexOfKey(name);     // Catch: Throwable -> L11
        if (index < 0) goto L24;
        Integer count = user.currentlyActive.valueAt(index);     // Catch: Throwable -> L11
        if (count.equals(ONE) == true) goto L13;
        user.currentlyActive.setValueAt(index, Integer.valueOf(count.intValue() - 1));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        user.currentlyActive.removeAt(index);     // Catch: Throwable -> L11
        long currentTime = getElapsedRealtime();     // Catch: Throwable -> L11
        ArrayList<UsageGroup> groups = user.observedMap.get(name);     // Catch: Throwable -> L11
        if (groups != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L17:
        int size = groups.size();     // Catch: Throwable -> L11
        int i = 0;
    L18:
        if (i >= size) goto L21;
        UsageGroup group = groups.get(i);     // Catch: Throwable -> L11
        group.noteUsageStop(currentTime);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L18
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L24:
        throw new IllegalArgumentException("Unable to stop usage for " + name + ", not in use");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void postInformLimitReachedListenerLocked(UsageGroup group) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, group));
    }

    private void postCheckTimeoutLocked(UsageGroup group, long timeout) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, group), timeout);
    }

    private void cancelCheckTimeoutLocked(UsageGroup group) {
        this.mHandler.removeMessages(1, group);
    }

    void dump(String[] args, PrintWriter pw) {
        if (args == null) goto L24;
        int i = 0;
    L5:
        if (i >= args.length) goto L24;
        String arg = args[i];
        if ("actives".equals(arg) == true) goto L8;
        i = i + 1;
        goto L5
    L8:
        Lock r2 = this.mLock;
        monitor-enter(r2);
        int nUsers = this.mUsers.size();     // Catch: Throwable -> L15
        int user = 0;
    L11:
        if (user >= nUsers) goto L19;
        ArrayMap<String, Integer> actives = this.mUsers.valueAt(user).currentlyActive;     // Catch: Throwable -> L15
        int nActive = actives.size();     // Catch: Throwable -> L15
        int active = 0;
    L13:
        if (active >= nActive) goto L17;
        pw.println(actives.keyAt(active));     // Catch: Throwable -> L15
        active = active + 1;     // Catch: Throwable -> L15
        goto L13
    L17:
        user = user + 1;     // Catch: Throwable -> L15
        goto L11
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L24:
        Lock r0 = this.mLock;
        monitor-enter(r0);
        pw.println("\n  App Time Limits");     // Catch: Throwable -> L29
        int nUsers2 = this.mUsers.size();     // Catch: Throwable -> L29
        int i2 = 0;
    L27:
        if (i2 >= nUsers2) goto L31;
        pw.print("   User ");     // Catch: Throwable -> L29
        this.mUsers.valueAt(i2).dump(pw);     // Catch: Throwable -> L29
        i2 = i2 + 1;     // Catch: Throwable -> L29
        goto L27
    L31:
        pw.println();     // Catch: Throwable -> L29
        int nObserverApps = this.mObserverApps.size();     // Catch: Throwable -> L29
        int i3 = 0;
    L32:
        if (i3 >= nObserverApps) goto L35;
        pw.print("   Observer App ");     // Catch: Throwable -> L29
        this.mObserverApps.valueAt(i3).dump(pw);     // Catch: Throwable -> L29
        i3 = i3 + 1;     // Catch: Throwable -> L29
        goto L32
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }
}

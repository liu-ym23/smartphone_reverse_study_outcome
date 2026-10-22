package com.android.server.am;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.TimeUtils;
import com.android.internal.app.ProcessMap;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.am.BaseAppStateTimeSlotEventsTracker.BaseAppStateTimeSlotEventsPolicy;
import com.android.server.am.BaseAppStateTimeSlotEventsTracker.SimpleAppStateTimeslotEvents;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseAppStateTimeSlotEventsTracker<T extends BaseAppStateTimeSlotEventsPolicy, U extends SimpleAppStateTimeslotEvents> extends BaseAppStateEventsTracker<T, U> {
    static final boolean DEBUG_APP_STATE_TIME_SLOT_EVENT_TRACKER = false;
    static final String TAG = "BaseAppStateTimeSlotEventsTracker";
    private H mHandler;
    private final ArrayMap<U, Integer> mTmpPkgs;

    static class BaseAppStateTimeSlotEventsPolicy<E extends BaseAppStateTimeSlotEventsTracker> extends BaseAppStateEventsTracker.BaseAppStateEventsPolicy<E> {
        final int mDefaultNumOfEventsThreshold;
        private final ProcessMap<Long> mExcessiveEventPkgs;
        final String mKeyNumOfEventsThreshold;
        private final Object mLock;
        volatile int mNumOfEventsThreshold;
        long mTimeSlotSize;

        public static /* synthetic */ void $r8$lambda$kd2ZnF50Kq1e96018ClxXCBOF9w(BaseAppStateTimeSlotEventsTracker r0) {
            BaseAppStateTimeSlotEventsTracker.m1388$$Nest$mtrimEvents(r0);
        }

        BaseAppStateTimeSlotEventsPolicy(BaseAppStateTracker.Injector injector, E tracker, String keyTrackerEnabled, boolean defaultTrackerEnabled, String keyMaxTrackingDuration, long defaultMaxTrackingDuration, String keyNumOfEventsThreshold, int defaultNumOfEventsThreshold) {
            super(injector, tracker, keyTrackerEnabled, defaultTrackerEnabled, keyMaxTrackingDuration, defaultMaxTrackingDuration);
            this.mExcessiveEventPkgs = new ProcessMap();
            this.mTimeSlotSize = HeartbeatStats.MAX_NAT_TIME_MS;
            this.mKeyNumOfEventsThreshold = keyNumOfEventsThreshold;
            this.mDefaultNumOfEventsThreshold = defaultNumOfEventsThreshold;
            this.mLock = tracker.mLock;
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        public void onSystemReady() {
            super.onSystemReady();
            updateNumOfEventsThreshold();
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        public void onPropertiesChanged(String name) {
            if (this.mKeyNumOfEventsThreshold.equals(name) == false) goto L5;
            updateNumOfEventsThreshold();
            return;
        L5:
            super.onPropertiesChanged(name);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onTrackerEnabled(boolean enabled) {
            ((BaseAppStateTimeSlotEventsTracker) this.mTracker).onMonitorEnabled(enabled);
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy
        public void onMaxTrackingDurationChanged(long maxDuration) {
            Handler r0 = ((BaseAppStateTimeSlotEventsTracker) this.mTracker).mBgHandler;
            final BaseAppStateTimeSlotEventsTracker r1 = (BaseAppStateTimeSlotEventsTracker) this.mTracker;
            r1.getClass();
            r0.post(new BaseAppStateTimeSlotEventsTracker$BaseAppStateTimeSlotEventsPolicy$$ExternalSyntheticLambda0(r1));
        }

        private void updateNumOfEventsThreshold() {
            int threshold = DeviceConfig.getInt("activity_manager", this.mKeyNumOfEventsThreshold, this.mDefaultNumOfEventsThreshold);
            if (threshold == this.mNumOfEventsThreshold) goto L6;
            this.mNumOfEventsThreshold = threshold;
            ((BaseAppStateTimeSlotEventsTracker) this.mTracker).onNumOfEventsThresholdChanged(threshold);
            return;
        }

        int getNumOfEventsThreshold() {
            return this.mNumOfEventsThreshold;
        }

        long getTimeSlotSize() {
            return this.mTimeSlotSize;
        }

        void setTimeSlotSize(long size) {
            this.mTimeSlotSize = size;
        }

        String getEventName() {
            return "event";
        }

        void onExcessiveEvents(String packageName, int uid, int numOfEvents, long now) {
            boolean notifyController = false;
            Object r1 = this.mLock;
            monitor-enter(r1);
            Long ts = (Long) this.mExcessiveEventPkgs.get(packageName, uid);     // Catch: Throwable -> L7
            if (ts != null) goto L9;
            this.mExcessiveEventPkgs.put(packageName, uid, Long.valueOf(now));     // Catch: Throwable -> L7
            notifyController = true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (notifyController == false) goto L17;
            ((BaseAppStateTimeSlotEventsTracker) this.mTracker).mAppRestrictionController.refreshAppRestrictionLevelForUid(uid, 1536, 2, true);
            return;
        L17:
            return;
        L7:
            th = move-exception;
            throw th;
        }

        int shouldExempt(String packageName, int uid) {
            if (((BaseAppStateTimeSlotEventsTracker) this.mTracker).isUidOnTop(uid) == false) goto L7;
            return 12;
        L7:
            if (((BaseAppStateTimeSlotEventsTracker) this.mTracker).mAppRestrictionController.hasForegroundServices(packageName, uid) == false) goto L10;
            return 14;
        L10:
            int reason = shouldExemptUid(uid);
            if (reason == (-1)) goto L13;
            return reason;
        L13:
            return -1;
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public int getProposedRestrictionLevel(String packageName, int uid, int maxLevel) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mExcessiveEventPkgs.get(packageName, uid) != null) goto L7;
        L12:
            int level = 30;
        L14:
            if (maxLevel <= 40) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return level;
        L17:
            if (maxLevel != 40) goto L20;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return 30;
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return 0;
        L7:
            if (((BaseAppStateTimeSlotEventsTracker) this.mTracker).mAppRestrictionController.isAutoRestrictAbusiveAppEnabled() == false) goto L12;
            level = 40;
            goto L14
        }

        void onUserInteractionStarted(String packageName, int uid) {
            Object r1 = this.mLock;
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mExcessiveEventPkgs.remove(packageName, uid) == null) goto L7;
            boolean r2 = true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            ((BaseAppStateTimeSlotEventsTracker) this.mTracker).mAppRestrictionController.refreshAppRestrictionLevelForUid(uid, 768, 3, true);
            return;
        L7:
            r2 = false;
            goto L9
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        void dump(PrintWriter pw, String prefix) {
            super.dump(pw, prefix);
            if (isEnabled() == false) goto L5;
            pw.print(prefix);
            pw.print(this.mKeyNumOfEventsThreshold);
            pw.print('=');
            pw.println(this.mNumOfEventsThreshold);
        L5:
            pw.print(prefix);
            pw.print("event_time_slot_size=");
            pw.println(getTimeSlotSize());
        }
    }

    static class H extends Handler {
        static final int MSG_NEW_EVENT = 0;
        final BaseAppStateTimeSlotEventsTracker mTracker;

        H(BaseAppStateTimeSlotEventsTracker tracker) {
            super(tracker.mBgHandler.getLooper());
            this.mTracker = tracker;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L5;
                default: goto L7;
            };
        L5:
            this.mTracker.handleNewEvent((String) msg.obj, msg.arg1);
            return;
        }
    }

    static class SimpleAppStateTimeslotEvents extends BaseAppStateTimeSlotEvents {
        static final int DEFAULT_INDEX = 0;
        static final long DEFAULT_TIME_SLOT_SIZE = 900000;
        static final long DEFAULT_TIME_SLOT_SIZE_DEBUG = 60000;

        SimpleAppStateTimeslotEvents(int uid, String packageName, long timeslotSize, String tag, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
            super(uid, packageName, 1, timeslotSize, tag, maxTrackingDurationConfig);
        }

        SimpleAppStateTimeslotEvents(SimpleAppStateTimeslotEvents other) {
            super(other);
        }

        @Override // com.android.server.am.BaseAppStateEvents
        String formatEventTypeLabel(int index) {
            return "";
        }

        @Override // com.android.server.am.BaseAppStateEvents
        String formatEventSummary(long now, int index) {
            if (this.mEvents[0] == null) goto L10;
            if (this.mEvents[0].size() == 0) goto L12;
            int total = getTotalEvents(now, 0);
            return "total=" + total + ", latest=" + getTotalEventsSince(this.mCurSlotStartTime[0], now, 0) + "(slot=" + TimeUtils.formatTime(this.mCurSlotStartTime[0], now) + ")";
        L12:
            return "(none)";
        L10:
            return "(none)";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mtrimEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1388$$Nest$mtrimEvents(BaseAppStateTimeSlotEventsTracker r0) {
        r0.trimEvents();
    }

    BaseAppStateTimeSlotEventsTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<T>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mTmpPkgs = new ArrayMap();
        this.mHandler = new H(this);
    }

    void onNewEvent(String packageName, int uid) {
        this.mHandler.obtainMessage(0, uid, 0, packageName).sendToTarget();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void handleNewEvent(String packageName, int uid) {
        if (((BaseAppStateTimeSlotEventsPolicy) this.mInjector.getPolicy()).shouldExempt(packageName, uid) == (-1)) goto L5;
        return;
    L5:
        long now = SystemClock.elapsedRealtime();
        Object r2 = this.mLock;
        monitor-enter(r2);
        SimpleAppStateTimeslotEvents r0 = (SimpleAppStateTimeslotEvents) this.mPkgEvents.get(uid, packageName);     // Catch: Throwable -> L23
        if (r0 == null) goto L33;
    L13:
        boolean r3 = false;
        r0.addEvent(now, 0);     // Catch: Throwable -> L23
        int totalEvents = r0.getTotalEvents(now, 0);     // Catch: Throwable -> L23
        if (totalEvents < ((BaseAppStateTimeSlotEventsPolicy) this.mInjector.getPolicy()).getNumOfEventsThreshold()) goto L17;
        r3 = true;
    L17:
        boolean notify = r3;
        monitor-exit(r2);     // Catch: Throwable -> L23
        if (notify == false) goto L22;
        ((BaseAppStateTimeSlotEventsPolicy) this.mInjector.getPolicy()).onExcessiveEvents(packageName, uid, totalEvents, now);
        return;
    L22:
        return;
    L33:
        r0 = createAppStateEvents(uid, packageName);     // Catch: Throwable -> L11
        this.mPkgEvents.put(uid, packageName, r0);     // Catch: Throwable -> L11
    L11:
        th = th;
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L27
        throw th;
    L27:
        th = th;
    L23:
        th = th;
        goto L31
    }

    void onMonitorEnabled(boolean enabled) {
        if (enabled == true) goto L11;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPkgEvents.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onNumOfEventsThresholdChanged(int r12) {
        long r4 = SystemClock.elapsedRealtime();
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseArray r0 = this.mPkgEvents.getMap();     // Catch: Throwable -> L11
        int r2 = r0.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (r2 < 0) goto L16;
        ArrayMap r3 = (ArrayMap) r0.valueAt(r2);     // Catch: Throwable -> L11
        int r6 = r3.size() - 1;     // Catch: Throwable -> L11
    L7:
        if (r6 < 0) goto L14;
        SimpleAppStateTimeslotEvents r7 = (SimpleAppStateTimeslotEvents) r3.valueAt(r6);     // Catch: Throwable -> L11
        int r8 = r7.getTotalEvents(r4, 0);     // Catch: Throwable -> L11
        if (r8 < r12) goto L13;
        this.mTmpPkgs.put(r7, Integer.valueOf(r8));     // Catch: Throwable -> L11
    L13:
        r6 = r6 - 1;     // Catch: Throwable -> L11
        goto L7
    L14:
        r2 = r2 - 1;     // Catch: Throwable -> L11
        goto L5
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        int r9 = this.mTmpPkgs.size() - 1;
    L18:
        if (r9 < 0) goto L20;
        U r10 = this.mTmpPkgs.keyAt(r9);
        ((BaseAppStateTimeSlotEventsPolicy) this.mInjector.getPolicy()).onExcessiveEvents(r10.mPackageName, r10.mUid, this.mTmpPkgs.valueAt(r9).intValue(), r4);
        r9 = r9 - 1;
        goto L18
    L20:
        this.mTmpPkgs.clear();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    int getTotalEventsLocked(int uid, long now) {
        U events = getUidEventsLocked(uid);
        if (events != null) goto L6;
        return 0;
    L6:
        return events.getTotalEvents(now, 0);
    }

    private void trimEvents() {
        long now = SystemClock.elapsedRealtime();
        trim(Math.max(0, now - ((BaseAppStateTimeSlotEventsPolicy) this.mInjector.getPolicy()).getMaxTrackingDuration()));
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUserInteractionStarted(String packageName, int uid) {
        ((BaseAppStateTimeSlotEventsPolicy) this.mInjector.getPolicy()).onUserInteractionStarted(packageName, uid);
    }
}

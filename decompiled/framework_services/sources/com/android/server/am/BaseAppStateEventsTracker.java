package com.android.server.am;

import android.content.Context;
import android.os.PowerExemptionManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import com.android.server.am.BaseAppStateEvents;
import com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseAppStateEventsTracker<T extends BaseAppStateEventsPolicy, U extends BaseAppStateEvents> extends BaseAppStateTracker<T> implements BaseAppStateEvents.Factory<U> {
    static final boolean DEBUG_BASE_APP_STATE_EVENTS_TRACKER = false;
    final UidProcessMap<U> mPkgEvents;
    final ArraySet<Integer> mTopUids;

    static abstract class BaseAppStateEventsPolicy<V extends BaseAppStateEventsTracker> extends BaseAppStatePolicy<V> implements BaseAppStateEvents.MaxTrackingDurationConfig {
        final long mDefaultMaxTrackingDuration;
        final String mKeyMaxTrackingDuration;
        volatile long mMaxTrackingDuration;

        public abstract void onMaxTrackingDurationChanged(long r1);

        BaseAppStateEventsPolicy(BaseAppStateTracker.Injector<?> injector, V tracker, String keyTrackerEnabled, boolean defaultTrackerEnabled, String keyMaxTrackingDuration, long defaultMaxTrackingDuration) {
            super(injector, tracker, keyTrackerEnabled, defaultTrackerEnabled);
            this.mKeyMaxTrackingDuration = keyMaxTrackingDuration;
            this.mDefaultMaxTrackingDuration = defaultMaxTrackingDuration;
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onPropertiesChanged(String name) {
            if (this.mKeyMaxTrackingDuration.equals(name) == false) goto L5;
            updateMaxTrackingDuration();
            return;
        L5:
            super.onPropertiesChanged(name);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onSystemReady() {
            super.onSystemReady();
            updateMaxTrackingDuration();
        }

        void updateMaxTrackingDuration() {
            long max = DeviceConfig.getLong("activity_manager", this.mKeyMaxTrackingDuration, this.mDefaultMaxTrackingDuration);
            if (max == this.mMaxTrackingDuration) goto L6;
            this.mMaxTrackingDuration = max;
            onMaxTrackingDurationChanged(max);
            return;
        }

        @Override // com.android.server.am.BaseAppStateEvents.MaxTrackingDurationConfig
        public long getMaxTrackingDuration() {
            return this.mMaxTrackingDuration;
        }

        String getExemptionReasonString(String packageName, int uid, int reason) {
            return PowerExemptionManager.reasonCodeToString(reason);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        void dump(PrintWriter pw, String prefix) {
            super.dump(pw, prefix);
            if (isEnabled() == false) goto L6;
            pw.print(prefix);
            pw.print(this.mKeyMaxTrackingDuration);
            pw.print('=');
            pw.println(this.mMaxTrackingDuration);
            return;
        }
    }

    static class SimplePackageEvents extends BaseAppStateTimeEvents {
        static final int DEFAULT_INDEX = 0;

        /* JADX WARN: Multi-variable type inference failed */
        SimplePackageEvents(int uid, String packageName, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
            super(uid, packageName, 1, "ActivityManager", maxTrackingDurationConfig);
            this.mEvents[0] = new LinkedList();
        }

        long getTotalEvents(long now) {
            return getTotalEvents(now, 0);
        }

        long getTotalEventsSince(long since, long now) {
            return getTotalEventsSince(since, now, 0);
        }

        @Override // com.android.server.am.BaseAppStateEvents
        String formatEventTypeLabel(int index) {
            return "";
        }
    }

    BaseAppStateEventsTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<T>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mPkgEvents = new UidProcessMap();
        this.mTopUids = new ArraySet();
    }

    void reset() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPkgEvents.clear();     // Catch: Throwable -> L7
        this.mTopUids.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    U getUidEventsLocked(int uid) {
        U events = null;
        ArrayMap<String, U> map = this.mPkgEvents.getMap().get(uid);
        if (map != null) goto L6;
        return null;
    L6:
        int i = map.size() - 1;
    L7:
        if (i < 0) goto L15;
        U event = map.valueAt(i);
        if (event == null) goto L13;
        if (events != null) goto L12;
        events = createAppStateEvents(uid, event.mPackageName);
    L12:
        events.add(event);
    L13:
        i = i - 1;
        goto L7
    L15:
        return events;
    }

    void trim(long earliest) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        trimLocked(earliest);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void trimLocked(long earliest) {
        SparseArray<ArrayMap<String, U>> map = this.mPkgEvents.getMap();
        int i = map.size() - 1;
    L3:
        if (i < 0) goto L15;
        ArrayMap<String, U> val = map.valueAt(i);
        int j = val.size() - 1;
    L5:
        if (j < 0) goto L10;
        U v = val.valueAt(j);
        v.trim(earliest);
        if (v.isEmpty() == false) goto L9;
        val.removeAt(j);
    L9:
        j = j - 1;
        goto L5
    L10:
        int j2 = val.size();
        if (j2 != 0) goto L13;
        map.removeAt(i);
    L13:
        i = i - 1;
        goto L3
    }

    boolean isUidOnTop(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mTopUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void onUntrackingUidLocked(int uid) {
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUidProcStateChanged(int uid, int procState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPkgEvents.getMap().indexOfKey(uid) >= 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        onUidProcStateChangedUncheckedLocked(uid, procState);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void onUidProcStateChangedUncheckedLocked(int uid, int procState) {
        if (procState >= 4) goto L5;
        this.mTopUids.add(Integer.valueOf(uid));
        return;
    L5:
        this.mTopUids.remove(Integer.valueOf(uid));
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUidGone(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTopUids.remove(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUidRemoved(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPkgEvents.getMap().remove(uid);     // Catch: Throwable -> L7
        onUntrackingUidLocked(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<ArrayMap<String, U>> map = this.mPkgEvents.getMap();     // Catch: Throwable -> L9
        int i = map.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        int uid = map.keyAt(i);     // Catch: Throwable -> L9
        if (UserHandle.getUserId(uid) != userId) goto L11;
        map.removeAt(i);     // Catch: Throwable -> L9
        onUntrackingUidLocked(uid);     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void dump(PrintWriter pw, String prefix) {
        BaseAppStateEventsTracker<T, U> r1 = this;
        BaseAppStateEventsPolicy r7 = (BaseAppStateEventsPolicy) r1.mInjector.getPolicy();
        Object r8 = r1.mLock;
        monitor-enter(r8);
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        SparseArray<ArrayMap<String, U>> map = r1.mPkgEvents.getMap();     // Catch: Throwable -> L9
        int i = map.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        int uid = map.keyAt(i);     // Catch: Throwable -> L9
        ArrayMap<String, U> val = map.valueAt(i);     // Catch: Throwable -> L9
        int j = val.size() - 1;     // Catch: Throwable -> L9
    L7:
        if (j < 0) goto L11;
        String packageName = val.keyAt(j);     // Catch: Throwable -> L9
        U events = val.valueAt(j);     // Catch: Throwable -> L9
        r1.dumpEventHeaderLocked(pw, prefix, packageName, uid, events, r7);     // Catch: Throwable -> L9
        int uid2 = uid;
        long now2 = now;
        dumpEventLocked(pw, prefix, events, now2);     // Catch: Throwable -> L9
        j = j - 1;     // Catch: Throwable -> L9
        r1 = this;
        now = now2;
        uid = uid2;
        goto L7
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        r1 = this;
        goto L5
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L9
        dumpOthers(pw, prefix);
        r7.dump(pw, prefix);
        return;
    L9:
        th = th;
    L20:
        throw th;
    L18:
        th = th;
        goto L20
    }

    void dumpOthers(PrintWriter pw, String prefix) {
    }

    void dumpEventHeaderLocked(PrintWriter pw, String prefix, String packageName, int uid, U events, T policy) {
        pw.print(prefix);
        pw.print("* ");
        pw.print(packageName);
        pw.print('/');
        pw.print(UserHandle.formatUid(uid));
        pw.print(" exemption=");
        pw.println(policy.getExemptionReasonString(packageName, uid, events.mExemptReason));
    }

    void dumpEventLocked(PrintWriter pw, String prefix, U events, long now) {
        events.dump(pw, "  " + prefix, now);
    }
}

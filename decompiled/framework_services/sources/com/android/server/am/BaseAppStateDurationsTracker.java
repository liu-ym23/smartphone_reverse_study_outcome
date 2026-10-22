package com.android.server.am;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.android.server.am.BaseAppStateDurations;
import com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseAppStateDurationsTracker<T extends BaseAppStateEventsTracker.BaseAppStateEventsPolicy, U extends BaseAppStateDurations> extends BaseAppStateEventsTracker<T, U> {
    static final boolean DEBUG_BASE_APP_STATE_DURATION_TRACKER = false;
    final SparseArray<UidStateDurations> mUidStateDurations;

    static class SimplePackageDurations extends BaseAppStateDurations<BaseAppStateTimeEvents.BaseTimeEvent> {
        static final int DEFAULT_INDEX = 0;

        /* JADX WARN: Multi-variable type inference failed */
        SimplePackageDurations(int uid, String packageName, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
            super(uid, packageName, 1, "ActivityManager", maxTrackingDurationConfig);
            this.mEvents[0] = new LinkedList();
        }

        SimplePackageDurations(SimplePackageDurations other) {
            super(other);
        }

        void addEvent(boolean active, long now) {
            addEvent(active, new BaseAppStateTimeEvents.BaseTimeEvent(now), 0);
        }

        long getTotalDurations(long now) {
            return getTotalDurations(now, 0);
        }

        long getTotalDurationsSince(long since, long now) {
            return getTotalDurationsSince(since, now, 0);
        }

        boolean isActive() {
            return isActive(0);
        }

        @Override // com.android.server.am.BaseAppStateEvents
        String formatEventTypeLabel(int index) {
            return "";
        }
    }

    static class UidStateDurations extends SimplePackageDurations {
        UidStateDurations(int uid, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
            super(uid, "", maxTrackingDurationConfig);
        }

        UidStateDurations(UidStateDurations other) {
            super(other);
        }
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker
    /* bridge */ /* synthetic */ void dumpEventLocked(PrintWriter r7, String r8, BaseAppStateEvents r9, long r10) {
        dumpEventLocked(r7, r8, (BaseAppStateDurations) r9, r10);
    }

    BaseAppStateDurationsTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<T>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mUidStateDurations = new SparseArray();
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker, com.android.server.am.BaseAppStateTracker
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
        UidStateDurations uidStateDurations = this.mUidStateDurations.get(uid);     // Catch: Throwable -> L8
        if (uidStateDurations != null) goto L14;
        uidStateDurations = new UidStateDurations(uid, (BaseAppStateEvents.MaxTrackingDurationConfig) this.mInjector.getPolicy());     // Catch: Throwable -> L8
        this.mUidStateDurations.put(uid, uidStateDurations);     // Catch: Throwable -> L8
    L14:
        if (procState >= 4) goto L16;
        boolean r2 = true;
    L17:
        uidStateDurations.addEvent(r2, SystemClock.elapsedRealtime());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        r2 = false;
        goto L17
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker, com.android.server.am.BaseAppStateTracker
    void onUidGone(int uid) {
        onUidProcStateChanged(uid, 20);
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker
    void trimLocked(long earliest) {
        super.trimLocked(earliest);
        int i = this.mUidStateDurations.size() - 1;
    L3:
        if (i < 0) goto L9;
        UidStateDurations u = this.mUidStateDurations.valueAt(i);
        u.trim(earliest);
        if (u.isEmpty() == false) goto L7;
        this.mUidStateDurations.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker
    void onUntrackingUidLocked(int uid) {
        this.mUidStateDurations.remove(uid);
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
    long getTotalDurations(String packageName, int uid, long now, int index, boolean bgOnly) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        BaseAppStateDurations r1 = (BaseAppStateDurations) this.mPkgEvents.get(uid, packageName);     // Catch: Throwable -> L9
        if (r1 != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        if (bgOnly == false) goto L19;
        UidStateDurations uidDurations = this.mUidStateDurations.get(uid);     // Catch: Throwable -> L9
        if (uidDurations == null) goto L19;
        if (uidDurations.isEmpty() == true) goto L19;
        U res = createAppStateEvents(r1);     // Catch: Throwable -> L9
        res.subtract(uidDurations, index, 0);     // Catch: Throwable -> L9
        long r4 = res.getTotalDurations(now, index);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L19:
        long r2 = r1.getTotalDurations(now, index);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    long getTotalDurations(String packageName, int uid, long now, int index) {
        return getTotalDurations(packageName, uid, now, index, true);
    }

    long getTotalDurations(String packageName, int uid, long now) {
        return getTotalDurations(packageName, uid, now, 0);
    }

    long getTotalDurations(int uid, long now, int index, boolean bgOnly) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        U durations = getUidEventsLocked(uid);     // Catch: Throwable -> L9
        if (durations != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        if (bgOnly == false) goto L17;
        UidStateDurations uidDurations = this.mUidStateDurations.get(uid);     // Catch: Throwable -> L9
        if (uidDurations == null) goto L17;
        if (uidDurations.isEmpty() == true) goto L17;
        durations.subtract(uidDurations, index, 0);     // Catch: Throwable -> L9
    L17:
        long r2 = durations.getTotalDurations(now, index);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    long getTotalDurations(int uid, long now, int index) {
        return getTotalDurations(uid, now, index, true);
    }

    long getTotalDurations(int uid, long now) {
        return getTotalDurations(uid, now, 0);
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
    long getTotalDurationsSince(String packageName, int uid, long since, long now, int index, boolean bgOnly) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        BaseAppStateDurations r0 = (BaseAppStateDurations) this.mPkgEvents.get(uid, packageName);     // Catch: Throwable -> L9
        if (r0 != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return 0;
    L11:
        if (bgOnly == false) goto L19;
        UidStateDurations uidDurations = this.mUidStateDurations.get(uid);     // Catch: Throwable -> L9
        if (uidDurations == null) goto L19;
        if (uidDurations.isEmpty() == true) goto L19;
        U res = createAppStateEvents(r0);     // Catch: Throwable -> L9
        res.subtract(uidDurations, index, 0);     // Catch: Throwable -> L9
        long r10 = res.getTotalDurationsSince(since, now, index);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r10;
    L19:
        long r8 = r0.getTotalDurationsSince(since, now, index);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r8;
    L9:
        th = move-exception;
        throw th;
    }

    long getTotalDurationsSince(String packageName, int uid, long since, long now, int index) {
        return getTotalDurationsSince(packageName, uid, since, now, index, true);
    }

    long getTotalDurationsSince(String packageName, int uid, long since, long now) {
        return getTotalDurationsSince(packageName, uid, since, now, 0);
    }

    long getTotalDurationsSince(int uid, long since, long now, int index, boolean bgOnly) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        U durations = getUidEventsLocked(uid);     // Catch: Throwable -> L24
        if (durations != null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return 0;
    L12:
        if (bgOnly == false) goto L19;
        UidStateDurations uidDurations = this.mUidStateDurations.get(uid);     // Catch: Throwable -> L10
        if (uidDurations == null) goto L19;
        if (uidDurations.isEmpty() == true) goto L19;
        durations.subtract(uidDurations, index, 0);     // Catch: Throwable -> L10
    L19:
        long since2 = durations.getTotalDurationsSince(since, now, index);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return since2;
    L10:
        th = th;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L22
        throw th;
    L22:
        th = th;
    L24:
        th = th;
        goto L26
    }

    long getTotalDurationsSince(int uid, long since, long now, int index) {
        return getTotalDurationsSince(uid, since, now, index, true);
    }

    long getTotalDurationsSince(int uid, long since, long now) {
        return getTotalDurationsSince(uid, since, now, 0);
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker
    void reset() {
        super.reset();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidStateDurations.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void dumpEventLocked(PrintWriter pw, String prefix, U events, long now) {
        UidStateDurations uidDurations = this.mUidStateDurations.get(events.mUid);
        pw.print("  " + prefix);
        pw.println("(bg only)");
        if (uidDurations != null) goto L5;
    L9:
        events.dump(pw, "    " + prefix, now);
        return;
    L5:
        if (uidDurations.isEmpty() == true) goto L9;
        U bgEvents = createAppStateEvents(events);
        bgEvents.subtract(uidDurations, 0);
        bgEvents.dump(pw, "    " + prefix, now);
        pw.print("  " + prefix);
        pw.println("(fg + bg)");
        events.dump(pw, "    " + prefix, now);
    }
}

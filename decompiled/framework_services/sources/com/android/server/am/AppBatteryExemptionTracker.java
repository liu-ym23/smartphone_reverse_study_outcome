package com.android.server.am;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
final class AppBatteryExemptionTracker extends BaseAppStateDurationsTracker<AppBatteryExemptionPolicy, UidBatteryStates> implements BaseAppStateEvents.Factory<UidBatteryStates>, BaseAppStateTracker.StateListener {
    private static final boolean DEBUG_BACKGROUND_BATTERY_EXEMPTION_TRACKER = false;
    static final String DEFAULT_NAME = "";
    private static final String TAG = "ActivityManager";
    private UidProcessMap<Integer> mUidPackageStates;

    static final class AppBatteryExemptionPolicy extends BaseAppStateEventsTracker.BaseAppStateEventsPolicy<AppBatteryExemptionTracker> {
        static final boolean DEFAULT_BG_BATTERY_EXEMPTION_ENABLED = false;
        static final String KEY_BG_BATTERY_EXEMPTION_ENABLED = "bg_battery_exemption_enabled";

        /* JADX INFO: renamed from: $r8$lambda$jMixVCQDkf-BsCQ_bwWqAgEzrk0, reason: not valid java name */
        public static /* synthetic */ void m1284$r8$lambda$jMixVCQDkfBsCQ_bwWqAgEzrk0(AppBatteryExemptionTracker r0) {
            AppBatteryExemptionTracker.m1283$$Nest$mtrimDurations(r0);
        }

        AppBatteryExemptionPolicy(BaseAppStateTracker.Injector injector, AppBatteryExemptionTracker tracker) {
            super(injector, tracker, KEY_BG_BATTERY_EXEMPTION_ENABLED, false, "bg_current_drain_window", tracker.mContext.getResources().getInteger(R.integer.config_burnInProtectionMinHorizontalOffset));
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy
        public void onMaxTrackingDurationChanged(long maxDuration) {
            Handler r0 = ((AppBatteryExemptionTracker) this.mTracker).mBgHandler;
            final AppBatteryExemptionTracker r1 = (AppBatteryExemptionTracker) this.mTracker;
            r1.getClass();
            r0.post(new AppBatteryExemptionTracker$AppBatteryExemptionPolicy$$ExternalSyntheticLambda0(r1));
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onTrackerEnabled(boolean enabled) {
            AppBatteryExemptionTracker.m1282$$Nest$monTrackerEnabled((AppBatteryExemptionTracker) this.mTracker, enabled);
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        void dump(PrintWriter pw, String prefix) {
            pw.print(prefix);
            pw.println("APP BATTERY EXEMPTION TRACKER POLICY SETTINGS:");
            super.dump(pw, "  " + prefix);
        }
    }

    static final class UidBatteryStates extends BaseAppStateDurations<UidStateEventWithBattery> {
        UidBatteryStates(int uid, String tag, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig) {
            super(uid, "", 5, tag, maxTrackingDurationConfig);
        }

        UidBatteryStates(UidBatteryStates other) {
            super(other);
        }

        void addEvent(boolean start, long now, AppBatteryTracker.ImmutableBatteryUsage batteryUsage, int eventType) {
            if (start == false) goto L4;
            addEvent(start, new UidStateEventWithBattery(start, now, batteryUsage, null), eventType);
            return;
        L4:
            UidStateEventWithBattery last = getLastEvent(eventType);
            if (last != null) goto L7;
            return;
        L7:
            if (last.isStart() == false) goto L13;
            addEvent(start, new UidStateEventWithBattery(start, now, batteryUsage.mutate().subtract(last.getBatteryUsage()).unmutate(), last), eventType);
            return;
        }

        UidStateEventWithBattery getLastEvent(int eventType) {
            if (this.mEvents[eventType] != null) goto L7;
            return null;
        L7:
            return (UidStateEventWithBattery) this.mEvents[eventType].peekLast();
        }

        private Pair<AppBatteryTracker.ImmutableBatteryUsage, AppBatteryTracker.ImmutableBatteryUsage> getBatteryUsageSince(long since, long now, LinkedList<UidStateEventWithBattery> events) {
            if (events == null) goto L25;
            if (events.size() == 0) goto L25;
            AppBatteryTracker.BatteryUsage batteryUsage = new AppBatteryTracker.BatteryUsage();
            UidStateEventWithBattery lastEvent = null;
            Iterator<UidStateEventWithBattery> r2 = events.iterator();
        L8:
            if (r2.hasNext() == false) goto L18;
            UidStateEventWithBattery event = r2.next();
            lastEvent = event;
            if (event.getTimestamp() < since) goto L8;
            if (event.isStart() == true) goto L8;
            batteryUsage.add(event.getBatteryUsage(since, Math.min(now, event.getTimestamp())));
            if (now > event.getTimestamp()) goto L8;
        L18:
            AppBatteryTracker.ImmutableBatteryUsage r3 = batteryUsage.unmutate();
            if (lastEvent.isStart() == false) goto L21;
            AppBatteryTracker.ImmutableBatteryUsage r4 = lastEvent.getBatteryUsage();
        L23:
            return Pair.create(r3, r4);
        L21:
            r4 = AppBatteryTracker.BATTERY_USAGE_NONE;
        L25:
            return Pair.create(AppBatteryTracker.BATTERY_USAGE_NONE, AppBatteryTracker.BATTERY_USAGE_NONE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        Pair<AppBatteryTracker.ImmutableBatteryUsage, AppBatteryTracker.ImmutableBatteryUsage> getBatteryUsageSince(long since, long now, int types) {
            LinkedList<UidStateEventWithBattery> result = new LinkedList();
            int i = 0;
            LinkedList<UidStateEventWithBattery> result2 = result;
        L4:
            if (i >= this.mEvents.length) goto L10;
            if ((BaseAppStateTracker.stateIndexToType(i) & types) == 0) goto L8;
            result2 = add(result2, this.mEvents[i]);
        L8:
            i = i + 1;
            goto L4
        L10:
            return getBatteryUsageSince(since, now, result2);
        }

        @Override // com.android.server.am.BaseAppStateDurations, com.android.server.am.BaseAppStateTimeEvents, com.android.server.am.BaseAppStateEvents
        LinkedList<UidStateEventWithBattery> add(LinkedList<UidStateEventWithBattery> durations, LinkedList<UidStateEventWithBattery> otherDurations) {
            if (otherDurations != null) goto L4;
        L111:
            return durations;
        L4:
            if (otherDurations.size() == 0) goto L111;
            if (durations == null) goto L110;
            if (durations.size() == 0) goto L110;
            Iterator<UidStateEventWithBattery> itl = durations.iterator();
            Iterator<UidStateEventWithBattery> itr = otherDurations.iterator();
            UidStateEventWithBattery l = itl.next();
            UidStateEventWithBattery r = itr.next();
            LinkedList<UidStateEventWithBattery> dest = new LinkedList();
            boolean actr = false;
            boolean actr2 = false;
            boolean overlapping = false;
            AppBatteryTracker.BatteryUsage batteryUsage = new AppBatteryTracker.BatteryUsage();
            long recentActTs = 0;
            long overlappingDuration = 0;
            long lts = l.getTimestamp();
            long rts = r.getTimestamp();
        L11:
            long r17 = Long.MAX_VALUE;
            if (lts != Long.MAX_VALUE) goto L18;
            if (rts != Long.MAX_VALUE) goto L18;
            return dest;
        L18:
            if (actr == true) goto L22;
            if (actr2 == true) goto L22;
            boolean r21 = false;
        L23:
            boolean actCur = r21;
            if (lts != rts) goto L51;
            UidStateEventWithBattery earliest = l;
            if (actr == false) goto L29;
            batteryUsage.add(l.getBatteryUsage());
        L29:
            if (actr2 == false) goto L31;
            batteryUsage.add(r.getBatteryUsage());
        L31:
            if (overlapping == false) goto L35;
            if (actr == true) goto L34;
            if (actr2 == false) goto L35;
        L34:
            long r26 = lts - recentActTs;
        L36:
            overlappingDuration = overlappingDuration + r26;
            if (actr == true) goto L39;
            boolean actl = true;
        L40:
            if (actr2 == true) goto L42;
            boolean actr3 = true;
        L43:
            boolean actr4 = itl.hasNext();
            if (actr4 == false) goto L46;
            UidStateEventWithBattery r6 = itl.next();
            l = r6;
            long lts2 = r6.getTimestamp();
        L48:
            if (itr.hasNext() == false) goto L50;
            UidStateEventWithBattery r7 = itr.next();
            r = r7;
            r17 = r7.getTimestamp();
        L50:
            actr2 = actr3;
            rts = r17;
            lts = lts2;
            actr = actl;
        L83:
            if (actr == false) goto L86;
            if (actr2 == false) goto L86;
            boolean r0 = true;
        L87:
            overlapping = r0;
            if (actr == true) goto L90;
            if (actr2 == true) goto L90;
        L91:
            if (actr == true) goto L95;
            if (actr2 == true) goto L95;
            boolean r1 = false;
        L96:
            Iterator<UidStateEventWithBattery> itr2 = itr;
            if (actCur == r1) goto L107;
            UidStateEventWithBattery event = (UidStateEventWithBattery) earliest.clone();
            if (actCur == false) goto L105;
            UidStateEventWithBattery lastEvent = dest.peekLast();
            long startTs = lastEvent.getTimestamp();
            long duration = event.getTimestamp() - startTs;
            long durationWithOverlapping = duration + overlappingDuration;
            if (durationWithOverlapping == 0) goto L103;
            batteryUsage.scale((duration * 1.0d) / durationWithOverlapping);
            event.update(lastEvent, new AppBatteryTracker.ImmutableBatteryUsage(batteryUsage));
        L104:
            batteryUsage.setTo(AppBatteryTracker.BATTERY_USAGE_NONE);
            overlappingDuration = 0;
        L106:
            dest.add(event);
        L108:
            itr = itr2;
            l = l;
            r = r;
            actr = actr;
            recentActTs = recentActTs;
            itl = itl;
            actr2 = actr2;
            goto L11
        L103:
            event.update(lastEvent, AppBatteryTracker.BATTERY_USAGE_NONE);
            goto L104
        L105:
            recentActTs = recentActTs;
            goto L106
        L107:
            l = l;
            r = r;
            actr = actr;
            actr2 = actr2;
            recentActTs = recentActTs;
        L95:
            r1 = true;
        L90:
            recentActTs = earliest.getTimestamp();
        L86:
            r0 = false;
            goto L87
        L46:
            lts2 = Long.MAX_VALUE;
            goto L48
        L42:
            actr3 = false;
            goto L43
        L39:
            actl = false;
        L35:
            r26 = 0;
            goto L36
        L51:
            itl = itl;
            if (lts >= rts) goto L68;
            earliest = l;
            if (actr == false) goto L56;
            batteryUsage.add(l.getBatteryUsage());
        L56:
            if (overlapping == false) goto L59;
            if (actr == false) goto L59;
            long r27 = lts - recentActTs;
        L60:
            overlappingDuration = overlappingDuration + r27;
            if (actr == true) goto L63;
            boolean actl2 = true;
        L64:
            boolean actl3 = itl.hasNext();
            if (actl3 == false) goto L67;
            UidStateEventWithBattery r5 = itl.next();
            l = r5;
            r17 = r5.getTimestamp();
        L67:
            actr = actl2;
            lts = r17;
            goto L83
        L63:
            actl2 = false;
        L59:
            r27 = 0;
            goto L60
        L68:
            earliest = r;
            if (actr2 == false) goto L71;
            batteryUsage.add(r.getBatteryUsage());
        L71:
            if (overlapping == false) goto L74;
            if (actr2 == false) goto L74;
            long r28 = rts - recentActTs;
        L75:
            overlappingDuration = overlappingDuration + r28;
            if (actr2 == true) goto L78;
            boolean actr5 = true;
        L79:
            boolean actr6 = itr.hasNext();
            if (actr6 == false) goto L82;
            UidStateEventWithBattery r8 = itr.next();
            r = r8;
            r17 = r8.getTimestamp();
        L82:
            actr2 = actr5;
            rts = r17;
            goto L83
        L78:
            actr5 = false;
        L74:
            r28 = 0;
        L22:
            r21 = true;
        L110:
            return (LinkedList) otherDurations.clone();
        }
    }

    static final class UidStateEventWithBattery extends BaseAppStateTimeEvents.BaseTimeEvent {
        private AppBatteryTracker.ImmutableBatteryUsage mBatteryUsage;
        private boolean mIsStart;
        private UidStateEventWithBattery mPeer;

        UidStateEventWithBattery(boolean isStart, long now, AppBatteryTracker.ImmutableBatteryUsage batteryUsage, UidStateEventWithBattery peer) {
            super(now);
            this.mIsStart = isStart;
            this.mBatteryUsage = batteryUsage;
            this.mPeer = peer;
            if (peer == null) goto L6;
            peer.mPeer = this;
            return;
        }

        UidStateEventWithBattery(UidStateEventWithBattery other) {
            super(other);
            this.mIsStart = other.mIsStart;
            this.mBatteryUsage = other.mBatteryUsage;
        }

        @Override // com.android.server.am.BaseAppStateTimeEvents.BaseTimeEvent
        void trimTo(long timestamp) {
            if (this.mIsStart == true) goto L5;
            return;
        L5:
            if (timestamp >= this.mTimestamp) goto L8;
            return;
        L8:
            if (this.mPeer == null) goto L10;
            AppBatteryTracker.ImmutableBatteryUsage batteryUsage = this.mPeer.getBatteryUsage();
            UidStateEventWithBattery r1 = this.mPeer;
            r1.mBatteryUsage = this.mPeer.getBatteryUsage(timestamp, this.mPeer.mTimestamp);
            this.mBatteryUsage = this.mBatteryUsage.mutate().add(batteryUsage).subtract(this.mPeer.mBatteryUsage).unmutate();
        L10:
            this.mTimestamp = timestamp;
        }

        void update(UidStateEventWithBattery peer, AppBatteryTracker.ImmutableBatteryUsage batteryUsage) {
            this.mPeer = peer;
            peer.mPeer = this;
            this.mBatteryUsage = batteryUsage;
        }

        boolean isStart() {
            return this.mIsStart;
        }

        AppBatteryTracker.ImmutableBatteryUsage getBatteryUsage(long start, long end) {
            if (this.mIsStart == true) goto L18;
            if (start >= this.mTimestamp) goto L18;
            if (end <= start) goto L18;
            long start2 = Math.max(start, this.mPeer.mTimestamp);
            long end2 = Math.min(end, this.mTimestamp);
            long totalDur = this.mTimestamp - this.mPeer.mTimestamp;
            long inputDur = end2 - start2;
            if (totalDur == 0) goto L16;
            if (totalDur != inputDur) goto L20;
            return this.mBatteryUsage;
        L20:
            return this.mBatteryUsage.mutate().scale((inputDur * 1.0d) / totalDur).unmutate();
        L16:
            return AppBatteryTracker.BATTERY_USAGE_NONE;
        L18:
            return AppBatteryTracker.BATTERY_USAGE_NONE;
        }

        AppBatteryTracker.ImmutableBatteryUsage getBatteryUsage() {
            return this.mBatteryUsage;
        }

        @Override // com.android.server.am.BaseAppStateTimeEvents.BaseTimeEvent
        public Object clone() {
            return new UidStateEventWithBattery(this);
        }

        @Override // com.android.server.am.BaseAppStateTimeEvents.BaseTimeEvent
        public boolean equals(Object other) {
            if (other != null) goto L6;
            return false;
        L6:
            if (other.getClass() == UidStateEventWithBattery.class) goto L8;
            return false;
        L8:
            UidStateEventWithBattery otherEvent = (UidStateEventWithBattery) other;
            if (otherEvent.mIsStart == this.mIsStart) goto L11;
            return false;
        L11:
            if (otherEvent.mTimestamp == this.mTimestamp) goto L13;
            return false;
        L13:
            if (this.mBatteryUsage.equals(otherEvent.mBatteryUsage) == false) goto L19;
            return true;
        L19:
            return false;
        }

        public String toString() {
            return "UidStateEventWithBattery(" + this.mIsStart + ", " + this.mTimestamp + ", " + this.mBatteryUsage + ")";
        }

        @Override // com.android.server.am.BaseAppStateTimeEvents.BaseTimeEvent
        public int hashCode() {
            return (((Boolean.hashCode(this.mIsStart) * 31) + Long.hashCode(this.mTimestamp)) * 31) + this.mBatteryUsage.hashCode();
        }
    }

    public static /* synthetic */ void $r8$lambda$iWmJGcyLLkDvNkQor9pOnxtCJY0(AppBatteryExemptionTracker r0, BaseAppStateTracker r1) {
        r0.lambda$onSystemReady$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monTrackerEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1282$$Nest$monTrackerEnabled(AppBatteryExemptionTracker r0, boolean r1) {
        r0.onTrackerEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtrimDurations, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1283$$Nest$mtrimDurations(AppBatteryExemptionTracker r0) {
        r0.trimDurations();
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public /* bridge */ /* synthetic */ BaseAppStateEvents createAppStateEvents(int r1, String r2) {
        return createAppStateEvents(r1, r2);
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public /* bridge */ /* synthetic */ BaseAppStateEvents createAppStateEvents(BaseAppStateEvents r1) {
        return createAppStateEvents((UidBatteryStates) r1);
    }

    AppBatteryExemptionTracker(Context context, AppRestrictionController controller) {
        this(context, controller, null, null);
    }

    AppBatteryExemptionTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<AppBatteryExemptionPolicy>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mUidPackageStates = new UidProcessMap();
        this.mInjector.setPolicy(new AppBatteryExemptionPolicy(this.mInjector, this));
    }

    @Override // com.android.server.am.BaseAppStateTracker
    int getType() {
        return 2;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onSystemReady() {
        super.onSystemReady();
        this.mAppRestrictionController.forEachTracker(new AppBatteryExemptionTracker$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$onSystemReady$0(BaseAppStateTracker tracker) {
        tracker.registerStateListener(this);
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public UidBatteryStates createAppStateEvents(int uid, String packageName) {
        return new UidBatteryStates(uid, TAG, (BaseAppStateEvents.MaxTrackingDurationConfig) this.mInjector.getPolicy());
    }

    public UidBatteryStates createAppStateEvents(UidBatteryStates other) {
        return new UidBatteryStates(other);
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
    @Override // com.android.server.am.BaseAppStateTracker.StateListener
    public void onStateChange(int uid, String packageName, boolean start, long now, int stateType) {
        if (((AppBatteryExemptionPolicy) this.mInjector.getPolicy()).isEnabled() == true) goto L5;
        return;
    L5:
        AppBatteryTracker.ImmutableBatteryUsage batteryUsage = this.mAppRestrictionController.getUidBatteryUsage(uid);
        int stateTypeIndex = BaseAppStateTracker.stateTypeToIndex(stateType);
        Object r11 = this.mLock;
        monitor-enter(r11);
        SparseArray<ArrayMap<String, Integer>> map = this.mUidPackageStates.getMap();     // Catch: Throwable -> L10
        ArrayMap<String, Integer> pkgsStates = map.get(uid);     // Catch: Throwable -> L10
        if (pkgsStates != null) goto L12;
        ArrayMap<String, Integer> pkgsStates2 = new ArrayMap();     // Catch: Throwable -> L10
        map.put(uid, pkgsStates2);     // Catch: Throwable -> L10
        ArrayMap<String, Integer> pkgsStates3 = pkgsStates2;
    L13:
        int states = 0;
        int indexOfPkg = pkgsStates3.indexOfKey(packageName);     // Catch: Throwable -> L10
        if (indexOfPkg < 0) goto L16;
        states = pkgsStates3.valueAt(indexOfPkg).intValue();     // Catch: Throwable -> L10
        int indexOfPkg2 = indexOfPkg;
    L17:
        int indexOfPkg3 = 0;
        if (start == false) goto L29;
        boolean alreadyStarted = false;
        int i = pkgsStates3.size() - 1;     // Catch: Throwable -> L10
    L20:
        if (i < 0) goto L25;
        int s = pkgsStates3.valueAt(i).intValue();     // Catch: Throwable -> L10
        if ((s & stateType) != 0) goto L23;
        i = i - 1;     // Catch: Throwable -> L10
        goto L20
    L23:
        alreadyStarted = true;
    L25:
        int i2 = states | stateType;     // Catch: Throwable -> L10
        pkgsStates3.setValueAt(indexOfPkg2, Integer.valueOf(i2));     // Catch: Throwable -> L10
        if (alreadyStarted == true) goto L28;
        indexOfPkg3 = 1;
    L28:
        int r15 = indexOfPkg3;
    L42:
        if (r15 == 0) goto L47;
        UidBatteryStates pkg = (UidBatteryStates) this.mPkgEvents.get(uid, "");     // Catch: Throwable -> L10
        if (pkg != null) goto L46;
        pkg = createAppStateEvents(uid, "");     // Catch: Throwable -> L10
        this.mPkgEvents.put(uid, "", pkg);     // Catch: Throwable -> L10
    L46:
        pkg.addEvent(start, now, batteryUsage, stateTypeIndex);     // Catch: Throwable -> L10
    L47:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L29:
        int states2 = states & (~stateType);     // Catch: Throwable -> L10
        pkgsStates3.setValueAt(indexOfPkg2, Integer.valueOf(states2));     // Catch: Throwable -> L10
        boolean allStopped = true;
        int i3 = pkgsStates3.size() - 1;     // Catch: Throwable -> L10
    L30:
        if (i3 < 0) goto L35;
        int s2 = pkgsStates3.valueAt(i3).intValue();     // Catch: Throwable -> L10
        if ((s2 & stateType) != 0) goto L33;
        i3 = i3 - 1;     // Catch: Throwable -> L10
        goto L30
    L33:
        allStopped = false;
    L35:
        if (allStopped == false) goto L37;
        indexOfPkg3 = 1;
    L37:
        if (states2 != 0) goto L41;
        pkgsStates3.removeAt(indexOfPkg2);     // Catch: Throwable -> L10
        if (pkgsStates3.size() != 0) goto L41;
        map.remove(uid);     // Catch: Throwable -> L10
    L41:
        r15 = indexOfPkg3;
        goto L42
    L16:
        pkgsStates3.put(packageName, 0);     // Catch: Throwable -> L10
        indexOfPkg2 = pkgsStates3.indexOfKey(packageName);     // Catch: Throwable -> L10
        goto L17
    L12:
        pkgsStates3 = pkgsStates;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateDurationsTracker, com.android.server.am.BaseAppStateEventsTracker
    void reset() {
        super.reset();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidPackageStates.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onTrackerEnabled(boolean enabled) {
        if (enabled == true) goto L11;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPkgEvents.clear();     // Catch: Throwable -> L8
        this.mUidPackageStates.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
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
    AppBatteryTracker.ImmutableBatteryUsage getUidBatteryExemptedUsageSince(int uid, long since, long now, int types) {
        if (((AppBatteryExemptionPolicy) this.mInjector.getPolicy()).isEnabled() == false) goto L5;
        Object r1 = this.mLock;
        monitor-enter(r1);
        UidBatteryStates pkg = (UidBatteryStates) this.mPkgEvents.get(uid, "");     // Catch: Throwable -> L27
        if (pkg != null) goto L17;
        AppBatteryTracker.ImmutableBatteryUsage r0 = AppBatteryTracker.BATTERY_USAGE_NONE;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r0;
    L14:
        th = th;
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L25
        throw th;
    L17:
        Pair<AppBatteryTracker.ImmutableBatteryUsage, AppBatteryTracker.ImmutableBatteryUsage> result = pkg.getBatteryUsageSince(since, now, types);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        if (((AppBatteryTracker.ImmutableBatteryUsage) result.second).isEmpty() == true) goto L24;
        AppBatteryTracker.ImmutableBatteryUsage batteryUsage = this.mAppRestrictionController.getUidBatteryUsage(uid);
        return ((AppBatteryTracker.ImmutableBatteryUsage) result.first).mutate().add(batteryUsage).subtract((AppBatteryTracker.BatteryUsage) result.second).unmutate();
    L24:
        return (AppBatteryTracker.ImmutableBatteryUsage) result.first;
    L25:
        th = th;
    L27:
        th = th;
        goto L29
    L5:
        return AppBatteryTracker.BATTERY_USAGE_NONE;
    }

    private void trimDurations() {
        long now = SystemClock.elapsedRealtime();
        trim(Math.max(0, now - ((AppBatteryExemptionPolicy) this.mInjector.getPolicy()).getMaxTrackingDuration()));
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker, com.android.server.am.BaseAppStateTracker
    void dump(PrintWriter pw, String prefix) {
        ((AppBatteryExemptionPolicy) this.mInjector.getPolicy()).dump(pw, prefix);
    }
}

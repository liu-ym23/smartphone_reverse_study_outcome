package com.android.server.am;

import android.app.ActivityManagerInternal;
import android.app.IProcessObserver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.SomeArgs;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
final class AppFGSTracker extends BaseAppStateDurationsTracker<AppFGSPolicy, PackageDurations> implements ActivityManagerInternal.ForegroundServiceStateListener {
    static final boolean DEBUG_BACKGROUND_FGS_TRACKER = false;
    static final String TAG = "ActivityManager";
    private final UidProcessMap<SparseBooleanArray> mFGSNotificationIDs;
    private final MyHandler mHandler;
    final NotificationListener mNotificationListener;
    final IProcessObserver.Stub mProcessObserver;
    private final ArrayMap<PackageDurations, Long> mTmpPkgDurations;

    static final class AppFGSPolicy extends BaseAppStateEventsTracker.BaseAppStateEventsPolicy<AppFGSTracker> {
        static final long DEFAULT_BG_FGS_LOCATION_THRESHOLD = 14400000;
        static final long DEFAULT_BG_FGS_LONG_RUNNING_THRESHOLD = 72000000;
        static final long DEFAULT_BG_FGS_LONG_RUNNING_WINDOW = 86400000;
        static final long DEFAULT_BG_FGS_MEDIA_PLAYBACK_THRESHOLD = 14400000;
        static final boolean DEFAULT_BG_FGS_MONITOR_ENABLED = true;
        static final String KEY_BG_FGS_LOCATION_THRESHOLD = "bg_fgs_location_threshold";
        static final String KEY_BG_FGS_LONG_RUNNING_THRESHOLD = "bg_fgs_long_running_threshold";
        static final String KEY_BG_FGS_LONG_RUNNING_WINDOW = "bg_fgs_long_running_window";
        static final String KEY_BG_FGS_MEDIA_PLAYBACK_THRESHOLD = "bg_fgs_media_playback_threshold";
        static final String KEY_BG_FGS_MONITOR_ENABLED = "bg_fgs_monitor_enabled";
        private volatile long mBgFgsLocationThresholdMs;
        private volatile long mBgFgsLongRunningThresholdMs;
        private volatile long mBgFgsMediaPlaybackThresholdMs;

        AppFGSPolicy(BaseAppStateTracker.Injector injector, AppFGSTracker tracker) {
            super(injector, tracker, KEY_BG_FGS_MONITOR_ENABLED, true, KEY_BG_FGS_LONG_RUNNING_WINDOW, 86400000);
            this.mBgFgsLongRunningThresholdMs = DEFAULT_BG_FGS_LONG_RUNNING_THRESHOLD;
            this.mBgFgsMediaPlaybackThresholdMs = 14400000;
            this.mBgFgsLocationThresholdMs = 14400000;
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        public void onSystemReady() {
            super.onSystemReady();
            updateBgFgsLongRunningThreshold();
            updateBgFgsMediaPlaybackThreshold();
            updateBgFgsLocationThreshold();
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        public void onPropertiesChanged(String name) {
            switch(name.hashCode()) {
                case -2001687768: goto L12;
                case 351955503: goto L9;
                case 803245321: goto L6;
                default: goto L14;
            };
        L14:
            byte r0 = -1;
        L15:
            switch(r0) {
                case 0: goto L19;
                case 1: goto L18;
                case 2: goto L17;
                default: goto L16;
            };
        L16:
            super.onPropertiesChanged(name);
            return;
        L17:
            updateBgFgsLocationThreshold();
            return;
        L18:
            updateBgFgsMediaPlaybackThreshold();
            return;
        L19:
            updateBgFgsLongRunningThreshold();
            return;
        L6:
            if (name.equals(KEY_BG_FGS_MEDIA_PLAYBACK_THRESHOLD) == false) goto L14;
            r0 = 1;
            goto L15
        L9:
            if (name.equals(KEY_BG_FGS_LONG_RUNNING_THRESHOLD) == false) goto L14;
            r0 = 0;
            goto L15
        L12:
            if (name.equals(KEY_BG_FGS_LOCATION_THRESHOLD) == false) goto L14;
            r0 = 2;
            goto L15
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onTrackerEnabled(boolean enabled) {
            AppFGSTracker.m1307$$Nest$monBgFgsMonitorEnabled((AppFGSTracker) this.mTracker, enabled);
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy
        public void onMaxTrackingDurationChanged(long maxDuration) {
            AppFGSTracker.m1306$$Nest$monBgFgsLongRunningThresholdChanged((AppFGSTracker) this.mTracker);
        }

        private void updateBgFgsLongRunningThreshold() {
            long threshold = DeviceConfig.getLong("activity_manager", KEY_BG_FGS_LONG_RUNNING_THRESHOLD, DEFAULT_BG_FGS_LONG_RUNNING_THRESHOLD);
            if (threshold == this.mBgFgsLongRunningThresholdMs) goto L6;
            this.mBgFgsLongRunningThresholdMs = threshold;
            AppFGSTracker.m1306$$Nest$monBgFgsLongRunningThresholdChanged((AppFGSTracker) this.mTracker);
            return;
        }

        private void updateBgFgsMediaPlaybackThreshold() {
            this.mBgFgsMediaPlaybackThresholdMs = DeviceConfig.getLong("activity_manager", KEY_BG_FGS_MEDIA_PLAYBACK_THRESHOLD, 14400000);
        }

        private void updateBgFgsLocationThreshold() {
            this.mBgFgsLocationThresholdMs = DeviceConfig.getLong("activity_manager", KEY_BG_FGS_LOCATION_THRESHOLD, 14400000);
        }

        long getFgsLongRunningThreshold() {
            return this.mBgFgsLongRunningThresholdMs;
        }

        long getFgsLongRunningWindowSize() {
            return getMaxTrackingDuration();
        }

        long getFGSMediaPlaybackThreshold() {
            return this.mBgFgsMediaPlaybackThresholdMs;
        }

        long getLocationFGSThreshold() {
            return this.mBgFgsLocationThresholdMs;
        }

        void onLongRunningFgs(String packageName, int uid, int exemptReason) {
            if (exemptReason == (-1)) goto L5;
            return;
        L5:
            long now = SystemClock.elapsedRealtime();
            long window = getFgsLongRunningWindowSize();
            long since = Math.max(0, now - window);
            if (shouldExemptMediaPlaybackFGS(packageName, uid, now, window) == false) goto L9;
            return;
        L9:
            if (shouldExemptLocationFGS(packageName, uid, now, since) == false) goto L11;
            return;
        L11:
            ((AppFGSTracker) this.mTracker).mAppRestrictionController.postLongRunningFgsIfNecessary(packageName, uid);
        }

        boolean shouldExemptMediaPlaybackFGS(String packageName, int uid, long now, long window) {
            long mediaPlaybackMs = ((AppFGSTracker) this.mTracker).mAppRestrictionController.getCompositeMediaPlaybackDurations(packageName, uid, now, window);
            if (mediaPlaybackMs > 0) goto L5;
            return false;
        L5:
            if (mediaPlaybackMs < getFGSMediaPlaybackThreshold()) goto L10;
            return true;
        L10:
            return false;
        }

        boolean shouldExemptLocationFGS(String packageName, int uid, long now, long since) {
            long locationMs = ((AppFGSTracker) this.mTracker).mAppRestrictionController.getForegroundServiceTotalDurationsSince(packageName, uid, since, now, 8);
            if (locationMs > 0) goto L5;
            return false;
        L5:
            if (locationMs < getLocationFGSThreshold()) goto L10;
            return true;
        L10:
            return false;
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy
        String getExemptionReasonString(String packageName, int uid, int reason) {
            if (reason != (-1)) goto L5;
            long now = SystemClock.elapsedRealtime();
            long window = getFgsLongRunningWindowSize();
            long since = Math.max(0, now - getFgsLongRunningWindowSize());
            return "{mediaPlayback=" + shouldExemptMediaPlaybackFGS(packageName, uid, now, window) + ", location=" + shouldExemptLocationFGS(packageName, uid, now, since) + "}";
        L5:
            return super.getExemptionReasonString(packageName, uid, reason);
        }

        void onLongRunningFgsGone(String packageName, int uid) {
            ((AppFGSTracker) this.mTracker).mAppRestrictionController.cancelLongRunningFGSNotificationIfNecessary(packageName, uid);
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        void dump(PrintWriter pw, String prefix) {
            pw.print(prefix);
            pw.println("APP FOREGROUND SERVICE TRACKER POLICY SETTINGS:");
            String prefix2 = "  " + prefix;
            super.dump(pw, prefix2);
            if (isEnabled() == false) goto L6;
            pw.print(prefix2);
            pw.print(KEY_BG_FGS_LONG_RUNNING_THRESHOLD);
            pw.print('=');
            pw.println(this.mBgFgsLongRunningThresholdMs);
            pw.print(prefix2);
            pw.print(KEY_BG_FGS_MEDIA_PLAYBACK_THRESHOLD);
            pw.print('=');
            pw.println(this.mBgFgsMediaPlaybackThresholdMs);
            pw.print(prefix2);
            pw.print(KEY_BG_FGS_LOCATION_THRESHOLD);
            pw.print('=');
            pw.println(this.mBgFgsLocationThresholdMs);
            return;
        }
    }

    private static class MyHandler extends Handler {
        static final int MSG_CHECK_LONG_RUNNING_FGS = 4;
        static final int MSG_FOREGROUND_SERVICES_CHANGED = 2;
        static final int MSG_FOREGROUND_SERVICES_NOTIFICATION_UPDATED = 3;
        static final int MSG_FOREGROUND_SERVICES_STARTED = 0;
        static final int MSG_FOREGROUND_SERVICES_STOPPED = 1;
        static final int MSG_NOTIFICATION_POSTED = 5;
        static final int MSG_NOTIFICATION_REMOVED = 6;
        private final AppFGSTracker mTracker;

        MyHandler(AppFGSTracker tracker) {
            super(tracker.mBgHandler.getLooper());
            this.mTracker = tracker;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L11;
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L19;
            };
        L5:
            AppFGSTracker.m1305$$Nest$mhandleNotificationRemoved(this.mTracker, (String) msg.obj, msg.arg1, msg.arg2);
            return;
        L6:
            AppFGSTracker.m1304$$Nest$mhandleNotificationPosted(this.mTracker, (String) msg.obj, msg.arg1, msg.arg2);
            return;
        L7:
            AppFGSTracker.m1300$$Nest$mcheckLongRunningFgs(this.mTracker);
            return;
        L8:
            SomeArgs args = (SomeArgs) msg.obj;
            AppFGSTracker.m1301$$Nest$mhandleForegroundServiceNotificationUpdated(this.mTracker, (String) args.arg1, args.argi1, args.argi2, ((Boolean) args.arg2).booleanValue());
            args.recycle();
            return;
        L9:
            AppFGSTracker.m1302$$Nest$mhandleForegroundServicesChanged(this.mTracker, (String) msg.obj, msg.arg1, msg.arg2);
            return;
        L10:
            AppFGSTracker.m1303$$Nest$mhandleForegroundServicesChanged(this.mTracker, (String) msg.obj, msg.arg1, msg.arg2, false);
            return;
        L11:
            AppFGSTracker.m1303$$Nest$mhandleForegroundServicesChanged(this.mTracker, (String) msg.obj, msg.arg1, msg.arg2, true);
            return;
        }
    }

    class NotificationListener extends NotificationListenerService {
        final /* synthetic */ AppFGSTracker this$0;

        NotificationListener(AppFGSTracker this$0) {
            this.this$0 = this$0;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationPosted(StatusBarNotification sbn, NotificationListenerService.RankingMap map) {
            AppFGSTracker.m1299$$Nest$fgetmHandler(this.this$0).obtainMessage(5, sbn.getUid(), sbn.getId(), sbn.getPackageName()).sendToTarget();
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationRemoved(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap, int reason) {
            AppFGSTracker.m1299$$Nest$fgetmHandler(this.this$0).obtainMessage(6, sbn.getUid(), sbn.getId(), sbn.getPackageName()).sendToTarget();
        }
    }

    static class PackageDurations extends BaseAppStateDurations<BaseAppStateTimeEvents.BaseTimeEvent> {
        static final int DEFAULT_INDEX = 0;
        private int mForegroundServiceTypes;
        private boolean mIsLongRunning;
        private final AppFGSTracker mTracker;

        static {
            DEFAULT_INDEX = AppFGSTracker.foregroundServiceTypeToIndex(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        PackageDurations(int uid, String packageName, BaseAppStateEvents.MaxTrackingDurationConfig maxTrackingDurationConfig, AppFGSTracker tracker) {
            super(uid, packageName, 31, AppFGSTracker.TAG, maxTrackingDurationConfig);
            this.mEvents[DEFAULT_INDEX] = new LinkedList();
            this.mTracker = tracker;
        }

        PackageDurations(PackageDurations other) {
            super(other);
            this.mIsLongRunning = other.mIsLongRunning;
            this.mForegroundServiceTypes = other.mForegroundServiceTypes;
            this.mTracker = other.mTracker;
        }

        void addEvent(boolean startFgs, long now) {
            addEvent(startFgs, new BaseAppStateTimeEvents.BaseTimeEvent(now), DEFAULT_INDEX);
            if (startFgs == false) goto L5;
        L7:
            if (startFgs == false) goto L9;
            return;
        L9:
            if (this.mForegroundServiceTypes == 0) goto L27;
            int i = 1;
        L12:
            if (i >= this.mEvents.length) goto L20;
            if (this.mEvents[i] == null) goto L19;
            if (isActive(i) == false) goto L19;
            this.mEvents[i].add(new BaseAppStateTimeEvents.BaseTimeEvent(now));
            notifyListenersOnStateChangeIfNecessary(false, now, AppFGSTracker.indexToForegroundServiceType(i));
        L19:
            i = i + 1;
            goto L12
        L20:
            this.mForegroundServiceTypes = 0;
            return;
        L27:
            return;
        L5:
            if (hasForegroundServices() == true) goto L7;
            this.mIsLongRunning = false;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        void setForegroundServiceType(int serviceTypes, long now) {
            if (serviceTypes != this.mForegroundServiceTypes) goto L5;
            return;
        L5:
            if (hasForegroundServices() == false) goto L35;
            int changes = this.mForegroundServiceTypes ^ serviceTypes;
            int serviceType = Integer.highestOneBit(changes);
        L8:
            if (serviceType == 0) goto L25;
            int i = AppFGSTracker.foregroundServiceTypeToIndex(serviceType);
            if (i >= this.mEvents.length) goto L24;
            if ((serviceTypes & serviceType) == 0) goto L20;
            if (this.mEvents[i] != null) goto L17;
            this.mEvents[i] = new LinkedList();
        L17:
            if (isActive(i) == true) goto L24;
            this.mEvents[i].add(new BaseAppStateTimeEvents.BaseTimeEvent(now));
            notifyListenersOnStateChangeIfNecessary(true, now, serviceType);
            goto L24
        L20:
            if (this.mEvents[i] == null) goto L24;
            if (isActive(i) == false) goto L24;
            this.mEvents[i].add(new BaseAppStateTimeEvents.BaseTimeEvent(now));
            notifyListenersOnStateChangeIfNecessary(false, now, serviceType);
        L24:
            changes = changes & (~serviceType);
            serviceType = Integer.highestOneBit(changes);
            goto L8
        L25:
            this.mForegroundServiceTypes = serviceTypes;
            return;
        }

        private void notifyListenersOnStateChangeIfNecessary(boolean start, long now, int serviceType) {
            switch(serviceType) {
                case 2: goto L5;
                case 8: goto L4;
                default: goto L3;
            };
        L3:
            return;
        L4:
            int stateType = 4;
        L6:
            this.mTracker.notifyListenersOnStateChange(this.mUid, this.mPackageName, start, now, stateType);
            return;
        L5:
            stateType = 2;
            goto L6
        }

        void setIsLongRunning(boolean isLongRunning) {
            this.mIsLongRunning = isLongRunning;
        }

        boolean isLongRunning() {
            return this.mIsLongRunning;
        }

        boolean hasForegroundServices() {
            return isActive(DEFAULT_INDEX);
        }

        @Override // com.android.server.am.BaseAppStateEvents
        String formatEventTypeLabel(int index) {
            if (index != DEFAULT_INDEX) goto L7;
            return "Overall foreground services: ";
        L7:
            return ServiceInfo.foregroundServiceTypeToLabel(AppFGSTracker.indexToForegroundServiceType(index)) + ": ";
        }
    }

    public static /* synthetic */ int $r8$lambda$96CgEXxVLBdbNPixpdL0HZzibHo(ArrayMap r0, Integer r1, Integer r2) {
        return lambda$checkLongRunningFgs$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MyHandler m1299$$Nest$fgetmHandler(AppFGSTracker r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckLongRunningFgs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1300$$Nest$mcheckLongRunningFgs(AppFGSTracker r0) {
        r0.checkLongRunningFgs();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleForegroundServiceNotificationUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1301$$Nest$mhandleForegroundServiceNotificationUpdated(AppFGSTracker r0, String r1, int r2, int r3, boolean r4) {
        r0.handleForegroundServiceNotificationUpdated(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleForegroundServicesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1302$$Nest$mhandleForegroundServicesChanged(AppFGSTracker r0, String r1, int r2, int r3) {
        r0.handleForegroundServicesChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleForegroundServicesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1303$$Nest$mhandleForegroundServicesChanged(AppFGSTracker r0, String r1, int r2, int r3, boolean r4) {
        r0.handleForegroundServicesChanged(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotificationPosted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1304$$Nest$mhandleNotificationPosted(AppFGSTracker r0, String r1, int r2, int r3) {
        r0.handleNotificationPosted(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotificationRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1305$$Nest$mhandleNotificationRemoved(AppFGSTracker r0, String r1, int r2, int r3) {
        r0.handleNotificationRemoved(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monBgFgsLongRunningThresholdChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1306$$Nest$monBgFgsLongRunningThresholdChanged(AppFGSTracker r0) {
        r0.onBgFgsLongRunningThresholdChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$monBgFgsMonitorEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1307$$Nest$monBgFgsMonitorEnabled(AppFGSTracker r0, boolean r1) {
        r0.onBgFgsMonitorEnabled(r1);
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public /* bridge */ /* synthetic */ BaseAppStateEvents createAppStateEvents(int r1, String r2) {
        return createAppStateEvents(r1, r2);
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public /* bridge */ /* synthetic */ BaseAppStateEvents createAppStateEvents(BaseAppStateEvents r1) {
        return createAppStateEvents((PackageDurations) r1);
    }

    public void onForegroundServiceStateChanged(String packageName, int uid, int pid, boolean started) {
        MyHandler r0 = this.mHandler;
        if (started == false) goto L5;
        int r1 = 0;
    L6:
        r0.obtainMessage(r1, pid, uid, packageName).sendToTarget();
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public void onForegroundServiceNotificationUpdated(String packageName, int uid, int foregroundId, boolean canceling) {
        SomeArgs args = SomeArgs.obtain();
        args.argi1 = uid;
        args.argi2 = foregroundId;
        args.arg1 = packageName;
        if (canceling == false) goto L5;
        Boolean r1 = Boolean.TRUE;
    L6:
        args.arg2 = r1;
        this.mHandler.obtainMessage(3, args).sendToTarget();
        return;
    L5:
        r1 = Boolean.FALSE;
        goto L6
    }

    AppFGSTracker(Context context, AppRestrictionController controller) {
        this(context, controller, null, null);
    }

    AppFGSTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<AppFGSPolicy>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mFGSNotificationIDs = new UidProcessMap();
        this.mTmpPkgDurations = new ArrayMap();
        this.mNotificationListener = new NotificationListener(this);
        this.mProcessObserver = new AnonymousClass1(this);
        this.mHandler = new MyHandler(this);
        this.mInjector.setPolicy(new AppFGSPolicy(this.mInjector, this));
    }

    @Override // com.android.server.am.BaseAppStateTracker
    int getType() {
        return 3;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    void onSystemReady() {
        super.onSystemReady();
        this.mInjector.getActivityManagerInternal().addForegroundServiceStateListener(this);
        this.mInjector.getActivityManagerInternal().registerProcessObserver(this.mProcessObserver);
    }

    @Override // com.android.server.am.BaseAppStateDurationsTracker, com.android.server.am.BaseAppStateEventsTracker
    void reset() {
        this.mHandler.removeMessages(4);
        super.reset();
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public PackageDurations createAppStateEvents(int uid, String packageName) {
        return new PackageDurations(uid, packageName, (BaseAppStateEvents.MaxTrackingDurationConfig) this.mInjector.getPolicy(), this);
    }

    public PackageDurations createAppStateEvents(PackageDurations other) {
        return new PackageDurations(other);
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
    private void handleForegroundServicesChanged(String packageName, int pid, int uid, boolean started) {
        if (((AppFGSPolicy) this.mInjector.getPolicy()).isEnabled() == true) goto L5;
        return;
    L5:
        long now = SystemClock.elapsedRealtime();
        int exemptReason = ((AppFGSPolicy) this.mInjector.getPolicy()).shouldExemptUid(uid);
        Object r4 = this.mLock;
        monitor-enter(r4);
        PackageDurations pkg = (PackageDurations) this.mPkgEvents.get(uid, packageName);     // Catch: Throwable -> L10
        if (pkg != null) goto L12;
        pkg = createAppStateEvents(uid, packageName);     // Catch: Throwable -> L10
        this.mPkgEvents.put(uid, packageName, pkg);     // Catch: Throwable -> L10
    L12:
        boolean wasLongRunning = pkg.isLongRunning();     // Catch: Throwable -> L10
        pkg.addEvent(started, now);     // Catch: Throwable -> L10
        if (wasLongRunning == true) goto L15;
    L17:
        boolean r8 = false;
    L18:
        boolean longRunningFGSGone = r8;
        if (longRunningFGSGone == false) goto L21;
        pkg.setIsLongRunning(false);     // Catch: Throwable -> L10
    L21:
        pkg.mExemptReason = exemptReason;     // Catch: Throwable -> L10
        scheduleDurationCheckLocked(now);     // Catch: Throwable -> L10
        monitor-exit(r4);     // Catch: Throwable -> L10
        if (longRunningFGSGone == false) goto L30;
        ((AppFGSPolicy) this.mInjector.getPolicy()).onLongRunningFgsGone(packageName, uid);
        return;
    L30:
        return;
    L15:
        if (pkg.hasForegroundServices() == true) goto L17;
        r8 = true;
    L10:
        th = move-exception;
        throw th;
    }

    private void handleForegroundServiceNotificationUpdated(String packageName, int uid, int notificationId, boolean canceling) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseBooleanArray notificationIDs = this.mFGSNotificationIDs.get(uid, packageName);     // Catch: Throwable -> L33
        if (canceling == true) goto L12;
        if (notificationIDs != null) goto L10;
        notificationIDs = new SparseBooleanArray();     // Catch: Throwable -> L8
        this.mFGSNotificationIDs.put(uid, packageName, notificationIDs);     // Catch: Throwable -> L8
    L10:
        notificationIDs.put(notificationId, false);     // Catch: Throwable -> L8
    L38:
        monitor-exit(r1);     // Catch: Throwable -> L31
        return;
    L12:
        if (notificationIDs == null) goto L38;
        int indexOfKey = notificationIDs.indexOfKey(notificationId);     // Catch: Throwable -> L33
        if (indexOfKey < 0) goto L38;
        boolean wasVisible = notificationIDs.valueAt(indexOfKey);     // Catch: Throwable -> L33
        notificationIDs.removeAt(indexOfKey);     // Catch: Throwable -> L33
        if (notificationIDs.size() != 0) goto L19;
        this.mFGSNotificationIDs.remove(uid, packageName);     // Catch: Throwable -> L8
    L19:
        int i = notificationIDs.size() - 1;
    L20:
        if (i < 0) goto L27;
        if (notificationIDs.valueAt(i) == true) goto L23;
        i = i - 1;
        goto L20
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L27:
        if (wasVisible == false) goto L38;
        notifyListenersOnStateChange(uid, packageName, false, SystemClock.elapsedRealtime(), 8);     // Catch: Throwable -> L31
    L8:
        th = th;
    L40:
        monitor-exit(r1);     // Catch: Throwable -> L31
        throw th;
    L31:
        th = th;
    L33:
        th = th;
        goto L40
    }

    private boolean hasForegroundServiceNotificationsLocked(String packageName, int uid) {
        SparseBooleanArray notificationIDs = this.mFGSNotificationIDs.get(uid, packageName);
        if (notificationIDs != null) goto L5;
    L15:
        return false;
    L5:
        if (notificationIDs.size() == 0) goto L15;
        int i = notificationIDs.size() - 1;
    L8:
        if (i < 0) goto L14;
        if (notificationIDs.valueAt(i) == true) goto L11;
        i = i - 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    private void handleNotificationPosted(String pkgName, int uid, int notificationId) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        SparseBooleanArray notificationIDs = this.mFGSNotificationIDs.get(uid, pkgName);     // Catch: Throwable -> L13
        if (notificationIDs == null) goto L27;
        int indexOfKey = notificationIDs.indexOfKey(notificationId);     // Catch: Throwable -> L13
        if (indexOfKey < 0) goto L27;
        if (notificationIDs.valueAt(indexOfKey) == false) goto L15;
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L15:
        int i = notificationIDs.size() - 1;     // Catch: Throwable -> L13
    L16:
        if (i < 0) goto L21;
        if (notificationIDs.valueAt(i) == true) goto L19;
        i = i - 1;     // Catch: Throwable -> L13
        goto L16
    L19:
        boolean anyVisible = true;
    L22:
        notificationIDs.setValueAt(indexOfKey, true);     // Catch: Throwable -> L13
        if (anyVisible == true) goto L25;
        notifyListenersOnStateChange(uid, pkgName, true, SystemClock.elapsedRealtime(), 8);     // Catch: Throwable -> L13
    L25:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L21:
        anyVisible = false;
    L27:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void handleNotificationRemoved(String pkgName, int uid, int notificationId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseBooleanArray notificationIDs = this.mFGSNotificationIDs.get(uid, pkgName);     // Catch: Throwable -> L32
        if (notificationIDs == null) goto L35;
        int indexOfKey = notificationIDs.indexOfKey(notificationId);     // Catch: Throwable -> L32
        if (indexOfKey < 0) goto L35;
        if (notificationIDs.valueAt(indexOfKey) == true) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L16:
        notificationIDs.setValueAt(indexOfKey, false);     // Catch: Throwable -> L32
        int i = notificationIDs.size() - 1;
    L18:
        if (i < 0) goto L25;
        if (notificationIDs.valueAt(i) == true) goto L21;
        i = i - 1;
        goto L18
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L25:
        notifyListenersOnStateChange(uid, pkgName, false, SystemClock.elapsedRealtime(), 8);     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    L13:
        th = th;
    L37:
        monitor-exit(r1);     // Catch: Throwable -> L30
        throw th;
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    L30:
        th = th;
    L32:
        th = th;
        goto L37
    }

    private void scheduleDurationCheckLocked(long now) {
        SparseArray<ArrayMap<String, PackageDurations>> map = this.mPkgEvents.getMap();
        long longest = -1;
        int i = map.size() - 1;
    L3:
        if (i < 0) goto L14;
        ArrayMap<String, PackageDurations> val = map.valueAt(i);
        int j = val.size() - 1;
    L5:
        if (j < 0) goto L13;
        PackageDurations pkg = val.valueAt(j);
        if (pkg.hasForegroundServices() == false) goto L12;
        if (pkg.isLongRunning() == true) goto L12;
        longest = Math.max(getTotalDurations(pkg, now), longest);
    L12:
        j = j - 1;
        goto L5
    L13:
        i = i - 1;
        goto L3
    L14:
        this.mHandler.removeMessages(4);
        if (longest < 0) goto L23;
        long future = this.mInjector.getServiceStartForegroundTimeout() + Math.max(0, ((AppFGSPolicy) this.mInjector.getPolicy()).getFgsLongRunningThreshold() - longest);
        this.mHandler.sendEmptyMessageDelayed(4, future);
        return;
    }

    private void checkLongRunningFgs() {
        AppFGSPolicy policy = (AppFGSPolicy) this.mInjector.getPolicy();
        final ArrayMap<PackageDurations, Long> pkgWithLongFgs = this.mTmpPkgDurations;
        long now = SystemClock.elapsedRealtime();
        long threshold = policy.getFgsLongRunningThreshold();
        long windowSize = policy.getFgsLongRunningWindowSize();
        long trimTo = Math.max(0, now - windowSize);
        Object r12 = this.mLock;
        monitor-enter(r12);
        SparseArray<ArrayMap<String, PackageDurations>> map = this.mPkgEvents.getMap();     // Catch: Throwable -> L20
        int i = map.size() - 1;     // Catch: Throwable -> L20
    L5:
        if (i < 0) goto L25;
        ArrayMap<String, PackageDurations> val = map.valueAt(i);     // Catch: Throwable -> L20
        int j = val.size() - 1;     // Catch: Throwable -> L20
    L7:
        if (j < 0) goto L24;
        PackageDurations pkg = val.valueAt(j);     // Catch: Throwable -> L20
        if (pkg.hasForegroundServices() == true) goto L11;
    L22:
        SparseArray<ArrayMap<String, PackageDurations>> map2 = map;
    L23:
        j = j - 1;     // Catch: Throwable -> L17
        map = map2;
        threshold = threshold;
        goto L7
    L11:
        if (pkg.isLongRunning() == true) goto L22;
        map2 = map;
        long totalDuration = getTotalDurations(pkg, now);     // Catch: Throwable -> L20
        if (totalDuration < threshold) goto L23;
        pkgWithLongFgs.put(pkg, Long.valueOf(totalDuration));     // Catch: Throwable -> L17
        pkg.setIsLongRunning(true);     // Catch: Throwable -> L17
        goto L23
    L24:
        i = i - 1;     // Catch: Throwable -> L17
        threshold = threshold;
        goto L5
    L25:
        trim(trimTo);     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        int size = pkgWithLongFgs.size();
        if (size <= 0) goto L36;
        Integer[] indices = new Integer[size];
        int i2 = 0;
    L30:
        if (i2 >= size) goto L32;
        indices[i2] = Integer.valueOf(i2);
        i2 = i2 + 1;
        goto L30
    L32:
        Arrays.sort(indices, new AppFGSTracker$$ExternalSyntheticLambda0(pkgWithLongFgs));
        int i3 = size - 1;
    L33:
        if (i3 < 0) goto L35;
        PackageDurations pkg2 = pkgWithLongFgs.keyAt(indices[i3].intValue());
        policy.onLongRunningFgs(pkg2.mPackageName, pkg2.mUid, pkg2.mExemptReason);
        i3 = i3 - 1;
        goto L33
    L35:
        pkgWithLongFgs.clear();
    L36:
        Object r7 = this.mLock;
        monitor-enter(r7);
        scheduleDurationCheckLocked(now);     // Catch: Throwable -> L41
        monitor-exit(r7);     // Catch: Throwable -> L41
        return;
    L41:
        th = move-exception;
        throw th;
    L17:
        th = th;
    L44:
        monitor-exit(r12);     // Catch: Throwable -> L17
        throw th;
    L20:
        th = th;
        goto L44
    }

    private static /* synthetic */ int lambda$checkLongRunningFgs$0(ArrayMap pkgWithLongFgs, Integer a, Integer b) {
        return Long.compare(((Long) pkgWithLongFgs.valueAt(a.intValue())).longValue(), ((Long) pkgWithLongFgs.valueAt(b.intValue())).longValue());
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
    private void handleForegroundServicesChanged(String packageName, int uid, int serviceTypes) {
        if (((AppFGSPolicy) this.mInjector.getPolicy()).isEnabled() == true) goto L5;
        return;
    L5:
        int exemptReason = ((AppFGSPolicy) this.mInjector.getPolicy()).shouldExemptUid(uid);
        long now = SystemClock.elapsedRealtime();
        Object r3 = this.mLock;
        monitor-enter(r3);
        PackageDurations pkg = (PackageDurations) this.mPkgEvents.get(uid, packageName);     // Catch: Throwable -> L10
        if (pkg != null) goto L12;
        pkg = new PackageDurations(uid, packageName, (BaseAppStateEvents.MaxTrackingDurationConfig) this.mInjector.getPolicy(), this);     // Catch: Throwable -> L10
        this.mPkgEvents.put(uid, packageName, pkg);     // Catch: Throwable -> L10
    L12:
        pkg.setForegroundServiceType(serviceTypes, now);     // Catch: Throwable -> L10
        pkg.mExemptReason = exemptReason;     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onBgFgsMonitorEnabled(boolean enabled) {
        if (enabled == false) goto L31;
        Object r0 = this.mLock;
        monitor-enter(r0);
        scheduleDurationCheckLocked(SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mNotificationListener.registerAsSystemService(this.mContext, new ComponentName(this.mContext, NotificationListener.class), -1);     // Catch: RemoteException -> L9
        return;
    L34:
        return;
    L11:
        th = move-exception;
        throw th;
    L31:
        this.mNotificationListener.unregisterAsSystemService();     // Catch: RemoteException -> L16
    L17:
        this.mHandler.removeMessages(4);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mPkgEvents.clear();     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    private void onBgFgsLongRunningThresholdChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (((AppFGSPolicy) this.mInjector.getPolicy()).isEnabled() == false) goto L9;
        scheduleDurationCheckLocked(SystemClock.elapsedRealtime());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    static int foregroundServiceTypeToIndex(int serviceType) {
        if (serviceType != 0) goto L5;
        return 0;
    L5:
        return Integer.numberOfTrailingZeros(serviceType) + 1;
    }

    static int indexToForegroundServiceType(int index) {
        if (index != PackageDurations.DEFAULT_INDEX) goto L6;
        return 0;
    L6:
        return 1 << (index - 1);
    }

    long getTotalDurations(PackageDurations pkg, long now) {
        return getTotalDurations(pkg.mPackageName, pkg.mUid, now, foregroundServiceTypeToIndex(0));
    }

    @Override // com.android.server.am.BaseAppStateDurationsTracker
    long getTotalDurations(int uid, long now) {
        return getTotalDurations(uid, now, foregroundServiceTypeToIndex(0));
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
    boolean hasForegroundServices(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageDurations pkg = (PackageDurations) this.mPkgEvents.get(uid, packageName);     // Catch: Throwable -> L9
        if (pkg != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (pkg.hasForegroundServices() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean hasForegroundServices(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<ArrayMap<String, PackageDurations>> map = this.mPkgEvents.getMap();     // Catch: Throwable -> L12
        ArrayMap<String, PackageDurations> pkgs = map.get(uid);     // Catch: Throwable -> L12
        if (pkgs == null) goto L15;
        int i = pkgs.size() - 1;     // Catch: Throwable -> L12
    L7:
        if (i < 0) goto L15;
        PackageDurations pkg = pkgs.valueAt(i);     // Catch: Throwable -> L12
        if (pkg.hasForegroundServices() == true) goto L10;
        i = i - 1;     // Catch: Throwable -> L12
        goto L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    boolean hasForegroundServiceNotifications(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = hasForegroundServiceNotificationsLocked(packageName, uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean hasForegroundServiceNotifications(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<ArrayMap<String, SparseBooleanArray>> map = this.mFGSNotificationIDs.getMap();     // Catch: Throwable -> L12
        ArrayMap<String, SparseBooleanArray> pkgs = map.get(uid);     // Catch: Throwable -> L12
        if (pkgs == null) goto L15;
        int i = pkgs.size() - 1;     // Catch: Throwable -> L12
    L7:
        if (i < 0) goto L15;
        if (hasForegroundServiceNotificationsLocked(pkgs.keyAt(i), uid) == true) goto L10;
        i = i - 1;     // Catch: Throwable -> L12
        goto L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.am.BaseAppStateTracker
    byte[] getTrackerInfoForStatsd(int uid) {
        long fgsDurations = getTotalDurations(uid, SystemClock.elapsedRealtime());
        if (fgsDurations != 0) goto L6;
        return null;
    L6:
        ProtoOutputStream proto = new ProtoOutputStream();
        proto.write(1133871366145L, hasForegroundServiceNotifications(uid));
        proto.write(1112396529666L, fgsDurations);
        proto.flush();
        return proto.getBytes();
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker, com.android.server.am.BaseAppStateTracker
    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.println("APP FOREGROUND SERVICE TRACKER:");
        super.dump(pw, "  " + prefix);
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker
    void dumpOthers(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.println("APPS WITH ACTIVE FOREGROUND SERVICES:");
        String prefix2 = "  " + prefix;
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<ArrayMap<String, SparseBooleanArray>> map = this.mFGSNotificationIDs.getMap();     // Catch: Throwable -> L7
        if (map.size() != 0) goto L9;
        pw.print(prefix2);     // Catch: Throwable -> L7
        pw.println("(none)");     // Catch: Throwable -> L7
    L9:
        int i = 0;
        int size = map.size();     // Catch: Throwable -> L7
    L10:
        if (i >= size) goto L16;
        int uid = map.keyAt(i);     // Catch: Throwable -> L7
        String uidString = UserHandle.formatUid(uid);     // Catch: Throwable -> L7
        ArrayMap<String, SparseBooleanArray> pkgs = map.valueAt(i);     // Catch: Throwable -> L7
        int j = 0;
        int numOfPkgs = pkgs.size();     // Catch: Throwable -> L7
    L12:
        if (j >= numOfPkgs) goto L14;
        String pkgName = pkgs.keyAt(j);     // Catch: Throwable -> L7
        pw.print(prefix2);     // Catch: Throwable -> L7
        pw.print(pkgName);     // Catch: Throwable -> L7
        pw.print('/');     // Catch: Throwable -> L7
        pw.print(uidString);     // Catch: Throwable -> L7
        pw.print(" notification=");     // Catch: Throwable -> L7
        pw.println(hasForegroundServiceNotificationsLocked(pkgName, uid));     // Catch: Throwable -> L7
        j = j + 1;     // Catch: Throwable -> L7
        goto L12
    L14:
        i = i + 1;     // Catch: Throwable -> L7
        goto L10
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}

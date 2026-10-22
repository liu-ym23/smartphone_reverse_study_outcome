package com.android.server.am;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.internal.app.ProcessMap;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AppMediaSessionTracker extends BaseAppStateDurationsTracker<AppMediaSessionPolicy, BaseAppStateDurationsTracker.SimplePackageDurations> {
    static final boolean DEBUG_MEDIA_SESSION_TRACKER = false;
    static final String TAG = "ActivityManager";
    private final HandlerExecutor mHandlerExecutor;
    private final MediaSessionManager.OnActiveSessionsChangedListener mSessionsChangedListener;
    private final ProcessMap<Boolean> mTmpMediaControllers;

    static final class AppMediaSessionPolicy extends BaseAppStateEventsTracker.BaseAppStateEventsPolicy<AppMediaSessionTracker> {
        static final boolean DEFAULT_BG_MEDIA_SESSION_MONITOR_ENABLED = true;
        static final long DEFAULT_BG_MEDIA_SESSION_MONITOR_MAX_TRACKING_DURATION = 345600000;
        static final String KEY_BG_MEADIA_SESSION_MONITOR_ENABLED = "bg_media_session_monitor_enabled";
        static final String KEY_BG_MEDIA_SESSION_MONITOR_MAX_TRACKING_DURATION = "bg_media_session_monitor_max_tracking_duration";

        public static /* synthetic */ void $r8$lambda$vU9Y6O_Ak5yd1fFgiQvvDQnuaxQ(AppMediaSessionTracker r0) {
            AppMediaSessionTracker.m1310$$Nest$mtrimDurations(r0);
        }

        AppMediaSessionPolicy(BaseAppStateTracker.Injector injector, AppMediaSessionTracker tracker) {
            super(injector, tracker, KEY_BG_MEADIA_SESSION_MONITOR_ENABLED, true, KEY_BG_MEDIA_SESSION_MONITOR_MAX_TRACKING_DURATION, DEFAULT_BG_MEDIA_SESSION_MONITOR_MAX_TRACKING_DURATION);
        }

        @Override // com.android.server.am.BaseAppStatePolicy
        public void onTrackerEnabled(boolean enabled) {
            AppMediaSessionTracker.m1309$$Nest$monBgMediaSessionMonitorEnabled((AppMediaSessionTracker) this.mTracker, enabled);
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy
        public void onMaxTrackingDurationChanged(long maxDuration) {
            Handler r0 = ((AppMediaSessionTracker) this.mTracker).mBgHandler;
            final AppMediaSessionTracker r1 = (AppMediaSessionTracker) this.mTracker;
            r1.getClass();
            r0.post(new AppMediaSessionTracker$AppMediaSessionPolicy$$ExternalSyntheticLambda0(r1));
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy
        String getExemptionReasonString(String packageName, int uid, int reason) {
            return "n/a";
        }

        @Override // com.android.server.am.BaseAppStateEventsTracker.BaseAppStateEventsPolicy, com.android.server.am.BaseAppStatePolicy
        void dump(PrintWriter pw, String prefix) {
            pw.print(prefix);
            pw.println("APP MEDIA SESSION TRACKER POLICY SETTINGS:");
            super.dump(pw, "  " + prefix);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$QGd-MrvifawKK7V_H96hUv85JPk, reason: not valid java name */
    public static /* synthetic */ void m1308$r8$lambda$QGdMrvifawKK7V_H96hUv85JPk(AppMediaSessionTracker r0, List r1) {
        r0.handleMediaSessionChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monBgMediaSessionMonitorEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1309$$Nest$monBgMediaSessionMonitorEnabled(AppMediaSessionTracker r0, boolean r1) {
        r0.onBgMediaSessionMonitorEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtrimDurations, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1310$$Nest$mtrimDurations(AppMediaSessionTracker r0) {
        r0.trimDurations();
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public /* bridge */ /* synthetic */ BaseAppStateEvents createAppStateEvents(int r1, String r2) {
        return createAppStateEvents(r1, r2);
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public /* bridge */ /* synthetic */ BaseAppStateEvents createAppStateEvents(BaseAppStateEvents r1) {
        return createAppStateEvents((BaseAppStateDurationsTracker.SimplePackageDurations) r1);
    }

    AppMediaSessionTracker(Context context, AppRestrictionController controller) {
        this(context, controller, null, null);
    }

    AppMediaSessionTracker(Context context, AppRestrictionController controller, Constructor<? extends BaseAppStateTracker.Injector<AppMediaSessionPolicy>> injector, Object outerContext) {
        super(context, controller, injector, outerContext);
        this.mSessionsChangedListener = new AppMediaSessionTracker$$ExternalSyntheticLambda0(this);
        this.mTmpMediaControllers = new ProcessMap();
        this.mHandlerExecutor = new HandlerExecutor(this.mBgHandler);
        this.mInjector.setPolicy(new AppMediaSessionPolicy(this.mInjector, this));
    }

    @Override // com.android.server.am.BaseAppStateEvents.Factory
    public BaseAppStateDurationsTracker.SimplePackageDurations createAppStateEvents(int uid, String packageName) {
        return new BaseAppStateDurationsTracker.SimplePackageDurations(uid, packageName, (BaseAppStateEvents.MaxTrackingDurationConfig) this.mInjector.getPolicy());
    }

    public BaseAppStateDurationsTracker.SimplePackageDurations createAppStateEvents(BaseAppStateDurationsTracker.SimplePackageDurations other) {
        return new BaseAppStateDurationsTracker.SimplePackageDurations(other);
    }

    private void onBgMediaSessionMonitorEnabled(boolean enabled) {
        if (enabled == false) goto L4;
        this.mInjector.getMediaSessionManager().addOnActiveSessionsChangedListener(null, UserHandle.ALL, this.mHandlerExecutor, this.mSessionsChangedListener);
        return;
    L4:
        this.mInjector.getMediaSessionManager().removeOnActiveSessionsChangedListener(this.mSessionsChangedListener);
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
    private void handleMediaSessionChanged(List<MediaController> controllers) {
        if (controllers == null) goto L35;
        Object r9 = this.mLock;
        monitor-enter(r9);
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        Iterator<MediaController> r10 = controllers.iterator();     // Catch: Throwable -> L12
    L8:
        if (r10.hasNext() == false) goto L19;
        MediaController controller = r10.next();     // Catch: Throwable -> L12
        String packageName = controller.getPackageName();     // Catch: Throwable -> L12
        int uid = controller.getSessionToken().getUid();     // Catch: Throwable -> L12
        BaseAppStateDurationsTracker.SimplePackageDurations pkg = (BaseAppStateDurationsTracker.SimplePackageDurations) this.mPkgEvents.get(uid, packageName);     // Catch: Throwable -> L12
        if (pkg != null) goto L14;
        BaseAppStateDurationsTracker.SimplePackageDurations pkg2 = createAppStateEvents(uid, packageName);     // Catch: Throwable -> L12
        this.mPkgEvents.put(uid, packageName, pkg2);     // Catch: Throwable -> L12
        BaseAppStateDurationsTracker.SimplePackageDurations pkg3 = pkg2;
    L16:
        if (pkg3.isActive() == true) goto L18;
        pkg3.addEvent(true, now);     // Catch: Throwable -> L12
        notifyListenersOnStateChange(pkg3.mUid, pkg3.mPackageName, true, now, 1);     // Catch: Throwable -> L12
    L18:
        this.mTmpMediaControllers.put(packageName, uid, Boolean.TRUE);     // Catch: Throwable -> L12
        goto L8
    L14:
        pkg3 = pkg;
        goto L16
    L19:
        SparseArray<ArrayMap<String, BaseAppStateDurationsTracker.SimplePackageDurations>> map = this.mPkgEvents.getMap();     // Catch: Throwable -> L12
        int i = map.size() - 1;     // Catch: Throwable -> L12
    L20:
        if (i < 0) goto L31;
        ArrayMap<String, BaseAppStateDurationsTracker.SimplePackageDurations> val = map.valueAt(i);     // Catch: Throwable -> L12
        int j = val.size() - 1;     // Catch: Throwable -> L12
    L22:
        if (j < 0) goto L29;
        BaseAppStateDurationsTracker.SimplePackageDurations pkg4 = val.valueAt(j);     // Catch: Throwable -> L12
        if (pkg4.isActive() == false) goto L28;
        if (this.mTmpMediaControllers.get(pkg4.mPackageName, pkg4.mUid) != null) goto L28;
        pkg4.addEvent(false, now);     // Catch: Throwable -> L12
        notifyListenersOnStateChange(pkg4.mUid, pkg4.mPackageName, false, now, 1);     // Catch: Throwable -> L12
    L28:
        j = j - 1;     // Catch: Throwable -> L12
        goto L22
    L29:
        i = i - 1;     // Catch: Throwable -> L12
        goto L20
    L31:
        monitor-exit(r9);     // Catch: Throwable -> L12
        this.mTmpMediaControllers.clear();
        return;
    L12:
        th = move-exception;
        throw th;
    L35:
        Object r11 = this.mLock;
        monitor-enter(r11);
        SparseArray<ArrayMap<String, BaseAppStateDurationsTracker.SimplePackageDurations>> map2 = this.mPkgEvents.getMap();     // Catch: Throwable -> L44
        long now2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L44
        int i2 = map2.size() - 1;     // Catch: Throwable -> L44
    L38:
        if (i2 < 0) goto L49;
        ArrayMap<String, BaseAppStateDurationsTracker.SimplePackageDurations> val2 = map2.valueAt(i2);     // Catch: Throwable -> L44
        int j2 = val2.size() - 1;     // Catch: Throwable -> L44
    L40:
        if (j2 < 0) goto L47;
        BaseAppStateDurationsTracker.SimplePackageDurations pkg5 = val2.valueAt(j2);     // Catch: Throwable -> L44
        if (pkg5.isActive() == false) goto L46;
        pkg5.addEvent(false, now2);     // Catch: Throwable -> L44
        notifyListenersOnStateChange(pkg5.mUid, pkg5.mPackageName, false, now2, 1);     // Catch: Throwable -> L44
    L46:
        j2 = j2 - 1;     // Catch: Throwable -> L44
        goto L40
    L47:
        i2 = i2 - 1;     // Catch: Throwable -> L44
        goto L38
    L49:
        monitor-exit(r11);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        throw th;
    }

    private void trimDurations() {
        long now = SystemClock.elapsedRealtime();
        trim(Math.max(0, now - ((AppMediaSessionPolicy) this.mInjector.getPolicy()).getMaxTrackingDuration()));
    }

    @Override // com.android.server.am.BaseAppStateTracker
    int getType() {
        return 4;
    }

    @Override // com.android.server.am.BaseAppStateEventsTracker, com.android.server.am.BaseAppStateTracker
    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.println("APP MEDIA SESSION TRACKER:");
        super.dump(pw, "  " + prefix);
    }
}

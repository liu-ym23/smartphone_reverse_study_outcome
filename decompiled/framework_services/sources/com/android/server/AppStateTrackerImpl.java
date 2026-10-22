package com.android.server;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseSetArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.IAppOpsCallback;
import com.android.internal.app.IAppOpsService;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.internal.util.jobs.StatLogger;
import com.android.modules.expresslog.Counter;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.usage.AppStandbyInternal;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AppStateTrackerImpl implements AppStateTracker {
    private static final String APP_RESTRICTION_COUNTER_METRIC_ID = "battery.value_app_background_restricted";
    private static final boolean DEBUG = false;
    static final int TARGET_OP = 70;
    final SparseBooleanArray mActiveUids;
    ActivityManagerInternal mActivityManagerInternal;
    private final ActivityManagerInternal.AppBackgroundRestrictionListener mAppBackgroundRestrictionListener;
    AppOpsManager mAppOpsManager;
    IAppOpsService mAppOpsService;
    AppStandbyInternal mAppStandbyInternal;
    volatile Set<Pair<Integer, String>> mBackgroundRestrictedUidPackages;
    boolean mBatterySaverEnabled;
    private final Context mContext;
    final SparseSetArray<String> mExemptedBucketPackages;
    FeatureFlagsObserver mFlagsObserver;
    boolean mForceAllAppStandbyForSmallBattery;
    boolean mForceAllAppsStandby;
    private final MyHandler mHandler;
    IActivityManager mIActivityManager;
    boolean mIsPluggedIn;
    final ArraySet<Listener> mListeners;
    private final Object mLock;
    private int[] mPowerExemptAllAppIds;
    private int[] mPowerExemptUserAppIds;
    PowerManagerInternal mPowerManagerInternal;
    private final BroadcastReceiver mReceiver;
    final ArraySet<Pair<Integer, String>> mRunAnyRestrictedPackages;
    StandbyTracker mStandbyTracker;
    boolean mStarted;
    private final StatLogger mStatLogger;
    private int[] mTempExemptAppIds;

    private final class AppOpsWatcher extends IAppOpsCallback.Stub {
        final /* synthetic */ AppStateTrackerImpl this$0;

        /* synthetic */ AppOpsWatcher(AppStateTrackerImpl r1, AppStateTrackerImplIA r2) {
            this(r1);
        }

        private AppOpsWatcher(AppStateTrackerImpl r1) {
            this.this$0 = r1;
        }

        public void opChanged(int op, int uid, String packageName, String persistentDeviceId) throws RemoteException {
            boolean restricted = false;
            if (this.this$0.mAppOpsService.checkOperation(70, uid, packageName) == 0) goto L6;
            boolean r1 = true;
        L7:
            restricted = r1;
            goto L9
        L6:
            r1 = false;
        L9:
            if (restricted == false) goto L11;
            Counter.logIncrementWithUid(AppStateTrackerImpl.APP_RESTRICTION_COUNTER_METRIC_ID, uid);
        L11:
            Object r2 = AppStateTrackerImpl.m65$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
        L16:
            th = move-exception;
            throw th;
        L14:
            if (this.this$0.updateForcedAppStandbyUidPackageLocked(uid, packageName, restricted) == false) goto L18;
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).notifyRunAnyAppOpsChanged(uid, packageName);     // Catch: Throwable -> L16
        L18:
            monitor-exit(r2);     // Catch: Throwable -> L16
        }
    }

    class FeatureFlagsObserver extends ContentObserver {
        final /* synthetic */ AppStateTrackerImpl this$0;

        FeatureFlagsObserver(AppStateTrackerImpl this$0) {
            this.this$0 = this$0;
            super(null);
        }

        void register() {
            AppStateTrackerImpl.m63$$Nest$fgetmContext(this.this$0).getContentResolver().registerContentObserver(Settings.Global.getUriFor("forced_app_standby_for_small_battery_enabled"), false, this);
        }

        boolean isForcedAppStandbyForSmallBatteryEnabled() {
            if (this.this$0.injectGetGlobalSettingInt("forced_app_standby_for_small_battery_enabled", 0) == 1) goto L5;
            return false;
        L5:
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (Settings.Global.getUriFor("forced_app_standby_for_small_battery_enabled").equals(uri) == false) goto L17;
            boolean enabled = isForcedAppStandbyForSmallBatteryEnabled();
            Object r1 = AppStateTrackerImpl.m65$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.mForceAllAppStandbyForSmallBattery != enabled) goto L12;
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L12:
            this.this$0.mForceAllAppStandbyForSmallBattery = enabled;     // Catch: Throwable -> L10
            AppStateTrackerImpl.m69$$Nest$mupdateForceAllAppStandbyState(this.this$0);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L17:
            Slog.w("AppStateTracker", "Unexpected feature flag uri encountered: " + uri);
        }
    }

    public static abstract class Listener {
        /* JADX INFO: renamed from: -$$Nest$monAutoRestrictedBucketFeatureFlagChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m72$$Nest$monAutoRestrictedBucketFeatureFlagChanged(Listener r0, AppStateTrackerImpl r1, boolean r2) {
            r0.onAutoRestrictedBucketFeatureFlagChanged(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$monExemptedBucketChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m73$$Nest$monExemptedBucketChanged(Listener r0, AppStateTrackerImpl r1) {
            r0.onExemptedBucketChanged(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monForceAllAppsStandbyChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m74$$Nest$monForceAllAppsStandbyChanged(Listener r0, AppStateTrackerImpl r1) {
            r0.onForceAllAppsStandbyChanged(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monPowerSaveExemptionListChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m75$$Nest$monPowerSaveExemptionListChanged(Listener r0, AppStateTrackerImpl r1) {
            r0.onPowerSaveExemptionListChanged(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monPowerSaveUnexempted, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m76$$Nest$monPowerSaveUnexempted(Listener r0, AppStateTrackerImpl r1) {
            r0.onPowerSaveUnexempted(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monRunAnyAppOpsChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m77$$Nest$monRunAnyAppOpsChanged(Listener r0, AppStateTrackerImpl r1, int r2, String r3) {
            r0.onRunAnyAppOpsChanged(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$monTempPowerSaveExemptionListChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m78$$Nest$monTempPowerSaveExemptionListChanged(Listener r0, AppStateTrackerImpl r1) {
            r0.onTempPowerSaveExemptionListChanged(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monUidActiveStateChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m79$$Nest$monUidActiveStateChanged(Listener r0, AppStateTrackerImpl r1, int r2) {
            r0.onUidActiveStateChanged(r1, r2);
        }

        public Listener() {
        }

        private void onRunAnyAppOpsChanged(AppStateTrackerImpl sender, int uid, String packageName) {
            updateJobsForUidPackage(uid, packageName, sender.isUidActive(uid));
            if (sender.areAlarmsRestricted(uid, packageName) == true) goto L6;
            unblockAlarmsForUidPackage(uid, packageName);
        L6:
            if (sender.isRunAnyInBackgroundAppOpsAllowed(uid, packageName) == true) goto L8;
            Slog.v("AppStateTracker", "Package " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + uid + " toggled into fg service restriction");
            updateBackgroundRestrictedForUidPackage(uid, packageName, true);
            return;
        L8:
            Slog.v("AppStateTracker", "Package " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + uid + " toggled out of fg service restriction");
            updateBackgroundRestrictedForUidPackage(uid, packageName, false);
        }

        private void onUidActiveStateChanged(AppStateTrackerImpl sender, int uid) {
            boolean isActive = sender.isUidActive(uid);
            updateJobsForUid(uid, isActive);
            updateAlarmsForUid(uid);
            if (isActive == false) goto L6;
            unblockAlarmsForUid(uid);
            return;
        }

        private void onPowerSaveUnexempted(AppStateTrackerImpl sender) {
            updateAllJobs();
            updateAllAlarms();
        }

        private void onPowerSaveExemptionListChanged(AppStateTrackerImpl sender) {
            updateAllJobs();
            updateAllAlarms();
            unblockAllUnrestrictedAlarms();
        }

        private void onTempPowerSaveExemptionListChanged(AppStateTrackerImpl sender) {
            updateAllJobs();
        }

        private void onExemptedBucketChanged(AppStateTrackerImpl sender) {
            updateAllJobs();
            updateAllAlarms();
        }

        private void onForceAllAppsStandbyChanged(AppStateTrackerImpl sender) {
            updateAllJobs();
            updateAllAlarms();
        }

        private void onAutoRestrictedBucketFeatureFlagChanged(AppStateTrackerImpl sender, boolean autoRestrictedBucket) {
            updateAllJobs();
            if (autoRestrictedBucket == false) goto L6;
            unblockAllUnrestrictedAlarms();
            return;
        }

        public void updateAllJobs() {
        }

        public void updateJobsForUid(int uid, boolean isNowActive) {
        }

        public void updateJobsForUidPackage(int uid, String packageName, boolean isNowActive) {
        }

        public void updateBackgroundRestrictedForUidPackage(int uid, String packageName, boolean restricted) {
        }

        public void updateAllAlarms() {
        }

        public void updateAlarmsForUid(int uid) {
        }

        public void unblockAllUnrestrictedAlarms() {
        }

        public void unblockAlarmsForUid(int uid) {
        }

        public void unblockAlarmsForUidPackage(int uid, String packageName) {
        }

        public void removeAlarmsForUid(int uid) {
        }

        public void handleUidCachedChanged(int uid, boolean cached) {
        }
    }

    private class MyHandler extends Handler {
        private static final int MSG_ALL_EXEMPTION_LIST_CHANGED = 5;
        private static final int MSG_ALL_UNEXEMPTED = 4;
        private static final int MSG_AUTO_RESTRICTED_BUCKET_FEATURE_FLAG_CHANGED = 11;
        private static final int MSG_EXEMPTED_BUCKET_CHANGED = 10;
        private static final int MSG_FORCE_ALL_CHANGED = 7;
        private static final int MSG_ON_UID_ACTIVE = 12;
        private static final int MSG_ON_UID_CACHED = 15;
        private static final int MSG_ON_UID_GONE = 13;
        private static final int MSG_ON_UID_IDLE = 14;
        private static final int MSG_RUN_ANY_CHANGED = 3;
        private static final int MSG_TEMP_EXEMPTION_LIST_CHANGED = 6;
        private static final int MSG_UID_ACTIVE_STATE_CHANGED = 0;
        private static final int MSG_USER_REMOVED = 8;
        final /* synthetic */ AppStateTrackerImpl this$0;

        MyHandler(AppStateTrackerImpl r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        public void notifyUidActiveStateChanged(int uid) {
            obtainMessage(0, uid, 0).sendToTarget();
        }

        public void notifyRunAnyAppOpsChanged(int uid, String packageName) {
            obtainMessage(3, uid, 0, packageName).sendToTarget();
        }

        public void notifyAllUnexempted() {
            removeMessages(4);
            obtainMessage(4).sendToTarget();
        }

        public void notifyAllExemptionListChanged() {
            removeMessages(5);
            obtainMessage(5).sendToTarget();
        }

        public void notifyTempExemptionListChanged() {
            removeMessages(6);
            obtainMessage(6).sendToTarget();
        }

        public void notifyForceAllAppsStandbyChanged() {
            removeMessages(7);
            obtainMessage(7).sendToTarget();
        }

        public void notifyExemptedBucketChanged() {
            removeMessages(10);
            obtainMessage(10).sendToTarget();
        }

        public void notifyAutoRestrictedBucketFeatureFlagChanged(boolean r3) {
            removeMessages(11);
            obtainMessage(11, r3 ? 1 : 0, 0).sendToTarget();
        }

        public void doUserRemoved(int userId) {
            obtainMessage(8, userId, 0).sendToTarget();
        }

        public void onUidActive(int uid) {
            obtainMessage(12, uid, 0).sendToTarget();
        }

        public void onUidGone(int r2, boolean r3) {
            obtainMessage(13, r2, r3 ? 1 : 0).sendToTarget();
        }

        public void onUidIdle(int r2, boolean r3) {
            obtainMessage(14, r2, r3 ? 1 : 0).sendToTarget();
        }

        public void onUidCachedChanged(int r2, boolean r3) {
            obtainMessage(15, r2, r3 ? 1 : 0).sendToTarget();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            switch(r10.what) {
                case 8: goto L78;
                default: goto L4;
            };
        L4:
            Object r0 = AppStateTrackerImpl.m65$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.mStarted == true) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            AppStateTrackerImpl r1 = this.this$0;
            long r2 = AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).getTime();
            int r4 = 0;
            boolean r5 = false;
            int r6 = 0;
            int r7 = 0;
            int r8 = 0;
            int r9 = 0;
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
            boolean r14 = true;
            switch(r10.what) {
                case 0: goto L71;
                case 1: goto L15;
                case 2: goto L15;
                case 3: goto L66;
                case 4: goto L61;
                case 5: goto L56;
                case 6: goto L51;
                case 7: goto L46;
                case 8: goto L44;
                case 9: goto L15;
                case 10: goto L39;
                case 11: goto L32;
                case 12: goto L29;
                case 13: goto L25;
                case 14: goto L21;
                case 15: goto L16;
                default: goto L15;
            };
        L15:
            return;
        L16:
            int r3 = r10.arg1;
            if (r10.arg2 == 0) goto L19;
            r5 = true;
        L19:
            handleUidCached(r3, r5);
            return;
        L21:
            handleUidIdle(r10.arg1);
            if (r10.arg2 == 0) goto L89;
            handleUidDisabled(r10.arg1);
            return;
        L89:
            return;
        L25:
            handleUidGone(r10.arg1);
            if (r10.arg2 == 0) goto L90;
            handleUidDisabled(r10.arg1);
            return;
        L90:
            return;
        L29:
            handleUidActive(r10.arg1);
            return;
        L39:
            Listener[] r15 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r16 = r15.length;
        L40:
            if (r7 >= r16) goto L42;
            Listener.m73$$Nest$monExemptedBucketChanged(r15[r7], r1);
            r7 = r7 + 1;
            goto L40
        L42:
            AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).logDurationStat(6, r2);
            return;
        L44:
            this.this$0.handleUserRemoved(r10.arg1);
            return;
        L46:
            Listener[] r17 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r18 = r17.length;
        L47:
            if (r8 >= r18) goto L49;
            Listener.m74$$Nest$monForceAllAppsStandbyChanged(r17[r8], r1);
            r8 = r8 + 1;
            goto L47
        L49:
            AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).logDurationStat(7, r2);
            return;
        L51:
            Listener[] r19 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r20 = r19.length;
        L52:
            if (r9 >= r20) goto L54;
            Listener.m78$$Nest$monTempPowerSaveExemptionListChanged(r19[r9], r1);
            r9 = r9 + 1;
            goto L52
        L54:
            AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).logDurationStat(5, r2);
            return;
        L56:
            Listener[] r21 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r22 = r21.length;
        L57:
            if (r11 >= r22) goto L59;
            Listener.m75$$Nest$monPowerSaveExemptionListChanged(r21[r11], r1);
            r11 = r11 + 1;
            goto L57
        L59:
            AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).logDurationStat(4, r2);
            return;
        L61:
            Listener[] r23 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r24 = r23.length;
        L62:
            if (r12 >= r24) goto L64;
            Listener.m76$$Nest$monPowerSaveUnexempted(r23[r12], r1);
            r12 = r12 + 1;
            goto L62
        L64:
            AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).logDurationStat(3, r2);
            return;
        L66:
            Listener[] r25 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r26 = r25.length;
        L67:
            if (r13 >= r26) goto L69;
            Listener.m77$$Nest$monRunAnyAppOpsChanged(r25[r13], r1, r10.arg1, (String) r10.obj);
            r13 = r13 + 1;
            goto L67
        L69:
            AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).logDurationStat(2, r2);
            return;
        L71:
            Listener[] r27 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r28 = r27.length;
        L72:
            if (r4 >= r28) goto L74;
            Listener.m79$$Nest$monUidActiveStateChanged(r27[r4], r1, r10.arg1);
            r4 = r4 + 1;
            goto L72
        L74:
            AppStateTrackerImpl.m66$$Nest$fgetmStatLogger(this.this$0).logDurationStat(1, r2);
            return;
        L32:
            if (r10.arg1 == 1) goto L35;
            r14 = false;
        L35:
            Listener[] r29 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r30 = r29.length;
        L36:
            if (r6 >= r30) goto L38;
            Listener.m72$$Nest$monAutoRestrictedBucketFeatureFlagChanged(r29[r6], r1, r14);
            r6 = r6 + 1;
            goto L36
        L38:
            return;
        L78:
            this.this$0.handleUserRemoved(r10.arg1);
        }

        private void handleUidCached(int uid, boolean cached) {
            Listener[] r0 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            Listener l = r0[r2];
            l.handleUidCachedChanged(uid, cached);
            r2 = r2 + 1;
            goto L3
        }

        private void handleUidDisabled(int uid) {
            Listener[] r0 = AppStateTrackerImpl.m67$$Nest$mcloneListeners(this.this$0);
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            Listener l = r0[r2];
            l.removeAlarmsForUid(uid);
            r2 = r2 + 1;
            goto L3
        }

        public void handleUidActive(int uid) {
            Object r0 = AppStateTrackerImpl.m65$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (AppStateTrackerImpl.m70$$Nest$smaddUidToArray(this.this$0.mActiveUids, uid) == false) goto L9;
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).notifyUidActiveStateChanged(uid);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void handleUidGone(int uid) {
            removeUid(uid, true);
        }

        public void handleUidIdle(int uid) {
            removeUid(uid, false);
        }

        private void removeUid(int uid, boolean remove) {
            Object r0 = AppStateTrackerImpl.m65$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (AppStateTrackerImpl.m71$$Nest$smremoveUidFromArray(this.this$0.mActiveUids, uid, remove) == false) goto L9;
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).notifyUidActiveStateChanged(uid);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    final class StandbyTracker extends AppStandbyInternal.AppIdleStateChangeListener {
        final /* synthetic */ AppStateTrackerImpl this$0;

        StandbyTracker(AppStateTrackerImpl this$0) {
            this.this$0 = this$0;
        }

        public void onAppIdleStateChanged(String packageName, int userId, boolean idle, int bucket, int reason) {
            Object r0 = AppStateTrackerImpl.m65$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            if (bucket != 5) goto L9;
            boolean changed = this.this$0.mExemptedBucketPackages.add(userId, packageName);     // Catch: Throwable -> L7
        L10:
            if (changed == false) goto L12;
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).notifyExemptedBucketChanged();     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            changed = this.this$0.mExemptedBucketPackages.remove(userId, packageName);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }
    }

    interface Stats {
        public static final int ALL_EXEMPTION_LIST_CHANGED = 4;
        public static final int ALL_UNEXEMPTED = 3;
        public static final int EXEMPTED_BUCKET_CHANGED = 6;
        public static final int FORCE_ALL_CHANGED = 7;
        public static final int IS_UID_ACTIVE_CACHED = 8;
        public static final int IS_UID_ACTIVE_RAW = 9;
        public static final int RUN_ANY_CHANGED = 2;
        public static final int TEMP_EXEMPTION_LIST_CHANGED = 5;
        public static final int UID_ACTIVE_STATE_CHANGED = 1;
        public static final int UID_FG_STATE_CHANGED = 0;
    }

    private final class UidObserver extends android.app.UidObserver {
        final /* synthetic */ AppStateTrackerImpl this$0;

        /* synthetic */ UidObserver(AppStateTrackerImpl r1, AppStateTrackerImplIA r2) {
            this(r1);
        }

        private UidObserver(AppStateTrackerImpl r1) {
            this.this$0 = r1;
        }

        public void onUidActive(int uid) {
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).onUidActive(uid);
        }

        public void onUidGone(int uid, boolean disabled) {
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).onUidGone(uid, disabled);
        }

        public void onUidIdle(int uid, boolean disabled) {
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).onUidIdle(uid, disabled);
        }

        public void onUidCachedChanged(int uid, boolean cached) {
            AppStateTrackerImpl.m64$$Nest$fgetmHandler(this.this$0).onUidCachedChanged(uid, cached);
        }
    }

    public static /* synthetic */ void $r8$lambda$qVyUgEB05pGgqtZDT4yMA5Prsac(AppStateTrackerImpl r0, PowerSaveState r1) {
        r0.lambda$onSystemServicesReady$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m63$$Nest$fgetmContext(AppStateTrackerImpl r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MyHandler m64$$Nest$fgetmHandler(AppStateTrackerImpl r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m65$$Nest$fgetmLock(AppStateTrackerImpl r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStatLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ StatLogger m66$$Nest$fgetmStatLogger(AppStateTrackerImpl r0) {
        return r0.mStatLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$mcloneListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ Listener[] m67$$Nest$mcloneListeners(AppStateTrackerImpl r0) {
        return r0.cloneListeners();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBackgroundRestrictedUidPackagesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m68$$Nest$mupdateBackgroundRestrictedUidPackagesLocked(AppStateTrackerImpl r0) {
        r0.updateBackgroundRestrictedUidPackagesLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateForceAllAppStandbyState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m69$$Nest$mupdateForceAllAppStandbyState(AppStateTrackerImpl r0) {
        r0.updateForceAllAppStandbyState();
    }

    /* JADX INFO: renamed from: -$$Nest$smaddUidToArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m70$$Nest$smaddUidToArray(SparseBooleanArray r0, int r1) {
        return addUidToArray(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smremoveUidFromArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m71$$Nest$smremoveUidFromArray(SparseBooleanArray r0, int r1, boolean r2) {
        return removeUidFromArray(r0, r1, r2);
    }

    public void addBackgroundRestrictedAppListener(final AppStateTracker.BackgroundRestrictedAppListener listener) {
        addListener(new AnonymousClass1(this, listener));
    }

    public boolean isAppBackgroundRestricted(int uid, String packageName) {
        Set<Pair<Integer, String>> bgRestrictedUidPkgs = this.mBackgroundRestrictedUidPackages;
        return bgRestrictedUidPkgs.contains(Pair.create(Integer.valueOf(uid), packageName));
    }

    public AppStateTrackerImpl(Context context, Looper looper) {
        this.mLock = new Object();
        this.mRunAnyRestrictedPackages = new ArraySet();
        this.mActiveUids = new SparseBooleanArray();
        this.mPowerExemptAllAppIds = new int[0];
        this.mPowerExemptUserAppIds = new int[0];
        this.mTempExemptAppIds = this.mPowerExemptAllAppIds;
        this.mExemptedBucketPackages = new SparseSetArray();
        this.mListeners = new ArraySet();
        this.mBackgroundRestrictedUidPackages = Collections.emptySet();
        this.mStatLogger = new StatLogger(new String[]{"UID_FG_STATE_CHANGED", "UID_ACTIVE_STATE_CHANGED", "RUN_ANY_CHANGED", "ALL_UNEXEMPTED", "ALL_EXEMPTION_LIST_CHANGED", "TEMP_EXEMPTION_LIST_CHANGED", "EXEMPTED_BUCKET_CHANGED", "FORCE_ALL_CHANGED", "IS_UID_ACTIVE_CACHED", "IS_UID_ACTIVE_RAW"});
        this.mAppBackgroundRestrictionListener = new AnonymousClass2(this);
        this.mReceiver = new AnonymousClass3(this);
        this.mContext = context;
        this.mHandler = new MyHandler(this, looper);
    }

    public void onSystemServicesReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mStarted = true;     // Catch: Throwable -> L8
        IActivityManager r1 = injectIActivityManager();     // Catch: Throwable -> L8
        r1.getClass();     // Catch: Throwable -> L8
        this.mIActivityManager = r1;     // Catch: Throwable -> L8
        ActivityManagerInternal r2 = injectActivityManagerInternal();     // Catch: Throwable -> L8
        r2.getClass();     // Catch: Throwable -> L8
        this.mActivityManagerInternal = r2;     // Catch: Throwable -> L8
        AppOpsManager r3 = injectAppOpsManager();     // Catch: Throwable -> L8
        r3.getClass();     // Catch: Throwable -> L8
        this.mAppOpsManager = r3;     // Catch: Throwable -> L8
        IAppOpsService r4 = injectIAppOpsService();     // Catch: Throwable -> L8
        r4.getClass();     // Catch: Throwable -> L8
        this.mAppOpsService = r4;     // Catch: Throwable -> L8
        PowerManagerInternal r5 = injectPowerManagerInternal();     // Catch: Throwable -> L8
        r5.getClass();     // Catch: Throwable -> L8
        this.mPowerManagerInternal = r5;     // Catch: Throwable -> L8
        AppStandbyInternal r6 = injectAppStandbyInternal();     // Catch: Throwable -> L8
        r6.getClass();     // Catch: Throwable -> L8
        this.mAppStandbyInternal = r6;     // Catch: Throwable -> L8
        this.mFlagsObserver = new FeatureFlagsObserver(this);     // Catch: Throwable -> L8
        this.mFlagsObserver.register();     // Catch: Throwable -> L8
        this.mForceAllAppStandbyForSmallBattery = this.mFlagsObserver.isForcedAppStandbyForSmallBatteryEnabled();     // Catch: Throwable -> L8
        this.mStandbyTracker = new StandbyTracker(this);     // Catch: Throwable -> L8
        this.mAppStandbyInternal.addListener(this.mStandbyTracker);     // Catch: Throwable -> L8
        this.mActivityManagerInternal.addAppBackgroundRestrictionListener(this.mAppBackgroundRestrictionListener);     // Catch: Throwable -> L8
        AppStateTrackerImplIA r7 = null;
        this.mIActivityManager.registerUidObserver(new UidObserver(this, r7), 30, -1, null);     // Catch: Throwable -> L8 RemoteException -> L13
        this.mAppOpsService.startWatchingMode(70, null, new AppOpsWatcher(this, r7));     // Catch: Throwable -> L8 RemoteException -> L13
    L14:
        IntentFilter filter = new IntentFilter();     // Catch: Throwable -> L8
        filter.addAction("android.intent.action.USER_REMOVED");     // Catch: Throwable -> L8
        filter.addAction("android.intent.action.BATTERY_CHANGED");     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mReceiver, filter);     // Catch: Throwable -> L8
        IntentFilter filter2 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");     // Catch: Throwable -> L8
        filter2.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mReceiver, filter2);     // Catch: Throwable -> L8
        refreshForcedAppStandbyUidPackagesLocked();     // Catch: Throwable -> L8
        this.mPowerManagerInternal.registerLowPowerModeObserver(11, new AppStateTrackerImpl$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L8
        this.mBatterySaverEnabled = this.mPowerManagerInternal.getLowPowerState(11).batterySaverEnabled;     // Catch: Throwable -> L8
        updateForceAllAppStandbyState();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private /* synthetic */ void lambda$onSystemServicesReady$0(PowerSaveState state) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBatterySaverEnabled = state.batterySaverEnabled;     // Catch: Throwable -> L7
        updateForceAllAppStandbyState();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    AppOpsManager injectAppOpsManager() {
        return (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
    }

    IAppOpsService injectIAppOpsService() {
        return IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));
    }

    IActivityManager injectIActivityManager() {
        return ActivityManager.getService();
    }

    ActivityManagerInternal injectActivityManagerInternal() {
        return (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
    }

    PowerManagerInternal injectPowerManagerInternal() {
        return (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
    }

    AppStandbyInternal injectAppStandbyInternal() {
        return (AppStandbyInternal) LocalServices.getService(AppStandbyInternal.class);
    }

    boolean isSmallBatteryDevice() {
        return ActivityManager.isSmallBatteryDevice();
    }

    int injectGetGlobalSettingInt(String key, int def) {
        return Settings.Global.getInt(this.mContext.getContentResolver(), key, def);
    }

    private void refreshForcedAppStandbyUidPackagesLocked() {
        this.mRunAnyRestrictedPackages.clear();
        List<AppOpsManager.PackageOps> ops = this.mAppOpsManager.getPackagesForOps(new int[]{70});
        if (ops != null) goto L5;
        return;
    L5:
        int size = ops.size();
        int i = 0;
    L6:
        if (i >= size) goto L18;
        AppOpsManager.PackageOps pkg = ops.get(i);
        List<AppOpsManager.OpEntry> entries = ops.get(i).getOps();
        int j = 0;
    L9:
        if (j >= entries.size()) goto L17;
        AppOpsManager.OpEntry ent = entries.get(j);
        if (ent.getOp() != 70) goto L16;
        if (ent.getMode() == 0) goto L16;
        this.mRunAnyRestrictedPackages.add(Pair.create(Integer.valueOf(pkg.getUid()), pkg.getPackageName()));
    L16:
        j = j + 1;
        goto L9
    L17:
        i = i + 1;
        goto L6
    L18:
        updateBackgroundRestrictedUidPackagesLocked();
    }

    private void updateBackgroundRestrictedUidPackagesLocked() {
        Set<Pair<Integer, String>> fasUidPkgs = new ArraySet();
        int i = 0;
        int size = this.mRunAnyRestrictedPackages.size();
    L3:
        if (i >= size) goto L5;
        fasUidPkgs.add(this.mRunAnyRestrictedPackages.valueAt(i));
        i = i + 1;
        goto L3
    L5:
        this.mBackgroundRestrictedUidPackages = Collections.unmodifiableSet(fasUidPkgs);
    }

    private void updateForceAllAppStandbyState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mForceAllAppStandbyForSmallBattery == true) goto L7;
    L15:
        toggleForceAllAppsStandbyLocked(this.mBatterySaverEnabled);     // Catch: Throwable -> L13
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (isSmallBatteryDevice() == false) goto L15;
        if (this.mIsPluggedIn == true) goto L11;
        boolean r1 = true;
    L12:
        toggleForceAllAppsStandbyLocked(r1);     // Catch: Throwable -> L13
        goto L16
    L11:
        r1 = false;
        goto L12
    }

    private void toggleForceAllAppsStandbyLocked(boolean enable) {
        if (enable != this.mForceAllAppsStandby) goto L5;
        return;
    L5:
        this.mForceAllAppsStandby = enable;
        this.mHandler.notifyForceAllAppsStandbyChanged();
    }

    private int findForcedAppStandbyUidPackageIndexLocked(int uid, String packageName) {
        int size = this.mRunAnyRestrictedPackages.size();
        if (size > 8) goto L5;
        int i = 0;
    L7:
        if (i >= size) goto L14;
        Pair<Integer, String> pair = this.mRunAnyRestrictedPackages.valueAt(i);
        if (((Integer) pair.first).intValue() != uid) goto L13;
        if (packageName.equals(pair.second) == false) goto L13;
        return i;
    L13:
        i = i + 1;
        goto L7
    L14:
        return -1;
    L5:
        return this.mRunAnyRestrictedPackages.indexOf(Pair.create(Integer.valueOf(uid), packageName));
    }

    boolean isRunAnyRestrictedLocked(int uid, String packageName) {
        if (findForcedAppStandbyUidPackageIndexLocked(uid, packageName) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean updateForcedAppStandbyUidPackageLocked(int uid, String packageName, boolean restricted) {
        int index = findForcedAppStandbyUidPackageIndexLocked(uid, packageName);
        if (index < 0) goto L5;
        boolean wasRestricted = true;
    L6:
        if (wasRestricted != restricted) goto L8;
        return false;
    L8:
        if (restricted == false) goto L10;
        this.mRunAnyRestrictedPackages.add(Pair.create(Integer.valueOf(uid), packageName));
    L11:
        updateBackgroundRestrictedUidPackagesLocked();
        return true;
    L10:
        this.mRunAnyRestrictedPackages.removeAt(index);
        goto L11
    L5:
        wasRestricted = false;
        goto L6
    }

    private static boolean addUidToArray(SparseBooleanArray array, int uid) {
        if (UserHandle.isCore(uid) == false) goto L6;
        return false;
    L6:
        if (array.get(uid) == false) goto L8;
        return false;
    L8:
        array.put(uid, true);
        return true;
    }

    private static boolean removeUidFromArray(SparseBooleanArray array, int uid, boolean remove) {
        if (UserHandle.isCore(uid) == false) goto L6;
        return false;
    L6:
        if (array.get(uid) == true) goto L8;
        return false;
    L8:
        if (remove == false) goto L10;
        array.delete(uid);
        return true;
    L10:
        array.put(uid, false);
        return true;
    }

    private Listener[] cloneListeners() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Listener[] r1 = (Listener[]) this.mListeners.toArray(new Listener[this.mListeners.size()]);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void handleUserRemoved(int removedUserId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mRunAnyRestrictedPackages.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L12;
        Pair<Integer, String> pair = this.mRunAnyRestrictedPackages.valueAt(i);     // Catch: Throwable -> L9
        int uid = ((Integer) pair.first).intValue();     // Catch: Throwable -> L9
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L9
        if (userId != removedUserId) goto L11;
        this.mRunAnyRestrictedPackages.removeAt(i);     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        updateBackgroundRestrictedUidPackagesLocked();     // Catch: Throwable -> L9
        cleanUpArrayForUser(this.mActiveUids, removedUserId);     // Catch: Throwable -> L9
        this.mExemptedBucketPackages.remove(removedUserId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void cleanUpArrayForUser(SparseBooleanArray array, int removedUserId) {
        int i = array.size() - 1;
    L3:
        if (i < 0) goto L9;
        int uid = array.keyAt(i);
        int userId = UserHandle.getUserId(uid);
        if (userId != removedUserId) goto L7;
        array.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    public void setPowerSaveExemptionListAppIds(int[] powerSaveExemptionListExceptIdleAppIdArray, int[] powerSaveExemptionListUserAppIdArray, int[] tempExemptionListAppIdArray) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int[] previousExemptionList = this.mPowerExemptAllAppIds;     // Catch: Throwable -> L7
        int[] previousTempExemptionList = this.mTempExemptAppIds;     // Catch: Throwable -> L7
        this.mPowerExemptAllAppIds = powerSaveExemptionListExceptIdleAppIdArray;     // Catch: Throwable -> L7
        this.mTempExemptAppIds = tempExemptionListAppIdArray;     // Catch: Throwable -> L7
        this.mPowerExemptUserAppIds = powerSaveExemptionListUserAppIdArray;     // Catch: Throwable -> L7
        if (isAnyAppIdUnexempt(previousExemptionList, this.mPowerExemptAllAppIds) == false) goto L10;
        this.mHandler.notifyAllUnexempted();     // Catch: Throwable -> L7
    L13:
        if (Arrays.equals(previousTempExemptionList, this.mTempExemptAppIds) == true) goto L15;
        this.mHandler.notifyTempExemptionListChanged();     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (Arrays.equals(previousExemptionList, this.mPowerExemptAllAppIds) == true) goto L13;
        this.mHandler.notifyAllExemptionListChanged();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    static boolean isAnyAppIdUnexempt(int[] prevArray, int[] newArray) {
        int i1 = 0;
        int i2 = 0;
    L4:
        if (i1 < prevArray.length) goto L6;
        boolean prevFinished = true;
    L8:
        if (i2 < newArray.length) goto L10;
        boolean newFinished = true;
    L12:
        if (prevFinished == true) goto L21;
        if (newFinished == true) goto L21;
        int a1 = prevArray[i1];
        int a2 = newArray[i2];
        if (a1 == a2) goto L17;
        if (a1 < a2) goto L19;
        i2 = i2 + 1;
        goto L4
    L19:
        return true;
    L17:
        i1 = i1 + 1;
        i2 = i2 + 1;
    L21:
        if (prevFinished == false) goto L23;
        return false;
    L23:
        return newFinished;
    L10:
        newFinished = false;
        goto L12
    L6:
        prevFinished = false;
        goto L8
    }

    public void addListener(Listener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean areAlarmsRestricted(int uid, String packageName) {
        boolean r1 = false;
        if (isUidActive(uid) == false) goto L5;
        return false;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int appId = UserHandle.getAppId(uid);     // Catch: Throwable -> L11
        if (ArrayUtils.contains(this.mPowerExemptAllAppIds, appId) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L14:
        if (this.mActivityManagerInternal.isBgAutoRestrictedBucketFeatureFlagEnabled() == false) goto L16;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L16:
        if (isRunAnyRestrictedLocked(uid, packageName) == false) goto L19;
        r1 = true;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean areAlarmsRestrictedByBatterySaver(int uid, String packageName) {
        if (isUidActive(uid) == false) goto L5;
        return false;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int appId = UserHandle.getAppId(uid);     // Catch: Throwable -> L11
        if (ArrayUtils.contains(this.mPowerExemptAllAppIds, appId) == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L13:
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L11
        if (this.mAppStandbyInternal.isAppIdleEnabled() == true) goto L16;
    L21:
        boolean r1 = this.mForceAllAppsStandby;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L16:
        if (this.mAppStandbyInternal.isInParole() == true) goto L21;
        if (this.mExemptedBucketPackages.contains(userId, packageName) == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean areJobsRestricted(int uid, String packageName, boolean hasForegroundExemption) {
        if (isUidActive(uid) == false) goto L5;
        return false;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int appId = UserHandle.getAppId(uid);     // Catch: Throwable -> L19
        if (ArrayUtils.contains(this.mPowerExemptAllAppIds, appId) == false) goto L10;
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return false;
    L10:
        if (ArrayUtils.contains(this.mTempExemptAppIds, appId) == true) goto L35;
        if (this.mActivityManagerInternal.isBgAutoRestrictedBucketFeatureFlagEnabled() == false) goto L15;
    L21:
        if (hasForegroundExemption == false) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return false;
    L24:
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L19
        if (this.mAppStandbyInternal.isAppIdleEnabled() == true) goto L27;
    L32:
        boolean r1 = this.mForceAllAppsStandby;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r1;
    L27:
        if (this.mAppStandbyInternal.isInParole() == true) goto L32;
        if (this.mExemptedBucketPackages.contains(userId, packageName) == false) goto L32;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return false;
    L15:
        if (isRunAnyRestrictedLocked(uid, packageName) == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return true;
    L19:
        th = move-exception;
        throw th;
    }

    public boolean isUidActive(int uid) {
        if (UserHandle.isCore(uid) == false) goto L6;
        return true;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mActiveUids.get(uid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean isUidActiveSynced(int uid) {
        if (isUidActive(uid) == false) goto L6;
        return true;
    L6:
        long start = this.mStatLogger.getTime();
        boolean ret = this.mActivityManagerInternal.isUidActive(uid);
        this.mStatLogger.logDurationStat(9, start);
        return ret;
    }

    public boolean isForceAllAppsStandbyEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mForceAllAppsStandby;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isRunAnyInBackgroundAppOpsAllowed(int uid, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isRunAnyRestrictedLocked(uid, packageName) == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean isUidPowerSaveExempt(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = ArrayUtils.contains(this.mPowerExemptAllAppIds, UserHandle.getAppId(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isUidPowerSaveUserExempt(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = ArrayUtils.contains(this.mPowerExemptUserAppIds, UserHandle.getAppId(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isUidTempPowerSaveExempt(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = ArrayUtils.contains(this.mTempExemptAppIds, UserHandle.getAppId(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Current AppStateTracker State:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        pw.print("Force all apps standby: ");     // Catch: Throwable -> L11
        pw.println(isForceAllAppsStandbyEnabled());     // Catch: Throwable -> L11
        pw.print("Small Battery Device: ");     // Catch: Throwable -> L11
        pw.println(isSmallBatteryDevice());     // Catch: Throwable -> L11
        pw.print("Force all apps standby for small battery device: ");     // Catch: Throwable -> L11
        pw.println(this.mForceAllAppStandbyForSmallBattery);     // Catch: Throwable -> L11
        pw.print("Plugged In: ");     // Catch: Throwable -> L11
        pw.println(this.mIsPluggedIn);     // Catch: Throwable -> L11
        pw.print("Active uids: ");     // Catch: Throwable -> L11
        dumpUids(pw, this.mActiveUids);     // Catch: Throwable -> L11
        pw.print("Except-idle + user exemption list appids: ");     // Catch: Throwable -> L11
        pw.println(Arrays.toString(this.mPowerExemptAllAppIds));     // Catch: Throwable -> L11
        pw.print("User exemption list appids: ");     // Catch: Throwable -> L11
        pw.println(Arrays.toString(this.mPowerExemptUserAppIds));     // Catch: Throwable -> L11
        pw.print("Temp exemption list appids: ");     // Catch: Throwable -> L11
        pw.println(Arrays.toString(this.mTempExemptAppIds));     // Catch: Throwable -> L11
        pw.println("Exempted bucket packages:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i = 0;
    L6:
        if (i >= this.mExemptedBucketPackages.size()) goto L14;
        pw.print("User ");     // Catch: Throwable -> L11
        pw.print(this.mExemptedBucketPackages.keyAt(i));     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int j = 0;
    L9:
        if (j >= this.mExemptedBucketPackages.sizeAt(i)) goto L13;
        pw.print((String) this.mExemptedBucketPackages.valueAt(i, j));     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        j = j + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L14:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Restricted packages:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<Pair<Integer, String>> r1 = this.mRunAnyRestrictedPackages.iterator();     // Catch: Throwable -> L11
    L16:
        if (r1.hasNext() == false) goto L18;
        Pair<Integer, String> uidAndPackage = r1.next();     // Catch: Throwable -> L11
        pw.print(UserHandle.formatUid(((Integer) uidAndPackage.first).intValue()));     // Catch: Throwable -> L11
        pw.print(" ");     // Catch: Throwable -> L11
        pw.print((String) uidAndPackage.second);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        goto L16
    L18:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        this.mStatLogger.dump(pw);     // Catch: Throwable -> L11
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void dumpUids(PrintWriter pw, SparseBooleanArray array) {
        pw.print("[");
        String sep = "";
        int i = 0;
    L4:
        if (i >= array.size()) goto L9;
        if (array.valueAt(i) == false) goto L8;
        pw.print(sep);
        pw.print(UserHandle.formatUid(array.keyAt(i)));
        sep = " ";
    L8:
        i = i + 1;
        goto L4
    L9:
        pw.println("]");
    }

    public void dumpProto(ProtoOutputStream proto, long fieldId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long token = proto.start(fieldId);     // Catch: Throwable -> L10
        proto.write(1133871366145L, isForceAllAppsStandbyEnabled());     // Catch: Throwable -> L10
        proto.write(1133871366150L, isSmallBatteryDevice());     // Catch: Throwable -> L10
        proto.write(1133871366151L, this.mForceAllAppStandbyForSmallBattery);     // Catch: Throwable -> L10
        proto.write(1133871366152L, this.mIsPluggedIn);     // Catch: Throwable -> L10
        int i = 0;
    L6:
        if (i >= this.mActiveUids.size()) goto L13;
        if (this.mActiveUids.valueAt(i) == false) goto L12;
        proto.write(2220498092034L, this.mActiveUids.keyAt(i));     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        int[] r3 = this.mPowerExemptAllAppIds;     // Catch: Throwable -> L10
        int r4 = r3.length;     // Catch: Throwable -> L10
        int r5 = 0;
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L16;
        int appId = r3[r6];     // Catch: Throwable -> L10
        proto.write(2220498092035L, appId);     // Catch: Throwable -> L10
        r6 = r6 + 1;     // Catch: Throwable -> L10
        goto L14
    L16:
        int[] r7 = this.mPowerExemptUserAppIds;     // Catch: Throwable -> L10
        int r8 = r7.length;     // Catch: Throwable -> L10
        int r9 = 0;
    L17:
        if (r9 >= r8) goto L19;
        int appId2 = r7[r9];     // Catch: Throwable -> L10
        proto.write(2220498092044L, appId2);     // Catch: Throwable -> L10
        r9 = r9 + 1;     // Catch: Throwable -> L10
        goto L17
    L19:
        int[] r10 = this.mTempExemptAppIds;     // Catch: Throwable -> L10
        int r11 = r10.length;     // Catch: Throwable -> L10
    L20:
        if (r5 >= r11) goto L22;
        int appId3 = r10[r5];     // Catch: Throwable -> L10
        proto.write(2220498092036L, appId3);     // Catch: Throwable -> L10
        r5 = r5 + 1;     // Catch: Throwable -> L10
        goto L20
    L22:
        int i2 = 0;
    L24:
        if (i2 >= this.mExemptedBucketPackages.size()) goto L30;
        int j = 0;
    L27:
        if (j >= this.mExemptedBucketPackages.sizeAt(i2)) goto L29;
        long token2 = proto.start(2246267895818L);     // Catch: Throwable -> L10
        proto.write(1120986464257L, this.mExemptedBucketPackages.keyAt(i2));     // Catch: Throwable -> L10
        proto.write(1138166333442L, (String) this.mExemptedBucketPackages.valueAt(i2, j));     // Catch: Throwable -> L10
        proto.end(token2);     // Catch: Throwable -> L10
        j = j + 1;     // Catch: Throwable -> L10
        goto L27
    L29:
        i2 = i2 + 1;     // Catch: Throwable -> L10
        goto L24
    L30:
        Iterator<Pair<Integer, String>> r12 = this.mRunAnyRestrictedPackages.iterator();     // Catch: Throwable -> L10
    L32:
        if (r12.hasNext() == false) goto L34;
        Pair<Integer, String> uidAndPackage = r12.next();     // Catch: Throwable -> L10
        long token3 = proto.start(2246267895813L);     // Catch: Throwable -> L10
        proto.write(1120986464257L, ((Integer) uidAndPackage.first).intValue());     // Catch: Throwable -> L10
        proto.write(1138166333442L, (String) uidAndPackage.second);     // Catch: Throwable -> L10
        proto.end(token3);     // Catch: Throwable -> L10
        goto L32
    L34:
        this.mStatLogger.dumpProto(proto, 1146756268041L);     // Catch: Throwable -> L10
        proto.end(token);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}

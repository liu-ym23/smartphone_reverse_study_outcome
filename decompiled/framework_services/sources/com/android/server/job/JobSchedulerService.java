package com.android.server.job;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.IUidObserver;
import android.app.compat.CompatChanges;
import android.app.job.IJobScheduler;
import android.app.job.IUserVisibleJobObserver;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobSnapshot;
import android.app.job.JobWorkItem;
import android.app.job.PendingJobReasonsInfo;
import android.app.job.UserVisibleJobSummary;
import android.app.usage.UsageStatsManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.hardware.tv.mediaquality.ParameterName;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.BatteryManagerInternal;
import android.os.BatteryStatsInternal;
import android.os.Binder;
import android.os.Handler;
import android.os.LimitExceededException;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.os.WorkSource;
import android.os.storage.StorageManagerInternal;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.KeyValueListParser;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseArrayMap;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseSetArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.internal.util.jobs.DumpUtils;
import com.android.modules.expresslog.Counter;
import com.android.modules.expresslog.Histogram;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.AppStateTracker;
import com.android.server.AppStateTrackerImpl;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;
import com.android.server.SysOptApexBridge;
import com.android.server.SystemService;
import com.android.server.input.KeyboardMetricsCollector;
import com.android.server.job.controllers.BackgroundJobsController;
import com.android.server.job.controllers.BatteryController;
import com.android.server.job.controllers.ComponentController;
import com.android.server.job.controllers.ConnectivityController;
import com.android.server.job.controllers.ContentObserverController;
import com.android.server.job.controllers.DeviceIdleJobsController;
import com.android.server.job.controllers.FlexibilityController;
import com.android.server.job.controllers.IdleController;
import com.android.server.job.controllers.JobStatus;
import com.android.server.job.controllers.ObricJobResourceController;
import com.android.server.job.controllers.PrefetchController;
import com.android.server.job.controllers.QuotaController;
import com.android.server.job.controllers.RestrictingController;
import com.android.server.job.controllers.StateController;
import com.android.server.job.controllers.StorageController;
import com.android.server.job.controllers.TimeController;
import com.android.server.job.restrictions.JobRestriction;
import com.android.server.job.restrictions.ThermalStatusRestriction;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorService;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.usage.AppStandbyInternal;
import com.android.server.utils.quota.Categorizer;
import com.android.server.utils.quota.Category;
import com.android.server.utils.quota.CountQuotaTracker;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public class JobSchedulerService extends SystemService implements StateChangedListener, JobCompletedListener {
    public static final int ACTIVE_INDEX = 0;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_STANDBY = false;
    public static final int EXEMPTED_INDEX = 6;
    public static final int FREQUENT_INDEX = 2;
    public static final long MAX_ALLOWED_PERIOD_MS = 31536000000L;
    private static final int MAX_JOBS_PER_APP = 150;
    static final int MSG_CHECK_CHANGED_JOB_LIST = 8;
    static final int MSG_CHECK_INDIVIDUAL_JOB = 0;
    static final int MSG_CHECK_JOB = 1;
    static final int MSG_CHECK_JOB_GREEDY = 3;
    static final int MSG_CHECK_MEDIA_EXEMPTION = 9;
    static final int MSG_INFORM_OBSERVERS_OF_USER_VISIBLE_JOB_CHANGE = 11;
    static final int MSG_INFORM_OBSERVER_OF_ALL_USER_VISIBLE_JOBS = 10;
    static final int MSG_STOP_JOB = 2;
    static final int MSG_UID_ACTIVE = 6;
    static final int MSG_UID_GONE = 5;
    static final int MSG_UID_IDLE = 7;
    static final int MSG_UID_STATE_CHANGED = 4;
    public static final int NEVER_INDEX = 4;
    private static final int NUM_COMPLETED_JOB_HISTORY = 20;
    private static final long PERIODIC_JOB_WINDOW_BUFFER = 1800000;
    private static final String QUOTA_TRACKER_ANR_TAG = "anr";
    private static final Category QUOTA_TRACKER_CATEGORY_ANR = null;
    private static final Category QUOTA_TRACKER_CATEGORY_DISABLED = null;
    private static final Category QUOTA_TRACKER_CATEGORY_SCHEDULE_LOGGED = null;
    private static final Category QUOTA_TRACKER_CATEGORY_SCHEDULE_PERSISTED = null;
    private static final Category QUOTA_TRACKER_CATEGORY_TIMEOUT_EJ = null;
    private static final Category QUOTA_TRACKER_CATEGORY_TIMEOUT_REG = null;
    private static final Category QUOTA_TRACKER_CATEGORY_TIMEOUT_TOTAL = null;
    private static final Category QUOTA_TRACKER_CATEGORY_TIMEOUT_UIJ = null;
    private static final String QUOTA_TRACKER_SCHEDULE_LOGGED = ".schedulePersisted out-of-quota logged";
    private static final String QUOTA_TRACKER_SCHEDULE_PERSISTED_TAG = ".schedulePersisted()";
    private static final String QUOTA_TRACKER_TIMEOUT_EJ_TAG = "timeout-ej";
    private static final String QUOTA_TRACKER_TIMEOUT_REG_TAG = "timeout-reg";
    private static final String QUOTA_TRACKER_TIMEOUT_TOTAL_TAG = "timeout-total";
    private static final String QUOTA_TRACKER_TIMEOUT_UIJ_TAG = "timeout-uij";
    public static final int RARE_INDEX = 3;
    private static final long REQUIRE_NETWORK_CONSTRAINT_FOR_NETWORK_JOB_WORK_ITEMS = 241104082;
    static final long REQUIRE_NETWORK_PERMISSIONS_FOR_CONNECTIVITY_JOBS = 271850009;
    public static final int RESTRICTED_INDEX = 5;
    public static final String TAG = "JobScheduler";
    public static final long THROW_ON_UNSUPPORTED_BIAS_USAGE = 300477393;
    public static final String TRACE_TRACK_NAME = "JobScheduler";
    public static final int WORKING_INDEX = 1;
    public static Clock sElapsedRealtimeClock;
    private static final Histogram sEnqueuedJwiHighWaterMarkLogger = null;
    private static final Histogram sInitialJobEstimatedNetworkDownloadKBLogger = null;
    private static final Histogram sInitialJobEstimatedNetworkUploadKBLogger = null;
    private static final Histogram sInitialJwiEstimatedNetworkDownloadKBLogger = null;
    private static final Histogram sInitialJwiEstimatedNetworkUploadKBLogger = null;
    private static final Histogram sJobMinimumChunkKBLogger = null;
    private static final Histogram sJwiMinimumChunkKBLogger = null;
    public static Clock sSystemClock;
    public static Clock sUptimeMillisClock;
    public static UsageStatsManagerInternal sUsageStatsManagerInternal;
    ActivityManagerInternal mActivityManagerInternal;
    private final AppStandbyInternal mAppStandbyInternal;
    AppStateTrackerImpl mAppStateTracker;
    private final SparseBooleanArray mBackingUpUids;
    final BatteryStateTracker mBatteryStateTracker;
    private final BatteryStatsInternal mBatteryStatsInternal;
    private final BroadcastReceiver mBroadcastReceiver;
    private final Consumer<JobStatus> mCancelJobDueToUserRemovalConsumer;
    private final ArraySet<JobStatus> mChangedJobList;
    private final SparseArray<String> mCloudMediaProviderPackages;
    final JobConcurrencyManager mConcurrencyManager;
    private final ConnectivityController mConnectivityController;
    final Constants mConstants;
    final ConstantsObserver mConstantsObserver;
    final List<StateController> mControllers;
    final ArrayMap<String, Boolean> mDebuggableApps;
    private final DeviceIdleJobsController mDeviceIdleJobsController;
    private final FlexibilityController mFlexibilityController;
    final JobHandler mHandler;
    private final Predicate<Integer> mIsUidActivePredicate;
    final JobPackageTracker mJobPackageTracker;
    final List<JobRestriction> mJobRestrictions;
    final JobSchedulerStub mJobSchedulerStub;
    private final CountDownLatch mJobStoreLoadedLatch;
    private final Runnable mJobTimeUpdater;
    final JobStore mJobs;
    private int mLastCancelledJobIndex;
    private final long[] mLastCancelledJobTimeElapsed;
    private final JobStatus[] mLastCancelledJobs;
    private int mLastCompletedJobIndex;
    private final long[] mLastCompletedJobTimeElapsed;
    private final JobStatus[] mLastCompletedJobs;
    DeviceIdleInternal mLocalDeviceIdleController;
    PackageManagerInternal mLocalPM;
    final Object mLock;
    private final MaybeReadyJobQueueFunctor mMaybeQueueFunctor;
    public final ObricJobResourceController mObricJobResourceController;
    private final PendingJobQueue mPendingJobQueue;
    private final SparseArrayMap<String, SparseArray<int[]>> mPendingJobReasonsCache;
    private final SparseArray<SparseArrayMap<String, Boolean>> mPermissionCache;
    private final PrefetchController mPrefetchController;
    private final QuotaController mQuotaController;
    private final CountQuotaTracker mQuotaTracker;
    private final ReadyJobQueueFunctor mReadyQueueFunctor;
    boolean mReadyToRock;
    boolean mReportedActive;
    private final List<RestrictingController> mRestrictiveControllers;
    final StandbyTracker mStandbyTracker;
    private final CountDownLatch mStartControllerTrackingLatch;
    int[] mStartedUsers;
    private final StorageController mStorageController;
    private final BroadcastReceiver mTimeSetReceiver;
    final SparseIntArray mUidBiasOverride;
    private final SparseIntArray mUidCapabilities;
    private final IUidObserver mUidObserver;
    private final SparseIntArray mUidProcStates;
    private final SparseSetArray<String> mUidToPackageCache;
    private final RemoteCallbackList<IUserVisibleJobObserver> mUserVisibleJobObservers;

    final class BatteryStateTracker extends BroadcastReceiver implements BatteryManagerInternal.ChargingPolicyChangeListener {
        private int mBatteryLevel;
        private final BatteryManagerInternal mBatteryManagerInternal;
        private boolean mBatteryNotLow;
        private boolean mCharging;
        private int mChargingPolicy;
        private int mLastBatterySeq;
        private BroadcastReceiver mMonitor;
        private boolean mPowerConnected;
        final /* synthetic */ JobSchedulerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmBatteryLevel, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4850$$Nest$fgetmBatteryLevel(BatteryStateTracker r0) {
            return r0.mBatteryLevel;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCharging, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4851$$Nest$fgetmCharging(BatteryStateTracker r0) {
            return r0.mCharging;
        }

        /* JADX INFO: renamed from: -$$Nest$misConsideredCharging, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4852$$Nest$misConsideredCharging(BatteryStateTracker r0) {
            return r0.isConsideredCharging();
        }

        /* JADX INFO: renamed from: -$$Nest$monReceiveInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4853$$Nest$monReceiveInternal(BatteryStateTracker r0, Intent r1) {
            r0.onReceiveInternal(r1);
        }

        BatteryStateTracker(JobSchedulerService this$0) {
            this.this$0 = this$0;
            this.mLastBatterySeq = -1;
            this.mBatteryManagerInternal = (BatteryManagerInternal) LocalServices.getService(BatteryManagerInternal.class);
        }

        public void startTracking() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.BATTERY_LOW");
            filter.addAction("android.intent.action.BATTERY_OKAY");
            filter.addAction("android.os.action.CHARGING");
            filter.addAction("android.os.action.DISCHARGING");
            filter.addAction("android.intent.action.BATTERY_LEVEL_CHANGED");
            filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            this.this$0.getTestableContext().registerReceiver(this, filter);
            this.mBatteryManagerInternal.registerChargingPolicyChangeListener(this);
            this.mBatteryLevel = this.mBatteryManagerInternal.getBatteryLevel();
            this.mBatteryNotLow = !this.mBatteryManagerInternal.getBatteryLevelLow();
            this.mCharging = this.mBatteryManagerInternal.isPowered(15);
            this.mChargingPolicy = this.mBatteryManagerInternal.getChargingPolicy();
        }

        public void setMonitorBatteryLocked(boolean enabled) {
            if (enabled == false) goto L7;
            if (this.mMonitor != null) goto L10;
            this.mMonitor = new AnonymousClass1(this);
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.BATTERY_CHANGED");
            this.this$0.getTestableContext().registerReceiver(this.mMonitor, filter);
            return;
        L10:
            return;
        L7:
            if (this.mMonitor == null) goto L12;
            this.this$0.getTestableContext().unregisterReceiver(this.mMonitor);
            this.mMonitor = null;
            return;
        }

        public boolean isCharging() {
            return isConsideredCharging();
        }

        public boolean isBatteryNotLow() {
            return this.mBatteryNotLow;
        }

        public boolean isMonitoring() {
            if (this.mMonitor == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isPowerConnected() {
            return this.mPowerConnected;
        }

        public int getSeq() {
            return this.mLastBatterySeq;
        }

        public void onChargingPolicyChanged(int newPolicy) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mChargingPolicy != newPolicy) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (JobSchedulerService.DEBUG == false) goto L13;
            Slog.i("JobScheduler", "Charging policy changed from " + this.mChargingPolicy + " to " + newPolicy);     // Catch: Throwable -> L8
        L13:
            boolean wasConsideredCharging = isConsideredCharging();     // Catch: Throwable -> L8
            this.mChargingPolicy = newPolicy;     // Catch: Throwable -> L8
            if (Trace.isTagEnabled(524288) == false) goto L17;
            Trace.instantForTrack(524288, "JobScheduler", "CHARGING POLICY CHANGED#" + this.mChargingPolicy);     // Catch: Throwable -> L8
        L17:
            if (isConsideredCharging() == wasConsideredCharging) goto L21;
            int c = this.this$0.mControllers.size() - 1;     // Catch: Throwable -> L8
        L19:
            if (c < 0) goto L21;
            this.this$0.mControllers.get(c).onBatteryStateChangedLocked();     // Catch: Throwable -> L8
            c = c - 1;     // Catch: Throwable -> L8
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            onReceiveInternal(intent);
        }

        private void onReceiveInternal(Intent intent) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            String action = intent.getAction();     // Catch: Throwable -> L9
            boolean changed = false;
            boolean r4 = false;
            if ("android.intent.action.BATTERY_LOW".equals(action) == false) goto L15;
            if (JobSchedulerService.DEBUG == false) goto L12;
            Slog.d("JobScheduler", "Battery life too low @ " + JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L9
        L12:
            if (this.mBatteryNotLow == false) goto L73;
            this.mBatteryNotLow = false;     // Catch: Throwable -> L9
            changed = true;
        L73:
            this.mLastBatterySeq = intent.getIntExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mLastBatterySeq);     // Catch: Throwable -> L9
            if (changed == false) goto L78;
            int c = this.this$0.mControllers.size() - 1;     // Catch: Throwable -> L9
        L76:
            if (c < 0) goto L78;
            this.this$0.mControllers.get(c).onBatteryStateChangedLocked();     // Catch: Throwable -> L9
            c = c - 1;     // Catch: Throwable -> L9
        L78:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L15:
            if ("android.intent.action.BATTERY_OKAY".equals(action) == false) goto L23;
            if (JobSchedulerService.DEBUG == false) goto L20;
            Slog.d("JobScheduler", "Battery high enough @ " + JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L9
        L20:
            if (this.mBatteryNotLow == true) goto L73;
            this.mBatteryNotLow = true;     // Catch: Throwable -> L9
            changed = true;
            goto L73
        L23:
            if ("android.intent.action.BATTERY_LEVEL_CHANGED".equals(action) == false) goto L32;
            if (JobSchedulerService.DEBUG == false) goto L27;
            Slog.d("JobScheduler", "Battery level changed @ " + JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L9
        L27:
            boolean wasConsideredCharging = isConsideredCharging();     // Catch: Throwable -> L9
            this.mBatteryLevel = this.mBatteryManagerInternal.getBatteryLevel();     // Catch: Throwable -> L9
            if (isConsideredCharging() == wasConsideredCharging) goto L30;
            r4 = true;
        L30:
            changed = r4;
            goto L73
        L32:
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(action) == false) goto L42;
            if (JobSchedulerService.DEBUG == false) goto L37;
            Slog.d("JobScheduler", "Power connected @ " + JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L9
        L37:
            if (this.mPowerConnected == false) goto L40;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L40:
            this.mPowerConnected = true;     // Catch: Throwable -> L9
            changed = true;
            goto L73
        L42:
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action) == false) goto L52;
            if (JobSchedulerService.DEBUG == false) goto L47;
            Slog.d("JobScheduler", "Power disconnected @ " + JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L9
        L47:
            if (this.mPowerConnected == true) goto L50;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L50:
            this.mPowerConnected = false;     // Catch: Throwable -> L9
            changed = true;
            goto L73
        L52:
            if ("android.os.action.CHARGING".equals(action) == false) goto L63;
            if (JobSchedulerService.DEBUG == false) goto L57;
            Slog.d("JobScheduler", "Battery charging @ " + JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L9
        L57:
            if (this.mCharging == true) goto L73;
            boolean wasConsideredCharging2 = isConsideredCharging();     // Catch: Throwable -> L9
            this.mCharging = true;     // Catch: Throwable -> L9
            if (isConsideredCharging() == wasConsideredCharging2) goto L61;
            r4 = true;
        L61:
            changed = r4;
            goto L73
        L63:
            if ("android.os.action.DISCHARGING".equals(action) == false) goto L73;
            if (JobSchedulerService.DEBUG == false) goto L68;
            Slog.d("JobScheduler", "Battery discharging @ " + JobSchedulerService.sElapsedRealtimeClock.millis());     // Catch: Throwable -> L9
        L68:
            if (this.mCharging == false) goto L73;
            boolean wasConsideredCharging3 = isConsideredCharging();     // Catch: Throwable -> L9
            this.mCharging = false;     // Catch: Throwable -> L9
            if (isConsideredCharging() == wasConsideredCharging3) goto L72;
            r4 = true;
        L72:
            changed = r4;
        L9:
            th = move-exception;
            throw th;
        }

        private boolean isConsideredCharging() {
            if (this.mCharging == false) goto L6;
            return true;
        L6:
            if (this.mPowerConnected == true) goto L9;
            return false;
        L9:
            if (this.mChargingPolicy != Integer.MIN_VALUE) goto L12;
            return false;
        L12:
            if (this.mBatteryLevel < 70) goto L17;
            if (BatteryManager.isAdaptiveChargingPolicy(this.mChargingPolicy) == false) goto L17;
            return true;
        L17:
            return false;
        }
    }

    private class CloudProviderChangeListener implements StorageManagerInternal.CloudProviderChangeListener {
        final /* synthetic */ JobSchedulerService this$0;

        /* synthetic */ CloudProviderChangeListener(JobSchedulerService r1, JobSchedulerServiceIA r2) {
            this(r1);
        }

        private CloudProviderChangeListener(JobSchedulerService r1) {
            this.this$0 = r1;
        }

        public void onCloudProviderChanged(int userId, String authority) {
            PackageManager pm = this.this$0.getContext().createContextAsUser(UserHandle.of(userId), 0).getPackageManager();
            ProviderInfo pi = pm.resolveContentProvider(authority, PackageManager.ComponentInfoFlags.of(0));
            if (pi != null) goto L5;
            String newPkg = null;
        L6:
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            String oldPkg = (String) JobSchedulerService.m4819$$Nest$fgetmCloudMediaProviderPackages(this.this$0).get(userId);     // Catch: Throwable -> L13
            if (Objects.equals(oldPkg, newPkg) == false) goto L11;
        L16:
            monitor-exit(r3);     // Catch: Throwable -> L13
            return;
        L11:
            if (JobSchedulerService.DEBUG == false) goto L15;
            Slog.d("JobScheduler", "Cloud provider of user " + userId + " changed from " + oldPkg + " to " + newPkg);     // Catch: Throwable -> L13
        L15:
            JobSchedulerService.m4819$$Nest$fgetmCloudMediaProviderPackages(this.this$0).put(userId, newPkg);     // Catch: Throwable -> L13
            SomeArgs args = SomeArgs.obtain();     // Catch: Throwable -> L13
            args.argi1 = userId;     // Catch: Throwable -> L13
            args.arg1 = oldPkg;     // Catch: Throwable -> L13
            args.arg2 = newPkg;     // Catch: Throwable -> L13
            this.this$0.mHandler.obtainMessage(9, args).sendToTarget();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        L5:
            newPkg = pi.packageName;
            goto L6
        }
    }

    public static class Constants {
        private static final int DEFAULT_ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF = 3;
        private static final int DEFAULT_API_QUOTA_SCHEDULE_COUNT = 250;
        private static final boolean DEFAULT_API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT = false;
        private static final boolean DEFAULT_API_QUOTA_SCHEDULE_THROW_EXCEPTION = true;
        private static final long DEFAULT_API_QUOTA_SCHEDULE_WINDOW_MS = 60000;
        private static final float DEFAULT_CONN_CONGESTION_DELAY_FRAC = 0.5f;
        private static final float DEFAULT_CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC = 0.5f;
        private static final long DEFAULT_CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS = 1860000;
        private static final float DEFAULT_CONN_PREFETCH_RELAX_FRAC = 0.5f;
        private static final SparseIntArray DEFAULT_CONN_TRANSPORT_BATCH_THRESHOLD = null;
        private static final long DEFAULT_CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS = 60000;
        private static final boolean DEFAULT_CONN_USE_CELL_SIGNAL_STRENGTH = true;
        private static final boolean DEFAULT_ENABLE_API_QUOTAS = true;
        private static final boolean DEFAULT_ENABLE_EXECUTION_SAFEGUARDS_UDC = true;
        private static final int DEFAULT_EXECUTION_SAFEGUARDS_UDC_ANR_COUNT = 3;
        private static final long DEFAULT_EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS = 21600000;
        private static final int DEFAULT_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT = 5;
        private static final int DEFAULT_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT = 3;
        private static final int DEFAULT_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT = 10;
        private static final int DEFAULT_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT = 2;
        private static final long DEFAULT_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS = 86400000;
        private static final float DEFAULT_HEAVY_USE_FACTOR = 0.9f;
        private static final long DEFAULT_MAX_CPU_ONLY_JOB_BATCH_DELAY_MS = 1860000;
        private static final long DEFAULT_MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS = 1860000;
        static final int DEFAULT_MAX_NUM_PERSISTED_JOB_WORK_ITEMS = 100000;
        private static final long DEFAULT_MIN_EXP_BACKOFF_TIME_MS = 10000;
        private static final long DEFAULT_MIN_LINEAR_BACKOFF_TIME_MS = 10000;
        private static final int DEFAULT_MIN_READY_CPU_ONLY_JOBS_COUNT = 0;
        private static final int DEFAULT_MIN_READY_NON_ACTIVE_JOBS_COUNT = 0;
        private static final float DEFAULT_MODERATE_USE_FACTOR = 0.5f;
        static final boolean DEFAULT_PERSIST_IN_SPLIT_FILES = true;
        private static final long DEFAULT_PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS = 3600000;
        public static final long DEFAULT_RUNTIME_CUMULATIVE_UI_LIMIT_MS = 86400000;
        public static final long DEFAULT_RUNTIME_FREE_QUOTA_MAX_LIMIT_MS = 1800000;
        public static final long DEFAULT_RUNTIME_MIN_EJ_GUARANTEE_MS = 180000;
        public static final long DEFAULT_RUNTIME_MIN_GUARANTEE_MS = 600000;
        public static final float DEFAULT_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR = 1.35f;
        public static final long DEFAULT_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS = 0;
        public static final long DEFAULT_RUNTIME_MIN_UI_GUARANTEE_MS = 0;
        public static final long DEFAULT_RUNTIME_UI_LIMIT_MS = 0;
        public static final boolean DEFAULT_RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS = false;
        private static final int DEFAULT_SYSTEM_STOP_TO_FAILURE_RATIO = 3;
        private static final String KEY_ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF = "abandoned_job_timeouts_before_aggressive_backoff";
        private static final String KEY_API_QUOTA_SCHEDULE_COUNT = "aq_schedule_count";
        private static final String KEY_API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT = "aq_schedule_return_failure";
        private static final String KEY_API_QUOTA_SCHEDULE_THROW_EXCEPTION = "aq_schedule_throw_exception";
        private static final String KEY_API_QUOTA_SCHEDULE_WINDOW_MS = "aq_schedule_window_ms";
        private static final String KEY_CONN_CONGESTION_DELAY_FRAC = "conn_congestion_delay_frac";
        private static final String KEY_CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC = "conn_low_signal_strength_relax_frac";
        private static final String KEY_CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS = "conn_max_connectivity_job_batch_delay_ms";
        private static final String KEY_CONN_PREFETCH_RELAX_FRAC = "conn_prefetch_relax_frac";
        private static final String KEY_CONN_TRANSPORT_BATCH_THRESHOLD = "conn_transport_batch_threshold";
        private static final String KEY_CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS = "conn_update_all_jobs_min_interval_ms";
        private static final String KEY_CONN_USE_CELL_SIGNAL_STRENGTH = "conn_use_cell_signal_strength";
        private static final String KEY_ENABLE_API_QUOTAS = "enable_api_quotas";
        private static final String KEY_ENABLE_EXECUTION_SAFEGUARDS_UDC = "enable_execution_safeguards_udc";
        private static final String KEY_EXECUTION_SAFEGUARDS_UDC_ANR_COUNT = "es_u_anr_count";
        private static final String KEY_EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS = "es_u_anr_window_ms";
        private static final String KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT = "es_u_timeout_ej_count";
        private static final String KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT = "es_u_timeout_reg_count";
        private static final String KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT = "es_u_timeout_total_count";
        private static final String KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT = "es_u_timeout_uij_count";
        private static final String KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS = "es_u_timeout_window_ms";
        private static final String KEY_HEAVY_USE_FACTOR = "heavy_use_factor";
        private static final String KEY_MAX_CPU_ONLY_JOB_BATCH_DELAY_MS = "max_cpu_only_job_batch_delay_ms";
        private static final String KEY_MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS = "max_non_active_job_batch_delay_ms";
        private static final String KEY_MAX_NUM_PERSISTED_JOB_WORK_ITEMS = "max_num_persisted_job_work_items";
        private static final String KEY_MIN_EXP_BACKOFF_TIME_MS = "min_exp_backoff_time_ms";
        private static final String KEY_MIN_LINEAR_BACKOFF_TIME_MS = "min_linear_backoff_time_ms";
        private static final String KEY_MIN_READY_CPU_ONLY_JOBS_COUNT = "min_ready_cpu_only_jobs_count";
        private static final String KEY_MIN_READY_NON_ACTIVE_JOBS_COUNT = "min_ready_non_active_jobs_count";
        private static final String KEY_MODERATE_USE_FACTOR = "moderate_use_factor";
        private static final String KEY_PERSIST_IN_SPLIT_FILES = "persist_in_split_files";
        private static final String KEY_PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS = "prefetch_force_batch_relax_threshold_ms";
        private static final String KEY_RUNTIME_CUMULATIVE_UI_LIMIT_MS = "runtime_cumulative_ui_limit_ms";
        private static final String KEY_RUNTIME_FREE_QUOTA_MAX_LIMIT_MS = "runtime_free_quota_max_limit_ms";
        private static final String KEY_RUNTIME_MIN_EJ_GUARANTEE_MS = "runtime_min_ej_guarantee_ms";
        private static final String KEY_RUNTIME_MIN_GUARANTEE_MS = "runtime_min_guarantee_ms";
        private static final String KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR = "runtime_min_ui_data_transfer_guarantee_buffer_factor";
        private static final String KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS = "runtime_min_ui_data_transfer_guarantee_ms";
        private static final String KEY_RUNTIME_MIN_UI_GUARANTEE_MS = "runtime_min_ui_guarantee_ms";
        private static final String KEY_RUNTIME_UI_LIMIT_MS = "runtime_ui_limit_ms";
        private static final String KEY_RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS = "runtime_use_data_estimates_for_limits";
        private static final String KEY_SYSTEM_STOP_TO_FAILURE_RATIO = "system_stop_to_failure_ratio";
        int ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF;
        public int API_QUOTA_SCHEDULE_COUNT;
        public boolean API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT;
        public boolean API_QUOTA_SCHEDULE_THROW_EXCEPTION;
        public long API_QUOTA_SCHEDULE_WINDOW_MS;
        public float CONN_CONGESTION_DELAY_FRAC;
        public float CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC;
        public long CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS;
        public float CONN_PREFETCH_RELAX_FRAC;
        public SparseIntArray CONN_TRANSPORT_BATCH_THRESHOLD;
        public long CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS;
        public boolean CONN_USE_CELL_SIGNAL_STRENGTH;
        public boolean ENABLE_API_QUOTAS;
        public boolean ENABLE_EXECUTION_SAFEGUARDS_UDC;
        public int EXECUTION_SAFEGUARDS_UDC_ANR_COUNT;
        public long EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS;
        public int EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT;
        public int EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT;
        public int EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT;
        public int EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT;
        public long EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS;
        float HEAVY_USE_FACTOR;
        long MAX_CPU_ONLY_JOB_BATCH_DELAY_MS;
        long MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS;
        public int MAX_NUM_PERSISTED_JOB_WORK_ITEMS;
        long MIN_EXP_BACKOFF_TIME_MS;
        long MIN_LINEAR_BACKOFF_TIME_MS;
        int MIN_READY_CPU_ONLY_JOBS_COUNT;
        int MIN_READY_NON_ACTIVE_JOBS_COUNT;
        float MODERATE_USE_FACTOR;
        public boolean PERSIST_IN_SPLIT_FILES;
        public long PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS;
        public long RUNTIME_CUMULATIVE_UI_LIMIT_MS;
        public long RUNTIME_FREE_QUOTA_MAX_LIMIT_MS;
        public long RUNTIME_MIN_EJ_GUARANTEE_MS;
        public long RUNTIME_MIN_GUARANTEE_MS;
        public float RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR;
        public long RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS;
        public long RUNTIME_MIN_UI_GUARANTEE_MS;
        public long RUNTIME_UI_LIMIT_MS;
        public boolean RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS;
        int SYSTEM_STOP_TO_FAILURE_RATIO;

        /* JADX INFO: renamed from: -$$Nest$mupdateApiQuotaConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4854$$Nest$mupdateApiQuotaConstantsLocked(Constants r0) {
            r0.updateApiQuotaConstantsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateBackoffConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4855$$Nest$mupdateBackoffConstantsLocked(Constants r0) {
            r0.updateBackoffConstantsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateBatchingConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4856$$Nest$mupdateBatchingConstantsLocked(Constants r0) {
            r0.updateBatchingConstantsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateConnectivityConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4857$$Nest$mupdateConnectivityConstantsLocked(Constants r0) {
            r0.updateConnectivityConstantsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdatePersistingConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4858$$Nest$mupdatePersistingConstantsLocked(Constants r0) {
            r0.updatePersistingConstantsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdatePrefetchConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4859$$Nest$mupdatePrefetchConstantsLocked(Constants r0) {
            r0.updatePrefetchConstantsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateRuntimeConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4860$$Nest$mupdateRuntimeConstantsLocked(Constants r0) {
            r0.updateRuntimeConstantsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateUseFactorConstantsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4861$$Nest$mupdateUseFactorConstantsLocked(Constants r0) {
            r0.updateUseFactorConstantsLocked();
        }

        static {
            DEFAULT_MIN_READY_CPU_ONLY_JOBS_COUNT = Math.min(3, JobConcurrencyManager.DEFAULT_CONCURRENCY_LIMIT / 3);
            DEFAULT_MIN_READY_NON_ACTIVE_JOBS_COUNT = Math.min(5, JobConcurrencyManager.DEFAULT_CONCURRENCY_LIMIT / 3);
            DEFAULT_CONN_TRANSPORT_BATCH_THRESHOLD = new SparseIntArray();
            DEFAULT_CONN_TRANSPORT_BATCH_THRESHOLD.put(0, Math.min(3, JobConcurrencyManager.DEFAULT_CONCURRENCY_LIMIT / 3));
            DEFAULT_RUNTIME_MIN_UI_GUARANTEE_MS = Math.max(DEFAULT_EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS, 600000);
            DEFAULT_RUNTIME_UI_LIMIT_MS = Math.max(43200000, 1800000);
            DEFAULT_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS = Math.max(600000, DEFAULT_RUNTIME_MIN_UI_GUARANTEE_MS);
        }

        public Constants() {
            this.MIN_READY_CPU_ONLY_JOBS_COUNT = DEFAULT_MIN_READY_CPU_ONLY_JOBS_COUNT;
            this.MIN_READY_NON_ACTIVE_JOBS_COUNT = DEFAULT_MIN_READY_NON_ACTIVE_JOBS_COUNT;
            this.MAX_CPU_ONLY_JOB_BATCH_DELAY_MS = 1860000;
            this.MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS = 1860000;
            this.HEAVY_USE_FACTOR = DEFAULT_HEAVY_USE_FACTOR;
            this.MODERATE_USE_FACTOR = 0.5f;
            this.MIN_LINEAR_BACKOFF_TIME_MS = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
            this.MIN_EXP_BACKOFF_TIME_MS = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
            this.SYSTEM_STOP_TO_FAILURE_RATIO = 3;
            this.ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF = 3;
            this.CONN_CONGESTION_DELAY_FRAC = 0.5f;
            this.CONN_PREFETCH_RELAX_FRAC = 0.5f;
            this.CONN_USE_CELL_SIGNAL_STRENGTH = true;
            this.CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS = 60000;
            this.CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC = 0.5f;
            this.CONN_TRANSPORT_BATCH_THRESHOLD = new SparseIntArray();
            this.CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS = 1860000;
            this.PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS = 3600000;
            this.ENABLE_API_QUOTAS = true;
            this.API_QUOTA_SCHEDULE_COUNT = 250;
            this.API_QUOTA_SCHEDULE_WINDOW_MS = 60000;
            this.API_QUOTA_SCHEDULE_THROW_EXCEPTION = true;
            this.API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT = false;
            this.ENABLE_EXECUTION_SAFEGUARDS_UDC = true;
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT = 2;
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT = 5;
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT = 3;
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT = 10;
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS = 86400000;
            this.EXECUTION_SAFEGUARDS_UDC_ANR_COUNT = 3;
            this.EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS = DEFAULT_EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS;
            this.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS = 1800000;
            this.RUNTIME_MIN_GUARANTEE_MS = 600000;
            this.RUNTIME_MIN_EJ_GUARANTEE_MS = 180000;
            this.RUNTIME_MIN_UI_GUARANTEE_MS = DEFAULT_RUNTIME_MIN_UI_GUARANTEE_MS;
            this.RUNTIME_UI_LIMIT_MS = DEFAULT_RUNTIME_UI_LIMIT_MS;
            this.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR = 1.35f;
            this.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS = DEFAULT_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS;
            this.RUNTIME_CUMULATIVE_UI_LIMIT_MS = 86400000;
            this.RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS = false;
            this.PERSIST_IN_SPLIT_FILES = true;
            this.MAX_NUM_PERSISTED_JOB_WORK_ITEMS = 100000;
            copyTransportBatchThresholdDefaults();
        }

        private void updateBatchingConstantsLocked() {
            this.MIN_READY_CPU_ONLY_JOBS_COUNT = Math.max(0, Math.min(JobConcurrencyManager.DEFAULT_CONCURRENCY_LIMIT / 3, DeviceConfig.getInt("jobscheduler", KEY_MIN_READY_CPU_ONLY_JOBS_COUNT, DEFAULT_MIN_READY_CPU_ONLY_JOBS_COUNT)));
            this.MIN_READY_NON_ACTIVE_JOBS_COUNT = Math.max(0, Math.min(JobConcurrencyManager.DEFAULT_CONCURRENCY_LIMIT / 3, DeviceConfig.getInt("jobscheduler", KEY_MIN_READY_NON_ACTIVE_JOBS_COUNT, DEFAULT_MIN_READY_NON_ACTIVE_JOBS_COUNT)));
            this.MAX_CPU_ONLY_JOB_BATCH_DELAY_MS = DeviceConfig.getLong("jobscheduler", KEY_MAX_CPU_ONLY_JOB_BATCH_DELAY_MS, 1860000);
            this.MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS = DeviceConfig.getLong("jobscheduler", KEY_MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS, 1860000);
        }

        private void updateUseFactorConstantsLocked() {
            this.HEAVY_USE_FACTOR = DeviceConfig.getFloat("jobscheduler", KEY_HEAVY_USE_FACTOR, DEFAULT_HEAVY_USE_FACTOR);
            this.MODERATE_USE_FACTOR = DeviceConfig.getFloat("jobscheduler", KEY_MODERATE_USE_FACTOR, 0.5f);
        }

        private void updateBackoffConstantsLocked() {
            this.MIN_LINEAR_BACKOFF_TIME_MS = DeviceConfig.getLong("jobscheduler", KEY_MIN_LINEAR_BACKOFF_TIME_MS, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
            this.MIN_EXP_BACKOFF_TIME_MS = DeviceConfig.getLong("jobscheduler", KEY_MIN_EXP_BACKOFF_TIME_MS, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
            this.SYSTEM_STOP_TO_FAILURE_RATIO = DeviceConfig.getInt("jobscheduler", KEY_SYSTEM_STOP_TO_FAILURE_RATIO, 3);
            this.ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF = DeviceConfig.getInt("jobscheduler", KEY_ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF, 3);
        }

        private void updateConnectivityConstantsLocked() {
            this.CONN_CONGESTION_DELAY_FRAC = DeviceConfig.getFloat("jobscheduler", KEY_CONN_CONGESTION_DELAY_FRAC, 0.5f);
            this.CONN_PREFETCH_RELAX_FRAC = DeviceConfig.getFloat("jobscheduler", KEY_CONN_PREFETCH_RELAX_FRAC, 0.5f);
            this.CONN_USE_CELL_SIGNAL_STRENGTH = DeviceConfig.getBoolean("jobscheduler", KEY_CONN_USE_CELL_SIGNAL_STRENGTH, true);
            this.CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS = DeviceConfig.getLong("jobscheduler", KEY_CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS, 60000);
            this.CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC = DeviceConfig.getFloat("jobscheduler", KEY_CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC, 0.5f);
            String batchThresholdConfigString = DeviceConfig.getString("jobscheduler", KEY_CONN_TRANSPORT_BATCH_THRESHOLD, null);
            KeyValueListParser parser = new KeyValueListParser(',');
            this.CONN_TRANSPORT_BATCH_THRESHOLD.clear();
            parser.setString(batchThresholdConfigString);     // Catch: IllegalArgumentException -> L8
            int t = parser.size() - 1;     // Catch: IllegalArgumentException -> L8
        L4:
            if (t < 0) goto L15;
            String transportString = parser.keyAt(t);     // Catch: IllegalArgumentException -> L8
            int transport = Integer.parseInt(transportString);     // Catch: IllegalArgumentException -> L8 NumberFormatException -> L10
            this.CONN_TRANSPORT_BATCH_THRESHOLD.put(transport, Math.max(0, Math.min(JobConcurrencyManager.DEFAULT_CONCURRENCY_LIMIT / 3, parser.getInt(transportString, 1))));     // Catch: IllegalArgumentException -> L8 NumberFormatException -> L10
        L12:
            t = t - 1;
        L10:
            e = move-exception;
            Slog.e("JobScheduler", "Bad transport string", e);     // Catch: IllegalArgumentException -> L8
        L15:
            this.CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS = Math.max(0, Math.min(86400000, DeviceConfig.getLong("jobscheduler", KEY_CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS, 1860000)));
            return;
        L8:
            e = move-exception;
            Slog.wtf("JobScheduler", "Bad string for conn_transport_batch_threshold", e);
            copyTransportBatchThresholdDefaults();
            goto L15
        }

        private void copyTransportBatchThresholdDefaults() {
            int i = DEFAULT_CONN_TRANSPORT_BATCH_THRESHOLD.size() - 1;
        L3:
            if (i < 0) goto L6;
            this.CONN_TRANSPORT_BATCH_THRESHOLD.put(DEFAULT_CONN_TRANSPORT_BATCH_THRESHOLD.keyAt(i), DEFAULT_CONN_TRANSPORT_BATCH_THRESHOLD.valueAt(i));
            i = i - 1;
            goto L3
        }

        private void updatePersistingConstantsLocked() {
            this.PERSIST_IN_SPLIT_FILES = DeviceConfig.getBoolean("jobscheduler", KEY_PERSIST_IN_SPLIT_FILES, true);
            this.MAX_NUM_PERSISTED_JOB_WORK_ITEMS = DeviceConfig.getInt("jobscheduler", KEY_MAX_NUM_PERSISTED_JOB_WORK_ITEMS, 100000);
        }

        private void updatePrefetchConstantsLocked() {
            this.PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS = DeviceConfig.getLong("jobscheduler", KEY_PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS, 3600000);
        }

        private void updateApiQuotaConstantsLocked() {
            this.ENABLE_API_QUOTAS = DeviceConfig.getBoolean("jobscheduler", KEY_ENABLE_API_QUOTAS, true);
            this.ENABLE_EXECUTION_SAFEGUARDS_UDC = DeviceConfig.getBoolean("jobscheduler", KEY_ENABLE_EXECUTION_SAFEGUARDS_UDC, true);
            this.API_QUOTA_SCHEDULE_COUNT = Math.max(250, DeviceConfig.getInt("jobscheduler", KEY_API_QUOTA_SCHEDULE_COUNT, 250));
            this.API_QUOTA_SCHEDULE_WINDOW_MS = DeviceConfig.getLong("jobscheduler", KEY_API_QUOTA_SCHEDULE_WINDOW_MS, 60000);
            this.API_QUOTA_SCHEDULE_THROW_EXCEPTION = DeviceConfig.getBoolean("jobscheduler", KEY_API_QUOTA_SCHEDULE_THROW_EXCEPTION, true);
            this.API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT = DeviceConfig.getBoolean("jobscheduler", KEY_API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT, false);
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT = Math.max(2, DeviceConfig.getInt("jobscheduler", KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT, 2));
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT = Math.max(2, DeviceConfig.getInt("jobscheduler", KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT, 5));
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT = Math.max(2, DeviceConfig.getInt("jobscheduler", KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT, 3));
            int highestTimeoutCount = Math.max(this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT, Math.max(this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT, this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT));
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT = Math.max(highestTimeoutCount, DeviceConfig.getInt("jobscheduler", KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT, 10));
            this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS = DeviceConfig.getLong("jobscheduler", KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS, 86400000);
            this.EXECUTION_SAFEGUARDS_UDC_ANR_COUNT = Math.max(1, DeviceConfig.getInt("jobscheduler", KEY_EXECUTION_SAFEGUARDS_UDC_ANR_COUNT, 3));
            this.EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS = DeviceConfig.getLong("jobscheduler", KEY_EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS, DEFAULT_EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS);
        }

        private void updateRuntimeConstantsLocked() {
            DeviceConfig.Properties properties = DeviceConfig.getProperties("jobscheduler", new String[]{KEY_RUNTIME_FREE_QUOTA_MAX_LIMIT_MS, KEY_RUNTIME_MIN_GUARANTEE_MS, KEY_RUNTIME_MIN_EJ_GUARANTEE_MS, KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR, KEY_RUNTIME_MIN_UI_GUARANTEE_MS, KEY_RUNTIME_UI_LIMIT_MS, KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS, KEY_RUNTIME_CUMULATIVE_UI_LIMIT_MS, KEY_RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS});
            this.RUNTIME_MIN_GUARANTEE_MS = Math.max(600000, properties.getLong(KEY_RUNTIME_MIN_GUARANTEE_MS, 600000));
            this.RUNTIME_MIN_EJ_GUARANTEE_MS = Math.max(60000, properties.getLong(KEY_RUNTIME_MIN_EJ_GUARANTEE_MS, 180000));
            this.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS = Math.max(this.RUNTIME_MIN_GUARANTEE_MS, properties.getLong(KEY_RUNTIME_FREE_QUOTA_MAX_LIMIT_MS, 1800000));
            this.RUNTIME_MIN_UI_GUARANTEE_MS = Math.max(this.RUNTIME_MIN_GUARANTEE_MS, properties.getLong(KEY_RUNTIME_MIN_UI_GUARANTEE_MS, DEFAULT_RUNTIME_MIN_UI_GUARANTEE_MS));
            this.RUNTIME_UI_LIMIT_MS = Math.max(this.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS, Math.max(this.RUNTIME_MIN_UI_GUARANTEE_MS, properties.getLong(KEY_RUNTIME_UI_LIMIT_MS, DEFAULT_RUNTIME_UI_LIMIT_MS)));
            this.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR = Math.max(1.0f, properties.getFloat(KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR, 1.35f));
            this.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS = Math.max(this.RUNTIME_MIN_UI_GUARANTEE_MS, properties.getLong(KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS, DEFAULT_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS));
            this.RUNTIME_CUMULATIVE_UI_LIMIT_MS = Math.max(this.RUNTIME_UI_LIMIT_MS, properties.getLong(KEY_RUNTIME_CUMULATIVE_UI_LIMIT_MS, 86400000));
            this.RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS = properties.getBoolean(KEY_RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS, false);
        }

        void dump(IndentingPrintWriter pw) {
            pw.println("Settings:");
            pw.increaseIndent();
            pw.print(KEY_MIN_READY_CPU_ONLY_JOBS_COUNT, Integer.valueOf(this.MIN_READY_CPU_ONLY_JOBS_COUNT)).println();
            pw.print(KEY_MIN_READY_NON_ACTIVE_JOBS_COUNT, Integer.valueOf(this.MIN_READY_NON_ACTIVE_JOBS_COUNT)).println();
            pw.print(KEY_MAX_CPU_ONLY_JOB_BATCH_DELAY_MS, Long.valueOf(this.MAX_CPU_ONLY_JOB_BATCH_DELAY_MS)).println();
            pw.print(KEY_MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS, Long.valueOf(this.MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS)).println();
            pw.print(KEY_HEAVY_USE_FACTOR, Float.valueOf(this.HEAVY_USE_FACTOR)).println();
            pw.print(KEY_MODERATE_USE_FACTOR, Float.valueOf(this.MODERATE_USE_FACTOR)).println();
            pw.print(KEY_MIN_LINEAR_BACKOFF_TIME_MS, Long.valueOf(this.MIN_LINEAR_BACKOFF_TIME_MS)).println();
            pw.print(KEY_MIN_EXP_BACKOFF_TIME_MS, Long.valueOf(this.MIN_EXP_BACKOFF_TIME_MS)).println();
            pw.print(KEY_SYSTEM_STOP_TO_FAILURE_RATIO, Integer.valueOf(this.SYSTEM_STOP_TO_FAILURE_RATIO)).println();
            pw.print(KEY_ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF, Integer.valueOf(this.ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF)).println();
            pw.print(KEY_CONN_CONGESTION_DELAY_FRAC, Float.valueOf(this.CONN_CONGESTION_DELAY_FRAC)).println();
            pw.print(KEY_CONN_PREFETCH_RELAX_FRAC, Float.valueOf(this.CONN_PREFETCH_RELAX_FRAC)).println();
            pw.print(KEY_CONN_USE_CELL_SIGNAL_STRENGTH, Boolean.valueOf(this.CONN_USE_CELL_SIGNAL_STRENGTH)).println();
            pw.print(KEY_CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS, Long.valueOf(this.CONN_UPDATE_ALL_JOBS_MIN_INTERVAL_MS)).println();
            pw.print(KEY_CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC, Float.valueOf(this.CONN_LOW_SIGNAL_STRENGTH_RELAX_FRAC)).println();
            pw.print(KEY_CONN_TRANSPORT_BATCH_THRESHOLD, this.CONN_TRANSPORT_BATCH_THRESHOLD.toString()).println();
            pw.print(KEY_CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS, Long.valueOf(this.CONN_MAX_CONNECTIVITY_JOB_BATCH_DELAY_MS)).println();
            pw.print(KEY_PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS, Long.valueOf(this.PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS)).println();
            pw.print(KEY_ENABLE_API_QUOTAS, Boolean.valueOf(this.ENABLE_API_QUOTAS)).println();
            pw.print(KEY_API_QUOTA_SCHEDULE_COUNT, Integer.valueOf(this.API_QUOTA_SCHEDULE_COUNT)).println();
            pw.print(KEY_API_QUOTA_SCHEDULE_WINDOW_MS, Long.valueOf(this.API_QUOTA_SCHEDULE_WINDOW_MS)).println();
            pw.print(KEY_API_QUOTA_SCHEDULE_THROW_EXCEPTION, Boolean.valueOf(this.API_QUOTA_SCHEDULE_THROW_EXCEPTION)).println();
            pw.print(KEY_API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT, Boolean.valueOf(this.API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT)).println();
            pw.print(KEY_ENABLE_EXECUTION_SAFEGUARDS_UDC, Boolean.valueOf(this.ENABLE_EXECUTION_SAFEGUARDS_UDC)).println();
            pw.print(KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT, Integer.valueOf(this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT)).println();
            pw.print(KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT, Integer.valueOf(this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT)).println();
            pw.print(KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT, Integer.valueOf(this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT)).println();
            pw.print(KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT, Integer.valueOf(this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT)).println();
            pw.print(KEY_EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS, Long.valueOf(this.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS)).println();
            pw.print(KEY_EXECUTION_SAFEGUARDS_UDC_ANR_COUNT, Integer.valueOf(this.EXECUTION_SAFEGUARDS_UDC_ANR_COUNT)).println();
            pw.print(KEY_EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS, Long.valueOf(this.EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS)).println();
            pw.print(KEY_RUNTIME_MIN_GUARANTEE_MS, Long.valueOf(this.RUNTIME_MIN_GUARANTEE_MS)).println();
            pw.print(KEY_RUNTIME_MIN_EJ_GUARANTEE_MS, Long.valueOf(this.RUNTIME_MIN_EJ_GUARANTEE_MS)).println();
            pw.print(KEY_RUNTIME_FREE_QUOTA_MAX_LIMIT_MS, Long.valueOf(this.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS)).println();
            pw.print(KEY_RUNTIME_MIN_UI_GUARANTEE_MS, Long.valueOf(this.RUNTIME_MIN_UI_GUARANTEE_MS)).println();
            pw.print(KEY_RUNTIME_UI_LIMIT_MS, Long.valueOf(this.RUNTIME_UI_LIMIT_MS)).println();
            pw.print(KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR, Float.valueOf(this.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR)).println();
            pw.print(KEY_RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS, Long.valueOf(this.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS)).println();
            pw.print(KEY_RUNTIME_CUMULATIVE_UI_LIMIT_MS, Long.valueOf(this.RUNTIME_CUMULATIVE_UI_LIMIT_MS)).println();
            pw.print(KEY_RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS, Boolean.valueOf(this.RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS)).println();
            pw.print(KEY_PERSIST_IN_SPLIT_FILES, Boolean.valueOf(this.PERSIST_IN_SPLIT_FILES)).println();
            pw.print(KEY_MAX_NUM_PERSISTED_JOB_WORK_ITEMS, Integer.valueOf(this.MAX_NUM_PERSISTED_JOB_WORK_ITEMS)).println();
            pw.decreaseIndent();
        }

        void dump(ProtoOutputStream proto) {
            proto.write(1120986464285L, this.MIN_READY_NON_ACTIVE_JOBS_COUNT);
            proto.write(1112396529694L, this.MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS);
            proto.write(1103806595080L, this.HEAVY_USE_FACTOR);
            proto.write(1103806595081L, this.MODERATE_USE_FACTOR);
            proto.write(1112396529681L, this.MIN_LINEAR_BACKOFF_TIME_MS);
            proto.write(1112396529682L, this.MIN_EXP_BACKOFF_TIME_MS);
            proto.write(1103806595093L, this.CONN_CONGESTION_DELAY_FRAC);
            proto.write(1103806595094L, this.CONN_PREFETCH_RELAX_FRAC);
            proto.write(1133871366175L, this.ENABLE_API_QUOTAS);
            proto.write(1120986464288L, this.API_QUOTA_SCHEDULE_COUNT);
            proto.write(1112396529697L, this.API_QUOTA_SCHEDULE_WINDOW_MS);
            proto.write(1133871366178L, this.API_QUOTA_SCHEDULE_THROW_EXCEPTION);
            proto.write(1133871366179L, this.API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT);
        }
    }

    private class ConstantsObserver implements DeviceConfig.OnPropertiesChangedListener {
        private boolean mCacheConfigChanges;
        private DeviceConfig.Properties mLastPropertiesPulled;
        final /* synthetic */ JobSchedulerService this$0;

        /* synthetic */ ConstantsObserver(JobSchedulerService r1, JobSchedulerServiceIA r2) {
            this(r1);
        }

        private ConstantsObserver(JobSchedulerService r1) {
            this.this$0 = r1;
            this.mCacheConfigChanges = false;
        }

        public String getValueLocked(String key) {
            if (this.mLastPropertiesPulled != null) goto L6;
            return null;
        L6:
            return this.mLastPropertiesPulled.getString(key, null);
        }

        public void setCacheConfigChangesLocked(boolean enabled) {
            if (enabled == true) goto L4;
        L6:
            this.mLastPropertiesPulled = null;
        L7:
            this.mCacheConfigChanges = enabled;
            return;
        L4:
            if (this.mCacheConfigChanges == true) goto L6;
            this.mLastPropertiesPulled = DeviceConfig.getProperties("jobscheduler", new String[0]);
            goto L7
        }

        public void start() {
            DeviceConfig.addOnPropertiesChangedListener("jobscheduler", AppSchedulingModuleThread.getExecutor(), this);
            onPropertiesChanged(DeviceConfig.getProperties("jobscheduler", new String[0]));
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            boolean apiQuotaScheduleUpdated = false;
            boolean concurrencyUpdated = false;
            boolean persistenceUpdated = false;
            boolean runtimeUpdated = false;
            int controller = 0;
        L4:
            if (controller >= this.this$0.mControllers.size()) goto L6;
            StateController sc = this.this$0.mControllers.get(controller);
            sc.prepareForUpdatedConstantsLocked();
            controller = controller + 1;
            goto L4
        L6:
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
        L11:
            th = move-exception;
            throw th;
        L9:
            if (this.mCacheConfigChanges == false) goto L13;
            this.mLastPropertiesPulled = DeviceConfig.getProperties("jobscheduler", new String[0]);     // Catch: Throwable -> L11
        L13:
            Iterator r5 = properties.getKeyset().iterator();     // Catch: Throwable -> L11
        L14:
            byte r8 = 1;
            if (r5.hasNext() == false) goto L175;
            String name = (String) r5.next();     // Catch: Throwable -> L11
            if (name == null) goto L14;
            if (JobSchedulerService.DEBUG == false) goto L22;
        L23:
            Slog.d("JobScheduler", "DeviceConfig " + name + " changed to " + properties.getString(name, null));     // Catch: Throwable -> L11
        L25:
            switch(name.hashCode()) {
                case -1847335205: goto L151;
                case -1787939498: goto L148;
                case -1644162308: goto L145;
                case -1470844605: goto L142;
                case -1313417082: goto L139;
                case -1272362358: goto L136;
                case -1215861621: goto L133;
                case -1194025741: goto L130;
                case -1062323940: goto L127;
                case -953747139: goto L124;
                case -941023983: goto L121;
                case -885226119: goto L118;
                case -803030002: goto L115;
                case -722508861: goto L112;
                case -687279910: goto L109;
                case -544478093: goto L106;
                case -492250078: goto L103;
                case -376691020: goto L100;
                case -138964320: goto L97;
                case -109453036: goto L94;
                case -57293457: goto L91;
                case -45782187: goto L88;
                case 213091160: goto L85;
                case 232730669: goto L82;
                case 263198386: goto L79;
                case 289418623: goto L76;
                case 316308971: goto L73;
                case 322281628: goto L70;
                case 408648654: goto L67;
                case 709194164: goto L64;
                case 811737328: goto L61;
                case 963672867: goto L58;
                case 1004645316: goto L55;
                case 1185412831: goto L52;
                case 1185743293: goto L49;
                case 1302735555: goto L46;
                case 1317782410: goto L43;
                case 1396959553: goto L40;
                case 1470808280: goto L37;
                case 1680706484: goto L34;
                case 1692637170: goto L31;
                case 1982168173: goto L28;
                default: goto L153;
            };     // Catch: Throwable -> L11
        L153:
            r8 = -1;
        L154:
            switch(r8) {
                case 0: goto L172;
                case 1: goto L172;
                case 2: goto L172;
                case 3: goto L172;
                case 4: goto L172;
                case 5: goto L172;
                case 6: goto L172;
                case 7: goto L172;
                case 8: goto L172;
                case 9: goto L172;
                case 10: goto L172;
                case 11: goto L172;
                case 12: goto L172;
                case 13: goto L171;
                case 14: goto L171;
                case 15: goto L171;
                case 16: goto L171;
                case 17: goto L170;
                case 18: goto L170;
                case 19: goto L169;
                case 20: goto L169;
                case 21: goto L169;
                case 22: goto L169;
                case 23: goto L168;
                case 24: goto L168;
                case 25: goto L168;
                case 26: goto L168;
                case 27: goto L168;
                case 28: goto L168;
                case 29: goto L168;
                case 30: goto L167;
                case 31: goto L165;
                case 32: goto L165;
                case 33: goto L165;
                case 34: goto L165;
                case 35: goto L165;
                case 36: goto L165;
                case 37: goto L165;
                case 38: goto L165;
                case 39: goto L165;
                case 40: goto L163;
                case 41: goto L163;
                default: goto L156;
            };     // Catch: Throwable -> L11
        L163:
            if (persistenceUpdated == true) goto L14;
            Constants.m4858$$Nest$mupdatePersistingConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            this.this$0.mJobs.setUseSplitFiles(this.this$0.mConstants.PERSIST_IN_SPLIT_FILES);     // Catch: Throwable -> L11
            persistenceUpdated = true;
            goto L14
        L165:
            if (runtimeUpdated == true) goto L14;
            Constants.m4860$$Nest$mupdateRuntimeConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            runtimeUpdated = true;
            goto L14
        L167:
            Constants.m4859$$Nest$mupdatePrefetchConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            goto L14
        L168:
            Constants.m4857$$Nest$mupdateConnectivityConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            goto L14
        L169:
            Constants.m4855$$Nest$mupdateBackoffConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            goto L14
        L170:
            Constants.m4861$$Nest$mupdateUseFactorConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            goto L14
        L171:
            Constants.m4856$$Nest$mupdateBatchingConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            goto L14
        L172:
            if (apiQuotaScheduleUpdated == true) goto L14;
            Constants.m4854$$Nest$mupdateApiQuotaConstantsLocked(this.this$0.mConstants);     // Catch: Throwable -> L11
            this.this$0.updateQuotaTracker();     // Catch: Throwable -> L11
            apiQuotaScheduleUpdated = true;
            goto L14
        L156:
            if (name.startsWith("concurrency_") == false) goto L159;
            if (concurrencyUpdated == true) goto L159;
            this.this$0.mConcurrencyManager.updateConfigLocked();     // Catch: Throwable -> L11
            concurrencyUpdated = true;
        L159:
            int ctrlr = 0;
        L161:
            if (ctrlr >= this.this$0.mControllers.size()) goto L14;
            StateController sc2 = this.this$0.mControllers.get(ctrlr);     // Catch: Throwable -> L11
            sc2.processConstantLocked(properties, name);     // Catch: Throwable -> L11
            ctrlr = ctrlr + 1;     // Catch: Throwable -> L11
            goto L161
        L28:
            if (name.equals("abandoned_job_timeouts_before_aggressive_backoff") == false) goto L153;
            r8 = ParameterName.COLOR_TUNE;
            goto L154
        L31:
            if (name.equals("conn_prefetch_relax_frac") == false) goto L153;
            r8 = ParameterName.GLOBE_DIMMING;
            goto L154
        L34:
            if (name.equals("runtime_min_ui_guarantee_ms") == false) goto L153;
            r8 = 34;
            goto L154
        L37:
            if (name.equals("runtime_free_quota_max_limit_ms") == false) goto L153;
            r8 = ParameterName.VRR;
            goto L154
        L40:
            if (name.equals("runtime_min_ui_data_transfer_guarantee_buffer_factor") == false) goto L153;
            r8 = 36;
            goto L154
        L43:
            if (name.equals("max_cpu_only_job_batch_delay_ms") == false) goto L153;
            r8 = 15;
            goto L154
        L46:
            if (name.equals("persist_in_split_files") == false) goto L153;
            r8 = 41;
            goto L154
        L49:
            if (name.equals("aq_schedule_throw_exception") == false) goto L153;
            r8 = 5;
            goto L154
        L52:
            if (name.equals("system_stop_to_failure_ratio") == false) goto L153;
            r8 = ParameterName.BLUE_STRETCH;
            goto L154
        L55:
            if (name.equals("min_ready_non_active_jobs_count") == false) goto L153;
            r8 = 14;
            goto L154
        L58:
            if (name.equals("conn_max_connectivity_job_batch_delay_ms") == false) goto L153;
            r8 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
            goto L154
        L61:
            if (name.equals("runtime_cumulative_ui_limit_ms") == false) goto L153;
            r8 = ParameterName.COLOR_TEMPERATURE_GREEN_GAIN;
            goto L154
        L64:
            if (name.equals("min_linear_backoff_time_ms") == false) goto L153;
            r8 = ParameterName.FILM_MODE;
            goto L154
        L67:
            if (name.equals("es_u_timeout_ej_count") == false) goto L153;
            r8 = 7;
            goto L154
        L70:
            if (name.equals("es_u_timeout_window_ms") == false) goto L153;
            r8 = 10;
            goto L154
        L73:
            if (name.equals("es_u_timeout_reg_count") == false) goto L153;
            r8 = 8;
            goto L154
        L76:
            if (name.equals("heavy_use_factor") == false) goto L153;
            r8 = ParameterName.DE_CONTOUR;
            goto L154
        L79:
            if (name.equals("min_exp_backoff_time_ms") == false) goto L153;
            r8 = ParameterName.BLACK_STRETCH;
            goto L154
        L82:
            if (name.equals("es_u_timeout_uij_count") == false) goto L153;
            r8 = 6;
            goto L154
        L85:
            if (name.equals("runtime_use_data_estimates_for_limits") == false) goto L153;
            r8 = ParameterName.COLOR_TEMPERATURE_BLUE_GAIN;
            goto L154
        L88:
            if (name.equals("max_non_active_job_batch_delay_ms") == false) goto L153;
            r8 = 16;
            goto L154
        L91:
            if (name.equals("conn_congestion_delay_frac") == false) goto L153;
            r8 = ParameterName.COLOR_TEMPERATURE;
            goto L154
        L94:
            if (name.equals("aq_schedule_return_failure") == false) goto L153;
            r8 = 4;
            goto L154
        L97:
            if (name.equals("es_u_anr_window_ms") == false) goto L153;
            r8 = 12;
            goto L154
        L100:
            if (name.equals("max_num_persisted_job_work_items") == false) goto L153;
            r8 = ParameterName.COLOR_TEMPERATURE_RED_OFFSET;
            goto L154
        L103:
            if (name.equals("conn_low_signal_strength_relax_frac") == false) goto L153;
            r8 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
            goto L154
        L106:
            if (name.equals("runtime_min_ui_data_transfer_guarantee_ms") == false) goto L153;
            r8 = 37;
            goto L154
        L109:
            if (name.equals("es_u_anr_count") == false) goto L153;
            r8 = 11;
            goto L154
        L112:
            if (name.equals("moderate_use_factor") == false) goto L153;
            r8 = ParameterName.DYNAMIC_LUMA_CONTROL;
            goto L154
        L115:
            if (name.equals("runtime_ui_limit_ms") == false) goto L153;
            r8 = 35;
            goto L154
        L118:
            if (name.equals("min_ready_cpu_only_jobs_count") == false) goto L153;
            r8 = 13;
            goto L154
        L121:
            if (name.equals("runtime_min_guarantee_ms") == false) goto L153;
            r8 = ParameterName.CVRR;
            goto L154
        L124:
            if (name.equals("conn_transport_batch_threshold") == false) goto L153;
            r8 = ParameterName.LEVEL_RANGE;
            goto L154
        L127:
            if (name.equals("aq_schedule_window_ms") == false) goto L153;
            r8 = 3;
            goto L154
        L130:
            if (name.equals("enable_execution_safeguards_udc") == false) goto L153;
        L133:
            if (name.equals("conn_update_all_jobs_min_interval_ms") == false) goto L153;
            r8 = ParameterName.PC_MODE;
            goto L154
        L136:
            if (name.equals("prefetch_force_batch_relax_threshold_ms") == false) goto L153;
            r8 = ParameterName.LOW_LATENCY;
            goto L154
        L139:
            if (name.equals("conn_use_cell_signal_strength") == false) goto L153;
            r8 = ParameterName.GAMUT_MAPPING;
            goto L154
        L142:
            if (name.equals("runtime_min_ej_guarantee_ms") == false) goto L153;
            r8 = 33;
            goto L154
        L145:
            if (name.equals("enable_api_quotas") == false) goto L153;
            r8 = 0;
            goto L154
        L148:
            if (name.equals("aq_schedule_count") == false) goto L153;
            r8 = 2;
            goto L154
        L151:
            if (name.equals("es_u_timeout_total_count") == false) goto L153;
            r8 = 9;
            goto L154
        L22:
            if (this.mCacheConfigChanges == false) goto L25;
        L175:
            int controller2 = 0;
        L177:
            if (controller2 >= this.this$0.mControllers.size()) goto L180;
            StateController sc3 = this.this$0.mControllers.get(controller2);     // Catch: Throwable -> L11
            sc3.onConstantsUpdatedLocked();     // Catch: Throwable -> L11
            controller2 = controller2 + 1;     // Catch: Throwable -> L11
            goto L177
        L180:
            monitor-exit(r4);     // Catch: Throwable -> L11
            this.this$0.mHandler.sendEmptyMessage(1);
        }
    }

    static class DeferredJobCounter implements Consumer<JobStatus> {
        private int mDeferred;

        DeferredJobCounter() {
            this.mDeferred = 0;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(JobStatus r1) {
            accept2(r1);
        }

        public int numDeferred() {
            return this.mDeferred;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(JobStatus job) {
            if (job.getWhenStandbyDeferred() <= 0) goto L6;
            this.mDeferred++;
            return;
        }
    }

    private final class JobHandler extends Handler {
        final /* synthetic */ JobSchedulerService this$0;

        public JobHandler(JobSchedulerService r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mReadyToRock == true) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            boolean isRunning = false;
            boolean disabled = true;
            switch(message.what) {
                case 0: goto L107;
                case 1: goto L101;
                case 2: goto L99;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L79;
                case 6: goto L71;
                case 7: goto L57;
                case 8: goto L54;
                case 9: goto L44;
                case 10: goto L25;
                case 11: goto L13;
                default: goto L115;
            };     // Catch: Throwable -> L8
        L13:
            SomeArgs args = (SomeArgs) message.obj;     // Catch: Throwable -> L8
            JobServiceContext r0 = (JobServiceContext) args.arg1;     // Catch: Throwable -> L8
            UserVisibleJobSummary summary = ((JobStatus) args.arg2).getUserVisibleJobSummary();     // Catch: Throwable -> L8
            if (args.argi1 != 1) goto L17;
            isRunning = true;
        L17:
            int i = JobSchedulerService.m4831$$Nest$fgetmUserVisibleJobObservers(this.this$0).beginBroadcast() - 1;
        L18:
            if (i < 0) goto L24;
            JobSchedulerService.m4831$$Nest$fgetmUserVisibleJobObservers(this.this$0).getBroadcastItem(i).onUserVisibleJobStateChanged(summary, isRunning);     // Catch: Throwable -> L8 RemoteException -> L21
        L22:
            i = i - 1;
            goto L18
        L24:
            JobSchedulerService.m4831$$Nest$fgetmUserVisibleJobObservers(this.this$0).finishBroadcast();     // Catch: Throwable -> L8
            args.recycle();     // Catch: Throwable -> L8
            goto L115
        L25:
            IUserVisibleJobObserver observer = (IUserVisibleJobObserver) message.obj;     // Catch: Throwable -> L8
            Object r4 = this.this$0.mLock;     // Catch: Throwable -> L8
            monitor-enter(r4);     // Catch: Throwable -> L8
            int i2 = this.this$0.mConcurrencyManager.mActiveServices.size() - 1;     // Catch: Throwable -> L35
        L28:
            if (i2 < 0) goto L40;
            JobServiceContext context = this.this$0.mConcurrencyManager.mActiveServices.get(i2);     // Catch: Throwable -> L35
            JobStatus jobStatus = context.getRunningJobLocked();     // Catch: Throwable -> L35
            if (jobStatus == null) goto L39;
            if (jobStatus.isUserVisibleJob() == false) goto L39;
            observer.onUserVisibleJobStateChanged(jobStatus.getUserVisibleJobSummary(), true);     // Catch: Throwable -> L35 RemoteException -> L37
        L39:
            i2 = i2 - 1;
        L40:
            monitor-exit(r4);     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L44:
            SomeArgs args2 = (SomeArgs) message.obj;     // Catch: Throwable -> L8
            Object r3 = this.this$0.mLock;     // Catch: Throwable -> L8
            monitor-enter(r3);     // Catch: Throwable -> L8
            JobSchedulerService.m4849$$Nest$mupdateMediaBackupExemptionLocked(this.this$0, args2.argi1, (String) args2.arg1, (String) args2.arg2);     // Catch: Throwable -> L50
            monitor-exit(r3);     // Catch: Throwable -> L50
            args2.recycle();     // Catch: Throwable -> L8
            goto L115
        L50:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L57:
            int uid = message.arg1;     // Catch: Throwable -> L8
            if (message.arg2 != 0) goto L61;
            disabled = false;
        L61:
            if (disabled == false) goto L63;
            this.this$0.cancelJobsForUid(uid, true, 11, 1, "app uid idle");     // Catch: Throwable -> L8
        L63:
            Object r5 = this.this$0.mLock;     // Catch: Throwable -> L8
            monitor-enter(r5);     // Catch: Throwable -> L8
            JobSchedulerService.m4821$$Nest$fgetmDeviceIdleJobsController(this.this$0).setUidActiveLocked(uid, false);     // Catch: Throwable -> L68
            monitor-exit(r5);     // Catch: Throwable -> L68
        L68:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L71:
            int uid2 = message.arg1;     // Catch: Throwable -> L8
            Object r6 = this.this$0.mLock;     // Catch: Throwable -> L8
            monitor-enter(r6);     // Catch: Throwable -> L8
            JobSchedulerService.m4821$$Nest$fgetmDeviceIdleJobsController(this.this$0).setUidActiveLocked(uid2, true);     // Catch: Throwable -> L76
            monitor-exit(r6);     // Catch: Throwable -> L76
        L76:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L79:
            int uid3 = message.arg1;     // Catch: Throwable -> L8
            if (message.arg2 != 0) goto L83;
            disabled = false;
        L83:
            this.this$0.updateUidState(uid3, 19, 0);     // Catch: Throwable -> L8
            if (disabled == false) goto L86;
            this.this$0.cancelJobsForUid(uid3, true, 11, 1, "uid gone");     // Catch: Throwable -> L8
        L86:
            Object r7 = this.this$0.mLock;     // Catch: Throwable -> L8
            monitor-enter(r7);     // Catch: Throwable -> L8
            JobSchedulerService.m4821$$Nest$fgetmDeviceIdleJobsController(this.this$0).setUidActiveLocked(uid3, false);     // Catch: Throwable -> L91
            monitor-exit(r7);     // Catch: Throwable -> L91
        L91:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L94:
            SomeArgs args3 = (SomeArgs) message.obj;     // Catch: Throwable -> L8
            int uid4 = args3.argi1;     // Catch: Throwable -> L8
            int procState = args3.argi2;     // Catch: Throwable -> L8
            int capabilities = args3.argi3;     // Catch: Throwable -> L8
            this.this$0.updateUidState(uid4, procState, capabilities);     // Catch: Throwable -> L8
            args3.recycle();     // Catch: Throwable -> L8
            goto L115
        L99:
            JobSchedulerService.m4833$$Nest$mcancelJobImplLocked(this.this$0, (JobStatus) message.obj, null, message.arg1, 1, "app no longer allowed to run");     // Catch: Throwable -> L8
            goto L115
        L107:
            JobStatus js = (JobStatus) message.obj;     // Catch: Throwable -> L8
            if (js != null) goto L110;
            Slog.e("JobScheduler", "Given null job to check individually");     // Catch: Throwable -> L8
            goto L115
        L110:
            if (this.this$0.isReadyToBeExecutedLocked(js) == false) goto L112;
            this.this$0.mJobPackageTracker.notePending(js);     // Catch: Throwable -> L8
            JobSchedulerService.m4823$$Nest$fgetmPendingJobQueue(this.this$0).add(js);     // Catch: Throwable -> L8
        L112:
            JobSchedulerService.m4818$$Nest$fgetmChangedJobList(this.this$0).remove(js);     // Catch: Throwable -> L8
        L115:
            this.this$0.maybeRunPendingJobsLocked();     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L54:
            if (JobSchedulerService.DEBUG == false) goto L56;
            Slog.d("JobScheduler", "MSG_CHECK_CHANGED_JOB_LIST");     // Catch: Throwable -> L8
        L56:
            JobSchedulerService.m4837$$Nest$mcheckChangedJobListLocked(this.this$0);     // Catch: Throwable -> L8
            goto L115
        L96:
            if (JobSchedulerService.DEBUG == false) goto L98;
            Slog.d("JobScheduler", "MSG_CHECK_JOB_GREEDY");     // Catch: Throwable -> L8
        L98:
            JobSchedulerService.m4848$$Nest$mqueueReadyJobsForExecutionLocked(this.this$0);     // Catch: Throwable -> L8
            goto L115
        L101:
            if (JobSchedulerService.DEBUG == false) goto L104;
            Slog.d("JobScheduler", "MSG_CHECK_JOB");     // Catch: Throwable -> L8
        L104:
            if (this.this$0.mReportedActive == false) goto L106;
            JobSchedulerService.m4848$$Nest$mqueueReadyJobsForExecutionLocked(this.this$0);     // Catch: Throwable -> L8
            goto L115
        L106:
            JobSchedulerService.m4846$$Nest$mmaybeQueueReadyJobsForExecutionLocked(this.this$0);     // Catch: Throwable -> L8
            goto L115
        }
    }

    final class JobSchedulerStub extends IJobScheduler.Stub {
        final /* synthetic */ JobSchedulerService this$0;

        public static /* synthetic */ void $r8$lambda$9isYUgRbOiEZYC69DvsyhLYoFxk(JobSchedulerStub r0, ArrayList r1, JobStatus r2) {
            r0.lambda$getAllJobSnapshots$0(r1, r2);
        }

        JobSchedulerStub(JobSchedulerService this$0) {
            this.this$0 = this$0;
        }

        private void enforceValidJobRequest(int uid, int pid, JobInfo job) {
            PackageManager pm = this.this$0.getContext().createContextAsUser(UserHandle.getUserHandleForUid(uid), 0).getPackageManager();
            ComponentName service = job.getService();
            ServiceInfo si = pm.getServiceInfo(service, 786432);     // Catch: PackageManager.NameNotFoundException -> L28
            if (si == null) goto L33;
            if (si.applicationInfo.uid != uid) goto L31;
            if ("android.permission.BIND_JOB_SERVICE".equals(si.permission) == false) goto L27;
            if (job.isPersisted() == false) goto L17;
            if (canPersistJobs(pid, uid) == true) goto L17;
            throw new IllegalArgumentException("Requested job cannot be persisted without holding android.permission.RECEIVE_BOOT_COMPLETED permission");
        L17:
            if (job.getRequiredNetwork() != null) goto L19;
            return;
        L19:
            if (CompatChanges.isChangeEnabled(JobSchedulerService.REQUIRE_NETWORK_PERMISSIONS_FOR_CONNECTIVITY_JOBS, uid) == true) goto L21;
            return;
        L21:
            if (JobSchedulerService.m4845$$Nest$mhasPermission(this.this$0, uid, pid, "android.permission.ACCESS_NETWORK_STATE") == false) goto L24;
            return;
        L24:
            throw new SecurityException("android.permission.ACCESS_NETWORK_STATE required for jobs with a connectivity constraint");
        L27:
            throw new IllegalArgumentException("Scheduled service " + service + " does not require android.permission.BIND_JOB_SERVICE permission");     // Catch: PackageManager.NameNotFoundException -> L28
        L31:
            throw new IllegalArgumentException("uid " + uid + " cannot schedule job in " + service.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L28
        L33:
            throw new IllegalArgumentException("No such service " + service);     // Catch: PackageManager.NameNotFoundException -> L28
        L35:
            throw new IllegalArgumentException("Tried to schedule job for non-existent component: " + service);
        }

        private JobInfo enforceBuilderApiPermissions(int uid, int pid, JobInfo job) {
            if (job.getBias() != 0) goto L5;
        L12:
            return job;
        L5:
            if (JobSchedulerService.m4845$$Nest$mhasPermission(this.this$0, uid, pid, "android.permission.UPDATE_DEVICE_STATS") == true) goto L12;
            if (CompatChanges.isChangeEnabled(JobSchedulerService.THROW_ON_UNSUPPORTED_BIAS_USAGE, uid) == true) goto L11;
            Slog.w("JobScheduler", "Uid " + uid + " set bias on its job");
            return new JobInfo.Builder(job).setBias(0).build(false, false, false, false);
        L11:
            throw new SecurityException("Apps may not call setBias()");
        }

        private boolean canPersistJobs(int pid, int uid) {
            return JobSchedulerService.m4845$$Nest$mhasPermission(this.this$0, uid, pid, "android.permission.RECEIVE_BOOT_COMPLETED");
        }

        private int validateJob(JobInfo job, int callingUid, int callingPid, int sourceUserId, String sourcePkgName, JobWorkItem jobWorkItem) {
            boolean rejectNegativeNetworkEstimates = CompatChanges.isChangeEnabled(253665015, callingUid);
            job.enforceValidity(CompatChanges.isChangeEnabled(194532703, callingUid), rejectNegativeNetworkEstimates, CompatChanges.isChangeEnabled(311402873, callingUid), CompatChanges.isChangeEnabled(323349338, callingUid));
            if ((job.getFlags() & 1) == 0) goto L6;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.CONNECTIVITY_INTERNAL", "JobScheduler");
        L6:
            if ((job.getFlags() & 8) == 0) goto L15;
            if (callingUid != 1000) goto L13;
            if (job.isPeriodic() == false) goto L15;
            Slog.wtf("JobScheduler", "Periodic jobs mustn't have FLAG_EXEMPT_FROM_APP_STANDBY. Job=" + job);
            goto L15
        L13:
            throw new SecurityException("Job has invalid flags");
        L15:
            if (job.isUserInitiated() == false) goto L47;
            int sourceUid = -1;
            int sourcePid = -1;
            if (sourceUserId == (-1)) goto L22;
            if (sourcePkgName == null) goto L22;
            sourceUid = AppGlobals.getPackageManager().getPackageUid(sourcePkgName, 0, sourceUserId);     // Catch: RemoteException -> L21
        L22:
            boolean isInStateToScheduleUiJobSource = false;
            String callingPkgName = job.getService().getPackageName();
            if (sourceUid == (-1)) goto L33;
            int sourceResult = validateRunUserInitiatedJobsPermission(sourceUid, sourcePkgName);
            if (sourceResult == 1) goto L27;
            return sourceResult;
        L27:
            if (callingUid == sourceUid) goto L29;
        L32:
            isInStateToScheduleUiJobSource = isInStateToScheduleUserInitiatedJobs(sourceUid, sourcePid, sourcePkgName);
            goto L33
        L29:
            if (callingPkgName.equals(sourcePkgName) == false) goto L32;
            sourcePid = callingPid;
        L33:
            boolean isInStateToScheduleUiJobCalling = false;
            if (callingUid == sourceUid) goto L36;
        L38:
            int callingResult = validateRunUserInitiatedJobsPermission(callingUid, callingPkgName);
            if (callingResult == 1) goto L41;
            return callingResult;
        L41:
            if (isInStateToScheduleUiJobSource == true) goto L43;
            isInStateToScheduleUiJobCalling = isInStateToScheduleUserInitiatedJobs(callingUid, callingPid, callingPkgName);
        L43:
            if (isInStateToScheduleUiJobSource == true) goto L47;
            if (isInStateToScheduleUiJobCalling == true) goto L47;
            Slog.e("JobScheduler", "Uid(s) " + sourceUid + SliceClientPermissions.SliceAuthority.DELIMITER + callingUid + " not in a state to schedule user-initiated jobs");
            Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_schedule_failure_uij_invalid_state", callingUid);
            return 0;
        L36:
            if (callingPkgName.equals(sourcePkgName) == true) goto L43;
        L47:
            if (jobWorkItem == null) goto L68;
            jobWorkItem.enforceValidity(rejectNegativeNetworkEstimates);
            if (jobWorkItem.getEstimatedNetworkDownloadBytes() != (-1)) goto L55;
            if (jobWorkItem.getEstimatedNetworkUploadBytes() != (-1)) goto L55;
            if (jobWorkItem.getMinimumNetworkChunkBytes() != (-1)) goto L55;
        L62:
            if (job.isPersisted() == false) goto L68;
            if (jobWorkItem.getIntent() == null) goto L68;
            throw new IllegalArgumentException("Cannot persist JobWorkItems with Intents");
        L55:
            if (job.getRequiredNetwork() != null) goto L62;
            if (CompatChanges.isChangeEnabled(JobSchedulerService.REQUIRE_NETWORK_CONSTRAINT_FOR_NETWORK_JOB_WORK_ITEMS, callingUid) == true) goto L60;
            Slog.e("JobScheduler", "JobWorkItem implies network usage but job doesn't specify a network constraint");
            goto L62
        L60:
            throw new IllegalArgumentException("JobWorkItem implies network usage but job doesn't specify a network constraint");
        L68:
            return 1;
        }

        private String validateNamespace(String namespace) {
            String namespace2 = JobScheduler.sanitizeNamespace(namespace);
            if (namespace2 != null) goto L5;
            return namespace2;
        L5:
            if (namespace2.isEmpty() == true) goto L12;
            if (namespace2.length() > 1000) goto L10;
            return namespace2.intern();
        L10:
            throw new IllegalArgumentException("namespace cannot be more than 1000 characters");
        L12:
            throw new IllegalArgumentException("namespace cannot be empty");
        }

        private int validateRunUserInitiatedJobsPermission(int uid, String packageName) {
            int state = JobSchedulerService.m4844$$Nest$mgetRunUserInitiatedJobsPermissionState(this.this$0, uid, packageName);
            if (state != 2) goto L5;
            Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_schedule_failure_uij_no_permission", uid);
            throw new SecurityException("android.permission.RUN_USER_INITIATED_JOBS required to schedule user-initiated jobs.");
        L5:
            if (state != 1) goto L8;
            Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_schedule_failure_uij_no_permission", uid);
            return 0;
        L8:
            return 1;
        }

        private boolean isInStateToScheduleUserInitiatedJobs(int uid, int pid, String pkgName) {
            int procState = this.this$0.mActivityManagerInternal.getUidProcessState(uid);
            if (JobSchedulerService.DEBUG == false) goto L6;
            Slog.d("JobScheduler", "Uid " + uid + " proc state=" + ActivityManager.procStateToString(procState));
        L6:
            if (procState != 2) goto L9;
            return true;
        L9:
            boolean canScheduleUiJobsInBg = this.this$0.mActivityManagerInternal.canScheduleUserInitiatedJobs(uid, pid, pkgName);
            if (JobSchedulerService.DEBUG == false) goto L12;
            Slog.d("JobScheduler", "Uid " + uid + " AM.canScheduleUserInitiatedJobs= " + canScheduleUiJobsInBg);
        L12:
            return canScheduleUiJobsInBg;
        }

        public int schedule(String namespace, JobInfo job) throws RemoteException {
            if (JobSchedulerService.DEBUG == false) goto L5;
            Slog.d("JobScheduler", "Scheduling job: " + job.toString());
        L5:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(uid);
            enforceValidJobRequest(uid, pid, job);
            int result = validateJob(job, uid, pid, -1, null, null);
            if (result == 1) goto L8;
            return result;
        L8:
            String namespace2 = validateNamespace(namespace);
            JobInfo job2 = enforceBuilderApiPermissions(uid, pid, job);
            long ident = Binder.clearCallingIdentity();
            int r0 = this.this$0.scheduleAsPackage(job2, null, uid, null, userId, namespace2, null);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(ident);
            return r0;
        L14:
            th = th;
        L17:
            Binder.restoreCallingIdentity(ident);
            throw th;
        L16:
            th = th;
            goto L17
        }

        public int enqueue(String namespace, JobInfo job, JobWorkItem work) throws RemoteException {
            if (JobSchedulerService.DEBUG == false) goto L5;
            Slog.d("JobScheduler", "Enqueueing job: " + job.toString() + " work: " + work);
        L5:
            int uid = Binder.getCallingUid();
            int pid = Binder.getCallingPid();
            int userId = UserHandle.getUserId(uid);
            enforceValidJobRequest(uid, pid, job);
            if (work == null) goto L23;
            int result = validateJob(job, uid, pid, -1, null, work);
            if (result == 1) goto L10;
            return result;
        L10:
            String namespace2 = validateNamespace(namespace);
            JobInfo job2 = enforceBuilderApiPermissions(uid, pid, job);
            long ident = Binder.clearCallingIdentity();
            int r0 = this.this$0.scheduleAsPackage(job2, work, uid, null, userId, namespace2, null);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(ident);
            return r0;
        L16:
            th = th;
        L20:
            Binder.restoreCallingIdentity(ident);
            throw th;
        L18:
            th = th;
            goto L20
        L23:
            throw new NullPointerException("work is null");
        }

        public int scheduleAsPackage(String namespace, JobInfo job, String packageName, int userId, String tag) throws RemoteException {
            int callerUid = Binder.getCallingUid();
            int callerPid = Binder.getCallingPid();
            if (JobSchedulerService.DEBUG == false) goto L5;
            Slog.d("JobScheduler", "Caller uid " + callerUid + " scheduling job: " + job.toString() + " on behalf of " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER);
        L5:
            if (packageName == null) goto L21;
            int mayScheduleForOthers = this.this$0.getContext().checkCallingOrSelfPermission("android.permission.UPDATE_DEVICE_STATS");
            if (mayScheduleForOthers != 0) goto L19;
            enforceValidJobRequest(callerUid, callerPid, job);
            int result = validateJob(job, callerUid, callerPid, userId, packageName, null);
            if (result == 1) goto L11;
            return result;
        L11:
            String namespace2 = validateNamespace(namespace);
            JobInfo job2 = enforceBuilderApiPermissions(callerUid, callerPid, job);
            long ident = Binder.clearCallingIdentity();
            int r0 = this.this$0.scheduleAsPackage(job2, null, callerUid, packageName, userId, namespace2, tag);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(ident);
            return r0;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L19:
            throw new SecurityException("Caller uid " + callerUid + " not permitted to schedule jobs for other apps");
        L21:
            throw new NullPointerException("Must specify a package for scheduleAsPackage()");
        }

        public Map<String, ParceledListSlice<JobInfo>> getAllPendingJobs() throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            ArrayMap<String, List<JobInfo>> jobs = JobSchedulerService.m4842$$Nest$mgetPendingJobs(this.this$0, uid);     // Catch: Throwable -> L8
            ArrayMap<String, ParceledListSlice<JobInfo>> outMap = new ArrayMap();     // Catch: Throwable -> L8
            int i = 0;
        L5:
            if (i >= jobs.size()) goto L10;
            outMap.put(jobs.keyAt(i), new ParceledListSlice(jobs.valueAt(i)));     // Catch: Throwable -> L8
            i = i + 1;
            goto L5
        L10:
            Binder.restoreCallingIdentity(ident);
            return outMap;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public ParceledListSlice<JobInfo> getAllPendingJobsInNamespace(String namespace) throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            ParceledListSlice<JobInfo> r3 = new ParceledListSlice(JobSchedulerService.m4843$$Nest$mgetPendingJobsInNamespace(this.this$0, uid, validateNamespace(namespace)));     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public JobInfo getPendingJob(String namespace, int jobId) throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            JobInfo r3 = JobSchedulerService.m4839$$Nest$mgetPendingJob(this.this$0, uid, validateNamespace(namespace), jobId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public int getPendingJobReason(String namespace, int jobId) throws RemoteException {
            return getPendingJobReasons(validateNamespace(namespace), jobId)[0];
        }

        public int[] getPendingJobReasons(String namespace, int jobId) throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            int[] r3 = JobSchedulerService.m4840$$Nest$mgetPendingJobReasons(this.this$0, uid, validateNamespace(namespace), jobId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public List<PendingJobReasonsInfo> getPendingJobReasonsHistory(String namespace, int jobId) throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            List<PendingJobReasonsInfo> r3 = JobSchedulerService.m4841$$Nest$mgetPendingJobReasonsHistory(this.this$0, uid, validateNamespace(namespace), jobId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void cancelAll() throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            this.this$0.cancelJobsForUid(uid, false, 1, 0, "cancelAll() called by app, callingUid=" + uid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void cancelAllInNamespace(String namespace) throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            JobSchedulerService.m4835$$Nest$mcancelJobsForUid(this.this$0, uid, false, true, validateNamespace(namespace), 1, 0, "cancelAllInNamespace() called by app, callingUid=" + uid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void cancel(String namespace, int jobId) throws RemoteException {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            JobSchedulerService.m4832$$Nest$mcancelJob(this.this$0, uid, validateNamespace(namespace), jobId, uid, 1);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(ident);
            return;
        L8:
            th = move-exception;
            Throwable r10 = th;
        L12:
            Binder.restoreCallingIdentity(ident);
            throw r10;
        L10:
            th = move-exception;
            r10 = th;
            goto L12
        }

        public boolean canRunUserInitiatedJobs(String packageName) {
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            int packageUid = this.this$0.mLocalPM.getPackageUid(packageName, 0, userId);
            if (callingUid != packageUid) goto L7;
            return JobSchedulerService.m4838$$Nest$mcheckRunUserInitiatedJobsPermission(this.this$0, packageUid, packageName);
        L7:
            throw new SecurityException("Uid " + callingUid + " cannot query canRunUserInitiatedJobs for package " + packageName);
        }

        public boolean hasRunUserInitiatedJobsPermission(String packageName, int userId) {
            int uid = this.this$0.mLocalPM.getPackageUid(packageName, 0, userId);
            int callingUid = Binder.getCallingUid();
            if (callingUid == uid) goto L10;
            if (UserHandle.isCore(callingUid) == true) goto L10;
            throw new SecurityException("Uid " + callingUid + " cannot query hasRunUserInitiatedJobsPermission for package " + packageName);
        L10:
            return JobSchedulerService.m4838$$Nest$mcheckRunUserInitiatedJobsPermission(this.this$0, uid, packageName);
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.getContext(), "JobScheduler", pw) == true) goto L5;
            return;
        L5:
            int filterUid = -1;
            boolean proto = false;
            if (ArrayUtils.isEmpty(args) == true) goto L35;
            int opti = 0;
        L9:
            if (opti >= args.length) goto L28;
            String arg = args[opti];
            if ("-h".equals(arg) == true) goto L12;
            if ("-a".equals(arg) == true) goto L20;
            if ("--proto".equals(arg) == false) goto L22;
            proto = true;
            goto L20
        L22:
            if (arg.length() <= 0) goto L28;
            if (arg.charAt(0) != '-') goto L28;
            pw.println("Unknown option: " + arg);
            return;
        L20:
            opti = opti + 1;
            goto L9
        L12:
            JobSchedulerService.dumpHelp(pw);
            return;
        L28:
            if (opti >= args.length) goto L35;
            String pkg = args[opti];
            filterUid = this.this$0.getContext().getPackageManager().getPackageUid(pkg, 4194304);     // Catch: PackageManager.NameNotFoundException -> L32
        L33:
            pw.println("Invalid package: " + pkg);
            return;
        L35:
            long identityToken = Binder.clearCallingIdentity();
            if (proto == false) goto L40;
            this.this$0.dumpInternalProto(fd, filterUid);     // Catch: Throwable -> L38
        L41:
            Binder.restoreCallingIdentity(identityToken);
            return;
        L40:
            this.this$0.dumpInternal(new IndentingPrintWriter(pw, "  "), filterUid);     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            Binder.restoreCallingIdentity(identityToken);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
            return new JobSchedulerShellCommand(this.this$0).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
        }

        public List<JobInfo> getStartedJobs() {
            int uid = Binder.getCallingUid();
            if (uid != 1000) goto L20;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            ArraySet<JobStatus> runningJobStatuses = this.this$0.mConcurrencyManager.getRunningJobsLocked();     // Catch: Throwable -> L11
            ArrayList<JobInfo> runningJobs = new ArrayList(runningJobStatuses.size());     // Catch: Throwable -> L11
            int i = runningJobStatuses.size() - 1;     // Catch: Throwable -> L11
        L7:
            if (i < 0) goto L15;
            JobStatus job = runningJobStatuses.valueAt(i);     // Catch: Throwable -> L11
            if (job == null) goto L13;
            runningJobs.add(job.getJob());     // Catch: Throwable -> L11
        L13:
            i = i - 1;     // Catch: Throwable -> L11
            goto L7
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return runningJobs;
        L11:
            th = move-exception;
            throw th;
        L20:
            throw new SecurityException("getStartedJobs() is system internal use only.");
        }

        public ParceledListSlice<JobSnapshot> getAllJobSnapshots() {
            int uid = Binder.getCallingUid();
            if (uid != 1000) goto L13;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            final ArrayList<JobSnapshot> snapshots = new ArrayList(this.this$0.mJobs.size());     // Catch: Throwable -> L9
            this.this$0.mJobs.forEachJob(new JobSchedulerService$JobSchedulerStub$$ExternalSyntheticLambda0(this, snapshots));     // Catch: Throwable -> L9
            ParceledListSlice<JobSnapshot> r3 = new ParceledListSlice(snapshots);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return r3;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new SecurityException("getAllJobSnapshots() is system internal use only.");
        }

        private /* synthetic */ void lambda$getAllJobSnapshots$0(ArrayList snapshots, JobStatus job) {
            snapshots.add(new JobSnapshot(job.getJob(), job.getSatisfiedConstraintFlags(), this.this$0.isReadyToBeExecutedLocked(job)));
        }

        public void registerUserVisibleJobObserver(IUserVisibleJobObserver observer) {
            super.registerUserVisibleJobObserver_enforcePermission();
            if (observer == null) goto L7;
            JobSchedulerService.m4831$$Nest$fgetmUserVisibleJobObservers(this.this$0).register(observer);
            this.this$0.mHandler.obtainMessage(10, observer).sendToTarget();
            return;
        L7:
            throw new NullPointerException("observer");
        }

        public void unregisterUserVisibleJobObserver(IUserVisibleJobObserver observer) {
            super.unregisterUserVisibleJobObserver_enforcePermission();
            if (observer == null) goto L7;
            JobSchedulerService.m4831$$Nest$fgetmUserVisibleJobObservers(this.this$0).unregister(observer);
            return;
        L7:
            throw new NullPointerException("observer");
        }

        public void notePendingUserRequestedAppStop(String packageName, int userId, String debugReason) {
            super.notePendingUserRequestedAppStop_enforcePermission();
            if (packageName == null) goto L7;
            this.this$0.notePendingUserRequestedAppStopInternal(packageName, userId, debugReason);
            return;
        L7:
            throw new NullPointerException("packageName");
        }
    }

    final class LocalService implements JobSchedulerInternal {
        final /* synthetic */ JobSchedulerService this$0;

        public static /* synthetic */ void $r8$lambda$8dEW4zqTPOecQlZk_ZT8qUk48Xw(String r0, List r1, JobStatus r2) {
            lambda$getSystemScheduledOwnJobs$0(r0, r1, r2);
        }

        LocalService(JobSchedulerService this$0) {
            this.this$0 = this$0;
        }

        public List<JobInfo> getSystemScheduledOwnJobs(final String namespace) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            final List<JobInfo> ownJobs = new ArrayList();     // Catch: Throwable -> L7
            this.this$0.mJobs.forEachJob(1000, new JobSchedulerService$LocalService$$ExternalSyntheticLambda0(namespace, ownJobs));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return ownJobs;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$getSystemScheduledOwnJobs$0(String namespace, List ownJobs, JobStatus job) {
            if (job.getSourceUid() == 1000) goto L5;
            return;
        L5:
            if (Objects.equals(job.getNamespace(), namespace) == true) goto L7;
            return;
        L7:
            if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(job.getSourcePackageName()) == false) goto L12;
            ownJobs.add(job.getJob());
            return;
        }

        public void initResourceCtrl(Map<String, Pair<Integer, Integer>> map, List<String> list) {
            if (this.this$0.mObricJobResourceController == null) goto L6;
            this.this$0.mObricJobResourceController.initResourceCtrl(map, list);
            return;
        }

        public void handleUpdateResourceState(int key, String value) {
            if (this.this$0.mObricJobResourceController == null) goto L6;
            this.this$0.mObricJobResourceController.handleBitState(key, value);
            return;
        }

        public void cancelJobsForUid(int uid, boolean includeProxiedJobs, int reason, int internalReasonCode, String debugReason) {
            this.this$0.cancelJobsForUid(uid, includeProxiedJobs, reason, internalReasonCode, debugReason);
        }

        public void addBackingUpUid(int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            JobSchedulerService.m4816$$Nest$fgetmBackingUpUids(this.this$0).put(uid, true);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeBackingUpUid(int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            JobSchedulerService.m4816$$Nest$fgetmBackingUpUids(this.this$0).delete(uid);     // Catch: Throwable -> L7
            if (this.this$0.mJobs.countJobsForUid(uid) <= 0) goto L9;
            this.this$0.mHandler.obtainMessage(1).sendToTarget();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void clearAllBackingUpUids() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (JobSchedulerService.m4816$$Nest$fgetmBackingUpUids(this.this$0).size() <= 0) goto L9;
            JobSchedulerService.m4816$$Nest$fgetmBackingUpUids(this.this$0).clear();     // Catch: Throwable -> L7
            this.this$0.mHandler.obtainMessage(1).sendToTarget();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public String getCloudMediaProviderPackage(int userId) {
            return (String) JobSchedulerService.m4819$$Nest$fgetmCloudMediaProviderPackages(this.this$0).get(userId);
        }

        public void reportAppUsage(String packageName, int userId) {
            this.this$0.reportAppUsage(packageName, userId);
        }

        public boolean isAppConsideredBuggy(int callingUserId, String callingPackageName, int timeoutBlameUserId, String timeoutBlamePackageName) {
            if (JobSchedulerService.m4827$$Nest$fgetmQuotaTracker(this.this$0).isWithinQuota(callingUserId, callingPackageName, JobSchedulerService.QUOTA_TRACKER_ANR_TAG) == true) goto L5;
        L10:
            return true;
        L5:
            if (JobSchedulerService.m4827$$Nest$fgetmQuotaTracker(this.this$0).isWithinQuota(callingUserId, callingPackageName, JobSchedulerService.QUOTA_TRACKER_SCHEDULE_PERSISTED_TAG) == false) goto L10;
            if (JobSchedulerService.m4827$$Nest$fgetmQuotaTracker(this.this$0).isWithinQuota(timeoutBlameUserId, timeoutBlamePackageName, JobSchedulerService.QUOTA_TRACKER_TIMEOUT_TOTAL_TAG) == false) goto L10;
            return false;
        }

        public boolean isNotificationAssociatedWithAnyUserInitiatedJobs(int notificationId, int userId, String packageName) {
            if (packageName != null) goto L6;
            return false;
        L6:
            return this.this$0.mConcurrencyManager.isNotificationAssociatedWithAnyUserInitiatedJobs(notificationId, userId, packageName);
        }

        public boolean isNotificationChannelAssociatedWithAnyUserInitiatedJobs(String notificationChannel, int userId, String packageName) {
            if (packageName == null) goto L7;
            if (notificationChannel != null) goto L6;
            return false;
        L6:
            return this.this$0.mConcurrencyManager.isNotificationChannelAssociatedWithAnyUserInitiatedJobs(notificationChannel, userId, packageName);
        L7:
            return false;
        }

        public JobSchedulerInternal.JobStorePersistStats getPersistStats() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            JobSchedulerInternal.JobStorePersistStats r1 = new JobSchedulerInternal.JobStorePersistStats(this.this$0.mJobs.getPersistStats());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class MaybeReadyJobQueueFunctor implements Consumer<JobStatus> {
        final ArrayMap<Network, ArraySet<JobStatus>> mBatches;
        final ArrayMap<Network, Integer> mUnbatchedJobCount;
        final ArraySet<JobStatus> mUnbatchedJobs;
        final List<JobStatus> runnableJobs;
        final /* synthetic */ JobSchedulerService this$0;

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(JobStatus r1) {
            accept2(r1);
        }

        public MaybeReadyJobQueueFunctor(JobSchedulerService this$0) {
            this.this$0 = this$0;
            this.mBatches = new ArrayMap();
            this.runnableJobs = new ArrayList();
            this.mUnbatchedJobs = new ArraySet();
            this.mUnbatchedJobCount = new ArrayMap();
            reset();
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(JobStatus job) {
            boolean isRunning = this.this$0.isCurrentlyRunningLocked(job);
            int r4 = 0;
            if (this.this$0.isReadyToBeExecutedLocked(job, false) == true) goto L5;
            if (isRunning == false) goto L91;
            if (job.isReady() == false) goto L79;
            JobRestriction restriction = this.this$0.checkIfRestricted(job);
            if (restriction == null) goto L87;
            int internalStopReason = restriction.getInternalReason();
            int internalStopReason2 = internalStopReason;
            String debugReason = "restricted due to " + JobParameters.getInternalReasonCodeDescription(internalStopReason);
        L88:
            this.this$0.mConcurrencyManager.stopJobOnServiceContextLocked(job, job.getStopReason(), internalStopReason2, debugReason);
            return;
        L87:
            internalStopReason2 = -1;
            debugReason = "couldn't figure out why the job should stop running";
            goto L88
        L79:
            if (job.getEffectiveStandbyBucket() == 5) goto L81;
        L83:
            internalStopReason2 = 1;
            debugReason = "cancelled due to unsatisfied constraints";
            goto L88
        L81:
            if (job.getStopReason() != 12) goto L83;
            internalStopReason2 = 6;
            debugReason = "cancelled due to restricted bucket";
            goto L88
        L91:
            if (JobSchedulerService.m4823$$Nest$fgetmPendingJobQueue(this.this$0).remove(job) == false) goto L100;
            JobSchedulerService.m4847$$Nest$mnoteJobNonPending(this.this$0, job);
            return;
        L100:
            return;
        L5:
            if (this.this$0.mActivityManagerInternal.isAppStartModeDisabled(job.getUid(), job.getJob().getService().getPackageName()) == false) goto L14;
            Slog.w("JobScheduler", "Aborting job " + job.getUid() + ":" + job.getJob().toString() + " -- package not allowed to start");
            if (isRunning == false) goto L10;
            this.this$0.mHandler.obtainMessage(2, 11, 0, job).sendToTarget();
            return;
        L10:
            if (JobSchedulerService.m4823$$Nest$fgetmPendingJobQueue(this.this$0).remove(job) == false) goto L95;
            JobSchedulerService.m4847$$Nest$mnoteJobNonPending(this.this$0, job);
            return;
        L95:
            return;
        L14:
            if (job.overrideState <= 0) goto L16;
            int r3 = 0;
            r4 = 0;
        L61:
            ArraySet<JobStatus> batch = this.mBatches.get(null);
            if (batch != null) goto L64;
            batch = new ArraySet();
            this.mBatches.put(null, batch);
        L64:
            batch.add(job);
            if (r3 != 0) goto L67;
            this.mUnbatchedJobCount.put(null, Integer.valueOf(this.mUnbatchedJobCount.getOrDefault(job.network, Integer.valueOf(r4)).intValue() + 1));
        L70:
            if (isRunning == true) goto L97;
            this.runnableJobs.add(job);
            if (r3 != 0) goto L98;
            this.mUnbatchedJobs.add(job);
            return;
        L98:
            return;
        L97:
            return;
        L67:
            if (job.getFirstForceBatchedTimeElapsed() != 0) goto L70;
            job.setFirstForceBatchedTimeElapsed(JobSchedulerService.sElapsedRealtimeClock.millis());
            goto L70
        L16:
            boolean shouldForceBatchJob = job.shouldTreatAsExpeditedJob();
            if (shouldForceBatchJob == true) goto L60;
            if (job.shouldTreatAsUserInitiatedJob() == true) goto L60;
            if (job.getEffectiveStandbyBucket() != 5) goto L25;
            r3 = 1;
            r4 = 0;
            goto L61
        L25:
            if (job.getJob().isPrefetch() == false) goto L32;
            long relativelySoonCutoffTime = JobSchedulerService.sSystemClock.millis() + this.this$0.mConstants.PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS;
            if (JobSchedulerService.m4826$$Nest$fgetmPrefetchController(this.this$0).getNextEstimatedLaunchTimeLocked(job) <= relativelySoonCutoffTime) goto L29;
            r3 = 1;
        L30:
            r4 = 0;
            goto L61
        L29:
            r3 = 0;
            goto L30
        L32:
            if (job.getNumPreviousAttempts() <= 0) goto L34;
            r3 = 0;
            r4 = 0;
            goto L61
        L34:
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
            if (job.hasDeadlineConstraint() == false) goto L39;
            long r11 = job.getLatestRunTimeElapsed() - nowElapsed;
        L39:
            if (this.this$0.mConstants.MIN_READY_NON_ACTIVE_JOBS_COUNT > 1) goto L41;
        L43:
            boolean batchingEnabled = false;
        L45:
            if (job.getFirstForceBatchedTimeElapsed() <= 0) goto L49;
            r4 = 0;
            if ((nowElapsed - job.getFirstForceBatchedTimeElapsed()) < this.this$0.mConstants.MAX_NON_ACTIVE_JOB_BATCH_DELAY_MS) goto L50;
            int r5 = 1;
        L52:
            if (batchingEnabled == true) goto L54;
        L57:
            int r6 = r4;
        L58:
            r3 = r6;
            goto L61
        L54:
            if (job.getEffectiveStandbyBucket() == 6) goto L57;
            if (r5 != 0) goto L57;
            r6 = 1;
        L50:
            r5 = r4;
            goto L52
        L49:
            r4 = 0;
            goto L50
        L41:
            if (job.getEffectiveStandbyBucket() == 0) goto L43;
            batchingEnabled = true;
        L60:
            r3 = 0;
            goto L61
        }

        void postProcessLocked() {
            ArraySet<JobStatus> jobsToRun = this.mUnbatchedJobs;
            if (JobSchedulerService.DEBUG == false) goto L5;
            Slog.d("JobScheduler", "maybeQueueReadyJobsForExecutionLocked: " + this.mUnbatchedJobs.size() + " unbatched jobs.");
        L5:
            int unbatchedCount = 0;
            int n = this.mBatches.size();
        L6:
            n = n - 1;
            int unbatchedJobCount = 0;
            if (n < 0) goto L33;
            Network network = this.mBatches.keyAt(n);
            Integer unbatchedJobCountObj = this.mUnbatchedJobCount.get(network);
            if (unbatchedJobCountObj == null) goto L11;
            int unbatchedJobCount2 = unbatchedJobCountObj.intValue();
            unbatchedCount = unbatchedCount + unbatchedJobCount2;
        L12:
            if (network == null) goto L6;
            ArraySet<JobStatus> batchedJobs = this.mBatches.valueAt(n);
            if (unbatchedJobCount2 > 0) goto L17;
            NetworkCapabilities networkCapabilities = JobSchedulerService.m4820$$Nest$fgetmConnectivityController(this.this$0).getNetworkCapabilities(network);
            if (networkCapabilities != null) goto L23;
            Slog.e("JobScheduler", "Couldn't get NetworkCapabilities for network " + network);
            goto L6
        L23:
            int[] transports = networkCapabilities.getTransportTypes();
            int maxNetworkBatchReq = 1;
            int r11 = transports.length;
        L24:
            if (unbatchedJobCount >= r11) goto L27;
            int transport = transports[unbatchedJobCount];
            maxNetworkBatchReq = Math.max(maxNetworkBatchReq, this.this$0.mConstants.CONN_TRANSPORT_BATCH_THRESHOLD.get(transport));
            unbatchedJobCount = unbatchedJobCount + 1;
            goto L24
        L27:
            if (batchedJobs.size() < maxNetworkBatchReq) goto L6;
            if (JobSchedulerService.DEBUG == false) goto L31;
            Slog.d("JobScheduler", "maybeQueueReadyJobsForExecutionLocked: " + batchedJobs.size() + " batched network jobs meet requirement for " + network);
        L31:
            jobsToRun.addAll(batchedJobs);
            goto L6
        L17:
            if (JobSchedulerService.DEBUG == false) goto L19;
            Slog.d("JobScheduler", "maybeQueueReadyJobsForExecutionLocked: piggybacking " + (batchedJobs.size() - unbatchedJobCount2) + " jobs on " + network + " because of unbatched job");
        L19:
            jobsToRun.addAll(batchedJobs);
            goto L6
        L11:
            unbatchedJobCount2 = 0;
            goto L12
        L33:
            ArraySet<JobStatus> batchedNonNetworkedJobs = this.mBatches.get(null);
            if (batchedNonNetworkedJobs == null) goto L51;
            int minReadyCount = this.this$0.mConstants.MIN_READY_NON_ACTIVE_JOBS_COUNT;
            if (jobsToRun.size() <= 0) goto L46;
            if (JobSchedulerService.DEBUG == false) goto L44;
            Integer unbatchedJobCountObj2 = this.mUnbatchedJobCount.get(null);
            if (unbatchedJobCountObj2 == null) goto L43;
            unbatchedJobCount = unbatchedJobCountObj2.intValue();
        L43:
            Slog.d("JobScheduler", "maybeQueueReadyJobsForExecutionLocked: piggybacking " + (batchedNonNetworkedJobs.size() - unbatchedJobCount) + " non-network jobs");
        L44:
            jobsToRun.addAll(batchedNonNetworkedJobs);
            goto L51
        L46:
            if (batchedNonNetworkedJobs.size() < minReadyCount) goto L51;
            if (JobSchedulerService.DEBUG == false) goto L50;
            Slog.d("JobScheduler", "maybeQueueReadyJobsForExecutionLocked: adding " + batchedNonNetworkedJobs.size() + " batched non-network jobs.");
        L50:
            jobsToRun.addAll(batchedNonNetworkedJobs);
        L51:
            final JobSchedulerService r3 = this.this$0;
            jobsToRun.removeIf(new JobSchedulerService$MaybeReadyJobQueueFunctor$$ExternalSyntheticLambda0(r3));
            if (unbatchedCount > 0) goto L60;
            if (jobsToRun.size() > 0) goto L60;
            if (JobSchedulerService.DEBUG == false) goto L63;
            Slog.d("JobScheduler", "maybeQueueReadyJobsForExecutionLocked: Not running anything.");
        L63:
            int numRunnableJobs = this.runnableJobs.size();
            if (numRunnableJobs > 0) goto L66;
        L86:
            reset();
            return;
        L66:
            if (numRunnableJobs == jobsToRun.size()) goto L86;
            SparseArrayMap r4 = JobSchedulerService.m4824$$Nest$fgetmPendingJobReasonsCache(this.this$0);
            monitor-enter(r4);
            int i = 0;
        L70:
            if (i >= numRunnableJobs) goto L82;
            JobStatus job = this.runnableJobs.get(i);     // Catch: Throwable -> L77
            if (jobsToRun.contains(job) == true) goto L80;
            SparseArray<int[]> reasons = (SparseArray) JobSchedulerService.m4824$$Nest$fgetmPendingJobReasonsCache(this.this$0).get(job.getUid(), job.getNamespace());     // Catch: Throwable -> L77
            if (reasons != null) goto L79;
            reasons = new SparseArray();     // Catch: Throwable -> L77
            JobSchedulerService.m4824$$Nest$fgetmPendingJobReasonsCache(this.this$0).add(job.getUid(), job.getNamespace(), reasons);     // Catch: Throwable -> L77
        L79:
            reasons.put(job.getJobId(), new int[]{13});     // Catch: Throwable -> L77
        L80:
            i = i + 1;     // Catch: Throwable -> L77
        L77:
            th = move-exception;
            throw th;
        L82:
            monitor-exit(r4);     // Catch: Throwable -> L77
        L60:
            if (JobSchedulerService.DEBUG == false) goto L62;
            Slog.d("JobScheduler", "maybeQueueReadyJobsForExecutionLocked: Running " + jobsToRun + " jobs.");
        L62:
            this.this$0.noteJobsPending(jobsToRun);
            JobSchedulerService.m4823$$Nest$fgetmPendingJobQueue(this.this$0).addAll(jobsToRun);
            goto L63
        }

        void reset() {
            this.runnableJobs.clear();
            this.mBatches.clear();
            this.mUnbatchedJobs.clear();
            this.mUnbatchedJobCount.clear();
        }
    }

    private static abstract class MySimpleClock extends Clock {
        private final ZoneId mZoneId;

        @Override // java.time.Clock, java.time.InstantSource
        public abstract long millis();

        MySimpleClock(ZoneId zoneId) {
            this.mZoneId = zoneId;
        }

        @Override // java.time.Clock
        public ZoneId getZone() {
            return this.mZoneId;
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Clock withZone(final ZoneId zone) {
            return new AnonymousClass1(this, zone);
        }

        @Override // java.time.Clock, java.time.InstantSource
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }
    }

    final class ReadyJobQueueFunctor implements Consumer<JobStatus> {
        final ArraySet<JobStatus> newReadyJobs;
        final /* synthetic */ JobSchedulerService this$0;

        /* JADX INFO: renamed from: -$$Nest$mpostProcessLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4862$$Nest$mpostProcessLocked(ReadyJobQueueFunctor r0) {
            r0.postProcessLocked();
        }

        ReadyJobQueueFunctor(JobSchedulerService this$0) {
            this.this$0 = this$0;
            this.newReadyJobs = new ArraySet();
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(JobStatus r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(JobStatus job) {
            if (this.this$0.isReadyToBeExecutedLocked(job) == true) goto L5;
            return;
        L5:
            if (JobSchedulerService.DEBUG == false) goto L7;
            Slog.d("JobScheduler", "    queued " + job.toShortString());
        L7:
            this.newReadyJobs.add(job);
        }

        private void postProcessLocked() {
            this.this$0.noteJobsPending(this.newReadyJobs);
            JobSchedulerService.m4823$$Nest$fgetmPendingJobQueue(this.this$0).addAll(this.newReadyJobs);
            this.newReadyJobs.clear();
        }
    }

    final class StandbyTracker extends AppStandbyInternal.AppIdleStateChangeListener {
        final /* synthetic */ JobSchedulerService this$0;

        StandbyTracker(JobSchedulerService this$0) {
            this.this$0 = this$0;
        }

        public void onAppIdleStateChanged(String packageName, int userId, boolean idle, int bucket, int reason) {
        }

        public void onUserInteractionStarted(String packageName, int userId) {
            int uid = this.this$0.mLocalPM.getPackageUid(packageName, 8192, userId);
            if (uid >= 0) goto L5;
            return;
        L5:
            long sinceLast = JobSchedulerService.sUsageStatsManagerInternal.getTimeSinceLastJobRun(packageName, userId);
            if (sinceLast <= 172800000) goto L8;
            long sinceLast2 = 0;
        L9:
            DeferredJobCounter counter = new DeferredJobCounter();
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            this.this$0.mJobs.forEachJobForSourceUid(uid, counter);     // Catch: Throwable -> L19
            monitor-exit(r2);     // Catch: Throwable -> L19
            if (counter.numDeferred() <= 0) goto L16;
        L17:
            JobSchedulerService.m4817$$Nest$fgetmBatteryStatsInternal(this.this$0).noteJobsDeferred(uid, counter.numDeferred(), sinceLast2);
            FrameworkStatsLog.write_non_chained(85, uid, null, counter.numDeferred(), sinceLast2);
            return;
        L16:
            if (sinceLast2 > 0) goto L17;
            return;
        L19:
            th = move-exception;
            throw th;
        L8:
            sinceLast2 = sinceLast;
            goto L9
        }
    }

    public static /* synthetic */ void $r8$lambda$2PWLLojenEoUVtVczAkQEiEcXT4(int r0, JobStatus r1, CountDownLatch r2, Handler r3, long r4) {
        lambda$checkConstraintRunnableForTesting$8(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$3U3vQgA2VmCzhfx3x77hvFjIh-g, reason: not valid java name */
    public static /* synthetic */ boolean m4812$r8$lambda$3U3vQgA2VmCzhfx3x77hvFjIhg(int r0, JobStatus r1) {
        return lambda$dumpInternalProto$10(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$EoOP1iqUWtKpr-nlVcT2lpIByWE, reason: not valid java name */
    public static /* synthetic */ boolean m4813$r8$lambda$EoOP1iqUWtKprnlVcT2lpIByWE(int r0, JobStatus r1) {
        return lambda$cancelJobsForUserLocked$1(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$JaDLrweKec7z55BBNRKa011oxl4(int r0, JobStatus r1) {
        return lambda$dumpInternal$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JjXiqpzW7ZRIZrywIAdtF0btMiE(JobSchedulerService r0, JobStatus r1) {
        r0.lambda$updateMediaBackupExemptionLocked$7(r1);
    }

    public static /* synthetic */ Category $r8$lambda$Q16HuucOPC3Nu2dDmrkdR058M08(JobSchedulerService r0, int r1, String r2, String r3) {
        return r0.lambda$new$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$TkIFiBnkkUUxdHLTB9ncTCF06WQ(JobSchedulerService r0, JobStatus r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$Ulq0lH6hWnerIiBupp3Llq6NoQA(JobSchedulerService r0, JobStatus r1) {
        r0.lambda$onBootPhase$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$_qsiROTbT1bHvhwbOpkod1sMBXE(JobSchedulerService r0) {
        r0.lambda$startControllerTrackingAsync$5();
    }

    /* JADX INFO: renamed from: $r8$lambda$kFq7qP-VcLL1Ltl-JO7FUKK_Zis, reason: not valid java name */
    public static /* synthetic */ boolean m4814$r8$lambda$kFq7qPVcLL1LtlJO7FUKK_Zis(JobSchedulerService r0, int r1) {
        return r0.isUidActive(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$sgF_JvJm-bvZP1qO91Stw_yEhBo, reason: not valid java name */
    public static /* synthetic */ void m4815$r8$lambda$sgF_JvJmbvZP1qO91Stw_yEhBo(JobSchedulerService r0) {
        r0.lambda$new$3();
    }

    public static /* synthetic */ boolean $r8$lambda$wLeviKUONkz7j6ey7Yx2IYF6OPU(int r0, String r1, String r2, JobStatus r3) {
        return lambda$updateMediaBackupExemptionLocked$6(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackingUpUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m4816$$Nest$fgetmBackingUpUids(JobSchedulerService r0) {
        return r0.mBackingUpUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryStatsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryStatsInternal m4817$$Nest$fgetmBatteryStatsInternal(JobSchedulerService r0) {
        return r0.mBatteryStatsInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChangedJobList, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m4818$$Nest$fgetmChangedJobList(JobSchedulerService r0) {
        return r0.mChangedJobList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCloudMediaProviderPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4819$$Nest$fgetmCloudMediaProviderPackages(JobSchedulerService r0) {
        return r0.mCloudMediaProviderPackages;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnectivityController, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConnectivityController m4820$$Nest$fgetmConnectivityController(JobSchedulerService r0) {
        return r0.mConnectivityController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceIdleJobsController, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceIdleJobsController m4821$$Nest$fgetmDeviceIdleJobsController(JobSchedulerService r0) {
        return r0.mDeviceIdleJobsController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmJobTimeUpdater, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m4822$$Nest$fgetmJobTimeUpdater(JobSchedulerService r0) {
        return r0.mJobTimeUpdater;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingJobQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingJobQueue m4823$$Nest$fgetmPendingJobQueue(JobSchedulerService r0) {
        return r0.mPendingJobQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingJobReasonsCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m4824$$Nest$fgetmPendingJobReasonsCache(JobSchedulerService r0) {
        return r0.mPendingJobReasonsCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m4825$$Nest$fgetmPermissionCache(JobSchedulerService r0) {
        return r0.mPermissionCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrefetchController, reason: not valid java name */
    static /* bridge */ /* synthetic */ PrefetchController m4826$$Nest$fgetmPrefetchController(JobSchedulerService r0) {
        return r0.mPrefetchController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQuotaTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountQuotaTracker m4827$$Nest$fgetmQuotaTracker(JobSchedulerService r0) {
        return r0.mQuotaTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidCapabilities, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m4828$$Nest$fgetmUidCapabilities(JobSchedulerService r0) {
        return r0.mUidCapabilities;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidProcStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m4829$$Nest$fgetmUidProcStates(JobSchedulerService r0) {
        return r0.mUidProcStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidToPackageCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseSetArray m4830$$Nest$fgetmUidToPackageCache(JobSchedulerService r0) {
        return r0.mUidToPackageCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserVisibleJobObservers, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m4831$$Nest$fgetmUserVisibleJobObservers(JobSchedulerService r0) {
        return r0.mUserVisibleJobObservers;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelJob, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4832$$Nest$mcancelJob(JobSchedulerService r0, int r1, String r2, int r3, int r4, int r5) {
        return r0.cancelJob(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelJobImplLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4833$$Nest$mcancelJobImplLocked(JobSchedulerService r0, JobStatus r1, JobStatus r2, int r3, int r4, String r5) {
        r0.cancelJobImplLocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelJobsForPackageAndUidLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4834$$Nest$mcancelJobsForPackageAndUidLocked(JobSchedulerService r0, String r1, int r2, boolean r3, boolean r4, int r5, int r6, String r7) {
        r0.cancelJobsForPackageAndUidLocked(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelJobsForUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4835$$Nest$mcancelJobsForUid(JobSchedulerService r0, int r1, boolean r2, boolean r3, String r4, int r5, int r6, String r7) {
        return r0.cancelJobsForUid(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelJobsForUserLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4836$$Nest$mcancelJobsForUserLocked(JobSchedulerService r0, int r1) {
        r0.cancelJobsForUserLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckChangedJobListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4837$$Nest$mcheckChangedJobListLocked(JobSchedulerService r0) {
        r0.checkChangedJobListLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckRunUserInitiatedJobsPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4838$$Nest$mcheckRunUserInitiatedJobsPermission(JobSchedulerService r0, int r1, String r2) {
        return r0.checkRunUserInitiatedJobsPermission(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPendingJob, reason: not valid java name */
    static /* bridge */ /* synthetic */ JobInfo m4839$$Nest$mgetPendingJob(JobSchedulerService r0, int r1, String r2, int r3) {
        return r0.getPendingJob(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPendingJobReasons, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m4840$$Nest$mgetPendingJobReasons(JobSchedulerService r0, int r1, String r2, int r3) {
        return r0.getPendingJobReasons(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPendingJobReasonsHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4841$$Nest$mgetPendingJobReasonsHistory(JobSchedulerService r0, int r1, String r2, int r3) {
        return r0.getPendingJobReasonsHistory(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPendingJobs, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m4842$$Nest$mgetPendingJobs(JobSchedulerService r0, int r1) {
        return r0.getPendingJobs(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPendingJobsInNamespace, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4843$$Nest$mgetPendingJobsInNamespace(JobSchedulerService r0, int r1, String r2) {
        return r0.getPendingJobsInNamespace(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRunUserInitiatedJobsPermissionState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4844$$Nest$mgetRunUserInitiatedJobsPermissionState(JobSchedulerService r0, int r1, String r2) {
        return r0.getRunUserInitiatedJobsPermissionState(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4845$$Nest$mhasPermission(JobSchedulerService r0, int r1, int r2, String r3) {
        return r0.hasPermission(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeQueueReadyJobsForExecutionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4846$$Nest$mmaybeQueueReadyJobsForExecutionLocked(JobSchedulerService r0) {
        r0.maybeQueueReadyJobsForExecutionLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mnoteJobNonPending, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4847$$Nest$mnoteJobNonPending(JobSchedulerService r0, JobStatus r1) {
        r0.noteJobNonPending(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mqueueReadyJobsForExecutionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4848$$Nest$mqueueReadyJobsForExecutionLocked(JobSchedulerService r0) {
        r0.queueReadyJobsForExecutionLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMediaBackupExemptionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4849$$Nest$mupdateMediaBackupExemptionLocked(JobSchedulerService r0, int r1, String r2, String r3) {
        r0.updateMediaBackupExemptionLocked(r1, r2, r3);
    }

    static {
        DEBUG = Log.isLoggable("JobScheduler", 3);
        if (DEBUG == true) goto L5;
        boolean r0 = false;
    L6:
        DEBUG_STANDBY = r0;
        sSystemClock = Clock.systemUTC();
        final ZoneOffset r2 = ZoneOffset.UTC;
        sUptimeMillisClock = new AnonymousClass1(r2);
        final ZoneOffset r3 = ZoneOffset.UTC;
        sElapsedRealtimeClock = new AnonymousClass2(r3);
        QUOTA_TRACKER_CATEGORY_SCHEDULE_PERSISTED = new Category(QUOTA_TRACKER_SCHEDULE_PERSISTED_TAG);
        QUOTA_TRACKER_CATEGORY_SCHEDULE_LOGGED = new Category(QUOTA_TRACKER_SCHEDULE_LOGGED);
        QUOTA_TRACKER_CATEGORY_TIMEOUT_UIJ = new Category(QUOTA_TRACKER_TIMEOUT_UIJ_TAG);
        QUOTA_TRACKER_CATEGORY_TIMEOUT_EJ = new Category(QUOTA_TRACKER_TIMEOUT_EJ_TAG);
        QUOTA_TRACKER_CATEGORY_TIMEOUT_REG = new Category(QUOTA_TRACKER_TIMEOUT_REG_TAG);
        QUOTA_TRACKER_CATEGORY_TIMEOUT_TOTAL = new Category(QUOTA_TRACKER_TIMEOUT_TOTAL_TAG);
        QUOTA_TRACKER_CATEGORY_ANR = new Category(QUOTA_TRACKER_ANR_TAG);
        QUOTA_TRACKER_CATEGORY_DISABLED = new Category(ServiceConfigAccessor.PROVIDER_MODE_DISABLED);
        sEnqueuedJwiHighWaterMarkLogger = new Histogram("job_scheduler.value_hist_w_uid_enqueued_work_items_high_water_mark", new Histogram.ScaledRangeOptions(25, 0, 5.0f, 1.4f));
        sInitialJobEstimatedNetworkDownloadKBLogger = new Histogram("job_scheduler.value_hist_initial_job_estimated_network_download_kilobytes", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        sInitialJwiEstimatedNetworkDownloadKBLogger = new Histogram("job_scheduler.value_hist_initial_jwi_estimated_network_download_kilobytes", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        sInitialJobEstimatedNetworkUploadKBLogger = new Histogram("job_scheduler.value_hist_initial_job_estimated_network_upload_kilobytes", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        sInitialJwiEstimatedNetworkUploadKBLogger = new Histogram("job_scheduler.value_hist_initial_jwi_estimated_network_upload_kilobytes", new Histogram.ScaledRangeOptions(50, 0, 32.0f, 1.31f));
        sJobMinimumChunkKBLogger = new Histogram("job_scheduler.value_hist_w_uid_job_minimum_chunk_kilobytes", new Histogram.ScaledRangeOptions(25, 0, 5.0f, 1.76f));
        sJwiMinimumChunkKBLogger = new Histogram("job_scheduler.value_hist_w_uid_jwi_minimum_chunk_kilobytes", new Histogram.ScaledRangeOptions(25, 0, 5.0f, 1.76f));
        return;
    L5:
        r0 = true;
        goto L6
    }

    void updateQuotaTracker() {
        CountQuotaTracker r0 = this.mQuotaTracker;
        if (this.mConstants.ENABLE_API_QUOTAS == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        r0.setEnabled(r1);
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_SCHEDULE_PERSISTED, this.mConstants.API_QUOTA_SCHEDULE_COUNT, this.mConstants.API_QUOTA_SCHEDULE_WINDOW_MS);
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_TIMEOUT_UIJ, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_UIJ_COUNT, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS);
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_TIMEOUT_EJ, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_EJ_COUNT, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS);
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_TIMEOUT_REG, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_REG_COUNT, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS);
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_TIMEOUT_TOTAL, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_TOTAL_COUNT, this.mConstants.EXECUTION_SAFEGUARDS_UDC_TIMEOUT_WINDOW_MS);
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_ANR, this.mConstants.EXECUTION_SAFEGUARDS_UDC_ANR_COUNT, this.mConstants.EXECUTION_SAFEGUARDS_UDC_ANR_WINDOW_MS);
        return;
    L5:
        if (this.mConstants.ENABLE_EXECUTION_SAFEGUARDS_UDC == true) goto L8;
        r1 = false;
        goto L9
    }

    public static String getPackageName(Intent intent) {
        Uri uri = intent.getData();
        if (uri == null) goto L5;
        String pkg = uri.getSchemeSpecificPart();
        return pkg;
    L5:
        return null;
    }

    public Context getTestableContext() {
        return getContext();
    }

    public Object getLock() {
        return this.mLock;
    }

    public JobStore getJobStore() {
        return this.mJobs;
    }

    public Constants getConstants() {
        return this.mConstants;
    }

    PendingJobQueue getPendingJobQueue() {
        return this.mPendingJobQueue;
    }

    public WorkSource deriveWorkSource(int sourceUid, String sourcePackageName) {
        WorkSource ws = new WorkSource();
        ws.createWorkChain().addNode(sourceUid, null).addNode(1000, "JobScheduler");
        return ws;
    }

    public ArraySet<String> getPackagesForUidLocked(int uid) {
        ArraySet<String> packages = this.mUidToPackageCache.get(uid);
        if (packages == null) goto L15;
        return packages;
    L15:
        String[] pkgs = AppGlobals.getPackageManager().getPackagesForUid(uid);     // Catch: RemoteException -> L9
        if (pkgs == null) goto L20;
        int r2 = pkgs.length;     // Catch: RemoteException -> L9
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L11;
        String pkg = pkgs[r3];     // Catch: RemoteException -> L9
        this.mUidToPackageCache.add(uid, pkg);     // Catch: RemoteException -> L9
        r3 = r3 + 1;     // Catch: RemoteException -> L9
        goto L7
    L11:
        return this.mUidToPackageCache.get(uid);
    L20:
        return packages;
    L18:
        return packages;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStartedUsers = ArrayUtils.appendInt(this.mStartedUsers, user.getUserIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserCompletedEvent(SystemService.TargetUser user, SystemService.UserCompletedEventType eventType) {
        if (eventType.includesOnUserStarting() == false) goto L5;
    L6:
        this.mHandler.obtainMessage(1).sendToTarget();
        return;
    L5:
        if (eventType.includesOnUserUnlocked() == true) goto L6;
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        if (from != null) goto L4;
        return;
    L4:
        if (this.mActivityManagerInternal.isEarlyPackageKillEnabledForUserSwitch(from.getUserIdentifier(), to.getUserIdentifier()) == false) goto L17;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStartedUsers = ArrayUtils.removeInt(this.mStartedUsers, from.getUserIdentifier());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStartedUsers = ArrayUtils.removeInt(this.mStartedUsers, user.getUserIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isUidActive(int uid) {
        return this.mAppStateTracker.isUidActiveSynced(uid);
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
    public int scheduleAsPackage(JobInfo r87, JobWorkItem r88, int r89, String r90, int r91, String r92, String r93) {
        String r10 = r90;
        String r14 = r87.getService().getPackageName();
        if (r87.isPersisted() == false) goto L47;
        if (r10 != null) goto L6;
        String r0 = r14;
    L7:
        String r3 = r0;
        if (this.mQuotaTracker.isWithinQuota(r91, r3, QUOTA_TRACKER_SCHEDULE_PERSISTED_TAG) == false) goto L10;
    L45:
        this.mQuotaTracker.noteEvent(r91, r3, QUOTA_TRACKER_SCHEDULE_PERSISTED_TAG);
        goto L47
    L10:
        if (this.mQuotaTracker.isWithinQuota(r91, r3, QUOTA_TRACKER_SCHEDULE_LOGGED) == false) goto L12;
        Slog.wtf("JobScheduler", r91 + "-" + r3 + " has called schedule() too many times");
        this.mQuotaTracker.noteEvent(r91, r3, QUOTA_TRACKER_SCHEDULE_LOGGED);
    L12:
        this.mAppStandbyInternal.restrictApp(r3, r91, 4);
        if (this.mConstants.API_QUOTA_SCHEDULE_THROW_EXCEPTION == false) goto L43;
        Object r4 = this.mLock;
        monitor-enter(r4);
    L26:
        th = move-exception;
        throw th;
    L17:
        if (this.mDebuggableApps.containsKey(r10) == false) goto L136;
    L34:
        boolean r1 = this.mDebuggableApps.get(r10).booleanValue();     // Catch: Throwable -> L26
        monitor-exit(r4);     // Catch: Throwable -> L26
        if (r1 == false) goto L43;
        throw new LimitExceededException("schedule()/enqueue() called more than " + this.mQuotaTracker.getLimit(QUOTA_TRACKER_CATEGORY_SCHEDULE_PERSISTED) + " times in the past " + this.mQuotaTracker.getWindowSizeMs(QUOTA_TRACKER_CATEGORY_SCHEDULE_PERSISTED) + "ms. See the documentation for more information.");
    L136:
        ApplicationInfo r2 = AppGlobals.getPackageManager().getApplicationInfo(r3, 0, r91);     // Catch: Throwable -> L26 RemoteException -> L28
        if (r2 == null) goto L30;
        ArrayMap<String, Boolean> r5 = this.mDebuggableApps;     // Catch: Throwable -> L26 RemoteException -> L28
        if ((r2.flags & 2) == 0) goto L23;
        boolean r6 = true;
    L24:
        r5.put(r10, Boolean.valueOf(r6));     // Catch: Throwable -> L26 RemoteException -> L28
    L23:
        r6 = false;
        goto L24
    L30:
        monitor-exit(r4);     // Catch: Throwable -> L26
        return 0;
    L28:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L26
    L43:
        if (this.mConstants.API_QUOTA_SCHEDULE_RETURN_FAILURE_RESULT == false) goto L45;
        return 0;
    L6:
        r0 = r10;
    L47:
        if (this.mActivityManagerInternal.isAppStartModeDisabled(r89, r14) == false) goto L51;
        Slog.w("JobScheduler", "Not scheduling job for " + r89 + ":" + r87.toString() + " -- package not allowed to start");
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_schedule_failure_app_start_mode_disabled", r89);
        return 0;
    L51:
        if (r87.getRequiredNetwork() == null) goto L55;
        sInitialJobEstimatedNetworkDownloadKBLogger.logSample(safelyScaleBytesToKBForHistogram(r87.getEstimatedNetworkDownloadBytes()));
        sInitialJobEstimatedNetworkUploadKBLogger.logSample(safelyScaleBytesToKBForHistogram(r87.getEstimatedNetworkUploadBytes()));
        sJobMinimumChunkKBLogger.logSampleWithUid(r89, safelyScaleBytesToKBForHistogram(r87.getMinimumNetworkChunkBytes()));
        if (r88 == null) goto L55;
        sInitialJwiEstimatedNetworkDownloadKBLogger.logSample(safelyScaleBytesToKBForHistogram(r88.getEstimatedNetworkDownloadBytes()));
        sInitialJwiEstimatedNetworkUploadKBLogger.logSample(safelyScaleBytesToKBForHistogram(r88.getEstimatedNetworkUploadBytes()));
        sJwiMinimumChunkKBLogger.logSampleWithUid(r89, safelyScaleBytesToKBForHistogram(r88.getMinimumNetworkChunkBytes()));
    L55:
        if (r88 == null) goto L57;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_job_work_items_enqueued", r89);
    L57:
        Object r7 = this.mLock;
        monitor-enter(r7);
        JobStatus r8 = this.mJobs.getJobByUidAndJobId(r89, r92, r87.getId());     // Catch: Throwable -> L73
        if (r88 == null) goto L83;
        if (r8 == null) goto L83;
        JobInfo r9 = r87;
        if (r8.getJob().equals(r9) == true) goto L67;
    L84:
        JobStatus r11 = JobStatus.createFromJobInfo(r9, r89, r10, r91, r92, r93);     // Catch: Throwable -> L73
        if (r11.isRequestedExpeditedJob() == true) goto L87;
    L91:
        r11.maybeAddForegroundExemption(this.mIsUidActivePredicate);     // Catch: Throwable -> L73
        if (DEBUG == false) goto L94;
        Slog.d("JobScheduler", "SCHEDULE: " + r11.toShortString());     // Catch: Throwable -> L73
    L94:
        if (r90 == null) goto L96;
    L100:
        r11.prepareLocked();     // Catch: Throwable -> L73
        if (r8 == null) goto L115;
        if (r88 == null) goto L111;
        if (r8.isPersisted() == false) goto L111;
        if (r8.getWorkCount() < this.mConstants.MAX_NUM_PERSISTED_JOB_WORK_ITEMS) goto L111;
        Slog.w("JobScheduler", "Too many JWIs for uid " + r89);     // Catch: Throwable -> L73
        throw new IllegalStateException("Apps may not persist more than " + this.mConstants.MAX_NUM_PERSISTED_JOB_WORK_ITEMS + " JobWorkItems per job");     // Catch: Throwable -> L73
    L111:
        JobStatus r12 = r11;
        Object r13 = r7;
        cancelJobImplLocked(r8, r12, 1, 0, "job rescheduled by app");     // Catch: Throwable -> L113
    L116:
        if (r88 == null) goto L118;
        r12.enqueueWorkLocked(r88);     // Catch: Throwable -> L113
        sEnqueuedJwiHighWaterMarkLogger.logSampleWithUid(r89, r12.getWorkCount());     // Catch: Throwable -> L113
    L118:
        int r15 = r12.getSourceUid();     // Catch: Throwable -> L113
        if (r12.isProxyJob() == false) goto L122;
        int[] r16 = {r15, r89};     // Catch: Throwable -> L113
    L121:
        int[] r17 = r16;
        if (r12.isProxyJob() == false) goto L126;
        String[] r18 = {null, r12.getSourceTag()};     // Catch: Throwable -> L113
    L127:
        FrameworkStatsLog.write(8, r17, r18, r12.getBatteryName(), 2, -1, r12.getStandbyBucket(), r12.getLoggingJobId(), r12.hasChargingConstraint(), r12.hasBatteryNotLowConstraint(), r12.hasStorageNotLowConstraint(), r12.hasTimingDelayConstraint(), r12.hasDeadlineConstraint(), r12.hasIdleConstraint(), r12.hasConnectivityConstraint(), r12.hasContentTriggerConstraint(), r12.isRequestedExpeditedJob(), false, 0, r12.getJob().isPrefetch(), r12.getJob().getPriority(), r12.getEffectivePriority(), r12.getNumPreviousAttempts(), r12.getJob().getMaxExecutionDelayMillis(), false, false, false, false, false, false, false, false, 0, r12.getJob().isUserInitiated(), false, r12.getJob().isPeriodic(), r12.getJob().getMinLatencyMillis(), r12.getEstimatedNetworkDownloadBytes(), r12.getEstimatedNetworkUploadBytes(), r12.getWorkCount(), ActivityManager.processStateAmToProto(this.mUidProcStates.get(r12.getUid())), r12.getNamespaceHash(), 0, 0, 0, 0, r12.getJob().getIntervalMillis(), r12.getJob().getFlexMillis(), r12.hasFlexibilityConstraint(), false, r12.canApplyTransportAffinities(), r12.getNumAppliedFlexibleConstraints(), r12.getNumDroppedFlexibleConstraints(), r12.getFilteredTraceTag(), r12.getFilteredDebugTags(), r12.getNumAbandonedFailures(), r12.getJob().getBackoffPolicy() + 1, shouldUseAggressiveBackoff(r12.getNumAbandonedFailures(), r12.getSourceUid()));     // Catch: Throwable -> L113
        if (isReadyToBeExecutedLocked(r12) == false) goto L130;
        this.mJobPackageTracker.notePending(r12);     // Catch: Throwable -> L113
        this.mPendingJobQueue.add(r12);     // Catch: Throwable -> L113
        maybeRunPendingJobsLocked();     // Catch: Throwable -> L113
    L130:
        monitor-exit(r13);     // Catch: Throwable -> L113
        return 1;
    L126:
        r18 = new String[]{r12.getSourceTag()};     // Catch: Throwable -> L113
        goto L127
    L122:
        r16 = new int[]{r15};     // Catch: Throwable -> L113
        goto L121
    L115:
        r13 = r7;
        r12 = r11;
        startTrackingJobLocked(r12, null);     // Catch: Throwable -> L113
        goto L116
    L96:
        if (this.mJobs.countJobsForUid(r89) <= 150) goto L100;
        Slog.w("JobScheduler", "Too many jobs for uid " + r89);     // Catch: Throwable -> L73
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_max_scheduling_limit_hit", r89);     // Catch: Throwable -> L73
        throw new IllegalStateException("Apps may not schedule more than 150 distinct jobs");     // Catch: Throwable -> L73
    L87:
        if (this.mQuotaController.isWithinEJQuotaLocked(r11) == true) goto L91;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_schedule_failure_ej_out_of_quota", r89);     // Catch: Throwable -> L73
        monitor-exit(r7);     // Catch: Throwable -> L73
        return 0;
    L67:
        if (r8.getWorkCount() >= this.mConstants.MAX_NUM_PERSISTED_JOB_WORK_ITEMS) goto L69;
    L75:
        r8.enqueueWorkLocked(r88);     // Catch: Throwable -> L73
        if (r8.getJob().isUserInitiated() == false) goto L78;
        r8.removeInternalFlags(6);     // Catch: Throwable -> L73
    L78:
        this.mJobs.touchJob(r8);     // Catch: Throwable -> L73
        sEnqueuedJwiHighWaterMarkLogger.logSampleWithUid(r89, r8.getWorkCount());     // Catch: Throwable -> L73
        r8.maybeAddForegroundExemption(this.mIsUidActivePredicate);     // Catch: Throwable -> L73
        monitor-exit(r7);     // Catch: Throwable -> L73
        return 1;
    L69:
        if (r8.isPersisted() == false) goto L75;
        Slog.w("JobScheduler", "Too many JWIs for uid " + r89);     // Catch: Throwable -> L73
        throw new IllegalStateException("Apps may not persist more than " + this.mConstants.MAX_NUM_PERSISTED_JOB_WORK_ITEMS + " JobWorkItems per job");     // Catch: Throwable -> L73
    L81:
        th = th;
    L74:
        Object r19 = r7;
    L132:
        monitor-exit(r19);     // Catch: Throwable -> L113
        throw th;
    L83:
        r9 = r87;
    L113:
        th = th;
        r19 = r10;
    L73:
        th = th;
        goto L74
    }

    private ArrayMap<String, List<JobInfo>> getPendingJobs(int uid) {
        ArrayMap<String, List<JobInfo>> outMap = new ArrayMap();
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArraySet<JobStatus> jobs = this.mJobs.getJobsByUid(uid);     // Catch: Throwable -> L9
        int i = jobs.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        JobStatus job = jobs.valueAt(i);     // Catch: Throwable -> L9
        List<JobInfo> outList = outMap.get(job.getNamespace());     // Catch: Throwable -> L9
        if (outList != null) goto L11;
        outList = new ArrayList();     // Catch: Throwable -> L9
        outMap.put(job.getNamespace(), outList);     // Catch: Throwable -> L9
    L11:
        outList.add(job.getJob());     // Catch: Throwable -> L9
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return outMap;
    L9:
        th = move-exception;
        throw th;
    }

    private List<JobInfo> getPendingJobsInNamespace(int uid, String namespace) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<JobStatus> jobs = this.mJobs.getJobsByUid(uid);     // Catch: Throwable -> L9
        ArrayList<JobInfo> outList = new ArrayList();     // Catch: Throwable -> L9
        int i = jobs.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        JobStatus job = jobs.valueAt(i);     // Catch: Throwable -> L9
        if (Objects.equals(namespace, job.getNamespace()) == false) goto L11;
        outList.add(job.getJob());     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return outList;
    L9:
        th = move-exception;
        throw th;
    }

    private int[] getPendingJobReasons(int uid, String namespace, int jobId) {
        SparseArrayMap<String, SparseArray<int[]>> r0 = this.mPendingJobReasonsCache;
        monitor-enter(r0);
        SparseArray<int[]> jobIdToReasons = (SparseArray) this.mPendingJobReasonsCache.get(uid, namespace);     // Catch: Throwable -> L10
        if (jobIdToReasons == null) goto L12;
        int[] reasons = jobIdToReasons.get(jobId);     // Catch: Throwable -> L10
        if (reasons == null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return reasons;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        Object r1 = this.mLock;
        monitor-enter(r1);
        int[] reasons2 = getPendingJobReasonsLocked(uid, namespace, jobId);     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.v("JobScheduler", "getPendingJobReasons(" + uid + "," + namespace + "," + jobId + ")=" + Arrays.toString(reasons2));     // Catch: Throwable -> L18
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L18
        SparseArrayMap<String, SparseArray<int[]>> r2 = this.mPendingJobReasonsCache;
        monitor-enter(r2);
        SparseArray<int[]> jobIdToReasons2 = (SparseArray) this.mPendingJobReasonsCache.get(uid, namespace);     // Catch: Throwable -> L26
        if (jobIdToReasons2 != null) goto L28;
        jobIdToReasons2 = new SparseArray();     // Catch: Throwable -> L26
        this.mPendingJobReasonsCache.add(uid, namespace, jobIdToReasons2);     // Catch: Throwable -> L26
    L28:
        jobIdToReasons2.put(jobId, reasons2);     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        return reasons2;
    L26:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        throw th;
    }

    int getPendingJobReason(JobStatus job) {
        return getPendingJobReasons(job.getUid(), job.getNamespace(), job.getJobId())[0];
    }

    int[] getPendingJobReasons(JobStatus job) {
        return getPendingJobReasons(job.getUid(), job.getNamespace(), job.getJobId());
    }

    private int[] getPendingJobReasonsLocked(int uid, String namespace, int jobId) {
        JobStatus job = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);
        if (job != null) goto L7;
        return new int[]{-2};
    L7:
        if (isCurrentlyRunningLocked(job) == true) goto L9;
        String debugPrefix = "getPendingJobReasonsLocked: " + job.toShortString();
        boolean jobReady = job.isReady();
        if (DEBUG == false) goto L13;
        Slog.v("JobScheduler", debugPrefix + " ready=" + jobReady);
    L13:
        JobRestriction restriction = checkIfRestricted(job);
        if (DEBUG == false) goto L16;
        Slog.v("JobScheduler", debugPrefix + " restriction=" + restriction);
    L16:
        if (jobReady == false) goto L47;
        if (restriction != null) goto L47;
        boolean userStarted = areUsersStartedLocked(job);
        if (DEBUG == false) goto L22;
        Slog.v("JobScheduler", debugPrefix + " userStarted=" + userStarted);
    L22:
        if (userStarted == false) goto L24;
        boolean backingUp = this.mBackingUpUids.get(job.getSourceUid());
        if (DEBUG == false) goto L29;
        Slog.v("JobScheduler", debugPrefix + " backingUp=" + backingUp);
    L29:
        if (backingUp == true) goto L31;
        boolean jobPending = this.mPendingJobQueue.contains(job);
        if (DEBUG == false) goto L35;
        Slog.v("JobScheduler", debugPrefix + " pending=" + jobPending);
    L35:
        if (jobPending == true) goto L37;
        boolean componentUsable = isComponentUsable(job);
        if (DEBUG == false) goto L41;
        Slog.v("JobScheduler", debugPrefix + " componentUsable=" + componentUsable);
    L41:
        if (componentUsable == true) goto L45;
        return new int[]{1};
    L45:
        return new int[]{0};
    L37:
        return new int[]{12};
    L31:
        return new int[]{1};
    L24:
        return new int[]{15};
    L47:
        return job.getPendingJobReasons(restriction);
    L9:
        return new int[]{-1};
    }

    private List<PendingJobReasonsInfo> getPendingJobReasonsHistory(int uid, String namespace, int jobId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        JobStatus job = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);     // Catch: Throwable -> L9
        if (job == null) goto L12;
        List<PendingJobReasonsInfo> r2 = job.getPendingJobReasonsHistory();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Invalid job id");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private JobInfo getPendingJob(int uid, String namespace, int jobId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<JobStatus> jobs = this.mJobs.getJobsByUid(uid);     // Catch: Throwable -> L13
        int i = jobs.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (i < 0) goto L17;
        JobStatus job = jobs.valueAt(i);     // Catch: Throwable -> L13
        if (job.getJobId() != jobId) goto L15;
        if (Objects.equals(namespace, job.getNamespace()) == false) goto L15;
        JobInfo r4 = job.getJob();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L15:
        i = i - 1;     // Catch: Throwable -> L13
        goto L5
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    void notePendingUserRequestedAppStopInternal(String packageName, int userId, String debugReason) {
        int packageUid = this.mLocalPM.getPackageUid(packageName, 0, userId);
        if (packageUid >= 0) goto L6;
        Slog.wtf("JobScheduler", "Asked to stop jobs of an unknown package");
        return;
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mConcurrencyManager.markJobsForUserStopLocked(userId, packageName, debugReason);     // Catch: Throwable -> L24
        ArraySet<JobStatus> jobs = this.mJobs.getJobsByUid(packageUid);     // Catch: Throwable -> L24
        int i = jobs.size() - 1;     // Catch: Throwable -> L24
    L9:
        if (i < 0) goto L28;
        JobStatus job = jobs.valueAt(i);     // Catch: Throwable -> L24
        job.addInternalFlags(2);     // Catch: Throwable -> L24
        if (this.mPendingJobQueue.remove(job) == false) goto L26;
        SparseArrayMap<String, SparseArray<int[]>> r5 = this.mPendingJobReasonsCache;     // Catch: Throwable -> L24
        monitor-enter(r5);     // Catch: Throwable -> L24
        SparseArray<int[]> jobIdToReason = (SparseArray) this.mPendingJobReasonsCache.get(job.getUid(), job.getNamespace());     // Catch: Throwable -> L17
        if (jobIdToReason != null) goto L19;
        jobIdToReason = new SparseArray();     // Catch: Throwable -> L17
        this.mPendingJobReasonsCache.add(job.getUid(), job.getNamespace(), jobIdToReason);     // Catch: Throwable -> L17
    L19:
        jobIdToReason.put(job.getJobId(), new int[]{15});     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
        goto L26
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L26:
        i = i - 1;     // Catch: Throwable -> L24
        goto L9
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0(JobStatus toRemove) {
        cancelJobImplLocked(toRemove, null, 13, 7, "user removed");
    }

    private void cancelJobsForUserLocked(final int userHandle) {
        this.mJobs.forEachJob(new JobSchedulerService$$ExternalSyntheticLambda0(userHandle), this.mCancelJobDueToUserRemovalConsumer);
    }

    private static /* synthetic */ boolean lambda$cancelJobsForUserLocked$1(int userHandle, JobStatus job) {
        if (job.getUserId() != userHandle) goto L5;
    L8:
        return true;
    L5:
        if (job.getSourceUserId() == userHandle) goto L8;
        return false;
    }

    private void cancelJobsForNonExistentUsers() {
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mJobs.removeJobsOfUnlistedUsers(umi.getUserIds());     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        SparseArrayMap<String, SparseArray<int[]>> r2 = this.mPendingJobReasonsCache;
        monitor-enter(r2);
        this.mPendingJobReasonsCache.clear();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    private void cancelJobsForPackageAndUidLocked(String pkgName, int uid, boolean includeSchedulingApp, boolean includeSourceApp, int reason, int internalReasonCode, String debugReason) {
        if (includeSchedulingApp == true) goto L7;
        if (includeSourceApp == true) goto L7;
        Slog.wtfStack("JobScheduler", "Didn't indicate whether to cancel jobs for scheduling and/or source app");
        includeSourceApp = true;
    L7:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(pkgName) == false) goto L10;
        Slog.wtfStack("JobScheduler", "Can't cancel all jobs for system package");
        return;
    L10:
        ArraySet<JobStatus> jobsForUid = new ArraySet();
        if (includeSchedulingApp == false) goto L13;
        this.mJobs.getJobsByUid(uid, jobsForUid);
    L13:
        if (includeSourceApp == false) goto L15;
        this.mJobs.getJobsBySourceUid(uid, jobsForUid);
    L15:
        int i = jobsForUid.size() - 1;
    L16:
        if (i < 0) goto L31;
        JobStatus job = jobsForUid.valueAt(i);
        if (includeSchedulingApp == true) goto L20;
    L21:
        if (includeSourceApp == true) goto L23;
    L25:
        boolean shouldCancel = false;
    L27:
        if (shouldCancel == false) goto L29;
        cancelJobImplLocked(job, null, reason, internalReasonCode, debugReason);
    L29:
        i = i - 1;
        goto L16
    L23:
        if (job.getSourcePackageName().equals(pkgName) == false) goto L25;
    L24:
        shouldCancel = true;
        goto L27
    L20:
        if (job.getServiceComponent().getPackageName().equals(pkgName) == true) goto L24;
    }

    public boolean cancelJobsForUid(int uid, boolean includeSourceApp, int reason, int internalReasonCode, String debugReason) {
        return cancelJobsForUid(uid, includeSourceApp, false, null, reason, internalReasonCode, debugReason);
    }

    private boolean cancelJobsForUid(int uid, boolean includeSourceApp, boolean namespaceOnly, String namespace, int reason, int internalReasonCode, String debugReason) {
        if (uid != 1000) goto L8;
        if (namespaceOnly == false) goto L6;
        if (namespace != null) goto L8;
    L6:
        Slog.wtfStack("JobScheduler", "Can't cancel all jobs for system uid");
        return false;
    L8:
        boolean jobsCanceled = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
        ArraySet<JobStatus> jobsForUid = new ArraySet();     // Catch: Throwable -> L13
        this.mJobs.getJobsByUid(uid, jobsForUid);     // Catch: Throwable -> L13
        if (includeSourceApp == false) goto L15;
        this.mJobs.getJobsBySourceUid(uid, jobsForUid);     // Catch: Throwable -> L13
    L15:
        int i = 0;
    L17:
        if (i >= jobsForUid.size()) goto L25;
        JobStatus toRemove = jobsForUid.valueAt(i);     // Catch: Throwable -> L13
        if (namespaceOnly == true) goto L21;
    L22:
        cancelJobImplLocked(toRemove, null, reason, internalReasonCode, debugReason);     // Catch: Throwable -> L13
        jobsCanceled = true;
    L23:
        i = i + 1;     // Catch: Throwable -> L13
        goto L17
    L21:
        if (Objects.equals(namespace, toRemove.getNamespace()) == false) goto L23;
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return jobsCanceled;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean cancelJob(int uid, String namespace, int jobId, int callingUid, int reason) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        JobStatus toCancel = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);     // Catch: Throwable -> L11
        if (toCancel == null) goto L14;
        cancelJobImplLocked(toCancel, null, reason, 0, "cancel() called by app, callingUid=" + callingUid + " uid=" + uid + " jobId=" + jobId);     // Catch: Throwable -> L9
    L14:
        if (toCancel == null) goto L16;
        boolean r13 = true;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r13;
    L16:
        r13 = false;
    L9:
        th = move-exception;
        Throwable r14 = th;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r14;
    L11:
        th = move-exception;
        r14 = th;
        goto L19
    }

    private void cancelJobImplLocked(JobStatus cancelled, JobStatus incomingJob, int reason, int internalReasonCode, String debugReason) {
        if (DEBUG == false) goto L5;
        Slog.d("JobScheduler", "CANCEL: " + cancelled.toShortString());
    L5:
        cancelled.unprepareLocked();
        stopTrackingJobLocked(cancelled, incomingJob, true);
        if (this.mPendingJobQueue.remove(cancelled) == false) goto L8;
        this.mJobPackageTracker.noteNonpending(cancelled);
    L8:
        this.mChangedJobList.remove(cancelled);
        boolean wasRunning = this.mConcurrencyManager.stopJobOnServiceContextLocked(cancelled, reason, internalReasonCode, debugReason);
        if (wasRunning == true) goto L19;
        int sourceUid = cancelled.getSourceUid();
        if (cancelled.isProxyJob() == false) goto L13;
        int[] r5 = {sourceUid, cancelled.getUid()};
    L15:
        if (cancelled.isProxyJob() == false) goto L17;
        String[] r11 = {null, cancelled.getSourceTag()};
    L18:
        String r0 = "JobScheduler";
        FrameworkStatsLog.write(8, r5, r11, cancelled.getBatteryName(), 3, internalReasonCode, cancelled.getStandbyBucket(), cancelled.getLoggingJobId(), cancelled.hasChargingConstraint(), cancelled.hasBatteryNotLowConstraint(), cancelled.hasStorageNotLowConstraint(), cancelled.hasTimingDelayConstraint(), cancelled.hasDeadlineConstraint(), cancelled.hasIdleConstraint(), cancelled.hasConnectivityConstraint(), cancelled.hasContentTriggerConstraint(), cancelled.isRequestedExpeditedJob(), false, reason, cancelled.getJob().isPrefetch(), cancelled.getJob().getPriority(), cancelled.getEffectivePriority(), cancelled.getNumPreviousAttempts(), cancelled.getJob().getMaxExecutionDelayMillis(), cancelled.isConstraintSatisfied(1073741824), cancelled.isConstraintSatisfied(1), cancelled.isConstraintSatisfied(2), cancelled.isConstraintSatisfied(8), cancelled.isConstraintSatisfied(Integer.MIN_VALUE), cancelled.isConstraintSatisfied(4), cancelled.isConstraintSatisfied(268435456), cancelled.isConstraintSatisfied(67108864), 0, cancelled.getJob().isUserInitiated(), false, cancelled.getJob().isPeriodic(), cancelled.getJob().getMinLatencyMillis(), cancelled.getEstimatedNetworkDownloadBytes(), cancelled.getEstimatedNetworkUploadBytes(), cancelled.getWorkCount(), ActivityManager.processStateAmToProto(this.mUidProcStates.get(cancelled.getUid())), cancelled.getNamespaceHash(), 0, 0, 0, 0, cancelled.getJob().getIntervalMillis(), cancelled.getJob().getFlexMillis(), cancelled.hasFlexibilityConstraint(), cancelled.isConstraintSatisfied(2097152), cancelled.canApplyTransportAffinities(), cancelled.getNumAppliedFlexibleConstraints(), cancelled.getNumDroppedFlexibleConstraints(), cancelled.getFilteredTraceTag(), cancelled.getFilteredDebugTags(), cancelled.getNumAbandonedFailures(), cancelled.getJob().getBackoffPolicy() + 1, shouldUseAggressiveBackoff(cancelled.getNumAbandonedFailures(), cancelled.getSourceUid()));
    L20:
        if (incomingJob != null) goto L22;
        JobSchedulerService r1 = this;
    L26:
        r1.reportActiveLocked();
        if (r1.mLastCancelledJobs.length <= 0) goto L31;
        if (internalReasonCode != 0) goto L32;
        r1.mLastCancelledJobs[r1.mLastCancelledJobIndex] = cancelled;
        r1.mLastCancelledJobTimeElapsed[r1.mLastCancelledJobIndex] = sElapsedRealtimeClock.millis();
        r1.mLastCancelledJobIndex = (r1.mLastCancelledJobIndex + 1) % r1.mLastCancelledJobs.length;
        return;
    L32:
        return;
    L31:
        return;
    L22:
        if (DEBUG == false) goto L24;
        Slog.i(r0, "Tracking replacement job " + incomingJob.toShortString());
    L24:
        r1 = this;
        r1.startTrackingJobLocked(incomingJob, cancelled);
        goto L26
    L17:
        r11 = new String[]{cancelled.getSourceTag()};
        goto L18
    L13:
        r5 = new int[]{sourceUid};
        goto L15
    L19:
        r0 = "JobScheduler";
        goto L20
    }

    void updateUidState(int uid, int procState, int capabilities) {
        if (DEBUG == false) goto L5;
        Slog.d("JobScheduler", "UID " + uid + " proc state changed to " + ActivityManager.procStateToString(procState) + " with capabilities=" + ActivityManager.getCapabilitiesSummary(capabilities));
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidProcStates.put(uid, procState);     // Catch: Throwable -> L10
        int prevBias = this.mUidBiasOverride.get(uid, 0);     // Catch: Throwable -> L10
        if (procState != 2) goto L13;
        this.mUidBiasOverride.put(uid, 40);     // Catch: Throwable -> L10
    L19:
        if (capabilities == 0) goto L24;
        if (procState == 20) goto L24;
        this.mUidCapabilities.put(uid, capabilities);     // Catch: Throwable -> L10
    L25:
        int newBias = this.mUidBiasOverride.get(uid, 0);     // Catch: Throwable -> L10
        if (prevBias != newBias) goto L28;
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L28:
        if (DEBUG == false) goto L30;
        Slog.d("JobScheduler", "UID " + uid + " bias changed from " + prevBias + " to " + newBias);     // Catch: Throwable -> L10
    L30:
        int c = 0;
    L32:
        if (c >= this.mControllers.size()) goto L34;
        this.mControllers.get(c).onUidBiasChangedLocked(uid, prevBias, newBias);     // Catch: Throwable -> L10
        c = c + 1;     // Catch: Throwable -> L10
        goto L32
    L34:
        this.mConcurrencyManager.onUidBiasChangedLocked(prevBias, newBias);     // Catch: Throwable -> L10
    L24:
        this.mUidCapabilities.delete(uid);     // Catch: Throwable -> L10
        goto L25
    L13:
        if (procState > 4) goto L16;
        this.mUidBiasOverride.put(uid, 35);     // Catch: Throwable -> L10
        goto L19
    L16:
        if (procState > 5) goto L18;
        this.mUidBiasOverride.put(uid, 30);     // Catch: Throwable -> L10
        goto L19
    L18:
        this.mUidBiasOverride.delete(uid);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getUidBias(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mUidBiasOverride.get(uid, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getUidCapabilities(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mUidCapabilities.get(uid, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getUidProcState(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mUidProcStates.get(uid, -1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.StateChangedListener
    public void onDeviceIdleStateChanged(boolean deviceIdle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (DEBUG == false) goto L9;
        Slog.d("JobScheduler", "Doze state changed: " + deviceIdle);     // Catch: Throwable -> L7
    L9:
        if (deviceIdle == false) goto L11;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L11:
        if (this.mReadyToRock == false) goto L18;
        if (this.mLocalDeviceIdleController != null) goto L15;
    L17:
        this.mHandler.obtainMessage(1).sendToTarget();     // Catch: Throwable -> L7
        goto L18
    L15:
        if (this.mReportedActive == true) goto L17;
        this.mReportedActive = true;     // Catch: Throwable -> L7
        this.mLocalDeviceIdleController.setJobsActive(true);     // Catch: Throwable -> L7
        goto L17
    }

    @Override // com.android.server.job.StateChangedListener
    public void onNetworkChanged(JobStatus jobStatus, Network newNetwork) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        JobServiceContext jsc = this.mConcurrencyManager.getRunningJobServiceContextLocked(jobStatus);     // Catch: Throwable -> L7
        if (jsc == null) goto L9;
        jsc.informOfNetworkChangeLocked(newNetwork);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.StateChangedListener
    public void onRestrictedBucketChanged(List<JobStatus> jobs) {
        int len = jobs.size();
        if (len != 0) goto L6;
        Slog.wtf("JobScheduler", "onRestrictedBucketChanged called with no jobs");
        return;
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L10:
        if (i >= len) goto L22;
        JobStatus js = jobs.get(i);     // Catch: Throwable -> L16
        int j = this.mRestrictiveControllers.size() - 1;     // Catch: Throwable -> L16
    L12:
        if (j < 0) goto L20;
        if (js.getStandbyBucket() != 5) goto L18;
        this.mRestrictiveControllers.get(j).startTrackingRestrictedJobLocked(js);     // Catch: Throwable -> L16
    L19:
        j = j - 1;     // Catch: Throwable -> L16
        goto L12
    L18:
        this.mRestrictiveControllers.get(j).stopTrackingRestrictedJobLocked(js);     // Catch: Throwable -> L16
        goto L19
    L20:
        i = i + 1;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L16
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    void reportActiveLocked() {
        if (this.mPendingJobQueue.size() <= 0) goto L5;
        boolean active = true;
    L6:
        if (active == true) goto L14;
        ArraySet<JobStatus> runningJobs = this.mConcurrencyManager.getRunningJobsLocked();
        int i = runningJobs.size() - 1;
    L8:
        if (i < 0) goto L14;
        JobStatus job = runningJobs.valueAt(i);
        if (job.canRunInDoze() == false) goto L11;
        i = i - 1;
        goto L8
    L11:
        active = true;
    L14:
        if (this.mReportedActive == active) goto L21;
        this.mReportedActive = active;
        if (this.mLocalDeviceIdleController == null) goto L22;
        this.mLocalDeviceIdleController.setJobsActive(active);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        active = false;
        goto L6
    }

    void reportAppUsage(String packageName, int userId) {
    }

    public JobSchedulerService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mJobPackageTracker = new JobPackageTracker();
        this.mCloudMediaProviderPackages = new SparseArray();
        this.mUserVisibleJobObservers = new RemoteCallbackList();
        this.mPermissionCache = new SparseArray();
        this.mPendingJobQueue = new PendingJobQueue();
        this.mStartedUsers = EmptyArray.INT;
        int r0 = 0;
        this.mLastCompletedJobIndex = 0;
        this.mLastCompletedJobs = new JobStatus[20];
        this.mLastCompletedJobTimeElapsed = new long[20];
        this.mLastCancelledJobIndex = 0;
        if (DEBUG == false) goto L5;
        int r2 = 20;
    L6:
        this.mLastCancelledJobs = new JobStatus[r2];
        if (DEBUG == false) goto L9;
        r0 = 20;
    L9:
        this.mLastCancelledJobTimeElapsed = new long[r0];
        this.mUidBiasOverride = new SparseIntArray();
        this.mUidCapabilities = new SparseIntArray();
        this.mUidProcStates = new SparseIntArray();
        this.mBackingUpUids = new SparseBooleanArray();
        this.mDebuggableApps = new ArrayMap();
        this.mUidToPackageCache = new SparseSetArray();
        this.mChangedJobList = new ArraySet();
        this.mPendingJobReasonsCache = new SparseArrayMap();
        this.mBroadcastReceiver = new AnonymousClass3(this);
        this.mUidObserver = new AnonymousClass4(this);
        this.mIsUidActivePredicate = new JobSchedulerService$$ExternalSyntheticLambda4(this);
        this.mCancelJobDueToUserRemovalConsumer = new JobSchedulerService$$ExternalSyntheticLambda5(this);
        this.mTimeSetReceiver = new AnonymousClass5(this);
        this.mJobTimeUpdater = new JobSchedulerService$$ExternalSyntheticLambda6(this);
        this.mReadyQueueFunctor = new ReadyJobQueueFunctor(this);
        this.mMaybeQueueFunctor = new MaybeReadyJobQueueFunctor(this);
        this.mLocalPM = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        ActivityManagerInternal r1 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        r1.getClass();
        this.mActivityManagerInternal = r1;
        this.mHandler = new JobHandler(this, AppSchedulingModuleThread.get().getLooper());
        this.mConstants = new Constants();
        this.mConstantsObserver = new ConstantsObserver(this, null);
        this.mJobSchedulerStub = new JobSchedulerStub(this);
        this.mConcurrencyManager = new JobConcurrencyManager(this);
        this.mStandbyTracker = new StandbyTracker(this);
        sUsageStatsManagerInternal = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        Categorizer quotaCategorizer = new JobSchedulerService$$ExternalSyntheticLambda7(this);
        this.mQuotaTracker = new CountQuotaTracker(context, quotaCategorizer);
        updateQuotaTracker();
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_SCHEDULE_LOGGED, 1, 60000);
        this.mQuotaTracker.setCountLimit(QUOTA_TRACKER_CATEGORY_DISABLED, Integer.MAX_VALUE, 60000);
        this.mAppStandbyInternal = (AppStandbyInternal) LocalServices.getService(AppStandbyInternal.class);
        this.mAppStandbyInternal.addListener(this.mStandbyTracker);
        this.mBatteryStatsInternal = (BatteryStatsInternal) LocalServices.getService(BatteryStatsInternal.class);
        publishLocalService(JobSchedulerInternal.class, new LocalService(this));
        this.mJobStoreLoadedLatch = new CountDownLatch(1);
        this.mJobs = JobStore.get(this);
        this.mJobs.initAsync(this.mJobStoreLoadedLatch);
        this.mBatteryStateTracker = new BatteryStateTracker(this);
        this.mBatteryStateTracker.startTracking();
        this.mStartControllerTrackingLatch = new CountDownLatch(1);
        this.mControllers = new ArrayList();
        this.mPrefetchController = new PrefetchController(this);
        this.mControllers.add(this.mPrefetchController);
        this.mFlexibilityController = new FlexibilityController(this, this.mPrefetchController);
        this.mControllers.add(this.mFlexibilityController);
        this.mConnectivityController = new ConnectivityController(this, this.mFlexibilityController);
        this.mControllers.add(this.mConnectivityController);
        this.mControllers.add(new TimeController(this));
        IdleController idleController = new IdleController(this, this.mFlexibilityController);
        this.mControllers.add(idleController);
        BatteryController batteryController = new BatteryController(this, this.mFlexibilityController);
        this.mControllers.add(batteryController);
        this.mStorageController = new StorageController(this);
        this.mControllers.add(this.mStorageController);
        BackgroundJobsController backgroundJobsController = new BackgroundJobsController(this);
        this.mControllers.add(backgroundJobsController);
        this.mControllers.add(new ContentObserverController(this));
        this.mDeviceIdleJobsController = new DeviceIdleJobsController(this);
        this.mControllers.add(this.mDeviceIdleJobsController);
        this.mQuotaController = new QuotaController(this, backgroundJobsController, this.mConnectivityController);
        this.mControllers.add(this.mQuotaController);
        this.mControllers.add(new ComponentController(this));
        this.mObricJobResourceController = new ObricJobResourceController(this);
        this.mControllers.add(this.mObricJobResourceController);
        startControllerTrackingAsync();
        this.mRestrictiveControllers = new ArrayList();
        this.mRestrictiveControllers.add(batteryController);
        this.mRestrictiveControllers.add(this.mConnectivityController);
        this.mRestrictiveControllers.add(idleController);
        this.mJobRestrictions = new ArrayList();
        this.mJobRestrictions.add(new ThermalStatusRestriction(this));
        this.mJobRestrictions.add(SysOptApexBridge.getFactory().getPowerSaverRestriction(context, this));
        if (this.mJobs.jobTimesInflatedValid() == true) goto L13;
        Slog.w("JobScheduler", "!!! RTC not yet good; tracking time updates for job scheduling");
        context.registerReceiver(this.mTimeSetReceiver, new IntentFilter("android.intent.action.TIME_SET"));
        return;
    L13:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    private /* synthetic */ Category lambda$new$2(int userId, String packageName, String tag) {
        if (QUOTA_TRACKER_TIMEOUT_UIJ_TAG.equals(tag) == false) goto L10;
        if (this.mConstants.ENABLE_EXECUTION_SAFEGUARDS_UDC == false) goto L8;
        return QUOTA_TRACKER_CATEGORY_TIMEOUT_UIJ;
    L8:
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    L10:
        if (QUOTA_TRACKER_TIMEOUT_EJ_TAG.equals(tag) == false) goto L17;
        if (this.mConstants.ENABLE_EXECUTION_SAFEGUARDS_UDC == false) goto L15;
        return QUOTA_TRACKER_CATEGORY_TIMEOUT_EJ;
    L15:
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    L17:
        if (QUOTA_TRACKER_TIMEOUT_REG_TAG.equals(tag) == false) goto L24;
        if (this.mConstants.ENABLE_EXECUTION_SAFEGUARDS_UDC == false) goto L22;
        return QUOTA_TRACKER_CATEGORY_TIMEOUT_REG;
    L22:
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    L24:
        if (QUOTA_TRACKER_TIMEOUT_TOTAL_TAG.equals(tag) == false) goto L31;
        if (this.mConstants.ENABLE_EXECUTION_SAFEGUARDS_UDC == false) goto L29;
        return QUOTA_TRACKER_CATEGORY_TIMEOUT_TOTAL;
    L29:
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    L31:
        if (QUOTA_TRACKER_ANR_TAG.equals(tag) == false) goto L38;
        if (this.mConstants.ENABLE_EXECUTION_SAFEGUARDS_UDC == false) goto L36;
        return QUOTA_TRACKER_CATEGORY_ANR;
    L36:
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    L38:
        if (QUOTA_TRACKER_SCHEDULE_PERSISTED_TAG.equals(tag) == false) goto L45;
        if (this.mConstants.ENABLE_API_QUOTAS == false) goto L43;
        return QUOTA_TRACKER_CATEGORY_SCHEDULE_PERSISTED;
    L43:
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    L45:
        if (QUOTA_TRACKER_SCHEDULE_LOGGED.equals(tag) == true) goto L47;
        Slog.wtf("JobScheduler", "Unexpected category tag: " + tag);
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    L47:
        if (this.mConstants.ENABLE_API_QUOTAS == false) goto L50;
        return QUOTA_TRACKER_CATEGORY_SCHEDULE_LOGGED;
    L50:
        return QUOTA_TRACKER_CATEGORY_DISABLED;
    }

    private /* synthetic */ void lambda$new$3() {
        Process.setThreadPriority(-2);
        ArrayList<JobStatus> toRemove = new ArrayList();
        ArrayList<JobStatus> toAdd = new ArrayList();
        Object r3 = this.mLock;
        monitor-enter(r3);
        getJobStore().getRtcCorrectedJobsLocked(toAdd, toRemove);     // Catch: Throwable -> L9
        int N = toAdd.size();     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= N) goto L13;
        JobStatus oldJob = toRemove.get(i);     // Catch: Throwable -> L9
        JobStatus newJob = toAdd.get(i);     // Catch: Throwable -> L9
        if (DEBUG == false) goto L11;
        Slog.v("JobScheduler", "  replacing " + oldJob + " with " + newJob);     // Catch: Throwable -> L9
    L11:
        cancelJobImplLocked(oldJob, newJob, 14, 9, "deferred rtc calculation");     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("jobscheduler", this.mJobSchedulerStub);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (480 != phase) goto L13;
        this.mStartControllerTrackingLatch.await();     // Catch: InterruptedException -> L6
    L39:
        this.mJobStoreLoadedLatch.await();     // Catch: InterruptedException -> L10
        return;
    L11:
        Slog.e("JobScheduler", "Couldn't wait on job store loading latch");
        return;
    L7:
        Slog.e("JobScheduler", "Couldn't wait on controller tracking start latch");
        goto L39
    L13:
        if (500 != phase) goto L27;
        this.mConstantsObserver.start();
        int i = this.mControllers.size() - 1;
    L15:
        if (i < 0) goto L17;
        this.mControllers.get(i).onSystemServicesReady();
        i = i - 1;
        goto L15
    L17:
        AppStateTracker r0 = (AppStateTracker) LocalServices.getService(AppStateTracker.class);
        r0.getClass();
        this.mAppStateTracker = (AppStateTrackerImpl) r0;
        ((StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class)).registerCloudProviderChangeListener(new CloudProviderChangeListener(this, null));
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addAction("android.intent.action.PACKAGE_RESTARTED");
        filter.addAction("android.intent.action.QUERY_PACKAGE_RESTART");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        getContext().registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, null);
        IntentFilter uidFilter = new IntentFilter("android.intent.action.UID_REMOVED");
        getContext().registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, uidFilter, null, null);
        IntentFilter userFilter = new IntentFilter("android.intent.action.USER_REMOVED");
        userFilter.addAction("android.intent.action.USER_ADDED");
        getContext().registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, userFilter, null, null);
        ActivityManager.getService().registerUidObserver(this.mUidObserver, 15, -1, null);     // Catch: RemoteException -> L20
    L21:
        this.mConcurrencyManager.onSystemReady();
        cancelJobsForNonExistentUsers();
        int i2 = this.mJobRestrictions.size() - 1;
    L22:
        if (i2 < 0) goto L50;
        this.mJobRestrictions.get(i2).onSystemServicesReady();
        i2 = i2 - 1;
        goto L22
    L50:
        return;
    L27:
        if (phase != 600) goto L49;
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mReadyToRock = true;     // Catch: Throwable -> L33
        this.mLocalDeviceIdleController = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);     // Catch: Throwable -> L33
        this.mConcurrencyManager.onThirdPartyAppsCanStart();     // Catch: Throwable -> L33
        this.mJobs.forEachJob(new JobSchedulerService$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L33
        this.mHandler.obtainMessage(1).sendToTarget();     // Catch: Throwable -> L33
        monitor-exit(r4);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onBootPhase$4(JobStatus job) {
        int controller = 0;
    L4:
        if (controller >= this.mControllers.size()) goto L7;
        StateController sc = this.mControllers.get(controller);
        sc.maybeStartTrackingJobLocked(job, null);
        controller = controller + 1;
        goto L4
    }

    private void startControllerTrackingAsync() {
        this.mHandler.post(new JobSchedulerService$$ExternalSyntheticLambda9(this));
    }

    private /* synthetic */ void lambda$startControllerTrackingAsync$5() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mControllers.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        this.mControllers.get(i).startTrackingLocked();     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mStartControllerTrackingLatch.countDown();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void startTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        if (jobStatus.isPreparedLocked() == true) goto L5;
        Slog.wtf("JobScheduler", "Not yet prepared when started tracking: " + jobStatus);
    L5:
        jobStatus.enqueueTime = sElapsedRealtimeClock.millis();
        if (lastJob == null) goto L8;
        boolean update = true;
    L9:
        this.mJobs.add(jobStatus);
        resetPendingJobReasonsCache(jobStatus);
        if (this.mReadyToRock == false) goto L18;
        int i = 0;
    L13:
        if (i >= this.mControllers.size()) goto L22;
        StateController controller = this.mControllers.get(i);
        if (update == false) goto L17;
        controller.maybeStopTrackingJobLocked(jobStatus, null);
    L17:
        controller.maybeStartTrackingJobLocked(jobStatus, lastJob);
        i = i + 1;
        goto L13
    L22:
        return;
    L18:
        return;
    L8:
        update = false;
        goto L9
    }

    private boolean stopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob, boolean removeFromPersisted) {
        jobStatus.stopTrackingJobLocked(incomingJob);
        SparseArrayMap<String, SparseArray<int[]>> r0 = this.mPendingJobReasonsCache;
        monitor-enter(r0);
        SparseArray<int[]> reasonCache = (SparseArray) this.mPendingJobReasonsCache.get(jobStatus.getUid(), jobStatus.getNamespace());     // Catch: Throwable -> L7
        if (reasonCache == null) goto L9;
        reasonCache.delete(jobStatus.getJobId());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        boolean removed = this.mJobs.remove(jobStatus, removeFromPersisted);
        if (removed == true) goto L14;
        Slog.w("JobScheduler", "Job didn't exist in JobStore: " + jobStatus.toShortString());
    L14:
        if (this.mReadyToRock == false) goto L19;
        int i = 0;
    L17:
        if (i >= this.mControllers.size()) goto L19;
        StateController controller = this.mControllers.get(i);
        controller.maybeStopTrackingJobLocked(jobStatus, incomingJob);
        i = i + 1;
    L19:
        return removed;
    L7:
        th = move-exception;
        throw th;
    }

    void resetPendingJobReasonsCache(JobStatus jobStatus) {
        SparseArrayMap<String, SparseArray<int[]>> r0 = this.mPendingJobReasonsCache;
        monitor-enter(r0);
        SparseArray<int[]> reasons = (SparseArray) this.mPendingJobReasonsCache.get(jobStatus.getUid(), jobStatus.getNamespace());     // Catch: Throwable -> L7
        if (reasons == null) goto L9;
        reasons.delete(jobStatus.getJobId());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCurrentlyRunningLocked(JobStatus job) {
        return this.mConcurrencyManager.isJobRunningLocked(job);
    }

    public boolean isJobInOvertimeLocked(JobStatus job) {
        return this.mConcurrencyManager.isJobInOvertimeLocked(job);
    }

    private void noteJobPending(JobStatus job) {
        this.mJobPackageTracker.notePending(job);
    }

    void noteJobsPending(ArraySet<JobStatus> jobs) {
        int i = jobs.size() - 1;
    L3:
        if (i < 0) goto L6;
        noteJobPending(jobs.valueAt(i));
        i = i - 1;
        goto L3
    }

    private void noteJobNonPending(JobStatus job) {
        this.mJobPackageTracker.noteNonpending(job);
    }

    private void clearPendingJobQueue() {
        this.mPendingJobQueue.resetIterator();
    L3:
        JobStatus job = this.mPendingJobQueue.next();
        if (job == null) goto L6;
        noteJobNonPending(job);
        goto L3
    L6:
        this.mPendingJobQueue.clear();
    }

    JobStatus getRescheduleJobForFailureLocked(JobStatus failureToReschedule, int stopReason, int internalStopReason) {
        if (internalStopReason == 11) goto L5;
    L8:
        long elapsedNowMillis = sElapsedRealtimeClock.millis();
        JobInfo job = failureToReschedule.getJob();
        long initialBackoffMillis = job.getInitialBackoffMillis();
        int numFailures = failureToReschedule.getNumFailures();
        int numAbandonedFailures = failureToReschedule.getNumAbandonedFailures();
        int numSystemStops = failureToReschedule.getNumSystemStops();
        int uid = failureToReschedule.getSourceUid();
        if (internalStopReason != 10) goto L11;
    L22:
        int numFailures2 = numFailures + 1;
        int numSystemStops2 = numSystemStops;
    L23:
        int backoffPolicy = job.getBackoffPolicy();
        if (shouldUseAggressiveBackoff(numAbandonedFailures, uid) == false) goto L26;
        backoffPolicy = 1;
    L26:
        int backoffAttempts = numFailures2 + (numSystemStops2 / this.mConstants.SYSTEM_STOP_TO_FAILURE_RATIO);
        if (backoffAttempts != 0) goto L29;
        job = job;
        long earliestRuntimeMs = 0;
    L43:
        JobStatus newJob = new JobStatus(failureToReschedule, earliestRuntimeMs, Long.MAX_VALUE, numFailures2, numAbandonedFailures, numSystemStops2, failureToReschedule.getLastSuccessfulRunTime(), sSystemClock.millis(), failureToReschedule.getCumulativeExecutionTimeMs());
        if (stopReason != 13) goto L47;
        newJob.addInternalFlags(2);
    L47:
        if (newJob.getCumulativeExecutionTimeMs() < this.mConstants.RUNTIME_CUMULATIVE_UI_LIMIT_MS) goto L52;
        if (newJob.shouldTreatAsUserInitiatedJob() == false) goto L52;
        newJob.addInternalFlags(4);
    L52:
        if (job.isPeriodic() == false) goto L54;
        newJob.setOriginalLatestRunTimeElapsed(failureToReschedule.getOriginalLatestRunTimeElapsed());
    L54:
        int ic = 0;
    L56:
        if (ic >= this.mControllers.size()) goto L59;
        StateController controller = this.mControllers.get(ic);
        controller.rescheduleForFailureLocked(newJob, failureToReschedule);
        ic = ic + 1;
        goto L56
    L59:
        return newJob;
    L29:
        switch(backoffPolicy) {
            case 0: goto L38;
            case 1: goto L34;
            default: goto L31;
        };
    L38:
        long backoff = initialBackoffMillis;
        if (backoff >= this.mConstants.MIN_LINEAR_BACKOFF_TIME_MS) goto L41;
        backoff = this.mConstants.MIN_LINEAR_BACKOFF_TIME_MS;
    L41:
        long delayMillis = backoff * ((long) backoffAttempts);
    L42:
        earliestRuntimeMs = elapsedNowMillis + Math.min(delayMillis, 18000000);
        goto L43
    L31:
        if (DEBUG == false) goto L34;
        Slog.v("JobScheduler", "Unrecognised back-off policy, defaulting to exponential.");
    L34:
        if (initialBackoffMillis >= this.mConstants.MIN_EXP_BACKOFF_TIME_MS) goto L36;
        long backoff2 = this.mConstants.MIN_EXP_BACKOFF_TIME_MS;
    L37:
        delayMillis = (long) Math.scalb(backoff2, backoffAttempts - 1);
        goto L42
    L36:
        backoff2 = initialBackoffMillis;
        goto L37
    L11:
        if (internalStopReason == 3) goto L22;
        if (internalStopReason == 12) goto L22;
        if (stopReason == 13) goto L22;
        if (CompatChanges.isChangeEnabled(372529068, uid) == false) goto L19;
    L21:
        numFailures2 = numFailures;
        numSystemStops2 = numSystemStops + 1;
        goto L23
    L19:
        if (internalStopReason != 13) goto L21;
        numAbandonedFailures = numAbandonedFailures + 1;
        numFailures2 = numFailures + 1;
        numSystemStops2 = numSystemStops;
        goto L23
    L5:
        if (failureToReschedule.isUserVisibleJob() == false) goto L8;
        Slog.i("JobScheduler", "Dropping " + failureToReschedule.toShortString() + " because of user stop");
        return null;
    }

    public boolean shouldUseAggressiveBackoff(int numAbandonedFailures, int uid) {
        if (CompatChanges.isChangeEnabled(372529068, uid) == false) goto L5;
    L7:
        return false;
    L5:
        if (numAbandonedFailures <= this.mConstants.ABANDONED_JOB_TIMEOUTS_BEFORE_AGGRESSIVE_BACKOFF) goto L7;
        return true;
    }

    JobStatus getRescheduleJobForPeriodic(JobStatus periodicToReschedule) {
        long elapsedNow = sElapsedRealtimeClock.millis();
        long period = Math.max(JobInfo.getMinPeriodMillis(), Math.min(31536000000L, periodicToReschedule.getJob().getIntervalMillis()));
        long flex = Math.max(JobInfo.getMinFlexMillis(), Math.min(period, periodicToReschedule.getJob().getFlexMillis()));
        long rescheduleBuffer = 0;
        long olrte = periodicToReschedule.getOriginalLatestRunTimeElapsed();
        if (olrte >= 0) goto L5;
    L6:
        Slog.wtf("JobScheduler", "Invalid periodic job original latest run time: " + olrte);
        olrte = elapsedNow;
    L7:
        long latestRunTimeElapsed = olrte;
        long diffMs = Math.abs(elapsedNow - latestRunTimeElapsed);
        if (elapsedNow > latestRunTimeElapsed) goto L10;
        elapsedNow = elapsedNow;
        long elapsedNow2 = latestRunTimeElapsed + period;
        if (diffMs < 1800000) goto L25;
    L27:
        long newLatestRuntimeElapsed = elapsedNow2;
    L29:
        if (newLatestRuntimeElapsed >= elapsedNow) goto L32;
        Slog.wtf("JobScheduler", "Rescheduling calculated latest runtime in the past: " + newLatestRuntimeElapsed);
        return new JobStatus(periodicToReschedule, (elapsedNow + period) - flex, elapsedNow + period, 0, 0, 0, sSystemClock.millis(), periodicToReschedule.getLastFailedRunTime(), 0);
    L32:
        long newEarliestRunTimeElapsed = newLatestRuntimeElapsed - Math.min(flex, period - rescheduleBuffer);
        if (DEBUG == false) goto L35;
        StringBuilder r2 = new StringBuilder();
        r2.append("Rescheduling executed periodic. New execution window [");
        long newLatestRuntimeElapsed2 = newLatestRuntimeElapsed;
        long newLatestRuntimeElapsed3 = newEarliestRunTimeElapsed / 1000;
        r2.append(newLatestRuntimeElapsed3);
        r2.append(", ");
        r2.append(newLatestRuntimeElapsed2 / 1000);
        r2.append("]s");
        Slog.v("JobScheduler", r2.toString());
    L37:
        return new JobStatus(periodicToReschedule, newEarliestRunTimeElapsed, newLatestRuntimeElapsed2, 0, 0, 0, sSystemClock.millis(), periodicToReschedule.getLastFailedRunTime(), 0);
    L35:
        newLatestRuntimeElapsed2 = newLatestRuntimeElapsed;
        goto L37
    L25:
        if (diffMs >= (period / 6)) goto L27;
        rescheduleBuffer = Math.min(1800000, (period / 6) - diffMs);
        newLatestRuntimeElapsed = elapsedNow2;
        goto L29
    L10:
        if (DEBUG == false) goto L13;
        Slog.i("JobScheduler", "Periodic job ran after its intended window by " + diffMs + " ms");
    L13:
        long numSkippedWindows = (diffMs / period) + 1;
        if (period != flex) goto L16;
    L21:
        long newLatestRuntimeElapsed4 = latestRunTimeElapsed + (period * numSkippedWindows);
        newLatestRuntimeElapsed = newLatestRuntimeElapsed4;
        goto L29
    L16:
        if (((period - flex) - (diffMs % period)) > (flex / 6)) goto L21;
        if (DEBUG == false) goto L20;
        Slog.d("JobScheduler", "Custom flex job ran too close to next window.");
    L20:
        numSkippedWindows = numSkippedWindows + 1;
        goto L21
    L5:
        if (olrte != Long.MAX_VALUE) goto L7;
        goto L6
    }

    void maybeProcessBuggyJob(JobStatus jobStatus, int debugStopReason) {
        boolean r1 = false;
        if (debugStopReason != 3) goto L5;
        boolean jobTimedOut = true;
    L7:
        if (CompatChanges.isChangeEnabled(372529068, jobStatus.getSourceUid()) == false) goto L9;
    L13:
        if (jobTimedOut == true) goto L33;
        if (jobStatus.madeActive <= 0) goto L33;
        long executionDurationMs = sUptimeMillisClock.millis() - jobStatus.madeActive;
        if (jobStatus.startedAsUserInitiatedJob == false) goto L23;
        if (executionDurationMs < this.mConstants.RUNTIME_MIN_UI_GUARANTEE_MS) goto L21;
        r1 = true;
    L21:
        jobTimedOut = r1;
        goto L33
    L23:
        if (jobStatus.startedAsExpeditedJob == false) goto L29;
        if (executionDurationMs < this.mConstants.RUNTIME_MIN_EJ_GUARANTEE_MS) goto L27;
        r1 = true;
    L27:
        jobTimedOut = r1;
        goto L33
    L29:
        if (executionDurationMs < this.mConstants.RUNTIME_MIN_GUARANTEE_MS) goto L31;
        r1 = true;
    L31:
        jobTimedOut = r1;
    L33:
        if (jobTimedOut == false) goto L45;
        int userId = jobStatus.getTimeoutBlameUserId();
        String pkg = jobStatus.getTimeoutBlamePackageName();
        CountQuotaTracker r4 = this.mQuotaTracker;
        if (jobStatus.startedAsUserInitiatedJob == false) goto L38;
        String r5 = QUOTA_TRACKER_TIMEOUT_UIJ_TAG;
    L41:
        r4.noteEvent(userId, pkg, r5);
        if (this.mQuotaTracker.noteEvent(userId, pkg, QUOTA_TRACKER_TIMEOUT_TOTAL_TAG) == true) goto L45;
        this.mAppStandbyInternal.restrictApp(pkg, userId, 4);
        goto L45
    L38:
        if (jobStatus.startedAsExpeditedJob == false) goto L40;
        r5 = QUOTA_TRACKER_TIMEOUT_EJ_TAG;
        goto L41
    L40:
        r5 = QUOTA_TRACKER_TIMEOUT_REG_TAG;
    L45:
        if (debugStopReason != 12) goto L50;
        int callingUserId = jobStatus.getUserId();
        String callingPkg = jobStatus.getServiceComponent().getPackageName();
        if (this.mQuotaTracker.noteEvent(callingUserId, callingPkg, QUOTA_TRACKER_ANR_TAG) == true) goto L51;
        this.mAppStandbyInternal.restrictApp(callingPkg, callingUserId, 4);
        return;
    L51:
        return;
    L50:
        return;
    L9:
        if (debugStopReason != 13) goto L11;
        boolean r3 = true;
    L12:
        jobTimedOut = jobTimedOut | r3;
        goto L13
    L11:
        r3 = false;
        goto L12
    L5:
        jobTimedOut = false;
        goto L7
    }

    @Override // com.android.server.job.JobCompletedListener
    public void onJobCompletedLocked(JobStatus jobStatus, int stopReason, int debugStopReason, boolean needsReschedule) {
        if (DEBUG == false) goto L5;
        Slog.d("JobScheduler", "Completed " + jobStatus + ", reason=" + debugStopReason + ", reschedule=" + needsReschedule);
    L5:
        this.mLastCompletedJobs[this.mLastCompletedJobIndex] = jobStatus;
        this.mLastCompletedJobTimeElapsed[this.mLastCompletedJobIndex] = sElapsedRealtimeClock.millis();
        this.mLastCompletedJobIndex = (this.mLastCompletedJobIndex + 1) % 20;
        maybeProcessBuggyJob(jobStatus, debugStopReason);
        if (debugStopReason != 7) goto L8;
    L54:
        jobStatus.unprepareLocked();
        reportActiveLocked();
        return;
    L8:
        if (debugStopReason == 8) goto L54;
        if (needsReschedule == false) goto L12;
        JobStatus rescheduledJob = getRescheduleJobForFailureLocked(jobStatus, stopReason, debugStopReason);
    L14:
        if (CompatChanges.isChangeEnabled(372529068, jobStatus.getSourceUid()) == false) goto L16;
    L18:
        boolean isStopReasonAbandoned = false;
    L19:
        if (rescheduledJob == null) goto L29;
        if (rescheduledJob.shouldTreatAsUserInitiatedJob() == true) goto L29;
        if (debugStopReason == 3) goto L27;
        if (isStopReasonAbandoned == true) goto L27;
        if (debugStopReason != 2) goto L29;
    L27:
        rescheduledJob.disallowRunInBatterySaverAndDoze();
    L29:
        if (stopTrackingJobLocked(jobStatus, rescheduledJob, true ^ jobStatus.getJob().isPeriodic()) == true) goto L38;
        if (DEBUG == false) goto L33;
        Slog.d("JobScheduler", "Could not find job to remove. Was job removed while executing?");
    L33:
        JobStatus newJs = this.mJobs.getJobByUidAndJobId(jobStatus.getUid(), jobStatus.getNamespace(), jobStatus.getJobId());
        if (newJs == null) goto L60;
        this.mHandler.obtainMessage(0, newJs).sendToTarget();
        return;
    L60:
        return;
    L38:
        if (rescheduledJob == null) goto L45;
        rescheduledJob.prepareLocked();     // Catch: SecurityException -> L41
    L43:
        startTrackingJobLocked(rescheduledJob, jobStatus);
    L52:
        jobStatus.unprepareLocked();
        reportActiveLocked();
        return;
    L42:
        Slog.w("JobScheduler", "Unable to regrant job permissions for " + rescheduledJob);
        goto L43
    L45:
        if (jobStatus.getJob().isPeriodic() == false) goto L52;
        JobStatus rescheduledPeriodic = getRescheduleJobForPeriodic(jobStatus);
        rescheduledPeriodic.prepareLocked();     // Catch: SecurityException -> L49
    L51:
        startTrackingJobLocked(rescheduledPeriodic, jobStatus);
    L50:
        Slog.w("JobScheduler", "Unable to regrant job permissions for " + rescheduledPeriodic);
        goto L51
    L16:
        if (debugStopReason != 13) goto L18;
        isStopReasonAbandoned = true;
        goto L19
    L12:
        rescheduledJob = null;
        goto L14
    }

    @Override // com.android.server.job.StateChangedListener
    public void onControllerStateChanged(ArraySet<JobStatus> changedJobs) {
        if (changedJobs != null) goto L13;
        this.mHandler.obtainMessage(1).sendToTarget();
        SparseArrayMap<String, SparseArray<int[]>> r1 = this.mPendingJobReasonsCache;
        monitor-enter(r1);
        this.mPendingJobReasonsCache.clear();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        if (changedJobs.size() <= 0) goto L41;
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mChangedJobList.addAll(changedJobs);     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        this.mHandler.obtainMessage(8).sendToTarget();
        SparseArrayMap<String, SparseArray<int[]>> r3 = this.mPendingJobReasonsCache;
        monitor-enter(r3);
        int i = changedJobs.size() - 1;     // Catch: Throwable -> L23
    L21:
        if (i < 0) goto L26;
        JobStatus job = changedJobs.valueAt(i);     // Catch: Throwable -> L23
        resetPendingJobReasonsCache(job);     // Catch: Throwable -> L23
        i = i - 1;     // Catch: Throwable -> L23
        goto L21
    L26:
        monitor-exit(r3);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.StateChangedListener
    public void onRestrictionStateChanged(JobRestriction restriction, boolean stopOvertimeJobs) {
        this.mHandler.obtainMessage(1).sendToTarget();
        if (stopOvertimeJobs == false) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConcurrencyManager.maybeStopOvertimeJobsLocked(restriction);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.StateChangedListener
    public void onRunJobNow(JobStatus jobStatus) {
        if (jobStatus != null) goto L4;
        this.mHandler.obtainMessage(3).sendToTarget();
        return;
    L4:
        this.mHandler.obtainMessage(0, jobStatus).sendToTarget();
    }

    JobRestriction checkIfRestricted(JobStatus job) {
        int i = this.mJobRestrictions.size() - 1;
    L3:
        if (i < 0) goto L8;
        JobRestriction restriction = this.mJobRestrictions.get(i);
        if (restriction.isJobRestricted(job, evaluateJobBiasLocked(job)) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return restriction;
    L8:
        return null;
    }

    private void stopNonReadyActiveJobsLocked() {
        this.mConcurrencyManager.stopNonReadyActiveJobsLocked();
    }

    private void queueReadyJobsForExecutionLocked() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(0);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(8);
        this.mChangedJobList.clear();
        if (DEBUG == false) goto L5;
        Slog.d("JobScheduler", "queuing all ready jobs for execution:");
    L5:
        clearPendingJobQueue();
        stopNonReadyActiveJobsLocked();
        this.mJobs.forEachJob(this.mReadyQueueFunctor);
        ReadyJobQueueFunctor.m4862$$Nest$mpostProcessLocked(this.mReadyQueueFunctor);
        if (DEBUG == false) goto L12;
        int queuedJobs = this.mPendingJobQueue.size();
        if (queuedJobs != 0) goto L10;
        Slog.d("JobScheduler", "No jobs pending.");
        return;
    L10:
        Slog.d("JobScheduler", queuedJobs + " jobs queued.");
        return;
    }

    private void maybeQueueReadyJobsForExecutionLocked() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(8);
        this.mChangedJobList.clear();
        if (DEBUG == false) goto L5;
        Slog.d("JobScheduler", "Maybe queuing ready jobs...");
    L5:
        clearPendingJobQueue();
        stopNonReadyActiveJobsLocked();
        this.mJobs.forEachJob(this.mMaybeQueueFunctor);
        this.mMaybeQueueFunctor.postProcessLocked();
    }

    private void checkChangedJobListLocked() {
        this.mHandler.removeMessages(8);
        if (DEBUG == false) goto L6;
        Slog.d("JobScheduler", "Check changed jobs...");
    L6:
        if (this.mChangedJobList.size() != 0) goto L8;
        return;
    L8:
        this.mChangedJobList.forEach(this.mMaybeQueueFunctor);
        this.mMaybeQueueFunctor.postProcessLocked();
        this.mChangedJobList.clear();
    }

    private void updateMediaBackupExemptionLocked(final int userId, final String oldPkg, final String newPkg) {
        Predicate<JobStatus> shouldProcessJob = new JobSchedulerService$$ExternalSyntheticLambda2(userId, oldPkg, newPkg);
        this.mJobs.forEachJob(shouldProcessJob, new JobSchedulerService$$ExternalSyntheticLambda3(this));
        this.mHandler.sendEmptyMessage(8);
    }

    private static /* synthetic */ boolean lambda$updateMediaBackupExemptionLocked$6(int userId, String oldPkg, String newPkg, JobStatus job) {
        if (job.getSourceUserId() == userId) goto L5;
    L9:
        return false;
    L5:
        if (job.getSourcePackageName().equals(oldPkg) == false) goto L7;
    L8:
        return true;
    L7:
        if (job.getSourcePackageName().equals(newPkg) == false) goto L9;
        goto L8
    }

    private /* synthetic */ void lambda$updateMediaBackupExemptionLocked$7(JobStatus job) {
        if (job.updateMediaBackupExemptionStatus() == false) goto L6;
        this.mChangedJobList.add(job);
        return;
    }

    public boolean areUsersStartedLocked(JobStatus job) {
        boolean sourceStarted = ArrayUtils.contains(this.mStartedUsers, job.getSourceUserId());
        if (job.getUserId() != job.getSourceUserId()) goto L5;
        return sourceStarted;
    L5:
        if (sourceStarted == true) goto L7;
    L9:
        return false;
    L7:
        if (ArrayUtils.contains(this.mStartedUsers, job.getUserId()) == false) goto L9;
        return true;
    }

    boolean isReadyToBeExecutedLocked(JobStatus job) {
        return isReadyToBeExecutedLocked(job, true);
    }

    boolean isReadyToBeExecutedLocked(JobStatus job, boolean rejectActive) {
        boolean jobActive = true;
        if (job.isReady() == false) goto L5;
    L8:
        boolean jobReady = true;
    L10:
        if (DEBUG == false) goto L12;
        Slog.v("JobScheduler", "isReadyToBeExecutedLocked: " + job.toShortString() + " ready=" + jobReady);
    L12:
        if (jobReady == false) goto L14;
        boolean jobExists = this.mJobs.containsJob(job);
        boolean userStarted = areUsersStartedLocked(job);
        boolean backingUp = this.mBackingUpUids.get(job.getSourceUid());
        if (DEBUG == false) goto L20;
        Slog.v("JobScheduler", "isReadyToBeExecutedLocked: " + job.toShortString() + " exists=" + jobExists + " userStarted=" + userStarted + " backingUp=" + backingUp);
    L20:
        if (jobExists == false) goto L42;
        if (userStarted == false) goto L42;
        if (backingUp == true) goto L42;
        if (checkIfRestricted(job) == null) goto L27;
        return false;
    L27:
        boolean jobPending = this.mPendingJobQueue.contains(job);
        if (rejectActive == true) goto L30;
    L32:
        jobActive = false;
    L34:
        if (DEBUG == false) goto L36;
        Slog.v("JobScheduler", "isReadyToBeExecutedLocked: " + job.toShortString() + " pending=" + jobPending + " active=" + jobActive);
    L36:
        if (jobPending == true) goto L41;
        if (jobActive == true) goto L41;
        return isComponentUsable(job);
    L41:
        return false;
    L30:
        if (this.mConcurrencyManager.isJobRunningLocked(job) == false) goto L32;
    L42:
        return false;
    L14:
        if (job.getSourcePackageName().equals("android.jobscheduler.cts.jobtestapp") == false) goto L16;
        Slog.v("JobScheduler", "    NOT READY: " + job);
    L16:
        return false;
    L5:
        if (evaluateControllerStatesLocked(job) == true) goto L8;
        jobReady = false;
        goto L10
    }

    private boolean isComponentUsable(JobStatus job) {
        String processName = job.serviceProcessName;
        if (processName == null) goto L5;
        boolean appIsBad = this.mActivityManagerInternal.isAppBad(processName, job.getUid());
        if (DEBUG == false) goto L14;
        if (appIsBad == false) goto L14;
        Slog.i("JobScheduler", "App is bad for " + job.toShortString() + " so not runnable");
    L14:
        return !appIsBad;
    L5:
        if (DEBUG == false) goto L15;
        Slog.v("JobScheduler", "isComponentUsable: " + job.toShortString() + " component not present");
        return false;
    L15:
        return false;
    }

    boolean evaluateControllerStatesLocked(JobStatus job) {
        int c = this.mControllers.size() - 1;
    L3:
        if (c < 0) goto L6;
        StateController sc = this.mControllers.get(c);
        sc.evaluateStateLocked(job);
        c = c - 1;
        goto L3
    L6:
        return job.isReady();
    }

    public boolean areComponentsInPlaceLocked(JobStatus job) {
        boolean jobExists = this.mJobs.containsJob(job);
        boolean userStarted = areUsersStartedLocked(job);
        boolean backingUp = this.mBackingUpUids.get(job.getSourceUid());
        if (DEBUG == false) goto L6;
        Slog.v("JobScheduler", "areComponentsInPlaceLocked: " + job.toShortString() + " exists=" + jobExists + " userStarted=" + userStarted + " backingUp=" + backingUp);
    L6:
        if (jobExists == false) goto L18;
        if (userStarted == false) goto L18;
        if (backingUp == true) goto L18;
        JobRestriction restriction = checkIfRestricted(job);
        if (restriction == null) goto L17;
        if (DEBUG == false) goto L15;
        Slog.v("JobScheduler", "areComponentsInPlaceLocked: " + job.toShortString() + " restricted due to " + restriction.getInternalReason());
    L15:
        return false;
    L17:
        return isComponentUsable(job);
    L18:
        return false;
    }

    public long getMinJobExecutionGuaranteeMs(JobStatus job) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (job.shouldTreatAsUserInitiatedJob() == true) goto L7;
    L32:
        boolean isWithinTimeoutQuota = job.shouldTreatAsExpeditedJob();     // Catch: Throwable -> L11
        if (isWithinTimeoutQuota == true) goto L35;
        long r1 = this.mConstants.RUNTIME_MIN_GUARANTEE_MS;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L35:
        if (job.getEffectiveStandbyBucket() == 5) goto L37;
        long r2 = this.mConstants.RUNTIME_MIN_EJ_GUARANTEE_MS;     // Catch: Throwable -> L11
    L38:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L37:
        r2 = Math.min(this.mConstants.RUNTIME_MIN_EJ_GUARANTEE_MS, 300000);     // Catch: Throwable -> L11
        goto L38
    L7:
        if (checkRunUserInitiatedJobsPermission(job.getSourceUid(), job.getSourcePackageName()) == false) goto L32;
        boolean isWithinTimeoutQuota2 = this.mQuotaTracker.isWithinQuota(job.getTimeoutBlameUserId(), job.getTimeoutBlamePackageName(), QUOTA_TRACKER_TIMEOUT_UIJ_TAG);     // Catch: Throwable -> L11
        if (isWithinTimeoutQuota2 == false) goto L13;
        long upperLimitMs = this.mConstants.RUNTIME_UI_LIMIT_MS;     // Catch: Throwable -> L11
    L15:
        if (job.getJob().getRequiredNetwork() != null) goto L17;
        long r4 = Math.min(upperLimitMs, this.mConstants.RUNTIME_MIN_UI_GUARANTEE_MS);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r4;
    L17:
        if (this.mConstants.RUNTIME_USE_DATA_ESTIMATES_FOR_LIMITS == false) goto L26;
        long estimatedTransferTimeMs = this.mConnectivityController.getEstimatedTransferTimeMs(job);     // Catch: Throwable -> L11
        if (estimatedTransferTimeMs != (-1)) goto L23;
        long r6 = Math.min(upperLimitMs, this.mConstants.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r6;
    L23:
        long factoredTransferTimeMs = (long) (estimatedTransferTimeMs * this.mConstants.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_BUFFER_FACTOR);     // Catch: Throwable -> L11
        long r8 = Math.min(upperLimitMs, Math.max(factoredTransferTimeMs, this.mConstants.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r8;
    L26:
        long r5 = Math.min(upperLimitMs, Math.max(this.mConstants.RUNTIME_MIN_UI_GUARANTEE_MS, this.mConstants.RUNTIME_MIN_UI_DATA_TRANSFER_GUARANTEE_MS));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r5;
    L13:
        upperLimitMs = this.mConstants.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS;     // Catch: Throwable -> L11
        goto L15
    }

    public long getMaxJobExecutionTimeMs(JobStatus job) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (job.shouldTreatAsUserInitiatedJob() == false) goto L16;
        if (checkRunUserInitiatedJobsPermission(job.getSourceUid(), job.getSourcePackageName()) == false) goto L16;
        if (this.mQuotaTracker.isWithinQuota(job.getTimeoutBlameUserId(), job.getTimeoutBlamePackageName(), QUOTA_TRACKER_TIMEOUT_UIJ_TAG) == false) goto L16;
        long r1 = this.mConstants.RUNTIME_UI_LIMIT_MS;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L16:
        if (job.shouldTreatAsUserInitiatedJob() == false) goto L21;
        long r2 = this.mConstants.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L21:
        if (job.shouldTreatAsExpeditedJob() == false) goto L23;
        String timeoutTag = QUOTA_TRACKER_TIMEOUT_EJ_TAG;
    L25:
        if (job.shouldTreatAsExpeditedJob() == false) goto L27;
        long normalUpperLimitMs = this.mConstants.RUNTIME_MIN_GUARANTEE_MS;     // Catch: Throwable -> L13
    L29:
        if (this.mQuotaTracker.isWithinQuota(job.getTimeoutBlameUserId(), job.getTimeoutBlamePackageName(), timeoutTag) == false) goto L31;
        long upperLimitMs = normalUpperLimitMs;
    L32:
        long r6 = Math.min(upperLimitMs, this.mQuotaController.getMaxJobExecutionTimeMsLocked(job));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r6;
    L31:
        upperLimitMs = this.mConstants.RUNTIME_MIN_GUARANTEE_MS;     // Catch: Throwable -> L13
        goto L32
    L27:
        normalUpperLimitMs = this.mConstants.RUNTIME_FREE_QUOTA_MAX_LIMIT_MS;     // Catch: Throwable -> L13
        goto L29
    L23:
        timeoutTag = QUOTA_TRACKER_TIMEOUT_REG_TAG;
        goto L25
    }

    void maybeRunPendingJobsLocked() {
        if (DEBUG == false) goto L5;
        Slog.d("JobScheduler", "pending queue: " + this.mPendingJobQueue.size() + " jobs.");
    L5:
        this.mConcurrencyManager.assignJobsToContextsLocked();
        reportActiveLocked();
    }

    private int adjustJobBias(int curBias, JobStatus job) {
        if (curBias >= 40) goto L11;
        float factor = this.mJobPackageTracker.getLoadFactor(job);
        if (factor < this.mConstants.HEAVY_USE_FACTOR) goto L8;
        return curBias - 80;
    L8:
        if (factor >= this.mConstants.MODERATE_USE_FACTOR) goto L10;
        return curBias;
    L10:
        return curBias - 40;
    L11:
        return curBias;
    }

    int evaluateJobBiasLocked(JobStatus job) {
        int bias = job.getBias();
        if (bias >= 30) goto L5;
        int override = this.mUidBiasOverride.get(job.getSourceUid(), 0);
        if (override == 0) goto L11;
        return adjustJobBias(override, job);
    L11:
        return adjustJobBias(bias, job);
    L5:
        return adjustJobBias(bias, job);
    }

    void informObserversOfUserVisibleJobChange(JobServiceContext r4, JobStatus r5, boolean r6) {
        SomeArgs r0 = SomeArgs.obtain();
        r0.arg1 = r4;
        r0.arg2 = r5;
        r0.argi1 = r6 ? 1 : 0;
        this.mHandler.obtainMessage(11, r0).sendToTarget();
    }

    public static int standbyBucketToBucketIndex(int bucket) {
        if (bucket != 50) goto L7;
        return 4;
    L7:
        if (bucket <= 40) goto L10;
        return 5;
    L10:
        if (bucket <= 30) goto L14;
        return 3;
    L14:
        if (bucket <= 20) goto L18;
        return 2;
    L18:
        if (bucket <= 10) goto L21;
        return 1;
    L21:
        if (bucket <= 5) goto L24;
        return 0;
    L24:
        return 6;
    }

    public static int standbyBucketForPackage(String packageName, int userId, long elapsedNow) {
        if (sUsageStatsManagerInternal == null) goto L5;
        int bucket = sUsageStatsManagerInternal.getAppStandbyBucket(packageName, userId, elapsedNow);
    L6:
        int bucket2 = standbyBucketToBucketIndex(bucket);
        if (DEBUG_STANDBY == false) goto L9;
        Slog.v("JobScheduler", packageName + SliceClientPermissions.SliceAuthority.DELIMITER + userId + " standby bucket index: " + bucket2);
    L9:
        return bucket2;
    L5:
        bucket = 0;
        goto L6
    }

    static int safelyScaleBytesToKBForHistogram(long bytes) {
        long kilobytes = bytes / 1000;
        if (kilobytes <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (kilobytes >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) kilobytes;
    }

    private boolean hasPermission(int uid, int pid, String permission) {
        SparseArray<SparseArrayMap<String, Boolean>> r0 = this.mPermissionCache;
        monitor-enter(r0);
        SparseArrayMap<String, Boolean> pidPermissions = this.mPermissionCache.get(uid);     // Catch: Throwable -> L7
        if (pidPermissions != null) goto L9;
        pidPermissions = new SparseArrayMap();     // Catch: Throwable -> L7
        this.mPermissionCache.put(uid, pidPermissions);     // Catch: Throwable -> L7
    L9:
        Boolean cached = (Boolean) pidPermissions.get(pid, permission);     // Catch: Throwable -> L7
        if (cached == null) goto L14;
        boolean r3 = cached.booleanValue();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L14:
        int result = getContext().checkPermission(permission, pid, uid);     // Catch: Throwable -> L7
        if (result != 0) goto L17;
        boolean permissionGranted = true;
    L18:
        pidPermissions.add(pid, permission, Boolean.valueOf(permissionGranted));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return permissionGranted;
    L17:
        permissionGranted = false;
    L7:
        th = move-exception;
        throw th;
    }

    int executeRunCommand(String pkgName, int userId, String namespace, int jobId, boolean satisfied, boolean force) {
        Slog.d("JobScheduler", "executeRunCommand(): " + pkgName + SliceClientPermissions.SliceAuthority.DELIMITER + namespace + SliceClientPermissions.SliceAuthority.DELIMITER + userId + " " + jobId + " s=" + satisfied + " f=" + force);
        CountDownLatch delayLatch = new CountDownLatch(1);
        IPackageManager r0 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L79
        if (userId == (-1)) goto L6;
        int r9 = userId;
    L7:
        int uid = r0.getPackageUid(pkgName, 0, r9);     // Catch: RemoteException -> L79
        if (uid >= 0) goto L11;
        return -1000;
    L11:
        Object r10 = this.mLock;     // Catch: RemoteException -> L79
        monitor-enter(r10);     // Catch: RemoteException -> L79
        JobStatus js = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);     // Catch: Throwable -> L49
        if (js != null) goto L21;
        monitor-exit(r10);     // Catch: Throwable -> L19
        return JobSchedulerShellCommand.CMD_ERR_NO_JOB;
    L21:
        if (force == false) goto L23;
        int r1 = 3;
    L26:
        js.overrideState = r1;     // Catch: Throwable -> L49
        int c = this.mControllers.size() - 1;
    L28:
        if (c < 0) goto L33;
        this.mControllers.get(c).evaluateStateLocked(js);     // Catch: Throwable -> L19
        c = c - 1;
        goto L28
    L33:
        if (js.isConstraintsSatisfied() == false) goto L35;
        Object r17 = r10;
        JobStatus js2 = js;
        delayLatch.countDown();     // Catch: Throwable -> L45
    L58:
        monitor-exit(r17);     // Catch: Throwable -> L45
        delayLatch.await(7, TimeUnit.SECONDS);     // Catch: InterruptedException -> L61
    L63:
        Object r11 = this.mLock;
        monitor-enter(r11);
    L70:
        th = move-exception;
        throw th;
    L66:
        if (js2.isConstraintsSatisfied() == true) goto L72;
        js2.overrideState = 0;     // Catch: Throwable -> L70
        monitor-exit(r11);     // Catch: Throwable -> L70
        return JobSchedulerShellCommand.CMD_ERR_CONSTRAINTS;
    L72:
        queueReadyJobsForExecutionLocked();     // Catch: Throwable -> L70
        maybeRunPendingJobsLocked();     // Catch: Throwable -> L70
        monitor-exit(r11);     // Catch: Throwable -> L70
        return 0;
    L61:
        e = move-exception;
        Slog.e("JobScheduler", "Couldn't wait for asynchronous constraint change", e);
        goto L63
    L35:
        if (js.hasConnectivityConstraint() == false) goto L54;
        if (js.isConstraintSatisfied(268435456) == true) goto L54;
        if (js.wouldBeReadyWithConstraint(268435456) == false) goto L54;
        js2 = js;
        r17 = r10;
        this.mHandler.postDelayed(checkConstraintRunnableForTesting(this.mHandler, js2, delayLatch, 5, 1000), 1000);     // Catch: Throwable -> L45
    L47:
        th = th;
    L77:
        monitor-exit(r10);     // Catch: Throwable -> L45
        throw th;     // Catch: RemoteException -> L79
    L54:
        js.overrideState = 0;     // Catch: Throwable -> L45
        monitor-exit(r10);     // Catch: Throwable -> L45
        return JobSchedulerShellCommand.CMD_ERR_CONSTRAINTS;
    L23:
        if (satisfied == false) goto L25;
        r1 = 1;
        goto L26
    L25:
        r1 = 2;
    L19:
        th = th;
    L49:
        th = th;
    L45:
        th = th;
        goto L77
    L6:
        r9 = 0;
    L80:
        return 0;
    }

    private static Runnable checkConstraintRunnableForTesting(final Handler handler, final JobStatus js, final CountDownLatch latch, final int remainingAttempts, final long delayMs) {
        return new JobSchedulerService$$ExternalSyntheticLambda10(remainingAttempts, js, latch, handler, delayMs);
    }

    private static /* synthetic */ void lambda$checkConstraintRunnableForTesting$8(int remainingAttempts, JobStatus js, CountDownLatch latch, Handler handler, long delayMs) {
        if (remainingAttempts <= 0) goto L9;
        if (js.isConstraintsSatisfied() == true) goto L9;
        handler.postDelayed(checkConstraintRunnableForTesting(handler, js, latch, remainingAttempts - 1, delayMs), delayMs);
        return;
    L9:
        latch.countDown();
    }

    int executeStopCommand(PrintWriter pw, String pkgName, int userId, String namespace, boolean hasJobId, int jobId, int stopReason, int internalStopReason) {
        if (DEBUG == false) goto L5;
        StringBuilder r1 = new StringBuilder();
        r1.append("executeStopJobCommand(): ");
        r1.append(pkgName);
        r1.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r1.append(userId);
        r1.append(" ");
        int r9 = jobId;
        r1.append(r9);
        r1.append(": ");
        int r10 = stopReason;
        r1.append(r10);
        r1.append("(");
        r1.append(JobParameters.getInternalReasonCodeDescription(internalStopReason));
        r1.append(")");
        Slog.v("JobScheduler", r1.toString());
    L6:
        Object r2 = this.mLock;
        monitor-enter(r2);
        boolean foundSome = this.mConcurrencyManager.executeStopCommandLocked(pw, pkgName, userId, namespace, hasJobId, r9, r10, internalStopReason);     // Catch: Throwable -> L11
        if (foundSome == true) goto L13;
        pw.println("No matching executing jobs found.");     // Catch: Throwable -> L11
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        throw th;
    L5:
        r9 = jobId;
        r10 = stopReason;
        goto L6
    }

    int executeCancelCommand(PrintWriter pw, String pkgName, int userId, String namespace, boolean hasJobId, int jobId) {
        if (DEBUG == false) goto L5;
        Slog.v("JobScheduler", "executeCancelCommand(): " + pkgName + SliceClientPermissions.SliceAuthority.DELIMITER + userId + " " + jobId);
    L5:
        int pkgUid = -1;
        IPackageManager pm = AppGlobals.getPackageManager();     // Catch: RemoteException -> L9
        pkgUid = pm.getPackageUid(pkgName, 0, userId);     // Catch: RemoteException -> L9
    L8:
        int pkgUid2 = pkgUid;
        if (pkgUid2 >= 0) goto L15;
        pw.println("Package " + pkgName + " not found.");
        return -1000;
    L15:
        if (hasJobId == true) goto L20;
        pw.println("Canceling all jobs for " + pkgName + " in user " + userId);
        if (cancelJobsForUid(pkgUid2, false, 13, 0, "cancel shell command for package") == true) goto L28;
        pw.println("No matching jobs found.");
        return 0;
    L28:
        return 0;
    L20:
        pw.println("Canceling job " + pkgName + "/#" + jobId + " in user " + userId);
        if (cancelJob(pkgUid2, namespace, jobId, 2000, 13) == true) goto L29;
        pw.println("No matching job found.");
        return 0;
    L29:
        return 0;
    }

    void setFlexPolicy(boolean override, int appliedConstraints) {
        if (DEBUG == false) goto L5;
        Slog.v("JobScheduler", "setFlexPolicy(): " + override + SliceClientPermissions.SliceAuthority.DELIMITER + appliedConstraints);
    L5:
        this.mFlexibilityController.setLocalPolicyForTesting(override, appliedConstraints);
    }

    void setMonitorBattery(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBatteryStateTracker.setMonitorBatteryLocked(enabled);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    int getBatterySeq() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mBatteryStateTracker.getSeq();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isBatteryCharging() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mBatteryStateTracker.isCharging();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isBatteryNotLow() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mBatteryStateTracker.isBatteryNotLow();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isPowerConnected() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mBatteryStateTracker.isPowerConnected();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setCacheConfigChanges(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConstantsObserver.setCacheConfigChangesLocked(enabled);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    String getConfigValue(String key) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mConstantsObserver.getValueLocked(key);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int getStorageSeq() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mStorageController.getTracker().getSeq();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean getStorageNotLow() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mStorageController.getTracker().isStorageNotLow();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int getEstimatedNetworkBytes(PrintWriter pw, String pkgName, int userId, String namespace, int jobId, int byteOption) {
        IPackageManager r1 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L11
        if (userId == (-1)) goto L6;
        int r2 = userId;
    L7:
        int uid = r1.getPackageUid(pkgName, 0, r2);     // Catch: RemoteException -> L11
        if (uid >= 0) goto L13;
        pw.print("unknown(");     // Catch: RemoteException -> L11
        pw.print(pkgName);     // Catch: RemoteException -> L11
        pw.println(")");     // Catch: RemoteException -> L11
        return -1000;
    L13:
        Object r3 = this.mLock;     // Catch: RemoteException -> L11
        monitor-enter(r3);     // Catch: RemoteException -> L11
        JobStatus js = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.d("JobScheduler", "get-estimated-network-bytes " + uid + SliceClientPermissions.SliceAuthority.DELIMITER + namespace + SliceClientPermissions.SliceAuthority.DELIMITER + jobId + ": " + js);     // Catch: Throwable -> L18
    L20:
        if (js != null) goto L25;
        pw.print("unknown(");     // Catch: Throwable -> L18
        UserHandle.formatUid(pw, uid);     // Catch: Throwable -> L18
        pw.print("/jid");     // Catch: Throwable -> L18
        pw.print(jobId);     // Catch: Throwable -> L18
        pw.println(")");     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        return JobSchedulerShellCommand.CMD_ERR_NO_JOB;
    L25:
        Pair<Long, Long> bytes = this.mConcurrencyManager.getEstimatedNetworkBytesLocked(pkgName, uid, namespace, jobId);     // Catch: Throwable -> L18
        if (bytes != null) goto L28;
        long downloadBytes = js.getEstimatedNetworkDownloadBytes();     // Catch: Throwable -> L18
        long uploadBytes = js.getEstimatedNetworkUploadBytes();     // Catch: Throwable -> L18
    L29:
        if (byteOption != 0) goto L31;
        pw.println(downloadBytes);     // Catch: Throwable -> L18
    L32:
        pw.println();     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        goto L37
    L31:
        pw.println(uploadBytes);     // Catch: Throwable -> L18
        goto L32
    L28:
        downloadBytes = ((Long) bytes.first).longValue();     // Catch: Throwable -> L18
        uploadBytes = ((Long) bytes.second).longValue();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L11
    L6:
        r2 = 0;
    L37:
        return 0;
    }

    int getTransferredNetworkBytes(PrintWriter pw, String pkgName, int userId, String namespace, int jobId, int byteOption) {
        IPackageManager r1 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L11
        if (userId == (-1)) goto L6;
        int r2 = userId;
    L7:
        int uid = r1.getPackageUid(pkgName, 0, r2);     // Catch: RemoteException -> L11
        if (uid >= 0) goto L13;
        pw.print("unknown(");     // Catch: RemoteException -> L11
        pw.print(pkgName);     // Catch: RemoteException -> L11
        pw.println(")");     // Catch: RemoteException -> L11
        return -1000;
    L13:
        Object r3 = this.mLock;     // Catch: RemoteException -> L11
        monitor-enter(r3);     // Catch: RemoteException -> L11
        JobStatus js = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.d("JobScheduler", "get-transferred-network-bytes " + uid + namespace + "//" + jobId + ": " + js);     // Catch: Throwable -> L18
    L20:
        if (js != null) goto L25;
        pw.print("unknown(");     // Catch: Throwable -> L18
        UserHandle.formatUid(pw, uid);     // Catch: Throwable -> L18
        pw.print("/jid");     // Catch: Throwable -> L18
        pw.print(jobId);     // Catch: Throwable -> L18
        pw.println(")");     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        return JobSchedulerShellCommand.CMD_ERR_NO_JOB;
    L25:
        Pair<Long, Long> bytes = this.mConcurrencyManager.getTransferredNetworkBytesLocked(pkgName, uid, namespace, jobId);     // Catch: Throwable -> L18
        if (bytes != null) goto L28;
        long downloadBytes = 0;
        long uploadBytes = 0;
    L29:
        if (byteOption != 0) goto L31;
        pw.println(downloadBytes);     // Catch: Throwable -> L18
    L32:
        pw.println();     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        goto L37
    L31:
        pw.println(uploadBytes);     // Catch: Throwable -> L18
        goto L32
    L28:
        downloadBytes = ((Long) bytes.first).longValue();     // Catch: Throwable -> L18
        uploadBytes = ((Long) bytes.second).longValue();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L11
    L6:
        r2 = 0;
    L37:
        return 0;
    }

    private boolean checkRunUserInitiatedJobsPermission(int packageUid, String packageName) {
        if (getRunUserInitiatedJobsPermissionState(packageUid, packageName) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int getRunUserInitiatedJobsPermissionState(int packageUid, String packageName) {
        return PermissionChecker.checkPermissionForPreflight(getTestableContext(), "android.permission.RUN_USER_INITIATED_JOBS", -1, packageUid, packageName);
    }

    protected ConnectivityController getConnectivityController() {
        return this.mConnectivityController;
    }

    protected QuotaController getQuotaController() {
        return this.mQuotaController;
    }

    protected void waitOnAsyncLoadingForTesting() throws Exception {
        this.mStartControllerTrackingLatch.await();
    }

    int getJobWakelockTag(PrintWriter pw, String pkgName, int userId, String namespace, int jobId) {
        IPackageManager r1 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L11
        if (userId == (-1)) goto L6;
        int r2 = userId;
    L7:
        int uid = r1.getPackageUid(pkgName, 0, r2);     // Catch: RemoteException -> L11
        if (uid >= 0) goto L13;
        pw.print("unknown(");     // Catch: RemoteException -> L11
        pw.print(pkgName);     // Catch: RemoteException -> L11
        pw.println(")");     // Catch: RemoteException -> L11
        return -1000;
    L13:
        Object r3 = this.mLock;     // Catch: RemoteException -> L11
        monitor-enter(r3);     // Catch: RemoteException -> L11
        JobStatus js = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.d("JobScheduler", "get-job-wakelock-tag " + namespace + SliceClientPermissions.SliceAuthority.DELIMITER + uid + SliceClientPermissions.SliceAuthority.DELIMITER + jobId + ": " + js);     // Catch: Throwable -> L18
    L20:
        if (js != null) goto L25;
        pw.print("unknown(");     // Catch: Throwable -> L18
        UserHandle.formatUid(pw, uid);     // Catch: Throwable -> L18
        pw.print("/jid");     // Catch: Throwable -> L18
        pw.print(jobId);     // Catch: Throwable -> L18
        pw.println(")");     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        return JobSchedulerShellCommand.CMD_ERR_NO_JOB;
    L25:
        pw.println(js.getWakelockTag());     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L11
    L6:
        r2 = 0;
    L30:
        return 0;
    }

    int getJobState(PrintWriter pw, String pkgName, int userId, String namespace, int jobId) {
        IPackageManager r0 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L88
        if (userId == (-1)) goto L7;
        int r6 = userId;
    L93:
        int uid = r0.getPackageUid(pkgName, 0, r6);     // Catch: RemoteException -> L13
        if (uid >= 0) goto L15;
        pw.print("unknown(");     // Catch: RemoteException -> L13
        pw.print(pkgName);     // Catch: RemoteException -> L13
        pw.println(")");     // Catch: RemoteException -> L13
        return -1000;
    L15:
        Object r8 = this.mLock;     // Catch: RemoteException -> L13
        monitor-enter(r8);     // Catch: RemoteException -> L13
        JobStatus js = this.mJobs.getJobByUidAndJobId(uid, namespace, jobId);     // Catch: Throwable -> L66
        if (DEBUG == true) goto L94;
    L22:
        if (js != null) goto L27;
        pw.print("unknown(");     // Catch: Throwable -> L20
        UserHandle.formatUid(pw, uid);     // Catch: Throwable -> L20
        pw.print("/jid");     // Catch: Throwable -> L20
        pw.print(jobId);     // Catch: Throwable -> L20
        pw.println(")");     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        return JobSchedulerShellCommand.CMD_ERR_NO_JOB;
    L27:
        boolean printed = false;
        if (this.mPendingJobQueue.contains(js) == false) goto L33;
        pw.print("pending");     // Catch: Throwable -> L20
        printed = true;
    L33:
        if (this.mConcurrencyManager.isJobRunningLocked(js) == false) goto L38;
        if (printed == false) goto L36;
        pw.print(" ");     // Catch: Throwable -> L20
    L36:
        printed = true;
        pw.println(DomainVerificationPersistence.TAG_ACTIVE);     // Catch: Throwable -> L20
    L38:
        if (ArrayUtils.contains(this.mStartedUsers, js.getUserId()) == true) goto L43;
        if (printed == false) goto L41;
        pw.print(" ");     // Catch: Throwable -> L20
    L41:
        printed = true;
        pw.println("user-stopped");     // Catch: Throwable -> L20
    L43:
        if (ArrayUtils.contains(this.mStartedUsers, js.getSourceUserId()) == true) goto L48;
        if (printed == false) goto L46;
        pw.print(" ");     // Catch: Throwable -> L20
    L46:
        printed = true;
        pw.println("source-user-stopped");     // Catch: Throwable -> L20
    L48:
        if (this.mBackingUpUids.get(js.getSourceUid()) == false) goto L53;
        if (printed == false) goto L51;
        pw.print(" ");     // Catch: Throwable -> L20
    L51:
        pw.println("backing-up");     // Catch: Throwable -> L20
        boolean printed2 = true;
    L54:
        boolean componentPresent = false;
        int r16 = 0;
        if (AppGlobals.getPackageManager().getServiceInfo(js.getServiceComponent(), 268435456, js.getUserId()) == null) goto L60;
        boolean r1 = true;
    L61:
        componentPresent = r1;
        goto L70
    L60:
        r1 = false;
    L70:
        if (componentPresent == true) goto L75;
        if (printed2 == false) goto L73;
        pw.print(" ");     // Catch: Throwable -> L62
    L73:
        printed2 = true;
        pw.println("no-component");     // Catch: Throwable -> L62
    L75:
        if (js.isReady() == false) goto L79;
        if (printed2 == false) goto L78;
        pw.print(" ");     // Catch: Throwable -> L62
    L78:
        printed2 = true;
        pw.println("ready");     // Catch: Throwable -> L62
    L79:
        if (printed2 == true) goto L81;
        pw.print("waiting");     // Catch: Throwable -> L62
    L81:
        pw.println();     // Catch: Throwable -> L62
        monitor-exit(r8);     // Catch: Throwable -> L62
        return r16;
    L69:
        r16 = 0;
        goto L70
    L53:
        printed2 = printed;
        goto L54
    L94:
        Slog.d("JobScheduler", "get-job-state " + namespace + SliceClientPermissions.SliceAuthority.DELIMITER + uid + SliceClientPermissions.SliceAuthority.DELIMITER + jobId + ": " + js);     // Catch: Throwable -> L20
    L20:
        th = th;
        int r17 = 0;
    L84:
        monitor-exit(r8);     // Catch: Throwable -> L62
        throw th;     // Catch: RemoteException -> L86
    L104:
        return r17;
    L66:
        th = th;
        r17 = 0;
    L62:
        th = th;
        goto L84
    L7:
        r6 = 0;
    L90:
        return 0;
    }

    void resetExecutionQuota(String pkgName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mQuotaController.clearAppStatsLocked(userId, pkgName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void resetScheduleQuota() {
        this.mQuotaTracker.clear();
    }

    void triggerDockState(boolean idleState) {
        if (idleState == false) goto L4;
        Intent dockIntent = new Intent("android.intent.action.DOCK_IDLE");
    L5:
        dockIntent.setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME);
        dockIntent.addFlags(1342177280);
        getContext().sendBroadcastAsUser(dockIntent, UserHandle.ALL);
        return;
    L4:
        dockIntent = new Intent("android.intent.action.DOCK_ACTIVE");
        goto L5
    }

    static void dumpHelp(PrintWriter pw) {
        pw.println("Job Scheduler (jobscheduler) dump options:");
        pw.println("  [-h] [package] [--proto] ...");
        pw.println("    -h: print this help");
        pw.println("  [package] is an optional package name to limit the output to.");
        pw.println("    --proto: output dump in protocol buffer format.");
    }

    private static void sortJobs(List<JobStatus> jobs) {
        Collections.sort(jobs, new AnonymousClass6());
    }

    @NeverCompile
    void dumpInternal(IndentingPrintWriter pw, int filterUid) {
        final int filterAppId = UserHandle.getAppId(filterUid);
        long now = sSystemClock.millis();
        long nowElapsed = sElapsedRealtimeClock.millis();
        long nowUptime = sUptimeMillisClock.millis();
        Predicate<JobStatus> predicate = new JobSchedulerService$$ExternalSyntheticLambda11(filterAppId);
        Object r13 = this.mLock;
        monitor-enter(r13);
        this.mConstants.dump(pw);     // Catch: Throwable -> L223
        Iterator<StateController> r0 = this.mControllers.iterator();     // Catch: Throwable -> L223
    L6:
        if (r0.hasNext() == false) goto L11;
        StateController controller = r0.next();     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        controller.dumpConstants(pw);     // Catch: Throwable -> L9
        pw.decreaseIndent();     // Catch: Throwable -> L9
    L9:
        th = th;
    L229:
        monitor-exit(r13);     // Catch: Throwable -> L185
        throw th;
    L11:
        pw.println();     // Catch: Throwable -> L223
        pw.println("Aconfig flags:");     // Catch: Throwable -> L223
        pw.increaseIndent();     // Catch: Throwable -> L223
        pw.print(Flags.FLAG_BATCH_ACTIVE_BUCKET_JOBS, false);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print(Flags.FLAG_BATCH_CONNECTIVITY_JOBS_PER_NETWORK, false);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print(Flags.FLAG_DO_NOT_FORCE_RUSH_EXECUTION_AT_BOOT, false);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print("android.app.job.ignore_important_while_foreground", true);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print("android.app.job.get_pending_job_reasons_api", true);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print("android.app.job.get_pending_job_reasons_history_api", true);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print("android.app.job.add_type_info_to_wakelock_tag", true);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.decreaseIndent();     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        int i = this.mJobRestrictions.size() - 1;
    L13:
        if (i < 0) goto L17;
        this.mJobRestrictions.get(i).dumpConstants(pw);     // Catch: Throwable -> L9
        i = i - 1;
        goto L13
    L17:
        pw.println();     // Catch: Throwable -> L223
        this.mQuotaTracker.dump(pw);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print("Power connected: ");     // Catch: Throwable -> L223
        pw.println(this.mBatteryStateTracker.isPowerConnected());     // Catch: Throwable -> L223
        pw.print("Battery charging: ");     // Catch: Throwable -> L223
        pw.println(BatteryStateTracker.m4851$$Nest$fgetmCharging(this.mBatteryStateTracker));     // Catch: Throwable -> L223
        pw.print("Considered charging: ");     // Catch: Throwable -> L223
        pw.println(BatteryStateTracker.m4852$$Nest$misConsideredCharging(this.mBatteryStateTracker));     // Catch: Throwable -> L223
        pw.print("Battery level: ");     // Catch: Throwable -> L223
        pw.println(BatteryStateTracker.m4850$$Nest$fgetmBatteryLevel(this.mBatteryStateTracker));     // Catch: Throwable -> L223
        pw.print("Battery not low: ");     // Catch: Throwable -> L223
        pw.println(this.mBatteryStateTracker.isBatteryNotLow());     // Catch: Throwable -> L223
        if (this.mBatteryStateTracker.isMonitoring() == false) goto L20;
        pw.print("MONITORING: seq=");     // Catch: Throwable -> L9
        pw.println(this.mBatteryStateTracker.getSeq());     // Catch: Throwable -> L9
    L20:
        pw.println();     // Catch: Throwable -> L223
        pw.println("Started users: " + Arrays.toString(this.mStartedUsers));     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print("Media Cloud Providers: ");     // Catch: Throwable -> L223
        pw.println(this.mCloudMediaProviderPackages);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L223
        pw.print("Registered ");     // Catch: Throwable -> L223
        pw.print(this.mJobs.size());     // Catch: Throwable -> L223
        pw.println(" jobs:");     // Catch: Throwable -> L223
        pw.increaseIndent();     // Catch: Throwable -> L223
        boolean jobPrinted = false;
        if (this.mJobs.size() > 0) goto L250;
        long nowUptime2 = nowUptime;
    L67:
        if (jobPrinted == true) goto L246;
        pw.println("None.");     // Catch: Throwable -> L40
    L246:
        pw.decreaseIndent();     // Catch: Throwable -> L227
        int i2 = 0;
    L71:
        if (i2 >= this.mControllers.size()) goto L74;
        pw.println();     // Catch: Throwable -> L40
        pw.println(this.mControllers.get(i2).getClass().getSimpleName() + ":");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
        this.mControllers.get(i2).dumpControllerStateLocked(pw, predicate);     // Catch: Throwable -> L40
        pw.decreaseIndent();     // Catch: Throwable -> L40
        i2 = i2 + 1;
        goto L71
    L74:
        int i3 = 0;
        boolean procStatePrinted = false;
    L77:
        if (i3 >= this.mUidProcStates.size()) goto L87;
        int uid = this.mUidProcStates.keyAt(i3);     // Catch: Throwable -> L40
        if (filterAppId != (-1)) goto L81;
    L82:
        if (procStatePrinted == true) goto L84;
        procStatePrinted = true;
        pw.println();     // Catch: Throwable -> L40
        pw.println("Uid proc states:");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
    L84:
        pw.print(UserHandle.formatUid(uid));     // Catch: Throwable -> L40
        pw.print(": ");     // Catch: Throwable -> L40
        pw.println(ActivityManager.procStateToString(this.mUidProcStates.valueAt(i3)));     // Catch: Throwable -> L40
    L85:
        i3 = i3 + 1;     // Catch: Throwable -> L40
        goto L77
    L81:
        if (filterAppId != UserHandle.getAppId(uid)) goto L85;
    L87:
        if (procStatePrinted == false) goto L89;
        pw.decreaseIndent();     // Catch: Throwable -> L40
    L89:
        int i4 = 0;
        boolean overridePrinted = false;
    L91:
        if (i4 >= this.mUidBiasOverride.size()) goto L101;
        int uid2 = this.mUidBiasOverride.keyAt(i4);     // Catch: Throwable -> L40
        if (filterAppId != (-1)) goto L95;
    L96:
        if (overridePrinted == true) goto L98;
        overridePrinted = true;
        pw.println();     // Catch: Throwable -> L40
        pw.println("Uid bias overrides:");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
    L98:
        pw.print(UserHandle.formatUid(uid2));     // Catch: Throwable -> L40
        pw.print(": ");     // Catch: Throwable -> L40
        pw.println(this.mUidBiasOverride.valueAt(i4));     // Catch: Throwable -> L40
    L99:
        i4 = i4 + 1;     // Catch: Throwable -> L40
        goto L91
    L95:
        if (filterAppId != UserHandle.getAppId(uid2)) goto L99;
    L101:
        if (overridePrinted == false) goto L103;
        pw.decreaseIndent();     // Catch: Throwable -> L40
    L103:
        int i5 = 0;
        boolean capabilitiesPrinted = false;
    L105:
        if (i5 >= this.mUidCapabilities.size()) goto L115;
        int uid3 = this.mUidCapabilities.keyAt(i5);     // Catch: Throwable -> L40
        if (filterAppId != (-1)) goto L109;
    L110:
        if (capabilitiesPrinted == true) goto L112;
        capabilitiesPrinted = true;
        pw.println();     // Catch: Throwable -> L40
        pw.println("Uid capabilities:");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
    L112:
        pw.print(UserHandle.formatUid(uid3));     // Catch: Throwable -> L40
        pw.print(": ");     // Catch: Throwable -> L40
        pw.println(ActivityManager.getCapabilitiesSummary(this.mUidCapabilities.valueAt(i5)));     // Catch: Throwable -> L40
    L113:
        i5 = i5 + 1;     // Catch: Throwable -> L40
        goto L105
    L109:
        if (filterAppId != UserHandle.getAppId(uid3)) goto L113;
    L115:
        if (capabilitiesPrinted == false) goto L117;
        pw.decreaseIndent();     // Catch: Throwable -> L40
    L117:
        int i6 = 0;
        boolean uidMapPrinted = false;
    L119:
        if (i6 >= this.mUidToPackageCache.size()) goto L129;
        int uid4 = this.mUidToPackageCache.keyAt(i6);     // Catch: Throwable -> L40
        if (filterUid == (-1)) goto L124;
        if (filterUid == uid4) goto L124;
    L127:
        i6 = i6 + 1;     // Catch: Throwable -> L40
    L124:
        if (uidMapPrinted == true) goto L126;
        uidMapPrinted = true;
        pw.println();     // Catch: Throwable -> L40
        pw.println("Cached UID->package map:");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
    L126:
        pw.print(uid4);     // Catch: Throwable -> L40
        pw.print(": ");     // Catch: Throwable -> L40
        pw.println(this.mUidToPackageCache.get(uid4));     // Catch: Throwable -> L40
        goto L127
    L129:
        if (uidMapPrinted == false) goto L131;
        pw.decreaseIndent();     // Catch: Throwable -> L40
    L131:
        int i7 = 0;
        boolean backingPrinted = false;
    L133:
        if (i7 >= this.mBackingUpUids.size()) goto L144;
        int uid5 = this.mBackingUpUids.keyAt(i7);     // Catch: Throwable -> L40
        if (filterAppId != (-1)) goto L137;
    L138:
        if (backingPrinted == true) goto L140;
        pw.println();     // Catch: Throwable -> L40
        pw.println("Backing up uids:");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
        backingPrinted = true;
    L141:
        pw.print(UserHandle.formatUid(uid5));     // Catch: Throwable -> L40
    L142:
        i7 = i7 + 1;     // Catch: Throwable -> L40
        goto L133
    L140:
        pw.print(", ");     // Catch: Throwable -> L40
        goto L141
    L137:
        if (filterAppId != UserHandle.getAppId(uid5)) goto L142;
    L144:
        if (backingPrinted == false) goto L146;
        pw.decreaseIndent();     // Catch: Throwable -> L40
        pw.println();     // Catch: Throwable -> L40
    L146:
        pw.println();     // Catch: Throwable -> L227
        this.mJobPackageTracker.dump(pw, filterAppId);     // Catch: Throwable -> L227
        pw.println();     // Catch: Throwable -> L227
        if (this.mJobPackageTracker.dumpHistory(pw, filterAppId) == false) goto L150;
        pw.println();     // Catch: Throwable -> L40
    L40:
        th = th;
    L150:
        pw.println("Pending queue:");     // Catch: Throwable -> L227
        pw.increaseIndent();     // Catch: Throwable -> L227
        this.mPendingJobQueue.resetIterator();     // Catch: Throwable -> L227
        boolean pendingPrinted = false;
        int pendingIdx = 0;
    L151:
        JobStatus job = this.mPendingJobQueue.next();     // Catch: Throwable -> L227
        if (job == null) goto L167;
        pendingIdx = pendingIdx + 1;
    L165:
        th = th;
        goto L229
    L156:
        if (predicate.test(job) == false) goto L151;
        if (pendingPrinted == true) goto L160;
        pendingPrinted = true;
    L160:
        pw.print("Pending #");     // Catch: Throwable -> L165
        pw.print(pendingIdx);     // Catch: Throwable -> L165
        pw.print(": ");     // Catch: Throwable -> L165
        pw.println(job.toShortString());     // Catch: Throwable -> L165
        pw.increaseIndent();     // Catch: Throwable -> L165
        job.dump(pw, false, nowElapsed);     // Catch: Throwable -> L165
        int bias = evaluateJobBiasLocked(job);     // Catch: Throwable -> L165
        pw.print("Evaluated bias: ");     // Catch: Throwable -> L165
        pw.println(JobInfo.getBiasString(bias));     // Catch: Throwable -> L165
        pw.print("Enq: ");     // Catch: Throwable -> L165
        long nowElapsed2 = nowElapsed;
        Predicate<JobStatus> predicate2 = predicate;
        TimeUtils.formatDuration(job.madePending - nowUptime2, pw);     // Catch: Throwable -> L163
        pw.decreaseIndent();     // Catch: Throwable -> L163
        pw.println();     // Catch: Throwable -> L163
        predicate = predicate2;
        nowElapsed = nowElapsed2;
    L163:
        th = th;
        goto L229
    L167:
        nowElapsed2 = nowElapsed;
        predicate2 = predicate;
        if (pendingPrinted == true) goto L231;
        pw.println(KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG);     // Catch: Throwable -> L163
    L231:
        pw.decreaseIndent();     // Catch: Throwable -> L225
        pw.println();     // Catch: Throwable -> L225
        predicate = predicate2;
        nowUptime = nowUptime2;
        this.mConcurrencyManager.dumpContextInfoLocked(pw, predicate, nowElapsed2, nowUptime);     // Catch: Throwable -> L223
        pw.println();     // Catch: Throwable -> L187
        pw.println("Recently completed jobs:");     // Catch: Throwable -> L187
        pw.increaseIndent();     // Catch: Throwable -> L187
        int r = 1;
        JobStatus job2 = job;
        boolean recentPrinted = false;
    L176:
        if (r > 20) goto L191;
        int idx = ((this.mLastCompletedJobIndex + 20) - r) % 20;     // Catch: Throwable -> L187
        job2 = this.mLastCompletedJobs[idx];     // Catch: Throwable -> L187
        if (job2 == null) goto L245;
        if (predicate.test(job2) == false) goto L245;
        TimeUtils.formatDuration(this.mLastCompletedJobTimeElapsed[idx], nowElapsed2, pw);     // Catch: Throwable -> L185
        pw.println();     // Catch: Throwable -> L185
        pw.increaseIndent();     // Catch: Throwable -> L185
        pw.increaseIndent();     // Catch: Throwable -> L185
        pw.println(job2.toShortString());     // Catch: Throwable -> L185
        job2.dump(pw, true, nowElapsed2);     // Catch: Throwable -> L185
        pw.decreaseIndent();     // Catch: Throwable -> L185
        pw.decreaseIndent();     // Catch: Throwable -> L185
        recentPrinted = true;
    L245:
        r = r + 1;     // Catch: Throwable -> L185
        jobPrinted = jobPrinted;
        filterAppId = filterAppId;
        now = now;
    L185:
        th = th;
        goto L229
    L191:
        long now2 = now;
        if (recentPrinted == true) goto L194;
        pw.println(KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG);     // Catch: Throwable -> L185
    L194:
        pw.decreaseIndent();     // Catch: Throwable -> L185
        pw.println();     // Catch: Throwable -> L185
        boolean recentCancellationsPrinted = false;
        int r2 = 1;
    L196:
        if (r2 > this.mLastCancelledJobs.length) goto L208;
        int idx2 = ((this.mLastCancelledJobIndex + this.mLastCancelledJobs.length) - r2) % this.mLastCancelledJobs.length;     // Catch: Throwable -> L185
        JobStatus job3 = this.mLastCancelledJobs[idx2];     // Catch: Throwable -> L185
        if (job3 == null) goto L206;
        if (predicate.test(job3) == false) goto L206;
        if (recentCancellationsPrinted == true) goto L204;
        pw.println();     // Catch: Throwable -> L185
        pw.println("Recently cancelled jobs:");     // Catch: Throwable -> L185
        pw.increaseIndent();     // Catch: Throwable -> L185
        recentCancellationsPrinted = true;
    L204:
        TimeUtils.formatDuration(this.mLastCancelledJobTimeElapsed[idx2], nowElapsed2, pw);     // Catch: Throwable -> L185
        pw.println();     // Catch: Throwable -> L185
        pw.increaseIndent();     // Catch: Throwable -> L185
        pw.increaseIndent();     // Catch: Throwable -> L185
        pw.println(job3.toShortString());     // Catch: Throwable -> L185
        job3.dump(pw, true, nowElapsed2);     // Catch: Throwable -> L185
        pw.decreaseIndent();     // Catch: Throwable -> L185
        pw.decreaseIndent();     // Catch: Throwable -> L185
    L206:
        r2 = r2 + 1;     // Catch: Throwable -> L185
        goto L196
    L208:
        if (recentCancellationsPrinted == true) goto L211;
        pw.decreaseIndent();     // Catch: Throwable -> L185
        pw.println();     // Catch: Throwable -> L185
    L211:
        if (filterUid != (-1)) goto L213;
        pw.println();     // Catch: Throwable -> L185
        pw.print("mReadyToRock=");     // Catch: Throwable -> L185
        pw.println(this.mReadyToRock);     // Catch: Throwable -> L185
        pw.print("mReportedActive=");     // Catch: Throwable -> L185
        pw.println(this.mReportedActive);     // Catch: Throwable -> L185
    L213:
        pw.println();     // Catch: Throwable -> L185
        this.mConcurrencyManager.dumpLocked(pw, now2, nowElapsed2);     // Catch: Throwable -> L221
        pw.println();     // Catch: Throwable -> L185
        pw.print("PersistStats: ");     // Catch: Throwable -> L185
        pw.println(this.mJobs.getPersistStats());     // Catch: Throwable -> L185
        monitor-exit(r13);     // Catch: Throwable -> L185
        pw.println();
        return;
    L221:
        th = th;
    L187:
        th = th;
    L225:
        th = th;
    L227:
        th = th;
        goto L229
    L250:
        List<JobStatus> jobs = this.mJobs.mJobSet.getAllJobs();     // Catch: Throwable -> L45
        sortJobs(jobs);     // Catch: Throwable -> L45
        Iterator<JobStatus> r16 = jobs.iterator();     // Catch: Throwable -> L45
    L24:
        if (r16.hasNext() == false) goto L65;
        JobStatus job4 = r16.next();     // Catch: Throwable -> L45
        if (predicate.test(job4) == false) goto L24;
        pw.print("JOB ");     // Catch: Throwable -> L45
        job4.printUniqueId(pw);     // Catch: Throwable -> L45
        pw.print(": ");     // Catch: Throwable -> L45
        pw.println(job4.toShortStringExceptUniqueId());     // Catch: Throwable -> L45
        pw.increaseIndent();     // Catch: Throwable -> L45
        job4.dump(pw, true, nowElapsed);     // Catch: Throwable -> L45
        pw.print("Restricted due to:");     // Catch: Throwable -> L45
        if (checkIfRestricted(job4) == null) goto L31;
        boolean isRestricted = true;
    L32:
        if (isRestricted == false) goto L47;
        int i8 = this.mJobRestrictions.size() - 1;
    L35:
        if (i8 < 0) goto L44;
        long nowUptime3 = nowUptime;
        JobRestriction restriction = this.mJobRestrictions.get(i8);     // Catch: Throwable -> L40
        if (restriction.isJobRestricted(job4, evaluateJobBiasLocked(job4)) == false) goto L43;
        int reason = restriction.getInternalReason();     // Catch: Throwable -> L40
        pw.print(" ");     // Catch: Throwable -> L40
        pw.print(JobParameters.getInternalReasonCodeDescription(reason));     // Catch: Throwable -> L40
    L43:
        i8 = i8 - 1;     // Catch: Throwable -> L40
        nowUptime = nowUptime3;
        goto L35
    L44:
        long nowUptime4 = nowUptime;
    L48:
        pw.println(".");     // Catch: Throwable -> L40
        pw.print("Ready: ");     // Catch: Throwable -> L40
        pw.print(isReadyToBeExecutedLocked(job4));     // Catch: Throwable -> L40
        pw.print(" (job=");     // Catch: Throwable -> L40
        pw.print(job4.isReady());     // Catch: Throwable -> L40
        pw.print(" user=");     // Catch: Throwable -> L40
        pw.print(areUsersStartedLocked(job4));     // Catch: Throwable -> L40
        pw.print(" !restricted=");     // Catch: Throwable -> L40
        if (isRestricted == true) goto L51;
        boolean r1 = true;
    L52:
        pw.print(r1);     // Catch: Throwable -> L40
        pw.print(" !pending=");     // Catch: Throwable -> L40
        if (this.mPendingJobQueue.contains(job4) == true) goto L55;
        boolean r3 = true;
    L56:
        pw.print(r3);     // Catch: Throwable -> L40
        pw.print(" !active=");     // Catch: Throwable -> L40
        if (this.mConcurrencyManager.isJobRunningLocked(job4) == true) goto L59;
        boolean r4 = true;
    L60:
        pw.print(r4);     // Catch: Throwable -> L40
        pw.print(" !backingup=");     // Catch: Throwable -> L40
        if (this.mBackingUpUids.get(job4.getSourceUid()) == true) goto L63;
        boolean r5 = true;
    L64:
        pw.print(r5);     // Catch: Throwable -> L40
        pw.print(" comp=");     // Catch: Throwable -> L40
        pw.print(isComponentUsable(job4));     // Catch: Throwable -> L40
        pw.println(")");     // Catch: Throwable -> L40
        pw.decreaseIndent();     // Catch: Throwable -> L40
        jobPrinted = true;
        nowUptime = nowUptime4;
        goto L24
    L63:
        r5 = false;
        goto L64
    L59:
        r4 = false;
        goto L60
    L55:
        r3 = false;
        goto L56
    L51:
        r1 = false;
        goto L52
    L47:
        nowUptime4 = nowUptime;
        pw.print(" none");     // Catch: Throwable -> L40
        goto L48
    L31:
        isRestricted = false;
        goto L32
    L65:
        nowUptime2 = nowUptime;
    L45:
        th = th;
    L223:
        th = th;
        goto L229
    }

    private static /* synthetic */ boolean lambda$dumpInternal$9(int filterAppId, JobStatus js) {
        if (filterAppId != (-1)) goto L5;
    L10:
        return true;
    L5:
        if (UserHandle.getAppId(js.getUid()) == filterAppId) goto L10;
        if (UserHandle.getAppId(js.getSourceUid()) == filterAppId) goto L10;
        return false;
    }

    void dumpInternalProto(FileDescriptor fd, int filterUid) {
        JobSchedulerService r1 = this;
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        final int filterAppId = UserHandle.getAppId(filterUid);
        long now = sSystemClock.millis();
        long nowElapsed = sElapsedRealtimeClock.millis();
        long nowUptime = sUptimeMillisClock.millis();
        Predicate<JobStatus> predicate = new JobSchedulerService$$ExternalSyntheticLambda8(filterAppId);
        Object r3 = r1.mLock;
        monitor-enter(r3);
        long settingsToken = proto.start(1146756268033L);     // Catch: Throwable -> L127
        r1.mConstants.dump(proto);     // Catch: Throwable -> L127
        Iterator<StateController> r0 = r1.mControllers.iterator();     // Catch: Throwable -> L127
    L6:
        if (r0.hasNext() == false) goto L12;
        StateController controller = r0.next();     // Catch: Throwable -> L10
        controller.dumpConstants(proto);     // Catch: Throwable -> L10
    L10:
        th = th;
        Object r22 = r3;
    L129:
        monitor-exit(r22);     // Catch: Throwable -> L115
        throw th;
    L12:
        long now2 = nowElapsed;
        long settingsToken2 = settingsToken;
        proto.end(settingsToken2);     // Catch: Throwable -> L125
        int i = r1.mJobRestrictions.size() - 1;
    L15:
        if (i < 0) goto L21;
        r1.mJobRestrictions.get(i).dumpConstants(proto);     // Catch: Throwable -> L18
        i = i - 1;
    L18:
        th = th;
        r22 = r3;
        goto L129
    L21:
        int[] r2 = r1.mStartedUsers;     // Catch: Throwable -> L125
        int r9 = r2.length;     // Catch: Throwable -> L125
        int r5 = 0;
    L23:
        if (r5 >= r9) goto L30;
        int u = r2[r5];     // Catch: Throwable -> L18
        r22 = r3;
        proto.write(2220498092034L, u);     // Catch: Throwable -> L28
        r5 = r5 + 1;
        r3 = r22;
    L28:
        th = th;
        goto L129
    L30:
        r22 = r3;
        r1.mQuotaTracker.dump(proto, 1146756268054L);     // Catch: Throwable -> L123
        if (r1.mJobs.size() > 0) goto L143;
        long nowElapsed2 = now2;
        long nowElapsed3 = now;
    L139:
        Iterator<StateController> r4 = r1.mControllers.iterator();     // Catch: Throwable -> L121
    L62:
        if (r4.hasNext() == false) goto L65;
        StateController controller2 = r4.next();     // Catch: Throwable -> L50
        controller2.dumpControllerStateLocked(proto, 2246267895812L, predicate);     // Catch: Throwable -> L50
        goto L62
    L65:
        int i2 = 0;
    L68:
        if (i2 >= r1.mUidBiasOverride.size()) goto L75;
        int uid = r1.mUidBiasOverride.keyAt(i2);     // Catch: Throwable -> L50
        if (filterAppId != (-1)) goto L72;
    L73:
        long pToken = proto.start(2246267895813L);     // Catch: Throwable -> L50
        proto.write(1120986464257L, uid);     // Catch: Throwable -> L50
        proto.write(1172526071810L, r1.mUidBiasOverride.valueAt(i2));     // Catch: Throwable -> L50
        proto.end(pToken);     // Catch: Throwable -> L50
    L74:
        i2 = i2 + 1;
        goto L68
    L72:
        if (filterAppId != UserHandle.getAppId(uid)) goto L74;
    L75:
        int i3 = 0;
    L77:
        if (i3 >= r1.mBackingUpUids.size()) goto L85;
        int uid2 = r1.mBackingUpUids.keyAt(i3);     // Catch: Throwable -> L50
        if (filterAppId != (-1)) goto L81;
    L82:
        proto.write(2220498092038L, uid2);     // Catch: Throwable -> L50
    L83:
        i3 = i3 + 1;
        goto L77
    L81:
        if (filterAppId != UserHandle.getAppId(uid2)) goto L83;
    L50:
        th = th;
        goto L129
    L85:
        r1.mJobPackageTracker.dump(proto, 1146756268040L, filterAppId);     // Catch: Throwable -> L121
        r1.mJobPackageTracker.dumpHistory(proto, 1146756268039L, filterAppId);     // Catch: Throwable -> L121
        r1.mPendingJobQueue.resetIterator();     // Catch: Throwable -> L121
    L86:
        JobStatus job = r1.mPendingJobQueue.next();     // Catch: Throwable -> L121
        if (job == null) goto L99;
        long pjToken = proto.start(2246267895817L);     // Catch: Throwable -> L97
        job.writeToShortProto(proto, 1146756268033L);     // Catch: Throwable -> L97
        long nowElapsed4 = nowElapsed2;
        job.dump(proto, 1146756268034L, false, nowElapsed4);     // Catch: Throwable -> L94
        proto.write(1172526071811L, r1.evaluateJobBiasLocked(job));     // Catch: Throwable -> L94
        proto.write(1112396529668L, nowUptime - job.madePending);     // Catch: Throwable -> L94
        proto.end(pjToken);     // Catch: Throwable -> L94
        r1 = this;
        nowElapsed2 = nowElapsed4;
    L94:
        th = th;
    L97:
        th = th;
        goto L129
    L99:
        long nowElapsed5 = nowElapsed2;
        if (filterUid != (-1)) goto L106;
        JobSchedulerService r12 = this;
        proto.write(1133871366155L, r12.mReadyToRock);     // Catch: Throwable -> L104
        proto.write(1133871366156L, r12.mReportedActive);     // Catch: Throwable -> L104
    L133:
        r12.mConcurrencyManager.dumpProtoLocked(proto, 1146756268052L, nowElapsed3, nowElapsed5);     // Catch: Throwable -> L117
        r12.mJobs.getPersistStats().dumpDebug(proto, 1146756268053L);     // Catch: Throwable -> L115
        monitor-exit(r22);     // Catch: Throwable -> L115
        proto.flush();
        return;
    L117:
        th = th;
    L119:
        th = th;
    L104:
        th = th;
        goto L129
    L106:
        r12 = this;
    L121:
        th = th;
        goto L129
    L143:
        List<JobStatus> jobs = r1.mJobs.mJobSet.getAllJobs();     // Catch: Throwable -> L56
        sortJobs(jobs);     // Catch: Throwable -> L56
        Iterator<JobStatus> r23 = jobs.iterator();     // Catch: Throwable -> L56
    L35:
        if (r23.hasNext() == false) goto L58;
        JobStatus job2 = r23.next();     // Catch: Throwable -> L56
        long rjToken = proto.start(2246267895811L);     // Catch: Throwable -> L56
        job2.writeToShortProto(proto, 1146756268033L);     // Catch: Throwable -> L56
        if (predicate.test(job2) == false) goto L35;
        long settingsToken3 = settingsToken2;
        long nowElapsed6 = now2;
        long nowElapsed7 = now;
        job2.dump(proto, 1146756268034L, true, nowElapsed6);     // Catch: Throwable -> L52
        proto.write(1133871366154L, r1.isReadyToBeExecutedLocked(job2));     // Catch: Throwable -> L52
        proto.write(1133871366147L, job2.isReady());     // Catch: Throwable -> L52
        proto.write(1133871366148L, r1.areUsersStartedLocked(job2));     // Catch: Throwable -> L52
        if (r1.checkIfRestricted(job2) == null) goto L43;
        boolean r6 = true;
    L44:
        proto.write(1133871366155L, r6);     // Catch: Throwable -> L52
        proto.write(1133871366149L, r1.mPendingJobQueue.contains(job2));     // Catch: Throwable -> L52
        proto.write(1133871366150L, r1.mConcurrencyManager.isJobRunningLocked(job2));     // Catch: Throwable -> L52
        proto.write(1133871366151L, r1.mBackingUpUids.get(job2.getSourceUid()));     // Catch: Throwable -> L52
        proto.write(1133871366152L, r1.isComponentUsable(job2));     // Catch: Throwable -> L52
        Iterator<JobRestriction> r7 = r1.mJobRestrictions.iterator();     // Catch: Throwable -> L52
    L46:
        if (r7.hasNext() == false) goto L54;
        JobRestriction restriction = r7.next();     // Catch: Throwable -> L52
        long restrictionsToken = proto.start(2246267895820L);     // Catch: Throwable -> L52
        nowElapsed2 = nowElapsed6;
        proto.write(1159641169921L, restriction.getInternalReason());     // Catch: Throwable -> L50
        proto.write(1133871366146L, restriction.isJobRestricted(job2, r1.evaluateJobBiasLocked(job2)));     // Catch: Throwable -> L50
        proto.end(restrictionsToken);     // Catch: Throwable -> L50
        nowElapsed6 = nowElapsed2;
        goto L46
    L54:
        long nowElapsed8 = nowElapsed6;
        proto.end(rjToken);     // Catch: Throwable -> L50
        now = nowElapsed7;
        settingsToken2 = settingsToken3;
        now2 = nowElapsed8;
        goto L35
    L43:
        r6 = false;
    L52:
        th = th;
        goto L129
    L58:
        nowElapsed2 = now2;
        nowElapsed3 = now;
    L56:
        th = th;
    L123:
        th = th;
    L125:
        th = th;
        r22 = r3;
    L115:
        th = th;
    L127:
        th = th;
        r22 = r3;
        goto L129
    }

    private static /* synthetic */ boolean lambda$dumpInternalProto$10(int filterAppId, JobStatus js) {
        if (filterAppId != (-1)) goto L5;
    L10:
        return true;
    L5:
        if (UserHandle.getAppId(js.getUid()) == filterAppId) goto L10;
        if (UserHandle.getAppId(js.getSourceUid()) == filterAppId) goto L10;
        return false;
    }
}

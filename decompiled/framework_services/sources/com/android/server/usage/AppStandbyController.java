package com.android.server.usage;

import android.R;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.AppStandbyInfo;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.app.usage.UsageStatsManagerInternal;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.CrossProfileAppsInternal;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.hardware.display.DisplayManager;
import android.hardware.tv.mediaquality.ParameterName;
import android.net.NetworkScoreManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IDeviceIdleController;
import android.os.Looper;
import android.os.Message;
import android.os.PowerAdvisorInternal;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.SparseSetArray;
import android.util.TimeUtils;
import android.widget.Toast;
import com.android.internal.app.IAppOpsService;
import com.android.internal.app.IBatteryStats;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.internal.util.jobs.ConcurrentUtils;
import com.android.server.AlarmManagerInternal;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.LocalServices;
import com.android.server.am.HostingRecord;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.job.JobPackageTracker;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes3.dex */
public class AppStandbyController implements AppStandbyInternal, UsageStatsManagerInternal.UsageEventListener {
    static final boolean COMPRESS_TIME = false;
    static final boolean DEBUG = false;
    static final long[] DEFAULT_ELAPSED_TIME_THRESHOLDS = null;
    private static final long DEFAULT_PREDICTION_TIMEOUT = 43200000;
    static final long[] DEFAULT_SCREEN_TIME_THRESHOLDS = null;
    private static final int HEADLESS_APP_CHECK_FLAGS = 1835520;
    static final long[] MINIMUM_ELAPSED_TIME_THRESHOLDS = null;
    static final long[] MINIMUM_SCREEN_TIME_THRESHOLDS = null;
    static final int MSG_CHECK_IDLE_STATES = 5;
    static final int MSG_CHECK_PACKAGE_IDLE_STATE = 11;
    static final int MSG_FORCE_IDLE_STATE = 4;
    static final int MSG_INFORM_LISTENERS = 3;
    static final int MSG_ONE_TIME_CHECK_IDLE_STATES = 10;
    static final int MSG_PAROLE_STATE_CHANGED = 9;
    static final int MSG_REPORT_CONTENT_PROVIDER_USAGE = 8;
    static final int MSG_REPORT_EXEMPTED_SYNC_START = 13;
    static final int MSG_REPORT_SYNC_SCHEDULED = 12;
    static final int MSG_TRIGGER_LISTENER_QUOTA_BUMP = 7;
    private static final long NETWORK_SCORER_CACHE_DURATION_MILLIS = 5000;
    private static final long NOTIFICATION_SEEN_HOLD_DURATION_FOR_PRE_T_APPS = 43200000;
    private static final int NOTIFICATION_SEEN_PROMOTED_BUCKET_FOR_PRE_T_APPS = 20;
    private static final long ONE_DAY = 86400000;
    private static final long ONE_HOUR = 3600000;
    private static final long ONE_MINUTE = 60000;
    private static final int SYSTEM_PACKAGE_FLAGS = 542908416;
    private static final String TAG = "AppStandbyController";
    private static final int[] THRESHOLD_BUCKETS = null;
    private static final long WAIT_FOR_ADMIN_DATA_TIMEOUT_MS = 10000;
    private final SparseArray<Set<String>> mActiveAdminApps;
    private final CountDownLatch mAdminDataAvailableLatch;
    private final SparseArray<Set<String>> mAdminProtectedPackages;
    private volatile boolean mAppIdleEnabled;
    private AppIdleHistory mAppIdleHistory;
    private final Object mAppIdleLock;
    private AppOpsManager mAppOpsManager;
    long[] mAppStandbyElapsedThresholds;
    private final Map<String, String> mAppStandbyProperties;
    long[] mAppStandbyScreenThresholds;
    private AppWidgetManager mAppWidgetManager;
    private final SparseSetArray<String> mAppsToRestoreToRare;
    volatile String mBroadcastResponseExemptedPermissions;
    volatile List<String> mBroadcastResponseExemptedPermissionsList;
    volatile String mBroadcastResponseExemptedRoles;
    volatile List<String> mBroadcastResponseExemptedRolesList;
    volatile int mBroadcastResponseFgThresholdState;
    volatile long mBroadcastResponseWindowDurationMillis;
    volatile long mBroadcastSessionsDurationMs;
    volatile long mBroadcastSessionsWithResponseDurationMs;
    private String mCachedDeviceProvisioningPackage;
    private volatile String mCachedNetworkScorer;
    private volatile long mCachedNetworkScorerAtMillis;
    private List<String> mCarrierPrivilegedApps;
    private final Object mCarrierPrivilegedLock;
    long mCheckIdleIntervalMillis;
    private final Context mContext;
    private final DisplayManager.DisplayListener mDisplayListener;
    long mExemptedSyncScheduledDozeTimeoutMillis;
    long mExemptedSyncScheduledNonDozeTimeoutMillis;
    long mExemptedSyncStartTimeoutMillis;
    private final AppStandbyHandler mHandler;
    private final boolean mHasFeatureTelephonySubscription;
    private boolean mHaveCarrierPrivilegedApps;
    private final ArraySet<String> mHeadlessSystemApps;
    long mInitialForegroundServiceStartTimeoutMillis;
    Injector mInjector;
    private volatile boolean mIsCharging;
    boolean mLinkCrossProfileApps;
    volatile boolean mNoteResponseEventForAllBroadcastSessions;
    int mNotificationSeenPromotedBucket;
    long mNotificationSeenTimeoutMillis;
    private final ArrayList<AppStandbyInternal.AppIdleStateChangeListener> mPackageAccessListeners;
    private PackageManager mPackageManager;
    private final SparseLongArray mPendingIdleStateChecks;
    private boolean mPendingInitializeDefaults;
    private volatile boolean mPendingOneTimeCheckIdleStates;
    private PowerAdvisorInternal mPowerAdvisorInternal;
    long mPredictionTimeoutMillis;
    boolean mRetainNotificationSeenImpactForPreTApps;
    long mSlicePinnedTimeoutMillis;
    long mStrongUsageTimeoutMillis;
    int mSyncAdapaterPromotedBucket;
    long mSyncAdapterTimeoutMillis;
    private final SparseIntArray mSystemExemptionAppOpMode;
    long mSystemInteractionTimeoutMillis;
    private final ArrayList<Integer> mSystemPackagesAppIds;
    private boolean mSystemServicesReady;
    long mSystemUpdateUsageTimeoutMillis;
    private boolean mTriggerQuotaBumpOnNotificationSeen;
    long mUnexemptedSyncScheduledTimeoutMillis;

    class AppStandbyHandler extends Handler {
        final /* synthetic */ AppStandbyController this$0;

        AppStandbyHandler(AppStandbyController this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean exempted = false;
            switch(msg.what) {
                case 3: goto L44;
                case 4: goto L40;
                case 5: goto L17;
                case 6: goto L4;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L7;
                case 13: goto L5;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L5:
            AppStandbyController.m9078$$Nest$mreportExemptedSyncStart(this.this$0, (String) msg.obj, msg.arg1);
            return;
        L12:
            AppStandbyController.m9071$$Nest$mcheckAndUpdateStandbyState(this.this$0, (String) msg.obj, msg.arg1, msg.arg2, this.this$0.mInjector.elapsedRealtime());
            return;
        L13:
            AppStandbyController.m9066$$Nest$fgetmHandler(this.this$0).removeMessages(10);
            AppStandbyController.m9083$$Nest$mwaitForAdminData(this.this$0);
            this.this$0.checkIdleStates(-1);
            return;
        L14:
            AppStandbyController.m9074$$Nest$minformParoleStateChanged(this.this$0);
            return;
        L15:
            ContentProviderUsageRecord record = (ContentProviderUsageRecord) msg.obj;
            AppStandbyController.m9076$$Nest$mreportContentProviderUsage(this.this$0, record.name, record.packageName, record.userId);
            record.recycle();
            return;
        L16:
            AppStandbyController.m9081$$Nest$mtriggerListenerQuotaBump(this.this$0, (String) msg.obj, msg.arg1);
            return;
        L17:
            removeMessages(5);
            long earliestCheck = Long.MAX_VALUE;
            long nowElapsed = this.this$0.mInjector.elapsedRealtime();
            SparseLongArray r7 = AppStandbyController.m9067$$Nest$fgetmPendingIdleStateChecks(this.this$0);
            monitor-enter(r7);
            int i = AppStandbyController.m9067$$Nest$fgetmPendingIdleStateChecks(this.this$0).size() - 1;     // Catch: Throwable -> L28
        L20:
            if (i < 0) goto L34;
            long expirationTime = AppStandbyController.m9067$$Nest$fgetmPendingIdleStateChecks(this.this$0).valueAt(i);     // Catch: Throwable -> L28
            if (expirationTime > nowElapsed) goto L31;
            int userId = AppStandbyController.m9067$$Nest$fgetmPendingIdleStateChecks(this.this$0).keyAt(i);     // Catch: Throwable -> L28
            if (this.this$0.checkIdleStates(userId) == true) goto L26;
        L30:
            AppStandbyController.m9067$$Nest$fgetmPendingIdleStateChecks(this.this$0).removeAt(i);     // Catch: Throwable -> L28
        L32:
            i = i - 1;     // Catch: Throwable -> L28
            goto L20
        L26:
            if (AppStandbyController.m9060$$Nest$fgetmAppIdleEnabled(this.this$0) == false) goto L30;
            expirationTime = nowElapsed + this.this$0.mCheckIdleIntervalMillis;     // Catch: Throwable -> L28
            AppStandbyController.m9067$$Nest$fgetmPendingIdleStateChecks(this.this$0).put(userId, expirationTime);     // Catch: Throwable -> L28
        L31:
            earliestCheck = Math.min(earliestCheck, expirationTime);     // Catch: Throwable -> L28
            goto L32
        L34:
            monitor-exit(r7);     // Catch: Throwable -> L28
            if (earliestCheck == Long.MAX_VALUE) goto L60;
            AppStandbyController.m9066$$Nest$fgetmHandler(this.this$0).sendMessageDelayed(AppStandbyController.m9066$$Nest$fgetmHandler(this.this$0).obtainMessage(5), earliestCheck - nowElapsed);
            return;
        L60:
            return;
        L28:
            th = move-exception;
            throw th;
        L40:
            AppStandbyController r0 = this.this$0;
            String r3 = (String) msg.obj;
            int r4 = msg.arg1;
            if (msg.arg2 != 1) goto L43;
            exempted = true;
        L43:
            r0.forceIdleState(r3, r4, exempted);
            return;
        L44:
            StandbyUpdateRecord r = (StandbyUpdateRecord) msg.obj;
            AppStandbyController.m9073$$Nest$minformListeners(this.this$0, r.packageName, r.userId, r.bucket, r.reason, r.isUserInteraction);
            r.recycle();
            return;
        L7:
            if (msg.arg2 <= 0) goto L9;
            exempted = true;
        L9:
            if (exempted == false) goto L11;
            AppStandbyController.m9077$$Nest$mreportExemptedSyncScheduled(this.this$0, (String) msg.obj, msg.arg1);
            return;
        L11:
            AppStandbyController.m9079$$Nest$mreportUnexemptedSyncScheduled(this.this$0, (String) msg.obj, msg.arg1);
        }
    }

    private class ConstantsObserver extends ContentObserver implements DeviceConfig.OnPropertiesChangedListener {
        public static final long DEFAULT_AUTO_RESTRICTED_BUCKET_DELAY_MS = 3600000;
        private static final String DEFAULT_BROADCAST_RESPONSE_EXEMPTED_PERMISSIONS = "";
        private static final String DEFAULT_BROADCAST_RESPONSE_EXEMPTED_ROLES = "";
        public static final int DEFAULT_BROADCAST_RESPONSE_FG_THRESHOLD_STATE = 2;
        public static final long DEFAULT_BROADCAST_RESPONSE_WINDOW_DURATION_MS = 120000;
        public static final long DEFAULT_BROADCAST_SESSIONS_DURATION_MS = 120000;
        public static final long DEFAULT_BROADCAST_SESSIONS_WITH_RESPONSE_DURATION_MS = 120000;
        public static final long DEFAULT_CHECK_IDLE_INTERVAL_MS = 14400000;
        public static final boolean DEFAULT_CROSS_PROFILE_APPS_SHARE_STANDBY_BUCKETS = true;
        public static final long DEFAULT_CURRENT_SLICE_PINNED_TIMEOUT = 7200000;
        public static final long DEFAULT_CURRENT_STRONG_USAGE_TIMEOUT = 300000;
        public static final long DEFAULT_CURRENT_SYNC_ADAPTER_TIMEOUT = 7200000;
        public static final long DEFAULT_EXEMPTED_SYNC_SCHEDULED_DOZE_TIMEOUT = 14400000;
        public static final long DEFAULT_EXEMPTED_SYNC_SCHEDULED_NON_DOZE_TIMEOUT = 600000;
        public static final long DEFAULT_EXEMPTED_SYNC_START_TIMEOUT = 600000;
        public static final long DEFAULT_INITIAL_FOREGROUND_SERVICE_START_TIMEOUT = 1800000;
        public static final long DEFAULT_LEGACY_SLICE_PINNED_TIMEOUT = 43200000;
        public static final long DEFAULT_LEGACY_STRONG_USAGE_TIMEOUT = 3600000;
        public static final long DEFAULT_LEGACY_SYNC_ADAPTER_TIMEOUT = 600000;
        public static final boolean DEFAULT_NOTE_RESPONSE_EVENT_FOR_ALL_BROADCAST_SESSIONS = true;
        public static final int DEFAULT_NOTIFICATION_SEEN_PROMOTED_BUCKET = 20;
        public static final long DEFAULT_NOTIFICATION_TIMEOUT = 43200000;
        public static final boolean DEFAULT_RETAIN_NOTIFICATION_SEEN_IMPACT_FOR_PRE_T_APPS = false;
        public static final long DEFAULT_SYSTEM_INTERACTION_TIMEOUT = 600000;
        public static final long DEFAULT_SYSTEM_UPDATE_TIMEOUT = 7200000;
        public static final boolean DEFAULT_TRIGGER_QUOTA_BUMP_ON_NOTIFICATION_SEEN = false;
        public static final long DEFAULT_UNEXEMPTED_SYNC_SCHEDULED_TIMEOUT = 600000;
        private static final String KEY_AUTO_RESTRICTED_BUCKET_DELAY_MS = "auto_restricted_bucket_delay_ms";
        private static final String KEY_BROADCAST_RESPONSE_EXEMPTED_PERMISSIONS = "brodacast_response_exempted_permissions";
        private static final String KEY_BROADCAST_RESPONSE_EXEMPTED_ROLES = "brodacast_response_exempted_roles";
        private static final String KEY_BROADCAST_RESPONSE_FG_THRESHOLD_STATE = "broadcast_response_fg_threshold_state";
        private static final String KEY_BROADCAST_RESPONSE_WINDOW_DURATION_MS = "broadcast_response_window_timeout_ms";
        private static final String KEY_BROADCAST_SESSIONS_DURATION_MS = "broadcast_sessions_duration_ms";
        private static final String KEY_BROADCAST_SESSIONS_WITH_RESPONSE_DURATION_MS = "broadcast_sessions_with_response_duration_ms";
        private static final String KEY_CROSS_PROFILE_APPS_SHARE_STANDBY_BUCKETS = "cross_profile_apps_share_standby_buckets";
        private static final String KEY_EXEMPTED_SYNC_SCHEDULED_DOZE_HOLD_DURATION = "exempted_sync_scheduled_d_duration";
        private static final String KEY_EXEMPTED_SYNC_SCHEDULED_NON_DOZE_HOLD_DURATION = "exempted_sync_scheduled_nd_duration";
        private static final String KEY_EXEMPTED_SYNC_START_HOLD_DURATION = "exempted_sync_start_duration";
        private static final String KEY_INITIAL_FOREGROUND_SERVICE_START_HOLD_DURATION = "initial_foreground_service_start_duration";
        private static final String KEY_NOTE_RESPONSE_EVENT_FOR_ALL_BROADCAST_SESSIONS = "note_response_event_for_all_broadcast_sessions";
        private static final String KEY_NOTIFICATION_SEEN_HOLD_DURATION = "notification_seen_duration";
        private static final String KEY_NOTIFICATION_SEEN_PROMOTED_BUCKET = "notification_seen_promoted_bucket";
        private static final String KEY_PREDICTION_TIMEOUT = "prediction_timeout";
        private static final String KEY_PREFIX_ELAPSED_TIME_THRESHOLD = "elapsed_threshold_";
        private static final String KEY_PREFIX_SCREEN_TIME_THRESHOLD = "screen_threshold_";
        private static final String KEY_RETAIN_NOTIFICATION_SEEN_IMPACT_FOR_PRE_T_APPS = "retain_notification_seen_impact_for_pre_t_apps";
        private static final String KEY_SLICE_PINNED_HOLD_DURATION = "slice_pinned_duration";
        private static final String KEY_STRONG_USAGE_HOLD_DURATION = "strong_usage_duration";
        private static final String KEY_SYNC_ADAPTER_HOLD_DURATION = "sync_adapter_duration";
        private static final String KEY_SYSTEM_INTERACTION_HOLD_DURATION = "system_interaction_duration";
        private static final String KEY_SYSTEM_UPDATE_HOLD_DURATION = "system_update_usage_duration";
        private static final String KEY_TRIGGER_QUOTA_BUMP_ON_NOTIFICATION_SEEN = "trigger_quota_bump_on_notification_seen";
        private static final String KEY_UNEXEMPTED_SYNC_SCHEDULED_HOLD_DURATION = "unexempted_sync_scheduled_duration";
        private final String[] KEYS_ELAPSED_TIME_THRESHOLDS;
        private final String[] KEYS_SCREEN_TIME_THRESHOLDS;
        private final TextUtils.SimpleStringSplitter mStringPipeSplitter;
        final /* synthetic */ AppStandbyController this$0;

        ConstantsObserver(AppStandbyController r5, Handler handler) {
            this.this$0 = r5;
            super(handler);
            this.KEYS_SCREEN_TIME_THRESHOLDS = new String[]{"screen_threshold_active", "screen_threshold_working_set", "screen_threshold_frequent", "screen_threshold_rare", "screen_threshold_restricted"};
            this.KEYS_ELAPSED_TIME_THRESHOLDS = new String[]{"elapsed_threshold_active", "elapsed_threshold_working_set", "elapsed_threshold_frequent", "elapsed_threshold_rare", "elapsed_threshold_restricted"};
            this.mStringPipeSplitter = new TextUtils.SimpleStringSplitter('|');
        }

        public void start() {
            ContentResolver cr = AppStandbyController.m9065$$Nest$fgetmContext(this.this$0).getContentResolver();
            cr.registerContentObserver(Settings.Global.getUriFor("app_standby_enabled"), false, this);
            cr.registerContentObserver(Settings.Global.getUriFor("adaptive_battery_management_enabled"), false, this);
            this.this$0.mInjector.registerDeviceConfigPropertiesChangedListener(this);
            processDefaultConstants();
            processProperties(this.this$0.mInjector.getDeviceConfigProperties(new String[0]));
            updateSettings();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            updateSettings();
            this.this$0.postOneTimeCheckIdleStates();
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            processProperties(properties);
            this.this$0.postOneTimeCheckIdleStates();
        }

        private void processDefaultConstants() {
            this.this$0.mSlicePinnedTimeoutMillis = 7200000;
            this.this$0.mSyncAdapterTimeoutMillis = 7200000;
            this.this$0.mSyncAdapaterPromotedBucket = 20;
            this.this$0.mStrongUsageTimeoutMillis = 300000;
        }

        private void processProperties(DeviceConfig.Properties properties) {
            boolean timeThresholdsUpdated = false;
            Object r3 = AppStandbyController.m9062$$Nest$fgetmAppIdleLock(this.this$0);
            monitor-enter(r3);
            Iterator r0 = properties.getKeyset().iterator();     // Catch: Throwable -> L16
        L6:
            if (r0.hasNext() == false) goto L121;
            String name = (String) r0.next();     // Catch: Throwable -> L16
            if (name == null) goto L6;
            switch(name.hashCode()) {
                case -1991469656: goto L85;
                case -1963219299: goto L82;
                case -1794959158: goto L79;
                case -1610671326: goto L76;
                case -1525033432: goto L73;
                case -1063555730: goto L70;
                case -973233853: goto L67;
                case -695619964: goto L64;
                case -654339791: goto L61;
                case -641750299: goto L58;
                case -557676904: goto L55;
                case -294320234: goto L52;
                case -129077581: goto L49;
                case -57661244: goto L46;
                case 276460958: goto L43;
                case 456604392: goto L40;
                case 742365823: goto L37;
                case 938381045: goto L34;
                case 992238669: goto L31;
                case 1105744372: goto L28;
                case 1288386175: goto L25;
                case 1378352561: goto L22;
                case 1400233242: goto L19;
                case 1915246556: goto L14;
                default: goto L87;
            };     // Catch: Throwable -> L16
        L87:
            byte r5 = -1;
        L89:
            switch(r5) {
                case 0: goto L119;
                case 1: goto L118;
                case 2: goto L117;
                case 3: goto L116;
                case 4: goto L115;
                case 5: goto L114;
                case 6: goto L113;
                case 7: goto L112;
                case 8: goto L111;
                case 9: goto L110;
                case 10: goto L109;
                case 11: goto L108;
                case 12: goto L107;
                case 13: goto L106;
                case 14: goto L105;
                case 15: goto L104;
                case 16: goto L103;
                case 17: goto L102;
                case 18: goto L101;
                case 19: goto L100;
                case 20: goto L99;
                case 21: goto L98;
                case 22: goto L97;
                case 23: goto L96;
                default: goto L90;
            };     // Catch: Throwable -> L16
        L90:
            if (timeThresholdsUpdated == false) goto L92;
        L120:
            AppStandbyController.m9063$$Nest$fgetmAppStandbyProperties(this.this$0).put(name, properties.getString(name, null));     // Catch: Throwable -> L16
            goto L6
        L92:
            if (name.startsWith(KEY_PREFIX_SCREEN_TIME_THRESHOLD) == false) goto L94;
        L95:
            updateTimeThresholds();     // Catch: Throwable -> L16
            timeThresholdsUpdated = true;
            goto L120
        L94:
            if (name.startsWith(KEY_PREFIX_ELAPSED_TIME_THRESHOLD) == false) goto L120;
        L96:
            this.this$0.mBroadcastResponseExemptedPermissions = properties.getString(KEY_BROADCAST_RESPONSE_EXEMPTED_PERMISSIONS, "");     // Catch: Throwable -> L16
            this.this$0.mBroadcastResponseExemptedPermissionsList = splitPipeSeparatedString(this.this$0.mBroadcastResponseExemptedPermissions);     // Catch: Throwable -> L16
            goto L120
        L97:
            this.this$0.mBroadcastResponseExemptedRoles = properties.getString(KEY_BROADCAST_RESPONSE_EXEMPTED_ROLES, "");     // Catch: Throwable -> L16
            this.this$0.mBroadcastResponseExemptedRolesList = splitPipeSeparatedString(this.this$0.mBroadcastResponseExemptedRoles);     // Catch: Throwable -> L16
            goto L120
        L98:
            this.this$0.mNoteResponseEventForAllBroadcastSessions = properties.getBoolean(KEY_NOTE_RESPONSE_EVENT_FOR_ALL_BROADCAST_SESSIONS, true);     // Catch: Throwable -> L16
            goto L120
        L99:
            this.this$0.mBroadcastSessionsWithResponseDurationMs = properties.getLong(KEY_BROADCAST_SESSIONS_WITH_RESPONSE_DURATION_MS, 120000);     // Catch: Throwable -> L16
            goto L120
        L100:
            this.this$0.mBroadcastSessionsDurationMs = properties.getLong(KEY_BROADCAST_SESSIONS_DURATION_MS, 120000);     // Catch: Throwable -> L16
            goto L120
        L101:
            this.this$0.mBroadcastResponseFgThresholdState = properties.getInt(KEY_BROADCAST_RESPONSE_FG_THRESHOLD_STATE, 2);     // Catch: Throwable -> L16
            goto L120
        L102:
            this.this$0.mBroadcastResponseWindowDurationMillis = properties.getLong(KEY_BROADCAST_RESPONSE_WINDOW_DURATION_MS, 120000);     // Catch: Throwable -> L16
            goto L120
        L103:
            this.this$0.mUnexemptedSyncScheduledTimeoutMillis = properties.getLong(KEY_UNEXEMPTED_SYNC_SCHEDULED_HOLD_DURATION, 600000);     // Catch: Throwable -> L16
            goto L120
        L104:
            this.this$0.mExemptedSyncStartTimeoutMillis = properties.getLong(KEY_EXEMPTED_SYNC_START_HOLD_DURATION, 600000);     // Catch: Throwable -> L16
            goto L120
        L105:
            this.this$0.mExemptedSyncScheduledNonDozeTimeoutMillis = properties.getLong(KEY_EXEMPTED_SYNC_SCHEDULED_NON_DOZE_HOLD_DURATION, 600000);     // Catch: Throwable -> L16
            goto L120
        L106:
            this.this$0.mExemptedSyncScheduledDozeTimeoutMillis = properties.getLong(KEY_EXEMPTED_SYNC_SCHEDULED_DOZE_HOLD_DURATION, 14400000);     // Catch: Throwable -> L16
            goto L120
        L107:
            this.this$0.mSyncAdapterTimeoutMillis = properties.getLong(KEY_SYNC_ADAPTER_HOLD_DURATION, 7200000);     // Catch: Throwable -> L16
            goto L120
        L108:
            this.this$0.mSystemUpdateUsageTimeoutMillis = properties.getLong(KEY_SYSTEM_UPDATE_HOLD_DURATION, 7200000);     // Catch: Throwable -> L16
            goto L120
        L109:
            this.this$0.mSystemInteractionTimeoutMillis = properties.getLong(KEY_SYSTEM_INTERACTION_HOLD_DURATION, 600000);     // Catch: Throwable -> L16
            goto L120
        L110:
            this.this$0.mPredictionTimeoutMillis = properties.getLong(KEY_PREDICTION_TIMEOUT, 43200000);     // Catch: Throwable -> L16
            goto L120
        L111:
            this.this$0.mStrongUsageTimeoutMillis = properties.getLong(KEY_STRONG_USAGE_HOLD_DURATION, 300000);     // Catch: Throwable -> L16
            goto L120
        L112:
            this.this$0.mSlicePinnedTimeoutMillis = properties.getLong(KEY_SLICE_PINNED_HOLD_DURATION, 7200000);     // Catch: Throwable -> L16
            goto L120
        L113:
            AppStandbyController.m9070$$Nest$fputmTriggerQuotaBumpOnNotificationSeen(this.this$0, properties.getBoolean(KEY_TRIGGER_QUOTA_BUMP_ON_NOTIFICATION_SEEN, false));     // Catch: Throwable -> L16
            goto L120
        L114:
            this.this$0.mRetainNotificationSeenImpactForPreTApps = properties.getBoolean(KEY_RETAIN_NOTIFICATION_SEEN_IMPACT_FOR_PRE_T_APPS, false);     // Catch: Throwable -> L16
            goto L120
        L115:
            this.this$0.mNotificationSeenPromotedBucket = properties.getInt(KEY_NOTIFICATION_SEEN_PROMOTED_BUCKET, 20);     // Catch: Throwable -> L16
            goto L120
        L116:
            this.this$0.mNotificationSeenTimeoutMillis = properties.getLong(KEY_NOTIFICATION_SEEN_HOLD_DURATION, 43200000);     // Catch: Throwable -> L16
            goto L120
        L117:
            this.this$0.mInitialForegroundServiceStartTimeoutMillis = properties.getLong(KEY_INITIAL_FOREGROUND_SERVICE_START_HOLD_DURATION, 1800000);     // Catch: Throwable -> L16
            goto L120
        L118:
            this.this$0.mLinkCrossProfileApps = properties.getBoolean(KEY_CROSS_PROFILE_APPS_SHARE_STANDBY_BUCKETS, true);     // Catch: Throwable -> L16
            goto L120
        L119:
            this.this$0.mInjector.mAutoRestrictedBucketDelayMs = Math.max(14400000, properties.getLong(KEY_AUTO_RESTRICTED_BUCKET_DELAY_MS, 3600000));     // Catch: Throwable -> L16
            goto L120
        L14:
            if (name.equals(KEY_INITIAL_FOREGROUND_SERVICE_START_HOLD_DURATION) == false) goto L87;
            r5 = 2;
            goto L89
        L19:
            if (name.equals(KEY_STRONG_USAGE_HOLD_DURATION) == false) goto L87;
            r5 = 8;
            goto L89
        L22:
            if (name.equals(KEY_PREDICTION_TIMEOUT) == false) goto L87;
            r5 = 9;
            goto L89
        L25:
            if (name.equals(KEY_CROSS_PROFILE_APPS_SHARE_STANDBY_BUCKETS) == false) goto L87;
            r5 = 1;
            goto L89
        L28:
            if (name.equals(KEY_EXEMPTED_SYNC_START_HOLD_DURATION) == false) goto L87;
            r5 = 15;
            goto L89
        L31:
            if (name.equals(KEY_BROADCAST_SESSIONS_DURATION_MS) == false) goto L87;
            r5 = ParameterName.FILM_MODE;
            goto L89
        L34:
            if (name.equals(KEY_NOTIFICATION_SEEN_PROMOTED_BUCKET) == false) goto L87;
            r5 = 4;
            goto L89
        L37:
            if (name.equals(KEY_BROADCAST_RESPONSE_FG_THRESHOLD_STATE) == false) goto L87;
            r5 = ParameterName.DYNAMIC_LUMA_CONTROL;
            goto L89
        L40:
            if (name.equals(KEY_EXEMPTED_SYNC_SCHEDULED_NON_DOZE_HOLD_DURATION) == false) goto L87;
            r5 = 14;
            goto L89
        L43:
            if (name.equals(KEY_RETAIN_NOTIFICATION_SEEN_IMPACT_FOR_PRE_T_APPS) == false) goto L87;
            r5 = 5;
            goto L89
        L46:
            if (name.equals(KEY_EXEMPTED_SYNC_SCHEDULED_DOZE_HOLD_DURATION) == false) goto L87;
            r5 = 13;
            goto L89
        L49:
            if (name.equals(KEY_BROADCAST_RESPONSE_WINDOW_DURATION_MS) == false) goto L87;
            r5 = ParameterName.DE_CONTOUR;
            goto L89
        L52:
            if (name.equals(KEY_BROADCAST_RESPONSE_EXEMPTED_ROLES) == false) goto L87;
            r5 = ParameterName.COLOR_TUNE;
            goto L89
        L55:
            if (name.equals(KEY_SYSTEM_UPDATE_HOLD_DURATION) == false) goto L87;
            r5 = 11;
            goto L89
        L58:
            if (name.equals(KEY_NOTE_RESPONSE_EVENT_FOR_ALL_BROADCAST_SESSIONS) == false) goto L87;
            r5 = ParameterName.BLUE_STRETCH;
            goto L89
        L61:
            if (name.equals(KEY_SYSTEM_INTERACTION_HOLD_DURATION) == false) goto L87;
            r5 = 10;
            goto L89
        L64:
            if (name.equals(KEY_NOTIFICATION_SEEN_HOLD_DURATION) == false) goto L87;
            r5 = 3;
            goto L89
        L67:
            if (name.equals(KEY_AUTO_RESTRICTED_BUCKET_DELAY_MS) == false) goto L87;
            r5 = 0;
            goto L89
        L70:
            if (name.equals(KEY_SLICE_PINNED_HOLD_DURATION) == false) goto L87;
            r5 = 7;
            goto L89
        L73:
            if (name.equals(KEY_BROADCAST_SESSIONS_WITH_RESPONSE_DURATION_MS) == false) goto L87;
            r5 = 20;
            goto L89
        L76:
            if (name.equals(KEY_UNEXEMPTED_SYNC_SCHEDULED_HOLD_DURATION) == false) goto L87;
            r5 = 16;
            goto L89
        L79:
            if (name.equals(KEY_TRIGGER_QUOTA_BUMP_ON_NOTIFICATION_SEEN) == false) goto L87;
            r5 = 6;
            goto L89
        L82:
            if (name.equals(KEY_BROADCAST_RESPONSE_EXEMPTED_PERMISSIONS) == false) goto L87;
            r5 = ParameterName.COLOR_TEMPERATURE;
            goto L89
        L85:
            if (name.equals(KEY_SYNC_ADAPTER_HOLD_DURATION) == false) goto L87;
            r5 = 12;
            goto L89
        L121:
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        private List<String> splitPipeSeparatedString(String string) {
            List<String> values = new ArrayList();
            this.mStringPipeSplitter.setString(string);
        L4:
            if (this.mStringPipeSplitter.hasNext() == false) goto L6;
            values.add(this.mStringPipeSplitter.next());
            goto L4
        L6:
            return values;
        }

        private void updateTimeThresholds() {
            DeviceConfig.Properties screenThresholdProperties = this.this$0.mInjector.getDeviceConfigProperties(this.KEYS_SCREEN_TIME_THRESHOLDS);
            DeviceConfig.Properties elapsedThresholdProperties = this.this$0.mInjector.getDeviceConfigProperties(this.KEYS_ELAPSED_TIME_THRESHOLDS);
            AppStandbyController r2 = this.this$0;
            r2.mAppStandbyScreenThresholds = generateThresholdArray(screenThresholdProperties, this.KEYS_SCREEN_TIME_THRESHOLDS, AppStandbyController.DEFAULT_SCREEN_TIME_THRESHOLDS, AppStandbyController.MINIMUM_SCREEN_TIME_THRESHOLDS);
            AppStandbyController r3 = this.this$0;
            r3.mAppStandbyElapsedThresholds = generateThresholdArray(elapsedThresholdProperties, this.KEYS_ELAPSED_TIME_THRESHOLDS, AppStandbyController.DEFAULT_ELAPSED_TIME_THRESHOLDS, AppStandbyController.MINIMUM_ELAPSED_TIME_THRESHOLDS);
            AppStandbyController r4 = this.this$0;
            r4.mCheckIdleIntervalMillis = Math.min(this.this$0.mAppStandbyElapsedThresholds[1] / 4, 14400000);
        }

        void updateSettings() {
            this.this$0.setAppIdleEnabled(this.this$0.mInjector.isAppIdleEnabled());
        }

        long[] generateThresholdArray(DeviceConfig.Properties properties, String[] keys, long[] defaults, long[] minValues) {
            if (properties.getKeyset().isEmpty() == false) goto L6;
            return defaults;
        L6:
            if (keys.length != AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length) goto L21;
            if (defaults.length != AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length) goto L19;
            if (minValues.length == AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length) goto L12;
            Slog.wtf(AppStandbyController.TAG, "minValues array is the wrong size");
            minValues = new long[AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length];
        L12:
            long[] array = new long[AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length];
            int i = 0;
        L14:
            if (i >= AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length) goto L17;
            array[i] = Math.max(minValues[i], properties.getLong(keys[i], defaults[i]));
            i = i + 1;
            goto L14
        L17:
            return array;
        L19:
            throw new IllegalStateException("# defaults (" + defaults.length + ") != # buckets (" + AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length + ")");
        L21:
            throw new IllegalStateException("# keys (" + keys.length + ") != # buckets (" + AppStandbyController.m9084$$Nest$sfgetTHRESHOLD_BUCKETS().length + ")");
        }
    }

    private static class ContentProviderUsageRecord {
        private static final Pool<ContentProviderUsageRecord> sPool = null;
        public String name;
        public String packageName;
        public int userId;

        private ContentProviderUsageRecord() {
        }

        static {
            sPool = new Pool(new ContentProviderUsageRecord[10]);
        }

        public static ContentProviderUsageRecord obtain(String name, String packageName, int userId) {
            ContentProviderUsageRecord r = sPool.obtain();
            if (r != null) goto L5;
            r = new ContentProviderUsageRecord();
        L5:
            r.name = name;
            r.packageName = packageName;
            r.userId = userId;
            return r;
        }

        public void recycle() {
            sPool.recycle(this);
        }
    }

    private class DeviceStateReceiver extends BroadcastReceiver {
        final /* synthetic */ AppStandbyController this$0;

        public static /* synthetic */ void $r8$lambda$vJLDXlUh4fYgit4sBALnnUw4CrE(AppStandbyController r0) {
            AppStandbyController.m9082$$Nest$mupdatePowerWhitelistCache(r0);
        }

        /* synthetic */ DeviceStateReceiver(AppStandbyController r1, AppStandbyControllerIA r2) {
            this(r1);
        }

        private DeviceStateReceiver(AppStandbyController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String r0 = intent.getAction();
            switch(r0.hashCode()) {
                case -65633567: goto L12;
                case -54942926: goto L9;
                case 948344062: goto L6;
                default: goto L14;
            };
        L14:
            byte r1 = -1;
        L15:
            switch(r1) {
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L18;
                default: goto L26;
            };
        L20:
            this.this$0.setChargingState(false);
            return;
        L21:
            this.this$0.setChargingState(true);
            return;
        L26:
            return;
        L18:
            if (AppStandbyController.m9069$$Nest$fgetmSystemServicesReady(this.this$0) == false) goto L23;
            AppStandbyHandler r2 = AppStandbyController.m9066$$Nest$fgetmHandler(this.this$0);
            final AppStandbyController r3 = this.this$0;
            r2.post(new AppStandbyController$DeviceStateReceiver$$ExternalSyntheticLambda0(r3));
            return;
        L23:
            return;
        L6:
            if (r0.equals("android.os.action.CHARGING") == false) goto L14;
            r1 = 0;
            goto L15
        L9:
            if (r0.equals("android.os.action.DISCHARGING") == false) goto L14;
            r1 = 1;
            goto L15
        L12:
            if (r0.equals("android.os.action.POWER_SAVE_WHITELIST_CHANGED") == false) goto L14;
            r1 = 2;
            goto L15
        }
    }

    static class Injector {
        private AlarmManagerInternal mAlarmManagerInternal;
        long mAutoRestrictedBucketDelayMs;
        private BatteryManager mBatteryManager;
        private IBatteryStats mBatteryStats;
        int mBootPhase;
        private final Context mContext;
        private CrossProfileAppsInternal mCrossProfileAppsInternal;
        private IDeviceIdleController mDeviceIdleController;
        private DisplayManager mDisplayManager;
        private final Looper mLooper;
        private PackageManagerInternal mPackageManagerInternal;
        private PowerManager mPowerManager;
        private final ArraySet<String> mPowerWhitelistedApps;
        private String mWellbeingApp;

        Injector(Context context, Looper looper) {
            this.mAutoRestrictedBucketDelayMs = 3600000;
            this.mPowerWhitelistedApps = new ArraySet();
            this.mWellbeingApp = null;
            this.mContext = context;
            this.mLooper = looper;
        }

        Context getContext() {
            return this.mContext;
        }

        Looper getLooper() {
            return this.mLooper;
        }

        void onBootPhase(int phase) {
            if (phase != 500) goto L11;
            this.mDeviceIdleController = IDeviceIdleController.Stub.asInterface(ServiceManager.getService("deviceidle"));
            this.mBatteryStats = IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats"));
            this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            this.mDisplayManager = (DisplayManager) this.mContext.getSystemService("display");
            this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
            this.mBatteryManager = (BatteryManager) this.mContext.getSystemService(BatteryManager.class);
            this.mCrossProfileAppsInternal = (CrossProfileAppsInternal) LocalServices.getService(CrossProfileAppsInternal.class);
            this.mAlarmManagerInternal = (AlarmManagerInternal) LocalServices.getService(AlarmManagerInternal.class);
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
            if (activityManager.isLowRamDevice() == false) goto L7;
        L8:
            this.mAutoRestrictedBucketDelayMs = 43200000;
        L13:
            this.mBootPhase = phase;
            return;
        L7:
            if (ActivityManager.isSmallBatteryDevice() == false) goto L13;
        L11:
            if (phase != 1000) goto L13;
            PackageManager packageManager = this.mContext.getPackageManager();
            this.mWellbeingApp = packageManager.getWellbeingPackageName();
            goto L13
        }

        int getBootPhase() {
            return this.mBootPhase;
        }

        long elapsedRealtime() {
            return SystemClock.elapsedRealtime();
        }

        long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        boolean isAppIdleEnabled() {
            boolean buildFlag = this.mContext.getResources().getBoolean(R.bool.config_enableContextSyncInCall);
            if (Settings.Global.getInt(this.mContext.getContentResolver(), "app_standby_enabled", 1) == 1) goto L5;
        L7:
            boolean runtimeFlag = false;
        L9:
            if (buildFlag == false) goto L13;
            if (runtimeFlag == false) goto L13;
            return true;
        L13:
            return false;
        L5:
            if (Settings.Global.getInt(this.mContext.getContentResolver(), "adaptive_battery_management_enabled", 1) != 1) goto L7;
            runtimeFlag = true;
            goto L9
        }

        boolean isCharging() {
            return this.mBatteryManager.isCharging();
        }

        boolean isNonIdleWhitelisted(String packageName) {
            if (this.mBootPhase >= 500) goto L6;
            return false;
        L6:
            ArraySet<String> r0 = this.mPowerWhitelistedApps;
            monitor-enter(r0);
            boolean r1 = this.mPowerWhitelistedApps.contains(packageName);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        IAppOpsService getAppOpsService() {
            return IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));
        }

        boolean isWellbeingPackage(String packageName) {
            return packageName.equals(this.mWellbeingApp);
        }

        boolean shouldGetExactAlarmBucketElevation(String packageName, int uid) {
            return this.mAlarmManagerInternal.shouldGetBucketElevation(packageName, uid);
        }

        void updatePowerWhitelistCache() {
            String[] whitelistedPkgs = this.mDeviceIdleController.getFullPowerWhitelistExceptIdle();     // Catch: RemoteException -> L14
            ArraySet<String> r1 = this.mPowerWhitelistedApps;     // Catch: RemoteException -> L14
            monitor-enter(r1);     // Catch: RemoteException -> L14
            this.mPowerWhitelistedApps.clear();     // Catch: Throwable -> L7
            int len = whitelistedPkgs.length;     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= len) goto L10;
            this.mPowerWhitelistedApps.add(whitelistedPkgs[i]);     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L7
        L21:
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: RemoteException -> L14
        L14:
            e = move-exception;
            Slog.wtf(AppStandbyController.TAG, "Failed to get power whitelist", e);
        }

        File getDataSystemDirectory() {
            return Environment.getDataSystemDirectory();
        }

        long getAutoRestrictedBucketDelayMs() {
            return this.mAutoRestrictedBucketDelayMs;
        }

        void noteEvent(int event, String packageName, int uid) throws RemoteException {
            if (this.mBatteryStats == null) goto L6;
            this.mBatteryStats.noteEvent(event, packageName, uid);
            return;
        }

        PackageManagerInternal getPackageManagerInternal() {
            return this.mPackageManagerInternal;
        }

        boolean isPackageEphemeral(int userId, String packageName) {
            return this.mPackageManagerInternal.isPackageEphemeral(userId, packageName);
        }

        boolean isPackageInstalled(String packageName, int flags, int userId) {
            if (this.mPackageManagerInternal.getPackageUid(packageName, flags, userId) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        int[] getRunningUserIds() throws RemoteException {
            return ActivityManager.getService().getRunningUserIds();
        }

        boolean isDefaultDisplayOn() {
            if (this.mDisplayManager.getDisplay(0).getState() != 2) goto L6;
            return true;
        L6:
            return false;
        }

        void registerDisplayListener(DisplayManager.DisplayListener listener, Handler handler) {
            this.mDisplayManager.registerDisplayListener(listener, handler);
        }

        String getActiveNetworkScorer() {
            NetworkScoreManager nsm = (NetworkScoreManager) this.mContext.getSystemService("network_score");
            return nsm.getActiveScorerPackage();
        }

        public boolean isBoundWidgetPackage(AppWidgetManager appWidgetManager, String packageName, int userId) {
            return appWidgetManager.isBoundWidgetPackage(packageName, userId);
        }

        DeviceConfig.Properties getDeviceConfigProperties(String... keys) {
            return DeviceConfig.getProperties("app_standby", keys);
        }

        public boolean isDeviceIdleMode() {
            return this.mPowerManager.isDeviceIdleMode();
        }

        public List<UserHandle> getValidCrossProfileTargets(String pkg, int userId) {
            int uid = this.mPackageManagerInternal.getPackageUid(pkg, 0, userId);
            AndroidPackage aPkg = this.mPackageManagerInternal.getPackage(uid);
            if (uid < 0) goto L12;
            if (aPkg == null) goto L12;
            if (aPkg.isCrossProfile() == false) goto L12;
            if (this.mCrossProfileAppsInternal.verifyUidHasInteractAcrossProfilePermission(pkg, uid) == false) goto L12;
            return this.mCrossProfileAppsInternal.getTargetUserProfiles(pkg, userId);
        L12:
            if (uid < 0) goto L16;
            if (aPkg != null) goto L16;
            Slog.wtf(AppStandbyController.TAG, "Null package retrieved for UID " + uid);
        L16:
            return Collections.emptyList();
        }

        void registerDeviceConfigPropertiesChangedListener(DeviceConfig.OnPropertiesChangedListener listener) {
            DeviceConfig.addOnPropertiesChangedListener("app_standby", AppSchedulingModuleThread.getExecutor(), listener);
        }

        void dump(PrintWriter pw) {
            pw.println("mPowerWhitelistedApps=[");
            ArraySet<String> r0 = this.mPowerWhitelistedApps;
            monitor-enter(r0);
            int i = this.mPowerWhitelistedApps.size() - 1;     // Catch: Throwable -> L7
        L5:
            if (i < 0) goto L10;
            pw.print("  ");     // Catch: Throwable -> L7
            pw.print(this.mPowerWhitelistedApps.valueAt(i));     // Catch: Throwable -> L7
            pw.println(",");     // Catch: Throwable -> L7
            i = i - 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            pw.println("]");
            pw.println();
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class Lock {
        Lock() {
        }
    }

    private class PackageReceiver extends BroadcastReceiver {
        final /* synthetic */ AppStandbyController this$0;

        public static /* synthetic */ void $r8$lambda$Jsj21CbFCzE6_cFuxtyN786E4Ak(PackageReceiver r0, int r1) {
            r0.lambda$onReceive$0(r1);
        }

        /* synthetic */ PackageReceiver(AppStandbyController r1, AppStandbyControllerIA r2) {
            this(r1);
        }

        private PackageReceiver(AppStandbyController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String pkgName = intent.getData().getSchemeSpecificPart();
            final int userId = getSendingUserId();
            if ("android.intent.action.PACKAGE_ADDED".equals(action) == false) goto L5;
        L6:
            String[] cmpList = intent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
            if (cmpList != null) goto L9;
        L12:
            this.this$0.clearCarrierPrivilegedApps();
            AppStandbyController.m9072$$Nest$mevaluateSystemAppException(this.this$0, pkgName, userId);
        L14:
            if ("android.intent.action.PACKAGE_CHANGED".equals(action) == false) goto L17;
            AppStandbyController.m9066$$Nest$fgetmHandler(this.this$0).obtainMessage(11, userId, -1, pkgName).sendToTarget();
        L17:
            if ("android.intent.action.PACKAGE_REMOVED".equals(action) == true) goto L21;
            if ("android.intent.action.PACKAGE_ADDED".equals(action) == true) goto L21;
        L42:
            SparseIntArray r2 = AppStandbyController.m9068$$Nest$fgetmSystemExemptionAppOpMode(this.this$0);
            monitor-enter(r2);
        L47:
            th = move-exception;
            throw th;
        L45:
            if ("android.intent.action.PACKAGE_REMOVED".equals(action) == false) goto L49;
            int uid = intent.getIntExtra("android.intent.extra.UID", -1);     // Catch: Throwable -> L47
            AppStandbyController.m9068$$Nest$fgetmSystemExemptionAppOpMode(this.this$0).delete(uid);     // Catch: Throwable -> L47
        L49:
            monitor-exit(r2);     // Catch: Throwable -> L47
            return;
        L21:
            if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L24;
            this.this$0.maybeUnrestrictBuggyApp(pkgName, userId);
            goto L42
        L24:
            if ("android.intent.action.PACKAGE_ADDED".equals(action) == true) goto L27;
            this.this$0.clearAppIdleForPackage(pkgName, userId);
            goto L42
        L27:
            if (AppStandbyController.m9064$$Nest$fgetmAppsToRestoreToRare(this.this$0).get(userId) != null) goto L40;
            Object r3 = AppStandbyController.m9062$$Nest$fgetmAppIdleLock(this.this$0);
            monitor-enter(r3);
            ArraySet<String> restoredApps = AppStandbyController.m9061$$Nest$fgetmAppIdleHistory(this.this$0).readRestoreToRareAppsList(userId);     // Catch: Throwable -> L33
            if (restoredApps == null) goto L35;
            AppStandbyController.m9064$$Nest$fgetmAppsToRestoreToRare(this.this$0).addAll(userId, restoredApps);     // Catch: Throwable -> L33
            AppStandbyController.m9066$$Nest$fgetmHandler(this.this$0).postDelayed(new AppStandbyController$PackageReceiver$$ExternalSyntheticLambda0(this, userId), 172800000);     // Catch: Throwable -> L33
        L35:
            monitor-exit(r3);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        L40:
            if (AppStandbyController.m9064$$Nest$fgetmAppsToRestoreToRare(this.this$0).contains(userId, pkgName) == false) goto L42;
            AppStandbyController.m9080$$Nest$mrestoreAppToRare(this.this$0, pkgName, userId, this.this$0.mInjector.elapsedRealtime(), 258);
            AppStandbyController.m9064$$Nest$fgetmAppsToRestoreToRare(this.this$0).remove(userId, pkgName);
            goto L42
        L9:
            if (cmpList.length != 1) goto L14;
            if (pkgName.equals(cmpList[0]) == false) goto L14;
        L5:
            if ("android.intent.action.PACKAGE_CHANGED".equals(action) == false) goto L17;
            goto L6
        }

        private /* synthetic */ void lambda$onReceive$0(int userId) {
            AppStandbyController.m9064$$Nest$fgetmAppsToRestoreToRare(this.this$0).remove(userId);
        }
    }

    private static class Pool<T> {
        private final T[] mArray;
        private int mSize;

        Pool(T[] array) {
            this.mSize = 0;
            this.mArray = array;
        }

        synchronized T obtain() {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mSize <= 0) goto L9;
            T[] r0 = this.mArray;     // Catch: Throwable -> L7
            int r1 = this.mSize - 1;     // Catch: Throwable -> L7
            this.mSize = r1;     // Catch: Throwable -> L7
            T r2 = r0[r1];     // Catch: Throwable -> L7
        L10:
            monitor-exit(this);
            return r2;
        L9:
            r2 = null;
            goto L10
        }

        synchronized void recycle(T instance) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mSize >= this.mArray.length) goto L9;
            T[] r0 = this.mArray;     // Catch: Throwable -> L7
            int r1 = this.mSize;     // Catch: Throwable -> L7
            this.mSize = r1 + 1;     // Catch: Throwable -> L7
            r0[r1] = instance;     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
        }
    }

    private static class StandbyUpdateRecord {
        private static final Pool<StandbyUpdateRecord> sPool = null;
        int bucket;
        boolean isUserInteraction;
        String packageName;
        int reason;
        int userId;

        private StandbyUpdateRecord() {
        }

        static {
            sPool = new Pool(new StandbyUpdateRecord[10]);
        }

        public static StandbyUpdateRecord obtain(String pkgName, int userId, int bucket, int reason, boolean isInteraction) {
            StandbyUpdateRecord r = sPool.obtain();
            if (r != null) goto L5;
            r = new StandbyUpdateRecord();
        L5:
            r.packageName = pkgName;
            r.userId = userId;
            r.bucket = bucket;
            r.reason = reason;
            r.isUserInteraction = isInteraction;
            return r;
        }

        public void recycle() {
            sPool.recycle(this);
        }
    }

    public static /* synthetic */ void $r8$lambda$KASTYduY3JRt750UcTvOhtni_NI(AppStandbyController r0, int r1) {
        r0.lambda$restoreAppsToRare$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$R1BnLLc8pHhJyjLrszRkEJC2lnw() {
        lambda$flushHandler$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$U2-GF_fLZHT7_Jm_uRMpoT-uHZQ, reason: not valid java name */
    public static /* synthetic */ void m9059$r8$lambda$U2GF_fLZHT7_Jm_uRMpoTuHZQ(AppStandbyController r0) {
        r0.loadHeadlessSystemAppCache();
    }

    public static /* synthetic */ void $r8$lambda$vJLDXlUh4fYgit4sBALnnUw4CrE(AppStandbyController r0) {
        r0.updatePowerWhitelistCache();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppIdleEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9060$$Nest$fgetmAppIdleEnabled(AppStandbyController r0) {
        return r0.mAppIdleEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppIdleHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppIdleHistory m9061$$Nest$fgetmAppIdleHistory(AppStandbyController r0) {
        return r0.mAppIdleHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppIdleLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9062$$Nest$fgetmAppIdleLock(AppStandbyController r0) {
        return r0.mAppIdleLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppStandbyProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9063$$Nest$fgetmAppStandbyProperties(AppStandbyController r0) {
        return r0.mAppStandbyProperties;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppsToRestoreToRare, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseSetArray m9064$$Nest$fgetmAppsToRestoreToRare(AppStandbyController r0) {
        return r0.mAppsToRestoreToRare;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9065$$Nest$fgetmContext(AppStandbyController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppStandbyHandler m9066$$Nest$fgetmHandler(AppStandbyController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingIdleStateChecks, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseLongArray m9067$$Nest$fgetmPendingIdleStateChecks(AppStandbyController r0) {
        return r0.mPendingIdleStateChecks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemExemptionAppOpMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m9068$$Nest$fgetmSystemExemptionAppOpMode(AppStandbyController r0) {
        return r0.mSystemExemptionAppOpMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemServicesReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9069$$Nest$fgetmSystemServicesReady(AppStandbyController r0) {
        return r0.mSystemServicesReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTriggerQuotaBumpOnNotificationSeen, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9070$$Nest$fputmTriggerQuotaBumpOnNotificationSeen(AppStandbyController r0, boolean r1) {
        r0.mTriggerQuotaBumpOnNotificationSeen = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAndUpdateStandbyState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9071$$Nest$mcheckAndUpdateStandbyState(AppStandbyController r0, String r1, int r2, int r3, long r4) {
        r0.checkAndUpdateStandbyState(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mevaluateSystemAppException, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9072$$Nest$mevaluateSystemAppException(AppStandbyController r0, String r1, int r2) {
        r0.evaluateSystemAppException(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$minformListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9073$$Nest$minformListeners(AppStandbyController r0, String r1, int r2, int r3, int r4, boolean r5) {
        r0.informListeners(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$minformParoleStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9074$$Nest$minformParoleStateChanged(AppStandbyController r0) {
        r0.informParoleStateChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$misDisplayOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9075$$Nest$misDisplayOn(AppStandbyController r0) {
        return r0.isDisplayOn();
    }

    /* JADX INFO: renamed from: -$$Nest$mreportContentProviderUsage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9076$$Nest$mreportContentProviderUsage(AppStandbyController r0, String r1, String r2, int r3) {
        r0.reportContentProviderUsage(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportExemptedSyncScheduled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9077$$Nest$mreportExemptedSyncScheduled(AppStandbyController r0, String r1, int r2) {
        r0.reportExemptedSyncScheduled(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportExemptedSyncStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9078$$Nest$mreportExemptedSyncStart(AppStandbyController r0, String r1, int r2) {
        r0.reportExemptedSyncStart(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportUnexemptedSyncScheduled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9079$$Nest$mreportUnexemptedSyncScheduled(AppStandbyController r0, String r1, int r2) {
        r0.reportUnexemptedSyncScheduled(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrestoreAppToRare, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9080$$Nest$mrestoreAppToRare(AppStandbyController r0, String r1, int r2, long r3, int r5) {
        r0.restoreAppToRare(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mtriggerListenerQuotaBump, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9081$$Nest$mtriggerListenerQuotaBump(AppStandbyController r0, String r1, int r2) {
        r0.triggerListenerQuotaBump(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePowerWhitelistCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9082$$Nest$mupdatePowerWhitelistCache(AppStandbyController r0) {
        r0.updatePowerWhitelistCache();
    }

    /* JADX INFO: renamed from: -$$Nest$mwaitForAdminData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9083$$Nest$mwaitForAdminData(AppStandbyController r0) {
        r0.waitForAdminData();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTHRESHOLD_BUCKETS, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m9084$$Nest$sfgetTHRESHOLD_BUCKETS() {
        return THRESHOLD_BUCKETS;
    }

    static {
        DEFAULT_SCREEN_TIME_THRESHOLDS = new long[]{0, 0, 3600000, 7200000, 21600000};
        MINIMUM_SCREEN_TIME_THRESHOLDS = new long[]{0, 0, 0, 1800000, 3600000};
        DEFAULT_ELAPSED_TIME_THRESHOLDS = new long[]{0, 43200000, 86400000, 172800000, 691200000};
        MINIMUM_ELAPSED_TIME_THRESHOLDS = new long[]{0, 3600000, 3600000, 7200000, 14400000};
        THRESHOLD_BUCKETS = new int[]{10, 20, 30, 40, 45};
    }

    public AppStandbyController(Context context) {
        this(new Injector(context, AppSchedulingModuleThread.get().getLooper()));
    }

    AppStandbyController(Injector injector) {
        this.mAppIdleLock = new Lock();
        this.mPackageAccessListeners = new ArrayList();
        this.mCarrierPrivilegedLock = new Lock();
        this.mActiveAdminApps = new SparseArray();
        this.mAdminProtectedPackages = new SparseArray();
        this.mHeadlessSystemApps = new ArraySet();
        this.mAdminDataAvailableLatch = new CountDownLatch(1);
        this.mPendingIdleStateChecks = new SparseLongArray();
        this.mSystemExemptionAppOpMode = new SparseIntArray();
        AppStandbyControllerIA r0 = null;
        this.mCachedNetworkScorer = null;
        this.mCachedNetworkScorerAtMillis = 0;
        this.mCachedDeviceProvisioningPackage = null;
        this.mCheckIdleIntervalMillis = Math.min(DEFAULT_ELAPSED_TIME_THRESHOLDS[1] / 4, 14400000);
        this.mAppStandbyScreenThresholds = DEFAULT_SCREEN_TIME_THRESHOLDS;
        this.mAppStandbyElapsedThresholds = DEFAULT_ELAPSED_TIME_THRESHOLDS;
        this.mStrongUsageTimeoutMillis = 3600000;
        this.mNotificationSeenTimeoutMillis = 43200000;
        this.mSlicePinnedTimeoutMillis = 43200000;
        this.mNotificationSeenPromotedBucket = 20;
        this.mTriggerQuotaBumpOnNotificationSeen = false;
        this.mRetainNotificationSeenImpactForPreTApps = false;
        this.mSystemUpdateUsageTimeoutMillis = 7200000;
        this.mPredictionTimeoutMillis = 43200000;
        this.mSyncAdapterTimeoutMillis = 600000;
        this.mSyncAdapaterPromotedBucket = 10;
        this.mExemptedSyncScheduledNonDozeTimeoutMillis = 600000;
        this.mExemptedSyncScheduledDozeTimeoutMillis = 14400000;
        this.mExemptedSyncStartTimeoutMillis = 600000;
        this.mUnexemptedSyncScheduledTimeoutMillis = 600000;
        this.mSystemInteractionTimeoutMillis = 600000;
        this.mInitialForegroundServiceStartTimeoutMillis = 1800000;
        this.mLinkCrossProfileApps = true;
        this.mBroadcastResponseWindowDurationMillis = 120000;
        this.mBroadcastResponseFgThresholdState = 2;
        this.mBroadcastSessionsDurationMs = 120000;
        this.mBroadcastSessionsWithResponseDurationMs = 120000;
        this.mNoteResponseEventForAllBroadcastSessions = true;
        this.mBroadcastResponseExemptedRoles = "";
        this.mBroadcastResponseExemptedRolesList = Collections.EMPTY_LIST;
        this.mBroadcastResponseExemptedPermissions = "";
        this.mBroadcastResponseExemptedPermissionsList = Collections.EMPTY_LIST;
        this.mAppStandbyProperties = new ArrayMap();
        this.mAppsToRestoreToRare = new SparseSetArray();
        this.mSystemPackagesAppIds = new ArrayList();
        this.mSystemServicesReady = false;
        this.mDisplayListener = new AnonymousClass2(this);
        this.mInjector = injector;
        this.mContext = this.mInjector.getContext();
        this.mHandler = new AppStandbyHandler(this, this.mInjector.getLooper());
        this.mPackageManager = this.mContext.getPackageManager();
        this.mHasFeatureTelephonySubscription = this.mPackageManager.hasSystemFeature("android.hardware.telephony.subscription");
        DeviceStateReceiver deviceStateReceiver = new DeviceStateReceiver(this, r0);
        IntentFilter deviceStates = new IntentFilter("android.os.action.CHARGING");
        deviceStates.addAction("android.os.action.DISCHARGING");
        deviceStates.addAction("android.os.action.POWER_SAVE_WHITELIST_CHANGED");
        this.mContext.registerReceiver(deviceStateReceiver, deviceStates);
        Object r3 = this.mAppIdleLock;
        monitor-enter(r3);
        this.mAppIdleHistory = new AppIdleHistory(this.mInjector.getDataSystemDirectory(), this.mInjector.elapsedRealtime());     // Catch: Throwable -> L8
        this.mPowerAdvisorInternal = (PowerAdvisorInternal) LocalServices.getService(PowerAdvisorInternal.class);     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(new PackageReceiver(this, r0), UserHandle.ALL, packageFilter, null, this.mHandler);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setAppIdleEnabled(boolean enabled) {
        UsageStatsManagerInternal usmi = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        if (enabled == false) goto L5;
        usmi.registerListener(this);
    L6:
        Object r1 = this.mAppIdleLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mAppIdleEnabled == enabled) goto L15;
        boolean oldParoleState = isInParole();     // Catch: Throwable -> L13
        this.mAppIdleEnabled = enabled;     // Catch: Throwable -> L13
        if (isInParole() == oldParoleState) goto L15;
        postParoleStateChanged();     // Catch: Throwable -> L13
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L5:
        usmi.unregisterListener(this);
        goto L6
    }

    public boolean isAppIdleEnabled() {
        return this.mAppIdleEnabled;
    }

    public void onBootPhase(int phase) {
        this.mInjector.onBootPhase(phase);
        if (phase != 500) goto L36;
        Slog.d(TAG, "Setting app idle enabled state");
        if (this.mAppIdleEnabled == false) goto L7;
        ((UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class)).registerListener(this);
    L7:
        ConstantsObserver settingsObserver = new ConstantsObserver(this, this.mHandler);
        settingsObserver.start();
        this.mAppWidgetManager = (AppWidgetManager) this.mContext.getSystemService(AppWidgetManager.class);
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        IAppOpsService iAppOpsService = this.mInjector.getAppOpsService();
        iAppOpsService.startWatchingMode(128, null, new AnonymousClass1(this));     // Catch: RemoteException -> L10
    L12:
        this.mInjector.registerDisplayListener(this.mDisplayListener, this.mHandler);
        Object r2 = this.mAppIdleLock;
        monitor-enter(r2);
        this.mAppIdleHistory.updateDisplay(isDisplayOn(), this.mInjector.elapsedRealtime());     // Catch: Throwable -> L32
        monitor-exit(r2);     // Catch: Throwable -> L32
        this.mSystemServicesReady = true;
        Object r3 = this.mAppIdleLock;
        monitor-enter(r3);
        boolean userFileExists = this.mAppIdleHistory.userFileExists(0);     // Catch: Throwable -> L29
        monitor-exit(r3);     // Catch: Throwable -> L29
        if (this.mPendingInitializeDefaults == true) goto L23;
        if (userFileExists == false) goto L23;
    L24:
        List<ApplicationInfo> systemApps = this.mPackageManager.getInstalledApplications(SYSTEM_PACKAGE_FLAGS);
        int i = 0;
        int size = systemApps.size();
    L25:
        if (i >= size) goto L47;
        ApplicationInfo appInfo = systemApps.get(i);
        this.mSystemPackagesAppIds.add(Integer.valueOf(UserHandle.getAppId(appInfo.uid)));
        i = i + 1;
        goto L25
    L47:
        return;
    L23:
        initializeDefaultsForSystemApps(0);
    L29:
        th = move-exception;
        throw th;
    L32:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        Slog.wtf(TAG, "Failed start watching for app op", e);
        goto L12
    L36:
        if (phase != 1000) goto L46;
        setChargingState(this.mInjector.isCharging());
        this.mHandler.post(new AppStandbyController$$ExternalSyntheticLambda0(this));
        this.mHandler.post(new AppStandbyController$$ExternalSyntheticLambda1(this));
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:? -> B:20:0x0056). Please report as a decompilation issue!!! */
    private void reportContentProviderUsage(String authority, String providerPkgName, int userId) {
        AppStandbyController r1 = this;
        int r3 = userId;
        if (r1.mAppIdleEnabled == true) goto L5;
        return;
    L5:
        String[] packages = ContentResolver.getSyncAdapterPackagesForAuthorityAsUser(authority, r3);
        PackageManagerInternal pmi = r1.mInjector.getPackageManagerInternal();
        long elapsedRealtime = r1.mInjector.elapsedRealtime();
        int r0 = packages.length;
        int r14 = 0;
    L6:
        if (r14 >= r0) goto L28;
        String packageName = packages[r14];
        if (packageName.equals(providerPkgName) == true) goto L26;
        int appId = UserHandle.getAppId(pmi.getPackageUid(packageName, 0, r3));
        if (r1.mSystemPackagesAppIds.contains(Integer.valueOf(appId)) == false) goto L26;
        List<UserHandle> linkedProfiles = r1.getCrossProfileTargets(packageName, r3);
        Object r4 = r1.mAppIdleLock;
        monitor-enter(r4);
        Object r17 = r4;
        r1.reportNoninteractiveUsageCrossUserLocked(packageName, r3, r1.mSyncAdapaterPromotedBucket, 8, elapsedRealtime, r1.mSyncAdapterTimeoutMillis, linkedProfiles);     // Catch: Throwable -> L20
        monitor-exit(r17);     // Catch: Throwable -> L20
    L20:
        th = th;
    L24:
        monitor-exit(r17);     // Catch: Throwable -> L20
        throw th;
    L22:
        th = th;
        r17 = r4;
    L26:
        r14 = r14 + 1;
        r1 = this;
        r3 = userId;
        goto L6
    }

    private void reportExemptedSyncScheduled(String packageName, int userId) {
        if (this.mAppIdleEnabled == true) goto L6;
        return;
    L6:
        if (this.mInjector.isDeviceIdleMode() == true) goto L8;
        int usageReason = 11;
        long durationMillis = this.mExemptedSyncScheduledNonDozeTimeoutMillis;
        int bucketToPromote = 10;
    L9:
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        List<UserHandle> linkedProfiles = getCrossProfileTargets(packageName, userId);
        Object r11 = this.mAppIdleLock;
        monitor-enter(r11);
        reportNoninteractiveUsageCrossUserLocked(packageName, userId, bucketToPromote, usageReason, elapsedRealtime, durationMillis, linkedProfiles);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L8:
        usageReason = 12;
        durationMillis = this.mExemptedSyncScheduledDozeTimeoutMillis;
        bucketToPromote = 20;
        goto L9
    }

    private void reportUnexemptedSyncScheduled(String packageName, int userId) {
        if (this.mAppIdleEnabled == true) goto L5;
        return;
    L5:
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        Object r11 = this.mAppIdleLock;
        monitor-enter(r11);
        int currentBucket = this.mAppIdleHistory.getAppStandbyBucket(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L14
        if (currentBucket != 50) goto L17;
        List<UserHandle> linkedProfiles = getCrossProfileTargets(packageName, userId);     // Catch: Throwable -> L14
        reportNoninteractiveUsageCrossUserLocked(packageName, userId, 20, 14, elapsedRealtime, this.mUnexemptedSyncScheduledTimeoutMillis, linkedProfiles);     // Catch: Throwable -> L12
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Throwable r13 = th;
    L19:
        monitor-exit(r11);     // Catch: Throwable -> L12
        throw r13;
    L14:
        th = move-exception;
        r13 = th;
        goto L19
    }

    private void reportExemptedSyncStart(String packageName, int userId) {
        if (this.mAppIdleEnabled == true) goto L5;
        return;
    L5:
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        List<UserHandle> linkedProfiles = getCrossProfileTargets(packageName, userId);
        Object r11 = this.mAppIdleLock;
        monitor-enter(r11);
        reportNoninteractiveUsageCrossUserLocked(packageName, userId, 10, 13, elapsedRealtime, this.mExemptedSyncStartTimeoutMillis, linkedProfiles);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Throwable r13 = th;
    L16:
        monitor-exit(r11);     // Catch: Throwable -> L12
        throw r13;
    L14:
        th = move-exception;
        r13 = th;
        goto L16
    }

    private void reportNoninteractiveUsageCrossUserLocked(String packageName, int userId, int bucket, int subReason, long elapsedRealtime, long nextCheckDelay, List<UserHandle> otherProfiles) {
        reportNoninteractiveUsageLocked(packageName, userId, bucket, subReason, elapsedRealtime, nextCheckDelay);
        int size = otherProfiles.size();
        int profileIndex = 0;
    L3:
        if (profileIndex >= size) goto L6;
        int otherUserId = otherProfiles.get(profileIndex).getIdentifier();
        reportNoninteractiveUsageLocked(packageName, otherUserId, bucket, subReason, elapsedRealtime, nextCheckDelay);
        profileIndex = profileIndex + 1;
        goto L3
    }

    private void reportNoninteractiveUsageLocked(String packageName, int userId, int bucket, int subReason, long elapsedRealtime, long nextCheckDelay) {
        AppIdleHistory.AppUsageHistory appUsage = this.mAppIdleHistory.reportUsage(packageName, userId, bucket, subReason, 0, elapsedRealtime + nextCheckDelay);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(11, userId, -1, packageName), nextCheckDelay);
        maybeInformListeners(packageName, userId, elapsedRealtime, appUsage.currentBucket, appUsage.bucketingReason, false);
    }

    private void triggerListenerQuotaBump(String packageName, int userId) {
        if (this.mAppIdleEnabled == true) goto L5;
        return;
    L5:
        ArrayList<AppStandbyInternal.AppIdleStateChangeListener> r0 = this.mPackageAccessListeners;
        monitor-enter(r0);
        Iterator<AppStandbyInternal.AppIdleStateChangeListener> r1 = this.mPackageAccessListeners.iterator();     // Catch: Throwable -> L11
    L9:
        if (r1.hasNext() == false) goto L13;
        AppStandbyInternal.AppIdleStateChangeListener listener = r1.next();     // Catch: Throwable -> L11
        listener.triggerTemporaryQuotaBump(packageName, userId);     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void setChargingState(boolean isCharging) {
        if (this.mIsCharging == isCharging) goto L6;
        this.mIsCharging = isCharging;
        postParoleStateChanged();
        return;
    }

    public boolean isInParole() {
        if (this.mAppIdleEnabled == true) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsCharging == true) goto L8;
        return false;
    }

    private void postParoleStateChanged() {
        this.mHandler.removeMessages(9);
        this.mHandler.sendEmptyMessage(9);
    }

    public void postCheckIdleStates(int userId) {
        if (userId != (-1)) goto L5;
        postOneTimeCheckIdleStates();
        return;
    L5:
        SparseLongArray r0 = this.mPendingIdleStateChecks;
        monitor-enter(r0);
        this.mPendingIdleStateChecks.put(userId, this.mInjector.elapsedRealtime());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mHandler.obtainMessage(5).sendToTarget();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void postOneTimeCheckIdleStates() {
        if (this.mInjector.getBootPhase() >= 500) goto L5;
        this.mPendingOneTimeCheckIdleStates = true;
        return;
    L5:
        this.mHandler.sendEmptyMessage(10);
        this.mPendingOneTimeCheckIdleStates = false;
    }

    boolean checkIdleStates(int checkUserId) {
        if (this.mAppIdleEnabled == true) goto L27;
        return false;
    L27:
        int[] runningUserIds = this.mInjector.getRunningUserIds();     // Catch: RemoteException -> L10
        if (checkUserId == (-1)) goto L12;
        if (ArrayUtils.contains(runningUserIds, checkUserId) == true) goto L12;
        return false;
    L12:
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        int i = 0;
    L14:
        if (i >= runningUserIds.length) goto L23;
        int userId = runningUserIds[i];
        if (checkUserId == (-1)) goto L19;
        if (checkUserId == userId) goto L19;
    L22:
        i = i + 1;
    L19:
        List<PackageInfo> packages = this.mPackageManager.getInstalledPackagesAsUser(512, userId);
        int packageCount = packages.size();
        int p = 0;
    L20:
        if (p >= packageCount) goto L22;
        PackageInfo pi = packages.get(p);
        String packageName = pi.packageName;
        checkAndUpdateStandbyState(packageName, userId, pi.applicationInfo.uid, elapsedRealtime);
        p = p + 1;
        goto L20
    L23:
        return true;
    L10:
        re = move-exception;
        throw re.rethrowFromSystemServer();
    }

    private void checkAndUpdateStandbyState(String packageName, int userId, int uid, long elapsedRealtime) {
        AppStandbyController r1 = this;
        String r2 = packageName;
        int r3 = userId;
        if (uid <= 0) goto L122;
        int uid2 = uid;
    L9:
        int minBucket = r1.getAppMinBucket(r2, UserHandle.getAppId(uid2), r3);
        if (minBucket > 10) goto L31;
        Object r10 = r1.mAppIdleLock;
        monitor-enter(r10);
        boolean previouslyIdle = r1.mAppIdleHistory.isIdle(r2, r3, elapsedRealtime);     // Catch: Throwable -> L21
        r1.mAppIdleHistory.setAppStandbyBucket(packageName, r3, elapsedRealtime, minBucket, 256);     // Catch: Throwable -> L23
        r2 = packageName;
        r3 = r3;
        minBucket = minBucket;
        boolean previouslyIdle2 = r1.mAppIdleHistory.isIdle(r2, r3, elapsedRealtime);     // Catch: Throwable -> L21
        monitor-exit(r10);     // Catch: Throwable -> L21
        r1.maybeInformListeners(r2, r3, elapsedRealtime, minBucket, 256, false);
    L102:
        if (previouslyIdle == previouslyIdle2) goto L133;
        r1.notifyBatteryStats(r2, r3, previouslyIdle2);
        return;
    L133:
        return;
    L23:
        th = th;
    L113:
        monitor-exit(r10);     // Catch: Throwable -> L29
        throw th;
    L29:
        th = th;
    L25:
        th = th;
    L21:
        th = th;
        goto L113
    L31:
        Object r11 = r1.mAppIdleLock;
        monitor-enter(r11);
        boolean previouslyIdle3 = r1.mAppIdleHistory.isIdle(r2, r3, elapsedRealtime);     // Catch: Throwable -> L109
        AppIdleHistory.AppUsageHistory app = r1.mAppIdleHistory.getAppUsageHistory(r2, r3, elapsedRealtime);     // Catch: Throwable -> L109
        int reason = app.bucketingReason;     // Catch: Throwable -> L109
        int oldMainReason = reason & JobPackageTracker.EVENT_STOP_REASON_MASK;
        if (oldMainReason != 1024) goto L40;
        monitor-exit(r11);     // Catch: Throwable -> L38
        return;
    L40:
        int oldBucket = app.currentBucket;     // Catch: Throwable -> L109
        if (oldBucket != 50) goto L45;
        monitor-exit(r11);     // Catch: Throwable -> L38
        return;
    L45:
        int newBucket = Math.max(oldBucket, 10);     // Catch: Throwable -> L109
        boolean predictionLate = r1.predictionTimedOut(app, elapsedRealtime);     // Catch: Throwable -> L109
        if (oldMainReason != 256) goto L49;
    L53:
        if (predictionLate == true) goto L60;
        if (app.lastPredictedBucket < 10) goto L60;
        if (app.lastPredictedBucket > 40) goto L60;
        newBucket = app.lastPredictedBucket;     // Catch: Throwable -> L38
        reason = UsbTerminalTypes.TERMINAL_TELE_PHONELINE;
    L65:
        long elapsedTimeAdjusted = r1.mAppIdleHistory.getElapsedTime(elapsedRealtime);     // Catch: Throwable -> L109
        int bucketWithValidExpiryTime = r1.getMinBucketWithValidExpiryTime(app, newBucket, elapsedTimeAdjusted);     // Catch: Throwable -> L75
        int reason2 = reason;
        if (bucketWithValidExpiryTime == (-1)) goto L78;
        newBucket = bucketWithValidExpiryTime;
        if (newBucket == 10) goto L77;
        if (app.currentBucket == newBucket) goto L77;
        int reason3 = 775;
    L79:
        int reason4 = reason3;
        if (app.lastUsedByUserElapsedTime >= 0) goto L82;
    L86:
        int newBucket2 = newBucket;
        int newBucket3 = reason4;
    L87:
        if (newBucket2 <= minBucket) goto L89;
        newBucket2 = minBucket;
    L89:
        if (oldBucket != newBucket2) goto L93;
        if (predictionLate == true) goto L93;
        boolean stillIdle = previouslyIdle3;
        r1 = r1;
    L100:
        monitor-exit(r11);     // Catch: Throwable -> L105
        previouslyIdle = previouslyIdle3;
        previouslyIdle2 = stillIdle;
    L93:
        int newBucket4 = newBucket2;
        r1.mAppIdleHistory.setAppStandbyBucket(r2, r3, elapsedRealtime, newBucket4, newBucket3);     // Catch: Throwable -> L107
        r3 = r3;
        r2 = r2;
        stillIdle = r1.mAppIdleHistory.isIdle(r2, r3, elapsedRealtime);     // Catch: Throwable -> L75
        r1 = r1;
        r1.maybeInformListeners(r2, r3, elapsedRealtime, newBucket4, newBucket3, false);     // Catch: Throwable -> L105
    L107:
        th = th;
    L111:
        monitor-exit(r11);     // Catch: Throwable -> L105
        throw th;
    L82:
        if (app.lastRestrictAttemptElapsedTime <= app.lastUsedByUserElapsedTime) goto L86;
        if ((elapsedTimeAdjusted - app.lastUsedByUserElapsedTime) < r1.mInjector.getAutoRestrictedBucketDelayMs()) goto L86;
        newBucket2 = 45;
        newBucket3 = app.lastRestrictReason;     // Catch: Throwable -> L75
    L77:
        reason3 = app.bucketingReason;     // Catch: Throwable -> L75
        goto L79
    L78:
        reason3 = reason2;
    L75:
        th = th;
    L60:
        if (oldMainReason == 256) goto L63;
    L64:
        newBucket = r1.getBucketForLocked(r2, r3, elapsedRealtime);     // Catch: Throwable -> L109
        reason = 512;
        goto L65
    L63:
        if ((app.bucketingReason & 255) == 2) goto L65;
    L49:
        if (oldMainReason == 768) goto L53;
        if (oldMainReason == 512) goto L53;
        if (predictionLate == false) goto L65;
    L38:
        th = th;
    L109:
        th = th;
    L105:
        th = th;
        goto L111
    L122:
        uid2 = r1.mPackageManager.getPackageUidAsUser(r2, r3);     // Catch: PackageManager.NameNotFoundException -> L6
    }

    private boolean predictionTimedOut(AppIdleHistory.AppUsageHistory app, long elapsedRealtime) {
        if (app.lastPredictedTime > 0) goto L5;
    L7:
        return false;
    L5:
        if ((this.mAppIdleHistory.getElapsedTime(elapsedRealtime) - app.lastPredictedTime) <= this.mPredictionTimeoutMillis) goto L7;
        return true;
    }

    private void maybeInformListeners(String packageName, int userId, long elapsedRealtime, int bucket, int reason, boolean userStartedInteracting) {
        Object r1 = this.mAppIdleLock;
        monitor-enter(r1);
        if (this.mAppIdleHistory.shouldInformListeners(packageName, userId, elapsedRealtime, bucket) == false) goto L11;
        StandbyUpdateRecord r = StandbyUpdateRecord.obtain(packageName, userId, bucket, reason, userStartedInteracting);     // Catch: Throwable -> L9
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, r));     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L13:
        th = move-exception;
        r9 = th;
        goto L15
    }

    private int getBucketForLocked(String packageName, int userId, long elapsedRealtime) {
        int bucketIndex = this.mAppIdleHistory.getThresholdIndex(packageName, userId, elapsedRealtime, this.mAppStandbyScreenThresholds, this.mAppStandbyElapsedThresholds);
        if (bucketIndex >= 0) goto L7;
        return 50;
    L7:
        return THRESHOLD_BUCKETS[bucketIndex];
    }

    private void notifyBatteryStats(String packageName, int userId, boolean idle) {
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, 8192, userId);     // Catch: Throwable -> L5
        if (idle == false) goto L7;
        this.mInjector.noteEvent(15, packageName, uid);     // Catch: Throwable -> L5
    L10:
        return;
    L7:
        this.mInjector.noteEvent(16, packageName, uid);     // Catch: Throwable -> L5
    }

    @Override // android.app.usage.UsageStatsManagerInternal.UsageEventListener
    public void onUsageEvent(int userId, UsageEvents.Event event) {
        if (this.mAppIdleEnabled == true) goto L5;
        return;
    L5:
        int eventType = event.getEventType();
        if (eventType != 1) goto L8;
    L23:
        String pkg = event.getPackageName();
        String extraDisplayInfo = event.getExtraDisplayInfo();
        List<UserHandle> linkedProfiles = getCrossProfileTargets(pkg, userId);
        Object r9 = this.mAppIdleLock;
        monitor-enter(r9);
        long elapsedRealtime = this.mInjector.elapsedRealtime();     // Catch: Throwable -> L31
        reportEventLocked(pkg, eventType, elapsedRealtime, userId, extraDisplayInfo);     // Catch: Throwable -> L36
        int size = linkedProfiles.size();     // Catch: Throwable -> L31
        int profileIndex = 0;
    L29:
        if (profileIndex >= size) goto L34;
        int linkedUserId = linkedProfiles.get(profileIndex).getIdentifier();     // Catch: Throwable -> L31
        reportEventLocked(pkg, eventType, elapsedRealtime, linkedUserId, extraDisplayInfo);     // Catch: Throwable -> L31
        profileIndex = profileIndex + 1;     // Catch: Throwable -> L31
        goto L29
    L34:
        monitor-exit(r9);     // Catch: Throwable -> L31
        return;
    L36:
        th = th;
    L38:
        monitor-exit(r9);     // Catch: Throwable -> L31
        throw th;
    L31:
        th = th;
        goto L38
    L8:
        if (eventType == 2) goto L23;
        if (eventType == 6) goto L23;
        if (eventType == 7) goto L23;
        if (eventType == 10) goto L23;
        if (eventType == 14) goto L23;
        if (eventType == 13) goto L23;
        if (eventType == 19) goto L23;
        if (eventType == 32) goto L23;
    }

    private void reportEventLocked(String pkg, int eventType, long elapsedRealtime, int userId) {
        reportEventLocked(pkg, eventType, elapsedRealtime, userId, null);
    }

    private void reportEventLocked(String pkg, int eventType, long elapsedRealtime, int userId, String extraDisplayInfo) {
        boolean previouslyIdle = this.mAppIdleHistory.isIdle(pkg, userId, elapsedRealtime);
        AppIdleHistory.AppUsageHistory appHistory = this.mAppIdleHistory.getAppUsageHistory(pkg, userId, elapsedRealtime);
        int prevBucket = appHistory.currentBucket;
        int prevBucketReason = appHistory.bucketingReason;
        int subReason = usageEventToSubReason(eventType);
        int reason = subReason | 768;
        if (eventType == 10) goto L5;
        int prevBucket2 = prevBucket;
        int prevBucketReason2 = prevBucketReason;
        int reason2 = reason;
        int r13 = -1;
        if (eventType != 14) goto L18;
        this.mAppIdleHistory.reportUsage(appHistory, pkg, userId, 20, subReason, 0, elapsedRealtime + this.mSlicePinnedTimeoutMillis);
        long nextCheckDelay = this.mSlicePinnedTimeoutMillis;
        String r3 = pkg;
        int r4 = userId;
    L27:
        boolean stillIdle = false;
        if (appHistory.currentBucket == prevBucket2) goto L37;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(11, r4, r13, r3), nextCheckDelay);
        if (appHistory.currentBucket == 10) goto L32;
    L34:
        boolean userStartedInteracting = false;
    L35:
        int r5 = appHistory.currentBucket;
        String r1 = r3;
        int r2 = r4;
        maybeInformListeners(r1, r2, elapsedRealtime, r5, reason2, userStartedInteracting);
        r3 = r1;
        r4 = r2;
        goto L37
    L32:
        if ((prevBucketReason2 & JobPackageTracker.EVENT_STOP_REASON_MASK) == 768) goto L34;
        userStartedInteracting = true;
    L37:
        this.mPowerAdvisorInternal.reportEvent(eventType, r3, r4, extraDisplayInfo);
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().appFrontEvent(eventType, r3, r4, extraDisplayInfo);
        if (appHistory.currentBucket < 40) goto L40;
        stillIdle = true;
    L40:
        if (previouslyIdle == stillIdle) goto L43;
        notifyBatteryStats(r3, r4, stillIdle);
        return;
    L43:
        return;
    L18:
        if (eventType != 6) goto L21;
        this.mAppIdleHistory.reportUsage(appHistory, pkg, userId, 10, subReason, 0, elapsedRealtime + this.mSystemInteractionTimeoutMillis);
        nextCheckDelay = this.mSystemInteractionTimeoutMillis;
        r3 = pkg;
        r4 = userId;
        goto L27
    L21:
        if (eventType == 19) goto L23;
        r3 = pkg;
        r4 = userId;
        this.mAppIdleHistory.reportUsage(appHistory, r3, r4, 10, subReason, elapsedRealtime, elapsedRealtime + this.mStrongUsageTimeoutMillis);
        nextCheckDelay = this.mStrongUsageTimeoutMillis;
        goto L27
    L23:
        if (prevBucket2 == 50) goto L25;
        return;
    L25:
        this.mAppIdleHistory.reportUsage(appHistory, pkg, userId, 10, subReason, 0, elapsedRealtime + this.mInitialForegroundServiceStartTimeoutMillis);
        nextCheckDelay = this.mInitialForegroundServiceStartTimeoutMillis;
        r3 = pkg;
        r4 = userId;
        goto L27
    L5:
        if (this.mRetainNotificationSeenImpactForPreTApps == false) goto L10;
        if (getTargetSdkVersion(pkg) >= 33) goto L10;
        int notificationSeenPromotedBucket = 20;
        long notificationSeenTimeoutMillis = 43200000;
    L13:
        reason2 = reason;
        prevBucketReason2 = prevBucketReason;
        prevBucket2 = prevBucket;
        r13 = -1;
        this.mAppIdleHistory.reportUsage(appHistory, pkg, userId, notificationSeenPromotedBucket, subReason, 0, elapsedRealtime + notificationSeenTimeoutMillis);
        r3 = pkg;
        r4 = userId;
        nextCheckDelay = notificationSeenTimeoutMillis;
    L10:
        if (this.mTriggerQuotaBumpOnNotificationSeen == false) goto L12;
        this.mHandler.obtainMessage(7, userId, -1, pkg).sendToTarget();
    L12:
        int notificationSeenPromotedBucket2 = this.mNotificationSeenPromotedBucket;
        notificationSeenPromotedBucket = notificationSeenPromotedBucket2;
        notificationSeenTimeoutMillis = this.mNotificationSeenTimeoutMillis;
        goto L13
    }

    private int getTargetSdkVersion(String packageName) {
        return this.mInjector.getPackageManagerInternal().getPackageTargetSdkVersion(packageName);
    }

    private int getMinBucketWithValidExpiryTime(AppIdleHistory.AppUsageHistory usageHistory, int targetBucket, long elapsedTimeMs) {
        if (usageHistory.bucketExpiryTimesMs != null) goto L5;
        return -1;
    L5:
        int size = usageHistory.bucketExpiryTimesMs.size();
        int i = 0;
    L6:
        if (i >= size) goto L14;
        int bucket = usageHistory.bucketExpiryTimesMs.keyAt(i);
        if (targetBucket <= bucket) goto L14;
        long expiryTimeMs = usageHistory.bucketExpiryTimesMs.valueAt(i);
        if (expiryTimeMs > elapsedTimeMs) goto L12;
        i = i + 1;
        goto L6
    L12:
        return bucket;
    L14:
        return -1;
    }

    private List<UserHandle> getCrossProfileTargets(String pkg, int userId) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mLinkCrossProfileApps == true) goto L11;
        List<UserHandle> r1 = Collections.emptyList();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return this.mInjector.getValidCrossProfileTargets(pkg, userId);
    }

    private int usageEventToSubReason(int eventType) {
        switch(eventType) {
            case 1: goto L19;
            case 2: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 10: goto L11;
            case 13: goto L9;
            case 14: goto L7;
            case 19: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 15;
    L7:
        return 9;
    L9:
        return 10;
    L11:
        return 2;
    L13:
        return 3;
    L15:
        return 1;
    L17:
        return 5;
    L19:
        return 4;
    }

    void forceIdleState(String packageName, int userId, boolean idle) {
        if (this.mAppIdleEnabled == true) goto L5;
        return;
    L5:
        int appId = getAppId(packageName);
        if (appId >= 0) goto L8;
        return;
    L8:
        int minBucket = getAppMinBucket(packageName, appId, userId);
        if (idle == true) goto L11;
    L14:
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        boolean previouslyIdle = isAppIdleFiltered(packageName, appId, userId, elapsedRealtime);
        Object r8 = this.mAppIdleLock;
        monitor-enter(r8);
        int standbyBucket = this.mAppIdleHistory.setIdle(packageName, userId, idle, elapsedRealtime);     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        boolean stillIdle = isAppIdleFiltered(packageName, appId, userId, elapsedRealtime);
        maybeInformListeners(packageName, userId, elapsedRealtime, standbyBucket, 1024, false);
        if (previouslyIdle == stillIdle) goto L33;
        notifyBatteryStats(packageName, userId, stillIdle);
        return;
    L33:
        return;
    L22:
        th = th;
    L30:
        throw th;
    L26:
        th = th;
        goto L30
    L11:
        if (minBucket >= 40) goto L14;
        Slog.e(TAG, "Tried to force an app to be idle when its min bucket is " + UsageStatsManager.standbyBucketToString(minBucket));
    }

    public void setLastJobRunTime(String packageName, int userId, long elapsedRealtime) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        this.mAppIdleHistory.setLastJobRunTime(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public long getTimeSinceLastJobRun(String packageName, int userId) {
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        Object r2 = this.mAppIdleLock;
        monitor-enter(r2);
        long r3 = this.mAppIdleHistory.getTimeSinceLastJobRun(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void setEstimatedLaunchTime(String packageName, int userId, long launchTime) {
        long nowElapsed = this.mInjector.elapsedRealtime();
        Object r8 = this.mAppIdleLock;
        monitor-enter(r8);
        this.mAppIdleHistory.setEstimatedLaunchTime(packageName, userId, nowElapsed, launchTime);     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L9
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public long getEstimatedLaunchTime(String packageName, int userId) {
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        Object r2 = this.mAppIdleLock;
        monitor-enter(r2);
        long r3 = this.mAppIdleHistory.getEstimatedLaunchTime(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public long getTimeSinceLastUsedByUser(String packageName, int userId) {
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        Object r2 = this.mAppIdleLock;
        monitor-enter(r2);
        long r3 = this.mAppIdleHistory.getTimeSinceLastUsedByUser(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUserRemoved(int userId) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        this.mAppIdleHistory.onUserRemoved(userId);     // Catch: Throwable -> L14
        SparseArray<Set<String>> r1 = this.mActiveAdminApps;     // Catch: Throwable -> L14
        monitor-enter(r1);     // Catch: Throwable -> L14
        this.mActiveAdminApps.remove(userId);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        SparseArray<Set<String>> r2 = this.mAdminProtectedPackages;     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        this.mAdminProtectedPackages.remove(userId);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private boolean isAppIdleUnfiltered(String packageName, int userId, long elapsedRealtime) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        boolean r1 = this.mAppIdleHistory.isIdle(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addListener(AppStandbyInternal.AppIdleStateChangeListener listener) {
        ArrayList<AppStandbyInternal.AppIdleStateChangeListener> r0 = this.mPackageAccessListeners;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPackageAccessListeners.contains(listener) == true) goto L9;
        this.mPackageAccessListeners.add(listener);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void removeListener(AppStandbyInternal.AppIdleStateChangeListener listener) {
        ArrayList<AppStandbyInternal.AppIdleStateChangeListener> r0 = this.mPackageAccessListeners;
        monitor-enter(r0);
        this.mPackageAccessListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getAppId(String packageName) {
        ApplicationInfo ai = this.mPackageManager.getApplicationInfo(packageName, 4194816);     // Catch: PackageManager.NameNotFoundException -> L4
        return ai.uid;
    L5:
        return -1;
    }

    public boolean isAppIdleFiltered(String packageName, int userId, long elapsedRealtime, boolean shouldObfuscateInstantApps) {
        if (shouldObfuscateInstantApps == false) goto L8;
        if (this.mInjector.isPackageEphemeral(userId, packageName) == false) goto L8;
        return false;
    L8:
        return isAppIdleFiltered(packageName, getAppId(packageName), userId, elapsedRealtime);
    }

    private int getAppMinBucket(String packageName, int userId) {
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L4
        return getAppMinBucket(packageName, UserHandle.getAppId(uid), userId);
    L5:
        return 50;
    }

    private int getAppMinBucket(String packageName, int appId, int userId) {
        if (packageName != null) goto L6;
        return 50;
    L6:
        if (this.mAppIdleEnabled == true) goto L9;
        return 5;
    L9:
        if (appId >= 10000) goto L12;
        return 5;
    L12:
        if (packageName.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L15;
        return 5;
    L15:
        if (this.mSystemServicesReady == false) goto L60;
        if (this.mInjector.isNonIdleWhitelisted(packageName) == false) goto L20;
        return 5;
    L20:
        if (isActiveDeviceAdmin(packageName, userId) == false) goto L23;
        return 5;
    L23:
        if (isAdminProtectedPackages(packageName, userId) == false) goto L26;
        return 5;
    L26:
        if (isActiveNetworkScorer(packageName) == false) goto L28;
        return 5;
    L28:
        int uid = UserHandle.getUid(userId, appId);
        SparseIntArray r4 = this.mSystemExemptionAppOpMode;
        monitor-enter(r4);
    L36:
        th = move-exception;
        throw th;
    L31:
        if (this.mSystemExemptionAppOpMode.indexOfKey(uid) >= 0) goto L33;
        int mode = this.mAppOpsManager.checkOpNoThrow(128, uid, packageName);     // Catch: Throwable -> L36
        this.mSystemExemptionAppOpMode.put(uid, mode);     // Catch: Throwable -> L36
        if (mode != 0) goto L42;
        monitor-exit(r4);     // Catch: Throwable -> L36
        return 5;
    L42:
        monitor-exit(r4);     // Catch: Throwable -> L36
        if (this.mAppWidgetManager == null) goto L49;
        if (this.mInjector.isBoundWidgetPackage(this.mAppWidgetManager, packageName, userId) == false) goto L49;
        return 10;
    L49:
        if (isDeviceProvisioningPackage(packageName) == false) goto L52;
        return 5;
    L52:
        if (this.mInjector.isWellbeingPackage(packageName) == false) goto L55;
        return 20;
    L55:
        if (this.mInjector.shouldGetExactAlarmBucketElevation(packageName, UserHandle.getUid(userId, appId)) == false) goto L60;
        return 20;
    L33:
        if (this.mSystemExemptionAppOpMode.get(uid) != 0) goto L42;
        monitor-exit(r4);     // Catch: Throwable -> L36
        return 5;
    L60:
        if (this.mHasFeatureTelephonySubscription == false) goto L65;
        if (isCarrierApp(packageName) == false) goto L65;
        return 5;
    L65:
        if (isHeadlessSystemApp(packageName) == false) goto L68;
        return 10;
    L68:
        if (this.mPackageManager.checkPermission("android.permission.ACCESS_BACKGROUND_LOCATION", packageName) != 0) goto L71;
        return 30;
    L71:
        return 50;
    }

    private boolean isHeadlessSystemApp(String packageName) {
        ArraySet<String> r0 = this.mHeadlessSystemApps;
        monitor-enter(r0);
        boolean r1 = this.mHeadlessSystemApps.contains(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAppIdleFiltered(String packageName, int appId, int userId, long elapsedRealtime) {
        if (this.mAppIdleEnabled == true) goto L5;
    L14:
        return false;
    L5:
        if (this.mIsCharging == true) goto L14;
        if (isAppIdleUnfiltered(packageName, userId, elapsedRealtime) == true) goto L10;
        return false;
    L10:
        if (getAppMinBucket(packageName, appId, userId) < 40) goto L16;
        return true;
    L16:
        return false;
    }

    static boolean isUserUsage(int reason) {
        if ((65280 & reason) != 768) goto L10;
        int subReason = reason & 255;
        if (subReason != 3) goto L7;
    L8:
        return true;
    L7:
        if (subReason == 4) goto L8;
        return false;
    L10:
        return false;
    }

    public int[] getIdleUidsForUser(int userId) {
        AppStandbyController r0 = this;
        if (r0.mAppIdleEnabled == false) goto L5;
        Trace.traceBegin(64, "getIdleUidsForUser");
        long elapsedRealtime = r0.mInjector.elapsedRealtime();
        PackageManagerInternal pmi = r0.mInjector.getPackageManagerInternal();
        int r9 = userId;
        List<ApplicationInfo> apps = pmi.getInstalledApplications(0, r9, Process.myUid());
        if (apps == null) goto L9;
        SparseBooleanArray uidIdleStates = new SparseBooleanArray();
        int notIdleCount = 0;
        int i = apps.size() - 1;
    L11:
        if (i < 0) goto L30;
        ApplicationInfo ai = apps.get(i);
        int index = uidIdleStates.indexOfKey(ai.uid);
        if (index >= 0) goto L15;
        boolean r2 = true;
    L16:
        boolean currentIdle = r2;
        if (currentIdle == false) goto L21;
        int r17 = r9;
        int index2 = index;
        if (r0.isAppIdleFiltered(ai.packageName, UserHandle.getAppId(ai.uid), r17, elapsedRealtime) == false) goto L22;
        boolean newIdle = true;
    L23:
        if (currentIdle == false) goto L26;
        if (newIdle == true) goto L26;
        notIdleCount = notIdleCount + 1;
    L26:
        if (index2 >= 0) goto L28;
        uidIdleStates.put(ai.uid, newIdle);
    L29:
        i = i - 1;
        r0 = this;
        r9 = userId;
        goto L11
    L28:
        uidIdleStates.setValueAt(index2, newIdle);
    L22:
        newIdle = false;
        goto L23
    L21:
        index2 = index;
        goto L22
    L15:
        r2 = uidIdleStates.valueAt(index);
        goto L16
    L30:
        int numIdleUids = uidIdleStates.size() - notIdleCount;
        int[] idleUids = new int[numIdleUids];
        int i2 = uidIdleStates.size() - 1;
    L31:
        if (i2 < 0) goto L36;
        if (uidIdleStates.valueAt(i2) == false) goto L35;
        numIdleUids = numIdleUids - 1;
        idleUids[numIdleUids] = uidIdleStates.keyAt(i2);
    L35:
        i2 = i2 - 1;
        goto L31
    L36:
        Trace.traceEnd(64);
        return idleUids;
    L9:
        return EmptyArray.INT;
    L5:
        return EmptyArray.INT;
    }

    public void setAppIdleAsync(String r3, boolean r4, int r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.mAppIdleEnabled == false) goto L9;
        this.mHandler.obtainMessage(4, r5, r4 ? 1 : 0, r3).sendToTarget();
        return;
    }

    public int getAppStandbyBucket(String packageName, int userId, long elapsedRealtime, boolean shouldObfuscateInstantApps) {
        if (this.mAppIdleEnabled == true) goto L6;
        return 5;
    L6:
        if (shouldObfuscateInstantApps == true) goto L8;
    L11:
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        int r1 = this.mAppIdleHistory.getAppStandbyBucket(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.mInjector.isPackageEphemeral(userId, packageName) == false) goto L11;
        return 10;
    }

    public int getAppStandbyBucketReason(String packageName, int userId, long elapsedRealtime) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        int r1 = this.mAppIdleHistory.getAppStandbyReason(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<AppStandbyInfo> getAppStandbyBuckets(int userId) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        ArrayList<AppStandbyInfo> r1 = this.mAppIdleHistory.getAppStandbyBuckets(userId, this.mAppIdleEnabled);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getAppMinStandbyBucket(String packageName, int appId, int userId, boolean shouldObfuscateInstantApps) {
        if (shouldObfuscateInstantApps == true) goto L4;
    L7:
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        int r1 = getAppMinBucket(packageName, appId, userId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mInjector.isPackageEphemeral(userId, packageName) == false) goto L7;
        return 50;
    }

    public void restrictApp(String packageName, int userId, int restrictReason) {
        restrictApp(packageName, userId, 1536, restrictReason);
    }

    public void restrictApp(String packageName, int userId, int mainReason, int restrictReason) {
        if (mainReason == 1536) goto L9;
        if (mainReason == 1024) goto L9;
        Slog.e(TAG, "Tried to restrict app " + packageName + " for an unsupported reason");
        return;
    L9:
        if (this.mInjector.isPackageInstalled(packageName, 0, userId) == true) goto L12;
        Slog.e(TAG, "Tried to restrict uninstalled app: " + packageName);
        return;
    L12:
        int reason = (65280 & mainReason) | (restrictReason & 255);
        long nowElapsed = this.mInjector.elapsedRealtime();
        setAppStandbyBucket(packageName, userId, 45, reason, nowElapsed, false);
    }

    public void restoreAppsToRare(Set<String> restoredApps, final int userId) {
        long nowElapsed = this.mInjector.elapsedRealtime();
        Iterator<String> r0 = restoredApps.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String packageName = r0.next();
        if (this.mInjector.isPackageInstalled(packageName, 0, userId) == false) goto L7;
        restoreAppToRare(packageName, userId, nowElapsed, 258);
        goto L4
    L7:
        Slog.i(TAG, "Tried to restore bucket for uninstalled app: " + packageName);
        this.mAppsToRestoreToRare.add(userId, packageName);
        goto L4
    L9:
        this.mHandler.postDelayed(new AppStandbyController$$ExternalSyntheticLambda2(this, userId), 172800000);
        Object r11 = this.mAppIdleLock;
        monitor-enter(r11);
        this.mAppIdleHistory.writeRestoreToRareAppsList(userId, this.mAppsToRestoreToRare.get(userId));     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$restoreAppsToRare$0(int userId) {
        this.mAppsToRestoreToRare.remove(userId);
    }

    private void restoreAppToRare(String pkgName, int userId, long nowElapsed, int reason) {
        int standbyBucket = getAppStandbyBucket(pkgName, userId, nowElapsed, false);
        if (standbyBucket != 50) goto L6;
        setAppStandbyBucket(pkgName, userId, 40, reason, nowElapsed, false);
        return;
    }

    public void setAppStandbyBucket(String packageName, int bucket, int userId, int callingUid, int callingPid) {
        setAppStandbyBuckets(Collections.singletonList(new AppStandbyInfo(packageName, bucket)), userId, callingUid, callingPid);
    }

    public void setAppStandbyBuckets(List<AppStandbyInfo> appBuckets, int userId, int callingUid, int callingPid) {
        AppStandbyController r0 = this;
        int userId2 = ActivityManager.handleIncomingUser(callingPid, callingUid, userId, false, true, "setAppStandbyBucket", null);
        if (callingUid != 0) goto L5;
    L9:
        boolean r1 = true;
    L8:
        boolean shellCaller = r1;
        if (UserHandle.isSameApp(callingUid, 1000) == false) goto L16;
        if (callingPid == Process.myPid()) goto L16;
    L17:
        int reason = 1024;
    L22:
        int numApps = appBuckets.size();
        long elapsedRealtime = r0.mInjector.elapsedRealtime();
        int i = 0;
    L23:
        if (i >= numApps) goto L39;
        AppStandbyInfo bucketInfo = appBuckets.get(i);
        String packageName = bucketInfo.mPackageName;
        int bucket = bucketInfo.mStandbyBucket;
        if (bucket < 10) goto L37;
        if (bucket > 50) goto L37;
        int reason2 = reason;
        long elapsedRealtime2 = elapsedRealtime;
        int packageUid = r0.mInjector.getPackageManagerInternal().getPackageUid(packageName, 4980736, userId2);
        if (packageUid == callingUid) goto L35;
        if (packageUid < 0) goto L33;
        int userId3 = userId2;
        reason = reason2;
        elapsedRealtime = elapsedRealtime2;
        r0.setAppStandbyBucket(packageName, userId3, bucket, reason, elapsedRealtime, shellCaller);
        i = i + 1;
        r0 = this;
        userId2 = userId3;
        goto L23
    L33:
        throw new IllegalArgumentException("Cannot set standby bucket for non existent package (" + packageName + ")");
    L35:
        throw new IllegalArgumentException("Cannot set your own standby bucket");
    L37:
        throw new IllegalArgumentException("Cannot set the standby bucket to " + bucket);
    L39:
        return;
    L16:
        if (shellCaller == true) goto L17;
        if (UserHandle.isCore(callingUid) == false) goto L21;
        reason = 1536;
        goto L22
    L21:
        reason = 1280;
        goto L22
    L5:
        if (callingUid == 2000) goto L9;
        r1 = false;
        goto L8
    }

    void setAppStandbyBucket(String packageName, int userId, int newBucket, int reason) {
        setAppStandbyBucket(packageName, userId, newBucket, reason, this.mInjector.elapsedRealtime(), false);
    }

    private void setAppStandbyBucket(String packageName, int userId, int newBucket, int reason, long elapsedRealtime, boolean resetTimeout) {
        if (this.mAppIdleEnabled == true) goto L5;
        return;
    L5:
        Object r10 = this.mAppIdleLock;
        monitor-enter(r10);
    L12:
        th = th;
    L197:
        monitor-exit(r10);     // Catch: Throwable -> L178
        throw th;
    L178:
        th = th;
        goto L197
    L8:
        if (this.mInjector.isPackageInstalled(packageName, 0, userId) == true) goto L14;
        Slog.e(TAG, "Tried to set bucket of uninstalled app: " + packageName);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L14:
        AppIdleHistory.AppUsageHistory app = this.mAppIdleHistory.getAppUsageHistory(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L12
        if ((reason & JobPackageTracker.EVENT_STOP_REASON_MASK) != 1280) goto L17;
        boolean r7 = true;
    L18:
        boolean predicted = r7;
        if (app.currentBucket >= 10) goto L23;
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L23:
        if (app.currentBucket == 50) goto L25;
        if (newBucket == 50) goto L25;
    L29:
        if ((app.bucketingReason & JobPackageTracker.EVENT_STOP_REASON_MASK) != 1536) goto L31;
        boolean r8 = true;
    L32:
        boolean wasForcedBySystem = r8;
        if (predicted == false) goto L39;
        int r16 = 65280;
        if ((app.bucketingReason & JobPackageTracker.EVENT_STOP_REASON_MASK) == 1024) goto L37;
        if (wasForcedBySystem == true) goto L37;
    L41:
        if ((reason & r16) != 1536) goto L43;
        boolean r2 = true;
    L44:
        boolean isForcedBySystem = r2;
        if (app.currentBucket != newBucket) goto L89;
        if (wasForcedBySystem == false) goto L89;
        if (isForcedBySystem == false) goto L89;
        if (newBucket == 45) goto L182;
        int r3 = reason;
    L199:
        int reason2 = ((app.bucketingReason & 255) | 1536) | (r3 & 255);
        if (app.currentBucket < 40) goto L64;
        boolean r4 = true;
    L65:
        boolean previouslyIdle = r4;
        this.mAppIdleHistory.setAppStandbyBucket(packageName, userId, elapsedRealtime, newBucket, reason2, resetTimeout);     // Catch: Throwable -> L79
        if (newBucket < 40) goto L72;
        boolean stillIdle = true;
    L73:
        if (previouslyIdle != stillIdle) goto L204;
    L77:
        monitor-exit(r10);     // Catch: Throwable -> L75
        return;
    L75:
        th = th;
        goto L197
    L204:
        notifyBatteryStats(packageName, userId, stillIdle);     // Catch: Throwable -> L75
        goto L77
    L72:
        stillIdle = false;
    L79:
        th = th;
    L82:
        th = th;
        goto L197
    L64:
        r4 = false;
    L84:
        th = th;
    L86:
        th = th;
        goto L197
    L182:
        this.mAppIdleHistory.noteRestrictionAttempt(packageName, userId, elapsedRealtime, reason);     // Catch: Throwable -> L54
        r3 = reason;
    L54:
        th = th;
    L56:
        th = th;
    L89:
        if ((reason & r16) != 1024) goto L91;
        boolean r5 = true;
    L92:
        boolean isForcedByUser = r5;
        if (app.currentBucket != 45) goto L109;
    L101:
        th = th;
        goto L197
    L96:
        if ((app.bucketingReason & r16) != 512) goto L104;
        if (predicted == false) goto L109;
        if (newBucket < 40) goto L109;
        monitor-exit(r10);     // Catch: Throwable -> L101
        return;
    L104:
        if (isUserUsage(reason) == true) goto L109;
        if (isForcedByUser == true) goto L109;
        monitor-exit(r10);     // Catch: Throwable -> L101
        return;
    L109:
        if (newBucket == 45) goto L180;
        long r6 = elapsedRealtime;
        predicted = predicted;
    L132:
        if (predicted == false) goto L152;
        long elapsedTimeAdjusted = this.mAppIdleHistory.getElapsedTime(r6);     // Catch: Throwable -> L12
        this.mAppIdleHistory.updateLastPrediction(app, elapsedTimeAdjusted, newBucket);     // Catch: Throwable -> L12
        int bucketWithValidExpiryTime = getMinBucketWithValidExpiryTime(app, newBucket, elapsedTimeAdjusted);     // Catch: Throwable -> L12
        if (bucketWithValidExpiryTime == (-1)) goto L147;
        int newBucket2 = bucketWithValidExpiryTime;
        if (newBucket2 == 10) goto L144;
    L142:
        th = th;
        goto L197
    L139:
        if (app.currentBucket == newBucket2) goto L144;
        int reason3 = 775;
    L191:
        int newBucket3 = Math.min(newBucket2, getAppMinBucket(packageName, userId));     // Catch: Throwable -> L174
    L172:
        th = th;
        goto L197
    L156:
        if (app.currentBucket < 40) goto L158;
        boolean r9 = true;
    L159:
        boolean previouslyIdle2 = r9;
        this.mAppIdleHistory.setAppStandbyBucket(packageName, userId, r6, newBucket3, reason3, resetTimeout);     // Catch: Throwable -> L172
        if (newBucket3 < 40) goto L163;
        boolean r18 = true;
    L164:
        boolean stillIdle2 = r18;
        if (previouslyIdle2 != stillIdle2) goto L202;
    L169:
        monitor-exit(r10);     // Catch: Throwable -> L167
        maybeInformListeners(packageName, userId, elapsedRealtime, newBucket3, reason3, false);
        return;
    L167:
        th = th;
        goto L197
    L202:
        notifyBatteryStats(packageName, userId, stillIdle2);     // Catch: Throwable -> L167
        goto L169
    L163:
        r18 = false;
        goto L164
    L158:
        r9 = false;
    L174:
        th = th;
    L144:
        reason3 = app.bucketingReason;     // Catch: Throwable -> L142
        goto L191
    L147:
        if (newBucket != 40) goto L152;
        if (getBucketForLocked(packageName, userId, r6) != 45) goto L152;
        newBucket2 = 45;
        reason3 = 512;
    L152:
        newBucket2 = newBucket;
        reason3 = reason;
        goto L191
    L180:
        r6 = elapsedRealtime;
        this.mAppIdleHistory.noteRestrictionAttempt(packageName, userId, r6, reason);     // Catch: Throwable -> L12
        if (isForcedByUser == true) goto L185;
        predicted = predicted;
        long timeUntilRestrictPossibleMs = (app.lastUsedByUserElapsedTime + this.mInjector.getAutoRestrictedBucketDelayMs()) - r6;     // Catch: Throwable -> L12
        if (timeUntilRestrictPossibleMs <= 0) goto L132;
        Slog.w(TAG, "Tried to restrict recently used app: " + packageName + " due to " + reason);     // Catch: Throwable -> L12
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(11, userId, -1, packageName), timeUntilRestrictPossibleMs);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L185:
    L119:
        th = th;
        goto L197
    L115:
        if (Build.IS_DEBUGGABLE == true) goto L117;
    L121:
        Slog.i(TAG, packageName + " restricted by user");     // Catch: Throwable -> L119
    L184:
        goto L132
    L117:
        if ((reason & 255) == 2) goto L121;
        Toast.makeText(this.mContext, this.mHandler.getLooper(), this.mContext.getResources().getString(R.string.autofill_save_yes, new Object[]{packageName}), 0).show();     // Catch: Throwable -> L119
    L129:
        th = th;
        goto L197
    L91:
        r5 = false;
        goto L92
    L43:
        r2 = false;
    L37:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L39:
        r16 = 65280;
        goto L41
    L31:
        r8 = false;
    L25:
        if (predicted == false) goto L29;
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L17:
        r7 = false;
        goto L18
    }

    public boolean isActiveDeviceAdmin(String packageName, int userId) {
        SparseArray<Set<String>> r0 = this.mActiveAdminApps;
        monitor-enter(r0);
        Set<String> adminPkgs = this.mActiveAdminApps.get(userId);     // Catch: Throwable -> L9
        if (adminPkgs != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (adminPkgs.contains(packageName) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isAdminProtectedPackages(String packageName, int userId) {
        SparseArray<Set<String>> r0 = this.mAdminProtectedPackages;
        monitor-enter(r0);
        boolean r3 = true;
        if (this.mAdminProtectedPackages.contains(-1) == false) goto L13;
        if (this.mAdminProtectedPackages.get(-1).contains(packageName) == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L13:
        if (this.mAdminProtectedPackages.contains(userId) == true) goto L15;
    L17:
        r3 = false;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L15:
        if (this.mAdminProtectedPackages.get(userId).contains(packageName) == false) goto L17;
    L10:
        th = move-exception;
        throw th;
    }

    public void addActiveDeviceAdmin(String adminPkg, int userId) {
        SparseArray<Set<String>> r0 = this.mActiveAdminApps;
        monitor-enter(r0);
        Set<String> adminPkgs = this.mActiveAdminApps.get(userId);     // Catch: Throwable -> L7
        if (adminPkgs != null) goto L9;
        adminPkgs = new ArraySet();     // Catch: Throwable -> L7
        this.mActiveAdminApps.put(userId, adminPkgs);     // Catch: Throwable -> L7
    L9:
        adminPkgs.add(adminPkg);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setActiveAdminApps(Set<String> adminPkgs, int userId) {
        SparseArray<Set<String>> r0 = this.mActiveAdminApps;
        monitor-enter(r0);
        if (adminPkgs != null) goto L8;
        this.mActiveAdminApps.remove(userId);     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        this.mActiveAdminApps.put(userId, adminPkgs);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void setAdminProtectedPackages(Set<String> packageNames, int userId) {
        SparseArray<Set<String>> r0 = this.mAdminProtectedPackages;
        monitor-enter(r0);
        if (packageNames == null) goto L11;
    L9:
        th = move-exception;
        throw th;
    L6:
        if (packageNames.isEmpty() == true) goto L11;
        this.mAdminProtectedPackages.put(userId, packageNames);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (this.mInjector.getBootPhase() < 1000) goto L21;
        postCheckIdleStates(userId);
        return;
    L21:
        return;
    L11:
        this.mAdminProtectedPackages.remove(userId);     // Catch: Throwable -> L9
        goto L12
    }

    public void onAdminDataAvailable() {
        this.mAdminDataAvailableLatch.countDown();
    }

    private void waitForAdminData() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.device_admin") == false) goto L6;
        ConcurrentUtils.waitForCountDownNoInterrupt(this.mAdminDataAvailableLatch, 10000, "Wait for admin data");
        return;
    }

    Set<String> getActiveAdminAppsForTest(int userId) {
        SparseArray<Set<String>> r0 = this.mActiveAdminApps;
        monitor-enter(r0);
        Set<String> r1 = this.mActiveAdminApps.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    Set<String> getAdminProtectedPackagesForTest(int userId) {
        SparseArray<Set<String>> r0 = this.mAdminProtectedPackages;
        monitor-enter(r0);
        Set<String> r1 = this.mAdminProtectedPackages.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isDeviceProvisioningPackage(String packageName) {
        if (this.mCachedDeviceProvisioningPackage != null) goto L6;
        this.mCachedDeviceProvisioningPackage = this.mContext.getResources().getString(R.string.config_mainDisplayShape);
    L6:
        return this.mCachedDeviceProvisioningPackage.equals(packageName);
    }

    private boolean isCarrierApp(String packageName) {
        Object r0 = this.mCarrierPrivilegedLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mHaveCarrierPrivilegedApps == true) goto L10;
        fetchCarrierPrivilegedAppsCPL();     // Catch: Throwable -> L7
    L10:
        if (this.mCarrierPrivilegedApps == null) goto L14;
        boolean r1 = this.mCarrierPrivilegedApps.contains(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return false;
    }

    public void clearCarrierPrivilegedApps() {
        Object r0 = this.mCarrierPrivilegedLock;
        monitor-enter(r0);
        this.mHaveCarrierPrivilegedApps = false;     // Catch: Throwable -> L8
        this.mCarrierPrivilegedApps = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void fetchCarrierPrivilegedAppsCPL() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        this.mCarrierPrivilegedApps = telephonyManager.getCarrierPrivilegedPackagesForAllActiveSubscriptions();
        this.mHaveCarrierPrivilegedApps = true;
    }

    private boolean isActiveNetworkScorer(String packageName) {
        long now = SystemClock.elapsedRealtime();
        if (this.mCachedNetworkScorer != null) goto L5;
    L6:
        this.mCachedNetworkScorer = this.mInjector.getActiveNetworkScorer();
        this.mCachedNetworkScorerAtMillis = now;
    L8:
        return packageName.equals(this.mCachedNetworkScorer);
    L5:
        if (this.mCachedNetworkScorerAtMillis >= (now - NETWORK_SCORER_CACHE_DURATION_MILLIS)) goto L8;
        goto L6
    }

    private void informListeners(String packageName, int userId, int bucket, int reason, boolean userInteraction) {
        if (bucket < 40) goto L5;
        boolean r0 = true;
    L6:
        boolean idle = r0;
        ArrayList<AppStandbyInternal.AppIdleStateChangeListener> r7 = this.mPackageAccessListeners;
        monitor-enter(r7);
        Iterator<AppStandbyInternal.AppIdleStateChangeListener> r1 = this.mPackageAccessListeners.iterator();     // Catch: Throwable -> L19
    L10:
        if (r1.hasNext() == false) goto L22;
        AppStandbyInternal.AppIdleStateChangeListener listener = r1.next();     // Catch: Throwable -> L19
        String packageName2 = packageName;
        int userId2 = userId;
        int bucket2 = bucket;
        int reason2 = reason;
        listener.onAppIdleStateChanged(packageName2, userId2, idle, bucket2, reason2);     // Catch: Throwable -> L16
        if (userInteraction == false) goto L18;
        listener.onUserInteractionStarted(packageName2, userId2);     // Catch: Throwable -> L16
    L18:
        packageName = packageName2;
        userId = userId2;
        bucket = bucket2;
        reason = reason2;
    L16:
        th = move-exception;
        Throwable r9 = th;
    L24:
        monitor-exit(r7);     // Catch: Throwable -> L16
        throw r9;
    L22:
        monitor-exit(r7);     // Catch: Throwable -> L16
        return;
    L19:
        th = move-exception;
        r9 = th;
        goto L24
    L5:
        r0 = false;
        goto L6
    }

    private void informParoleStateChanged() {
        boolean paroled = isInParole();
        ArrayList<AppStandbyInternal.AppIdleStateChangeListener> r1 = this.mPackageAccessListeners;
        monitor-enter(r1);
        Iterator<AppStandbyInternal.AppIdleStateChangeListener> r2 = this.mPackageAccessListeners.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        AppStandbyInternal.AppIdleStateChangeListener listener = r2.next();     // Catch: Throwable -> L8
        listener.onParoleStateChanged(paroled);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public long getBroadcastResponseWindowDurationMs() {
        return this.mBroadcastResponseWindowDurationMillis;
    }

    public int getBroadcastResponseFgThresholdState() {
        return this.mBroadcastResponseFgThresholdState;
    }

    public long getBroadcastSessionsDurationMs() {
        return this.mBroadcastSessionsDurationMs;
    }

    public long getBroadcastSessionsWithResponseDurationMs() {
        return this.mBroadcastSessionsWithResponseDurationMs;
    }

    public boolean shouldNoteResponseEventForAllBroadcastSessions() {
        return this.mNoteResponseEventForAllBroadcastSessions;
    }

    public List<String> getBroadcastResponseExemptedRoles() {
        return this.mBroadcastResponseExemptedRolesList;
    }

    public List<String> getBroadcastResponseExemptedPermissions() {
        return this.mBroadcastResponseExemptedPermissionsList;
    }

    public String getAppStandbyConstant(String key) {
        return this.mAppStandbyProperties.get(key);
    }

    public void clearLastUsedTimestampsForTest(String packageName, int userId) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        this.mAppIdleHistory.clearLastUsedTimestamps(packageName, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$flushHandler$1() {
    }

    boolean flushHandler(long timeoutMillis) {
        return this.mHandler.runWithScissors(new AppStandbyController$$ExternalSyntheticLambda3(), timeoutMillis);
    }

    public void flushToDisk() {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        this.mAppIdleHistory.writeAppIdleTimes(this.mInjector.elapsedRealtime());     // Catch: Throwable -> L7
        this.mAppIdleHistory.writeAppIdleDurations();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isDisplayOn() {
        return this.mInjector.isDefaultDisplayOn();
    }

    void clearAppIdleForPackage(String packageName, int userId) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        this.mAppIdleHistory.clearUsage(packageName, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void maybeUnrestrictBuggyApp(String packageName, int userId) {
        maybeUnrestrictApp(packageName, userId, 1536, 4, 256, 1);
    }

    public void maybeUnrestrictApp(String packageName, int userId, int prevMainReasonRestrict, int prevSubReasonRestrict, int mainReasonUnrestrict, int subReasonUnrestrict) {
        Object r10 = this.mAppIdleLock;
        monitor-enter(r10);
        long elapsedRealtime = this.mInjector.elapsedRealtime();     // Catch: Throwable -> L16
        AppIdleHistory.AppUsageHistory app = this.mAppIdleHistory.getAppUsageHistory(packageName, userId, elapsedRealtime);     // Catch: Throwable -> L16
        if (app.currentBucket != 45) goto L18;
        if ((app.bucketingReason & JobPackageTracker.EVENT_STOP_REASON_MASK) != prevMainReasonRestrict) goto L18;
        if ((app.bucketingReason & 255) != prevSubReasonRestrict) goto L12;
        int newBucket = 40;
        int newReason = mainReasonUnrestrict | subReasonUnrestrict;     // Catch: Throwable -> L16
    L13:
        this.mAppIdleHistory.setAppStandbyBucket(packageName, userId, elapsedRealtime, newBucket, newReason);     // Catch: Throwable -> L16
        maybeInformListeners(packageName, userId, elapsedRealtime, newBucket, newReason, false);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L12:
        newBucket = 45;
        newReason = app.bucketingReason & (~prevSubReasonRestrict);     // Catch: Throwable -> L16
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void updatePowerWhitelistCache() {
        if (this.mInjector.getBootPhase() >= 500) goto L5;
        return;
    L5:
        this.mInjector.updatePowerWhitelistCache();
        postCheckIdleStates(-1);
    }

    private void evaluateSystemAppException(String packageName, int userId) {
        if (this.mSystemServicesReady == true) goto L16;
        return;
    L16:
        PackageInfo pi = this.mPackageManager.getPackageInfoAsUser(packageName, HEADLESS_APP_CHECK_FLAGS, userId);     // Catch: PackageManager.NameNotFoundException -> L7
        maybeUpdateHeadlessSystemAppCache(pi);     // Catch: PackageManager.NameNotFoundException -> L7
        return;
    L9:
        monitor-enter(this.mHeadlessSystemApps);
        this.mHeadlessSystemApps.remove(packageName);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean maybeUpdateHeadlessSystemAppCache(PackageInfo pkgInfo) {
        if (pkgInfo != null) goto L5;
    L13:
        return false;
    L5:
        if (pkgInfo.applicationInfo == null) goto L13;
        if (pkgInfo.applicationInfo.isSystemApp() == false) goto L9;
    L11:
        Intent frontDoorActivityIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(pkgInfo.packageName);
        List<ResolveInfo> res = this.mPackageManager.queryIntentActivitiesAsUser(frontDoorActivityIntent, HEADLESS_APP_CHECK_FLAGS, 0);
        return updateHeadlessSystemAppCache(pkgInfo.packageName, ArrayUtils.isEmpty(res));
    L9:
        if (pkgInfo.applicationInfo.isUpdatedSystemApp() == true) goto L11;
        goto L11
    }

    private boolean updateHeadlessSystemAppCache(String packageName, boolean add) {
        ArraySet<String> r0 = this.mHeadlessSystemApps;
        monitor-enter(r0);
        if (add == false) goto L10;
        boolean r1 = this.mHeadlessSystemApps.add(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L10:
        boolean r2 = this.mHeadlessSystemApps.remove(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public void initializeDefaultsForSystemApps(int userId) {
        if (this.mSystemServicesReady == true) goto L6;
        this.mPendingInitializeDefaults = true;
        return;
    L6:
        Slog.d(TAG, "Initializing defaults for system apps on user " + userId + ", appIdleEnabled=" + this.mAppIdleEnabled);
        long elapsedRealtime = this.mInjector.elapsedRealtime();
        List<PackageInfo> packages = this.mPackageManager.getInstalledPackagesAsUser(512, userId);
        int packageCount = packages.size();
        Object r15 = this.mAppIdleLock;
        monitor-enter(r15);
        int i = 0;
    L9:
        if (i >= packageCount) goto L19;
        PackageInfo pi = packages.get(i);     // Catch: Throwable -> L15
        String packageName = pi.packageName;     // Catch: Throwable -> L15
        if (pi.applicationInfo == null) goto L18;
        if (pi.applicationInfo.isSystemApp() == false) goto L18;
        this.mAppIdleHistory.reportUsage(packageName, userId, 10, 6, 0, elapsedRealtime + this.mSystemUpdateUsageTimeoutMillis);     // Catch: Throwable -> L15
    L18:
        i = i + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L19:
        this.mAppIdleHistory.writeAppIdleTimes(userId, elapsedRealtime);     // Catch: Throwable -> L15
        monitor-exit(r15);     // Catch: Throwable -> L15
    }

    private Set<String> getSystemPackagesWithLauncherActivities() {
        Intent intent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> activities = this.mPackageManager.queryIntentActivitiesAsUser(intent, HEADLESS_APP_CHECK_FLAGS, 0);
        ArraySet<String> ret = new ArraySet();
        Iterator<ResolveInfo> r3 = activities.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ResolveInfo ri = r3.next();
        ret.add(ri.activityInfo.packageName);
        goto L4
    L6:
        return ret;
    }

    private void loadHeadlessSystemAppCache() {
        long start = SystemClock.uptimeMillis();
        List<PackageInfo> packages = this.mPackageManager.getInstalledPackagesAsUser(HEADLESS_APP_CHECK_FLAGS, 0);
        Set<String> systemLauncherActivities = getSystemPackagesWithLauncherActivities();
        int packageCount = packages.size();
        int i = 0;
    L3:
        if (i >= packageCount) goto L10;
        PackageInfo pkgInfo = packages.get(i);
        if (pkgInfo == null) goto L9;
        String pkg = pkgInfo.packageName;
        boolean isHeadLess = !systemLauncherActivities.contains(pkg);
        if (updateHeadlessSystemAppCache(pkg, isHeadLess) == true) goto L9;
    L9:
        i = i + 1;
        goto L3
    L10:
        long end = SystemClock.uptimeMillis();
        Slog.d(TAG, "Loaded headless system app cache in " + (end - start) + " ms: appIdleEnabled=" + this.mAppIdleEnabled);
    }

    public void postReportContentProviderUsage(String name, String packageName, int userId) {
        ContentProviderUsageRecord record = ContentProviderUsageRecord.obtain(name, packageName, userId);
        this.mHandler.obtainMessage(8, record).sendToTarget();
    }

    public void postReportSyncScheduled(String r3, int r4, boolean r5) {
        this.mHandler.obtainMessage(12, r4, r5 ? 1 : 0, r3).sendToTarget();
    }

    public void postReportExemptedSyncStart(String packageName, int userId) {
        this.mHandler.obtainMessage(13, userId, 0, packageName).sendToTarget();
    }

    AppIdleHistory getAppIdleHistoryForTest() {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        AppIdleHistory r1 = this.mAppIdleHistory;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void dumpUsers(IndentingPrintWriter idpw, int[] userIds, List<String> pkgs) {
        Object r0 = this.mAppIdleLock;
        monitor-enter(r0);
        this.mAppIdleHistory.dumpUsers(idpw, userIds, pkgs);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dumpState(String[] args, PrintWriter pw) {
        pw.println("Flags: ");
        pw.println("    com.android.server.usage.avoid_idle_check: true");
        pw.println("    com.android.server.usage.adjust_default_bucket_elevation_params: true");
        pw.println("    com.android.server.usage.persist_restore_to_rare_apps_list: true");
        pw.println();
        Object r0 = this.mCarrierPrivilegedLock;
        monitor-enter(r0);
        pw.println("Carrier privileged apps (have=" + this.mHaveCarrierPrivilegedApps + "): " + this.mCarrierPrivilegedApps);     // Catch: Throwable -> L64
        monitor-exit(r0);     // Catch: Throwable -> L64
        pw.println();
        pw.println("Settings:");
        pw.print("  mCheckIdleIntervalMillis=");
        TimeUtils.formatDuration(this.mCheckIdleIntervalMillis, pw);
        pw.println();
        pw.print("  mStrongUsageTimeoutMillis=");
        TimeUtils.formatDuration(this.mStrongUsageTimeoutMillis, pw);
        pw.println();
        pw.print("  mNotificationSeenTimeoutMillis=");
        TimeUtils.formatDuration(this.mNotificationSeenTimeoutMillis, pw);
        pw.println();
        pw.print("  mNotificationSeenPromotedBucket=");
        pw.print(UsageStatsManager.standbyBucketToString(this.mNotificationSeenPromotedBucket));
        pw.println();
        pw.print("  mTriggerQuotaBumpOnNotificationSeen=");
        pw.print(this.mTriggerQuotaBumpOnNotificationSeen);
        pw.println();
        pw.print("  mRetainNotificationSeenImpactForPreTApps=");
        pw.print(this.mRetainNotificationSeenImpactForPreTApps);
        pw.println();
        pw.print("  mSlicePinnedTimeoutMillis=");
        TimeUtils.formatDuration(this.mSlicePinnedTimeoutMillis, pw);
        pw.println();
        pw.print("  mSyncAdapterTimeoutMillis=");
        TimeUtils.formatDuration(this.mSyncAdapterTimeoutMillis, pw);
        pw.println();
        pw.print("  mSyncAdapaterPromotedBucket=");
        pw.print(UsageStatsManager.standbyBucketToString(this.mSyncAdapaterPromotedBucket));
        pw.println();
        pw.print("  mSystemInteractionTimeoutMillis=");
        TimeUtils.formatDuration(this.mSystemInteractionTimeoutMillis, pw);
        pw.println();
        pw.print("  mInitialForegroundServiceStartTimeoutMillis=");
        TimeUtils.formatDuration(this.mInitialForegroundServiceStartTimeoutMillis, pw);
        pw.println();
        pw.print("  mPredictionTimeoutMillis=");
        TimeUtils.formatDuration(this.mPredictionTimeoutMillis, pw);
        pw.println();
        pw.print("  mExemptedSyncScheduledNonDozeTimeoutMillis=");
        TimeUtils.formatDuration(this.mExemptedSyncScheduledNonDozeTimeoutMillis, pw);
        pw.println();
        pw.print("  mExemptedSyncScheduledDozeTimeoutMillis=");
        TimeUtils.formatDuration(this.mExemptedSyncScheduledDozeTimeoutMillis, pw);
        pw.println();
        pw.print("  mExemptedSyncStartTimeoutMillis=");
        TimeUtils.formatDuration(this.mExemptedSyncStartTimeoutMillis, pw);
        pw.println();
        pw.print("  mUnexemptedSyncScheduledTimeoutMillis=");
        TimeUtils.formatDuration(this.mUnexemptedSyncScheduledTimeoutMillis, pw);
        pw.println();
        pw.print("  mSystemUpdateUsageTimeoutMillis=");
        TimeUtils.formatDuration(this.mSystemUpdateUsageTimeoutMillis, pw);
        pw.println();
        pw.print("  mBroadcastResponseWindowDurationMillis=");
        TimeUtils.formatDuration(this.mBroadcastResponseWindowDurationMillis, pw);
        pw.println();
        pw.print("  mBroadcastResponseFgThresholdState=");
        pw.print(ActivityManager.procStateToString(this.mBroadcastResponseFgThresholdState));
        pw.println();
        pw.print("  mBroadcastSessionsDurationMs=");
        TimeUtils.formatDuration(this.mBroadcastSessionsDurationMs, pw);
        pw.println();
        pw.print("  mBroadcastSessionsWithResponseDurationMs=");
        TimeUtils.formatDuration(this.mBroadcastSessionsWithResponseDurationMs, pw);
        pw.println();
        pw.print("  mNoteResponseEventForAllBroadcastSessions=");
        pw.print(this.mNoteResponseEventForAllBroadcastSessions);
        pw.println();
        pw.print("  mBroadcastResponseExemptedRoles=");
        pw.print(this.mBroadcastResponseExemptedRoles);
        pw.println();
        pw.print("  mBroadcastResponseExemptedPermissions=");
        pw.print(this.mBroadcastResponseExemptedPermissions);
        pw.println();
        pw.println();
        pw.print("mAppIdleEnabled=");
        pw.print(this.mAppIdleEnabled);
        pw.print(" mIsCharging=");
        pw.print(this.mIsCharging);
        pw.println();
        pw.print("mScreenThresholds=");
        pw.println(Arrays.toString(this.mAppStandbyScreenThresholds));
        pw.print("mElapsedThresholds=");
        pw.println(Arrays.toString(this.mAppStandbyElapsedThresholds));
        pw.println();
        pw.println("mHeadlessSystemApps=[");
        ArraySet<String> r2 = this.mHeadlessSystemApps;
        monitor-enter(r2);
        int i = this.mHeadlessSystemApps.size() - 1;     // Catch: Throwable -> L13
    L9:
        if (i < 0) goto L17;
        pw.print("  ");     // Catch: Throwable -> L13
        pw.print(this.mHeadlessSystemApps.valueAt(i));     // Catch: Throwable -> L13
        if (i == 0) goto L15;
        pw.println(",");     // Catch: Throwable -> L13
    L15:
        i = i - 1;     // Catch: Throwable -> L13
        goto L9
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L13
        pw.println("]");
        pw.println();
        pw.println("mSystemPackagesAppIds=[");
        ArrayList<Integer> r1 = this.mSystemPackagesAppIds;
        monitor-enter(r1);
        int i2 = this.mSystemPackagesAppIds.size() - 1;     // Catch: Throwable -> L25
    L21:
        if (i2 < 0) goto L29;
        pw.print("  ");     // Catch: Throwable -> L25
        pw.print(this.mSystemPackagesAppIds.get(i2));     // Catch: Throwable -> L25
        if (i2 == 0) goto L27;
        pw.println(",");     // Catch: Throwable -> L25
    L27:
        i2 = i2 - 1;     // Catch: Throwable -> L25
        goto L21
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L25
        pw.println("]");
        pw.println();
        pw.println("mActiveAdminApps=[");
        SparseArray<Set<String>> r3 = this.mActiveAdminApps;
        monitor-enter(r3);
        int size = this.mActiveAdminApps.size();     // Catch: Throwable -> L37
        int i3 = 0;
    L33:
        if (i3 >= size) goto L41;
        int userId = this.mActiveAdminApps.keyAt(i3);     // Catch: Throwable -> L37
        pw.print(" ");     // Catch: Throwable -> L37
        pw.print(userId);     // Catch: Throwable -> L37
        pw.print(": ");     // Catch: Throwable -> L37
        pw.print(this.mActiveAdminApps.valueAt(i3));     // Catch: Throwable -> L37
        if (i3 == (size - 1)) goto L39;
        pw.print(",");     // Catch: Throwable -> L37
    L39:
        pw.println();     // Catch: Throwable -> L37
        i3 = i3 + 1;     // Catch: Throwable -> L37
        goto L33
    L41:
        monitor-exit(r3);     // Catch: Throwable -> L37
        pw.println("]");
        pw.println();
        pw.println("mAdminProtectedPackages=[");
        SparseArray<Set<String>> r4 = this.mAdminProtectedPackages;
        monitor-enter(r4);
        int size2 = this.mAdminProtectedPackages.size();     // Catch: Throwable -> L49
        int i4 = 0;
    L45:
        if (i4 >= size2) goto L53;
        int userId2 = this.mAdminProtectedPackages.keyAt(i4);     // Catch: Throwable -> L49
        pw.print(" ");     // Catch: Throwable -> L49
        pw.print(userId2);     // Catch: Throwable -> L49
        pw.print(": ");     // Catch: Throwable -> L49
        pw.print(this.mAdminProtectedPackages.valueAt(i4));     // Catch: Throwable -> L49
        if (i4 == (size2 - 1)) goto L51;
        pw.print(",");     // Catch: Throwable -> L49
    L51:
        pw.println();     // Catch: Throwable -> L49
        i4 = i4 + 1;     // Catch: Throwable -> L49
        goto L45
    L53:
        monitor-exit(r4);     // Catch: Throwable -> L49
        pw.println("]");
        pw.println();
        this.mInjector.dump(pw);
        return;
    L49:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        throw th;
    L64:
        th = move-exception;
        throw th;
    }
}

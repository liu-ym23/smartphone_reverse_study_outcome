package com.android.server.net;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.app.IUidObserver;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.app.usage.UsageStatsManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.ConnectivityManager;
import android.net.INetworkManagementEventObserver;
import android.net.INetworkPolicyListener;
import android.net.INetworkPolicyManager;
import android.net.Network;
import android.net.NetworkIdentity;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkRequest;
import android.net.NetworkStateSnapshot;
import android.net.NetworkTemplate;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.BestClock;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.HandlerThread;
import android.os.INetworkManagementService;
import android.os.MessageQueue;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.PowerExemptionManager;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.SubscriptionPlan;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.DataUnit;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.RecurrenceRule;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.SparseSetArray;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.StatLogger;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.net.module.util.NetworkIdentityUtils;
import com.android.net.module.util.PermissionUtils;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemConfig;
import com.android.server.connectivity.MultipathPolicyTracker;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.usage.AppStandbyInternal;
import dalvik.annotation.optimization.NeverCompile;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkPolicyManagerService extends INetworkPolicyManager.Stub {
    private static final String ACTION_SNOOZE_RAPID = "com.android.server.net.action.SNOOZE_RAPID";
    private static final String ACTION_SNOOZE_WARNING = "com.android.server.net.action.SNOOZE_WARNING";
    private static final String ATTR_APP_ID = "appId";

    @Deprecated
    private static final String ATTR_CYCLE_DAY = "cycleDay";
    private static final String ATTR_CYCLE_END = "cycleEnd";
    private static final String ATTR_CYCLE_PERIOD = "cyclePeriod";
    private static final String ATTR_CYCLE_START = "cycleStart";

    @Deprecated
    private static final String ATTR_CYCLE_TIMEZONE = "cycleTimezone";
    private static final String ATTR_INFERRED = "inferred";
    private static final String ATTR_LAST_LIMIT_SNOOZE = "lastLimitSnooze";
    private static final String ATTR_LAST_SNOOZE = "lastSnooze";
    private static final String ATTR_LAST_WARNING_SNOOZE = "lastWarningSnooze";
    private static final String ATTR_LIMIT_BEHAVIOR = "limitBehavior";
    private static final String ATTR_LIMIT_BYTES = "limitBytes";
    private static final String ATTR_METERED = "metered";
    private static final String ATTR_NETWORK_ID = "networkId";
    private static final String ATTR_NETWORK_TEMPLATE = "networkTemplate";
    private static final String ATTR_NETWORK_TYPES = "networkTypes";
    private static final String ATTR_OWNER_PACKAGE = "ownerPackage";
    private static final String ATTR_POLICY = "policy";
    private static final String ATTR_RESTRICT_BACKGROUND = "restrictBackground";
    private static final String ATTR_SUBSCRIBER_ID = "subscriberId";
    private static final String ATTR_SUBSCRIBER_ID_MATCH_RULE = "subscriberIdMatchRule";
    private static final String ATTR_SUB_ID = "subId";
    private static final String ATTR_SUMMARY = "summary";
    private static final String ATTR_TEMPLATE_METERED = "templateMetered";
    private static final String ATTR_TITLE = "title";
    private static final String ATTR_UID = "uid";
    private static final String ATTR_USAGE_BYTES = "usageBytes";
    private static final String ATTR_USAGE_TIME = "usageTime";
    private static final String ATTR_VERSION = "version";
    private static final String ATTR_WARNING_BYTES = "warningBytes";
    private static final String ATTR_XML_UTILS_NAME = "name";
    private static final int CHAIN_TOGGLE_DISABLE = 2;
    private static final int CHAIN_TOGGLE_ENABLE = 1;
    private static final int CHAIN_TOGGLE_NONE = 0;
    private static final boolean DEBUG = false;
    private static final boolean LOGD = false;
    private static final boolean LOGV = false;
    private static final int MSG_ADVISE_PERSIST_THRESHOLD = 7;
    private static final int MSG_CLEAR_SUBSCRIPTION_PLANS = 22;
    private static final int MSG_LIMIT_REACHED = 5;
    private static final int MSG_METERED_IFACES_CHANGED = 2;
    private static final int MSG_METERED_RESTRICTED_PACKAGES_CHANGED = 17;
    private static final int MSG_POLICIES_CHANGED = 13;
    private static final int MSG_PROCESS_BACKGROUND_TRANSITIONING_UIDS = 24;
    private static final int MSG_REMOVE_INTERFACE_QUOTAS = 11;
    private static final int MSG_RESET_FIREWALL_RULES_BY_UID = 15;
    private static final int MSG_RESTRICT_BACKGROUND_CHANGED = 6;
    private static final int MSG_RULES_CHANGED = 1;
    private static final int MSG_SET_NETWORK_TEMPLATE_ENABLED = 18;
    private static final int MSG_STATS_PROVIDER_WARNING_OR_LIMIT_REACHED = 20;
    private static final int MSG_SUBSCRIPTION_OVERRIDE = 16;
    private static final int MSG_SUBSCRIPTION_PLANS_CHANGED = 19;
    private static final int MSG_UIDS_BLOCKED_REASONS_CHANGED = 23;
    private static final int MSG_UID_BLOCKED_REASON_CHANGED = 21;
    private static final int MSG_UPDATE_INTERFACE_QUOTAS = 10;
    public static final int OPPORTUNISTIC_QUOTA_UNKNOWN = -1;
    private static final String PROP_SUB_PLAN_OWNER = "persist.sys.sub_plan_owner";
    private static final float QUOTA_FRAC_JOBS_DEFAULT = 0.5f;
    private static final float QUOTA_FRAC_MULTIPATH_DEFAULT = 0.5f;
    private static final float QUOTA_LIMITED_DEFAULT = 0.1f;
    private static final long QUOTA_UNLIMITED_DEFAULT = 0;
    static final String TAG = "NetworkPolicy";
    private static final String TAG_ALLOWLIST = "whitelist";
    private static final String TAG_APP_POLICY = "app-policy";
    private static final String TAG_NETWORK_POLICY = "network-policy";
    private static final String TAG_POLICY_LIST = "policy-list";
    private static final String TAG_RESTRICT_BACKGROUND = "restrict-background";
    private static final String TAG_REVOKED_RESTRICT_BACKGROUND = "revoked-restrict-background";
    private static final String TAG_UID_POLICY = "uid-policy";
    private static final String TAG_XML_UTILS_INT_ARRAY = "int-array";
    public static final int TYPE_LIMIT = 35;
    public static final int TYPE_LIMIT_SNOOZED = 36;
    public static final int TYPE_RAPID = 45;
    public static final int TYPE_WARNING = 34;
    private static final int UID_MSG_GONE = 101;
    static final int UID_MSG_STATE_CHANGED = 100;
    private static final int VERSION_ADDED_CYCLE = 11;
    private static final int VERSION_ADDED_INFERRED = 7;
    private static final int VERSION_ADDED_METERED = 4;
    private static final int VERSION_ADDED_NETWORK_ID = 9;
    private static final int VERSION_ADDED_NETWORK_TYPES = 12;
    private static final int VERSION_ADDED_RESTRICT_BACKGROUND = 3;
    private static final int VERSION_ADDED_SNOOZE = 2;
    private static final int VERSION_ADDED_TIMEZONE = 6;
    private static final int VERSION_INIT = 1;
    private static final int VERSION_LATEST = 14;
    private static final int VERSION_REMOVED_SUBSCRIPTION_PLANS = 14;
    private static final int VERSION_SPLIT_SNOOZE = 5;
    private static final int VERSION_SUPPORTED_CARRIER_USAGE = 13;
    private static final int VERSION_SWITCH_APP_ID = 8;
    private static final int VERSION_SWITCH_UID = 10;
    private static final long WAIT_FOR_ADMIN_DATA_TIMEOUT_MS = 10000;
    private final ActiveDataSubIdListener mActiveDataSubIdListener;
    private final ArraySet<NotificationId> mActiveNotifs;
    private final IActivityManager mActivityManager;
    private ActivityManagerInternal mActivityManagerInternal;
    private final CountDownLatch mAdminDataAvailableLatch;
    private final INetworkManagementEventObserver mAlertObserver;
    private final SparseBooleanArray mAppIdleTempWhitelistAppIds;
    private final AppOpsManager mAppOps;
    private AppStandbyInternal mAppStandby;
    long mBackgroundRestrictionDelayMs;
    long mBackgroundRestrictionLongDelayMs;
    long mBackgroundRestrictionShortDelayMs;
    private final SparseLongArray mBackgroundTransitioningUids;
    private final CarrierConfigManager mCarrierConfigManager;
    private BroadcastReceiver mCarrierConfigReceiver;
    private final Clock mClock;
    private ConnectivityManager mConnManager;
    private BroadcastReceiver mConnReceiver;
    private final Context mContext;
    private final SparseBooleanArray mDefaultRestrictBackgroundAllowlistUids;
    private final Dependencies mDeps;
    volatile boolean mDeviceIdleMode;
    final SparseBooleanArray mFirewallChainStates;
    final Handler mHandler;
    private final Handler.Callback mHandlerCallback;
    private final IPackageManager mIPm;
    final SparseBooleanArray mInternetPermissionMap;
    private final RemoteCallbackList<INetworkPolicyListener> mListeners;
    private boolean mLoadedRestrictBackground;
    private final NetworkPolicyLogger mLogger;
    volatile boolean mLowPowerStandbyActive;
    private final SparseBooleanArray mLowPowerStandbyAllowlistUids;
    private List<String[]> mMergedSubscriberIds;
    private ArraySet<String> mMeteredIfaces;
    final Object mMeteredIfacesLock;
    private final SparseArray<Set<Integer>> mMeteredRestrictedUids;
    private final MultipathPolicyTracker mMultipathPolicyTracker;
    private final SparseIntArray mNetIdToSubId;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private final INetworkManagementService mNetworkManager;
    private volatile boolean mNetworkManagerReady;
    private final SparseBooleanArray mNetworkMetered;
    final Object mNetworkPoliciesSecondLock;
    final ArrayMap<NetworkTemplate, NetworkPolicy> mNetworkPolicy;
    private final SparseBooleanArray mNetworkRoaming;
    private NetworkStatsManager mNetworkStats;
    private SparseSetArray<String> mNetworkToIfaces;
    private boolean mNeverApplyRulesToCoreUids;
    private long mNextProcessBackgroundUidsTime;
    private final ArraySet<NetworkTemplate> mOverLimitNotified;
    private final BroadcastReceiver mPackageReceiver;
    private final AtomicFile mPolicyFile;
    private PowerExemptionManager mPowerExemptionManager;
    private PowerManagerInternal mPowerManagerInternal;
    private final BroadcastReceiver mPowerSaveAllowlistReceiver;
    private final SparseBooleanArray mPowerSaveTempWhitelistAppIds;
    private final SparseBooleanArray mPowerSaveWhitelistAppIds;
    private final SparseBooleanArray mPowerSaveWhitelistExceptIdleAppIds;
    volatile boolean mRestrictBackground;
    private final SparseBooleanArray mRestrictBackgroundAllowlistRevokedUids;
    private boolean mRestrictBackgroundBeforeBsm;
    volatile boolean mRestrictBackgroundChangedInBsm;
    private boolean mRestrictBackgroundLowPowerMode;
    volatile boolean mRestrictPower;
    private RestrictedModeObserver mRestrictedModeObserver;
    volatile boolean mRestrictedNetworkingMode;
    int mSetSubscriptionPlansIdCounter;
    final SparseIntArray mSetSubscriptionPlansIds;
    private NetworkPolicyManagerServiceSmtEx mSmtEx;
    private final BroadcastReceiver mSnoozeReceiver;
    public final StatLogger mStatLogger;
    private final StatsCallback mStatsCallback;
    private final SparseArray<PersistableBundle> mSubIdToCarrierConfig;
    private final SparseArray<String> mSubIdToSubscriberId;
    final SparseLongArray mSubscriptionOpportunisticQuota;
    final SparseArray<SubscriptionPlan[]> mSubscriptionPlans;
    final SparseArray<String> mSubscriptionPlansOwner;
    private final boolean mSuppressDefaultPolicy;
    volatile boolean mSystemReady;
    private final SparseArray<UidBlockedState> mTmpUidBlockedState;
    private final SparseArray<UidBlockedState> mUidBlockedState;
    final Handler mUidEventHandler;
    private final Handler.Callback mUidEventHandlerCallback;
    private final ServiceThread mUidEventThread;
    final SparseIntArray mUidFirewallStandbyRules;
    private final IUidObserver mUidObserver;
    final SparseIntArray mUidPolicy;
    private final BroadcastReceiver mUidRemovedReceiver;
    final Object mUidRulesFirstLock;
    private final SparseArray<NetworkPolicyManager.UidState> mUidState;
    private final SparseArray<UidStateCallbackInfo> mUidStateCallbackInfos;
    private UsageStatsManagerInternal mUsageStats;
    private boolean mUseDifferentDelaysForBackgroundChain;
    private boolean mUseMeteredFirewallChains;
    private final UserManager mUserManager;
    private final BroadcastReceiver mUserReceiver;
    private final BroadcastReceiver mWifiReceiver;

    private class ActiveDataSubIdListener extends TelephonyCallback implements TelephonyCallback.ActiveDataSubscriptionIdListener {
        private int mActiveDataSubId;
        private int mDefaultDataSubId;
        final /* synthetic */ NetworkPolicyManagerService this$0;

        /* synthetic */ ActiveDataSubIdListener(NetworkPolicyManagerService r1, NetworkPolicyManagerServiceIA r2) {
            this(r1);
        }

        private ActiveDataSubIdListener(NetworkPolicyManagerService r1) {
            this.this$0 = r1;
            this.mDefaultDataSubId = NetworkPolicyManagerService.m5977$$Nest$fgetmDeps(this.this$0).getDefaultDataSubId();
            this.mActiveDataSubId = NetworkPolicyManagerService.m5977$$Nest$fgetmDeps(this.this$0).getActivateDataSubId();
        }

        @Override // android.telephony.TelephonyCallback.ActiveDataSubscriptionIdListener
        public void onActiveDataSubscriptionIdChanged(int subId) {
            this.mActiveDataSubId = subId;
            this.mDefaultDataSubId = NetworkPolicyManagerService.m5977$$Nest$fgetmDeps(this.this$0).getDefaultDataSubId();
            Object r0 = this.this$0.mNetworkPoliciesSecondLock;
            monitor-enter(r0);
            this.this$0.updateNotificationsNL();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChainToggleType {
    }

    static class Dependencies {
        final Context mContext;
        final NetworkStatsManager mNetworkStatsManager;

        Dependencies(Context context) {
            this.mContext = context;
            this.mNetworkStatsManager = (NetworkStatsManager) this.mContext.getSystemService(NetworkStatsManager.class);
            this.mNetworkStatsManager.setPollOnOpen(false);
        }

        long getNetworkTotalBytes(NetworkTemplate template, long start, long end) {
            Trace.traceBegin(2097152, "getNetworkTotalBytes");
        L22:
            NetworkStats.Bucket ret = this.mNetworkStatsManager.querySummaryForDevice(template, start, end);     // Catch: Throwable -> L8 RuntimeException -> L10
            long r11 = ret.getRxBytes() + ret.getTxBytes();
            Trace.traceEnd(2097152);
            return r11;
        L10:
            e = move-exception;
            RuntimeException e = e;
        L17:
            Slog.w(NetworkPolicyManagerService.TAG, "Failed to read network stats: " + e);     // Catch: Throwable -> L8
            Trace.traceEnd(2097152);
            return 0;
        L8:
            th = move-exception;
            RuntimeException e2 = th;
        L20:
            Trace.traceEnd(2097152);
            throw e2;
        L14:
            e = move-exception;
            e = e;
        L12:
            th = move-exception;
            e2 = th;
            goto L20
        }

        List<NetworkStats.Bucket> getNetworkUidBytes(NetworkTemplate template, long start, long end) {
            Trace.traceBegin(2097152, "getNetworkUidBytes");
            List<NetworkStats.Bucket> buckets = new ArrayList();
        L26:
            NetworkStats stats = this.mNetworkStatsManager.querySummary(template, start, end);     // Catch: Throwable -> L10 RuntimeException -> L12
        L7:
            if (stats.hasNextBucket() == false) goto L15;
            NetworkStats.Bucket bucket = new NetworkStats.Bucket();     // Catch: Throwable -> L10 RuntimeException -> L12
            stats.getNextBucket(bucket);     // Catch: Throwable -> L10 RuntimeException -> L12
            buckets.add(bucket);     // Catch: Throwable -> L10 RuntimeException -> L12
        L15:
            Trace.traceEnd(2097152);
            return buckets;
        L12:
            e = move-exception;
            RuntimeException e = e;
        L21:
            Slog.w(NetworkPolicyManagerService.TAG, "Failed to read network stats: " + e);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Throwable r11 = th;
        L24:
            Trace.traceEnd(2097152);
            throw r11;
        L18:
            e = move-exception;
            e = e;
        L16:
            th = move-exception;
            r11 = th;
            goto L24
        }

        int getDefaultDataSubId() {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }

        int getActivateDataSubId() {
            return SubscriptionManager.getActiveDataSubscriptionId();
        }
    }

    private static final class IfaceQuotas {
        public final String iface;
        public final long limit;
        public final long warning;

        /* synthetic */ IfaceQuotas(String r1, long r2, long r4, NetworkPolicyManagerServiceIA r6) {
            this(r1, r2, r4);
        }

        private IfaceQuotas(String iface, long warning, long limit) {
            this.iface = iface;
            this.warning = warning;
            this.limit = limit;
        }
    }

    private class NetPolicyAppIdleStateChangeListener extends AppStandbyInternal.AppIdleStateChangeListener {
        final /* synthetic */ NetworkPolicyManagerService this$0;

        /* synthetic */ NetPolicyAppIdleStateChangeListener(NetworkPolicyManagerService r1, NetworkPolicyManagerServiceIA r2) {
            this(r1);
        }

        private NetPolicyAppIdleStateChangeListener(NetworkPolicyManagerService r1) {
            this.this$0 = r1;
        }

        public void onAppIdleStateChanged(String packageName, int userId, boolean idle, int bucket, int reason) {
            int uid = NetworkPolicyManagerService.m5976$$Nest$fgetmContext(this.this$0).getPackageManager().getPackageUidAsUser(packageName, 8192, userId);     // Catch: PackageManager.NameNotFoundException -> L10
            Object r1 = this.this$0.mUidRulesFirstLock;     // Catch: PackageManager.NameNotFoundException -> L10
            monitor-enter(r1);     // Catch: PackageManager.NameNotFoundException -> L10
            NetworkPolicyManagerService.m5979$$Nest$fgetmLogger(this.this$0).appIdleStateChanged(uid, idle);     // Catch: Throwable -> L7
            this.this$0.updateRuleForAppIdleUL(uid, -1);     // Catch: Throwable -> L7
            NetworkPolicyManagerService.m6021$$Nest$mupdateRulesForPowerRestrictionsUL(this.this$0, uid);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            goto L11
        L16:
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: PackageManager.NameNotFoundException -> L10
        }

        public void onParoleStateChanged(boolean isParoleOn) {
            Object r0 = this.this$0.mUidRulesFirstLock;
            monitor-enter(r0);
            NetworkPolicyManagerService.m5979$$Nest$fgetmLogger(this.this$0).paroleStateChanged(isParoleOn);     // Catch: Throwable -> L7
            NetworkPolicyManagerService.m6018$$Nest$mupdateRulesForAppIdleParoleUL(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private class NetworkPolicyManagerInternalImpl extends NetworkPolicyManagerInternal {
        final /* synthetic */ NetworkPolicyManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$Eorgwm5gR8P86BvHTwgo-Zy4s1M, reason: not valid java name */
        public static /* synthetic */ void m6030$r8$lambda$Eorgwm5gR8P86BvHTwgoZy4s1M(NetworkPolicyManagerInternalImpl r0, int r1) {
            r0.lambda$setLowPowerStandbyActive$0(r1);
        }

        /* synthetic */ NetworkPolicyManagerInternalImpl(NetworkPolicyManagerService r1, NetworkPolicyManagerServiceIA r2) {
            this(r1);
        }

        private NetworkPolicyManagerInternalImpl(NetworkPolicyManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void resetUserState(int userId) {
            Object r0 = this.this$0.mUidRulesFirstLock;
            monitor-enter(r0);
            boolean changed = true;
            boolean changed2 = this.this$0.removeUserStateUL(userId, false, true);     // Catch: Throwable -> L18
            if (NetworkPolicyManagerService.m5992$$Nest$maddDefaultRestrictBackgroundAllowlistUidsUL(this.this$0, userId) == true) goto L9;
            if (changed2 == true) goto L9;
            changed = false;
        L9:
            if (changed == false) goto L20;
            Object r1 = this.this$0.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L18
            monitor-enter(r1);     // Catch: Throwable -> L18
            this.this$0.writePolicyAL();     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void onTempPowerSaveWhitelistChange(int appId, boolean added, int reasonCode, String reason) {
            Object r0 = this.this$0.mUidRulesFirstLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mSystemReady == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            NetworkPolicyManagerService.m5979$$Nest$fgetmLogger(this.this$0).tempPowerSaveWlChanged(appId, added, reasonCode, reason);     // Catch: Throwable -> L8
            if (added == false) goto L13;
            NetworkPolicyManagerService.m5987$$Nest$fgetmPowerSaveTempWhitelistAppIds(this.this$0).put(appId, true);     // Catch: Throwable -> L8
        L14:
            NetworkPolicyManagerService.m6024$$Nest$mupdateRulesForTempAllowlistChangeUL(this.this$0, appId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L13:
            NetworkPolicyManagerService.m5987$$Nest$fgetmPowerSaveTempWhitelistAppIds(this.this$0).delete(appId);     // Catch: Throwable -> L8
            goto L14
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public SubscriptionPlan getSubscriptionPlan(Network network) {
            Object r0 = this.this$0.mNetworkPoliciesSecondLock;
            monitor-enter(r0);
            int subId = NetworkPolicyManagerService.m6005$$Nest$mgetSubIdLocked(this.this$0, network);     // Catch: Throwable -> L7
            SubscriptionPlan r2 = NetworkPolicyManagerService.m6004$$Nest$mgetPrimarySubscriptionPlanLocked(this.this$0, subId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public long getSubscriptionOpportunisticQuota(Network network, int quotaType) {
            Object r0 = this.this$0.mNetworkPoliciesSecondLock;
            monitor-enter(r0);
            long quotaBytes = this.this$0.mSubscriptionOpportunisticQuota.get(NetworkPolicyManagerService.m6005$$Nest$mgetSubIdLocked(this.this$0, network), -1);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            if (quotaBytes != (-1)) goto L10;
            return -1;
        L10:
            if (quotaType != 1) goto L14;
            return (long) (quotaBytes * Settings.Global.getFloat(NetworkPolicyManagerService.m5976$$Nest$fgetmContext(this.this$0).getContentResolver(), "netpolicy_quota_frac_jobs", 0.5f));
        L14:
            if (quotaType == 2) goto L16;
            return -1;
        L16:
            return (long) (quotaBytes * Settings.Global.getFloat(NetworkPolicyManagerService.m5976$$Nest$fgetmContext(this.this$0).getContentResolver(), "netpolicy_quota_frac_multipath", 0.5f));
        L18:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void onAdminDataAvailable() {
            NetworkPolicyManagerService.m5974$$Nest$fgetmAdminDataAvailableLatch(this.this$0).countDown();
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void setAppIdleWhitelist(int uid, boolean shouldWhitelist) {
            this.this$0.setAppIdleWhitelist(uid, shouldWhitelist);
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void setMeteredRestrictedPackages(Set<String> packageNames, int userId) {
            NetworkPolicyManagerService.m6011$$Nest$msetMeteredRestrictedPackagesInternal(this.this$0, packageNames, userId);
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void setMeteredRestrictedPackagesAsync(Set<String> packageNames, int userId) {
            this.this$0.mHandler.obtainMessage(17, userId, 0, packageNames).sendToTarget();
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void setLowPowerStandbyActive(boolean active) {
            Trace.traceBegin(2097152, "setLowPowerStandbyActive");
            Object r0 = this.this$0.mUidRulesFirstLock;     // Catch: Throwable -> L31
            monitor-enter(r0);     // Catch: Throwable -> L31
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L6:
            if (this.this$0.mLowPowerStandbyActive != active) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L10
            Trace.traceEnd(2097152);
            return;
        L12:
            this.this$0.mLowPowerStandbyActive = active;     // Catch: Throwable -> L10
            Object r3 = this.this$0.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L10
            monitor-enter(r3);     // Catch: Throwable -> L10
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L15:
            if (this.this$0.mSystemReady == true) goto L22;
            monitor-exit(r3);     // Catch: Throwable -> L20
            monitor-exit(r0);     // Catch: Throwable -> L10
            Trace.traceEnd(2097152);
            return;
        L22:
            monitor-exit(r3);     // Catch: Throwable -> L20
            NetworkPolicyManagerService.m6002$$Nest$mforEachUid(this.this$0, "updateRulesForRestrictPower", new NetworkPolicyManagerService$NetworkPolicyManagerInternalImpl$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L10
            this.this$0.updateRulesForLowPowerStandbyUL();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            Trace.traceEnd(2097152);
            return;
        L31:
            th = move-exception;
            Trace.traceEnd(2097152);
            throw th;
        }

        private /* synthetic */ void lambda$setLowPowerStandbyActive$0(int uid) {
            NetworkPolicyManagerService.m6021$$Nest$mupdateRulesForPowerRestrictionsUL(this.this$0, uid);
        }

        @Override // com.android.server.net.NetworkPolicyManagerInternal
        public void setLowPowerStandbyAllowlist(int[] uids) {
            Object r0 = this.this$0.mUidRulesFirstLock;
            monitor-enter(r0);
            SparseBooleanArray changedUids = new SparseBooleanArray();     // Catch: Throwable -> L10
            int i = 0;
        L6:
            if (i >= NetworkPolicyManagerService.m5980$$Nest$fgetmLowPowerStandbyAllowlistUids(this.this$0).size()) goto L13;
            int oldUid = NetworkPolicyManagerService.m5980$$Nest$fgetmLowPowerStandbyAllowlistUids(this.this$0).keyAt(i);     // Catch: Throwable -> L10
            if (ArrayUtils.contains(uids, oldUid) == true) goto L12;
            changedUids.put(oldUid, true);     // Catch: Throwable -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L10
            goto L6
        L13:
            int i2 = 0;
        L15:
            if (i2 >= changedUids.size()) goto L17;
            int deletedUid = changedUids.keyAt(i2);     // Catch: Throwable -> L10
            NetworkPolicyManagerService.m5980$$Nest$fgetmLowPowerStandbyAllowlistUids(this.this$0).delete(deletedUid);     // Catch: Throwable -> L10
            i2 = i2 + 1;     // Catch: Throwable -> L10
            goto L15
        L17:
            int i3 = uids.length;     // Catch: Throwable -> L10
            int r3 = 0;
        L18:
            if (r3 >= i3) goto L24;
            int newUid = uids[r3];     // Catch: Throwable -> L10
            if (NetworkPolicyManagerService.m5980$$Nest$fgetmLowPowerStandbyAllowlistUids(this.this$0).indexOfKey(newUid) >= 0) goto L22;
            changedUids.append(newUid, true);     // Catch: Throwable -> L10
            NetworkPolicyManagerService.m5980$$Nest$fgetmLowPowerStandbyAllowlistUids(this.this$0).append(newUid, true);     // Catch: Throwable -> L10
        L22:
            r3 = r3 + 1;     // Catch: Throwable -> L10
            goto L18
        L24:
            if (this.this$0.mLowPowerStandbyActive == true) goto L27;
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L27:
            Object r2 = this.this$0.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L10
            monitor-enter(r2);     // Catch: Throwable -> L10
        L34:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L30:
            if (this.this$0.mSystemReady == true) goto L36;
            monitor-exit(r2);     // Catch: Throwable -> L34
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L36:
            monitor-exit(r2);     // Catch: Throwable -> L34
            int i4 = 0;
        L39:
            if (i4 >= changedUids.size()) goto L42;
            int changedUid = changedUids.keyAt(i4);     // Catch: Throwable -> L10
            NetworkPolicyManagerService.m6021$$Nest$mupdateRulesForPowerRestrictionsUL(this.this$0, changedUid);     // Catch: Throwable -> L10
            this.this$0.updateRuleForLowPowerStandbyUL(changedUid);     // Catch: Throwable -> L10
            i4 = i4 + 1;     // Catch: Throwable -> L10
            goto L39
        L42:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private static class NotificationId {
        private final int mId;
        private final String mTag;

        NotificationId(NetworkPolicy policy, int type) {
            this.mTag = buildNotificationTag(policy, type);
            this.mId = type;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof NotificationId) == true) goto L9;
            return false;
        L9:
            NotificationId that = (NotificationId) o;
            return Objects.equals(this.mTag, that.mTag);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mTag});
        }

        private static String buildNotificationTag(NetworkPolicy policy, int type) {
            return "NetworkPolicy:" + policy.template.hashCode() + ":" + type;
        }

        public String getTag() {
            return this.mTag;
        }

        public int getId() {
            return this.mId;
        }

        public String toString() {
            return this.mTag;
        }
    }

    private static class RestrictedModeObserver extends ContentObserver {
        private final Context mContext;
        private final RestrictedModeListener mListener;

        public interface RestrictedModeListener {
            void onChange(boolean r1);
        }

        RestrictedModeObserver(Context ctx, RestrictedModeListener listener) {
            super(null);
            this.mContext = ctx;
            this.mListener = listener;
            this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("restricted_networking_mode"), false, this);
        }

        public boolean isRestrictedModeEnabled() {
            if (Settings.Global.getInt(this.mContext.getContentResolver(), "restricted_networking_mode", 0) == 0) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            this.mListener.onChange(isRestrictedModeEnabled());
        }
    }

    interface Stats {
        public static final int COUNT = 2;
        public static final int IS_UID_NETWORKING_BLOCKED = 1;
        public static final int UPDATE_NETWORK_ENABLED = 0;
    }

    private class StatsCallback extends NetworkStatsManager.UsageCallback {
        private boolean mIsAnyCallbackReceived;
        final /* synthetic */ NetworkPolicyManagerService this$0;

        /* synthetic */ StatsCallback(NetworkPolicyManagerService r1, NetworkPolicyManagerServiceIA r2) {
            this(r1);
        }

        private StatsCallback(NetworkPolicyManagerService r1) {
            this.this$0 = r1;
            this.mIsAnyCallbackReceived = false;
        }

        @Override // android.app.usage.NetworkStatsManager.UsageCallback
        public void onThresholdReached(int networkType, String subscriberId) {
            this.mIsAnyCallbackReceived = true;
            Object r0 = this.this$0.mNetworkPoliciesSecondLock;
            monitor-enter(r0);
            this.this$0.updateNetworkRulesNL();     // Catch: Throwable -> L7
            this.this$0.updateNetworkEnabledNL();     // Catch: Throwable -> L7
            this.this$0.updateNotificationsNL();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isAnyCallbackReceived() {
            return this.mIsAnyCallbackReceived;
        }
    }

    static final class UidBlockedState {
        private static final int[] ALLOWED_REASONS = null;
        private static final int[] BLOCKED_REASONS = null;
        public int allowedReasons;
        public int blockedReasons;
        public int effectiveBlockedReasons;

        private UidBlockedState(int blockedReasons, int allowedReasons, int effectiveBlockedReasons) {
            this.blockedReasons = blockedReasons;
            this.allowedReasons = allowedReasons;
            this.effectiveBlockedReasons = effectiveBlockedReasons;
        }

        UidBlockedState() {
            this(0, 0, 0);
        }

        void updateEffectiveBlockedReasons() {
            if (NetworkPolicyManagerService.m6028$$Nest$sfgetLOGV() == true) goto L5;
        L7:
            this.effectiveBlockedReasons = getEffectiveBlockedReasons(this.blockedReasons, this.allowedReasons);
            if (NetworkPolicyManagerService.m6028$$Nest$sfgetLOGV() == false) goto L11;
            Log.v(NetworkPolicyManagerService.TAG, "updateEffectiveBlockedReasons(): blockedReasons=" + Integer.toBinaryString(this.blockedReasons) + ", effectiveReasons=" + Integer.toBinaryString(this.effectiveBlockedReasons));
            return;
        L11:
            return;
        L5:
            if (this.blockedReasons != 0) goto L7;
            Log.v(NetworkPolicyManagerService.TAG, "updateEffectiveBlockedReasons(): no blocked reasons");
            goto L7
        }

        static int getEffectiveBlockedReasons(int blockedReasons, int allowedReasons) {
            int effectiveBlockedReasons = blockedReasons;
            if (blockedReasons != 0) goto L6;
            return effectiveBlockedReasons;
        L6:
            if ((allowedReasons & 1) == 0) goto L9;
            effectiveBlockedReasons = effectiveBlockedReasons & (-65536);
        L9:
            if ((131072 & allowedReasons) == 0) goto L12;
            effectiveBlockedReasons = effectiveBlockedReasons & 65535;
        L12:
            if ((allowedReasons & 2) == 0) goto L15;
            effectiveBlockedReasons = ((effectiveBlockedReasons & (-2)) & (-3)) & (-5);
        L15:
            if ((262144 & allowedReasons) == 0) goto L18;
            effectiveBlockedReasons = (effectiveBlockedReasons & (-65537)) & (-131073);
        L18:
            if ((allowedReasons & 32) == 0) goto L21;
            effectiveBlockedReasons = effectiveBlockedReasons & (-33);
        L21:
            if ((allowedReasons & 4) == 0) goto L24;
            effectiveBlockedReasons = (((effectiveBlockedReasons & (-2)) & (-3)) & (-5)) & (-65);
        L24:
            if ((allowedReasons & 8) == 0) goto L27;
            effectiveBlockedReasons = ((effectiveBlockedReasons & (-2)) & (-5)) & (-65);
        L27:
            if ((allowedReasons & 16) == 0) goto L30;
            effectiveBlockedReasons = effectiveBlockedReasons & (-9);
        L30:
            if ((65536 & allowedReasons) == 0) goto L33;
            effectiveBlockedReasons = effectiveBlockedReasons & (-65537);
        L33:
            if ((allowedReasons & 64) == 0) goto L36;
            effectiveBlockedReasons = effectiveBlockedReasons & (-33);
        L36:
            if ((allowedReasons & 128) != 0) goto L38;
            return effectiveBlockedReasons;
        L38:
            return effectiveBlockedReasons & (-65);
        }

        static int getAllowedReasonsForProcState(int procState) {
            if (procState > 3) goto L7;
            return 262306;
        L7:
            if (procState > 5) goto L11;
            return 262274;
        L11:
            if (procState >= 12) goto L14;
            return 128;
        L14:
            return 0;
        }

        public String toString() {
            return toString(this.blockedReasons, this.allowedReasons, this.effectiveBlockedReasons);
        }

        public static String toString(int blockedReasons, int allowedReasons, int effectiveBlockedReasons) {
            return "{blocked=" + blockedReasonsToString(blockedReasons) + ",allowed=" + allowedReasonsToString(allowedReasons) + ",effective=" + blockedReasonsToString(effectiveBlockedReasons) + "}";
        }

        static {
            BLOCKED_REASONS = new int[]{1, 2, 4, 8, 32, 64, 65536, 131072, 262144, 1048576};
            ALLOWED_REASONS = new int[]{1, 2, 32, 4, 8, 16, 64, 128, 65536, 131072, 262144};
        }

        private static String blockedReasonToString(int blockedReason) {
            switch(blockedReason) {
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L21;
                case 4: goto L19;
                case 8: goto L17;
                case 32: goto L15;
                case 64: goto L13;
                case 65536: goto L11;
                case 131072: goto L9;
                case 262144: goto L7;
                case 1048576: goto L5;
                default: goto L3;
            };
        L3:
            Slog.wtfStack(NetworkPolicyManagerService.TAG, "Unknown blockedReason: " + blockedReason);
            return String.valueOf(blockedReason);
        L5:
            return "BG_DISABLED";
        L7:
            return "METERED_ADMIN_DISABLED";
        L9:
            return "METERED_USER_RESTRICTED";
        L11:
            return "DATA_SAVER";
        L13:
            return "APP_BACKGROUND";
        L15:
            return "LOW_POWER_STANDBY";
        L17:
            return "RESTRICTED_MODE";
        L19:
            return "APP_STANDBY";
        L21:
            return "DOZE";
        L23:
            return "BATTERY_SAVER";
        L25:
            return "NONE";
        }

        private static String allowedReasonToString(int allowedReason) {
            switch(allowedReason) {
                case 0: goto L27;
                case 1: goto L25;
                case 2: goto L23;
                case 4: goto L21;
                case 8: goto L19;
                case 16: goto L17;
                case 32: goto L15;
                case 64: goto L13;
                case 128: goto L11;
                case 65536: goto L9;
                case 131072: goto L7;
                case 262144: goto L5;
                default: goto L3;
            };
        L3:
            Slog.wtfStack(NetworkPolicyManagerService.TAG, "Unknown allowedReason: " + allowedReason);
            return String.valueOf(allowedReason);
        L5:
            return "METERED_FOREGROUND";
        L7:
            return "METERED_SYSTEM";
        L9:
            return "METERED_USER_EXEMPTED";
        L11:
            return "NOT_IN_BACKGROUND";
        L13:
            return "LOW_POWER_STANDBY_ALLOWLIST";
        L15:
            return "TOP";
        L17:
            return "RESTRICTED_MODE_PERMISSIONS";
        L19:
            return "POWER_SAVE_EXCEPT_IDLE_ALLOWLIST";
        L21:
            return "POWER_SAVE_ALLOWLIST";
        L23:
            return "FOREGROUND";
        L25:
            return "SYSTEM";
        L27:
            return "NONE";
        }

        public static String blockedReasonsToString(int blockedReasons) {
            int r0 = 0;
            if (blockedReasons == 0) goto L5;
            StringBuilder sb = new StringBuilder();
            int[] r2 = BLOCKED_REASONS;
            int r3 = r2.length;
        L7:
            String r4 = "|";
            if (r0 >= r3) goto L16;
            int reason = r2[r0];
            if ((blockedReasons & reason) == 0) goto L15;
            if (sb.length() != 0) goto L14;
            r4 = "";
        L14:
            sb.append(r4);
            sb.append(blockedReasonToString(reason));
            blockedReasons = blockedReasons & (~reason);
        L15:
            r0 = r0 + 1;
            goto L7
        L16:
            if (blockedReasons == 0) goto L22;
            if (sb.length() != 0) goto L20;
            r4 = "";
        L20:
            sb.append(r4);
            sb.append(String.valueOf(blockedReasons));
            Slog.wtfStack(NetworkPolicyManagerService.TAG, "Unknown blockedReasons: " + blockedReasons);
        L22:
            return sb.toString();
        L5:
            return blockedReasonToString(0);
        }

        public static String allowedReasonsToString(int allowedReasons) {
            int r0 = 0;
            if (allowedReasons == 0) goto L5;
            StringBuilder sb = new StringBuilder();
            int[] r2 = ALLOWED_REASONS;
            int r3 = r2.length;
        L7:
            String r4 = "|";
            if (r0 >= r3) goto L16;
            int reason = r2[r0];
            if ((allowedReasons & reason) == 0) goto L15;
            if (sb.length() != 0) goto L14;
            r4 = "";
        L14:
            sb.append(r4);
            sb.append(allowedReasonToString(reason));
            allowedReasons = allowedReasons & (~reason);
        L15:
            r0 = r0 + 1;
            goto L7
        L16:
            if (allowedReasons == 0) goto L22;
            if (sb.length() != 0) goto L20;
            r4 = "";
        L20:
            sb.append(r4);
            sb.append(String.valueOf(allowedReasons));
            Slog.wtfStack(NetworkPolicyManagerService.TAG, "Unknown allowedReasons: " + allowedReasons);
        L22:
            return sb.toString();
        L5:
            return allowedReasonToString(0);
        }

        public void copyFrom(UidBlockedState uidBlockedState) {
            this.blockedReasons = uidBlockedState.blockedReasons;
            this.allowedReasons = uidBlockedState.allowedReasons;
            this.effectiveBlockedReasons = uidBlockedState.effectiveBlockedReasons;
        }

        public int deriveUidRules() {
            int uidRule = 0;
            if ((this.effectiveBlockedReasons & 8) == 0) goto L6;
            uidRule = 0 | 1024;
        L6:
            if ((this.effectiveBlockedReasons & 103) == 0) goto L9;
            uidRule = uidRule | 64;
        L12:
            if ((this.effectiveBlockedReasons & 393216) == 0) goto L15;
            uidRule = uidRule | 4;
        L28:
            if ((this.effectiveBlockedReasons & 1048576) == 0) goto L31;
            uidRule = uidRule | 128;
        L31:
            if (NetworkPolicyManagerService.m6028$$Nest$sfgetLOGV() == false) goto L33;
            Slog.v(NetworkPolicyManagerService.TAG, "uidBlockedState=" + this + " -> uidRule=" + NetworkPolicyManager.uidRulesToString(uidRule));
        L33:
            return uidRule;
        L15:
            if ((this.blockedReasons & 131072) == 0) goto L20;
            if ((this.allowedReasons & 262144) == 0) goto L20;
            uidRule = uidRule | 2;
        L20:
            if ((this.blockedReasons & 65536) == 0) goto L28;
            if ((this.allowedReasons & 65536) == 0) goto L25;
            uidRule = uidRule | 32;
            goto L28
        L25:
            if ((this.allowedReasons & 262144) == 0) goto L28;
            uidRule = uidRule | 2;
            goto L28
        L9:
            if ((this.blockedReasons & 103) == 0) goto L12;
            uidRule = uidRule | 32;
            goto L12
        }
    }

    private static final class UidStateCallbackInfo {
        public int capability;
        public boolean isPending;
        public int procState;
        public long procStateSeq;
        public int uid;

        /* synthetic */ UidStateCallbackInfo(NetworkPolicyManagerServiceIA r1) {
            this();
        }

        private UidStateCallbackInfo() {
            this.procState = 20;
            this.procStateSeq = -1;
        }

        public void update(int uid, int procState, long procStateSeq, int capability) {
            this.uid = uid;
            this.procState = procState;
            this.procStateSeq = procStateSeq;
            this.capability = capability;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("uid=");
            sb.append(this.uid);
            sb.append(",");
            sb.append("proc_state=");
            sb.append(ActivityManager.procStateToString(this.procState));
            sb.append(",");
            sb.append("seq=");
            sb.append(this.procStateSeq);
            sb.append(",");
            sb.append("cap=");
            ActivityManager.printCapabilitiesSummary(sb, this.capability);
            sb.append(",");
            sb.append("pending=");
            sb.append(this.isPending);
            sb.append("}");
            return sb.toString();
        }
    }

    public static /* synthetic */ void $r8$lambda$3GuQhs92xi8ei4ZPpN0P0tku59c(NetworkPolicyManagerService r0, int r1) {
        r0.lambda$updateRulesForRestrictBackgroundUL$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$5Bzemdqa4u7WtPncTGtyV6odZ1o(NetworkPolicyManagerService r0, int r1) {
        r0.lambda$updateRulesForRestrictPowerUL$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$BCOXJnz0Yso4ytSwaFPgX32dfqQ(NetworkPolicyManagerService r0, SparseIntArray r1, int r2) {
        r0.lambda$updateRestrictedModeAllowlistUL$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$De1nAbH4FF8eM7AAo9J-bhSZ_a0, reason: not valid java name */
    public static /* synthetic */ void m5973$r8$lambda$De1nAbH4FF8eM7AAo9JbhSZ_a0(NetworkPolicyManagerService r0, int r1) {
        r0.lambda$handleDeviceIdleModeChangedUL$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$Dk3c_PWeFqFDh_UsrdcGT7NTPxc(CountDownLatch r0) {
        lambda$updateNetworks$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$LgIB7ao7OPlj1X80zfarWKVGUGc(NetworkPolicyManagerService r0, boolean r1) {
        r0.lambda$initService$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$Vjvidsl51zqXS7fNCzjK8IojqZ8(NetworkPolicyManagerService r0, CountDownLatch r1) {
        r0.lambda$networkScoreAndNetworkManagementServiceReady$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$y6NbbUE5w9mVKKbVy0XCA9aA5_c(SparseBooleanArray r0, int r1, IntConsumer r2, AndroidPackage r3) {
        lambda$forEachUid$7(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdminDataAvailableLatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountDownLatch m5974$$Nest$fgetmAdminDataAvailableLatch(NetworkPolicyManagerService r0) {
        return r0.mAdminDataAvailableLatch;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackgroundTransitioningUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseLongArray m5975$$Nest$fgetmBackgroundTransitioningUids(NetworkPolicyManagerService r0) {
        return r0.mBackgroundTransitioningUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5976$$Nest$fgetmContext(NetworkPolicyManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeps, reason: not valid java name */
    static /* bridge */ /* synthetic */ Dependencies m5977$$Nest$fgetmDeps(NetworkPolicyManagerService r0) {
        return r0.mDeps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m5978$$Nest$fgetmListeners(NetworkPolicyManagerService r0) {
        return r0.mListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkPolicyLogger m5979$$Nest$fgetmLogger(NetworkPolicyManagerService r0) {
        return r0.mLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLowPowerStandbyAllowlistUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m5980$$Nest$fgetmLowPowerStandbyAllowlistUids(NetworkPolicyManagerService r0) {
        return r0.mLowPowerStandbyAllowlistUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMeteredIfaces, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m5981$$Nest$fgetmMeteredIfaces(NetworkPolicyManagerService r0) {
        return r0.mMeteredIfaces;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMeteredRestrictedUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5982$$Nest$fgetmMeteredRestrictedUids(NetworkPolicyManagerService r0) {
        return r0.mMeteredRestrictedUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkMetered, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m5983$$Nest$fgetmNetworkMetered(NetworkPolicyManagerService r0) {
        return r0.mNetworkMetered;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkRoaming, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m5984$$Nest$fgetmNetworkRoaming(NetworkPolicyManagerService r0) {
        return r0.mNetworkRoaming;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkStatsManager m5985$$Nest$fgetmNetworkStats(NetworkPolicyManagerService r0) {
        return r0.mNetworkStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkToIfaces, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseSetArray m5986$$Nest$fgetmNetworkToIfaces(NetworkPolicyManagerService r0) {
        return r0.mNetworkToIfaces;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerSaveTempWhitelistAppIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m5987$$Nest$fgetmPowerSaveTempWhitelistAppIds(NetworkPolicyManagerService r0) {
        return r0.mPowerSaveTempWhitelistAppIds;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSubIdToSubscriberId, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5988$$Nest$fgetmSubIdToSubscriberId(NetworkPolicyManagerService r0) {
        return r0.mSubIdToSubscriberId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidStateCallbackInfos, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5989$$Nest$fgetmUidStateCallbackInfos(NetworkPolicyManagerService r0) {
        return r0.mUidStateCallbackInfos;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUseDifferentDelaysForBackgroundChain, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5990$$Nest$fgetmUseDifferentDelaysForBackgroundChain(NetworkPolicyManagerService r0) {
        return r0.mUseDifferentDelaysForBackgroundChain;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNextProcessBackgroundUidsTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5991$$Nest$fputmNextProcessBackgroundUidsTime(NetworkPolicyManagerService r0, long r1) {
        r0.mNextProcessBackgroundUidsTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddDefaultRestrictBackgroundAllowlistUidsUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5992$$Nest$maddDefaultRestrictBackgroundAllowlistUidsUL(NetworkPolicyManagerService r0, int r1) {
        return r0.addDefaultRestrictBackgroundAllowlistUidsUL(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mbroadcastRestrictBackgroundChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5993$$Nest$mbroadcastRestrictBackgroundChanged(NetworkPolicyManagerService r0, int r1, Boolean r2) {
        r0.broadcastRestrictBackgroundChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchBlockedReasonChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5994$$Nest$mdispatchBlockedReasonChanged(NetworkPolicyManagerService r0, INetworkPolicyListener r1, int r2, int r3, int r4) {
        r0.dispatchBlockedReasonChanged(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchMeteredIfacesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5995$$Nest$mdispatchMeteredIfacesChanged(NetworkPolicyManagerService r0, INetworkPolicyListener r1, String[] r2) {
        r0.dispatchMeteredIfacesChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchRestrictBackgroundChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5996$$Nest$mdispatchRestrictBackgroundChanged(NetworkPolicyManagerService r0, INetworkPolicyListener r1, boolean r2) {
        r0.dispatchRestrictBackgroundChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchSubscriptionOverride, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5997$$Nest$mdispatchSubscriptionOverride(NetworkPolicyManagerService r0, INetworkPolicyListener r1, int r2, int r3, int r4, int[] r5) {
        r0.dispatchSubscriptionOverride(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchSubscriptionPlansChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5998$$Nest$mdispatchSubscriptionPlansChanged(NetworkPolicyManagerService r0, INetworkPolicyListener r1, int r2, SubscriptionPlan[] r3) {
        r0.dispatchSubscriptionPlansChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchUidPoliciesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5999$$Nest$mdispatchUidPoliciesChanged(NetworkPolicyManagerService r0, INetworkPolicyListener r1, int r2, int r3) {
        r0.dispatchUidPoliciesChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchUidRulesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6000$$Nest$mdispatchUidRulesChanged(NetworkPolicyManagerService r0, INetworkPolicyListener r1, int r2, int r3) {
        r0.dispatchUidRulesChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mensureActiveCarrierPolicyAL, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6001$$Nest$mensureActiveCarrierPolicyAL(NetworkPolicyManagerService r0, int r1, String r2) {
        return r0.ensureActiveCarrierPolicyAL(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mforEachUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6002$$Nest$mforEachUid(NetworkPolicyManagerService r0, String r1, IntConsumer r2) {
        r0.forEachUid(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetBackgroundTransitioningDelay, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6003$$Nest$mgetBackgroundTransitioningDelay(NetworkPolicyManagerService r0, int r1) {
        return r0.getBackgroundTransitioningDelay(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPrimarySubscriptionPlanLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SubscriptionPlan m6004$$Nest$mgetPrimarySubscriptionPlanLocked(NetworkPolicyManagerService r0, int r1) {
        return r0.getPrimarySubscriptionPlanLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSubIdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6005$$Nest$mgetSubIdLocked(NetworkPolicyManagerService r0, Network r1) {
        return r0.getSubIdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeUpdateCarrierPolicyCycleAL, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6006$$Nest$mmaybeUpdateCarrierPolicyCycleAL(NetworkPolicyManagerService r0, int r1, String r2) {
        return r0.maybeUpdateCarrierPolicyCycleAL(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monUidDeletedUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6007$$Nest$monUidDeletedUL(NetworkPolicyManagerService r0, int r1) {
        r0.onUidDeletedUL(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveInterfaceLimit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6008$$Nest$mremoveInterfaceLimit(NetworkPolicyManagerService r0, String r1) {
        r0.removeInterfaceLimit(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetUidFirewallRules, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6009$$Nest$mresetUidFirewallRules(NetworkPolicyManagerService r0, int r1) {
        r0.resetUidFirewallRules(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetInterfaceLimit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6010$$Nest$msetInterfaceLimit(NetworkPolicyManagerService r0, String r1, long r2) {
        r0.setInterfaceLimit(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetMeteredRestrictedPackagesInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6011$$Nest$msetMeteredRestrictedPackagesInternal(NetworkPolicyManagerService r0, Set r1, int r2) {
        r0.setMeteredRestrictedPackagesInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetNetworkTemplateEnabledInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6012$$Nest$msetNetworkTemplateEnabledInner(NetworkPolicyManagerService r0, NetworkTemplate r1, boolean r2) {
        r0.setNetworkTemplateEnabledInner(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetSubscriptionPlansInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6013$$Nest$msetSubscriptionPlansInternal(NetworkPolicyManagerService r0, int r1, SubscriptionPlan[] r2, long r3, String r5) {
        r0.setSubscriptionPlansInternal(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNetworkToIfacesNL, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6014$$Nest$mupdateNetworkToIfacesNL(NetworkPolicyManagerService r0, int r1, ArraySet r2) {
        return r0.updateNetworkToIfacesNL(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNetworksInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6015$$Nest$mupdateNetworksInternal(NetworkPolicyManagerService r0) {
        r0.updateNetworksInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePowerSaveAllowlistUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6016$$Nest$mupdatePowerSaveAllowlistUL(NetworkPolicyManagerService r0) {
        r0.updatePowerSaveAllowlistUL();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRestrictionRulesForUidUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6017$$Nest$mupdateRestrictionRulesForUidUL(NetworkPolicyManagerService r0, int r1) {
        r0.updateRestrictionRulesForUidUL(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRulesForAppIdleParoleUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6018$$Nest$mupdateRulesForAppIdleParoleUL(NetworkPolicyManagerService r0) {
        r0.updateRulesForAppIdleParoleUL();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRulesForBackgroundChainUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6019$$Nest$mupdateRulesForBackgroundChainUL(NetworkPolicyManagerService r0) {
        r0.updateRulesForBackgroundChainUL();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRulesForGlobalChangeAL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6020$$Nest$mupdateRulesForGlobalChangeAL(NetworkPolicyManagerService r0, boolean r1) {
        r0.updateRulesForGlobalChangeAL(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRulesForPowerRestrictionsUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6021$$Nest$mupdateRulesForPowerRestrictionsUL(NetworkPolicyManagerService r0, int r1) {
        r0.updateRulesForPowerRestrictionsUL(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRulesForPowerRestrictionsUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6022$$Nest$mupdateRulesForPowerRestrictionsUL(NetworkPolicyManagerService r0, int r1, boolean r2) {
        r0.updateRulesForPowerRestrictionsUL(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRulesForRestrictPowerUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6023$$Nest$mupdateRulesForRestrictPowerUL(NetworkPolicyManagerService r0) {
        r0.updateRulesForRestrictPowerUL();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRulesForTempAllowlistChangeUL, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6024$$Nest$mupdateRulesForTempAllowlistChangeUL(NetworkPolicyManagerService r0, int r1) {
        r0.updateRulesForTempAllowlistChangeUL(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupgradeWifiMeteredOverride, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6025$$Nest$mupgradeWifiMeteredOverride(NetworkPolicyManagerService r0) {
        r0.upgradeWifiMeteredOverride();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6026$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOGD, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6027$$Nest$sfgetLOGD() {
        return LOGD;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOGV, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6028$$Nest$sfgetLOGV() {
        return LOGV;
    }

    /* JADX INFO: renamed from: -$$Nest$smupdateCapabilityChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6029$$Nest$smupdateCapabilityChange(SparseBooleanArray r0, boolean r1, Network r2) {
        return updateCapabilityChange(r0, r1, r2);
    }

    static {
        LOGD = NetworkPolicyLogger.LOGD;
        LOGV = NetworkPolicyLogger.LOGV;
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DEBUG = r1;
        QUOTA_UNLIMITED_DEFAULT = DataUnit.MEBIBYTES.toBytes(20);
    }

    public NetworkPolicyManagerService(Context context, IActivityManager activityManager, INetworkManagementService networkManagement) {
        this(context, activityManager, networkManagement, AppGlobals.getPackageManager(), getDefaultClock(), getDefaultSystemDir(), false, new Dependencies(context));
    }

    private static File getDefaultSystemDir() {
        return new File(Environment.getDataDirectory(), "system");
    }

    private static Clock getDefaultClock() {
        return new BestClock(ZoneOffset.UTC, new Clock[]{SystemClock.currentNetworkTimeClock(), Clock.systemUTC()});
    }

    NetworkPolicyManager.UidState getUidStateForTest(int uid) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        NetworkPolicyManager.UidState r1 = this.mUidState.get(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public NetworkPolicyManagerService(Context context, IActivityManager activityManager, INetworkManagementService networkManagement, IPackageManager pm, Clock clock, File systemDir, boolean suppressDefaultPolicy, Dependencies deps) {
        this.mUidRulesFirstLock = new Object();
        this.mNetworkPoliciesSecondLock = new Object();
        this.mAdminDataAvailableLatch = new CountDownLatch(1);
        this.mBackgroundRestrictionDelayMs = TimeUnit.SECONDS.toMillis(5);
        this.mBackgroundRestrictionShortDelayMs = TimeUnit.SECONDS.toMillis(2);
        this.mBackgroundRestrictionLongDelayMs = TimeUnit.SECONDS.toMillis(20);
        this.mNextProcessBackgroundUidsTime = Long.MAX_VALUE;
        this.mNetworkPolicy = new ArrayMap();
        this.mSubscriptionPlans = new SparseArray();
        this.mSubscriptionPlansOwner = new SparseArray();
        this.mSetSubscriptionPlansIds = new SparseIntArray();
        this.mSetSubscriptionPlansIdCounter = 0;
        this.mSubscriptionOpportunisticQuota = new SparseLongArray();
        this.mUidPolicy = new SparseIntArray();
        this.mUidFirewallStandbyRules = new SparseIntArray();
        this.mFirewallChainStates = new SparseBooleanArray();
        this.mPowerSaveWhitelistExceptIdleAppIds = new SparseBooleanArray();
        this.mPowerSaveWhitelistAppIds = new SparseBooleanArray();
        this.mPowerSaveTempWhitelistAppIds = new SparseBooleanArray();
        this.mLowPowerStandbyAllowlistUids = new SparseBooleanArray();
        this.mAppIdleTempWhitelistAppIds = new SparseBooleanArray();
        this.mDefaultRestrictBackgroundAllowlistUids = new SparseBooleanArray();
        this.mRestrictBackgroundAllowlistRevokedUids = new SparseBooleanArray();
        this.mMeteredIfacesLock = new Object();
        this.mMeteredIfaces = new ArraySet();
        this.mOverLimitNotified = new ArraySet();
        this.mActiveNotifs = new ArraySet();
        this.mUidState = new SparseArray();
        this.mUidBlockedState = new SparseArray();
        this.mTmpUidBlockedState = new SparseArray();
        this.mBackgroundTransitioningUids = new SparseLongArray();
        this.mNetworkMetered = new SparseBooleanArray();
        this.mNetworkRoaming = new SparseBooleanArray();
        this.mNetworkToIfaces = new SparseSetArray();
        this.mNetIdToSubId = new SparseIntArray();
        this.mSubIdToSubscriberId = new SparseArray();
        this.mMergedSubscriberIds = new ArrayList();
        this.mSubIdToCarrierConfig = new SparseArray();
        this.mMeteredRestrictedUids = new SparseArray();
        this.mListeners = new RemoteCallbackList();
        this.mLogger = new NetworkPolicyLogger();
        this.mInternetPermissionMap = new SparseBooleanArray();
        this.mUidStateCallbackInfos = new SparseArray();
        this.mStatLogger = new StatLogger(new String[]{"updateNetworkEnabledNL()", "isUidNetworkingBlocked()"});
        this.mUidObserver = new AnonymousClass4(this);
        this.mPowerSaveAllowlistReceiver = new AnonymousClass5(this);
        this.mPackageReceiver = new AnonymousClass6(this);
        this.mUidRemovedReceiver = new AnonymousClass7(this);
        this.mUserReceiver = new AnonymousClass8(this);
        NetworkPolicyManagerServiceIA r2 = null;
        this.mStatsCallback = new StatsCallback(this, r2);
        this.mSnoozeReceiver = new AnonymousClass9(this);
        this.mWifiReceiver = new AnonymousClass10(this);
        this.mNetworkCallback = new AnonymousClass11(this);
        this.mAlertObserver = new AnonymousClass12(this);
        this.mConnReceiver = new AnonymousClass13(this);
        this.mCarrierConfigReceiver = new AnonymousClass14(this);
        this.mHandlerCallback = new AnonymousClass15(this);
        this.mUidEventHandlerCallback = new AnonymousClass16(this);
        context.getClass();
        this.mContext = context;
        activityManager.getClass();
        this.mActivityManager = activityManager;
        networkManagement.getClass();
        this.mNetworkManager = networkManagement;
        this.mPowerExemptionManager = (PowerExemptionManager) this.mContext.getSystemService(PowerExemptionManager.class);
        clock.getClass();
        this.mClock = clock;
        this.mUserManager = (UserManager) this.mContext.getSystemService("user");
        this.mCarrierConfigManager = (CarrierConfigManager) this.mContext.getSystemService(CarrierConfigManager.class);
        this.mIPm = pm;
        this.mSmtEx = new NetworkPolicyManagerServiceSmtEx(this.mContext, this);
        HandlerThread thread = new HandlerThread(TAG);
        thread.start();
        this.mHandler = new Handler(thread.getLooper(), this.mHandlerCallback);
        this.mUidEventThread = new ServiceThread("NetworkPolicy.uid", -2, false);
        this.mUidEventThread.start();
        this.mUidEventHandler = new Handler(this.mUidEventThread.getLooper(), this.mUidEventHandlerCallback);
        this.mSuppressDefaultPolicy = suppressDefaultPolicy;
        deps.getClass();
        this.mDeps = deps;
        this.mActiveDataSubIdListener = new ActiveDataSubIdListener(this, r2);
        this.mPolicyFile = new AtomicFile(new File(systemDir, "netpolicy.xml"), "net-policy");
        this.mAppOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mNetworkStats = (NetworkStatsManager) context.getSystemService(NetworkStatsManager.class);
        this.mMultipathPolicyTracker = new MultipathPolicyTracker(this.mContext, this.mHandler);
        LocalServices.addService(NetworkPolicyManagerInternal.class, new NetworkPolicyManagerInternalImpl(this, r2));
        SysOptBridge.getFactory().getPolicyServiceOptEx().init(context, this);
    }

    public void bindConnectivityManager() {
        ConnectivityManager r0 = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        r0.getClass();
        this.mConnManager = r0;
    }

    private void updatePowerSaveAllowlistUL() {
        int r1 = 0;
        int[] allowlist = this.mPowerExemptionManager.getAllowListedAppIds(false);
        this.mPowerSaveWhitelistExceptIdleAppIds.clear();
        int r2 = allowlist.length;
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L6;
        int uid = allowlist[r3];
        this.mPowerSaveWhitelistExceptIdleAppIds.put(uid, true);
        r3 = r3 + 1;
        goto L4
    L6:
        int[] allowlist2 = this.mPowerExemptionManager.getAllowListedAppIds(true);
        this.mPowerSaveWhitelistAppIds.clear();
        int r4 = allowlist2.length;
    L7:
        if (r1 >= r4) goto L9;
        int uid2 = allowlist2[r1];
        this.mPowerSaveWhitelistAppIds.put(uid2, true);
        r1 = r1 + 1;
        goto L7
    }

    boolean addDefaultRestrictBackgroundAllowlistUidsUL() {
        List<UserInfo> users = this.mUserManager.getUsers();
        int numberUsers = users.size();
        boolean changed = false;
        int i = 0;
    L3:
        if (i >= numberUsers) goto L12;
        UserInfo user = users.get(i);
        if (addDefaultRestrictBackgroundAllowlistUidsUL(user.id) == true) goto L9;
        if (changed == true) goto L9;
        boolean r5 = false;
    L10:
        changed = r5;
        i = i + 1;
    L9:
        r5 = true;
        goto L10
    L12:
        return changed;
    }

    private boolean addDefaultRestrictBackgroundAllowlistUidsUL(int userId) {
        SystemConfig sysConfig = SystemConfig.getInstance();
        PackageManager pm = this.mContext.getPackageManager();
        ArraySet<String> allowDataUsage = sysConfig.getAllowInDataUsageSave();
        boolean changed = false;
        int i = 0;
    L4:
        if (i >= allowDataUsage.size()) goto L29;
        String pkg = allowDataUsage.valueAt(i);
        if (LOGD == false) goto L30;
        Slog.d(TAG, "checking restricted background exemption for package " + pkg + " and user " + userId);
    L30:
        ApplicationInfo app = pm.getApplicationInfoAsUser(pkg, 1048576, userId);     // Catch: PackageManager.NameNotFoundException -> L22
        if (app.isPrivilegedApp() == true) goto L13;
        Slog.e(TAG, "addDefaultRestrictBackgroundAllowlistUidsUL(): skipping non-privileged app  " + pkg);
    L27:
        i = i + 1;
        goto L4
    L13:
        int uid = UserHandle.getUid(userId, app.uid);
        this.mDefaultRestrictBackgroundAllowlistUids.append(uid, true);
        if (LOGD == false) goto L17;
        Slog.d(TAG, "Adding uid " + uid + " (user " + userId + ") to default restricted background allowlist. Revoked status: " + this.mRestrictBackgroundAllowlistRevokedUids.get(uid));
    L17:
        if (this.mRestrictBackgroundAllowlistRevokedUids.get(uid) == true) goto L27;
        if (LOGD == false) goto L21;
        Slog.d(TAG, "adding default package " + pkg + " (uid " + uid + " for user " + userId + ") to restrict background allowlist");
    L21:
        setUidPolicyUncheckedUL(uid, 4, false);
        changed = true;
    L24:
        if (LOGD == false) goto L27;
        Slog.d(TAG, "No ApplicationInfo for package " + pkg);
        goto L27
    L29:
        return changed;
    }

    private void initService(CountDownLatch initCompleteSignal) {
        Trace.traceBegin(2097152, "systemReady");
        int oldPriority = Process.getThreadPriority(Process.myTid());
        Process.setThreadPriority(-2);     // Catch: Throwable -> L8
        if (isBandwidthControlEnabled() == true) goto L10;
        Slog.w(TAG, "bandwidth controls disabled, unable to enforce policy");     // Catch: Throwable -> L8
        Process.setThreadPriority(oldPriority);
        Trace.traceEnd(2097152);
        return;
    L10:
        this.mUsageStats = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);     // Catch: Throwable -> L8
        this.mAppStandby = (AppStandbyInternal) LocalServices.getService(AppStandbyInternal.class);     // Catch: Throwable -> L8
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L8
        this.mUseMeteredFirewallChains = true;     // Catch: Throwable -> L8
        this.mUseDifferentDelaysForBackgroundChain = false;     // Catch: Throwable -> L8
        this.mNeverApplyRulesToCoreUids = true;     // Catch: Throwable -> L8
        Object r6 = this.mUidRulesFirstLock;     // Catch: Throwable -> L8
        monitor-enter(r6);     // Catch: Throwable -> L8
        Object r7 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L49
        monitor-enter(r7);     // Catch: Throwable -> L49
        updatePowerSaveAllowlistUL();     // Catch: Throwable -> L19
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);     // Catch: Throwable -> L19
        this.mPowerManagerInternal.registerLowPowerModeObserver(new AnonymousClass1(this));     // Catch: Throwable -> L19
        this.mRestrictPower = this.mPowerManagerInternal.getLowPowerState(6).batterySaverEnabled;     // Catch: Throwable -> L19
        this.mRestrictedModeObserver = new RestrictedModeObserver(this.mContext, new NetworkPolicyManagerService$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L19
        this.mRestrictedNetworkingMode = this.mRestrictedModeObserver.isRestrictedModeEnabled();     // Catch: Throwable -> L19
        this.mSystemReady = true;     // Catch: Throwable -> L19
        waitForAdminData();     // Catch: Throwable -> L19
        readPolicyAL();     // Catch: Throwable -> L19
        this.mRestrictBackgroundBeforeBsm = this.mLoadedRestrictBackground;     // Catch: Throwable -> L19
        this.mRestrictBackgroundLowPowerMode = this.mPowerManagerInternal.getLowPowerState(10).batterySaverEnabled;     // Catch: Throwable -> L19
        if (this.mRestrictBackgroundLowPowerMode == true) goto L17;
    L21:
        this.mPowerManagerInternal.registerLowPowerModeObserver(new AnonymousClass2(this));     // Catch: Throwable -> L19
        if (addDefaultRestrictBackgroundAllowlistUidsUL() == false) goto L24;
        writePolicyAL();     // Catch: Throwable -> L19
    L24:
        enableFirewallChainUL(6, true);     // Catch: Throwable -> L19
        setRestrictBackgroundUL(this.mRestrictBackground, "init_service");     // Catch: Throwable -> L19
        if (this.mRestrictBackground == true) goto L32;
        if (this.mRestrictPower == true) goto L32;
        if (this.mDeviceIdleMode == true) goto L32;
        updateRulesForAppIdleUL();     // Catch: Throwable -> L19
    L33:
        monitor-exit(r7);     // Catch: Throwable -> L19
        monitor-exit(r6);     // Catch: Throwable -> L49
        this.mActivityManagerInternal.registerNetworkPolicyUidObserver(this.mUidObserver, 35, -1, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L8 RemoteException -> L38
        this.mNetworkManager.registerObserver(this.mAlertObserver);     // Catch: Throwable -> L8 RemoteException -> L38
    L39:
        IntentFilter allowlistFilter = new IntentFilter("android.os.action.POWER_SAVE_WHITELIST_CHANGED");     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mPowerSaveAllowlistReceiver, allowlistFilter, null, this.mHandler);     // Catch: Throwable -> L8
        IntentFilter connFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mConnReceiver, connFilter, "android.permission.NETWORK_STACK", this.mHandler);     // Catch: Throwable -> L8
        IntentFilter packageFilter = new IntentFilter();     // Catch: Throwable -> L8
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");     // Catch: Throwable -> L8
        packageFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);     // Catch: Throwable -> L8
        this.mContext.registerReceiverForAllUsers(this.mPackageReceiver, packageFilter, null, this.mHandler);     // Catch: Throwable -> L8
        this.mContext.registerReceiverForAllUsers(this.mUidRemovedReceiver, new IntentFilter("android.intent.action.UID_REMOVED"), null, this.mHandler);     // Catch: Throwable -> L8
        IntentFilter userFilter = new IntentFilter();     // Catch: Throwable -> L8
        userFilter.addAction("android.intent.action.USER_ADDED");     // Catch: Throwable -> L8
        userFilter.addAction("android.intent.action.USER_REMOVED");     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mUserReceiver, userFilter, null, this.mHandler);     // Catch: Throwable -> L8
        Executor executor = new HandlerExecutor(this.mHandler);     // Catch: Throwable -> L8
        this.mNetworkStats.registerUsageCallback(new NetworkTemplate.Builder(1).build(), 0, executor, this.mStatsCallback);     // Catch: Throwable -> L8
        this.mNetworkStats.registerUsageCallback(new NetworkTemplate.Builder(4).build(), 0, executor, this.mStatsCallback);     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mSnoozeReceiver, new IntentFilter(ACTION_SNOOZE_WARNING), "android.permission.MANAGE_NETWORK_POLICY", this.mHandler);     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mSnoozeReceiver, new IntentFilter(ACTION_SNOOZE_RAPID), "android.permission.MANAGE_NETWORK_POLICY", this.mHandler);     // Catch: Throwable -> L8
        IntentFilter wifiFilter = new IntentFilter("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mWifiReceiver, wifiFilter, null, this.mHandler);     // Catch: Throwable -> L8
        IntentFilter carrierConfigFilter = new IntentFilter("android.telephony.action.CARRIER_CONFIG_CHANGED");     // Catch: Throwable -> L8
        this.mContext.registerReceiver(this.mCarrierConfigReceiver, carrierConfigFilter, null, this.mHandler);     // Catch: Throwable -> L8
        this.mConnManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.mNetworkCallback);     // Catch: Throwable -> L8
        this.mAppStandby.addListener(new NetPolicyAppIdleStateChangeListener(this, null));     // Catch: Throwable -> L8
        Object r9 = this.mUidRulesFirstLock;     // Catch: Throwable -> L8
        monitor-enter(r9);     // Catch: Throwable -> L8
        updateRulesForAppIdleParoleUL();     // Catch: Throwable -> L46
        monitor-exit(r9);     // Catch: Throwable -> L46
        ((SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class)).addOnSubscriptionsChangedListener(new HandlerExecutor(this.mHandler), new AnonymousClass3(this));     // Catch: Throwable -> L8
        getSmtEx().registerReceiver(this.mContext);     // Catch: Throwable -> L8
        ((TelephonyManager) this.mContext.getSystemService(TelephonyManager.class)).registerTelephonyCallback(executor, this.mActiveDataSubIdListener);     // Catch: Throwable -> L8
        initCompleteSignal.countDown();     // Catch: Throwable -> L8
        Process.setThreadPriority(oldPriority);
        Trace.traceEnd(2097152);
        return;
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L32:
        updateRulesForGlobalChangeAL(false);     // Catch: Throwable -> L19
        getSmtEx().updateWarningDialogLocked(this.mClock, this.mNetworkPolicy, this.mOverLimitNotified);     // Catch: Throwable -> L19
        goto L33
    L17:
        if (this.mLoadedRestrictBackground == true) goto L21;
        this.mLoadedRestrictBackground = true;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Process.setThreadPriority(oldPriority);
        Trace.traceEnd(2097152);
        throw th;
    }

    private /* synthetic */ void lambda$initService$0(boolean enabled) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        this.mRestrictedNetworkingMode = enabled;     // Catch: Throwable -> L7
        updateRestrictedModeAllowlistUL();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public CountDownLatch networkScoreAndNetworkManagementServiceReady() {
        this.mNetworkManagerReady = true;
        final CountDownLatch initCompleteSignal = new CountDownLatch(1);
        this.mHandler.post(new NetworkPolicyManagerService$$ExternalSyntheticLambda0(this, initCompleteSignal));
        return initCompleteSignal;
    }

    private /* synthetic */ void lambda$networkScoreAndNetworkManagementServiceReady$1(CountDownLatch initCompleteSignal) {
        initService(initCompleteSignal);
    }

    public void systemReady(CountDownLatch initCompleteSignal) {
    L6:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new IllegalStateException("Service NetworkPolicy init interrupted", e);
    L3:
        if (initCompleteSignal.await(30, TimeUnit.SECONDS) == false) goto L9;
        this.mMultipathPolicyTracker.start();     // Catch: InterruptedException -> L6
        return;
    L9:
        throw new IllegalStateException("Service NetworkPolicy init timeout");     // Catch: InterruptedException -> L6
    }

    private static boolean updateCapabilityChange(SparseBooleanArray lastValues, boolean newValue, Network network) {
        boolean changed = false;
        boolean lastValue = lastValues.get(network.getNetId(), false);
        if (lastValue == newValue) goto L5;
    L6:
        changed = true;
    L7:
        if (changed == false) goto L9;
        lastValues.put(network.getNetId(), newValue);
    L9:
        return changed;
    L5:
        if (lastValues.indexOfKey(network.getNetId()) >= 0) goto L7;
        goto L6
    }

    private boolean updateNetworkToIfacesNL(int netId, ArraySet<String> newIfaces) {
        ArraySet<String> lastIfaces = this.mNetworkToIfaces.get(netId);
        boolean changed = true;
        if (lastIfaces != null) goto L6;
    L9:
        if (changed == false) goto L14;
        this.mNetworkToIfaces.remove(netId);
        Iterator<String> r2 = newIfaces.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        String iface = r2.next();
        this.mNetworkToIfaces.add(netId, iface);
    L14:
        return changed;
    L6:
        if (lastIfaces.equals(newIfaces) == false) goto L9;
        changed = false;
        goto L9
    }

    void updateNotificationsNL() {
        getSmtEx().updateWarningDialogLocked(this.mClock, this.mNetworkPolicy, this.mOverLimitNotified);
    }

    private ApplicationInfo findRapidBlame(NetworkTemplate template, long start, long end) {
        if (this.mStatsCallback.isAnyCallbackReceived() == true) goto L5;
        return null;
    L5:
        List<NetworkStats.Bucket> stats = this.mDeps.getNetworkUidBytes(template, start, end);
        Iterator<NetworkStats.Bucket> r7 = stats.iterator();
        int maxUid = 0;
        long maxBytes = 0;
        long totalBytes = 0;
    L7:
        if (r7.hasNext() == false) goto L13;
        NetworkStats.Bucket entry = r7.next();
        long bytes = entry.getRxBytes() + entry.getTxBytes();
        totalBytes = totalBytes + bytes;
        if (bytes <= maxBytes) goto L7;
        maxBytes = bytes;
        maxUid = entry.getUid();
        goto L7
    L13:
        if (maxBytes > 0) goto L15;
    L23:
        return null;
    L15:
        if (maxBytes <= (totalBytes / 2)) goto L23;
        String[] packageNames = this.mContext.getPackageManager().getPackagesForUid(maxUid);
        if (packageNames == null) goto L23;
        if (packageNames.length != 1) goto L23;
        return this.mContext.getPackageManager().getApplicationInfo(packageNames[0], 4989440);
    }

    protected int findRelevantSubIdNL(NetworkTemplate template) {
        int i = 0;
    L4:
        if (i >= this.mSubIdToSubscriberId.size()) goto L9;
        int subId = this.mSubIdToSubscriberId.keyAt(i);
        String subscriberId = this.mSubIdToSubscriberId.valueAt(i);
        NetworkIdentity probeIdent = new NetworkIdentity.Builder().setType(0).setSubscriberId(subscriberId).setMetered(true).setDefaultNetwork(true).setSubId(subId).build();
        if (template.matches(probeIdent) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return subId;
    L9:
        return -1;
    }

    private void notifyOverLimitNL(NetworkTemplate template) {
        if (this.mOverLimitNotified.contains(template) == true) goto L6;
        this.mOverLimitNotified.add(template);
        return;
    }

    private void notifyUnderLimitNL(NetworkTemplate template) {
        this.mOverLimitNotified.remove(template);
    }

    private void enqueueNotification(NetworkPolicy policy, int type, long totalBytes, ApplicationInfo rapidBlame) {
        NotificationId notificationId = new NotificationId(policy, type);
        Notification.Builder builder = new Notification.Builder(this.mContext, "NETWORK_ALERTS");
        builder.setOnlyAlertOnce(true);
        builder.setWhen(0);
        builder.setColor(this.mContext.getColor(R.color.system_notification_accent_color));
        Resources res = this.mContext.getResources();
        switch(type) {
            case 34: goto L22;
            case 35: goto L17;
            case 36: goto L11;
            case 45: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        CharSequence title = res.getText(R.string.display_manager_overlay_display_secure_suffix);
        if (rapidBlame == null) goto L8;
        CharSequence body = res.getString(R.string.display_manager_hdmi_display_name, new Object[]{rapidBlame.loadLabel(this.mContext.getPackageManager())});
    L9:
        builder.setSmallIcon(R.drawable.stat_notify_error);
        Intent snoozeIntent = buildSnoozeRapidIntent(policy.template, this.mContext.getPackageName());
        builder.setDeleteIntent(PendingIntent.getBroadcast(this.mContext, 0, snoozeIntent, AudioFormat.DTS_HD));
        Intent viewIntent = buildViewDataUsageIntent(res, policy.template);
        setContentIntent(builder, viewIntent);
    L23:
        builder.setTicker(title);
        builder.setContentTitle(title);
        builder.setContentText(body);
        builder.setStyle(new Notification.BigTextStyle().bigText(body));
        ((NotificationManager) this.mContext.getSystemService(NotificationManager.class)).notifyAsUser(notificationId.getTag(), notificationId.getId(), builder.build(), UserHandle.ALL);
        this.mActiveNotifs.add(notificationId);
        return;
    L8:
        body = res.getString(R.string.display_manager_overlay_display_name);
        goto L9
    L22:
        title = res.getText(R.string.dlg_ok);
        body = res.getString(R.string.display_rotation_camera_compat_toast_in_multi_window, new Object[]{Formatter.formatFileSize(this.mContext, totalBytes, 8)});
        builder.setSmallIcon(R.drawable.stat_notify_error);
        Intent snoozeIntent2 = buildSnoozeWarningIntent(policy.template, this.mContext.getPackageName());
        builder.setDeleteIntent(PendingIntent.getBroadcast(this.mContext, 0, snoozeIntent2, AudioFormat.DTS_HD));
        Intent viewIntent2 = buildViewDataUsageIntent(res, policy.template);
        setContentIntent(builder, viewIntent2);
        goto L23
    L11:
        switch(policy.template.getMatchRule()) {
            case 1: goto L14;
            case 4: goto L13;
            case 10: goto L14;
            default: goto L12;
        };
    L12:
        return;
    L13:
        CharSequence title2 = res.getText(R.string.done_accessibility_shortcut_menu_button);
    L15:
        long overBytes = totalBytes - policy.limitBytes;
        CharSequence body2 = res.getString(R.string.disable_accessibility_shortcut, new Object[]{Formatter.formatFileSize(this.mContext, overBytes, 8)});
        builder.setOngoing(true);
        builder.setSmallIcon(R.drawable.stat_notify_error);
        builder.setChannelId("NETWORK_STATUS");
        Intent intent = buildViewDataUsageIntent(res, policy.template);
        setContentIntent(builder, intent);
        title = title2;
        body = body2;
        goto L23
    L14:
        title2 = res.getText(R.string.dismiss_action);
        goto L15
    L17:
        switch(policy.template.getMatchRule()) {
            case 1: goto L20;
            case 4: goto L19;
            case 10: goto L20;
            default: goto L18;
        };
    L18:
        return;
    L19:
        CharSequence title3 = res.getText(R.string.done_label);
    L21:
        CharSequence body3 = res.getText(R.string.dial_number_using);
        builder.setOngoing(true);
        builder.setSmallIcon(17305165);
        getSmtEx();
        Intent intent2 = NetworkPolicyManagerServiceSmtEx.buildNetworkOverLimitIntent(policy.template, 0, 1);
        setContentIntent(builder, intent2);
        title = title3;
        body = body3;
        goto L23
    L20:
        title3 = res.getText(R.string.display_manager_built_in_display_name);
        goto L21
    }

    private void setContentIntent(Notification.Builder builder, Intent intent) {
        if (UserManager.isHeadlessSystemUserMode() == false) goto L5;
        builder.setContentIntent(PendingIntent.getActivityAsUser(this.mContext, 0, intent, AudioFormat.DTS_HD, null, UserHandle.CURRENT));
        return;
    L5:
        builder.setContentIntent(PendingIntent.getActivity(this.mContext, 0, intent, AudioFormat.DTS_HD));
    }

    private void cancelNotification(NotificationId notificationId) {
        ((NotificationManager) this.mContext.getSystemService(NotificationManager.class)).cancel(notificationId.getTag(), notificationId.getId());
    }

    private void updateNetworksInternal() {
        updateSubscriptions();
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        Object r1 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L10
        monitor-enter(r1);     // Catch: Throwable -> L10
        ensureActiveCarrierPolicyAL();     // Catch: Throwable -> L12
        normalizePoliciesNL();     // Catch: Throwable -> L12
        updateNetworkEnabledNL();     // Catch: Throwable -> L12
        updateNetworkRulesNL();     // Catch: Throwable -> L12
        updateNotificationsNL();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void updateNetworks() throws InterruptedException {
        updateNetworksInternal();
        final CountDownLatch latch = new CountDownLatch(1);
        this.mHandler.post(new NetworkPolicyManagerService$$ExternalSyntheticLambda5(latch));
        latch.await(5, TimeUnit.SECONDS);
    }

    private static /* synthetic */ void lambda$updateNetworks$2(CountDownLatch latch) {
        latch.countDown();
    }

    Handler getHandlerForTesting() {
        return this.mHandler;
    }

    private boolean maybeUpdateCarrierPolicyCycleAL(int subId, String subscriberId) {
        if (LOGV == false) goto L5;
        Slog.v(TAG, "maybeUpdateCarrierPolicyCycleAL()");
    L5:
        boolean policyUpdated = false;
        NetworkIdentity probeIdent = new NetworkIdentity.Builder().setType(0).setSubscriberId(subscriberId).setMetered(true).setDefaultNetwork(true).setSubId(subId).build();
        int i = this.mNetworkPolicy.size() - 1;
    L6:
        if (i < 0) goto L12;
        NetworkTemplate template = this.mNetworkPolicy.keyAt(i);
        if (template.matches(probeIdent) == false) goto L10;
        NetworkPolicy policy = this.mNetworkPolicy.valueAt(i);
        policyUpdated = policyUpdated | updateDefaultCarrierPolicyAL(subId, policy);
    L10:
        i = i - 1;
        goto L6
    L12:
        return policyUpdated;
    }

    int getCycleDayFromCarrierConfig(PersistableBundle config, int fallbackCycleDay) {
        if (config != null) goto L4;
        return fallbackCycleDay;
    L4:
        int cycleDay = config.getInt("monthly_data_cycle_day_int");
        if (cycleDay != (-1)) goto L7;
        return fallbackCycleDay;
    L7:
        Calendar cal = Calendar.getInstance();
        if (cycleDay >= cal.getMinimum(5)) goto L10;
    L13:
        Slog.e(TAG, "Invalid date in CarrierConfigManager.KEY_MONTHLY_DATA_CYCLE_DAY_INT: " + cycleDay);
        return fallbackCycleDay;
    L10:
        if (cycleDay > cal.getMaximum(5)) goto L13;
        return cycleDay;
    }

    long getWarningBytesFromCarrierConfig(PersistableBundle config, long fallbackWarningBytes) {
        if (config != null) goto L4;
        return fallbackWarningBytes;
    L4:
        long warningBytes = config.getLong("data_warning_threshold_bytes_long");
        if (warningBytes != (-2)) goto L8;
        return -1;
    L8:
        if (warningBytes != (-1)) goto L12;
        return getPlatformDefaultWarningBytes();
    L12:
        if (warningBytes >= 0) goto L15;
        Slog.e(TAG, "Invalid value in CarrierConfigManager.KEY_DATA_WARNING_THRESHOLD_BYTES_LONG; expected a non-negative value but got: " + warningBytes);
        return fallbackWarningBytes;
    L15:
        return warningBytes;
    }

    long getLimitBytesFromCarrierConfig(PersistableBundle config, long fallbackLimitBytes) {
        if (config != null) goto L4;
        return fallbackLimitBytes;
    L4:
        long limitBytes = config.getLong("data_limit_threshold_bytes_long");
        if (limitBytes != (-2)) goto L8;
        return -1;
    L8:
        if (limitBytes != (-1)) goto L12;
        return getPlatformDefaultLimitBytes();
    L12:
        if (limitBytes >= 0) goto L15;
        Slog.e(TAG, "Invalid value in CarrierConfigManager.KEY_DATA_LIMIT_THRESHOLD_BYTES_LONG; expected a non-negative value but got: " + limitBytes);
        return fallbackLimitBytes;
    L15:
        return limitBytes;
    }

    void handleNetworkPoliciesUpdateAL(boolean shouldNormalizePolicies) {
        if (shouldNormalizePolicies == false) goto L4;
        normalizePoliciesNL();
    L4:
        updateNetworkEnabledNL();
        updateNetworkRulesNL();
        updateNotificationsNL();
        writePolicyAL();
    }

    void updateNetworkEnabledNL() {
        if (LOGV == false) goto L5;
        Slog.v(TAG, "updateNetworkEnabledNL()");
    L5:
        getSmtEx().updateNetworkEnabledNL(this.mNetworkPolicy);
    }

    protected void setNetworkTemplateEnabled(NetworkTemplate r4, boolean r5) {
        this.mHandler.obtainMessage(18, r5 ? 1 : 0, 0, r4).sendToTarget();
    }

    private void setNetworkTemplateEnabledInner(NetworkTemplate template, boolean enabled) {
        if (template.getMatchRule() != 1) goto L5;
    L6:
        IntArray matchingSubIds = new IntArray();
        Object r2 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r2);
        int i = 0;
    L26:
    L14:
        th = move-exception;
        throw th;
    L10:
        if (i >= this.mSubIdToSubscriberId.size()) goto L18;
        int subId = this.mSubIdToSubscriberId.keyAt(i);     // Catch: Throwable -> L14
        String subscriberId = this.mSubIdToSubscriberId.valueAt(i);     // Catch: Throwable -> L14
        NetworkIdentity probeIdent = new NetworkIdentity.Builder().setType(0).setSubscriberId(subscriberId).setMetered(true).setDefaultNetwork(true).setSubId(subId).build();     // Catch: Throwable -> L14
        if (template.matches(probeIdent) == false) goto L16;
        matchingSubIds.add(subId);     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L26
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L14
        TelephonyManager tm = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        int i2 = 0;
    L21:
        if (i2 >= matchingSubIds.size()) goto L32;
        tm.createForSubscriptionId(matchingSubIds.get(i2)).setPolicyDataEnabled(enabled);
        i2 = i2 + 1;
        goto L21
    L32:
        return;
    L5:
        if (template.getMatchRule() == 10) goto L6;
    }

    private static void collectIfaces(ArraySet<String> ifaces, NetworkStateSnapshot snapshot) {
        ifaces.addAll(snapshot.getLinkProperties().getAllInterfaceNames());
    }

    void updateSubscriptions() {
        if (LOGV == false) goto L5;
        Slog.v(TAG, "updateSubscriptions()");
    L5:
        long r2 = 2097152;
        Trace.traceBegin(2097152, "updateSubscriptions");
        TelephonyManager tm = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        SubscriptionManager sm = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        List<SubscriptionInfo> subList = CollectionUtils.emptyIfNull(sm.getActiveSubscriptionInfoList());
        List<String[]> mergedSubscriberIdsList = new ArrayList();
        SparseArray<String> subIdToSubscriberId = new SparseArray(subList.size());
        SparseArray<PersistableBundle> subIdToCarrierConfig = new SparseArray();
        Iterator<SubscriptionInfo> r0 = subList.iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        SubscriptionInfo sub = r0.next();
        int subId = sub.getSubscriptionId();
        TelephonyManager tmSub = tm.createForSubscriptionId(subId);
        String subscriberId = tmSub.getSubscriberId();
        if (TextUtils.isEmpty(subscriberId) == true) goto L11;
        subIdToSubscriberId.put(tmSub.getSubscriptionId(), subscriberId);
    L12:
        String[] mergedSubscriberId = ArrayUtils.defeatNullable(tmSub.getMergedImsisFromGroup());
        mergedSubscriberIdsList.add(mergedSubscriberId);
        PersistableBundle config = this.mCarrierConfigManager.getConfigForSubId(subId);
        if (config == null) goto L15;
        subIdToCarrierConfig.put(subId, config);
    L16:
        r2 = r2;
        r0 = r0;
        goto L7
    L15:
        Slog.e(TAG, "Missing CarrierConfig for subId " + subId);
        goto L16
    L11:
        Slog.wtf(TAG, "Missing subscriberId for subId " + tmSub.getSubscriptionId());
        goto L12
    L17:
        long r16 = r2;
        Object r3 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r3);
        this.mSubIdToSubscriberId.clear();     // Catch: Throwable -> L23
        int i = 0;
    L21:
        if (i >= subIdToSubscriberId.size()) goto L25;
        this.mSubIdToSubscriberId.put(subIdToSubscriberId.keyAt(i), subIdToSubscriberId.valueAt(i));     // Catch: Throwable -> L23
        i = i + 1;     // Catch: Throwable -> L23
        goto L21
    L25:
        this.mMergedSubscriberIds = mergedSubscriberIdsList;     // Catch: Throwable -> L23
        this.mSubIdToCarrierConfig.clear();     // Catch: Throwable -> L23
        int i2 = 0;
    L27:
        if (i2 >= subIdToCarrierConfig.size()) goto L30;
        this.mSubIdToCarrierConfig.put(subIdToCarrierConfig.keyAt(i2), subIdToCarrierConfig.valueAt(i2));     // Catch: Throwable -> L23
        i2 = i2 + 1;     // Catch: Throwable -> L23
        goto L27
    L30:
        monitor-exit(r3);     // Catch: Throwable -> L23
        Trace.traceEnd(r16);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    void updateNetworkRulesNL() {
        NetworkPolicyManagerService r1 = this;
        if (LOGV == false) goto L5;
        Slog.v(TAG, "updateNetworkRulesNL()");
    L5:
        long r7 = 2097152;
        Trace.traceBegin(2097152, "updateNetworkRulesNL");
        List<NetworkStateSnapshot> snapshots = r1.mConnManager.getAllNetworkStateSnapshots();
        r1.mNetIdToSubId.clear();
        ArrayMap<NetworkStateSnapshot, NetworkIdentity> identified = new ArrayMap();
        Iterator<NetworkStateSnapshot> r0 = snapshots.iterator();
    L6:
        int r11 = 1;
        if (r0.hasNext() == false) goto L9;
        NetworkStateSnapshot snapshot = r0.next();
        r1.mNetIdToSubId.put(snapshot.getNetwork().getNetId(), snapshot.getSubId());
        NetworkIdentity ident = new NetworkIdentity.Builder().setNetworkStateSnapshot(snapshot).setDefaultNetwork(true).build();
        identified.put(snapshot, ident);
        goto L6
    L9:
        ArraySet<String> newMeteredIfaces = new ArraySet();
        ArraySet<String> matchingIfaces = new ArraySet();
        int i = r1.mNetworkPolicy.size() - 1;
        long lowestRule = Long.MAX_VALUE;
    L10:
        int r16 = 0;
        if (i < 0) goto L69;
        NetworkPolicy policy = r1.mNetworkPolicy.valueAt(i);
        matchingIfaces.clear();
        int j = identified.size() - r11;
    L13:
        if (j < 0) goto L19;
        if (policy.template.matches(identified.valueAt(j)) == false) goto L17;
        collectIfaces(matchingIfaces, identified.keyAt(j));
    L17:
        j = j - 1;
        goto L13
    L19:
        if (LOGD == false) goto L22;
        Slog.d(TAG, "Applying " + policy + " to ifaces " + matchingIfaces);
    L22:
        if (policy.warningBytes == (-1)) goto L24;
        int r2 = r11;
    L25:
        int r19 = r2;
        if (policy.limitBytes == (-1)) goto L28;
        r16 = r11;
    L28:
        long limitBytes = Long.MAX_VALUE;
        if (r16 != 0) goto L34;
        if (r19 != 0) goto L34;
    L49:
        long limitBytes2 = Long.MAX_VALUE;
        long warningBytes = Long.MAX_VALUE;
    L50:
        if (r19 != 0) goto L55;
        if (r16 != 0) goto L55;
        if (policy.metered == true) goto L55;
    L60:
        if (r19 != 0) goto L62;
    L64:
        if (r16 == 0) goto L68;
        if (policy.limitBytes >= lowestRule) goto L68;
        lowestRule = policy.limitBytes;
    L68:
        i = i - 1;
        r11 = 1;
        r1 = this;
        r7 = r7;
        goto L10
    L62:
        if (policy.warningBytes >= lowestRule) goto L64;
        lowestRule = policy.warningBytes;
    L55:
        if (matchingIfaces.size() <= 1) goto L57;
        Slog.w(TAG, "shared quota unsupported; generating rule for each iface");
    L57:
        int j2 = matchingIfaces.size() - 1;
    L58:
        if (j2 < 0) goto L60;
        String iface = matchingIfaces.valueAt(j2);
        setInterfaceQuotasAsync(iface, warningBytes, limitBytes2);
        newMeteredIfaces.add(iface);
        j2 = j2 - 1;
    L34:
        if (policy.hasCycle() == false) goto L49;
        Pair<ZonedDateTime, ZonedDateTime> cycle = (Pair) NetworkPolicyManager.cycleIterator(policy).next();
        long start = ((ZonedDateTime) cycle.first).toInstant().toEpochMilli();
        long end = ((ZonedDateTime) cycle.second).toInstant().toEpochMilli();
        policy = policy;
        r7 = r7;
        long totalBytes = r1.getTotalBytes(policy.template, start, end);
        if (r16 == 0) goto L41;
        if (policy.lastLimitSnooze >= start) goto L41;
        limitBytes = Math.max(1, policy.limitBytes - totalBytes);
    L41:
        if (r19 != 0) goto L43;
    L47:
        limitBytes2 = limitBytes;
        warningBytes = Long.MAX_VALUE;
        goto L50
    L43:
        if (policy.lastWarningSnooze >= start) goto L47;
        if (policy.isOverWarning(totalBytes) == true) goto L47;
        long warningBytes2 = Math.max(1, policy.warningBytes - totalBytes);
        limitBytes2 = limitBytes;
        warningBytes = warningBytes2;
        goto L50
    L24:
        r2 = 0;
        goto L25
    L69:
        long r26 = r7;
        Iterator<NetworkStateSnapshot> r3 = snapshots.iterator();
    L71:
        if (r3.hasNext() == false) goto L84;
        NetworkStateSnapshot snapshot2 = r3.next();
        if (snapshot2.getNetworkCapabilities().hasCapability(11) == true) goto L71;
        matchingIfaces.clear();
        collectIfaces(matchingIfaces, snapshot2);
        int j3 = matchingIfaces.size() - 1;
    L75:
        if (j3 < 0) goto L71;
        String iface2 = matchingIfaces.valueAt(j3);
        if (newMeteredIfaces.contains(iface2) == true) goto L80;
        setInterfaceQuotasAsync(iface2, Long.MAX_VALUE, Long.MAX_VALUE);
        newMeteredIfaces.add(iface2);
    L80:
        j3 = j3 - 1;
        goto L75
    L84:
        Object r4 = this.mMeteredIfacesLock;
        monitor-enter(r4);
        int i2 = this.mMeteredIfaces.size() - 1;     // Catch: Throwable -> L91
    L87:
        if (i2 < 0) goto L94;
        String iface3 = this.mMeteredIfaces.valueAt(i2);     // Catch: Throwable -> L91
        if (newMeteredIfaces.contains(iface3) == true) goto L93;
        removeInterfaceQuotasAsync(iface3);     // Catch: Throwable -> L91
    L93:
        i2 = i2 - 1;     // Catch: Throwable -> L91
        goto L87
    L94:
        this.mMeteredIfaces = newMeteredIfaces;     // Catch: Throwable -> L91
        monitor-exit(r4);     // Catch: Throwable -> L91
        ContentResolver cr = this.mContext.getContentResolver();
        if (Settings.Global.getInt(cr, "netpolicy_quota_enabled", 1) == 0) goto L99;
        boolean quotaEnabled = true;
    L100:
        long quotaUnlimited = Settings.Global.getLong(cr, "netpolicy_quota_unlimited", QUOTA_UNLIMITED_DEFAULT);
        float quotaLimited = Settings.Global.getFloat(cr, "netpolicy_quota_limited", QUOTA_LIMITED_DEFAULT);
        this.mSubscriptionOpportunisticQuota.clear();
        Iterator<NetworkStateSnapshot> r5 = snapshots.iterator();
    L102:
        if (r5.hasNext() == false) goto L130;
        NetworkStateSnapshot snapshot3 = r5.next();
        if (quotaEnabled == false) goto L102;
        if (snapshot3.getNetwork() == null) goto L102;
        int subId = getSubIdLocked(snapshot3.getNetwork());
        if (subId == (-1)) goto L102;
        SubscriptionPlan plan = getPrimarySubscriptionPlanLocked(subId);
        if (plan == null) goto L102;
        long limitBytes3 = plan.getDataLimitBytes();
        if (snapshot3.getNetworkCapabilities().hasCapability(18) == true) goto L119;
        long quotaBytes = 0;
        int subId2 = subId;
        float quotaLimited2 = quotaLimited;
    L129:
        this.mSubscriptionOpportunisticQuota.put(subId2, quotaBytes);
        r5 = r5;
        cr = cr;
        quotaLimited = quotaLimited2;
        goto L102
    L119:
        if (limitBytes3 != (-1)) goto L122;
        quotaBytes = -1;
        subId2 = subId;
        quotaLimited2 = quotaLimited;
        goto L129
    L122:
        if (limitBytes3 != Long.MAX_VALUE) goto L124;
        quotaBytes = quotaUnlimited;
        subId2 = subId;
        quotaLimited2 = quotaLimited;
        goto L129
    L124:
        Range<ZonedDateTime> cycle2 = plan.cycleIterator().next();
        long start2 = ((ZonedDateTime) cycle2.getLower()).toInstant().toEpochMilli();
        long end2 = ((ZonedDateTime) cycle2.getUpper()).toInstant().toEpochMilli();
        Instant now = this.mClock.instant();
        long startOfDay = ZonedDateTime.ofInstant(now, ((ZonedDateTime) cycle2.getLower()).getZone()).truncatedTo(ChronoUnit.DAYS).toInstant().toEpochMilli();
        String subscriberId = snapshot3.getSubscriberId();
        quotaLimited2 = quotaLimited;
        if (subscriberId != null) goto L127;
        subId2 = subId;
        long totalBytes2 = 0;
    L128:
        long remainingBytes = limitBytes3 - totalBytes2;
        long remainingDays = (((end2 - now.toEpochMilli()) - 1) / TimeUnit.DAYS.toMillis(1)) + 1;
        quotaBytes = Math.max(0, (long) ((remainingBytes / remainingDays) * quotaLimited2));
        goto L129
    L127:
        subId2 = subId;
        totalBytes2 = getTotalBytes(buildTemplateCarrierMetered(subscriberId), start2, startOfDay);
        goto L128
    L130:
        Object r6 = this.mMeteredIfacesLock;
        monitor-enter(r6);
        String[] meteredIfaces = (String[]) this.mMeteredIfaces.toArray(new String[this.mMeteredIfaces.size()]);     // Catch: Throwable -> L136
        monitor-exit(r6);     // Catch: Throwable -> L136
        this.mHandler.obtainMessage(2, meteredIfaces).sendToTarget();
        this.mHandler.obtainMessage(7, Long.valueOf(lowestRule)).sendToTarget();
        Trace.traceEnd(r26);
        return;
    L136:
        th = move-exception;
        throw th;
    L99:
        quotaEnabled = false;
    L91:
        th = move-exception;
        throw th;
    }

    private void ensureActiveCarrierPolicyAL() {
        if (LOGV == false) goto L6;
        Slog.v(TAG, "ensureActiveCarrierPolicyAL()");
    L6:
        if (this.mSuppressDefaultPolicy == false) goto L8;
        return;
    L8:
        int i = 0;
    L10:
        if (i >= this.mSubIdToSubscriberId.size()) goto L13;
        int subId = this.mSubIdToSubscriberId.keyAt(i);
        String subscriberId = this.mSubIdToSubscriberId.valueAt(i);
        ensureActiveCarrierPolicyAL(subId, subscriberId);
        i = i + 1;
        goto L10
    }

    private boolean ensureActiveCarrierPolicyAL(int subId, String subscriberId) {
        NetworkIdentity probeIdent = new NetworkIdentity.Builder().setType(0).setSubscriberId(subscriberId).setMetered(true).setDefaultNetwork(true).setSubId(subId).build();
        int i = this.mNetworkPolicy.size() - 1;
    L4:
        if (i < 0) goto L12;
        NetworkTemplate template = this.mNetworkPolicy.keyAt(i);
        if (template.matches(probeIdent) == true) goto L8;
        i = i - 1;
        goto L4
    L8:
        if (LOGD == false) goto L10;
        Slog.d(TAG, "Found template " + template + " which matches subscriber " + NetworkIdentityUtils.scrubSubscriberId(subscriberId));
    L10:
        return false;
    L12:
        Slog.i(TAG, "No policy for subscriber " + NetworkIdentityUtils.scrubSubscriberId(subscriberId) + "; generating default policy");
        NetworkPolicy policy = buildDefaultCarrierPolicy(subId, subscriberId);
        addNetworkPolicyAL(policy);
        return true;
    }

    private long getPlatformDefaultWarningBytes() {
        int dataWarningConfig = this.mContext.getResources().getInteger(R.integer.config_notificationsBatteryLowBehavior);
        if (dataWarningConfig != (-1)) goto L6;
        return -1;
    L6:
        return DataUnit.MEBIBYTES.toBytes(dataWarningConfig);
    }

    private long getPlatformDefaultLimitBytes() {
        return -1;
    }

    NetworkPolicy buildDefaultCarrierPolicy(int subId, String subscriberId) {
        NetworkTemplate template = buildTemplateCarrierMetered(subscriberId);
        RecurrenceRule cycleRule = NetworkPolicy.buildRule(ZonedDateTime.now().getDayOfMonth(), ZoneId.systemDefault());
        NetworkPolicy policy = new NetworkPolicy(template, cycleRule, getPlatformDefaultWarningBytes(), getPlatformDefaultLimitBytes(), -1, -1, true, true);
        Object r4 = this.mUidRulesFirstLock;
        monitor-enter(r4);
        Object r5 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L10
        monitor-enter(r5);     // Catch: Throwable -> L10
        updateDefaultCarrierPolicyAL(subId, policy);     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L10
        return policy;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static NetworkTemplate buildTemplateCarrierMetered(String subscriberId) {
        subscriberId.getClass();
        return new NetworkTemplate.Builder(10).setSubscriberIds(Set.of(subscriberId)).setMeteredness(1).build();
    }

    private boolean updateDefaultCarrierPolicyAL(int subId, NetworkPolicy policy) {
        if (policy.inferred == false) goto L5;
        NetworkPolicy original = new NetworkPolicy(policy.template, policy.cycleRule, policy.warningBytes, policy.limitBytes, policy.lastWarningSnooze, policy.lastLimitSnooze, policy.metered, policy.inferred);
        SubscriptionPlan[] plans = this.mSubscriptionPlans.get(subId);
        if (ArrayUtils.isEmpty(plans) == true) goto L21;
        SubscriptionPlan plan = plans[0];
        policy.cycleRule = plan.getCycleRule();
        long planLimitBytes = plan.getDataLimitBytes();
        if (planLimitBytes != (-1)) goto L14;
        policy.warningBytes = getPlatformDefaultWarningBytes();
        policy.limitBytes = getPlatformDefaultLimitBytes();
    L27:
        if (policy.equals(original) == false) goto L29;
        return false;
    L29:
        Slog.d(TAG, "Updated " + original + " to " + policy);
        return true;
    L14:
        if (planLimitBytes != Long.MAX_VALUE) goto L16;
        policy.warningBytes = -1;
        policy.limitBytes = -1;
        goto L27
    L16:
        policy.warningBytes = (9 * planLimitBytes) / 10;
        switch(plan.getDataLimitBehavior()) {
            case 0: goto L19;
            case 1: goto L19;
            default: goto L18;
        };
    L18:
        policy.limitBytes = -1;
        goto L27
    L19:
        policy.limitBytes = planLimitBytes;
        goto L27
    L21:
        PersistableBundle config = this.mSubIdToCarrierConfig.get(subId);
        if (policy.cycleRule.isMonthly() == false) goto L24;
        int currentCycleDay = policy.cycleRule.start.getDayOfMonth();
    L25:
        int cycleDay = getCycleDayFromCarrierConfig(config, currentCycleDay);
        policy.cycleRule = NetworkPolicy.buildRule(cycleDay, ZoneId.systemDefault());
        policy.warningBytes = getWarningBytesFromCarrierConfig(config, policy.warningBytes);
        policy.limitBytes = getLimitBytesFromCarrierConfig(config, policy.limitBytes);
        goto L27
    L24:
        currentCycleDay = -1;
        goto L25
    L5:
        if (LOGD == false) goto L7;
        Slog.d(TAG, "Ignoring user-defined policy " + policy);
    L7:
        return false;
    }

    private void readPolicyAL() {
        if (LOGV == false) goto L5;
        Slog.v(TAG, "readPolicyAL()");
    L5:
        this.mNetworkPolicy.clear();
        this.mSubscriptionPlans.clear();
        this.mSubscriptionPlansOwner.clear();
        this.mUidPolicy.clear();
        FileInputStream fis = null;
    L21:
        th = th;
    L152:
        IoUtils.closeQuietly(fis);
        throw th;
    L23:
        e = e;
    L146:
        Log.wtf(TAG, "problem reading network policy", e);     // Catch: Throwable -> L21
    L147:
        IoUtils.closeQuietly(fis);
        return;
    L7:
        fis = this.mPolicyFile.openRead();     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
        TypedXmlPullParser in = Xml.resolvePullParser(fis);     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        SparseBooleanArray restrictBackgroundAllowedUids = new SparseBooleanArray();     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        int version = 1;
        boolean insideAllowlist = false;
    L9:
        int type = in.next();     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        boolean r9 = false;
        if (type == 1) goto L131;
        String tag = in.getName();     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        if (type == 2) goto L15;
        FileInputStream fis2 = fis;
        insideAllowlist = insideAllowlist;
        if (type == 3) goto L127;
    L129:
        insideAllowlist = insideAllowlist;
    L130:
        fis = fis2;
        goto L9
    L127:
        if (TAG_ALLOWLIST.equals(tag) == false) goto L129;
        insideAllowlist = false;
        goto L130
    L15:
        if (TAG_POLICY_LIST.equals(tag) == false) goto L31;
        boolean r11 = this.mRestrictBackground;     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
        int version2 = XmlUtils.readIntAttribute(in, ATTR_VERSION);     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
        if (version2 >= 3) goto L19;
    L28:
        this.mLoadedRestrictBackground = r9;     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
        fis2 = fis;
        version = version2;
        goto L130
    L19:
        if (XmlUtils.readBooleanAttribute(in, ATTR_RESTRICT_BACKGROUND) == false) goto L28;
        r9 = true;
        goto L28
        goto L149
    L31:
        if (TAG_NETWORK_POLICY.equals(tag) == false) goto L97;
        int templateType = XmlUtils.readIntAttribute(in, ATTR_NETWORK_TEMPLATE);     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        String subscriberId = in.getAttributeValue(null, ATTR_SUBSCRIBER_ID);     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        if (version < 9) goto L36;
        String networkId = in.getAttributeValue(null, ATTR_NETWORK_ID);     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
    L38:
        if (version < 13) goto L41;
        int subscriberIdMatchRule = XmlUtils.readIntAttribute(in, ATTR_SUBSCRIBER_ID_MATCH_RULE);     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
        int subscriberIdMatchRule2 = XmlUtils.readIntAttribute(in, ATTR_TEMPLATE_METERED);     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
    L46:
        if (version < 11) goto L62;
        String start = XmlUtils.readStringAttribute(in, ATTR_CYCLE_START);     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        String end = XmlUtils.readStringAttribute(in, ATTR_CYCLE_END);     // Catch: Throwable -> L56 Exception -> L58 FileNotFoundException -> L60
        fis2 = fis;
        String period = XmlUtils.readStringAttribute(in, ATTR_CYCLE_PERIOD);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        RecurrenceRule cycleRule = new RecurrenceRule(RecurrenceRule.convertZonedDateTime(start), RecurrenceRule.convertZonedDateTime(end), RecurrenceRule.convertPeriod(period));     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        RecurrenceRule cycleRule2 = cycleRule;
    L67:
        long warningBytes = XmlUtils.readLongAttribute(in, ATTR_WARNING_BYTES);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        long limitBytes = XmlUtils.readLongAttribute(in, ATTR_LIMIT_BYTES);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if (version < 5) goto L71;
        long lastLimitSnooze = XmlUtils.readLongAttribute(in, ATTR_LAST_LIMIT_SNOOZE);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L75:
        if (version < 4) goto L77;
        boolean metered = XmlUtils.readBooleanAttribute(in, ATTR_METERED);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L80:
        if (version < 5) goto L82;
        long lastWarningSnooze = XmlUtils.readLongAttribute(in, ATTR_LAST_WARNING_SNOOZE);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L84:
        if (version < 7) goto L86;
        boolean inferred = XmlUtils.readBooleanAttribute(in, ATTR_INFERRED);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L87:
        NetworkTemplate.Builder builder = new NetworkTemplate.Builder(templateType).setMeteredness(subscriberIdMatchRule2);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if (subscriberIdMatchRule != 0) goto L90;
        ArraySet<String> ids = new ArraySet();     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        ids.add(subscriberId);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        builder.setSubscriberIds(ids);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L90:
        if (networkId == null) goto L92;
        builder.setWifiNetworkKeys(Set.of(networkId));     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L92:
        NetworkTemplate template = builder.build();     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if (NetworkPolicy.isTemplatePersistable(template) == false) goto L129;
        this.mNetworkPolicy.put(template, new NetworkPolicy(template, cycleRule2, warningBytes, limitBytes, lastWarningSnooze, lastLimitSnooze, metered, inferred));     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L129
    L86:
        inferred = false;
        goto L87
    L82:
        lastWarningSnooze = -1;
        goto L84
    L77:
        switch(templateType) {
            case 1: goto L79;
            default: goto L78;
        };     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L78:
        metered = false;
        goto L80
    L79:
        metered = true;
        goto L80
    L71:
        if (version < 2) goto L73;
        lastLimitSnooze = XmlUtils.readLongAttribute(in, ATTR_LAST_SNOOZE);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L75
    L73:
        lastLimitSnooze = -1;
    L52:
        e = e;
        fis = fis2;
    L50:
        th = th;
        fis = fis2;
    L55:
        fis = fis2;
        goto L149
        goto L149
    L62:
        fis2 = fis;
        int cycleDay = XmlUtils.readIntAttribute(in, ATTR_CYCLE_DAY);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if (version < 6) goto L65;
        String cycleTimezone = in.getAttributeValue(null, ATTR_CYCLE_TIMEZONE);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L66:
        cycleRule2 = NetworkPolicy.buildRule(cycleDay, ZoneId.of(cycleTimezone));     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L67
    L65:
        cycleTimezone = "UTC";
        goto L66
    L41:
        if (templateType != 1) goto L44;
        Log.d(TAG, "Update template match rule from mobile to carrier and force to metered");     // Catch: Throwable -> L21 Exception -> L23 FileNotFoundException -> L25
        templateType = 10;
        subscriberIdMatchRule2 = 1;
        subscriberIdMatchRule = 0;
        goto L46
    L44:
        subscriberIdMatchRule2 = -1;
        subscriberIdMatchRule = 0;
        goto L46
    L36:
        networkId = null;
        goto L38
    L97:
        fis2 = fis;
        insideAllowlist = insideAllowlist;
        if (TAG_UID_POLICY.equals(tag) == false) goto L106;
        int uid = XmlUtils.readIntAttribute(in, "uid");     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        int policy = XmlUtils.readIntAttribute(in, ATTR_POLICY);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if (UserHandle.isApp(uid) == false) goto L103;
        setUidPolicyUncheckedUL(uid, policy, false);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L129
    L103:
        Slog.w(TAG, "unable to apply policy to UID " + uid + "; ignoring");     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L129
    L106:
        if (TAG_APP_POLICY.equals(tag) == false) goto L113;
        int appId = XmlUtils.readIntAttribute(in, ATTR_APP_ID);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        int policy2 = XmlUtils.readIntAttribute(in, ATTR_POLICY);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        int uid2 = UserHandle.getUid(0, appId);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if (UserHandle.isApp(uid2) == false) goto L110;
        setUidPolicyUncheckedUL(uid2, policy2, false);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L129
    L110:
        Slog.w(TAG, "unable to apply policy to UID " + uid2 + "; ignoring");     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L129
    L113:
        if (TAG_ALLOWLIST.equals(tag) == false) goto L116;
        insideAllowlist = true;
        goto L130
    L116:
        if (TAG_RESTRICT_BACKGROUND.equals(tag) == false) goto L121;
        if (insideAllowlist == false) goto L121;
        restrictBackgroundAllowedUids.append(XmlUtils.readIntAttribute(in, "uid"), true);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L121:
        if (TAG_REVOKED_RESTRICT_BACKGROUND.equals(tag) == false) goto L129;
        if (insideAllowlist == false) goto L129;
        this.mRestrictBackgroundAllowlistRevokedUids.put(XmlUtils.readIntAttribute(in, "uid"), true);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L129
    L131:
        fis2 = fis;
        int size = restrictBackgroundAllowedUids.size();     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        int i = 0;
    L132:
        if (i >= size) goto L144;
        int uid3 = restrictBackgroundAllowedUids.keyAt(i);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        int policy3 = this.mUidPolicy.get(uid3, 0);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if ((policy3 & 1) == 0) goto L137;
        Slog.w(TAG, "ignoring restrict-background-allowlist for " + uid3 + " because its policy is " + NetworkPolicyManager.uidPoliciesToString(policy3));     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L143:
        i = i + 1;
        goto L132
    L137:
        if (UserHandle.isApp(uid3) == false) goto L142;
        int newPolicy = policy3 | 4;     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        if (LOGV == false) goto L141;
        Log.v(TAG, "new policy for " + uid3 + ": " + NetworkPolicyManager.uidPoliciesToString(newPolicy));     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
    L141:
        setUidPolicyUncheckedUL(uid3, newPolicy, false);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L143
    L142:
        Slog.w(TAG, "unable to update policy on UID " + uid3);     // Catch: Throwable -> L50 Exception -> L52 FileNotFoundException -> L54
        goto L143
        goto L55
    L144:
        IoUtils.closeQuietly(fis2);
        return;
    L58:
        e = e;
    L56:
        th = th;
    L149:
        upgradeDefaultBackgroundDataUL();     // Catch: Throwable -> L21
        goto L147
    }

    private void upgradeDefaultBackgroundDataUL() {
        boolean r2 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "default_restrict_background_data", 0) != 1) goto L5;
        r2 = true;
    L5:
        this.mLoadedRestrictBackground = r2;
    }

    private void upgradeWifiMeteredOverride() {
        ArrayMap<String, Boolean> wifiNetworkKeys = new ArrayMap();
        Object r1 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r1);
        int i = 0;
    L60:
    L16:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mNetworkPolicy.size()) goto L21;
        NetworkPolicy policy = this.mNetworkPolicy.valueAt(i);     // Catch: Throwable -> L16
        if (policy.template.getMatchRule() == 4) goto L10;
    L18:
        i = i + 1;     // Catch: Throwable -> L16
        goto L60
    L10:
        if (policy.inferred == true) goto L18;
        this.mNetworkPolicy.removeAt(i);     // Catch: Throwable -> L16
        Set<String> keys = policy.template.getWifiNetworkKeys();     // Catch: Throwable -> L16
        if (keys.isEmpty() == false) goto L14;
        String r5 = null;
    L15:
        wifiNetworkKeys.put(r5, Boolean.valueOf(policy.metered));     // Catch: Throwable -> L16
        goto L60
    L14:
        r5 = keys.iterator().next();     // Catch: Throwable -> L16
        goto L15
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L16
        if (wifiNetworkKeys.isEmpty() == false) goto L25;
        return;
    L25:
        WifiManager wm = (WifiManager) this.mContext.getSystemService(WifiManager.class);
        List<WifiConfiguration> configs = wm.getConfiguredNetworks();
        int i2 = 0;
    L27:
        if (i2 >= configs.size()) goto L40;
        WifiConfiguration config = configs.get(i2);
        Iterator r6 = config.getAllNetworkKeys().iterator();
    L30:
        if (r6.hasNext() == false) goto L39;
        String key = (String) r6.next();
        Boolean metered = wifiNetworkKeys.get(key);
        if (metered == null) goto L30;
        Slog.d(TAG, "Found network " + key + "; upgrading metered hint");
        if (metered.booleanValue() == false) goto L36;
        int r7 = 1;
    L37:
        config.meteredOverride = r7;
        wm.updateNetwork(config);
        goto L39
    L36:
        r7 = 2;
    L39:
        i2 = i2 + 1;
        goto L27
    L40:
        Object r4 = this.mUidRulesFirstLock;
        monitor-enter(r4);
        Object r2 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L48
        monitor-enter(r2);     // Catch: Throwable -> L48
        writePolicyAL();     // Catch: Throwable -> L50
        monitor-exit(r2);     // Catch: Throwable -> L50
        monitor-exit(r4);     // Catch: Throwable -> L48
        return;
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    void writePolicyAL() {
        if (LOGV == false) goto L5;
        Slog.v(TAG, "writePolicyAL()");
    L5:
        FileOutputStream fos = null;
        fos = this.mPolicyFile.startWrite();     // Catch: IOException -> L19
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: IOException -> L19
        int r8 = 1;
        out.startDocument(null, true);     // Catch: IOException -> L19
        out.startTag(null, TAG_POLICY_LIST);     // Catch: IOException -> L19
        XmlUtils.writeIntAttribute(out, ATTR_VERSION, 14);     // Catch: IOException -> L19
        XmlUtils.writeBooleanAttribute(out, ATTR_RESTRICT_BACKGROUND, this.mRestrictBackground);     // Catch: IOException -> L19
        int i = 0;
    L8:
        if (i >= this.mNetworkPolicy.size()) goto L30;
        NetworkPolicy policy = this.mNetworkPolicy.valueAt(i);     // Catch: IOException -> L19
        NetworkTemplate template = policy.template;     // Catch: IOException -> L19
        if (NetworkPolicy.isTemplatePersistable(template) == false) goto L29;
        out.startTag(null, TAG_NETWORK_POLICY);     // Catch: IOException -> L19
        XmlUtils.writeIntAttribute(out, ATTR_NETWORK_TEMPLATE, template.getMatchRule());     // Catch: IOException -> L19
        if (template.getSubscriberIds().isEmpty() == false) goto L15;
        String subscriberId = null;
    L17:
        if (subscriberId == null) goto L22;
        out.attribute(null, ATTR_SUBSCRIBER_ID, subscriberId);     // Catch: IOException -> L19
    L22:
        if (template.getSubscriberIds().isEmpty() == false) goto L24;
        int subscriberIdMatchRule = r8;
    L25:
        XmlUtils.writeIntAttribute(out, ATTR_SUBSCRIBER_ID_MATCH_RULE, subscriberIdMatchRule);     // Catch: IOException -> L19
        if (template.getWifiNetworkKeys().isEmpty() == true) goto L28;
        out.attribute(null, ATTR_NETWORK_ID, (String) template.getWifiNetworkKeys().iterator().next());     // Catch: IOException -> L19
    L28:
        XmlUtils.writeIntAttribute(out, ATTR_TEMPLATE_METERED, template.getMeteredness());     // Catch: IOException -> L19
        XmlUtils.writeStringAttribute(out, ATTR_CYCLE_START, RecurrenceRule.convertZonedDateTime(policy.cycleRule.start));     // Catch: IOException -> L19
        XmlUtils.writeStringAttribute(out, ATTR_CYCLE_END, RecurrenceRule.convertZonedDateTime(policy.cycleRule.end));     // Catch: IOException -> L19
        XmlUtils.writeStringAttribute(out, ATTR_CYCLE_PERIOD, RecurrenceRule.convertPeriod(policy.cycleRule.period));     // Catch: IOException -> L19
        XmlUtils.writeLongAttribute(out, ATTR_WARNING_BYTES, policy.warningBytes);     // Catch: IOException -> L19
        XmlUtils.writeLongAttribute(out, ATTR_LIMIT_BYTES, policy.limitBytes);     // Catch: IOException -> L19
        XmlUtils.writeLongAttribute(out, ATTR_LAST_WARNING_SNOOZE, policy.lastWarningSnooze);     // Catch: IOException -> L19
        XmlUtils.writeLongAttribute(out, ATTR_LAST_LIMIT_SNOOZE, policy.lastLimitSnooze);     // Catch: IOException -> L19
        XmlUtils.writeBooleanAttribute(out, ATTR_METERED, policy.metered);     // Catch: IOException -> L19
        XmlUtils.writeBooleanAttribute(out, ATTR_INFERRED, policy.inferred);     // Catch: IOException -> L19
        out.endTag(null, TAG_NETWORK_POLICY);     // Catch: IOException -> L19
        goto L29
    L24:
        subscriberIdMatchRule = 0;
        goto L25
    L15:
        subscriberId = (String) template.getSubscriberIds().iterator().next();     // Catch: IOException -> L19
    L29:
        i = i + 1;     // Catch: IOException -> L19
        r8 = 1;
        goto L8
    L30:
        int i2 = 0;
    L33:
        if (i2 >= this.mUidPolicy.size()) goto L39;
        int uid = this.mUidPolicy.keyAt(i2);     // Catch: IOException -> L19
        int policy2 = this.mUidPolicy.valueAt(i2);     // Catch: IOException -> L19
        if (policy2 == 0) goto L38;
        out.startTag(null, TAG_UID_POLICY);     // Catch: IOException -> L19
        XmlUtils.writeIntAttribute(out, "uid", uid);     // Catch: IOException -> L19
        XmlUtils.writeIntAttribute(out, ATTR_POLICY, policy2);     // Catch: IOException -> L19
        out.endTag(null, TAG_UID_POLICY);     // Catch: IOException -> L19
    L38:
        i2 = i2 + 1;     // Catch: IOException -> L19
        goto L33
    L39:
        out.endTag(null, TAG_POLICY_LIST);     // Catch: IOException -> L19
        out.startTag(null, TAG_ALLOWLIST);     // Catch: IOException -> L19
        int size = this.mRestrictBackgroundAllowlistRevokedUids.size();     // Catch: IOException -> L19
        int i3 = 0;
    L40:
        if (i3 >= size) goto L42;
        int uid2 = this.mRestrictBackgroundAllowlistRevokedUids.keyAt(i3);     // Catch: IOException -> L19
        out.startTag(null, TAG_REVOKED_RESTRICT_BACKGROUND);     // Catch: IOException -> L19
        XmlUtils.writeIntAttribute(out, "uid", uid2);     // Catch: IOException -> L19
        out.endTag(null, TAG_REVOKED_RESTRICT_BACKGROUND);     // Catch: IOException -> L19
        i3 = i3 + 1;     // Catch: IOException -> L19
        goto L40
    L42:
        out.endTag(null, TAG_ALLOWLIST);     // Catch: IOException -> L19
        out.endDocument();     // Catch: IOException -> L19
        this.mPolicyFile.finishWrite(fos);     // Catch: IOException -> L19
        return;
    L45:
        if (fos == null) goto L57;
        this.mPolicyFile.failWrite(fos);
        return;
    }

    public void setUidPolicy(int uid, int policy) {
        setUidPolicy_enforcePermission();
        if (UserHandle.isApp(uid) == false) goto L23;
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L16
        int oldPolicy = this.mUidPolicy.get(uid, 0);     // Catch: Throwable -> L11
        if (oldPolicy == policy) goto L13;
        setUidPolicyUncheckedUL(uid, oldPolicy, policy, true);     // Catch: Throwable -> L11
        this.mLogger.uidPolicyChanged(uid, oldPolicy, policy);     // Catch: Throwable -> L11
    L13:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L23:
        throw new IllegalArgumentException("cannot apply policy to UID " + uid);
    }

    public void addUidPolicy(int uid, int policy) {
        addUidPolicy_enforcePermission();
        if (UserHandle.isApp(uid) == false) goto L23;
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L16
        int oldPolicy = this.mUidPolicy.get(uid, 0);     // Catch: Throwable -> L11
        int policy2 = policy | oldPolicy;     // Catch: Throwable -> L11
        if (oldPolicy == policy2) goto L13;
        setUidPolicyUncheckedUL(uid, oldPolicy, policy2, true);     // Catch: Throwable -> L11
        this.mLogger.uidPolicyChanged(uid, oldPolicy, policy2);     // Catch: Throwable -> L11
    L13:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L23:
        throw new IllegalArgumentException("cannot apply policy to UID " + uid);
    }

    public void removeUidPolicy(int uid, int policy) {
        removeUidPolicy_enforcePermission();
        if (UserHandle.isApp(uid) == false) goto L23;
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L16
        int oldPolicy = this.mUidPolicy.get(uid, 0);     // Catch: Throwable -> L11
        int policy2 = oldPolicy & (~policy);     // Catch: Throwable -> L11
        if (oldPolicy == policy2) goto L13;
        setUidPolicyUncheckedUL(uid, oldPolicy, policy2, true);     // Catch: Throwable -> L11
        this.mLogger.uidPolicyChanged(uid, oldPolicy, policy2);     // Catch: Throwable -> L11
    L13:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L23:
        throw new IllegalArgumentException("cannot apply policy to UID " + uid);
    }

    private void setUidPolicyUncheckedUL(int uid, int oldPolicy, int policy, boolean persist) {
        boolean notifyApp = false;
        setUidPolicyUncheckedUL(uid, policy, false);
        if (isUidValidForAllowlistRulesUL(uid) == true) goto L6;
        notifyApp = false;
    L46:
        this.mHandler.obtainMessage(13, uid, policy, Boolean.valueOf(notifyApp)).sendToTarget();
        if (persist == false) goto L56;
        Object r1 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r1);
        writePolicyAL();     // Catch: Throwable -> L53
        monitor-exit(r1);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    L56:
        return;
    L6:
        if (oldPolicy != 1) goto L8;
        boolean wasDenied = true;
    L9:
        if (policy != 1) goto L11;
        boolean isDenied = true;
    L13:
        if (oldPolicy != 4) goto L15;
        boolean wasAllowed = true;
    L16:
        if (policy != 4) goto L18;
        boolean isAllowed = true;
    L19:
        if (wasDenied == false) goto L21;
    L25:
        boolean wasBlocked = true;
    L26:
        if (isDenied == false) goto L28;
    L32:
        boolean isBlocked = true;
    L33:
        if (wasAllowed == false) goto L44;
        if (isAllowed == false) goto L37;
        if (isDenied == false) goto L44;
    L37:
        if (this.mDefaultRestrictBackgroundAllowlistUids.get(uid) == false) goto L44;
        if (this.mRestrictBackgroundAllowlistRevokedUids.get(uid) == true) goto L44;
        if (LOGD == false) goto L43;
        Slog.d(TAG, "Adding uid " + uid + " to revoked restrict background allowlist");
    L43:
        this.mRestrictBackgroundAllowlistRevokedUids.append(uid, true);
    L44:
        if (wasBlocked == isBlocked) goto L46;
        notifyApp = true;
        goto L46
    L28:
        if (this.mRestrictBackground == false) goto L31;
        if (isAllowed == false) goto L32;
    L31:
        isBlocked = false;
        goto L33
    L21:
        if (this.mRestrictBackground == false) goto L24;
        if (wasAllowed == false) goto L25;
    L24:
        wasBlocked = false;
        goto L26
    L18:
        isAllowed = false;
        goto L19
    L15:
        wasAllowed = false;
        goto L16
    L11:
        isDenied = false;
        goto L13
    L8:
        wasDenied = false;
        goto L9
    }

    private void setUidPolicyUncheckedUL(int uid, int policy, boolean persist) {
        if (policy != 0) goto L4;
        this.mUidPolicy.delete(uid);
    L5:
        updateRulesForDataUsageRestrictionsUL(uid);
        if (persist == false) goto L15;
        Object r0 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r0);
        writePolicyAL();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        return;
    L4:
        this.mUidPolicy.put(uid, policy);
        goto L5
    }

    public int getUidPolicy(int uid) {
        getUidPolicy_enforcePermission();
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        int r1 = this.mUidPolicy.get(uid, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int[] getUidsWithPolicy(int policy) {
        getUidsWithPolicy_enforcePermission();
        int[] uids = new int[0];
        Object r1 = this.mUidRulesFirstLock;
        monitor-enter(r1);
        int i = 0;
    L21:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mUidPolicy.size()) goto L17;
        int uid = this.mUidPolicy.keyAt(i);     // Catch: Throwable -> L13
        int uidPolicy = this.mUidPolicy.valueAt(i);     // Catch: Throwable -> L13
        if (policy != 0) goto L11;
        if (uidPolicy != 0) goto L11;
    L12:
        uids = ArrayUtils.appendInt(uids, uid);     // Catch: Throwable -> L13
    L15:
        i = i + 1;     // Catch: Throwable -> L13
    L11:
        if ((uidPolicy & policy) == 0) goto L15;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return uids;
    }

    boolean removeUserStateUL(int userId, boolean writePolicy, boolean updateGlobalRules) {
        this.mLogger.removingUserState(userId);
        boolean changed = false;
        int i = this.mRestrictBackgroundAllowlistRevokedUids.size() - 1;
    L3:
        if (i < 0) goto L8;
        int uid = this.mRestrictBackgroundAllowlistRevokedUids.keyAt(i);
        if (UserHandle.getUserId(uid) != userId) goto L7;
        this.mRestrictBackgroundAllowlistRevokedUids.removeAt(i);
        changed = true;
    L7:
        i = i - 1;
        goto L3
    L8:
        int i2 = 0;
        int[] uids = new int[0];
        int i3 = 0;
    L10:
        if (i3 >= this.mUidPolicy.size()) goto L15;
        int uid2 = this.mUidPolicy.keyAt(i3);
        if (UserHandle.getUserId(uid2) != userId) goto L14;
        uids = ArrayUtils.appendInt(uids, uid2);
    L14:
        i3 = i3 + 1;
        goto L10
    L15:
        int i4 = uids.length;
        if (i4 <= 0) goto L21;
        int r4 = uids.length;
    L18:
        if (i2 >= r4) goto L20;
        this.mUidPolicy.delete(uids[i2]);
        i2 = i2 + 1;
        goto L18
    L20:
        changed = true;
    L21:
        Object r1 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r1);
        if (updateGlobalRules == true) goto L34;
    L27:
        if (writePolicy == false) goto L30;
        if (changed == false) goto L30;
        writePolicyAL();     // Catch: Throwable -> L25
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L25
        return changed;
    L25:
        th = move-exception;
        throw th;
    L34:
        updateRulesForGlobalChangeAL(true);     // Catch: Throwable -> L25
        goto L27
    }

    private boolean checkAnyPermissionOf(String... permissions) {
        int r0 = permissions.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        String permission = permissions[r2];
        if (this.mContext.checkCallingOrSelfPermission(permission) == 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void enforceAnyPermissionOf(String... permissions) {
        if (checkAnyPermissionOf(permissions) == false) goto L6;
        return;
    L6:
        throw new SecurityException("Requires one of the following permissions: " + String.join(", ", permissions) + ".");
    }

    public void registerListener(INetworkPolicyListener listener) {
        listener.getClass();
        enforceAnyPermissionOf(new String[]{"android.permission.CONNECTIVITY_INTERNAL", "android.permission.OBSERVE_NETWORK_POLICY"});
        this.mListeners.register(listener);
    }

    public void unregisterListener(INetworkPolicyListener listener) {
        listener.getClass();
        enforceAnyPermissionOf(new String[]{"android.permission.CONNECTIVITY_INTERNAL", "android.permission.OBSERVE_NETWORK_POLICY"});
        this.mListeners.unregister(listener);
    }

    public void setNetworkPolicies(NetworkPolicy[] policies) {
        setNetworkPolicies_enforcePermission();
        if (DEBUG == false) goto L5;
        Log.d(TAG, "setNetworkPolicies");
    L5:
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mUidRulesFirstLock;     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
        Object r3 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
        this.mOverLimitNotified.clear();     // Catch: Throwable -> L17
        normalizePoliciesNL(policies);     // Catch: Throwable -> L17
        handleNetworkPoliciesUpdateAL(false);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    void addNetworkPolicyAL(NetworkPolicy policy) {
        NetworkPolicy[] policies = getNetworkPolicies(this.mContext.getOpPackageName());
        NetworkPolicy[] policies2 = (NetworkPolicy[]) ArrayUtils.appendElement(NetworkPolicy.class, policies, policy);
        setNetworkPolicies(policies2);
    }

    public NetworkPolicy[] getNetworkPolicies(String callingPackage) {
        getNetworkPolicies_enforcePermission();
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", TAG);     // Catch: SecurityException -> L5
    L10:
        Object r0 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r0);
        int size = this.mNetworkPolicy.size();     // Catch: Throwable -> L15
        NetworkPolicy[] policies = new NetworkPolicy[size];     // Catch: Throwable -> L15
        int i = 0;
    L13:
        if (i >= size) goto L18;
        policies[i] = this.mNetworkPolicy.valueAt(i);     // Catch: Throwable -> L15
        i = i + 1;     // Catch: Throwable -> L15
        goto L13
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return policies;
    L15:
        th = move-exception;
        throw th;
    L6:
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PHONE_STATE", TAG);
        if (this.mAppOps.noteOp(51, Binder.getCallingUid(), callingPackage) == 0) goto L10;
        return new NetworkPolicy[0];
    }

    private void normalizePoliciesNL() {
        normalizePoliciesNL(getNetworkPolicies(this.mContext.getOpPackageName()));
    }

    private void normalizePoliciesNL(NetworkPolicy[] policies) {
        this.mNetworkPolicy.clear();
        int r0 = policies.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        NetworkPolicy policy = policies[r1];
        if (policy == null) goto L14;
        policy.template = normalizeTemplate(policy.template, this.mMergedSubscriberIds);
        NetworkPolicy existing = this.mNetworkPolicy.get(policy.template);
        if (existing != null) goto L10;
    L11:
        if (existing == null) goto L13;
        Slog.d(TAG, "Normalization replaced " + existing + " with " + policy);
    L13:
        this.mNetworkPolicy.put(policy.template, policy);
        goto L14
    L10:
        if (existing.compareTo(policy) > 0) goto L11;
    L14:
        r1 = r1 + 1;
        goto L3
    }

    static NetworkTemplate normalizeTemplate(NetworkTemplate template, List<String[]> mergedList) {
        if (template.getSubscriberIds().isEmpty() == false) goto L5;
        return template;
    L5:
        Iterator<String[]> r0 = mergedList.iterator();
    L7:
        if (r0.hasNext() == false) goto L20;
        String[] merged = r0.next();
        ArraySet mergedSet = new ArraySet(merged);
        if (mergedSet.size() == merged.length) goto L11;
        Log.wtf(TAG, "Duplicated merged list detected: " + Arrays.toString(merged));
    L11:
        Iterator r3 = template.getSubscriberIds().iterator();
    L13:
        if (r3.hasNext() == false) goto L7;
        String subscriberId = (String) r3.next();
        if (com.android.net.module.util.CollectionUtils.contains(merged, subscriberId) == false) goto L13;
        return new NetworkTemplate.Builder(template.getMatchRule()).setWifiNetworkKeys(template.getWifiNetworkKeys()).setSubscriberIds(mergedSet).setMeteredness(template.getMeteredness()).build();
    L20:
        return template;
    }

    public void snoozeLimit(NetworkTemplate template) {
        snoozeLimit_enforcePermission();
        long token = Binder.clearCallingIdentity();
        performSnooze(template, 35);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    void performSnooze(NetworkTemplate template, int type) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "performSnooze");
    L5:
        long currentTime = this.mClock.millis();
        Object r2 = this.mUidRulesFirstLock;
        monitor-enter(r2);
        Object r3 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L23
        monitor-enter(r3);     // Catch: Throwable -> L23
        NetworkPolicy policy = this.mNetworkPolicy.get(template);     // Catch: Throwable -> L14
        if (policy == null) goto L26;
        switch(type) {
            case 34: goto L18;
            case 35: goto L17;
            case 45: goto L16;
            default: goto L13;
        };     // Catch: Throwable -> L14
    L16:
        policy.lastRapidSnooze = currentTime;     // Catch: Throwable -> L14
    L19:
        handleNetworkPoliciesUpdateAL(true);     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L23
        return;
    L17:
        policy.lastLimitSnooze = currentTime;     // Catch: Throwable -> L14
        goto L19
    L18:
        policy.lastWarningSnooze = currentTime;     // Catch: Throwable -> L14
        goto L19
    L13:
        throw new IllegalArgumentException("unexpected type");     // Catch: Throwable -> L14
    L26:
        throw new IllegalArgumentException("unable to find policy for " + template);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public void setRestrictBackground(boolean restrictBackground) {
        Trace.traceBegin(2097152, "setRestrictBackground");
        if (DEBUG == false) goto L23;
        Log.d(TAG, "setRestrictBackground");
    L23:
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_NETWORK_POLICY", TAG);     // Catch: Throwable -> L13
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L13
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        Object r5 = this.mUidRulesFirstLock;     // Catch: Throwable -> L18
        monitor-enter(r5);     // Catch: Throwable -> L18
        setRestrictBackgroundUL(restrictBackground, "uid:" + callingUid);     // Catch: Throwable -> L15
        monitor-exit(r5);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L13
        Trace.traceEnd(2097152);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void setRestrictBackgroundUL(boolean restrictBackground, String reason) {
        Trace.traceBegin(2097152, "setRestrictBackgroundUL");
    L8:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    L4:
        if (restrictBackground != this.mRestrictBackground) goto L10;
        Slog.w(TAG, "setRestrictBackgroundUL: already " + restrictBackground);     // Catch: Throwable -> L8
        Trace.traceEnd(2097152);
        return;
    L10:
        Slog.d(TAG, "setRestrictBackgroundUL(): " + restrictBackground + "; reason: " + reason);     // Catch: Throwable -> L8
        boolean oldRestrictBackground = this.mRestrictBackground;     // Catch: Throwable -> L8
        this.mRestrictBackground = restrictBackground;     // Catch: Throwable -> L8
        updateRulesForRestrictBackgroundUL();     // Catch: Throwable -> L8
        if (this.mNetworkManager.setDataSaverModeEnabled(this.mRestrictBackground) == true) goto L19;
        Slog.e(TAG, "Could not change Data Saver Mode on NMS to " + this.mRestrictBackground);     // Catch: Throwable -> L8 RemoteException -> L16
        this.mRestrictBackground = oldRestrictBackground;     // Catch: Throwable -> L8 RemoteException -> L16
        Trace.traceEnd(2097152);
        return;
    L19:
        sendRestrictBackgroundChangedMsg();     // Catch: Throwable -> L8
        this.mLogger.restrictBackgroundChanged(oldRestrictBackground, this.mRestrictBackground);     // Catch: Throwable -> L8
        if (this.mRestrictBackgroundLowPowerMode == false) goto L22;
        this.mRestrictBackgroundChangedInBsm = true;     // Catch: Throwable -> L8
    L22:
        Object r3 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L8
        monitor-enter(r3);     // Catch: Throwable -> L8
        updateNotificationsNL();     // Catch: Throwable -> L28
        writePolicyAL();     // Catch: Throwable -> L28
        monitor-exit(r3);     // Catch: Throwable -> L28
        Trace.traceEnd(2097152);
        return;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    }

    private void sendRestrictBackgroundChangedMsg() {
        this.mHandler.removeMessages(6);
        this.mHandler.obtainMessage(6, this.mRestrictBackground ? 1 : 0, 0).sendToTarget();
    }

    public int getRestrictBackgroundByCaller() {
        getRestrictBackgroundByCaller_enforcePermission();
        return getRestrictBackgroundStatusInternal(Binder.getCallingUid());
    }

    public int getRestrictBackgroundStatus(int uid) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        return getRestrictBackgroundStatusInternal(uid);
    }

    private int getRestrictBackgroundStatusInternal(int uid) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        int policy = getUidPolicy(uid);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L10
        int r4 = 3;
        if (policy != 1) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 3;
    L13:
        if (this.mRestrictBackground == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 1;
    L17:
        if ((this.mUidPolicy.get(uid) & 4) == 0) goto L20;
        r4 = 2;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public boolean getRestrictBackground() {
        getRestrictBackground_enforcePermission();
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        boolean r1 = this.mRestrictBackground;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDeviceIdleMode(boolean enabled) {
        setDeviceIdleMode_enforcePermission();
        Trace.traceBegin(2097152, "setDeviceIdleMode");
        Object r0 = this.mUidRulesFirstLock;     // Catch: Throwable -> L18
        monitor-enter(r0);     // Catch: Throwable -> L18
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        if (this.mDeviceIdleMode != enabled) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        Trace.traceEnd(2097152);
        return;
    L12:
        this.mDeviceIdleMode = enabled;     // Catch: Throwable -> L10
        this.mLogger.deviceIdleModeEnabled(enabled);     // Catch: Throwable -> L10
        if (this.mSystemReady == false) goto L15;
        handleDeviceIdleModeChangedUL(enabled);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (enabled == false) goto L20;
        EventLogTags.writeDeviceIdleOnPhase("net");     // Catch: Throwable -> L18
    L21:
        Trace.traceEnd(2097152);
        return;
    L20:
        EventLogTags.writeDeviceIdleOffPhase("net");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    public void setWifiMeteredOverride(String networkId, int meteredOverride) {
        setWifiMeteredOverride_enforcePermission();
        long token = Binder.clearCallingIdentity();
        WifiManager wm = (WifiManager) this.mContext.getSystemService(WifiManager.class);     // Catch: Throwable -> L10
        List<WifiConfiguration> configs = wm.getConfiguredNetworks();     // Catch: Throwable -> L10
        Iterator<WifiConfiguration> r4 = configs.iterator();     // Catch: Throwable -> L10
    L5:
        if (r4.hasNext() == false) goto L13;
        WifiConfiguration config = r4.next();     // Catch: Throwable -> L10
        if (Objects.equals(NetworkPolicyManager.resolveNetworkId(config), networkId) == false) goto L5;
        config.meteredOverride = meteredOverride;     // Catch: Throwable -> L10
        wm.updateNetwork(config);     // Catch: Throwable -> L10
        goto L5
    L13:
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void enforceSubscriptionPlanAccess(int subId, int callingUid, String callingPackage) {
        this.mAppOps.checkPackage(callingUid, callingPackage);
        long token = Binder.clearCallingIdentity();
        PersistableBundle config = this.mCarrierConfigManager.getConfigForSubId(subId);     // Catch: Throwable -> L33
        TelephonyManager tm = ((TelephonyManager) this.mContext.getSystemService(TelephonyManager.class)).createForSubscriptionId(subId);     // Catch: Throwable -> L33
        Binder.restoreCallingIdentity(token);
        if (tm == null) goto L10;
        if (tm.checkCarrierPrivilegesForPackage(callingPackage) != 1) goto L10;
        return;
    L10:
        if (config == null) goto L16;
        String overridePackage = config.getString("config_plans_package_override_string", null);
        if (TextUtils.isEmpty(overridePackage) == true) goto L16;
        if (Objects.equals(overridePackage, callingPackage) == false) goto L16;
        return;
    L16:
        String defaultPackage = this.mCarrierConfigManager.getDefaultCarrierServicePackageName();
        if (TextUtils.isEmpty(defaultPackage) == false) goto L19;
    L21:
        String testPackage = SystemProperties.get("persist.sys.sub_plan_owner." + subId, null);
        if (TextUtils.isEmpty(testPackage) == false) goto L24;
    L26:
        String legacyTestPackage = SystemProperties.get("fw.sub_plan_owner." + subId, null);
        if (TextUtils.isEmpty(legacyTestPackage) == false) goto L29;
    L31:
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_SUBSCRIPTION_PLANS", TAG);
        return;
    L29:
        if (Objects.equals(legacyTestPackage, callingPackage) == false) goto L31;
        return;
    L24:
        if (Objects.equals(testPackage, callingPackage) == false) goto L26;
        return;
    L19:
        if (Objects.equals(defaultPackage, callingPackage) == false) goto L21;
        return;
    L33:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void enforceSubscriptionPlanValidity(SubscriptionPlan[] plans) {
        if (plans.length != 0) goto L6;
        Log.d(TAG, "Received empty plans list. Clearing existing SubscriptionPlans.");
        return;
    L6:
        int[] allNetworkTypes = TelephonyManager.getAllNetworkTypes();
        ArraySet<Integer> allNetworksSet = new ArraySet();
        addAll(allNetworksSet, allNetworkTypes);
        ArraySet<Integer> applicableNetworkTypes = new ArraySet();
        boolean hasGeneralPlan = false;
        int i = 0;
    L8:
        if (i >= plans.length) goto L30;
        int[] planNetworkTypes = plans[i].getNetworkTypes();
        ArraySet<Integer> planNetworksSet = new ArraySet();
        int j = 0;
    L11:
        if (j >= planNetworkTypes.length) goto L21;
        if (allNetworksSet.contains(Integer.valueOf(planNetworkTypes[j])) == false) goto L20;
        if (planNetworksSet.add(Integer.valueOf(planNetworkTypes[j])) == false) goto L18;
        j = j + 1;
        goto L11
    L18:
        throw new IllegalArgumentException("Subscription plan contains duplicate network types.");
    L20:
        throw new IllegalArgumentException("Invalid network type: " + planNetworkTypes[j]);
    L21:
        int j2 = planNetworkTypes.length;
        if (j2 != allNetworkTypes.length) goto L25;
        hasGeneralPlan = true;
    L26:
        i = i + 1;
        goto L8
    L25:
        if (addAll(applicableNetworkTypes, planNetworkTypes) == true) goto L26;
        throw new IllegalArgumentException("Multiple subscription plans defined for a single network type.");
    L30:
        if (hasGeneralPlan == false) goto L33;
        return;
    L33:
        throw new IllegalArgumentException("No generic subscription plan that applies to all network types.");
    }

    private static boolean addAll(ArraySet<Integer> set, int... elements) {
        boolean result = true;
        int i = 0;
    L4:
        if (i >= elements.length) goto L7;
        result = result & set.add(Integer.valueOf(elements[i]));
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    public SubscriptionPlan getSubscriptionPlan(NetworkTemplate template) {
        enforceAnyPermissionOf(new String[]{"android.permission.MAINLINE_NETWORK_STACK"});
        Object r0 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r0);
        int subId = findRelevantSubIdNL(template);     // Catch: Throwable -> L7
        SubscriptionPlan r2 = getPrimarySubscriptionPlanLocked(subId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyStatsProviderWarningOrLimitReached() {
        enforceAnyPermissionOf(new String[]{"android.permission.MAINLINE_NETWORK_STACK"});
        Object r0 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSystemReady == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mHandler.obtainMessage(20).sendToTarget();
    }

    public SubscriptionPlan[] getSubscriptionPlans(int subId, String callingPackage) {
        enforceSubscriptionPlanAccess(subId, Binder.getCallingUid(), callingPackage);
        String fake = SystemProperties.get("fw.fake_plan");
        if (TextUtils.isEmpty(fake) == true) goto L27;
        List<SubscriptionPlan> plans = new ArrayList();
        if ("month_hard".equals(fake) == false) goto L8;
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2007-03-14T00:00:00.000Z")).setTitle("G-Mobile").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 1).setDataUsage(DataUnit.GIBIBYTES.toBytes(1), ZonedDateTime.now().minusHours(36).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2017-03-14T00:00:00.000Z")).setTitle("G-Mobile Happy").setDataLimit(Long.MAX_VALUE, 1).setDataUsage(DataUnit.GIBIBYTES.toBytes(5), ZonedDateTime.now().minusHours(36).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2017-03-14T00:00:00.000Z")).setTitle("G-Mobile, Charged after limit").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 1).setDataUsage(DataUnit.GIBIBYTES.toBytes(5), ZonedDateTime.now().minusHours(36).toInstant().toEpochMilli()).build());
    L26:
        return (SubscriptionPlan[]) plans.toArray(new SubscriptionPlan[plans.size()]);
    L8:
        if ("month_soft".equals(fake) == false) goto L11;
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2007-03-14T00:00:00.000Z")).setTitle("G-Mobile is the carriers name who this plan belongs to").setSummary("Crazy unlimited bandwidth plan with incredibly long title that should be cut off to prevent UI from looking terrible").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 2).setDataUsage(DataUnit.GIBIBYTES.toBytes(1), ZonedDateTime.now().minusHours(1).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2017-03-14T00:00:00.000Z")).setTitle("G-Mobile, Throttled after limit").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 2).setDataUsage(DataUnit.GIBIBYTES.toBytes(5), ZonedDateTime.now().minusHours(1).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2017-03-14T00:00:00.000Z")).setTitle("G-Mobile, No data connection after limit").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 0).setDataUsage(DataUnit.GIBIBYTES.toBytes(5), ZonedDateTime.now().minusHours(1).toInstant().toEpochMilli()).build());
        goto L26
    L11:
        if ("month_over".equals(fake) == false) goto L14;
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2007-03-14T00:00:00.000Z")).setTitle("G-Mobile is the carriers name who this plan belongs to").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 2).setDataUsage(DataUnit.GIBIBYTES.toBytes(6), ZonedDateTime.now().minusHours(1).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2017-03-14T00:00:00.000Z")).setTitle("G-Mobile, Throttled after limit").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 2).setDataUsage(DataUnit.GIBIBYTES.toBytes(5), ZonedDateTime.now().minusHours(1).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2017-03-14T00:00:00.000Z")).setTitle("G-Mobile, No data connection after limit").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 0).setDataUsage(DataUnit.GIBIBYTES.toBytes(5), ZonedDateTime.now().minusHours(1).toInstant().toEpochMilli()).build());
        goto L26
    L14:
        if ("month_none".equals(fake) == false) goto L17;
        plans.add(SubscriptionPlan.Builder.createRecurringMonthly(ZonedDateTime.parse("2007-03-14T00:00:00.000Z")).setTitle("G-Mobile").build());
        goto L26
    L17:
        if ("prepaid".equals(fake) == false) goto L20;
        plans.add(SubscriptionPlan.Builder.createNonrecurring(ZonedDateTime.now().minusDays(20), ZonedDateTime.now().plusDays(10)).setTitle("G-Mobile").setDataLimit(DataUnit.MEBIBYTES.toBytes(512), 0).setDataUsage(DataUnit.MEBIBYTES.toBytes(100), ZonedDateTime.now().minusHours(3).toInstant().toEpochMilli()).build());
        goto L26
    L20:
        if ("prepaid_crazy".equals(fake) == false) goto L23;
        plans.add(SubscriptionPlan.Builder.createNonrecurring(ZonedDateTime.now().minusDays(20), ZonedDateTime.now().plusDays(10)).setTitle("G-Mobile Anytime").setDataLimit(DataUnit.MEBIBYTES.toBytes(512), 0).setDataUsage(DataUnit.MEBIBYTES.toBytes(100), ZonedDateTime.now().minusHours(3).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createNonrecurring(ZonedDateTime.now().minusDays(10), ZonedDateTime.now().plusDays(20)).setTitle("G-Mobile Nickel Nights").setSummary("5¢/GB between 1-5AM").setDataLimit(DataUnit.GIBIBYTES.toBytes(5), 2).setDataUsage(DataUnit.MEBIBYTES.toBytes(15), ZonedDateTime.now().minusHours(30).toInstant().toEpochMilli()).build());
        plans.add(SubscriptionPlan.Builder.createNonrecurring(ZonedDateTime.now().minusDays(10), ZonedDateTime.now().plusDays(20)).setTitle("G-Mobile Bonus 3G").setSummary("Unlimited 3G data").setDataLimit(DataUnit.GIBIBYTES.toBytes(1), 2).setDataUsage(DataUnit.MEBIBYTES.toBytes(300), ZonedDateTime.now().minusHours(1).toInstant().toEpochMilli()).build());
        goto L26
    L23:
        if ("unlimited".equals(fake) == false) goto L26;
        plans.add(SubscriptionPlan.Builder.createNonrecurring(ZonedDateTime.now().minusDays(20), ZonedDateTime.now().plusDays(10)).setTitle("G-Mobile Awesome").setDataLimit(Long.MAX_VALUE, 2).setDataUsage(DataUnit.MEBIBYTES.toBytes(50), ZonedDateTime.now().minusHours(3).toInstant().toEpochMilli()).build());
        goto L26
    L27:
        Object r5 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r5);
        String ownerPackage = this.mSubscriptionPlansOwner.get(subId);     // Catch: Throwable -> L40
        if (Objects.equals(ownerPackage, callingPackage) == false) goto L32;
    L42:
        SubscriptionPlan[] r6 = this.mSubscriptionPlans.get(subId);     // Catch: Throwable -> L40
        monitor-exit(r5);     // Catch: Throwable -> L40
        return r6;
    L32:
        if (UserHandle.getCallingAppId() == 1000) goto L42;
        if (UserHandle.getCallingAppId() == 1001) goto L42;
        Log.w(TAG, "Not returning plans because caller " + callingPackage + " doesn't match owner " + ownerPackage);     // Catch: Throwable -> L40
        monitor-exit(r5);     // Catch: Throwable -> L40
        return null;
    L40:
        th = move-exception;
        throw th;
    }

    public void setSubscriptionPlans(int subId, SubscriptionPlan[] plans, long expirationDurationMillis, String callingPackage) {
        enforceSubscriptionPlanAccess(subId, Binder.getCallingUid(), callingPackage);
        enforceSubscriptionPlanValidity(plans);
        int r0 = plans.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        SubscriptionPlan plan = plans[r1];
        plan.getClass();
        r1 = r1 + 1;
        goto L3
    L5:
        long token = Binder.clearCallingIdentity();
        setSubscriptionPlansInternal(subId, plans, expirationDurationMillis, callingPackage);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void setSubscriptionPlansInternal(int subId, SubscriptionPlan[] plans, long expirationDurationMillis, String callingPackage) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        Object r1 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L18
        monitor-enter(r1);     // Catch: Throwable -> L18
        this.mSubscriptionPlans.put(subId, plans);     // Catch: Throwable -> L9
        this.mSubscriptionPlansOwner.put(subId, callingPackage);     // Catch: Throwable -> L9
        String subscriberId = this.mSubIdToSubscriberId.get(subId, null);     // Catch: Throwable -> L9
        if (subscriberId == null) goto L11;
        ensureActiveCarrierPolicyAL(subId, subscriberId);     // Catch: Throwable -> L9
        maybeUpdateCarrierPolicyCycleAL(subId, subscriberId);     // Catch: Throwable -> L9
    L12:
        handleNetworkPoliciesUpdateAL(true);     // Catch: Throwable -> L9
        Intent intent = new Intent("android.telephony.action.SUBSCRIPTION_PLANS_CHANGED");     // Catch: Throwable -> L9
        intent.addFlags(1073741824);     // Catch: Throwable -> L9
        intent.putExtra("android.telephony.extra.SUBSCRIPTION_INDEX", subId);     // Catch: Throwable -> L9
        this.mContext.sendBroadcast(intent, "android.permission.MANAGE_SUBSCRIPTION_PLANS");     // Catch: Throwable -> L9
        this.mHandler.sendMessage(this.mHandler.obtainMessage(19, subId, 0, plans));     // Catch: Throwable -> L9
        int setPlansId = this.mSetSubscriptionPlansIdCounter;     // Catch: Throwable -> L9
        this.mSetSubscriptionPlansIdCounter = setPlansId + 1;     // Catch: Throwable -> L9
        this.mSetSubscriptionPlansIds.put(subId, setPlansId);     // Catch: Throwable -> L9
        if (expirationDurationMillis <= 0) goto L15;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(22, subId, setPlansId, callingPackage), expirationDurationMillis);     // Catch: Throwable -> L9
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L11:
        Slog.wtf(TAG, "Missing subscriberId for subId " + subId);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    void setSubscriptionPlansOwner(int subId, String packageName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.NETWORK_SETTINGS", TAG);
        SystemProperties.set("persist.sys.sub_plan_owner." + subId, packageName);
    }

    public String getSubscriptionPlansOwner(int subId) {
        if (UserHandle.getCallingAppId() != 1000) goto L13;
        Object r0 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r0);
        String r1 = this.mSubscriptionPlansOwner.get(subId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new SecurityException();
    }

    public void setSubscriptionOverride(int subId, int overrideMask, int overrideValue, int[] networkTypes, long expirationDurationMillis, String callingPackage) {
        enforceSubscriptionPlanAccess(subId, Binder.getCallingUid(), callingPackage);
        ArraySet<Integer> allNetworksSet = new ArraySet();
        addAll(allNetworksSet, TelephonyManager.getAllNetworkTypes());
        IntArray applicableNetworks = new IntArray();
        int r0 = networkTypes.length;
        int r10 = 0;
    L3:
        if (r10 >= r0) goto L9;
        int networkType = networkTypes[r10];
        if (allNetworksSet.contains(Integer.valueOf(networkType)) == false) goto L7;
        applicableNetworks.add(networkType);
    L8:
        r10 = r10 + 1;
        goto L3
    L7:
        Log.d(TAG, "setSubscriptionOverride removing invalid network type: " + networkType);
        goto L8
    L9:
        Object r11 = this.mNetworkPoliciesSecondLock;
        monitor-enter(r11);
        SubscriptionPlan plan = getPrimarySubscriptionPlanLocked(subId);     // Catch: Throwable -> L33
        boolean overrideEnabled = true;
        if (overrideMask == 1) goto L22;
        if (plan == null) goto L21;
        if (plan.getDataLimitBehavior() != (-1)) goto L22;
    L21:
        throw new IllegalStateException("Must provide valid SubscriptionPlan to enable overriding");     // Catch: Throwable -> L18
    L22:
        monitor-exit(r11);     // Catch: Throwable -> L18
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "netpolicy_override_enabled", 1) != 0) goto L27;
        overrideEnabled = false;
    L27:
        if (overrideEnabled == true) goto L29;
        if (overrideValue == 0) goto L29;
        return;
    L29:
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = Integer.valueOf(subId);
        args.arg2 = Integer.valueOf(overrideMask);
        args.arg3 = Integer.valueOf(overrideValue);
        args.arg4 = applicableNetworks.toArray();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(16, args));
        if (expirationDurationMillis <= 0) goto L43;
        args.arg3 = 0;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(16, args), expirationDurationMillis);
        return;
    L43:
        return;
    L18:
        th = th;
    L35:
        monitor-exit(r11);     // Catch: Throwable -> L18
        throw th;
    L33:
        th = th;
        goto L35
    }

    public int getMultipathPreference(Network network) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        Integer preference = this.mMultipathPolicyTracker.getMultipathPreference(network);
        if (preference != null) goto L5;
        return 0;
    L5:
        return preference.intValue();
    }

    @NeverCompile
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter fout = new IndentingPrintWriter(writer, "  ");
        ArraySet<String> argSet = new ArraySet(args.length);
        int r2 = args.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        String arg = args[r4];
        argSet.add(arg);
        r4 = r4 + 1;
        goto L6
    L8:
        Object r3 = this.mUidRulesFirstLock;
        monitor-enter(r3);
        Object r5 = this.mNetworkPoliciesSecondLock;     // Catch: Throwable -> L23
        monitor-enter(r5);     // Catch: Throwable -> L23
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L13:
        if (argSet.contains("--unsnooze") == false) goto L25;
        int i = this.mNetworkPolicy.size() - 1;     // Catch: Throwable -> L17
    L15:
        if (i < 0) goto L19;
        this.mNetworkPolicy.valueAt(i).clearSnooze();     // Catch: Throwable -> L17
        i = i - 1;     // Catch: Throwable -> L17
        goto L15
    L19:
        handleNetworkPoliciesUpdateAL(true);     // Catch: Throwable -> L17
        fout.println("Cleared snooze timestamps");     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L23
        return;
    L25:
        fout.print("System ready: ");     // Catch: Throwable -> L17
        fout.println(this.mSystemReady);     // Catch: Throwable -> L17
        fout.print("Restrict background: ");     // Catch: Throwable -> L17
        fout.println(this.mRestrictBackground);     // Catch: Throwable -> L17
        fout.print("Restrict power: ");     // Catch: Throwable -> L17
        fout.println(this.mRestrictPower);     // Catch: Throwable -> L17
        fout.print("Device idle: ");     // Catch: Throwable -> L17
        fout.println(this.mDeviceIdleMode);     // Catch: Throwable -> L17
        SysOptBridge.getFactory().getPolicyServiceOptEx().dump(fout);     // Catch: Throwable -> L17
        fout.print("Restricted networking mode: ");     // Catch: Throwable -> L17
        fout.println(this.mRestrictedNetworkingMode);     // Catch: Throwable -> L17
        fout.print("Low Power Standby mode: ");     // Catch: Throwable -> L17
        fout.println(this.mLowPowerStandbyActive);     // Catch: Throwable -> L17
        Object r6 = this.mMeteredIfacesLock;     // Catch: Throwable -> L17
        monitor-enter(r6);     // Catch: Throwable -> L17
        fout.print("Metered ifaces: ");     // Catch: Throwable -> L142
        fout.println(this.mMeteredIfaces);     // Catch: Throwable -> L142
        monitor-exit(r6);     // Catch: Throwable -> L142
        fout.println();     // Catch: Throwable -> L17
        fout.println("Flags:");     // Catch: Throwable -> L17
        fout.println("com.android.server.net.use_metered_firewall_chains: " + this.mUseMeteredFirewallChains);     // Catch: Throwable -> L17
        fout.println("com.android.server.net.use_different_delays_for_background_chain: " + this.mUseDifferentDelaysForBackgroundChain);     // Catch: Throwable -> L17
        fout.println("com.android.server.net.never_apply_rules_to_core_uids: " + this.mNeverApplyRulesToCoreUids);     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.println("mRestrictBackgroundLowPowerMode: " + this.mRestrictBackgroundLowPowerMode);     // Catch: Throwable -> L17
        fout.println("mRestrictBackgroundBeforeBsm: " + this.mRestrictBackgroundBeforeBsm);     // Catch: Throwable -> L17
        fout.println("mLoadedRestrictBackground: " + this.mLoadedRestrictBackground);     // Catch: Throwable -> L17
        fout.println("mRestrictBackgroundChangedInBsm: " + this.mRestrictBackgroundChangedInBsm);     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.println("Network policies:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i2 = 0;
    L31:
        if (i2 >= this.mNetworkPolicy.size()) goto L33;
        fout.println(this.mNetworkPolicy.valueAt(i2).toString());     // Catch: Throwable -> L17
        i2 = i2 + 1;     // Catch: Throwable -> L17
        goto L31
    L33:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.println("Subscription plans:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i3 = 0;
    L35:
        if (i3 >= this.mSubscriptionPlans.size()) goto L42;
        int subId = this.mSubscriptionPlans.keyAt(i3);     // Catch: Throwable -> L17
        fout.println("Subscription ID " + subId + ":");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        SubscriptionPlan[] plans = this.mSubscriptionPlans.valueAt(i3);     // Catch: Throwable -> L17
        if (ArrayUtils.isEmpty(plans) == true) goto L41;
        int r8 = plans.length;     // Catch: Throwable -> L17
        int r9 = 0;
    L39:
        if (r9 >= r8) goto L41;
        SubscriptionPlan plan = plans[r9];     // Catch: Throwable -> L17
        fout.println(plan);     // Catch: Throwable -> L17
        r9 = r9 + 1;     // Catch: Throwable -> L17
    L41:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        i3 = i3 + 1;     // Catch: Throwable -> L17
        goto L35
    L42:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.println("Active subscriptions:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i4 = 0;
    L44:
        if (i4 >= this.mSubIdToSubscriberId.size()) goto L46;
        int subId2 = this.mSubIdToSubscriberId.keyAt(i4);     // Catch: Throwable -> L17
        String subscriberId = this.mSubIdToSubscriberId.valueAt(i4);     // Catch: Throwable -> L17
        fout.println(subId2 + "=" + NetworkIdentityUtils.scrubSubscriberId(subscriberId));     // Catch: Throwable -> L17
        i4 = i4 + 1;     // Catch: Throwable -> L17
        goto L44
    L46:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        Iterator<String[]> r7 = this.mMergedSubscriberIds.iterator();     // Catch: Throwable -> L17
    L48:
        if (r7.hasNext() == false) goto L50;
        String[] mergedSubscribers = r7.next();     // Catch: Throwable -> L17
        fout.println("Merged subscriptions: " + Arrays.toString(NetworkIdentityUtils.scrubSubscriberIds(mergedSubscribers)));     // Catch: Throwable -> L17
        goto L48
    L50:
        fout.println();     // Catch: Throwable -> L17
        fout.println("Policy for UIDs:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int size = this.mUidPolicy.size();     // Catch: Throwable -> L17
        int i5 = 0;
    L51:
        if (i5 >= size) goto L53;
        int uid = this.mUidPolicy.keyAt(i5);     // Catch: Throwable -> L17
        int policy = this.mUidPolicy.valueAt(i5);     // Catch: Throwable -> L17
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(uid);     // Catch: Throwable -> L17
        fout.print(" policy=");     // Catch: Throwable -> L17
        fout.print(NetworkPolicyManager.uidPoliciesToString(policy));     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i5 = i5 + 1;     // Catch: Throwable -> L17
        goto L51
    L53:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        int size2 = this.mPowerSaveWhitelistExceptIdleAppIds.size();     // Catch: Throwable -> L17
        if (size2 <= 0) goto L59;
        fout.println("Power save whitelist (except idle) app ids:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i6 = 0;
    L56:
        if (i6 >= size2) goto L58;
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(this.mPowerSaveWhitelistExceptIdleAppIds.keyAt(i6));     // Catch: Throwable -> L17
        fout.print(": ");     // Catch: Throwable -> L17
        fout.print(this.mPowerSaveWhitelistExceptIdleAppIds.valueAt(i6));     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i6 = i6 + 1;     // Catch: Throwable -> L17
        goto L56
    L58:
        fout.decreaseIndent();     // Catch: Throwable -> L17
    L59:
        int size3 = this.mPowerSaveWhitelistAppIds.size();     // Catch: Throwable -> L17
        if (size3 <= 0) goto L65;
        fout.println("Power save whitelist app ids:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i7 = 0;
    L62:
        if (i7 >= size3) goto L64;
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(this.mPowerSaveWhitelistAppIds.keyAt(i7));     // Catch: Throwable -> L17
        fout.print(": ");     // Catch: Throwable -> L17
        fout.print(this.mPowerSaveWhitelistAppIds.valueAt(i7));     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i7 = i7 + 1;     // Catch: Throwable -> L17
        goto L62
    L64:
        fout.decreaseIndent();     // Catch: Throwable -> L17
    L65:
        int size4 = this.mAppIdleTempWhitelistAppIds.size();     // Catch: Throwable -> L17
        if (size4 <= 0) goto L71;
        fout.println("App idle whitelist app ids:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i8 = 0;
    L68:
        if (i8 >= size4) goto L70;
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(this.mAppIdleTempWhitelistAppIds.keyAt(i8));     // Catch: Throwable -> L17
        fout.print(": ");     // Catch: Throwable -> L17
        fout.print(this.mAppIdleTempWhitelistAppIds.valueAt(i8));     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i8 = i8 + 1;     // Catch: Throwable -> L17
        goto L68
    L70:
        fout.decreaseIndent();     // Catch: Throwable -> L17
    L71:
        int size5 = this.mDefaultRestrictBackgroundAllowlistUids.size();     // Catch: Throwable -> L17
        if (size5 <= 0) goto L77;
        fout.println("Default restrict background allowlist uids:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i9 = 0;
    L74:
        if (i9 >= size5) goto L76;
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(this.mDefaultRestrictBackgroundAllowlistUids.keyAt(i9));     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i9 = i9 + 1;     // Catch: Throwable -> L17
        goto L74
    L76:
        fout.decreaseIndent();     // Catch: Throwable -> L17
    L77:
        int size6 = this.mRestrictBackgroundAllowlistRevokedUids.size();     // Catch: Throwable -> L17
        if (size6 <= 0) goto L83;
        fout.println("Default restrict background allowlist uids revoked by users:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i10 = 0;
    L80:
        if (i10 >= size6) goto L82;
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(this.mRestrictBackgroundAllowlistRevokedUids.keyAt(i10));     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i10 = i10 + 1;     // Catch: Throwable -> L17
        goto L80
    L82:
        fout.decreaseIndent();     // Catch: Throwable -> L17
    L83:
        int size7 = this.mLowPowerStandbyAllowlistUids.size();     // Catch: Throwable -> L17
        if (size7 <= 0) goto L89;
        fout.println("Low Power Standby allowlist uids:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i11 = 0;
    L86:
        if (i11 >= size7) goto L88;
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(this.mLowPowerStandbyAllowlistUids.keyAt(i11));     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i11 = i11 + 1;     // Catch: Throwable -> L17
        goto L86
    L88:
        fout.decreaseIndent();     // Catch: Throwable -> L17
    L89:
        fout.println();     // Catch: Throwable -> L17
        if (this.mUseDifferentDelaysForBackgroundChain == false) goto L92;
        fout.print("Background restrictions short delay: ");     // Catch: Throwable -> L17
        TimeUtils.formatDuration(this.mBackgroundRestrictionShortDelayMs, fout);     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.print("Background restrictions long delay: ");     // Catch: Throwable -> L17
        TimeUtils.formatDuration(this.mBackgroundRestrictionLongDelayMs, fout);     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
    L92:
        int size8 = this.mBackgroundTransitioningUids.size();     // Catch: Throwable -> L17
        if (size8 <= 0) goto L98;
        long nowUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        fout.println("Uids transitioning to background:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i12 = 0;
    L95:
        if (i12 >= size8) goto L97;
        fout.print("UID=");     // Catch: Throwable -> L17
        fout.print(this.mBackgroundTransitioningUids.keyAt(i12));     // Catch: Throwable -> L17
        fout.print(", ");     // Catch: Throwable -> L17
        TimeUtils.formatDuration(this.mBackgroundTransitioningUids.valueAt(i12), nowUptime, fout);     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        i12 = i12 + 1;     // Catch: Throwable -> L17
        goto L95
    L97:
        fout.decreaseIndent();     // Catch: Throwable -> L17
    L98:
        fout.println();     // Catch: Throwable -> L17
        SparseBooleanArray knownUids = new SparseBooleanArray();     // Catch: Throwable -> L17
        collectKeys(this.mUidState, knownUids);     // Catch: Throwable -> L17
        SparseArray<UidBlockedState> r10 = this.mUidBlockedState;     // Catch: Throwable -> L17
        monitor-enter(r10);     // Catch: Throwable -> L17
        collectKeys(this.mUidBlockedState, knownUids);     // Catch: Throwable -> L139
        monitor-exit(r10);     // Catch: Throwable -> L139
        SparseArray<UidStateCallbackInfo> r11 = this.mUidStateCallbackInfos;     // Catch: Throwable -> L17
        monitor-enter(r11);     // Catch: Throwable -> L17
        collectKeys(this.mUidStateCallbackInfos, knownUids);     // Catch: Throwable -> L136
        monitor-exit(r11);     // Catch: Throwable -> L136
        fout.println("Status for all known UIDs:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int size9 = knownUids.size();     // Catch: Throwable -> L17
        int i13 = 0;
    L107:
        if (i13 >= size9) goto L124;
        int uid2 = knownUids.keyAt(i13);     // Catch: Throwable -> L17
        fout.print("UID", Integer.valueOf(uid2));     // Catch: Throwable -> L17
        NetworkPolicyManager.UidState uidState = this.mUidState.get(uid2);     // Catch: Throwable -> L17
        fout.print("state", uidState);     // Catch: Throwable -> L17
        SparseArray<UidBlockedState> r12 = this.mUidBlockedState;     // Catch: Throwable -> L17
        monitor-enter(r12);     // Catch: Throwable -> L17
        UidBlockedState uidBlockedState = this.mUidBlockedState.get(uid2);     // Catch: Throwable -> L121
        fout.print("blocked_state", uidBlockedState);     // Catch: Throwable -> L121
        monitor-exit(r12);     // Catch: Throwable -> L121
        SparseArray<UidStateCallbackInfo> r13 = this.mUidStateCallbackInfos;     // Catch: Throwable -> L17
        monitor-enter(r13);     // Catch: Throwable -> L17
        UidStateCallbackInfo callbackInfo = this.mUidStateCallbackInfos.get(uid2);     // Catch: Throwable -> L118
        fout.println();     // Catch: Throwable -> L118
        fout.increaseIndent();     // Catch: Throwable -> L118
        fout.print("callback_info", callbackInfo);     // Catch: Throwable -> L118
        fout.decreaseIndent();     // Catch: Throwable -> L118
        monitor-exit(r13);     // Catch: Throwable -> L118
        fout.println();     // Catch: Throwable -> L17
        i13 = i13 + 1;
        goto L107
    L118:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L121:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L124:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.println("Admin restricted uids for metered data:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int size10 = this.mMeteredRestrictedUids.size();     // Catch: Throwable -> L17
        int i14 = 0;
    L125:
        if (i14 >= size10) goto L127;
        fout.print("u" + this.mMeteredRestrictedUids.keyAt(i14) + ": ");     // Catch: Throwable -> L17
        fout.println(this.mMeteredRestrictedUids.valueAt(i14));     // Catch: Throwable -> L17
        i14 = i14 + 1;     // Catch: Throwable -> L17
        goto L125
    L127:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.println("Network to interfaces:");     // Catch: Throwable -> L17
        fout.increaseIndent();     // Catch: Throwable -> L17
        int i15 = 0;
    L129:
        if (i15 >= this.mNetworkToIfaces.size()) goto L131;
        int key = this.mNetworkToIfaces.keyAt(i15);     // Catch: Throwable -> L17
        fout.println(key + ": " + this.mNetworkToIfaces.get(key));     // Catch: Throwable -> L17
        i15 = i15 + 1;     // Catch: Throwable -> L17
        goto L129
    L131:
        fout.decreaseIndent();     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        fout.print("Active notifications: ");     // Catch: Throwable -> L17
        fout.println(this.mActiveNotifs);     // Catch: Throwable -> L17
        fout.println();     // Catch: Throwable -> L17
        this.mStatLogger.dump(fout);     // Catch: Throwable -> L17
        this.mLogger.dumpLogs(fout);     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L23
        fout.println();
        this.mMultipathPolicyTracker.dump(fout);
        return;
    L136:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L139:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L142:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L23:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
        return new NetworkPolicyManagerShellCommand(this.mContext, this).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
    }

    void setDebugUid(int uid) {
        this.mLogger.setDebugUid(uid);
    }

    boolean isUidForegroundOnRestrictBackgroundUL(int uid) {
        NetworkPolicyManager.UidState uidState = this.mUidState.get(uid);
        if (NetworkPolicyManager.isProcStateAllowedWhileOnRestrictBackground(uidState) == false) goto L6;
        return true;
    L6:
        SparseArray<UidStateCallbackInfo> r1 = this.mUidStateCallbackInfos;
        monitor-enter(r1);
        UidStateCallbackInfo callbackInfo = this.mUidStateCallbackInfos.get(uid);     // Catch: Throwable -> L11
        if (uidState == null) goto L13;
        long prevProcStateSeq = uidState.procStateSeq;     // Catch: Throwable -> L11
    L14:
        if (callbackInfo != null) goto L16;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return false;
    L16:
        if (callbackInfo.isPending == false) goto L22;
        if (callbackInfo.procStateSeq < prevProcStateSeq) goto L22;
        boolean r5 = NetworkPolicyManager.isProcStateAllowedWhileOnRestrictBackground(callbackInfo.procState, callbackInfo.capability);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r5;
    L13:
        prevProcStateSeq = -1;
    L11:
        th = move-exception;
        throw th;
    }

    boolean isUidForegroundOnRestrictPowerUL(int uid) {
        NetworkPolicyManager.UidState uidState = this.mUidState.get(uid);
        if (NetworkPolicyManager.isProcStateAllowedWhileIdleOrPowerSaveMode(uidState) == false) goto L6;
        return true;
    L6:
        SparseArray<UidStateCallbackInfo> r1 = this.mUidStateCallbackInfos;
        monitor-enter(r1);
        UidStateCallbackInfo callbackInfo = this.mUidStateCallbackInfos.get(uid);     // Catch: Throwable -> L11
        if (uidState == null) goto L13;
        long prevProcStateSeq = uidState.procStateSeq;     // Catch: Throwable -> L11
    L14:
        if (callbackInfo != null) goto L16;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return false;
    L16:
        if (callbackInfo.isPending == false) goto L22;
        if (callbackInfo.procStateSeq < prevProcStateSeq) goto L22;
        boolean r5 = NetworkPolicyManager.isProcStateAllowedWhileIdleOrPowerSaveMode(callbackInfo.procState, callbackInfo.capability);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r5;
    L13:
        prevProcStateSeq = -1;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isUidTop(int uid) {
        NetworkPolicyManager.UidState uidState = this.mUidState.get(uid);
        return NetworkPolicyManager.isProcStateAllowedWhileInLowPowerStandby(uidState);
    }

    private boolean isUidExemptFromBackgroundRestrictions(int uid) {
        if (this.mBackgroundTransitioningUids.indexOfKey(uid) < 0) goto L5;
    L8:
        return true;
    L5:
        if (NetworkPolicyManager.isProcStateAllowedNetworkWhileBackground(this.mUidState.get(uid)) == true) goto L8;
        return false;
    }

    private long getBackgroundTransitioningDelay(int procState) {
        if (this.mUseDifferentDelaysForBackgroundChain == false) goto L10;
        if (procState > 15) goto L8;
        return this.mBackgroundRestrictionLongDelayMs;
    L8:
        return this.mBackgroundRestrictionShortDelayMs;
    L10:
        return this.mBackgroundRestrictionDelayMs;
    }

    private boolean updateUidStateUL(int uid, int procState, long procStateSeq, int capability) {
        Trace.traceBegin(2097152, "updateUidStateUL: " + uid + SliceClientPermissions.SliceAuthority.DELIMITER + ActivityManager.procStateToString(procState) + SliceClientPermissions.SliceAuthority.DELIMITER + procStateSeq + SliceClientPermissions.SliceAuthority.DELIMITER + ActivityManager.getCapabilitiesSummary(capability));
        NetworkPolicyManager.UidState oldUidState = this.mUidState.get(uid);     // Catch: Throwable -> L11
        boolean allowedInLpsChanged = false;
        if (oldUidState != null) goto L6;
    L15:
        if (oldUidState != null) goto L17;
    L23:
        NetworkPolicyManager.UidState newUidState = new NetworkPolicyManager.UidState(uid, procState, procStateSeq, capability);     // Catch: Throwable -> L11
        this.mUidState.put(uid, newUidState);     // Catch: Throwable -> L11
        updateRestrictBackgroundRulesOnUidStatusChangedUL(uid, oldUidState, newUidState);     // Catch: Throwable -> L11
        boolean updatePowerRestrictionRules = false;
        if (NetworkPolicyManager.isProcStateAllowedWhileIdleOrPowerSaveMode(oldUidState) == NetworkPolicyManager.isProcStateAllowedWhileIdleOrPowerSaveMode(newUidState)) goto L26;
        boolean allowedWhileIdleOrPowerSaveModeChanged = true;
    L27:
        if (allowedWhileIdleOrPowerSaveModeChanged == false) goto L35;
        updateRuleForAppIdleUL(uid, procState);     // Catch: Throwable -> L11
        if (this.mDeviceIdleMode == false) goto L32;
        updateRuleForDeviceIdleUL(uid);     // Catch: Throwable -> L11
    L32:
        if (this.mRestrictPower == false) goto L34;
        updateRuleForRestrictPowerUL(uid);     // Catch: Throwable -> L11
    L34:
        updatePowerRestrictionRules = true;
    L35:
        boolean wasAllowed = NetworkPolicyManager.isProcStateAllowedNetworkWhileBackground(oldUidState);     // Catch: Throwable -> L11
        boolean isAllowed = NetworkPolicyManager.isProcStateAllowedNetworkWhileBackground(newUidState);     // Catch: Throwable -> L11
        if (wasAllowed == true) goto L39;
        if (isAllowed == false) goto L39;
        this.mBackgroundTransitioningUids.delete(uid);     // Catch: Throwable -> L11
        updateRuleForBackgroundUL(uid);     // Catch: Throwable -> L11
        updatePowerRestrictionRules = true;
        long r17 = 2097152;
    L61:
        if (this.mLowPowerStandbyActive == true) goto L63;
    L67:
        if (updatePowerRestrictionRules == false) goto L69;
        updateRulesForPowerRestrictionsUL(uid, procState);     // Catch: Throwable -> L46
    L69:
        Trace.traceEnd(r17);
        return true;
    L63:
        if (NetworkPolicyManager.isProcStateAllowedWhileInLowPowerStandby(oldUidState) == NetworkPolicyManager.isProcStateAllowedWhileInLowPowerStandby(newUidState)) goto L65;
        allowedInLpsChanged = true;
    L65:
        if (allowedInLpsChanged == false) goto L67;
        updateRuleForLowPowerStandbyUL(uid);     // Catch: Throwable -> L46
        updatePowerRestrictionRules = true;
    L39:
        if (isAllowed == true) goto L59;
        int transitionIdx = this.mBackgroundTransitioningUids.indexOfKey(uid);     // Catch: Throwable -> L11
        long completionTimeMs = SystemClock.uptimeMillis() + getBackgroundTransitioningDelay(procState);
        boolean completionTimeUpdated = false;
        if (wasAllowed == false) goto L49;
        if (transitionIdx >= 0) goto L48;
        r17 = 2097152;
        this.mBackgroundTransitioningUids.put(uid, completionTimeMs);     // Catch: Throwable -> L46
        completionTimeUpdated = true;
    L55:
        if (completionTimeUpdated == false) goto L61;
        if (completionTimeMs >= this.mNextProcessBackgroundUidsTime) goto L61;
        this.mHandler.removeMessages(24);     // Catch: Throwable -> L46
        this.mHandler.sendEmptyMessageAtTime(24, completionTimeMs);     // Catch: Throwable -> L46
        this.mNextProcessBackgroundUidsTime = completionTimeMs;     // Catch: Throwable -> L46
        goto L61
    L48:
        r17 = 2097152;
        goto L55
    L49:
        r17 = 2097152;
        if (this.mUseDifferentDelaysForBackgroundChain == false) goto L55;
        if (transitionIdx < 0) goto L55;
        if (completionTimeMs >= this.mBackgroundTransitioningUids.valueAt(transitionIdx)) goto L55;
        this.mBackgroundTransitioningUids.setValueAt(transitionIdx, completionTimeMs);     // Catch: Throwable -> L46
        completionTimeUpdated = true;
        goto L55
    L59:
        r17 = 2097152;
    L46:
        th = th;
    L71:
        Trace.traceEnd(r17);
        throw th;
    L26:
        allowedWhileIdleOrPowerSaveModeChanged = false;
        goto L27
    L17:
        if (oldUidState.procState != procState) goto L23;
        if (oldUidState.capability != capability) goto L23;
        Trace.traceEnd(2097152);
        return false;
    L6:
        if (procStateSeq >= oldUidState.procStateSeq) goto L15;
        if (LOGV == false) goto L13;
        Slog.v(TAG, "Ignoring older uid state updates; uid=" + uid + ",procState=" + ActivityManager.procStateToString(procState) + ",seq=" + procStateSeq + ",cap=" + capability + ",oldUidState=" + oldUidState);     // Catch: Throwable -> L11
    L13:
        Trace.traceEnd(2097152);
        return false;
    L11:
        th = th;
        r17 = 2097152;
        goto L71
    }

    private boolean removeUidStateUL(int uid) {
        int index = this.mUidState.indexOfKey(uid);
        if (index < 0) goto L17;
        NetworkPolicyManager.UidState oldUidState = this.mUidState.valueAt(index);
        this.mUidState.removeAt(index);
        if (oldUidState == null) goto L20;
        updateRestrictBackgroundRulesOnUidStatusChangedUL(uid, oldUidState, null);
        if (this.mDeviceIdleMode == false) goto L10;
        updateRuleForDeviceIdleUL(uid);
    L10:
        if (this.mRestrictPower == false) goto L12;
        updateRuleForRestrictPowerUL(uid);
    L12:
        this.mBackgroundTransitioningUids.delete(uid);
        updateRuleForBackgroundUL(uid);
        updateRulesForPowerRestrictionsUL(uid);
        if (this.mLowPowerStandbyActive == false) goto L19;
        updateRuleForLowPowerStandbyUL(uid);
        return true;
    L19:
        return true;
    L20:
        return false;
    L17:
        return false;
    }

    private void updateNetworkStats(int uid, boolean uidForeground) {
        if (Trace.isTagEnabled(2097152) == false) goto L15;
        StringBuilder r2 = new StringBuilder();
        r2.append("updateNetworkStats: ");
        r2.append(uid);
        r2.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        if (uidForeground == false) goto L7;
        String r3 = "F";
    L8:
        r2.append(r3);
        Trace.traceBegin(2097152, r2.toString());
        goto L15
    L7:
        r3 = "B";
    L15:
        this.mNetworkStats.noteUidForeground(uid, uidForeground);     // Catch: Throwable -> L12
        Trace.traceEnd(2097152);
        return;
    L12:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void updateRestrictBackgroundRulesOnUidStatusChangedUL(int uid, NetworkPolicyManager.UidState oldUidState, NetworkPolicyManager.UidState newUidState) {
        boolean oldForeground = NetworkPolicyManager.isProcStateAllowedWhileOnRestrictBackground(oldUidState);
        boolean newForeground = NetworkPolicyManager.isProcStateAllowedWhileOnRestrictBackground(newUidState);
        if (oldForeground == newForeground) goto L6;
        updateRulesForDataUsageRestrictionsUL(uid);
        return;
    }

    boolean isRestrictedModeEnabled() {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        boolean r1 = this.mRestrictedNetworkingMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void updateRestrictedModeAllowlistUL() {
        final SparseIntArray uidRules = new SparseIntArray();
        forEachUid("updateRestrictedModeAllowlist", new NetworkPolicyManagerService$$ExternalSyntheticLambda6(this, uidRules));
        if (this.mRestrictedNetworkingMode == false) goto L5;
        setUidFirewallRulesUL(4, uidRules);
    L5:
        enableFirewallChainUL(4, this.mRestrictedNetworkingMode);
    }

    private /* synthetic */ void lambda$updateRestrictedModeAllowlistUL$3(SparseIntArray uidRules, int uid) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        int effectiveBlockedReasons = updateBlockedReasonsForRestrictedModeUL(uid);     // Catch: Throwable -> L7
        int newFirewallRule = getRestrictedModeFirewallRule(effectiveBlockedReasons);     // Catch: Throwable -> L7
        if (newFirewallRule == 0) goto L9;
        uidRules.append(uid, newFirewallRule);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateRestrictedModeForUidUL(int uid) {
        int effectiveBlockedReasons = updateBlockedReasonsForRestrictedModeUL(uid);
        if (this.mRestrictedNetworkingMode == false) goto L6;
        setUidFirewallRuleUL(4, uid, getRestrictedModeFirewallRule(effectiveBlockedReasons));
        return;
    }

    private int updateBlockedReasonsForRestrictedModeUL(int uid) {
        boolean hasRestrictedModeAccess = hasRestrictedModeAccess(uid);
        SparseArray<UidBlockedState> r1 = this.mUidBlockedState;
        monitor-enter(r1);
        UidBlockedState uidBlockedState = getOrCreateUidBlockedStateForUid(this.mUidBlockedState, uid);     // Catch: Throwable -> L7
        int oldEffectiveBlockedReasons = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L7
        if (this.mRestrictedNetworkingMode == false) goto L9;
        uidBlockedState.blockedReasons |= 8;     // Catch: Throwable -> L7
    L10:
        if (hasRestrictedModeAccess == false) goto L12;
        uidBlockedState.allowedReasons |= 16;     // Catch: Throwable -> L7
    L13:
        uidBlockedState.updateEffectiveBlockedReasons();     // Catch: Throwable -> L7
        int newEffectiveBlockedReasons = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L7
        if (oldEffectiveBlockedReasons != newEffectiveBlockedReasons) goto L16;
        int uidRules = 0;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L7
        if (oldEffectiveBlockedReasons == newEffectiveBlockedReasons) goto L21;
        handleBlockedReasonsChanged(uid, newEffectiveBlockedReasons, oldEffectiveBlockedReasons);
        postUidRulesChangedMsg(uid, uidRules);
    L21:
        return newEffectiveBlockedReasons;
    L16:
        uidRules = uidBlockedState.deriveUidRules();     // Catch: Throwable -> L7
        goto L18
    L12:
        uidBlockedState.allowedReasons &= -17;     // Catch: Throwable -> L7
        goto L13
    L9:
        uidBlockedState.blockedReasons &= -9;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private static int getRestrictedModeFirewallRule(int effectiveBlockedReasons) {
        if ((effectiveBlockedReasons & 8) == 0) goto L6;
        return 0;
    L6:
        return 1;
    }

    private boolean hasRestrictedModeAccess(int uid) {
        if (this.mIPm.checkUidPermission("android.permission.CONNECTIVITY_USE_RESTRICTED_NETWORKS", uid) != 0) goto L6;
    L12:
        return true;
    L6:
        if (this.mIPm.checkUidPermission("android.permission.NETWORK_STACK", uid) == 0) goto L12;
        if (this.mIPm.checkUidPermission("android.permission.MAINLINE_NETWORK_STACK", uid) == 0) goto L12;
        return false;
    L15:
        return false;
    }

    void updateRulesForPowerSaveUL() {
        Trace.traceBegin(2097152, "updateRulesForPowerSaveUL");
        updateRulesForAllowlistedPowerSaveUL(this.mRestrictPower, 3);     // Catch: Throwable -> L6
        Trace.traceEnd(2097152);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    void updateRuleForRestrictPowerUL(int uid) {
        updateRulesForAllowlistedPowerSaveUL(uid, this.mRestrictPower, 3);
    }

    void updateRulesForDeviceIdleUL() {
        Trace.traceBegin(2097152, "updateRulesForDeviceIdleUL");
        updateRulesForAllowlistedPowerSaveUL(this.mDeviceIdleMode, 1);     // Catch: Throwable -> L6
        Trace.traceEnd(2097152);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    void updateRuleForDeviceIdleUL(int uid) {
        updateRulesForAllowlistedPowerSaveUL(uid, this.mDeviceIdleMode, 1);
    }

    private void updateRulesForAllowlistedPowerSaveUL(boolean enabled, int chain) {
        if (enabled == false) goto L16;
        SparseIntArray uidRules = new SparseIntArray();
        List<UserInfo> users = this.mUserManager.getUsers();
        int ui = users.size() - 1;
    L4:
        if (ui < 0) goto L9;
        UserInfo user = users.get(ui);
        updateRulesForAllowlistedAppIds(uidRules, this.mPowerSaveTempWhitelistAppIds, user.id);
        updateRulesForAllowlistedAppIds(uidRules, this.mPowerSaveWhitelistAppIds, user.id);
        if (chain != 3) goto L8;
        updateRulesForAllowlistedAppIds(uidRules, this.mPowerSaveWhitelistExceptIdleAppIds, user.id);
    L8:
        ui = ui - 1;
        goto L4
    L9:
        int i = this.mUidState.size() - 1;
    L10:
        if (i < 0) goto L15;
        if (NetworkPolicyManager.isProcStateAllowedWhileIdleOrPowerSaveMode(this.mUidState.valueAt(i)) == false) goto L14;
        uidRules.put(this.mUidState.keyAt(i), 1);
    L14:
        i = i - 1;
        goto L10
    L15:
        setUidFirewallRulesUL(chain, uidRules, 1);
        return;
    L16:
        setUidFirewallRulesUL(chain, null, 2);
    }

    private void updateRulesForBackgroundChainUL() {
        Trace.traceBegin(2097152, "updateRulesForBackgroundChainUL");
        SparseIntArray uidRules = new SparseIntArray();     // Catch: Throwable -> L6
        List<UserInfo> users = this.mUserManager.getUsers();     // Catch: Throwable -> L6
        int ui = users.size() - 1;     // Catch: Throwable -> L6
    L4:
        if (ui < 0) goto L8;
        UserInfo user = users.get(ui);     // Catch: Throwable -> L6
        updateRulesForAllowlistedAppIds(uidRules, this.mPowerSaveTempWhitelistAppIds, user.id);     // Catch: Throwable -> L6
        updateRulesForAllowlistedAppIds(uidRules, this.mPowerSaveWhitelistAppIds, user.id);     // Catch: Throwable -> L6
        updateRulesForAllowlistedAppIds(uidRules, this.mPowerSaveWhitelistExceptIdleAppIds, user.id);     // Catch: Throwable -> L6
        ui = ui - 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        int i = this.mUidState.size() - 1;     // Catch: Throwable -> L6
    L9:
        if (i < 0) goto L16;
        if (this.mBackgroundTransitioningUids.indexOfKey(this.mUidState.keyAt(i)) < 0) goto L13;
    L14:
        uidRules.put(this.mUidState.keyAt(i), 1);     // Catch: Throwable -> L6
    L15:
        i = i - 1;     // Catch: Throwable -> L6
        goto L9
    L13:
        if (NetworkPolicyManager.isProcStateAllowedNetworkWhileBackground(this.mUidState.valueAt(i)) == false) goto L15;
    L16:
        setUidFirewallRulesUL(6, uidRules);     // Catch: Throwable -> L6
        Trace.traceEnd(2097152);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void updateRulesForAllowlistedAppIds(SparseIntArray uidRules, SparseBooleanArray allowlistedAppIds, int userId) {
        int i = allowlistedAppIds.size() - 1;
    L3:
        if (i < 0) goto L9;
        if (allowlistedAppIds.valueAt(i) == false) goto L7;
        int appId = allowlistedAppIds.keyAt(i);
        int uid = UserHandle.getUid(userId, appId);
        uidRules.put(uid, 1);
    L7:
        i = i - 1;
        goto L3
    }

    void updateRulesForLowPowerStandbyUL() {
        Trace.traceBegin(2097152, "updateRulesForLowPowerStandbyUL");
    L12:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    L4:
        if (this.mLowPowerStandbyActive == false) goto L16;
        SparseIntArray uidRules = new SparseIntArray();     // Catch: Throwable -> L12
        int i = this.mUidState.size() - 1;     // Catch: Throwable -> L12
    L6:
        if (i < 0) goto L15;
        int uid = this.mUidState.keyAt(i);     // Catch: Throwable -> L12
        int effectiveBlockedReasons = getEffectiveBlockedReasons(uid);     // Catch: Throwable -> L12
        if (hasInternetPermissionUL(uid) == false) goto L14;
        if ((effectiveBlockedReasons & 32) != 0) goto L14;
        uidRules.put(uid, 1);     // Catch: Throwable -> L12
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L6
    L15:
        setUidFirewallRulesUL(5, uidRules, 1);     // Catch: Throwable -> L12
    L17:
        Trace.traceEnd(2097152);
        return;
    L16:
        setUidFirewallRulesUL(5, null, 2);     // Catch: Throwable -> L12
        goto L17
    }

    void updateRuleForLowPowerStandbyUL(int uid) {
        if (hasInternetPermissionUL(uid) == true) goto L5;
        return;
    L5:
        int effectiveBlockedReasons = getEffectiveBlockedReasons(uid);
        if (this.mUidState.contains(uid) == true) goto L8;
    L10:
        setUidFirewallRuleUL(5, uid, 0);
        return;
    L8:
        if ((effectiveBlockedReasons & 32) != 0) goto L10;
        setUidFirewallRuleUL(5, uid, 1);
    }

    private boolean isAllowlistedFromPowerSaveUL(int uid, boolean deviceIdleMode) {
        int appId = UserHandle.getAppId(uid);
        boolean r2 = true;
        if (this.mPowerSaveTempWhitelistAppIds.get(appId) == false) goto L5;
    L8:
        boolean allowlisted = true;
    L10:
        if (deviceIdleMode == true) goto L18;
        if (allowlisted == false) goto L13;
    L16:
        boolean allowlisted2 = r2;
        return allowlisted2;
    L13:
        if (isAllowlistedFromPowerSaveExceptIdleUL(uid) == true) goto L16;
        r2 = false;
        goto L16
    L18:
        return allowlisted;
    L5:
        if (this.mPowerSaveWhitelistAppIds.get(appId) == true) goto L8;
        allowlisted = false;
        goto L10
    }

    private boolean isAllowlistedFromPowerSaveExceptIdleUL(int uid) {
        int appId = UserHandle.getAppId(uid);
        return this.mPowerSaveWhitelistExceptIdleAppIds.get(appId);
    }

    private boolean isAllowlistedFromLowPowerStandbyUL(int uid) {
        return this.mLowPowerStandbyAllowlistUids.get(uid);
    }

    private void updateRulesForAllowlistedPowerSaveUL(int uid, boolean enabled, int chain) {
        if (enabled == true) goto L4;
        return;
    L4:
        if (chain != 1) goto L6;
        boolean r2 = true;
    L7:
        boolean isWhitelisted = isAllowlistedFromPowerSaveUL(uid, r2);
        if (isWhitelisted == false) goto L10;
    L13:
        setUidFirewallRuleUL(chain, uid, 1);
        return;
    L10:
        if (isUidForegroundOnRestrictPowerUL(uid) == true) goto L13;
        setUidFirewallRuleUL(chain, uid, 0);
        return;
    L6:
        r2 = false;
        goto L7
    }

    void updateRulesForAppIdleUL() {
        Trace.traceBegin(2097152, "updateRulesForAppIdleUL");
        SparseIntArray uidRules = this.mUidFirewallStandbyRules;     // Catch: Throwable -> L15
        uidRules.clear();     // Catch: Throwable -> L15
        List<UserInfo> users = this.mUserManager.getUsers();     // Catch: Throwable -> L15
        int ui = users.size() - 1;     // Catch: Throwable -> L15
    L5:
        if (ui < 0) goto L24;
        UserInfo user = users.get(ui);     // Catch: Throwable -> L15
        int[] idleUids = this.mUsageStats.getIdleUidsForUser(user.id);     // Catch: Throwable -> L15
        int r9 = idleUids.length;     // Catch: Throwable -> L15
        int r10 = 0;
    L7:
        if (r10 >= r9) goto L23;
        int uid = idleUids[r10];     // Catch: Throwable -> L15
        if (this.mPowerSaveTempWhitelistAppIds.get(UserHandle.getAppId(uid), false) == true) goto L22;
        if (this.mNeverApplyRulesToCoreUids == false) goto L18;
        if (isUidValidForRulesUL(uid) == false) goto L22;
    L18:
        if (hasInternetPermissionUL(uid) == false) goto L22;
        if (isUidForegroundOnRestrictPowerUL(uid) == true) goto L22;
        uidRules.put(uid, 2);     // Catch: Throwable -> L15
    L22:
        r10 = r10 + 1;     // Catch: Throwable -> L15
        goto L7
    L23:
        ui = ui - 1;     // Catch: Throwable -> L15
        goto L5
    L24:
        setUidFirewallRulesUL(2, uidRules.clone(), 0);     // Catch: Throwable -> L15
        Trace.traceEnd(2097152);
        return;
    L15:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    void updateRuleForAppIdleUL(int uid, int uidProcessState) {
        if (isUidValidForDenylistRulesUL(uid) == true) goto L6;
        return;
    L6:
        if (Trace.isTagEnabled(2097152) == false) goto L27;
        Trace.traceBegin(2097152, "updateRuleForAppIdleUL: " + uid);
    L27:
        int appId = UserHandle.getAppId(uid);     // Catch: Throwable -> L18
        if (this.mPowerSaveTempWhitelistAppIds.get(appId) == false) goto L12;
    L20:
        setUidFirewallRuleUL(2, uid, 0);     // Catch: Throwable -> L18
        if (LOGD == false) goto L23;
        Log.d(TAG, "updateRuleForAppIdleUL " + uid + " to DEFAULT");     // Catch: Throwable -> L18
    L23:
        Trace.traceEnd(2097152);
        return;
    L12:
        if (isUidIdle(uid, uidProcessState) == false) goto L20;
        if (isUidForegroundOnRestrictPowerUL(uid) == true) goto L20;
        setUidFirewallRuleUL(2, uid, 2);     // Catch: Throwable -> L18
        if (LOGD == false) goto L23;
        Log.d(TAG, "updateRuleForAppIdleUL DENY " + uid);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    void updateRuleForBackgroundUL(int uid) {
        if (isUidValidForAllowlistRulesUL(uid) == true) goto L5;
        return;
    L5:
        Trace.traceBegin(2097152, "updateRuleForBackgroundUL: " + uid);
    L15:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    L8:
        if (isAllowlistedFromPowerSaveUL(uid, false) == false) goto L10;
    L17:
        setUidFirewallRuleUL(6, uid, 1);     // Catch: Throwable -> L15
        if (LOGD == false) goto L20;
        Log.d(TAG, "updateRuleForBackgroundUL ALLOW " + uid);     // Catch: Throwable -> L15
    L20:
        Trace.traceEnd(2097152);
        return;
    L10:
        if (isUidExemptFromBackgroundRestrictions(uid) == true) goto L17;
        setUidFirewallRuleUL(6, uid, 0);     // Catch: Throwable -> L15
        if (LOGD == false) goto L20;
        Log.d(TAG, "updateRuleForBackgroundUL " + uid + " to DEFAULT");     // Catch: Throwable -> L15
        goto L20
    }

    private void updateRulesForAppIdleParoleUL() {
        boolean r0 = this.mAppStandby.isInParole();
        boolean r1 = !r0;
        int r2 = this.mUidFirewallStandbyRules.size();
        SparseIntArray r3 = new SparseIntArray();
        int r4 = 0;
    L3:
        int r6 = 1;
        boolean r7 = true;
        if (r4 >= r2) goto L29;
        int r8 = this.mUidFirewallStandbyRules.keyAt(r4);
        if (isUidValidForDenylistRulesUL(r8) == false) goto L27;
        int r9 = getBlockedReasons(r8);
        if (r1 == true) goto L14;
        if ((65535 & r9) == 0) goto L27;
    L14:
        if (r0 == false) goto L16;
    L18:
        r7 = false;
    L19:
        if (r7 == true) goto L21;
    L25:
        this.mUidFirewallStandbyRules.put(r8, 0);
    L26:
        updateRulesForPowerRestrictionsUL(r8, r7);
        goto L27
    L21:
        if (this.mPowerSaveTempWhitelistAppIds.get(UserHandle.getAppId(r8)) == true) goto L25;
        if (isUidForegroundOnRestrictPowerUL(r8) == true) goto L25;
        this.mUidFirewallStandbyRules.put(r8, 2);
        r3.put(r8, 2);
        goto L26
    L16:
        if (isUidIdle(r8) == false) goto L18;
    L27:
        r4 = r4 + 1;
        goto L3
    L29:
        if (r1 == true) goto L32;
        r6 = 2;
    L32:
        setUidFirewallRulesUL(2, r3, r6);
    }

    private void updateRulesForGlobalChangeAL(boolean restrictedNetworksChanged) {
        if (Trace.isTagEnabled(2097152) == false) goto L19;
        StringBuilder r2 = new StringBuilder();
        r2.append("updateRulesForGlobalChangeAL: ");
        if (restrictedNetworksChanged == false) goto L7;
        String r3 = "R";
    L8:
        r2.append(r3);
        Trace.traceBegin(2097152, r2.toString());
        goto L19
    L7:
        r3 = "-";
    L19:
        updateRulesForBackgroundChainUL();     // Catch: Throwable -> L13
        updateRulesForAppIdleUL();     // Catch: Throwable -> L13
        updateRulesForRestrictPowerUL();     // Catch: Throwable -> L13
        updateRulesForRestrictBackgroundUL();     // Catch: Throwable -> L13
        updateRestrictedModeAllowlistUL();     // Catch: Throwable -> L13
        if (restrictedNetworksChanged == false) goto L15;
        normalizePoliciesNL();     // Catch: Throwable -> L13
        updateNetworkRulesNL();     // Catch: Throwable -> L13
    L15:
        Trace.traceEnd(2097152);
        return;
    L13:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void handleDeviceIdleModeChangedUL(boolean enabled) {
        Trace.traceBegin(2097152, "updateRulesForRestrictPowerUL");
        updateRulesForDeviceIdleUL();     // Catch: Throwable -> L6
        if (enabled == false) goto L8;
        forEachUid("updateRulesForRestrictPower", new NetworkPolicyManagerService$$ExternalSyntheticLambda7(this));     // Catch: Throwable -> L6
    L9:
        Trace.traceEnd(2097152);
        return;
    L8:
        handleDeviceIdleModeDisabledUL();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private /* synthetic */ void lambda$handleDeviceIdleModeChangedUL$4(int uid) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        updateRulesForPowerRestrictionsUL(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleDeviceIdleModeDisabledUL() {
        Trace.traceBegin(2097152, "handleDeviceIdleModeDisabledUL");
        SparseArray<SomeArgs> uidStateUpdates = new SparseArray();     // Catch: Throwable -> L25
        SparseArray<UidBlockedState> r3 = this.mUidBlockedState;     // Catch: Throwable -> L25
        monitor-enter(r3);     // Catch: Throwable -> L25
        int size = this.mUidBlockedState.size();     // Catch: Throwable -> L13
        int i = 0;
    L6:
        if (i >= size) goto L20;
        int uid = this.mUidBlockedState.keyAt(i);     // Catch: Throwable -> L13
        UidBlockedState uidBlockedState = this.mUidBlockedState.valueAt(i);     // Catch: Throwable -> L13
        if ((uidBlockedState.blockedReasons & 2) == 0) goto L18;
        uidBlockedState.blockedReasons &= -3;     // Catch: Throwable -> L13
        int oldEffectiveBlockedReasons = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L13
        uidBlockedState.updateEffectiveBlockedReasons();     // Catch: Throwable -> L13
        if (LOGV == false) goto L16;
        Log.v(TAG, "handleDeviceIdleModeDisabled(" + uid + "); newUidBlockedState=" + uidBlockedState + ", oldEffectiveBlockedReasons=" + oldEffectiveBlockedReasons);     // Catch: Throwable -> L13
    L16:
        if (oldEffectiveBlockedReasons == uidBlockedState.effectiveBlockedReasons) goto L18;
        SomeArgs someArgs = SomeArgs.obtain();     // Catch: Throwable -> L13
        someArgs.argi1 = oldEffectiveBlockedReasons;     // Catch: Throwable -> L13
        someArgs.argi2 = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L13
        someArgs.argi3 = uidBlockedState.deriveUidRules();     // Catch: Throwable -> L13
        uidStateUpdates.append(uid, someArgs);     // Catch: Throwable -> L13
        this.mActivityManagerInternal.onUidBlockedReasonsChanged(uid, uidBlockedState.effectiveBlockedReasons);     // Catch: Throwable -> L13
    L18:
        i = i + 1;     // Catch: Throwable -> L13
        goto L6
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L13
    L22:
        if (uidStateUpdates.size() == 0) goto L27;
        this.mHandler.obtainMessage(23, uidStateUpdates).sendToTarget();     // Catch: Throwable -> L25
    L27:
        Trace.traceEnd(2097152);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void updateRulesForRestrictPowerUL() {
        Trace.traceBegin(2097152, "updateRulesForRestrictPowerUL");
        updateRulesForDeviceIdleUL();     // Catch: Throwable -> L6
        updateRulesForPowerSaveUL();     // Catch: Throwable -> L6
        forEachUid("updateRulesForRestrictPower", new NetworkPolicyManagerService$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L6
        Trace.traceEnd(2097152);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private /* synthetic */ void lambda$updateRulesForRestrictPowerUL$5(int uid) {
        updateRulesForPowerRestrictionsUL(uid);
    }

    protected void updateRulesForRestrictBackgroundUL() {
        Trace.traceBegin(2097152, "updateRulesForRestrictBackgroundUL");
        forEachUid("updateRulesForRestrictBackground", new NetworkPolicyManagerService$$ExternalSyntheticLambda4(this));     // Catch: Throwable -> L6
        Trace.traceEnd(2097152);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private /* synthetic */ void lambda$updateRulesForRestrictBackgroundUL$6(int uid) {
        updateRulesForDataUsageRestrictionsUL(uid);
    }

    private void forEachUid(String tag, final IntConsumer consumer) {
        if (Trace.isTagEnabled(2097152) == false) goto L27;
        Trace.traceBegin(2097152, "forEachUid-" + tag);
    L27:
        Trace.traceBegin(2097152, "list-users");     // Catch: Throwable -> L18
        List<UserInfo> users = this.mUserManager.getUsers();     // Catch: Throwable -> L22
        Trace.traceEnd(2097152);     // Catch: Throwable -> L18
        Trace.traceBegin(2097152, "iterate-uids");     // Catch: Throwable -> L18
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L12
        int usersSize = users.size();     // Catch: Throwable -> L12
        int i = 0;
    L9:
        if (i >= usersSize) goto L15;
        final int userId = users.get(i).id;     // Catch: Throwable -> L12
        final SparseBooleanArray sharedAppIdsHandled = new SparseBooleanArray();     // Catch: Throwable -> L12
        packageManagerInternal.forEachInstalledPackage(new NetworkPolicyManagerService$$ExternalSyntheticLambda1(sharedAppIdsHandled, userId, consumer), userId);     // Catch: Throwable -> L12
        i = i + 1;
        goto L9
    L15:
        Trace.traceEnd(2097152);     // Catch: Throwable -> L18
        Trace.traceEnd(2097152);
        return;
    L12:
        th = move-exception;
        Trace.traceEnd(2097152);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L22:
        th = move-exception;
        Trace.traceEnd(2097152);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private static /* synthetic */ void lambda$forEachUid$7(SparseBooleanArray sharedAppIdsHandled, int userId, IntConsumer consumer, AndroidPackage androidPackage) {
        int appId = androidPackage.getUid();
        if (androidPackage.getSharedUserId() != null) goto L5;
    L8:
        int uid = UserHandle.getUid(userId, appId);
        consumer.accept(uid);
        return;
    L5:
        if (sharedAppIdsHandled.indexOfKey(appId) >= 0) goto L7;
        sharedAppIdsHandled.put(appId, true);
        goto L8
    }

    private void updateRulesForTempAllowlistChangeUL(int appId) {
        List<UserInfo> users = this.mUserManager.getUsers();
        int numUsers = users.size();
        int i = 0;
    L3:
        if (i >= numUsers) goto L6;
        UserInfo user = users.get(i);
        int uid = UserHandle.getUid(user.id, appId);
        updateRuleForAppIdleUL(uid, -1);
        updateRuleForDeviceIdleUL(uid);
        updateRuleForRestrictPowerUL(uid);
        updateRuleForBackgroundUL(uid);
        updateRulesForPowerRestrictionsUL(uid);
        i = i + 1;
        goto L3
    }

    private boolean isUidValidForDenylistRulesUL(int uid) {
        if (uid != 1013) goto L5;
        return true;
    L5:
        if (uid != 1019) goto L7;
        return true;
    L7:
        if (isUidValidForAllowlistRulesUL(uid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    private boolean isUidValidForAllowlistRulesUL(int uid) {
        return isUidValidForRulesUL(uid);
    }

    private boolean isUidValidForRulesUL(int uid) {
        if (UserHandle.isApp(uid) == true) goto L5;
    L7:
        return false;
    L5:
        if (hasInternetPermissionUL(uid) == false) goto L7;
        return true;
    }

    void setAppIdleWhitelist(int uid, boolean shouldWhitelist) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_NETWORK_POLICY", TAG);
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppIdleTempWhitelistAppIds.get(uid) != shouldWhitelist) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
        this.mLogger.appIdleWlChanged(uid, shouldWhitelist);     // Catch: Throwable -> L14
        if (shouldWhitelist == false) goto L16;
        this.mAppIdleTempWhitelistAppIds.put(uid, true);     // Catch: Throwable -> L14
    L17:
        updateRuleForAppIdleUL(uid, -1);     // Catch: Throwable -> L14
        updateRulesForPowerRestrictionsUL(uid);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        this.mAppIdleTempWhitelistAppIds.delete(uid);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    }

    int[] getAppIdleWhitelist() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_NETWORK_POLICY", TAG);
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        int len = this.mAppIdleTempWhitelistAppIds.size();     // Catch: Throwable -> L7
        int[] uids = new int[len];     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= len) goto L10;
        uids[i] = this.mAppIdleTempWhitelistAppIds.keyAt(i);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return uids;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isUidIdle(int uid) {
        return isUidIdle(uid, -1);
    }

    private boolean isUidIdle(int uid, int uidProcessState) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        if (uidProcessState == (-1)) goto L13;
    L10:
        th = move-exception;
        throw th;
    L7:
        if (ActivityManager.isProcStateConsideredInteraction(uidProcessState) == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L13:
        if (this.mAppIdleTempWhitelistAppIds.get(uid) == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L10
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);
        int userId = UserHandle.getUserId(uid);
        if (packages == null) goto L26;
        int r3 = packages.length;
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L33;
        String packageName = packages[r4];
        if (this.mUsageStats.isAppIdle(packageName, uid, userId) == false) goto L24;
        r4 = r4 + 1;
        goto L21
    L24:
        return false;
    L33:
        return true;
    L26:
        return true;
    }

    private boolean hasInternetPermissionUL(int uid) {
        if (this.mInternetPermissionMap.get(uid) == false) goto L7;
        return true;
    L7:
        if (this.mIPm.checkUidPermission("android.permission.INTERNET", uid) != 0) goto L9;
        boolean hasPermission = true;
    L10:
        this.mInternetPermissionMap.put(uid, hasPermission);     // Catch: RemoteException -> L12
        return hasPermission;
    L9:
        hasPermission = false;
    L13:
        return true;
    }

    private void onUidDeletedUL(int uid) {
        SparseArray<UidBlockedState> r0 = this.mUidBlockedState;
        monitor-enter(r0);
        this.mUidBlockedState.delete(uid);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        this.mUidState.delete(uid);
        this.mActivityManagerInternal.onUidBlockedReasonsChanged(uid, 0);
        this.mUidPolicy.delete(uid);
        this.mUidFirewallStandbyRules.delete(uid);
        this.mBackgroundTransitioningUids.delete(uid);
        this.mPowerSaveWhitelistExceptIdleAppIds.delete(uid);
        this.mPowerSaveWhitelistAppIds.delete(uid);
        this.mPowerSaveTempWhitelistAppIds.delete(uid);
        this.mAppIdleTempWhitelistAppIds.delete(uid);
        SparseArray<UidStateCallbackInfo> r2 = this.mUidStateCallbackInfos;
        monitor-enter(r2);
        this.mUidStateCallbackInfos.remove(uid);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        this.mHandler.obtainMessage(15, uid, 0).sendToTarget();
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    private void updateRestrictionRulesForUidUL(int uid) {
        updateRuleForDeviceIdleUL(uid);
        updateRuleForAppIdleUL(uid, -1);
        updateRuleForRestrictPowerUL(uid);
        updateRuleForBackgroundUL(uid);
        updateRestrictedModeForUidUL(uid);
        updateRulesForPowerRestrictionsUL(uid);
        updateRulesForDataUsageRestrictionsUL(uid);
    }

    private void updateRulesForDataUsageRestrictionsUL(int uid) {
        if (Trace.isTagEnabled(2097152) == false) goto L11;
        Trace.traceBegin(2097152, "updateRulesForDataUsageRestrictionsUL: " + uid);
    L11:
        updateRulesForDataUsageRestrictionsULInner(uid);     // Catch: Throwable -> L8
        Trace.traceEnd(2097152);
        return;
    L8:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void updateRulesForDataUsageRestrictionsULInner(int uid) {
        if (isUidValidForAllowlistRulesUL(uid) == false) goto L5;
        int uidPolicy = this.mUidPolicy.get(uid, 0);
        boolean isForeground = isUidForegroundOnRestrictBackgroundUL(uid);
        boolean isRestrictedByAdmin = isRestrictedByAdminUL(uid);
        if ((uidPolicy & 1) == 0) goto L11;
        boolean r0 = true;
    L12:
        boolean isDenied = r0;
        if ((uidPolicy & 4) == 0) goto L15;
        boolean r1 = true;
    L16:
        boolean isAllowed = r1;
        if (isRestrictedByAdmin == false) goto L19;
        int r12 = 262144;
    L20:
        int newBlockedReasons = 0 | r12;
        int r13 = 65536;
        if (this.mRestrictBackground == false) goto L23;
        int r14 = 65536;
    L24:
        int newBlockedReasons2 = newBlockedReasons | r14;
        if (isDenied == false) goto L27;
        int r15 = 131072;
    L28:
        int newBlockedReasons3 = newBlockedReasons2 | r15;
        if ((uidPolicy & 16) == 0) goto L31;
        boolean isBgDenied = true;
    L32:
        if (isBgDenied == false) goto L34;
        int r16 = 1048576;
    L35:
        int newBlockedReasons4 = r16 | newBlockedReasons3;
        if (isSystem(uid) == false) goto L38;
        int r2 = 131072;
    L39:
        int newAllowedReasons = r2 | 0;
        if (isForeground == false) goto L42;
        int r10 = 262144;
    L43:
        int newAllowedReasons2 = newAllowedReasons | r10;
        if (isAllowed == true) goto L47;
        r13 = 0;
    L47:
        int newAllowedReasons3 = newAllowedReasons2 | r13;
        SparseArray<UidBlockedState> r17 = this.mUidBlockedState;
        monitor-enter(r17);
        UidBlockedState uidBlockedState = getOrCreateUidBlockedStateForUid(this.mUidBlockedState, uid);     // Catch: Throwable -> L64
        UidBlockedState previousUidBlockedState = getOrCreateUidBlockedStateForUid(this.mTmpUidBlockedState, uid);     // Catch: Throwable -> L64
        previousUidBlockedState.copyFrom(uidBlockedState);     // Catch: Throwable -> L64
        uidBlockedState.blockedReasons = (uidBlockedState.blockedReasons & 65535) | newBlockedReasons4;     // Catch: Throwable -> L64
        uidBlockedState.allowedReasons = (uidBlockedState.allowedReasons & 65535) | newAllowedReasons3;     // Catch: Throwable -> L64
        uidBlockedState.updateEffectiveBlockedReasons();     // Catch: Throwable -> L64
        int oldEffectiveBlockedReasons = previousUidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L64
        int newEffectiveBlockedReasons = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L64
        int r3 = previousUidBlockedState.allowedReasons;     // Catch: Throwable -> L64
        if (oldEffectiveBlockedReasons != newEffectiveBlockedReasons) goto L52;
        int r19 = 0;
    L53:
        int uidRules = r19;
        if (LOGV == true) goto L106;
        int newAllowedReasons4 = newAllowedReasons3;
    L67:
        monitor-exit(r17);     // Catch: Throwable -> L60
        if (oldEffectiveBlockedReasons == newEffectiveBlockedReasons) goto L72;
        handleBlockedReasonsChanged(uid, newEffectiveBlockedReasons, oldEffectiveBlockedReasons);
        postUidRulesChangedMsg(uid, uidRules);
    L72:
        if (this.mUseMeteredFirewallChains == true) goto L74;
        boolean r4 = false;
        if ((oldEffectiveBlockedReasons & 393216) != 0) goto L90;
        if ((newEffectiveBlockedReasons & 393216) != 0) goto L90;
    L95:
        if ((r3 & 327680) != 0) goto L99;
        if ((newAllowedReasons4 & 327680) != 0) goto L99;
        return;
    L99:
        if ((newAllowedReasons4 & 327680) == 0) goto L101;
        r4 = true;
    L101:
        setMeteredNetworkAllowlist(uid, r4);
        return;
    L90:
        if ((393216 & newEffectiveBlockedReasons) == 0) goto L92;
        boolean r18 = true;
    L93:
        setMeteredNetworkDenylist(uid, r18);
        goto L95
    L92:
        r18 = false;
        goto L93
    L74:
        if ((newEffectiveBlockedReasons & 262144) == 0) goto L76;
        setUidFirewallRuleUL(12, uid, 2);
        int r5 = 0;
    L78:
        if ((newEffectiveBlockedReasons & 131072) == 0) goto L80;
        setUidFirewallRuleUL(11, uid, 2);
    L82:
        if ((newAllowedReasons4 & 327680) == 0) goto L84;
        setUidFirewallRuleUL(10, uid, 1);
        return;
    L84:
        setUidFirewallRuleUL(10, uid, r5);
        return;
    L80:
        setUidFirewallRuleUL(11, uid, r5);
        goto L82
    L76:
        r5 = 0;
        setUidFirewallRuleUL(12, uid, 0);
        goto L78
    L106:
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L62
        newAllowedReasons4 = newAllowedReasons3;
        r6.append("updateRuleForRestrictBackgroundUL(");     // Catch: Throwable -> L60
        r6.append(uid);     // Catch: Throwable -> L60
        r6.append("): isForeground=");     // Catch: Throwable -> L60
        r6.append(isForeground);     // Catch: Throwable -> L60
        r6.append(", isDenied=");     // Catch: Throwable -> L60
        r6.append(isDenied);     // Catch: Throwable -> L60
        r6.append(", isAllowed=");     // Catch: Throwable -> L60
        r6.append(isAllowed);     // Catch: Throwable -> L60
        r6.append(", isBgDenied=");     // Catch: Throwable -> L60
        r6.append(isBgDenied);     // Catch: Throwable -> L60
        r6.append(", isRestrictedByAdmin=");     // Catch: Throwable -> L60
        r6.append(isRestrictedByAdmin);     // Catch: Throwable -> L60
        r6.append(", oldBlockedState=");     // Catch: Throwable -> L60
        r6.append(previousUidBlockedState);     // Catch: Throwable -> L60
        r6.append(", newBlockedState=");     // Catch: Throwable -> L60
        r6.append(uidBlockedState);     // Catch: Throwable -> L60
        r6.append(", newBlockedMeteredReasons=");     // Catch: Throwable -> L60
        r6.append(NetworkPolicyManager.blockedReasonsToString(newBlockedReasons4));     // Catch: Throwable -> L60
        r6.append(", newAllowedMeteredReasons=");     // Catch: Throwable -> L60
        r6.append(NetworkPolicyManager.allowedReasonsToString(newAllowedReasons4));     // Catch: Throwable -> L60
        Log.v(TAG, r6.toString());     // Catch: Throwable -> L60
    L62:
        th = th;
    L103:
        monitor-exit(r17);     // Catch: Throwable -> L60
        throw th;
    L52:
        r19 = uidBlockedState.deriveUidRules();     // Catch: Throwable -> L64
    L60:
        th = th;
    L64:
        th = th;
        goto L103
    L42:
        r10 = 0;
        goto L43
    L38:
        r2 = 0;
        goto L39
    L34:
        r16 = 0;
        goto L35
    L31:
        isBgDenied = false;
        goto L32
    L27:
        r15 = 0;
        goto L28
    L23:
        r14 = 0;
        goto L24
    L19:
        r12 = 0;
        goto L20
    L15:
        r1 = false;
        goto L16
    L11:
        r0 = false;
        goto L12
    L5:
        if (LOGD == false) goto L109;
        Slog.d(TAG, "no need to update restrict data rules for uid " + uid);
        return;
    }

    private void updateRulesForPowerRestrictionsUL(int uid) {
        updateRulesForPowerRestrictionsUL(uid, -1);
    }

    private void updateRulesForPowerRestrictionsUL(int uid, int uidProcState) {
        updateRulesForPowerRestrictionsUL(uid, isUidIdle(uid, uidProcState));
    }

    private void updateRulesForPowerRestrictionsUL(int uid, boolean isUidIdle) {
        if (Trace.isTagEnabled(2097152) == false) goto L15;
        StringBuilder r2 = new StringBuilder();
        r2.append("updateRulesForPowerRestrictionsUL: ");
        r2.append(uid);
        r2.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        if (isUidIdle == false) goto L7;
        String r3 = "I";
    L8:
        r2.append(r3);
        Trace.traceBegin(2097152, r2.toString());
        goto L15
    L7:
        r3 = "-";
    L15:
        updateRulesForPowerRestrictionsULInner(uid, isUidIdle);     // Catch: Throwable -> L12
        Trace.traceEnd(2097152);
        return;
    L12:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void updateRulesForPowerRestrictionsULInner(int r20, boolean r21) {
        if (isUidValidForDenylistRulesUL(r20) == false) goto L5;
        boolean r4 = isUidForegroundOnRestrictPowerUL(r20);
        boolean r5 = isUidTop(r20);
        boolean r6 = isAllowlistedFromPowerSaveUL(r20, this.mDeviceIdleMode);
        SparseArray<UidBlockedState> r7 = this.mUidBlockedState;
        monitor-enter(r7);
        UidBlockedState r0 = getOrCreateUidBlockedStateForUid(this.mUidBlockedState, r20);     // Catch: Throwable -> L53
        UidBlockedState r8 = getOrCreateUidBlockedStateForUid(this.mTmpUidBlockedState, r20);     // Catch: Throwable -> L53
        r8.copyFrom(r0);     // Catch: Throwable -> L53
        int r13 = 0;
        if (this.mRestrictPower == false) goto L13;
        int r11 = 1;
    L14:
        int r9 = 0 | r11;     // Catch: Throwable -> L53
        int r14 = 2;
        if (this.mDeviceIdleMode == false) goto L17;
        int r12 = 2;
    L18:
        int r10 = r9 | r12;     // Catch: Throwable -> L53
        int r15 = 32;
        if (this.mLowPowerStandbyActive == false) goto L21;
        int r16 = 32;
    L22:
        int r17 = r10 | r16;     // Catch: Throwable -> L53
        if (r21 == false) goto L25;
        int r18 = 4;
    L26:
        int r19 = 8;
        int r22 = (((r17 | r18) | (r0.blockedReasons & 8)) | 64) | (r0.blockedReasons & 1048576);     // Catch: Throwable -> L53
        int r110 = 0 | (isSystem(r20) ? 1 : 0);     // Catch: Throwable -> L53
        if (r4 == true) goto L30;
        r14 = 0;
    L30:
        int r111 = r110 | r14;     // Catch: Throwable -> L53
        if (r5 == true) goto L34;
        r15 = 0;
    L34:
        int r112 = r111 | r15;     // Catch: Throwable -> L53
        if (isAllowlistedFromPowerSaveUL(r20, true) == false) goto L37;
        int r113 = 4;
    L38:
        int r114 = r112 | r113;     // Catch: Throwable -> L53
        if (isAllowlistedFromPowerSaveExceptIdleUL(r20) == true) goto L42;
        r19 = 0;
    L42:
        int r115 = (r114 | r19) | (r0.allowedReasons & 16);     // Catch: Throwable -> L53
        if (isAllowlistedFromLowPowerStandbyUL(r20) == false) goto L45;
        int r116 = 64;
    L46:
        int r117 = r115 | r116;     // Catch: Throwable -> L53
        if (isUidExemptFromBackgroundRestrictions(r20) == false) goto L49;
        int r118 = 128;
    L50:
        r0.blockedReasons = (r0.blockedReasons & (-65536)) | r22;     // Catch: Throwable -> L53
        r0.allowedReasons = (r0.allowedReasons & (-65536)) | (r117 | r118);     // Catch: Throwable -> L53
        r0.updateEffectiveBlockedReasons();     // Catch: Throwable -> L53
        if (LOGV == false) goto L55;
        Log.v(TAG, "updateRulesForPowerRestrictionsUL(" + r20 + "), isIdle: " + r21 + ", mRestrictPower: " + this.mRestrictPower + ", mDeviceIdleMode: " + this.mDeviceIdleMode + ", isForeground=" + r4 + ", isTop=" + r5 + ", isWhitelisted=" + r6 + ", oldUidBlockedState=" + r8 + ", newUidBlockedState=" + r0);     // Catch: Throwable -> L53
    L55:
        int r119 = r8.effectiveBlockedReasons;     // Catch: Throwable -> L53
        int r120 = r0.effectiveBlockedReasons;     // Catch: Throwable -> L53
        if (r119 == r120) goto L60;
        r13 = r0.deriveUidRules();     // Catch: Throwable -> L53
    L60:
        monitor-exit(r7);     // Catch: Throwable -> L53
        if (r119 == r120) goto L69;
        handleBlockedReasonsChanged(r20, r120, r119);
        postUidRulesChangedMsg(r20, r13);
        return;
    L69:
        return;
    L49:
        r118 = 0;
        goto L50
    L45:
        r116 = 0;
        goto L46
    L37:
        r113 = 0;
        goto L38
    L25:
        r18 = 0;
        goto L26
    L21:
        r16 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r11 = 0;
    L53:
        th = move-exception;
        throw th;
    L5:
        if (LOGD == false) goto L68;
        Slog.d(TAG, "no need to update restrict power rules for uid " + r20);
        return;
    }

    private void handleBlockedReasonsChanged(int uid, int newEffectiveBlockedReasons, int oldEffectiveBlockedReasons) {
        this.mActivityManagerInternal.onUidBlockedReasonsChanged(uid, newEffectiveBlockedReasons);
        postBlockedReasonsChangedMsg(uid, newEffectiveBlockedReasons, oldEffectiveBlockedReasons);
    }

    private void postBlockedReasonsChangedMsg(int uid, int newEffectiveBlockedReasons, int oldEffectiveBlockedReasons) {
        this.mHandler.obtainMessage(21, uid, newEffectiveBlockedReasons, Integer.valueOf(oldEffectiveBlockedReasons)).sendToTarget();
    }

    private void postUidRulesChangedMsg(int uid, int uidRules) {
        this.mHandler.obtainMessage(1, uid, uidRules).sendToTarget();
    }

    private void dispatchUidRulesChanged(INetworkPolicyListener listener, int uid, int uidRules) {
        listener.onUidRulesChanged(uid, uidRules);     // Catch: RemoteException -> L4
        return;
    }

    private void dispatchMeteredIfacesChanged(INetworkPolicyListener listener, String[] meteredIfaces) {
        listener.onMeteredIfacesChanged(meteredIfaces);     // Catch: RemoteException -> L4
        return;
    }

    private void dispatchRestrictBackgroundChanged(INetworkPolicyListener listener, boolean restrictBackground) {
        listener.onRestrictBackgroundChanged(restrictBackground);     // Catch: RemoteException -> L4
        return;
    }

    private void dispatchUidPoliciesChanged(INetworkPolicyListener listener, int uid, int uidPolicies) {
        listener.onUidPoliciesChanged(uid, uidPolicies);     // Catch: RemoteException -> L4
        return;
    }

    private void dispatchSubscriptionOverride(INetworkPolicyListener listener, int subId, int overrideMask, int overrideValue, int[] networkTypes) {
        listener.onSubscriptionOverride(subId, overrideMask, overrideValue, networkTypes);     // Catch: RemoteException -> L4
        return;
    }

    private void dispatchSubscriptionPlansChanged(INetworkPolicyListener listener, int subId, SubscriptionPlan[] plans) {
        listener.onSubscriptionPlansChanged(subId, plans);     // Catch: RemoteException -> L4
        return;
    }

    private void dispatchBlockedReasonChanged(INetworkPolicyListener listener, int uid, int oldBlockedReasons, int newBlockedReasons) {
        listener.onBlockedReasonChanged(uid, oldBlockedReasons, newBlockedReasons);     // Catch: RemoteException -> L4
        return;
    }

    void handleUidChanged(int uid) {
        Trace.traceBegin(2097152, "onUidStateChanged");
        SparseArray<UidStateCallbackInfo> r3 = this.mUidStateCallbackInfos;     // Catch: Throwable -> L37
        monitor-enter(r3);     // Catch: Throwable -> L37
        UidStateCallbackInfo uidStateCallbackInfo = this.mUidStateCallbackInfos.get(uid);     // Catch: Throwable -> L39
        if (uidStateCallbackInfo == null) goto L57;
        int procState = uidStateCallbackInfo.procState;     // Catch: Throwable -> L39
        long procStateSeq = uidStateCallbackInfo.procStateSeq;     // Catch: Throwable -> L39
        int capability = uidStateCallbackInfo.capability;     // Catch: Throwable -> L39
        uidStateCallbackInfo.isPending = false;     // Catch: Throwable -> L39
        monitor-exit(r3);     // Catch: Throwable -> L39
        Object r4 = this.mUidRulesFirstLock;     // Catch: Throwable -> L37
        monitor-enter(r4);     // Catch: Throwable -> L37
        this.mLogger.uidStateChanged(uid, procState, procStateSeq, capability);     // Catch: Throwable -> L31
        boolean updated = updateUidStateUL(uid, procState, procStateSeq, capability);     // Catch: Throwable -> L29
        this.mActivityManagerInternal.notifyNetworkPolicyRulesUpdated(uid, procStateSeq);     // Catch: Throwable -> L29
        monitor-exit(r4);     // Catch: Throwable -> L29
        if (updated == false) goto L27;
        updateNetworkStats(uid, NetworkPolicyManager.isProcStateAllowedWhileOnRestrictBackground(procState, capability));     // Catch: Throwable -> L25
    L27:
        Trace.traceEnd(2097152);
        return;
    L31:
        th = th;
    L30:
        Throwable r12 = th;
    L35:
        monitor-exit(r4);     // Catch: Throwable -> L29
        throw r12;     // Catch: Throwable -> L25
    L33:
        th = move-exception;
        r12 = th;
    L29:
        th = th;
        goto L30
    L57:
        monitor-exit(r3);     // Catch: Throwable -> L10
        Trace.traceEnd(2097152);
        return;
    L10:
        th = th;
    L52:
        monitor-exit(r3);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L25
    L43:
        th = th;
    L39:
        th = th;
    L25:
        th = move-exception;
        Throwable r13 = th;
    L45:
        Trace.traceEnd(2097152);
        throw r13;
    L37:
        th = move-exception;
        r13 = th;
        goto L45
    }

    void handleUidGone(int uid) {
        Trace.traceBegin(2097152, "onUidGone");
        SparseArray<UidStateCallbackInfo> r0 = this.mUidStateCallbackInfos;     // Catch: Throwable -> L21
        monitor-enter(r0);     // Catch: Throwable -> L21
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L6:
        if (this.mUidStateCallbackInfos.contains(uid) == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        Trace.traceEnd(2097152);
        return;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        Object r1 = this.mUidRulesFirstLock;     // Catch: Throwable -> L21
        monitor-enter(r1);     // Catch: Throwable -> L21
        boolean updated = removeUidStateUL(uid);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        if (updated == true) goto L19;
    L23:
        Trace.traceEnd(2097152);
        return;
    L19:
        updateNetworkStats(uid, false);     // Catch: Throwable -> L21
        goto L23
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    }

    private void broadcastRestrictBackgroundChanged(int uid, Boolean changed) {
        PackageManager pm = this.mContext.getPackageManager();
        String[] packages = pm.getPackagesForUid(uid);
        if (packages == null) goto L8;
        int userId = UserHandle.getUserId(uid);
        int r3 = packages.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L10;
        String packageName = packages[r4];
        Intent intent = new Intent("android.net.conn.RESTRICT_BACKGROUND_CHANGED");
        intent.setPackage(packageName);
        intent.setFlags(1073741824);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(userId));
        r4 = r4 + 1;
        goto L6
    L10:
        return;
    }

    private void setInterfaceQuotasAsync(String iface, long warningBytes, long limitBytes) {
        this.mHandler.obtainMessage(10, new IfaceQuotas(iface, warningBytes, limitBytes, null)).sendToTarget();
    }

    private void setInterfaceLimit(String iface, long limitBytes) {
        this.mNetworkManager.setInterfaceQuota(iface, limitBytes);     // Catch: RemoteException -> L4 IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        Log.wtf(TAG, "problem setting interface quota", e);
        return;
    }

    private void removeInterfaceQuotasAsync(String iface) {
        this.mHandler.obtainMessage(11, iface).sendToTarget();
    }

    private void removeInterfaceLimit(String iface) {
        this.mNetworkManager.removeInterfaceQuota(iface);     // Catch: RemoteException -> L4 IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        Log.wtf(TAG, "problem removing interface quota", e);
        return;
    }

    private void setMeteredNetworkDenylist(int uid, boolean enable) {
        if (LOGV == false) goto L16;
        Slog.v(TAG, "setMeteredNetworkDenylist " + uid + ": " + enable);
    L16:
        this.mNetworkManager.setUidOnMeteredNetworkDenylist(uid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mLogger.meteredDenylistChanged(uid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        if (Process.isApplicationUid(uid) == false) goto L18;
        int sdkSandboxUid = Process.toSdkSandboxUid(uid);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mNetworkManager.setUidOnMeteredNetworkDenylist(sdkSandboxUid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mLogger.meteredDenylistChanged(sdkSandboxUid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        goto L15
    L20:
        return;
    L18:
        return;
    L11:
        e = move-exception;
        Log.wtf(TAG, "problem setting denylist (" + enable + ") rules for " + uid, e);
        return;
    }

    private void setMeteredNetworkAllowlist(int uid, boolean enable) {
        if (LOGV == false) goto L16;
        Slog.v(TAG, "setMeteredNetworkAllowlist " + uid + ": " + enable);
    L16:
        this.mNetworkManager.setUidOnMeteredNetworkAllowlist(uid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mLogger.meteredAllowlistChanged(uid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        if (Process.isApplicationUid(uid) == false) goto L18;
        int sdkSandboxUid = Process.toSdkSandboxUid(uid);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mNetworkManager.setUidOnMeteredNetworkAllowlist(sdkSandboxUid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mLogger.meteredAllowlistChanged(sdkSandboxUid, enable);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        goto L15
    L20:
        return;
    L18:
        return;
    L11:
        e = move-exception;
        Log.wtf(TAG, "problem setting allowlist (" + enable + ") rules for " + uid, e);
        return;
    }

    private void setUidFirewallRulesUL(int chain, SparseIntArray uidRules, int toggle) {
        if (uidRules == null) goto L4;
        setUidFirewallRulesUL(chain, uidRules);
    L4:
        if (toggle == 0) goto L11;
        boolean r0 = true;
        if (toggle == 1) goto L9;
        r0 = false;
    L9:
        enableFirewallChainUL(chain, r0);
        return;
    }

    private void setUidFirewallRulesUL(int chain, SparseIntArray uidRules) {
        int size = uidRules.size();     // Catch: RemoteException -> L9 IllegalStateException -> L11
        IntArray uids = new IntArray(size);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        IntArray rules = new IntArray(size);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        int index = size - 1;     // Catch: RemoteException -> L9 IllegalStateException -> L11
    L3:
        if (index < 0) goto L17;
        int uid = uidRules.keyAt(index);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        if (this.mNeverApplyRulesToCoreUids == true) goto L7;
    L13:
        uids.add(uid);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        rules.add(uidRules.valueAt(index));     // Catch: RemoteException -> L9 IllegalStateException -> L11
        if (Process.isApplicationUid(uid) == false) goto L16;
        uids.add(Process.toSdkSandboxUid(uid));     // Catch: RemoteException -> L9 IllegalStateException -> L11
        rules.add(uidRules.valueAt(index));     // Catch: RemoteException -> L9 IllegalStateException -> L11
    L16:
        index = index - 1;     // Catch: RemoteException -> L9 IllegalStateException -> L11
        goto L3
    L7:
        if (isUidValidForRulesUL(uid) == true) goto L13;
    L17:
        int[] uidArray = uids.toArray();     // Catch: RemoteException -> L9 IllegalStateException -> L11
        int[] ruleArray = rules.toArray();     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mNetworkManager.setFirewallUidRules(chain, uidArray, ruleArray);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        this.mLogger.firewallRulesChanged(chain, uidArray, ruleArray);     // Catch: RemoteException -> L9 IllegalStateException -> L11
        goto L20
    L27:
        return;
    L11:
        e = move-exception;
        Log.wtf(TAG, "problem setting firewall uid rules", e);
        return;
    }

    private void setUidFirewallRuleUL(int chain, int uid, int rule) {
        if (this.mNeverApplyRulesToCoreUids == false) goto L8;
        if (isUidValidForRulesUL(uid) == true) goto L8;
        return;
    L8:
        if (Trace.isTagEnabled(2097152) == false) goto L11;
        Trace.traceBegin(2097152, "setUidFirewallRuleUL: " + chain + SliceClientPermissions.SliceAuthority.DELIMITER + uid + SliceClientPermissions.SliceAuthority.DELIMITER + rule);
    L11:
        if (chain != 2) goto L32;
        this.mUidFirewallStandbyRules.put(uid, rule);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Trace.traceEnd(2097152);
        throw th;
    L32:
        this.mNetworkManager.setFirewallUidRule(chain, uid, rule);     // Catch: Throwable -> L14 RemoteException -> L20 IllegalStateException -> L22
        this.mLogger.uidFirewallRuleChanged(chain, uid, rule);     // Catch: Throwable -> L14 RemoteException -> L20 IllegalStateException -> L22
        if (Process.isApplicationUid(uid) == false) goto L27;
        int sdkSandboxUid = Process.toSdkSandboxUid(uid);     // Catch: Throwable -> L14 RemoteException -> L20 IllegalStateException -> L22
        this.mNetworkManager.setFirewallUidRule(chain, sdkSandboxUid, rule);     // Catch: Throwable -> L14 RemoteException -> L20 IllegalStateException -> L22
        this.mLogger.uidFirewallRuleChanged(chain, sdkSandboxUid, rule);     // Catch: Throwable -> L14 RemoteException -> L20 IllegalStateException -> L22
    L22:
        e = move-exception;
        Log.wtf(TAG, "problem setting firewall uid rules", e);     // Catch: Throwable -> L14
    L27:
        Trace.traceEnd(2097152);
    }

    private void enableFirewallChainUL(int chain, boolean enable) {
        if (this.mFirewallChainStates.indexOfKey(chain) >= 0) goto L5;
    L7:
        this.mFirewallChainStates.put(chain, enable);
        this.mNetworkManager.setFirewallChainEnabled(chain, enable);     // Catch: RemoteException -> L10 IllegalStateException -> L12
        this.mLogger.firewallChainEnabled(chain, enable);     // Catch: RemoteException -> L10 IllegalStateException -> L12
        return;
    L12:
        e = move-exception;
        Log.wtf(TAG, "problem enable firewall chain", e);
        return;
    L18:
        return;
    L5:
        if (this.mFirewallChainStates.get(chain) != enable) goto L7;
    }

    private void resetUidFirewallRules(int uid) {
        this.mNetworkManager.setFirewallUidRule(1, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setFirewallUidRule(2, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setFirewallUidRule(3, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setFirewallUidRule(4, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setFirewallUidRule(5, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setFirewallUidRule(6, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        if (this.mUseMeteredFirewallChains == false) goto L9;
        this.mNetworkManager.setFirewallUidRule(12, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setFirewallUidRule(11, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setFirewallUidRule(10, uid, 0);     // Catch: RemoteException -> L5 IllegalStateException -> L7
    L16:
        goto L13
    L9:
        this.mNetworkManager.setUidOnMeteredNetworkAllowlist(uid, false);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mLogger.meteredAllowlistChanged(uid, false);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mNetworkManager.setUidOnMeteredNetworkDenylist(uid, false);     // Catch: RemoteException -> L5 IllegalStateException -> L7
        this.mLogger.meteredDenylistChanged(uid, false);     // Catch: RemoteException -> L5 IllegalStateException -> L7
    L7:
        e = move-exception;
        Log.wtf(TAG, "problem resetting firewall uid rules for " + uid, e);
    L13:
        if (Process.isApplicationUid(uid) == false) goto L19;
        resetUidFirewallRules(Process.toSdkSandboxUid(uid));
        return;
    }

    @Deprecated
    protected long getTotalBytes(NetworkTemplate template, long start, long end) {
        if (this.mStatsCallback.isAnyCallbackReceived() == true) goto L7;
        return 0;
    L7:
        return this.mDeps.getNetworkTotalBytes(template, start, end);
    }

    private boolean isBandwidthControlEnabled() {
        long token = Binder.clearCallingIdentity();
        boolean r2 = this.mNetworkManager.isBandwidthControlEnabled();     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L12:
        Binder.restoreCallingIdentity(token);
        return false;
    }

    private static Intent buildSnoozeWarningIntent(NetworkTemplate template, String targetPackage) {
        Intent intent = new Intent(ACTION_SNOOZE_WARNING);
        intent.addFlags(268435456);
        intent.putExtra("android.net.NETWORK_TEMPLATE", template);
        intent.setPackage(targetPackage);
        return intent;
    }

    private static Intent buildSnoozeRapidIntent(NetworkTemplate template, String targetPackage) {
        Intent intent = new Intent(ACTION_SNOOZE_RAPID);
        intent.addFlags(268435456);
        intent.putExtra("android.net.NETWORK_TEMPLATE", template);
        intent.setPackage(targetPackage);
        return intent;
    }

    private static Intent buildNetworkOverLimitIntent(Resources res, NetworkTemplate template) {
        Intent intent = new Intent();
        intent.setComponent(ComponentName.unflattenFromString(res.getString(R.string.config_secondaryLocationTimeZoneProviderPackageName)));
        intent.addFlags(268435456);
        intent.putExtra("android.net.NETWORK_TEMPLATE", template);
        return intent;
    }

    private static Intent buildViewDataUsageIntent(Resources res, NetworkTemplate template) {
        Intent intent = new Intent();
        intent.setComponent(ComponentName.unflattenFromString(res.getString(R.string.config_defaultWallpaperEffectsGenerationService)));
        intent.addFlags(268435456);
        intent.putExtra("android.net.NETWORK_TEMPLATE", template);
        return intent;
    }

    void addIdleHandler(MessageQueue.IdleHandler handler) {
        this.mHandler.getLooper().getQueue().addIdleHandler(handler);
    }

    void updateRestrictBackgroundByLowPowerModeUL(PowerSaveState result) {
        if (this.mRestrictBackgroundLowPowerMode != result.batterySaverEnabled) goto L5;
        return;
    L5:
        this.mRestrictBackgroundLowPowerMode = result.batterySaverEnabled;
        boolean restrictBackground = this.mRestrictBackgroundLowPowerMode;
        boolean localRestrictBgChangedInBsm = this.mRestrictBackgroundChangedInBsm;
        if (this.mRestrictBackgroundLowPowerMode == false) goto L8;
        boolean shouldInvokeRestrictBackground = !this.mRestrictBackground;
        this.mRestrictBackgroundBeforeBsm = this.mRestrictBackground;
        localRestrictBgChangedInBsm = false;
    L9:
        if (shouldInvokeRestrictBackground == false) goto L11;
        setRestrictBackgroundUL(restrictBackground, "low_power");
    L11:
        this.mRestrictBackgroundChangedInBsm = localRestrictBgChangedInBsm;
        return;
    L8:
        boolean shouldInvokeRestrictBackground2 = this.mRestrictBackgroundChangedInBsm;
        shouldInvokeRestrictBackground = !shouldInvokeRestrictBackground2;
        restrictBackground = this.mRestrictBackgroundBeforeBsm;
        goto L9
    }

    private static void collectKeys(SparseIntArray source, SparseBooleanArray target) {
        int size = source.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        target.put(source.keyAt(i), true);
        i = i + 1;
        goto L3
    }

    private static <T> void collectKeys(SparseArray<T> source, SparseBooleanArray target) {
        int size = source.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        target.put(source.keyAt(i), true);
        i = i + 1;
        goto L3
    }

    public void factoryReset(String subscriber) {
        factoryReset_enforcePermission();
        if (this.mUserManager.hasUserRestriction("no_network_reset") == false) goto L5;
        return;
    L5:
        NetworkPolicy[] policies = getNetworkPolicies(this.mContext.getOpPackageName());
        NetworkTemplate templateMobile = null;
        if (subscriber == null) goto L8;
        NetworkTemplate templateCarrier = buildTemplateCarrierMetered(subscriber);
    L10:
        if (subscriber == null) goto L13;
        templateMobile = new NetworkTemplate.Builder(1).setSubscriberIds(Set.of(subscriber)).setMeteredness(1).build();
    L13:
        int r4 = policies.length;
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L21;
        NetworkPolicy policy = policies[r6];
        if (policy.template.equals(templateCarrier) == false) goto L18;
    L19:
        policy.limitBytes = -1;
        policy.inferred = false;
        policy.clearSnooze();
    L20:
        r6 = r6 + 1;
        goto L14
    L18:
        if (policy.template.equals(templateMobile) == false) goto L20;
    L21:
        setNetworkPolicies(policies);
        setRestrictBackground(false);
        if (this.mUserManager.hasUserRestriction("no_control_apps") == true) goto L27;
        int[] r3 = getUidsWithPolicy(1);
        int r5 = r3.length;
        int r7 = 0;
    L25:
        if (r7 >= r5) goto L32;
        int uid = r3[r7];
        setUidPolicy(uid, 0);
        r7 = r7 + 1;
        goto L25
    L32:
        return;
    L27:
        return;
    L8:
        templateCarrier = null;
        goto L10
    }

    public boolean isUidNetworkingBlocked(int uid, boolean isNetworkMetered) {
        long startTime = this.mStatLogger.getTime();
        this.mContext.enforceCallingOrSelfPermission("android.permission.OBSERVE_NETWORK_POLICY", TAG);
        SparseArray<UidBlockedState> r2 = this.mUidBlockedState;
        monitor-enter(r2);
        UidBlockedState uidBlockedState = this.mUidBlockedState.get(uid);     // Catch: Throwable -> L16
        if (uidBlockedState != null) goto L7;
        int blockedReasons = 0;
    L8:
        if (isNetworkMetered == true) goto L10;
        blockedReasons = blockedReasons & 65535;     // Catch: Throwable -> L16
    L10:
        this.mLogger.networkBlocked(uid, uidBlockedState);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        this.mStatLogger.logDurationStat(1, startTime);
        if (blockedReasons != 0) goto L15;
        return false;
    L15:
        return true;
    L7:
        blockedReasons = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public boolean isUidRestrictedOnMeteredNetworks(int uid) {
        isUidRestrictedOnMeteredNetworks_enforcePermission();
        SparseArray<UidBlockedState> r0 = this.mUidBlockedState;
        monitor-enter(r0);
        UidBlockedState uidBlockedState = this.mUidBlockedState.get(uid);     // Catch: Throwable -> L13
        boolean r2 = false;
        if (uidBlockedState != null) goto L7;
        int blockedReasons = 0;
    L9:
        if ((blockedReasons & (-65536)) == 0) goto L11;
        r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        blockedReasons = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private static boolean isSystem(int uid) {
        if (uid >= 10000) goto L5;
        return true;
    L5:
        return false;
    }

    private void setMeteredRestrictedPackagesInternal(Set<String> packageNames, int userId) {
        Object r0 = this.mUidRulesFirstLock;
        monitor-enter(r0);
        Set<Integer> newRestrictedUids = new ArraySet();     // Catch: Throwable -> L10
        Iterator<String> r2 = packageNames.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        String packageName = r2.next();     // Catch: Throwable -> L10
        int uid = getUidForPackage(packageName, userId);     // Catch: Throwable -> L10
        if (uid < 0) goto L6;
        newRestrictedUids.add(Integer.valueOf(uid));     // Catch: Throwable -> L10
        goto L6
    L13:
        Set<Integer> oldRestrictedUids = this.mMeteredRestrictedUids.get(userId);     // Catch: Throwable -> L10
        this.mMeteredRestrictedUids.put(userId, newRestrictedUids);     // Catch: Throwable -> L10
        handleRestrictedPackagesChangeUL(oldRestrictedUids, newRestrictedUids);     // Catch: Throwable -> L10
        this.mLogger.meteredRestrictedPkgsChanged(newRestrictedUids);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private int getUidForPackage(String packageName, int userId) {
        return this.mContext.getPackageManager().getPackageUidAsUser(packageName, 4202496, userId);
    L5:
        return -1;
    }

    private int getSubIdLocked(Network network) {
        return this.mNetIdToSubId.get(network.getNetId(), -1);
    }

    private SubscriptionPlan getPrimarySubscriptionPlanLocked(int subId) {
        SubscriptionPlan[] plans = this.mSubscriptionPlans.get(subId);
        if (ArrayUtils.isEmpty(plans) == true) goto L14;
        int r1 = plans.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L19;
        SubscriptionPlan plan = plans[r2];
        if (plan.getCycleRule().isRecurring() == true) goto L9;
        Range<ZonedDateTime> cycle = plan.cycleIterator().next();
        if (cycle.contains(ZonedDateTime.now(this.mClock)) == true) goto L12;
        r2 = r2 + 1;
        goto L6
    L12:
        return plan;
    L9:
        return plan;
    L19:
        return null;
    L14:
        return null;
    }

    private void waitForAdminData() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.device_admin") == false) goto L6;
        ConcurrentUtils.waitForCountDownNoInterrupt(this.mAdminDataAvailableLatch, 10000, "Wait for admin data");
        return;
    }

    private void handleRestrictedPackagesChangeUL(Set<Integer> oldRestrictedUids, Set<Integer> newRestrictedUids) {
        if (this.mNetworkManagerReady == true) goto L5;
        return;
    L5:
        if (oldRestrictedUids != null) goto L11;
        Iterator<Integer> r0 = newRestrictedUids.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        updateRulesForDataUsageRestrictionsUL(r0.next().intValue());
        goto L8
    L10:
        return;
    L11:
        Iterator<Integer> r1 = oldRestrictedUids.iterator();
    L13:
        if (r1.hasNext() == false) goto L18;
        int uid = r1.next().intValue();
        if (newRestrictedUids.contains(Integer.valueOf(uid)) == true) goto L13;
        updateRulesForDataUsageRestrictionsUL(uid);
        goto L13
    L18:
        Iterator<Integer> r2 = newRestrictedUids.iterator();
    L20:
        if (r2.hasNext() == false) goto L25;
        int uid2 = r2.next().intValue();
        if (oldRestrictedUids.contains(Integer.valueOf(uid2)) == true) goto L20;
        updateRulesForDataUsageRestrictionsUL(uid2);
        goto L20
    }

    private boolean isRestrictedByAdminUL(int uid) {
        Set<Integer> restrictedUids = this.mMeteredRestrictedUids.get(UserHandle.getUserId(uid));
        if (restrictedUids != null) goto L5;
    L7:
        return false;
    L5:
        if (restrictedUids.contains(Integer.valueOf(uid)) == false) goto L7;
        return true;
    }

    private static boolean getBooleanDefeatingNullable(PersistableBundle bundle, String key, boolean defaultValue) {
        if (bundle == null) goto L5;
        return bundle.getBoolean(key, defaultValue);
    L5:
        return defaultValue;
    }

    private static UidBlockedState getOrCreateUidBlockedStateForUid(SparseArray<UidBlockedState> uidBlockedStates, int uid) {
        UidBlockedState uidBlockedState = uidBlockedStates.get(uid);
        if (uidBlockedState != null) goto L6;
        UidBlockedState uidBlockedState2 = new UidBlockedState();
        uidBlockedStates.put(uid, uidBlockedState2);
        return uidBlockedState2;
    L6:
        return uidBlockedState;
    }

    private int getEffectiveBlockedReasons(int uid) {
        SparseArray<UidBlockedState> r0 = this.mUidBlockedState;
        monitor-enter(r0);
        UidBlockedState uidBlockedState = this.mUidBlockedState.get(uid);     // Catch: Throwable -> L10
        if (uidBlockedState != null) goto L7;
        int r2 = 0;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = uidBlockedState.effectiveBlockedReasons;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private int getBlockedReasons(int uid) {
        SparseArray<UidBlockedState> r0 = this.mUidBlockedState;
        monitor-enter(r0);
        UidBlockedState uidBlockedState = this.mUidBlockedState.get(uid);     // Catch: Throwable -> L10
        if (uidBlockedState != null) goto L7;
        int r2 = 0;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = uidBlockedState.blockedReasons;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public NetworkPolicyManagerServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }
}

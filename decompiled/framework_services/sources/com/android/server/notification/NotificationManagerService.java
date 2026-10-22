package com.android.server.notification;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AlarmManager;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.AutomaticZenRule;
import android.app.IActivityManager;
import android.app.ICallNotificationEventCallback;
import android.app.INotificationManager;
import android.app.INotificationManagerSmtEx;
import android.app.IObricNotificationManager;
import android.app.ITransientNotification;
import android.app.ITransientNotificationCallback;
import android.app.IUriGrantsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationHistory;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Person;
import android.app.StatsManager;
import android.app.SysMonitorFwBridge;
import android.app.UriGrantsManager;
import android.app.ZenBypassingApp;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.backup.BackupManager;
import android.app.backup.BackupRestoreEventLogger;
import android.app.compat.CompatChanges;
import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManagerInternal;
import android.companion.AssociationInfo;
import android.companion.ICompanionDeviceManager;
import android.content.AttributionSource;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.LauncherApps;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ServiceInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutServiceInternal;
import android.content.pm.UserInfo;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.audio.common.V2_0.AudioChannelMask;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.metrics.LogMaker;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.DeviceIdleManager;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.permission.PermissionManager;
import android.provider.Settings;
import android.service.notification.Adjustment;
import android.service.notification.Condition;
import android.service.notification.ConversationChannelWrapper;
import android.service.notification.DeviceEffectsApplier;
import android.service.notification.IConditionProvider;
import android.service.notification.INotificationListener;
import android.service.notification.IStatusBarNotificationHolder;
import android.service.notification.NotificationListenerFilter;
import android.service.notification.NotificationListenerService;
import android.service.notification.NotificationRankingUpdate;
import android.service.notification.NotificationStats;
import android.service.notification.SnoozeCriterion;
import android.service.notification.StatusBarNotification;
import android.service.notification.ZenDeviceEffects;
import android.service.notification.ZenModeConfig;
import android.service.notification.ZenPolicy;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.StatsEvent;
import android.util.Utils;
import android.util.Xml;
import android.util.proto.ProtoOutputStream;
import android.view.accessibility.AccessibilityManager;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.config.sysui.SystemUiSystemPropertiesFlags;
import com.android.internal.logging.InstanceId;
import com.android.internal.logging.InstanceIdSequence;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.notification.NotificationChannelGroupsHelper;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.SomeArgs;
import com.android.internal.statusbar.NotificationVisibility;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.function.TriPredicate;
import com.android.internal.widget.LockPatternUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.DeviceIdleInternal;
import com.android.server.EventLogTags;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.am.HostingRecord;
import com.android.server.am.IAppRecordManagerService;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.job.JobSchedulerInternal;
import com.android.server.lights.LightsManager;
import com.android.server.notification.toast.CustomToastRecord;
import com.android.server.notification.toast.TextToastRecord;
import com.android.server.notification.toast.ToastRecord;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.policy.PermissionPolicyInternal;
import com.android.server.power.IBytedancePowerAdvisor;
import com.android.server.redmagic.GameKeysPatch;
import com.android.server.scene.SceneUtils;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import com.android.server.utils.PriorityDump;
import com.android.server.utils.Slogf;
import com.android.server.utils.quota.MultiRateLimiter;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.BackgroundActivityStartCallback;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricImplFactory;
import com.redmagic.game.GameKeysHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import libcore.io.IoUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationManagerService extends SystemService {
    private static final String ACTION_NOTIFICATION_TIMEOUT = null;
    private static final String ADSERVICES_MODULE_PKG_NAME = "com.android.adservices";
    static final IBinder ALLOWLIST_TOKEN = null;
    private static final String ATTR_VERSION = "version";
    private static final int AUTOGROUP_SPARSE_GROUPS_AT_COUNT = 6;
    static final Duration BITMAP_DURATION = null;
    private static final long CHANGE_BACKGROUND_CUSTOM_TOAST_BLOCK = 128611929;
    public static final boolean DBG = false;
    private static final int DB_VERSION = 1;
    static final boolean DEBUG_INTERRUPTIVENESS = false;
    static final String[] DEFAULT_ALLOWED_ADJUSTMENTS = null;
    static final Integer[] DEFAULT_ALLOWED_ADJUSTMENT_KEY_TYPES = null;
    static final float DEFAULT_MAX_NOTIFICATION_ENQUEUE_RATE = 5.0f;
    private static final long DELAY_FORCE_REGROUP_TIME = 3000;
    private static final long DELAY_FOR_ASSISTANT_TIME = 200;
    public static final boolean ENABLE_CHILD_NOTIFICATIONS = false;
    static final long ENFORCE_NO_CLEAR_FLAG_ON_MEDIA_NOTIFICATION = 264179692;
    private static final int EVENTLOG_ENQUEUE_STATUS_IGNORED = 2;
    private static final int EVENTLOG_ENQUEUE_STATUS_NEW = 0;
    private static final int EVENTLOG_ENQUEUE_STATUS_UPDATE = 1;
    private static final String EXTRA_KEY = "key";
    static final int FINISH_TOKEN_TIMEOUT = 11000;
    private static final String LOCKSCREEN_ALLOW_SECURE_NOTIFICATIONS_TAG = "allow-secure-notifications-on-lockscreen";
    private static final String LOCKSCREEN_ALLOW_SECURE_NOTIFICATIONS_VALUE = "value";
    static final int LONG_DELAY = 3500;
    static final long MANAGE_GLOBAL_ZEN_VIA_IMPLICIT_RULES = 308670109;
    static final int MATCHES_CALL_FILTER_CONTACTS_TIMEOUT_MS = 3000;
    static final float MATCHES_CALL_FILTER_TIMEOUT_AFFINITY = 1.0f;
    public static final int MAX_NOTIFICATION_CHANNEL = 1000;
    static final int MAX_PACKAGE_NOTIFICATIONS = 50;
    static final int MAX_PACKAGE_TOASTS = 5;
    static final int MESSAGE_DURATION_REACHED = 2;
    static final int MESSAGE_FINISH_TOKEN_TIMEOUT = 7;
    static final int MESSAGE_LISTENER_HINTS_CHANGED = 5;
    static final int MESSAGE_LISTENER_NOTIFICATION_FILTER_CHANGED = 6;
    static final int MESSAGE_ON_PACKAGE_CHANGED = 8;
    private static final int MESSAGE_RANKING_SORT = 1001;
    private static final int MESSAGE_RECONSIDER_RANKING = 1000;
    static final int MESSAGE_SEND_RANKING_UPDATE = 4;
    private static final long MIN_PACKAGE_OVERRATE_LOG_INTERVAL = 5000;
    private static final int MY_PID = 0;
    private static final int MY_UID = 0;
    static final String[] NON_BLOCKABLE_DEFAULT_ROLES = null;
    private static final long NOTIFICATION_CANCELLATION_REASONS = 175319604;
    private static final List<String> NOTIFICATION_IGNORE_LIST = null;
    private static final int NOTIFICATION_INSTANCE_ID_MAX = 8192;
    private static final long NOTIFICATION_LOG_ASSISTANT_CANCEL = 195579280;
    static final long NOTIFICATION_MAX_AGE_AT_POST = 0;
    private static final int NOTIFICATION_RAPID_CLEAR_THRESHOLD_MS = 5000;
    private static final long NOTIFICATION_TRAMPOLINE_BLOCK = 167676448;
    private static final long NOTIFICATION_TRAMPOLINE_BLOCK_FOR_EXEMPT_ROLES = 227752274;
    static final long NOTIFICATION_TTL = 0;
    private static final String NUBIA_PUSH_CLIENT_GROUPKEY = "neopush";
    private static final String NUBIA_PUSH_CLIENT_PACKAGE = "com.zte.dbneopush";
    private static final Duration POST_WAKE_LOCK_TIMEOUT = null;
    private static final long RATE_LIMIT_TOASTS = 174840628;
    public static final int REPORT_REMOTE_VIEWS = 1;
    private static final int REQUEST_CODE_TIMEOUT = 1;
    static final String REVIEW_NOTIF_ACTION_CANCELED = "REVIEW_NOTIF_ACTION_CANCELED";
    static final String REVIEW_NOTIF_ACTION_DISMISS = "REVIEW_NOTIF_ACTION_DISMISS";
    static final String REVIEW_NOTIF_ACTION_REMIND = "REVIEW_NOTIF_ACTION_REMIND";
    static final int REVIEW_NOTIF_STATE_DISMISSED = 2;
    static final int REVIEW_NOTIF_STATE_RESHOWN = 3;
    static final int REVIEW_NOTIF_STATE_SHOULD_SHOW = 0;
    static final int REVIEW_NOTIF_STATE_UNKNOWN = -1;
    static final int REVIEW_NOTIF_STATE_USER_INTERACTED = 1;
    static final String ROOT_PKG = "root";
    private static final String SCHEME_TIMEOUT = "timeout";
    static final int SHORT_DELAY = 2000;
    private static final ArrayMap<String, ArraySet<String>> SMART_CHARGING_NAVIGATION_CHANNELS = null;
    private static final ArraySet<String> SMART_CHARGING_NAVIGATION_PACKAGES = null;
    static final long SNOOZE_UNTIL_UNSPECIFIED = -1;
    public static final String TAG = "NotificationService";
    private static final String TAG_NOTIFICATION_POLICY = "notification-policy";
    static final String TOAST_QUOTA_TAG = "toast_quota_tag";
    private static final MultiRateLimiter.RateLimit[] TOAST_RATE_LIMITS = null;
    private static final Duration ZEN_BROADCAST_DELAY = null;
    private Boolean isReplaceTargetPkg;
    private AccessibilityManager mAccessibilityManager;
    private ActivityManager mActivityManager;
    private ModuleInfo mAdservicesModuleInfo;
    private AlarmManager mAlarmManager;
    private TriPredicate<String, Integer, String> mAllowedManagedServicePackages;
    private IActivityManager mAm;
    private ActivityManagerInternal mAmi;
    private AppOpsManager mAppOps;
    private AppOpsManager.OnOpChangedListener mAppOpsListener;
    private UsageStatsManagerInternal mAppUsageStats;
    private Archive mArchive;
    NotificationAssistants mAssistants;
    private ActivityTaskManagerInternal mAtm;
    protected NotificationAttentionHelper mAttentionHelper;
    private int mAutoGroupAtCount;
    final ArrayMap<Integer, ArrayMap<String, String>> mAutobundledSummaries;
    private Handler mBroadcastsHandler;
    final ArrayMap<String, ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>>> mCallNotificationEventCallbacks;
    ICompanionDeviceManager mCompanionManager;
    private ConditionProviders mConditionProviders;
    private String mDefaultSearchSelectorPkg;
    protected String[] mDefaultUnsupportedAdjustments;
    private DeviceIdleManager mDeviceIdleManager;
    private DevicePolicyManagerInternal mDpm;
    private List<ComponentName> mEffectsSuppressors;
    final ArrayList<NotificationRecord> mEnqueuedNotifications;
    private SystemUiSystemPropertiesFlags.FlagResolver mFlagResolver;
    final IBinder mForegroundToken;
    private GroupHelper mGroupHelper;
    WorkerHandler mHandler;
    private NotificationHistoryManager mHistoryManager;
    final ArrayMap<String, InlineReplyUriRecord> mInlineReplyRecordsByKey;
    private final BroadcastReceiver mIntentReceiver;
    private final NotificationManagerInternal mInternalService;
    private int mInterruptionFilter;
    private boolean mIsCurrentToastShown;
    private boolean mIsTelevision;
    private long mLastOverRateLogTime;
    private int mListenerHints;
    NotificationListeners mListeners;
    private final SparseArray<ArraySet<ComponentName>> mListenersDisablingEffects;
    protected final BroadcastReceiver mLocaleChangeReceiver;
    private boolean mLockScreenAllowSecureNotifications;
    private LockPatternUtils mLockUtils;
    private float mMaxPackageEnqueueRate;
    private MetricsLogger mMetricsLogger;
    private Set<String> mMsgPkgsAllowedAsConvos;
    private NotificationChannelLogger mNotificationChannelLogger;
    final NotificationDelegate mNotificationDelegate;
    private InstanceIdSequence mNotificationInstanceIdSequence;
    final ArrayList<NotificationRecord> mNotificationList;
    private NotificationListenerStats mNotificationListenerStats;
    final Object mNotificationLock;
    NotificationManagerPrivate mNotificationManagerPrivate;
    private NotificationRecordLogger mNotificationRecordLogger;
    private final BroadcastReceiver mNotificationTimeoutReceiver;
    final ArrayMap<String, NotificationRecord> mNotificationsByKey;
    private IObricNotificationManagerService mObricExt;
    private final BroadcastReceiver mPackageIntentReceiver;
    IPackageManager mPackageManager;
    private PackageManager mPackageManagerClient;
    PackageManagerInternal mPackageManagerInternal;
    private PermissionHelper mPermissionHelper;
    private PermissionManager mPermissionManager;
    private PermissionPolicyInternal mPermissionPolicyInternal;
    private IPlatformCompat mPlatformCompat;
    private AtomicFile mPolicyFile;
    private PostNotificationTrackerFactory mPostNotificationTrackerFactory;
    private PowerManager mPowerManager;
    PreferencesHelper mPreferencesHelper;
    private StatsPullAtomCallbackImpl mPullAtomCallback;
    protected RankingHandler mRankingHandler;
    RankingHelper mRankingHelper;
    private final HandlerThread mRankingThread;
    private boolean mRedactOtpNotifications;
    private final BroadcastReceiver mRestoreReceiver;
    private ReviewNotificationPermissionsReceiver mReviewNotificationPermissionsReceiver;
    private volatile RoleObserver mRoleObserver;
    private final SavePolicyFileRunnable mSavePolicyFile;
    final IBinder mService;
    private SettingsObserver mSettingsObserver;
    private ShortcutHelper mShortcutHelper;
    private ShortcutHelper.ShortcutListener mShortcutListener;
    protected boolean mShowReviewPermissionsNotification;
    private final NotificationManagerServiceSmtEx mSmtEx;
    protected SnoozeHelper mSnoozeHelper;
    private StatsManager mStatsManager;
    StatusBarManagerInternal mStatusBar;
    private int mStripRemoteViewsSizeBytes;
    private StrongAuthTracker mStrongAuthTracker;
    final ArrayMap<String, NotificationRecord> mSummaryByGroupKey;
    private TelecomManager mTelecomManager;
    final ArrayList<ToastRecord> mToastQueue;
    private MultiRateLimiter mToastRateLimiter;
    private final Set<Integer> mToastRateLimitingDisabledUids;
    private TimeToLiveHelper mTtlHelper;
    private IUriGrantsManager mUgm;
    private UriGrantsManagerInternal mUgmInternal;
    private UserManager mUm;
    private UserManagerInternal mUmInternal;
    protected NotificationUsageStats mUsageStats;
    private UsageStatsManagerInternal mUsageStatsManagerInternal;
    private final ManagedServices.UserProfiles mUserProfiles;
    private int mWarnRemoteViewsSizeBytes;
    private WindowManagerInternal mWindowManagerInternal;
    protected ZenModeHelper mZenModeHelper;

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$1, reason: invalid class name */
    class AnonymousClass1 implements NotificationDelegate {
        final /* synthetic */ NotificationManagerService this$0;

        public static /* synthetic */ void $r8$lambda$sNKHgUrKFGcM6C178dspNrxRjsQ(AnonymousClass1 r0, int r1, int r2, String r3, String r4, int r5, String r6, int r7) {
            r0.lambda$onNotificationError$0(r1, r2, r3, r4, r5, r6, r7);
        }

        AnonymousClass1(NotificationManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void prepareForPossibleShutdown() {
            NotificationManagerService.m6141$$Nest$fgetmHistoryManager(this.this$0).triggerWriteToDisk();
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onSetDisabled(int status) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            this.this$0.mAttentionHelper.updateDisableNotificationEffectsLocked(status);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onClearAll(int callingUid, int callingPid, int userId) {
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            this.this$0.cancelAllLocked(callingUid, callingPid, userId, 3, null, true, 34);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Throwable r11 = th;
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L9
            throw r11;
        L11:
            th = move-exception;
            r11 = th;
            goto L13
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationClick(int callingUid, int callingPid, String key, NotificationVisibility nv) {
            NotificationManagerService.m6197$$Nest$mexitIdle(this.this$0);
            Object r9 = this.this$0.mNotificationLock;
            monitor-enter(r9);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L9
            if (r != null) goto L11;
            Slog.w(NotificationManagerService.TAG, "No notification with key: " + key);     // Catch: Throwable -> L9
            monitor-exit(r9);     // Catch: Throwable -> L9
            return;
        L11:
            long now = System.currentTimeMillis();     // Catch: Throwable -> L9
            MetricsLogger.action(r.getItemLogMaker().setType(4).addTaggedData(798, Integer.valueOf(nv.rank)).addTaggedData(1395, Integer.valueOf(nv.count)));     // Catch: Throwable -> L9
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_CLICKED, r);     // Catch: Throwable -> L9
            EventLogTags.writeNotificationClicked(key, r.getLifespanMs(now), r.getFreshnessMs(now), r.getExposureMs(now), nv.rank, nv.count);     // Catch: Throwable -> L9
            StatusBarNotification sbn = r.getSbn();     // Catch: Throwable -> L9
            if ((sbn.getNotification().flags & 65536) == 0) goto L14;
            this.this$0.cancelNotification(callingUid, callingPid, sbn.getPackageName(), sbn.getTag(), sbn.getId(), 65536, 36928, false, r.getUserId(), 1, nv.rank, nv.count, null);     // Catch: Throwable -> L9
        L15:
            nv.recycle();     // Catch: Throwable -> L9
            this.this$0.reportUserInteraction(r);     // Catch: Throwable -> L9
            this.this$0.mAssistants.notifyAssistantNotificationClicked(r);     // Catch: Throwable -> L9
            monitor-exit(r9);     // Catch: Throwable -> L9
            return;
        L14:
            this.this$0.cancelNotification(callingUid, callingPid, sbn.getPackageName(), sbn.getTag(), sbn.getId(), 16, 36928, false, r.getUserId(), 1, nv.rank, nv.count, null);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationActionClick(int callingUid, int callingPid, String key, int actionIndex, Notification.Action action, NotificationVisibility nv, boolean generatedByAssistant) {
            NotificationManagerService.m6197$$Nest$mexitIdle(this.this$0);
            Object r14 = this.this$0.mNotificationLock;
            monitor-enter(r14);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L9
            if (r != null) goto L11;
            Slog.w(NotificationManagerService.TAG, "No notification with key: " + key);     // Catch: Throwable -> L9
            monitor-exit(r14);     // Catch: Throwable -> L9
            return;
        L11:
            long now = System.currentTimeMillis();     // Catch: Throwable -> L9
            LogMaker r6 = r.getLogMaker(now).setCategory(129).setType(4).setSubtype(actionIndex).addTaggedData(798, Integer.valueOf(nv.rank)).addTaggedData(1395, Integer.valueOf(nv.count));     // Catch: Throwable -> L9
            int r8 = 0;
            if (action.isContextual() == false) goto L14;
            int r7 = 1;
        L15:
            LogMaker r9 = r6.addTaggedData(1601, Integer.valueOf(r7));     // Catch: Throwable -> L9
            if (generatedByAssistant == false) goto L18;
            r8 = 1;
        L18:
            MetricsLogger.action(r9.addTaggedData(1600, Integer.valueOf(r8)).addTaggedData(1629, Integer.valueOf(nv.location.toMetricsEventEnum())));     // Catch: Throwable -> L9
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationEvent.fromAction(actionIndex, generatedByAssistant, action.isContextual()), r);     // Catch: Throwable -> L9
            EventLogTags.writeNotificationActionClicked(key, action.actionIntent.getTarget().toString(), action.actionIntent.getIntent().toString(), actionIndex, r.getLifespanMs(now), r.getFreshnessMs(now), r.getExposureMs(now), nv.rank, nv.count);     // Catch: Throwable -> L9
            nv.recycle();     // Catch: Throwable -> L9
            this.this$0.reportUserInteraction(r);     // Catch: Throwable -> L9
            this.this$0.mAssistants.notifyAssistantActionClicked(r, action, generatedByAssistant);     // Catch: Throwable -> L9
            this.this$0.mHandler.scheduleCancelNotification(new CancelNotificationRunnable(this.this$0, callingUid, callingPid, r.getSbn().getPackageName(), r.getSbn().getTag(), r.getSbn().getId(), 65536, 8192, false, r.getUserId(), 1, -1, -1, null, SystemClock.elapsedRealtime()), 200);     // Catch: Throwable -> L9
            monitor-exit(r14);     // Catch: Throwable -> L9
            return;
        L14:
            r7 = 0;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationClear(int callingUid, int callingPid, String pkg, int userId, String key, int dismissalSurface, int dismissalSentiment, NotificationVisibility nv) {
            Object r5 = this.this$0.mNotificationLock;
            monitor-enter(r5);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L23
            if (r != null) goto L33;
            String tag = null;
            int id = 0;
        L29:
            monitor-exit(r5);     // Catch: Throwable -> L21
            this.this$0.cancelNotification(callingUid, callingPid, pkg, tag, id, 0, 8192, true, userId, 2, nv.rank, nv.count, null);
            nv.recycle();
            return;
        L21:
            th = th;
        L27:
            monitor-exit(r5);     // Catch: Throwable -> L13
        L13:
            th = th;
            goto L27
        L28:
            throw th;
        L33:
            r.recordDismissalSurface(dismissalSurface);     // Catch: Throwable -> L15
            r.recordDismissalSentiment(dismissalSentiment);     // Catch: Throwable -> L13
            String tag2 = r.getSbn().getTag();     // Catch: Throwable -> L13
            int id2 = r.getSbn().getId();     // Catch: Throwable -> L13
            tag = tag2;
            id = id2;
            goto L29
        L39:
            th = th;
        L15:
            th = th;
        L23:
            th = th;
        L25:
            th = th;
            goto L27
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onPanelRevealed(boolean clearEffects, int items) {
            MetricsLogger.visible(this.this$0.getContext(), 127);
            MetricsLogger.histogram(this.this$0.getContext(), "note_load", items);
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationPanelEvent.NOTIFICATION_PANEL_OPEN);
            EventLogTags.writeNotificationPanelRevealed(items);
            if (clearEffects == false) goto L5;
            clearEffects();
        L5:
            this.this$0.mAssistants.onPanelRevealed(items);
            NotificationManagerService.m6152$$Nest$fgetmObricExt(this.this$0).onPanelShown();
            this.this$0.getSmtEx().reportPanelShown(true);
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onPanelHidden() {
            MetricsLogger.hidden(this.this$0.getContext(), 127);
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationPanelEvent.NOTIFICATION_PANEL_CLOSE);
            EventLogTags.writeNotificationPanelHidden();
            this.this$0.mAssistants.onPanelHidden();
            NotificationManagerService.m6152$$Nest$fgetmObricExt(this.this$0).onPanelHidden();
            this.this$0.getSmtEx().reportPanelShown(false);
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void clearEffects() {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (NotificationManagerService.DBG == false) goto L9;
            Slog.d(NotificationManagerService.TAG, "clearEffects");     // Catch: Throwable -> L7
        L9:
            this.this$0.mAttentionHelper.clearAttentionEffects();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationError(int callingUid, int callingPid, final String pkg, final String tag, final int id, final int uid, final int initialPid, final String message, int userId) {
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            NotificationRecord r = this.this$0.findNotificationLocked(pkg, tag, id, userId);     // Catch: Throwable -> L9
            boolean r3 = false;
            if (r != null) goto L7;
        L11:
            boolean r5 = false;
        L12:
            boolean fgService = r5;
            if (r != null) goto L15;
        L17:
            boolean uiJob = r3;
            monitor-exit(r2);     // Catch: Throwable -> L9
            this.this$0.cancelNotification(callingUid, callingPid, pkg, tag, id, 0, 0, false, userId, 4, null);
            if (fgService == true) goto L22;
            if (uiJob == true) goto L22;
            return;
        L22:
            if (fgService == false) goto L24;
            final int exceptionTypeId = 3;
        L25:
            Binder.withCleanCallingIdentity(new NotificationManagerService$1$$ExternalSyntheticLambda0(this, uid, initialPid, pkg, tag, id, message, exceptionTypeId));
            return;
        L24:
            exceptionTypeId = 6;
            goto L25
        L15:
            if ((r.getNotification().flags & 32768) == 0) goto L17;
            r3 = true;
            goto L17
        L7:
            if ((r.getNotification().flags & 64) == 0) goto L11;
            r5 = true;
        L9:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$onNotificationError$0(int uid, int initialPid, String pkg, String tag, int id, String message, int exceptionTypeId) throws Exception {
            NotificationManagerService.m6131$$Nest$fgetmAm(this.this$0).crashApplicationWithType(uid, initialPid, pkg, -1, "Bad notification(tag=" + tag + ", id=" + id + ") posted from package " + pkg + ", crashing app(uid=" + uid + ", pid=" + initialPid + "): " + message, true, exceptionTypeId);
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationVisibilityChanged(NotificationVisibility[] newlyVisibleKeys, NotificationVisibility[] noLongerVisibleKeys) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            int r1 = newlyVisibleKeys.length;     // Catch: Throwable -> L14
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L27;
            NotificationVisibility nv = newlyVisibleKeys[r3];     // Catch: Throwable -> L14
            NotificationRecord r = this.this$0.mNotificationsByKey.get(nv.key);     // Catch: Throwable -> L14
            if (r != null) goto L10;
        L26:
            r3 = r3 + 1;     // Catch: Throwable -> L14
            goto L5
        L10:
            if (r.isSeen() == false) goto L12;
        L17:
            boolean isHun = true;
            r.setVisibility(true, nv.rank, nv.count, NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0));     // Catch: Throwable -> L14
            this.this$0.mAssistants.notifyAssistantVisibilityChangedLocked(r, true);     // Catch: Throwable -> L14
            if (nv.location == NotificationVisibility.NotificationLocation.LOCATION_FIRST_HEADS_UP) goto L21;
            isHun = false;
        L21:
            if (isHun == false) goto L23;
        L24:
            this.this$0.logSmartSuggestionsVisible(r, nv.location.toMetricsEventEnum());     // Catch: Throwable -> L14
        L25:
            this.this$0.maybeRecordInterruptionLocked(r);     // Catch: Throwable -> L14
            nv.recycle();     // Catch: Throwable -> L14
            goto L26
        L23:
            if (r.hasBeenVisiblyExpanded() == false) goto L25;
        L12:
            if (NotificationManagerService.DBG == false) goto L16;
            Slog.d(NotificationManagerService.TAG, "Marking notification as visible " + nv.key);     // Catch: Throwable -> L14
        L16:
            this.this$0.reportSeen(r);     // Catch: Throwable -> L14
            goto L17
        L27:
            int r2 = noLongerVisibleKeys.length;     // Catch: Throwable -> L14
            int r4 = 0;
        L28:
            if (r4 >= r2) goto L34;
            NotificationVisibility nv2 = noLongerVisibleKeys[r4];     // Catch: Throwable -> L14
            NotificationRecord r5 = this.this$0.mNotificationsByKey.get(nv2.key);     // Catch: Throwable -> L14
            if (r5 == null) goto L33;
            r5.setVisibility(false, nv2.rank, nv2.count, NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0));     // Catch: Throwable -> L14
            this.this$0.mAssistants.notifyAssistantVisibilityChangedLocked(r5, false);     // Catch: Throwable -> L14
            nv2.recycle();     // Catch: Throwable -> L14
        L33:
            r4 = r4 + 1;     // Catch: Throwable -> L14
            goto L28
        L34:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationExpansionChanged(String key, boolean userAction, boolean expanded, int notificationLocation) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L9
            if (r == null) goto L21;
            r.stats.onExpansionChanged(userAction, expanded);     // Catch: Throwable -> L9
            if (r.hasBeenVisiblyExpanded() == false) goto L11;
            this.this$0.logSmartSuggestionsVisible(r, notificationLocation);     // Catch: Throwable -> L9
        L11:
            if (userAction == false) goto L17;
            LogMaker r2 = r.getItemLogMaker();     // Catch: Throwable -> L9
            if (expanded == false) goto L15;
            int r3 = 3;
        L16:
            MetricsLogger.action(r2.setType(r3));     // Catch: Throwable -> L9
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationEvent.fromExpanded(expanded, userAction), r);     // Catch: Throwable -> L9
            goto L17
        L15:
            r3 = 14;
        L17:
            if (expanded == false) goto L20;
            if (userAction == false) goto L20;
            r.recordExpanded();     // Catch: Throwable -> L9
            this.this$0.reportUserInteraction(r);     // Catch: Throwable -> L9
        L20:
            this.this$0.mAssistants.notifyAssistantExpansionChangedLocked(r.getSbn(), r.getNotificationType(), userAction, expanded);     // Catch: Throwable -> L9
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationDirectReplied(String key) {
            NotificationManagerService.m6197$$Nest$mexitIdle(this.this$0);
            String packageName = null;
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L7
            if (r == null) goto L9;
            packageName = r.getSbn().getPackageName();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (packageName == null) goto L12;
            int packageImportance = NotificationManagerService.m6202$$Nest$mgetPackageImportanceWithIdentity(this.this$0, packageName);
        L13:
            Object r3 = this.this$0.mNotificationLock;
            monitor-enter(r3);
            NotificationRecord r2 = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L18
            if (r2 == null) goto L20;
            r2.setCanceledAfterLifetimeExtension(false);     // Catch: Throwable -> L18
            NotificationManagerService.m6225$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedLocked(this.this$0, r2, r2.getSbn().getPackageName(), packageImportance);     // Catch: Throwable -> L18
            r2.recordDirectReplied();     // Catch: Throwable -> L18
            NotificationManagerService.m6147$$Nest$fgetmMetricsLogger(this.this$0).write(r2.getLogMaker().setCategory(1590).setType(4));     // Catch: Throwable -> L18
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_DIRECT_REPLIED, r2);     // Catch: Throwable -> L18
            this.this$0.reportUserInteraction(r2);     // Catch: Throwable -> L18
            this.this$0.mAssistants.notifyAssistantNotificationDirectReplyLocked(r2);     // Catch: Throwable -> L18
        L20:
            monitor-exit(r3);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        L12:
            packageImportance = 0;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationSmartSuggestionsAdded(String key, int smartReplyCount, int smartActionCount, boolean generatedByAssistant, boolean editBeforeSending) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L7
            if (r == null) goto L9;
            r.setNumSmartRepliesAdded(smartReplyCount);     // Catch: Throwable -> L7
            r.setNumSmartActionsAdded(smartActionCount);     // Catch: Throwable -> L7
            r.setSuggestionsGeneratedByAssistant(generatedByAssistant);     // Catch: Throwable -> L7
            r.setEditChoicesBeforeSending(editBeforeSending);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationSmartReplySent(String key, int replyIndex, CharSequence reply, int notificationLocation, boolean modifiedBeforeSending) {
            String packageName = null;
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L7
            if (r == null) goto L9;
            packageName = r.getSbn().getPackageName();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (packageName == null) goto L12;
            int packageImportance = NotificationManagerService.m6202$$Nest$mgetPackageImportanceWithIdentity(this.this$0, packageName);
        L13:
            Object r3 = this.this$0.mNotificationLock;
            monitor-enter(r3);
            NotificationRecord r2 = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L29
            if (r2 == null) goto L31;
            int r4 = 0;
            r2.setCanceledAfterLifetimeExtension(false);     // Catch: Throwable -> L29
            NotificationManagerService.m6225$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedLocked(this.this$0, r2, r2.getSbn().getPackageName(), packageImportance);     // Catch: Throwable -> L29
            r2.recordSmartReplied();     // Catch: Throwable -> L29
            LogMaker r5 = r2.getLogMaker().setCategory(1383).setSubtype(replyIndex);     // Catch: Throwable -> L29
            if (r2.getSuggestionsGeneratedByAssistant() == false) goto L20;
            int r6 = 1;
        L21:
            LogMaker r7 = r5.addTaggedData(1600, Integer.valueOf(r6)).addTaggedData(1629, Integer.valueOf(notificationLocation));     // Catch: Throwable -> L29
            if (r2.getEditChoicesBeforeSending() == false) goto L24;
            int r8 = 1;
        L25:
            LogMaker r9 = r7.addTaggedData(1647, Integer.valueOf(r8));     // Catch: Throwable -> L29
            if (modifiedBeforeSending == false) goto L28;
            r4 = 1;
        L28:
            LogMaker logMaker = r9.addTaggedData(1648, Integer.valueOf(r4));     // Catch: Throwable -> L29
            NotificationManagerService.m6147$$Nest$fgetmMetricsLogger(this.this$0).write(logMaker);     // Catch: Throwable -> L29
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_SMART_REPLIED, r2);     // Catch: Throwable -> L29
            this.this$0.reportUserInteraction(r2);     // Catch: Throwable -> L29
            this.this$0.mAssistants.notifyAssistantSuggestedReplySent(r2.getSbn(), r2.getNotificationType(), reply, r2.getSuggestionsGeneratedByAssistant());     // Catch: Throwable -> L29
            goto L31
        L24:
            r8 = 0;
            goto L25
        L20:
            r6 = 0;
        L31:
            monitor-exit(r3);     // Catch: Throwable -> L29
            return;
        L29:
            th = move-exception;
            throw th;
        L12:
            packageImportance = 0;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationSettingsViewed(String key) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L7
            if (r == null) goto L9;
            r.recordViewedSettings();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationBubbleChanged(String key, boolean isBubble, int bubbleFlags) {
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L8
            if (r == null) goto L14;
            if (isBubble == true) goto L10;
            r.getNotification().flags &= -4097;     // Catch: Throwable -> L8
            r.setFlagBubbleRemoved(true);     // Catch: Throwable -> L8
            goto L14
        L10:
            r.getNotification().flags |= 8;     // Catch: Throwable -> L8
            r.setFlagBubbleRemoved(false);     // Catch: Throwable -> L8
            if (r.getNotification().getBubbleMetadata() == null) goto L13;
            r.getNotification().getBubbleMetadata().setFlags(bubbleFlags);     // Catch: Throwable -> L8
        L13:
            this.this$0.mHandler.post(new EnqueueNotificationRunnable(this.this$0, r.getUser().getIdentifier(), r, true, false, NotificationManagerService.m6157$$Nest$fgetmPostNotificationTrackerFactory(this.this$0).newTracker(null)));     // Catch: Throwable -> L8
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onBubbleMetadataFlagChanged(String key, int flags) {
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L10
            if (r == null) goto L18;
            Notification.BubbleMetadata data = r.getNotification().getBubbleMetadata();     // Catch: Throwable -> L10
            if (data != null) goto L13;
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L13:
            if (flags == data.getFlags()) goto L18;
            int changedFlags = data.getFlags() ^ flags;     // Catch: Throwable -> L10
            if ((changedFlags & 2) == 0) goto L17;
            this.this$0.mAttentionHelper.clearEffectsLocked(key);     // Catch: Throwable -> L10
        L17:
            data.setFlags(flags);     // Catch: Throwable -> L10
            r.getNotification().flags |= 8;     // Catch: Throwable -> L10
            this.this$0.mHandler.post(new EnqueueNotificationRunnable(this.this$0, r.getUser().getIdentifier(), r, true, false, NotificationManagerService.m6157$$Nest$fgetmPostNotificationTrackerFactory(this.this$0).newTracker(null)));     // Catch: Throwable -> L10
        L18:
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void grantInlineReplyUriPermission(String key, Uri uri, UserHandle user, String packageName, int callingUid) {
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            InlineReplyUriRecord r = this.this$0.mInlineReplyRecordsByKey.get(key);     // Catch: Throwable -> L11
            if (r != null) goto L13;
            InlineReplyUriRecord newRecord = new InlineReplyUriRecord(NotificationManagerService.m6166$$Nest$fgetmUgmInternal(this.this$0).newUriPermissionOwner("INLINE_REPLY:" + key), user, packageName, key);     // Catch: Throwable -> L9
            this.this$0.mInlineReplyRecordsByKey.put(key, newRecord);     // Catch: Throwable -> L9
            InlineReplyUriRecord newRecord2 = newRecord;
        L14:
            IBinder owner = newRecord2.getPermissionOwner();     // Catch: Throwable -> L9
            int userId = newRecord2.getUserId();     // Catch: Throwable -> L9
            if (UserHandle.getUserId(callingUid) != userId) goto L31;
        L25:
            int uid = callingUid;
        L26:
            newRecord2.addUri(uri);     // Catch: Throwable -> L9
            NotificationManagerService.m6204$$Nest$mgrantUriPermission(this.this$0, owner, uri, uid, newRecord2.getPackageName(), userId);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            return;
        L31:
            String[] pkgs = this.this$0.mPackageManager.getPackagesForUid(callingUid);     // Catch: Throwable -> L9 RemoteException -> L19
            if (pkgs != null) goto L21;
            Log.e(NotificationManagerService.TAG, "Cannot grant uri permission to unknown UID: " + callingUid);     // Catch: Throwable -> L9 RemoteException -> L19
        L21:
            String pkg = pkgs[0];     // Catch: Throwable -> L9 RemoteException -> L19
            int uid2 = this.this$0.mPackageManager.getPackageUid(pkg, 0, userId);     // Catch: Throwable -> L9 RemoteException -> L19
            uid = uid2;
            goto L26
        L19:
            re = move-exception;
            Log.e(NotificationManagerService.TAG, "Cannot talk to package manager", re);     // Catch: Throwable -> L9
        L9:
            th = th;
        L29:
            monitor-exit(r2);     // Catch: Throwable -> L9
            throw th;
        L13:
            newRecord2 = r;
        L11:
            th = th;
            goto L29
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void clearInlineReplyUriPermissions(String key, int callingUid) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            InlineReplyUriRecord uriRecord = this.this$0.mInlineReplyRecordsByKey.get(key);     // Catch: Throwable -> L7
            if (uriRecord == null) goto L9;
            NotificationManagerService.m6192$$Nest$mdestroyPermissionOwner(this.this$0, uriRecord.getPermissionOwner(), uriRecord.getUserId(), "INLINE_REPLY: " + uriRecord.getKey());     // Catch: Throwable -> L7
            this.this$0.mInlineReplyRecordsByKey.remove(key);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationDelegate
        public void onNotificationFeedbackReceived(String key, Bundle feedback) {
            NotificationManagerService.m6197$$Nest$mexitIdle(this.this$0);
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L9
            if (r == null) goto L7;
            this.this$0.mAssistants.notifyAssistantFeedbackReceived(r, feedback);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L7:
            if (NotificationManagerService.DBG == false) goto L11;
            Slog.w(NotificationManagerService.TAG, "No notification with key: " + key);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$11, reason: invalid class name */
    class AnonymousClass11 implements GroupHelper.Callback {
        final /* synthetic */ NotificationManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$OX5ioLFuOBbDLaaVANlyLDNqkuA(int r0, int r1, int r2) {
            return lambda$removeNotificationFromCanceledGroup$0(r0, r1, r2);
        }

        public static /* synthetic */ boolean $r8$lambda$_K091Ww5X4_ngsPxFGjkEBBzLoY(NotificationRecord r0, int r1, String r2, String r3) {
            return NotificationManagerService.m6254$$Nest$smwasChildOfForceRegroupedGroupChecker(r0, r1, r2, r3);
        }

        AnonymousClass11(NotificationManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void addAutoGroup(String key, String groupName, boolean requestSort) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord r = this.this$0.mNotificationsByKey.get(key);     // Catch: Throwable -> L11
            if (r != null) goto L7;
        L14:
            this.this$0.addAutogroupKeyLocked(key, groupName, requestSort);     // Catch: Throwable -> L11
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (NotificationManagerService.NUBIA_PUSH_CLIENT_PACKAGE.equals(r.getSbn().getOpPkg()) == true) goto L9;
        L13:
            this.this$0.convertSummaryToNotificationLocked(key);     // Catch: Throwable -> L11
            this.this$0.addAutogroupKeyLocked(key, groupName, requestSort);     // Catch: Throwable -> L11
            goto L15
        L9:
            if (NotificationManagerService.NUBIA_PUSH_CLIENT_GROUPKEY.equals(r.getSbn().getGroup()) == true) goto L14;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void removeAutoGroup(String key) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            this.this$0.removeAutogroupKeyLocked(key);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void addAutoGroupSummary(int userId, String pkg, String triggeringKey, String groupName, int summaryId, GroupHelper.NotificationAttributes summaryAttr) {
            NotificationRecord r = this.this$0.createAutoGroupSummary(userId, pkg, triggeringKey, groupName, summaryId, summaryAttr);
            if (r == null) goto L11;
            if (NotificationManagerService.m6129$$Nest$fgetmActivityManager(this.this$0).getPackageImportance(pkg) != 100) goto L8;
            boolean r0 = true;
        L7:
            boolean isAppForeground = r0;
            this.this$0.mHandler.post(new EnqueueNotificationRunnable(this.this$0, userId, r, isAppForeground, false, NotificationManagerService.m6157$$Nest$fgetmPostNotificationTrackerFactory(this.this$0).newTracker(null)));
            return;
        L8:
            r0 = false;
            goto L7
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void removeAutoGroupSummary(int userId, String pkg, String groupKey) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            this.this$0.clearAutogroupSummaryLocked(userId, pkg, groupKey);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void updateAutogroupSummary(int userId, String pkg, String groupKey, GroupHelper.NotificationAttributes summaryAttr) {
            if (pkg != null) goto L4;
        L6:
            boolean r0 = false;
        L7:
            boolean isAppForeground = r0;
            Object r7 = this.this$0.mNotificationLock;
            monitor-enter(r7);
            this.this$0.updateAutobundledSummaryLocked(userId, pkg, groupKey, summaryAttr, isAppForeground);     // Catch: Throwable -> L14
            monitor-exit(r7);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            Throwable r9 = th;
        L18:
            monitor-exit(r7);     // Catch: Throwable -> L14
            throw r9;
        L16:
            th = move-exception;
            r9 = th;
            goto L18
        L4:
            if (NotificationManagerService.m6129$$Nest$fgetmActivityManager(this.this$0).getPackageImportance(pkg) != 100) goto L6;
            r0 = true;
            goto L7
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void removeAppProvidedSummary(String key) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            this.this$0.removeAppSummaryLocked(key);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void sendAppProvidedSummaryDeleteIntent(String pkg, PendingIntent deleteIntent) {
            NotificationManagerService.m6253$$Nest$smsendDeleteIntent(deleteIntent, pkg);
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public void removeNotificationFromCanceledGroup(int userId, String pkg, String groupKey, final int cancelReason) {
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            final int mustNotHaveFlags = 98368;
            FlagChecker childrenFlagChecker = new NotificationManagerService$11$$ExternalSyntheticLambda0(cancelReason, mustNotHaveFlags);     // Catch: Throwable -> L10
            NotificationManagerService.m6181$$Nest$mcancelGroupChildrenLocked(this.this$0, userId, pkg, Binder.getCallingUid(), Binder.getCallingPid(), null, false, childrenFlagChecker, new NotificationManagerService$11$$ExternalSyntheticLambda1(), groupKey, 8, SystemClock.elapsedRealtime());     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            return;
        L10:
            th = th;
        L14:
            monitor-exit(r2);     // Catch: Throwable -> L10
            throw th;
        L12:
            th = th;
            goto L14
        }

        private static /* synthetic */ boolean lambda$removeNotificationFromCanceledGroup$0(int cancelReason, int mustNotHaveFlags, int flags) {
            if (cancelReason == 2) goto L8;
            if (cancelReason == 1) goto L8;
            if (cancelReason == 3) goto L8;
        L11:
            if ((flags & mustNotHaveFlags) == 0) goto L13;
            return false;
        L13:
            return true;
        L8:
            if ((flags & 4096) == 0) goto L11;
            return false;
        }

        @Override // com.android.server.notification.GroupHelper.Callback
        public NotificationRecord removeAppProvidedSummaryOnClassification(String triggeringKey, String oldGroupKey) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord r1 = this.this$0.removeAppProvidedSummaryOnClassificationLocked(triggeringKey, oldGroupKey);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$12, reason: invalid class name */
    class AnonymousClass12 extends INotificationManager.Stub {
        final /* synthetic */ NotificationManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$-bEcbv2XyMra1ibE6xDuYV909N4, reason: not valid java name */
        public static /* synthetic */ void m6255$r8$lambda$bEcbv2XyMra1ibE6xDuYV909N4(AnonymousClass12 r0, ArrayList r1) {
            r0.lambda$getActiveNotificationsWithAttribution$0(r1);
        }

        public static /* synthetic */ Boolean $r8$lambda$9e1Zv0Eb_mTwUeFMV5TGSei42ck(int r0) {
            return lambda$canManageGlobalZenPolicy$3(r0);
        }

        public static /* synthetic */ void $r8$lambda$AiVXW_Mz68xRVFQJEQCJ4W9_HZQ(AnonymousClass12 r0, UserHandle r1, int r2, int r3, ManagedServices.ManagedServiceInfo r4, int r5) {
            r0.lambda$requestInterruptionFilterFromListener$1(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ Boolean $r8$lambda$yqPQmPTqL0XGRX7x2Rn5ugf6JAE(AnonymousClass12 r0, int r1) {
            return r0.lambda$validateAutomaticZenRule$2(r1);
        }

        AnonymousClass12(NotificationManagerService this$0) {
            this.this$0 = this$0;
        }

        public IObricNotificationManager getIObricExt() {
            return NotificationManagerService.m6152$$Nest$fgetmObricExt(this.this$0).getIObricExt();
        }

        public boolean enqueueTextToast(String pkg, IBinder token, CharSequence text, int duration, boolean isUiContext, int displayId, ITransientNotificationCallback textCallback) {
            return enqueueToast(pkg, token, text, null, duration, isUiContext, displayId, textCallback);
        }

        public boolean enqueueToast(String pkg, IBinder token, ITransientNotification callback, int duration, boolean isUiContext, int displayId) {
            return enqueueToast(pkg, token, null, callback, duration, isUiContext, displayId, null);
        }

        private boolean enqueueToast(String pkg, IBinder token, CharSequence text, ITransientNotification callback, int duration, boolean isUiContext, int displayId, ITransientNotificationCallback textCallback) {
            return enqueueToastWithType(pkg, token, text, callback, duration, isUiContext, displayId, textCallback, 2005);
        }

        public boolean enqueueToastWithType(String pkg, IBinder token, CharSequence text, ITransientNotification callback, int duration, boolean isUiContext, int displayId, ITransientNotificationCallback textCallback, int type) {
            if (NotificationManagerService.DBG == false) goto L5;
            Slog.i(NotificationManagerService.TAG, "enqueueToast pkg=" + pkg + " token=" + token + " duration=" + duration + " isUiContext=" + isUiContext + " displayId=" + displayId);
        L5:
            boolean r14 = false;
            if (pkg == null) goto L138;
            if (text != null) goto L11;
            if (callback == null) goto L138;
        L11:
            if (text == null) goto L13;
            if (callback != null) goto L138;
        L13:
            if (token == null) goto L138;
            int callingUid = Binder.getCallingUid();
            if (isUiContext == true) goto L26;
            if (displayId != 0) goto L26;
            if (NotificationManagerService.m6167$$Nest$fgetmUm(this.this$0).isVisibleBackgroundUsersSupported() == false) goto L26;
            int userId = UserHandle.getUserId(callingUid);
            int userDisplayId = NotificationManagerService.m6168$$Nest$fgetmUmInternal(this.this$0).getMainDisplayAssignedToUser(userId);
            if (displayId == userDisplayId) goto L26;
            if (NotificationManagerService.DBG == false) goto L25;
            Slogf.d(NotificationManagerService.TAG, "Changing display id from %d to %d on user %d", new Object[]{Integer.valueOf(displayId), Integer.valueOf(userDisplayId), Integer.valueOf(userId)});
        L25:
            int displayId2 = userDisplayId;
        L27:
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, pkg);
            if (this.this$0.isCallerSystemOrSystemUi() == false) goto L30;
        L33:
            boolean isSystemToast = true;
        L35:
            if (callback == null) goto L37;
            boolean isAppRenderedToast = true;
        L39:
            if (checkCanEnqueueToast(pkg, callingUid, displayId2, isAppRenderedToast, isSystemToast) == true) goto L157;
            return false;
        L157:
            int prefetchState = SysOptBridge.getFactory().getSysPrefetchService().getPrefetchStateByInfo(pkg, callingUid);     // Catch: Exception -> L47
            if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(prefetchState) == false) goto L51;
            if (NotificationManagerService.DBG == false) goto L49;
            Slog.i(NotificationManagerService.TAG, "prefetch ignore toast. callingUid=" + callingUid + " pkg=" + pkg + " token=" + token + " duration=" + duration + " displayId=" + displayId2);     // Catch: Exception -> L47
        L49:
            return false;
        L51:
            ArrayList<ToastRecord> r4 = this.this$0.mToastQueue;
            monitor-enter(r4);
            int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L133
            long callingId = Binder.clearCallingIdentity();     // Catch: Throwable -> L133
            int index = this.this$0.indexOfToastLocked(pkg, token);     // Catch: Throwable -> L129
            if (index < 0) goto L62;
            this.this$0.mToastQueue.get(index).update(duration);     // Catch: Throwable -> L59
            AnonymousClass12 r15 = this;
            boolean r20 = false;
            boolean r31 = true;
        L114:
            if (index != 0) goto L116;
            r15.this$0.showNextToastLocked(r20);     // Catch: Throwable -> L107
        L107:
            th = th;
        L131:
            Binder.restoreCallingIdentity(callingId);     // Catch: Throwable -> L119
            throw th;     // Catch: Throwable -> L119
        L116:
            Binder.restoreCallingIdentity(callingId);     // Catch: Throwable -> L119
            monitor-exit(r4);     // Catch: Throwable -> L119
            return r31;
        L59:
            th = th;
            goto L131
        L62:
            int N = this.this$0.mToastQueue.size();     // Catch: Throwable -> L129
            int i = 0;
            int count = 0;
        L64:
            if (i >= N) goto L84;
            ToastRecord r = this.this$0.mToastQueue.get(i);     // Catch: Throwable -> L79
            if (r.pkg.equals(pkg) == false) goto L82;
            int count2 = count + 1;     // Catch: Throwable -> L79
            boolean r21 = r14;
            if (count2 >= 5) goto L69;
            count = count2;
        L83:
            i = i + 1;
            r14 = r21;
            index = index;
            callingUid = callingUid;
            goto L64
        L69:
            StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L79
            r0.append("Package has already queued ");     // Catch: Throwable -> L77
            r0.append(count2);     // Catch: Throwable -> L77
            r0.append(" toasts. Not showing more. Package=");     // Catch: Throwable -> L77
            r0.append(pkg);     // Catch: Throwable -> L77
            Slog.e(NotificationManagerService.TAG, r0.toString());     // Catch: Throwable -> L77
            Binder.restoreCallingIdentity(callingId);     // Catch: Throwable -> L75
            monitor-exit(r4);     // Catch: Throwable -> L75
            return r21;
        L75:
            th = th;
        L135:
            monitor-exit(r4);     // Catch: Throwable -> L119
            throw th;
        L77:
            th = th;
            goto L131
        L82:
            r21 = r14;
        L79:
            th = th;
            goto L131
        L84:
            int callingUid2 = callingUid;
            r20 = r14;
            r31 = true;
            Binder windowToken = new Binder();     // Catch: Throwable -> L127
            if (TextUtils.equals(pkg, SceneUtils.PKG_SYS_UI) == false) goto L89;
            int type2 = 2020;
        L159:
            int toastType = GameKeysHelper.getToastType(pkg);     // Catch: Throwable -> L125
            if (toastType == (-1)) goto L99;
            int type3 = toastType;
        L149:
            NotificationManagerService.m6171$$Nest$fgetmWindowManagerInternal(this.this$0).addWindowToken(windowToken, type3, displayId2, null);     // Catch: Throwable -> L123
            r15 = this;
            boolean isSystemToast2 = isSystemToast;
            ToastRecord record = NotificationManagerService.m6203$$Nest$mgetToastRecord(this.this$0, callingUid2, callingPid, pkg, isSystemToast2, token, text, callback, duration, windowToken, displayId2, textCallback, type3);     // Catch: Throwable -> L121
            int systemToastInsertIdx = r15.this$0.mToastQueue.size();     // Catch: Throwable -> L107
            if (isSystemToast2 == false) goto L110;
            systemToastInsertIdx = r15.getInsertIndexForSystemToastLocked();     // Catch: Throwable -> L107
        L110:
            if (systemToastInsertIdx >= r15.this$0.mToastQueue.size()) goto L112;
            int index2 = systemToastInsertIdx;
            r15.this$0.mToastQueue.add(index2, record);     // Catch: Throwable -> L107
        L113:
            NotificationManagerService.m6223$$Nest$mkeepProcessAliveForToastIfNeededLocked(r15.this$0, callingPid);     // Catch: Throwable -> L107
            index = index2;
            goto L114
        L112:
            r15.this$0.mToastQueue.add(record);     // Catch: Throwable -> L107
            index2 = r15.this$0.mToastQueue.size() - 1;     // Catch: Throwable -> L107
        L121:
            th = th;
        L123:
            th = th;
            goto L131
        L99:
            type3 = type2;
        L125:
            th = th;
            goto L131
        L89:
            if (TextUtils.equals(pkg, "com.bytedanceos.keyguard") == false) goto L91;
            type2 = 2010;
            goto L159
        L91:
            if (TextUtils.equals(pkg, "com.obric.screenshot") == false) goto L94;
            type2 = 2036;
            goto L159
        L94:
            type2 = type;
        L127:
            th = th;
        L129:
            th = th;
        L119:
            th = th;
        L133:
            th = th;
            goto L135
        L37:
            isAppRenderedToast = false;
            goto L39
        L30:
            if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(pkg) == true) goto L33;
            isSystemToast = false;
        L26:
            displayId2 = displayId;
        L138:
            Slog.e(NotificationManagerService.TAG, "Not enqueuing toast. pkg=" + pkg + " text=" + text + " callback= token=" + token);
            return false;
        }

        private int getInsertIndexForSystemToastLocked() {
            int idx = 0;
            Iterator<ToastRecord> r1 = this.this$0.mToastQueue.iterator();
        L4:
            if (r1.hasNext() == false) goto L14;
            ToastRecord r = r1.next();
            if (idx != 0) goto L11;
            if (NotificationManagerService.m6143$$Nest$fgetmIsCurrentToastShown(this.this$0) == false) goto L11;
            idx = idx + 1;
        L11:
            if (r.isSystemToast == false) goto L12;
            idx = idx + 1;
            goto L4
        L12:
            return idx;
        L14:
            return idx;
        }

        private boolean checkCanEnqueueToast(String pkg, int callingUid, int displayId, boolean isAppRenderedToast, boolean isSystemToast) {
            boolean isPackageSuspended = isPackagePaused(pkg);
            boolean notificationsDisabledForPackage = !areNotificationsEnabledForPackage(pkg, callingUid);
            if (GameKeysHelper.GAME_APP_TOAST_WHITE_LIST.contains(pkg) == false) goto L5;
            return true;
        L5:
            long callingIdentity = Binder.clearCallingIdentity();
            if (NotificationManagerService.m6129$$Nest$fgetmActivityManager(this.this$0).getUidImportance(callingUid) != 100) goto L10;
            boolean appIsForeground = true;
        L11:
            Binder.restoreCallingIdentity(callingIdentity);
            if (isSystemToast == true) goto L23;
            if (notificationsDisabledForPackage == false) goto L15;
            if (appIsForeground == true) goto L15;
        L16:
            StringBuilder r7 = new StringBuilder();
            r7.append("Suppressing toast from package ");
            r7.append(pkg);
            if (isPackageSuspended == false) goto L19;
            String r11 = " due to package suspended.";
        L20:
            r7.append(r11);
            Slog.e(NotificationManagerService.TAG, r7.toString());
            return false;
        L19:
            r11 = " by user request.";
        L15:
            if (isPackageSuspended == true) goto L16;
        L23:
            if (NotificationManagerService.m6179$$Nest$mblockToast(this.this$0, callingUid, isSystemToast, isAppRenderedToast, NotificationManagerService.m6222$$Nest$misPackageInForegroundForToast(this.this$0, callingUid)) == false) goto L26;
            Slog.w(NotificationManagerService.TAG, "Blocking custom toast from package " + pkg + " due to package not in the foreground at time the toast was posted");
            return false;
        L26:
            int userId = UserHandle.getUserId(callingUid);
            if (isSystemToast == false) goto L29;
        L32:
            return true;
        L29:
            if (NotificationManagerService.m6168$$Nest$fgetmUmInternal(this.this$0).isUserVisible(userId, displayId) == true) goto L32;
            Slog.e(NotificationManagerService.TAG, "Suppressing toast from package " + pkg + SliceClientPermissions.SliceAuthority.DELIMITER + callingUid + " as user " + userId + " is not visible on display " + displayId);
            return false;
        L10:
            appIsForeground = false;
        L33:
            th = move-exception;
            Binder.restoreCallingIdentity(callingIdentity);
            throw th;
        }

        public void cancelToast(String pkg, IBinder token) {
            Slog.i(NotificationManagerService.TAG, "cancelToast pkg=" + pkg + " token=" + token);
            if (pkg == null) goto L24;
            if (token == null) goto L24;
            ArrayList<ToastRecord> r0 = this.this$0.mToastQueue;
            monitor-enter(r0);
            long callingId = Binder.clearCallingIdentity();     // Catch: Throwable -> L18
            int index = this.this$0.indexOfToastLocked(pkg, token);     // Catch: Throwable -> L12
            if (index < 0) goto L14;
            this.this$0.cancelToastLocked(index);     // Catch: Throwable -> L12
        L15:
            Binder.restoreCallingIdentity(callingId);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L14:
            Slog.w(NotificationManagerService.TAG, "Toast already cancelled. pkg=" + pkg + " token=" + token);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);     // Catch: Throwable -> L18
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        L24:
            Slog.e(NotificationManagerService.TAG, "Not cancelling notification. pkg=" + pkg + " token=" + token);
        }

        public void setToastRateLimitingEnabled(boolean enable) {
            super.setToastRateLimitingEnabled_enforcePermission();
            ArrayList<ToastRecord> r0 = this.this$0.mToastQueue;
            monitor-enter(r0);
            int uid = Binder.getCallingUid();     // Catch: Throwable -> L12
            int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L12
            if (enable == false) goto L23;
            NotificationManagerService.m6164$$Nest$fgetmToastRateLimitingDisabledUids(this.this$0).remove(Integer.valueOf(uid));     // Catch: Throwable -> L12
            String[] packages = this.this$0.mPackageManager.getPackagesForUid(uid);     // Catch: Throwable -> L12 RemoteException -> L14
            if (packages != null) goto L16;
            Slog.e(NotificationManagerService.TAG, "setToastRateLimitingEnabled method haven't found any packages for the  given uid: " + uid + ", toast rate limiter not reset for that uid.");     // Catch: Throwable -> L12 RemoteException -> L14
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L16:
            int r4 = packages.length;     // Catch: Throwable -> L12 RemoteException -> L14
            int r5 = 0;
        L17:
            if (r5 >= r4) goto L24;
            String pkg = packages[r5];     // Catch: Throwable -> L12 RemoteException -> L14
            NotificationManagerService.m6163$$Nest$fgetmToastRateLimiter(this.this$0).clear(userId, pkg);     // Catch: Throwable -> L12 RemoteException -> L14
            r5 = r5 + 1;
        L24:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            e = move-exception;
            Slog.e(NotificationManagerService.TAG, "Failed to reset toast rate limiter for given uid", e);     // Catch: Throwable -> L12
            goto L24
        L23:
            NotificationManagerService.m6164$$Nest$fgetmToastRateLimitingDisabledUids(this.this$0).add(Integer.valueOf(uid));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public void finishToken(String pkg, IBinder token) {
            ArrayList<ToastRecord> r0 = this.this$0.mToastQueue;
            monitor-enter(r0);
            long callingId = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
            int index = this.this$0.indexOfToastLocked(pkg, token);     // Catch: Throwable -> L8
            if (index < 0) goto L10;
            ToastRecord record = this.this$0.mToastQueue.get(index);     // Catch: Throwable -> L8
            this.this$0.finishWindowTokenLocked(record.windowToken, record.displayId);     // Catch: Throwable -> L8
        L11:
            Binder.restoreCallingIdentity(callingId);     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L10:
            Slog.w(NotificationManagerService.TAG, "Toast already killed. pkg=" + pkg + " token=" + token);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public void enqueueNotificationWithTag(String pkg, String opPkg, String tag, int id, Notification notification, int userId) throws RemoteException {
            this.this$0.enqueueNotificationInternal(pkg, opPkg, Binder.getCallingUid(), Binder.getCallingPid(), tag, id, notification, userId, false, true);
        }

        public void cancelNotificationWithTag(String pkg, String opPkg, String tag, int id, int userId) {
            if (this.this$0.isCallingUidSystem() == false) goto L5;
            int mustNotHaveFlags = 0;
        L6:
            NotificationManagerService r2 = this.this$0;
            int r5 = Binder.getCallingUid();
            int r6 = Binder.getCallingPid();
            r2.cancelNotificationInternal(pkg, opPkg, r5, r6, tag, id, userId, mustNotHaveFlags | 65536);
            return;
        L5:
            mustNotHaveFlags = 33856;
            goto L6
        }

        public void cancelAllNotifications(String pkg, int userId) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, false, "cancelAllNotifications", pkg);
            this.this$0.cancelAllNotificationsInt(Binder.getCallingUid(), Binder.getCallingPid(), pkg, null, 0, 98368, userId2, 9);
            int packageImportance = NotificationManagerService.m6202$$Nest$mgetPackageImportanceWithIdentity(this.this$0, pkg);
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            NotificationManagerService.m6224$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedListLocked(this.this$0, this.this$0.mNotificationList, packageImportance);     // Catch: Throwable -> L7
            NotificationManagerService.m6224$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedListLocked(this.this$0, this.this$0.mEnqueuedNotifications, packageImportance);     // Catch: Throwable -> L7
            monitor-exit(r2);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void silenceNotificationSound() {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mNotificationDelegate.clearEffects();
        }

        public void setNotificationsEnabledForPackage(String r5, int r6, boolean r7) {
            if (NotificationManagerService.m6190$$Nest$mcheckSelfSetSwitch(this.this$0, r5) == true) goto L6;
            enforceSystemOrSystemUI("setNotificationsEnabledForPackage");
        L6:
            if (NotificationManagerService.m6154$$Nest$fgetmPermissionHelper(this.this$0).hasPermission(r6) != r7) goto L8;
            return;
        L8:
            NotificationManagerService.m6154$$Nest$fgetmPermissionHelper(this.this$0).setNotificationPermission(r5, UserHandle.getUserId(r6), r7, true);
            NotificationManagerService.m6235$$Nest$msendAppBlockStateChangedBroadcast(this.this$0, r5, r6, !r7);
            NotificationManagerService.m6147$$Nest$fgetmMetricsLogger(this.this$0).write(new LogMaker(147).setType(4).setPackageName(r5).setSubtype(r7 ? 1 : 0));
            NotificationManagerService.m6148$$Nest$fgetmNotificationChannelLogger(this.this$0).logAppNotificationsAllowed(r6, r5, r7);
        }

        public void setNotificationsEnabledWithImportanceLockForPackage(String pkg, int uid, boolean enabled) {
            setNotificationsEnabledForPackage(pkg, uid, enabled);
        }

        public boolean areNotificationsEnabled(String pkg) {
            return areNotificationsEnabledForPackage(pkg, Binder.getCallingUid());
        }

        public boolean areNotificationsEnabledForPackage(String pkg, int uid) {
            if (Process.isSdkSandboxUid(uid) == false) goto L6;
            return false;
        L6:
            enforceSystemOrSystemUIOrSamePackage(pkg, "Caller not system or systemui or same package");
            if (UserHandle.getCallingUserId() == UserHandle.getUserId(uid)) goto L10;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS", "canNotifyAsPackage for uid " + uid);
        L10:
            return NotificationManagerService.m6178$$Nest$mareNotificationsEnabledForPackageInt(this.this$0, uid);
        }

        public boolean areBubblesAllowed(String pkg) {
            if (getBubblePreferenceForPackage(pkg, Binder.getCallingUid()) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean areBubblesEnabled(UserHandle user) {
            if (UserHandle.getCallingUserId() == user.getIdentifier()) goto L6;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS", "areBubblesEnabled for user " + user.getIdentifier());
        L6:
            return this.this$0.mPreferencesHelper.bubblesEnabled(user);
        }

        public int getBubblePreferenceForPackage(String pkg, int uid) {
            enforceSystemOrSystemUIOrSamePackage(pkg, "Caller not system or systemui or same package");
            if (UserHandle.getCallingUserId() == UserHandle.getUserId(uid)) goto L6;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS", "getBubblePreferenceForPackage for uid " + uid);
        L6:
            return this.this$0.mPreferencesHelper.getBubblePreference(pkg, uid);
        }

        public void setBubblesAllowed(String pkg, int uid, int bubblePreference) {
            NotificationManagerService.m6189$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0, "Caller not system or sysui or shell");
            this.this$0.mPreferencesHelper.setBubblesAllowed(pkg, uid, bubblePreference);
            this.this$0.handleSavePolicyFile();
        }

        public boolean shouldHideSilentStatusIcons(String callingPkg) {
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, callingPkg);
            if (this.this$0.isCallerSystemOrPhone() == true) goto L10;
            if (this.this$0.mListeners.isListenerPackage(callingPkg) == true) goto L10;
            throw new SecurityException("Only available for notification listeners");
        L10:
            return this.this$0.mPreferencesHelper.shouldHideSilentStatusIcons();
        }

        public void setHideSilentStatusIcons(boolean hide) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mPreferencesHelper.setHideSilentStatusIcons(hide);
            this.this$0.handleSavePolicyFile();
            this.this$0.mListeners.onStatusBarIconsBehaviorChanged(hide);
        }

        public void deleteNotificationHistoryItem(String pkg, int uid, long postedTime) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            NotificationManagerService.m6141$$Nest$fgetmHistoryManager(this.this$0).deleteNotificationHistoryItem(pkg, uid, postedTime);
        }

        public NotificationListenerFilter getListenerFilter(ComponentName cn, int userId) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mListeners.getNotificationListenerFilter(Pair.create(cn, Integer.valueOf(userId)));
        }

        public void setListenerFilter(ComponentName cn, int userId, NotificationListenerFilter nlf) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mListeners.setNotificationListenerFilter(Pair.create(cn, Integer.valueOf(userId)), nlf);
            this.this$0.handleSavePolicyFile();
        }

        public int getPackageImportance(String pkg) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            if (NotificationManagerService.m6154$$Nest$fgetmPermissionHelper(this.this$0).hasPermission(Binder.getCallingUid()) == false) goto L6;
            return 3;
        L6:
            return 0;
        }

        public boolean isImportanceLocked(String pkg, int uid) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mPreferencesHelper.isImportanceLocked(pkg, uid);
        }

        public boolean canShowBadge(String pkg, int uid) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mPreferencesHelper.canShowBadge(pkg, uid);
        }

        public void setShowBadge(String pkg, int uid, boolean showBadge) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mPreferencesHelper.setShowBadge(pkg, uid, showBadge);
            this.this$0.handleSavePolicyFile();
        }

        public void allowAssistantAdjustment(String adjustmentType) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            this.this$0.mAssistants.allowAdjustmentType(adjustmentType);
            UserHandle.getUserId(Binder.getCallingUid());
            this.this$0.handleSavePolicyFile();
        }

        public void disallowAssistantAdjustment(String adjustmentType) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            this.this$0.mAssistants.disallowAdjustmentType(adjustmentType);
            UserHandle.getUserId(Binder.getCallingUid());
            this.this$0.handleSavePolicyFile();
        }

        public void setAdjustmentTypeSupportedState(INotificationListener token, String key, boolean supported) {
            long identity = Binder.clearCallingIdentity();
            Object r2 = this.this$0.mNotificationLock;     // Catch: Throwable -> L18
            monitor-enter(r2);     // Catch: Throwable -> L18
            ManagedServices.ManagedServiceInfo info = this.this$0.mAssistants.checkServiceTokenLocked(token);     // Catch: Throwable -> L10
            if (key != null) goto L12;
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            this.this$0.mAssistants.setAdjustmentTypeSupportedState(info.userid, key, supported);     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            this.this$0.handleSavePolicyFile();
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<String> getUnsupportedAdjustmentTypes() {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            ArrayList r1 = new ArrayList(this.this$0.mAssistants.getUnsupportedAdjustments(UserHandle.getUserId(Binder.getCallingUid())));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int[] getAllowedAdjustmentKeyTypes() {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            return this.this$0.mAssistants.getAllowedClassificationTypes();
        }

        public void setAssistantAdjustmentKeyTypeState(int type, boolean enabled) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            this.this$0.mAssistants.setAssistantAdjustmentKeyTypeState(type, enabled);
            this.this$0.handleSavePolicyFile();
        }

        public String[] getAdjustmentDeniedPackages(String key) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            return this.this$0.mAssistants.getAdjustmentDeniedPackages(key);
        }

        public boolean isAdjustmentSupportedForPackage(String key, String pkg) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            return this.this$0.mAssistants.isAdjustmentAllowedForPackage(key, pkg);
        }

        public void setAdjustmentSupportedForPackage(String key, String pkg, boolean enabled) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            this.this$0.mAssistants.setAdjustmentSupportedForPackage(key, pkg, enabled);
            this.this$0.handleSavePolicyFile();
        }

        public boolean appCanBePromoted(String pkg, int uid) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            return this.this$0.mPreferencesHelper.canBePromoted(pkg, uid);
        }

        public boolean canBePromoted(String callingPkg) {
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, callingPkg);
            return this.this$0.mPreferencesHelper.canBePromoted(callingPkg, Binder.getCallingUid());
        }

        public void setCanBePromoted(String pkg, int uid, boolean promote, boolean fromUser) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            boolean changed = this.this$0.mPreferencesHelper.setCanBePromoted(pkg, uid, promote, fromUser);
            if (changed == false) goto L42;
            Object r7 = this.this$0.mNotificationLock;
            monitor-enter(r7);
            List<NotificationRecord> enqueued = NotificationManagerService.m6198$$Nest$mfindAppNotificationByListLocked(this.this$0, this.this$0.mEnqueuedNotifications, pkg, UserHandle.getUserId(uid));     // Catch: Throwable -> L16
            Iterator<NotificationRecord> r8 = enqueued.iterator();     // Catch: Throwable -> L16
        L8:
            if (r8.hasNext() == false) goto L21;
            NotificationRecord r = r8.next();     // Catch: Throwable -> L16
            if (promote == true) goto L12;
        L18:
            if (promote == true) goto L8;
            Notification r11 = r.getNotification();     // Catch: Throwable -> L16
            r11.flags = (-262145) & r11.flags;     // Catch: Throwable -> L16
            goto L8
        L12:
            if (r.getNotification().hasPromotableCharacteristics() == false) goto L18;
            if (r.getImportance() <= 1) goto L18;
            r.getNotification().flags |= 262144;     // Catch: Throwable -> L16
            goto L8
        L21:
            List<NotificationRecord> posted = NotificationManagerService.m6198$$Nest$mfindAppNotificationByListLocked(this.this$0, this.this$0.mNotificationList, pkg, UserHandle.getUserId(uid));     // Catch: Throwable -> L16
            Iterator<NotificationRecord> r9 = posted.iterator();     // Catch: Throwable -> L16
        L23:
            if (r9.hasNext() == false) goto L38;
            NotificationRecord r2 = r9.next();     // Catch: Throwable -> L16
            if (promote == true) goto L27;
        L33:
            if (promote == true) goto L23;
            if (this.this$0.hasFlag(r2.getNotification().flags, 262144) == false) goto L23;
            r2.getNotification().flags &= -262145;     // Catch: Throwable -> L16
            PostNotificationTracker tracker = NotificationManagerService.m6157$$Nest$fgetmPostNotificationTrackerFactory(this.this$0).newTracker(null);     // Catch: Throwable -> L16
            this.this$0.mHandler.post(new EnqueueNotificationRunnable(this.this$0, r2.getUser().getIdentifier(), r2, false, false, tracker));     // Catch: Throwable -> L16
            goto L23
        L27:
            if (this.this$0.hasFlag(r2.getNotification().flags, 262144) == true) goto L33;
            if (r2.getNotification().hasPromotableCharacteristics() == false) goto L33;
            if (r2.getImportance() <= 1) goto L33;
            r2.getNotification().flags |= 262144;     // Catch: Throwable -> L16
            PostNotificationTracker tracker2 = NotificationManagerService.m6157$$Nest$fgetmPostNotificationTrackerFactory(this.this$0).newTracker(null);     // Catch: Throwable -> L16
            this.this$0.mHandler.post(new EnqueueNotificationRunnable(this.this$0, r2.getUser().getIdentifier(), r2, false, false, tracker2));     // Catch: Throwable -> L16
            goto L23
        L38:
            monitor-exit(r7);     // Catch: Throwable -> L16
            this.this$0.handleSavePolicyFile();
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public boolean hasSentValidMsg(String pkg, int uid) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mPreferencesHelper.hasSentValidMsg(pkg, uid);
        }

        public boolean isInInvalidMsgState(String pkg, int uid) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mPreferencesHelper.isInInvalidMsgState(pkg, uid);
        }

        public boolean hasUserDemotedInvalidMsgApp(String pkg, int uid) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mPreferencesHelper.hasUserDemotedInvalidMsgApp(pkg, uid);
        }

        public void setInvalidMsgAppDemoted(String pkg, int uid, boolean isDemoted) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mPreferencesHelper.setInvalidMsgAppDemoted(pkg, uid, isDemoted);
            this.this$0.handleSavePolicyFile();
        }

        public boolean hasSentValidBubble(String pkg, int uid) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mPreferencesHelper.hasSentValidBubble(pkg, uid);
        }

        public void setNotificationDelegate(String callingPkg, String delegate) {
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, callingPkg);
            int callingUid = Binder.getCallingUid();
            UserHandle user = UserHandle.getUserHandleForUid(callingUid);
            if (delegate != null) goto L14;
            this.this$0.mPreferencesHelper.revokeNotificationDelegate(callingPkg, Binder.getCallingUid());
            this.this$0.handleSavePolicyFile();
            return;
        L14:
            ApplicationInfo info = this.this$0.mPackageManager.getApplicationInfo(delegate, 786432, user.getIdentifier());     // Catch: RemoteException -> L9
            if (info == null) goto L17;
            this.this$0.mPreferencesHelper.setNotificationDelegate(callingPkg, callingUid, delegate, info.uid);     // Catch: RemoteException -> L9
            this.this$0.handleSavePolicyFile();     // Catch: RemoteException -> L9
            return;
        L17:
            return;
        L9:
            e = move-exception;
            e.rethrowFromSystemServer();
        }

        public String getNotificationDelegate(String callingPkg) {
            this.this$0.checkCallerIsSystemOrSameApp(callingPkg);
            return this.this$0.mPreferencesHelper.getNotificationDelegate(callingPkg, Binder.getCallingUid());
        }

        public boolean canNotifyAsPackage(String callingPkg, String targetPkg, int userId) {
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, callingPkg);
            int callingUid = Binder.getCallingUid();
            UserHandle user = UserHandle.getUserHandleForUid(callingUid);
            if (user.getIdentifier() == userId) goto L6;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS", "canNotifyAsPackage for user " + userId);
        L6:
            if (callingPkg.equals(targetPkg) == false) goto L18;
            return true;
        L18:
            ApplicationInfo info = this.this$0.mPackageManager.getApplicationInfo(targetPkg, 786432, userId);     // Catch: RemoteException -> L13
            if (info == null) goto L20;
            return this.this$0.mPreferencesHelper.isDelegateAllowed(targetPkg, info.uid, callingPkg, callingUid);
        L20:
            return false;
        L16:
            return false;
        }

        public boolean canUseFullScreenIntent(AttributionSource attributionSource) {
            String packageName = attributionSource.getPackageName();
            int uid = attributionSource.getUid();
            int userId = UserHandle.getUserId(uid);
            NotificationManagerService.m6185$$Nest$mcheckCallerIsSameApp(this.this$0, packageName, uid, userId);
            ApplicationInfo applicationInfo = NotificationManagerService.m6153$$Nest$fgetmPackageManagerClient(this.this$0).getApplicationInfoAsUser(packageName, 268435456, userId);     // Catch: PackageManager.NameNotFoundException -> L6
            return NotificationManagerService.m6191$$Nest$mcheckUseFullScreenIntentPermission(this.this$0, attributionSource, applicationInfo, false);
        L6:
            e = move-exception;
            Slog.e(NotificationManagerService.TAG, "Failed to getApplicationInfo() in canUseFullScreenIntent()", e);
            return false;
        }

        public void updateNotificationChannelGroupForPackage(String pkg, int uid, NotificationChannelGroup group) throws RemoteException {
            enforceSystemOrSystemUI("Caller not system or systemui");
            this.this$0.createNotificationChannelGroup(pkg, uid, group, false, false);
            this.this$0.handleSavePolicyFile();
        }

        public void createNotificationChannelGroups(String pkg, ParceledListSlice channelGroupList) throws RemoteException {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            ParceledListSlice<NotificationChannelGroup> oldGroups = getNotificationChannelGroups(pkg);
            if (oldGroups != null) goto L5;
        L9:
            List<NotificationChannelGroup> groups = channelGroupList.getList();
            int groupSize = groups.size();
            int i = 0;
        L10:
            if (i >= groupSize) goto L12;
            NotificationChannelGroup group = groups.get(i);
            this.this$0.createNotificationChannelGroup(pkg, Binder.getCallingUid(), group, true, false);
            i = i + 1;
            goto L10
        L12:
            this.this$0.handleSavePolicyFile();
            return;
        L5:
            if (oldGroups.getList().size() <= 1000) goto L9;
            Slog.w(NotificationManagerService.TAG, "too many NotificationChannelGroups");
            throw new IllegalStateException("too many NotificationChannelGroups : " + oldGroups.getList().size());
        }

        private void createNotificationChannelsImpl(String pkg, int uid, ParceledListSlice channelsList) {
            createNotificationChannelsImpl(pkg, uid, channelsList, -1);
        }

        private void createNotificationChannelsImpl(String pkg, int uid, ParceledListSlice channelsList, int startingTaskId) {
            boolean r10 = false;
            ParceledListSlice<NotificationChannel> allOldChannels = this.this$0.mPreferencesHelper.getNotificationChannels(pkg, uid, false, false);
            if (allOldChannels != null) goto L5;
        L9:
            List<NotificationChannel> channels = channelsList.getList();
            int channelsSize = channels.size();
            ParceledListSlice<NotificationChannel> oldChannels = this.this$0.mPreferencesHelper.getNotificationChannels(pkg, uid, true, false);
            if (oldChannels != null) goto L12;
        L14:
            boolean r1 = false;
        L15:
            boolean hadNonBundleChannel = r1;
            boolean needsPolicyFileChange = false;
            boolean hasRequestedNotificationPermission = false;
            int i = 0;
        L16:
            if (i >= channelsSize) goto L44;
            NotificationChannel channel = channels.get(i);
            channel.getClass();
            int i2 = i;
            needsPolicyFileChange = this.this$0.mPreferencesHelper.createNotificationChannel(pkg, uid, channel, true, NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).isPackageOrComponentAllowed(pkg, UserHandle.getUserId(uid)), Binder.getCallingUid(), this.this$0.isCallerSystemOrSystemUi());
            if (needsPolicyFileChange == false) goto L42;
            this.this$0.mListeners.notifyNotificationChannelChanged(pkg, UserHandle.getUserHandleForUid(uid), this.this$0.mPreferencesHelper.getNotificationChannel(pkg, uid, channel.getId(), r10), 1);
            if (hadNonBundleChannel == true) goto L24;
            if (hasRequestedNotificationPermission == true) goto L24;
            boolean hasNonBundleChannel = r10;
        L25:
            if (hasNonBundleChannel == true) goto L33;
            ParceledListSlice<NotificationChannel> currChannels = this.this$0.mPreferencesHelper.getNotificationChannels(pkg, uid, true, r10);
            if (currChannels != null) goto L29;
        L31:
            boolean r6 = r10;
        L32:
            hasNonBundleChannel = r6;
            goto L33
        L29:
            if (currChannels.getList().isEmpty() == true) goto L31;
            r6 = true;
        L33:
            if (hadNonBundleChannel == true) goto L42;
            if (hasNonBundleChannel == false) goto L42;
            if (hasRequestedNotificationPermission == true) goto L42;
            if (startingTaskId == (-1)) goto L42;
            if (NotificationManagerService.m6155$$Nest$fgetmPermissionPolicyInternal(this.this$0) != null) goto L41;
            NotificationManagerService.m6174$$Nest$fputmPermissionPolicyInternal(this.this$0, (PermissionPolicyInternal) LocalServices.getService(PermissionPolicyInternal.class));
        L41:
            this.this$0.mHandler.post(new ShowNotificationPermissionPromptRunnable(pkg, UserHandle.getUserId(uid), startingTaskId, NotificationManagerService.m6155$$Nest$fgetmPermissionPolicyInternal(this.this$0)));
            hasRequestedNotificationPermission = true;
        L24:
            hasNonBundleChannel = true;
        L42:
            i = i2 + 1;
            r10 = false;
            goto L16
        L44:
            if (needsPolicyFileChange == false) goto L54;
            this.this$0.handleSavePolicyFile();
            return;
        L54:
            return;
        L12:
            if (oldChannels.getList().isEmpty() == true) goto L14;
            r1 = true;
            goto L15
        L5:
            if (allOldChannels.getList().size() <= 1000) goto L9;
            Slog.w(NotificationManagerService.TAG, "too many NotificationChannel");
            throw new IllegalStateException("too many NotificationChannel : " + allOldChannels.getList().size());
        }

        public void createNotificationChannels(String pkg, ParceledListSlice channelsList) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            int taskId = -1;
            int uid = this.this$0.mPackageManager.getPackageUid(pkg, 0, UserHandle.getUserId(Binder.getCallingUid()));     // Catch: RemoteException -> L5
            taskId = NotificationManagerService.m6135$$Nest$fgetmAtm(this.this$0).getTaskToShowPermissionDialogOn(pkg, uid);     // Catch: RemoteException -> L5
        L6:
            createNotificationChannelsImpl(pkg, Binder.getCallingUid(), channelsList, taskId);
        }

        public void createNotificationChannelsForPackage(String pkg, int uid, ParceledListSlice channelsList) {
            enforceSystemOrSystemUI("only system can call this");
            createNotificationChannelsImpl(pkg, uid, channelsList);
        }

        public void createConversationNotificationChannelForPackage(String pkg, int uid, NotificationChannel parentChannel, String conversationId) {
            enforceSystemOrSystemUI("only system can call this");
            Preconditions.checkNotNull(parentChannel);
            Preconditions.checkNotNull(conversationId);
            String parentId = parentChannel.getId();
            parentChannel.setId(String.format("%1$s : %2$s", new Object[]{parentId, conversationId}));
            parentChannel.setConversationId(parentId, conversationId);
            createNotificationChannelsImpl(pkg, uid, new ParceledListSlice(Arrays.asList(new NotificationChannel[]{parentChannel})));
            this.this$0.mRankingHandler.requestSort();
            this.this$0.handleSavePolicyFile();
        }

        public NotificationChannel getNotificationChannel(String callingPkg, int userId, String targetPkg, String channelId) {
            return getConversationNotificationChannel(callingPkg, userId, targetPkg, channelId, true, null);
        }

        public NotificationChannel getConversationNotificationChannel(String callingPkg, int userId, String targetPkg, String channelId, boolean returnParentIfNoConversationChannel, String conversationId) {
            if (NotificationManagerService.m6218$$Nest$misCallerSystemOrSystemUiOrShell(this.this$0) == true) goto L16;
            if (canNotifyAsPackage(callingPkg, targetPkg, userId) == true) goto L16;
            throw new SecurityException("Pkg " + callingPkg + " cannot read channels for " + targetPkg + " in " + userId);
        L16:
            int targetUid = NotificationManagerService.m6153$$Nest$fgetmPackageManagerClient(this.this$0).getPackageUidAsUser(targetPkg, userId);     // Catch: PackageManager.NameNotFoundException -> L12
            int targetUid2 = targetUid;
        L15:
            return this.this$0.mPreferencesHelper.getConversationNotificationChannel(targetPkg, targetUid2, channelId, conversationId, returnParentIfNoConversationChannel, false);
        L13:
            targetUid2 = -1;
            goto L15
        }

        public NotificationChannel getNotificationChannelForPackage(String pkg, int uid, String channelId, String conversationId, boolean includeDeleted) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mPreferencesHelper.getConversationNotificationChannel(pkg, uid, channelId, conversationId, true, includeDeleted);
        }

        private void enforceDeletingChannelHasNoFgService(String pkg, int userId, String channelId) {
            if (NotificationManagerService.m6132$$Nest$fgetmAmi(this.this$0).hasForegroundServiceNotification(pkg, userId, channelId) == true) goto L5;
            return;
        L5:
            Slog.w(NotificationManagerService.TAG, "Package u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + pkg + " may not delete notification channel '" + channelId + "' with fg service");
            throw new SecurityException("Not allowed to delete channel " + channelId + " with a foreground service");
        }

        private void enforceDeletingChannelHasNoUserInitiatedJob(String pkg, int userId, String channelId) {
            JobSchedulerInternal js = (JobSchedulerInternal) LocalServices.getService(JobSchedulerInternal.class);
            if (js != null) goto L5;
            return;
        L5:
            if (js.isNotificationChannelAssociatedWithAnyUserInitiatedJobs(channelId, userId, pkg) == false) goto L10;
            Slog.w(NotificationManagerService.TAG, "Package u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + pkg + " may not delete notification channel '" + channelId + "' with user-initiated job");
            throw new SecurityException("Not allowed to delete channel " + channelId + " with a user-initiated job");
        }

        public void deleteNotificationChannel(String pkg, String channelId) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            int callingUid = Binder.getCallingUid();
            boolean isSystemOrSystemUi = this.this$0.isCallerSystemOrSystemUi();
            int callingUser = UserHandle.getUserId(callingUid);
            if ("miscellaneous".equals(channelId) == true) goto L13;
            if (NotificationChannel.SYSTEM_RESERVED_IDS.contains(channelId) == false) goto L8;
            Log.v(NotificationManagerService.TAG, "Package " + pkg + " cannot delete a reserved channel");
            return;
        L8:
            enforceDeletingChannelHasNoFgService(pkg, callingUser, channelId);
            enforceDeletingChannelHasNoUserInitiatedJob(pkg, callingUser, channelId);
            this.this$0.cancelAllNotificationsInt(NotificationManagerService.m6246$$Nest$sfgetMY_UID(), NotificationManagerService.m6245$$Nest$sfgetMY_PID(), pkg, channelId, 0, 0, callingUser, 20);
            boolean previouslyExisted = this.this$0.mPreferencesHelper.deleteNotificationChannel(pkg, callingUid, channelId, callingUid, isSystemOrSystemUi);
            if (previouslyExisted == false) goto L14;
            NotificationManagerService.m6134$$Nest$fgetmArchive(this.this$0).removeChannelNotifications(pkg, callingUser, channelId);
            NotificationManagerService.m6141$$Nest$fgetmHistoryManager(this.this$0).deleteNotificationChannel(pkg, callingUid, channelId);
            this.this$0.mListeners.notifyNotificationChannelChanged(pkg, UserHandle.getUserHandleForUid(callingUid), this.this$0.mPreferencesHelper.getNotificationChannel(pkg, callingUid, channelId, true), 3);
            this.this$0.handleSavePolicyFile();
            return;
        L14:
            return;
        L13:
            throw new IllegalArgumentException("Cannot delete default channel");
        }

        public NotificationChannelGroup getNotificationChannelGroup(String pkg, String groupId) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            return this.this$0.mPreferencesHelper.getNotificationChannelGroupWithChannels(pkg, Binder.getCallingUid(), groupId, false);
        }

        public ParceledListSlice<NotificationChannelGroup> getNotificationChannelGroups(String pkg) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            return this.this$0.mPreferencesHelper.getNotificationChannelGroups(pkg, Binder.getCallingUid(), NotificationChannelGroupsHelper.Params.forAllGroups());
        }

        public ParceledListSlice<NotificationChannelGroup> getNotificationChannelGroupsWithoutChannels(String pkg) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            List<NotificationChannelGroup> groups = new ArrayList();
            groups.addAll(this.this$0.mPreferencesHelper.getNotificationChannelGroupsWithoutChannels(pkg, Binder.getCallingUid()));
            return new ParceledListSlice(groups);
        }

        public void deleteNotificationChannelGroup(String pkg, String groupId) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            int callingUid = Binder.getCallingUid();
            boolean isSystemOrSystemUi = this.this$0.isCallerSystemOrSystemUi();
            NotificationChannelGroup groupToDelete = this.this$0.mPreferencesHelper.getNotificationChannelGroupWithChannels(pkg, callingUid, groupId, false);
            if (groupToDelete == null) goto L14;
            int userId = UserHandle.getUserId(callingUid);
            List<NotificationChannel> groupChannels = groupToDelete.getChannels();
            int i = 0;
        L6:
            if (i >= groupChannels.size()) goto L8;
            String channelId = groupChannels.get(i).getId();
            enforceDeletingChannelHasNoFgService(pkg, userId, channelId);
            enforceDeletingChannelHasNoUserInitiatedJob(pkg, userId, channelId);
            i = i + 1;
            goto L6
        L8:
            List<NotificationChannel> deletedChannels = this.this$0.mPreferencesHelper.deleteNotificationChannelGroup(pkg, callingUid, groupId, callingUid, isSystemOrSystemUi);
            int i2 = 0;
        L10:
            if (i2 >= deletedChannels.size()) goto L12;
            NotificationChannel deletedChannel = deletedChannels.get(i2);
            this.this$0.cancelAllNotificationsInt(NotificationManagerService.m6246$$Nest$sfgetMY_UID(), NotificationManagerService.m6245$$Nest$sfgetMY_PID(), pkg, deletedChannel.getId(), 0, 0, userId, 20);
            this.this$0.mListeners.notifyNotificationChannelChanged(pkg, UserHandle.getUserHandleForUid(callingUid), deletedChannel, 3);
            i2 = i2 + 1;
            deletedChannels = deletedChannels;
            groupChannels = groupChannels;
            goto L10
        L12:
            this.this$0.mListeners.notifyNotificationChannelGroupChanged(pkg, UserHandle.getUserHandleForUid(callingUid), groupToDelete, 3);
            this.this$0.handleSavePolicyFile();
            return;
        }

        public void updateNotificationChannelForPackage(String pkg, int uid, NotificationChannel channel) {
            NotificationManagerService.m6189$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0, "Caller not system or sysui or shell");
            channel.getClass();
            this.this$0.updateNotificationChannelInt(pkg, uid, channel, false);
        }

        public void unlockNotificationChannel(String pkg, int uid, String channelId) {
            NotificationManagerService.m6189$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0, "Caller not system or sysui or shell");
            this.this$0.mPreferencesHelper.unlockNotificationChannelImportance(pkg, uid, channelId);
            this.this$0.handleSavePolicyFile();
        }

        public void unlockAllNotificationChannels() {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mPreferencesHelper.unlockAllNotificationChannels();
            this.this$0.handleSavePolicyFile();
        }

        public ParceledListSlice<NotificationChannel> getNotificationChannelsForPackage(String pkg, int uid, boolean includeDeleted) {
            enforceSystemOrSystemUI("getNotificationChannelsForPackage");
            return this.this$0.mPreferencesHelper.getNotificationChannels(pkg, uid, includeDeleted, true);
        }

        public int getNumNotificationChannelsForPackage(String pkg, int uid, boolean includeDeleted) {
            enforceSystemOrSystemUI("getNumNotificationChannelsForPackage");
            return this.this$0.getNumNotificationChannelsForPackage(pkg, uid, includeDeleted);
        }

        public boolean onlyHasDefaultChannel(String pkg, int uid) {
            enforceSystemOrSystemUI("onlyHasDefaultChannel");
            return this.this$0.mPreferencesHelper.onlyHasDefaultChannel(pkg, uid);
        }

        public int getDeletedChannelCount(String pkg, int uid) {
            enforceSystemOrSystemUI("getDeletedChannelCount");
            return this.this$0.mPreferencesHelper.getDeletedChannelCount(pkg, uid);
        }

        public int getBlockedChannelCount(String pkg, int uid) {
            enforceSystemOrSystemUI("getBlockedChannelCount");
            return this.this$0.mPreferencesHelper.getBlockedChannelCount(pkg, uid);
        }

        public ParceledListSlice<ConversationChannelWrapper> getConversations(boolean onlyImportant) {
            enforceSystemOrSystemUI("getConversations");
            IntArray userIds = NotificationManagerService.m6170$$Nest$fgetmUserProfiles(this.this$0).getCurrentProfileIds();
            ArrayList<ConversationChannelWrapper> conversations = this.this$0.mPreferencesHelper.getConversations(userIds, onlyImportant);
            Iterator<ConversationChannelWrapper> r2 = conversations.iterator();
        L4:
            if (r2.hasNext() == false) goto L11;
            ConversationChannelWrapper conversation = r2.next();
            if (NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0) == null) goto L7;
            conversation.setShortcutInfo(NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0).getValidShortcutInfo(conversation.getNotificationChannel().getConversationId(), conversation.getPkg(), UserHandle.of(UserHandle.getUserId(conversation.getUid()))));
            goto L4
        L7:
            conversation.setShortcutInfo(null);
            goto L4
        L11:
            return new ParceledListSlice(conversations);
        }

        public ParceledListSlice<NotificationChannelGroup> getNotificationChannelGroupsForPackage(String pkg, int uid, boolean includeDeleted) {
            enforceSystemOrSystemUI("getNotificationChannelGroupsForPackage");
            return this.this$0.mPreferencesHelper.getNotificationChannelGroups(pkg, uid, new NotificationChannelGroupsHelper.Params(includeDeleted, true, false, true, null));
        }

        public ParceledListSlice<NotificationChannelGroup> getRecentBlockedNotificationChannelGroupsForPackage(String pkg, int uid) {
            enforceSystemOrSystemUI("getRecentBlockedNotificationChannelGroupsForPackage");
            Set<String> recentlySentChannels = new HashSet();
            long now = System.currentTimeMillis();
            long startTime = now - 1209600000;
            UsageEvents events = NotificationManagerService.m6169$$Nest$fgetmUsageStatsManagerInternal(this.this$0).queryEventsForUser(UserHandle.getUserId(uid), startTime, now, 0);
            if (events == null) goto L16;
            UsageEvents.Event event = new UsageEvents.Event();
        L6:
            if (events.hasNextEvent() == false) goto L16;
            events.getNextEvent(event);
            if (event.getEventType() != 12) goto L6;
            if (pkg.equals(event.mPackage) == false) goto L6;
            String channelId = event.mNotificationChannelId;
            if (channelId == null) goto L6;
            recentlySentChannels.add(channelId);
        L16:
            return this.this$0.mPreferencesHelper.getNotificationChannelGroups(pkg, uid, NotificationChannelGroupsHelper.Params.onlySpecifiedOrBlockedChannels(recentlySentChannels));
        }

        public ParceledListSlice<ConversationChannelWrapper> getConversationsForPackage(String pkg, int uid) {
            enforceSystemOrSystemUI("getConversationsForPackage");
            ArrayList<ConversationChannelWrapper> conversations = this.this$0.mPreferencesHelper.getConversations(pkg, uid);
            Iterator<ConversationChannelWrapper> r1 = conversations.iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            ConversationChannelWrapper conversation = r1.next();
            if (NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0) == null) goto L7;
            conversation.setShortcutInfo(NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0).getValidShortcutInfo(conversation.getNotificationChannel().getConversationId(), pkg, UserHandle.of(UserHandle.getUserId(uid))));
            goto L4
        L7:
            conversation.setShortcutInfo(null);
            goto L4
        L11:
            return new ParceledListSlice(conversations);
        }

        public NotificationChannelGroup getPopulatedNotificationChannelGroupForPackage(String pkg, int uid, String groupId, boolean includeDeleted) {
            enforceSystemOrSystemUI("getPopulatedNotificationChannelGroupForPackage");
            return this.this$0.mPreferencesHelper.getNotificationChannelGroupWithChannels(pkg, uid, groupId, includeDeleted);
        }

        public NotificationChannelGroup getNotificationChannelGroupForPackage(String groupId, String pkg, int uid) {
            enforceSystemOrSystemUI("getNotificationChannelGroupForPackage");
            return this.this$0.mPreferencesHelper.getNotificationChannelGroup(groupId, pkg, uid);
        }

        public ParceledListSlice<NotificationChannel> getNotificationChannels(String callingPkg, String targetPkg, int userId) {
            if (canNotifyAsPackage(callingPkg, targetPkg, userId) == false) goto L5;
        L9:
            int targetUid = -1;
            targetUid = NotificationManagerService.m6153$$Nest$fgetmPackageManagerClient(this.this$0).getPackageUidAsUser(targetPkg, userId);     // Catch: PackageManager.NameNotFoundException -> L12
        L14:
            return this.this$0.mPreferencesHelper.getNotificationChannels(targetPkg, targetUid, false, true);
        L5:
            if (this.this$0.isCallingUidSystem() == true) goto L9;
            throw new SecurityException("Pkg " + callingPkg + " cannot read channels for " + targetPkg + " in " + userId);
        }

        public ParceledListSlice<NotificationChannel> getNotificationChannelsBypassingDnd(String pkg, int uid) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            if (areNotificationsEnabledForPackage(pkg, uid) == true) goto L7;
            return ParceledListSlice.emptyList();
        L7:
            return this.this$0.mPreferencesHelper.getNotificationChannelsBypassingDnd(pkg, uid);
        }

        public ParceledListSlice<ZenBypassingApp> getPackagesBypassingDnd(int userId) throws RemoteException {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            UserHandle user = UserHandle.of(userId);
            ArrayList<ZenBypassingApp> bypassing = this.this$0.mPreferencesHelper.getPackagesBypassingDnd(userId);
            int i = bypassing.size() - 1;
        L3:
            if (i < 0) goto L9;
            String pkg = bypassing.get(i).getPkg();
            if (areNotificationsEnabledForPackage(pkg, getUidForPackageAndUser(pkg, user)) == true) goto L7;
            bypassing.remove(i);
        L7:
            i = i - 1;
            goto L3
        L9:
            return new ParceledListSlice(bypassing);
        }

        public boolean areChannelsBypassingDnd() {
            if (this.this$0.mZenModeHelper.getConsolidatedNotificationPolicy().allowPriorityChannels() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.mPreferencesHelper.hasPriorityChannels() == false) goto L7;
            return true;
        }

        public List<String> getPackagesWithAnyChannels(int userId) throws RemoteException {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            UserHandle user = UserHandle.of(userId);
            List<String> packages = this.this$0.mPreferencesHelper.getPackagesWithAnyChannels(userId);
            int i = packages.size() - 1;
        L3:
            if (i < 0) goto L9;
            String pkg = packages.get(i);
            if (areNotificationsEnabledForPackage(pkg, getUidForPackageAndUser(pkg, user)) == true) goto L7;
            packages.remove(i);
        L7:
            i = i - 1;
            goto L3
        L9:
            return packages;
        }

        public void clearData(String packageName, int uid, boolean fromApp) throws RemoteException {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            int userId = UserHandle.getUserId(uid);
            this.this$0.cancelAllNotificationsInt(NotificationManagerService.m6246$$Nest$sfgetMY_UID(), NotificationManagerService.m6245$$Nest$sfgetMY_PID(), packageName, null, 0, 0, UserHandle.getUserId(Binder.getCallingUid()), 21);
            boolean packagesChanged = NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).resetPackage(packageName, userId) | false;
            ArrayMap<Boolean, ArrayList<ComponentName>> changedListeners = this.this$0.mListeners.resetComponents(packageName, userId);
            if (changedListeners.get(true).size() <= 0) goto L5;
        L8:
            boolean r4 = true;
        L9:
            boolean packagesChanged2 = packagesChanged | r4;
            int i = 0;
        L11:
            if (i >= changedListeners.get(true).size()) goto L13;
            NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).setPackageOrComponentEnabled(changedListeners.get(true).get(i).getPackageName(), userId, false, true);
            i = i + 1;
            goto L11
        L13:
            ArrayMap<Boolean, ArrayList<ComponentName>> changedAssistants = this.this$0.mAssistants.resetComponents(packageName, userId);
            if (changedAssistants.get(true).size() <= 0) goto L16;
        L19:
            boolean r7 = true;
        L20:
            boolean packagesChanged3 = packagesChanged2 | r7;
            int i2 = 1;
        L22:
            if (i2 >= changedAssistants.get(true).size()) goto L25;
            this.this$0.mAssistants.setPackageOrComponentEnabled(changedAssistants.get(true).get(i2).flattenToString(), userId, true, false);
            i2 = i2 + 1;
            goto L22
        L25:
            if (changedAssistants.get(true).size() <= 0) goto L27;
            NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).setPackageOrComponentEnabled(changedAssistants.get(true).get(0).getPackageName(), userId, false, true);
        L27:
            this.this$0.mSnoozeHelper.clearData(UserHandle.getUserId(uid), packageName);
            if (fromApp == true) goto L30;
            this.this$0.mPreferencesHelper.clearData(packageName, uid);
        L30:
            if (packagesChanged3 == false) goto L32;
            this.this$0.getContext().sendBroadcastAsUser(new Intent("android.app.action.NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED").setPackage(packageName).addFlags(67108864), UserHandle.of(userId), null);
        L32:
            this.this$0.handleSavePolicyFile();
            return;
        L16:
            if (changedAssistants.get(false).size() > 0) goto L19;
            r7 = false;
            goto L20
        L5:
            if (changedListeners.get(false).size() > 0) goto L8;
            r4 = false;
            goto L9
        }

        public List<String> getAllowedAssistantAdjustments(String pkg) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            if (this.this$0.isCallerSystemOrPhone() == true) goto L10;
            if (this.this$0.mAssistants.isPackageAllowed(pkg, UserHandle.getCallingUserId()) == true) goto L10;
            throw new SecurityException("Not currently an assistant");
        L10:
            return new ArrayList(this.this$0.mAssistants.getAllowedAssistantAdjustments());
        }

        @Deprecated
        public StatusBarNotification[] getActiveNotifications(String callingPkg) {
            return getActiveNotificationsWithAttribution(callingPkg, null);
        }

        public StatusBarNotification[] getActiveNotificationsWithAttribution(String callingPkg, String callingAttributionTag) {
            getActiveNotificationsWithAttribution_enforcePermission();
            ArrayList<StatusBarNotification> tmp = new ArrayList();
            int uid = Binder.getCallingUid();
            final ArrayList<Integer> currentUsers = new ArrayList();
            currentUsers.add(-1);
            Binder.withCleanCallingIdentity(new NotificationManagerService$12$$ExternalSyntheticLambda2(this, currentUsers));
            int mode = NotificationManagerService.m6133$$Nest$fgetmAppOps(this.this$0).noteOpNoThrow(25, uid, callingPkg, callingAttributionTag, null);
            if (mode != 0) goto L5;
        L6:
            Object r11 = this.this$0.mNotificationLock;
            monitor-enter(r11);
            int N = this.this$0.mNotificationList.size();     // Catch: Throwable -> L13
            int i = 0;
        L9:
            if (i >= N) goto L17;
            StatusBarNotification sbn = this.this$0.mNotificationList.get(i).getSbn();     // Catch: Throwable -> L13
            if (currentUsers.contains(Integer.valueOf(sbn.getUserId())) == false) goto L15;
            tmp.add(sbn);     // Catch: Throwable -> L13
        L15:
            i = i + 1;     // Catch: Throwable -> L13
            goto L9
        L17:
            monitor-exit(r11);     // Catch: Throwable -> L13
        L19:
            return (StatusBarNotification[]) tmp.toArray(new StatusBarNotification[tmp.size()]);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (mode != 3) goto L19;
            goto L6
        }

        private /* synthetic */ void lambda$getActiveNotificationsWithAttribution$0(ArrayList currentUsers) throws Exception {
            int r2 = 0;
            int[] r0 = NotificationManagerService.m6167$$Nest$fgetmUm(this.this$0).getProfileIds(ActivityManager.getCurrentUser(), false);
            int r1 = r0.length;
        L3:
            if (r2 >= r1) goto L5;
            int user = r0[r2];
            currentUsers.add(Integer.valueOf(user));
            r2 = r2 + 1;
            goto L3
        }

        public ParceledListSlice<StatusBarNotification> getAppActiveNotifications(String pkg, int incomingUserId) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            int userId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), incomingUserId, true, false, "getAppActiveNotifications", pkg);
            Object r10 = this.this$0.mNotificationLock;
            monitor-enter(r10);
            ArrayMap<String, StatusBarNotification> map = new ArrayMap(this.this$0.mNotificationList.size() + this.this$0.mEnqueuedNotifications.size());     // Catch: Throwable -> L9
            int N = this.this$0.mNotificationList.size();     // Catch: Throwable -> L9
            int i = 0;
        L5:
            if (i >= N) goto L12;
            StatusBarNotification sbn = sanitizeSbn(pkg, userId, this.this$0.mNotificationList.get(i).getSbn());     // Catch: Throwable -> L9
            if (sbn == null) goto L11;
            map.put(sbn.getKey(), sbn);     // Catch: Throwable -> L9
        L11:
            i = i + 1;     // Catch: Throwable -> L9
            goto L5
        L12:
            Iterator<NotificationRecord> r2 = this.this$0.mSnoozeHelper.getSnoozed(userId, pkg).iterator();     // Catch: Throwable -> L9
        L14:
            if (r2.hasNext() == false) goto L19;
            NotificationRecord snoozed = r2.next();     // Catch: Throwable -> L9
            StatusBarNotification sbn2 = sanitizeSbn(pkg, userId, snoozed.getSbn());     // Catch: Throwable -> L9
            if (sbn2 == null) goto L14;
            map.put(sbn2.getKey(), sbn2);     // Catch: Throwable -> L9
            goto L14
        L19:
            int M = this.this$0.mEnqueuedNotifications.size();     // Catch: Throwable -> L9
            int i2 = 0;
        L20:
            if (i2 >= M) goto L25;
            StatusBarNotification sbn3 = sanitizeSbn(pkg, userId, this.this$0.mEnqueuedNotifications.get(i2).getSbn());     // Catch: Throwable -> L9
            if (sbn3 == null) goto L24;
            map.put(sbn3.getKey(), sbn3);     // Catch: Throwable -> L9
        L24:
            i2 = i2 + 1;     // Catch: Throwable -> L9
            goto L20
        L25:
            ArrayList<StatusBarNotification> list = new ArrayList(map.size());     // Catch: Throwable -> L9
            list.addAll(map.values());     // Catch: Throwable -> L9
            ParceledListSlice<StatusBarNotification> r5 = new ParceledListSlice(list);     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return r5;
        L9:
            th = move-exception;
            throw th;
        }

        private StatusBarNotification sanitizeSbn(String pkg, int userId, StatusBarNotification sbn) {
            if (sbn.getUserId() == userId) goto L5;
        L10:
            return null;
        L5:
            if (sbn.getPackageName().equals(pkg) == false) goto L7;
        L8:
            Notification notification = sbn.getNotification().clone();
            notification.overrideAllowlistToken(null);
            return new StatusBarNotification(sbn.getPackageName(), sbn.getOpPkg(), sbn.getId(), sbn.getTag(), sbn.getUid(), sbn.getInitialPid(), notification, sbn.getUser(), sbn.getOverrideGroupKey(), sbn.getPostTime());
        L7:
            if (sbn.getOpPkg().equals(pkg) == false) goto L10;
            goto L8
        }

        @Deprecated
        public StatusBarNotification[] getHistoricalNotifications(String callingPkg, int count, boolean includeSnoozed) {
            return getHistoricalNotificationsWithAttribution(callingPkg, null, count, includeSnoozed);
        }

        public StatusBarNotification[] getHistoricalNotificationsWithAttribution(String callingPkg, String callingAttributionTag, int count, boolean includeSnoozed) {
            getHistoricalNotificationsWithAttribution_enforcePermission();
            StatusBarNotification[] tmp = null;
            int uid = Binder.getCallingUid();
            int mode = NotificationManagerService.m6133$$Nest$fgetmAppOps(this.this$0).noteOpNoThrow(25, uid, callingPkg, callingAttributionTag, null);
            if (mode != 0) goto L5;
        L6:
            Archive r10 = NotificationManagerService.m6134$$Nest$fgetmArchive(this.this$0);
            monitor-enter(r10);
            tmp = NotificationManagerService.m6134$$Nest$fgetmArchive(this.this$0).getArray(NotificationManagerService.m6167$$Nest$fgetmUm(this.this$0), count, includeSnoozed);     // Catch: Throwable -> L11
            monitor-exit(r10);     // Catch: Throwable -> L11
        L10:
            return tmp;
        L11:
            th = move-exception;
            throw th;
        L5:
            if (mode != 3) goto L10;
            goto L6
        }

        public NotificationHistory getNotificationHistory(String callingPkg, String callingAttributionTag) {
            getNotificationHistory_enforcePermission();
            int uid = Binder.getCallingUid();
            int mode = NotificationManagerService.m6133$$Nest$fgetmAppOps(this.this$0).noteOpNoThrow(25, uid, callingPkg, callingAttributionTag, null);
            if (mode != 0) goto L5;
        L9:
            IntArray currentUserIds = NotificationManagerService.m6170$$Nest$fgetmUserProfiles(this.this$0).getCurrentProfileIds();
            Trace.traceBegin(524288, "notifHistoryReadHistory");
            NotificationHistory r0 = NotificationManagerService.m6141$$Nest$fgetmHistoryManager(this.this$0).readNotificationHistory(currentUserIds.toArray());     // Catch: Throwable -> L13
            Trace.traceEnd(524288);
            return r0;
        L13:
            th = move-exception;
            Trace.traceEnd(524288);
            throw th;
        L5:
            if (mode == 3) goto L9;
            return new NotificationHistory();
        }

        public void registerCallNotificationEventListener(String packageName, UserHandle userHandle, ICallNotificationEventCallback listener) {
            registerCallNotificationEventListener_enforcePermission();
            if (userHandle.getIdentifier() == (-2)) goto L5;
            int userId = userHandle.getIdentifier();
        L6:
            ArrayMap<String, ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>>> r1 = this.this$0.mCallNotificationEventCallbacks;
            monitor-enter(r1);
            ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>> callbacksForPackage = this.this$0.mCallNotificationEventCallbacks.getOrDefault(packageName, new ArrayMap());     // Catch: Throwable -> L35
            RemoteCallbackList<ICallNotificationEventCallback> callbackList = callbacksForPackage.getOrDefault(Integer.valueOf(userId), new RemoteCallbackList());     // Catch: Throwable -> L35
            if (callbackList.register(listener) == false) goto L37;
            callbacksForPackage.put(Integer.valueOf(userId), callbackList);     // Catch: Throwable -> L35
            this.this$0.mCallNotificationEventCallbacks.put(packageName, callbacksForPackage);     // Catch: Throwable -> L35
            monitor-exit(r1);     // Catch: Throwable -> L35
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            Iterator<NotificationRecord> r3 = this.this$0.mNotificationList.iterator();     // Catch: Throwable -> L25
        L16:
            if (r3.hasNext() == false) goto L31;
            NotificationRecord r = r3.next();     // Catch: Throwable -> L25
            if (r.getNotification().isStyle(Notification.CallStyle.class) == false) goto L16;
            if (NotificationManagerService.m6252$$Nest$smnotificationMatchesUserId(r, userId, false) == false) goto L16;
            if (r.getSbn().getPackageName().equals(packageName) == false) goto L16;
            listener.onCallNotificationPosted(packageName, r.getUser());     // Catch: Throwable -> L25 RemoteException -> L27
        L27:
            e = move-exception;
            throw new RuntimeException(e);     // Catch: Throwable -> L25
        L31:
            monitor-exit(r2);     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        L37:
            Log.e(NotificationManagerService.TAG, "registerCallNotificationEventListener failed to register listener: " + packageName + " " + userHandle + " " + listener);     // Catch: Throwable -> L35
            monitor-exit(r1);     // Catch: Throwable -> L35
            return;
        L35:
            th = move-exception;
            throw th;
        L5:
            userId = NotificationManagerService.m6132$$Nest$fgetmAmi(this.this$0).getCurrentUserId();
            goto L6
        }

        public void unregisterCallNotificationEventListener(String packageName, UserHandle userHandle, ICallNotificationEventCallback listener) {
            unregisterCallNotificationEventListener_enforcePermission();
            ArrayMap<String, ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>>> r0 = this.this$0.mCallNotificationEventCallbacks;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (userHandle.getIdentifier() == (-2)) goto L9;
            int userId = userHandle.getIdentifier();     // Catch: Throwable -> L7
        L10:
            ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>> callbacksForPackage = this.this$0.mCallNotificationEventCallbacks.get(packageName);     // Catch: Throwable -> L7
            if (callbacksForPackage != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L14:
            RemoteCallbackList<ICallNotificationEventCallback> callbackList = callbacksForPackage.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
            if (callbackList != null) goto L19;
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L19:
            if (callbackList.unregister(listener) == true) goto L21;
            Log.e(NotificationManagerService.TAG, "unregisterCallNotificationEventListener listener not found for: " + packageName + " " + userHandle + " " + listener);     // Catch: Throwable -> L7
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            userId = NotificationManagerService.m6132$$Nest$fgetmAmi(this.this$0).getCurrentUserId();     // Catch: Throwable -> L7
            goto L10
        }

        public void registerListener(INotificationListener listener, ComponentName component, int userid) {
            enforceSystemOrSystemUI("INotificationManager.registerListener");
            this.this$0.mListeners.registerSystemService(listener, component, userid, Binder.getCallingUid());
        }

        public void unregisterListener(INotificationListener token, int userid) {
            this.this$0.mListeners.unregisterService(token, userid);
        }

        public void cancelNotificationsFromListener(INotificationListener token, String[] keys) {
            AnonymousClass12 r1 = this;
            int callingPid = Binder.getCallingUid();
            int callingPid2 = Binder.getCallingPid();
            long identity = Binder.clearCallingIdentity();
            boolean notificationsRapidlyCleared = false;
            Object r5 = r1.this$0.mNotificationLock;     // Catch: Throwable -> L105
            monitor-enter(r5);     // Catch: Throwable -> L105
            ManagedServices.ManagedServiceInfo info = r1.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L107
            String pkg = info.component.getPackageName();     // Catch: Throwable -> L107
            monitor-exit(r5);     // Catch: Throwable -> L107
            int packageImportance = NotificationManagerService.m6202$$Nest$mgetPackageImportanceWithIdentity(r1.this$0, pkg);     // Catch: Throwable -> L105
            Object r6 = r1.this$0.mNotificationLock;     // Catch: Throwable -> L105
            monitor-enter(r6);     // Catch: Throwable -> L105
            if (r1.this$0.mAssistants.isServiceTokenValidLocked(token) == false) goto L13;
            int reason = 22;
        L14:
            if (keys != null) goto L147;
            AnonymousClass12 r8 = r1;
            int callingUid = callingPid;
            Object r18 = r6;
            Iterator<NotificationRecord> r0 = r8.this$0.mNotificationList.iterator();     // Catch: Throwable -> L95
        L57:
            if (r0.hasNext() == false) goto L69;
            NotificationRecord notificationRecord = r0.next();     // Catch: Throwable -> L67
            Iterator<NotificationRecord> r16 = r0;
            int callingUid2 = callingUid;
            if (NotificationManagerService.m6221$$Nest$misNotificationRecent(r8.this$0, notificationRecord.getUpdateTimeMs()) == true) goto L63;
            callingUid = callingUid2;
            r0 = r16;
            goto L57
        L63:
            boolean notificationsRapidlyCleared2 = true;
        L134:
            int callingUid3 = callingUid2;
            r8.this$0.cancelAllLocked(callingUid3, callingPid2, info.userid, 11, info, info.supportsProfiles(), 65570);     // Catch: Throwable -> L91
            NotificationManagerService.m6224$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedListLocked(r8.this$0, r8.this$0.mNotificationList, packageImportance);     // Catch: Throwable -> L89
            NotificationManagerService.m6224$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedListLocked(r8.this$0, r8.this$0.mEnqueuedNotifications, packageImportance);     // Catch: Throwable -> L89
        L76:
            monitor-exit(r18);     // Catch: Throwable -> L89
            if (notificationsRapidlyCleared2 == false) goto L87;
            NotificationManagerService.m6133$$Nest$fgetmAppOps(r8.this$0).noteOpNoThrow(142, callingUid3, pkg, null, null);     // Catch: Throwable -> L82
        L82:
            th = th;
        L113:
            Binder.restoreCallingIdentity(identity);
            throw th;
        L84:
            th = th;
        L87:
            Binder.restoreCallingIdentity(identity);
            return;
        L89:
            th = th;
        L126:
            monitor-exit(r18);     // Catch: Throwable -> L103
            throw th;     // Catch: Throwable -> L101
        L103:
            th = th;
        L91:
            th = th;
        L93:
            th = th;
        L65:
            th = th;
        L67:
            th = th;
            goto L126
        L69:
            callingUid2 = callingUid;
            notificationsRapidlyCleared2 = false;
        L95:
            th = th;
            goto L126
        L147:
            int i = keys.length;     // Catch: Throwable -> L52
            int i2 = 0;
        L16:
            if (i2 >= i) goto L54;
            int N = i;
            NotificationRecord r = r1.this$0.mNotificationsByKey.get(keys[i2]);     // Catch: Throwable -> L52
            if (r == null) goto L26;
            int userId = r.getSbn().getUserId();     // Catch: Throwable -> L52
            if (userId != info.userid) goto L23;
        L29:
            if (notificationsRapidlyCleared == false) goto L137;
            int callingUid4 = callingPid;
        L41:
            boolean r2 = true;
        L42:
            boolean notificationsRapidlyCleared3 = r2;
            String r3 = r.getSbn().getPackageName();     // Catch: Throwable -> L50
            String r4 = r.getSbn().getTag();     // Catch: Throwable -> L50
            int i3 = r.getSbn().getId();     // Catch: Throwable -> L50
            int callingUid5 = callingUid4;
            r18 = r6;
            ManagedServices.ManagedServiceInfo info2 = info;
            cancelNotificationFromListenerLocked(info2, callingUid5, callingPid2, r3, r4, i3, userId, reason);     // Catch: Throwable -> L48
            AnonymousClass12 r9 = this;
            int callingUid6 = callingUid5;
            ManagedServices.ManagedServiceInfo info3 = info2;
            notificationsRapidlyCleared = notificationsRapidlyCleared3;
        L47:
            i2 = i2 + 1;
            callingPid2 = callingPid2;
            info = info3;
            i = N;
            r6 = r18;
            callingPid = callingUid6;
            r1 = r9;
        L48:
            th = th;
        L50:
            th = th;
            r18 = r6;
            goto L126
        L137:
            callingUid4 = callingPid;
            if (NotificationManagerService.m6221$$Nest$misNotificationRecent(r1.this$0, r.getUpdateTimeMs()) == true) goto L41;
            r2 = false;
        L36:
            th = th;
            r18 = r6;
        L38:
            th = th;
            r18 = r6;
            goto L126
        L23:
            if (userId == (-1)) goto L29;
            if (NotificationManagerService.m6170$$Nest$fgetmUserProfiles(r1.this$0).isCurrentProfile(userId) == true) goto L29;
        L27:
            th = th;
            r18 = r6;
        L26:
            r9 = r1;
            callingUid6 = callingPid;
            r18 = r6;
            info3 = info;
            goto L47
        L54:
            r8 = r1;
            callingUid3 = callingPid;
            r18 = r6;
            notificationsRapidlyCleared2 = notificationsRapidlyCleared;
        L52:
            th = th;
            r18 = r6;
            goto L126
        L13:
            reason = 10;
        L97:
            th = th;
            r18 = r6;
            goto L126
        L101:
            th = th;
        L107:
            th = th;
        L141:
            throw th;     // Catch: Throwable -> L101
        L111:
            th = th;
        L105:
            th = th;
            goto L113
        }

        public void requestBindListener(ComponentName component) {
            this.this$0.checkCallerIsSystemOrSameApp(component.getPackageName());
            int uid = Binder.getCallingUid();
            UserHandle.getUserId(uid);
            long identity = Binder.clearCallingIdentity();
            boolean isAssistantEnabled = this.this$0.mAssistants.isComponentEnabledForCurrentProfiles(component);     // Catch: Throwable -> L6
            if (isAssistantEnabled == false) goto L8;
            ManagedServices manager = this.this$0.mAssistants;     // Catch: Throwable -> L6
        L9:
            manager.setComponentState(component, UserHandle.getUserId(uid), true);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            manager = this.this$0.mListeners;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void requestUnbindListener(INotificationListener token) {
            int uid = Binder.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            Object r3 = this.this$0.mNotificationLock;     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L9
            info.getOwner().setComponentState(info.component, UserHandle.getUserId(uid), false);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void requestUnbindListenerComponent(ComponentName component) {
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, component.getPackageName());
            int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(uid);
            long identity = Binder.clearCallingIdentity();
            Object r4 = this.this$0.mNotificationLock;     // Catch: Throwable -> L19
            monitor-enter(r4);     // Catch: Throwable -> L19
            boolean isAssistantEnabled = this.this$0.mAssistants.isComponentEnabledForCurrentProfiles(component);     // Catch: Throwable -> L8
            if (isAssistantEnabled == false) goto L10;
            ManagedServices manager = this.this$0.mAssistants;     // Catch: Throwable -> L8
        L12:
            if (manager.isPackageOrComponentAllowed(component.flattenToString(), userId) == false) goto L14;
            manager.setComponentState(component, userId, false);     // Catch: Throwable -> L8
        L14:
            monitor-exit(r4);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            manager = this.this$0.mListeners;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setNotificationsShownFromListener(INotificationListener token, String[] keys) {
            long identity = Binder.clearCallingIdentity();
            Object r2 = this.this$0.mNotificationLock;     // Catch: Throwable -> L39
            monitor-enter(r2);     // Catch: Throwable -> L39
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L10
            if (keys != null) goto L12;
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            ArrayList<NotificationRecord> seen = new ArrayList();     // Catch: Throwable -> L10
            int n = keys.length;     // Catch: Throwable -> L10
            int i = 0;
        L13:
            if (i >= n) goto L32;
            NotificationRecord r = this.this$0.mNotificationsByKey.get(keys[i]);     // Catch: Throwable -> L10
            if (r == null) goto L30;
            int userId = r.getSbn().getUserId();     // Catch: Throwable -> L10
            if (userId != info.userid) goto L20;
        L24:
            seen.add(r);     // Catch: Throwable -> L10
            if (r.isSeen() == true) goto L30;
            if (NotificationManagerService.DBG == false) goto L29;
            Slog.d(NotificationManagerService.TAG, "Marking notification as seen " + keys[i]);     // Catch: Throwable -> L10
        L29:
            this.this$0.reportSeen(r);     // Catch: Throwable -> L10
            r.setSeen();     // Catch: Throwable -> L10
            this.this$0.maybeRecordInterruptionLocked(r);     // Catch: Throwable -> L10
            goto L30
        L20:
            if (userId == (-1)) goto L24;
            if (NotificationManagerService.m6170$$Nest$fgetmUserProfiles(this.this$0).isCurrentProfile(userId) == true) goto L24;
        L30:
            i = i + 1;     // Catch: Throwable -> L10
            goto L13
        L32:
            if (seen.isEmpty() == true) goto L34;
            this.this$0.mAssistants.onNotificationsSeenLocked(seen);     // Catch: Throwable -> L10
        L34:
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private void cancelNotificationFromListenerLocked(ManagedServices.ManagedServiceInfo info, int callingUid, int callingPid, String pkg, String tag, int id, int userId, int reason) {
            int mustNotHaveFlags = 2 | 65536;
            this.this$0.cancelNotification(callingUid, callingPid, pkg, tag, id, 0, mustNotHaveFlags, true, userId, reason, info);
        }

        public void snoozeNotificationUntilContextFromListener(INotificationListener token, String key, String snoozeCriterionId) {
            int callingUid = Binder.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            this.this$0.snoozeNotificationInt(callingUid, token, key, -1, snoozeCriterionId);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            th = move-exception;
            Throwable r10 = th;
        L12:
            Binder.restoreCallingIdentity(identity);
            throw r10;
        L10:
            th = move-exception;
            r10 = th;
            goto L12
        }

        public void snoozeNotificationUntilFromListener(INotificationListener token, String key, long duration) {
            int callingUid = Binder.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            this.this$0.snoozeNotificationInt(callingUid, token, key, duration, null);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            th = move-exception;
            Throwable r10 = th;
        L12:
            Binder.restoreCallingIdentity(identity);
            throw r10;
        L10:
            th = move-exception;
            r10 = th;
            goto L12
        }

        public void unsnoozeNotificationFromAssistant(INotificationListener token, String key) {
            long identity = Binder.clearCallingIdentity();
            Object r2 = this.this$0.mNotificationLock;     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            ManagedServices.ManagedServiceInfo info = this.this$0.mAssistants.checkServiceTokenLocked(token);     // Catch: Throwable -> L9
            this.this$0.unsnoozeNotificationInt(key, info, false);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void unsnoozeNotificationFromSystemListener(INotificationListener token, String key) {
            long identity = Binder.clearCallingIdentity();
            Object r2 = this.this$0.mNotificationLock;     // Catch: Throwable -> L17
            monitor-enter(r2);     // Catch: Throwable -> L17
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L11
            if (info.isSystem == false) goto L14;
            this.this$0.unsnoozeNotificationInt(key, info, true);     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return;
        L14:
            throw new SecurityException("Not allowed to unsnooze before deadline");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void migrateNotificationFilter(INotificationListener token, int defaultTypes, List<String> disallowedApps) {
            long identity = Binder.clearCallingIdentity();
            Object r4 = this.this$0.mNotificationLock;     // Catch: Throwable -> L49
            monitor-enter(r4);     // Catch: Throwable -> L49
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L10
            Pair<ComponentName, Integer> r0 = Pair.create(info.component, Integer.valueOf(info.userid));     // Catch: Throwable -> L10
            NotificationListenerFilter nlf = this.this$0.mListeners.getNotificationListenerFilter(r0);     // Catch: Throwable -> L10
            if (nlf != null) goto L12;
            NotificationListenerFilter nlf2 = new NotificationListenerFilter();     // Catch: Throwable -> L10
        L14:
            if (nlf2.getDisallowedPackages().isEmpty() == false) goto L32;
            if (disallowedApps == null) goto L32;
            Iterator<String> r9 = disallowedApps.iterator();     // Catch: Throwable -> L10
        L18:
            if (r9.hasNext() == false) goto L32;
            String pkg = r9.next();     // Catch: Throwable -> L10
            int r12 = 0;
            int[] r11 = NotificationManagerService.m6167$$Nest$fgetmUm(this.this$0).getProfileIds(info.userid, false);     // Catch: Throwable -> L10
            int r13 = r11.length;     // Catch: Throwable -> L10
        L20:
            if (r12 >= r13) goto L18;
            int userId = r11[r12];     // Catch: Throwable -> L10
            int uid = getUidForPackageAndUser(pkg, UserHandle.of(userId));     // Catch: Throwable -> L10 Exception -> L27
            if (uid == (-1)) goto L30;
            VersionedPackage vp = new VersionedPackage(pkg, uid);     // Catch: Throwable -> L10 Exception -> L27
            nlf2.addPackage(vp);     // Catch: Throwable -> L10 Exception -> L27
        L30:
            r12 = r12 + 1;
        L32:
            if (nlf2.areAllTypesAllowed() == false) goto L39;
            nlf2.setTypes(defaultTypes);     // Catch: Throwable -> L36
        L39:
            this.this$0.mListeners.setNotificationListenerFilter(r0, nlf2);     // Catch: Throwable -> L36
            monitor-exit(r4);     // Catch: Throwable -> L36
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            nlf2 = nlf;
        L10:
            th = th;
        L45:
            monitor-exit(r4);     // Catch: Throwable -> L36
            throw th;     // Catch: Throwable -> L47
        L47:
            th = th;
        L51:
            Binder.restoreCallingIdentity(identity);
            throw th;
        L43:
            th = th;
        L36:
            th = th;
        L49:
            th = th;
            goto L51
        }

        public void cancelNotificationFromListener(INotificationListener token, String pkg, String tag, int id) {
            Slog.e(NotificationManagerService.TAG, "Ignoring deprecated cancelNotification(pkg, tag, id) use cancelNotification(key) instead.");
        }

        public ParceledListSlice<StatusBarNotification> getActiveNotificationsFromListener(INotificationListener token, String[] keys, int trim) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L11
            if (keys == null) goto L7;
            boolean getKeys = true;
        L9:
            if (getKeys == false) goto L13;
            int N = keys.length;     // Catch: Throwable -> L11
        L14:
            ArrayList<StatusBarNotification> list = new ArrayList(N);     // Catch: Throwable -> L11
            int i = 0;
        L15:
            if (i >= N) goto L20;
            if (getKeys == false) goto L18;
            NotificationRecord r = this.this$0.mNotificationsByKey.get(keys[i]);     // Catch: Throwable -> L11
        L19:
            addToListIfNeeded(r, info, list, trim);     // Catch: Throwable -> L11
            i = i + 1;     // Catch: Throwable -> L11
            goto L15
        L18:
            r = this.this$0.mNotificationList.get(i);     // Catch: Throwable -> L11
            goto L19
        L20:
            ParceledListSlice<StatusBarNotification> r5 = new ParceledListSlice(list);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r5;
        L13:
            N = this.this$0.mNotificationList.size();     // Catch: Throwable -> L11
            goto L14
        L7:
            getKeys = false;
        L11:
            th = move-exception;
            throw th;
        }

        public ParceledListSlice<StatusBarNotification> getSnoozedNotificationsFromListener(INotificationListener token, int trim) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L7
            List<NotificationRecord> snoozedRecords = this.this$0.mSnoozeHelper.getSnoozed();     // Catch: Throwable -> L7
            int N = snoozedRecords.size();     // Catch: Throwable -> L7
            ArrayList<StatusBarNotification> list = new ArrayList(N);     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= N) goto L9;
            addToListIfNeeded(snoozedRecords.get(i), info, list, trim);     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L9:
            ParceledListSlice<StatusBarNotification> r5 = new ParceledListSlice(list);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r5;
        L7:
            th = move-exception;
            throw th;
        }

        private void addToListIfNeeded(NotificationRecord r, ManagedServices.ManagedServiceInfo info, ArrayList<StatusBarNotification> notifications, int trim) {
            if (r != null) goto L4;
            return;
        L4:
            StatusBarNotification sbn = r.getSbn();
            if (this.this$0.isVisibleToListener(sbn, r.getNotificationType(), info) == true) goto L8;
            return;
        L8:
            if (this.this$0.mListeners.hasSensitiveContent(r) == true) goto L10;
        L12:
            if (trim != 0) goto L14;
            StatusBarNotification r1 = sbn;
        L15:
            notifications.add(r1);
            return;
        L14:
            r1 = sbn.cloneLight();
            goto L15
        L10:
            if (this.this$0.mListeners.isUidTrusted(info.uid) == true) goto L12;
            notifications.add(this.this$0.mListeners.redactStatusBarNotification(sbn));
        }

        public void clearRequestedListenerHints(INotificationListener token) {
            long identity = Binder.clearCallingIdentity();
            Object r2 = this.this$0.mNotificationLock;     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L9
            NotificationManagerService.m6231$$Nest$mremoveDisabledHints(this.this$0, info);     // Catch: Throwable -> L9
            NotificationManagerService.m6242$$Nest$mupdateListenerHintsLocked(this.this$0);     // Catch: Throwable -> L9
            NotificationManagerService.m6240$$Nest$mupdateEffectsSuppressorLocked(this.this$0);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void requestHintsFromListener(INotificationListener token, int hints) {
            long identity = Binder.clearCallingIdentity();
            Object r2 = this.this$0.mNotificationLock;     // Catch: Throwable -> L20
            monitor-enter(r2);     // Catch: Throwable -> L20
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L11
            if ((hints & 7) == 0) goto L8;
            boolean disableEffects = true;
        L9:
            if (disableEffects == false) goto L13;
            NotificationManagerService.m6176$$Nest$maddDisabledHints(this.this$0, info, hints);     // Catch: Throwable -> L11
        L14:
            NotificationManagerService.m6242$$Nest$mupdateListenerHintsLocked(this.this$0);     // Catch: Throwable -> L11
            NotificationManagerService.m6240$$Nest$mupdateEffectsSuppressorLocked(this.this$0);     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return;
        L13:
            NotificationManagerService.m6232$$Nest$mremoveDisabledHints(this.this$0, info, hints);     // Catch: Throwable -> L11
            goto L14
        L8:
            disableEffects = false;
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public int getHintsFromListener(INotificationListener token) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            int r1 = NotificationManagerService.m6144$$Nest$fgetmListenerHints(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getHintsFromListenerNoToken() {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            int r1 = NotificationManagerService.m6144$$Nest$fgetmListenerHints(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void requestInterruptionFilterFromListener(INotificationListener token, int interruptionFilter) throws RemoteException {
            final int callingUid = Binder.getCallingUid();
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            final ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L14
            monitor-exit(r1);     // Catch: Throwable -> L14
            final int zenMode = NotificationManager.zenModeFromInterruptionFilter(interruptionFilter, -1);
            if (zenMode != (-1)) goto L9;
            return;
        L9:
            final UserHandle zenUser = getCallingZenUser();
            if (canManageGlobalZenPolicy(info.component.getPackageName(), callingUid) == true) goto L12;
            this.this$0.mZenModeHelper.applyGlobalZenModeAsImplicitZenRule(zenUser, info.component.getPackageName(), callingUid, zenMode);
            return;
        L12:
            final int origin = computeZenOrigin(false);
            Binder.withCleanCallingIdentity(new NotificationManagerService$12$$ExternalSyntheticLambda1(this, zenUser, zenMode, origin, info, callingUid));
            return;
        L14:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$requestInterruptionFilterFromListener$1(UserHandle zenUser, int zenMode, int origin, ManagedServices.ManagedServiceInfo info, int callingUid) throws Exception {
            this.this$0.mZenModeHelper.setManualZenMode(zenUser, zenMode, null, origin, "listener:" + info.component.flattenToShortString(), info.component.getPackageName(), callingUid);
        }

        public int getInterruptionFilterFromListener(INotificationListener token) throws RemoteException {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            int r1 = NotificationManagerService.m6142$$Nest$fgetmInterruptionFilter(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setOnNotificationPostedTrimFromListener(INotificationListener token, int trim) throws RemoteException {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L8
            if (info != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.this$0.mListeners.setOnNotificationPostedTrimLocked(info, trim);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public int getZenMode() {
            return this.this$0.mZenModeHelper.getZenMode();
        }

        public ZenModeConfig getZenModeConfig() {
            enforceSystemOrSystemUI("INotificationManager.getZenModeConfig");
            return this.this$0.mZenModeHelper.getConfig();
        }

        public void setZenMode(int mode, Uri conditionId, String reason, boolean fromUser) {
            enforceSystemOrSystemUI("INotificationManager.setZenMode");
            enforceUserOriginOnlyFromSystem(fromUser, "setZenMode");
            UserHandle zenUser = getCallingZenUser();
            int callingUid = Binder.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            this.this$0.mZenModeHelper.setManualZenMode(zenUser, mode, conditionId, computeZenOrigin(fromUser), reason, null, callingUid);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            th = move-exception;
            Throwable r12 = th;
        L12:
            Binder.restoreCallingIdentity(identity);
            throw r12;
        L10:
            th = move-exception;
            r12 = th;
            goto L12
        }

        public ParceledListSlice getAutomaticZenRules() {
            int callingUid = Binder.getCallingUid();
            enforcePolicyAccess(callingUid, "getAutomaticZenRules");
            List<AutomaticZenRule.AzrWithId> ruleList = new ArrayList();
            Iterator<Map.Entry<String, AutomaticZenRule>> r2 = this.this$0.mZenModeHelper.getAutomaticZenRules(getCallingZenUser(), callingUid).entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            Map.Entry<String, AutomaticZenRule> rule = r2.next();
            ruleList.add(new AutomaticZenRule.AzrWithId(rule.getKey(), rule.getValue()));
            goto L4
        L7:
            return new ParceledListSlice(ruleList);
        }

        public AutomaticZenRule getAutomaticZenRule(String id) throws RemoteException {
            id.getClass();
            int callingUid = Binder.getCallingUid();
            enforcePolicyAccess(callingUid, "getAutomaticZenRule");
            return this.this$0.mZenModeHelper.getAutomaticZenRule(getCallingZenUser(), id, callingUid);
        }

        public String addAutomaticZenRule(AutomaticZenRule automaticZenRule, String pkg, boolean fromUser) {
            validateAutomaticZenRule(null, automaticZenRule);
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, pkg);
            if (automaticZenRule.getZenPolicy() != null) goto L5;
        L9:
            enforcePolicyAccess(Binder.getCallingUid(), "addAutomaticZenRule");
            enforceUserOriginOnlyFromSystem(fromUser, "addAutomaticZenRule");
            UserHandle zenUser = getCallingZenUser();
            if (this.this$0.isCallingAppIdSystem() == true) goto L12;
        L14:
            String rulePkg = pkg;
        L16:
            return this.this$0.mZenModeHelper.addAutomaticZenRule(zenUser, rulePkg, automaticZenRule, computeZenOrigin(fromUser), "addAutomaticZenRule", Binder.getCallingUid());
        L12:
            if (automaticZenRule.getOwner() == null) goto L14;
            String rulePkg2 = automaticZenRule.getOwner().getPackageName();
            rulePkg = rulePkg2;
            goto L16
        L5:
            if (automaticZenRule.getInterruptionFilter() == 2) goto L9;
            throw new IllegalArgumentException("ZenPolicy is only applicable to INTERRUPTION_FILTER_PRIORITY filters");
        }

        public void setManualZenRuleDeviceEffects(ZenDeviceEffects effects) throws RemoteException {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            UserHandle zenUser = getCallingZenUser();
            this.this$0.mZenModeHelper.setManualZenRuleDeviceEffects(zenUser, effects, computeZenOrigin(true), "Update manual mode non-policy settings", Binder.getCallingUid());
        }

        public boolean updateAutomaticZenRule(String id, AutomaticZenRule automaticZenRule, boolean fromUser) throws RemoteException {
            validateAutomaticZenRule(id, automaticZenRule);
            enforcePolicyAccess(Binder.getCallingUid(), "updateAutomaticZenRule");
            enforceUserOriginOnlyFromSystem(fromUser, "updateAutomaticZenRule");
            UserHandle zenUser = getCallingZenUser();
            return this.this$0.mZenModeHelper.updateAutomaticZenRule(zenUser, id, automaticZenRule, computeZenOrigin(fromUser), "updateAutomaticZenRule", Binder.getCallingUid());
        }

        private void validateAutomaticZenRule(String updateId, AutomaticZenRule rule) {
            rule.getClass();
            rule.getName().getClass();
            rule.validate();
            boolean isCallerWellbeing = false;
            if (updateId != null) goto L5;
        L9:
            boolean isImplicitRuleUpdateFromSystem = false;
        L11:
            if (isImplicitRuleUpdateFromSystem == false) goto L13;
        L19:
            rule.getConditionId().getClass();
            if (this.this$0.isCallerSystemOrSystemUi() == false) goto L22;
            return;
        L22:
            final int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(uid);
            if (rule.getType() != 7) goto L30;
            boolean isDeviceOwner = ((Boolean) Binder.withCleanCallingIdentity(new NotificationManagerService$12$$ExternalSyntheticLambda3(this, uid))).booleanValue();
            if (isDeviceOwner == false) goto L28;
            return;
        L28:
            throw new IllegalArgumentException("Only Device Owners can use AutomaticZenRules with TYPE_MANAGED");
        L30:
            if (rule.getType() != 3) goto L43;
            String wellbeingPackage = this.this$0.getContext().getResources().getString(R.string.config_systemWellbeing);
            if (TextUtils.isEmpty(wellbeingPackage) == false) goto L34;
        L38:
            if (isCallerWellbeing == false) goto L41;
            return;
        L41:
            throw new IllegalArgumentException("Only the 'Wellbeing' package can use AutomaticZenRules with TYPE_BEDTIME");
        L34:
            if (NotificationManagerService.m6217$$Nest$misCallerSameApp(this.this$0, wellbeingPackage, uid, userId) == false) goto L38;
            isCallerWellbeing = true;
            goto L38
        L43:
            return;
        L13:
            if (rule.getOwner() != null) goto L19;
            if (rule.getConfigurationActivity() != null) goto L19;
            throw new NullPointerException("Rule must have a ConditionProviderService and/or configuration activity");
        L5:
            if (ZenModeConfig.isImplicitRuleId(updateId) == false) goto L9;
            if (this.this$0.isCallerSystemOrSystemUi() == false) goto L9;
            isImplicitRuleUpdateFromSystem = true;
            goto L11
        }

        private /* synthetic */ Boolean lambda$validateAutomaticZenRule$2(int uid) throws Exception {
            return Boolean.valueOf(NotificationManagerService.m6137$$Nest$fgetmDpm(this.this$0).isActiveDeviceOwner(uid));
        }

        public boolean removeAutomaticZenRule(String id, boolean fromUser) throws RemoteException {
            id.getClass();
            enforcePolicyAccess(Binder.getCallingUid(), "removeAutomaticZenRule");
            enforceUserOriginOnlyFromSystem(fromUser, "removeAutomaticZenRule");
            UserHandle zenUser = getCallingZenUser();
            return this.this$0.mZenModeHelper.removeAutomaticZenRule(zenUser, id, computeZenOrigin(fromUser), "removeAutomaticZenRule", Binder.getCallingUid());
        }

        public boolean removeAutomaticZenRules(String packageName, boolean fromUser) throws RemoteException {
            packageName.getClass();
            enforceSystemOrSystemUI("removeAutomaticZenRules");
            enforceUserOriginOnlyFromSystem(fromUser, "removeAutomaticZenRules");
            UserHandle zenUser = getCallingZenUser();
            return this.this$0.mZenModeHelper.removeAutomaticZenRules(zenUser, packageName, computeZenOrigin(fromUser), packageName + "|removeAutomaticZenRules", Binder.getCallingUid());
        }

        public int getRuleInstanceCount(ComponentName owner) throws RemoteException {
            owner.getClass();
            enforceSystemOrSystemUI("getRuleInstanceCount");
            return this.this$0.mZenModeHelper.getCurrentInstanceCount(getCallingZenUser(), owner);
        }

        public int getAutomaticZenRuleState(String id) {
            id.getClass();
            int callingUid = Binder.getCallingUid();
            enforcePolicyAccess(callingUid, "getAutomaticZenRuleState");
            return this.this$0.mZenModeHelper.getAutomaticZenRuleState(getCallingZenUser(), id, callingUid);
        }

        public void setAutomaticZenRuleState(String id, Condition condition) {
            id.getClass();
            condition.getClass();
            condition.validate();
            enforcePolicyAccess(Binder.getCallingUid(), "setAutomaticZenRuleState");
            boolean fromUser = true;
            if (condition.source == 1) goto L6;
            fromUser = false;
        L6:
            UserHandle zenUser = getCallingZenUser();
            this.this$0.mZenModeHelper.setAutomaticZenRuleState(zenUser, id, condition, computeZenOrigin(fromUser), Binder.getCallingUid());
        }

        private UserHandle getCallingZenUser() {
            if (NotificationManagerService.m6218$$Nest$misCallerSystemOrSystemUiOrShell(this.this$0) == false) goto L7;
            return UserHandle.CURRENT;
        L7:
            return Binder.getCallingUserHandle();
        }

        private int computeZenOrigin(boolean fromUser) {
            if (fromUser == false) goto L10;
            if (this.this$0.isCallerSystemOrSystemUi() == false) goto L7;
            return 3;
        L7:
            return 7;
        L10:
            if (this.this$0.isCallerSystemOrSystemUi() == false) goto L13;
            return 5;
        L13:
            return 4;
        }

        private void enforceUserOriginOnlyFromSystem(boolean fromUser, String method) {
            if (fromUser == true) goto L4;
            return;
        L4:
            if (NotificationManagerService.m6218$$Nest$misCallerSystemOrSystemUiOrShell(this.this$0) == false) goto L7;
            return;
        L7:
            throw new SecurityException(TextUtils.formatSimple("Calling %s with fromUser == true is only allowed for system", new Object[]{method}));
        }

        public void setInterruptionFilter(String pkg, int filter, boolean fromUser) {
            enforcePolicyAccess(pkg, "setInterruptionFilter");
            int zen = NotificationManager.zenModeFromInterruptionFilter(filter, -1);
            if (zen == (-1)) goto L21;
            int callingUid = Binder.getCallingUid();
            enforceUserOriginOnlyFromSystem(fromUser, "setInterruptionFilter");
            UserHandle zenUser = getCallingZenUser();
            if (canManageGlobalZenPolicy(pkg, callingUid) == true) goto L8;
            this.this$0.mZenModeHelper.applyGlobalZenModeAsImplicitZenRule(zenUser, pkg, callingUid, zen);
            return;
        L8:
            long identity = Binder.clearCallingIdentity();
            this.this$0.mZenModeHelper.setManualZenMode(zenUser, zen, null, computeZenOrigin(fromUser), "setInterruptionFilter", pkg, callingUid);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(identity);
            return;
        L14:
            th = move-exception;
            Throwable r13 = th;
        L18:
            Binder.restoreCallingIdentity(identity);
            throw r13;
        L16:
            th = move-exception;
            r13 = th;
            goto L18
        L21:
            throw new IllegalArgumentException("Invalid filter: " + filter);
        }

        public void notifyConditions(final String pkg, IConditionProvider provider, final Condition[] conditions) {
            final ManagedServices.ManagedServiceInfo info = NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).checkServiceToken(provider);
            this.this$0.checkCallerIsSystemOrSameApp(pkg);
            this.this$0.mHandler.post(new AnonymousClass1(this, pkg, info, conditions));
        }

        public void requestUnbindProvider(IConditionProvider provider) {
            int uid = Binder.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            ManagedServices.ManagedServiceInfo info = NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).checkServiceToken(provider);     // Catch: Throwable -> L6
            info.getOwner().setComponentState(info.component, UserHandle.getUserId(uid), false);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void requestBindProvider(ComponentName component) {
            this.this$0.checkCallerIsSystemOrSameApp(component.getPackageName());
            int uid = Binder.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).setComponentState(component, UserHandle.getUserId(uid), true);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private void enforceSystemOrSystemUI(String message) {
            if (this.this$0.isCallerSystemOrPhone() == false) goto L5;
            return;
        L5:
            this.this$0.getContext().enforceCallingPermission("android.permission.STATUS_BAR_SERVICE", message);
        }

        private void enforceSystemOrSystemUIOrSamePackage(String pkg, String message) {
            this.this$0.checkCallerIsSystemOrSameApp(pkg);     // Catch: SecurityException -> L4
            return;
        L5:
            this.this$0.getContext().enforceCallingPermission("android.permission.STATUS_BAR_SERVICE", message);
        }

        private void enforcePolicyAccess(int uid, String method) {
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MANAGE_NOTIFICATIONS") != 0) goto L5;
            return;
        L5:
            boolean accessAllowed = false;
            String[] packages = NotificationManagerService.m6153$$Nest$fgetmPackageManagerClient(this.this$0).getPackagesForUid(uid);
            int packageCount = packages.length;
            int i = 0;
        L6:
            if (i >= packageCount) goto L15;
            if (NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).isPackageOrComponentAllowed(packages[i], UserHandle.getUserId(uid)) == false) goto L11;
            accessAllowed = true;
        L11:
            if (packages[i].equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L13;
            accessAllowed = true;
        L13:
            i = i + 1;
            goto L6
        L15:
            if (accessAllowed == false) goto L17;
            return;
        L17:
            Slog.w(NotificationManagerService.TAG, "Notification policy access denied calling " + method);
            throw new SecurityException("Notification policy access denied");
        }

        private boolean canManageGlobalZenPolicy(String callingPkg, final int callingUid) {
            boolean isCompatChangeEnabled = ((Boolean) Binder.withCleanCallingIdentity(new NotificationManagerService$12$$ExternalSyntheticLambda0(callingUid))).booleanValue();
            if (isCompatChangeEnabled == true) goto L5;
        L10:
            return true;
        L5:
            if (this.this$0.isCallerSystemOrSystemUi() == true) goto L10;
            if (NotificationManagerService.m6214$$Nest$mhasCompanionDevice(this.this$0, callingPkg, UserHandle.getUserId(callingUid), Set.of("android.app.role.COMPANION_DEVICE_WATCH", "android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION")) == true) goto L10;
            return false;
        }

        private static /* synthetic */ Boolean lambda$canManageGlobalZenPolicy$3(int callingUid) throws Exception {
            return Boolean.valueOf(CompatChanges.isChangeEnabled(NotificationManagerService.MANAGE_GLOBAL_ZEN_VIA_IMPLICIT_RULES, callingUid));
        }

        private void enforcePolicyAccess(String pkg, String method) {
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MANAGE_NOTIFICATIONS") != 0) goto L5;
            return;
        L5:
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, pkg);
            if (checkPolicyAccess(pkg) == false) goto L8;
            return;
        L8:
            Slog.w(NotificationManagerService.TAG, "Notification policy access denied calling " + method);
            throw new SecurityException("Notification policy access denied");
        }

        private boolean checkPackagePolicyAccess(String pkg) {
            return NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).isPackageOrComponentAllowed(pkg, INotificationManager.Stub.getCallingUserHandle().getIdentifier());
        }

        private boolean checkPolicyAccess(String pkg) {
            int uid = this.this$0.getContext().getPackageManager().getPackageUidAsUser(pkg, UserHandle.getCallingUserId());     // Catch: PackageManager.NameNotFoundException -> L20
            if (this.this$0.checkComponentPermission("android.permission.MANAGE_NOTIFICATIONS", uid, -1, true) != 0) goto L7;
            return true;
        L7:
            if (checkPackagePolicyAccess(pkg) == true) goto L19;
            if (this.this$0.mListeners.isComponentEnabledForPackage(pkg) == true) goto L19;
            if (NotificationManagerService.m6137$$Nest$fgetmDpm(this.this$0) != null) goto L13;
            return false;
        L13:
            if (NotificationManagerService.m6137$$Nest$fgetmDpm(this.this$0).isActiveProfileOwner(uid) == true) goto L19;
            if (NotificationManagerService.m6137$$Nest$fgetmDpm(this.this$0).isActiveDeviceOwner(uid) == true) goto L19;
            return false;
        L19:
            return true;
        L21:
            return false;
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.getContext(), NotificationManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            DumpFilter filter = DumpFilter.parseFromArguments(args);
            long token = Binder.clearCallingIdentity();
            ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions = this.this$0.getAllUsersNotificationPermissions();     // Catch: Throwable -> L9
            if (filter.stats == false) goto L12;
            NotificationManagerService.m6193$$Nest$mdumpJson(this.this$0, pw, filter, pkgPermissions);     // Catch: Throwable -> L9
        L21:
            Binder.restoreCallingIdentity(token);
            return;
        L12:
            if (filter.rvStats == false) goto L15;
            NotificationManagerService.m6196$$Nest$mdumpRemoteViewStats(this.this$0, pw, filter);     // Catch: Throwable -> L9
            goto L21
        L15:
            if (filter.proto == false) goto L18;
            NotificationManagerService.m6195$$Nest$mdumpProto(this.this$0, fd, filter, pkgPermissions);     // Catch: Throwable -> L9
            goto L21
        L18:
            if (filter.criticalPriority == false) goto L20;
            NotificationManagerService.m6194$$Nest$mdumpNotificationRecords(this.this$0, pw, filter);     // Catch: Throwable -> L9
            goto L21
        L20:
            this.this$0.dumpImpl(pw, filter, pkgPermissions);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public ComponentName getEffectsSuppressor() {
            if (NotificationManagerService.m6138$$Nest$fgetmEffectsSuppressors(this.this$0).isEmpty() == true) goto L5;
            ComponentName suppressor = (ComponentName) NotificationManagerService.m6138$$Nest$fgetmEffectsSuppressors(this.this$0).get(0);
        L7:
            if (NotificationManagerService.m6218$$Nest$misCallerSystemOrSystemUiOrShell(this.this$0) == true) goto L13;
            if (suppressor == null) goto L13;
            if (NotificationManagerService.m6217$$Nest$misCallerSameApp(this.this$0, suppressor.getPackageName(), Binder.getCallingUid(), UserHandle.getUserId(Binder.getCallingUid())) == true) goto L13;
            return null;
        L13:
            return suppressor;
        L5:
            suppressor = null;
            goto L7
        }

        public boolean matchesCallFilter(Bundle extras) {
            boolean systemAccess = false;
            enforceSystemOrSystemUI("INotificationManager.matchesCallFilter");     // Catch: SecurityException -> L5
            systemAccess = true;
        L6:
            boolean listenerAccess = false;
            String[] pkgNames = this.this$0.mPackageManager.getPackagesForUid(Binder.getCallingUid());     // Catch: Throwable -> L12 RemoteException -> L14
            int i = 0;
        L9:
            if (i >= pkgNames.length) goto L17;
            listenerAccess = listenerAccess | this.this$0.mListeners.hasAllowedListener(pkgNames[i], Binder.getCallingUserHandle().getIdentifier());
            i = i + 1;
            goto L9
            goto L25
        L17:
            if (systemAccess == true) goto L29;
            if (listenerAccess == true) goto L29;
        L19:
            this.this$0.getContext().enforceCallingPermission("android.permission.READ_CONTACTS", "matchesCallFilter requires listener permission, contacts read access, or system level access");
        L29:
            return this.this$0.mZenModeHelper.matchesCallFilter(Binder.getCallingUserHandle(), extras, (ValidateNotificationPeople) this.this$0.mRankingHelper.findExtractor(ValidateNotificationPeople.class), 3000, 1.0f, Binder.getCallingUid());
        L12:
            th = move-exception;
            if (systemAccess == true) goto L23;
            if (listenerAccess == true) goto L23;
            this.this$0.getContext().enforceCallingPermission("android.permission.READ_CONTACTS", "matchesCallFilter requires listener permission, contacts read access, or system level access");
        L23:
            throw th;
        L25:
            if (systemAccess == true) goto L29;
            if (listenerAccess == true) goto L29;
            goto L19
        }

        public void cleanUpCallersAfter(long timeThreshold) {
            enforceSystemOrSystemUI("INotificationManager.cleanUpCallersAfter");
            this.this$0.mZenModeHelper.cleanUpCallersAfter(timeThreshold);
        }

        public boolean isSystemConditionProviderEnabled(String path) {
            enforceSystemOrSystemUI("INotificationManager.isSystemConditionProviderEnabled");
            return NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).isSystemProviderEnabled(path);
        }

        public byte[] getBackupPayload(int user) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            if (NotificationManagerService.DBG == false) goto L5;
            Slog.d(NotificationManagerService.TAG, "getBackupPayload u=" + user);
        L5:
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            this.this$0.writePolicyXml(baos, true, user, null);     // Catch: IOException -> L8
            return baos.toByteArray();
        L8:
            e = move-exception;
            Slog.w(NotificationManagerService.TAG, "getBackupPayload: error writing payload for user " + user, e);
            return null;
        }

        public void applyRestore(byte[] payload, int user) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            if (NotificationManagerService.DBG == false) goto L9;
            StringBuilder r0 = new StringBuilder();
            r0.append("applyRestore u=");
            r0.append(user);
            r0.append(" payload=");
            if (payload == null) goto L7;
            String r3 = new String(payload, StandardCharsets.UTF_8);
        L8:
            r0.append(r3);
            Slog.d(NotificationManagerService.TAG, r0.toString());
            goto L9
        L7:
            r3 = null;
        L9:
            if (payload != null) goto L12;
            Slog.w(NotificationManagerService.TAG, "applyRestore: no payload to restore for user " + user);
            return;
        L12:
            ByteArrayInputStream bais = new ByteArrayInputStream(payload);
            this.this$0.readPolicyXml(bais, true, user, null);     // Catch: Throwable -> L15
            this.this$0.handleSavePolicyFile();     // Catch: Throwable -> L15
            return;
        L15:
            e = move-exception;
            Slog.w(NotificationManagerService.TAG, "applyRestore: error reading payload", e);
        }

        public boolean isNotificationPolicyAccessGranted(String pkg) {
            return checkPolicyAccess(pkg);
        }

        public boolean isNotificationPolicyAccessGrantedForPackage(String pkg) {
            enforceSystemOrSystemUIOrSamePackage(pkg, "request policy access status for another package");
            return checkPolicyAccess(pkg);
        }

        public void setNotificationPolicyAccessGranted(String pkg, boolean granted) throws RemoteException {
            setNotificationPolicyAccessGrantedForUser(pkg, INotificationManager.Stub.getCallingUserHandle().getIdentifier(), granted);
        }

        public void setNotificationPolicyAccessGrantedForUser(String pkg, int userId, boolean granted) {
            NotificationManagerService.m6187$$Nest$mcheckCallerIsSystemOrShell(this.this$0);
            long identity = Binder.clearCallingIdentity();
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L4:
            if (NotificationManagerService.m6130$$Nest$fgetmAllowedManagedServicePackages(this.this$0).test(pkg, Integer.valueOf(userId), NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).getRequiredPermission()) == false) goto L13;
            boolean changed = NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).setPackageOrComponentEnabled(pkg, userId, true, granted);     // Catch: Throwable -> L11
            if (changed == true) goto L9;
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            this.this$0.getContext().sendBroadcastAsUser(new Intent("android.app.action.NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED").setPackage(pkg).addFlags(67108864), UserHandle.of(userId), null);     // Catch: Throwable -> L11
            this.this$0.handleSavePolicyFile();     // Catch: Throwable -> L11
        L13:
            Binder.restoreCallingIdentity(identity);
        }

        public NotificationManager.Policy getNotificationPolicy(String pkg) {
            int callingUid = Binder.getCallingUid();
            UserHandle zenUser = getCallingZenUser();
            if (canManageGlobalZenPolicy(pkg, callingUid) == false) goto L5;
            long identity = Binder.clearCallingIdentity();
            NotificationManager.Policy r4 = this.this$0.mZenModeHelper.getNotificationPolicy(zenUser);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return r4;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            return this.this$0.mZenModeHelper.getNotificationPolicyFromImplicitZenRule(zenUser, pkg);
        }

        public NotificationManager.Policy getConsolidatedNotificationPolicy() {
            long identity = Binder.clearCallingIdentity();
            NotificationManager.Policy r2 = this.this$0.mZenModeHelper.getConsolidatedNotificationPolicy();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setNotificationPolicy(String pkg, NotificationManager.Policy policy, boolean fromUser) {
            enforcePolicyAccess(pkg, "setNotificationPolicy");
            enforceUserOriginOnlyFromSystem(fromUser, "setNotificationPolicy");
            int callingUid = Binder.getCallingUid();
            int origin = computeZenOrigin(fromUser);
            UserHandle zenUser = getCallingZenUser();
            boolean r8 = NotificationManagerService.m6218$$Nest$misCallerSystemOrSystemUiOrShell(this.this$0);
            boolean shouldApplyAsImplicitRule = !canManageGlobalZenPolicy(pkg, callingUid);
            long identity = Binder.clearCallingIdentity();
            ApplicationInfo applicationInfo = this.this$0.mPackageManager.getApplicationInfo(pkg, 0, UserHandle.getUserId(callingUid));     // Catch: Throwable -> L13 RemoteException -> L15
            NotificationManager.Policy currPolicy = this.this$0.mZenModeHelper.getNotificationPolicy(zenUser);     // Catch: Throwable -> L13 RemoteException -> L15
            if (applicationInfo.targetSdkVersion >= 28) goto L17;
            int priorityCategories = policy.priorityCategories;     // Catch: Throwable -> L13 RemoteException -> L15
        L55:
            NotificationManager.Policy policy2 = new NotificationManager.Policy((((((priorityCategories & (-33)) & (-65)) & (-129)) | (currPolicy.priorityCategories & 32)) | (currPolicy.priorityCategories & 64)) | (currPolicy.priorityCategories & 128), policy.priorityCallSenders, policy.priorityMessageSenders, policy.suppressedVisualEffects);     // Catch: Throwable -> L9 RemoteException -> L11
        L53:
        L23:
            e = e;
        L43:
            Slog.e(NotificationManagerService.TAG, "Failed to set notification policy", e);     // Catch: Throwable -> L35
        L41:
            Binder.restoreCallingIdentity(identity);
            return;
        L21:
            th = th;
        L46:
            Binder.restoreCallingIdentity(identity);
            throw th;
        L19:
            if (applicationInfo.targetSdkVersion >= 30) goto L25;
            int priorityCategories2 = this.this$0.correctCategory(policy2.priorityCategories, 256, currPolicy.priorityCategories);     // Catch: Throwable -> L21 RemoteException -> L23
            policy2 = new NotificationManager.Policy(priorityCategories2, policy2.priorityCallSenders, policy2.priorityMessageSenders, policy2.suppressedVisualEffects, currPolicy.priorityConversationSenders);     // Catch: Throwable -> L21 RemoteException -> L23
        L25:
            int newVisualEffects = this.this$0.calculateSuppressedVisualEffects(policy2, currPolicy, applicationInfo.targetSdkVersion);     // Catch: Throwable -> L21 RemoteException -> L23
            if (r8 == true) goto L28;
        L30:
            int newState = -1;
        L31:
            NotificationManager.Policy policy3 = new NotificationManager.Policy(policy2.priorityCategories, policy2.priorityCallSenders, policy2.priorityMessageSenders, newVisualEffects, newState, policy2.priorityConversationSenders);     // Catch: Throwable -> L21 RemoteException -> L23
        L49:
            if (shouldApplyAsImplicitRule == false) goto L39;
            this.this$0.mZenModeHelper.applyGlobalPolicyAsImplicitZenRule(zenUser, pkg, callingUid, policy3);     // Catch: Throwable -> L35 RemoteException -> L37
        L48:
            goto L41
        L39:
            ZenLog.traceSetNotificationPolicy(pkg, applicationInfo.targetSdkVersion, policy3);     // Catch: Throwable -> L35 RemoteException -> L37
            this.this$0.mZenModeHelper.setNotificationPolicy(zenUser, policy3, origin, callingUid);     // Catch: Throwable -> L35 RemoteException -> L37
        L37:
            e = e;
            goto L43
        L28:
            if (policy2.state == (-1)) goto L30;
            int newState2 = NotificationManager.Policy.policyState(currPolicy.hasPriorityChannels(), policy2.allowPriorityChannels());     // Catch: Throwable -> L21 RemoteException -> L23
            newState = newState2;
            goto L31
        L11:
            e = e;
        L9:
            th = th;
            goto L46
        L17:
            policy2 = policy;
        L35:
            th = th;
        L15:
            e = e;
        L13:
            th = th;
            goto L46
        }

        public ZenPolicy getDefaultZenPolicy() {
            enforceSystemOrSystemUI("INotificationManager.getDefaultZenPolicy");
            long identity = Binder.clearCallingIdentity();
            ZenPolicy r2 = this.this$0.mZenModeHelper.getDefaultZenPolicy();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<String> getEnabledNotificationListenerPackages() {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mListeners.getAllowedPackages(INotificationManager.Stub.getCallingUserHandle().getIdentifier());
        }

        public List<ComponentName> getEnabledNotificationListeners(int userId) {
            this.this$0.checkNotificationListenerAccess();
            return this.this$0.mListeners.getAllowedComponents(userId);
        }

        public ComponentName getAllowedNotificationAssistantForUser(int userId) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            List<ComponentName> allowedComponents = this.this$0.mAssistants.getAllowedComponents(userId);
            if (allowedComponents.size() > 1) goto L7;
            return (ComponentName) CollectionUtils.firstOrNull(allowedComponents);
        L7:
            throw new IllegalStateException("At most one NotificationAssistant: " + allowedComponents.size());
        }

        public ComponentName getAllowedNotificationAssistant() {
            return getAllowedNotificationAssistantForUser(INotificationManager.Stub.getCallingUserHandle().getIdentifier());
        }

        public ComponentName getDefaultNotificationAssistant() {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mAssistants.getDefaultFromConfig();
        }

        public void setNASMigrationDoneAndResetDefault(int userId, boolean loadFromConfig) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.setNASMigrationDone(userId);
            if (loadFromConfig == false) goto L5;
            this.this$0.mAssistants.resetDefaultFromConfig();
            return;
        L5:
            this.this$0.mAssistants.clearDefaults();
        }

        public boolean hasEnabledNotificationListener(String packageName, int userId) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mListeners.isPackageAllowed(packageName, userId);
        }

        public boolean isNotificationListenerAccessGranted(ComponentName listener) {
            listener.getClass();
            this.this$0.checkCallerIsSystemOrSameApp(listener.getPackageName());
            return this.this$0.mListeners.isPackageOrComponentAllowed(listener.flattenToString(), INotificationManager.Stub.getCallingUserHandle().getIdentifier());
        }

        public boolean isNotificationListenerAccessGrantedForUser(ComponentName listener, int userId) {
            listener.getClass();
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            return this.this$0.mListeners.isPackageOrComponentAllowed(listener.flattenToString(), userId);
        }

        public boolean isNotificationAssistantAccessGranted(ComponentName assistant) {
            assistant.getClass();
            this.this$0.checkCallerIsSystemOrSameApp(assistant.getPackageName());
            return this.this$0.mAssistants.isPackageOrComponentAllowed(assistant.flattenToString(), INotificationManager.Stub.getCallingUserHandle().getIdentifier());
        }

        public void setNotificationListenerAccessGranted(ComponentName listener, boolean granted, boolean userSet) throws RemoteException {
            setNotificationListenerAccessGrantedForUser(listener, INotificationManager.Stub.getCallingUserHandle().getIdentifier(), granted, userSet);
        }

        public void setNotificationAssistantAccessGranted(ComponentName assistant, boolean granted) {
            setNotificationAssistantAccessGrantedForUser(assistant, INotificationManager.Stub.getCallingUserHandle().getIdentifier(), granted);
        }

        public void setNotificationListenerAccessGrantedForUser(ComponentName listener, int userId, boolean granted, boolean userSet) {
            listener.getClass();
            if (UserHandle.getCallingUserId() == userId) goto L6;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", "setNotificationListenerAccessGrantedForUser for user " + userId);
        L6:
            if (NotificationManagerService.m6168$$Nest$fgetmUmInternal(this.this$0).isVisibleBackgroundFullUser(userId) == false) goto L8;
            return;
        L8:
            this.this$0.checkNotificationListenerAccess();
            if (granted == true) goto L11;
        L15:
            if (userSet == false) goto L17;
        L19:
            long identity = Binder.clearCallingIdentity();
        L32:
            th = move-exception;
            Throwable r11 = th;
        L37:
            Binder.restoreCallingIdentity(identity);
            throw r11;
        L21:
            if (NotificationManagerService.m6130$$Nest$fgetmAllowedManagedServicePackages(this.this$0).test(listener.getPackageName(), Integer.valueOf(userId), this.this$0.mListeners.getRequiredPermission()) == false) goto L35;
            boolean changed = this.this$0.mListeners.setPackageOrComponentEnabled(listener.flattenToString(), userId, true, granted, userSet);     // Catch: Throwable -> L30
            if (changed == true) goto L28;
            Binder.restoreCallingIdentity(identity);
            return;
        L28:
            NotificationManagerService.m6136$$Nest$fgetmConditionProviders(this.this$0).setPackageOrComponentEnabled(listener.flattenToString(), userId, false, granted, userSet);     // Catch: Throwable -> L30
            this.this$0.getContext().sendBroadcastAsUser(new Intent("android.app.action.NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED").setPackage(listener.getPackageName()).addFlags(1073741824), UserHandle.of(userId), null);     // Catch: Throwable -> L30
            this.this$0.handleSavePolicyFile();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            r11 = th;
        L35:
            Binder.restoreCallingIdentity(identity);
            return;
        L17:
            if (isNotificationListenerAccessUserSet(listener, userId) == false) goto L19;
            return;
        L11:
            if (listener.flattenToString().length() <= NotificationManager.MAX_SERVICE_COMPONENT_NAME_LENGTH) goto L15;
            throw new IllegalArgumentException("Component name too long: " + listener.flattenToString());
        }

        private boolean isNotificationListenerAccessUserSet(ComponentName listener, int userId) {
            return this.this$0.mListeners.isPackageOrComponentUserSet(listener.flattenToString(), userId);
        }

        public void setNotificationAssistantAccessGrantedForUser(ComponentName assistant, int userId, boolean granted) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            Iterator r0 = NotificationManagerService.m6167$$Nest$fgetmUm(this.this$0).getEnabledProfiles(userId).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            UserInfo ui = (UserInfo) r0.next();
            this.this$0.mAssistants.setUserSet(ui.id, true);
            goto L4
        L6:
            long identity = Binder.clearCallingIdentity();
            this.this$0.setNotificationAssistantAccessGrantedForUserInternal(assistant, userId, granted, true);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void applyEnqueuedAdjustmentFromAssistant(INotificationListener token, Adjustment adjustment) {
            boolean foundEnqueued = false;
            long identity = Binder.clearCallingIdentity();
            Object r3 = this.this$0.mNotificationLock;     // Catch: Throwable -> L25
            monitor-enter(r3);     // Catch: Throwable -> L25
            this.this$0.mAssistants.checkServiceTokenLocked(token);     // Catch: Throwable -> L14
            int N = this.this$0.mEnqueuedNotifications.size();     // Catch: Throwable -> L14
            int i = 0;
        L6:
            if (i >= N) goto L18;
            NotificationRecord r = this.this$0.mEnqueuedNotifications.get(i);     // Catch: Throwable -> L14
            if (Objects.equals(adjustment.getKey(), r.getKey()) == false) goto L16;
            if (Objects.equals(Integer.valueOf(adjustment.getUser()), Integer.valueOf(r.getUserId())) == false) goto L16;
            if (this.this$0.mAssistants.isSameUser(token, r.getUserId()) == false) goto L16;
            NotificationManagerService.m6177$$Nest$mapplyAdjustmentLocked(this.this$0, r, adjustment, false);     // Catch: Throwable -> L14
            r.applyAdjustments();     // Catch: Throwable -> L14
            r.calculateImportance();     // Catch: Throwable -> L14
            foundEnqueued = true;
        L16:
            i = i + 1;     // Catch: Throwable -> L14
            goto L6
        L18:
            if (foundEnqueued == true) goto L20;
            applyAdjustmentsFromAssistant(token, List.of(adjustment));     // Catch: Throwable -> L14
        L20:
            monitor-exit(r3);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(identity);
            return;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void applyAdjustmentFromAssistant(INotificationListener token, Adjustment adjustment) {
            List<Adjustment> adjustments = new ArrayList();
            adjustments.add(adjustment);
            applyAdjustmentsFromAssistant(token, adjustments);
        }

        public void applyAdjustmentsFromAssistant(INotificationListener token, List<Adjustment> adjustments) {
            boolean needsSort = false;
            long identity = Binder.clearCallingIdentity();
            Object r3 = this.this$0.mNotificationLock;     // Catch: Throwable -> L25
            monitor-enter(r3);     // Catch: Throwable -> L25
            this.this$0.mAssistants.checkServiceTokenLocked(token);     // Catch: Throwable -> L17
            Iterator<Adjustment> r4 = adjustments.iterator();     // Catch: Throwable -> L17
        L7:
            if (r4.hasNext() == false) goto L21;
            Adjustment adjustment = r4.next();     // Catch: Throwable -> L17
            NotificationRecord r = this.this$0.mNotificationsByKey.get(adjustment.getKey());     // Catch: Throwable -> L17
            if (r == null) goto L7;
            if (this.this$0.mAssistants.isSameUser(token, r.getUserId()) == false) goto L7;
            NotificationManagerService.m6177$$Nest$mapplyAdjustmentLocked(this.this$0, r, adjustment, true);     // Catch: Throwable -> L17
            if (adjustment.getSignals().containsKey("key_importance") == true) goto L15;
        L19:
            r.setPendingLogUpdate(true);     // Catch: Throwable -> L17
            needsSort = true;
            goto L7
        L15:
            if (adjustment.getSignals().getInt("key_importance") != 0) goto L19;
            cancelNotificationsFromListener(token, new String[]{r.getKey()});     // Catch: Throwable -> L17
            goto L7
        L21:
            monitor-exit(r3);     // Catch: Throwable -> L17
            if (needsSort == false) goto L27;
            this.this$0.mRankingHandler.requestSort();     // Catch: Throwable -> L25
        L27:
            Binder.restoreCallingIdentity(identity);
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public NotificationChannel createConversationNotificationChannelForPackageFromPrivilegedListener(INotificationListener token, String pkg, UserHandle user, String parentId, String conversationId) throws RemoteException {
            pkg.getClass();
            user.getClass();
            parentId.getClass();
            conversationId.getClass();
            ManagedServices.ManagedServiceInfo nlsInfo = verifyPrivilegedListener(token, user, true);
            if (nlsInfo.isSystemUi() == false) goto L5;
        L10:
            int uid = getUidForPackageAndUser(pkg, user);
            NotificationChannel parentChannel = this.this$0.mPreferencesHelper.getNotificationChannel(pkg, uid, parentId, false);
            if (parentChannel != null) goto L13;
            return null;
        L13:
            NotificationChannel previous = this.this$0.mPreferencesHelper.getConversationNotificationChannel(pkg, uid, parentId, conversationId, false, false);
            if (previous == null) goto L16;
            return previous;
        L16:
            String conversationChannelId = String.format("%1$s : %2$s", new Object[]{parentId, conversationId});
            NotificationChannel conversationChannel = parentChannel.copy();
            conversationChannel.setId(conversationChannelId);
            conversationChannel.setConversationId(parentId, conversationId);
            createNotificationChannelsImpl(pkg, uid, new ParceledListSlice(Arrays.asList(new NotificationChannel[]{conversationChannel})));
            NotificationChannel created = this.this$0.mPreferencesHelper.getConversationNotificationChannel(pkg, uid, parentId, conversationId, false, false);
            if (created == null) goto L19;
            NotificationManagerService.m6150$$Nest$fgetmNotificationListenerStats(this.this$0).logCreatedChannels(nlsInfo, 1);
            this.this$0.handleSavePolicyFile();
        L19:
            return created;
        L5:
            if (NotificationManagerService.m6220$$Nest$misNotificationAssistant(this.this$0, nlsInfo.service) == true) goto L10;
            if (NotificationManagerService.m6150$$Nest$fgetmNotificationListenerStats(this.this$0).isAllowedToCreateChannel(nlsInfo) == true) goto L10;
            Slog.e(NotificationManagerService.TAG, "NLS " + nlsInfo + " has created too many channels already! Rejecting " + pkg + SliceClientPermissions.SliceAuthority.DELIMITER + user + SliceClientPermissions.SliceAuthority.DELIMITER + parentId + SliceClientPermissions.SliceAuthority.DELIMITER + conversationId);
            return null;
        }

        public void updateNotificationChannelFromPrivilegedListener(INotificationListener token, String pkg, UserHandle user, NotificationChannel channel) throws RemoteException {
            channel.getClass();
            pkg.getClass();
            user.getClass();
            verifyPrivilegedListener(token, user, true);
            NotificationChannel originalChannel = this.this$0.mPreferencesHelper.getNotificationChannel(pkg, getUidForPackageAndUser(pkg, user), channel.getId(), true);
            verifyPrivilegedListenerUriPermission(Binder.getCallingUid(), channel, originalChannel);
            this.this$0.updateNotificationChannelInt(pkg, getUidForPackageAndUser(pkg, user), channel, true);
        }

        public ParceledListSlice<NotificationChannel> getNotificationChannelsFromPrivilegedListener(INotificationListener token, String pkg, UserHandle user) throws RemoteException {
            pkg.getClass();
            user.getClass();
            verifyPrivilegedListener(token, user, true);
            return this.this$0.mPreferencesHelper.getNotificationChannels(pkg, getUidForPackageAndUser(pkg, user), false, true);
        }

        public ParceledListSlice<NotificationChannelGroup> getNotificationChannelGroupsFromPrivilegedListener(INotificationListener token, String pkg, UserHandle user) throws RemoteException {
            pkg.getClass();
            user.getClass();
            verifyPrivilegedListener(token, user, true);
            List<NotificationChannelGroup> groups = new ArrayList();
            groups.addAll(this.this$0.mPreferencesHelper.getNotificationChannelGroupsWithoutChannels(pkg, getUidForPackageAndUser(pkg, user)));
            return new ParceledListSlice(groups);
        }

        public boolean isInCall(String pkg, int uid) {
            NotificationManagerService.m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(this.this$0);
            return NotificationManagerService.m6216$$Nest$misCallNotification(this.this$0, pkg, uid);
        }

        public void setPrivateNotificationsAllowed(boolean allow) {
            if (this.this$0.getContext().checkCallingPermission("android.permission.CONTROL_KEYGUARD_SECURE_NOTIFICATIONS") != 0) goto L9;
            if (allow == NotificationManagerService.m6145$$Nest$fgetmLockScreenAllowSecureNotifications(this.this$0)) goto L10;
            NotificationManagerService.m6172$$Nest$fputmLockScreenAllowSecureNotifications(this.this$0, allow);
            this.this$0.getContext().sendBroadcast(new Intent("android.app.action.KEYGUARD_PRIVATE_NOTIFICATIONS_CHANGED").putExtra("android.app.extra.KM_PRIVATE_NOTIFS_ALLOWED", NotificationManagerService.m6145$$Nest$fgetmLockScreenAllowSecureNotifications(this.this$0)), "android.permission.STATUS_BAR_SERVICE");
            this.this$0.handleSavePolicyFile();
            return;
        L10:
            return;
        L9:
            throw new SecurityException("Requires CONTROL_KEYGUARD_SECURE_NOTIFICATIONS permission");
        }

        public boolean getPrivateNotificationsAllowed() {
            if (this.this$0.getContext().checkCallingPermission("android.permission.CONTROL_KEYGUARD_SECURE_NOTIFICATIONS") != 0) goto L7;
            return NotificationManagerService.m6145$$Nest$fgetmLockScreenAllowSecureNotifications(this.this$0);
        L7:
            throw new SecurityException("Requires CONTROL_KEYGUARD_SECURE_NOTIFICATIONS permission");
        }

        public boolean isPackagePaused(String pkg) {
            pkg.getClass();
            NotificationManagerService.m6184$$Nest$mcheckCallerIsSameApp(this.this$0, pkg);
            return this.this$0.isPackagePausedOrSuspended(pkg, Binder.getCallingUid());
        }

        public boolean isPermissionFixed(String pkg, int userId) {
            enforceSystemOrSystemUI("isPermissionFixed");
            return NotificationManagerService.m6154$$Nest$fgetmPermissionHelper(this.this$0).isPermissionFixed(pkg, userId);
        }

        private ManagedServices.ManagedServiceInfo verifyPrivilegedListener(INotificationListener token, UserHandle user, boolean assistantAllowed) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            ManagedServices.ManagedServiceInfo info = this.this$0.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L26
            monitor-exit(r0);     // Catch: Throwable -> L26
            if (this.this$0.hasCompanionDevice(info) == true) goto L22;
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            if (assistantAllowed == false) goto L18;
        L15:
            th = move-exception;
            throw th;
        L12:
            if (this.this$0.mAssistants.isServiceTokenValidLocked(info.service) == false) goto L18;
            monitor-exit(r1);     // Catch: Throwable -> L15
        L18:
            throw new SecurityException(info + " does not have access");     // Catch: Throwable -> L15
        L22:
            if (info.enabledAndUserMatches(user.getIdentifier()) == false) goto L25;
            return info;
        L25:
            throw new SecurityException(info + " does not have access");
        L26:
            th = move-exception;
            throw th;
        }

        private void verifyPrivilegedListenerUriPermission(int sourceUid, NotificationChannel updateChannel, NotificationChannel originalChannel) {
            Uri soundUri = updateChannel.getSound();
            if (originalChannel == null) goto L5;
            Uri originalSoundUri = originalChannel.getSound();
        L6:
            if (soundUri != null) goto L8;
            return;
        L8:
            if (Objects.equals(originalSoundUri, soundUri) == true) goto L12;
            PermissionHelper.grantUriPermission(NotificationManagerService.m6166$$Nest$fgetmUgmInternal(this.this$0), soundUri, sourceUid);
            return;
        L12:
            return;
        L5:
            originalSoundUri = null;
            goto L6
        }

        private int getUidForPackageAndUser(String pkg, UserHandle user) throws RemoteException {
            long identity = Binder.clearCallingIdentity();
            int r2 = this.this$0.mPackageManager.getPackageUid(pkg, 0, user.getIdentifier());     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new NotificationShellCmd(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public long pullStats(long startNs, int report, boolean doAgg, List<ParcelFileDescriptor> out) {
            NotificationManagerService.m6187$$Nest$mcheckCallerIsSystemOrShell(this.this$0);
            long startMs = TimeUnit.MILLISECONDS.convert(startNs, TimeUnit.NANOSECONDS);
            long identity = Binder.clearCallingIdentity();
            switch(report) {
                case 1: goto L44;
                default: goto L4;
            };
        L4:
            long r17 = 0;
        L30:
            Binder.restoreCallingIdentity(identity);
            Slog.e(NotificationManagerService.TAG, "exiting pullStats: bad request");
            return r17;
        L44:
            Slog.e(NotificationManagerService.TAG, "pullStats REPORT_REMOTE_VIEWS from: " + startMs + "  with " + doAgg);     // Catch: Throwable -> L24 IOException -> L26
            PulledStats stats = this.this$0.mUsageStats.remoteViewStats(startMs, doAgg);     // Catch: Throwable -> L24 IOException -> L26
            if (stats == null) goto L28;
        L38:
            out.add(stats.toParcelFileDescriptor(report));     // Catch: Throwable -> L16 IOException -> L22
            Slog.e(NotificationManagerService.TAG, "exiting pullStats with: " + out.size());     // Catch: Throwable -> L16 IOException -> L22
            long endNs = TimeUnit.NANOSECONDS.convert(stats.endTimeMs(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16 IOException -> L18
            Binder.restoreCallingIdentity(identity);
            return endNs;
        L20:
            e = e;
            long r18 = 0;
        L33:
            Slog.e(NotificationManagerService.TAG, "exiting pullStats: on error", e);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return r18;
        L22:
            e = e;
        L23:
            r18 = 0;
            goto L33
        L28:
            r17 = 0;
            Slog.e(NotificationManagerService.TAG, "null stats for: " + report);     // Catch: Throwable -> L16 IOException -> L18
        L18:
            e = e;
        L26:
            e = e;
        L24:
            e = th;
        L36:
            Binder.restoreCallingIdentity(identity);
            throw e;
        L16:
            e = th;
            goto L36
        }

        public void incrementCounter(String metricId) {
        }

        public INotificationManagerSmtEx getISmtEx() {
            return NotificationManagerService.m6162$$Nest$fgetmSmtEx(this.this$0).mServiceSmtEx;
        }

        public void setPkgAllNotificationSilent(String pkg, int uid, boolean silent) {
            enforceSystemOrSystemUI("setPkgAllNotificationSilent");
            this.this$0.mPreferencesHelper.setPkgAllNotificationSilent(pkg, uid, silent);
            this.this$0.handleSavePolicyFile();
        }

        public boolean isPkgAllNotificationSilent(String pkg, int uid) {
            enforceSystemOrSystemUI("isPkgAllNotificationSilent");
            return this.this$0.mPreferencesHelper.isPkgAllNotificationSilent(pkg, uid);
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$13, reason: invalid class name */
    class AnonymousClass13 implements NotificationManagerInternal {
        final /* synthetic */ NotificationManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$Y7hWGJ7tw5GT2-NIhu0nynKsCBw, reason: not valid java name */
        public static /* synthetic */ void m6256$r8$lambda$Y7hWGJ7tw5GT2NIhu0nynKsCBw(AnonymousClass13 r0, String r1, int r2, int r3) {
            r0.lambda$removeUserInitiatedJobFlagFromNotification$1(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$YIyC9I1FmZnC2lDA1wJaF-Lch-A, reason: not valid java name */
        public static /* synthetic */ void m6257$r8$lambda$YIyC9I1FmZnC2lDA1wJaFLchA(AnonymousClass13 r0, String r1, int r2, int r3) {
            r0.lambda$removeForegroundServiceFlagFromNotification$0(r1, r2, r3);
        }

        AnonymousClass13(NotificationManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public byte[] getBackupPayload(int user, BackupRestoreEventLogger logger) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            if (NotificationManagerService.DBG == false) goto L5;
            Slog.d(NotificationManagerService.TAG, "getBackupPayload u=" + user);
        L5:
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            this.this$0.writePolicyXml(baos, true, user, logger);     // Catch: IOException -> L8
            return baos.toByteArray();
        L8:
            e = move-exception;
            Slog.w(NotificationManagerService.TAG, "getBackupPayload: error writing payload for user " + user, e);
            return null;
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void applyRestore(byte[] payload, int user, BackupRestoreEventLogger logger) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            if (NotificationManagerService.DBG == false) goto L9;
            StringBuilder r0 = new StringBuilder();
            r0.append("applyRestore u=");
            r0.append(user);
            r0.append(" payload=");
            if (payload == null) goto L7;
            String r2 = new String(payload, StandardCharsets.UTF_8);
        L8:
            r0.append(r2);
            Slog.d(NotificationManagerService.TAG, r0.toString());
            goto L9
        L7:
            r2 = null;
        L9:
            if (payload != null) goto L12;
            Slog.w(NotificationManagerService.TAG, "applyRestore: no payload to restore for user " + user);
            return;
        L12:
            ByteArrayInputStream bais = new ByteArrayInputStream(payload);
            this.this$0.readPolicyXml(bais, true, user, logger);     // Catch: Throwable -> L15
            this.this$0.handleSavePolicyFile();     // Catch: Throwable -> L15
            return;
        L15:
            e = move-exception;
            Slog.w(NotificationManagerService.TAG, "applyRestore: error reading payload", e);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public NotificationChannel getNotificationChannel(String pkg, int uid, String channelId) {
            return this.this$0.mPreferencesHelper.getNotificationChannel(pkg, uid, channelId, false);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public NotificationChannelGroup getNotificationChannelGroup(String pkg, int uid, String channelId) {
            return this.this$0.mPreferencesHelper.getGroupForChannel(pkg, uid, channelId);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void enqueueNotification(String pkg, String opPkg, int callingUid, int callingPid, String tag, int id, Notification notification, int userId) {
            this.this$0.enqueueNotificationInternal(pkg, opPkg, callingUid, callingPid, tag, id, notification, userId, false, true);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void enqueueNotification(String pkg, String opPkg, int callingUid, int callingPid, String tag, int id, Notification notification, int userId, boolean byForegroundService) {
            this.this$0.enqueueNotificationInternal(pkg, opPkg, callingUid, callingPid, tag, id, notification, userId, byForegroundService, true);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void cancelNotification(String pkg, String opPkg, int callingUid, int callingPid, String tag, int id, int userId) {
            if (this.this$0.isCallingUidSystem() == false) goto L5;
            int r0 = 0;
        L6:
            int mustNotHaveFlags = r0;
            this.this$0.cancelNotificationInternal(pkg, opPkg, callingUid, callingPid, tag, id, userId, mustNotHaveFlags);
            return;
        L5:
            r0 = 33856;
            goto L6
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public boolean isNotificationShown(String pkg, String tag, int notificationId, int userId) {
            return this.this$0.isNotificationShownInternal(pkg, tag, notificationId, userId);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void removeForegroundServiceFlagFromNotification(final String pkg, final int notificationId, final int userId) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mHandler.post(new NotificationManagerService$13$$ExternalSyntheticLambda1(this, pkg, notificationId, userId));
        }

        private /* synthetic */ void lambda$removeForegroundServiceFlagFromNotification$0(String pkg, int notificationId, int userId) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            removeFlagFromNotificationLocked(pkg, notificationId, userId, 64);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void removeUserInitiatedJobFlagFromNotification(final String pkg, final int notificationId, final int userId) {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            this.this$0.mHandler.post(new NotificationManagerService$13$$ExternalSyntheticLambda0(this, pkg, notificationId, userId));
        }

        private /* synthetic */ void lambda$removeUserInitiatedJobFlagFromNotification$1(String pkg, int notificationId, int userId) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            removeFlagFromNotificationLocked(pkg, notificationId, userId, 32768);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void removeFlagFromNotificationLocked(String pkg, int notificationId, int userId, int flag) {
            int count = NotificationManagerService.m6201$$Nest$mgetNotificationCount(this.this$0, pkg, userId);
            boolean removeFlagFromNotification = false;
            if (count <= 50) goto L6;
            this.this$0.mUsageStats.registerOverCountQuota(pkg);
            removeFlagFromNotification = true;
        L6:
            if (removeFlagFromNotification == false) goto L18;
            NotificationRecord r = this.this$0.findNotificationLocked(pkg, null, notificationId, userId);
            if (r != null) goto L10;
            return;
        L10:
            if (NotificationManagerService.DBG == true) goto L12;
        L16:
            NotificationManagerService.m6233$$Nest$mremoveFromNotificationListsLocked(this.this$0, r);
            this.this$0.cancelNotificationLocked(r, false, 8, true, null, SystemClock.elapsedRealtime());
            return;
        L12:
            if (flag != 64) goto L14;
            String type = "FGS";
        L15:
            Slog.d(NotificationManagerService.TAG, "Remove " + type + " flag not allow. Cancel " + type + " notification");
            goto L16
        L14:
            type = "UIJ";
            goto L15
        L18:
            List<NotificationRecord> enqueued = NotificationManagerService.m6249$$Nest$smfindNotificationsByListLocked(this.this$0.mEnqueuedNotifications, pkg, null, notificationId, userId);
            int i = 0;
        L20:
            if (i >= enqueued.size()) goto L25;
            NotificationRecord r2 = enqueued.get(i);
            if (r2 == null) goto L24;
            StatusBarNotification sbn = r2.getSbn();
            sbn.getNotification().flags = r2.getFlags() & (~flag);
        L24:
            i = i + 1;
            goto L20
        L25:
            NotificationRecord r3 = NotificationManagerService.m6248$$Nest$smfindNotificationByListLocked(this.this$0.mNotificationList, pkg, null, notificationId, userId);
            if (r3 == null) goto L32;
            StatusBarNotification sbn2 = r3.getSbn();
            sbn2.getNotification().flags = r3.getFlags() & (~flag);
            this.this$0.mRankingHelper.sort(this.this$0.mNotificationList);
            this.this$0.mListeners.notifyPostedLocked(r3, r3);
            return;
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void onConversationRemoved(String pkg, int uid, Set<String> shortcuts) {
            NotificationManagerService.m6227$$Nest$monConversationRemovedInternal(this.this$0, pkg, uid, shortcuts);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public int getNumNotificationChannelsForPackage(String pkg, int uid, boolean includeDeleted) {
            return this.this$0.getNumNotificationChannelsForPackage(pkg, uid, includeDeleted);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public boolean areNotificationsEnabledForPackage(String pkg, int uid) {
            return NotificationManagerService.m6178$$Nest$mareNotificationsEnabledForPackageInt(this.this$0, uid);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void sendReviewPermissionsNotification() {
            if (this.this$0.mShowReviewPermissionsNotification == true) goto L5;
            return;
        L5:
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            NotificationManager nm = (NotificationManager) this.this$0.getContext().getSystemService(NotificationManager.class);
            nm.notify(NotificationManagerService.TAG, 71, this.this$0.createReviewPermissionsNotification());
            Settings.Global.putInt(this.this$0.getContext().getContentResolver(), "review_permissions_notification_state", 3);
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void cleanupHistoryFiles() {
            NotificationManagerService.m6186$$Nest$mcheckCallerIsSystem(this.this$0);
            NotificationManagerService.m6141$$Nest$fgetmHistoryManager(this.this$0).cleanupHistoryFiles();
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void removeBitmaps() {
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            Iterator<NotificationRecord> r0 = this.this$0.mNotificationList.iterator();     // Catch: Throwable -> L10
        L6:
            if (r0.hasNext() == false) goto L17;
            NotificationRecord r = r0.next();     // Catch: Throwable -> L10
            long timePostedMs = r.getSbn().getPostTime();     // Catch: Throwable -> L10
            long timeNowMs = System.currentTimeMillis();     // Catch: Throwable -> L10
            if (NotificationManagerService.m6139$$Nest$fgetmFlagResolver(this.this$0).isEnabled(SystemUiSystemPropertiesFlags.NotificationFlags.DEBUG_SHORT_BITMAP_DURATION) == false) goto L12;
            long bitmapDuration = Duration.ofSeconds(5).toMillis();     // Catch: Throwable -> L10
        L14:
            if (NotificationManagerService.m6250$$Nest$smisBitmapExpired(timePostedMs, timeNowMs, bitmapDuration) == false) goto L6;
            NotificationManagerService.m6230$$Nest$mremoveBitmapAndRepost(this.this$0, r);     // Catch: Throwable -> L10
            goto L6
        L12:
            bitmapDuration = NotificationManagerService.BITMAP_DURATION.toMillis();     // Catch: Throwable -> L10
            goto L14
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void setDeviceEffectsApplier(DeviceEffectsApplier applier) {
            if (this.this$0.mZenModeHelper == null) goto L7;
            this.this$0.mZenModeHelper.setDeviceEffectsApplier(applier);
            return;
        L7:
            throw new IllegalStateException("ZenModeHelper is not yet ready!");
        }

        @Override // com.android.server.notification.NotificationManagerInternal
        public void onDisplayRemoveSystemDecorations(int displayId) {
            ArrayList<ToastRecord> r0 = this.this$0.mToastQueue;
            monitor-enter(r0);
            int i = this.this$0.mToastQueue.size() - 1;     // Catch: Throwable -> L9
        L5:
            if (i < 0) goto L13;
            ToastRecord toast = this.this$0.mToastQueue.get(i);     // Catch: Throwable -> L9
            if (toast.displayId != displayId) goto L11;
            this.this$0.cancelToastLocked(i);     // Catch: Throwable -> L9
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

        @Override // com.android.server.notification.NotificationManagerInternal
        public boolean isPkgAllNotificationSilent(String pkg, int uid) {
            return this.this$0.mPreferencesHelper.isPkgAllNotificationSilent(pkg, uid);
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$15, reason: invalid class name */
    class AnonymousClass15 implements Runnable {
        final /* synthetic */ NotificationManagerService this$0;
        final /* synthetic */ NotificationRecord val$r;

        AnonymousClass15(NotificationManagerService this$0, NotificationRecord r2) {
            this.this$0 = this$0;
            this.val$r = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).onNotificationRemoved(this.val$r);
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$16, reason: invalid class name */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ NotificationManagerService this$0;
        final /* synthetic */ int val$callingPid;
        final /* synthetic */ int val$callingUid;
        final /* synthetic */ long val$cancellationElapsedTimeMs;
        final /* synthetic */ String val$channelId;
        final /* synthetic */ int val$mustHaveFlags;
        final /* synthetic */ int val$mustNotHaveFlags;
        final /* synthetic */ String val$pkg;
        final /* synthetic */ int val$reason;
        final /* synthetic */ int val$userId;

        public static /* synthetic */ boolean $r8$lambda$BDn_OcdQo9vwfG5SuRuUE_RdIpc(int r0, int r1, int r2) {
            return lambda$run$0(r0, r1, r2);
        }

        AnonymousClass16(NotificationManagerService this$0, int r2, int r3, String r4, int r5, int r6, int r7, int r8, String r9, long r10) {
            this.this$0 = this$0;
            this.val$callingUid = r2;
            this.val$callingPid = r3;
            this.val$pkg = r4;
            this.val$userId = r5;
            this.val$mustHaveFlags = r6;
            this.val$mustNotHaveFlags = r7;
            this.val$reason = r8;
            this.val$channelId = r9;
            this.val$cancellationElapsedTimeMs = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            EventLogTags.writeNotificationCancelAll(this.val$callingUid, this.val$callingPid, this.val$pkg, this.val$userId, this.val$mustHaveFlags, this.val$mustNotHaveFlags, this.val$reason, null);
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            final int r0 = this.val$mustHaveFlags;     // Catch: Throwable -> L7
            final int r3 = this.val$mustNotHaveFlags;     // Catch: Throwable -> L7
            FlagChecker flagChecker = new NotificationManagerService$16$$ExternalSyntheticLambda0(r0, r3);     // Catch: Throwable -> L7
            NotificationManagerService.m6180$$Nest$mcancelAllNotificationsByListLocked(this.this$0, this.this$0.mNotificationList, this.val$pkg, true, this.val$channelId, flagChecker, false, this.val$userId, false, this.val$reason, null, true, this.val$cancellationElapsedTimeMs);     // Catch: Throwable -> L7
            NotificationManagerService.m6180$$Nest$mcancelAllNotificationsByListLocked(this.this$0, this.this$0.mEnqueuedNotifications, this.val$pkg, true, this.val$channelId, flagChecker, false, this.val$userId, false, this.val$reason, null, false, this.val$cancellationElapsedTimeMs);     // Catch: Throwable -> L7
            this.this$0.mSnoozeHelper.cancel(this.val$userId, this.val$pkg);     // Catch: Throwable -> L7
            monitor-exit(r2);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ boolean lambda$run$0(int mustHaveFlags, int mustNotHaveFlags, int flags) {
            if ((flags & mustHaveFlags) == mustHaveFlags) goto L6;
            return false;
        L6:
            if ((flags & mustNotHaveFlags) == 0) goto L8;
            return false;
        L8:
            return true;
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$17, reason: invalid class name */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ NotificationManagerService this$0;
        final /* synthetic */ int val$callingPid;
        final /* synthetic */ int val$callingUid;
        final /* synthetic */ long val$cancellationElapsedTimeMs;
        final /* synthetic */ boolean val$includeCurrentProfiles;
        final /* synthetic */ ManagedServices.ManagedServiceInfo val$listener;
        final /* synthetic */ int val$mustNotHaveFlags;
        final /* synthetic */ int val$reason;
        final /* synthetic */ int val$userId;

        public static /* synthetic */ boolean $r8$lambda$7xcXDOw4oRqp0sGOkb6DeyNjqYA(int r0, int r1, int r2) {
            return lambda$run$0(r0, r1, r2);
        }

        AnonymousClass17(NotificationManagerService this$0, ManagedServices.ManagedServiceInfo r2, int r3, int r4, int r5, int r6, int r7, boolean r8, long r9) {
            this.this$0 = this$0;
            this.val$listener = r2;
            this.val$callingUid = r3;
            this.val$callingPid = r4;
            this.val$userId = r5;
            this.val$reason = r6;
            this.val$mustNotHaveFlags = r7;
            this.val$includeCurrentProfiles = r8;
            this.val$cancellationElapsedTimeMs = r9;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.val$listener != null) goto L7;
            String r0 = null;
        L8:
            String listenerName = r0;
            EventLogTags.writeNotificationCancelAll(this.val$callingUid, this.val$callingPid, null, this.val$userId, 0, 0, this.val$reason, listenerName);     // Catch: Throwable -> L11
            final int r1 = this.val$mustNotHaveFlags;     // Catch: Throwable -> L11
            final int r3 = this.val$reason;     // Catch: Throwable -> L11
            FlagChecker flagChecker = new NotificationManagerService$17$$ExternalSyntheticLambda0(r1, r3);     // Catch: Throwable -> L11
            NotificationManagerService.m6180$$Nest$mcancelAllNotificationsByListLocked(this.this$0, this.this$0.mNotificationList, null, false, null, flagChecker, this.val$includeCurrentProfiles, this.val$userId, true, this.val$reason, listenerName, true, this.val$cancellationElapsedTimeMs);     // Catch: Throwable -> L11
            NotificationManagerService.m6180$$Nest$mcancelAllNotificationsByListLocked(this.this$0, this.this$0.mEnqueuedNotifications, null, false, null, flagChecker, this.val$includeCurrentProfiles, this.val$userId, true, this.val$reason, listenerName, false, this.val$cancellationElapsedTimeMs);     // Catch: Throwable -> L11
            this.this$0.mSnoozeHelper.cancel(this.val$userId, this.val$includeCurrentProfiles);     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return;
        L7:
            r0 = this.val$listener.component.toShortString();     // Catch: Throwable -> L11
            goto L8
        }

        private static /* synthetic */ boolean lambda$run$0(int mustNotHaveFlags, int reason, int flags) {
            int flagsToCheck = mustNotHaveFlags;
            if (11 != reason) goto L5;
        L6:
            flagsToCheck = flagsToCheck | 4096;
        L8:
            if ((flags & flagsToCheck) == 0) goto L11;
            return false;
        L11:
            return true;
        L5:
            if (3 != reason) goto L8;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$8, reason: invalid class name */
    class AnonymousClass8 extends ZenModeHelper.Callback {
        final /* synthetic */ NotificationManagerService this$0;

        public static /* synthetic */ void $r8$lambda$B3qtJtCTKLYZ9L6VodmNyD2yFFs(AnonymousClass8 r0) {
            r0.lambda$onZenModeChanged$0();
        }

        public static /* synthetic */ void $r8$lambda$CkzNIVR8Syb_8K5SrgKEkyahm7A(AnonymousClass8 r0, String r1, String r2, int r3, int r4) {
            r0.lambda$onAutomaticRuleStatusChanged$3(r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$JN40qwcAHvnSNa6DjudyrjjvMYY(AnonymousClass8 r0, NotificationManager.Policy r1) {
            r0.lambda$onConsolidatedPolicyChanged$2(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$g1YGMc-Sn6OF0jEQYrZuOAsZfYw, reason: not valid java name */
        public static /* synthetic */ void m6258$r8$lambda$g1YGMcSn6OF0jEQYrZuOAsZfYw(AnonymousClass8 r0, NotificationManager.Policy r1) {
            r0.lambda$onPolicyChanged$1(r1);
        }

        AnonymousClass8(NotificationManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.notification.ZenModeHelper.Callback
        public void onConfigChanged() {
            this.this$0.handleSavePolicyFile();
        }

        @Override // com.android.server.notification.ZenModeHelper.Callback
        void onZenModeChanged() {
            Binder.withCleanCallingIdentity(new NotificationManagerService$8$$ExternalSyntheticLambda2(this));
        }

        private /* synthetic */ void lambda$onZenModeChanged$0() throws Exception {
            NotificationManagerService.m6237$$Nest$msendRegisteredOnlyBroadcast(this.this$0, "android.app.action.INTERRUPTION_FILTER_CHANGED");
            this.this$0.getContext().sendBroadcastAsUser(new Intent("android.app.action.INTERRUPTION_FILTER_CHANGED_INTERNAL").addFlags(67108864), UserHandle.ALL, "android.permission.MANAGE_NOTIFICATIONS");
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationManagerService.m6241$$Nest$mupdateInterruptionFilterLocked(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.this$0.mRankingHandler.requestSort();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.ZenModeHelper.Callback
        void onPolicyChanged(final NotificationManager.Policy newPolicy) {
            Binder.withCleanCallingIdentity(new NotificationManagerService$8$$ExternalSyntheticLambda3(this, newPolicy));
        }

        private /* synthetic */ void lambda$onPolicyChanged$1(NotificationManager.Policy newPolicy) throws Exception {
            Intent intent = new Intent("android.app.action.NOTIFICATION_POLICY_CHANGED");
            intent.putExtra("android.app.extra.NOTIFICATION_POLICY", newPolicy);
            NotificationManagerService.m6236$$Nest$msendRegisteredOnlyBroadcast(this.this$0, intent);
            this.this$0.mRankingHandler.requestSort();
        }

        @Override // com.android.server.notification.ZenModeHelper.Callback
        void onConsolidatedPolicyChanged(final NotificationManager.Policy newConsolidatedPolicy) {
            Binder.withCleanCallingIdentity(new NotificationManagerService$8$$ExternalSyntheticLambda0(this, newConsolidatedPolicy));
        }

        private /* synthetic */ void lambda$onConsolidatedPolicyChanged$2(NotificationManager.Policy newConsolidatedPolicy) throws Exception {
            Intent intent = new Intent("android.app.action.CONSOLIDATED_NOTIFICATION_POLICY_CHANGED");
            intent.putExtra("android.app.extra.NOTIFICATION_POLICY", newConsolidatedPolicy);
            NotificationManagerService.m6236$$Nest$msendRegisteredOnlyBroadcast(this.this$0, intent);
            this.this$0.mRankingHandler.requestSort();
        }

        @Override // com.android.server.notification.ZenModeHelper.Callback
        void onAutomaticRuleStatusChanged(final int userId, final String pkg, final String id, final int status) {
            Binder.withCleanCallingIdentity(new NotificationManagerService$8$$ExternalSyntheticLambda1(this, pkg, id, status, userId));
        }

        private /* synthetic */ void lambda$onAutomaticRuleStatusChanged$3(String pkg, String id, int status, int userId) throws Exception {
            Intent intent = new Intent("android.app.action.AUTOMATIC_ZEN_RULE_STATUS_CHANGED");
            intent.setPackage(pkg);
            intent.putExtra("android.app.extra.AUTOMATIC_ZEN_RULE_ID", id);
            intent.putExtra("android.app.extra.AUTOMATIC_ZEN_RULE_STATUS", status);
            intent.addFlags(67108864);
            this.this$0.getContext().sendBroadcastAsUser(intent, UserHandle.of(userId));
        }
    }

    /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$9, reason: invalid class name */
    class AnonymousClass9 extends AppOpsManager.OnOpChangedInternalListener {
        final /* synthetic */ NotificationManagerService this$0;

        public static /* synthetic */ void $r8$lambda$Mvw5hsTJvkanS89R2phXe6JQS3Y(AnonymousClass9 r0, String r1, int r2) {
            r0.lambda$onOpChanged$0(r1, r2);
        }

        AnonymousClass9(NotificationManagerService this$0) {
            this.this$0 = this$0;
        }

        public void onOpChanged(String op, final String packageName, final int userId) {
            this.this$0.mHandler.post(new NotificationManagerService$9$$ExternalSyntheticLambda0(this, packageName, userId));
        }

        private /* synthetic */ void lambda$onOpChanged$0(String packageName, int userId) {
            NotificationManagerService.m6210$$Nest$mhandleNotificationPermissionChange(this.this$0, packageName, userId);
        }
    }

    static class Archive {
        final LinkedList<Pair<StatusBarNotification, Integer>> mBuffer;
        final Object mBufferLock;
        final int mBufferSize;
        final SparseArray<Boolean> mEnabled;

        public static /* synthetic */ void $r8$lambda$G8nwmgc5l2ypDxchBknpc76wcvs(UserManager r0, ArrayList r1) {
            lambda$getArray$0(r0, r1);
        }

        public Archive(int size) {
            this.mBufferLock = new Object();
            this.mBufferSize = size;
            this.mBuffer = new LinkedList();
            this.mEnabled = new SparseArray();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int N = this.mBuffer.size();
            sb.append("Archive (");
            sb.append(N);
            sb.append(" notification");
            if (N != 1) goto L5;
            String r2 = ")";
        L6:
            sb.append(r2);
            return sb.toString();
        L5:
            r2 = "s)";
            goto L6
        }

        public void record(StatusBarNotification sbn, int reason) {
            if (this.mEnabled.get(sbn.getNormalizedUserId(), false).booleanValue() == true) goto L5;
            return;
        L5:
            Object r0 = this.mBufferLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L8:
            if (this.mBuffer.size() != this.mBufferSize) goto L12;
            this.mBuffer.removeFirst();     // Catch: Throwable -> L10
        L12:
            this.mBuffer.addLast(new Pair(sbn.cloneLight(), Integer.valueOf(reason)));     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
        }

        public Iterator<Pair<StatusBarNotification, Integer>> descendingIterator() {
            return this.mBuffer.descendingIterator();
        }

        public StatusBarNotification[] getArray(final UserManager um, int count, boolean includeSnoozed) {
            final ArrayList<Integer> currentUsers = new ArrayList();
            currentUsers.add(-1);
            Binder.withCleanCallingIdentity(new NotificationManagerService$Archive$$ExternalSyntheticLambda0(um, currentUsers));
            Object r1 = this.mBufferLock;
            monitor-enter(r1);
            if (count == 0) goto L24;
        L8:
            List<StatusBarNotification> a = new ArrayList();     // Catch: Throwable -> L6
            Iterator<Pair<StatusBarNotification, Integer>> iter = descendingIterator();     // Catch: Throwable -> L6
            int i = 0;
        L10:
            if (iter.hasNext() == false) goto L19;
            if (i >= count) goto L19;
            Pair<StatusBarNotification, Integer> pair = iter.next();     // Catch: Throwable -> L6
            if (((Integer) pair.second).intValue() != 18) goto L16;
            if (includeSnoozed == false) goto L10;
        L16:
            if (currentUsers.contains(Integer.valueOf(((StatusBarNotification) pair.first).getUserId())) == false) goto L10;
            i = i + 1;     // Catch: Throwable -> L6
            a.add((StatusBarNotification) pair.first);     // Catch: Throwable -> L6
        L19:
            StatusBarNotification[] r5 = (StatusBarNotification[]) a.toArray(new StatusBarNotification[a.size()]);     // Catch: Throwable -> L6
            monitor-exit(r1);     // Catch: Throwable -> L6
            return r5;
        L6:
            th = move-exception;
            throw th;
        L24:
            count = this.mBufferSize;     // Catch: Throwable -> L6
            goto L8
        }

        private static /* synthetic */ void lambda$getArray$0(UserManager um, ArrayList currentUsers) throws Exception {
            int r1 = 0;
            int[] r0 = um.getProfileIds(ActivityManager.getCurrentUser(), false);
            int r2 = r0.length;
        L3:
            if (r1 >= r2) goto L5;
            int user = r0[r1];
            currentUsers.add(Integer.valueOf(user));
            r1 = r1 + 1;
            goto L3
        }

        public void updateHistoryEnabled(int userId, boolean enabled) {
            this.mEnabled.put(userId, Boolean.valueOf(enabled));
            if (enabled == true) goto L19;
            Object r0 = this.mBufferLock;
            monitor-enter(r0);
            int i = this.mBuffer.size() - 1;     // Catch: Throwable -> L11
        L7:
            if (i < 0) goto L15;
            if (userId != ((StatusBarNotification) this.mBuffer.get(i).first).getNormalizedUserId()) goto L13;
            this.mBuffer.remove(i);     // Catch: Throwable -> L11
        L13:
            i = i - 1;     // Catch: Throwable -> L11
            goto L7
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void removeChannelNotifications(String pkg, int userId, String channelId) {
            Object r0 = this.mBufferLock;
            monitor-enter(r0);
            Iterator<Pair<StatusBarNotification, Integer>> bufferIter = descendingIterator();     // Catch: Throwable -> L19
        L6:
            if (bufferIter.hasNext() == false) goto L23;
            Pair<StatusBarNotification, Integer> pair = bufferIter.next();     // Catch: Throwable -> L19
            if (pair.first == null) goto L6;
            if (userId != ((StatusBarNotification) pair.first).getNormalizedUserId()) goto L6;
            if (pkg == null) goto L6;
            if (pkg.equals(((StatusBarNotification) pair.first).getPackageName()) == false) goto L6;
            if (((StatusBarNotification) pair.first).getNotification() == null) goto L6;
            if (Objects.equals(channelId, ((StatusBarNotification) pair.first).getNotification().getChannelId()) == false) goto L6;
            bufferIter.remove();     // Catch: Throwable -> L19
            goto L6
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void removePackageNotifications(String pkg, int userId) {
            Object r0 = this.mBufferLock;
            monitor-enter(r0);
            Iterator<Pair<StatusBarNotification, Integer>> bufferIter = descendingIterator();     // Catch: Throwable -> L17
        L6:
            if (bufferIter.hasNext() == false) goto L21;
            Pair<StatusBarNotification, Integer> pair = bufferIter.next();     // Catch: Throwable -> L17
            if (pair.first == null) goto L6;
            if (userId != ((StatusBarNotification) pair.first).getNormalizedUserId()) goto L6;
            if (pkg == null) goto L6;
            if (pkg.equals(((StatusBarNotification) pair.first).getPackageName()) == false) goto L6;
            if (((StatusBarNotification) pair.first).getNotification() == null) goto L6;
            bufferIter.remove();     // Catch: Throwable -> L17
            goto L6
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        void dumpImpl(PrintWriter pw, DumpFilter filter) {
            Object r0 = this.mBufferLock;
            monitor-enter(r0);
            Iterator<Pair<StatusBarNotification, Integer>> iter = descendingIterator();     // Catch: Throwable -> L12
            int i = 0;
        L6:
            if (iter.hasNext() == false) goto L20;
            StatusBarNotification sbn = (StatusBarNotification) iter.next().first;     // Catch: Throwable -> L12
            if (filter == null) goto L14;
            if (filter.matches(sbn) == false) goto L6;
        L14:
            pw.println("    " + sbn);     // Catch: Throwable -> L12
            i = i + 1;     // Catch: Throwable -> L12
            if (i < 5) goto L6;
            if (iter.hasNext() == false) goto L20;
            pw.println("    ...");     // Catch: Throwable -> L12
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    protected class CancelNotificationRunnable implements Runnable {
        private final int mCallingPid;
        private final int mCallingUid;
        private final long mCancellationElapsedTimeMs;
        private final int mCount;
        private final int mId;
        private final ManagedServices.ManagedServiceInfo mListener;
        private final int mMustHaveFlags;
        private final int mMustNotHaveFlags;
        private final String mPkg;
        private final int mRank;
        private final int mReason;
        private final boolean mSendDelete;
        private final String mTag;
        private final int mUserId;
        final /* synthetic */ NotificationManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$JqwDe9ZkYXAqtt5oz-qopN18Czk, reason: not valid java name */
        public static /* synthetic */ boolean m6259$r8$lambda$JqwDe9ZkYXAqtt5ozqopN18Czk(CancelNotificationRunnable r0, int r1) {
            return r0.lambda$run$0(r1);
        }

        public static /* synthetic */ boolean $r8$lambda$kYFIDEcWoLAYUYKeGjvl50FfPbY(NotificationRecord r0, int r1, String r2, String r3) {
            return NotificationManagerService.m6251$$Nest$smisChildOfCurrentGroupChecker(r0, r1, r2, r3);
        }

        CancelNotificationRunnable(NotificationManagerService this$0, int callingUid, int callingPid, String pkg, String tag, int id, int mustHaveFlags, int mustNotHaveFlags, boolean sendDelete, int userId, int reason, int rank, int count, ManagedServices.ManagedServiceInfo listener, long cancellationElapsedTimeMs) {
            this.this$0 = this$0;
            this.mCallingUid = callingUid;
            this.mCallingPid = callingPid;
            this.mPkg = pkg;
            this.mTag = tag;
            this.mId = id;
            this.mMustHaveFlags = mustHaveFlags;
            this.mMustNotHaveFlags = mustNotHaveFlags;
            this.mSendDelete = sendDelete;
            this.mUserId = userId;
            this.mReason = reason;
            this.mRank = rank;
            this.mCount = count;
            this.mListener = listener;
            this.mCancellationElapsedTimeMs = cancellationElapsedTimeMs;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mListener != null) goto L5;
            String r0 = null;
        L6:
            String listenerName = r0;
            if (NotificationManagerService.DBG == false) goto L9;
            EventLogTags.writeNotificationCancel(this.mCallingUid, this.mCallingPid, this.mPkg, this.mId, this.mTag, this.mUserId, this.mMustHaveFlags, this.mMustNotHaveFlags, this.mReason, listenerName);
            String listenerName2 = listenerName;
        L10:
            int packageImportance = NotificationManagerService.m6202$$Nest$mgetPackageImportanceWithIdentity(this.this$0, this.mPkg);
            Object r12 = this.this$0.mNotificationLock;
            monitor-enter(r12);
            NotificationRecord r = this.this$0.findNotificationLocked(this.mPkg, this.mTag, this.mId, this.mUserId);     // Catch: Throwable -> L64
            if (r != null) goto L16;
            Object r17 = r12;
            NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).maybeCancelGroupChildrenForCanceledSummary(this.mPkg, this.mTag, this.mId, this.mUserId, this.mReason);     // Catch: Throwable -> L70
            if (this.mReason == 18) goto L78;
            boolean wasSnoozed = this.this$0.mSnoozeHelper.cancel(this.mUserId, this.mPkg, this.mTag, this.mId);     // Catch: Throwable -> L70
            if (wasSnoozed == false) goto L78;
            this.this$0.handleSavePolicyFile();     // Catch: Throwable -> L70
        L78:
            monitor-exit(r17);     // Catch: Throwable -> L70
            return;
        L16:
            if (this.mReason != 1) goto L23;
            this.this$0.mUsageStats.registerClickedByUser(r);     // Catch: Throwable -> L19
        L19:
            th = th;
            r17 = r12;
        L80:
            monitor-exit(r17);     // Catch: Throwable -> L70
            throw th;
        L23:
            if (this.mReason != 10) goto L27;
            if (r.getNotification().isBubbleNotification() == false) goto L27;
        L32:
            int flags = 0;
            if (r.getNotification().getBubbleMetadata() == null) goto L35;
            flags = r.getNotification().getBubbleMetadata().getFlags();     // Catch: Throwable -> L19
        L35:
            this.this$0.mNotificationDelegate.onBubbleMetadataFlagChanged(r.getKey(), flags | 2);     // Catch: Throwable -> L19
            monitor-exit(r12);     // Catch: Throwable -> L19
            return;
        L27:
            if (this.mReason != 1) goto L39;
            if (r.canBubble() == false) goto L39;
            if (r.isFlagBubbleRemoved() == true) goto L32;
        L39:
            if ((r.getNotification().flags & this.mMustHaveFlags) == this.mMustHaveFlags) goto L44;
            monitor-exit(r12);     // Catch: Throwable -> L19
            return;
        L44:
            if ((r.getNotification().flags & this.mMustNotHaveFlags) == 0) goto L48;
            NotificationManagerService.m6225$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedLocked(this.this$0, r, this.mPkg, packageImportance);     // Catch: Throwable -> L19
            monitor-exit(r12);     // Catch: Throwable -> L19
            return;
        L48:
            FlagChecker childrenFlagChecker = new NotificationManagerService$CancelNotificationRunnable$$ExternalSyntheticLambda0(this);     // Catch: Throwable -> L64
            boolean wasPosted = NotificationManagerService.m6233$$Nest$mremoveFromNotificationListsLocked(this.this$0, r);     // Catch: Throwable -> L64
            NotificationManagerService.m6182$$Nest$mcancelNotificationLocked(this.this$0, r, this.mSendDelete, this.mReason, this.mRank, this.mCount, wasPosted, listenerName2, this.mCancellationElapsedTimeMs);     // Catch: Throwable -> L64
            if (r.getNotification().isGroupSummary() == false) goto L66;
            r17 = r12;
            NotificationRecord r2 = r;
            boolean r15 = true;
            NotificationManagerService.m6181$$Nest$mcancelGroupChildrenLocked(this.this$0, this.mUserId, this.mPkg, this.mCallingUid, this.mCallingPid, listenerName2, this.mSendDelete, childrenFlagChecker, new NotificationManagerService$CancelNotificationRunnable$$ExternalSyntheticLambda1(), r.getGroupKey(), this.mReason, this.mCancellationElapsedTimeMs);     // Catch: Throwable -> L58
        L67:
            this.this$0.mAttentionHelper.updateLightsLocked();     // Catch: Throwable -> L70
            if (NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0) == null) goto L78;
            NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0).maybeListenForShortcutChangesForBubbles(r2, r15);     // Catch: Throwable -> L70
        L58:
            th = th;
        L60:
            th = th;
        L62:
            th = th;
            r17 = r12;
            goto L80
        L66:
            r2 = r;
            r17 = r12;
            r15 = true;
        L64:
            th = th;
            r17 = r12;
        L70:
            th = th;
            goto L80
        L9:
            listenerName2 = listenerName;
            goto L10
        L5:
            r0 = this.mListener.component.toShortString();
            goto L6
        }

        private /* synthetic */ boolean lambda$run$0(int flags) {
            if (this.mReason == 2) goto L17;
            if (this.mReason == 1) goto L17;
            if (this.mReason == 3) goto L17;
            if (this.mReason != 8) goto L20;
            if ((flags & 64) == 0) goto L14;
        L15:
            return false;
        L14:
            if ((32768 & flags) != 0) goto L15;
        L20:
            if ((this.mMustNotHaveFlags & flags) == 0) goto L22;
            return false;
        L22:
            return true;
        L17:
            if ((flags & 4096) == 0) goto L20;
            return false;
        }
    }

    public static final class DumpFilter {
        public boolean criticalPriority;
        public boolean filtered;
        public boolean normalPriority;
        public String pkgFilter;
        public boolean proto;
        public boolean redact;
        public boolean rvStats;
        public long since;
        public boolean stats;
        public boolean zen;

        public DumpFilter() {
            this.filtered = false;
            this.redact = true;
            this.proto = false;
            this.criticalPriority = false;
            this.normalPriority = false;
        }

        public static DumpFilter parseFromArguments(String[] args) {
            DumpFilter filter = new DumpFilter();
            int ai = 0;
        L4:
            if (ai >= args.length) goto L65;
            String a = args[ai];
            if ("--proto".equals(a) == false) goto L8;
            filter.proto = true;
        L63:
            ai = ai + 1;
            goto L4
        L8:
            byte r5 = 0;
            if ("--noredact".equals(a) == false) goto L11;
        L62:
            filter.redact = false;
            goto L63
        L11:
            if ("--reveal".equals(a) == true) goto L62;
            if ("p".equals(a) == true) goto L57;
            if (SceneUtils.KEY_PKG.equals(a) == true) goto L57;
            if ("--package".equals(a) == true) goto L57;
            if ("--zen".equals(a) == false) goto L23;
        L55:
            filter.filtered = true;
            filter.zen = true;
            goto L63
        L23:
            if ("zen".equals(a) == true) goto L55;
            if ("--stats".equals(a) == false) goto L32;
            filter.stats = true;
            if (ai >= (args.length - 1)) goto L30;
            ai = ai + 1;
            filter.since = Long.parseLong(args[ai]);
            goto L63
        L30:
            filter.since = 0;
            goto L63
        L32:
            if ("--remote-view-stats".equals(a) == false) goto L38;
            filter.rvStats = true;
            if (ai >= (args.length - 1)) goto L36;
            ai = ai + 1;
            filter.since = Long.parseLong(args[ai]);
            goto L63
        L36:
            filter.since = 0;
            goto L63
        L38:
            if (PriorityDump.PRIORITY_ARG.equals(a) == false) goto L63;
            if (ai >= (args.length - 1)) goto L63;
            ai = ai + 1;
            String r3 = args[ai];
            switch(r3.hashCode()) {
                case -1986416409: goto L48;
                case -1560189025: goto L45;
                default: goto L50;
            };
        L50:
            r5 = -1;
        L51:
            switch(r5) {
                case 0: goto L54;
                case 1: goto L53;
                default: goto L63;
            };
        L53:
            filter.normalPriority = true;
            goto L63
        L54:
            filter.criticalPriority = true;
            goto L63
        L45:
            if (r3.equals(PriorityDump.PRIORITY_ARG_CRITICAL) == false) goto L50;
        L48:
            if (r3.equals(PriorityDump.PRIORITY_ARG_NORMAL) == false) goto L50;
            r5 = 1;
        L57:
            if (ai >= (args.length - 1)) goto L63;
            ai = ai + 1;
            filter.pkgFilter = args[ai].trim().toLowerCase();
            if (filter.pkgFilter.isEmpty() == false) goto L61;
            filter.pkgFilter = null;
            goto L63
        L61:
            filter.filtered = true;
            goto L63
        L65:
            return filter;
        }

        public boolean matches(StatusBarNotification sbn) {
            if (this.filtered == true) goto L6;
            return true;
        L6:
            if (this.zen == true) goto L16;
            if (sbn != null) goto L10;
        L14:
            return false;
        L10:
            if (matches(sbn.getPackageName()) == false) goto L12;
            return true;
        L12:
            if (matches(sbn.getOpPkg()) == false) goto L14;
            return true;
        L16:
            return true;
        }

        public boolean matches(ComponentName component) {
            if (this.filtered == true) goto L6;
            return true;
        L6:
            if (this.zen == true) goto L14;
            if (component != null) goto L10;
        L12:
            return false;
        L10:
            if (matches(component.getPackageName()) == false) goto L12;
            return true;
        L14:
            return true;
        }

        public boolean matches(String pkg) {
            if (this.filtered == true) goto L6;
            return true;
        L6:
            if (this.zen == true) goto L14;
            if (pkg != null) goto L10;
        L12:
            return false;
        L10:
            if (pkg.toLowerCase().contains(this.pkgFilter) == false) goto L12;
            return true;
        L14:
            return true;
        }

        public String toString() {
            if (this.stats == false) goto L6;
            return "stats";
        L6:
            if (this.zen == false) goto L9;
            return "zen";
        L9:
            return '\'' + this.pkgFilter + '\'';
        }
    }

    protected class EnqueueNotificationRunnable implements Runnable {
        private final boolean isAppForeground;
        private final boolean isAppProvided;
        private final PostNotificationTracker mTracker;
        private final NotificationRecord r;
        final /* synthetic */ NotificationManagerService this$0;
        private final int userId;

        EnqueueNotificationRunnable(NotificationManagerService this$0, int userId, NotificationRecord r, boolean foreground, boolean isAppProvided, PostNotificationTracker tracker) {
            this.this$0 = this$0;
            this.userId = userId;
            this.r = r;
            this.isAppForeground = foreground;
            this.isAppProvided = isAppProvided;
            this.mTracker = (PostNotificationTracker) Preconditions.checkNotNull(tracker);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean enqueued = enqueueNotification();     // Catch: Throwable -> L7
            if (enqueued == true) goto L13;
            this.mTracker.cancel();
            return;
        L13:
            return;
        L7:
            th = move-exception;
            if (0 != 0) goto L10;
            this.mTracker.cancel();
        L10:
            throw th;
        }

        private boolean enqueueNotification() {
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            this.r.getNotification().overrideAllowlistToken(NotificationManagerService.ALLOWLIST_TOKEN);     // Catch: Throwable -> L9
            long snoozeAt = this.this$0.mSnoozeHelper.getSnoozeTimeForUnpostedNotification(this.r.getUser().getIdentifier(), this.r.getSbn().getPackageName(), this.r.getSbn().getKey()).longValue();     // Catch: Throwable -> L9
            long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L9
            if (snoozeAt <= currentTime) goto L11;
            new SnoozeNotificationRunnable(this.this$0, this.r.getSbn().getKey(), snoozeAt - currentTime, null).snoozeLocked(this.r);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            return false;
        L11:
            String contextId = this.this$0.mSnoozeHelper.getSnoozeContextForUnpostedNotification(this.r.getUser().getIdentifier(), this.r.getSbn().getPackageName(), this.r.getSbn().getKey());     // Catch: Throwable -> L9
            if (contextId == null) goto L16;
            new SnoozeNotificationRunnable(this.this$0, this.r.getSbn().getKey(), 0, contextId).snoozeLocked(this.r);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            return false;
        L16:
            this.this$0.mEnqueuedNotifications.add(this.r);     // Catch: Throwable -> L9
            NotificationManagerService.m6165$$Nest$fgetmTtlHelper(this.this$0).scheduleTimeoutLocked(this.r, SystemClock.elapsedRealtime());     // Catch: Throwable -> L9
            StatusBarNotification n = this.r.getSbn();     // Catch: Throwable -> L9
            if (NotificationManagerService.DBG == false) goto L19;
            Slog.d(NotificationManagerService.TAG, "EnqueueNotificationRunnable.run for: " + n.getKey());     // Catch: Throwable -> L9
        L19:
            NotificationRecord old = this.this$0.mNotificationsByKey.get(n.getKey());     // Catch: Throwable -> L9
            if (old == null) goto L22;
            this.r.copyRankingInformation(old);     // Catch: Throwable -> L9
        L22:
            int callingUid = n.getUid();     // Catch: Throwable -> L9
            int callingPid = n.getInitialPid();     // Catch: Throwable -> L9
            Notification notification = n.getNotification();     // Catch: Throwable -> L9
            String pkg = n.getPackageName();     // Catch: Throwable -> L9
            int id = n.getId();     // Catch: Throwable -> L9
            String tag = n.getTag();     // Catch: Throwable -> L9
            NotificationManagerService.m6243$$Nest$mupdateNotificationBubbleFlags(this.this$0, this.r, this.isAppForeground);     // Catch: Throwable -> L9
            NotificationManagerService.m6206$$Nest$mhandleGroupedNotificationLocked(this.this$0, this.r, old, callingUid, callingPid);     // Catch: Throwable -> L9
            if (n.isGroup() == false) goto L28;
            if (notification.isGroupChild() == false) goto L28;
            this.this$0.mSnoozeHelper.repostGroupSummary(pkg, this.r.getUserId(), n.getGroupKey());     // Catch: Throwable -> L9
        L28:
            if (pkg.equals("com.android.providers.downloads") == false) goto L34;
            if (Log.isLoggable("DownloadManager", 2) == true) goto L34;
        L43:
            if (this.this$0.mAssistants.isEnabled() == false) goto L45;
            NotificationAssistants.m6265$$Nest$monNotificationEnqueuedLocked(this.this$0.mAssistants, this.r);     // Catch: Throwable -> L9
            boolean r19 = true;
            this.this$0.mHandler.postDelayed(new PostNotificationRunnable(this.this$0, this.r.getKey(), this.r.getSbn().getPackageName(), this.r.getUid(), this.mTracker), NotificationManagerService.DELAY_FOR_ASSISTANT_TIME);     // Catch: Throwable -> L9
        L46:
            monitor-exit(r2);     // Catch: Throwable -> L9
            return r19;
        L45:
            r19 = true;
            this.this$0.mHandler.post(new PostNotificationRunnable(this.this$0, this.r.getKey(), this.r.getSbn().getPackageName(), this.r.getUid(), this.mTracker));     // Catch: Throwable -> L9
        L34:
            if (old == null) goto L36;
            int enqueueStatus = 1;
        L38:
            if (this.isAppProvided == false) goto L40;
            int appProvided = 1;
        L41:
            EventLogTags.writeNotificationEnqueue(callingUid, callingPid, pkg, id, tag, this.userId, notification.toString(), enqueueStatus, appProvided);     // Catch: Throwable -> L9
            goto L43
        L40:
            appProvided = 0;
            goto L41
        L36:
            enqueueStatus = 0;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private interface FlagChecker {
        boolean apply(int r1);
    }

    @FunctionalInterface
    private interface GroupChildChecker {
        boolean apply(NotificationRecord r1, int r2, String r3, String r4);
    }

    public class NotificationAssistants extends ManagedServices {
        private static final String ATT_DENIED_KEY = "key";
        private static final String ATT_DENIED_KEY_APPS = "denied_apps";
        private static final String ATT_NAS_UNSUPPORTED = "unsupported_adjustments";
        private static final String ATT_TYPES = "types";
        private static final String TAG_DENIED = "user_denied_adjustments";
        private static final String TAG_DENIED_KEY = "adjustment";
        static final String TAG_ENABLED_NOTIFICATION_ASSISTANTS = "enabled_assistants";
        private static final String TAG_ENABLED_TYPES = "enabled_classification_types";
        private Map<String, Set<String>> mAdjustmentKeyDeniedPackages;
        private Set<String> mAllowedAdjustments;
        private Set<Integer> mAllowedClassificationTypes;
        protected ComponentName mDefaultFromConfig;
        private Set<String> mDeniedAdjustments;
        private final Object mLock;
        private Map<Integer, HashSet<String>> mNasUnsupported;
        final /* synthetic */ NotificationManagerService this$0;

        public static /* synthetic */ void $r8$lambda$5vL6yJfer7Zdx2EbcgYtsQLHhBA(NotificationAssistants r0, String r1, boolean r2, boolean r3, INotificationListener r4, StatusBarNotification r5) {
            r0.lambda$notifyAssistantExpansionChangedLocked$4(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: $r8$lambda$Ee7CaSIdQ6RZAi0O2_hzQW-5MTE, reason: not valid java name */
        public static /* synthetic */ void m6260$r8$lambda$Ee7CaSIdQ6RZAi0O2_hzQW5MTE(NotificationAssistants r0, String r1, INotificationListener r2, StatusBarNotification r3) {
            r0.lambda$notifyAssistantNotificationDirectReplyLocked$5(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$Ew6032arg6YYkbIZxTH_wu2-PH4, reason: not valid java name */
        public static /* synthetic */ void m6261$r8$lambda$Ew6032arg6YYkbIZxTH_wu2PH4(BiConsumer r0, INotificationListener r1, StatusBarNotification r2) {
            lambda$notifyAssistantLocked$10(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$ITkgMmj84OpUm9GlVdhPrTueLi4(NotificationAssistants r0, ManagedServices.ManagedServiceInfo r1, ArrayList r2) {
            r0.lambda$onNotificationsSeenLocked$0(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$IaZN9bpRjPnBphyi8VMl-aCgDCc, reason: not valid java name */
        public static /* synthetic */ void m6262$r8$lambda$IaZN9bpRjPnBphyi8VMlaCgDCc(NotificationAssistants r0, String r1, Notification.Action r2, boolean r3, INotificationListener r4, StatusBarNotification r5) {
            r0.lambda$notifyAssistantActionClicked$7(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$JaP2g16OT1H17pGrOy_OzDklhPs(NotificationAssistants r0, ManagedServices.ManagedServiceInfo r1, int r2) {
            r0.lambda$onPanelRevealed$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$aECXYnUCR0b92CL_vudQbpnY8y0(NotificationAssistants r0, ManagedServices.ManagedServiceInfo r1) {
            r0.lambda$disallowAdjustmentType$12(r1);
        }

        public static /* synthetic */ void $r8$lambda$cJbcAalcJTPB4ZWuiwdWGms0pP0(NotificationAssistants r0, String r1, INotificationListener r2, StatusBarNotification r3) {
            r0.lambda$notifyAssistantNotificationClicked$9(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$cr2bUV1rlb8Y6czZsCx7TdSE7P8(NotificationAssistants r0, String r1, boolean r2, INotificationListener r3, StatusBarNotification r4) {
            r0.lambda$notifyAssistantVisibilityChangedLocked$3(r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$egp56sRA3DO2m7RoRfiB32DPib8(NotificationAssistants r0, String r1, INotificationListener r2, StatusBarNotification r3) {
            r0.lambda$notifyAssistantSnoozedLocked$8(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$ktC3e8dmg0Hz37lGdFdzA1P73kQ(NotificationAssistants r0, ManagedServices.ManagedServiceInfo r1) {
            r0.lambda$allowAdjustmentType$11(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$qswTSiOPe4q3U5Q1-LevM3uWdzY, reason: not valid java name */
        public static /* synthetic */ void m6263$r8$lambda$qswTSiOPe4q3U5Q1LevM3uWdzY(NotificationAssistants r0, ManagedServices.ManagedServiceInfo r1) {
            r0.lambda$onPanelHidden$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$rxiPtFLD6dJzRx_3jr0h1oCyUks(NotificationAssistants r0, String r1, CharSequence r2, boolean r3, INotificationListener r4, StatusBarNotification r5) {
            r0.lambda$notifyAssistantSuggestedReplySent$6(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyAssistantSnoozedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6264$$Nest$mnotifyAssistantSnoozedLocked(NotificationAssistants r0, NotificationRecord r1, String r2) {
            r0.notifyAssistantSnoozedLocked(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$monNotificationEnqueuedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6265$$Nest$monNotificationEnqueuedLocked(NotificationAssistants r0, NotificationRecord r1) {
            r0.onNotificationEnqueuedLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetNasUnsupportedDefaults, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6266$$Nest$msetNasUnsupportedDefaults(NotificationAssistants r0, int r1) {
            r0.setNasUnsupportedDefaults(r1);
        }

        @Override // com.android.server.notification.ManagedServices
        protected void loadDefaultsFromConfig() {
            loadDefaultsFromConfig(true);
        }

        protected void loadDefaultsFromConfig(boolean addToDefault) {
            ArraySet<String> assistants = new ArraySet();
            assistants.addAll(Arrays.asList(this.mContext.getResources().getString(R.string.config_deviceProvisioningPackage).split(":")));
            int i = 0;
        L4:
            if (i >= assistants.size()) goto L18;
            ComponentName assistantCn = ComponentName.unflattenFromString(assistants.valueAt(i));
            String packageName = assistants.valueAt(i);
            if (assistantCn == null) goto L9;
            packageName = assistantCn.getPackageName();
        L9:
            if (TextUtils.isEmpty(packageName) == true) goto L16;
            ArraySet<ComponentName> approved = queryPackageForServices(packageName, 786432, 0);
            if (approved.contains(assistantCn) == false) goto L16;
            if (addToDefault == false) goto L15;
            addDefaultComponentOrPackage(assistantCn.flattenToString());
            goto L16
        L15:
            this.mDefaultFromConfig = assistantCn;
        L16:
            i = i + 1;
            goto L4
        }

        ComponentName getDefaultFromConfig() {
            if (this.mDefaultFromConfig != null) goto L6;
            loadDefaultsFromConfig(false);
        L6:
            return this.mDefaultFromConfig;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void upgradeUserSet() {
            Iterator<Integer> r0 = this.mApproved.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            int userId = r0.next().intValue();
            ArraySet<String> userSetServices = this.mUserSetServices.get(Integer.valueOf(userId));
            ArrayMap<Integer, Boolean> r3 = this.mIsUserChanged;
            Integer r4 = Integer.valueOf(userId);
            if (userSetServices != null) goto L8;
        L10:
            boolean r5 = false;
        L11:
            r3.put(r4, Boolean.valueOf(r5));
            goto L4
        L8:
            if (userSetServices.size() <= 0) goto L10;
            r5 = true;
            goto L11
        }

        @Override // com.android.server.notification.ManagedServices
        protected void addApprovedList(String approved, int userId, boolean isPrimary, String userSet) {
            if (TextUtils.isEmpty(approved) == true) goto L7;
            String[] approvedArray = approved.split(":");
            if (approvedArray.length <= 1) goto L7;
            Slog.d(this.TAG, "More than one approved assistants");
            approved = approvedArray[0];
        L7:
            super.addApprovedList(approved, userId, isPrimary, userSet);
        }

        public NotificationAssistants(NotificationManagerService this$0, Context context, Object lock, ManagedServices.UserProfiles up, IPackageManager pm) {
            this.this$0 = this$0;
            super(context, lock, up, pm);
            this.mLock = new Object();
            this.mAllowedClassificationTypes = new ArraySet();
            this.mAllowedAdjustments = new ArraySet();
            this.mDeniedAdjustments = new ArraySet();
            this.mNasUnsupported = new ArrayMap();
            this.mAdjustmentKeyDeniedPackages = new ArrayMap();
            this.mDefaultFromConfig = null;
            this.mAllowedClassificationTypes.addAll(List.of(NotificationManagerService.DEFAULT_ALLOWED_ADJUSTMENT_KEY_TYPES));
        }

        @Override // com.android.server.notification.ManagedServices
        protected ManagedServices.Config getConfig() {
            ManagedServices.Config c = new ManagedServices.Config();
            c.caption = "notification assistant";
            c.serviceInterface = "android.service.notification.NotificationAssistantService";
            c.xmlTag = TAG_ENABLED_NOTIFICATION_ASSISTANTS;
            c.secureSettingName = "enabled_notification_assistant";
            c.bindPermission = "android.permission.BIND_NOTIFICATION_ASSISTANT_SERVICE";
            c.settingsAction = "android.settings.MANAGE_DEFAULT_APPS_SETTINGS";
            c.clientLabel = R.string.permdesc_runInBackground;
            return c;
        }

        @Override // com.android.server.notification.ManagedServices
        protected IInterface asInterface(IBinder binder) {
            return INotificationListener.Stub.asInterface(binder);
        }

        @Override // com.android.server.notification.ManagedServices
        protected boolean checkType(IInterface service) {
            return service instanceof INotificationListener;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void onServiceAdded(ManagedServices.ManagedServiceInfo info) {
            this.this$0.mListeners.registerGuestService(info);
        }

        @Override // com.android.server.notification.ManagedServices
        protected void ensureFilters(ServiceInfo si, int userId) {
        }

        @Override // com.android.server.notification.ManagedServices
        protected void onServiceRemovedLocked(ManagedServices.ManagedServiceInfo removed) {
            this.this$0.mListeners.unregisterService(removed.service, removed.userid);
        }

        @Override // com.android.server.notification.ManagedServices
        public void onUserUnlocked(int user) {
            if (this.DEBUG == false) goto L5;
            Slog.d(this.TAG, "onUserUnlocked u=" + user);
        L5:
            rebindServices(true, user);
        }

        @Override // com.android.server.notification.ManagedServices
        protected boolean allowRebindForParentUser() {
            return false;
        }

        @Override // com.android.server.notification.ManagedServices
        protected String getRequiredPermission() {
            return "android.permission.REQUEST_NOTIFICATION_ASSISTANT_SERVICE";
        }

        protected Set<String> getAllowedAssistantAdjustments() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Set<String> types = new HashSet(Set.of(NotificationManagerService.DEFAULT_ALLOWED_ADJUSTMENTS));     // Catch: Throwable -> L7
            types.removeAll(this.mDeniedAdjustments);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return types;
        L7:
            th = move-exception;
            throw th;
        }

        protected boolean isAdjustmentAllowed(String type) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (List.of(NotificationManagerService.DEFAULT_ALLOWED_ADJUSTMENTS).contains(type) == true) goto L7;
        L11:
            boolean r1 = false;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L7:
            if (this.mDeniedAdjustments.contains(type) == true) goto L11;
            r1 = true;
            goto L12
        }

        protected boolean isAdjustmentKeyTypeAllowed(int type) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r1 = this.mAllowedClassificationTypes.contains(Integer.valueOf(type));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        protected int[] getAllowedClassificationTypes() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int[] r1 = this.mAllowedClassificationTypes.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setAssistantAdjustmentKeyTypeState(int type, boolean enabled) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            if (enabled == false) goto L8;
            this.mAllowedClassificationTypes.add(Integer.valueOf(type));     // Catch: Throwable -> L6
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L8:
            this.mAllowedClassificationTypes.remove(Integer.valueOf(type));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        protected String[] getAdjustmentDeniedPackages(String key) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            monitor-exit(r0);     // Catch: Throwable -> L7
            return new String[0];
        L7:
            th = move-exception;
            throw th;
        }

        protected boolean isAdjustmentAllowedForPackage(String key, String pkg) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            monitor-exit(r0);     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            throw th;
        }

        public void setAdjustmentSupportedForPackage(String key, String pkg, boolean enabled) {
        }

        protected void onNotificationsSeenLocked(ArrayList<NotificationRecord> records) {
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L22;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            final ArrayList<String> keys = new ArrayList(records.size());
            Iterator<NotificationRecord> r3 = records.iterator();
        L7:
            if (r3.hasNext() == false) goto L19;
            NotificationRecord r = r3.next();
            if (this.this$0.isVisibleToListener(r.getSbn(), r.getNotificationType(), info) == true) goto L11;
        L13:
            boolean sbnVisible = false;
        L15:
            if (sbnVisible == false) goto L7;
            keys.add(r.getKey());
            goto L7
        L11:
            if (info.isSameUser(r.getUserId()) == false) goto L13;
            sbnVisible = true;
            goto L15
        L19:
            if (keys.isEmpty() == true) goto L4;
            this.this$0.mHandler.post(new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda10(this, info, keys));
            goto L4
        }

        private /* synthetic */ void lambda$onNotificationsSeenLocked$0(ManagedServices.ManagedServiceInfo info, ArrayList keys) {
            notifySeen(info, keys);
        }

        protected void onPanelRevealed(final int items) {
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            this.this$0.mHandler.post(new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda11(this, info, items));
            goto L4
        }

        private /* synthetic */ void lambda$onPanelRevealed$1(ManagedServices.ManagedServiceInfo info, int items) {
            INotificationListener assistant = info.service;
            assistant.onPanelRevealed(items);     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (panel revealed): " + info, ex);
        }

        protected void onPanelHidden() {
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            this.this$0.mHandler.post(new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda5(this, info));
            goto L4
        }

        private /* synthetic */ void lambda$onPanelHidden$2(ManagedServices.ManagedServiceInfo info) {
            INotificationListener assistant = info.service;
            assistant.onPanelHidden();     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (panel hidden): " + info, ex);
        }

        boolean hasUserSet(int userId) {
            Boolean userSet = this.mIsUserChanged.get(Integer.valueOf(userId));
            if (userSet != null) goto L5;
        L7:
            return false;
        L5:
            if (userSet.booleanValue() == false) goto L7;
            return true;
        }

        void setUserSet(int userId, boolean set) {
            this.mIsUserChanged.put(Integer.valueOf(userId), Boolean.valueOf(set));
        }

        private void notifySeen(ManagedServices.ManagedServiceInfo info, ArrayList<String> keys) {
            INotificationListener assistant = info.service;
            assistant.onNotificationsSeen(keys);     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (seen): " + info, ex);
        }

        private void onNotificationEnqueuedLocked(NotificationRecord r) {
            boolean debug = isVerboseLogEnabled();
            if (debug == false) goto L5;
            Slog.v(this.TAG, "onNotificationEnqueuedLocked() called with: r = [" + r + "]");
        L5:
            StatusBarNotification sbn = r.getSbn();
            Iterator<ManagedServices.ManagedServiceInfo> r3 = getServices().iterator();
        L7:
            if (r3.hasNext() == false) goto L26;
            ManagedServices.ManagedServiceInfo info = r3.next();
            if (this.this$0.isVisibleToListener(sbn, r.getNotificationType(), info) == true) goto L11;
        L13:
            boolean sbnVisible = false;
        L15:
            if (sbnVisible == false) goto L7;
            TrimCache trimCache = new TrimCache(this.this$0, sbn);
            INotificationListener assistant = info.service;
            StatusBarNotification sbnToPost = trimCache.ForListener(info);
            NotificationRankingUpdate update = this.this$0.makeRankingUpdateLocked(info);
            StatusBarNotificationHolder sbnHolder = new StatusBarNotificationHolder(sbnToPost);     // Catch: RemoteException -> L19 DeadObjectException -> L21
            assistant.onNotificationEnqueuedWithChannel(sbnHolder, r.getChannel(), update);     // Catch: RemoteException -> L19 DeadObjectException -> L21
        L21:
            ex = move-exception;
            Slog.wtf(this.TAG, "unable to notify assistant (enqueued): " + info, ex);
        L19:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (enqueued): " + info, ex);
            goto L7
        L11:
            if (info.isSameUser(r.getUserId()) == false) goto L13;
            sbnVisible = true;
            goto L15
        }

        void notifyAssistantVisibilityChangedLocked(NotificationRecord r, final boolean isVisible) {
            final String key = r.getSbn().getKey();
            if (NotificationManagerService.DBG == false) goto L5;
            Slog.d(this.TAG, "notifyAssistantVisibilityChangedLocked: " + key);
        L5:
            notifyAssistantLocked(r.getSbn(), r.getNotificationType(), true, new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda6(this, key, isVisible));
        }

        private /* synthetic */ void lambda$notifyAssistantVisibilityChangedLocked$3(String key, boolean isVisible, INotificationListener assistant, StatusBarNotification unused) {
            assistant.onNotificationVisibilityChanged(key, isVisible);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (visible): " + assistant, ex);
        }

        void notifyAssistantExpansionChangedLocked(StatusBarNotification sbn, int notificationType, final boolean isUserAction, final boolean isExpanded) {
            final String key = sbn.getKey();
            notifyAssistantLocked(sbn, notificationType, true, new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda4(this, key, isUserAction, isExpanded));
        }

        private /* synthetic */ void lambda$notifyAssistantExpansionChangedLocked$4(String key, boolean isUserAction, boolean isExpanded, INotificationListener assistant, StatusBarNotification unused) {
            assistant.onNotificationExpansionChanged(key, isUserAction, isExpanded);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (expanded): " + assistant, ex);
        }

        void notifyAssistantNotificationDirectReplyLocked(NotificationRecord r) {
            final String key = r.getKey();
            notifyAssistantLocked(r.getSbn(), r.getNotificationType(), true, new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda8(this, key));
        }

        private /* synthetic */ void lambda$notifyAssistantNotificationDirectReplyLocked$5(String key, INotificationListener assistant, StatusBarNotification unused) {
            assistant.onNotificationDirectReply(key);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (expanded): " + assistant, ex);
        }

        void notifyAssistantSuggestedReplySent(StatusBarNotification sbn, int notificationType, final CharSequence reply, final boolean generatedByAssistant) {
            final String key = sbn.getKey();
            notifyAssistantLocked(sbn, notificationType, true, new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda3(this, key, reply, generatedByAssistant));
        }

        private /* synthetic */ void lambda$notifyAssistantSuggestedReplySent$6(String key, CharSequence reply, boolean generatedByAssistant, INotificationListener assistant, StatusBarNotification unused) {
            if (generatedByAssistant == false) goto L4;
            int r0 = 1;
        L10:
            assistant.onSuggestedReplySent(key, reply, r0);     // Catch: RemoteException -> L7
            return;
        L7:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (snoozed): " + assistant, ex);
            return;
        L4:
            r0 = 0;
            goto L10
        }

        void notifyAssistantActionClicked(NotificationRecord r, final Notification.Action action, final boolean generatedByAssistant) {
            final String key = r.getSbn().getKey();
            notifyAssistantLocked(r.getSbn(), r.getNotificationType(), true, new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda7(this, key, action, generatedByAssistant));
        }

        private /* synthetic */ void lambda$notifyAssistantActionClicked$7(String key, Notification.Action action, boolean generatedByAssistant, INotificationListener assistant, StatusBarNotification unused) {
            if (generatedByAssistant == false) goto L4;
            int r0 = 1;
        L10:
            assistant.onActionClicked(key, action, r0);     // Catch: RemoteException -> L7
            return;
        L7:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (snoozed): " + assistant, ex);
            return;
        L4:
            r0 = 0;
            goto L10
        }

        private void notifyAssistantSnoozedLocked(NotificationRecord r, final String snoozeCriterionId) {
            notifyAssistantLocked(r.getSbn(), r.getNotificationType(), true, new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda9(this, snoozeCriterionId));
        }

        private /* synthetic */ void lambda$notifyAssistantSnoozedLocked$8(String snoozeCriterionId, INotificationListener info, StatusBarNotification sbnToPost) {
            StatusBarNotificationHolder sbnHolder = new StatusBarNotificationHolder(sbnToPost);     // Catch: RemoteException -> L5 DeadObjectException -> L7
            info.onNotificationSnoozedUntilContext(sbnHolder, snoozeCriterionId);     // Catch: RemoteException -> L5 DeadObjectException -> L7
        L14:
            return;
        L7:
            ex = move-exception;
            Slog.wtf(this.TAG, "unable to notify assistant (snoozed): " + info, ex);
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (snoozed): " + info, ex);
        }

        void notifyAssistantNotificationClicked(NotificationRecord r) {
            final String key = r.getSbn().getKey();
            notifyAssistantLocked(r.getSbn(), r.getNotificationType(), true, new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda2(this, key));
        }

        private /* synthetic */ void lambda$notifyAssistantNotificationClicked$9(String key, INotificationListener assistant, StatusBarNotification unused) {
            assistant.onNotificationClicked(key);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (clicked): " + assistant, ex);
        }

        void notifyAssistantFeedbackReceived(NotificationRecord r, Bundle feedback) {
            StatusBarNotification sbn = r.getSbn();
            Iterator<ManagedServices.ManagedServiceInfo> r1 = getServices().iterator();
        L4:
            if (r1.hasNext() == false) goto L19;
            ManagedServices.ManagedServiceInfo info = r1.next();
            if (this.this$0.isVisibleToListener(sbn, r.getNotificationType(), info) == true) goto L8;
        L10:
            boolean sbnVisible = false;
        L12:
            if (sbnVisible == false) goto L4;
            INotificationListener assistant = info.service;
            NotificationRankingUpdate update = this.this$0.makeRankingUpdateLocked(info);     // Catch: RemoteException -> L16
            assistant.onNotificationFeedbackReceived(sbn.getKey(), update, feedback);     // Catch: RemoteException -> L16
        L16:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (feedback): " + assistant, ex);
            goto L4
        L8:
            if (info.isSameUser(r.getUserId()) == false) goto L10;
            sbnVisible = true;
            goto L12
        }

        private void notifyAssistantLocked(StatusBarNotification sbn, int notificationType, boolean sameUserOnly, final BiConsumer<INotificationListener, StatusBarNotification> callback) {
            TrimCache trimCache = new TrimCache(this.this$0, sbn);
            boolean debug = isVerboseLogEnabled();
            if (debug == false) goto L5;
            Slog.v(this.TAG, "notifyAssistantLocked() called with: sbn = [" + sbn + "], sameUserOnly = [" + sameUserOnly + "], callback = [" + callback + "]");
        L5:
            Iterator<ManagedServices.ManagedServiceInfo> r2 = getServices().iterator();
        L7:
            if (r2.hasNext() == false) goto L21;
            ManagedServices.ManagedServiceInfo info = r2.next();
            if (this.this$0.isVisibleToListener(sbn, notificationType, info) == false) goto L14;
            if (sameUserOnly == true) goto L12;
        L13:
            boolean sbnVisible = true;
        L16:
            if (debug == false) goto L18;
            Slog.v(this.TAG, "notifyAssistantLocked info=" + info + " snbVisible=" + sbnVisible);
        L18:
            if (sbnVisible == false) goto L7;
            final INotificationListener assistant = info.service;
            final StatusBarNotification sbnToPost = trimCache.ForListener(info);
            this.this$0.mHandler.post(new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda1(callback, assistant, sbnToPost));
            goto L7
        L12:
            if (info.isSameUser(sbn.getUserId()) == true) goto L13;
        L14:
            sbnVisible = false;
            goto L16
        }

        private static /* synthetic */ void lambda$notifyAssistantLocked$10(BiConsumer callback, INotificationListener assistant, StatusBarNotification sbnToPost) {
            callback.accept(assistant, sbnToPost);
        }

        public boolean isEnabled() {
            return !getServices().isEmpty();
        }

        protected void resetDefaultAssistantsIfNecessary() {
            List<UserInfo> activeUsers = this.mUm.getAliveUsers();
            Iterator<UserInfo> r1 = activeUsers.iterator();
        L4:
            if (r1.hasNext() == false) goto L12;
            UserInfo userInfo = r1.next();
            int userId = userInfo.getUserHandle().getIdentifier();
            if (hasUserSet(userId) == true) goto L4;
            if (this.this$0.isNASMigrationDone(userId) == true) goto L10;
            resetDefaultFromConfig();
            this.this$0.setNASMigrationDone(userId);
        L10:
            Slog.d(this.TAG, "Approving default notification assistant for user " + userId);
            this.this$0.setDefaultAssistantForUser(userId);
            goto L4
        }

        protected void resetDefaultFromConfig() {
            clearDefaults();
            loadDefaultsFromConfig();
        }

        protected void clearDefaults() {
            this.mDefaultComponents.clear();
            this.mDefaultPackages.clear();
        }

        @Override // com.android.server.notification.ManagedServices
        protected boolean setPackageOrComponentEnabled(String pkgOrComponent, int userId, boolean isPrimary, boolean enabled, boolean userSet) {
            if (enabled == false) goto L10;
            List<ComponentName> allowedComponents = getAllowedComponents(userId);
            if (allowedComponents.isEmpty() == true) goto L10;
            ComponentName currentComponent = (ComponentName) CollectionUtils.firstOrNull(allowedComponents);
            if (currentComponent.flattenToString().equals(pkgOrComponent) == false) goto L8;
            return false;
        L8:
            this.this$0.setNotificationAssistantAccessGrantedForUserInternal(currentComponent, userId, false, userSet);
        L10:
            return super.setPackageOrComponentEnabled(pkgOrComponent, userId, isPrimary, enabled, userSet);
        }

        private boolean isVerboseLogEnabled() {
            return Log.isLoggable("notification_assistant", 2);
        }

        private void addDefaultClassificationTypes() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mAllowedClassificationTypes.isEmpty() == false) goto L9;
            this.mAllowedClassificationTypes.addAll(List.of(NotificationManagerService.DEFAULT_ALLOWED_ADJUSTMENT_KEY_TYPES));     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void allowAdjustmentType(String key) {
            this.mDeniedAdjustments.remove(key);
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            this.this$0.mHandler.post(new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda12(this, info));
            goto L4
        L7:
            if ("key_type".equals(key) == false) goto L11;
            addDefaultClassificationTypes();
            return;
        }

        private /* synthetic */ void lambda$allowAdjustmentType$11(ManagedServices.ManagedServiceInfo info) {
            notifyCapabilitiesChanged(info);
        }

        public void disallowAdjustmentType(String key) {
            this.mDeniedAdjustments.add(key);
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            this.this$0.mHandler.post(new NotificationManagerService$NotificationAssistants$$ExternalSyntheticLambda0(this, info));
            goto L4
        }

        private /* synthetic */ void lambda$disallowAdjustmentType$12(ManagedServices.ManagedServiceInfo info) {
            notifyCapabilitiesChanged(info);
        }

        public void setAdjustmentTypeSupportedState(int userId, String key, boolean supported) {
            HashSet<String> disabledAdjustments = this.mNasUnsupported.getOrDefault(Integer.valueOf(userId), new HashSet());
            if (supported == false) goto L5;
            disabledAdjustments.remove(key);
        L6:
            this.mNasUnsupported.put(Integer.valueOf(userId), disabledAdjustments);
            this.this$0.handleSavePolicyFile();
            return;
        L5:
            disabledAdjustments.add(key);
            goto L6
        }

        public Set<String> getUnsupportedAdjustments(int userId) {
            return this.mNasUnsupported.getOrDefault(Integer.valueOf(userId), new HashSet());
        }

        private void setNasUnsupportedDefaults(int userId) {
            if (this.mNasUnsupported == null) goto L6;
            this.mNasUnsupported.put(Integer.valueOf(userId), new HashSet(List.of(this.this$0.mDefaultUnsupportedAdjustments)));
            this.this$0.handleSavePolicyFile();
            return;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void writeExtraAttributes(TypedXmlSerializer out, int approvedUserId) throws IOException {
            Object r0 = this.mLock;
            monitor-enter(r0);
            out.attribute(null, ATT_NAS_UNSUPPORTED, TextUtils.join(",", this.mNasUnsupported.getOrDefault(Integer.valueOf(approvedUserId), new HashSet())));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void readExtraAttributes(String tag, TypedXmlPullParser parser, int approvedUserId) throws IOException {
            if ("service_listing".equals(tag) == false) goto L18;
            String types = XmlUtils.readStringAttribute(parser, ATT_NAS_UNSUPPORTED);
            Object r1 = this.mLock;
            monitor-enter(r1);
            if (types != null) goto L11;
            setNasUnsupportedDefaults(approvedUserId);     // Catch: Throwable -> L8
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L11:
            if (TextUtils.isEmpty(types) == true) goto L13;
            this.mNasUnsupported.put(Integer.valueOf(approvedUserId), new HashSet(List.of(types.split(","))));     // Catch: Throwable -> L8
            goto L14
        L13:
            this.mNasUnsupported.put(Integer.valueOf(approvedUserId), new HashSet());     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void writeExtraXmlTags(TypedXmlSerializer out) throws IOException {
        }

        @Override // com.android.server.notification.ManagedServices
        protected void readExtraTag(String tag, TypedXmlPullParser parser) throws IOException {
        }

        private void notifyCapabilitiesChanged(ManagedServices.ManagedServiceInfo info) {
            INotificationListener assistant = info.service;
            assistant.onAllowedAdjustmentsChanged();     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify assistant (capabilities): " + info, ex);
        }

        protected void pullBundlePreferencesStats(List<StatsEvent> events) {
            Object r1 = this.mLock;
            monitor-enter(r1);
            List<String> unsupportedAdjustments = new ArrayList(this.mNasUnsupported.getOrDefault(Integer.valueOf(UserHandle.getUserId(Binder.getCallingUid())), new HashSet(List.of(this.this$0.mDefaultUnsupportedAdjustments))));     // Catch: Throwable -> L12
            if (unsupportedAdjustments.contains("key_type") == true) goto L7;
            boolean r3 = true;
        L8:
            boolean bundlesAllowed = r3;
            monitor-exit(r1);     // Catch: Throwable -> L12
            int[] allowedBundleTypes = getAllowedClassificationTypes();
            events.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.NOTIFICATION_BUNDLE_PREFERENCES, NotificationRecordLogger.NotificationPullStatsEvent.NOTIFICATION_BUNDLE_PREFERENCES_PULLED.getId(), bundlesAllowed, allowedBundleTypes));
            return;
        L7:
            r3 = false;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public class NotificationListeners extends ManagedServices {
        static final String ATT_COMPONENT = "component";
        static final String ATT_PKG = "pkg";
        static final String ATT_TYPES = "types";
        static final String ATT_UID = "uid";
        static final String FLAG_SEPARATOR = "\\|";
        static final String TAG_APPROVED = "allowed";
        static final String TAG_DISALLOWED = "disallowed";
        static final String TAG_ENABLED_NOTIFICATION_LISTENERS = "enabled_listeners";
        static final String TAG_REQUESTED_LISTENER = "listener";
        static final String TAG_REQUESTED_LISTENERS = "request_listeners";
        static final String XML_SEPARATOR = ",";
        private final boolean mIsHeadlessSystemUserMode;
        private final ArraySet<ManagedServices.ManagedServiceInfo> mLightTrimListeners;
        private final ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> mRequestedNotificationListeners;
        private final ArraySet<Integer> mTrustedListenerUids;
        final /* synthetic */ NotificationManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$0iWeY82Ox6K-WVRWLCpMEXmz-hA, reason: not valid java name */
        public static /* synthetic */ void m6267$r8$lambda$0iWeY82Ox6KWVRWLCpMEXmzhA(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, int r2) {
            r0.lambda$notifyListenerHintsChangedLocked$7(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$6V9RGqXihQs6v7F21expZx6F_zc(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, StatusBarNotification r2, NotificationRankingUpdate r3) {
            r0.lambda$prepareNotifyPostedLocked$3(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$8WHqs6YFtOfFequl8EwqMerBSx4(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, StatusBarNotification r2, NotificationRankingUpdate r3) {
            r0.lambda$prepareNotifyPostedLocked$2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$KeHzurar6-Y0ok_fcbWJBcURzrE, reason: not valid java name */
        public static /* synthetic */ void m6268$r8$lambda$KeHzurar6Y0ok_fcbWJBcURzrE(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, boolean r2) {
            r0.lambda$onStatusBarIconsBehaviorChanged$0(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$OSrMhYvlV-R3E77qIoH5pzE972U, reason: not valid java name */
        public static /* synthetic */ void m6269$r8$lambda$OSrMhYvlVR3E77qIoH5pzE972U(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, NotificationRankingUpdate r2) {
            r0.lambda$notifyRankingUpdateLocked$6(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$RbnnqtIVpjhzFw8dbsSx7hvhMgg(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, StatusBarNotification r2, NotificationRankingUpdate r3, NotificationStats r4, int r5) {
            r0.lambda$notifyRemovedLocked$4(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$VmcY63y9deVrzSb6PhmE8Uor26s(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, String r2, UserHandle r3, NotificationChannelGroup r4, int r5) {
            r0.lambda$notifyNotificationChannelGroupChanged$10(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$W6cqH1TH5i5zhS_9JyCD0Cwqo4k(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, String r2, UserHandle r3, NotificationChannel r4, int r5) {
            r0.lambda$notifyNotificationChannelChanged$9(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$iL7tP1rlSnQntsBHgGsAwtCItDk(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, int r2) {
            r0.lambda$notifyInterruptionFilterChanged$8(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$nPIV6NoKkWlO9nB30QOeIw7qlCM(NotificationListeners r0, ManagedServices.ManagedServiceInfo r1, StatusBarNotification r2, NotificationRankingUpdate r3) {
            r0.lambda$prepareNotifyPostedLocked$1(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$ykOQj42f4S_ClginyasCRZXMpGU(NotificationListeners r0, NotificationRecord r1) {
            r0.lambda$notifyRemovedLocked$5(r1);
        }

        public NotificationListeners(NotificationManagerService this$0, Context context, Object lock, ManagedServices.UserProfiles userProfiles, IPackageManager pm) {
            this(this$0, context, lock, userProfiles, pm, UserManager.isHeadlessSystemUserMode());
        }

        public NotificationListeners(NotificationManagerService this$0, Context context, Object lock, ManagedServices.UserProfiles userProfiles, IPackageManager pm, boolean isHeadlessSystemUserMode) {
            this.this$0 = this$0;
            super(context, lock, userProfiles, pm);
            this.mLightTrimListeners = new ArraySet();
            this.mTrustedListenerUids = new ArraySet();
            this.mRequestedNotificationListeners = new ArrayMap();
            this.mIsHeadlessSystemUserMode = isHeadlessSystemUserMode;
        }

        @Override // com.android.server.notification.ManagedServices
        protected boolean setPackageOrComponentEnabled(String pkgOrComponent, int userId, boolean isPrimary, boolean enabled, boolean userSet) {
            boolean changed = super.setPackageOrComponentEnabled(pkgOrComponent, userId, isPrimary, enabled, userSet);
            if (changed == true) goto L6;
            return false;
        L6:
            String pkgName = getPackageName(pkgOrComponent);
            int uid = this.this$0.mPackageManagerInternal.getPackageUid(pkgName, 0, userId);
            if (enabled == true) goto L17;
            if (uid < 0) goto L17;
            ArraySet<Integer> r5 = this.mTrustedListenerUids;
            monitor-enter(r5);
            this.mTrustedListenerUids.remove(Integer.valueOf(uid));     // Catch: Throwable -> L14
            monitor-exit(r5);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        L17:
            if (enabled == false) goto L29;
            if (uid < 0) goto L29;
            if (isAppTrustedNotificationListenerService(uid, pkgName) == false) goto L29;
            ArraySet<Integer> r6 = this.mTrustedListenerUids;
            monitor-enter(r6);
            this.mTrustedListenerUids.add(Integer.valueOf(uid));     // Catch: Throwable -> L26
            monitor-exit(r6);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L29:
            this.mContext.sendBroadcastAsUser(new Intent("android.app.action.NOTIFICATION_LISTENER_ENABLED_CHANGED").addFlags(1073741824), UserHandle.of(userId), null);
            return true;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void loadDefaultsFromConfig() {
            String defaultListenerAccess = this.mContext.getResources().getString(R.string.config_extensionFallbackServiceName);
            if (defaultListenerAccess == null) goto L18;
            String[] listeners = defaultListenerAccess.split(":");
            int i = 0;
        L6:
            if (i >= listeners.length) goto L22;
            if (TextUtils.isEmpty(listeners[i]) == true) goto L17;
            int packageQueryFlags = 786432;
            if (this.mIsHeadlessSystemUserMode == false) goto L13;
            packageQueryFlags = 786432 + 4194304;
        L13:
            ArraySet<ComponentName> approvedListeners = queryPackageForServices(listeners[i], packageQueryFlags, 0);
            int k = 0;
        L15:
            if (k >= approvedListeners.size()) goto L17;
            ComponentName cn = approvedListeners.valueAt(k);
            addDefaultComponentOrPackage(cn.flattenToString());
            k = k + 1;
        L17:
            i = i + 1;
            goto L6
        L22:
            return;
        }

        @Override // com.android.server.notification.ManagedServices
        protected int getBindFlags() {
            return 83886337;
        }

        @Override // com.android.server.notification.ManagedServices
        protected ManagedServices.Config getConfig() {
            ManagedServices.Config c = new ManagedServices.Config();
            c.caption = "notification listener";
            c.serviceInterface = "android.service.notification.NotificationListenerService";
            c.xmlTag = TAG_ENABLED_NOTIFICATION_LISTENERS;
            c.secureSettingName = "enabled_notification_listeners";
            c.bindPermission = "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE";
            c.settingsAction = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
            c.clientLabel = R.string.permdesc_requestIgnoreBatteryOptimizations;
            return c;
        }

        @Override // com.android.server.notification.ManagedServices
        protected IInterface asInterface(IBinder binder) {
            return INotificationListener.Stub.asInterface(binder);
        }

        @Override // com.android.server.notification.ManagedServices
        protected boolean checkType(IInterface service) {
            return service instanceof INotificationListener;
        }

        @Override // com.android.server.notification.ManagedServices
        public void onServiceAdded(ManagedServices.ManagedServiceInfo info) {
            if (this.this$0.isCallerSystemOrPhone() == false) goto L5;
        L7:
            boolean r0 = false;
        L8:
            info.isSystemUi = r0;
            INotificationListener listener = info.service;
            Object r2 = this.this$0.mNotificationLock;
            monitor-enter(r2);
            NotificationRankingUpdate update = this.this$0.makeRankingUpdateLocked(info);     // Catch: Throwable -> L26
            updateUriPermissionsForActiveNotificationsLocked(info, true);     // Catch: Throwable -> L26
            monitor-exit(r2);     // Catch: Throwable -> L26
            if (isAppTrustedNotificationListenerService(info.uid, info.component.getPackageName()) == false) goto L31;
            ArraySet<Integer> r1 = this.mTrustedListenerUids;
            monitor-enter(r1);
            this.mTrustedListenerUids.add(Integer.valueOf(info.uid));     // Catch: Throwable -> L19
            monitor-exit(r1);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L31:
            listener.onListenerConnected(update);     // Catch: RemoteException -> L24
            return;
        L25:
            return;
        L26:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.getContext().checkPermission("android.permission.STATUS_BAR_SERVICE", -1, info.uid) != 0) goto L7;
            r0 = true;
            goto L8
        }

        @Override // com.android.server.notification.ManagedServices
        protected void onServiceRemovedLocked(ManagedServices.ManagedServiceInfo removed) {
            updateUriPermissionsForActiveNotificationsLocked(removed, false);
            if (NotificationManagerService.m6231$$Nest$mremoveDisabledHints(this.this$0, removed) == false) goto L5;
            NotificationManagerService.m6242$$Nest$mupdateListenerHintsLocked(this.this$0);
            NotificationManagerService.m6240$$Nest$mupdateEffectsSuppressorLocked(this.this$0);
        L5:
            ArraySet<Integer> r0 = this.mTrustedListenerUids;
            monitor-enter(r0);
            this.mTrustedListenerUids.remove(Integer.valueOf(removed.uid));     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.mLightTrimListeners.remove(removed);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.ManagedServices
        public void onUserRemoved(int user) {
            super.onUserRemoved(user);
            ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> r0 = this.mRequestedNotificationListeners;
            monitor-enter(r0);
            int i = this.mRequestedNotificationListeners.size() - 1;     // Catch: Throwable -> L9
        L5:
            if (i < 0) goto L13;
            if (((Integer) this.mRequestedNotificationListeners.keyAt(i).second).intValue() != user) goto L11;
            this.mRequestedNotificationListeners.removeAt(i);     // Catch: Throwable -> L9
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

        @Override // com.android.server.notification.ManagedServices
        public void onUserUnlocked(int user) {
            if (this.mUmInternal.isVisibleBackgroundFullUser(user) == false) goto L5;
            return;
        L5:
            super.onUserUnlocked(user);
        }

        @Override // com.android.server.notification.ManagedServices
        protected boolean allowRebindForParentUser() {
            return true;
        }

        @Override // com.android.server.notification.ManagedServices
        public void onPackagesChanged(boolean removingPackage, String[] pkgList, int[] uidList) {
            super.onPackagesChanged(removingPackage, pkgList, uidList);
            ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> r0 = this.mRequestedNotificationListeners;
            monitor-enter(r0);
            if (removingPackage == false) goto L26;
            int i = 0;
        L30:
        L15:
            th = move-exception;
            throw th;
        L7:
            if (i >= pkgList.length) goto L19;
            String pkg = pkgList[i];     // Catch: Throwable -> L15
            int userId = UserHandle.getUserId(uidList[i]);     // Catch: Throwable -> L15
            int j = this.mRequestedNotificationListeners.size() - 1;     // Catch: Throwable -> L15
        L9:
            if (j < 0) goto L18;
            Pair<ComponentName, Integer> key = this.mRequestedNotificationListeners.keyAt(j);     // Catch: Throwable -> L15
            if (((Integer) key.second).intValue() != userId) goto L17;
            if (((ComponentName) key.first).getPackageName().equals(pkg) == false) goto L17;
            this.mRequestedNotificationListeners.removeAt(j);     // Catch: Throwable -> L15
        L17:
            j = j - 1;     // Catch: Throwable -> L15
            goto L9
        L18:
            i = i + 1;     // Catch: Throwable -> L15
            goto L30
        L19:
            int i2 = 0;
        L21:
            if (i2 >= pkgList.length) goto L26;
            String pkg2 = pkgList[i2];     // Catch: Throwable -> L15
            int j2 = this.mRequestedNotificationListeners.size() - 1;     // Catch: Throwable -> L15
        L23:
            if (j2 < 0) goto L25;
            NotificationListenerFilter nlf = this.mRequestedNotificationListeners.valueAt(j2);     // Catch: Throwable -> L15
            VersionedPackage ai = new VersionedPackage(pkg2, uidList[i2]);     // Catch: Throwable -> L15
            nlf.removePackage(ai);     // Catch: Throwable -> L15
            j2 = j2 - 1;     // Catch: Throwable -> L15
            goto L23
        L25:
            i2 = i2 + 1;     // Catch: Throwable -> L15
        L26:
            monitor-exit(r0);     // Catch: Throwable -> L15
        }

        @Override // com.android.server.notification.ManagedServices
        protected String getRequiredPermission() {
            return null;
        }

        @Override // com.android.server.notification.ManagedServices
        protected boolean shouldReflectToSettings() {
            return true;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void readExtraTag(String tag, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            if (TAG_REQUESTED_LISTENERS.equals(tag) == false) goto L30;
            int listenersOuterDepth = parser.getDepth();
        L6:
            if (XmlUtils.nextElementWithin(parser, listenersOuterDepth) == false) goto L48;
            if (TAG_REQUESTED_LISTENER.equals(parser.getName()) == false) goto L6;
            int userId = XmlUtils.readIntAttribute(parser, "user");
            ComponentName cn = ComponentName.unflattenFromString(XmlUtils.readStringAttribute(parser, ATT_COMPONENT));
            int approved = 15;
            ArraySet<VersionedPackage> disallowedPkgs = new ArraySet();
            int listenerOuterDepth = parser.getDepth();
        L12:
            if (XmlUtils.nextElementWithin(parser, listenerOuterDepth) == false) goto L22;
            if (TAG_APPROVED.equals(parser.getName()) == true) goto L15;
            if (TAG_DISALLOWED.equals(parser.getName()) == false) goto L12;
            String pkg = XmlUtils.readStringAttribute(parser, "pkg");
            int uid = XmlUtils.readIntAttribute(parser, "uid");
            if (TextUtils.isEmpty(pkg) == true) goto L12;
            VersionedPackage ai = new VersionedPackage(pkg, uid);
            disallowedPkgs.add(ai);
            goto L12
        L15:
            approved = XmlUtils.readIntAttribute(parser, ATT_TYPES);
            goto L12
        L22:
            NotificationListenerFilter nlf = new NotificationListenerFilter(approved, disallowedPkgs);
            ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> r7 = this.mRequestedNotificationListeners;
            monitor-enter(r7);
            this.mRequestedNotificationListeners.put(Pair.create(cn, Integer.valueOf(userId)), nlf);     // Catch: Throwable -> L27
            monitor-exit(r7);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            throw th;
        L48:
            return;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void writeExtraXmlTags(TypedXmlSerializer out) throws IOException {
            out.startTag(null, TAG_REQUESTED_LISTENERS);
            ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> r0 = this.mRequestedNotificationListeners;
            monitor-enter(r0);
            Iterator<Pair<ComponentName, Integer>> r2 = this.mRequestedNotificationListeners.keySet().iterator();     // Catch: Throwable -> L13
        L6:
            if (r2.hasNext() == false) goto L17;
            Pair<ComponentName, Integer> listener = r2.next();     // Catch: Throwable -> L13
            NotificationListenerFilter nlf = this.mRequestedNotificationListeners.get(listener);     // Catch: Throwable -> L13
            out.startTag(null, TAG_REQUESTED_LISTENER);     // Catch: Throwable -> L13
            XmlUtils.writeStringAttribute(out, ATT_COMPONENT, ((ComponentName) listener.first).flattenToString());     // Catch: Throwable -> L13
            XmlUtils.writeIntAttribute(out, "user", ((Integer) listener.second).intValue());     // Catch: Throwable -> L13
            out.startTag(null, TAG_APPROVED);     // Catch: Throwable -> L13
            XmlUtils.writeIntAttribute(out, ATT_TYPES, nlf.getTypes());     // Catch: Throwable -> L13
            out.endTag(null, TAG_APPROVED);     // Catch: Throwable -> L13
            Iterator r5 = nlf.getDisallowedPackages().iterator();     // Catch: Throwable -> L13
        L9:
            if (r5.hasNext() == false) goto L16;
            VersionedPackage ai = (VersionedPackage) r5.next();     // Catch: Throwable -> L13
            if (TextUtils.isEmpty(ai.getPackageName()) == true) goto L9;
            out.startTag(null, TAG_DISALLOWED);     // Catch: Throwable -> L13
            XmlUtils.writeStringAttribute(out, "pkg", ai.getPackageName());     // Catch: Throwable -> L13
            XmlUtils.writeIntAttribute(out, "uid", ai.getVersionCode());     // Catch: Throwable -> L13
            out.endTag(null, TAG_DISALLOWED);     // Catch: Throwable -> L13
            goto L9
        L16:
            out.endTag(null, TAG_REQUESTED_LISTENER);     // Catch: Throwable -> L13
            goto L6
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L13
            out.endTag(null, TAG_REQUESTED_LISTENERS);
            return;
        L13:
            th = move-exception;
            throw th;
        }

        protected NotificationListenerFilter getNotificationListenerFilter(Pair<ComponentName, Integer> pair) {
            ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> r0 = this.mRequestedNotificationListeners;
            monitor-enter(r0);
            NotificationListenerFilter r1 = this.mRequestedNotificationListeners.get(pair);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        protected void setNotificationListenerFilter(Pair<ComponentName, Integer> pair, NotificationListenerFilter nlf) {
            ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> r0 = this.mRequestedNotificationListeners;
            monitor-enter(r0);
            this.mRequestedNotificationListeners.put(pair, nlf);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.notification.ManagedServices
        protected void ensureFilters(ServiceInfo si, int userId) {
            Pair<ComponentName, Integer> listener = Pair.create(si.getComponentName(), Integer.valueOf(userId));
            ArrayMap<Pair<ComponentName, Integer>, NotificationListenerFilter> r1 = this.mRequestedNotificationListeners;
            monitor-enter(r1);
            NotificationListenerFilter existingNlf = this.mRequestedNotificationListeners.get(listener);     // Catch: Throwable -> L12
            if (si.metaData == null) goto L19;
            if (existingNlf != null) goto L15;
            if (si.metaData.containsKey("android.service.notification.default_filter_types") == false) goto L15;
            String typeList = si.metaData.get("android.service.notification.default_filter_types").toString();     // Catch: Throwable -> L12
            if (typeList == null) goto L15;
            int types = getTypesFromStringList(typeList);     // Catch: Throwable -> L12
            NotificationListenerFilter nlf = new NotificationListenerFilter(types, new ArraySet());     // Catch: Throwable -> L12
            this.mRequestedNotificationListeners.put(listener, nlf);     // Catch: Throwable -> L12
        L15:
            if (si.metaData.containsKey("android.service.notification.disabled_filter_types") == false) goto L19;
            int neverBridge = getTypesFromStringList(si.metaData.get("android.service.notification.disabled_filter_types").toString());     // Catch: Throwable -> L12
            if (neverBridge == 0) goto L19;
            NotificationListenerFilter nlf2 = this.mRequestedNotificationListeners.getOrDefault(listener, new NotificationListenerFilter());     // Catch: Throwable -> L12
            nlf2.setTypes(nlf2.getTypes() & (~neverBridge));     // Catch: Throwable -> L12
            this.mRequestedNotificationListeners.put(listener, nlf2);     // Catch: Throwable -> L12
        L19:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        private int getTypesFromStringList(String typeList) {
            int types = 0;
            if (typeList == null) goto L26;
            String[] typeStrings = typeList.split(FLAG_SEPARATOR);
            int i = 0;
        L6:
            if (i >= typeStrings.length) goto L26;
            String typeString = typeStrings[i];
            if (TextUtils.isEmpty(typeString) == true) goto L25;
            if (typeString.equalsIgnoreCase("ONGOING") == false) goto L14;
            types = types | 8;
            goto L25
        L14:
            if (typeString.equalsIgnoreCase("CONVERSATIONS") == false) goto L17;
            types = types | 1;
            goto L25
        L17:
            if (typeString.equalsIgnoreCase("SILENT") == false) goto L20;
            types = types | 4;
            goto L25
        L20:
            if (typeString.equalsIgnoreCase("ALERTING") == false) goto L27;
            types = types | 2;
            goto L25
        L27:
            types = types | Integer.parseInt(typeString);
        L25:
            i = i + 1;
        L26:
            return types;
        }

        public void setOnNotificationPostedTrimLocked(ManagedServices.ManagedServiceInfo info, int trim) {
            if (trim != 1) goto L5;
            this.mLightTrimListeners.add(info);
            return;
        L5:
            this.mLightTrimListeners.remove(info);
        }

        public int getOnNotificationPostedTrim(ManagedServices.ManagedServiceInfo r2) {
            return this.mLightTrimListeners.contains(r2) ? 1 : 0;
        }

        public void onStatusBarIconsBehaviorChanged(final boolean hideSilentStatusIcons) {
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            this.this$0.mHandler.post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda0(this, info, hideSilentStatusIcons));
            goto L4
        }

        private /* synthetic */ void lambda$onStatusBarIconsBehaviorChanged$0(ManagedServices.ManagedServiceInfo info, boolean hideSilentStatusIcons) {
            INotificationListener listener = info.service;
            listener.onStatusBarIconsBehaviorChanged(hideSilentStatusIcons);     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (hideSilentStatusIcons): " + info, ex);
        }

        void notifyPostedLocked(NotificationRecord r, NotificationRecord old) {
            notifyPostedLocked(r, old, true);
        }

        void notifyPostedLocked(NotificationRecord r, NotificationRecord old, boolean notifyAllListeners) {
            Iterator<Runnable> r0 = prepareNotifyPostedLocked(r, old, notifyAllListeners).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Runnable listenerCall = r0.next();
            this.this$0.mHandler.post(listenerCall);
            goto L4
        }

        List<Runnable> prepareNotifyPostedLocked(NotificationRecord r, NotificationRecord old, boolean notifyAllListeners) {
            if (this.this$0.isInLockDownMode(r.getUser().getIdentifier()) == true) goto L5;
            ArrayList<Runnable> listenerCalls = new ArrayList();
            StatusBarNotification sbn = r.getSbn();     // Catch: Exception -> L10
            if (old == null) goto L12;
            StatusBarNotification oldSbn = old.getSbn();     // Catch: Exception -> L10
        L13:
            TrimCache trimCache = new TrimCache(this.this$0, sbn);     // Catch: Exception -> L10
            TrimCache redactedCache = null;
            StatusBarNotification redactedSbn = null;
            StatusBarNotification oldRedactedSbn = null;
            boolean isNewSensitive = hasSensitiveContent(r);     // Catch: Exception -> L10
            boolean isOldSensitive = hasSensitiveContent(old);     // Catch: Exception -> L10
            if (NotificationManagerService.m6158$$Nest$fgetmRedactOtpNotifications(this.this$0) == false) goto L16;
            boolean redactionEnabled = true;
        L17:
            Iterator<ManagedServices.ManagedServiceInfo> r14 = getServices().iterator();     // Catch: Exception -> L10
        L19:
            if (r14.hasNext() == false) goto L115;
            final ManagedServices.ManagedServiceInfo info = r14.next();     // Catch: Exception -> L10
            boolean isTrusted = isUidTrusted(info.uid);     // Catch: Exception -> L10
            if (redactionEnabled == false) goto L25;
            if (isNewSensitive == false) goto L25;
            if (isTrusted == true) goto L25;
            boolean sendRedacted = true;
        L26:
            if (redactionEnabled == false) goto L30;
            if (isOldSensitive == false) goto L30;
            if (isTrusted == true) goto L30;
            boolean sendOldRedacted = true;
        L31:
            TrimCache redactedCache2 = redactedCache;
            boolean sbnVisible = this.this$0.isVisibleToListener(sbn, r.getNotificationType(), info);     // Catch: Exception -> L10
            if (oldSbn == null) goto L36;
            boolean sbnVisible2 = sbnVisible;
            if (this.this$0.isVisibleToListener(oldSbn, old.getNotificationType(), info) == false) goto L37;
            boolean oldSbnVisible = true;
        L39:
            if (oldSbnVisible == true) goto L42;
            if (sbnVisible2 == true) goto L42;
        L46:
            redactedCache = redactedCache2;
        L42:
            boolean oldSbnVisible2 = oldSbnVisible;
            if (r.isHidden() == false) goto L48;
            if (info.targetSdkVersion < 28) goto L46;
        L48:
            if (sendRedacted == false) goto L51;
            if (redactedSbn != null) goto L51;
            StatusBarNotification redactedSbn2 = redactStatusBarNotification(sbn);     // Catch: Exception -> L10
            TrimCache redactedCache3 = new TrimCache(this.this$0, redactedSbn2);     // Catch: Exception -> L10
            redactedSbn = redactedSbn2;
        L52:
            if (sendRedacted == false) goto L54;
            final StatusBarNotification sbnToPost = redactedCache3.ForListener(info);     // Catch: Exception -> L10
        L56:
            if (old == null) goto L77;
            if (old.getNotification() == null) goto L77;
            TrimCache redactedCache4 = redactedCache3;
            if ((old.getNotification().flags & 65536) <= 0) goto L78;
            if (sbn == null) goto L78;
            if (sbn.getNotification() == null) goto L78;
            if ((sbn.getNotification().flags & 65536) <= 0) goto L78;
            if (info.isSystemUi() == true) goto L68;
            if (NotificationManagerService.DBG == false) goto L73;
            Slog.d(this.TAG, "prepareNotifyPostedLocked: direct reply update, skipping post to " + info.toString());     // Catch: Exception -> L10
        L73:
            redactedCache = redactedCache4;
            redactedSbn = redactedSbn;
            oldRedactedSbn = oldRedactedSbn;
            goto L19
        L68:
            final NotificationRankingUpdate update = this.this$0.makeRankingUpdateLocked(info);     // Catch: Exception -> L10
            listenerCalls.add(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda8(this, info, sbnToPost, update));     // Catch: Exception -> L10
        L78:
            if (notifyAllListeners == true) goto L82;
            if (info.targetSdkVersion < 28) goto L82;
            redactedCache = redactedCache4;
            redactedSbn = redactedSbn;
            oldRedactedSbn = oldRedactedSbn;
        L82:
            final NotificationRankingUpdate update2 = this.this$0.makeRankingUpdateLocked(info);     // Catch: Exception -> L10
            if (oldSbnVisible2 == false) goto L95;
            if (sbnVisible2 == true) goto L95;
            if (sendOldRedacted == false) goto L88;
            if (oldRedactedSbn != 0) goto L88;
            oldRedactedSbn = redactStatusBarNotification(oldSbn);     // Catch: Exception -> L10
        L90:
            if (sendOldRedacted == false) goto L92;
            final StatusBarNotification oldSbnLightClone = oldRedactedSbn.cloneLight();     // Catch: Exception -> L10
        L93:
            listenerCalls.add(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda9(this, info, oldSbnLightClone, update2));     // Catch: Exception -> L10
            redactedCache = redactedCache4;
            redactedSbn = redactedSbn;
            goto L19
        L92:
            oldSbnLightClone = oldSbn.cloneLight();     // Catch: Exception -> L10
        L88:
            oldRedactedSbn = oldRedactedSbn;
        L95:
            if (info.userid != (-1)) goto L97;
            int targetUserId = 0;
        L99:
            StatusBarNotification oldSbn2 = oldSbn;
            NotificationRecord r4 = r;
            this.this$0.updateUriPermissions(r4, old, info.component.getPackageName(), targetUserId);     // Catch: Exception -> L104
            this.this$0.mPackageManagerInternal.grantImplicitAccess(targetUserId, null, UserHandle.getAppId(info.uid), sbn.getUid(), false, false);     // Catch: Exception -> L104
            if (sendRedacted == false) goto L106;
            if (redactedSbn != 0) goto L106;
            redactedSbn = redactStatusBarNotification(sbn);     // Catch: Exception -> L104
            TrimCache redactedCache5 = new TrimCache(this.this$0, redactedSbn);     // Catch: Exception -> L104
        L107:
            if (sendRedacted == false) goto L109;
            final StatusBarNotification sbnToPost2 = redactedCache5.ForListener(info);     // Catch: Exception -> L104
        L110:
            StatusBarNotification sbn2 = sbn;
            listenerCalls.add(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda10(this, info, sbnToPost2, update2));     // Catch: Exception -> L104
            redactedCache = redactedCache5;
            oldSbn = oldSbn2;
            sbn = sbn2;
            oldRedactedSbn = oldRedactedSbn;
            goto L19
        L109:
            sbnToPost2 = trimCache.ForListener(info);     // Catch: Exception -> L104
        L106:
            redactedCache5 = redactedCache4;
            redactedSbn = redactedSbn;
        L104:
            e = e;
        L114:
            Slog.e(this.TAG, "Could not notify listeners for " + r4.getKey(), e);
            goto L115
        L97:
            targetUserId = info.userid;     // Catch: Exception -> L10
        L77:
            redactedCache4 = redactedCache3;
            goto L78
        L54:
            sbnToPost = trimCache.ForListener(info);     // Catch: Exception -> L10
        L51:
            redactedCache3 = redactedCache2;
        L37:
            oldSbnVisible = false;
            goto L39
        L36:
            sbnVisible2 = sbnVisible;
        L30:
            sendOldRedacted = false;
        L25:
            sendRedacted = false;
        L115:
            return listenerCalls;
        L16:
            redactionEnabled = false;
            goto L17
        L12:
            oldSbn = null;
        L10:
            e = e;
            r4 = r;
            goto L114
        L5:
            return new ArrayList();
        }

        private /* synthetic */ void lambda$prepareNotifyPostedLocked$1(ManagedServices.ManagedServiceInfo info, StatusBarNotification sbnToPost, NotificationRankingUpdate update) {
            notifyPosted(info, sbnToPost, update);
        }

        private /* synthetic */ void lambda$prepareNotifyPostedLocked$2(ManagedServices.ManagedServiceInfo info, StatusBarNotification oldSbnLightClone, NotificationRankingUpdate update) {
            notifyRemoved(info, oldSbnLightClone, update, null, 6);
        }

        private /* synthetic */ void lambda$prepareNotifyPostedLocked$3(ManagedServices.ManagedServiceInfo info, StatusBarNotification sbnToPost, NotificationRankingUpdate update) {
            notifyPosted(info, sbnToPost, update);
        }

        boolean isAppTrustedNotificationListenerService(int uid, String pkg) {
            long token = Binder.clearCallingIdentity();
        L15:
            th = move-exception;
            Throwable r11 = th;
        L49:
            Binder.restoreCallingIdentity(token);
            throw r11;
        L38:
            e = move-exception;
            RemoteException e = e;
        L45:
            Slog.e(this.TAG, "Failed to check trusted status of listener", e);     // Catch: Throwable -> L15
        L35:
            Binder.restoreCallingIdentity(token);
            return false;
        L36:
            th = move-exception;
            r11 = th;
            goto L49
        L4:
            if (this.this$0.mPackageManager.checkUidPermission("android.permission.RECEIVE_SENSITIVE_NOTIFICATIONS", uid) == 0) goto L42;
            if (this.this$0.mPackageManagerInternal.isPlatformSigned(pkg) == true) goto L42;
        L52:
        L17:
            e = move-exception;
            e = e;
            goto L45
        L10:
            if (NotificationManagerService.m6133$$Nest$fgetmAppOps(this.this$0).noteOpNoThrow(148, uid, pkg, null, null) == 0) goto L42;
            List<AssociationInfo> cdmAssocs = new ArrayList();     // Catch: Throwable -> L15 RemoteException -> L17
            if (this.this$0.mCompanionManager != null) goto L20;
            NotificationManagerService r12 = this.this$0;     // Catch: Throwable -> L15 RemoteException -> L17
            r12.mCompanionManager = this.this$0.getCompanionManager();     // Catch: Throwable -> L15 RemoteException -> L17
        L20:
            if (this.this$0.mCompanionManager == null) goto L22;
            cdmAssocs = this.this$0.mCompanionManager.getAllAssociationsForUser(UserHandle.getUserId(uid));     // Catch: Throwable -> L15 RemoteException -> L17
        L22:
            int i = 0;
        L23:
            if (i >= cdmAssocs.size()) goto L35;
            AssociationInfo assocInfo = cdmAssocs.get(i);     // Catch: Throwable -> L15 RemoteException -> L17
            if (assocInfo.isRevoked() == true) goto L33;
            if (pkg.equals(assocInfo.getPackageName()) == false) goto L33;
            if (assocInfo.getUserId() != UserHandle.getUserId(uid)) goto L33;
            Binder.restoreCallingIdentity(token);
            return true;
        L33:
            i = i + 1;
        L42:
            Binder.restoreCallingIdentity(token);
            return true;
        }

        StatusBarNotification redactStatusBarNotification(StatusBarNotification sbn) {
            ApplicationInfo appInfo = (ApplicationInfo) sbn.getNotification().extras.getParcelable("android.appInfo", ApplicationInfo.class);
            if (appInfo == null) goto L5;
            String pkgLabel = appInfo.loadLabel(NotificationManagerService.m6153$$Nest$fgetmPackageManagerClient(this.this$0)).toString();
        L6:
            CharSequence redactedText = this.mContext.getString(R.string.sms_control_no);
            Notification oldNotif = sbn.getNotification();
            Notification oldClone = new Notification();
            oldNotif.cloneInto(oldClone, false);
            Notification.Builder redactedNotifBuilder = new Notification.Builder(this.this$0.getContext(), oldClone);
            redactedNotifBuilder.setContentTitle(pkgLabel);
            redactedNotifBuilder.setContentText(redactedText);
            redactedNotifBuilder.setSubText(null);
            redactedNotifBuilder.setActions(new Notification.Action[0]);
            if (oldNotif.actions == null) goto L13;
            int i = 0;
        L10:
            if (i >= oldNotif.actions.length) goto L13;
            Notification.Action act = new Notification.Action.Builder(oldNotif.actions[i]).build();
            act.title = this.mContext.getString(R.string.sms_control_message);
            redactedNotifBuilder.addAction(act);
            i = i + 1;
        L13:
            if (oldNotif.isStyle(Notification.MessagingStyle.class) == false) goto L16;
            Person empty = new Person.Builder().setName("").build();
            Notification.MessagingStyle messageStyle = new Notification.MessagingStyle(empty);
            messageStyle.addMessage(new Notification.MessagingStyle.Message(redactedText, System.currentTimeMillis(), empty));
            redactedNotifBuilder.setStyle(messageStyle);
        L16:
            if (oldNotif.isStyle(Notification.BigTextStyle.class) == false) goto L18;
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.bigText(this.mContext.getString(R.string.sms_control_no));
            bigTextStyle.setBigContentTitle("");
            bigTextStyle.setSummaryText("");
            redactedNotifBuilder.setStyle(bigTextStyle);
        L18:
            Notification redacted = redactedNotifBuilder.build();
            if (redacted.extras.containsKey("android.title.big") == false) goto L21;
            redacted.extras.putString("android.title.big", pkgLabel);
        L21:
            redacted.extras.remove("android.subText");
            redacted.extras.remove("android.textLines");
            redacted.extras.remove("android.largeIcon.big");
            return sbn.cloneShallow(redacted);
        L5:
            String pkgLabel2 = this.TAG;
            Slog.w(pkgLabel2, "StatusBarNotification " + sbn + " does not have ApplicationInfo. Did you pass in a 'cloneLight' notification?");
            pkgLabel = sbn.getPackageName();
            goto L6
        }

        boolean hasSensitiveContent(NotificationRecord r) {
            if (r != null) goto L4;
            return false;
        L4:
            return r.hasSensitiveContent();
        }

        boolean isUidTrusted(int uid) {
            ArraySet<Integer> r0 = this.mTrustedListenerUids;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mTrustedListenerUids.contains(Integer.valueOf(uid)) == false) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        private void updateUriPermissionsForActiveNotificationsLocked(ManagedServices.ManagedServiceInfo info, boolean grant) {
            Iterator<NotificationRecord> r0 = this.this$0.mNotificationList.iterator();     // Catch: Exception -> L10
        L3:
            if (r0.hasNext() == false) goto L49;
            NotificationRecord r = r0.next();     // Catch: Exception -> L10
            if (grant == false) goto L13;
            if (this.this$0.isVisibleToListener(r.getSbn(), r.getNotificationType(), info) == false) goto L3;
        L13:
            if (r.isHidden() == false) goto L18;
            if (info.targetSdkVersion < 28) goto L3;
        L18:
            if (info.userid != (-1)) goto L21;
            int r1 = 0;
        L20:
            int targetUserId = r1;
            if (grant == true) goto L23;
            this.this$0.updateUriPermissions(null, r, info.component.getPackageName(), targetUserId, true);     // Catch: Exception -> L10
            goto L3
        L23:
            this.this$0.updateUriPermissions(r, null, info.component.getPackageName(), targetUserId);     // Catch: Exception -> L10
            goto L3
        L21:
            r1 = info.userid;     // Catch: Exception -> L10
            goto L20
        L49:
            return;
        L10:
            e = move-exception;
            String r2 = this.TAG;
            StringBuilder r3 = new StringBuilder();
            r3.append("Could not ");
            if (grant == false) goto L30;
            String r4 = "grant";
        L31:
            r3.append(r4);
            r3.append(" Uri permissions to ");
            r3.append(info.component);
            Slog.e(r2, r3.toString(), e);
            return;
        L30:
            r4 = "revoke";
            goto L31
        }

        public void notifyRemovedLocked(final NotificationRecord r, int reason, NotificationStats notificationStats) {
            final int r6 = reason;
            if (this.this$0.isInLockDownMode(r.getUser().getIdentifier()) == false) goto L5;
            return;
        L5:
            StatusBarNotification sbn = r.getSbn();
            StatusBarNotification sbnLight = sbn.cloneLight();
            StatusBarNotification redactedSbn = null;
            boolean hasSensitiveContent = hasSensitiveContent(r);
            Iterator<ManagedServices.ManagedServiceInfo> r10 = getServices().iterator();
        L7:
            if (r10.hasNext() == false) goto L40;
            final ManagedServices.ManagedServiceInfo info = r10.next();
            if (this.this$0.isVisibleToListener(sbn, r.getNotificationType(), info) == false) goto L7;
            if (r.isHidden() == false) goto L17;
            if (r6 == 14) goto L17;
            if (info.targetSdkVersion < 28) goto L7;
        L17:
            if (r6 != 14) goto L22;
            if (info.targetSdkVersion >= 28) goto L7;
        L22:
            if (hasSensitiveContent == true) goto L24;
        L26:
            boolean r1 = false;
        L27:
            boolean sendRedacted = r1;
            if (sendRedacted == false) goto L31;
            if (redactedSbn != null) goto L31;
            StatusBarNotification redactedSbn2 = redactStatusBarNotification(sbn);
            StatusBarNotification redactedSbn3 = redactedSbn2;
        L33:
            if (this.this$0.mAssistants.isServiceTokenValidLocked(info.service) == false) goto L35;
            final NotificationStats stats = notificationStats;
        L36:
            if (sendRedacted == false) goto L38;
            final StatusBarNotification sbnToSend = redactedSbn3;
        L39:
            final NotificationRankingUpdate update = this.this$0.makeRankingUpdateLocked(info);
            this.this$0.mHandler.post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda5(this, info, sbnToSend, update, stats, r6));
            r6 = reason;
            redactedSbn = redactedSbn3;
            goto L7
        L38:
            sbnToSend = sbnLight;
            goto L39
        L35:
            stats = null;
        L31:
            redactedSbn3 = redactedSbn;
            goto L33
        L24:
            if (isUidTrusted(info.uid) == true) goto L26;
            r1 = true;
            goto L27
        L40:
            this.this$0.mHandler.post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda6(this, r));
        }

        private /* synthetic */ void lambda$notifyRemovedLocked$4(ManagedServices.ManagedServiceInfo info, StatusBarNotification sbnToSend, NotificationRankingUpdate update, NotificationStats stats, int reason) {
            notifyRemoved(info, sbnToSend, update, stats, reason);
        }

        private /* synthetic */ void lambda$notifyRemovedLocked$5(NotificationRecord r) {
            this.this$0.updateUriPermissions(null, r, null, 0);
        }

        public void notifyRankingUpdateLocked(List<NotificationRecord> changedHiddenNotifications) {
            if (changedHiddenNotifications != null) goto L4;
        L6:
            boolean isHiddenRankingUpdate = false;
        L7:
            Iterator<ManagedServices.ManagedServiceInfo> r1 = getServices().iterator();
        L9:
            if (r1.hasNext() == false) goto L30;
            final ManagedServices.ManagedServiceInfo serviceInfo = r1.next();
            if (serviceInfo.isEnabledForUser() == false) goto L9;
            if (this.this$0.isInteractionVisibleToListener(serviceInfo, ActivityManager.getCurrentUser()) == false) goto L9;
            boolean notifyThisListener = false;
            if (isHiddenRankingUpdate == true) goto L18;
        L26:
            if (notifyThisListener == true) goto L28;
            if (isHiddenRankingUpdate == true) goto L9;
        L28:
            final NotificationRankingUpdate update = this.this$0.makeRankingUpdateLocked(serviceInfo);
            this.this$0.mHandler.post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda2(this, serviceInfo, update));
            goto L9
        L18:
            if (serviceInfo.targetSdkVersion < 28) goto L26;
            Iterator<NotificationRecord> r4 = changedHiddenNotifications.iterator();
        L21:
            if (r4.hasNext() == false) goto L26;
            NotificationRecord rec = r4.next();
            if (this.this$0.isVisibleToListener(rec.getSbn(), rec.getNotificationType(), serviceInfo) == false) goto L21;
            notifyThisListener = true;
            goto L26
        L30:
            return;
        L4:
            if (changedHiddenNotifications.size() <= 0) goto L6;
            isHiddenRankingUpdate = true;
            goto L7
        }

        private /* synthetic */ void lambda$notifyRankingUpdateLocked$6(ManagedServices.ManagedServiceInfo serviceInfo, NotificationRankingUpdate update) {
            notifyRankingUpdate(serviceInfo, update);
        }

        public void notifyListenerHintsChangedLocked(final int hints) {
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            final ManagedServices.ManagedServiceInfo serviceInfo = r0.next();
            if (serviceInfo.isEnabledForUser() == false) goto L4;
            if (this.this$0.isInteractionVisibleToListener(serviceInfo, ActivityManager.getCurrentUser()) == false) goto L4;
            this.this$0.mHandler.post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda3(this, serviceInfo, hints));
            goto L4
        }

        private /* synthetic */ void lambda$notifyListenerHintsChangedLocked$7(ManagedServices.ManagedServiceInfo serviceInfo, int hints) {
            notifyListenerHintsChanged(serviceInfo, hints);
        }

        public void notifyHiddenLocked(List<NotificationRecord> changedNotifications) {
            if (changedNotifications != null) goto L4;
            return;
        L4:
            if (changedNotifications.size() == 0) goto L13;
            notifyRankingUpdateLocked(changedNotifications);
            int numChangedNotifications = changedNotifications.size();
            int i = 0;
        L7:
            if (i >= numChangedNotifications) goto L10;
            NotificationRecord rec = changedNotifications.get(i);
            this.this$0.mListeners.notifyRemovedLocked(rec, 14, rec.getStats());
            i = i + 1;
            goto L7
        L10:
            return;
        }

        public void notifyUnhiddenLocked(List<NotificationRecord> changedNotifications) {
            if (changedNotifications != null) goto L4;
            return;
        L4:
            if (changedNotifications.size() == 0) goto L13;
            notifyRankingUpdateLocked(changedNotifications);
            int numChangedNotifications = changedNotifications.size();
            int i = 0;
        L7:
            if (i >= numChangedNotifications) goto L10;
            NotificationRecord rec = changedNotifications.get(i);
            notifyPostedLocked(rec, rec, false);
            i = i + 1;
            goto L7
        L10:
            return;
        }

        public void notifyInterruptionFilterChanged(final int interruptionFilter) {
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            final ManagedServices.ManagedServiceInfo serviceInfo = r0.next();
            if (serviceInfo.isEnabledForUser() == false) goto L4;
            if (this.this$0.isInteractionVisibleToListener(serviceInfo, ActivityManager.getCurrentUser()) == false) goto L4;
            this.this$0.mHandler.post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda7(this, serviceInfo, interruptionFilter));
            goto L4
        }

        private /* synthetic */ void lambda$notifyInterruptionFilterChanged$8(ManagedServices.ManagedServiceInfo serviceInfo, int interruptionFilter) {
            notifyInterruptionFilterChanged(serviceInfo, interruptionFilter);
        }

        protected void notifyNotificationChannelChanged(final String pkg, final UserHandle user, final NotificationChannel channel, final int modificationType) {
            if (channel != null) goto L4;
            return;
        L4:
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L6:
            if (r0.hasNext() == false) goto L14;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            if (info.enabledAndUserMatches(UserHandle.getCallingUserId()) == false) goto L6;
            if (this.this$0.isInteractionVisibleToListener(info, UserHandle.getCallingUserId()) == false) goto L6;
            BackgroundThread.getHandler().post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda1(this, info, pkg, user, channel, modificationType));
            goto L6
        }

        private /* synthetic */ void lambda$notifyNotificationChannelChanged$9(ManagedServices.ManagedServiceInfo info, String pkg, UserHandle user, NotificationChannel channel, int modificationType) {
            if (info.isSystem == false) goto L5;
        L8:
            notifyNotificationChannelChanged(info, pkg, user, channel, modificationType);
            return;
        L5:
            if (this.this$0.hasCompanionDevice(info) == true) goto L8;
            if (NotificationManagerService.m6220$$Nest$misNotificationAssistant(this.this$0, info.service) == true) goto L8;
        }

        protected void notifyNotificationChannelGroupChanged(final String pkg, final UserHandle user, final NotificationChannelGroup group, final int modificationType) {
            if (group != null) goto L4;
            return;
        L4:
            Iterator<ManagedServices.ManagedServiceInfo> r0 = getServices().iterator();
        L6:
            if (r0.hasNext() == false) goto L14;
            final ManagedServices.ManagedServiceInfo info = r0.next();
            if (info.enabledAndUserMatches(UserHandle.getCallingUserId()) == false) goto L6;
            if (this.this$0.isInteractionVisibleToListener(info, UserHandle.getCallingUserId()) == false) goto L6;
            BackgroundThread.getHandler().post(new NotificationManagerService$NotificationListeners$$ExternalSyntheticLambda4(this, info, pkg, user, group, modificationType));
            goto L6
        }

        private /* synthetic */ void lambda$notifyNotificationChannelGroupChanged$10(ManagedServices.ManagedServiceInfo info, String pkg, UserHandle user, NotificationChannelGroup group, int modificationType) {
            if (info.isSystem() == false) goto L5;
        L6:
            notifyNotificationChannelGroupChanged(info, pkg, user, group, modificationType);
            return;
        L5:
            if (this.this$0.hasCompanionDevice(info) == true) goto L6;
        }

        private void notifyPosted(ManagedServices.ManagedServiceInfo info, StatusBarNotification sbn, NotificationRankingUpdate rankingUpdate) {
            INotificationListener listener = info.service;
            StatusBarNotificationHolder sbnHolder = new StatusBarNotificationHolder(sbn);     // Catch: RemoteException -> L5 DeadObjectException -> L7
            listener.onNotificationPosted(sbnHolder, rankingUpdate);     // Catch: RemoteException -> L5 DeadObjectException -> L7
        L14:
            return;
        L7:
            ex = move-exception;
            Slog.wtf(this.TAG, "unable to notify listener (posted): " + info, ex);
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (posted): " + info, ex);
        }

        private void notifyRemoved(ManagedServices.ManagedServiceInfo info, StatusBarNotification sbn, NotificationRankingUpdate rankingUpdate, NotificationStats stats, int reason) {
            INotificationListener listener = info.service;
        L19:
            ex = move-exception;
            Slog.wtf(this.TAG, "unable to notify listener (removed): " + info, ex);
            return;
        L17:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (removed): " + info, ex);
            return;
        L4:
            if (CompatChanges.isChangeEnabled(NotificationManagerService.NOTIFICATION_CANCELLATION_REASONS, info.uid) == true) goto L11;
            if (reason != 20) goto L8;
        L9:
            reason = 17;
            goto L11
        L8:
            if (reason == 21) goto L9;
        L11:
            if (CompatChanges.isChangeEnabled(NotificationManagerService.NOTIFICATION_LOG_ASSISTANT_CANCEL, info.uid) == false) goto L13;
        L15:
            StatusBarNotificationHolder sbnHolder = new StatusBarNotificationHolder(sbn);     // Catch: RemoteException -> L17 DeadObjectException -> L19
            listener.onNotificationRemoved(sbnHolder, rankingUpdate, stats, reason);     // Catch: RemoteException -> L17 DeadObjectException -> L19
        L26:
            return;
        L13:
            if (reason != 22) goto L15;
            reason = 10;
            goto L15
        }

        private void notifyRankingUpdate(ManagedServices.ManagedServiceInfo info, NotificationRankingUpdate rankingUpdate) {
            INotificationListener listener = info.service;
            listener.onNotificationRankingUpdate(rankingUpdate);     // Catch: RemoteException -> L5 DeadObjectException -> L7
        L12:
            return;
        L7:
            ex = move-exception;
            Slog.wtf(this.TAG, "unable to notify listener (ranking update): " + info, ex);
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (ranking update): " + info, ex);
        }

        private void notifyListenerHintsChanged(ManagedServices.ManagedServiceInfo info, int hints) {
            INotificationListener listener = info.service;
            listener.onListenerHintsChanged(hints);     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (listener hints): " + info, ex);
        }

        private void notifyInterruptionFilterChanged(ManagedServices.ManagedServiceInfo info, int interruptionFilter) {
            INotificationListener listener = info.service;
            listener.onInterruptionFilterChanged(interruptionFilter);     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (interruption filter): " + info, ex);
        }

        void notifyNotificationChannelChanged(ManagedServices.ManagedServiceInfo info, String pkg, UserHandle user, NotificationChannel channel, int modificationType) {
            INotificationListener listener = info.service;
            listener.onNotificationChannelModification(pkg, user, channel, modificationType);     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (channel changed): " + info, ex);
        }

        private void notifyNotificationChannelGroupChanged(ManagedServices.ManagedServiceInfo info, String pkg, UserHandle user, NotificationChannelGroup group, int modificationType) {
            INotificationListener listener = info.getService();
            listener.onNotificationChannelGroupModification(pkg, user, group, modificationType);     // Catch: RemoteException -> L5
            return;
        L5:
            ex = move-exception;
            Slog.e(this.TAG, "unable to notify listener (channel group changed): " + info, ex);
        }

        public boolean isListenerPackage(String packageName) {
            if (packageName != null) goto L5;
            return false;
        L5:
            Object r1 = this.this$0.mNotificationLock;
            monitor-enter(r1);
            Iterator<ManagedServices.ManagedServiceInfo> r2 = getServices().iterator();     // Catch: Throwable -> L15
        L9:
            if (r2.hasNext() == false) goto L18;
            ManagedServices.ManagedServiceInfo serviceInfo = r2.next();     // Catch: Throwable -> L15
            if (packageName.equals(serviceInfo.component.getPackageName()) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L15
            return true;
        L18:
            monitor-exit(r1);     // Catch: Throwable -> L15
            return false;
        L15:
            th = move-exception;
            throw th;
        }

        boolean hasAllowedListener(String packageName, int userId) {
            if (packageName != null) goto L5;
            return false;
        L5:
            List<ComponentName> allowedComponents = getAllowedComponents(userId);
            int i = 0;
        L7:
            if (i >= allowedComponents.size()) goto L14;
            if (allowedComponents.get(i).getPackageName().equals(packageName) == true) goto L10;
            i = i + 1;
            goto L7
        L10:
            return true;
        L14:
            return false;
        }
    }

    private class NotificationTrampolineCallback implements BackgroundActivityStartCallback {
        final /* synthetic */ NotificationManagerService this$0;

        /* synthetic */ NotificationTrampolineCallback(NotificationManagerService r1, NotificationManagerServiceIA r2) {
            this(r1);
        }

        private NotificationTrampolineCallback(NotificationManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.wm.BackgroundActivityStartCallback
        public BackgroundActivityStartCallback.BackgroundActivityStartCallbackResult isActivityStartAllowed(Collection<IBinder> tokens, int uid, String packageName) {
            Preconditions.checkArgument(!tokens.isEmpty());
            Iterator<IBinder> r0 = tokens.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            IBinder token = r0.next();
            if (token == NotificationManagerService.ALLOWLIST_TOKEN) goto L4;
            return BackgroundActivityStartCallback.RESULT_TRUE;
        L10:
            String logcatMessage = "Indirect notification activity start (trampoline) from " + packageName;
            if (blockTrampoline(uid) == false) goto L14;
            Slog.e(NotificationManagerService.TAG, logcatMessage + " blocked");
            return BackgroundActivityStartCallback.RESULT_FALSE;
        L14:
            Slog.w(NotificationManagerService.TAG, logcatMessage + ", this should be avoided for performance reasons");
            return new BackgroundActivityStartCallback.BackgroundActivityStartCallbackResult(true, NotificationManagerService.ALLOWLIST_TOKEN);
        }

        private boolean blockTrampoline(int uid) {
            if (NotificationManagerService.m6159$$Nest$fgetmRoleObserver(this.this$0) == null) goto L9;
            if (NotificationManagerService.m6159$$Nest$fgetmRoleObserver(this.this$0).isUidExemptFromTrampolineRestrictions(uid) == false) goto L9;
            return CompatChanges.isChangeEnabled(NotificationManagerService.NOTIFICATION_TRAMPOLINE_BLOCK_FOR_EXEMPT_ROLES, uid);
        L9:
            return CompatChanges.isChangeEnabled(NotificationManagerService.NOTIFICATION_TRAMPOLINE_BLOCK, uid);
        }

        @Override // com.android.server.wm.BackgroundActivityStartCallback
        public boolean canCloseSystemDialogs(Collection<IBinder> tokens, int uid) {
            if (tokens.contains(NotificationManagerService.ALLOWLIST_TOKEN) == true) goto L5;
        L7:
            return false;
        L5:
            if (CompatChanges.isChangeEnabled(NotificationManagerService.NOTIFICATION_TRAMPOLINE_BLOCK, uid) == true) goto L7;
            return true;
        }
    }

    private interface NotificationUpdate {
        void apply(NotificationRecord r1, boolean r2);
    }

    protected class PostNotificationRunnable implements Runnable {
        private final String key;
        private final PostNotificationTracker mTracker;
        private final String pkg;
        final /* synthetic */ NotificationManagerService this$0;
        private final int uid;

        /* JADX INFO: renamed from: com.android.server.notification.NotificationManagerService$PostNotificationRunnable$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ PostNotificationRunnable this$1;
            final /* synthetic */ NotificationRecord val$r;

            AnonymousClass1(PostNotificationRunnable this$1, NotificationRecord r2) {
                this.this$1 = this$1;
                this.val$r = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$1.this$0).onNotificationRemoved(this.val$r);
            }
        }

        public static /* synthetic */ void $r8$lambda$jV8WYuiOwpgtNEMlkEaZb1iQHxs(PostNotificationRunnable r0) {
            r0.lambda$postNotification$0();
        }

        public static /* synthetic */ void $r8$lambda$kfFWmcqs_JJRFSKEAIhRLjgjo94(PostNotificationRunnable r0, NotificationRecord r1) {
            r0.lambda$postNotification$3(r1);
        }

        PostNotificationRunnable(NotificationManagerService this$0, String key, String pkg, int uid, PostNotificationTracker tracker) {
            this.this$0 = this$0;
            this.key = key;
            this.pkg = pkg;
            this.uid = uid;
            this.mTracker = (PostNotificationTracker) Preconditions.checkNotNull(tracker);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean posted = false;
            posted = postNotification();     // Catch: Throwable -> L9 Exception -> L11
            if (posted == false) goto L13;
            IAppRecordManagerService appRecordManagerService = SysOptBridge.getFactory().getAppRecordManagerService();     // Catch: Throwable -> L9 Exception -> L11
            if (appRecordManagerService == null) goto L13;
            appRecordManagerService.noteNotification(this.uid, this.pkg);     // Catch: Throwable -> L9 Exception -> L11
        L13:
            if (posted == true) goto L19;
        L14:
            this.mTracker.cancel();
            return;
        L19:
            return;
        L11:
            e = move-exception;
            Slog.e(NotificationManagerService.TAG, "Error posting", e);     // Catch: Throwable -> L9
            if (posted == false) goto L14;
            return;
        L9:
            th = move-exception;
            if (posted == true) goto L22;
            this.mTracker.cancel();
        L22:
            throw th;
        }

        /* JADX WARN: Not initialized variable reg: 20, insn: 0x0361: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r20 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('posted' boolean)]), block:B:144:0x0361 */
        private boolean postNotification() {
            boolean appBanned = !NotificationManagerService.m6178$$Nest$mareNotificationsEnabledForPackageInt(this.this$0, this.uid);
            boolean isCallNotification = NotificationManagerService.m6216$$Nest$misCallNotification(this.this$0, this.pkg, this.uid);
            boolean posted = false;
            Object r6 = this.this$0.mNotificationLock;
            monitor-enter(r6);
            final NotificationRecord r = NotificationManagerService.m6247$$Nest$smfindNotificationByListLocked(this.this$0.mEnqueuedNotifications, this.key);     // Catch: Throwable -> L181
            boolean r0 = false;
            if (r != null) goto L20;
            Slog.i(NotificationManagerService.TAG, "Cannot find enqueued record for key: " + this.key);     // Catch: Throwable -> L18
            int N = this.this$0.mEnqueuedNotifications.size();     // Catch: Throwable -> L13
            int i = 0;
        L9:
            if (i >= N) goto L16;
            NotificationRecord enqueued = this.this$0.mEnqueuedNotifications.get(i);     // Catch: Throwable -> L13
            if (Objects.equals(this.key, enqueued.getKey()) == true) goto L12;
            i = i + 1;     // Catch: Throwable -> L13
            goto L9
        L12:
            this.this$0.mEnqueuedNotifications.remove(i);     // Catch: Throwable -> L13
        L16:
            monitor-exit(r6);     // Catch: Throwable -> L13
            return false;
        L20:
            StatusBarNotification n = r.getSbn();     // Catch: Throwable -> L181
            Notification notification = n.getNotification();     // Catch: Throwable -> L181
            if (isCallNotification == true) goto L24;
        L26:
            boolean r7 = false;
        L27:
            boolean isCallNotificationAndCorrectStyle = r7;
            if (notification.isMediaNotification() == true) goto L48;
            if (isCallNotificationAndCorrectStyle == true) goto L48;
            if (appBanned == false) goto L33;
        L34:
            this.this$0.mUsageStats.registerBlocked(r);     // Catch: Throwable -> L18
            if (NotificationManagerService.DBG == false) goto L38;
            Slog.e(NotificationManagerService.TAG, "Suppressing notification from package " + this.pkg);     // Catch: Throwable -> L18
        L38:
            int N2 = this.this$0.mEnqueuedNotifications.size();     // Catch: Throwable -> L13
            int i2 = 0;
        L39:
            if (i2 >= N2) goto L44;
            NotificationRecord enqueued2 = this.this$0.mEnqueuedNotifications.get(i2);     // Catch: Throwable -> L13
            if (Objects.equals(this.key, enqueued2.getKey()) == true) goto L42;
            i2 = i2 + 1;     // Catch: Throwable -> L13
            goto L39
        L42:
            this.this$0.mEnqueuedNotifications.remove(i2);     // Catch: Throwable -> L13
        L44:
            monitor-exit(r6);     // Catch: Throwable -> L13
            return false;
        L33:
            if (this.this$0.isRecordBlockedLocked(r) == true) goto L34;
        L48:
            if (NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).isUpdateForCanceledSummary(r) == false) goto L68;
            if (NotificationManagerService.DBG == false) goto L52;
            Log.w(NotificationManagerService.TAG, "Suppressing notification because summary was canceled: " + r);     // Catch: Throwable -> L18
        L52:
            String groupKey = r.getGroupKey();     // Catch: Throwable -> L18
            NotificationRecord groupSummary = this.this$0.mSummaryByGroupKey.get(groupKey);     // Catch: Throwable -> L18
            if (groupSummary != null) goto L55;
        L58:
            int N3 = this.this$0.mEnqueuedNotifications.size();     // Catch: Throwable -> L13
            int i3 = 0;
        L59:
            if (i3 >= N3) goto L64;
            NotificationRecord enqueued3 = this.this$0.mEnqueuedNotifications.get(i3);     // Catch: Throwable -> L13
            boolean r16 = r0;
            if (Objects.equals(this.key, enqueued3.getKey()) == true) goto L62;
            i3 = i3 + 1;     // Catch: Throwable -> L13
            r0 = r16;
            goto L59
        L62:
            this.this$0.mEnqueuedNotifications.remove(i3);     // Catch: Throwable -> L13
        L65:
            monitor-exit(r6);     // Catch: Throwable -> L13
            return r16;
        L64:
            r16 = r0;
            goto L65
        L55:
            if (groupSummary.getKey().equals(r.getKey()) == false) goto L58;
            this.this$0.mSummaryByGroupKey.remove(groupKey);     // Catch: Throwable -> L18
            goto L58
        L68:
            boolean isPackageSuspended = this.this$0.isPackagePausedOrSuspended(r.getSbn().getPackageName(), r.getUid());     // Catch: Throwable -> L181
            r.setHidden(isPackageSuspended);     // Catch: Throwable -> L181
            if (isPackageSuspended == false) goto L71;
            this.this$0.mUsageStats.registerSuspendedByAdmin(r);     // Catch: Throwable -> L18
        L71:
            NotificationRecord old = this.this$0.mNotificationsByKey.get(this.key);     // Catch: Throwable -> L181
            if (old == null) goto L78;
            if (old.getSbn().getInstanceId() == null) goto L78;
            n.setInstanceId(old.getSbn().getInstanceId());     // Catch: Throwable -> L18
        L79:
            int index = this.this$0.indexOfNotificationLocked(n.getKey());     // Catch: Throwable -> L181
            if (index < 0) goto L196;
            StatusBarNotification r3 = null;
            NotificationRecord old2 = this.this$0.mNotificationList.get(index);     // Catch: Throwable -> L145
            this.this$0.mNotificationList.set(index, r);     // Catch: Throwable -> L145
            this.this$0.mUsageStats.registerUpdatedByApp(r, old2);     // Catch: Throwable -> L145
            NotificationManagerService.m6169$$Nest$fgetmUsageStatsManagerInternal(this.this$0).reportNotificationUpdated(r.getSbn().getOpPkg(), r.getSbn().getUser(), this.mTracker.getStartTime());     // Catch: Throwable -> L145
            notification.flags |= old2.getNotification().flags & 64;     // Catch: Throwable -> L145
            r.isUpdate = true;     // Catch: Throwable -> L145
            boolean isInterruptive = this.this$0.isVisuallyInterruptive(old2, r);     // Catch: Throwable -> L145
            r.setTextChanged(isInterruptive);     // Catch: Throwable -> L145
            if (isInterruptive == false) goto L93;
            r.resetRankingTime();     // Catch: Throwable -> L85
        L93:
            NotificationRecord old3 = old2;
        L94:
            this.this$0.mNotificationsByKey.put(n.getKey(), r);     // Catch: Throwable -> L145
            if ((notification.flags & 64) == 0) goto L193;
            notification.flags |= 32;     // Catch: Throwable -> L85
        L193:
            if (notification.getSmallIcon() != null) goto L102;
        L147:
            old3 = old3;
            posted = false;
        L148:
            this.this$0.mRankingHelper.extractSignals(r);     // Catch: Throwable -> L143
            this.this$0.mRankingHelper.sort(this.this$0.mNotificationList);     // Catch: Throwable -> L143
            int position = this.this$0.mRankingHelper.indexOf(this.this$0.mNotificationList, r);     // Catch: Throwable -> L143
            if (r.isHidden() == true) goto L151;
            int buzzBeepBlinkLoggingCode = this.this$0.mAttentionHelper.buzzBeepBlinkLocked(r, new NotificationAttentionHelper.Signals(NotificationManagerService.m6170$$Nest$fgetmUserProfiles(this.this$0).isCurrentProfile(r.getUserId()), NotificationManagerService.m6144$$Nest$fgetmListenerHints(this.this$0)));     // Catch: Throwable -> L143
            int buzzBeepBlinkLoggingCode2 = buzzBeepBlinkLoggingCode;
        L153:
            if (notification.getSmallIcon() == null) goto L158;
            NotificationRecord old4 = old3;
            NotificationRecordLogger.NotificationReported maybeReport = NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).prepareToLogNotificationPosted(r, old4, position, buzzBeepBlinkLoggingCode2, this.this$0.getGroupInstanceId(r.getSbn().getGroupKey()));     // Catch: Throwable -> L143
            NotificationManagerService.m6226$$Nest$mnotifyListenersPostedAndLogLocked(this.this$0, r, old4, this.mTracker, maybeReport);     // Catch: Throwable -> L143
            boolean posted2 = true;
            NotificationManagerService.m6234$$Nest$mreportNavigationFgsNotificationIfNeeded(this.this$0, r, true);     // Catch: Throwable -> L85
        L167:
            if (NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0) == null) goto L169;
            NotificationManagerService.m6161$$Nest$fgetmShortcutHelper(this.this$0).maybeListenForShortcutChangesForBubbles(r, false);     // Catch: Throwable -> L85
        L169:
            this.this$0.maybeRecordInterruptionLocked(r);     // Catch: Throwable -> L85
            this.this$0.maybeRegisterMessageSent(r);     // Catch: Throwable -> L85
            this.this$0.maybeReportForegroundServiceUpdate(r, true);     // Catch: Throwable -> L85
            int N4 = this.this$0.mEnqueuedNotifications.size();     // Catch: Throwable -> L175
            int i4 = 0;
        L171:
            if (i4 >= N4) goto L179;
            NotificationRecord enqueued4 = this.this$0.mEnqueuedNotifications.get(i4);     // Catch: Throwable -> L175
            if (Objects.equals(this.key, enqueued4.getKey()) == true) goto L174;
            i4 = i4 + 1;     // Catch: Throwable -> L175
            goto L171
        L174:
            this.this$0.mEnqueuedNotifications.remove(i4);     // Catch: Throwable -> L175
        L179:
            monitor-exit(r6);     // Catch: Throwable -> L175
            return posted2;
        L158:
            NotificationRecord old5 = old3;
            Slog.e(NotificationManagerService.TAG, "Not posting notification without small icon: " + notification);     // Catch: Throwable -> L143
            if (old5 != null) goto L162;
        L164:
            this.this$0.notifyCallNotificationEventListenerOnRemoved(r);     // Catch: Throwable -> L143
            Slog.e(NotificationManagerService.TAG, "WARNING: In a future release this will crash the app: " + n.getPackageName());     // Catch: Throwable -> L143
            posted2 = posted;
            goto L167
        L162:
            if (old5.isCanceled == true) goto L164;
            this.this$0.mListeners.notifyRemovedLocked(r, 4, r.getStats());     // Catch: Throwable -> L143
            this.this$0.mHandler.post(new NotificationManagerService$PostNotificationRunnable$$ExternalSyntheticLambda1(this, r));     // Catch: Throwable -> L143
            goto L164
        L151:
            buzzBeepBlinkLoggingCode2 = 0;
            goto L153
        L102:
            if (NotificationManagerService.m6219$$Nest$misCritical(this.this$0, r) == true) goto L147;
            if (old3 == null) goto L105;
            StatusBarNotification oldSbn = old3.getSbn();     // Catch: Throwable -> L85
        L106:
            if (oldSbn != null) goto L108;
        L117:
            Object r4 = this.this$0.mNotificationLock;     // Catch: Throwable -> L145
            monitor-enter(r4);     // Catch: Throwable -> L145
            String autogroupName = GroupHelper.getFullAggregateGroupKey(r);     // Catch: Throwable -> L139
            boolean willBeAutogrouped = NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).onNotificationPosted(r, NotificationManagerService.m6213$$Nest$mhasAutoGroupSummaryLocked(this.this$0, r));     // Catch: Throwable -> L139
            if (willBeAutogrouped == false) goto L205;
            this.this$0.addAutogroupKeyLocked(this.key, autogroupName, false);     // Catch: Throwable -> L125
        L133:
            monitor-exit(r4);     // Catch: Throwable -> L135
        L125:
            th = th;
        L141:
            monitor-exit(r4);     // Catch: Throwable -> L135
            throw th;     // Catch: Throwable -> L143
        L127:
            th = th;
            goto L141
        L205:
            this.this$0.mHandler.postDelayed(new NotificationManagerService$PostNotificationRunnable$$ExternalSyntheticLambda0(this), this.key, 3000);     // Catch: Throwable -> L135
        L137:
            th = th;
        L139:
            th = th;
        L135:
            th = th;
            goto L141
        L108:
            if (Objects.equals(oldSbn.getGroup(), n.getGroup()) == false) goto L117;
            if (Objects.equals(oldSbn.getNotification().getGroup(), n.getNotification().getGroup()) == false) goto L117;
            if (oldSbn.getNotification().flags != n.getNotification().flags) goto L117;
            if (old3.getChannel().getId().equals(r.getChannel().getId()) == false) goto L117;
            old3 = old3;
            posted = false;
            goto L148
        L105:
            oldSbn = r3;
        L143:
            th = th;
        L183:
            int N5 = this.this$0.mEnqueuedNotifications.size();     // Catch: Throwable -> L175
            int i5 = 0;
        L184:
            if (i5 >= N5) goto L190;
            NotificationRecord enqueued5 = this.this$0.mEnqueuedNotifications.get(i5);     // Catch: Throwable -> L175
            if (Objects.equals(this.key, enqueued5.getKey()) == true) goto L188;
            i5 = i5 + 1;     // Catch: Throwable -> L175
            goto L184
        L188:
            this.this$0.mEnqueuedNotifications.remove(i5);     // Catch: Throwable -> L175
        L190:
            throw th;     // Catch: Throwable -> L175
        L145:
            th = th;
            goto L183
        L196:
            this.this$0.mNotificationList.add(r);     // Catch: Throwable -> L87
            this.this$0.mUsageStats.registerPostedByApp(r);     // Catch: Throwable -> L87
            NotificationManagerService.m6169$$Nest$fgetmUsageStatsManagerInternal(this.this$0).reportNotificationPosted(r.getSbn().getOpPkg(), r.getSbn().getUser(), this.mTracker.getStartTime());     // Catch: Throwable -> L85
            r3 = null;
            boolean isInterruptive2 = this.this$0.isVisuallyInterruptive(null, r);     // Catch: Throwable -> L85
            r.setInterruptive(isInterruptive2);     // Catch: Throwable -> L85
            r.setTextChanged(isInterruptive2);     // Catch: Throwable -> L85
            old3 = old;
        L87:
            th = th;
        L85:
            th = th;
        L78:
            n.setInstanceId(NotificationManagerService.m6149$$Nest$fgetmNotificationInstanceIdSequence(this.this$0).newInstanceId());     // Catch: Throwable -> L181
            goto L79
        L24:
            if (notification.isStyle(Notification.CallStyle.class) == false) goto L26;
            r7 = true;
        L13:
            th = th;
        L191:
            monitor-exit(r6);     // Catch: Throwable -> L175
            throw th;
        L18:
            th = th;
        L175:
            th = th;
        L181:
            th = th;
            goto L183
        }

        private /* synthetic */ void lambda$postNotification$0() {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord record = this.this$0.mNotificationsByKey.get(this.key);     // Catch: Throwable -> L7
            if (record == null) goto L9;
            NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).onNotificationPostedWithDelay(record, this.this$0.mNotificationList, this.this$0.mSummaryByGroupKey);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$postNotification$1(NotificationRecord r) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).onNotificationPosted(r, NotificationManagerService.m6213$$Nest$mhasAutoGroupSummaryLocked(this.this$0, r));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$postNotification$2() {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord record = this.this$0.mNotificationsByKey.get(this.key);     // Catch: Throwable -> L7
            if (record == null) goto L9;
            NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).onNotificationPostedWithDelay(record, this.this$0.mNotificationList, this.this$0.mSummaryByGroupKey);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$postNotification$3(NotificationRecord r) {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationManagerService.m6140$$Nest$fgetmGroupHelper(this.this$0).onNotificationRemoved(r, this.this$0.mNotificationList, false);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class PostNotificationTracker {
        private final List<Runnable> mCleanupRunnables;
        private boolean mOngoing;
        private final long mStartTime;
        private final PowerManager.WakeLock mWakeLock;

        public static /* synthetic */ void $r8$lambda$Sj35ThxKAaMQVMJuJW7BiRrLEAE(PostNotificationTracker r0) {
            r0.lambda$cancel$0();
        }

        public static /* synthetic */ void $r8$lambda$utPF6Nzeh5_1soUTRhYEbXDXUko(PostNotificationTracker r0) {
            r0.lambda$finish$1();
        }

        PostNotificationTracker(PowerManager.WakeLock wakeLock) {
            this.mStartTime = SystemClock.elapsedRealtime();
            this.mWakeLock = wakeLock;
            this.mOngoing = true;
            this.mCleanupRunnables = new ArrayList();
            if (NotificationManagerService.DBG == false) goto L6;
            Slog.d(NotificationManagerService.TAG, "PostNotification: Started");
            return;
        }

        void addCleanupRunnable(Runnable runnable) {
            this.mCleanupRunnables.add(runnable);
        }

        long getStartTime() {
            return this.mStartTime;
        }

        boolean isOngoing() {
            return this.mOngoing;
        }

        void cancel() {
            if (isOngoing() == true) goto L6;
            Log.wtfStack(NotificationManagerService.TAG, "cancel() called on already-finished tracker");
            return;
        L6:
            this.mOngoing = false;
            if (this.mWakeLock == null) goto L9;
            Binder.withCleanCallingIdentity(new NotificationManagerService$PostNotificationTracker$$ExternalSyntheticLambda0(this));
        L9:
            Iterator<Runnable> r0 = this.mCleanupRunnables.iterator();
        L11:
            if (r0.hasNext() == false) goto L14;
            Runnable r = r0.next();
            r.run();
            goto L11
        L14:
            if (NotificationManagerService.DBG == false) goto L18;
            long elapsedTime = SystemClock.elapsedRealtime() - this.mStartTime;
            Slog.d(NotificationManagerService.TAG, TextUtils.formatSimple("PostNotification: Abandoned after %d ms", new Object[]{Long.valueOf(elapsedTime)}));
            return;
        }

        private /* synthetic */ void lambda$cancel$0() throws Exception {
            this.mWakeLock.release();
        }

        long finish() {
            long elapsedTime = SystemClock.elapsedRealtime() - this.mStartTime;
            if (isOngoing() == true) goto L6;
            Log.wtfStack(NotificationManagerService.TAG, "finish() called on already-finished tracker");
            return elapsedTime;
        L6:
            this.mOngoing = false;
            if (this.mWakeLock == null) goto L9;
            Binder.withCleanCallingIdentity(new NotificationManagerService$PostNotificationTracker$$ExternalSyntheticLambda1(this));
        L9:
            Iterator<Runnable> r2 = this.mCleanupRunnables.iterator();
        L11:
            if (r2.hasNext() == false) goto L14;
            Runnable r = r2.next();
            r.run();
            goto L11
        L14:
            if (NotificationManagerService.DBG == false) goto L16;
            Slog.d(NotificationManagerService.TAG, TextUtils.formatSimple("PostNotification: Finished in %d ms", new Object[]{Long.valueOf(elapsedTime)}));
        L16:
            return elapsedTime;
        }

        private /* synthetic */ void lambda$finish$1() throws Exception {
            this.mWakeLock.release();
        }
    }

    interface PostNotificationTrackerFactory {
        default PostNotificationTracker newTracker(PowerManager.WakeLock optionalWakelock) {
            return new PostNotificationTracker(optionalWakelock);
        }
    }

    private final class RankingHandlerWorker extends Handler implements RankingHandler {
        final /* synthetic */ NotificationManagerService this$0;

        public RankingHandlerWorker(NotificationManagerService r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1000: goto L6;
                case 1001: goto L5;
                default: goto L9;
            };
        L5:
            this.this$0.handleRankingSort();
            return;
        L6:
            NotificationManagerService.m6211$$Nest$mhandleRankingReconsideration(this.this$0, msg);
            return;
        }

        @Override // com.android.server.notification.RankingHandler
        public void requestSort() {
            removeMessages(1001);
            Message msg = Message.obtain();
            msg.what = 1001;
            sendMessage(msg);
        }

        @Override // com.android.server.notification.RankingHandler
        public void requestReconsideration(RankingReconsideration recon) {
            Message m = Message.obtain(this, 1000, recon);
            long delay = recon.getDelay(TimeUnit.MILLISECONDS);
            sendMessageDelayed(m, delay);
        }
    }

    class RoleObserver implements OnRoleHoldersChangedListener {
        private final Executor mExecutor;
        private final Looper mMainLooper;
        private ArrayMap<String, ArrayMap<Integer, ArraySet<String>>> mNonBlockableDefaultApps;
        private final IPackageManager mPm;
        private final RoleManager mRm;
        private volatile ArraySet<Integer> mTrampolineExemptUids;
        final /* synthetic */ NotificationManagerService this$0;

        RoleObserver(NotificationManagerService this$0, Context context, RoleManager roleManager, IPackageManager pkgMgr, Looper mainLooper) {
            this.this$0 = this$0;
            this.mTrampolineExemptUids = new ArraySet();
            this.mRm = roleManager;
            this.mPm = pkgMgr;
            this.mExecutor = context.getMainExecutor();
            this.mMainLooper = mainLooper;
        }

        public void init() {
            List<UserHandle> users = NotificationManagerService.m6167$$Nest$fgetmUm(this.this$0).getUserHandles(true);
            this.mNonBlockableDefaultApps = new ArrayMap();
            int i = 0;
        L4:
            if (i >= NotificationManagerService.NON_BLOCKABLE_DEFAULT_ROLES.length) goto L18;
            String role = NotificationManagerService.NON_BLOCKABLE_DEFAULT_ROLES[i];
            ArrayMap<Integer, ArraySet<String>> userToApprovedList = new ArrayMap();
            this.mNonBlockableDefaultApps.put(role, userToApprovedList);
            int j = 0;
        L7:
            if (j >= users.size()) goto L17;
            int userId = users.get(j).getIdentifier();
            ArraySet<String> approvedForUserId = new ArraySet(this.mRm.getRoleHoldersAsUser(role, UserHandle.of(userId)));
            ArraySet<Pair<String, Integer>> approvedAppUids = new ArraySet();
            Iterator<String> r8 = approvedForUserId.iterator();
        L10:
            if (r8.hasNext() == false) goto L16;
            String pkg = r8.next();
            int uid = getUidForPackage(pkg, userId);
            if (uid != (-1)) goto L13;
            Slog.e(NotificationManagerService.TAG, "init: Invalid package for role " + role + " (user " + userId + "): " + pkg);
            goto L10
        L13:
            approvedAppUids.add(new Pair(pkg, Integer.valueOf(uid)));
            goto L10
        L16:
            userToApprovedList.put(Integer.valueOf(userId), approvedForUserId);
            this.this$0.mPreferencesHelper.updateDefaultApps(userId, null, approvedAppUids);
            j = j + 1;
            goto L7
        L17:
            i = i + 1;
            goto L4
        L18:
            updateTrampolineExemptUidsForUsers((UserHandle[]) users.toArray(new UserHandle[0]));
            this.mRm.addOnRoleHoldersChangedListenerAsUser(this.mExecutor, this, UserHandle.ALL);
        }

        void destroy() {
            this.mRm.removeOnRoleHoldersChangedListenerAsUser(this, UserHandle.ALL);
        }

        public boolean isApprovedPackageForRoleForUser(String role, String pkg, int userId) {
            return this.mNonBlockableDefaultApps.get(role).get(Integer.valueOf(userId)).contains(pkg);
        }

        public boolean isUidExemptFromTrampolineRestrictions(int uid) {
            return this.mTrampolineExemptUids.contains(Integer.valueOf(uid));
        }

        public void onRoleHoldersChanged(String roleName, UserHandle user) {
            onRoleHoldersChangedForNonBlockableDefaultApps(roleName, user);
            onRoleHoldersChangedForTrampolines(roleName, user);
        }

        private void onRoleHoldersChangedForNonBlockableDefaultApps(String roleName, UserHandle user) {
            boolean relevantChange = false;
            int i = 0;
        L4:
            if (i >= NotificationManagerService.NON_BLOCKABLE_DEFAULT_ROLES.length) goto L9;
            if (NotificationManagerService.NON_BLOCKABLE_DEFAULT_ROLES[i].equals(roleName) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            relevantChange = true;
        L9:
            if (relevantChange == true) goto L11;
            return;
        L11:
            ArraySet<String> roleHolders = new ArraySet(this.mRm.getRoleHoldersAsUser(roleName, user));
            ArrayMap<Integer, ArraySet<String>> prevApprovedForRole = this.mNonBlockableDefaultApps.getOrDefault(roleName, new ArrayMap());
            ArraySet<String> previouslyApproved = prevApprovedForRole.getOrDefault(Integer.valueOf(user.getIdentifier()), new ArraySet());
            ArraySet<String> toRemove = new ArraySet();
            ArraySet<Pair<String, Integer>> toAdd = new ArraySet();
            Iterator<String> r6 = previouslyApproved.iterator();
        L13:
            if (r6.hasNext() == false) goto L18;
            String previous = r6.next();
            if (roleHolders.contains(previous) == true) goto L13;
            toRemove.add(previous);
            goto L13
        L18:
            Iterator<String> r7 = roleHolders.iterator();
        L20:
            if (r7.hasNext() == false) goto L28;
            String nowApproved = r7.next();
            if (previouslyApproved.contains(nowApproved) == true) goto L20;
            int uid = getUidForPackage(nowApproved, user.getIdentifier());
            if (uid != (-1)) goto L25;
            Slog.e(NotificationManagerService.TAG, "onRoleHoldersChanged: Invalid package for role " + roleName + " (user " + user.getIdentifier() + "): " + nowApproved);
            goto L20
        L25:
            toAdd.add(new Pair(nowApproved, Integer.valueOf(uid)));
            goto L20
        L28:
            prevApprovedForRole.put(Integer.valueOf(user.getIdentifier()), roleHolders);
            this.mNonBlockableDefaultApps.put(roleName, prevApprovedForRole);
            this.this$0.mPreferencesHelper.updateDefaultApps(user.getIdentifier(), toRemove, toAdd);
        }

        private void onRoleHoldersChangedForTrampolines(String roleName, UserHandle user) {
            if ("android.app.role.BROWSER".equals(roleName) == true) goto L5;
            return;
        L5:
            updateTrampolineExemptUidsForUsers(new UserHandle[]{user});
        }

        private void updateTrampolineExemptUidsForUsers(UserHandle... users) {
            Preconditions.checkState(this.mMainLooper.isCurrentThread());
            ArraySet<Integer> oldUids = this.mTrampolineExemptUids;
            ArraySet<Integer> newUids = new ArraySet();
            int i = 0;
            int n = oldUids.size();
        L3:
            if (i >= n) goto L8;
            int uid = oldUids.valueAt(i).intValue();
            if (ArrayUtils.contains(users, UserHandle.of(UserHandle.getUserId(uid))) == true) goto L7;
            newUids.add(Integer.valueOf(uid));
        L7:
            i = i + 1;
            goto L3
        L8:
            int i2 = 0;
            int n2 = users.length;
        L9:
            if (i2 >= n2) goto L19;
            UserHandle user = users[i2];
            Iterator r5 = this.mRm.getRoleHoldersAsUser("android.app.role.BROWSER", user).iterator();
        L12:
            if (r5.hasNext() == false) goto L18;
            String pkg = (String) r5.next();
            int uid2 = getUidForPackage(pkg, user.getIdentifier());
            if (uid2 != (-1)) goto L15;
            Slog.e(NotificationManagerService.TAG, "updateTrampoline: Invalid package for role android.app.role.BROWSER (user " + user.getIdentifier() + "): " + pkg);
            goto L12
        L15:
            newUids.add(Integer.valueOf(uid2));
            goto L12
        L18:
            i2 = i2 + 1;
            goto L9
        L19:
            this.mTrampolineExemptUids = newUids;
        }

        private int getUidForPackage(String pkg, int userId) {
            return this.mPm.getPackageUid(pkg, 131072, userId);
        L5:
            Slog.e(NotificationManagerService.TAG, "role manager has bad default " + pkg + " " + userId);
            return -1;
        }
    }

    private final class SavePolicyFileRunnable implements Runnable {
        final /* synthetic */ NotificationManagerService this$0;

        /* synthetic */ SavePolicyFileRunnable(NotificationManagerService r1, NotificationManagerServiceIA r2) {
            this(r1);
        }

        private SavePolicyFileRunnable(NotificationManagerService r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NotificationManagerService.DBG == false) goto L5;
            Slog.d(NotificationManagerService.TAG, "handleSavePolicyFile");
        L5:
            AtomicFile r0 = NotificationManagerService.m6156$$Nest$fgetmPolicyFile(this.this$0);
            monitor-enter(r0);
            FileOutputStream stream = NotificationManagerService.m6156$$Nest$fgetmPolicyFile(this.this$0).startWrite();     // Catch: Throwable -> L10 IOException -> L17
            this.this$0.writePolicyXml(stream, false, -1, null);     // Catch: Throwable -> L10 IOException -> L12
            NotificationManagerService.m6156$$Nest$fgetmPolicyFile(this.this$0).finishWrite(stream);     // Catch: Throwable -> L10 IOException -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L10
            BackupManager.dataChanged(this.this$0.getContext().getPackageName());
            return;
        L12:
            e = move-exception;
            Slog.w(NotificationManagerService.TAG, "Failed to save policy file, restoring backup", e);     // Catch: Throwable -> L10
            NotificationManagerService.m6156$$Nest$fgetmPolicyFile(this.this$0).failWrite(stream);     // Catch: Throwable -> L10
            goto L14
        L17:
            e = move-exception;
            Slog.w(NotificationManagerService.TAG, "Failed to save policy file", e);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private final class SettingsObserver extends ContentObserver {
        private final Uri DEVICE_PROVISIONED_URI;
        private final Uri LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS;
        private final Uri LOCK_SCREEN_SHOW_NOTIFICATIONS;
        private final Uri NOTIFICATION_BADGING_URI;
        private final Uri NOTIFICATION_BUBBLES_URI;
        private final Uri NOTIFICATION_HISTORY_ENABLED;
        private final Uri NOTIFICATION_RATE_LIMIT_URI;
        private final Uri NOTIFICATION_SHOW_MEDIA_ON_QUICK_SETTINGS_URI;
        private final Uri REDACT_OTP_NOTIFICATIONS;
        private final Uri SHOW_NOTIFICATION_SNOOZE;
        final /* synthetic */ NotificationManagerService this$0;

        SettingsObserver(NotificationManagerService r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
            this.NOTIFICATION_BADGING_URI = Settings.Secure.getUriFor("notification_badging");
            this.NOTIFICATION_BUBBLES_URI = Settings.Secure.getUriFor("notification_bubbles");
            this.NOTIFICATION_RATE_LIMIT_URI = Settings.Global.getUriFor("max_notification_enqueue_rate");
            this.NOTIFICATION_HISTORY_ENABLED = Settings.Secure.getUriFor("notification_history_enabled");
            this.NOTIFICATION_SHOW_MEDIA_ON_QUICK_SETTINGS_URI = Settings.Global.getUriFor("qs_media_controls");
            this.LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS = Settings.Secure.getUriFor("lock_screen_allow_private_notifications");
            this.LOCK_SCREEN_SHOW_NOTIFICATIONS = Settings.Secure.getUriFor("lock_screen_show_notifications");
            this.SHOW_NOTIFICATION_SNOOZE = Settings.Secure.getUriFor("show_notification_snooze");
            this.REDACT_OTP_NOTIFICATIONS = Settings.Global.getUriFor("redact_otp_notifications_from_untrusted_listeners");
            this.DEVICE_PROVISIONED_URI = Settings.Global.getUriFor("device_provisioned");
        }

        void observe() {
            ContentResolver resolver = this.this$0.getContext().getContentResolver();
            resolver.registerContentObserver(this.NOTIFICATION_BADGING_URI, false, this, -1);
            resolver.registerContentObserver(this.NOTIFICATION_RATE_LIMIT_URI, false, this, -1);
            resolver.registerContentObserver(this.NOTIFICATION_BUBBLES_URI, false, this, -1);
            resolver.registerContentObserver(this.NOTIFICATION_HISTORY_ENABLED, false, this, -1);
            resolver.registerContentObserver(this.NOTIFICATION_SHOW_MEDIA_ON_QUICK_SETTINGS_URI, false, this, -1);
            resolver.registerContentObserver(this.LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS, false, this, -1);
            resolver.registerContentObserver(this.LOCK_SCREEN_SHOW_NOTIFICATIONS, false, this, -1);
            resolver.registerContentObserver(this.SHOW_NOTIFICATION_SNOOZE, false, this, -1);
            resolver.registerContentObserver(this.REDACT_OTP_NOTIFICATIONS, false, this, -1);
            resolver.registerContentObserver(this.DEVICE_PROVISIONED_URI, false, this, -1);
            update(null);
        }

        void destroy() {
            this.this$0.getContext().getContentResolver().unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            update(uri);
        }

        public void update(Uri uri) {
            ContentResolver resolver = this.this$0.getContext().getContentResolver();
            if (uri != null) goto L5;
        L6:
            NotificationManagerService.m6173$$Nest$fputmMaxPackageEnqueueRate(this.this$0, Settings.Global.getFloat(resolver, "max_notification_enqueue_rate", NotificationManagerService.m6146$$Nest$fgetmMaxPackageEnqueueRate(this.this$0)));
        L7:
            if (uri != null) goto L9;
        L10:
            this.this$0.mPreferencesHelper.updateBadgingEnabled();
        L11:
            if (uri != null) goto L13;
        L14:
            this.this$0.mPreferencesHelper.updateBubblesEnabled();
        L15:
            if (uri != null) goto L17;
        L18:
            Iterator r1 = NotificationManagerService.m6167$$Nest$fgetmUm(this.this$0).getUsers().iterator();
        L20:
            if (r1.hasNext() == false) goto L22;
            UserInfo userInfo = (UserInfo) r1.next();
            update(uri, userInfo.id);
        L22:
            if (uri != null) goto L24;
        L25:
            this.this$0.mPreferencesHelper.updateMediaNotificationFilteringEnabled();
        L26:
            if (uri != null) goto L28;
        L29:
            this.this$0.mPreferencesHelper.updateLockScreenPrivateNotifications();
        L30:
            if (uri != null) goto L32;
        L33:
            this.this$0.mPreferencesHelper.updateLockScreenShowNotifications();
        L34:
            boolean r2 = true;
            if (this.SHOW_NOTIFICATION_SNOOZE.equals(uri) == false) goto L43;
            if (Settings.Secure.getIntForUser(resolver, "show_notification_snooze", 0, -2) == 0) goto L39;
            boolean snoozeEnabled = true;
        L40:
            if (snoozeEnabled == true) goto L43;
            NotificationManagerService.m6239$$Nest$munsnoozeAll(this.this$0);
            goto L43
        L39:
            snoozeEnabled = false;
        L43:
            if (this.REDACT_OTP_NOTIFICATIONS.equals(uri) == false) goto L49;
            NotificationManagerService r3 = this.this$0;
            if (Settings.Global.getInt(resolver, "redact_otp_notifications_from_untrusted_listeners", 1) == 0) goto L47;
            boolean r4 = true;
        L48:
            NotificationManagerService.m6175$$Nest$fputmRedactOtpNotifications(r3, r4);
            goto L49
        L47:
            r4 = false;
        L49:
            if (uri != null) goto L51;
        L52:
            NotificationAttentionHelper r5 = this.this$0.mAttentionHelper;
            if (Settings.Global.getInt(resolver, "device_provisioned", 0) == 0) goto L56;
            r2 = false;
        L56:
            r5.mDisableNotificationEffectsForSetupWizard = r2;
            return;
        L51:
            if (this.DEVICE_PROVISIONED_URI.equals(uri) == true) goto L52;
            return;
        L32:
            if (this.LOCK_SCREEN_SHOW_NOTIFICATIONS.equals(uri) == false) goto L34;
        L28:
            if (this.LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS.equals(uri) == false) goto L30;
        L24:
            if (this.NOTIFICATION_SHOW_MEDIA_ON_QUICK_SETTINGS_URI.equals(uri) == false) goto L26;
        L17:
            if (this.NOTIFICATION_HISTORY_ENABLED.equals(uri) == false) goto L22;
        L13:
            if (this.NOTIFICATION_BUBBLES_URI.equals(uri) == false) goto L15;
        L9:
            if (this.NOTIFICATION_BADGING_URI.equals(uri) == false) goto L11;
        L5:
            if (this.NOTIFICATION_RATE_LIMIT_URI.equals(uri) == false) goto L7;
            goto L6
        }

        public void update(Uri uri, int userId) {
            ContentResolver resolver = this.this$0.getContext().getContentResolver();
            if (uri != null) goto L5;
        L6:
            Archive r1 = NotificationManagerService.m6134$$Nest$fgetmArchive(this.this$0);
            boolean r3 = false;
            if (Settings.Secure.getIntForUser(resolver, "notification_history_enabled", 0, userId) != 1) goto L9;
            r3 = true;
        L9:
            r1.updateHistoryEnabled(userId, r3);
            return;
        L5:
            if (this.NOTIFICATION_HISTORY_ENABLED.equals(uri) == true) goto L6;
        }
    }

    protected static class ShowNotificationPermissionPromptRunnable implements Runnable {
        private final String mPkgName;
        private final PermissionPolicyInternal mPpi;
        private final int mTaskId;
        private final int mUserId;

        ShowNotificationPermissionPromptRunnable(String pkg, int user, int task, PermissionPolicyInternal pPi) {
            this.mPkgName = pkg;
            this.mUserId = user;
            this.mTaskId = task;
            this.mPpi = pPi;
        }

        public boolean equals(Object o) {
            if ((o instanceof ShowNotificationPermissionPromptRunnable) == true) goto L5;
            return false;
        L5:
            ShowNotificationPermissionPromptRunnable other = (ShowNotificationPermissionPromptRunnable) o;
            if (Objects.equals(this.mPkgName, other.mPkgName) == true) goto L8;
            return false;
        L8:
            if (this.mUserId == other.mUserId) goto L10;
            return false;
        L10:
            if (this.mTaskId != other.mTaskId) goto L15;
            return true;
        L15:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mPkgName, Integer.valueOf(this.mUserId), Integer.valueOf(this.mTaskId)});
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mPpi.showNotificationPromptIfNeeded(this.mPkgName, this.mUserId, this.mTaskId);
        }
    }

    protected class SnoozeNotificationRunnable implements Runnable {
        private final long mDuration;
        private final String mKey;
        private final String mSnoozeCriterionId;
        final /* synthetic */ NotificationManagerService this$0;

        SnoozeNotificationRunnable(NotificationManagerService this$0, String key, long duration, String snoozeCriterionId) {
            this.this$0 = this$0;
            this.mKey = key;
            this.mDuration = duration;
            this.mSnoozeCriterionId = snoozeCriterionId;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.this$0.mNotificationLock;
            monitor-enter(r0);
            NotificationRecord r = NotificationManagerService.m6199$$Nest$mfindInCurrentAndSnoozedNotificationByKeyLocked(this.this$0, this.mKey);     // Catch: Throwable -> L7
            if (r == null) goto L9;
            snoozeLocked(r);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void snoozeLocked(NotificationRecord r) {
            List<NotificationRecord> recordsToSnooze = new ArrayList();
            if (r.getSbn().isGroup() == false) goto L25;
            List<NotificationRecord> groupNotifications = this.this$0.findCurrentAndSnoozedGroupNotificationsLocked(r.getSbn().getPackageName(), r.getSbn().getGroupKey(), r.getSbn().getUserId());
            if (r.getNotification().isGroupSummary() == false) goto L15;
            int i = 0;
        L8:
            if (i >= groupNotifications.size()) goto L25;
            if (this.mKey.equals(groupNotifications.get(i).getKey()) == true) goto L12;
            recordsToSnooze.add(groupNotifications.get(i));
        L12:
            i = i + 1;
            goto L8
        L15:
            if (this.this$0.mSummaryByGroupKey.containsKey(r.getSbn().getGroupKey()) == false) goto L25;
            if (groupNotifications.size() != 2) goto L25;
            int i2 = 0;
        L20:
            if (i2 >= groupNotifications.size()) goto L25;
            if (this.mKey.equals(groupNotifications.get(i2).getKey()) == true) goto L24;
            recordsToSnooze.add(groupNotifications.get(i2));
        L24:
            i2 = i2 + 1;
        L25:
            recordsToSnooze.add(r);
            if (this.this$0.mSnoozeHelper.canSnooze(recordsToSnooze.size()) == false) goto L32;
            int i3 = 0;
        L29:
            if (i3 >= recordsToSnooze.size()) goto L41;
            snoozeNotificationLocked(recordsToSnooze.get(i3));
            i3 = i3 + 1;
            goto L29
        L41:
            return;
        L32:
            Log.w(NotificationManagerService.TAG, "Cannot snooze " + r.getKey() + ": too many snoozed notifications");
        }

        void snoozeNotificationLocked(NotificationRecord r) {
            LogMaker r0 = r.getLogMaker().setCategory(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_SESSION).setType(2).addTaggedData(1139, Long.valueOf(this.mDuration));
            if (this.mSnoozeCriterionId != null) goto L5;
            int r1 = 0;
        L6:
            MetricsLogger.action(r0.addTaggedData(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_APPLIED, Integer.valueOf(r1)));
            NotificationManagerService.m6151$$Nest$fgetmNotificationRecordLogger(this.this$0).log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_SNOOZED, r);
            this.this$0.reportUserInteraction(r);
            boolean wasPosted = NotificationManagerService.m6233$$Nest$mremoveFromNotificationListsLocked(this.this$0, r);
            this.this$0.cancelNotificationLocked(r, false, 18, wasPosted, null, SystemClock.elapsedRealtime());
            this.this$0.mAttentionHelper.updateLightsLocked();
            if (isSnoozable(r) == true) goto L9;
            return;
        L9:
            if (this.mSnoozeCriterionId == null) goto L11;
            NotificationAssistants.m6264$$Nest$mnotifyAssistantSnoozedLocked(this.this$0.mAssistants, r, this.mSnoozeCriterionId);
            this.this$0.mSnoozeHelper.snooze(r, this.mSnoozeCriterionId);
        L12:
            r.recordSnoozed();
            this.this$0.handleSavePolicyFile();
            return;
        L11:
            this.this$0.mSnoozeHelper.snooze(r, this.mDuration);
            goto L12
        L5:
            r1 = 1;
            goto L6
        }

        private boolean isSnoozable(NotificationRecord record) {
            if ((record.getFlags() & 1024) == 0) goto L5;
        L8:
            boolean isExemptedSummary = true;
        L10:
            if (record.getNotification().isGroupSummary() == false) goto L15;
            if (isExemptedSummary == true) goto L14;
            return true;
        L14:
            return false;
        L15:
            return true;
        L5:
            if (GroupHelper.isAggregatedGroup(record) == true) goto L8;
            isExemptedSummary = false;
            goto L10
        }
    }

    private class StatsPullAtomCallbackImpl implements StatsManager.StatsPullAtomCallback {
        final /* synthetic */ NotificationManagerService this$0;

        /* synthetic */ StatsPullAtomCallbackImpl(NotificationManagerService r1, NotificationManagerServiceIA r2) {
            this(r1);
        }

        private StatsPullAtomCallbackImpl(NotificationManagerService r1) {
            this.this$0 = r1;
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            switch(atomTag) {
                case 10071: goto L6;
                case 10072: goto L6;
                case 10073: goto L6;
                case 10084: goto L6;
                case 10231: goto L6;
                default: goto L4;
            };
        L4:
            throw new UnsupportedOperationException("Unknown tagId=" + atomTag);
        L6:
            return NotificationManagerService.m6229$$Nest$mpullNotificationStates(this.this$0, atomTag, data);
        }
    }

    private static final class StatusBarNotificationHolder extends IStatusBarNotificationHolder.Stub {
        private StatusBarNotification mValue;

        public StatusBarNotificationHolder(StatusBarNotification value) {
            this.mValue = value;
        }

        public StatusBarNotification get() {
            StatusBarNotification value = this.mValue;
            this.mValue = null;
            return value;
        }
    }

    protected class StrongAuthTracker extends LockPatternUtils.StrongAuthTracker {
        SparseBooleanArray mUserInLockDownMode;
        final /* synthetic */ NotificationManagerService this$0;

        StrongAuthTracker(NotificationManagerService this$0, Context context) {
            this.this$0 = this$0;
            super(context);
            this.mUserInLockDownMode = new SparseBooleanArray();
        }

        private boolean containsFlag(int haystack, int needle) {
            if ((haystack & needle) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isInLockDownMode(int userId) {
            return this.mUserInLockDownMode.get(userId, false);
        }

        public synchronized void onStrongAuthRequiredChanged(int userId) {
            monitor-enter(this);
            boolean userInLockDownModeNext = containsFlag(getStrongAuthForUser(userId), 32);     // Catch: Throwable -> L9
            if (userInLockDownModeNext != isInLockDownMode(userId)) goto L7;
            monitor-exit(this);
            return;
        L7:
            if (userInLockDownModeNext == false) goto L11;
            NotificationManagerService.m6183$$Nest$mcancelNotificationsWhenEnterLockDownMode(this.this$0, userId);     // Catch: Throwable -> L9
        L11:
            this.mUserInLockDownMode.put(userId, userInLockDownModeNext);     // Catch: Throwable -> L9
            if (userInLockDownModeNext == true) goto L14;
            NotificationManagerService.m6228$$Nest$mpostNotificationsWhenExitLockDownMode(this.this$0, userId);     // Catch: Throwable -> L9
        L14:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private class TrimCache {
        StatusBarNotification heavy;
        StatusBarNotification sbnClone;
        StatusBarNotification sbnCloneLight;
        final /* synthetic */ NotificationManagerService this$0;

        TrimCache(NotificationManagerService r1, StatusBarNotification sbn) {
            this.this$0 = r1;
            this.heavy = sbn;
        }

        StatusBarNotification ForListener(ManagedServices.ManagedServiceInfo info) {
            if (this.this$0.mListeners.getOnNotificationPostedTrim(info) != 1) goto L10;
            if (this.sbnCloneLight != null) goto L8;
            this.sbnCloneLight = this.heavy.cloneLight();
        L8:
            return this.sbnCloneLight;
        L10:
            if (this.sbnClone != null) goto L13;
            this.sbnClone = this.heavy.clone();
        L13:
            return this.sbnClone;
        }
    }

    protected class WorkerHandler extends Handler {
        final /* synthetic */ NotificationManagerService this$0;

        public WorkerHandler(NotificationManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 2: goto L10;
                case 3: goto L17;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                case 8: goto L5;
                default: goto L17;
            };
        L5:
            SomeArgs args = (SomeArgs) msg.obj;
            this.this$0.handleOnPackageChanged(((Boolean) args.arg1).booleanValue(), args.argi1, (String[]) args.arg2, (int[]) args.arg3);
            args.recycle();
            return;
        L6:
            NotificationManagerService.m6207$$Nest$mhandleKillTokenTimeout(this.this$0, (ToastRecord) msg.obj);
            return;
        L7:
            NotificationManagerService.m6209$$Nest$mhandleListenerInterruptionFilterChanged(this.this$0, msg.arg1);
            return;
        L8:
            NotificationManagerService.m6208$$Nest$mhandleListenerHintsChanged(this.this$0, msg.arg1);
            return;
        L9:
            NotificationManagerService.m6212$$Nest$mhandleSendRankingUpdate(this.this$0);
            return;
        L10:
            NotificationManagerService.m6205$$Nest$mhandleDurationReached(this.this$0, (ToastRecord) msg.obj);
            return;
        }

        protected void scheduleSendRankingUpdate() {
            if (hasMessages(4) == true) goto L6;
            Message m = Message.obtain(this, 4);
            sendMessage(m);
            return;
        }

        protected void scheduleCancelNotification(CancelNotificationRunnable cancelRunnable, int delay) {
            sendMessageDelayed(Message.obtain(this, cancelRunnable), delay);
        }

        protected void scheduleOnPackageChanged(boolean removingPackage, int changeUserId, String[] pkgList, int[] uidList) {
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = Boolean.valueOf(removingPackage);
            args.argi1 = changeUserId;
            args.arg2 = pkgList;
            args.arg3 = uidList;
            sendMessage(Message.obtain(this, 8, args));
        }
    }

    public static /* synthetic */ void $r8$lambda$1y8sKtk_8HyOufwSTjE5MlYWWQk(NotificationManagerService r0, CharSequence r1) {
        r0.lambda$doChannelWarningToast$13(r1);
    }

    public static /* synthetic */ void $r8$lambda$4dfnf5tKpmr48S6rdkxU6fsXkkI(NotificationManagerService r0, NotificationRecord r1, boolean r2) {
        r0.lambda$cancelNotificationLocked$16(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$6eKorDCCxIYHMwpAqnmOw3vsRMo(NotificationManagerService r0, boolean r1, String r2, int r3) {
        r0.lambda$sendAppBlockStateChangedBroadcast$8(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$AksEhefUr0mq8xo8Ea7je9NeZ90(NotificationManagerService r0, SystemService.TargetUser r1) {
        r0.lambda$onUserStopping$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$BxBJ2SLuZHvZTPbKjjihS5f3J0Y(NotificationManagerService r0, String r1) {
        r0.lambda$cancelNotificationLocked$17(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$E8Mo_5I8e1ccpHMa_sTAecbihs8(int r0, String r1, NotificationRecord r2) {
        return lambda$applyNotificationUpdateForUid$1(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$HOgrimk1XvSso7i4OeAiLllMsRk(int r0) {
        return lambda$handleGroupedNotificationLocked$15(r0);
    }

    public static /* synthetic */ void $r8$lambda$KW_ZYTs1XmOAyw31eERUf0AhI30(NotificationManagerService r0, Intent r1) {
        r0.lambda$sendZenBroadcastWithDelay$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$Os8GlU1qTM9ciDMkJqkDSf7A38g(NotificationManagerService r0) {
        r0.lambda$onBootPhase$6();
    }

    /* JADX INFO: renamed from: $r8$lambda$QZjmddaDeb7-Ft1cRHnyw-JS_6c, reason: not valid java name */
    public static /* synthetic */ boolean m6125$r8$lambda$QZjmddaDeb7Ft1cRHnywJS_6c(int r0, int r1, NotificationRecord r2) {
        return lambda$applyNotificationUpdateForUserAndType$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$SEiDsxpGNQZwvB8jzhcrw5y8Ypc(NotificationManagerService r0, int r1, String r2, NotificationChannel r3) {
        r0.lambda$updateNotificationChannelInt$10(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$T483C3_BlmQaNvdld5jC-PLIr-k, reason: not valid java name */
    public static /* synthetic */ void m6126$r8$lambda$T483C3_BlmQaNvdld5jCPLIrk(NotificationManagerService r0, boolean r1, Notification r2, int r3, String r4, int r5) {
        r0.lambda$reportForegroundServiceUpdate$11(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$T7Iy5CZtau3OMePYhuToAvPhum0(NotificationManagerService r0, NotificationRecord r1) {
        r0.lambda$postNotificationsWhenExitLockDownMode$18(r1);
    }

    public static /* synthetic */ void $r8$lambda$UrLihhgwm79YgkH7EOA2ISYP8QI(NotificationManagerService r0, int r1, NotificationRecord r2, boolean r3) {
        r0.lambda$onStart$4(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$X7kfRx5YT4KkAOsIq70FkylJXmc(int r0, NotificationRecord r1) {
        return lambda$applyNotificationUpdateForUser$0(r0, r1);
    }

    public static /* synthetic */ PostNotificationTracker $r8$lambda$YC33IbBzokLEU0mV1vIgr2hBSjM(NotificationManagerService r0, String r1, int r2) {
        return r0.lambda$acquireWakeLockForPost$12(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gc5Na2ulXljIMlHP0ynzjVrijHQ(int r0, String r1, String r2, int r3, boolean r4) {
        lambda$reportNavigationFgsNotificationIfNeeded$14(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$kYFIDEcWoLAYUYKeGjvl50FfPbY(NotificationRecord r0, int r1, String r2, String r3) {
        return isChildOfCurrentGroupChecker(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$kl4Qsgei4yOTKQc6rIFHP0P2Pfg(int r0, String r1, NotificationRecord r2) {
        return lambda$applyNotificationUpdateForUserAndChannelType$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$mSUFX9o_tbmsae0r9w2sI6ayWco(NotificationManagerService r0, SystemService.TargetUser r1) {
        r0.lambda$onUserUnlocked$7(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$pIysok3wglcE-LNuNZ7ODb8PT5w, reason: not valid java name */
    public static /* synthetic */ void m6127$r8$lambda$pIysok3wglcELNuNZ7ODb8PT5w(NotificationManagerService r0, NotificationRecord r1, boolean r2, boolean r3) {
        r0.lambda$maybeNotifySystemUiListenerLifetimeExtendedLocked$20(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$yOKghboRHRTpCFpB-KmgFWHbcT0, reason: not valid java name */
    public static /* synthetic */ void m6128$r8$lambda$yOKghboRHRTpCFpBKmgFWHbcT0(NotificationManagerService r0, List r1, PostNotificationTracker r2, NotificationRecordLogger.NotificationReported r3) {
        r0.lambda$notifyListenersPostedAndLogLocked$19(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManager m6129$$Nest$fgetmActivityManager(NotificationManagerService r0) {
        return r0.mActivityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowedManagedServicePackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ TriPredicate m6130$$Nest$fgetmAllowedManagedServicePackages(NotificationManagerService r0) {
        return r0.mAllowedManagedServicePackages;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAm, reason: not valid java name */
    static /* bridge */ /* synthetic */ IActivityManager m6131$$Nest$fgetmAm(NotificationManagerService r0) {
        return r0.mAm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAmi, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m6132$$Nest$fgetmAmi(NotificationManagerService r0) {
        return r0.mAmi;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOps, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m6133$$Nest$fgetmAppOps(NotificationManagerService r0) {
        return r0.mAppOps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmArchive, reason: not valid java name */
    static /* bridge */ /* synthetic */ Archive m6134$$Nest$fgetmArchive(NotificationManagerService r0) {
        return r0.mArchive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAtm, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m6135$$Nest$fgetmAtm(NotificationManagerService r0) {
        return r0.mAtm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConditionProviders, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConditionProviders m6136$$Nest$fgetmConditionProviders(NotificationManagerService r0) {
        return r0.mConditionProviders;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDpm, reason: not valid java name */
    static /* bridge */ /* synthetic */ DevicePolicyManagerInternal m6137$$Nest$fgetmDpm(NotificationManagerService r0) {
        return r0.mDpm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEffectsSuppressors, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6138$$Nest$fgetmEffectsSuppressors(NotificationManagerService r0) {
        return r0.mEffectsSuppressors;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlagResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemUiSystemPropertiesFlags.FlagResolver m6139$$Nest$fgetmFlagResolver(NotificationManagerService r0) {
        return r0.mFlagResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGroupHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ GroupHelper m6140$$Nest$fgetmGroupHelper(NotificationManagerService r0) {
        return r0.mGroupHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHistoryManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationHistoryManager m6141$$Nest$fgetmHistoryManager(NotificationManagerService r0) {
        return r0.mHistoryManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInterruptionFilter, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6142$$Nest$fgetmInterruptionFilter(NotificationManagerService r0) {
        return r0.mInterruptionFilter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCurrentToastShown, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6143$$Nest$fgetmIsCurrentToastShown(NotificationManagerService r0) {
        return r0.mIsCurrentToastShown;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListenerHints, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6144$$Nest$fgetmListenerHints(NotificationManagerService r0) {
        return r0.mListenerHints;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockScreenAllowSecureNotifications, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6145$$Nest$fgetmLockScreenAllowSecureNotifications(NotificationManagerService r0) {
        return r0.mLockScreenAllowSecureNotifications;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxPackageEnqueueRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m6146$$Nest$fgetmMaxPackageEnqueueRate(NotificationManagerService r0) {
        return r0.mMaxPackageEnqueueRate;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMetricsLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ MetricsLogger m6147$$Nest$fgetmMetricsLogger(NotificationManagerService r0) {
        return r0.mMetricsLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationChannelLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationChannelLogger m6148$$Nest$fgetmNotificationChannelLogger(NotificationManagerService r0) {
        return r0.mNotificationChannelLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationInstanceIdSequence, reason: not valid java name */
    static /* bridge */ /* synthetic */ InstanceIdSequence m6149$$Nest$fgetmNotificationInstanceIdSequence(NotificationManagerService r0) {
        return r0.mNotificationInstanceIdSequence;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationListenerStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationListenerStats m6150$$Nest$fgetmNotificationListenerStats(NotificationManagerService r0) {
        return r0.mNotificationListenerStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationRecordLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationRecordLogger m6151$$Nest$fgetmNotificationRecordLogger(NotificationManagerService r0) {
        return r0.mNotificationRecordLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObricExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IObricNotificationManagerService m6152$$Nest$fgetmObricExt(NotificationManagerService r0) {
        return r0.mObricExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m6153$$Nest$fgetmPackageManagerClient(NotificationManagerService r0) {
        return r0.mPackageManagerClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionHelper m6154$$Nest$fgetmPermissionHelper(NotificationManagerService r0) {
        return r0.mPermissionHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionPolicyInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionPolicyInternal m6155$$Nest$fgetmPermissionPolicyInternal(NotificationManagerService r0) {
        return r0.mPermissionPolicyInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPolicyFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicFile m6156$$Nest$fgetmPolicyFile(NotificationManagerService r0) {
        return r0.mPolicyFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPostNotificationTrackerFactory, reason: not valid java name */
    static /* bridge */ /* synthetic */ PostNotificationTrackerFactory m6157$$Nest$fgetmPostNotificationTrackerFactory(NotificationManagerService r0) {
        return r0.mPostNotificationTrackerFactory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRedactOtpNotifications, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6158$$Nest$fgetmRedactOtpNotifications(NotificationManagerService r0) {
        return r0.mRedactOtpNotifications;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRoleObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ RoleObserver m6159$$Nest$fgetmRoleObserver(NotificationManagerService r0) {
        return r0.mRoleObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettingsObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ SettingsObserver m6160$$Nest$fgetmSettingsObserver(NotificationManagerService r0) {
        return r0.mSettingsObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShortcutHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ ShortcutHelper m6161$$Nest$fgetmShortcutHelper(NotificationManagerService r0) {
        return r0.mShortcutHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSmtEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManagerServiceSmtEx m6162$$Nest$fgetmSmtEx(NotificationManagerService r0) {
        return r0.mSmtEx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmToastRateLimiter, reason: not valid java name */
    static /* bridge */ /* synthetic */ MultiRateLimiter m6163$$Nest$fgetmToastRateLimiter(NotificationManagerService r0) {
        return r0.mToastRateLimiter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmToastRateLimitingDisabledUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m6164$$Nest$fgetmToastRateLimitingDisabledUids(NotificationManagerService r0) {
        return r0.mToastRateLimitingDisabledUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTtlHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ TimeToLiveHelper m6165$$Nest$fgetmTtlHelper(NotificationManagerService r0) {
        return r0.mTtlHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUgmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UriGrantsManagerInternal m6166$$Nest$fgetmUgmInternal(NotificationManagerService r0) {
        return r0.mUgmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUm, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m6167$$Nest$fgetmUm(NotificationManagerService r0) {
        return r0.mUm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManagerInternal m6168$$Nest$fgetmUmInternal(NotificationManagerService r0) {
        return r0.mUmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsageStatsManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsageStatsManagerInternal m6169$$Nest$fgetmUsageStatsManagerInternal(NotificationManagerService r0) {
        return r0.mUsageStatsManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserProfiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ ManagedServices.UserProfiles m6170$$Nest$fgetmUserProfiles(NotificationManagerService r0) {
        return r0.mUserProfiles;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m6171$$Nest$fgetmWindowManagerInternal(NotificationManagerService r0) {
        return r0.mWindowManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLockScreenAllowSecureNotifications, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6172$$Nest$fputmLockScreenAllowSecureNotifications(NotificationManagerService r0, boolean r1) {
        r0.mLockScreenAllowSecureNotifications = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxPackageEnqueueRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6173$$Nest$fputmMaxPackageEnqueueRate(NotificationManagerService r0, float r1) {
        r0.mMaxPackageEnqueueRate = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPermissionPolicyInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6174$$Nest$fputmPermissionPolicyInternal(NotificationManagerService r0, PermissionPolicyInternal r1) {
        r0.mPermissionPolicyInternal = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRedactOtpNotifications, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6175$$Nest$fputmRedactOtpNotifications(NotificationManagerService r0, boolean r1) {
        r0.mRedactOtpNotifications = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddDisabledHints, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6176$$Nest$maddDisabledHints(NotificationManagerService r0, ManagedServices.ManagedServiceInfo r1, int r2) {
        r0.addDisabledHints(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyAdjustmentLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6177$$Nest$mapplyAdjustmentLocked(NotificationManagerService r0, NotificationRecord r1, Adjustment r2, boolean r3) {
        r0.applyAdjustmentLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mareNotificationsEnabledForPackageInt, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6178$$Nest$mareNotificationsEnabledForPackageInt(NotificationManagerService r0, int r1) {
        return r0.areNotificationsEnabledForPackageInt(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mblockToast, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6179$$Nest$mblockToast(NotificationManagerService r0, int r1, boolean r2, boolean r3, boolean r4) {
        return r0.blockToast(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelAllNotificationsByListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6180$$Nest$mcancelAllNotificationsByListLocked(NotificationManagerService r0, ArrayList r1, String r2, boolean r3, String r4, FlagChecker r5, boolean r6, int r7, boolean r8, int r9, String r10, boolean r11, long r12) {
        r0.cancelAllNotificationsByListLocked(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelGroupChildrenLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6181$$Nest$mcancelGroupChildrenLocked(NotificationManagerService r0, int r1, String r2, int r3, int r4, String r5, boolean r6, FlagChecker r7, GroupChildChecker r8, String r9, int r10, long r11) {
        r0.cancelGroupChildrenLocked(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelNotificationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6182$$Nest$mcancelNotificationLocked(NotificationManagerService r0, NotificationRecord r1, boolean r2, int r3, int r4, int r5, boolean r6, String r7, long r8) {
        r0.cancelNotificationLocked(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelNotificationsWhenEnterLockDownMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6183$$Nest$mcancelNotificationsWhenEnterLockDownMode(NotificationManagerService r0, int r1) {
        r0.cancelNotificationsWhenEnterLockDownMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerIsSameApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6184$$Nest$mcheckCallerIsSameApp(NotificationManagerService r0, String r1) {
        r0.checkCallerIsSameApp(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerIsSameApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6185$$Nest$mcheckCallerIsSameApp(NotificationManagerService r0, String r1, int r2, int r3) {
        r0.checkCallerIsSameApp(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerIsSystem, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6186$$Nest$mcheckCallerIsSystem(NotificationManagerService r0) {
        r0.checkCallerIsSystem();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerIsSystemOrShell, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6187$$Nest$mcheckCallerIsSystemOrShell(NotificationManagerService r0) {
        r0.checkCallerIsSystemOrShell();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerIsSystemOrSystemUiOrShell, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6188$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(NotificationManagerService r0) {
        r0.checkCallerIsSystemOrSystemUiOrShell();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallerIsSystemOrSystemUiOrShell, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6189$$Nest$mcheckCallerIsSystemOrSystemUiOrShell(NotificationManagerService r0, String r1) {
        r0.checkCallerIsSystemOrSystemUiOrShell(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckSelfSetSwitch, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6190$$Nest$mcheckSelfSetSwitch(NotificationManagerService r0, String r1) {
        return r0.checkSelfSetSwitch(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckUseFullScreenIntentPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6191$$Nest$mcheckUseFullScreenIntentPermission(NotificationManagerService r0, AttributionSource r1, ApplicationInfo r2, boolean r3) {
        return r0.checkUseFullScreenIntentPermission(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdestroyPermissionOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6192$$Nest$mdestroyPermissionOwner(NotificationManagerService r0, IBinder r1, int r2, String r3) {
        r0.destroyPermissionOwner(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpJson, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6193$$Nest$mdumpJson(NotificationManagerService r0, PrintWriter r1, DumpFilter r2, ArrayMap r3) {
        r0.dumpJson(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpNotificationRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6194$$Nest$mdumpNotificationRecords(NotificationManagerService r0, PrintWriter r1, DumpFilter r2) {
        r0.dumpNotificationRecords(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpProto, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6195$$Nest$mdumpProto(NotificationManagerService r0, FileDescriptor r1, DumpFilter r2, ArrayMap r3) {
        r0.dumpProto(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpRemoteViewStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6196$$Nest$mdumpRemoteViewStats(NotificationManagerService r0, PrintWriter r1, DumpFilter r2) {
        r0.dumpRemoteViewStats(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mexitIdle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6197$$Nest$mexitIdle(NotificationManagerService r0) {
        r0.exitIdle();
    }

    /* JADX INFO: renamed from: -$$Nest$mfindAppNotificationByListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6198$$Nest$mfindAppNotificationByListLocked(NotificationManagerService r0, ArrayList r1, String r2, int r3) {
        return r0.findAppNotificationByListLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mfindInCurrentAndSnoozedNotificationByKeyLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationRecord m6199$$Nest$mfindInCurrentAndSnoozedNotificationByKeyLocked(NotificationManagerService r0, String r1) {
        return r0.findInCurrentAndSnoozedNotificationByKeyLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfindNotificationByKeyLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationRecord m6200$$Nest$mfindNotificationByKeyLocked(NotificationManagerService r0, String r1) {
        return r0.findNotificationByKeyLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNotificationCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6201$$Nest$mgetNotificationCount(NotificationManagerService r0, String r1, int r2) {
        return r0.getNotificationCount(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPackageImportanceWithIdentity, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6202$$Nest$mgetPackageImportanceWithIdentity(NotificationManagerService r0, String r1) {
        return r0.getPackageImportanceWithIdentity(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetToastRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ ToastRecord m6203$$Nest$mgetToastRecord(NotificationManagerService r0, int r1, int r2, String r3, boolean r4, IBinder r5, CharSequence r6, ITransientNotification r7, int r8, Binder r9, int r10, ITransientNotificationCallback r11, int r12) {
        return r0.getToastRecord(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: -$$Nest$mgrantUriPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6204$$Nest$mgrantUriPermission(NotificationManagerService r0, IBinder r1, Uri r2, int r3, String r4, int r5) {
        r0.grantUriPermission(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleDurationReached, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6205$$Nest$mhandleDurationReached(NotificationManagerService r0, ToastRecord r1) {
        r0.handleDurationReached(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleGroupedNotificationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6206$$Nest$mhandleGroupedNotificationLocked(NotificationManagerService r0, NotificationRecord r1, NotificationRecord r2, int r3, int r4) {
        r0.handleGroupedNotificationLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleKillTokenTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6207$$Nest$mhandleKillTokenTimeout(NotificationManagerService r0, ToastRecord r1) {
        r0.handleKillTokenTimeout(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleListenerHintsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6208$$Nest$mhandleListenerHintsChanged(NotificationManagerService r0, int r1) {
        r0.handleListenerHintsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleListenerInterruptionFilterChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6209$$Nest$mhandleListenerInterruptionFilterChanged(NotificationManagerService r0, int r1) {
        r0.handleListenerInterruptionFilterChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotificationPermissionChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6210$$Nest$mhandleNotificationPermissionChange(NotificationManagerService r0, String r1, int r2) {
        r0.handleNotificationPermissionChange(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRankingReconsideration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6211$$Nest$mhandleRankingReconsideration(NotificationManagerService r0, Message r1) {
        r0.handleRankingReconsideration(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSendRankingUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6212$$Nest$mhandleSendRankingUpdate(NotificationManagerService r0) {
        r0.handleSendRankingUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$mhasAutoGroupSummaryLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6213$$Nest$mhasAutoGroupSummaryLocked(NotificationManagerService r0, NotificationRecord r1) {
        return r0.hasAutoGroupSummaryLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasCompanionDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6214$$Nest$mhasCompanionDevice(NotificationManagerService r0, String r1, int r2, Set r3) {
        return r0.hasCompanionDevice(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhideNotificationsForPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6215$$Nest$mhideNotificationsForPackages(NotificationManagerService r0, String[] r1, int[] r2) {
        r0.hideNotificationsForPackages(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misCallNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6216$$Nest$misCallNotification(NotificationManagerService r0, String r1, int r2) {
        return r0.isCallNotification(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misCallerSameApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6217$$Nest$misCallerSameApp(NotificationManagerService r0, String r1, int r2, int r3) {
        return r0.isCallerSameApp(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$misCallerSystemOrSystemUiOrShell, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6218$$Nest$misCallerSystemOrSystemUiOrShell(NotificationManagerService r0) {
        return r0.isCallerSystemOrSystemUiOrShell();
    }

    /* JADX INFO: renamed from: -$$Nest$misCritical, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6219$$Nest$misCritical(NotificationManagerService r0, NotificationRecord r1) {
        return r0.isCritical(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misNotificationAssistant, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6220$$Nest$misNotificationAssistant(NotificationManagerService r0, IInterface r1) {
        return r0.isNotificationAssistant(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misNotificationRecent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6221$$Nest$misNotificationRecent(NotificationManagerService r0, long r1) {
        return r0.isNotificationRecent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misPackageInForegroundForToast, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6222$$Nest$misPackageInForegroundForToast(NotificationManagerService r0, int r1) {
        return r0.isPackageInForegroundForToast(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mkeepProcessAliveForToastIfNeededLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6223$$Nest$mkeepProcessAliveForToastIfNeededLocked(NotificationManagerService r0, int r1) {
        r0.keepProcessAliveForToastIfNeededLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6224$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedListLocked(NotificationManagerService r0, List r1, int r2) {
        r0.maybeNotifySystemUiListenerLifetimeExtendedListLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6225$$Nest$mmaybeNotifySystemUiListenerLifetimeExtendedLocked(NotificationManagerService r0, NotificationRecord r1, String r2, int r3) {
        r0.maybeNotifySystemUiListenerLifetimeExtendedLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyListenersPostedAndLogLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6226$$Nest$mnotifyListenersPostedAndLogLocked(NotificationManagerService r0, NotificationRecord r1, NotificationRecord r2, PostNotificationTracker r3, NotificationRecordLogger.NotificationReported r4) {
        r0.notifyListenersPostedAndLogLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monConversationRemovedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6227$$Nest$monConversationRemovedInternal(NotificationManagerService r0, String r1, int r2, Set r3) {
        r0.onConversationRemovedInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostNotificationsWhenExitLockDownMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6228$$Nest$mpostNotificationsWhenExitLockDownMode(NotificationManagerService r0, int r1) {
        r0.postNotificationsWhenExitLockDownMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullNotificationStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6229$$Nest$mpullNotificationStates(NotificationManagerService r0, int r1, List r2) {
        return r0.pullNotificationStates(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveBitmapAndRepost, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6230$$Nest$mremoveBitmapAndRepost(NotificationManagerService r0, NotificationRecord r1) {
        r0.removeBitmapAndRepost(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveDisabledHints, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6231$$Nest$mremoveDisabledHints(NotificationManagerService r0, ManagedServices.ManagedServiceInfo r1) {
        return r0.removeDisabledHints(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveDisabledHints, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6232$$Nest$mremoveDisabledHints(NotificationManagerService r0, ManagedServices.ManagedServiceInfo r1, int r2) {
        return r0.removeDisabledHints(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveFromNotificationListsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6233$$Nest$mremoveFromNotificationListsLocked(NotificationManagerService r0, NotificationRecord r1) {
        return r0.removeFromNotificationListsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportNavigationFgsNotificationIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6234$$Nest$mreportNavigationFgsNotificationIfNeeded(NotificationManagerService r0, NotificationRecord r1, boolean r2) {
        r0.reportNavigationFgsNotificationIfNeeded(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msendAppBlockStateChangedBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6235$$Nest$msendAppBlockStateChangedBroadcast(NotificationManagerService r0, String r1, int r2, boolean r3) {
        r0.sendAppBlockStateChangedBroadcast(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msendRegisteredOnlyBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6236$$Nest$msendRegisteredOnlyBroadcast(NotificationManagerService r0, Intent r1) {
        r0.sendRegisteredOnlyBroadcast(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendRegisteredOnlyBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6237$$Nest$msendRegisteredOnlyBroadcast(NotificationManagerService r0, String r1) {
        r0.sendRegisteredOnlyBroadcast(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munhideNotificationsForPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6238$$Nest$munhideNotificationsForPackages(NotificationManagerService r0, String[] r1, int[] r2) {
        r0.unhideNotificationsForPackages(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$munsnoozeAll, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6239$$Nest$munsnoozeAll(NotificationManagerService r0) {
        r0.unsnoozeAll();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateEffectsSuppressorLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6240$$Nest$mupdateEffectsSuppressorLocked(NotificationManagerService r0) {
        r0.updateEffectsSuppressorLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateInterruptionFilterLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6241$$Nest$mupdateInterruptionFilterLocked(NotificationManagerService r0) {
        r0.updateInterruptionFilterLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateListenerHintsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6242$$Nest$mupdateListenerHintsLocked(NotificationManagerService r0) {
        r0.updateListenerHintsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNotificationBubbleFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6243$$Nest$mupdateNotificationBubbleFlags(NotificationManagerService r0, NotificationRecord r1, boolean r2) {
        r0.updateNotificationBubbleFlags(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetACTION_NOTIFICATION_TIMEOUT, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6244$$Nest$sfgetACTION_NOTIFICATION_TIMEOUT() {
        return ACTION_NOTIFICATION_TIMEOUT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMY_PID, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6245$$Nest$sfgetMY_PID() {
        return MY_PID;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMY_UID, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6246$$Nest$sfgetMY_UID() {
        return MY_UID;
    }

    /* JADX INFO: renamed from: -$$Nest$smfindNotificationByListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationRecord m6247$$Nest$smfindNotificationByListLocked(ArrayList r0, String r1) {
        return findNotificationByListLocked(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smfindNotificationByListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationRecord m6248$$Nest$smfindNotificationByListLocked(ArrayList r0, String r1, String r2, int r3, int r4) {
        return findNotificationByListLocked(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smfindNotificationsByListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6249$$Nest$smfindNotificationsByListLocked(ArrayList r0, String r1, String r2, int r3, int r4) {
        return findNotificationsByListLocked(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smisBitmapExpired, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6250$$Nest$smisBitmapExpired(long r0, long r2, long r4) {
        return isBitmapExpired(r0, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smisChildOfCurrentGroupChecker, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6251$$Nest$smisChildOfCurrentGroupChecker(NotificationRecord r0, int r1, String r2, String r3) {
        return isChildOfCurrentGroupChecker(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smnotificationMatchesUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6252$$Nest$smnotificationMatchesUserId(NotificationRecord r0, int r1, boolean r2) {
        return notificationMatchesUserId(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smsendDeleteIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6253$$Nest$smsendDeleteIntent(PendingIntent r0, String r1) {
        sendDeleteIntent(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smwasChildOfForceRegroupedGroupChecker, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6254$$Nest$smwasChildOfForceRegroupedGroupChecker(NotificationRecord r0, int r1, String r2, String r3) {
        return wasChildOfForceRegroupedGroupChecker(r0, r1, r2, r3);
    }

    static {
        DBG = Log.isLoggable(TAG, 3);
        ENABLE_CHILD_NOTIFICATIONS = SystemProperties.getBoolean("debug.child_notifs", true);
        NOTIFICATION_IGNORE_LIST = Arrays.asList(new String[]{"com.qualcomm.qti.smq"});
        SMART_CHARGING_NAVIGATION_PACKAGES = new ArraySet(Arrays.asList(new String[]{"com.autonavi.minimap", "com.baidu.BaiduMap", "com.tencent.map", "com.google.android.apps.maps", "com.waze", "com.sygic.aura", "com.tomtom.gplay.navapp", "com.here.app.maps"}));
        SMART_CHARGING_NAVIGATION_CHANNELS = new ArrayMap();
        SMART_CHARGING_NAVIGATION_CHANNELS.put("com.baidu.BaiduMap", new ArraySet(Arrays.asList(new String[]{"com.baidu.baidumap.localnotification"})));
        SMART_CHARGING_NAVIGATION_CHANNELS.put("com.tencent.map", new ArraySet(Arrays.asList(new String[]{"navi"})));
        SMART_CHARGING_NAVIGATION_CHANNELS.put("com.sygic.aura", new ArraySet(Arrays.asList(new String[]{"nav_guidance_channel"})));
        SMART_CHARGING_NAVIGATION_CHANNELS.put("com.tomtom.gplay.navapp", new ArraySet(Arrays.asList(new String[]{"tomtom_nav_foreground"})));
        SMART_CHARGING_NAVIGATION_CHANNELS.put("com.here.app.maps", new ArraySet(Arrays.asList(new String[]{"GUIDANCE_CHANNEL"})));
        DEBUG_INTERRUPTIVENESS = SystemProperties.getBoolean("debug.notification.interruptiveness", false);
        BITMAP_DURATION = Duration.ofHours(24);
        DEFAULT_ALLOWED_ADJUSTMENTS = new String[]{"key_people", "key_snooze_criteria", "key_user_sentiment", "key_contextual_actions", "key_text_replies", "key_importance", "key_importance_proposal", "key_sensitive_content", "key_ranking_score", "key_not_conversation", "key_type", "key_summarization"};
        DEFAULT_ALLOWED_ADJUSTMENT_KEY_TYPES = new Integer[]{1, 3, 4, 2};
        NON_BLOCKABLE_DEFAULT_ROLES = new String[]{"android.app.role.DIALER", "android.app.role.EMERGENCY"};
        TOAST_RATE_LIMITS = new MultiRateLimiter.RateLimit[]{MultiRateLimiter.RateLimit.create(3, Duration.ofSeconds(20)), MultiRateLimiter.RateLimit.create(5, Duration.ofSeconds(42)), MultiRateLimiter.RateLimit.create(6, Duration.ofSeconds(68))};
        ACTION_NOTIFICATION_TIMEOUT = NotificationManagerService.class.getSimpleName() + ".TIMEOUT";
        POST_WAKE_LOCK_TIMEOUT = Duration.ofSeconds(30);
        NOTIFICATION_TTL = Duration.ofDays(3).toMillis();
        NOTIFICATION_MAX_AGE_AT_POST = Duration.ofDays(14).toMillis();
        ZEN_BROADCAST_DELAY = Duration.ofMillis(250);
        MY_UID = Process.myUid();
        MY_PID = Process.myPid();
        ALLOWLIST_TOKEN = new Binder();
    }

    void loadDefaultApprovedServices(int userId) {
        this.mListeners.loadDefaultsFromConfig();
        this.mConditionProviders.loadDefaultsFromConfig();
        this.mAssistants.loadDefaultsFromConfig();
    }

    protected void allowDefaultApprovedServices(int userId) {
        ArraySet<ComponentName> defaultListeners = this.mListeners.getDefaultComponents();
        int i = 0;
    L4:
        if (i >= defaultListeners.size()) goto L6;
        ComponentName cn = defaultListeners.valueAt(i);
        allowNotificationListener(userId, cn);
        i = i + 1;
        goto L4
    L6:
        allowDndPackages(userId);
        setDefaultAssistantForUser(userId);
    }

    void allowDndPackages(int userId) {
        ArraySet<String> defaultDnds = this.mConditionProviders.getDefaultPackages();
        int i = 0;
    L4:
        if (i >= defaultDnds.size()) goto L7;
        allowDndPackage(userId, defaultDnds.valueAt(i));
        i = i + 1;
        goto L4
    L7:
        if (isDNDMigrationDone(userId) == true) goto L11;
        setDNDMigrationDone(userId);
        return;
    }

    boolean isDNDMigrationDone(int userId) {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "dnd_settings_migrated", 0, userId) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    void setDNDMigrationDone(int userId) {
        Settings.Secure.putIntForUser(getContext().getContentResolver(), "dnd_settings_migrated", 1, userId);
    }

    protected void migrateDefaultNAS() {
        List<UserInfo> activeUsers = this.mUm.getUsers();
        Iterator<UserInfo> r1 = activeUsers.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        UserInfo userInfo = r1.next();
        int userId = userInfo.getUserHandle().getIdentifier();
        if (isNASMigrationDone(userId) == true) goto L4;
        if (isProfileUser(userInfo) == true) goto L4;
        List<ComponentName> allowedComponents = this.mAssistants.getAllowedComponents(userId);
        if (allowedComponents.size() == 0) goto L12;
        Slog.d(TAG, "Reset NAS setting and migrate to new default");
        resetAssistantUserSet(userId);
        this.mAssistants.resetDefaultAssistantsIfNecessary();
        goto L4
    L12:
        Slog.d(TAG, "NAS Migration: user set to none, disable new NAS setting");
        setNASMigrationDone(userId);
        this.mAssistants.clearDefaults();
        goto L4
    }

    void setNASMigrationDone(int baseUserId) {
        int r1 = 0;
        int[] r0 = this.mUm.getProfileIds(baseUserId, false);
        int r2 = r0.length;
    L3:
        if (r1 >= r2) goto L5;
        int profileId = r0[r1];
        Settings.Secure.putIntForUser(getContext().getContentResolver(), "nas_settings_updated", 1, profileId);
        r1 = r1 + 1;
        goto L3
    }

    boolean isNASMigrationDone(int userId) {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "nas_settings_updated", 0, userId) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    boolean isProfileUser(UserInfo userInfo) {
        if (privateSpaceFlagsEnabled() == false) goto L11;
        if (userInfo.isProfile() == true) goto L7;
        return false;
    L7:
        if (hasParent(userInfo) == true) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (userInfo.isManagedProfile() == true) goto L15;
        if (userInfo.isCloneProfile() == true) goto L15;
        return false;
    L15:
        return true;
    }

    boolean hasParent(UserInfo profile) {
        if (this.mUmInternal.getProfileParentId(profile.id) == profile.id) goto L5;
        return true;
    L5:
        return false;
    }

    protected void setDefaultAssistantForUser(int userId) {
        ArraySet<ComponentName> defaults = this.mAssistants.getDefaultComponents();
        int i = 0;
    L4:
        if (i >= defaults.size()) goto L10;
        ComponentName cn = defaults.valueAt(i);
        if (allowAssistant(userId, cn) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return;
    }

    protected void updateAutobundledSummaryLocked(int userId, String pkg, String groupKey, GroupHelper.NotificationAttributes summaryAttr, boolean isAppForeground) {
        ArrayMap<String, String> summaries = this.mAutobundledSummaries.get(Integer.valueOf(userId));
        if (summaries != null) goto L5;
        return;
    L5:
        String summaryKey = summaries.get(groupKey);
        if (summaryKey != null) goto L8;
        return;
    L8:
        NotificationRecord summary = this.mNotificationsByKey.get(summaryKey);
        if (summary != null) goto L11;
        return;
    L11:
        int oldFlags = summary.getSbn().getNotification().flags;
        if (summaryAttr.icon.sameAs(summary.getSbn().getNotification().getSmallIcon()) == true) goto L14;
    L21:
        boolean attributesUpdated = true;
    L22:
        summary.getNotification().flags |= 131072;
        if (summary.getChannel().getId().equals(summaryAttr.channelId) == true) goto L28;
        NotificationChannel newChannel = this.mPreferencesHelper.getNotificationChannel(pkg, summary.getUid(), summaryAttr.channelId, false);
        if (newChannel == null) goto L28;
        summary.updateNotificationChannel(newChannel);
        boolean attributesUpdated2 = true;
    L30:
        if (oldFlags != summaryAttr.flags) goto L32;
        if (attributesUpdated2 == true) goto L32;
        return;
    L32:
        Notification r5 = summary.getSbn().getNotification();
        if (summaryAttr.flags == (-1)) goto L35;
        int r6 = summaryAttr.flags;
    L36:
        r5.flags = r6;
        summary.getSbn().getNotification().setSmallIcon(summaryAttr.icon);
        summary.getSbn().getNotification().color = summaryAttr.iconColor;
        summary.getSbn().getNotification().visibility = summaryAttr.visibility;
        summary.getSbn().getNotification().setGroupAlertBehavior(summaryAttr.groupAlertBehavior);
        this.mHandler.post(new EnqueueNotificationRunnable(this, userId, summary, isAppForeground, false, this.mPostNotificationTrackerFactory.newTracker(null)));
        return;
    L35:
        r6 = oldFlags;
    L28:
        attributesUpdated2 = attributesUpdated;
        goto L30
    L14:
        if (summaryAttr.iconColor != summary.getSbn().getNotification().color) goto L21;
        if (summaryAttr.visibility != summary.getSbn().getNotification().visibility) goto L21;
        if (summaryAttr.groupAlertBehavior != summary.getSbn().getNotification().getGroupAlertBehavior()) goto L21;
        attributesUpdated = false;
        goto L22
    }

    private void allowDndPackage(int userId, String packageName) {
        getBinderService().setNotificationPolicyAccessGrantedForUser(packageName, userId, true);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void allowNotificationListener(int userId, ComponentName cn) {
        getBinderService().setNotificationListenerAccessGrantedForUser(cn, userId, true, true);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean allowAssistant(int userId, ComponentName candidate) {
        Set<ComponentName> validAssistants = this.mAssistants.queryPackageForServices(null, 786432, userId);
        if (candidate != null) goto L5;
    L8:
        return false;
    L5:
        if (validAssistants.contains(candidate) == false) goto L8;
        setNotificationAssistantAccessGrantedForUserInternal(candidate, userId, true, false);
        return true;
    }

    void readPolicyXml(InputStream stream, boolean forRestore, int userId, BackupRestoreEventLogger logger) throws XmlPullParserException, NumberFormatException, IOException {
        if (forRestore == false) goto L4;
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setInput(stream, StandardCharsets.UTF_8.name());
    L5:
        XmlUtils.beginDocument(parser, TAG_NOTIFICATION_POLICY);
        boolean migratedManagedServices = false;
        UserInfo userInfo = this.mUmInternal.getUserInfo(userId);
        if (forRestore == true) goto L8;
    L10:
        boolean ineligibleForManagedServices = false;
    L11:
        int outerDepth = parser.getDepth();
    L13:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L59;
        if ("zen".equals(parser.getName()) == false) goto L30;
        int successfulReads = 0;
        int unsuccessfulReads = 0;
        boolean loadedCorrectly = this.mZenModeHelper.readXml(parser, forRestore, userId, logger);     // Catch: Exception -> L22
        if (loadedCorrectly == false) goto L20;
        successfulReads = 0 + 1;
    L24:
        if (logger == null) goto L33;
        logger.logItemsRestored("notifications:zen_config", successfulReads);
        if (unsuccessfulReads <= 0) goto L33;
        logger.logItemsRestoreFailed("notifications:zen_config", unsuccessfulReads, "notifications:invalid_xml_parsing");
    L33:
        if (this.mListeners.getConfig().xmlTag.equals(parser.getName()) == true) goto L34;
        if (this.mAssistants.getConfig().xmlTag.equals(parser.getName()) == true) goto L39;
        if (this.mConditionProviders.getConfig().xmlTag.equals(parser.getName()) == false) goto L48;
        if (ineligibleForManagedServices == true) goto L13;
        this.mConditionProviders.readXml(parser, this.mAllowedManagedServicePackages, forRestore, userId);
        migratedManagedServices = true;
    L51:
        if (LOCKSCREEN_ALLOW_SECURE_NOTIFICATIONS_TAG.equals(parser.getName()) == false) goto L57;
        if (forRestore == false) goto L55;
        if (userId != 0) goto L13;
    L55:
        this.mLockScreenAllowSecureNotifications = parser.getAttributeBoolean(null, LOCKSCREEN_ALLOW_SECURE_NOTIFICATIONS_VALUE, true);
    L57:
        if (NotificationListenerStats.isXmlTag(parser.getName()) == false) goto L13;
        this.mNotificationListenerStats.readXml(parser);
        goto L13
    L48:
        if ("snoozed-notifications".equals(parser.getName()) == false) goto L51;
        this.mSnoozeHelper.readXml(parser, System.currentTimeMillis());
        goto L51
    L39:
        if (ineligibleForManagedServices == true) goto L13;
        this.mAssistants.readXml(parser, this.mAllowedManagedServicePackages, forRestore, userId);
        migratedManagedServices = true;
        goto L51
    L34:
        if (ineligibleForManagedServices == true) goto L13;
        this.mListeners.readXml(parser, this.mAllowedManagedServicePackages, forRestore, userId);
        migratedManagedServices = true;
        goto L51
    L20:
        unsuccessfulReads = 0 + 1;
    L22:
        e = move-exception;
        Slog.wtf(TAG, "failed to read config", e);
        unsuccessfulReads = 0 + 1;
        goto L24
    L30:
        if ("ranking".equals(parser.getName()) == false) goto L33;
        this.mPreferencesHelper.readXml(parser, forRestore, userId);
        goto L33
    L59:
        if (migratedManagedServices == true) goto L61;
        this.mListeners.migrateToXml();
        this.mAssistants.migrateToXml();
        this.mConditionProviders.migrateToXml();
        handleSavePolicyFile();
    L61:
        this.mAssistants.resetDefaultAssistantsIfNecessary();
        this.mPreferencesHelper.syncHasPriorityChannels();
        return;
    L8:
        if (isProfileUser(userInfo) == false) goto L10;
        ineligibleForManagedServices = true;
        goto L11
    L4:
        parser = Xml.resolvePullParser(stream);
        goto L5
    }

    void resetDefaultDndIfNecessary() {
        boolean removed = false;
        List<UserInfo> activeUsers = this.mUm.getAliveUsers();
        Iterator<UserInfo> r2 = activeUsers.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        UserInfo userInfo = r2.next();
        int userId = userInfo.getUserHandle().getIdentifier();
        if (isDNDMigrationDone(userId) == true) goto L4;
        removed = removed | this.mConditionProviders.removeDefaultFromConfig(userId);
        this.mConditionProviders.resetDefaultFromConfig();
        allowDndPackages(userId);
        goto L4
    L9:
        if (removed == false) goto L17;
        handleSavePolicyFile();
        return;
    }

    protected void loadPolicyFile() {
        if (DBG == false) goto L5;
        Slog.d(TAG, "loadPolicyFile");
    L5:
        AtomicFile r0 = this.mPolicyFile;
        monitor-enter(r0);
        InputStream infile = null;
        infile = this.mPolicyFile.openRead();     // Catch: Throwable -> L12 XmlPullParserException -> L14 NumberFormatException -> L16 IOException -> L18 FileNotFoundException -> L20
        readPolicyXml(infile, false, -1, null);     // Catch: Throwable -> L12 XmlPullParserException -> L14 NumberFormatException -> L16 IOException -> L18 FileNotFoundException -> L20
        boolean isWatch = this.mPackageManagerClient.hasSystemFeature("android.hardware.type.watch");     // Catch: Throwable -> L12 XmlPullParserException -> L14 NumberFormatException -> L16 IOException -> L18 FileNotFoundException -> L20
        if (isWatch == false) goto L22;
        resetDefaultDndIfNecessary();     // Catch: Throwable -> L12 XmlPullParserException -> L14 NumberFormatException -> L16 IOException -> L18 FileNotFoundException -> L20
    L22:
        IoUtils.closeQuietly(infile);     // Catch: Throwable -> L24
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L14:
        e = move-exception;
        Log.wtf(TAG, "Unable to parse notification policy", e);     // Catch: Throwable -> L12
    L18:
        e = move-exception;
        Log.wtf(TAG, "Unable to read notification policy", e);     // Catch: Throwable -> L12
    L16:
        e = move-exception;
        Log.wtf(TAG, "Unable to parse notification policy", e);     // Catch: Throwable -> L12
    L30:
        loadDefaultApprovedServices(0);     // Catch: Throwable -> L12
        allowDefaultApprovedServices(0);     // Catch: Throwable -> L12
        IoUtils.closeQuietly(infile);     // Catch: Throwable -> L24
    L12:
        th = move-exception;
        IoUtils.closeQuietly(infile);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    protected void handleSavePolicyFile() {
        if (IoThread.getHandler().hasCallbacks(this.mSavePolicyFile) == true) goto L6;
        IoThread.getHandler().postDelayed(this.mSavePolicyFile, 250);
        return;
    }

    protected static boolean privateSpaceFlagsEnabled() {
        return true;
    }

    void writePolicyXml(OutputStream stream, boolean forBackup, int userId, BackupRestoreEventLogger logger) throws IOException {
        if (forBackup == false) goto L4;
        TypedXmlSerializer out = Xml.newFastSerializer();
        out.setOutput(stream, StandardCharsets.UTF_8.name());
        TypedXmlSerializer out2 = out;
    L5:
        out2.startDocument(null, true);
        out2.startTag(null, TAG_NOTIFICATION_POLICY);
        out2.attributeInt(null, ATTR_VERSION, 1);
        this.mZenModeHelper.writeXml(out2, forBackup, null, userId, logger);
        this.mPreferencesHelper.writeXml(out2, forBackup, userId);
        this.mListeners.writeXml(out2, forBackup, userId);
        this.mAssistants.writeXml(out2, forBackup, userId);
        this.mSnoozeHelper.writeXml(out2);
        this.mConditionProviders.writeXml(out2, forBackup, userId);
        if (forBackup == false) goto L8;
        if (userId == 0) goto L8;
    L9:
        if (forBackup == true) goto L11;
        this.mNotificationListenerStats.writeXml(out2);
    L11:
        out2.endTag(null, TAG_NOTIFICATION_POLICY);
        out2.endDocument();
        return;
    L8:
        writeSecureNotificationsPolicy(out2);
        goto L9
    L4:
        TypedXmlSerializer out3 = Xml.resolveSerializer(stream);
        out2 = out3;
        goto L5
    }

    private void applyNotificationUpdateForUser(final int userId, NotificationUpdate notificationUpdate) {
        applyUpdateForNotificationsFiltered(new NotificationManagerService$$ExternalSyntheticLambda18(userId), notificationUpdate);
    }

    private static /* synthetic */ boolean lambda$applyNotificationUpdateForUser$0(int userId, NotificationRecord r) {
        if (r.getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private void applyNotificationUpdateForUid(final int userId, final String pkg, NotificationUpdate notificationUpdate) {
        applyUpdateForNotificationsFiltered(new NotificationManagerService$$ExternalSyntheticLambda1(userId, pkg), notificationUpdate);
    }

    private static /* synthetic */ boolean lambda$applyNotificationUpdateForUid$1(int userId, String pkg, NotificationRecord r) {
        if (r.getUserId() == userId) goto L5;
    L7:
        return false;
    L5:
        if (Objects.equals(r.getSbn().getPackageName(), pkg) == false) goto L7;
        return true;
    }

    private void applyNotificationUpdateForUserAndChannelType(final int userId, int bundleType, NotificationUpdate notificationUpdate) {
        final String bundleChannelId = NotificationChannel.getChannelIdForBundleType(bundleType);
        applyUpdateForNotificationsFiltered(new NotificationManagerService$$ExternalSyntheticLambda3(userId, bundleChannelId), notificationUpdate);
    }

    private static /* synthetic */ boolean lambda$applyNotificationUpdateForUserAndChannelType$2(int userId, String bundleChannelId, NotificationRecord r) {
        if (r.getUserId() == userId) goto L5;
    L9:
        return false;
    L5:
        if (r.getChannel() == null) goto L9;
        if (Objects.equals(bundleChannelId, r.getChannel().getId()) == false) goto L9;
        return true;
    }

    private void applyNotificationUpdateForUserAndType(final int userId, final int bundleType, NotificationUpdate notificationUpdate) {
        applyUpdateForNotificationsFiltered(new NotificationManagerService$$ExternalSyntheticLambda11(userId, bundleType), notificationUpdate);
    }

    private static /* synthetic */ boolean lambda$applyNotificationUpdateForUserAndType$3(int userId, int bundleType, NotificationRecord r) {
        if (r.getUserId() == userId) goto L5;
    L7:
        return false;
    L5:
        if (r.getBundleType() != bundleType) goto L7;
        return true;
    }

    void unclassifyNotification(String key) {
    }

    void reclassifyNotification(String key) {
    }

    private void unclassifyNotificationLocked(NotificationRecord r, boolean isPosted) {
        if (DBG == false) goto L5;
        Slog.v(TAG, "unclassifyNotification: " + r);
    L5:
        String origChannelId = r.getNotification().getChannelId();
        NotificationChannel originalChannel = this.mPreferencesHelper.getNotificationChannel(r.getSbn().getPackageName(), r.getUid(), origChannelId, false);
        String currChannelId = r.getChannel().getId();
        boolean isClassified = NotificationChannel.SYSTEM_RESERVED_IDS.contains(currChannelId);
        if (originalChannel != null) goto L8;
        return;
    L8:
        if (origChannelId.equals(currChannelId) == true) goto L13;
        if (isClassified == false) goto L14;
        r.updateNotificationChannel(originalChannel);
        this.mGroupHelper.onNotificationUnbundled(r, GroupHelper.isOriginalGroupSummaryPresent(r, this.mSummaryByGroupKey));
        return;
    L14:
        return;
    }

    private void unsummarizeNotificationLocked(NotificationRecord r, boolean isPosted) {
        Bundle signals = new Bundle();
        signals.putString("key_summarization", null);
        Adjustment adjustment = new Adjustment(r.getSbn().getPackageName(), r.getKey(), signals, "", r.getSbn().getUserId());
        r.addAdjustment(adjustment);
        this.mRankingHandler.requestSort();
    }

    private void reclassifyNotificationLocked(NotificationRecord r, boolean isPosted) {
        if (DBG == false) goto L5;
        Slog.v(TAG, "reclassifyNotification: " + r);
    L5:
        boolean isClassified = NotificationChannel.SYSTEM_RESERVED_IDS.contains(r.getChannel().getId());
        if (r.getBundleType() == 0) goto L10;
        if (isClassified == true) goto L10;
        Bundle classifBundle = new Bundle();
        classifBundle.putInt("key_type", r.getBundleType());
        Adjustment adj = new Adjustment(r.getSbn().getPackageName(), r.getKey(), classifBundle, "reclassify", r.getUserId());
        applyAdjustmentLocked(r, adj, isPosted);
        this.mRankingHandler.requestSort();
        return;
    L10:
        if (DBG == false) goto L14;
        Slog.w(TAG, "Can't reclassify. No valid bundle type or already bundled: " + r);
        return;
    }

    private void applyUpdateForNotificationsFiltered(Predicate<NotificationRecord> filter, NotificationUpdate notificationUpdate) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        int i = 0;
    L25:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mEnqueuedNotifications.size()) goto L13;
        NotificationRecord r = this.mEnqueuedNotifications.get(i);     // Catch: Throwable -> L10
        if (filter.test(r) == false) goto L12;
        notificationUpdate.apply(r, false);     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L25
    L13:
        int i2 = 0;
    L15:
        if (i2 >= this.mNotificationList.size()) goto L21;
        NotificationRecord r2 = this.mNotificationList.get(i2);     // Catch: Throwable -> L10
        if (filter.test(r2) == false) goto L19;
        notificationUpdate.apply(r2, true);     // Catch: Throwable -> L10
    L19:
        i2 = i2 + 1;     // Catch: Throwable -> L10
        goto L15
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    void logSmartSuggestionsVisible(NotificationRecord r4, int r5) {
        if (r4.getNumSmartRepliesAdded() > 0) goto L7;
        if (r4.getNumSmartActionsAdded() > 0) goto L7;
        return;
    L7:
        if (r4.hasSeenSmartReplies() == true) goto L11;
        r4.setSeenSmartReplies(true);
        LogMaker r0 = r4.getLogMaker().setCategory(1382).addTaggedData(1384, Integer.valueOf(r4.getNumSmartRepliesAdded())).addTaggedData(AudioChannelMask.OUT_7POINT1, Integer.valueOf(r4.getNumSmartActionsAdded())).addTaggedData(1600, Integer.valueOf(r4.getSuggestionsGeneratedByAssistant() ? 1 : 0)).addTaggedData(1629, Integer.valueOf(r5)).addTaggedData(1647, Integer.valueOf(r4.getEditChoicesBeforeSending() ? 1 : 0));
        this.mMetricsLogger.write(r0);
        this.mNotificationRecordLogger.log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_SMART_REPLY_VISIBLE, r4);
        return;
    }

    protected void logSensitiveAdjustmentReceived(boolean hasPosted, boolean hasSensitiveContent, int lifespanMs) {
        FrameworkStatsLog.write(FrameworkStatsLog.SENSITIVE_NOTIFICATION_REDACTION, hasPosted, hasSensitiveContent, lifespanMs);
    }

    protected void logClassificationChannelAdjustmentReceived(NotificationRecord r, boolean hasPosted, int classification) {
        int r2 = 0;
        if (r.getChannel().getImportance() < 3) goto L5;
        boolean r0 = true;
    L6:
        boolean isAlerting = r0;
        if (r.getSbn().getInstanceId() != null) goto L9;
    L8:
        int instanceId = r2;
        FrameworkStatsLog.write(FrameworkStatsLog.NOTIFICATION_CHANNEL_CLASSIFICATION, hasPosted, isAlerting, classification, r.getLifespanMs(System.currentTimeMillis()), NotificationRecordLogger.NotificationReportedEvent.NOTIFICATION_ADJUSTED.getId(), instanceId, r.getUid());
        return;
    L9:
        r2 = r.getSbn().getInstanceId().getId();
        goto L8
    L5:
        r0 = false;
        goto L6
    }

    public NotificationManagerService(Context context) {
        this(context, new NotificationRecordLoggerImpl(), new InstanceIdSequence(8192));
    }

    public NotificationManagerService(Context context, NotificationRecordLogger notificationRecordLogger, InstanceIdSequence notificationInstanceIdSequence) {
        super(context);
        this.isReplaceTargetPkg = true;
        this.mForegroundToken = new Binder();
        this.mRankingThread = new HandlerThread("ranker", 10);
        this.mListenersDisablingEffects = new SparseArray();
        this.mEffectsSuppressors = new ArrayList();
        this.mInterruptionFilter = 0;
        this.mNotificationLock = new Object();
        this.mNotificationList = new ArrayList();
        this.mNotificationsByKey = new ArrayMap();
        this.mInlineReplyRecordsByKey = new ArrayMap();
        this.mEnqueuedNotifications = new ArrayList();
        this.mAutobundledSummaries = new ArrayMap();
        this.mToastQueue = new ArrayList();
        this.mToastRateLimitingDisabledUids = new ArraySet();
        this.mSummaryByGroupKey = new ArrayMap();
        this.mIsCurrentToastShown = false;
        this.mUserProfiles = new ManagedServices.UserProfiles();
        this.mLockScreenAllowSecureNotifications = true;
        this.mCallNotificationEventCallbacks = new ArrayMap();
        this.mMaxPackageEnqueueRate = DEFAULT_MAX_NOTIFICATION_ENQUEUE_RATE;
        this.mRedactOtpNotifications = true;
        this.mSavePolicyFile = new SavePolicyFileRunnable(this, null);
        this.mMsgPkgsAllowedAsConvos = new HashSet();
        this.mObricExt = (IObricNotificationManagerService) ObricImplFactory.getImpl(IObricNotificationManagerService.class, new Object[]{this});
        this.mNotificationDelegate = new AnonymousClass1(this);
        this.mNotificationManagerPrivate = new AnonymousClass2(this);
        this.mLocaleChangeReceiver = new AnonymousClass3(this);
        this.mRestoreReceiver = new AnonymousClass4(this);
        this.mNotificationTimeoutReceiver = new AnonymousClass5(this);
        this.mPackageIntentReceiver = new AnonymousClass6(this);
        this.mIntentReceiver = new AnonymousClass7(this);
        this.mService = new AnonymousClass12(this);
        this.mInternalService = new AnonymousClass13(this);
        this.mShortcutListener = new AnonymousClass14(this);
        this.mNotificationRecordLogger = notificationRecordLogger;
        this.mNotificationInstanceIdSequence = notificationInstanceIdSequence;
        Notification.processAllowlistToken = ALLOWLIST_TOKEN;
        this.mSmtEx = new NotificationManagerServiceSmtEx(this);
    }

    void setStrongAuthTracker(StrongAuthTracker strongAuthTracker) {
        this.mStrongAuthTracker = strongAuthTracker;
    }

    void setLockPatternUtils(LockPatternUtils lockUtils) {
        this.mLockUtils = lockUtils;
    }

    ShortcutHelper getShortcutHelper() {
        return this.mShortcutHelper;
    }

    void setShortcutHelper(ShortcutHelper helper) {
        this.mShortcutHelper = helper;
    }

    int getNotificationRecordCount() {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        int count = ((this.mNotificationList.size() + this.mNotificationsByKey.size()) + this.mSummaryByGroupKey.size()) + this.mEnqueuedNotifications.size();     // Catch: Throwable -> L15
        Iterator<NotificationRecord> r2 = this.mNotificationList.iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L18;
        NotificationRecord posted = r2.next();     // Catch: Throwable -> L15
        if (this.mNotificationsByKey.containsKey(posted.getKey()) == false) goto L11;
        count = count - 1;     // Catch: Throwable -> L15
    L11:
        if (posted.getSbn().isGroup() == false) goto L6;
        if (posted.getNotification().isGroupSummary() == false) goto L6;
        count = count - 1;     // Catch: Throwable -> L15
        goto L6
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return count;
    L15:
        th = move-exception;
        throw th;
    }

    void clearNotifications() {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mEnqueuedNotifications.clear();     // Catch: Throwable -> L7
        this.mNotificationList.clear();     // Catch: Throwable -> L7
        this.mNotificationsByKey.clear();     // Catch: Throwable -> L7
        this.mSummaryByGroupKey.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addNotification(NotificationRecord r) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mNotificationList.add(r);     // Catch: Throwable -> L7
        this.mNotificationsByKey.put(r.getSbn().getKey(), r);     // Catch: Throwable -> L7
        if (r.getSbn().isGroup() == false) goto L9;
        this.mSummaryByGroupKey.put(r.getGroupKey(), r);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addEnqueuedNotification(NotificationRecord r) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mEnqueuedNotifications.add(r);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    NotificationRecord getNotificationRecord(String key) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        NotificationRecord r1 = this.mNotificationsByKey.get(key);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setHandler(WorkerHandler handler) {
        this.mHandler = handler;
    }

    void setRankingHelper(RankingHelper rankingHelper) {
        this.mRankingHelper = rankingHelper;
    }

    void setPreferencesHelper(PreferencesHelper prefHelper) {
        this.mPreferencesHelper = prefHelper;
    }

    void setZenHelper(ZenModeHelper zenHelper) {
        this.mZenModeHelper = zenHelper;
    }

    void setAttentionHelper(NotificationAttentionHelper nah) {
        this.mAttentionHelper = nah;
    }

    void setIsTelevision(boolean isTelevision) {
        this.mIsTelevision = isTelevision;
    }

    void setTelecomManager(TelecomManager tm) {
        this.mTelecomManager = tm;
    }

    void init(WorkerHandler handler, RankingHandler rankingHandler, Handler broadcastsHandler, IPackageManager packageManager, PackageManager packageManagerClient, LightsManager lightsManager, NotificationListeners notificationListeners, NotificationAssistants notificationAssistants, ConditionProviders conditionProviders, ICompanionDeviceManager companionManager, SnoozeHelper snoozeHelper, NotificationUsageStats usageStats, AtomicFile policyFile, ActivityManager activityManager, GroupHelper groupHelper, IActivityManager am, ActivityTaskManagerInternal atm, UsageStatsManagerInternal appUsageStats, DevicePolicyManagerInternal dpm, IUriGrantsManager ugm, UriGrantsManagerInternal ugmInternal, AppOpsManager appOps, UserManager userManager, NotificationHistoryManager historyManager, StatsManager statsManager, ActivityManagerInternal ami, MultiRateLimiter toastRateLimiter, PermissionHelper permissionHelper, UsageStatsManagerInternal usageStatsManagerInternal, TelecomManager telecomManager, NotificationChannelLogger channelLogger, SystemUiSystemPropertiesFlags.FlagResolver flagResolver, PermissionManager permissionManager, PowerManager powerManager, PostNotificationTrackerFactory postNotificationTrackerFactory, NotificationListenerStats notificationListenerStats) {
        this.mHandler = handler;
        Resources resources = getContext().getResources();
        this.mMaxPackageEnqueueRate = Settings.Global.getFloat(getContext().getContentResolver(), "max_notification_enqueue_rate", DEFAULT_MAX_NOTIFICATION_ENQUEUE_RATE);
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.mAm = am;
        this.mAtm = atm;
        this.mAtm.setBackgroundActivityStartCallback(new NotificationTrampolineCallback(this, null));
        this.mUgm = ugm;
        this.mUgmInternal = ugmInternal;
        this.mPackageManager = packageManager;
        this.mPackageManagerClient = packageManagerClient;
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mPermissionManager = permissionManager;
        this.mPermissionPolicyInternal = (PermissionPolicyInternal) LocalServices.getService(PermissionPolicyInternal.class);
        this.mUmInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mUsageStatsManagerInternal = usageStatsManagerInternal;
        this.mAppOps = appOps;
        this.mAppUsageStats = appUsageStats;
        this.mAlarmManager = (AlarmManager) getContext().getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mCompanionManager = companionManager;
        this.mActivityManager = activityManager;
        this.mAmi = ami;
        this.mDeviceIdleManager = (DeviceIdleManager) getContext().getSystemService(DeviceIdleManager.class);
        this.mDpm = dpm;
        this.mUm = userManager;
        this.mTelecomManager = telecomManager;
        this.mPowerManager = powerManager;
        this.mPostNotificationTrackerFactory = postNotificationTrackerFactory;
        this.mPlatformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        this.mStrongAuthTracker = new StrongAuthTracker(this, getContext());
        String[] extractorNames = resources.getStringArray(R.array.config_roundedCornerRadiusArray);     // Catch: Resources.NotFoundException -> L5
        String[] extractorNames2 = extractorNames;
    L7:
        this.mUsageStats = usageStats;
        this.mMetricsLogger = new MetricsLogger();
        this.mRankingHandler = rankingHandler;
        this.mConditionProviders = conditionProviders;
        this.mNotificationListenerStats = notificationListenerStats;
        this.mZenModeHelper = new ZenModeHelper(getContext(), this.mHandler.getLooper(), Clock.systemUTC(), this.mConditionProviders, flagResolver, new ZenModeEventLogger(this.mPackageManagerClient));
        this.mZenModeHelper.addCallback(new AnonymousClass8(this));
        this.mPermissionHelper = permissionHelper;
        this.mNotificationChannelLogger = channelLogger;
        this.mUserProfiles.updateCache(getContext());
        this.mPreferencesHelper = new PreferencesHelper(getContext(), this.mPackageManagerClient, this.mRankingHandler, this.mZenModeHelper, this.mPermissionHelper, this.mPermissionManager, this.mNotificationChannelLogger, this.mAppOps, this.mUserProfiles, this.mUgmInternal, this.mShowReviewPermissionsNotification, Clock.systemUTC());
        this.mRankingHelper = new RankingHelper(getContext(), this.mRankingHandler, this.mPreferencesHelper, this.mZenModeHelper, this.mUsageStats, extractorNames2, this.mPlatformCompat, groupHelper);
        this.mSnoozeHelper = snoozeHelper;
        this.mGroupHelper = groupHelper;
        this.mHistoryManager = historyManager;
        this.mTtlHelper = new TimeToLiveHelper(this.mNotificationManagerPrivate, getContext());
        this.mListeners = notificationListeners;
        this.mAssistants = notificationAssistants;
        this.mAllowedManagedServicePackages = new NotificationManagerService$$ExternalSyntheticLambda2(this);
        this.mPolicyFile = policyFile;
        loadPolicyFile();
        this.mStatusBar = (StatusBarManagerInternal) getLocalService(StatusBarManagerInternal.class);
        if (this.mStatusBar == null) goto L10;
        this.mStatusBar.setNotificationDelegate(this.mNotificationDelegate);
    L10:
        this.mZenModeHelper.initZenMode();
        this.mInterruptionFilter = this.mZenModeHelper.getZenModeListenerInterruptionFilter();
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mArchive = new Archive(resources.getInteger(R.integer.config_num_physical_slots));
        if (this.mPackageManagerClient.hasSystemFeature("android.software.leanback") == false) goto L13;
    L16:
        boolean r2 = true;
    L17:
        this.mIsTelevision = r2;
        this.mZenModeHelper.setPriorityOnlyDndExemptPackages(getContext().getResources().getStringArray(R.array.config_screenDarkeningThresholds));
        this.mWarnRemoteViewsSizeBytes = getContext().getResources().getInteger(R.integer.config_overrideHasPermanentMenuKey);
        this.mStripRemoteViewsSizeBytes = getContext().getResources().getInteger(R.integer.config_oem_enabled_satellite_location_fresh_duration);
        this.mMsgPkgsAllowedAsConvos = Set.of(getStringArrayResource(R.array.config_roundedCornerRadiusAdjustmentArray));
        this.mDefaultSearchSelectorPkg = getContext().getString(getContext().getResources().getIdentifier("config_defaultSearchSelectorPackageName", "string", PackageManagerService.PLATFORM_PACKAGE_NAME));
        this.mFlagResolver = flagResolver;
        this.mStatsManager = statsManager;
        this.mToastRateLimiter = toastRateLimiter;
        this.mAttentionHelper = new NotificationAttentionHelper(getContext(), this.mNotificationLock, lightsManager, this.mAccessibilityManager, this.mPackageManagerClient, userManager, usageStats, this.mNotificationManagerPrivate, this.mZenModeHelper, flagResolver);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_STOPPED");
        filter.addAction("android.intent.action.USER_ADDED");
        filter.addAction("android.intent.action.USER_REMOVED");
        filter.addAction("android.intent.action.USER_UNLOCKED");
        filter.addAction("android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
        if (privateSpaceFlagsEnabled() == false) goto L20;
        filter.addAction("android.intent.action.PROFILE_UNAVAILABLE");
    L20:
        getContext().registerReceiverAsUser(this.mIntentReceiver, UserHandle.ALL, filter, null, null);
        IntentFilter pkgFilter = new IntentFilter();
        pkgFilter.addAction("android.intent.action.PACKAGE_ADDED");
        pkgFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        pkgFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        pkgFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        pkgFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        getContext().registerReceiverAsUser(this.mPackageIntentReceiver, UserHandle.ALL, pkgFilter, null, null);
        IntentFilter suspendedPkgFilter = new IntentFilter();
        suspendedPkgFilter.addAction("android.intent.action.PACKAGES_SUSPENDED");
        suspendedPkgFilter.addAction("android.intent.action.PACKAGES_UNSUSPENDED");
        suspendedPkgFilter.addAction("android.intent.action.DISTRACTING_PACKAGES_CHANGED");
        getContext().registerReceiverAsUser(this.mPackageIntentReceiver, UserHandle.ALL, suspendedPkgFilter, null, null);
        IntentFilter sdFilter = new IntentFilter("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        getContext().registerReceiverAsUser(this.mPackageIntentReceiver, UserHandle.ALL, sdFilter, null, null);
        IntentFilter settingsRestoredFilter = new IntentFilter("android.os.action.SETTING_RESTORED");
        getContext().registerReceiver(this.mRestoreReceiver, settingsRestoredFilter);
        IntentFilter localeChangedFilter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        getContext().registerReceiver(this.mLocaleChangeReceiver, localeChangedFilter);
        this.mReviewNotificationPermissionsReceiver = new ReviewNotificationPermissionsReceiver();
        Context r0 = getContext();
        ReviewNotificationPermissionsReceiver r5 = this.mReviewNotificationPermissionsReceiver;
        IntentFilter localeChangedFilter2 = ReviewNotificationPermissionsReceiver.getFilter();
        r0.registerReceiver(r5, localeChangedFilter2, 4);
        this.mAppOpsListener = new AnonymousClass9(this);
        this.mAppOps.startWatchingMode(11, null, this.mAppOpsListener);
        this.mObricExt.allowNotificationListenerForSpecificApps();
        return;
    L13:
        if (this.mPackageManagerClient.hasSystemFeature("android.hardware.type.television") == true) goto L16;
        r2 = false;
    L6:
        extractorNames2 = new String[0];
        goto L7
    }

    public void onDestroy() {
        if (this.mIntentReceiver == null) goto L6;
        getContext().unregisterReceiver(this.mIntentReceiver);
    L6:
        if (this.mPackageIntentReceiver == null) goto L9;
        getContext().unregisterReceiver(this.mPackageIntentReceiver);
    L9:
        if (this.mTtlHelper == null) goto L12;
        this.mTtlHelper.destroy();
    L12:
        if (this.mRestoreReceiver == null) goto L15;
        getContext().unregisterReceiver(this.mRestoreReceiver);
    L15:
        if (this.mLocaleChangeReceiver == null) goto L18;
        getContext().unregisterReceiver(this.mLocaleChangeReceiver);
    L18:
        if (this.mSettingsObserver == null) goto L21;
        this.mSettingsObserver.destroy();
    L21:
        if (this.mRoleObserver == null) goto L24;
        this.mRoleObserver.destroy();
    L24:
        if (this.mShortcutHelper == null) goto L27;
        this.mShortcutHelper.destroy();
    L27:
        if (this.mStatsManager == null) goto L30;
        this.mStatsManager.clearPullAtomCallback(FrameworkStatsLog.PACKAGE_NOTIFICATION_PREFERENCES);
        this.mStatsManager.clearPullAtomCallback(FrameworkStatsLog.PACKAGE_NOTIFICATION_CHANNEL_PREFERENCES);
        this.mStatsManager.clearPullAtomCallback(FrameworkStatsLog.PACKAGE_NOTIFICATION_CHANNEL_GROUP_PREFERENCES);
        this.mStatsManager.clearPullAtomCallback(FrameworkStatsLog.NOTIFICATION_BUNDLE_PREFERENCES);
        this.mStatsManager.clearPullAtomCallback(FrameworkStatsLog.DND_MODE_RULE);
    L30:
        if (this.mAppOps == null) goto L33;
        this.mAppOps.stopWatchingMode(this.mAppOpsListener);
    L33:
        if (this.mAlarmManager == null) goto L36;
        this.mAlarmManager.cancelAll();
        return;
    }

    protected String[] getStringArrayResource(int key) {
        return getContext().getResources().getStringArray(key);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        SnoozeHelper snoozeHelper = new SnoozeHelper(getContext(), new NotificationManagerService$$ExternalSyntheticLambda21(this), this.mUserProfiles);
        File systemDir = new File(Environment.getDataDirectory(), "system");
        this.mRankingThread.start();
        WorkerHandler handler = new WorkerHandler(this, Looper.myLooper());
        this.mShowReviewPermissionsNotification = getContext().getResources().getBoolean(R.bool.config_performantAuthDefault);
        this.mDefaultUnsupportedAdjustments = getContext().getResources().getStringArray(R.array.config_ringtoneEffectUris);
        RankingHandlerWorker r9 = new RankingHandlerWorker(this, this.mRankingThread.getLooper());
        IPackageManager r10 = AppGlobals.getPackageManager();
        PackageManager r12 = getContext().getPackageManager();
        LightsManager r13 = (LightsManager) getLocalService(LightsManager.class);
        NotificationListeners r0 = new NotificationListeners(this, getContext(), this.mNotificationLock, this.mUserProfiles, AppGlobals.getPackageManager());
        NotificationAssistants r1 = new NotificationAssistants(this, getContext(), this.mNotificationLock, this.mUserProfiles, AppGlobals.getPackageManager());
        ConditionProviders r11 = new ConditionProviders(getContext(), this.mUserProfiles, AppGlobals.getPackageManager());
        NotificationUsageStats r14 = new NotificationUsageStats(getContext());
        AtomicFile r15 = new AtomicFile(new File(systemDir, "notification_policy.xml"), TAG_NOTIFICATION_POLICY);
        ActivityManager r4 = (ActivityManager) getContext().getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        GroupHelper r16 = getGroupHelper();
        IActivityManager r17 = ActivityManager.getService();
        ActivityTaskManagerInternal r18 = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        UsageStatsManagerInternal r19 = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        DevicePolicyManagerInternal r20 = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        IUriGrantsManager r21 = UriGrantsManager.getService();
        UriGrantsManagerInternal r22 = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        AppOpsManager r2 = (AppOpsManager) getContext().getSystemService(AppOpsManager.class);
        UserManager r3 = (UserManager) getContext().getSystemService(UserManager.class);
        NotificationHistoryManager r5 = new NotificationHistoryManager(getContext(), handler);
        StatsManager r6 = (StatsManager) getContext().getSystemService("stats");
        this.mStatsManager = r6;
        init(handler, r9, null, r10, r12, r13, r0, r1, r11, null, snoozeHelper, r14, r15, r4, r16, r17, r18, r19, r20, r21, r22, r2, r3, r5, r6, (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class), createToastRateLimiter(), new PermissionHelper(getContext(), AppGlobals.getPackageManager(), AppGlobals.getPermissionManager()), (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class), (TelecomManager) getContext().getSystemService(TelecomManager.class), new NotificationChannelLoggerImpl(), SystemUiSystemPropertiesFlags.getResolver(), (PermissionManager) getContext().getSystemService(PermissionManager.class), (PowerManager) getContext().getSystemService(PowerManager.class), new AnonymousClass10(this), new NotificationListenerStats());
        publishBinderService("notification", this.mService, false, 5);
        publishLocalService(NotificationManagerInternal.class, this.mInternalService);
    }

    private /* synthetic */ void lambda$onStart$4(int userId, NotificationRecord r, boolean muteOnReturn) {
    L8:
        e = e;
    L15:
        Slog.e(TAG, "Cannot un-snooze notification", e);
        return;
    L4:
        if (DBG == true) goto L17;
        boolean r12 = muteOnReturn;
    L13:
        enqueueNotificationInternal(r.getSbn().getPackageName(), r.getSbn().getOpPkg(), r.getSbn().getUid(), r.getSbn().getInitialPid(), r.getSbn().getTag(), r.getSbn().getId(), r.getSbn().getNotification(), userId, r12, false, false);     // Catch: Exception -> L8
        return;
    L17:
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L10
        r0.append("Reposting ");     // Catch: Exception -> L10
        r0.append(r.getKey());     // Catch: Exception -> L10
        r0.append(" ");     // Catch: Exception -> L10
        r12 = muteOnReturn;
        r0.append(r12);     // Catch: Exception -> L8
        Slog.d(TAG, r0.toString());     // Catch: Exception -> L8
    L10:
        e = e;
        goto L15
    }

    private void registerNotificationPreferencesPullers() {
        this.mPullAtomCallback = new StatsPullAtomCallbackImpl(this, null);
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PACKAGE_NOTIFICATION_PREFERENCES, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mPullAtomCallback);
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PACKAGE_NOTIFICATION_CHANNEL_PREFERENCES, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mPullAtomCallback);
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PACKAGE_NOTIFICATION_CHANNEL_GROUP_PREFERENCES, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mPullAtomCallback);
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DND_MODE_RULE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mPullAtomCallback);
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.NOTIFICATION_BUNDLE_PREFERENCES, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mPullAtomCallback);
    }

    private int pullNotificationStates(int atomTag, List<StatsEvent> data) {
        switch(atomTag) {
            case 10071: goto L8;
            case 10072: goto L7;
            case 10073: goto L6;
            case 10084: goto L5;
            case 10231: goto L14;
            default: goto L14;
        };
    L5:
        this.mZenModeHelper.pullRules(data);
        return 0;
    L6:
        this.mPreferencesHelper.pullPackageChannelGroupPreferencesStats(data);
        return 0;
    L7:
        this.mPreferencesHelper.pullPackageChannelPreferencesStats(data);
        return 0;
    L8:
        this.mPreferencesHelper.pullPackagePreferencesStats(data, getAllUsersNotificationPermissions());
        return 0;
    L14:
        return 0;
    }

    private GroupHelper getGroupHelper() {
        this.mAutoGroupAtCount = getContext().getResources().getInteger(R.integer.config_bg_current_drain_power_components);
        return new GroupHelper(getContext(), getContext().getPackageManager(), this.mAutoGroupAtCount, 6, new AnonymousClass11(this));
    }

    void setTestHarnessExempted(boolean isExempted) {
        this.mGroupHelper.setTestHarnessExempted(isExempted);
    }

    private void sendRegisteredOnlyBroadcast(String action) {
        sendRegisteredOnlyBroadcast(new Intent(action));
    }

    private void sendZenBroadcastWithDelay(final Intent intent) {
        String token = "zen_broadcast:" + intent.getAction();
        this.mBroadcastsHandler.removeCallbacksAndEqualMessages(token);
        this.mBroadcastsHandler.postDelayed(new NotificationManagerService$$ExternalSyntheticLambda17(this, intent), token, ZEN_BROADCAST_DELAY.toMillis());
    }

    private /* synthetic */ void lambda$sendZenBroadcastWithDelay$5(Intent intent) {
        sendRegisteredOnlyBroadcast(intent);
    }

    private void sendRegisteredOnlyBroadcast(Intent baseIntent) {
        int[] userIds = this.mUmInternal.getProfileIds(this.mAmi.getCurrentUserId(), true);
        Intent intent = new Intent(baseIntent).addFlags(1073741824);
        int r2 = userIds.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        getContext().sendBroadcastAsUser(intent, UserHandle.of(userIds[r4]), null);
        r4 = r4 + 1;
        goto L3
    L5:
        int r5 = userIds.length;
    L7:
        if (r3 >= r5) goto L13;
        int userId = userIds[r3];
        Iterator<String> r6 = this.mConditionProviders.getAllowedPackages(userId).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        String pkg = r6.next();
        Intent pkgIntent = new Intent(baseIntent).setPackage(pkg).setFlags(67108864);
        getContext().sendBroadcastAsUser(pkgIntent, UserHandle.of(userId));
        goto L10
    L12:
        r3 = r3 + 1;
        goto L7
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        onBootPhase(phase, Looper.getMainLooper());
    }

    void onBootPhase(int phase, Looper mainLooper) {
        if (phase != 500) goto L11;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mZenModeHelper.onSystemReady();
        NotificationManagerService r2 = this;
        RoleObserver roleObserver = new RoleObserver(r2, getContext(), (RoleManager) getContext().getSystemService(RoleManager.class), this.mPackageManager, mainLooper);
        roleObserver.init();
        r2.mRoleObserver = roleObserver;
        LauncherApps launcherApps = (LauncherApps) getContext().getSystemService("launcherapps");
        UserManager userManager = (UserManager) getContext().getSystemService("user");
        r2.mShortcutHelper = new ShortcutHelper(launcherApps, r2.mShortcutListener, (ShortcutServiceInternal) getLocalService(ShortcutServiceInternal.class), userManager);
        BubbleExtractor bubbsExtractor = (BubbleExtractor) r2.mRankingHelper.findExtractor(BubbleExtractor.class);
        if (bubbsExtractor == null) goto L7;
        bubbsExtractor.setShortcutHelper(r2.mShortcutHelper);
        bubbsExtractor.setPackageManager(r2.mPackageManagerClient);
    L7:
        registerNotificationPreferencesPullers();
        if (r2.mLockUtils != null) goto L10;
        r2.mLockUtils = new LockPatternUtils(getContext());
    L10:
        r2.mLockUtils.registerStrongAuthTracker(r2.mStrongAuthTracker);
        r2.mAttentionHelper.onSystemReady();
    L36:
        getSmtEx().onBootPhase(phase, r2.mHandler);
        return;
    L11:
        r2 = this;
        if (phase != 600) goto L25;
        r2.mSettingsObserver.observe();
        r2.mListeners.onBootPhaseAppsCanStart();
        r2.mAssistants.onBootPhaseAppsCanStart();
        r2.mConditionProviders.onBootPhaseAppsCanStart();
        r2.mHistoryManager.onBootPhaseAppsCanStart();
        r2.mPreferencesHelper.onBootPhaseAppsCanStart();
        migrateDefaultNAS();
        maybeShowInitialReviewPermissionsNotification();
        if (r2.mZenModeHelper.hasDeviceEffectsApplier() == true) goto L16;
        r2.mZenModeHelper.setDeviceEffectsApplier(new DefaultDeviceEffectsApplier(getContext()));
    L16:
        List<ModuleInfo> moduleInfoList = r2.mPackageManagerClient.getInstalledModules(268435456);
        Iterator<ModuleInfo> r0 = moduleInfoList.iterator();
    L18:
        if (r0.hasNext() == false) goto L36;
        ModuleInfo mi = r0.next();
        if (Objects.equals(mi.getApexModuleName(), ADSERVICES_MODULE_PKG_NAME) == false) goto L18;
        r2.mAdservicesModuleInfo = mi;
        goto L18
    L25:
        if (phase != 550) goto L28;
        r2.mSnoozeHelper.scheduleRepostsForPersistedNotifications(System.currentTimeMillis());
        goto L36
    L28:
        if (phase != 520) goto L31;
        r2.mPreferencesHelper.updateFixedImportance(r2.mUm.getUsers());
        r2.mPreferencesHelper.migrateNotificationPermissions(r2.mUm.getUsers());
        goto L36
    L31:
        if (phase != 1000) goto L36;
        if (r2.mFlagResolver.isEnabled(SystemUiSystemPropertiesFlags.NotificationFlags.DEBUG_SHORT_BITMAP_DURATION) == false) goto L35;
        new Thread(new NotificationManagerService$$ExternalSyntheticLambda4(this)).start();
        goto L36
    L35:
        NotificationBitmapJobService.scheduleJob(getContext());
        goto L36
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    private /* synthetic */ void lambda$onBootPhase$6() {
    L8:
        Thread.sleep(MIN_PACKAGE_OVERRATE_LOG_INTERVAL);     // Catch: InterruptedException -> L5
    L7:
        this.mInternalService.removeBitmaps();
        goto L8
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocked(final SystemService.TargetUser user) {
        this.mHandler.post(new NotificationManagerService$$ExternalSyntheticLambda5(this, user));
    }

    private /* synthetic */ void lambda$onUserUnlocked$7(SystemService.TargetUser user) {
        Trace.traceBegin(524288, "notifHistoryUnlockUser");
        this.mHistoryManager.onUserUnlocked(user.getUserIdentifier());     // Catch: Throwable -> L6
        Trace.traceEnd(524288);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    }

    private void sendAppBlockStateChangedBroadcast(final String pkg, final int uid, final boolean blocked) {
        this.mHandler.postDelayed(new NotificationManagerService$$ExternalSyntheticLambda14(this, blocked, pkg, uid), 500);
    }

    private /* synthetic */ void lambda$sendAppBlockStateChangedBroadcast$8(boolean blocked, String pkg, int uid) {
        getContext().sendBroadcastAsUser(new Intent("android.app.action.APP_BLOCK_STATE_CHANGED").putExtra("android.app.extra.BLOCKED_STATE", blocked).addFlags(268435456).setPackage(pkg), UserHandle.of(UserHandle.getUserId(uid)), null);     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Can't notify app about app block change", e);
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        int userId = to.getUserIdentifier();
        this.mUserProfiles.updateCache(getContext());
        if (this.mUserProfiles.isProfileUser(userId, getContext()) == true) goto L5;
        this.mSettingsObserver.update(null);
        this.mConditionProviders.onUserSwitched(userId);
        this.mListeners.onUserSwitched(userId);
        this.mZenModeHelper.onUserSwitched(userId);
        this.mPreferencesHelper.syncHasPriorityChannels();
    L5:
        this.mAssistants.onUserSwitched(userId);
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(final SystemService.TargetUser user) {
        this.mHandler.post(new NotificationManagerService$$ExternalSyntheticLambda19(this, user));
    }

    private /* synthetic */ void lambda$onUserStopping$9(SystemService.TargetUser user) {
        Trace.traceBegin(524288, "notifHistoryStopUser");
        this.mHistoryManager.onUserStopped(user.getUserIdentifier());     // Catch: Throwable -> L6
        Trace.traceEnd(524288);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    }

    private void updateListenerHintsLocked() {
        int hints = calculateHints();
        if (hints != this.mListenerHints) goto L5;
        return;
    L5:
        ZenLog.traceListenerHintsChanged(this.mListenerHints, hints, this.mEffectsSuppressors.size());
        this.mListenerHints = hints;
        scheduleListenerHintsChanged(hints);
    }

    private void updateEffectsSuppressorLocked() {
        long oldSuppressedEffects = this.mZenModeHelper.getSuppressedEffects();
        long updatedSuppressedEffects = calculateSuppressedEffects();
        if (updatedSuppressedEffects != oldSuppressedEffects) goto L5;
        return;
    L5:
        List<ComponentName> suppressors = getSuppressors();
        ZenLog.traceEffectsSuppressorChanged(this.mEffectsSuppressors, suppressors, oldSuppressedEffects, updatedSuppressedEffects);
        this.mZenModeHelper.setSuppressedEffects(updatedSuppressedEffects);
        this.mEffectsSuppressors = suppressors;
        sendRegisteredOnlyBroadcast("android.os.action.ACTION_EFFECTS_SUPPRESSOR_CHANGED");
    }

    private void exitIdle() {
        if (this.mDeviceIdleManager == null) goto L6;
        this.mDeviceIdleManager.endIdle("notification interaction");
        return;
    }

    void updateNotificationChannelInt(final String pkg, final int uid, NotificationChannel channel, boolean fromListener) {
        if (channel.getImportance() != 0) goto L9;
        cancelAllNotificationsInt(MY_UID, MY_PID, pkg, channel.getId(), 0, 0, UserHandle.getUserId(uid), 17);
        if (isUidSystemOrPhone(uid) == false) goto L9;
        IntArray profileIds = this.mUserProfiles.getCurrentProfileIds();
        int N = profileIds.size();
        int i = 0;
    L7:
        if (i >= N) goto L9;
        int profileId = profileIds.get(i);
        cancelAllNotificationsInt(MY_UID, MY_PID, pkg, channel.getId(), 0, 0, profileId, 17);
        i = i + 1;
    L9:
        NotificationChannel preUpdate = this.mPreferencesHelper.getNotificationChannel(pkg, uid, channel.getId(), true);
        this.mPreferencesHelper.updateNotificationChannel(pkg, uid, channel, true, Binder.getCallingUid(), isCallerSystemOrSystemUi());
        if (this.mPreferencesHelper.onlyHasDefaultChannel(pkg, uid) == false) goto L16;
        PermissionHelper r0 = this.mPermissionHelper;
        int r4 = UserHandle.getUserId(uid);
        if (channel.getImportance() == 0) goto L14;
        boolean r5 = true;
    L15:
        r0.setNotificationPermission(pkg, r4, r5, true);
        goto L16
    L14:
        r5 = false;
    L16:
        maybeNotifyChannelOwner(pkg, uid, preUpdate, channel);
        if (fromListener == true) goto L19;
        NotificationChannel modifiedChannel = this.mPreferencesHelper.getNotificationChannel(pkg, uid, channel.getId(), false);
        this.mListeners.notifyNotificationChannelChanged(pkg, UserHandle.getUserHandleForUid(uid), modifiedChannel, 2);
    L19:
        final NotificationChannel updatedChannel = this.mPreferencesHelper.getNotificationChannel(pkg, uid, channel.getId(), false);
        this.mHandler.postDelayed(new NotificationManagerService$$ExternalSyntheticLambda16(this, uid, pkg, updatedChannel), 3000);
        handleSavePolicyFile();
    }

    private /* synthetic */ void lambda$updateNotificationChannelInt$10(int uid, String pkg, NotificationChannel updatedChannel) {
        Object r1 = this.mNotificationLock;
        monitor-enter(r1);
        this.mGroupHelper.onChannelUpdated(UserHandle.getUserHandleForUid(uid).getIdentifier(), pkg, updatedChannel, this.mNotificationList, this.mSummaryByGroupKey);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    private void maybeNotifyChannelOwner(String pkg, int uid, NotificationChannel preUpdate, NotificationChannel update) {
    L7:
        e = move-exception;
        Slog.w(TAG, "Can't notify app about channel change", e);
        return;
    L3:
        if (preUpdate.getImportance() != 0) goto L10;
        if (update.getImportance() == 0) goto L10;
    L13:
        Context r0 = getContext();     // Catch: SecurityException -> L7
        Intent r1 = new Intent("android.app.action.NOTIFICATION_CHANNEL_BLOCK_STATE_CHANGED").putExtra("android.app.extra.NOTIFICATION_CHANNEL_ID", update.getId());     // Catch: SecurityException -> L7
        if (update.getImportance() != 0) goto L16;
        boolean r3 = true;
    L17:
        r0.sendBroadcastAsUser(r1.putExtra("android.app.extra.BLOCKED_STATE", r3).addFlags(268435456).setPackage(pkg), UserHandle.of(UserHandle.getUserId(uid)), null);     // Catch: SecurityException -> L7
        return;
    L16:
        r3 = false;
    L10:
        if (preUpdate.getImportance() != 0) goto L12;
        return;
    L12:
        if (update.getImportance() == 0) goto L13;
    }

    void createNotificationChannelGroup(String pkg, int uid, NotificationChannelGroup group, boolean fromApp, boolean fromListener) {
        group.getClass();
        pkg.getClass();
        NotificationChannelGroup preUpdate = this.mPreferencesHelper.getNotificationChannelGroup(group.getId(), pkg, uid);
        this.mPreferencesHelper.createNotificationChannelGroup(pkg, uid, group, fromApp, Binder.getCallingUid(), isCallerSystemOrSystemUi());
        if (fromApp == true) goto L5;
        maybeNotifyChannelGroupOwner(pkg, uid, preUpdate, group);
    L5:
        if (fromListener == true) goto L8;
        this.mListeners.notifyNotificationChannelGroupChanged(pkg, UserHandle.of(UserHandle.getCallingUserId()), group, 1);
        return;
    }

    private void maybeNotifyChannelGroupOwner(String pkg, int uid, NotificationChannelGroup preUpdate, NotificationChannelGroup update) {
    L6:
        e = move-exception;
        Slog.w(TAG, "Can't notify app about group change", e);
        return;
    L3:
        if (preUpdate.isBlocked() == update.isBlocked()) goto L13;
        getContext().sendBroadcastAsUser(new Intent("android.app.action.NOTIFICATION_CHANNEL_GROUP_BLOCK_STATE_CHANGED").putExtra("android.app.extra.NOTIFICATION_CHANNEL_GROUP_ID", update.getId()).putExtra("android.app.extra.BLOCKED_STATE", update.isBlocked()).addFlags(268435456).setPackage(pkg), UserHandle.of(UserHandle.getUserId(uid)), null);     // Catch: SecurityException -> L6
        return;
    }

    private ArrayList<ComponentName> getSuppressors() {
        ArrayList<ComponentName> names = new ArrayList();
        int i = this.mListenersDisablingEffects.size() - 1;
    L3:
        if (i < 0) goto L10;
        ArraySet<ComponentName> serviceInfoList = this.mListenersDisablingEffects.valueAt(i);
        Iterator<ComponentName> r3 = serviceInfoList.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ComponentName info = r3.next();
        names.add(info);
        goto L6
    L8:
        i = i - 1;
        goto L3
    L10:
        return names;
    }

    private boolean removeDisabledHints(ManagedServices.ManagedServiceInfo info) {
        return removeDisabledHints(info, 0);
    }

    private boolean removeDisabledHints(ManagedServices.ManagedServiceInfo info, int hints) {
        boolean removed = false;
        int i = this.mListenersDisablingEffects.size() - 1;
    L3:
        if (i < 0) goto L11;
        int hint = this.mListenersDisablingEffects.keyAt(i);
        ArraySet<ComponentName> listeners = this.mListenersDisablingEffects.valueAt(i);
        if (hints != 0) goto L7;
    L8:
        removed = removed | listeners.remove(info.component);
    L9:
        i = i - 1;
        goto L3
    L7:
        if ((hint & hints) != hint) goto L9;
    L11:
        return removed;
    }

    private void addDisabledHints(ManagedServices.ManagedServiceInfo info, int hints) {
        if ((hints & 1) == 0) goto L6;
        addDisabledHint(info, 1);
    L6:
        if ((hints & 2) == 0) goto L9;
        addDisabledHint(info, 2);
    L9:
        if ((hints & 4) == 0) goto L12;
        addDisabledHint(info, 4);
        return;
    }

    private void addDisabledHint(ManagedServices.ManagedServiceInfo info, int hint) {
        if (this.mListenersDisablingEffects.indexOfKey(hint) >= 0) goto L5;
        this.mListenersDisablingEffects.put(hint, new ArraySet());
    L5:
        ArraySet<ComponentName> hintListeners = this.mListenersDisablingEffects.get(hint);
        hintListeners.add(info.component);
    }

    private int calculateHints() {
        int hints = 0;
        int i = this.mListenersDisablingEffects.size() - 1;
    L3:
        if (i < 0) goto L9;
        int hint = this.mListenersDisablingEffects.keyAt(i);
        ArraySet<ComponentName> serviceInfoList = this.mListenersDisablingEffects.valueAt(i);
        if (serviceInfoList.isEmpty() == true) goto L7;
        hints = hints | hint;
    L7:
        i = i - 1;
        goto L3
    L9:
        return hints;
    }

    private long calculateSuppressedEffects() {
        int hints = calculateHints();
        long suppressedEffects = 0;
        if ((hints & 1) == 0) goto L6;
        suppressedEffects = 0 | 3;
    L6:
        if ((hints & 2) == 0) goto L9;
        suppressedEffects = suppressedEffects | 1;
    L9:
        if ((hints & 4) != 0) goto L11;
        return suppressedEffects;
    L11:
        return suppressedEffects | 2;
    }

    private void updateInterruptionFilterLocked() {
        int interruptionFilter = this.mZenModeHelper.getZenModeListenerInterruptionFilter();
        if (interruptionFilter != this.mInterruptionFilter) goto L5;
        return;
    L5:
        this.mInterruptionFilter = interruptionFilter;
        scheduleInterruptionFilterChanged(interruptionFilter);
    }

    int correctCategory(int requestedCategoryList, int categoryType, int currentCategoryList) {
        if ((requestedCategoryList & categoryType) == 0) goto L8;
        if ((currentCategoryList & categoryType) != 0) goto L8;
        return requestedCategoryList & (~categoryType);
    L8:
        if ((requestedCategoryList & categoryType) == 0) goto L10;
        return requestedCategoryList;
    L10:
        if ((currentCategoryList & categoryType) != 0) goto L12;
        return requestedCategoryList;
    L12:
        return requestedCategoryList | categoryType;
    }

    INotificationManager getBinderService() {
        return INotificationManager.Stub.asInterface(this.mService);
    }

    protected void reportSeen(NotificationRecord r) {
        if (r.isProxied() == true) goto L6;
        this.mAppUsageStats.reportEvent(r.getSbn().getPackageName(), getRealUserId(r.getSbn().getUserId()), 10);
        return;
    }

    protected int calculateSuppressedVisualEffects(NotificationManager.Policy incomingPolicy, NotificationManager.Policy currPolicy, int targetSdkVersion) {
        if (incomingPolicy.suppressedVisualEffects == (-1)) goto L5;
        int[] effectsIntroducedInP = {4, 8, 16, 32, 64, 128, 256};
        int newSuppressedVisualEffects = incomingPolicy.suppressedVisualEffects;
        if (targetSdkVersion >= 28) goto L19;
        int i = 0;
    L10:
        if (i >= effectsIntroducedInP.length) goto L13;
        newSuppressedVisualEffects = (newSuppressedVisualEffects & (~effectsIntroducedInP[i])) | (currPolicy.suppressedVisualEffects & effectsIntroducedInP[i]);
        i = i + 1;
        goto L10
    L13:
        if ((1 & newSuppressedVisualEffects) == 0) goto L16;
        newSuppressedVisualEffects = (newSuppressedVisualEffects | 8) | 4;
    L16:
        if ((newSuppressedVisualEffects & 2) != 0) goto L42;
        return newSuppressedVisualEffects;
    L42:
        return newSuppressedVisualEffects | 16;
    L19:
        if (((newSuppressedVisualEffects - 2) - 1) <= 0) goto L21;
        boolean hasNewEffects = true;
    L22:
        if (hasNewEffects == false) goto L34;
        int newSuppressedVisualEffects2 = newSuppressedVisualEffects & (-4);
        if ((newSuppressedVisualEffects2 & 16) == 0) goto L27;
        newSuppressedVisualEffects2 = newSuppressedVisualEffects2 | 2;
    L27:
        if ((newSuppressedVisualEffects2 & 8) != 0) goto L29;
        return newSuppressedVisualEffects2;
    L29:
        if ((newSuppressedVisualEffects2 & 4) != 0) goto L31;
        return newSuppressedVisualEffects2;
    L31:
        if ((newSuppressedVisualEffects2 & 128) != 0) goto L46;
        return newSuppressedVisualEffects2;
    L46:
        return newSuppressedVisualEffects2 | 1;
    L34:
        if ((1 & newSuppressedVisualEffects) == 0) goto L37;
        newSuppressedVisualEffects = ((newSuppressedVisualEffects | 8) | 4) | 128;
    L37:
        if ((newSuppressedVisualEffects & 2) != 0) goto L39;
        return newSuppressedVisualEffects;
    L39:
        return newSuppressedVisualEffects | 16;
    L21:
        hasNewEffects = false;
        goto L22
    L5:
        return incomingPolicy.suppressedVisualEffects;
    }

    protected void maybeRecordInterruptionLocked(NotificationRecord r) {
        if (r.isInterruptive() == true) goto L5;
        return;
    L5:
        if (r.hasRecordedInterruption() == true) goto L19;
        this.mAppUsageStats.reportInterruptiveNotification(r.getSbn().getPackageName(), r.getChannel().getId(), getRealUserId(r.getSbn().getUserId()));
        Trace.traceBegin(524288, "notifHistoryAddItem");
    L11:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    L8:
        if (r.getNotification().getSmallIcon() == null) goto L13;
        this.mHistoryManager.addNotification(new NotificationHistory.HistoricalNotification.Builder().setPackage(r.getSbn().getPackageName()).setUid(r.getSbn().getUid()).setUserId(r.getSbn().getNormalizedUserId()).setChannelId(r.getChannel().getId()).setChannelName(r.getChannel().getName().toString()).setPostedTimeMs(System.currentTimeMillis()).setTitle(getHistoryTitle(r.getNotification())).setText(getHistoryText(r.getNotification())).setIcon(r.getNotification().getSmallIcon()).build());     // Catch: Throwable -> L11
    L13:
        Trace.traceEnd(524288);
        r.setRecordedInterruption(true);
        return;
    }

    protected void reportForegroundServiceUpdate(final boolean shown, final Notification notification, final int id, final String pkg, final int userId) {
        this.mHandler.post(new NotificationManagerService$$ExternalSyntheticLambda15(this, shown, notification, id, pkg, userId));
    }

    private /* synthetic */ void lambda$reportForegroundServiceUpdate$11(boolean shown, Notification notification, int id, String pkg, int userId) {
        this.mAmi.onForegroundServiceNotificationUpdate(shown, notification, id, pkg, userId);
    }

    protected void maybeReportForegroundServiceUpdate(NotificationRecord r, boolean shown) {
        if (r.isForegroundService() == false) goto L6;
        StatusBarNotification sbn = r.getSbn();
        reportForegroundServiceUpdate(shown, sbn.getNotification(), sbn.getId(), sbn.getPackageName(), sbn.getUser().getIdentifier());
        return;
    }

    private String getHistoryTitle(Notification n) {
        CharSequence title = null;
        if (n.extras == null) goto L7;
        title = n.extras.getCharSequence("android.title");
        if (title != null) goto L7;
        title = n.extras.getCharSequence("android.title.big");
    L7:
        if (title != null) goto L10;
        return getContext().getResources().getString(R.string.permdesc_reorderTasks);
    L10:
        return String.valueOf(title);
    }

    private String getHistoryText(Notification n) {
        CharSequence text = null;
        if (n.extras == null) goto L17;
        text = n.extras.getCharSequence("android.text");
        Notification.Builder nb = Notification.Builder.recoverBuilder(getContext(), n);
        if ((nb.getStyle() instanceof Notification.BigTextStyle) == false) goto L8;
        text = ((Notification.BigTextStyle) nb.getStyle()).getBigText();
    L15:
        if (TextUtils.isEmpty(text) == false) goto L17;
        text = n.extras.getCharSequence("android.text");
        goto L17
    L8:
        if ((nb.getStyle() instanceof Notification.MessagingStyle) == false) goto L15;
        Notification.MessagingStyle ms = (Notification.MessagingStyle) nb.getStyle();
        List<Notification.MessagingStyle.Message> messages = ms.getMessages();
        if (messages == null) goto L15;
        if (messages.size() <= 0) goto L15;
        text = messages.get(messages.size() - 1).getText();
    L17:
        if (text != null) goto L20;
        return null;
    L20:
        return String.valueOf(text);
    }

    protected void maybeRegisterMessageSent(NotificationRecord r) {
        if (r.isConversation() == true) goto L5;
        return;
    L5:
        if (r.getShortcutInfo() == null) goto L15;
        if (this.mPreferencesHelper.setValidMessageSent(r.getSbn().getPackageName(), r.getUid()) == false) goto L10;
        handleSavePolicyFile();
        return;
    L10:
        if (r.getNotification().getBubbleMetadata() != null) goto L12;
        return;
    L12:
        if (this.mPreferencesHelper.setValidBubbleSent(r.getSbn().getPackageName(), r.getUid()) == false) goto L21;
        handleSavePolicyFile();
        return;
    L21:
        return;
    L15:
        if (this.mPreferencesHelper.setInvalidMessageSent(r.getSbn().getPackageName(), r.getUid()) == false) goto L23;
        handleSavePolicyFile();
        return;
    }

    protected void reportUserInteraction(NotificationRecord r) {
        this.mAppUsageStats.reportEvent(r.getSbn().getPackageName(), getRealUserId(r.getSbn().getUserId()), 7);
        this.mAttentionHelper.onUserInteraction(r);
    }

    private int getRealUserId(int userId) {
        if (userId != (-1)) goto L6;
        return 0;
    L6:
        return userId;
    }

    private ToastRecord getToastRecord(int uid, int pid, String packageName, boolean isSystemToast, IBinder token, CharSequence text, ITransientNotification callback, int duration, Binder windowToken, int displayId, ITransientNotificationCallback textCallback, int type) {
        if (callback != null) goto L6;
        return new TextToastRecord(this, this.mStatusBar, uid, pid, packageName, isSystemToast, token, text, duration, windowToken, displayId, textCallback, type);
    L6:
        return new CustomToastRecord(this, uid, pid, packageName, isSystemToast, token, callback, duration, windowToken, displayId);
    }

    NotificationManagerInternal getInternalService() {
        return this.mInternalService;
    }

    private MultiRateLimiter createToastRateLimiter() {
        return new MultiRateLimiter.Builder(getContext()).addRateLimits(TOAST_RATE_LIMITS).build();
    }

    protected int checkComponentPermission(String permission, int uid, int owningUid, boolean exported) {
        return ActivityManager.checkComponentPermission(permission, uid, owningUid, exported);
    }

    private void handleNotificationPermissionChange(String pkg, int userId) {
        if (this.mUmInternal.isUserInitialized(userId) == true) goto L5;
        return;
    L5:
        int uid = this.mPackageManagerInternal.getPackageUid(pkg, 0, userId);
        if (uid != (-1)) goto L9;
        Log.e(TAG, String.format("No uid found for %s, %s!", new Object[]{pkg, Integer.valueOf(userId)}));
        return;
    L9:
        boolean hasPermission = this.mPermissionHelper.hasPermission(uid);
        if (hasPermission == true) goto L13;
        cancelAllNotificationsInt(MY_UID, MY_PID, pkg, null, 0, 0, userId, 7);
        return;
    }

    protected void checkNotificationListenerAccess() {
        if (isCallerSystemOrPhone() == true) goto L6;
        getContext().enforceCallingPermission("android.permission.MANAGE_NOTIFICATION_LISTENERS", "Caller must hold android.permission.MANAGE_NOTIFICATION_LISTENERS");
        return;
    }

    protected void setNotificationAssistantAccessGrantedForUserInternal(ComponentName assistant, int baseUserId, boolean granted, boolean userSet) {
        List<UserInfo> users = this.mUm.getEnabledProfiles(baseUserId);
        if (users == null) goto L21;
        Iterator<UserInfo> r1 = users.iterator();
    L6:
        if (r1.hasNext() == false) goto L30;
        UserInfo user = r1.next();
        int userId = user.id;
        if (assistant == null) goto L9;
        if (granted == true) goto L14;
    L17:
        this.mConditionProviders.setPackageOrComponentEnabled(assistant.flattenToString(), userId, false, granted);
        boolean granted2 = granted;
        boolean userSet2 = userSet;
        this.mAssistants.setPackageOrComponentEnabled(assistant.flattenToString(), userId, true, granted2, userSet2);
        NotificationAssistants.m6266$$Nest$msetNasUnsupportedDefaults(this.mAssistants, userId);
        getContext().sendBroadcastAsUser(new Intent("android.app.action.NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED").setPackage(assistant.getPackageName()).addFlags(1073741824), UserHandle.of(userId), null);
        handleSavePolicyFile();
    L18:
        granted = granted2;
        userSet = userSet2;
        goto L6
    L14:
        if (this.mAllowedManagedServicePackages.test(assistant.getPackageName(), Integer.valueOf(userId), this.mAssistants.getRequiredPermission()) == true) goto L17;
        granted2 = granted;
        userSet2 = userSet;
        goto L18
    L9:
        ComponentName allowedAssistant = (ComponentName) CollectionUtils.firstOrNull(this.mAssistants.getAllowedComponents(userId));
        if (allowedAssistant == null) goto L6;
        setNotificationAssistantAccessGrantedForUserInternal(allowedAssistant, userId, false, userSet);
        goto L6
    L30:
        return;
    }

    private void applyAdjustmentLocked(NotificationRecord r, Adjustment adjustment, boolean isPosted) {
        if (r != null) goto L5;
        return;
    L5:
        if (adjustment.getSignals() == null) goto L50;
        Bundle adjustments = adjustment.getSignals();
        Bundle.setDefusable(adjustments, true);
        if (adjustments.containsKey("key_type") == false) goto L9;
        r.setBundleType(adjustments.getInt("key_type"));
    L9:
        List<String> toRemove = new ArrayList();
        Iterator<String> r4 = adjustments.keySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L22;
        String potentialKey = r4.next();
        if (this.mAssistants.isAdjustmentAllowed(potentialKey) == true) goto L16;
        toRemove.add(potentialKey);
    L16:
        if (potentialKey.equals("key_type") == false) goto L11;
        this.mAssistants.setAdjustmentTypeSupportedState(r.getSbn().getNormalizedUserId(), potentialKey, true);
        if (this.mAssistants.isAdjustmentKeyTypeAllowed(adjustments.getInt("key_type")) == true) goto L11;
        toRemove.add(potentialKey);
        goto L11
    L22:
        Iterator<String> r1 = toRemove.iterator();
    L24:
        if (r1.hasNext() == false) goto L27;
        String removeKey = r1.next();
        adjustments.remove(removeKey);
        goto L24
    L27:
        if (adjustments.containsKey("key_type") == false) goto L38;
        NotificationChannel newChannel = getClassificationChannelLocked(r, adjustments);
        if (newChannel != null) goto L31;
    L37:
        adjustments.remove("key_type");
        goto L38
    L31:
        if (newChannel.getId().equals(r.getChannel().getId()) == true) goto L37;
        if (hasFlag(r.getNotification().flags, 262144) == false) goto L36;
        adjustments.remove("key_type");
        goto L38
    L36:
        int classification = adjustments.getInt("key_type");
        adjustments.putParcelable("key_type", newChannel);
        logClassificationChannelAdjustmentReceived(r, isPosted, classification);
    L38:
        r.addAdjustment(adjustment);
        if (adjustment.getSignals().containsKey("key_sensitive_content") == false) goto L51;
        logSensitiveAdjustmentReceived(isPosted, adjustment.getSignals().getBoolean("key_sensitive_content"), r.getLifespanMs(System.currentTimeMillis()));
        return;
    L51:
        return;
    }

    private NotificationChannel getClassificationChannelLocked(NotificationRecord r, Bundle adjustments) {
        int type = adjustments.getInt("key_type");
        if (type >= 1) goto L5;
        return null;
    L5:
        if (type > 4) goto L13;
        NotificationChannel channel = this.mPreferencesHelper.getReservedChannel(r.getSbn().getPackageName(), r.getUid(), type);
        if (channel != null) goto L12;
        NotificationChannel channel2 = this.mPreferencesHelper.createReservedChannel(r.getSbn().getPackageName(), r.getUid(), type);
        handleSavePolicyFile();
        return channel2;
    L12:
        return channel;
    L13:
        return null;
    }

    void addAutogroupKeyLocked(String key, String groupName, boolean requestSort) {
        NotificationRecord r = this.mNotificationsByKey.get(key);
        if (r != null) goto L6;
        return;
    L6:
        if (r.getSbn().getOverrideGroupKey() == null) goto L8;
        return;
    L8:
        if (NUBIA_PUSH_CLIENT_PACKAGE.equals(r.getSbn().getOpPkg()) == false) goto L12;
        if (NUBIA_PUSH_CLIENT_GROUPKEY.equals(r.getSbn().getGroup()) == false) goto L12;
    L15:
        addAutoGroupAdjustment(r, groupName);
        EventLogTags.writeNotificationAutogrouped(key);
        if (requestSort == false) goto L19;
        this.mRankingHandler.requestSort();
    L19:
        if (r.getSbn().isAppGroup() == false) goto L23;
        this.mListeners.notifyPostedLocked(r, r);
        this.mNotificationRecordLogger.log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_FORCE_GROUP, r);
        return;
    L23:
        return;
    L12:
        if (r.getSbn().isAppGroup() == false) goto L14;
        r.setOverrideGroupKey(groupName);
    L14:
        r.getNotification().flags |= 131072;
        goto L15
    }

    void removeAutogroupKeyLocked(String key) {
        NotificationRecord r = this.mNotificationsByKey.get(key);
        if (r != null) goto L7;
        Slog.w(TAG, "Failed to remove autogroup " + key);
        return;
    L7:
        if (r.getSbn().getOverrideGroupKey() == null) goto L10;
        addAutoGroupAdjustment(r, null);
        EventLogTags.writeNotificationUnautogrouped(key);
        this.mRankingHandler.requestSort();
        return;
    }

    private void addAutoGroupAdjustment(NotificationRecord r, String overrideGroupKey) {
        Bundle signals = new Bundle();
        signals.putString("key_group_key", overrideGroupKey);
        Adjustment adjustment = new Adjustment(r.getSbn().getPackageName(), r.getKey(), signals, "", r.getSbn().getUserId());
        r.addAdjustment(adjustment);
    }

    void clearAutogroupSummaryLocked(int userId, String pkg, String groupKey) {
        ArrayMap<String, String> summaries = this.mAutobundledSummaries.get(Integer.valueOf(userId));
        if (summaries != null) goto L5;
        return;
    L5:
        if (summaries.containsKey(groupKey) == false) goto L11;
        NotificationRecord removed = findNotificationByKeyLocked(summaries.remove(groupKey));
        if (removed == null) goto L12;
        StatusBarNotification sbn = removed.getSbn();
        cancelNotification(MY_UID, MY_PID, pkg, sbn.getTag(), sbn.getId(), 0, 0, false, userId, 16, null);
        return;
    L12:
        return;
    }

    void removeAppSummaryLocked(String key) {
        NotificationRecord r = this.mNotificationsByKey.get(key);
        if (r != null) goto L6;
        return;
    L6:
        if (convertSummaryToNotificationLocked(key) == false) goto L9;
        r.isCanceled = true;
        cancelNotification(Binder.getCallingUid(), Binder.getCallingPid(), r.getSbn().getPackageName(), r.getSbn().getTag(), r.getSbn().getId(), 0, 0, false, r.getUserId(), 13, null);
        return;
    }

    NotificationRecord removeAppProvidedSummaryOnClassificationLocked(String triggeringKey, String oldGroupKey) {
        NotificationRecord r = this.mNotificationsByKey.get(triggeringKey);
        if (r == null) goto L36;
        if (oldGroupKey != null) goto L7;
        return null;
    L7:
        if (r.getSbn().isAppGroup() == true) goto L9;
        return null;
    L9:
        if (r.getNotification().isGroupChild() == false) goto L39;
        NotificationRecord groupSummary = this.mSummaryByGroupKey.get(oldGroupKey);
        if (groupSummary != null) goto L13;
        return null;
    L13:
        if (GroupHelper.isAggregatedGroup(groupSummary) == true) goto L41;
        List<NotificationRecord> notificationsInGroup = findGroupNotificationsLocked(r.getSbn().getPackageName(), oldGroupKey, r.getUserId());
        if (notificationsInGroup.size() > 1) goto L17;
    L24:
        boolean r3 = true;
    L25:
        boolean isOnlySummaryLeft = r3;
        if (isOnlySummaryLeft == false) goto L35;
        if (DBG == false) goto L31;
        Slog.i(TAG, "Removing app summary (all children bundled): " + groupSummary);
    L31:
        if (convertSummaryToNotificationLocked(groupSummary.getKey()) == false) goto L43;
        groupSummary.isCanceled = true;
        this.mSummaryByGroupKey.remove(oldGroupKey);
        cancelNotification(Binder.getCallingUid(), Binder.getCallingPid(), groupSummary.getSbn().getPackageName(), groupSummary.getSbn().getTag(), groupSummary.getSbn().getId(), 0, 0, false, groupSummary.getUserId(), 13, null);
        return groupSummary;
    L43:
        return null;
    L35:
        return null;
    L17:
        if (notificationsInGroup.size() == 2) goto L19;
    L23:
        r3 = false;
        goto L25
    L19:
        if (notificationsInGroup.contains(r) == false) goto L23;
        if (notificationsInGroup.contains(groupSummary) == false) goto L23;
    L41:
        return null;
    L39:
        return null;
    L36:
        return null;
    }

    private boolean hasAutoGroupSummaryLocked(NotificationRecord record) {
        String autbundledGroupKey = GroupHelper.getFullAggregateGroupKey(record);
        ArrayMap<String, String> summaries = this.mAutobundledSummaries.get(Integer.valueOf(record.getUserId()));
        if (summaries != null) goto L5;
    L7:
        return false;
    L5:
        if (summaries.containsKey(autbundledGroupKey) == false) goto L7;
        return true;
    }

    NotificationRecord createAutoGroupSummary(int userId, String pkg, String triggeringKey, String groupKey, int summaryId, GroupHelper.NotificationAttributes summaryAttr) {
        boolean isPermissionFixed = this.mPermissionHelper.isPermissionFixed(pkg, userId);
        Object r11 = this.mNotificationLock;
        monitor-enter(r11);
        NotificationRecord notificationRecord = this.mNotificationsByKey.get(triggeringKey);     // Catch: Throwable -> L57
        if (notificationRecord == null) goto L66;
        StatusBarNotification adjustedSbn = notificationRecord.getSbn();     // Catch: Throwable -> L57
        int userId2 = adjustedSbn.getUser().getIdentifier();     // Catch: Throwable -> L57
        int uid = adjustedSbn.getUid();     // Catch: Throwable -> L55
        ArrayMap<String, String> summaries = this.mAutobundledSummaries.get(Integer.valueOf(userId2));     // Catch: Throwable -> L55
        if (summaries == null) goto L72;
        ArrayMap<String, String> summaries2 = summaries;
    L20:
        this.mAutobundledSummaries.put(Integer.valueOf(userId2), summaries2);     // Catch: Throwable -> L55
        boolean hasSummary = summaries2.containsKey(groupKey);     // Catch: Throwable -> L55
        String channelId = summaryAttr.channelId;     // Catch: Throwable -> L55
        if (hasSummary == false) goto L68;
        Object r25 = r11;
        NotificationRecord summaryRecord = null;
    L41:
        if (summaryRecord == null) goto L53;
    L48:
        th = th;
    L59:
        monitor-exit(r25);     // Catch: Throwable -> L34
    L34:
        th = th;
        goto L59
    L60:
        throw th;
    L45:
        if (checkDisqualifyingFeatures(userId2, uid, summaryRecord.getSbn().getId(), summaryRecord.getSbn().getTag(), summaryRecord, true, false) == false) goto L53;
        monitor-exit(r25);     // Catch: Throwable -> L48
        return summaryRecord;
    L50:
        th = th;
    L53:
        monitor-exit(r25);     // Catch: Throwable -> L48
        return null;
    L68:
        ApplicationInfo appInfo = (ApplicationInfo) adjustedSbn.getNotification().extras.getParcelable("android.appInfo", ApplicationInfo.class);     // Catch: Throwable -> L38
        Bundle extras = new Bundle();     // Catch: Throwable -> L38
        extras.putParcelable("android.appInfo", appInfo);     // Catch: Throwable -> L38
        Notification summaryNotification = new Notification.Builder(getContext(), channelId).setSmallIcon(summaryAttr.icon).setGroupSummary(true).setGroupAlertBehavior(summaryAttr.groupAlertBehavior).setGroup(groupKey).setFlag(summaryAttr.flags, true).setColor(summaryAttr.iconColor).setVisibility(summaryAttr.visibility).build();     // Catch: Throwable -> L38
        summaryNotification.extras.putAll(extras);     // Catch: Throwable -> L38
        Intent appIntent = getContext().getPackageManager().getLaunchIntentForPackage(pkg);     // Catch: Throwable -> L38
        if (appIntent != null) goto L25;
        Notification summaryNotification2 = summaryNotification;
    L28:
        ArrayMap<String, String> summaries3 = summaries2;
        r25 = r11;
        StatusBarNotification summarySbn = new StatusBarNotification(adjustedSbn.getPackageName(), adjustedSbn.getOpPkg(), summaryId, groupKey, adjustedSbn.getUid(), adjustedSbn.getInitialPid(), summaryNotification2, adjustedSbn.getUser(), groupKey, System.currentTimeMillis());     // Catch: Throwable -> L34
        NotificationRecord summaryRecord2 = new NotificationRecord(getContext(), summarySbn, notificationRecord.getChannel());     // Catch: Throwable -> L34
        summaryRecord2.setImportanceFixed(isPermissionFixed);     // Catch: Throwable -> L34
        summaryRecord2.setIsAppImportanceLocked(notificationRecord.getIsAppImportanceLocked());     // Catch: Throwable -> L34
        summaries3.put(summarySbn.getGroupKey(), summarySbn.getKey());     // Catch: Throwable -> L34
        summaryRecord = summaryRecord2;
        goto L41
    L78:
        th = th;
    L36:
        th = th;
        r25 = r11;
        goto L59
    L25:
        summaryNotification2 = summaryNotification;
        summaryNotification2.contentIntent = this.mAmi.getPendingIntentActivityAsApp(0, appIntent, 67108864, null, pkg, appInfo.uid);     // Catch: Throwable -> L17
    L17:
        th = th;
        r25 = r11;
    L38:
        th = th;
        r25 = r11;
        goto L59
    L72:
        summaries2 = new ArrayMap();     // Catch: Throwable -> L17
    L55:
        th = th;
        r25 = r11;
        goto L59
    L66:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return null;
    L9:
        th = th;
        r25 = r11;
    L57:
        th = th;
        r25 = r11;
        goto L59
    }

    boolean convertSummaryToNotificationLocked(String key) {
        NotificationRecord r = this.mNotificationsByKey.get(key);
        if (r != null) goto L6;
        return false;
    L6:
        if (r.getSbn().isAppGroup() == true) goto L8;
    L16:
        return false;
    L8:
        if (r.getNotification().isGroupSummary() == false) goto L16;
        String oldGroupKey = r.getGroupKey();
        NotificationRecord groupSummary = this.mSummaryByGroupKey.get(oldGroupKey);
        if (groupSummary != null) goto L12;
    L14:
        StatusBarNotification sbn = r.getSbn();
        Notification r4 = sbn.getNotification();
        r4.flags = r.mOriginalFlags & (-513);
        EventLogTags.writeNotificationSummaryConverted(key);
        this.mNotificationRecordLogger.log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_FORCE_GROUP_SUMMARY, r);
        return true;
    L12:
        if (groupSummary.getKey().equals(r.getKey()) == false) goto L14;
        this.mSummaryByGroupKey.remove(oldGroupKey);
        goto L14
    }

    protected ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> getAllUsersNotificationPermissions() {
        ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> allPermissions = new ArrayMap();
        List<UserInfo> allUsers = this.mUm.getUsers();
        Iterator<UserInfo> r2 = allUsers.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        UserInfo ui = r2.next();
        ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> userPermissions = this.mPermissionHelper.getNotificationPermissionValues(ui.getUserHandle().getIdentifier());
        Iterator<Pair<Integer, String>> r5 = userPermissions.keySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L4;
        Pair<Integer, String> pair = r5.next();
        allPermissions.put(pair, userPermissions.get(pair));
        goto L7
    L10:
        return allPermissions;
    }

    private void dumpJson(PrintWriter pw, DumpFilter filter, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        JSONObject dump = new JSONObject();
        dump.put(HostingRecord.HOSTING_TYPE_SERVICE, "Notification Manager");     // Catch: JSONException -> L5
        dump.put("bans", this.mPreferencesHelper.dumpBansJson(filter, pkgPermissions));     // Catch: JSONException -> L5
        dump.put("ranking", this.mPreferencesHelper.dumpJson(filter, pkgPermissions));     // Catch: JSONException -> L5
        dump.put("stats", this.mUsageStats.dumpJson(filter));     // Catch: JSONException -> L5
        dump.put("channels", this.mPreferencesHelper.dumpChannelsJson(filter));     // Catch: JSONException -> L5
    L7:
        pw.println(dump);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void dumpRemoteViewStats(PrintWriter pw, DumpFilter filter) {
        PulledStats stats = this.mUsageStats.remoteViewStats(filter.since, true);
        if (stats != null) goto L6;
        pw.println("no remote view stats reported.");
        return;
    L6:
        stats.dump(1, pw, filter);
    }

    private void dumpProto(FileDescriptor fd, DumpFilter filter, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        Object r10 = this.mNotificationLock;
        monitor-enter(r10);
        int N = this.mNotificationList.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= N) goto L15;
        NotificationRecord nr = this.mNotificationList.get(i);     // Catch: Throwable -> L11
        if (filter.filtered == true) goto L9;
    L13:
        nr.dump(proto, 2246267895809L, filter.redact, 1);     // Catch: Throwable -> L11
    L14:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        if (filter.matches(nr.getSbn()) == true) goto L13;
    L15:
        int N2 = this.mEnqueuedNotifications.size();     // Catch: Throwable -> L11
        int i2 = 0;
    L16:
        if (i2 >= N2) goto L24;
        NotificationRecord nr2 = this.mEnqueuedNotifications.get(i2);     // Catch: Throwable -> L11
        if (filter.filtered == true) goto L20;
    L22:
        nr2.dump(proto, 2246267895809L, filter.redact, 0);     // Catch: Throwable -> L11
    L23:
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L16
    L20:
        if (filter.matches(nr2.getSbn()) == true) goto L22;
    L24:
        List<NotificationRecord> snoozed = this.mSnoozeHelper.getSnoozed();     // Catch: Throwable -> L11
        int N3 = snoozed.size();     // Catch: Throwable -> L11
        int i3 = 0;
    L25:
        if (i3 >= N3) goto L33;
        NotificationRecord nr3 = snoozed.get(i3);     // Catch: Throwable -> L11
        if (filter.filtered == true) goto L29;
    L31:
        nr3.dump(proto, 2246267895809L, filter.redact, 2);     // Catch: Throwable -> L11
    L32:
        i3 = i3 + 1;     // Catch: Throwable -> L11
        goto L25
    L29:
        if (filter.matches(nr3.getSbn()) == true) goto L31;
    L33:
        long zenLog = proto.start(1146756268034L);     // Catch: Throwable -> L11
        this.mZenModeHelper.dump(proto);     // Catch: Throwable -> L11
        Iterator<ComponentName> r4 = this.mEffectsSuppressors.iterator();     // Catch: Throwable -> L11
    L35:
        if (r4.hasNext() == false) goto L37;
        ComponentName suppressor = r4.next();     // Catch: Throwable -> L11
        suppressor.dumpDebug(proto, 2246267895812L);     // Catch: Throwable -> L11
        goto L35
    L37:
        proto.end(zenLog);     // Catch: Throwable -> L11
        long listenersToken = proto.start(1146756268035L);     // Catch: Throwable -> L11
        this.mListeners.dump(proto, filter);     // Catch: Throwable -> L11
        proto.end(listenersToken);     // Catch: Throwable -> L11
        proto.write(1120986464260L, this.mListenerHints);     // Catch: Throwable -> L11
        int i4 = 0;
    L39:
        if (i4 >= this.mListenersDisablingEffects.size()) goto L45;
        long effectsToken = proto.start(2246267895813L);     // Catch: Throwable -> L11
        long zenLog2 = zenLog;
        proto.write(1120986464257L, this.mListenersDisablingEffects.keyAt(i4));     // Catch: Throwable -> L11
        ArraySet<ComponentName> listeners = this.mListenersDisablingEffects.valueAt(i4);     // Catch: Throwable -> L11
        int j = 0;
    L42:
        if (j >= listeners.size()) goto L44;
        ComponentName componentName = listeners.valueAt(j);     // Catch: Throwable -> L11
        componentName.dumpDebug(proto, 2246267895811L);     // Catch: Throwable -> L11
        j = j + 1;     // Catch: Throwable -> L11
        i4 = i4;
        goto L42
    L44:
        proto.end(effectsToken);     // Catch: Throwable -> L11
        i4 = i4 + 1;     // Catch: Throwable -> L11
        zenLog = zenLog2;
        goto L39
    L45:
        long assistantsToken = proto.start(1146756268038L);     // Catch: Throwable -> L11
        this.mAssistants.dump(proto, filter);     // Catch: Throwable -> L11
        proto.end(assistantsToken);     // Catch: Throwable -> L11
        long conditionsToken = proto.start(1146756268039L);     // Catch: Throwable -> L11
        this.mConditionProviders.dump(proto, filter);     // Catch: Throwable -> L11
        proto.end(conditionsToken);     // Catch: Throwable -> L11
        long rankingToken = proto.start(1146756268040L);     // Catch: Throwable -> L11
        this.mRankingHelper.dump(proto, filter);     // Catch: Throwable -> L11
        this.mPreferencesHelper.dump(proto, filter, pkgPermissions);     // Catch: Throwable -> L51
        proto.end(rankingToken);     // Catch: Throwable -> L51
        monitor-exit(r10);     // Catch: Throwable -> L51
        proto.flush();
        return;
    L11:
        th = th;
    L52:
        monitor-exit(r10);     // Catch: Throwable -> L51
        throw th;
    L51:
        th = th;
        goto L52
    }

    private void dumpNotificationRecords(PrintWriter pw, DumpFilter filter) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        int N = this.mNotificationList.size();     // Catch: Throwable -> L13
        if (N <= 0) goto L18;
        pw.println("  Notification List:");     // Catch: Throwable -> L13
        int i = 0;
    L7:
        if (i >= N) goto L17;
        NotificationRecord nr = this.mNotificationList.get(i);     // Catch: Throwable -> L13
        if (filter.filtered == true) goto L11;
    L15:
        nr.dump(pw, "    ", getContext(), filter.redact);     // Catch: Throwable -> L13
    L16:
        i = i + 1;     // Catch: Throwable -> L13
        goto L7
    L11:
        if (filter.matches(nr.getSbn()) == true) goto L15;
    L17:
        pw.println("  ");     // Catch: Throwable -> L13
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void dumpImpl(PrintWriter pw, DumpFilter filter, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        pw.print("Current Notification Manager state");
        if (filter.filtered == false) goto L5;
        pw.print(" (filtered to ");
        pw.print(filter);
        pw.print(")");
    L5:
        pw.println(':');
        if (filter.filtered == true) goto L8;
    L10:
        boolean zenOnly = false;
    L11:
        if (zenOnly == true) goto L26;
        ArrayList<ToastRecord> r1 = this.mToastQueue;
        monitor-enter(r1);
        int N = this.mToastQueue.size();     // Catch: Throwable -> L19
        if (N <= 0) goto L22;
        pw.println("  Toast Queue:");     // Catch: Throwable -> L19
        int i = 0;
    L17:
        if (i >= N) goto L21;
        this.mToastQueue.get(i).dump(pw, "    ", filter);     // Catch: Throwable -> L19
        i = i + 1;     // Catch: Throwable -> L19
        goto L17
    L21:
        pw.println("  ");     // Catch: Throwable -> L19
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L26:
        Object r2 = this.mNotificationLock;
        monitor-enter(r2);
        if (zenOnly == false) goto L86;
    L52:
        if (zenOnly == true) goto L69;
        pw.println("\n  Ranking Config:");     // Catch: Throwable -> L32
        this.mRankingHelper.dump(pw, "    ", filter);     // Catch: Throwable -> L32
        pw.println("\n Notification Preferences:");     // Catch: Throwable -> L32
        this.mPreferencesHelper.dump(pw, "    ", filter, pkgPermissions);     // Catch: Throwable -> L32
        pw.println("\n  Notification listeners:");     // Catch: Throwable -> L32
        this.mListeners.dump(pw, filter);     // Catch: Throwable -> L32
        pw.print("    mListenerHints: ");     // Catch: Throwable -> L32
        pw.println(this.mListenerHints);     // Catch: Throwable -> L32
        pw.print("    mListenersDisablingEffects: (");     // Catch: Throwable -> L32
        int N2 = this.mListenersDisablingEffects.size();     // Catch: Throwable -> L32
        int i2 = 0;
    L54:
        if (i2 >= N2) goto L67;
        int hint = this.mListenersDisablingEffects.keyAt(i2);     // Catch: Throwable -> L32
        if (i2 <= 0) goto L58;
        pw.print(';');     // Catch: Throwable -> L32
    L58:
        pw.print("hint[" + hint + "]:");     // Catch: Throwable -> L32
        ArraySet<ComponentName> listeners = this.mListenersDisablingEffects.valueAt(i2);     // Catch: Throwable -> L32
        int listenerSize = listeners.size();     // Catch: Throwable -> L32
        int j = 0;
    L59:
        if (j >= listenerSize) goto L66;
        if (j <= 0) goto L62;
        pw.print(',');     // Catch: Throwable -> L32
    L62:
        ComponentName listener = listeners.valueAt(j);     // Catch: Throwable -> L32
        if (listener == null) goto L65;
        pw.print(listener);     // Catch: Throwable -> L32
    L65:
        j = j + 1;     // Catch: Throwable -> L32
        goto L59
    L66:
        i2 = i2 + 1;     // Catch: Throwable -> L32
        goto L54
    L67:
        pw.println(')');     // Catch: Throwable -> L32
        pw.println("\n  NotificationListenerStats:");     // Catch: Throwable -> L32
        this.mNotificationListenerStats.dump(pw, "    ");     // Catch: Throwable -> L32
        pw.println("\n  Notification assistant services:");     // Catch: Throwable -> L32
        this.mAssistants.dump(pw, filter);     // Catch: Throwable -> L32
    L69:
        if (filter.filtered == false) goto L71;
        if (zenOnly == true) goto L71;
    L72:
        pw.println("\n  Condition providers:");     // Catch: Throwable -> L32
        this.mConditionProviders.dump(pw, filter);     // Catch: Throwable -> L32
        pw.println("\n  Group summaries:");     // Catch: Throwable -> L32
        Iterator<Map.Entry<String, NotificationRecord>> r3 = this.mSummaryByGroupKey.entrySet().iterator();     // Catch: Throwable -> L32
    L74:
        if (r3.hasNext() == false) goto L79;
        Map.Entry<String, NotificationRecord> entry = r3.next();     // Catch: Throwable -> L32
        NotificationRecord r = entry.getValue();     // Catch: Throwable -> L32
        pw.println("    " + entry.getKey() + " -> " + r.getKey());     // Catch: Throwable -> L32
        if (this.mNotificationsByKey.get(r.getKey()) == r) goto L74;
        pw.println("!!!!!!LEAK: Record not found in mNotificationsByKey.");     // Catch: Throwable -> L32
        r.dump(pw, "      ", getContext(), filter.redact);     // Catch: Throwable -> L32
        goto L74
    L79:
        if (zenOnly == true) goto L81;
        pw.println("\n  Usage Stats:");     // Catch: Throwable -> L32
        this.mUsageStats.dump(pw, "    ", filter);     // Catch: Throwable -> L32
        pw.println("\n  TimeToLive alarms:");     // Catch: Throwable -> L32
        this.mTtlHelper.dump(pw, "    ");     // Catch: Throwable -> L32
    L81:
        pw.println("\n  GroupHelper:");     // Catch: Throwable -> L32
        this.mGroupHelper.dump(pw, "    ");     // Catch: Throwable -> L32
        monitor-exit(r2);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    L71:
        pw.println("\n  Zen Mode:");     // Catch: Throwable -> L32
        pw.print("    mInterruptionFilter=");     // Catch: Throwable -> L32
        pw.println(this.mInterruptionFilter);     // Catch: Throwable -> L32
        this.mZenModeHelper.dump(pw, "    ");     // Catch: Throwable -> L32
        pw.println("\n  Zen Log:");     // Catch: Throwable -> L32
        ZenLog.dump(pw, "    ");     // Catch: Throwable -> L32
        goto L72
    L86:
        if (filter.normalPriority == true) goto L35;
        dumpNotificationRecords(pw, filter);     // Catch: Throwable -> L32
    L35:
        if (filter.filtered == true) goto L37;
        pw.println("  mMaxPackageEnqueueRate=" + this.mMaxPackageEnqueueRate);     // Catch: Throwable -> L32
        pw.println("  hideSilentStatusBar=" + this.mPreferencesHelper.shouldHideSilentStatusIcons());     // Catch: Throwable -> L32
        this.mAttentionHelper.dumpLocked(pw, "    ", filter);     // Catch: Throwable -> L32
    L37:
        pw.println("  mArchive=" + this.mArchive.toString());     // Catch: Throwable -> L32
        this.mArchive.dumpImpl(pw, filter);     // Catch: Throwable -> L32
        if (zenOnly == true) goto L52;
        int N3 = this.mEnqueuedNotifications.size();     // Catch: Throwable -> L32
        if (N3 <= 0) goto L51;
        pw.println("  Enqueued Notification List:");     // Catch: Throwable -> L32
        int i3 = 0;
    L42:
        if (i3 >= N3) goto L50;
        NotificationRecord nr = this.mEnqueuedNotifications.get(i3);     // Catch: Throwable -> L32
        if (filter.filtered == true) goto L46;
    L48:
        nr.dump(pw, "    ", getContext(), filter.redact);     // Catch: Throwable -> L32
    L49:
        i3 = i3 + 1;     // Catch: Throwable -> L32
        goto L42
    L46:
        if (filter.matches(nr.getSbn()) == true) goto L48;
    L50:
        pw.println("  ");     // Catch: Throwable -> L32
    L51:
        this.mSnoozeHelper.dump(pw, filter);     // Catch: Throwable -> L32
        goto L52
    L8:
        if (filter.zen == false) goto L10;
        zenOnly = true;
        goto L11
    }

    private static boolean isBigPictureWithBitmapOrIcon(Notification n) {
        boolean isBigPicture = n.isStyle(Notification.BigPictureStyle.class);
        if (isBigPicture == true) goto L6;
        return false;
    L6:
        if (n.extras.containsKey("android.picture") == true) goto L8;
    L10:
        boolean hasBitmap = false;
    L12:
        if (hasBitmap == false) goto L15;
        return true;
    L15:
        if (n.extras.containsKey("android.pictureIcon") == true) goto L17;
    L19:
        boolean hasIcon = false;
    L21:
        if (hasIcon == false) goto L23;
        return true;
    L23:
        return false;
    L17:
        if (n.extras.getParcelable("android.pictureIcon") == null) goto L19;
        hasIcon = true;
        goto L21
    L8:
        if (n.extras.getParcelable("android.picture") == null) goto L10;
        hasBitmap = true;
        goto L12
    }

    private static boolean isBitmapExpired(long timePostedMs, long timeNowMs, long timeToLiveMs) {
        long timeDiff = timeNowMs - timePostedMs;
        if (timeDiff <= timeToLiveMs) goto L5;
        return true;
    L5:
        return false;
    }

    private void removeBitmapAndRepost(NotificationRecord r) {
        if (isBigPictureWithBitmapOrIcon(r.getNotification()) == true) goto L5;
        return;
    L5:
        r.getNotification().extras.putParcelable("android.picture", null);
        r.getNotification().extras.putParcelable("android.pictureIcon", null);
        r.getNotification().flags |= 8;
        enqueueNotificationInternal(r.getSbn().getPackageName(), r.getSbn().getPackageName(), r.getSbn().getUid(), MY_PID, r.getSbn().getTag(), r.getSbn().getId(), r.getNotification(), r.getSbn().getUserId(), true, false, false);
    }

    int getNumNotificationChannelsForPackage(String pkg, int uid, boolean includeDeleted) {
        return this.mPreferencesHelper.getNotificationChannels(pkg, uid, includeDeleted, false).getList().size();
    }

    void cancelNotificationInternal(String pkg, String opPkg, int callingUid, int callingPid, String tag, int id, int userId, int mustNotHaveFlags) {
        int userId2 = ActivityManager.handleIncomingUser(callingPid, callingUid, userId, true, false, "cancelNotificationWithTag", pkg);
        int uid = resolveNotificationUid(opPkg, pkg, callingUid, userId2);     // Catch: PackageManager.NameNotFoundException -> L5
        int uid2 = uid;
    L8:
        if (uid2 != (-1)) goto L12;
        Slog.w(TAG, opPkg + ":" + callingUid + " trying to cancel notification for nonexistent pkg " + pkg + " in user " + userId2);
        return;
    L12:
        if (Objects.equals(pkg, opPkg) == true) goto L28;
        Object r1 = this.mNotificationLock;
        monitor-enter(r1);
        NotificationRecord r = findNotificationLocked(pkg, tag, id, userId2);     // Catch: Throwable -> L22
        if (r != null) goto L18;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L22
        goto L28
    L18:
        if (Objects.equals(opPkg, r.getSbn().getOpPkg()) == true) goto L24;
        throw new SecurityException(opPkg + " does not have permission to cancel a notification they did not post " + tag + " " + id);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L28:
        cancelNotification(uid2, callingPid, pkg, tag, id, 0, mustNotHaveFlags, false, userId2, 8, null);
        return;
    L6:
        uid2 = -1;
        goto L8
    }

    boolean isNotificationShownInternal(String pkg, String tag, int notificationId, int userId) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (findNotificationLocked(pkg, tag, notificationId, userId) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void enqueueNotificationInternal(String pkg, String opPkg, int callingUid, int callingPid, String tag, int id, Notification notification, int incomingUserId, boolean byForegroundService, boolean isAppProvided) {
        enqueueNotificationInternal(pkg, opPkg, callingUid, callingPid, tag, id, notification, incomingUserId, false, byForegroundService, isAppProvided);
    }

    void enqueueNotificationInternal(String pkg, String opPkg, int callingUid, int callingPid, String tag, int id, Notification notification, int incomingUserId, boolean postSilently, boolean byForegroundService, boolean isAppProvided) {
        PostNotificationTracker tracker = acquireWakeLockForPost(pkg, callingUid);
        boolean enqueued = enqueueNotificationInternal(pkg, opPkg, callingUid, callingPid, tag, id, notification, incomingUserId, postSilently, tracker, byForegroundService, isAppProvided);     // Catch: Throwable -> L7
        if (enqueued == true) goto L13;
        tracker.cancel();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (0 != 0) goto L10;
        tracker.cancel();
    L10:
        throw th;
    }

    private PostNotificationTracker acquireWakeLockForPost(final String pkg, final int uid) {
        return (PostNotificationTracker) Binder.withCleanCallingIdentity(new NotificationManagerService$$ExternalSyntheticLambda20(this, pkg, uid));
    }

    private /* synthetic */ PostNotificationTracker lambda$acquireWakeLockForPost$12(String pkg, int uid) throws Exception {
        PowerManager.WakeLock wakeLock = this.mPowerManager.newWakeLock(1, "NotificationManagerService:post:" + pkg);
        wakeLock.setWorkSource(new WorkSource(uid, pkg));
        wakeLock.acquire(POST_WAKE_LOCK_TIMEOUT.toMillis());
        return this.mPostNotificationTrackerFactory.newTracker(wakeLock);
    }

    private boolean enqueueNotificationInternal(String pkg, String opPkg, int callingUid, int callingPid, String tag, int id, Notification notification, int incomingUserId, boolean postSilently, PostNotificationTracker tracker, boolean byForegroundService, boolean isAppProvided) {
        String pkg2 = pkg;
        if (DBG == false) goto L6;
        Slog.v(TAG, "enqueueNotificationInternal: pkg=" + pkg2 + " id=" + id + " notification=" + notification);
    L6:
        if (Utils.isXtsPkg(pkg2) == true) goto L26;
        if (NUBIA_PUSH_CLIENT_PACKAGE.equals(pkg2) == true) goto L26;
        if (notification.isGroupSummary() == false) goto L20;
        if (notification.hasTitle() == true) goto L20;
        if (notification.extras != null) goto L16;
    L17:
        Slog.w(TAG, "A group summary is not allowed");
        return false;
    L16:
        if (notification.extras.getCharSequence("android.text") == null) goto L17;
    L20:
        if (Notification.isCompatSilentSceneWhitelistPkg(pkg2) == true) goto L22;
    L24:
        notification.clearGroupInfomation();
        goto L26
    L22:
        if (notification.isSilent() == false) goto L24;
        notification.flags |= 131072;
    L26:
        if (NOTIFICATION_IGNORE_LIST.contains(pkg2) == false) goto L29;
        Slog.i(TAG, "Cannot enqueue notification");
        return false;
    L29:
        if (pkg2 == null) goto L225;
        if (notification == null) goto L225;
        int userId = ActivityManager.handleIncomingUser(callingPid, callingUid, incomingUserId, true, false, "enqueueNotification", pkg2);
        UserHandle user = UserHandle.of(userId);
        boolean isPushNotification = NUBIA_PUSH_CLIENT_PACKAGE.equals(pkg2);
        if (notification.extras == null) goto L42;
        String fakedPkg = notification.extras.getString("target_pkg");
        this.isReplaceTargetPkg = Boolean.valueOf(notification.extras.getBoolean("replace_targetPkg", true));
        if (isPushNotification == false) goto L39;
        if (fakedPkg == null) goto L39;
        if (this.isReplaceTargetPkg.booleanValue() == false) goto L39;
        Slog.d(TAG, "push notification, replace " + pkg2 + " with " + fakedPkg);
        pkg2 = fakedPkg;
    L39:
        if (fakedPkg == null) goto L41;
        Slog.d(TAG, "use small icon for pkg: " + pkg2 + ", fakePkg: " + fakedPkg + ", isReplaceTargetPkg: " + this.isReplaceTargetPkg + ", isPushNotification: " + isPushNotification);
        notification.extras.putBoolean("status_bar_use_app_icon", false);
        notification.extras.putBoolean("small_icon_use_app_icon", false);
    L41:
        String fakedPkg2 = fakedPkg;
        String oriPushPkg = pkg;
        String fakedPkg3 = pkg2;
    L226:
        int notificationUid = resolveNotificationUid(opPkg, fakedPkg3, callingUid, userId);     // Catch: PackageManager.NameNotFoundException -> L46
        int notificationUid2 = notificationUid;
    L49:
        if (notificationUid2 == (-1)) goto L223;
        IBinder allowlistToken = notification.getAllowlistToken();
        if (allowlistToken != null) goto L53;
    L57:
        notification.overrideAllowlistToken(ALLOWLIST_TOKEN);
        checkRestrictedCategories(notification);
        String pkg3 = fakedPkg3;
        ActivityManagerInternal.ServiceNotificationPolicy policy = this.mAmi.applyForegroundServiceNotification(notification, tag, id, pkg3, userId);
        JobSchedulerInternal js = (JobSchedulerInternal) LocalServices.getService(JobSchedulerInternal.class);
        if (js == null) goto L60;
        boolean stripUijFlag = !js.isNotificationAssociatedWithAnyUserInitiatedJobs(id, userId, pkg3);
    L61:
        boolean stripUijFlag2 = stripUijFlag;
        int notificationUid3 = notificationUid2;
        fixNotification(notification, pkg3, tag, id, userId, notificationUid3, policy, stripUijFlag2);     // Catch: Exception -> L215
        if (policy == ActivityManagerInternal.ServiceNotificationPolicy.UPDATE_ONLY) goto L66;
    L69:
        this.mUsageStats.registerEnqueuedByApp(pkg3);
        String fakedPkg4 = fakedPkg2;
        StatusBarNotification n = new StatusBarNotification(pkg3, opPkg, id, tag, notificationUid3, callingPid, notification, user, null, System.currentTimeMillis());
        String channelId = notification.getChannelId();
        if (this.mIsTelevision == true) goto L72;
    L74:
        String channelId2 = channelId;
    L75:
        String shortcutId = n.getShortcutId();
        String pkg4 = pkg3;
        NotificationChannel channel = getNotificationChannelRestoreDeleted(pkg4, callingUid, notificationUid3, channelId2, shortcutId);
        if (isPushNotification == false) goto L96;
        if (fakedPkg4 == null) goto L96;
        if (this.isReplaceTargetPkg.booleanValue() == false) goto L96;
        ParceledListSlice<NotificationChannel> channels = this.mPreferencesHelper.getNotificationChannels(pkg4, notificationUid3, true, true);
        if (channels != null) goto L83;
    L95:
        String channelId3 = channelId2;
        int notificationUid4 = notificationUid3;
        String pkg5 = pkg4;
        NotificationChannel channel2 = this.mPreferencesHelper.getConversationNotificationChannel(oriPushPkg, callingUid, channelId3, shortcutId, true, false);
        String channelId4 = channelId3;
        int notificationUid5 = callingUid;
        Slog.d(TAG, "target pkg has no channel, still use push channel " + channel2);
        NotificationChannel channel3 = channel2;
    L97:
        if (channel3 != null) goto L104;
        String noChannelStr = "No Channel found for pkg=" + pkg5 + ", channelId=" + channelId4 + ", id=" + id + ", tag=" + tag + ", opPkg=" + opPkg + ", callingUid=" + notificationUid5 + ", userId=" + userId + ", incomingUserId=" + incomingUserId + ", notificationUid=" + notificationUid4 + ", notification=" + notification;
        Slog.e(TAG, noChannelStr);
        boolean appNotificationsOff = !this.mPermissionHelper.hasPermission(notificationUid4);
        if (appNotificationsOff == true) goto L241;
        doChannelWarningToast(notificationUid4, "Developer warning for package \"" + pkg5 + "\"\nFailed to post notification on channel \"" + channelId4 + "\"\nSee log for more details");
        return false;
    L241:
        return false;
    L104:
        if (notification.extras == null) goto L135;
        String msgId = notification.extras.getString("ups_msgId");
        if (fakedPkg4 != null) goto L110;
        if (msgId != null) goto L110;
        String fakedPkg5 = fakedPkg4;
    L136:
        GameKeysPatch gameKeysPatch = GameKeysPatch.getInstance();
        if (gameKeysPatch == null) goto L143;
        if (gameKeysPatch.interceptEnqueueNotificationInternal(getContext(), pkg5, id, notification) == false) goto L143;
        return false;
    L143:
        if (this.mPreferencesHelper.canBePromoted(pkg5, notificationUid4) == true) goto L145;
    L149:
        NotificationRecord r = new NotificationRecord(getContext(), n, channel3);
        r.setIsAppImportanceLocked(this.mPermissionHelper.isPermissionUserSet(pkg5, userId));
        r.setPostSilently(postSilently);
        r.setFlagBubbleRemoved(false);
        r.setPkgAllowedAsConvo(this.mMsgPkgsAllowedAsConvos.contains(pkg5));
        boolean isImportanceFixed = this.mPermissionHelper.isPermissionFixed(pkg5, userId);
        r.setImportanceFixed(isImportanceFixed);
        if (notification.isFgsOrUij() == true) goto L152;
        String channelId5 = pkg5;
        int notificationUid6 = notificationUid4;
        NotificationRecord r2 = r;
    L177:
        if (this.mShortcutHelper == null) goto L179;
        UserHandle user2 = user;
        ShortcutInfo info = this.mShortcutHelper.getValidShortcutInfo(notification.getShortcutId(), channelId5, user2);
    L181:
        if (notification.getShortcutId() == null) goto L184;
        if (info != null) goto L184;
        Slog.w(TAG, "notification " + r2.getKey() + " added an invalid shortcut");
    L184:
        r2.setShortcutInfo(info);
        r2.setHasSentValidMsg(this.mPreferencesHelper.hasSentValidMsg(channelId5, notificationUid6));
        r2.userDemotedAppFromConvoSpace(this.mPreferencesHelper.hasUserDemotedInvalidMsgApp(channelId5, notificationUid6));
        if (r2.getSbn().getOverrideGroupKey() == null) goto L187;
        boolean r7 = true;
    L188:
        NotificationRecord r3 = r2;
        String pkg6 = channelId5;
        UserHandle user3 = user2;
        if (checkDisqualifyingFeatures(userId, notificationUid6, id, tag, r3, r7, byForegroundService) == true) goto L192;
        return false;
    L192:
        this.mUsageStats.registerEnqueuedByAppAndAccepted(pkg6);
        if (info == null) goto L196;
        this.mShortcutHelper.cacheShortcut(info, user3);
    L196:
        if (notification.allPendingIntents == null) goto L208;
        int intentCount = notification.allPendingIntents.size();
        if (intentCount <= 0) goto L207;
        long duration = ((DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class)).getNotificationAllowlistDuration();
        int i = 0;
    L200:
        if (i >= intentCount) goto L206;
        PendingIntent pendingIntent = (PendingIntent) notification.allPendingIntents.valueAt(i);
        if (pendingIntent == null) goto L205;
        this.mAmi.setPendingIntentAllowlistDuration(pendingIntent.getTarget(), ALLOWLIST_TOKEN, duration, 0, 310, "NotificationManagerService");
        this.mAmi.setPendingIntentAllowBgActivityStarts(pendingIntent.getTarget(), ALLOWLIST_TOKEN, 7);
    L205:
        i = i + 1;
        info = info;
        intentCount = intentCount;
        goto L200
    L206:
        ShortcutInfo info2 = info;
    L209:
        int packageImportance = getPackageImportanceWithIdentity(pkg6);
        if (packageImportance != 100) goto L212;
        boolean isAppForeground = true;
    L213:
        this.mHandler.post(new EnqueueNotificationRunnable(this, userId, r3, isAppForeground, isAppProvided, tracker));
        return true;
    L212:
        isAppForeground = false;
        goto L213
    L207:
        info2 = info;
        goto L209
    L208:
        info2 = info;
        goto L209
    L187:
        r7 = false;
        goto L188
    L179:
        user2 = r8;
        info = null;
        goto L181
    L152:
        if ((channel3.getUserLockedFields() & 4) == 0) goto L158;
        if (channel3.isUserVisibleTaskShown() == false) goto L158;
    L163:
        if (channel3.isUserVisibleTaskShown() == false) goto L165;
    L170:
        channelId5 = pkg5;
        notificationUid6 = notificationUid4;
        r2 = r;
        goto L177
    L165:
        if (TextUtils.isEmpty(channelId4) == true) goto L170;
        if ("miscellaneous".equals(channelId4) == true) goto L169;
        channel3.setUserVisibleTaskShown(true);
        r.updateNotificationChannel(channel3);
        channelId5 = pkg5;
        notificationUid6 = notificationUid4;
        r2 = r;
        goto L177
    L169:
        channelId5 = pkg5;
        notificationUid6 = notificationUid4;
        r2 = r;
    L158:
        if (r.getImportance() != 1) goto L160;
    L171:
        channel3.setImportance(2);
        r.setSystemImportance(2);
        if (channel3.isUserVisibleTaskShown() == true) goto L174;
        channel3.unlockFields(4);
        channel3.setUserVisibleTaskShown(true);
    L174:
        PreferencesHelper r0 = this.mPreferencesHelper;
        boolean r6 = isCallerSystemOrSystemUi();
        channelId5 = pkg5;
        NotificationChannel channel4 = channel3;
        r2 = r;
        int notificationUid7 = notificationUid4;
        r0.updateNotificationChannel(channelId5, notificationUid7, channel4, false, callingUid, r6);
        notificationUid6 = notificationUid7;
        channel3 = channel4;
        r2.updateNotificationChannel(channel3);
        goto L177
    L160:
        if (r.getImportance() != 0) goto L163;
    L145:
        if (notification.hasPromotableCharacteristics() == false) goto L149;
        if (channel3.getImportance() <= 1) goto L149;
        notification.flags |= 262144;
    L110:
        if (isPushNotification == true) goto L232;
        Slog.d(TAG, "enqueueNotificationInternal: pkg " + pkg5 + " want to fake push client, is stopped");
        return false;
    L232:
        fakedPkg5 = fakedPkg4;
        this.mPackageManagerClient.getPackageInfo(fakedPkg5, 0);     // Catch: PackageManager.NameNotFoundException -> L127
        int targetUid = -1;
        targetUid = this.mPackageManagerClient.getPackageUidAsUser(fakedPkg5, incomingUserId);     // Catch: PackageManager.NameNotFoundException -> L118
    L119:
        Slog.d(TAG, "enqueueNotificationInternal: pkg=" + pkg5 + " opPkg=" + opPkg + " fakedPkg= " + fakedPkg5 + " id=" + id + " callingUid=" + notificationUid5 + " targetUid=" + targetUid + " notification=" + notification + " importance=" + channel3.getImportance());
        if ((-1) == targetUid) goto L136;
        if (msgId == null) goto L136;
        if (channel3.getImportance() != 0) goto L136;
        Slog.d(TAG, "notification close, remove push client notification for target pkg " + fakedPkg5);
        sendBroadcastForPushClient(msgId, 2);
        return false;
    L127:
        e = e;
    L131:
        Slog.d(TAG, "package not installed , remove push client notification for target pkg " + fakedPkg5);
        sendBroadcastForPushClient(msgId, 1);
        return false;
    L129:
        e = e;
        fakedPkg5 = fakedPkg4;
        goto L131
    L135:
        fakedPkg5 = fakedPkg4;
        goto L136
    L83:
        if (channels.getList().isEmpty() == true) goto L95;
        boolean hasHighChannel = false;
        int i2 = 0;
    L86:
        if (i2 >= channels.getList().size()) goto L91;
        NotificationChannel channelItem = (NotificationChannel) channels.getList().get(i2);
        boolean hasHighChannel2 = hasHighChannel;
        String pkg7 = pkg4;
        if (channelItem.getImportance() == 4) goto L89;
        i2 = i2 + 1;
        hasHighChannel = hasHighChannel2;
        pkg4 = pkg7;
        goto L86
    L89:
        channel = channelItem;
        hasHighChannel = true;
    L92:
        if (hasHighChannel == true) goto L94;
        channel = (NotificationChannel) channels.getList().get(0);
    L94:
        channelId4 = channelId2;
        channel3 = channel;
        notificationUid4 = notificationUid3;
        pkg5 = pkg7;
        notificationUid5 = callingUid;
        goto L97
    L91:
        pkg7 = pkg4;
    L96:
        notificationUid4 = notificationUid3;
        channelId4 = channelId2;
        notificationUid5 = callingUid;
        pkg5 = pkg4;
        channel3 = channel;
        goto L97
    L72:
        if (new Notification.TvExtender(notification).getChannelId() == null) goto L74;
        String channelId6 = new Notification.TvExtender(notification).getChannelId();
        channelId2 = channelId6;
        goto L75
    L66:
        if (isNotificationShownInternal(pkg3, tag, id, userId) == true) goto L69;
        reportForegroundServiceUpdate(false, notification, id, pkg3, userId);
        return false;
    L215:
        e = move-exception;
        if (notification.isForegroundService() == true) goto L221;
        Slog.e(TAG, "Cannot fix notification", e);
        return false;
    L221:
        throw new SecurityException("Invalid FGS notification", e);
    L60:
        stripUijFlag = true;
        goto L61
    L53:
        if (allowlistToken == ALLOWLIST_TOKEN) goto L57;
        throw new SecurityException("Unexpected allowlist token received from " + callingUid);
    L223:
        throw new SecurityException("Caller " + opPkg + ":" + callingUid + " trying to post for invalid pkg " + fakedPkg3 + " in user " + incomingUserId);
    L47:
        notificationUid2 = -1;
        goto L49
    L42:
        fakedPkg2 = null;
        oriPushPkg = null;
        fakedPkg3 = pkg2;
    L225:
        throw new IllegalArgumentException("null not allowed: pkg=" + pkg2 + " id=" + id + " notification=" + notification);
    }

    private NotificationChannel getNotificationChannelRestoreDeleted(String pkg, int callingUid, int notificationUid, String channelId, String conversationId) {
        if (NotificationChannel.SYSTEM_RESERVED_IDS.contains(channelId) == false) goto L6;
        return null;
    L6:
        NotificationChannel channel = this.mPreferencesHelper.getConversationNotificationChannel(pkg, notificationUid, channelId, conversationId, true, !TextUtils.isEmpty(conversationId));
        if (channel == null) goto L18;
        if (channel.isDeleted() == false) goto L18;
        if (Objects.equals(conversationId, channel.getConversationId()) == false) goto L16;
        boolean needsPolicyFileChange = this.mPreferencesHelper.createNotificationChannel(pkg, notificationUid, channel, true, this.mConditionProviders.isPackageOrComponentAllowed(pkg, UserHandle.getUserId(notificationUid)), callingUid, true);
        if (needsPolicyFileChange == false) goto L21;
        handleSavePolicyFile();
        return channel;
    L21:
        return channel;
    L16:
        return null;
    L18:
        return channel;
    }

    private void onConversationRemovedInternal(String pkg, int uid, Set<String> shortcuts) {
        checkCallerIsSystem();
        Preconditions.checkStringNotEmpty(pkg);
        this.mHistoryManager.deleteConversations(pkg, uid, shortcuts);
        String pkg2 = pkg;
        List<String> deletedChannelIds = this.mPreferencesHelper.deleteConversations(pkg2, uid, shortcuts, 1000, true);
        Iterator<String> r9 = deletedChannelIds.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        String channelId = r9.next();
        String pkg3 = pkg2;
        cancelAllNotificationsInt(MY_UID, MY_PID, pkg3, channelId, 0, 0, UserHandle.getUserId(uid), 20);
        pkg2 = pkg3;
        goto L4
    L6:
        handleSavePolicyFile();
    }

    private void makeStickyHun(Notification notification, String pkg, int userId) {
        if (this.mPermissionHelper.hasRequestedPermission("android.permission.USE_FULL_SCREEN_INTENT", pkg, userId) == false) goto L6;
        notification.flags |= 16384;
    L6:
        if (notification.contentIntent != null) goto L8;
        notification.contentIntent = notification.fullScreenIntent;
    L8:
        notification.fullScreenIntent = null;
    }

    protected void fixNotification(Notification notification, String pkg, String tag, int id, int userId, int notificationUid, ActivityManagerInternal.ServiceNotificationPolicy fgsPolicy, boolean stripUijFlag) throws PackageManager.NameNotFoundException, RemoteException {
        PackageManager r5 = this.mPackageManagerClient;
        if (userId != (-1)) goto L5;
        int r8 = 0;
    L6:
        ApplicationInfo ai = r5.getApplicationInfoAsUser(pkg, 268435456, r8);
        Notification.addFieldsFromContext(ai, notification);
        notification.extras.remove("android.summarization");
        if (notification.isForegroundService() == false) goto L13;
        if (fgsPolicy != ActivityManagerInternal.ServiceNotificationPolicy.NOT_FOREGROUND_SERVICE) goto L13;
        notification.flags &= -65;
    L13:
        if (notification.isUserInitiatedJob() == false) goto L17;
        if (stripUijFlag == false) goto L17;
        notification.flags &= -32769;
    L17:
        if (notification.isFgsOrUij() == false) goto L20;
        notification.flags &= -17;
    L20:
        if ((notification.flags & 2) > 0) goto L22;
    L24:
        notification.flags &= -8193;
    L25:
        int canColorize = getContext().checkPermission("android.permission.USE_COLORIZED_NOTIFICATIONS", -1, notificationUid);
        if (canColorize != 0) goto L28;
        notification.flags |= 2048;
    L30:
        if (notification.extras.getBoolean("android.allowDuringSetup", false) == false) goto L36;
        int hasShowDuringSetupPerm = getContext().checkPermission("android.permission.NOTIFICATION_DURING_SETUP", -1, notificationUid);
        if (hasShowDuringSetupPerm == 0) goto L36;
        notification.extras.remove("android.allowDuringSetup");
        if (DBG == false) goto L36;
        Slog.w(TAG, "warning: pkg " + pkg + " attempting to show during setup without holding perm android.permission.NOTIFICATION_DURING_SETUP");
    L36:
        int hasShowDuringSetupPerm2 = notification.flags;
        notification.flags = hasShowDuringSetupPerm2 & (-16385);
        notification.flags &= -65537;
        if (notification.fullScreenIntent == null) goto L42;
        AttributionSource attributionSource = new AttributionSource.Builder(notificationUid).setPackageName(pkg).build();
        boolean canUseFullScreenIntent = checkUseFullScreenIntentPermission(attributionSource, ai, true);
        if (canUseFullScreenIntent == true) goto L42;
        makeStickyHun(notification, pkg, userId);
    L42:
        if (notification.actions == null) goto L60;
        boolean hasNullActions = false;
        int nActions = notification.actions.length;
        int i = 0;
    L44:
        if (i >= nActions) goto L49;
        if (notification.actions[i] == null) goto L47;
        i = i + 1;
        goto L44
    L47:
        hasNullActions = true;
    L49:
        if (hasNullActions == false) goto L60;
        ArrayList<Notification.Action> nonNullActions = new ArrayList();
        int i2 = 0;
    L51:
        if (i2 >= nActions) goto L57;
        if (notification.actions[i2] == null) goto L55;
        nonNullActions.add(notification.actions[i2]);
    L55:
        i2 = i2 + 1;
        goto L51
    L57:
        if (nonNullActions.size() == 0) goto L59;
        notification.actions = (Notification.Action[]) nonNullActions.toArray(new Notification.Action[0]);
        goto L60
    L59:
        notification.actions = null;
    L60:
        notification.flags &= -262145;
        if (notification.isStyle(Notification.CallStyle.class) == false) goto L64;
        Notification.Builder builder = Notification.Builder.recoverBuilder(getContext(), notification);
        Notification.CallStyle style = (Notification.CallStyle) builder.getStyle();
        List<Notification.Action> actions = style.getActionsListWithSystemActions();
        notification.actions = new Notification.Action[actions.size()];
        actions.toArray(notification.actions);
    L64:
        if (notification.isStyle(Notification.MediaStyle.class) == false) goto L66;
    L67:
        int hasMediaContentControlPermission = getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", -1, notificationUid);
        if (hasMediaContentControlPermission == 0) goto L73;
        notification.extras.remove("android.mediaRemoteDevice");
        notification.extras.remove("android.mediaRemoteIcon");
        notification.extras.remove("android.mediaRemoteIntent");
        if (DBG == false) goto L73;
        Slog.w(TAG, "Package " + pkg + ": Use of setRemotePlayback requires the MEDIA_CONTENT_CONTROL permission");
    L73:
        if (CompatChanges.isChangeEnabled(ENFORCE_NO_CLEAR_FLAG_ON_MEDIA_NOTIFICATION, notificationUid) == false) goto L76;
        notification.flags |= 32;
    L76:
        if (notification.extras.containsKey("android.substName") == false) goto L82;
        int hasSubstituteAppNamePermission = getContext().checkPermission("android.permission.SUBSTITUTE_NOTIFICATION_APP_NAME", -1, notificationUid);
        if (hasSubstituteAppNamePermission == 0) goto L82;
        notification.extras.remove("android.substName");
        if (DBG == false) goto L82;
        Slog.w(TAG, "warning: pkg " + pkg + " attempting to substitute app name without holding perm android.permission.SUBSTITUTE_NOTIFICATION_APP_NAME");
    L82:
        checkRemoteViews(pkg, tag, id, notification);
        if (notification.getTimeoutAfter() != 0) goto L85;
        notification.setTimeoutAfter(NOTIFICATION_TTL);
    L85:
        notification.fixSilentGroup();
        return;
    L66:
        if (notification.isStyle(Notification.DecoratedMediaCustomViewStyle.class) == false) goto L76;
    L28:
        notification.flags &= -2049;
        goto L30
    L22:
        if (canBeNonDismissible(ai, notification) == false) goto L24;
        notification.flags |= 8192;
        goto L25
    L5:
        r8 = userId;
        goto L6
    }

    private boolean canBeNonDismissible(ApplicationInfo ai, Notification notification) {
        if (notification.isMediaNotification() == false) goto L5;
    L14:
        return true;
    L5:
        if (isEnterpriseExempted(ai) == true) goto L14;
        if (notification.isStyle(Notification.CallStyle.class) == true) goto L14;
        if (isDefaultSearchSelectorPackage(ai.packageName) == true) goto L14;
        if (isDefaultAdservicesPackage(ai.packageName) == true) goto L14;
        return false;
    }

    private boolean isDefaultSearchSelectorPackage(String pkg) {
        return Objects.equals(this.mDefaultSearchSelectorPkg, pkg);
    }

    private boolean isDefaultAdservicesPackage(String pkg) {
        if (this.mAdservicesModuleInfo != null) goto L5;
        return false;
    L5:
        Iterator r0 = this.mAdservicesModuleInfo.getApkInApexPackageNames().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        String apkName = (String) r0.next();
        if (Objects.equals(apkName, pkg) == false) goto L7;
        return true;
    L13:
        return false;
    }

    private boolean isEnterpriseExempted(ApplicationInfo ai) {
        if (this.mDpm == null) goto L10;
        if (this.mDpm.isActiveProfileOwner(ai.uid) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mDpm.isActiveDeviceOwner(ai.uid) == true) goto L8;
    L10:
        if (ai.uid != 1000) goto L13;
        return false;
    L13:
        if (this.mAppOps.checkOpNoThrow(125, ai.uid, ai.packageName) != 0) goto L16;
        return true;
    L16:
        return false;
    }

    private boolean checkUseFullScreenIntentPermission(AttributionSource attributionSource, ApplicationInfo applicationInfo, boolean forDataDelivery) {
        if (applicationInfo.targetSdkVersion >= 29) goto L6;
        return true;
    L6:
        if (forDataDelivery == false) goto L8;
        int permissionResult = this.mPermissionManager.checkPermissionForDataDelivery("android.permission.USE_FULL_SCREEN_INTENT", attributionSource, null);
    L9:
        if (permissionResult == 0) goto L13;
        return false;
    L13:
        return true;
    L8:
        permissionResult = this.mPermissionManager.checkPermissionForPreflight("android.permission.USE_FULL_SCREEN_INTENT", attributionSource);
        goto L9
    }

    private void checkRemoteViews(String pkg, String tag, int id, Notification notification) {
        if (removeRemoteView(pkg, tag, id, notification.contentView) == false) goto L6;
        notification.contentView = null;
    L6:
        if (removeRemoteView(pkg, tag, id, notification.bigContentView) == false) goto L9;
        notification.bigContentView = null;
    L9:
        if (removeRemoteView(pkg, tag, id, notification.headsUpContentView) == false) goto L12;
        notification.headsUpContentView = null;
    L12:
        if (notification.publicVersion != null) goto L14;
        return;
    L14:
        if (removeRemoteView(pkg, tag, id, notification.publicVersion.contentView) == false) goto L17;
        notification.publicVersion.contentView = null;
    L17:
        if (removeRemoteView(pkg, tag, id, notification.publicVersion.bigContentView) == false) goto L20;
        notification.publicVersion.bigContentView = null;
    L20:
        if (removeRemoteView(pkg, tag, id, notification.publicVersion.headsUpContentView) == false) goto L24;
        notification.publicVersion.headsUpContentView = null;
        return;
    }

    private boolean removeRemoteView(String pkg, String tag, int id, RemoteViews contentView) {
        if (contentView != null) goto L5;
        return false;
    L5:
        long contentViewSize = contentView.estimateMemoryUsage();
        if (contentViewSize <= this.mWarnRemoteViewsSizeBytes) goto L11;
        if (contentViewSize >= this.mStripRemoteViewsSizeBytes) goto L11;
        Slog.w(TAG, "RemoteViews too large on pkg: " + pkg + " tag: " + tag + " id: " + id + " this might be stripped in a future release");
    L11:
        if (contentViewSize < this.mStripRemoteViewsSizeBytes) goto L14;
        this.mUsageStats.registerImageRemoved(pkg);
        Slog.w(TAG, "Removed too large RemoteViews (" + contentViewSize + " bytes) on pkg: " + pkg + " tag: " + tag + " id: " + id);
        return true;
    L14:
        return false;
    }

    private void updateNotificationBubbleFlags(NotificationRecord r, boolean isAppForeground) {
        Notification notification = r.getNotification();
        Notification.BubbleMetadata metadata = notification.getBubbleMetadata();
        if (metadata != null) goto L5;
        return;
    L5:
        if (isAppForeground == true) goto L8;
        int flags = metadata.getFlags();
        metadata.setFlags(flags & (-2));
    L8:
        if (metadata.isBubbleSuppressable() == true) goto L11;
        int flags2 = metadata.getFlags();
        metadata.setFlags(flags2 & (-9));
        return;
    }

    protected void doChannelWarningToast(int forUid, final CharSequence toastText) {
        Binder.withCleanCallingIdentity(new NotificationManagerService$$ExternalSyntheticLambda22(this, toastText));
    }

    private /* synthetic */ void lambda$doChannelWarningToast$13(CharSequence toastText) throws Exception {
        if (Settings.Global.getInt(getContext().getContentResolver(), "show_notification_channel_warnings", 0) == 0) goto L5;
        boolean warningEnabled = true;
    L6:
        if (warningEnabled == false) goto L9;
        Toast toast = Toast.makeText(getContext(), this.mHandler.getLooper(), toastText, 0);
        toast.show();
        return;
    L9:
        return;
    L5:
        warningEnabled = false;
        goto L6
    }

    int resolveNotificationUid(String callingPkg, String targetPkg, int callingUid, int userId) throws PackageManager.NameNotFoundException {
        if (userId != (-1)) goto L6;
        userId = UserHandle.getUserId(callingUid);
    L6:
        if (isCallerSameApp(targetPkg, callingUid, userId) == true) goto L8;
    L12:
        boolean isPushNotification = NUBIA_PUSH_CLIENT_PACKAGE.equals(callingPkg);
        int targetUid = this.mPackageManagerClient.getPackageUidAsUser(targetPkg, userId);
        if (isCallerAndroid(callingPkg, callingUid) == false) goto L15;
    L22:
        return targetUid;
    L15:
        if (this.mPreferencesHelper.isDelegateAllowed(targetPkg, targetUid, callingPkg, callingUid) == true) goto L22;
        if (isPushNotification == false) goto L21;
        if (this.isReplaceTargetPkg.booleanValue() == true) goto L22;
    L21:
        throw new SecurityException("Caller " + callingPkg + ":" + callingUid + " cannot post for pkg " + targetPkg + " in user " + userId);
    L8:
        if (TextUtils.equals(callingPkg, targetPkg) == false) goto L10;
    L11:
        return callingUid;
    L10:
        if (isCallerSameApp(callingPkg, callingUid, userId) == false) goto L12;
        goto L11
    }

    public boolean hasFlag(int flags, int flag) {
        if ((flags & flag) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [int] */
    boolean checkDisqualifyingFeatures(int r21, int r22, int r23, String r24, NotificationRecord r25, boolean r26, boolean r27) {
        Notification r5 = r25.getNotification();
        String r6 = r25.getSbn().getPackageName();
        if (isUidSystemOrPhone(r22) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        boolean r9 = r0;
        boolean r10 = this.mListeners.isListenerPackage(r6);
        if (r9 == true) goto L65;
        if (r10 == true) goto L65;
        int r11 = Binder.getCallingUid();
        Object r12 = this.mNotificationLock;
        monitor-enter(r12);
    L59:
        th = th;
    L161:
        monitor-exit(r12);     // Catch: Throwable -> L63
        throw th;
    L63:
        th = th;
        goto L161
    L15:
        if (this.mNotificationsByKey.get(r25.getSbn().getKey()) == null) goto L166;
    L23:
        if (this.mNotificationsByKey.get(r25.getSbn().getKey()) == null) goto L26;
    L29:
        boolean r1 = true;
    L165:
        if (r1 == true) goto L159;
    L50:
        boolean r17 = false;
    L51:
        monitor-exit(r12);     // Catch: Throwable -> L42
        if (r5.isFgsOrUij() == true) goto L67;
        int r2 = getNotificationCount(r6, r21, r23, r24);
        if (r2 < 50) goto L67;
        this.mUsageStats.registerOverCountQuota(r6);
        Slog.e(TAG, "Package has already posted or enqueued " + r2 + " notifications.  Not showing more.  package=" + r6);
        return r17;
    L67:
        if (r5.getBubbleMetadata() == null) goto L76;
        if (r5.getBubbleMetadata().getIntent() == null) goto L76;
        if (hasFlag(this.mAmi.getPendingIntentFlags(r5.getBubbleMetadata().getIntent().getTarget()), 67108864) == false) goto L76;
        throw new IllegalArgumentException(r25.getKey() + " Not posted. PendingIntents attached to bubbles must be mutable");
    L76:
        if (r5.actions == null) goto L91;
        Notification.Action[] r3 = r5.actions;
        int r13 = r3.length;
        ?? r14 = r17;
    L78:
        if (r14 >= r13) goto L90;
        Notification.Action r15 = r3[r14];
        if (r15.getRemoteInputs() != null) goto L86;
        if (r15.getDataOnlyRemoteInputs() != null) goto L86;
    L87:
        r14 = r14 + 1;
    L86:
        if (hasFlag(this.mAmi.getPendingIntentFlags(r15.actionIntent.getTarget()), 67108864) == false) goto L87;
        throw new IllegalArgumentException(r25.getKey() + " Not posted. PendingIntents attached to actions with remote inputs must be mutable");
    L90:
        boolean r18 = true;
    L93:
        if (r25.getSystemGeneratedSmartActions() == null) goto L107;
        Iterator<Notification.Action> r4 = r25.getSystemGeneratedSmartActions().iterator();
    L96:
        if (r4.hasNext() == false) goto L107;
        Notification.Action r7 = r4.next();
        if (r7.getRemoteInputs() != null) goto L102;
        if (r7.getDataOnlyRemoteInputs() == null) goto L96;
    L102:
        if (hasFlag(this.mAmi.getPendingIntentFlags(r7.actionIntent.getTarget()), 67108864) == false) goto L96;
        throw new IllegalArgumentException(r25.getKey() + " Not posted. PendingIntents attached to contextual actions with remote inputs must be mutable");
    L107:
        if (r5.isStyle(Notification.CallStyle.class) == false) goto L125;
        if (r5.fullScreenIntent == null) goto L111;
        boolean r8 = r18;
    L113:
        if ((r5.flags & 16384) == 0) goto L115;
        boolean r16 = r18;
    L117:
        if (r5.isFgsOrUij() == true) goto L125;
        if (r8 == true) goto L125;
        if (r16 == true) goto L125;
        if (r27 == true) goto L125;
        throw new IllegalArgumentException(r25.getKey() + " Not posted. CallStyle notifications must be for a foreground service or user initated job or use a fullScreenIntent.");
    L115:
        r16 = r17;
        goto L117
    L111:
        r8 = r17;
    L125:
        if (this.mSnoozeHelper.isSnoozed(r21, r6, r25.getKey()) == false) goto L131;
        MetricsLogger.action(r25.getLogMaker().setType(6).setCategory(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_SESSION));
        this.mNotificationRecordLogger.log(NotificationRecordLogger.NotificationEvent.NOTIFICATION_NOT_POSTED_SNOOZED, r25);
        if (DBG == false) goto L129;
        Slog.d(TAG, "Ignored enqueue for snoozed notification " + r25.getKey());
    L129:
        this.mSnoozeHelper.update(r21, r25);
        handleSavePolicyFile();
        return r17;
    L131:
        boolean r19 = !areNotificationsEnabledForPackageInt(r22);
        Object r110 = this.mNotificationLock;
        monitor-enter(r110);
        boolean r20 = r19 | isRecordBlockedLocked(r25);     // Catch: Throwable -> L154
        monitor-exit(r110);     // Catch: Throwable -> L154
        if (r20 == false) goto L146;
        if (r5.isMediaNotification() == true) goto L146;
        if (isCallNotification(r6, r22, r5) == true) goto L146;
        if (DBG == false) goto L143;
        Slog.e(TAG, "Suppressing notification from package " + r25.getSbn().getPackageName() + " by user request.");
    L143:
        this.mUsageStats.registerBlocked(r25);
        return r17;
    L146:
        if (r5.hasAppProvidedWhen() == true) goto L148;
    L153:
        return r18;
    L148:
        if (r5.getWhen() <= 0) goto L153;
        if ((System.currentTimeMillis() - r5.getWhen()) <= NOTIFICATION_MAX_AGE_AT_POST) goto L153;
        Slog.d(TAG, "Ignored enqueue for old " + r5.getWhen() + " notification " + r25.getKey());
        this.mUsageStats.registerTooOldBlocked(r25);
        return r17;
    L154:
        th = move-exception;
        throw th;
    L91:
        r18 = true;
        goto L93
    L159:
    L46:
        th = th;
        goto L161
    L33:
        if (r25.getNotification().hasCompletedProgress() == true) goto L50;
        if (r26 == true) goto L50;
        float r111 = this.mUsageStats.getAppEnqueueRate(r6);     // Catch: Throwable -> L46
        if (r111 <= this.mMaxPackageEnqueueRate) goto L49;
        this.mUsageStats.registerOverRateQuota(r6);     // Catch: Throwable -> L46
        long r112 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L46
        if ((r112 - this.mLastOverRateLogTime) <= MIN_PACKAGE_OVERRATE_LOG_INTERVAL) goto L44;
        Slog.e(TAG, "Package enqueue rate is " + r111 + ". Shedding " + r25.getSbn().getKey() + ". package=" + r6);     // Catch: Throwable -> L42
        this.mLastOverRateLogTime = r112;     // Catch: Throwable -> L42
    L44:
        monitor-exit(r12);     // Catch: Throwable -> L42
        return false;
    L49:
        r17 = false;
    L42:
        th = th;
        goto L161
    L26:
        if (findNotificationByListLocked(this.mEnqueuedNotifications, r25.getSbn().getKey()) != null) goto L29;
        r1 = false;
        goto L165
    L166:
    L21:
        th = th;
        goto L161
    L17:
        if (isCallerInstantApp(r11, r21) == false) goto L23;
        throw new SecurityException("Instant app " + r6 + " cannot create notifications");     // Catch: Throwable -> L21
    L65:
        r17 = false;
        goto L67
    L5:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(r6) == true) goto L8;
        r0 = false;
        goto L9
    }

    private boolean isCallNotification(String pkg, int uid, Notification n) {
        if (n.isStyle(Notification.CallStyle.class) == true) goto L5;
        return false;
    L5:
        return isCallNotification(pkg, uid);
    }

    private boolean isCallNotification(String pkg, int uid) {
        long identity = Binder.clearCallingIdentity();
        boolean r3 = false;
        if (this.mPackageManagerClient.hasSystemFeature("android.software.telecom") == true) goto L6;
    L21:
        Binder.restoreCallingIdentity(identity);
        return false;
    L6:
        if (this.mTelecomManager == null) goto L21;
        if (this.mTelecomManager.isInManagedCall() == true) goto L16;
        if (this.mTelecomManager.isInSelfManagedCall(pkg, UserHandle.ALL) == true) goto L16;
    L17:
        Binder.restoreCallingIdentity(identity);
        return r3;
    L16:
        r3 = true;
    L19:
        Binder.restoreCallingIdentity(identity);
        return false;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean areNotificationsEnabledForPackageInt(int uid) {
        return this.mPermissionHelper.hasPermission(uid);
    }

    private int getNotificationCount(String pkg, int userId) {
        int count = 0;
        Object r1 = this.mNotificationLock;
        monitor-enter(r1);
        int numListSize = this.mNotificationList.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= numListSize) goto L14;
        NotificationRecord existing = this.mNotificationList.get(i);     // Catch: Throwable -> L11
        if (existing.getSbn().getPackageName().equals(pkg) == false) goto L13;
        if (existing.getSbn().getUserId() != userId) goto L13;
        count = count + 1;     // Catch: Throwable -> L11
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L14:
        int numEnqSize = this.mEnqueuedNotifications.size();     // Catch: Throwable -> L11
        int i2 = 0;
    L15:
        if (i2 >= numEnqSize) goto L23;
        NotificationRecord existing2 = this.mEnqueuedNotifications.get(i2);     // Catch: Throwable -> L11
        if (existing2.getSbn().getPackageName().equals(pkg) == false) goto L21;
        if (existing2.getSbn().getUserId() != userId) goto L21;
        count = count + 1;     // Catch: Throwable -> L11
    L21:
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L15
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return count;
    L11:
        th = move-exception;
        throw th;
    }

    protected int getNotificationCount(String pkg, int userId, int excludedId, String excludedTag) {
        int count = 0;
        Object r1 = this.mNotificationLock;
        monitor-enter(r1);
        int N = this.mNotificationList.size();     // Catch: Throwable -> L15
        int i = 0;
    L5:
        if (i >= N) goto L19;
        NotificationRecord existing = this.mNotificationList.get(i);     // Catch: Throwable -> L15
        if (existing.getSbn().getPackageName().equals(pkg) == false) goto L18;
        if (existing.getSbn().getUserId() != userId) goto L18;
        if (existing.getSbn().getId() == excludedId) goto L13;
    L17:
        count = count + 1;     // Catch: Throwable -> L15
        goto L18
    L13:
        if (TextUtils.equals(existing.getSbn().getTag(), excludedTag) == false) goto L17;
    L18:
        i = i + 1;     // Catch: Throwable -> L15
        goto L5
    L19:
        int M = this.mEnqueuedNotifications.size();     // Catch: Throwable -> L15
        int i2 = 0;
    L20:
        if (i2 >= M) goto L28;
        NotificationRecord existing2 = this.mEnqueuedNotifications.get(i2);     // Catch: Throwable -> L15
        if (existing2.getSbn().getPackageName().equals(pkg) == false) goto L26;
        if (existing2.getSbn().getUserId() != userId) goto L26;
        count = count + 1;     // Catch: Throwable -> L15
    L26:
        i2 = i2 + 1;     // Catch: Throwable -> L15
        goto L20
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return count;
    L15:
        th = move-exception;
        throw th;
    }

    boolean isRecordBlockedLocked(NotificationRecord r) {
        String pkg = r.getSbn().getPackageName();
        int callingUid = r.getSbn().getUid();
        if (this.mPreferencesHelper.isGroupBlocked(pkg, callingUid, r.getChannel().getGroup()) == false) goto L5;
    L8:
        return true;
    L5:
        if (r.getImportance() == 0) goto L8;
        return false;
    }

    private void unsnoozeAll() {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mSnoozeHelper.repostAll(this.mUserProfiles.getCurrentProfileIds());     // Catch: Throwable -> L7
        handleSavePolicyFile();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isPackagePausedOrSuspended(String pkg, int uid) {
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int flags = pmi.getDistractingPackageRestrictions(pkg, Binder.getCallingUserHandle().getIdentifier());
        if ((flags & 2) == 0) goto L5;
        boolean isPaused = true;
    L7:
        return isPaused | isPackageSuspendedForUser(pkg, uid);
    L5:
        isPaused = false;
        goto L7
    }

    private void reportNavigationFgsNotificationIfNeeded(NotificationRecord r, boolean active) {
        if (r != null) goto L4;
        return;
    L4:
        if (r.getSbn() == null) goto L27;
        StatusBarNotification sbn = r.getSbn();
        final String pkg = sbn.getPackageName();
        if (SMART_CHARGING_NAVIGATION_PACKAGES.contains(pkg) == true) goto L9;
        return;
    L9:
        Notification notification = sbn.getNotification();
        boolean r1 = false;
        if (active == false) goto L12;
        final int type = getNavigationFgsNotificationType(pkg, notification);
    L14:
        if (active == false) goto L17;
        if (type == 0) goto L17;
        r1 = true;
    L17:
        final boolean reportActive = r1;
        final int uid = sbn.getUid();
        final String key = sbn.getKey();
        String r2 = null;
        if (notification == null) goto L20;
        String channelId = notification.getChannelId();
    L21:
        StringBuilder r9 = new StringBuilder();
        r9.append("Navigation FGS notification report, uid=");
        r9.append(uid);
        r9.append(", pkg=");
        r9.append(pkg);
        r9.append(", key=");
        r9.append(key);
        r9.append(", category=");
        if (notification == null) goto L24;
        r2 = notification.category;
    L24:
        r9.append(r2);
        r9.append(", channelId=");
        r9.append(channelId);
        r9.append(", type=");
        r9.append(type);
        r9.append(", active=");
        r9.append(reportActive);
        Slog.i(TAG, r9.toString());
        this.mHandler.post(new NotificationManagerService$$ExternalSyntheticLambda12(uid, pkg, key, type, reportActive));
        return;
    L20:
        channelId = null;
        goto L21
    L12:
        type = 0;
        goto L14
    }

    private static /* synthetic */ void lambda$reportNavigationFgsNotificationIfNeeded$14(int uid, String pkg, String key, int type, boolean reportActive) {
        IBytedancePowerAdvisor powerAdvisor = SysOptBridge.getFactory().getBytedancePowerAdvisorInstance();
        if (powerAdvisor == null) goto L6;
        powerAdvisor.noteNavigationFgsNotificationChanged(uid, pkg, key, type, reportActive);
        return;
    }

    private int getNavigationFgsNotificationType(String pkg, Notification notification) {
        if (notification != null) goto L4;
        return 0;
    L4:
        if (notification.isForegroundService() == true) goto L7;
        return 0;
    L7:
        if ("navigation".equals(notification.category) == false) goto L11;
        return 2;
    L11:
        if ("transport".equals(notification.category) == false) goto L14;
        return 3;
    L14:
        if (isKnownNavigationFgsChannel(pkg, notification.getChannelId()) == false) goto L16;
        return 3;
    L16:
        return 1;
    }

    private boolean isKnownNavigationFgsChannel(String pkg, String channelId) {
        ArraySet<String> channels = SMART_CHARGING_NAVIGATION_CHANNELS.get(pkg);
        if (channels != null) goto L5;
    L7:
        return false;
    L5:
        if (channels.contains(channelId) == false) goto L7;
        return true;
    }

    InstanceId getGroupInstanceId(String groupKey) {
        if (groupKey != null) goto L5;
        return null;
    L5:
        NotificationRecord group = this.mSummaryByGroupKey.get(groupKey);
        if (group != null) goto L9;
        return null;
    L9:
        return group.getSbn().getInstanceId();
    }

    protected boolean isVisuallyInterruptive(NotificationRecord old, NotificationRecord r) {
        if (r.getSbn().isGroup() == false) goto L11;
        if (r.getSbn().getNotification().isGroupSummary() == false) goto L11;
        if (DEBUG_INTERRUPTIVENESS == false) goto L9;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is not interruptive: summary");
    L9:
        return false;
    L11:
        if (old == null) goto L13;
        Notification oldN = old.getSbn().getNotification();
        Notification newN = r.getSbn().getNotification();
        if (oldN.extras == null) goto L81;
        if (newN.extras == null) goto L81;
        if (r.getSbn().getNotification().isFgsOrUij() == true) goto L24;
        String oldTitle = String.valueOf(oldN.extras.get("android.title"));
        String newTitle = String.valueOf(newN.extras.get("android.title"));
        if (Objects.equals(oldTitle, newTitle) == false) goto L30;
        String oldText = String.valueOf(oldN.extras.get("android.text"));
        String newText = String.valueOf(newN.extras.get("android.text"));
        if (Objects.equals(oldText, newText) == true) goto L40;
        if (DEBUG_INTERRUPTIVENESS == false) goto L38;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: changed text");
        StringBuilder r1 = new StringBuilder();
        r1.append("INTERRUPTIVENESS: ");
        r1.append(String.format("   old text: %s (%s@0x%08x)", new Object[]{oldText, oldText.getClass(), Integer.valueOf(oldText.hashCode())}));
        Slog.v(TAG, r1.toString());
        Slog.v(TAG, "INTERRUPTIVENESS: " + String.format("   new text: %s (%s@0x%08x)", new Object[]{newText, newText.getClass(), Integer.valueOf(newText.hashCode())}));
    L38:
        return true;
    L40:
        if (oldN.hasCompletedProgress() == newN.hasCompletedProgress()) goto L46;
        if (DEBUG_INTERRUPTIVENESS == false) goto L44;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: completed progress");
    L44:
        return true;
    L46:
        if (Notification.areIconsDifferent(oldN, newN) == false) goto L52;
        if (DEBUG_INTERRUPTIVENESS == false) goto L50;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: icons differ");
    L50:
        return true;
    L52:
        if (r.canBubble() == false) goto L58;
        if (DEBUG_INTERRUPTIVENESS == false) goto L56;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is not interruptive: bubble");
    L56:
        return false;
    L58:
        if (Notification.areActionsVisiblyDifferent(oldN, newN) == true) goto L60;
        Notification.Builder oldB = Notification.Builder.recoverBuilder(getContext(), oldN);     // Catch: Exception -> L68
        Notification.Builder newB = Notification.Builder.recoverBuilder(getContext(), newN);     // Catch: Exception -> L68
        if (Notification.areStyledNotificationsVisiblyDifferent(oldB, newB) == false) goto L72;
        if (DEBUG_INTERRUPTIVENESS == false) goto L70;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: styles differ");     // Catch: Exception -> L68
    L70:
        return true;
    L72:
        if (Notification.areRemoteViewsChanged(oldB, newB) == true) goto L74;
    L79:
        return false;
    L74:
        if (DEBUG_INTERRUPTIVENESS == false) goto L76;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: remoteviews differ");     // Catch: Exception -> L68
    L76:
        return true;
    L68:
        e = move-exception;
        Slog.w(TAG, "error recovering builder", e);
        goto L79
    L60:
        if (DEBUG_INTERRUPTIVENESS == false) goto L62;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: changed actions");
    L62:
        return true;
    L30:
        if (DEBUG_INTERRUPTIVENESS == false) goto L32;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: changed title");
        StringBuilder r2 = new StringBuilder();
        r2.append("INTERRUPTIVENESS: ");
        r2.append(String.format("   old title: %s (%s@0x%08x)", new Object[]{oldTitle, oldTitle.getClass(), Integer.valueOf(oldTitle.hashCode())}));
        Slog.v(TAG, r2.toString());
        Slog.v(TAG, "INTERRUPTIVENESS: " + String.format("   new title: %s (%s@0x%08x)", new Object[]{newTitle, newTitle.getClass(), Integer.valueOf(newTitle.hashCode())}));
    L32:
        return true;
    L24:
        if (DEBUG_INTERRUPTIVENESS == false) goto L26;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is not interruptive: FGS/UIJ");
    L26:
        return false;
    L81:
        if (DEBUG_INTERRUPTIVENESS == false) goto L83;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is not interruptive: no extras");
    L83:
        return false;
    L13:
        if (DEBUG_INTERRUPTIVENESS == false) goto L15;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r.getKey() + " is interruptive: new notification");
    L15:
        return true;
    }

    private boolean isCritical(NotificationRecord record) {
        if (record.getCriticality() >= 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean wasSummaryAutogrouped(NotificationRecord r, NotificationRecord old) {
        if (old == null) goto L27;
        boolean isNotAutogroupSummary = false;
        if ((old.mOriginalFlags & 512) == 0) goto L7;
        boolean wasSummary = true;
    L9:
        if ((old.getFlags() & 512) == 0) goto L11;
    L13:
        boolean wasForcedGrouped = false;
    L15:
        if ((r.getFlags() & 1024) == 0) goto L17;
    L21:
        if (wasSummary == false) goto L23;
        if (wasForcedGrouped == false) goto L23;
    L25:
        return true;
    L23:
        if (wasForcedGrouped == false) goto L28;
        if (isNotAutogroupSummary == true) goto L25;
        return false;
    L28:
        return false;
    L17:
        if ((r.getFlags() & 512) == 0) goto L21;
        isNotAutogroupSummary = true;
        goto L21
    L11:
        if (old.getSbn().getOverrideGroupKey() == null) goto L13;
        wasForcedGrouped = true;
        goto L15
    L7:
        wasSummary = false;
        goto L9
    L27:
        return false;
    }

    private void handleGroupedNotificationLocked(NotificationRecord r, NotificationRecord old, int callingUid, int callingPid) {
        StatusBarNotification sbn = r.getSbn();
        Notification n = sbn.getNotification();
        if (n.isGroupSummary() == false) goto L8;
        if (sbn.isAppGroup() == true) goto L8;
        n.flags &= -513;
    L8:
        if (wasSummaryAutogrouped(r, old) == false) goto L10;
        n.flags &= -513;
    L10:
        String group = sbn.getGroupKey();
        boolean isSummary = n.isGroupSummary();
        String oldGroup = null;
        if (old == null) goto L13;
        Notification r4 = old.getSbn().getNotification();
    L14:
        Notification oldN = r4;
        if (old == null) goto L17;
        oldGroup = old.getSbn().getGroupKey();
    L17:
        if (old != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        boolean oldIsSummary = r5;
        if (oldIsSummary == false) goto L30;
        NotificationRecord removedSummary = this.mSummaryByGroupKey.remove(oldGroup);
        if (removedSummary == old) goto L30;
        if (removedSummary == null) goto L28;
        String removedKey = removedSummary.getKey();
    L29:
        Slog.w(TAG, "Removed summary didn't match old notification: old=" + old.getKey() + ", removed=" + removedKey);
        goto L30
    L28:
        removedKey = "<null>";
    L30:
        if (isSummary == false) goto L32;
        this.mSummaryByGroupKey.put(group, r);
        this.mGroupHelper.onGroupSummaryAdded(r, this.mNotificationList);
    L32:
        FlagChecker childrenFlagChecker = new NotificationManagerService$$ExternalSyntheticLambda7();
        if (oldIsSummary == false) goto L41;
        if (isSummary == true) goto L36;
    L39:
        cancelGroupChildrenLocked(old.getUserId(), old.getSbn().getPackageName(), callingUid, callingPid, null, false, childrenFlagChecker, new NotificationManagerService$$ExternalSyntheticLambda8(), old.getGroupKey(), 8, SystemClock.elapsedRealtime());
        return;
    L36:
        if (oldGroup.equals(group) == false) goto L39;
        return;
    L41:
        return;
    L19:
        if (oldN.isGroupSummary() == false) goto L21;
        r5 = true;
        goto L22
    L13:
        r4 = null;
        goto L14
    }

    private static /* synthetic */ boolean lambda$handleGroupedNotificationLocked$15(int flags) {
        if ((flags & 64) == 0) goto L5;
        return false;
    L5:
        if ((32768 & flags) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private PendingIntent getNotificationTimeoutPendingIntent(NotificationRecord record, int flags) {
        Context r0 = getContext();
        Intent r1 = new Intent(ACTION_NOTIFICATION_TIMEOUT).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).setData(new Uri.Builder().scheme(SCHEME_TIMEOUT).appendPath(record.getKey()).build()).addFlags(268435456).putExtra(EXTRA_KEY, record.getKey());
        return PendingIntent.getBroadcast(r0, 1, r1, flags | 67108864);
    }

    void scheduleTimeoutLocked(NotificationRecord record) {
        if (record.getNotification().getTimeoutAfter() <= 0) goto L6;
        PendingIntent pi = getNotificationTimeoutPendingIntent(record, 134217728);
        this.mAlarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + record.getNotification().getTimeoutAfter(), pi);
        return;
    }

    void cancelScheduledTimeoutLocked(NotificationRecord record) {
        PendingIntent pi = getNotificationTimeoutPendingIntent(record, 268435456);
        if (pi == null) goto L6;
        this.mAlarmManager.cancel(pi);
        return;
    }

    void showNextToastLocked(boolean lastToastWasTextRecord) {
        if (this.mIsCurrentToastShown == false) goto L5;
        return;
    L5:
        ToastRecord record = this.mToastQueue.get(0);
    L6:
        if (record == null) goto L32;
        int userId = UserHandle.getUserId(record.uid);
        boolean rateLimitingEnabled = !this.mToastRateLimitingDisabledUids.contains(Integer.valueOf(record.uid));
        if (this.mToastRateLimiter.isWithinQuota(userId, record.pkg, TOAST_QUOTA_TAG) == false) goto L10;
    L13:
        boolean isWithinQuota = true;
    L14:
        boolean isPackageInForeground = isPackageInForegroundForToast(record.uid);
        if (GameKeysHelper.GAME_APP_TOAST_WHITE_LIST.contains(record.pkg) == false) goto L18;
        isPackageInForeground = true;
    L18:
        if (tryShowToast(record, rateLimitingEnabled, isWithinQuota, isPackageInForeground) == true) goto L19;
        int index = this.mToastQueue.indexOf(record);
        if (index < 0) goto L28;
        ToastRecord toast = this.mToastQueue.remove(index);
        this.mWindowManagerInternal.removeWindowToken(toast.windowToken, true, toast.displayId);
    L28:
        if (this.mToastQueue.size() <= 0) goto L30;
        ToastRecord r4 = this.mToastQueue.get(0);
    L31:
        record = r4;
        goto L6
    L30:
        r4 = null;
        goto L31
    L19:
        scheduleDurationReachedLocked(record, lastToastWasTextRecord);
        this.mIsCurrentToastShown = true;
        if (rateLimitingEnabled == false) goto L37;
        if (isPackageInForeground == true) goto L38;
        this.mToastRateLimiter.noteEvent(userId, record.pkg, TOAST_QUOTA_TAG);
        return;
    L38:
        return;
    L37:
        return;
    L10:
        if (isExemptFromRateLimiting(record.pkg, userId) == true) goto L13;
        isWithinQuota = false;
        goto L14
    }

    private boolean tryShowToast(ToastRecord record, boolean rateLimitingEnabled, boolean isWithinQuota, boolean isPackageInForeground) {
        if (rateLimitingEnabled == false) goto L9;
        if (isWithinQuota == true) goto L9;
        if (isPackageInForeground == true) goto L9;
        reportCompatRateLimitingToastsChange(record.uid);
        Slog.w(TAG, "Package " + record.pkg + " is above allowed toast quota, the following toast was blocked and discarded: " + record);
        return false;
    L9:
        if (blockToast(record.uid, record.isSystemToast, record.isAppRendered(), isPackageInForeground) == false) goto L13;
        Slog.w(TAG, "Blocking custom toast from package " + record.pkg + " due to package not in the foreground at the time of showing the toast");
        return false;
    L13:
        return record.show();
    }

    private boolean isExemptFromRateLimiting(String pkg, int userId) {
        if (this.mPackageManager.checkPermission("android.permission.UNLIMITED_TOASTS", pkg, userId) != 0) goto L6;
        boolean r1 = true;
    L7:
        boolean isExemptFromRateLimiting = r1;
        return isExemptFromRateLimiting;
    L6:
        r1 = false;
    L9:
        Slog.e(TAG, "Failed to connect with package manager");
        return false;
    }

    private void reportCompatRateLimitingToastsChange(int uid) {
        long id = Binder.clearCallingIdentity();
        this.mPlatformCompat.reportChangeByUid(RATE_LIMIT_TOASTS, uid);     // Catch: Throwable -> L5 RemoteException -> L7
    L4:
        Binder.restoreCallingIdentity(id);
        return;
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(id);
        throw th;
    L7:
        e = move-exception;
        Slog.e(TAG, "Unexpected exception while reporting toast was blocked due to rate limiting", e);     // Catch: Throwable -> L5
        goto L4
    }

    void cancelToastLocked(int index) {
        ToastRecord record = this.mToastQueue.get(index);
        record.hide();
        if (index != 0) goto L5;
        this.mIsCurrentToastShown = false;
    L5:
        ToastRecord lastToast = this.mToastQueue.remove(index);
        scheduleKillTokenTimeout(lastToast);
        keepProcessAliveForToastIfNeededLocked(record.pid);
        if (this.mToastQueue.size() <= 0) goto L9;
        showNextToastLocked(lastToast instanceof TextToastRecord);
        return;
    }

    void finishWindowTokenLocked(IBinder t, int displayId) {
        this.mHandler.removeCallbacksAndMessages(t);
        this.mWindowManagerInternal.removeWindowToken(t, true, displayId);
    }

    private void scheduleDurationReachedLocked(ToastRecord r, boolean lastToastWasTextRecord) {
        this.mHandler.removeCallbacksAndMessages(r);
        Message m = Message.obtain(this.mHandler, 2, r);
        if (r.getDuration() != 1) goto L5;
        int delay = LONG_DELAY;
    L6:
        int delay2 = this.mAccessibilityManager.getRecommendedTimeoutMillis(delay, 2);
        if (lastToastWasTextRecord == false) goto L10;
        delay2 = delay2 + 250;
    L10:
        if ((r instanceof TextToastRecord) == false) goto L12;
        delay2 = delay2 + FrameworkStatsLog.DEVICE_ROTATED;
    L12:
        this.mHandler.sendMessageDelayed(m, delay2);
        return;
    L5:
        delay = 2000;
        goto L6
    }

    private void handleDurationReached(ToastRecord record) {
        if (DBG == false) goto L5;
        Slog.d(TAG, "Timeout pkg=" + record.pkg + " token=" + record.token);
    L5:
        ArrayList<ToastRecord> r0 = this.mToastQueue;
        monitor-enter(r0);
        int index = indexOfToastLocked(record.pkg, record.token);     // Catch: Throwable -> L10
        if (index < 0) goto L12;
        cancelToastLocked(index);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void scheduleKillTokenTimeout(ToastRecord r) {
        this.mHandler.removeCallbacksAndMessages(r);
        Message m = Message.obtain(this.mHandler, 7, r);
        this.mHandler.sendMessageDelayed(m, 11000);
    }

    private void handleKillTokenTimeout(ToastRecord record) {
        if (DBG == false) goto L5;
        Slog.d(TAG, "Kill Token Timeout token=" + record.windowToken);
    L5:
        ArrayList<ToastRecord> r0 = this.mToastQueue;
        monitor-enter(r0);
        finishWindowTokenLocked(record.windowToken, record.displayId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    int indexOfToastLocked(String pkg, IBinder token) {
        ArrayList<ToastRecord> list = this.mToastQueue;
        int len = list.size();
        int i = 0;
    L3:
        if (i >= len) goto L10;
        ToastRecord r = list.get(i);
        if (r.pkg.equals(pkg) == false) goto L9;
        if (r.token != token) goto L9;
        return i;
    L9:
        i = i + 1;
        goto L3
    L10:
        return -1;
    }

    public void keepProcessAliveForToastIfNeeded(int pid) {
        ArrayList<ToastRecord> r0 = this.mToastQueue;
        monitor-enter(r0);
        keepProcessAliveForToastIfNeededLocked(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void keepProcessAliveForToastIfNeededLocked(int pid) {
        int toastCount = 0;
        ArrayList<ToastRecord> list = this.mToastQueue;
        int n = list.size();
        int i = 0;
    L3:
        if (i >= n) goto L19;
        ToastRecord r = list.get(i);
        if (r.pid != pid) goto L9;
        if (r.keepProcessAlive() == false) goto L9;
        toastCount = toastCount + 1;
    L9:
        i = i + 1;
        goto L3
    L19:
        IActivityManager r3 = this.mAm;     // Catch: RemoteException -> L17
        IBinder r4 = this.mForegroundToken;     // Catch: RemoteException -> L17
        if (toastCount <= 0) goto L14;
        boolean r5 = true;
    L15:
        r3.setProcessImportant(r4, pid, r5, "toast");     // Catch: RemoteException -> L17
        return;
    L14:
        r5 = false;
    }

    private boolean isPackageInForegroundForToast(int callingUid) {
        return this.mAtm.hasResumedActivity(callingUid);
    }

    private boolean blockToast(int uid, boolean isSystemToast, boolean isAppRenderedToast, boolean isPackageInForeground) {
        String[] packages = getContext().getPackageManager().getPackagesForUid(uid);
        if (packages != null) goto L5;
    L9:
        boolean isXtsApp = false;
    L10:
        boolean changeEnabled = CompatChanges.isChangeEnabled(CHANGE_BACKGROUND_CUSTOM_TOAST_BLOCK, uid);
        if (isAppRenderedToast == false) goto L23;
        if (isSystemToast == true) goto L23;
        if (isPackageInForeground == true) goto L23;
        if (isXtsApp == false) goto L16;
        if (changeEnabled == false) goto L23;
    L16:
        if (changeEnabled == true) goto L20;
        if (getSmtEx().checkCallerIsSystemApp(uid) == true) goto L23;
    L20:
        if (this.mSmtEx.isAssistant(uid) == true) goto L23;
        return true;
    L23:
        return false;
    L5:
        if (packages.length <= 0) goto L9;
        if (Utils.isXtsPkg(packages[0]) == false) goto L9;
        isXtsApp = true;
        goto L10
    }

    private void handleRankingReconsideration(Message message) {
        if ((message.obj instanceof RankingReconsideration) == true) goto L5;
        return;
    L5:
        RankingReconsideration recon = (RankingReconsideration) message.obj;
        recon.run();
        Object r4 = this.mNotificationLock;
        monitor-enter(r4);
        NotificationRecord record = this.mNotificationsByKey.get(recon.getKey());     // Catch: Throwable -> L48
        if (record != null) goto L13;
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L13:
        int indexBefore = findNotificationRecordIndexLocked(record);     // Catch: Throwable -> L48
        boolean interceptBefore = record.isIntercepted();     // Catch: Throwable -> L48
        int visibilityBefore = record.getPackageVisibilityOverride();     // Catch: Throwable -> L48
        boolean interruptiveBefore = record.isInterruptive();     // Catch: Throwable -> L48
        recon.applyChangesLocked(record);     // Catch: Throwable -> L48
        applyZenModeLocked(record);     // Catch: Throwable -> L48
        this.mRankingHelper.sort(this.mNotificationList);     // Catch: Throwable -> L48
        boolean changed = false;
        if (indexBefore == findNotificationRecordIndexLocked(record)) goto L16;
        boolean indexChanged = true;
    L18:
        if (interceptBefore == record.isIntercepted()) goto L20;
        boolean interceptChanged = true;
    L22:
        if (visibilityBefore == record.getPackageVisibilityOverride()) goto L24;
        boolean visibilityChanged = true;
    L26:
        if (record.canBubble() == true) goto L28;
    L30:
        boolean interruptiveChanged = false;
    L32:
        if (indexChanged == true) goto L36;
        if (interceptChanged == true) goto L36;
        if (visibilityChanged == true) goto L36;
        if (interruptiveChanged == true) goto L36;
    L37:
        if (interceptBefore == false) goto L50;
        if (record.isIntercepted() == true) goto L50;
        if (record.isNewEnoughForAlerting(System.currentTimeMillis()) == false) goto L50;
        NotificationAttentionHelper r2 = this.mAttentionHelper;     // Catch: Throwable -> L44
        ManagedServices.UserProfiles r15 = this.mUserProfiles;     // Catch: Throwable -> L44
        int indexBefore2 = record.getUserId();     // Catch: Throwable -> L44
        r2.buzzBeepBlinkLocked(record, new NotificationAttentionHelper.Signals(r15.isCurrentProfile(indexBefore2), this.mListenerHints));     // Catch: Throwable -> L44
        ZenLog.traceAlertOnUpdatedIntercept(record);     // Catch: Throwable -> L44
    L50:
        monitor-exit(r4);     // Catch: Throwable -> L44
        if (changed == false) goto L60;
        this.mHandler.scheduleSendRankingUpdate();
        return;
    L60:
        return;
    L36:
        changed = true;
        goto L37
    L28:
        if (interruptiveBefore == record.isInterruptive()) goto L30;
        interruptiveChanged = true;
        goto L32
    L24:
        visibilityChanged = false;
        goto L26
    L20:
        interceptChanged = false;
        goto L22
    L16:
        indexChanged = false;
    L11:
        th = th;
    L54:
        monitor-exit(r4);     // Catch: Throwable -> L44
        throw th;
    L48:
        th = th;
    L44:
        th = th;
        goto L54
    }

    void handleRankingSort() {
        if (this.mRankingHelper != null) goto L5;
        return;
    L5:
        Object r2 = this.mNotificationLock;
        monitor-enter(r2);
        int N = this.mNotificationList.size();     // Catch: Throwable -> L10
        ArrayMap<String, NotificationRecordExtractorData> extractorDataBefore = new ArrayMap(N);     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= N) goto L12;
        NotificationRecord r = this.mNotificationList.get(i);     // Catch: Throwable -> L10
        NotificationRecordExtractorData extractorData = new NotificationRecordExtractorData(i, r.getPackageVisibilityOverride(), r.canShowBadge(), r.canBubble(), r.getNotification().isBubbleNotification(), r.getChannel(), r.getGroupKey(), r.getPeopleOverride(), r.getSnoozeCriteria(), Integer.valueOf(r.getUserSentiment()), Integer.valueOf(r.getSuppressedVisualEffects()), r.getSystemGeneratedSmartActions(), r.getSmartReplies(), r.getImportance(), r.getRankingScore(), r.isConversation(), r.getProposedImportance(), r.hasSensitiveContent(), r.getSummarization());     // Catch: Throwable -> L10
        extractorDataBefore.put(r.getKey(), extractorData);     // Catch: Throwable -> L10
        this.mRankingHelper.extractSignals(r);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mRankingHelper.sort(this.mNotificationList);     // Catch: Throwable -> L10
        int i2 = 0;
    L13:
        if (i2 >= N) goto L28;
        NotificationRecord r3 = this.mNotificationList.get(i2);     // Catch: Throwable -> L10
        if (extractorDataBefore.containsKey(r3.getKey()) == true) goto L18;
    L26:
        i2 = i2 + 1;     // Catch: Throwable -> L10
        goto L13
    L18:
        if (extractorDataBefore.get(r3.getKey()).hasDiffForRankingLocked(r3, i2) == false) goto L21;
        this.mHandler.scheduleSendRankingUpdate();     // Catch: Throwable -> L10
    L21:
        if (r3.hasPendingLogUpdate() == false) goto L26;
        NotificationRecordExtractorData prevData = extractorDataBefore.get(r3.getKey());     // Catch: Throwable -> L10
        if (prevData.hasDiffForLoggingLocked(r3, i2) == false) goto L25;
        this.mNotificationRecordLogger.logNotificationAdjusted(r3, i2, 0, getGroupInstanceId(r3.getSbn().getGroupKey()));     // Catch: Throwable -> L10
    L25:
        r3.setPendingLogUpdate(false);     // Catch: Throwable -> L10
        goto L26
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void recordCallerLocked(NotificationRecord record) {
        if (this.mZenModeHelper.isCall(record) == false) goto L6;
        this.mZenModeHelper.recordCaller(record);
        return;
    }

    protected void applyZenModeLocked(NotificationRecord record) {
        record.setIntercepted(this.mZenModeHelper.shouldIntercept(record));
        if (record.isIntercepted() == false) goto L5;
        record.setSuppressedVisualEffects(this.mZenModeHelper.getConsolidatedNotificationPolicy().suppressedVisualEffects);
        return;
    L5:
        record.setSuppressedVisualEffects(0);
    }

    private int findNotificationRecordIndexLocked(NotificationRecord target) {
        return this.mRankingHelper.indexOf(this.mNotificationList, target);
    }

    private void handleSendRankingUpdate() {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mListeners.notifyRankingUpdateLocked(null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void scheduleListenerHintsChanged(int state) {
        this.mHandler.removeMessages(5);
        this.mHandler.obtainMessage(5, state, 0).sendToTarget();
    }

    private void scheduleInterruptionFilterChanged(int listenerInterruptionFilter) {
        this.mHandler.removeMessages(6);
        this.mHandler.obtainMessage(6, listenerInterruptionFilter, 0).sendToTarget();
    }

    private void handleListenerHintsChanged(int hints) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mListeners.notifyListenerHintsChangedLocked(hints);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleListenerInterruptionFilterChanged(int interruptionFilter) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mListeners.notifyInterruptionFilterChanged(interruptionFilter);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void handleOnPackageChanged(boolean removingPackage, int changeUserId, String[] pkgList, int[] uidList) {
        this.mListeners.onPackagesChanged(removingPackage, pkgList, uidList);
        this.mAssistants.onPackagesChanged(removingPackage, pkgList, uidList);
        this.mConditionProviders.onPackagesChanged(removingPackage, pkgList, uidList);
        boolean preferencesChanged = removingPackage | this.mPreferencesHelper.onPackagesChanged(removingPackage, changeUserId, pkgList, uidList);
        if (removingPackage == false) goto L7;
        int size = Math.min(pkgList.length, uidList.length);
        int i = 0;
    L5:
        if (i >= size) goto L7;
        String pkg = pkgList[i];
        int uid = uidList[i];
        int userHandle = UserHandle.getUserId(uid);
        this.mArchive.removePackageNotifications(pkg, userHandle);
        this.mHistoryManager.onPackageRemoved(userHandle, pkg);
        this.mNotificationListenerStats.onPackageRemoved(uid, pkg);
        i = i + 1;
    L7:
        if (preferencesChanged == false) goto L11;
        handleSavePolicyFile();
        return;
    }

    static int clamp(int x, int low, int high) {
        if (x < low) goto L8;
        if (x <= high) goto L7;
        return high;
    L7:
        return x;
    L8:
        return low;
    }

    private boolean removeFromNotificationListsLocked(NotificationRecord r) {
        boolean wasPosted = false;
        NotificationRecord recordInList = findNotificationByListLocked(this.mNotificationList, r.getKey());
        if (recordInList == null) goto L5;
        this.mNotificationList.remove(recordInList);
        this.mNotificationsByKey.remove(recordInList.getSbn().getKey());
        wasPosted = true;
    L5:
        NotificationRecord recordInList2 = findNotificationByListLocked(this.mEnqueuedNotifications, r.getKey());
        if (recordInList2 == null) goto L8;
        this.mEnqueuedNotifications.remove(recordInList2);
        goto L5
    L8:
        return wasPosted;
    }

    protected void cancelNotificationLocked(NotificationRecord r, boolean sendDelete, int reason, boolean wasPosted, String listenerName, long cancellationElapsedTimeMs) {
        cancelNotificationLocked(r, sendDelete, reason, -1, -1, wasPosted, listenerName, cancellationElapsedTimeMs);
    }

    private void cancelNotificationLocked(final NotificationRecord r, final boolean sendDelete, int reason, int rank, int count, boolean wasPosted, String listenerName, long cancellationElapsedTimeMs) {
        String canceledKey = r.getKey();
        this.mTtlHelper.cancelScheduledTimeoutLocked(r);
        recordCallerLocked(r);
        if (r.getStats().getDismissalSurface() != (-1)) goto L5;
        r.recordDismissalSurface(0);
    L5:
        if (sendDelete == false) goto L7;
        sendDeleteIntent(r.getNotification().deleteIntent, r.getSbn().getPackageName());
    L7:
        if (wasPosted == false) goto L22;
        reportNavigationFgsNotificationIfNeeded(r, false);
        if (r.getNotification().getSmallIcon() != null) goto L11;
    L21:
        this.mAttentionHelper.clearEffectsLocked(canceledKey);
        goto L22
    L11:
        if (reason == 18) goto L13;
        r.isCanceled = true;
    L13:
        this.mListeners.notifyRemovedLocked(r, reason, r.getStats());
        this.mHandler.removeCallbacksAndEqualMessages(r.getKey());
        this.mHandler.post(new NotificationManagerService$$ExternalSyntheticLambda9(this, r, sendDelete));
        NotificationRecord groupSummary = this.mSummaryByGroupKey.get(r.getGroupKey());
        if (groupSummary != null) goto L16;
    L20:
        notifyCallNotificationEventListenerOnRemoved(r);
        goto L21
    L16:
        if (GroupHelper.isAggregatedGroup(groupSummary) == true) goto L20;
        if (groupSummary.getKey().equals(canceledKey) == true) goto L20;
        final String summaryKey = groupSummary.getKey();
        this.mHandler.removeCallbacksAndEqualMessages(summaryKey);
        this.mHandler.postDelayed(new NotificationManagerService$$ExternalSyntheticLambda10(this, summaryKey), summaryKey, 3000);
    L22:
        switch(reason) {
            case 2: goto L25;
            case 3: goto L25;
            case 4: goto L26;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L26;
            case 8: goto L24;
            case 9: goto L24;
            case 10: goto L25;
            case 11: goto L25;
            default: goto L26;
        };
    L24:
        this.mUsageStats.registerRemovedByApp(r);
        this.mUsageStatsManagerInternal.reportNotificationRemoved(r.getSbn().getOpPkg(), r.getUser(), cancellationElapsedTimeMs);
        goto L26
    L25:
        this.mUsageStats.registerDismissedByUser(r);
    L26:
        String groupKey = r.getGroupKey();
        NotificationRecord groupSummary2 = this.mSummaryByGroupKey.get(groupKey);
        if (groupSummary2 != null) goto L29;
    L31:
        ArrayMap<String, String> summaries = this.mAutobundledSummaries.get(Integer.valueOf(r.getSbn().getUserId()));
        if (summaries == null) goto L37;
        if (r.getSbn().getKey().equals(summaries.get(groupKey)) == false) goto L37;
        summaries.remove(groupKey);
    L37:
        if (reason == 20) goto L39;
        this.mArchive.record(r.getSbn(), reason);
    L39:
        long now = System.currentTimeMillis();
        LogMaker logMaker = r.getItemLogMaker().setType(5).setSubtype(reason);
        if (rank == (-1)) goto L45;
        if (count == (-1)) goto L45;
        logMaker.addTaggedData(798, Integer.valueOf(rank)).addTaggedData(1395, Integer.valueOf(count));
    L45:
        MetricsLogger.action(logMaker);
        EventLogTags.writeNotificationCanceled(canceledKey, reason, r.getLifespanMs(now), r.getFreshnessMs(now), r.getExposureMs(now), rank, count, listenerName);
        if (wasPosted == false) goto L49;
        this.mNotificationRecordLogger.logNotificationCancelled(r, reason, r.getStats().getDismissalSurface());
        return;
    L49:
        return;
    L29:
        if (groupSummary2.getKey().equals(canceledKey) == false) goto L31;
        this.mSummaryByGroupKey.remove(groupKey);
        goto L31
    }

    private /* synthetic */ void lambda$cancelNotificationLocked$16(NotificationRecord r, boolean sendDelete) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mGroupHelper.onNotificationRemoved(r, this.mNotificationList, sendDelete);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$cancelNotificationLocked$17(String summaryKey) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        NotificationRecord summaryRecord = this.mNotificationsByKey.get(summaryKey);     // Catch: Throwable -> L7
        if (summaryRecord == null) goto L9;
        this.mGroupHelper.onGroupedNotificationRemovedWithDelay(summaryRecord, this.mNotificationList, this.mSummaryByGroupKey);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void sendDeleteIntent(PendingIntent deleteIntent, String fromPkg) {
        if (deleteIntent == null) goto L10;
        ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).clearPendingIntentAllowBgActivityStarts(deleteIntent.getTarget(), ALLOWLIST_TOKEN);     // Catch: PendingIntent.CanceledException -> L5
        deleteIntent.send();     // Catch: PendingIntent.CanceledException -> L5
        return;
    L5:
        ex = move-exception;
        Slog.w(TAG, "canceled PendingIntent for " + fromPkg, ex);
        return;
    }

    void updateUriPermissions(NotificationRecord newRecord, NotificationRecord oldRecord, String targetPkg, int targetUserId) {
        updateUriPermissions(newRecord, oldRecord, targetPkg, targetUserId, false);
    }

    void updateUriPermissions(NotificationRecord newRecord, NotificationRecord oldRecord, String targetPkg, int targetUserId, boolean onlyRevokeCurrentTarget) {
        if (newRecord == null) goto L4;
        String key = newRecord.getKey();
    L6:
        if (DBG == false) goto L8;
        Slog.d(TAG, key + ": updating permissions");
    L8:
        ArraySet<Uri> oldUris = null;
        if (newRecord == null) goto L11;
        ArraySet<Uri> newUris = newRecord.getGrantableUris();
    L12:
        if (oldRecord == null) goto L14;
        oldUris = oldRecord.getGrantableUris();
    L14:
        if (newUris != null) goto L17;
        if (oldUris != null) goto L17;
        return;
    L17:
        IBinder permissionOwner = null;
        if (newRecord == null) goto L21;
        if (0 != 0) goto L21;
        permissionOwner = newRecord.permissionOwner;
    L21:
        if (oldRecord == null) goto L24;
        if (permissionOwner != null) goto L24;
        permissionOwner = oldRecord.permissionOwner;
    L24:
        if (newUris == null) goto L30;
        if (permissionOwner != null) goto L30;
        if (DBG == false) goto L29;
        Slog.d(TAG, key + ": creating owner");
    L29:
        permissionOwner = this.mUgmInternal.newUriPermissionOwner("NOTIF:" + key);
    L30:
        if (newUris != null) goto L34;
        if (permissionOwner == null) goto L34;
        if (onlyRevokeCurrentTarget == true) goto L34;
        destroyPermissionOwner(permissionOwner, UserHandle.getUserId(oldRecord.getUid()), key);
        IBinder permissionOwner2 = null;
    L35:
        if (newUris == null) goto L49;
        if (permissionOwner2 == null) goto L49;
        int i = 0;
    L39:
        if (i >= newUris.size()) goto L49;
        Uri uri = newUris.valueAt(i);
        if (oldUris == null) goto L45;
        if (oldUris.contains(uri) == false) goto L45;
    L48:
        i = i + 1;
    L45:
        if (DBG == false) goto L47;
        Slog.d(TAG, key + ": granting " + uri);
    L47:
        grantUriPermission(permissionOwner2, uri, newRecord.getUid(), targetPkg, targetUserId);
    L49:
        if (oldUris == null) goto L65;
        if (permissionOwner2 == null) goto L65;
        int i2 = 0;
    L53:
        if (i2 >= oldUris.size()) goto L65;
        Uri uri2 = oldUris.valueAt(i2);
        if (newUris == null) goto L59;
        if (newUris.contains(uri2) == false) goto L59;
    L64:
        i2 = i2 + 1;
    L59:
        if (DBG == false) goto L61;
        Slog.d(TAG, key + ": revoking " + uri2);
    L61:
        if (onlyRevokeCurrentTarget == false) goto L63;
        revokeUriPermission(permissionOwner2, uri2, UserHandle.getUserId(oldRecord.getUid()), targetPkg, targetUserId);
        goto L64
    L63:
        revokeUriPermission(permissionOwner2, uri2, UserHandle.getUserId(oldRecord.getUid()), null, -1);
    L65:
        if (newRecord == null) goto L75;
        newRecord.permissionOwner = permissionOwner2;
        return;
    L75:
        return;
    L34:
        permissionOwner2 = permissionOwner;
        goto L35
    L11:
        newUris = null;
        goto L12
    L4:
        key = oldRecord.getKey();
        goto L6
    }

    private void grantUriPermission(IBinder owner, Uri uri, int sourceUid, String targetPkg, int targetUserId) {
        if (uri != null) goto L4;
        return;
    L4:
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L27;
        long ident = Binder.clearCallingIdentity();
        this.mUgm.grantUriPermissionFromOwner(owner, sourceUid, targetPkg, ContentProvider.getUriWithoutUserId(uri), 1, ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(sourceUid)), targetUserId);     // Catch: Throwable -> L10 SecurityException -> L12 RemoteException -> L14
    L23:
        goto L9
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L9:
        Binder.restoreCallingIdentity(ident);
        return;
    L17:
        Slog.e(TAG, "Cannot grant uri access; " + sourceUid + " does not own " + uri);     // Catch: Throwable -> L10
        goto L23
    }

    private void revokeUriPermission(IBinder owner, Uri uri, int sourceUserId, String targetPkg, int targetUserId) {
        if (uri == null) goto L19;
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L24;
        int userId = ContentProvider.getUserIdFromUri(uri, sourceUserId);
        long ident = Binder.clearCallingIdentity();
        this.mUgmInternal.revokeUriPermissionFromOwner(owner, ContentProvider.getUriWithoutUserId(uri), 1, userId, targetPkg, targetUserId);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        Throwable r11 = th;
    L16:
        Binder.restoreCallingIdentity(ident);
        throw r11;
    L14:
        th = move-exception;
        r11 = th;
        goto L16
    L24:
        return;
    }

    private void destroyPermissionOwner(IBinder owner, int userId, String logKey) {
        long ident = Binder.clearCallingIdentity();
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        if (DBG == false) goto L8;
        Slog.d(TAG, logKey + ": destroying owner");     // Catch: Throwable -> L6
    L8:
        this.mUgmInternal.revokeUriPermissionFromOwner(owner, null, -1, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
    }

    void cancelNotification(int callingUid, int callingPid, String pkg, String tag, int id, int mustHaveFlags, int mustNotHaveFlags, boolean sendDelete, int userId, int reason, ManagedServices.ManagedServiceInfo listener) {
        cancelNotification(callingUid, callingPid, pkg, tag, id, mustHaveFlags, mustNotHaveFlags, sendDelete, userId, reason, -1, -1, listener);
    }

    void cancelNotification(int callingUid, int callingPid, String pkg, String tag, int id, int mustHaveFlags, int mustNotHaveFlags, boolean sendDelete, int userId, int reason, int rank, int count, ManagedServices.ManagedServiceInfo listener) {
        this.mHandler.scheduleCancelNotification(new CancelNotificationRunnable(this, callingUid, callingPid, pkg, tag, id, mustHaveFlags, mustNotHaveFlags, sendDelete, userId, reason, rank, count, listener, SystemClock.elapsedRealtime()), 0);
    }

    private static boolean notificationMatchesUserId(NotificationRecord r, int userId, boolean isAutogroupSummary) {
        if (isAutogroupSummary == false) goto L9;
        if (r.getUserId() == userId) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (userId == (-1)) goto L15;
        if (r.getUserId() == (-1)) goto L15;
        if (r.getUserId() == userId) goto L15;
        return false;
    L15:
        return true;
    }

    private boolean notificationMatchesCurrentProfiles(NotificationRecord r, int userId) {
        if (notificationMatchesUserId(r, userId, false) == false) goto L5;
    L6:
        return true;
    L5:
        if (this.mUserProfiles.isCurrentProfile(r.getUserId()) == true) goto L6;
        return false;
    }

    void cancelAllNotificationsInt(int callingUid, int callingPid, String pkg, String channelId, int mustHaveFlags, int mustNotHaveFlags, int userId, int reason) {
        long cancellationElapsedTimeMs = SystemClock.elapsedRealtime();
        this.mHandler.post(new AnonymousClass16(this, callingUid, callingPid, pkg, userId, mustHaveFlags, mustNotHaveFlags, reason, channelId, cancellationElapsedTimeMs));
    }

    private static boolean isChildOfCurrentGroupChecker(NotificationRecord childRecord, int userId, String pkg, String groupKey) {
        if (childRecord.getUser().getIdentifier() == userId) goto L5;
    L13:
        return false;
    L5:
        if (childRecord.getSbn().getPackageName().equals(pkg) == false) goto L13;
        if (childRecord.getSbn().isGroup() == false) goto L13;
        if (childRecord.getNotification().isGroupSummary() == true) goto L13;
        if (TextUtils.equals(groupKey, childRecord.getGroupKey()) == false) goto L13;
        return true;
    }

    private static boolean wasChildOfForceRegroupedGroupChecker(NotificationRecord childRecord, int userId, String pkg, String groupKey) {
        if (childRecord.getUser().getIdentifier() == userId) goto L5;
    L13:
        return false;
    L5:
        if (childRecord.getSbn().getPackageName().equals(pkg) == false) goto L13;
        if (childRecord.getSbn().isGroup() == false) goto L13;
        if (childRecord.getNotification().isGroupSummary() == true) goto L13;
        if (TextUtils.equals(groupKey, childRecord.getOriginalGroupKey()) == false) goto L13;
        return true;
    }

    private void cancelAllNotificationsByListLocked(ArrayList<NotificationRecord> notificationList, String pkg, boolean nullPkgIndicatesUserSwitch, String channelId, FlagChecker flagChecker, boolean includeCurrentProfiles, int userId, boolean sendDelete, int reason, String listenerName, boolean wasPosted, long cancellationElapsedTimeMs) {
        Set<String> childNotifications = null;
        int i = notificationList.size() - 1;
    L3:
        if (i < 0) goto L38;
        NotificationRecord r = notificationList.get(i);
        if (includeCurrentProfiles == false) goto L10;
        if (notificationMatchesCurrentProfiles(r, userId) == false) goto L36;
    L12:
        if (nullPkgIndicatesUserSwitch == false) goto L18;
        if (pkg != null) goto L18;
        if (r.getUserId() == (-1)) goto L36;
    L18:
        if (flagChecker.apply(r.getFlags()) == false) goto L36;
        if (pkg != null) goto L22;
    L24:
        if (channelId == null) goto L29;
        if (channelId.equals(r.getChannel().getId()) == false) goto L36;
    L29:
        if (r.getSbn().isGroup() == true) goto L31;
    L35:
        notificationList.remove(i);
        this.mNotificationsByKey.remove(r.getKey());
        r.recordDismissalSentiment(1);
        cancelNotificationLocked(r, sendDelete, reason, wasPosted, listenerName, cancellationElapsedTimeMs);
        goto L36
    L31:
        if (r.getNotification().isGroupChild() == false) goto L35;
        if (childNotifications != null) goto L34;
        childNotifications = new HashSet();
    L34:
        childNotifications.add(r.getKey());
        goto L36
    L22:
        if (r.getSbn().getPackageName().equals(pkg) == true) goto L24;
    L36:
        i = i - 1;
        goto L3
    L10:
        if (notificationMatchesUserId(r, userId, false) == true) goto L12;
    L38:
        if (childNotifications == null) goto L60;
        int M = notificationList.size();
        int i2 = M - 1;
    L40:
        if (i2 < 0) goto L46;
        NotificationRecord r2 = notificationList.get(i2);
        if (childNotifications.contains(r2.getKey()) == false) goto L45;
        notificationList.remove(i2);
        this.mNotificationsByKey.remove(r2.getKey());
        r2.recordDismissalSentiment(1);
        cancelNotificationLocked(r2, sendDelete, reason, wasPosted, listenerName, cancellationElapsedTimeMs);
    L45:
        i2 = i2 - 1;
        goto L40
    L46:
        this.mAttentionHelper.updateLightsLocked();
        return;
    }

    void snoozeNotificationInt(int callingUid, INotificationListener token, String key, long duration, String snoozeCriterionId) {
        Object r6 = this.mNotificationLock;
        monitor-enter(r6);
        ManagedServices.ManagedServiceInfo listener = this.mListeners.checkServiceTokenLocked(token);     // Catch: Throwable -> L10
        if (listener != null) goto L12;
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L12:
        String packageName = listener.component.getPackageName();     // Catch: Throwable -> L10
        String listenerName = listener.component.toShortString();     // Catch: Throwable -> L10
        if (duration > 0) goto L15;
        if (snoozeCriterionId != null) goto L15;
    L16:
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L15:
        if (key == null) goto L16;
        NotificationRecord r = findInCurrentAndSnoozedNotificationByKeyLocked(key);     // Catch: Throwable -> L10
        if (r != null) goto L23;
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L23:
        if (listener.enabledAndUserMatches(r.getSbn().getNormalizedUserId()) == true) goto L26;
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L26:
        long notificationUpdateTimeMs = r.getUpdateTimeMs();     // Catch: Throwable -> L10
        if (DBG == false) goto L29;
        Slog.d(TAG, String.format("snooze event(%s, %d, %s, %s)", new Object[]{key, Long.valueOf(duration), snoozeCriterionId, listenerName}));     // Catch: Throwable -> L10
    L29:
        this.mHandler.post(new SnoozeNotificationRunnable(this, key, duration, snoozeCriterionId));     // Catch: Throwable -> L10
        monitor-exit(r6);     // Catch: Throwable -> L10
        if (isNotificationRecent(notificationUpdateTimeMs) == false) goto L35;
        this.mAppOps.noteOpNoThrow(142, callingUid, packageName, null, null);
        return;
    L35:
        return;
    L10:
        th = th;
    L38:
        monitor-exit(r6);     // Catch: Throwable -> L10
        throw th;
    L36:
        th = th;
        goto L38
    }

    void unsnoozeNotificationInt(String key, ManagedServices.ManagedServiceInfo listener, boolean muteOnReturn) {
        if (listener != null) goto L4;
        String listenerName = null;
    L6:
        if (DBG == false) goto L8;
        Slog.d(TAG, String.format("unsnooze event(%s, %s)", new Object[]{key, listenerName}));
    L8:
        this.mSnoozeHelper.repost(key, muteOnReturn);
        handleSavePolicyFile();
        return;
    L4:
        listenerName = listener.component.toShortString();
        goto L6
    }

    private boolean isNotificationRecent(long notificationUpdateTimeMs) {
        if ((System.currentTimeMillis() - notificationUpdateTimeMs) >= MIN_PACKAGE_OVERRATE_LOG_INTERVAL) goto L5;
        return true;
    L5:
        return false;
    }

    void cancelAllLocked(int callingUid, int callingPid, int userId, int reason, ManagedServices.ManagedServiceInfo listener, boolean includeCurrentProfiles, int mustNotHaveFlags) {
        long cancellationElapsedTimeMs = SystemClock.elapsedRealtime();
        this.mHandler.post(new AnonymousClass17(this, listener, callingUid, callingPid, userId, reason, mustNotHaveFlags, includeCurrentProfiles, cancellationElapsedTimeMs));
    }

    private void cancelGroupChildrenLocked(int userId, String pkg, int callingUid, int callingPid, String listenerName, boolean sendDelete, FlagChecker flagChecker, GroupChildChecker groupChildChecker, String groupKey, int reason, long cancellationElapsedTimeMs) {
        if (pkg == null) goto L4;
        cancelGroupChildrenByListLocked(this.mNotificationList, userId, pkg, callingUid, callingPid, listenerName, sendDelete, true, flagChecker, groupChildChecker, groupKey, reason, cancellationElapsedTimeMs);
        cancelGroupChildrenByListLocked(this.mEnqueuedNotifications, userId, pkg, callingUid, callingPid, listenerName, sendDelete, false, flagChecker, groupChildChecker, groupKey, reason, cancellationElapsedTimeMs);
        return;
    L4:
        if (DBG == false) goto L9;
        Slog.e(TAG, "No package for group summary");
        return;
    }

    private void cancelGroupChildrenByListLocked(ArrayList<NotificationRecord> notificationList, int userId, String pkg, int callingUid, int callingPid, String listenerName, boolean sendDelete, boolean wasPosted, FlagChecker flagChecker, GroupChildChecker grouChildChecker, String groupKey, int reason, long cancellationElapsedTimeMs) {
        int i = notificationList.size() - 1;
    L3:
        if (i < 0) goto L18;
        NotificationRecord childR = notificationList.get(i);
        StatusBarNotification childSbn = childR.getSbn();
        if (grouChildChecker.apply(childR, userId, pkg, groupKey) == false) goto L16;
        if (flagChecker == null) goto L10;
        if (flagChecker.apply(childR.getFlags()) == false) goto L16;
    L10:
        if (childR.getChannel().isImportantConversation() == false) goto L15;
        if (reason == 2) goto L16;
    L15:
        EventLogTags.writeNotificationCancel(callingUid, callingPid, pkg, childSbn.getId(), childSbn.getTag(), userId, 0, 0, 12, listenerName);
        notificationList.remove(i);
        this.mNotificationsByKey.remove(childR.getKey());
        cancelNotificationLocked(childR, sendDelete, 12, wasPosted, listenerName, cancellationElapsedTimeMs);
    L16:
        i = i - 1;
        goto L3
    }

    List<NotificationRecord> findCurrentAndSnoozedGroupNotificationsLocked(String pkg, String groupKey, int userId) {
        List<NotificationRecord> records = this.mSnoozeHelper.getNotifications(pkg, groupKey, Integer.valueOf(userId));
        records.addAll(findGroupNotificationsLocked(pkg, groupKey, userId));
        return records;
    }

    List<NotificationRecord> findGroupNotificationsLocked(String pkg, String groupKey, int userId) {
        List<NotificationRecord> records = new ArrayList();
        records.addAll(findGroupNotificationByListLocked(this.mNotificationList, pkg, groupKey, userId));
        records.addAll(findGroupNotificationByListLocked(this.mEnqueuedNotifications, pkg, groupKey, userId));
        return records;
    }

    private NotificationRecord findInCurrentAndSnoozedNotificationByKeyLocked(String key) {
        NotificationRecord r = findNotificationByKeyLocked(key);
        if (r == null) goto L5;
        return r;
    L5:
        return this.mSnoozeHelper.getNotification(key);
    }

    private List<NotificationRecord> findAppNotificationByListLocked(ArrayList<NotificationRecord> list, String pkg, int userId) {
        List<NotificationRecord> records = new ArrayList();
        int len = list.size();
        int i = 0;
    L3:
        if (i >= len) goto L11;
        NotificationRecord r = list.get(i);
        if (notificationMatchesUserId(r, userId, false) == false) goto L9;
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L9;
        records.add(r);
    L9:
        i = i + 1;
        goto L3
    L11:
        return records;
    }

    private List<NotificationRecord> findGroupNotificationByListLocked(ArrayList<NotificationRecord> list, String pkg, String groupKey, int userId) {
        List<NotificationRecord> records = new ArrayList();
        int len = list.size();
        int i = 0;
    L3:
        if (i >= len) goto L13;
        NotificationRecord r = list.get(i);
        if (notificationMatchesUserId(r, userId, false) == false) goto L11;
        if (r.getGroupKey().equals(groupKey) == false) goto L11;
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L11;
        records.add(r);
    L11:
        i = i + 1;
        goto L3
    L13:
        return records;
    }

    private NotificationRecord findNotificationByKeyLocked(String key) {
        NotificationRecord r = findNotificationByListLocked(this.mNotificationList, key);
        if (r == null) goto L5;
        return r;
    L5:
        NotificationRecord r2 = findNotificationByListLocked(this.mEnqueuedNotifications, key);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return null;
    }

    NotificationRecord findNotificationLocked(String pkg, String tag, int id, int userId) {
        NotificationRecord r = findNotificationByListLocked(this.mNotificationList, pkg, tag, id, userId);
        if (r == null) goto L5;
        return r;
    L5:
        NotificationRecord r2 = findNotificationByListLocked(this.mEnqueuedNotifications, pkg, tag, id, userId);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return null;
    }

    private static NotificationRecord findNotificationByListLocked(ArrayList<NotificationRecord> list, String pkg, String tag, int id, int userId) {
        int len = list.size();
        int i = 0;
    L3:
        if (i >= len) goto L18;
        NotificationRecord r = list.get(i);
        if ((r.getFlags() & UsbTerminalTypes.TERMINAL_EMBED_UNDEFINED) == 0) goto L7;
        boolean r3 = true;
    L9:
        if (notificationMatchesUserId(r, userId, r3) == false) goto L17;
        if (r.getSbn().getId() != id) goto L17;
        if (TextUtils.equals(r.getSbn().getTag(), tag) == false) goto L17;
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L17;
        return r;
    L17:
        i = i + 1;
        goto L3
    L7:
        r3 = false;
        goto L9
    L18:
        return null;
    }

    private static List<NotificationRecord> findNotificationsByListLocked(ArrayList<NotificationRecord> list, String pkg, String tag, int id, int userId) {
        List<NotificationRecord> matching = new ArrayList();
        int len = list.size();
        int i = 0;
    L3:
        if (i >= len) goto L15;
        NotificationRecord r = list.get(i);
        if (notificationMatchesUserId(r, userId, false) == false) goto L13;
        if (r.getSbn().getId() != id) goto L13;
        if (TextUtils.equals(r.getSbn().getTag(), tag) == false) goto L13;
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L13;
        matching.add(r);
    L13:
        i = i + 1;
        goto L3
    L15:
        return matching;
    }

    private static NotificationRecord findNotificationByListLocked(ArrayList<NotificationRecord> list, String key) {
        int N = list.size();
        int i = 0;
    L3:
        if (i >= N) goto L9;
        if (key.equals(list.get(i).getKey()) == true) goto L7;
        i = i + 1;
        goto L3
    L7:
        return list.get(i);
    L9:
        return null;
    }

    int indexOfNotificationLocked(String key) {
        int N = this.mNotificationList.size();
        int i = 0;
    L3:
        if (i >= N) goto L8;
        if (key.equals(this.mNotificationList.get(i).getKey()) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    private void hideNotificationsForPackages(String[] pkgs, int[] uidList) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        Set<Integer> uidSet = (Set) Arrays.stream(uidList).boxed().collect(Collectors.toSet());     // Catch: Throwable -> L11
        List<String> pkgList = Arrays.asList(pkgs);     // Catch: Throwable -> L11
        List<NotificationRecord> changedNotifications = new ArrayList();     // Catch: Throwable -> L11
        int numNotifications = this.mNotificationList.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= numNotifications) goto L14;
        NotificationRecord rec = this.mNotificationList.get(i);     // Catch: Throwable -> L11
        if (pkgList.contains(rec.getSbn().getPackageName()) == false) goto L13;
        if (uidSet.contains(Integer.valueOf(rec.getUid())) == false) goto L13;
        rec.setHidden(true);     // Catch: Throwable -> L11
        changedNotifications.add(rec);     // Catch: Throwable -> L11
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L14:
        this.mListeners.notifyHiddenLocked(changedNotifications);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void unhideNotificationsForPackages(String[] pkgs, int[] uidList) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        Set<Integer> uidSet = (Set) Arrays.stream(uidList).boxed().collect(Collectors.toSet());     // Catch: Throwable -> L11
        List<String> pkgList = Arrays.asList(pkgs);     // Catch: Throwable -> L11
        List<NotificationRecord> changedNotifications = new ArrayList();     // Catch: Throwable -> L11
        int numNotifications = this.mNotificationList.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= numNotifications) goto L14;
        NotificationRecord rec = this.mNotificationList.get(i);     // Catch: Throwable -> L11
        if (pkgList.contains(rec.getSbn().getPackageName()) == false) goto L13;
        if (uidSet.contains(Integer.valueOf(rec.getUid())) == false) goto L13;
        rec.setHidden(false);     // Catch: Throwable -> L11
        changedNotifications.add(rec);     // Catch: Throwable -> L11
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L14:
        this.mListeners.notifyUnhiddenLocked(changedNotifications);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void cancelNotificationsWhenEnterLockDownMode(int userId) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        int numNotifications = this.mNotificationList.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= numNotifications) goto L14;
        NotificationRecord rec = this.mNotificationList.get(i);     // Catch: Throwable -> L11
        if (rec.getUser().getIdentifier() != userId) goto L10;
        this.mListeners.notifyRemovedLocked(rec, 23, rec.getStats());     // Catch: Throwable -> L11
    L10:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void postNotificationsWhenExitLockDownMode(int userId) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        int numNotifications = this.mNotificationList.size();     // Catch: Throwable -> L11
        long delay = 0;
        int i = 0;
    L5:
        if (i >= numNotifications) goto L14;
        final NotificationRecord rec = this.mNotificationList.get(i);     // Catch: Throwable -> L11
        if (rec.getUser().getIdentifier() != userId) goto L10;
        this.mHandler.postDelayed(new NotificationManagerService$$ExternalSyntheticLambda6(this, rec), delay);     // Catch: Throwable -> L11
        delay = delay + 20;     // Catch: Throwable -> L11
    L10:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$postNotificationsWhenExitLockDownMode$18(NotificationRecord rec) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        this.mListeners.notifyPostedLocked(rec, rec);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected boolean isCallingUidSystem() {
        int uid = Binder.getCallingUid();
        if (uid != 1000) goto L5;
        return true;
    L5:
        return false;
    }

    protected boolean isCallingAppIdSystem() {
        int uid = Binder.getCallingUid();
        int appid = UserHandle.getAppId(uid);
        if (appid != 1000) goto L5;
        return true;
    L5:
        return false;
    }

    protected boolean isUidSystemOrPhone(int uid) {
        int appid = UserHandle.getAppId(uid);
        if (appid != 1000) goto L5;
    L9:
        return true;
    L5:
        if (appid == 1001) goto L9;
        if (uid == 0) goto L9;
        return false;
    }

    protected boolean isCallerSystemOrPhone() {
        return isUidSystemOrPhone(Binder.getCallingUid());
    }

    protected boolean isCallerSystemOrSystemUi() {
        if (isCallerSystemOrPhone() == false) goto L6;
        return true;
    L6:
        if (getContext().checkCallingPermission("android.permission.STATUS_BAR_SERVICE") == 0) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isCallerSystemOrSystemUiOrShell() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L8;
        if (callingUid != 0) goto L7;
        return true;
    L7:
        return isCallerSystemOrSystemUi();
    L8:
        return true;
    }

    private void checkCallerIsSystemOrShell() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L8;
        if (callingUid == 0) goto L9;
        checkCallerIsSystem();
        return;
    L9:
        return;
    }

    private void checkCallerIsSystem() {
        if (isCallerSystemOrPhone() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Disallowed call for uid " + Binder.getCallingUid());
    }

    private void checkCallerIsSystemOrSystemUiOrShell() {
        checkCallerIsSystemOrSystemUiOrShell(null);
    }

    private void checkCallerIsSystemOrSystemUiOrShell(String message) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L11;
        if (callingUid != 0) goto L7;
        return;
    L7:
        if (isCallerSystemOrPhone() == false) goto L9;
        return;
    L9:
        getContext().enforceCallingPermission("android.permission.STATUS_BAR_SERVICE", message);
        return;
    }

    protected void checkCallerIsSystemOrSameApp(String pkg) {
        if (isCallerSystemOrPhone() == false) goto L5;
        return;
    L5:
        checkCallerIsSameApp(pkg);
    }

    private boolean isCallerAndroid(String callingPkg, int uid) {
        if (isUidSystemOrPhone(uid) == false) goto L8;
        if (callingPkg == null) goto L8;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(callingPkg) == false) goto L8;
        return true;
    L8:
        return false;
    }

    private void checkRestrictedCategories(Notification notification) {
        if (this.mPackageManager.hasSystemFeature("android.hardware.type.automotive", 0) == true) goto L11;
        return;
    L11:
        if ("car_emergency".equals(notification.category) == false) goto L13;
    L16:
        getContext().enforceCallingPermission("android.permission.SEND_CATEGORY_CAR_NOTIFICATIONS", String.format("Notification category %s restricted", new Object[]{notification.category}));
        return;
    L13:
        if ("car_warning".equals(notification.category) == true) goto L16;
        if ("car_information".equals(notification.category) == true) goto L16;
        return;
    L8:
        if (DBG == false) goto L11;
        Slog.e(TAG, "Unable to confirm if it's safe to skip category restrictions check thus the check will be done anyway");
        goto L11
    }

    boolean isCallerInstantApp(int callingUid, int userId) {
        if (isUidSystemOrPhone(callingUid) == false) goto L6;
        return false;
    L6:
        if (userId != (-1)) goto L22;
        userId = 0;
    L22:
        String[] pkgs = this.mPackageManager.getPackagesForUid(callingUid);     // Catch: RemoteException -> L14
        if (pkgs == null) goto L19;
        String pkg = pkgs[0];     // Catch: RemoteException -> L14
        this.mAppOps.checkPackage(callingUid, pkg);     // Catch: RemoteException -> L14
        ApplicationInfo ai = this.mPackageManager.getApplicationInfo(pkg, 0, userId);     // Catch: RemoteException -> L14
        if (ai == null) goto L17;
        return ai.isInstantApp();
    L17:
        throw new SecurityException("Unknown package " + pkg);     // Catch: RemoteException -> L14
    L19:
        throw new SecurityException("Unknown uid " + callingUid);     // Catch: RemoteException -> L14
    L14:
        re = move-exception;
        throw new SecurityException("Unknown uid " + callingUid, re);
    }

    private void checkCallerIsSameApp(String pkg) {
        checkCallerIsSameApp(pkg, Binder.getCallingUid(), UserHandle.getCallingUserId());
    }

    private void checkCallerIsSameApp(String pkg, int uid, int userId) {
        if (uid != 0) goto L7;
        if (ROOT_PKG.equals(pkg) == false) goto L7;
        return;
    L7:
        if (UserHandle.isSameApp(uid, this.mPackageManagerInternal.getPackageUid(pkg, 0, userId)) == false) goto L10;
        return;
    L10:
        throw new SecurityException("Package " + pkg + " is not owned by uid " + uid);
    }

    private boolean isCallerSameApp(String pkg, int uid, int userId) {
        checkCallerIsSameApp(pkg, uid, userId);     // Catch: SecurityException -> L5
        return true;
    L6:
        return false;
    }

    private static String callStateToString(int state) {
        switch(state) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "CALL_STATE_OFFHOOK";
    L7:
        return "CALL_STATE_RINGING";
    L9:
        return "CALL_STATE_IDLE";
    L4:
        return "CALL_STATE_UNKNOWN_" + state;
    }

    NotificationRankingUpdate makeRankingUpdateLocked(ManagedServices.ManagedServiceInfo info) {
        int N = this.mNotificationList.size();
        ArrayList<NotificationListenerService.Ranking> rankings = new ArrayList();
        int i = 0;
    L4:
        if (i >= N) goto L34;
        NotificationRecord record = this.mNotificationList.get(i);
        if (isInLockDownMode(record.getUser().getIdentifier()) == true) goto L32;
        if (isVisibleToListener(record.getSbn(), record.getNotificationType(), info) == false) goto L32;
        String key = record.getSbn().getKey();
        NotificationListenerService.Ranking ranking = new NotificationListenerService.Ranking();
        ArrayList<Notification.Action> smartActions = record.getSystemGeneratedSmartActions();
        ArrayList<CharSequence> smartReplies = record.getSmartReplies();
        boolean hasSensitiveContent = record.hasSensitiveContent();
        if (this.mListeners.isUidTrusted(info.uid) == false) goto L14;
    L16:
        ArrayList<Notification.Action> smartActions2 = smartActions;
        ArrayList<CharSequence> smartReplies2 = smartReplies;
    L17:
        int r10 = rankings.size();
        boolean r7 = !record.isIntercepted();
        int r12 = record.getPackageVisibilityOverride();
        int r13 = record.getSuppressedVisualEffects();
        int r14 = record.getImportance();
        CharSequence r15 = record.getImportanceExplanation();
        String r16 = record.getSbn().getOverrideGroupKey();
        NotificationChannel r17 = record.getChannel();
        ArrayList<String> r18 = record.getPeopleOverride();
        ArrayList<SnoozeCriterion> r19 = record.getSnoozeCriteria();
        boolean r20 = record.canShowBadge();
        int r21 = record.getUserSentiment();
        boolean r22 = record.isHidden();
        long r23 = record.getLastAudiblyAlertedMs();
        if (record.getSound() == null) goto L20;
    L23:
        boolean r25 = true;
    L24:
        boolean r28 = record.canBubble();
        boolean r29 = record.isTextChanged();
        boolean r30 = record.isConversation();
        ShortcutInfo r31 = record.getShortcutInfo();
        if (record.getRankingScore() != 0.0f) goto L28;
        int r32 = 0;
    L31:
        ranking.populate(key, r10, r7, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, smartActions2, smartReplies2, r28, r29, r30, r31, r32, record.getNotification().isBubbleNotification(), record.getProposedImportance(), hasSensitiveContent, record.getSummarization());
        rankings.add(ranking);
        goto L32
    L28:
        if (record.getRankingScore() <= 0.0f) goto L30;
        r32 = 1;
        goto L31
    L30:
        r32 = -1;
        goto L31
    L20:
        if (record.getVibration() != null) goto L23;
        r25 = false;
        goto L24
    L14:
        if (this.mListeners.hasSensitiveContent(record) == false) goto L16;
        smartActions2 = null;
        smartReplies2 = null;
    L32:
        i = i + 1;
        goto L4
    L34:
        return new NotificationRankingUpdate((NotificationListenerService.Ranking[]) rankings.toArray(new NotificationListenerService.Ranking[0]));
    }

    boolean isInLockDownMode(int userId) {
        return this.mStrongAuthTracker.isInLockDownMode(userId);
    }

    boolean hasCompanionDevice(ManagedServices.ManagedServiceInfo info) {
        return hasCompanionDevice(info.component.getPackageName(), info.userid, null);
    }

    private boolean hasCompanionDevice(String pkg, int userId, Set<String> withDeviceProfiles) {
        if (this.mCompanionManager != null) goto L6;
        this.mCompanionManager = getCompanionManager();
    L6:
        if (this.mCompanionManager != null) goto L8;
        return false;
    L8:
        long identity = Binder.clearCallingIdentity();
        List<AssociationInfo> associations = this.mCompanionManager.getAssociations(pkg, userId);     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L22 SecurityException -> L24
        Iterator<AssociationInfo> r5 = associations.iterator();     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L22 SecurityException -> L24
    L11:
        if (r5.hasNext() == false) goto L30;
        AssociationInfo association = r5.next();     // Catch: Throwable -> L18 Exception -> L20 RemoteException -> L22 SecurityException -> L24
        if (withDeviceProfiles == null) goto L26;
        if (withDeviceProfiles.contains(association.getDeviceProfile()) == false) goto L11;
    L26:
        Binder.restoreCallingIdentity(identity);
        return true;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L22:
        re = move-exception;
        Slog.e(TAG, "Cannot reach companion device service", re);     // Catch: Throwable -> L18
    L20:
        e = move-exception;
        Slog.e(TAG, "Cannot verify caller pkg=" + pkg + ", userId=" + userId, e);     // Catch: Throwable -> L18
    L30:
        Binder.restoreCallingIdentity(identity);
        return false;
    }

    protected ICompanionDeviceManager getCompanionManager() {
        return ICompanionDeviceManager.Stub.asInterface(ServiceManager.getService("companiondevice"));
    }

    boolean isVisibleToListener(StatusBarNotification sbn, int notificationType, ManagedServices.ManagedServiceInfo listener) {
        if (listener.enabledAndUserMatches(sbn.getUserId()) == true) goto L6;
        return false;
    L6:
        if (isInteractionVisibleToListener(listener, sbn.getUserId()) == true) goto L8;
        return false;
    L8:
        NotificationListenerFilter nls = this.mListeners.getNotificationListenerFilter(listener.mKey);
        if (nls != null) goto L11;
        return true;
    L11:
        if (nls.isTypeAllowed(notificationType) == true) goto L13;
    L14:
        return false;
    L13:
        if (nls.isPackageAllowed(new VersionedPackage(sbn.getPackageName(), sbn.getUid())) == false) goto L14;
        return true;
    }

    boolean isInteractionVisibleToListener(ManagedServices.ManagedServiceInfo info, int userId) {
        boolean isAssistantService = isNotificationAssistant(info.getService());
        if (isAssistantService == true) goto L5;
    L8:
        return true;
    L5:
        if (info.isSameUser(userId) == true) goto L8;
        return false;
    }

    private boolean isNotificationAssistant(IInterface service) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        boolean r1 = this.mAssistants.isServiceTokenValidLocked(service);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isPackageSuspendedForUser(String pkg, int uid) {
        long identity = Binder.clearCallingIdentity();
        int userId = UserHandle.getUserId(uid);
        boolean r3 = this.mPackageManager.isPackageSuspendedForUser(pkg, userId);     // Catch: Throwable -> L6 IllegalArgumentException -> L8 RemoteException -> L10
        Binder.restoreCallingIdentity(identity);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L16:
        throw new SecurityException("Could not talk to package manager service");     // Catch: Throwable -> L6
    L12:
        Binder.restoreCallingIdentity(identity);
        return false;
    }

    boolean canUseManagedServices(String pkg, Integer userId, String requiredPermission) {
        if (requiredPermission == null) goto L13;
        if (this.mPackageManager.checkPermission(requiredPermission, pkg, userId.intValue()) == 0) goto L15;
        return false;
    L15:
        return true;
    L8:
        e = move-exception;
        Slog.e(TAG, "can't talk to pm", e);
        return true;
    L13:
        return true;
    }

    private void notifyListenersPostedAndLogLocked(NotificationRecord r, NotificationRecord old, final PostNotificationTracker tracker, final NotificationRecordLogger.NotificationReported report) {
        final List<Runnable> listenerCalls = this.mListeners.prepareNotifyPostedLocked(r, old, true);
        this.mHandler.post(new NotificationManagerService$$ExternalSyntheticLambda0(this, listenerCalls, tracker, report));
        notifyCallNotificationEventListenerOnPosted(r);
    }

    private /* synthetic */ void lambda$notifyListenersPostedAndLogLocked$19(List listenerCalls, PostNotificationTracker tracker, NotificationRecordLogger.NotificationReported report) {
        Iterator r0 = listenerCalls.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Runnable listenerCall = (Runnable) r0.next();
        listenerCall.run();
        goto L4
    L6:
        long postDurationMillis = tracker.finish();
        if (report == null) goto L11;
        report.post_duration_millis = postDurationMillis;
        this.mNotificationRecordLogger.logNotificationPosted(report);
        return;
    }

    private void maybeNotifySystemUiListenerLifetimeExtendedListLocked(List<NotificationRecord> notificationList, int packageImportance) {
        int i = notificationList.size() - 1;
    L3:
        if (i < 0) goto L6;
        NotificationRecord record = notificationList.get(i);
        maybeNotifySystemUiListenerLifetimeExtendedLocked(record, record.getSbn().getPackageName(), packageImportance);
        i = i - 1;
        goto L3
    }

    private void maybeNotifySystemUiListenerLifetimeExtendedLocked(final NotificationRecord record, String pkg, int packageImportance) {
        if (record == null) goto L19;
        if ((record.getSbn().getNotification().flags & 65536) <= 0) goto L19;
        if (record.isCanceledAfterLifetimeExtension() == true) goto L21;
        record.setCanceledAfterLifetimeExtension(true);
        final boolean savedOnlyAlertOnceState = false;
        if (pkg != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        boolean isAppForeground = r2;
        final boolean savedPostSilentlyState = record.shouldPostSilently();
        if ((record.getNotification().flags & 8) <= 0) goto L16;
        savedOnlyAlertOnceState = true;
    L16:
        record.setPostSilently(true);
        record.getNotification().flags |= 8;
        PostNotificationTracker tracker = this.mPostNotificationTrackerFactory.newTracker(null);
        tracker.addCleanupRunnable(new NotificationManagerService$$ExternalSyntheticLambda13(this, record, savedPostSilentlyState, savedOnlyAlertOnceState));
        this.mHandler.post(new EnqueueNotificationRunnable(this, record.getUser().getIdentifier(), record, isAppForeground, false, tracker));
        EventLogTags.writeNotificationCancelPrevented(record.getKey());
        return;
    L10:
        if (packageImportance != 100) goto L12;
        r2 = true;
        goto L13
    L21:
        return;
    }

    private /* synthetic */ void lambda$maybeNotifySystemUiListenerLifetimeExtendedLocked$20(NotificationRecord record, boolean savedPostSilentlyState, boolean savedOnlyAlertOnceState) {
        Object r0 = this.mNotificationLock;
        monitor-enter(r0);
        record.setPostSilently(savedPostSilentlyState);     // Catch: Throwable -> L7
        if (savedOnlyAlertOnceState == true) goto L9;
        record.getNotification().flags &= -9;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private int getPackageImportanceWithIdentity(String pkg) {
        long token = Binder.clearCallingIdentity();
        int packageImportance = this.mActivityManager.getPackageImportance(pkg);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return packageImportance;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void broadcastToCallNotificationEventCallbacks(RemoteCallbackList<ICallNotificationEventCallback> callbackList, NotificationRecord r, boolean isPosted) {
        if (callbackList == null) goto L20;
        int numCallbacks = callbackList.beginBroadcast();
        int i = 0;
    L4:
        if (i >= numCallbacks) goto L13;
        if (isPosted == true) goto L15;
        callbackList.getBroadcastItem(i).onCallNotificationRemoved(r.getSbn().getPackageName(), r.getUser());     // Catch: RemoteException -> L7
    L10:
        i = i + 1;
        goto L4
    L15:
        callbackList.getBroadcastItem(i).onCallNotificationPosted(r.getSbn().getPackageName(), r.getUser());     // Catch: RemoteException -> L7
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        callbackList.finishBroadcast();
        return;
    }

    void notifyCallNotificationEventListenerOnPosted(NotificationRecord r) {
        if (r.getNotification().isStyle(Notification.CallStyle.class) == true) goto L5;
        return;
    L5:
        ArrayMap<String, ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>>> r0 = this.mCallNotificationEventCallbacks;
        monitor-enter(r0);
        ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>> callbacksForPackage = this.mCallNotificationEventCallbacks.get(r.getSbn().getPackageName());     // Catch: Throwable -> L11
        if (callbacksForPackage != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        if (r.getUser().equals(UserHandle.ALL) == true) goto L16;
        broadcastToCallNotificationEventCallbacks(callbacksForPackage.get(Integer.valueOf(r.getUser().getIdentifier())), r, true);     // Catch: Throwable -> L11
        broadcastToCallNotificationEventCallbacks(callbacksForPackage.get(-1), r, true);     // Catch: Throwable -> L11
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        Iterator<RemoteCallbackList<ICallNotificationEventCallback>> r2 = callbacksForPackage.values().iterator();     // Catch: Throwable -> L11
    L18:
        if (r2.hasNext() == false) goto L20;
        RemoteCallbackList<ICallNotificationEventCallback> callbackList = r2.next();     // Catch: Throwable -> L11
        broadcastToCallNotificationEventCallbacks(callbackList, r, true);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    void notifyCallNotificationEventListenerOnRemoved(NotificationRecord r) {
        if (r.getNotification().isStyle(Notification.CallStyle.class) == true) goto L5;
        return;
    L5:
        ArrayMap<String, ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>>> r0 = this.mCallNotificationEventCallbacks;
        monitor-enter(r0);
        ArrayMap<Integer, RemoteCallbackList<ICallNotificationEventCallback>> callbacksForPackage = this.mCallNotificationEventCallbacks.get(r.getSbn().getPackageName());     // Catch: Throwable -> L11
        if (callbacksForPackage != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        if (r.getUser().equals(UserHandle.ALL) == true) goto L16;
        broadcastToCallNotificationEventCallbacks(callbacksForPackage.get(Integer.valueOf(r.getUser().getIdentifier())), r, false);     // Catch: Throwable -> L11
        broadcastToCallNotificationEventCallbacks(callbacksForPackage.get(-1), r, false);     // Catch: Throwable -> L11
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        Iterator<RemoteCallbackList<ICallNotificationEventCallback>> r2 = callbacksForPackage.values().iterator();     // Catch: Throwable -> L11
    L18:
        if (r2.hasNext() == false) goto L20;
        RemoteCallbackList<ICallNotificationEventCallback> callbackList = r2.next();     // Catch: Throwable -> L11
        broadcastToCallNotificationEventCallbacks(callbackList, r, false);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    void resetAssistantUserSet(int userId) {
        checkCallerIsSystemOrShell();
        this.mAssistants.setUserSet(userId, false);
        handleSavePolicyFile();
    }

    ComponentName getApprovedAssistant(int userId) {
        checkCallerIsSystemOrShell();
        List<ComponentName> allowedComponents = this.mAssistants.getAllowedComponents(userId);
        return (ComponentName) CollectionUtils.firstOrNull(allowedComponents);
    }

    private void writeSecureNotificationsPolicy(TypedXmlSerializer out) throws IOException {
        out.startTag(null, LOCKSCREEN_ALLOW_SECURE_NOTIFICATIONS_TAG);
        out.attributeBoolean(null, LOCKSCREEN_ALLOW_SECURE_NOTIFICATIONS_VALUE, this.mLockScreenAllowSecureNotifications);
        out.endTag(null, LOCKSCREEN_ALLOW_SECURE_NOTIFICATIONS_TAG);
    }

    protected Notification createReviewPermissionsNotification() {
        Intent tapIntent = new Intent("android.settings.ALL_APPS_NOTIFICATION_SETTINGS_FOR_REVIEW");
        Intent remindIntent = new Intent(REVIEW_NOTIF_ACTION_REMIND);
        Intent dismissIntent = new Intent(REVIEW_NOTIF_ACTION_DISMISS);
        Intent swipeIntent = new Intent(REVIEW_NOTIF_ACTION_CANCELED);
        Notification.Action remindMe = new Notification.Action.Builder(null, getContext().getResources().getString(R.string.status_bar_wifi), PendingIntent.getBroadcast(getContext(), 0, remindIntent, AudioFormat.DTS_HD)).build();
        Notification.Action dismiss = new Notification.Action.Builder(null, getContext().getResources().getString(R.string.status_bar_vpn), PendingIntent.getBroadcast(getContext(), 0, dismissIntent, AudioFormat.DTS_HD)).build();
        return new Notification.Builder(getContext(), "SYSTEM_CHANGES_ALERTS").setSmallIcon(17305175).setContentTitle(getContext().getResources().getString(R.string.stk_cc_ss_to_dial)).setContentText(getContext().getResources().getString(R.string.status_bar_zen)).setContentIntent(PendingIntent.getActivity(getContext(), 0, tapIntent, AudioFormat.DTS_HD)).setStyle(new Notification.BigTextStyle()).setFlag(32, true).setAutoCancel(true).addAction(remindMe).addAction(dismiss).setDeleteIntent(PendingIntent.getBroadcast(getContext(), 0, swipeIntent, AudioFormat.DTS_HD)).build();
    }

    protected void maybeShowInitialReviewPermissionsNotification() {
        if (this.mShowReviewPermissionsNotification == true) goto L5;
        return;
    L5:
        int currentState = Settings.Global.getInt(getContext().getContentResolver(), "review_permissions_notification_state", -1);
        if (currentState != 0) goto L8;
    L9:
        NotificationManager nm = (NotificationManager) getContext().getSystemService(NotificationManager.class);
        nm.notify(TAG, 71, createReviewPermissionsNotification());
        return;
    L8:
        if (currentState == 3) goto L9;
    }

    private void sendBroadcastForPushClient(String msgId, int resultCode) {
        if (msgId != null) goto L4;
        return;
    L4:
        Intent intent = new Intent("com.ups.service.ntfy.show");
        intent.putExtra("ups_msgId", msgId);
        intent.putExtra("resultCode", resultCode);
        getContext().sendBroadcastAsUser(intent, UserHandle.ALL);
    }

    private boolean checkSelfSetSwitch(String pkg) {
        if ("com.zte.softda".equalsIgnoreCase(pkg) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mPackageManagerInternal == null) goto L9;
        if (this.mPackageManagerInternal.isSameApp("com.zte.softda", Binder.getCallingUid(), UserHandle.getCallingUserId()) == false) goto L9;
        return true;
    }

    public NotificationManagerServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IObricNotificationManagerService getObricExt() {
        return this.mObricExt;
    }
}

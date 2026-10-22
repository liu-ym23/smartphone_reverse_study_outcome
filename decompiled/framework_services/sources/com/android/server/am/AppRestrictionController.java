package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.app.IUidObserver;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.app.usage.AppStandbyInfo;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.graphics.drawable.Icon;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerExemptionManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseArrayMap;
import android.util.TimeUtils;
import android.util.Xml;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.function.TriConsumer;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.AppStateTracker;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.apphibernation.AppHibernationManagerInternal;
import com.android.server.job.JobPackageTracker;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.usage.AppStandbyInternal;
import com.android.server.usage.UnixCalendar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class AppRestrictionController {
    private static final String APP_RESTRICTION_SETTINGS_DIRNAME = "apprestriction";
    private static final String APP_RESTRICTION_SETTINGS_FILENAME = "settings.xml";
    private static final String ATTR_CUR_LEVEL = "curlevel";
    private static final String ATTR_LEVEL_TS = "levelts";
    private static final String ATTR_PACKAGE = "package";
    private static final String ATTR_REASON = "reason";
    private static final String ATTR_UID = "uid";
    static final boolean DEBUG_BG_RESTRICTION_CONTROLLER = false;
    static final String DEVICE_CONFIG_SUBNAMESPACE_PREFIX = "bg_";
    private static final boolean ENABLE_SHOW_FGS_MANAGER_ACTION_ON_BG_RESTRICTION = false;
    private static final boolean ENABLE_SHOW_FOREGROUND_SERVICE_MANAGER = true;
    private static final String[] ROLES_IN_INTEREST = null;
    static final int STOCK_PM_FLAGS = 819200;
    static final String TAG = "ActivityManager";
    private static final String TAG_SETTINGS = "settings";
    static final int TRACKER_TYPE_BATTERY = 1;
    static final int TRACKER_TYPE_BATTERY_EXEMPTION = 2;
    static final int TRACKER_TYPE_BIND_SERVICE_EVENTS = 7;
    static final int TRACKER_TYPE_BROADCAST_EVENTS = 6;
    static final int TRACKER_TYPE_FGS = 3;
    static final int TRACKER_TYPE_MEDIA_SESSION = 4;
    static final int TRACKER_TYPE_PERMISSION = 5;
    static final int TRACKER_TYPE_UNKNOWN = 0;
    private final SparseArrayMap<String, Runnable> mActiveUids;
    final ActivityManagerService mActivityManagerService;
    private final AppStandbyInternal.AppIdleStateChangeListener mAppIdleStateChangeListener;
    private final ArrayList<BaseAppStateTracker> mAppStateTrackers;
    private final AppStateTracker.BackgroundRestrictedAppListener mBackgroundRestrictionListener;
    private final HandlerExecutor mBgExecutor;
    private final BgHandler mBgHandler;
    private final HandlerThread mBgHandlerThread;
    ArraySet<String> mBgRestrictionExemptioFromSysConfig;
    private final BroadcastReceiver mBootReceiver;
    private final BroadcastReceiver mBroadcastReceiver;
    private final SparseArray<Set<String>> mCarrierPrivilegedApps;
    private final Object mCarrierPrivilegedLock;
    private volatile ArrayList<PhoneCarrierPrivilegesCallback> mCarrierPrivilegesCallbacks;
    private final ConstantsObserver mConstantsObserver;
    private final Context mContext;
    private int[] mDeviceIdleAllowlist;
    private int[] mDeviceIdleExceptIdleAllowlist;
    private final TrackerInfo mEmptyTrackerInfo;
    private final HandlerExecutor mExecutor;
    private final Injector mInjector;
    private final Object mLock;
    private volatile boolean mLockedBootCompleted;
    private final NotificationHelper mNotificationHelper;
    private final CopyOnWriteArraySet<ActivityManagerInternal.AppBackgroundRestrictionListener> mRestrictionListeners;
    final RestrictionSettings mRestrictionSettings;
    private final AtomicBoolean mRestrictionSettingsXmlLoaded;
    private final OnRoleHoldersChangedListener mRoleHolderChangedListener;
    private final Object mSettingsLock;
    private final ArraySet<Integer> mSystemDeviceIdleAllowlist;
    private final ArraySet<Integer> mSystemDeviceIdleExceptIdleAllowlist;
    private final HashMap<String, Boolean> mSystemModulesCache;
    private final ArrayList<Runnable> mTmpRunnables;
    private final IUidObserver mUidObserver;
    private final SparseArray<ArrayList<String>> mUidRolesMapping;

    static class BgHandler extends Handler {
        static final int MSG_APP_RESTRICTION_LEVEL_CHANGED = 1;
        static final int MSG_APP_STANDBY_BUCKET_CHANGED = 2;
        static final int MSG_BACKGROUND_RESTRICTION_CHANGED = 0;
        static final int MSG_CANCEL_REQUEST_BG_RESTRICTED = 9;
        static final int MSG_LOAD_RESTRICTION_SETTINGS = 10;
        static final int MSG_PERSIST_RESTRICTION_SETTINGS = 11;
        static final int MSG_REQUEST_BG_RESTRICTED = 4;
        static final int MSG_UID_ACTIVE = 6;
        static final int MSG_UID_GONE = 7;
        static final int MSG_UID_IDLE = 5;
        static final int MSG_UID_PROC_STATE_CHANGED = 8;
        static final int MSG_USER_INTERACTION_STARTED = 3;
        private final Injector mInjector;

        BgHandler(Looper looper, Injector injector) {
            super(looper);
            this.mInjector = injector;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            AppRestrictionController c = this.mInjector.getAppRestrictionController();
            boolean r2 = false;
            switch(msg.what) {
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                case 10: goto L6;
                case 11: goto L5;
                default: goto L38;
            };
        L5:
            c.mRestrictionSettings.persistToXml(msg.arg1);
            return;
        L6:
            c.mRestrictionSettings.loadFromXml(true);
            return;
        L7:
            c.handleCancelRequestBgRestricted((String) msg.obj, msg.arg1);
            return;
        L8:
            c.handleUidProcStateChanged(msg.arg1, msg.arg2);
            return;
        L9:
            int r1 = msg.arg1;
            if (msg.arg2 != 1) goto L12;
            r2 = true;
        L12:
            c.handleUidInactive(r1, r2);
            c.handleUidGone(msg.arg1);
            return;
        L13:
            c.handleUidActive(msg.arg1);
            return;
        L14:
            int r3 = msg.arg1;
            if (msg.arg2 != 1) goto L17;
            r2 = true;
        L17:
            c.handleUidInactive(r3, r2);
            return;
        L18:
            c.handleRequestBgRestricted((String) msg.obj, msg.arg1);
            return;
        L19:
            AppRestrictionController.m1363$$Nest$monUserInteractionStarted(c, (String) msg.obj, msg.arg1);
            return;
        L20:
            AppRestrictionController.m1355$$Nest$mhandleAppStandbyBucketChanged(c, msg.arg2, (String) msg.obj, msg.arg1);
            return;
        L21:
            AppRestrictionController.m1353$$Nest$mdispatchAppRestrictionLevelChanges(c, msg.arg1, (String) msg.obj, msg.arg2);
            return;
        L22:
            int r4 = msg.arg1;
            String r5 = (String) msg.obj;
            if (msg.arg2 != 1) goto L25;
            r2 = true;
        L25:
            AppRestrictionController.m1356$$Nest$mhandleBackgroundRestrictionChanged(c, r4, r5, r2);
            return;
        }
    }

    final class ConstantsObserver implements DeviceConfig.OnPropertiesChangedListener {
        static final long DEFAULT_BG_ABUSIVE_NOTIFICATION_MINIMAL_INTERVAL_MS = 2592000000L;
        static final boolean DEFAULT_BG_AUTO_RESTRICTED_BUCKET_ON_BG_RESTRICTION = false;
        static final boolean DEFAULT_BG_AUTO_RESTRICT_ABUSIVE_APPS = true;
        static final long DEFAULT_BG_LONG_FGS_NOTIFICATION_MINIMAL_INTERVAL_MS = 2592000000L;
        static final boolean DEFAULT_BG_PROMPT_FGS_ON_LONG_RUNNING = true;
        static final boolean DEFAULT_BG_PROMPT_FGS_WITH_NOTIFICATION_ON_LONG_RUNNING = false;
        static final String KEY_BG_ABUSIVE_NOTIFICATION_MINIMAL_INTERVAL = "bg_abusive_notification_minimal_interval";
        static final String KEY_BG_AUTO_RESTRICTED_BUCKET_ON_BG_RESTRICTION = "bg_auto_restricted_bucket_on_bg_restricted";
        static final String KEY_BG_AUTO_RESTRICT_ABUSIVE_APPS = "bg_auto_restrict_abusive_apps";
        static final String KEY_BG_LONG_FGS_NOTIFICATION_MINIMAL_INTERVAL = "bg_long_fgs_notification_minimal_interval";
        static final String KEY_BG_PROMPT_ABUSIVE_APPS_TO_BG_RESTRICTED = "bg_prompt_abusive_apps_to_bg_restricted";
        static final String KEY_BG_PROMPT_FGS_ON_LONG_RUNNING = "bg_prompt_fgs_on_long_running";
        static final String KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_ON_LONG_RUNNING = "bg_prompt_fgs_with_noti_on_long_running";
        static final String KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_TO_BG_RESTRICTED = "bg_prompt_fgs_with_noti_to_bg_restricted";
        static final String KEY_BG_RESTRICTION_EXEMPTED_PACKAGES = "bg_restriction_exempted_packages";
        volatile long mBgAbusiveNotificationMinIntervalMs;
        volatile boolean mBgAutoRestrictAbusiveApps;
        volatile boolean mBgAutoRestrictedBucket;
        volatile long mBgLongFgsNotificationMinIntervalMs;
        volatile boolean mBgPromptAbusiveAppsToBgRestricted;
        volatile boolean mBgPromptFgsOnLongRunning;
        volatile boolean mBgPromptFgsWithNotiOnLongRunning;
        volatile boolean mBgPromptFgsWithNotiToBgRestricted;
        volatile Set<String> mBgRestrictionExemptedPackages;
        final boolean mDefaultBgPromptAbusiveAppToBgRestricted;
        final boolean mDefaultBgPromptFgsWithNotiToBgRestricted;
        final /* synthetic */ AppRestrictionController this$0;

        ConstantsObserver(AppRestrictionController this$0, Handler handler, Context context) {
            this.this$0 = this$0;
            this.mBgRestrictionExemptedPackages = Collections.emptySet();
            this.mDefaultBgPromptFgsWithNotiToBgRestricted = context.getResources().getBoolean(R.bool.config_bluetooth_sco_off_call);
            this.mDefaultBgPromptAbusiveAppToBgRestricted = context.getResources().getBoolean(R.bool.config_bluetooth_address_validation);
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            Iterator r0 = properties.getKeyset().iterator();
        L4:
            if (r0.hasNext() == false) goto L54;
            String name = (String) r0.next();
            if (name == null) goto L53;
            if (name.startsWith(AppRestrictionController.DEVICE_CONFIG_SUBNAMESPACE_PREFIX) == false) goto L68;
            switch(name.hashCode()) {
                case -1918659497: goto L38;
                case -1199889595: goto L35;
                case -582264882: goto L32;
                case -395763044: goto L29;
                case -157665503: goto L26;
                case 854605367: goto L23;
                case 892275457: goto L20;
                case 1771474142: goto L17;
                case 1965398671: goto L14;
                default: goto L40;
            };
        L40:
            byte r2 = -1;
        L41:
            switch(r2) {
                case 0: goto L51;
                case 1: goto L50;
                case 2: goto L49;
                case 3: goto L48;
                case 4: goto L47;
                case 5: goto L46;
                case 6: goto L45;
                case 7: goto L44;
                case 8: goto L43;
                default: goto L52;
            };
        L43:
            updateBgRestrictionExemptedPackages();
            goto L52
        L44:
            updateBgPromptAbusiveAppToBgRestricted();
            goto L52
        L45:
            updateBgPromptFgsOnLongRunning();
            goto L52
        L46:
            updateBgPromptFgsWithNotiOnLongRunning();
            goto L52
        L47:
            updateBgPromptFgsWithNotiToBgRestricted();
            goto L52
        L48:
            updateBgLongFgsNotificationMinimalInterval();
            goto L52
        L49:
            updateBgAbusiveNotificationMinimalInterval();
            goto L52
        L50:
            updateBgAutoRestrictAbusiveApps();
            goto L52
        L51:
            updateBgAutoRestrictedBucketChanged();
        L52:
            AppRestrictionController.m1359$$Nest$monPropertiesChanged(this.this$0, name);
            goto L4
        L14:
            if (name.equals(KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_TO_BG_RESTRICTED) == false) goto L40;
            r2 = 4;
            goto L41
        L17:
            if (name.equals(KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_ON_LONG_RUNNING) == false) goto L40;
            r2 = 5;
            goto L41
        L20:
            if (name.equals(KEY_BG_LONG_FGS_NOTIFICATION_MINIMAL_INTERVAL) == false) goto L40;
            r2 = 3;
            goto L41
        L23:
            if (name.equals(KEY_BG_ABUSIVE_NOTIFICATION_MINIMAL_INTERVAL) == false) goto L40;
            r2 = 2;
            goto L41
        L26:
            if (name.equals(KEY_BG_RESTRICTION_EXEMPTED_PACKAGES) == false) goto L40;
            r2 = 8;
            goto L41
        L29:
            if (name.equals(KEY_BG_AUTO_RESTRICTED_BUCKET_ON_BG_RESTRICTION) == false) goto L40;
            r2 = 0;
            goto L41
        L32:
            if (name.equals(KEY_BG_PROMPT_FGS_ON_LONG_RUNNING) == false) goto L40;
            r2 = 6;
            goto L41
        L35:
            if (name.equals(KEY_BG_AUTO_RESTRICT_ABUSIVE_APPS) == false) goto L40;
            r2 = 1;
            goto L41
        L38:
            if (name.equals(KEY_BG_PROMPT_ABUSIVE_APPS_TO_BG_RESTRICTED) == false) goto L40;
            r2 = 7;
            goto L41
        L68:
            return;
        L53:
            return;
        }

        public void start() {
            updateDeviceConfig();
        }

        void updateDeviceConfig() {
            updateBgAutoRestrictedBucketChanged();
            updateBgAutoRestrictAbusiveApps();
            updateBgAbusiveNotificationMinimalInterval();
            updateBgLongFgsNotificationMinimalInterval();
            updateBgPromptFgsWithNotiToBgRestricted();
            updateBgPromptFgsWithNotiOnLongRunning();
            updateBgPromptFgsOnLongRunning();
            updateBgPromptAbusiveAppToBgRestricted();
            updateBgRestrictionExemptedPackages();
        }

        private void updateBgAutoRestrictedBucketChanged() {
            boolean oldValue = this.mBgAutoRestrictedBucket;
            this.mBgAutoRestrictedBucket = DeviceConfig.getBoolean("activity_manager", KEY_BG_AUTO_RESTRICTED_BUCKET_ON_BG_RESTRICTION, false);
            if (oldValue == this.mBgAutoRestrictedBucket) goto L6;
            AppRestrictionController.m1354$$Nest$mdispatchAutoRestrictedBucketFeatureFlagChanged(this.this$0, this.mBgAutoRestrictedBucket);
            return;
        }

        private void updateBgAutoRestrictAbusiveApps() {
            this.mBgAutoRestrictAbusiveApps = DeviceConfig.getBoolean("activity_manager", KEY_BG_AUTO_RESTRICT_ABUSIVE_APPS, true);
        }

        private void updateBgAbusiveNotificationMinimalInterval() {
            this.mBgAbusiveNotificationMinIntervalMs = DeviceConfig.getLong("activity_manager", KEY_BG_ABUSIVE_NOTIFICATION_MINIMAL_INTERVAL, UnixCalendar.MONTH_IN_MILLIS);
        }

        private void updateBgLongFgsNotificationMinimalInterval() {
            this.mBgLongFgsNotificationMinIntervalMs = DeviceConfig.getLong("activity_manager", KEY_BG_LONG_FGS_NOTIFICATION_MINIMAL_INTERVAL, UnixCalendar.MONTH_IN_MILLIS);
        }

        private void updateBgPromptFgsWithNotiToBgRestricted() {
            this.mBgPromptFgsWithNotiToBgRestricted = DeviceConfig.getBoolean("activity_manager", KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_TO_BG_RESTRICTED, this.mDefaultBgPromptFgsWithNotiToBgRestricted);
        }

        private void updateBgPromptFgsWithNotiOnLongRunning() {
            this.mBgPromptFgsWithNotiOnLongRunning = DeviceConfig.getBoolean("activity_manager", KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_ON_LONG_RUNNING, false);
        }

        private void updateBgPromptFgsOnLongRunning() {
            this.mBgPromptFgsOnLongRunning = DeviceConfig.getBoolean("activity_manager", KEY_BG_PROMPT_FGS_ON_LONG_RUNNING, true);
        }

        private void updateBgPromptAbusiveAppToBgRestricted() {
            this.mBgPromptAbusiveAppsToBgRestricted = DeviceConfig.getBoolean("activity_manager", KEY_BG_PROMPT_ABUSIVE_APPS_TO_BG_RESTRICTED, this.mDefaultBgPromptAbusiveAppToBgRestricted);
        }

        private void updateBgRestrictionExemptedPackages() {
            String settings = DeviceConfig.getString("activity_manager", KEY_BG_RESTRICTION_EXEMPTED_PACKAGES, null);
            if (settings != null) goto L6;
            this.mBgRestrictionExemptedPackages = Collections.emptySet();
            return;
        L6:
            String[] settingsList = settings.split(",");
            ArraySet<String> packages = new ArraySet();
            int r3 = settingsList.length;
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L9;
            String pkg = settingsList[r4];
            packages.add(pkg);
            r4 = r4 + 1;
            goto L7
        L9:
            this.mBgRestrictionExemptedPackages = Collections.unmodifiableSet(packages);
        }

        void dump(PrintWriter pw, String prefix) {
            pw.print(prefix);
            pw.println("BACKGROUND RESTRICTION POLICY SETTINGS:");
            String prefix2 = "  " + prefix;
            pw.print(prefix2);
            pw.print(KEY_BG_AUTO_RESTRICTED_BUCKET_ON_BG_RESTRICTION);
            pw.print('=');
            pw.println(this.mBgAutoRestrictedBucket);
            pw.print(prefix2);
            pw.print(KEY_BG_AUTO_RESTRICT_ABUSIVE_APPS);
            pw.print('=');
            pw.println(this.mBgAutoRestrictAbusiveApps);
            pw.print(prefix2);
            pw.print(KEY_BG_ABUSIVE_NOTIFICATION_MINIMAL_INTERVAL);
            pw.print('=');
            pw.println(this.mBgAbusiveNotificationMinIntervalMs);
            pw.print(prefix2);
            pw.print(KEY_BG_LONG_FGS_NOTIFICATION_MINIMAL_INTERVAL);
            pw.print('=');
            pw.println(this.mBgLongFgsNotificationMinIntervalMs);
            pw.print(prefix2);
            pw.print(KEY_BG_PROMPT_FGS_ON_LONG_RUNNING);
            pw.print('=');
            pw.println(this.mBgPromptFgsOnLongRunning);
            pw.print(prefix2);
            pw.print(KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_ON_LONG_RUNNING);
            pw.print('=');
            pw.println(this.mBgPromptFgsWithNotiOnLongRunning);
            pw.print(prefix2);
            pw.print(KEY_BG_PROMPT_FGS_WITH_NOTIFICATION_TO_BG_RESTRICTED);
            pw.print('=');
            pw.println(this.mBgPromptFgsWithNotiToBgRestricted);
            pw.print(prefix2);
            pw.print(KEY_BG_PROMPT_ABUSIVE_APPS_TO_BG_RESTRICTED);
            pw.print('=');
            pw.println(this.mBgPromptAbusiveAppsToBgRestricted);
            pw.print(prefix2);
            pw.print(KEY_BG_RESTRICTION_EXEMPTED_PACKAGES);
            pw.print('=');
            pw.println(this.mBgRestrictionExemptedPackages.toString());
        }
    }

    static class Injector {
        private ActivityManagerInternal mActivityManagerInternal;
        private AppBatteryExemptionTracker mAppBatteryExemptionTracker;
        private AppBatteryTracker mAppBatteryTracker;
        private AppFGSTracker mAppFGSTracker;
        private AppHibernationManagerInternal mAppHibernationInternal;
        private AppMediaSessionTracker mAppMediaSessionTracker;
        private AppOpsManager mAppOpsManager;
        private AppPermissionTracker mAppPermissionTracker;
        private AppRestrictionController mAppRestrictionController;
        private AppStandbyInternal mAppStandbyInternal;
        private AppStateTracker mAppStateTracker;
        private final Context mContext;
        private IActivityManager mIActivityManager;
        private NotificationManager mNotificationManager;
        private PackageManagerInternal mPackageManagerInternal;
        private RoleManager mRoleManager;
        private TelephonyManager mTelephonyManager;
        private UserManagerInternal mUserManagerInternal;

        Injector(Context context) {
            this.mContext = context;
        }

        Context getContext() {
            return this.mContext;
        }

        void initAppStateTrackers(AppRestrictionController controller) {
            this.mAppRestrictionController = controller;
            this.mAppBatteryTracker = new AppBatteryTracker(this.mContext, controller);
            this.mAppBatteryExemptionTracker = new AppBatteryExemptionTracker(this.mContext, controller);
            this.mAppFGSTracker = new AppFGSTracker(this.mContext, controller);
            this.mAppMediaSessionTracker = new AppMediaSessionTracker(this.mContext, controller);
            this.mAppPermissionTracker = new AppPermissionTracker(this.mContext, controller);
            AppRestrictionController.m1342$$Nest$fgetmAppStateTrackers(controller).add(this.mAppBatteryTracker);
            AppRestrictionController.m1342$$Nest$fgetmAppStateTrackers(controller).add(this.mAppBatteryExemptionTracker);
            AppRestrictionController.m1342$$Nest$fgetmAppStateTrackers(controller).add(this.mAppFGSTracker);
            AppRestrictionController.m1342$$Nest$fgetmAppStateTrackers(controller).add(this.mAppMediaSessionTracker);
            AppRestrictionController.m1342$$Nest$fgetmAppStateTrackers(controller).add(this.mAppPermissionTracker);
            AppRestrictionController.m1342$$Nest$fgetmAppStateTrackers(controller).add(new AppBroadcastEventsTracker(this.mContext, controller));
            AppRestrictionController.m1342$$Nest$fgetmAppStateTrackers(controller).add(new AppBindServiceEventsTracker(this.mContext, controller));
        }

        ActivityManagerInternal getActivityManagerInternal() {
            if (this.mActivityManagerInternal != null) goto L6;
            this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        L6:
            return this.mActivityManagerInternal;
        }

        AppRestrictionController getAppRestrictionController() {
            return this.mAppRestrictionController;
        }

        AppOpsManager getAppOpsManager() {
            if (this.mAppOpsManager != null) goto L6;
            this.mAppOpsManager = (AppOpsManager) getContext().getSystemService(AppOpsManager.class);
        L6:
            return this.mAppOpsManager;
        }

        AppStandbyInternal getAppStandbyInternal() {
            if (this.mAppStandbyInternal != null) goto L6;
            this.mAppStandbyInternal = (AppStandbyInternal) LocalServices.getService(AppStandbyInternal.class);
        L6:
            return this.mAppStandbyInternal;
        }

        AppHibernationManagerInternal getAppHibernationInternal() {
            if (this.mAppHibernationInternal != null) goto L6;
            this.mAppHibernationInternal = (AppHibernationManagerInternal) LocalServices.getService(AppHibernationManagerInternal.class);
        L6:
            return this.mAppHibernationInternal;
        }

        AppStateTracker getAppStateTracker() {
            if (this.mAppStateTracker != null) goto L6;
            this.mAppStateTracker = (AppStateTracker) LocalServices.getService(AppStateTracker.class);
        L6:
            return this.mAppStateTracker;
        }

        IActivityManager getIActivityManager() {
            return ActivityManager.getService();
        }

        UserManagerInternal getUserManagerInternal() {
            if (this.mUserManagerInternal != null) goto L6;
            this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        L6:
            return this.mUserManagerInternal;
        }

        PackageManagerInternal getPackageManagerInternal() {
            if (this.mPackageManagerInternal != null) goto L6;
            this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        L6:
            return this.mPackageManagerInternal;
        }

        PackageManager getPackageManager() {
            return getContext().getPackageManager();
        }

        NotificationManager getNotificationManager() {
            if (this.mNotificationManager != null) goto L6;
            this.mNotificationManager = (NotificationManager) getContext().getSystemService(NotificationManager.class);
        L6:
            return this.mNotificationManager;
        }

        RoleManager getRoleManager() {
            if (this.mRoleManager != null) goto L6;
            this.mRoleManager = (RoleManager) getContext().getSystemService(RoleManager.class);
        L6:
            return this.mRoleManager;
        }

        TelephonyManager getTelephonyManager() {
            if (this.mTelephonyManager != null) goto L6;
            this.mTelephonyManager = (TelephonyManager) getContext().getSystemService(TelephonyManager.class);
        L6:
            return this.mTelephonyManager;
        }

        AppFGSTracker getAppFGSTracker() {
            return this.mAppFGSTracker;
        }

        AppMediaSessionTracker getAppMediaSessionTracker() {
            return this.mAppMediaSessionTracker;
        }

        ActivityManagerService getActivityManagerService() {
            return this.mAppRestrictionController.mActivityManagerService;
        }

        UidBatteryUsageProvider getUidBatteryUsageProvider() {
            return this.mAppBatteryTracker;
        }

        AppBatteryExemptionTracker getAppBatteryExemptionTracker() {
            return this.mAppBatteryExemptionTracker;
        }

        AppPermissionTracker getAppPermissionTracker() {
            return this.mAppPermissionTracker;
        }

        String getPackageName(int pid) {
            ActivityManagerService am = getActivityManagerService();
            ActivityManagerService.PidMap r1 = am.mPidsSelfLocked;
            monitor-enter(r1);
            ProcessRecord app = am.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L11
            if (app == null) goto L13;
            ApplicationInfo ai = app.info;     // Catch: Throwable -> L11
            if (ai == null) goto L13;
            String r4 = ai.packageName;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return r4;
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return null;
        L11:
            th = move-exception;
            throw th;
        }

        void scheduleInitTrackers(Handler handler, Runnable initializers) {
            handler.post(initializers);
        }

        File getDataSystemDeDirectory(int userId) {
            return Environment.getDataSystemDeDirectory(userId);
        }

        long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        Handler getDefaultHandler() {
            return this.mAppRestrictionController.mActivityManagerService.mHandler;
        }

        boolean isTest() {
            return false;
        }
    }

    static class NotificationHelper {
        static final String ACTION_FGS_MANAGER_TRAMPOLINE = "com.android.server.am.ACTION_FGS_MANAGER_TRAMPOLINE";
        static final String ATTR_LAST_BATTERY_NOTIFICATION_TIME = "last_batt_noti_ts";
        static final String ATTR_LAST_LONG_FGS_NOTIFICATION_TIME = "last_long_fgs_noti_ts";
        static final String GROUP_KEY = "com.android.app.abusive_bg_apps";
        static final String[] NOTIFICATION_TIME_ATTRS = null;
        static final int NOTIFICATION_TYPE_ABUSIVE_CURRENT_DRAIN = 0;
        static final int NOTIFICATION_TYPE_LAST = 2;
        static final int NOTIFICATION_TYPE_LONG_RUNNING_FGS = 1;
        static final String[] NOTIFICATION_TYPE_STRINGS = null;
        static final String PACKAGE_SCHEME = "package";
        static final int SUMMARY_NOTIFICATION_ID = 203105544;
        private final BroadcastReceiver mActionButtonReceiver;
        private final AppRestrictionController mBgController;
        private final Context mContext;
        private final Injector mInjector;
        private final Object mLock;
        private int mNotificationIDStepper;
        private final NotificationManager mNotificationManager;
        private final Object mSettingsLock;

        @Retention(RetentionPolicy.SOURCE)
        @interface NotificationType {
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
        static /* bridge */ /* synthetic */ Context m1369$$Nest$fgetmContext(NotificationHelper r0) {
            return r0.mContext;
        }

        static {
            NOTIFICATION_TYPE_STRINGS = new String[]{"Abusive current drain", "Long-running FGS"};
            NOTIFICATION_TIME_ATTRS = new String[]{ATTR_LAST_BATTERY_NOTIFICATION_TIME, ATTR_LAST_LONG_FGS_NOTIFICATION_TIME};
        }

        static int notificationTimeAttrToType(String attr) {
            switch(attr.hashCode()) {
                case -1157017279: goto L9;
                case 17543473: goto L6;
                default: goto L11;
            };
        L11:
            byte r0 = -1;
        L12:
            switch(r0) {
                case 0: goto L16;
                case 1: goto L15;
                default: goto L14;
            };
        L15:
            return 1;
        L16:
            return 0;
        L14:
            throw new IllegalArgumentException();
        L6:
            if (attr.equals(ATTR_LAST_BATTERY_NOTIFICATION_TIME) == false) goto L11;
            r0 = 0;
            goto L12
        L9:
            if (attr.equals(ATTR_LAST_LONG_FGS_NOTIFICATION_TIME) == false) goto L11;
            r0 = 1;
            goto L12
        }

        static String notificationTypeToTimeAttr(int type) {
            return NOTIFICATION_TIME_ATTRS[type];
        }

        static String notificationTypeToString(int notificationType) {
            return NOTIFICATION_TYPE_STRINGS[notificationType];
        }

        NotificationHelper(AppRestrictionController controller) {
            this.mActionButtonReceiver = new AnonymousClass1(this);
            this.mNotificationIDStepper = 203105545;
            this.mBgController = controller;
            this.mInjector = AppRestrictionController.m1348$$Nest$fgetmInjector(controller);
            this.mNotificationManager = this.mInjector.getNotificationManager();
            this.mLock = AppRestrictionController.m1349$$Nest$fgetmLock(controller);
            this.mSettingsLock = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(controller);
            this.mContext = this.mInjector.getContext();
        }

        void onSystemReady() {
            this.mContext.registerReceiverForAllUsers(this.mActionButtonReceiver, new IntentFilter(ACTION_FGS_MANAGER_TRAMPOLINE), "android.permission.MANAGE_ACTIVITY_TASKS", AppRestrictionController.m1343$$Nest$fgetmBgHandler(this.mBgController), 4);
        }

        void postRequestBgRestrictedIfNecessary(String packageName, int uid) {
            if (AppRestrictionController.m1346$$Nest$fgetmConstantsObserver(this.mBgController).mBgPromptAbusiveAppsToBgRestricted == true) goto L5;
            return;
        L5:
            Intent intent = new Intent("android.settings.VIEW_ADVANCED_POWER_USAGE_DETAIL");
            intent.setData(Uri.fromParts("package", packageName, null));
            intent.addFlags(AudioFormat.AAC_ADIF);
            PendingIntent pendingIntent = PendingIntent.getActivityAsUser(this.mContext, 0, intent, AudioFormat.DTS_HD, null, UserHandle.of(UserHandle.getUserId(uid)));
            boolean hasForegroundServices = this.mBgController.hasForegroundServices(packageName, uid);
            boolean hasForegroundServiceNotifications = this.mBgController.hasForegroundServiceNotifications(packageName, uid);
            if (AppRestrictionController.m1346$$Nest$fgetmConstantsObserver(this.mBgController).mBgPromptFgsWithNotiToBgRestricted == true) goto L10;
            if (hasForegroundServices == false) goto L10;
            if (hasForegroundServiceNotifications == false) goto L10;
            return;
        L10:
            postNotificationIfNecessary(0, R.string.permdesc_schedule_exact_alarm, R.string.permdesc_readVisualUserSelect, pendingIntent, packageName, uid, null);
        }

        void postLongRunningFgsIfNecessary(String packageName, int uid) {
            FrameworkStatsLog.write(FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO, uid, this.mBgController.getRestrictionLevel(uid), 0, 3, this.mInjector.getAppFGSTracker().getTrackerInfoForStatsd(uid), null, null, null, PowerExemptionManager.getExemptionReasonForStatsd(this.mBgController.getBackgroundRestrictionExemptionReason(uid)), 0, 0, ActivityManager.isLowRamDeviceStatic(), this.mBgController.getRestrictionLevel(uid));
            if (AppRestrictionController.m1346$$Nest$fgetmConstantsObserver(this.mBgController).mBgPromptFgsOnLongRunning == true) goto L6;
            return;
        L6:
            if (AppRestrictionController.m1346$$Nest$fgetmConstantsObserver(this.mBgController).mBgPromptFgsWithNotiOnLongRunning == false) goto L8;
        L10:
            Intent intent = new Intent("android.intent.action.SHOW_FOREGROUND_SERVICE_MANAGER");
            intent.addFlags(16777216);
            PendingIntent pendingIntent = PendingIntent.getBroadcastAsUser(this.mContext, 0, intent, AudioFormat.DTS_HD, UserHandle.SYSTEM);
            postNotificationIfNecessary(1, R.string.permdesc_sdcardRead, R.string.permdesc_receiveBootCompleted, pendingIntent, packageName, uid, null);
            return;
        L8:
            if (this.mBgController.hasForegroundServiceNotifications(packageName, uid) == false) goto L10;
        }

        long getNotificationMinInterval(int notificationType) {
            switch(notificationType) {
                case 0: goto L8;
                case 1: goto L6;
                default: goto L3;
            };
        L3:
            return 0;
        L6:
            return AppRestrictionController.m1346$$Nest$fgetmConstantsObserver(this.mBgController).mBgLongFgsNotificationMinIntervalMs;
        L8:
            return AppRestrictionController.m1346$$Nest$fgetmConstantsObserver(this.mBgController).mBgAbusiveNotificationMinIntervalMs;
        }

        int getNotificationIdIfNecessary(int notificationType, String packageName, int uid) {
            Object r0 = this.mSettingsLock;
            monitor-enter(r0);
            RestrictionSettings.PkgSettings settings = this.mBgController.mRestrictionSettings.getRestrictionSettingsLocked(uid, packageName);     // Catch: Throwable -> L8
            if (settings != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return 0;
        L10:
            long now = this.mInjector.currentTimeMillis();     // Catch: Throwable -> L8
            long lastNotificationShownTime = settings.getLastNotificationTime(notificationType);     // Catch: Throwable -> L8
            if (lastNotificationShownTime != 0) goto L13;
        L16:
            settings.setLastNotificationTime(notificationType, now);     // Catch: Throwable -> L8
            int notificationId = settings.getNotificationId(notificationType);     // Catch: Throwable -> L8
            if (notificationId > 0) goto L19;
            int r7 = this.mNotificationIDStepper;     // Catch: Throwable -> L8
            this.mNotificationIDStepper = r7 + 1;     // Catch: Throwable -> L8
            notificationId = r7;
            settings.setNotificationId(notificationType, notificationId);     // Catch: Throwable -> L8
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return notificationId;
        L13:
            if ((getNotificationMinInterval(notificationType) + lastNotificationShownTime) <= now) goto L16;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return 0;
        L8:
            th = move-exception;
            throw th;
        }

        void postNotificationIfNecessary(int notificationType, int titleRes, int messageRes, PendingIntent pendingIntent, String packageName, int uid, Notification.Action[] actions) {
            int notificationId = getNotificationIdIfNecessary(notificationType, packageName, uid);
            if (notificationId > 0) goto L5;
            return;
        L5:
            PackageManagerInternal pmi = this.mInjector.getPackageManagerInternal();
            PackageManager pm = this.mInjector.getPackageManager();
            ApplicationInfo ai = pmi.getApplicationInfo(packageName, 819200, 1000, UserHandle.getUserId(uid));
            String title = this.mContext.getString(titleRes);
            Context r0 = this.mContext;
            if (ai == null) goto L8;
            CharSequence r2 = ai.loadLabel(pm);
        L9:
            String message = r0.getString(messageRes, new Object[]{r2});
            if (ai == null) goto L12;
            Icon icon = Icon.createWithResource(packageName, ai.icon);
        L13:
            postNotification(notificationId, packageName, uid, title, message, icon, pendingIntent, actions);
            return;
        L12:
            icon = null;
            goto L13
        L8:
            r2 = packageName;
            goto L9
        }

        void postNotification(int notificationId, String packageName, int uid, String title, String message, Icon icon, PendingIntent pendingIntent, Notification.Action[] actions) {
            UserHandle targetUser = UserHandle.of(UserHandle.getUserId(uid));
            postSummaryNotification(targetUser);
            Notification.Builder notificationBuilder = new Notification.Builder(this.mContext, "ABUSIVE_BACKGROUND_APPS").setAutoCancel(true).setGroup(GROUP_KEY).setWhen(this.mInjector.currentTimeMillis()).setSmallIcon(R.drawable.stat_sys_warning).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentText(message).setContentIntent(pendingIntent);
            if (icon == null) goto L5;
            notificationBuilder.setLargeIcon(icon);
        L5:
            if (actions == null) goto L10;
            int r2 = actions.length;
            int r3 = 0;
        L8:
            if (r3 >= r2) goto L10;
            Notification.Action action = actions[r3];
            notificationBuilder.addAction(action);
            r3 = r3 + 1;
        L10:
            Notification notification = notificationBuilder.build();
            notification.extras.putString("android.intent.extra.PACKAGE_NAME", packageName);
            this.mNotificationManager.notifyAsUser(null, notificationId, notification, targetUser);
        }

        private void postSummaryNotification(UserHandle targetUser) {
            Notification summary = new Notification.Builder(this.mContext, "ABUSIVE_BACKGROUND_APPS").setGroup(GROUP_KEY).setGroupSummary(true).setStyle(new Notification.BigTextStyle()).setSmallIcon(R.drawable.stat_sys_warning).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).build();
            this.mNotificationManager.notifyAsUser(null, SUMMARY_NOTIFICATION_ID, summary, targetUser);
        }

        void cancelRequestBgRestrictedIfNecessary(String packageName, int uid) {
            Object r0 = this.mSettingsLock;
            monitor-enter(r0);
            RestrictionSettings.PkgSettings settings = this.mBgController.mRestrictionSettings.getRestrictionSettingsLocked(uid, packageName);     // Catch: Throwable -> L9
            if (settings == null) goto L11;
            int notificationId = settings.getNotificationId(0);     // Catch: Throwable -> L9
            if (notificationId <= 0) goto L11;
            this.mNotificationManager.cancel(notificationId);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        void cancelLongRunningFGSNotificationIfNecessary(String packageName, int uid) {
            Object r0 = this.mSettingsLock;
            monitor-enter(r0);
            RestrictionSettings.PkgSettings settings = this.mBgController.mRestrictionSettings.getRestrictionSettingsLocked(uid, packageName);     // Catch: Throwable -> L9
            if (settings == null) goto L11;
            int notificationId = settings.getNotificationId(1);     // Catch: Throwable -> L9
            if (notificationId <= 0) goto L11;
            this.mNotificationManager.cancel(notificationId);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private class PhoneCarrierPrivilegesCallback implements TelephonyManager.CarrierPrivilegesCallback {
        private final int mPhoneId;
        final /* synthetic */ AppRestrictionController this$0;

        PhoneCarrierPrivilegesCallback(AppRestrictionController r1, int phoneId) {
            this.this$0 = r1;
            this.mPhoneId = phoneId;
        }

        public void onCarrierPrivilegesChanged(Set<String> privilegedPackageNames, Set<Integer> privilegedUids) {
            Object r0 = AppRestrictionController.m1345$$Nest$fgetmCarrierPrivilegedLock(this.this$0);
            monitor-enter(r0);
            AppRestrictionController.m1344$$Nest$fgetmCarrierPrivilegedApps(this.this$0).put(this.mPhoneId, Collections.unmodifiableSet(privilegedPackageNames));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class RestrictionSettings {
        final SparseArrayMap<String, PkgSettings> mRestrictionLevels;
        final /* synthetic */ AppRestrictionController this$0;

        final class PkgSettings {
            private int mCurrentRestrictionLevel;
            private long[] mLastNotificationShownTime;
            private int mLastRestrictionLevel;
            private long mLevelChangeTime;
            private int[] mNotificationId;
            private final String mPackageName;
            private int mReason;
            private final int mUid;
            final /* synthetic */ RestrictionSettings this$1;

            /* JADX INFO: renamed from: -$$Nest$fgetmCurrentRestrictionLevel, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m1371$$Nest$fgetmCurrentRestrictionLevel(PkgSettings r0) {
                return r0.mCurrentRestrictionLevel;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmLastNotificationShownTime, reason: not valid java name */
            static /* bridge */ /* synthetic */ long[] m1372$$Nest$fgetmLastNotificationShownTime(PkgSettings r0) {
                return r0.mLastNotificationShownTime;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmLevelChangeTime, reason: not valid java name */
            static /* bridge */ /* synthetic */ long m1373$$Nest$fgetmLevelChangeTime(PkgSettings r2) {
                return r2.mLevelChangeTime;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmReason, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m1374$$Nest$fgetmReason(PkgSettings r0) {
                return r0.mReason;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmCurrentRestrictionLevel, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m1375$$Nest$fputmCurrentRestrictionLevel(PkgSettings r0, int r1) {
                r0.mCurrentRestrictionLevel = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmLastRestrictionLevel, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m1376$$Nest$fputmLastRestrictionLevel(PkgSettings r0, int r1) {
                r0.mLastRestrictionLevel = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmLevelChangeTime, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m1377$$Nest$fputmLevelChangeTime(PkgSettings r0, long r1) {
                r0.mLevelChangeTime = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmReason, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m1378$$Nest$fputmReason(PkgSettings r0, int r1) {
                r0.mReason = r1;
            }

            PkgSettings(RestrictionSettings this$1, String packageName, int uid) {
                this.this$1 = this$1;
                this.mPackageName = packageName;
                this.mUid = uid;
                this.mLastRestrictionLevel = 0;
                this.mCurrentRestrictionLevel = 0;
            }

            int update(int level, int reason, int subReason) {
                if (level == this.mCurrentRestrictionLevel) goto L6;
                this.mLastRestrictionLevel = this.mCurrentRestrictionLevel;
                this.mCurrentRestrictionLevel = level;
                this.mLevelChangeTime = AppRestrictionController.m1348$$Nest$fgetmInjector(this.this$1.this$0).currentTimeMillis();
                this.mReason = (65280 & reason) | (subReason & 255);
                AppRestrictionController.m1343$$Nest$fgetmBgHandler(this.this$1.this$0).obtainMessage(1, this.mUid, level, this.mPackageName).sendToTarget();
            L6:
                return this.mLastRestrictionLevel;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder(128);
                sb.append("RestrictionLevel{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(':');
                sb.append(this.mPackageName);
                sb.append('/');
                sb.append(UserHandle.formatUid(this.mUid));
                sb.append('}');
                sb.append(' ');
                sb.append(ActivityManager.restrictionLevelToName(this.mCurrentRestrictionLevel));
                sb.append('(');
                sb.append(UsageStatsManager.reasonToString(this.mReason));
                sb.append(')');
                return sb.toString();
            }

            void dump(PrintWriter pw, long now) {
                Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$1.this$0);
                monitor-enter(r0);
                pw.print(toString());     // Catch: Throwable -> L7
                if (this.mLastRestrictionLevel == 0) goto L9;
                pw.print('/');     // Catch: Throwable -> L7
                pw.print(ActivityManager.restrictionLevelToName(this.mLastRestrictionLevel));     // Catch: Throwable -> L7
            L9:
                pw.print(" levelChange=");     // Catch: Throwable -> L7
                TimeUtils.formatDuration(this.mLevelChangeTime - now, pw);     // Catch: Throwable -> L7
                if (this.mLastNotificationShownTime == null) goto L18;
                int i = 0;
            L13:
                if (i >= this.mLastNotificationShownTime.length) goto L18;
                if (this.mLastNotificationShownTime[i] <= 0) goto L17;
                pw.print(" lastNoti(");     // Catch: Throwable -> L7
                AppRestrictionController.m1350$$Nest$fgetmNotificationHelper(this.this$1.this$0);     // Catch: Throwable -> L7
                pw.print(NotificationHelper.notificationTypeToString(i));     // Catch: Throwable -> L7
                pw.print(")=");     // Catch: Throwable -> L7
                TimeUtils.formatDuration(this.mLastNotificationShownTime[i] - now, pw);     // Catch: Throwable -> L7
            L17:
                i = i + 1;     // Catch: Throwable -> L7
            L18:
                monitor-exit(r0);     // Catch: Throwable -> L7
                pw.print(" effectiveExemption=");
                pw.print(PowerExemptionManager.reasonCodeToString(this.this$1.this$0.getBackgroundRestrictionExemptionReason(this.mUid)));
                return;
            L7:
                th = move-exception;
                throw th;
            }

            String getPackageName() {
                return this.mPackageName;
            }

            int getUid() {
                return this.mUid;
            }

            int getCurrentRestrictionLevel() {
                return this.mCurrentRestrictionLevel;
            }

            int getLastRestrictionLevel() {
                return this.mLastRestrictionLevel;
            }

            int getReason() {
                return this.mReason;
            }

            long getLastNotificationTime(int notificationType) {
                if (this.mLastNotificationShownTime != null) goto L7;
                return 0;
            L7:
                return this.mLastNotificationShownTime[notificationType];
            }

            void setLastNotificationTime(int notificationType, long timestamp) {
                setLastNotificationTime(notificationType, timestamp, true);
            }

            void setLastNotificationTime(int notificationType, long timestamp, boolean persist) {
                if (this.mLastNotificationShownTime != null) goto L5;
                this.mLastNotificationShownTime = new long[2];
            L5:
                this.mLastNotificationShownTime[notificationType] = timestamp;
                if (persist == true) goto L8;
                return;
            L8:
                if (AppRestrictionController.m1351$$Nest$fgetmRestrictionSettingsXmlLoaded(this.this$1.this$0).get() == false) goto L12;
                this.this$1.schedulePersistToXml(UserHandle.getUserId(this.mUid));
                return;
            }

            int getNotificationId(int notificationType) {
                if (this.mNotificationId != null) goto L7;
                return 0;
            L7:
                return this.mNotificationId[notificationType];
            }

            void setNotificationId(int notificationType, int notificationId) {
                if (this.mNotificationId != null) goto L5;
                this.mNotificationId = new int[2];
            L5:
                this.mNotificationId[notificationType] = notificationId;
            }

            void setLevelChangeTime(long timestamp) {
                this.mLevelChangeTime = timestamp;
            }

            public Object clone() {
                PkgSettings newObj = new PkgSettings(this.this$1, this.mPackageName, this.mUid);
                newObj.mCurrentRestrictionLevel = this.mCurrentRestrictionLevel;
                newObj.mLastRestrictionLevel = this.mLastRestrictionLevel;
                newObj.mLevelChangeTime = this.mLevelChangeTime;
                newObj.mReason = this.mReason;
                if (this.mLastNotificationShownTime == null) goto L6;
                newObj.mLastNotificationShownTime = Arrays.copyOf(this.mLastNotificationShownTime, this.mLastNotificationShownTime.length);
            L6:
                if (this.mNotificationId == null) goto L8;
                newObj.mNotificationId = Arrays.copyOf(this.mNotificationId, this.mNotificationId.length);
            L8:
                return newObj;
            }

            public boolean equals(Object other) {
                if (other != this) goto L6;
                return true;
            L6:
                if (other != null) goto L8;
            L29:
                return false;
            L8:
                if ((other instanceof PkgSettings) == false) goto L29;
                PkgSettings otherSettings = (PkgSettings) other;
                if (otherSettings.mUid != this.mUid) goto L28;
                if (otherSettings.mCurrentRestrictionLevel != this.mCurrentRestrictionLevel) goto L28;
                if (otherSettings.mLastRestrictionLevel != this.mLastRestrictionLevel) goto L28;
                if (otherSettings.mLevelChangeTime != this.mLevelChangeTime) goto L28;
                if (otherSettings.mReason != this.mReason) goto L28;
                if (TextUtils.equals(otherSettings.mPackageName, this.mPackageName) == false) goto L28;
                if (Arrays.equals(otherSettings.mLastNotificationShownTime, this.mLastNotificationShownTime) == false) goto L28;
                if (Arrays.equals(otherSettings.mNotificationId, this.mNotificationId) == false) goto L28;
                return true;
            L28:
                return false;
            }
        }

        public static /* synthetic */ void $r8$lambda$JN5jmrDzyU9x6w0DncYKD46bZBI(ArrayList r0, PkgSettings r1) {
            lambda$dump$1(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$m_m_lZ6NSW8FYf2K17fgT6bulJQ(PkgSettings r0) {
            lambda$resetToDefault$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetLastRestrictionLevel, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1370$$Nest$mgetLastRestrictionLevel(RestrictionSettings r0, int r1, String r2) {
            return r0.getLastRestrictionLevel(r1, r2);
        }

        RestrictionSettings(AppRestrictionController this$0) {
            this.this$0 = this$0;
            this.mRestrictionLevels = new SparseArrayMap();
        }

        int update(String packageName, int uid, int level, int reason, int subReason) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            PkgSettings settings = getRestrictionSettingsLocked(uid, packageName);     // Catch: Throwable -> L7
            if (settings != null) goto L9;
            settings = new PkgSettings(this, packageName, uid);     // Catch: Throwable -> L7
            this.mRestrictionLevels.add(uid, packageName, settings);     // Catch: Throwable -> L7
        L9:
            int r2 = settings.update(level, reason, subReason);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        int getReason(String packageName, int uid) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            PkgSettings settings = (PkgSettings) this.mRestrictionLevels.get(uid, packageName);     // Catch: Throwable -> L7
            if (settings == null) goto L9;
            int r2 = settings.getReason();     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L9:
            r2 = 256;
        L7:
            th = move-exception;
            throw th;
        }

        int getRestrictionLevel(int uid) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            int uidKeyIndex = this.mRestrictionLevels.indexOfKey(uid);     // Catch: Throwable -> L8
            if (uidKeyIndex >= 0) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return 0;
        L10:
            int numPackages = this.mRestrictionLevels.numElementsForKeyAt(uidKeyIndex);     // Catch: Throwable -> L8
            if (numPackages != 0) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return 0;
        L14:
            int level = 0;
            int i = 0;
        L15:
            if (i >= numPackages) goto L25;
            PkgSettings setting = (PkgSettings) this.mRestrictionLevels.valueAt(uidKeyIndex, i);     // Catch: Throwable -> L8
            if (setting == null) goto L23;
            int l = setting.getCurrentRestrictionLevel();     // Catch: Throwable -> L8
            if (level != 0) goto L21;
            int r7 = l;
        L22:
            level = r7;
            goto L23
        L21:
            r7 = Math.min(level, l);     // Catch: Throwable -> L8
        L23:
            i = i + 1;     // Catch: Throwable -> L8
            goto L15
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return level;
        L8:
            th = move-exception;
            throw th;
        }

        int getRestrictionLevel(int uid, String packageName) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            PkgSettings settings = getRestrictionSettingsLocked(uid, packageName);     // Catch: Throwable -> L7
            if (settings != null) goto L9;
            int r2 = getRestrictionLevel(uid);     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L9:
            r2 = settings.getCurrentRestrictionLevel();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        int getRestrictionLevel(String packageName, int userId) {
            PackageManagerInternal pm = AppRestrictionController.m1348$$Nest$fgetmInjector(this.this$0).getPackageManagerInternal();
            int uid = pm.getPackageUid(packageName, 819200, userId);
            return getRestrictionLevel(uid, packageName);
        }

        private int getLastRestrictionLevel(int uid, String packageName) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            PkgSettings settings = (PkgSettings) this.mRestrictionLevels.get(uid, packageName);     // Catch: Throwable -> L10
            if (settings != null) goto L7;
            int r2 = 0;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r2;
        L7:
            r2 = settings.getLastRestrictionLevel();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        void forEachPackageInUidLocked(int uid, TriConsumer<String, Integer, Integer> consumer) {
            int uidKeyIndex = this.mRestrictionLevels.indexOfKey(uid);
            if (uidKeyIndex >= 0) goto L5;
            return;
        L5:
            int numPackages = this.mRestrictionLevels.numElementsForKeyAt(uidKeyIndex);
            int i = 0;
        L6:
            if (i >= numPackages) goto L9;
            PkgSettings settings = (PkgSettings) this.mRestrictionLevels.valueAt(uidKeyIndex, i);
            consumer.accept((String) this.mRestrictionLevels.keyAt(uidKeyIndex, i), Integer.valueOf(settings.getCurrentRestrictionLevel()), Integer.valueOf(settings.getReason()));
            i = i + 1;
            goto L6
        }

        void forEachUidLocked(Consumer<Integer> consumer) {
            int i = this.mRestrictionLevels.numMaps() - 1;
        L3:
            if (i < 0) goto L6;
            consumer.accept(Integer.valueOf(this.mRestrictionLevels.keyAt(i)));
            i = i - 1;
            goto L3
        }

        PkgSettings getRestrictionSettingsLocked(int uid, String packageName) {
            return (PkgSettings) this.mRestrictionLevels.get(uid, packageName);
        }

        void removeUser(int userId) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            int i = this.mRestrictionLevels.numMaps() - 1;     // Catch: Throwable -> L11
        L5:
            if (i < 0) goto L14;
            int uid = this.mRestrictionLevels.keyAt(i);     // Catch: Throwable -> L11
            if (UserHandle.getUserId(uid) != userId) goto L10;
            this.mRestrictionLevels.deleteAt(i);     // Catch: Throwable -> L11
        L10:
            i = i - 1;     // Catch: Throwable -> L11
            goto L5
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        void removePackage(String pkgName, int uid) {
            removePackage(pkgName, uid, true);
        }

        void removePackage(String pkgName, int uid, boolean persist) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            int keyIndex = this.mRestrictionLevels.indexOfKey(uid);     // Catch: Throwable -> L9
            this.mRestrictionLevels.delete(uid, pkgName);     // Catch: Throwable -> L9
            if (keyIndex >= 0) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (persist == true) goto L14;
            return;
        L14:
            if (AppRestrictionController.m1351$$Nest$fgetmRestrictionSettingsXmlLoaded(this.this$0).get() == false) goto L22;
            schedulePersistToXml(UserHandle.getUserId(uid));
            return;
        L22:
            return;
        L7:
            if (this.mRestrictionLevels.numElementsForKeyAt(keyIndex) != 0) goto L11;
            this.mRestrictionLevels.deleteAt(keyIndex);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        void removeUid(int uid) {
            removeUid(uid, true);
        }

        void removeUid(int uid, boolean persist) {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            this.mRestrictionLevels.delete(uid);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            if (persist == true) goto L8;
            return;
        L8:
            if (AppRestrictionController.m1351$$Nest$fgetmRestrictionSettingsXmlLoaded(this.this$0).get() == false) goto L17;
            schedulePersistToXml(UserHandle.getUserId(uid));
            return;
        L17:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        void reset() {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            int i = this.mRestrictionLevels.numMaps() - 1;     // Catch: Throwable -> L7
        L5:
            if (i < 0) goto L10;
            this.mRestrictionLevels.deleteAt(i);     // Catch: Throwable -> L7
            i = i - 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void resetToDefault() {
            Object r0 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            this.mRestrictionLevels.forEach(new AppRestrictionController$RestrictionSettings$$ExternalSyntheticLambda2());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$resetToDefault$0(PkgSettings settings) {
            PkgSettings.m1375$$Nest$fputmCurrentRestrictionLevel(settings, 0);
            PkgSettings.m1376$$Nest$fputmLastRestrictionLevel(settings, 0);
            PkgSettings.m1377$$Nest$fputmLevelChangeTime(settings, 0);
            PkgSettings.m1378$$Nest$fputmReason(settings, 256);
            if (PkgSettings.m1372$$Nest$fgetmLastNotificationShownTime(settings) == null) goto L8;
            int i = 0;
        L6:
            if (i >= PkgSettings.m1372$$Nest$fgetmLastNotificationShownTime(settings).length) goto L10;
            PkgSettings.m1372$$Nest$fgetmLastNotificationShownTime(settings)[i] = 0;
            i = i + 1;
            goto L6
        L10:
            return;
        }

        void dump(PrintWriter pw, String prefix) {
            final ArrayList<PkgSettings> settings = new ArrayList();
            Object r1 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r1);
            this.mRestrictionLevels.forEach(new AppRestrictionController$RestrictionSettings$$ExternalSyntheticLambda0(settings));     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            Collections.sort(settings, Comparator.comparingInt(new AppRestrictionController$RestrictionSettings$$ExternalSyntheticLambda1()));
            long now = AppRestrictionController.m1348$$Nest$fgetmInjector(this.this$0).currentTimeMillis();
            int i = 0;
            int size = settings.size();
        L7:
            if (i >= size) goto L10;
            pw.print(prefix);
            pw.print('#');
            pw.print(i);
            pw.print(' ');
            settings.get(i).dump(pw, now);
            pw.println();
            i = i + 1;
            goto L7
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$dump$1(ArrayList settings, PkgSettings setting) {
            settings.add(setting);
        }

        void schedulePersistToXml(int userId) {
            AppRestrictionController.m1343$$Nest$fgetmBgHandler(this.this$0).obtainMessage(11, userId, 0).sendToTarget();
        }

        void scheduleLoadFromXml() {
            AppRestrictionController.m1343$$Nest$fgetmBgHandler(this.this$0).sendEmptyMessage(10);
        }

        File getXmlFileNameForUser(int userId) {
            File dir = new File(AppRestrictionController.m1348$$Nest$fgetmInjector(this.this$0).getDataSystemDeDirectory(userId), AppRestrictionController.APP_RESTRICTION_SETTINGS_DIRNAME);
            return new File(dir, AppRestrictionController.APP_RESTRICTION_SETTINGS_FILENAME);
        }

        void loadFromXml(boolean applyLevel) {
            int[] allUsers = AppRestrictionController.m1348$$Nest$fgetmInjector(this.this$0).getUserManagerInternal().getUserIds();
            int r1 = allUsers.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            int userId = allUsers[r2];
            loadFromXml(userId, applyLevel);
            r2 = r2 + 1;
            goto L3
        L5:
            AppRestrictionController.m1351$$Nest$fgetmRestrictionSettingsXmlLoaded(this.this$0).set(true);
        }

        void loadFromXml(int userId, boolean applyLevel) {
            File file = getXmlFileNameForUser(userId);
            if (file.exists() == true) goto L5;
            return;
        L5:
            long[] ts = new long[2];
            InputStream in = new FileInputStream(file);     // Catch: Throwable -> L36
            TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L24
            long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L24
        L9:
            int type = parser.next();     // Catch: Throwable -> L24
            if (type == 1) goto L27;
            if (type != 2) goto L9;
            String tagName = parser.getName();     // Catch: Throwable -> L24
            if ("settings".equals(tagName) == true) goto L19;
            Slog.w(AppRestrictionController.TAG, "Unexpected tag name: " + tagName);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Throwable r14 = th;
        L44:
            in.close();     // Catch: Throwable -> L33
            throw r14;     // Catch: Throwable -> L29 Throwable -> L29
        L33:
            th = move-exception;
            r14.addSuppressed(th);     // Catch: Throwable -> L29 Throwable -> L29
            throw r14;     // Catch: Throwable -> L29 Throwable -> L29
        L19:
            boolean applyLevel2 = applyLevel;
            loadOneFromXml(parser, now, ts, applyLevel2);     // Catch: Throwable -> L22
            applyLevel = applyLevel2;
        L22:
            th = move-exception;
            r14 = th;
            goto L44
        L27:
            in.close();     // Catch: Throwable -> L29
            return;
        L24:
            th = move-exception;
            r14 = th;
            goto L44
        L59:
            return;
        }

        private void loadOneFromXml(TypedXmlPullParser parser, long now, long[] ts, boolean applyLevel) {
            int i = 0;
        L3:
            long r5 = 0;
            if (i >= ts.length) goto L6;
            ts[i] = 0;
            i = i + 1;
            goto L3
        L6:
            long levelTs = 0;
            int i2 = 0;
            int uid = 0;
            String packageName = null;
            int curLevel = 0;
            int reason = 256;
        L7:
            int uid2 = parser.getAttributeCount();
            byte r7 = 0;
            if (i2 >= uid2) goto L41;
            String attrName = parser.getAttributeName(i2);     // Catch: IllegalArgumentException -> L15
            String attrValue = parser.getAttributeValue(i2);     // Catch: IllegalArgumentException -> L15
            switch(attrName.hashCode()) {
                case -934964668: goto L27;
                case -807062458: goto L24;
                case 115792: goto L21;
                case 69785859: goto L18;
                case 569868612: goto L13;
                default: goto L29;
            };     // Catch: IllegalArgumentException -> L15
        L29:
            r7 = -1;
        L30:
            switch(r7) {
                case 0: goto L37;
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                default: goto L31;
            };     // Catch: IllegalArgumentException -> L15
        L31:
            int type = NotificationHelper.notificationTimeAttrToType(attrName);     // Catch: IllegalArgumentException -> L15
            ts[type] = Long.parseLong(attrValue);     // Catch: IllegalArgumentException -> L15
            goto L39
        L32:
            int type2 = Integer.parseInt(attrValue);     // Catch: IllegalArgumentException -> L15
            reason = type2;
            goto L39
        L33:
            levelTs = Long.parseLong(attrValue);     // Catch: IllegalArgumentException -> L15
            goto L39
        L34:
            curLevel = Integer.parseInt(attrValue);     // Catch: IllegalArgumentException -> L15
            goto L39
        L35:
            packageName = attrValue;
            goto L39
        L37:
            uid = Integer.parseInt(attrValue);     // Catch: IllegalArgumentException -> L15
            goto L39
        L13:
            if (attrName.equals(AppRestrictionController.ATTR_CUR_LEVEL) == false) goto L29;
            r7 = 2;
            goto L30
        L18:
            if (attrName.equals(AppRestrictionController.ATTR_LEVEL_TS) == false) goto L29;
            r7 = 3;
            goto L30
        L21:
            if (attrName.equals("uid") == false) goto L29;
        L24:
            if (attrName.equals("package") == false) goto L29;
            r7 = 1;
            goto L30
        L27:
            if (attrName.equals("reason") == false) goto L29;
            r7 = 4;
        L39:
            i2 = i2 + 1;
            goto L7
        L41:
            if (uid == 0) goto L85;
            Object r8 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r8);
            PkgSettings pkgSettings = getRestrictionSettingsLocked(uid, packageName);     // Catch: Throwable -> L78
            if (pkgSettings != null) goto L51;
            monitor-exit(r8);     // Catch: Throwable -> L49
            return;
        L51:
            int i3 = 0;
        L53:
            if (i3 >= ts.length) goto L61;
            if (pkgSettings.getLastNotificationTime(i3) != r5) goto L59;
            if (ts[i3] == r5) goto L59;
            pkgSettings.setLastNotificationTime(i3, ts[i3], false);     // Catch: Throwable -> L49
        L59:
            i3 = i3 + 1;
            r5 = 0;
            goto L53
        L61:
            int i4 = PkgSettings.m1371$$Nest$fgetmCurrentRestrictionLevel(pkgSettings);     // Catch: Throwable -> L78
            if (i4 < curLevel) goto L65;
            monitor-exit(r8);     // Catch: Throwable -> L49
            return;
        L65:
            monitor-exit(r8);     // Catch: Throwable -> L78
            long levelTs2 = levelTs;
            String packageName2 = packageName;
            int curBucket = AppRestrictionController.m1348$$Nest$fgetmInjector(this.this$0).getAppStandbyInternal().getAppStandbyBucket(packageName2, UserHandle.getUserId(uid), now, false);
            if (applyLevel == false) goto L69;
            PkgSettings pkgSettings2 = pkgSettings;
            this.this$0.applyRestrictionLevel(packageName2, uid, curLevel, AppRestrictionController.m1347$$Nest$fgetmEmptyTrackerInfo(this.this$0), curBucket, true, reason & JobPackageTracker.EVENT_STOP_REASON_MASK, reason & 255);
        L70:
            Object r9 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r9);
            pkgSettings2.setLevelChangeTime(levelTs2);     // Catch: Throwable -> L75
            monitor-exit(r9);     // Catch: Throwable -> L75
            return;
        L75:
            th = move-exception;
            throw th;
        L69:
            pkgSettings2 = pkgSettings;
            pkgSettings2.update(curLevel, 65280 & reason, reason & 255);
        L49:
            th = th;
        L90:
            monitor-exit(r8);     // Catch: Throwable -> L82
            throw th;
        L82:
            th = th;
        L78:
            th = th;
            goto L90
        }

        void persistToXml(int userId) {
            File file = getXmlFileNameForUser(userId);
            File dir = file.getParentFile();
            if (dir.isDirectory() == false) goto L5;
        L8:
            AtomicFile atomicFile = new AtomicFile(file);
            FileOutputStream stream = null;
            stream = atomicFile.startWrite();     // Catch: Exception -> L12
            stream.write(toXmlByteArray(userId));     // Catch: Exception -> L12
            atomicFile.finishWrite(stream);
            return;
        L12:
            e = move-exception;
            Slog.e(AppRestrictionController.TAG, "Failed to write file " + file, e);
            if (stream == null) goto L19;
            atomicFile.failWrite(stream);
            return;
        L19:
            return;
        L5:
            if (dir.mkdirs() == true) goto L8;
            Slog.w(AppRestrictionController.TAG, "Failed to create folder for " + userId);
        }

        private byte[] toXmlByteArray(int userId) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();     // Catch: IOException -> L27
            TypedXmlSerializer serializer = Xml.resolveSerializer(os);     // Catch: Throwable -> L29
            serializer.startDocument(null, true);     // Catch: Throwable -> L29
            Object r4 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);     // Catch: Throwable -> L29
            monitor-enter(r4);     // Catch: Throwable -> L29
            int i = this.mRestrictionLevels.numMaps() - 1;     // Catch: Throwable -> L17
        L7:
            if (i < 0) goto L23;
            int j = this.mRestrictionLevels.numElementsForKeyAt(i) - 1;     // Catch: Throwable -> L17
        L9:
            if (j < 0) goto L21;
            PkgSettings settings = (PkgSettings) this.mRestrictionLevels.valueAt(i, j);     // Catch: Throwable -> L17
            int uid = settings.getUid();     // Catch: Throwable -> L17
            if (UserHandle.getUserId(uid) != userId) goto L20;
            serializer.startTag(null, "settings");     // Catch: Throwable -> L17
            serializer.attributeInt(null, "uid", uid);     // Catch: Throwable -> L17
            serializer.attribute(null, "package", settings.getPackageName());     // Catch: Throwable -> L17
            serializer.attributeInt(null, AppRestrictionController.ATTR_CUR_LEVEL, PkgSettings.m1371$$Nest$fgetmCurrentRestrictionLevel(settings));     // Catch: Throwable -> L17
            serializer.attributeLong(null, AppRestrictionController.ATTR_LEVEL_TS, PkgSettings.m1373$$Nest$fgetmLevelChangeTime(settings));     // Catch: Throwable -> L17
            serializer.attributeInt(null, "reason", PkgSettings.m1374$$Nest$fgetmReason(settings));     // Catch: Throwable -> L17
            int k = 0;
        L15:
            if (k >= 2) goto L19;
            serializer.attributeLong(null, NotificationHelper.notificationTypeToTimeAttr(k), settings.getLastNotificationTime(k));     // Catch: Throwable -> L17
            k = k + 1;     // Catch: Throwable -> L17
            goto L15
        L19:
            serializer.endTag(null, "settings");     // Catch: Throwable -> L17
        L20:
            j = j - 1;     // Catch: Throwable -> L17
            goto L9
        L21:
            i = i - 1;     // Catch: Throwable -> L17
            goto L7
        L23:
            monitor-exit(r4);     // Catch: Throwable -> L17
            serializer.endDocument();     // Catch: Throwable -> L29
            serializer.flush();     // Catch: Throwable -> L29
            byte[] r3 = os.toByteArray();     // Catch: Throwable -> L29
            os.close();     // Catch: IOException -> L27
            return r3;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            os.close();     // Catch: Throwable -> L35
        L37:
            throw th;     // Catch: IOException -> L27
        L35:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L27
        L39:
            return null;
        }

        void removeXml() {
            int[] allUsers = AppRestrictionController.m1348$$Nest$fgetmInjector(this.this$0).getUserManagerInternal().getUserIds();
            int r1 = allUsers.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            int userId = allUsers[r2];
            getXmlFileNameForUser(userId).delete();
            r2 = r2 + 1;
            goto L3
        }

        public Object clone() {
            RestrictionSettings newObj = new RestrictionSettings(this.this$0);
            Object r1 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r1);
            int i = this.mRestrictionLevels.numMaps() - 1;     // Catch: Throwable -> L9
        L5:
            if (i < 0) goto L13;
            int j = this.mRestrictionLevels.numElementsForKeyAt(i) - 1;     // Catch: Throwable -> L9
        L7:
            if (j < 0) goto L11;
            PkgSettings settings = (PkgSettings) this.mRestrictionLevels.valueAt(i, j);     // Catch: Throwable -> L9
            newObj.mRestrictionLevels.add(this.mRestrictionLevels.keyAt(i), (String) this.mRestrictionLevels.keyAt(i, j), (PkgSettings) settings.clone());     // Catch: Throwable -> L9
            j = j - 1;     // Catch: Throwable -> L9
            goto L7
        L11:
            i = i - 1;     // Catch: Throwable -> L9
            goto L5
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return newObj;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean equals(Object other) {
            if (other != this) goto L6;
            return true;
        L6:
            if (other != null) goto L8;
        L37:
            return false;
        L8:
            if ((other instanceof RestrictionSettings) == false) goto L37;
            SparseArrayMap<String, PkgSettings> otherSettings = ((RestrictionSettings) other).mRestrictionLevels;
            Object r3 = AppRestrictionController.m1352$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r3);
        L16:
            th = move-exception;
            throw th;
        L13:
            if (otherSettings.numMaps() == this.mRestrictionLevels.numMaps()) goto L18;
            monitor-exit(r3);     // Catch: Throwable -> L16
            return false;
        L18:
            int i = this.mRestrictionLevels.numMaps() - 1;     // Catch: Throwable -> L16
        L19:
            if (i < 0) goto L33;
            int uid = this.mRestrictionLevels.keyAt(i);     // Catch: Throwable -> L16
            if (otherSettings.numElementsForKey(uid) != this.mRestrictionLevels.numElementsForKeyAt(i)) goto L22;
            int j = this.mRestrictionLevels.numElementsForKeyAt(i) - 1;     // Catch: Throwable -> L16
        L25:
            if (j < 0) goto L31;
            PkgSettings settings = (PkgSettings) this.mRestrictionLevels.valueAt(i, j);     // Catch: Throwable -> L16
            if (settings.equals(otherSettings.get(uid, settings.getPackageName())) == false) goto L28;
            j = j - 1;     // Catch: Throwable -> L16
            goto L25
        L28:
            monitor-exit(r3);     // Catch: Throwable -> L16
            return false;
        L31:
            i = i - 1;     // Catch: Throwable -> L16
            goto L19
        L22:
            monitor-exit(r3);     // Catch: Throwable -> L16
            return false;
        L33:
            monitor-exit(r3);     // Catch: Throwable -> L16
            return true;
        }
    }

    private class TrackerInfo {
        final byte[] mInfo;
        final int mType;

        TrackerInfo(AppRestrictionController r1) {
            this.mType = 0;
            this.mInfo = null;
        }

        TrackerInfo(AppRestrictionController r1, int type, byte[] info) {
            this.mType = type;
            this.mInfo = info;
        }
    }

    @interface TrackerType {
    }

    interface UidBatteryUsageProvider {
        AppBatteryTracker.ImmutableBatteryUsage getUidBatteryUsage(int r1);
    }

    public static /* synthetic */ void $r8$lambda$C90gSwy4qIsl8Y3wdIptCUOaeAE(AppRestrictionController r0, AppStandbyInternal r1, String r2, int r3, int r4, int r5, int r6, int r7, TrackerInfo r8) {
        r0.lambda$applyRestrictionLevel$1(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: $r8$lambda$EB-EiOMlR4mEiHsXx47zeZChYJY, reason: not valid java name */
    public static /* synthetic */ void m1339$r8$lambda$EBEiOMlR4mEiHsXx47zeZChYJY(AppStandbyInternal r0, String r1, Integer r2, Integer r3) {
        lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$FtkCfwU6MEYv3FLycKPhyJHp3fA(AppRestrictionController r0, String r1, UserHandle r2) {
        r0.onRoleHoldersChanged(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$IBHoNjdS0p0ljscWEhgRfJKdC1k(ArrayList r0, boolean r1, AppStandbyInternal r2, Integer r3, String r4, Integer r5, Integer r6) {
        lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$5(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$WVvwlryYxT2AxDDMgtbHDqF9YZo(AppStandbyInternal r0, String r1, Integer r2, Integer r3) {
        lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$_ydL4E-eseJqSvYCC9_LF-yu1d4, reason: not valid java name */
    public static /* synthetic */ void m1340$r8$lambda$_ydL4EeseJqSvYCC9_LFyu1d4(int r0, String r1, int r2, ActivityManagerInternal.AppBackgroundRestrictionListener r3) {
        lambda$dispatchAppRestrictionLevelChanges$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$cCOwIzhwVMmMXJ70sQK3rFQtGL0(AppRestrictionController r0) {
        r0.lambda$onSystemReady$0();
    }

    public static /* synthetic */ void $r8$lambda$dQlSmja9BFi8lzUkFPpqj6AfbgU(AppStandbyInternal r0, String r1, int r2, Integer r3) {
        lambda$handleUidActive$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$eI8UzIOTzZzh0kKu72jmLf9aSvE(boolean r0, ActivityManagerInternal.AppBackgroundRestrictionListener r1) {
        lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oY7vGD6ZBYgVNvNPzUZAGcXnf7g(AppRestrictionController r0, int r1, AppStandbyInternal r2, int r3, String r4, Integer r5, Integer r6) {
        r0.lambda$handleUidActive$9(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$vjNA8_CL3X8l1i-hIsSd-D4C2js, reason: not valid java name */
    public static /* synthetic */ void m1341$r8$lambda$vjNA8_CL3X8l1ihIsSdD4C2js(AppRestrictionController r0, ArrayList r1, boolean r2, AppStandbyInternal r3, Integer r4) {
        r0.lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$6(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppStateTrackers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m1342$$Nest$fgetmAppStateTrackers(AppRestrictionController r0) {
        return r0.mAppStateTrackers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBgHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ BgHandler m1343$$Nest$fgetmBgHandler(AppRestrictionController r0) {
        return r0.mBgHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCarrierPrivilegedApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m1344$$Nest$fgetmCarrierPrivilegedApps(AppRestrictionController r0) {
        return r0.mCarrierPrivilegedApps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCarrierPrivilegedLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1345$$Nest$fgetmCarrierPrivilegedLock(AppRestrictionController r0) {
        return r0.mCarrierPrivilegedLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConstantsObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConstantsObserver m1346$$Nest$fgetmConstantsObserver(AppRestrictionController r0) {
        return r0.mConstantsObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEmptyTrackerInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ TrackerInfo m1347$$Nest$fgetmEmptyTrackerInfo(AppRestrictionController r0) {
        return r0.mEmptyTrackerInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m1348$$Nest$fgetmInjector(AppRestrictionController r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1349$$Nest$fgetmLock(AppRestrictionController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationHelper m1350$$Nest$fgetmNotificationHelper(AppRestrictionController r0) {
        return r0.mNotificationHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRestrictionSettingsXmlLoaded, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m1351$$Nest$fgetmRestrictionSettingsXmlLoaded(AppRestrictionController r0) {
        return r0.mRestrictionSettingsXmlLoaded;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettingsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1352$$Nest$fgetmSettingsLock(AppRestrictionController r0) {
        return r0.mSettingsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchAppRestrictionLevelChanges, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1353$$Nest$mdispatchAppRestrictionLevelChanges(AppRestrictionController r0, int r1, String r2, int r3) {
        r0.dispatchAppRestrictionLevelChanges(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchAutoRestrictedBucketFeatureFlagChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1354$$Nest$mdispatchAutoRestrictedBucketFeatureFlagChanged(AppRestrictionController r0, boolean r1) {
        r0.dispatchAutoRestrictedBucketFeatureFlagChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAppStandbyBucketChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1355$$Nest$mhandleAppStandbyBucketChanged(AppRestrictionController r0, int r1, String r2, int r3) {
        r0.handleAppStandbyBucketChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBackgroundRestrictionChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1356$$Nest$mhandleBackgroundRestrictionChanged(AppRestrictionController r0, int r1, String r2, boolean r3) {
        r0.handleBackgroundRestrictionChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monLockedBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1357$$Nest$monLockedBootCompleted(AppRestrictionController r0) {
        r0.onLockedBootCompleted();
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1358$$Nest$monPackageRemoved(AppRestrictionController r0, String r1, int r2) {
        r0.onPackageRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPropertiesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1359$$Nest$monPropertiesChanged(AppRestrictionController r0, String r1) {
        r0.onPropertiesChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUidAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1360$$Nest$monUidAdded(AppRestrictionController r0, int r1) {
        r0.onUidAdded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUidRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1361$$Nest$monUidRemoved(AppRestrictionController r0, int r1) {
        r0.onUidRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1362$$Nest$monUserAdded(AppRestrictionController r0, int r1) {
        r0.onUserAdded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserInteractionStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1363$$Nest$monUserInteractionStarted(AppRestrictionController r0, String r1, int r2) {
        r0.onUserInteractionStarted(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1364$$Nest$monUserRemoved(AppRestrictionController r0, int r1) {
        r0.onUserRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1365$$Nest$monUserStarted(AppRestrictionController r0, int r1) {
        r0.onUserStarted(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1366$$Nest$monUserStopped(AppRestrictionController r0, int r1) {
        r0.onUserStopped(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterCarrierPrivilegesCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1367$$Nest$mregisterCarrierPrivilegesCallbacks(AppRestrictionController r0) {
        r0.registerCarrierPrivilegesCallbacks();
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterCarrierPrivilegesCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1368$$Nest$munregisterCarrierPrivilegesCallbacks(AppRestrictionController r0) {
        r0.unregisterCarrierPrivilegesCallbacks();
    }

    static {
        ROLES_IN_INTEREST = new String[]{"android.app.role.DIALER", "android.app.role.EMERGENCY"};
    }

    public void addAppBackgroundRestrictionListener(ActivityManagerInternal.AppBackgroundRestrictionListener listener) {
        this.mRestrictionListeners.add(listener);
    }

    AppRestrictionController(Context context, ActivityManagerService service) {
        this(new Injector(context), service);
    }

    AppRestrictionController(Injector injector, ActivityManagerService service) {
        this.mAppStateTrackers = new ArrayList();
        this.mRestrictionSettings = new RestrictionSettings(this);
        this.mRestrictionListeners = new CopyOnWriteArraySet();
        this.mActiveUids = new SparseArrayMap();
        this.mTmpRunnables = new ArrayList();
        this.mDeviceIdleAllowlist = new int[0];
        this.mDeviceIdleExceptIdleAllowlist = new int[0];
        this.mSystemDeviceIdleAllowlist = new ArraySet();
        this.mSystemDeviceIdleExceptIdleAllowlist = new ArraySet();
        this.mLock = new Object();
        this.mSettingsLock = new Object();
        this.mRoleHolderChangedListener = new AppRestrictionController$$ExternalSyntheticLambda8(this);
        this.mUidRolesMapping = new SparseArray();
        this.mSystemModulesCache = new HashMap();
        this.mCarrierPrivilegedLock = new Object();
        this.mCarrierPrivilegedApps = new SparseArray();
        this.mRestrictionSettingsXmlLoaded = new AtomicBoolean();
        this.mLockedBootCompleted = false;
        this.mEmptyTrackerInfo = new TrackerInfo(this);
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mBootReceiver = new AnonymousClass2(this);
        this.mBackgroundRestrictionListener = new AnonymousClass3(this);
        this.mAppIdleStateChangeListener = new AnonymousClass4(this);
        this.mUidObserver = new AnonymousClass5(this);
        this.mInjector = injector;
        this.mContext = injector.getContext();
        this.mActivityManagerService = service;
        this.mBgHandlerThread = new HandlerThread("bgres-controller", 10);
        this.mBgHandlerThread.start();
        this.mBgHandler = new BgHandler(this.mBgHandlerThread.getLooper(), injector);
        this.mBgExecutor = new HandlerExecutor(this.mBgHandler);
        this.mConstantsObserver = new ConstantsObserver(this, this.mBgHandler, this.mContext);
        this.mNotificationHelper = new NotificationHelper(this);
        injector.initAppStateTrackers(this);
        this.mExecutor = new HandlerExecutor(injector.getDefaultHandler());
    }

    void onSystemReady() {
        DeviceConfig.addOnPropertiesChangedListener("activity_manager", this.mBgExecutor, this.mConstantsObserver);
        this.mConstantsObserver.start();
        initBgRestrictionExemptioFromSysConfig();
        initRestrictionStates();
        initSystemModuleNames();
        initRolesInInterest();
        registerForUidObservers();
        registerForSystemBroadcasts();
        registerCarrierPrivilegesCallbacks();
        this.mNotificationHelper.onSystemReady();
        this.mInjector.getAppStateTracker().addBackgroundRestrictedAppListener(this.mBackgroundRestrictionListener);
        this.mInjector.getAppStandbyInternal().addListener(this.mAppIdleStateChangeListener);
        this.mInjector.getRoleManager().addOnRoleHoldersChangedListenerAsUser(this.mExecutor, this.mRoleHolderChangedListener, UserHandle.ALL);
        this.mInjector.scheduleInitTrackers(this.mBgHandler, new AppRestrictionController$$ExternalSyntheticLambda10(this));
    }

    private /* synthetic */ void lambda$onSystemReady$0() {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onSystemReady();
        i = i + 1;
        goto L3
    }

    void resetRestrictionSettings() {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        this.mRestrictionSettings.reset();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        initRestrictionStates();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void tearDown() {
        DeviceConfig.removeOnPropertiesChangedListener(this.mConstantsObserver);
        unregisterForUidObservers();
        unregisterForSystemBroadcasts();
        this.mRestrictionSettings.removeXml();
    }

    private void initBgRestrictionExemptioFromSysConfig() {
        SystemConfig sysConfig = SystemConfig.getInstance();
        this.mBgRestrictionExemptioFromSysConfig = sysConfig.getBgRestrictionExemption();
        loadAppIdsFromPackageList(sysConfig.getAllowInPowerSaveExceptIdle(), this.mSystemDeviceIdleExceptIdleAllowlist);
        loadAppIdsFromPackageList(sysConfig.getAllowInPowerSave(), this.mSystemDeviceIdleAllowlist);
    }

    private void loadAppIdsFromPackageList(ArraySet<String> packages, ArraySet<Integer> apps) {
        PackageManager pm = this.mInjector.getPackageManager();
        int i = packages.size() - 1;
    L3:
        if (i < 0) goto L13;
        String pkg = packages.valueAt(i);
        ApplicationInfo ai = pm.getApplicationInfo(pkg, 1048576);     // Catch: PackageManager.NameNotFoundException -> L10
        if (ai == null) goto L11;
        apps.add(Integer.valueOf(UserHandle.getAppId(ai.uid)));     // Catch: PackageManager.NameNotFoundException -> L10
    L11:
        i = i - 1;
        goto L3
    }

    private boolean isExemptedFromSysConfig(String packageName) {
        if (this.mBgRestrictionExemptioFromSysConfig != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mBgRestrictionExemptioFromSysConfig.contains(packageName) == false) goto L7;
        return true;
    }

    private void initRestrictionStates() {
        int[] allUsers = this.mInjector.getUserManagerInternal().getUserIds();
        int r1 = allUsers.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        int userId = allUsers[r3];
        refreshAppRestrictionLevelForUser(userId, 1024, 2);
        r3 = r3 + 1;
        goto L3
    L6:
        if (this.mInjector.isTest() == true) goto L11;
        this.mRestrictionSettings.scheduleLoadFromXml();
        int r4 = allUsers.length;
    L9:
        if (r2 >= r4) goto L14;
        int userId2 = allUsers[r2];
        this.mRestrictionSettings.schedulePersistToXml(userId2);
        r2 = r2 + 1;
        goto L9
    L14:
        return;
    }

    private void initSystemModuleNames() {
        PackageManager pm = this.mInjector.getPackageManager();
        List<ModuleInfo> moduleInfos = pm.getInstalledModules(0);
        if (moduleInfos != null) goto L5;
        return;
    L5:
        HashMap<String, Boolean> r2 = this.mSystemModulesCache;
        monitor-enter(r2);
        Iterator<ModuleInfo> r3 = moduleInfos.iterator();     // Catch: Throwable -> L11
    L9:
        if (r3.hasNext() == false) goto L13;
        ModuleInfo info = r3.next();     // Catch: Throwable -> L11
        this.mSystemModulesCache.put(info.getPackageName(), Boolean.TRUE);     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isSystemModule(String packageName) {
        HashMap<String, Boolean> r0 = this.mSystemModulesCache;
        monitor-enter(r0);
        Boolean val = this.mSystemModulesCache.get(packageName);     // Catch: Throwable -> L9
        if (val == null) goto L12;
        boolean r2 = val.booleanValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManager pm = this.mInjector.getPackageManager();
        boolean isSystemModule = false;
        boolean isSystemModule2 = true;
        if (pm.getModuleInfo(packageName, 0) == null) goto L17;
        boolean r4 = true;
    L18:
        isSystemModule = r4;
        goto L20
    L17:
        r4 = false;
    L20:
        if (isSystemModule == false) goto L41;
    L30:
        isSystemModule2 = isSystemModule;
    L31:
        HashMap<String, Boolean> r3 = this.mSystemModulesCache;
        monitor-enter(r3);
        this.mSystemModulesCache.put(packageName, Boolean.valueOf(isSystemModule2));     // Catch: Throwable -> L36
        monitor-exit(r3);     // Catch: Throwable -> L36
        return isSystemModule2;
    L36:
        th = move-exception;
        throw th;
    L41:
        PackageInfo pkg = pm.getPackageInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L26
        if (pkg == null) goto L28;
        if (pkg.applicationInfo.sourceDir.startsWith(Environment.getApexDirectory().getAbsolutePath()) == true) goto L31;
    L28:
        isSystemModule2 = false;
    L9:
        th = move-exception;
        throw th;
    }

    private void registerForUidObservers() {
        this.mInjector.getIActivityManager().registerUidObserver(this.mUidObserver, 15, 4, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: RemoteException -> L4
        return;
    }

    private void unregisterForUidObservers() {
        this.mInjector.getIActivityManager().unregisterUidObserver(this.mUidObserver);     // Catch: RemoteException -> L4
        return;
    }

    private void refreshAppRestrictionLevelForUser(int userId, int reason, int subReason) {
        List<AppStandbyInfo> appStandbyInfos = this.mInjector.getAppStandbyInternal().getAppStandbyBuckets(userId);
        if (ArrayUtils.isEmpty(appStandbyInfos) == false) goto L5;
        return;
    L5:
        PackageManagerInternal pm = this.mInjector.getPackageManagerInternal();
        Iterator<AppStandbyInfo> r11 = appStandbyInfos.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        AppStandbyInfo info = r11.next();
        int uid = pm.getPackageUid(info.mPackageName, 819200, userId);
        if (uid < 0) goto L10;
        Pair<Integer, TrackerInfo> levelTypePair = calcAppRestrictionLevel(userId, uid, info.mPackageName, info.mStandbyBucket, false, false);
        applyRestrictionLevel(info.mPackageName, uid, ((Integer) levelTypePair.first).intValue(), (TrackerInfo) levelTypePair.second, info.mStandbyBucket, true, reason, subReason);
        goto L7
    L10:
        Slog.e(TAG, "Unable to find " + info.mPackageName + "/u" + userId);
        goto L7
    }

    void refreshAppRestrictionLevelForUid(int uid, int reason, int subReason, boolean allowRequestBgRestricted) {
        AppRestrictionController r0 = this;
        int r2 = uid;
        String[] packages = r0.mInjector.getPackageManager().getPackagesForUid(r2);
        if (ArrayUtils.isEmpty(packages) == false) goto L5;
        return;
    L5:
        AppStandbyInternal appStandbyInternal = r0.mInjector.getAppStandbyInternal();
        int userId = UserHandle.getUserId(r2);
        long now = SystemClock.elapsedRealtime();
        int r10 = packages.length;
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L8;
        String pkg = packages[r11];
        int userId2 = userId;
        int curBucket = appStandbyInternal.getAppStandbyBucket(pkg, userId2, now, false);
        Pair<Integer, TrackerInfo> levelTypePair = r0.calcAppRestrictionLevel(userId2, r2, pkg, curBucket, allowRequestBgRestricted, true);
        r2 = uid;
        r0 = this;
        r0.applyRestrictionLevel(pkg, r2, ((Integer) levelTypePair.first).intValue(), (TrackerInfo) levelTypePair.second, curBucket, true, reason, subReason);
        r11 = r11 + 1;
        appStandbyInternal = appStandbyInternal;
        now = now;
        userId = userId2;
        goto L6
    }

    private Pair<Integer, TrackerInfo> calcAppRestrictionLevel(int userId, int uid, String packageName, int standbyBucket, boolean allowRequestBgRestricted, boolean calcTrackers) {
        if (this.mInjector.getAppHibernationInternal().isHibernatingForUser(packageName, userId) == true) goto L5;
        TrackerInfo trackerInfo = null;
        switch(standbyBucket) {
            case 5: goto L30;
            case 50: goto L11;
            default: goto L11;
        };
    L30:
        int level = 20;
    L32:
        return new Pair(Integer.valueOf(level), trackerInfo);
    L11:
        if (this.mInjector.getAppStateTracker().isAppBackgroundRestricted(uid, packageName) == false) goto L15;
        return new Pair(50, this.mEmptyTrackerInfo);
    L15:
        if (standbyBucket != 45) goto L17;
        level = 40;
    L19:
        if (calcTrackers == false) goto L32;
        Pair<Integer, TrackerInfo> levelTypePair = calcAppRestrictionLevelFromTackers(uid, packageName, 100);
        int l = ((Integer) levelTypePair.first).intValue();
        if (l == 20) goto L23;
        if (l <= level) goto L26;
        level = l;
        trackerInfo = (TrackerInfo) levelTypePair.second;
    L26:
        if (level != 50) goto L32;
        if (allowRequestBgRestricted == false) goto L29;
        this.mBgHandler.obtainMessage(4, uid, 0, packageName).sendToTarget();
    L29:
        Pair<Integer, TrackerInfo> levelTypePair2 = calcAppRestrictionLevelFromTackers(uid, packageName, 50);
        level = ((Integer) levelTypePair2.first).intValue();
        trackerInfo = (TrackerInfo) levelTypePair2.second;
        goto L32
    L23:
        return new Pair(20, (TrackerInfo) levelTypePair.second);
    L17:
        level = 30;
        goto L19
    L5:
        return new Pair(60, this.mEmptyTrackerInfo);
    }

    private Pair<Integer, TrackerInfo> calcAppRestrictionLevelFromTackers(int uid, String packageName, int maxLevel) {
        int level = 0;
        int prevLevel = 0;
        BaseAppStateTracker resultTracker = null;
        int i = this.mAppStateTrackers.size() - 1;
    L3:
        if (i < 0) goto L9;
        int l = this.mAppStateTrackers.get(i).getPolicy().getProposedRestrictionLevel(packageName, uid, maxLevel);
        level = Math.max(level, l);
        if (level == prevLevel) goto L7;
        BaseAppStateTracker resultTracker2 = this.mAppStateTrackers.get(i);
        resultTracker = resultTracker2;
        prevLevel = level;
    L7:
        i = i - 1;
        goto L3
    L9:
        if (resultTracker != null) goto L11;
        TrackerInfo trackerInfo = this.mEmptyTrackerInfo;
    L13:
        return new Pair(Integer.valueOf(level), trackerInfo);
    L11:
        trackerInfo = new TrackerInfo(this, resultTracker.getType(), resultTracker.getTrackerInfoForStatsd(uid));
        goto L13
    }

    private static int standbyBucketToRestrictionLevel(int standbyBucket) {
        switch(standbyBucket) {
            case 5: goto L10;
            case 10: goto L8;
            case 20: goto L8;
            case 30: goto L8;
            case 40: goto L8;
            case 45: goto L6;
            case 50: goto L8;
            default: goto L3;
        };
    L3:
        return 0;
    L6:
        return 40;
    L8:
        return 30;
    L10:
        return 20;
    }

    int getRestrictionLevel(int uid) {
        return this.mRestrictionSettings.getRestrictionLevel(uid);
    }

    int getRestrictionLevel(int uid, String packageName) {
        return this.mRestrictionSettings.getRestrictionLevel(uid, packageName);
    }

    int getRestrictionLevel(String packageName, int userId) {
        return this.mRestrictionSettings.getRestrictionLevel(packageName, userId);
    }

    boolean isAutoRestrictAbusiveAppEnabled() {
        return this.mConstantsObserver.mBgAutoRestrictAbusiveApps;
    }

    long getForegroundServiceTotalDurations(String packageName, int uid, long now, int serviceType) {
        return this.mInjector.getAppFGSTracker().getTotalDurations(packageName, uid, now, AppFGSTracker.foregroundServiceTypeToIndex(serviceType));
    }

    long getForegroundServiceTotalDurations(int uid, long now, int serviceType) {
        return this.mInjector.getAppFGSTracker().getTotalDurations(uid, now, AppFGSTracker.foregroundServiceTypeToIndex(serviceType));
    }

    long getForegroundServiceTotalDurationsSince(String packageName, int uid, long since, long now, int serviceType) {
        return this.mInjector.getAppFGSTracker().getTotalDurationsSince(packageName, uid, since, now, AppFGSTracker.foregroundServiceTypeToIndex(serviceType));
    }

    long getForegroundServiceTotalDurationsSince(int uid, long since, long now, int serviceType) {
        return this.mInjector.getAppFGSTracker().getTotalDurationsSince(uid, since, now, AppFGSTracker.foregroundServiceTypeToIndex(serviceType));
    }

    long getMediaSessionTotalDurations(String packageName, int uid, long now) {
        return this.mInjector.getAppMediaSessionTracker().getTotalDurations(packageName, uid, now);
    }

    long getMediaSessionTotalDurations(int uid, long now) {
        return this.mInjector.getAppMediaSessionTracker().getTotalDurations(uid, now);
    }

    long getMediaSessionTotalDurationsSince(String packageName, int uid, long since, long now) {
        return this.mInjector.getAppMediaSessionTracker().getTotalDurationsSince(packageName, uid, since, now);
    }

    long getMediaSessionTotalDurationsSince(int uid, long since, long now) {
        return this.mInjector.getAppMediaSessionTracker().getTotalDurationsSince(uid, since, now);
    }

    long getCompositeMediaPlaybackDurations(String packageName, int uid, long now, long window) {
        long since = Math.max(0, now - window);
        long mediaPlaybackDuration = Math.max(getMediaSessionTotalDurationsSince(packageName, uid, since, now), getForegroundServiceTotalDurationsSince(packageName, uid, since, now, 2));
        return mediaPlaybackDuration;
    }

    long getCompositeMediaPlaybackDurations(int uid, long now, long window) {
        long since = Math.max(0, now - window);
        long mediaPlaybackDuration = Math.max(getMediaSessionTotalDurationsSince(uid, since, now), getForegroundServiceTotalDurationsSince(uid, since, now, 2));
        return mediaPlaybackDuration;
    }

    boolean hasForegroundServices(String packageName, int uid) {
        return this.mInjector.getAppFGSTracker().hasForegroundServices(packageName, uid);
    }

    boolean hasForegroundServices(int uid) {
        return this.mInjector.getAppFGSTracker().hasForegroundServices(uid);
    }

    boolean hasForegroundServiceNotifications(String packageName, int uid) {
        return this.mInjector.getAppFGSTracker().hasForegroundServiceNotifications(packageName, uid);
    }

    boolean hasForegroundServiceNotifications(int uid) {
        return this.mInjector.getAppFGSTracker().hasForegroundServiceNotifications(uid);
    }

    AppBatteryTracker.ImmutableBatteryUsage getUidBatteryExemptedUsageSince(int uid, long since, long now, int types) {
        return this.mInjector.getAppBatteryExemptionTracker().getUidBatteryExemptedUsageSince(uid, since, now, types);
    }

    AppBatteryTracker.ImmutableBatteryUsage getUidBatteryUsage(int uid) {
        return this.mInjector.getUidBatteryUsageProvider().getUidBatteryUsage(uid);
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.println("APP BACKGROUND RESTRICTIONS");
        String prefix2 = "  " + prefix;
        pw.print(prefix2);
        pw.println("BACKGROUND RESTRICTION LEVEL SETTINGS");
        this.mRestrictionSettings.dump(pw, "  " + prefix2);
        this.mConstantsObserver.dump(pw, "  " + prefix2);
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        pw.println();
        this.mAppStateTrackers.get(i).dump(pw, prefix2);
        i = i + 1;
        goto L3
    }

    void dumpAsProto(ProtoOutputStream proto, int uid) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).dumpAsProto(proto, uid);
        i = i + 1;
        goto L3
    }

    private int getRestrictionLevelStatsd(int level) {
        switch(level) {
            case 0: goto L17;
            case 10: goto L15;
            case 20: goto L13;
            case 30: goto L11;
            case 40: goto L9;
            case 50: goto L7;
            case 60: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    L17:
        return 0;
    }

    private int getThresholdStatsd(int reason) {
        switch(reason) {
            case 1024: goto L7;
            case 1536: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 1;
    L7:
        return 2;
    }

    private int getTrackerTypeStatsd(int type) {
        switch(type) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 7;
    L7:
        return 6;
    L9:
        return 5;
    L11:
        return 4;
    L13:
        return 3;
    L15:
        return 2;
    L17:
        return 1;
    }

    private int getExemptionReasonStatsd(int uid, int level) {
        if (level == 20) goto L6;
        return 1;
    L6:
        int reasonCode = getBackgroundRestrictionExemptionReason(uid);
        return PowerExemptionManager.getExemptionReasonForStatsd(reasonCode);
    }

    private int getOptimizationLevelStatsd(int level) {
        switch(level) {
            case 0: goto L11;
            case 10: goto L9;
            case 30: goto L7;
            case 50: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 2;
    L7:
        return 1;
    L9:
        return 3;
    L11:
        return 0;
    }

    private int getTargetSdkStatsd(String packageName) {
        PackageManager pm = this.mInjector.getPackageManager();
        if (pm != null) goto L28;
        return 0;
    L28:
        PackageInfo pkg = pm.getPackageInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L23
        if (pkg == null) goto L25;
        if (pkg.applicationInfo == null) goto L25;
        int targetSdk = pkg.applicationInfo.targetSdkVersion;     // Catch: PackageManager.NameNotFoundException -> L23
        if (targetSdk >= 31) goto L16;
        return 1;
    L16:
        if (targetSdk >= 33) goto L19;
        return 2;
    L19:
        if (targetSdk != 33) goto L22;
        return 3;
    L22:
        return 0;
    L25:
        return 0;
    L27:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void applyRestrictionLevel(String r20, final int r21, final int r22, TrackerInfo r23, int r24, boolean r25, int r26, int r27) {
        final AppRestrictionController r1 = this;
        final AppStandbyInternal r8 = r1.mInjector.getAppStandbyInternal();
        if (r23 != null) goto L5;
        TrackerInfo r10 = r1.mEmptyTrackerInfo;
    L6:
        Object r9 = r1.mSettingsLock;
        monitor-enter(r9);
    L92:
        th = th;
    L112:
        monitor-exit(r9);     // Catch: Throwable -> L96
        throw th;
    L96:
        th = th;
        goto L112
    L9:
        final int r11 = r1.getRestrictionLevel(r21, r20);     // Catch: Throwable -> L92
        if (r11 != r22) goto L15;
        monitor-exit(r9);     // Catch: Throwable -> L13
        return;
    L15:
        if (standbyBucketToRestrictionLevel(r24) != r22) goto L21;
        int r3 = r8.getAppStandbyBucketReason(r20, UserHandle.getUserId(r21), SystemClock.elapsedRealtime());     // Catch: Throwable -> L13
        if (r3 == 0) goto L21;
        int r6 = r3 & JobPackageTracker.EVENT_STOP_REASON_MASK;
        int r7 = r3 & 255;
    L118:
        int r4 = r1.mRestrictionSettings.getReason(r20, r21);     // Catch: Throwable -> L90
        r1.mRestrictionSettings.update(r20, r21, r22, r6, r7);     // Catch: Throwable -> L90
        final String r2 = r20;
        final int r14 = r6;
        final int r15 = r7;
        monitor-exit(r9);     // Catch: Throwable -> L88
        boolean r16 = true;
        if (r22 < 40) goto L63;
        if (r11 >= 40) goto L63;
        if (r24 != 45) goto L31;
        int r12 = r21;
        r10 = r10;
        r1 = r1;
        int r13 = r11;
        int r17 = r14;
    L83:
        if (r16 == false) goto L87;
        if (r13 == 0) goto L87;
        int r18 = r17;
        int r5 = r13 == true ? 1 : 0;
        r1.logAppBackgroundRestrictionInfo(r20, r12, r5, r22, r10, r18);
        return;
    L87:
        return;
    L31:
        if (r1.mConstantsObserver.mBgAutoRestrictedBucket == true) goto L35;
        if (r22 == 40) goto L35;
        r12 = r21;
        r10 = r10;
        r13 = r11;
        r17 = r14;
        r1 = r1;
    L35:
        Object r19 = r1.mSettingsLock;
        monitor-enter(r19);
        if (r1.mActiveUids.indexOfKey(r21, r2) < 0) goto L53;
        final TrackerInfo r28 = r10;
        SparseArrayMap<String, Runnable> r0 = r1.mActiveUids;     // Catch: Throwable -> L50
        Object r110 = r19;
        Runnable r29 = new AppRestrictionController$$ExternalSyntheticLambda6(r1, r8, r2, r21, r14, r15, r11, r22, r28);     // Catch: Throwable -> L48
        r12 = r21;
        int r30 = r11;
        AppStandbyInternal r31 = r8;
        r2 = r2;
        r0.add(r12, r2, r29);     // Catch: Throwable -> L46
        r16 = false;
        Object r111 = r110;
    L54:
        monitor-exit(r111);     // Catch: Throwable -> L46
        if (r16 == false) goto L57;
        r31.restrictApp(r2, UserHandle.getUserId(r12), r14, r15);
    L57:
        r13 = r30;
        r17 = r14;
    L48:
        th = th;
        Object r112 = r110;
    L60:
        monitor-exit(r112);     // Catch: Throwable -> L46
        throw th;
    L50:
        th = th;
    L52:
        r112 = r19;
        goto L60
    L53:
        r12 = r21;
        r30 = r11;
        r111 = r19;
        r31 = r8;
    L58:
        th = th;
    L46:
        th = th;
        r112 = r11;
    L63:
        r12 = r21;
        r10 = r10;
        r1 = r1;
        if (r11 < 40) goto L82;
        if (r22 >= 40) goto L82;
        Object r32 = r1.mSettingsLock;
        monitor-enter(r32);
    L76:
        th = th;
    L110:
        monitor-exit(r32);     // Catch: Throwable -> L80
        throw th;
    L80:
        th = th;
        goto L110
    L69:
        if (r1.mActiveUids.indexOfKey(r12, r2) >= 0) goto L116;
    L74:
        monitor-exit(r32);     // Catch: Throwable -> L76
        r13 = r11;
        r17 = r14;
        r8.maybeUnrestrictApp(r2, UserHandle.getUserId(r12), r4 & JobPackageTracker.EVENT_STOP_REASON_MASK, r4 & 255, r17, r15);
        goto L83
    L116:
        r1.mActiveUids.add(r12, r2, null);     // Catch: Throwable -> L72
    L72:
        th = th;
    L82:
        r13 = r11;
        r17 = r14;
    L88:
        th = th;
    L90:
        th = th;
    L21:
        r6 = r26;
        r7 = r27;
    L13:
        th = th;
        goto L112
    L5:
        r10 = r23;
        goto L6
    }

    private /* synthetic */ void lambda$applyRestrictionLevel$1(AppStandbyInternal appStandbyInternal, String pkgName, int uid, int localReason, int localSubReason, int curLevel, int level, TrackerInfo localTrackerInfo) {
        appStandbyInternal.restrictApp(pkgName, UserHandle.getUserId(uid), localReason, localSubReason);
        logAppBackgroundRestrictionInfo(pkgName, uid, curLevel, level, localTrackerInfo, localReason);
    }

    private void logAppBackgroundRestrictionInfo(String pkgName, int uid, int prevLevel, int level, TrackerInfo trackerInfo, int reason) {
        int r5 = getRestrictionLevelStatsd(level);
        int r6 = getThresholdStatsd(reason);
        int r7 = getTrackerTypeStatsd(trackerInfo.mType);
        byte[] r9 = null;
        if (trackerInfo.mType != 3) goto L5;
        byte[] r8 = trackerInfo.mInfo;
    L7:
        if (trackerInfo.mType != 1) goto L9;
        byte[] r4 = trackerInfo.mInfo;
    L11:
        if (trackerInfo.mType != 6) goto L13;
        byte[] r10 = trackerInfo.mInfo;
    L15:
        if (trackerInfo.mType != 7) goto L17;
        r9 = trackerInfo.mInfo;
    L17:
        FrameworkStatsLog.write(FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO, uid, r5, r6, r7, r8, r4, r10, r9, getExemptionReasonStatsd(uid, level), getOptimizationLevelStatsd(level), getTargetSdkStatsd(pkgName), ActivityManager.isLowRamDeviceStatic(), getRestrictionLevelStatsd(prevLevel));
        return;
    L13:
        r10 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r8 = null;
        goto L7
    }

    private void handleBackgroundRestrictionChanged(int uid, String pkgName, boolean restricted) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L5;
        this.mAppStateTrackers.get(i).onBackgroundRestrictionChanged(uid, pkgName, restricted);
        i = i + 1;
        goto L3
    L5:
        AppStandbyInternal appStandbyInternal = this.mInjector.getAppStandbyInternal();
        int userId = UserHandle.getUserId(uid);
        long now = SystemClock.elapsedRealtime();
        int curBucket = appStandbyInternal.getAppStandbyBucket(pkgName, userId, now, false);
        if (restricted == false) goto L8;
        applyRestrictionLevel(pkgName, uid, 50, this.mEmptyTrackerInfo, curBucket, true, 1024, 2);
        this.mBgHandler.obtainMessage(9, uid, 0, pkgName).sendToTarget();
        return;
    L8:
        int lastLevel = RestrictionSettings.m1370$$Nest$mgetLastRestrictionLevel(this.mRestrictionSettings, uid, pkgName);
        if (curBucket != 5) goto L11;
        int tentativeBucket = 5;
    L16:
        Pair<Integer, TrackerInfo> levelTypePair = calcAppRestrictionLevel(UserHandle.getUserId(uid), uid, pkgName, tentativeBucket, false, true);
        applyRestrictionLevel(pkgName, uid, ((Integer) levelTypePair.first).intValue(), (TrackerInfo) levelTypePair.second, curBucket, true, 768, 3);
        return;
    L11:
        int r3 = 40;
        if (lastLevel != 40) goto L14;
        r3 = 45;
    L14:
        tentativeBucket = r3;
        goto L16
    }

    private void dispatchAppRestrictionLevelChanges(final int uid, final String pkgName, final int newLevel) {
        this.mRestrictionListeners.forEach(new AppRestrictionController$$ExternalSyntheticLambda7(uid, pkgName, newLevel));
    }

    private static /* synthetic */ void lambda$dispatchAppRestrictionLevelChanges$2(int uid, String pkgName, int newLevel, ActivityManagerInternal.AppBackgroundRestrictionListener l) {
        l.onRestrictionLevelChanged(uid, pkgName, newLevel);
    }

    private void dispatchAutoRestrictedBucketFeatureFlagChanged(final boolean newValue) {
        final AppStandbyInternal appStandbyInternal = this.mInjector.getAppStandbyInternal();
        final ArrayList<Runnable> pendingTasks = new ArrayList();
        Object r2 = this.mSettingsLock;
        monitor-enter(r2);
        this.mRestrictionSettings.forEachUidLocked(new AppRestrictionController$$ExternalSyntheticLambda4(this, pendingTasks, newValue, appStandbyInternal));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= pendingTasks.size()) goto L10;
        pendingTasks.get(i).run();
        i = i + 1;
        goto L8
    L10:
        this.mRestrictionListeners.forEach(new AppRestrictionController$$ExternalSyntheticLambda5(newValue));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$6(final ArrayList pendingTasks, final boolean newValue, final AppStandbyInternal appStandbyInternal, final Integer uid) {
        this.mRestrictionSettings.forEachPackageInUidLocked(uid.intValue(), new AppRestrictionController$$ExternalSyntheticLambda3(pendingTasks, newValue, appStandbyInternal, uid));
    }

    private static /* synthetic */ void lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$5(ArrayList pendingTasks, boolean newValue, final AppStandbyInternal appStandbyInternal, final Integer uid, final String pkgName, Integer level, final Integer reason) {
        if (level.intValue() != 50) goto L9;
        if (newValue == false) goto L6;
        Runnable r0 = new AppRestrictionController$$ExternalSyntheticLambda0(appStandbyInternal, pkgName, uid, reason);
    L7:
        pendingTasks.add(r0);
        return;
    L6:
        r0 = new AppRestrictionController$$ExternalSyntheticLambda1(appStandbyInternal, pkgName, uid, reason);
        goto L7
    }

    private static /* synthetic */ void lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$3(AppStandbyInternal appStandbyInternal, String pkgName, Integer uid, Integer reason) {
        appStandbyInternal.restrictApp(pkgName, UserHandle.getUserId(uid.intValue()), reason.intValue() & JobPackageTracker.EVENT_STOP_REASON_MASK, reason.intValue() & 255);
    }

    private static /* synthetic */ void lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$4(AppStandbyInternal appStandbyInternal, String pkgName, Integer uid, Integer reason) {
        appStandbyInternal.maybeUnrestrictApp(pkgName, UserHandle.getUserId(uid.intValue()), reason.intValue() & JobPackageTracker.EVENT_STOP_REASON_MASK, reason.intValue() & 255, 768, 6);
    }

    private static /* synthetic */ void lambda$dispatchAutoRestrictedBucketFeatureFlagChanged$7(boolean newValue, ActivityManagerInternal.AppBackgroundRestrictionListener l) {
        l.onAutoRestrictedBucketFeatureFlagChanged(newValue);
    }

    private void handleAppStandbyBucketChanged(int bucket, String packageName, int userId) {
        if (this.mLockedBootCompleted == true) goto L5;
        return;
    L5:
        int uid = this.mInjector.getPackageManagerInternal().getPackageUid(packageName, 819200, userId);
        Pair<Integer, TrackerInfo> levelTypePair = calcAppRestrictionLevel(userId, uid, packageName, bucket, false, false);
        applyRestrictionLevel(packageName, uid, ((Integer) levelTypePair.first).intValue(), (TrackerInfo) levelTypePair.second, bucket, false, 256, 0);
    }

    void handleRequestBgRestricted(String packageName, int uid) {
        this.mNotificationHelper.postRequestBgRestrictedIfNecessary(packageName, uid);
    }

    void handleCancelRequestBgRestricted(String packageName, int uid) {
        this.mNotificationHelper.cancelRequestBgRestrictedIfNecessary(packageName, uid);
    }

    void handleUidProcStateChanged(int uid, int procState) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onUidProcStateChanged(uid, procState);
        i = i + 1;
        goto L3
    }

    void handleUidGone(int uid) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onUidGone(uid);
        i = i + 1;
        goto L3
    }

    public void noteAppRestrictionEnabled(String packageName, int uid, int restrictionType, boolean enabled, int reason, String subReason, int source, long threshold) {
        if (subReason != null) goto L5;
    L7:
        String subReason2 = subReason;
    L8:
        FrameworkStatsLog.write(FrameworkStatsLog.APP_RESTRICTION_STATE_CHANGED, uid, getRestrictionTypeStatsd(restrictionType), enabled, getRestrictionChangeReasonStatsd(reason, subReason2), subReason2, threshold, source);
        return;
    L5:
        if (subReason.length() <= 16) goto L7;
        Slog.e(TAG, "subReason is too long, truncating " + subReason);
        subReason2 = subReason.substring(0, 16);
        goto L8
    }

    private int getRestrictionTypeStatsd(int level) {
        switch(level) {
            case 0: goto L11;
            case 10: goto L10;
            case 20: goto L9;
            case 30: goto L8;
            case 40: goto L7;
            case 50: goto L6;
            case 60: goto L5;
            case 70: goto L4;
            default: goto L3;
        };
    L3:
        return 8;
    L4:
        return 7;
    L5:
        return 6;
    L6:
        return 5;
    L7:
        return 4;
    L8:
        return 3;
    L9:
        return 2;
    L10:
        return 1;
    L11:
        return 0;
    }

    private int getRestrictionChangeReasonStatsd(int reason, String subReason) {
        switch(reason) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return 8;
    L4:
        return 7;
    L5:
        return 6;
    L6:
        return 4;
    L7:
        return 3;
    L8:
        return 2;
    L9:
        return 1;
    }

    void handleUidInactive(int uid, boolean disabled) {
        ArrayList<Runnable> pendingTasks = this.mTmpRunnables;
        Object r1 = this.mSettingsLock;
        monitor-enter(r1);
        int index = this.mActiveUids.indexOfKey(uid);     // Catch: Throwable -> L8
        if (index >= 0) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        int numPackages = this.mActiveUids.numElementsForKeyAt(index);     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= numPackages) goto L16;
        Runnable pendingTask = (Runnable) this.mActiveUids.valueAt(index, i);     // Catch: Throwable -> L8
        if (pendingTask == null) goto L15;
        pendingTasks.add(pendingTask);     // Catch: Throwable -> L8
    L15:
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L16:
        this.mActiveUids.deleteAt(index);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        int i2 = 0;
        int size = pendingTasks.size();
    L19:
        if (i2 >= size) goto L21;
        pendingTasks.get(i2).run();
        i2 = i2 + 1;
        goto L19
    L21:
        pendingTasks.clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void handleUidActive(final int uid) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        final AppStandbyInternal appStandbyInternal = this.mInjector.getAppStandbyInternal();     // Catch: Throwable -> L7
        final int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L7
        this.mRestrictionSettings.forEachPackageInUidLocked(uid, new AppRestrictionController$$ExternalSyntheticLambda9(this, uid, appStandbyInternal, userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleUidActive$9(int uid, final AppStandbyInternal appStandbyInternal, final int userId, final String pkgName, Integer level, final Integer reason) {
        if (this.mConstantsObserver.mBgAutoRestrictedBucket == true) goto L5;
    L7:
        this.mActiveUids.add(uid, pkgName, null);
        return;
    L5:
        if (level.intValue() != 50) goto L7;
        this.mActiveUids.add(uid, pkgName, new AppRestrictionController$$ExternalSyntheticLambda2(appStandbyInternal, pkgName, userId, reason));
    }

    private static /* synthetic */ void lambda$handleUidActive$8(AppStandbyInternal appStandbyInternal, String pkgName, int userId, Integer reason) {
        appStandbyInternal.restrictApp(pkgName, userId, reason.intValue() & JobPackageTracker.EVENT_STOP_REASON_MASK, reason.intValue() & 255);
    }

    boolean isOnDeviceIdleAllowlist(int uid) {
        int appId = UserHandle.getAppId(uid);
        if (Arrays.binarySearch(this.mDeviceIdleAllowlist, appId) < 0) goto L5;
    L8:
        return true;
    L5:
        if (Arrays.binarySearch(this.mDeviceIdleExceptIdleAllowlist, appId) >= 0) goto L8;
        return false;
    }

    boolean isOnSystemDeviceIdleAllowlist(int uid) {
        int appId = UserHandle.getAppId(uid);
        if (this.mSystemDeviceIdleAllowlist.contains(Integer.valueOf(appId)) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mSystemDeviceIdleExceptIdleAllowlist.contains(Integer.valueOf(appId)) == true) goto L8;
        return false;
    }

    void setDeviceIdleAllowlist(int[] allAppids, int[] exceptIdleAppids) {
        this.mDeviceIdleAllowlist = allAppids;
        this.mDeviceIdleExceptIdleAllowlist = exceptIdleAppids;
    }

    int getBackgroundRestrictionExemptionReason(int uid) {
        int reason = getPotentialSystemExemptionReason(uid);
        if (reason == (-1)) goto L5;
        return reason;
    L5:
        String[] packages = this.mInjector.getPackageManager().getPackagesForUid(uid);
        if (packages == null) goto L20;
        int r3 = packages.length;
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r5 >= r3) goto L13;
        String pkg = packages[r5];
        int reason2 = getPotentialSystemExemptionReason(uid, pkg);
        if (reason2 != (-1)) goto L11;
        r5 = r5 + 1;
        goto L8
    L11:
        return reason2;
    L13:
        int r6 = packages.length;
    L15:
        if (r4 >= r6) goto L20;
        String pkg2 = packages[r4];
        int reason3 = getPotentialUserAllowedExemptionReason(uid, pkg2);
        if (reason3 != (-1)) goto L18;
        r4 = r4 + 1;
        goto L15
    L18:
        return reason3;
    L20:
        return -1;
    }

    int getPotentialSystemExemptionReason(int uid) {
        if (UserHandle.isCore(uid) == false) goto L7;
        return 51;
    L7:
        if (isOnSystemDeviceIdleAllowlist(uid) == false) goto L11;
        return 300;
    L11:
        if (UserManager.isDeviceInDemoMode(this.mContext) == false) goto L14;
        return 63;
    L14:
        int userId = UserHandle.getUserId(uid);
        if (this.mInjector.getUserManagerInternal().hasUserRestriction("no_control_apps", userId) == false) goto L18;
        return 323;
    L18:
        ActivityManagerInternal am = this.mInjector.getActivityManagerInternal();
        if (am.isDeviceOwner(uid) == false) goto L23;
        return 55;
    L23:
        if (am.isProfileOwner(uid) == false) goto L26;
        return 56;
    L26:
        int uidProcState = am.getUidProcessState(uid);
        if (uidProcState > 0) goto L31;
        return 10;
    L31:
        if (uidProcState > 1) goto L34;
        return 11;
    L34:
        return -1;
    }

    int getPotentialSystemExemptionReason(int uid, String pkg) {
        PackageManagerInternal pm = this.mInjector.getPackageManagerInternal();
        AppStandbyInternal appStandbyInternal = this.mInjector.getAppStandbyInternal();
        AppOpsManager appOpsManager = this.mInjector.getAppOpsManager();
        ActivityManagerService activityManagerService = this.mInjector.getActivityManagerService();
        int userId = UserHandle.getUserId(uid);
        if (isSystemModule(pkg) == false) goto L7;
        return 320;
    L7:
        if (isCarrierApp(pkg) == false) goto L11;
        return 321;
    L11:
        if (isExemptedFromSysConfig(pkg) == false) goto L14;
        return 300;
    L14:
        if (this.mConstantsObserver.mBgRestrictionExemptedPackages.contains(pkg) == false) goto L17;
        return 300;
    L17:
        if (pm.isPackageStateProtected(pkg, userId) == false) goto L21;
        return 322;
    L21:
        if (appStandbyInternal.isActiveDeviceAdmin(pkg, userId) == false) goto L25;
        return FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ACTIVE_DEVICE_ADMIN;
    L25:
        if (activityManagerService.mConstants.mFlagSystemExemptPowerRestrictionsEnabled == true) goto L27;
        return -1;
    L27:
        if (appOpsManager.checkOpNoThrow(128, uid, pkg) != 0) goto L32;
        return 327;
    L32:
        return -1;
    }

    int getPotentialUserAllowedExemptionReason(int uid, String pkg) {
        AppOpsManager appOpsManager = this.mInjector.getAppOpsManager();
        if (appOpsManager.checkOpNoThrow(47, uid, pkg) != 0) goto L7;
        return 68;
    L7:
        if (appOpsManager.checkOpNoThrow(94, uid, pkg) != 0) goto L11;
        return 69;
    L11:
        if (isRoleHeldByUid("android.app.role.DIALER", uid) == false) goto L15;
        return FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ROLE_DIALER;
    L15:
        if (isRoleHeldByUid("android.app.role.EMERGENCY", uid) == false) goto L19;
        return 319;
    L19:
        if (isOnDeviceIdleAllowlist(uid) == false) goto L22;
        return 65;
    L22:
        ActivityManagerInternal am = this.mInjector.getActivityManagerInternal();
        if (am.isAssociatedCompanionApp(UserHandle.getUserId(uid), uid) == false) goto L26;
        return 57;
    L26:
        return -1;
    }

    private boolean isCarrierApp(String packageName) {
        Object r0 = this.mCarrierPrivilegedLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCarrierPrivilegedApps == null) goto L15;
        int i = this.mCarrierPrivilegedApps.size() - 1;     // Catch: Throwable -> L12
    L7:
        if (i < 0) goto L15;
        if (this.mCarrierPrivilegedApps.valueAt(i).contains(packageName) == true) goto L10;
        i = i - 1;     // Catch: Throwable -> L12
        goto L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    private void registerCarrierPrivilegesCallbacks() {
        TelephonyManager telephonyManager = this.mInjector.getTelephonyManager();
        if (telephonyManager != null) goto L5;
        return;
    L5:
        int numPhones = telephonyManager.getActiveModemCount();
        ArrayList<PhoneCarrierPrivilegesCallback> callbacks = new ArrayList();
        int i = 0;
    L6:
        if (i >= numPhones) goto L8;
        PhoneCarrierPrivilegesCallback callback = new PhoneCarrierPrivilegesCallback(this, i);
        callbacks.add(callback);
        telephonyManager.registerCarrierPrivilegesCallback(i, this.mExecutor, callback);
        i = i + 1;
        goto L6
    L8:
        this.mCarrierPrivilegesCallbacks = callbacks;
    }

    private void unregisterCarrierPrivilegesCallbacks() {
        TelephonyManager telephonyManager = this.mInjector.getTelephonyManager();
        if (telephonyManager != null) goto L5;
        return;
    L5:
        ArrayList<PhoneCarrierPrivilegesCallback> callbacks = this.mCarrierPrivilegesCallbacks;
        if (callbacks == null) goto L13;
        int i = callbacks.size() - 1;
    L8:
        if (i < 0) goto L10;
        telephonyManager.unregisterCarrierPrivilegesCallback(callbacks.get(i));
        i = i - 1;
        goto L8
    L10:
        this.mCarrierPrivilegesCallbacks = null;
        return;
    }

    private boolean isRoleHeldByUid(String roleName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<String> roles = this.mUidRolesMapping.get(uid);     // Catch: Throwable -> L9
        if (roles != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (roles.indexOf(roleName) < 0) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private void initRolesInInterest() {
        int[] allUsers = this.mInjector.getUserManagerInternal().getUserIds();
        String[] r1 = ROLES_IN_INTEREST;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        String role = r1[r4];
        if (this.mInjector.getRoleManager().isRoleAvailable(role) == false) goto L10;
        int r6 = allUsers.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L10;
        int userId = allUsers[r7];
        UserHandle user = UserHandle.of(userId);
        onRoleHoldersChanged(role, user);
        r7 = r7 + 1;
    L10:
        r4 = r4 + 1;
        goto L3
    }

    private void onRoleHoldersChanged(String roleName, UserHandle user) {
        List<String> rolePkgs = this.mInjector.getRoleManager().getRoleHoldersAsUser(roleName, user);
        ArraySet<Integer> roleUids = new ArraySet();
        int userId = user.getIdentifier();
        if (rolePkgs == null) goto L8;
        PackageManagerInternal pm = this.mInjector.getPackageManagerInternal();
        Iterator<String> r4 = rolePkgs.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        String pkg = r4.next();
        roleUids.add(Integer.valueOf(pm.getPackageUid(pkg, 819200, userId)));
    L8:
        Object r3 = this.mLock;
        monitor-enter(r3);
        int i = this.mUidRolesMapping.size() - 1;     // Catch: Throwable -> L21
    L11:
        if (i < 0) goto L26;
        int uid = this.mUidRolesMapping.keyAt(i);     // Catch: Throwable -> L21
        if (UserHandle.getUserId(uid) != userId) goto L25;
        ArrayList<String> roles = this.mUidRolesMapping.valueAt(i);     // Catch: Throwable -> L21
        int index = roles.indexOf(roleName);     // Catch: Throwable -> L21
        boolean isRole = roleUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L21
        if (index < 0) goto L23;
        if (isRole == true) goto L25;
        roles.remove(index);     // Catch: Throwable -> L21
        if (roles.isEmpty() == false) goto L25;
        this.mUidRolesMapping.removeAt(i);     // Catch: Throwable -> L21
        goto L25
    L23:
        if (isRole == false) goto L25;
        roles.add(roleName);     // Catch: Throwable -> L21
        roleUids.remove(Integer.valueOf(uid));     // Catch: Throwable -> L21
    L25:
        i = i - 1;     // Catch: Throwable -> L21
        goto L11
    L26:
        int i2 = roleUids.size();     // Catch: Throwable -> L21
        int i3 = i2 - 1;     // Catch: Throwable -> L21
    L27:
        if (i3 < 0) goto L30;
        ArrayList<String> roles2 = new ArrayList();     // Catch: Throwable -> L21
        roles2.add(roleName);     // Catch: Throwable -> L21
        this.mUidRolesMapping.put(roleUids.valueAt(i3).intValue(), roles2);     // Catch: Throwable -> L21
        i3 = i3 - 1;     // Catch: Throwable -> L21
        goto L27
    L30:
        monitor-exit(r3);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    Handler getBackgroundHandler() {
        return this.mBgHandler;
    }

    HandlerThread getBackgroundHandlerThread() {
        return this.mBgHandlerThread;
    }

    Object getLock() {
        return this.mLock;
    }

    void addAppStateTracker(BaseAppStateTracker tracker) {
        this.mAppStateTrackers.add(tracker);
    }

    <T extends BaseAppStateTracker> T getAppStateTracker(Class<T> trackerClass) {
        Iterator<BaseAppStateTracker> r0 = this.mAppStateTrackers.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        T r1 = (T) r0.next();
        if (trackerClass.isAssignableFrom(r1.getClass()) == false) goto L4;
        return r1;
    L9:
        return null;
    }

    void postLongRunningFgsIfNecessary(String packageName, int uid) {
        this.mNotificationHelper.postLongRunningFgsIfNecessary(packageName, uid);
    }

    void cancelLongRunningFGSNotificationIfNecessary(String packageName, int uid) {
        this.mNotificationHelper.cancelLongRunningFGSNotificationIfNecessary(packageName, uid);
    }

    String getPackageName(int pid) {
        return this.mInjector.getPackageName(pid);
    }

    private void registerForSystemBroadcasts() {
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        packageFilter.addDataScheme("package");
        this.mContext.registerReceiverForAllUsers(this.mBroadcastReceiver, packageFilter, null, this.mBgHandler);
        IntentFilter userFilter = new IntentFilter();
        userFilter.addAction("android.intent.action.USER_ADDED");
        userFilter.addAction("android.intent.action.USER_REMOVED");
        userFilter.addAction("android.intent.action.UID_REMOVED");
        this.mContext.registerReceiverForAllUsers(this.mBroadcastReceiver, userFilter, null, this.mBgHandler);
        IntentFilter bootFilter = new IntentFilter();
        bootFilter.addAction("android.intent.action.LOCKED_BOOT_COMPLETED");
        this.mContext.registerReceiverAsUser(this.mBootReceiver, UserHandle.SYSTEM, bootFilter, null, this.mBgHandler);
        IntentFilter telFilter = new IntentFilter("android.telephony.action.MULTI_SIM_CONFIG_CHANGED");
        this.mContext.registerReceiverForAllUsers(this.mBroadcastReceiver, telFilter, null, this.mBgHandler);
    }

    private void unregisterForSystemBroadcasts() {
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        this.mContext.unregisterReceiver(this.mBootReceiver);
    }

    void forEachTracker(Consumer<BaseAppStateTracker> sink) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        sink.accept(this.mAppStateTrackers.get(i));
        i = i + 1;
        goto L3
    }

    private void onUserAdded(int userId) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onUserAdded(userId);
        i = i + 1;
        goto L3
    }

    private void onUserStarted(int userId) {
        refreshAppRestrictionLevelForUser(userId, 1024, 2);
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onUserStarted(userId);
        i = i + 1;
        goto L3
    }

    private void onUserStopped(int userId) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onUserStopped(userId);
        i = i + 1;
        goto L3
    }

    private void onUserRemoved(int userId) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L5;
        this.mAppStateTrackers.get(i).onUserRemoved(userId);
        i = i + 1;
        goto L3
    L5:
        this.mRestrictionSettings.removeUser(userId);
    }

    private void onUidAdded(int uid) {
        refreshAppRestrictionLevelForUid(uid, 1536, 0, false);
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onUidAdded(uid);
        i = i + 1;
        goto L3
    }

    private void onPackageRemoved(String pkgName, int uid) {
        this.mRestrictionSettings.removePackage(pkgName, uid);
    }

    private void onUidRemoved(int uid) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L5;
        this.mAppStateTrackers.get(i).onUidRemoved(uid);
        i = i + 1;
        goto L3
    L5:
        this.mRestrictionSettings.removeUid(uid);
    }

    private void onLockedBootCompleted() {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L5;
        this.mAppStateTrackers.get(i).onLockedBootCompleted();
        i = i + 1;
        goto L3
    L5:
        this.mLockedBootCompleted = true;
    }

    boolean isBgAutoRestrictedBucketFeatureFlagEnabled() {
        return this.mConstantsObserver.mBgAutoRestrictedBucket;
    }

    private void onPropertiesChanged(String name) {
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onPropertiesChanged(name);
        i = i + 1;
        goto L3
    }

    private void onUserInteractionStarted(String packageName, int userId) {
        int uid = this.mInjector.getPackageManagerInternal().getPackageUid(packageName, 819200, userId);
        int i = 0;
        int size = this.mAppStateTrackers.size();
    L3:
        if (i >= size) goto L6;
        this.mAppStateTrackers.get(i).onUserInteractionStarted(packageName, uid);
        i = i + 1;
        goto L3
    }
}

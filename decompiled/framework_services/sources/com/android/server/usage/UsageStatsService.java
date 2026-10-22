package com.android.server.usage;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.IUidObserver;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.supervision.SupervisionManagerInternal;
import android.app.usage.AppLaunchEstimateInfo;
import android.app.usage.AppStandbyInfo;
import android.app.usage.BroadcastResponseStatsList;
import android.app.usage.ConfigurationStats;
import android.app.usage.EventStats;
import android.app.usage.IUsageStatsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageEventsQuery;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.app.usage.UsageStatsManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.LocusId;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ShortcutServiceInternal;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.SparseSetArray;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.AlarmQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes3.dex */
public class UsageStatsService extends SystemService implements UserUsageStatsService.StatsUpdatedListener {
    private static final File COMMON_USAGE_STATS_DIR = null;
    static final boolean COMPRESS_TIME = false;
    static final boolean DEBUG = false;
    static final boolean DEBUG_RESPONSE_STATS = false;
    private static final boolean ENABLE_KERNEL_UPDATES = true;
    public static final boolean ENABLE_TIME_CHANGE_CORRECTION = false;
    private static final long FLUSH_INTERVAL = 1200000;
    private static final String GLOBAL_COMPONENT_USAGE_FILE_NAME = "globalcomponentusage";
    private static final File KERNEL_COUNTER_FILE = null;
    private static final File KERNEL_COUNTER_KDA_FILE = null;
    private static final File LEGACY_COMMON_USAGE_STATS_DIR = null;
    private static final File LEGACY_USER_USAGE_STATS_DIR = null;
    private static final int MAX_TEXT_LENGTH = 127;
    static final int MSG_FLUSH_TO_DISK = 1;
    static final int MSG_HANDLE_LAUNCH_TIME_ON_USER_UNLOCK = 8;
    static final int MSG_NOTIFY_ESTIMATED_LAUNCH_TIMES_CHANGED = 9;
    static final int MSG_NOTIFY_USAGE_EVENT_LISTENER = 12;
    static final int MSG_ON_START = 7;
    static final int MSG_PACKAGE_REMOVED = 6;
    static final int MSG_REMOVE_USER = 2;
    static final int MSG_REPORT_EVENT = 0;
    static final int MSG_REPORT_EVENT_TO_ALL_USERID = 4;
    static final int MSG_UID_REMOVED = 10;
    static final int MSG_UID_STATE_CHANGED = 3;
    static final int MSG_UNLOCKED_USER = 5;
    static final int MSG_USER_STARTED = 11;
    private static final long ONE_DAY = 86400000;
    private static final long ONE_WEEK = 604800000;
    static final String TAG = "UsageStatsService";
    private static final long TEN_SECONDS = 10000;
    static final long TIME_CHANGE_THRESHOLD_MILLIS = 2000;
    private static final char TOKEN_DELIMITER = '/';
    private static final long TWENTY_MINUTES = 1200000;
    private static final long UNKNOWN_LAUNCH_TIME_DELAY_MS = 31536000000L;
    private static final boolean USE_DEDICATED_HANDLER_THREAD = false;
    AppOpsManager mAppOps;
    AppStandbyInternal mAppStandby;
    AppTimeLimitController mAppTimeLimit;
    DevicePolicyManagerInternal mDpmInternal;
    private final CopyOnWriteArraySet<UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener> mEstimatedLaunchTimeChangedListeners;
    private Handler mHandler;
    private final Injector mInjector;
    private Handler mIoHandler;
    private final Handler.Callback mIoHandlerCallback;
    private final Map<String, Long> mLastTimeComponentUsedGlobal;
    private final SparseArray<LaunchTimeAlarmQueue> mLaunchTimeAlarmQueues;
    private final Object mLock;
    PackageManager mPackageManager;
    PackageManagerInternal mPackageManagerInternal;
    private final PackageMonitor mPackageMonitor;
    private final SparseSetArray<String> mPendingLaunchTimeChangePackages;
    private long mRealTimeSnapshot;
    private final SparseArray<LinkedList<UsageEvents.Event>> mReportedEvents;
    private BroadcastResponseStatsTracker mResponseStatsTracker;
    ShortcutServiceInternal mShortcutServiceInternal;
    private AppStandbyInternal.AppIdleStateChangeListener mStandbyChangeListener;
    SupervisionManagerInternal mSupervisionManagerInternal;
    private long mSystemTimeSnapshot;
    private final IUidObserver mUidObserver;
    private final SparseIntArray mUidToKernelCounter;
    private final ArraySet<UsageStatsManagerInternal.UsageEventListener> mUsageEventListeners;
    final SparseArray<ArraySet<String>> mUsageReporters;
    int mUsageSource;
    UserManager mUserManager;
    private final SparseArray<UserUsageStatsService> mUserState;
    private final CopyOnWriteArraySet<Integer> mUserUnlockedStates;
    final SparseArray<ActivityData> mVisibleActivities;

    private static class ActivityData {
        public int lastEvent;
        private final String mTaskRootClass;
        private final String mTaskRootPackage;
        private final String mUsageSourcePackage;

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskRootClass, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9142$$Nest$fgetmTaskRootClass(ActivityData r0) {
            return r0.mTaskRootClass;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskRootPackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9143$$Nest$fgetmTaskRootPackage(ActivityData r0) {
            return r0.mTaskRootPackage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUsageSourcePackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9144$$Nest$fgetmUsageSourcePackage(ActivityData r0) {
            return r0.mUsageSourcePackage;
        }

        /* synthetic */ ActivityData(String r1, String r2, String r3, UsageStatsServiceIA r4) {
            this(r1, r2, r3);
        }

        private ActivityData(String taskRootPackage, String taskRootClass, String sourcePackage) {
            this.lastEvent = 0;
            this.mTaskRootPackage = taskRootPackage;
            this.mTaskRootClass = taskRootClass;
            this.mUsageSourcePackage = sourcePackage;
        }
    }

    private final class BinderService extends IUsageStatsManager.Stub {
        final /* synthetic */ UsageStatsService this$0;

        public static /* synthetic */ boolean $r8$lambda$KcrJYyWcmAOKG3NFhWUYPCQlNFI(BinderService r0, int r1, int r2, boolean r3, AppStandbyInfo r4) {
            return r0.lambda$getAppStandbyBuckets$0(r1, r2, r3, r4);
        }

        /* synthetic */ BinderService(UsageStatsService r1, UsageStatsServiceIA r2) {
            this(r1);
        }

        private BinderService(UsageStatsService r1) {
            this.this$0 = r1;
        }

        private boolean hasQueryPermission(String callingPackage) {
            int callingUid = Binder.getCallingUid();
            if (NBUsageTimeStatsPolicy.skipCheckPermission(callingPackage) == false) goto L6;
            return true;
        L6:
            if (callingUid != 1000) goto L8;
            return true;
        L8:
            int mode = this.this$0.mAppOps.noteOp(43, callingUid, callingPackage);
            if (mode == 3) goto L11;
            if (mode != 0) goto L18;
            return true;
        L18:
            return false;
        L11:
            if (this.this$0.getContext().checkCallingPermission("android.permission.PACKAGE_USAGE_STATS") != 0) goto L14;
            return true;
        L14:
            return false;
        }

        private boolean canReportUsageStats() {
            if (isCallingUidSystem() == false) goto L6;
            return true;
        L6:
            if (this.this$0.getContext().checkCallingPermission("android.permission.REPORT_USAGE_STATS") == 0) goto L10;
            return false;
        L10:
            return true;
        }

        private boolean hasObserverPermission() {
            int callingUid = Binder.getCallingUid();
            DevicePolicyManagerInternal dpmInternal = UsageStatsService.m9118$$Nest$mgetDpmInternal(this.this$0);
            if (callingUid == 1000) goto L15;
            if (dpmInternal == null) goto L11;
            if (dpmInternal.isActiveProfileOwner(callingUid) == true) goto L15;
            if (dpmInternal.isActiveDeviceOwner(callingUid) == true) goto L15;
        L11:
            if (this.this$0.getContext().checkCallingPermission("android.permission.OBSERVE_APP_USAGE") == 0) goto L16;
            return false;
        L16:
            return true;
        L15:
            return true;
        }

        private boolean hasPermissions(String... permissions) {
            int callingUid = Binder.getCallingUid();
            if (callingUid != 1000) goto L5;
            return true;
        L5:
            boolean hasPermissions = true;
            Context context = this.this$0.getContext();
            int i = 0;
        L7:
            if (i >= permissions.length) goto L15;
            if (hasPermissions == true) goto L10;
        L12:
            boolean r5 = false;
        L13:
            hasPermissions = r5;
            i = i + 1;
            goto L7
        L10:
            if (context.checkCallingPermission(permissions[i]) != 0) goto L12;
            r5 = true;
            goto L13
        L15:
            return hasPermissions;
        }

        private void checkCallerIsSystemOrSameApp(String pkg) {
            if (isCallingUidSystem() == false) goto L5;
            return;
        L5:
            checkCallerIsSameApp(pkg);
        }

        private void checkCallerIsSameApp(String pkg) {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            if (this.this$0.mPackageManagerInternal.getPackageUid(pkg, 0, callingUserId) != callingUid) goto L6;
            return;
        L6:
            throw new SecurityException("Calling uid " + callingUid + " cannot query eventsfor package " + pkg);
        }

        private boolean isCallingUidSystem() {
            int uid = UserHandle.getAppId(Binder.getCallingUid());
            if (uid != 1000) goto L5;
            return true;
        L5:
            return false;
        }

        private UsageEvents queryEventsHelper(int userId, long beginTime, long endTime, String callingPackage, int[] eventTypeFilter, ArraySet<String> pkgNameFilter) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            boolean obfuscateInstantApps = UsageStatsService.m9137$$Nest$mshouldObfuscateInstantAppsForCaller(this.this$0, callingUid, UserHandle.getCallingUserId());
            long token = Binder.clearCallingIdentity();
            boolean hideShortcutInvocationEvents = UsageStatsService.m9136$$Nest$mshouldHideShortcutInvocationEvents(this.this$0, userId, callingPackage, callingPid, callingUid);     // Catch: Throwable -> L15
            boolean hideLocusIdEvents = UsageStatsService.m9135$$Nest$mshouldHideLocusIdEvents(this.this$0, callingPid, callingUid);     // Catch: Throwable -> L15
            boolean obfuscateNotificationEvents = UsageStatsService.m9138$$Nest$mshouldObfuscateNotificationEvents(this.this$0, callingPid, callingUid);     // Catch: Throwable -> L15
            int flags = 0;
            if (obfuscateInstantApps == false) goto L6;
            flags = 0 | 1;     // Catch: Throwable -> L15
        L6:
            if (hideShortcutInvocationEvents == false) goto L8;
            flags = flags | 2;     // Catch: Throwable -> L15
        L8:
            if (hideLocusIdEvents == false) goto L10;
            flags = flags | 8;     // Catch: Throwable -> L15
        L10:
            if (obfuscateNotificationEvents == false) goto L12;
            flags = flags | 4;     // Catch: Throwable -> L15
        L12:
            UsageStatsService r7 = this.this$0;     // Catch: Throwable -> L15
            UsageEvents r8 = r7.queryEventsWithQueryFilters(userId, beginTime, endTime, flags, eventTypeFilter, pkgNameFilter);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(token);
            return r8;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        private void reportUserInteractionInnerHelper(String packageName, int userId, PersistableBundle extras) {
            if (canReportUsageStats() == false) goto L14;
            if (userId == UserHandle.getCallingUserId()) goto L8;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "Caller doesn't have INTERACT_ACROSS_USERS_FULL permission");
        L8:
            if (this.this$0.mPackageManagerInternal.getPackageUid(packageName, 0, userId) < 0) goto L12;
            UsageEvents.Event event = new UsageEvents.Event(7, SystemClock.elapsedRealtime());
            event.mPackage = packageName;
            event.mExtras = extras;
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
            return;
        L12:
            throw new IllegalArgumentException("Package " + packageName + " does not exist!");
        L14:
            throw new SecurityException("Only the system or holders of the REPORT_USAGE_STATS permission are allowed to call reportUserInteraction");
        }

        public ParceledListSlice<UsageStats> queryUsageStats(int bucketType, long beginTime, long endTime, String callingPackage, int userId) {
            if (hasQueryPermission(callingPackage) == true) goto L5;
            return null;
        L5:
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, true, "queryUsageStats", callingPackage);
            boolean obfuscateInstantApps = UsageStatsService.m9137$$Nest$mshouldObfuscateInstantAppsForCaller(this.this$0, callingUid, UserHandle.getCallingUserId());
            long token = Binder.clearCallingIdentity();
            List<UsageStats> results = this.this$0.queryUsageStats(userId2, bucketType, beginTime, endTime, obfuscateInstantApps);     // Catch: Throwable -> L11
            if (results == null) goto L13;
            ParceledListSlice<UsageStats> r2 = new ParceledListSlice(results);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return r2;
        L13:
            Binder.restoreCallingIdentity(token);
            return null;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public ParceledListSlice<ConfigurationStats> queryConfigurationStats(int bucketType, long beginTime, long endTime, String callingPackage) throws RemoteException {
            if (hasQueryPermission(callingPackage) == true) goto L5;
            return null;
        L5:
            int userId = UserHandle.getCallingUserId();
            long token = Binder.clearCallingIdentity();
            List<ConfigurationStats> results = this.this$0.queryConfigurationStats(userId, bucketType, beginTime, endTime);     // Catch: Throwable -> L11
            if (results == null) goto L13;
            ParceledListSlice<ConfigurationStats> r2 = new ParceledListSlice(results);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return r2;
        L13:
            Binder.restoreCallingIdentity(token);
            return null;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public ParceledListSlice<EventStats> queryEventStats(int bucketType, long beginTime, long endTime, String callingPackage) throws RemoteException {
            if (hasQueryPermission(callingPackage) == true) goto L5;
            return null;
        L5:
            int userId = UserHandle.getCallingUserId();
            long token = Binder.clearCallingIdentity();
            List<EventStats> results = this.this$0.queryEventStats(userId, bucketType, beginTime, endTime);     // Catch: Throwable -> L11
            if (results == null) goto L13;
            ParceledListSlice<EventStats> r2 = new ParceledListSlice(results);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return r2;
        L13:
            Binder.restoreCallingIdentity(token);
            return null;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public UsageEvents queryEvents(long beginTime, long endTime, String callingPackage) {
            if (hasQueryPermission(callingPackage) == true) goto L7;
            return null;
        L7:
            return queryEventsHelper(UserHandle.getCallingUserId(), beginTime, endTime, callingPackage, EmptyArray.INT, null);
        }

        public UsageEvents queryEventsWithFilter(UsageEventsQuery query, String callingPackage) {
            query.getClass();
            callingPackage.getClass();
            if (hasQueryPermission(callingPackage) == true) goto L6;
            return null;
        L6:
            int callingUserId = UserHandle.getCallingUserId();
            int userId = query.getUserId();
            if (userId != (-10000)) goto L9;
            int userId2 = callingUserId;
        L10:
            if (userId2 == callingUserId) goto L13;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "No permission to query usage stats for user " + userId2);
        L13:
            return queryEventsHelper(userId2, query.getBeginTimeMillis(), query.getEndTimeMillis(), callingPackage, query.getEventTypes(), new ArraySet(query.getPackageNames()));
        L9:
            userId2 = userId;
            goto L10
        }

        public UsageEvents queryEventsForPackage(long beginTime, long endTime, String callingPackage) {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            checkCallerIsSameApp(callingPackage);
            boolean includeTaskRoot = hasQueryPermission(callingPackage);
            long token = Binder.clearCallingIdentity();
            UsageEvents r0 = this.this$0.queryEventsForPackage(callingUserId, beginTime, endTime, callingPackage, includeTaskRoot);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r0;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public UsageEvents queryEventsForUser(long beginTime, long endTime, int userId, String callingPackage) {
            if (hasQueryPermission(callingPackage) == true) goto L6;
            return null;
        L6:
            int callingUserId = UserHandle.getCallingUserId();
            if (userId == callingUserId) goto L10;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "No permission to query usage stats for this user");
        L10:
            return queryEventsHelper(userId, beginTime, endTime, callingPackage, EmptyArray.INT, null);
        }

        public UsageEvents queryEventsForPackageForUser(long beginTime, long endTime, int userId, String pkg, String callingPackage) {
            if (hasQueryPermission(callingPackage) == true) goto L7;
            return null;
        L7:
            if (userId == UserHandle.getCallingUserId()) goto L9;
            this.this$0.getContext().enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "No permission to query usage stats for this user");
        L9:
            checkCallerIsSystemOrSameApp(pkg);
            long token = Binder.clearCallingIdentity();
            UsageEvents r0 = this.this$0.queryEventsForPackage(userId, beginTime, endTime, pkg, true);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(token);
            return r0;
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isAppStandbyEnabled() {
            return this.this$0.mAppStandby.isAppIdleEnabled();
        }

        public boolean isAppInactive(String packageName, int userId, String callingPackage) {
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "isAppInactive", null);     // Catch: RemoteException -> L28
            if (packageName.equals(callingPackage) == false) goto L14;
            int actualCallingUid = this.this$0.mPackageManagerInternal.getPackageUid(callingPackage, 0, userId2);
            if (actualCallingUid == callingUid) goto L16;
            return false;
        L16:
            boolean obfuscateInstantApps = UsageStatsService.m9137$$Nest$mshouldObfuscateInstantAppsForCaller(this.this$0, callingUid, userId2);
            long token = Binder.clearCallingIdentity();
            boolean r12 = this.this$0.mAppStandby.isAppIdleFiltered(packageName, userId2, SystemClock.elapsedRealtime(), obfuscateInstantApps);     // Catch: Throwable -> L22
            Binder.restoreCallingIdentity(token);
            return r12;
        L22:
            th = move-exception;
            Throwable r13 = th;
        L26:
            Binder.restoreCallingIdentity(token);
            throw r13;
        L24:
            th = move-exception;
            r13 = th;
            goto L26
        L14:
            if (hasQueryPermission(callingPackage) == true) goto L16;
            return false;
        L28:
            e = move-exception;
            RemoteException re = e;
        L33:
            throw re.rethrowFromSystemServer();
        L30:
            e = move-exception;
            re = e;
            goto L33
        }

        public void setAppInactive(String packageName, boolean idle, int userId) {
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, true, "setAppInactive", null);     // Catch: RemoteException -> L17
            this.this$0.getContext().enforceCallingPermission("android.permission.CHANGE_APP_IDLE_STATE", "No permission to change app idle state");
            long token = Binder.clearCallingIdentity();
            int appId = this.this$0.mAppStandby.getAppId(packageName);     // Catch: Throwable -> L14
            if (appId >= 0) goto L11;
            Binder.restoreCallingIdentity(token);
            return;
        L11:
            this.this$0.mAppStandby.setAppIdleAsync(packageName, idle, userId2);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return;
        L14:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L17:
            e = move-exception;
            RemoteException re = e;
        L22:
            throw re.rethrowFromSystemServer();
        L19:
            e = move-exception;
            re = e;
            goto L22
        }

        public int getAppStandbyBucket(String packageName, String callingPackage, int userId) {
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "getAppStandbyBucket", null);     // Catch: RemoteException -> L30
            int packageUid = this.this$0.mPackageManagerInternal.getPackageUid(packageName, 0, userId2);
            if (packageUid != callingUid) goto L7;
            boolean r0 = true;
        L8:
            boolean sameApp = r0;
            if (sameApp == true) goto L16;
            if (hasQueryPermission(callingPackage) == true) goto L16;
            throw new SecurityException("Don't have permission to query app standby bucket");
        L16:
            boolean isInstantApp = UsageStatsService.m9121$$Nest$misInstantApp(this.this$0, packageName, userId2);
            boolean cannotAccessInstantApps = UsageStatsService.m9137$$Nest$mshouldObfuscateInstantAppsForCaller(this.this$0, callingUid, userId2);
            if (packageUid < 0) goto L29;
            if (sameApp == true) goto L21;
            if (isInstantApp == false) goto L21;
            if (cannotAccessInstantApps == true) goto L29;
        L21:
            long token = Binder.clearCallingIdentity();
            int r1 = this.this$0.mAppStandby.getAppStandbyBucket(packageName, userId2, SystemClock.elapsedRealtime(), false);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(token);
            return r1;
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L29:
            throw new IllegalArgumentException("Cannot get standby bucket for non existent package (" + packageName + ")");
        L7:
            r0 = false;
        L30:
            re = move-exception;
            throw re.rethrowFromSystemServer();
        }

        public void setAppStandbyBucket(String packageName, int bucket, int userId) {
            super.setAppStandbyBucket_enforcePermission();
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            long token = Binder.clearCallingIdentity();
            this.this$0.mAppStandby.setAppStandbyBucket(packageName, bucket, userId, callingUid, callingPid);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Throwable r9 = th;
        L12:
            Binder.restoreCallingIdentity(token);
            throw r9;
        L10:
            th = move-exception;
            r9 = th;
            goto L12
        }

        public ParceledListSlice<AppStandbyInfo> getAppStandbyBuckets(String callingPackageName, int userId) {
            final int callingUid = Binder.getCallingUid();
            final int userId2 = ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "getAppStandbyBucket", null);     // Catch: RemoteException -> L24
            if (hasQueryPermission(callingPackageName) == false) goto L23;
            final boolean cannotAccessInstantApps = UsageStatsService.m9137$$Nest$mshouldObfuscateInstantAppsForCaller(this.this$0, callingUid, userId2);
            long token = Binder.clearCallingIdentity();
            List<AppStandbyInfo> standbyBucketList = this.this$0.mAppStandby.getAppStandbyBuckets(userId2);     // Catch: Throwable -> L14
            if (standbyBucketList != null) goto L17;
            ParceledListSlice<AppStandbyInfo> r5 = ParceledListSlice.emptyList();     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return r5;
        L17:
            standbyBucketList.removeIf(new UsageStatsService$BinderService$$ExternalSyntheticLambda0(this, callingUid, userId2, cannotAccessInstantApps));     // Catch: Throwable -> L14
            ParceledListSlice<AppStandbyInfo> r6 = new ParceledListSlice(standbyBucketList);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return r6;
        L14:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L23:
            throw new SecurityException("Don't have permission to query app standby bucket");
        L24:
            e = move-exception;
            RemoteException re = e;
        L29:
            throw re.rethrowFromSystemServer();
        L26:
            e = move-exception;
            re = e;
            goto L29
        }

        private /* synthetic */ boolean lambda$getAppStandbyBuckets$0(int callingUid, int targetUserId, boolean cannotAccessInstantApps, AppStandbyInfo i) {
            if (UsageStatsService.m9131$$Nest$msameApp(this.this$0, callingUid, targetUserId, i.mPackageName) == false) goto L5;
        L8:
            return false;
        L5:
            if (UsageStatsService.m9121$$Nest$misInstantApp(this.this$0, i.mPackageName, targetUserId) == false) goto L8;
            if (cannotAccessInstantApps == false) goto L8;
            return true;
        }

        public void setAppStandbyBuckets(ParceledListSlice appBuckets, int userId) {
            super.setAppStandbyBuckets_enforcePermission();
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            long token = Binder.clearCallingIdentity();
            this.this$0.mAppStandby.setAppStandbyBuckets(appBuckets.getList(), userId, callingUid, callingPid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getAppMinStandbyBucket(String packageName, String callingPackage, int userId) {
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "getAppStandbyBucket", null);     // Catch: RemoteException -> L26
            int packageUid = this.this$0.mPackageManagerInternal.getPackageUid(packageName, 0, userId2);
            if (packageUid != callingUid) goto L9;
        L13:
            boolean isInstantApp = UsageStatsService.m9121$$Nest$misInstantApp(this.this$0, packageName, userId2);
            boolean cannotAccessInstantApps = UsageStatsService.m9137$$Nest$mshouldObfuscateInstantAppsForCaller(this.this$0, callingUid, userId2);
            if (packageUid < 0) goto L25;
            if (isInstantApp == false) goto L17;
            if (cannotAccessInstantApps == true) goto L25;
        L17:
            long token = Binder.clearCallingIdentity();
            int r0 = this.this$0.mAppStandby.getAppMinStandbyBucket(packageName, UserHandle.getAppId(packageUid), userId2, false);     // Catch: Throwable -> L21
            Binder.restoreCallingIdentity(token);
            return r0;
        L21:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L25:
            throw new IllegalArgumentException("Cannot get min standby bucket for non existent package (" + packageName + ")");
        L9:
            if (hasQueryPermission(callingPackage) == true) goto L13;
            throw new SecurityException("Don't have permission to query min app standby bucket");
        L26:
            e = move-exception;
            RemoteException re = e;
        L31:
            throw re.rethrowFromSystemServer();
        L28:
            e = move-exception;
            re = e;
            goto L31
        }

        public void setEstimatedLaunchTime(String packageName, long estimatedLaunchTime, int userId) {
            super.setEstimatedLaunchTime_enforcePermission();
            long token = Binder.clearCallingIdentity();
            UsageStatsService.m9132$$Nest$msetEstimatedLaunchTime(this.this$0, userId, packageName, estimatedLaunchTime);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setEstimatedLaunchTimes(ParceledListSlice estimatedLaunchTimes, int userId) {
            super.setEstimatedLaunchTimes_enforcePermission();
            long token = Binder.clearCallingIdentity();
            UsageStatsService.m9133$$Nest$msetEstimatedLaunchTimes(this.this$0, userId, estimatedLaunchTimes.getList());     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void onCarrierPrivilegedAppsChanged() {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.BIND_CARRIER_SERVICES", "onCarrierPrivilegedAppsChanged can only be called by privileged apps.");
            this.this$0.mAppStandby.clearCarrierPrivilegedApps();
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.getContext(), UsageStatsService.TAG, pw) == true) goto L5;
            return;
        L5:
            this.this$0.dump(args, pw);
        }

        public void reportChooserSelection(String packageName, int userId, String contentType, String[] annotations, String action) {
            if (packageName == null) goto L22;
            if (contentType != null) goto L5;
            return;
        L5:
            if (contentType.isBlank() == true) goto L23;
            if (action != null) goto L8;
            return;
        L8:
            if (action.isBlank() == false) goto L11;
            return;
        L11:
            if (canReportUsageStats() == false) goto L19;
            if (this.this$0.mPackageManagerInternal.getPackageUid(packageName, 0, userId) >= 0) goto L16;
            Slog.w(UsageStatsService.TAG, "Event report user selecting an invalid package");
            return;
        L16:
            UsageEvents.Event event = new UsageEvents.Event(9, SystemClock.elapsedRealtime());
            event.mPackage = packageName;
            event.mAction = action;
            event.mContentType = contentType;
            event.mContentAnnotations = annotations;
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
            return;
        L19:
            throw new SecurityException("Only the system or holders of the REPORT_USAGE_STATS permission are allowed to call reportChooserSelection");
        L23:
            return;
        L22:
            throw new IllegalArgumentException("Package selection must not be null.");
        }

        public void reportUserInteraction(String packageName, int userId) {
            reportUserInteractionInnerHelper(packageName, userId, null);
        }

        public void reportUserInteractionWithBundle(String packageName, int userId, PersistableBundle extras) {
            packageName.getClass();
            if (extras == null) goto L17;
            if (extras.size() == 0) goto L17;
            String category = extras.getString("android.app.usage.extra.EVENT_CATEGORY");
            if (TextUtils.isEmpty(category) == true) goto L15;
            String action = extras.getString("android.app.usage.extra.EVENT_ACTION");
            if (TextUtils.isEmpty(action) == true) goto L13;
            PersistableBundle extrasCopy = new PersistableBundle();
            extrasCopy.putString("android.app.usage.extra.EVENT_CATEGORY", UsageStatsService.m9119$$Nest$mgetTrimmedString(this.this$0, category));
            extrasCopy.putString("android.app.usage.extra.EVENT_ACTION", UsageStatsService.m9119$$Nest$mgetTrimmedString(this.this$0, action));
            reportUserInteractionInnerHelper(packageName, userId, extrasCopy);
            return;
        L13:
            throw new IllegalArgumentException("Empty android.app.usage.extra.EVENT_ACTION");
        L15:
            throw new IllegalArgumentException("Empty android.app.usage.extra.EVENT_CATEGORY");
        L17:
            throw new IllegalArgumentException("Emtry extras!");
        }

        public void registerAppUsageObserver(int observerId, String[] packages, long timeLimitMs, PendingIntent callbackIntent, String callingPackage) {
            if (hasObserverPermission() == false) goto L20;
            if (packages == null) goto L18;
            if (packages.length == 0) goto L18;
            if (callbackIntent == null) goto L16;
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            this.this$0.registerAppUsageObserver(callingUid, observerId, packages, timeLimitMs, callbackIntent, userId);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(token);
            return;
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L16:
            throw new NullPointerException("callbackIntent can't be null");
        L18:
            throw new IllegalArgumentException("Must specify at least one package");
        L20:
            throw new SecurityException("Caller doesn't have OBSERVE_APP_USAGE permission");
        }

        public void unregisterAppUsageObserver(int observerId, String callingPackage) {
            if (hasObserverPermission() == false) goto L12;
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            this.this$0.unregisterAppUsageObserver(callingUid, observerId, userId);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L12:
            throw new SecurityException("Caller doesn't have OBSERVE_APP_USAGE permission");
        }

        public void registerUsageSessionObserver(int sessionObserverId, String[] observed, long timeLimitMs, long sessionThresholdTimeMs, PendingIntent limitReachedCallbackIntent, PendingIntent sessionEndCallbackIntent, String callingPackage) {
            if (hasObserverPermission() == false) goto L20;
            if (observed == null) goto L18;
            if (observed.length == 0) goto L18;
            if (limitReachedCallbackIntent == null) goto L16;
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            this.this$0.registerUsageSessionObserver(callingUid, sessionObserverId, observed, timeLimitMs, sessionThresholdTimeMs, limitReachedCallbackIntent, sessionEndCallbackIntent, userId);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(token);
            return;
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L16:
            throw new NullPointerException("limitReachedCallbackIntent can't be null");
        L18:
            throw new IllegalArgumentException("Must specify at least one observed entity");
        L20:
            throw new SecurityException("Caller doesn't have OBSERVE_APP_USAGE permission");
        }

        public void unregisterUsageSessionObserver(int sessionObserverId, String callingPackage) {
            if (hasObserverPermission() == false) goto L12;
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            this.this$0.unregisterUsageSessionObserver(callingUid, sessionObserverId, userId);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L12:
            throw new SecurityException("Caller doesn't have OBSERVE_APP_USAGE permission");
        }

        public void registerAppUsageLimitObserver(int observerId, String[] packages, long timeLimitMs, long timeUsedMs, PendingIntent callbackIntent, String callingPackage) {
            int callingUid = Binder.getCallingUid();
            if (hasPermissions(new String[]{"android.permission.SUSPEND_APPS", "android.permission.OBSERVE_APP_USAGE"}) == false) goto L5;
        L9:
            if (packages == null) goto L26;
            if (packages.length == 0) goto L26;
            if (callbackIntent == null) goto L14;
        L18:
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            this.this$0.registerAppUsageLimitObserver(callingUid, observerId, packages, timeLimitMs, timeUsedMs, callbackIntent, userId);     // Catch: Throwable -> L22
            Binder.restoreCallingIdentity(token);
            return;
        L22:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L14:
            if (timeUsedMs >= timeLimitMs) goto L18;
            throw new NullPointerException("callbackIntent can't be null");
        L26:
            throw new IllegalArgumentException("Must specify at least one package");
        L5:
            if (UsageStatsService.m9122$$Nest$misSupervisionEnabled(this.this$0, callingUid) == true) goto L9;
            throw new SecurityException("Caller must be the active supervision app or it must have both SUSPEND_APPS and OBSERVE_APP_USAGE permissions");
        }

        public void unregisterAppUsageLimitObserver(int observerId, String callingPackage) {
            int callingUid = Binder.getCallingUid();
            if (hasPermissions(new String[]{"android.permission.SUSPEND_APPS", "android.permission.OBSERVE_APP_USAGE"}) == false) goto L5;
        L9:
            int userId = UserHandle.getUserId(callingUid);
            long token = Binder.clearCallingIdentity();
            this.this$0.unregisterAppUsageLimitObserver(callingUid, observerId, userId);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(token);
            return;
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            if (UsageStatsService.m9122$$Nest$misSupervisionEnabled(this.this$0, callingUid) == true) goto L9;
            throw new SecurityException("Caller must be the active supervision app or it must have both SUSPEND_APPS and OBSERVE_APP_USAGE permissions");
        }

        public void reportUsageStart(IBinder activity, String token, String callingPackage) {
            reportPastUsageStart(activity, token, 0, callingPackage);
        }

        public void reportPastUsageStart(IBinder activity, String token, long timeAgoMs, String callingPackage) {
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            long binderToken = Binder.clearCallingIdentity();
            SparseArray<ArraySet<String>> r4 = this.this$0.mUsageReporters;     // Catch: Throwable -> L18
            monitor-enter(r4);     // Catch: Throwable -> L18
            ArraySet<String> tokens = this.this$0.mUsageReporters.get(activity.hashCode());     // Catch: Throwable -> L8
            if (tokens != null) goto L10;
            tokens = new ArraySet();     // Catch: Throwable -> L8
            this.this$0.mUsageReporters.put(activity.hashCode(), tokens);     // Catch: Throwable -> L8
        L10:
            monitor-exit(r4);     // Catch: Throwable -> L8
            monitor-enter(tokens);     // Catch: Throwable -> L18
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L13:
            if (tokens.add(token) == false) goto L23;
            monitor-exit(tokens);     // Catch: Throwable -> L20
            this.this$0.mAppTimeLimit.noteUsageStart(UsageStatsService.m9117$$Nest$mbuildFullToken(this.this$0, callingPackage, token), userId, timeAgoMs);     // Catch: Throwable -> L18
            Binder.restoreCallingIdentity(binderToken);
            return;
        L23:
            throw new IllegalArgumentException(token + " for " + callingPackage + " is already reported as started for this activity");     // Catch: Throwable -> L20
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(binderToken);
            throw th;
        }

        public void reportUsageStop(IBinder activity, String token, String callingPackage) {
            int callingUid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            long binderToken = Binder.clearCallingIdentity();
            SparseArray<ArraySet<String>> r4 = this.this$0.mUsageReporters;     // Catch: Throwable -> L15
            monitor-enter(r4);     // Catch: Throwable -> L15
            ArraySet<String> tokens = this.this$0.mUsageReporters.get(activity.hashCode());     // Catch: Throwable -> L23
            if (tokens == null) goto L26;
            monitor-exit(r4);     // Catch: Throwable -> L23
            monitor-enter(tokens);     // Catch: Throwable -> L15
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L10:
            if (tokens.remove(token) == false) goto L20;
            monitor-exit(tokens);     // Catch: Throwable -> L17
            this.this$0.mAppTimeLimit.noteUsageStop(UsageStatsService.m9117$$Nest$mbuildFullToken(this.this$0, callingPackage, token), userId);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(binderToken);
            return;
        L20:
            throw new IllegalArgumentException(token + " for " + callingPackage + " is already reported as stopped for this activity");     // Catch: Throwable -> L17
        L26:
            throw new IllegalArgumentException("Unknown reporter trying to stop token " + token + " for " + callingPackage);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(binderToken);
            throw th;
        }

        public int getUsageSource() {
            if (hasObserverPermission() == false) goto L13;
            Object r0 = UsageStatsService.m9113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = this.this$0.mUsageSource;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new SecurityException("Caller doesn't have OBSERVE_APP_USAGE permission");
        }

        public void forceUsageSourceSettingRead() {
            UsageStatsService.m9127$$Nest$mreadUsageSourceSetting(this.this$0);
        }

        public long getLastTimeAnyComponentUsed(String packageName, String callingPackage) {
            if (hasPermissions(new String[]{"android.permission.INTERACT_ACROSS_USERS"}) == false) goto L17;
            if (hasQueryPermission(callingPackage) == false) goto L15;
            Object r0 = UsageStatsService.m9113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            long r1 = (((Long) UsageStatsService.m9112$$Nest$fgetmLastTimeComponentUsedGlobal(this.this$0).getOrDefault(packageName, 0L)).longValue() / TimeUnit.DAYS.toMillis(1)) * TimeUnit.DAYS.toMillis(1);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        L15:
            throw new SecurityException("Don't have permission to query usage stats");
        L17:
            throw new SecurityException("Caller doesn't have INTERACT_ACROSS_USERS permission");
        }

        public BroadcastResponseStatsList queryBroadcastResponseStats(String packageName, long id, String callingPackage, int userId) {
            callingPackage.getClass();
            if (id < 0) goto L7;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.ACCESS_BROADCAST_RESPONSE_STATS", "queryBroadcastResponseStats");
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "queryBroadcastResponseStats", callingPackage);
            return new BroadcastResponseStatsList(UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).queryBroadcastResponseStats(callingUid, packageName, id, userId2));
        L7:
            throw new IllegalArgumentException("id needs to be >=0");
        }

        public void clearBroadcastResponseStats(String packageName, long id, String callingPackage, int userId) {
            callingPackage.getClass();
            if (id < 0) goto L7;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.ACCESS_BROADCAST_RESPONSE_STATS", "clearBroadcastResponseStats");
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "clearBroadcastResponseStats", callingPackage);
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).clearBroadcastResponseStats(callingUid, packageName, id, userId2);
            return;
        L7:
            throw new IllegalArgumentException("id needs to be >=0");
        }

        public void clearBroadcastEvents(String callingPackage, int userId) {
            callingPackage.getClass();
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.ACCESS_BROADCAST_RESPONSE_STATS", "clearBroadcastEvents");
            int callingUid = Binder.getCallingUid();
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "clearBroadcastResponseStats", callingPackage);
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).clearBroadcastEvents(callingUid, userId2);
        }

        public boolean isPackageExemptedFromBroadcastResponseStats(String callingPackage, int userId) {
            callingPackage.getClass();
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DUMP", "isPackageExemptedFromBroadcastResponseStats");
            return UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).isPackageExemptedFromBroadcastResponseStats(callingPackage, UserHandle.of(userId));
        }

        public String getAppStandbyConstant(String key) {
            key.getClass();
            if (hasPermissions(new String[]{"android.permission.READ_DEVICE_CONFIG"}) == false) goto L7;
            return this.this$0.mAppStandby.getAppStandbyConstant(key);
        L7:
            throw new SecurityException("Caller doesn't have READ_DEVICE_CONFIG permission");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
            return new UsageStatsShellCommand(this.this$0).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
        }

        public Map<String, Long> queryNbStatsTotalTime(List<String> pkgNames, String callingPackage, int userId) throws RemoteException {
            if (hasQueryPermission(callingPackage) == true) goto L6;
            return null;
        L6:
            long currentTimeMillis = System.currentTimeMillis();
            return queryNbStatsTime(pkgNames, currentTimeMillis - 94608000000L, currentTimeMillis, callingPackage, userId);
        }

        public Map<String, Long> queryNbStatsTime(List<String> pkgNames, long beginTime, long endTime, String callingPackage, int userId) throws RemoteException {
            if (hasQueryPermission(callingPackage) == true) goto L6;
            return null;
        L6:
            long currentTimeMillis = System.currentTimeMillis();
            long expiryTime = currentTimeMillis - 864000000;
            new HashMap();
            if (beginTime <= expiryTime) goto L10;
            UsageEvents usageEvents = queryEvents(beginTime, endTime, callingPackage);
            Map<String, Long> result = NBUsageTimeStatsPolicy.parseUsageEvents(usageEvents, pkgNames, beginTime, endTime);
            return result;
        L10:
            if (endTime >= expiryTime) goto L12;
            Map<String, Long> result2 = queryStatsByUss(pkgNames, beginTime, endTime, callingPackage, userId);
            return result2;
        L12:
            UsageEvents usageEvents2 = queryEvents(expiryTime, endTime, callingPackage);
            Map<String, Long> resultByEvents = NBUsageTimeStatsPolicy.parseUsageEvents(usageEvents2, pkgNames, expiryTime, endTime);
            Map<String, Long> resultByUss = queryStatsByUss(pkgNames, beginTime, expiryTime, callingPackage, userId);
            Map<String, Long> result3 = NBUsageTimeStatsPolicy.mergeStatsResult(resultByEvents, resultByUss);
            return result3;
        }

        private Map<String, Long> queryStatsByUss(List<String> pkgNames, long beginTime, long endTime, String callingPackage, int userId) {
            ParceledListSlice<UsageStats> slice = queryUsageStats(4, beginTime, endTime, callingPackage, userId);
            List<UsageStats> usageStatsList = new ArrayList();
            if (slice == null) goto L5;
            usageStatsList = slice.getList();
        L5:
            Map<String, Long> resultByUss = new HashMap();
            Iterator<UsageStats> r3 = usageStatsList.iterator();
        L7:
            if (r3.hasNext() == false) goto L17;
            UsageStats usageStats = r3.next();
            String pkgname = usageStats.getPackageName();
            if (pkgNames.size() <= 0) goto L7;
            if (pkgNames.contains(pkgname) == false) goto L7;
            long totalTime = usageStats.getTotalTimeInForeground();
            if (resultByUss.containsKey(pkgname) == true) goto L14;
            resultByUss.put(pkgname, Long.valueOf(totalTime));
            goto L7
        L14:
            long time = resultByUss.get(pkgname).longValue();
            resultByUss.put(pkgname, Long.valueOf(totalTime + time));
            goto L7
        L17:
            return resultByUss;
        }

        public Map<String, Integer> queryNbStatsCount(List<String> pkgNames, long beginTime, long endTime, long threshold, String callingPackage) throws RemoteException {
            if (hasQueryPermission(callingPackage) == true) goto L6;
            return null;
        L6:
            UsageEvents usageEvents = queryEvents(beginTime, endTime, callingPackage);
            return NBUsageTimeStatsPolicy.queryNbStatsCount(usageEvents, pkgNames, beginTime, endTime, threshold);
        }

        public List<Map<String, Long>> queryNbStatsDistribution(List<String> pkgNames, long beginTime, long endTime, long offset, String callingPackage) throws RemoteException {
            BinderService r0 = this;
            String r5 = callingPackage;
            if (r0.hasQueryPermission(r5) == true) goto L6;
            return null;
        L6:
            List<Map<String, Long>> distributionResult = new ArrayList();
            long eTime = beginTime + offset;
            if (offset > 7200000) goto L9;
            boolean r6 = true;
        L10:
            boolean eventOverOffset = r6;
            int eventOverOffsetCount = 0;
            long bTime = beginTime;
            long eTime2 = eTime;
        L12:
            if (eTime2 > endTime) goto L29;
            UsageEvents usageEvents = r0.queryEvents(bTime, eTime2, r5);
            long eTime3 = eTime2;
            long bTime2 = bTime;
            Map<String, Long> parseResult = NBUsageTimeStatsPolicy.parseUsageEvents(usageEvents, pkgNames, bTime2, eTime3);
            if (eventOverOffset == true) goto L16;
            distributionResult.add(parseResult);
        L28:
            bTime = bTime2 + offset;
            eTime2 = eTime3 + offset;
            r0 = this;
            r5 = callingPackage;
            goto L12
        L16:
            if (parseResult.size() != 0) goto L18;
            eventOverOffsetCount = eventOverOffsetCount + 1;
            goto L28
        L18:
            if (eventOverOffsetCount <= 0) goto L26;
            UsageEvents.Event fPausedEvent = findTheOverOffsetPausedEvent(bTime2, eTime3, callingPackage, pkgNames);
            int i = 0;
        L20:
            if (i >= eventOverOffsetCount) goto L25;
            Map<String, Long> zone = new HashMap();
            if (fPausedEvent == null) goto L24;
            zone.put(fPausedEvent.getPackageName(), Long.valueOf(offset));
        L24:
            distributionResult.add(zone);
            i = i + 1;
            goto L20
        L25:
            distributionResult.add(parseResult);
            eventOverOffsetCount = 0;
            goto L28
        L26:
            distributionResult.add(parseResult);
            goto L28
        L29:
            long lastOffset = (endTime - beginTime) % offset;
            if (lastOffset <= 0) goto L40;
            if (eventOverOffsetCount <= 0) goto L39;
            UsageEvents.Event thePausedEvent = findTheOverOffsetPausedEvent(endTime - lastOffset, endTime, callingPackage, pkgNames);
            int i2 = 0;
        L33:
            if (i2 >= eventOverOffsetCount) goto L39;
            Map<String, Long> zonetime = new HashMap();
            if (thePausedEvent == null) goto L37;
            zonetime.put(thePausedEvent.getPackageName(), Long.valueOf(offset));
        L37:
            distributionResult.add(zonetime);
            i2 = i2 + 1;
        L39:
            UsageEvents usageEvents2 = queryEvents(endTime - lastOffset, endTime, callingPackage);
            distributionResult.add(NBUsageTimeStatsPolicy.parseUsageEvents(usageEvents2, pkgNames, endTime - lastOffset, endTime));
        L40:
            return distributionResult;
        L9:
            r6 = false;
            goto L10
        }

        private UsageEvents.Event findTheOverOffsetPausedEvent(long bTime, long eTime, String callingPackage, List<String> pkgNames) {
            UsageEvents events = queryEvents(bTime, eTime, callingPackage);
            if (events != null) goto L6;
            Slog.i(UsageStatsService.TAG, "findTheOverOffsetPausedEvent, events  is null , bTime = " + bTime + ", eTime = " + eTime);
            return null;
        L6:
            UsageEvents.Event fResumedEvent = null;
        L8:
            if (events.hasNextEvent() == false) goto L33;
            UsageEvents.Event event = new UsageEvents.Event();
            events.getNextEvent(event);
            if (2 != event.getEventType()) goto L18;
            if (0 != 0) goto L18;
            if (fResumedEvent != null) goto L18;
            if (pkgNames != null) goto L15;
            return null;
        L15:
            if (pkgNames.contains(event.getPackageName()) == false) goto L31;
            Slog.i(UsageStatsService.TAG, "findTheOverOffsetPausedEvent, fPausedEvent [" + event.getPackageName() + ", " + event.getTimeStamp() + "]");
            return event;
        L31:
            return null;
        L18:
            if (1 != event.getEventType()) goto L8;
            if (fResumedEvent != null) goto L8;
            fResumedEvent = event;
            goto L8
        L33:
            return null;
        }
    }

    class H extends Handler {
        final /* synthetic */ UsageStatsService this$0;

        public H(UsageStatsService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L58;
                case 1: goto L57;
                case 2: goto L56;
                case 3: goto L4;
                case 4: goto L55;
                case 5: goto L41;
                case 6: goto L40;
                case 7: goto L32;
                case 8: goto L4;
                case 9: goto L7;
                case 10: goto L6;
                case 11: goto L5;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L5:
            this.this$0.mAppStandby.postCheckIdleStates(msg.arg1);
            return;
        L6:
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).onUidRemoved(msg.arg1);
            return;
        L7:
            removeMessages(9);
            ArraySet<String> pkgNames = new ArraySet();
            SparseSetArray r1 = UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0);
            monitor-enter(r1);
            int numUsers = UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0).size();     // Catch: Throwable -> L29
            monitor-exit(r1);     // Catch: Throwable -> L29
            int u = numUsers - 1;
        L12:
            if (u < 0) goto L80;
            pkgNames.clear();
            SparseSetArray r3 = UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0);
            monitor-enter(r3);
            int userId = UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0).keyAt(u);     // Catch: Throwable -> L25
            pkgNames.addAll(UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0).get(userId));     // Catch: Throwable -> L25
            UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0).remove(userId);     // Catch: Throwable -> L25
            monitor-exit(r3);     // Catch: Throwable -> L25
            int p = pkgNames.size() - 1;
        L18:
            if (p < 0) goto L24;
            String pkgName = pkgNames.valueAt(p);
            long nextEstimatedLaunchTime = this.this$0.getEstimatedPackageLaunchTime(userId, pkgName);
            Iterator r8 = UsageStatsService.m9109$$Nest$fgetmEstimatedLaunchTimeChangedListeners(this.this$0).iterator();
        L21:
            if (r8.hasNext() == false) goto L23;
            UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener listener = (UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener) r8.next();
            listener.onEstimatedLaunchTimeChanged(userId, pkgName, nextEstimatedLaunchTime);
            goto L21
        L23:
            p = p - 1;
            goto L18
        L24:
            u = u - 1;
        L25:
            th = move-exception;
            throw th;
        L80:
            return;
        L29:
            th = move-exception;
            throw th;
        L32:
            Object r0 = UsageStatsService.m9113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UsageStatsService.m9123$$Nest$mloadGlobalComponentUsageLocked(this.this$0);     // Catch: Throwable -> L37
            monitor-exit(r0);     // Catch: Throwable -> L37
            return;
        L37:
            th = move-exception;
            throw th;
        L40:
            UsageStatsService.m9124$$Nest$monPackageRemoved(this.this$0, msg.arg1, (String) msg.obj);
            return;
        L41:
            int userId2 = msg.arg1;
            Trace.traceBegin(524288, "usageStatsHandleUserUnlocked(" + userId2 + ")");     // Catch: Throwable -> L44 Exception -> L46
            UsageStatsService.m9125$$Nest$monUserUnlocked(this.this$0, userId2);     // Catch: Throwable -> L44 Exception -> L46
        L43:
            Trace.traceEnd(524288);
            return;
        L44:
            th = move-exception;
            Trace.traceEnd(524288);
            throw th;
        L46:
            e = move-exception;
            if (this.this$0.mUserManager.isUserUnlocked(userId2) == true) goto L52;
            Slog.w(UsageStatsService.TAG, "Attempted to unlock stopped or removed user " + msg.arg1);     // Catch: Throwable -> L44
            goto L43
        L52:
            throw e;     // Catch: Throwable -> L44
        L55:
            this.this$0.reportEventToAllUserId((UsageEvents.Event) msg.obj);
            return;
        L56:
            this.this$0.onUserRemoved(msg.arg1);
            return;
        L57:
            this.this$0.flushToDisk();
            return;
        L58:
            this.this$0.reportEvent((UsageEvents.Event) msg.obj, msg.arg1);
        }
    }

    static class Injector {
        Injector() {
        }

        AppStandbyInternal getAppStandbyController(Context context) {
            return AppStandbyInternal.newAppStandbyController(UsageStatsService.class.getClassLoader(), context);
        }
    }

    private class LaunchTimeAlarmQueue extends AlarmQueue<String> {
        private final int mUserId;
        final /* synthetic */ UsageStatsService this$0;

        @Override // com.android.server.utils.AlarmQueue
        protected /* bridge */ /* synthetic */ boolean isForUser(String r1, int r2) {
            return isForUser2(r1, r2);
        }

        LaunchTimeAlarmQueue(UsageStatsService r9, int userId, Context context, Looper looper) {
            this.this$0 = r9;
            super(context, looper, "*usage.launchTime*", "Estimated launch times", true, 30000);
            this.mUserId = userId;
        }

        /* JADX INFO: renamed from: isForUser, reason: avoid collision after fix types in other method */
        protected boolean isForUser2(String key, int userId) {
            if (this.mUserId != userId) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.utils.AlarmQueue
        protected void processExpiredAlarms(ArraySet<String> expired) {
            if (expired.size() <= 0) goto L12;
            SparseSetArray r0 = UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0);
            monitor-enter(r0);
            UsageStatsService.m9114$$Nest$fgetmPendingLaunchTimeChangePackages(this.this$0).addAll(this.mUserId, expired);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            UsageStatsService.m9110$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(9);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private final class LocalService extends UsageStatsManagerInternal {
        final /* synthetic */ UsageStatsService this$0;

        /* synthetic */ LocalService(UsageStatsService r1, UsageStatsServiceIA r2) {
            this(r1);
        }

        private LocalService(UsageStatsService r1) {
            this.this$0 = r1;
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportEvent(ComponentName component, int userId, int eventType, int instanceId, ComponentName taskRoot) {
            reportEvent(component, userId, eventType, instanceId, taskRoot, null);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportEvent(ComponentName component, int userId, int eventType, int instanceId, ComponentName taskRoot, String extraDisplayInfo) {
            if (component != null) goto L5;
            Slog.w(UsageStatsService.TAG, "Event reported without a component name");
            return;
        L5:
            UsageEvents.Event event = new UsageEvents.Event(eventType, SystemClock.elapsedRealtime());
            event.mPackage = component.getPackageName();
            event.mClass = component.getClassName();
            event.mInstanceId = instanceId;
            if (taskRoot != null) goto L8;
            event.mTaskRootPackage = null;
            event.mTaskRootClass = null;
        L9:
            if (extraDisplayInfo == null) goto L11;
            event.mExtraDisplayInfo = extraDisplayInfo;
        L11:
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
            return;
        L8:
            event.mTaskRootPackage = taskRoot.getPackageName();
            event.mTaskRootClass = taskRoot.getClassName();
            goto L9
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportEvent(String packageName, int userId, int eventType) {
            if (packageName != null) goto L5;
            Slog.w(UsageStatsService.TAG, "Event reported without a package name, eventType:" + eventType);
            return;
        L5:
            UsageEvents.Event event = new UsageEvents.Event(eventType, SystemClock.elapsedRealtime());
            event.mPackage = packageName;
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportEventForAllUsers(String packageName, int eventType) {
            if (packageName != null) goto L5;
            Slog.w(UsageStatsService.TAG, "Event reported without a package name, eventType:" + eventType);
            return;
        L5:
            UsageEvents.Event event = new UsageEvents.Event(eventType, SystemClock.elapsedRealtime());
            event.mPackage = packageName;
            this.this$0.reportEventToAllUserId(event);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportConfigurationChange(Configuration config, int userId) {
            if (config != null) goto L5;
            Slog.w(UsageStatsService.TAG, "Configuration event reported with a null config");
            return;
        L5:
            UsageEvents.Event event = new UsageEvents.Event(5, SystemClock.elapsedRealtime());
            event.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;
            event.mConfiguration = new Configuration(config);
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportInterruptiveNotification(String packageName, String channelId, int userId) {
            if (packageName == null) goto L7;
            if (channelId == null) goto L7;
            UsageEvents.Event event = new UsageEvents.Event(12, SystemClock.elapsedRealtime());
            event.mPackage = packageName.intern();
            event.mNotificationChannelId = channelId.intern();
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
            return;
        L7:
            Slog.w(UsageStatsService.TAG, "Event reported without a package name or a channel ID");
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportShortcutUsage(String packageName, String shortcutId, int userId) {
            if (packageName == null) goto L7;
            if (shortcutId == null) goto L7;
            UsageEvents.Event event = new UsageEvents.Event(8, SystemClock.elapsedRealtime());
            event.mPackage = packageName.intern();
            event.mShortcutId = shortcutId.intern();
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
            return;
        L7:
            Slog.w(UsageStatsService.TAG, "Event reported without a package name or a shortcut ID");
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportLocusUpdate(ComponentName activity, int userId, LocusId locusId, IBinder appToken) {
            if (locusId != null) goto L4;
            return;
        L4:
            UsageEvents.Event event = new UsageEvents.Event(30, SystemClock.elapsedRealtime());
            event.mLocusId = locusId.getId();
            event.mPackage = activity.getPackageName();
            event.mClass = activity.getClassName();
            event.mInstanceId = appToken.hashCode();
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportContentProviderUsage(String name, String packageName, int userId) {
            this.this$0.mAppStandby.postReportContentProviderUsage(name, packageName, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportUserInteractionEvent(String pkgName, int userId, PersistableBundle extras) {
            if (extras != null) goto L4;
        L6:
            UsageEvents.Event event = new UsageEvents.Event(7, SystemClock.elapsedRealtime());
            event.mPackage = pkgName;
            event.mExtras = extras;
            UsageStatsService.m9130$$Nest$mreportEventOrAddToQueue(this.this$0, userId, event);
            return;
        L4:
            if (extras.size() == 0) goto L6;
            String category = extras.getString("android.app.usage.extra.EVENT_CATEGORY");
            String action = extras.getString("android.app.usage.extra.EVENT_ACTION");
            extras.putString("android.app.usage.extra.EVENT_CATEGORY", UsageStatsService.m9119$$Nest$mgetTrimmedString(this.this$0, category));
            extras.putString("android.app.usage.extra.EVENT_ACTION", UsageStatsService.m9119$$Nest$mgetTrimmedString(this.this$0, action));
            goto L6
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public boolean isAppIdle(String packageName, int uidForAppId, int userId) {
            return this.this$0.mAppStandby.isAppIdleFiltered(packageName, uidForAppId, userId, SystemClock.elapsedRealtime());
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public int getAppStandbyBucket(String packageName, int userId, long nowElapsed) {
            return this.this$0.mAppStandby.getAppStandbyBucket(packageName, userId, nowElapsed, false);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public int[] getIdleUidsForUser(int userId) {
            return this.this$0.mAppStandby.getIdleUidsForUser(userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void prepareShutdown() {
            this.this$0.shutdown();
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void prepareForPossibleShutdown() {
            this.this$0.prepareForPossibleShutdown();
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public byte[] getBackupPayload(int userId, String key) {
            if (UsageStatsService.m9116$$Nest$fgetmUserUnlockedStates(this.this$0).contains(Integer.valueOf(userId)) == true) goto L6;
            Slog.w(UsageStatsService.TAG, "Failed to get backup payload for locked user " + userId);
            return null;
        L6:
            Object r0 = UsageStatsService.m9113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserUsageStatsService userStats = UsageStatsService.m9120$$Nest$mgetUserUsageStatsServiceLocked(this.this$0, userId);     // Catch: Throwable -> L12
            if (userStats != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L12
            return null;
        L14:
            Slog.i(UsageStatsService.TAG, "Returning backup payload for u=" + userId);     // Catch: Throwable -> L12
            byte[] r1 = userStats.getBackupPayload(key);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void applyRestoredPayload(int userId, String key, byte[] payload) {
            Object r0 = UsageStatsService.m9113$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (UsageStatsService.m9116$$Nest$fgetmUserUnlockedStates(this.this$0).contains(Integer.valueOf(userId)) == true) goto L11;
            Slog.w(UsageStatsService.TAG, "Failed to apply restored payload for locked user " + userId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            UserUsageStatsService userStats = UsageStatsService.m9120$$Nest$mgetUserUsageStatsServiceLocked(this.this$0, userId);     // Catch: Throwable -> L9
            if (userStats != null) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L15:
            Set<String> restoredApps = userStats.applyRestoredPayload(key, payload);     // Catch: Throwable -> L9
            this.this$0.mAppStandby.restoreAppsToRare(restoredApps, userId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public List<UsageStats> queryUsageStatsForUser(int userId, int intervalType, long beginTime, long endTime, boolean obfuscateInstantApps) {
            return this.this$0.queryUsageStats(userId, intervalType, beginTime, endTime, obfuscateInstantApps);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public UsageEvents queryEventsForUser(int userId, long beginTime, long endTime, int flags) {
            return this.this$0.queryEvents(userId, beginTime, endTime, flags);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void setLastJobRunTime(String packageName, int userId, long elapsedRealtime) {
            this.this$0.mAppStandby.setLastJobRunTime(packageName, userId, elapsedRealtime);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public long getEstimatedPackageLaunchTime(String packageName, int userId) {
            return this.this$0.getEstimatedPackageLaunchTime(userId, packageName);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public long getTimeSinceLastJobRun(String packageName, int userId) {
            return this.this$0.mAppStandby.getTimeSinceLastJobRun(packageName, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportAppJobState(String packageName, int userId, int numDeferredJobs, long timeSinceLastJobRun) {
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void onActiveAdminAdded(String packageName, int userId) {
            this.this$0.mAppStandby.addActiveDeviceAdmin(packageName, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void setActiveAdminApps(Set<String> packageNames, int userId) {
            this.this$0.mAppStandby.setActiveAdminApps(packageNames, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void setAdminProtectedPackages(Set<String> packageNames, int userId) {
            this.this$0.mAppStandby.setAdminProtectedPackages(packageNames, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void onAdminDataAvailable() {
            this.this$0.mAppStandby.onAdminDataAvailable();
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportSyncScheduled(String packageName, int userId, boolean exempted) {
            this.this$0.mAppStandby.postReportSyncScheduled(packageName, userId, exempted);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportExemptedSyncStart(String packageName, int userId) {
            this.this$0.mAppStandby.postReportExemptedSyncStart(packageName, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public UsageStatsManagerInternal.AppUsageLimitData getAppUsageLimit(String packageName, UserHandle user) {
            return this.this$0.mAppTimeLimit.getAppUsageLimit(packageName, user);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public boolean pruneUninstalledPackagesData(int userId) {
            return UsageStatsService.m9126$$Nest$mpruneUninstalledPackagesData(this.this$0, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public boolean updatePackageMappingsData(int userId) {
            return UsageStatsService.m9141$$Nest$mupdatePackageMappingsData(this.this$0, userId);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void registerListener(UsageStatsManagerInternal.UsageEventListener listener) {
            UsageStatsService.m9129$$Nest$mregisterListener(this.this$0, listener);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void unregisterListener(UsageStatsManagerInternal.UsageEventListener listener) {
            UsageStatsService.m9140$$Nest$munregisterListener(this.this$0, listener);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void registerLaunchTimeChangedListener(UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener listener) {
            UsageStatsService.m9128$$Nest$mregisterLaunchTimeChangedListener(this.this$0, listener);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void unregisterLaunchTimeChangedListener(UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener listener) {
            UsageStatsService.m9139$$Nest$munregisterLaunchTimeChangedListener(this.this$0, listener);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportBroadcastDispatched(int sourceUid, String targetPackage, UserHandle targetUser, long idForResponseEvent, long timestampMs, int targetUidProcState) {
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).reportBroadcastDispatchEvent(sourceUid, targetPackage, targetUser, idForResponseEvent, timestampMs, targetUidProcState);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportNotificationPosted(String packageName, UserHandle user, long timestampMs) {
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).reportNotificationPosted(packageName, user, timestampMs);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportNotificationUpdated(String packageName, UserHandle user, long timestampMs) {
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).reportNotificationUpdated(packageName, user, timestampMs);
        }

        @Override // android.app.usage.UsageStatsManagerInternal
        public void reportNotificationRemoved(String packageName, UserHandle user, long timestampMs) {
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).reportNotificationCancelled(packageName, user, timestampMs);
        }
    }

    private class MyPackageMonitor extends PackageMonitor {
        final /* synthetic */ UsageStatsService this$0;

        /* synthetic */ MyPackageMonitor(UsageStatsService r1, UsageStatsServiceIA r2) {
            this(r1);
        }

        private MyPackageMonitor(UsageStatsService r1) {
            this.this$0 = r1;
        }

        public void onPackageRemoved(String packageName, int uid) {
            int changingUserId = getChangingUserId();
            if (UsageStatsService.m9134$$Nest$mshouldDeleteObsoleteData(this.this$0, UserHandle.of(changingUserId)) == false) goto L5;
            UsageStatsService.m9110$$Nest$fgetmHandler(this.this$0).obtainMessage(6, changingUserId, 0, packageName).sendToTarget();
        L5:
            UsageStatsService.m9115$$Nest$fgetmResponseStatsTracker(this.this$0).onPackageRemoved(packageName, UserHandle.getUserId(uid));
            super.onPackageRemoved(packageName, uid);
        }
    }

    private class UidRemovedReceiver extends BroadcastReceiver {
        final /* synthetic */ UsageStatsService this$0;

        /* synthetic */ UidRemovedReceiver(UsageStatsService r1, UsageStatsServiceIA r2) {
            this(r1);
        }

        private UidRemovedReceiver(UsageStatsService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int uid = intent.getIntExtra("android.intent.extra.UID", -1);
            if (uid != (-1)) goto L5;
            return;
        L5:
            UsageStatsService.m9110$$Nest$fgetmHandler(this.this$0).obtainMessage(10, uid, 0).sendToTarget();
        }
    }

    private class UserActionsReceiver extends BroadcastReceiver {
        final /* synthetic */ UsageStatsService this$0;

        /* synthetic */ UserActionsReceiver(UsageStatsService r1, UsageStatsServiceIA r2) {
            this(r1);
        }

        private UserActionsReceiver(UsageStatsService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int userId = intent.getIntExtra("android.intent.extra.user_handle", -1);
            String action = intent.getAction();
            if ("android.intent.action.USER_REMOVED".equals(action) == false) goto L7;
            if (userId < 0) goto L12;
            UsageStatsService.m9110$$Nest$fgetmHandler(this.this$0).obtainMessage(2, userId, 0).sendToTarget();
            return;
        L12:
            return;
        L7:
            if ("android.intent.action.USER_STARTED".equals(action) == false) goto L14;
            if (userId < 0) goto L15;
            if (userId <= 0) goto L16;
            UsageStatsService.m9110$$Nest$fgetmHandler(this.this$0).obtainMessage(11, userId, 0).sendToTarget();
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$TpcNng9zAtQEa_4AWZmaJYBdR0c(UsageStatsService r0, Message r1) {
        return r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEstimatedLaunchTimeChangedListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArraySet m9109$$Nest$fgetmEstimatedLaunchTimeChangedListeners(UsageStatsService r0) {
        return r0.mEstimatedLaunchTimeChangedListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9110$$Nest$fgetmHandler(UsageStatsService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIoHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9111$$Nest$fgetmIoHandler(UsageStatsService r0) {
        return r0.mIoHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastTimeComponentUsedGlobal, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m9112$$Nest$fgetmLastTimeComponentUsedGlobal(UsageStatsService r0) {
        return r0.mLastTimeComponentUsedGlobal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9113$$Nest$fgetmLock(UsageStatsService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingLaunchTimeChangePackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseSetArray m9114$$Nest$fgetmPendingLaunchTimeChangePackages(UsageStatsService r0) {
        return r0.mPendingLaunchTimeChangePackages;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResponseStatsTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ BroadcastResponseStatsTracker m9115$$Nest$fgetmResponseStatsTracker(UsageStatsService r0) {
        return r0.mResponseStatsTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserUnlockedStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArraySet m9116$$Nest$fgetmUserUnlockedStates(UsageStatsService r0) {
        return r0.mUserUnlockedStates;
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildFullToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9117$$Nest$mbuildFullToken(UsageStatsService r0, String r1, String r2) {
        return r0.buildFullToken(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDpmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ DevicePolicyManagerInternal m9118$$Nest$mgetDpmInternal(UsageStatsService r0) {
        return r0.getDpmInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTrimmedString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9119$$Nest$mgetTrimmedString(UsageStatsService r0, String r1) {
        return r0.getTrimmedString(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserUsageStatsServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserUsageStatsService m9120$$Nest$mgetUserUsageStatsServiceLocked(UsageStatsService r0, int r1) {
        return r0.getUserUsageStatsServiceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misInstantApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9121$$Nest$misInstantApp(UsageStatsService r0, String r1, int r2) {
        return r0.isInstantApp(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misSupervisionEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9122$$Nest$misSupervisionEnabled(UsageStatsService r0, int r1) {
        return r0.isSupervisionEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mloadGlobalComponentUsageLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9123$$Nest$mloadGlobalComponentUsageLocked(UsageStatsService r0) {
        r0.loadGlobalComponentUsageLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9124$$Nest$monPackageRemoved(UsageStatsService r0, int r1, String r2) {
        r0.onPackageRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9125$$Nest$monUserUnlocked(UsageStatsService r0, int r1) {
        r0.onUserUnlocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpruneUninstalledPackagesData, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9126$$Nest$mpruneUninstalledPackagesData(UsageStatsService r0, int r1) {
        return r0.pruneUninstalledPackagesData(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadUsageSourceSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9127$$Nest$mreadUsageSourceSetting(UsageStatsService r0) {
        r0.readUsageSourceSetting();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterLaunchTimeChangedListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9128$$Nest$mregisterLaunchTimeChangedListener(UsageStatsService r0, UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener r1) {
        r0.registerLaunchTimeChangedListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9129$$Nest$mregisterListener(UsageStatsService r0, UsageStatsManagerInternal.UsageEventListener r1) {
        r0.registerListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportEventOrAddToQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9130$$Nest$mreportEventOrAddToQueue(UsageStatsService r0, int r1, UsageEvents.Event r2) {
        r0.reportEventOrAddToQueue(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msameApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9131$$Nest$msameApp(UsageStatsService r0, int r1, int r2, String r3) {
        return r0.sameApp(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetEstimatedLaunchTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9132$$Nest$msetEstimatedLaunchTime(UsageStatsService r0, int r1, String r2, long r3) {
        r0.setEstimatedLaunchTime(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetEstimatedLaunchTimes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9133$$Nest$msetEstimatedLaunchTimes(UsageStatsService r0, int r1, List r2) {
        r0.setEstimatedLaunchTimes(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldDeleteObsoleteData, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9134$$Nest$mshouldDeleteObsoleteData(UsageStatsService r0, UserHandle r1) {
        return r0.shouldDeleteObsoleteData(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldHideLocusIdEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9135$$Nest$mshouldHideLocusIdEvents(UsageStatsService r0, int r1, int r2) {
        return r0.shouldHideLocusIdEvents(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldHideShortcutInvocationEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9136$$Nest$mshouldHideShortcutInvocationEvents(UsageStatsService r0, int r1, String r2, int r3, int r4) {
        return r0.shouldHideShortcutInvocationEvents(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldObfuscateInstantAppsForCaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9137$$Nest$mshouldObfuscateInstantAppsForCaller(UsageStatsService r0, int r1, int r2) {
        return r0.shouldObfuscateInstantAppsForCaller(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldObfuscateNotificationEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9138$$Nest$mshouldObfuscateNotificationEvents(UsageStatsService r0, int r1, int r2) {
        return r0.shouldObfuscateNotificationEvents(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterLaunchTimeChangedListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9139$$Nest$munregisterLaunchTimeChangedListener(UsageStatsService r0, UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener r1) {
        r0.unregisterLaunchTimeChangedListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9140$$Nest$munregisterListener(UsageStatsService r0, UsageStatsManagerInternal.UsageEventListener r1) {
        r0.unregisterListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdatePackageMappingsData, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9141$$Nest$mupdatePackageMappingsData(UsageStatsService r0, int r1) {
        return r0.updatePackageMappingsData(r1);
    }

    static {
        ENABLE_TIME_CHANGE_CORRECTION = SystemProperties.getBoolean("persist.debug.time_correction", true);
        USE_DEDICATED_HANDLER_THREAD = SystemProperties.getBoolean("persist.debug.use_dedicated_handler_thread", true);
        DEBUG_RESPONSE_STATS = Log.isLoggable(TAG, 3);
        KERNEL_COUNTER_FILE = new File("/proc/uid_procstat/set");
        KERNEL_COUNTER_KDA_FILE = new File("/proc/kda_procstat/set");
        COMMON_USAGE_STATS_DIR = new File(Environment.getDataSystemDirectory(), "usagestats");
        LEGACY_USER_USAGE_STATS_DIR = COMMON_USAGE_STATS_DIR;
        LEGACY_COMMON_USAGE_STATS_DIR = new File(Environment.getDataSystemDeDirectory(), "usagestats");
    }

    private /* synthetic */ boolean lambda$new$0(Message msg) {
        switch(msg.what) {
            case 3: goto L19;
            case 8: goto L17;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        int userId = msg.arg1;
        UsageEvents.Event event = (UsageEvents.Event) msg.obj;
        ArraySet<UsageStatsManagerInternal.UsageEventListener> r3 = this.mUsageEventListeners;
        monitor-enter(r3);
        int size = this.mUsageEventListeners.size();     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= size) goto L13;
        this.mUsageEventListeners.valueAt(i).onUsageEvent(userId, event);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    L17:
        int userId2 = msg.arg1;
        Trace.traceBegin(524288, "usageStatsHandleEstimatedLaunchTimesOnUser(" + userId2 + ")");
        handleEstimatedLaunchTimesOnUserUnlock(userId2);
        Trace.traceEnd(524288);
        return true;
    L19:
        int userId3 = msg.arg1;
        int procState = msg.arg2;
        if (procState > 2) goto L22;
        int newCounter = 0;
    L23:
        SparseIntArray r5 = this.mUidToKernelCounter;
        monitor-enter(r5);
        int oldCounter = this.mUidToKernelCounter.get(userId3, 0);     // Catch: Throwable -> L30
        if (newCounter == oldCounter) goto L34;
        this.mUidToKernelCounter.put(userId3, newCounter);     // Catch: Throwable -> L30
        FileUtils.stringToFile(KERNEL_COUNTER_FILE, userId3 + " " + newCounter);     // Catch: Throwable -> L30 IOException -> L32
        FileUtils.stringToFile(KERNEL_COUNTER_KDA_FILE, userId3 + " " + newCounter);     // Catch: Throwable -> L30 IOException -> L32
    L32:
        e = move-exception;
        Slog.w(TAG, "Failed to update counter set: " + e);     // Catch: Throwable -> L30
    L34:
        monitor-exit(r5);     // Catch: Throwable -> L30
        return true;
    L30:
        th = move-exception;
        throw th;
    L22:
        newCounter = 1;
        goto L23
    }

    public UsageStatsService(Context context) {
        this(context, new Injector());
    }

    UsageStatsService(Context context, Injector injector) {
        super(context);
        this.mLock = new Object();
        this.mUserState = new SparseArray();
        this.mUserUnlockedStates = new CopyOnWriteArraySet();
        this.mUidToKernelCounter = new SparseIntArray();
        this.mLastTimeComponentUsedGlobal = new ArrayMap();
        this.mPackageMonitor = new MyPackageMonitor(this, null);
        this.mReportedEvents = new SparseArray();
        this.mUsageReporters = new SparseArray();
        this.mVisibleActivities = new SparseArray();
        this.mLaunchTimeAlarmQueues = new SparseArray();
        this.mUsageEventListeners = new ArraySet();
        this.mEstimatedLaunchTimeChangedListeners = new CopyOnWriteArraySet();
        this.mPendingLaunchTimeChangePackages = new SparseSetArray();
        this.mStandbyChangeListener = new AnonymousClass1(this);
        this.mIoHandlerCallback = new UsageStatsService$$ExternalSyntheticLambda0(this);
        this.mUidObserver = new AnonymousClass3(this);
        this.mInjector = injector;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mAppOps = (AppOpsManager) getContext().getSystemService("appops");
        this.mUserManager = (UserManager) getContext().getSystemService("user");
        this.mPackageManager = getContext().getPackageManager();
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mHandler = getUsageEventProcessingHandler();
        this.mIoHandler = new Handler(IoThread.get().getLooper(), this.mIoHandlerCallback);
        this.mAppStandby = this.mInjector.getAppStandbyController(getContext());
        this.mResponseStatsTracker = new BroadcastResponseStatsTracker(this.mAppStandby, getContext());
        this.mAppTimeLimit = new AppTimeLimitController(getContext(), new AnonymousClass2(this), this.mHandler.getLooper());
        this.mAppStandby.addListener(this.mStandbyChangeListener);
        PackageMonitor r0 = this.mPackageMonitor;
        Context r1 = getContext();
        UsageStatsServiceIA r3 = null;
        if (USE_DEDICATED_HANDLER_THREAD == false) goto L5;
        Looper r2 = this.mHandler.getLooper();
    L6:
        r0.register(r1, r2, UserHandle.ALL, true);
        IntentFilter filter = new IntentFilter("android.intent.action.USER_REMOVED");
        filter.addAction("android.intent.action.USER_STARTED");
        Context r4 = getContext();
        UserActionsReceiver r5 = new UserActionsReceiver(this, r3);
        UserHandle r6 = UserHandle.ALL;
        if (USE_DEDICATED_HANDLER_THREAD == false) goto L9;
        Handler r9 = this.mHandler;
    L10:
        r4.registerReceiverAsUser(r5, r6, filter, null, r9);
        Context r8 = getContext();
        UidRemovedReceiver r10 = new UidRemovedReceiver(this, r3);
        UserHandle r11 = UserHandle.ALL;
        IntentFilter r12 = new IntentFilter("android.intent.action.UID_REMOVED");
        if (USE_DEDICATED_HANDLER_THREAD == false) goto L13;
        Handler r13 = this.mHandler;
    L14:
        r8.registerReceiverAsUser(r10, r11, r12, null, r13);
        this.mRealTimeSnapshot = SystemClock.elapsedRealtime();
        this.mSystemTimeSnapshot = System.currentTimeMillis();
        publishLocalService(UsageStatsManagerInternal.class, new LocalService(this, r3));
        publishLocalService(AppStandbyInternal.class, this.mAppStandby);
        publishBinderServices();
        this.mHandler.obtainMessage(7).sendToTarget();
        return;
    L13:
        r13 = null;
        goto L14
    L9:
        r9 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    void publishBinderServices() {
        publishBinderService("usagestats", new BinderService(this, null));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        this.mAppStandby.onBootPhase(phase);
        if (phase != 500) goto L16;
        getDpmInternal();
        getShortcutServiceInternal();
        this.mResponseStatsTracker.onSystemServicesReady(getContext());
        if (KERNEL_COUNTER_FILE.exists() == true) goto L14;
        Slog.w(TAG, "Missing procfs interface: " + KERNEL_COUNTER_FILE);
    L12:
        readUsageSourceSetting();
        return;
    L14:
        ActivityManager.getService().registerUidObserver(this.mUidObserver, 3, -1, null);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        this.mUserState.put(user.getUserIdentifier(), null);
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        this.mHandler.obtainMessage(5, user.getUserIdentifier(), 0).sendToTarget();
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        int userId = user.getUserIdentifier();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L11;
        persistPendingEventsLocked(userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        UsageEvents.Event event = new UsageEvents.Event(29, SystemClock.elapsedRealtime());     // Catch: Throwable -> L9
        event.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;     // Catch: Throwable -> L9
        reportEvent(event, userId);     // Catch: Throwable -> L9
        UserUsageStatsService userService = this.mUserState.get(userId);     // Catch: Throwable -> L9
        if (userService == null) goto L14;
        userService.userStopped();     // Catch: Throwable -> L9
    L14:
        this.mUserUnlockedStates.remove(Integer.valueOf(userId));     // Catch: Throwable -> L9
        this.mUserState.put(userId, null);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        SparseArray<LaunchTimeAlarmQueue> r2 = this.mLaunchTimeAlarmQueues;
        monitor-enter(r2);
        LaunchTimeAlarmQueue alarmQueue = this.mLaunchTimeAlarmQueues.get(userId);     // Catch: Throwable -> L21
        if (alarmQueue == null) goto L23;
        alarmQueue.removeAllAlarms();     // Catch: Throwable -> L21
        this.mLaunchTimeAlarmQueues.remove(userId);     // Catch: Throwable -> L21
    L23:
        monitor-exit(r2);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private Handler getUsageEventProcessingHandler() {
        if (USE_DEDICATED_HANDLER_THREAD == false) goto L7;
        return new H(this, UsageStatsHandlerThread.get().getLooper());
    L7:
        return new H(this, BackgroundThread.get().getLooper());
    }

    private void onUserUnlocked(int userId) {
        HashMap<String, Long> installedPackages = getInstalledPackages(userId);
        UsageStatsIdleService.scheduleUpdateMappingsJob(getContext(), userId);
        boolean deleteObsoleteData = shouldDeleteObsoleteData(UserHandle.of(userId));
        Object r7 = this.mLock;
        monitor-enter(r7);
        this.mUserUnlockedStates.add(Integer.valueOf(userId));     // Catch: Throwable -> L39
        UsageEvents.Event unlockEvent = new UsageEvents.Event(28, SystemClock.elapsedRealtime());     // Catch: Throwable -> L39
        unlockEvent.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;     // Catch: Throwable -> L39
        migrateStatsToSystemCeIfNeededLocked(userId);     // Catch: Throwable -> L39
        LinkedList<UsageEvents.Event> pendingEvents = new LinkedList();     // Catch: Throwable -> L39
        Trace.traceBegin(524288, "loadPendingEvents");     // Catch: Throwable -> L39
        loadPendingEventsLocked(userId, pendingEvents);     // Catch: Throwable -> L39
        Trace.traceEnd(524288);     // Catch: Throwable -> L39
        SparseArray<LinkedList<UsageEvents.Event>> r1 = this.mReportedEvents;     // Catch: Throwable -> L39
        monitor-enter(r1);     // Catch: Throwable -> L39
        LinkedList<UsageEvents.Event> eventsInMem = this.mReportedEvents.get(userId);     // Catch: Throwable -> L41
        if (eventsInMem != null) goto L56;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L41
        if (pendingEvents.isEmpty() == true) goto L16;
        boolean needToFlush = true;
    L17:
        initializeUserUsageStatsServiceLocked(userId, System.currentTimeMillis(), installedPackages, deleteObsoleteData);     // Catch: Throwable -> L37
        UserUsageStatsService userService = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L26
        if (userService != null) goto L29;
        Slog.i(TAG, "Attempted to unlock stopped or removed user " + userId);     // Catch: Throwable -> L26
        monitor-exit(r7);     // Catch: Throwable -> L26
        return;
    L29:
        if (pendingEvents.peek() == null) goto L31;
        reportEvent(pendingEvents.poll(), userId);     // Catch: Throwable -> L26
        goto L29
    L31:
        reportEvent(unlockEvent, userId);     // Catch: Throwable -> L26
        deleteRecursively(new File(Environment.getDataSystemDeDirectory(userId), "usagestats"));     // Catch: Throwable -> L26
        if (needToFlush == false) goto L34;
        userService.persistActiveStats();     // Catch: Throwable -> L26
    L34:
        monitor-exit(r7);     // Catch: Throwable -> L26
        this.mIoHandler.obtainMessage(8, userId, 0).sendToTarget();
        return;
    L37:
        th = th;
    L47:
        monitor-exit(r7);     // Catch: Throwable -> L26
        throw th;
    L16:
        needToFlush = false;
        goto L17
    L56:
        pendingEvents.addAll(eventsInMem);     // Catch: Throwable -> L10
        this.mReportedEvents.remove(userId);     // Catch: Throwable -> L10
    L10:
        th = th;
    L52:
        monitor-exit(r1);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L26
    L45:
        th = th;
    L41:
        th = th;
    L26:
        th = th;
    L39:
        th = th;
        goto L47
    }

    private HashMap<String, Long> getInstalledPackages(int userId) {
        if (this.mPackageManager != null) goto L6;
        return null;
    L6:
        List<PackageInfo> installedPackages = this.mPackageManager.getInstalledPackagesAsUser(8192, userId);
        HashMap<String, Long> packagesMap = new HashMap();
        int i = installedPackages.size() - 1;
    L7:
        if (i < 0) goto L10;
        PackageInfo packageInfo = installedPackages.get(i);
        packagesMap.put(packageInfo.packageName, Long.valueOf(packageInfo.firstInstallTime));
        i = i - 1;
        goto L7
    L10:
        return packagesMap;
    }

    private DevicePolicyManagerInternal getDpmInternal() {
        if (this.mDpmInternal != null) goto L6;
        this.mDpmInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
    L6:
        return this.mDpmInternal;
    }

    private SupervisionManagerInternal getSupervisionManagerInternal() {
        if (this.mSupervisionManagerInternal != null) goto L6;
        this.mSupervisionManagerInternal = (SupervisionManagerInternal) LocalServices.getService(SupervisionManagerInternal.class);
    L6:
        return this.mSupervisionManagerInternal;
    }

    private ShortcutServiceInternal getShortcutServiceInternal() {
        if (this.mShortcutServiceInternal != null) goto L6;
        this.mShortcutServiceInternal = (ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class);
    L6:
        return this.mShortcutServiceInternal;
    }

    private void readUsageSourceSetting() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUsageSource = Settings.Global.getInt(getContext().getContentResolver(), "app_time_limit_usage_source", 1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.usage.UserUsageStatsService.StatsUpdatedListener
    public void onStatsUpdated() {
        this.mHandler.sendEmptyMessageDelayed(1, 1200000);
    }

    @Override // com.android.server.usage.UserUsageStatsService.StatsUpdatedListener
    public void onStatsReloaded() {
        this.mAppStandby.postOneTimeCheckIdleStates();
    }

    @Override // com.android.server.usage.UserUsageStatsService.StatsUpdatedListener
    public void onNewUpdate(int userId) {
        this.mAppStandby.initializeDefaultsForSystemApps(userId);
    }

    private boolean sameApp(int callingUid, int userId, String packageName) {
        if (this.mPackageManagerInternal.getPackageUid(packageName, 0, userId) != callingUid) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isInstantApp(String packageName, int userId) {
        return this.mPackageManagerInternal.isPackageEphemeral(userId, packageName);
    }

    private boolean shouldObfuscateInstantAppsForCaller(int callingUid, int userId) {
        return !this.mPackageManagerInternal.canAccessInstantApps(callingUid, userId);
    }

    private boolean shouldHideShortcutInvocationEvents(int userId, String callingPackage, int callingPid, int callingUid) {
        ShortcutServiceInternal shortcutServiceInternal = getShortcutServiceInternal();
        if (shortcutServiceInternal != null) goto L5;
        return true;
    L5:
        return true ^ shortcutServiceInternal.hasShortcutHostPermission(userId, callingPackage, callingPid, callingUid);
    }

    private boolean shouldHideLocusIdEvents(int callingPid, int callingUid) {
        if (callingUid != 1000) goto L6;
        return false;
    L6:
        if (getContext().checkPermission("android.permission.ACCESS_LOCUS_ID_USAGE_STATS", callingPid, callingUid) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean shouldObfuscateNotificationEvents(int callingPid, int callingUid) {
        if (callingUid != 1000) goto L6;
        return false;
    L6:
        if (getContext().checkPermission("android.permission.MANAGE_NOTIFICATIONS", callingPid, callingUid) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isSupervisionEnabled(int callingUid) {
        DevicePolicyManagerInternal dpmInternal = getDpmInternal();
        if (dpmInternal != null) goto L5;
    L7:
        return false;
    L5:
        if (dpmInternal.isActiveSupervisionApp(callingUid) == false) goto L7;
        return true;
    }

    private static void deleteRecursively(File path) {
        if (path.isDirectory() == false) goto L11;
        File[] files = path.listFiles();
        if (files == null) goto L11;
        int r1 = files.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L11;
        File subFile = files[r2];
        deleteRecursively(subFile);
        r2 = r2 + 1;
    L11:
        if (path.exists() == true) goto L13;
        return;
    L13:
        if (path.delete() == true) goto L18;
        Slog.e(TAG, "Failed to delete " + path);
        return;
    }

    private UserUsageStatsService getUserUsageStatsServiceLocked(int userId) {
        UserUsageStatsService service = this.mUserState.get(userId);
        if (service != null) goto L5;
        Slog.wtf(TAG, "Failed to fetch usage stats service for user " + userId + ". The user might not have been initialized yet.");
    L5:
        return service;
    }

    private void initializeUserUsageStatsServiceLocked(int userId, long currentTimeMillis, HashMap<String, Long> installedPackages, boolean deleteObsoleteData) {
        File usageStatsDir = new File(Environment.getDataSystemCeDirectory(userId), "usagestats");
        UserUsageStatsService service = new UserUsageStatsService(getContext(), userId, usageStatsDir, this);
        service.init(currentTimeMillis, installedPackages, deleteObsoleteData);     // Catch: Exception -> L5
        this.mUserState.put(userId, service);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (this.mUserManager.isUserUnlocked(userId) == true) goto L10;
        Slog.w(TAG, "Attempted to initialize service for stopped or removed user " + userId);
        return;
    L10:
        Slog.w(TAG, "Failed to initialized unlocked user " + userId);
        throw e;
    }

    private void migrateStatsToSystemCeIfNeededLocked(int userId) {
        File usageStatsDir = new File(Environment.getDataSystemCeDirectory(userId), "usagestats");
        if (usageStatsDir.mkdirs() == false) goto L5;
    L9:
        File migrated = new File(usageStatsDir, "migrated");
        if (migrated.exists() == true) goto L57;
    L39:
        Slog.i(TAG, "Starting migration to system CE for user " + userId);
        File legacyUserDir = new File(LEGACY_USER_USAGE_STATS_DIR, Integer.toString(userId));
        if (legacyUserDir.exists() == false) goto L64;
        copyRecursively(usageStatsDir, legacyUserDir);
    L64:
        BufferedWriter writer = new BufferedWriter(new FileWriter(migrated));     // Catch: IOException -> L47
        writer.write(Integer.toString(4));     // Catch: Throwable -> L49
        writer.write("\n");     // Catch: Throwable -> L49
        writer.flush();     // Catch: Throwable -> L49
        writer.close();     // Catch: IOException -> L47
        Slog.i(TAG, "Finished migration to system CE for user " + userId);
        deleteLegacyUserDir(userId);
        return;
    L49:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L52
    L54:
        throw th;     // Catch: IOException -> L47
    L52:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L47
    L47:
        e = move-exception;
        Slog.e(TAG, "Failed to write migrated status file");
        throw new RuntimeException(e);
    L57:
        BufferedReader reader = new BufferedReader(new FileReader(migrated));     // Catch: Throwable -> L17
        int previousVersion = Integer.parseInt(reader.readLine());     // Catch: Throwable -> L19
        if (previousVersion < 4) goto L21;
        deleteLegacyUserDir(userId);     // Catch: Throwable -> L19
        reader.close();     // Catch: Throwable -> L17 Throwable -> L17
        return;
    L21:
        reader.close();     // Catch: Throwable -> L17 Throwable -> L17
    L19:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Throwable -> L17 Throwable -> L17
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17 Throwable -> L17
    L17:
        e = move-exception;
        Slog.e(TAG, "Failed to read migration status file, possibly corrupted.");
        deleteRecursively(usageStatsDir);
        if (usageStatsDir.exists() == false) goto L31;
        Slog.e(TAG, "Unable to delete usage stats CE directory.");
        throw new RuntimeException(e);
    L31:
        if (usageStatsDir.mkdirs() == true) goto L39;
        if (usageStatsDir.exists() == true) goto L39;
        throw new IllegalStateException("Usage stats directory does not exist: " + usageStatsDir.getAbsolutePath());
    L5:
        if (usageStatsDir.exists() == true) goto L9;
        throw new IllegalStateException("Usage stats directory does not exist: " + usageStatsDir.getAbsolutePath());
    }

    private static void copyRecursively(File parent, File f) {
        File[] files = f.listFiles();
        if (files == null) goto L23;
        int i = files.length - 1;
    L10:
        if (i < 0) goto L22;
        File newParent = parent;
        if (files[i].isDirectory() == false) goto L20;
        newParent = new File(parent, files[i].getName());
        boolean mkdirSuccess = newParent.mkdirs();
        if (mkdirSuccess == true) goto L20;
        if (newParent.exists() == true) goto L20;
        throw new IllegalStateException("Failed to create usage stats directory during migration: " + newParent.getAbsolutePath());
    L20:
        copyRecursively(newParent, files[i]);
        i = i - 1;
        goto L10
    L22:
        return;
    L23:
        Files.copy(f.toPath(), new File(parent, f.getName()).toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to move usage stats file : " + f.toString());
        throw new RuntimeException(e);
    }

    private void deleteLegacyUserDir(int userId) {
        File legacyUserDir = new File(LEGACY_USER_USAGE_STATS_DIR, Integer.toString(userId));
        if (legacyUserDir.exists() == false) goto L8;
        deleteRecursively(legacyUserDir);
        if (legacyUserDir.exists() == false) goto L9;
        Slog.w(TAG, "Error occurred while attempting to delete legacy usage stats dir for user " + userId);
        return;
    L9:
        return;
    }

    void shutdown() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L8
        UsageEvents.Event event = new UsageEvents.Event(26, SystemClock.elapsedRealtime());     // Catch: Throwable -> L8
        event.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;     // Catch: Throwable -> L8
        reportEventToAllUserId(event);     // Catch: Throwable -> L8
        flushToDiskLocked();     // Catch: Throwable -> L8
        persistGlobalComponentUsageLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mAppStandby.flushToDisk();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void prepareForPossibleShutdown() {
        UsageEvents.Event event = new UsageEvents.Event(26, SystemClock.elapsedRealtime());
        event.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;
        this.mHandler.obtainMessage(4, event).sendToTarget();
        this.mHandler.sendEmptyMessage(1);
    }

    private void loadPendingEventsLocked(int userId, LinkedList<UsageEvents.Event> pendingEvents) {
        File usageStatsDeDir = new File(Environment.getDataSystemDeDirectory(userId), "usagestats");
        File[] pendingEventsFiles = usageStatsDeDir.listFiles();
        if (pendingEventsFiles != null) goto L5;
        return;
    L5:
        if (pendingEventsFiles.length == 0) goto L41;
        Arrays.sort(pendingEventsFiles);
        int numFiles = pendingEventsFiles.length;
        int i = 0;
    L8:
        if (i >= numFiles) goto L29;
        AtomicFile af = new AtomicFile(pendingEventsFiles[i]);
        LinkedList<UsageEvents.Event> tmpEvents = new LinkedList();
        FileInputStream in = af.openRead();     // Catch: Exception -> L14
        UsageStatsProtoV2.readPendingEvents(in, tmpEvents);     // Catch: Throwable -> L18
        if (in == null) goto L16;
        in.close();     // Catch: Exception -> L14
    L16:
        pendingEvents.addAll(tmpEvents);     // Catch: Exception -> L14
    L27:
        i = i + 1;
        goto L8
    L18:
        th = move-exception;
        if (in != null) goto L31;
    L25:
        throw th;     // Catch: Exception -> L14
    L31:
        in.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L14
    L26:
        Slog.e(TAG, "Could not read " + pendingEventsFiles[i] + " for user " + userId);
        goto L27
    L29:
        return;
    }

    private void persistPendingEventsLocked(int userId) {
        LinkedList<UsageEvents.Event> pendingEvents = this.mReportedEvents.get(userId);
        if (pendingEvents != null) goto L5;
        return;
    L5:
        if (pendingEvents.isEmpty() == true) goto L32;
        File deDir = Environment.getDataSystemDeDirectory(userId);
        File usageStatsDeDir = new File(deDir, "usagestats");
        if (usageStatsDeDir.mkdir() == false) goto L10;
    L16:
        File pendingEventsFile = new File(usageStatsDeDir, "pendingevents_" + System.currentTimeMillis());
        AtomicFile af = new AtomicFile(pendingEventsFile);
        FileOutputStream fos = null;
        FileOutputStream fos2 = af.startWrite();     // Catch: Throwable -> L19 Exception -> L21
        UsageStatsProtoV2.writePendingEvents(fos2, pendingEvents);     // Catch: Throwable -> L19 Exception -> L21
        af.finishWrite(fos2);     // Catch: Throwable -> L19 Exception -> L21
        fos = null;
        pendingEvents.clear();     // Catch: Throwable -> L19 Exception -> L21
    L18:
        af.failWrite(fos);
        return;
    L19:
        th = move-exception;
        af.failWrite(fos);
        throw th;
    L22:
        Slog.e(TAG, "Failed to write " + pendingEventsFile.getAbsolutePath() + " for user " + userId);     // Catch: Throwable -> L19
        goto L18
    L10:
        if (usageStatsDeDir.exists() == true) goto L16;
        if (deDir.exists() == false) goto L14;
        Slog.e(TAG, "Failed to create " + usageStatsDeDir);
        return;
    L14:
        Slog.w(TAG, "User " + userId + " was already removed! Discarding pending events");
        pendingEvents.clear();
        return;
    }

    private void loadGlobalComponentUsageLocked() {
        AtomicFile af = new AtomicFile(new File(COMMON_USAGE_STATS_DIR, GLOBAL_COMPONENT_USAGE_FILE_NAME));
        if (af.exists() == true) goto L8;
        af = new AtomicFile(new File(LEGACY_COMMON_USAGE_STATS_DIR, GLOBAL_COMPONENT_USAGE_FILE_NAME));
        if (af.exists() == true) goto L7;
        return;
    L7:
        Slog.i(TAG, "Reading globalcomponentusage file from old location");
    L8:
        Map<String, Long> tmpUsage = new ArrayMap();
        FileInputStream in = af.openRead();     // Catch: Exception -> L13
        UsageStatsProtoV2.readGlobalComponentUsage(in, tmpUsage);     // Catch: Throwable -> L20
        if (in == null) goto L15;
        in.close();     // Catch: Exception -> L13
    L15:
        Map.Entry<String, Long>[] entries = (Map.Entry[]) tmpUsage.entrySet().toArray();     // Catch: Exception -> L13
        int size = entries.length;     // Catch: Exception -> L13
        int i = 0;
    L16:
        if (i >= size) goto L36;
        this.mLastTimeComponentUsedGlobal.putIfAbsent(entries[i].getKey(), entries[i].getValue());     // Catch: Exception -> L13
        i = i + 1;
        goto L16
    L36:
        return;
    L20:
        th = move-exception;
        if (in != null) goto L30;
    L27:
        throw th;     // Catch: Exception -> L13
    L30:
        in.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L13
    L28:
        Slog.e(TAG, "Could not read " + af.getBaseFile());
    }

    private void persistGlobalComponentUsageLocked() {
        if (this.mLastTimeComponentUsedGlobal.isEmpty() == false) goto L6;
        return;
    L6:
        if (COMMON_USAGE_STATS_DIR.mkdirs() == false) goto L8;
    L12:
        File lastTimePackageFile = new File(COMMON_USAGE_STATS_DIR, GLOBAL_COMPONENT_USAGE_FILE_NAME);
        AtomicFile af = new AtomicFile(lastTimePackageFile);
        FileOutputStream fos = null;
        fos = af.startWrite();     // Catch: Throwable -> L16 Exception -> L18
        UsageStatsProtoV2.writeGlobalComponentUsage(fos, this.mLastTimeComponentUsedGlobal);     // Catch: Throwable -> L16 Exception -> L18
        af.finishWrite(fos);     // Catch: Throwable -> L16 Exception -> L18
        fos = null;
    L15:
        af.failWrite(fos);
        return;
    L16:
        th = move-exception;
        af.failWrite(fos);
        throw th;
    L19:
        Slog.e(TAG, "Failed to write " + lastTimePackageFile.getAbsolutePath());     // Catch: Throwable -> L16
        goto L15
    L8:
        if (COMMON_USAGE_STATS_DIR.exists() == true) goto L12;
        throw new IllegalStateException("Common usage stats directory does not exist: " + COMMON_USAGE_STATS_DIR.getAbsolutePath());
    }

    private void reportEventOrAddToQueue(int userId, UsageEvents.Event event) {
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == false) goto L7;
        this.mHandler.obtainMessage(0, userId, 0, event).sendToTarget();
        return;
    L7:
        if (Trace.isTagEnabled(524288) == false) goto L9;
        String traceTag = "usageStatsQueueEvent(" + userId + ") #" + UserUsageStatsService.eventToString(event.mEventType);
        Trace.traceBegin(524288, traceTag);
    L9:
        SparseArray<LinkedList<UsageEvents.Event>> r2 = this.mReportedEvents;
        monitor-enter(r2);
        LinkedList<UsageEvents.Event> events = this.mReportedEvents.get(userId);     // Catch: Throwable -> L19
        if (events != null) goto L24;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);     // Catch: Throwable -> L19
        if (umi == null) goto L21;
        if (umi.exists(userId) == false) goto L21;
        events = new LinkedList();     // Catch: Throwable -> L19
        this.mReportedEvents.put(userId, events);     // Catch: Throwable -> L19
    L21:
        Slog.wtf(TAG, "Attempted to report event for non-existent user " + userId + " (" + event.mPackage + SliceClientPermissions.SliceAuthority.DELIMITER + event.mClass + " eventType:" + event.mEventType + ")");     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return;
    L24:
        events.add(event);     // Catch: Throwable -> L19
        if (events.size() != 1) goto L27;
        this.mHandler.sendEmptyMessageDelayed(1, 1200000);     // Catch: Throwable -> L19
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L19
        Trace.traceEnd(524288);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private void convertToSystemTimeLocked(UsageEvents.Event event) {
        long actualSystemTime = System.currentTimeMillis();
        if (ENABLE_TIME_CHANGE_CORRECTION == false) goto L10;
        long actualRealtime = SystemClock.elapsedRealtime();
        long expectedSystemTime = (actualRealtime - this.mRealTimeSnapshot) + this.mSystemTimeSnapshot;
        long diffSystemTime = actualSystemTime - expectedSystemTime;
        if (Math.abs(diffSystemTime) <= 2000) goto L10;
        UserUsageStatsService service = this.mUserState.get(0);
        if (service == null) goto L9;
        service.systemTimeChangeMoment(actualSystemTime);
    L9:
        Slog.i(TAG, "Time changed in by " + (diffSystemTime / 1000) + " seconds");
        this.mRealTimeSnapshot = actualRealtime;
        this.mSystemTimeSnapshot = actualSystemTime;
    L10:
        event.mTimeStamp = Math.max(0, event.mTimeStamp - this.mRealTimeSnapshot) + this.mSystemTimeSnapshot;
    }

    void reportEvent(UsageEvents.Event event, int userId) {
        switch(event.mEventType) {
            case 1: goto L5;
            case 2: goto L5;
            case 23: goto L5;
            default: goto L4;
        };
    L4:
        int uid = 0;
    L7:
        if (event.mPackage != null) goto L9;
    L11:
        Object r8 = this.mLock;
        monitor-enter(r8);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L20;
        Slog.wtf(TAG, "Failed to report event for locked user " + userId + " (" + event.mPackage + SliceClientPermissions.SliceAuthority.DELIMITER + event.mClass + " eventType:" + event.mEventType + " instanceId:" + event.mInstanceId + ")");     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L18
        return;
    L20:
        UsageStatsServiceIA r9 = null;
        switch(event.mEventType) {
            case 1: goto L81;
            case 2: goto L68;
            case 7: goto L66;
            case 8: goto L65;
            case 9: goto L65;
            case 19: goto L65;
            case 20: goto L65;
            case 23: goto L24;
            case 24: goto L23;
            case 31: goto L67;
            default: goto L97;
        };     // Catch: Throwable -> L18
    L23:
        event.mEventType = 23;     // Catch: Throwable -> L18
    L24:
        ActivityData prevData = (ActivityData) this.mVisibleActivities.removeReturnOld(event.mInstanceId);     // Catch: Throwable -> L18
        if (prevData != null) goto L30;
        Slog.w(TAG, "Unexpected activity event reported! (" + event.mPackage + SliceClientPermissions.SliceAuthority.DELIMITER + event.mClass + " event : " + event.mEventType + " instanceId : " + event.mInstanceId + ")");     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L18
        return;
    L30:
        if (prevData.lastEvent == 2) goto L32;
        logAppUsageEventReportedAtomLocked(2, uid, event.mPackage);     // Catch: Throwable -> L18
    L32:
        SparseArray<ArraySet<String>> r5 = this.mUsageReporters;     // Catch: Throwable -> L18
        monitor-enter(r5);     // Catch: Throwable -> L18
        ArraySet<String> tokens = (ArraySet) this.mUsageReporters.removeReturnOld(event.mInstanceId);     // Catch: Throwable -> L62
        monitor-exit(r5);     // Catch: Throwable -> L62
        if (tokens == null) goto L55;
        monitor-enter(tokens);     // Catch: Throwable -> L18
        int size = tokens.size();     // Catch: Throwable -> L44
        int i = 0;
    L39:
        if (i >= size) goto L50;
        String token = tokens.valueAt(i);     // Catch: Throwable -> L44
        this.mAppTimeLimit.noteUsageStop(buildFullToken(event.mPackage, token), userId);     // Catch: Throwable -> L44 IllegalArgumentException -> L46
    L48:
        i = i + 1;     // Catch: Throwable -> L44
    L46:
        iae = move-exception;
        Slog.w(TAG, "Failed to stop usage for during reporter death: " + iae);     // Catch: Throwable -> L44
        goto L48
    L50:
        monitor-exit(tokens);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L55:
        if (event.mTaskRootPackage != null) goto L117;
        event.mTaskRootPackage = ActivityData.m9143$$Nest$fgetmTaskRootPackage(prevData);     // Catch: Throwable -> L18
        event.mTaskRootClass = ActivityData.m9142$$Nest$fgetmTaskRootClass(prevData);     // Catch: Throwable -> L18
    L117:
        this.mAppTimeLimit.noteUsageStop(ActivityData.m9144$$Nest$fgetmUsageSourcePackage(prevData), userId);     // Catch: Throwable -> L18 IllegalArgumentException -> L59
    L59:
        iae = move-exception;
        Slog.w(TAG, "Failed to note usage stop", iae);     // Catch: Throwable -> L18
        goto L97
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L65:
        logAppUsageEventReportedAtomLocked(event.mEventType, uid, event.mPackage);     // Catch: Throwable -> L18
        goto L97
    L66:
        logAppUsageEventReportedAtomLocked(7, uid, event.mPackage);     // Catch: Throwable -> L18
    L67:
        convertToSystemTimeLocked(event);     // Catch: Throwable -> L18
        this.mLastTimeComponentUsedGlobal.put(event.mPackage, Long.valueOf(event.mTimeStamp));     // Catch: Throwable -> L18
        goto L97
    L68:
        ActivityData pausedData = this.mVisibleActivities.get(event.mInstanceId);     // Catch: Throwable -> L18
        if (pausedData != null) goto L77;
        String usageSourcePackage2 = getUsageSourcePackage(event);     // Catch: Throwable -> L18
        this.mAppTimeLimit.noteUsageStart(usageSourcePackage2, userId);     // Catch: Throwable -> L18 IllegalArgumentException -> L74
    L76:
        pausedData = new ActivityData(event.mTaskRootPackage, event.mTaskRootClass, usageSourcePackage2, r9);     // Catch: Throwable -> L18
        this.mVisibleActivities.put(event.mInstanceId, pausedData);     // Catch: Throwable -> L18
    L78:
        pausedData.lastEvent = 2;     // Catch: Throwable -> L18
        if (event.mTaskRootPackage != null) goto L97;
        event.mTaskRootPackage = ActivityData.m9143$$Nest$fgetmTaskRootPackage(pausedData);     // Catch: Throwable -> L18
        event.mTaskRootClass = ActivityData.m9142$$Nest$fgetmTaskRootClass(pausedData);     // Catch: Throwable -> L18
        goto L97
    L74:
        iae = move-exception;
        Slog.e(TAG, "Failed to note usage start", iae);     // Catch: Throwable -> L18
        goto L76
    L77:
        logAppUsageEventReportedAtomLocked(2, uid, event.mPackage);     // Catch: Throwable -> L18
        goto L78
    L81:
        logAppUsageEventReportedAtomLocked(1, uid, event.mPackage);     // Catch: Throwable -> L18
        if (this.mVisibleActivities.get(event.mInstanceId) != null) goto L97;
        String usageSourcePackage = getUsageSourcePackage(event);     // Catch: Throwable -> L18
        this.mAppTimeLimit.noteUsageStart(usageSourcePackage, userId);     // Catch: Throwable -> L18 IllegalArgumentException -> L88
    L90:
        ActivityData resumedData = new ActivityData(event.mTaskRootPackage, event.mTaskRootClass, usageSourcePackage, r9);     // Catch: Throwable -> L18
        resumedData.lastEvent = 1;     // Catch: Throwable -> L18
        this.mVisibleActivities.put(event.mInstanceId, resumedData);     // Catch: Throwable -> L18
        long estimatedLaunchTime = this.mAppStandby.getEstimatedLaunchTime(event.mPackage, userId);     // Catch: Throwable -> L18
        long now = System.currentTimeMillis();     // Catch: Throwable -> L18
        if (estimatedLaunchTime >= now) goto L93;
    L94:
        this.mAppStandby.setEstimatedLaunchTime(event.mPackage, userId, 0);     // Catch: Throwable -> L18
        if (stageChangedEstimatedLaunchTime(userId, event.mPackage) == false) goto L97;
        this.mHandler.sendEmptyMessage(9);     // Catch: Throwable -> L18
        goto L97
    L93:
        if (estimatedLaunchTime <= (604800000 + now)) goto L97;
    L88:
        iae = move-exception;
        Slog.e(TAG, "Failed to note usage start", iae);     // Catch: Throwable -> L18
    L97:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L18
        if (service != null) goto L101;
        monitor-exit(r8);     // Catch: Throwable -> L18
        return;
    L101:
        service.reportEvent(event);     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L18
        this.mIoHandler.obtainMessage(12, userId, 0, event).sendToTarget();
        return;
    L9:
        if (isInstantApp(event.mPackage, userId) == false) goto L11;
        event.mFlags |= 1;
        goto L11
    L5:
        int uid2 = this.mPackageManagerInternal.getPackageUid(event.mPackage, 0, userId);
        uid = uid2;
        goto L7
    }

    private void logAppUsageEventReportedAtomLocked(int eventType, int uid, String packageName) {
        FrameworkStatsLog.write(269, uid, packageName, "", getAppUsageEventOccurredAtomEventType(eventType));
    }

    private int getAppUsageEventOccurredAtomEventType(int eventType) {
        switch(eventType) {
            case 1: goto L19;
            case 2: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 11: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        Slog.w(TAG, "Unsupported usage event logging: " + eventType);
        return -1;
    L5:
        return 20;
    L7:
        return 19;
    L9:
        return 11;
    L11:
        return 9;
    L13:
        return 8;
    L15:
        return 7;
    L17:
        return 2;
    L19:
        return 1;
    }

    private String getUsageSourcePackage(UsageEvents.Event event) {
        switch(this.mUsageSource) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return event.mTaskRootPackage;
    L7:
        return event.mPackage;
    }

    void reportEventToAllUserId(UsageEvents.Event event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userCount = this.mUserState.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= userCount) goto L10;
        UsageEvents.Event copy = new UsageEvents.Event(event);     // Catch: Throwable -> L7
        reportEventOrAddToQueue(this.mUserState.keyAt(i), copy);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void flushToDisk() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UsageEvents.Event event = new UsageEvents.Event(25, SystemClock.elapsedRealtime());     // Catch: Throwable -> L8
        event.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;     // Catch: Throwable -> L8
        reportEventToAllUserId(event);     // Catch: Throwable -> L8
        flushToDiskLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mAppStandby.flushToDisk();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Slog.i(TAG, "Removing user " + userId + " and all data.");     // Catch: Throwable -> L25
        this.mUserState.remove(userId);     // Catch: Throwable -> L25
        this.mAppTimeLimit.onUserRemoved(userId);     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        SparseArray<LaunchTimeAlarmQueue> r1 = this.mLaunchTimeAlarmQueues;
        monitor-enter(r1);
        LaunchTimeAlarmQueue alarmQueue = this.mLaunchTimeAlarmQueues.get(userId);     // Catch: Throwable -> L11
        if (alarmQueue == null) goto L13;
        alarmQueue.removeAllAlarms();     // Catch: Throwable -> L11
        this.mLaunchTimeAlarmQueues.remove(userId);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        SparseSetArray<String> r2 = this.mPendingLaunchTimeChangePackages;
        monitor-enter(r2);
        this.mPendingLaunchTimeChangePackages.remove(userId);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        this.mAppStandby.onUserRemoved(userId);
        this.mResponseStatsTracker.onUserRemoved(userId);
        UsageStatsIdleService.cancelPruneJob(getContext(), userId);
        UsageStatsIdleService.cancelUpdateMappingsJob(getContext(), userId);
        return;
    L20:
        th = move-exception;
        throw th;
    L11:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;
    }

    private void onPackageRemoved(int userId, String packageName) {
        SparseSetArray<String> r0 = this.mPendingLaunchTimeChangePackages;
        monitor-enter(r0);
        ArraySet<String> pkgNames = this.mPendingLaunchTimeChangePackages.get(userId);     // Catch: Throwable -> L7
        if (pkgNames == null) goto L9;
        pkgNames.remove(packageName);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        SparseArray<LaunchTimeAlarmQueue> r1 = this.mLaunchTimeAlarmQueues;
        monitor-enter(r1);
        LaunchTimeAlarmQueue alarmQueue = this.mLaunchTimeAlarmQueues.get(userId);     // Catch: Throwable -> L15
        if (alarmQueue == null) goto L17;
        alarmQueue.removeAlarmForKey(packageName);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        Object r2 = this.mLock;
        monitor-enter(r2);
        long timeRemoved = System.currentTimeMillis();     // Catch: Throwable -> L24
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L26;
        monitor-exit(r2);     // Catch: Throwable -> L24
        return;
    L26:
        UserUsageStatsService userService = this.mUserState.get(userId);     // Catch: Throwable -> L24
        if (userService != null) goto L30;
        monitor-exit(r2);     // Catch: Throwable -> L24
        return;
    L30:
        int tokenRemoved = userService.onPackageRemoved(packageName, timeRemoved);     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L24
        if (tokenRemoved == (-1)) goto L47;
        UsageStatsIdleService.schedulePruneJob(getContext(), userId);
        return;
    L47:
        return;
    L24:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean pruneUninstalledPackagesData(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        UserUsageStatsService userService = this.mUserState.get(userId);     // Catch: Throwable -> L8
        if (userService != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L14:
        boolean r2 = userService.pruneUninstalledPackagesData();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    }

    private boolean updatePackageMappingsData(int userId) {
        if (shouldDeleteObsoleteData(UserHandle.of(userId)) == true) goto L6;
        return true;
    L6:
        HashMap<String, Long> installedPkgs = getInstalledPackages(userId);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return false;
    L14:
        UserUsageStatsService userService = this.mUserState.get(userId);     // Catch: Throwable -> L12
        if (userService != null) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return false;
    L18:
        boolean r3 = userService.updatePackageMappingsLocked(installedPkgs);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r3;
    }

    List<UsageStats> queryUsageStats(int userId, int bucketType, long beginTime, long endTime, boolean obfuscateInstantApps) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L11;
        Slog.w(TAG, "Failed to query usage stats for locked user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L11:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L9
        if (service != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L15:
        List<UsageStats> list = service.queryUsageStats(bucketType, beginTime, endTime);     // Catch: Throwable -> L9
        if (list != null) goto L19;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L19:
        if (obfuscateInstantApps == false) goto L26;
        int i = list.size() - 1;     // Catch: Throwable -> L9
    L21:
        if (i < 0) goto L26;
        UsageStats stats = list.get(i);     // Catch: Throwable -> L9
        if (isInstantApp(stats.mPackageName, userId) == false) goto L25;
        list.set(i, stats.getObfuscatedForInstantApp());     // Catch: Throwable -> L9
    L25:
        i = i - 1;     // Catch: Throwable -> L9
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return list;
    }

    List<ConfigurationStats> queryConfigurationStats(int userId, int bucketType, long beginTime, long endTime) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L23:
        th = th;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L21
        throw th;
    L29:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L12;
        Slog.w(TAG, "Failed to query configuration stats for locked user " + userId);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L12:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L23
        if (service != null) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L18:
        List<ConfigurationStats> r11 = service.queryConfigurationStats(bucketType, beginTime, endTime);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r11;
    L10:
        th = th;
    L21:
        th = th;
        goto L25
    }

    List<EventStats> queryEventStats(int userId, int bucketType, long beginTime, long endTime) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L23:
        th = th;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L21
        throw th;
    L29:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L12;
        Slog.w(TAG, "Failed to query event stats for locked user " + userId);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L12:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L23
        if (service != null) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L18:
        List<EventStats> r11 = service.queryEventStats(bucketType, beginTime, endTime);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r11;
    L10:
        th = th;
    L21:
        th = th;
        goto L25
    }

    UsageEvents queryEvents(int userId, long beginTime, long endTime, int flags) {
        return queryEventsWithQueryFilters(userId, beginTime, endTime, flags, EmptyArray.INT, null);
    }

    UsageEvents queryEventsWithQueryFilters(int userId, long beginTime, long endTime, int flags, int[] eventTypeFilter, ArraySet<String> pkgNameFilter) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L11;
        Slog.w(TAG, "Failed to query events for locked user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L11:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L9
        if (service != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L15:
        UsageEvents r0 = service.queryEvents(beginTime, endTime, flags, eventTypeFilter, pkgNameFilter);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    }

    UsageEvents queryEventsForPackage(int userId, long beginTime, long endTime, String packageName, boolean includeTaskRoot) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L11;
        Slog.w(TAG, "Failed to query package events for locked user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L11:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L9
        if (service != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L15:
        UsageEvents r0 = service.queryEventsForPackage(beginTime, endTime, packageName, includeTaskRoot);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    }

    private UsageEvents queryEarliestAppEvents(int userId, long beginTime, long endTime, int eventType) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L23:
        th = th;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L21
        throw th;
    L29:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L12;
        Slog.w(TAG, "Failed to query earliest events for locked user " + userId);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L12:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L23
        if (service != null) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L18:
        UsageEvents r11 = service.queryEarliestAppEvents(beginTime, endTime, eventType);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r11;
    L10:
        th = th;
    L21:
        th = th;
        goto L25
    }

    private UsageEvents queryEarliestEventsForPackage(int userId, long beginTime, long endTime, String packageName, int eventType) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L11;
        Slog.w(TAG, "Failed to query earliest package events for locked user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L11:
        UserUsageStatsService service = getUserUsageStatsServiceLocked(userId);     // Catch: Throwable -> L9
        if (service != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L15:
        UsageEvents r0 = service.queryEarliestEventsForPackage(beginTime, endTime, packageName, eventType);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    }

    long getEstimatedPackageLaunchTime(int userId, String packageName) {
        long estimatedLaunchTime = this.mAppStandby.getEstimatedLaunchTime(packageName, userId);
        long now = System.currentTimeMillis();
        if (estimatedLaunchTime >= now) goto L5;
    L6:
        long estimatedLaunchTime2 = calculateEstimatedPackageLaunchTime(userId, packageName);
        this.mAppStandby.setEstimatedLaunchTime(packageName, userId, estimatedLaunchTime2);
        getOrCreateLaunchTimeAlarmQueue(userId).addAlarm(packageName, SystemClock.elapsedRealtime() + (estimatedLaunchTime2 - now));
        return estimatedLaunchTime2;
    L5:
        if (estimatedLaunchTime == Long.MAX_VALUE) goto L6;
        return estimatedLaunchTime;
    }

    private LaunchTimeAlarmQueue getOrCreateLaunchTimeAlarmQueue(int userId) {
        SparseArray<LaunchTimeAlarmQueue> r0 = this.mLaunchTimeAlarmQueues;
        monitor-enter(r0);
        LaunchTimeAlarmQueue alarmQueue = this.mLaunchTimeAlarmQueues.get(userId);     // Catch: Throwable -> L7
        if (alarmQueue != null) goto L9;
        alarmQueue = new LaunchTimeAlarmQueue(this, userId, getContext(), this.mHandler.getLooper());     // Catch: Throwable -> L7
        this.mLaunchTimeAlarmQueues.put(userId, alarmQueue);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return alarmQueue;
    L7:
        th = move-exception;
        throw th;
    }

    private long calculateEstimatedPackageLaunchTime(int userId, String packageName) {
        long endTime = System.currentTimeMillis();
        long beginTime = endTime - 604800000;
        long unknownTime = endTime + 31536000000L;
        UsageEvents events = queryEarliestEventsForPackage(userId, beginTime, endTime, packageName, 1);
        if (events != null) goto L5;
        return unknownTime;
    L5:
        UsageEvents.Event event = new UsageEvents.Event();
        if (events.getNextEvent(event) == true) goto L8;
        return unknownTime;
    L8:
        if ((endTime - event.getTimeStamp()) <= 86400000) goto L10;
        boolean hasMoreThan24HoursOfHistory = true;
    L12:
        if (event.getEventType() != 1) goto L17;
        long timestamp = event.getTimeStamp();
        long nextLaunch = calculateNextLaunchTime(hasMoreThan24HoursOfHistory, timestamp);
        if (nextLaunch <= endTime) goto L17;
        return nextLaunch;
    L17:
        if (events.getNextEvent(event) == true) goto L12;
        return unknownTime;
    L10:
        hasMoreThan24HoursOfHistory = false;
        goto L12
    }

    private static long calculateNextLaunchTime(boolean hasMoreThan24HoursOfHistory, long eventTimestamp) {
        if (hasMoreThan24HoursOfHistory == false) goto L6;
        return 604800000 + eventTimestamp;
    L6:
        return 86400000 + eventTimestamp;
    }

    private void handleEstimatedLaunchTimesOnUserUnlock(int userId) {
        long nowElapsed = SystemClock.elapsedRealtime();
        long now = System.currentTimeMillis();
        long r9 = 604800000;
        long beginTime = now - 604800000;
        int r1 = userId;
        UsageEvents events = queryEarliestAppEvents(r1, beginTime, now, 1);
        if (events != null) goto L5;
        return;
    L5:
        ArrayMap<String, Boolean> hasMoreThan24HoursOfHistory = new ArrayMap();
        UsageEvents.Event event = new UsageEvents.Event();
        boolean changedTimes = false;
        LaunchTimeAlarmQueue alarmQueue = getOrCreateLaunchTimeAlarmQueue(userId);
        boolean unprocessedEvent = events.getNextEvent(event);
    L6:
        if (unprocessedEvent == false) goto L28;
        long r16 = r9;
        String packageName = event.getPackageName();
        long beginTime2 = beginTime;
        if (hasMoreThan24HoursOfHistory.containsKey(packageName) == true) goto L15;
        if ((now - event.getTimeStamp()) <= 86400000) goto L12;
        boolean hasHistory = true;
    L13:
        hasMoreThan24HoursOfHistory.put(packageName, Boolean.valueOf(hasHistory));
        goto L15
    L12:
        hasHistory = false;
    L15:
        if (event.getEventType() != 1) goto L26;
        long estimatedLaunchTime = this.mAppStandby.getEstimatedLaunchTime(packageName, r1);
        if (estimatedLaunchTime >= now) goto L19;
    L21:
        estimatedLaunchTime = calculateNextLaunchTime(hasMoreThan24HoursOfHistory.get(packageName).booleanValue(), event.getTimeStamp());
        this.mAppStandby.setEstimatedLaunchTime(packageName, r1, estimatedLaunchTime);
    L23:
        if (estimatedLaunchTime >= (now + r16)) goto L25;
        changedTimes = changedTimes | stageChangedEstimatedLaunchTime(r1, packageName);
    L25:
        alarmQueue.addAlarm(packageName, nowElapsed + (estimatedLaunchTime - now));
        goto L26
    L19:
        if (estimatedLaunchTime != Long.MAX_VALUE) goto L23;
    L26:
        unprocessedEvent = events.getNextEvent(event);
        r1 = userId;
        r9 = r16;
        beginTime = beginTime2;
        goto L6
    L28:
        if (changedTimes == false) goto L34;
        this.mHandler.sendEmptyMessage(9);
        return;
    }

    private void setEstimatedLaunchTime(int userId, String packageName, long estimatedLaunchTime) {
        long now = System.currentTimeMillis();
        if (estimatedLaunchTime > now) goto L5;
        return;
    L5:
        long oldEstimatedLaunchTime = this.mAppStandby.getEstimatedLaunchTime(packageName, userId);
        if (estimatedLaunchTime == oldEstimatedLaunchTime) goto L11;
        this.mAppStandby.setEstimatedLaunchTime(packageName, userId, estimatedLaunchTime);
        if (stageChangedEstimatedLaunchTime(userId, packageName) == false) goto L12;
        this.mHandler.sendEmptyMessage(9);
        return;
    L12:
        return;
    }

    private void setEstimatedLaunchTimes(int userId, List<AppLaunchEstimateInfo> launchEstimates) {
        boolean changedTimes = false;
        long now = System.currentTimeMillis();
        int i = launchEstimates.size() - 1;
    L3:
        if (i < 0) goto L12;
        AppLaunchEstimateInfo estimate = launchEstimates.get(i);
        if (estimate.estimatedLaunchTime <= now) goto L10;
        long oldEstimatedLaunchTime = this.mAppStandby.getEstimatedLaunchTime(estimate.packageName, userId);
        if (estimate.estimatedLaunchTime == oldEstimatedLaunchTime) goto L10;
        this.mAppStandby.setEstimatedLaunchTime(estimate.packageName, userId, estimate.estimatedLaunchTime);
        changedTimes = changedTimes | stageChangedEstimatedLaunchTime(userId, estimate.packageName);
    L10:
        i = i - 1;
        goto L3
    L12:
        if (changedTimes == false) goto L19;
        this.mHandler.sendEmptyMessage(9);
        return;
    }

    private boolean stageChangedEstimatedLaunchTime(int userId, String packageName) {
        SparseSetArray<String> r0 = this.mPendingLaunchTimeChangePackages;
        monitor-enter(r0);
        boolean r1 = this.mPendingLaunchTimeChangePackages.add(userId, packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void registerListener(UsageStatsManagerInternal.UsageEventListener listener) {
        ArraySet<UsageStatsManagerInternal.UsageEventListener> r0 = this.mUsageEventListeners;
        monitor-enter(r0);
        this.mUsageEventListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void unregisterListener(UsageStatsManagerInternal.UsageEventListener listener) {
        ArraySet<UsageStatsManagerInternal.UsageEventListener> r0 = this.mUsageEventListeners;
        monitor-enter(r0);
        this.mUsageEventListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void registerLaunchTimeChangedListener(UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener listener) {
        this.mEstimatedLaunchTimeChangedListeners.add(listener);
    }

    private void unregisterLaunchTimeChangedListener(UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener listener) {
        this.mEstimatedLaunchTimeChangedListeners.remove(listener);
    }

    private boolean shouldDeleteObsoleteData(UserHandle userHandle) {
        DevicePolicyManagerInternal dpmInternal = getDpmInternal();
        if (dpmInternal != null) goto L5;
    L8:
        return true;
    L5:
        if (dpmInternal.getProfileOwnerOrDeviceOwnerSupervisionComponent(userHandle) == null) goto L8;
        return false;
    }

    private String buildFullToken(String packageName, String token) {
        StringBuilder sb = new StringBuilder((packageName.length() + token.length()) + 1);
        sb.append(packageName);
        sb.append(TOKEN_DELIMITER);
        sb.append(token);
        return sb.toString();
    }

    private void flushToDiskLocked() {
        int userCount = this.mUserState.size();
        int i = 0;
    L3:
        if (i >= userCount) goto L11;
        int userId = this.mUserState.keyAt(i);
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L7;
        persistPendingEventsLocked(userId);
    L10:
        i = i + 1;
        goto L3
    L7:
        UserUsageStatsService service = this.mUserState.get(userId);
        if (service == null) goto L10;
        service.persistActiveStats();
        goto L10
    L11:
        this.mHandler.removeMessages(1);
    }

    private String getTrimmedString(String input) {
        if (input != null) goto L4;
    L7:
        return input;
    L4:
        if (input.length() <= 127) goto L7;
        return input.substring(0, 127);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:209:? -> B:185:0x03a2). Please report as a decompilation issue!!! */
    void dump(String[] args, PrintWriter pw) {
        IndentingPrintWriter idpw = new IndentingPrintWriter(pw, "  ");
        ArrayList<String> pkgs = new ArrayList();
        String[] r7 = null;
        if (args == null) goto L161;
        int i = 0;
        boolean compact = false;
        boolean checkin = false;
    L6:
        if (i >= args.length) goto L160;
        String arg = args[i];
        if ("--checkin".equals(arg) == false) goto L11;
        checkin = true;
    L159:
        i = i + 1;
        r7 = null;
        goto L6
    L11:
        if ("-c".equals(arg) == false) goto L14;
        compact = true;
        goto L159
    L14:
        if ("flush".equals(arg) == true) goto L15;
        if ("is-app-standby-enabled".equals(arg) == true) goto L26;
        if ("apptimelimit".equals(arg) == true) goto L30;
        if ("file".equals(arg) == true) goto L45;
        if ("database-info".equals(arg) == true) goto L69;
        if ("appstandby".equals(arg) == true) goto L93;
        if ("stats-directory".equals(arg) == true) goto L97;
        if ("mappings".equals(arg) == true) goto L110;
        if ("broadcast-response-stats".equals(arg) == true) goto L123;
        if ("app-component-usage".equals(arg) == true) goto L133;
        boolean compact2 = compact;
        if (arg != null) goto L156;
    L158:
        compact = compact2;
        goto L159
    L156:
        if (arg.startsWith("-") == true) goto L158;
        pkgs.add(arg);
        goto L158
    L133:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        Object r12 = this.mLock;
        monitor-enter(r12);
    L143:
        th = th;
    L151:
        monitor-exit(r12);     // Catch: Throwable -> L143
        throw th;
    L145:
        th = th;
        goto L151
    L136:
        if (this.mLastTimeComponentUsedGlobal.isEmpty() == true) goto L149;
        ipw.println("App Component Usages:");     // Catch: Throwable -> L145
        ipw.increaseIndent();     // Catch: Throwable -> L145
        Iterator<String> r0 = this.mLastTimeComponentUsedGlobal.keySet().iterator();     // Catch: Throwable -> L145
    L139:
        if (r0.hasNext() == false) goto L147;
        String pkg = r0.next();     // Catch: Throwable -> L145
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L145
        r14.append("package=");     // Catch: Throwable -> L145
        r14.append(pkg);     // Catch: Throwable -> L145
        r14.append(" lastUsed=");     // Catch: Throwable -> L145
        boolean compact3 = compact;
        r14.append(UserUsageStatsService.formatDateTime(this.mLastTimeComponentUsedGlobal.get(pkg).longValue(), true));     // Catch: Throwable -> L143
        ipw.println(r14.toString());     // Catch: Throwable -> L143
        compact = compact3;
        goto L139
    L147:
        ipw.decreaseIndent();     // Catch: Throwable -> L143
    L149:
        monitor-exit(r12);     // Catch: Throwable -> L143
        return;
    L123:
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mResponseStatsTracker.dump(idpw);     // Catch: Throwable -> L128
        monitor-exit(r8);     // Catch: Throwable -> L128
        return;
    L128:
        th = move-exception;
        throw th;
    L110:
        IndentingPrintWriter ipw2 = new IndentingPrintWriter(pw, "  ");
        Object r13 = this.mLock;
        monitor-enter(r13);
        int userId = parseUserIdFromArgs(args, i, ipw2);     // Catch: Throwable -> L115
        if (userId == (-10000)) goto L117;
        this.mUserState.get(userId).dumpMappings(ipw2);     // Catch: Throwable -> L115
    L117:
        monitor-exit(r13);     // Catch: Throwable -> L115
        return;
    L115:
        th = move-exception;
        throw th;
    L97:
        IndentingPrintWriter ipw3 = new IndentingPrintWriter(pw, "  ");
        Object r15 = this.mLock;
        monitor-enter(r15);
        int userId2 = parseUserIdFromArgs(args, i, ipw3);     // Catch: Throwable -> L102
        if (userId2 == (-10000)) goto L104;
        ipw3.println(new File(Environment.getDataSystemCeDirectory(userId2), "usagestats").getAbsolutePath());     // Catch: Throwable -> L102
    L104:
        monitor-exit(r15);     // Catch: Throwable -> L102
        return;
    L102:
        th = move-exception;
        throw th;
    L93:
        this.mAppStandby.dumpState(args, pw);
        return;
    L69:
        IndentingPrintWriter ipw4 = new IndentingPrintWriter(pw, "  ");
        Object r16 = this.mLock;
        monitor-enter(r16);
    L81:
        th = move-exception;
        throw th;
    L73:
        if ((i + 1) < args.length) goto L84;
        int numUsers = this.mUserState.size();     // Catch: Throwable -> L81
        int user = 0;
    L75:
        if (user >= numUsers) goto L87;
        int userId3 = this.mUserState.keyAt(user);     // Catch: Throwable -> L81
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId3)) == false) goto L80;
        ipw4.println("user=" + userId3);     // Catch: Throwable -> L81
        ipw4.increaseIndent();     // Catch: Throwable -> L81
        this.mUserState.valueAt(user).dumpDatabaseInfo(ipw4);     // Catch: Throwable -> L81
        ipw4.decreaseIndent();     // Catch: Throwable -> L81
    L80:
        user = user + 1;     // Catch: Throwable -> L81
    L87:
        monitor-exit(r16);     // Catch: Throwable -> L81
        return;
    L84:
        int user2 = parseUserIdFromArgs(args, i, ipw4);     // Catch: Throwable -> L81
        if (user2 == (-10000)) goto L87;
        this.mUserState.get(user2).dumpDatabaseInfo(ipw4);     // Catch: Throwable -> L81
        goto L87
    L45:
        IndentingPrintWriter ipw5 = new IndentingPrintWriter(pw, "  ");
        Object r17 = this.mLock;
        monitor-enter(r17);
    L57:
        th = move-exception;
        throw th;
    L49:
        if ((i + 1) < args.length) goto L60;
        int numUsers2 = this.mUserState.size();     // Catch: Throwable -> L57
        int user3 = 0;
    L51:
        if (user3 >= numUsers2) goto L63;
        int userId4 = this.mUserState.keyAt(user3);     // Catch: Throwable -> L57
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId4)) == false) goto L56;
        ipw5.println("user=" + userId4);     // Catch: Throwable -> L57
        ipw5.increaseIndent();     // Catch: Throwable -> L57
        this.mUserState.valueAt(user3).dumpFile(ipw5, null);     // Catch: Throwable -> L57
        ipw5.decreaseIndent();     // Catch: Throwable -> L57
    L56:
        user3 = user3 + 1;     // Catch: Throwable -> L57
    L63:
        monitor-exit(r17);     // Catch: Throwable -> L57
        return;
    L60:
        int user4 = parseUserIdFromArgs(args, i, ipw5);     // Catch: Throwable -> L57
        if (user4 == (-10000)) goto L63;
        String[] remainingArgs = (String[]) Arrays.copyOfRange(args, i + 2, args.length);     // Catch: Throwable -> L57
        this.mUserState.get(user4).dumpFile(ipw5, remainingArgs);     // Catch: Throwable -> L57
        goto L63
    L30:
        Object r18 = this.mLock;
        monitor-enter(r18);
    L36:
        th = move-exception;
        throw th;
    L34:
        if ((i + 1) < args.length) goto L38;
        this.mAppTimeLimit.dump(r7, pw);     // Catch: Throwable -> L36
    L39:
        monitor-exit(r18);     // Catch: Throwable -> L36
        return;
    L38:
        String[] remainingArgs2 = (String[]) Arrays.copyOfRange(args, i + 1, args.length);     // Catch: Throwable -> L36
        this.mAppTimeLimit.dump(remainingArgs2, pw);     // Catch: Throwable -> L36
        goto L39
    L26:
        pw.println(this.mAppStandby.isAppIdleEnabled());
        return;
    L15:
        Object r19 = this.mLock;
        monitor-enter(r19);
        flushToDiskLocked();     // Catch: Throwable -> L21
        monitor-exit(r19);     // Catch: Throwable -> L21
        this.mAppStandby.flushToDisk();
        pw.println("Flushed stats to disk");
        return;
    L21:
        th = move-exception;
        throw th;
    L160:
        boolean compact4 = compact;
    L162:
        pw.println("Flags:");
        pw.println("    android.app.usage.user_interaction_type_api: true");
        pw.println("    android.app.usage.use_parceled_list: true");
        pw.println("    android.app.usage.filter_based_event_query_api: true");
        pw.println("    android.app.usage.disable_idle_check: true");
        Object r9 = this.mLock;
        monitor-enter(r9);
        int userCount = this.mUserState.size();     // Catch: Throwable -> L198
        int[] userIds = new int[userCount];     // Catch: Throwable -> L198
        int i2 = 0;
    L165:
        if (i2 >= userCount) goto L200;
        int userId5 = this.mUserState.keyAt(i2);     // Catch: Throwable -> L198
        userIds[i2] = userId5;     // Catch: Throwable -> L198
        idpw.printPair("user", Integer.valueOf(userId5));     // Catch: Throwable -> L198
        idpw.println();     // Catch: Throwable -> L198
        idpw.increaseIndent();     // Catch: Throwable -> L198
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId5)) == false) goto L174;
        if (checkin == true) goto L212;
        this.mUserState.valueAt(i2).dump(idpw, pkgs, compact4);     // Catch: Throwable -> L170
        idpw.println();     // Catch: Throwable -> L170
        checkin = checkin;
    L192:
        idpw.decreaseIndent();     // Catch: Throwable -> L194
        i2 = i2 + 1;
        checkin = checkin;
        goto L165
    L212:
        this.mUserState.valueAt(i2).checkin(idpw);     // Catch: Throwable -> L170
        checkin = checkin;
    L170:
        th = th;
    L206:
        monitor-exit(r9);     // Catch: Throwable -> L194
        throw th;
    L174:
        SparseArray<LinkedList<UsageEvents.Event>> r110 = this.mReportedEvents;     // Catch: Throwable -> L198
        monitor-enter(r110);     // Catch: Throwable -> L198
        LinkedList<UsageEvents.Event> pendingEvents = this.mReportedEvents.get(userId5);     // Catch: Throwable -> L188
        if (pendingEvents == null) goto L191;
        if (pendingEvents.isEmpty() == true) goto L191;
        int eventCount = pendingEvents.size();     // Catch: Throwable -> L188
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L188
        r111.append("Pending events: count=");     // Catch: Throwable -> L185
        r111.append(eventCount);     // Catch: Throwable -> L185
        idpw.println(r111.toString());     // Catch: Throwable -> L185
        idpw.increaseIndent();     // Catch: Throwable -> L185
        int idx = 0;
    L183:
        if (idx >= eventCount) goto L187;
        UserUsageStatsService.printEvent(idpw, pendingEvents.get(idx), true);     // Catch: Throwable -> L185
        idx = idx + 1;     // Catch: Throwable -> L185
        pendingEvents = pendingEvents;
        goto L183
    L187:
        idpw.decreaseIndent();     // Catch: Throwable -> L185
        idpw.println();     // Catch: Throwable -> L185
    L185:
        th = th;
    L196:
        monitor-exit(r110);     // Catch: Throwable -> L185
        throw th;     // Catch: Throwable -> L194
    L191:
        monitor-exit(r110);     // Catch: Throwable -> L185
    L188:
        th = th;
        goto L196
    L200:
        idpw.println();     // Catch: Throwable -> L194
        idpw.printPair("Usage Source", UsageStatsManager.usageSourceToString(this.mUsageSource));     // Catch: Throwable -> L194
        idpw.println();     // Catch: Throwable -> L194
        this.mAppTimeLimit.dump(null, pw);     // Catch: Throwable -> L194
        idpw.println();     // Catch: Throwable -> L194
        this.mResponseStatsTracker.dump(idpw);     // Catch: Throwable -> L194
        monitor-exit(r9);     // Catch: Throwable -> L194
        this.mAppStandby.dumpUsers(idpw, userIds, pkgs);
        if (CollectionUtils.isEmpty(pkgs) == false) goto L255;
        pw.println();
        this.mAppStandby.dumpState(args, pw);
        return;
    L255:
        return;
    L194:
        th = th;
    L198:
        th = th;
        goto L206
    L161:
        compact4 = false;
        checkin = false;
        goto L162
    }

    private int parseUserIdFromArgs(String[] args, int index, IndentingPrintWriter ipw) {
        int userId = Integer.parseInt(args[index + 1]);     // Catch: Throwable -> L13
        if (this.mUserState.indexOfKey(userId) >= 0) goto L9;
        ipw.println("the specified user does not exist.");
        return ProcessList.INVALID_ADJ;
    L9:
        if (this.mUserUnlockedStates.contains(Integer.valueOf(userId)) == true) goto L12;
        ipw.println("the specified user is currently in a locked state.");
        return ProcessList.INVALID_ADJ;
    L12:
        return userId;
    L14:
        ipw.println("invalid user specified.");
        return ProcessList.INVALID_ADJ;
    }

    void clearLastUsedTimestamps(String packageName, int userId) {
        this.mAppStandby.clearLastUsedTimestampsForTest(packageName, userId);
    }

    void deletePackageData(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserState.get(userId).deleteDataFor(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void registerAppUsageObserver(int callingUid, int observerId, String[] packages, long timeLimitMs, PendingIntent callbackIntent, int userId) {
        this.mAppTimeLimit.addAppUsageObserver(callingUid, observerId, packages, timeLimitMs, callbackIntent, userId);
    }

    void unregisterAppUsageObserver(int callingUid, int observerId, int userId) {
        this.mAppTimeLimit.removeAppUsageObserver(callingUid, observerId, userId);
    }

    void registerUsageSessionObserver(int callingUid, int observerId, String[] observed, long timeLimitMs, long sessionThresholdTime, PendingIntent limitReachedCallbackIntent, PendingIntent sessionEndCallbackIntent, int userId) {
        this.mAppTimeLimit.addUsageSessionObserver(callingUid, observerId, observed, timeLimitMs, sessionThresholdTime, limitReachedCallbackIntent, sessionEndCallbackIntent, userId);
    }

    void unregisterUsageSessionObserver(int callingUid, int sessionObserverId, int userId) {
        this.mAppTimeLimit.removeUsageSessionObserver(callingUid, sessionObserverId, userId);
    }

    void registerAppUsageLimitObserver(int callingUid, int observerId, String[] packages, long timeLimitMs, long timeUsedMs, PendingIntent callbackIntent, int userId) {
        this.mAppTimeLimit.addAppUsageLimitObserver(callingUid, observerId, packages, timeLimitMs, timeUsedMs, callbackIntent, userId);
    }

    void unregisterAppUsageLimitObserver(int callingUid, int observerId, int userId) {
        this.mAppTimeLimit.removeAppUsageLimitObserver(callingUid, observerId, userId);
    }
}

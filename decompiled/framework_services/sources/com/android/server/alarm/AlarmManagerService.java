package com.android.server.alarm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.IAlarmCompleteListener;
import android.app.IAlarmListener;
import android.app.IAlarmManager;
import android.app.PendingIntent;
import android.app.compat.CompatChanges;
import android.app.role.RoleManager;
import android.app.usage.UsageStatsManagerInternal;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserPackage;
import android.content.res.Resources;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.tv.mediaquality.ParameterName;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.BatteryStatsInternal;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.ThreadLocalWorkSource;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.provider.DeviceConfig;
import android.system.Os;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Log;
import android.util.LongArrayQueue;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import bytedanceos.util.FeatLog;
import com.android.internal.app.IAppOpsService;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.LocalLog;
import com.android.internal.util.RingBuffer;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.internal.util.jobs.DumpUtils;
import com.android.internal.util.jobs.StatLogger;
import com.android.server.AlarmManagerInternal;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.AppStateTracker;
import com.android.server.AppStateTrackerImpl;
import com.android.server.DeviceIdleInternal;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.SysOptApexBridge;
import com.android.server.SystemClockTime;
import com.android.server.SystemService;
import com.android.server.SystemServiceManager;
import com.android.server.SystemTimeZone;
import com.android.server.am.HostingRecord;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.permission.PermissionManagerService;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.usage.AppStandbyInternal;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerService extends SystemService {
    static final int ACTIVE_INDEX = 0;
    static final boolean DEBUG_ALARM_CLOCK = false;
    static final boolean DEBUG_BATCH = false;
    static final boolean DEBUG_BG_LIMIT = false;
    static final boolean DEBUG_LISTENER_CALLBACK = false;
    static final boolean DEBUG_STANDBY = false;
    static final boolean DEBUG_WAKELOCK = false;
    private static final int ELAPSED_REALTIME_WAKEUP_MASK = 4;
    static final int FREQUENT_INDEX = 2;
    static final long HEARTBEAT_THRESHOLD = 259200000;
    static final long INDEFINITE_DELAY = 31536000000L;
    static final int IS_WAKEUP_MASK = 5;
    static final long MIN_FUZZABLE_INTERVAL = 10000;
    static final int NEVER_INDEX = 4;
    private static final Intent NEXT_ALARM_CLOCK_CHANGED_INTENT = null;
    static final int PRIORITY_NORMAL = 2;
    static final int PRIORITY_SYSTEM = 0;
    static final int PRIORITY_WAKEUP = 1;
    static final int RARE_INDEX = 3;
    static final boolean RECORD_ALARMS_IN_HISTORY = true;
    static final boolean RECORD_DEVICE_IDLE_ALARMS = false;
    private static final int REMOVAL_HISTORY_SIZE_PER_UID = 10;
    private static final int RTC_WAKEUP_MASK = 1;
    static final String TAG = "AlarmManager";
    private static final long TEMPORARY_QUOTA_DURATION = 86400000;
    static final int TICK_HISTORY_DEPTH = 10;
    static final int TIME_CHANGED_MASK = 65536;
    static final String TIME_TICK_TAG = "TIME_TICK";
    static final int WORKING_INDEX = 1;
    static final boolean localLOGV = false;
    protected static final HeartbeatStats sHeartbeatStats = null;
    private ActivityManagerInternal mActivityManagerInternal;
    ActivityOptions mActivityOptsRestrictBal;
    private final Runnable mAlarmClockUpdater;
    final Comparator<Alarm> mAlarmDispatchComparator;
    AlarmStore mAlarmStore;
    SparseIntArray mAlarmsPerUid;
    AppWakeupHistory mAllowWhileIdleCompatHistory;
    final ArrayList<IdleDispatchEntry> mAllowWhileIdleDispatches;
    AppWakeupHistory mAllowWhileIdleHistory;
    AppOpsManager mAppOps;
    boolean mAppStandbyParole;
    private AppStateTrackerImpl mAppStateTracker;
    AppWakeupHistory mAppWakeupHistory;
    private final Intent mBackgroundIntent;
    private BatteryStatsInternal mBatteryStatsInternal;
    BroadcastOptions mBroadcastOptsRestrictBal;
    int mBroadcastRefCount;
    final SparseArray<ArrayMap<String, BroadcastStats>> mBroadcastStats;
    ClockReceiver mClockReceiver;
    Constants mConstants;
    PendingIntent mDateChangeSender;
    final DeliveryTracker mDeliveryTracker;
    volatile Set<Integer> mExactAlarmCandidates;
    private final AppStateTrackerImpl.Listener mForceAppStandbyListener;
    AlarmHandler mHandler;
    private final SparseArray<AlarmManager.AlarmClockInfo> mHandlerSparseAlarmClockArray;
    ArrayList<InFlight> mInFlight;
    private final ArrayList<AlarmManagerInternal.InFlightListener> mInFlightListeners;
    private final Injector mInjector;
    boolean mInteractive;
    long mLastAlarmDeliveryTime;
    SparseIntArray mLastOpScheduleExactAlarm;
    private final SparseLongArray mLastPriorityAlarmDispatch;
    private long mLastTickReceived;
    private long mLastTickSet;
    long mLastTimeChangeClockTime;
    long mLastTimeChangeRealtime;
    private long mLastTrigger;
    private long mLastWakeup;
    private int mListenerCount;
    IBinder.DeathRecipient mListenerDeathRecipient;
    private int mListenerFinishCount;
    DeviceIdleInternal mLocalDeviceIdleController;
    private volatile PermissionManagerServiceInternal mLocalPermissionManager;
    final Object mLock;
    final LocalLog mLog;
    long mMaxDelayTime;
    MetricsHelper mMetricsHelper;
    private final SparseArray<AlarmManager.AlarmClockInfo> mNextAlarmClockForUser;
    private boolean mNextAlarmClockMayChange;
    private long mNextNonWakeUpSetAt;
    private long mNextNonWakeup;
    long mNextNonWakeupDeliveryTime;
    private int mNextTickHistory;
    Alarm mNextWakeFromIdle;
    private long mNextWakeUpSetAt;
    private long mNextWakeup;
    long mNonInteractiveStartTime;
    long mNonInteractiveTime;
    int mNumDelayedAlarms;
    int mNumTimeChanged;
    BroadcastOptions mOptsTimeBroadcast;
    BroadcastOptions mOptsWithFgs;
    BroadcastOptions mOptsWithFgsForAlarmClock;
    BroadcastOptions mOptsWithoutFgs;
    private PackageManagerInternal mPackageManagerInternal;
    SparseArray<ArrayList<Alarm>> mPendingBackgroundAlarms;
    Alarm mPendingIdleUntil;
    ArrayList<Alarm> mPendingNonWakeupAlarms;
    private final SparseBooleanArray mPendingSendNextAlarmClockChangedForUser;
    private final SparseArray<RingBuffer<RemovedAlarm>> mRemovalHistory;
    private RoleManager mRoleManager;
    private int mSendCount;
    private int mSendFinishCount;
    private final IBinder mService;
    long mStartCurrentDelayTime;
    private boolean mStartUserBeforeScheduledAlarms;
    private final StatLogger mStatLogger;
    int mSystemUiUid;
    TemporaryQuotaReserve mTemporaryQuotaReserve;
    private final long[] mTickHistory;
    Intent mTimeTickIntent;
    Bundle mTimeTickOptions;
    IAlarmListener mTimeTickTrigger;
    private final SparseArray<AlarmManager.AlarmClockInfo> mTmpSparseAlarmClockArray;
    long mTotalDelayTime;
    private UsageStatsManagerInternal mUsageStatsManagerInternal;
    UserWakeupStore mUserWakeupStore;
    PowerManager.WakeLock mWakeLock;

    /* JADX INFO: renamed from: com.android.server.alarm.AlarmManagerService$2, reason: invalid class name */
    class AnonymousClass2 extends IAlarmListener.Stub {
        final /* synthetic */ AlarmManagerService this$0;

        public static /* synthetic */ void $r8$lambda$FzGTY398wY7rsveJl5qWIzqCYlQ(AnonymousClass2 r0, IAlarmCompleteListener r1) {
            r0.lambda$doAlarm$0(r1);
        }

        AnonymousClass2(AlarmManagerService this$0) {
            this.this$0 = this$0;
        }

        public void doAlarm(final IAlarmCompleteListener callback) throws RemoteException {
            if (AlarmManagerService.DEBUG_BATCH == false) goto L5;
            Slog.v(AlarmManagerService.TAG, "Received TIME_TICK alarm; rescheduling");
        L5:
            this.this$0.mHandler.post(new AlarmManagerService$2$$ExternalSyntheticLambda0(this, callback));
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            AlarmManagerService.m1008$$Nest$fputmLastTickReceived(this.this$0, AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCurrentTimeMillis());     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.this$0.mClockReceiver.scheduleTimeTickEvent();
            return;
        L11:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private /* synthetic */ void lambda$doAlarm$0(IAlarmCompleteListener callback) {
            this.this$0.getContext().sendBroadcastAsUser(this.this$0.mTimeTickIntent, UserHandle.ALL, null, this.this$0.mTimeTickOptions);
            callback.alarmComplete(this);     // Catch: RemoteException -> L5
            return;
        }
    }

    /* JADX INFO: renamed from: com.android.server.alarm.AlarmManagerService$4, reason: invalid class name */
    class AnonymousClass4 extends IAlarmManager.Stub {
        final /* synthetic */ AlarmManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$scO4Iu-t8u760yEMT1eAnCRYgKA, reason: not valid java name */
        public static /* synthetic */ boolean m1042$r8$lambda$scO4Iut8u760yEMT1eAnCRYgKA(String r0, int r1, Alarm r2) {
            return lambda$removeAll$0(r0, r1, r2);
        }

        AnonymousClass4(AlarmManagerService this$0) {
            this.this$0 = this$0;
        }

        public void set(String callingPackage, int type, long triggerAtTime, long windowLength, long interval, int flags, PendingIntent operation, IAlarmListener directReceiver, String listenerTag, WorkSource workSource, AlarmManager.AlarmClockInfo alarmClock) {
            int callingUid = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            if (callingUid != AlarmManagerService.m1001$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(callingPackage, 0, callingUserId)) goto L101;
            if (interval == 0) goto L10;
            if (directReceiver == null) goto L10;
            throw new IllegalArgumentException("Repeating alarms cannot use AlarmReceivers");
        L10:
            if (workSource == null) goto L13;
            this.this$0.getContext().enforcePermission("android.permission.UPDATE_DEVICE_STATS", Binder.getCallingPid(), callingUid, "AlarmManager.set");
        L13:
            if ((flags & 16) != 0) goto L15;
            long windowLength2 = windowLength;
            int flags2 = flags;
        L19:
            int flags3 = flags2 & (-43);
            if (alarmClock == null) goto L23;
            flags3 = flags3 | 2;
            windowLength2 = 0;
        L33:
            boolean lowerQuota = false;
            if ((flags3 & 4) == 0) goto L36;
            boolean r8 = true;
        L37:
            boolean allowWhileIdle = r8;
            if (windowLength2 != 0) goto L40;
            boolean r4 = true;
        L41:
            boolean exact = r4;
            int exactAllowReason = -1;
            if ((flags3 & 64) == 0) goto L47;
            this.this$0.getContext().enforcePermission("android.permission.SCHEDULE_PRIORITIZED_ALARM", Binder.getCallingPid(), callingUid, "AlarmManager.setPrioritized");
            flags3 = flags3 & (-5);
            if (exact == false) goto L46;
            int exactAllowReason2 = 5;
            Bundle idleOptions = null;
        L95:
            if (exact == false) goto L97;
            int flags4 = flags3 | 1;
        L98:
            this.this$0.setImpl(type, triggerAtTime, windowLength2, interval, operation, directReceiver, listenerTag, flags4, workSource, alarmClock, callingUid, callingPackage, idleOptions, exactAllowReason2);
            return;
        L97:
            flags4 = flags3;
            goto L98
        L46:
            exactAllowReason2 = -1;
            idleOptions = null;
            goto L95
        L47:
            if (exact == true) goto L51;
            if (allowWhileIdle == true) goto L51;
            exactAllowReason2 = -1;
            idleOptions = null;
        L51:
            Bundle idleOptions2 = null;
            if (AlarmManagerService.m1039$$Nest$smisExactAlarmChangeEnabled(callingPackage, callingUserId) == false) goto L67;
            if (directReceiver != null) goto L58;
            boolean needsPermission = exact;
            if (exact == true) goto L61;
            lowerQuota = true;
        L61:
            if (exact == false) goto L66;
            if (alarmClock == null) goto L64;
            Bundle idleOptions3 = this.this$0.mOptsWithFgsForAlarmClock.toBundle();
        L76:
            if (needsPermission == true) goto L78;
            Bundle idleOptions4 = idleOptions3;
        L92:
            if (lowerQuota == false) goto L94;
            flags3 = (flags3 & (-5)) | 32;
            exactAllowReason2 = exactAllowReason;
            idleOptions = idleOptions4;
            goto L95
        L94:
            exactAllowReason2 = exactAllowReason;
            idleOptions = idleOptions4;
            goto L95
        L78:
            if (this.this$0.hasUseExactAlarmInternal(callingPackage, callingUid) == false) goto L81;
            exactAllowReason = 3;
            idleOptions4 = idleOptions3;
            goto L92
        L81:
            if (this.this$0.hasScheduleExactAlarmInternal(callingPackage, callingUid) == false) goto L84;
            exactAllowReason = 0;
            idleOptions4 = idleOptions3;
            goto L92
        L84:
            if (this.this$0.isExemptFromExactAlarmPermissionNoLock(callingUid) == false) goto L89;
            exactAllowReason = 1;
            if (allowWhileIdle == false) goto L88;
            idleOptions2 = this.this$0.mOptsWithoutFgs.toBundle();
        L88:
            lowerQuota = allowWhileIdle;
            idleOptions4 = idleOptions2;
            goto L92
        L89:
            String errorMessage = "Caller " + callingPackage + " needs to hold android.permission.SCHEDULE_EXACT_ALARM or android.permission.USE_EXACT_ALARM to set exact alarms.";
            throw new SecurityException(errorMessage);
        L64:
            idleOptions3 = this.this$0.mOptsWithFgs.toBundle();
            goto L76
        L66:
            idleOptions3 = this.this$0.mOptsWithoutFgs.toBundle();
            goto L76
        L58:
            needsPermission = false;
            lowerQuota = allowWhileIdle;
            if (exact == false) goto L61;
            exactAllowReason = 4;
            goto L61
        L67:
            needsPermission = false;
            lowerQuota = allowWhileIdle;
            if (allowWhileIdle == true) goto L72;
            if (alarmClock != null) goto L72;
            idleOptions3 = null;
        L74:
            if (exact == false) goto L76;
            exactAllowReason = 2;
        L72:
            idleOptions3 = this.this$0.mOptsWithFgs.toBundle();
            goto L74
        L40:
            r4 = false;
            goto L41
        L36:
            r8 = false;
            goto L37
        L23:
            if (workSource != null) goto L33;
            if (UserHandle.isCore(callingUid) == false) goto L27;
        L32:
            flags3 = (flags3 | 8) & (-69);
            goto L33
        L27:
            if (UserHandle.isSameApp(callingUid, this.this$0.mSystemUiUid) == true) goto L32;
            if (AlarmManagerService.m991$$Nest$fgetmAppStateTracker(this.this$0) == null) goto L33;
            if (AlarmManagerService.m991$$Nest$fgetmAppStateTracker(this.this$0).isUidPowerSaveUserExempt(callingUid) == false) goto L33;
        L15:
            if (callingUid == 1000) goto L17;
            flags2 = flags & (-17);
            windowLength2 = windowLength;
            goto L19
        L17:
            windowLength2 = 0;
            flags2 = flags;
            goto L19
        L101:
            throw new SecurityException("Package " + callingPackage + " does not belong to the calling uid " + callingUid);
        }

        public boolean canScheduleExactAlarms(String packageName) {
            int callingUid = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCallingUid();
            int userId = UserHandle.getUserId(callingUid);
            int packageUid = AlarmManagerService.m1001$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(packageName, 0, userId);
            if (callingUid != packageUid) goto L18;
            if (AlarmManagerService.m1039$$Nest$smisExactAlarmChangeEnabled(packageName, userId) == true) goto L8;
            return true;
        L8:
            if (this.this$0.isExemptFromExactAlarmPermissionNoLock(packageUid) == false) goto L10;
            return true;
        L10:
            if (this.this$0.hasScheduleExactAlarmInternal(packageName, packageUid) == false) goto L12;
            return true;
        L12:
            if (this.this$0.hasUseExactAlarmInternal(packageName, packageUid) == true) goto L21;
            return false;
        L21:
            return true;
        L18:
            throw new SecurityException("Uid " + callingUid + " cannot query canScheduleExactAlarms for package " + packageName);
        }

        public boolean hasScheduleExactAlarm(String packageName, int userId) {
            int callingUid = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCallingUid();
            if (UserHandle.getUserId(callingUid) == userId) goto L5;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "hasScheduleExactAlarm");
        L5:
            int uid = AlarmManagerService.m1001$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(packageName, 0, userId);
            if (callingUid != uid) goto L8;
        L12:
            if (uid > 0) goto L16;
            return false;
        L16:
            return this.this$0.hasScheduleExactAlarmInternal(packageName, uid);
        L8:
            if (UserHandle.isCore(callingUid) == true) goto L12;
            throw new SecurityException("Uid " + callingUid + " cannot query hasScheduleExactAlarm for package " + packageName);
        }

        public boolean setTime(long millis) {
            setTime_enforcePermission();
            return this.this$0.setTimeImpl(millis, 100, "AlarmManager.setTime() called");
        }

        public void setTimeZone(String tz) {
            setTimeZone_enforcePermission();
            long oldId = Binder.clearCallingIdentity();
            this.this$0.setTimeZoneImpl(tz, 100, "AlarmManager.setTimeZone() called");     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(oldId);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(oldId);
            throw th;
        }

        public void remove(PendingIntent operation, IAlarmListener listener) {
            if (operation != null) goto L6;
            if (listener != null) goto L6;
            Slog.w(AlarmManagerService.TAG, "remove() with no intent or listener");
            return;
        L6:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.removeLocked(operation, listener, 1);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void removeAll(final String callingPackage) {
            final int callingUid = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCallingUid();
            if (callingUid != 1000) goto L7;
            Slog.wtfStack(AlarmManagerService.TAG, "Attempt to remove all alarms from the system uid package: " + callingPackage);
            return;
        L7:
            if (callingUid != AlarmManagerService.m1001$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(callingPackage, 0, UserHandle.getUserId(callingUid))) goto L17;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            AlarmManagerService.m1028$$Nest$mremoveAlarmsInternalLocked(this.this$0, new AlarmManagerService$4$$ExternalSyntheticLambda0(callingPackage, callingUid), 1);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L17:
            throw new SecurityException("Package " + callingPackage + " does not belong to the calling uid " + callingUid);
        }

        private static /* synthetic */ boolean lambda$removeAll$0(String callingPackage, int callingUid, Alarm a) {
            if (a.matches(callingPackage) == true) goto L5;
        L7:
            return false;
        L5:
            if (a.creatorUid != callingUid) goto L7;
            return true;
        }

        public long getNextWakeFromIdleTime() {
            return this.this$0.getNextWakeFromIdleTimeImpl();
        }

        public AlarmManager.AlarmClockInfo getNextAlarmClock(int userId) {
            int userId2 = AlarmManagerService.m990$$Nest$fgetmActivityManagerInternal(this.this$0).handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 0, "getNextAlarmClock", null);
            return this.this$0.getNextAlarmClockImpl(userId2);
        }

        public int getConfigVersion() {
            getConfigVersion_enforcePermission();
            return this.this$0.mConstants.getVersion();
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.getContext(), AlarmManagerService.TAG, pw) == true) goto L6;
            return;
        L6:
            if (args.length > 0) goto L8;
        L10:
            this.this$0.dumpImpl(new IndentingPrintWriter(pw, "  "));
            return;
        L8:
            if ("--proto".equals(args[0]) == false) goto L10;
            this.this$0.dumpProto(fd);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new ShellCmd(this.this$0, null).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    /* JADX INFO: renamed from: com.android.server.alarm.AlarmManagerService$7, reason: invalid class name */
    class AnonymousClass7 extends AppStateTrackerImpl.Listener {
        final /* synthetic */ AlarmManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$AinQYnhWVt71NkQ037hWAS7gdhc(AnonymousClass7 r0, int r1, Alarm r2) {
            return r0.lambda$updateAlarmsForUid$1(r1, r2);
        }

        public static /* synthetic */ boolean $r8$lambda$pBK0ysRM9OxX6J2fPvjoLldHNMA(AnonymousClass7 r0, Alarm r1) {
            return r0.lambda$updateAllAlarms$0(r1);
        }

        AnonymousClass7(AlarmManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.AppStateTrackerImpl.Listener
        public void updateAllAlarms() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$7$$ExternalSyntheticLambda1(this)) == false) goto L9;
            this.this$0.rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private /* synthetic */ boolean lambda$updateAllAlarms$0(Alarm a) {
            return AlarmManagerService.m1017$$Nest$madjustDeliveryTimeBasedOnBatterySaver(this.this$0, a);
        }

        @Override // com.android.server.AppStateTrackerImpl.Listener
        public void updateAlarmsForUid(final int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$7$$ExternalSyntheticLambda0(this, uid)) == false) goto L9;
            this.this$0.rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private /* synthetic */ boolean lambda$updateAlarmsForUid$1(int uid, Alarm a) {
            if (a.creatorUid == uid) goto L7;
            return false;
        L7:
            return AlarmManagerService.m1017$$Nest$madjustDeliveryTimeBasedOnBatterySaver(this.this$0, a);
        }

        @Override // com.android.server.AppStateTrackerImpl.Listener
        public void unblockAllUnrestrictedAlarms() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.sendAllUnrestrictedPendingBackgroundAlarmsLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.AppStateTrackerImpl.Listener
        public void unblockAlarmsForUid(int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.sendPendingBackgroundAlarmsLocked(uid, null);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.AppStateTrackerImpl.Listener
        public void unblockAlarmsForUidPackage(int uid, String packageName) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.sendPendingBackgroundAlarmsLocked(uid, packageName);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.AppStateTrackerImpl.Listener
        public void removeAlarmsForUid(int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.removeForStoppedLocked(uid);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    class AlarmHandler extends Handler {
        public static final int ALARM_EVENT = 1;
        public static final int APP_STANDBY_BUCKET_CHANGED = 5;
        public static final int CHARGING_STATUS_CHANGED = 6;
        public static final int CHECK_EXACT_ALARM_PERMISSION_ON_UPDATE = 13;
        public static final int LISTENER_TIMEOUT = 3;
        public static final int REFRESH_EXACT_ALARM_CANDIDATES = 11;
        public static final int REMOVE_EXACT_ALARMS = 8;
        public static final int REMOVE_EXACT_LISTENER_ALARMS_ON_CACHED = 15;
        public static final int REMOVE_FOR_CANCELED = 7;
        public static final int REPORT_ALARMS_ACTIVE = 4;
        public static final int SEND_NEXT_ALARM_CLOCK_CHANGED = 2;
        public static final int TEMPORARY_QUOTA_CHANGED = 14;
        final /* synthetic */ AlarmManagerService this$0;

        AlarmHandler(AlarmManagerService this$0) {
            this.this$0 = this$0;
            super(Looper.myLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean r1 = false;
            switch(msg.what) {
                case 1: goto L55;
                case 2: goto L54;
                case 3: goto L53;
                case 4: goto L48;
                case 5: goto L36;
                case 6: goto L21;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L101;
                case 10: goto L101;
                case 11: goto L11;
                case 12: goto L101;
                case 13: goto L6;
                case 14: goto L36;
                case 15: goto L5;
                default: goto L101;
            };
        L5:
            int uid = ((Integer) msg.obj).intValue();
            AlarmManagerService.m1029$$Nest$mremoveExactListenerAlarms(this.this$0, new int[]{uid});
            return;
        L6:
            String packageName = (String) msg.obj;
            int uid2 = msg.arg1;
            if (this.this$0.hasScheduleExactAlarmInternal(packageName, uid2) == false) goto L9;
            return;
        L9:
            if (this.this$0.hasUseExactAlarmInternal(packageName, uid2) == true) goto L90;
            this.this$0.removeExactAlarmsOnPermissionRevoked(uid2, packageName, false);
            return;
        L90:
            return;
        L11:
            this.this$0.refreshExactAlarmCandidates();
            return;
        L12:
            this.this$0.removeExactAlarmsOnPermissionRevoked(msg.arg1, (String) msg.obj, true);
            return;
        L13:
            PendingIntent operation = (PendingIntent) msg.obj;
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            this.this$0.removeLocked(operation, null, 4);     // Catch: Throwable -> L18
            monitor-exit(r3);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        L21:
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            this.this$0.mAppStandbyParole = ((Boolean) msg.obj).booleanValue();     // Catch: Throwable -> L26
            if (this.this$0.mAppStandbyParole == false) goto L28;
            SysOptApexBridge.getFactory().getAlarmMS().resetRestrictedAlarm();     // Catch: Throwable -> L26
        L28:
            boolean isReorderByStandby = this.this$0.reorderAlarmsBasedOnStandbyBuckets(null);     // Catch: Throwable -> L26
            boolean isReorderByPowerSave = this.this$0.reorderAlarmsBasedOnPowerSaver(null);     // Catch: Throwable -> L26
            if (isReorderByStandby == true) goto L31;
            if (isReorderByPowerSave == true) goto L31;
        L32:
            monitor-exit(r2);     // Catch: Throwable -> L26
            return;
        L31:
            this.this$0.rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L26
            AlarmManagerService.m1032$$Nest$mupdateNextAlarmClockLocked(this.this$0);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L36:
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            ArraySet<UserPackage> filterPackages = new ArraySet();     // Catch: Throwable -> L41
            filterPackages.add(UserPackage.of(msg.arg1, (String) msg.obj));     // Catch: Throwable -> L41
            if (this.this$0.reorderAlarmsBasedOnStandbyBuckets(filterPackages) == false) goto L43;
            this.this$0.rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L41
            AlarmManagerService.m1032$$Nest$mupdateNextAlarmClockLocked(this.this$0);     // Catch: Throwable -> L41
        L43:
            monitor-exit(r4);     // Catch: Throwable -> L41
            return;
        L41:
            th = move-exception;
            throw th;
        L53:
            this.this$0.mDeliveryTracker.alarmTimedOut((IBinder) msg.obj);
            return;
        L54:
            AlarmManagerService.m1030$$Nest$msendNextAlarmClockChanged(this.this$0);
            return;
        L55:
            ArrayList<Alarm> triggerList = new ArrayList();
            Object r5 = this.this$0.mLock;
            monitor-enter(r5);
            long nowELAPSED = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getElapsedRealtimeMillis();     // Catch: Throwable -> L72
            this.this$0.triggerAlarmsLocked(triggerList, nowELAPSED);     // Catch: Throwable -> L72
            AlarmManagerService.m1032$$Nest$mupdateNextAlarmClockLocked(this.this$0);     // Catch: Throwable -> L72
            monitor-exit(r5);     // Catch: Throwable -> L72
            int i = 0;
        L61:
            if (i >= triggerList.size()) goto L102;
            Alarm alarm = triggerList.get(i);
            Bundle bundle = AlarmManagerService.m1020$$Nest$mgetAlarmOperationBundle(this.this$0, alarm);     // Catch: PendingIntent.CanceledException -> L65
            alarm.operation.send(null, 0, null, null, null, null, bundle);     // Catch: PendingIntent.CanceledException -> L65
        L69:
            AlarmManagerService.m1019$$Nest$mdecrementAlarmCount(this.this$0, alarm.uid, 1);
            i = i + 1;
        L67:
            if (alarm.repeatInterval <= 0) goto L69;
            this.this$0.removeImpl(alarm.operation, null);
            goto L69
        L102:
            return;
        L72:
            th = move-exception;
            throw th;
        L101:
            return;
        L48:
            if (this.this$0.mLocalDeviceIdleController == null) goto L97;
            DeviceIdleInternal r0 = this.this$0.mLocalDeviceIdleController;
            if (msg.arg1 == 0) goto L52;
            r1 = true;
        L52:
            r0.setAlarmsActive(r1);
            return;
        }
    }

    private class AlarmThread extends Thread {
        private int mFalseWakeups;
        private int mWtfThreshold;
        final /* synthetic */ AlarmManagerService this$0;

        AlarmThread(AlarmManagerService r1) {
            this.this$0 = r1;
            super(AlarmManagerService.TAG);
            this.mFalseWakeups = 0;
            this.mWtfThreshold = 100;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:? -> B:124:0x0399). Please report as a decompilation issue!!! */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ArrayList<Alarm> triggerList = new ArrayList();
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            this.this$0.mLastTimeChangeClockTime = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCurrentTimeMillis();     // Catch: Throwable -> L151
            this.this$0.mLastTimeChangeRealtime = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getElapsedRealtimeMillis();     // Catch: Throwable -> L151
            monitor-exit(r3);     // Catch: Throwable -> L151
        L6:
            int result = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).waitForAlarm();
            long nowRTC = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCurrentTimeMillis();
            long nowELAPSED = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getElapsedRealtimeMillis();
            Object r9 = this.this$0.mLock;
            monitor-enter(r9);
            AlarmManagerService.m1011$$Nest$fputmLastWakeup(this.this$0, nowELAPSED);     // Catch: Throwable -> L145
            monitor-exit(r9);     // Catch: Throwable -> L145
            if (result != 0) goto L12;
            Slog.wtf(AlarmManagerService.TAG, "waitForAlarm returned 0, nowRTC = " + nowRTC + ", nowElapsed = " + nowELAPSED);
        L12:
            triggerList.clear();
            if ((result & 65536) == 0) goto L39;
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            long lastTimeChangeClockTime = this.this$0.mLastTimeChangeClockTime;     // Catch: Throwable -> L35
            long expectedClockTime = (nowELAPSED - this.this$0.mLastTimeChangeRealtime) + lastTimeChangeClockTime;     // Catch: Throwable -> L35
            monitor-exit(r4);     // Catch: Throwable -> L35
            if (nowRTC < (expectedClockTime - 1000)) goto L25;
            if (nowRTC <= (1000 + expectedClockTime)) goto L39;
        L25:
            if (AlarmManagerService.DEBUG_BATCH == false) goto L27;
            Slog.v(AlarmManagerService.TAG, "Time changed notification from kernel; rebatching");
        L27:
            FrameworkStatsLog.write(45, nowRTC);
            this.this$0.removeImpl(null, this.this$0.mTimeTickTrigger);
            this.this$0.removeImpl(this.this$0.mDateChangeSender, null);
            this.this$0.reevaluateRtcAlarms();
            this.this$0.mClockReceiver.scheduleTimeTickEvent();
            this.this$0.mClockReceiver.scheduleDateChangedEvent();
            Object r14 = this.this$0.mLock;
            monitor-enter(r14);
            this.this$0.mNumTimeChanged++;     // Catch: Throwable -> L32
            this.this$0.mLastTimeChangeClockTime = nowRTC;     // Catch: Throwable -> L32
            this.this$0.mLastTimeChangeRealtime = nowELAPSED;     // Catch: Throwable -> L32
            monitor-exit(r14);     // Catch: Throwable -> L32
            Intent intent = new Intent("android.intent.action.TIME_SET");
            intent.addFlags(622854144);
            this.this$0.mOptsTimeBroadcast.setTemporaryAppAllowlist(AlarmManagerService.m990$$Nest$fgetmActivityManagerInternal(this.this$0).getBootTimeTempAllowListDuration(), 0, 205, "");
            this.this$0.mOptsTimeBroadcast.setDeliveryGroupPolicy(1);
            this.this$0.getContext().sendBroadcastAsUser(intent, UserHandle.ALL, null, this.this$0.mOptsTimeBroadcast.toBundle());
            int result2 = result | 5;
        L41:
            if (result2 == 65536) goto L137;
            Object r5 = this.this$0.mLock;
            monitor-enter(r5);
            if (AlarmManagerService.localLOGV == false) goto L52;
            Slog.v(AlarmManagerService.TAG, "Checking for alarms... rtc=" + nowRTC + ", elapsed=" + nowELAPSED);     // Catch: Throwable -> L48
        L48:
            th = th;
        L135:
            monitor-exit(r5);     // Catch: Throwable -> L124
            throw th;
        L124:
            th = th;
        L52:
            if (AlarmManagerService.m1006$$Nest$fgetmStartUserBeforeScheduledAlarms(this.this$0) == false) goto L62;
            int[] userIds = this.this$0.mUserWakeupStore.getUserIdsToWakeup(nowELAPSED);     // Catch: Throwable -> L48
            int i = 0;
        L55:
            if (i >= userIds.length) goto L62;
            if (AlarmManagerService.m990$$Nest$fgetmActivityManagerInternal(this.this$0).isUserRunning(userIds[i], 0) == false) goto L59;
        L60:
            this.this$0.mUserWakeupStore.removeUserWakeup(userIds[i]);     // Catch: Throwable -> L48
        L61:
            i = i + 1;
            goto L55
        L59:
            if (AlarmManagerService.m990$$Nest$fgetmActivityManagerInternal(this.this$0).startUserInBackground(userIds[i]) == true) goto L61;
        L62:
            AlarmManagerService.m1010$$Nest$fputmLastTrigger(this.this$0, nowELAPSED);     // Catch: Throwable -> L133
            int wakeUps = this.this$0.triggerAlarmsLocked(triggerList, nowELAPSED);     // Catch: Throwable -> L133
            if (AlarmManagerService.localLOGV == false) goto L65;
        L66:
            Slog.i(AlarmManagerService.TAG, "triggerAlarmsLocked triggerList=" + wakeUps + ", " + triggerList + ", nowELAPSED=" + nowELAPSED + ", nowRTC=" + nowRTC + ", mLastWakedupElapsed=" + AlarmManagerService.sHeartbeatStats.mLastWakedupElapsed + ", mNextWakeup=" + AlarmManagerService.m1000$$Nest$fgetmNextWakeup(this.this$0) + ", waitForAlarm=" + result2);     // Catch: Throwable -> L133
        L67:
            if (wakeUps != 0) goto L76;
            if (this.this$0.checkAllowNonWakeupDelayLocked(nowELAPSED) == false) goto L76;
            if (this.this$0.mPendingNonWakeupAlarms.size() != 0) goto L73;
            this.this$0.mStartCurrentDelayTime = nowELAPSED;     // Catch: Throwable -> L48
            this.this$0.mNextNonWakeupDeliveryTime = ((this.this$0.currentNonWakeupFuzzLocked(nowELAPSED) * 3) / 2) + nowELAPSED;     // Catch: Throwable -> L48
        L73:
            this.this$0.mPendingNonWakeupAlarms.addAll(triggerList);     // Catch: Throwable -> L48
            this.this$0.mNumDelayedAlarms += triggerList.size();     // Catch: Throwable -> L48
            this.this$0.rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L48
            AlarmManagerService.m1032$$Nest$mupdateNextAlarmClockLocked(this.this$0);     // Catch: Throwable -> L48
            ArrayList<Alarm> triggerList2 = triggerList;
        L173:
            monitor-exit(r5);     // Catch: Throwable -> L124
        L141:
            triggerList = triggerList2;
        L76:
            if (this.this$0.mPendingNonWakeupAlarms.size() <= 0) goto L83;
            this.this$0.calculateDeliveryPriorities(this.this$0.mPendingNonWakeupAlarms);     // Catch: Throwable -> L48
            triggerList.addAll(this.this$0.mPendingNonWakeupAlarms);     // Catch: Throwable -> L48
            Collections.sort(triggerList, this.this$0.mAlarmDispatchComparator);     // Catch: Throwable -> L48
            long thisDelayTime = nowELAPSED - this.this$0.mStartCurrentDelayTime;     // Catch: Throwable -> L48
            this.this$0.mTotalDelayTime += thisDelayTime;     // Catch: Throwable -> L48
            if (this.this$0.mMaxDelayTime >= thisDelayTime) goto L80;
            this.this$0.mMaxDelayTime = thisDelayTime;     // Catch: Throwable -> L48
        L80:
            this.this$0.mPendingNonWakeupAlarms.clear();     // Catch: Throwable -> L48
        L83:
            if (this.this$0.mLastTimeChangeRealtime != nowELAPSED) goto L85;
        L92:
            ArraySet<UserPackage> triggerPackages = new ArraySet();     // Catch: Throwable -> L133
            IntArray wakeupUids = new IntArray();     // Catch: Throwable -> L133
            SparseIntArray countsPerUid = new SparseIntArray();     // Catch: Throwable -> L133
            SparseIntArray wakeupCountsPerUid = new SparseIntArray();     // Catch: Throwable -> L133
            int i2 = 0;
        L94:
            if (i2 >= triggerList.size()) goto L175;
            Alarm a = triggerList.get(i2);     // Catch: Throwable -> L106
            AlarmManagerService.m1036$$Nest$smincrement(countsPerUid, a.uid);     // Catch: Throwable -> L106
            if (a.wakeup == false) goto L99;
            wakeupUids.add(a.uid);     // Catch: Throwable -> L48
            AlarmManagerService.m1036$$Nest$smincrement(wakeupCountsPerUid, a.uid);     // Catch: Throwable -> L48
        L99:
            if (AlarmManagerService.isExemptFromAppStandby(a) == true) goto L109;
            triggerPackages.add(UserPackage.of(UserHandle.getUserId(a.creatorUid), a.sourcePackage));     // Catch: Throwable -> L104
        L104:
            th = th;
        L109:
            i2 = i2 + 1;
            result2 = result2;
        L106:
            th = th;
            goto L135
        L175:
        L126:
            th = th;
            goto L135
        L112:
            if (wakeupUids.size() > 0) goto L114;
        L116:
            this.this$0.deliverAlarmsLocked(triggerList, nowELAPSED);     // Catch: Throwable -> L126
            this.this$0.mTemporaryQuotaReserve.cleanUpExpiredQuotas(nowELAPSED);     // Catch: Throwable -> L126
            this.this$0.reorderAlarmsBasedOnStandbyBuckets(triggerPackages);     // Catch: Throwable -> L126
            ArraySet<UserPackage> powerSaverTriggerPackages = new ArraySet();     // Catch: Throwable -> L126
            int i3 = 0;
        L118:
            if (i3 >= triggerList.size()) goto L130;
            Alarm a2 = triggerList.get(i3);     // Catch: Throwable -> L126
            if (AlarmManagerService.isExemptFromPowerSaver(a2) == true) goto L129;
            powerSaverTriggerPackages.add(UserPackage.of(UserHandle.getUserId(a2.creatorUid), a2.sourcePackage));     // Catch: Throwable -> L124
        L129:
            i3 = i3 + 1;     // Catch: Throwable -> L124
            triggerList = triggerList;
            goto L118
        L130:
            triggerList2 = triggerList;
            this.this$0.reorderAlarmsBasedOnPowerSaver(powerSaverTriggerPackages);     // Catch: Throwable -> L124
            this.this$0.rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L124
            AlarmManagerService.m1032$$Nest$mupdateNextAlarmClockLocked(this.this$0);     // Catch: Throwable -> L124
            AlarmManagerService.m1025$$Nest$mlogAlarmBatchDelivered(this.this$0, triggerList2.size(), wakeUps, countsPerUid, wakeupCountsPerUid);     // Catch: Throwable -> L124
            goto L173
        L114:
            if (AlarmManagerService.m993$$Nest$fgetmBatteryStatsInternal(this.this$0) == null) goto L116;
            AlarmManagerService.m993$$Nest$fgetmBatteryStatsInternal(this.this$0).noteWakingAlarmBatch(nowELAPSED, wakeupUids.toArray());     // Catch: Throwable -> L104
            goto L116
        L85:
            if (triggerList.isEmpty() == false) goto L92;
            int r10 = this.mFalseWakeups + 1;     // Catch: Throwable -> L48
            this.mFalseWakeups = r10;     // Catch: Throwable -> L48
            if (r10 < this.mWtfThreshold) goto L92;
            Slog.wtf(AlarmManagerService.TAG, "Too many (" + this.mFalseWakeups + ") false wakeups, nowElapsed=" + nowELAPSED);     // Catch: Throwable -> L48
            if (this.mWtfThreshold >= 100000) goto L91;
            this.mWtfThreshold *= 10;     // Catch: Throwable -> L48
            goto L92
        L91:
            this.mFalseWakeups = 0;     // Catch: Throwable -> L48
            goto L92
        L65:
            if (HeartbeatStats.DEBUG_HEARTBEAT == false) goto L67;
        L133:
            th = th;
            goto L135
        L137:
            triggerList2 = triggerList;
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            this.this$0.rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L142
            monitor-exit(r2);     // Catch: Throwable -> L142
        L142:
            th = move-exception;
            throw th;
        L32:
            th = move-exception;
            throw th;
        L35:
            th = move-exception;
            throw th;
        L39:
            result2 = result;
        L145:
            th = th;
        L167:
            throw th;
        L149:
            th = th;
        L151:
            th = th;
        L177:
            throw th;
        L155:
            th = th;
            goto L177
        }
    }

    private final class AppStandbyTracker extends AppStandbyInternal.AppIdleStateChangeListener {
        final /* synthetic */ AlarmManagerService this$0;

        /* synthetic */ AppStandbyTracker(AlarmManagerService r1, AlarmManagerServiceIA r2) {
            this(r1);
        }

        private AppStandbyTracker(AlarmManagerService r1) {
            this.this$0 = r1;
        }

        public void onAppIdleStateChanged(String packageName, int userId, boolean idle, int bucket, int reason) {
            if (AlarmManagerService.DEBUG_STANDBY == false) goto L5;
            Slog.d(AlarmManagerService.TAG, "Package " + packageName + " for user " + userId + " now in bucket " + bucket);
        L5:
            this.this$0.mHandler.obtainMessage(5, userId, -1, packageName).sendToTarget();
        }

        public void triggerTemporaryQuotaBump(String packageName, int userId) {
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            int quotaBump = this.this$0.mConstants.TEMPORARY_QUOTA_BUMP;     // Catch: Throwable -> L32
            monitor-exit(r1);     // Catch: Throwable -> L32
            if (quotaBump > 0) goto L8;
            return;
        L8:
            int uid = AlarmManagerService.m1001$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(packageName, 0, userId);
            if (uid < 0) goto L31;
            if (UserHandle.isCore(uid) == false) goto L14;
            return;
        L14:
            if (AlarmManagerService.DEBUG_STANDBY == false) goto L16;
            Slog.d(AlarmManagerService.TAG, "Bumping quota temporarily for " + packageName + " for user " + userId);
        L16:
            Object r8 = this.this$0.mLock;
            monitor-enter(r8);
            this.this$0.mTemporaryQuotaReserve.replenishQuota(packageName, userId, quotaBump, AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getElapsedRealtimeMillis());     // Catch: Throwable -> L24
            monitor-exit(r8);     // Catch: Throwable -> L24
            this.this$0.mHandler.obtainMessage(14, userId, -1, packageName).sendToTarget();
            return;
        L24:
            th = move-exception;
            Throwable r10 = th;
        L28:
            monitor-exit(r8);     // Catch: Throwable -> L24
            throw r10;
        L26:
            th = move-exception;
            r10 = th;
            goto L28
        L31:
            return;
        L32:
            th = th;
        L39:
            throw th;
        L36:
            th = th;
            goto L39
        }
    }

    static class AppWakeupHistory {
        private final ArrayMap<UserPackage, LongArrayQueue> mPackageHistory;
        private long mWindowSize;

        AppWakeupHistory(long windowSize) {
            this.mPackageHistory = new ArrayMap();
            this.mWindowSize = windowSize;
        }

        void recordAlarmForPackage(String packageName, int userId, long nowElapsed) {
            UserPackage userPackage = UserPackage.of(userId, packageName);
            LongArrayQueue history = this.mPackageHistory.get(userPackage);
            if (history != null) goto L6;
            history = new LongArrayQueue();
            this.mPackageHistory.put(userPackage, history);
        L6:
            if (history.size() != 0) goto L8;
        L9:
            history.addLast(nowElapsed);
        L10:
            snapToWindow(history);
            return;
        L8:
            if (history.peekLast() >= nowElapsed) goto L10;
            goto L9
        }

        void removeForUser(int userId) {
            int i = this.mPackageHistory.size() - 1;
        L3:
            if (i < 0) goto L9;
            UserPackage userPackageKey = this.mPackageHistory.keyAt(i);
            if (userPackageKey.userId != userId) goto L7;
            this.mPackageHistory.removeAt(i);
        L7:
            i = i - 1;
            goto L3
        }

        void removeForPackage(String packageName, int userId) {
            UserPackage userPackage = UserPackage.of(userId, packageName);
            this.mPackageHistory.remove(userPackage);
        }

        private void snapToWindow(LongArrayQueue history) {
        L3:
            if ((history.peekFirst() + this.mWindowSize) >= history.peekLast()) goto L5;
            history.removeFirst();
            goto L3
        }

        int getTotalWakeupsInWindow(String packageName, int userId) {
            LongArrayQueue history = this.mPackageHistory.get(UserPackage.of(userId, packageName));
            if (history != null) goto L6;
            return 0;
        L6:
            return history.size();
        }

        long getNthLastWakeupForPackage(String packageName, int userId, int n) {
            LongArrayQueue history = this.mPackageHistory.get(UserPackage.of(userId, packageName));
            if (history != null) goto L5;
            return 0;
        L5:
            int i = history.size() - n;
            if (i >= 0) goto L9;
            return 0;
        L9:
            return history.get(i);
        }

        void dump(IndentingPrintWriter pw, long nowElapsed) {
            pw.increaseIndent();
            int i = 0;
        L4:
            if (i >= this.mPackageHistory.size()) goto L9;
            UserPackage userPackage = this.mPackageHistory.keyAt(i);
            LongArrayQueue timestamps = this.mPackageHistory.valueAt(i);
            pw.print(userPackage.packageName);
            pw.print(", u");
            pw.print(userPackage.userId);
            pw.print(": ");
            int lastIdx = Math.max(0, timestamps.size() - 100);
            int j = timestamps.size() - 1;
        L6:
            if (j < lastIdx) goto L8;
            TimeUtils.formatDuration(timestamps.get(j), nowElapsed, pw);
            pw.print(", ");
            j = j - 1;
            goto L6
        L8:
            pw.println();
            i = i + 1;
            goto L4
        L9:
            pw.decreaseIndent();
        }
    }

    static final class BroadcastStats {
        long aggregateTime;
        int count;
        final ArrayMap<String, FilterStats> filterStats;
        final String mPackageName;
        final int mUid;
        int nesting;
        int numWakeup;
        long startTime;

        BroadcastStats(int uid, String packageName) {
            this.filterStats = new ArrayMap();
            this.mUid = uid;
            this.mPackageName = packageName;
        }

        public String toString() {
            return "BroadcastStats{uid=" + this.mUid + ", packageName=" + this.mPackageName + ", aggregateTime=" + this.aggregateTime + ", count=" + this.count + ", numWakeup=" + this.numWakeup + ", startTime=" + this.startTime + ", nesting=" + this.nesting + "}";
        }

        public void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, this.mUid);
            proto.write(1138166333442L, this.mPackageName);
            proto.write(1112396529667L, this.aggregateTime);
            proto.write(1120986464260L, this.count);
            proto.write(1120986464261L, this.numWakeup);
            proto.write(1112396529670L, this.startTime);
            proto.write(1120986464263L, this.nesting);
            proto.end(token);
        }
    }

    class ChargingReceiver extends BroadcastReceiver {
        final /* synthetic */ AlarmManagerService this$0;

        ChargingReceiver(AlarmManagerService this$0) {
            this.this$0 = this$0;
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.os.action.CHARGING");
            filter.addAction("android.os.action.DISCHARGING");
            this$0.getContext().registerReceiver(this, filter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.os.action.CHARGING".equals(action) == true) goto L5;
            boolean charging = AlarmManagerService.DEBUG_STANDBY;
            if (charging == false) goto L11;
            Slog.d(AlarmManagerService.TAG, "Disconnected from power.");
        L11:
            boolean charging2 = false;
        L12:
            this.this$0.mHandler.removeMessages(6);
            this.this$0.mHandler.obtainMessage(6, Boolean.valueOf(charging2)).sendToTarget();
            return;
        L5:
            if (AlarmManagerService.DEBUG_STANDBY == false) goto L7;
            Slog.d(AlarmManagerService.TAG, "Device is charging.");
        L7:
            charging2 = true;
            goto L12
        }
    }

    class ClockReceiver extends BroadcastReceiver {
        final /* synthetic */ AlarmManagerService this$0;

        public ClockReceiver(AlarmManagerService this$0) {
            this.this$0 = this$0;
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.DATE_CHANGED");
            this$0.getContext().registerReceiver(this, filter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.DATE_CHANGED") == false) goto L6;
            scheduleDateChangedEvent();
            return;
        }

        public void scheduleTimeTickEvent() {
            long currentTime = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCurrentTimeMillis();
            long nextTime = ((currentTime / 60000) + 1) * 60000;
            long tickEventDelay = nextTime - currentTime;
            if (this.this$0.mConstants.TIME_TICK_ALLOWED_WHILE_IDLE == false) goto L5;
            int r8 = 8;
        L6:
            int flags = 1 | r8;
            this.this$0.setImpl(3, AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getElapsedRealtimeMillis() + tickEventDelay, 0, 0, null, this.this$0.mTimeTickTrigger, AlarmManagerService.TIME_TICK_TAG, flags, null, null, Process.myUid(), PackageManagerService.PLATFORM_PACKAGE_NAME, null, 1);
            Object r9 = this.this$0.mLock;
            monitor-enter(r9);
            AlarmManagerService.m1009$$Nest$fputmLastTickSet(this.this$0, currentTime);     // Catch: Throwable -> L11
            monitor-exit(r9);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        L5:
            r8 = 0;
            goto L6
        }

        public void scheduleDateChangedEvent() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getCurrentTimeMillis());
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.add(5, 1);
            this.this$0.setImpl(1, calendar.getTimeInMillis(), 0, 0, this.this$0.mDateChangeSender, null, null, 1, null, null, Process.myUid(), PackageManagerService.PLATFORM_PACKAGE_NAME, null, 1);
        }
    }

    final class Constants implements DeviceConfig.OnPropertiesChangedListener {
        private static final long DEFAULT_ALLOW_WHILE_IDLE_ALLOWLIST_DURATION = 10000;
        private static final int DEFAULT_ALLOW_WHILE_IDLE_COMPAT_QUOTA = 7;
        private static final long DEFAULT_ALLOW_WHILE_IDLE_COMPAT_WINDOW = 3600000;
        private static final int DEFAULT_ALLOW_WHILE_IDLE_QUOTA = 72;
        private static final long DEFAULT_ALLOW_WHILE_IDLE_WINDOW = 3600000;
        private static final int DEFAULT_APP_STANDBY_RESTRICTED_QUOTA = 1;
        private static final long DEFAULT_APP_STANDBY_RESTRICTED_WINDOW = 86400000;
        private static final long DEFAULT_APP_STANDBY_WINDOW = 3600000;
        private static final long DEFAULT_CACHED_LISTENER_REMOVAL_DELAY = 10000;
        private static final boolean DEFAULT_DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF = true;
        private static final long DEFAULT_LISTENER_TIMEOUT = 5000;
        private static final int DEFAULT_MAX_ALARMS_PER_UID = 500;
        private static final long DEFAULT_MAX_DEVICE_IDLE_FUZZ = 900000;
        private static final long DEFAULT_MAX_INTERVAL = 31536000000L;
        private static final long DEFAULT_MIN_DEVICE_IDLE_FUZZ = 120000;
        private static final long DEFAULT_MIN_FUTURITY = 5000;
        private static final long DEFAULT_MIN_INTERVAL = 60000;
        private static final long DEFAULT_MIN_WINDOW = 600000;
        private static final long DEFAULT_PRIORITY_ALARM_DELAY = 540000;
        private static final int DEFAULT_TEMPORARY_QUOTA_BUMP = 0;
        private static final boolean DEFAULT_TIME_TICK_ALLOWED_WHILE_IDLE = true;
        static final String KEY_ALLOW_WHILE_IDLE_COMPAT_QUOTA = "allow_while_idle_compat_quota";
        static final String KEY_ALLOW_WHILE_IDLE_COMPAT_WINDOW = "allow_while_idle_compat_window";
        static final String KEY_ALLOW_WHILE_IDLE_QUOTA = "allow_while_idle_quota";
        static final String KEY_ALLOW_WHILE_IDLE_WHITELIST_DURATION = "allow_while_idle_whitelist_duration";
        static final String KEY_ALLOW_WHILE_IDLE_WINDOW = "allow_while_idle_window";
        private static final String KEY_APP_STANDBY_RESTRICTED_QUOTA = "standby_quota_restricted";
        private static final String KEY_APP_STANDBY_RESTRICTED_WINDOW = "app_standby_restricted_window";
        private static final String KEY_APP_STANDBY_WINDOW = "app_standby_window";
        static final String KEY_CACHED_LISTENER_REMOVAL_DELAY = "cached_listener_removal_delay";
        private static final String KEY_DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF = "delay_nonwakeup_alarms_while_screen_off";
        static final String KEY_LISTENER_TIMEOUT = "listener_timeout";
        static final String KEY_MAX_ALARMS_PER_UID = "max_alarms_per_uid";
        static final String KEY_MAX_DEVICE_IDLE_FUZZ = "max_device_idle_fuzz";
        static final String KEY_MAX_INTERVAL = "max_interval";
        static final String KEY_MIN_DEVICE_IDLE_FUZZ = "min_device_idle_fuzz";
        static final String KEY_MIN_FUTURITY = "min_futurity";
        static final String KEY_MIN_INTERVAL = "min_interval";
        static final String KEY_MIN_WINDOW = "min_window";
        private static final String KEY_PREFIX_STANDBY_QUOTA = "standby_quota_";
        static final String KEY_PRIORITY_ALARM_DELAY = "priority_alarm_delay";
        static final String KEY_TEMPORARY_QUOTA_BUMP = "temporary_quota_bump";
        private static final String KEY_TIME_TICK_ALLOWED_WHILE_IDLE = "time_tick_allowed_while_idle";
        public int ALLOW_WHILE_IDLE_COMPAT_QUOTA;
        public long ALLOW_WHILE_IDLE_COMPAT_WINDOW;
        public int ALLOW_WHILE_IDLE_QUOTA;
        public long ALLOW_WHILE_IDLE_WHITELIST_DURATION;
        public long ALLOW_WHILE_IDLE_WINDOW;
        public int[] APP_STANDBY_QUOTAS;
        public int APP_STANDBY_RESTRICTED_QUOTA;
        public long APP_STANDBY_RESTRICTED_WINDOW;
        public long APP_STANDBY_WINDOW;
        public long CACHED_LISTENER_REMOVAL_DELAY;
        private final int[] DEFAULT_APP_STANDBY_QUOTAS;
        public boolean DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF;
        final String[] KEYS_APP_STANDBY_QUOTAS;
        public long LISTENER_TIMEOUT;
        public int MAX_ALARMS_PER_UID;
        public long MAX_DEVICE_IDLE_FUZZ;
        public long MAX_INTERVAL;
        public long MIN_DEVICE_IDLE_FUZZ;
        public long MIN_FUTURITY;
        public long MIN_INTERVAL;
        public long MIN_WINDOW;
        public long PRIORITY_ALARM_DELAY;
        public int TEMPORARY_QUOTA_BUMP;
        public boolean TIME_TICK_ALLOWED_WHILE_IDLE;
        private long mLastAllowWhileIdleWhitelistDuration;
        private int mVersion;
        final /* synthetic */ AlarmManagerService this$0;

        Constants(AlarmManagerService this$0, Handler handler) {
            this.this$0 = this$0;
            this.KEYS_APP_STANDBY_QUOTAS = new String[]{"standby_quota_active", "standby_quota_working", "standby_quota_frequent", "standby_quota_rare", "standby_quota_never"};
            this.DEFAULT_APP_STANDBY_QUOTAS = new int[]{720, 10, 2, 1, 0};
            this.MIN_FUTURITY = 5000;
            this.MIN_INTERVAL = 60000;
            this.MAX_INTERVAL = 31536000000L;
            this.MIN_WINDOW = 600000;
            this.ALLOW_WHILE_IDLE_WHITELIST_DURATION = 10000;
            this.LISTENER_TIMEOUT = 5000;
            this.MAX_ALARMS_PER_UID = 500;
            this.APP_STANDBY_WINDOW = 3600000;
            this.APP_STANDBY_QUOTAS = new int[this.DEFAULT_APP_STANDBY_QUOTAS.length];
            this.APP_STANDBY_RESTRICTED_QUOTA = 1;
            this.APP_STANDBY_RESTRICTED_WINDOW = 86400000;
            this.TIME_TICK_ALLOWED_WHILE_IDLE = true;
            this.ALLOW_WHILE_IDLE_QUOTA = 72;
            this.ALLOW_WHILE_IDLE_COMPAT_QUOTA = 7;
            this.ALLOW_WHILE_IDLE_COMPAT_WINDOW = 3600000;
            this.ALLOW_WHILE_IDLE_WINDOW = 3600000;
            this.PRIORITY_ALARM_DELAY = DEFAULT_PRIORITY_ALARM_DELAY;
            this.MIN_DEVICE_IDLE_FUZZ = 120000;
            this.MAX_DEVICE_IDLE_FUZZ = 900000;
            this.TEMPORARY_QUOTA_BUMP = 0;
            this.DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF = true;
            this.CACHED_LISTENER_REMOVAL_DELAY = 10000;
            this.mLastAllowWhileIdleWhitelistDuration = -1;
            this.mVersion = 0;
            updateAllowWhileIdleWhitelistDurationLocked();
            int i = 0;
        L4:
            if (i >= this.APP_STANDBY_QUOTAS.length) goto L7;
            this.APP_STANDBY_QUOTAS[i] = this.DEFAULT_APP_STANDBY_QUOTAS[i];
            i = i + 1;
            goto L4
        }

        public int getVersion() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = this.mVersion;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void start() {
            AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).registerDeviceConfigListener(this);
            onPropertiesChanged(DeviceConfig.getProperties("alarm_manager", new String[0]));
        }

        public void updateAllowWhileIdleWhitelistDurationLocked() {
            if (this.mLastAllowWhileIdleWhitelistDuration == this.ALLOW_WHILE_IDLE_WHITELIST_DURATION) goto L6;
            this.mLastAllowWhileIdleWhitelistDuration = this.ALLOW_WHILE_IDLE_WHITELIST_DURATION;
            this.this$0.mOptsWithFgs.setTemporaryAppAllowlist(this.ALLOW_WHILE_IDLE_WHITELIST_DURATION, 0, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ALARM_MANAGER_WHILE_IDLE, "");
            this.this$0.mOptsWithFgsForAlarmClock.setTemporaryAppAllowlist(this.ALLOW_WHILE_IDLE_WHITELIST_DURATION, 0, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ALARM_MANAGER_ALARM_CLOCK, "");
            this.this$0.mOptsWithoutFgs.setTemporaryAppAllowlist(this.ALLOW_WHILE_IDLE_WHITELIST_DURATION, 1, -1, "");
            return;
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            boolean standbyQuotaUpdated = false;
            boolean deviceIdleFuzzBoundariesUpdated = false;
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            this.mVersion++;     // Catch: Throwable -> L16
            Iterator r0 = properties.getKeyset().iterator();     // Catch: Throwable -> L16
        L6:
            if (r0.hasNext() == false) goto L118;
            String name = (String) r0.next();     // Catch: Throwable -> L16
            if (name == null) goto L6;
            switch(name.hashCode()) {
                case -1577286106: goto L73;
                case -1490947714: goto L70;
                case -1293038119: goto L67;
                case -1251256606: goto L64;
                case -975718548: goto L61;
                case -880907612: goto L58;
                case -618440710: goto L55;
                case -591494837: goto L52;
                case -577593775: goto L49;
                case -564889801: goto L46;
                case -410928980: goto L43;
                case -392965507: goto L40;
                case -147388512: goto L37;
                case 932562134: goto L34;
                case 1139967827: goto L31;
                case 1213697417: goto L28;
                case 1528643904: goto L25;
                case 1883600258: goto L22;
                case 2003069970: goto L19;
                case 2099862680: goto L14;
                default: goto L75;
            };     // Catch: Throwable -> L16
        L75:
            byte r7 = -1;
        L77:
            switch(r7) {
                case 0: goto L116;
                case 1: goto L115;
                case 2: goto L114;
                case 3: goto L111;
                case 4: goto L110;
                case 5: goto L107;
                case 6: goto L101;
                case 7: goto L95;
                case 8: goto L94;
                case 9: goto L93;
                case 10: goto L90;
                case 11: goto L89;
                case 12: goto L89;
                case 13: goto L88;
                case 14: goto L87;
                case 15: goto L85;
                case 16: goto L85;
                case 17: goto L84;
                case 18: goto L83;
                case 19: goto L82;
                default: goto L79;
            };     // Catch: Throwable -> L16
        L82:
            this.CACHED_LISTENER_REMOVAL_DELAY = properties.getLong(KEY_CACHED_LISTENER_REMOVAL_DELAY, 10000);     // Catch: Throwable -> L16
            goto L6
        L83:
            this.DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF = properties.getBoolean(KEY_DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF, true);     // Catch: Throwable -> L16
            goto L6
        L84:
            this.TEMPORARY_QUOTA_BUMP = properties.getInt(KEY_TEMPORARY_QUOTA_BUMP, 0);     // Catch: Throwable -> L16
            goto L6
        L85:
            if (deviceIdleFuzzBoundariesUpdated == true) goto L6;
            updateDeviceIdleFuzzBoundaries();     // Catch: Throwable -> L16
            deviceIdleFuzzBoundariesUpdated = true;
            goto L6
        L87:
            this.PRIORITY_ALARM_DELAY = properties.getLong(KEY_PRIORITY_ALARM_DELAY, DEFAULT_PRIORITY_ALARM_DELAY);     // Catch: Throwable -> L16
            goto L6
        L88:
            this.TIME_TICK_ALLOWED_WHILE_IDLE = properties.getBoolean(KEY_TIME_TICK_ALLOWED_WHILE_IDLE, true);     // Catch: Throwable -> L16
            goto L6
        L89:
            updateStandbyWindowsLocked();     // Catch: Throwable -> L16
            goto L6
        L90:
            this.MAX_ALARMS_PER_UID = properties.getInt(KEY_MAX_ALARMS_PER_UID, 500);     // Catch: Throwable -> L16
            if (this.MAX_ALARMS_PER_UID >= 500) goto L6;
            Slog.w(AlarmManagerService.TAG, "Cannot set max_alarms_per_uid lower than 500");     // Catch: Throwable -> L16
            this.MAX_ALARMS_PER_UID = 500;     // Catch: Throwable -> L16
            goto L6
        L93:
            this.LISTENER_TIMEOUT = properties.getLong(KEY_LISTENER_TIMEOUT, 5000);     // Catch: Throwable -> L16
            goto L6
        L94:
            this.ALLOW_WHILE_IDLE_WHITELIST_DURATION = properties.getLong(KEY_ALLOW_WHILE_IDLE_WHITELIST_DURATION, 10000);     // Catch: Throwable -> L16
            updateAllowWhileIdleWhitelistDurationLocked();     // Catch: Throwable -> L16
            goto L6
        L95:
            this.ALLOW_WHILE_IDLE_COMPAT_WINDOW = properties.getLong(KEY_ALLOW_WHILE_IDLE_COMPAT_WINDOW, 3600000);     // Catch: Throwable -> L16
            if (this.ALLOW_WHILE_IDLE_COMPAT_WINDOW <= 3600000) goto L99;
            Slog.w(AlarmManagerService.TAG, "Cannot have allow_while_idle_compat_window > 3600000");     // Catch: Throwable -> L16
            this.ALLOW_WHILE_IDLE_COMPAT_WINDOW = 3600000;     // Catch: Throwable -> L16
            goto L6
        L99:
            if (this.ALLOW_WHILE_IDLE_COMPAT_WINDOW == 3600000) goto L6;
            Slog.w(AlarmManagerService.TAG, "Using a non-default allow_while_idle_compat_window = " + this.ALLOW_WHILE_IDLE_COMPAT_WINDOW);     // Catch: Throwable -> L16
            goto L6
        L101:
            this.ALLOW_WHILE_IDLE_WINDOW = properties.getLong(KEY_ALLOW_WHILE_IDLE_WINDOW, 3600000);     // Catch: Throwable -> L16
            if (this.ALLOW_WHILE_IDLE_WINDOW <= 3600000) goto L105;
            Slog.w(AlarmManagerService.TAG, "Cannot have allow_while_idle_window > 3600000");     // Catch: Throwable -> L16
            this.ALLOW_WHILE_IDLE_WINDOW = 3600000;     // Catch: Throwable -> L16
            goto L6
        L105:
            if (this.ALLOW_WHILE_IDLE_WINDOW == 3600000) goto L6;
            Slog.w(AlarmManagerService.TAG, "Using a non-default allow_while_idle_window = " + this.ALLOW_WHILE_IDLE_WINDOW);     // Catch: Throwable -> L16
            goto L6
        L107:
            this.ALLOW_WHILE_IDLE_COMPAT_QUOTA = properties.getInt(KEY_ALLOW_WHILE_IDLE_COMPAT_QUOTA, 7);     // Catch: Throwable -> L16
            if (this.ALLOW_WHILE_IDLE_COMPAT_QUOTA > 0) goto L6;
            Slog.w(AlarmManagerService.TAG, "Must have positive allow_while_idle_compat quota");     // Catch: Throwable -> L16
            this.ALLOW_WHILE_IDLE_COMPAT_QUOTA = 1;     // Catch: Throwable -> L16
            goto L6
        L110:
            this.MIN_WINDOW = properties.getLong(KEY_MIN_WINDOW, 600000);     // Catch: Throwable -> L16
            goto L6
        L111:
            this.ALLOW_WHILE_IDLE_QUOTA = properties.getInt(KEY_ALLOW_WHILE_IDLE_QUOTA, 72);     // Catch: Throwable -> L16
            if (this.ALLOW_WHILE_IDLE_QUOTA > 0) goto L6;
            Slog.w(AlarmManagerService.TAG, "Must have positive allow_while_idle quota");     // Catch: Throwable -> L16
            this.ALLOW_WHILE_IDLE_QUOTA = 1;     // Catch: Throwable -> L16
            goto L6
        L114:
            this.MAX_INTERVAL = properties.getLong(KEY_MAX_INTERVAL, 31536000000L);     // Catch: Throwable -> L16
            goto L6
        L115:
            this.MIN_INTERVAL = properties.getLong(KEY_MIN_INTERVAL, 60000);     // Catch: Throwable -> L16
            goto L6
        L116:
            this.MIN_FUTURITY = properties.getLong(KEY_MIN_FUTURITY, 5000);     // Catch: Throwable -> L16
            goto L6
        L79:
            if (name.startsWith(KEY_PREFIX_STANDBY_QUOTA) == false) goto L6;
            if (standbyQuotaUpdated == true) goto L6;
            updateStandbyQuotasLocked();     // Catch: Throwable -> L16
            standbyQuotaUpdated = true;
            goto L6
        L14:
            if (name.equals(KEY_DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF) == false) goto L75;
            r7 = ParameterName.DYNAMIC_LUMA_CONTROL;
            goto L77
        L19:
            if (name.equals(KEY_MIN_INTERVAL) == false) goto L75;
            r7 = 1;
            goto L77
        L22:
            if (name.equals(KEY_ALLOW_WHILE_IDLE_COMPAT_QUOTA) == false) goto L75;
            r7 = 5;
            goto L77
        L25:
            if (name.equals(KEY_MAX_INTERVAL) == false) goto L75;
            r7 = 2;
            goto L77
        L28:
            if (name.equals(KEY_TIME_TICK_ALLOWED_WHILE_IDLE) == false) goto L75;
            r7 = 13;
            goto L77
        L31:
            if (name.equals(KEY_ALLOW_WHILE_IDLE_WHITELIST_DURATION) == false) goto L75;
            r7 = 8;
            goto L77
        L34:
            if (name.equals(KEY_LISTENER_TIMEOUT) == false) goto L75;
            r7 = 9;
            goto L77
        L37:
            if (name.equals(KEY_APP_STANDBY_WINDOW) == false) goto L75;
            r7 = 11;
            goto L77
        L40:
            if (name.equals(KEY_MIN_WINDOW) == false) goto L75;
            r7 = 4;
            goto L77
        L43:
            if (name.equals(KEY_MAX_DEVICE_IDLE_FUZZ) == false) goto L75;
            r7 = 16;
            goto L77
        L46:
            if (name.equals(KEY_ALLOW_WHILE_IDLE_WINDOW) == false) goto L75;
            r7 = 6;
            goto L77
        L49:
            if (name.equals(KEY_ALLOW_WHILE_IDLE_QUOTA) == false) goto L75;
            r7 = 3;
            goto L77
        L52:
            if (name.equals(KEY_TEMPORARY_QUOTA_BUMP) == false) goto L75;
            r7 = ParameterName.DE_CONTOUR;
            goto L77
        L55:
            if (name.equals(KEY_PRIORITY_ALARM_DELAY) == false) goto L75;
            r7 = 14;
            goto L77
        L58:
            if (name.equals(KEY_APP_STANDBY_RESTRICTED_WINDOW) == false) goto L75;
            r7 = 12;
            goto L77
        L61:
            if (name.equals(KEY_MAX_ALARMS_PER_UID) == false) goto L75;
            r7 = 10;
            goto L77
        L64:
            if (name.equals(KEY_CACHED_LISTENER_REMOVAL_DELAY) == false) goto L75;
            r7 = ParameterName.FILM_MODE;
            goto L77
        L67:
            if (name.equals(KEY_MIN_FUTURITY) == false) goto L75;
            r7 = 0;
            goto L77
        L70:
            if (name.equals(KEY_MIN_DEVICE_IDLE_FUZZ) == false) goto L75;
            r7 = 15;
            goto L77
        L73:
            if (name.equals(KEY_ALLOW_WHILE_IDLE_COMPAT_WINDOW) == false) goto L75;
            r7 = 7;
            goto L77
        L118:
            monitor-exit(r4);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        private void updateDeviceIdleFuzzBoundaries() {
            DeviceConfig.Properties properties = DeviceConfig.getProperties("alarm_manager", new String[]{KEY_MIN_DEVICE_IDLE_FUZZ, KEY_MAX_DEVICE_IDLE_FUZZ});
            this.MIN_DEVICE_IDLE_FUZZ = properties.getLong(KEY_MIN_DEVICE_IDLE_FUZZ, 120000);
            this.MAX_DEVICE_IDLE_FUZZ = properties.getLong(KEY_MAX_DEVICE_IDLE_FUZZ, 900000);
            if (this.MAX_DEVICE_IDLE_FUZZ >= this.MIN_DEVICE_IDLE_FUZZ) goto L6;
            Slog.w(AlarmManagerService.TAG, "max_device_idle_fuzz cannot be smaller than min_device_idle_fuzz! Increasing to " + this.MIN_DEVICE_IDLE_FUZZ);
            this.MAX_DEVICE_IDLE_FUZZ = this.MIN_DEVICE_IDLE_FUZZ;
            return;
        }

        private void updateStandbyQuotasLocked() {
            DeviceConfig.Properties properties = DeviceConfig.getProperties("alarm_manager", this.KEYS_APP_STANDBY_QUOTAS);
            this.APP_STANDBY_QUOTAS[0] = properties.getInt(this.KEYS_APP_STANDBY_QUOTAS[0], this.DEFAULT_APP_STANDBY_QUOTAS[0]);
            int i = 1;
        L4:
            if (i >= this.KEYS_APP_STANDBY_QUOTAS.length) goto L6;
            this.APP_STANDBY_QUOTAS[i] = properties.getInt(this.KEYS_APP_STANDBY_QUOTAS[i], Math.min(this.APP_STANDBY_QUOTAS[i - 1], this.DEFAULT_APP_STANDBY_QUOTAS[i]));
            i = i + 1;
            goto L4
        L6:
            this.APP_STANDBY_RESTRICTED_QUOTA = Math.max(1, DeviceConfig.getInt("alarm_manager", KEY_APP_STANDBY_RESTRICTED_QUOTA, 1));
        }

        private void updateStandbyWindowsLocked() {
            DeviceConfig.Properties properties = DeviceConfig.getProperties("alarm_manager", new String[]{KEY_APP_STANDBY_WINDOW, KEY_APP_STANDBY_RESTRICTED_WINDOW});
            this.APP_STANDBY_WINDOW = properties.getLong(KEY_APP_STANDBY_WINDOW, 3600000);
            if (this.APP_STANDBY_WINDOW <= 3600000) goto L6;
            Slog.w(AlarmManagerService.TAG, "Cannot exceed the app_standby_window size of 3600000");
            this.APP_STANDBY_WINDOW = 3600000;
        L8:
            this.APP_STANDBY_RESTRICTED_WINDOW = Math.max(this.APP_STANDBY_WINDOW, properties.getLong(KEY_APP_STANDBY_RESTRICTED_WINDOW, 86400000));
            return;
        L6:
            if (this.APP_STANDBY_WINDOW >= 3600000) goto L8;
            Slog.w(AlarmManagerService.TAG, "Using a non-default app_standby_window of " + this.APP_STANDBY_WINDOW);
            goto L8
        }

        void dump(IndentingPrintWriter pw) {
            pw.println("Settings:");
            pw.increaseIndent();
            pw.print("version", Integer.valueOf(this.mVersion));
            pw.println();
            pw.print(KEY_MIN_FUTURITY);
            pw.print("=");
            TimeUtils.formatDuration(this.MIN_FUTURITY, pw);
            pw.println();
            pw.print(KEY_MIN_INTERVAL);
            pw.print("=");
            TimeUtils.formatDuration(this.MIN_INTERVAL, pw);
            pw.println();
            pw.print(KEY_MAX_INTERVAL);
            pw.print("=");
            TimeUtils.formatDuration(this.MAX_INTERVAL, pw);
            pw.println();
            pw.print(KEY_MIN_WINDOW);
            pw.print("=");
            TimeUtils.formatDuration(this.MIN_WINDOW, pw);
            pw.println();
            pw.print(KEY_LISTENER_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.LISTENER_TIMEOUT, pw);
            pw.println();
            pw.print(KEY_ALLOW_WHILE_IDLE_QUOTA, Integer.valueOf(this.ALLOW_WHILE_IDLE_QUOTA));
            pw.println();
            pw.print(KEY_ALLOW_WHILE_IDLE_WINDOW);
            pw.print("=");
            TimeUtils.formatDuration(this.ALLOW_WHILE_IDLE_WINDOW, pw);
            pw.println();
            pw.print(KEY_ALLOW_WHILE_IDLE_COMPAT_QUOTA, Integer.valueOf(this.ALLOW_WHILE_IDLE_COMPAT_QUOTA));
            pw.println();
            pw.print(KEY_ALLOW_WHILE_IDLE_COMPAT_WINDOW);
            pw.print("=");
            TimeUtils.formatDuration(this.ALLOW_WHILE_IDLE_COMPAT_WINDOW, pw);
            pw.println();
            pw.print(KEY_ALLOW_WHILE_IDLE_WHITELIST_DURATION);
            pw.print("=");
            TimeUtils.formatDuration(this.ALLOW_WHILE_IDLE_WHITELIST_DURATION, pw);
            pw.println();
            pw.print(KEY_MAX_ALARMS_PER_UID, Integer.valueOf(this.MAX_ALARMS_PER_UID));
            pw.println();
            pw.print(KEY_APP_STANDBY_WINDOW);
            pw.print("=");
            TimeUtils.formatDuration(this.APP_STANDBY_WINDOW, pw);
            pw.println();
            int i = 0;
        L4:
            if (i >= this.KEYS_APP_STANDBY_QUOTAS.length) goto L6;
            pw.print(this.KEYS_APP_STANDBY_QUOTAS[i], Integer.valueOf(this.APP_STANDBY_QUOTAS[i]));
            pw.println();
            i = i + 1;
            goto L4
        L6:
            int i2 = this.APP_STANDBY_RESTRICTED_QUOTA;
            pw.print(KEY_APP_STANDBY_RESTRICTED_QUOTA, Integer.valueOf(i2));
            pw.println();
            pw.print(KEY_APP_STANDBY_RESTRICTED_WINDOW);
            pw.print("=");
            TimeUtils.formatDuration(this.APP_STANDBY_RESTRICTED_WINDOW, pw);
            pw.println();
            pw.print(KEY_TIME_TICK_ALLOWED_WHILE_IDLE, Boolean.valueOf(this.TIME_TICK_ALLOWED_WHILE_IDLE));
            pw.println();
            pw.print(KEY_PRIORITY_ALARM_DELAY);
            pw.print("=");
            TimeUtils.formatDuration(this.PRIORITY_ALARM_DELAY, pw);
            pw.println();
            pw.print(KEY_MIN_DEVICE_IDLE_FUZZ);
            pw.print("=");
            TimeUtils.formatDuration(this.MIN_DEVICE_IDLE_FUZZ, pw);
            pw.println();
            pw.print(KEY_MAX_DEVICE_IDLE_FUZZ);
            pw.print("=");
            TimeUtils.formatDuration(this.MAX_DEVICE_IDLE_FUZZ, pw);
            pw.println();
            pw.print(KEY_TEMPORARY_QUOTA_BUMP, Integer.valueOf(this.TEMPORARY_QUOTA_BUMP));
            pw.println();
            pw.print(KEY_DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF, Boolean.valueOf(this.DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF));
            pw.println();
            pw.print(KEY_CACHED_LISTENER_REMOVAL_DELAY);
            pw.print("=");
            TimeUtils.formatDuration(this.CACHED_LISTENER_REMOVAL_DELAY, pw);
            pw.println();
            pw.decreaseIndent();
        }

        void dumpProto(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1112396529665L, this.MIN_FUTURITY);
            proto.write(1112396529666L, this.MIN_INTERVAL);
            proto.write(1112396529671L, this.MAX_INTERVAL);
            proto.write(1112396529667L, this.LISTENER_TIMEOUT);
            proto.write(1112396529670L, this.ALLOW_WHILE_IDLE_WHITELIST_DURATION);
            proto.end(token);
        }
    }

    class DeliveryTracker extends IAlarmCompleteListener.Stub implements PendingIntent.OnFinished {
        final /* synthetic */ AlarmManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$62Drd0vqnQmV2BTyiiOtLERwqAU(DeliveryTracker r0, Alarm r1, boolean r2, boolean r3, Alarm r4) {
            return r0.lambda$deliverLocked$1(r1, r2, r3, r4);
        }

        public static /* synthetic */ boolean $r8$lambda$TjsvVoOAEgUSOYZAfIv13a5CFjE(DeliveryTracker r0, Alarm r1, boolean r2, boolean r3, Alarm r4) {
            return r0.lambda$deliverLocked$0(r1, r2, r3, r4);
        }

        DeliveryTracker(AlarmManagerService this$0) {
            this.this$0 = this$0;
        }

        private InFlight removeLocked(PendingIntent pi, Intent intent) {
            int i = 0;
        L4:
            if (i >= this.this$0.mInFlight.size()) goto L13;
            InFlight inflight = this.this$0.mInFlight.get(i);
            if (inflight.mPendingIntent == pi) goto L8;
            i = i + 1;
            goto L4
        L8:
            if (pi.isBroadcast() == false) goto L11;
            AlarmManagerService.m1026$$Nest$mnotifyBroadcastAlarmCompleteLocked(this.this$0, inflight.mUid);
        L11:
            return this.this$0.mInFlight.remove(i);
        L13:
            this.this$0.mLog.w("No in-flight alarm for " + pi + " " + intent);
            return null;
        }

        private InFlight removeLocked(IBinder listener) {
            int i = 0;
        L4:
            if (i >= this.this$0.mInFlight.size()) goto L10;
            if (this.this$0.mInFlight.get(i).mListener == listener) goto L8;
            i = i + 1;
            goto L4
        L8:
            return this.this$0.mInFlight.remove(i);
        L10:
            this.this$0.mLog.w("No in-flight alarm for listener " + listener);
            return null;
        }

        private void updateStatsLocked(InFlight inflight) {
            long nowELAPSED = AlarmManagerService.m995$$Nest$fgetmInjector(this.this$0).getElapsedRealtimeMillis();
            BroadcastStats bs = inflight.mBroadcastStats;
            bs.nesting--;
            if (bs.nesting > 0) goto L5;
            bs.nesting = 0;
            bs.aggregateTime += nowELAPSED - bs.startTime;
        L5:
            FilterStats fs = inflight.mFilterStats;
            fs.nesting--;
            if (fs.nesting > 0) goto L8;
            fs.nesting = 0;
            fs.aggregateTime += nowELAPSED - fs.startTime;
        L8:
            AlarmManagerService.m990$$Nest$fgetmActivityManagerInternal(this.this$0).noteAlarmFinish(inflight.mPendingIntent, inflight.mWorkSource, inflight.mUid, inflight.mTag);
        }

        private void updateTrackingLocked(InFlight inflight) {
            if (inflight == null) goto L4;
            updateStatsLocked(inflight);
        L4:
            this.this$0.mBroadcastRefCount--;
            if (AlarmManagerService.DEBUG_WAKELOCK == false) goto L8;
            Slog.d(AlarmManagerService.TAG, "mBroadcastRefCount -> " + this.this$0.mBroadcastRefCount);
        L8:
            if (this.this$0.mBroadcastRefCount != 0) goto L17;
            this.this$0.mHandler.obtainMessage(4, 0, 0).sendToTarget();
            this.this$0.mWakeLock.release();
            if (this.this$0.mInFlight.size() <= 0) goto L22;
            this.this$0.mLog.w("Finished all dispatches with " + this.this$0.mInFlight.size() + " remaining inflights");
            int i = 0;
        L13:
            if (i >= this.this$0.mInFlight.size()) goto L15;
            this.this$0.mLog.w("  Remaining #" + i + ": " + this.this$0.mInFlight.get(i));
            i = i + 1;
            goto L13
        L15:
            this.this$0.mInFlight.clear();
            return;
        L22:
            return;
        L17:
            if (this.this$0.mInFlight.size() <= 0) goto L19;
            InFlight inFlight = this.this$0.mInFlight.get(0);
            this.this$0.setWakelockWorkSource(inFlight.mWorkSource, inFlight.mCreatorUid, inFlight.mTag, false);
            return;
        L19:
            this.this$0.mLog.w("Alarm wakelock still held but sent queue empty");
            this.this$0.mWakeLock.setWorkSource(null);
        }

        public void alarmComplete(IBinder who) {
            if (who != null) goto L5;
            this.this$0.mLog.w("Invalid alarmComplete: uid=" + Binder.getCallingUid() + " pid=" + Binder.getCallingPid());
            return;
        L5:
            long ident = Binder.clearCallingIdentity();
            Object r2 = this.this$0.mLock;     // Catch: Throwable -> L24
            monitor-enter(r2);     // Catch: Throwable -> L24
            this.this$0.mHandler.removeMessages(3, who);     // Catch: Throwable -> L13
            InFlight inflight = removeLocked(who);     // Catch: Throwable -> L13
            if (inflight == null) goto L17;
            if (AlarmManagerService.DEBUG_LISTENER_CALLBACK == false) goto L15;
            Slog.i(AlarmManagerService.TAG, "alarmComplete() from " + who);     // Catch: Throwable -> L13
        L15:
            updateTrackingLocked(inflight);     // Catch: Throwable -> L13
            AlarmManagerService r4 = this.this$0;     // Catch: Throwable -> L13
            AlarmManagerService.m1013$$Nest$fputmListenerFinishCount(r4, AlarmManagerService.m998$$Nest$fgetmListenerFinishCount(r4) + 1);     // Catch: Throwable -> L13
        L19:
            monitor-exit(r2);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(ident);
            return;
        L17:
            if (AlarmManagerService.DEBUG_LISTENER_CALLBACK == false) goto L19;
            Slog.i(AlarmManagerService.TAG, "Late alarmComplete() from " + who);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        @Override // android.app.PendingIntent.OnFinished
        public void onSendFinished(PendingIntent pi, Intent intent, int resultCode, String resultData, Bundle resultExtras) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            AlarmManagerService r1 = this.this$0;     // Catch: Throwable -> L7
            AlarmManagerService.m1016$$Nest$fputmSendFinishCount(r1, AlarmManagerService.m1004$$Nest$fgetmSendFinishCount(r1) + 1);     // Catch: Throwable -> L7
            updateTrackingLocked(removeLocked(pi, intent));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void alarmTimedOut(IBinder who) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            InFlight inflight = removeLocked(who);     // Catch: Throwable -> L9
            if (inflight == null) goto L13;
            if (AlarmManagerService.DEBUG_LISTENER_CALLBACK == false) goto L11;
            Slog.i(AlarmManagerService.TAG, "Alarm listener " + who + " timed out in delivery");     // Catch: Throwable -> L9
        L11:
            updateTrackingLocked(inflight);     // Catch: Throwable -> L9
            AlarmManagerService r2 = this.this$0;     // Catch: Throwable -> L9
            AlarmManagerService.m1013$$Nest$fputmListenerFinishCount(r2, AlarmManagerService.m998$$Nest$fgetmListenerFinishCount(r2) + 1);     // Catch: Throwable -> L9
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L13:
            if (AlarmManagerService.DEBUG_LISTENER_CALLBACK == false) goto L15;
            Slog.i(AlarmManagerService.TAG, "Spurious timeout of listener " + who);     // Catch: Throwable -> L9
        L15:
            this.this$0.mLog.w("Spurious timeout of listener " + who);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void deliverLocked(final Alarm alarm, long nowELAPSED) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                Method dump skipped, instruction units count: 754
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.server.alarm.AlarmManagerService.DeliveryTracker.deliverLocked(com.android.server.alarm.Alarm, long):void");
        }

        private /* synthetic */ boolean lambda$deliverLocked$0(Alarm alarm, boolean doze, boolean batterySaver, Alarm a) {
            if (a.creatorUid == alarm.creatorUid) goto L5;
        L24:
            return false;
        L5:
            if (AlarmManagerService.m1038$$Nest$smisAllowedWhileIdleRestricted(a) == false) goto L24;
            if (doze == true) goto L10;
        L12:
            boolean dozeAdjusted = false;
        L14:
            if (batterySaver == true) goto L16;
        L18:
            boolean batterySaverAdjusted = false;
        L20:
            if (dozeAdjusted == true) goto L23;
            if (batterySaverAdjusted == true) goto L23;
            return false;
        L23:
            return true;
        L16:
            if (AlarmManagerService.m1017$$Nest$madjustDeliveryTimeBasedOnBatterySaver(this.this$0, a) == false) goto L18;
            batterySaverAdjusted = true;
            goto L20
        L10:
            if (AlarmManagerService.m1018$$Nest$madjustDeliveryTimeBasedOnDeviceIdle(this.this$0, a) == false) goto L12;
            dozeAdjusted = true;
            goto L14
        }

        private /* synthetic */ boolean lambda$deliverLocked$1(Alarm alarm, boolean doze, boolean batterySaver, Alarm a) {
            if (a.creatorUid == alarm.creatorUid) goto L5;
        L24:
            return false;
        L5:
            if ((alarm.flags & 64) == 0) goto L24;
            if (doze == true) goto L10;
        L12:
            boolean dozeAdjusted = false;
        L14:
            if (batterySaver == true) goto L16;
        L18:
            boolean batterySaverAdjusted = false;
        L20:
            if (dozeAdjusted == true) goto L23;
            if (batterySaverAdjusted == true) goto L23;
            return false;
        L23:
            return true;
        L16:
            if (AlarmManagerService.m1017$$Nest$madjustDeliveryTimeBasedOnBatterySaver(this.this$0, a) == false) goto L18;
            batterySaverAdjusted = true;
            goto L20
        L10:
            if (AlarmManagerService.m1018$$Nest$madjustDeliveryTimeBasedOnDeviceIdle(this.this$0, a) == false) goto L12;
            dozeAdjusted = true;
            goto L14
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchPriority {
    }

    static final class FilterStats {
        long aggregateTime;
        int count;
        HeartbeatStats.HeartbeatInfo heartbeatInfo;
        long lastTime;
        final BroadcastStats mBroadcastStats;
        final String mTag;
        int nesting;
        int numWakeup;
        long startTime;
        AlarmRingBuffer triggerHistory;

        FilterStats(BroadcastStats broadcastStats, String tag) {
            this.triggerHistory = AlarmManagerService.sHeartbeatStats.getHistoryBuffer();
            this.mBroadcastStats = broadcastStats;
            this.mTag = tag;
        }

        public String toString() {
            if (HeartbeatStats.sEnabled == false) goto L5;
            StringBuilder sb = new StringBuilder(128);
            sb.append("FilterStats@");
            sb.append(Integer.toHexString(hashCode()));
            sb.append(" {");
            sb.append("count=");
            sb.append(this.count);
            sb.append(", numWakeup=");
            sb.append(this.numWakeup);
            sb.append(", package=");
            sb.append(this.mBroadcastStats.mPackageName);
            sb.append(", ");
            sb.append("tag@filterstats: " + this.mTag);
            sb.append(", heartbeatInfo=");
            sb.append(this.heartbeatInfo);
            sb.append("}");
            return sb.toString();
        L5:
            return "FilterStats{tag=" + this.mTag + ", lastTime=" + this.lastTime + ", aggregateTime=" + this.aggregateTime + ", count=" + this.count + ", numWakeup=" + this.numWakeup + ", startTime=" + this.startTime + ", nesting=" + this.nesting + "}";
        }

        public void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1138166333441L, this.mTag);
            proto.write(1112396529666L, this.lastTime);
            proto.write(1112396529667L, this.aggregateTime);
            proto.write(1120986464260L, this.count);
            proto.write(1120986464261L, this.numWakeup);
            proto.write(1112396529670L, this.startTime);
            proto.write(1120986464263L, this.nesting);
            proto.end(token);
        }
    }

    static final class IdleDispatchEntry {
        long argRealtime;
        long elapsedRealtime;
        String op;
        String pkg;
        String tag;
        int uid;

        IdleDispatchEntry() {
        }
    }

    static final class InFlight {
        final int mAlarmType;
        final BroadcastStats mBroadcastStats;
        final int mCreatorUid;
        final FilterStats mFilterStats;
        final IBinder mListener;
        final PendingIntent mPendingIntent;
        final int mPriorityClass;
        final String mTag;
        final int mUid;
        final long mWhenElapsed;
        final WorkSource mWorkSource;

        InFlight(AlarmManagerService service, Alarm alarm, long nowELAPSED) {
            this.mPendingIntent = alarm.operation;
            this.mWhenElapsed = nowELAPSED;
            if (alarm.listener == null) goto L5;
            IBinder r0 = alarm.listener.asBinder();
        L6:
            this.mListener = r0;
            this.mWorkSource = alarm.workSource;
            this.mUid = alarm.uid;
            this.mCreatorUid = alarm.creatorUid;
            this.mTag = alarm.statsTag;
            if (alarm.operation == null) goto L9;
            BroadcastStats r1 = AlarmManagerService.m1022$$Nest$mgetStatsLocked(service, alarm.operation);
        L10:
            this.mBroadcastStats = r1;
            FilterStats fs = this.mBroadcastStats.filterStats.get(this.mTag);
            if (fs != null) goto L17;
            fs = new FilterStats(this.mBroadcastStats, this.mTag);
            this.mBroadcastStats.filterStats.put(this.mTag, fs);
            if (HeartbeatStats.sEnabled == false) goto L17;
            fs.heartbeatInfo = AlarmManagerService.sHeartbeatStats.getHeartbeatInfo(this.mPendingIntent, Long.MAX_VALUE, 0, alarm.processName);
            if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L17;
            Slog.i(AlarmManagerService.TAG, "create FilterStats fs=" + fs);
        L17:
            fs.lastTime = nowELAPSED;
            this.mFilterStats = fs;
            this.mAlarmType = alarm.type;
            this.mPriorityClass = alarm.priorityClass;
            return;
        L9:
            r1 = AlarmManagerService.m1021$$Nest$mgetStatsLocked(service, alarm.uid, alarm.packageName);
            goto L10
        L5:
            r0 = null;
            goto L6
        }

        boolean isBroadcast() {
            if (this.mPendingIntent != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mPendingIntent.isBroadcast() == false) goto L7;
            return true;
        }

        public String toString() {
            return "InFlight{pendingIntent=" + this.mPendingIntent + ", when=" + this.mWhenElapsed + ", workSource=" + this.mWorkSource + ", uid=" + this.mUid + ", creatorUid=" + this.mCreatorUid + ", tag=" + this.mTag + ", broadcastStats=" + this.mBroadcastStats + ", filterStats=" + this.mFilterStats + ", alarmType=" + this.mAlarmType + ", priorityClass=" + this.mPriorityClass + "}";
        }

        public void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, this.mUid);
            proto.write(1138166333442L, this.mTag);
            proto.write(1112396529667L, this.mWhenElapsed);
            proto.write(1159641169924L, this.mAlarmType);
            if (this.mPendingIntent == null) goto L6;
            this.mPendingIntent.dumpDebug(proto, 1146756268037L);
        L6:
            if (this.mBroadcastStats == null) goto L9;
            this.mBroadcastStats.dumpDebug(proto, 1146756268038L);
        L9:
            if (this.mFilterStats == null) goto L12;
            this.mFilterStats.dumpDebug(proto, 1146756268039L);
        L12:
            if (this.mWorkSource == null) goto L14;
            this.mWorkSource.dumpDebug(proto, 1146756268040L);
        L14:
            proto.end(token);
        }
    }

    static class Injector {
        private Context mContext;
        private long mNativeData;

        Injector(Context context) {
            this.mContext = context;
        }

        void init() {
            System.loadLibrary("alarm_jni");
            this.mNativeData = AlarmManagerService.m1037$$Nest$sminit();
        }

        int waitForAlarm() {
            return AlarmManagerService.m1041$$Nest$smwaitForAlarm(this.mNativeData);
        }

        boolean isAlarmDriverPresent() {
            if (this.mNativeData == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void setAlarm(int type, long millis) {
            if (millis >= 0) goto L5;
            long alarmSeconds = 0;
            long alarmNanoseconds = 0;
        L6:
            int result = AlarmManagerService.m1040$$Nest$smset(this.mNativeData, type, alarmSeconds, alarmNanoseconds);
            if (result == 0) goto L10;
            long nowElapsed = SystemClock.elapsedRealtime();
            Slog.wtf(AlarmManagerService.TAG, "Unable to set kernel alarm, now=" + nowElapsed + " type=" + type + " @ (" + alarmSeconds + "," + alarmNanoseconds + "), ret = " + result + " = " + Os.strerror(result));
            return;
        L10:
            return;
        L5:
            long alarmSeconds2 = millis / 1000;
            alarmNanoseconds = 1000 * ((millis % 1000) * 1000);
            alarmSeconds = alarmSeconds2;
            goto L6
        }

        int getCallingUid() {
            return Binder.getCallingUid();
        }

        long getNextAlarm(int type) {
            return AlarmManagerService.m1035$$Nest$smgetNextAlarm(this.mNativeData, type);
        }

        void initializeTimeIfRequired() {
            SystemClockTime.initializeIfRequired();
        }

        void setCurrentTimeMillis(long unixEpochMillis, int confidence, String logMsg) {
            SystemClockTime.setTimeAndConfidence(unixEpochMillis, confidence, logMsg);
        }

        void close() {
            AlarmManagerService.m1033$$Nest$smclose(this.mNativeData);
        }

        long getElapsedRealtimeMillis() {
            return SystemClock.elapsedRealtime();
        }

        long getCurrentTimeMillis() {
            return System.currentTimeMillis();
        }

        PowerManager.WakeLock getAlarmWakeLock() {
            PowerManager pm = (PowerManager) this.mContext.getSystemService("power");
            return pm.newWakeLock(1, "*alarm*");
        }

        int getSystemUiUid(PackageManagerInternal pm) {
            return pm.getPackageUid(pm.getSystemUiServiceComponent().getPackageName(), DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES, 0);
        }

        IAppOpsService getAppOpsService() {
            return IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));
        }

        ClockReceiver getClockReceiver(AlarmManagerService service) {
            service.getClass();
            return new ClockReceiver(service);
        }

        void registerDeviceConfigListener(DeviceConfig.OnPropertiesChangedListener listener) {
            DeviceConfig.addOnPropertiesChangedListener("alarm_manager", AppSchedulingModuleThread.getExecutor(), listener);
        }
    }

    class InteractiveStateReceiver extends BroadcastReceiver {
        final /* synthetic */ AlarmManagerService this$0;

        public InteractiveStateReceiver(AlarmManagerService this$0) {
            this.this$0 = this$0;
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.SCREEN_OFF");
            filter.addAction("android.intent.action.SCREEN_ON");
            filter.setPriority(1000);
            this$0.getContext().registerReceiver(this, filter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.interactiveStateChangedLocked("android.intent.action.SCREEN_ON".equals(intent.getAction()));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class LocalService implements AlarmManagerInternal {
        final /* synthetic */ AlarmManagerService this$0;

        /* synthetic */ LocalService(AlarmManagerService r1, AlarmManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(AlarmManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.AlarmManagerInternal
        public boolean isIdling() {
            return AlarmManagerService.m1023$$Nest$misIdlingImpl(this.this$0);
        }

        @Override // com.android.server.AlarmManagerInternal
        public void removeAlarmsForUid(int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.removeLocked(uid, 3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.AlarmManagerInternal
        public void remove(PendingIntent pi) {
            this.this$0.mHandler.obtainMessage(7, pi).sendToTarget();
        }

        @Override // com.android.server.AlarmManagerInternal
        public boolean shouldGetBucketElevation(String packageName, int uid) {
            if (this.this$0.hasUseExactAlarmInternal(packageName, uid) == false) goto L5;
        L10:
            return true;
        L5:
            if (CompatChanges.isChangeEnabled(262645982, packageName, UserHandle.getUserHandleForUid(uid)) == false) goto L7;
        L9:
            return false;
        L7:
            if (this.this$0.hasScheduleExactAlarmInternal(packageName, uid) == false) goto L9;
            goto L9
        }

        @Override // com.android.server.AlarmManagerInternal
        public void setTimeZone(String tzId, int confidence, String logInfo) {
            this.this$0.setTimeZoneImpl(tzId, confidence, logInfo);
        }

        @Override // com.android.server.AlarmManagerInternal
        public void setTime(long unixEpochTimeMillis, int confidence, String logMsg) {
            this.this$0.setTimeImpl(unixEpochTimeMillis, confidence, logMsg);
        }

        @Override // com.android.server.AlarmManagerInternal
        public void registerInFlightListener(AlarmManagerInternal.InFlightListener callback) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            AlarmManagerService.m994$$Nest$fgetmInFlightListeners(this.this$0).add(callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.AlarmManagerInternal
        public long getNextAlarmTriggerTimeForUser(int userId) {
            AlarmManager.AlarmClockInfo nextAlarm = this.this$0.getNextAlarmClockImpl(userId);
            if (nextAlarm != null) goto L7;
            return 0;
        L7:
            return nextAlarm.getTriggerTime();
        }
    }

    static class RemovedAlarm {
        static final int REMOVE_REASON_ALARM_CANCELLED = 1;
        static final int REMOVE_REASON_DATA_CLEARED = 3;
        static final int REMOVE_REASON_EXACT_PERMISSION_REVOKED = 2;
        static final int REMOVE_REASON_LISTENER_BINDER_DIED = 5;
        static final int REMOVE_REASON_LISTENER_CACHED = 6;
        static final int REMOVE_REASON_PI_CANCELLED = 4;
        static final int REMOVE_REASON_UNDEFINED = 0;
        final Alarm.Snapshot mAlarmSnapshot;
        final int mRemoveReason;
        final long mWhenRemovedElapsed;
        final long mWhenRemovedRtc;

        RemovedAlarm(Alarm a, int removeReason, long nowRtc, long nowElapsed) {
            this.mAlarmSnapshot = new Alarm.Snapshot(a);
            this.mRemoveReason = removeReason;
            this.mWhenRemovedRtc = nowRtc;
            this.mWhenRemovedElapsed = nowElapsed;
        }

        static final boolean isLoggable(int reason) {
            if (reason == 0) goto L4;
            return true;
        L4:
            return false;
        }

        static final String removeReasonToString(int reason) {
            switch(reason) {
                case 1: goto L15;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L9;
                case 5: goto L7;
                case 6: goto L5;
                default: goto L4;
            };
        L5:
            return "listener_cached";
        L7:
            return "listener_binder_died";
        L9:
            return "pi_cancelled";
        L11:
            return "data_cleared";
        L13:
            return "exact_alarm_permission_revoked";
        L15:
            return "alarm_cancelled";
        L4:
            return "unknown:" + reason;
        }

        void dump(IndentingPrintWriter pw, long nowElapsed, SimpleDateFormat sdf) {
            pw.increaseIndent();
            pw.print("Reason", removeReasonToString(this.mRemoveReason));
            pw.print("elapsed=");
            TimeUtils.formatDuration(this.mWhenRemovedElapsed, nowElapsed, pw);
            pw.print(" rtc=");
            pw.print(sdf.format(new Date(this.mWhenRemovedRtc)));
            pw.println();
            pw.println("Snapshot:");
            pw.increaseIndent();
            this.mAlarmSnapshot.dump(pw, nowElapsed);
            pw.decreaseIndent();
            pw.decreaseIndent();
        }
    }

    private class ShellCmd extends ShellCommand {
        final /* synthetic */ AlarmManagerService this$0;

        /* synthetic */ ShellCmd(AlarmManagerService r1, AlarmManagerServiceIA r2) {
            this(r1);
        }

        private ShellCmd(AlarmManagerService r1) {
            this.this$0 = r1;
        }

        IAlarmManager getBinderService() {
            return IAlarmManager.Stub.asInterface(AlarmManagerService.m1005$$Nest$fgetmService(this.this$0));
        }

        public int onCommand(String cmd) {
            if (cmd == null) goto L4;
            PrintWriter pw = getOutPrintWriter();
        L12:
            e = move-exception;
            pw.println(e);
            return -1;
        L7:
            switch(cmd.hashCode()) {
                case -2120488796: goto L18;
                case 1369384280: goto L15;
                case 2023087364: goto L10;
                default: goto L20;
            };     // Catch: Exception -> L12
        L20:
            byte r2 = -1;
        L21:
            switch(r2) {
                case 0: goto L28;
                case 1: goto L26;
                case 2: goto L24;
                default: goto L23;
            };     // Catch: Exception -> L12
        L24:
            int version = getBinderService().getConfigVersion();     // Catch: Exception -> L12
            pw.println(version);     // Catch: Exception -> L12
            return 0;
        L26:
            String tz = getNextArgRequired();     // Catch: Exception -> L12
            getBinderService().setTimeZone(tz);     // Catch: Exception -> L12
            return 0;
        L28:
            String tz2 = getNextArgRequired();     // Catch: Exception -> L12
            long millis = Long.parseLong(tz2);     // Catch: Exception -> L12
            if (getBinderService().setTime(millis) == true) goto L31;
            return -1;
        L31:
            return 0;
        L23:
            return handleDefaultCommands(cmd);
        L10:
            if (cmd.equals("set-timezone") == false) goto L20;
            r2 = 1;
            goto L21
        L15:
            if (cmd.equals("set-time") == false) goto L20;
            r2 = 0;
            goto L21
        L18:
            if (cmd.equals("get-config-version") == false) goto L20;
            r2 = 2;
            goto L21
        L4:
            return handleDefaultCommands(cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("Alarm manager service (alarm) commands:");
            pw.println("  help");
            pw.println("    Print this help text.");
            pw.println("  set-time TIME");
            pw.println("    Set the system clock time to TIME where TIME is milliseconds");
            pw.println("    since the Epoch.");
            pw.println("  set-timezone TZ");
            pw.println("    Set the system timezone to TZ where TZ is an Olson id.");
            pw.println("  get-config-version");
            pw.println("    Returns an integer denoting the version of device_config keys the service is sync'ed to. As long as this returns the same version, the values of the config are guaranteed to remain the same.");
        }
    }

    interface Stats {
        public static final int HAS_SCHEDULE_EXACT_ALARM = 1;
        public static final int REORDER_ALARMS_FOR_STANDBY = 0;
    }

    static class TemporaryQuotaReserve {
        private long mMaxDuration;
        private final ArrayMap<UserPackage, QuotaInfo> mQuotaBuffer;

        private static class QuotaInfo {
            public long expirationTime;
            public long lastUsage;
            public int remainingQuota;

            /* synthetic */ QuotaInfo(AlarmManagerServiceIA r1) {
                this();
            }

            private QuotaInfo() {
            }
        }

        TemporaryQuotaReserve(long maxDuration) {
            this.mQuotaBuffer = new ArrayMap();
            this.mMaxDuration = maxDuration;
        }

        void replenishQuota(String packageName, int userId, int quota, long nowElapsed) {
            if (quota > 0) goto L4;
            return;
        L4:
            UserPackage userPackage = UserPackage.of(userId, packageName);
            QuotaInfo currentQuotaInfo = this.mQuotaBuffer.get(userPackage);
            if (currentQuotaInfo != null) goto L7;
            currentQuotaInfo = new QuotaInfo(null);
            this.mQuotaBuffer.put(userPackage, currentQuotaInfo);
        L7:
            currentQuotaInfo.remainingQuota = quota;
            currentQuotaInfo.expirationTime = this.mMaxDuration + nowElapsed;
        }

        boolean hasQuota(String packageName, int userId, long triggerElapsed) {
            UserPackage userPackage = UserPackage.of(userId, packageName);
            QuotaInfo quotaInfo = this.mQuotaBuffer.get(userPackage);
            if (quotaInfo != null) goto L5;
        L9:
            return false;
        L5:
            if (quotaInfo.remainingQuota <= 0) goto L9;
            if (triggerElapsed > quotaInfo.expirationTime) goto L9;
            return true;
        }

        void recordUsage(String packageName, int userId, long nowElapsed) {
            UserPackage userPackage = UserPackage.of(userId, packageName);
            QuotaInfo quotaInfo = this.mQuotaBuffer.get(userPackage);
            if (quotaInfo != null) goto L7;
            Slog.wtf(AlarmManagerService.TAG, "Temporary quota being consumed at " + nowElapsed + " but not found for package: " + packageName + ", user: " + userId);
            return;
        L7:
            if (nowElapsed > quotaInfo.lastUsage) goto L9;
            return;
        L9:
            if (quotaInfo.remainingQuota > 0) goto L12;
            Slog.wtf(AlarmManagerService.TAG, "Temporary quota being consumed at " + nowElapsed + " but remaining only " + quotaInfo.remainingQuota + " for package: " + packageName + ", user: " + userId);
        L15:
            quotaInfo.lastUsage = nowElapsed;
            return;
        L12:
            if (quotaInfo.expirationTime >= nowElapsed) goto L14;
            Slog.wtf(AlarmManagerService.TAG, "Temporary quota being consumed at " + nowElapsed + " but expired at " + quotaInfo.expirationTime + " for package: " + packageName + ", user: " + userId);
            goto L15
        L14:
            quotaInfo.remainingQuota--;
            goto L15
        }

        void cleanUpExpiredQuotas(long nowElapsed) {
            int i = this.mQuotaBuffer.size() - 1;
        L3:
            if (i < 0) goto L9;
            QuotaInfo quotaInfo = this.mQuotaBuffer.valueAt(i);
            if (quotaInfo.expirationTime >= nowElapsed) goto L7;
            this.mQuotaBuffer.removeAt(i);
        L7:
            i = i - 1;
            goto L3
        }

        void removeForUser(int userId) {
            int i = this.mQuotaBuffer.size() - 1;
        L3:
            if (i < 0) goto L9;
            UserPackage userPackageKey = this.mQuotaBuffer.keyAt(i);
            if (userPackageKey.userId != userId) goto L7;
            this.mQuotaBuffer.removeAt(i);
        L7:
            i = i - 1;
            goto L3
        }

        void removeForPackage(String packageName, int userId) {
            UserPackage userPackage = UserPackage.of(userId, packageName);
            this.mQuotaBuffer.remove(userPackage);
        }

        void dump(IndentingPrintWriter pw, long nowElapsed) {
            pw.increaseIndent();
            int i = 0;
        L4:
            if (i >= this.mQuotaBuffer.size()) goto L10;
            UserPackage userPackage = this.mQuotaBuffer.keyAt(i);
            QuotaInfo quotaInfo = this.mQuotaBuffer.valueAt(i);
            pw.print(userPackage.packageName);
            pw.print(", u");
            pw.print(userPackage.userId);
            pw.print(": ");
            if (quotaInfo != null) goto L8;
            pw.print("--");
        L9:
            pw.println();
            i = i + 1;
            goto L4
        L8:
            pw.print("quota: ");
            pw.print(quotaInfo.remainingQuota);
            pw.print(", expiration: ");
            TimeUtils.formatDuration(quotaInfo.expirationTime, nowElapsed, pw);
            pw.print(" last used: ");
            TimeUtils.formatDuration(quotaInfo.lastUsage, nowElapsed, pw);
            goto L9
        L10:
            pw.decreaseIndent();
        }
    }

    class UninstallReceiver extends BroadcastReceiver {
        final /* synthetic */ AlarmManagerService this$0;

        public UninstallReceiver(AlarmManagerService this$0) {
            this.this$0 = this$0;
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.PACKAGE_REMOVED");
            filter.addAction("android.intent.action.PACKAGE_ADDED");
            filter.addAction("android.intent.action.PACKAGE_RESTARTED");
            filter.addAction("android.intent.action.QUERY_PACKAGE_RESTART");
            filter.addDataScheme(Settings.ATTR_PACKAGE);
            this$0.getContext().registerReceiverForAllUsers(this, filter, null, null);
            IntentFilter sdFilter = new IntentFilter();
            sdFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
            sdFilter.addAction("android.intent.action.USER_STOPPED");
            if (AlarmManagerService.m1006$$Nest$fgetmStartUserBeforeScheduledAlarms(this$0) == false) goto L5;
            sdFilter.addAction("android.intent.action.USER_REMOVED");
        L5:
            sdFilter.addAction("android.intent.action.UID_REMOVED");
            this$0.getContext().registerReceiverForAllUsers(this, sdFilter, null, null);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) goto L5;
            return;
        L5:
            int uid = intent.getIntExtra("android.intent.extra.UID", -1);
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            String[] pkgList = null;
            int r7 = 0;
            switch(action.hashCode()) {
                case -2061058799: goto L35;
                case -1749672628: goto L32;
                case -1403934493: goto L29;
                case -1072806502: goto L26;
                case -757780528: goto L23;
                case -742246786: goto L20;
                case 525384130: goto L17;
                case 1544582882: goto L12;
                default: goto L37;
            };     // Catch: Throwable -> L14
        L37:
            byte r5 = -1;
        L39:
            switch(r5) {
                case 0: goto L98;
                case 1: goto L93;
                case 2: goto L86;
                case 3: goto L83;
                case 4: goto L78;
                case 5: goto L51;
                case 6: goto L42;
                case 7: goto L46;
                default: goto L52;
            };     // Catch: Throwable -> L14
        L46:
            Uri data = intent.getData();     // Catch: Throwable -> L14
            if (data == null) goto L52;
            String pkg = data.getSchemeSpecificPart();     // Catch: Throwable -> L14
            if (pkg == null) goto L52;
            pkgList = new String[]{pkg};     // Catch: Throwable -> L14
            goto L52
        L51:
            pkgList = intent.getStringArrayExtra("android.intent.extra.changed_package_list");     // Catch: Throwable -> L14
            goto L52
        L78:
            this.this$0.mHandler.sendEmptyMessage(11);     // Catch: Throwable -> L14
            if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L81;
            String packageUpdated = intent.getData().getSchemeSpecificPart();     // Catch: Throwable -> L14
            this.this$0.mHandler.obtainMessage(13, uid, -1, packageUpdated).sendToTarget();     // Catch: Throwable -> L14
        L81:
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L83:
            AlarmManagerService.m996$$Nest$fgetmLastPriorityAlarmDispatch(this.this$0).delete(uid);     // Catch: Throwable -> L14
            AlarmManagerService.m1002$$Nest$fgetmRemovalHistory(this.this$0).delete(uid);     // Catch: Throwable -> L14
            this.this$0.mLastOpScheduleExactAlarm.delete(uid);     // Catch: Throwable -> L14
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L86:
            int user = intent.getIntExtra("android.intent.extra.user_handle", -1);     // Catch: Throwable -> L14
            if (user >= 0) goto L89;
        L91:
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L89:
            if (AlarmManagerService.m1006$$Nest$fgetmStartUserBeforeScheduledAlarms(this.this$0) == false) goto L91;
            this.this$0.mUserWakeupStore.onUserRemoved(user);     // Catch: Throwable -> L14
            goto L91
        L93:
            int userHandle = intent.getIntExtra("android.intent.extra.user_handle", -1);     // Catch: Throwable -> L14
            if (userHandle < 0) goto L96;
            this.this$0.removeUserLocked(userHandle);     // Catch: Throwable -> L14
            this.this$0.mAppWakeupHistory.removeForUser(userHandle);     // Catch: Throwable -> L14
            this.this$0.mAllowWhileIdleHistory.removeForUser(userHandle);     // Catch: Throwable -> L14
            this.this$0.mAllowWhileIdleCompatHistory.removeForUser(userHandle);     // Catch: Throwable -> L14
            this.this$0.mTemporaryQuotaReserve.removeForUser(userHandle);     // Catch: Throwable -> L14
        L96:
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L98:
            String[] pkgList2 = intent.getStringArrayExtra("android.intent.extra.PACKAGES");     // Catch: Throwable -> L14
            int r4 = pkgList2.length;     // Catch: Throwable -> L14
        L99:
            if (r7 >= r4) goto L106;
            String packageName = pkgList2[r7];     // Catch: Throwable -> L14
            if (this.this$0.lookForPackageLocked(packageName, uid) == true) goto L102;
            r7 = r7 + 1;     // Catch: Throwable -> L14
            goto L99
        L102:
            setResultCode(-1);     // Catch: Throwable -> L14
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L106:
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L52:
            if (pkgList != null) goto L54;
        L76:
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L54:
            if (pkgList.length <= 0) goto L76;
            int r2 = pkgList.length;     // Catch: Throwable -> L14
            int r6 = 0;
        L56:
            if (r6 >= r2) goto L76;
            String pkg2 = pkgList[r6];     // Catch: Throwable -> L14
            if (HeartbeatStats.sEnabled == true) goto L60;
        L64:
            if (uid < 0) goto L66;
            this.this$0.mAppWakeupHistory.removeForPackage(pkg2, UserHandle.getUserId(uid));     // Catch: Throwable -> L14
            this.this$0.mAllowWhileIdleHistory.removeForPackage(pkg2, UserHandle.getUserId(uid));     // Catch: Throwable -> L14
            this.this$0.mAllowWhileIdleCompatHistory.removeForPackage(pkg2, UserHandle.getUserId(uid));     // Catch: Throwable -> L14
            this.this$0.mTemporaryQuotaReserve.removeForPackage(pkg2, UserHandle.getUserId(uid));     // Catch: Throwable -> L14
            this.this$0.removeLocked(uid, 0);     // Catch: Throwable -> L14
        L67:
            int i = this.this$0.mBroadcastStats.size() - 1;     // Catch: Throwable -> L14
        L68:
            if (i < 0) goto L75;
            ArrayMap<String, BroadcastStats> uidStats = this.this$0.mBroadcastStats.valueAt(i);     // Catch: Throwable -> L14
            if (uidStats.remove(pkg2) == null) goto L74;
            if (uidStats.size() > 0) goto L74;
            this.this$0.mBroadcastStats.removeAt(i);     // Catch: Throwable -> L14
        L74:
            i = i - 1;     // Catch: Throwable -> L14
        L75:
            r6 = r6 + 1;     // Catch: Throwable -> L14
            goto L56
        L66:
            this.this$0.removeLocked(pkg2, 0);     // Catch: Throwable -> L14
            goto L67
        L60:
            if (pkg2.equals("com.obric.clock") == true) goto L75;
            if ("com.obric.calendar".equals(pkg2) == false) goto L64;
        L42:
            if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L45;
            monitor-exit(r3);     // Catch: Throwable -> L14
            return;
        L45:
            this.this$0.mHandler.sendEmptyMessage(11);     // Catch: Throwable -> L14
            goto L46
        L12:
            if (action.equals("android.intent.action.PACKAGE_ADDED") == false) goto L37;
            r5 = 4;
            goto L39
        L17:
            if (action.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L37;
            r5 = 6;
            goto L39
        L20:
            if (action.equals("android.intent.action.USER_STOPPED") == false) goto L37;
            r5 = 1;
            goto L39
        L23:
            if (action.equals("android.intent.action.PACKAGE_RESTARTED") == false) goto L37;
            r5 = 7;
            goto L39
        L26:
            if (action.equals("android.intent.action.QUERY_PACKAGE_RESTART") == false) goto L37;
            r5 = 0;
            goto L39
        L29:
            if (action.equals("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE") == false) goto L37;
            r5 = 5;
            goto L39
        L32:
            if (action.equals("android.intent.action.UID_REMOVED") == false) goto L37;
            r5 = 3;
            goto L39
        L35:
            if (action.equals("android.intent.action.USER_REMOVED") == false) goto L37;
            r5 = 2;
        L14:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3cblH7eOf-8k0i2H4hIA4DAIYbY, reason: not valid java name */
    public static /* synthetic */ void m983$r8$lambda$3cblH7eOf8k0i2H4hIA4DAIYbY(AlarmManagerService r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ boolean $r8$lambda$4MqVZI7HBDXu54WD0FdtTwqz0Us(int r0, Alarm r1) {
        return lambda$removeUserLocked$21(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$4a0NpUe_TWy4a-I7d_33FEMZDUg, reason: not valid java name */
    public static /* synthetic */ boolean m984$r8$lambda$4a0NpUe_TWy4aI7d_33FEMZDUg(int r0, String r1, Alarm r2) {
        return lambda$removeExactAlarmsOnPermissionRevoked$14(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$9HsTaZG8vsF2IxRyd624VLZWTxg(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$setImplLocked$13(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ADG0EAACpycMPBOZGFyKeH7UxXU(int r0, Alarm r1) {
        return lambda$removeLocked$18(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$B32hwN2JtHp6zdRj8F-Y-tZUgHg, reason: not valid java name */
    public static /* synthetic */ void m985$r8$lambda$B32hwN2JtHp6zdRj8FYtZUgHg(AlarmManagerService r0, int[] r1, int[] r2) {
        r0.lambda$onStart$7(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$Ct09kLSBsw8yFCFj8quDlIWNG7k(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$reevaluateRtcAlarms$3(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$FGaKilfo5wHxIMcbDNdy1Ruhrpg(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$removeAlarmsInternalLocked$15(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Hj6QBLqdMP1eOs_vGNpRNut-_0I, reason: not valid java name */
    public static /* synthetic */ boolean m986$r8$lambda$Hj6QBLqdMP1eOs_vGNpRNut_0I(int[] r0, Alarm r1) {
        return lambda$removeExactListenerAlarms$8(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$L82siL18ro7TYb8gZPPKO1HL33E(AlarmManagerService r0, Alarm r1, Alarm r2) {
        return r0.lambda$new$1(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$MERpfNaCHJyDKltYJNz7MGK6mHg(AlarmManagerService r0, Alarm r1) {
        return r0.isBackgroundRestricted(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$MMGy4PPWHU9upUPIWm_pgcigTak(AlarmManagerService r0, ArraySet r1, Alarm r2) {
        return r0.lambda$reorderAlarmsBasedOnPowerSaver$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$NONeIDpzLn33z8YSpt_ZH6KzF3M(AlarmManagerService r0) {
        r0.lambda$interactiveStateChangedLocked$22();
    }

    public static /* synthetic */ boolean $r8$lambda$PWZJeVAGbJJbJ2jrjucyiyPbD7Y(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$setImplLocked$12(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$QgyF8PZON2kLE4tEaY61PTMen4Q(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$reevaluateRtcAlarms$4(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$RcgEA8fH6mSsM9WlE_PiJ_wAvOE(String r0, Alarm r1) {
        return lambda$removeLocked$19(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$RvL9bTJyGSHvBZTajQfzJEAwelM(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$triggerAlarmsLocked$23(r1);
    }

    public static /* synthetic */ AlarmStore $r8$lambda$WHyfHE4o9i9LnS0B3Rt1WPzBwm4(AlarmManagerService r0) {
        return r0.lambda$onBootPhase$10();
    }

    /* JADX INFO: renamed from: $r8$lambda$bN-p56GdkwdB3Yk6RnyjKfw-OZA, reason: not valid java name */
    public static /* synthetic */ boolean m987$r8$lambda$bNp56GdkwdB3Yk6RnyjKfwOZA(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$setImplLocked$11(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$dijK_WYi4Ako51YxjxZm9RMoyV8(AlarmManagerService r0, int r1, Alarm r2) {
        return r0.lambda$removeForStoppedLocked$20(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$gTBrLqI8lRe-eLGhoAoKns8vULU, reason: not valid java name */
    public static /* synthetic */ boolean m988$r8$lambda$gTBrLqI8lReeLGhoAoKns8vULU(AlarmManagerService r0, ArraySet r1, Alarm r2) {
        return r0.lambda$reorderAlarmsBasedOnStandbyBuckets$5(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$lO7FlqYCXbhzV969DpFL5GaI-Ko, reason: not valid java name */
    public static /* synthetic */ boolean m989$r8$lambda$lO7FlqYCXbhzV969DpFL5GaIKo(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$reevaluateRtcAlarms$2(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$r5YY5ooCDOp8NnOkL1xTRiEoXms(AlarmManagerService r0, Alarm r1) {
        return r0.lambda$removeAlarmsInternalLocked$16(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$tqdFahJPkNbOEr_3mNLrRNcYMTM(PendingIntent r0, IAlarmListener r1, Alarm r2) {
        return lambda$removeLocked$17(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$vLGDcJNlfRGnIXusBZTh1mkq4s0(AlarmManagerService r0, int r1) {
        r0.lambda$onUserStarting$9(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m990$$Nest$fgetmActivityManagerInternal(AlarmManagerService r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppStateTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppStateTrackerImpl m991$$Nest$fgetmAppStateTracker(AlarmManagerService r0) {
        return r0.mAppStateTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackgroundIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m992$$Nest$fgetmBackgroundIntent(AlarmManagerService r0) {
        return r0.mBackgroundIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryStatsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryStatsInternal m993$$Nest$fgetmBatteryStatsInternal(AlarmManagerService r0) {
        return r0.mBatteryStatsInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInFlightListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m994$$Nest$fgetmInFlightListeners(AlarmManagerService r0) {
        return r0.mInFlightListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m995$$Nest$fgetmInjector(AlarmManagerService r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastPriorityAlarmDispatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseLongArray m996$$Nest$fgetmLastPriorityAlarmDispatch(AlarmManagerService r0) {
        return r0.mLastPriorityAlarmDispatch;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListenerCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m997$$Nest$fgetmListenerCount(AlarmManagerService r0) {
        return r0.mListenerCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListenerFinishCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m998$$Nest$fgetmListenerFinishCount(AlarmManagerService r0) {
        return r0.mListenerFinishCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextTickHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m999$$Nest$fgetmNextTickHistory(AlarmManagerService r0) {
        return r0.mNextTickHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextWakeup, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1000$$Nest$fgetmNextWakeup(AlarmManagerService r2) {
        return r2.mNextWakeup;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m1001$$Nest$fgetmPackageManagerInternal(AlarmManagerService r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemovalHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m1002$$Nest$fgetmRemovalHistory(AlarmManagerService r0) {
        return r0.mRemovalHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSendCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1003$$Nest$fgetmSendCount(AlarmManagerService r0) {
        return r0.mSendCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSendFinishCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1004$$Nest$fgetmSendFinishCount(AlarmManagerService r0) {
        return r0.mSendFinishCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m1005$$Nest$fgetmService(AlarmManagerService r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStartUserBeforeScheduledAlarms, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1006$$Nest$fgetmStartUserBeforeScheduledAlarms(AlarmManagerService r0) {
        return r0.mStartUserBeforeScheduledAlarms;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTickHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ long[] m1007$$Nest$fgetmTickHistory(AlarmManagerService r0) {
        return r0.mTickHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastTickReceived, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1008$$Nest$fputmLastTickReceived(AlarmManagerService r0, long r1) {
        r0.mLastTickReceived = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastTickSet, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1009$$Nest$fputmLastTickSet(AlarmManagerService r0, long r1) {
        r0.mLastTickSet = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastTrigger, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1010$$Nest$fputmLastTrigger(AlarmManagerService r0, long r1) {
        r0.mLastTrigger = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastWakeup, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1011$$Nest$fputmLastWakeup(AlarmManagerService r0, long r1) {
        r0.mLastWakeup = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmListenerCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1012$$Nest$fputmListenerCount(AlarmManagerService r0, int r1) {
        r0.mListenerCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmListenerFinishCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1013$$Nest$fputmListenerFinishCount(AlarmManagerService r0, int r1) {
        r0.mListenerFinishCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNextTickHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1014$$Nest$fputmNextTickHistory(AlarmManagerService r0, int r1) {
        r0.mNextTickHistory = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSendCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1015$$Nest$fputmSendCount(AlarmManagerService r0, int r1) {
        r0.mSendCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSendFinishCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1016$$Nest$fputmSendFinishCount(AlarmManagerService r0, int r1) {
        r0.mSendFinishCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$madjustDeliveryTimeBasedOnBatterySaver, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1017$$Nest$madjustDeliveryTimeBasedOnBatterySaver(AlarmManagerService r0, Alarm r1) {
        return r0.adjustDeliveryTimeBasedOnBatterySaver(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$madjustDeliveryTimeBasedOnDeviceIdle, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1018$$Nest$madjustDeliveryTimeBasedOnDeviceIdle(AlarmManagerService r0, Alarm r1) {
        return r0.adjustDeliveryTimeBasedOnDeviceIdle(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdecrementAlarmCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1019$$Nest$mdecrementAlarmCount(AlarmManagerService r0, int r1, int r2) {
        r0.decrementAlarmCount(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAlarmOperationBundle, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m1020$$Nest$mgetAlarmOperationBundle(AlarmManagerService r0, Alarm r1) {
        return r0.getAlarmOperationBundle(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStatsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ BroadcastStats m1021$$Nest$mgetStatsLocked(AlarmManagerService r0, int r1, String r2) {
        return r0.getStatsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStatsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ BroadcastStats m1022$$Nest$mgetStatsLocked(AlarmManagerService r0, PendingIntent r1) {
        return r0.getStatsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misIdlingImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1023$$Nest$misIdlingImpl(AlarmManagerService r0) {
        return r0.isIdlingImpl();
    }

    /* JADX INFO: renamed from: -$$Nest$misScheduleExactAlarmDeniedByDefault, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1024$$Nest$misScheduleExactAlarmDeniedByDefault(AlarmManagerService r0, String r1, int r2) {
        return r0.isScheduleExactAlarmDeniedByDefault(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogAlarmBatchDelivered, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1025$$Nest$mlogAlarmBatchDelivered(AlarmManagerService r0, int r1, int r2, SparseIntArray r3, SparseIntArray r4) {
        r0.logAlarmBatchDelivered(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyBroadcastAlarmCompleteLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1026$$Nest$mnotifyBroadcastAlarmCompleteLocked(AlarmManagerService r0, int r1) {
        r0.notifyBroadcastAlarmCompleteLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyBroadcastAlarmPendingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1027$$Nest$mnotifyBroadcastAlarmPendingLocked(AlarmManagerService r0, int r1) {
        r0.notifyBroadcastAlarmPendingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAlarmsInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1028$$Nest$mremoveAlarmsInternalLocked(AlarmManagerService r0, Predicate r1, int r2) {
        r0.removeAlarmsInternalLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveExactListenerAlarms, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1029$$Nest$mremoveExactListenerAlarms(AlarmManagerService r0, int[] r1) {
        r0.removeExactListenerAlarms(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendNextAlarmClockChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1030$$Nest$msendNextAlarmClockChanged(AlarmManagerService r0) {
        r0.sendNextAlarmClockChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$msendScheduleExactAlarmPermissionStateChangedBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1031$$Nest$msendScheduleExactAlarmPermissionStateChangedBroadcast(AlarmManagerService r0, String r1, int r2) {
        r0.sendScheduleExactAlarmPermissionStateChangedBroadcast(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNextAlarmClockLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1032$$Nest$mupdateNextAlarmClockLocked(AlarmManagerService r0) {
        r0.updateNextAlarmClockLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$smclose, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1033$$Nest$smclose(long r0) {
        close(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetAlarmAttributionUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1034$$Nest$smgetAlarmAttributionUid(Alarm r0) {
        return getAlarmAttributionUid(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetNextAlarm, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1035$$Nest$smgetNextAlarm(long r0, int r2) {
        return getNextAlarm(r0, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smincrement, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1036$$Nest$smincrement(SparseIntArray r0, int r1) {
        increment(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sminit, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1037$$Nest$sminit() {
        return init();
    }

    /* JADX INFO: renamed from: -$$Nest$smisAllowedWhileIdleRestricted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1038$$Nest$smisAllowedWhileIdleRestricted(Alarm r0) {
        return isAllowedWhileIdleRestricted(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisExactAlarmChangeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1039$$Nest$smisExactAlarmChangeEnabled(String r0, int r1) {
        return isExactAlarmChangeEnabled(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smset, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1040$$Nest$smset(long r0, int r2, long r3, long r5) {
        return set(r0, r2, r3, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$smwaitForAlarm, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1041$$Nest$smwaitForAlarm(long r0) {
        return waitForAlarm(r0);
    }

    private static native void close(long r0);

    private static native long getNextAlarm(long r0, int r2);

    private static native long init();

    private static native int set(long r0, int r2, long r3, long r5);

    private static native int waitForAlarm(long r0);

    static {
        boolean r1 = false;
        localLOGV = SystemProperties.getBoolean("persist.alarm.debug", false);
        if (localLOGV == true) goto L5;
        boolean r0 = false;
    L6:
        DEBUG_BATCH = r0;
        if (localLOGV == true) goto L9;
        boolean r2 = false;
    L10:
        DEBUG_ALARM_CLOCK = r2;
        if (localLOGV == true) goto L13;
        boolean r3 = false;
    L14:
        DEBUG_LISTENER_CALLBACK = r3;
        if (localLOGV == true) goto L17;
        boolean r4 = false;
    L18:
        DEBUG_WAKELOCK = r4;
        if (localLOGV == true) goto L21;
        boolean r5 = false;
    L22:
        DEBUG_BG_LIMIT = r5;
        if (localLOGV == false) goto L26;
        r1 = true;
    L26:
        DEBUG_STANDBY = r1;
        NEXT_ALARM_CLOCK_CHANGED_INTENT = new Intent("android.app.action.NEXT_ALARM_CLOCK_CHANGED").addFlags(AudioFormat.APTX_HD);
        sHeartbeatStats = new HeartbeatStats();
        return;
    L21:
        r5 = true;
        goto L22
    L17:
        r4 = true;
        goto L18
    L13:
        r3 = true;
        goto L14
    L9:
        r2 = true;
        goto L10
    L5:
        r0 = true;
        goto L6
    }

    private static boolean isTimeTickAlarm(Alarm a) {
        if (a.uid == 1000) goto L5;
    L7:
        return false;
    L5:
        if (TIME_TICK_TAG.equals(a.listenerTag) == false) goto L7;
        return true;
    }

    private static BroadcastOptions makeBasicAlarmBroadcastOptions() {
        BroadcastOptions b = BroadcastOptions.makeBasic();
        b.setAlarmBroadcast(true);
        return b;
    }

    private /* synthetic */ void lambda$new$0() {
        this.mNextAlarmClockMayChange = true;
    }

    private /* synthetic */ int lambda$new$1(Alarm lhs, Alarm rhs) {
        if ((lhs.flags & 16) == 0) goto L5;
        boolean idleUntil1 = true;
    L7:
        if ((rhs.flags & 16) == 0) goto L9;
        boolean idleUntil2 = true;
    L11:
        if (idleUntil1 == idleUntil2) goto L16;
        if (idleUntil1 == true) goto L14;
        return 1;
    L14:
        return -1;
    L16:
        if (lhs.priorityClass >= rhs.priorityClass) goto L19;
        return -1;
    L19:
        if (lhs.priorityClass <= rhs.priorityClass) goto L22;
        return 1;
    L22:
        if (lhs.listener != this.mTimeTickTrigger) goto L24;
        boolean timeTick1 = true;
    L26:
        if (rhs.listener != this.mTimeTickTrigger) goto L28;
        boolean timeTick2 = true;
    L29:
        if (timeTick1 == timeTick2) goto L34;
        if (timeTick1 == true) goto L32;
        return 1;
    L32:
        return -1;
    L34:
        if (lhs.getRequestedElapsed() >= rhs.getRequestedElapsed()) goto L37;
        return -1;
    L37:
        if (lhs.getRequestedElapsed() <= rhs.getRequestedElapsed()) goto L39;
        return 1;
    L39:
        return 0;
    L28:
        timeTick2 = false;
        goto L29
    L24:
        timeTick1 = false;
        goto L26
    L9:
        idleUntil2 = false;
        goto L11
    L5:
        idleUntil1 = false;
        goto L7
    }

    void calculateDeliveryPriorities(ArrayList<Alarm> alarms) {
        int N = alarms.size();
        ArraySet<UserPackage> wakeupPackages = new ArraySet(4);
        int i = 0;
    L3:
        if (i >= N) goto L8;
        Alarm a = alarms.get(i);
        if (a.wakeup == false) goto L7;
        wakeupPackages.add(UserPackage.of(UserHandle.getUserId(a.creatorUid), a.sourcePackage));
    L7:
        i = i + 1;
        goto L3
    L8:
        int i2 = 0;
    L9:
        if (i2 >= N) goto L21;
        Alarm a2 = alarms.get(i2);
        if (a2.creatorUid != 1000) goto L16;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(a2.sourcePackage) == false) goto L16;
        a2.priorityClass = 0;
    L19:
        i2 = i2 + 1;
    L16:
        if (wakeupPackages.contains(UserPackage.of(UserHandle.getUserId(a2.creatorUid), a2.sourcePackage)) == false) goto L18;
        a2.priorityClass = 1;
        goto L19
    L18:
        a2.priorityClass = 2;
        goto L19
    }

    AlarmManagerService(Context context, Injector injector) {
        super(context);
        this.mBackgroundIntent = new Intent().addFlags(4);
        this.mLog = new LocalLog(TAG);
        this.mLock = new Object();
        this.mExactAlarmCandidates = Collections.emptySet();
        this.mLastOpScheduleExactAlarm = new SparseIntArray();
        this.mPendingBackgroundAlarms = new SparseArray();
        this.mTickHistory = new long[10];
        this.mBroadcastRefCount = 0;
        this.mAlarmsPerUid = new SparseIntArray();
        this.mPendingNonWakeupAlarms = new ArrayList();
        this.mInFlight = new ArrayList();
        this.mInFlightListeners = new ArrayList();
        this.mLastPriorityAlarmDispatch = new SparseLongArray();
        this.mRemovalHistory = new SparseArray();
        this.mDeliveryTracker = new DeliveryTracker(this);
        this.mInteractive = true;
        this.mAllowWhileIdleDispatches = new ArrayList();
        this.mStatLogger = new StatLogger("Alarm manager stats", new String[]{"REORDER_ALARMS_FOR_STANDBY", "HAS_SCHEDULE_EXACT_ALARM"});
        this.mOptsWithFgs = makeBasicAlarmBroadcastOptions();
        this.mOptsWithFgsForAlarmClock = makeBasicAlarmBroadcastOptions();
        this.mOptsWithoutFgs = makeBasicAlarmBroadcastOptions();
        this.mOptsTimeBroadcast = makeBasicAlarmBroadcastOptions();
        this.mActivityOptsRestrictBal = ActivityOptions.makeBasic();
        this.mBroadcastOptsRestrictBal = makeBasicAlarmBroadcastOptions();
        this.mNextAlarmClockForUser = new SparseArray();
        this.mTmpSparseAlarmClockArray = new SparseArray();
        this.mPendingSendNextAlarmClockChangedForUser = new SparseBooleanArray();
        this.mAlarmClockUpdater = new AlarmManagerService$$ExternalSyntheticLambda13(this);
        this.mHandlerSparseAlarmClockArray = new SparseArray();
        this.mAlarmDispatchComparator = new AlarmManagerService$$ExternalSyntheticLambda14(this);
        this.mPendingIdleUntil = null;
        this.mNextWakeFromIdle = null;
        this.mBroadcastStats = new SparseArray();
        this.mNumDelayedAlarms = 0;
        this.mTotalDelayTime = 0;
        this.mMaxDelayTime = 0;
        this.mService = new AnonymousClass4(this);
        this.mForceAppStandbyListener = new AnonymousClass7(this);
        this.mSendCount = 0;
        this.mSendFinishCount = 0;
        this.mListenerCount = 0;
        this.mListenerFinishCount = 0;
        this.mInjector = injector;
    }

    public AlarmManagerService(Context context) {
        this(context, new Injector(context));
    }

    static boolean isRtc(int type) {
        if (type == 1) goto L8;
        if (type == 0) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private long convertToElapsed(long when, int type) {
        if (isRtc(type) == true) goto L5;
        return when;
    L5:
        return when - (this.mInjector.getCurrentTimeMillis() - this.mInjector.getElapsedRealtimeMillis());
    }

    long getMinimumAllowedWindow(long nowElapsed, long triggerElapsed) {
        long futurity = triggerElapsed - nowElapsed;
        return Math.min((long) (futurity * 0.75d), this.mConstants.MIN_WINDOW);
    }

    static long maxTriggerTime(long now, long triggerAtTime, long interval) {
        if (interval != 0) goto L5;
        long futurity = triggerAtTime - now;
    L7:
        if (futurity >= 10000) goto L9;
        futurity = 0;
    L9:
        long maxElapsed = addClampPositive(triggerAtTime, (long) (futurity * 0.75d));
        if (interval == 0) goto L12;
        return maxElapsed;
    L12:
        return Math.min(maxElapsed, addClampPositive(triggerAtTime, 3600000));
    L5:
        futurity = interval;
        goto L7
    }

    void reevaluateRtcAlarms() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean changed = this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda10(this));     // Catch: Throwable -> L15
        if (changed == true) goto L7;
    L17:
        if (changed == false) goto L19;
        rescheduleKernelAlarmsLocked();     // Catch: Throwable -> L15
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        if (this.mPendingIdleUntil == null) goto L17;
        if (this.mNextWakeFromIdle == null) goto L17;
        if (isRtc(this.mNextWakeFromIdle.type) == false) goto L17;
        boolean idleUntilUpdated = this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda11(this));     // Catch: Throwable -> L15
        if (idleUntilUpdated == false) goto L17;
        this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda12(this));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$reevaluateRtcAlarms$2(Alarm a) {
        if (isRtc(a.type) == true) goto L7;
        return false;
    L7:
        return restoreRequestedTime(a);
    }

    private /* synthetic */ boolean lambda$reevaluateRtcAlarms$3(Alarm a) {
        if (a == this.mPendingIdleUntil) goto L5;
    L7:
        return false;
    L5:
        if (adjustIdleUntilTime(a) == false) goto L7;
        return true;
    }

    private /* synthetic */ boolean lambda$reevaluateRtcAlarms$4(Alarm alarm) {
        return adjustDeliveryTimeBasedOnDeviceIdle(alarm);
    }

    boolean reorderAlarmsBasedOnStandbyBuckets(final ArraySet<UserPackage> targetPackages) {
        long start = this.mStatLogger.getTime();
        boolean changed = this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda20(this, targetPackages));
        this.mStatLogger.logDurationStat(0, start);
        return changed;
    }

    private /* synthetic */ boolean lambda$reorderAlarmsBasedOnStandbyBuckets$5(ArraySet targetPackages, Alarm a) {
        UserPackage userPackage = UserPackage.of(UserHandle.getUserId(a.creatorUid), a.sourcePackage);
        if (targetPackages == null) goto L9;
        if (targetPackages.contains(userPackage) == true) goto L9;
        return false;
    L9:
        return adjustDeliveryTimeBasedOnBucketLocked(a);
    }

    boolean reorderAlarmsBasedOnPowerSaver(final ArraySet<UserPackage> targetPackages) {
        boolean changed = this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda3(this, targetPackages));
        return changed;
    }

    private /* synthetic */ boolean lambda$reorderAlarmsBasedOnPowerSaver$6(ArraySet targetPackages, Alarm a) {
        UserPackage userPackage = UserPackage.of(UserHandle.getUserId(a.creatorUid), a.sourcePackage);
        if (targetPackages == null) goto L9;
        if (targetPackages.contains(userPackage) == true) goto L9;
        return false;
    L9:
        return adjustDeliveryTimeBasedOnPowerSaverLocked(a);
    }

    void ctlAlarmsBasedOnPowerSaver(ArraySet<UserPackage> targetPackages) {
        if (reorderAlarmsBasedOnPowerSaver(targetPackages) == false) goto L6;
        rescheduleKernelAlarmsLocked();
        updateNextAlarmClockLocked();
        return;
    }

    ArrayList<String> getTargetProcsByPkgName(String pkgName) {
        return sHeartbeatStats.getTargetProcsByPkgName(pkgName);
    }

    private String getProcName(int pid) {
        String procName = this.mActivityManagerInternal.getProcessNameByPid(pid);
        if (procName != null) goto L6;
        return "";
    L6:
        return procName;
    }

    private boolean restoreRequestedTime(Alarm a) {
        return a.setPolicyElapsed(0, convertToElapsed(a.origWhen, a.type));
    }

    static long clampPositive(long val) {
        if (val >= 0) goto L7;
        return Long.MAX_VALUE;
    L7:
        return val;
    }

    static long addClampPositive(long val1, long val2) {
        long val = val1 + val2;
        if (val < 0) goto L6;
        return val;
    L6:
        if (val1 >= 0) goto L8;
    L11:
        return 0;
    L8:
        if (val2 < 0) goto L11;
        return Long.MAX_VALUE;
    }

    void sendPendingBackgroundAlarmsLocked(int uid, String packageName) {
        ArrayList<Alarm> alarmsForUid = this.mPendingBackgroundAlarms.get(uid);
        if (alarmsForUid != null) goto L5;
        return;
    L5:
        if (alarmsForUid.size() != 0) goto L8;
        return;
    L8:
        if (packageName == null) goto L22;
        if (DEBUG_BG_LIMIT == false) goto L12;
        Slog.d(TAG, "Sending blocked alarms for uid " + uid + ", package " + packageName);
    L12:
        ArrayList<Alarm> alarmsToDeliver = new ArrayList();
        int i = alarmsForUid.size() - 1;
    L13:
        if (i < 0) goto L18;
        Alarm a = alarmsForUid.get(i);
        if (a.matches(packageName) == false) goto L17;
        alarmsToDeliver.add(alarmsForUid.remove(i));
    L17:
        i = i - 1;
        goto L13
    L18:
        int i2 = alarmsForUid.size();
        if (i2 != 0) goto L25;
        this.mPendingBackgroundAlarms.remove(uid);
    L25:
        deliverPendingBackgroundAlarmsLocked(alarmsToDeliver, this.mInjector.getElapsedRealtimeMillis());
        return;
    L22:
        if (DEBUG_BG_LIMIT == false) goto L24;
        Slog.d(TAG, "Sending blocked alarms for uid " + uid);
    L24:
        alarmsToDeliver = alarmsForUid;
        this.mPendingBackgroundAlarms.remove(uid);
        goto L25
    }

    void sendAllUnrestrictedPendingBackgroundAlarmsLocked() {
        ArrayList<Alarm> alarmsToDeliver = new ArrayList();
        findAllUnrestrictedPendingBackgroundAlarmsLockedInner(this.mPendingBackgroundAlarms, alarmsToDeliver, new AlarmManagerService$$ExternalSyntheticLambda6(this));
        if (alarmsToDeliver.size() <= 0) goto L6;
        deliverPendingBackgroundAlarmsLocked(alarmsToDeliver, this.mInjector.getElapsedRealtimeMillis());
        return;
    }

    static void findAllUnrestrictedPendingBackgroundAlarmsLockedInner(SparseArray<ArrayList<Alarm>> pendingAlarms, ArrayList<Alarm> unrestrictedAlarms, Predicate<Alarm> isBackgroundRestricted) {
        int uidIndex = pendingAlarms.size() - 1;
    L3:
        if (uidIndex < 0) goto L16;
        ArrayList<Alarm> alarmsForUid = pendingAlarms.valueAt(uidIndex);
        int alarmIndex = alarmsForUid.size() - 1;
    L5:
        if (alarmIndex < 0) goto L11;
        Alarm alarm = alarmsForUid.get(alarmIndex);
        if (isBackgroundRestricted.test(alarm) == true) goto L10;
        unrestrictedAlarms.add(alarm);
        alarmsForUid.remove(alarmIndex);
    L10:
        alarmIndex = alarmIndex - 1;
        goto L5
    L11:
        int alarmIndex2 = alarmsForUid.size();
        if (alarmIndex2 != 0) goto L14;
        pendingAlarms.removeAt(uidIndex);
    L14:
        uidIndex = uidIndex - 1;
        goto L3
    }

    private void deliverPendingBackgroundAlarmsLocked(ArrayList<Alarm> alarms, long nowELAPSED) {
        ArrayList<Alarm> r0 = alarms;
        int N = r0.size();
        boolean hasWakeup = false;
        int i = 0;
    L3:
        if (i >= N) goto L14;
        Alarm alarm = r0.get(i);
        if (alarm.wakeup == false) goto L7;
        boolean hasWakeup2 = true;
    L8:
        alarm.count = 1;
        if (alarm.repeatInterval <= 0) goto L11;
        alarm.count = (int) (((long) alarm.count) + ((nowELAPSED - alarm.getRequestedElapsed()) / alarm.repeatInterval));
        long delta = ((long) alarm.count) * alarm.repeatInterval;
        long nextElapsed = alarm.getRequestedElapsed() + delta;
        long nextMaxElapsed = maxTriggerTime(nowELAPSED, nextElapsed, alarm.repeatInterval);
        int N2 = N;
        int i2 = i;
        setImplLocked(alarm.type, alarm.origWhen + delta, nextElapsed, nextMaxElapsed - nextElapsed, alarm.repeatInterval, alarm.operation, null, null, alarm.flags, alarm.workSource, alarm.alarmClock, alarm.uid, alarm.packageName, null, -1, alarm.processName, true, true);
    L12:
        i = i2 + 1;
        r0 = alarms;
        hasWakeup = hasWakeup2;
        N = N2;
        goto L3
    L11:
        N2 = N;
        i2 = i;
        goto L12
    L7:
        hasWakeup2 = hasWakeup;
        goto L8
    L14:
        if (hasWakeup == true) goto L22;
        long r2 = nowELAPSED;
        if (checkAllowNonWakeupDelayLocked(r2) == false) goto L24;
        if (this.mPendingNonWakeupAlarms.size() != 0) goto L20;
        this.mStartCurrentDelayTime = r2;
        this.mNextNonWakeupDeliveryTime = ((currentNonWakeupFuzzLocked(r2) * 3) / 2) + r2;
    L20:
        this.mPendingNonWakeupAlarms.addAll(alarms);
        this.mNumDelayedAlarms += alarms.size();
        return;
    L24:
        if (DEBUG_BG_LIMIT == false) goto L27;
        Slog.d(TAG, "Waking up to deliver pending blocked alarms");
    L27:
        if (this.mPendingNonWakeupAlarms.size() <= 0) goto L32;
        alarms.addAll(this.mPendingNonWakeupAlarms);
        long thisDelayTime = r2 - this.mStartCurrentDelayTime;
        this.mTotalDelayTime += thisDelayTime;
        if (this.mMaxDelayTime >= thisDelayTime) goto L31;
        this.mMaxDelayTime = thisDelayTime;
    L31:
        this.mPendingNonWakeupAlarms.clear();
    L32:
        calculateDeliveryPriorities(alarms);
        Collections.sort(alarms, this.mAlarmDispatchComparator);
        deliverAlarmsLocked(alarms, nowELAPSED);
        return;
    L22:
        r2 = nowELAPSED;
        goto L24
    }

    private void notifyBroadcastAlarmPendingLocked(int uid) {
        int numListeners = this.mInFlightListeners.size();
        int i = 0;
    L3:
        if (i >= numListeners) goto L6;
        this.mInFlightListeners.get(i).broadcastAlarmPending(uid);
        i = i + 1;
        goto L3
    }

    private void notifyBroadcastAlarmCompleteLocked(int uid) {
        int numListeners = this.mInFlightListeners.size();
        int i = 0;
    L3:
        if (i >= numListeners) goto L6;
        this.mInFlightListeners.get(i).broadcastAlarmComplete(uid);
        i = i + 1;
        goto L3
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mInjector.init();
        this.mHandler = new AlarmHandler(this);
        sHeartbeatStats.init(this, getContext(), this.mHandler);
        this.mOptsWithFgs.setPendingIntentBackgroundActivityLaunchAllowed(false);
        this.mOptsWithFgsForAlarmClock.setPendingIntentBackgroundActivityLaunchAllowed(false);
        this.mOptsWithoutFgs.setPendingIntentBackgroundActivityLaunchAllowed(false);
        this.mOptsTimeBroadcast.setPendingIntentBackgroundActivityLaunchAllowed(false);
        this.mActivityOptsRestrictBal.setPendingIntentBackgroundActivityLaunchAllowed(false);
        this.mBroadcastOptsRestrictBal.setPendingIntentBackgroundActivityLaunchAllowed(false);
        this.mMetricsHelper = new MetricsHelper(getContext(), this.mLock);
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (UserManager.supportsMultipleUsers() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.mStartUserBeforeScheduledAlarms = r0;
        if (this.mStartUserBeforeScheduledAlarms == false) goto L11;
        this.mUserWakeupStore = new UserWakeupStore();
        this.mUserWakeupStore.init();
    L11:
        ActivityManager.UidFrozenStateChangedCallback callback = new AlarmManagerService$$ExternalSyntheticLambda2(this);
        ActivityManager am = (ActivityManager) getContext().getSystemService(ActivityManager.class);
        am.registerUidFrozenStateChangedCallback(new HandlerExecutor(this.mHandler), callback);
        this.mListenerDeathRecipient = new AnonymousClass1(this);
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mConstants = new Constants(this, this.mHandler);     // Catch: Throwable -> L16
        this.mAlarmStore = new LazyAlarmStore();     // Catch: Throwable -> L16
        this.mAlarmStore.setAlarmClockRemovalListener(this.mAlarmClockUpdater);     // Catch: Throwable -> L16
        this.mAppWakeupHistory = new AppWakeupHistory(3600000);     // Catch: Throwable -> L16
        this.mAllowWhileIdleHistory = new AppWakeupHistory(3600000);     // Catch: Throwable -> L16
        this.mAllowWhileIdleCompatHistory = new AppWakeupHistory(3600000);     // Catch: Throwable -> L16
        this.mTemporaryQuotaReserve = new TemporaryQuotaReserve(86400000);     // Catch: Throwable -> L16
        SysOptApexBridge.getFactory().getAlarmMS().init(getContext(), this);     // Catch: Throwable -> L16
        this.mNextNonWakeup = 0;     // Catch: Throwable -> L16
        this.mNextWakeup = 0;     // Catch: Throwable -> L16
        this.mInjector.initializeTimeIfRequired();     // Catch: Throwable -> L16
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L16
        this.mSystemUiUid = this.mInjector.getSystemUiUid(this.mPackageManagerInternal);     // Catch: Throwable -> L16
        if (this.mSystemUiUid > 0) goto L18;
        Slog.wtf(TAG, "SysUI package not found!");     // Catch: Throwable -> L16
    L18:
        this.mWakeLock = this.mInjector.getAlarmWakeLock();     // Catch: Throwable -> L16
        this.mTimeTickIntent = new Intent("android.intent.action.TIME_TICK").addFlags(1344274432);     // Catch: Throwable -> L16
        this.mTimeTickOptions = BroadcastOptions.makeBasic().setDeliveryGroupPolicy(1).setDeferralPolicy(2).toBundle();     // Catch: Throwable -> L16
        this.mTimeTickTrigger = new AnonymousClass2(this);     // Catch: Throwable -> L16
        Intent intent = new Intent("android.intent.action.DATE_CHANGED");     // Catch: Throwable -> L16
        intent.addFlags(538968064);     // Catch: Throwable -> L16
        this.mDateChangeSender = PendingIntent.getBroadcastAsUser(getContext(), 0, intent, 67108864, UserHandle.ALL);     // Catch: Throwable -> L16
        this.mClockReceiver = this.mInjector.getClockReceiver(this);     // Catch: Throwable -> L16
        new ChargingReceiver(this);     // Catch: Throwable -> L16
        new InteractiveStateReceiver(this);     // Catch: Throwable -> L16
        new UninstallReceiver(this);     // Catch: Throwable -> L16
        if (this.mInjector.isAlarmDriverPresent() == false) goto L21;
        AlarmThread waitThread = new AlarmThread(this);     // Catch: Throwable -> L16
        waitThread.start();     // Catch: Throwable -> L16
    L22:
        monitor-exit(r4);     // Catch: Throwable -> L16
        publishLocalService(AlarmManagerInternal.class, new LocalService(this, null));
        publishBinderService(HostingRecord.TRIGGER_TYPE_ALARM, this.mService);
        return;
    L21:
        Slog.w(TAG, "Failed to open alarm driver. Falling back to a handler.");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L5:
        if (Resources.getSystem().getBoolean(R.bool.config_allowAlarmsOnStoppedUsers) == false) goto L7;
        r0 = true;
        goto L8
    }

    private /* synthetic */ void lambda$onStart$7(int[] uids, int[] frozenStates) {
        int size = frozenStates.length;
        if (uids.length == size) goto L6;
        Slog.wtf(TAG, "Got different length arrays in frozen state callback! uids.length: " + uids.length + " frozenStates.length: " + size);
        return;
    L6:
        IntArray affectedUids = new IntArray();
        int i = 0;
    L7:
        if (i >= size) goto L16;
        if (frozenStates[i] != 1) goto L15;
        if (CompatChanges.isChangeEnabled(265195908, uids[i]) == false) goto L15;
        affectedUids.add(uids[i]);
    L15:
        i = i + 1;
        goto L7
    L16:
        int i2 = affectedUids.size();
        if (i2 <= 0) goto L24;
        removeExactListenerAlarms(affectedUids.toArray());
        return;
    }

    private void removeExactListenerAlarms(final int... whichUids) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeAlarmsInternalLocked(new AlarmManagerService$$ExternalSyntheticLambda5(whichUids), 6);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeExactListenerAlarms$8(int[] whichUids, Alarm a) {
        if (ArrayUtils.contains(whichUids, a.uid) == true) goto L5;
        return false;
    L5:
        if (a.listener != null) goto L7;
        return false;
    L7:
        if (a.windowLength != 0) goto L14;
        Slog.w(TAG, "Alarm " + a.listenerTag + " being removed for " + UserHandle.formatUid(a.uid) + ":" + a.packageName + " because the app got frozen");
        return true;
    L14:
        return false;
    }

    void refreshExactAlarmCandidates() {
        String[] candidates = this.mLocalPermissionManager.getAppOpPermissionPackages("android.permission.SCHEDULE_EXACT_ALARM");
        Set<Integer> newAppIds = new ArraySet(candidates.length);
        int r2 = candidates.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        String candidate = candidates[r4];
        int uid = this.mPackageManagerInternal.getPackageUid(candidate, 4194304, 0);
        if (uid <= 0) goto L7;
        newAppIds.add(Integer.valueOf(UserHandle.getAppId(uid)));
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        this.mExactAlarmCandidates = Collections.unmodifiableSet(newAppIds);
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        super.onUserStarting(user);
        final int userId = user.getUserIdentifier();
        if (this.mStartUserBeforeScheduledAlarms == false) goto L5;
        this.mUserWakeupStore.onUserStarting(userId);
    L5:
        this.mHandler.post(new AlarmManagerService$$ExternalSyntheticLambda4(this, userId));
    }

    private /* synthetic */ void lambda$onUserStarting$9(int userId) {
        Iterator<Integer> r0 = this.mExactAlarmCandidates.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        int appId = r0.next().intValue();
        int uid = UserHandle.getUid(userId, appId);
        AndroidPackage androidPackage = this.mPackageManagerInternal.getPackage(uid);
        if (androidPackage == null) goto L4;
        int mode = this.mAppOps.checkOpNoThrow(107, uid, androidPackage.getPackageName());
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mLastOpScheduleExactAlarm.put(uid, mode);     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L16;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConstants.start();     // Catch: Throwable -> L13
        this.mAppOps = (AppOpsManager) getContext().getSystemService("appops");     // Catch: Throwable -> L13
        this.mLocalDeviceIdleController = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);     // Catch: Throwable -> L13
        this.mUsageStatsManagerInternal = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);     // Catch: Throwable -> L13
        this.mAppStateTracker = (AppStateTrackerImpl) LocalServices.getService(AppStateTracker.class);     // Catch: Throwable -> L13
        this.mAppStateTracker.addListener(this.mForceAppStandbyListener);     // Catch: Throwable -> L13
        BatteryManager bm = (BatteryManager) getContext().getSystemService(BatteryManager.class);     // Catch: Throwable -> L13
        this.mAppStandbyParole = bm.isCharging();     // Catch: Throwable -> L13
        this.mClockReceiver.scheduleTimeTickEvent();     // Catch: Throwable -> L13
        this.mClockReceiver.scheduleDateChangedEvent();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        IAppOpsService iAppOpsService = this.mInjector.getAppOpsService();
        AlarmManagerServiceIA r1 = null;
        iAppOpsService.startWatchingMode(107, null, new AnonymousClass3(this));     // Catch: RemoteException -> L11
    L12:
        this.mLocalPermissionManager = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        refreshExactAlarmCandidates();
        AppStandbyInternal appStandbyInternal = (AppStandbyInternal) LocalServices.getService(AppStandbyInternal.class);
        appStandbyInternal.addListener(new AppStandbyTracker(this, r1));
        this.mBatteryStatsInternal = (BatteryStatsInternal) LocalServices.getService(BatteryStatsInternal.class);
        this.mRoleManager = (RoleManager) getContext().getSystemService(RoleManager.class);
        this.mMetricsHelper.registerPuller(new AlarmManagerService$$ExternalSyntheticLambda1(this));
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ AlarmStore lambda$onBootPhase$10() {
        return this.mAlarmStore;
    }

    protected void finalize() throws Throwable {
        this.mInjector.close();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    boolean setTimeImpl(long newSystemClockTimeMillis, int confidence, String logMsg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInjector.setCurrentTimeMillis(newSystemClockTimeMillis, confidence, logMsg);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    void setTimeZoneImpl(String tzId, int confidence, String logInfo) {
        if (TextUtils.isEmpty(tzId) == false) goto L5;
        return;
    L5:
        TimeZone newZone = TimeZone.getTimeZone(tzId);
        monitor-enter(this);
        boolean timeZoneWasChanged = SystemTimeZone.setTimeZoneId(tzId, confidence, logInfo);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        TimeZone.setDefault(null);
        if (timeZoneWasChanged == false) goto L18;
        this.mClockReceiver.scheduleDateChangedEvent();
        Intent intent = new Intent("android.intent.action.TIMEZONE_CHANGED");
        intent.addFlags(622854144);
        intent.putExtra("time-zone", newZone.getID());
        this.mOptsTimeBroadcast.setTemporaryAppAllowlist(this.mActivityManagerInternal.getBootTimeTempAllowListDuration(), 0, 204, "");
        this.mOptsTimeBroadcast.setDeliveryGroupPolicy(1);
        getContext().sendBroadcastAsUser(intent, UserHandle.ALL, null, this.mOptsTimeBroadcast.toBundle());
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void removeImpl(PendingIntent operation, IAlarmListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeLocked(operation, listener, 0);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setImpl(int type, long triggerAtTime, long windowLength, long interval, PendingIntent operation, IAlarmListener directReceiver, String listenerTag, int flags, WorkSource workSource, AlarmManager.AlarmClockInfo alarmClock, int callingUid, String callingPackage, Bundle idleOptions, int exactAllowReason) {
        long triggerAtTime2 = triggerAtTime;
        long windowLength2 = windowLength;
        if (operation != null) goto L5;
        if (directReceiver != null) goto L5;
    L7:
        Slog.w(TAG, "Alarms must either supply a PendingIntent or an AlarmReceiver");
        return;
    L5:
        if (operation == null) goto L10;
        if (directReceiver != null) goto L7;
    L10:
        if (directReceiver != null) goto L104;
    L16:
        long minInterval = this.mConstants.MIN_INTERVAL;
        if (interval > 0) goto L19;
    L21:
        long minInterval2 = minInterval;
        if (interval <= this.mConstants.MAX_INTERVAL) goto L24;
        Slog.w(TAG, "Suspiciously long interval " + interval + " millis; clamping");
        long interval2 = this.mConstants.MAX_INTERVAL;
    L25:
        if (type < 0) goto L98;
        if (type > 3) goto L98;
        if (triggerAtTime2 >= 0) goto L31;
        long what = Binder.getCallingPid();
        Slog.w(TAG, "Invalid alarm trigger time! " + triggerAtTime2 + " from uid=" + callingUid + " pid=" + what);
        triggerAtTime2 = 0;
    L31:
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        long nominalTrigger = convertToElapsed(triggerAtTime2, type);
        if (UserHandle.isCore(callingUid) == false) goto L34;
        long r14 = 0;
    L35:
        long minTrigger = nowElapsed + r14;
        long triggerElapsed = Math.max(minTrigger, nominalTrigger);
        if (windowLength2 != 0) goto L39;
        long triggerElapsed2 = triggerElapsed;
        long nominalTrigger2 = windowLength2;
        long windowLength3 = triggerElapsed;
    L54:
        Object r15 = this.mLock;
        monitor-enter(r15);
    L93:
        th = th;
        Object r26 = r15;
    L95:
        monitor-exit(r26);     // Catch: Throwable -> L85
        throw th;
    L57:
        if (DEBUG_BATCH == false) goto L101;
    L64:
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L93
        r16.append("set(");     // Catch: Throwable -> L93
        r16.append(operation);     // Catch: Throwable -> L93
        r16.append(") : type=");     // Catch: Throwable -> L93
        r16.append(type);     // Catch: Throwable -> L93
        r16.append(" triggerAtTime=");     // Catch: Throwable -> L93
        r16.append(triggerAtTime2);     // Catch: Throwable -> L93
        r16.append(" win=");     // Catch: Throwable -> L93
        r16.append(nominalTrigger2);     // Catch: Throwable -> L93
        r16.append(" tElapsed=");     // Catch: Throwable -> L93
        r16.append(triggerElapsed2);     // Catch: Throwable -> L93
        r16.append(" maxElapsed=");     // Catch: Throwable -> L93
        r16.append(windowLength3);     // Catch: Throwable -> L93
        r16.append(" interval=");     // Catch: Throwable -> L93
        long triggerAtTime3 = interval2;
        r16.append(triggerAtTime3);     // Catch: Throwable -> L91
        r16.append(" flags=0x");     // Catch: Throwable -> L91
        r16.append(Integer.toHexString(flags));     // Catch: Throwable -> L91
        r16.append(" pkg: ");     // Catch: Throwable -> L91
        r16.append(callingPackage);     // Catch: Throwable -> L91
        r16.append(" tag: ");     // Catch: Throwable -> L91
        String r9 = listenerTag;
        interval2 = triggerAtTime3;
        r16.append(Alarm.makeTag(operation, r9, type));     // Catch: Throwable -> L89
        Slog.v(TAG, r16.toString());     // Catch: Throwable -> L89
    L70:
        if (this.mAlarmsPerUid.get(callingUid, 0) >= this.mConstants.MAX_ALARMS_PER_UID) goto L103;
    L79:
        r26 = r15;
        setImplLocked(type, triggerAtTime2, triggerElapsed2, nominalTrigger2, interval2, operation, directReceiver, r9, flags, workSource, alarmClock, callingUid, callingPackage, idleOptions, exactAllowReason, getProcName(Binder.getCallingPid()), true, true);     // Catch: Throwable -> L87
        monitor-exit(r26);     // Catch: Throwable -> L85
        return;
    L87:
        th = th;
        goto L95
    L103:
        String errorMsg = "Maximum limit of concurrent alarms " + this.mConstants.MAX_ALARMS_PER_UID + " reached for uid: " + UserHandle.formatUid(callingUid) + ", callingPackage: " + callingPackage;     // Catch: Throwable -> L74
        Slog.w(TAG, errorMsg);     // Catch: Throwable -> L74
        if (callingUid != 1000) goto L77;
        EventLog.writeEvent(1397638484, new Object[]{"234441463", -1, errorMsg});     // Catch: Throwable -> L74
        goto L79
    L77:
        throw new IllegalStateException(errorMsg);     // Catch: Throwable -> L74
    L74:
        th = th;
        r26 = r15;
    L89:
        th = th;
        r26 = r15;
    L91:
        th = th;
        r26 = r15;
        goto L95
    L101:
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == true) goto L64;
        r9 = listenerTag;
    L62:
        th = th;
        r26 = r15;
    L85:
        th = th;
        goto L95
    L39:
        if (windowLength2 >= 0) goto L41;
        long maxElapsed = maxTriggerTime(nowElapsed, triggerElapsed, interval2);
        triggerElapsed2 = triggerElapsed;
        nominalTrigger2 = maxElapsed - triggerElapsed2;
        windowLength3 = maxElapsed;
        goto L54
    L41:
        triggerElapsed2 = triggerElapsed;
        long minAllowedWindow = getMinimumAllowedWindow(nowElapsed, triggerElapsed2);
        if (windowLength2 <= 86400000) goto L44;
        nowElapsed = nowElapsed;
        Slog.w(TAG, "Window length " + windowLength2 + "ms too long; limiting to 1 day");
        windowLength2 = 86400000;
    L53:
        nominalTrigger2 = windowLength2;
        windowLength3 = triggerElapsed2 + windowLength2;
        goto L54
    L44:
        nowElapsed = nowElapsed;
        if ((flags & 64) != 0) goto L53;
        if (windowLength2 >= minAllowedWindow) goto L53;
        if (isExemptFromMinWindowRestrictions(callingUid) == true) goto L53;
        if (CompatChanges.isChangeEnabled(185199076, callingPackage, UserHandle.getUserHandleForUid(callingUid)) == false) goto L53;
        Slog.w(TAG, "Window length " + windowLength2 + "ms too short; expanding to " + minAllowedWindow + "ms.");
        windowLength2 = minAllowedWindow;
        goto L53
    L34:
        r14 = this.mConstants.MIN_FUTURITY;
    L98:
        throw new IllegalArgumentException("Invalid alarm type " + type);
    L24:
        interval2 = interval;
        goto L25
    L19:
        if (interval >= minInterval) goto L21;
        StringBuilder r0 = new StringBuilder();
        minInterval2 = minInterval;
        r0.append("Suspiciously short interval ");
        r0.append(interval);
        r0.append(" millis; expanding to ");
        r0.append(minInterval2 / 1000);
        r0.append(" seconds");
        Slog.w(TAG, r0.toString());
        interval2 = minInterval2;
        goto L25
    L104:
        directReceiver.asBinder().linkToDeath(this.mListenerDeathRecipient, 0);     // Catch: RemoteException -> L13
    L14:
        Slog.w(TAG, "Dropping unreachable alarm listener " + listenerTag);
    }

    private void setImplLocked(int type, long when, long whenElapsed, long windowLength, long interval, PendingIntent operation, IAlarmListener directReceiver, String listenerTag, int flags, WorkSource workSource, AlarmManager.AlarmClockInfo alarmClock, int callingUid, String callingPackage, Bundle idleOptions, int exactAllowReason, String procName, boolean removeNeeded, boolean doSchedule) {
        Alarm a = new Alarm(type, when, whenElapsed, windowLength, interval, operation, directReceiver, listenerTag, workSource, flags, alarmClock, callingUid, callingPackage, idleOptions, exactAllowReason, procName);
        if (this.mActivityManagerInternal.isAppStartModeDisabled(callingUid, callingPackage) == false) goto L6;
        Slog.w(TAG, "Not setting alarm from " + callingUid + ":" + a + " -- package not allowed to start");
        return;
    L6:
        int callerProcState = this.mActivityManagerInternal.getUidProcessState(callingUid);
        if (HeartbeatStats.sEnabled == false) goto L11;
        if (removeNeeded == true) goto L11;
    L12:
        incrementAlarmCount(a.uid);
        setImplLocked(a, doSchedule);
        MetricsHelper.pushAlarmScheduled(a, callerProcState);
        return;
    L11:
        removeLocked(operation, directReceiver, 0);
        goto L12
    }

    int getQuotaForBucketLocked(int bucket) {
        if (bucket > 10) goto L6;
        int index = 0;
    L16:
        return this.mConstants.APP_STANDBY_QUOTAS[index];
    L6:
        if (bucket > 20) goto L9;
        index = 1;
        goto L16
    L9:
        if (bucket > 30) goto L12;
        index = 2;
        goto L16
    L12:
        if (bucket >= 50) goto L14;
        index = 3;
        goto L16
    L14:
        index = 4;
        goto L16
    }

    private boolean adjustIdleUntilTime(Alarm alarm) {
        if ((alarm.flags & 16) != 0) goto L5;
        return false;
    L5:
        boolean changedBeforeFuzz = restoreRequestedTime(alarm);
        if (this.mNextWakeFromIdle != null) goto L8;
        return changedBeforeFuzz;
    L8:
        long upcomingWakeFromIdle = this.mNextWakeFromIdle.getWhenElapsed();
        if (alarm.getWhenElapsed() >= (upcomingWakeFromIdle - this.mConstants.MIN_DEVICE_IDLE_FUZZ)) goto L11;
        return changedBeforeFuzz;
    L11:
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        long futurity = upcomingWakeFromIdle - nowElapsed;
        if (futurity > this.mConstants.MIN_DEVICE_IDLE_FUZZ) goto L14;
        alarm.setPolicyElapsed(0, nowElapsed);
        return true;
    L14:
        ThreadLocalRandom random = ThreadLocalRandom.current();
        long upperBoundExcl = Math.min(this.mConstants.MAX_DEVICE_IDLE_FUZZ, futurity) + 1;
        long fuzz = random.nextLong(this.mConstants.MIN_DEVICE_IDLE_FUZZ, upperBoundExcl);
        alarm.setPolicyElapsed(0, upcomingWakeFromIdle - fuzz);
        return true;
    }

    private boolean adjustDeliveryTimeBasedOnBatterySaver(Alarm alarm) {
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        if (isExemptFromBatterySaver(alarm) == false) goto L7;
        return false;
    L7:
        if (this.mAppStateTracker == null) goto L36;
        if (this.mAppStateTracker.areAlarmsRestrictedByBatterySaver(alarm.creatorUid, alarm.sourcePackage) == false) goto L36;
        if ((alarm.flags & 8) == 0) goto L15;
        long batterySaverPolicyElapsed = nowElapsed;
    L34:
        return alarm.setPolicyElapsed(3, batterySaverPolicyElapsed);
    L15:
        if (isAllowedWhileIdleRestricted(alarm) == false) goto L26;
        int userId = UserHandle.getUserId(alarm.creatorUid);
        if ((alarm.flags & 4) == 0) goto L19;
        int quota = this.mConstants.ALLOW_WHILE_IDLE_QUOTA;
        long window = this.mConstants.ALLOW_WHILE_IDLE_WINDOW;
        AppWakeupHistory history = this.mAllowWhileIdleHistory;
    L20:
        int dispatchesInHistory = history.getTotalWakeupsInWindow(alarm.sourcePackage, userId);
        if (dispatchesInHistory >= quota) goto L23;
        batterySaverPolicyElapsed = nowElapsed;
        goto L34
    L23:
        batterySaverPolicyElapsed = history.getNthLastWakeupForPackage(alarm.sourcePackage, userId, quota) + window;
        goto L34
    L19:
        quota = this.mConstants.ALLOW_WHILE_IDLE_COMPAT_QUOTA;
        window = this.mConstants.ALLOW_WHILE_IDLE_COMPAT_WINDOW;
        history = this.mAllowWhileIdleCompatHistory;
        goto L20
    L26:
        if ((alarm.flags & 64) == 0) goto L32;
        long lastDispatch = this.mLastPriorityAlarmDispatch.get(alarm.creatorUid, 0);
        if (lastDispatch != 0) goto L30;
        batterySaverPolicyElapsed = nowElapsed;
        goto L34
    L30:
        batterySaverPolicyElapsed = this.mConstants.PRIORITY_ALARM_DELAY + lastDispatch;
        goto L34
    L32:
        batterySaverPolicyElapsed = 31536000000L + nowElapsed;
    L36:
        return alarm.setPolicyElapsed(3, nowElapsed);
    }

    private static boolean isAllowedWhileIdleRestricted(Alarm a) {
        if ((a.flags & 36) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean adjustDeliveryTimeBasedOnDeviceIdle(Alarm alarm) {
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        if (this.mPendingIdleUntil == null) goto L32;
        if (this.mPendingIdleUntil == alarm) goto L32;
        if ((alarm.flags & 10) == 0) goto L11;
        long deviceIdlePolicyTime = nowElapsed;
    L30:
        return alarm.setPolicyElapsed(2, deviceIdlePolicyTime);
    L11:
        if (isAllowedWhileIdleRestricted(alarm) == false) goto L22;
        int userId = UserHandle.getUserId(alarm.creatorUid);
        if ((alarm.flags & 4) == 0) goto L15;
        int quota = this.mConstants.ALLOW_WHILE_IDLE_QUOTA;
        long window = this.mConstants.ALLOW_WHILE_IDLE_WINDOW;
        AppWakeupHistory history = this.mAllowWhileIdleHistory;
    L16:
        int dispatchesInHistory = history.getTotalWakeupsInWindow(alarm.sourcePackage, userId);
        if (dispatchesInHistory >= quota) goto L19;
        deviceIdlePolicyTime = nowElapsed;
        goto L30
    L19:
        long whenInQuota = history.getNthLastWakeupForPackage(alarm.sourcePackage, userId, quota) + window;
        deviceIdlePolicyTime = Math.min(whenInQuota, this.mPendingIdleUntil.getWhenElapsed());
        goto L30
    L15:
        quota = this.mConstants.ALLOW_WHILE_IDLE_COMPAT_QUOTA;
        window = this.mConstants.ALLOW_WHILE_IDLE_COMPAT_WINDOW;
        history = this.mAllowWhileIdleCompatHistory;
        goto L16
    L22:
        if ((alarm.flags & 64) == 0) goto L28;
        long lastDispatch = this.mLastPriorityAlarmDispatch.get(alarm.creatorUid, 0);
        if (lastDispatch != 0) goto L26;
        long whenAllowed = nowElapsed;
    L27:
        deviceIdlePolicyTime = Math.min(whenAllowed, this.mPendingIdleUntil.getWhenElapsed());
        goto L30
    L26:
        whenAllowed = this.mConstants.PRIORITY_ALARM_DELAY + lastDispatch;
        goto L27
    L28:
        deviceIdlePolicyTime = this.mPendingIdleUntil.getWhenElapsed();
    L32:
        return alarm.setPolicyElapsed(2, nowElapsed);
    }

    private boolean adjustDeliveryTimeBasedOnBucketLocked(Alarm alarm) {
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        if (isExemptFromAppStandby(alarm) == true) goto L29;
        if (this.mAppStandbyParole == true) goto L29;
        String sourcePackage = alarm.sourcePackage;
        int sourceUserId = UserHandle.getUserId(alarm.creatorUid);
        int standbyBucket = this.mUsageStatsManagerInternal.getAppStandbyBucket(sourcePackage, sourceUserId, nowElapsed);
        int wakeupsInWindow = this.mAppWakeupHistory.getTotalWakeupsInWindow(sourcePackage, sourceUserId);
        if (standbyBucket != 45) goto L15;
        if (wakeupsInWindow <= 0) goto L26;
        long lastWakeupTime = this.mAppWakeupHistory.getNthLastWakeupForPackage(sourcePackage, sourceUserId, this.mConstants.APP_STANDBY_RESTRICTED_QUOTA);
        if ((nowElapsed - lastWakeupTime) >= this.mConstants.APP_STANDBY_RESTRICTED_WINDOW) goto L26;
        return alarm.setPolicyElapsed(1, this.mConstants.APP_STANDBY_RESTRICTED_WINDOW + lastWakeupTime);
    L26:
        alarm.mUsingReserveQuota = false;
        return alarm.setPolicyElapsed(1, nowElapsed);
    L15:
        int quotaForBucket = getQuotaForBucketLocked(standbyBucket);
        if (wakeupsInWindow < quotaForBucket) goto L26;
        if (this.mTemporaryQuotaReserve.hasQuota(sourcePackage, sourceUserId, nowElapsed) == false) goto L21;
        alarm.mUsingReserveQuota = true;
        return alarm.setPolicyElapsed(1, nowElapsed);
    L21:
        if (quotaForBucket > 0) goto L23;
        long t = 31536000000L + nowElapsed;
    L25:
        return alarm.setPolicyElapsed(1, t);
    L23:
        long t2 = this.mAppWakeupHistory.getNthLastWakeupForPackage(sourcePackage, sourceUserId, quotaForBucket);
        t = this.mConstants.APP_STANDBY_WINDOW + t2;
    L29:
        return alarm.setPolicyElapsed(1, nowElapsed);
    }

    private boolean adjustDeliveryTimeBasedOnPowerSaverLocked(Alarm alarm) {
        if (isExemptFromPowerSaver(alarm) == true) goto L10;
        if (this.mAppStandbyParole == true) goto L10;
        FeatLog.i(IAlarmManagerServiceOptEx.OPT_TAG, IAlarmManagerServiceOptEx.FEAT_TAG, 0, "powerSaver restricted. " + alarm);
        return alarm.setPolicyElapsed(4, alarm.calHeartBeatElapsed(true));
    L10:
        return alarm.setPolicyElapsed(4, alarm.calHeartBeatElapsed(false));
    }

    private void setImplLocked(Alarm a, boolean doSchedule) {
        if ((a.flags & 16) == 0) goto L11;
        adjustIdleUntilTime(a);
        if (this.mPendingIdleUntil != a) goto L7;
    L9:
        this.mPendingIdleUntil = a;
        this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda22(this));
    L14:
        if ((a.flags & 2) == 0) goto L25;
        if (this.mNextWakeFromIdle != null) goto L18;
    L19:
        this.mNextWakeFromIdle = a;
        if (this.mPendingIdleUntil == null) goto L25;
        boolean updated = this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda23(this));
        if (updated == false) goto L25;
        this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda24(this));
        goto L25
    L18:
        if (this.mNextWakeFromIdle.getWhenElapsed() > a.getWhenElapsed()) goto L19;
    L25:
        if (a.alarmClock == null) goto L27;
        this.mNextAlarmClockMayChange = true;
    L27:
        adjustDeliveryTimeBasedOnBatterySaver(a);
        adjustDeliveryTimeBasedOnBucketLocked(a);
        adjustDeliveryTimeBasedOnPowerSaverLocked(a);
        this.mAlarmStore.add(a);
        if (HeartbeatStats.sEnabled == false) goto L30;
        if (doSchedule == true) goto L30;
        return;
    L30:
        rescheduleKernelAlarmsLocked();
        updateNextAlarmClockLocked();
        return;
    L7:
        if (this.mPendingIdleUntil == null) goto L9;
        Slog.wtfStack(TAG, "setImplLocked: idle until changed from " + this.mPendingIdleUntil + " to " + a);
        AlarmStore r0 = this.mAlarmStore;
        final Alarm r1 = this.mPendingIdleUntil;
        r1.getClass();
        r0.remove(new AlarmManagerService$$ExternalSyntheticLambda21(r1));
        goto L9
    L11:
        if (this.mPendingIdleUntil == null) goto L14;
        adjustDeliveryTimeBasedOnDeviceIdle(a);
        goto L14
    }

    private /* synthetic */ boolean lambda$setImplLocked$11(Alarm alarm) {
        return adjustDeliveryTimeBasedOnDeviceIdle(alarm);
    }

    private /* synthetic */ boolean lambda$setImplLocked$12(Alarm alarm) {
        if (alarm == this.mPendingIdleUntil) goto L5;
    L7:
        return false;
    L5:
        if (adjustIdleUntilTime(alarm) == false) goto L7;
        return true;
    }

    private /* synthetic */ boolean lambda$setImplLocked$13(Alarm alarm) {
        return adjustDeliveryTimeBasedOnDeviceIdle(alarm);
    }

    boolean hasUseExactAlarmInternal(String packageName, int uid) {
        if (isUseExactAlarmEnabled(packageName, UserHandle.getUserId(uid)) == true) goto L5;
    L7:
        return false;
    L5:
        if (PermissionChecker.checkPermissionForPreflight(getContext(), "android.permission.USE_EXACT_ALARM", -1, uid, packageName) != 0) goto L7;
        return true;
    }

    boolean hasScheduleExactAlarmInternal(String packageName, int uid) {
        long start = this.mStatLogger.getTime();
        if (this.mExactAlarmCandidates.contains(Integer.valueOf(UserHandle.getAppId(uid))) == true) goto L6;
        boolean hasPermission = false;
    L19:
        this.mStatLogger.logDurationStat(1, start);
        return hasPermission;
    L6:
        if (isExactAlarmChangeEnabled(packageName, UserHandle.getUserId(uid)) == true) goto L8;
        hasPermission = false;
        goto L19
    L8:
        boolean r4 = false;
        if (isScheduleExactAlarmDeniedByDefault(packageName, UserHandle.getUserId(uid)) == true) goto L11;
        int mode = this.mAppOps.checkOpNoThrow(107, uid, packageName);
        if (mode == 3) goto L17;
        if (mode == 0) goto L17;
    L18:
        hasPermission = r4;
    L17:
        r4 = true;
        goto L18
    L11:
        if (PermissionChecker.checkPermissionForPreflight(getContext(), "android.permission.SCHEDULE_EXACT_ALARM", -1, uid, packageName) != 0) goto L13;
        r4 = true;
    L13:
        hasPermission = r4;
        goto L19
    }

    boolean isExemptFromMinWindowRestrictions(int uid) {
        return isExemptFromExactAlarmPermissionNoLock(uid);
    }

    boolean isExemptFromExactAlarmPermissionNoLock(int uid) {
        if (Build.IS_DEBUGGABLE == false) goto L8;
        if (Thread.holdsLock(this.mLock) == false) goto L8;
        Slog.wtfStack(TAG, "Alarm lock held while calling into DeviceIdleController");
    L8:
        if (UserHandle.isSameApp(this.mSystemUiUid, uid) == false) goto L10;
    L17:
        return true;
    L10:
        if (UserHandle.isCore(uid) == true) goto L17;
        if (this.mLocalDeviceIdleController == null) goto L17;
        if (this.mLocalDeviceIdleController.isAppOnWhitelist(UserHandle.getAppId(uid)) == true) goto L17;
        return false;
    }

    private static boolean isExactAlarmChangeEnabled(String packageName, int userId) {
        return CompatChanges.isChangeEnabled(171306433, packageName, UserHandle.of(userId));
    }

    private static boolean isUseExactAlarmEnabled(String packageName, int userId) {
        return CompatChanges.isChangeEnabled(218533173, packageName, UserHandle.of(userId));
    }

    private boolean isScheduleExactAlarmDeniedByDefault(String packageName, int userId) {
        return CompatChanges.isChangeEnabled(226439802, packageName, UserHandle.of(userId));
    }

    @NeverCompile
    void dumpImpl(IndentingPrintWriter pw) {
        Object r3 = this.mLock;
        monitor-enter(r3);
        pw.println("Current Alarm Manager state:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mConstants.dump(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Feature Flags:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        boolean r4 = true;
        pw.print(Flags.FLAG_START_USER_BEFORE_SCHEDULED_ALARMS, true);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print(Flags.FLAG_ACQUIRE_WAKELOCK_BEFORE_SEND, false);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("App Standby Parole: " + this.mAppStandbyParole);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        if (this.mAppStateTracker == null) goto L9;
        this.mAppStateTracker.dump(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
    L9:
        long nowELAPSED = this.mInjector.getElapsedRealtimeMillis();     // Catch: Throwable -> L7
        long nowUPTIME = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        long nowRTC = this.mInjector.getCurrentTimeMillis();     // Catch: Throwable -> L7
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L7
        pw.print("nowRTC=");     // Catch: Throwable -> L7
        pw.print(nowRTC);     // Catch: Throwable -> L7
        pw.print("=");     // Catch: Throwable -> L7
        pw.print(sdf.format(new Date(nowRTC)));     // Catch: Throwable -> L7
        pw.print(" nowELAPSED=");     // Catch: Throwable -> L7
        pw.print(nowELAPSED);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("mLastTimeChangeClockTime=");     // Catch: Throwable -> L7
        pw.print(this.mLastTimeChangeClockTime);     // Catch: Throwable -> L7
        pw.print("=");     // Catch: Throwable -> L7
        pw.println(sdf.format(new Date(this.mLastTimeChangeClockTime)));     // Catch: Throwable -> L7
        pw.print("mLastTimeChangeRealtime=");     // Catch: Throwable -> L7
        pw.println(this.mLastTimeChangeRealtime);     // Catch: Throwable -> L7
        pw.print("mLastTickReceived=");     // Catch: Throwable -> L7
        pw.println(sdf.format(new Date(this.mLastTickReceived)));     // Catch: Throwable -> L7
        pw.print("mLastTickSet=");     // Catch: Throwable -> L7
        pw.println(sdf.format(new Date(this.mLastTickSet)));     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Recent TIME_TICK history:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i = this.mNextTickHistory;     // Catch: Throwable -> L7
    L10:
        i = i - 1;     // Catch: Throwable -> L7
        if (i >= 0) goto L13;
        i = 9;
    L13:
        long time = this.mTickHistory[i];     // Catch: Throwable -> L7
        long r15 = 0;
        if (time <= 0) goto L16;
        String r5 = sdf.format(new Date(nowRTC - (nowELAPSED - time)));     // Catch: Throwable -> L7
    L17:
        pw.println(r5);     // Catch: Throwable -> L7
        if (i == this.mNextTickHistory) goto L19;
        nowELAPSED = nowELAPSED;
        r4 = r4;
        goto L10
    L19:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        SystemServiceManager ssm = (SystemServiceManager) LocalServices.getService(SystemServiceManager.class);     // Catch: Throwable -> L7
        if (ssm == null) goto L25;
        pw.println();     // Catch: Throwable -> L7
        pw.print("RuntimeStarted=");     // Catch: Throwable -> L7
        pw.print(sdf.format(new Date((nowRTC - nowELAPSED) + ssm.getRuntimeStartElapsedTime())));     // Catch: Throwable -> L7
        if (ssm.isRuntimeRestarted() == false) goto L24;
        pw.print("  (Runtime restarted)");     // Catch: Throwable -> L7
    L24:
        pw.println();     // Catch: Throwable -> L7
        pw.print("Runtime uptime (elapsed): ");     // Catch: Throwable -> L7
        long nowELAPSED2 = nowELAPSED;
        TimeUtils.formatDuration(nowELAPSED2, ssm.getRuntimeStartElapsedTime(), pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Runtime uptime (uptime): ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(nowUPTIME, ssm.getRuntimeStartUptime(), pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
    L26:
        pw.println();     // Catch: Throwable -> L7
        if (this.mInteractive == true) goto L29;
        pw.print("Time since non-interactive: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(nowELAPSED2 - this.mNonInteractiveStartTime, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
    L29:
        pw.print("Max wakeup delay: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(currentNonWakeupFuzzLocked(nowELAPSED2), pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Time since last dispatch: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(nowELAPSED2 - this.mLastAlarmDeliveryTime, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Next non-wakeup delivery time: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mNextNonWakeupDeliveryTime, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        long nextWakeupRTC = this.mNextWakeup + (nowRTC - nowELAPSED2);     // Catch: Throwable -> L7
        long nextNonWakeupRTC = this.mNextNonWakeup + (nowRTC - nowELAPSED2);     // Catch: Throwable -> L7
        pw.print("Next non-wakeup alarm: ");     // Catch: Throwable -> L7
        long nowRTC2 = nowRTC;
        TimeUtils.formatDuration(this.mNextNonWakeup, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.print(" = ");     // Catch: Throwable -> L7
        pw.print(this.mNextNonWakeup);     // Catch: Throwable -> L7
        pw.print(" = ");     // Catch: Throwable -> L7
        pw.println(sdf.format(new Date(nextNonWakeupRTC)));     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.print("set at ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mNextNonWakeUpSetAt, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Next wakeup alarm: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mNextWakeup, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.print(" = ");     // Catch: Throwable -> L7
        pw.print(this.mNextWakeup);     // Catch: Throwable -> L7
        pw.print(" = ");     // Catch: Throwable -> L7
        pw.println(sdf.format(new Date(nextWakeupRTC)));     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.print("set at ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mNextWakeUpSetAt, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Next kernel non-wakeup alarm: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mInjector.getNextAlarm(3), pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Next kernel wakeup alarm: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mInjector.getNextAlarm(2), pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Last wakeup: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mLastWakeup, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.print(" = ");     // Catch: Throwable -> L7
        pw.println(this.mLastWakeup);     // Catch: Throwable -> L7
        pw.print("Last trigger: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mLastTrigger, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.print(" = ");     // Catch: Throwable -> L7
        pw.println(this.mLastTrigger);     // Catch: Throwable -> L7
        pw.print("Num time change events: ");     // Catch: Throwable -> L7
        pw.println(this.mNumTimeChanged);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("App ids requesting SCHEDULE_EXACT_ALARM: " + this.mExactAlarmCandidates);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Last OP_SCHEDULE_EXACT_ALARM: [");     // Catch: Throwable -> L7
        int i2 = 0;
    L31:
        if (i2 >= this.mLastOpScheduleExactAlarm.size()) goto L35;
        if (i2 <= 0) goto L34;
        pw.print(", ");     // Catch: Throwable -> L7
    L34:
        UserHandle.formatUid(pw, this.mLastOpScheduleExactAlarm.keyAt(i2));     // Catch: Throwable -> L7
        pw.print(":" + AppOpsManager.modeToName(this.mLastOpScheduleExactAlarm.valueAt(i2)));     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L31
    L35:
        pw.println("]");     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Next alarm clock information: ");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        TreeSet<Integer> users = new TreeSet();     // Catch: Throwable -> L7
        int i3 = 0;
    L37:
        if (i3 >= this.mNextAlarmClockForUser.size()) goto L39;
        users.add(Integer.valueOf(this.mNextAlarmClockForUser.keyAt(i3)));     // Catch: Throwable -> L7
        i3 = i3 + 1;     // Catch: Throwable -> L7
        goto L37
    L39:
        int i4 = 0;
    L41:
        if (i4 >= this.mPendingSendNextAlarmClockChangedForUser.size()) goto L43;
        users.add(Integer.valueOf(this.mPendingSendNextAlarmClockChangedForUser.keyAt(i4)));     // Catch: Throwable -> L7
        i4 = i4 + 1;     // Catch: Throwable -> L7
        goto L41
    L43:
        Iterator<Integer> r10 = users.iterator();     // Catch: Throwable -> L7
    L45:
        if (r10.hasNext() == false) goto L55;
        int user = r10.next().intValue();     // Catch: Throwable -> L7
        AlarmManager.AlarmClockInfo next = this.mNextAlarmClockForUser.get(user);     // Catch: Throwable -> L7
        if (next == null) goto L49;
        long r23 = next.getTriggerTime();     // Catch: Throwable -> L7
    L50:
        long time2 = r23;
        long r24 = r15;
        boolean pendingSend = this.mPendingSendNextAlarmClockChangedForUser.get(user);     // Catch: Throwable -> L7
        SystemServiceManager ssm2 = ssm;
        pw.print("user:");     // Catch: Throwable -> L7
        pw.print(user);     // Catch: Throwable -> L7
        pw.print(" pendingSend:");     // Catch: Throwable -> L7
        pw.print(pendingSend);     // Catch: Throwable -> L7
        pw.print(" time:");     // Catch: Throwable -> L7
        long nextWakeupRTC2 = nextWakeupRTC;
        pw.print(time2);     // Catch: Throwable -> L7
        if (time2 <= r24) goto L53;
        pw.print(" = ");     // Catch: Throwable -> L7
        pw.print(sdf.format(new Date(time2)));     // Catch: Throwable -> L7
        pw.print(" = ");     // Catch: Throwable -> L7
        long nowRTC3 = nowRTC2;
        TimeUtils.formatDuration(time2, nowRTC3, pw);     // Catch: Throwable -> L7
    L54:
        pw.println();     // Catch: Throwable -> L7
        nowRTC2 = nowRTC3;
        ssm = ssm2;
        r15 = r24;
        nextNonWakeupRTC = nextNonWakeupRTC;
        nextWakeupRTC = nextWakeupRTC2;
        goto L45
    L53:
        nowRTC3 = nowRTC2;
        goto L54
    L49:
        r23 = r15;
        goto L50
    L55:
        long nowRTC4 = nowRTC2;
        pw.decreaseIndent();     // Catch: Throwable -> L7
        if (this.mAlarmStore.size() <= 0) goto L58;
        pw.println();     // Catch: Throwable -> L7
        this.mAlarmStore.dump(pw, nowELAPSED2, sdf);     // Catch: Throwable -> L7
    L58:
        pw.println();     // Catch: Throwable -> L7
        pw.println("Pending user blocked background alarms: ");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        boolean blocked = false;
        int i5 = 0;
    L60:
        if (i5 >= this.mPendingBackgroundAlarms.size()) goto L68;
        ArrayList<Alarm> blockedAlarms = this.mPendingBackgroundAlarms.valueAt(i5);     // Catch: Throwable -> L7
        if (blockedAlarms == null) goto L66;
        if (blockedAlarms.size() <= 0) goto L66;
        blocked = true;
        dumpAlarmList(pw, blockedAlarms, nowELAPSED2, sdf);     // Catch: Throwable -> L7
    L66:
        i5 = i5 + 1;     // Catch: Throwable -> L7
        goto L60
    L68:
        if (blocked == true) goto L70;
        pw.println("none");     // Catch: Throwable -> L7
    L70:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Pending alarms per uid: [");     // Catch: Throwable -> L7
        int i6 = 0;
    L72:
        if (i6 >= this.mAlarmsPerUid.size()) goto L76;
        if (i6 <= 0) goto L75;
        pw.print(", ");     // Catch: Throwable -> L7
    L75:
        UserHandle.formatUid(pw, this.mAlarmsPerUid.keyAt(i6));     // Catch: Throwable -> L7
        pw.print(":");     // Catch: Throwable -> L7
        pw.print(this.mAlarmsPerUid.valueAt(i6));     // Catch: Throwable -> L7
        i6 = i6 + 1;     // Catch: Throwable -> L7
        goto L72
    L76:
        pw.println("]");     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        if (this.mStartUserBeforeScheduledAlarms == false) goto L79;
        pw.println("Scheduled user wakeups:");     // Catch: Throwable -> L7
        this.mUserWakeupStore.dump(pw, nowELAPSED2);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
    L79:
        pw.println("App Alarm history:");     // Catch: Throwable -> L7
        this.mAppWakeupHistory.dump(pw, nowELAPSED2);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Temporary Quota Reserves:");     // Catch: Throwable -> L7
        this.mTemporaryQuotaReserve.dump(pw, nowELAPSED2);     // Catch: Throwable -> L7
        if (this.mPendingIdleUntil == null) goto L87;
        pw.println();     // Catch: Throwable -> L7
        pw.println("Idle mode state:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.print("Idling until: ");     // Catch: Throwable -> L7
        if (this.mPendingIdleUntil == null) goto L84;
        pw.println(this.mPendingIdleUntil);     // Catch: Throwable -> L7
        this.mPendingIdleUntil.dump(pw, nowELAPSED2, sdf);     // Catch: Throwable -> L7
    L85:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        goto L87
    L84:
        pw.println("null");     // Catch: Throwable -> L7
    L87:
        if (this.mNextWakeFromIdle == null) goto L89;
        pw.println();     // Catch: Throwable -> L7
        pw.print("Next wake from idle: ");     // Catch: Throwable -> L7
        pw.println(this.mNextWakeFromIdle);     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mNextWakeFromIdle.dump(pw, nowELAPSED2, sdf);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
    L89:
        pw.println();     // Catch: Throwable -> L7
        pw.print("Past-due non-wakeup alarms: ");     // Catch: Throwable -> L7
        if (this.mPendingNonWakeupAlarms.size() <= 0) goto L92;
        pw.println(this.mPendingNonWakeupAlarms.size());     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        dumpAlarmList(pw, this.mPendingNonWakeupAlarms, nowELAPSED2, sdf);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
    L93:
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.print("Number of delayed alarms: ");     // Catch: Throwable -> L7
        pw.print(this.mNumDelayedAlarms);     // Catch: Throwable -> L7
        pw.print(", total delay time: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mTotalDelayTime, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Max delay time: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mMaxDelayTime, pw);     // Catch: Throwable -> L7
        pw.print(", max non-interactive time: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mNonInteractiveTime, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print("Broadcast ref count: ");     // Catch: Throwable -> L7
        pw.println(this.mBroadcastRefCount);     // Catch: Throwable -> L7
        pw.print("PendingIntent send count: ");     // Catch: Throwable -> L7
        pw.println(this.mSendCount);     // Catch: Throwable -> L7
        pw.print("PendingIntent finish count: ");     // Catch: Throwable -> L7
        pw.println(this.mSendFinishCount);     // Catch: Throwable -> L7
        pw.print("Listener send count: ");     // Catch: Throwable -> L7
        pw.println(this.mListenerCount);     // Catch: Throwable -> L7
        pw.print("Listener finish count: ");     // Catch: Throwable -> L7
        pw.println(this.mListenerFinishCount);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        if (this.mInFlight.size() <= 0) goto L100;
        pw.println("Outstanding deliveries:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i7 = 0;
    L97:
        if (i7 >= this.mInFlight.size()) goto L99;
        pw.print("#");     // Catch: Throwable -> L7
        pw.print(i7);     // Catch: Throwable -> L7
        pw.print(": ");     // Catch: Throwable -> L7
        pw.println(this.mInFlight.get(i7));     // Catch: Throwable -> L7
        i7 = i7 + 1;     // Catch: Throwable -> L7
        goto L97
    L99:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
    L100:
        pw.println("Allow while idle history:");     // Catch: Throwable -> L7
        this.mAllowWhileIdleHistory.dump(pw, nowELAPSED2);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Allow while idle compat history:");     // Catch: Throwable -> L7
        this.mAllowWhileIdleCompatHistory.dump(pw, nowELAPSED2);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        if (this.mLastPriorityAlarmDispatch.size() <= 0) goto L108;
        pw.println("Last priority alarm dispatches:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i8 = 0;
    L104:
        if (i8 >= this.mLastPriorityAlarmDispatch.size()) goto L106;
        pw.print("UID: ");     // Catch: Throwable -> L7
        UserHandle.formatUid(pw, this.mLastPriorityAlarmDispatch.keyAt(i8));     // Catch: Throwable -> L7
        pw.print(": ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mLastPriorityAlarmDispatch.valueAt(i8), nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        i8 = i8 + 1;     // Catch: Throwable -> L7
        goto L104
    L106:
        pw.decreaseIndent();     // Catch: Throwable -> L7
    L108:
        if (this.mRemovalHistory.size() <= 0) goto L118;
        pw.println("Removal history:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i9 = 0;
    L111:
        if (i9 >= this.mRemovalHistory.size()) goto L116;
        UserHandle.formatUid(pw, this.mRemovalHistory.keyAt(i9));     // Catch: Throwable -> L7
        pw.println(":");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        RemovedAlarm[] historyForUid = (RemovedAlarm[]) this.mRemovalHistory.valueAt(i9).toArray();     // Catch: Throwable -> L7
        int index = historyForUid.length - 1;     // Catch: Throwable -> L7
    L113:
        if (index < 0) goto L115;
        pw.print("#" + (historyForUid.length - index) + ": ");     // Catch: Throwable -> L7
        historyForUid[index].dump(pw, nowELAPSED2, sdf);     // Catch: Throwable -> L7
        index = index + (-1);     // Catch: Throwable -> L7
        goto L113
    L115:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        i9 = i9 + 1;     // Catch: Throwable -> L7
        goto L111
    L116:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
    L118:
        if (this.mLog.dump(pw, "Recent problems:") == false) goto L120;
        pw.println();     // Catch: Throwable -> L7
    L120:
        FilterStats[] topFilters = new FilterStats[10];     // Catch: Throwable -> L7
        Comparator<FilterStats> comparator = new AnonymousClass5(this);     // Catch: Throwable -> L7
        int len = 0;
        int iu = 0;
    L122:
        if (iu >= this.mBroadcastStats.size()) goto L151;
        ArrayMap<String, BroadcastStats> uidStats = this.mBroadcastStats.valueAt(iu);     // Catch: Throwable -> L7
        int ip = 0;
    L124:
        boolean blocked2 = blocked;
        if (ip >= uidStats.size()) goto L149;
        BroadcastStats bs = uidStats.valueAt(ip);     // Catch: Throwable -> L7
        long nowRTC5 = nowRTC4;
        int is = 0;
    L128:
        if (is >= bs.filterStats.size()) goto L148;
        FilterStats fs = bs.filterStats.valueAt(is);     // Catch: Throwable -> L7
        if (len <= 0) goto L132;
        int r20 = Arrays.binarySearch(topFilters, 0, len, fs, comparator);     // Catch: Throwable -> L7
    L133:
        int pos = r20;
        if (pos >= 0) goto L136;
        int is2 = -pos;
        int pos2 = is2 - 1;     // Catch: Throwable -> L7
    L137:
        int is3 = topFilters.length;     // Catch: Throwable -> L7
        if (pos2 >= is3) goto L147;
        int copylen = (topFilters.length - pos2) - 1;     // Catch: Throwable -> L7
        if (copylen <= 0) goto L143;
        System.arraycopy(topFilters, pos2, topFilters, pos2 + 1, copylen);     // Catch: Throwable -> L7
    L143:
        topFilters[pos2] = fs;     // Catch: Throwable -> L7
        if (len >= topFilters.length) goto L147;
        len = len + 1;     // Catch: Throwable -> L7
    L147:
        is = is + 1;     // Catch: Throwable -> L7
        bs = bs;
        goto L128
    L136:
        pos2 = pos;
        goto L137
    L132:
        r20 = 0;
        goto L133
    L148:
        ip = ip + 1;     // Catch: Throwable -> L7
        blocked = blocked2;
        nowRTC4 = nowRTC5;
        goto L124
    L149:
        iu = iu + 1;     // Catch: Throwable -> L7
        blocked = blocked2;
        goto L122
    L151:
        if (len <= 0) goto L159;
        pw.println("Top Alarms:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i10 = 0;
    L153:
        if (i10 >= len) goto L158;
        FilterStats fs2 = topFilters[i10];     // Catch: Throwable -> L7
        if (fs2.nesting <= 0) goto L157;
        pw.print("*ACTIVE* ");     // Catch: Throwable -> L7
    L157:
        TimeUtils.formatDuration(fs2.aggregateTime, pw);     // Catch: Throwable -> L7
        pw.print(" running, ");     // Catch: Throwable -> L7
        pw.print(fs2.numWakeup);     // Catch: Throwable -> L7
        pw.print(" wakeups, ");     // Catch: Throwable -> L7
        pw.print(fs2.count);     // Catch: Throwable -> L7
        pw.print(" alarms: ");     // Catch: Throwable -> L7
        UserHandle.formatUid(pw, fs2.mBroadcastStats.mUid);     // Catch: Throwable -> L7
        pw.print(":");     // Catch: Throwable -> L7
        pw.print(fs2.mBroadcastStats.mPackageName);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.print(fs2.mTag);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        i10 = i10 + 1;     // Catch: Throwable -> L7
        goto L153
    L158:
        pw.decreaseIndent();     // Catch: Throwable -> L7
    L159:
        pw.println();     // Catch: Throwable -> L7
        pw.println("Alarm Stats:");     // Catch: Throwable -> L7
        ArrayList<FilterStats> tmpFilters = new ArrayList();     // Catch: Throwable -> L7
        int iu2 = 0;
    L161:
        if (iu2 >= this.mBroadcastStats.size()) goto L181;
        ArrayMap<String, BroadcastStats> uidStats2 = this.mBroadcastStats.valueAt(iu2);     // Catch: Throwable -> L7
        int ip2 = 0;
    L164:
        if (ip2 >= uidStats2.size()) goto L180;
        BroadcastStats bs2 = uidStats2.valueAt(ip2);     // Catch: Throwable -> L7
        if (bs2.nesting <= 0) goto L168;
        pw.print("*ACTIVE* ");     // Catch: Throwable -> L7
    L168:
        UserHandle.formatUid(pw, bs2.mUid);     // Catch: Throwable -> L7
        pw.print(":");     // Catch: Throwable -> L7
        pw.print(bs2.mPackageName);     // Catch: Throwable -> L7
        pw.print(" ");     // Catch: Throwable -> L7
        FilterStats[] topFilters2 = topFilters;
        int iu3 = iu2;
        TimeUtils.formatDuration(bs2.aggregateTime, pw);     // Catch: Throwable -> L7
        pw.print(" running, ");     // Catch: Throwable -> L7
        pw.print(bs2.numWakeup);     // Catch: Throwable -> L7
        pw.println(" wakeups:");     // Catch: Throwable -> L7
        tmpFilters.clear();     // Catch: Throwable -> L7
        int is4 = 0;
    L170:
        if (is4 >= bs2.filterStats.size()) goto L172;
        tmpFilters.add(bs2.filterStats.valueAt(is4));     // Catch: Throwable -> L7
        is4 = is4 + 1;     // Catch: Throwable -> L7
        goto L170
    L172:
        Collections.sort(tmpFilters, comparator);     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        int i11 = 0;
    L174:
        if (i11 >= tmpFilters.size()) goto L179;
        FilterStats fs3 = tmpFilters.get(i11);     // Catch: Throwable -> L7
        ArrayList<FilterStats> tmpFilters2 = tmpFilters;
        if (fs3.nesting <= 0) goto L178;
        pw.print("*ACTIVE* ");     // Catch: Throwable -> L7
    L178:
        TimeUtils.formatDuration(fs3.aggregateTime, pw);     // Catch: Throwable -> L7
        pw.print(" ");     // Catch: Throwable -> L7
        pw.print(fs3.numWakeup);     // Catch: Throwable -> L7
        pw.print(" wakes ");     // Catch: Throwable -> L7
        pw.print(fs3.count);     // Catch: Throwable -> L7
        pw.print(" alarms, last ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(fs3.lastTime, nowELAPSED2, pw);     // Catch: Throwable -> L7
        pw.println(":");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.print(fs3.mTag);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        i11 = i11 + 1;     // Catch: Throwable -> L7
        tmpFilters = tmpFilters2;
        goto L174
    L179:
        pw.decreaseIndent();     // Catch: Throwable -> L7
        ip2 = ip2 + 1;     // Catch: Throwable -> L7
        topFilters = topFilters2;
        iu2 = iu3;
        tmpFilters = tmpFilters;
        goto L164
    L180:
        iu2 = iu2 + 1;     // Catch: Throwable -> L7
        goto L161
    L181:
        pw.println();     // Catch: Throwable -> L7
        this.mStatLogger.dump(pw);     // Catch: Throwable -> L7
        sHeartbeatStats.dump(pw);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L92:
        pw.println("(none)");     // Catch: Throwable -> L7
        goto L93
    L25:
        nowELAPSED2 = nowELAPSED;
        goto L26
    L16:
        r5 = "-";
    L7:
        th = move-exception;
        throw th;
    }

    void dumpProto(FileDescriptor fd) {
        final AlarmManagerService r1 = this;
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        Object r9 = r1.mLock;
        monitor-enter(r9);
        long nowRTC = r1.mInjector.getCurrentTimeMillis();     // Catch: Throwable -> L7
        long nowElapsed = r1.mInjector.getElapsedRealtimeMillis();     // Catch: Throwable -> L7
        proto.write(1112396529665L, nowRTC);     // Catch: Throwable -> L7
        proto.write(1112396529666L, nowElapsed);     // Catch: Throwable -> L7
        proto.write(1112396529667L, r1.mLastTimeChangeClockTime);     // Catch: Throwable -> L7
        proto.write(1112396529668L, r1.mLastTimeChangeRealtime);     // Catch: Throwable -> L7
        r1.mConstants.dumpProto(proto, 1146756268037L);     // Catch: Throwable -> L7
        if (r1.mAppStateTracker == null) goto L9;
        r1.mAppStateTracker.dumpProto(proto, 1146756268038L);     // Catch: Throwable -> L7
    L9:
        proto.write(1133871366151L, r1.mInteractive);     // Catch: Throwable -> L7
        if (r1.mInteractive == true) goto L12;
        proto.write(1112396529672L, nowElapsed - r1.mNonInteractiveStartTime);     // Catch: Throwable -> L7
        proto.write(1112396529673L, r1.currentNonWakeupFuzzLocked(nowElapsed));     // Catch: Throwable -> L7
        proto.write(1112396529674L, nowElapsed - r1.mLastAlarmDeliveryTime);     // Catch: Throwable -> L7
        proto.write(1112396529675L, nowElapsed - r1.mNextNonWakeupDeliveryTime);     // Catch: Throwable -> L7
    L12:
        proto.write(1112396529676L, r1.mNextNonWakeup - nowElapsed);     // Catch: Throwable -> L7
        proto.write(1112396529677L, r1.mNextWakeup - nowElapsed);     // Catch: Throwable -> L7
        proto.write(1112396529678L, nowElapsed - r1.mLastWakeup);     // Catch: Throwable -> L7
        proto.write(1112396529679L, nowElapsed - r1.mNextWakeUpSetAt);     // Catch: Throwable -> L7
        proto.write(1112396529680L, r1.mNumTimeChanged);     // Catch: Throwable -> L7
        TreeSet<Integer> users = new TreeSet();     // Catch: Throwable -> L7
        int nextAlarmClockForUserSize = r1.mNextAlarmClockForUser.size();     // Catch: Throwable -> L7
        int i = 0;
    L13:
        if (i >= nextAlarmClockForUserSize) goto L15;
        users.add(Integer.valueOf(r1.mNextAlarmClockForUser.keyAt(i)));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L13
    L15:
        int pendingSendNextAlarmClockChangedForUserSize = r1.mPendingSendNextAlarmClockChangedForUser.size();     // Catch: Throwable -> L7
        int i2 = 0;
    L16:
        if (i2 >= pendingSendNextAlarmClockChangedForUserSize) goto L18;
        users.add(Integer.valueOf(r1.mPendingSendNextAlarmClockChangedForUser.keyAt(i2)));     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L16
    L18:
        Iterator<Integer> r3 = users.iterator();     // Catch: Throwable -> L7
    L20:
        if (r3.hasNext() == false) goto L26;
        int user = r3.next().intValue();     // Catch: Throwable -> L7
        AlarmManager.AlarmClockInfo next = r1.mNextAlarmClockForUser.get(user);     // Catch: Throwable -> L7
        if (next == null) goto L24;
        long r16 = next.getTriggerTime();     // Catch: Throwable -> L7
    L25:
        long time = r16;
        boolean pendingSend = r1.mPendingSendNextAlarmClockChangedForUser.get(user);     // Catch: Throwable -> L7
        long aToken = proto.start(2246267895826L);     // Catch: Throwable -> L7
        proto.write(1120986464257L, user);     // Catch: Throwable -> L7
        proto.write(1133871366146L, pendingSend);     // Catch: Throwable -> L7
        proto.write(1112396529667L, time);     // Catch: Throwable -> L7
        proto.end(aToken);     // Catch: Throwable -> L7
        r3 = r3;
        nowRTC = nowRTC;
        goto L20
    L24:
        r16 = 0;
        goto L25
    L26:
        r1.mAlarmStore.dumpProto(proto, nowElapsed);     // Catch: Throwable -> L7
        int i3 = 0;
    L28:
        if (i3 >= r1.mPendingBackgroundAlarms.size()) goto L37;
        ArrayList<Alarm> blockedAlarms = r1.mPendingBackgroundAlarms.valueAt(i3);     // Catch: Throwable -> L7
        if (blockedAlarms == null) goto L35;
        Iterator<Alarm> r13 = blockedAlarms.iterator();     // Catch: Throwable -> L7
    L33:
        if (r13.hasNext() == false) goto L35;
        Alarm a = r13.next();     // Catch: Throwable -> L7
        a.dumpDebug(proto, 2246267895828L, nowElapsed);     // Catch: Throwable -> L7
    L35:
        i3 = i3 + 1;     // Catch: Throwable -> L7
        goto L28
    L37:
        if (r1.mPendingIdleUntil == null) goto L40;
        r1.mPendingIdleUntil.dumpDebug(proto, 1146756268053L, nowElapsed);     // Catch: Throwable -> L7
    L40:
        if (r1.mNextWakeFromIdle == null) goto L42;
        r1.mNextWakeFromIdle.dumpDebug(proto, 1146756268055L, nowElapsed);     // Catch: Throwable -> L7
    L42:
        Iterator<Alarm> r2 = r1.mPendingNonWakeupAlarms.iterator();     // Catch: Throwable -> L7
    L44:
        if (r2.hasNext() == false) goto L46;
        Alarm a2 = r2.next();     // Catch: Throwable -> L7
        a2.dumpDebug(proto, 2246267895832L, nowElapsed);     // Catch: Throwable -> L7
        goto L44
    L46:
        proto.write(1120986464281L, r1.mNumDelayedAlarms);     // Catch: Throwable -> L7
        proto.write(1112396529690L, r1.mTotalDelayTime);     // Catch: Throwable -> L7
        proto.write(1112396529691L, r1.mMaxDelayTime);     // Catch: Throwable -> L7
        proto.write(1112396529692L, r1.mNonInteractiveTime);     // Catch: Throwable -> L7
        proto.write(1120986464285L, r1.mBroadcastRefCount);     // Catch: Throwable -> L7
        proto.write(1120986464286L, r1.mSendCount);     // Catch: Throwable -> L7
        proto.write(1120986464287L, r1.mSendFinishCount);     // Catch: Throwable -> L7
        proto.write(1120986464288L, r1.mListenerCount);     // Catch: Throwable -> L7
        proto.write(1120986464289L, r1.mListenerFinishCount);     // Catch: Throwable -> L7
        Iterator<InFlight> r4 = r1.mInFlight.iterator();     // Catch: Throwable -> L7
    L48:
        if (r4.hasNext() == false) goto L50;
        InFlight f = r4.next();     // Catch: Throwable -> L7
        f.dumpDebug(proto, 2246267895842L);     // Catch: Throwable -> L7
        goto L48
    L50:
        r1.mLog.dumpDebug(proto, 1146756268069L);     // Catch: Throwable -> L7
        FilterStats[] topFilters = new FilterStats[10];     // Catch: Throwable -> L7
        Comparator<FilterStats> comparator = new AnonymousClass6(r1);     // Catch: Throwable -> L7
        int len = 0;
        int iu = 0;
    L52:
        if (iu >= r1.mBroadcastStats.size()) goto L79;
        ArrayMap<String, BroadcastStats> uidStats = r1.mBroadcastStats.valueAt(iu);     // Catch: Throwable -> L7
        int ip = 0;
    L55:
        if (ip >= uidStats.size()) goto L78;
        BroadcastStats bs = uidStats.valueAt(ip);     // Catch: Throwable -> L7
        int is = 0;
    L57:
        TreeSet<Integer> users2 = users;
        if (is >= bs.filterStats.size()) goto L77;
        FilterStats fs = bs.filterStats.valueAt(is);     // Catch: Throwable -> L7
        int iu2 = iu;
        int pos = 0;
        if (len <= 0) goto L63;
        pos = Arrays.binarySearch(topFilters, 0, len, fs, comparator);     // Catch: Throwable -> L7
    L63:
        if (pos >= 0) goto L67;
        pos = (-pos) - 1;     // Catch: Throwable -> L7
    L67:
        if (pos >= topFilters.length) goto L75;
        int copylen = (topFilters.length - pos) - 1;     // Catch: Throwable -> L7
        if (copylen <= 0) goto L72;
        System.arraycopy(topFilters, pos, topFilters, pos + 1, copylen);     // Catch: Throwable -> L7
    L72:
        topFilters[pos] = fs;     // Catch: Throwable -> L7
        if (len >= topFilters.length) goto L76;
        len = len + 1;     // Catch: Throwable -> L7
    L76:
        is = is + 1;     // Catch: Throwable -> L7
        users = users2;
        iu = iu2;
        nowElapsed = nowElapsed;
        goto L57
    L75:
        nowElapsed = nowElapsed;
        goto L76
    L77:
        ip = ip + 1;     // Catch: Throwable -> L7
        users = users2;
        goto L55
    L78:
        iu = iu + 1;     // Catch: Throwable -> L7
        goto L52
    L79:
        int i4 = 0;
    L80:
        if (i4 >= len) goto L82;
        long token = proto.start(2246267895846L);     // Catch: Throwable -> L7
        FilterStats fs2 = topFilters[i4];     // Catch: Throwable -> L7
        proto.write(1120986464257L, fs2.mBroadcastStats.mUid);     // Catch: Throwable -> L7
        proto.write(1138166333442L, fs2.mBroadcastStats.mPackageName);     // Catch: Throwable -> L7
        fs2.dumpDebug(proto, 1146756268035L);     // Catch: Throwable -> L7
        proto.end(token);     // Catch: Throwable -> L7
        i4 = i4 + 1;     // Catch: Throwable -> L7
        goto L80
    L82:
        ArrayList<FilterStats> tmpFilters = new ArrayList();     // Catch: Throwable -> L7
        int iu3 = 0;
    L84:
        if (iu3 >= r1.mBroadcastStats.size()) goto L99;
        ArrayMap<String, BroadcastStats> uidStats2 = r1.mBroadcastStats.valueAt(iu3);     // Catch: Throwable -> L7
        int ip2 = 0;
    L87:
        if (ip2 >= uidStats2.size()) goto L97;
        long token2 = proto.start(2246267895847L);     // Catch: Throwable -> L7
        BroadcastStats bs2 = uidStats2.valueAt(ip2);     // Catch: Throwable -> L7
        FilterStats[] topFilters2 = topFilters;
        bs2.dumpDebug(proto, 1146756268033L);     // Catch: Throwable -> L7
        tmpFilters.clear();     // Catch: Throwable -> L7
        int is2 = 0;
    L90:
        if (is2 >= bs2.filterStats.size()) goto L92;
        tmpFilters.add(bs2.filterStats.valueAt(is2));     // Catch: Throwable -> L7
        is2 = is2 + 1;     // Catch: Throwable -> L7
        goto L90
    L92:
        Collections.sort(tmpFilters, comparator);     // Catch: Throwable -> L7
        Iterator<FilterStats> r5 = tmpFilters.iterator();     // Catch: Throwable -> L7
    L94:
        if (r5.hasNext() == false) goto L96;
        r5.next().dumpDebug(proto, 2246267895810L);     // Catch: Throwable -> L7
        tmpFilters = tmpFilters;
        r5 = r5;
        goto L94
    L96:
        proto.end(token2);     // Catch: Throwable -> L7
        ip2 = ip2 + 1;     // Catch: Throwable -> L7
        topFilters = topFilters2;
        tmpFilters = tmpFilters;
        goto L87
    L97:
        iu3 = iu3 + 1;     // Catch: Throwable -> L7
        r1 = this;
        goto L84
    L99:
        monitor-exit(r9);     // Catch: Throwable -> L7
        proto.flush();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    long getNextWakeFromIdleTimeImpl() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mNextWakeFromIdle == null) goto L9;
        long r1 = this.mNextWakeFromIdle.getWhenElapsed();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = Long.MAX_VALUE;
        goto L10
    }

    private boolean isIdlingImpl() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingIdleUntil == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    AlarmManager.AlarmClockInfo getNextAlarmClockImpl(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AlarmManager.AlarmClockInfo r1 = this.mNextAlarmClockForUser.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateNextAlarmClockLocked() {
        if (this.mNextAlarmClockMayChange == true) goto L5;
        return;
    L5:
        this.mNextAlarmClockMayChange = false;
        SparseArray<AlarmManager.AlarmClockInfo> nextForUser = this.mTmpSparseAlarmClockArray;
        nextForUser.clear();
        ArrayList<Alarm> allAlarms = this.mAlarmStore.asList();
        Iterator<Alarm> r2 = allAlarms.iterator();
    L7:
        if (r2.hasNext() == false) goto L22;
        Alarm a = r2.next();
        if (a.alarmClock == null) goto L7;
        int userId = UserHandle.getUserId(a.uid);
        AlarmManager.AlarmClockInfo current = this.mNextAlarmClockForUser.get(userId);
        if (DEBUG_ALARM_CLOCK == false) goto L14;
        Log.v(TAG, "Found AlarmClockInfo " + a.alarmClock + " at " + formatNextAlarm(getContext(), a.alarmClock, userId) + " for user " + userId);
    L14:
        if (nextForUser.get(userId) == null) goto L15;
        if (a.alarmClock.equals(current) == false) goto L7;
        if (current.getTriggerTime() > nextForUser.get(userId).getTriggerTime()) goto L7;
        nextForUser.put(userId, current);
        goto L7
    L15:
        nextForUser.put(userId, a.alarmClock);
        goto L7
    L22:
        int newUserCount = nextForUser.size();
        int i = 0;
    L23:
        if (i >= newUserCount) goto L28;
        AlarmManager.AlarmClockInfo newAlarm = nextForUser.valueAt(i);
        int userId2 = nextForUser.keyAt(i);
        AlarmManager.AlarmClockInfo currentAlarm = this.mNextAlarmClockForUser.get(userId2);
        if (newAlarm.equals(currentAlarm) == true) goto L27;
        updateNextAlarmInfoForUserLocked(userId2, newAlarm);
    L27:
        i = i + 1;
        goto L23
    L28:
        int oldUserCount = this.mNextAlarmClockForUser.size();
        int i2 = oldUserCount - 1;
    L29:
        if (i2 < 0) goto L35;
        int userId3 = this.mNextAlarmClockForUser.keyAt(i2);
        if (nextForUser.get(userId3) != null) goto L33;
        updateNextAlarmInfoForUserLocked(userId3, null);
    L33:
        i2 = i2 - 1;
        goto L29
    }

    private void updateNextAlarmInfoForUserLocked(int userId, AlarmManager.AlarmClockInfo alarmClock) {
        if (alarmClock == null) goto L13;
        if (DEBUG_ALARM_CLOCK == false) goto L7;
        Log.v(TAG, "Next AlarmClockInfoForUser(" + userId + "): " + formatNextAlarm(getContext(), alarmClock, userId));
    L7:
        this.mNextAlarmClockForUser.put(userId, alarmClock);
        if (this.mStartUserBeforeScheduledAlarms == true) goto L10;
    L21:
        this.mPendingSendNextAlarmClockChangedForUser.put(userId, true);
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessage(2);
        return;
    L10:
        if (shouldAddWakeupForUser(userId) == false) goto L21;
        this.mUserWakeupStore.addUserWakeup(userId, convertToElapsed(this.mNextAlarmClockForUser.get(userId).getTriggerTime(), 1));
        goto L21
    L13:
        if (DEBUG_ALARM_CLOCK == false) goto L16;
        Log.v(TAG, "Next AlarmClockInfoForUser(" + userId + "): None");
    L16:
        if (this.mStartUserBeforeScheduledAlarms == true) goto L18;
    L20:
        this.mNextAlarmClockForUser.remove(userId);
        goto L21
    L18:
        if (this.mActivityManagerInternal.isUserRunning(userId, 0) == false) goto L20;
        this.mUserWakeupStore.removeUserWakeup(userId);
        goto L20
    }

    boolean shouldAddWakeupForUser(int userId) {
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        if (umInternal.getUserInfo(userId) != null) goto L5;
    L12:
        return false;
    L5:
        if (umInternal.getUserInfo(userId).isGuest() == true) goto L12;
        if (userId != 0) goto L9;
        return false;
    L9:
        if (umInternal.getUserInfo(userId).isFull() == false) goto L14;
        return true;
    L14:
        return false;
    }

    private void sendNextAlarmClockChanged() {
        SparseArray<AlarmManager.AlarmClockInfo> pendingUsers = this.mHandlerSparseAlarmClockArray;
        pendingUsers.clear();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int n = this.mPendingSendNextAlarmClockChangedForUser.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= n) goto L9;
        int userId = this.mPendingSendNextAlarmClockChangedForUser.keyAt(i);     // Catch: Throwable -> L7
        pendingUsers.append(userId, this.mNextAlarmClockForUser.get(userId));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mPendingSendNextAlarmClockChangedForUser.clear();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        int n2 = pendingUsers.size();
        int i2 = 0;
    L12:
        if (i2 >= n2) goto L15;
        int userId2 = pendingUsers.keyAt(i2);
        AlarmManager.AlarmClockInfo alarmClock = pendingUsers.valueAt(i2);
        android.provider.Settings.System.putStringForUser(getContext().getContentResolver(), "next_alarm_formatted", formatNextAlarm(getContext(), alarmClock, userId2), userId2);
        getContext().sendBroadcastAsUser(NEXT_ALARM_CLOCK_CHANGED_INTENT, new UserHandle(userId2));
        i2 = i2 + 1;
        goto L12
    L15:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String formatNextAlarm(Context context, AlarmManager.AlarmClockInfo info, int userId) {
        if (DateFormat.is24HourFormat(context, userId) == false) goto L5;
        String skeleton = "EHm";
    L6:
        String pattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), skeleton);
        if (info != null) goto L10;
        return "";
    L10:
        return DateFormat.format(pattern, info.getTriggerTime()).toString();
    L5:
        skeleton = "Ehma";
        goto L6
    }

    void rescheduleKernelAlarmsLocked() {
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        long nextNonWakeup = 0;
        if (this.mAlarmStore.size() <= 0) goto L29;
        long firstWakeup = this.mAlarmStore.getNextWakeupDeliveryTime();
        if (this.mStartUserBeforeScheduledAlarms == true) goto L7;
    L13:
        long first = this.mAlarmStore.getNextDeliveryTime();
        if (localLOGV == false) goto L16;
    L17:
        Slog.v(TAG, "rescheduleKernelAlarmsLocked firstWakeup=" + firstWakeup + ", firstElapsed=" + first + ", mNextWakeup=" + this.mNextWakeup);
    L19:
        if (firstWakeup == 0) goto L26;
        this.mNextWakeup = firstWakeup;
        this.mNextWakeUpSetAt = nowElapsed;
        setLocked(2, firstWakeup);
        if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L23;
    L24:
        Slog.v(TAG, "set ELAPSED_REALTIME_WAKEUP at " + HeartbeatStats.intToDotedString(this.mNextWakeup));
        goto L26
    L23:
        if (HeartbeatStats.DEBUG_TRACE_ALARM == true) goto L24;
    L26:
        if (first == firstWakeup) goto L29;
        nextNonWakeup = first;
        goto L29
    L16:
        if (HeartbeatStats.DEBUG_TRACE_ALARM == false) goto L19;
    L7:
        if (this.mUserWakeupStore == null) goto L13;
        long firstUserWakeup = this.mUserWakeupStore.getNextWakeupTime();
        if (firstUserWakeup < 0) goto L13;
        if (firstUserWakeup >= firstWakeup) goto L13;
        firstWakeup = firstUserWakeup;
    L29:
        if (this.mPendingNonWakeupAlarms.size() <= 0) goto L36;
        if (nextNonWakeup != 0) goto L33;
    L34:
        nextNonWakeup = this.mNextNonWakeupDeliveryTime;
        goto L36
    L33:
        if (this.mNextNonWakeupDeliveryTime < nextNonWakeup) goto L34;
    L36:
        if (nextNonWakeup == 0) goto L39;
        this.mNextNonWakeup = nextNonWakeup;
        this.mNextNonWakeUpSetAt = nowElapsed;
        setLocked(3, nextNonWakeup);
        return;
    }

    void removeExactAlarmsOnPermissionRevoked(final int uid, final String packageName, boolean killUid) {
        if (isExemptFromExactAlarmPermissionNoLock(uid) == false) goto L5;
        return;
    L5:
        if (isExactAlarmChangeEnabled(packageName, UserHandle.getUserId(uid)) == false) goto L22;
        Slog.w(TAG, "Package " + packageName + ", uid " + uid + " lost permission to set exact alarms!");
        Predicate<Alarm> whichAlarms = new AlarmManagerService$$ExternalSyntheticLambda25(uid, packageName);
        Object r1 = this.mLock;
        monitor-enter(r1);
        removeAlarmsInternalLocked(whichAlarms, 2);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (killUid == false) goto L21;
        PermissionManagerService.killUid(UserHandle.getAppId(uid), UserHandle.getUserId(uid), "schedule_exact_alarm revoked");
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeExactAlarmsOnPermissionRevoked$14(int uid, String packageName, Alarm a) {
        if (a.uid == uid) goto L5;
    L9:
        return false;
    L5:
        if (a.packageName.equals(packageName) == false) goto L9;
        if (a.windowLength != 0) goto L9;
        return true;
    }

    private void removeAlarmsInternalLocked(Predicate<Alarm> whichAlarms, int reason) {
        long nowRtc = this.mInjector.getCurrentTimeMillis();
        long nowElapsed = this.mInjector.getElapsedRealtimeMillis();
        ArrayList<Alarm> removedAlarms = this.mAlarmStore.remove(whichAlarms);
        boolean removedFromStore = !removedAlarms.isEmpty();
        int i = this.mPendingBackgroundAlarms.size() - 1;
    L3:
        if (i < 0) goto L14;
        ArrayList<Alarm> alarmsForUid = this.mPendingBackgroundAlarms.valueAt(i);
        int j = alarmsForUid.size() - 1;
    L5:
        if (j < 0) goto L10;
        Alarm alarm = alarmsForUid.get(j);
        if (whichAlarms.test(alarm) == false) goto L9;
        removedAlarms.add(alarmsForUid.remove(j));
    L9:
        j = j - 1;
        goto L5
    L10:
        int j2 = alarmsForUid.size();
        if (j2 != 0) goto L13;
        this.mPendingBackgroundAlarms.removeAt(i);
    L13:
        i = i - 1;
        goto L3
    L14:
        int i2 = this.mPendingNonWakeupAlarms.size() - 1;
    L15:
        if (i2 < 0) goto L20;
        Alarm a = this.mPendingNonWakeupAlarms.get(i2);
        if (whichAlarms.test(a) == false) goto L19;
        removedAlarms.add(this.mPendingNonWakeupAlarms.remove(i2));
    L19:
        i2 = i2 - 1;
        goto L15
    L20:
        Iterator<Alarm> r10 = removedAlarms.iterator();
    L22:
        if (r10.hasNext() == false) goto L38;
        Alarm removed = r10.next();
        decrementAlarmCount(removed.uid, 1);
        if (removed.listener == null) goto L27;
        removed.listener.asBinder().unlinkToDeath(this.mListenerDeathRecipient, 0);
    L27:
        if (RemovedAlarm.isLoggable(reason) == false) goto L22;
        if (isTimeTickAlarm(removed) == false) goto L32;
        Slog.wtf(TAG, "Removed TIME_TICK alarm");
    L32:
        RingBuffer<RemovedAlarm> bufferForUid = this.mRemovalHistory.get(removed.uid);
        if (bufferForUid != null) goto L36;
        bufferForUid = new RingBuffer(RemovedAlarm.class, 10);
        this.mRemovalHistory.put(removed.uid, bufferForUid);
    L36:
        bufferForUid.append(new RemovedAlarm(removed, reason, nowRtc, nowElapsed));
        goto L22
    L38:
        if (removedFromStore == false) goto L69;
        boolean idleUntilUpdated = false;
        if (this.mPendingIdleUntil == null) goto L45;
        if (whichAlarms.test(this.mPendingIdleUntil) == false) goto L45;
        this.mPendingIdleUntil = null;
        idleUntilUpdated = true;
    L45:
        if (this.mNextWakeFromIdle != null) goto L47;
    L51:
        if (idleUntilUpdated == false) goto L53;
        this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda18(this));
    L53:
        rescheduleKernelAlarmsLocked();
        updateNextAlarmClockLocked();
        return;
    L47:
        if (whichAlarms.test(this.mNextWakeFromIdle) == false) goto L51;
        this.mNextWakeFromIdle = this.mAlarmStore.getNextWakeFromIdleAlarm();
        if (this.mPendingIdleUntil == null) goto L51;
        idleUntilUpdated = idleUntilUpdated | this.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda17(this));
        goto L51
    }

    private /* synthetic */ boolean lambda$removeAlarmsInternalLocked$15(Alarm alarm) {
        if (alarm == this.mPendingIdleUntil) goto L5;
    L7:
        return false;
    L5:
        if (adjustIdleUntilTime(alarm) == false) goto L7;
        return true;
    }

    private /* synthetic */ boolean lambda$removeAlarmsInternalLocked$16(Alarm alarm) {
        return adjustDeliveryTimeBasedOnDeviceIdle(alarm);
    }

    void removeLocked(final PendingIntent operation, final IAlarmListener directReceiver, int reason) {
        if (operation != null) goto L8;
        if (directReceiver != null) goto L8;
        if (localLOGV == false) goto L10;
        Slog.w(TAG, "requested remove() of null operation", new RuntimeException("here"));
        return;
    L10:
        return;
    L8:
        removeAlarmsInternalLocked(new AlarmManagerService$$ExternalSyntheticLambda16(operation, directReceiver), reason);
    }

    private static /* synthetic */ boolean lambda$removeLocked$17(PendingIntent operation, IAlarmListener directReceiver, Alarm a) {
        return a.matches(operation, directReceiver);
    }

    void removeLocked(final int uid, int reason) {
        if (uid != 1000) goto L6;
        Slog.w(TAG, "removeLocked: Shouldn't for UID=" + uid);
        return;
    L6:
        removeAlarmsInternalLocked(new AlarmManagerService$$ExternalSyntheticLambda19(uid), reason);
    }

    private static /* synthetic */ boolean lambda$removeLocked$18(int uid, Alarm a) {
        if (a.uid != uid) goto L5;
        return true;
    L5:
        return false;
    }

    void removeLocked(final String packageName, int reason) {
        if (packageName == null) goto L4;
        removeAlarmsInternalLocked(new AlarmManagerService$$ExternalSyntheticLambda9(packageName), reason);
        return;
    L4:
        if (localLOGV == false) goto L9;
        Slog.w(TAG, "requested remove() of null packageName", new RuntimeException("here"));
        return;
    }

    private static /* synthetic */ boolean lambda$removeLocked$19(String packageName, Alarm a) {
        return a.matches(packageName);
    }

    void removeForStoppedLocked(final int uid) {
        if (uid != 1000) goto L6;
        Slog.w(TAG, "removeForStoppedLocked: Shouldn't for UID=" + uid);
        return;
    L6:
        Predicate<Alarm> whichAlarms = new AlarmManagerService$$ExternalSyntheticLambda15(this, uid);
        removeAlarmsInternalLocked(whichAlarms, 0);
    }

    private /* synthetic */ boolean lambda$removeForStoppedLocked$20(int uid, Alarm a) {
        if (a.uid == uid) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityManagerInternal.isAppStartModeDisabled(uid, a.packageName) == false) goto L7;
        return true;
    }

    void removeUserLocked(final int userHandle) {
        if (userHandle != 0) goto L5;
        Slog.w(TAG, "Ignoring attempt to remove system-user state!");
        return;
    L5:
        Predicate<Alarm> whichAlarms = new AlarmManagerService$$ExternalSyntheticLambda7(userHandle);
        removeAlarmsInternalLocked(whichAlarms, 0);
        int i = this.mLastPriorityAlarmDispatch.size() - 1;
    L6:
        if (i < 0) goto L11;
        if (UserHandle.getUserId(this.mLastPriorityAlarmDispatch.keyAt(i)) != userHandle) goto L10;
        this.mLastPriorityAlarmDispatch.removeAt(i);
    L10:
        i = i - 1;
        goto L6
    L11:
        int i2 = this.mRemovalHistory.size() - 1;
    L12:
        if (i2 < 0) goto L17;
        if (UserHandle.getUserId(this.mRemovalHistory.keyAt(i2)) != userHandle) goto L16;
        this.mRemovalHistory.removeAt(i2);
    L16:
        i2 = i2 - 1;
        goto L12
    L17:
        int i3 = this.mLastOpScheduleExactAlarm.size() - 1;
    L18:
        if (i3 < 0) goto L24;
        if (UserHandle.getUserId(this.mLastOpScheduleExactAlarm.keyAt(i3)) != userHandle) goto L22;
        this.mLastOpScheduleExactAlarm.removeAt(i3);
    L22:
        i3 = i3 - 1;
        goto L18
    }

    private static /* synthetic */ boolean lambda$removeUserLocked$21(int userHandle, Alarm a) {
        if (UserHandle.getUserId(a.uid) != userHandle) goto L5;
        return true;
    L5:
        return false;
    }

    void interactiveStateChangedLocked(boolean interactive) {
        if (this.mInteractive == interactive) goto L20;
        this.mInteractive = interactive;
        long nowELAPSED = this.mInjector.getElapsedRealtimeMillis();
        if (interactive == true) goto L7;
        this.mNonInteractiveStartTime = nowELAPSED;
        return;
    L7:
        if (this.mPendingNonWakeupAlarms.size() <= 0) goto L13;
        long thisDelayTime = nowELAPSED - this.mStartCurrentDelayTime;
        this.mTotalDelayTime += thisDelayTime;
        if (this.mMaxDelayTime >= thisDelayTime) goto L11;
        this.mMaxDelayTime = thisDelayTime;
    L11:
        ArrayList<Alarm> triggerList = new ArrayList(this.mPendingNonWakeupAlarms);
        deliverAlarmsLocked(triggerList, nowELAPSED);
        this.mPendingNonWakeupAlarms.clear();
    L13:
        if (this.mNonInteractiveStartTime <= 0) goto L17;
        long dur = nowELAPSED - this.mNonInteractiveStartTime;
        if (dur <= this.mNonInteractiveTime) goto L17;
        this.mNonInteractiveTime = dur;
    L17:
        this.mHandler.post(new AlarmManagerService$$ExternalSyntheticLambda0(this));
        return;
    }

    private /* synthetic */ void lambda$interactiveStateChangedLocked$22() {
        getContext().sendBroadcastAsUser(this.mTimeTickIntent, UserHandle.ALL, null, this.mTimeTickOptions);
    }

    boolean lookForPackageLocked(String packageName, int uid) {
        Iterator<Alarm> r0 = this.mAlarmStore.asList().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Alarm alarm = r0.next();
        if (alarm.matches(packageName) == false) goto L4;
        if (alarm.creatorUid != uid) goto L4;
        return true;
    L11:
        ArrayList<Alarm> alarmsForUid = this.mPendingBackgroundAlarms.get(uid);
        if (alarmsForUid == null) goto L20;
        Iterator<Alarm> r1 = alarmsForUid.iterator();
    L15:
        if (r1.hasNext() == false) goto L20;
        if (r1.next().matches(packageName) == false) goto L15;
        return true;
    L20:
        Iterator<Alarm> r2 = this.mPendingNonWakeupAlarms.iterator();
    L22:
        if (r2.hasNext() == false) goto L29;
        Alarm alarm2 = r2.next();
        if (alarm2.matches(packageName) == false) goto L22;
        if (alarm2.creatorUid != uid) goto L22;
        return true;
    L29:
        return false;
    }

    private void setLocked(int type, long when) {
        if (this.mInjector.isAlarmDriverPresent() == false) goto L5;
        this.mInjector.setAlarm(type, when);
        return;
    L5:
        Message msg = Message.obtain();
        msg.what = 1;
        this.mHandler.removeMessages(msg.what);
        this.mHandler.sendMessageAtTime(msg, when);
    }

    static final void dumpAlarmList(IndentingPrintWriter ipw, ArrayList<Alarm> list, long nowELAPSED, SimpleDateFormat sdf) {
        int n = list.size();
        int i = n - 1;
    L3:
        if (i < 0) goto L6;
        Alarm a = list.get(i);
        String label = Alarm.typeToString(a.type);
        ipw.print(label);
        ipw.print(" #");
        ipw.print(n - i);
        ipw.print(": ");
        ipw.println(a);
        ipw.increaseIndent();
        a.dump(ipw, nowELAPSED, sdf);
        ipw.decreaseIndent();
        i = i - 1;
        goto L3
    }

    private static boolean isExemptFromBatterySaver(Alarm alarm) {
        if (alarm.alarmClock == null) goto L6;
        return true;
    L6:
        if (alarm.operation == null) goto L13;
        if (alarm.operation.isActivity() == false) goto L10;
    L11:
        return true;
    L10:
        if (alarm.operation.isForegroundService() == true) goto L11;
    L13:
        if (UserHandle.isCore(alarm.creatorUid) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean isBackgroundRestricted(Alarm alarm) {
        if (alarm.alarmClock == null) goto L6;
        return false;
    L6:
        if (alarm.operation != null) goto L8;
    L10:
        String sourcePackage = alarm.sourcePackage;
        int sourceUid = alarm.creatorUid;
        if (UserHandle.isCore(sourceUid) == false) goto L14;
        return false;
    L14:
        if (this.mAppStateTracker != null) goto L16;
        return false;
    L16:
        if (this.mAppStateTracker.areAlarmsRestricted(sourceUid, sourcePackage) == false) goto L20;
        return true;
    L20:
        return false;
    L8:
        if (alarm.operation.isActivity() == false) goto L10;
        return false;
    }

    int triggerAlarmsLocked(ArrayList<Alarm> triggerList, long nowELAPSED) {
        final AlarmManagerService r0 = this;
        ArrayList<Alarm> r1 = triggerList;
        long r2 = nowELAPSED;
        ArrayList<Alarm> pendingAlarms = r0.mAlarmStore.removePendingAlarms(r2);
        Iterator<Alarm> r24 = pendingAlarms.iterator();
        int wakeUps = 0;
    L4:
        if (r24.hasNext() == false) goto L38;
        Alarm alarm = r24.next();
        if (r0.isBackgroundRestricted(alarm) == true) goto L8;
        alarm.count = 1;
        r1.add(alarm);
        if ((alarm.flags & 2) == 0) goto L22;
        if (r0.mPendingIdleUntil == null) goto L19;
        int r4 = 1;
    L20:
        EventLogTags.writeDeviceIdleWakeFromIdle(r4, alarm.statsTag);
        goto L22
    L19:
        r4 = 0;
    L22:
        if (r0.mPendingIdleUntil != alarm) goto L25;
        r0.mPendingIdleUntil = null;
        r0.mAlarmStore.updateAlarmDeliveries(new AlarmManagerService$$ExternalSyntheticLambda8(r0));
    L25:
        if (r0.mNextWakeFromIdle != alarm) goto L28;
        r0.mNextWakeFromIdle = r0.mAlarmStore.getNextWakeFromIdleAlarm();
    L28:
        if (alarm.repeatInterval <= 0) goto L30;
        alarm.count = (int) (((long) alarm.count) + ((r2 - alarm.getRequestedElapsed()) / alarm.repeatInterval));
        long delta = ((long) alarm.count) * alarm.repeatInterval;
        long nextElapsed = alarm.getRequestedElapsed() + delta;
        long nextMaxElapsed = maxTriggerTime(r2, nextElapsed, alarm.repeatInterval);
        Alarm alarm2 = alarm;
        r0 = this;
        r0.setImplLocked(alarm.type, alarm.origWhen + delta, nextElapsed, nextMaxElapsed - nextElapsed, alarm.repeatInterval, alarm.operation, null, null, alarm.flags, alarm.workSource, alarm.alarmClock, alarm.uid, alarm.packageName, null, -1, alarm.processName, false, false);
    L31:
        Alarm alarm3 = alarm2;
        if (alarm3.wakeup == false) goto L35;
        wakeUps = wakeUps + 1;
    L35:
        if (alarm3.alarmClock == null) goto L37;
        r0.mNextAlarmClockMayChange = true;
    L37:
        r1 = triggerList;
        r2 = nowELAPSED;
        goto L4
    L30:
        alarm2 = alarm;
        goto L31
    L8:
        if (DEBUG_BG_LIMIT == false) goto L10;
        Slog.d(TAG, "Deferring alarm " + alarm + " due to user forced app standby");
    L10:
        ArrayList<Alarm> alarmsForUid = r0.mPendingBackgroundAlarms.get(alarm.creatorUid);
        if (alarmsForUid != null) goto L13;
        alarmsForUid = new ArrayList();
        r0.mPendingBackgroundAlarms.put(alarm.creatorUid, alarmsForUid);
    L13:
        alarmsForUid.add(alarm);
        goto L4
    L38:
        calculateDeliveryPriorities(triggerList);
        Collections.sort(triggerList, r0.mAlarmDispatchComparator);
        if (localLOGV == false) goto L44;
        int i = 0;
    L42:
        if (i >= triggerList.size()) goto L44;
        Slog.v(TAG, "Triggering alarm #" + i + ": " + triggerList.get(i));
        i = i + 1;
    L44:
        return wakeUps;
    }

    private /* synthetic */ boolean lambda$triggerAlarmsLocked$23(Alarm a) {
        return adjustDeliveryTimeBasedOnDeviceIdle(a);
    }

    long currentNonWakeupFuzzLocked(long nowELAPSED) {
        long timeSinceOn = nowELAPSED - this.mNonInteractiveStartTime;
        if (timeSinceOn >= 300000) goto L10;
        if (HeartbeatStats.sEnabled == true) goto L8;
        return 120000;
    L8:
        return 300000;
    L10:
        if (timeSinceOn >= 1800000) goto L13;
        return HeartbeatStats.MAX_NAT_TIME_MS;
    L13:
        return 3600000;
    }

    boolean checkAllowNonWakeupDelayLocked(long nowELAPSED) {
        if (this.mConstants.DELAY_NONWAKEUP_ALARMS_WHILE_SCREEN_OFF == true) goto L6;
        return false;
    L6:
        if (this.mInteractive == false) goto L9;
        return false;
    L9:
        if (this.mLastAlarmDeliveryTime > 0) goto L12;
        return false;
    L12:
        if (this.mPendingNonWakeupAlarms.size() > 0) goto L14;
    L16:
        long timeSinceLast = nowELAPSED - this.mLastAlarmDeliveryTime;
        if (timeSinceLast > currentNonWakeupFuzzLocked(nowELAPSED)) goto L20;
        return true;
    L20:
        return false;
    L14:
        if (this.mNextNonWakeupDeliveryTime >= nowELAPSED) goto L16;
        return false;
    }

    void deliverAlarmsLocked(ArrayList<Alarm> triggerList, long nowELAPSED) {
        this.mLastAlarmDeliveryTime = nowELAPSED;
        System.currentTimeMillis();
        int i = 0;
    L4:
        if (i >= triggerList.size()) goto L19;
        Alarm alarm = triggerList.get(i);
        if (alarm.wakeup == false) goto L8;
        Trace.traceBegin(131072, "Dispatch wakeup alarm to " + alarm.packageName);
    L22:
        if (localLOGV == false) goto L14;
        Slog.v(TAG, "sending alarm " + alarm);     // Catch: RuntimeException -> L12
    L14:
        this.mActivityManagerInternal.noteAlarmStart(alarm.operation, alarm.workSource, alarm.uid, alarm.statsTag);     // Catch: RuntimeException -> L12
        this.mDeliveryTracker.deliverLocked(alarm, nowELAPSED);     // Catch: RuntimeException -> L12
    L17:
        Trace.traceEnd(131072);
        decrementAlarmCount(alarm.uid, 1);
        i = i + 1;
    L12:
        e = move-exception;
        Slog.w(TAG, "Failure sending alarm.", e);
        goto L17
    L8:
        Trace.traceBegin(131072, "Dispatch non-wakeup alarm to " + alarm.packageName);
        goto L22
    L19:
        if (HeartbeatStats.sEnabled == false) goto L27;
        sHeartbeatStats.checkHeartbeatValidationLocked();
        return;
    }

    static boolean isExemptFromAppStandby(Alarm a) {
        if (a.alarmClock == null) goto L5;
    L10:
        return true;
    L5:
        if (UserHandle.isCore(a.creatorUid) == true) goto L10;
        if ((a.flags & 12) != 0) goto L10;
        return false;
    }

    static boolean isExemptFromPowerSaver(Alarm a) {
        if (a.alarmClock == null) goto L5;
        return true;
    L5:
        if (UserHandle.isCore(a.creatorUid) == true) goto L17;
        IAlarmManagerServiceOptEx r0 = SysOptApexBridge.getFactory().getAlarmMS();
        int r2 = a.creatorUid;
        String r3 = a.sourcePackage;
        if ((a.flags & 12) == 0) goto L9;
        boolean r4 = true;
    L11:
        if (r0.isExemptFromPowerSaver(r2, r3, r4) == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r4 = false;
        goto L11
    L17:
        return true;
    }

    private static void increment(SparseIntArray array, int key) {
        int index = array.indexOfKey(key);
        if (index < 0) goto L5;
        array.setValueAt(index, array.valueAt(index) + 1);
        return;
    L5:
        array.put(key, 1);
    }

    private void logAlarmBatchDelivered(int alarms, int wakeups, SparseIntArray countsPerUid, SparseIntArray wakeupCountsPerUid) {
        int[] uids = new int[countsPerUid.size()];
        int[] countsArray = new int[countsPerUid.size()];
        int[] wakeupCountsArray = new int[countsPerUid.size()];
        int i = 0;
    L4:
        if (i >= countsPerUid.size()) goto L6;
        uids[i] = countsPerUid.keyAt(i);
        countsArray[i] = countsPerUid.valueAt(i);
        wakeupCountsArray[i] = wakeupCountsPerUid.get(uids[i], 0);
        i = i + 1;
        goto L4
    L6:
        MetricsHelper.pushAlarmBatchDelivered(alarms, wakeups, uids, countsArray, wakeupCountsArray);
    }

    void setWakelockWorkSource(WorkSource ws, int knownUid, String tag, boolean first) {
        PowerManager.WakeLock r1 = this.mWakeLock;     // Catch: Exception -> L11
        if (first == false) goto L6;
        String r2 = tag;
    L7:
        r1.setHistoryTag(r2);     // Catch: Exception -> L11
        if (ws == null) goto L13;
        this.mWakeLock.setWorkSource(ws);     // Catch: Exception -> L11
        return;
    L13:
        if (knownUid < 0) goto L17;
        this.mWakeLock.setWorkSource(new WorkSource(knownUid));     // Catch: Exception -> L11
        return;
    L6:
        r2 = null;
    L17:
        this.mWakeLock.setWorkSource(null);
    }

    private static int getAlarmAttributionUid(Alarm alarm) {
        if (alarm.workSource == null) goto L9;
        if (alarm.workSource.isEmpty() == true) goto L9;
        return alarm.workSource.getAttributionUid();
    L9:
        return alarm.creatorUid;
    }

    private Bundle getAlarmOperationBundle(Alarm alarm) {
        if (alarm.mIdleOptions == null) goto L7;
        return alarm.mIdleOptions;
    L7:
        if (alarm.operation.isActivity() == false) goto L11;
        return this.mActivityOptsRestrictBal.toBundle();
    L11:
        return this.mBroadcastOptsRestrictBal.toBundle();
    }

    private final BroadcastStats getStatsLocked(PendingIntent pi) {
        String pkg = pi.getCreatorPackage();
        int uid = pi.getCreatorUid();
        return getStatsLocked(uid, pkg);
    }

    private final BroadcastStats getStatsLocked(int uid, String pkgName) {
        ArrayMap<String, BroadcastStats> uidStats = this.mBroadcastStats.get(uid);
        if (uidStats != null) goto L5;
        uidStats = new ArrayMap();
        this.mBroadcastStats.put(uid, uidStats);
    L5:
        BroadcastStats bs = uidStats.get(pkgName);
        if (bs != null) goto L9;
        BroadcastStats bs2 = new BroadcastStats(uid, pkgName);
        uidStats.put(pkgName, bs2);
        return bs2;
    L9:
        return bs;
    }

    private void incrementAlarmCount(int uid) {
        increment(this.mAlarmsPerUid, uid);
    }

    private void sendScheduleExactAlarmPermissionStateChangedBroadcast(String packageName, int userId) {
        Intent i = new Intent("android.app.action.SCHEDULE_EXACT_ALARM_PERMISSION_STATE_CHANGED");
        i.addFlags(872415232);
        i.setPackage(packageName);
        BroadcastOptions opts = BroadcastOptions.makeBasic();
        opts.setTemporaryAppAllowlist(this.mActivityManagerInternal.getBootTimeTempAllowListDuration(), 0, 207, "");
        getContext().sendBroadcastAsUser(i, UserHandle.of(userId), null, opts.toBundle());
    }

    private void decrementAlarmCount(int uid, int decrement) {
        int oldCount = 0;
        int uidIndex = this.mAlarmsPerUid.indexOfKey(uid);
        if (uidIndex < 0) goto L8;
        oldCount = this.mAlarmsPerUid.valueAt(uidIndex);
        if (oldCount <= decrement) goto L7;
        this.mAlarmsPerUid.setValueAt(uidIndex, oldCount - decrement);
        goto L8
    L7:
        this.mAlarmsPerUid.removeAt(uidIndex);
    L8:
        if (oldCount >= decrement) goto L11;
        Slog.wtf(TAG, "Attempt to decrement existing alarm count " + oldCount + " by " + decrement + " for uid " + uid);
        return;
    }
}

package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.BackgroundStartPrivileges;
import android.app.ForegroundServiceDelegationOptions;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.ForegroundServiceTypePolicy;
import android.app.IApplicationThread;
import android.app.IForegroundServiceObserver;
import android.app.IServiceConnection;
import android.app.InvalidForegroundServiceTypeException;
import android.app.MissingForegroundServiceTypeException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteServiceException;
import android.app.ServiceStartArgs;
import android.app.admin.DevicePolicyEventLogger;
import android.app.compat.CompatChanges;
import android.appwidget.AppWidgetManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.DeadObjectException;
import android.os.FrozenObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerExemptionManager;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StabTrace;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.TransactionTooLargeException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.EventLog;
import android.util.Pair;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.webkit.WebViewZygote;
import com.android.internal.app.procstats.ServiceState;
import com.android.internal.os.SomeArgs;
import com.android.internal.os.TimeoutRecord;
import com.android.internal.os.TransferPipe;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FastPrintWriter;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.AppStateTracker;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.uri.NeededUriGrants;
import com.android.server.utils.AnrTimer;
import com.android.server.wm.ActivityRecord;
import com.android.server.wm.ActivityServiceConnectionsHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import vendor.qti.hardware.servicetracker.V1_0.IServicetracker;
import vendor.qti.hardware.servicetrackeraidl.ClientData;
import vendor.qti.hardware.servicetrackeraidl.ServiceData;

/* JADX INFO: loaded from: classes.dex */
public final class ActiveServices {
    private static final String AIDL_SERVICE = "vendor.qti.hardware.servicetrackeraidl.IServicetracker/default";
    private static final SimpleDateFormat DATE_FORMATTER = null;
    private static final boolean DEBUG_DELAYED_SERVICE = false;
    private static final boolean DEBUG_DELAYED_STARTS = false;
    private static final boolean DEBUG_SHORT_SERVICE = false;
    static final int DEFAULT_SERVICE_CACHED_BIND_POLICY_FLAG = 3;
    static final int DEFAULT_SERVICE_NO_BUMP_BIND_POLICY_FLAG = 7;
    static final long FGS_BG_START_RESTRICTION_CHANGE_ID = 170668199;
    public static final long FGS_BOOT_COMPLETED_RESTRICTIONS = 296558535;
    static final int FGS_IMMEDIATE_DISPLAY_MASK = 54;
    static final long FGS_INTRODUCE_TIME_LIMITS = 317799821;
    public static final long FGS_SAW_RESTRICTIONS = 319471980;
    static final long FGS_START_EXCEPTION_CHANGE_ID = 174041399;
    static final int FGS_STOP_REASON_STOP_FOREGROUND = 1;
    static final int FGS_STOP_REASON_STOP_SERVICE = 2;
    static final int FGS_STOP_REASON_UNKNOWN = 0;
    static final long FGS_TYPE_CHECK_FOR_INSTANT_APPS = 261055255;
    static final int LAST_ANR_LIFETIME_DURATION_MSECS = 7200000;
    private static final boolean LOG_SERVICE_START_STOP = false;
    public static final long MEDIA_FGS_STATE_TRANSITION = 281762171;
    static final int SERVICE_BIND_OOMADJ_POLICY_FREEZE_CALLER = 8;
    static final int SERVICE_BIND_OOMADJ_POLICY_LEGACY = 0;
    static final int SERVICE_BIND_OOMADJ_POLICY_SKIP_OOM_UPDATE_ON_BIND = 2;
    static final int SERVICE_BIND_OOMADJ_POLICY_SKIP_OOM_UPDATE_ON_CONNECT = 4;
    static final int SERVICE_BIND_OOMADJ_POLICY_SKIP_OOM_UPDATE_ON_CREATE = 1;
    private static boolean SERVICE_RESCHEDULE = false;
    private static final String TAG = "ActivityManager";
    private static final String TAG_MU = "ActivityManager_MU";
    static final String TAG_SERVICE = "ActivityManager";
    private static final String TAG_SERVICE_EXECUTING = "ActivityManager";
    private static boolean mIsAIDLSupported;
    public static BoostFramework mPerf;
    static final AtomicReference<Pair<Integer, Integer>> sNumForegroundServices = null;
    private final boolean isLowRamDevice;
    private final ProcessAnrTimer mActiveServiceAnrTimer;
    ArraySet<String> mAllowListWhileInUsePermissionInFgs;
    final ActivityManagerService mAm;
    AppStateTracker mAppStateTracker;
    AppWidgetManagerInternal mAppWidgetManagerInternal;
    private long mBindServiceSeqCounter;
    String mCachedDeviceProvisioningPackage;
    final ArrayList<ServiceRecord> mDestroyingServices;
    private final ForegroundServiceTypeLoggerModule mFGSLogger;
    private final SparseArray<AppOpCallback> mFgsAppOpCallbacks;
    final SparseLongArray mFgsDeferralEligible;
    private boolean mFgsDeferralRateLimited;
    final ArrayMap<ForegroundServiceDelegation, ServiceRecord> mFgsDelegations;
    final RemoteCallbackList<IForegroundServiceObserver> mFgsObservers;
    String mLastAnrDump;
    final Runnable mLastAnrDumpClearer;
    final int mMaxStartingBackground;
    private ArrayMap<ServiceRecord, ArrayList<Runnable>> mPendingBringups;
    final ArrayList<ServiceRecord> mPendingFgsNotifications;
    final ArrayList<ServiceRecord> mPendingServices;
    private final Runnable mPostDeferredFGSNotifications;
    private final ArraySet<String> mRestartBackoffDisabledPackages;
    final ArrayList<ServiceRecord> mRestartingServices;
    boolean mScreenOn;
    final ArrayMap<IBinder, ArrayList<ConnectionRecord>> mServiceConnections;
    private final ServiceAnrTimer mServiceFGAnrTimer;
    final SparseArray<ServiceMap> mServiceMap;
    private IServicetracker mServicetracker;
    private vendor.qti.hardware.servicetrackeraidl.IServicetracker mServicetracker_aidl;
    private final ServiceAnrTimer mShortFGSAnrTimer;
    final SparseArray<SparseArray<ServiceRecord.TimeLimitedFgsInfo>> mTimeLimitedFgsInfo;
    private ArrayList<ServiceRecord> mTmpCollectionResults;

    static final class ActiveForegroundApp {
        boolean mAppOnTop;
        long mEndTime;
        long mHideTime;
        CharSequence mLabel;
        int mNumActive;
        String mPackageName;
        boolean mShownWhileScreenOn;
        boolean mShownWhileTop;
        long mStartTime;
        long mStartVisibleTime;
        int mUid;

        ActiveForegroundApp() {
        }
    }

    private static final class AppOpCallback {
        private static final int[] LOGGED_AP_OPS = null;
        private final SparseIntArray mAcceptedOps;
        private final SparseIntArray mAppOpModes;
        private final AppOpsManager mAppOpsManager;
        private final Object mCounterLock;
        private boolean mDestroyed;
        private int mNumFgs;
        private final AppOpsManager.OnOpNotedInternalListener mOpNotedCallback;
        private final AppOpsManager.OnOpStartedListener mOpStartedCallback;
        private final ProcessRecord mProcessRecord;
        private final SparseIntArray mRejectedOps;

        /* JADX INFO: renamed from: -$$Nest$mincrementOpCountIfNeeded, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1098$$Nest$mincrementOpCountIfNeeded(AppOpCallback r0, int r1, int r2, int r3) {
            r0.incrementOpCountIfNeeded(r1, r2, r3);
        }

        static {
            LOGGED_AP_OPS = new int[]{0, 1, 27, 26};
        }

        AppOpCallback(ProcessRecord r, AppOpsManager appOpsManager) {
            this.mAcceptedOps = new SparseIntArray();
            this.mRejectedOps = new SparseIntArray();
            this.mCounterLock = new Object();
            this.mAppOpModes = new SparseIntArray();
            int r0 = 0;
            this.mNumFgs = 0;
            this.mDestroyed = false;
            this.mOpNotedCallback = new AnonymousClass1(this);
            this.mOpStartedCallback = new AnonymousClass2(this);
            this.mProcessRecord = r;
            this.mAppOpsManager = appOpsManager;
            int[] r1 = LOGGED_AP_OPS;
            int r2 = r1.length;
        L3:
            if (r0 >= r2) goto L5;
            int op = r1[r0];
            int mode = appOpsManager.unsafeCheckOpRawNoThrow(op, r.uid, r.info.packageName);
            this.mAppOpModes.put(op, mode);
            r0 = r0 + 1;
            goto L3
        }

        private void incrementOpCountIfNeeded(int op, int uid, int result) {
            if (uid == this.mProcessRecord.uid) goto L5;
            return;
        L5:
            if (isNotTop() == false) goto L12;
            if (result != 0) goto L8;
            boolean r0 = true;
        L9:
            incrementOpCount(op, r0);
            return;
        L8:
            r0 = false;
            goto L9
        }

        private boolean isNotTop() {
            if (this.mProcessRecord.mState.getCurProcState() == 2) goto L5;
            return true;
        L5:
            return false;
        }

        private void incrementOpCount(int op, boolean allowed) {
            Object r0 = this.mCounterLock;
            monitor-enter(r0);
            if (allowed == false) goto L8;
            SparseIntArray counter = this.mAcceptedOps;     // Catch: Throwable -> L6
        L9:
            int index = counter.indexOfKey(op);     // Catch: Throwable -> L6
            if (index >= 0) goto L12;
            counter.put(op, 1);     // Catch: Throwable -> L6
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L12:
            counter.setValueAt(index, counter.valueAt(index) + 1);     // Catch: Throwable -> L6
            goto L13
        L8:
            counter = this.mRejectedOps;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        void registerLocked() {
            if (isObsoleteLocked() == false) goto L6;
            Slog.wtf("ActivityManager", "Trying to register on a stale AppOpCallback.");
            return;
        L6:
            this.mNumFgs++;
            if (this.mNumFgs != 1) goto L10;
            this.mAppOpsManager.startWatchingNoted(LOGGED_AP_OPS, this.mOpNotedCallback);
            this.mAppOpsManager.startWatchingStarted(LOGGED_AP_OPS, this.mOpStartedCallback);
            return;
        }

        void unregisterLocked() {
            this.mNumFgs--;
            if (this.mNumFgs > 0) goto L6;
            this.mDestroyed = true;
            logFinalValues();
            this.mAppOpsManager.stopWatchingNoted(this.mOpNotedCallback);
            this.mAppOpsManager.stopWatchingStarted(this.mOpStartedCallback);
            return;
        }

        boolean isObsoleteLocked() {
            return this.mDestroyed;
        }

        private void logFinalValues() {
            Object r1 = this.mCounterLock;
            monitor-enter(r1);
            int[] r0 = LOGGED_AP_OPS;     // Catch: Throwable -> L11
            int r2 = r0.length;     // Catch: Throwable -> L11
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L13;
            int op = r0[r3];     // Catch: Throwable -> L11
            int acceptances = this.mAcceptedOps.get(op);     // Catch: Throwable -> L11
            int rejections = this.mRejectedOps.get(op);     // Catch: Throwable -> L11
            if (acceptances > 0) goto L9;
            if (rejections > 0) goto L9;
        L10:
            r3 = r3 + 1;     // Catch: Throwable -> L11
        L9:
            FrameworkStatsLog.write(256, this.mProcessRecord.uid, op, modeToEnum(this.mAppOpModes.get(op)), acceptances, rejections);     // Catch: Throwable -> L11
            goto L10
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private static int modeToEnum(int mode) {
            switch(mode) {
                case 0: goto L9;
                case 1: goto L7;
                case 2: goto L3;
                case 3: goto L3;
                case 4: goto L5;
                default: goto L3;
            };
        L3:
            return 0;
        L5:
            return 3;
        L7:
            return 2;
        L9:
            return 1;
        }
    }

    class BackgroundRestrictedListener implements AppStateTracker.BackgroundRestrictedAppListener {
        final /* synthetic */ ActiveServices this$0;

        BackgroundRestrictedListener(ActiveServices this$0) {
            this.this$0 = this$0;
        }

        public void updateBackgroundRestrictedForUidPackage(int uid, String packageName, boolean restricted) {
            ActivityManagerService r0 = this.this$0.mAm;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mAm.mProcessList.updateBackgroundRestrictedForUidPackageLocked(uid, packageName, restricted);     // Catch: Throwable -> L9
            if (ActiveServices.m1092$$Nest$misForegroundServiceAllowedInBackgroundRestricted(this.this$0, uid, packageName) == false) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            if (ActiveServices.m1093$$Nest$misTempAllowedByAlarmClock(this.this$0, uid) == true) goto L11;
            this.this$0.stopAllForegroundServicesLocked(uid, packageName);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface FgsStopReason {
    }

    private class MediaProjectionFgsTypeCustomPermission extends ForegroundServiceTypePolicy.ForegroundServiceTypePermission {
        final /* synthetic */ ActiveServices this$0;

        MediaProjectionFgsTypeCustomPermission(ActiveServices r1) {
            this.this$0 = r1;
            super("Media projection screen capture permission");
        }

        public int checkPermission(Context context, int callerUid, int callerPid, String packageName, boolean allowWhileInUse) {
            if (this.this$0.mAm.isAllowedMediaProjectionNoOpCheck(callerUid) == false) goto L5;
            return 0;
        L5:
            return -1;
        }
    }

    private static class ProcessAnrTimer extends AnrTimer<ProcessRecord> {
        @Override // com.android.server.utils.AnrTimer
        public /* bridge */ /* synthetic */ int getPid(ProcessRecord r1) {
            return getPid2(r1);
        }

        @Override // com.android.server.utils.AnrTimer
        public /* bridge */ /* synthetic */ int getUid(ProcessRecord r1) {
            return getUid2(r1);
        }

        ProcessAnrTimer(ActivityManagerService am, int msg, String label) {
            am.getClass();
            super(am.mHandler, msg, label);
        }

        ProcessAnrTimer(ActivityManagerService am, int msg, String label, AnrTimer.Args args) {
            am.getClass();
            super(am.mHandler, msg, label, args);
        }

        /* JADX INFO: renamed from: getPid, reason: avoid collision after fix types in other method */
        public int getPid2(ProcessRecord proc) {
            return proc.getPid();
        }

        /* JADX INFO: renamed from: getUid, reason: avoid collision after fix types in other method */
        public int getUid2(ProcessRecord proc) {
            return proc.uid;
        }
    }

    private static class ServiceAnrTimer extends AnrTimer<ServiceRecord> {
        @Override // com.android.server.utils.AnrTimer
        public /* bridge */ /* synthetic */ int getPid(ServiceRecord r1) {
            return getPid2(r1);
        }

        @Override // com.android.server.utils.AnrTimer
        public /* bridge */ /* synthetic */ int getUid(ServiceRecord r1) {
            return getUid2(r1);
        }

        ServiceAnrTimer(ActivityManagerService am, int msg, String label) {
            am.getClass();
            super(am.mHandler, msg, label);
        }

        ServiceAnrTimer(ActivityManagerService am, int msg, String label, AnrTimer.Args args) {
            am.getClass();
            super(am.mHandler, msg, label, args);
        }

        /* JADX INFO: renamed from: getPid, reason: avoid collision after fix types in other method */
        public int getPid2(ServiceRecord service) {
            if (service.app != null) goto L7;
            return 0;
        L7:
            return service.app.getPid();
        }

        /* JADX INFO: renamed from: getUid, reason: avoid collision after fix types in other method */
        public int getUid2(ServiceRecord service) {
            if (service.appInfo != null) goto L7;
            return 0;
        L7:
            return service.appInfo.uid;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ServiceBindingOomAdjPolicy {
    }

    final class ServiceDumper {
        private final String[] args;
        private final boolean dumpAll;
        private final String dumpPackage;
        private final FileDescriptor fd;
        private final ActivityManagerService.ItemMatcher matcher;
        private boolean needSep;
        private final long nowReal;
        private boolean printed;
        private boolean printedAnything;
        private final PrintWriter pw;
        private final ArrayList<ServiceRecord> services;
        final /* synthetic */ ActiveServices this$0;

        ServiceDumper(ActiveServices this$0, FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, String dumpPackage) {
            ActiveServices r1 = this$0;
            this.this$0 = r1;
            this.services = new ArrayList();
            this.nowReal = SystemClock.elapsedRealtime();
            int r4 = 0;
            this.needSep = false;
            this.printedAnything = false;
            this.printed = false;
            this.fd = fd;
            this.pw = pw;
            this.args = args;
            this.dumpAll = dumpAll;
            this.dumpPackage = dumpPackage;
            this.matcher = new ActivityManagerService.ItemMatcher();
            this.matcher.build(args, opti);
            int[] users = r1.mAm.mUserController.getUsers();
            int r10 = users.length;
        L3:
            if (r4 >= r10) goto L19;
            int user = users[r4];
            ServiceMap smap = ActiveServices.m1091$$Nest$mgetServiceMapLocked(r1, user);
            if (smap.mServicesByInstanceName.size() <= 0) goto L18;
            int si = 0;
        L8:
            if (si >= smap.mServicesByInstanceName.size()) goto L18;
            ServiceRecord r = smap.mServicesByInstanceName.valueAt(si);
            if (this.matcher.match(r, r.name) == false) goto L17;
            if (dumpPackage != null) goto L14;
        L16:
            this.services.add(r);
            goto L17
        L14:
            if (dumpPackage.equals(r.appInfo.packageName) == true) goto L16;
        L17:
            si = si + 1;
        L18:
            r4 = r4 + 1;
            r1 = this$0;
            goto L3
        }

        private void dumpHeaderLocked() {
            this.pw.println("ACTIVITY MANAGER SERVICES (dumpsys activity services)");
            if (this.this$0.mLastAnrDump == null) goto L6;
            this.pw.println("  Last ANR service:");
            this.pw.print(this.this$0.mLastAnrDump);
            this.pw.println();
            return;
        }

        void dumpLocked() {
            dumpHeaderLocked();
            int[] users = this.this$0.mAm.mUserController.getUsers();     // Catch: Exception -> L11
            int r1 = users.length;     // Catch: Exception -> L11
            int r3 = 0;
        L4:
            if (r3 >= r1) goto L27;
            int user = users[r3];     // Catch: Exception -> L11
            int serviceIdx = 0;
        L7:
            if (serviceIdx >= this.services.size()) goto L13;
            if (this.services.get(serviceIdx).userId == user) goto L13;
            serviceIdx = serviceIdx + 1;     // Catch: Exception -> L11
        L13:
            this.printed = false;     // Catch: Exception -> L11
            if (serviceIdx >= this.services.size()) goto L23;
            this.needSep = false;     // Catch: Exception -> L11
        L17:
            if (serviceIdx >= this.services.size()) goto L22;
            ServiceRecord r = this.services.get(serviceIdx);     // Catch: Exception -> L11
            serviceIdx = serviceIdx + 1;     // Catch: Exception -> L11
            if (r.userId != user) goto L22;
            dumpServiceLocalLocked(r);     // Catch: Exception -> L11
        L22:
            this.needSep |= this.printed;     // Catch: Exception -> L11
        L23:
            dumpUserRemainsLocked(user);     // Catch: Exception -> L11
            r3 = r3 + 1;
        L27:
            dumpRemainsLocked();
            return;
        L11:
            e = move-exception;
            Slog.w("ActivityManager", "Exception in dumpServicesLocked", e);
            goto L27
        }

        void dumpWithClient() {
            ActivityManagerService r0 = this.this$0.mAm;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            dumpHeaderLocked();     // Catch: Throwable -> L58
            monitor-exit(r0);     // Catch: Throwable -> L58
            ActivityManagerService.resetPriorityAfterLockedSection();
            int[] users = this.this$0.mAm.mUserController.getUsers();     // Catch: Exception -> L15
            int r1 = users.length;     // Catch: Exception -> L15
            int r3 = 0;
        L8:
            if (r3 >= r1) goto L48;
            int user = users[r3];     // Catch: Exception -> L15
            int serviceIdx = 0;
        L11:
            if (serviceIdx >= this.services.size()) goto L17;
            if (this.services.get(serviceIdx).userId == user) goto L17;
            serviceIdx = serviceIdx + 1;     // Catch: Exception -> L15
        L17:
            this.printed = false;     // Catch: Exception -> L15
            if (serviceIdx >= this.services.size()) goto L36;
            this.needSep = false;     // Catch: Exception -> L15
        L21:
            if (serviceIdx >= this.services.size()) goto L35;
            ServiceRecord r = this.services.get(serviceIdx);     // Catch: Exception -> L15
            serviceIdx = serviceIdx + 1;     // Catch: Exception -> L15
            if (r.userId != user) goto L35;
            ActivityManagerService r7 = this.this$0.mAm;     // Catch: Exception -> L15
            ActivityManagerService.boostPriorityForLockedSection();     // Catch: Exception -> L15
            monitor-enter(r7);     // Catch: Exception -> L15
            dumpServiceLocalLocked(r);     // Catch: Throwable -> L31
            monitor-exit(r7);     // Catch: Throwable -> L31
            ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L15
            dumpServiceClient(r);     // Catch: Exception -> L15
            goto L21
        L31:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L15
            throw th;     // Catch: Exception -> L15
        L35:
            this.needSep |= this.printed;     // Catch: Exception -> L15
        L36:
            ActivityManagerService r6 = this.this$0.mAm;     // Catch: Exception -> L15
            ActivityManagerService.boostPriorityForLockedSection();     // Catch: Exception -> L15
            monitor-enter(r6);     // Catch: Exception -> L15
            dumpUserRemainsLocked(user);     // Catch: Throwable -> L42
            monitor-exit(r6);     // Catch: Throwable -> L42
            ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L15
            r3 = r3 + 1;
            goto L8
        L42:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L15
            throw th;     // Catch: Exception -> L15
        L48:
            ActivityManagerService r2 = this.this$0.mAm;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            dumpRemainsLocked();     // Catch: Throwable -> L54
            monitor-exit(r2);     // Catch: Throwable -> L54
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L54:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L15:
            e = move-exception;
            Slog.w("ActivityManager", "Exception in dumpServicesLocked", e);
        L58:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private void dumpUserHeaderLocked(int user) {
            if (this.printed == false) goto L5;
        L8:
            this.printedAnything = true;
            if (this.needSep == false) goto L12;
            this.pw.println();
            return;
        L12:
            return;
        L5:
            if (this.printedAnything == false) goto L7;
            this.pw.println();
        L7:
            this.pw.println("  User " + user + " active services:");
            this.printed = true;
            goto L8
        }

        private void dumpServiceLocalLocked(ServiceRecord r) {
            dumpUserHeaderLocked(r.userId);
            this.pw.print("  * ");
            this.pw.println(r);
            if (this.dumpAll == false) goto L5;
            r.dump(this.pw, "    ");
            this.needSep = true;
            return;
        L5:
            this.pw.print("    app=");
            this.pw.println(r.app);
            this.pw.print("    created=");
            TimeUtils.formatDuration(r.createRealTime, this.nowReal, this.pw);
            this.pw.print(" started=");
            this.pw.print(r.startRequested);
            this.pw.print(" connections=");
            ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections = r.getConnections();
            this.pw.println(connections.size());
            if (connections.size() <= 0) goto L24;
            this.pw.println("    Connections:");
            int conni = 0;
        L9:
            if (conni >= connections.size()) goto L25;
            ArrayList<ConnectionRecord> clist = connections.valueAt(conni);
            int i = 0;
        L12:
            if (i >= clist.size()) goto L18;
            ConnectionRecord conn = clist.get(i);
            this.pw.print("      ");
            this.pw.print(conn.binding.intent.intent.getIntent().toShortString(false, false, false, false));
            this.pw.print(" -> ");
            ProcessRecord proc = conn.binding.client;
            PrintWriter r6 = this.pw;
            if (proc == null) goto L16;
            String r7 = proc.toShortString();
        L17:
            r6.println(r7);
            i = i + 1;
            goto L12
        L16:
            r7 = "null";
            goto L17
        L18:
            conni = conni + 1;
            goto L9
        L25:
            return;
        }

        private void dumpServiceClient(ServiceRecord r) {
            ProcessRecord proc = r.app;
            if (proc != null) goto L5;
            return;
        L5:
            IApplicationThread thread = proc.getThread();
            if (thread != null) goto L8;
            return;
        L8:
            this.pw.println("    Client:");
            this.pw.flush();
            TransferPipe tp = new TransferPipe();     // Catch: RemoteException -> L13 IOException -> L15
            thread.dumpService(tp.getWriteFd(), r, this.args);     // Catch: Throwable -> L17
            tp.setBufferPrefix("      ");     // Catch: Throwable -> L17
            tp.go(this.fd, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);     // Catch: Throwable -> L17
            tp.kill();     // Catch: RemoteException -> L13 IOException -> L15
        L22:
            this.needSep = true;
            return;
        L17:
            th = move-exception;
            tp.kill();     // Catch: RemoteException -> L13 IOException -> L15
            throw th;     // Catch: RemoteException -> L13 IOException -> L15
        L15:
            e = move-exception;
            this.pw.println("      Failure while dumping the service: " + e);
            goto L22
        L20:
            this.pw.println("      Got a RemoteException while dumping the service");
            goto L22
        }

        private void dumpUserRemainsLocked(int user) {
            ServiceMap smap = ActiveServices.m1091$$Nest$mgetServiceMapLocked(this.this$0, user);
            this.printed = false;
            int si = 0;
            int SN = smap.mDelayedStartList.size();
        L4:
            if (si >= SN) goto L21;
            ServiceRecord r = smap.mDelayedStartList.get(si);
            if (this.matcher.match(r, r.name) == false) goto L20;
            if (this.dumpPackage == null) goto L14;
            if (this.dumpPackage.equals(r.appInfo.packageName) == false) goto L20;
        L14:
            if (this.printed == false) goto L16;
        L19:
            this.printedAnything = true;
            this.pw.print("  * Delayed start ");
            this.pw.println(r);
            goto L20
        L16:
            if (this.printedAnything == false) goto L18;
            this.pw.println();
        L18:
            this.pw.println("  User " + user + " delayed start services:");
            this.printed = true;
        L20:
            si = si + 1;
            goto L4
        L21:
            this.printed = false;
            int si2 = 0;
            int SN2 = smap.mStartingBackground.size();
        L22:
            if (si2 >= SN2) goto L40;
            ServiceRecord r2 = smap.mStartingBackground.get(si2);
            if (this.matcher.match(r2, r2.name) == false) goto L38;
            if (this.dumpPackage == null) goto L32;
            if (this.dumpPackage.equals(r2.appInfo.packageName) == false) goto L38;
        L32:
            if (this.printed == false) goto L34;
        L37:
            this.printedAnything = true;
            this.pw.print("  * Starting bg ");
            this.pw.println(r2);
            goto L38
        L34:
            if (this.printedAnything == false) goto L36;
            this.pw.println();
        L36:
            this.pw.println("  User " + user + " starting in background:");
            this.printed = true;
        L38:
            si2 = si2 + 1;
            goto L22
        }

        private void dumpRemainsLocked() {
            int r3 = 0;
            if (this.this$0.mPendingServices.size() <= 0) goto L25;
            this.printed = false;
            int i = 0;
        L6:
            if (i >= this.this$0.mPendingServices.size()) goto L23;
            ServiceRecord r = this.this$0.mPendingServices.get(i);
            if (this.matcher.match(r, r.name) == false) goto L22;
            if (this.dumpPackage != null) goto L13;
        L15:
            this.printedAnything = true;
            if (this.printed == false) goto L18;
        L21:
            this.pw.print("  * Pending ");
            this.pw.println(r);
            r.dump(this.pw, "    ");
            goto L22
        L18:
            if (this.needSep == false) goto L20;
            this.pw.println();
        L20:
            this.needSep = true;
            this.pw.println("  Pending services:");
            this.printed = true;
            goto L21
        L13:
            if (this.dumpPackage.equals(r.appInfo.packageName) == true) goto L15;
        L22:
            i = i + 1;
            goto L6
        L23:
            this.needSep = true;
        L25:
            if (this.this$0.mRestartingServices.size() <= 0) goto L47;
            this.printed = false;
            int i2 = 0;
        L28:
            if (i2 >= this.this$0.mRestartingServices.size()) goto L45;
            ServiceRecord r2 = this.this$0.mRestartingServices.get(i2);
            if (this.matcher.match(r2, r2.name) == false) goto L44;
            if (this.dumpPackage != null) goto L35;
        L37:
            this.printedAnything = true;
            if (this.printed == false) goto L40;
        L43:
            this.pw.print("  * Restarting ");
            this.pw.println(r2);
            r2.dump(this.pw, "    ");
            goto L44
        L40:
            if (this.needSep == false) goto L42;
            this.pw.println();
        L42:
            this.needSep = true;
            this.pw.println("  Restarting services:");
            this.printed = true;
            goto L43
        L35:
            if (this.dumpPackage.equals(r2.appInfo.packageName) == true) goto L37;
        L44:
            i2 = i2 + 1;
            goto L28
        L45:
            this.needSep = true;
        L47:
            if (this.this$0.mDestroyingServices.size() <= 0) goto L69;
            this.printed = false;
            int i3 = 0;
        L50:
            if (i3 >= this.this$0.mDestroyingServices.size()) goto L67;
            ServiceRecord r4 = this.this$0.mDestroyingServices.get(i3);
            if (this.matcher.match(r4, r4.name) == false) goto L66;
            if (this.dumpPackage != null) goto L57;
        L59:
            this.printedAnything = true;
            if (this.printed == false) goto L62;
        L65:
            this.pw.print("  * Destroy ");
            this.pw.println(r4);
            r4.dump(this.pw, "    ");
            goto L66
        L62:
            if (this.needSep == false) goto L64;
            this.pw.println();
        L64:
            this.needSep = true;
            this.pw.println("  Destroying services:");
            this.printed = true;
            goto L65
        L57:
            if (this.dumpPackage.equals(r4.appInfo.packageName) == true) goto L59;
        L66:
            i3 = i3 + 1;
            goto L50
        L67:
            this.needSep = true;
        L69:
            if (this.dumpAll == false) goto L96;
            this.printed = false;
            int ic = 0;
        L72:
            if (ic >= this.this$0.mServiceConnections.size()) goto L96;
            ArrayList<ConnectionRecord> r5 = this.this$0.mServiceConnections.valueAt(ic);
            int i4 = 0;
        L75:
            if (i4 >= r5.size()) goto L94;
            ConnectionRecord cr = r5.get(i4);
            if (this.matcher.match(cr.binding.service, cr.binding.service.name) == false) goto L93;
            if (this.dumpPackage != null) goto L82;
        L86:
            this.printedAnything = true;
            if (this.printed == false) goto L89;
        L92:
            this.pw.print("  * ");
            this.pw.println(cr);
            cr.dump(this.pw, "    ");
            goto L93
        L89:
            if (this.needSep == false) goto L91;
            this.pw.println();
        L91:
            this.needSep = true;
            this.pw.println("  Connection bindings to services:");
            this.printed = true;
            goto L92
        L82:
            if (cr.binding.client == null) goto L93;
            if (this.dumpPackage.equals(cr.binding.client.info.packageName) == true) goto L86;
        L93:
            i4 = i4 + 1;
            goto L75
        L94:
            ic = ic + 1;
        L96:
            if (this.matcher.all == false) goto L131;
            long nowElapsed = SystemClock.elapsedRealtime();
            int[] users = this.this$0.mAm.mUserController.getUsers();
            int r7 = users.length;
        L99:
            if (r3 >= r7) goto L131;
            int user = users[r3];
            boolean printedUser = false;
            ServiceMap smap = this.this$0.mServiceMap.get(user);
            if (smap == null) goto L129;
            int i5 = smap.mActiveForegroundApps.size() - 1;
        L105:
            if (i5 < 0) goto L124;
            ActiveForegroundApp aa = smap.mActiveForegroundApps.valueAt(i5);
            if (this.dumpPackage != null) goto L109;
        L111:
            if (printedUser == true) goto L116;
            printedUser = true;
            this.printedAnything = true;
            if (this.needSep == false) goto L115;
            this.pw.println();
        L115:
            this.needSep = true;
            this.pw.print("Active foreground apps - user ");
            this.pw.print(user);
            this.pw.println(":");
        L116:
            this.pw.print("  #");
            this.pw.print(i5);
            this.pw.print(": ");
            this.pw.println(aa.mPackageName);
            if (aa.mLabel == null) goto L119;
            this.pw.print("    mLabel=");
            this.pw.println(aa.mLabel);
        L119:
            this.pw.print("    mNumActive=");
            this.pw.print(aa.mNumActive);
            this.pw.print(" mAppOnTop=");
            this.pw.print(aa.mAppOnTop);
            this.pw.print(" mShownWhileTop=");
            this.pw.print(aa.mShownWhileTop);
            this.pw.print(" mShownWhileScreenOn=");
            this.pw.println(aa.mShownWhileScreenOn);
            this.pw.print("    mStartTime=");
            TimeUtils.formatDuration(aa.mStartTime - nowElapsed, this.pw);
            this.pw.print(" mStartVisibleTime=");
            TimeUtils.formatDuration(aa.mStartVisibleTime - nowElapsed, this.pw);
            this.pw.println();
            if (aa.mEndTime == 0) goto L122;
            this.pw.print("    mEndTime=");
            TimeUtils.formatDuration(aa.mEndTime - nowElapsed, this.pw);
            this.pw.println();
        L122:
            i5 = i5 - 1;
            goto L105
        L109:
            if (this.dumpPackage.equals(aa.mPackageName) == true) goto L111;
        L124:
            if (smap.hasMessagesOrCallbacks() == false) goto L129;
            if (this.needSep == false) goto L128;
            this.pw.println();
        L128:
            this.printedAnything = true;
            this.needSep = true;
            this.pw.print("  Handler - user ");
            this.pw.print(user);
            this.pw.println(":");
            smap.dumpMine(new PrintWriterPrinter(this.pw), "    ");
        L129:
            r3 = r3 + 1;
        L131:
            if (this.printedAnything == true) goto L160;
            this.pw.println("  (nothing)");
            return;
        }
    }

    private final class ServiceLookupResult {
        final ComponentName aliasComponent;
        final String permission;
        final ServiceRecord record;

        ServiceLookupResult(ActiveServices r1, ServiceRecord _record, ComponentName _aliasComponent) {
            this.record = _record;
            this.permission = null;
            this.aliasComponent = _aliasComponent;
        }

        ServiceLookupResult(ActiveServices r1, String _permission) {
            this.record = null;
            this.permission = _permission;
            this.aliasComponent = null;
        }
    }

    final class ServiceMap extends Handler {
        static final int MSG_BG_START_TIMEOUT = 1;
        static final int MSG_ENSURE_NOT_START_BG = 3;
        static final int MSG_UPDATE_FOREGROUND_APPS = 2;
        final ArrayMap<String, ActiveForegroundApp> mActiveForegroundApps;
        boolean mActiveForegroundAppsChanged;
        final ArrayList<ServiceRecord> mDelayedStartList;
        final ArrayList<String> mPendingRemoveForegroundApps;
        final ArrayMap<ComponentName, ServiceRecord> mServicesByInstanceName;
        final ArrayMap<Intent.FilterComparison, ServiceRecord> mServicesByIntent;
        final ArrayList<ServiceRecord> mStartingBackground;
        final int mUserId;
        final /* synthetic */ ActiveServices this$0;

        ServiceMap(ActiveServices this$0, Looper looper, int userId) {
            this.this$0 = this$0;
            super(looper);
            this.mServicesByInstanceName = new ArrayMap();
            this.mServicesByIntent = new ArrayMap();
            this.mDelayedStartList = new ArrayList();
            this.mStartingBackground = new ArrayList();
            this.mActiveForegroundApps = new ArrayMap();
            this.mPendingRemoveForegroundApps = new ArrayList();
            this.mUserId = userId;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L5;
                default: goto L31;
            };
        L5:
            ActivityManagerService r0 = this.this$0.mAm;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            rescheduleDelayedStartsLocked();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L10:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L14:
            this.this$0.updateForegroundApps(this);
            return;
        L15:
            ActivityManagerService r1 = this.this$0.mAm;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            rescheduleDelayedStartsLocked();     // Catch: Throwable -> L21
            monitor-exit(r1);     // Catch: Throwable -> L21
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L21:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        void ensureNotStartingBackgroundLocked(ServiceRecord r) {
            if (this.mStartingBackground.remove(r) == false) goto L9;
            if (ActiveServices.m1097$$Nest$sfgetDEBUG_DELAYED_STARTS() == false) goto L7;
            Slog.v("ActivityManager", "No longer background starting: " + r);
        L7:
            removeMessages(3);
            Message msg = obtainMessage(3);
            sendMessage(msg);
        L9:
            if (this.mDelayedStartList.remove(r) == true) goto L11;
            return;
        L11:
            if (ActiveServices.m1097$$Nest$sfgetDEBUG_DELAYED_STARTS() == false) goto L15;
            Slog.v("ActivityManager", "No longer delaying start: " + r);
            return;
        }

        void rescheduleDelayedStartsLocked() {
            removeMessages(1);
            long now = SystemClock.uptimeMillis();
            int i = 0;
            int N = this.mStartingBackground.size();
        L4:
            if (i >= N) goto L10;
            ServiceRecord r = this.mStartingBackground.get(i);
            if (r.startingBgTimeout > now) goto L8;
            Slog.i("ActivityManager", "Waited long enough for: " + r);
            this.mStartingBackground.remove(i);
            N = N + (-1);
            i = i + (-1);
        L8:
            i = i + 1;
        L10:
            if (this.mDelayedStartList.size() <= 0) goto L32;
            if (this.mStartingBackground.size() >= this.this$0.mMaxStartingBackground) goto L32;
            ServiceRecord r2 = this.mDelayedStartList.remove(0);
            if (ActiveServices.m1097$$Nest$sfgetDEBUG_DELAYED_STARTS() == false) goto L17;
            Slog.v("ActivityManager", "REM FR DELAY LIST (exec next): " + r2);
        L17:
            if (ActiveServices.m1096$$Nest$sfgetDEBUG_DELAYED_SERVICE() == true) goto L19;
        L24:
            r2.delayed = false;
            if (r2.pendingStarts.size() <= 0) goto L26;
            ServiceRecord.StartItem si = r2.pendingStarts.get(0);     // Catch: TransactionTooLargeException -> L29
            this.this$0.startServiceInnerLocked(this, si.intent, r2, false, true, si.callingId, si.mCallingProcessName, si.mCallingProcessState, r2.startRequested, si.mCallingPackageName);     // Catch: TransactionTooLargeException -> L29
            goto L10
        L26:
            Slog.wtf("ActivityManager", "**** NO PENDING STARTS! " + r2 + " startReq=" + r2.startRequested + " delayedStop=" + r2.delayedStop);
            goto L10
        L19:
            if (this.mDelayedStartList.size() <= 0) goto L24;
            Slog.v("ActivityManager", "Remaining delayed list:");
            int i2 = 0;
        L22:
            if (i2 >= this.mDelayedStartList.size()) goto L24;
            Slog.v("ActivityManager", "  #" + i2 + ": " + this.mDelayedStartList.get(i2));
            i2 = i2 + 1;
        L32:
            if (this.mStartingBackground.size() <= 0) goto L55;
            ServiceRecord next = this.mStartingBackground.get(0);
            if (next.startingBgTimeout <= now) goto L36;
            long when = next.startingBgTimeout;
        L38:
            if (ActiveServices.m1096$$Nest$sfgetDEBUG_DELAYED_SERVICE() == false) goto L40;
            Slog.v("ActivityManager", "Top bg start is " + next + ", can delay others up to " + when);
        L40:
            Message msg = obtainMessage(1);
            sendMessageAtTime(msg, when);
            return;
        L36:
            when = now;
            goto L38
        }
    }

    private class ServiceRestarter implements Runnable {
        private ServiceRecord mService;
        final /* synthetic */ ActiveServices this$0;

        /* synthetic */ ServiceRestarter(ActiveServices r1, ActiveServicesIA r2) {
            this(r1);
        }

        private ServiceRestarter(ActiveServices r1) {
            this.this$0 = r1;
        }

        void setService(ServiceRecord service) {
            this.mService = service;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityManagerService r0 = this.this$0.mAm;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.performServiceRestartLocked(this.mService);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    private class SystemExemptedFgsTypePermission extends ForegroundServiceTypePolicy.ForegroundServiceTypePermission {
        final /* synthetic */ ActiveServices this$0;

        SystemExemptedFgsTypePermission(ActiveServices r1) {
            this.this$0 = r1;
            super("System exempted");
        }

        public int checkPermission(Context context, int callerUid, int callerPid, String packageName, boolean allowWhileInUse) {
            AppRestrictionController appRestrictionController = this.this$0.mAm.mAppRestrictionController;
            int reason = appRestrictionController.getPotentialSystemExemptionReason(callerUid);
            if (reason != (-1)) goto L8;
            reason = appRestrictionController.getPotentialSystemExemptionReason(callerUid, packageName);
            if (reason != (-1)) goto L8;
            reason = appRestrictionController.getPotentialUserAllowedExemptionReason(callerUid, packageName);
        L8:
            if (reason == (-1)) goto L10;
        L12:
            switch(reason) {
                case 10: goto L14;
                case 11: goto L14;
                case 51: goto L14;
                case 55: goto L14;
                case 56: goto L14;
                case 63: goto L14;
                case 65: goto L14;
                case 300: goto L14;
                case 319: goto L14;
                case 320: goto L14;
                case 321: goto L14;
                case 322: goto L14;
                case 323: goto L14;
                case 324: goto L14;
                case 326: goto L14;
                case 327: goto L14;
                default: goto L13;
            };
        L13:
            return -1;
        L14:
            return 0;
        L10:
            if (ArrayUtils.contains(this.this$0.mAm.getPackageManagerInternal().getKnownPackageNames(2, 0), packageName) == false) goto L12;
            reason = FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_PACKAGE_INSTALLER;
            goto L12
        }
    }

    public static /* synthetic */ void $r8$lambda$0qkjeNpxaTsg0ZNHkscOuBnZYxA(ActiveServices r0) {
        r0.lambda$attachApplicationLocked$2();
    }

    /* JADX INFO: renamed from: $r8$lambda$6TNWDsWZktLO4SAji1n-AbDocHs, reason: not valid java name */
    public static /* synthetic */ void m1086$r8$lambda$6TNWDsWZktLO4SAji1nAbDocHs(ArrayList r0) {
        lambda$bringDownDisabledPackageServicesLocked$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$6UZVmEzbRvh3K-t1ovMgwDsBea8, reason: not valid java name */
    public static /* synthetic */ void m1087$r8$lambda$6UZVmEzbRvh3Kt1ovMgwDsBea8(ServiceConnection r0, ComponentName r1, ForegroundServiceDelegation r2) {
        lambda$startForegroundServiceDelegateLocked$8(r0, r1, r2);
    }

    public static /* synthetic */ Integer $r8$lambda$btpRyn2QvHxPy1BXkZJjoK5OB78(ActiveServices r0, int r1, boolean r2, ProcessRecord r3) {
        return r0.lambda$shouldAllowFgsStartForegroundNoBindingCheckLocked$7(r1, r2, r3);
    }

    public static /* synthetic */ Integer $r8$lambda$dtupl9fjxv8RDOZGvTs4p44nKJI(ActiveServices r0, int r1, ArraySet r2, ProcessRecord r3) {
        return r0.lambda$shouldAllowFgsWhileInUsePermissionByBindingsLocked$5(r1, r2, r3);
    }

    public static /* synthetic */ Integer $r8$lambda$jK_UxrI6agW1buIHNND7c_BI120(int r0, ProcessRecord r1) {
        return lambda$shouldAllowFgsWhileInUsePermissionLocked$4(r0, r1);
    }

    public static /* synthetic */ Pair $r8$lambda$p_X4sOJTkojjyDKVG3R4by9T9zs(ActiveServices r0, int r1, ArraySet r2, ProcessRecord r3) {
        return r0.lambda$canBindingClientStartFgsLocked$6(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$u0_M56QId-Gw-qfZV42Z9_xVIIU, reason: not valid java name */
    public static /* synthetic */ int m1088$r8$lambda$u0_M56QIdGwqfZV42Z9_xVIIU(ServiceRecord r0, ServiceRecord r1) {
        return lambda$setServiceRestartBackoffEnabledLocked$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$uPw5lmk5q9J52kbSZGS3vk7wJdc(ServiceRecord r0) {
        lambda$bringDownServiceLocked$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingBringups, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m1089$$Nest$fgetmPendingBringups(ActiveServices r0) {
        return r0.mPendingBringups;
    }

    /* JADX INFO: renamed from: -$$Nest$mbringUpServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1090$$Nest$mbringUpServiceLocked(ActiveServices r0, ServiceRecord r1, int r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8) {
        return r0.bringUpServiceLocked(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetServiceMapLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceMap m1091$$Nest$mgetServiceMapLocked(ActiveServices r0, int r1) {
        return r0.getServiceMapLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misForegroundServiceAllowedInBackgroundRestricted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1092$$Nest$misForegroundServiceAllowedInBackgroundRestricted(ActiveServices r0, int r1, String r2) {
        return r0.isForegroundServiceAllowedInBackgroundRestricted(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misTempAllowedByAlarmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1093$$Nest$misTempAllowedByAlarmClock(ActiveServices r0, int r1) {
        return r0.isTempAllowedByAlarmClock(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestStartTargetPermissionsReviewIfNeededLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1094$$Nest$mrequestStartTargetPermissionsReviewIfNeededLocked(ActiveServices r0, ServiceRecord r1, String r2, String r3, int r4, Intent r5, boolean r6, int r7, boolean r8, IServiceConnection r9) {
        return r0.requestStartTargetPermissionsReviewIfNeededLocked(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartServiceInnerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m1095$$Nest$mstartServiceInnerLocked(ActiveServices r0, ServiceRecord r1, Intent r2, int r3, int r4, String r5, int r6, boolean r7, boolean r8, BackgroundStartPrivileges r9, String r10) {
        return r0.startServiceInnerLocked(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_DELAYED_SERVICE, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1096$$Nest$sfgetDEBUG_DELAYED_SERVICE() {
        return DEBUG_DELAYED_SERVICE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_DELAYED_STARTS, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1097$$Nest$sfgetDEBUG_DELAYED_STARTS() {
        return DEBUG_DELAYED_STARTS;
    }

    static {
        DEBUG_DELAYED_SERVICE = ActivityManagerDebugConfig.DEBUG_SERVICE;
        DEBUG_DELAYED_STARTS = DEBUG_DELAYED_SERVICE;
        DEBUG_SHORT_SERVICE = ActivityManagerDebugConfig.DEBUG_SERVICE;
        LOG_SERVICE_START_STOP = ActivityManagerDebugConfig.DEBUG_SERVICE;
        mIsAIDLSupported = false;
        sNumForegroundServices = new AtomicReference(new Pair(0, 0));
        mPerf = new BoostFramework();
        SERVICE_RESCHEDULE = false;
        DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    void stopAllForegroundServicesLocked(int uid, String packageName) {
        ActiveServices r0 = this;
        ServiceMap smap = r0.getServiceMapLocked(UserHandle.getUserId(uid));
        int N = smap.mServicesByInstanceName.size();
        ArrayList<ServiceRecord> toStop = new ArrayList(N);
        int i = 0;
    L3:
        if (i >= N) goto L16;
        ServiceRecord r = smap.mServicesByInstanceName.valueAt(i);
        if (uid == r.serviceInfo.applicationInfo.uid) goto L9;
        if (packageName.equals(r.serviceInfo.packageName) == true) goto L9;
    L15:
        i = i + 1;
    L9:
        if (r.isForeground == false) goto L15;
        if (r.mAllowStartForegroundAtEntering == 301) goto L15;
        if (r0.isDeviceProvisioningPackage(r.packageName) == true) goto L15;
        toStop.add(r);
        goto L15
    L16:
        int numToStop = toStop.size();
        if (numToStop > 0) goto L19;
    L21:
        int i2 = 0;
    L22:
        if (i2 >= numToStop) goto L28;
        ServiceRecord r2 = toStop.get(i2);
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L26;
        Slog.i("ActivityManager", "  Stopping fg for service " + r2);
    L26:
        r0.setServiceForegroundInnerLocked(r2, 0, null, 0, 0, 0, true);
        i2 = i2 + 1;
        r0 = this;
        goto L22
    L28:
        return;
    L19:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L21;
        Slog.i("ActivityManager", "Package " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + uid + " in FAS with foreground services");
        goto L21
    }

    public ActiveServices(ActivityManagerService service) {
        this.mServiceMap = new SparseArray();
        this.mServiceConnections = new ArrayMap();
        this.mPendingServices = new ArrayList();
        this.mRestartingServices = new ArrayList();
        this.mDestroyingServices = new ArrayList();
        this.mPendingFgsNotifications = new ArrayList();
        this.mFgsDelegations = new ArrayMap();
        this.mBindServiceSeqCounter = 0;
        this.mFgsDeferralRateLimited = true;
        this.mFgsDeferralEligible = new SparseLongArray();
        this.mFgsObservers = new RemoteCallbackList();
        this.mPendingBringups = new ArrayMap();
        this.mTmpCollectionResults = null;
        this.mFgsAppOpCallbacks = new SparseArray();
        this.mRestartBackoffDisabledPackages = new ArraySet();
        this.mScreenOn = true;
        this.isLowRamDevice = SystemProperties.getBoolean("ro.config.low_ram", false);
        this.mTimeLimitedFgsInfo = new SparseArray();
        this.mAllowListWhileInUsePermissionInFgs = new ArraySet();
        this.mLastAnrDumpClearer = new AnonymousClass1(this);
        this.mPostDeferredFGSNotifications = new AnonymousClass5(this);
        this.mAm = service;
        int maxBg = 0;
        maxBg = Integer.parseInt(SystemProperties.get("ro.config.max_starting_bg", "0"));     // Catch: RuntimeException -> L5
    L6:
        if (maxBg <= 0) goto L9;
        int r4 = maxBg;
    L12:
        this.mMaxStartingBackground = r4;
        ServiceManager.getService("platform_compat");
        if (mPerf == null) goto L15;
        SERVICE_RESCHEDULE = Boolean.parseBoolean(mPerf.perfGetProp("ro.vendor.qti.am.reschedule_service", "false"));
    L15:
        this.mFGSLogger = new ForegroundServiceTypeLoggerModule();
        this.mActiveServiceAnrTimer = new ProcessAnrTimer(service, 12, "SERVICE_TIMEOUT", new AnrTimer.Args().freeze(true));
        this.mShortFGSAnrTimer = new ServiceAnrTimer(service, 78, "SHORT_FGS_TIMEOUT");
        this.mServiceFGAnrTimer = new ServiceAnrTimer(service, 66, "SERVICE_FOREGROUND_TIMEOUT", new AnrTimer.Args().extend(true));
        if (ServiceManager.isDeclared(AIDL_SERVICE) == true) goto L19;
        return;
    L19:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L23;
        Slog.w("ActivityManager", "AIDL is supported");     // Catch: Exception -> L21
    L23:
        mIsAIDLSupported = true;     // Catch: Exception -> L21
        return;
    L26:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L28;
        Slog.w("ActivityManager", "AIDL not Supported");
    L28:
        mIsAIDLSupported = false;
        return;
    L9:
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L11;
        r4 = 1;
        goto L12
    L11:
        r4 = 8;
        goto L12
    }

    void systemServicesReady() {
        getAppStateTracker().addBackgroundRestrictedAppListener(new BackgroundRestrictedListener(this));
        this.mAppWidgetManagerInternal = (AppWidgetManagerInternal) LocalServices.getService(AppWidgetManagerInternal.class);
        setAllowListWhileInUsePermissionInFgs();
        initSystemExemptedFgsTypePermission();
        initMediaProjectFgsTypeCustomPermission();
    }

    private AppStateTracker getAppStateTracker() {
        if (this.mAppStateTracker != null) goto L6;
        this.mAppStateTracker = (AppStateTracker) LocalServices.getService(AppStateTracker.class);
    L6:
        return this.mAppStateTracker;
    }

    private void setAllowListWhileInUsePermissionInFgs() {
        String attentionServicePackageName = this.mAm.mContext.getPackageManager().getAttentionServicePackageName();
        if (TextUtils.isEmpty(attentionServicePackageName) == true) goto L5;
        this.mAllowListWhileInUsePermissionInFgs.add(attentionServicePackageName);
    L5:
        String systemCaptionsServicePackageName = this.mAm.mContext.getPackageManager().getSystemCaptionsServicePackageName();
        if (TextUtils.isEmpty(systemCaptionsServicePackageName) == true) goto L9;
        this.mAllowListWhileInUsePermissionInFgs.add(systemCaptionsServicePackageName);
        return;
    }

    private boolean getServicetrackerInstance() {
        if (this.mServicetracker == null) goto L23;
        return true;
    L23:
        this.mServicetracker = IServicetracker.getService(false);     // Catch: RemoteException -> L7 NoSuchElementException -> L9
    L7:
        e = move-exception;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L14;
        Slog.e("ActivityManager", "Failed to get servicetracker interface", e);
    L14:
        return false;
    L16:
        if (this.mServicetracker == null) goto L18;
        return true;
    L18:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L20;
        Slog.w("ActivityManager", "servicetracker HIDL not available");
    L20:
        return false;
    }

    private boolean getAIDLServicetrackerInstance() {
        if (mIsAIDLSupported == true) goto L6;
        return false;
    L6:
        if (this.mServicetracker_aidl == null) goto L25;
        return true;
    L25:
        IBinder mBinder = ServiceManager.getService(AIDL_SERVICE);     // Catch: Exception -> L9 NoSuchElementException -> L11
        this.mServicetracker_aidl = vendor.qti.hardware.servicetrackeraidl.IServicetracker.Stub.asInterface(mBinder);     // Catch: Exception -> L9 NoSuchElementException -> L11
    L9:
        e = move-exception;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L16;
        Slog.e("ActivityManager", "Failed to get servicetracker AIDL interface", e);
    L16:
        return false;
    L18:
        if (this.mServicetracker_aidl == null) goto L20;
        return true;
    L20:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L22;
        Slog.w("ActivityManager", "servicetracker AIDL not available");
    L22:
        return false;
    }

    ServiceRecord getServiceByNameLocked(ComponentName name, int callingUser) {
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L6;
        Slog.v(TAG_MU, "getServiceByNameLocked(" + name + "), callingUser = " + callingUser);
    L6:
        return getServiceMapLocked(callingUser).mServicesByInstanceName.get(name);
    }

    boolean hasBackgroundServicesLocked(int callingUser) {
        ServiceMap smap = this.mServiceMap.get(callingUser);
        if (smap != null) goto L5;
        return false;
    L5:
        if (smap.mStartingBackground.size() < this.mMaxStartingBackground) goto L9;
        return true;
    L9:
        return false;
    }

    boolean hasForegroundServiceNotificationLocked(String pkg, int userId, String channelId) {
        ServiceMap smap = this.mServiceMap.get(userId);
        if (smap == null) goto L21;
        int i = 0;
    L6:
        if (i >= smap.mServicesByInstanceName.size()) goto L30;
        ServiceRecord sr = smap.mServicesByInstanceName.valueAt(i);
        if (sr.appInfo.packageName.equals(pkg) == false) goto L20;
        if (sr.isForeground == false) goto L20;
        if (sr.foregroundNoti == null) goto L20;
        if (Objects.equals(sr.foregroundNoti.getChannelId(), channelId) == false) goto L20;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L29;
        Slog.d("ActivityManager", "Channel u" + userId + "/pkg=" + pkg + "/channelId=" + channelId + " has fg service notification");
        return true;
    L29:
        return true;
    L20:
        i = i + 1;
        goto L6
    L30:
        return false;
    L21:
        return false;
    }

    private ServiceMap getServiceMapLocked(int callingUser) {
        ServiceMap smap = this.mServiceMap.get(callingUser);
        if (smap != null) goto L6;
        ServiceMap smap2 = new ServiceMap(this, this.mAm.mHandler.getLooper(), callingUser);
        this.mServiceMap.put(callingUser, smap2);
        return smap2;
    L6:
        return smap;
    }

    ArrayMap<ComponentName, ServiceRecord> getServicesLocked(int callingUser) {
        return getServiceMapLocked(callingUser).mServicesByInstanceName;
    }

    private boolean appRestrictedAnyInBackground(int uid, String packageName) {
        AppStateTracker appStateTracker = getAppStateTracker();
        if (appStateTracker != null) goto L5;
        return false;
    L5:
        return appStateTracker.isAppBackgroundRestricted(uid, packageName);
    }

    void updateAppRestrictedAnyInBackgroundLocked(int uid, String packageName) {
        boolean restricted = appRestrictedAnyInBackground(uid, packageName);
        UidRecord uidRec = this.mAm.mProcessList.getUidRecordLOSP(uid);
        if (uidRec == null) goto L8;
        ProcessRecord app = uidRec.getProcessInPackage(packageName);
        if (app == null) goto L9;
        app.mState.setBackgroundRestricted(restricted);
        return;
    L9:
        return;
    }

    static String getProcessNameForService(ServiceInfo sInfo, ComponentName name, String callingPackage, String instanceName, boolean isSdkSandbox, boolean inSharedIsolatedProcess, boolean inPrivateSharedIsolatedProcess) {
        if (isSdkSandbox == false) goto L5;
        return instanceName;
    L5:
        if ((sInfo.flags & 2) == 0) goto L16;
        if (inPrivateSharedIsolatedProcess == true) goto L8;
    L10:
        if (inSharedIsolatedProcess == false) goto L14;
        return callingPackage + ":ishared:" + instanceName;
    L14:
        return sInfo.processName + ":" + name.getClassName();
    L8:
        if (isDefaultProcessService(sInfo) == true) goto L10;
    L16:
        return sInfo.processName;
    }

    private static boolean isDefaultProcessService(ServiceInfo serviceInfo) {
        return serviceInfo.applicationInfo.processName.equals(serviceInfo.processName);
    }

    private static void traceInstant(String message, ServiceRecord service) {
        if (Trace.isTagEnabled(64) == true) goto L6;
        return;
    L6:
        if (service.getComponentName() == null) goto L8;
        String serviceName = service.getComponentName().toShortString();
    L9:
        Trace.instant(64, message + serviceName);
        return;
    L8:
        serviceName = "(?)";
        goto L9
    }

    ComponentName startServiceLocked(IApplicationThread caller, Intent service, String resolvedType, int callingPid, int callingUid, boolean fgRequired, String callingPackage, String callingFeatureId, int userId, boolean isSdkSandboxService, int sdkSandboxClientAppUid, String sdkSandboxClientAppPackage, String instanceName) throws TransactionTooLargeException {
        return startServiceLocked(caller, service, resolvedType, callingPid, callingUid, fgRequired, callingPackage, callingFeatureId, userId, BackgroundStartPrivileges.NONE, isSdkSandboxService, sdkSandboxClientAppUid, sdkSandboxClientAppPackage, instanceName);
    }

    ComponentName startServiceLocked(IApplicationThread caller, Intent service, String resolvedType, int callingPid, int callingUid, boolean fgRequired, String callingPackage, String callingFeatureId, int userId, BackgroundStartPrivileges backgroundStartPrivileges) throws TransactionTooLargeException {
        return startServiceLocked(caller, service, resolvedType, callingPid, callingUid, fgRequired, callingPackage, callingFeatureId, userId, backgroundStartPrivileges, false, -1, null, null);
    }

    ComponentName startServiceLocked(IApplicationThread caller, Intent service, String resolvedType, int callingPid, int callingUid, boolean fgRequired, String callingPackage, String callingFeatureId, int userId, BackgroundStartPrivileges backgroundStartPrivileges, boolean isSdkSandboxService, int sdkSandboxClientAppUid, String sdkSandboxClientAppPackage, String instanceName) throws TransactionTooLargeException {
        if (DEBUG_DELAYED_STARTS == false) goto L5;
        StringBuilder r5 = new StringBuilder();
        r5.append("startService: ");
        r5.append(service);
        r5.append(" type=");
        String r8 = resolvedType;
        r5.append(r8);
        r5.append(" args=");
        r5.append(service.getExtras());
        Slog.v("ActivityManager", r5.toString());
    L6:
        ProcessRecord callerApp = this.mAm.getRecordForAppLOSP(caller, true);
        if (caller == null) goto L19;
        if (callerApp == null) goto L18;
        if (callerApp.getSmtEx().inFreezeStat() == false) goto L13;
        return null;
    L13:
        if (callerApp.mState.getSetSchedGroup() == 0) goto L15;
        boolean r0 = true;
    L16:
        boolean callerFg = r0;
    L20:
        boolean callerFg2 = callerFg;
        ServiceLookupResult res = retrieveServiceLocked(service, instanceName, isSdkSandboxService, sdkSandboxClientAppUid, sdkSandboxClientAppPackage, r8, callingPackage, callingPid, callingUid, userId, true, callerFg2, false, false, null, false, false);
        if (res != null) goto L24;
        return null;
    L24:
        if (res.record == null) goto L26;
        ServiceRecord r = res.record;
        traceInstant("startService(): ", r);
        setFgsRestrictionLocked(callingPackage, callingPid, callingUid, service, r, userId, backgroundStartPrivileges, false);
        if (this.mAm.mUserController.exists(r.userId) == true) goto L35;
        Slog.w("ActivityManager", "Trying to start service with non-existent user! " + r.userId);
        return null;
    L35:
        if (isSdkSandboxService == false) goto L37;
        int r1 = sdkSandboxClientAppUid;
    L38:
        int appUid = r1;
        if (isSdkSandboxService == false) goto L41;
        String r2 = sdkSandboxClientAppPackage;
    L42:
        String appPackageName = r2;
        int appTargetSdkVersion = r.appInfo.targetSdkVersion;
        if (isSdkSandboxService == false) goto L53;
        int appTargetSdkVersion2 = AppGlobals.getPackageManager().getApplicationInfo(appPackageName, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, userId).targetSdkVersion;     // Catch: RemoteException -> L48
        int appTargetSdkVersion3 = appTargetSdkVersion2;
    L54:
        boolean bgLaunch = !this.mAm.isUidActiveLOSP(appUid);
        if (bgLaunch == true) goto L57;
    L66:
        boolean forcedStandby = false;
    L67:
        if (fgRequired == false) goto L80;
        logFgsBackgroundStart(r);
        if (r.isFgsAllowedStart() == true) goto L80;
        if (isBgFgsRestrictionEnabled(r, callingUid) == false) goto L80;
        String msg = "startForegroundService() not allowed due to mAllowStartForeground false: service " + r.shortInstanceName;
        Slog.w("ActivityManager", msg);
        showFgsBgRestrictedNotificationLocked(r);
        logFGSStateChangeLocked(r, 3, 0, 0, 0, 0, false);
        if (CompatChanges.isChangeEnabled(FGS_START_EXCEPTION_CHANGE_ID, callingUid) == true) goto L76;
        return null;
    L76:
        throw new ForegroundServiceStartNotAllowedException(msg);
    L80:
        if (fgRequired == false) goto L87;
        int mode = this.mAm.getAppOpsManager().checkOpNoThrow(76, appUid, appPackageName);
        switch(mode) {
            case 0: goto L87;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L87;
            default: goto L84;
        };
    L85:
        Slog.w("ActivityManager", "startForegroundService not allowed due to app op: service " + service + " to " + r.shortInstanceName + " from pid=" + callingPid + " uid=" + callingUid + " pkg=" + callingPackage);
        boolean fgRequired2 = false;
        boolean forceSilentAbort = true;
    L88:
        ProcessRecord pr = this.mAm.getProcessRecordLocked(r2.processName, r2.appInfo.uid);
        if (forcedStandby == 0) goto L91;
    L96:
        if (pr != null) goto L98;
    L101:
        ActivityManagerService r3 = this.mAm;
        ServiceRecord r4 = r2;
        int appUid2 = appUid;
        boolean fgRequired3 = fgRequired2;
        int appTargetSdkVersion4 = appTargetSdkVersion3;
        int callingProcessState = callingPid;
        boolean forcedStandby2 = forcedStandby;
        int allowed = r3.getAppStartModeLOSP(appUid2, appPackageName, appTargetSdkVersion4, callingProcessState, false, false, forcedStandby2);
        int appTargetSdkVersion5 = appTargetSdkVersion4;
        if (allowed == 0) goto L116;
        Slog.w("ActivityManager", "Background start not allowed: service " + service + " to " + r4.shortInstanceName + " from pid=" + callingProcessState + " uid=" + callingUid + " pkg=" + callingPackage + " startFg?=" + fgRequired3);
        if (allowed == 1) goto L115;
        if (forceSilentAbort == true) goto L115;
        if (forcedStandby2 == false) goto L113;
        if (fgRequired3 == false) goto L113;
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L112;
        Slog.v("ActivityManager", "Silently dropping foreground service launch due to FAS");
    L112:
        return null;
    L113:
        UidRecord uidRec = this.mAm.mProcessList.getUidRecordLOSP(appUid2);
        return new ComponentName("?", "app is in background uid " + uidRec);
    L115:
        return null;
    L116:
        ProcessRecord targetApp = this.mAm.getProcessRecordLocked(r4.processName, r4.appInfo.uid);
        if (targetApp != null) goto L121;
        ProcessRecord callerApp2 = callerApp;
        if (SysOptBridge.getFactory().getProcessIntercept().isServiceAllowStart(callerApp2, r4, service, callingUid) == true) goto L123;
        return null;
    L123:
        if (appTargetSdkVersion5 >= 26) goto L131;
        if (fgRequired3 == false) goto L131;
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L128;
    L129:
        Slog.i("ActivityManager", "startForegroundService() but host targets " + appTargetSdkVersion5 + " - not requiring startForeground()");
    L130:
        fgRequired3 = false;
        goto L131
    L128:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L130;
    L131:
        ActivityManagerService.PidMap r6 = this.mAm.mPidsSelfLocked;
        monitor-enter(r6);
        ProcessRecord callingApp = this.mAm.mPidsSelfLocked.get(callingProcessState);     // Catch: Throwable -> L161
        monitor-exit(r6);     // Catch: Throwable -> L161
        if (callingApp == null) goto L137;
        String callingProcessName = callingApp.processName;
    L138:
        if (callingApp != null) goto L140;
    L145:
        int r7 = -1;
    L144:
        int callingProcessState2 = r7;
        r4.updateProcessStateOnRequest();
        ServiceRecord r9 = r4;
        String callingProcessName2 = callingProcessName;
        boolean fgRequired4 = fgRequired3;
        if (deferServiceBringupIfFrozenLocked(r9, service, callingPackage, callingFeatureId, callingUid, callingProcessState, callingProcessName2, callingProcessState2, fgRequired3, callerFg2, userId, backgroundStartPrivileges, false, null) == false) goto L150;
        return null;
    L150:
        if (requestStartTargetPermissionsReviewIfNeededLocked(r9, callingPackage, callingFeatureId, callingUid, service, callerFg2, userId, false, null) == true) goto L152;
        return null;
    L152:
        ComponentName realResult = startServiceInnerLocked(r9, service, callingUid, callingPid, callingProcessName2, callingProcessState2, fgRequired4, callerFg2, backgroundStartPrivileges, callingPackage);
        if (res.aliasComponent != null) goto L155;
    L160:
        return realResult;
    L155:
        if (realResult.getPackageName().startsWith("!") == true) goto L160;
        if (realResult.getPackageName().startsWith("?") == true) goto L160;
        return res.aliasComponent;
    L140:
        if (callingApp.getThread() == null) goto L145;
        if (callingApp.isKilled() == true) goto L145;
        r7 = callingApp.mState.getCurProcState();
        goto L144
    L137:
        callingProcessName = callingPackage;
    L161:
        th = th;
    L171:
        throw th;
    L165:
        th = th;
        goto L171
    L121:
        callerApp2 = callerApp;
        goto L123
    L98:
        if (pr.info.getSysEx().doPrefetch == 0) goto L101;
        appTargetSdkVersion5 = appTargetSdkVersion3;
        callingProcessState = callingPid;
        r4 = r2;
        appUid2 = appUid;
        fgRequired3 = fgRequired2;
        goto L116
    L91:
        if (r2.startRequested == true) goto L94;
        if (fgRequired2 == false) goto L96;
    L94:
        appTargetSdkVersion5 = appTargetSdkVersion3;
        callingProcessState = callingPid;
        r4 = r2;
        appUid2 = appUid;
        fgRequired3 = fgRequired2;
        goto L116
    L84:
        return new ComponentName("!!", "foreground not allowed as per app op");
    L87:
        fgRequired2 = fgRequired;
        forceSilentAbort = false;
        goto L88
    L57:
        if (appRestrictedAnyInBackground(appUid, appPackageName) == false) goto L66;
        if (isTempAllowedByAlarmClock(appUid) == true) goto L66;
        if (isDeviceProvisioningPackage(appPackageName) == true) goto L66;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L65;
        Slog.d("ActivityManager", "Forcing bg-only service start only for " + r.shortInstanceName + " : bgLaunch=" + bgLaunch + " callerFg=" + callerFg2);
    L65:
        forcedStandby = true;
    L53:
        appTargetSdkVersion3 = appTargetSdkVersion;
        goto L54
    L41:
        r2 = r.packageName;
        goto L42
    L37:
        r1 = r.appInfo.uid;
        goto L38
    L26:
        if (res.permission == null) goto L28;
        String r10 = res.permission;
    L30:
        return new ComponentName("!", r10);
    L28:
        r10 = "private to package";
        goto L30
    L15:
        r0 = false;
        goto L16
    L18:
        throw new SecurityException("Unable to find app for caller " + caller + " (pid=" + callingPid + ") when starting service " + service);
    L19:
        callerFg = true;
        goto L20
    L5:
        r8 = resolvedType;
        goto L6
    }

    private boolean shouldAllowBootCompletedStart(ServiceRecord r, int foregroundServiceType) {
        int fgsStartReasonCode = r.getFgsAllowStart();
        if (CompatChanges.isChangeEnabled(FGS_BOOT_COMPLETED_RESTRICTIONS, r.appInfo.uid) == true) goto L5;
    L11:
        return true;
    L5:
        if (fgsStartReasonCode != 200) goto L11;
        if ((this.mAm.mConstants.FGS_BOOT_COMPLETED_ALLOWLIST & foregroundServiceType) != 0) goto L12;
        return false;
    L12:
        return true;
    }

    private ComponentName startServiceInnerLocked(ServiceRecord r, Intent service, int callingUid, int callingPid, String callingProcessName, int callingProcessState, boolean fgRequired, boolean callerFg, BackgroundStartPrivileges backgroundStartPrivileges, String callingPackage) throws TransactionTooLargeException {
        NeededUriGrants neededGrants = this.mAm.mUgmInternal.checkGrantUriPermissionFromIntent(service, callingUid, r.packageName, r.userId);
        if (unscheduleServiceRestartLocked(r, callingUid, false) == true) goto L5;
    L7:
        boolean wasStartRequested = r.startRequested;
        this.mAm.mProcessStateController.setServiceLastActivityTime(r, SystemClock.uptimeMillis());
        this.mAm.mProcessStateController.setStartRequested(r, true);
        r.delayedStop = false;
        r.fgRequired = fgRequired;
        r.pendingStarts.add(new ServiceRecord.StartItem(r, false, r.makeNextStartId(), service, neededGrants, callingUid, callingProcessName, callingPackage, callingProcessState));
        if (r.isForeground == false) goto L10;
    L13:
        boolean r5 = true;
    L14:
        boolean isFgs = r5;
        if (isFgs == false) goto L25;
        boolean whileInUseAllowsUiJobScheduling = ActivityManagerService.doesReasonCodeAllowSchedulingUserInitiatedJobs(r.getFgsAllowWiu_forStart(), callingUid);
        if (whileInUseAllowsUiJobScheduling == true) goto L22;
        String r10 = callingPackage;
        if (this.mAm.canScheduleUserInitiatedJobs(callingUid, callingPid, r10) == true) goto L23;
        boolean r2 = false;
    L24:
        r.updateAllowUiJobScheduling(r2);
    L26:
        if (fgRequired == false) goto L39;
        Object r3 = this.mAm.mProcessStats.mLock;
        monitor-enter(r3);
        ServiceState stracker = r.getTracker();     // Catch: Throwable -> L32
        if (stracker == null) goto L34;
        boolean r9 = true;
        stracker.setForeground(true, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L32
    L35:
        monitor-exit(r3);     // Catch: Throwable -> L32
        this.mAm.mAppOpsService.startOperation(AppOpsManager.getToken(this.mAm.mAppOpsService), 76, r.appInfo.uid, r.packageName, null, true, false, null, false, 0, -1);
    L40:
        ServiceMap smap = getServiceMapLocked(r.userId);
        boolean addToStarting = false;
        if (callerFg == true) goto L83;
        if (fgRequired == true) goto L83;
        if (r.app != null) goto L83;
        if (this.mAm.mUserController.hasStartedUserState(r.userId) == false) goto L83;
        ProcessRecord proc = this.mAm.getProcessRecordLocked(r.processName, r.appInfo.uid);
        if (proc == null) goto L64;
        if (proc.mState.getCurProcState() > 11) goto L64;
        if (proc.mState.getCurProcState() < 10) goto L58;
        addToStarting = true;
        if (DEBUG_DELAYED_STARTS == false) goto L81;
        Slog.v("ActivityManager", "Not delaying, but counting as bg: " + r);
    L81:
        boolean addToStarting2 = addToStarting;
    L94:
        if (backgroundStartPrivileges.allowsAny() == false) goto L97;
        r.allowBgActivityStartsOnServiceStart(backgroundStartPrivileges);
    L97:
        ComponentName cmp = startServiceInnerLocked(smap, service, r, callerFg, addToStarting2, callingUid, callingProcessName, callingProcessState, wasStartRequested, r10);
        return cmp;
    L58:
        if (DEBUG_DELAYED_STARTS == false) goto L81;
        StringBuilder sb = new StringBuilder(128);
        sb.append("Not potential delay (state=");
        sb.append(proc.mState.getCurProcState());
        sb.append(' ');
        sb.append(proc.mState.getAdjType());
        String reason = proc.mState.makeAdjReason();
        if (reason == null) goto L62;
        sb.append(' ');
        sb.append(reason);
    L62:
        sb.append("): ");
        sb.append(r.toString());
        Slog.v("ActivityManager", sb.toString());
    L64:
        if (DEBUG_DELAYED_SERVICE == false) goto L67;
        Slog.v("ActivityManager", "Potential start delay of " + r + " in " + proc);
    L67:
        if (r.delayed == false) goto L74;
        if (DEBUG_DELAYED_STARTS == false) goto L72;
        Slog.v("ActivityManager", "Continuing to delay: " + r);
    L72:
        return r.name;
    L74:
        if (smap.mStartingBackground.size() < this.mMaxStartingBackground) goto L78;
        Slog.i("ActivityManager", "Delaying start of: " + r);
        smap.mDelayedStartList.add(r);
        r.delayed = r9;
        return r.name;
    L78:
        if (DEBUG_DELAYED_STARTS == false) goto L80;
        Slog.v("ActivityManager", "Not delaying: " + r);
    L80:
        addToStarting = true;
    L83:
        if (DEBUG_DELAYED_STARTS == false) goto L92;
        if (callerFg == true) goto L91;
        if (fgRequired == true) goto L91;
        if (r.app == null) goto L90;
        Slog.v("ActivityManager", "Not potential delay (cur app=" + r.app + "): " + r);
        goto L92
    L90:
        Slog.v("ActivityManager", "Not potential delay (user " + r.userId + " not started): " + r);
    L91:
        Slog.v("ActivityManager", "Not potential delay (callerFg=" + callerFg + " uid=" + callingUid + " pid=" + callingPid + " fgRequired=" + fgRequired + "): " + r);
    L92:
        addToStarting2 = false;
        goto L94
    L34:
        r9 = true;
    L32:
        th = move-exception;
        throw th;
    L39:
        r9 = true;
    L23:
        r2 = true;
        goto L24
    L22:
        r10 = callingPackage;
        goto L23
    L25:
        r10 = callingPackage;
        r.updateAllowUiJobScheduling(false);
        goto L26
    L10:
        if (r.fgRequired == true) goto L13;
        r5 = false;
        goto L14
    L5:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L7;
        Slog.v("ActivityManager", "START SERVICE WHILE RESTART PENDING: " + r);
        goto L7
    }

    private boolean requestStartTargetPermissionsReviewIfNeededLocked(final ServiceRecord r, String callingPackage, String callingFeatureId, int callingUid, final Intent service, final boolean callerFg, final int userId, boolean isBinding, final IServiceConnection connection) {
        if (this.mAm.getPackageManagerInternal().isPermissionsReviewRequired(r.packageName, r.userId) == false) goto L22;
        if (callerFg == true) goto L12;
        StringBuilder r0 = new StringBuilder();
        r0.append("u");
        r0.append(r.userId);
        if (isBinding == false) goto L9;
        String r3 = " Binding";
    L10:
        r0.append(r3);
        r0.append(" a service in package");
        r0.append(r.packageName);
        r0.append(" requires a permissions review");
        Slog.w("ActivityManager", r0.toString());
        return false;
    L9:
        r3 = " Starting";
        goto L10
    L12:
        final Intent intent = new Intent("android.intent.action.REVIEW_PERMISSIONS");
        intent.addFlags(411041792);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", r.packageName);
        if (isBinding == false) goto L15;
        RemoteCallback callback = new RemoteCallback(new AnonymousClass2(this, r, service, callerFg, connection));
        intent.putExtra("android.intent.extra.REMOTE_CALLBACK", callback);
    L17:
        if (ActivityManagerDebugConfig.DEBUG_PERMISSIONS_REVIEW == false) goto L19;
        Slog.i("ActivityManager", "u" + r.userId + " Launching permission review for package " + r.packageName);
    L19:
        this.mAm.mHandler.post(new AnonymousClass3(this, intent, userId));
        return false;
    L15:
        intent.putExtra("android.intent.extra.INTENT", new IntentSender(this.mAm.mPendingIntentController.getIntentSender(4, callingPackage, callingFeatureId, callingUid, userId, null, null, 0, new Intent[]{service}, new String[]{service.resolveType(this.mAm.mContext.getContentResolver())}, 1409286144, null)));
        goto L17
    L22:
        return true;
    }

    private boolean deferServiceBringupIfFrozenLocked(final ServiceRecord s, final Intent serviceIntent, final String callingPackage, final String callingFeatureId, final int callingUid, final int callingPid, final String callingProcessName, final int callingProcessState, final boolean fgRequired, final boolean callerFg, final int userId, final BackgroundStartPrivileges backgroundStartPrivileges, final boolean isBinding, final IServiceConnection connection) {
        PackageManagerInternal pm = this.mAm.getPackageManagerInternal();
        boolean frozen = pm.isPackageFrozen(s.packageName, callingUid, s.userId);
        if (frozen == true) goto L6;
        return false;
    L6:
        ArrayList<Runnable> curPendingBringups = this.mPendingBringups.get(s);
        if (curPendingBringups != null) goto L9;
        curPendingBringups = new ArrayList();
        this.mPendingBringups.put(s, curPendingBringups);
    L9:
        curPendingBringups.add(new AnonymousClass4(this, s, callingPackage, callingFeatureId, callingUid, serviceIntent, callerFg, userId, isBinding, connection, callingPid, callingProcessName, callingProcessState, fgRequired, backgroundStartPrivileges));
        return true;
    }

    void schedulePendingServiceStartLocked(String packageName, int userId) {
        int totalPendings = this.mPendingBringups.size();
        int i = totalPendings - 1;
    L3:
        if (i < 0) goto L22;
        if (totalPendings <= 0) goto L35;
        ServiceRecord r = this.mPendingBringups.keyAt(i);
        if (r.userId != userId) goto L21;
        if (TextUtils.equals(r.packageName, packageName) == false) goto L21;
        ArrayList<Runnable> curPendingBringups = this.mPendingBringups.valueAt(i);
        if (curPendingBringups == null) goto L16;
        int j = curPendingBringups.size() - 1;
    L13:
        if (j < 0) goto L15;
        curPendingBringups.get(j).run();
        j = j - 1;
        goto L13
    L15:
        curPendingBringups.clear();
    L16:
        int curTotalPendings = this.mPendingBringups.size();
        this.mPendingBringups.remove(r);
        if (totalPendings != curTotalPendings) goto L18;
        totalPendings = this.mPendingBringups.size();
        i = i - 1;
        goto L3
    L18:
        totalPendings = this.mPendingBringups.size();
        i = totalPendings - 1;
    L21:
        i = i - 1;
        goto L3
    L35:
        return;
    }

    ComponentName startServiceInnerLocked(ServiceMap smap, Intent service, ServiceRecord r, boolean callerFg, boolean addToStarting, int callingUid, String callingProcessName, int callingProcessState, boolean wasStartRequested, String callingPackage) throws TransactionTooLargeException {
        Object r3 = this.mAm.mProcessStats.mLock;
        monitor-enter(r3);
        ServiceState stracker = r.getTracker();     // Catch: Throwable -> L7
        if (stracker == null) goto L9;
        stracker.setStarted(true, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r3);     // Catch: Throwable -> L7
        r.callStart = false;
        int uid = r.appInfo.uid;
        String packageName = r.name.getPackageName();
        String serviceName = r.name.getClassName();
        FrameworkStatsLog.write(99, uid, packageName, serviceName, 1);
        this.mAm.mBatteryStatsService.noteServiceStartRunning(uid, packageName, serviceName);
        ProcessRecord hostApp = r.app;
        if (hostApp != null) goto L13;
        boolean wasStopped = r.appInfo.isStopped();
    L14:
        if (hostApp != null) goto L16;
        boolean firstLaunch = r.appInfo.isNotLaunched();
    L17:
        boolean wasStopped2 = wasStopped;
        boolean firstLaunch2 = firstLaunch;
        String error = bringUpServiceLocked(r, service.getFlags(), callerFg, false, false, false, true, 0);
        this.mAm.updateOomAdjPendingTargetsLocked(6);
        if (error == null) goto L22;
        return new ComponentName("!!", error);
    L22:
        if (wasStopped2 == false) goto L24;
        int packageState = 2;
    L26:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L28;
        StringBuilder r6 = new StringBuilder();
        r6.append("Logging startService for ");
        r6.append(packageName);
        r6.append(", stopped=");
        r6.append(wasStopped2);
        r6.append(", firstLaunch=");
        r6.append(firstLaunch2);
        r6.append(", intent=");
        Intent r7 = service;
        r6.append(r7);
        r6.append(", r.app=");
        r6.append(r.app);
        Slog.d("ActivityManager", r6.toString());
    L29:
        String r15 = r7.getAction();
        if (r.app != null) goto L32;
    L40:
        int r18 = 3;
    L41:
        FrameworkStatsLog.write(FrameworkStatsLog.SERVICE_REQUEST_EVENT_REPORTED, uid, callingUid, r15, 1, false, r18, getShortProcessNameForStats(callingUid, callingProcessName), getShortServiceNameForStats(r), packageState, packageName, callingPackage, callingProcessState, r.mProcessStateOnRequest, firstLaunch2, 0);
        if (r.startRequested == false) goto L58;
        if (addToStarting == false) goto L58;
        if (smap.mStartingBackground.size() != 0) goto L47;
        boolean first = true;
    L48:
        smap.mStartingBackground.add(r);
        r.startingBgTimeout = SystemClock.uptimeMillis() + this.mAm.mConstants.BG_START_TIMEOUT;
        if (DEBUG_DELAYED_SERVICE == false) goto L53;
        RuntimeException here = new RuntimeException("here");
        here.fillInStackTrace();
        Slog.v("ActivityManager", "Starting background (first=" + first + "): " + r, here);
    L55:
        if (first == false) goto L63;
        smap.rescheduleDelayedStartsLocked();
    L63:
        return r.name;
    L53:
        if (DEBUG_DELAYED_STARTS == false) goto L55;
        Slog.v("ActivityManager", "Starting background (first=" + first + "): " + r);
        goto L55
    L47:
        first = false;
    L58:
        if (callerFg == false) goto L60;
    L61:
        smap.ensureNotStartingBackgroundLocked(r);
        goto L63
    L60:
        if (r.fgRequired == false) goto L63;
    L32:
        if (r.app.getThread() == null) goto L40;
        if (wasStartRequested == false) goto L36;
    L39:
        r18 = 2;
        goto L41
    L36:
        if (r.getConnections().isEmpty() == false) goto L39;
        r18 = 1;
        goto L41
    L28:
        r7 = service;
        goto L29
    L24:
        packageState = 1;
        goto L26
    L16:
        firstLaunch = false;
        goto L17
    L13:
        wasStopped = false;
    L7:
        th = th;
    L70:
        throw th;
    L66:
        th = th;
        goto L70
    }

    private String getShortProcessNameForStats(int uid, String processName) {
        String[] packages = this.mAm.mContext.getPackageManager().getPackagesForUid(uid);
        if (packages != null) goto L5;
    L15:
        return processName;
    L5:
        if (packages.length != 1) goto L15;
        if (TextUtils.equals(packages[0], processName) == false) goto L10;
        return null;
    L10:
        if (processName == null) goto L15;
        if (processName.startsWith(packages[0]) == false) goto L15;
        return processName.substring(packages[0].length());
    }

    private String getShortServiceNameForStats(ServiceRecord r) {
        ComponentName cn = r.getComponentName();
        if (cn != null) goto L7;
        return null;
    L7:
        return cn.getShortClassName();
    }

    void stopServiceLocked(ServiceRecord service, boolean enqueueOomAdj) {
        traceInstant("stopService(): ", service);
        Trace.traceBegin(64, "stopServiceLocked()");     // Catch: Throwable -> L30
        if (service.delayed == true) goto L6;
        maybeStopShortFgsTimeoutLocked(service);     // Catch: Throwable -> L30
        maybeStopFgsTimeoutLocked(service);     // Catch: Throwable -> L30
        int uid = service.appInfo.uid;     // Catch: Throwable -> L30
        String packageName = service.name.getPackageName();     // Catch: Throwable -> L30
        String serviceName = service.name.getClassName();     // Catch: Throwable -> L30
        FrameworkStatsLog.write(99, uid, packageName, serviceName, 2);     // Catch: Throwable -> L30
        this.mAm.mBatteryStatsService.noteServiceStopRunning(uid, packageName, serviceName);     // Catch: Throwable -> L30
        this.mAm.mProcessStateController.setStartRequested(service, false);     // Catch: Throwable -> L30
        if (service.tracker == null) goto L23;
        Object r7 = this.mAm.mProcessStats.mLock;     // Catch: Throwable -> L8
        monitor-enter(r7);     // Catch: Throwable -> L8
        service.tracker.setStarted(false, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L23:
        service.callStart = false;     // Catch: Throwable -> L30
        bringDownServiceIfNeededLocked(service, false, false, enqueueOomAdj, "stopService");     // Catch: Throwable -> L28
        Trace.traceEnd(64);
        return;
    L28:
        th = th;
    L32:
        Trace.traceEnd(64);
        throw th;
    L6:
        if (DEBUG_DELAYED_STARTS == false) goto L10;
        Slog.v("ActivityManager", "Delaying stop of pending: " + service);     // Catch: Throwable -> L8
    L10:
        service.delayedStop = true;     // Catch: Throwable -> L8
        Trace.traceEnd(64);
        return;
    L8:
        th = th;
    L30:
        th = th;
        goto L32
    }

    int stopServiceLocked(IApplicationThread caller, Intent service, String resolvedType, int userId, boolean isSdkSandboxService, int sdkSandboxClientAppUid, String sdkSandboxClientAppPackage, String instanceName) {
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("stopService: ");
        r0.append(service);
        r0.append(" type=");
        String r8 = resolvedType;
        r0.append(r8);
        Slog.v("ActivityManager", r0.toString());
    L6:
        ProcessRecord callerApp = this.mAm.getRecordForAppLOSP(caller, true);
        if (caller == null) goto L13;
        if (callerApp != null) goto L13;
        throw new SecurityException("Unable to find app for caller " + caller + " (pid=" + this.mAm.mInjector.getCallingPid() + ") when stopping service " + service);
    L13:
        if (caller != null) goto L15;
    L17:
        ServiceLookupResult r = retrieveServiceLocked(service, instanceName, isSdkSandboxService, sdkSandboxClientAppUid, sdkSandboxClientAppPackage, r8, null, this.mAm.mInjector.getCallingPid(), this.mAm.mInjector.getCallingUid(), userId, false, false, false, false, null, false, false);
        if (r != null) goto L20;
        return 0;
    L20:
        if (r.record == null) goto L28;
        long origId = this.mAm.mInjector.clearCallingIdentity();
        stopServiceLocked(r.record, false);     // Catch: Throwable -> L25
        this.mAm.mInjector.restoreCallingIdentity(origId);
        return 1;
    L25:
        th = move-exception;
        this.mAm.mInjector.restoreCallingIdentity(origId);
        throw th;
    L28:
        return -1;
    L15:
        if (callerApp.getSmtEx().inFreezeStat() == false) goto L17;
        return 0;
    L5:
        r8 = resolvedType;
        goto L6
    }

    void stopInBackgroundLocked(int uid) {
        ServiceMap services = this.mServiceMap.get(UserHandle.getUserId(uid));
        ArrayList<ServiceRecord> stopping = null;
        if (services == null) goto L34;
        int i = services.mServicesByInstanceName.size() - 1;
    L5:
        if (i < 0) goto L19;
        ServiceRecord service = services.mServicesByInstanceName.valueAt(i);
        if (service.appInfo.uid != uid) goto L17;
        if (service.startRequested == false) goto L17;
        if (this.mAm.getAppStartModeLOSP(service.appInfo.uid, service.packageName, service.appInfo.targetSdkVersion, -1, false, false, false) == 0) goto L17;
        if (stopping != null) goto L14;
        stopping = new ArrayList();
    L14:
        String compName = service.shortInstanceName;
        EventLogTags.writeAmStopIdleService(service.appInfo.uid, compName);
        StringBuilder sb = new StringBuilder(64);
        sb.append("Stopping service due to app idle: ");
        UserHandle.formatUid(sb, service.appInfo.uid);
        sb.append(" ");
        TimeUtils.formatDuration(service.createRealTime - SystemClock.elapsedRealtime(), sb);
        sb.append(" ");
        sb.append(compName);
        Slog.w("ActivityManager", sb.toString());
        stopping.add(service);
        if (appRestrictedAnyInBackground(service.appInfo.uid, service.packageName) == false) goto L17;
        cancelForegroundNotificationLocked(service);
    L17:
        i = i - 1;
        goto L5
    L19:
        if (stopping == null) goto L35;
        int size = stopping.size();
        int i2 = size - 1;
    L21:
        if (i2 < 0) goto L24;
        ServiceRecord service2 = stopping.get(i2);
        service2.delayed = false;
        services.ensureNotStartingBackgroundLocked(service2);
        stopServiceLocked(service2, true);
        i2 = i2 - 1;
        goto L21
    L24:
        if (size <= 0) goto L36;
        this.mAm.updateOomAdjPendingTargetsLocked(18);
        return;
    L36:
        return;
    L35:
        return;
    }

    void killMisbehavingService(ServiceRecord r, int appUid, int appPid, String localPackageName, int exceptionTypeId) {
        ActivityManagerService r1 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
    L20:
        th = th;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L22:
        th = th;
        goto L24
    L30:
        if (r.destroying == true) goto L11;
        stopServiceLocked(r, false);     // Catch: Throwable -> L9
    L29:
    L14:
        this.mAm.crashApplicationWithType(appUid, appPid, localPackageName, -1, "Bad notification for startForeground", true, exceptionTypeId);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        ServiceMap smap = getServiceMapLocked(r.userId);     // Catch: Throwable -> L22
        ServiceRecord found = smap.mServicesByInstanceName.remove(r.instanceName);     // Catch: Throwable -> L22
        if (found == null) goto L14;
        stopServiceLocked(found, false);     // Catch: Throwable -> L9
    L9:
        th = th;
        goto L24
    }

    IBinder peekServiceLocked(Intent service, String resolvedType, String callingPackage) {
        ServiceLookupResult r = retrieveServiceLocked(service, null, resolvedType, callingPackage, this.mAm.mInjector.getCallingPid(), this.mAm.mInjector.getCallingUid(), UserHandle.getCallingUserId(), false, false, false, false, false, false);
        if (r != null) goto L5;
        return null;
    L5:
        if (r.record == null) goto L10;
        IntentBindRecord ib = r.record.bindings.get(r.record.intent);
        if (ib == null) goto L12;
        IBinder ret = ib.binder;
        return ret;
    L12:
        return null;
    L10:
        throw new SecurityException("Permission Denial: Accessing service from pid=" + this.mAm.mInjector.getCallingPid() + ", uid=" + this.mAm.mInjector.getCallingUid() + " requires " + r.permission);
    }

    boolean stopServiceTokenLocked(ComponentName className, IBinder token, int startId) {
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L5;
        Slog.v("ActivityManager", "stopServiceToken: " + className + " " + token + " startId=" + startId);
    L5:
        ServiceRecord r = findServiceLocked(className, token, UserHandle.getCallingUserId());
        if (r == null) goto L35;
        if (startId < 0) goto L22;
        ServiceRecord.StartItem si = r.findDeliveredStart(startId, false, false);
        if (si == null) goto L17;
    L11:
        if (r.deliveredStarts.size() <= 0) goto L17;
        ServiceRecord.StartItem cur = r.deliveredStarts.remove(0);
        cur.removeUriPermissionsLocked();
        if (cur != si) goto L11;
    L17:
        if (r.getLastStartId() == startId) goto L20;
        return false;
    L20:
        if (r.deliveredStarts.size() <= 0) goto L22;
        Slog.w("ActivityManager", "stopServiceToken startId " + startId + " is last, but have " + r.deliveredStarts.size() + " remaining args");
    L22:
        maybeStopShortFgsTimeoutLocked(r);
        maybeStopFgsTimeoutLocked(r);
        int uid = r.appInfo.uid;
        String packageName = r.name.getPackageName();
        String serviceName = r.name.getClassName();
        FrameworkStatsLog.write(99, uid, packageName, serviceName, 2);
        this.mAm.mBatteryStatsService.noteServiceStopRunning(uid, packageName, serviceName);
        this.mAm.mProcessStateController.setStartRequested(r, false);
        if (r.tracker == null) goto L32;
        Object r1 = this.mAm.mProcessStats.mLock;
        monitor-enter(r1);
        r.tracker.setStarted(false, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    L32:
        r.callStart = false;
        long origId = this.mAm.mInjector.clearCallingIdentity();
        bringDownServiceIfNeededLocked(r, false, false, false, "stopServiceToken");
        this.mAm.mInjector.restoreCallingIdentity(origId);
        return true;
    L35:
        return false;
    }

    public void setServiceForegroundLocked(ComponentName className, IBinder token, int id, Notification notification, int flags, int foregroundServiceType) {
        int userId = UserHandle.getCallingUserId();
        int callingUid = this.mAm.mInjector.getCallingUid();
        long origId = this.mAm.mInjector.clearCallingIdentity();
        if (StabTrace.isEnable() == false) goto L5;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L24:
        ServiceRecord r = findServiceLocked(className, token, userId);     // Catch: Throwable -> L11
        if (r == null) goto L13;
        setServiceForegroundInnerLocked(r, id, notification, flags, foregroundServiceType, callingUid, false);     // Catch: Throwable -> L11
    L13:
        this.mAm.mInjector.restoreCallingIdentity(origId);
        if (StabTrace.isEnable() == false) goto L21;
        StringBuilder sb = new StringBuilder(150);
        sb.append("setServiceFG:");
        if (className == null) goto L18;
        String r2 = className.getClassName();
    L19:
        sb.append(r2);
        sb.append("callUid=" + userId);
        sb.append("fgtype=");
        sb.append(foregroundServiceType);
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());
        return;
    L18:
        r2 = "";
        goto L19
    L21:
        return;
    L11:
        th = move-exception;
        this.mAm.mInjector.restoreCallingIdentity(origId);
        throw th;
    L5:
        beginTime2 = 0;
        goto L24
    }

    public int getForegroundServiceTypeLocked(ComponentName className, IBinder token) {
        int userId = UserHandle.getCallingUserId();
        long origId = this.mAm.mInjector.clearCallingIdentity();
        int ret = 0;
        ServiceRecord r = findServiceLocked(className, token, userId);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        ret = r.foregroundServiceType;     // Catch: Throwable -> L7
    L9:
        this.mAm.mInjector.restoreCallingIdentity(origId);
        return ret;
    L7:
        th = move-exception;
        this.mAm.mInjector.restoreCallingIdentity(origId);
        throw th;
    }

    boolean foregroundAppShownEnoughLocked(ActiveForegroundApp aa, long nowElapsed) {
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L5;
        Slog.d("ActivityManager", "Shown enough: pkg=" + aa.mPackageName + ", uid=" + aa.mUid);
    L5:
        aa.mHideTime = Long.MAX_VALUE;
        if (aa.mShownWhileTop == false) goto L11;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L42;
        Slog.d("ActivityManager", "YES - shown while on top");
        return true;
    L42:
        return true;
    L11:
        if (this.mScreenOn == false) goto L13;
    L24:
        long minTime = aa.mStartVisibleTime;
        if (aa.mStartTime == aa.mStartVisibleTime) goto L27;
        long r6 = this.mAm.mConstants.FGSERVICE_SCREEN_ON_AFTER_TIME;
    L28:
        long minTime2 = minTime + r6;
        if (nowElapsed >= minTime2) goto L31;
        long reportTime = this.mAm.mConstants.FGSERVICE_MIN_REPORT_TIME + nowElapsed;
        if (reportTime <= minTime2) goto L37;
        long r8 = reportTime;
    L38:
        aa.mHideTime = r8;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L49;
        Slog.d("ActivityManager", "NO -- wait " + (aa.mHideTime - nowElapsed) + " with screen on");
        return false;
    L49:
        return false;
    L37:
        r8 = minTime2;
        goto L38
    L31:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L33;
        Slog.d("ActivityManager", "YES - shown long enough with screen on");
    L33:
        return true;
    L27:
        r6 = this.mAm.mConstants.FGSERVICE_MIN_SHOWN_TIME;
        goto L28
    L13:
        if (aa.mShownWhileScreenOn == true) goto L24;
        long minTime3 = aa.mEndTime + this.mAm.mConstants.FGSERVICE_SCREEN_ON_BEFORE_TIME;
        if (nowElapsed >= minTime3) goto L18;
        aa.mHideTime = minTime3;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L45;
        Slog.d("ActivityManager", "NO -- wait " + (aa.mHideTime - nowElapsed) + " with screen off");
        return false;
    L45:
        return false;
    L18:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L20;
        Slog.d("ActivityManager", "YES - gone long enough with screen off");
    L20:
        return true;
    }

    void updateForegroundApps(ServiceMap smap) {
        ActivityManagerService r0 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        long nextUpdateTime = Long.MAX_VALUE;
        if (smap != null) goto L7;
    L42:
        smap.mActiveForegroundAppsChanged = false;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L11;
        Slog.d("ActivityManager", "Updating foreground apps for user " + smap.mUserId);     // Catch: Throwable -> L9
    L11:
        smap.mPendingRemoveForegroundApps.clear();     // Catch: Throwable -> L9
        int i = smap.mActiveForegroundApps.size() - 1;     // Catch: Throwable -> L9
    L12:
        if (i < 0) goto L33;
        ActiveForegroundApp aa = smap.mActiveForegroundApps.valueAt(i);     // Catch: Throwable -> L9
        if (aa.mEndTime == 0) goto L21;
        boolean canRemove = foregroundAppShownEnoughLocked(aa, now);     // Catch: Throwable -> L9
        if (canRemove == false) goto L19;
        smap.mPendingRemoveForegroundApps.add(smap.mActiveForegroundApps.keyAt(i));     // Catch: Throwable -> L9
        smap.mActiveForegroundAppsChanged = true;     // Catch: Throwable -> L9
    L32:
        i = i - 1;     // Catch: Throwable -> L9
        goto L12
    L19:
        if (aa.mHideTime >= nextUpdateTime) goto L21;
        nextUpdateTime = aa.mHideTime;     // Catch: Throwable -> L9
    L21:
        boolean canRemove2 = aa.mAppOnTop;     // Catch: Throwable -> L9
        if (canRemove2 == true) goto L32;
        if (isForegroundServiceAllowedInBackgroundRestricted(aa.mUid, aa.mPackageName) == false) goto L29;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L32;
        Slog.d("ActivityManager", "Adding active: pkg=" + aa.mPackageName + ", uid=" + aa.mUid);     // Catch: Throwable -> L9
        goto L32
    L29:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L31;
        Slog.d("ActivityManager", "bg-restricted app " + aa.mPackageName + SliceClientPermissions.SliceAuthority.DELIMITER + aa.mUid + " exiting top; demoting fg services ");     // Catch: Throwable -> L9
    L31:
        stopAllForegroundServicesLocked(aa.mUid, aa.mPackageName);     // Catch: Throwable -> L9
        goto L32
    L33:
        int i2 = smap.mPendingRemoveForegroundApps.size() - 1;     // Catch: Throwable -> L9
    L34:
        if (i2 < 0) goto L36;
        smap.mActiveForegroundApps.remove(smap.mPendingRemoveForegroundApps.get(i2));     // Catch: Throwable -> L9
        i2 = i2 - 1;     // Catch: Throwable -> L9
        goto L34
    L36:
        smap.removeMessages(2);     // Catch: Throwable -> L9
        if (nextUpdateTime >= Long.MAX_VALUE) goto L42;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L41;
        Slog.d("ActivityManager", "Next update time in: " + (nextUpdateTime - now));     // Catch: Throwable -> L9
    L41:
        Message msg = smap.obtainMessage(2);     // Catch: Throwable -> L9
        smap.sendMessageAtTime(msg, (SystemClock.uptimeMillis() + nextUpdateTime) - SystemClock.elapsedRealtime());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void requestUpdateActiveForegroundAppsLocked(ServiceMap smap, long timeElapsed) {
        Message msg = smap.obtainMessage(2);
        if (timeElapsed == 0) goto L5;
        smap.sendMessageAtTime(msg, (SystemClock.uptimeMillis() + timeElapsed) - SystemClock.elapsedRealtime());
        return;
    L5:
        smap.mActiveForegroundAppsChanged = true;
        smap.sendMessage(msg);
    }

    private void decActiveForegroundAppLocked(ServiceMap smap, ServiceRecord r) {
        ActiveForegroundApp active = smap.mActiveForegroundApps.get(r.packageName);
        if (active == null) goto L16;
        active.mNumActive--;
        if (active.mNumActive > 0) goto L17;
        active.mEndTime = SystemClock.elapsedRealtime();
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L10;
        Slog.d("ActivityManager", "Ended running of service");
    L10:
        if (foregroundAppShownEnoughLocked(active, active.mEndTime) == false) goto L13;
        smap.mActiveForegroundApps.remove(r.packageName);
        smap.mActiveForegroundAppsChanged = true;
        requestUpdateActiveForegroundAppsLocked(smap, 0);
        return;
    L13:
        if (active.mHideTime >= Long.MAX_VALUE) goto L19;
        requestUpdateActiveForegroundAppsLocked(smap, active.mHideTime);
        return;
    L19:
        return;
    L17:
        return;
    }

    void updateScreenStateLocked(boolean screenOn) {
        if (this.mScreenOn == screenOn) goto L38;
        this.mScreenOn = screenOn;
        if (screenOn == false) goto L49;
        long nowElapsed = SystemClock.elapsedRealtime();
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L9;
        Slog.d("ActivityManager", "Screen turned on");
    L9:
        int i = this.mServiceMap.size() - 1;
    L10:
        if (i < 0) goto L50;
        ServiceMap smap = this.mServiceMap.valueAt(i);
        long nextUpdateTime = Long.MAX_VALUE;
        boolean changed = false;
        int j = smap.mActiveForegroundApps.size() - 1;
    L13:
        if (j < 0) goto L32;
        ActiveForegroundApp active = smap.mActiveForegroundApps.valueAt(j);
        if (active.mEndTime != 0) goto L20;
        if (active.mShownWhileScreenOn == true) goto L30;
        active.mShownWhileScreenOn = true;
        active.mStartVisibleTime = nowElapsed;
    L30:
        j = j - 1;
        goto L13
    L20:
        if (active.mShownWhileScreenOn == true) goto L25;
        if (active.mStartVisibleTime != active.mStartTime) goto L25;
        active.mStartVisibleTime = nowElapsed;
        active.mEndTime = nowElapsed;
    L25:
        if (foregroundAppShownEnoughLocked(active, nowElapsed) == false) goto L28;
        smap.mActiveForegroundApps.remove(active.mPackageName);
        smap.mActiveForegroundAppsChanged = true;
        changed = true;
        goto L30
    L28:
        if (active.mHideTime >= nextUpdateTime) goto L30;
        nextUpdateTime = active.mHideTime;
        goto L30
    L32:
        if (changed == false) goto L35;
        requestUpdateActiveForegroundAppsLocked(smap, 0);
    L37:
        i = i - 1;
        goto L10
    L35:
        if (nextUpdateTime >= Long.MAX_VALUE) goto L37;
        requestUpdateActiveForegroundAppsLocked(smap, nextUpdateTime);
        goto L37
    L50:
        return;
    L49:
        return;
    }

    void foregroundServiceProcStateChangedLocked(UidRecord uidRec) {
        ServiceMap smap = this.mServiceMap.get(UserHandle.getUserId(uidRec.getUid()));
        if (smap == null) goto L27;
        boolean changed = false;
        int j = smap.mActiveForegroundApps.size() - 1;
    L5:
        if (j < 0) goto L19;
        ActiveForegroundApp active = smap.mActiveForegroundApps.valueAt(j);
        if (active.mUid != uidRec.getUid()) goto L17;
        if (uidRec.getCurProcState() > 2) goto L15;
        if (active.mAppOnTop == true) goto L13;
        active.mAppOnTop = true;
        changed = true;
    L13:
        active.mShownWhileTop = true;
        goto L17
    L15:
        if (active.mAppOnTop == false) goto L17;
        active.mAppOnTop = false;
        changed = true;
    L17:
        j = j - 1;
        goto L5
    L19:
        if (changed == false) goto L28;
        requestUpdateActiveForegroundAppsLocked(smap, 0);
        return;
    L28:
        return;
    }

    private boolean isForegroundServiceAllowedInBackgroundRestricted(ProcessRecord app) {
        ProcessStateRecord state = app.mState;
        if (isDeviceProvisioningPackage(app.info.packageName) == false) goto L6;
        return true;
    L6:
        if (state.isBackgroundRestricted() == true) goto L8;
    L17:
        return true;
    L8:
        if (state.getSetProcState() <= 3) goto L17;
        if (state.getSetProcState() == 4) goto L13;
        return false;
    L13:
        if (state.isSetBoundByNonBgRestrictedApp() == false) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean isForegroundServiceAllowedInBackgroundRestricted(int uid, String packageName) {
        UidRecord uidRec = this.mAm.mProcessList.getUidRecordLOSP(uid);
        if (uidRec == null) goto L9;
        ProcessRecord app = uidRec.getProcessInPackage(packageName);
        if (app == null) goto L9;
        if (isForegroundServiceAllowedInBackgroundRestricted(app) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isTempAllowedByAlarmClock(int uid) {
        ActivityManagerService.FgsTempAllowListItem item = this.mAm.isAllowlistedForFgsStartLOSP(uid);
        if (item != null) goto L5;
        return false;
    L5:
        if (item.mReasonCode != 301) goto L9;
        return true;
    L9:
        return false;
    }

    void logFgsApiBeginLocked(int uid, int pid, int apiType) {
        ForegroundServiceTypeLoggerModule r0 = this.mFGSLogger;
        monitor-enter(r0);
        this.mFGSLogger.logForegroundServiceApiEventBegin(uid, pid, apiType, "");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void logFgsApiEndLocked(int uid, int pid, int apiType) {
        ForegroundServiceTypeLoggerModule r0 = this.mFGSLogger;
        monitor-enter(r0);
        this.mFGSLogger.logForegroundServiceApiEventEnd(uid, pid, apiType);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void logFgsApiStateChangedLocked(int uid, int pid, int apiType, int state) {
        ForegroundServiceTypeLoggerModule r0 = this.mFGSLogger;
        monitor-enter(r0);
        this.mFGSLogger.logForegroundServiceApiStateChanged(uid, pid, apiType, state);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 25341. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    private void setServiceForegroundInnerLocked(com.android.server.am.ServiceRecord r55, int r56, android.app.Notification r57, int r58, int r59, int r60, boolean r61) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = (r54v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] (LINE:2357) in method: com.android.server.am.ActiveServices.setServiceForegroundInnerLocked(com.android.server.am.ServiceRecord, int, android.app.Notification, int, int, int, boolean):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.am.ActiveServices.setServiceForegroundInnerLocked(com.android.server.am.ServiceRecord, int, android.app.Notification, int, int, int, boolean):void");
    }

    private boolean withinFgsDeferRateLimit(ServiceRecord sr, long now) {
        if (now < sr.fgDisplayTime) goto L5;
        int uid = sr.appInfo.uid;
        long eligible = this.mFgsDeferralEligible.get(uid, 0);
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L14;
        if (now >= eligible) goto L14;
        Slog.d("ActivityManager", "FGS transition for uid " + uid + " within rate limit, showing immediately");
    L14:
        if (now >= eligible) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L7;
        Slog.d("ActivityManager", "FGS transition for " + sr + " within deferral period, no rate limit applied");
    L7:
        return false;
    }

    private Pair<Integer, RuntimeException> validateForegroundServiceType(ServiceRecord r, int type, int defaultToType, int startType) {
        ForegroundServiceTypePolicy policy = ForegroundServiceTypePolicy.getDefaultPolicy();
        ForegroundServiceTypePolicy.ForegroundServiceTypePolicyInfo policyInfo = policy.getForegroundServiceTypePolicyInfo(type, defaultToType);
        int code = policy.checkForegroundServiceTypePolicy(this.mAm.mContext, r.packageName, r.app.uid, r.app.getPid(), r.isFgsAllowedWiu_forStart(), policyInfo);
        RuntimeException exception = null;
        String r6 = "";
        switch(code) {
            case 2: goto L20;
            case 3: goto L16;
            case 4: goto L10;
            case 5: goto L5;
            default: goto L22;
        };
    L5:
        StringBuilder r11 = new StringBuilder();
        r11.append("Starting FGS with type ");
        r11.append(ServiceInfo.foregroundServiceTypeToLabel(type));
        r11.append(" callerApp=");
        r11.append(r.app);
        r11.append(" targetSDK=");
        r11.append(r.app.info.targetSdkVersion);
        r11.append(" requires permissions: ");
        r11.append(policyInfo.toPermissionString());
        if (policyInfo.hasForegroundOnlyPermission() == false) goto L9;
        r6 = " and the app must be in the eligible state/exemptions to access the foreground only permission";
    L9:
        r11.append(r6);
        exception = new SecurityException(r11.toString());
        goto L22
    L10:
        StringBuilder r15 = new StringBuilder();
        r15.append("Starting FGS with type ");
        r15.append(ServiceInfo.foregroundServiceTypeToLabel(type));
        r15.append(" code=");
        r15.append(code);
        r15.append(" callerApp=");
        r15.append(r.app);
        r15.append(" targetSDK=");
        r15.append(r.app.info.targetSdkVersion);
        r15.append(" requiredPermissions=");
        r15.append(policyInfo.toPermissionString());
        if (policyInfo.hasForegroundOnlyPermission() == false) goto L14;
        r6 = " and the app must be in the eligible state/exemptions to access the foreground only permission";
    L14:
        r15.append(r6);
        String msg = r15.toString();
        Slog.wtfQuiet("ActivityManager", msg);
        Slog.w("ActivityManager", msg);
        goto L22
    L20:
        String msg2 = "Starting FGS with type " + ServiceInfo.foregroundServiceTypeToLabel(type) + " code=" + code + " callerApp=" + r.app + " targetSDK=" + r.app.info.targetSdkVersion;
        Slog.wtfQuiet("ActivityManager", msg2);
        Slog.w("ActivityManager", msg2);
    L22:
        return Pair.create(Integer.valueOf(code), exception);
    L16:
        if (startType != (-1)) goto L19;
        if (type != 0) goto L19;
        exception = new MissingForegroundServiceTypeException("Starting FGS without a type  callerApp=" + r.app + " targetSDK=" + r.app.info.targetSdkVersion);
    L19:
        exception = new InvalidForegroundServiceTypeException("Starting FGS with type " + ServiceInfo.foregroundServiceTypeToLabel(type) + " callerApp=" + r.app + " targetSDK=" + r.app.info.targetSdkVersion + " has been prohibited");
        goto L22
    }

    private void initSystemExemptedFgsTypePermission() {
        ForegroundServiceTypePolicy policy = ForegroundServiceTypePolicy.getDefaultPolicy();
        ForegroundServiceTypePolicy.ForegroundServiceTypePolicyInfo policyInfo = policy.getForegroundServiceTypePolicyInfo(1024, 0);
        if (policyInfo == null) goto L6;
        policyInfo.setCustomPermission(new SystemExemptedFgsTypePermission(this));
        return;
    }

    private void initMediaProjectFgsTypeCustomPermission() {
        ForegroundServiceTypePolicy policy = ForegroundServiceTypePolicy.getDefaultPolicy();
        ForegroundServiceTypePolicy.ForegroundServiceTypePolicyInfo policyInfo = policy.getForegroundServiceTypePolicyInfo(32, 0);
        if (policyInfo == null) goto L6;
        policyInfo.setCustomPermission(new MediaProjectionFgsTypeCustomPermission(this));
        return;
    }

    ActivityManagerInternal.ServiceNotificationPolicy applyForegroundServiceNotificationLocked(Notification notification, String tag, int id, String pkg, int userId) {
        if (tag == null) goto L6;
        return ActivityManagerInternal.ServiceNotificationPolicy.NOT_FOREGROUND_SERVICE;
    L6:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L8;
        Slog.d("ActivityManager", "Evaluating FGS policy for id=" + id + " pkg=" + pkg + " not=" + notification);
    L8:
        ServiceMap smap = this.mServiceMap.get(userId);
        if (smap == null) goto L11;
        int i = 0;
    L14:
        if (i >= smap.mServicesByInstanceName.size()) goto L39;
        ServiceRecord sr = smap.mServicesByInstanceName.valueAt(i);
        if (sr.isForeground == false) goto L37;
        if (id != sr.foregroundId) goto L37;
        if (pkg.equals(sr.appInfo.packageName) == false) goto L37;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L25;
        Slog.d("ActivityManager", "   FOUND: notification is for " + sr);
    L25:
        notification.flags |= 64;
        sr.foregroundNoti = notification;
        boolean showNow = shouldShowFgsNotificationLocked(sr);
        if (showNow == false) goto L33;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L30;
        Slog.d("ActivityManager", "   Showing immediately due to policy");
    L30:
        sr.mFgsNotificationDeferred = false;
        return ActivityManagerInternal.ServiceNotificationPolicy.SHOW_IMMEDIATELY;
    L33:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L35;
        Slog.d("ActivityManager", "   Deferring / update-only");
    L35:
        startFgsDeferralTimerLocked(sr);
        return ActivityManagerInternal.ServiceNotificationPolicy.UPDATE_ONLY;
    L37:
        i = i + 1;
        goto L14
    L39:
        return ActivityManagerInternal.ServiceNotificationPolicy.NOT_FOREGROUND_SERVICE;
    L11:
        return ActivityManagerInternal.ServiceNotificationPolicy.NOT_FOREGROUND_SERVICE;
    }

    private boolean shouldShowFgsNotificationLocked(ServiceRecord r) {
        long now = SystemClock.uptimeMillis();
        if (this.mAm.mConstants.mFlagFgsNotificationDeferralEnabled == true) goto L6;
        return true;
    L6:
        if (r.mFgsNotificationDeferred == false) goto L14;
        if (now < r.fgDisplayTime) goto L14;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L12;
        Slog.d("ActivityManager", "FGS reached end of deferral period: " + r);
    L12:
        return true;
    L14:
        if (withinFgsDeferRateLimit(r, now) == false) goto L17;
        return true;
    L17:
        if (this.mAm.mConstants.mFlagFgsNotificationDeferralApiGated == true) goto L19;
    L24:
        boolean isLegacyApp = r.mFgsNotificationShown;
        if (isLegacyApp == false) goto L28;
        return true;
    L28:
        if (r.foregroundNoti.isForegroundDisplayForceDeferred() == true) goto L42;
        if (r.foregroundNoti.shouldShowForegroundImmediately() == false) goto L36;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L34;
        Slog.d("ActivityManager", "FGS " + r + " notification policy says show immediately");
    L34:
        return true;
    L36:
        if ((r.foregroundServiceType & 54) != 0) goto L38;
    L44:
        return false;
    L38:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L40;
        Slog.d("ActivityManager", "FGS " + r + " type gets immediate display");
    L40:
        return true;
    L42:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L44;
        Slog.d("ActivityManager", "FGS " + r + " notification is app deferred");
        goto L44
    L19:
        if (r.appInfo.targetSdkVersion >= 31) goto L21;
        boolean isLegacyApp2 = true;
    L22:
        if (isLegacyApp2 == false) goto L24;
        return true;
    L21:
        isLegacyApp2 = false;
        goto L22
    }

    private void startFgsDeferralTimerLocked(ServiceRecord r) {
        long now = SystemClock.uptimeMillis();
        int uid = r.appInfo.uid;
        if (r.isShortFgs() == false) goto L5;
        long r3 = this.mAm.mConstants.mFgsNotificationDeferralIntervalForShort;
    L6:
        long when = r3 + now;
        int i = 0;
    L8:
        if (i >= this.mPendingFgsNotifications.size()) goto L20;
        ServiceRecord pending = this.mPendingFgsNotifications.get(i);
        if (pending == r) goto L12;
        if (uid != pending.appInfo.uid) goto L18;
        when = Math.min(when, pending.fgDisplayTime);
    L18:
        i = i + 1;
        goto L8
    L12:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L41;
        Slog.d("ActivityManager", "FGS " + r + " already pending notification display");
        return;
    L41:
        return;
    L20:
        if (this.mFgsDeferralRateLimited == true) goto L22;
    L26:
        r.fgDisplayTime = when;
        boolean isLegacyApp = true;
        r.mFgsNotificationDeferred = true;
        r.mFgsNotificationWasDeferred = true;
        r.mFgsNotificationShown = false;
        this.mPendingFgsNotifications.add(r);
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L30;
        Slog.d("ActivityManager", "FGS " + r + " notification in " + (when - now) + " ms");
    L30:
        if (r.appInfo.targetSdkVersion < 31) goto L33;
        isLegacyApp = false;
    L33:
        if (isLegacyApp == false) goto L35;
        Slog.i("ActivityManager", "Deferring FGS notification in legacy app " + r.appInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + UserHandle.formatUid(r.appInfo.uid) + " : " + r.foregroundNoti);
    L35:
        this.mAm.mHandler.postAtTime(this.mPostDeferredFGSNotifications, when);
        return;
    L22:
        if (r.isShortFgs() == false) goto L24;
        long r5 = this.mAm.mConstants.mFgsNotificationDeferralExclusionTimeForShort;
    L25:
        long nextEligible = r5 + when;
        this.mFgsDeferralEligible.put(uid, nextEligible);
        goto L26
    L24:
        r5 = this.mAm.mConstants.mFgsNotificationDeferralExclusionTime;
        goto L25
    L5:
        r3 = this.mAm.mConstants.mFgsNotificationDeferralInterval;
        goto L6
    }

    boolean enableFgsNotificationRateLimitLocked(boolean enable) {
        if (enable == this.mFgsDeferralRateLimited) goto L7;
        this.mFgsDeferralRateLimited = enable;
        if (enable == true) goto L7;
        this.mFgsDeferralEligible.clear();
    L7:
        return enable;
    }

    private void removeServiceNotificationDeferralsLocked(String packageName, int userId) {
        int i = this.mPendingFgsNotifications.size() - 1;
    L3:
        if (i < 0) goto L13;
        ServiceRecord r = this.mPendingFgsNotifications.get(i);
        if (userId != r.userId) goto L11;
        if (r.appInfo.packageName.equals(packageName) == false) goto L11;
        this.mPendingFgsNotifications.remove(i);
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L11;
        Slog.d("ActivityManager", "Removing notification deferral for " + r);
    L11:
        i = i - 1;
        goto L3
    }

    public void onForegroundServiceNotificationUpdateLocked(boolean shown, Notification notification, int id, String pkg, int userId) {
        int i = this.mPendingFgsNotifications.size() - 1;
    L4:
        if (i < 0) goto L20;
        ServiceRecord sr = this.mPendingFgsNotifications.get(i);
        if (userId != sr.userId) goto L19;
        if (id != sr.foregroundId) goto L19;
        if (sr.appInfo.packageName.equals(pkg) == false) goto L19;
        if (shown == false) goto L17;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L15;
        Slog.d("ActivityManager", "Notification shown; canceling deferral of " + sr);
    L15:
        sr.mFgsNotificationShown = true;
        sr.mFgsNotificationDeferred = false;
        this.mPendingFgsNotifications.remove(i);
        goto L19
    L17:
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L19;
        Slog.d("ActivityManager", "FGS notification deferred for " + sr);
    L19:
        i = i - 1;
        goto L4
    L20:
        ServiceMap smap = this.mServiceMap.get(userId);
        if (smap == null) goto L36;
        int i2 = 0;
    L24:
        if (i2 >= smap.mServicesByInstanceName.size()) goto L49;
        ServiceRecord sr2 = smap.mServicesByInstanceName.valueAt(i2);
        if (sr2.isForeground == false) goto L35;
        if (id != sr2.foregroundId) goto L35;
        if (sr2.appInfo.packageName.equals(pkg) == false) goto L35;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L34;
        Slog.d("ActivityManager", "Recording shown notification for " + sr2);
    L34:
        sr2.foregroundNoti = notification;
    L35:
        i2 = i2 + 1;
        goto L24
    L49:
        return;
    }

    private void registerAppOpCallbackLocked(ServiceRecord r) {
        if (r.app != null) goto L5;
        return;
    L5:
        int uid = r.appInfo.uid;
        AppOpCallback callback = this.mFgsAppOpCallbacks.get(uid);
        if (callback != null) goto L8;
        callback = new AppOpCallback(r.app, this.mAm.getAppOpsManager());
        this.mFgsAppOpCallbacks.put(uid, callback);
    L8:
        callback.registerLocked();
    }

    private void unregisterAppOpCallbackLocked(ServiceRecord r) {
        int uid = r.appInfo.uid;
        AppOpCallback callback = this.mFgsAppOpCallbacks.get(uid);
        if (callback == null) goto L8;
        callback.unregisterLocked();
        if (callback.isObsoleteLocked() == false) goto L9;
        this.mFgsAppOpCallbacks.remove(uid);
        return;
    L9:
        return;
    }

    private void cancelForegroundNotificationLocked(ServiceRecord r) {
        if (r.foregroundNoti == null) goto L30;
        ServiceMap sm = getServiceMapLocked(r.userId);
        if (sm == null) goto L21;
        int i = sm.mServicesByInstanceName.size() - 1;
    L7:
        if (i < 0) goto L21;
        ServiceRecord other = sm.mServicesByInstanceName.valueAt(i);
        if (other == r) goto L20;
        if (other.isForeground == false) goto L20;
        if (other.foregroundId != r.foregroundId) goto L20;
        if (other.packageName.equals(r.packageName) == false) goto L20;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L29;
        Slog.i("ActivityManager", "FGS notification for " + r + " shared by " + other + " (isForeground=" + other.isForeground + ") - NOT cancelling");
        return;
    L29:
        return;
    L20:
        i = i - 1;
    L21:
        r.cancelNotification();
        return;
    }

    private void updateServiceForegroundLocked(ProcessServiceRecord psr, boolean oomAdj) {
        int i = psr.numberOfRunningServices() - 1;
        boolean anyForeground = false;
        int fgServiceTypes = 0;
        boolean hasTypeNone = false;
    L3:
        if (i < 0) goto L13;
        ServiceRecord sr = psr.getRunningServiceAt(i);
        if (sr.isForeground == false) goto L7;
    L8:
        int fgServiceTypes2 = sr.foregroundServiceType | fgServiceTypes;
        if (sr.foregroundServiceType != 0) goto L11;
        anyForeground = true;
        fgServiceTypes = fgServiceTypes2;
        hasTypeNone = true;
    L12:
        i = i - 1;
        goto L3
    L11:
        anyForeground = true;
        fgServiceTypes = fgServiceTypes2;
        goto L12
    L7:
        if (sr.fgRequired == false) goto L12;
    L13:
        this.mAm.updateProcessForegroundLocked(psr.mApp, anyForeground, fgServiceTypes, hasTypeNone, oomAdj);
        psr.setHasReportedForegroundServices(anyForeground);
    }

    void unscheduleShortFgsTimeoutLocked(ServiceRecord sr) {
        this.mShortFGSAnrTimer.cancel(sr);
        this.mAm.mHandler.removeMessages(77, sr);
        this.mAm.mHandler.removeMessages(76, sr);
    }

    private void maybeUpdateShortFgsTrackingLocked(ServiceRecord sr, boolean extendTimeout) {
        if (sr.isShortFgs() == true) goto L6;
        this.mAm.mProcessStateController.clearShortFgsInfo(sr);
        unscheduleShortFgsTimeoutLocked(sr);
        return;
    L6:
        boolean isAlreadyShortFgs = sr.hasShortFgsInfo();
        if (extendTimeout == true) goto L15;
        if (isAlreadyShortFgs == false) goto L15;
        if (DEBUG_SHORT_SERVICE == false) goto L13;
        Slog.w("ActivityManager", "NOT extending SHORT_SERVICE time out: " + sr);
    L13:
        sr.getShortFgsInfo().update();
        return;
    L15:
        if (DEBUG_SHORT_SERVICE == false) goto L19;
        if (isAlreadyShortFgs == false) goto L18;
        Slog.i("ActivityManager", "Extending SHORT_SERVICE time out: " + sr);
        goto L19
    L18:
        Slog.i("ActivityManager", "Short FGS started: " + sr);
    L19:
        traceInstant("short FGS start/extend: ", sr);
        this.mAm.mProcessStateController.setShortFgsInfo(sr, SystemClock.uptimeMillis());
        unscheduleShortFgsTimeoutLocked(sr);
        Message msg = this.mAm.mHandler.obtainMessage(76, sr);
        this.mAm.mHandler.sendMessageAtTime(msg, sr.getShortFgsInfo().getTimeoutTime());
    }

    private void maybeStopShortFgsTimeoutLocked(ServiceRecord sr) {
        this.mAm.mProcessStateController.clearShortFgsInfo(sr);
        if (sr.isShortFgs() == true) goto L6;
        return;
    L6:
        if (DEBUG_SHORT_SERVICE == false) goto L8;
        Slog.i("ActivityManager", "Stop short FGS timeout: " + sr);
    L8:
        unscheduleShortFgsTimeoutLocked(sr);
    }

    void onShortFgsTimeout(ServiceRecord sr) {
        ActivityManagerService r1 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        long nowUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L34
        if (sr.shouldTriggerShortFgsTimeout(nowUptime) == false) goto L7;
        Slog.e("ActivityManager", "Short FGS timed out: " + sr);     // Catch: Throwable -> L34
        traceInstant("short FGS timeout: ", sr);     // Catch: Throwable -> L34
        if (nowUptime > sr.mFgsEnterTime) goto L18;
        int r0 = 0;
    L42:
        logFGSStateChangeLocked(sr, 5, r0, 0, 0, 0, false);     // Catch: Throwable -> L25
        sr.app.getSmtEx().getThread().scheduleTimeoutService(sr, sr.getShortFgsInfo().getStartId());     // Catch: Throwable -> L25 RemoteException -> L27
    L30:
        Message msg = this.mAm.mHandler.obtainMessage(77, sr);     // Catch: Throwable -> L25
        this.mAm.mHandler.sendMessageAtTime(msg, sr.getShortFgsInfo().getProcStateDemoteTime());     // Catch: Throwable -> L25
        this.mShortFGSAnrTimer.start(sr, sr.getShortFgsInfo().getAnrTime() - SystemClock.uptimeMillis());     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L27:
        e = move-exception;
        Slog.w("ActivityManager", "Exception from scheduleTimeoutService: " + e.toString());     // Catch: Throwable -> L25
    L25:
        th = th;
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L25
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L18:
        r0 = (int) (nowUptime - sr.mFgsEnterTime);
        goto L42
    L7:
        if (DEBUG_SHORT_SERVICE == false) goto L11;
        Slog.d("ActivityManager", "[STALE] Short FGS timed out: " + sr + " " + sr.getShortFgsTimedEventDescription(nowUptime));     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = th;
    L34:
        th = th;
        goto L36
    }

    boolean shouldServiceTimeOutLocked(ComponentName className, IBinder token) {
        int userId = UserHandle.getCallingUserId();
        long ident = this.mAm.mInjector.clearCallingIdentity();
        ServiceRecord sr = findServiceLocked(className, token, userId);     // Catch: Throwable -> L10
        if (sr != null) goto L7;
        this.mAm.mInjector.restoreCallingIdentity(ident);
        return false;
    L7:
        long nowUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L10
        boolean r6 = sr.shouldTriggerShortFgsTimeout(nowUptime);     // Catch: Throwable -> L10
        this.mAm.mInjector.restoreCallingIdentity(ident);
        return r6;
    L10:
        th = move-exception;
        this.mAm.mInjector.restoreCallingIdentity(ident);
        throw th;
    }

    void onShortFgsProcstateTimeout(ServiceRecord sr) {
        ActivityManagerService r0 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long nowUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        if (sr.shouldDemoteShortFgsProcState(nowUptime) == false) goto L7;
        Slog.e("ActivityManager", "Short FGS procstate demoted: " + sr);     // Catch: Throwable -> L9
        traceInstant("short FGS demote: ", sr);     // Catch: Throwable -> L9
        this.mAm.updateOomAdjLocked(sr.app, 13);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (DEBUG_SHORT_SERVICE == false) goto L11;
        Slog.d("ActivityManager", "[STALE] Short FGS procstate demotion: " + sr + " " + sr.getShortFgsTimedEventDescription(nowUptime));     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onShortFgsAnrTimeout(ServiceRecord sr) {
        String reason = "A foreground service of FOREGROUND_SERVICE_TYPE_SHORT_SERVICE did not stop within a timeout: " + sr.getComponentName();
        TimeoutRecord tr = TimeoutRecord.forShortFgsTimeout(reason);
        tr.mLatencyTracker.waitingOnAMSLockStarted();
        ActivityManagerService r2 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        tr.mLatencyTracker.waitingOnAMSLockEnded();     // Catch: Throwable -> L9
        long nowUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        if (sr.shouldTriggerShortFgsAnr(nowUptime) == false) goto L7;
        this.mShortFGSAnrTimer.accept(sr);     // Catch: Throwable -> L9
        String message = "Short FGS ANR'ed: " + sr;     // Catch: Throwable -> L9
        if (DEBUG_SHORT_SERVICE == false) goto L18;
        Slog.wtf("ActivityManager", message);     // Catch: Throwable -> L9
    L19:
        traceInstant("short FGS ANR: ", sr);     // Catch: Throwable -> L9
        if (this.mAm.getExt().handleShortFgsAnrTimeout(sr, tr) == false) goto L24;
        monitor-exit(r2);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L24:
        this.mAm.appNotResponding(sr.app, tr);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L18:
        Slog.e("ActivityManager", message);     // Catch: Throwable -> L9
        goto L19
    L7:
        if (DEBUG_SHORT_SERVICE == false) goto L11;
        Slog.d("ActivityManager", "[STALE] Short FGS ANR'ed: " + sr + " " + sr.getShortFgsTimedEventDescription(nowUptime));     // Catch: Throwable -> L9
    L11:
        this.mShortFGSAnrTimer.discard(sr);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    int getTimeLimitedFgsType(int foregroundServiceType) {
        int fgsType = 0;
        long timeout = 0;
        if ((foregroundServiceType & 8192) != 8192) goto L6;
        fgsType = 8192;
        timeout = this.mAm.mConstants.mMediaProcessingFgsTimeoutDuration;
    L6:
        if ((foregroundServiceType & 1) == 1) goto L8;
        return fgsType;
    L8:
        if (timeout != 0) goto L10;
    L11:
        long timeout2 = this.mAm.mConstants.mDataSyncFgsTimeoutDuration;
        return 1;
    L10:
        if (this.mAm.mConstants.mDataSyncFgsTimeoutDuration > timeout) goto L11;
        return fgsType;
    }

    private long getTimeLimitForFgsType(int foregroundServiceType) {
        switch(foregroundServiceType) {
            case 1: goto L6;
            case 8192: goto L8;
            default: goto L3;
        };
    L3:
        return Long.MAX_VALUE;
    L8:
        return this.mAm.mConstants.mMediaProcessingFgsTimeoutDuration;
    L6:
        return this.mAm.mConstants.mDataSyncFgsTimeoutDuration;
    }

    private long getNextFgsStopTime(int fgsType, ServiceRecord.TimeLimitedFgsInfo fgsInfo) {
        long timeLimit = getTimeLimitForFgsType(fgsType);
        if (timeLimit != Long.MAX_VALUE) goto L6;
        return Long.MAX_VALUE;
    L6:
        return fgsInfo.getLastFgsStartTime() + Math.max(0, timeLimit - fgsInfo.getTotalRuntime());
    }

    private ServiceRecord.TimeLimitedFgsInfo getFgsTimeLimitedInfo(int uid, int fgsType) {
        SparseArray<ServiceRecord.TimeLimitedFgsInfo> fgsInfo = this.mTimeLimitedFgsInfo.get(uid);
        if (fgsInfo != null) goto L5;
        return null;
    L5:
        return fgsInfo.get(fgsType);
    }

    private void maybeUpdateFgsTrackingLocked(ServiceRecord sr, int previousFgsType) {
        int previouslyTimeLimitedType = getTimeLimitedFgsType(previousFgsType);
        if (previouslyTimeLimitedType != 0) goto L8;
        if (sr.isFgsTimeLimited() == true) goto L8;
        return;
    L8:
        if (previouslyTimeLimitedType == 0) goto L16;
        ServiceRecord.TimeLimitedFgsInfo fgsTypeInfo = getFgsTimeLimitedInfo(sr.appInfo.uid, previouslyTimeLimitedType);
        if (fgsTypeInfo == null) goto L13;
        fgsTypeInfo.updateTotalRuntime(SystemClock.uptimeMillis());
        fgsTypeInfo.decNumParallelServices();
    L13:
        if (sr.isFgsTimeLimited() == true) goto L16;
        this.mAm.mHandler.removeMessages(84, sr);
        this.mAm.mHandler.removeMessages(85, sr);
        return;
    L16:
        traceInstant("FGS start: ", sr);
        long nowUptime = SystemClock.uptimeMillis();
        SparseArray<ServiceRecord.TimeLimitedFgsInfo> fgsInfo = this.mTimeLimitedFgsInfo.get(sr.appInfo.uid);
        if (fgsInfo != null) goto L19;
        fgsInfo = new SparseArray();
        this.mTimeLimitedFgsInfo.put(sr.appInfo.uid, fgsInfo);
    L19:
        int timeLimitedFgsType = getTimeLimitedFgsType(sr.foregroundServiceType);
        ServiceRecord.TimeLimitedFgsInfo fgsTypeInfo2 = fgsInfo.get(timeLimitedFgsType);
        if (fgsTypeInfo2 != null) goto L22;
        fgsTypeInfo2 = sr.createTimeLimitedFgsInfo();
        fgsInfo.put(timeLimitedFgsType, fgsTypeInfo2);
    L22:
        fgsTypeInfo2.noteFgsFgsStart(nowUptime);
        this.mAm.mHandler.removeMessages(84, sr);
        this.mAm.mHandler.removeMessages(85, sr);
        Message msg = this.mAm.mHandler.obtainMessage(84, sr);
        long timeoutCallbackTime = getNextFgsStopTime(timeLimitedFgsType, fgsTypeInfo2);
        if (timeoutCallbackTime != Long.MAX_VALUE) goto L26;
        Slog.wtf("ActivityManager", "Couldn't calculate timeout for time-limited fgs: " + sr);
        return;
    L26:
        this.mAm.mHandler.sendMessageAtTime(msg, timeoutCallbackTime);
    }

    private void maybeStopFgsTimeoutLocked(ServiceRecord sr) {
        int timeLimitedType = getTimeLimitedFgsType(sr.foregroundServiceType);
        if (timeLimitedType != 0) goto L5;
        return;
    L5:
        ServiceRecord.TimeLimitedFgsInfo fgsTypeInfo = getFgsTimeLimitedInfo(sr.appInfo.uid, timeLimitedType);
        if (fgsTypeInfo == null) goto L8;
        fgsTypeInfo.updateTotalRuntime(SystemClock.uptimeMillis());
        fgsTypeInfo.decNumParallelServices();
    L8:
        Slog.d("ActivityManager", "Stop FGS timeout: " + sr);
        this.mAm.mHandler.removeMessages(84, sr);
        this.mAm.mHandler.removeMessages(85, sr);
    }

    void onUidRemovedLocked(int uid) {
        this.mTimeLimitedFgsInfo.delete(uid);
    }

    boolean hasServiceTimedOutLocked(ComponentName className, IBinder token) {
        int userId = UserHandle.getCallingUserId();
        long ident = this.mAm.mInjector.clearCallingIdentity();
        ServiceRecord sr = findServiceLocked(className, token, userId);     // Catch: Throwable -> L13
        boolean r4 = false;
        if (sr != null) goto L8;
        this.mAm.mInjector.restoreCallingIdentity(ident);
        return false;
    L8:
        if (getTimeLimitedFgsType(sr.foregroundServiceType) == 0) goto L11;
        r4 = true;
    L11:
        this.mAm.mInjector.restoreCallingIdentity(ident);
        return r4;
    L13:
        th = move-exception;
        this.mAm.mInjector.restoreCallingIdentity(ident);
        throw th;
    }

    void onFgsTimeout(ServiceRecord sr) {
        ActivityManagerService r9 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r9);
        int fgsType = getTimeLimitedFgsType(sr.foregroundServiceType);     // Catch: Throwable -> L25
        if (fgsType == 0) goto L44;
        if (sr.app == null) goto L44;
        int r4 = 0;
        if (sr.app.mState.getCurProcState() > 2) goto L12;
        boolean r0 = true;
    L13:
        boolean currentlyTop = r0;
        long nowUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L25
        if (currentlyTop == false) goto L16;
        long r5 = nowUptime;
    L17:
        long lastTopTime = r5;
        long constantTimeLimit = getTimeLimitForFgsType(fgsType);     // Catch: Throwable -> L25
        if (lastTopTime != Long.MIN_VALUE) goto L20;
    L27:
        Slog.e("ActivityManager", "FGS (" + ServiceInfo.foregroundServiceTypeToLabel(fgsType) + ") timed out: " + sr);     // Catch: Throwable -> L25
        traceInstant("FGS timed out: ", sr);     // Catch: Throwable -> L25
        ServiceRecord.TimeLimitedFgsInfo fgsTypeInfo = getFgsTimeLimitedInfo(sr.appInfo.uid, fgsType);     // Catch: Throwable -> L25
        if (fgsTypeInfo == null) goto L52;
        fgsTypeInfo.updateTotalRuntime(nowUptime);     // Catch: Throwable -> L25
        fgsTypeInfo.setTimeLimitExceededAt(nowUptime);     // Catch: Throwable -> L25
        if (nowUptime <= fgsTypeInfo.getFirstFgsStartUptime()) goto L33;
        r4 = (int) (nowUptime - fgsTypeInfo.getFirstFgsStartUptime());     // Catch: Throwable -> L25
    L33:
        logFGSStateChangeLocked(sr, 5, r4, 0, 0, 0, false);     // Catch: Throwable -> L25
    L52:
        sr.app.getSmtEx().getThread().scheduleTimeoutServiceForType(sr, sr.getLastStartId(), fgsType);     // Catch: Throwable -> L25 RemoteException -> L38
    L40:
        Message msg = this.mAm.mHandler.obtainMessage(85, sr);     // Catch: Throwable -> L25
        this.mAm.mHandler.sendMessageDelayed(msg, this.mAm.mConstants.mFgsCrashExtraWaitDuration);     // Catch: Throwable -> L25
        monitor-exit(r9);     // Catch: Throwable -> L25
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L38:
        e = move-exception;
        Slog.w("ActivityManager", "Exception from scheduleTimeoutServiceForType: " + e);     // Catch: Throwable -> L25
        goto L40
    L20:
        if (constantTimeLimit <= (nowUptime - lastTopTime)) goto L27;
        this.mAm.mHandler.removeMessages(84, sr);     // Catch: Throwable -> L25
        this.mAm.mHandler.removeMessages(85, sr);     // Catch: Throwable -> L25
        Message msg2 = this.mAm.mHandler.obtainMessage(84, sr);     // Catch: Throwable -> L25
        this.mAm.mHandler.sendMessageAtTime(msg2, lastTopTime + constantTimeLimit);     // Catch: Throwable -> L25
        monitor-exit(r9);     // Catch: Throwable -> L25
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        r5 = sr.app.mState.getLastTopTime();     // Catch: Throwable -> L25
        goto L17
    L12:
        r0 = false;
    L44:
        this.mAm.mHandler.removeMessages(85, sr);     // Catch: Throwable -> L25
        monitor-exit(r9);     // Catch: Throwable -> L25
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L25:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onFgsCrashTimeout(ServiceRecord sr) {
        int fgsType = getTimeLimitedFgsType(sr.foregroundServiceType);
        if (fgsType != 0) goto L5;
        return;
    L5:
        ActivityManagerService r2 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        ServiceRecord.TimeLimitedFgsInfo fgsTypeInfo = getFgsTimeLimitedInfo(sr.appInfo.uid, fgsType);     // Catch: Throwable -> L10
        if (fgsTypeInfo == null) goto L12;
        fgsTypeInfo.decNumParallelServices();     // Catch: Throwable -> L10
    L12:
        String reason = "A foreground service of type " + ServiceInfo.foregroundServiceTypeToLabel(fgsType) + " did not stop within its timeout: " + sr.getComponentName();     // Catch: Throwable -> L10
        Slog.e("ActivityManager", "FGS Crashed: " + sr);     // Catch: Throwable -> L10
        traceInstant("FGS Crash: ", sr);     // Catch: Throwable -> L10
        if (sr.app == null) goto L15;
        this.mAm.crashApplicationWithTypeWithExtras(sr.app.uid, sr.app.getPid(), sr.app.info.packageName, sr.app.userId, reason, false, 7, RemoteServiceException.ForegroundServiceDidNotStopInTimeException.createExtrasForService(sr.getComponentName()));     // Catch: Throwable -> L10
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void updateAllowlistManagerLocked(ProcessServiceRecord psr) {
        psr.mAllowlistManager = false;
        int i = psr.numberOfRunningServices() - 1;
    L3:
        if (i < 0) goto L11;
        ServiceRecord sr = psr.getRunningServiceAt(i);
        if (sr.allowlistManager == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        psr.mAllowlistManager = true;
        return;
    }

    private void stopServiceAndUpdateAllowlistManagerLocked(ServiceRecord service) {
        maybeStopShortFgsTimeoutLocked(service);
        ProcessServiceRecord psr = service.app.mServices;
        this.mAm.mProcessStateController.stopService(psr, service);
        psr.updateBoundClientUids();
        if (service.allowlistManager == false) goto L6;
        updateAllowlistManagerLocked(psr);
        return;
    }

    void updateServiceConnectionActivitiesLocked(ProcessServiceRecord clientPsr) {
        ArraySet<ProcessRecord> updatedProcesses = null;
        int i = 0;
    L4:
        if (i >= clientPsr.numberOfConnections()) goto L18;
        ConnectionRecord conn = clientPsr.getConnectionAt(i);
        ProcessRecord proc = conn.binding.service.app;
        if (proc == null) goto L16;
        if (proc == clientPsr.mApp) goto L16;
        if (updatedProcesses != null) goto L13;
        updatedProcesses = new ArraySet();
    L15:
        updatedProcesses.add(proc);
        updateServiceClientActivitiesLocked(proc.mServices, null, false);
        goto L16
    L13:
        if (updatedProcesses.contains(proc) == false) goto L15;
    L16:
        i = i + 1;
        goto L4
    }

    private boolean updateServiceClientActivitiesLocked(ProcessServiceRecord psr, ConnectionRecord modCr, boolean updateLru) {
        if (modCr != null) goto L5;
    L9:
        boolean anyClientActivities = false;
        int i = psr.numberOfRunningServices() - 1;
    L10:
        if (i < 0) goto L29;
        if (anyClientActivities == true) goto L29;
        ServiceRecord sr = psr.getRunningServiceAt(i);
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections = sr.getConnections();
        int conni = connections.size() - 1;
    L13:
        if (conni < 0) goto L27;
        if (anyClientActivities == true) goto L27;
        ArrayList<ConnectionRecord> clist = connections.valueAt(conni);
        int cri = clist.size() - 1;
    L16:
        if (cri < 0) goto L26;
        ConnectionRecord cr = clist.get(cri);
        if (cr.binding.client == null) goto L25;
        if (cr.binding.client == psr.mApp) goto L25;
        if (cr.binding.client.hasActivities() == false) goto L25;
        anyClientActivities = true;
    L25:
        cri = cri - 1;
    L26:
        conni = conni - 1;
    L27:
        i = i - 1;
    L29:
        if (anyClientActivities == psr.hasClientActivities()) goto L34;
        this.mAm.mProcessStateController.setHasClientActivities(psr, anyClientActivities);
        if (updateLru == false) goto L33;
        this.mAm.updateLruProcessLocked(psr.mApp, anyClientActivities, null);
    L33:
        return true;
    L34:
        return false;
    L5:
        if (modCr.binding.client == null) goto L9;
        if (modCr.binding.client.hasActivities() == true) goto L9;
        return false;
    }

    private void getServiceTrackerAidlData(ServiceData sData, ClientData cData, ServiceRecord r, ConnectionRecord connrec, ProcessRecord callerApp, boolean unbind) {
        if (unbind == false) goto L11;
        sData.packageName = connrec.binding.service.packageName;
        sData.processName = connrec.binding.service.shortInstanceName;
        sData.lastActivity = connrec.binding.service.lastActivity;
        if (connrec.binding.service.app == null) goto L7;
        sData.pid = connrec.binding.service.app.getPid();
        sData.serviceB = connrec.binding.service.app.mState.isServiceB();
    L8:
        if (cData == null) goto L18;
        cData.processName = connrec.binding.client.processName;
        cData.pid = connrec.binding.client.getPid();
        return;
    L18:
        return;
    L7:
        sData.pid = -1;
        sData.serviceB = false;
        goto L8
    L11:
        sData.packageName = r.packageName;
        sData.processName = r.shortInstanceName;
        sData.lastActivity = r.lastActivity;
        if (r.app == null) goto L14;
        sData.pid = r.app.getPid();
        sData.serviceB = r.app.mState.isServiceB();
    L15:
        if (cData == null) goto L19;
        cData.processName = callerApp.processName;
        cData.pid = callerApp.getPid();
        return;
    L19:
        return;
    L14:
        sData.pid = -1;
        sData.serviceB = false;
        goto L15
    }

    private void getServiceTrackerHidlData(vendor.qti.hardware.servicetracker.V1_0.ServiceData sData, vendor.qti.hardware.servicetracker.V1_0.ClientData cData, ServiceRecord r, ConnectionRecord connrec, ProcessRecord callerApp, boolean unbind) {
        if (unbind == false) goto L11;
        sData.packageName = connrec.binding.service.packageName;
        sData.processName = connrec.binding.service.shortInstanceName;
        sData.lastActivity = connrec.binding.service.lastActivity;
        if (connrec.binding.service.app == null) goto L7;
        sData.pid = connrec.binding.service.app.getPid();
        sData.serviceB = connrec.binding.service.app.mState.isServiceB();
    L8:
        if (cData == null) goto L18;
        cData.processName = connrec.binding.client.processName;
        cData.pid = connrec.binding.client.getPid();
        return;
    L18:
        return;
    L7:
        sData.pid = -1;
        sData.serviceB = false;
        goto L8
    L11:
        sData.packageName = r.packageName;
        sData.processName = r.shortInstanceName;
        sData.lastActivity = r.lastActivity;
        if (r.app == null) goto L14;
        sData.pid = r.app.getPid();
        sData.serviceB = r.app.mState.isServiceB();
    L15:
        if (cData == null) goto L19;
        cData.processName = callerApp.processName;
        cData.pid = callerApp.getPid();
        return;
    L19:
        return;
    L14:
        sData.pid = -1;
        sData.serviceB = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v184, types: [com.android.server.am.ProcessStateController] */
    /* JADX WARN: Type inference failed for: r0v60, types: [com.android.server.am.ProcessStateController] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14, types: [vendor.qti.hardware.servicetracker.V1_0.IServicetracker, vendor.qti.hardware.servicetrackeraidl.IServicetracker] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20, types: [com.android.server.am.ProcessRecord] */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v43, types: [com.android.server.am.ProcessRecord] */
    /* JADX WARN: Type inference failed for: r15v44 */
    /* JADX WARN: Type inference failed for: r15v51 */
    /* JADX WARN: Type inference failed for: r15v52 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.android.server.am.ProcessServiceRecord] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.android.server.am.ActiveServices] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35, types: [com.android.server.am.ActiveServices] */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v65 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.android.server.am.ActiveServices] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v41, types: [com.android.server.am.ProcessRecord] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r3v65, types: [com.android.server.am.OomAdjuster] */
    /* JADX WARN: Type inference failed for: r53v3 */
    /* JADX WARN: Type inference failed for: r53v4 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v67 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    int bindServiceLocked(IApplicationThread r60, IBinder r61, Intent r62, String r63, IServiceConnection r64, long r65, String r67, boolean r68, int r69, String r70, IApplicationThread r71, String r72, int r73) throws TransactionTooLargeException {
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L5;
        StringBuilder r5 = new StringBuilder();
        r5.append("bindService: ");
        r5.append(r62);
        r5.append(" type=");
        String r8 = r63;
        r5.append(r8);
        r5.append(" conn=");
        r5.append(r64.asBinder());
        r5.append(" flags=0x");
        r5.append(Long.toHexString(r65));
        Slog.v("ActivityManager", r5.toString());
    L6:
        int r7 = this.mAm.mInjector.getCallingPid();
        int r4 = this.mAm.mInjector.getCallingUid();
        ProcessRecord r6 = this.mAm.getRecordForAppLOSP(r60, true);
        if (r6 == null) goto L495;
        if (r6.getSmtEx().inFreezeStat() == false) goto L13;
        Slog.w("ActivityManager", "abandon bind service by freeze");
        return 0;
    L13:
        if (r61 == null) goto L19;
        ActivityServiceConnectionsHolder r9 = this.mAm.mAtmInternal.getServiceConnectionsHolder(r61);
        if (r9 != null) goto L18;
        Slog.w("ActivityManager", "Binding with unknown activity: " + r61);
        return 0;
    L18:
        ActivityServiceConnectionsHolder r21 = r9;
    L21:
        if (r6.info.uid != 1000) goto L23;
        boolean r12 = true;
    L24:
        boolean r25 = r12;
        if (r25 == false) goto L33;
        r62.setDefusable(true);
        PendingIntent r11 = (PendingIntent) r62.getParcelableExtra("android.intent.extra.client_intent");
        if (r11 == null) goto L32;
        int r10 = r62.getIntExtra("android.intent.extra.client_label", 0);
        if (r10 == 0) goto L31;
        int r22 = r10;
        PendingIntent r23 = r11;
        Intent r13 = r62.cloneFilter();
    L35:
        if ((r65 & 134217728) == 0) goto L38;
        this.mAm.enforceCallingPermission("android.permission.MANAGE_ACTIVITY_TASKS", "BIND_TREAT_LIKE_ACTIVITY");
    L38:
        if ((r65 & 524288) == 0) goto L44;
        if (r25 == true) goto L44;
        throw new SecurityException("Non-system caller (pid=" + r7 + ") set BIND_SCHEDULE_LIKE_TOP_APP when binding service " + r13);
    L44:
        if ((r65 & 16777216) == 0) goto L50;
        if (r25 == true) goto L50;
        throw new SecurityException("Non-system caller " + r60 + " (pid=" + r7 + ") set BIND_ALLOW_WHITELIST_MANAGEMENT when binding service " + r13);
    L50:
        if ((r65 & 4194304) == 0) goto L56;
        if (r25 == true) goto L56;
        throw new SecurityException("Non-system caller " + r60 + " (pid=" + r7 + ") set BIND_ALLOW_INSTANT when binding service " + r13);
    L56:
        if ((r65 & 65536) == 0) goto L62;
        if (r25 == true) goto L62;
        throw new SecurityException("Non-system caller (pid=" + r7 + ") set BIND_ALMOST_PERCEPTIBLE when binding service " + r13);
    L62:
        if ((r65 & DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES) == 0) goto L65;
        this.mAm.enforceCallingPermission("android.permission.START_ACTIVITIES_FROM_BACKGROUND", "BIND_ALLOW_BACKGROUND_ACTIVITY_STARTS");
    L65:
        if ((r65 & 262144) == 0) goto L68;
        this.mAm.enforceCallingPermission("android.permission.START_FOREGROUND_SERVICES_FROM_BACKGROUND", "BIND_ALLOW_FOREGROUND_SERVICE_STARTS_FROM_BACKGROUND");
    L68:
        if (r6.mState.getSetSchedGroup() == 0) goto L70;
        boolean r14 = true;
    L72:
        if ((r65 & Integer.toUnsignedLong(Integer.MIN_VALUE)) == 0) goto L74;
    L77:
        boolean r15 = true;
    L79:
        if ((r65 & 4194304) == 0) goto L81;
        boolean r16 = true;
    L83:
        if ((r65 & 8192) == 0) goto L85;
        boolean r18 = true;
    L87:
        if ((r65 & 16384) == 0) goto L89;
        boolean r19 = true;
    L91:
        if ((r65 & 8589934592L) == 0) goto L93;
        boolean r20 = true;
    L95:
        if (r69 <= 0) goto L97;
        ProcessRecord r17 = this.mAm.getRecordForAppLOSP(r71);
    L98:
        Intent r3 = r13;
        ProcessRecord r28 = r17;
        ServiceLookupResult r110 = retrieveServiceLocked(r3, r67, r68, r69, r70, r8, r72, r7, r4, r73, true, r14, r15, r16, null, r18, r19, r20);
        boolean r24 = r14;
        if (r110 != null) goto L101;
        return 0;
    L101:
        int r26 = -1;
        if (r110.record != null) goto L104;
        return -1;
    L104:
        ServiceRecord r27 = r110.record;
        AppBindRecord r111 = r27.retrieveAppBindingLocked(r3, r6, r28);
        ProcessServiceRecord r112 = r111.client.mServices;
        if (r112.numberOfConnections() < this.mAm.mConstants.mMaxServiceConnectionsPerProcess) goto L108;
        Slog.w("ActivityManager", "bindService exceeded max service connection number per process, callerApp:" + r6.processName + " intent:" + r3);
        return 0;
    L108:
        ActivityManagerService.PidMap r113 = this.mAm.mPidsSelfLocked;
        monitor-enter(r113);
        ProcessRecord r0 = this.mAm.mPidsSelfLocked.get(r7);     // Catch: Throwable -> L488
        monitor-exit(r113);     // Catch: Throwable -> L488
        if (r0 == null) goto L114;
        String r1 = r0.processName;
    L115:
        String r114 = r1;
        if (r0 != null) goto L118;
    L123:
        r27.updateProcessStateOnRequest();
        if (this.mAm.getProcessRecordLocked(r27.processName, r27.appInfo.uid) == null) goto L126;
    L128:
        boolean r115 = deferServiceBringupIfFrozenLocked(r27, r3, r72, null, r4, r7, r114, r26, false, r24, r73, BackgroundStartPrivileges.NONE, true, r64);
        if (r115 == true) goto L133;
        ActiveServices r116 = this;
        int r117 = r4;
        Intent r2 = r3;
        boolean r118 = r24;
        if (requestStartTargetPermissionsReviewIfNeededLocked(r27, r72, null, r4, r3, r24, r73, true, r64) == true) goto L134;
        boolean r29 = true;
    L135:
        boolean r119 = r29;
        long r30 = r116.mAm.mInjector.clearCallingIdentity();
    L484:
        th = th;
        ?? r31 = r116;
        long r32 = r30;
    L486:
        r31.mAm.mInjector.restoreCallingIdentity(r32);
        throw th;
    L137:
        if (r116.unscheduleServiceRestartLocked(r27, r6.info.uid, false) == false) goto L144;
    L141:
        th = th;
        r31 = r116;
        r32 = r30;
        goto L486
    L139:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L144;
        Slog.v("ActivityManager", "BIND SERVICE WHILE RESTART PENDING: " + r27);     // Catch: Throwable -> L141
    L144:
        if ((r65 & 1) == 0) goto L160;
        r116.mAm.mProcessStateController.setServiceLastActivityTime(r27, SystemClock.uptimeMillis());     // Catch: Throwable -> L141
        if (r27.hasAutoCreateConnections() == true) goto L159;
        Object r33 = r116.mAm.mProcessStats.mLock;     // Catch: Throwable -> L141
        monitor-enter(r33);     // Catch: Throwable -> L141
        ServiceState r34 = r27.getTracker();     // Catch: Throwable -> L152
        if (r34 == null) goto L154;
        boolean r120 = true;
        r34.setBound(true, r116.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L152
    L155:
        monitor-exit(r33);     // Catch: Throwable -> L152
    L162:
        if ((r65 & 2097152) == 0) goto L164;
        r116.mAm.requireAllowedAssociationsLocked(r27.appInfo.packageName);     // Catch: Throwable -> L141
    L164:
        boolean r35 = r27.startRequested;     // Catch: Throwable -> L484
        if (r27.getConnections().isEmpty() == true) goto L167;
        boolean r36 = r120;
    L168:
        boolean r210 = r36;
        r116.mAm.startAssociationLocked(r6.uid, r6.processName, r6.mState.getCurProcState(), r27.appInfo.uid, r27.appInfo.longVersionCode, r27.instanceName, r27.processName);     // Catch: Throwable -> L484
        r116.mAm.grantImplicitAccess(r6.userId, r2, r6.uid, UserHandle.getAppId(r27.appInfo.uid));     // Catch: Throwable -> L484
        Intent r121 = r2;
        ActivityServiceConnectionsHolder r37 = r21;
        ConnectionRecord r38 = new ConnectionRecord(r111, r37, r64, r65, r22, r23, r6.uid, r6.processName, r72, r110.aliasComponent);     // Catch: Throwable -> L480
    L478:
        th = th;
        r31 = r116;
        r32 = r30;
        goto L486
    L175:
        if ("android.intent.action.JOB_SERVICE".equals(r121.getAction()) == true) goto L525;
    L180:
        IBinder r39 = r64.asBinder();     // Catch: Throwable -> L478
        r27.addConnection(r39, r38);     // Catch: Throwable -> L478
        r111.connections.add(r38);     // Catch: Throwable -> L478
        if (r37 == null) goto L183;
        r37.addConnection(r38);     // Catch: Throwable -> L178
    L178:
        th = th;
        r31 = r116;
        r32 = r30;
    L183:
        ?? r40 = r112;
        r116.mAm.mProcessStateController.addConnection(r40, r38);     // Catch: Throwable -> L476
        r38.startAssociationIfNeeded();     // Catch: Throwable -> L476
        if (r111.client == r27.app) goto L196;
    L192:
        th = th;
        r31 = r116;
        r32 = r30;
        goto L486
    L189:
        if (r38.hasFlag(8) == false) goto L196;
        r116.mAm.mProcessStateController.setHasAboveClient(r40, true);     // Catch: Throwable -> L192
    L196:
        if (r38.hasFlag(16777216) == false) goto L200;
        r27.allowlistManager = true;     // Catch: Throwable -> L192
    L200:
        if (r38.hasFlag(1048576) == false) goto L204;
        r27.setAllowedBgActivityStartsByBinding(true);     // Catch: Throwable -> L192
    L204:
        if (r38.hasFlag(32768) == false) goto L207;
        r27.isNotAppComponentUsage = true;     // Catch: Throwable -> L192
    L207:
        ?? r41 = 2;
        if (r27.app == null) goto L217;
        if (r27.app.mState == null) goto L217;
        if (r27.app.mState.getCurProcState() > 2) goto L217;
        if (r38.hasFlag(65536) == false) goto L217;
        r116.mAm.mProcessStateController.setLastTopAlmostPerceptibleBindRequest(r27, SystemClock.uptimeMillis());     // Catch: Throwable -> L192
    L217:
        if (r27.app == null) goto L219;
        r116.updateServiceClientActivitiesLocked(r27.app.mServices, r38, true);     // Catch: Throwable -> L192
    L219:
        ArrayList<ConnectionRecord> r42 = r116.mServiceConnections.get(r39);     // Catch: Throwable -> L476
        if (r42 != null) goto L223;
        ArrayList<ConnectionRecord> r43 = new ArrayList();     // Catch: Throwable -> L192
        r116.mServiceConnections.put(r39, r43);     // Catch: Throwable -> L192
        ArrayList<ConnectionRecord> r44 = r43;
    L224:
        r44.add(r38);     // Catch: Throwable -> L476
        ServiceRecord r45 = null;
        if (r116.isLowRamDevice == false) goto L567;
        ?? r122 = 0;
        r45 = r27;
        r40 = r116;
        int r123 = 2;
        r41 = r6;
    L498:
    L474:
        th = th;
        r32 = r30;
        r31 = r40;
        goto L486
    L279:
        if ((r45.serviceInfo.flags & r123) == 0) goto L281;
        boolean r46 = true;
    L283:
        if (r46 == false) goto L286;
        ?? r124 = r122;
    L288:
        if (r124 == 0) goto L290;
        int r47 = r40.getServiceBindingOomAdjPolicyForAddLocked(r111.client, r124, r38);     // Catch: Throwable -> L256
    L292:
        if (r115 == true) goto L299;
        if (r119 == true) goto L299;
        if ((r47 & 8) == 0) goto L299;
        if (r41.isFreezable() == false) goto L299;
        boolean r48 = true;
    L301:
        if (r48 == false) goto L303;
        r40.mAm.mOomAdjuster.updateAppFreezeStateLSP(r41, 4, true, 1001);     // Catch: Throwable -> L256
    L303:
        if (r124 != 0) goto L305;
        boolean r49 = r45.appInfo.isStopped();     // Catch: Throwable -> L256
    L306:
        if (r124 != 0) goto L309;
        boolean r211 = r45.appInfo.isNotLaunched();     // Catch: Throwable -> L256
    L311:
        if (r38.hasFlag(1) == true) goto L500;
        boolean r55 = r49;
        int r410 = r47;
        boolean r411 = r118;
        ServiceRecord r50 = r45;
        ConnectionRecord r125 = r38;
        boolean r126 = false;
    L541:
        ServiceRecord r51 = r50;
        int r52 = r117;
        r40.setFgsRestrictionLocked(r72, r7, r52, r121, r51, r73, BackgroundStartPrivileges.NONE, true);     // Catch: Throwable -> L470
    L468:
        th = th;
        r32 = r30;
        r31 = r40;
        goto L486
    L342:
        if (r51.app != null) goto L533;
    L368:
        boolean r53 = r126;
    L369:
        if (r53 == false) goto L371;
        r40.mAm.updateOomAdjPendingTargetsLocked(4);     // Catch: Throwable -> L346
    L371:
        boolean r54 = r55;
        if (r54 == false) goto L374;
        int r127 = 2;
    L377:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L380;
        StringBuilder r56 = new StringBuilder();     // Catch: Throwable -> L346
        r56.append("Logging bindService for ");     // Catch: Throwable -> L346
        r56.append(r51.packageName);     // Catch: Throwable -> L346
        r56.append(", stopped=");     // Catch: Throwable -> L346
        r56.append(r54);     // Catch: Throwable -> L346
        r56.append(", firstLaunch=");     // Catch: Throwable -> L346
        boolean r57 = r211;
        r56.append(r57);     // Catch: Throwable -> L346
        Slog.d("ActivityManager", r56.toString());     // Catch: Throwable -> L346
    L381:
        int r58 = r51.appInfo.uid;     // Catch: Throwable -> L468
        String r59 = ActivityManagerService.getShortAction(r121.getAction());     // Catch: Throwable -> L468
        if (r51.app == null) goto L391;
        if (r51.app.getThread() == null) goto L391;
        if (r35 == true) goto L390;
        if (r210 == true) goto L390;
        int r128 = 1;
    L392:
        String r66 = r40.getShortProcessNameForStats(r52, r41.processName);     // Catch: Throwable -> L468
        String r129 = r40.getShortServiceNameForStats(r51);     // Catch: Throwable -> L468
        String r130 = r51.packageName;     // Catch: Throwable -> L468
        String r74 = r41.info.packageName;     // Catch: Throwable -> L468
        int r75 = r41.mState.getCurProcState();     // Catch: Throwable -> L468
        int r76 = r51.mProcessStateOnRequest;     // Catch: Throwable -> L468
        ConnectionRecord r510 = r125;
        ?? r77 = r41;
        AppBindRecord r78 = r111;
        FrameworkStatsLog.write(FrameworkStatsLog.SERVICE_REQUEST_EVENT_REPORTED, r58, r52, r59, 2, false, r128, r66, r129, r127, r130, r74, r75, r76, r57, 0);     // Catch: Throwable -> L466
    L464:
        th = th;
        r32 = r30;
        r31 = r40;
        goto L486
    L397:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == true) goto L496;
    L402:
        if (r51.app != null) goto L514;
    L441:
        r78 = r78;
        ?? r131 = r77;
        boolean r79 = r411;
        int r80 = r410;
        int r132 = 1;
        if (r78.intent.requested == false) goto L447;
        ?? r81 = this;
        ?? r133 = r131;
    L527:
        r81.maybeLogBindCrossProfileService(r73, r72, r133.info.uid);     // Catch: Throwable -> L458
        r81.getServiceMapLocked(r51.userId).ensureNotStartingBackgroundLocked(r51);     // Catch: Throwable -> L458
        r81.mAm.mInjector.restoreCallingIdentity(r30);
        r81.notifyBindingServiceEventLocked(r133, r72);
        r81.notifyServiceBoundLocked(r133, r51, r78);
        return r132;
    L458:
        th = th;
    L459:
        r32 = r30;
        r31 = r81;
    L460:
        th = th;
        goto L459
    L447:
        ActiveServices r82 = this;
        r82.requestServiceBindingLocked(r51, r78.intent, r79, false, r80);     // Catch: Throwable -> L450
        r81 = r82;
        r133 = r131;
    L450:
        th = th;
    L434:
        r32 = r30;
        r31 = r82;
    L462:
        th = th;
        r81 = this;
        goto L459
    L514:
        if (r78.intent.received == false) goto L441;
    L438:
        th = th;
        r31 = this;
        r32 = r30;
        goto L486
    L408:
        if (r110.aliasComponent != null) goto L524;
        ComponentName r83 = r51.name;     // Catch: Throwable -> L438
    L569:
        r510.conn.connected(r83, r78.intent.binder, false);     // Catch: Throwable -> L411 Exception -> L417 FrozenObjectException -> L419
    L417:
        e = move-exception;
        Slog.w("ActivityManager", "Failure sending service " + r51.shortInstanceName + " to connection " + r510.conn.asBinder() + " (in " + r510.binding.client.processName + ")", e);     // Catch: Throwable -> L411
    L411:
        th = th;
        r32 = r30;
        r31 = r40;
    L423:
        r132 = 1;
        if (r78.intent.apps.size() != 1) goto L440;
        if (r78.intent.doRebind == false) goto L440;
        r40.requestServiceBindingLocked(r51, r78.intent, r411, true, r410);     // Catch: Throwable -> L432
    L435:
        th = th;
        r31 = this;
        r32 = r30;
    L440:
        r81 = this;
        r133 = r77;
        goto L527
    L524:
        r83 = r110.aliasComponent;     // Catch: Throwable -> L411
    L442:
        th = th;
        r31 = this;
        r32 = r30;
    L432:
        th = th;
        r82 = this;
        goto L434
    L496:
        Slog.v("ActivityManager", "Bind " + r51 + " with " + r78 + ": received=" + r78.intent.received + " apps=" + r78.intent.apps.size() + " doRebind=" + r78.intent.doRebind);     // Catch: Throwable -> L400
    L400:
        th = th;
        r32 = r30;
        r31 = r40;
    L466:
        th = th;
        r32 = r30;
        r31 = r40;
    L390:
        r128 = 2;
    L346:
        th = th;
        r32 = r30;
        r31 = r40;
    L391:
        r128 = 3;
        goto L392
    L380:
        r57 = r211;
        goto L381
    L374:
        r127 = 1;
        goto L377
    L533:
        ProcessServiceRecord r84 = r51.app.mServices;     // Catch: Throwable -> L346
        if (r125.hasFlag(134217728) == false) goto L349;
        r40.mAm.mProcessStateController.setTreatLikeActivity(r84, true);     // Catch: Throwable -> L346
    L349:
        if (r51.allowlistManager == false) goto L351;
        r84.mAllowlistManager = true;     // Catch: Throwable -> L346
    L351:
        ActivityManagerService r85 = r40.mAm;     // Catch: Throwable -> L346
        ProcessRecord r86 = r51.app;     // Catch: Throwable -> L346
        if (r41.hasActivitiesOrRecentTasks() == false) goto L358;
        if (r84.hasClientActivities() == false) goto L358;
    L361:
        boolean r134 = true;
    L363:
        r85.updateLruProcessLocked(r86, r134, r111.client);     // Catch: Throwable -> L346
        if (r51.wasOomAdjUpdated() == true) goto L368;
        if ((r410 & 4) != 0) goto L368;
        r40.mAm.enqueueOomAdjTargetLocked(r51.app);     // Catch: Throwable -> L346
        r53 = true;
    L358:
        if (r41.mState.getCurProcState() <= 2) goto L360;
    L362:
        r134 = false;
        goto L363
    L360:
        if (r125.hasFlag(134217728) == false) goto L362;
    L470:
        th = th;
        r32 = r30;
        r31 = r40;
    L472:
        th = th;
        r32 = r53;
        r31 = r40;
        goto L486
    L500:
        r40.mAm.mProcessStateController.setServiceLastActivityTime(r45, SystemClock.uptimeMillis());     // Catch: Throwable -> L332
        if ((r47 & 1) != 0) goto L318;
        boolean r87 = true;
    L319:
        r126 = r87;
        r55 = r49;
        int r88 = r47;
        r125 = r38;
        r50 = r45;
        boolean r89 = r118;
        r411 = r89;
        r410 = r88;
        if (r40.bringUpServiceLocked(r50, r121.getFlags(), r89, false, r119, r115, true, r88) == null) goto L541;
        r40.mAm.updateOomAdjPendingTargetsLocked(4);     // Catch: Throwable -> L327
        r40.mAm.mInjector.restoreCallingIdentity(r30);
        return 0;
    L327:
        th = th;
        r32 = r30;
        r31 = r40;
    L330:
        th = th;
        r32 = r30;
        r31 = r40;
        goto L486
    L318:
        r87 = false;
    L332:
        th = th;
        r32 = r30;
        r31 = r40;
    L334:
        th = th;
        r32 = r30;
        r31 = r40;
        goto L486
    L309:
        r211 = false;
        goto L311
    L305:
        r49 = false;
    L299:
        r48 = false;
        goto L301
    L290:
        r47 = 0;
        goto L292
    L286:
        r124 = r40.mAm.getProcessRecordLocked(r45.processName, r45.appInfo.uid);     // Catch: Throwable -> L474
        goto L288
    L281:
        r46 = false;
        goto L283
    L567:
        if (r116.getAIDLServicetrackerInstance() == true) goto L573;
        ActiveServices r90 = r116;
        r123 = 2;
        ?? r135 = 0;
    L266:
        e = e;
        r45 = r27;
        ProcessRecord r91 = r6;
    L275:
        Slog.e("ActivityManager", "Failed to send bind details to servicetracker HAL", e);     // Catch: Throwable -> L256
        r90.mServicetracker = r135;     // Catch: Throwable -> L256
        r90.mServicetracker_aidl = r135;     // Catch: Throwable -> L256
        r40 = r90;
        r41 = r91;
        r122 = r135;
    L264:
        th = th;
        r32 = r30;
        r31 = r90;
        goto L486
    L249:
        if (r90.getServicetrackerInstance() == false) goto L268;
        vendor.qti.hardware.servicetracker.V1_0.ServiceData r92 = new vendor.qti.hardware.servicetracker.V1_0.ServiceData();     // Catch: Throwable -> L264 RemoteException -> L266
        vendor.qti.hardware.servicetracker.V1_0.ClientData r93 = new vendor.qti.hardware.servicetracker.V1_0.ClientData();     // Catch: Throwable -> L264 RemoteException -> L266
        r45 = r27;
        r90.getServiceTrackerHidlData(r92, r93, r45, null, r6, false);     // Catch: Throwable -> L260 RemoteException -> L262
        r91 = r6;
        r90.mServicetracker.bindService(r92, r93);     // Catch: Throwable -> L256 RemoteException -> L258
        r40 = r90;
        r41 = r91;
        r122 = r135;
    L258:
        e = e;
        goto L275
    L262:
        e = e;
        r91 = r6;
    L260:
        th = th;
        r32 = r30;
        r31 = r90;
        goto L486
    L268:
        r45 = r27;
        r41 = r6;
        r40 = r90;
        r122 = r135;
        goto L498
    L573:
        ServiceData r94 = new ServiceData();     // Catch: Throwable -> L243 RemoteException -> L245
        ClientData r95 = new ClientData();     // Catch: Throwable -> L243 RemoteException -> L245
        r135 = 0;
        r45 = r27;
        r90 = r116;
        r123 = 2;
        r90.getServiceTrackerAidlData(r94, r95, r45, null, r6, false);     // Catch: Throwable -> L239 RemoteException -> L241
    L565:
        r90.mServicetracker_aidl.bindService(r94, r95);     // Catch: Throwable -> L235 RemoteException -> L237
        r45 = r45;
        r41 = r6;
        r40 = r90;
        r122 = r135;
        goto L498
    L237:
        e = e;
        r45 = r45;
        r91 = r6;
    L235:
        th = th;
        r32 = r30;
        r31 = r90;
    L241:
        e = e;
        r91 = r6;
    L239:
        th = th;
        r32 = r30;
        r31 = r90;
        goto L486
    L245:
        e = e;
        r90 = r116;
        r123 = 2;
        r135 = 0;
        r45 = r27;
        r91 = r6;
    L243:
        th = th;
        r31 = r116;
        r32 = r30;
        goto L486
    L272:
        e = e;
        r135 = 0;
        r45 = r27;
        r90 = r116;
        r123 = 2;
        r91 = r6;
    L270:
        th = th;
        r31 = r116;
        r32 = r30;
    L256:
        th = th;
        r32 = r30;
        r31 = r40;
        goto L486
    L223:
        r44 = r42;
    L476:
        th = th;
        r31 = r116;
        r32 = r30;
        goto L486
    L525:
        r38.getSmtEx().connectWithJobService = true;     // Catch: Throwable -> L178
    L480:
        th = th;
        r31 = r116;
        r32 = r30;
    L482:
        th = th;
        r31 = r116;
        r32 = r30;
        goto L486
    L167:
        r36 = false;
        goto L168
    L154:
        r120 = true;
    L152:
        th = move-exception;
        throw th;     // Catch: Throwable -> L141
    L159:
        r120 = true;
        goto L162
    L160:
        r120 = true;
    L134:
        r29 = false;
        goto L135
    L133:
        r116 = this;
        r2 = r3;
        r117 = r4;
        r118 = r24;
        goto L134
    L126:
        if (SysOptBridge.getFactory().getProcessIntercept().isServiceAllowStart(r6, r27, r3, Binder.getCallingUid()) == true) goto L128;
        return 0;
    L118:
        if (r0.getThread() == null) goto L123;
        if (r0.isKilled() == true) goto L123;
        r26 = r0.mState.getCurProcState();
        goto L123
    L114:
        r1 = r72;
    L488:
        th = th;
    L510:
        throw th;
    L492:
        th = th;
        goto L510
    L97:
        r17 = null;
        goto L98
    L93:
        r20 = false;
        goto L95
    L89:
        r19 = false;
        goto L91
    L85:
        r18 = false;
        goto L87
    L81:
        r16 = false;
        goto L83
    L74:
        if ((r65 & 4611686018427387904L) != 0) goto L77;
        r15 = false;
        goto L79
    L70:
        r14 = false;
        goto L72
    L31:
        r22 = r10;
        r23 = r11;
        r13 = r62;
        goto L35
    L32:
        r22 = 0;
        r23 = r11;
        r13 = r62;
        goto L35
    L33:
        r22 = 0;
        r23 = null;
        r13 = r62;
        goto L35
    L23:
        r12 = false;
        goto L24
    L19:
        r21 = null;
        goto L21
    L495:
        throw new SecurityException("Unable to find app for caller " + r60 + " (pid=" + r7 + ") when binding service " + r62);
    L5:
        r8 = r63;
        goto L6
    }

    private void notifyServiceBoundLocked(ProcessRecord callerApp, ServiceRecord s, AppBindRecord binding) {
        ProcessRecord servicePr = s.app;
        if (servicePr == null) goto L5;
    L7:
        if (servicePr != null) goto L9;
        return;
    L9:
        if (callerApp.getSmtEx().getPid() != servicePr.getSmtEx().getPid()) goto L11;
        return;
    L11:
        if (servicePr.info != null) goto L13;
        return;
    L13:
        if (callerApp.info.packageName != null) goto L15;
        return;
    L15:
        if (callerApp.info.packageName.equals(servicePr.info.packageName) == false) goto L17;
        return;
    L17:
        if (binding.intent != null) goto L19;
    L21:
        Intent intent = null;
    L22:
        if (intent == null) goto L24;
        String r2 = intent.getAction();
    L25:
        String action = r2;
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().notifyServiceConnEvent(true, callerApp.getSmtEx().getPid(), callerApp.getProcessName(), action, servicePr.info.uid, servicePr.info.packageName, s.processName);
        return;
    L24:
        r2 = "";
        goto L25
    L19:
        if (binding.intent.intent == null) goto L21;
        intent = binding.intent.intent.getIntent();
        goto L22
    L5:
        if (s.processName == null) goto L7;
        servicePr = this.mAm.getProcessRecordLocked(s.processName, s.appInfo.uid);
        goto L7
    }

    private void notifyServiceUnboundLocked(ProcessRecord callerApp, ServiceRecord s, AppBindRecord binding) {
        ProcessRecord servicePr = s.app;
        int r1 = -1;
        if (servicePr == null) goto L5;
        int servicePid = servicePr.getSmtEx().getPid();
    L7:
        if (s.appInfo == null) goto L9;
        r1 = s.appInfo.uid;
    L9:
        int serviceUid = r1;
        String r3 = "";
        if (s.appInfo == null) goto L12;
        String servicePkg = s.appInfo.packageName;
    L14:
        if (callerApp.getSmtEx().getPid() != servicePid) goto L16;
        return;
    L16:
        if (callerApp.info.packageName != null) goto L18;
        return;
    L18:
        if (callerApp.info.packageName.equals(servicePkg) == false) goto L20;
        return;
    L20:
        if (binding.intent != null) goto L22;
    L24:
        Intent intent = null;
    L25:
        if (intent == null) goto L27;
        r3 = intent.getAction();
    L27:
        String action = r3;
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().notifyServiceConnEvent(false, callerApp.getSmtEx().getPid(), callerApp.getProcessName(), action, serviceUid, servicePkg, s.processName);
        return;
    L22:
        if (binding.intent.intent == null) goto L24;
        intent = binding.intent.intent.getIntent();
        goto L25
    L12:
        servicePkg = "";
        goto L14
    L5:
        servicePid = -1;
        goto L7
    }

    private void notifyBindingServiceEventLocked(ProcessRecord callerApp, String callingPackage) {
        ApplicationInfo ai = callerApp.info;
        if (ai == null) goto L5;
        String callerPackage = ai.packageName;
    L6:
        if (callerPackage == null) goto L9;
        this.mAm.mHandler.obtainMessage(75, callerApp.uid, 0, callerPackage).sendToTarget();
        return;
    L9:
        return;
    L5:
        callerPackage = callingPackage;
        goto L6
    }

    private void maybeLogBindCrossProfileService(int userId, String callingPackage, int callingUid) {
        if (UserHandle.isCore(callingUid) == false) goto L5;
        return;
    L5:
        int callingUserId = UserHandle.getUserId(callingUid);
        if (callingUserId != userId) goto L8;
        return;
    L8:
        if (this.mAm.mUserController.isSameProfileGroup(callingUserId, userId) == false) goto L13;
        DevicePolicyEventLogger.createEvent(151).setStrings(new String[]{callingPackage}).write();
        return;
    }

    void publishServiceLocked(ServiceRecord r, Intent intent, IBinder service) {
        Intent r7 = intent;
        String r3 = "from_job";
        long origId = this.mAm.mInjector.clearCallingIdentity();
    L7:
        th = move-exception;
        this.mAm.mInjector.restoreCallingIdentity(origId);
        throw th;
    L5:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L9;
        Slog.v("ActivityManager", "PUBLISHING " + r + " " + r7 + ": " + service);     // Catch: Throwable -> L7
    L9:
        if (r == null) goto L73;
        Intent.FilterComparison filter = new Intent.FilterComparison(r7);     // Catch: Throwable -> L7
        IntentBindRecord b = r.bindings.get(filter);     // Catch: Throwable -> L7
        if (b != null) goto L13;
    L68:
        boolean r4 = this.mDestroyingServices.contains(r);     // Catch: Throwable -> L7
        if (r.wasOomAdjUpdated() == false) goto L71;
        int r6 = 20;
    L72:
        serviceDoneExecutingLocked(r, r4, false, false, r6);     // Catch: Throwable -> L7
        goto L73
    L71:
        r6 = 0;
        goto L72
    L13:
        if (b.received == true) goto L68;
        b.binder = service;     // Catch: Throwable -> L7
        b.requested = true;     // Catch: Throwable -> L7
        b.received = true;     // Catch: Throwable -> L7
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections = r.getConnections();     // Catch: Throwable -> L7
        int conni = connections.size() - 1;     // Catch: Throwable -> L7
    L15:
        if (conni < 0) goto L68;
        ArrayList<ConnectionRecord> clist = connections.valueAt(conni);     // Catch: Throwable -> L7
        int i = 0;
    L18:
        if (i >= clist.size()) goto L66;
        ConnectionRecord c = clist.get(i);     // Catch: Throwable -> L7
        if (filter.equals(c.binding.intent.intent) == false) goto L22;
        connections = connections;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L36;
        Slog.v("ActivityManager", "Publishing to: " + c);     // Catch: Throwable -> L7
    L36:
        if (c.aliasComponent == null) goto L38;
        ComponentName r0 = c.aliasComponent;     // Catch: Throwable -> L7
    L39:
        ComponentName clientSideComponentName = r0;
        boolean fromJob = r7.getSmtEx().getSmtBooleanExtra(r3, false);     // Catch: Throwable -> L7
        intent.getSmtEx().removeSmtExtra(r3);     // Catch: Throwable -> L7
        if (c.binding.client == null) goto L77;
        if (c.binding.client.getSmtEx().inFreezeStat() == false) goto L77;
        IApplicationFreezer r17 = SysOptBridge.getFactory().getApplicationFreezer();     // Catch: Throwable -> L7
        ProcessRecord r1 = c.binding.client;     // Catch: Throwable -> L7
        IApplicationFreezer.UnfreezeReason r19 = IApplicationFreezer.UnfreezeReason.NEED_SERVICE;     // Catch: Throwable -> L7
        IApplicationFreezer.FreezeInfo r2 = new IApplicationFreezer.FreezeInfo();     // Catch: Throwable -> L7
        IApplicationFreezer.CallerInfo r5 = new IApplicationFreezer.CallerInfo();     // Catch: Throwable -> L7
        if (c.binding.client != null) goto L46;
        int r8 = 0;
    L47:
        IApplicationFreezer.CallerInfo r9 = r5.setPid(r8).setUid(c.clientUid).setPackageName(c.clientPackageName).setFg(r.executeFg);     // Catch: Throwable -> L7
        if (fromJob == false) goto L50;
        String r10 = "J";
    L51:
        r17.unfreezeAppIfNeededLocked(r1, r19, null, null, r2.setCallerInfo(r9.setType(r10).setAction(r.name.flattenToShortString()).setExtraMsg("publish")));     // Catch: Throwable -> L7
        goto L77
    L50:
        r10 = "S";
        goto L51
    L46:
        r8 = c.binding.client.getSmtEx().getPid();     // Catch: Throwable -> L7
    L77:
        c.conn.connected(clientSideComponentName, service, false);     // Catch: Throwable -> L7 Exception -> L59
    L65:
        i = i + 1;     // Catch: Throwable -> L7
        r7 = intent;
        connections = connections;
        r3 = r3;
    L59:
        e = e;
    L64:
        Slog.w("ActivityManager", "Failure sending service " + r.shortInstanceName + " to connection " + c.conn.asBinder() + " (in " + c.binding.client.processName + ")", e);     // Catch: Throwable -> L7
    L61:
        e = e;
        goto L64
    L38:
        r0 = r.name;     // Catch: Throwable -> L7
        goto L39
    L22:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L26;
        Slog.v("ActivityManager", "Not publishing to: " + c);     // Catch: Throwable -> L7
    L26:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L29;
        Slog.v("ActivityManager", "Bound intent: " + c.binding.intent.intent);     // Catch: Throwable -> L7
    L29:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L31;
        Slog.v("ActivityManager", "Published intent: " + r7);     // Catch: Throwable -> L7
    L31:
        r3 = r3;
        goto L65
    L66:
        conni = conni - 1;     // Catch: Throwable -> L7
        r7 = intent;
    L73:
        this.mAm.mInjector.restoreCallingIdentity(origId);
    }

    void updateServiceGroupLocked(IServiceConnection connection, int group, int importance) {
        IBinder binder = connection.asBinder();
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L5;
        Slog.v("ActivityManager", "updateServiceGroup: conn=" + binder);
    L5:
        ArrayList<ConnectionRecord> clist = this.mServiceConnections.get(binder);
        if (clist == null) goto L27;
        int i = clist.size() - 1;
    L8:
        if (i < 0) goto L25;
        ConnectionRecord crec = clist.get(i);
        ServiceRecord srec = crec.binding.service;
        if (srec == null) goto L23;
        if ((srec.serviceInfo.flags & 2) == 0) goto L23;
        if (srec.app == null) goto L20;
        ProcessServiceRecord psr = srec.app.mServices;
        if (group <= 0) goto L18;
        psr.setConnectionService(srec);
        psr.setConnectionGroup(group);
        psr.setConnectionImportance(importance);
        goto L23
    L18:
        psr.setConnectionService(null);
        psr.setConnectionGroup(0);
        psr.setConnectionImportance(0);
        goto L23
    L20:
        if (group <= 0) goto L22;
        srec.pendingConnectionGroup = group;
        srec.pendingConnectionImportance = importance;
        goto L23
    L22:
        srec.pendingConnectionGroup = 0;
        srec.pendingConnectionImportance = 0;
    L23:
        i = i - 1;
        goto L8
    L25:
        return;
    L27:
        throw new IllegalArgumentException("Could not find connection for " + connection.asBinder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [vendor.qti.hardware.servicetracker.V1_0.IServicetracker, vendor.qti.hardware.servicetrackeraidl.IServicetracker] */
    /* JADX WARN: Type inference failed for: r11v7, types: [com.android.server.am.ProcessRecord, com.android.server.wm.ActivityServiceConnectionsHolder] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    boolean unbindServiceLocked(IServiceConnection r21) {
        IBinder r8 = r21.asBinder();
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L5;
        Slog.v("ActivityManager", "unbindService: conn=" + r8);
    L5:
        ArrayList<ConnectionRecord> r10 = this.mServiceConnections.get(r8);
        int r11 = 0;
        if (r10 != null) goto L9;
        Slog.w("ActivityManager", "Unbind failed: could not find connection for " + r21.asBinder());
        return false;
    L9:
        int r12 = this.mAm.mInjector.getCallingPid();
        long r13 = this.mAm.mInjector.clearCallingIdentity();
        long r2 = 64;
    L15:
        th = th;
        long r17 = r2;
    L66:
        Trace.traceEnd(r17);
        this.mAm.mInjector.restoreCallingIdentity(r13);
        throw th;
    L11:
        if (Trace.isTagEnabled(64) == true) goto L13;
    L19:
        boolean r15 = false;
    L20:
        if (r10.size() <= 0) goto L61;
        ConnectionRecord r5 = r10.get(r11);     // Catch: Throwable -> L15
        if (this.isLowRamDevice == false) goto L73;
        r17 = r2;
        ?? r14 = 0;
    L44:
        int r0 = removeConnectionLocked(r5, r14, r14, true);     // Catch: Throwable -> L31
        if (r10.size() > 0) goto L47;
    L49:
        int r3 = 0;
    L50:
        ProcessRecord r4 = r5.binding.service.app;     // Catch: Throwable -> L31
        if (r4 == null) goto L60;
        ProcessServiceRecord r6 = r4.mServices;     // Catch: Throwable -> L31
        if (r6.mAllowlistManager == false) goto L56;
        updateAllowlistManagerLocked(r6);     // Catch: Throwable -> L31
    L56:
        if (r5.hasFlag(134217728) == false) goto L58;
        this.mAm.mProcessStateController.setTreatLikeActivity(r6, true);     // Catch: Throwable -> L31
        this.mAm.updateLruProcessLocked(r4, true, r14);     // Catch: Throwable -> L31
    L58:
        if (r0 != 0) goto L60;
        this.mAm.enqueueOomAdjTargetLocked(r4);     // Catch: Throwable -> L31
        r15 = true;
    L60:
        r11 = r3;
        r2 = r17;
        goto L20
    L47:
        if (r10.get(0) != r5) goto L49;
        Slog.wtf("ActivityManager", "Connection " + r5 + " not removed for binder " + r8);     // Catch: Throwable -> L31
        r3 = 0;
        r10.remove(0);     // Catch: Throwable -> L31
        goto L50
    L73:
    L35:
        e = e;
        r17 = r2;
        ?? r16 = 0;
    L42:
        Slog.e("ActivityManager", "Failed to send unbind details to servicetracker AIDL/HAL", e);     // Catch: Throwable -> L31
        this.mServicetracker = r16;     // Catch: Throwable -> L31
        this.mServicetracker_aidl = r16;     // Catch: Throwable -> L31
        r14 = r16;
        goto L44
    L26:
        if (getAIDLServicetrackerInstance() == false) goto L37;
        ServiceData r1 = new ServiceData();     // Catch: Throwable -> L15 RemoteException -> L35
        ClientData r7 = new ClientData();     // Catch: Throwable -> L15 RemoteException -> L35
        r17 = r2;
        Object r18 = null;
        getServiceTrackerAidlData(r1, r7, null, r5, null, true);     // Catch: Throwable -> L31 RemoteException -> L33
        this.mServicetracker_aidl.unbindService(r1, r7);     // Catch: Throwable -> L31 RemoteException -> L33
        Object r19 = r18;
    L30:
        r14 = r19;
    L31:
        th = th;
    L33:
        e = e;
        r16 = r18;
        goto L42
    L37:
        r17 = r2;
        Object r110 = null;
        r19 = r110;
        if (getServicetrackerInstance() == false) goto L30;
        vendor.qti.hardware.servicetracker.V1_0.ServiceData r9 = new vendor.qti.hardware.servicetracker.V1_0.ServiceData();     // Catch: Throwable -> L31 RemoteException -> L33
        vendor.qti.hardware.servicetracker.V1_0.ClientData r20 = new vendor.qti.hardware.servicetracker.V1_0.ClientData();     // Catch: Throwable -> L31 RemoteException -> L33
        getServiceTrackerHidlData(r9, r20, null, r5, null, true);     // Catch: Throwable -> L31 RemoteException -> L33
        this.mServicetracker.unbindService(r9, r20);     // Catch: Throwable -> L31 RemoteException -> L33
        r14 = r110;
        goto L44
    L61:
        r17 = r2;
        if (r15 == false) goto L64;
        this.mAm.updateOomAdjPendingTargetsLocked(5);     // Catch: Throwable -> L31
    L64:
        Trace.traceEnd(r17);
        this.mAm.mInjector.restoreCallingIdentity(r13);
        return true;
    L13:
        if (r10.size() <= 0) goto L17;
        ConnectionRecord r22 = r10.get(0);     // Catch: Throwable -> L15
        String r23 = r22.binding.service.shortInstanceName + " from " + r22.clientProcessName;     // Catch: Throwable -> L15
    L18:
        Trace.traceBegin(64, "unbindServiceLocked: " + r23);     // Catch: Throwable -> L15
        goto L19
    L17:
        r23 = Integer.toString(r12);     // Catch: Throwable -> L15
        goto L18
    }

    void unbindFinishedLocked(ServiceRecord r, Intent intent) {
        long origId = this.mAm.mInjector.clearCallingIdentity();
        if (r == null) goto L50;
        Intent.FilterComparison filter = new Intent.FilterComparison(intent);     // Catch: Throwable -> L11
        IntentBindRecord b = r.bindings.get(filter);     // Catch: Throwable -> L11
        int r11 = 0;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L15;
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L11
        r4.append("unbindFinished in ");     // Catch: Throwable -> L11
        r4.append(r);     // Catch: Throwable -> L11
        r4.append(" at ");     // Catch: Throwable -> L11
        r4.append(b);     // Catch: Throwable -> L11
        r4.append(": apps=");     // Catch: Throwable -> L11
        if (b == null) goto L13;
        int r5 = b.apps.size();     // Catch: Throwable -> L11
    L14:
        r4.append(r5);     // Catch: Throwable -> L11
        Slog.v("ActivityManager", r4.toString());     // Catch: Throwable -> L11
        goto L15
    L13:
        r5 = 0;
    L15:
        boolean inDestroying = this.mDestroyingServices.contains(r);     // Catch: Throwable -> L11
        if (b == null) goto L39;
        if (b.apps.size() <= 0) goto L36;
        if (inDestroying == true) goto L36;
        int i = b.apps.size() - 1;     // Catch: Throwable -> L11
    L21:
        if (i < 0) goto L28;
        ProcessRecord client = b.apps.valueAt(i).client;     // Catch: Throwable -> L11
        if (client == null) goto L27;
        if (client.mState.getSetSchedGroup() == 0) goto L27;
        boolean inFg = true;
    L56:
        requestServiceBindingLocked(r, b, inFg, true, 0);     // Catch: Throwable -> L11 TransactionTooLargeException -> L32
    L27:
        i = i - 1;
        goto L21
    L28:
        inFg = false;
    L36:
        b.doRebind = true;     // Catch: Throwable -> L11
    L39:
        if (r.wasOomAdjUpdated() == false) goto L43;
        r11 = 5;
    L43:
        serviceDoneExecutingLocked(r, inDestroying, false, false, r11);     // Catch: Throwable -> L11
    L11:
        th = th;
    L47:
        this.mAm.mInjector.restoreCallingIdentity(origId);
        throw th;
    L45:
        th = th;
    L50:
        this.mAm.mInjector.restoreCallingIdentity(origId);
    }

    private final ServiceRecord findServiceLocked(ComponentName name, IBinder token, int userId) {
        ServiceRecord r = getServiceByNameLocked(name, userId);
        if (r == token) goto L7;
        return null;
    L7:
        return r;
    }

    private ServiceLookupResult retrieveServiceLocked(Intent service, String instanceName, String resolvedType, String callingPackage, int callingPid, int callingUid, int userId, boolean createIfNeeded, boolean callingFromFg, boolean isBindExternal, boolean allowInstant, boolean inSharedIsolatedProcess, boolean inPrivateSharedIsolatedProcess) {
        return retrieveServiceLocked(service, instanceName, false, -1, null, resolvedType, callingPackage, callingPid, callingUid, userId, createIfNeeded, callingFromFg, isBindExternal, allowInstant, null, inSharedIsolatedProcess, inPrivateSharedIsolatedProcess);
    }

    private String generateAdditionalSeInfoFromService(Intent service) {
        if (service != null) goto L4;
        return "";
    L4:
        if (service.getAction() != null) goto L6;
        return "";
    L6:
        if (service.getAction().equals("android.service.voice.HotwordDetectionService") == false) goto L8;
        return ":isolatedComputeApp";
    L8:
        if (service.getAction().equals("android.service.voice.VisualQueryDetectionService") == false) goto L10;
        return ":isolatedComputeApp";
    L10:
        if (service.getAction().equals("android.service.wearable.WearableSensingService") == false) goto L12;
        return ":isolatedComputeApp";
    L12:
        if (service.getAction().equals("android.service.ondeviceintelligence.OnDeviceSandboxedInferenceService") == false) goto L21;
        return ":isolatedComputeApp";
    L21:
        return "";
    }

    private ServiceLookupResult retrieveServiceLocked(Intent service, String instanceName, boolean isSdkSandboxService, int sdkSandboxClientAppUid, String sdkSandboxClientAppPackage, String resolvedType, String callingPackage, int callingPid, int callingUid, int userId, boolean createIfNeeded, boolean callingFromFg, boolean isBindExternal, boolean allowInstant, ForegroundServiceDelegationOptions fgsDelegateOptions, boolean inSharedIsolatedProcess, boolean inPrivateSharedIsolatedProcess) {
        return retrieveServiceLocked(service, instanceName, isSdkSandboxService, sdkSandboxClientAppUid, sdkSandboxClientAppPackage, resolvedType, callingPackage, callingPid, callingUid, userId, createIfNeeded, callingFromFg, isBindExternal, allowInstant, fgsDelegateOptions, inSharedIsolatedProcess, inPrivateSharedIsolatedProcess, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v45, types: [android.content.pm.PackageManager] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.android.server.am.ActivityManagerService] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v45, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v49, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v50, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v51, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v52, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v53, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v54, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v55, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v56, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v6, types: [int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v11 */
    /* JADX WARN: Type inference failed for: r26v12 */
    /* JADX WARN: Type inference failed for: r26v13 */
    /* JADX WARN: Type inference failed for: r26v17 */
    /* JADX WARN: Type inference failed for: r26v18 */
    /* JADX WARN: Type inference failed for: r26v19 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v20 */
    /* JADX WARN: Type inference failed for: r26v21 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v7 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v80 */
    /* JADX WARN: Type inference failed for: r3v81 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private ServiceLookupResult retrieveServiceLocked(Intent r54, String r55, boolean r56, int r57, String r58, String r59, String r60, int r61, int r62, int r63, boolean r64, boolean r65, boolean r66, boolean r67, ForegroundServiceDelegationOptions r68, boolean r69, boolean r70, boolean r71) {
        String r10 = r55;
        if (r56 == false) goto L9;
        if (r10 != null) goto L9;
        throw new IllegalArgumentException("No instanceName provided for sdk sandbox process");
    L9:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L11;
        StringBuilder r2 = new StringBuilder();
        r2.append("retrieveServiceLocked: ");
        r2.append(r54);
        r2.append(" type=");
        String r7 = r59;
        r2.append(r7);
        r2.append(" callingUid=");
        r2.append(r62);
        Slog.v("ActivityManager", r2.toString());
    L12:
        int r6 = this.mAm.mUserController.handleIncomingUser(r61, r62, r63, false, getAllowMode(r54, r60), HostingRecord.HOSTING_TYPE_SERVICE, r60);
        ServiceMap r11 = getServiceMapLocked(r6);
        ComponentAliasResolver.Resolution<ComponentName> r13 = this.mAm.mComponentAliasResolver.resolveService(r54, r7, 0, r6, r62);
        if (r10 != null) goto L15;
        ComponentName r4 = r54.getComponent();
    L18:
        if (r4 == null) goto L23;
        ServiceRecord r0 = r11.mServicesByInstanceName.get(r4);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L24;
        if (r0 == null) goto L24;
        Slog.v("ActivityManager", "Retrieved by component: " + r0);
    L24:
        if (r0 != null) goto L32;
        if (r66 == true) goto L32;
        if (r10 != null) goto L32;
        r0 = r11.mServicesByIntent.get(new Intent.FilterComparison(r54));
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L32;
        if (r0 == null) goto L32;
        Slog.v("ActivityManager", "Retrieved by intent: " + r0);
    L32:
        if (r0 == null) goto L45;
        ActiveServicesIA r16 = null;
        String r17 = ":";
        if (this.mAm.getPackageManagerInternal().filterAppAccess(r0.packageName, r62, r6) == false) goto L38;
        Slog.w("ActivityManager", "Unable to start service " + r54 + " U=" + r6 + ": not found");
        return null;
    L38:
        if ((r0.serviceInfo.flags & 4) == 0) goto L46;
        if (r60.equals(r0.packageName) == true) goto L46;
        r0 = null;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L46;
        Slog.v("ActivityManager", "Whoops, can't use existing external service");
    L46:
        ServiceRecord r18 = r0;
        if (r18 != null) goto L70;
        if (r68 == null) goto L70;
        ServiceInfo r1 = new ServiceInfo();
        ApplicationInfo r3 = AppGlobals.getPackageManager().getApplicationInfo(r68.mClientPackageName, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, r6);     // Catch: RemoteException -> L52
    L54:
        if (r3 == null) goto L69;
        if (r3.uid != r68.mClientUid) goto L67;
        r1.applicationInfo = r3;
        r1.packageName = r3.packageName;
        r1.mForegroundServiceType = r68.mForegroundServiceTypes;
        r1.processName = r3.processName;
        ComponentName r21 = r54.getComponent();
        r1.name = r21.getClassName();
        if (r64 == false) goto L63;
        Intent.FilterComparison r8 = new Intent.FilterComparison(r54.cloneFilter());
        ServiceRestarter r9 = new ServiceRestarter(this, r16);
        ServiceRecord r19 = new ServiceRecord(this.mAm, r21, r21, r1.applicationInfo.packageName, r1.applicationInfo.uid, r8, r1, r65, r9, getProcessNameForService(r1, r21, r60, null, false, false, false), -1, null, false);
        r19.foregroundId = r68.mClientNotificationId;
        r19.foregroundNoti = r68.mClientNotification;
        r9.setService(r19);
        r11.mServicesByInstanceName.put(r21, r19);
        r11.mServicesByIntent.put(r8, r19);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L62;
        Slog.v("ActivityManager", "Retrieve created new service: " + r19);
    L62:
        r19.mRecentCallingPackage = r60;
        r19.mRecentCallingUid = r62;
        ServiceRecord r14 = r19;
    L64:
        StringBuilder r5 = new StringBuilder();
        ApplicationInfo r12 = r14.appInfo;
        r5.append(r12.seInfo);
        r5.append(generateAdditionalSeInfoFromService(r54));
        r12.seInfo = r5.toString();
        return new ServiceLookupResult(this, r14, r13.getAlias());
    L63:
        r14 = r18;
        goto L64
    L67:
        throw new SecurityException("startForegroundServiceDelegate failed, uid:" + r3.uid + " does not match clientUid:" + r68.mClientUid);
    L69:
        throw new SecurityException("startForegroundServiceDelegate failed, could not resolve client package " + r60);
    L53:
        r3 = null;
    L70:
        ComponentName r33 = r4;
        String r15 = "association not allowed between packages ";
        if (r18 != null) goto L315;
        long r22 = 268436480;
        if (r67 == false) goto L75;
        r22 = 268436480 | 8388608;
    L75:
        if (r71 == false) goto L392;
        r22 = r22 | 8589934592L;
    L392:
        String r51 = " and ";
        Intent r20 = r54;
        String r110 = r60;
        long r23 = r22;
        r11 = r11;
        String r24 = r17;
        ResolveInfo r25 = this.mAm.getPackageManagerInternal().resolveService(r20, r59, r23, r6, r62, r61);     // Catch: RemoteException -> L310
        int r26 = r6;
        if (r25 != null) goto L369;
        ServiceInfo r27 = null;
    L87:
        if (r27 != null) goto L90;
        Slog.w("ActivityManager", "Unable to start service " + r20 + " U=" + r26 + ": not found");     // Catch: RemoteException -> L83
        return null;
    L90:
        if (r10 == null) goto L97;
        if ((r27.flags & 2) != 0) goto L97;
        if (r56 == true) goto L97;
        throw new IllegalArgumentException("Can't use instance name '" + r10 + "' with non-isolated non-sdk sandbox service '" + r27.name + "'");     // Catch: RemoteException -> L83
    L97:
        if (r56 == false) goto L373;
        if ((r27.flags & 2) == 0) goto L373;
        throw new IllegalArgumentException("Service cannot be both sdk sandbox and isolated");     // Catch: RemoteException -> L83
    L373:
        ComponentName r28 = new ComponentName(r27.applicationInfo.packageName, r27.name);     // Catch: RemoteException -> L308
        if (r33 == null) goto L106;
        ComponentName r29 = r33;
    L107:
        if (this.mAm.validateAssociationAllowedLocked(r110, r62, r29.getPackageName(), r27.applicationInfo.uid) == true) goto L364;
        StringBuilder r30 = new StringBuilder();     // Catch: RemoteException -> L120
        r30.append("association not allowed between packages ");     // Catch: RemoteException -> L120
        r30.append(r110);     // Catch: RemoteException -> L120
        r30.append(r51);     // Catch: RemoteException -> L118
        r30.append(r29.getPackageName());     // Catch: RemoteException -> L118
        String r31 = r30.toString();     // Catch: RemoteException -> L118
        StringBuilder r32 = new StringBuilder();     // Catch: RemoteException -> L118
        String r34 = "Service lookup failed: ";
        r32.append(r34);     // Catch: RemoteException -> L115
        r32.append(r31);     // Catch: RemoteException -> L115
        Slog.w("ActivityManager", r32.toString());     // Catch: RemoteException -> L115
        return new ServiceLookupResult(this, r31);
    L116:
        r10 = r34;
        r51 = r51;
    L117:
        String r210 = r15;
    L85:
        ?? r111 = r62;
        Object r35 = r110;
        ?? r211 = r210;
    L314:
        ServiceRecord r112 = r18;
        ?? r36 = r35;
        ?? r113 = r111;
        ?? r212 = r211;
    L316:
        if (r112 == null) goto L361;
        r112.mRecentCallingPackage = r36;
        r112.mRecentCallingUid = r113;
        r112.mRecentCallerApplicationInfo = this.mAm.mContext.getPackageManager().getApplicationInfoAsUser(r36, 0, UserHandle.getUserId(r113));     // Catch: PackageManager.NameNotFoundException -> L320
    L322:
        if (this.mAm.validateAssociationAllowedLocked(r36, r113, r112.packageName, r112.appInfo.uid) == true) goto L325;
        String r37 = r212 + r36 + r51 + r112.packageName;
        Slog.w("ActivityManager", r10 + r37);
        return new ServiceLookupResult(this, r37);
    L325:
        ?? r38 = r113;
        if (this.mAm.mIntentFirewall.checkService(r112.name, r54, r38 == true ? 1 : 0, r61, r59, r112.appInfo) == true) goto L330;
        return new ServiceLookupResult(this, "blocked by firewall");
    L330:
        if (ActivityManagerService.checkComponentPermission(r112.permission, r61, r38 == true ? 1 : 0, r112.appInfo.uid, r112.exported) == 0) goto L338;
        if (r112.exported == true) goto L335;
        Slog.w("ActivityManager", "Permission Denial: Accessing service " + r112.shortInstanceName + " from pid=" + r61 + ", uid=" + (r38 == true ? 1 : 0) + " that is not exported from uid " + r112.appInfo.uid);
        return new ServiceLookupResult(this, "not exported from uid " + r112.appInfo.uid);
    L335:
        Slog.w("ActivityManager", "Permission Denial: Accessing service " + r112.shortInstanceName + " from pid=" + r61 + ", uid=" + (r38 == true ? 1 : 0) + " requires " + r112.permission);
        return new ServiceLookupResult(this, r112.permission);
    L338:
        if ("android.permission.BIND_HOTWORD_DETECTION_SERVICE".equals(r112.permission) == true) goto L346;
        if ("android.permission.BIND_VISUAL_QUERY_DETECTION_SERVICE".equals(r112.permission) == true) goto L346;
        if ("android.permission.BIND_WEARABLE_SENSING_SERVICE".equals(r112.permission) == true) goto L346;
        if ("android.permission.BIND_ON_DEVICE_SANDBOXED_INFERENCE_SERVICE".equals(r112.permission) == true) goto L346;
    L350:
        if (r112.permission == null) goto L358;
        if (r60 == null) goto L358;
        int r39 = AppOpsManager.permissionToOpCode(r112.permission);
        if (r39 == (-1)) goto L358;
        if (this.mAm.getAppOpsManager().checkOpNoThrow(r39, r38 == true ? 1 : 0, r60) == 0) goto L358;
        Slog.w("ActivityManager", "Appop Denial: Accessing service " + r112.shortInstanceName + " from pid=" + r61 + ", uid=" + (r38 == true ? 1 : 0) + " requires appop " + AppOpsManager.opToName(r39));
        return null;
    L358:
        StringBuilder r40 = new StringBuilder();
        ApplicationInfo r41 = r112.appInfo;
        r40.append(r41.seInfo);
        r40.append(generateAdditionalSeInfoFromService(r54));
        r41.seInfo = r40.toString();
        return new ServiceLookupResult(this, r112, r13.getAlias());
    L346:
        if (r38 == 1000(0x3e8, float:1.401E-42)) goto L350;
        Slog.w("ActivityManager", "Permission Denial: Accessing service " + r112.shortInstanceName + " from pid=" + r61 + ", uid=" + (r38 == true ? 1 : 0) + " requiring permission " + r112.permission + " can only be bound to from the system.");
        return new ServiceLookupResult(this, "can only be bound to by the system.");
    L361:
        return null;
    L119:
        r34 = "Service lookup failed: ";
    L121:
        r10 = "Service lookup failed: ";
        goto L117
    L364:
        String r42 = r27.applicationInfo.packageName;     // Catch: RemoteException -> L306
        int r43 = r27.applicationInfo.uid;     // Catch: RemoteException -> L306
        ?? r213 = r27.flags & 4;
        r10 = "Service lookup failed: ";
        if (r213 == 0) goto L160;
        if (r66 == false) goto L159;
        r51 = r51;
        if (r27.exported == false) goto L157;
        if (r70 == true) goto L155;
        if ((r27.flags & 2) == 0) goto L153;
        if (this.mAm.getPackageManagerInternal().isSameApp(r110, r62, r26) == false) goto L151;
        ApplicationInfo r44 = AppGlobals.getPackageManager().getApplicationInfo(r110, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, r26);     // Catch: RemoteException -> L142
        if (r44 == null) goto L147;
        ServiceInfo r114 = new ServiceInfo(r27);     // Catch: RemoteException -> L142
        r114.applicationInfo = new ApplicationInfo(r114.applicationInfo);     // Catch: RemoteException -> L142
        r114.applicationInfo.packageName = r44.packageName;     // Catch: RemoteException -> L142
        r114.applicationInfo.uid = r44.uid;     // Catch: RemoteException -> L142
        ComponentName r115 = new ComponentName(r44.packageName, r29.getClassName());     // Catch: RemoteException -> L142
        String r116 = r44.packageName;     // Catch: RemoteException -> L142
        if (r10 != null) goto L144;
        String r117 = r28.getClassName();     // Catch: RemoteException -> L142
    L145:
        ComponentName r45 = new ComponentName(r116, r117);     // Catch: RemoteException -> L142
        r20.setComponent(r115);     // Catch: RemoteException -> L142
        ServiceInfo r118 = r114;
        ComponentName r119 = r115;
        ComponentName r46 = r45;
    L163:
        if (r69 == false) goto L169;
        if (r70 == false) goto L169;
        throw new SecurityException("Either BIND_SHARED_ISOLATED_PROCESS or BIND_PACKAGE_ISOLATED_PROCESS should be set. Not both.");     // Catch: RemoteException -> L142
    L169:
        if (r69 == true) goto L377;
        if (r70 == true) goto L377;
    L174:
        if (r70 == false) goto L180;
        if (isDefaultProcessService(r118) == false) goto L180;
        throw new SecurityException("BIND_PACKAGE_ISOLATED_PROCESS cannot be used for services running in the main app process.");     // Catch: RemoteException -> L142
    L180:
        if (r69 == false) goto L189;
        if (r10 == null) goto L188;
        if ((r118.flags & 16) != 0) goto L189;
        throw new SecurityException("BIND_SHARED_ISOLATED_PROCESS failed, " + r46 + " has not set the allowSharedIsolatedProcess  attribute.");     // Catch: RemoteException -> L142
    L188:
        throw new IllegalArgumentException("instanceName must be provided for binding a service into a shared isolated process.");     // Catch: RemoteException -> L142
    L189:
        if (r26 > 0) goto L370;
        Intent r47 = r20;
        r10 = r10;
        ServiceInfo r48 = r118;
        ServiceMap r120 = r11;
        int r121 = r26;
    L404:
        r112 = r120.mServicesByInstanceName.get(r119);     // Catch: RemoteException -> L295
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L247;
        if (r112 == null) goto L247;
        Slog.v("ActivityManager", "Retrieved via pm by intent: " + r112);     // Catch: RemoteException -> L244
    L247:
        if (r112 != null) goto L293;
        if (r64 == false) goto L293;
        Intent.FilterComparison r49 = new Intent.FilterComparison(r47.cloneFilter());     // Catch: RemoteException -> L244
        ServiceRestarter r50 = new ServiceRestarter(this, null);     // Catch: RemoteException -> L244
        ComponentName r52 = r119;
        int r122 = r62;
        String r410 = getProcessNameForService(r48, r52, r60, r55, r56, r69, r70);     // Catch: RemoteException -> L291
        String r53 = r60;
        ActivityManagerService r72 = this.mAm;     // Catch: RemoteException -> L289
        boolean r73 = true;
        if (r69 == true) goto L258;
        if (r70 == true) goto L258;
        boolean r411 = false;
    L259:
        ServiceInfo r412 = r48;
        ServiceRecord r310 = new ServiceRecord(r72, r46, r52, r42, r43, r49, r412, r65, r50, r410, r57, r58, r411);     // Catch: RemoteException -> L289
        Intent.FilterComparison r74 = r49;
        ServiceRestarter r75 = r50;
        r75.setService(r310);     // Catch: RemoteException -> L270
        r120.mServicesByInstanceName.put(r52, r310);     // Catch: RemoteException -> L270
        r120.mServicesByIntent.put(r74, r310);     // Catch: RemoteException -> L270
        int r123 = this.mPendingServices.size() - 1;     // Catch: RemoteException -> L270
    L262:
        if (r123 < 0) goto L274;
        boolean r124 = r73;
        ServiceRecord r76 = this.mPendingServices.get(r123);     // Catch: RemoteException -> L270
        Intent.FilterComparison r413 = r74;
        ServiceRestarter r414 = r75;
        if (r76.serviceInfo.applicationInfo.uid != r412.applicationInfo.uid) goto L273;
        if (r76.instanceName.equals(r52) == false) goto L273;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L272;
        Slog.v("ActivityManager", "Remove pending: " + r76);     // Catch: RemoteException -> L270
    L272:
        this.mPendingServices.remove(r123);     // Catch: RemoteException -> L270
    L273:
        r123 = r123 - 1;     // Catch: RemoteException -> L270
        r73 = r124;
        r74 = r413;
        r75 = r414;
        goto L262
    L274:
        int r77 = this.mPendingBringups.size() - 1;     // Catch: RemoteException -> L270
    L275:
        if (r77 < 0) goto L286;
        ServiceRecord r78 = this.mPendingBringups.keyAt(r77);     // Catch: RemoteException -> L270
        if (r78.serviceInfo.applicationInfo.uid != r412.applicationInfo.uid) goto L284;
        if (r78.instanceName.equals(r52) == false) goto L284;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L283;
        Slog.v("ActivityManager", "Remove pending bringup: " + r78);     // Catch: RemoteException -> L270
    L283:
        this.mPendingBringups.removeAt(r77);     // Catch: RemoteException -> L270
    L284:
        r77 = r77 - 1;     // Catch: RemoteException -> L270
        goto L275
    L286:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L288;
        Slog.v("ActivityManager", "Retrieve created new service: " + r310);     // Catch: RemoteException -> L270
    L288:
        r112 = r310;
        r36 = r53;
        r113 = r122;
        r212 = r15;
    L271:
        r18 = r310;
        r26 = r121;
        r11 = r120;
        r35 = r53;
        r111 = r122;
        r211 = r15;
    L258:
        r411 = true;
    L246:
        r26 = r121;
        r11 = r120;
        r18 = r112;
        r35 = r53;
        r111 = r122;
        r211 = r15;
    L292:
        r53 = r60;
    L293:
        r36 = r60;
        r113 = r62;
        r212 = r15;
    L245:
        r53 = r60;
        r122 = r62;
    L296:
        r35 = r60;
        r111 = r62;
        r26 = r121;
        r11 = r120;
        r211 = r15;
        goto L314
    L370:
        if (this.mAm.isSystemUserOnly(r118.flags) == false) goto L196;
        Slog.w("ActivityManager", r20 + " is only available for the SYSTEM user, calling userId is: " + r26);     // Catch: RemoteException -> L142
        return null;
    L196:
        if (this.mAm.isSingleton(r118.processName, r118.applicationInfo, r118.name, r118.flags) == false) goto L232;
        if (this.mAm.isValidSingletonCall(r62, r118.applicationInfo.uid) == false) goto L232;
        ServiceMap r79 = getServiceMapLocked(0);     // Catch: RemoteException -> L226
        long r80 = this.mAm.mInjector.clearCallingIdentity();     // Catch: RemoteException -> L224
        r10 = r10;
        long r125 = r80;
        ResolveInfo r81 = this.mAm.getPackageManagerInternal().resolveService(r20, r59, r23, 0, r62, r61);     // Catch: Throwable -> L218
        Intent r82 = r20;
        if (r81 != null) goto L216;
        Slog.w("ActivityManager", "Unable to resolve service " + r82 + " U=0: not found");     // Catch: Throwable -> L214
        this.mAm.mInjector.restoreCallingIdentity(r125);     // Catch: RemoteException -> L212
        return null;
    L216:
        ServiceInfo r83 = r81.serviceInfo;     // Catch: Throwable -> L214
        this.mAm.mInjector.restoreCallingIdentity(r125);     // Catch: RemoteException -> L212
        ServiceInfo r126 = r83;
        r26 = 0;
        r11 = r79;
        Intent r84 = r82;
    L406:
        ServiceInfo r85 = new ServiceInfo(r126);     // Catch: RemoteException -> L235
        r85.applicationInfo = this.mAm.getAppInfoForUser(r85.applicationInfo, r26);     // Catch: RemoteException -> L235
        r48 = r85;
        r120 = r11;
        r121 = r26;
        r47 = r84;
    L236:
        r35 = r60;
        r111 = r62;
        r211 = r15;
    L214:
        th = th;
    L222:
        this.mAm.mInjector.restoreCallingIdentity(r125);     // Catch: RemoteException -> L212
        throw th;     // Catch: RemoteException -> L212
    L218:
        th = th;
    L220:
        th = th;
        r125 = r80;
    L213:
        r35 = r60;
        r111 = r62;
        r26 = 0;
        r11 = r79;
        r211 = r15;
    L225:
        r10 = r10;
    L227:
        r10 = r10;
        r35 = r60;
        r111 = r62;
        r26 = 0;
        r11 = r11;
        r211 = r15;
    L232:
        r126 = r118;
        r11 = r11;
        r84 = r20;
    L230:
        r10 = r10;
        r35 = r60;
        r111 = r62;
        r11 = r11;
        r211 = r15;
    L377:
        if ((r118.flags & 2) != 0) goto L174;
        throw new SecurityException("BIND_SHARED_ISOLATED_PROCESS failed, " + r46 + " is not an isolatedProcess");     // Catch: RemoteException -> L300
    L303:
        r111 = r62;
        r35 = r110;
        r10 = r10;
        r11 = r11;
        r211 = r15;
        goto L314
    L144:
        r117 = r28.getClassName() + r24 + r10;     // Catch: RemoteException -> L142
        goto L145
    L147:
        throw new SecurityException("BIND_EXTERNAL_SERVICE failed, could not resolve client package " + r110);     // Catch: RemoteException -> L142
    L151:
        throw new SecurityException("BIND_EXTERNAL_SERVICE failed, calling package not owned by calling UID ");     // Catch: RemoteException -> L142
    L153:
        throw new SecurityException("BIND_EXTERNAL_SERVICE failed, " + r28 + " is not an isolatedProcess");     // Catch: RemoteException -> L142
    L155:
        throw new SecurityException("BIND_PACKAGE_ISOLATED_PROCESS cannot be applied to an external service.");     // Catch: RemoteException -> L142
    L157:
        throw new SecurityException("BIND_EXTERNAL_SERVICE failed, " + r28 + " is not exported");     // Catch: RemoteException -> L142
    L149:
        r213 = "association not allowed between packages ";
        goto L143
    L159:
        throw new SecurityException("BIND_EXTERNAL_SERVICE required for " + r29);     // Catch: RemoteException -> L142
    L160:
        r51 = r51;
        if (r66 == true) goto L305;
        r118 = r27;
        r119 = r29;
        r46 = r28;
        goto L163
    L305:
        throw new SecurityException("BIND_EXTERNAL_SERVICE failed, " + r29 + " is not an externalService");     // Catch: RemoteException -> L300
    L301:
        r11 = r11;
        r35 = r20;
        r111 = r15;
        r211 = r213;
    L143:
        r111 = r62;
        r35 = r110;
        r11 = r11;
        r10 = r10;
        r211 = r213;
    L307:
        r10 = "Service lookup failed: ";
        r211 = "association not allowed between packages ";
        r51 = r51;
        r35 = r110;
        r111 = r62;
        r11 = r11;
        goto L314
    L106:
        r29 = r28;
    L309:
        r211 = "association not allowed between packages ";
        r35 = r110;
        r10 = "Service lookup failed: ";
        r111 = r62;
        r11 = r11;
        goto L314
    L369:
        r27 = r25.serviceInfo;     // Catch: RemoteException -> L83
        goto L87
    L84:
        r210 = "association not allowed between packages ";
        r10 = "Service lookup failed: ";
    L311:
        r26 = r6;
        r211 = "association not allowed between packages ";
        r35 = r110;
        r10 = "Service lookup failed: ";
        r111 = r62;
        r11 = r11;
    L313:
        r35 = r60;
        r10 = "Service lookup failed: ";
        r51 = " and ";
        r211 = "association not allowed between packages ";
        r111 = r62;
        r26 = r6;
        goto L314
    L315:
        r36 = r60;
        r10 = "Service lookup failed: ";
        r51 = " and ";
        r212 = "association not allowed between packages ";
        r113 = r62;
        r112 = r18;
        goto L316
    L45:
        r17 = ":";
        r16 = null;
        goto L46
    L23:
        r0 = null;
        goto L24
    L15:
        ComponentName r86 = r54.getComponent();
        if (r86 == null) goto L363;
        r4 = new ComponentName(r86.getPackageName(), r86.getClassName() + ":" + r10);
        goto L18
    L363:
        throw new IllegalArgumentException("Can't use custom instance name '" + r10 + "' without expicit component in Intent");
    L11:
        r7 = r59;
        goto L12
    }

    private int getAllowMode(Intent service, String callingPackage) {
        if (callingPackage != null) goto L4;
        return 1;
    L4:
        if (service.getComponent() != null) goto L6;
        return 1;
    L6:
        if (callingPackage.equals(service.getComponent().getPackageName()) == false) goto L12;
        return 3;
    L12:
        return 1;
    }

    private void bumpServiceExecutingLocked(ServiceRecord r, boolean fg, String why, int oomAdjReason, boolean skipTimeoutIfPossible) {
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L6;
        Slog.v("ActivityManager", ">>> EXECUTING " + why + " of " + r + " in app " + r.app);
    L9:
        if (StabTrace.isEnable() == false) goto L11;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L13:
        if (this.mAm.mBootPhase < 600) goto L15;
    L19:
        boolean timeoutNeeded = true;
    L20:
        boolean timeoutNeeded2 = false;
        if (skipTimeoutIfPossible == true) goto L23;
    L29:
        boolean r8 = false;
    L30:
        boolean shouldSkipTimeout = r8;
        if (r.executeNesting != 0) goto L56;
        r.executeFg = fg;
        Object r9 = this.mAm.mProcessStats.mLock;
        monitor-enter(r9);
        ServiceState stracker = r.getTracker();     // Catch: Throwable -> L37
        if (stracker == null) goto L39;
        stracker.setExecuting(true, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L37
    L39:
        monitor-exit(r9);     // Catch: Throwable -> L37
        if (r.app == null) goto L66;
        SysOptBridge.getFactory().getFreezeController().bumpServiceEvent(r.app.uid, r.app.mPid, false, "bumpServiceExecutingLocked = " + r.shortInstanceName);
        ProcessServiceRecord psr = r.app.mServices;
        this.mAm.mProcessStateController.startExecutingService(psr, r);
        ProcessStateController r10 = this.mAm.mProcessStateController;
        if (psr.shouldExecServicesFg() == true) goto L45;
        if (fg == true) goto L45;
    L46:
        r10.setExecServicesFg(psr, timeoutNeeded2);
        if (timeoutNeeded == false) goto L66;
        if (psr.numberOfExecutingServices() != 1) goto L66;
        if (shouldSkipTimeout == true) goto L52;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().monitorService(r);
        scheduleServiceTimeoutLocked(r.app);
        goto L66
    L52:
        r.app.mServices.noteScheduleServiceTimeoutPending(true);
    L45:
        timeoutNeeded2 = true;
    L66:
        if (r.app != null) goto L68;
    L72:
        r.executeFg |= fg;
        r.executeNesting++;
        r.executingStart = SystemClock.uptimeMillis();
        if (timeoutNeeded == true) goto L75;
        return;
    L75:
        if (StabTrace.isEnable() == false) goto L81;
        StringBuilder sb = new StringBuilder(150);
        sb.append("bumpServiceExec:");
        sb.append(r.name.getClassName());
        sb.append("exeNesting=");
        sb.append(r.executeNesting);
        sb.append("why=");
        sb.append(why);
        sb.append("fg=");
        sb.append(fg);
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());
        return;
    L81:
        return;
    L68:
        if (r.app.mState.getCurProcState() <= 10) goto L72;
        this.mAm.enqueueOomAdjTargetLocked(r.app);
        r.updateOomAdjSeq();
        if (oomAdjReason == 0) goto L72;
        this.mAm.updateOomAdjPendingTargetsLocked(oomAdjReason);
    L37:
        th = move-exception;
        throw th;
    L56:
        if (r.app == null) goto L66;
        if (fg == false) goto L66;
        ProcessServiceRecord psr2 = r.app.mServices;
        if (psr2.shouldExecServicesFg() == true) goto L66;
        this.mAm.mProcessStateController.setExecServicesFg(psr2, true);
        if (timeoutNeeded == false) goto L66;
        if (shouldSkipTimeout == true) goto L64;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().monitorService(r);
        scheduleServiceTimeoutLocked(r.app);
        goto L66
    L64:
        r.app.mServices.noteScheduleServiceTimeoutPending(true);
        goto L66
    L23:
        if (r.app == null) goto L29;
        if (r.app.mOptRecord.isPendingFreeze() == false) goto L27;
    L28:
        r8 = true;
        goto L30
    L27:
        if (r.app.mOptRecord.isFrozen() == false) goto L29;
    L15:
        if (r.app == null) goto L19;
        if (r.app.getPid() != ActivityManagerService.MY_PID) goto L19;
        Slog.w("ActivityManager", "Too early to start/bind service in system_server: Phase=" + this.mAm.mBootPhase + " " + r.getComponentName());
        timeoutNeeded = false;
        goto L20
    L11:
        beginTime2 = 0;
        goto L13
    L6:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE_EXECUTING == false) goto L9;
        Slog.v("ActivityManager", ">>> EXECUTING " + why + " of " + r.shortInstanceName);
        goto L9
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    private final boolean requestServiceBindingLocked(ServiceRecord r, IntentBindRecord i, boolean execInFg, boolean rebind, int serviceBindingOomAdjPolicy) throws TransactionTooLargeException {
        ServiceRecord r2 = r;
        if (r2.app != null) goto L5;
        return false;
    L5:
        if (r2.app.getThread() != null) goto L8;
        return false;
    L8:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L11;
        Slog.d("ActivityManager", "requestBind " + i + ": requested=" + i.requested + " rebind=" + rebind);
    L11:
        if ((serviceBindingOomAdjPolicy & 2) == 0) goto L13;
        boolean skipOomAdj = true;
    L15:
        if (i.requested == false) goto L20;
        if (rebind == true) goto L20;
    L95:
        return true;
    L20:
        if (i.apps.size() <= 0) goto L95;
        if (skipOomAdj == false) goto L25;
        int r5 = 0;
    L26:
        ActiveServices r1 = this;
        r1.bumpServiceExecutingLocked(r2, execInFg, "bind", r5, skipOomAdj);     // Catch: RemoteException -> L66 TransactionTooLargeException -> L69
        ActiveServices r14 = r1;
    L64:
        e = e;
        String r24 = "ActivityManager";
    L55:
        r1 = r14;
        String r3 = r24;
    L86:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L88;
        Slog.v(r3, "Crashed while binding " + r2, e);
    L88:
        boolean inDestroying = r1.mDestroyingServices.contains(r2);
        if (r2.wasOomAdjUpdated() == false) goto L91;
        int r6 = 5;
    L92:
        r1.serviceDoneExecutingLocked(r2, inDestroying, inDestroying, false, r6);
        throw e;
    L91:
        r6 = 0;
        goto L92
    L30:
        if (Trace.isTagEnabled(64) == false) goto L39;
        Trace.instant(64, "requestServiceBinding=" + i.intent.getIntent() + ". bindSeq=" + r14.mBindServiceSeqCounter);     // Catch: RemoteException -> L33 TransactionTooLargeException -> L35
    L35:
        e = e;
        r3 = "ActivityManager";
        r1 = r14;
    L39:
        if (StabTrace.isEnable() == false) goto L42;
        long beginTime = Process.getCpuClocks();     // Catch: RemoteException -> L33 TransactionTooLargeException -> L35
        long beginTime2 = beginTime;
    L43:
        IApplicationThread r0 = r2.app.getThread();     // Catch: RemoteException -> L33 TransactionTooLargeException -> L64
        Intent r4 = i.intent.getIntent();     // Catch: RemoteException -> L33 TransactionTooLargeException -> L64
        int r7 = r2.app.mState.getReportedProcState();     // Catch: RemoteException -> L33 TransactionTooLargeException -> L64
        long r8 = r14.mBindServiceSeqCounter;     // Catch: RemoteException -> L33 TransactionTooLargeException -> L64
        r24 = "ActivityManager";
        r14.mBindServiceSeqCounter = r8 + 1;     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        r0.scheduleBindService(r2, r4, rebind, r7, r8);     // Catch: RemoteException -> L60 TransactionTooLargeException -> L62
        r2 = r2;
        if (StabTrace.isEnable() == false) goto L56;
        StringBuilder sb = new StringBuilder(150);     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        sb.append("scheduleBindService:pid=");     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        sb.append(r2.app.getPid());     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        sb.append("name=");     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        sb.append(r2.name.getClassName());     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
    L56:
        if (rebind == true) goto L58;
        i.requested = true;     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
    L58:
        i.hasBound = true;     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        i.doRebind = false;     // Catch: RemoteException -> L52 TransactionTooLargeException -> L54
        goto L75
    L62:
        e = e;
        r2 = r2;
    L61:
        r2 = r2;
    L54:
        e = e;
    L75:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L77;
        Slog.v(r24, "Crashed while binding " + r2);
    L77:
        boolean inDestroying2 = r14.mDestroyingServices.contains(r2);
        if (r2.wasOomAdjUpdated() == false) goto L80;
        int r9 = 5;
    L81:
        r14.serviceDoneExecutingLocked(r2, inDestroying2, inDestroying2, false, r9);
        return false;
    L80:
        r9 = 0;
        goto L81
        goto L34
    L42:
        beginTime2 = 0;
    L34:
        r24 = "ActivityManager";
        goto L75
    L69:
        e = e;
        r3 = "ActivityManager";
    L67:
        r14 = r1;
        r24 = "ActivityManager";
        goto L75
    L25:
        r5 = 4;
        goto L26
    L13:
        skipOomAdj = false;
        goto L15
    }

    private final boolean scheduleServiceRestartLocked(ServiceRecord r, boolean allowCancel) {
        if (this.mAm.mAtmInternal.isShuttingDown() == false) goto L6;
        Slog.w("ActivityManager", "Not scheduling restart of crashed service " + r.shortInstanceName + " - system is shutting down");
        return false;
    L6:
        ServiceMap smap = getServiceMapLocked(r.userId);
        if (smap.mServicesByInstanceName.get(r.instanceName) == r) goto L10;
        ServiceRecord cur = smap.mServicesByInstanceName.get(r.instanceName);
        Slog.wtf("ActivityManager", "Attempting to schedule restart of " + r + " when found in map: " + cur);
        return false;
    L10:
        long now = SystemClock.uptimeMillis();
        int oldPosInRestarting = this.mRestartingServices.indexOf(r);
        if (oldPosInRestarting == (-1)) goto L13;
        boolean inRestarting = true;
    L15:
        if ((r.serviceInfo.applicationInfo.flags & 8) != 0) goto L112;
        long minDuration = this.mAm.mConstants.SERVICE_RESTART_DURATION;
        long resetTime = this.mAm.mConstants.SERVICE_RESET_RUN_DURATION;
        boolean canceled = false;
        int N = r.deliveredStarts.size();
        if (N <= 0) goto L47;
        int i = N - 1;
        int r18 = 1;
    L19:
        if (i < 0) goto L46;
        ServiceRecord.StartItem si = r.deliveredStarts.get(i);
        si.removeUriPermissionsLocked();
        boolean inRestarting2 = inRestarting;
        if (si.intent != null) goto L23;
        ServiceMap smap2 = smap;
        i = i;
    L45:
        i = i - 1;
        inRestarting = inRestarting2;
        smap = smap2;
        goto L19
    L23:
        if (allowCancel == false) goto L30;
        smap2 = smap;
        if (si.deliveryCount < 3) goto L27;
    L29:
        StringBuilder r8 = new StringBuilder();
        i = i;
        r8.append("Canceling start item ");
        r8.append(si.intent);
        r8.append(" in service ");
        r8.append(r.shortInstanceName);
        Slog.w("ActivityManager", r8.toString());
        canceled = true;
        goto L45
    L27:
        if (si.doneExecutingCount >= 6) goto L29;
    L31:
        r.pendingStarts.add(0, si);
        boolean r4 = canceled;
        long dur = 2 * (SystemClock.uptimeMillis() - si.deliveredTime);
        if (SERVICE_RESCHEDULE == false) goto L38;
        if (DEBUG_DELAYED_SERVICE == false) goto L38;
        Slog.w("ActivityManager", "Can add more delay !!! si.deliveredTime " + si.deliveredTime + " dur " + dur + " si.deliveryCount " + si.deliveryCount + " si.doneExecutingCount " + si.doneExecutingCount + " allowCancel " + allowCancel);
    L38:
        if (minDuration >= dur) goto L41;
        minDuration = dur;
    L41:
        if (resetTime >= dur) goto L43;
        resetTime = dur;
    L44:
        canceled = r4;
        goto L45
    L43:
        resetTime = resetTime;
        goto L44
    L30:
        smap2 = smap;
        goto L31
    L46:
        boolean inRestarting3 = inRestarting;
        r.deliveredStarts.clear();
    L48:
        if (allowCancel == false) goto L61;
        boolean shouldStop = r.canStopIfKilled(canceled);
        if (shouldStop == false) goto L56;
        if (r.hasAutoCreateConnections() == true) goto L56;
        return false;
    L56:
        if (r.startRequested == false) goto L59;
        if (shouldStop == true) goto L59;
        String reason = "start-requested";
    L62:
        r.totalRestartCount++;
        if (SERVICE_RESCHEDULE == false) goto L69;
        if (DEBUG_DELAYED_SERVICE == false) goto L69;
        Slog.w("ActivityManager", "r.name " + r.name + " N " + N + " minDuration " + minDuration + " resetTime " + resetTime + " now " + now + " r.restartDelay " + r.restartDelay + " r.restartTime+resetTime " + (r.restartTime + resetTime) + " allowCancel " + allowCancel);
    L69:
        if (r.restartDelay != 0) goto L71;
        r.restartCount++;
        r.restartDelay = minDuration;
        int oldPosInRestarting2 = oldPosInRestarting;
    L81:
        if (isServiceRestartBackoffEnabledLocked(r.packageName) == false) goto L110;
        long r9 = r.restartDelay + now;
        r.mEarliestRestartTime = r9;
        r.nextRestartTime = r9;
        if (SERVICE_RESCHEDULE == true) goto L85;
    L87:
        if (inRestarting3 == false) goto L89;
        int oldPosInRestarting3 = oldPosInRestarting2;
        this.mRestartingServices.remove(oldPosInRestarting3);
        boolean inRestarting4 = false;
    L91:
        if (this.mRestartingServices.isEmpty() == false) goto L93;
        long extraDelay = getExtraRestartTimeInBetweenLocked();
        long r3 = now + extraDelay;
        long extraDelay2 = r.nextRestartTime;
        r.nextRestartTime = Math.max(r3, extraDelay2);
        r.restartDelay = r.nextRestartTime - now;
    L108:
        boolean inRestarting5 = inRestarting4;
    L111:
        boolean inRestarting6 = inRestarting5;
        String reason2 = reason;
    L113:
        r.mRestartSchedulingTime = now;
        if (inRestarting6 == false) goto L116;
    L133:
        cancelForegroundNotificationLocked(r);
        performScheduleRestartLocked(r, "Scheduling", reason2, now);
        return true;
    L116:
        if (oldPosInRestarting3 != (-1)) goto L125;
        r.createdFromFg = false;
        Object r5 = this.mAm.mProcessStats.mLock;
        monitor-enter(r5);
        r.makeRestarting(this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L122
        monitor-exit(r5);     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        throw th;
    L125:
        boolean added = false;
        int i2 = 0;
        int size = this.mRestartingServices.size();
    L126:
        if (i2 >= size) goto L131;
        ServiceRecord r2 = this.mRestartingServices.get(i2);
        if (r2.nextRestartTime > r.nextRestartTime) goto L129;
        i2 = i2 + 1;
        goto L126
    L129:
        this.mRestartingServices.add(i2, r);
        added = true;
    L131:
        if (added == true) goto L133;
        this.mRestartingServices.add(r);
        goto L133
    L93:
        long restartTimeBetween = getExtraRestartTimeInBetweenLocked() + this.mAm.mConstants.SERVICE_MIN_RESTART_TIME_BETWEEN;
    L94:
        boolean repeat = false;
        long restartTimeBetween2 = restartTimeBetween;
        long nextRestartTime = r.nextRestartTime;
        int i3 = this.mRestartingServices.size() - 1;
    L95:
        if (i3 < 0) goto L105;
        int N2 = N;
        ServiceRecord r6 = this.mRestartingServices.get(i3);
        long nextRestartTime2 = nextRestartTime;
        long nextRestartTime3 = r6.nextRestartTime;
        if (nextRestartTime2 >= (nextRestartTime3 - restartTimeBetween2)) goto L99;
    L101:
        long nextRestartTime4 = nextRestartTime3 + restartTimeBetween2;
        if (nextRestartTime2 >= nextRestartTime4) goto L107;
        i3 = i3 - 1;
        N = N2;
        nextRestartTime = nextRestartTime2;
    L107:
        if (repeat == false) goto L108;
        restartTimeBetween = restartTimeBetween2;
        N = N2;
        goto L94
    L99:
        if (nextRestartTime2 >= (nextRestartTime3 + restartTimeBetween2)) goto L101;
        long nextRestartTime5 = nextRestartTime3 + restartTimeBetween2;
        r.nextRestartTime = nextRestartTime5;
        r.restartDelay = r.nextRestartTime - now;
        repeat = true;
        goto L107
    L105:
        N2 = N;
        goto L107
    L89:
        oldPosInRestarting3 = oldPosInRestarting2;
        inRestarting4 = inRestarting3;
        goto L91
    L85:
        if (DEBUG_DELAYED_SERVICE == false) goto L87;
        Slog.w("ActivityManager", "r.name " + r.name + " N " + N + " minDuration " + minDuration + " resetTime " + resetTime + " now " + now + " r.restartDelay " + r.restartDelay + " r.restartTime+resetTime " + (r.restartTime + resetTime) + " r.nextRestartTime " + r.nextRestartTime + " allowCancel " + allowCancel);
        goto L87
    L110:
        reason = reason;
        oldPosInRestarting3 = oldPosInRestarting2;
        r.restartDelay = this.mAm.mConstants.SERVICE_RESTART_DURATION;
        r.nextRestartTime = r.restartDelay + now;
        inRestarting5 = inRestarting3;
        goto L111
    L71:
        int r10 = r18;
        if (r.crashCount <= r10) goto L74;
        oldPosInRestarting2 = oldPosInRestarting;
        r.restartDelay = this.mAm.mConstants.BOUND_SERVICE_CRASH_RESTART_DURATION * ((long) (r.crashCount - r10));
        goto L81
    L74:
        oldPosInRestarting2 = oldPosInRestarting;
        if (now <= (r.restartTime + resetTime)) goto L77;
        r.restartCount = 1;
        r.restartDelay = minDuration;
        goto L81
    L77:
        r.restartDelay *= (long) this.mAm.mConstants.SERVICE_RESTART_DURATION_FACTOR;
        if (r.restartDelay >= minDuration) goto L81;
        r.restartDelay = minDuration;
    L59:
        reason = "connection";
        goto L62
    L61:
        reason = "always";
        goto L62
    L47:
        inRestarting3 = inRestarting;
        r18 = 1;
        goto L48
    L112:
        inRestarting6 = inRestarting;
        oldPosInRestarting3 = oldPosInRestarting;
        r.totalRestartCount++;
        r.restartCount = 0;
        r.restartDelay = 0;
        r.mEarliestRestartTime = 0;
        r.nextRestartTime = now;
        reason2 = "persistent";
        goto L113
    L13:
        inRestarting = false;
        goto L15
    }

    void performScheduleRestartLocked(ServiceRecord r, String scheduling, String reason, long now) {
        if (r.fgRequired == true) goto L5;
    L7:
        this.mAm.mHandler.removeCallbacks(r.restarter);
        this.mAm.mHandler.postAtTime(r.restarter, r.nextRestartTime);
        r.nextRestartTime = r.restartDelay + now;
        Slog.w("ActivityManager", scheduling + " restart of crashed service " + r.shortInstanceName + " in " + r.restartDelay + "ms for " + reason);
        if (SERVICE_RESCHEDULE == true) goto L10;
    L14:
        int i = r.userId;
        EventLog.writeEvent(EventLogTags.AM_SCHEDULE_SERVICE_RESTART, new Object[]{Integer.valueOf(i), r.shortInstanceName, Long.valueOf(r.restartDelay)});
        return;
    L10:
        if (DEBUG_DELAYED_SERVICE == false) goto L14;
        int i2 = this.mRestartingServices.size() - 1;
    L12:
        if (i2 < 0) goto L14;
        ServiceRecord r2 = this.mRestartingServices.get(i2);
        Slog.w("ActivityManager", "Restarting list - i " + i2 + " r2.nextRestartTime " + r2.nextRestartTime + " r2.name " + r2.name);
        i2 = i2 + (-1);
        goto L12
    L5:
        if (r.fgWaiting == false) goto L7;
        this.mServiceFGAnrTimer.cancel(r);
        r.fgWaiting = false;
        goto L7
    }

    void rescheduleServiceRestartOnMemoryPressureIfNeededLocked(int prevMemFactor, int curMemFactor, String reason, long now) {
        boolean enabled = this.mAm.mConstants.mEnableExtraServiceRestartDelayOnMemPressure;
        if (enabled == true) goto L5;
        return;
    L5:
        performRescheduleServiceRestartOnMemoryPressureLocked(this.mAm.mConstants.mExtraServiceRestartDelayOnMemPressure[prevMemFactor], this.mAm.mConstants.mExtraServiceRestartDelayOnMemPressure[curMemFactor], reason, now);
    }

    void rescheduleServiceRestartOnMemoryPressureIfNeededLocked(boolean prevEnabled, boolean curEnabled, long now) {
        if (prevEnabled != curEnabled) goto L4;
        return;
    L4:
        int memFactor = this.mAm.mAppProfiler.getLastMemoryLevelLocked();
        long delay = this.mAm.mConstants.mExtraServiceRestartDelayOnMemPressure[memFactor];
        long r1 = 0;
        long r3 = 0;
        if (prevEnabled == false) goto L7;
        r1 = delay;
    L7:
        if (curEnabled == false) goto L9;
        r3 = delay;
    L9:
        performRescheduleServiceRestartOnMemoryPressureLocked(r1, r3, "config", now);
    }

    void rescheduleServiceRestartIfPossibleLocked(long extraRestartTimeBetween, long minRestartTimeBetween, String reason, long now) {
        ActiveServices r0 = this;
        long restartTimeBetween = extraRestartTimeBetween + minRestartTimeBetween;
        long spanForInsertOne = restartTimeBetween * 2;
        long lastRestartTime = now;
        int lastRestartTimePos = -1;
        int i = 0;
        int size = r0.mRestartingServices.size();
    L3:
        if (i >= size) goto L39;
        ServiceRecord r = r0.mRestartingServices.get(i);
        if ((r.serviceInfo.applicationInfo.flags & 8) != 0) goto L36;
        if (r0.isServiceRestartBackoffEnabledLocked(r.packageName) == false) goto L36;
        long r13 = lastRestartTime + restartTimeBetween;
        long lastRestartTime2 = lastRestartTime;
        long lastRestartTime3 = r.mEarliestRestartTime;
        if (r13 > lastRestartTime3) goto L17;
        long r1 = r.mEarliestRestartTime;
        if (i <= 0) goto L14;
        long r14 = r0.mRestartingServices.get(i - 1).nextRestartTime + restartTimeBetween;
    L15:
        r.nextRestartTime = Math.max(now, Math.max(r1, r14));
    L23:
        int j = lastRestartTimePos + 1;
        int lastRestartTimePos2 = lastRestartTimePos;
    L24:
        if (j > i) goto L34;
        ServiceRecord r2 = r0.mRestartingServices.get(j);
        long r3 = r2.nextRestartTime;
        if (j != 0) goto L28;
        long r4 = lastRestartTime2;
    L29:
        long timeInBetween = r3 - r4;
        if (timeInBetween >= spanForInsertOne) goto L34;
        long lastRestartTime4 = r2.nextRestartTime;
        lastRestartTimePos2 = j;
        lastRestartTime2 = lastRestartTime4;
        j = j + 1;
        r0 = this;
        goto L24
    L28:
        r4 = r0.mRestartingServices.get(j - 1).nextRestartTime;
    L34:
        r.restartDelay = r.nextRestartTime - now;
        performScheduleRestartLocked(r, "Rescheduling", reason, now);
        lastRestartTimePos = lastRestartTimePos2;
        lastRestartTime = lastRestartTime2;
    L37:
        i = i + 1;
        r0 = this;
        goto L3
    L14:
        r14 = 0;
        goto L15
    L17:
        if (lastRestartTime2 > now) goto L19;
        r.nextRestartTime = Math.max(now, Math.max(r.mEarliestRestartTime, r.mRestartSchedulingTime + extraRestartTimeBetween));
    L21:
        if (i <= (lastRestartTimePos + 1)) goto L23;
        r0.mRestartingServices.remove(i);
        r0.mRestartingServices.add(lastRestartTimePos + 1, r);
        goto L23
    L19:
        r.nextRestartTime = Math.max(now, lastRestartTime2 + restartTimeBetween);
    L36:
        long lastRestartTime5 = r.nextRestartTime;
        int lastRestartTimePos3 = i;
        lastRestartTimePos = lastRestartTimePos3;
        lastRestartTime = lastRestartTime5;
        goto L37
    }

    void performRescheduleServiceRestartOnMemoryPressureLocked(long oldExtraDelay, long newExtraDelay, String reason, long now) {
        ActiveServices r0 = this;
        long delta = newExtraDelay - oldExtraDelay;
        if (delta != 0) goto L6;
        return;
    L6:
        if (delta <= 0) goto L36;
        long restartTimeBetween = r0.mAm.mConstants.SERVICE_MIN_RESTART_TIME_BETWEEN + newExtraDelay;
        long lastRestartTime = now;
        int size = r0.mRestartingServices.size();
        int i = 0;
    L8:
        if (i >= size) goto L42;
        ServiceRecord r = r0.mRestartingServices.get(i);
        if ((r.serviceInfo.applicationInfo.flags & 8) != 0) goto L31;
        if (r0.isServiceRestartBackoffEnabledLocked(r.packageName) == false) goto L31;
        boolean reschedule = false;
        if (lastRestartTime > now) goto L22;
        long oldVal = r.nextRestartTime;
        long r1 = r.mEarliestRestartTime;
        restartTimeBetween = restartTimeBetween;
        long restartTimeBetween2 = r.mRestartSchedulingTime;
        r.nextRestartTime = Math.max(now, Math.max(r1, restartTimeBetween2 + newExtraDelay));
        if (r.nextRestartTime == oldVal) goto L19;
        boolean r2 = true;
    L20:
        reschedule = r2;
    L25:
        r.restartDelay = r.nextRestartTime - now;
        long lastRestartTime2 = r.nextRestartTime;
        if (reschedule == false) goto L28;
        r0 = this;
        r0.performScheduleRestartLocked(r, "Rescheduling", reason, now);
    L29:
        lastRestartTime = lastRestartTime2;
    L32:
        i = i + 1;
        restartTimeBetween = restartTimeBetween;
        goto L8
    L28:
        r0 = this;
        goto L29
    L19:
        r2 = false;
        goto L20
    L22:
        long lastRestartTime3 = lastRestartTime;
        restartTimeBetween = restartTimeBetween;
        if ((r.nextRestartTime - lastRestartTime3) >= restartTimeBetween) goto L25;
        r.nextRestartTime = Math.max(lastRestartTime3 + restartTimeBetween, now);
        reschedule = true;
    L31:
        long lastRestartTime4 = r.nextRestartTime;
        lastRestartTime = lastRestartTime4;
        goto L32
    L42:
        return;
    L36:
        if (delta >= 0) goto L43;
        r0.rescheduleServiceRestartIfPossibleLocked(newExtraDelay, r0.mAm.mConstants.SERVICE_MIN_RESTART_TIME_BETWEEN, reason, now);
        return;
    }

    long getExtraRestartTimeInBetweenLocked() {
        if (this.mAm.mConstants.mEnableExtraServiceRestartDelayOnMemPressure == true) goto L6;
        return 0;
    L6:
        int memFactor = this.mAm.mAppProfiler.getLastMemoryLevelLocked();
        return this.mAm.mConstants.mExtraServiceRestartDelayOnMemPressure[memFactor];
    }

    final void performServiceRestartLocked(ServiceRecord r) {
        if (this.mRestartingServices.contains(r) == true) goto L5;
        return;
    L5:
        boolean isVisible = false;
        if (isServiceNeededLocked(r, false, false) == true) goto L51;
        Slog.wtf("ActivityManager", "Restarting service that is not needed: " + r);
        this.mRestartingServices.remove(r);
        return;
    L51:
    L22:
        th = move-exception;
        this.mAm.updateOomAdjPendingTargetsLocked(6);
        throw th;
    L11:
        if (SERVICE_RESCHEDULE == false) goto L46;
        ActivityRecord top_rc = this.mAm.mTaskSupervisor.getTopResumedActivity();     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
        ProcessRecord pRec = this.mAm.getProcessRecordLocked(r.serviceInfo.applicationInfo.processName, r.serviceInfo.applicationInfo.uid);     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
        if ((r.serviceInfo.applicationInfo.flags & 8) == 0) goto L15;
        boolean r5 = true;
    L16:
        boolean isPersistent = r5;
        if (pRec != null) goto L19;
        isVisible = false;
    L27:
        if (top_rc != null) goto L29;
    L37:
        boolean shouldDelay = false;
    L38:
        if (shouldDelay == true) goto L42;
        bringUpServiceLocked(r, r.intent.getIntent().getFlags(), r.createdFromFg, true, false, false, true, 0);     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
        goto L47
    L42:
        if (DEBUG_DELAYED_SERVICE == false) goto L44;
        Slog.v("ActivityManager", "Reschedule service restart due to app launch r.shortInstanceName " + r.shortInstanceName + " r.app = " + r.app);     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
    L44:
        Slog.d("ActivityManager", "Reschedule service restart due to app launch r.shortInstanceName " + r.shortInstanceName + " r.app = " + r.app);     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
        r.resetRestartCounter();     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
        scheduleServiceRestartLocked(r, true);     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
        goto L47
    L29:
        if (top_rc.launching == false) goto L37;
        if (r.shortInstanceName.contains(top_rc.packageName) == true) goto L37;
        if (isPersistent == true) goto L37;
        if (r.isForeground == true) goto L37;
        if (isVisible == true) goto L37;
        shouldDelay = true;
        goto L38
    L19:
        if (pRec.mProfile.getCurRawAdj() != 100) goto L27;
        isVisible = true;
        goto L27
    L15:
        r5 = false;
        goto L16
    L46:
        bringUpServiceLocked(r, r.intent.getIntent().getFlags(), r.createdFromFg, true, false, false, true, 0);     // Catch: Throwable -> L22 TransactionTooLargeException -> L24
    L47:
        this.mAm.updateOomAdjPendingTargetsLocked(6);
    }

    private final boolean unscheduleServiceRestartLocked(ServiceRecord r, int callingUid, boolean force) {
        if (force == false) goto L4;
    L7:
        boolean removed = this.mRestartingServices.remove(r);
        if (removed == false) goto L10;
    L11:
        r.resetRestartCounter();
    L12:
        if (removed == false) goto L14;
        clearRestartingIfNeededLocked(r);
    L14:
        this.mAm.mHandler.removeCallbacks(r.restarter);
        return true;
    L10:
        if (callingUid == r.appInfo.uid) goto L12;
    L4:
        if (r.restartDelay != 0) goto L7;
        return false;
    }

    private void clearRestartingIfNeededLocked(ServiceRecord r) {
        if (r.restartTracker == null) goto L19;
        boolean stillTracking = false;
        int i = this.mRestartingServices.size() - 1;
    L5:
        if (i < 0) goto L10;
        if (this.mRestartingServices.get(i).restartTracker == r.restartTracker) goto L8;
        i = i - 1;
        goto L5
    L8:
        stillTracking = true;
    L10:
        if (stillTracking == true) goto L24;
        Object r1 = this.mAm.mProcessStats.mLock;
        monitor-enter(r1);
        r.restartTracker.setRestarting(false, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        r.restartTracker = null;
        return;
    L16:
        th = move-exception;
        throw th;
    L24:
        return;
    }

    void setServiceRestartBackoffEnabledLocked(String packageName, boolean enable, String reason) {
        if (enable == false) goto L4;
        removeServiceRestartBackoffEnabledLocked(packageName);
        return;
    L4:
        if (this.mRestartBackoffDisabledPackages.contains(packageName) == false) goto L6;
        return;
    L6:
        this.mRestartBackoffDisabledPackages.add(packageName);
        long now = SystemClock.uptimeMillis();
        int i = 0;
        int size = this.mRestartingServices.size();
    L7:
        if (i >= size) goto L23;
        ServiceRecord r = this.mRestartingServices.get(i);
        if (TextUtils.equals(r.packageName, packageName) == false) goto L14;
        long remaining = r.nextRestartTime - now;
        if (remaining <= this.mAm.mConstants.SERVICE_RESTART_DURATION) goto L13;
        r.restartDelay = this.mAm.mConstants.SERVICE_RESTART_DURATION;
        r.nextRestartTime = r.restartDelay + now;
        ActiveServices r1 = this;
        String reason2 = reason;
        r1.performScheduleRestartLocked(r, "Rescheduling", reason2, now);
    L15:
        Collections.sort(r1.mRestartingServices, new ActiveServices$$ExternalSyntheticLambda0());
        i = i + 1;
        reason = reason2;
        goto L7
    L13:
        r1 = this;
        reason2 = reason;
        goto L15
    L14:
        r1 = this;
        reason2 = reason;
        goto L15
    }

    private static /* synthetic */ int lambda$setServiceRestartBackoffEnabledLocked$0(ServiceRecord a, ServiceRecord b) {
        return (int) (a.nextRestartTime - b.nextRestartTime);
    }

    private void removeServiceRestartBackoffEnabledLocked(String packageName) {
        this.mRestartBackoffDisabledPackages.remove(packageName);
    }

    boolean isServiceRestartBackoffEnabledLocked(String packageName) {
        return !this.mRestartBackoffDisabledPackages.contains(packageName);
    }

    private String bringUpServiceLocked(ServiceRecord r, int intentFlags, boolean execInFg, boolean whileRestarting, boolean permissionsReviewRequired, boolean packageFrozen, boolean enqueueOomAdj, int serviceBindingOomAdjPolicy) throws TransactionTooLargeException {
    L6:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    L4:
        if (Trace.isTagEnabled(64) == false) goto L8;
        Trace.traceBegin(64, "bringUpServiceLocked: " + r.shortInstanceName);     // Catch: Throwable -> L6
    L8:
        String r0 = bringUpServiceInnerLocked(r, intentFlags, execInFg, whileRestarting, permissionsReviewRequired, packageFrozen, enqueueOomAdj, serviceBindingOomAdjPolicy);     // Catch: Throwable -> L6
        Trace.traceEnd(64);
        return r0;
    }

    private String bringUpServiceInnerLocked(ServiceRecord r, int intentFlags, boolean execInFg, boolean whileRestarting, boolean permissionsReviewRequired, boolean packageFrozen, boolean enqueueOomAdj, int serviceBindingOomAdjPolicy) throws TransactionTooLargeException {
        ServiceRecord r2 = r;
        if (r2.app == null) goto L15;
        boolean fromJob = false;
        if (r2.intent != null) goto L7;
    L9:
        IApplicationFreezer r11 = SysOptBridge.getFactory().getApplicationFreezer();
        ProcessRecord r12 = r2.app;
        IApplicationFreezer.UnfreezeReason r13 = IApplicationFreezer.UnfreezeReason.NEED_SERVICE;
        IApplicationFreezer.FreezeInfo r6 = new IApplicationFreezer.FreezeInfo();
        IApplicationFreezer.CallerInfo r9 = new IApplicationFreezer.CallerInfo().setUid(r2.mRecentCallingUid).setPackageName(r2.mRecentCallingPackage).setFg(execInFg);
        if (fromJob == false) goto L12;
        String r14 = "J";
    L13:
        r11.unfreezeAppIfNeededLocked(r12, r13, null, null, r6.setCallerInfo(r9.setType(r14).setAction(r2.name.flattenToShortString()).setExtraMsg("bringUpA")));
        goto L15
    L12:
        r14 = "S";
        goto L13
    L7:
        if (r2.intent.getIntent() == null) goto L9;
        fromJob = r2.intent.getIntent().getSmtEx().getSmtBooleanExtra("from_job", false);
        r2.intent.getIntent().getSmtEx().removeSmtExtra("from_job");
    L15:
        if (r2.app != null) goto L17;
    L20:
        if (whileRestarting == false) goto L22;
    L24:
        long startTimeNs = SystemClock.elapsedRealtimeNanos();
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L28;
        Slog.v("ActivityManager", "Bringing up " + r2 + " " + r2.intent + " fg=" + r2.fgRequired);
    L28:
        if (this.mRestartingServices.remove(r2) == false) goto L31;
        clearRestartingIfNeededLocked(r);
    L31:
        if (r2.delayed == true) goto L33;
    L36:
        String r10 = "Unable to launch app ";
        if (this.mAm.mUserController.hasStartedUserState(r2.userId) == true) goto L41;
        String msg = "Unable to launch app " + r2.appInfo.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + r2.appInfo.uid + " for service " + r2.intent.getIntent() + ": user " + r2.userId + " is stopped";
        Slog.w("ActivityManager", msg);
        bringDownServiceLocked(r2, enqueueOomAdj);
        return msg;
    L41:
        if (r2.appInfo.packageName.equals(r2.mRecentCallingPackage) == true) goto L228;
        if (r2.isNotAppComponentUsage == true) goto L228;
        this.mAm.mUsageStatsService.reportEvent(r2.packageName, r2.userId, 31);
    L228:
        String r18 = "J";
        this.mAm.mPackageManagerInt.notifyComponentUsed(r2.packageName, r2.userId, r2.mRecentCallingPackage, r2.toString());     // Catch: IllegalArgumentException -> L50
    L56:
        if ((r2.serviceInfo.flags & 2) == 0) goto L58;
        boolean r0 = true;
    L59:
        boolean isolated = r0;
        String procName = r2.processName;
        HostingRecord hostingRecord = new HostingRecord(HostingRecord.HOSTING_TYPE_SERVICE, r2.instanceName, r2.definingPackageName, r2.definingUid, r2.serviceInfo.processName, getHostingRecordTriggerType(r));
        if (isolated == true) goto L147;
        ProcessRecord app = this.mAm.getProcessRecordLocked(procName, r2.appInfo.uid);
        if (app != null) goto L74;
        boolean fromJob2 = false;
        if (r2.intent == null) goto L69;
        if (r2.intent.getIntent() == null) goto L69;
        fromJob2 = r2.intent.getIntent().getSmtEx().getSmtBooleanExtra("from_job", false);
        r2.intent.getIntent().getSmtEx().removeSmtExtra("from_job");
    L69:
        IApplicationFreezer r19 = SysOptBridge.getFactory().getApplicationFreezer();
        int r3 = r2.appInfo.uid;
        IApplicationFreezer.UnfreezeReason r23 = IApplicationFreezer.UnfreezeReason.NEED_SERVICE;
        IApplicationFreezer.FreezeInfo r5 = new IApplicationFreezer.FreezeInfo();
        IApplicationFreezer.CallerInfo r4 = new IApplicationFreezer.CallerInfo().setUid(r2.mRecentCallingUid).setPackageName(r2.mRecentCallingPackage).setFg(execInFg);
        if (fromJob2 == false) goto L72;
        String r15 = r18;
    L73:
        ProcessRecord app2 = r19.unfreezeAppIfNeededLocked(null, procName, r3, r23, null, null, r5.setCallerInfo(r4.setType(r15).setAction(r2.name.flattenToShortString()).setExtraMsg("bringUpB")));
        String procName2 = procName;
        Slog.i("AMS.Freeze", "unfreezeAppIfNeededLocked proc:" + app2 + " procName:" + procName2 + " reason: NEED_SERVICE, at bringUpServiceLocked");
        ProcessRecord app3 = app2;
    L76:
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L78;
        Slog.v(TAG_MU, "bringUpServiceLocked: appInfo.uid=" + r2.appInfo.uid + " app=" + app3);
    L78:
        if (app3 == null) goto L145;
        IApplicationThread thread = app3.getThread();
        int pid = app3.getPid();
        String r16 = SliceClientPermissions.SliceAuthority.DELIMITER;
        UidRecord uidRecord = app3.getUidRecord();
        if (app3.isThreadReady() == true) goto L243;
        hostingRecord = hostingRecord;
        r10 = "Unable to launch app ";
    L146:
        boolean r8 = enqueueOomAdj;
        HostingRecord hostingRecord2 = hostingRecord;
    L196:
        if (app3 != null) goto L211;
        if (permissionsReviewRequired == true) goto L211;
        if (packageFrozen == true) goto L211;
        if (r2.isSdkSandbox == false) goto L202;
        int uid = Process.toSdkSandboxUid(r2.sdkSandboxClientAppUid);
        ProcessRecord app4 = this.mAm.startSdkSandboxProcessLocked(procName2, r2.appInfo, true, intentFlags, hostingRecord2, 0, uid, r2.sdkSandboxClientAppPackage);
        r2.isolationHostProc = app4;
        ProcessRecord app5 = app4;
    L203:
        if (app5 != null) goto L206;
        String msg2 = r10 + r2.appInfo.packageName + r16 + r2.appInfo.uid + " for service " + r2.intent.getIntent() + ": process is bad";
        Slog.w("ActivityManager", msg2);
        bringDownServiceLocked(r2, r8);
        return msg2;
    L206:
        this.mAm.mProcessList.getAppStartInfoTracker().handleProcessServiceStart(startTimeNs, app5, r2);
        if (isolated == false) goto L211;
        r2.isolationHostProc = app5;
        goto L211
    L202:
        app5 = this.mAm.startProcessLocked(procName2, r2.appInfo, true, intentFlags, hostingRecord2, 0, false, isolated);
    L211:
        if (r2.fgRequired == false) goto L217;
        if (ActivityManagerDebugConfig.DEBUG_FOREGROUND_SERVICE == false) goto L215;
        Slog.v("ActivityManager", "Allowlisting " + UserHandle.formatUid(r2.appInfo.uid) + " for fg-service launch");
    L215:
        this.mAm.tempAllowlistUidLocked(r2.appInfo.uid, this.mAm.mConstants.mServiceStartForegroundTimeoutMs, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_SERVICE_LAUNCH, "fg-service-launch", 0, r2.mRecentCallingUid);
    L217:
        if (this.mPendingServices.contains(r2) == true) goto L220;
        this.mPendingServices.add(r2);
    L220:
        if (r2.delayedStop == false) goto L227;
        r2.delayedStop = false;
        if (r2.startRequested == false) goto L227;
        if (DEBUG_DELAYED_STARTS == false) goto L226;
        Slog.v("ActivityManager", "Applying delayed stop (in bring up): " + r2);
    L226:
        stopServiceLocked(r2, r8);
    L227:
        return null;
    L243:
        if (Trace.isTagEnabled(64) == false) goto L100;
        IApplicationThread thread2 = thread;
    L239:
        Trace.traceBegin(64, "realStartServiceLocked: " + r2.shortInstanceName);     // Catch: Throwable -> L88 RemoteException -> L90 TransactionTooLargeException -> L92
    L237:
    L241:
        app3.addPackage(r2.appInfo.packageName, r2.appInfo.longVersionCode, this.mAm.mProcessStats);     // Catch: Throwable -> L113 RemoteException -> L116 TransactionTooLargeException -> L119
        r2 = r;
        realStartServiceLocked(r2, app3, thread2, pid, uidRecord, execInFg, enqueueOomAdj, serviceBindingOomAdjPolicy);     // Catch: Throwable -> L107 RemoteException -> L109 TransactionTooLargeException -> L111
        Trace.traceEnd(64);
        return null;
    L111:
        e = move-exception;
        throw e;     // Catch: Throwable -> L135
    L109:
        e = e;
    L133:
        Slog.w("ActivityManager", "Exception when starting service " + r2.shortInstanceName, e);     // Catch: Throwable -> L135
        Trace.traceEnd(64);
    L107:
        e = th;
    L141:
        Trace.traceEnd(64);
        throw e;
    L119:
        e = e;
    L252:
        throw e;     // Catch: Throwable -> L135
    L116:
        e = e;
        r2 = r;
    L113:
        e = th;
    L126:
        e = e;
    L124:
        e = e;
    L122:
        e = th;
        goto L141
    L92:
        e = move-exception;
        throw e;     // Catch: Throwable -> L135
    L90:
        e = e;
    L88:
        e = th;
    L98:
        e = move-exception;
        throw e;     // Catch: Throwable -> L135
    L96:
        e = e;
    L94:
        e = th;
        goto L141
    L100:
        thread2 = thread;
        goto L237
    L137:
        e = move-exception;
        throw e;     // Catch: Throwable -> L135
    L130:
        e = e;
    L128:
        e = th;
    L135:
        e = th;
        goto L141
    L145:
        r16 = SliceClientPermissions.SliceAuthority.DELIMITER;
        hostingRecord = hostingRecord;
        r10 = "Unable to launch app ";
        goto L146
    L72:
        r15 = "S";
        goto L73
    L74:
        procName2 = procName;
        app3 = app;
        goto L76
    L147:
        procName2 = procName;
        r16 = SliceClientPermissions.SliceAuthority.DELIMITER;
        r10 = "Unable to launch app ";
        if (r2.inSharedIsolatedProcess == false) goto L186;
        app3 = this.mAm.mProcessList.getSharedIsolatedProcess(procName2, r2.appInfo.uid, r2.appInfo.packageName);
        if (app3 != null) goto L152;
    L185:
        r8 = enqueueOomAdj;
        app3 = null;
        hostingRecord2 = hostingRecord;
        goto L196
    L152:
        if (app3.isKilled() == true) goto L185;
        IApplicationThread thread3 = app3.getThread();
        int pid2 = app3.getPid();
        UidRecord uidRecord2 = app3.getUidRecord();
        r2.isolationHostProc = app3;
        if (app3.isThreadReady() == true) goto L233;
        r8 = enqueueOomAdj;
    L184:
        hostingRecord2 = hostingRecord;
        goto L196
    L233:
    L170:
        e = th;
    L181:
        Trace.traceEnd(64);
        throw e;
    L164:
        e = move-exception;
        throw e;     // Catch: Throwable -> L170
    L162:
        e = e;
        r8 = enqueueOomAdj;
    L177:
        Slog.w("ActivityManager", "Exception when starting service " + r2.shortInstanceName, e);     // Catch: Throwable -> L170
        Trace.traceEnd(64);
    L160:
        e = th;
        goto L181
    L157:
        if (Trace.isTagEnabled(64) == false) goto L166;
        Trace.traceBegin(64, "realStartServiceLocked: " + r2.shortInstanceName);     // Catch: Throwable -> L160 RemoteException -> L162 TransactionTooLargeException -> L164
    L166:
        r8 = enqueueOomAdj;
        realStartServiceLocked(r2, app3, thread3, pid2, uidRecord2, execInFg, r8, 0);     // Catch: Throwable -> L170 RemoteException -> L172 TransactionTooLargeException -> L174
        Trace.traceEnd(64);
        return null;
    L174:
        e = move-exception;
        throw e;     // Catch: Throwable -> L170
    L172:
        e = e;
        goto L177
    L186:
        r8 = enqueueOomAdj;
        app3 = r2.isolationHostProc;
        if (WebViewZygote.isMultiprocessEnabled() == true) goto L189;
    L191:
        HostingRecord hostingRecord3 = hostingRecord;
    L193:
        if ((r2.serviceInfo.flags & 8) == 0) goto L195;
        hostingRecord2 = HostingRecord.byAppZygote(r2.instanceName, r2.definingPackageName, r2.definingUid, r2.serviceInfo.processName);
        goto L196
    L195:
        hostingRecord2 = hostingRecord3;
        goto L196
    L189:
        if (r2.serviceInfo.packageName.equals(WebViewZygote.getPackageName()) == false) goto L191;
        hostingRecord3 = HostingRecord.byWebviewZygote(r2.instanceName, r2.definingPackageName, r2.definingUid, r2.serviceInfo.processName);
        goto L193
    L58:
        r0 = false;
    L50:
        e = e;
    L54:
        Slog.w("ActivityManager", "Failed trying to unstop package " + r2.packageName + ": " + e);
    L52:
        e = e;
        r18 = "J";
        goto L54
    L33:
        if (DEBUG_DELAYED_STARTS == false) goto L35;
        Slog.v("ActivityManager", "REM FR DELAY LIST (bring up): " + r2);
    L35:
        getServiceMapLocked(r2.userId).mDelayedStartList.remove(r2);
        r2.delayed = false;
        goto L36
    L22:
        if (this.mRestartingServices.contains(r2) == false) goto L24;
        return null;
    L17:
        if (r2.app.isThreadReady() == false) goto L20;
        r2.updateOomAdjSeq();
        sendServiceArgsLocked(r2, execInFg, false);
        return null;
    }

    private String getHostingRecordTriggerType(ServiceRecord r) {
        if ("android.permission.BIND_JOB_SERVICE".equals(r.permission) == true) goto L5;
        return "unknown";
    L5:
        if (r.mRecentCallingUid != 1000) goto L10;
        return HostingRecord.TRIGGER_TYPE_JOB;
    L10:
        return "unknown";
    }

    private void requestServiceBindingsLocked(ServiceRecord r, boolean execInFg, int serviceBindingOomAdjPolicy) throws TransactionTooLargeException {
        int i = r.bindings.size() - 1;
    L3:
        if (i < 0) goto L9;
        IntentBindRecord ibr = r.bindings.valueAt(i);
        ServiceRecord r2 = r;
        boolean execInFg2 = execInFg;
        int serviceBindingOomAdjPolicy2 = serviceBindingOomAdjPolicy;
        if (requestServiceBindingLocked(r2, ibr, execInFg2, false, serviceBindingOomAdjPolicy2) == false) goto L12;
        i = i - 1;
        r = r2;
        execInFg = execInFg2;
        serviceBindingOomAdjPolicy = serviceBindingOomAdjPolicy2;
        goto L3
    L12:
        return;
    }

    private int getServiceBindingOomAdjPolicyForAddLocked(ProcessRecord clientApp, ProcessRecord hostApp, ConnectionRecord cr) {
        int policy = 0;
        if (clientApp == null) goto L18;
        if (hostApp == null) goto L19;
        if (clientApp != hostApp) goto L8;
        policy = 7;
    L13:
        if ((policy & 4) == 0) goto L15;
        return policy;
    L15:
        if (this.mAm.mOomAdjuster.evaluateServiceConnectionAdd(clientApp, hostApp, cr) == true) goto L21;
        return 7;
    L21:
        return policy;
    L8:
        if (clientApp.isCached() == false) goto L13;
        policy = 7;
        if (clientApp.isFreezable() == false) goto L13;
        policy = 7 | 8;
        goto L13
    L19:
        return 0;
    L18:
        return 0;
    }

    private int getServiceBindingOomAdjPolicyForRemovalLocked(ProcessRecord clientApp, ProcessRecord hostApp, ConnectionRecord cr) {
        if (clientApp == null) goto L12;
        if (hostApp == null) goto L13;
        if (cr == null) goto L14;
        if (clientApp != hostApp) goto L9;
        return 7;
    L9:
        if (this.mAm.mOomAdjuster.evaluateServiceConnectionRemoval(clientApp, hostApp, cr) == true) goto L16;
        return 7;
    L16:
        return 0;
    L14:
        return 0;
    L13:
        return 0;
    L12:
        return 0;
    }

    private void realStartServiceLocked(ServiceRecord r, ProcessRecord app, IApplicationThread thread, int pid, UidRecord uidRecord, boolean execInFg, boolean enqueueOomAdj, int serviceBindingOomAdjPolicy) throws RemoteException {
        r = r;
        IApplicationThread r11 = thread;
        if (r11 == null) goto L213;
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L7;
        Slog.v(TAG_MU, "realStartServiceLocked, ServiceRecord.uid = " + r.appInfo.uid + ", ProcessRecord.uid = " + app.uid);
    L7:
        r.setProcess(app, thread, pid, uidRecord);
        long now = SystemClock.uptimeMillis();
        r.restartTime = now;
        this.mAm.mProcessStateController.setServiceLastActivityTime(r, now);
        if ((serviceBindingOomAdjPolicy & 1) == 0) goto L10;
        boolean skipOomAdj = true;
    L11:
        ProcessServiceRecord psr = app.mServices;
        boolean newService = this.mAm.mProcessStateController.startService(psr, r);
        bumpServiceExecutingLocked(r, execInFg, "create", 0, skipOomAdj);
        boolean skipOomAdj2 = skipOomAdj;
        this.mAm.updateLruProcessLocked(app, false, null);
        updateServiceForegroundLocked(psr, false);
        if (skipOomAdj2 == true) goto L14;
        this.mAm.enqueueOomAdjTargetLocked(app);
        r.updateOomAdjSeq();
        this.mAm.updateOomAdjPendingTargetsLocked(6);
    L14:
        boolean created = false;
    L24:
        e = e;
        r11 = null;
    L214:
        Slog.w("ActivityManager", "Application dead when creating service " + r);     // Catch: Throwable -> L146
        this.mAm.appDiedLocked(app, "Died when creating service");     // Catch: Throwable -> L146
        throw e;     // Catch: Throwable -> L146
    L146:
        e = th;
    L23:
        boolean created2 = created;
    L148:
        if (created2 == true) goto L162;
        boolean inDestroying = this.mDestroyingServices.contains(r);
        if (r.wasOomAdjUpdated() == false) goto L152;
        int r6 = 19;
    L153:
        serviceDoneExecutingLocked(r, inDestroying, inDestroying, false, r6);
        if (newService == false) goto L160;
        this.mAm.mProcessStateController.stopService(psr, r);
        r.app = r11;
        if (SERVICE_RESCHEDULE == false) goto L160;
        if (DEBUG_DELAYED_SERVICE == false) goto L160;
        Slog.w("ActivityManager", " Failed to create Service !!!! .This will introduce huge delay...  " + r.shortInstanceName + " in " + r.restartDelay + "ms");
    L160:
        if (inDestroying == true) goto L162;
        scheduleServiceRestartLocked(r, false);
        goto L162
    L152:
        r6 = 0;
    L162:
        throw e;
    L21:
        e = th;
        r11 = null;
        goto L23
    L16:
        if (LOG_SERVICE_START_STOP == false) goto L241;
        int lastPeriod = r.shortInstanceName.lastIndexOf(46);     // Catch: Throwable -> L40 DeadObjectException -> L42 FrozenObjectException -> L44
        if (lastPeriod < 0) goto L29;
        String nameTerm = r.shortInstanceName.substring(lastPeriod);     // Catch: Throwable -> L21 DeadObjectException -> L24 FrozenObjectException -> L26
    L30:
        goto L39
    L226:
        EventLogTags.writeAmCreateService(r.userId, System.identityHashCode(r), nameTerm, r.app.uid, pid);     // Catch: Throwable -> L34 DeadObjectException -> L36 FrozenObjectException -> L38
    L36:
        e = e;
    L37:
        r11 = null;
    L34:
        e = th;
    L35:
        created2 = false;
        r11 = null;
        goto L148
        goto L27
    L29:
        nameTerm = r.shortInstanceName;     // Catch: Throwable -> L40 DeadObjectException -> L42 FrozenObjectException -> L44
    L42:
        e = e;
    L40:
        e = th;
    L39:
        created2 = false;
        r11 = null;
    L164:
        if (created2 == true) goto L179;
        boolean inDestroying2 = this.mDestroyingServices.contains(r);
        if (r.wasOomAdjUpdated() == false) goto L168;
        int r7 = 19;
    L169:
        serviceDoneExecutingLocked(r, inDestroying2, inDestroying2, false, r7);
        if (newService == false) goto L176;
        this.mAm.mProcessStateController.stopService(psr, r);
        r.app = r11;
        if (SERVICE_RESCHEDULE == false) goto L176;
        if (DEBUG_DELAYED_SERVICE == false) goto L176;
        Slog.w("ActivityManager", " Failed to create Service !!!! .This will introduce huge delay...  " + r.shortInstanceName + " in " + r.restartDelay + "ms");
    L176:
        if (inDestroying2 == true) goto L179;
    L129:
        scheduleServiceRestartLocked(r, false);
        goto L179
    L168:
        r7 = 0;
    L179:
        if (r.allowlistManager == false) goto L181;
        boolean r3 = true;
        psr.mAllowlistManager = true;
    L182:
        requestServiceBindingsLocked(r, execInFg, serviceBindingOomAdjPolicy);
        updateServiceClientActivitiesLocked(psr, r11, r3);
        if (newService == false) goto L187;
        if (created2 == false) goto L187;
        psr.addBoundClientUidsOfNewService(r);
    L187:
        if (r.startRequested == false) goto L194;
        if (r.callStart == false) goto L194;
        if (r.pendingStarts.size() != 0) goto L194;
        ArrayList<ServiceRecord.StartItem> r12 = r.pendingStarts;
        ServiceRecord.StartItem r0 = new ServiceRecord.StartItem(r, false, r.makeNextStartId(), null, null, 0, null, null, -1);
        r = r;
        r12.add(r0);
    L194:
        sendServiceArgsLocked(r, execInFg, r.wasOomAdjUpdated());
        if (r.delayed == true) goto L197;
        boolean r4 = false;
    L202:
        if (r.delayedStop == false) goto L211;
        r.delayedStop = r4;
        if (r.startRequested == false) goto L247;
        if (DEBUG_DELAYED_STARTS == false) goto L208;
        Slog.v("ActivityManager", "Applying delayed stop (from start): " + r);
    L208:
        stopServiceLocked(r, enqueueOomAdj);
        return;
    L247:
        return;
    L211:
        return;
    L197:
        if (DEBUG_DELAYED_STARTS == false) goto L199;
        Slog.v("ActivityManager", "REM FR DELAY LIST (new proc): " + r);
    L199:
        getServiceMapLocked(r.userId).mDelayedStartList.remove(r);
        r4 = false;
        r.delayed = false;
        goto L202
    L181:
        r3 = true;
    L241:
        int uid = r.appInfo.uid;     // Catch: DeadObjectException -> L36 Throwable -> L139 FrozenObjectException -> L141
        String packageName = r.name.getPackageName();     // Catch: DeadObjectException -> L36 Throwable -> L139 FrozenObjectException -> L141
        String serviceName = r.name.getClassName();     // Catch: DeadObjectException -> L36 Throwable -> L139 FrozenObjectException -> L141
        FrameworkStatsLog.write(100, uid, packageName, serviceName);     // Catch: DeadObjectException -> L36 Throwable -> L139 FrozenObjectException -> L141
        this.mAm.mBatteryStatsService.noteServiceStartLaunch(uid, packageName, serviceName);     // Catch: DeadObjectException -> L36 Throwable -> L139 FrozenObjectException -> L141
        this.mAm.notifyPackageUse(r.serviceInfo.packageName, 1);     // Catch: DeadObjectException -> L36 Throwable -> L139 FrozenObjectException -> L141
        if (StabTrace.isEnable() == false) goto L51;
        long beginTime = Process.getCpuClocks();     // Catch: Throwable -> L34 DeadObjectException -> L36 FrozenObjectException -> L38
        long beginTime2 = beginTime;
    L52:
        r11 = null;
        r11.scheduleCreateService(r, r.serviceInfo, null, app.mState.getReportedProcState());     // Catch: DeadObjectException -> L61 Throwable -> L135 FrozenObjectException -> L137
        if (StabTrace.isEnable() == false) goto L68;
        StringBuilder sb = new StringBuilder(150);     // Catch: Throwable -> L59 DeadObjectException -> L61 FrozenObjectException -> L63
        sb.append("scheduleCreateService:pid=");     // Catch: Throwable -> L59 DeadObjectException -> L61 FrozenObjectException -> L63
        if (r.app == null) goto L65;
        Object r5 = Integer.valueOf(r.app.getPid());     // Catch: Throwable -> L59 DeadObjectException -> L61 FrozenObjectException -> L63
    L66:
        sb.append(r5);     // Catch: Throwable -> L59 DeadObjectException -> L61 FrozenObjectException -> L63
        sb.append("name=");     // Catch: Throwable -> L59 DeadObjectException -> L61 FrozenObjectException -> L63
        sb.append(r.name.getClassName());     // Catch: Throwable -> L59 DeadObjectException -> L61 FrozenObjectException -> L63
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());     // Catch: Throwable -> L59 DeadObjectException -> L61 FrozenObjectException -> L63
        goto L64
    L65:
        r5 = "0";
    L59:
        e = th;
        created2 = false;
        r11 = null;
    L64:
        created2 = false;
        r11 = null;
    L68:
        r.postNotification(false);     // Catch: DeadObjectException -> L61 Throwable -> L135 FrozenObjectException -> L137
        created2 = true;
        if (this.isLowRamDevice == false) goto L223;
        r11 = null;
    L116:
        if (1 != 0) goto L179;
        boolean inDestroying3 = this.mDestroyingServices.contains(r);
        if (r.wasOomAdjUpdated() == false) goto L120;
        int r8 = 19;
    L121:
        serviceDoneExecutingLocked(r, inDestroying3, inDestroying3, false, r8);
        if (newService == false) goto L128;
        this.mAm.mProcessStateController.stopService(psr, r);
        r.app = r11;
        if (SERVICE_RESCHEDULE == false) goto L128;
        if (DEBUG_DELAYED_SERVICE == false) goto L128;
        Slog.w("ActivityManager", " Failed to create Service !!!! .This will introduce huge delay...  " + r.shortInstanceName + " in " + r.restartDelay + "ms");
    L128:
        if (inDestroying3 == true) goto L179;
    L120:
        r8 = 0;
        goto L121
    L223:
    L235:
        if (getAIDLServicetrackerInstance() == true) goto L239;
        r11 = null;
        if (getServicetrackerInstance() == false) goto L234;
        vendor.qti.hardware.servicetracker.V1_0.ServiceData sData = new vendor.qti.hardware.servicetracker.V1_0.ServiceData();     // Catch: Throwable -> L77 RemoteException -> L79
        getServiceTrackerHidlData(sData, null, r, null, null, false);     // Catch: Throwable -> L98 RemoteException -> L100
        r = r;
        this.mServicetracker.startService(sData);     // Catch: Throwable -> L94 RemoteException -> L96
    L216:
    L96:
        e = e;
    L232:
        Slog.e("ActivityManager", "Failed to send start details to servicetracker HAL", e);     // Catch: Throwable -> L94 DeadObjectException -> L111 FrozenObjectException -> L113
        this.mServicetracker = r11;     // Catch: Throwable -> L94 DeadObjectException -> L111 FrozenObjectException -> L113
        this.mServicetracker_aidl = r11;     // Catch: Throwable -> L94 DeadObjectException -> L111 FrozenObjectException -> L113
    L111:
        e = e;
    L112:
        created = true;
        goto L214
    L100:
        e = e;
        r = r;
    L98:
        e = th;
        r = r;
    L234:
    L239:
        ServiceData sData2 = new ServiceData();     // Catch: Throwable -> L81 RemoteException -> L83
        r11 = null;
        getServiceTrackerAidlData(sData2, null, r, null, null, false);     // Catch: Throwable -> L77 RemoteException -> L79
        this.mServicetracker_aidl.startService(sData2);     // Catch: Throwable -> L77 RemoteException -> L79
        goto L234
    L83:
        e = e;
        r = r;
    L81:
        e = th;
        r11 = null;
    L78:
        r = r;
    L79:
        e = e;
        r = r;
    L77:
        e = th;
    L106:
        e = e;
    L94:
        e = th;
        goto L148
    L104:
        e = th;
        r11 = null;
    L131:
        e = e;
        r11 = null;
    L134:
        r11 = null;
        goto L164
    L61:
        e = e;
        r11 = null;
    L135:
        e = th;
        r11 = null;
    L138:
        r11 = null;
    L28:
        created2 = false;
        goto L164
        goto L142
        goto L39
    L51:
        beginTime2 = 0;
    L139:
        e = th;
        r11 = null;
    L142:
        r11 = null;
    L27:
        r11 = null;
        goto L28
    L10:
        skipOomAdj = false;
        goto L11
    L213:
        throw new RemoteException();
    }

    private final void sendServiceArgsLocked(ServiceRecord r, boolean execInFg, boolean oomAdjusted) throws TransactionTooLargeException {
        ServiceRecord r2 = r;
        int N = r2.pendingStarts.size();
        if (N != 0) goto L5;
        return;
    L5:
        ArrayList<ServiceStartArgs> args = new ArrayList();
    L7:
        if (r2.pendingStarts.size() <= 0) goto L39;
        ServiceRecord.StartItem si = r2.pendingStarts.remove(0);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L12;
        Slog.v("ActivityManager", "Sending arguments to: " + r2 + " " + r2.intent + " args=" + si.intent);
    L12:
        if (si.intent != null) goto L15;
        if (N > 1) goto L7;
    L15:
        si.deliveredTime = SystemClock.uptimeMillis();
        r2.deliveredStarts.add(si);
        si.deliveryCount++;
        if (si.neededGrants == null) goto L18;
        this.mAm.mUgmInternal.grantUriPermissionUncheckedFromIntent(si.neededGrants, si.getUriPermissionsLocked());
    L18:
        this.mAm.grantImplicitAccess(r2.userId, si.intent, si.callingId, UserHandle.getAppId(r2.appInfo.uid));
        bumpServiceExecutingLocked(r2, execInFg, IMediaProjectionManagerServiceExt.NODE_START, 0, false);
        if (r2.fgRequired == true) goto L21;
    L32:
        int flags = 0;
        if (si.deliveryCount <= 1) goto L36;
        flags = 0 | 2;
    L36:
        if (si.doneExecutingCount <= 0) goto L38;
        flags = flags | 1;
    L38:
        args.add(new ServiceStartArgs(si.taskRemoved, si.id, flags, si.intent));
        goto L7
    L21:
        if (r2.fgWaiting == true) goto L32;
        if (r2.isForeground == true) goto L29;
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L27;
        Slog.i("ActivityManager", "Launched service must call startForeground() within timeout: " + r2);
    L27:
        scheduleServiceForegroundTransitionTimeoutLocked(r);
        goto L32
    L29:
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L31;
        Slog.i("ActivityManager", "Service already foreground; no new timeout: " + r2);
    L31:
        r2.fgRequired = false;
        goto L32
    L39:
        if (oomAdjusted == true) goto L41;
        this.mAm.enqueueOomAdjTargetLocked(r2.app);
        this.mAm.updateOomAdjPendingTargetsLocked(6);
    L41:
        ParceledListSlice<ServiceStartArgs> slice = new ParceledListSlice(args);
        slice.setInlineCountLimit(4);
        if (StabTrace.isEnable() == false) goto L44;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L76:
        r2.app.getThread().scheduleServiceArgs(r2, slice);     // Catch: Exception -> L49 RemoteException -> L51 TransactionTooLargeException -> L53
        if (StabTrace.isEnable() == false) goto L55;
        StringBuilder sb = new StringBuilder(150);     // Catch: Exception -> L49 RemoteException -> L51 TransactionTooLargeException -> L53
        sb.append("scheduleServiceArg:pid=");     // Catch: Exception -> L49 RemoteException -> L51 TransactionTooLargeException -> L53
        sb.append(r2.app.getPid());     // Catch: Exception -> L49 RemoteException -> L51 TransactionTooLargeException -> L53
        sb.append("name=");     // Catch: Exception -> L49 RemoteException -> L51 TransactionTooLargeException -> L53
        sb.append(r2.name.getClassName());     // Catch: Exception -> L49 RemoteException -> L51 TransactionTooLargeException -> L53
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());     // Catch: Exception -> L49 RemoteException -> L51 TransactionTooLargeException -> L53
    L55:
        caughtException = null;
    L66:
        if (caughtException == null) goto L75;
        boolean inDestroying = this.mDestroyingServices.contains(r2);
        int size = args.size();
        int i = 0;
    L68:
        if (i >= size) goto L70;
        serviceDoneExecutingLocked(r2, inDestroying, inDestroying, true, 19);
        i = i + 1;
        r2 = r;
        goto L68
    L70:
        this.mAm.updateOomAdjPendingTargetsLocked(19);
        if ((caughtException instanceof TransactionTooLargeException) == true) goto L74;
        return;
    L74:
        throw ((TransactionTooLargeException) caughtException);
    L75:
        return;
    L53:
        caughtException = e;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L65;
        Slog.v("ActivityManager", "Transaction too large for " + args.size() + " args, first: " + args.get(0).args);
    L65:
        Slog.w("ActivityManager", "Failed delivering service starts", caughtException);
    L51:
        caughtException = e;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L60;
        Slog.v("ActivityManager", "Crashed while sending args: " + r2);
    L60:
        Slog.w("ActivityManager", "Failed delivering service starts", caughtException);
    L49:
        caughtException = e;
        Slog.w("ActivityManager", "Unexpected exception", caughtException);
        goto L66
    L44:
        beginTime2 = 0;
        goto L76
    }

    private final boolean isServiceNeededLocked(ServiceRecord r, boolean knowConn, boolean hasConn) {
        if (r.startRequested == false) goto L5;
        return true;
    L5:
        if (knowConn == true) goto L7;
        hasConn = r.hasAutoCreateConnections();
    L7:
        if (hasConn == false) goto L9;
        return true;
    L9:
        return false;
    }

    private void bringDownServiceIfNeededLocked(ServiceRecord r, boolean knowConn, boolean hasConn, boolean enqueueOomAdj, String debugReason) {
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L6;
        Slog.i("ActivityManager", "Bring down service for " + debugReason + " :" + r.toString());
    L6:
        if (isServiceNeededLocked(r, knowConn, hasConn) == false) goto L9;
        return;
    L9:
        if (this.mPendingServices.contains(r) == false) goto L11;
        return;
    L11:
        bringDownServiceLocked(r, enqueueOomAdj);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private boolean bringDownServiceLocked(ServiceRecord r, boolean enqueueOomAdj) {
        final ServiceRecord r2 = r;
        if (r2.app != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean freezing = r0;
        if (this.isLowRamDevice == true) goto L31;
    L23:
        e = e;
    L29:
        Slog.e("ActivityManager", "Failed to send destroy details to servicetracker HAL", e);
        this.mServicetracker = null;
        this.mServicetracker_aidl = null;
        goto L31
    L280:
        if (getAIDLServicetrackerInstance() == false) goto L16;
        ServiceData sData = new ServiceData();     // Catch: RemoteException -> L13
        getServiceTrackerAidlData(sData, null, r2, null, null, false);     // Catch: RemoteException -> L13
        this.mServicetracker_aidl.destroyService(sData);     // Catch: RemoteException -> L13
        r2 = r;
    L279:
        goto L31
    L16:
        if (getServicetrackerInstance() == false) goto L27;
        vendor.qti.hardware.servicetracker.V1_0.ServiceData sData2 = new vendor.qti.hardware.servicetracker.V1_0.ServiceData();     // Catch: RemoteException -> L13
        getServiceTrackerHidlData(sData2, null, r, null, null, false);     // Catch: RemoteException -> L25
        r2 = r;
        this.mServicetracker.destroyService(sData2);     // Catch: RemoteException -> L23
    L25:
        e = e;
        r2 = r;
        goto L29
    L27:
        r2 = r;
    L13:
        e = e;
        r2 = r;
    L31:
        if (r2.isShortFgs() == false) goto L33;
        Slog.w("ActivityManager", "Short FGS brought down without stopping: " + r2);
        maybeStopShortFgsTimeoutLocked(r);
    L33:
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections = r2.getConnections();
        int conni = connections.size() - 1;
    L34:
        if (conni < 0) goto L62;
        ArrayList<ConnectionRecord> c = connections.valueAt(conni);
        int i = c.size() - 1;
    L36:
        if (i < 0) goto L58;
        ConnectionRecord cr = c.get(i);
        if (freezing == true) goto L40;
    L43:
        cr.serviceDead = true;
        cr.stopAssociation();
        if (cr.aliasComponent == null) goto L46;
        ComponentName r1 = cr.aliasComponent;
    L47:
        ComponentName clientSideComponentName = r1;
        c.remove(i);     // Catch: Exception -> L50 FrozenObjectException -> L52
        notifyServiceUnboundLocked(cr.binding.client, r2, cr.binding);     // Catch: Exception -> L50 FrozenObjectException -> L52
        cr.conn.connected(clientSideComponentName, null, true);     // Catch: Exception -> L50 FrozenObjectException -> L52
    L50:
        e = move-exception;
        Slog.w("ActivityManager", "Failure disconnecting service " + r2.shortInstanceName + " to connection " + cr.conn.asBinder() + " (in " + cr.binding.client.processName + ")", e);
    L56:
        i = i - 1;
        goto L36
    L46:
        r1 = r2.name;
        goto L47
    L40:
        if (cr.binding.client.info.uid != r2.app.info.uid) goto L43;
        Slog.i("ActivityManager", "freeze: service: " + r2.name + " has self connection bind=" + cr.binding.client + ", info.uid=" + cr.binding.client.info.uid + " r.app=" + r2.app + ", so keep it");
        goto L56
    L58:
        if (c.size() != 0) goto L60;
        connections.removeAt(conni);
    L60:
        conni = conni - 1;
        goto L34
    L62:
        if (r2.wasOomAdjUpdated() == false) goto L64;
        boolean oomAdjusted = true;
    L66:
        if (r2.app != null) goto L68;
    L108:
        boolean keepBinding = oomAdjusted;
    L109:
        boolean oomAdjusted2 = r2.fgRequired;
        if (oomAdjusted2 == false) goto L124;
        Slog.w("ActivityManager", "Bringing down service while still waiting for start foreground: " + r2);
        r2.fgRequired = false;
        r2.fgWaiting = false;
        Object r3 = this.mAm.mProcessStats.mLock;
        monitor-enter(r3);
        ServiceState stracker = r2.getTracker();     // Catch: Throwable -> L116
        if (stracker == null) goto L118;
        stracker.setForeground(false, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L116
    L118:
        monitor-exit(r3);     // Catch: Throwable -> L116
        this.mAm.mAppOpsService.finishOperation(AppOpsManager.getToken(this.mAm.mAppOpsService), 76, r2.appInfo.uid, r2.packageName, null);
        this.mServiceFGAnrTimer.cancel(r2);
        if (r2.app == null) goto L124;
        Message msg = this.mAm.mHandler.obtainMessage(69);
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = r2.app;
        args.arg2 = r2.toString();
        args.arg3 = r2.getComponentName();
        msg.obj = args;
        this.mAm.mHandler.sendMessage(msg);
    L116:
        th = move-exception;
        throw th;
    L124:
        ServiceMap smap = getServiceMapLocked(r2.userId);
        if (freezing == false) goto L127;
    L143:
        unscheduleServiceRestartLocked(r2, 0, true);
        int i2 = this.mPendingServices.size() - 1;
    L144:
        if (i2 < 0) goto L152;
        if (this.mPendingServices.get(i2) != r2) goto L150;
        this.mPendingServices.remove(i2);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L150;
        Slog.v("ActivityManager", "Removed pending: " + r2);
    L150:
        i2 = i2 - 1;
        goto L144
    L152:
        if (this.mPendingBringups.remove(r2) != null) goto L154;
    L156:
        if (freezing == true) goto L258;
        cancelForegroundNotificationLocked(r);
        boolean exitingFg = r2.isForeground;
        if (exitingFg == false) goto L186;
        maybeStopShortFgsTimeoutLocked(r);
        decActiveForegroundAppLocked(smap, r2);
        Object r5 = this.mAm.mProcessStats.mLock;
        monitor-enter(r5);
        ServiceState stracker2 = r2.getTracker();     // Catch: Throwable -> L180
        if (stracker2 != null) goto L275;
    L167:
        monitor-exit(r5);     // Catch: Throwable -> L180
        this.mAm.mAppOpsService.finishOperation(AppOpsManager.getToken(this.mAm.mAppOpsService), 76, r2.appInfo.uid, r2.packageName, null);
        unregisterAppOpCallbackLocked(r);
        r2.mFgsExitTime = SystemClock.uptimeMillis();
        if (r2.mFgsExitTime <= r2.mFgsEnterTime) goto L171;
        int r4 = (int) (r2.mFgsExitTime - r2.mFgsEnterTime);
    L172:
        ServiceMap smap2 = smap;
        logFGSStateChangeLocked(r2, 2, r4, 2, 0, 0, false);
        ForegroundServiceTypeLoggerModule r6 = this.mFGSLogger;
        monitor-enter(r6);
        this.mFGSLogger.logForegroundServiceStop(r2.appInfo.uid, r2);     // Catch: Throwable -> L177
        monitor-exit(r6);     // Catch: Throwable -> L177
        this.mAm.updateForegroundServiceUsageStats(r2.name, r2.userId, false);
    L187:
        this.mAm.mProcessStateController.setIsForegroundService(r2, false);
        r2.mFgsNotificationWasDeferred = false;
        dropFgsNotificationStateLocked(r);
        r2.foregroundId = 0;
        r2.foregroundNoti = null;
        resetFgsRestrictionLocked(r);
        if (exitingFg == false) goto L190;
        signalForegroundServiceObserversLocked(r);
    L190:
        r2.clearDeliveredStartsLocked();
        r2.pendingStarts.clear();
        smap2.mDelayedStartList.remove(r2);
        if (r2.app == null) goto L231;
        this.mAm.mBatteryStatsService.noteServiceStopLaunch(r2.appInfo.uid, r2.name.getPackageName(), r2.name.getClassName());
        stopServiceAndUpdateAllowlistManagerLocked(r);
        if (r2.app.isThreadReady() == false) goto L228;
        this.mAm.updateLruProcessLocked(r2.app, false, null);
        updateServiceForegroundLocked(r2.app.mServices, false);
        if (r2.mIsFgsDelegate == false) goto L207;
        if (r2.mFgsDelegation.mConnection == null) goto L199;
        this.mAm.mHandler.post(new ActiveServices$$ExternalSyntheticLambda6(r2));
    L199:
        int i3 = this.mFgsDelegations.size() - 1;
    L200:
        if (i3 < 0) goto L205;
        if (this.mFgsDelegations.valueAt(i3) == r2) goto L203;
        i3 = i3 - 1;
        goto L200
    L203:
        this.mFgsDelegations.removeAt(i3);
    L205:
        boolean oomAdjusted3 = keepBinding;
    L234:
        boolean oomAdjusted4 = oomAdjusted3;
    L235:
        if (oomAdjusted4 == true) goto L240;
        this.mAm.enqueueOomAdjTargetLocked(r2.app);
        if (enqueueOomAdj == true) goto L240;
        this.mAm.updateOomAdjPendingTargetsLocked(19);
    L240:
        if (r2.bindings.size() <= 0) goto L243;
        r2.bindings.clear();
    L243:
        if ((r2.restarter instanceof ServiceRestarter) == false) goto L245;
        ((ServiceRestarter) r2.restarter).setService(null);
    L245:
        Object r7 = this.mAm.mProcessStats.mLock;
        monitor-enter(r7);
        int memFactor = this.mAm.mProcessStats.getMemFactorLocked();     // Catch: Throwable -> L252
        if (r2.tracker == null) goto L254;
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L252
        r2.tracker.setStarted(false, memFactor, now);     // Catch: Throwable -> L252
        r2.tracker.setBound(false, memFactor, now);     // Catch: Throwable -> L252
        if (r2.executeNesting != 0) goto L254;
        r2.tracker.clearCurrentOwner(r2, false);     // Catch: Throwable -> L252
        r2.tracker = null;     // Catch: Throwable -> L252
    L254:
        monitor-exit(r7);     // Catch: Throwable -> L252
    L259:
        smap2.ensureNotStartingBackgroundLocked(r2);
        updateNumForegroundServicesLocked();
        return true;
    L252:
        th = move-exception;
        throw th;
    L207:
        if (keepBinding == false) goto L209;
        int r8 = 0;
    L210:
        boolean oomAdjusted5 = keepBinding;
        bumpServiceExecutingLocked(r2, false, "destroy", r8, oomAdjusted5);     // Catch: Exception -> L223
        this.mDestroyingServices.add(r2);     // Catch: Exception -> L223
        oomAdjusted4 = oomAdjusted5 | r2.wasOomAdjUpdated();
        r2.destroying = true;     // Catch: Exception -> L216
        if (StabTrace.isEnable() == false) goto L218;
        long beginTime = Process.getCpuClocks();     // Catch: Exception -> L216
        long beginTime2 = beginTime;
    L219:
        r2.app.getThread().scheduleStopService(r2);     // Catch: Exception -> L216
        if (StabTrace.isEnable() == false) goto L235;
        StringBuilder sb = new StringBuilder(150);     // Catch: Exception -> L216
        sb.append("scheduleStopService:pid=");     // Catch: Exception -> L216
        sb.append(r2.app.getPid());     // Catch: Exception -> L216
        sb.append("name=");     // Catch: Exception -> L216
        sb.append(r2.name.getClassName());     // Catch: Exception -> L216
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());     // Catch: Exception -> L216
        goto L235
    L218:
        beginTime2 = 0;
    L216:
        e = e;
    L227:
        Slog.w("ActivityManager", "Exception when destroying service " + r2.shortInstanceName, e);
        serviceProcessGoneLocked(r, enqueueOomAdj);
    L223:
        e = e;
        oomAdjusted4 = oomAdjusted5;
        goto L227
    L209:
        r8 = 5;
        goto L210
    L228:
        oomAdjusted3 = keepBinding;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L234;
        Slog.v("ActivityManager", "Removed service that has no process: " + r2);
        goto L234
    L231:
        oomAdjusted3 = keepBinding;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L234;
        Slog.v("ActivityManager", "Removed service that is not running: " + r2);
    L177:
        th = move-exception;
        throw th;
    L171:
        r4 = 0;
        goto L172
    L275:
        stracker2.setForeground(false, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L165
    L165:
        th = th;
    L269:
        monitor-exit(r5);     // Catch: Throwable -> L184
        throw th;
    L184:
        th = th;
    L180:
        th = th;
        goto L269
    L186:
        smap2 = smap;
        goto L187
    L258:
        smap2 = smap;
        goto L259
    L154:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L156;
        Slog.v("ActivityManager", "Removed pending bringup: " + r2);
        goto L156
    L127:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L129;
        RuntimeException here = new RuntimeException();
        here.fillInStackTrace();
        Slog.v("ActivityManager", "Bringing down " + r2 + " " + r2.intent, here);
    L129:
        r2.destroyTime = SystemClock.uptimeMillis();
        if (LOG_SERVICE_START_STOP == false) goto L136;
        int r9 = r2.userId;
        int r10 = System.identityHashCode(r2);
        if (r2.app == null) goto L134;
        int r11 = r2.app.getPid();
    L135:
        EventLogTags.writeAmDestroyService(r9, r10, r11);
        goto L136
    L134:
        r11 = -1;
    L136:
        ServiceRecord found = smap.mServicesByInstanceName.remove(r2.instanceName);
        if (found == null) goto L142;
        if (found == r2) goto L142;
        smap.mServicesByInstanceName.put(r2.instanceName, found);
        throw new IllegalStateException("Bringing down " + r2 + " but actually running " + found);
    L142:
        smap.mServicesByIntent.remove(r2.intent);
        r2.totalRestartCount = 0;
        goto L143
    L68:
        if (r2.app.isThreadReady() == false) goto L108;
        boolean oomAdjusted6 = oomAdjusted;
        int i4 = r2.bindings.size() - 1;
    L70:
        if (i4 < 0) goto L107;
        IntentBindRecord ibr = r2.bindings.valueAt(i4);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L75;
        Slog.v("ActivityManager", "Bringing down binding " + ibr + ": hasBound=" + ibr.hasBound);
    L75:
        if (ibr.hasBound == false) goto L106;
        if (freezing == false) goto L84;
        int j = ibr.apps.size() - 1;
    L79:
        if (j < 0) goto L84;
        ProcessRecord app = ibr.apps.keyAt(j);
        if (app.info.uid == r2.app.info.uid) goto L82;
        j = j - 1;
        goto L79
    L82:
        boolean keepBinding2 = true;
    L85:
        if (keepBinding2 == true) goto L106;
        r2.bindings.remove(Integer.valueOf(i4));
        if (oomAdjusted6 == false) goto L90;
        int r12 = 0;
    L271:
        bumpServiceExecutingLocked(r2, false, "bring down unbind", r12, oomAdjusted6);     // Catch: Exception -> L103
        boolean oomAdjusted7 = oomAdjusted6 | r2.wasOomAdjUpdated();
        ibr.hasBound = false;     // Catch: Exception -> L96
        ibr.requested = false;     // Catch: Exception -> L96
        if (StabTrace.isEnable() == false) goto L98;
        long beginTime3 = Process.getCpuClocks();     // Catch: Exception -> L96
        long beginTime4 = beginTime3;
    L99:
        r2.app.getThread().scheduleUnbindService(r2, ibr.intent.getIntent());     // Catch: Exception -> L96
        if (StabTrace.isEnable() == false) goto L102;
        StringBuilder sb2 = new StringBuilder(150);     // Catch: Exception -> L96
        sb2.append("scheduleUnBindService:pid=");     // Catch: Exception -> L96
        sb2.append(r2.app.getPid());     // Catch: Exception -> L96
        sb2.append("name=");     // Catch: Exception -> L96
        sb2.append(r2.name.getClassName());     // Catch: Exception -> L96
        StabTrace.traceInfo(8, sb2.toString(), beginTime4, Process.getCpuClocks());     // Catch: Exception -> L96
    L102:
        oomAdjusted6 = oomAdjusted7;
        goto L106
    L98:
        beginTime4 = 0;
    L96:
        e = e;
    L105:
        Slog.w("ActivityManager", "Exception when unbinding service " + r2.shortInstanceName, e);
        serviceProcessGoneLocked(r, enqueueOomAdj);
        keepBinding = oomAdjusted7;
    L103:
        e = e;
        oomAdjusted7 = oomAdjusted6;
        goto L105
    L90:
        r12 = 5;
    L84:
        keepBinding2 = false;
    L106:
        i4 = i4 - 1;
        goto L70
    L107:
        keepBinding = oomAdjusted6;
        goto L109
    L64:
        oomAdjusted = false;
        goto L66
    L5:
        if (r2.app.getSmtEx().isFreezing() == false) goto L7;
        r0 = true;
        goto L8
    }

    private static /* synthetic */ void lambda$bringDownServiceLocked$1(ServiceRecord r) {
        r.mFgsDelegation.mConnection.onServiceDisconnected(r.mFgsDelegation.mOptions.getComponentName());
    }

    private void dropFgsNotificationStateLocked(ServiceRecord r) {
        if (r.foregroundNoti != null) goto L5;
        return;
    L5:
        boolean shared = false;
        ServiceMap smap = this.mServiceMap.get(r.userId);
        if (smap == null) goto L21;
        int numServices = smap.mServicesByInstanceName.size();
        int i = 0;
    L8:
        if (i >= numServices) goto L22;
        ServiceRecord sr = smap.mServicesByInstanceName.valueAt(i);
        if (sr == r) goto L19;
        if (sr.isForeground == false) goto L19;
        if (r.foregroundId != sr.foregroundId) goto L19;
        if (r.appInfo.packageName.equals(sr.appInfo.packageName) == false) goto L19;
        shared = true;
    L19:
        i = i + 1;
    L22:
        if (shared == true) goto L31;
        r.stripForegroundServiceFlagFromNotification();
        return;
    L31:
        return;
    L21:
        Slog.wtf("ActivityManager", "FGS " + r + " not found!");
        goto L22
    }

    int removeConnectionLocked(ConnectionRecord c, ProcessRecord skipApp, ActivityServiceConnectionsHolder skipAct, boolean enqueueOomAdj) {
        IBinder binder = c.conn.asBinder();
        AppBindRecord b = c.binding;
        ServiceRecord s = b.service;
        ArrayList<ConnectionRecord> clist = s.getConnections().get(binder);
        if (clist != null) goto L5;
    L10:
        b.connections.remove(c);
        c.stopAssociation();
        if (c.activity == null) goto L17;
        if (c.activity == skipAct) goto L17;
        c.activity.removeConnection(c);
    L17:
        if (b.client == skipApp) goto L40;
        ProcessServiceRecord psr = b.client.mServices;
        this.mAm.mProcessStateController.removeConnection(psr, c);
        if (s.appInfo.uid == b.client.uid) goto L22;
        SysOptBridge.getFactory().getFreezeController().clientConnectionRemoveEvent(s.appInfo.uid, b.client.uid);
    L22:
        if (c.hasFlag(8) == false) goto L25;
        this.mAm.mProcessStateController.updateHasAboveClientLocked(psr);
    L25:
        if (c.hasFlag(16777216) == false) goto L32;
        s.updateAllowlistManager();
        if (s.allowlistManager == true) goto L32;
        if (s.app == null) goto L32;
        updateAllowlistManagerLocked(s.app.mServices);
    L32:
        if (c.hasFlag(1048576) == false) goto L35;
        s.updateIsAllowedBgActivityStartsByBinding();
    L35:
        if (c.hasFlag(65536) == false) goto L38;
        this.mAm.mProcessStateController.updateHasTopStartedAlmostPerceptibleServices(psr);
    L38:
        if (s.app == null) goto L40;
        updateServiceClientActivitiesLocked(s.app.mServices, c, true);
    L40:
        ArrayList<ConnectionRecord> clist2 = this.mServiceConnections.get(binder);
        if (clist2 == null) goto L45;
        clist2.remove(c);
        if (clist2.size() != 0) goto L45;
        this.mServiceConnections.remove(binder);
    L45:
        this.mAm.stopAssociationLocked(b.client.uid, b.client.processName, s.appInfo.uid, s.appInfo.longVersionCode, s.instanceName, s.processName);
        if (b.connections.size() != 0) goto L49;
        b.intent.apps.remove(b.client);
    L49:
        if (c.serviceDead == true) goto L112;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L54;
        Slog.v("ActivityManager", "Disconnecting binding " + b.intent + ": shouldUnbind=" + b.intent.hasBound);
    L54:
        if (s.app != null) goto L56;
    L87:
        boolean r5 = enqueueOomAdj;
        int serviceBindingOomAdjPolicy = 0;
    L89:
        if (s.getConnections().isEmpty() == false) goto L96;
        if (s.startRequested == true) goto L96;
        this.mPendingServices.remove(s);
        this.mPendingBringups.remove(s);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L96;
        Slog.v("ActivityManager", "Removed pending service: " + s);
    L96:
        if (c.hasFlag(1) == false) goto L117;
        boolean hasAutoCreate = s.hasAutoCreateConnections();
        if (hasAutoCreate == false) goto L100;
    L109:
        bringDownServiceIfNeededLocked(s, true, hasAutoCreate, r5, "removeConnection");
        goto L117
    L100:
        if (s.tracker == null) goto L109;
        Object r3 = this.mAm.mProcessStats.mLock;
        monitor-enter(r3);
        s.tracker.setBound(false, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L106
        monitor-exit(r3);     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        throw th;
    L117:
        return serviceBindingOomAdjPolicy;
    L56:
        if (s.app.isThreadReady() == false) goto L87;
        if (b.intent.apps.size() != 0) goto L87;
        if (b.intent.hasBound == false) goto L87;
        serviceBindingOomAdjPolicy = getServiceBindingOomAdjPolicyForRemovalLocked(b.client, s.app, c);
        if ((serviceBindingOomAdjPolicy & 4) == 0) goto L64;
        boolean skipOomAdj = true;
    L66:
        if (skipOomAdj == false) goto L68;
        int r6 = 0;
    L113:
        bumpServiceExecutingLocked(s, false, "unbind", r6, skipOomAdj);     // Catch: Exception -> L76
        if (b.client != s.app) goto L72;
    L78:
        b.intent.hasBound = false;     // Catch: Exception -> L76
        b.intent.doRebind = false;     // Catch: Exception -> L76
        if (StabTrace.isEnable() == false) goto L81;
        long beginTime = Process.getCpuClocks();     // Catch: Exception -> L76
        long beginTime2 = beginTime;
    L82:
        s.app.getThread().scheduleUnbindService(s, b.intent.intent.getIntent());     // Catch: Exception -> L76
        if (StabTrace.isEnable() == false) goto L85;
        StringBuilder sb = new StringBuilder(150);     // Catch: Exception -> L76
        sb.append("scheduleUnbindService2:pid=");     // Catch: Exception -> L76
        sb.append(s.app.getPid());     // Catch: Exception -> L76
        sb.append("name=");     // Catch: Exception -> L76
        sb.append(s.name.getClassName());     // Catch: Exception -> L76
        StabTrace.traceInfo(1, sb.toString(), beginTime2, Process.getCpuClocks());     // Catch: Exception -> L76
    L85:
        r5 = enqueueOomAdj;
        goto L89
    L81:
        beginTime2 = 0;
        goto L82
    L72:
        if (c.notHasFlag(32) == false) goto L78;
        if (s.app.mState.getSetProcState() > 13) goto L78;
        this.mAm.updateLruProcessLocked(s.app, false, null);     // Catch: Exception -> L76
    L76:
        e = move-exception;
        Slog.w("ActivityManager", "Exception when unbinding service " + s.shortInstanceName, e);
        r5 = enqueueOomAdj;
        serviceProcessGoneLocked(s, r5);
        goto L89
    L68:
        r6 = 5;
        goto L113
    L64:
        skipOomAdj = false;
        goto L66
    L112:
        return 0;
    L5:
        if (clist.remove(c) == false) goto L8;
        notifyServiceUnboundLocked(b.client, s, b);
    L8:
        if (clist.size() != 0) goto L10;
        s.removeConnection(binder);
        goto L10
    }

    void serviceDoneExecutingLocked(ServiceRecord r, int type, int startId, int res, boolean enqueueOomAdj, Intent intent) {
        boolean inDestroying = this.mDestroyingServices.contains(r);
        if (r == null) goto L41;
        int r2 = 0;
        if (type != 1) goto L23;
        r.callStart = true;
        if (res == 1000) goto L9;
        r.startCommandResult = res;
    L9:
        switch(res) {
            case 0: goto L19;
            case 1: goto L19;
            case 2: goto L16;
            case 3: goto L13;
            case 1000: goto L12;
            default: goto L11;
        };
    L12:
        r.findDeliveredStart(startId, true, true);
    L20:
        if (res != 0) goto L32;
        r.callStart = false;
    L32:
        boolean needOomAdj = false;
    L33:
        long origId = this.mAm.mInjector.clearCallingIdentity();
        if (r.wasOomAdjUpdated() == true) goto L39;
        if (needOomAdj == true) goto L39;
    L40:
        serviceDoneExecutingLocked(r, inDestroying, inDestroying, enqueueOomAdj, r2);
        this.mAm.mInjector.restoreCallingIdentity(origId);
        return;
    L39:
        r2 = 20;
        goto L40
    L13:
        ServiceRecord.StartItem si = r.findDeliveredStart(startId, false, false);
        if (si == null) goto L20;
        si.deliveryCount = 0;
        si.doneExecutingCount++;
        r.stopIfKilled = true;
        goto L20
    L16:
        r.findDeliveredStart(startId, false, true);
        if (r.getLastStartId() != startId) goto L20;
        r.stopIfKilled = true;
        goto L20
    L19:
        r.findDeliveredStart(startId, false, true);
        r.stopIfKilled = false;
        goto L20
    L11:
        throw new IllegalArgumentException("Unknown service start result: " + res);
    L23:
        if (type != 2) goto L32;
        if (inDestroying == true) goto L29;
        if (r.app == null) goto L31;
        Slog.w("ActivityManager", "Service done with onDestroy, but not inDestroying: " + r + ", app=" + r.app);
    L31:
        needOomAdj = true;
        goto L33
    L29:
        if (r.executeNesting == 1) goto L31;
        Slog.w("ActivityManager", "Service done with onDestroy, but executeNesting=" + r.executeNesting + ": " + r);
        r.executeNesting = 1;
        goto L31
    L41:
        Slog.w("ActivityManager", "Done executing unknown service from pid " + this.mAm.mInjector.getCallingPid());
    }

    private void serviceProcessGoneLocked(ServiceRecord r, boolean enqueueOomAdj) {
        if (r.tracker == null) goto L12;
        Object r1 = this.mAm.mProcessStats.mLock;
        monitor-enter(r1);
        int memFactor = this.mAm.mProcessStats.getMemFactorLocked();     // Catch: Throwable -> L9
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        r.tracker.setExecuting(false, memFactor, now);     // Catch: Throwable -> L9
        r.tracker.setForeground(false, memFactor, now);     // Catch: Throwable -> L9
        r.tracker.setBound(false, memFactor, now);     // Catch: Throwable -> L9
        r.tracker.setStarted(false, memFactor, now);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        serviceDoneExecutingLocked(r, true, true, enqueueOomAdj, 12);
    }

    private void serviceDoneExecutingLocked(ServiceRecord r, boolean inDestroying, boolean finishing, boolean enqueueOomAdj, int oomAdjReason) {
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L6;
        Slog.v("ActivityManager", "<<< DONE EXECUTING " + r + ": nesting=" + r.executeNesting + ", inDestroying=" + inDestroying + ", app=" + r.app);
    L9:
        if (StabTrace.isEnable() == false) goto L11;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L12:
        r.executeNesting--;
        if (r.executeNesting > 0) goto L84;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().cancelService(r);
        if (r.app == null) goto L63;
        ProcessServiceRecord psr = r.app.mServices;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L19;
        Slog.v("ActivityManager", "Nesting at 0 of " + r.shortInstanceName);
    L19:
        this.mAm.mProcessStateController.setExecServicesFg(psr, false);
        this.mAm.mProcessStateController.stopExecutingService(psr, r);
        if (psr.numberOfExecutingServices() != 0) goto L46;
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L24;
    L25:
        Slog.v("ActivityManager", "No more executingServices of " + r.shortInstanceName);
    L27:
        if (r.app.mPid == 0) goto L30;
        this.mActiveServiceAnrTimer.cancel(r.app);
    L30:
        if (r.app.mPid == 0) goto L43;
        long now = SystemClock.uptimeMillis();
        boolean bRecord = false;
        long duration = now - r.executingStart;
        if (r.isForeground == false) goto L37;
        if (duration <= 100) goto L39;
        bRecord = true;
    L39:
        if (bRecord != true) goto L43;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().updateServiceRecordData(r.packageName, r.shortInstanceName, r.processName, r.createRealTime, r.executingStart, duration, now, System.currentTimeMillis(), r.isForeground);
        goto L43
    L37:
        if (duration <= 1000) goto L39;
        bRecord = true;
    L43:
        if (r.app == null) goto L53;
        SysOptBridge.getFactory().getFreezeController().bumpServiceEvent(r.app.uid, r.app.mPid, true, "serviceDoneExecuting = " + r.shortInstanceName);
    L53:
        if (inDestroying == true) goto L55;
    L58:
        if (oomAdjReason == 0) goto L62;
        if (enqueueOomAdj == false) goto L61;
        this.mAm.mProcessStateController.enqueueUpdateTarget(r.app);
        goto L62
    L61:
        this.mAm.mProcessStateController.runUpdate(r.app, oomAdjReason);
    L62:
        r.updateOomAdjSeq();
        goto L63
    L55:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L57;
        Slog.v("ActivityManager", "doneExecuting remove destroying " + r);
    L57:
        this.mDestroyingServices.remove(r);
        r.bindings.clear();
        goto L58
    L24:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE_EXECUTING == false) goto L27;
    L46:
        if (r.executeFg == false) goto L53;
        int i = psr.numberOfExecutingServices() - 1;
    L48:
        if (i < 0) goto L53;
        if (psr.getExecutingServiceAt(i).executeFg == true) goto L51;
        i = i - 1;
        goto L48
    L51:
        this.mAm.mProcessStateController.setExecServicesFg(psr, true);
    L63:
        r.executeFg = false;
        if (r.tracker == null) goto L76;
        Object r6 = this.mAm.mProcessStats.mLock;
        monitor-enter(r6);
        int memFactor = this.mAm.mProcessStats.getMemFactorLocked();     // Catch: Throwable -> L70
        long now2 = SystemClock.uptimeMillis();     // Catch: Throwable -> L70
        r.tracker.setExecuting(false, memFactor, now2);     // Catch: Throwable -> L70
        r.tracker.setForeground(false, memFactor, now2);     // Catch: Throwable -> L70
        if (finishing == false) goto L72;
        r.tracker.clearCurrentOwner(r, false);     // Catch: Throwable -> L70
        r.tracker = null;     // Catch: Throwable -> L70
    L72:
        monitor-exit(r6);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    L76:
        if (finishing == false) goto L84;
        if (r.app != null) goto L80;
    L82:
        r.setProcess(null, null, 0, null);
        goto L84
    L80:
        if (r.app.isPersistent() == true) goto L82;
        stopServiceAndUpdateAllowlistManagerLocked(r);
    L84:
        if (StabTrace.isEnable() == false) goto L97;
        StringBuilder sb = new StringBuilder(150);
        sb.append("serviceDoneExe:callPid=");
        sb.append(Binder.getCallingPid());
        sb.append(" ");
        sb.append(r.name.getClassName());
        sb.append(" exeNesting=");
        sb.append(r.executeNesting);
        sb.append(" exeService=");
        if (r.app != null) goto L88;
    L90:
        int r5 = -1;
    L91:
        sb.append(r5);
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());
        return;
    L88:
        if (r.app.mServices == null) goto L90;
        r5 = r.app.mServices.numberOfExecutingServices();
        goto L91
    L97:
        return;
    L11:
        beginTime2 = 0;
        goto L12
    L6:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE_EXECUTING == false) goto L9;
        Slog.v("ActivityManager", "<<< DONE EXECUTING " + r.shortInstanceName);
        goto L9
    }

    boolean attachApplicationLocked(ProcessRecord proc, String processName) throws RemoteException {
        boolean didSomething = false;
        proc.mState.setBackgroundRestricted(appRestrictedAnyInBackground(proc.uid, proc.info.packageName));
        if (this.mPendingServices.size() <= 0) goto L41;
        ServiceRecord sr = null;
        int i = 0;
        boolean didSomething2 = false;
    L60:
    L14:
        e = move-exception;
        Slog.w("ActivityManager", "Exception in new application when starting service " + sr.shortInstanceName, e);
        throw e;
    L6:
        if (i >= this.mPendingServices.size()) goto L37;
        sr = this.mPendingServices.get(i);     // Catch: RemoteException -> L14
        if (proc != sr.isolationHostProc) goto L10;
    L16:
        IApplicationThread thread = proc.getThread();     // Catch: RemoteException -> L14
        int pid = proc.getPid();     // Catch: RemoteException -> L14
        UidRecord uidRecord = proc.getUidRecord();     // Catch: RemoteException -> L14
        this.mPendingServices.remove(i);     // Catch: RemoteException -> L14
        int i2 = i - 1;     // Catch: RemoteException -> L14
        proc.addPackage(sr.appInfo.packageName, sr.appInfo.longVersionCode, this.mAm.mProcessStats);     // Catch: RemoteException -> L14
        if (Trace.isTagEnabled(64) == false) goto L62;
        Trace.traceBegin(64, "realStartServiceLocked: " + sr.shortInstanceName);     // Catch: Throwable -> L22
    L22:
        th = th;
    L35:
        Trace.traceEnd(64);     // Catch: RemoteException -> L14
        throw th;     // Catch: RemoteException -> L14
    L62:
        realStartServiceLocked(sr, proc, thread, pid, uidRecord, sr.createdFromFg, true, 0);     // Catch: Throwable -> L31
        Trace.traceEnd(64);     // Catch: RemoteException -> L14
        didSomething2 = true;
        if (isServiceNeededLocked(sr, false, false) == true) goto L29;
        bringDownServiceLocked(sr, true);     // Catch: RemoteException -> L14
    L29:
        this.mAm.updateOomAdjPendingTargetsLocked(6);     // Catch: RemoteException -> L14
        i = i2;
    L30:
        i = i + 1;     // Catch: RemoteException -> L14
    L31:
        th = th;
    L33:
        th = th;
        goto L35
    L10:
        if (proc.uid != sr.appInfo.uid) goto L30;
        if (processName.equals(sr.processName) == true) goto L16;
    L37:
        didSomething = didSomething2;
    L41:
        if (this.mRestartingServices.size() <= 0) goto L57;
        boolean didImmediateRestart = false;
        int i3 = 0;
    L44:
        if (i3 >= this.mRestartingServices.size()) goto L55;
        ServiceRecord sr2 = this.mRestartingServices.get(i3);
        if (proc != sr2.isolationHostProc) goto L48;
    L52:
        this.mAm.mHandler.removeCallbacks(sr2.restarter);
        this.mAm.mHandler.post(sr2.restarter);
        didImmediateRestart = true;
    L53:
        i3 = i3 + 1;
        goto L44
    L48:
        if (proc.uid != sr2.appInfo.uid) goto L53;
        if (processName.equals(sr2.processName) == true) goto L52;
    L55:
        if (didImmediateRestart == false) goto L57;
        this.mAm.mHandler.post(new ActiveServices$$ExternalSyntheticLambda3(this));
    L57:
        return didSomething;
    }

    private /* synthetic */ void lambda$attachApplicationLocked$2() {
        long now = SystemClock.uptimeMillis();
        ActivityManagerService r9 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r9);
        rescheduleServiceRestartIfPossibleLocked(getExtraRestartTimeInBetweenLocked(), this.mAm.mConstants.SERVICE_MIN_RESTART_TIME_BETWEEN, "other", now);     // Catch: Throwable -> L8
        monitor-exit(r9);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void processStartTimedOutLocked(ProcessRecord proc) {
        boolean needOomAdj = false;
        int i = 0;
        int size = this.mPendingServices.size();
    L3:
        if (i >= size) goto L13;
        ServiceRecord sr = this.mPendingServices.get(i);
        if (proc.uid != sr.appInfo.uid) goto L9;
        if (proc.processName.equals(sr.processName) == false) goto L9;
    L10:
        Slog.w("ActivityManager", "Forcing bringing down service: " + sr);
        sr.isolationHostProc = null;
        this.mPendingServices.remove(i);
        size = this.mPendingServices.size();
        i = i - 1;
        needOomAdj = true;
        bringDownServiceLocked(sr, true);
    L11:
        i = i + 1;
    L9:
        if (sr.isolationHostProc != proc) goto L11;
    L13:
        if (needOomAdj == false) goto L19;
        this.mAm.updateOomAdjPendingTargetsLocked(12);
        return;
    }

    private boolean collectPackageServicesLocked(String packageName, Set<String> filterByClasses, boolean evenPersistent, boolean doit, int minOomAdj, ArrayMap<ComponentName, ServiceRecord> services) {
        boolean didSomething = false;
        int i = services.size() - 1;
    L3:
        if (i < 0) goto L39;
        ServiceRecord service = services.valueAt(i);
        if (packageName != null) goto L7;
    L13:
        boolean sameComponent = true;
    L15:
        if (service.app != null) goto L17;
    L20:
        if (sameComponent == false) goto L37;
        if (service.app == null) goto L26;
        if (evenPersistent == true) goto L26;
        if (service.app.isPersistent() == true) goto L37;
    L26:
        if (doit == false) goto L27;
        didSomething = true;
        Slog.i("ActivityManager", "  Force stopping service " + service);
        if (service.app != null) goto L31;
    L33:
        service.setProcess(null, null, 0, null);
        service.isolationHostProc = null;
        if (this.mTmpCollectionResults != null) goto L36;
        this.mTmpCollectionResults = new ArrayList();
    L36:
        this.mTmpCollectionResults.add(service);
        goto L37
    L31:
        if (service.app.isPersistent() == true) goto L33;
        stopServiceAndUpdateAllowlistManagerLocked(service);
        goto L33
    L27:
        return true;
    L37:
        i = i - 1;
        goto L3
    L17:
        if (service.app.mState.getCurAdj() >= minOomAdj) goto L20;
        Slog.i("ActivityManager", "Skip force stopping service " + service + ": below minimum oom adj level");
        goto L37
    L7:
        if (service.packageName.equals(packageName) == false) goto L12;
        if (filterByClasses == null) goto L13;
        if (filterByClasses.contains(service.name.getClassName()) == true) goto L13;
    L12:
        sameComponent = false;
        goto L15
    L39:
        return didSomething;
    }

    boolean bringDownDisabledPackageServicesLocked(String packageName, Set<String> filterByClasses, int userId, boolean evenPersistent, boolean fullStop, boolean doit) {
        return bringDownDisabledPackageServicesLocked(packageName, filterByClasses, userId, evenPersistent, fullStop, doit, ProcessList.INVALID_ADJ);
    }

    boolean bringDownDisabledPackageServicesLocked(String packageName, Set<String> filterByClasses, int userId, boolean evenPersistent, boolean fullStop, boolean doit, int minOomAdj) {
        boolean didSomething = false;
        if (this.mTmpCollectionResults == null) goto L6;
        this.mTmpCollectionResults.clear();
    L6:
        if (userId != (-1)) goto L18;
        boolean didSomething2 = false;
        int i = this.mServiceMap.size() - 1;
    L8:
        if (i < 0) goto L26;
        didSomething2 = didSomething2 | collectPackageServicesLocked(packageName, filterByClasses, evenPersistent, doit, minOomAdj, this.mServiceMap.valueAt(i).mServicesByInstanceName);
        if (doit == true) goto L13;
        if (didSomething2 == false) goto L13;
        return true;
    L13:
        if (doit == false) goto L16;
        if (filterByClasses != null) goto L16;
        forceStopPackageLocked(packageName, this.mServiceMap.valueAt(i).mUserId);
    L16:
        i = i - 1;
    L26:
        if (this.mTmpCollectionResults == null) goto L38;
        int size = this.mTmpCollectionResults.size();
        int i2 = size - 1;
    L28:
        if (i2 < 0) goto L31;
        bringDownServiceLocked(this.mTmpCollectionResults.get(i2), true);
        i2 = i2 - 1;
        goto L28
    L31:
        if (size <= 0) goto L33;
        this.mAm.updateOomAdjPendingTargetsLocked(22);
    L33:
        if (fullStop == true) goto L35;
    L37:
        ArrayList<ServiceRecord> allServices = this.mTmpCollectionResults;
        allServices.clear();
        goto L38
    L35:
        if (this.mTmpCollectionResults.isEmpty() == true) goto L37;
        final ArrayList<ServiceRecord> allServices2 = (ArrayList) this.mTmpCollectionResults.clone();
        this.mAm.mHandler.postDelayed(new ActiveServices$$ExternalSyntheticLambda9(allServices2), 250);
    L38:
        return didSomething2;
    L18:
        ServiceMap smap = this.mServiceMap.get(userId);
        if (smap == null) goto L21;
        ArrayMap<ComponentName, ServiceRecord> items = smap.mServicesByInstanceName;
        didSomething = collectPackageServicesLocked(packageName, filterByClasses, evenPersistent, doit, minOomAdj, items);
    L21:
        if (doit == false) goto L24;
        if (filterByClasses != null) goto L24;
        forceStopPackageLocked(packageName, userId);
    L24:
        didSomething2 = didSomething;
        goto L26
    }

    private static /* synthetic */ void lambda$bringDownDisabledPackageServicesLocked$3(ArrayList allServices) {
        int i = 0;
    L4:
        if (i >= allServices.size()) goto L7;
        ((ServiceRecord) allServices.get(i)).cancelNotification();
        i = i + 1;
        goto L4
    }

    private void signalForegroundServiceObserversLocked(ServiceRecord r) {
        int num = this.mFgsObservers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= num) goto L8;
        this.mFgsObservers.getBroadcastItem(i).onForegroundStateChanged(r, r.appInfo.packageName, r.userId, r.isForeground);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mFgsObservers.finishBroadcast();
    }

    boolean registerForegroundServiceObserverLocked(int callingUid, IForegroundServiceObserver callback) {
        int mapSize = this.mServiceMap.size();     // Catch: RemoteException -> L14
        int mapIndex = 0;
    L4:
        if (mapIndex >= mapSize) goto L18;
        ServiceMap smap = this.mServiceMap.valueAt(mapIndex);     // Catch: RemoteException -> L14
        if (smap == null) goto L17;
        int numServices = smap.mServicesByInstanceName.size();     // Catch: RemoteException -> L14
        int i = 0;
    L8:
        if (i >= numServices) goto L17;
        ServiceRecord sr = smap.mServicesByInstanceName.valueAt(i);     // Catch: RemoteException -> L14
        if (sr.isForeground == false) goto L16;
        if (callingUid != sr.appInfo.uid) goto L16;
        callback.onForegroundStateChanged(sr, sr.appInfo.packageName, sr.userId, true);     // Catch: RemoteException -> L14
    L16:
        i = i + 1;     // Catch: RemoteException -> L14
    L17:
        mapIndex = mapIndex + 1;     // Catch: RemoteException -> L14
        goto L4
    L18:
        this.mFgsObservers.register(callback);     // Catch: RemoteException -> L14
        return true;
    L20:
        Slog.e("ActivityManager", "Bad FGS observer from uid " + callingUid);
        return false;
    }

    void forceStopPackageLocked(String packageName, int userId) {
        ServiceMap smap = this.mServiceMap.get(userId);
        if (smap != null) goto L5;
    L15:
        int i = this.mPendingBringups.size() - 1;
    L16:
        if (i < 0) goto L23;
        ServiceRecord r = this.mPendingBringups.keyAt(i);
        if (TextUtils.equals(r.packageName, packageName) == false) goto L22;
        if (r.userId != userId) goto L22;
        this.mPendingBringups.removeAt(i);
    L22:
        i = i - 1;
        goto L16
    L23:
        removeServiceRestartBackoffEnabledLocked(packageName);
        removeServiceNotificationDeferralsLocked(packageName, userId);
        return;
    L5:
        if (smap.mActiveForegroundApps.size() <= 0) goto L15;
        int i2 = smap.mActiveForegroundApps.size() - 1;
    L7:
        if (i2 < 0) goto L13;
        ActiveForegroundApp aa = smap.mActiveForegroundApps.valueAt(i2);
        if (aa.mPackageName.equals(packageName) == false) goto L11;
        smap.mActiveForegroundApps.removeAt(i2);
        smap.mActiveForegroundAppsChanged = true;
    L11:
        i2 = i2 - 1;
        goto L7
    L13:
        if (smap.mActiveForegroundAppsChanged == false) goto L15;
        requestUpdateActiveForegroundAppsLocked(smap, 0);
        goto L15
    }

    void cleanUpServices(int userId, ComponentName component, Intent baseIntent) {
        ArrayList<ServiceRecord> services = new ArrayList();
        ArrayMap<ComponentName, ServiceRecord> alls = getServicesLocked(userId);
        int i = alls.size() - 1;
    L3:
        if (i < 0) goto L8;
        ServiceRecord sr = alls.valueAt(i);
        if (sr.packageName.equals(component.getPackageName()) == false) goto L7;
        services.add(sr);
    L7:
        i = i - 1;
        goto L3
    L8:
        int i2 = services.size() - 1;
        boolean needOomAdj = false;
    L9:
        if (i2 < 0) goto L25;
        ServiceRecord sr2 = services.get(i2);
        if (sr2.startRequested == false) goto L23;
        if ((sr2.serviceInfo.flags & 1) == 0) goto L15;
        Slog.i("ActivityManager", "Stopping service " + sr2.shortInstanceName + ": remove task");
        stopServiceLocked(sr2, true);
        needOomAdj = true;
        goto L23
    L15:
        sr2.pendingStarts.add(new ServiceRecord.StartItem(sr2, true, sr2.getLastStartId(), baseIntent, null, 0, null, null, -1));
        if (sr2.app == null) goto L23;
        if (sr2.app.isThreadReady() == false) goto L23;
        sendServiceArgsLocked(sr2, true, false);     // Catch: TransactionTooLargeException -> L22
    L23:
        i2 = i2 - 1;
        goto L9
    L25:
        if (needOomAdj == false) goto L40;
        this.mAm.updateOomAdjPendingTargetsLocked(17);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    final void killServicesLocked(ProcessRecord r20, boolean r21) {
        ProcessServiceRecord r3 = r20.mServices;
        IApplicationThread r4 = 0;
    L8:
        e = move-exception;
        Slog.e("ActivityManager", "Failed to send kill process details to servicetracker AIDL/HAL", e);
        this.mServicetracker = null;
        this.mServicetracker_aidl = null;
    L17:
        boolean r5 = r20.getSmtEx().isFreezing();
        int r0 = 0;
        int r6 = 1;
        if (r5 == true) goto L23;
        int r7 = r3.numberOfConnections() - 1;
    L20:
        if (r7 < 0) goto L22;
        removeConnectionLocked(r3.getConnectionAt(r7), r20, null, true);
        r7 = r7 - 1;
        goto L20
    L22:
        updateServiceConnectionActivitiesLocked(r3);
        this.mAm.mProcessStateController.removeAllConnections(r3);
        r3.mAllowlistManager = false;
    L23:
        int r8 = r3.numberOfRunningServices() - 1;
    L24:
        if (r8 < 0) goto L81;
        ServiceRecord r9 = r3.getRunningServiceAt(r8);
        if (r5 == true) goto L43;
        this.mAm.mBatteryStatsService.noteServiceStopLaunch(r9.appInfo.uid, r9.name.getPackageName(), r9.name.getClassName());
        if (r9.app != r20) goto L30;
    L34:
        r9.setProcess(r4, r4, r0, r4);
        r9.cancelNotification();
        r9.isolationHostProc = r4;
        r9.executeNesting = r0;
        Object r10 = this.mAm.mProcessStats.mLock;
        monitor-enter(r10);
        r9.forceClearTracker();     // Catch: Throwable -> L39
        monitor-exit(r10);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    L30:
        if (r9.app == null) goto L34;
        if (r9.app.isPersistent() == true) goto L34;
        this.mAm.mProcessStateController.stopService(r9.app.mServices, r9);
        r9.app.mServices.updateBoundClientUids();
    L43:
        if (this.mDestroyingServices.remove(r9) == true) goto L45;
    L47:
        int r11 = r9.bindings.size() - 1;
        ?? r12 = r4;
    L48:
        if (r11 < 0) goto L80;
        IntentBindRecord r13 = r9.bindings.valueAt(r11);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L52;
        Slog.v("ActivityManager", "Killing binding " + r13 + ": shouldUnbind=" + r13.hasBound);
    L52:
        boolean r14 = false;
        int r15 = r13.apps.size() - r6;
    L53:
        if (r15 < 0) goto L76;
        ProcessRecord r16 = r13.apps.keyAt(r15);
        if (r5 == false) goto L60;
        if (r20.info.uid != r16.info.uid) goto L60;
        r14 = true;
    L60:
        if (r16.isKilledByAm() == true) goto L74;
        if (r16.getThread() == null) goto L74;
        AppBindRecord r1 = r13.apps.valueAt(r15);
        boolean r17 = false;
        int r18 = r1.connections.size() - r6;
    L65:
        if (r18 < 0) goto L73;
        ConnectionRecord r19 = r1.connections.valueAt(r18);
        AppBindRecord r110 = r1;
        if (r19.hasFlag(1) == false) goto L71;
        if (r19.notHasFlag(48) == false) goto L71;
        r17 = true;
    L71:
        r18 = r18 - 1;
        r1 = r110;
    L73:
        if (r17 == false) goto L74;
    L74:
        r15 = r15 - 1;
        r6 = 1;
        goto L53
    L76:
        if (r14 == true) goto L78;
        boolean r22 = false;
        r13.binder = null;
        r13.hasBound = false;
        r13.received = false;
        r13.requested = false;
    L79:
        r11 = r11 - 1;
        r6 = 1;
        r12 = r22;
        goto L48
    L78:
        r22 = false;
        goto L79
    L80:
        r8 = r8 - 1;
        r0 = 0;
        r6 = 1;
        r4 = r12;
        goto L24
    L45:
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L47;
        Slog.v("ActivityManager", "killServices remove destroying " + r9);
        goto L47
    L81:
        ServiceMap r23 = getServiceMapLocked(r20.userId);
        int r24 = r3.numberOfRunningServices() - 1;
    L82:
        if (r24 < 0) goto L123;
        ServiceRecord r25 = r3.getRunningServiceAt(r24);
        if (r20.isPersistent() == true) goto L87;
        if (r5 == true) goto L87;
        this.mAm.mProcessStateController.stopService(r3, r25);
        r3.updateBoundClientUids();
    L87:
        ServiceRecord r26 = r23.mServicesByInstanceName.get(r25.instanceName);
        if (r26 == r25) goto L91;
        if (r26 == null) goto L122;
        Slog.wtf("ActivityManager", "Service " + r25 + " in process " + r20 + " not same as in map: " + r26);
    L122:
        r24 = r24 - 1;
        goto L82
    L91:
        if (r21 == true) goto L93;
    L102:
        if (r21 == true) goto L104;
    L121:
        bringDownServiceLocked(r25, true);
        goto L122
    L104:
        if (this.mAm.mUserController.isUserRunning(r25.userId, 0) == false) goto L121;
        if (scheduleServiceRestartLocked(r25, true) == true) goto L110;
        bringDownServiceLocked(r25, true);
        goto L122
    L110:
        if (r25.canStopIfKilled(false) == false) goto L122;
        this.mAm.mProcessStateController.setStartRequested(r25, false);
        if (r25.tracker == null) goto L122;
        Object r111 = this.mAm.mProcessStats.mLock;
        monitor-enter(r111);
        r25.tracker.setStarted(false, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L118
        monitor-exit(r111);     // Catch: Throwable -> L118
    L118:
        th = move-exception;
        throw th;
    L93:
        if (r25.crashCount < this.mAm.mConstants.BOUND_SERVICE_MAX_CRASH_RETRY) goto L102;
        if ((r25.serviceInfo.applicationInfo.flags & 8) != 0) goto L102;
        Slog.w("ActivityManager", "Service crashed " + r25.crashCount + " times, stopping: " + r25);
        Integer r2 = Integer.valueOf(r25.userId);
        Integer r27 = Integer.valueOf(r25.crashCount);
        String r112 = r25.shortInstanceName;
        if (r25.app == null) goto L99;
        int r113 = r25.app.getPid();
    L100:
        EventLog.writeEvent(EventLogTags.AM_SERVICE_CRASHED_TOO_MUCH, new Object[]{r2, r27, r112, Integer.valueOf(r113)});
        bringDownServiceLocked(r25, true);
        goto L122
    L99:
        r113 = -1;
        goto L100
    L123:
        this.mAm.updateOomAdjPendingTargetsLocked(19);
        if (r21 == true) goto L151;
        if (r5 == true) goto L127;
        this.mAm.mProcessStateController.stopAllServices(r3);
        r3.clearBoundClientUids();
    L127:
        int r28 = this.mRestartingServices.size() - 1;
    L128:
        if (r28 < 0) goto L135;
        ServiceRecord r29 = this.mRestartingServices.get(r28);
        if (r29.processName.equals(r20.processName) == false) goto L134;
        if (r29.serviceInfo.applicationInfo.uid != r20.info.uid) goto L134;
        this.mRestartingServices.remove(r28);
        clearRestartingIfNeededLocked(r29);
    L134:
        r28 = r28 - 1;
        goto L128
    L135:
        int r30 = this.mPendingServices.size() - 1;
    L136:
        if (r30 < 0) goto L143;
        ServiceRecord r31 = this.mPendingServices.get(r30);
        if (r31.processName.equals(r20.processName) == false) goto L142;
        if (r31.serviceInfo.applicationInfo.uid != r20.info.uid) goto L142;
        this.mPendingServices.remove(r30);
    L142:
        r30 = r30 - 1;
        goto L136
    L143:
        int r32 = this.mPendingBringups.size() - 1;
    L144:
        if (r32 < 0) goto L151;
        ServiceRecord r33 = this.mPendingBringups.keyAt(r32);
        if (r33.processName.equals(r20.processName) == false) goto L150;
        if (r33.serviceInfo.applicationInfo.uid != r20.info.uid) goto L150;
        this.mPendingBringups.removeAt(r32);
    L150:
        r32 = r32 - 1;
    L151:
        int r34 = this.mDestroyingServices.size();
    L152:
        if (r34 <= 0) goto L166;
        int r35 = r34 - 1;
        ServiceRecord r36 = this.mDestroyingServices.get(r35);
        if (r36.app != r20) goto L165;
        Object r37 = this.mAm.mProcessStats.mLock;
        monitor-enter(r37);
        r36.forceClearTracker();     // Catch: Throwable -> L162
        monitor-exit(r37);     // Catch: Throwable -> L162
        this.mDestroyingServices.remove(r35);
        if (ActivityManagerDebugConfig.DEBUG_SERVICE == false) goto L165;
        Slog.v("ActivityManager", "killServices remove destroying " + r36);
    L162:
        th = move-exception;
        throw th;
    L165:
        r34 = r35;
        goto L152
    L166:
        int r38 = r3.numberOfRunningServices() - 1;
    L167:
        if (r38 < 0) goto L169;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().cancelService(r3.getRunningServiceAt(r38));
        r38 = r38 - 1;
        goto L167
    L169:
        if (r5 == true) goto L220;
        this.mAm.mProcessStateController.stopAllExecutingServices(r3);
        r3.noteScheduleServiceTimeoutPending(false);
        return;
    L220:
        return;
    L4:
        if (this.isLowRamDevice == true) goto L11;
        if (getAIDLServicetrackerInstance() == false) goto L11;
        this.mServicetracker_aidl.killProcess(r20.getPid());     // Catch: RemoteException -> L8
    L178:
    L11:
        if (this.isLowRamDevice == true) goto L178;
        if (getServicetrackerInstance() == false) goto L178;
        this.mServicetracker.killProcess(r20.getPid());     // Catch: RemoteException -> L8
        goto L178
    }

    ActivityManager.RunningServiceInfo makeRunningServiceInfoLocked(ServiceRecord r) {
        ActivityManager.RunningServiceInfo info = new ActivityManager.RunningServiceInfo();
        info.service = r.name;
        if (r.app == null) goto L5;
        info.pid = r.app.getPid();
    L5:
        info.uid = r.appInfo.uid;
        info.process = r.processName;
        info.foreground = r.isForeground;
        info.activeSince = r.createRealTime;
        info.started = r.startRequested;
        info.clientCount = r.getConnections().size();
        info.crashCount = r.crashCount;
        info.lastActivityTime = r.lastActivity;
        if (r.isForeground == false) goto L9;
        info.flags |= 2;
    L9:
        if (r.startRequested == false) goto L12;
        info.flags |= 1;
    L12:
        if (r.app == null) goto L17;
        if (r.app.getPid() != ActivityManagerService.MY_PID) goto L17;
        info.flags |= 4;
    L17:
        if (r.app != null) goto L19;
    L21:
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections = r.getConnections();
        int conni = connections.size() - 1;
    L22:
        if (conni < 0) goto L33;
        ArrayList<ConnectionRecord> connl = connections.valueAt(conni);
        int i = 0;
    L25:
        if (i >= connl.size()) goto L31;
        ConnectionRecord conn = connl.get(i);
        if (conn.clientLabel != 0) goto L28;
        i = i + 1;
        goto L25
    L28:
        info.clientPackage = conn.binding.client.info.packageName;
        info.clientLabel = conn.clientLabel;
        return info;
    L31:
        conni = conni - 1;
        goto L22
    L33:
        return info;
    L19:
        if (r.app.isPersistent() == false) goto L21;
        info.flags |= 8;
        goto L21
    }

    List<ActivityManager.RunningServiceInfo> getRunningServiceInfoLocked(int maxNum, int flags, int callingUid, boolean allowed, boolean canInteractAcrossUsers) {
        ArrayList<ActivityManager.RunningServiceInfo> res = new ArrayList();
        long ident = this.mAm.mInjector.clearCallingIdentity();
        if (canInteractAcrossUsers == false) goto L25;
        int[] users = this.mAm.mUserController.getUsers();     // Catch: Throwable -> L15
        int ui = 0;
    L6:
        if (ui >= users.length) goto L18;
        if (res.size() >= maxNum) goto L18;
        ArrayMap<ComponentName, ServiceRecord> alls = getServicesLocked(users[ui]);     // Catch: Throwable -> L15
        int i = 0;
    L11:
        if (i >= alls.size()) goto L17;
        if (res.size() >= maxNum) goto L17;
        res.add(makeRunningServiceInfoLocked(alls.valueAt(i)));     // Catch: Throwable -> L15
        i = i + 1;     // Catch: Throwable -> L15
    L17:
        ui = ui + 1;     // Catch: Throwable -> L15
    L18:
        int i2 = 0;
    L20:
        if (i2 >= this.mRestartingServices.size()) goto L53;
        if (res.size() >= maxNum) goto L53;
        ServiceRecord r = this.mRestartingServices.get(i2);     // Catch: Throwable -> L15
        ActivityManager.RunningServiceInfo info = makeRunningServiceInfoLocked(r);     // Catch: Throwable -> L15
        info.restarting = r.nextRestartTime;     // Catch: Throwable -> L15
        res.add(info);     // Catch: Throwable -> L15
        i2 = i2 + 1;     // Catch: Throwable -> L15
    L53:
        this.mAm.mInjector.restoreCallingIdentity(ident);
        return res;
    L25:
        int userId = UserHandle.getUserId(callingUid);     // Catch: Throwable -> L15
        ArrayMap<ComponentName, ServiceRecord> alls2 = getServicesLocked(userId);     // Catch: Throwable -> L15
        int i3 = 0;
    L27:
        if (i3 >= alls2.size()) goto L38;
        if (res.size() >= maxNum) goto L38;
        ServiceRecord sr = alls2.valueAt(i3);     // Catch: Throwable -> L15
        if (allowed == false) goto L33;
    L36:
        res.add(makeRunningServiceInfoLocked(sr));     // Catch: Throwable -> L15
    L37:
        i3 = i3 + 1;     // Catch: Throwable -> L15
        goto L27
    L33:
        if (sr.app == null) goto L37;
        if (sr.app.uid != callingUid) goto L37;
    L38:
        int i4 = 0;
    L40:
        if (i4 >= this.mRestartingServices.size()) goto L53;
        if (res.size() >= maxNum) goto L53;
        ServiceRecord r2 = this.mRestartingServices.get(i4);     // Catch: Throwable -> L15
        if (r2.userId != userId) goto L52;
        if (allowed == false) goto L47;
    L51:
        ActivityManager.RunningServiceInfo info2 = makeRunningServiceInfoLocked(r2);     // Catch: Throwable -> L15
        info2.restarting = r2.nextRestartTime;     // Catch: Throwable -> L15
        res.add(info2);     // Catch: Throwable -> L15
        goto L52
    L47:
        if (r2.app == null) goto L52;
        if (r2.app.uid == callingUid) goto L51;
    L52:
        i4 = i4 + 1;
    L15:
        th = move-exception;
        this.mAm.mInjector.restoreCallingIdentity(ident);
        throw th;
    }

    public PendingIntent getRunningServiceControlPanelLocked(ComponentName name) {
        int userId = UserHandle.getUserId(this.mAm.mInjector.getCallingUid());
        ServiceRecord r = getServiceByNameLocked(name, userId);
        if (r == null) goto L15;
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections = r.getConnections();
        int conni = connections.size() - 1;
    L5:
        if (conni < 0) goto L20;
        ArrayList<ConnectionRecord> conn = connections.valueAt(conni);
        int i = 0;
    L8:
        if (i >= conn.size()) goto L14;
        if (conn.get(i).clientIntent != null) goto L12;
        i = i + 1;
        goto L8
    L12:
        return conn.get(i).clientIntent;
    L14:
        conni = conni - 1;
        goto L5
    L20:
        return null;
    L15:
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0123: MOVE (r5 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY] A[D('timeoutRecord' com.android.internal.os.TimeoutRecord)]), block:B:53:0x0123 */
    void serviceTimeout(ProcessRecord proc) {
        long r3 = 64;
        Trace.traceBegin(64, "serviceTimeout()");     // Catch: Throwable -> L91
        ActivityManagerService r6 = this.mAm;     // Catch: Throwable -> L91
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L91
        monitor-enter(r6);     // Catch: Throwable -> L91
    L81:
        th = th;
    L88:
        monitor-exit(r6);     // Catch: Throwable -> L37
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L101:
        if (proc.isDebugging() == false) goto L13;
        this.mActiveServiceAnrTimer.discard(proc);     // Catch: Throwable -> L11
        monitor-exit(r6);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(64);
        return;
    L13:
        ProcessServiceRecord psr = proc.mServices;     // Catch: Throwable -> L81
        if (psr.numberOfExecutingServices() == 0) goto L84;
        if (proc.getThread() == null) goto L84;
        if (proc.isKilled() == true) goto L84;
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L81
        if (psr.shouldExecServicesFg() == false) goto L24;
        long r9 = this.mAm.mConstants.SERVICE_TIMEOUT;     // Catch: Throwable -> L11
    L25:
        long maxTime = now - r9;     // Catch: Throwable -> L81
        ServiceRecord timeout = null;
        long nextTime = 0;
        int i = psr.numberOfExecutingServices() - 1;
    L27:
        if (i < 0) goto L40;
        ServiceRecord sr = psr.getExecutingServiceAt(i);     // Catch: Throwable -> L11
        long r16 = r3;
        if (sr.executingStart < maxTime) goto L32;
        if (sr.executingStart <= nextTime) goto L39;
        nextTime = sr.executingStart;     // Catch: Throwable -> L37
    L39:
        i = i - 1;
        r3 = r16;
        goto L27
    L32:
        timeout = sr;
    L41:
        if (timeout == null) goto L57;
    L54:
        th = th;
        goto L88
    L43:
        if (this.mAm.mProcessList.isInLruListLOSP(proc) == false) goto L57;
        AutoCloseable timer = this.mActiveServiceAnrTimer.accept(proc);     // Catch: Throwable -> L54
        Slog.w("ActivityManager", "Timeout executing service: " + timeout);     // Catch: Throwable -> L54
        StringWriter sw = new StringWriter();     // Catch: Throwable -> L54
        FastPrintWriter r14 = new FastPrintWriter(sw, false, 1024);     // Catch: Throwable -> L54
        r14.println(timeout);     // Catch: Throwable -> L54
        timeout.dump(r14, "    ");     // Catch: Throwable -> L54
        r14.close();     // Catch: Throwable -> L54
        this.mLastAnrDump = sw.toString();     // Catch: Throwable -> L54
        this.mAm.mHandler.removeCallbacks(this.mLastAnrDumpClearer);     // Catch: Throwable -> L54
        this.mAm.mHandler.postDelayed(this.mLastAnrDumpClearer, 7200000);     // Catch: Throwable -> L52
        long waitedMillis = now - timeout.executingStart;     // Catch: Throwable -> L52
        TimeoutRecord timeoutRecord = TimeoutRecord.forServiceExec(timeout.shortInstanceName, waitedMillis).setExpiredTimer(timer);     // Catch: Throwable -> L52
        timeoutRecord.mReason += " FG=" + psr.shouldExecServicesFg();     // Catch: Throwable -> L50
        TimeoutRecord timeoutRecord2 = timeoutRecord;
    L63:
        monitor-exit(r6);     // Catch: Throwable -> L37
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L69
        if (timeoutRecord2 == null) goto L79;
        SysOptBridge.getFactory().getFreezeController().serviceTimeoutEvent(proc.uid, proc.mPid, "check Process whileTimeout proc:" + proc);     // Catch: Throwable -> L69
        if (StabTrace.isEnable() == false) goto L71;
        long beginTime = Process.getCpuClocks();     // Catch: Throwable -> L69
        long beginTime2 = beginTime;
    L72:
        this.mAm.mAnrHelper.appNotResponding(proc, timeoutRecord2);     // Catch: Throwable -> L69
        if (StabTrace.isEnable() == false) goto L79;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");     // Catch: Throwable -> L69
        long currentTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L69
        String formattedDate = sdf.format(new Date(currentTimeMillis));     // Catch: Throwable -> L69
        StringBuilder sb = new StringBuilder(200);     // Catch: Throwable -> L69
        sb.append(formattedDate);     // Catch: Throwable -> L69
        sb.append(" pid=");     // Catch: Throwable -> L69
        sb.append(Integer.valueOf(proc.getPid()));     // Catch: Throwable -> L69
        sb.append(timeoutRecord2.mReason);     // Catch: Throwable -> L69
        sb.append(" occur ANR ");     // Catch: Throwable -> L69
        sb.append("FG=");     // Catch: Throwable -> L69
        if (proc.mServices == null) goto L77;
        Object r7 = Boolean.valueOf(proc.mServices.shouldExecServicesFg());     // Catch: Throwable -> L69
    L78:
        sb.append(r7);     // Catch: Throwable -> L69
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());     // Catch: Throwable -> L69
        goto L79
    L77:
        r7 = "-1";
        goto L78
    L71:
        beginTime2 = 0;
    L79:
        Trace.traceEnd(r16);
        return;
    L50:
        th = th;
    L57:
        this.mActiveServiceAnrTimer.discard(proc);     // Catch: Throwable -> L52
        if (psr.shouldExecServicesFg() == false) goto L60;
        long delay = this.mAm.mConstants.SERVICE_TIMEOUT + nextTime;     // Catch: Throwable -> L52
    L61:
        this.mActiveServiceAnrTimer.start(proc, delay);     // Catch: Throwable -> L52
        timeoutRecord2 = null;
        goto L63
    L60:
        delay = (this.mAm.mConstants.SERVICE_BACKGROUND_TIMEOUT + nextTime) - SystemClock.uptimeMillis();     // Catch: Throwable -> L52
        goto L61
    L40:
        r16 = r3;
        goto L41
    L24:
        r9 = this.mAm.mConstants.SERVICE_BACKGROUND_TIMEOUT;     // Catch: Throwable -> L81
    L84:
        this.mActiveServiceAnrTimer.discard(proc);     // Catch: Throwable -> L52
        monitor-exit(r6);     // Catch: Throwable -> L52
        ActivityManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(64);
        return;
    L52:
        th = th;
    L11:
        th = th;
    L37:
        th = th;
    L69:
        th = th;
    L93:
        Trace.traceEnd(64);
        throw th;
    L91:
        th = th;
        goto L93
    }

    void serviceForegroundTimeout(ServiceRecord r) {
        Trace.traceBegin(64, "serviceForegroundTimeout()");     // Catch: Throwable -> L31
        String annotation = "Context.startForegroundService() did not then call Service.startForeground(): " + r;     // Catch: Throwable -> L31
        TimeoutRecord timeoutRecord = TimeoutRecord.forServiceStartWithEndTime(annotation, SystemClock.uptimeMillis());     // Catch: Throwable -> L31
        timeoutRecord.mLatencyTracker.waitingOnAMSLockStarted();     // Catch: Throwable -> L31
        ActivityManagerService r4 = this.mAm;     // Catch: Throwable -> L31
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L31
        monitor-enter(r4);     // Catch: Throwable -> L31
        timeoutRecord.mLatencyTracker.waitingOnAMSLockEnded();     // Catch: Throwable -> L20
        if (r.fgRequired == false) goto L35;
        if (r.fgWaiting == false) goto L35;
        if (r.destroying == true) goto L35;
        ProcessRecord app = r.app;     // Catch: Throwable -> L20
        if (app != null) goto L15;
    L22:
        this.mServiceFGAnrTimer.accept(r);     // Catch: Throwable -> L20
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L25;
        Slog.i("ActivityManager", "Service foreground-required timeout for " + r);     // Catch: Throwable -> L20
    L25:
        r.fgWaiting = false;     // Catch: Throwable -> L20
        stopServiceLocked(r, false);     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        if (app == null) goto L33;
        Message msg = this.mAm.mHandler.obtainMessage(67);     // Catch: Throwable -> L31
        SomeArgs args = SomeArgs.obtain();     // Catch: Throwable -> L31
        args.arg1 = app;     // Catch: Throwable -> L31
        args.arg2 = timeoutRecord;     // Catch: Throwable -> L31
        msg.obj = args;     // Catch: Throwable -> L31
        this.mAm.mHandler.sendMessageDelayed(msg, this.mAm.mConstants.mServiceStartForegroundAnrDelayMs);     // Catch: Throwable -> L31
    L33:
        Trace.traceEnd(64);
        return;
    L15:
        if (app.isDebugging() == false) goto L22;
        this.mServiceFGAnrTimer.discard(r);     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(64);
        return;
    L35:
        this.mServiceFGAnrTimer.discard(r);     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(64);
        return;
    L20:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    }

    void serviceForegroundTimeoutANR(ProcessRecord app, TimeoutRecord timeoutRecord) {
        if (StabTrace.isEnable() == false) goto L5;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L6:
        this.mAm.mAnrHelper.appNotResponding(app, timeoutRecord);
        if (StabTrace.isEnable() == false) goto L14;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long currentTimeMillis = System.currentTimeMillis();
        String formattedDate = sdf.format(new Date(currentTimeMillis));
        StringBuilder sb = new StringBuilder(200);
        sb.append(formattedDate);
        sb.append(" serviceFG occur ANR:");
        sb.append(timeoutRecord.mReason);
        sb.append(" pid=");
        if (app == null) goto L11;
        Object r2 = Integer.valueOf(app.getPid());
    L12:
        sb.append(r2);
        StabTrace.traceInfo(8, sb.toString(), beginTime2, Process.getCpuClocks());
        return;
    L11:
        r2 = "0";
        goto L12
    L14:
        return;
    L5:
        beginTime2 = 0;
        goto L6
    }

    public void updateServiceApplicationInfoLocked(ApplicationInfo applicationInfo) {
        int userId = UserHandle.getUserId(applicationInfo.uid);
        ServiceMap serviceMap = this.mServiceMap.get(userId);
        if (serviceMap == null) goto L10;
        ArrayMap<ComponentName, ServiceRecord> servicesByName = serviceMap.mServicesByInstanceName;
        int j = servicesByName.size() - 1;
    L5:
        if (j < 0) goto L14;
        ServiceRecord serviceRecord = servicesByName.valueAt(j);
        if (applicationInfo.packageName.equals(serviceRecord.appInfo.packageName) == false) goto L9;
        serviceRecord.appInfo = applicationInfo;
        serviceRecord.serviceInfo.applicationInfo = applicationInfo;
    L9:
        j = j - 1;
        goto L5
    L14:
        return;
    }

    void serviceForegroundCrash(ProcessRecord app, String serviceRecord, ComponentName service) {
        this.mAm.crashApplicationWithTypeWithExtras(app.uid, app.getPid(), app.info.packageName, app.userId, "Context.startForegroundService() did not then call Service.startForeground(): " + serviceRecord, false, 1, RemoteServiceException.ForegroundServiceDidNotStartInTimeException.createExtrasForService(service));
    }

    void scheduleServiceTimeoutLocked(ProcessRecord proc) {
        if (proc.mServices.numberOfExecutingServices() != 0) goto L5;
        return;
    L5:
        if (proc.getThread() != null) goto L8;
        return;
    L8:
        if (proc.mServices.shouldExecServicesFg() == false) goto L10;
        long delay = this.mAm.mConstants.SERVICE_TIMEOUT;
    L11:
        this.mActiveServiceAnrTimer.start(proc, delay);
        proc.mServices.noteScheduleServiceTimeoutPending(false);
        return;
    L10:
        delay = this.mAm.mConstants.SERVICE_BACKGROUND_TIMEOUT;
        goto L11
    }

    void scheduleServiceForegroundTransitionTimeoutLocked(ServiceRecord r) {
        if (r.app.mServices.numberOfExecutingServices() != 0) goto L5;
        return;
    L5:
        if (r.app.getThread() == null) goto L10;
        r.fgWaiting = true;
        this.mServiceFGAnrTimer.start(r, this.mAm.mConstants.mServiceStartForegroundTimeoutMs);
        return;
    }

    ServiceDumper newServiceDumperLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, String dumpPackage) {
        return new ServiceDumper(this, fd, pw, args, opti, dumpAll, dumpPackage);
    }

    protected void dumpDebug(ProtoOutputStream proto, long fieldId) {
        ActiveServices r1 = this;
        ActivityManagerService r3 = r1.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        long outterToken = proto.start(fieldId);     // Catch: Throwable -> L13
        int[] users = r1.mAm.mUserController.getUsers();     // Catch: Throwable -> L13
        int r6 = users.length;     // Catch: Throwable -> L13
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L17;
        int user = users[r7];     // Catch: Throwable -> L13
        ServiceMap smap = r1.mServiceMap.get(user);     // Catch: Throwable -> L13
        if (smap != null) goto L9;
        int[] users2 = users;
    L16:
        r7 = r7 + 1;     // Catch: Throwable -> L13
        r1 = this;
        users = users2;
        goto L5
    L9:
        long token = proto.start(2246267895809L);     // Catch: Throwable -> L13
        proto.write(1120986464257L, user);     // Catch: Throwable -> L13
        ArrayMap<ComponentName, ServiceRecord> alls = smap.mServicesByInstanceName;     // Catch: Throwable -> L13
        int i = 0;
    L11:
        if (i >= alls.size()) goto L15;
        alls.valueAt(i).dumpDebug(proto, 2246267895810L);     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
        users = users;
        goto L11
    L15:
        users2 = users;
        proto.end(token);     // Catch: Throwable -> L13
        goto L16
    L17:
        proto.end(outterToken);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    protected boolean dumpService(FileDescriptor fd, PrintWriter pw, String name, int[] users, String[] args, int opti, boolean dumpAll) {
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(false);     // Catch: Throwable -> L45
        ArrayList<ServiceRecord> services = new ArrayList();     // Catch: Throwable -> L45
        Predicate<ServiceRecord> filter = DumpUtils.filterRecord(name);     // Catch: Throwable -> L45
        ActivityManagerService r5 = this.mAm;     // Catch: Throwable -> L45
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L45
        monitor-enter(r5);     // Catch: Throwable -> L45
        if (users == null) goto L50;
        int[] users2 = users;
    L11:
        int r0 = users2.length;     // Catch: Throwable -> L22
        int r7 = 0;
    L12:
        if (r7 >= r0) goto L26;
        int user = users2[r7];     // Catch: Throwable -> L22
        ServiceMap smap = this.mServiceMap.get(user);     // Catch: Throwable -> L22
        if (smap == null) goto L25;
        ArrayMap<ComponentName, ServiceRecord> alls = smap.mServicesByInstanceName;     // Catch: Throwable -> L22
        int i = 0;
    L18:
        if (i >= alls.size()) goto L25;
        ServiceRecord r1 = alls.valueAt(i);     // Catch: Throwable -> L22
        if (filter.test(r1) == false) goto L24;
        services.add(r1);     // Catch: Throwable -> L22
    L24:
        i = i + 1;     // Catch: Throwable -> L22
    L25:
        r7 = r7 + 1;     // Catch: Throwable -> L22
        goto L12
    L26:
        monitor-exit(r5);     // Catch: Throwable -> L22
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L36
        if (services.size() > 0) goto L31;
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(true);
        return false;
    L31:
        services.sort(Comparator.comparing(new ActiveServices$$ExternalSyntheticLambda1()));     // Catch: Throwable -> L36
        boolean needSep = false;
        int i2 = 0;
    L33:
        if (i2 >= services.size()) goto L40;
        if (needSep == false) goto L38;
        pw.println();     // Catch: Throwable -> L36
    L38:
        needSep = true;
        dumpService("", fd, pw, services.get(i2), args, dumpAll);     // Catch: Throwable -> L36
        i2 = i2 + 1;
        goto L33
    L40:
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(true);
        return true;
    L50:
        users2 = this.mAm.mUserController.getUsers();     // Catch: Throwable -> L8
    L8:
        th = th;
    L42:
        monitor-exit(r5);     // Catch: Throwable -> L22
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = th;
    L47:
        this.mAm.mOomAdjuster.mCachedAppOptimizer.enableFreezer(true);
        throw th;
    L22:
        th = th;
    L45:
        th = th;
        goto L47
    }

    private void dumpService(String prefix, FileDescriptor fd, PrintWriter pw, ServiceRecord r, String[] args, boolean dumpAll) {
        String innerPrefix = prefix + "  ";
        ActivityManagerService r1 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("SERVICE ");     // Catch: Throwable -> L7
        pw.print(r.shortInstanceName);     // Catch: Throwable -> L7
        pw.print(" ");     // Catch: Throwable -> L7
        pw.print(Integer.toHexString(System.identityHashCode(r)));     // Catch: Throwable -> L7
        pw.print(" pid=");     // Catch: Throwable -> L7
        if (r.app == null) goto L9;
        pw.print(r.app.getPid());     // Catch: Throwable -> L7
        pw.print(" user=");     // Catch: Throwable -> L7
        pw.println(r.userId);     // Catch: Throwable -> L7
    L10:
        if (dumpAll == false) goto L12;
        r.dump(pw, innerPrefix);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (r.app == null) goto L31;
        IApplicationThread thread = r.app.getThread();
        if (thread == null) goto L40;
        pw.print(prefix);
        pw.println("  Client:");
        pw.flush();
        TransferPipe tp = new TransferPipe();     // Catch: RemoteException -> L22 IOException -> L24
        thread.dumpService(tp.getWriteFd(), r, args);     // Catch: Throwable -> L26
        tp.setBufferPrefix(prefix + "    ");     // Catch: Throwable -> L26
        tp.go(fd);     // Catch: Throwable -> L26
        tp.kill();     // Catch: RemoteException -> L22 IOException -> L24
    L41:
        return;
    L26:
        th = move-exception;
        tp.kill();     // Catch: RemoteException -> L22 IOException -> L24
        throw th;     // Catch: RemoteException -> L22 IOException -> L24
    L24:
        e = move-exception;
        pw.println(prefix + "    Failure while dumping the service: " + e);
    L29:
        pw.println(prefix + "    Got a RemoteException while dumping the service");
        return;
    L40:
        return;
    L31:
        return;
    L9:
        pw.println("(not running)");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void setFgsRestrictionLocked(String callingPackage, int callingPid, int callingUid, Intent intent, ServiceRecord r, int userId, BackgroundStartPrivileges backgroundStartPrivileges, boolean isBindService) {
        setFgsRestrictionLocked(callingPackage, callingPid, callingUid, intent, r, userId, backgroundStartPrivileges, isBindService, false);
    }

    private void setFgsRestrictionLocked(String callingPackage, int callingPid, int callingUid, Intent intent, ServiceRecord r, int userId, BackgroundStartPrivileges backgroundStartPrivileges, boolean inBindService, boolean forBoundFgs) {
        if (inBindService == false) goto L5;
        int allowWiu = r.mAllowWiu_inBindService;
        int allowStart = r.mAllowStart_inBindService;
    L7:
        if (allowWiu == (-1)) goto L9;
        if (allowStart == (-1)) goto L9;
    L16:
        if (inBindService == false) goto L18;
        r.mAllowWiu_inBindService = allowWiu;
        r.mAllowStart_inBindService = allowStart;
        return;
    L18:
        if (forBoundFgs == true) goto L21;
        r.mAllowWiu_noBinding = allowWiu;
        r.mAllowStart_noBinding = allowStart;
    L27:
        if (r.mAllowWiu_byBindings != (-1)) goto L31;
        r.mAllowWiu_byBindings = shouldAllowFgsWhileInUsePermissionByBindingsLocked(callingUid);
    L31:
        if (r.mAllowStart_byBindings != (-1)) goto L35;
        r.mAllowStart_byBindings = r.mAllowWiu_byBindings;
        return;
    L35:
        return;
    L21:
        if (r.mAllowWiu_byBindings != (-1)) goto L24;
        r.mAllowWiu_byBindings = allowWiu;
    L24:
        if (r.mAllowStart_byBindings != (-1)) goto L27;
        r.mAllowStart_byBindings = allowStart;
    L9:
        int allowWhileInUse = shouldAllowFgsWhileInUsePermissionLocked(callingPackage, callingPid, callingUid, r.app, backgroundStartPrivileges);
        if (allowWiu != (-1)) goto L12;
        int allowWiu2 = allowWhileInUse;
    L13:
        if (allowStart != (-1)) goto L15;
        allowStart = shouldAllowFgsStartForegroundWithBindingCheckLocked(allowWhileInUse, callingPackage, callingPid, callingUid, intent, r, backgroundStartPrivileges, inBindService);
        allowWiu = allowWiu2;
        goto L16
    L15:
        allowWiu = allowWiu2;
        goto L16
    L12:
        allowWiu2 = allowWiu;
        goto L13
    L5:
        allowWiu = r.mAllowWiu_noBinding;
        allowStart = r.mAllowStart_noBinding;
        goto L7
    }

    void resetFgsRestrictionLocked(ServiceRecord r) {
        r.clearFgsAllowWiu();
        r.clearFgsAllowStart();
        r.mInfoAllowStartForeground = null;
        r.mInfoTempFgsAllowListReason = null;
        r.mLoggedInfoAllowStartForeground = false;
        r.updateAllowUiJobScheduling(r.isFgsAllowedWiu_forStart());
    }

    boolean canStartForegroundServiceLocked(int callingPid, int callingUid, String callingPackage) {
        if (this.mAm.mConstants.mFlagBackgroundFgsStartRestrictionEnabled == true) goto L5;
        return true;
    L5:
        int allowWhileInUse = shouldAllowFgsWhileInUsePermissionLocked(callingPackage, callingPid, callingUid, null, BackgroundStartPrivileges.NONE);
        int allowStartFgs = shouldAllowFgsStartForegroundNoBindingCheckLocked(allowWhileInUse, callingPid, callingUid, callingPackage, null, BackgroundStartPrivileges.NONE);
        if (allowStartFgs == (-1)) goto L8;
    L10:
        if (allowStartFgs != (-1)) goto L14;
        return false;
    L14:
        return true;
    L8:
        if (canBindingClientStartFgsLocked(callingUid) == null) goto L10;
        allowStartFgs = 54;
        goto L10
    }

    int shouldAllowFgsWhileInUsePermissionLocked(String callingPackage, int callingPid, final int callingUid, ProcessRecord targetProcess, BackgroundStartPrivileges backgroundStartPrivileges) {
        int ret = -1;
        int uidState = this.mAm.getUidStateLocked(callingUid);
        if ((-1) == (-1)) goto L5;
    L7:
        if (ret != (-1)) goto L11;
        boolean isCallingUidVisible = this.mAm.mAtmInternal.isUidForeground(callingUid);
        if (isCallingUidVisible == false) goto L11;
        ret = 50;
    L11:
        if (ret == (-1)) goto L13;
    L15:
        if (ret != (-1)) goto L22;
        int callingAppId = UserHandle.getAppId(callingUid);
        switch(callingAppId) {
            case 0: goto L19;
            case 1000: goto L19;
            case 1027: goto L19;
            case 2000: goto L19;
            default: goto L18;
        };
    L18:
        boolean isCallerSystem = false;
    L20:
        if (isCallerSystem == false) goto L22;
        ret = 51;
        goto L22
    L19:
        isCallerSystem = true;
    L22:
        if (ret != (-1)) goto L26;
        Integer allowedType = (Integer) this.mAm.mProcessList.searchEachLruProcessesLOSP(false, new ActiveServices$$ExternalSyntheticLambda7(callingUid));
        if (allowedType == null) goto L26;
        ret = allowedType.intValue();
    L26:
        if (ret == (-1)) goto L28;
    L31:
        if (ret != (-1)) goto L38;
        if (targetProcess == null) goto L38;
        ActiveInstrumentation instr = targetProcess.getActiveInstrumentation();
        if (instr == null) goto L38;
        if (instr.mHasBackgroundActivityStartsPermission == false) goto L38;
        ret = 60;
    L38:
        if (ret == (-1)) goto L40;
    L42:
        if (ret == (-1)) goto L44;
    L50:
        if (ret != (-1)) goto L55;
        boolean isDeviceOwner = this.mAm.mInternal.isDeviceOwner(callingUid);
        if (isDeviceOwner == false) goto L56;
        return 55;
    L56:
        return ret;
    L55:
        return ret;
    L44:
        if (verifyPackage(callingPackage, callingUid) == false) goto L49;
        boolean isAllowedPackage = this.mAllowListWhileInUsePermissionInFgs.contains(callingPackage);
        if (isAllowedPackage == false) goto L50;
        ret = 65;
        goto L50
    L49:
        EventLog.writeEvent(1397638484, new Object[]{"215003903", Integer.valueOf(callingUid), "callingPackage:" + callingPackage + " does not belong to callingUid:" + callingUid});
        goto L50
    L40:
        if (this.mAm.checkPermission("android.permission.START_ACTIVITIES_FROM_BACKGROUND", callingPid, callingUid) != 0) goto L42;
        ret = 58;
        goto L42
    L28:
        if (this.mAm.mInternal.isTempAllowlistedForFgsWhileInUse(callingUid) == false) goto L31;
        return 70;
    L13:
        if (backgroundStartPrivileges.allowsBackgroundActivityStarts() == false) goto L15;
        ret = 53;
        goto L15
    L5:
        if (uidState > 2) goto L7;
        ret = PowerExemptionManager.getReasonCodeFromProcState(uidState);
        goto L7
    }

    private static /* synthetic */ Integer lambda$shouldAllowFgsWhileInUsePermissionLocked$4(int callingUid, ProcessRecord pr) {
        if (pr.uid == callingUid) goto L5;
        return null;
    L5:
        if (pr.getWindowProcessController().areBackgroundFgsStartsAllowed() == true) goto L7;
        return null;
    L7:
        return 52;
    }

    private int shouldAllowFgsWhileInUsePermissionByBindingsLocked(final int callingUid) {
        final ArraySet<Integer> checkedClientUids = new ArraySet();
        Integer result = (Integer) this.mAm.mProcessList.searchEachLruProcessesLOSP(false, new ActiveServices$$ExternalSyntheticLambda8(this, callingUid, checkedClientUids));
        if (result != null) goto L6;
        return -1;
    L6:
        return result.intValue();
    }

    private /* synthetic */ Integer lambda$shouldAllowFgsWhileInUsePermissionByBindingsLocked$5(int callingUid, ArraySet checkedClientUids, ProcessRecord pr) {
        int r0 = callingUid;
        Integer r4 = null;
        if (pr.uid == r0) goto L5;
        return null;
    L5:
        ProcessServiceRecord psr = pr.mServices;
        int serviceCount = psr.mServices.size();
        int svc = 0;
    L6:
        if (svc >= serviceCount) goto L39;
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> conns = psr.mServices.valueAt(svc).getConnections();
        int size = conns.size();
        int conni = 0;
    L8:
        if (conni >= size) goto L37;
        ArrayList<ConnectionRecord> crs = conns.valueAt(conni);
        int con = 0;
    L11:
        if (con >= crs.size()) goto L36;
        ConnectionRecord cr = crs.get(con);
        ProcessRecord clientPr = cr.binding.client;
        int clientUid = clientPr.uid;
        if (clientUid == r0) goto L35;
        if (checkedClientUids.contains(Integer.valueOf(clientUid)) == true) goto L35;
        int clientUidState = this.mAm.getUidStateLocked(r0);
        boolean boundByPersistentWithBal = false;
        if (clientUidState != 2) goto L20;
        boolean boundByTop = true;
    L22:
        if (clientUidState < 2) goto L24;
    L28:
        if (boundByTop == true) goto L33;
        if (boundByPersistentWithBal == true) goto L33;
        checkedClientUids.add(Integer.valueOf(clientUid));
    L33:
        return Integer.valueOf(PowerExemptionManager.getReasonCodeFromProcState(clientUidState));
    L24:
        if (cr.hasFlag(1048576) == false) goto L28;
        boundByPersistentWithBal = true;
        goto L28
    L20:
        boundByTop = false;
    L35:
        con = con + 1;
        r0 = callingUid;
        r4 = r4;
        goto L11
    L36:
        conni = conni + 1;
        r0 = callingUid;
        goto L8
    L37:
        svc = svc + 1;
        r0 = callingUid;
        goto L6
    L39:
        return r4;
    }

    private String canBindingClientStartFgsLocked(final int uid) {
        final ArraySet<Integer> checkedClientUids = new ArraySet();
        Pair<Integer, String> isAllowed = (Pair) this.mAm.mProcessList.searchEachLruProcessesLOSP(false, new ActiveServices$$ExternalSyntheticLambda2(this, uid, checkedClientUids));
        if (isAllowed == null) goto L6;
        String bindFromPackage = (String) isAllowed.second;
        return bindFromPackage;
    L6:
        return null;
    }

    private /* synthetic */ Pair lambda$canBindingClientStartFgsLocked$6(int uid, ArraySet checkedClientUids, ProcessRecord pr) {
        int r0 = uid;
        if (pr.uid != r0) goto L28;
        ProcessServiceRecord psr = pr.mServices;
        int serviceCount = psr.mServices.size();
        int svc = 0;
    L5:
        if (svc >= serviceCount) goto L38;
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> conns = psr.mServices.valueAt(svc).getConnections();
        int size = conns.size();
        int conni = 0;
    L7:
        if (conni >= size) goto L27;
        ArrayList<ConnectionRecord> crs = conns.valueAt(conni);
        int con = 0;
    L10:
        if (con >= crs.size()) goto L26;
        ConnectionRecord cr = crs.get(con);
        ProcessRecord clientPr = cr.binding.client;
        if (clientPr.isPersistent() == true) goto L25;
        int clientPid = clientPr.mPid;
        int clientUid = clientPr.uid;
        if (clientUid == r0) goto L25;
        if (checkedClientUids.contains(Integer.valueOf(clientUid)) == true) goto L25;
        String clientPackageName = cr.clientPackageName;
        int allowWhileInUse2 = shouldAllowFgsWhileInUsePermissionLocked(clientPackageName, clientPid, clientUid, null, BackgroundStartPrivileges.NONE);
        int allowStartFgs = shouldAllowFgsStartForegroundNoBindingCheckLocked(allowWhileInUse2, clientPid, clientUid, clientPackageName, null, BackgroundStartPrivileges.NONE);
        if (allowStartFgs != (-1)) goto L22;
        checkedClientUids.add(Integer.valueOf(clientUid));
        goto L25
    L22:
        return new Pair(Integer.valueOf(allowStartFgs), clientPackageName);
    L25:
        con = con + 1;
        r0 = uid;
        goto L10
    L26:
        conni = conni + 1;
        r0 = uid;
        goto L7
    L27:
        svc = svc + 1;
        r0 = uid;
        goto L5
    L38:
        return null;
    L28:
        return null;
    }

    private int shouldAllowFgsStartForegroundWithBindingCheckLocked(int allowWhileInUse, String callingPackage, int callingPid, int callingUid, Intent intent, ServiceRecord r, BackgroundStartPrivileges backgroundStartPrivileges, boolean isBindService) {
        ActivityManagerService.FgsTempAllowListItem tempAllowListReason = this.mAm.isAllowlistedForFgsStartLOSP(callingUid);
        r.mInfoTempFgsAllowListReason = tempAllowListReason;
        int ret = shouldAllowFgsStartForegroundNoBindingCheckLocked(allowWhileInUse, callingPid, callingUid, callingPackage, r, backgroundStartPrivileges);
        if (ret != (-1)) goto L8;
        String bindFromPackage = canBindingClientStartFgsLocked(callingUid);
        if (bindFromPackage == null) goto L7;
        String bindFromPackage2 = bindFromPackage;
        int ret2 = 54;
    L9:
        int uidState = this.mAm.getUidStateLocked(callingUid);
        int callerTargetSdkVersion = -1;
        callerTargetSdkVersion = this.mAm.mContext.getPackageManager().getTargetSdkVersion(callingPackage);     // Catch: PackageManager.NameNotFoundException -> L12
    L14:
        if ((this.mAm.getUidProcessCapabilityLocked(callingUid) & 16) == 0) goto L16;
        boolean uidBfsl = true;
    L17:
        StringBuilder r11 = new StringBuilder();
        r11.append("[callingPackage: ");
        r11.append(callingPackage);
        r11.append("; callingUid: ");
        r11.append(callingUid);
        r11.append("; uidState: ");
        r11.append(ProcessList.makeProcStateString(uidState));
        r11.append("; uidBFSL: ");
        if (uidBfsl == false) goto L20;
        String r12 = "[BFSL]";
    L21:
        r11.append(r12);
        r11.append("; intent: ");
        r11.append(intent);
        r11.append("; code:");
        r11.append(PowerExemptionManager.reasonCodeToString(ret2));
        r11.append("; tempAllowListReason:<");
        if (tempAllowListReason != null) goto L24;
        String r13 = null;
    L25:
        r11.append(r13);
        r11.append(">; allowWiu:");
        r11.append(allowWhileInUse);
        r11.append("; targetSdkVersion:");
        r11.append(r.appInfo.targetSdkVersion);
        r11.append("; callerTargetSdkVersion:");
        r11.append(callerTargetSdkVersion);
        r11.append("; startForegroundCount:");
        r11.append(r.mStartForegroundCount);
        r11.append("; bindFromPackage:");
        r11.append(bindFromPackage2);
        r11.append(": isBindService:");
        r11.append(isBindService);
        r11.append("]");
        String debugInfo = r11.toString();
        if (debugInfo.equals(r.mInfoAllowStartForeground) == true) goto L28;
        r.mLoggedInfoAllowStartForeground = false;
        r.mInfoAllowStartForeground = debugInfo;
    L28:
        return ret2;
    L24:
        r13 = tempAllowListReason.mReason + ",reasonCode:" + PowerExemptionManager.reasonCodeToString(tempAllowListReason.mReasonCode) + ",duration:" + tempAllowListReason.mDuration + ",callingUid:" + tempAllowListReason.mCallingUid;
        goto L25
    L20:
        r12 = "n/a";
        goto L21
    L16:
        uidBfsl = false;
        goto L17
    L7:
        bindFromPackage2 = bindFromPackage;
        ret2 = ret;
        goto L9
    L8:
        bindFromPackage2 = null;
        ret2 = ret;
        goto L9
    }

    private int shouldAllowFgsStartForegroundNoBindingCheckLocked(int allowWhileInUse, int callingPid, final int callingUid, String callingPackage, ServiceRecord targetService, BackgroundStartPrivileges backgroundStartPrivileges) {
        int ret = allowWhileInUse;
        if (ret != (-1)) goto L8;
        int uidState = this.mAm.getUidStateLocked(callingUid);
        if (uidState > 2) goto L8;
        ret = PowerExemptionManager.getReasonCodeFromProcState(uidState);
    L8:
        if (ret == (-1)) goto L10;
    L16:
        if (ret == (-1)) goto L18;
    L20:
        if (ret == (-1)) goto L22;
    L24:
        if (ret == (-1)) goto L26;
    L41:
        if (ret != (-1)) goto L49;
        boolean isCompanionApp = this.mAm.mInternal.isAssociatedCompanionApp(UserHandle.getUserId(callingUid), callingUid);
        if (isCompanionApp == false) goto L49;
        if (isPermissionGranted("android.permission.REQUEST_COMPANION_START_FOREGROUND_SERVICES_FROM_BACKGROUND", callingPid, callingUid) == false) goto L47;
    L48:
        ret = 57;
        goto L49
    L47:
        if (isPermissionGranted("android.permission.REQUEST_COMPANION_RUN_IN_BACKGROUND", callingPid, callingUid) == true) goto L48;
    L49:
        if (ret != (-1)) goto L56;
        ActivityManagerService.FgsTempAllowListItem item = this.mAm.isAllowlistedForFgsStartLOSP(callingUid);
        if (item == null) goto L56;
        if (item != ActivityManagerService.FAKE_TEMP_ALLOW_LIST_ITEM) goto L55;
        ret = 300;
        goto L56
    L55:
        ret = item.mReasonCode;
    L56:
        if (ret == (-1)) goto L58;
    L60:
        if (ret != (-1)) goto L64;
        boolean isProfileOwner = this.mAm.mInternal.isProfileOwner(callingUid);
        if (isProfileOwner == false) goto L64;
        ret = 56;
    L64:
        if (ret != (-1)) goto L70;
        AppOpsManager appOpsManager = this.mAm.getAppOpsManager();
        if (this.mAm.mConstants.mFlagSystemExemptPowerRestrictionsEnabled == false) goto L70;
        if (appOpsManager.checkOpNoThrow(128, callingUid, callingPackage) != 0) goto L70;
        ret = 327;
    L70:
        if (ret != (-1)) goto L77;
        AppOpsManager appOpsManager2 = this.mAm.getAppOpsManager();
        if (appOpsManager2.checkOpNoThrow(47, callingUid, callingPackage) != 0) goto L75;
        ret = 68;
        goto L77
    L75:
        if (appOpsManager2.checkOpNoThrow(94, callingUid, callingPackage) != 0) goto L77;
        ret = 69;
    L77:
        if (ret != (-1)) goto L85;
        String inputMethod = Settings.Secure.getStringForUser(this.mAm.mContext.getContentResolver(), "default_input_method", UserHandle.getUserId(callingUid));
        if (inputMethod == null) goto L85;
        ComponentName cn = ComponentName.unflattenFromString(inputMethod);
        if (cn == null) goto L85;
        if (cn.getPackageName().equals(callingPackage) == false) goto L85;
        ret = 71;
    L85:
        if (ret == (-1)) goto L87;
        return ret;
    L87:
        if (this.mAm.mConstants.mFgsAllowOptOut == false) goto L98;
        if (targetService != null) goto L90;
        return ret;
    L90:
        if (targetService.appInfo.hasRequestForegroundServiceExemption() == false) goto L100;
        return 1000;
    L100:
        return ret;
    L98:
        return ret;
    L58:
        if (UserManager.isDeviceInDemoMode(this.mAm.mContext) == false) goto L60;
        ret = 63;
        goto L60
    L26:
        if (this.mAm.mAtmInternal.hasSystemAlertWindowPermission(callingUid, callingPid, callingPackage) == false) goto L41;
        if (CompatChanges.isChangeEnabled(FGS_SAW_RESTRICTIONS, callingUid) == false) goto L40;
        UidRecord uidRecord = this.mAm.mProcessList.getUidRecordLOSP(callingUid);
        if (uidRecord == null) goto L41;
        int i = uidRecord.getNumOfProcs() - 1;
    L32:
        if (i < 0) goto L41;
        ProcessRecord pr = uidRecord.getProcessRecordByIndex(i);
        if (pr == null) goto L38;
        if (pr.mState.hasOverlayUi() == false) goto L38;
        ret = 62;
    L38:
        i = i - 1;
        goto L32
    L40:
        ret = 62;
        goto L41
    L22:
        if (backgroundStartPrivileges.allowsBackgroundFgsStarts() == false) goto L24;
        ret = 53;
        goto L24
    L18:
        if (this.mAm.checkPermission("android.permission.START_FOREGROUND_SERVICES_FROM_BACKGROUND", callingPid, callingUid) != 0) goto L20;
        ret = 59;
        goto L20
    L10:
        if ((this.mAm.getUidProcessCapabilityLocked(callingUid) & 16) == 0) goto L12;
        final boolean uidBfsl = true;
    L13:
        Integer allowedType = (Integer) this.mAm.mProcessList.searchEachLruProcessesLOSP(false, new ActiveServices$$ExternalSyntheticLambda5(this, callingUid, uidBfsl));
        if (allowedType == null) goto L16;
        ret = allowedType.intValue();
        goto L16
    L12:
        uidBfsl = false;
        goto L13
    }

    private /* synthetic */ Integer lambda$shouldAllowFgsStartForegroundNoBindingCheckLocked$7(int callingUid, boolean uidBfsl, ProcessRecord app) {
        if (app.uid != callingUid) goto L26;
        ProcessStateRecord state = app.mState;
        int procstate = state.getCurProcState();
        if (procstate <= 3) goto L25;
        if (uidBfsl == true) goto L8;
    L10:
        ActiveInstrumentation instr = app.getActiveInstrumentation();
        if (instr != null) goto L13;
    L16:
        long lastInvisibleTime = app.mState.getLastInvisibleTime();
        if (lastInvisibleTime > 0) goto L19;
        return null;
    L19:
        if (lastInvisibleTime >= Long.MAX_VALUE) goto L29;
        long sinceLastInvisible = SystemClock.elapsedRealtime() - lastInvisibleTime;
        if (sinceLastInvisible < this.mAm.mConstants.mFgToBgFgsGraceDuration) goto L23;
        return null;
    L23:
        return 67;
    L29:
        return null;
    L13:
        if (instr.mHasBackgroundForegroundServiceStartsPermission == false) goto L16;
        return 61;
    L8:
        if (procstate > 5) goto L10;
    L25:
        return Integer.valueOf(PowerExemptionManager.getReasonCodeFromProcState(procstate));
    L26:
        return null;
    }

    private boolean isPermissionGranted(String permission, int callingPid, int callingUid) {
        if (this.mAm.checkPermission(permission, callingPid, callingUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isFgsBgStart(int code) {
        if (code != 10) goto L5;
    L11:
        return false;
    L5:
        if (code == 11) goto L11;
        if (code == 12) goto L11;
        if (code == 50) goto L11;
        return true;
    }

    private void showFgsBgRestrictedNotificationLocked(ServiceRecord r) {
        if (this.mAm.mConstants.mFgsStartRestrictionNotificationEnabled == true) goto L5;
        return;
    L5:
        Context context = this.mAm.mContext;
        String content = "App restricted: " + r.mRecentCallingPackage;
        long now = System.currentTimeMillis();
        String bigText = DATE_FORMATTER.format(Long.valueOf(now)) + " " + r.mInfoAllowStartForeground;
        Notification.Builder n = new Notification.Builder(context, "ALERTS").setGroup("com.android.fgs-bg-restricted").setSmallIcon(17305251).setWhen(0).setColor(context.getColor(R.color.system_notification_accent_color)).setTicker("Foreground Service BG-Launch Restricted").setContentTitle("Foreground Service BG-Launch Restricted").setContentText(content).setStyle(new Notification.BigTextStyle().bigText(bigText));
        ((NotificationManager) context.getSystemService(NotificationManager.class)).notifyAsUser(Long.toString(now), 61, n.build(), UserHandle.ALL);
    }

    private boolean isBgFgsRestrictionEnabled(ServiceRecord r, int actualCallingUid) {
        if (this.mAm.mConstants.mFlagFgsStartRestrictionEnabled == true) goto L6;
        return false;
    L6:
        if (CompatChanges.isChangeEnabled(FGS_BG_START_RESTRICTION_CHANGE_ID, r.appInfo.uid) == true) goto L9;
        return false;
    L9:
        if (this.mAm.mConstants.mFgsStartRestrictionCheckCallerTargetSdk == true) goto L12;
        return true;
    L12:
        if (actualCallingUid != 1000) goto L15;
        return true;
    L15:
        if (CompatChanges.isChangeEnabled(FGS_BG_START_RESTRICTION_CHANGE_ID, actualCallingUid) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private void logFgsBackgroundStart(ServiceRecord r) {
        if (r.mLoggedInfoAllowStartForeground == true) goto L21;
        StringBuilder r0 = new StringBuilder();
        r0.append("Background started FGS: ");
        if (r.isFgsAllowedStart() == false) goto L7;
        String r1 = "Allowed ";
    L8:
        r0.append(r1);
        r0.append(r.mInfoAllowStartForeground);
        if (r.isShortFgs() == false) goto L11;
        String r2 = " (Called on SHORT_SERVICE)";
    L12:
        r0.append(r2);
        String msg = r0.toString();
        if (r.isFgsAllowedStart() == true) goto L15;
        Slog.wtfQuiet("ActivityManager", msg);
        Slog.w("ActivityManager", msg);
    L19:
        r.mLoggedInfoAllowStartForeground = true;
        return;
    L15:
        if (ActivityManagerUtils.shouldSamplePackageForAtom(r.packageName, this.mAm.mConstants.mFgsStartAllowedLogSampleRate) == false) goto L17;
        Slog.wtfQuiet("ActivityManager", msg);
    L17:
        Slog.i("ActivityManager", msg);
        goto L19
    L11:
        r2 = "";
        goto L12
    L7:
        r1 = "Disallowed ";
        goto L8
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    private void logFGSStateChangeLocked(ServiceRecord r43, int r44, int r45, int r46, int r47, int r48, boolean r49) {
        if (ActivityManagerUtils.shouldSamplePackageForAtom(r43.packageName, this.mAm.mConstants.mFgsAtomSampleRate) == true) goto L6;
        return;
    L6:
        if (r44 == 1) goto L11;
        if (r44 == 2) goto L11;
        if (r44 == 5) goto L11;
        boolean r6 = r43.isFgsAllowedWiu_forCapabilities();
        int r7 = r43.getFgsAllowStart();
        ?? r8 = r6;
    L13:
        if (r43.mRecentCallerApplicationInfo == null) goto L15;
        int r10 = r43.mRecentCallerApplicationInfo.targetSdkVersion;
    L16:
        int r9 = r43.appInfo.uid;
        String r4 = r43.shortInstanceName;
        int r12 = r43.appInfo.targetSdkVersion;
        int r11 = r43.mRecentCallingUid;
        if (r43.mInfoTempFgsAllowListReason == null) goto L19;
        int r14 = r43.mInfoTempFgsAllowListReason.mCallingUid;
    L20:
        boolean r13 = r43.mFgsNotificationWasDeferred;
        boolean r15 = r43.mFgsNotificationShown;
        int r16 = r43.mStartForegroundCount;
        boolean r2 = r43.mFgsHasNotificationPermission;
        int r17 = r43.foregroundServiceType;
        boolean r3 = r43.mIsFgsDelegate;
        if (r43.mFgsDelegation == null) goto L23;
        int r5 = r43.mFgsDelegation.mOptions.mClientUid;
    L24:
        int r18 = r5;
        if (r43.mFgsDelegation == null) goto L27;
        int r19 = r43.mFgsDelegation.mOptions.mDelegationService;
    L28:
        FrameworkStatsLog.write(60, r9, r4, r44, r8, r7, r12, r11, r10, r14, r13, r15, r45, r16, 0, r2, r17, r47, r3, r18, r19, 0, null, null, this.mAm.getUidStateLocked(r43.appInfo.uid), this.mAm.getUidProcessCapabilityLocked(r43.appInfo.uid), this.mAm.getUidStateLocked(r43.mRecentCallingUid), this.mAm.getUidProcessCapabilityLocked(r43.mRecentCallingUid), 0, 0, r43.mAllowWiu_noBinding, r43.mAllowWiu_inBindService, r43.mAllowWiu_byBindings, r43.mAllowStart_noBinding, r43.mAllowStart_inBindService, r43.mAllowStart_byBindings, r48, r49);
        if (r44 != 1) goto L32;
        int r20 = EventLogTags.AM_FOREGROUND_SERVICE_START;
    L41:
        if (r20 != 30100) goto L44;
        SysOptBridge.getFactory().getAppRecordManagerService().fgServiceEvent(r43, true);
    L46:
        EventLog.writeEvent(r20, new Object[]{Integer.valueOf(r43.userId), r43.shortInstanceName, Integer.valueOf(r8), PowerExemptionManager.reasonCodeToString(r7), Integer.valueOf(r43.appInfo.targetSdkVersion), Integer.valueOf(r10), Integer.valueOf(r43.mFgsNotificationWasDeferred ? 1 : 0), Integer.valueOf(r43.mFgsNotificationShown ? 1 : 0), Integer.valueOf(r45), Integer.valueOf(r43.mStartForegroundCount), fgsStopReasonToString(r46), Integer.valueOf(r43.foregroundServiceType)});
        return;
    L44:
        if (r20 != 30102) goto L46;
        SysOptBridge.getFactory().getAppRecordManagerService().fgServiceEvent(r43, false);
        goto L46
    L32:
        if (r44 != 2) goto L35;
        r20 = EventLogTags.AM_FOREGROUND_SERVICE_STOP;
        goto L41
    L35:
        if (r44 != 3) goto L38;
        r20 = EventLogTags.AM_FOREGROUND_SERVICE_DENIED;
        goto L41
    L38:
        if (r44 != 5) goto L48;
        r20 = EventLogTags.AM_FOREGROUND_SERVICE_TIMED_OUT;
        goto L41
    L48:
        return;
    L27:
        r19 = 0;
        goto L28
    L23:
        r5 = -1;
        goto L24
    L19:
        r14 = -1;
        goto L20
    L15:
        r10 = 0;
    L11:
        boolean r21 = r43.mAllowWhileInUsePermissionInFgsAtEntering;
        r7 = r43.mAllowStartForegroundAtEntering;
        r8 = r21;
        goto L13
    }

    private void updateNumForegroundServicesLocked() {
        sNumForegroundServices.set(this.mAm.mProcessList.getNumForegroundServices());
    }

    boolean canAllowWhileInUsePermissionInFgsLocked(int callingPid, int callingUid, String callingPackage) {
        if (shouldAllowFgsWhileInUsePermissionLocked(callingPackage, callingPid, callingUid, null, BackgroundStartPrivileges.NONE) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean canAllowWhileInUsePermissionInFgsLocked(int callingPid, int callingUid, String callingPackage, ProcessRecord targetProcess, BackgroundStartPrivileges backgroundStartPrivileges) {
        if (shouldAllowFgsWhileInUsePermissionLocked(callingPackage, callingPid, callingUid, targetProcess, backgroundStartPrivileges) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean verifyPackage(String packageName, int uid) {
        if (uid != 0) goto L4;
        return true;
    L4:
        if (uid != 1000) goto L7;
        return true;
    L7:
        return this.mAm.getPackageManagerInternal().isSameApp(packageName, uid, UserHandle.getUserId(uid));
    }

    private static String fgsStopReasonToString(int stopReason) {
        switch(stopReason) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "STOP_SERVICE";
    L7:
        return "STOP_FOREGROUND";
    }

    boolean startForegroundServiceDelegateLocked(ForegroundServiceDelegationOptions options, final ServiceConnection connection) {
        Slog.v("ActivityManager", "startForegroundServiceDelegateLocked " + options.getDescription());
        final ComponentName cn = options.getComponentName();
        int i = this.mFgsDelegations.size() - 1;
    L4:
        if (i < 0) goto L10;
        if (this.mFgsDelegations.keyAt(i).mOptions.isSameDelegate(options) == true) goto L7;
        i = i - 1;
        goto L4
    L7:
        Slog.e("ActivityManager", "startForegroundServiceDelegate " + options.getDescription() + " already exists, multiple connections are not allowed");
        return false;
    L10:
        int callingPid = options.mClientPid;
        int callingUid = options.mClientUid;
        int userId = UserHandle.getUserId(callingUid);
        String callingPackage = options.mClientPackageName;
        if (canStartForegroundServiceLocked(callingPid, callingUid, callingPackage) == true) goto L14;
        Slog.d("ActivityManager", "startForegroundServiceDelegateLocked aborted, app is in the background");
        return false;
    L14:
        IApplicationThread caller = options.mClientAppThread;
        if (caller == null) goto L17;
        IApplicationThread caller2 = caller;
        ProcessRecord callerApp = this.mAm.getRecordForAppLOSP(caller);
    L27:
        if (callerApp == null) goto L80;
        Intent intent = new Intent();
        intent.setComponent(cn);
        ProcessRecord callerApp2 = callerApp;
        IApplicationThread caller3 = caller2;
        ServiceLookupResult res = retrieveServiceLocked(intent, null, false, -1, null, null, callingPackage, callingPid, callingUid, userId, true, false, false, false, options, false, false);
        if (res != null) goto L31;
        boolean r8 = false;
    L77:
        Slog.d("ActivityManager", "startForegroundServiceDelegateLocked retrieveServiceLocked returns null");
        return r8;
    L31:
        if (res.record != null) goto L33;
        r8 = false;
        goto L77
    L33:
        ServiceRecord r = res.record;
        r.setProcess(callerApp2, caller3, callingPid, null);
        r.mIsFgsDelegate = true;
        final ForegroundServiceDelegation delegation = new ForegroundServiceDelegation(options, connection);
        r.mFgsDelegation = delegation;
        this.mFgsDelegations.put(delegation, r);
        this.mAm.mProcessStateController.setIsForegroundService(r, true);
        r.mFgsEnterTime = SystemClock.uptimeMillis();
        this.mAm.mProcessStateController.setForegroundServiceType(r, options.mForegroundServiceTypes);
        r.updateOomAdjSeq();
        setFgsRestrictionLocked(callingPackage, callingPid, callingUid, intent, r, userId, BackgroundStartPrivileges.NONE, false);
        ProcessServiceRecord psr = callerApp2.mServices;
        this.mAm.mProcessStateController.startService(psr, r);
        updateServiceForegroundLocked(psr, true);
        Object r5 = this.mAm.mProcessStats.mLock;
        monitor-enter(r5);
        ServiceState stracker = r.getTracker();     // Catch: Throwable -> L70
        if (stracker == null) goto L95;
        stracker.setForeground(true, this.mAm.mProcessStats.getMemFactorLocked(), SystemClock.uptimeMillis());     // Catch: Throwable -> L41
    L41:
        th = th;
    L87:
        monitor-exit(r5);     // Catch: Throwable -> L74
        throw th;
    L74:
        th = th;
    L43:
        th = th;
    L95:
        monitor-exit(r5);     // Catch: Throwable -> L68
        this.mAm.mBatteryStatsService.noteServiceStartRunning(callingUid, callingPackage, cn.getClassName());
        this.mAm.mAppOpsService.startOperation(AppOpsManager.getToken(this.mAm.mAppOpsService), 76, r.appInfo.uid, r.packageName, null, true, false, null, false, 0, -1);
        registerAppOpCallbackLocked(r);
        ForegroundServiceTypeLoggerModule r4 = this.mFGSLogger;
        monitor-enter(r4);
        this.mFGSLogger.logForegroundServiceStart(r.appInfo.uid, 0, r);     // Catch: Throwable -> L62
        monitor-exit(r4);     // Catch: Throwable -> L62
        logFGSStateChangeLocked(r, 1, 0, 0, 0, 4, false);
        if (connection == null) goto L55;
        this.mAm.mHandler.post(new ActiveServices$$ExternalSyntheticLambda4(connection, cn, delegation));
    L55:
        signalForegroundServiceObserversLocked(r);
        if (r.foregroundId != 0) goto L58;
    L60:
        return true;
    L58:
        if (r.foregroundNoti == null) goto L60;
        r.foregroundNoti.flags |= 64;
        r.postNotification(true);
        return true;
    L62:
        th = th;
    L93:
        throw th;
    L66:
        th = th;
    L68:
        th = th;
    L70:
        th = th;
        goto L87
    L80:
        throw new SecurityException("Unable to find app for caller " + caller2 + " (pid=" + callingPid + ") when startForegroundServiceDelegateLocked " + cn);
    L17:
        ActivityManagerService.PidMap r9 = this.mAm.mPidsSelfLocked;
        monitor-enter(r9);
        ProcessRecord callerApp3 = this.mAm.mPidsSelfLocked.get(callingPid);     // Catch: Throwable -> L81
        if (callerApp3 != null) goto L105;
    L25:
        monitor-exit(r9);     // Catch: Throwable -> L81
        caller2 = caller;
        callerApp = callerApp3;
        goto L27
    L105:
        caller = callerApp3.getThread();     // Catch: Throwable -> L23
    L23:
        th = th;
    L99:
        monitor-exit(r9);     // Catch: Throwable -> L85
        throw th;
    L85:
        th = th;
    L81:
        th = th;
        goto L99
    }

    private static /* synthetic */ void lambda$startForegroundServiceDelegateLocked$8(ServiceConnection connection, ComponentName cn, ForegroundServiceDelegation delegation) {
        connection.onServiceConnected(cn, delegation.mBinder);
    }

    void stopForegroundServiceDelegateLocked(ForegroundServiceDelegationOptions options) {
        ServiceRecord r = null;
        int i = this.mFgsDelegations.size();
    L3:
        i = i - 1;
        if (i < 0) goto L9;
        if (this.mFgsDelegations.keyAt(i).mOptions.isSameDelegate(options) == false) goto L3;
        Slog.d("ActivityManager", "stopForegroundServiceDelegateLocked " + options.getDescription());
        ServiceRecord r2 = this.mFgsDelegations.valueAt(i);
        r = r2;
    L9:
        if (r == null) goto L11;
        r.updateOomAdjSeq();
        bringDownServiceLocked(r, false);
        return;
    L11:
        Slog.e("ActivityManager", "stopForegroundServiceDelegateLocked delegate does not exist " + options.getDescription());
    }

    void stopForegroundServiceDelegateLocked(ServiceConnection connection) {
        ServiceRecord r = null;
        int i = this.mFgsDelegations.size();
    L3:
        i = i - 1;
        if (i < 0) goto L9;
        ForegroundServiceDelegation d = this.mFgsDelegations.keyAt(i);
        if (d.mConnection != connection) goto L3;
        Slog.d("ActivityManager", "stopForegroundServiceDelegateLocked " + d.mOptions.getDescription());
        ServiceRecord r2 = this.mFgsDelegations.valueAt(i);
        r = r2;
    L9:
        if (r == null) goto L11;
        r.updateOomAdjSeq();
        bringDownServiceLocked(r, false);
        return;
    L11:
        Slog.e("ActivityManager", "stopForegroundServiceDelegateLocked delegate does not exist");
    }

    void notifyActiveMediaForegroundServiceLocked(String packageName, int userId, int notificationId) {
    }

    void notifyInactiveMediaForegroundServiceLocked(String packageName, int userId, int notificationId) {
    }

    private static void getClientPackages(ServiceRecord sr, ArraySet<String> output) {
        ArrayMap<IBinder, ArrayList<ConnectionRecord>> connections = sr.getConnections();
        int conni = connections.size() - 1;
    L3:
        if (conni < 0) goto L12;
        ArrayList<ConnectionRecord> connl = connections.valueAt(conni);
        int i = 0;
        int size = connl.size();
    L5:
        if (i >= size) goto L10;
        ConnectionRecord conn = connl.get(i);
        if (conn.binding.client == null) goto L9;
        output.add(conn.binding.client.info.packageName);
    L9:
        i = i + 1;
        goto L5
    L10:
        conni = conni - 1;
        goto L3
    }

    ArraySet<String> getClientPackagesLocked(String servicePackageName) {
        ArraySet<String> results = new ArraySet();
        int[] users = this.mAm.mUserController.getUsers();
        int ui = 0;
    L4:
        if (ui >= users.length) goto L13;
        ArrayMap<ComponentName, ServiceRecord> alls = getServicesLocked(users[ui]);
        int i = 0;
        int size = alls.size();
    L6:
        if (i >= size) goto L11;
        ServiceRecord sr = alls.valueAt(i);
        if (sr.name.getPackageName().equals(servicePackageName) == false) goto L10;
        getClientPackages(sr, results);
    L10:
        i = i + 1;
        goto L6
    L11:
        ui = ui + 1;
        goto L4
    L13:
        return results;
    }

    private boolean isDeviceProvisioningPackage(String packageName) {
        if (this.mCachedDeviceProvisioningPackage != null) goto L6;
        this.mCachedDeviceProvisioningPackage = this.mAm.mContext.getResources().getString(R.string.config_mainDisplayShape);
    L6:
        if (this.mCachedDeviceProvisioningPackage != null) goto L8;
    L10:
        return false;
    L8:
        if (this.mCachedDeviceProvisioningPackage.equals(packageName) == false) goto L10;
        return true;
    }
}

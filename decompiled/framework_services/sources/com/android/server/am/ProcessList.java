package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.app.ApplicationExitInfo;
import android.app.IApplicationThread;
import android.app.IProcessObserver;
import android.app.SysMonitorFwBridge;
import android.app.UidObserver;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.net.NetworkPolicyManager;
import android.os.AppZygote;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.ProcessSmtEx;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.storage.StorageManagerInternal;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.DebugUtils;
import android.util.EventLog;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.ProcessMap;
import com.android.internal.os.Zygote;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DoppelgangerUtils;
import com.android.internal.util.MemInfoReader;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemConfig;
import com.android.server.Watchdog;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.compat.PlatformCompat;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.resmng.IResMngConfig;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.wm.ActivityServiceConnectionsHolder;
import com.android.server.wm.ActivityTaskManagerService;
import com.android.server.wm.WindowManagerService;
import com.android.server.wm.WindowProcessController;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessList {
    public static final int ACTION_ADJUST = 50;
    public static final int ACTION_RECOVER = 100;
    static final String ANDROID_APP_DATA_ISOLATION_ENABLED_PROPERTY = "persist.zygote.app_data_isolation";
    static final String ANDROID_VOLD_APP_DATA_ISOLATION_ENABLED_PROPERTY = "persist.sys.vold_app_data_isolation_enabled";
    private static final String APPLY_SDK_SANDBOX_AUDIT_RESTRICTIONS = ":isSdkSandboxAudit";
    private static final String APPLY_SDK_SANDBOX_NEXT_RESTRICTIONS = ":isSdkSandboxNext";
    private static final long APP_DATA_DIRECTORY_ISOLATION = 143937733;
    public static final int BACKUP_APP_ADJ = 300;
    public static final int CACHED_APP_IMPORTANCE_LEVELS = 5;
    public static final int CACHED_APP_LMK_FIRST_ADJ = 950;
    public static final int CACHED_APP_MAX_ADJ = 999;
    public static final int CACHED_APP_MIN_ADJ = 900;
    private static final boolean DEFAULT_APPLY_SDK_SANDBOX_AUDIT_RESTRICTIONS = false;
    private static final boolean DEFAULT_APPLY_SDK_SANDBOX_NEXT_RESTRICTIONS = false;
    public static final int FOREGROUND_APP_ADJ = 0;
    public static final int HEAVY_WEIGHT_APP_ADJ = 400;
    public static final int HOME_APP_ADJ = 600;
    public static final int INVALID_ADJ = -10000;
    private static final long LMKD_RECONNECT_DELAY_MS = 1000;
    static final int LMK_ASYNC_EVENT_KILL = 0;
    static final int LMK_ASYNC_EVENT_STAT = 1;
    static final byte LMK_BOOT_COMPLETED = 10;
    static final byte LMK_GETKILLCNT = 4;
    static final byte LMK_KILL_OCCURRED = 8;
    static final byte LMK_PROCKILL = 6;
    static final byte LMK_PROCPRIO = 1;
    static final byte LMK_PROCPURGE = 3;
    static final byte LMK_PROCREMOVE = 2;
    static final byte LMK_PROCS_PRIO = 11;
    static final byte LMK_START_MONITORING = 9;
    static final byte LMK_SUBSCRIBE = 5;
    static final byte LMK_TARGET = 0;
    static final byte LMK_UPDATE_PROPS = 7;
    private static final int MAX_OOM_ADJ_BATCH_LENGTH = 52;
    private static final int MAX_PROCS_PRIO_PACKET_SIZE = 3;
    private static final int MAX_ZYGOTE_UNSOLICITED_MESSAGE_SIZE = 16;
    static final int MIN_CACHED_APPS = 2;
    public static final int NATIVE_ADJ = -1000;
    static final int NETWORK_STATE_BLOCK = 1;
    static final int NETWORK_STATE_NO_CHANGE = 0;
    static final int NETWORK_STATE_UNBLOCK = 2;
    public static final int OOM_ADJEXT_MAX = 100;
    public static final int OOM_ADJEXT_MIN = 0;
    static final int PAGE_SIZE = 0;
    public static final int PERCEPTIBLE_APP_ADJ = 200;
    public static final int PERCEPTIBLE_LOW_APP_ADJ = 250;
    public static final int PERCEPTIBLE_MEDIUM_APP_ADJ = 225;
    public static final int PERCEPTIBLE_RECENT_FOREGROUND_APP_ADJ = 50;
    public static final int PERSISTENT_PROC_ADJ = -800;
    public static final int PERSISTENT_SERVICE_ADJ = -700;
    public static final int PREVIOUS_APP_ADJ = 700;
    public static final int PREVIOUS_APP_MAX_ADJ = 0;
    public static final int PROC_MEM_CACHED = 4;
    public static final int PROC_MEM_IMPORTANT = 2;
    public static final int PROC_MEM_NUM = 5;
    public static final int PROC_MEM_PERSISTENT = 0;
    public static final int PROC_MEM_SERVICE = 3;
    public static final int PROC_MEM_TOP = 1;
    static final int PROC_TYPE_ADJUST_WL = 4;
    static final int PROC_TYPE_APP_EXT = 3;
    private static final String PROPERTY_APPLY_SDK_SANDBOX_AUDIT_RESTRICTIONS = "apply_sdk_sandbox_audit_restrictions";
    private static final String PROPERTY_APPLY_SDK_SANDBOX_NEXT_RESTRICTIONS = "apply_sdk_sandbox_next_restrictions";
    private static final String PROPERTY_USE_APP_IMAGE_STARTUP_CACHE = "persist.device_config.runtime_native.use_app_image_startup_cache";
    public static final int PSS_ALL_INTERVAL = 1200000;
    private static final int PSS_FIRST_ASLEEP_BACKGROUND_INTERVAL = 30000;
    private static final int PSS_FIRST_ASLEEP_CACHED_INTERVAL = 60000;
    private static final int PSS_FIRST_ASLEEP_PERSISTENT_INTERVAL = 60000;
    private static final int PSS_FIRST_ASLEEP_TOP_INTERVAL = 20000;
    private static final int PSS_FIRST_BACKGROUND_INTERVAL = 20000;
    private static final int PSS_FIRST_CACHED_INTERVAL = 20000;
    private static final int PSS_FIRST_PERSISTENT_INTERVAL = 30000;
    private static final int PSS_FIRST_TOP_INTERVAL = 10000;
    public static final int PSS_MAX_INTERVAL = 3600000;
    public static final int PSS_MIN_TIME_FROM_STATE_CHANGE = 15000;
    public static final int PSS_SAFE_TIME_FROM_STATE_CHANGE = 1000;
    private static final int PSS_SAME_CACHED_INTERVAL = 600000;
    private static final int PSS_SAME_IMPORTANT_INTERVAL = 600000;
    private static final int PSS_SAME_PERSISTENT_INTERVAL = 600000;
    private static final int PSS_SAME_SERVICE_INTERVAL = 300000;
    private static final int PSS_SAME_TOP_INTERVAL = 60000;
    private static final int PSS_TEST_FIRST_BACKGROUND_INTERVAL = 5000;
    private static final int PSS_TEST_FIRST_TOP_INTERVAL = 3000;
    public static final int PSS_TEST_MIN_TIME_FROM_STATE_CHANGE = 10000;
    private static final int PSS_TEST_SAME_BACKGROUND_INTERVAL = 15000;
    private static final int PSS_TEST_SAME_IMPORTANT_INTERVAL = 10000;
    static final int SCHED_GROUP_BACKGROUND = 0;
    static final int SCHED_GROUP_DEFAULT = 2;
    static final int SCHED_GROUP_FOREGROUND_WINDOW = 5;
    static final int SCHED_GROUP_RESTRICTED = 1;
    public static final int SCHED_GROUP_TOP_APP = 3;
    static final int SCHED_GROUP_TOP_APP_BOUND = 4;
    static final int SCHED_GROUP_UNDEFINED = Integer.MIN_VALUE;
    public static final int SERVICE_ADJ = 500;
    public static final int SERVICE_B_ADJ = 800;
    public static final int SYSTEM_ADJ = -900;
    static final String TAG = "ActivityManager";
    static final String TAG_PROCESS_OBSERVERS = "ActivityManager";
    static final int TRIM_CRITICAL_THRESHOLD = 3;
    static final int TRIM_LOW_THRESHOLD = 5;
    public static final int UNKNOWN_ADJ = 1001;
    private static final String UNSOL_ZYGOTE_MSG_SOCKET_PATH = "/data/system/unsolzygotesocket";
    public static final int VISIBLE_APP_ADJ = 100;
    static final int VISIBLE_APP_LAYER_MAX = 99;
    public static BoostFramework mPerfServiceStartHint;
    private static final long[] sFirstAsleepPssTimes = null;
    private static final long[] sFirstAwakePssTimes = null;
    static KillHandler sKillHandler;
    static ServiceThread sKillThread;
    private static LmkdConnection sLmkdConnection;
    private static OomConnection sOomConnection;
    private static final int[] sProcStateToProcMem = null;
    private static final long[] sSameAsleepPssTimes = null;
    private static final long[] sSameAwakePssTimes = null;
    private static final long[] sTestFirstPssTimes = null;
    private static final long[] sTestSamePssTimes = null;
    private ActivityManagerService.ProcessChangeItem[] mActiveProcessChanges;
    ActiveUids mActiveUids;
    private ArrayList<String> mAppDataIsolationAllowlistedApps;
    private boolean mAppDataIsolationEnabled;
    final AppExitInfoTracker mAppExitInfoTracker;
    IsolatedUidRangeAllocator mAppIsolatedUidRangeAllocator;
    private final AppStartInfoTracker mAppStartInfoTracker;
    final ArrayMap<AppZygote, ArrayList<ProcessRecord>> mAppZygoteProcesses;
    final ProcessMap<AppZygote> mAppZygotes;
    final ArraySet<ProcessRecord> mAppsInBackgroundRestricted;
    final ArrayList<ActivityManagerService.ProcessChangeItem> mAvailProcessChanges;
    private long mCachedRestoreLevel;
    final ProcessMap<ProcessRecord> mDyingProcesses;
    IsolatedUidRange mGlobalIsolatedUids;
    private boolean mHaveDisplaySize;
    ImperceptibleKillRunner mImperceptibleKillRunner;
    final SparseArray<ProcessRecord> mIsolatedProcesses;
    private int mLruProcessActivityStart;
    private int mLruProcessServiceStart;
    final ArrayList<ProcessRecord> mLruProcesses;
    private int mLruSeq;
    private final int[] mOomAdj;
    private boolean mOomLevelsSet;
    private final int[] mOomMinFree;
    private final int[] mOomMinFreeHigh;
    private final int[] mOomMinFreeLow;
    private final ArrayList<ActivityManagerService.ProcessChangeItem> mPendingProcessChanges;
    final LongSparseArray<ProcessRecord> mPendingStarts;
    private PlatformCompat mPlatformCompat;
    ActivityManagerGlobalLock mProcLock;
    private long mProcStartSeqCounter;
    volatile long mProcStateSeqCounter;
    private final Object mProcessChangeLock;
    private ProcessListSettingsListener mProcessListSettingsListener;
    private final MyProcessMap mProcessNames;
    private final RemoteCallbackList<IProcessObserver> mProcessObservers;
    final ArrayList<ProcessRecord> mRemovedProcesses;
    final SparseArray<ArrayList<ProcessRecord>> mSdkSandboxes;
    ActivityManagerService mService;
    private ProcessListSmtBase mSmtEx;
    final StringBuilder mStringBuilder;
    private LocalSocket mSystemServerSocketForZygote;
    private final long mTotalMemMb;
    private boolean mVoldAppDataIsolationEnabled;
    private final int[] mZygoteSigChldMessage;
    private final byte[] mZygoteUnsolicitedMessage;

    private final class ImperceptibleKillRunner extends UidObserver {
        private static final String DROPBOX_TAG_IMPERCEPTIBLE_KILL = "imperceptible_app_kill";
        private static final String EXTRA_PID = "pid";
        private static final String EXTRA_REASON = "reason";
        private static final String EXTRA_REQUESTER = "requester";
        private static final String EXTRA_TIMESTAMP = "timestamp";
        private static final String EXTRA_UID = "uid";
        private static final boolean LOG_TO_DROPBOX = false;
        private Handler mHandler;
        private volatile boolean mIdle;
        private ProcessMap<Long> mLastProcessKillTimes;
        private IdlenessReceiver mReceiver;
        private boolean mUidObserverEnabled;
        private SparseArray<List<Bundle>> mWorkItems;
        final /* synthetic */ ProcessList this$0;

        private final class H extends Handler {
            static final int MSG_DEVICE_IDLE = 0;
            static final int MSG_UID_GONE = 1;
            static final int MSG_UID_STATE_CHANGED = 2;
            final /* synthetic */ ImperceptibleKillRunner this$1;

            H(ImperceptibleKillRunner r1, Looper looper) {
                this.this$1 = r1;
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch(msg.what) {
                    case 0: goto L7;
                    case 1: goto L6;
                    case 2: goto L5;
                    default: goto L11;
                };
            L5:
                ImperceptibleKillRunner.m1568$$Nest$mhandleUidStateChanged(this.this$1, msg.arg1, msg.arg2);
                return;
            L6:
                ImperceptibleKillRunner.m1567$$Nest$mhandleUidGone(this.this$1, msg.arg1);
                return;
            L7:
                ImperceptibleKillRunner.m1566$$Nest$mhandleDeviceIdle(this.this$1);
                return;
            }
        }

        private final class IdlenessReceiver extends BroadcastReceiver {
            final /* synthetic */ ImperceptibleKillRunner this$1;

            /* synthetic */ IdlenessReceiver(ImperceptibleKillRunner r1, ProcessListIA r2) {
                this(r1);
            }

            private IdlenessReceiver(ImperceptibleKillRunner r1) {
                this.this$1 = r1;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                PowerManager pm = (PowerManager) this.this$1.this$0.mService.mContext.getSystemService(PowerManager.class);
                String r1 = intent.getAction();
                switch(r1.hashCode()) {
                    case 498807504: goto L9;
                    case 870701415: goto L6;
                    default: goto L11;
                };
            L11:
                byte r2 = -1;
            L12:
                switch(r2) {
                    case 0: goto L15;
                    case 1: goto L14;
                    default: goto L18;
                };
            L14:
                this.this$1.notifyDeviceIdleness(pm.isDeviceIdleMode());
                return;
            L15:
                this.this$1.notifyDeviceIdleness(pm.isLightDeviceIdleMode());
                return;
            L18:
                return;
            L6:
                if (r1.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") == false) goto L11;
                r2 = 1;
                goto L12
            L9:
                if (r1.equals("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED") == false) goto L11;
                r2 = 0;
                goto L12
            }
        }

        public static /* synthetic */ Boolean $r8$lambda$KiGWcKMquEyHD6tuwLTDNrdI_7c(ImperceptibleKillRunner r0, String r1) {
            return r0.lambda$killProcessLocked$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleDeviceIdle, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1566$$Nest$mhandleDeviceIdle(ImperceptibleKillRunner r0) {
            r0.handleDeviceIdle();
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleUidGone, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1567$$Nest$mhandleUidGone(ImperceptibleKillRunner r0, int r1) {
            r0.handleUidGone(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleUidStateChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1568$$Nest$mhandleUidStateChanged(ImperceptibleKillRunner r0, int r1, int r2) {
            r0.handleUidStateChanged(r1, r2);
        }

        ImperceptibleKillRunner(ProcessList r1, Looper looper) {
            this.this$0 = r1;
            this.mWorkItems = new SparseArray();
            this.mLastProcessKillTimes = new ProcessMap();
            this.mHandler = new H(this, looper);
        }

        boolean enqueueLocked(ProcessRecord app, String reason, int requester) {
            ProcessListIA r1 = null;
            if (app.isolated == false) goto L5;
            Long last = null;
        L7:
            if (last != null) goto L9;
        L12:
            Bundle bundle = new Bundle();
            bundle.putInt("pid", app.getPid());
            bundle.putInt("uid", app.uid);
            bundle.putLong("timestamp", app.getStartTime());
            bundle.putString("reason", reason);
            bundle.putInt(EXTRA_REQUESTER, requester);
            List<Bundle> list = this.mWorkItems.get(app.uid);
            if (list != null) goto L15;
            list = new ArrayList();
            this.mWorkItems.put(app.uid, list);
        L15:
            list.add(bundle);
            if (this.mReceiver != null) goto L20;
            this.mReceiver = new IdlenessReceiver(this, r1);
            IntentFilter filter = new IntentFilter("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED");
            filter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            this.this$0.mService.mContext.registerReceiver(this.mReceiver, filter);
            return true;
        L20:
            return true;
        L9:
            if (SystemClock.uptimeMillis() >= (last.longValue() + ((long) ActivityManagerConstants.MIN_CRASH_INTERVAL))) goto L12;
            return false;
        L5:
            last = (Long) this.mLastProcessKillTimes.get(app.processName, app.uid);
            goto L7
        }

        void notifyDeviceIdleness(boolean idle) {
            if (this.mIdle == idle) goto L5;
            boolean diff = true;
        L6:
            this.mIdle = idle;
            if (diff == false) goto L21;
            if (idle == false) goto L24;
            ActivityManagerService r2 = this.this$0.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
        L14:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L12:
            if (this.mWorkItems.size() <= 0) goto L16;
            this.mHandler.sendEmptyMessage(0);     // Catch: Throwable -> L14
        L16:
            monitor-exit(r2);     // Catch: Throwable -> L14
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L24:
            return;
        L21:
            return;
        L5:
            diff = false;
            goto L6
        }

        private void handleDeviceIdle() {
            DropBoxManager dbox = (DropBoxManager) this.this$0.mService.mContext.getSystemService(DropBoxManager.class);
            ActivityManagerService r10 = this.this$0.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r10);
            int size = this.mWorkItems.size();     // Catch: Throwable -> L15
            int i = size - 1;     // Catch: Throwable -> L15
        L6:
            if (this.mIdle == false) goto L22;
            if (i < 0) goto L22;
            List<Bundle> list = this.mWorkItems.valueAt(i);     // Catch: Throwable -> L15
            int len = list.size();     // Catch: Throwable -> L15
            int j = len - 1;     // Catch: Throwable -> L15
        L10:
            if (this.mIdle == false) goto L19;
            if (j < 0) goto L19;
            Bundle bundle = list.get(j);     // Catch: Throwable -> L15
            if (killProcessLocked(bundle.getInt("pid"), bundle.getInt("uid"), bundle.getLong("timestamp"), bundle.getString("reason"), bundle.getInt(EXTRA_REQUESTER), dbox, false) == false) goto L17;
            list.remove(j);     // Catch: Throwable -> L15
        L17:
            j = j - 1;     // Catch: Throwable -> L15
        L19:
            if (list.size() != 0) goto L21;
            this.mWorkItems.removeAt(i);     // Catch: Throwable -> L15
        L21:
            i = i - 1;     // Catch: Throwable -> L15
        L22:
            registerUidObserverIfNecessaryLocked();     // Catch: Throwable -> L15
            monitor-exit(r10);     // Catch: Throwable -> L15
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L15:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private void registerUidObserverIfNecessaryLocked() {
            if (this.mUidObserverEnabled == true) goto L8;
            if (this.mWorkItems.size() <= 0) goto L8;
            this.mUidObserverEnabled = true;
            this.this$0.mService.registerUidObserver(this, 3, -1, PackageManagerService.PLATFORM_PACKAGE_NAME);
            return;
        L8:
            if (this.mUidObserverEnabled == true) goto L10;
            return;
        L10:
            if (this.mWorkItems.size() != 0) goto L15;
            this.mUidObserverEnabled = false;
            this.this$0.mService.unregisterUidObserver(this);
            return;
        }

        private boolean killProcessLocked(int pid, int uid, long timestamp, String reason, int requester, DropBoxManager dbox, boolean logToDropbox) {
            ActivityManagerService.PidMap r2 = this.this$0.mService.mPidsSelfLocked;
            monitor-enter(r2);
            ProcessRecord app = this.this$0.mService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            if (app == null) goto L30;
            if (app.getPid() != pid) goto L30;
            if (app.uid != uid) goto L30;
            if (app.getStartTime() != timestamp) goto L30;
            if (app.getPkgList().searchEachPackage(new ProcessList$ImperceptibleKillRunner$$ExternalSyntheticLambda0(this)) == null) goto L19;
            return true;
        L19:
            if (this.this$0.mService.mConstants.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES.contains(Integer.valueOf(app.mState.getReportedProcState())) == false) goto L22;
            return false;
        L22:
            app.killLocked(reason, 13, 15, true);
            if (app.isolated == true) goto L25;
            this.mLastProcessKillTimes.put(app.processName, app.uid, Long.valueOf(SystemClock.uptimeMillis()));
        L25:
            if (logToDropbox == false) goto L28;
            SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            this.this$0.mService.appendDropBoxProcessHeaders(app, app.processName, null, sb);
            sb.append("Reason: " + reason);
            sb.append("\n");
            sb.append("Requester UID: " + requester);
            sb.append("\n");
            dbox.addText(DROPBOX_TAG_IMPERCEPTIBLE_KILL, sb.toString());
        L28:
            return true;
        L30:
            return true;
        L31:
            th = th;
        L37:
            throw th;
        L35:
            th = th;
            goto L37
        }

        private /* synthetic */ Boolean lambda$killProcessLocked$0(String pkgName) {
            if (this.this$0.mService.mConstants.IMPERCEPTIBLE_KILL_EXEMPT_PACKAGES.contains(pkgName) == true) goto L5;
            return null;
        L5:
            return Boolean.TRUE;
        }

        private void handleUidStateChanged(int uid, int procState) {
            DropBoxManager dbox = (DropBoxManager) this.this$0.mService.mContext.getSystemService(DropBoxManager.class);
            if (dbox != null) goto L5;
        L8:
            boolean r0 = false;
        L7:
            boolean logToDropbox = r0;
            ActivityManagerService r11 = this.this$0.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r11);
        L24:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L12:
            if (this.mIdle == true) goto L14;
        L31:
            monitor-exit(r11);     // Catch: Throwable -> L24
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L14:
            if (this.this$0.mService.mConstants.IMPERCEPTIBLE_KILL_EXEMPT_PROC_STATES.contains(Integer.valueOf(procState)) == true) goto L31;
            List<Bundle> list = this.mWorkItems.get(uid);     // Catch: Throwable -> L24
            if (list == null) goto L31;
            int len = list.size();     // Catch: Throwable -> L24
            int j = len - 1;     // Catch: Throwable -> L24
        L19:
            if (this.mIdle == false) goto L28;
            if (j < 0) goto L28;
            Bundle bundle = list.get(j);     // Catch: Throwable -> L24
            if (killProcessLocked(bundle.getInt("pid"), bundle.getInt("uid"), bundle.getLong("timestamp"), bundle.getString("reason"), bundle.getInt(EXTRA_REQUESTER), dbox, logToDropbox) == false) goto L26;
            list.remove(j);     // Catch: Throwable -> L24
        L26:
            j = j - 1;     // Catch: Throwable -> L24
        L28:
            if (list.size() != 0) goto L30;
            this.mWorkItems.remove(uid);     // Catch: Throwable -> L24
        L30:
            registerUidObserverIfNecessaryLocked();     // Catch: Throwable -> L24
            goto L31
        L5:
            if (dbox.isTagEnabled(DROPBOX_TAG_IMPERCEPTIBLE_KILL) == false) goto L8;
            r0 = true;
            goto L7
        }

        private void handleUidGone(int uid) {
            ActivityManagerService r0 = this.this$0.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.mWorkItems.remove(uid);     // Catch: Throwable -> L8
            registerUidObserverIfNecessaryLocked();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        public void onUidGone(int uid, boolean disabled) {
            this.mHandler.obtainMessage(1, uid, 0).sendToTarget();
        }

        public void onUidStateChanged(int uid, int procState, long procStateSeq, int capability) {
            this.mHandler.obtainMessage(2, uid, procState).sendToTarget();
        }
    }

    final class IsolatedUidRange {
        public final int mFirstUid;
        public final int mLastUid;
        private int mNextUid;
        private final SparseBooleanArray mUidUsed;

        IsolatedUidRange(ProcessList this$0, int firstUid, int lastUid) {
            this.mUidUsed = new SparseBooleanArray();
            this.mFirstUid = firstUid;
            this.mLastUid = lastUid;
            this.mNextUid = firstUid;
        }

        int allocateIsolatedUidLocked(int userId) {
            int stepsLeft = (this.mLastUid - this.mFirstUid) + 1;
            int i = 0;
        L3:
            if (i >= stepsLeft) goto L14;
            if (this.mNextUid >= this.mFirstUid) goto L7;
        L8:
            this.mNextUid = this.mFirstUid;
        L9:
            int uid = UserHandle.getUid(userId, this.mNextUid);
            this.mNextUid++;
            if (this.mUidUsed.get(uid, false) == false) goto L11;
            i = i + 1;
            goto L3
        L11:
            this.mUidUsed.put(uid, true);
            return uid;
        L7:
            if (this.mNextUid <= this.mLastUid) goto L9;
        L14:
            return -1;
        }

        void freeIsolatedUidLocked(int uid) {
            this.mUidUsed.delete(uid);
        }
    }

    final class IsolatedUidRangeAllocator {
        private final ProcessMap<IsolatedUidRange> mAppRanges;
        private final BitSet mAvailableUidRanges;
        private final int mFirstUid;
        private final int mNumUidRanges;
        private final int mNumUidsPerRange;
        final /* synthetic */ ProcessList this$0;

        IsolatedUidRangeAllocator(ProcessList this$0, int firstUid, int lastUid, int numUidsPerRange) {
            this.this$0 = this$0;
            this.mAppRanges = new ProcessMap();
            this.mFirstUid = firstUid;
            this.mNumUidsPerRange = numUidsPerRange;
            this.mNumUidRanges = ((lastUid - firstUid) + 1) / numUidsPerRange;
            this.mAvailableUidRanges = new BitSet(this.mNumUidRanges);
            this.mAvailableUidRanges.set(0, this.mNumUidRanges);
        }

        IsolatedUidRange getIsolatedUidRangeLocked(String processName, int uid) {
            return (IsolatedUidRange) this.mAppRanges.get(processName, uid);
        }

        IsolatedUidRange getOrCreateIsolatedUidRangeLocked(String processName, int uid) {
            IsolatedUidRange range = getIsolatedUidRangeLocked(processName, uid);
            if (range != null) goto L10;
            int uidRangeIndex = this.mAvailableUidRanges.nextSetBit(0);
            if (uidRangeIndex >= 0) goto L8;
            return null;
        L8:
            this.mAvailableUidRanges.clear(uidRangeIndex);
            int actualUid = this.mFirstUid + (this.mNumUidsPerRange * uidRangeIndex);
            IsolatedUidRange range2 = new IsolatedUidRange(this.this$0, actualUid, (this.mNumUidsPerRange + actualUid) - 1);
            this.mAppRanges.put(processName, uid, range2);
            return range2;
        L10:
            return range;
        }

        void freeUidRangeLocked(ApplicationInfo info) {
            IsolatedUidRange range = (IsolatedUidRange) this.mAppRanges.get(info.processName, info.uid);
            if (range == null) goto L6;
            int uidRangeIndex = (range.mFirstUid - this.mFirstUid) / this.mNumUidsPerRange;
            this.mAvailableUidRanges.set(uidRangeIndex);
            this.mAppRanges.remove(info.processName, info.uid);
            return;
        }
    }

    final class KillHandler extends Handler {
        static final int KILL_PROCESS_GROUP_MSG = 4000;
        static final int LMKD_RECONNECT_MSG = 4001;

        public KillHandler(ProcessList this$0, Looper looper) {
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 4000: goto L8;
                case 4001: goto L6;
                default: goto L4;
            };
        L4:
            super.handleMessage(msg);
            return;
        L8:
            Trace.traceBegin(64, "killProcessGroup");
            Process.killProcessGroup(msg.arg1, msg.arg2);
            Trace.traceEnd(64);
            return;
        L6:
            if (ProcessList.m1565$$Nest$sfgetsLmkdConnection().connect() == true) goto L11;
            Slog.i("ActivityManager", "Failed to connect to lmkd, retry after 1000 ms");
            sendMessageDelayed(obtainMessage(LMKD_RECONNECT_MSG), 1000);
            return;
        }
    }

    final class MyProcessMap extends ProcessMap<ProcessRecord> {
        final /* synthetic */ ProcessList this$0;

        MyProcessMap(ProcessList this$0) {
            this.this$0 = this$0;
        }

        public /* bridge */ /* synthetic */ Object put(String r1, int r2, Object r3) {
            return put(r1, r2, (ProcessRecord) r3);
        }

        /* JADX INFO: renamed from: remove, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1569remove(String r1, int r2) {
            return remove(r1, r2);
        }

        public ProcessRecord put(String name, int uid, ProcessRecord value) {
            ProcessRecord r = (ProcessRecord) super.put(name, uid, value);
            this.this$0.mService.mAtmInternal.onProcessAdded(r.getWindowProcessController());
            return r;
        }

        public ProcessRecord remove(String name, int uid) {
            ProcessRecord r = (ProcessRecord) super.remove(name, uid);
            this.this$0.mService.mAtmInternal.onProcessRemoved(name, uid);
            return r;
        }
    }

    static final class ProcStartHandler extends Handler {
        static final int MSG_PROCESS_DIED = 1;
        static final int MSG_PROCESS_KILL_TIMEOUT = 2;
        private final ActivityManagerService mService;

        ProcStartHandler(ActivityManagerService service, Looper looper) {
            super(looper);
            this.mService = service;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L14;
                case 2: goto L5;
                default: goto L19;
            };
        L5:
            ActivityManagerService r0 = this.mService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.mService.handleProcessStartOrKillTimeoutLocked((ProcessRecord) msg.obj, true);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L10:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L14:
            ProcessList.m1564$$Nest$mhandlePredecessorProcDied(this.mService.mProcessList, (ProcessRecord) msg.obj);
            return;
        }
    }

    public static final class ProcStateMemTracker {
        final int[] mHighestMem;
        int mPendingHighestMemState;
        int mPendingMemState;
        float mPendingScalingFactor;
        final float[] mScalingFactor;
        int mTotalHighestMem;

        public ProcStateMemTracker() {
            this.mHighestMem = new int[5];
            this.mScalingFactor = new float[5];
            this.mTotalHighestMem = 4;
            int i = 0;
        L3:
            if (i >= 5) goto L5;
            this.mHighestMem[i] = 5;
            this.mScalingFactor[i] = 1.0f;
            i = i + 1;
            goto L3
        L5:
            this.mPendingMemState = -1;
        }

        public void dumpLine(PrintWriter pw) {
            pw.print("best=");
            pw.print(this.mTotalHighestMem);
            pw.print(" (");
            boolean needSep = false;
            int i = 0;
        L4:
            if (i >= 5) goto L11;
            if (this.mHighestMem[i] >= 5) goto L10;
            if (needSep == false) goto L9;
            pw.print(", ");
        L9:
            pw.print(i);
            pw.print("=");
            pw.print(this.mHighestMem[i]);
            pw.print(" ");
            pw.print(this.mScalingFactor[i]);
            pw.print("x");
            needSep = true;
        L10:
            i = i + 1;
            goto L4
        L11:
            pw.print(")");
            if (this.mPendingMemState < 0) goto L14;
            pw.print(" / pending state=");
            pw.print(this.mPendingMemState);
            pw.print(" highest=");
            pw.print(this.mPendingHighestMemState);
            pw.print(" ");
            pw.print(this.mPendingScalingFactor);
            pw.print("x");
        L14:
            pw.println();
        }
    }

    static class ProcessListSettingsListener implements DeviceConfig.OnPropertiesChangedListener {
        private final Context mContext;
        private final Object mLock;
        private boolean mSdkSandboxApplyRestrictionsAudit;
        private boolean mSdkSandboxApplyRestrictionsNext;

        /* JADX INFO: renamed from: -$$Nest$mregisterObserver, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1570$$Nest$mregisterObserver(ProcessListSettingsListener r0) {
            r0.registerObserver();
        }

        ProcessListSettingsListener(Context context) {
            this.mLock = new Object();
            this.mSdkSandboxApplyRestrictionsAudit = DeviceConfig.getBoolean("adservices", ProcessList.PROPERTY_APPLY_SDK_SANDBOX_AUDIT_RESTRICTIONS, false);
            this.mSdkSandboxApplyRestrictionsNext = DeviceConfig.getBoolean("adservices", ProcessList.PROPERTY_APPLY_SDK_SANDBOX_NEXT_RESTRICTIONS, false);
            this.mContext = context;
        }

        private void registerObserver() {
            DeviceConfig.addOnPropertiesChangedListener("adservices", this.mContext.getMainExecutor(), this);
        }

        void unregisterObserver() {
            DeviceConfig.removeOnPropertiesChangedListener(this);
        }

        boolean applySdkSandboxRestrictionsAudit() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r1 = this.mSdkSandboxApplyRestrictionsAudit;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        boolean applySdkSandboxRestrictionsNext() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r1 = this.mSdkSandboxApplyRestrictionsNext;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator r1 = properties.getKeyset().iterator();     // Catch: Throwable -> L16
        L6:
            if (r1.hasNext() == false) goto L27;
            String name = (String) r1.next();     // Catch: Throwable -> L16
            if (name == null) goto L6;
            switch(name.hashCode()) {
                case -460166235: goto L19;
                case 1346273945: goto L14;
                default: goto L21;
            };     // Catch: Throwable -> L16
        L21:
            byte r3 = -1;
        L22:
            switch(r3) {
                case 0: goto L25;
                case 1: goto L24;
                default: goto L6;
            };     // Catch: Throwable -> L16
        L24:
            this.mSdkSandboxApplyRestrictionsNext = properties.getBoolean(ProcessList.PROPERTY_APPLY_SDK_SANDBOX_NEXT_RESTRICTIONS, false);     // Catch: Throwable -> L16
            goto L6
        L25:
            this.mSdkSandboxApplyRestrictionsAudit = properties.getBoolean(ProcessList.PROPERTY_APPLY_SDK_SANDBOX_AUDIT_RESTRICTIONS, false);     // Catch: Throwable -> L16
            goto L6
        L14:
            if (name.equals(ProcessList.PROPERTY_APPLY_SDK_SANDBOX_AUDIT_RESTRICTIONS) == false) goto L21;
            r3 = 0;
            goto L22
        L19:
            if (name.equals(ProcessList.PROPERTY_APPLY_SDK_SANDBOX_NEXT_RESTRICTIONS) == false) goto L21;
            r3 = 1;
            goto L22
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$3Aeowc7Aa0A47bbOcoIMPuNZ44Y(ProcessList r0, ProcessRecord r1, String r2, int[] r3, int r4, int r5, int r6, String r7, String r8, String r9, long r10) {
        r0.lambda$startProcessLocked$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void $r8$lambda$3aT8AjDesFyouy4iqaLN2hUmayA(ProcessList r0, ProcessRecord r1, String r2, int[] r3, int r4, int r5, int r6, String r7, String r8, String r9, long r10) {
        r0.lambda$handleProcessStart$1(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ int $r8$lambda$_2hhy3f6tCYNbqfLdggq9vFVtX4(ProcessList r0, FileDescriptor r1, int r2) {
        return r0.handleZygoteMessages(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$_uPPqfJ3pVXaIRjsrMD8UI7EV5A(boolean r0, List r1, ArrayMap r2, ProcessRecord r3, ArrayList r4, String r5) {
        lambda$updateApplicationInfoLOSP$4(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$h3hOlLi3GqcRRi-bHw7PQrQQN8w, reason: not valid java name */
    public static /* synthetic */ void m1562$r8$lambda$h3hOlLi3GqcRRibHw7PQrQQN8w(ProcessList r0, ProcessRecord r1, ApplicationInfo r2, HostingRecord r3) {
        r0.lambda$startProcessLocked$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$h4KTbfA-h_I30e2IlMT_GS04LSU, reason: not valid java name */
    public static /* synthetic */ void m1563$r8$lambda$h4KTbfAh_I30e2IlMT_GS04LSU(ProcessList r0, String r1, boolean r2, long r3, ProcessRecord r5) {
        r0.lambda$updateBackgroundRestrictedForUidPackageLocked$5(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$wm644qNFTPEBPGx9KMQartUv80k(ProcessList r0, long r1, ProcessRecord r3) {
        r0.lambda$killAppIfBgRestrictedAndCachedIdleLocked$6(r1, r3);
    }

    public static /* synthetic */ int $r8$lambda$z_FKOziVFNfiIg_h3f2qRDU43EU(Pair r0, Pair r1) {
        return lambda$killPackageProcessesLSP$3(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePredecessorProcDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1564$$Nest$mhandlePredecessorProcDied(ProcessList r0, ProcessRecord r1) {
        r0.handlePredecessorProcDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsLmkdConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ LmkdConnection m1565$$Nest$sfgetsLmkdConnection() {
        return sLmkdConnection;
    }

    static {
        PREVIOUS_APP_MAX_ADJ = 700;
        PAGE_SIZE = (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        sKillHandler = null;
        sKillThread = null;
        sLmkdConnection = null;
        sOomConnection = null;
        mPerfServiceStartHint = new BoostFramework();
        sProcStateToProcMem = new int[]{0, 0, 1, 2, 1, 2, 2, 2, 2, 2, 3, 4, 1, 2, 4, 4, 4, 4, 4, 4};
        sFirstAwakePssTimes = new long[]{30000, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, 20000, 20000, 20000};
        sSameAwakePssTimes = new long[]{600000, 60000, 600000, 300000, 600000};
        sFirstAsleepPssTimes = new long[]{60000, 20000, 30000, 30000, 60000};
        sSameAsleepPssTimes = new long[]{600000, 60000, 600000, 300000, 600000};
        sTestFirstPssTimes = new long[]{BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS, BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS, 5000, 5000, 5000};
        sTestSamePssTimes = new long[]{15000, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, 15000, 15000};
    }

    ProcessListSettingsListener getProcessListSettingsListener() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mProcessListSettingsListener != null) goto L9;
        this.mProcessListSettingsListener = new ProcessListSettingsListener(this.mService.mContext);     // Catch: Throwable -> L7
        ProcessListSettingsListener.m1570$$Nest$mregisterObserver(this.mProcessListSettingsListener);     // Catch: Throwable -> L7
    L9:
        ProcessListSettingsListener r1 = this.mProcessListSettingsListener;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterLockedSection();
        return r1;
    }

    ProcessList() {
        this.mService = null;
        this.mOomAdj = new int[]{0, 100, 200, 250, 900, 950};
        this.mOomMinFreeLow = new int[]{12288, 18432, CpioConstants.C_ISBLK, CpioConstants.C_ISNWK, 43008, CpioConstants.C_ISSOCK};
        this.mOomMinFreeHigh = new int[]{73728, 92160, 110592, 129024, 147456, 184320};
        this.mOomMinFree = new int[this.mOomAdj.length];
        this.mOomLevelsSet = false;
        this.mAppDataIsolationEnabled = false;
        this.mVoldAppDataIsolationEnabled = false;
        this.mStringBuilder = new StringBuilder(256);
        this.mProcStateSeqCounter = 0;
        this.mProcStartSeqCounter = 0;
        this.mPendingStarts = new LongSparseArray();
        this.mLruProcesses = new ArrayList();
        this.mLruProcessActivityStart = 0;
        this.mLruProcessServiceStart = 0;
        this.mLruSeq = 0;
        this.mIsolatedProcesses = new SparseArray();
        this.mAppZygotes = new ProcessMap();
        this.mAppStartInfoTracker = new AppStartInfoTracker();
        this.mSdkSandboxes = new SparseArray();
        this.mAppExitInfoTracker = new AppExitInfoTracker();
        this.mAppZygoteProcesses = new ArrayMap();
        this.mAppsInBackgroundRestricted = new ArraySet();
        this.mPlatformCompat = null;
        this.mZygoteUnsolicitedMessage = new byte[16];
        this.mZygoteSigChldMessage = new int[3];
        this.mGlobalIsolatedUids = new IsolatedUidRange(this, 99000, 99999);
        this.mAppIsolatedUidRangeAllocator = new IsolatedUidRangeAllocator(this, 90000, 98999, 100);
        this.mRemovedProcesses = new ArrayList();
        this.mDyingProcesses = new ProcessMap();
        this.mProcessObservers = new RemoteCallbackList();
        this.mActiveProcessChanges = new ActivityManagerService.ProcessChangeItem[5];
        this.mPendingProcessChanges = new ArrayList();
        this.mAvailProcessChanges = new ArrayList();
        this.mProcessChangeLock = new Object();
        this.mProcessNames = new MyProcessMap(this);
        this.mSmtEx = new ProcessListSmtBase(this);
        MemInfoReader minfo = new MemInfoReader();
        minfo.readMemInfo();
        this.mTotalMemMb = minfo.getTotalSize() / DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES;
        updateOomLevels(0, 0, false);
    }

    void init(ActivityManagerService service, ActiveUids activeUids, PlatformCompat platformCompat) {
        this.mService = service;
        this.mActiveUids = activeUids;
        this.mPlatformCompat = platformCompat;
        this.mProcLock = service.mProcLock;
        this.mAppDataIsolationEnabled = SystemProperties.getBoolean(ANDROID_APP_DATA_ISOLATION_ENABLED_PROPERTY, true);
        this.mVoldAppDataIsolationEnabled = SystemProperties.getBoolean(ANDROID_VOLD_APP_DATA_ISOLATION_ENABLED_PROPERTY, false);
        this.mAppDataIsolationAllowlistedApps = new ArrayList(SystemConfig.getInstance().getAppDataIsolationWhitelistedApps());
        if (sKillHandler != null) goto L9;
        sKillThread = new ServiceThread("ActivityManager:kill", 10, true);
        sKillThread.start();
        sKillHandler = new KillHandler(this, sKillThread.getLooper());
        sOomConnection = new OomConnection(new AnonymousClass1(this));
        sLmkdConnection = new LmkdConnection(sKillThread.getLooper().getQueue(), new AnonymousClass2(this));
        this.mSystemServerSocketForZygote = createSystemServerSocketForZygote();
        if (this.mSystemServerSocketForZygote == null) goto L7;
        sKillHandler.getLooper().getQueue().addOnFileDescriptorEventListener(this.mSystemServerSocketForZygote.getFileDescriptor(), 1, new ProcessList$$ExternalSyntheticLambda7(this));
    L7:
        this.mAppStartInfoTracker.init(this.mService);
        this.mAppExitInfoTracker.init(this.mService);
        this.mImperceptibleKillRunner = new ImperceptibleKillRunner(this, sKillThread.getLooper());
        return;
    }

    void onSystemReady() {
        this.mAppStartInfoTracker.onSystemReady();
        this.mAppExitInfoTracker.onSystemReady();
    }

    void applyDisplaySize(WindowManagerService wm) {
        if (this.mHaveDisplaySize == true) goto L10;
        Point p = new Point();
        wm.getBaseDisplaySize(0, p);
        if (p.x != 0) goto L7;
        return;
    L7:
        if (p.y == 0) goto L12;
        updateOomLevels(p.x, p.y, true);
        this.mHaveDisplaySize = true;
        return;
    L12:
        return;
    }

    Map<Integer, String> getProcessesWithPendingBindMounts(int userId) {
        Map<Integer, String> pidPackageMap = new HashMap();
        ActivityManagerGlobalLock r1 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r1);
        int i = this.mLruProcesses.size() - 1;     // Catch: Throwable -> L14
    L5:
        if (i < 0) goto L20;
        ProcessRecord record = this.mLruProcesses.get(i);     // Catch: Throwable -> L14
        if (record.userId != userId) goto L18;
        if (record.isBindMountPending() == false) goto L18;
        int pid = record.getPid();     // Catch: Throwable -> L14
        if (pid == 0) goto L17;
        pidPackageMap.put(Integer.valueOf(pid), record.info.packageName);     // Catch: Throwable -> L14
        goto L18
    L17:
        throw new IllegalStateException("Pending process is not started yet,retry later");     // Catch: Throwable -> L14
    L18:
        i = i - 1;     // Catch: Throwable -> L14
        goto L5
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return pidPackageMap;
    L14:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void updateOomLevels(int displayWidth, int displayHeight, boolean write) {
        float scaleMem = (this.mTotalMemMb - 350) / 350.0f;
        float scaleDisp = ((displayWidth * displayHeight) - 384000) / (1024000 - 384000);
        if (scaleMem <= scaleDisp) goto L5;
        float scale = scaleMem;
    L7:
        if (scale >= 0.0f) goto L10;
        scale = 0.0f;
    L12:
        int minfree_adj = Resources.getSystem().getInteger(R.integer.config_mediaOutputSwitchDialogVersion);
        int minfree_abs = Resources.getSystem().getInteger(R.integer.config_mdc_initial_max_retry);
        if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) goto L15;
        boolean is64bit = true;
    L16:
        int i = 0;
    L17:
        char r13 = 4;
        if (i >= this.mOomAdj.length) goto L28;
        int low = this.mOomMinFreeLow[i];
        int high = this.mOomMinFreeHigh[i];
        if (is64bit == false) goto L26;
        if (i != 4) goto L24;
        high = (high * 3) / 2;
        goto L26
    L24:
        if (i != 5) goto L26;
        high = (high * 7) / 4;
    L26:
        this.mOomMinFree[i] = (int) (low + ((high - low) * scale));
        i = i + 1;
        goto L17
    L28:
        if (minfree_abs < 0) goto L33;
        int i2 = 0;
    L31:
        if (i2 >= this.mOomAdj.length) goto L33;
        this.mOomMinFree[i2] = (int) ((minfree_abs * this.mOomMinFree[i2]) / this.mOomMinFree[this.mOomAdj.length - 1]);
        i2 = i2 + 1;
    L33:
        if (minfree_adj == 0) goto L43;
        int i3 = 0;
    L36:
        if (i3 >= this.mOomAdj.length) goto L43;
        int[] r11 = this.mOomMinFree;
        char r17 = r13;
        r11[i3] = r11[i3] + ((int) ((minfree_adj * this.mOomMinFree[i3]) / this.mOomMinFree[this.mOomAdj.length - 1]));
        if (this.mOomMinFree[i3] >= 0) goto L40;
        this.mOomMinFree[i3] = 0;
    L40:
        i3 = i3 + 1;
        r13 = r17;
    L43:
        this.mCachedRestoreLevel = (getMemLevel(999) / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) / 3;
        int reserve = (((displayWidth * displayHeight) * 4) * 3) / 1024;
        int reserve_adj = Resources.getSystem().getInteger(R.integer.config_jobSchedulerIdleWindowSlop);
        int reserve_abs = Resources.getSystem().getInteger(R.integer.config_jobSchedulerBackgroundJobsDelay);
        if (reserve_abs < 0) goto L46;
        reserve = reserve_abs;
    L46:
        if (reserve_adj == 0) goto L50;
        reserve = reserve + reserve_adj;
        if (reserve >= 0) goto L50;
        reserve = 0;
    L50:
        if (write == false) goto L67;
        ByteBuffer buf = ByteBuffer.allocate(((this.mOomAdj.length * 2) + 1) * 4);
        buf.putInt(0);
        int i4 = 0;
    L53:
        if (i4 >= this.mOomAdj.length) goto L55;
        buf.putInt((this.mOomMinFree[i4] * 1024) / PAGE_SIZE);
        buf.putInt(this.mOomAdj[i4]);
        i4 = i4 + 1;
        goto L53
    L55:
        writeLmkd(buf, null);
        SystemProperties.set("sys.sysctl.extra_free_kbytes", Integer.toString(reserve));
        this.mOomLevelsSet = true;
        return;
    L67:
        return;
    L15:
        is64bit = false;
        goto L16
    L10:
        if (scale <= 1.0f) goto L12;
        scale = 1.0f;
        goto L12
    L5:
        scale = scaleDisp;
        goto L7
    }

    public static int computeEmptyProcessLimit(int totalProcessLimit) {
        return totalProcessLimit / 2;
    }

    private static String buildOomTag(String prefix, String compactPrefix, String space, int val, int base, boolean compact) {
        int diff = val - base;
        if (diff != 0) goto L10;
        if (compact == false) goto L6;
        return compactPrefix;
    L6:
        if (space != null) goto L9;
        return prefix;
    L9:
        return prefix + space;
    L10:
        String r2 = "+";
        if (diff >= 10) goto L19;
        StringBuilder r1 = new StringBuilder();
        r1.append(prefix);
        if (compact == true) goto L16;
        r2 = "+ ";
    L16:
        r1.append(r2);
        r1.append(Integer.toString(diff));
        return r1.toString();
    L19:
        return prefix + "+" + Integer.toString(diff);
    }

    public static String makeOomAdjString(int setAdj, boolean compact) {
        if (setAdj < 900) goto L7;
        return buildOomTag("cch", "cch", "   ", setAdj, 900, compact);
    L7:
        if (setAdj < 800) goto L11;
        return buildOomTag("svcb  ", "svcb", null, setAdj, 800, compact);
    L11:
        if (setAdj < 700) goto L15;
        return buildOomTag("prev  ", "prev", null, setAdj, 700, compact);
    L15:
        if (setAdj < 600) goto L19;
        return buildOomTag("home  ", "home", null, setAdj, 600, compact);
    L19:
        if (setAdj < 500) goto L23;
        return buildOomTag("svc   ", "svc", null, setAdj, 500, compact);
    L23:
        if (setAdj < 400) goto L27;
        return buildOomTag("hvy   ", "hvy", null, setAdj, 400, compact);
    L27:
        if (setAdj < 300) goto L31;
        return buildOomTag("bkup  ", "bkup", null, setAdj, 300, compact);
    L31:
        if (setAdj < 250) goto L35;
        return buildOomTag("prcl  ", "prcl", null, setAdj, 250, compact);
    L35:
        if (setAdj < 225) goto L39;
        return buildOomTag("prcm  ", "prcm", null, setAdj, PERCEPTIBLE_MEDIUM_APP_ADJ, compact);
    L39:
        if (setAdj < 200) goto L43;
        return buildOomTag("prcp  ", "prcp", null, setAdj, 200, compact);
    L43:
        if (setAdj >= 100) goto L45;
        if (setAdj < 0) goto L50;
        return buildOomTag("fg ", "fg ", "   ", setAdj, 0, compact);
    L50:
        if (setAdj < (-700)) goto L54;
        return buildOomTag("psvc  ", "psvc", null, setAdj, PERSISTENT_SERVICE_ADJ, compact);
    L54:
        if (setAdj < (-800)) goto L58;
        return buildOomTag("pers  ", "pers", null, setAdj, PERSISTENT_PROC_ADJ, compact);
    L58:
        if (setAdj < (-900)) goto L62;
        return buildOomTag("sys   ", "sys", null, setAdj, SYSTEM_ADJ, compact);
    L62:
        if (setAdj < (-1000)) goto L66;
        return buildOomTag("ntv  ", "ntv", null, setAdj, -1000, compact);
    L66:
        return Integer.toString(setAdj);
    L45:
        return buildOomTag("vis", "vis", "   ", setAdj, 100, compact);
    }

    public static String makeProcStateString(int curProcState) {
        return ActivityManager.procStateToString(curProcState);
    }

    public static String makeSchedulingGroupString(int curSchedulingGroup) {
        switch(curSchedulingGroup) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L5;
            default: goto L4;
        };
    L5:
        return "3RD";
    L7:
        return "top_app_bound";
    L9:
        return "top_app";
    L11:
        return "default";
    L13:
        return "restricted";
    L15:
        return "background";
    L4:
        return "unknown: " + curSchedulingGroup;
    }

    public static int makeProcStateProtoEnum(int curProcState) {
        switch(curProcState) {
            case -1: goto L47;
            case 0: goto L45;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return 998;
    L5:
        return 1019;
    L7:
        return 1018;
    L9:
        return 1017;
    L11:
        return 1016;
    L13:
        return 1015;
    L15:
        return 1014;
    L17:
        return 1013;
    L19:
        return 1012;
    L21:
        return 1011;
    L23:
        return 1010;
    L25:
        return 1009;
    L27:
        return 1008;
    L29:
        return 1007;
    L31:
        return 1006;
    L33:
        return 1005;
    L35:
        return 1004;
    L37:
        return 1003;
    L39:
        return 1020;
    L41:
        return 1002;
    L43:
        return 1001;
    L45:
        return 1000;
    L47:
        return 999;
    }

    public static void appendRamKb(StringBuilder sb, long ramKb) {
        int j = 0;
        int fact = 10;
    L4:
        if (j >= 6) goto L9;
        if (ramKb >= fact) goto L8;
        sb.append(' ');
    L8:
        j = j + 1;
        fact = fact * 10;
        goto L4
    L9:
        sb.append(ramKb);
    }

    public static boolean procStatesDifferForMem(int procState1, int procState2) {
        if (sProcStateToProcMem[procState1] == sProcStateToProcMem[procState2]) goto L5;
        return true;
    L5:
        return false;
    }

    public static long minTimeFromStateChange(boolean test) {
        if (test == false) goto L4;
        return JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
    L4:
        return 15000;
    }

    public static long computeNextPssTime(int procState, ProcStateMemTracker tracker, boolean test, boolean sleeping, long now, long earliest) {
        int memState = sProcStateToProcMem[procState];
        if (tracker != null) goto L5;
        boolean first = true;
        float scalingFactor = 1.0f;
    L18:
        if (test == false) goto L22;
        if (first == false) goto L21;
        long[] table = sTestFirstPssTimes;
    L29:
        long delay = (long) (table[memState] * scalingFactor);
        if (delay <= 3600000) goto L33;
        delay = 3600000;
    L33:
        return Math.max(now + delay, earliest);
    L21:
        table = sTestSamePssTimes;
        goto L29
    L22:
        if (first == false) goto L26;
        if (sleeping == false) goto L25;
        table = sFirstAsleepPssTimes;
        goto L29
    L25:
        table = sFirstAwakePssTimes;
        goto L29
    L26:
        if (sleeping == false) goto L28;
        table = sSameAsleepPssTimes;
        goto L29
    L28:
        table = sSameAwakePssTimes;
        goto L29
    L5:
        if (memState >= tracker.mTotalHighestMem) goto L7;
        int highestMemState = memState;
    L9:
        if (highestMemState >= tracker.mHighestMem[memState]) goto L11;
        first = true;
    L12:
        tracker.mPendingMemState = memState;
        tracker.mPendingHighestMemState = highestMemState;
        if (first == false) goto L15;
        scalingFactor = 1.0f;
        tracker.mPendingScalingFactor = 1.0f;
        goto L18
    L15:
        scalingFactor = tracker.mScalingFactor[memState];
        tracker.mPendingScalingFactor = 1.5f * scalingFactor;
        goto L18
    L11:
        first = false;
        goto L12
    L7:
        highestMemState = tracker.mTotalHighestMem;
        goto L9
    }

    long getMemLevel(int adjustment) {
        int i = 0;
    L4:
        if (i >= this.mOomAdj.length) goto L11;
        if (adjustment <= this.mOomAdj[i]) goto L8;
        i = i + 1;
        goto L4
    L8:
        return this.mOomMinFree[i] * 1024;
    L11:
        return this.mOomMinFree[this.mOomAdj.length - 1] * 1024;
    }

    long getCachedRestoreThresholdKb() {
        return this.mCachedRestoreLevel;
    }

    AppStartInfoTracker getAppStartInfoTracker() {
        return this.mAppStartInfoTracker;
    }

    public static void setOomAdj(int pid, int uid, int amt) {
        if (pid > 0) goto L5;
        return;
    L5:
        if (amt != 1001) goto L7;
        return;
    L7:
        long start = SystemClock.elapsedRealtime();
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.putInt(1);
        buf.putInt(pid);
        buf.putInt(uid);
        buf.putInt(amt);
        writeLmkd(buf, null);
        long now = SystemClock.elapsedRealtime();
        if ((now - start) <= 250) goto L11;
        Slog.w("ActivityManager", "SLOW OOM ADJ(DEF): " + (now - start) + "ms for pid " + pid + " = " + amt);
        return;
    }

    public static void setOomAdjext(int pid, int uid, int amtext) {
        if (pid > 0) goto L4;
        return;
    L4:
        if (amtext >= 0) goto L6;
        return;
    L6:
        if (amtext > 100) goto L14;
        long start = SystemClock.elapsedRealtime();
        ByteBuffer buf = ByteBuffer.allocate(20);
        buf.putInt(1);
        buf.putInt(pid);
        buf.putInt(uid);
        buf.putInt(amtext);
        buf.putInt(3);
        writeLmkd(buf, null);
        long now = SystemClock.elapsedRealtime();
        if ((now - start) <= 250) goto L13;
        Slog.w("ActivityManager", "SLOW OOM ADJEXT(PROC_TYPE_APP_EXT): " + (now - start) + "ms for pid " + pid + " = " + amtext);
        return;
    L13:
        return;
    }

    public static void adjustOomWaterLevel(int action) {
        if (action != 50) goto L5;
    L7:
        long start = SystemClock.elapsedRealtime();
        ByteBuffer buf = ByteBuffer.allocate(20);
        buf.putInt(1);
        buf.putInt(0);
        buf.putInt(0);
        buf.putInt(action);
        buf.putInt(4);
        writeLmkd(buf, null);
        long now = SystemClock.elapsedRealtime();
        if ((now - start) <= 250) goto L11;
        Slog.w("ActivityManager", "SLOW OOM ADJEXT(PROC_TYPE_ADJUST_WL): " + (now - start) + "ms for action = " + action);
        return;
    L11:
        return;
    L5:
        if (action == 100) goto L7;
    }

    public static void setOomAdjExt(int pid, int uid, int amt, int isSystemApp, int isMainProc) {
        if (pid > 0) goto L5;
        return;
    L5:
        if (amt != 1001) goto L7;
        return;
    L7:
        long start = SystemClock.elapsedRealtime();
        ByteBuffer buf = ByteBuffer.allocate(24);
        buf.putInt(1);
        buf.putInt(pid);
        buf.putInt(uid);
        buf.putInt(amt);
        buf.putInt(isSystemApp);
        buf.putInt(isMainProc);
        writeLmkd(buf, null);
        long now = SystemClock.elapsedRealtime();
        if ((now - start) <= 250) goto L11;
        Slog.w("ActivityManager", "SLOW OOM ADJ: " + (now - start) + "ms for pid " + pid + " = " + amt);
        return;
    }

    public static void batchSetOomAdj(ArrayList<ProcessRecord> apps) {
        int totalApps = apps.size();
        if (totalApps != 0) goto L5;
        return;
    L5:
        ByteBuffer buf = ByteBuffer.allocate(52);
        int total_procs_in_buf = 0;
        buf.putInt(11);
        int i = 0;
    L7:
        if (i >= totalApps) goto L18;
        int pid = apps.get(i).getPid();
        int amt = apps.get(i).mState.getCurAdj();
        int uid = apps.get(i).uid;
        if (pid <= 0) goto L17;
        if (amt == 1001) goto L17;
        if (total_procs_in_buf < 3) goto L16;
        writeLmkd(buf, null);
        buf.clear();
        total_procs_in_buf = 0;
        ByteBuffer.allocate(52);
        buf.putInt(11);
    L16:
        buf.putInt(pid);
        buf.putInt(uid);
        buf.putInt(amt);
        buf.putInt(0);
        total_procs_in_buf = total_procs_in_buf + 1;
    L17:
        i = i + 1;
        goto L7
    L18:
        writeLmkd(buf, null);
    }

    public static void batchSetOomAdjExt(ArrayList<ProcessRecord> apps) {
        int totalApps = apps.size();
        if (totalApps != 0) goto L5;
        return;
    L5:
        ByteBuffer buf = ByteBuffer.allocate(76);
        int total_procs_in_buf = 0;
        buf.putInt(11);
        int i = 0;
    L7:
        if (i >= totalApps) goto L24;
        int pid = apps.get(i).getPid();
        int amt = apps.get(i).mState.getCurAdj();
        int uid = apps.get(i).uid;
        if (pid <= 0) goto L23;
        if (amt == 1001) goto L23;
        if (total_procs_in_buf < 3) goto L16;
        writeLmkd(buf, null);
        buf.clear();
        total_procs_in_buf = 0;
        ByteBuffer.allocate(76);
        buf.putInt(11);
    L16:
        String packageName = apps.get(i).info.packageName;
        String processName = apps.get(i).processName;
        int isMainProc = 0;
        int isSystemApp = 0;
        if (packageName.equals(processName) == false) goto L20;
        isMainProc = 1;
    L20:
        if (apps.get(i).info.isSystemApp() == false) goto L22;
        isSystemApp = 1;
    L22:
        buf.putInt(pid);
        buf.putInt(uid);
        buf.putInt(amt);
        buf.putInt(isSystemApp);
        buf.putInt(isMainProc);
        buf.putInt(0);
        total_procs_in_buf = total_procs_in_buf + 1;
    L23:
        i = i + 1;
        goto L7
    L24:
        writeLmkd(buf, null);
    }

    public static final void remove(int pid) {
        if (pid > 0) goto L4;
        return;
    L4:
        ByteBuffer buf = ByteBuffer.allocate(8);
        buf.putInt(2);
        buf.putInt(pid);
        writeLmkd(buf, null);
    }

    public static final Integer getLmkdKillCount(int min_oom_adj, int max_oom_adj) {
        ByteBuffer buf = ByteBuffer.allocate(12);
        ByteBuffer repl = ByteBuffer.allocate(8);
        buf.putInt(4);
        buf.putInt(min_oom_adj);
        buf.putInt(max_oom_adj);
        repl.putInt(4);
        repl.rewind();
        if (writeLmkd(buf, repl) == true) goto L5;
        return null;
    L5:
        if (repl.getInt() == 4) goto L7;
        return null;
    L7:
        return new Integer(repl.getInt());
    }

    public boolean onLmkdConnect(OutputStream ostream) {
        ByteBuffer buf = ByteBuffer.allocate(4);     // Catch: IOException -> L9
        buf.putInt(3);     // Catch: IOException -> L9
        ostream.write(buf.array(), 0, buf.position());     // Catch: IOException -> L9
        if (this.mOomLevelsSet == false) goto L12;
        ByteBuffer buf2 = ByteBuffer.allocate(((this.mOomAdj.length * 2) + 1) * 4);     // Catch: IOException -> L9
        buf2.putInt(0);     // Catch: IOException -> L9
        int i = 0;
    L7:
        if (i >= this.mOomAdj.length) goto L11;
        buf2.putInt((this.mOomMinFree[i] * 1024) / PAGE_SIZE);     // Catch: IOException -> L9
        buf2.putInt(this.mOomAdj[i]);     // Catch: IOException -> L9
        i = i + 1;     // Catch: IOException -> L9
        goto L7
    L11:
        ostream.write(buf2.array(), 0, buf2.position());     // Catch: IOException -> L9
    L12:
        ByteBuffer buf3 = ByteBuffer.allocate(8);     // Catch: IOException -> L9
        buf3.putInt(5);     // Catch: IOException -> L9
        buf3.putInt(0);     // Catch: IOException -> L9
        ostream.write(buf3.array(), 0, buf3.position());     // Catch: IOException -> L9
        ByteBuffer buf4 = ByteBuffer.allocate(8);     // Catch: IOException -> L9
        buf4.putInt(5);     // Catch: IOException -> L9
        buf4.putInt(1);     // Catch: IOException -> L9
        ostream.write(buf4.array(), 0, buf4.position());     // Catch: IOException -> L9
        return true;
    L15:
        return false;
    }

    public static void startPsiMonitoringAfterBoot() {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putInt(9);
        writeLmkd(buf, null);
    }

    protected static boolean writeLmkd(ByteBuffer buf, ByteBuffer repl) {
        if (sLmkdConnection.isConnected() == true) goto L9;
        sKillHandler.sendMessage(sKillHandler.obtainMessage(4001));
        if (sLmkdConnection.waitForConnection(BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS) == true) goto L9;
        return false;
    L9:
        return sLmkdConnection.exchange(buf, repl);
    }

    static void killProcessGroup(int uid, int pid) {
        if (sKillHandler == null) goto L5;
        sKillHandler.sendMessage(sKillHandler.obtainMessage(4000, uid, pid));
        return;
    L5:
        Slog.w("ActivityManager", "Asked to kill process group before system bringup!");
        Process.killProcessGroup(uid, pid);
    }

    ProcessRecord getProcessRecordLocked(String processName, int uid) {
        if (uid != 1000) goto L19;
        SparseArray<ProcessRecord> procs = (SparseArray) this.mProcessNames.getMap().get(processName);
        if (procs != null) goto L8;
        return null;
    L8:
        int procCount = procs.size();
        int i = 0;
    L9:
        if (i >= procCount) goto L19;
        int procUid = procs.keyAt(i);
        if (UserHandle.isCore(procUid) == false) goto L17;
        if (UserHandle.isSameUser(procUid, uid) == false) goto L17;
        return procs.valueAt(i);
    L17:
        i = i + 1;
    L19:
        return (ProcessRecord) this.mProcessNames.get(processName, uid);
    }

    void getMemoryInfo(ActivityManager.MemoryInfo outInfo) {
        long homeAppMem = getMemLevel(600);
        long cachedAppMem = getMemLevel(900);
        outInfo.advertisedMem = Process.getAdvertisedMem();
        outInfo.availMem = Process.getFreeMemory();
        outInfo.totalMem = Process.getTotalMemory();
        outInfo.threshold = homeAppMem;
        if (outInfo.availMem >= (((cachedAppMem - homeAppMem) / 2) + homeAppMem)) goto L5;
        boolean r4 = true;
    L6:
        outInfo.lowMemory = r4;
        outInfo.hiddenAppThreshold = cachedAppMem;
        outInfo.secondaryServerThreshold = getMemLevel(500);
        outInfo.visibleAppThreshold = getMemLevel(100);
        outInfo.foregroundAppThreshold = getMemLevel(0);
        return;
    L5:
        r4 = false;
        goto L6
    }

    ProcessRecord findAppProcessLOSP(IBinder app, String reason) {
        return findAppProcessLOSP(app, reason, 0);
    }

    ProcessRecord findAppProcessLOSP(IBinder app, String reason, int includeSmtProcess) {
        int NP = this.mProcessNames.getMap().size();
        int ip = 0;
    L3:
        if (ip >= NP) goto L14;
        SparseArray<ProcessRecord> apps = (SparseArray) this.mProcessNames.getMap().valueAt(ip);
        int NA = apps.size();
        int ia = 0;
    L5:
        if (ia >= NA) goto L12;
        ProcessRecord p = apps.valueAt(ia);
        IApplicationThread thread = p.getThread();
        if (thread == null) goto L11;
        if (thread.asBinder() != app) goto L11;
        return p;
    L11:
        ia = ia + 1;
        goto L5
    L12:
        ip = ip + 1;
        goto L3
    L14:
        if (includeSmtProcess == 0) goto L18;
        ProcessRecord proc = SysOptBridge.getFactory().getProcessListOptEx().findAppProcessSmtLocked(app, includeSmtProcess);
        if (proc == null) goto L18;
        return proc;
    L18:
        Slog.w("ActivityManager", "Can't find mystery application for " + reason + " from pid=" + Binder.getCallingPid() + " uid=" + Binder.getCallingUid() + ": " + app);
        return null;
    }

    private void checkSlow(long startTime, String where) {
        long now = SystemClock.uptimeMillis();
        if ((now - startTime) <= 50) goto L6;
        Slog.w("ActivityManager", "Slow operation: " + (now - startTime) + "ms so far, now at " + where);
        return;
    }

    private int[] computeGidsForProcess(int mountExternal, int uid, int[] permGids, boolean externalStorageAccess) {
        ArrayList<Integer> gidList = new ArrayList(permGids.length + 5);
        int sharedAppGid = UserHandle.getSharedAppGid(UserHandle.getAppId(uid));
        int cacheAppGid = UserHandle.getCacheAppGid(UserHandle.getAppId(uid));
        int userGid = UserHandle.getUserGid(UserHandle.getUserId(uid));
        int r4 = permGids.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L6;
        int permGid = permGids[r5];
        gidList.add(Integer.valueOf(permGid));
        r5 = r5 + 1;
        goto L3
    L6:
        if (sharedAppGid == (-1)) goto L8;
        gidList.add(Integer.valueOf(sharedAppGid));
    L8:
        if (cacheAppGid == (-1)) goto L10;
        gidList.add(Integer.valueOf(cacheAppGid));
    L10:
        if (userGid == (-1)) goto L13;
        gidList.add(Integer.valueOf(userGid));
    L13:
        if (mountExternal == 4) goto L15;
        if (mountExternal == 3) goto L15;
    L17:
        if (mountExternal != 2) goto L19;
        gidList.add(1079);
    L19:
        if (mountExternal != 3) goto L21;
        gidList.add(1023);
    L21:
        DoppelgangerUtils.computeGidsForProcess(gidList, uid);
        if (externalStorageAccess == false) goto L24;
        gidList.add(1077);
    L24:
        int[] gidArray = new int[gidList.size()];
        int i = 0;
    L26:
        if (i >= gidArray.length) goto L29;
        gidArray[i] = gidList.get(i).intValue();
        i = i + 1;
        goto L26
    L29:
        return gidArray;
    L15:
        gidList.add(Integer.valueOf(UserHandle.getUid(UserHandle.getUserId(uid), 1015)));
        gidList.add(1078);
        gidList.add(1079);
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean startProcessLocked(ProcessRecord r36, HostingRecord r37, int r38, boolean r39, boolean r40, String r41) {
        ProcessList r2 = this;
        int r1 = 1;
        if (r36.isPendingStart() == false) goto L5;
        return true;
    L5:
        SysOptBridge.getFactory().getSmartScenes().updateProcessState(r36.processName, r36.info, true, false);
        r2.mSmtEx.updateAppTypeMayFromExpandService(r36);
        long r3 = SystemClock.uptimeMillis();
        long r17 = SystemClock.elapsedRealtime();
        if (r36.getPid() > 0) goto L8;
    L23:
        r36.unlinkDeathRecipient();
        r36.setDyingPid(0);
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == true) goto L26;
    L28:
        r2.mService.mProcessesOnHold.remove(r36);
        r2.checkSlow(r3, "startProcess: starting to update cpu stats");
        r2.mService.updateCpuStats();
        r2.checkSlow(r3, "startProcess: done updating cpu stats");
        int r0 = UserHandle.getUserId(r36.uid);     // Catch: RuntimeException -> L230
        AppGlobals.getPackageManager().checkPackageStartable(r36.info.packageName, r0);     // Catch: RuntimeException -> L230 RemoteException -> L232
        int r4 = r36.uid;     // Catch: RuntimeException -> L230
        int r10 = 0;
        if (r36.isolated == false) goto L262;
        int r16 = 0;
        int r14 = r0;
        int[] r7 = null;
    L243:
        r36.setMountMode(r10);     // Catch: RuntimeException -> L227
        r2.checkSlow(r3, "startProcess: building args");     // Catch: RuntimeException -> L227
        if (r36.getWindowProcessController().isFactoryTestProcess() == false) goto L83;
        int r6 = 0;
    L84:
        int r5 = 0;
        if ((r36.info.flags & 2) == 0) goto L87;
        int r8 = 1;
    L88:
        boolean r9 = r36.info.isProfileableByShell();     // Catch: RuntimeException -> L227
        boolean r11 = r36.info.isProfileable();     // Catch: RuntimeException -> L227
        if (r36.isSdkSandbox == false) goto L97;
        ApplicationInfo r12 = r36.getClientInfoForSdkSandbox();     // Catch: RuntimeException -> L47
        if (r12 == null) goto L97;
        if ((r12.flags & 2) == 0) goto L95;
        int r13 = 1;
    L96:
        int r20 = r8 | r13;     // Catch: RuntimeException -> L47
        boolean r21 = r9 | r12.isProfileableByShell();     // Catch: RuntimeException -> L47
        boolean r22 = r11 | r12.isProfileable();     // Catch: RuntimeException -> L47
    L98:
        if (r20 == 0) goto L104;
        r5 = (((0 | 1) | 33554432) | 256) | 2;     // Catch: RuntimeException -> L47
        if (Settings.Global.getInt(r2.mService.mContext.getContentResolver(), "art_verifier_verify_debuggable", 1) != 0) goto L104;
        r5 = r5 | 512;     // Catch: RuntimeException -> L47
        Slog.w("ActivityManager", r36 + ": ART verification disabled");     // Catch: RuntimeException -> L47
    L104:
        if ((r36.info.flags & 16384) == 0) goto L106;
    L107:
        r5 = r5 | 8;
    L108:
        if (r21 == false) goto L110;
        r5 = r5 | 32768;
    L110:
        if (r22 == false) goto L113;
        r5 = r5 | 16777216;
    L113:
        if ("1".equals(SystemProperties.get("debug.checkjni")) == false) goto L115;
        r5 = r5 | 2;     // Catch: RuntimeException -> L227
    L115:
        String r15 = SystemProperties.get("debug.generate-debug-info");     // Catch: RuntimeException -> L227
        if ("1".equals(r15) == false) goto L118;
    L119:
        r5 = r5 | 32;
    L120:
        String r18 = SystemProperties.get("dalvik.vm.minidebuginfo");     // Catch: RuntimeException -> L227
        if ("1".equals(r18) == false) goto L123;
    L124:
        r5 = r5 | 2048;
    L126:
        if ("1".equals(SystemProperties.get("debug.jni.logging")) == false) goto L129;
        r5 = r5 | 16;     // Catch: RuntimeException -> L227
    L129:
        if ("1".equals(SystemProperties.get("debug.assert")) == false) goto L132;
        r5 = r5 | 4;     // Catch: RuntimeException -> L227
    L132:
        if ("1".equals(SystemProperties.get("debug.ignoreappsignalhandler")) == false) goto L135;
        r5 = r5 | 131072;     // Catch: RuntimeException -> L227
    L135:
        if (r2.mService.mNativeDebuggingApp == null) goto L140;
        if (r2.mService.mNativeDebuggingApp.equals(r36.processName) == false) goto L140;
        r5 = ((r5 | 64) | 32) | 128;     // Catch: RuntimeException -> L47
        r2.mService.mNativeDebuggingApp = null;     // Catch: RuntimeException -> L47
    L140:
        if (r36.info.isEmbeddedDexUsed() == false) goto L142;
    L145:
        r5 = r5 | 1024;     // Catch: RuntimeException -> L47
    L146:
        if (r39 == false) goto L148;
    L156:
        String r19 = SystemProperties.get(PROPERTY_USE_APP_IMAGE_STARTUP_CACHE, "");     // Catch: RuntimeException -> L227
        if (TextUtils.isEmpty(r19) == true) goto L164;
        if (r19.equals("false") == true) goto L164;
        r5 = r5 | 65536;
    L164:
        if (Os.sysconf(OsConstants._SC_PAGESIZE) == 16384) goto L167;
        r1 = r16;
    L167:
        if (r1 != 0) goto L169;
    L171:
        int r23 = r5;
    L172:
        String r110 = null;
        if (r20 == 0) goto L190;
        String r24 = r36.info.nativeLibraryDir + "/wrap.sh";     // Catch: RuntimeException -> L47
        StrictMode.ThreadPolicy r25 = StrictMode.allowThreadDiskReads();     // Catch: RuntimeException -> L47
    L184:
        th = th;
    L188:
        StrictMode.setThreadPolicy(r25);     // Catch: RuntimeException -> L47
        throw th;     // Catch: RuntimeException -> L47
    L177:
        if (new File(r24).exists() == false) goto L187;
        StringBuilder r26 = new StringBuilder();     // Catch: Throwable -> L184
        r26.append("/system/bin/logwrapper ");     // Catch: Throwable -> L182
        r26.append(r24);     // Catch: Throwable -> L182
        r110 = r26.toString();     // Catch: Throwable -> L182
    L182:
        th = th;
    L187:
        StrictMode.setThreadPolicy(r25);     // Catch: RuntimeException -> L47
    L191:
        if (r41 == null) goto L193;
        String r27 = r41;
    L194:
        if (r27 != null) goto L199;
        r27 = Build.SUPPORTED_ABIS[r16];     // Catch: RuntimeException -> L47
    L199:
        if (r36.info.primaryCpuAbi == null) goto L202;
        String r111 = VMRuntime.getInstructionSet(r27);     // Catch: RuntimeException -> L47
    L203:
        r36.setGids(r7);     // Catch: RuntimeException -> L227
        r36.setRequiredAbi(r27);     // Catch: RuntimeException -> L227
        r36.setInstructionSet(r111);     // Catch: RuntimeException -> L227
        if (r37.getDefiningPackageName() == null) goto L207;
        ApplicationInfo r28 = new ApplicationInfo(r36.info);     // Catch: RuntimeException -> L47
        r28.packageName = r37.getDefiningPackageName();     // Catch: RuntimeException -> L47
        r28.uid = r6;     // Catch: RuntimeException -> L47
    L208:
        String r29 = r27;
        int r30 = r23 | Zygote.getMemorySafetyRuntimeFlags(r28, r36.processInfo, r111, r2.mPlatformCompat);     // Catch: RuntimeException -> L227
        if (TextUtils.isEmpty(r36.info.seInfoUser) == true) goto L249;
        long r210 = r3;
    L251:
        return startProcessLocked(r37, "android.app.ActivityThread", r36, r6, r7, r30, r38, r10, updateSeInfo(r36), r29, r111, r110, r210, r17);
    L225:
        e = e;
        r2 = this;
        boolean r211 = r16;
    L235:
        Slog.e("ActivityManager", "Failure starting process " + r36.processName, e);
        r2.mService.forceStopPackageLocked(r36.info.packageName, UserHandle.getAppId(r36.uid), false, false, true, false, false, false, r36.userId, "start failure");
        return r211;
    L249:
        StringBuilder r31 = new StringBuilder();     // Catch: RuntimeException -> L216
        r210 = r3;
        r31.append("SELinux tag not defined for ");     // Catch: RuntimeException -> L214
        r31.append(r36.info.packageName);     // Catch: RuntimeException -> L214
        r31.append(" (uid ");     // Catch: RuntimeException -> L214
        r31.append(r36.uid);     // Catch: RuntimeException -> L214
        r31.append(")");     // Catch: RuntimeException -> L214
        Slog.wtf("ActivityManager", "SELinux tag not defined", new IllegalStateException(r31.toString()));     // Catch: RuntimeException -> L214
    L214:
        e = e;
        r2 = this;
        r211 = r16;
    L216:
        e = e;
        r2 = this;
        r211 = r16;
        goto L235
    L207:
        r28 = r36.info;     // Catch: RuntimeException -> L227
        goto L208
    L202:
        r111 = null;
        goto L203
    L193:
        r27 = r36.info.primaryCpuAbi;     // Catch: RuntimeException -> L227
        goto L194
    L190:
        r23 = r23;
        goto L191
    L169:
        if (r2.mService.mContext.getPackageManager().isPageSizeCompatEnabled(r36.info.packageName) == false) goto L171;
        r23 = r5 | 67108864;     // Catch: RuntimeException -> L47
        goto L172
    L148:
        if (r2.mService.mHiddenApiBlacklist.isDisabled() == true) goto L156;
        r36.info.maybeUpdateHiddenApiEnforcementPolicy(r2.mService.mHiddenApiBlacklist.getPolicy());     // Catch: RuntimeException -> L47
        int r112 = r36.info.getHiddenApiEnforcementPolicy();     // Catch: RuntimeException -> L47
        int r113 = r112 << Zygote.API_ENFORCEMENT_POLICY_SHIFT;     // Catch: RuntimeException -> L47
        if ((r113 & 12288) != r113) goto L155;
        r5 = r5 | r113;     // Catch: RuntimeException -> L47
        if (r40 == false) goto L156;
        r5 = r5 | 262144;     // Catch: RuntimeException -> L47
        goto L156
    L155:
        throw new IllegalStateException("Invalid API policy: " + r112);     // Catch: RuntimeException -> L47
    L142:
        if (r36.processInfo == null) goto L146;
        if (r36.processInfo.useEmbeddedDex == false) goto L146;
    L123:
        if ("true".equals(r18) == false) goto L126;
    L118:
        if ("true".equals(r15) == false) goto L120;
    L106:
        if (r2.mService.mSafeMode == false) goto L108;
    L95:
        r13 = r16;
    L97:
        r20 = r8;
        r21 = r9;
        r22 = r11;
        goto L98
    L87:
        r8 = r16;
        goto L88
    L83:
        r6 = r4;
    L227:
        e = e;
        int r212 = r16;
    L229:
        r211 = r212;
        goto L235
    L262:
        r2.checkSlow(r3, "startProcess: getting gids from package manager");     // Catch: RuntimeException -> L73 RemoteException -> L75
        IPackageManager r32 = AppGlobals.getPackageManager();     // Catch: RuntimeException -> L73 RemoteException -> L75
    L237:
        int[] r114 = r32.getPackageGids(r36.info.packageName, 268435456, r36.userId);     // Catch: RuntimeException -> L51 RemoteException -> L56
        StorageManagerInternal r33 = (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);     // Catch: RuntimeException -> L51 RemoteException -> L56
        r10 = r33.getExternalStorageMountMode(r4, r36.info.packageName);     // Catch: RuntimeException -> L51 RemoteException -> L56
        boolean r34 = r33.hasExternalStorageAccess(r4, r36.info.packageName);     // Catch: RuntimeException -> L51 RemoteException -> L56
        if (r2.mService.isAppFreezerExemptInstPkg() == false) goto L58;
        r14 = r0;
    L53:
        e = e;
    L78:
        throw e.rethrowAsRuntimeException();     // Catch: RuntimeException -> L47
    L42:
        if (r32.checkPermission("android.permission.INSTALL_PACKAGES", r36.info.packageName, r14) != 0) goto L61;
        StringBuilder r115 = new StringBuilder();     // Catch: RuntimeException -> L51 RemoteException -> L53
    L245:
        r115.append(r36.info.packageName);     // Catch: RuntimeException -> L47 RemoteException -> L49
        r115.append(" is exempt from freezer");     // Catch: RuntimeException -> L47 RemoteException -> L49
        Slog.i("ActivityManager", r115.toString());     // Catch: RuntimeException -> L47 RemoteException -> L49
        r36.mOptRecord.setFreezeExempt(true);     // Catch: RuntimeException -> L47 RemoteException -> L49
    L49:
        e = e;
    L61:
        if (r36.processInfo != null) goto L63;
    L72:
        r7 = r2.computeGidsForProcess(r10, r4, r114, r34);     // Catch: RuntimeException -> L47
        goto L243
    L63:
        if (r36.processInfo.deniedPermissions == null) goto L72;
        int r35 = r36.processInfo.deniedPermissions.size() - 1;     // Catch: RuntimeException -> L47
    L65:
        if (r35 < 0) goto L72;
        int[] r42 = r2.mService.mPackageManagerInt.getPermissionGids((String) r36.processInfo.deniedPermissions.valueAt(r35), r36.userId);     // Catch: RuntimeException -> L47
        if (r42 == null) goto L71;
        int r43 = r42.length;     // Catch: RuntimeException -> L47
        int r116 = 0;
    L69:
        if (r116 >= r43) goto L71;
        r114 = ArrayUtils.removeInt(r114, r42[r116]);     // Catch: RuntimeException -> L47
        r116 = r116 + 1;     // Catch: RuntimeException -> L47
    L71:
        r35 = r35 - 1;     // Catch: RuntimeException -> L47
        goto L65
    L58:
        r14 = r0;
    L56:
        e = e;
    L51:
        e = e;
        boolean r117 = false;
    L48:
        r211 = r117;
    L75:
        e = e;
    L73:
        e = e;
        r117 = false;
    L47:
        e = e;
        goto L48
    L232:
        e = move-exception;
        throw e.rethrowAsRuntimeException();     // Catch: RuntimeException -> L223
    L223:
        e = e;
    L230:
        e = e;
        r212 = 0;
        goto L229
    L26:
        if (r2.mService.mProcessesOnHold.contains(r36) == false) goto L28;
        Slog.v("ActivityManager", "startProcessLocked removing on hold: " + r36);
        goto L28
    L8:
        if (r36.getPid() == ActivityManagerService.MY_PID) goto L23;
        r2.checkSlow(r3, "startProcess: removing from pids map");
        ActivityManagerService.PidMap r44 = r2.mService.mPidsSelfLocked;
        monitor-enter(r44);
        r2.mService.getSmtEx().mPrefetchPidsSelf.doRemoveInternal(r36.getPid(), r36);     // Catch: Throwable -> L20
        SysOptBridge.getFactory().getSysPrefetchService().removePrefetchApp(r36.getPid(), 1);     // Catch: Throwable -> L20
        monitor-exit(r44);     // Catch: Throwable -> L20
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(r36.info.getSysEx().prefetchState) == false) goto L17;
        SysOptBridge.getFactory().getSysPrefetchService().addUnLaunchedPrefetchProcess(r36.getPid(), r36);
    L17:
        if (ProcessSmtEx.inPrefetchState(r36.info.getSysEx().prefetchState) == false) goto L19;
        SysOptBridge.getFactory().getSysPrefetchService().addUnLaunchedPrefetchProcess(r36.getPid(), r36);
    L19:
        r2.mService.removePidLocked(r36.getPid(), r36);
        r36.setBindMountPending(false);
        r2.mService.mHandler.removeMessages(20, r36);
        r2.checkSlow(r3, "startProcess: done removing from pids map");
        SysOptBridge.getFactory().getWarmStartPidCache().removeIfPidMatches(r36.uid, r36.processName, r36.getPid());
        r36.setPid(0);
        r36.setStartSeq(0);
    L20:
        th = move-exception;
        throw th;
    }

    String updateSeInfo(ProcessRecord app) {
        String extraInfo = "";
        if (app.isSdkSandbox == false) goto L13;
        if (getProcessListSettingsListener().applySdkSandboxRestrictionsNext() == false) goto L8;
        extraInfo = APPLY_SDK_SANDBOX_NEXT_RESTRICTIONS;
        goto L13
    L8:
        if (com.android.internal.hidden_from_bootclasspath.com.android.sdksandbox.flags.Flags.selinuxSdkSandboxAudit() == false) goto L13;
        if (getProcessListSettingsListener().applySdkSandboxRestrictionsAudit() == false) goto L13;
        extraInfo = APPLY_SDK_SANDBOX_AUDIT_RESTRICTIONS;
    L13:
        if (com.android.internal.hidden_from_bootclasspath.com.android.sdksandbox.flags.Flags.selinuxInputSelector() == true) goto L15;
        StringBuilder r1 = new StringBuilder();
        r1.append(app.info.seInfo);
        if (TextUtils.isEmpty(app.info.seInfoUser) == false) goto L19;
        String r2 = "";
    L20:
        r1.append(r2);
        r1.append(extraInfo);
        return r1.toString();
    L19:
        r2 = app.info.seInfoUser;
        goto L20
    L15:
        return app.info.seInfo + extraInfo + TextUtils.emptyIfNull(app.info.seInfoUser);
    }

    boolean startProcessLocked(HostingRecord hostingRecord, final String entryPoint, final ProcessRecord app, int uid, final int[] gids, final int runtimeFlags, final int zygotePolicyFlags, final int mountExternal, String seInfo, final String requiredAbi, final String instructionSet, final String invokeWith, long startUptime, long startElapsedTime) {
        app.setPendingStart(true);
        app.setRemoved(false);
        ActivityManagerGlobalLock r3 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r3);
        app.setKilledByAm(false);     // Catch: Throwable -> L51
        app.setKilled(false);     // Catch: Throwable -> L51
        monitor-exit(r3);     // Catch: Throwable -> L51
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        if (app.getStartSeq() == 0) goto L10;
        Slog.wtf("ActivityManager", "startProcessLocked processName:" + app.processName + " with non-zero startSeq:" + app.getStartSeq());
    L10:
        if (app.getPid() == 0) goto L12;
        Slog.wtf("ActivityManager", "startProcessLocked processName:" + app.processName + " with non-zero pid:" + app.getPid());
    L12:
        app.setDisabledCompatChanges(null);
        app.setLoggableCompatChanges(null);
        if (this.mPlatformCompat == null) goto L15;
        app.setDisabledCompatChanges(this.mPlatformCompat.getDisabledChanges(app.info));
        app.setLoggableCompatChanges(this.mPlatformCompat.getLoggableChanges(app.info));
    L15:
        final long startSeq = 1 + this.mProcStartSeqCounter;
        this.mProcStartSeqCounter = startSeq;
        app.setStartSeq(startSeq);
        app.setStartParams(uid, hostingRecord, seInfo, startUptime, startElapsedTime);
        if (invokeWith == null) goto L18;
    L21:
        boolean r0 = true;
    L22:
        app.setUsingWrapper(r0);
        this.mPendingStarts.put(startSeq, app);
        if (this.mService.mConstants.FLAG_PROCESS_START_ASYNC == false) goto L61;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L27;
        Slog.i("ActivityManager", "Posting procStart msg for " + app.toShortString());
    L27:
        this.mService.mProcStartHandler.post(new ProcessList$$ExternalSyntheticLambda3(this, app, entryPoint, gids, runtimeFlags, zygotePolicyFlags, mountExternal, requiredAbi, instructionSet, invokeWith, startSeq));
        return true;
    L61:
        boolean r20 = true;
        Process.ProcessStartResult startResult = startProcess(hostingRecord, entryPoint, app, uid, gids, runtimeFlags, zygotePolicyFlags, mountExternal, seInfo, requiredAbi, instructionSet, invokeWith, startUptime, HostingRecord.HOSTING_TYPE_TOP_ACTIVITY.equals(hostingRecord.getType()) | HostingRecord.HOSTING_TYPE_NEXT_TOP_ACTIVITY.equals(hostingRecord.getType()));     // Catch: RuntimeException -> L41
        ProcessRecord r2 = app;
        boolean r8 = false;
        ProcessList r1 = this;
        r1.handleProcessStartedLocked(r2, startResult.pid, startResult.usingWrapper, startSeq, false);     // Catch: RuntimeException -> L37
    L47:
        if (r2.getPid() <= 0) goto L50;
        return r20;
    L50:
        return r8;
    L37:
        e = e;
    L45:
        Slog.e("ActivityManager", "Failure starting process " + r2.processName, e);
        r2.setPendingStart(r8);
        r1.mService.forceStopPackageLocked(r2.info.packageName, UserHandle.getAppId(r2.uid), false, false, true, false, false, false, r2.userId, "start failure");
    L39:
        e = e;
        r2 = app;
        r8 = false;
        r1 = this;
    L41:
        e = e;
        r8 = false;
        r1 = this;
        r2 = app;
    L43:
        e = e;
        r1 = this;
        r2 = app;
        r8 = false;
        r20 = true;
        goto L45
    L18:
        if (Zygote.getWrapProperty(app.processName) != null) goto L21;
        r0 = false;
    L51:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$startProcessLocked$0(ProcessRecord app, String entryPoint, int[] gids, int runtimeFlags, int zygotePolicyFlags, int mountExternal, String requiredAbi, String instructionSet, String invokeWith, long startSeq) {
        handleProcessStart(app, entryPoint, gids, runtimeFlags, zygotePolicyFlags, mountExternal, requiredAbi, instructionSet, invokeWith, startSeq);
    }

    private void handleProcessStart(final ProcessRecord app, final String entryPoint, final int[] gids, final int runtimeFlags, final int zygotePolicyFlags, final int mountExternal, final String requiredAbi, final String instructionSet, final String invokeWith, final long startSeq) {
        Runnable startRunnable = new ProcessList$$ExternalSyntheticLambda0(this, app, entryPoint, gids, runtimeFlags, zygotePolicyFlags, mountExternal, requiredAbi, instructionSet, invokeWith, startSeq);
        ProcessRecord predecessor = app.mPredecessor;
        if (predecessor != null) goto L5;
    L15:
        startRunnable.run();
        return;
    L5:
        if (predecessor.getDyingPid() <= 0) goto L15;
        ActivityManagerService r5 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r5);
        this.mService.appDiedLocked(predecessor, "predecessor long time kill");     // Catch: Throwable -> L11
        startRunnable.run();     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$handleProcessStart$1(ProcessRecord app, String entryPoint, int[] gids, int runtimeFlags, int zygotePolicyFlags, int mountExternal, String requiredAbi, String instructionSet, String invokeWith, long startSeq) {
        ProcessList r2 = this;
        ProcessRecord r5 = app;
        Process.ProcessStartResult startResult = r2.startProcess(app.getHostingRecord(), entryPoint, r5, app.getStartUid(), gids, runtimeFlags, zygotePolicyFlags, mountExternal, app.getSeInfo(), requiredAbi, instructionSet, invokeWith, app.getStartTime(), HostingRecord.HOSTING_TYPE_TOP_ACTIVITY.equals(app.getHostingRecord().getType()) | HostingRecord.HOSTING_TYPE_NEXT_TOP_ACTIVITY.equals(app.getHostingRecord().getType()));     // Catch: RuntimeException -> L17
        ActivityManagerService r3 = r2.mService;     // Catch: RuntimeException -> L17
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: RuntimeException -> L17
        monitor-enter(r3);     // Catch: RuntimeException -> L17
        long r6 = startSeq;
        r2.handleProcessStartedLocked(r5, startResult, r6);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: RuntimeException -> L11
        return;
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: RuntimeException -> L11
        throw th;     // Catch: RuntimeException -> L11
    L11:
        e = e;
    L21:
        RuntimeException e = e;
        ActivityManagerService r4 = r2.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        Slog.e("ActivityManager", "Failure starting process " + r5.processName, e);     // Catch: Throwable -> L27
        r2.mPendingStarts.remove(r6);     // Catch: Throwable -> L27
        r5.setPendingStart(false);     // Catch: Throwable -> L27
        r2.mService.forceStopPackageLocked(r5.info.packageName, UserHandle.getAppId(r5.uid), false, false, true, false, false, false, r5.userId, "start failure");     // Catch: Throwable -> L27
        r5.doEarlyCleanupIfNecessaryLocked();     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L27:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L17:
        e = e;
    L18:
        r6 = startSeq;
    L19:
        e = e;
        r2 = this;
        r5 = app;
        goto L18
    }

    private void handleProcessStartWithPredecessor(ProcessRecord predecessor, Runnable successorStartRunnable) {
        if (predecessor.mSuccessorStartRunnable == null) goto L6;
        Slog.wtf("ActivityManager", "We've been watching for the death of " + predecessor);
        return;
    L6:
        predecessor.mSuccessorStartRunnable = successorStartRunnable;
        this.mService.mProcStartHandler.sendMessageDelayed(this.mService.mProcStartHandler.obtainMessage(2, predecessor), this.mService.mConstants.mProcessKillTimeoutMs);
    }

    private void handlePredecessorProcDied(ProcessRecord app) {
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L5;
        Slog.i("ActivityManager", app.toString() + " is really gone now");
    L5:
        Runnable start = app.mSuccessorStartRunnable;
        if (start == null) goto L9;
        app.mSuccessorStartRunnable = null;
        start.run();
        return;
    }

    public void killAppZygoteIfNeededLocked(AppZygote appZygote, boolean force) {
        ApplicationInfo appInfo = appZygote.getAppInfo();
        ArrayList<ProcessRecord> zygoteProcesses = this.mAppZygoteProcesses.get(appZygote);
        if (zygoteProcesses == null) goto L9;
        if (force == false) goto L6;
    L7:
        this.mAppZygotes.remove(appInfo.processName, appInfo.uid);
        this.mAppZygoteProcesses.remove(appZygote);
        this.mAppIsolatedUidRangeAllocator.freeUidRangeLocked(appInfo);
        appZygote.stopZygote();
        return;
    L6:
        if (zygoteProcesses.size() == 0) goto L7;
        return;
    }

    private void removeProcessFromAppZygoteLocked(ProcessRecord app) {
        IsolatedUidRange appUidRange = this.mAppIsolatedUidRangeAllocator.getIsolatedUidRangeLocked(app.info.processName, app.getHostingRecord().getDefiningUid());
        if (appUidRange == null) goto L5;
        appUidRange.freeIsolatedUidLocked(app.uid);
    L5:
        AppZygote appZygote = (AppZygote) this.mAppZygotes.get(app.info.processName, app.getHostingRecord().getDefiningUid());
        if (appZygote == null) goto L14;
        ArrayList<ProcessRecord> zygoteProcesses = this.mAppZygoteProcesses.get(appZygote);
        zygoteProcesses.remove(app);
        if (zygoteProcesses.size() != 0) goto L15;
        this.mService.mHandler.removeMessages(71);
        if (app.isRemoved() == false) goto L12;
        killAppZygoteIfNeededLocked(appZygote, false);
        return;
    L12:
        Message msg = this.mService.mHandler.obtainMessage(71);
        msg.obj = appZygote;
        this.mService.mHandler.sendMessageDelayed(msg, 5000);
        return;
    L15:
        return;
    }

    private AppZygote createAppZygoteForProcessIfNeeded(ProcessRecord app) {
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        int uid = app.getHostingRecord().getDefiningUid();     // Catch: Throwable -> L9
        AppZygote appZygote = (AppZygote) this.mAppZygotes.get(app.info.processName, uid);     // Catch: Throwable -> L9
        if (appZygote != null) goto L13;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L11;
        Slog.d("ActivityManager", "Creating new app zygote.");     // Catch: Throwable -> L9
    L11:
        IsolatedUidRange uidRange = this.mAppIsolatedUidRangeAllocator.getIsolatedUidRangeLocked(app.info.processName, app.getHostingRecord().getDefiningUid());     // Catch: Throwable -> L9
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L9
        int firstUid = UserHandle.getUid(userId, uidRange.mFirstUid);     // Catch: Throwable -> L9
        int lastUid = UserHandle.getUid(userId, uidRange.mLastUid);     // Catch: Throwable -> L9
        ApplicationInfo appInfo = new ApplicationInfo(app.info);     // Catch: Throwable -> L9
        appInfo.packageName = app.getHostingRecord().getDefiningPackageName();     // Catch: Throwable -> L9
        appInfo.uid = uid;     // Catch: Throwable -> L9
        appZygote = new AppZygote(appInfo, app.processInfo, uid, firstUid, lastUid);     // Catch: Throwable -> L9
        this.mAppZygotes.put(app.info.processName, uid, appZygote);     // Catch: Throwable -> L9
        ArrayList<ProcessRecord> zygoteProcessList = new ArrayList();     // Catch: Throwable -> L9
        this.mAppZygoteProcesses.put(appZygote, zygoteProcessList);     // Catch: Throwable -> L9
    L16:
        zygoteProcessList.add(app);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return appZygote;
    L13:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L15;
        Slog.d("ActivityManager", "Reusing existing app zygote.");     // Catch: Throwable -> L9
    L15:
        this.mService.mHandler.removeMessages(71, appZygote);     // Catch: Throwable -> L9
        zygoteProcessList = this.mAppZygoteProcesses.get(appZygote);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private Map<String, Pair<String, Long>> getPackageAppDataInfoMap(PackageManagerInternal pmInt, String[] packages, int uid) {
        Map<String, Pair<String, Long>> result = new ArrayMap(packages.length);
        int userId = UserHandle.getUserId(uid);
        int r2 = packages.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L13;
        String packageName = packages[r3];
        PackageStateInternal packageState = pmInt.getPackageStateInternal(packageName);
        if (packageState != null) goto L7;
        Slog.w("ActivityManager", "Unknown package:" + packageName);
    L12:
        r3 = r3 + 1;
        goto L3
    L7:
        String volumeUuid = packageState.getVolumeUuid();
        long inode = packageState.getUserStateOrDefault(userId).getCeDataInode();
        if (inode <= 0) goto L9;
        result.put(packageName, Pair.create(volumeUuid, Long.valueOf(inode)));
        goto L12
    L9:
        Slog.w("ActivityManager", packageName + " inode == 0 or app uninstalled with keep-data");
        return null;
    L13:
        return result;
    }

    private boolean needsStorageDataIsolation(StorageManagerInternal storageManagerInternal, ProcessRecord app) {
        int mountMode = app.getMountMode();
        if (this.mVoldAppDataIsolationEnabled == true) goto L5;
    L16:
        return false;
    L5:
        if (UserHandle.isApp(app.uid) == false) goto L16;
        if (storageManagerInternal.isExternalStorageService(app.uid) == true) goto L16;
        if (mountMode == 4) goto L16;
        if (mountMode == 3) goto L16;
        if (mountMode == 2) goto L16;
        if (mountMode == 0) goto L16;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.android.server.am.ProcessList] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.android.server.AppStateTracker] */
    private Process.ProcessStartResult startProcess(HostingRecord r41, String r42, ProcessRecord r43, int r44, int[] r45, int r46, int r47, int r48, String r49, String r50, String r51, String r52, long r53, boolean r55) {
        ?? r1 = this;
        Trace.traceBegin(64, "Start proc: " + r43.processName);     // Catch: Throwable -> L6
        r1.checkSlow(r53, "startProcess: asking zygote to start proc");     // Catch: Throwable -> L6
        boolean r16 = r41.isTopApp();     // Catch: Throwable -> L6
        if (r16 == false) goto L11;
        r43.mState.setHasForegroundActivities(true);     // Catch: Throwable -> L6
    L11:
        if (r1.mAppDataIsolationEnabled == true) goto L13;
    L21:
        boolean r9 = false;
    L22:
        PackageManagerInternal r11 = r1.mService.getPackageManagerInternal();     // Catch: Throwable -> L6
        if (r43.isSdkSandbox == false) goto L25;
        String[] r12 = {r43.sdkSandboxClientAppPackage};     // Catch: Throwable -> L6
    L30:
        boolean r13 = r1.hasAppStorage(r11, r43.info.packageName);     // Catch: Throwable -> L6
        Map<String, Pair<String, Long>> r14 = r1.getPackageAppDataInfoMap(r11, r12, r44);     // Catch: Throwable -> L6
        if (r14 != null) goto L33;
        r9 = false;
    L33:
        ArraySet r15 = new ArraySet(r1.mAppDataIsolationAllowlistedApps);     // Catch: Throwable -> L6
        int r17 = r12.length;     // Catch: Throwable -> L6
        int r6 = 0;
    L35:
        if (r6 >= r17) goto L39;
        r15.remove(r12[r6]);     // Catch: Throwable -> L37
        r6 = r6 + 1;     // Catch: Throwable -> L37
    L37:
        th = th;
        long r27 = 64;
        ?? r2 = r1;
    L169:
        Trace.traceEnd(r27);
        throw th;
    L39:
        Map<String, Pair<String, Long>> r7 = r1.getPackageAppDataInfoMap(r11, (String[]) r15.toArray(new String[0]), r44);     // Catch: Throwable -> L37
        if (r7 != null) goto L42;
        r9 = false;
    L42:
        if (r13 == false) goto L44;
    L46:
        boolean r22 = r9;
    L47:
        int r8 = UserHandle.getUserId(r44);     // Catch: Throwable -> L37
        StorageManagerInternal r10 = (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);     // Catch: Throwable -> L37
        if (r1.needsStorageDataIsolation(r10, r43) == false) goto L54;
        if (r14 != null) goto L51;
    L53:
        r43.setBindMountPending(true);     // Catch: Throwable -> L37
        boolean r23 = false;
    L56:
        if (r43.isolated == false) goto L58;
        Map<String, Pair<String, Long>> r21 = null;
        Map<String, Pair<String, Long>> r20 = null;
    L59:
        String[] r18 = DeviceConfig.getString("app_compat", "appcompat_sysprop_override_pkgs", "").split(",");     // Catch: Throwable -> L37
        String[] r19 = r43.getPackageList();     // Catch: Throwable -> L37
        int r110 = 0;
    L61:
        if (r110 >= r19.length) goto L66;
        if (ArrayUtils.contains(r18, r19[r110]) == true) goto L64;
        r110 = r110 + 1;     // Catch: Throwable -> L37
        goto L61
    L64:
        boolean r24 = true;
    L67:
        ?? r25 = r1.mService.mServices.mAppStateTracker;     // Catch: Throwable -> L37
        if (r25 == 0) goto L82;
        boolean r0 = r25.isAppBackgroundRestricted(r43.info.uid, r43.info.packageName);     // Catch: Throwable -> L37
        if (r0 == false) goto L81;
        ActivityManagerService r111 = r1.mService;     // Catch: Throwable -> L37
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L37
        monitor-enter(r111);     // Catch: Throwable -> L37
        r1.mAppsInBackgroundRestricted.add(r43);     // Catch: Throwable -> L77
        monitor-exit(r111);     // Catch: Throwable -> L77
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L37
        goto L81
    L77:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L81:
        r43.mState.setBackgroundRestricted(r0);     // Catch: Throwable -> L37
    L82:
        r43.mProcessGroupCreated = false;     // Catch: Throwable -> L37
        r43.mSkipProcessGroupCreation = false;     // Catch: Throwable -> L37
        r27 = SystemClock.uptimeNanos();     // Catch: Throwable -> L37
        if (r41.usesWebviewZygote() == true) goto L191;
        boolean r26 = false;
        int r3 = 0;
        r27 = 64;
        if (r41.usesAppZygote() == true) goto L183;
        Map<String, Pair<String, Long>> r112 = r20;
        Map<String, Pair<String, Long>> r113 = r21;
        String r4 = r43.processName;     // Catch: Throwable -> L96
        int r114 = r43.info.targetSdkVersion;     // Catch: Throwable -> L96
        String r115 = r43.info.dataDir;     // Catch: Throwable -> L96
        String r5 = r43.info.packageName;     // Catch: Throwable -> L96
        long[] r116 = r43.getDisabledCompatChanges();     // Catch: Throwable -> L96
        String r28 = "--topapp=" + String.valueOf(r55);     // Catch: Throwable -> L96
        String r29 = "seq=" + r43.getStartSeq();     // Catch: Throwable -> L96
        String r30 = "--memcg-path=" + r43.info.getSysEx().memcgPath;     // Catch: Throwable -> L96
        StringBuilder r31 = new StringBuilder();     // Catch: Throwable -> L96
        r31.append("--pte_start=");     // Catch: Throwable -> L96
        r31.append(r1.mSmtEx.canUsePtePreload(r55, r44, r43.info.packageName, r43.processName));     // Catch: Throwable -> L167
        String[] r210 = {r28, r29, r30, r31.toString()};     // Catch: Throwable -> L167
        int r32 = r44;
        boolean r33 = r55;
        Process.ProcessStartResult r34 = Process.start(r42, r4, r32 == true ? 1 : 0, r44, r45, r46, r48, r114, r49, r50, r51, r115, r52, r5, r47, r16, r116, r112, r113, r22, r23, r24, r210);     // Catch: Throwable -> L165
        Map<String, Pair<String, Long>> r117 = r112;
        ProcessListSmtBase r35 = getSmtEx();     // Catch: Throwable -> L165
        int r36 = r34.pid;     // Catch: Throwable -> L165
        r35.processAppColdLaunch(r36, r43.info, r33);     // Catch: Throwable -> L165
        r43.mProcessGroupCreated = true;     // Catch: Throwable -> L165
        r26 = true;
        r1 = r33;
        int r37 = r32;
        r25 = r36;
    L171:
    L106:
        this.mAppStartInfoTracker.addTimestampToStart(r43, r27, 1);     // Catch: Throwable -> L112
        if (r43.info != null) goto L110;
    L114:
        int r118 = r3;
    L116:
        if (r1 != 0) goto L119;
        if (r118 != 0) goto L119;
    L125:
        if (r26 == true) goto L143;
        monitor-enter(r43);     // Catch: Throwable -> L112
    L134:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L128:
        if (r43.mSkipProcessGroupCreation == true) goto L139;
        int r38 = Process.createProcessGroup(r37, r34.pid);     // Catch: Throwable -> L134
        if (r38 < 0) goto L132;
        r43.mProcessGroupCreated = true;     // Catch: Throwable -> L134
        goto L139
    L132:
        if (r38 != (-OsConstants.ESRCH)) goto L137;
        Slog.e("ActivityManager", "Unable to create process group for " + r43.processName + " (" + r34.pid + ")");     // Catch: Throwable -> L134
        goto L139
    L137:
        throw new AssertionError("Unable to create process group for " + r43.processName + " (" + r34.pid + ")");     // Catch: Throwable -> L134
    L139:
        monitor-exit(r43);     // Catch: Throwable -> L134
    L143:
        if (r23 == false) goto L146;
        r10.prepareStorageDirs(r8, r117.keySet(), r43.processName);     // Catch: Throwable -> L112
    L146:
        SysOptBridge.getFactory().getFreezeController().startProcessEvent(r43, r34.pid);     // Catch: Throwable -> L112
        if (mPerfServiceStartHint == null) goto L174;
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(r43.info.getSysEx().prefetchState) == true) goto L174;
        if (r41.getType() == null) goto L174;
        if (r41.getType().equals(HostingRecord.HOSTING_TYPE_NEXT_ACTIVITY) == false) goto L155;
    L157:
        mPerfServiceStartHint.perfHint(4225, r43.processName, r34.pid, 101);     // Catch: Throwable -> L112
        goto L174
    L155:
        if (r41.getType().equals(HostingRecord.HOSTING_TYPE_NEXT_TOP_ACTIVITY) == true) goto L157;
    L174:
        checkSlow(r53, "startProcess: returned from zygote!");     // Catch: Throwable -> L163
        Trace.traceEnd(r27);
        return r34;
    L163:
        th = th;
    L119:
        if (r43.processName == null) goto L125;
        if (r43.processName.equals(r43.info.packageName) == false) goto L125;
        if (r34.pid <= 0) goto L125;
        this.mService.mWindowManager.getSmtEx().notifyStartEventToResManager(r37, r34.pid, r3, r43.info.packageName);     // Catch: Throwable -> L112
        SysOptBridge.getFactory().getIoLimiter().notifyStartIoLimit(r37, r34.pid);     // Catch: Throwable -> L112
        goto L125
    L110:
        if (r43.info.getSysEx().doPrefetch != 1) goto L114;
        r118 = 1;
    L112:
        th = th;
    L165:
        th = th;
    L167:
        th = th;
        goto L169
    L183:
        int r39 = r44;
        r117 = r20;
        r34 = r1.createAppZygoteForProcessIfNeeded(r43).startProcess(r42, r43.processName, r39, r45, r46, r48, r43.info.targetSdkVersion, r49, r50, r51, r43.info.dataDir, r43.info.packageName, r16, r43.getDisabledCompatChanges(), r117, r21, new String[]{"seq=" + r43.getStartSeq()});     // Catch: Throwable -> L96
        r1 = r55;
        r37 = r39;
        r25 = r39;
    L98:
        th = th;
        r25 = r44;
    L96:
        th = th;
        goto L169
    L191:
        String r40 = r43.processName;     // Catch: Throwable -> L89
        int r54 = r43.info.targetSdkVersion;     // Catch: Throwable -> L89
        String r119 = r43.info.dataDir;     // Catch: Throwable -> L89
        String r120 = r43.info.packageName;     // Catch: Throwable -> L89
        r27 = 64;
        long[] r121 = r43.getDisabledCompatChanges();     // Catch: Throwable -> L87
        r26 = false;
        String[] r56 = {"seq=" + r43.getStartSeq(), "--memcg-path=uid_" + r43.info.uid};     // Catch: Throwable -> L87
        r3 = 0;
        r34 = Process.startWebView(r42, r40, r44, r44, r45, r46, r48, r54, r49, r50, r51, r119, null, r120, r121, r56);     // Catch: Throwable -> L87
        r37 = r44;
        r1 = r55;
        r117 = r20;
    L89:
        th = th;
        r27 = 64;
    L88:
        r2 = r1;
    L87:
        th = th;
        goto L88
    L66:
        r24 = false;
        goto L67
    L58:
        r21 = r7;
        r20 = r14;
        goto L59
    L51:
        if (r10.isFuseMounted(r8) == false) goto L53;
        r23 = true;
        goto L56
    L54:
        r23 = false;
        goto L56
    L44:
        if (r43.isSdkSandbox == true) goto L46;
        r14 = null;
        r7 = null;
        r22 = false;
        goto L47
    L25:
        String[] r122 = r11.getSharedUserPackagesForPackage(r43.info.packageName, r43.userId);     // Catch: Throwable -> L6
        if (r122.length != 0) goto L28;
        String[] r123 = {r43.info.packageName};     // Catch: Throwable -> L6
    L29:
        r12 = r123;
        goto L30
    L28:
        r123 = r122;
        goto L29
    L13:
        if (UserHandle.isApp(r43.uid) == true) goto L19;
        if (UserHandle.isIsolated(r43.uid) == true) goto L19;
        if (r43.isSdkSandbox == false) goto L21;
    L19:
        if (r1.mPlatformCompat.isChangeEnabled(APP_DATA_DIRECTORY_ISOLATION, r43.info) == false) goto L21;
        r9 = true;
    L6:
        th = th;
        r27 = 64;
        r2 = r1;
        goto L169
    }

    private boolean hasAppStorage(PackageManagerInternal pmInt, String packageName) {
        AndroidPackage pkg = pmInt.getPackage(packageName);
        if (pkg != null) goto L6;
        Slog.w("ActivityManager", "Unknown package " + packageName);
        return false;
    L6:
        PackageManager.Property noAppStorageProp = (PackageManager.Property) pkg.getProperties().get("android.internal.PROPERTY_NO_APP_DATA_STORAGE");
        if (noAppStorageProp != null) goto L9;
    L10:
        return true;
    L9:
        if (noAppStorageProp.getBoolean() == false) goto L10;
        return false;
    }

    void startProcessLocked(ProcessRecord app, HostingRecord hostingRecord, int zygotePolicyFlags) {
        startProcessLocked(app, hostingRecord, zygotePolicyFlags, null);
    }

    boolean startProcessLocked(ProcessRecord app, HostingRecord hostingRecord, int zygotePolicyFlags, String abiOverride) {
        return startProcessLocked(app, hostingRecord, zygotePolicyFlags, false, false, abiOverride);
    }

    ProcessRecord startProcessLocked(String processName, final ApplicationInfo info, boolean knownToBeDead, int intentFlags, final HostingRecord hostingRecord, int zygotePolicyFlags, boolean allowWhileBooting, boolean isolated, int isolatedUid, boolean isSdkSandbox, int sdkSandboxUid, String sdkSandboxClientAppPackage, String abiOverride, String entryPoint, String[] entryPointArgs, Runnable crashHandler) {
        String r3 = processName;
        monitor-enter(this);
        final ProcessRecord prefetchProcess = this.mSmtEx.findPrefetchProcessLocked(r3, info);     // Catch: Throwable -> L11
        int r13 = -1;
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L15;
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L11
        r4.append("startProcessLocked enter. find ");     // Catch: Throwable -> L11
        r4.append(r3);     // Catch: Throwable -> L11
        r4.append(" app=");     // Catch: Throwable -> L11
        r4.append(prefetchProcess);     // Catch: Throwable -> L11
        r4.append(" doPrefetch=");     // Catch: Throwable -> L11
        if (prefetchProcess != null) goto L9;
    L13:
        int r5 = -1;
    L14:
        r4.append(r5);     // Catch: Throwable -> L11
        Slog.i("SmartPrefetch", r4.toString());     // Catch: Throwable -> L11
        goto L15
    L9:
        if (prefetchProcess.info == null) goto L13;
        r5 = prefetchProcess.info.getSysEx().doPrefetch;     // Catch: Throwable -> L11
    L15:
        if (prefetchProcess != null) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L11
        long startTime = SystemClock.uptimeMillis();
        SystemClock.elapsedRealtimeNanos();
        if (isolated == true) goto L59;
        ProcessRecord app = getProcessRecordLocked(r3, info.uid);
        if (app != null) goto L42;
        ProcessRecord app2 = SysOptBridge.getFactory().getApplicationFreezer().unfreezeAppIfNeededLocked(null, processName, info.uid, IApplicationFreezer.UnfreezeReason.NEED_START_PROCESS, null, null, null);
        r3 = processName;
        Slog.i("AMS.Freeze", "unfreezeAppIfNeededLocked proc:" + app2 + " procName:" + r3 + " reason: NEED_START_PROCESS, at startProcessLocked");
    L43:
        checkSlow(startTime, "startProcess: after getProcessRecord");
        if ((intentFlags & 4) == 0) goto L52;
        if (this.mService.mAppErrors.isBadProcess(r3, info.uid) == false) goto L61;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L50;
        Slog.v("ActivityManager", "Bad process: " + info.uid + SliceClientPermissions.SliceAuthority.DELIMITER + r3);
    L50:
        return null;
    L61:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L71;
        StringBuilder r6 = new StringBuilder();
        r6.append("startProcess: name=");
        r6.append(r3);
        r6.append(" app=");
        r6.append(app2);
        r6.append(" knownToBeDead=");
        r6.append(knownToBeDead);
        r6.append(" thread=");
        if (app2 == null) goto L65;
        IApplicationThread r7 = app2.getThread();
    L66:
        r6.append(r7);
        r6.append(" pid=");
        if (app2 == null) goto L69;
        int r8 = app2.getPid();
    L70:
        r6.append(r8);
        Slog.v("ActivityManager", r6.toString());
        goto L71
    L69:
        r8 = -1;
        goto L70
    L65:
        r7 = null;
    L71:
        ProcessRecord predecessor = null;
        if (app2 != null) goto L74;
    L105:
        if (isolated == true) goto L114;
        predecessor = (ProcessRecord) this.mDyingProcesses.get(r3, info.uid);
        if (predecessor == null) goto L113;
        if (app2 == null) goto L111;
        if (app2 == predecessor) goto L111;
        app2.mPredecessor = predecessor;
        predecessor.mSuccessor = app2;
    L112:
        Slog.w("ActivityManager", predecessor.toString() + " is attached to a previous process " + predecessor.getDyingPid());
        ProcessRecord app3 = app2;
    L115:
        if (app3 != null) goto L124;
        checkSlow(startTime, "startProcess: creating new process record");
        ApplicationInfo r2 = info;
        HostingRecord r9 = hostingRecord;
        ProcessRecord predecessor2 = predecessor;
        app3 = newProcessRecordLocked(r2, r3, isolated, isolatedUid, isSdkSandbox, sdkSandboxUid, sdkSandboxClientAppPackage, r9);
        if (app3 != null) goto L120;
        Slog.w("ActivityManager", "Failed making new process record for " + r3 + SliceClientPermissions.SliceAuthority.DELIMITER + r2.uid + " isolated=" + isolated);
        return null;
    L120:
        app3.mErrorState.setCrashHandler(crashHandler);
        app3.setIsolatedEntryPoint(entryPoint);
        app3.setIsolatedEntryPointArgs(entryPointArgs);
        if (predecessor2 == null) goto L123;
        app3.mPredecessor = predecessor2;
        predecessor2.mSuccessor = app3;
    L123:
        checkSlow(startTime, "startProcess: done creating new process record");
    L126:
        if (this.mService.mProcessesReady == false) goto L128;
    L138:
        checkSlow(startTime, "startProcess: stepping in to startProcess");
        boolean success = startProcessLocked(app3, r9, zygotePolicyFlags, abiOverride);
        checkSlow(startTime, "startProcess: done starting proc!");
        if (success == true) goto L141;
        return null;
    L141:
        return app3;
    L128:
        if (this.mService.isAllowedWhileBooting(r2) == true) goto L138;
        if (allowWhileBooting == true) goto L138;
        if (this.mService.mProcessesOnHold.contains(app3) == true) goto L134;
        this.mService.mProcessesOnHold.add(app3);
    L134:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L136;
        Slog.v("ActivityManager", "System not ready, putting on hold: " + app3);
    L136:
        checkSlow(startTime, "startProcess: returning with proc on hold");
        return app3;
    L124:
        r2 = info;
        r9 = hostingRecord;
        app3.addPackage(r2.packageName, r2.longVersionCode, this.mService.mProcessStats);
        checkSlow(startTime, "startProcess: added package to existing proc");
    L111:
        app2 = null;
        goto L112
    L113:
        app3 = app2;
        goto L115
    L114:
        app3 = app2;
        goto L115
    L74:
        if (app2.getPid() <= 0) goto L105;
        if (knownToBeDead == true) goto L79;
        if (app2.isKilled() == true) goto L79;
    L81:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L83;
        Slog.v("ActivityManager", "App already running: " + app2);
    L83:
        app2.addPackage(info.packageName, info.longVersionCode, this.mService.mProcessStats);
        checkSlow(startTime, "startProcess: done, added package to proc");
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L94;
        StringBuilder r10 = new StringBuilder();
        r10.append("startProcessLocked. app=");
        r10.append(app2);
        r10.append(" doPrefetch=");
        if (app2.info == null) goto L88;
        int r11 = app2.info.getSysEx().doPrefetch;
    L89:
        r10.append(r11);
        r10.append(" set to NONE prefetchState=");
        if (app2.info == null) goto L92;
        r13 = app2.info.getSysEx().prefetchState;
    L92:
        r10.append(r13);
        Slog.i("SmartPrefetch", r10.toString());
        goto L94
    L88:
        r11 = -1;
    L94:
        if (app2.info.getSysEx().doPrefetch <= 0) goto L96;
        app2.mSmtEx.isStartDuringPrefetch = true;
        this.mService.getSmtEx().resumeDelayFreezingAppActivity(app2.getPid());
    L96:
        return app2;
    L79:
        if (app2.getThread() == null) goto L81;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L100;
        Slog.v("ActivityManager", "App died: " + app2);
    L100:
        checkSlow(startTime, "startProcess: bad proc running, killing");
        app2.getSmtEx().killedReason = "bad-proc";
        this.mService.getSmtEx().reportKillingEvent(KillingStatsUtils.buildOtherKillingEventItem(app2.getSmtEx().getCanonicalName(), app2.uid, app2.getPid(), "bad-proc"));
        killProcessGroup(app2.uid, app2.getPid());
        checkSlow(startTime, "startProcess: done killing old proc");
        if (app2.isKilled() == true) goto L103;
        Slog.w("ActivityManager", app2.toString() + " is attached to a previous process");
    L104:
        predecessor = app2;
        app3 = null;
        goto L115
    L103:
        Slog.w("ActivityManager", app2.toString() + " is attached to a previous process");
        goto L104
    L52:
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L54;
        Slog.v("ActivityManager", "Clearing bad process: " + info.uid + SliceClientPermissions.SliceAuthority.DELIMITER + r3);
    L54:
        this.mService.mAppErrors.resetProcessCrashTime(r3, info.uid);
        if (this.mService.mAppErrors.isBadProcess(r3, info.uid) == false) goto L61;
        EventLog.writeEvent(EventLogTags.AM_PROC_GOOD, new Object[]{Integer.valueOf(UserHandle.getUserId(info.uid)), Integer.valueOf(info.uid), info.processName});
        this.mService.mAppErrors.clearBadProcess(r3, info.uid);
        if (app2 == null) goto L61;
        app2.mErrorState.setBad(false);
        goto L61
    L42:
        app2 = app;
        goto L43
    L59:
        app2 = null;
        goto L61
    L17:
        if (this.mService.mConstants.FLAG_PROCESS_START_ASYNC == false) goto L19;
        Slog.i("ActivityManager", "Posting prefetch post-processing msg for " + prefetchProcess.toShortString());     // Catch: Throwable -> L11
        this.mService.mProcStartHandler.post(new ProcessList$$ExternalSyntheticLambda5(this, prefetchProcess, info, hostingRecord));     // Catch: Throwable -> L11
    L21:
        if (prefetchProcess.getPid() > 0) goto L23;
    L33:
        monitor-exit(this);     // Catch: Throwable -> L11
        return prefetchProcess;
    L23:
        if (HostingRecord.HOSTING_TYPE_TOP_ACTIVITY.equals(hostingRecord.getType()) == false) goto L25;
    L26:
        Process.setUIFirstSchedEventTrack(prefetchProcess.getPid(), prefetchProcess.getPid(), 2, info.packageName, true, 1);     // Catch: Throwable -> L11
    L28:
        if (ActivityManagerService.mUxPerf != null) goto L30;
    L32:
        ActivityManagerService.mUxPerf.perfHint(4225, prefetchProcess.processName, prefetchProcess.getPid(), 103);     // Catch: Throwable -> L11
        goto L33
    L30:
        if (ActivityManagerService.mUxPerf.getPerfHalVersion() < 2.299999952316284d) goto L32;
        int pkgType2 = ActivityManagerService.mUxPerf.perfGetFeedback(5633, prefetchProcess.processName);     // Catch: Throwable -> L11
        ActivityManagerService.mUxPerf.perfHintAcqRel(-1, 4225, prefetchProcess.processName, prefetchProcess.getPid(), 103, 1, new int[]{pkgType2});     // Catch: Throwable -> L11
        goto L33
    L25:
        if (HostingRecord.HOSTING_TYPE_NEXT_TOP_ACTIVITY.equals(hostingRecord.getType()) == false) goto L28;
    L19:
        getSmtEx().prefetchProcPostProcessing(prefetchProcess, info, hostingRecord);     // Catch: Throwable -> L11
    L11:
        th = th;
    L147:
        throw th;
    L144:
        th = th;
        goto L147
    }

    private /* synthetic */ void lambda$startProcessLocked$2(ProcessRecord prefetchProcess, ApplicationInfo info, HostingRecord hostingRecord) {
        getSmtEx().prefetchProcPostProcessing(prefetchProcess, info, hostingRecord);
    }

    String isProcStartValidLocked(ProcessRecord app, long expectedStartSeq) {
        StringBuilder sb = null;
        if (app.isKilledByAm() == false) goto L8;
        if (0 != 0) goto L6;
        sb = new StringBuilder();
    L6:
        sb.append("killedByAm=true;");
    L8:
        if (this.mProcessNames.get(app.processName, app.uid) == app) goto L15;
        if (this.mSmtEx.mPrefetchProcess.get(app.processName, app.uid) == app) goto L15;
        if (sb != null) goto L13;
        sb = new StringBuilder();
    L13:
        sb.append("No entry in mProcessNames;");
    L15:
        if (app.isPendingStart() == true) goto L20;
        if (sb != null) goto L18;
        sb = new StringBuilder();
    L18:
        sb.append("pendingStart=false;");
    L20:
        if (app.getStartSeq() <= expectedStartSeq) goto L40;
        if (sb != null) goto L23;
        sb = new StringBuilder();
    L23:
        sb.append("seq=" + app.getStartSeq() + ",expected=" + expectedStartSeq + ";");
    L40:
        AppGlobals.getPackageManager().checkPackageStartable(app.info.packageName, app.userId);     // Catch: SecurityException -> L26 RemoteException -> L28
    L26:
        e = move-exception;
        if (this.mService.mConstants.FLAG_PROCESS_START_ASYNC == false) goto L35;
        if (sb != null) goto L34;
        sb = new StringBuilder();
    L34:
        sb.append("Package is frozen;");
        goto L36
    L35:
        throw e;
    L36:
        if (sb != null) goto L39;
        return null;
    L39:
        return sb.toString();
    }

    private boolean handleProcessStartedLocked(ProcessRecord pending, Process.ProcessStartResult startResult, long expectedStartSeq) {
        if (this.mPendingStarts.get(expectedStartSeq) != null) goto L10;
        if (pending.getPid() != startResult.pid) goto L11;
        pending.setUsingWrapper(startResult.usingWrapper);
        return false;
    L11:
        return false;
    L10:
        return handleProcessStartedLocked(pending, startResult.pid, startResult.usingWrapper, expectedStartSeq, false);
    }

    boolean handleProcessStartedLocked(ProcessRecord app, int pid, boolean usingWrapper, long expectedStartSeq, boolean procAttached) {
        int r9 = pid;
        this.mPendingStarts.remove(expectedStartSeq);
        String reason = isProcStartValidLocked(app, expectedStartSeq);
        if (reason == null) goto L9;
        Slog.w("ActivityManager", app + " start not valid, killing pid=" + r9 + ", " + reason);
        app.setPendingStart(false);
        app.getSmtEx().killedReason = "handleProcessStartedLocked";
        this.mService.getSmtEx().reportKillingEvent(KillingStatsUtils.buildOtherKillingEventItem(app.getSmtEx().getCanonicalName(), app.uid, app.getPid(), "handleProcessStartedLocked"));
        Process.killProcessQuiet(r9);
        int appPid = app.getPid();
        if (appPid == 0) goto L7;
        Process.killProcessGroup(app.uid, appPid);
    L7:
        noteAppKill(app, 13, 13, reason);
        app.doEarlyCleanupIfNecessaryLocked();
        return false;
    L9:
        String r0 = null;
        if (app == null) goto L12;
        HostingRecord r3 = app.getHostingRecord();
    L13:
        HostingRecord hr = r3;
        if (hr == null) goto L16;
        String type = hr.getType();
    L17:
        if (hr == null) goto L19;
        r0 = hr.getDefiningPackageName();
    L19:
        String packageName = r0;
        if (HostingRecord.HOSTING_TYPE_TOP_ACTIVITY.equals(type) == false) goto L22;
    L29:
        boolean r1 = true;
    L30:
        boolean isForegroundTarget = r1;
        if (SysMonitorFwBridge.getFactory().getResprobe().isFeatureEnabled() == false) goto L37;
        if (isForegroundTarget == false) goto L37;
        Trace.traceBegin(64, "Resprobe snapshot 0");
        boolean ok = SysMonitorFwBridge.getFactory().getResprobe().snapshot(r9, r9, 132, 0);
        Trace.traceEnd(64);
        if (ok != true) goto L36;
        Slog.d("ActivityManager", "Resprobe snapshot 0 success, pid=" + r9 + ", type=" + type + ", packageName=" + packageName);
        goto L37
    L36:
        Slog.e("ActivityManager", "Resprobe snapshot 0 failed, pid=" + r9 + ", type=" + type + ", packageName=" + packageName);
    L37:
        this.mService.mBatteryStatsService.noteProcessStart(app.processName, app.info.uid);
        checkSlow(app.getStartTime(), "startProcess: done updating battery stats");
        Integer r17 = Integer.valueOf(UserHandle.getUserId(app.getStartUid()));
        Integer r18 = Integer.valueOf(r9);
        Integer r19 = Integer.valueOf(app.getStartUid());
        String r2 = app.processName;
        String r21 = app.getHostingRecord().getType();
        if (app.getHostingRecord().getName() == null) goto L41;
        String r6 = app.getHostingRecord().getName();
    L42:
        EventLog.writeEvent(EventLogTags.AM_PROC_START, new Object[]{r17, r18, r19, r2, r21, r6});
        SysOptBridge.getFactory().getAppRecordManagerService().processStart(app, r9);
        IPackageManager r4 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L63
        String packageName2 = app.info.packageName;     // Catch: RemoteException -> L63
        String r5 = app.processName;     // Catch: RemoteException -> L60
        int r7 = app.uid;     // Catch: RemoteException -> L58
        String r8 = app.getSeInfo();     // Catch: RemoteException -> L55
        String type2 = app.info.sourceDir;     // Catch: RemoteException -> L55
        boolean r20 = true;
        r4.logAppProcessStartIfNeeded(packageName2, r5, r7, r8, type2, r9);     // Catch: RemoteException -> L53
    L65:
        Watchdog.getInstance().processStarted(app.processName, r9);
        checkSlow(app.getStartTime(), "startProcess: building log message");
        StringBuilder buf = this.mStringBuilder;
        buf.setLength(0);
        buf.append("Start proc ");
        buf.append(r9);
        buf.append(':');
        buf.append(app.processName);
        buf.append('/');
        UserHandle.formatUid(buf, app.getStartUid());
        if (app.getIsolatedEntryPoint() == null) goto L68;
        buf.append(" [");
        buf.append(app.getIsolatedEntryPoint());
        buf.append("]");
    L68:
        buf.append(" for ");
        buf.append(app.getHostingRecord().getType());
        if (app.getHostingRecord().getName() == null) goto L71;
        buf.append(" ");
        buf.append(app.getHostingRecord().getName());
    L71:
        this.mService.reportUidInfoMessageLocked("ActivityManager", buf.toString(), app.getStartUid());
        ActivityManagerGlobalLock r10 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r10);
        app.setPid(pid);     // Catch: Throwable -> L123
        app.setUsingWrapper(usingWrapper);     // Catch: Throwable -> L123
        app.setPendingStart(false);     // Catch: Throwable -> L123
        monitor-exit(r10);     // Catch: Throwable -> L123
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        checkSlow(app.getStartTime(), "startProcess: starting to update pids map");
        ActivityManagerService.PidMap r11 = this.mService.mPidsSelfLocked;
        monitor-enter(r11);
        ProcessRecord oldApp = this.mService.mPidsSelfLocked.get(r9);     // Catch: Throwable -> L117
        monitor-exit(r11);     // Catch: Throwable -> L117
        if (oldApp == null) goto L84;
        if (app.isolated == true) goto L84;
        Slog.wtf("ActivityManager", "handleProcessStartedLocked process:" + app.processName + " startSeq:" + app.getStartSeq() + " pid:" + r9 + " belongs to another existing app:" + oldApp.processName + " startSeq:" + oldApp.getStartSeq());
        this.mService.cleanUpApplicationRecordLocked(oldApp, pid, false, false, -1, true, false);
        r9 = pid;
    L84:
        this.mService.addPidLocked(app);
        if (app.info.getSysEx().doPrefetch != 0) goto L87;
    L90:
        ActivityManagerService.PidMap r12 = this.mService.getSmtEx().mPrefetchPidsSelf;
        monitor-enter(r12);
        this.mService.getSmtEx().mPrefetchPidsSelf.doAddInternal(r9, app);     // Catch: Throwable -> L114
        monitor-exit(r12);     // Catch: Throwable -> L114
    L95:
        if (app.info.getSysEx().doPrefetch == 0) goto L97;
    L98:
        SysOptBridge.getFactory().getSysPrefetchService().addPrefetchApp(app.getPid(), app.info.packageName);
    L99:
        ActivityManagerService.PidMap r13 = this.mService.mPidsSelfLocked;
        monitor-enter(r13);
        if (procAttached == false) goto L130;
    L109:
        monitor-exit(r13);     // Catch: Throwable -> L107
        dispatchProcessStarted(app, pid);
        checkSlow(app.getStartTime(), "startProcess: done updating pids map");
        return r20;
    L107:
        th = move-exception;
        throw th;
    L130:
        Message msg = this.mService.mHandler.obtainMessage(20);     // Catch: Throwable -> L107
        msg.obj = app;     // Catch: Throwable -> L107
        ActivityManagerService.MainHandler r14 = this.mService.mHandler;     // Catch: Throwable -> L107
        if (usingWrapper == false) goto L105;
        long r15 = 1200000;
    L106:
        r14.sendMessageDelayed(msg, r15);     // Catch: Throwable -> L107
        goto L109
    L105:
        r15 = ActivityManagerService.PROC_START_TIMEOUT;     // Catch: Throwable -> L107
        goto L106
    L97:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(app.info.getSysEx().prefetchState) == false) goto L99;
    L114:
        th = move-exception;
        throw th;
    L87:
        if (app.info.getSysEx().doPrefetch == 2) goto L90;
        this.mService.mPidsSelfLocked.doAddInternal(r9, app);
    L117:
        th = th;
    L146:
        throw th;
    L121:
        th = th;
    L123:
        th = th;
    L140:
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L128:
        th = th;
    L56:
        r20 = true;
    L59:
        r20 = true;
    L61:
        r20 = true;
    L64:
        r20 = true;
        goto L65
    L41:
        r6 = "";
        goto L42
    L22:
        if (HostingRecord.HOSTING_TYPE_NEXT_TOP_ACTIVITY.equals(type) == true) goto L29;
        if (HostingRecord.HOSTING_TYPE_ACTIVITY.equals(type) == true) goto L29;
        if (HostingRecord.HOSTING_TYPE_NEXT_ACTIVITY.equals(type) == true) goto L29;
        r1 = false;
        goto L30
    L16:
        type = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    }

    void removeLruProcessLocked(ProcessRecord app) {
        int lrui = this.mLruProcesses.lastIndexOf(app);
        if (lrui < 0) goto L29;
        ActivityManagerGlobalLock r2 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r2);
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L7:
        if (app.isKilled() == true) goto L18;
        if (app.isPersistent() == false) goto L13;
        Slog.w("ActivityManager", "Removing persistent process that hasn't been killed: " + app);     // Catch: Throwable -> L11
        goto L18
    L13:
        Slog.wtfStack("ActivityManager", "Removing process that hasn't been killed: " + app);     // Catch: Throwable -> L11
        if (app.getPid() <= 0) goto L16;
        app.getSmtEx().killedReason = "removeLruProcessLocked";     // Catch: Throwable -> L11
        this.mService.getSmtEx().reportKillingEvent(KillingStatsUtils.buildAmKillingEventItem(app.getSmtEx().getCanonicalName(), app.uid, app.getPid(), app.mState.getSetAdj(), app.mState.getSetProcState(), "removeLruProcessLocked"));     // Catch: Throwable -> L11
        Process.killProcessQuiet(app.getPid());     // Catch: Throwable -> L11
        killProcessGroup(app.uid, app.getPid());     // Catch: Throwable -> L11
        noteAppKill(app, 13, 16, "hasn't been killed");     // Catch: Throwable -> L11
        goto L18
    L16:
        app.setPendingStart(false);     // Catch: Throwable -> L11
    L18:
        if (lrui >= this.mLruProcessActivityStart) goto L21;
        this.mLruProcessActivityStart--;     // Catch: Throwable -> L11
    L21:
        if (lrui >= this.mLruProcessServiceStart) goto L23;
        this.mLruProcessServiceStart--;     // Catch: Throwable -> L11
    L23:
        this.mLruProcesses.remove(lrui);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterProcLockedSection();
    L29:
        this.mService.removeOomAdjTargetLocked(app, true);
    }

    boolean killPackageProcessesLSP(String packageName, int appId, int userId, int minOomAdj, int reasonCode, int subReason, String reason) {
        return killPackageProcessesLSP(packageName, appId, userId, minOomAdj, false, true, true, false, false, false, reasonCode, subReason, reason);
    }

    void killAppZygotesLocked(String packageName, int appId, int userId, boolean force) {
        ArrayList<AppZygote> zygotesToKill = new ArrayList();
        Iterator r1 = this.mAppZygotes.getMap().values().iterator();
    L4:
        if (r1.hasNext() == false) goto L25;
        SparseArray<AppZygote> appZygotes = (SparseArray) r1.next();
        int i = 0;
    L7:
        if (i >= appZygotes.size()) goto L4;
        int appZygoteUid = appZygotes.keyAt(i);
        if (userId != (-1)) goto L11;
    L13:
        if (appId >= 0) goto L15;
    L17:
        AppZygote appZygote = appZygotes.valueAt(i);
        if (packageName != null) goto L20;
    L22:
        zygotesToKill.add(appZygote);
    L23:
        i = i + 1;
        goto L7
    L20:
        if (packageName.equals(appZygote.getAppInfo().packageName) == true) goto L22;
    L15:
        if (UserHandle.getAppId(appZygoteUid) == appId) goto L17;
    L11:
        if (UserHandle.getUserId(appZygoteUid) == userId) goto L13;
    L25:
        Iterator<AppZygote> r2 = zygotesToKill.iterator();
    L27:
        if (r2.hasNext() == false) goto L29;
        killAppZygoteIfNeededLocked(r2.next(), force);
        goto L27
    }

    private static boolean freezePackageCgroup(int packageUID, boolean freeze) {
        Process.freezeCgroupUid(packageUID, freeze);     // Catch: RuntimeException -> L5
        return true;
    L5:
        e = move-exception;
        if (freeze == false) goto L8;
        String logtxt = IResMngConfig.FEAT_FREEZE;
    L9:
        Slog.e("ActivityManager", "Unable to " + logtxt + " cgroup uid: " + packageUID + ": " + e);
        return false;
    L8:
        logtxt = "unfreeze";
        goto L9
    }

    private static boolean unfreezePackageCgroup(int packageUID) {
        return freezePackageCgroup(packageUID, false);
    }

    private void freezeBinderAndPackageCgroup(List<Pair<ProcessRecord, Boolean>> procs, int packageUID) {
        int N = procs.size();
        int i = 0;
    L4:
        if (i >= N) goto L21;
        int pid = ((ProcessRecord) procs.get(i).first).getPid();
        int nRetries = 0;
        if (pid <= 0) goto L20;
    L23:
        int rc = this.mService.getFreezer().freezeBinder(pid, true, 10);     // Catch: RuntimeException -> L16
        if (rc != (-OsConstants.EAGAIN)) goto L13;
        int nRetries2 = nRetries + 1;     // Catch: RuntimeException -> L16
        if (nRetries >= 1) goto L13;
        nRetries = nRetries2;
    L13:
        if (rc == 0) goto L20;
        Slog.e("ActivityManager", "Unable to freeze binder for " + pid + ": " + rc);     // Catch: RuntimeException -> L16
    L16:
        e = move-exception;
        Slog.e("ActivityManager", "Unable to freeze binder for " + pid + ": " + e);
    L20:
        i = i + 1;
        goto L4
    L21:
        freezePackageCgroup(packageUID, true);
    }

    private static List<Pair<ProcessRecord, Boolean>> getUIDSublist(List<Pair<ProcessRecord, Boolean>> procs, int startIdx) {
        int uid = ((ProcessRecord) procs.get(startIdx).first).uid;
        int endIdx = startIdx + 1;
    L4:
        if (endIdx >= procs.size()) goto L9;
        if (((ProcessRecord) procs.get(endIdx).first).uid != uid) goto L9;
        endIdx = endIdx + 1;
    L9:
        return procs.subList(startIdx, endIdx);
    }

    boolean killPackageProcessesLSP(String packageName, int appId, int userId, int minOomAdj, boolean callerWillRestart, boolean allowRestart, boolean doit, boolean evenPersistent, boolean setRemoved, boolean uninstalling, int reasonCode, int subReason, String reason) {
        PackageManagerInternal pm = this.mService.getPackageManagerInternal();
        ArrayList<Pair<ProcessRecord, Boolean>> procs = new ArrayList();
        ArrayMap<String, SparseArray> allProcs = new ArrayMap();
        allProcs.putAll(this.mProcessNames.getMap());
        allProcs.putAll(SysOptBridge.getFactory().getApplicationFreezer().getFrozenProcesses().getMap());
        int NP = allProcs.size();
        int ip = 0;
    L3:
        if (ip >= NP) goto L96;
        SparseArray<ProcessRecord> apps = allProcs.valueAt(ip);
        int NA = apps.size();
        int ia = 0;
    L5:
        if (ia >= NA) goto L95;
        ProcessRecord app = apps.valueAt(ia);
        if (app.isPersistent() == false) goto L11;
        if (evenPersistent == true) goto L11;
        int ip2 = ip;
    L94:
        ia = ia + 1;
        ip = ip2;
    L11:
        if (app.isRemoved() == false) goto L35;
        if (doit == false) goto L34;
        boolean shouldAllowRestart = false;
        if (uninstalling == true) goto L32;
        if (packageName == null) goto L32;
        if (app.getPkgList().containsKey(packageName) == false) goto L19;
        ip2 = ip;
        boolean r17 = true;
    L30:
        boolean r0 = false;
    L31:
        shouldAllowRestart = r0;
    L33:
        procs.add(new Pair(app, Boolean.valueOf(shouldAllowRestart)));
        goto L94
    L19:
        if (app.getPkgDeps() != null) goto L21;
        ip2 = ip;
        r17 = true;
        goto L30
    L21:
        if (app.getPkgDeps().contains(packageName) == true) goto L23;
    L27:
        ip2 = ip;
        r17 = true;
        goto L30
    L23:
        if (app.info == null) goto L27;
        String r2 = app.info.packageName;
        r17 = true;
        int r3 = app.uid;
        ip2 = ip;
        int ip3 = app.userId;
        if (pm.isPackageFrozen(r2, r3, ip3) == true) goto L30;
        r0 = true;
    L32:
        ip2 = ip;
        r17 = true;
        goto L33
    L34:
        ip2 = ip;
        goto L94
    L35:
        ip2 = ip;
        if (app.mState.getSetAdj() < minOomAdj) goto L94;
        if (app.processName == null) goto L46;
        if ("com.zte.softda".equals(app.processName) == false) goto L46;
        if ("PermissionHelper".equals(reason) == true) goto L94;
    L46:
        boolean shouldAllowRestart2 = false;
        if (packageName != null) goto L58;
        if (userId != (-1)) goto L50;
    L52:
        if (appId >= 0) goto L54;
    L56:
        shouldAllowRestart2 = false;
    L87:
        boolean shouldAllowRestart3 = shouldAllowRestart2;
    L88:
        if (doit == false) goto L89;
        if (setRemoved == false) goto L93;
        app.setRemoved(true);
    L93:
        procs.add(new Pair(app, Boolean.valueOf(shouldAllowRestart3)));
        goto L94
    L89:
        return true;
    L54:
        if (UserHandle.getAppId(app.uid) == appId) goto L56;
    L50:
        if (app.userId == userId) goto L52;
    L58:
        if (app.getPkgDeps() != null) goto L60;
    L62:
        boolean isDep = false;
    L64:
        if (isDep == true) goto L70;
        if (UserHandle.getAppId(app.uid) != appId) goto L94;
    L70:
        if (userId != (-1)) goto L72;
    L74:
        boolean isInPkgList = app.getPkgList().containsKey(packageName);
        if (isInPkgList == true) goto L78;
        if (isDep == false) goto L94;
    L78:
        if (isInPkgList == true) goto L87;
        if (isDep == false) goto L87;
        if (uninstalling == true) goto L87;
        if (app.info == null) goto L87;
        if (pm.isPackageFrozen(app.info.packageName, app.uid, app.userId) == true) goto L87;
        shouldAllowRestart3 = true;
        goto L88
    L72:
        if (app.userId == userId) goto L74;
    L60:
        if (app.getPkgDeps().contains(packageName) == false) goto L62;
        isDep = true;
        goto L64
    L95:
        ip = ip + 1;
        goto L3
    L96:
        boolean r4 = true;
        if (appId >= 10000) goto L99;
    L101:
        boolean r1 = false;
    L102:
        boolean killingUserApp = r1;
        if (killingUserApp == false) goto L105;
        procs.sort(new ProcessList$$ExternalSyntheticLambda2());
    L105:
        int idx = 0;
    L107:
        if (idx >= procs.size()) goto L146;
        List<Pair<ProcessRecord, Boolean>> uidProcs = getUIDSublist(procs, idx);
        int packageUID = ((ProcessRecord) uidProcs.get(0).first).uid;
        if (killingUserApp == true) goto L111;
    L113:
        boolean r6 = false;
    L114:
        boolean doFreeze = r6;
        if (doFreeze == false) goto L155;
        freezeBinderAndPackageCgroup(uidProcs, packageUID);     // Catch: Throwable -> L118
    L118:
        th = th;
        int packageUID2 = packageUID;
    L143:
        if (doFreeze == false) goto L145;
        unfreezePackageCgroup(packageUID2);
    L145:
        throw th;
    L155:
        Iterator<Pair<ProcessRecord, Boolean>> r18 = uidProcs.iterator();     // Catch: Throwable -> L137
    L122:
        if (r18.hasNext() == false) goto L139;
        Pair<ProcessRecord, Boolean> proc = r18.next();     // Catch: Throwable -> L137
        ProcessRecord r7 = (ProcessRecord) proc.first;     // Catch: Throwable -> L137
        if (allowRestart == false) goto L126;
    L129:
        boolean r5 = r4;
    L130:
        if (doFreeze == true) goto L132;
        boolean r8 = r4;
    L133:
        int idx2 = idx;
        packageUID2 = packageUID;
        List<Pair<ProcessRecord, Boolean>> uidProcs2 = uidProcs;
        boolean r19 = r4;
        removeProcessLocked(r7, callerWillRestart, r5, reasonCode, subReason, reason, r8);     // Catch: Throwable -> L135
        r4 = r19;
        idx = idx2;
        uidProcs = uidProcs2;
        packageUID = packageUID2;
    L135:
        th = th;
        goto L143
    L132:
        r8 = false;
        goto L133
    L126:
        if (((Boolean) proc.second).booleanValue() == true) goto L129;
        r5 = false;
        goto L130
    L139:
        boolean r110 = r4;
        int idx3 = idx;
        List<Pair<ProcessRecord, Boolean>> uidProcs3 = uidProcs;
        int packageUID3 = packageUID;
        killAppZygotesLocked(packageName, appId, userId, false);     // Catch: Throwable -> L135
        if (doFreeze == false) goto L142;
        unfreezePackageCgroup(packageUID3);
    L142:
        idx = idx3 + uidProcs3.size();
        r4 = r110;
    L137:
        th = th;
        packageUID2 = packageUID;
        goto L143
    L111:
        if (UserHandle.getAppId(packageUID) != appId) goto L113;
        r6 = r4;
        goto L114
    L146:
        boolean r111 = r4;
        this.mService.updateOomAdjLocked(12);
        if (procs.size() <= 0) goto L150;
        return r111;
    L150:
        return false;
    L99:
        if (appId > 19999) goto L101;
        r1 = true;
        goto L102
    }

    private static /* synthetic */ int lambda$killPackageProcessesLSP$3(Pair o1, Pair o2) {
        return Integer.compare(((ProcessRecord) o1.first).uid, ((ProcessRecord) o2.first).uid);
    }

    boolean removeProcessLocked(ProcessRecord app, boolean callerWillRestart, boolean allowRestart, int reasonCode, String reason) {
        return removeProcessLocked(app, callerWillRestart, allowRestart, reasonCode, 0, reason, true);
    }

    boolean removeProcessLocked(ProcessRecord app, boolean callerWillRestart, boolean allowRestart, int reasonCode, int subReason, String reason) {
        return removeProcessLocked(app, callerWillRestart, allowRestart, reasonCode, subReason, reason, true);
    }

    boolean removeProcessLocked(ProcessRecord app, boolean callerWillRestart, boolean allowRestart, int reasonCode, int subReason, String reason, boolean async) {
        String name = app.processName;
        int uid = app.uid;
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L5;
        Slog.d("ActivityManager", "Force removing proc " + app.toShortString() + " (" + name + SliceClientPermissions.SliceAuthority.DELIMITER + uid + ")");
    L5:
        ProcessRecord old = (ProcessRecord) this.mProcessNames.get(name, uid);
        if (old != null) goto L8;
        old = (ProcessRecord) SysOptBridge.getFactory().getApplicationFreezer().getFrozenProcesses().get(name, uid);
    L8:
        if (old != null) goto L10;
        ProcessRecord old2 = (ProcessRecord) this.mSmtEx.mPrefetchProcess.get(name, uid);
    L12:
        if (old2 == app) goto L15;
        Slog.w("ActivityManager", "Ignoring remove of inactive process: " + app);
        return false;
    L15:
        removeProcessNameLocked(name, uid);
        this.mService.mAtmInternal.clearHeavyWeightProcessIfEquals(app.getWindowProcessController());
        int pid = app.getPid();
        if (pid > 0) goto L18;
    L19:
        if (pid != 0) goto L50;
        if (app.isPendingStart() == false) goto L50;
    L22:
        if (pid <= 0) goto L33;
        ActivityManagerService.PidMap r4 = this.mService.mPidsSelfLocked;
        monitor-enter(r4);
        this.mService.getSmtEx().mPrefetchPidsSelf.doRemoveInternal(pid, app);     // Catch: Throwable -> L30
        SysOptBridge.getFactory().getSysPrefetchService().removePrefetchApp(app.getPid(), 3);     // Catch: Throwable -> L30
        monitor-exit(r4);     // Catch: Throwable -> L30
        app.setBindMountPending(false);
        this.mService.mHandler.removeMessages(20, app);
        this.mService.mHandler.removeMessages(82, app);
        this.mService.mHandler.removeMessages(83, app);
        this.mService.mBatteryStatsService.noteProcessFinish(app.processName, app.info.uid);
        if (app.isolated == false) goto L33;
        this.mService.mBatteryStatsService.removeIsolatedUid(app.uid, app.info.uid);
        this.mService.getPackageManagerInternal().removeIsolatedUid(app.uid);
        SysOptBridge.getFactory().getAppRecordManagerService().removeIsolatedUid(app.uid);
    L30:
        th = move-exception;
        throw th;
    L33:
        boolean willRestart = false;
        if (app.isPersistent() == true) goto L36;
    L40:
        boolean needRestart = false;
    L41:
        app.killLocked(reason, reasonCode, subReason, true, async);
        if (pid <= 0) goto L44;
        this.mService.removePidLocked(pid, app);
    L44:
        boolean willRestart2 = willRestart;
        this.mService.handleAppDiedLocked(app, pid, willRestart2, allowRestart, false);
        if (willRestart2 == false) goto L54;
        removeLruProcessLocked(app);
        this.mService.addAppLocked(app.info, null, false, null, 0);
    L54:
        return needRestart;
    L36:
        if (app.isolated == true) goto L40;
        if (callerWillRestart == true) goto L39;
        willRestart = true;
        needRestart = false;
        goto L41
    L39:
        needRestart = true;
    L50:
        this.mRemovedProcesses.add(app);
        return false;
    L18:
        if (pid != ActivityManagerService.MY_PID) goto L22;
    L10:
        old2 = old;
        goto L12
    }

    void addProcessNameLocked(ProcessRecord proc) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        ProcessRecord old = removeProcessNameLocked(proc.processName, proc.uid);     // Catch: Throwable -> L9
        if (old == proc) goto L7;
    L11:
        if (old != null) goto L13;
    L16:
        UidRecord uidRec = this.mActiveUids.get(proc.uid);     // Catch: Throwable -> L9
        if (uidRec != null) goto L30;
        uidRec = new UidRecord(proc.uid, this.mService);     // Catch: Throwable -> L9
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L22;
        Slog.i("ActivityManager", "Creating new process uid: " + uidRec);     // Catch: Throwable -> L9
    L22:
        if (Arrays.binarySearch(this.mService.mDeviceIdleTempAllowlist, UserHandle.getAppId(proc.uid)) < 0) goto L24;
    L25:
        uidRec.setCurAllowListed(true);     // Catch: Throwable -> L9
        uidRec.setSetAllowListed(true);     // Catch: Throwable -> L9
    L26:
        uidRec.updateHasInternetPermission();     // Catch: Throwable -> L9
        this.mActiveUids.put(proc.uid, uidRec);     // Catch: Throwable -> L9
        if (SysOptBridge.getFactory().getActivityManager(this.mService).getmUidCpuRunner() == null) goto L29;
        SysOptBridge.getFactory().getActivityManager(this.mService).getmUidCpuRunner().onUidAdded(proc.uid);     // Catch: Throwable -> L9
    L29:
        EventLogTags.writeAmUidRunning(uidRec.getUid());     // Catch: Throwable -> L9
        this.mService.noteUidProcessStateAndCapability(uidRec.getUid(), uidRec.getCurProcState(), uidRec.getCurCapability());     // Catch: Throwable -> L9
        this.mService.noteUidProcessState(uidRec.getUid(), uidRec.getCurProcState());     // Catch: Throwable -> L9
        goto L30
    L24:
        if (this.mService.mPendingTempAllowlist.indexOfKey(proc.uid) < 0) goto L26;
    L30:
        proc.setUidRecord(uidRec);     // Catch: Throwable -> L9
        uidRec.addProcess(proc);     // Catch: Throwable -> L9
        if (proc.uid != 1000) goto L33;
        proc.getUidRecord().getSmtEx().getSystemSmtUidRecord(proc.info.getSmtUid(), this.mService).procRecords.add(proc);     // Catch: Throwable -> L9
    L33:
        proc.setRenderThreadTid(0, new int[]{0, 0});     // Catch: Throwable -> L9
        if (proc.info.getSysEx().doPrefetch != 1) goto L36;
    L41:
        this.mSmtEx.mPrefetchProcess.put(proc.processName, proc.uid, proc);     // Catch: Throwable -> L9
    L42:
        SysOptBridge.getFactory().getSysPrefetchService().addAlivePrefetch(proc.processName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        if (proc.isSdkSandbox == false) goto L56;
        ArrayList<ProcessRecord> sdkSandboxes = this.mSdkSandboxes.get(proc.uid);
        if (sdkSandboxes != null) goto L49;
        sdkSandboxes = new ArrayList();
    L49:
        sdkSandboxes.add(proc);
        this.mSdkSandboxes.put(Process.getAppUidForSdkSandboxUid(proc.uid), sdkSandboxes);
        return;
    L56:
        return;
    L36:
        if (proc.info.getSysEx().doPrefetch == 2) goto L41;
        this.mProcessNames.put(proc.processName, proc.uid, proc);     // Catch: Throwable -> L9
        if (proc.isolated == false) goto L42;
        this.mIsolatedProcesses.put(proc.uid, proc);     // Catch: Throwable -> L9
        goto L42
    L13:
        if (old.isKilled() == false) goto L15;
        Slog.w("ActivityManager", "Existing proc " + old + " was killed " + (SystemClock.uptimeMillis() - old.getKillTime()) + "ms ago when adding " + proc);     // Catch: Throwable -> L9
        goto L16
    L15:
        Slog.w("ActivityManager", "Already have existing proc " + old + " when adding " + proc);     // Catch: Throwable -> L9
        goto L16
    L7:
        if (proc.isPersistent() == false) goto L11;
        Slog.w("ActivityManager", "Re-adding persistent process " + proc);     // Catch: Throwable -> L9
        proc.resetCrashingOnRestart();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private IsolatedUidRange getOrCreateIsolatedUidRangeLocked(ApplicationInfo info, HostingRecord hostingRecord) {
        if (hostingRecord == null) goto L9;
        if (hostingRecord.usesAppZygote() == false) goto L9;
        return this.mAppIsolatedUidRangeAllocator.getOrCreateIsolatedUidRangeLocked(info.processName, hostingRecord.getDefiningUid());
    L9:
        return this.mGlobalIsolatedUids;
    }

    ProcessRecord getSharedIsolatedProcess(String processName, int uid, String packageName) {
        int i = 0;
        int size = this.mIsolatedProcesses.size();
    L3:
        if (i >= size) goto L12;
        ProcessRecord app = this.mIsolatedProcesses.valueAt(i);
        if (app.info.uid != uid) goto L11;
        if (app.info.packageName.equals(packageName) == false) goto L11;
        if (app.processName.equals(processName) == false) goto L11;
        return app;
    L11:
        i = i + 1;
        goto L3
    L12:
        return null;
    }

    List<Integer> getIsolatedProcessesLocked(int uid) {
        List<Integer> ret = null;
        int i = 0;
        int size = this.mIsolatedProcesses.size();
    L3:
        if (i >= size) goto L11;
        ProcessRecord app = this.mIsolatedProcesses.valueAt(i);
        if (app.info.uid != uid) goto L9;
        if (ret != null) goto L8;
        ret = new ArrayList();
    L8:
        ret.add(Integer.valueOf(app.getPid()));
    L9:
        i = i + 1;
        goto L3
    L11:
        return ret;
    }

    List<ProcessRecord> getSdkSandboxProcessesForAppLocked(int uid) {
        return this.mSdkSandboxes.get(uid);
    }

    ProcessRecord newProcessRecordLocked(ApplicationInfo info, String customProcess, boolean isolated, int isolatedUid, boolean isSdkSandbox, int sdkSandboxUid, String sdkSandboxClientAppPackage, HostingRecord hostingRecord) {
        if (customProcess == null) goto L4;
        String r0 = customProcess;
    L5:
        String proc = r0;
        int userId = UserHandle.getUserId(info.uid);
        int uid = info.uid;
        if (isSdkSandbox == false) goto L9;
        uid = sdkSandboxUid;
    L9:
        if (Process.isSdkSandboxUid(uid) == false) goto L14;
        if (isSdkSandbox == false) goto L12;
        if (sdkSandboxClientAppPackage != null) goto L14;
    L12:
        Slog.e("ActivityManager", "Abort creating new sandbox process as required parameters are missing.");
        return null;
    L14:
        if (isolated == false) goto L25;
        if (isolatedUid != 0) goto L23;
        HostingRecord r9 = hostingRecord;
        IsolatedUidRange uidRange = getOrCreateIsolatedUidRangeLocked(info, r9);
        if (uidRange != null) goto L19;
        return null;
    L19:
        int uid2 = uidRange.allocateIsolatedUidLocked(userId);
        if (uid2 != (-1)) goto L24;
        return null;
    L24:
        this.mAppExitInfoTracker.mIsolatedUidRecords.addIsolatedUid(uid2, info.uid);
        this.mService.getPackageManagerInternal().addIsolatedUid(uid2, info.uid);
        this.mService.mBatteryStatsService.addIsolatedUid(uid2, info.uid);
        SysOptBridge.getFactory().getAppRecordManagerService().addIsolatedUid(uid2, info.uid);
        int uid3 = uid2;
    L26:
        ProcessRecord r = new ProcessRecord(this.mService, info, proc, uid3, sdkSandboxClientAppPackage, r9.getDefiningUid(), r9.getDefiningProcessName());
        ProcessStateRecord state = r.mState;
        boolean wasStopped = info.isStopped();
        if (wasStopped == false) goto L35;
        boolean wasEverLaunched = !info.isNotLaunched();
        if (r9.isTypeActivity() == false) goto L34;
        if (wasEverLaunched == false) goto L32;
        int stoppedState = 2;
    L33:
        r.getWindowProcessController().setStoppedState(stoppedState);
        goto L35
    L32:
        stoppedState = 1;
        goto L33
    L34:
        r.setWasForceStopped(wasEverLaunched);
    L35:
        if (isolated == true) goto L43;
        if (isSdkSandbox == true) goto L43;
        if (userId != 0) goto L43;
        if ((info.flags & 9) != 9) goto L43;
        if (TextUtils.equals(proc, info.processName) == false) goto L43;
        state.setCurrentSchedulingGroup(2);
        state.setSetSchedGroup(2);
        r.setPersistent(true);
        this.mService.mProcessStateController.setMaxAdj(r, PERSISTENT_PROC_ADJ);
    L43:
        if (isolated == false) goto L46;
        if (isolatedUid == 0) goto L46;
        this.mService.mProcessStateController.setMaxAdj(r, PERSISTENT_SERVICE_ADJ);
    L46:
        addProcessNameLocked(r);
        return r;
    L23:
        r9 = hostingRecord;
        uid2 = isolatedUid;
        goto L24
    L25:
        r9 = hostingRecord;
        uid3 = uid;
        goto L26
    L4:
        r0 = info.processName;
        goto L5
    }

    ProcessRecord removeProcessNameLocked(String name, int uid) {
        return removeProcessNameLocked(name, uid, null);
    }

    ProcessRecord removeProcessNameLocked(String name, int uid, ProcessRecord expecting) {
        ProcessRecord old = (ProcessRecord) this.mProcessNames.get(name, uid);
        if (old != null) goto L5;
        old = (ProcessRecord) SysOptBridge.getFactory().getApplicationFreezer().getFrozenProcesses().get(name, uid);
    L5:
        if (old != null) goto L7;
        old = (ProcessRecord) this.mSmtEx.mPrefetchProcess.get(name, uid);
    L7:
        if (old == null) goto L16;
        if (old.info == null) goto L16;
        if (old.info.getSysEx().doPrefetch == 0) goto L13;
    L14:
        SysOptBridge.getFactory().getSysPrefetchService().notifyPrefetchKilled(old.info.packageName, uid);
        goto L16
    L13:
        if (old.mSmtEx.freezeFromPrefetch == true) goto L14;
    L16:
        if (old == null) goto L18;
        SysOptBridge.getFactory().getSmartScenes().updateProcessState(name, old.info, false, false);
    L18:
        if (expecting == null) goto L20;
        ProcessRecord record = expecting;
    L21:
        if (expecting == null) goto L23;
        if (old == expecting) goto L23;
    L24:
        ActivityManagerGlobalLock r3 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r3);
        if (expecting == null) goto L63;
        if (old == expecting) goto L63;
    L29:
        if (record == null) goto L44;
        UidRecord uidRecord = record.getUidRecord();     // Catch: Throwable -> L35
        if (uidRecord == null) goto L44;
        uidRecord.removeProcess(record);     // Catch: Throwable -> L35
        if (old.uid != 1000) goto L38;
        old.getUidRecord().getSmtEx().getSystemSmtUidRecord(old.info.getSmtUid(), this.mService).procRecords.remove(old);     // Catch: Throwable -> L35
    L38:
        if (uidRecord.getNumOfProcs() == 0) goto L40;
    L43:
        record.setUidRecord(null);     // Catch: Throwable -> L35
        goto L44
    L40:
        if (ActivityManagerDebugConfig.DEBUG_UID_OBSERVERS == false) goto L42;
        Slog.i("ActivityManager", "No more processes in " + uidRecord);     // Catch: Throwable -> L35
    L42:
        this.mService.enqueueUidChangeLocked(uidRecord, -1, -2147483647);     // Catch: Throwable -> L35
        EventLogTags.writeAmUidStopped(uid);     // Catch: Throwable -> L35
        this.mActiveUids.remove(uid);     // Catch: Throwable -> L35
        SysOptBridge.getFactory().getActivityManager(this.mService).getmUidCpuRunner().onUidRemoved(uid);     // Catch: Throwable -> L35
        this.mService.mFgsStartTempAllowList.removeUid(record.info.uid);     // Catch: Throwable -> L35
        this.mService.noteUidProcessStateAndCapability(uid, 20, 0);     // Catch: Throwable -> L35
        this.mService.noteUidProcessState(uid, 20);     // Catch: Throwable -> L35
    L44:
        monitor-exit(r3);     // Catch: Throwable -> L35
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        this.mIsolatedProcesses.remove(uid);
        this.mGlobalIsolatedUids.freeIsolatedUidLocked(uid);
        if (record != null) goto L48;
    L50:
        if (record != null) goto L52;
    L58:
        this.mAppsInBackgroundRestricted.remove(record);
        return old;
    L52:
        if (record.isSdkSandbox == false) goto L58;
        int appUid = Process.getAppUidForSdkSandboxUid(uid);
        ArrayList<ProcessRecord> sdkSandboxesForUid = this.mSdkSandboxes.get(appUid);
        if (sdkSandboxesForUid == null) goto L58;
        sdkSandboxesForUid.remove(record);
        if (sdkSandboxesForUid.size() != 0) goto L58;
        this.mSdkSandboxes.remove(appUid);
        goto L58
    L48:
        if (record.appZygote == false) goto L50;
        removeProcessFromAppZygoteLocked(record);
    L35:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L63:
        this.mProcessNames.remove(name, uid);     // Catch: Throwable -> L35
        this.mSmtEx.mPrefetchProcess.remove(name, uid);     // Catch: Throwable -> L35
        SysOptBridge.getFactory().getSysPrefetchService().removeAlivePrefetch(name);     // Catch: Throwable -> L35
    L23:
        Slog.i("AMS.Freeze", "takeoutByProcessLocked name:" + name + " uid:" + uid + " record:" + record + ", at removeProcessNameLocked");
        SysOptBridge.getFactory().getApplicationFreezer().takeoutByProcessLocked(record);
        goto L24
    L20:
        record = old;
        goto L21
    }

    void updateCoreSettingsLOSP(Bundle settings) {
        int i = this.mLruProcesses.size() - 1;
    L3:
        if (i < 0) goto L15;
        ProcessRecord processRecord = this.mLruProcesses.get(i);
        IApplicationThread thread = processRecord.getThread();
        if (thread == null) goto L10;
        thread.setCoreSettings(settings);     // Catch: RemoteException -> L7
    L13:
        i = i - 1;
        goto L3
    L10:
        if (processRecord.getSmtEx().inFreezeStat() == false) goto L13;
        processRecord.getSmtEx().cacheData.putBundle("core_settings", settings);     // Catch: RemoteException -> L7
        goto L13
    }

    void killAllBackgroundProcessesExceptLSP(int minTargetSdk, int maxProcState) {
        ArrayList<ProcessRecord> procs = new ArrayList();
        int NP = this.mProcessNames.getMap().size();
        int ip = 0;
    L3:
        if (ip >= NP) goto L17;
        SparseArray<ProcessRecord> apps = (SparseArray) this.mProcessNames.getMap().valueAt(ip);
        int NA = apps.size();
        int ia = 0;
    L5:
        if (ia >= NA) goto L16;
        ProcessRecord app = apps.valueAt(ia);
        if (app.isRemoved() == true) goto L14;
        if (minTargetSdk >= 0) goto L10;
    L11:
        if (maxProcState < 0) goto L14;
        if (app.mState.getSetProcState() > maxProcState) goto L14;
    L15:
        ia = ia + 1;
        goto L5
    L10:
        if (app.info.targetSdkVersion >= minTargetSdk) goto L15;
    L14:
        procs.add(app);
        goto L15
    L16:
        ip = ip + 1;
        goto L3
    L17:
        int N = procs.size();
        int i = 0;
    L18:
        if (i >= N) goto L21;
        removeProcessLocked(procs.get(i), false, true, 13, 10, "kill all background except");
        i = i + 1;
        goto L18
    }

    void updateAllTimePrefsLOSP(int timePref) {
        int i = this.mLruProcesses.size() - 1;
    L3:
        if (i < 0) goto L12;
        ProcessRecord r = this.mLruProcesses.get(i);
        IApplicationThread thread = r.getThread();
        if (thread == null) goto L10;
        thread.updateTimePrefs(timePref);     // Catch: RemoteException -> L8
    L9:
        Slog.w("ActivityManager", "Failed to update preferences for: " + r.info.processName);
    L10:
        i = i - 1;
        goto L3
    }

    void setAllHttpProxy() {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        int i = this.mLruProcesses.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (i < 0) goto L19;
        ProcessRecord r = this.mLruProcesses.get(i);     // Catch: Throwable -> L13
        IApplicationThread thread = r.getThread();     // Catch: Throwable -> L13
        if (r.getPid() == ActivityManagerService.MY_PID) goto L17;
        if (thread == null) goto L17;
        if (r.isolated == true) goto L17;
        thread.updateHttpProxy();     // Catch: Throwable -> L13 RemoteException -> L15
    L16:
        Slog.w("ActivityManager", "Failed to update http proxy for: " + r.info.processName);     // Catch: Throwable -> L13
    L17:
        i = i - 1;     // Catch: Throwable -> L13
        goto L5
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        ActivityThread.updateHttpProxy(this.mService.mContext);
        return;
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    void clearAllDnsCacheLOSP() {
        int i = this.mLruProcesses.size() - 1;
    L3:
        if (i < 0) goto L12;
        ProcessRecord r = this.mLruProcesses.get(i);
        IApplicationThread thread = r.getThread();
        if (thread == null) goto L10;
        thread.clearDnsCache();     // Catch: RemoteException -> L8
    L9:
        Slog.w("ActivityManager", "Failed to clear dns cache for: " + r.info.processName);
    L10:
        i = i - 1;
        goto L3
    }

    void handleAllTrustStorageUpdateLOSP() {
        int i = this.mLruProcesses.size() - 1;
    L3:
        if (i < 0) goto L12;
        ProcessRecord r = this.mLruProcesses.get(i);
        IApplicationThread thread = r.getThread();
        if (thread == null) goto L10;
        thread.handleTrustStorageUpdate();     // Catch: RemoteException -> L8
    L9:
        Slog.w("ActivityManager", "Failed to handle trust storage update for: " + r.info.processName);
    L10:
        i = i - 1;
        goto L3
    }

    private int offerLruProcessInternalLSP(ProcessRecord app, long now, String what, Object obj, ProcessRecord srcApp) {
        app.setLastActivityTime(now);
        if (app.hasActivitiesOrRecentTasks() == false) goto L6;
        return -1;
    L6:
        int lrui = this.mLruProcesses.lastIndexOf(app);
        if (lrui >= 0) goto L9;
        Slog.wtf("ActivityManager", "Adding dependent process " + app + " not on LRU list: " + what + " " + obj + " from " + srcApp);
    L9:
        return lrui;
    }

    private void completeLruProcessInternalLSP(SparseBooleanArray indices, int nextActivityIndex, int nextIndex) {
        int i = indices.size() - 1;
    L3:
        if (i < 0) goto L22;
        int lrui = indices.keyAt(i);
        if (lrui < 0) goto L6;
        boolean isActivity = indices.valueAt(i);
        if (isActivity == false) goto L10;
        int index = nextActivityIndex;
    L11:
        if (lrui >= index) goto L20;
        ProcessRecord app = this.mLruProcesses.remove(lrui);
        int index2 = index - 1;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L16;
        Slog.d("ActivityManager", "Moving dep from " + lrui + " to " + index2 + " in LRU list: " + app);
    L16:
        this.mLruProcesses.add(index2, app);
        app.setLruSeq(this.mLruSeq);
        if (isActivity == false) goto L19;
        nextActivityIndex = index2;
        goto L20
    L19:
        nextIndex = index2;
    L20:
        i = i - 1;
        goto L3
    L10:
        index = nextIndex;
        goto L11
    L6:
        return;
    }

    private void updateClientActivitiesOrderingLSP(ProcessRecord topApp, int topI, int bottomI, int endIndex) {
        ProcessList r0 = this;
        ProcessServiceRecord topPsr = topApp.mServices;
        if (topApp.hasActivitiesOrRecentTasks() == true) goto L134;
        if (topPsr.isTreatedLikeActivity() == true) goto L134;
        if (topPsr.hasClientActivities() == false) goto L163;
        int uid = topApp.info.uid;
        int topConnectionGroup = topPsr.getConnectionGroup();
        if (topConnectionGroup <= 0) goto L47;
        int endImportance = topPsr.getConnectionImportance();
        int i = endIndex;
        int endImportance2 = endImportance;
        int endIndex2 = endIndex;
    L12:
        if (i < bottomI) goto L46;
        ProcessRecord subProc = r0.mLruProcesses.get(i);
        ProcessServiceRecord subPsr = subProc.mServices;
        int subConnectionGroup = subPsr.getConnectionGroup();
        int subConnectionImportance = subPsr.getConnectionImportance();
        if (subProc.info.uid != uid) goto L44;
        if (subConnectionGroup != topConnectionGroup) goto L44;
        if (i != endIndex2) goto L23;
        if (subConnectionImportance < endImportance2) goto L23;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L22;
        Slog.d("ActivityManager", "Keeping in-place above " + subProc + " endImportance=" + endImportance2 + " group=" + subConnectionGroup + " importance=" + subConnectionImportance);
    L22:
        endIndex2 = endIndex2 - 1;
        endImportance2 = subConnectionImportance;
        int topConnectionGroup2 = topConnectionGroup;
    L45:
        i = i - 1;
        topPsr = topPsr;
        topConnectionGroup = topConnectionGroup2;
    L23:
        topPsr = topPsr;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L26;
        Slog.d("ActivityManager", "Pulling up " + subProc + " to position in group with importance=" + subConnectionImportance);
    L26:
        boolean moved = false;
        int pos = topI;
    L27:
        boolean moved2 = moved;
        topConnectionGroup2 = topConnectionGroup;
        if (pos <= endIndex2) goto L37;
        int endIndex3 = endIndex2;
        ProcessRecord posProc = r0.mLruProcesses.get(pos);
        int endImportance3 = endImportance2;
        if (subConnectionImportance <= posProc.mServices.getConnectionImportance()) goto L31;
        pos = pos - 1;
        moved = moved2;
        topConnectionGroup = topConnectionGroup2;
        endIndex2 = endIndex3;
        endImportance2 = endImportance3;
        goto L27
    L31:
        r0.mLruProcesses.remove(i);
        r0.mLruProcesses.add(pos, subProc);
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L35;
        Slog.d("ActivityManager", "Moving " + subProc + " from position " + i + " to above " + posProc + " @ " + pos);
    L35:
        boolean moved3 = true;
        endIndex2 = endIndex3 - 1;
    L38:
        if (moved3 == true) goto L43;
        r0.mLruProcesses.remove(i);
        r0.mLruProcesses.add(endIndex2, subProc);
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L42;
        Slog.d("ActivityManager", "Moving " + subProc + " from position " + i + " to end of group @ " + endIndex2);
    L42:
        endIndex2 = endIndex2 - 1;
        endImportance2 = subConnectionImportance;
        goto L45
    L43:
        endImportance2 = endImportance3;
        goto L45
    L37:
        endImportance3 = endImportance2;
        moved3 = moved2;
    L44:
        topPsr = topPsr;
        topConnectionGroup2 = topConnectionGroup;
        endIndex2 = endIndex2;
        endImportance2 = endImportance2;
        goto L45
    L46:
        int endIndex4 = endIndex2;
    L48:
        int i2 = endIndex4;
        int endIndex5 = endIndex4;
    L49:
        if (i2 < bottomI) goto L132;
        ProcessRecord subProc2 = r0.mLruProcesses.get(i2);
        ProcessServiceRecord subPsr2 = subProc2.mServices;
        int subConnectionGroup2 = subPsr2.getConnectionGroup();
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L54;
        Slog.d("ActivityManager", "Looking to spread old procs, at " + subProc2 + " @ " + i2);
    L54:
        if (subProc2.info.uid == uid) goto L130;
        if (i2 >= endIndex5) goto L104;
        boolean hasActivity = false;
        int connUid = 0;
        int connGroup = 0;
    L58:
        if (subProc2.info.uid == uid) goto L104;
        r0.mLruProcesses.remove(i2);
        r0.mLruProcesses.add(endIndex5, subProc2);
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L62;
        Slog.d("ActivityManager", "Different app, moving to " + endIndex5);
    L62:
        i2 = i2 - 1;
        if (i2 < bottomI) goto L104;
        subProc2 = r0.mLruProcesses.get(i2);
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L69;
        Slog.d("ActivityManager", "Looking at next app at " + i2 + ": " + subProc2);
    L69:
        if (subProc2.hasActivitiesOrRecentTasks() == true) goto L96;
        if (subPsr2.isTreatedLikeActivity() == true) goto L96;
        if (subPsr2.hasClientActivities() == false) goto L103;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L78;
        Slog.d("ActivityManager", "This is a client of an activity");
    L78:
        if (hasActivity == false) goto L92;
        if (connUid == 0) goto L89;
        if (connUid != subProc2.info.uid) goto L89;
        if (connGroup == 0) goto L86;
        if (connGroup == subConnectionGroup2) goto L103;
    L86:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L104;
        Slog.d("ActivityManager", "Already found a different group: connGroup=" + connGroup + " group=" + subConnectionGroup2);
    L89:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L104;
        Slog.d("ActivityManager", "Already found a different activity: connUid=" + connUid + " uid=" + subProc2.info.uid);
        goto L104
    L92:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L94;
        Slog.d("ActivityManager", "This is an activity client!  uid=" + subProc2.info.uid + " group=" + subConnectionGroup2);
    L94:
        hasActivity = true;
        connUid = subProc2.info.uid;
        connGroup = subConnectionGroup2;
    L103:
        endIndex5 = endIndex5 - 1;
    L96:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L98;
        Slog.d("ActivityManager", "This is hosting an activity!");
    L98:
        if (hasActivity == true) goto L100;
        hasActivity = true;
        goto L103
    L100:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L104;
        Slog.d("ActivityManager", "Already found an activity, done");
    L104:
        endIndex5 = endIndex5 - 1;
        if (endIndex5 < bottomI) goto L112;
        ProcessRecord endProc = r0.mLruProcesses.get(endIndex5);
        if (endProc.info.uid != uid) goto L104;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L112;
        Slog.d("ActivityManager", "Found next group of app: " + endProc + " @ " + endIndex5);
    L112:
        if (endIndex5 < bottomI) goto L127;
        ProcessServiceRecord endPsr = r0.mLruProcesses.get(endIndex5).mServices;
        int endConnectionGroup = endPsr.getConnectionGroup();
        endIndex5 = endIndex5 - 1;
    L114:
        if (endIndex5 < bottomI) goto L127;
        ProcessRecord nextEndProc = r0.mLruProcesses.get(endIndex5);
        int nextConnectionGroup = nextEndProc.mServices.getConnectionGroup();
        if (nextEndProc.info.uid != uid) goto L121;
        if (nextConnectionGroup != endConnectionGroup) goto L121;
        endIndex5 = endIndex5 - 1;
        r0 = this;
    L121:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L127;
        Slog.d("ActivityManager", "Found next group or app: " + nextEndProc + " @ " + endIndex5 + " group=" + nextConnectionGroup);
    L127:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L129;
        Slog.d("ActivityManager", "Bumping scan position to " + endIndex5);
    L129:
        i2 = endIndex5;
    L131:
        r0 = this;
        goto L49
    L130:
        i2 = i2 - 1;
        goto L131
    L132:
        return;
    L47:
        endIndex4 = endIndex;
        goto L48
    L163:
        return;
    }

    void updateLruProcessLocked(ProcessRecord app, boolean activityChange, ProcessRecord client) {
        ProcessServiceRecord psr = app.mServices;
        if (app.info.getSysEx().isPrefetchApp() == false) goto L6;
        return;
    L6:
        if (app.hasActivitiesOrRecentTasks() == false) goto L8;
    L13:
        boolean hasActivity = true;
    L15:
        if (activityChange == true) goto L19;
        if (hasActivity == false) goto L19;
        return;
    L19:
        if (app.getPid() == 0) goto L21;
    L23:
        ActivityManagerGlobalLock r4 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r4);
        updateLruProcessLSP(app, client, hasActivity, false);     // Catch: Throwable -> L29
        monitor-exit(r4);     // Catch: Throwable -> L29
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L29:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L21:
        if (app.isPendingStart() == true) goto L23;
        return;
    L8:
        if (psr.hasClientActivities() == true) goto L13;
        if (psr.isTreatedLikeActivity() == true) goto L13;
        hasActivity = false;
        goto L15
    }

    private void updateLruProcessLSP(ProcessRecord app, ProcessRecord client, boolean hasActivity, boolean hasService) {
        ProcessList r0 = this;
        ProcessRecord r6 = app;
        r0.mLruSeq++;
        long now = SystemClock.uptimeMillis();
        ProcessServiceRecord psr = r6.mServices;
        r6.setLastActivityTime(now);
        if (hasActivity == false) goto L14;
        int N = r0.mLruProcesses.size();
        if (N > 0) goto L7;
    L21:
        int lrui = r0.mLruProcesses.lastIndexOf(r6);
        if (r6.isPersistent() == false) goto L28;
        if (lrui < 0) goto L28;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L139;
        Slog.d("ActivityManager", "Not moving, persistent: " + r6);
        return;
    L139:
        return;
    L28:
        if (lrui < 0) goto L37;
        if (lrui >= r0.mLruProcessActivityStart) goto L33;
        r0.mLruProcessActivityStart--;
    L33:
        if (lrui >= r0.mLruProcessServiceStart) goto L35;
        r0.mLruProcessServiceStart--;
    L35:
        r0.mLruProcesses.remove(lrui);
    L37:
        if (hasActivity == false) goto L63;
        int N2 = r0.mLruProcesses.size();
        int nextIndex = r0.mLruProcessServiceStart;
        if (r6.hasActivitiesOrRecentTasks() == true) goto L59;
        if (psr.isTreatedLikeActivity() == true) goto L59;
        if (r0.mLruProcessActivityStart >= (N2 - 1)) goto L59;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L47;
        Slog.d("ActivityManager", "Adding to second-top of LRU activity list: " + r6 + " group=" + psr.getConnectionGroup() + " importance=" + psr.getConnectionImportance());
    L47:
        int pos = N2 - 1;
    L49:
        if (pos <= r0.mLruProcessActivityStart) goto L54;
        ProcessRecord posproc = r0.mLruProcesses.get(pos);
        if (posproc.info.uid == r6.info.uid) goto L54;
        pos = pos - 1;
    L54:
        r0.mLruProcesses.add(pos, r6);
        int endIndex = pos - 1;
        if (endIndex >= r0.mLruProcessActivityStart) goto L57;
        endIndex = r0.mLruProcessActivityStart;
    L57:
        int nextActivityIndex = endIndex;
        r0.updateClientActivitiesOrderingLSP(r6, pos, r0.mLruProcessActivityStart, endIndex);
    L62:
        int nextIndex2 = nextIndex;
        int nextIndex3 = nextActivityIndex;
    L86:
        r6.setLruSeq(r0.mLruSeq);
        SparseBooleanArray indices = new SparseBooleanArray(psr.numberOfConnections() + r6.mProviders.numberOfProviderConnections());
        int j = psr.numberOfConnections() - 1;
    L87:
        if (j < 0) goto L111;
        ConnectionRecord cr = psr.getConnectionAt(j);
        if (cr.binding != null) goto L91;
    L109:
        int nextActivityIndex2 = nextIndex3;
    L110:
        j = j - 1;
        nextIndex3 = nextActivityIndex2;
        goto L87
    L91:
        if (cr.serviceDead == true) goto L109;
        if (cr.binding.service == null) goto L109;
        if (cr.binding.service.app == null) goto L109;
        if (cr.binding.service.app.getLruSeq() == r0.mLruSeq) goto L108;
        nextActivityIndex2 = nextIndex3;
        if (cr.notHasFlag(18253611312L) == false) goto L110;
        if (cr.binding.service.app.isPersistent() == true) goto L110;
        if (cr.binding.service.app.mServices.hasClientActivities() == false) goto L107;
        if (nextActivityIndex2 < 0) goto L106;
        indices.append(r0.offerLruProcessInternalLSP(cr.binding.service.app, now, "service connection", cr, r6), true);
        r0 = this;
        r6 = app;
        goto L110
    L106:
        r0 = this;
        r6 = app;
        goto L110
    L107:
        r0 = this;
        r6 = app;
        indices.append(r0.offerLruProcessInternalLSP(cr.binding.service.app, now, "service connection", cr, r6), false);
        goto L110
    L108:
        nextActivityIndex2 = nextIndex3;
        goto L110
    L111:
        int nextActivityIndex3 = nextIndex3;
        ProcessProviderRecord ppr = r6.mProviders;
        int j2 = ppr.numberOfProviderConnections() - 1;
    L112:
        if (j2 < 0) goto L122;
        ContentProviderRecord cpr = ppr.getProviderConnectionAt(j2).provider;
        if (cpr.proc == null) goto L121;
        if (cpr.proc.getLruSeq() == r0.mLruSeq) goto L121;
        if (cpr.proc.isPersistent() == true) goto L121;
        indices.append(r0.offerLruProcessInternalLSP(cpr.proc, now, "provider reference", cpr, r6), false);
    L121:
        j2 = j2 - 1;
        r6 = app;
        goto L112
    L122:
        r0.completeLruProcessInternalLSP(indices, nextActivityIndex3, nextIndex2);
        return;
    L59:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L61;
        Slog.d("ActivityManager", "Adding to top of LRU activity list: " + r6);
    L61:
        r0.mLruProcesses.add(r6);
        nextActivityIndex = r0.mLruProcesses.size() - 1;
        goto L62
    L63:
        if (hasService == true) goto L65;
        int index = r0.mLruProcessServiceStart;
        if (client == null) goto L80;
        int clientIndex = r0.mLruProcesses.lastIndexOf(client);
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L74;
        if (clientIndex >= 0) goto L74;
        Slog.d("ActivityManager", "Unknown client " + client + " when updating " + r6);
    L74:
        if (clientIndex > lrui) goto L76;
        clientIndex = lrui;
    L76:
        if (clientIndex < 0) goto L80;
        if (index <= clientIndex) goto L80;
        index = clientIndex;
    L80:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L82;
        Slog.d("ActivityManager", "Adding at " + index + " of LRU list: " + r6);
    L82:
        r0.mLruProcesses.add(index, r6);
        int nextIndex4 = index - 1;
        r0.mLruProcessActivityStart++;
        r0.mLruProcessServiceStart++;
        if (index <= 1) goto L85;
        r0.updateClientActivitiesOrderingLSP(r6, r0.mLruProcessServiceStart - 1, 0, index - 1);
    L85:
        nextIndex2 = nextIndex4;
        nextIndex3 = -1;
        goto L86
    L65:
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L67;
        Slog.d("ActivityManager", "Adding to top of LRU service list: " + r6);
    L67:
        r0.mLruProcesses.add(r0.mLruProcessActivityStart, r6);
        int nextIndex5 = r0.mLruProcessServiceStart;
        r0.mLruProcessActivityStart++;
        nextIndex2 = nextIndex5;
        nextIndex3 = -1;
        goto L86
    L7:
        if (r0.mLruProcesses.get(N - 1) != r6) goto L21;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L137;
        Slog.d("ActivityManager", "Not moving, already top activity: " + r6);
        return;
    L137:
        return;
    L14:
        if (r0.mLruProcessServiceStart <= 0) goto L21;
        if (r0.mLruProcesses.get(r0.mLruProcessServiceStart - 1) != r6) goto L21;
        if (ActivityManagerDebugConfig.DEBUG_LRU == false) goto L138;
        Slog.d("ActivityManager", "Not moving, already top other: " + r6);
        return;
    }

    ProcessRecord getLRURecordForAppLOSP(IApplicationThread thread) {
        if (thread != null) goto L6;
        return null;
    L6:
        return getLRURecordForAppLOSP(thread.asBinder(), true);
    }

    ProcessRecord getLRURecordForAppLOSP(IBinder threadBinder, boolean includeFreezeStat) {
        if (threadBinder != null) goto L5;
        return null;
    L5:
        int i = this.mLruProcesses.size() - 1;
    L6:
        if (i < 0) goto L17;
        ProcessRecord rec = this.mLruProcesses.get(i);
        if (includeFreezeStat == false) goto L10;
        IApplicationThread t = rec.getSmtEx().getThread();
    L11:
        if (t == null) goto L15;
        if (t.asBinder() != threadBinder) goto L15;
        return rec;
    L15:
        i = i - 1;
        goto L6
    L10:
        t = rec.getThread();
        goto L11
    L17:
        return null;
    }

    boolean haveBackgroundProcessLOSP() {
        int i = this.mLruProcesses.size() - 1;
    L3:
        if (i < 0) goto L10;
        ProcessRecord rec = this.mLruProcesses.get(i);
        if (rec.getThread() == null) goto L9;
        if (rec.mState.getSetProcState() < 16) goto L9;
        return true;
    L9:
        i = i - 1;
        goto L3
    L10:
        return false;
    }

    void fillInProcMemInfoLOSP(ProcessRecord app, ActivityManager.RunningAppProcessInfo outInfo, int clientTargetSdk) {
        outInfo.pid = app.getPid();
        outInfo.uid = app.info.uid;
        boolean r1 = true;
        if (app.getWindowProcessController().isHeavyWeightProcess() == false) goto L6;
        outInfo.flags |= 1;
    L6:
        if (app.isPersistent() == false) goto L9;
        outInfo.flags |= 2;
    L9:
        if (app.hasActivities() == false) goto L11;
        outInfo.flags |= 4;
    L11:
        outInfo.lastTrimLevel = app.mProfile.getTrimMemoryLevel();
        ProcessStateRecord state = app.mState;
        int procState = state.getCurProcState();
        outInfo.importance = ActivityManager.RunningAppProcessInfo.procStateToImportanceForTargetSdk(procState, clientTargetSdk);
        if (outInfo.importance != 400) goto L14;
        outInfo.lru = state.getCurAdj();
    L15:
        outInfo.importanceReasonCode = state.getAdjTypeCode();
        outInfo.processState = procState;
        if (app == this.mService.getTopApp()) goto L19;
        r1 = false;
    L19:
        outInfo.isFocused = r1;
        outInfo.lastActivityTime = app.getLastActivityTime();
        return;
    L14:
        outInfo.lru = 0;
        goto L15
    }

    List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessesLOSP(boolean allUsers, int userId, boolean allUids, int callingUid, int clientTargetSdk) {
        List<ActivityManager.RunningAppProcessInfo> runList = null;
        int i = this.mLruProcesses.size() - 1;
    L3:
        if (i < 0) goto L37;
        ProcessRecord app = this.mLruProcesses.get(i);
        ProcessStateRecord state = app.mState;
        ProcessErrorStateRecord errState = app.mErrorState;
        if (allUsers == false) goto L7;
    L8:
        if (allUids == true) goto L13;
        if (app.uid == callingUid) goto L13;
    L35:
        i = i - 1;
    L13:
        if (app.getThread() == null) goto L35;
        if (errState.isCrashing() == true) goto L35;
        if (errState.isNotResponding() == true) goto L35;
        ActivityManager.RunningAppProcessInfo currApp = new ActivityManager.RunningAppProcessInfo(app.processName, app.getPid(), app.getPackageList());
        if (app.getPkgDeps() == null) goto L21;
        int size = app.getPkgDeps().size();
        currApp.pkgDeps = (String[]) app.getPkgDeps().toArray(new String[size]);
    L21:
        fillInProcMemInfoLOSP(app, currApp, clientTargetSdk);
        if ((state.getAdjSource() instanceof ProcessRecord) == false) goto L25;
        currApp.importanceReasonPid = ((ProcessRecord) state.getAdjSource()).getPid();
        currApp.importanceReasonImportance = ActivityManager.RunningAppProcessInfo.procStateToImportance(state.getAdjSourceProcState());
    L30:
        if ((state.getAdjTarget() instanceof ComponentName) == false) goto L32;
        currApp.importanceReasonComponent = (ComponentName) state.getAdjTarget();
    L32:
        if (runList != null) goto L34;
        runList = new ArrayList();
    L34:
        runList.add(currApp);
        goto L35
    L25:
        if ((state.getAdjSource() instanceof ActivityServiceConnectionsHolder) == false) goto L30;
        ActivityServiceConnectionsHolder r = (ActivityServiceConnectionsHolder) state.getAdjSource();
        int pid = r.getActivityPid();
        if (pid == (-1)) goto L30;
        currApp.importanceReasonPid = pid;
        goto L30
    L7:
        if (app.userId != userId) goto L35;
    L37:
        return runList;
    }

    int getLruSizeLOSP() {
        return this.mLruProcesses.size();
    }

    ArrayList<ProcessRecord> getLruProcessesLOSP() {
        return this.mLruProcesses;
    }

    ArrayList<ProcessRecord> getLruProcessesLSP() {
        return this.mLruProcesses;
    }

    void setLruProcessServiceStartLSP(int pos) {
        this.mLruProcessServiceStart = pos;
    }

    int getLruProcessServiceStartLOSP() {
        return this.mLruProcessServiceStart;
    }

    void forEachLruProcessesLOSP(boolean iterateForward, Consumer<ProcessRecord> callback) {
        if (iterateForward == false) goto L7;
        int i = 0;
        int size = this.mLruProcesses.size();
    L4:
        if (i >= size) goto L10;
        callback.accept(this.mLruProcesses.get(i));
        i = i + 1;
        goto L4
    L10:
        return;
    L7:
        int i2 = this.mLruProcesses.size() - 1;
    L8:
        if (i2 < 0) goto L13;
        callback.accept(this.mLruProcesses.get(i2));
        i2 = i2 - 1;
        goto L8
    }

    <R> R searchEachLruProcessesLOSP(boolean iterateForward, Function<ProcessRecord, R> callback) {
        if (iterateForward == false) goto L10;
        int i = 0;
        int size = this.mLruProcesses.size();
    L4:
        if (i >= size) goto L16;
        R r = callback.apply(this.mLruProcesses.get(i));
        if (r != null) goto L7;
        i = i + 1;
        goto L4
    L7:
        return r;
    L16:
        return null;
    L10:
        int i2 = this.mLruProcesses.size() - 1;
    L11:
        if (i2 < 0) goto L22;
        R r2 = callback.apply(this.mLruProcesses.get(i2));
        if (r2 != null) goto L14;
        i2 = i2 - 1;
        goto L11
    L14:
        return r2;
    L22:
        return null;
    }

    boolean isInLruListLOSP(ProcessRecord app) {
        return this.mLruProcesses.contains(app);
    }

    int getLruSeqLOSP() {
        return this.mLruSeq;
    }

    MyProcessMap getProcessNamesLOSP() {
        return this.mProcessNames;
    }

    void dumpLruListHeaderLocked(PrintWriter pw) {
        pw.print("  Process LRU list (sorted by oom_adj, ");
        pw.print(this.mLruProcesses.size());
        pw.print(" total, non-act at ");
        pw.print(this.mLruProcesses.size() - this.mLruProcessActivityStart);
        pw.print(", non-svc at ");
        pw.print(this.mLruProcesses.size() - this.mLruProcessServiceStart);
        pw.println("):");
    }

    private void dumpLruEntryLocked(PrintWriter pw, int index, ProcessRecord proc, String prefix) {
        pw.print(prefix);
        pw.print('#');
        if (index >= 10) goto L5;
        pw.print(' ');
    L5:
        pw.print(index);
        pw.print(": ");
        pw.print(makeOomAdjString(proc.mState.getSetAdj(), false));
        pw.print(' ');
        pw.print(makeProcStateString(proc.mState.getCurProcState()));
        pw.print(' ');
        pw.print(makeSchedulingGroupString(proc.mState.getCurrentSchedulingGroup()));
        pw.print(' ');
        pw.print(proc.mState.getAdjType());
        pw.print(' ');
        ActivityManager.printCapabilitiesSummary(pw, proc.mState.getCurCapability());
        pw.print(' ');
        pw.print(proc.toShortString());
        ProcessServiceRecord psr = proc.mServices;
        if (proc.hasActivitiesOrRecentTasks() == false) goto L8;
    L11:
        pw.print(" act:");
        boolean printed = false;
        if (proc.hasActivities() == false) goto L15;
        pw.print(ActivityTaskManagerService.DUMP_ACTIVITIES_CMD);
        printed = true;
    L15:
        if (proc.hasRecentTasks() == false) goto L20;
        if (printed == false) goto L18;
        pw.print("|");
    L18:
        pw.print(ActivityTaskManagerService.DUMP_RECENTS_CMD);
        printed = true;
    L20:
        if (psr.hasClientActivities() == false) goto L25;
        if (printed == false) goto L23;
        pw.print("|");
    L23:
        pw.print("client");
        printed = true;
    L25:
        if (psr.isTreatedLikeActivity() == false) goto L29;
        if (printed == false) goto L28;
        pw.print("|");
    L28:
        pw.print("treated");
    L29:
        pw.println();
        return;
    L8:
        if (psr.hasClientActivities() == true) goto L11;
        if (psr.isTreatedLikeActivity() == false) goto L29;
        goto L11
    }

    boolean dumpLruLocked(PrintWriter pw, String dumpPackage, String prefix) {
        int lruSize = this.mLruProcesses.size();
        if (prefix != null) goto L5;
        pw.println("ACTIVITY MANAGER LRU PROCESSES (dumpsys activity lru)");
        String innerPrefix = "  ";
    L17:
        boolean first = true;
        int i = lruSize - 1;
    L19:
        if (i < this.mLruProcessActivityStart) goto L29;
        ProcessRecord r = this.mLruProcesses.get(i);
        if (dumpPackage != null) goto L23;
    L25:
        if (first == false) goto L27;
        pw.print(innerPrefix);
        pw.println("Activities:");
        first = false;
    L27:
        dumpLruEntryLocked(pw, i, r, innerPrefix);
    L28:
        i = i - 1;
        goto L19
    L23:
        if (r.getPkgList().containsKey(dumpPackage) == true) goto L25;
    L29:
        boolean first2 = true;
    L31:
        if (i < this.mLruProcessServiceStart) goto L41;
        ProcessRecord r2 = this.mLruProcesses.get(i);
        if (dumpPackage != null) goto L35;
    L37:
        if (first2 == false) goto L39;
        pw.print(innerPrefix);
        pw.println("Services:");
        first2 = false;
    L39:
        dumpLruEntryLocked(pw, i, r2, innerPrefix);
    L40:
        i = i - 1;
        goto L31
    L35:
        if (r2.getPkgList().containsKey(dumpPackage) == true) goto L37;
    L41:
        boolean first3 = true;
    L42:
        if (i < 0) goto L52;
        ProcessRecord r3 = this.mLruProcesses.get(i);
        if (dumpPackage != null) goto L46;
    L48:
        if (first3 == false) goto L50;
        pw.print(innerPrefix);
        pw.println("Other:");
        first3 = false;
    L50:
        dumpLruEntryLocked(pw, i, r3, innerPrefix);
    L51:
        i = i - 1;
        goto L42
    L46:
        if (r3.getPkgList().containsKey(dumpPackage) == true) goto L48;
    L52:
        SysOptBridge.getFactory().getActivityManager(this.mService).getmUidCpuRunner().dumpUidCpuUsage(pw);
        return true;
    L5:
        boolean haveAny = false;
        int i2 = lruSize - 1;
    L6:
        if (i2 < 0) goto L13;
        ProcessRecord r4 = this.mLruProcesses.get(i2);
        if (dumpPackage == null) goto L12;
        if (r4.getPkgList().containsKey(dumpPackage) == true) goto L12;
        i2 = i2 - 1;
    L12:
        haveAny = true;
    L13:
        if (haveAny == true) goto L16;
        return false;
    L16:
        pw.print(prefix);
        pw.println("Raw LRU list (dumpsys activity lru):");
        innerPrefix = prefix + "  ";
        goto L17
    }

    void dumpProcessesLSP(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, String dumpPackage, int dumpAppId) {
        boolean needSep = false;
        int numPers = 0;
        pw.println("ACTIVITY MANAGER RUNNING PROCESSES (dumpsys activity processes)");
        if (dumpAll == true) goto L7;
        if (dumpPackage != null) goto L7;
        int numPers2 = 0;
    L29:
        if (this.mIsolatedProcesses.size() <= 0) goto L43;
        boolean printed = false;
        int i = 0;
        int size = this.mIsolatedProcesses.size();
    L31:
        if (i >= size) goto L43;
        ProcessRecord r = this.mIsolatedProcesses.valueAt(i);
        if (dumpPackage != null) goto L35;
    L37:
        if (printed == true) goto L41;
        if (needSep == false) goto L40;
        pw.println();
    L40:
        pw.println("  Isolated process list (sorted by uid):");
        printed = true;
        needSep = true;
    L41:
        pw.print("    Isolated #");
        pw.print(i);
        pw.print(": ");
        pw.println(r);
    L42:
        i = i + 1;
        goto L31
    L35:
        if (r.getPkgList().containsKey(dumpPackage) == true) goto L37;
    L43:
        boolean needSep2 = this.mService.dumpActiveInstruments(pw, dumpPackage, needSep);
        if (dumpOomLocked(fd, pw, needSep2, args, opti, dumpAll, dumpPackage, false) == false) goto L46;
        boolean needSep3 = true;
    L48:
        if (this.mActiveUids.size() <= 0) goto L50;
        needSep3 = needSep3 | this.mActiveUids.dump(pw, dumpPackage, dumpAppId, "UID states:", needSep3);
    L50:
        if (dumpAll == false) goto L52;
        String r2 = dumpPackage;
        needSep3 = needSep3 | this.mService.mUidObserverController.dumpValidateUids(pw, r2, dumpAppId, "UID validation:", needSep3);
    L53:
        if (needSep3 == false) goto L56;
        pw.println();
    L56:
        if (dumpLruLocked(pw, r2, "  ") == false) goto L58;
        boolean needSep4 = true;
    L60:
        if (getLruSizeLOSP() <= 0) goto L64;
        if (needSep4 == false) goto L63;
        pw.println();
    L63:
        dumpLruListHeaderLocked(pw);
        dumpProcessOomList(pw, this.mService, this.mLruProcesses, "    ", "Proc", "PERS", false, dumpPackage);
        boolean needSep5 = true;
    L65:
        this.mService.dumpOtherProcessesInfoLSP(fd, pw, dumpAll, dumpPackage, dumpAppId, numPers2, needSep5);
        return;
    L64:
        needSep5 = needSep4;
        goto L65
    L58:
        needSep4 = needSep3;
        goto L60
    L52:
        r2 = dumpPackage;
        goto L53
    L46:
        needSep3 = needSep2;
    L7:
        int numOfNames = this.mProcessNames.getMap().size();
        int ip = 0;
    L8:
        if (ip >= numOfNames) goto L27;
        SparseArray<ProcessRecord> procs = (SparseArray) this.mProcessNames.getMap().valueAt(ip);
        int ia = 0;
        int size2 = procs.size();
    L10:
        if (ia >= size2) goto L26;
        ProcessRecord r3 = procs.valueAt(ia);
        if (dumpPackage != null) goto L14;
    L16:
        if (needSep == true) goto L19;
        pw.println("  All known processes:");
        needSep = true;
    L19:
        if (r3.isPersistent() == false) goto L21;
        String r9 = "  *PERS*";
    L22:
        pw.print(r9);
        pw.print(" UID ");
        pw.print(procs.keyAt(ia));
        pw.print(" ");
        pw.println(r3);
        r3.dump(pw, "    ");
        if (r3.isPersistent() == false) goto L25;
        numPers = numPers + 1;
    L25:
        ia = ia + 1;
        goto L10
    L21:
        r9 = "  *APP*";
        goto L22
    L14:
        if (r3.getPkgList().containsKey(dumpPackage) == true) goto L16;
    L26:
        ip = ip + 1;
        goto L8
    L27:
        SysOptBridge.getFactory().getActivityManager(this.mService).dumpProcessesLocked(pw, dumpPackage);
        numPers2 = numPers;
        goto L29
    }

    void writeProcessesToProtoLSP(ProtoOutputStream proto, String dumpPackage) {
        int numOfNames = this.mProcessNames.getMap().size();
        int ip = 0;
        int numPers = 0;
    L3:
        if (ip >= numOfNames) goto L16;
        SparseArray<ProcessRecord> procs = (SparseArray) this.mProcessNames.getMap().valueAt(ip);
        int ia = 0;
        int size = procs.size();
    L5:
        if (ia >= size) goto L15;
        ProcessRecord r = procs.valueAt(ia);
        if (dumpPackage != null) goto L9;
    L11:
        r.dumpDebug(proto, 2246267895809L, this.mLruProcesses.indexOf(r));
        if (r.isPersistent() == false) goto L14;
        numPers = numPers + 1;
    L14:
        ia = ia + 1;
        goto L5
    L9:
        if (r.getPkgList().containsKey(dumpPackage) == true) goto L11;
    L15:
        ip = ip + 1;
        goto L3
    L16:
        int i = 0;
        int size2 = this.mIsolatedProcesses.size();
    L17:
        if (i >= size2) goto L25;
        ProcessRecord r2 = this.mIsolatedProcesses.valueAt(i);
        if (dumpPackage != null) goto L21;
    L23:
        r2.dumpDebug(proto, 2246267895810L, this.mLruProcesses.indexOf(r2));
    L24:
        i = i + 1;
        goto L17
    L21:
        if (r2.getPkgList().containsKey(dumpPackage) == true) goto L23;
    L25:
        int dumpAppId = this.mService.getAppId(dumpPackage);
        this.mActiveUids.dumpProto(proto, dumpPackage, dumpAppId, 2246267895812L);
        if (getLruSizeLOSP() <= 0) goto L29;
        long lruToken = proto.start(1146756268038L);
        int total = getLruSizeLOSP();
        proto.write(1120986464257L, total);
        proto.write(1120986464258L, total - this.mLruProcessActivityStart);
        proto.write(1120986464259L, total - this.mLruProcessServiceStart);
        writeProcessOomListToProto(proto, 2246267895812L, this.mService, this.mLruProcesses, true, dumpPackage);
        proto.end(lruToken);
    L29:
        this.mService.writeOtherProcessesInfoToProtoLSP(proto, dumpPackage, dumpAppId, numPers);
    }

    private static ArrayList<Pair<ProcessRecord, Integer>> sortProcessOomList(List<ProcessRecord> origList, String dumpPackage) {
        ArrayList<Pair<ProcessRecord, Integer>> list = new ArrayList(origList.size());
        int i = 0;
        int size = origList.size();
    L3:
        if (i >= size) goto L11;
        ProcessRecord r = origList.get(i);
        if (dumpPackage != null) goto L7;
    L9:
        list.add(new Pair(origList.get(i), Integer.valueOf(i)));
    L10:
        i = i + 1;
        goto L3
    L7:
        if (r.getPkgList().containsKey(dumpPackage) == true) goto L9;
    L11:
        Comparator<Pair<ProcessRecord, Integer>> comparator = new AnonymousClass3();
        Collections.sort(list, comparator);
        return list;
    }

    private static boolean writeProcessOomListToProto(ProtoOutputStream proto, long fieldId, ActivityManagerService service, List<ProcessRecord> origList, boolean inclDetails, String dumpPackage) {
        List<ProcessRecord> r1 = origList;
        ArrayList<Pair<ProcessRecord, Integer>> list = sortProcessOomList(r1, dumpPackage);
        if (list.isEmpty() == false) goto L6;
        return false;
    L6:
        long curUptime = SystemClock.uptimeMillis();
        boolean r7 = true;
        int i = list.size() - 1;
    L7:
        if (i < 0) goto L55;
        ProcessRecord r = (ProcessRecord) list.get(i).first;
        ProcessStateRecord state = r.mState;
        ProcessServiceRecord psr = r.mServices;
        long token = proto.start(fieldId);
        String oomAdj = makeOomAdjString(state.getSetAdj(), r7);
        boolean r16 = r7;
        proto.write(1133871366145L, r.isPersistent());
        proto.write(1120986464258L, (r1.size() - 1) - ((Integer) list.get(i).second).intValue());
        proto.write(1138166333443L, oomAdj);
        int schedGroup = -1;
        switch(state.getSetSchedGroup()) {
            case 0: goto L14;
            case 1: goto L16;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            default: goto L16;
        };
    L11:
        schedGroup = 3;
        goto L16
    L12:
        schedGroup = 2;
        goto L16
    L13:
        schedGroup = 1;
        goto L16
    L14:
        schedGroup = 0;
    L16:
        if (schedGroup == (-1)) goto L19;
        proto.write(1159641169924L, schedGroup);
    L19:
        if (state.hasForegroundActivities() == false) goto L22;
        proto.write(1133871366149L, r16);
    L24:
        proto.write(1159641169927L, makeProcStateProtoEnum(state.getCurProcState()));
        proto.write(1120986464264L, r.mProfile.getTrimMemoryLevel());
        r.dumpDebug(proto, 1146756268041L);
        proto.write(1138166333450L, state.getAdjType());
        if (state.getAdjSource() != null) goto L29;
        if (state.getAdjTarget() != null) goto L29;
    L42:
        if (inclDetails == false) goto L53;
        long detailToken = proto.start(1146756268047L);
        proto.write(1120986464257L, state.getMaxAdj());
        proto.write(1120986464258L, state.getCurRawAdj());
        proto.write(1120986464259L, state.getSetRawAdj());
        proto.write(1120986464260L, state.getCurAdj());
        proto.write(1120986464261L, state.getSetAdj());
        proto.write(1159641169927L, makeProcStateProtoEnum(state.getCurProcState()));
        proto.write(1159641169928L, makeProcStateProtoEnum(state.getSetProcState()));
        proto.write(1138166333449L, DebugUtils.sizeValueToString(r.mProfile.getLastPss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, new StringBuilder()));
        proto.write(1138166333450L, DebugUtils.sizeValueToString(r.mProfile.getLastSwapPss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, new StringBuilder()));
        proto.write(1138166333451L, DebugUtils.sizeValueToString(r.mProfile.getLastCachedPss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, new StringBuilder()));
        proto.write(1133871366156L, state.isCached());
        proto.write(1133871366157L, state.isEmpty());
        proto.write(1133871366158L, psr.hasAboveClient());
        if (state.getSetProcState() < 10) goto L51;
        long lastCpuTime = r.mProfile.mLastCpuTime.get();
        long curUptime2 = curUptime;
        long curUptime3 = service.mLastPowerCheckUptime;
        long uptimeSince = curUptime2 - curUptime3;
        if (lastCpuTime == 0) goto L52;
        if (uptimeSince <= 0) goto L52;
        long timeUsed = r.mProfile.mCurCpuTime.get() - lastCpuTime;
        long cpuTimeToken = proto.start(1146756268047L);
        proto.write(1112396529665L, uptimeSince);
        proto.write(1112396529666L, timeUsed);
        proto.write(1108101562371L, (timeUsed * 100.0d) / uptimeSince);
        proto.end(cpuTimeToken);
    L52:
        proto.end(detailToken);
    L54:
        proto.end(token);
        i = i - 1;
        r1 = origList;
        curUptime = curUptime2;
        list = list;
        r7 = true;
        goto L7
    L51:
        curUptime2 = curUptime;
        goto L52
    L53:
        curUptime2 = curUptime;
        i = i;
    L29:
        if ((state.getAdjTarget() instanceof ComponentName) == false) goto L33;
        ComponentName cn = (ComponentName) state.getAdjTarget();
        cn.dumpDebug(proto, 1146756268043L);
    L36:
        if ((state.getAdjSource() instanceof ProcessRecord) == false) goto L40;
        ProcessRecord p = (ProcessRecord) state.getAdjSource();
        p.dumpDebug(proto, 1146756268045L);
        goto L42
    L40:
        if (state.getAdjSource() == null) goto L42;
        proto.write(1138166333454L, state.getAdjSource().toString());
        goto L42
    L33:
        if (state.getAdjTarget() == null) goto L36;
        proto.write(1138166333452L, state.getAdjTarget().toString());
        goto L36
    L22:
        if (psr.hasForegroundServices() == false) goto L24;
        proto.write(1133871366150L, r16);
        goto L24
    L55:
        return true;
    }

    private static boolean dumpProcessOomList(PrintWriter pw, ActivityManagerService service, List<ProcessRecord> origList, String prefix, String normalLabel, String persistentLabel, boolean inclDetails, String dumpPackage) {
        ActivityManagerService r1 = service;
        ArrayList<Pair<ProcessRecord, Integer>> list = sortProcessOomList(origList, dumpPackage);
        boolean r7 = false;
        if (list.isEmpty() == false) goto L5;
        return false;
    L5:
        long curUptime = SystemClock.uptimeMillis();
        long uptimeSince = curUptime - r1.mLastPowerCheckUptime;
        boolean r12 = true;
        int i = list.size() - 1;
    L6:
        if (i < 0) goto L69;
        ProcessRecord r = (ProcessRecord) list.get(i).first;
        ProcessStateRecord state = r.mState;
        ProcessServiceRecord psr = r.mServices;
        boolean r16 = r12;
        String oomAdj = makeOomAdjString(state.getSetAdj(), r7);
        switch(state.getSetSchedGroup()) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            default: goto L9;
        };
    L9:
        char schedGroup = '?';
    L16:
        if (state.hasForegroundActivities() == false) goto L19;
        char foreground = 'A';
    L22:
        String procState = makeProcStateString(state.getCurProcState());
        pw.print(prefix);
        long curUptime2 = curUptime;
        if (r.isPersistent() == false) goto L25;
        String r8 = persistentLabel;
    L26:
        pw.print(r8);
        pw.print(" #");
        int num = (origList.size() - 1) - ((Integer) list.get(i).second).intValue();
        ArrayList<Pair<ProcessRecord, Integer>> list2 = list;
        if (num >= 10) goto L29;
        pw.print(' ');
    L29:
        pw.print(num);
        pw.print(": ");
        pw.print(oomAdj);
        pw.print(' ');
        pw.print(schedGroup);
        pw.print('/');
        pw.print(foreground);
        pw.print('/');
        pw.print(procState);
        pw.print(' ');
        ActivityManager.printCapabilitiesSummary(pw, state.getCurCapability());
        pw.print(' ');
        pw.print(" t:");
        if (r.mProfile.getTrimMemoryLevel() >= 10) goto L32;
        char r5 = ' ';
        pw.print(' ');
    L33:
        pw.print(r.mProfile.getTrimMemoryLevel());
        pw.print(r5);
        pw.print(r.toShortString());
        pw.print(" (");
        pw.print(state.getAdjType());
        pw.println(')');
        if (state.getAdjSource() == null) goto L36;
    L39:
        pw.print(prefix);
        pw.print("    ");
        if ((state.getAdjTarget() instanceof ComponentName) == false) goto L43;
        pw.print(((ComponentName) state.getAdjTarget()).flattenToShortString());
    L46:
        pw.print("<=");
        if ((state.getAdjSource() instanceof ProcessRecord) == false) goto L50;
        pw.print("Proc{");
        pw.print(((ProcessRecord) state.getAdjSource()).toShortString());
        pw.println("}");
    L53:
        if (inclDetails == false) goto L66;
        pw.print(prefix);
        pw.print("    ");
        pw.print("oom: max=");
        pw.print(state.getMaxAdj());
        pw.print(" curRaw=");
        pw.print(state.getCurRawAdj());
        pw.print(" setRaw=");
        pw.print(state.getSetRawAdj());
        pw.print(" cur=");
        pw.print(state.getCurAdj());
        pw.print(" set=");
        pw.println(state.getSetAdj());
        pw.print(prefix);
        pw.print("    ");
        pw.print("state: cur=");
        pw.print(makeProcStateString(state.getCurProcState()));
        pw.print(" set=");
        pw.print(makeProcStateString(state.getSetProcState()));
        if (r1.mAppProfiler.isProfilingPss() == false) goto L57;
        pw.print(" lastPss=");
        DebugUtils.printSizeValue(pw, r.mProfile.getLastPss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);
        pw.print(" lastSwapPss=");
        DebugUtils.printSizeValue(pw, r.mProfile.getLastSwapPss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);
        pw.print(" lastCachedPss=");
        DebugUtils.printSizeValue(pw, r.mProfile.getLastCachedPss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);
    L58:
        pw.println();
        pw.print(prefix);
        pw.print("    ");
        pw.print("cached=");
        pw.print(state.isCached());
        pw.print(" empty=");
        pw.print(state.isEmpty());
        pw.print(" hasAboveClient=");
        pw.println(psr.hasAboveClient());
        if (state.getSetProcState() < 10) goto L67;
        long lastCpuTime = r.mProfile.mLastCpuTime.get();
        if (lastCpuTime == 0) goto L67;
        if (uptimeSince <= 0) goto L67;
        long lastCpuTime2 = r.mProfile.mCurCpuTime.get() - lastCpuTime;
        pw.print(prefix);
        pw.print("    ");
        pw.print("run cpu over ");
        TimeUtils.formatDuration(uptimeSince, pw);
        pw.print(" used ");
        TimeUtils.formatDuration(lastCpuTime2, pw);
        pw.print(" (");
        pw.print((100 * lastCpuTime2) / uptimeSince);
        pw.println("%)");
    L67:
        i = i - 1;
        r1 = service;
        r12 = r16;
        list = list2;
        curUptime = curUptime2;
        r7 = false;
        goto L6
    L57:
        pw.print(" lastRss=");
        DebugUtils.printSizeValue(pw, r.mProfile.getLastRss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);
        pw.print(" lastCachedRss=");
        DebugUtils.printSizeValue(pw, r.mProfile.getLastCachedRss() * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);
        goto L58
    L66:
        i = i;
        goto L67
    L50:
        if (state.getAdjSource() == null) goto L52;
        pw.println(state.getAdjSource().toString());
        goto L53
    L52:
        pw.println("{null}");
        goto L53
    L43:
        if (state.getAdjTarget() == null) goto L45;
        pw.print(state.getAdjTarget().toString());
        goto L46
    L45:
        pw.print("{null}");
        goto L46
    L36:
        if (state.getAdjTarget() == null) goto L53;
    L32:
        r5 = ' ';
        goto L33
    L25:
        r8 = normalLabel;
        goto L26
    L19:
        if (psr.hasForegroundServices() == false) goto L21;
        foreground = 'S';
        goto L22
    L21:
        foreground = ' ';
        goto L22
    L10:
        schedGroup = 'B';
        goto L16
    L11:
        schedGroup = 'T';
        goto L16
    L12:
        schedGroup = 'F';
        goto L16
    L13:
        schedGroup = 'R';
        goto L16
    L14:
        schedGroup = 'b';
        goto L16
    L69:
        return r12;
    }

    private void printOomLevel(PrintWriter pw, String name, int adj) {
        pw.print("    ");
        if (adj < 0) goto L8;
        pw.print(' ');
        if (adj >= 10) goto L10;
        pw.print(' ');
    L10:
        pw.print(adj);
        pw.print(": ");
        pw.print(name);
        pw.print(" (");
        pw.print(ActivityManagerService.stringifySize(getMemLevel(adj), 1024));
        pw.println(")");
        return;
    L8:
        if (adj <= (-10)) goto L10;
        pw.print(' ');
        goto L10
    }

    boolean dumpOomLocked(FileDescriptor fd, PrintWriter pw, boolean needSep, String[] args, int opti, boolean dumpAll, String dumpPackage, boolean inclGc) {
        if (getLruSizeLOSP() <= 0) goto L10;
        if (needSep == false) goto L6;
        pw.println();
    L6:
        pw.println("  OOM levels:");
        printOomLevel(pw, "SYSTEM_ADJ", SYSTEM_ADJ);
        printOomLevel(pw, "PERSISTENT_PROC_ADJ", PERSISTENT_PROC_ADJ);
        printOomLevel(pw, "PERSISTENT_SERVICE_ADJ", PERSISTENT_SERVICE_ADJ);
        printOomLevel(pw, "FOREGROUND_APP_ADJ", 0);
        printOomLevel(pw, "VISIBLE_APP_ADJ", 100);
        printOomLevel(pw, "PERCEPTIBLE_APP_ADJ", 200);
        printOomLevel(pw, "PERCEPTIBLE_MEDIUM_APP_ADJ", PERCEPTIBLE_MEDIUM_APP_ADJ);
        printOomLevel(pw, "PERCEPTIBLE_LOW_APP_ADJ", 250);
        printOomLevel(pw, "BACKUP_APP_ADJ", 300);
        printOomLevel(pw, "HEAVY_WEIGHT_APP_ADJ", 400);
        printOomLevel(pw, "SERVICE_ADJ", 500);
        printOomLevel(pw, "HOME_APP_ADJ", 600);
        printOomLevel(pw, "PREVIOUS_APP_ADJ", 700);
        printOomLevel(pw, "SERVICE_B_ADJ", 800);
        printOomLevel(pw, "CACHED_APP_MIN_ADJ", 900);
        printOomLevel(pw, "CACHED_APP_MAX_ADJ", 999);
        if (1 == 0) goto L9;
        pw.println();
    L9:
        pw.print("  Process OOM control (");
        pw.print(getLruSizeLOSP());
        pw.print(" total, non-act at ");
        pw.print(getLruSizeLOSP() - this.mLruProcessActivityStart);
        pw.print(", non-svc at ");
        pw.print(getLruSizeLOSP() - this.mLruProcessServiceStart);
        pw.println("):");
        dumpProcessOomList(pw, this.mService, this.mLruProcesses, "    ", "Proc", "PERS", true, dumpPackage);
        needSep = true;
    L10:
        Object r2 = this.mService.mAppProfiler.mProfilerLock;
        monitor-enter(r2);
        this.mService.mAppProfiler.dumpProcessesToGc(pw, needSep, dumpPackage);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        pw.println();
        this.mService.mAtmInternal.dumpForOom(pw);
        return true;
    L18:
        th = th;
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L18
        throw th;
    L20:
        th = th;
        goto L22
    }

    void registerProcessObserver(IProcessObserver observer) {
        RemoteCallbackList<IProcessObserver> r0 = this.mProcessObservers;
        monitor-enter(r0);
        this.mProcessObservers.register(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void unregisterProcessObserver(IProcessObserver observer) {
        RemoteCallbackList<IProcessObserver> r0 = this.mProcessObservers;
        monitor-enter(r0);
        this.mProcessObservers.unregister(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void dispatchProcessesChanged() {
        Object r0 = this.mProcessChangeLock;
        monitor-enter(r0);
        int numOfChanges = this.mPendingProcessChanges.size();     // Catch: Throwable -> L7
        if (this.mActiveProcessChanges.length >= numOfChanges) goto L9;
        this.mActiveProcessChanges = new ActivityManagerService.ProcessChangeItem[numOfChanges];     // Catch: Throwable -> L7
    L9:
        this.mPendingProcessChanges.toArray(this.mActiveProcessChanges);     // Catch: Throwable -> L7
        this.mPendingProcessChanges.clear();     // Catch: Throwable -> L7
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L12;
        Slog.i("ActivityManager", "*** Delivering " + numOfChanges + " process changes");     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        RemoteCallbackList<IProcessObserver> r2 = this.mProcessObservers;
        monitor-enter(r2);
        int i = this.mProcessObservers.beginBroadcast();     // Catch: Throwable -> L26
    L16:
        if (i <= 0) goto L40;
        i = i - 1;     // Catch: Throwable -> L26
        IProcessObserver observer = this.mProcessObservers.getBroadcastItem(i);     // Catch: Throwable -> L26
        if (observer == null) goto L16;
        int j = 0;
    L20:
        if (j >= numOfChanges) goto L16;
        ActivityManagerService.ProcessChangeItem item = this.mActiveProcessChanges[j];     // Catch: Throwable -> L26 RemoteException -> L28
        if ((item.changes & 1) == 0) goto L32;
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L30;
        Slog.i("ActivityManager", "ACTIVITIES CHANGED pid=" + item.pid + " uid=" + item.uid + ": " + item.foregroundActivities);     // Catch: Throwable -> L26 RemoteException -> L28
    L30:
        observer.onForegroundActivitiesChanged(item.pid, item.uid, item.foregroundActivities);     // Catch: Throwable -> L26 RemoteException -> L28
    L32:
        if ((item.changes & 2) == 0) goto L37;
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L36;
        Slog.i("ActivityManager", "FOREGROUND SERVICES CHANGED pid=" + item.pid + " uid=" + item.uid + ": " + item.foregroundServiceTypes);     // Catch: Throwable -> L26 RemoteException -> L28
    L36:
        observer.onForegroundServicesChanged(item.pid, item.uid, item.foregroundServiceTypes);     // Catch: Throwable -> L26 RemoteException -> L28
    L37:
        j = j + 1;
        goto L20
    L40:
        this.mProcessObservers.finishBroadcast();     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        Object r1 = this.mProcessChangeLock;
        monitor-enter(r1);
        int j2 = 0;
    L45:
        if (j2 >= numOfChanges) goto L50;
        this.mAvailProcessChanges.add(this.mActiveProcessChanges[j2]);     // Catch: Throwable -> L47
        j2 = j2 + 1;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L50:
        monitor-exit(r1);     // Catch: Throwable -> L47
        return;
    L26:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        throw th;
    }

    void enqueueProcessChangeItemLocked(int pid, int uid, int changes, int foregroundServicetypes) {
        Object r0 = this.mProcessChangeLock;
        monitor-enter(r0);
        ActivityManagerService.ProcessChangeItem item = enqueueProcessChangeItemLocked(pid, uid);     // Catch: Throwable -> L7
        item.changes |= changes;     // Catch: Throwable -> L7
        item.foregroundServiceTypes = foregroundServicetypes;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void enqueueProcessChangeItemLocked(int pid, int uid, int changes, boolean hasForegroundActivities) {
        Object r0 = this.mProcessChangeLock;
        monitor-enter(r0);
        ActivityManagerService.ProcessChangeItem item = enqueueProcessChangeItemLocked(pid, uid);     // Catch: Throwable -> L7
        item.changes |= changes;     // Catch: Throwable -> L7
        item.foregroundActivities = hasForegroundActivities;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ActivityManagerService.ProcessChangeItem enqueueProcessChangeItemLocked(int pid, int uid) {
        int i = this.mPendingProcessChanges.size() - 1;
        ActivityManagerService.ProcessChangeItem item = null;
    L4:
        if (i < 0) goto L11;
        ActivityManagerService.ProcessChangeItem item2 = this.mPendingProcessChanges.get(i);
        item = item2;
        if (item.pid == pid) goto L8;
        i = i - 1;
        goto L4
    L8:
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L11;
        Slog.i("ActivityManager", "Re-using existing item: " + item);
    L11:
        if (i >= 0) goto L28;
        int num = this.mAvailProcessChanges.size();
        if (num <= 0) goto L17;
        ActivityManagerService.ProcessChangeItem item3 = this.mAvailProcessChanges.remove(num - 1);
        item = item3;
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L21;
        Slog.i("ActivityManager", "Retrieving available item: " + item);
    L21:
        item.changes = 0;
        item.pid = pid;
        item.uid = uid;
        if (this.mPendingProcessChanges.size() == 0) goto L24;
    L27:
        this.mPendingProcessChanges.add(item);
        goto L28
    L24:
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L26;
        Slog.i("ActivityManager", "*** Enqueueing dispatch processes changed!");
    L26:
        this.mService.mUiHandler.obtainMessage(31).sendToTarget();
        goto L27
    L17:
        ActivityManagerService.ProcessChangeItem item4 = new ActivityManagerService.ProcessChangeItem();
        if (ActivityManagerDebugConfig.DEBUG_PROCESS_OBSERVERS == false) goto L20;
        Slog.i("ActivityManager", "Allocating new item: " + item4);
    L20:
        item = item4;
    L28:
        return item;
    }

    void scheduleDispatchProcessDiedLocked(int pid, int uid) {
        scheduleDispatchProcessDiedLocked(pid, uid, false);
    }

    void scheduleDispatchProcessDiedLocked(int pid, int uid, boolean freezing) {
        if (freezing == true) goto L20;
        Object r0 = this.mProcessChangeLock;
        monitor-enter(r0);
        int i = this.mPendingProcessChanges.size() - 1;     // Catch: Throwable -> L12
    L6:
        if (i < 0) goto L15;
        ActivityManagerService.ProcessChangeItem item = this.mPendingProcessChanges.get(i);     // Catch: Throwable -> L12
        if (pid <= 0) goto L14;
        if (item.pid != pid) goto L14;
        this.mPendingProcessChanges.remove(i);     // Catch: Throwable -> L12
        this.mAvailProcessChanges.add(item);     // Catch: Throwable -> L12
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L6
    L15:
        this.mService.mUiHandler.obtainMessage(32, pid, uid, null).sendToTarget();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void dispatchProcessStarted(ProcessRecord app, int pid) {
        Slog.i("ActivityManager", "ProcessObserver broadcast disabled");
    }

    void dispatchProcessDied(int pid, int uid) {
        RemoteCallbackList<IProcessObserver> r0 = this.mProcessObservers;
        monitor-enter(r0);
        int i = this.mProcessObservers.beginBroadcast();     // Catch: Throwable -> L10
    L5:
        if (i <= 0) goto L14;
        i = i - 1;     // Catch: Throwable -> L10
        IProcessObserver observer = this.mProcessObservers.getBroadcastItem(i);     // Catch: Throwable -> L10
        if (observer == null) goto L5;
        observer.onProcessDied(pid, uid);     // Catch: Throwable -> L10 RemoteException -> L12
        goto L5
    L14:
        this.mProcessObservers.finishBroadcast();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    ArrayList<ProcessRecord> collectProcessesLOSP(int start, boolean allPkgs, String[] args) {
        if (args == null) goto L34;
        if (args.length <= start) goto L34;
        if (args[start].charAt(0) == '-') goto L34;
        ArrayList<ProcessRecord> procs = new ArrayList();
        int pid = -1;
        pid = Integer.parseInt(args[start]);     // Catch: NumberFormatException -> L10
    L11:
        int i = this.mLruProcesses.size() - 1;
    L12:
        if (i < 0) goto L28;
        ProcessRecord proc = this.mLruProcesses.get(i);
        if (proc.getPid() > 0) goto L16;
    L18:
        if (allPkgs == false) goto L25;
        if (proc.getPkgList() == null) goto L25;
        if (proc.getPkgList().containsKey(args[start]) == false) goto L25;
        procs.add(proc);
    L27:
        i = i - 1;
    L25:
        if (proc.processName.equals(args[start]) == false) goto L27;
        procs.add(proc);
        goto L27
    L16:
        if (proc.getPid() != pid) goto L18;
        procs.add(proc);
        goto L27
    L28:
        int i2 = procs.size();
        if (i2 > 0) goto L42;
        return null;
    L42:
        return procs;
    L34:
        return new ArrayList(this.mLruProcesses);
    }

    void updateApplicationInfoLOSP(List<String> packagesToUpdate, int userId, boolean updateFrameworkRes) {
        final ArrayMap<String, ApplicationInfo> applicationInfoByPackage = new ArrayMap();
        int i = packagesToUpdate.size() - 1;
    L3:
        if (i < 0) goto L8;
        String packageName = packagesToUpdate.get(i);
        int userId2 = userId;
        ApplicationInfo ai = this.mService.getPackageManagerInternal().getApplicationInfo(packageName, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, 1000, userId2);
        if (ai == null) goto L7;
        applicationInfoByPackage.put(packageName, ai);
    L7:
        i = i - 1;
        userId = userId2;
        goto L3
    L8:
        int userId3 = userId;
        this.mService.mActivityTaskManager.updateActivityApplicationInfo(userId3, applicationInfoByPackage);
        final ArrayList<WindowProcessController> targetProcesses = new ArrayList();
        int i2 = this.mLruProcesses.size() - 1;
    L9:
        if (i2 < 0) goto L20;
        final ProcessRecord app = this.mLruProcesses.get(i2);
        if (app.getThread() != null) goto L14;
        final List<String> packagesToUpdate2 = packagesToUpdate;
        final boolean updateFrameworkRes2 = updateFrameworkRes;
    L19:
        i2 = i2 - 1;
        updateFrameworkRes = updateFrameworkRes2;
        packagesToUpdate = packagesToUpdate2;
        goto L9
    L14:
        if (userId3 != (-1)) goto L16;
    L18:
        packagesToUpdate2 = packagesToUpdate;
        updateFrameworkRes2 = updateFrameworkRes;
        app.getPkgList().forEachPackage(new ProcessList$$ExternalSyntheticLambda4(updateFrameworkRes2, packagesToUpdate2, applicationInfoByPackage, app, targetProcesses));
        goto L19
    L16:
        if (app.userId == userId3) goto L18;
        packagesToUpdate2 = packagesToUpdate;
        updateFrameworkRes2 = updateFrameworkRes;
        goto L19
    L20:
        this.mService.mActivityTaskManager.updateAssetConfiguration(targetProcesses, updateFrameworkRes);
    }

    private static /* synthetic */ void lambda$updateApplicationInfoLOSP$4(boolean updateFrameworkRes, List packagesToUpdate, ArrayMap applicationInfoByPackage, ProcessRecord app, ArrayList targetProcesses, String packageName) {
        if (updateFrameworkRes == false) goto L4;
    L16:
        ApplicationInfo ai = (ApplicationInfo) applicationInfoByPackage.get(packageName);     // Catch: RemoteException -> L10
        if (ai != null) goto L8;
        return;
    L8:
        if (ai.packageName.equals(app.info.packageName) == false) goto L12;
        app.info = ai;     // Catch: RemoteException -> L10
        app.getWindowProcessController().updateApplicationInfo(ai);     // Catch: RemoteException -> L10
        PlatformCompatCache.getInstance().onApplicationInfoChanged(ai);     // Catch: RemoteException -> L10
    L12:
        app.getThread().scheduleApplicationInfoChanged(ai);     // Catch: RemoteException -> L10
        targetProcesses.add(app.getWindowProcessController());     // Catch: RemoteException -> L10
        return;
    L14:
        Slog.w("ActivityManager", String.format("Failed to update %s ApplicationInfo for %s", new Object[]{packageName, app}));
        return;
    L4:
        if (packagesToUpdate.contains(packageName) == true) goto L16;
    }

    void sendPackageBroadcastLocked(int cmd, String[] packages, int userId) {
        boolean foundProcess = false;
        int i = this.mLruProcesses.size() - 1;
    L3:
        if (i < 0) goto L22;
        ProcessRecord r = this.mLruProcesses.get(i);
        IApplicationThread thread = r.getThread();
        if (thread == null) goto L20;
        if (userId != (-1)) goto L9;
    L29:
        int index = packages.length - 1;     // Catch: RemoteException -> L17
    L11:
        if (index < 0) goto L19;
        if (foundProcess == true) goto L19;
        if (packages[index].equals(r.info.packageName) == false) goto L16;
        foundProcess = true;
    L16:
        index = index - 1;     // Catch: RemoteException -> L17
    L19:
        thread.dispatchPackageBroadcast(cmd, packages);     // Catch: RemoteException -> L17
        goto L20
    L9:
        if (r.userId == userId) goto L29;
    L20:
        i = i - 1;
        goto L3
    L22:
        if (foundProcess == true) goto L40;
        AppGlobals.getPackageManager().notifyPackagesReplacedReceived(packages);     // Catch: RemoteException -> L25
        return;
    L26:
        return;
    }

    int getUidProcStateLOSP(int uid) {
        UidRecord uidRec = this.mActiveUids.get(uid);
        if (uidRec != null) goto L6;
        return 20;
    L6:
        return uidRec.getCurProcState();
    }

    int getUidProcessCapabilityLOSP(int uid) {
        UidRecord uidRec = this.mActiveUids.get(uid);
        if (uidRec != null) goto L6;
        return 0;
    L6:
        return uidRec.getCurCapability();
    }

    UidRecord getUidRecordLOSP(int uid) {
        return this.mActiveUids.get(uid);
    }

    void doStopUidForIdleUidsLocked() {
        int size = this.mActiveUids.size();
        int i = 0;
    L3:
        if (i >= size) goto L13;
        int uid = this.mActiveUids.keyAt(i);
        if (UserHandle.isCore(uid) == true) goto L11;
        UidRecord uidRec = this.mActiveUids.valueAt(i);
        if (uidRec.isIdle() == false) goto L11;
        this.mService.doStopUidLocked(uidRec.getUid(), uidRec);
    L11:
        i = i + 1;
        goto L3
    }

    int getBlockStateForUid(UidRecord uidRec) {
        if (NetworkPolicyManager.isProcStateAllowedWhileIdleOrPowerSaveMode(uidRec.getCurProcState(), uidRec.getCurCapability()) == false) goto L5;
    L8:
        boolean isAllowed = true;
    L10:
        if (NetworkPolicyManager.isProcStateAllowedWhileIdleOrPowerSaveMode(uidRec.getSetProcState(), uidRec.getSetCapability()) == false) goto L12;
    L15:
        boolean wasAllowed = true;
    L17:
        if (wasAllowed == true) goto L20;
        if (isAllowed == false) goto L20;
        return 1;
    L20:
        if (wasAllowed == false) goto L24;
        if (isAllowed == true) goto L24;
        return 2;
    L24:
        return 0;
    L12:
        if (NetworkPolicyManager.isProcStateAllowedWhileOnRestrictBackground(uidRec.getSetProcState(), uidRec.getSetCapability()) == true) goto L15;
        wasAllowed = false;
        goto L17
    L5:
        if (NetworkPolicyManager.isProcStateAllowedWhileOnRestrictBackground(uidRec.getCurProcState(), uidRec.getCurCapability()) == true) goto L8;
        isAllowed = false;
        goto L10
    }

    void incrementProcStateSeqAndNotifyAppsLOSP(ActiveUids activeUids) {
        int i = activeUids.size() - 1;
    L3:
        if (i < 0) goto L6;
        activeUids.valueAt(i).curProcStateSeq = getNextProcStateSeq();
        i = i - 1;
        goto L3
    L6:
        if (this.mService.mConstants.mNetworkAccessTimeoutMs > 0) goto L8;
        return;
    L8:
        ArrayList<Integer> blockingUids = null;
        int i2 = activeUids.size() - 1;
    L9:
        if (i2 < 0) goto L46;
        UidRecord uidRec = activeUids.valueAt(i2);
        if (this.mService.mInjector.isNetworkRestrictedForUid(uidRec.getUid()) == false) goto L44;
        if (UserHandle.isApp(uidRec.getUid()) == false) goto L44;
        if (uidRec.hasInternetPermission == false) goto L44;
        if (uidRec.getSetProcState() == uidRec.getCurProcState()) goto L21;
    L23:
        int blockState = getBlockStateForUid(uidRec);
        if (blockState == 0) goto L44;
        Object r7 = uidRec.networkStateLock;
        monitor-enter(r7);
        if (blockState != 1) goto L35;
        if (blockingUids == null) goto L68;
    L33:
        blockingUids.add(Integer.valueOf(uidRec.getUid()));     // Catch: Throwable -> L31
    L40:
        monitor-exit(r7);     // Catch: Throwable -> L31
        goto L44
    L68:
        blockingUids = new ArrayList();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L35:
        if (ActivityManagerDebugConfig.DEBUG_NETWORK == false) goto L38;
        Slog.d("ActivityManager_Network", "uid going to background, notifying all blocking threads for uid: " + uidRec);     // Catch: Throwable -> L31
    L38:
        if (uidRec.procStateSeqWaitingForNetwork == 0) goto L40;
        uidRec.networkStateLock.notifyAll();     // Catch: Throwable -> L31
        goto L40
    L21:
        if (uidRec.getSetCapability() != uidRec.getCurCapability()) goto L23;
    L44:
        i2 = i2 - 1;
        goto L9
    L46:
        if (blockingUids != null) goto L48;
        return;
    L48:
        int i3 = this.mLruProcesses.size() - 1;
    L49:
        if (i3 < 0) goto L67;
        ProcessRecord app = this.mLruProcesses.get(i3);
        if (blockingUids.contains(Integer.valueOf(app.uid)) == false) goto L65;
        IApplicationThread thread = app.getThread();
        if (app.isKilledByAm() == true) goto L65;
        if (thread == null) goto L65;
        UidRecord uidRec2 = getUidRecordLOSP(app.uid);
        if (ActivityManagerDebugConfig.DEBUG_NETWORK == false) goto L62;
        Slog.d("ActivityManager_Network", "Informing app thread that it needs to block: " + uidRec2);     // Catch: RemoteException -> L60
    L62:
        if (uidRec2 == null) goto L65;
        thread.setNetworkBlockSeq(uidRec2.curProcStateSeq);     // Catch: RemoteException -> L60
    L65:
        i3 = i3 - 1;
        goto L49
    }

    long getNextProcStateSeq() {
        long r0 = this.mProcStateSeqCounter + 1;
        this.mProcStateSeqCounter = r0;
        return r0;
    }

    private LocalSocket createSystemServerSocketForZygote() {
        File socketFile = new File(UNSOL_ZYGOTE_MSG_SOCKET_PATH);
        if (socketFile.exists() == false) goto L5;
        socketFile.delete();
    L5:
        LocalSocket serverSocket = null;
        serverSocket = new LocalSocket(1);     // Catch: Exception -> L8
        serverSocket.bind(new LocalSocketAddress(UNSOL_ZYGOTE_MSG_SOCKET_PATH, LocalSocketAddress.Namespace.FILESYSTEM));     // Catch: Exception -> L8
        Os.chmod(UNSOL_ZYGOTE_MSG_SOCKET_PATH, 438);     // Catch: Exception -> L8
        return serverSocket;
    L9:
        if (serverSocket == null) goto L19;
        serverSocket.close();     // Catch: IOException -> L12
    L13:
        return null;
    L19:
        return serverSocket;
    }

    private int handleZygoteMessages(FileDescriptor fd, int events) {
        fd.getInt$();
        if ((events & 1) != 0) goto L15;
    L14:
        return 1;
    L15:
        int len = Os.read(fd, this.mZygoteUnsolicitedMessage, 0, this.mZygoteUnsolicitedMessage.length);     // Catch: Exception -> L10
        if (len <= 0) goto L14;
        if (this.mZygoteSigChldMessage.length != Zygote.nativeParseSigChld(this.mZygoteUnsolicitedMessage, len, this.mZygoteSigChldMessage)) goto L14;
        this.mAppExitInfoTracker.handleZygoteSigChld(this.mZygoteSigChldMessage[0], this.mZygoteSigChldMessage[1], this.mZygoteSigChldMessage[2]);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Slog.w("ActivityManager", "Exception in reading unsolicited zygote message: " + e);
        goto L14
    }

    boolean handleDyingAppDeathLocked(ProcessRecord app, int pid) {
        if (this.mProcessNames.get(app.processName, app.uid) != app) goto L5;
    L8:
        return false;
    L5:
        if (this.mDyingProcesses.get(app.processName, app.uid) != app) goto L8;
        Slog.v("ActivityManager", "Got obituary of " + pid + ":" + app.processName);
        app.unlinkDeathRecipient();
        this.mDyingProcesses.remove(app.processName, app.uid);
        app.setDyingPid(0);
        handlePrecedingAppDiedLocked(app);
        removeLruProcessLocked(app);
        return true;
    }

    boolean handlePrecedingAppDiedLocked(ProcessRecord app) {
        if (app.mSuccessor != null) goto L5;
        return true;
    L5:
        if (app.isPersistent() == true) goto L7;
    L11:
        app.mSuccessor.mPredecessor = null;
        app.mSuccessor = null;
        this.mService.mProcStartHandler.removeMessages(2, app);
        this.mService.mProcStartHandler.obtainMessage(1, app).sendToTarget();
        return false;
    L7:
        if (app.isRemoved() == true) goto L11;
        if (this.mService.mPersistentStartingProcesses.indexOf(app.mSuccessor) >= 0) goto L11;
        this.mService.mPersistentStartingProcesses.add(app.mSuccessor);
        goto L11
    }

    void updateBackgroundRestrictedForUidPackageLocked(int uid, final String packageName, final boolean restricted) {
        UidRecord uidRec = getUidRecordLOSP(uid);
        if (uidRec == null) goto L6;
        final long nowElapsed = SystemClock.elapsedRealtime();
        uidRec.forEachProcess(new ProcessList$$ExternalSyntheticLambda1(this, packageName, restricted, nowElapsed));
        this.mService.updateOomAdjPendingTargetsLocked(21);
        return;
    }

    private /* synthetic */ void lambda$updateBackgroundRestrictedForUidPackageLocked$5(String packageName, boolean restricted, long nowElapsed, ProcessRecord app) {
        if (TextUtils.equals(app.info.packageName, packageName) == false) goto L19;
        app.mState.setBackgroundRestricted(restricted);
        if (restricted == false) goto L14;
        this.mAppsInBackgroundRestricted.add(app);
        long future = killAppIfBgRestrictedAndCachedIdleLocked(app, nowElapsed);
        if (future <= 0) goto L16;
        if (this.mService.mDeterministicUidIdle == false) goto L11;
    L12:
        this.mService.mHandler.sendEmptyMessageDelayed(58, future - nowElapsed);
        goto L16
    L11:
        if (this.mService.mHandler.hasMessages(58) == false) goto L12;
    L16:
        if (app.isKilledByAm() == true) goto L20;
        this.mService.enqueueOomAdjTargetLocked(app);
        return;
    L20:
        return;
    L14:
        this.mAppsInBackgroundRestricted.remove(app);
        goto L16
    }

    long killAppIfBgRestrictedAndCachedIdleLocked(ProcessRecord app, long nowElapsed) {
        UidRecord uidRec = app.getUidRecord();
        long lastCanKillTime = app.mState.getLastCanKillOnBgRestrictedAndIdleTime();
        if (this.mService.mConstants.mKillBgRestrictedAndCachedIdle == true) goto L5;
    L25:
        return 0;
    L5:
        if (app.isKilled() == true) goto L25;
        if (app.getThread() == null) goto L25;
        if (uidRec == null) goto L25;
        if (uidRec.isIdle() == false) goto L25;
        if (app.isCached() == false) goto L25;
        if (app.mState.shouldNotKillOnBgRestrictedAndIdle() == true) goto L25;
        if (app.mState.isBackgroundRestricted() == false) goto L25;
        if (lastCanKillTime == 0) goto L25;
        long future = this.mService.mConstants.mKillBgRestrictedAndCachedIdleSettleTimeMs + lastCanKillTime;
        if (future > nowElapsed) goto L24;
        app.killLocked("cached idle & background restricted", 13, 18, true);
        return 0;
    L24:
        return future;
    }

    void killAppIfBgRestrictedAndCachedIdleLocked(UidRecord uidRec) {
        final long nowElapsed = SystemClock.elapsedRealtime();
        uidRec.forEachProcess(new ProcessList$$ExternalSyntheticLambda6(this, nowElapsed));
    }

    private /* synthetic */ void lambda$killAppIfBgRestrictedAndCachedIdleLocked$6(long nowElapsed, ProcessRecord app) {
        killAppIfBgRestrictedAndCachedIdleLocked(app, nowElapsed);
    }

    void noteProcessDiedLocked(ProcessRecord app) {
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L5;
        Slog.i("ActivityManager", "note: " + app + " died, saving the exit info");
    L5:
        Watchdog.getInstance().processDied(app.processName, app.getPid());
        if (app.getDeathRecipient() == null) goto L8;
    L10:
        this.mAppExitInfoTracker.scheduleNoteProcessDied(app);
        return;
    L8:
        if (this.mDyingProcesses.get(app.processName, app.uid) != app) goto L10;
        this.mDyingProcesses.remove(app.processName, app.uid);
        app.setDyingPid(0);
        goto L10
    }

    void noteAppRecoverableCrash(ProcessRecord app) {
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L5;
        Slog.i("ActivityManager", "note: " + app + " has a recoverable native crash");
    L5:
        this.mAppExitInfoTracker.scheduleNoteAppRecoverableCrash(app);
    }

    void noteAppKill(ProcessRecord app, int reason, int subReason, String msg) {
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L6;
        Slog.i("ActivityManager", "note: " + app + " is being killed, reason: " + ApplicationExitInfo.reasonCodeToString(reason) + ", sub-reason: " + ApplicationExitInfo.subreasonToString(subReason) + ", message: " + msg);
    L6:
        if (app.getPid() > 0) goto L8;
    L12:
        this.mAppExitInfoTracker.scheduleNoteAppKill(app, reason, subReason, msg);
        return;
    L8:
        if (app.isolated == true) goto L12;
        if (app.getDeathRecipient() == null) goto L12;
        this.mDyingProcesses.put(app.processName, app.uid, app);
        app.setDyingPid(app.getPid());
        goto L12
    }

    void noteAppKill(int pid, int uid, int reason, int subReason, String msg) {
        if (ActivityManagerDebugConfig.DEBUG_PROCESSES == false) goto L5;
        Slog.i("ActivityManager", "note: " + pid + " is being killed, reason: " + reason + ", sub-reason: " + subReason + ", message: " + msg);
    L5:
        ActivityManagerService.PidMap r1 = this.mService.mPidsSelfLocked;
        monitor-enter(r1);
        ProcessRecord app = this.mService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        if (app != null) goto L11;
    L17:
        this.mAppExitInfoTracker.scheduleNoteAppKill(pid, uid, reason, subReason, msg);
        return;
    L11:
        if (app.uid != uid) goto L17;
        if (app.isolated == true) goto L17;
        if (app.getDeathRecipient() == null) goto L17;
        this.mDyingProcesses.put(app.processName, uid, app);
        app.setDyingPid(app.getPid());
    L19:
        th = th;
    L25:
        throw th;
    L23:
        th = th;
        goto L25
    }

    void killProcessesWhenImperceptible(int[] pids, String reason, int requester) {
        if (ArrayUtils.isEmpty(pids) == false) goto L5;
        return;
    L5:
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int i = 0;
    L30:
    L17:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L9:
        if (i >= pids.length) goto L24;
        ActivityManagerService.PidMap r2 = this.mService.mPidsSelfLocked;     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        ProcessRecord app = this.mService.mPidsSelfLocked.get(pids[i]);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        if (app == null) goto L19;
        this.mImperceptibleKillRunner.enqueueLocked(app, reason, requester);     // Catch: Throwable -> L17
    L19:
        i = i + 1;
        goto L30
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L17
        ActivityManagerService.resetPriorityAfterLockedSection();
    }

    Pair<Integer, Integer> getNumForegroundServices() {
        int numForegroundServices = 0;
        int procs = 0;
        ActivityManagerService r2 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        int i = 0;
        int size = this.mLruProcesses.size();     // Catch: Throwable -> L11
    L6:
        if (i >= size) goto L14;
        ProcessRecord pr = this.mLruProcesses.get(i);     // Catch: Throwable -> L11
        int numFgs = pr.mServices.getNumForegroundServices();     // Catch: Throwable -> L11
        if (numFgs <= 0) goto L10;
        numForegroundServices = numForegroundServices + numFgs;     // Catch: Throwable -> L11
        procs = procs + 1;     // Catch: Throwable -> L11
    L10:
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        return new Pair(Integer.valueOf(numForegroundServices), Integer.valueOf(procs));
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public ProcessListSmtBase getSmtEx() {
        return this.mSmtEx;
    }
}

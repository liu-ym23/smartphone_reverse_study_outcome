package com.android.server;

import android.app.IActivityController;
import android.app.SysMonitorFwBridge;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.biometrics.face.V1_0.IBiometricsFace;
import android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint;
import android.hardware.health.V2_0.IHealth;
import android.hidl.manager.V1_0.IServiceManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Debug;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IPowerManager;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceDebugInfo;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.sysprop.WatchdogProperties;
import android.util.Dumpable;
import android.util.EventLog;
import android.util.Log;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.ProcessCpuTracker;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.ProcessRecord;
import com.android.server.am.StackTracesDumpHelper;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.am.TraceErrorLogger;
import com.android.server.am.trace.SmartTraceUtils;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.criticalevents.CriticalEventLog;
import com.android.server.wm.SurfaceAnimationThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class Watchdog implements Dumpable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String[] AIDL_INTERFACE_PREFIXES_OF_INTEREST = null;
    static final int COMPLETED = 0;
    private static final boolean DB = false;
    public static final boolean DEBUG = false;
    private static final long DEFAULT_TIMEOUT = 60000;
    public static final List<String> HAL_INTERFACES_OF_INTEREST = null;
    public static final String[] NATIVE_STACKS_OF_INTEREST = null;
    static final int OVERDUE = 3;
    private static final int PRE_WATCHDOG_TIMEOUT_RATIO = 4;
    private static final String PROP_FATAL_LOOP_COUNT = "framework_watchdog.fatal_count";
    private static final String PROP_FATAL_LOOP_WINDOWS_SECS = "framework_watchdog.fatal_window.second";
    static final String TAG = "Watchdog";
    private static final String TIMEOUT_HISTORY_FILE = "/data/system/watchdog-timeout-history.txt";
    static final int WAITED_UNTIL_PRE_WATCHDOG = 2;
    static final int WAITING = 1;
    static final int WATCHDOG_MONITOR_TIMEOUT_CHECK = 300;
    static final int WATCHDOG_MONITOR_TIMEOUT_INIT = 0;
    static final int WATCHDOG_MONITOR_TIMEOUT_SWT = 420;
    static final int WATCHDOG_MONITOR_TIMEOUT_WAIT_HALF = 360;
    private static Watchdog sWatchdog;
    private ActivityManagerService mActivity;
    private final boolean mActivityControllerRestart;
    private boolean mAllowRestart;
    private IActivityController mController;
    private final ArrayList<HandlerCheckerAndTimeout> mHandlerCheckers;
    private final List<Integer> mInterestingJavaPids;
    private boolean mIsMonkey;
    private final Object mLock;
    private final HandlerChecker mMonitorChecker;
    private final Thread mThread;
    SimpleDateFormat mTraceDateFormat;
    private final TraceErrorLogger mTraceErrorLogger;
    private volatile long mWatchdogTimeoutMillis;

    private static final class BinderThreadMonitor implements Monitor {
        /* synthetic */ BinderThreadMonitor(WatchdogIA r1) {
            this();
        }

        private BinderThreadMonitor() {
        }

        @Override // com.android.server.Watchdog.Monitor
        public void monitor() {
            Binder.blockUntilThreadAvailable();
        }
    }

    public static class HandlerChecker implements Runnable {
        private Clock mClock;
        private boolean mCompleted;
        private Monitor mCurrentMonitor;
        private final Handler mHandler;
        private Object mLock;
        private final ArrayList<Monitor> mMonitorQueue;
        private final ArrayList<Monitor> mMonitors;
        private final String mName;
        private int mPauseCount;
        private long mPauseEndTimeMillis;
        private long mStartTimeMillis;
        private int mSysTid;
        private long mWaitMaxMillis;

        HandlerChecker(Handler handler, String name, Object lock, Clock clock) {
            this.mMonitors = new ArrayList();
            this.mMonitorQueue = new ArrayList();
            this.mHandler = handler;
            this.mName = name;
            this.mLock = lock;
            this.mCompleted = true;
            this.mClock = clock;
            this.mSysTid = this.mHandler.getLooper().getSysTid();
        }

        HandlerChecker(Handler handler, String name, Object lock) {
            this(handler, name, lock, SystemClock.uptimeClock());
        }

        void addMonitorLocked(Monitor monitor) {
            this.mMonitorQueue.add(monitor);
        }

        public void scheduleCheckLocked(long handlerCheckerTimeoutMillis) {
            this.mWaitMaxMillis = handlerCheckerTimeoutMillis;
            if (this.mCompleted == true) goto L5;
        L7:
            long nowMillis = this.mClock.millis();
            if (this.mPauseCount <= 0) goto L10;
        L13:
            boolean isPaused = true;
        L15:
            if (this.mMonitors.size() == 0) goto L17;
        L18:
            if (isPaused == false) goto L22;
        L19:
            this.mCompleted = true;
            return;
        L22:
            if (this.mCompleted == true) goto L24;
            return;
        L24:
            this.mCompleted = false;
            this.mCurrentMonitor = null;
            this.mStartTimeMillis = nowMillis;
            this.mPauseEndTimeMillis = 0;
            this.mHandler.postAtFrontOfQueue(this);
            return;
        L17:
            if (isHandlerPolling() == true) goto L19;
        L10:
            if (this.mPauseEndTimeMillis > nowMillis) goto L13;
            isPaused = false;
            goto L15
        L5:
            if (this.mMonitorQueue.isEmpty() == true) goto L7;
            this.mMonitors.addAll(this.mMonitorQueue);
            this.mMonitorQueue.clear();
            goto L7
        }

        boolean isHandlerPolling() {
            return this.mHandler.getLooper().getQueue().isPolling();
        }

        public int getCompletionStateLocked() {
            if (this.mCompleted == false) goto L6;
            return 0;
        L6:
            long latency = this.mClock.millis() - this.mStartTimeMillis;
            if (latency >= (this.mWaitMaxMillis / 4)) goto L11;
            return 1;
        L11:
            if (latency >= this.mWaitMaxMillis) goto L14;
            return 2;
        L14:
            return 3;
        }

        public Thread getThread() {
            return this.mHandler.getLooper().getThread();
        }

        public String getName() {
            return this.mName;
        }

        public int getSysTid() {
            return this.mSysTid;
        }

        String describeBlockedStateLocked() {
            if (this.mCurrentMonitor != null) goto L5;
            String prefix = "Blocked in handler";
        L6:
            long latencySeconds = (this.mClock.millis() - this.mStartTimeMillis) / 1000;
            return prefix + " on " + this.mName + " (" + getThread().getName() + ") for " + latencySeconds + "s";
        L5:
            prefix = "Blocked in monitor " + this.mCurrentMonitor.getClass().getName();
            goto L6
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.mMonitors.size();
            int i = 0;
        L3:
            if (i >= size) goto L12;
            Object r2 = this.mLock;
            monitor-enter(r2);
            this.mCurrentMonitor = this.mMonitors.get(i);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            this.mCurrentMonitor.monitor();
            i = i + 1;
        L9:
            th = move-exception;
            throw th;
        L12:
            Object r1 = this.mLock;
            monitor-enter(r1);
            this.mCompleted = true;     // Catch: Throwable -> L18
            this.mCurrentMonitor = null;     // Catch: Throwable -> L18
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        }

        public void pauseForLocked(int pauseMillis, String reason) {
            this.mPauseEndTimeMillis = this.mClock.millis() + ((long) pauseMillis);
            this.mCompleted = true;
            Slog.i(Watchdog.TAG, "Pausing of HandlerChecker: " + this.mName + " for reason: " + reason + ". Pause end time: " + this.mPauseEndTimeMillis);
        }

        public void pauseLocked(String reason) {
            this.mPauseCount++;
            this.mCompleted = true;
            Slog.i(Watchdog.TAG, "Pausing HandlerChecker: " + this.mName + " for reason: " + reason + ". Pause count: " + this.mPauseCount);
        }

        public void resumeLocked(String reason) {
            if (this.mPauseCount <= 0) goto L5;
            this.mPauseCount--;
            Slog.i(Watchdog.TAG, "Resuming HandlerChecker: " + this.mName + " for reason: " + reason + ". Pause count: " + this.mPauseCount);
            return;
        L5:
            Slog.wtf(Watchdog.TAG, "Already resumed HandlerChecker: " + this.mName);
        }

        public String toString() {
            return "CheckerHandler for " + this.mName;
        }
    }

    static final class HandlerCheckerAndTimeout {
        private final Optional<Long> mCustomTimeoutMillis;
        private final HandlerChecker mHandler;

        private HandlerCheckerAndTimeout(HandlerChecker checker, Optional<Long> timeoutMillis) {
            this.mHandler = checker;
            this.mCustomTimeoutMillis = timeoutMillis;
        }

        HandlerChecker checker() {
            return this.mHandler;
        }

        Optional<Long> customTimeoutMillis() {
            return this.mCustomTimeoutMillis;
        }

        static HandlerCheckerAndTimeout withDefaultTimeout(HandlerChecker checker) {
            return new HandlerCheckerAndTimeout(checker, Optional.empty());
        }

        static HandlerCheckerAndTimeout withCustomTimeout(HandlerChecker checker, long timeoutMillis) {
            return new HandlerCheckerAndTimeout(checker, Optional.of(Long.valueOf(timeoutMillis)));
        }
    }

    public interface Monitor {
        void monitor();
    }

    final class RebootRequestReceiver extends BroadcastReceiver {
        final /* synthetic */ Watchdog this$0;

        RebootRequestReceiver(Watchdog this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context c, Intent intent) {
            if (intent.getIntExtra("nowait", 0) == 0) goto L6;
            this.this$0.rebootSystem("Received ACTION_REBOOT broadcast");
            return;
        L6:
            Slog.w(Watchdog.TAG, "Unsupported ACTION_REBOOT broadcast: " + intent);
        }
    }

    private static class SettingsObserver extends ContentObserver {
        private final Context mContext;
        private final Uri mUri;
        private final Watchdog mWatchdog;

        SettingsObserver(Context context, Watchdog watchdog) {
            super(BackgroundThread.getHandler());
            this.mUri = Settings.Global.getUriFor("system_server_watchdog_timeout_ms");
            this.mContext = context;
            this.mWatchdog = watchdog;
            onChange();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (this.mUri.equals(uri) == false) goto L6;
            onChange();
            return;
        }

        public void onChange() {
            this.mWatchdog.updateWatchdogTimeout(Settings.Global.getLong(this.mContext.getContentResolver(), "system_server_watchdog_timeout_ms", 60000));     // Catch: RuntimeException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(Watchdog.TAG, "Exception while reading settings " + e.getMessage(), e);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$IHmOjeSmDoiNkZR0B-wv71mYNoM, reason: not valid java name */
    public static /* synthetic */ void m513$r8$lambda$IHmOjeSmDoiNkZR0Bwv71mYNoM(Watchdog r0) {
        r0.run();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivity, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m514$$Nest$fgetmActivity(Watchdog r0) {
        return r0.mActivity;
    }

    static {
        NATIVE_STACKS_OF_INTEREST = new String[]{"/system/bin/audioserver", "/system/bin/cameraserver", "/system/bin/drmserver", "/system/bin/keystore2", "/system/bin/mediadrmserver", "/system/bin/mediaserver", "/system/bin/mediaserver64", "/system/bin/netd", "/system/bin/sdcard", "/system/bin/servicemanager", "/system/bin/surfaceflinger", "/system/bin/vold", "media.extractor", "media.metrics", "media.codec", "media.swcodec", "media.transcoding", "com.android.bluetooth", "/apex/com.android.art/bin/artd", "/apex/com.android.os.statsd/bin/statsd"};
        HAL_INTERFACES_OF_INTEREST = Arrays.asList(new String[]{"android.hardware.audio@4.0::IDevicesFactory", "android.hardware.audio@5.0::IDevicesFactory", "android.hardware.audio@6.0::IDevicesFactory", "android.hardware.audio@7.0::IDevicesFactory", IBiometricsFace.kInterfaceName, IBiometricsFingerprint.kInterfaceName, "android.hardware.bluetooth@1.0::IBluetoothHci", "android.hardware.camera.provider@2.4::ICameraProvider", "android.hardware.gnss@1.0::IGnss", "android.hardware.graphics.allocator@2.0::IAllocator", "android.hardware.graphics.allocator@4.0::IAllocator", "android.hardware.graphics.composer@2.1::IComposer", IHealth.kInterfaceName, "android.hardware.light@2.0::ILight", "android.hardware.media.c2@1.0::IComponentStore", "android.hardware.media.omx@1.0::IOmx", "android.hardware.media.omx@1.0::IOmxStore", "android.hardware.neuralnetworks@1.0::IDevice", "android.hardware.power@1.0::IPower", "android.hardware.power.stats@1.0::IPowerStats", "android.hardware.sensors@1.0::ISensors", "android.hardware.sensors@2.0::ISensors", "android.hardware.sensors@2.1::ISensors", "android.hardware.vr@1.0::IVr", "android.system.suspend@1.0::ISystemSuspend"});
        AIDL_INTERFACE_PREFIXES_OF_INTEREST = new String[]{"android.hardware.audio.core.IModule/", "android.hardware.audio.core.IConfig/", "android.hardware.audio.effect.IFactory/", "android.hardware.biometrics.face.IFace/", "android.hardware.biometrics.fingerprint.IFingerprint/", "android.hardware.bluetooth.IBluetoothHci/", "android.hardware.camera.provider.ICameraProvider/", "android.hardware.drm.IDrmFactory/", "android.hardware.gnss.IGnss/", "android.hardware.graphics.allocator.IAllocator/", "android.hardware.graphics.composer3.IComposer/", "android.hardware.health.IHealth/", "android.hardware.input.processor.IInputProcessor/", "android.hardware.light.ILights/", "android.hardware.neuralnetworks.IDevice/", "android.hardware.power.IPower/", "android.hardware.power.stats.IPowerStats/", "android.hardware.sensors.ISensors/", "android.hardware.vibrator.IVibrator/", "android.hardware.vibrator.IVibratorManager/", "android.hardware.wifi.hostapd.IHostapd/", "android.hardware.wifi.IWifi/", "android.hardware.wifi.supplicant.ISupplicant/", "android.system.suspend.ISystemSuspend/"};
    }

    public static Watchdog getInstance() {
        if (sWatchdog != null) goto L6;
        sWatchdog = new Watchdog();
    L6:
        return sWatchdog;
    }

    private Watchdog() {
        this.mLock = new Object();
        this.mActivityControllerRestart = SystemProperties.getBoolean("persist.sys.control.restart", true);
        this.mHandlerCheckers = new ArrayList();
        this.mIsMonkey = false;
        this.mAllowRestart = true;
        this.mWatchdogTimeoutMillis = 60000;
        this.mTraceDateFormat = new SimpleDateFormat("dd_MM_HH_mm_ss.SSS");
        this.mInterestingJavaPids = new ArrayList();
        this.mThread = new Thread(new Watchdog$$ExternalSyntheticLambda0(this), "watchdog");
        ServiceThread t = new ServiceThread("watchdog.monitor", 0, true);
        t.start();
        this.mMonitorChecker = new HandlerChecker(new Handler(t.getLooper()), "monitor thread", this.mLock);
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(this.mMonitorChecker));
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(FgThread.getHandler(), "foreground thread", this.mLock)));
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(new Handler(Looper.getMainLooper()), "main thread", this.mLock)));
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(UiThread.getHandler(), "ui thread", this.mLock)));
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(IoThread.getHandler(), "i/o thread", this.mLock)));
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(DisplayThread.getHandler(), "display thread", this.mLock)));
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(AnimationThread.getHandler(), "animation thread", this.mLock)));
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(SurfaceAnimationThread.getHandler(), "surface animation thread", this.mLock)));
        addMonitor(new BinderThreadMonitor(null));
        this.mInterestingJavaPids.add(Integer.valueOf(Process.myPid()));
        this.mTraceErrorLogger = new TraceErrorLogger();
    }

    public void start() {
        this.mThread.start();
    }

    public void init(Context context, ActivityManagerService activity) {
        this.mActivity = activity;
        context.registerReceiver(new RebootRequestReceiver(this), new IntentFilter("android.intent.action.REBOOT"), "android.permission.REBOOT", null);
        Process.kickWatchdog(0);
    }

    public void registerSettingsObserver(Context context) {
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor("system_server_watchdog_timeout_ms"), false, new SettingsObserver(context, this), 0);
    }

    void updateWatchdogTimeout(long timeoutMillis) {
        if (Build.IS_USERDEBUG == false) goto L5;
    L7:
        this.mWatchdogTimeoutMillis = timeoutMillis;
        Slog.i(TAG, "Watchdog timeout updated to " + this.mWatchdogTimeoutMillis + " millis");
        return;
    L5:
        if (timeoutMillis > 20000) goto L7;
        timeoutMillis = 20001;
        goto L7
    }

    private static boolean isInterestingJavaProcess(String processName) {
        if (processName.equals(StorageManagerService.sMediaStoreAuthorityProcessName) == false) goto L5;
    L8:
        return true;
    L5:
        if (processName.equals("com.android.phone") == true) goto L8;
        return false;
    }

    public void processStarted(String processName, int pid) {
        if (isInterestingJavaProcess(processName) == false) goto L12;
        Slog.i(TAG, "Interesting Java process " + processName + " started. Pid " + pid);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInterestingJavaPids.add(Integer.valueOf(pid));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void processDied(String processName, int pid) {
        if (isInterestingJavaProcess(processName) == false) goto L12;
        Slog.i(TAG, "Interesting Java process " + processName + " died. Pid " + pid);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInterestingJavaPids.remove(Integer.valueOf(pid));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setActivityController(IActivityController controller) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mController = controller;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setActivityController(IActivityController controller, boolean isMonkey) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mController = controller;     // Catch: Throwable -> L7
        this.mIsMonkey = isMonkey;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAllowRestart(boolean allowRestart) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllowRestart = allowRestart;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMonitor(Monitor monitor) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMonitorChecker.addMonitorLocked(monitor);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addThread(Handler thread) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String name = thread.getLooper().getThread().getName();     // Catch: Throwable -> L7
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withDefaultTimeout(new HandlerChecker(thread, name, this.mLock)));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addThread(Handler thread, long timeoutMillis) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String name = thread.getLooper().getThread().getName();     // Catch: Throwable -> L7
        this.mHandlerCheckers.add(HandlerCheckerAndTimeout.withCustomTimeout(new HandlerChecker(thread, name, this.mLock), timeoutMillis));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void pauseWatchingCurrentThreadFor(int pauseMillis, String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<HandlerCheckerAndTimeout> r1 = this.mHandlerCheckers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        HandlerCheckerAndTimeout hc = r1.next();     // Catch: Throwable -> L10
        HandlerChecker checker = hc.checker();     // Catch: Throwable -> L10
        if (Thread.currentThread().equals(checker.getThread()) == false) goto L6;
        checker.pauseForLocked(pauseMillis, reason);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void pauseWatchingMonitorsFor(int pauseMillis, String reason) {
        this.mMonitorChecker.pauseForLocked(pauseMillis, reason);
    }

    public void pauseWatchingCurrentThread(String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<HandlerCheckerAndTimeout> r1 = this.mHandlerCheckers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        HandlerCheckerAndTimeout hc = r1.next();     // Catch: Throwable -> L10
        HandlerChecker checker = hc.checker();     // Catch: Throwable -> L10
        if (Thread.currentThread().equals(checker.getThread()) == false) goto L6;
        checker.pauseLocked(reason);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void resumeWatchingCurrentThread(String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<HandlerCheckerAndTimeout> r1 = this.mHandlerCheckers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        HandlerCheckerAndTimeout hc = r1.next();     // Catch: Throwable -> L10
        HandlerChecker checker = hc.checker();     // Catch: Throwable -> L10
        if (Thread.currentThread().equals(checker.getThread()) == false) goto L6;
        checker.resumeLocked(reason);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void rebootSystem(String reason) {
        Slog.i(TAG, "Rebooting system because: " + reason);
        IPowerManager pms = ServiceManager.getService("power");
        pms.reboot(false, reason, false);     // Catch: RemoteException -> L5
        return;
    }

    private int evaluateCheckerCompletionLocked() {
        int state = 0;
        int i = 0;
    L4:
        if (i >= this.mHandlerCheckers.size()) goto L7;
        HandlerChecker hc = this.mHandlerCheckers.get(i).checker();
        state = Math.max(state, hc.getCompletionStateLocked());
        i = i + 1;
        goto L4
    L7:
        return state;
    }

    private ArrayList<HandlerChecker> getCheckersWithStateLocked(int completionState) {
        ArrayList<HandlerChecker> checkers = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mHandlerCheckers.size()) goto L10;
        HandlerChecker hc = this.mHandlerCheckers.get(i).checker();
        if (hc.getCompletionStateLocked() != completionState) goto L8;
        checkers.add(hc);
    L8:
        i = i + 1;
        goto L4
    L10:
        return checkers;
    }

    private String describeCheckersLocked(List<HandlerChecker> checkers) {
        StringBuilder builder = new StringBuilder(128);
        int i = 0;
    L4:
        if (i >= checkers.size()) goto L10;
        if (builder.length() <= 0) goto L8;
        builder.append(", ");
    L8:
        builder.append(checkers.get(i).describeBlockedStateLocked());
        i = i + 1;
        goto L4
    L10:
        return builder.toString();
    }

    private static void addInterestingHidlPids(HashSet<Integer> pids) {
        IServiceManager serviceManager = IServiceManager.getService();     // Catch: RemoteException -> L13
        ArrayList<IServiceManager.InstanceDebugInfo> dump = serviceManager.debugDump();     // Catch: RemoteException -> L13
        Iterator<IServiceManager.InstanceDebugInfo> r2 = dump.iterator();     // Catch: RemoteException -> L13
    L4:
        if (r2.hasNext() == false) goto L29;
        IServiceManager.InstanceDebugInfo info = r2.next();     // Catch: RemoteException -> L13
        if (info.pid == (-1)) goto L4;
        if (HAL_INTERFACES_OF_INTEREST.contains(info.interfaceName) == false) goto L4;
        pids.add(Integer.valueOf(info.pid));     // Catch: RemoteException -> L13
        goto L4
    L29:
        return;
    L13:
        e = move-exception;
        Log.w(TAG, e);
    }

    private static void addInterestingAidlPids(HashSet<Integer> pids) {
        ServiceDebugInfo[] infos = ServiceManager.getServiceDebugInfo();
        if (infos != null) goto L5;
        return;
    L5:
        int r1 = infos.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L15;
        ServiceDebugInfo info = infos[r3];
        String[] r5 = AIDL_INTERFACE_PREFIXES_OF_INTEREST;
        int r6 = r5.length;
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L14;
        String prefix = r5[r7];
        if (info.name.startsWith(prefix) == false) goto L13;
        pids.add(Integer.valueOf(info.debugPid));
    L13:
        r7 = r7 + 1;
        goto L9
    L14:
        r3 = r3 + 1;
        goto L6
    }

    public static ArrayList<Integer> getInterestingNativePids() {
        HashSet<Integer> pids = new HashSet();
        addInterestingAidlPids(pids);
        addInterestingHidlPids(pids);
        int[] nativePids = Process.getPidsForCommands(NATIVE_STACKS_OF_INTEREST);
        if (nativePids == null) goto L9;
        int r2 = nativePids.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L9;
        int i = nativePids[r3];
        pids.add(Integer.valueOf(i));
        r3 = r3 + 1;
    L9:
        return new ArrayList(pids);
    }

    private void handlePidsType(ArrayList<Integer> srcPids, ArrayList<Integer> nativePids, ArrayList<Integer> javaPids) {
        if (javaPids != null) goto L5;
        nativePids.addAll(srcPids);
        return;
    L5:
        Iterator<Integer> r0 = srcPids.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        int pid = r0.next().intValue();
        ProcessRecord pr = this.mActivity.getProcessRecordForPid(pid);
        if (pr != null) goto L10;
        nativePids.add(Integer.valueOf(pid));
        goto L7
    L10:
        Slog.i(TAG, "dump java process is " + pr);
        javaPids.add(Integer.valueOf(pid));
        goto L7
    }

    public ArrayList<Integer> getInterestingNativePidsMore(int pid, boolean checkExtra) {
        return getInterestingNativePidsMore(pid, checkExtra, null);
    }

    public ArrayList<Integer> getInterestingNativePidsMore(int pid, boolean checkExtra, ArrayList<Integer> javaPids) {
        ArrayList<Integer> nativeBinderPids = getInterestingNativeBinderPids(pid);
        ArrayList<Integer> nativePids = new ArrayList();
        if (nativeBinderPids != null) goto L5;
    L7:
        if (checkExtra == false) goto L28;
        int[] extraPids = Process.getPidsForCommands(new String[]{"/system/bin/installd", "/system/bin/vold"});
        if (extraPids == null) goto L28;
        if (extraPids.length <= 0) goto L28;
        int r5 = extraPids.length;
        int r7 = 0;
    L14:
        if (r7 >= r5) goto L28;
        int curPid = extraPids[r7];
        if (nativeBinderPids == null) goto L27;
        if (nativeBinderPids.contains(Integer.valueOf(curPid)) == false) goto L27;
        int[] pids = Process.getChildPidForParent(curPid);
        Slog.i(TAG, "getInterestingNativePidsMore:" + curPid);
        if (pids == null) goto L27;
        if (pids.length <= 0) goto L27;
        int r10 = pids.length;
        int r12 = 0;
    L25:
        if (r12 >= r10) goto L27;
        int cur = pids[r12];
        Slog.i(TAG, "getInterestingNativePidsMore add " + cur);
        nativePids.add(Integer.valueOf(cur));
        r12 = r12 + 1;
    L27:
        r7 = r7 + 1;
    L28:
        int sfpid = Process.getPidForNameFast("surfaceflinger");
        nativePids.add(Integer.valueOf(sfpid));
        ArrayList<Integer> sfPids = getInterestingNativeBinderPids(sfpid);
        if (sfPids != null) goto L31;
    L33:
        HashSet<Integer> tmpSet = new HashSet(nativePids);
        nativePids.clear();
        nativePids.addAll(tmpSet);
        return nativePids;
    L31:
        if (sfPids.size() <= 0) goto L33;
        handlePidsType(sfPids, nativePids, javaPids);
        goto L33
    L5:
        if (nativeBinderPids.size() <= 0) goto L7;
        handlePidsType(nativeBinderPids, nativePids, javaPids);
        goto L7
    }

    public ArrayList<Integer> getInterestingNativeBinderPids(int pid) {
        int[] serverPids = Binder.getBinderServerPids(pid);
        ArrayList<Integer> pidList = new ArrayList();
        if (serverPids != null) goto L5;
    L10:
        ArrayList<Integer> binderPidList = new ArrayList();
        binderPidList.addAll(pidList);
        if (pidList.size() <= 0) goto L24;
        Iterator<Integer> r7 = pidList.iterator();
    L14:
        if (r7.hasNext() == false) goto L24;
        int curPid = r7.next().intValue();
        int[] curPids = Binder.getBinderServerPids(curPid);
        if (curPids == null) goto L14;
        if (curPids.length <= 0) goto L14;
        int r10 = curPids.length;
        int r11 = 0;
    L21:
        if (r11 >= r10) goto L14;
        int cur = curPids[r11];
        binderPidList.add(Integer.valueOf(cur));
        Slog.i(TAG, "" + curPid + " binder server pid is " + cur);
        r11 = r11 + 1;
    L24:
        return binderPidList;
    L5:
        if (serverPids.length <= 0) goto L10;
        int r6 = serverPids.length;
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L10;
        int curPid2 = serverPids[r8];
        Slog.i(TAG, "" + pid + " binder server pid is " + curPid2);
        pidList.add(Integer.valueOf(curPid2));
        r8 = r8 + 1;
        goto L8
    }

    private void run() {
        Watchdog r1 = this;
        boolean waitedHalf = false;
    L3:
        List<HandlerChecker> blockedCheckers = Collections.emptyList();
        String subject = "";
        boolean allowRestart = true;
        int debuggerWasConnected = 0;
        boolean doWaitedPreDump = false;
        Process.kickWatchdog(300);
        long watchdogTimeoutMillis = r1.mWatchdogTimeoutMillis;
        long checkIntervalMillis = watchdogTimeoutMillis / 4;
        Object r12 = r1.mLock;
        monitor-enter(r12);
        long timeout = checkIntervalMillis;
        int i = 0;
    L172:
    L21:
        th = th;
    L168:
        monitor-exit(r12);     // Catch: Throwable -> L150
        throw th;
    L150:
        th = th;
        goto L168
    L7:
        if (i >= r1.mHandlerCheckers.size()) goto L23;
        HandlerCheckerAndTimeout hc = r1.mHandlerCheckers.get(i);     // Catch: Throwable -> L21
        int i2 = i;
        boolean waitedHalf2 = waitedHalf;
        List<HandlerChecker> blockedCheckers2 = blockedCheckers;
        String subject2 = subject;
        hc.checker().scheduleCheckLocked(hc.customTimeoutMillis().orElse(Long.valueOf(((long) Build.HW_TIMEOUT_MULTIPLIER) * watchdogTimeoutMillis)).longValue());     // Catch: Throwable -> L15
        i = i2 + 1;     // Catch: Throwable -> L15
        waitedHalf = waitedHalf2;
        blockedCheckers = blockedCheckers2;
        subject = subject2;
    L15:
        th = th;
    L17:
        th = th;
    L19:
        th = th;
        goto L168
    L23:
        waitedHalf2 = waitedHalf;
        blockedCheckers2 = blockedCheckers;
        subject2 = subject;
        if (0 <= 0) goto L26;
        debuggerWasConnected = 0 - 1;     // Catch: Throwable -> L15
    L26:
        long start = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
    L28:
        if (timeout <= 0) goto L40;
        if (Debug.isDebuggerConnected() == false) goto L158;
        debuggerWasConnected = 2;
    L158:
        r1.mLock.wait(timeout);     // Catch: Throwable -> L15 InterruptedException -> L34
    L37:
        if (Debug.isDebuggerConnected() == false) goto L39;
        debuggerWasConnected = 2;
    L39:
        timeout = checkIntervalMillis - (SystemClock.uptimeMillis() - start);     // Catch: Throwable -> L15
    L34:
        e = move-exception;
        Log.wtf(TAG, e);     // Catch: Throwable -> L15
        goto L37
    L40:
        int waitState = r1.evaluateCheckerCompletionLocked();     // Catch: Throwable -> L15
        if (waitState == 0) goto L162;
        if (waitState == 1) goto L49;
        if (waitState != 2) goto L73;
        if (waitedHalf2 == true) goto L71;
        Slog.i(TAG, "WAITED_UNTIL_PRE_WATCHDOG");     // Catch: Throwable -> L15
        Process.kickWatchdog(WATCHDOG_MONITOR_TIMEOUT_WAIT_HALF);     // Catch: Throwable -> L45
        List<HandlerChecker> blockedCheckers3 = r1.getCheckersWithStateLocked(2);     // Catch: Throwable -> L45
        String subject3 = r1.describeCheckersLocked(blockedCheckers3);     // Catch: Throwable -> L68
        ArrayList<Integer> pids = new ArrayList(r1.mInterestingJavaPids);     // Catch: Throwable -> L64
        doWaitedPreDump = true;
        List<Integer> threadsList = new ArrayList();     // Catch: Throwable -> L64
        Iterator<HandlerChecker> r3 = blockedCheckers3.iterator();     // Catch: Throwable -> L64
    L62:
        if (r3.hasNext() == false) goto L66;
        threadsList.add(Integer.valueOf(r3.next().getSysTid()));     // Catch: Throwable -> L64
        pids = pids;
        goto L62
    L66:
        ArrayList<Integer> pids2 = pids;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().checkSystemThreadsBinderBlock(threadsList);     // Catch: Throwable -> L64
        waitedHalf2 = true;
        String subject4 = subject3;
        List<HandlerChecker> blockedCheckers4 = blockedCheckers3;
        ArrayList<Integer> pids3 = pids2;
    L156:
        monitor-exit(r12);     // Catch: Throwable -> L144
        if (SmartTraceUtils.isPerfettoDumpEnabled() == false) goto L93;
        SmartTraceUtils.traceStart();
        long dueTime = SystemClock.uptimeMillis() + 30000;
        long dueTime2 = dueTime;
    L94:
        r1.logWatchog(doWaitedPreDump, subject4, pids3);
        if (doWaitedPreDump == true) goto L96;
        Object r15 = r1.mLock;
        monitor-enter(r15);
        IActivityController controller = r1.mController;     // Catch: Throwable -> L138
        boolean isMonkey = r1.mIsMonkey;     // Catch: Throwable -> L138
        monitor-exit(r15);     // Catch: Throwable -> L138
        if (controller == null) goto L114;
        if (isMonkey == true) goto L114;
        Slog.i(TAG, "Reporting stuck state to activity controller");
        Binder.setDumpDisabled("Service dumps disabled due to hung system process.");     // Catch: RemoteException -> L110
        int res = controller.systemNotResponding(subject4);     // Catch: RemoteException -> L110
        if (res < 0) goto L114;
        if (r1.mActivityControllerRestart == true) goto L114;
        Slog.i(TAG, "Activity controller requested to coninue to wait");     // Catch: RemoteException -> L110
        waitedHalf = false;
    L114:
        if (Debug.isDebuggerConnected() == false) goto L117;
        debuggerWasConnected = 2;
    L117:
        if (debuggerWasConnected < 2) goto L119;
        Slog.w(TAG, "Debugger connected: Watchdog is *not* killing the system process");
    L137:
        waitedHalf = false;
        r1 = this;
        goto L3
    L119:
        if (debuggerWasConnected <= 0) goto L121;
        Slog.w(TAG, "Debugger was connected: Watchdog is *not* killing the system process");
        goto L137
    L121:
        if (allowRestart == true) goto L123;
        Slog.w(TAG, "Restart not allowed: Watchdog is *not* killing the system process");
        goto L137
    L123:
        Slog.w(TAG, "*** WATCHDOG KILLING SYSTEM PROCESS: " + subject4);
        WatchdogDiagnostics.diagnoseCheckers(blockedCheckers4);
        Slog.w(TAG, "*** GOODBYE!");
        if (SmartTraceUtils.isPerfettoDumpEnabled() == false) goto L130;
        if (dueTime2 <= SystemClock.uptimeMillis()) goto L130;
        long timeDelta = dueTime2 - SystemClock.uptimeMillis();
        Slog.i(TAG, "Sleep " + timeDelta + " ms to make sure perfetto log to be dumped completely");
        SystemClock.sleep(timeDelta);
    L130:
        if (Build.IS_USER == false) goto L132;
    L136:
        Process.killProcess(Process.myPid());
        System.exit(10);
        goto L137
    L132:
        if (isCrashLoopFound() == false) goto L136;
        if (WatchdogProperties.should_ignore_fatal_count().orElse(false).booleanValue() == true) goto L136;
        breakCrashLoop();
    L138:
        th = th;
    L152:
        throw th;
    L142:
        th = th;
        goto L152
    L96:
        waitedHalf = waitedHalf2;
        goto L3
    L93:
        dueTime2 = 0;
    L144:
        th = th;
    L64:
        th = th;
    L68:
        th = th;
        goto L168
    L71:
        monitor-exit(r12);     // Catch: Throwable -> L15
    L72:
        waitedHalf = waitedHalf2;
        goto L3
    L73:
        Process.kickWatchdog(420);     // Catch: Throwable -> L15
        List<HandlerChecker> blockedCheckers5 = r1.getCheckersWithStateLocked(3);     // Catch: Throwable -> L15
        subject4 = r1.describeCheckersLocked(blockedCheckers5);     // Catch: Throwable -> L146
        List<Integer> threadsList2 = new ArrayList();     // Catch: Throwable -> L85
        List<String> threadNameList = new ArrayList();     // Catch: Throwable -> L85
        Iterator<HandlerChecker> r16 = blockedCheckers5.iterator();     // Catch: Throwable -> L85
    L79:
        if (r16.hasNext() == false) goto L87;
        HandlerChecker check = r16.next();     // Catch: Throwable -> L85
        List<HandlerChecker> blockedCheckers6 = blockedCheckers5;
        threadsList2.add(Integer.valueOf(check.getSysTid()));     // Catch: Throwable -> L83
        threadNameList.add(check.getThread().getName());     // Catch: Throwable -> L83
        blockedCheckers5 = blockedCheckers6;
    L83:
        th = th;
        goto L168
    L87:
        List<HandlerChecker> blockedCheckers7 = blockedCheckers5;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifySWT(threadsList2, threadNameList, subject4);     // Catch: Throwable -> L83
        allowRestart = r1.mAllowRestart;     // Catch: Throwable -> L83
        pids3 = new ArrayList(r1.mInterestingJavaPids);     // Catch: Throwable -> L83
        blockedCheckers4 = blockedCheckers7;
    L85:
        th = th;
    L146:
        th = th;
        goto L168
    L49:
        monitor-exit(r12);     // Catch: Throwable -> L15
        goto L72
    L162:
        monitor-exit(r12);     // Catch: Throwable -> L45
        waitedHalf = false;
    L45:
        th = th;
        goto L168
    }

    private void logWatchog(boolean preWatchdog, String subject, ArrayList<Integer> pids) {
        ArrayList<Integer> javaPids = new ArrayList();
        ArrayList<Integer> nativePids = getInterestingNativePidsMore(Process.myPid(), true, javaPids);
        javaPids.addAll(pids);
        HashSet<Integer> tmpSet = new HashSet(javaPids);
        pids.clear();
        pids.addAll(tmpSet);
        String criticalEvents = CriticalEventLog.getInstance().logLinesForSystemServerTraceFile();
        final UUID errorId = this.mTraceErrorLogger.generateErrorId();
        if (this.mTraceErrorLogger.isAddErrorIdEnabled() == false) goto L5;
        this.mTraceErrorLogger.addProcessInfoAndErrorIdToTrace("system_server", Process.myPid(), errorId);
        this.mTraceErrorLogger.addSubjectToTrace(subject, errorId);
    L5:
        if (preWatchdog == false) goto L10;
        CriticalEventLog.getInstance().logHalfWatchdog(subject);
        File initialStack = StackTracesDumpHelper.dumpStackTraces(pids, null, null, CompletableFuture.completedFuture(nativePids), null, subject, criticalEvents, null, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), null);
        if (initialStack == null) goto L9;
        SmartTraceUtils.dumpStackTraces(Process.myPid(), pids, nativePids, initialStack);
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.SYSTEM_SERVER_PRE_WATCHDOG_OCCURRED);
        String dropboxTag = "pre_watchdog";
        File initialStack2 = initialStack;
    L11:
        LinkedHashMap headersMap = new LinkedHashMap(Collections.singletonMap("Watchdog-Type", dropboxTag));
        long anrTime = SystemClock.uptimeMillis();
        final StringBuilder report = new StringBuilder();
        report.append(ResourcePressureUtil.currentPsiState());
        ProcessCpuTracker processCpuTracker = new ProcessCpuTracker(false);
        StringWriter tracesFileException = new StringWriter();
        if (preWatchdog == true) goto L14;
        long curLogType = SysMonitorSvcBridge.getFactory().getAnrMonitor().getDumpObjectCountsFlag();
        SysMonitorFwBridge.getFactory().getStabUtil().notifyWatchdog(curLogType);
    L14:
        final String dropboxTag2 = dropboxTag;
        final File finalStack = StackTracesDumpHelper.dumpStackTraces(pids, processCpuTracker, new SparseBooleanArray(), CompletableFuture.completedFuture(getInterestingNativePids()), tracesFileException, subject, criticalEvents, headersMap, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), null);
        if (finalStack == null) goto L17;
        SmartTraceUtils.dumpStackTraces(Process.myPid(), pids, nativePids, finalStack);
    L17:
        boolean r0 = Build.IS_DEBUGGABLE;
        SystemClock.sleep(5000);
        processCpuTracker.update();
        report.append(processCpuTracker.printCurrentState(anrTime, 10));
        report.append(tracesFileException.getBuffer());
        if (preWatchdog == true) goto L20;
        doSysRq('w');
        doSysRq('m');
        doSysRq('l');
    L20:
        final String r2 = "watchdogWriteToDropbox";
        Thread dropboxThread = new AnonymousClass1(this, r2, dropboxTag2, report, finalStack, errorId);
        dropboxThread.start();
        dropboxThread.join(BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);     // Catch: InterruptedException -> L23
    L25:
        boolean crashOnWatchdog = SystemProperties.getBoolean("persist.sys.crashOnWatchdog", false);
        if (crashOnWatchdog == false) goto L31;
        Slog.e(TAG, "Triggering SysRq for system_server watchdog,s");
        doSysRq('w');
        doSysRq('l');
        SystemClock.sleep(BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);
        doSysRq('c');
        return;
    L31:
        return;
    L10:
        CriticalEventLog.getInstance().logWatchdog(subject, errorId);
        EventLog.writeEvent(EventLogTags.WATCHDOG, subject);
        FrameworkStatsLog.write(185, subject);
        dropboxTag = "watchdog";
        initialStack2 = null;
        goto L11
    }

    private void doSysRq(char c) {
        FileWriter sysrq_trigger = new FileWriter("/proc/sysrq-trigger");     // Catch: IOException -> L4
        sysrq_trigger.write(c);     // Catch: IOException -> L4
        sysrq_trigger.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to write to /proc/sysrq-trigger", e);
    }

    private void resetTimeoutHistory() {
        writeTimeoutHistory(new ArrayList());
    }

    private void writeTimeoutHistory(Iterable<String> crashHistory) {
        String data = String.join(",", crashHistory);
        FileWriter writer = new FileWriter(TIMEOUT_HISTORY_FILE);     // Catch: IOException -> L7
        writer.write(SystemProperties.get("ro.boottime.zygote"));     // Catch: Throwable -> L9
        writer.write(":");     // Catch: Throwable -> L9
        writer.write(data);     // Catch: Throwable -> L9
        writer.close();     // Catch: IOException -> L7
        return;
    L9:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: IOException -> L7
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to write file /data/system/watchdog-timeout-history.txt", e);
    }

    private String[] readTimeoutHistory() {
        String[] emptyStringArray = new String[0];
        BufferedReader reader = new BufferedReader(new FileReader(TIMEOUT_HISTORY_FILE));     // Catch: IOException -> L8 FileNotFoundException -> L10
        String line = reader.readLine();     // Catch: Throwable -> L16
        if (line != null) goto L12;
        reader.close();     // Catch: IOException -> L8 FileNotFoundException -> L10
        return emptyStringArray;
    L12:
        String[] data = line.trim().split(":");     // Catch: Throwable -> L16
        String history = "";
        if (data.length < 1) goto L18;
        String boottime = data[0];     // Catch: Throwable -> L16
    L20:
        if (data.length < 2) goto L23;
        history = data[1];     // Catch: Throwable -> L16
    L23:
        if (SystemProperties.get("ro.boottime.zygote").equals(boottime) == true) goto L25;
    L29:
        reader.close();     // Catch: IOException -> L8 FileNotFoundException -> L10
        return emptyStringArray;
    L25:
        if (history.isEmpty() == true) goto L29;
        String[] r5 = history.split(",");     // Catch: Throwable -> L16
        reader.close();     // Catch: IOException -> L8 FileNotFoundException -> L10
        return r5;
        goto L39
    L18:
        boottime = "";
    L16:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: IOException -> L8 FileNotFoundException -> L10
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L8 FileNotFoundException -> L10
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to read file /data/system/watchdog-timeout-history.txt", e);
        return emptyStringArray;
    L39:
        return emptyStringArray;
    }

    private boolean hasActiveUsbConnection() {
        String state = FileUtils.readTextFile(new File("/sys/class/android_usb/android0/state"), 128, null).trim();     // Catch: IOException -> L7
        if ("CONFIGURED".equals(state) == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to determine if device was on USB", e);
        return false;
    }

    private boolean isCrashLoopFound() {
        int fatalCount = WatchdogProperties.fatal_count().orElse(0).intValue();
        long fatalWindowMs = TimeUnit.SECONDS.toMillis(WatchdogProperties.fatal_window_seconds().orElse(0).intValue());
        if (fatalCount == 0) goto L21;
        if (fatalWindowMs == 0) goto L21;
        long nowMs = SystemClock.elapsedRealtime();
        String[] rawCrashHistory = readTimeoutHistory();
        ArrayList<String> crashHistory = new ArrayList(Arrays.asList((String[]) Arrays.copyOfRange(rawCrashHistory, Math.max(0, (rawCrashHistory.length - fatalCount) - 1), rawCrashHistory.length)));
        crashHistory.add(String.valueOf(nowMs));
        writeTimeoutHistory(crashHistory);
        if (hasActiveUsbConnection() == false) goto L24;
        return false;
    L24:
        long firstCrashMs = Long.parseLong(crashHistory.get(0));     // Catch: NumberFormatException -> L17
        if (crashHistory.size() >= fatalCount) goto L14;
        return false;
    L14:
        if ((nowMs - firstCrashMs) < fatalWindowMs) goto L16;
        return false;
    L16:
        return true;
    L17:
        t = move-exception;
        Slog.w(TAG, "Failed to parseLong " + crashHistory.get(0), t);
        resetTimeoutHistory();
        return false;
    L21:
        if (fatalCount == fatalWindowMs) goto L23;
        Slog.w(TAG, String.format("sysprops '%s' and '%s' should be set or unset together", new Object[]{PROP_FATAL_LOOP_COUNT, PROP_FATAL_LOOP_WINDOWS_SECS}));
    L23:
        return false;
    }

    private void breakCrashLoop() {
        FileWriter kmsg = new FileWriter("/dev/kmsg_debug", true);     // Catch: IOException -> L6
        kmsg.append("Fatal reset to escape the system_server crashing loop\n");     // Catch: Throwable -> L8
        kmsg.close();     // Catch: IOException -> L6
    L15:
        doSysRq('c');
        return;
    L8:
        th = move-exception;
        kmsg.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: IOException -> L6
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        Slog.w(TAG, "Failed to append to kmsg", e);
        goto L15
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter pw, String[] args) {
        pw.print("WatchdogTimeoutMillis=");
        pw.println(this.mWatchdogTimeoutMillis);
    }

    private void appendFile(File writeTo, File copyFrom) {
        BufferedReader in = new BufferedReader(new FileReader(copyFrom));     // Catch: IOException -> L6
        FileWriter out = new FileWriter(writeTo, true);     // Catch: IOException -> L6
    L3:
        String line = in.readLine();     // Catch: IOException -> L6
        if (line == null) goto L8;
        out.write(line);     // Catch: IOException -> L6
        out.write(10);     // Catch: IOException -> L6
        goto L3
    L8:
        in.close();     // Catch: IOException -> L6
        out.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Exception while writing watchdog traces to new file!");
        e.printStackTrace();
    }

    private void binderStateRead() {
        boolean binderfsNodePresent = false;
        BufferedReader in = null;
        Slog.i(TAG, "Collecting Binder Transaction Status Information");     // Catch: IOException -> L13
        in = new BufferedReader(new FileReader("/dev/binderfs/binder_logs/state"));     // Catch: IOException -> L6
        Slog.i(TAG, "Collecting Binder state file from binderfs");     // Catch: IOException -> L6
        binderfsNodePresent = true;
    L8:
        if (binderfsNodePresent == false) goto L27;
    L16:
        if (in != null) goto L19;
        Slog.w(TAG, "Failed to open binder state file, skipping collection.");     // Catch: IOException -> L13
        return;
    L19:
        FileWriter out = new FileWriter("/data/anr/BinderTraces_pid" + String.valueOf(Process.myPid()) + ".txt");     // Catch: IOException -> L13
    L20:
        String line = in.readLine();     // Catch: IOException -> L13
        if (line == null) goto L23;
        out.write(line);     // Catch: IOException -> L13
        out.write(10);     // Catch: IOException -> L13
        goto L20
    L23:
        in.close();     // Catch: IOException -> L13
        out.close();     // Catch: IOException -> L13
        return;
    L27:
        in = new BufferedReader(new FileReader("/sys/kernel/debug/binder/state"));     // Catch: IOException -> L11
        Slog.i(TAG, "Collecting Binder state file from debugfs");     // Catch: IOException -> L11
    L11:
        e = move-exception;
        Slog.i(TAG, "Debugfs node not found", e);     // Catch: IOException -> L13
        goto L16
    L6:
        e = move-exception;
        Slog.i(TAG, "Binderfs node not found, Trying to collect it from debugfs", e);     // Catch: IOException -> L13
    L13:
        e = move-exception;
        Slog.w(TAG, "Failed to collect state file", e);
    }
}

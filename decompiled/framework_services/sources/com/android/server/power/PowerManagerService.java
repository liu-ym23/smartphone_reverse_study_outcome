package com.android.server.power;

import android.R;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.SynchronousUserSwitchObserver;
import android.app.compat.CompatChanges;
import android.content.AttributionSource;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.SensorManager;
import android.hardware.SystemSensorManager;
import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateManager;
import android.hardware.display.AmbientDisplayConfiguration;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.BatteryManagerInternal;
import android.os.BatterySaverPolicyConfig;
import android.os.Binder;
import android.os.DisturbModeUtils;
import android.os.ExtPowerManagerInternal;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.IPowerManager;
import android.os.IPowerManagerExt;
import android.os.IPowerManagerSmtEx;
import android.os.IScreenTimeoutPolicyListener;
import android.os.IWakeLockCallback;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelDuration;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.provider.Settings;
import android.service.dreams.DreamManagerInternal;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.KeyValueListParser;
import android.util.LongArray;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import android.view.KeyEvent;
import com.android.internal.app.IBatteryStats;
import com.android.internal.display.BrightnessSynchronizer;
import com.android.internal.foldables.FoldGracePeriodProvider;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.LatencyTracker;
import com.android.internal.util.Preconditions;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.LockGuard;
import com.android.server.PackageWatchdog;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.UiThread;
import com.android.server.Watchdog;
import com.android.server.am.BatteryStatsService;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.common.IGameScreenSaver;
import com.android.server.dispatcher.SystemWakefulnessEventDispatcher;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.feature.DeviceConfigParameterProvider;
import com.android.server.job.controllers.JobStatus;
import com.android.server.lights.LightsManager;
import com.android.server.lights.LogicalLight;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.power.batterysaver.BatterySaverController;
import com.android.server.power.batterysaver.BatterySaverPolicy;
import com.android.server.power.batterysaver.BatterySaverStateMachine;
import com.android.server.power.batterysaver.BatterySavingStats;
import com.android.server.power.feature.PowerManagerFlags;
import com.android.server.wm.WindowManagerInternalSmtEx;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class PowerManagerService extends SystemService implements Watchdog.Monitor {
    private static final SimpleDateFormat DATE_FORMAT = null;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_SPEW = false;
    private static final IntArray DEFAULT_DISPLAY_GROUP_IDS = null;
    private static final int DEFAULT_DOUBLE_TAP_TO_WAKE = 0;
    static final int DEFAULT_SCREEN_OFF_TIMEOUT = 15000;
    private static final int DEFAULT_SLEEP_TIMEOUT = -1;
    private static final int DIRTY_ACTUAL_DISPLAY_POWER_STATE_UPDATED = 8;
    private static final int DIRTY_ATTENTIVE = 16384;
    private static final int DIRTY_BATTERY_STATE = 256;
    private static final int DIRTY_BOOT_COMPLETED = 16;
    private static final int DIRTY_DISPLAY_GROUP_WAKEFULNESS = 65536;
    private static final int DIRTY_DOCK_STATE = 1024;
    private static final int DIRTY_IS_POWERED = 64;
    private static final int DIRTY_POSTURED_STATE = 131072;
    private static final int DIRTY_PROXIMITY_POSITIVE = 512;
    private static final int DIRTY_QUIESCENT = 4096;
    private static final int DIRTY_SCREEN_BRIGHTNESS_BOOST = 2048;
    private static final int DIRTY_SETTINGS = 32;
    private static final int DIRTY_STAY_ON = 128;
    private static final int DIRTY_USER_ACTIVITY = 4;
    private static final int DIRTY_WAKEFULNESS = 2;
    private static final int DIRTY_WAKE_LOCKS = 1;
    private static final long ENHANCED_DISCHARGE_PREDICTION_BROADCAST_MIN_DELAY_MS = 60000;
    private static final long ENHANCED_DISCHARGE_PREDICTION_TIMEOUT_MS = 1800000;
    private static final int HALT_MODE_REBOOT = 1;
    private static final int HALT_MODE_REBOOT_SAFE_MODE = 2;
    private static final int HALT_MODE_SHUTDOWN = 0;
    private static final String HOLDING_DISPLAY_SUSPEND_BLOCKER = "holding display";
    static final long MIN_LONG_WAKE_CHECK_INTERVAL = 60000;
    private static final int MSG_ATTENTIVE_TIMEOUT = 5;
    private static final int MSG_CHECK_FOR_LONG_WAKELOCKS = 4;
    private static final int MSG_RELEASE_ALL_OVERRIDE_WAKE_LOCKS = 6;
    private static final int MSG_SANDMAN = 2;
    private static final int MSG_SCREEN_BRIGHTNESS_BOOST_TIMEOUT = 3;
    private static final int MSG_USER_ACTIVITY_TIMEOUT = 1;
    private static final String REASON_BATTERY_THERMAL_STATE = "shutdown,thermal,battery";
    private static final String REASON_LOW_BATTERY = "shutdown,battery";
    private static final String REASON_REBOOT = "reboot";
    private static final String REASON_SHUTDOWN = "shutdown";
    private static final String REASON_THERMAL_SHUTDOWN = "shutdown,thermal";
    private static final String REASON_USERREQUESTED = "shutdown,userrequested";
    public static final long REQUIRE_TURN_SCREEN_ON_PERMISSION = 216114297;
    private static final int SCREEN_BRIGHTNESS_BOOST_TIMEOUT = 5000;
    private static final int SCREEN_ON_LATENCY_WARNING_MS = 200;
    private static final int SLOW_WL_WARN_MS = 1000;
    private static final String SYSTEM_PROPERTY_QUIESCENT = "ro.boot.quiescent";
    private static final String SYSTEM_PROPERTY_REBOOT_REASON = "sys.boot.reason";
    private static final String SYSTEM_PROPERTY_RETAIL_DEMO_ENABLED = "sys.retaildemo.enabled";
    private static final String TAG = "PowerManagerService";
    static final String TRACE_SCREEN_ON = "Screen turning on";
    static final int USER_ACTIVITY_SCREEN_BRIGHT = 1;
    static final int USER_ACTIVITY_SCREEN_DIM = 2;
    static final int USER_ACTIVITY_SCREEN_DREAM = 4;
    static final int WAKE_LOCK_BUTTON_BRIGHT = 8;
    static final int WAKE_LOCK_CPU = 1;
    static final int WAKE_LOCK_DOZE = 64;
    static final int WAKE_LOCK_DRAW = 128;
    static final int WAKE_LOCK_PROXIMITY_SCREEN_OFF = 16;
    static final int WAKE_LOCK_SCREEN_BRIGHT = 2;
    static final int WAKE_LOCK_SCREEN_DIM = 4;
    static final int WAKE_LOCK_SCREEN_TIMEOUT_OVERRIDE = 256;
    static final int WAKE_LOCK_STAY_AWAKE = 32;
    private static boolean sQuiescent;
    private boolean mAlwaysOnEnabled;
    private final AmbientDisplayConfiguration mAmbientDisplayConfiguration;
    private final AmbientDisplaySuppressionController mAmbientDisplaySuppressionController;
    private final AmbientDisplaySuppressionController.AmbientDisplaySuppressionChangedCallback mAmbientSuppressionChangedCallback;
    private final AttentionDetector mAttentionDetector;
    private LogicalLight mAttentionLight;
    private int mAttentiveTimeoutConfig;
    private long mAttentiveTimeoutSetting;
    private long mAttentiveWarningDurationConfig;
    private int mBatteryLevel;
    private boolean mBatteryLevelLow;
    private BatteryManagerInternal mBatteryManagerInternal;
    private final BatterySaverStateMachine mBatterySaverStateMachine;
    private final boolean mBatterySaverSupported;
    private IBatteryStats mBatteryStats;
    private final BinderService mBinderService;
    private boolean mBootCompleted;
    private final SuspendBlocker mBootingSuspendBlocker;
    private boolean mBrightWhenDozingConfig;
    private final Clock mClock;
    final Constants mConstants;
    protected final Context mContext;
    private boolean mDecoupleHalAutoSuspendModeFromDisplayConfig;
    private boolean mDecoupleHalInteractiveModeFromDisplayConfig;
    private final DeviceConfigParameterProvider mDeviceConfigProvider;
    protected boolean mDeviceIdleMode;
    int[] mDeviceIdleTempWhitelist;
    int[] mDeviceIdleWhitelist;
    private boolean mDevicePostured;
    protected int mDirty;
    private boolean mDisableScreenWakeLocksWhileCached;
    private DisplayManager mDisplayManager;
    protected DisplayManagerInternal mDisplayManagerInternal;
    private final DisplayManagerInternal.DisplayPowerCallbacks mDisplayPowerCallbacks;
    private final SuspendBlocker mDisplaySuspendBlocker;
    private int mDockState;
    private boolean mDoubleTapWakeEnabled;
    private boolean mDozeAfterScreenOff;
    private int mDozeScreenBrightnessOverrideFromDreamManager;
    private float mDozeScreenBrightnessOverrideFromDreamManagerFloat;
    private int mDozeScreenStateOverrideFromDreamManager;
    private int mDozeScreenStateOverrideReasonFromDreamManager;
    private boolean mDozeStartInProgress;
    private boolean mDrawWakeLockOverrideFromSidekick;
    private DreamManagerInternal mDreamManager;
    private boolean mDreamsActivateOnDockSetting;
    private boolean mDreamsActivateOnSleepSetting;
    private boolean mDreamsActivateWhilePosturedSetting;
    private boolean mDreamsActivatedOnDockByDefaultConfig;
    private boolean mDreamsActivatedOnSleepByDefaultConfig;
    private boolean mDreamsActivatedWhilePosturedByDefaultConfig;
    private int mDreamsBatteryLevelDrain;
    private int mDreamsBatteryLevelDrainCutoffConfig;
    private int mDreamsBatteryLevelMinimumWhenNotPoweredConfig;
    private int mDreamsBatteryLevelMinimumWhenPoweredConfig;
    private boolean mDreamsDisabledByAmbientModeSuppressionConfig;
    private boolean mDreamsEnabledByDefaultConfig;
    private boolean mDreamsEnabledOnBatteryConfig;
    private boolean mDreamsEnabledSetting;
    private boolean mDreamsSupportedConfig;
    private boolean mEnhancedDischargePredictionIsPersonalized;
    private long mEnhancedDischargeTimeElapsed;
    private final Object mEnhancedDischargeTimeLock;
    private IExtPowerManagerService mExt;
    private final FaceDownDetector mFaceDownDetector;
    private final PowerManagerFlags mFeatureFlags;
    private final FoldGracePeriodProvider mFoldGracePeriodProvider;
    private boolean mForceSuspendActive;
    private int mForegroundProfile;
    private boolean mHalAutoSuspendModeEnabled;
    private boolean mHalInteractiveModeEnabled;
    final Handler mHandler;
    private final ServiceThread mHandlerThread;
    private boolean mHoldingBootingSuspendBlocker;
    private boolean mHoldingDisplaySuspendBlocker;
    private boolean mHoldingWakeLockSuspendBlocker;
    private final InattentiveSleepWarningController mInattentiveSleepWarningOverlayController;
    private final Injector mInjector;
    private boolean mInterceptedPowerKeyForProximity;
    boolean mIsFaceDown;
    private boolean mIsPowered;
    private boolean mKeepDreamingWhenUnplugging;
    private long mLastEnhancedDischargeTimeUpdatedElapsed;
    private long mLastFlipTime;
    private int mLastGlobalSleepReason;
    long mLastGlobalSleepTime;
    private long mLastGlobalSleepTimeRealtime;
    private int mLastGlobalWakeReason;
    private long mLastGlobalWakeTime;
    private long mLastGlobalWakeTimeRealtime;
    private long mLastInteractivePowerHintTime;
    private long mLastScreenBrightnessBoostTime;
    private long mLastSlowWlLog;
    private long mLastWarningAboutUserActivityPermission;
    private boolean mLightDeviceIdleMode;
    private LightsManager mLightsManager;
    private final LocalService mLocalService;
    final Object mLock;
    private boolean mLowPowerStandbyActive;
    int[] mLowPowerStandbyAllowlist;
    private final LowPowerStandbyController mLowPowerStandbyController;
    private long mMaximumScreenDimDurationConfig;
    private float mMaximumScreenDimRatioConfig;
    private long mMaximumScreenOffTimeoutFromDeviceAdmin;
    private long mMinimumScreenOffTimeoutConfig;
    private final NativeWrapper mNativeWrapper;
    private Notifier mNotifier;
    private long mNotifyLongDispatched;
    private long mNotifyLongNextCheck;
    private long mNotifyLongScheduled;
    private long mOverriddenTimeout;
    private final PermissionCheckerWrapper mPermissionCheckerWrapper;
    private int mPlugType;
    private WindowManagerPolicy mPolicy;
    private final PowerGroupWakefulnessChangeListener mPowerGroupWakefulnessChangeListener;
    protected final SparseArray<PowerGroup> mPowerGroups;
    private final PowerPropertiesWrapper mPowerPropertiesWrapper;
    private final SparseArray<ProfilePowerState> mProfilePowerState;
    private boolean mProximityPositive;
    private boolean mRequestWaitForNegativeProximity;
    private boolean mSandmanScheduled;
    private boolean mScreenBrightnessBoostInProgress;
    public final float mScreenBrightnessDefault;
    public final float mScreenBrightnessDim;
    public final float mScreenBrightnessMaximum;
    public final float mScreenBrightnessMinimum;
    protected int mScreenBrightnessModeSetting;
    private boolean mScreenBrightnessModeSettingChanged;
    private long mScreenOffTimeoutSetting;
    private ScreenTimeoutOverridePolicy mScreenTimeoutOverridePolicy;
    private final ScreenUndimDetector mScreenUndimDetector;
    private SettingsObserver mSettingsObserver;
    private long mSleepTimeoutSetting;
    volatile boolean mSleepingForPsensor;
    private final PowerManagerServiceSmtEx mSmtEx;
    private boolean mStayOn;
    private int mStayOnAlltimeSetting;
    private int mStayOnWhilePluggedInSetting;
    private boolean mSupportsDoubleTapWakeConfig;
    private final ArrayList<SuspendBlocker> mSuspendBlockers;
    private boolean mSuspendWhenScreenOffDueToProximityConfig;
    private final SystemPropertiesWrapper mSystemProperties;
    private boolean mSystemReady;
    private boolean mTheaterModeEnabled;
    protected final SparseArray<UidState> mUidState;
    private boolean mUidsChanged;
    private boolean mUidsChanging;
    private boolean mUpdatePowerStateInProgress;
    private final boolean mUseAutoSuspend;
    private boolean mUseNormalBrightnessForDoze;
    private long mUserActivityTimeoutOverrideFromWindowManager;
    private int mUserId;
    private boolean mUserInactiveOverrideFromWindowManager;
    private int mWakeLockSummary;
    private final SuspendBlocker mWakeLockSuspendBlocker;
    private final ArrayList<WakeLock> mWakeLocks;
    private boolean mWakeUpWhenPluggedOrUnpluggedConfig;
    private boolean mWakeUpWhenPluggedOrUnpluggedInTheaterModeConfig;
    private boolean mWakefulnessChanging;
    protected int mWakefulnessRaw;
    private WirelessChargerDetector mWirelessChargerDetector;
    private IZswPowerManagerService mZswExt;

    final class BatteryReceiver extends BroadcastReceiver {
        final /* synthetic */ PowerManagerService this$0;

        BatteryReceiver(PowerManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            PowerManagerService.m7489$$Nest$mhandleBatteryStateChangedLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class BinderService extends IPowerManager.Stub {
        private final PowerManagerShellCommand mShellCommand;
        final /* synthetic */ PowerManagerService this$0;

        BinderService(PowerManagerService this$0, Context context) {
            this.this$0 = this$0;
            this.mShellCommand = new PowerManagerShellCommand(context, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            this.mShellCommand.exec(this, in, out, err, args, callback, resultReceiver);
        }

        public void acquireWakeLockWithUid(IBinder lock, int flags, String tag, String packageName, int uid, int displayId, IWakeLockCallback callback) {
            if (uid >= 0) goto L4;
            uid = Binder.getCallingUid();
        L4:
            acquireWakeLock(lock, flags, tag, packageName, new WorkSource(uid), null, displayId, callback);
        }

        public void setPowerBoost(int boost, int durationMs) {
            if (PowerManagerService.m7462$$Nest$fgetmSystemReady(this.this$0) == true) goto L5;
            return;
        L5:
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            PowerManagerService.m7513$$Nest$msetPowerBoostInternal(this.this$0, boost, durationMs);
        }

        public void setPowerMode(int mode, boolean enabled) {
            if (PowerManagerService.m7462$$Nest$fgetmSystemReady(this.this$0) == true) goto L5;
            return;
        L5:
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            this.this$0.setPowerModeInternal(mode, enabled);
        }

        public boolean setPowerModeChecked(int mode, boolean enabled) {
            if (PowerManagerService.m7462$$Nest$fgetmSystemReady(this.this$0) == true) goto L6;
            return false;
        L6:
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            return this.this$0.setPowerModeInternal(mode, enabled);
        }

        public void acquireWakeLock(IBinder lock, int flags, String tag, String packageName, WorkSource ws, String historyTag, int displayId, IWakeLockCallback callback) {
            if (lock == null) goto L52;
            if (packageName == null) goto L50;
            if (isInteractive() == false) goto L8;
        L17:
            int flags2 = flags;
        L18:
            PowerManager.validateWakeLockParameters(flags2, tag);
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.WAKE_LOCK", null);
            if ((flags2 & 64) == 0) goto L22;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        L22:
            if ((flags2 & 256) != 0) goto L24;
        L28:
            if (ws != null) goto L30;
        L32:
            WorkSource ws2 = null;
        L33:
            int uid = Binder.getCallingUid();
            int pid = Binder.getCallingPid();
            if ((Integer.MIN_VALUE & flags2) == 0) goto L41;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            WorkSource workSource = new WorkSource(Binder.getCallingUid(), packageName);
            if (ws2 != null) goto L38;
        L40:
            int uid2 = Process.myUid();
            int pid2 = Process.myPid();
            int uid3 = uid2;
            int pid3 = pid2;
            WorkSource ws3 = workSource;
        L42:
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7476$$Nest$macquireWakeLockInternal(this.this$0, lock, displayId, flags2, tag, packageName, ws3, historyTag, uid3, pid3, callback);     // Catch: Throwable -> L46
            Binder.restoreCallingIdentity(ident);
            return;
        L46:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L38:
            if (ws2.isEmpty() == true) goto L40;
            workSource.add(ws2);
            goto L40
        L41:
            uid3 = uid;
            pid3 = pid;
            ws3 = ws2;
            goto L42
        L30:
            if (ws.isEmpty() == true) goto L32;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_DEVICE_STATS", null);
            ws2 = ws;
            goto L33
        L24:
            if (PowerManagerService.m7450$$Nest$fgetmFeatureFlags(this.this$0).isEarlyScreenTimeoutDetectorEnabled() == false) goto L27;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.SCREEN_TIMEOUT_OVERRIDE", null);
            goto L28
        L27:
            throw new IllegalArgumentException("Acquiring an unsupported wake lock: flags=" + flags2 + ", tag=" + tag);
        L8:
            if ((flags & 268435456) == 0) goto L17;
            if (DisturbModeUtils.getInstance(this.this$0.mContext) == null) goto L17;
            if (DisturbModeUtils.getInstance(this.this$0.mContext).isInDisturbModeForLightScreen(packageName) == false) goto L17;
            if (DisturbModeUtils.SMDBG == false) goto L16;
            Slog.i("DisturbModeUtils", "PMS in disturb mode not light screen:" + packageName);
        L16:
            flags2 = 268435456 ^ flags;
            goto L18
        L50:
            throw new IllegalArgumentException("packageName must not be null");
        L52:
            throw new IllegalArgumentException("lock must not be null");
        }

        public void acquireWakeLockAsync(IBinder lock, int flags, String tag, String packageName, WorkSource ws, String historyTag) {
            acquireWakeLock(lock, flags, tag, packageName, ws, historyTag, -1, null);
        }

        public void releaseWakeLock(IBinder lock, int flags) {
            if (lock == null) goto L11;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.WAKE_LOCK", null);
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7503$$Nest$mreleaseWakeLockInternal(this.this$0, lock, flags);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            throw new IllegalArgumentException("lock must not be null");
        }

        public void releaseWakeLockAsync(IBinder lock, int flags) {
            releaseWakeLock(lock, flags);
        }

        public void updateWakeLockUids(IBinder lock, int[] uids) {
            WorkSource ws = null;
            if (uids == null) goto L15;
            ws = new WorkSource();
            int r3 = 0;
            if (PowerManagerService.m7450$$Nest$fgetmFeatureFlags(this.this$0).isWakelockAttributionViaWorkchainEnabled() == false) goto L11;
            int callingUid = Binder.getCallingUid();
            int r4 = uids.length;
        L8:
            if (r3 >= r4) goto L15;
            int uid = uids[r3];
            WorkSource.WorkChain workChain = ws.createWorkChain();
            workChain.addNode(uid, null);
            workChain.addNode(callingUid, null);
            r3 = r3 + 1;
            goto L8
        L11:
            int r2 = uids.length;
        L13:
            if (r3 >= r2) goto L15;
            int uid2 = uids[r3];
            ws.add(uid2);
            r3 = r3 + 1;
        L15:
            updateWakeLockWorkSource(lock, ws, null);
        }

        public void updateWakeLockUidsAsync(IBinder lock, int[] uids) {
            updateWakeLockUids(lock, uids);
        }

        public void updateWakeLockWorkSource(IBinder lock, WorkSource ws, String historyTag) {
            if (lock == null) goto L17;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.WAKE_LOCK", null);
            if (ws != null) goto L6;
        L8:
            ws = null;
        L9:
            int callingUid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7521$$Nest$mupdateWakeLockWorkSourceInternal(this.this$0, lock, ws, historyTag, callingUid);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(ident);
            return;
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L6:
            if (ws.isEmpty() == true) goto L8;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_DEVICE_STATS", null);
            goto L9
        L17:
            throw new IllegalArgumentException("lock must not be null");
        }

        public void updateWakeLockCallback(IBinder lock, IWakeLockCallback callback) {
            if (lock == null) goto L11;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.WAKE_LOCK", null);
            int callingUid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7519$$Nest$mupdateWakeLockCallbackInternal(this.this$0, lock, callback, callingUid);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            throw new IllegalArgumentException("lock must not be null");
        }

        public boolean isWakeLockLevelSupported(int level) {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7497$$Nest$misWakeLockLevelSupportedInternal(this.this$0, level, 0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isWakeLockLevelSupportedWithDisplayId(int level, int displayId) {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7497$$Nest$misWakeLockLevelSupportedInternal(this.this$0, level, displayId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void addScreenTimeoutPolicyListener(int displayId, IScreenTimeoutPolicyListener listener) {
            if (PowerManagerService.m7450$$Nest$fgetmFeatureFlags(this.this$0).isScreenTimeoutPolicyListenerApiEnabled() == false) goto L29;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            if (displayId == (-1)) goto L27;
            long ident = Binder.clearCallingIdentity();
            int displayGroupId = this.this$0.mDisplayManagerInternal.getGroupIdForDisplay(displayId);     // Catch: Throwable -> L16
            Object r3 = this.this$0.mLock;     // Catch: Throwable -> L16
            monitor-enter(r3);     // Catch: Throwable -> L16
            PowerGroup powerGroup = this.this$0.mPowerGroups.get(displayGroupId);     // Catch: Throwable -> L18
            if (powerGroup == null) goto L21;
            int initialTimeoutPolicy = powerGroup.getScreenTimeoutPolicy();     // Catch: Throwable -> L18
            monitor-exit(r3);     // Catch: Throwable -> L18
            PowerManagerService.m7457$$Nest$fgetmNotifier(this.this$0).addScreenTimeoutPolicyListener(displayId, initialTimeoutPolicy, listener);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(ident);
            return;
        L21:
            throw new IllegalArgumentException("No display found for the specified display id " + displayId);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L27:
            throw new IllegalArgumentException("Valid display id is expected");
        L29:
            throw new IllegalStateException("Screen timeout policy listener API flag is not enabled");
        }

        public void removeScreenTimeoutPolicyListener(int displayId, IScreenTimeoutPolicyListener listener) {
            if (PowerManagerService.m7450$$Nest$fgetmFeatureFlags(this.this$0).isScreenTimeoutPolicyListenerApiEnabled() == false) goto L16;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            if (displayId == (-1)) goto L14;
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7457$$Nest$fgetmNotifier(this.this$0).removeScreenTimeoutPolicyListener(displayId, listener);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(ident);
            return;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L14:
            throw new IllegalArgumentException("Valid display id is expected");
        L16:
            throw new IllegalStateException("Screen timeout policy listener API flag is not enabled");
        }

        public void userActivity(int displayId, long eventTime, int event, int flags) {
            long now = PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis();
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L18;
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.USER_ACTIVITY") == 0) goto L18;
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
        L11:
            th = move-exception;
            throw th;
        L9:
            if (now < (PowerManagerService.m7454$$Nest$fgetmLastWarningAboutUserActivityPermission(this.this$0) + 300000)) goto L13;
            PowerManagerService.m7472$$Nest$fputmLastWarningAboutUserActivityPermission(this.this$0, now);     // Catch: Throwable -> L11
            Slog.w(PowerManagerService.TAG, "Ignoring call to PowerManager.userActivity() because the caller does not have DEVICE_POWER or USER_ACTIVITY permission.  Please fix your app!   pid=" + Binder.getCallingPid() + " uid=" + Binder.getCallingUid());     // Catch: Throwable -> L11
        L13:
            monitor-exit(r3);     // Catch: Throwable -> L11
            return;
        L18:
            if (eventTime <= now) goto L21;
            Slog.wtf(PowerManagerService.TAG, "Event cannot be newer than the current time (now=" + now + ", eventTime=" + eventTime + ", displayId=" + displayId + ", event=" + PowerManager.userActivityEventToString(event) + ", flags=" + flags + ")");
            return;
        L21:
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7522$$Nest$muserActivityInternal(this.this$0, displayId, eventTime, event, flags, uid);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return;
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void wakeUp(long eventTime, int reason, String details, String opPackageName) {
            wakeUpWithDisplayId(eventTime, reason, details, opPackageName, 0);
        }

        public void wakeUpWithDisplayId(long eventTime, int reason, String details, String opPackageName, int displayId) {
            long now = PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis();
            if (eventTime > now) goto L42;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).wakeUp(eventTime, reason, details, opPackageName);
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            int displayGroupId = PowerManagerService.m7483$$Nest$mgetDisplayGroupId(this.this$0, displayId);     // Catch: Throwable -> L36
            Object r3 = this.this$0.mLock;     // Catch: Throwable -> L36
            monitor-enter(r3);     // Catch: Throwable -> L36
        L30:
            th = th;
            Object r17 = r3;
        L32:
            monitor-exit(r17);     // Catch: Throwable -> L26
            throw th;     // Catch: Throwable -> L34
        L34:
            th = th;
        L40:
            Binder.restoreCallingIdentity(ident);
            throw th;
        L10:
            if (PowerManagerService.m7439$$Nest$fgetmBootCompleted(this.this$0) == false) goto L46;
        L19:
            r17 = r3;
            this.this$0.wakePowerGroupLocked(this.this$0.mPowerGroups.get(displayGroupId), eventTime, reason, details, uid, opPackageName, uid);     // Catch: Throwable -> L28
            monitor-exit(r17);     // Catch: Throwable -> L26
            Binder.restoreCallingIdentity(ident);
            return;
        L28:
            th = th;
            goto L32
        L46:
        L17:
            th = th;
            r17 = r3;
            goto L32
        L12:
            if (PowerManagerService.m7528$$Nest$sfgetsQuiescent() == false) goto L19;
            this.this$0.mDirty |= 4096;     // Catch: Throwable -> L17
            this.this$0.updatePowerStateLocked();     // Catch: Throwable -> L17
            monitor-exit(r3);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(ident);
            return;
        L26:
            th = th;
        L36:
            th = th;
        L38:
            th = th;
            goto L40
        L42:
            Slog.e(PowerManagerService.TAG, "Event time " + eventTime + " cannot be newer than " + now);
            throw new IllegalArgumentException("event time must not be in the future");
        }

        public void goToSleep(long eventTime, int reason, int flags) {
            PowerManagerService.m7487$$Nest$mgoToSleepInternal(this.this$0, PowerManagerService.m7527$$Nest$sfgetDEFAULT_DISPLAY_GROUP_IDS(), eventTime, reason, flags);
        }

        public void goToSleepWithDisplayId(int displayId, long eventTime, int reason, int flags) {
            if (displayId != (-1)) goto L5;
            IntArray groupIds = this.this$0.mDisplayManagerInternal.getDisplayGroupIds();
        L12:
            PowerManagerService.m7487$$Nest$mgoToSleepInternal(this.this$0, groupIds, eventTime, reason, flags);
            return;
        L5:
            DisplayInfo displayInfo = this.this$0.mDisplayManagerInternal.getDisplayInfo(displayId);
            if (displayInfo == null) goto L8;
            boolean r2 = true;
        L9:
            Preconditions.checkArgument(r2, "display ID(%d) doesn't exist", new Object[]{Integer.valueOf(displayId)});
            int groupId = displayInfo.displayGroupId;
            if (groupId == (-1)) goto L15;
            groupIds = IntArray.wrap(new int[]{groupId});
            goto L12
        L15:
            throw new IllegalArgumentException("invalid display group ID");
        L8:
            r2 = false;
            goto L9
        }

        public void nap(long eventTime) {
            long now = PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis();
            if (eventTime > now) goto L11;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7499$$Nest$mnapInternal(this.this$0, eventTime, uid, false);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(ident);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            Slog.e(PowerManagerService.TAG, "Event time " + eventTime + " cannot be newer than " + now);
            throw new IllegalArgumentException("event time must not be in the future");
        }

        public float getBrightnessConstraint(int displayId, int constraint) {
            DisplayInfo info = null;
            if (this.this$0.mDisplayManagerInternal == null) goto L5;
            info = this.this$0.mDisplayManagerInternal.getDisplayInfo(displayId);
        L5:
            switch(constraint) {
                case 0: goto L27;
                case 1: goto L21;
                case 2: goto L15;
                case 3: goto L9;
                default: goto L6;
            };
        L6:
            return Float.NaN;
        L15:
            if (info == null) goto L20;
            if (BrightnessUtils.isValidBrightnessValue(info.brightnessDefault) == false) goto L20;
            return info.brightnessDefault;
        L20:
            return this.this$0.mScreenBrightnessDefault;
        L21:
            if (info == null) goto L26;
            if (BrightnessUtils.isValidBrightnessValue(info.brightnessMaximum) == false) goto L26;
            return info.brightnessMaximum;
        L26:
            return this.this$0.mScreenBrightnessMaximum;
        L27:
            if (info == null) goto L32;
            if (BrightnessUtils.isValidBrightnessValue(info.brightnessMinimum) == false) goto L32;
            return info.brightnessMinimum;
        L32:
            return this.this$0.mScreenBrightnessMinimum;
        L9:
            if (info == null) goto L14;
            if (BrightnessUtils.isValidBrightnessValue(info.brightnessDim) == false) goto L14;
            return info.brightnessDim;
        L14:
            return this.this$0.mScreenBrightnessDim;
        }

        public boolean isInteractive() {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = this.this$0.isGloballyInteractiveInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isDisplayInteractive(int displayId) {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            boolean r3 = PowerManagerService.m7495$$Nest$misInteractiveInternal(this.this$0, displayId, uid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean areAutoPowerSaveModesEnabled() {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = this.this$0.mContext.getResources().getBoolean(R.bool.config_enableContextSyncInCall);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isPowerSaveMode() {
            long ident = Binder.clearCallingIdentity();
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L4:
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L10;
            if (PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).getBatterySaverController().isEnabled() == false) goto L10;
            boolean r2 = true;
        L11:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L10:
            r2 = false;
            goto L11
        }

        public PowerSaveState getPowerSaveState(int serviceType) {
            long ident = Binder.clearCallingIdentity();
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L4:
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L8;
            PowerSaveState r2 = PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).getBatterySaverPolicy().getBatterySaverPolicy(serviceType);     // Catch: Throwable -> L6
        L9:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L8:
            r2 = new PowerSaveState.Builder().build();     // Catch: Throwable -> L6
            goto L9
        }

        public boolean setPowerSaveModeEnabled(boolean enabled) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.POWER_SAVER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        L5:
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7512$$Nest$msetLowPowerModeInternal(this.this$0, enabled);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return r2;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isBatterySaverSupported() {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public BatterySaverPolicyConfig getFullPowerSavePolicy() {
            long ident = Binder.clearCallingIdentity();
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L4:
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L8;
            BatterySaverPolicyConfig r2 = PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).getFullBatterySaverPolicy();     // Catch: Throwable -> L6
        L9:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L8:
            r2 = new BatterySaverPolicyConfig.Builder().build();     // Catch: Throwable -> L6
            goto L9
        }

        public boolean setFullPowerSavePolicy(BatterySaverPolicyConfig config) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.POWER_SAVER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", "setFullPowerSavePolicy");
        L5:
            long ident = Binder.clearCallingIdentity();
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L7:
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L13;
            if (PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).setFullBatterySaverPolicy(config) == false) goto L13;
            boolean r2 = true;
        L14:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L13:
            r2 = false;
            goto L14
        }

        public boolean setDynamicPowerSaveHint(boolean powerSaveHint, int disableThreshold) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.POWER_SAVER", "updateDynamicPowerSavings");
            long ident = Binder.clearCallingIdentity();
            ContentResolver resolver = this.this$0.mContext.getContentResolver();     // Catch: Throwable -> L11
            boolean success = Settings.Global.putInt(resolver, "dynamic_power_savings_disable_threshold", disableThreshold);     // Catch: Throwable -> L11
            if (success == true) goto L6;
        L13:
            Binder.restoreCallingIdentity(ident);
            return success;
        L6:
            if (powerSaveHint == false) goto L8;
            int r5 = 1;
        L9:
            success = success & Settings.Global.putInt(resolver, "dynamic_power_savings_enabled", r5);
            goto L13
        L8:
            r5 = 0;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean setAdaptivePowerSavePolicy(BatterySaverPolicyConfig config) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.POWER_SAVER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", "setAdaptivePowerSavePolicy");
        L5:
            long ident = Binder.clearCallingIdentity();
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L7:
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L13;
            if (PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).setAdaptiveBatterySaverPolicy(config) == false) goto L13;
            boolean r2 = true;
        L14:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L13:
            r2 = false;
            goto L14
        }

        public boolean setAdaptivePowerSaveEnabled(boolean enabled) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.POWER_SAVER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", "setAdaptivePowerSaveEnabled");
        L5:
            long ident = Binder.clearCallingIdentity();
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L7:
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L13;
            if (PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).setAdaptiveBatterySaverEnabled(enabled) == false) goto L13;
            boolean r2 = true;
        L14:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L13:
            r2 = false;
            goto L14
        }

        public int getPowerSaveModeTrigger() {
            long ident = Binder.clearCallingIdentity();
            int r2 = Settings.Global.getInt(this.this$0.mContext.getContentResolver(), "automatic_power_save_mode", 0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setBatteryDischargePrediction(ParcelDuration timeRemaining, boolean isPersonalized) {
            long nowElapsed = PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).elapsedRealtime();
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.BATTERY_PREDICTION") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", "setBatteryDischargePrediction");
        L5:
            long timeRemainingMs = timeRemaining.getDuration().toMillis();
            Preconditions.checkArgumentPositive(timeRemainingMs, "Given time remaining is not positive: " + timeRemainingMs);
            long ident = Binder.clearCallingIdentity();
            Object r6 = this.this$0.mLock;     // Catch: Throwable -> L25
            monitor-enter(r6);     // Catch: Throwable -> L25
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L9:
            if (PowerManagerService.m7452$$Nest$fgetmIsPowered(this.this$0) == true) goto L32;
            monitor-exit(r6);     // Catch: Throwable -> L29
            Object r7 = PowerManagerService.m7447$$Nest$fgetmEnhancedDischargeTimeLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r7);     // Catch: Throwable -> L25
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L14:
            if (PowerManagerService.m7453$$Nest$fgetmLastEnhancedDischargeTimeUpdatedElapsed(this.this$0) <= nowElapsed) goto L20;
            monitor-exit(r7);     // Catch: Throwable -> L18
            Binder.restoreCallingIdentity(ident);
            return;
        L20:
            long broadcastDelayMs = Math.max(0, 60000 - (nowElapsed - PowerManagerService.m7453$$Nest$fgetmLastEnhancedDischargeTimeUpdatedElapsed(this.this$0)));     // Catch: Throwable -> L18
            PowerManagerService.m7467$$Nest$fputmEnhancedDischargeTimeElapsed(this.this$0, nowElapsed + timeRemainingMs);     // Catch: Throwable -> L18
            PowerManagerService.m7466$$Nest$fputmEnhancedDischargePredictionIsPersonalized(this.this$0, isPersonalized);     // Catch: Throwable -> L18
            PowerManagerService.m7471$$Nest$fputmLastEnhancedDischargeTimeUpdatedElapsed(this.this$0, nowElapsed);     // Catch: Throwable -> L18
            monitor-exit(r7);     // Catch: Throwable -> L18
            PowerManagerService.m7457$$Nest$fgetmNotifier(this.this$0).postEnhancedDischargePredictionBroadcast(broadcastDelayMs);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return;
        L32:
            throw new IllegalStateException("Discharge prediction can't be set while the device is charging");     // Catch: Throwable -> L29
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        private boolean isEnhancedDischargePredictionValidLocked(long nowElapsed) {
            if (PowerManagerService.m7453$$Nest$fgetmLastEnhancedDischargeTimeUpdatedElapsed(this.this$0) > 0) goto L5;
        L9:
            return false;
        L5:
            if (nowElapsed >= PowerManagerService.m7446$$Nest$fgetmEnhancedDischargeTimeElapsed(this.this$0)) goto L9;
            if ((nowElapsed - PowerManagerService.m7453$$Nest$fgetmLastEnhancedDischargeTimeUpdatedElapsed(this.this$0)) >= 1800000) goto L9;
            return true;
        }

        public ParcelDuration getBatteryDischargePrediction() {
            long ident = Binder.clearCallingIdentity();
            Object r3 = this.this$0.mLock;     // Catch: Throwable -> L28 RemoteException -> L30
            monitor-enter(r3);     // Catch: Throwable -> L28 RemoteException -> L30
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28 RemoteException -> L30
        L6:
            if (PowerManagerService.m7452$$Nest$fgetmIsPowered(this.this$0) == false) goto L12;
            monitor-exit(r3);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(ident);
            return null;
        L12:
            monitor-exit(r3);     // Catch: Throwable -> L10
            Object r4 = PowerManagerService.m7447$$Nest$fgetmEnhancedDischargeTimeLock(this.this$0);     // Catch: Throwable -> L28 RemoteException -> L30
            monitor-enter(r4);     // Catch: Throwable -> L28 RemoteException -> L30
            long nowElapsed = PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).elapsedRealtime();     // Catch: Throwable -> L21
            if (isEnhancedDischargePredictionValidLocked(nowElapsed) == false) goto L24;
            ParcelDuration r6 = new ParcelDuration(PowerManagerService.m7446$$Nest$fgetmEnhancedDischargeTimeElapsed(this.this$0) - nowElapsed);     // Catch: Throwable -> L21
            monitor-exit(r4);     // Catch: Throwable -> L21
            Binder.restoreCallingIdentity(ident);
            return r6;
        L24:
            monitor-exit(r4);     // Catch: Throwable -> L21
            ParcelDuration r5 = new ParcelDuration(PowerManagerService.m7438$$Nest$fgetmBatteryStats(this.this$0).computeBatteryTimeRemaining());     // Catch: Throwable -> L28 RemoteException -> L30
            Binder.restoreCallingIdentity(ident);
            return r5;
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28 RemoteException -> L30
        L28:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L38:
            Binder.restoreCallingIdentity(ident);
            return null;
        }

        public boolean isBatteryDischargePredictionPersonalized() {
            long ident = Binder.clearCallingIdentity();
            Object r2 = PowerManagerService.m7447$$Nest$fgetmEnhancedDischargeTimeLock(this.this$0);     // Catch: Throwable -> L18
            monitor-enter(r2);     // Catch: Throwable -> L18
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L6:
            if (isEnhancedDischargePredictionValidLocked(PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).elapsedRealtime()) == true) goto L8;
        L12:
            boolean r3 = false;
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(ident);
            return r3;
        L8:
            if (PowerManagerService.m7445$$Nest$fgetmEnhancedDischargePredictionIsPersonalized(this.this$0) == false) goto L12;
            r3 = true;
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isDeviceIdleMode() {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = this.this$0.isDeviceIdleModeInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isLightDeviceIdleMode() {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = this.this$0.isLightDeviceIdleModeInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isLowPowerStandbySupported() {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_LOW_POWER_STANDBY", "isLowPowerStandbySupported");
        L5:
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).isSupported();     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return r2;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isLowPowerStandbyEnabled() {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).isEnabled();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setLowPowerStandbyEnabled(boolean enabled) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_LOW_POWER_STANDBY", "setLowPowerStandbyEnabled");
        L5:
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).setEnabled(enabled);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setLowPowerStandbyActiveDuringMaintenance(boolean activeDuringMaintenance) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_LOW_POWER_STANDBY", "setLowPowerStandbyActiveDuringMaintenance");
        L5:
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).setActiveDuringMaintenance(activeDuringMaintenance);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void forceLowPowerStandbyActive(boolean active) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_LOW_POWER_STANDBY", "forceLowPowerStandbyActive");
        L5:
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).forceActive(active);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setLowPowerStandbyPolicy(IPowerManager.LowPowerStandbyPolicy policy) {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_LOW_POWER_STANDBY", "setLowPowerStandbyPolicy");
        L5:
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).setPolicy(PowerManager.LowPowerStandbyPolicy.fromParcelable(policy));     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public IPowerManager.LowPowerStandbyPolicy getLowPowerStandbyPolicy() {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_LOW_POWER_STANDBY", "getLowPowerStandbyPolicy");
        L5:
            long ident = Binder.clearCallingIdentity();
            IPowerManager.LowPowerStandbyPolicy r2 = PowerManager.LowPowerStandbyPolicy.toParcelable(PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).getPolicy());     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return r2;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isExemptFromLowPowerStandby() {
            int callingUid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            boolean r3 = PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).isPackageExempt(callingUid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isReasonAllowedInLowPowerStandby(int reason) {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).isAllowed(reason);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isFeatureAllowedInLowPowerStandby(String feature) {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).isAllowed(feature);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void acquireLowPowerStandbyPorts(IBinder token, List<IPowerManager.LowPowerStandbyPortDescription> ports) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.SET_LOW_POWER_STANDBY_PORTS", "acquireLowPowerStandbyPorts");
            int callingUid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).acquireStandbyPorts(token, callingUid, PowerManager.LowPowerStandbyPortDescription.fromParcelable(ports));     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void releaseLowPowerStandbyPorts(IBinder token) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.SET_LOW_POWER_STANDBY_PORTS", "releaseLowPowerStandbyPorts");
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).releaseStandbyPorts(token);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public List<IPowerManager.LowPowerStandbyPortDescription> getActiveLowPowerStandbyPorts() {
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DEVICE_POWER") == 0) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_LOW_POWER_STANDBY", "getActiveLowPowerStandbyPorts");
        L5:
            long ident = Binder.clearCallingIdentity();
            List<IPowerManager.LowPowerStandbyPortDescription> r2 = PowerManager.LowPowerStandbyPortDescription.toParcelable(PowerManagerService.m7455$$Nest$fgetmLowPowerStandbyController(this.this$0).getActiveStandbyPorts());     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return r2;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public int getLastShutdownReason() {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
            int r2 = this.this$0.getLastShutdownReasonInternal();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public int getLastSleepReason() {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
            int r2 = PowerManagerService.m7485$$Nest$mgetLastSleepReasonInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void reboot(boolean confirm, String reason, boolean wait) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.REBOOT", null);
            if ("recovery".equals(reason) == false) goto L5;
        L6:
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.RECOVERY", null);
        L7:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            Slog.d(PowerManagerService.TAG, "reboot reason=" + reason + " confirm=" + confirm + " wait=" + wait + " (" + pid + "," + uid + ")");
            ShutdownCheckPoints.recordCheckPoint(Binder.getCallingPid(), reason);
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7516$$Nest$mshutdownOrRebootInternal(this.this$0, 1, confirm, reason, wait);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(ident);
            return;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L5:
            if ("recovery-update".equals(reason) == false) goto L7;
            goto L6
        }

        public void rebootSafeMode(boolean confirm, boolean wait) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.REBOOT", null);
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            Slog.d(PowerManagerService.TAG, "reboot confirm=" + confirm + " wait=" + wait + " (" + pid + "," + uid + ")");
            ShutdownCheckPoints.recordCheckPoint(Binder.getCallingPid(), "safemode");
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7516$$Nest$mshutdownOrRebootInternal(this.this$0, 2, confirm, "safemode", wait);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void shutdown(boolean confirm, String reason, boolean wait) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.REBOOT", null);
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            Slog.d(PowerManagerService.TAG, "shutdown reason=" + reason + " confirm=" + confirm + " wait=" + wait + " (" + pid + "," + uid + ")");
            ShutdownCheckPoints.recordCheckPoint(Binder.getCallingPid(), reason);
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7516$$Nest$mshutdownOrRebootInternal(this.this$0, 0, confirm, reason, wait);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void crash(String message) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.REBOOT", null);
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7478$$Nest$mcrashInternal(this.this$0, message);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setStayOnSetting(int val) {
            int uid = Binder.getCallingUid();
            if (uid != 0) goto L5;
        L7:
            long ident = Binder.clearCallingIdentity();
            this.this$0.setStayOnSettingInternal(val);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(ident);
            return;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L5:
            if (Settings.checkAndNoteWriteSettingsOperation(this.this$0.mContext, uid, Settings.getPackageNameForUid(this.this$0.mContext, uid), null, true) == true) goto L7;
        }

        public void setAttentionLight(boolean on, int color) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7505$$Nest$msetAttentionLightInternal(this.this$0, on, color);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setDozeAfterScreenOff(boolean on) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7507$$Nest$msetDozeAfterScreenOffInternal(this.this$0, on);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isAmbientDisplayAvailable() {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.READ_DREAM_STATE", null);
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7434$$Nest$fgetmAmbientDisplayConfiguration(this.this$0).ambientDisplayAvailable();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void suppressAmbientDisplay(String token, boolean suppress) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.WRITE_DREAM_STATE", null);
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7435$$Nest$fgetmAmbientDisplaySuppressionController(this.this$0).suppress(token, uid, suppress);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isAmbientDisplaySuppressedForToken(String token) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.READ_DREAM_STATE", null);
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            boolean r3 = PowerManagerService.m7435$$Nest$fgetmAmbientDisplaySuppressionController(this.this$0).isSuppressed(token, uid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isAmbientDisplaySuppressedForTokenByApp(String token, int appUid) {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.READ_DREAM_STATE", null);
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.READ_DREAM_SUPPRESSION", null);
            long ident = Binder.clearCallingIdentity();
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L4:
            if (isAmbientDisplayAvailable() == false) goto L10;
            if (PowerManagerService.m7435$$Nest$fgetmAmbientDisplaySuppressionController(this.this$0).isSuppressed(token, appUid) == false) goto L10;
            boolean r2 = true;
        L11:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L10:
            r2 = false;
            goto L11
        }

        public boolean isAmbientDisplaySuppressed() {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.READ_DREAM_STATE", null);
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7435$$Nest$fgetmAmbientDisplaySuppressionController(this.this$0).isSuppressed();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void boostScreenBrightness(long eventTime) {
            long now = PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis();
            if (eventTime > PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis()) goto L11;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7477$$Nest$mboostScreenBrightnessInternal(this.this$0, eventTime, uid);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(ident);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            Slog.e(PowerManagerService.TAG, "Event time " + eventTime + " cannot be newer than " + now);
            throw new IllegalArgumentException("event time must not be in the future");
        }

        public boolean isScreenBrightnessBoosted() {
            long ident = Binder.clearCallingIdentity();
            boolean r2 = PowerManagerService.m7496$$Nest$misScreenBrightnessBoostedInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean forceSuspend() {
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            boolean r3 = PowerManagerService.m7482$$Nest$mforceSuspendInternal(this.this$0, uid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.mContext, PowerManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            boolean ret = PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).dump(fd, pw, args);
            if (ret == false) goto L8;
            return;
        L8:
            long ident = Binder.clearCallingIdentity();
            boolean isDumpProto = false;
            int r4 = args.length;
            int r5 = 0;
        L10:
            if (r5 >= r4) goto L24;
            String arg = args[r5];
            if (arg.equals("--proto") == true) goto L13;
            r5 = r5 + 1;
            goto L10
        L13:
            isDumpProto = true;
        L24:
            if (isDumpProto == false) goto L19;
            PowerManagerService.m7480$$Nest$mdumpProto(this.this$0, fd);     // Catch: Throwable -> L17
        L20:
            Binder.restoreCallingIdentity(ident);
            return;
        L19:
            PowerManagerService.m7479$$Nest$mdumpInternal(this.this$0, pw);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public List<String> getAmbientDisplaySuppressionTokens() {
            int uid = Binder.getCallingUid();
            long ident = Binder.clearCallingIdentity();
            List<String> r3 = PowerManagerService.m7435$$Nest$fgetmAmbientDisplaySuppressionController(this.this$0).getSuppressionTokens(uid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setUseFaceDownDetector(boolean enable) {
            long ident = Binder.clearCallingIdentity();
            PowerManagerService.m7449$$Nest$fgetmFaceDownDetector(this.this$0).setEnabledOverride(enable);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public IPowerManagerSmtEx getISmtEx() {
            return PowerManagerService.m7460$$Nest$fgetmSmtEx(this.this$0);
        }

        public IPowerManagerExt getIExt() {
            return PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).getIExt();
        }

        public int getGlobalWakefulness() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = this.this$0.getGlobalWakefulnessLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isInFakeSleep() {
            return PowerManagerService.m7464$$Nest$fgetmZswExt(this.this$0).isInFakeSleep();
        }

        public void enterFakeSleep() {
            PowerManagerService.m7464$$Nest$fgetmZswExt(this.this$0).enterFakeSleep();
        }

        public void exitFakeSleep(int flag) {
            PowerManagerService.m7464$$Nest$fgetmZswExt(this.this$0).exitFakeSleep(flag);
        }
    }

    interface Clock {
        long elapsedRealtime();

        long uptimeMillis();
    }

    private final class Constants extends ContentObserver {
        private static final boolean DEFAULT_NO_CACHED_WAKE_LOCKS = true;
        private static final String KEY_NO_CACHED_WAKE_LOCKS = "no_cached_wake_locks";
        public boolean NO_CACHED_WAKE_LOCKS;
        private final KeyValueListParser mParser;
        private ContentResolver mResolver;
        final /* synthetic */ PowerManagerService this$0;

        public Constants(PowerManagerService r2, Handler handler) {
            this.this$0 = r2;
            super(handler);
            this.NO_CACHED_WAKE_LOCKS = true;
            this.mParser = new KeyValueListParser(',');
        }

        public void start(ContentResolver resolver) {
            this.mResolver = resolver;
            this.mResolver.registerContentObserver(Settings.Global.getUriFor("power_manager_constants"), false, this);
            updateConstants();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            updateConstants();
        }

        private void updateConstants() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mParser.setString(Settings.Global.getString(this.mResolver, "power_manager_constants"));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
        L10:
            this.NO_CACHED_WAKE_LOCKS = this.mParser.getBoolean(KEY_NO_CACHED_WAKE_LOCKS, true);     // Catch: Throwable -> L6
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        L8:
            e = move-exception;
            Slog.e(PowerManagerService.TAG, "Bad alarm manager settings", e);     // Catch: Throwable -> L6
            goto L10
        }

        void dump(PrintWriter pw) {
            pw.println("  Settings power_manager_constants:");
            pw.print("    ");
            pw.print(KEY_NO_CACHED_WAKE_LOCKS);
            pw.print("=");
            pw.println(this.NO_CACHED_WAKE_LOCKS);
        }

        void dumpProto(ProtoOutputStream proto) {
            long constantsToken = proto.start(1146756268033L);
            proto.write(1133871366145L, this.NO_CACHED_WAKE_LOCKS);
            proto.end(constantsToken);
        }
    }

    class DeviceStateListener implements DeviceStateManager.DeviceStateCallback {
        private int mDeviceState;
        final /* synthetic */ PowerManagerService this$0;

        DeviceStateListener(PowerManagerService this$0) {
            this.this$0 = this$0;
            this.mDeviceState = -1;
        }

        public void onDeviceStateChanged(DeviceState deviceState) {
            int stateIdentifier = deviceState.getIdentifier();
            if (this.mDeviceState == stateIdentifier) goto L6;
            this.mDeviceState = stateIdentifier;
            PowerManagerService.m7522$$Nest$muserActivityInternal(this.this$0, 0, PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis(), 6, 0, 1000);
            return;
        }
    }

    private final class DisplayGroupPowerChangeListener implements DisplayManagerInternal.DisplayGroupListener {
        static final int DISPLAY_GROUP_ADDED = 0;
        static final int DISPLAY_GROUP_CHANGED = 2;
        static final int DISPLAY_GROUP_REMOVED = 1;
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ DisplayGroupPowerChangeListener(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private DisplayGroupPowerChangeListener(PowerManagerService r1) {
            this.this$0 = r1;
        }

        public void onDisplayGroupAdded(int groupId) {
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L22:
            th = th;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L22
            throw th;
        L24:
            th = th;
            goto L26
        L5:
            if (this.this$0.mPowerGroups.contains(groupId) == false) goto L12;
            Slog.e(PowerManagerService.TAG, "Tried to add already existing group:" + groupId);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L9:
            th = th;
            goto L26
        L12:
            if (groupId != 0) goto L14;
            boolean r2 = true;
        L15:
            boolean supportsSandman = r2;
            PowerGroup powerGroup = new PowerGroup(groupId, PowerManagerService.m7458$$Nest$fgetmPowerGroupWakefulnessChangeListener(this.this$0), PowerManagerService.m7457$$Nest$fgetmNotifier(this.this$0), this.this$0.mDisplayManagerInternal, 1, false, supportsSandman, PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis(), PowerManagerService.m7450$$Nest$fgetmFeatureFlags(this.this$0));     // Catch: Throwable -> L22
            this.this$0.mPowerGroups.append(groupId, powerGroup);     // Catch: Throwable -> L22
            this.this$0.onPowerGroupEventLocked(0, powerGroup);     // Catch: Throwable -> L22
            PowerManagerService.m7464$$Nest$fgetmZswExt(this.this$0).registerPowerGroupListener(groupId, powerGroup);     // Catch: Throwable -> L22
            monitor-exit(r1);     // Catch: Throwable -> L22
            PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).onDisplayGroupAdded(groupId);
            return;
        L14:
            r2 = false;
            goto L15
        }

        public void onDisplayGroupRemoved(int groupId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            if (groupId != 0) goto L11;
            Slog.wtf(PowerManagerService.TAG, "Tried to remove default display group: " + groupId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.this$0.mPowerGroups.contains(groupId) == true) goto L15;
            Slog.e(PowerManagerService.TAG, "Tried to remove non-existent group:" + groupId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L15:
            this.this$0.onPowerGroupEventLocked(1, this.this$0.mPowerGroups.get(groupId));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).onDisplayGroupRemoved(groupId);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void onDisplayGroupChanged(int groupId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mPowerGroups.contains(groupId) == true) goto L11;
            Slog.e(PowerManagerService.TAG, "Tried to change non-existent group: " + groupId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            this.this$0.onPowerGroupEventLocked(2, this.this$0.mPowerGroups.get(groupId));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).onDisplayGroupChanged(groupId);
        }
    }

    private final class DisplayListener implements DisplayManager.DisplayListener {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ DisplayListener(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private DisplayListener(PowerManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
            PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).onDisplayAdded(displayId);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
            PowerManagerService.m7457$$Nest$fgetmNotifier(this.this$0).clearScreenTimeoutPolicyListeners(displayId);
            PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).onDisplayRemoved(displayId);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).onDisplayChanged(displayId);
        }
    }

    private final class DockReceiver extends BroadcastReceiver {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ DockReceiver(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private DockReceiver(PowerManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int dockState = intent.getIntExtra("android.intent.extra.DOCK_STATE", 0);     // Catch: Throwable -> L7
            if (PowerManagerService.m7444$$Nest$fgetmDockState(this.this$0) == dockState) goto L9;
            FrameworkStatsLog.write(FrameworkStatsLog.DOCK_STATE_CHANGED, dockState);     // Catch: Throwable -> L7
            PowerManagerService.m7465$$Nest$fputmDockState(this.this$0, dockState);     // Catch: Throwable -> L7
            this.this$0.mDirty |= 1024;     // Catch: Throwable -> L7
            this.this$0.updatePowerStateLocked();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class DreamManagerStateListener implements DreamManagerInternal.DreamManagerStateListener {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ DreamManagerStateListener(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private DreamManagerStateListener(PowerManagerService r1) {
            this.this$0 = r1;
        }

        public void onKeepDreamingWhenUnpluggingChanged(boolean keepDreaming) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            PowerManagerService.m7470$$Nest$fputmKeepDreamingWhenUnplugging(this.this$0, keepDreaming);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class DreamReceiver extends BroadcastReceiver {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ DreamReceiver(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private DreamReceiver(PowerManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            PowerManagerService.m7504$$Nest$mscheduleSandmanLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class ForegroundProfileObserver extends SynchronousUserSwitchObserver {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ ForegroundProfileObserver(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private ForegroundProfileObserver(PowerManagerService r1) {
            this.this$0 = r1;
        }

        public void onUserSwitching(int newUserId) throws RemoteException {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            PowerManagerService.m7474$$Nest$fputmUserId(this.this$0, newUserId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onForegroundProfileSwitch(int newProfileId) throws RemoteException {
            long now = PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis();
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            PowerManagerService.m7468$$Nest$fputmForegroundProfile(this.this$0, newProfileId);     // Catch: Throwable -> L7
            PowerManagerService.m7498$$Nest$mmaybeUpdateForegroundProfileLastActivityLocked(this.this$0, now);     // Catch: Throwable -> L7
            monitor-exit(r2);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HaltMode {
    }

    static class Injector {
        Injector() {
        }

        Notifier createNotifier(Looper looper, Context context, IBatteryStats batteryStats, SuspendBlocker suspendBlocker, WindowManagerPolicy policy, FaceDownDetector faceDownDetector, ScreenUndimDetector screenUndimDetector, Executor backgroundExecutor, PowerManagerFlags powerManagerFlags) {
            return new Notifier(looper, context, batteryStats, suspendBlocker, policy, faceDownDetector, screenUndimDetector, backgroundExecutor, powerManagerFlags, null);
        }

        SuspendBlocker createSuspendBlocker(PowerManagerService service, String name) {
            service.getClass();
            SuspendBlockerImpl r0 = new SuspendBlockerImpl(service, name);
            PowerManagerService.m7461$$Nest$fgetmSuspendBlockers(service).add(r0);
            return r0;
        }

        BatterySaverStateMachine createBatterySaverStateMachine(Object lock, Context context) {
            BatterySavingStats batterySavingStats = new BatterySavingStats(lock);
            BatterySaverPolicy batterySaverPolicy = new BatterySaverPolicy(lock, context, batterySavingStats);
            BatterySaverController batterySaverController = new BatterySaverController(lock, context, BackgroundThread.get().getLooper(), batterySaverPolicy, batterySavingStats);
            return new BatterySaverStateMachine(lock, context, batterySaverController);
        }

        NativeWrapper createNativeWrapper() {
            return new NativeWrapper();
        }

        WirelessChargerDetector createWirelessChargerDetector(SensorManager sensorManager, SuspendBlocker suspendBlocker, Handler handler) {
            return new WirelessChargerDetector(sensorManager, suspendBlocker, handler);
        }

        AmbientDisplayConfiguration createAmbientDisplayConfiguration(Context context) {
            return new AmbientDisplayConfiguration(context);
        }

        AmbientDisplaySuppressionController createAmbientDisplaySuppressionController(AmbientDisplaySuppressionController.AmbientDisplaySuppressionChangedCallback callback) {
            return new AmbientDisplaySuppressionController(callback);
        }

        InattentiveSleepWarningController createInattentiveSleepWarningController() {
            return new InattentiveSleepWarningController();
        }

        FoldGracePeriodProvider createFoldGracePeriodProvider() {
            return new FoldGracePeriodProvider();
        }

        public SystemPropertiesWrapper createSystemPropertiesWrapper() {
            return new AnonymousClass1(this);
        }

        Clock createClock() {
            return new AnonymousClass2(this);
        }

        Handler createHandler(Looper looper, Handler.Callback callback) {
            return new Handler(looper, callback, true);
        }

        void invalidateIsInteractiveCaches() {
            PowerManager.invalidateIsInteractiveCaches();
        }

        LowPowerStandbyController createLowPowerStandbyController(Context context, Looper looper) {
            return new LowPowerStandbyController(context, looper);
        }

        PermissionCheckerWrapper createPermissionCheckerWrapper() {
            return new PowerManagerService$Injector$$ExternalSyntheticLambda0();
        }

        PowerPropertiesWrapper createPowerPropertiesWrapper() {
            return new AnonymousClass3(this);
        }

        DeviceConfigParameterProvider createDeviceConfigParameterProvider() {
            return new DeviceConfigParameterProvider(DeviceConfigInterface.REAL);
        }

        PowerManagerFlags getFlags() {
            return new PowerManagerFlags();
        }
    }

    final class LocalService extends PowerManagerInternal {
        final /* synthetic */ PowerManagerService this$0;

        LocalService(PowerManagerService this$0) {
            this.this$0 = this$0;
        }

        public void setDozeOverrideFromDreamManager(int screenState, int reason, float screenBrightnessFloat, int screenBrightnessInt, boolean useNormalBrightnessForDoze) {
            switch(screenState) {
                case 0: goto L4;
                case 1: goto L4;
                case 2: goto L4;
                case 3: goto L4;
                case 4: goto L4;
                case 5: goto L3;
                case 6: goto L4;
                default: goto L3;
            };
        L3:
            int screenState2 = 0;
        L6:
            if (screenBrightnessInt >= (-1)) goto L8;
        L11:
            int screenBrightnessInt2 = -1;
        L13:
            if (screenBrightnessFloat != (-1.0f)) goto L15;
        L19:
            float screenBrightnessFloat2 = screenBrightnessFloat;
        L21:
            if (com.android.server.common.Constants.ENABLE_GAME_SCREEN_SAVER == false) goto L25;
            int reason2 = reason;
            boolean useNormalBrightnessForDoze2 = useNormalBrightnessForDoze;
            if (((IGameScreenSaver) LocalServices.getService(IGameScreenSaver.class)).interceptDozeOverrideScreenBrightness(screenState2, reason2, screenBrightnessFloat2, screenBrightnessInt2, useNormalBrightnessForDoze2) == false) goto L26;
            return;
        L26:
            PowerManagerService.m7508$$Nest$msetDozeOverrideFromDreamManagerInternal(this.this$0, screenState2, reason2, screenBrightnessFloat2, screenBrightnessInt2, useNormalBrightnessForDoze2);
            return;
        L25:
            reason2 = reason;
            useNormalBrightnessForDoze2 = useNormalBrightnessForDoze;
            goto L26
        L15:
            if (screenBrightnessFloat >= 0.0f) goto L17;
        L18:
            screenBrightnessFloat2 = Float.NaN;
            goto L21
        L17:
            if (screenBrightnessFloat <= 1.0f) goto L19;
        L8:
            if (screenBrightnessInt > 255) goto L11;
            screenBrightnessInt2 = screenBrightnessInt;
            goto L13
        L4:
            screenState2 = screenState;
            goto L6
        }

        public void setUserInactiveOverrideFromWindowManager() {
            PowerManagerService.m7515$$Nest$msetUserInactiveOverrideFromWindowManagerInternal(this.this$0);
        }

        public void setUserActivityTimeoutOverrideFromWindowManager(long timeoutMillis) {
            PowerManagerService.m7514$$Nest$msetUserActivityTimeoutOverrideFromWindowManagerInternal(this.this$0, timeoutMillis);
        }

        public void setDrawWakeLockOverrideFromSidekick(boolean keepState) {
            PowerManagerService.m7509$$Nest$msetDrawWakeLockOverrideFromSidekickInternal(this.this$0, keepState);
        }

        public void setMaximumScreenOffTimeoutFromDeviceAdmin(int userId, long timeMs) {
            Slog.d(PowerManagerService.TAG, "setMaximumScreenOffTimeoutFromDeviceAdmin userId=" + userId + " timeMs=" + timeMs);
            this.this$0.setMaximumScreenOffTimeoutFromDeviceAdminInternal(userId, timeMs);
        }

        public PowerSaveState getLowPowerState(int serviceType) {
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L6;
            return PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).getBatterySaverPolicy().getBatterySaverPolicy(serviceType);
        L6:
            return new PowerSaveState.Builder().build();
        }

        public void registerLowPowerModeObserver(PowerManagerInternal.LowPowerModeListener listener) {
            if (PowerManagerService.m7437$$Nest$fgetmBatterySaverSupported(this.this$0) == false) goto L5;
            PowerManagerService.m7436$$Nest$fgetmBatterySaverStateMachine(this.this$0).getBatterySaverController().addListener(listener);
            return;
        L5:
            Slog.w(PowerManagerService.TAG, "Battery saver is not supported, no low power mode observer registered");
        }

        public boolean setDeviceIdleMode(boolean enabled) {
            return this.this$0.setDeviceIdleModeInternal(enabled);
        }

        public boolean setLightDeviceIdleMode(boolean enabled) {
            return this.this$0.setLightDeviceIdleModeInternal(enabled);
        }

        public void setDeviceIdleWhitelist(int[] appids) {
            this.this$0.setDeviceIdleWhitelistInternal(appids);
        }

        public void setDeviceIdleTempWhitelist(int[] appids) {
            this.this$0.setDeviceIdleTempWhitelistInternal(appids);
        }

        public void setLowPowerStandbyAllowlist(int[] appids) {
            this.this$0.setLowPowerStandbyAllowlistInternal(appids);
        }

        public void setLowPowerStandbyActive(boolean enabled) {
            this.this$0.setLowPowerStandbyActiveInternal(enabled);
        }

        public void startUidChanges() {
            this.this$0.startUidChangesInternal();
        }

        public void finishUidChanges() {
            this.this$0.finishUidChangesInternal();
        }

        public void updateUidProcState(int uid, int procState) {
            this.this$0.updateUidProcStateInternal(uid, procState);
        }

        public void uidGone(int uid) {
            this.this$0.uidGoneInternal(uid);
        }

        public void uidActive(int uid) {
            this.this$0.uidActiveInternal(uid);
        }

        public void uidIdle(int uid) {
            this.this$0.uidIdleInternal(uid);
        }

        public void setPowerBoost(int boost, int durationMs) {
            PowerManagerService.m7513$$Nest$msetPowerBoostInternal(this.this$0, boost, durationMs);
        }

        public void setPowerMode(int mode, boolean enabled) {
            this.this$0.setPowerModeInternal(mode, enabled);
        }

        public boolean wasDeviceIdleFor(long ms) {
            return this.this$0.wasDeviceIdleForInternal(ms);
        }

        public PowerManager.WakeData getLastWakeup() {
            return PowerManagerService.m7486$$Nest$mgetLastWakeupInternal(this.this$0);
        }

        public PowerManager.SleepData getLastGoToSleep() {
            return PowerManagerService.m7484$$Nest$mgetLastGoToSleepInternal(this.this$0);
        }

        public boolean interceptPowerKeyDown(KeyEvent event) {
            return PowerManagerService.m7494$$Nest$minterceptPowerKeyDownInternal(this.this$0, event);
        }

        public void nap(long eventTime, boolean allowWake) {
            PowerManagerService.m7499$$Nest$mnapInternal(this.this$0, eventTime, 1000, allowWake);
        }

        public boolean isAmbientDisplaySuppressed() {
            return PowerManagerService.m7435$$Nest$fgetmAmbientDisplaySuppressionController(this.this$0).isSuppressed();
        }

        public void setDevicePostured(boolean isPostured) {
            PowerManagerService.m7506$$Nest$msetDevicePosturedInternal(this.this$0, isPostured);
        }

        public void updateSettings() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            PowerManagerService.m7518$$Nest$mupdateSettingsLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void forceDisplaySleep() {
            PowerManagerService.m7481$$Nest$mforceDisplaySleepInternal(this.this$0);
        }

        public void wakeupFromForceDisplaySleep() {
            PowerManagerService.m7525$$Nest$mwakeupFromForceDisplaySleepInternal(this.this$0);
        }

        public ExtPowerManagerInternal getInternalExt() {
            return PowerManagerService.m7448$$Nest$fgetmExt(this.this$0).getInternalExt();
        }
    }

    public static class NativeWrapper {
        public NativeWrapper() {
        }

        public void nativeInit(PowerManagerService service) {
            PowerManagerService.m7500$$Nest$mnativeInit(service);
        }

        public void nativeAcquireSuspendBlocker(String name) {
            PowerManagerService.m7530$$Nest$smnativeAcquireSuspendBlocker(name);
        }

        public void nativeReleaseSuspendBlocker(String name) {
            PowerManagerService.m7532$$Nest$smnativeReleaseSuspendBlocker(name);
        }

        public void nativeSetAutoSuspend(boolean enable) {
            PowerManagerService.m7533$$Nest$smnativeSetAutoSuspend(enable);
        }

        public void nativeSetPowerBoost(int boost, int durationMs) {
            PowerManagerService.m7534$$Nest$smnativeSetPowerBoost(boost, durationMs);
        }

        public boolean nativeSetPowerMode(int mode, boolean enabled) {
            return PowerManagerService.m7535$$Nest$smnativeSetPowerMode(mode, enabled);
        }

        public boolean nativeForceSuspend() {
            return PowerManagerService.m7531$$Nest$smnativeForceSuspend();
        }
    }

    interface PermissionCheckerWrapper {
        int checkPermissionForDataDelivery(Context r1, String r2, int r3, AttributionSource r4, String r5);
    }

    private final class PowerGroupWakefulnessChangeListener implements PowerGroup.PowerGroupListener {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ PowerGroupWakefulnessChangeListener(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private PowerGroupWakefulnessChangeListener(PowerManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.power.PowerGroup.PowerGroupListener
        public void onWakefulnessChangedLocked(int groupId, int wakefulness, long eventTime, int reason, int uid, int opUid, String opPackageName, String details) {
            PowerManagerService.m7475$$Nest$fputmWakefulnessChanging(this.this$0, true);
            this.this$0.mDirty |= 2;
            PowerManagerService.m7451$$Nest$fgetmInjector(this.this$0).invalidateIsInteractiveCaches();
            if (wakefulness == 1) goto L5;
        L12:
            if (wakefulness != 0) goto L17;
            if (reason != 20) goto L17;
            this.this$0.mSleepingForPsensor = true;
        L17:
            if (PowerManagerService.m7459$$Nest$fgetmScreenTimeoutOverridePolicy(this.this$0) == null) goto L20;
            if (groupId != 0) goto L20;
            PowerManagerService.m7459$$Nest$fgetmScreenTimeoutOverridePolicy(this.this$0).onWakefulnessChange(PowerManagerService.m7463$$Nest$fgetmWakeLockSummary(this.this$0), wakefulness);
        L20:
            this.this$0.mDirty |= 65536;
            PowerManagerService.m7457$$Nest$fgetmNotifier(this.this$0).onGroupWakefulnessChangeStarted(groupId, wakefulness, reason, eventTime);
            PowerManagerService.m7517$$Nest$mupdateGlobalWakefulnessLocked(this.this$0, eventTime, reason, uid, opUid, opPackageName, details);
            this.this$0.updatePowerStateLocked();
            return;
        L5:
            if (reason != 13) goto L7;
            int r0 = 1;
        L8:
            int flags = r0;
            PowerManagerService.m7524$$Nest$muserActivityNoUpdateLocked(this.this$0, this.this$0.mPowerGroups.get(groupId), eventTime, 0, flags, uid);
            if (reason != 19) goto L11;
            this.this$0.getSmtEx().mProSensorHelper.stop();
        L11:
            this.this$0.mSleepingForPsensor = false;
            goto L12
        L7:
            r0 = 0;
            goto L8
        }
    }

    private final class PowerManagerHandlerCallback implements Handler.Callback {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ PowerManagerHandlerCallback(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private PowerManagerHandlerCallback(PowerManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 200: goto L5;
                default: goto L29;
            };
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            PowerManagerService.m7520$$Nest$mupdateWakeLockDisabledStatesLocked(this.this$0);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return true;
        L10:
            th = move-exception;
            throw th;
        L13:
            PowerManagerService.m7502$$Nest$mreleaseAllOverrideWakeLocks(this.this$0, msg.arg1);
            return true;
        L14:
            PowerManagerService.m7488$$Nest$mhandleAttentiveTimeout(this.this$0);
            return true;
        L15:
            this.this$0.checkForLongWakeLocks();
            return true;
        L16:
            PowerManagerService.m7491$$Nest$mhandleScreenBrightnessBoostTimeout(this.this$0);
            return true;
        L17:
            PowerManagerService.m7490$$Nest$mhandleSandman(this.this$0, msg.arg1);
            return true;
        L18:
            PowerManagerService.m7492$$Nest$mhandleUserActivityTimeout(this.this$0);
            return true;
        L29:
            return true;
        }
    }

    interface PowerPropertiesWrapper {
        boolean permissionless_turn_screen_on();

        boolean waive_target_sdk_check_for_turn_screen_on();
    }

    private final class PrivateMethodCaller implements IZswPowerManagerService.PrivateMethodCaller {
        final /* synthetic */ PowerManagerService this$0;

        /* synthetic */ PrivateMethodCaller(PowerManagerService r1, PowerManagerServiceIA r2) {
            this(r1);
        }

        private PrivateMethodCaller(PowerManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.power.IZswPowerManagerService.PrivateMethodCaller
        public void updatePowerStateLocked(int dirty) {
            this.this$0.mDirty |= dirty;
            this.this$0.updatePowerStateLocked();
        }

        @Override // com.android.server.power.IZswPowerManagerService.PrivateMethodCaller
        public boolean userActivityNoUpdateLocked(long eventTime, int event, int flags, int uid) {
            return PowerManagerService.m7523$$Nest$muserActivityNoUpdateLocked(this.this$0, eventTime, event, flags, uid);
        }

        @Override // com.android.server.power.IZswPowerManagerService.PrivateMethodCaller
        public void wakePowerGroupLocked(int groupId, long eventTime, int reason, String details, int uid, String opPackageName, int opUid) {
            this.this$0.wakePowerGroupLocked(this.this$0.mPowerGroups.get(groupId), eventTime, reason, details, uid, opPackageName, opUid);
        }

        @Override // com.android.server.power.IZswPowerManagerService.PrivateMethodCaller
        public void goToSleepInternal(IntArray groupIds, long eventTime, int reason, int flags) {
            PowerManagerService.m7487$$Nest$mgoToSleepInternal(this.this$0, groupIds, eventTime, reason, flags);
        }
    }

    private static final class ProfilePowerState {
        long mLastUserActivityTime;
        boolean mLockingNotified;
        long mScreenOffTimeout;
        final int mUserId;
        int mWakeLockSummary;

        public ProfilePowerState(int userId, long screenOffTimeout, long now) {
            this.mUserId = userId;
            this.mScreenOffTimeout = screenOffTimeout;
            this.mLastUserActivityTime = now;
        }
    }

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ PowerManagerService this$0;

        public SettingsObserver(PowerManagerService r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.handleSettingsChangedLocked();     // Catch: Throwable -> L9
            if (uri.equals(Settings.System.getUriFor("screen_brightness_mode")) == false) goto L12;
            if (this.this$0.mScreenBrightnessModeSetting != 0) goto L14;
            this.this$0.getSmtEx().mScreenBrightnessAuto = -1.0f;     // Catch: Throwable -> L9
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (uri.equals(Settings.System.getUriFor("screen_brightness_temp")) == false) goto L14;
            Settings.System.getFloat(this.this$0.mContext.getContentResolver(), "screen_brightness_temp", -1.0f);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    private final class SuspendBlockerImpl implements SuspendBlocker {
        private static final String UNKNOWN_ID = "unknown";
        private final String mName;
        private final int mNameHash;
        private final ArrayMap<String, LongArray> mOpenReferenceTimes;
        private int mReferenceCount;
        final /* synthetic */ PowerManagerService this$0;

        public SuspendBlockerImpl(PowerManagerService r1, String name) {
            this.this$0 = r1;
            this.mOpenReferenceTimes = new ArrayMap();
            this.mName = name;
            this.mNameHash = this.mName.hashCode();
        }

        protected void finalize() throws Throwable {
        L6:
            th = move-exception;
            super.finalize();
            throw th;
        L3:
            if (this.mReferenceCount == 0) goto L8;
            Slog.wtf(PowerManagerService.TAG, "Suspend blocker \"" + this.mName + "\" was finalized without being released!");     // Catch: Throwable -> L6
            this.mReferenceCount = 0;     // Catch: Throwable -> L6
            PowerManagerService.m7456$$Nest$fgetmNativeWrapper(this.this$0).nativeReleaseSuspendBlocker(this.mName);     // Catch: Throwable -> L6
            Trace.asyncTraceForTrackEnd(131072, "SuspendBlockers", this.mNameHash);     // Catch: Throwable -> L6
        L8:
            super.finalize();
        }

        @Override // com.android.server.power.SuspendBlocker
        public void acquire() {
            acquire("unknown");
        }

        @Override // com.android.server.power.SuspendBlocker
        public void acquire(String id) {
            monitor-enter(this);
            recordReferenceLocked(id);     // Catch: Throwable -> L6
            this.mReferenceCount++;     // Catch: Throwable -> L6
            if (this.mReferenceCount != 1) goto L8;
            Trace.asyncTraceForTrackBegin(131072, "SuspendBlockers", this.mName, this.mNameHash);     // Catch: Throwable -> L6
            PowerManagerService.m7456$$Nest$fgetmNativeWrapper(this.this$0).nativeAcquireSuspendBlocker(this.mName);     // Catch: Throwable -> L6
        L8:
            SysOptBridge.getFactory().getPowerManager().updateAcquireWakeLockTimeLocked(this.mName);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.power.SuspendBlocker
        public void release() {
            release("unknown");
        }

        @Override // com.android.server.power.SuspendBlocker
        public void release(String id) {
            monitor-enter(this);
            removeReferenceLocked(id);     // Catch: Throwable -> L8
            SysOptBridge.getFactory().getPowerManager().updateReleaseWakeLockTimeLocked(this.mName);     // Catch: Throwable -> L8
            this.mReferenceCount--;     // Catch: Throwable -> L8
            if (this.mReferenceCount != 0) goto L11;
            PowerManagerService.m7456$$Nest$fgetmNativeWrapper(this.this$0).nativeReleaseSuspendBlocker(this.mName);     // Catch: Throwable -> L8
            if (Trace.isTagEnabled(131072) == false) goto L13;
            Trace.asyncTraceForTrackEnd(131072, "SuspendBlockers", this.mNameHash);     // Catch: Throwable -> L8
        L13:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.mReferenceCount >= 0) goto L13;
            Slog.wtf(PowerManagerService.TAG, "Suspend blocker \"" + this.mName + "\" was released without being acquired!", new Throwable());     // Catch: Throwable -> L8
            this.mReferenceCount = 0;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public String toString() {
            monitor-enter(this);
            StringBuilder builder = new StringBuilder();     // Catch: Throwable -> L12
            builder.append(this.mName);     // Catch: Throwable -> L12
            builder.append(": ref count=");     // Catch: Throwable -> L12
            builder.append(this.mReferenceCount);     // Catch: Throwable -> L12
            builder.append(" [");     // Catch: Throwable -> L12
            int size = this.mOpenReferenceTimes.size();     // Catch: Throwable -> L12
            int i = 0;
        L4:
            if (i >= size) goto L22;
            String id = this.mOpenReferenceTimes.keyAt(i);     // Catch: Throwable -> L12
            LongArray times = this.mOpenReferenceTimes.valueAt(i);     // Catch: Throwable -> L12
            if (times == null) goto L21;
            if (times.size() == 0) goto L21;
            if (i <= 0) goto L14;
            builder.append(", ");     // Catch: Throwable -> L12
        L14:
            builder.append(id);     // Catch: Throwable -> L12
            builder.append(": (");     // Catch: Throwable -> L12
            int j = 0;
        L16:
            if (j >= times.size()) goto L20;
            if (j <= 0) goto L19;
            builder.append(", ");     // Catch: Throwable -> L12
        L19:
            builder.append(PowerManagerService.m7526$$Nest$sfgetDATE_FORMAT().format(new Date(times.get(j))));     // Catch: Throwable -> L12
            j = j + 1;     // Catch: Throwable -> L12
            goto L16
        L20:
            builder.append(")");     // Catch: Throwable -> L12
        L21:
            i = i + 1;     // Catch: Throwable -> L12
            goto L4
        L22:
            builder.append("]");     // Catch: Throwable -> L12
            String r2 = builder.toString();     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return r2;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.power.SuspendBlocker
        public void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long sbToken = proto.start(fieldId);
            monitor-enter(this);
            proto.write(1138166333441L, this.mName);     // Catch: Throwable -> L8
            proto.write(1120986464258L, this.mReferenceCount);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            proto.end(sbToken);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void recordReferenceLocked(String id) {
            LongArray times = this.mOpenReferenceTimes.get(id);
            if (times != null) goto L5;
            times = new LongArray(2);
            this.mOpenReferenceTimes.put(id, times);
        L5:
            times.add(System.currentTimeMillis());
        }

        private void removeReferenceLocked(String id) {
            LongArray times = this.mOpenReferenceTimes.get(id);
            if (times != null) goto L5;
            return;
        L5:
            if (times.size() <= 0) goto L11;
            times.remove(times.size() - 1);
            if (times.size() != 0) goto L12;
            this.mOpenReferenceTimes.remove(id);
            return;
        L12:
            return;
        }
    }

    static final class UidState {
        boolean mActive;
        boolean mFrozen;
        int mNumWakeLocks;
        int mProcState;
        final int mUid;

        UidState(int uid) {
            this.mUid = uid;
        }
    }

    final class UserSwitchedReceiver extends BroadcastReceiver {
        final /* synthetic */ PowerManagerService this$0;

        UserSwitchedReceiver(PowerManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.this$0.handleSettingsChangedLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class WakeLock implements IBinder.DeathRecipient {
        public long mAcquireTime;
        public IWakeLockCallback mCallback;
        public boolean mDisabled;
        public final int mDisplayId;
        public int mFlags;
        public String mHistoryTag;
        public final IBinder mLock;
        public boolean mNotifiedAcquired;
        public boolean mNotifiedLong;
        public final int mOwnerPid;
        public final int mOwnerUid;
        public final String mPackageName;
        public String mTag;
        public final UidState mUidState;
        public WorkSource mWorkSource;
        final /* synthetic */ PowerManagerService this$0;

        public WakeLock(PowerManagerService this$0, IBinder lock, int displayId, int flags, String tag, String packageName, WorkSource workSource, String historyTag, int ownerUid, int ownerPid, UidState uidState, IWakeLockCallback callback) {
            this.this$0 = this$0;
            this.mLock = lock;
            this.mDisplayId = displayId;
            this.mFlags = flags;
            this.mTag = tag;
            this.mPackageName = packageName;
            this.mWorkSource = PowerManagerService.m7529$$Nest$smcopyWorkSource(workSource);
            this.mHistoryTag = historyTag;
            this.mOwnerUid = ownerUid;
            this.mOwnerPid = ownerPid;
            this.mUidState = uidState;
            this.mCallback = callback;
            linkToDeath();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            unlinkToDeath();
            PowerManagerService.m7493$$Nest$mhandleWakeLockDeath(this.this$0, this);
        }

        private void linkToDeath() {
            this.mLock.linkToDeath(this, 0);     // Catch: RemoteException -> L4
            return;
        L6:
            throw new IllegalArgumentException("Wakelock.mLock is already dead.");
        }

        void unlinkToDeath() {
            this.mLock.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
            return;
        L4:
            e = move-exception;
            Slog.wtf(PowerManagerService.TAG, "Failed to unlink Wakelock.mLock", e);
        }

        public boolean setDisabled(boolean disabled) {
            if (this.mDisabled == disabled) goto L6;
            this.mDisabled = disabled;
            return true;
        L6:
            return false;
        }

        public boolean hasSameProperties(int flags, String tag, WorkSource workSource, int ownerUid, int ownerPid, IWakeLockCallback callback) {
            if (this.mFlags == flags) goto L5;
        L13:
            return false;
        L5:
            if (this.mTag.equals(tag) == false) goto L13;
            if (hasSameWorkSource(workSource) == false) goto L13;
            if (this.mOwnerUid != ownerUid) goto L13;
            if (this.mOwnerPid != ownerPid) goto L13;
            return true;
        }

        public void updateProperties(int flags, String tag, String packageName, WorkSource workSource, String historyTag, int ownerUid, int ownerPid, IWakeLockCallback callback) {
            if (this.mPackageName.equals(packageName) == false) goto L15;
            if (this.mOwnerUid != ownerUid) goto L13;
            if (this.mOwnerPid != ownerPid) goto L11;
            this.mFlags = flags;
            this.mTag = tag;
            updateWorkSource(workSource);
            this.mHistoryTag = historyTag;
            this.mCallback = callback;
            return;
        L11:
            throw new IllegalStateException("Existing wake lock pid changed: " + this.mOwnerPid + " to " + ownerPid);
        L13:
            throw new IllegalStateException("Existing wake lock uid changed: " + this.mOwnerUid + " to " + ownerUid);
        L15:
            throw new IllegalStateException("Existing wake lock package name changed: " + this.mPackageName + " to " + packageName);
        }

        public boolean hasSameWorkSource(WorkSource workSource) {
            return Objects.equals(this.mWorkSource, workSource);
        }

        public void updateWorkSource(WorkSource workSource) {
            this.mWorkSource = PowerManagerService.m7529$$Nest$smcopyWorkSource(workSource);
        }

        public Integer getPowerGroupId() {
            if (PowerManagerService.m7462$$Nest$fgetmSystemReady(this.this$0) == false) goto L14;
            if (this.mDisplayId == (-1)) goto L14;
            DisplayInfo displayInfo = this.this$0.mDisplayManagerInternal.getDisplayInfo(this.mDisplayId);
            if (displayInfo != null) goto L10;
            return null;
        L10:
            return Integer.valueOf(displayInfo.displayGroupId);
        L14:
            return -1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getLockLevelString());
            sb.append(" '");
            sb.append(this.mTag);
            sb.append("'");
            sb.append(getLockFlagsString());
            if (this.mDisabled == false) goto L6;
            sb.append(" DISABLED");
        L6:
            if (this.mNotifiedAcquired == false) goto L9;
            sb.append(" ACQ=");
            TimeUtils.formatDuration(this.mAcquireTime - PowerManagerService.m7440$$Nest$fgetmClock(this.this$0).uptimeMillis(), sb);
        L9:
            if (this.mNotifiedLong == false) goto L11;
            sb.append(" LONG");
        L11:
            sb.append(" (uid=");
            sb.append(this.mOwnerUid);
            sb.append(" pkg=");
            sb.append(this.mPackageName);
            if (this.mOwnerPid == 0) goto L15;
            sb.append(" pid=");
            sb.append(this.mOwnerPid);
        L15:
            if (this.mWorkSource == null) goto L17;
            sb.append(" ws=");
            sb.append(this.mWorkSource);
        L17:
            sb.append(")");
            return sb.toString();
        }

        public void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long wakeLockToken = proto.start(fieldId);
            proto.write(1159641169921L, this.mFlags & 65535);
            proto.write(1138166333442L, this.mTag);
            long wakeLockFlagsToken = proto.start(1146756268035L);
            boolean r5 = false;
            if ((this.mFlags & 268435456) == 0) goto L5;
            boolean r4 = true;
        L6:
            proto.write(1133871366145L, r4);
            if ((this.mFlags & 536870912) == 0) goto L9;
            boolean r6 = true;
        L10:
            proto.write(1133871366146L, r6);
            if ((this.mFlags & Integer.MIN_VALUE) == 0) goto L13;
            r5 = true;
        L13:
            proto.write(1133871366147L, r5);
            proto.end(wakeLockFlagsToken);
            proto.write(1133871366148L, this.mDisabled);
            if (this.mNotifiedAcquired == false) goto L16;
            proto.write(1112396529669L, this.mAcquireTime);
        L16:
            proto.write(1133871366150L, this.mNotifiedLong);
            proto.write(1120986464263L, this.mOwnerUid);
            proto.write(1120986464264L, this.mOwnerPid);
            if (this.mWorkSource == null) goto L19;
            this.mWorkSource.dumpDebug(proto, 1146756268041L);
        L19:
            proto.end(wakeLockToken);
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r4 = false;
            goto L6
        }

        private String getLockLevelString() {
            switch((this.mFlags & 65535)) {
                case 1: goto L20;
                case 6: goto L18;
                case 10: goto L16;
                case 26: goto L14;
                case 32: goto L12;
                case 64: goto L10;
                case 128: goto L8;
                case 256: goto L6;
                default: goto L4;
            };
        L4:
            return "???                              ";
        L6:
            return "SCREEN_TIMEOUT_OVERRIDE_WAKE_LOCK";
        L8:
            return "DRAW_WAKE_LOCK                   ";
        L10:
            return "DOZE_WAKE_LOCK                   ";
        L12:
            return "PROXIMITY_SCREEN_OFF_WAKE_LOCK   ";
        L14:
            return "FULL_WAKE_LOCK                   ";
        L16:
            return "SCREEN_BRIGHT_WAKE_LOCK          ";
        L18:
            return "SCREEN_DIM_WAKE_LOCK             ";
        L20:
            return "PARTIAL_WAKE_LOCK                ";
        }

        private String getLockFlagsString() {
            String result = "";
            if ((this.mFlags & 268435456) == 0) goto L6;
            result = " ACQUIRE_CAUSES_WAKEUP";
        L6:
            if ((this.mFlags & 536870912) == 0) goto L9;
            result = result + " ON_AFTER_RELEASE";
        L9:
            if ((this.mFlags & Integer.MIN_VALUE) != 0) goto L11;
            return result;
        L11:
            return result + " SYSTEM_WAKELOCK";
        }
    }

    public static /* synthetic */ void $r8$lambda$0JGrQAIQ8EZVc3mZTzxzsJneY2I(PowerManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$3liLNXR9Xdg5WdaPUHiY0gp1K-I, reason: not valid java name */
    public static /* synthetic */ void m7432$r8$lambda$3liLNXR9Xdg5WdaPUHiY0gp1KI(PowerManagerService r0) {
        r0.lambda$systemReady$2();
    }

    public static /* synthetic */ void $r8$lambda$4GsS2JKyVK8OBvDP2H2Jr4yhNok(PowerManagerService r0, int r1) {
        r0.lambda$systemReady$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$ISKUWRqC06iRZjg7fRWTYaRayo4(PowerManagerService r0, boolean r1) {
        r0.onFlip(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$WMwmGP2zFTOVuGH-zaOZvqGXfAo, reason: not valid java name */
    public static /* synthetic */ void m7433$r8$lambda$WMwmGP2zFTOVuGHzaOZvqGXfAo(PowerManagerService r0, int r1, int r2, float r3, int r4, boolean r5) {
        r0.setDozeOverrideFromDreamManagerInternal(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$tMJINFgOcVIz9J8H8BZsW3MK8Cw(PowerManagerService r0) {
        r0.onUserAttention();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAmbientDisplayConfiguration, reason: not valid java name */
    static /* bridge */ /* synthetic */ AmbientDisplayConfiguration m7434$$Nest$fgetmAmbientDisplayConfiguration(PowerManagerService r0) {
        return r0.mAmbientDisplayConfiguration;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAmbientDisplaySuppressionController, reason: not valid java name */
    static /* bridge */ /* synthetic */ AmbientDisplaySuppressionController m7435$$Nest$fgetmAmbientDisplaySuppressionController(PowerManagerService r0) {
        return r0.mAmbientDisplaySuppressionController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatterySaverStateMachine, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatterySaverStateMachine m7436$$Nest$fgetmBatterySaverStateMachine(PowerManagerService r0) {
        return r0.mBatterySaverStateMachine;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatterySaverSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7437$$Nest$fgetmBatterySaverSupported(PowerManagerService r0) {
        return r0.mBatterySaverSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBatteryStats m7438$$Nest$fgetmBatteryStats(PowerManagerService r0) {
        return r0.mBatteryStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7439$$Nest$fgetmBootCompleted(PowerManagerService r0) {
        return r0.mBootCompleted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m7440$$Nest$fgetmClock(PowerManagerService r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDecoupleHalAutoSuspendModeFromDisplayConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7441$$Nest$fgetmDecoupleHalAutoSuspendModeFromDisplayConfig(PowerManagerService r0) {
        return r0.mDecoupleHalAutoSuspendModeFromDisplayConfig;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDecoupleHalInteractiveModeFromDisplayConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7442$$Nest$fgetmDecoupleHalInteractiveModeFromDisplayConfig(PowerManagerService r0) {
        return r0.mDecoupleHalInteractiveModeFromDisplayConfig;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplaySuspendBlocker, reason: not valid java name */
    static /* bridge */ /* synthetic */ SuspendBlocker m7443$$Nest$fgetmDisplaySuspendBlocker(PowerManagerService r0) {
        return r0.mDisplaySuspendBlocker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7444$$Nest$fgetmDockState(PowerManagerService r0) {
        return r0.mDockState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnhancedDischargePredictionIsPersonalized, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7445$$Nest$fgetmEnhancedDischargePredictionIsPersonalized(PowerManagerService r0) {
        return r0.mEnhancedDischargePredictionIsPersonalized;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnhancedDischargeTimeElapsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7446$$Nest$fgetmEnhancedDischargeTimeElapsed(PowerManagerService r2) {
        return r2.mEnhancedDischargeTimeElapsed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnhancedDischargeTimeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7447$$Nest$fgetmEnhancedDischargeTimeLock(PowerManagerService r0) {
        return r0.mEnhancedDischargeTimeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtPowerManagerService m7448$$Nest$fgetmExt(PowerManagerService r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFaceDownDetector, reason: not valid java name */
    static /* bridge */ /* synthetic */ FaceDownDetector m7449$$Nest$fgetmFaceDownDetector(PowerManagerService r0) {
        return r0.mFaceDownDetector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFeatureFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerFlags m7450$$Nest$fgetmFeatureFlags(PowerManagerService r0) {
        return r0.mFeatureFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m7451$$Nest$fgetmInjector(PowerManagerService r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsPowered, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7452$$Nest$fgetmIsPowered(PowerManagerService r0) {
        return r0.mIsPowered;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastEnhancedDischargeTimeUpdatedElapsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7453$$Nest$fgetmLastEnhancedDischargeTimeUpdatedElapsed(PowerManagerService r2) {
        return r2.mLastEnhancedDischargeTimeUpdatedElapsed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastWarningAboutUserActivityPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7454$$Nest$fgetmLastWarningAboutUserActivityPermission(PowerManagerService r2) {
        return r2.mLastWarningAboutUserActivityPermission;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLowPowerStandbyController, reason: not valid java name */
    static /* bridge */ /* synthetic */ LowPowerStandbyController m7455$$Nest$fgetmLowPowerStandbyController(PowerManagerService r0) {
        return r0.mLowPowerStandbyController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNativeWrapper, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeWrapper m7456$$Nest$fgetmNativeWrapper(PowerManagerService r0) {
        return r0.mNativeWrapper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotifier, reason: not valid java name */
    static /* bridge */ /* synthetic */ Notifier m7457$$Nest$fgetmNotifier(PowerManagerService r0) {
        return r0.mNotifier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerGroupWakefulnessChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerGroupWakefulnessChangeListener m7458$$Nest$fgetmPowerGroupWakefulnessChangeListener(PowerManagerService r0) {
        return r0.mPowerGroupWakefulnessChangeListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScreenTimeoutOverridePolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScreenTimeoutOverridePolicy m7459$$Nest$fgetmScreenTimeoutOverridePolicy(PowerManagerService r0) {
        return r0.mScreenTimeoutOverridePolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSmtEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerServiceSmtEx m7460$$Nest$fgetmSmtEx(PowerManagerService r0) {
        return r0.mSmtEx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSuspendBlockers, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m7461$$Nest$fgetmSuspendBlockers(PowerManagerService r0) {
        return r0.mSuspendBlockers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7462$$Nest$fgetmSystemReady(PowerManagerService r0) {
        return r0.mSystemReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakeLockSummary, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7463$$Nest$fgetmWakeLockSummary(PowerManagerService r0) {
        return r0.mWakeLockSummary;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmZswExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IZswPowerManagerService m7464$$Nest$fgetmZswExt(PowerManagerService r0) {
        return r0.mZswExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7465$$Nest$fputmDockState(PowerManagerService r0, int r1) {
        r0.mDockState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEnhancedDischargePredictionIsPersonalized, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7466$$Nest$fputmEnhancedDischargePredictionIsPersonalized(PowerManagerService r0, boolean r1) {
        r0.mEnhancedDischargePredictionIsPersonalized = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEnhancedDischargeTimeElapsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7467$$Nest$fputmEnhancedDischargeTimeElapsed(PowerManagerService r0, long r1) {
        r0.mEnhancedDischargeTimeElapsed = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmForegroundProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7468$$Nest$fputmForegroundProfile(PowerManagerService r0, int r1) {
        r0.mForegroundProfile = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInterceptedPowerKeyForProximity, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7469$$Nest$fputmInterceptedPowerKeyForProximity(PowerManagerService r0, boolean r1) {
        r0.mInterceptedPowerKeyForProximity = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmKeepDreamingWhenUnplugging, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7470$$Nest$fputmKeepDreamingWhenUnplugging(PowerManagerService r0, boolean r1) {
        r0.mKeepDreamingWhenUnplugging = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastEnhancedDischargeTimeUpdatedElapsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7471$$Nest$fputmLastEnhancedDischargeTimeUpdatedElapsed(PowerManagerService r0, long r1) {
        r0.mLastEnhancedDischargeTimeUpdatedElapsed = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastWarningAboutUserActivityPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7472$$Nest$fputmLastWarningAboutUserActivityPermission(PowerManagerService r0, long r1) {
        r0.mLastWarningAboutUserActivityPermission = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProximityPositive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7473$$Nest$fputmProximityPositive(PowerManagerService r0, boolean r1) {
        r0.mProximityPositive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7474$$Nest$fputmUserId(PowerManagerService r0, int r1) {
        r0.mUserId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWakefulnessChanging, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7475$$Nest$fputmWakefulnessChanging(PowerManagerService r0, boolean r1) {
        r0.mWakefulnessChanging = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$macquireWakeLockInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7476$$Nest$macquireWakeLockInternal(PowerManagerService r0, IBinder r1, int r2, int r3, String r4, String r5, WorkSource r6, String r7, int r8, int r9, IWakeLockCallback r10) {
        r0.acquireWakeLockInternal(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: -$$Nest$mboostScreenBrightnessInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7477$$Nest$mboostScreenBrightnessInternal(PowerManagerService r0, long r1, int r3) {
        r0.boostScreenBrightnessInternal(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcrashInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7478$$Nest$mcrashInternal(PowerManagerService r0, String r1) {
        r0.crashInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7479$$Nest$mdumpInternal(PowerManagerService r0, PrintWriter r1) {
        r0.dumpInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpProto, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7480$$Nest$mdumpProto(PowerManagerService r0, FileDescriptor r1) {
        r0.dumpProto(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mforceDisplaySleepInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7481$$Nest$mforceDisplaySleepInternal(PowerManagerService r0) {
        r0.forceDisplaySleepInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mforceSuspendInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7482$$Nest$mforceSuspendInternal(PowerManagerService r0, int r1) {
        return r0.forceSuspendInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDisplayGroupId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7483$$Nest$mgetDisplayGroupId(PowerManagerService r0, int r1) {
        return r0.getDisplayGroupId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLastGoToSleepInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.SleepData m7484$$Nest$mgetLastGoToSleepInternal(PowerManagerService r0) {
        return r0.getLastGoToSleepInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLastSleepReasonInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7485$$Nest$mgetLastSleepReasonInternal(PowerManagerService r0) {
        return r0.getLastSleepReasonInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLastWakeupInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeData m7486$$Nest$mgetLastWakeupInternal(PowerManagerService r0) {
        return r0.getLastWakeupInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgoToSleepInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7487$$Nest$mgoToSleepInternal(PowerManagerService r0, IntArray r1, long r2, int r4, int r5) {
        r0.goToSleepInternal(r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAttentiveTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7488$$Nest$mhandleAttentiveTimeout(PowerManagerService r0) {
        r0.handleAttentiveTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBatteryStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7489$$Nest$mhandleBatteryStateChangedLocked(PowerManagerService r0) {
        r0.handleBatteryStateChangedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSandman, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7490$$Nest$mhandleSandman(PowerManagerService r0, int r1) {
        r0.handleSandman(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScreenBrightnessBoostTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7491$$Nest$mhandleScreenBrightnessBoostTimeout(PowerManagerService r0) {
        r0.handleScreenBrightnessBoostTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUserActivityTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7492$$Nest$mhandleUserActivityTimeout(PowerManagerService r0) {
        r0.handleUserActivityTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleWakeLockDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7493$$Nest$mhandleWakeLockDeath(PowerManagerService r0, WakeLock r1) {
        r0.handleWakeLockDeath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minterceptPowerKeyDownInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7494$$Nest$minterceptPowerKeyDownInternal(PowerManagerService r0, KeyEvent r1) {
        return r0.interceptPowerKeyDownInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misInteractiveInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7495$$Nest$misInteractiveInternal(PowerManagerService r0, int r1, int r2) {
        return r0.isInteractiveInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misScreenBrightnessBoostedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7496$$Nest$misScreenBrightnessBoostedInternal(PowerManagerService r0) {
        return r0.isScreenBrightnessBoostedInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$misWakeLockLevelSupportedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7497$$Nest$misWakeLockLevelSupportedInternal(PowerManagerService r0, int r1, int r2) {
        return r0.isWakeLockLevelSupportedInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeUpdateForegroundProfileLastActivityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7498$$Nest$mmaybeUpdateForegroundProfileLastActivityLocked(PowerManagerService r0, long r1) {
        r0.maybeUpdateForegroundProfileLastActivityLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnapInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7499$$Nest$mnapInternal(PowerManagerService r0, long r1, int r3, boolean r4) {
        r0.napInternal(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mnativeInit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7500$$Nest$mnativeInit(PowerManagerService r0) {
        r0.nativeInit();
    }

    /* JADX INFO: renamed from: -$$Nest$monDreamSuppressionChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7501$$Nest$monDreamSuppressionChangedLocked(PowerManagerService r0, boolean r1) {
        r0.onDreamSuppressionChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseAllOverrideWakeLocks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7502$$Nest$mreleaseAllOverrideWakeLocks(PowerManagerService r0, int r1) {
        r0.releaseAllOverrideWakeLocks(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseWakeLockInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7503$$Nest$mreleaseWakeLockInternal(PowerManagerService r0, IBinder r1, int r2) {
        r0.releaseWakeLockInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleSandmanLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7504$$Nest$mscheduleSandmanLocked(PowerManagerService r0) {
        r0.scheduleSandmanLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$msetAttentionLightInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7505$$Nest$msetAttentionLightInternal(PowerManagerService r0, boolean r1, int r2) {
        r0.setAttentionLightInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDevicePosturedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7506$$Nest$msetDevicePosturedInternal(PowerManagerService r0, boolean r1) {
        r0.setDevicePosturedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDozeAfterScreenOffInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7507$$Nest$msetDozeAfterScreenOffInternal(PowerManagerService r0, boolean r1) {
        r0.setDozeAfterScreenOffInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDozeOverrideFromDreamManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7508$$Nest$msetDozeOverrideFromDreamManagerInternal(PowerManagerService r0, int r1, int r2, float r3, int r4, boolean r5) {
        r0.setDozeOverrideFromDreamManagerInternal(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDrawWakeLockOverrideFromSidekickInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7509$$Nest$msetDrawWakeLockOverrideFromSidekickInternal(PowerManagerService r0, boolean r1) {
        r0.setDrawWakeLockOverrideFromSidekickInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetHalAutoSuspendModeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7510$$Nest$msetHalAutoSuspendModeLocked(PowerManagerService r0, boolean r1) {
        r0.setHalAutoSuspendModeLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetHalInteractiveModeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7511$$Nest$msetHalInteractiveModeLocked(PowerManagerService r0, boolean r1) {
        r0.setHalInteractiveModeLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetLowPowerModeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7512$$Nest$msetLowPowerModeInternal(PowerManagerService r0, boolean r1) {
        return r0.setLowPowerModeInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetPowerBoostInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7513$$Nest$msetPowerBoostInternal(PowerManagerService r0, int r1, int r2) {
        r0.setPowerBoostInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUserActivityTimeoutOverrideFromWindowManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7514$$Nest$msetUserActivityTimeoutOverrideFromWindowManagerInternal(PowerManagerService r0, long r1) {
        r0.setUserActivityTimeoutOverrideFromWindowManagerInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUserInactiveOverrideFromWindowManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7515$$Nest$msetUserInactiveOverrideFromWindowManagerInternal(PowerManagerService r0) {
        r0.setUserInactiveOverrideFromWindowManagerInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mshutdownOrRebootInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7516$$Nest$mshutdownOrRebootInternal(PowerManagerService r0, int r1, boolean r2, String r3, boolean r4) {
        r0.shutdownOrRebootInternal(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateGlobalWakefulnessLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7517$$Nest$mupdateGlobalWakefulnessLocked(PowerManagerService r0, long r1, int r3, int r4, int r5, String r6, String r7) {
        r0.updateGlobalWakefulnessLocked(r1, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7518$$Nest$mupdateSettingsLocked(PowerManagerService r0) {
        r0.updateSettingsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateWakeLockCallbackInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7519$$Nest$mupdateWakeLockCallbackInternal(PowerManagerService r0, IBinder r1, IWakeLockCallback r2, int r3) {
        r0.updateWakeLockCallbackInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateWakeLockDisabledStatesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7520$$Nest$mupdateWakeLockDisabledStatesLocked(PowerManagerService r0) {
        r0.updateWakeLockDisabledStatesLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateWakeLockWorkSourceInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7521$$Nest$mupdateWakeLockWorkSourceInternal(PowerManagerService r0, IBinder r1, WorkSource r2, String r3, int r4) {
        r0.updateWakeLockWorkSourceInternal(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$muserActivityInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7522$$Nest$muserActivityInternal(PowerManagerService r0, int r1, long r2, int r4, int r5, int r6) {
        r0.userActivityInternal(r1, r2, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$muserActivityNoUpdateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7523$$Nest$muserActivityNoUpdateLocked(PowerManagerService r0, long r1, int r3, int r4, int r5) {
        return r0.userActivityNoUpdateLocked(r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$muserActivityNoUpdateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7524$$Nest$muserActivityNoUpdateLocked(PowerManagerService r0, PowerGroup r1, long r2, int r4, int r5, int r6) {
        return r0.userActivityNoUpdateLocked(r1, r2, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mwakeupFromForceDisplaySleepInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7525$$Nest$mwakeupFromForceDisplaySleepInternal(PowerManagerService r0) {
        r0.wakeupFromForceDisplaySleepInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDATE_FORMAT, reason: not valid java name */
    static /* bridge */ /* synthetic */ SimpleDateFormat m7526$$Nest$sfgetDATE_FORMAT() {
        return DATE_FORMAT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEFAULT_DISPLAY_GROUP_IDS, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntArray m7527$$Nest$sfgetDEFAULT_DISPLAY_GROUP_IDS() {
        return DEFAULT_DISPLAY_GROUP_IDS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsQuiescent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7528$$Nest$sfgetsQuiescent() {
        return sQuiescent;
    }

    /* JADX INFO: renamed from: -$$Nest$smcopyWorkSource, reason: not valid java name */
    static /* bridge */ /* synthetic */ WorkSource m7529$$Nest$smcopyWorkSource(WorkSource r0) {
        return copyWorkSource(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAcquireSuspendBlocker, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7530$$Nest$smnativeAcquireSuspendBlocker(String r0) {
        nativeAcquireSuspendBlocker(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeForceSuspend, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7531$$Nest$smnativeForceSuspend() {
        return nativeForceSuspend();
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeReleaseSuspendBlocker, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7532$$Nest$smnativeReleaseSuspendBlocker(String r0) {
        nativeReleaseSuspendBlocker(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeSetAutoSuspend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7533$$Nest$smnativeSetAutoSuspend(boolean r0) {
        nativeSetAutoSuspend(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeSetPowerBoost, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7534$$Nest$smnativeSetPowerBoost(int r0, int r1) {
        nativeSetPowerBoost(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeSetPowerMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7535$$Nest$smnativeSetPowerMode(int r0, boolean r1) {
        return nativeSetPowerMode(r0, r1);
    }

    private static native void nativeAcquireSuspendBlocker(String r0);

    private static native boolean nativeForceSuspend();

    private native void nativeInit();

    private static native void nativeReleaseSuspendBlocker(String r0);

    private static native void nativeSetAutoSuspend(boolean r0);

    private static native void nativeSetPowerBoost(int r0, int r1);

    private static native boolean nativeSetPowerMode(int r0, boolean r1);

    static {
        DATE_FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        DEFAULT_DISPLAY_GROUP_IDS = IntArray.wrap(new int[]{0});
    }

    public PowerManagerService(Context context) {
        this(context, new Injector());
    }

    PowerManagerService(Context context, Injector injector) {
        super(context);
        this.mLock = LockGuard.installNewLock(1);
        this.mSuspendBlockers = new ArrayList();
        this.mWakeLocks = new ArrayList();
        this.mEnhancedDischargeTimeLock = new Object();
        this.mDockState = 0;
        this.mMaximumScreenOffTimeoutFromDeviceAdmin = Long.MAX_VALUE;
        this.mIsFaceDown = false;
        this.mLastFlipTime = 0;
        this.mOverriddenTimeout = -1;
        this.mUserActivityTimeoutOverrideFromWindowManager = -1;
        this.mDozeScreenStateOverrideFromDreamManager = 0;
        this.mDozeScreenStateOverrideReasonFromDreamManager = 0;
        this.mDozeScreenBrightnessOverrideFromDreamManager = -1;
        this.mDozeScreenBrightnessOverrideFromDreamManagerFloat = Float.NaN;
        this.mLastWarningAboutUserActivityPermission = Long.MIN_VALUE;
        this.mDeviceIdleWhitelist = new int[0];
        this.mDeviceIdleTempWhitelist = new int[0];
        this.mLowPowerStandbyAllowlist = new int[0];
        this.mUidState = new SparseArray();
        this.mPowerGroups = new SparseArray();
        this.mProfilePowerState = new SparseArray();
        this.mDisplayPowerCallbacks = new AnonymousClass1(this);
        this.mAmbientSuppressionChangedCallback = new AnonymousClass4(this);
        this.mSleepingForPsensor = false;
        this.mExt = (IExtPowerManagerService) ExtImplFactory.getImpl(IExtPowerManagerService.class, new Object[]{this});
        this.mContext = context;
        this.mBinderService = new BinderService(this, this.mContext);
        this.mLocalService = new LocalService(this);
        this.mNativeWrapper = injector.createNativeWrapper();
        this.mSystemProperties = injector.createSystemPropertiesWrapper();
        this.mClock = injector.createClock();
        this.mFeatureFlags = injector.getFlags();
        this.mInjector = injector;
        this.mHandlerThread = new ServiceThread(TAG, -4, false);
        this.mHandlerThread.start();
        PowerManagerServiceIA r5 = null;
        this.mHandler = injector.createHandler(this.mHandlerThread.getLooper(), new PowerManagerHandlerCallback(this, r5));
        this.mConstants = new Constants(this, this.mHandler);
        this.mFoldGracePeriodProvider = injector.createFoldGracePeriodProvider();
        this.mAmbientDisplayConfiguration = this.mInjector.createAmbientDisplayConfiguration(context);
        this.mAmbientDisplaySuppressionController = this.mInjector.createAmbientDisplaySuppressionController(this.mAmbientSuppressionChangedCallback);
        this.mAttentionDetector = new AttentionDetector(new PowerManagerService$$ExternalSyntheticLambda0(this), this.mLock);
        this.mFaceDownDetector = new FaceDownDetector(new PowerManagerService$$ExternalSyntheticLambda1(this));
        this.mScreenUndimDetector = new ScreenUndimDetector();
        this.mBatterySaverSupported = this.mContext.getResources().getBoolean(R.bool.config_batterySaver_full_deferKeyValueBackup);
        if (this.mBatterySaverSupported == false) goto L5;
        BatterySaverStateMachine r3 = this.mInjector.createBatterySaverStateMachine(this.mLock, this.mContext);
    L6:
        this.mBatterySaverStateMachine = r3;
        if (this.mBatterySaverSupported == false) goto L9;
        BatterySaverController r4 = this.mBatterySaverStateMachine.getBatterySaverController();
    L10:
        this.mSmtEx = new PowerManagerServiceSmtEx(this, r4, this.mHandler, this.mLock);
        this.mSmtEx.setContext(this.mContext);
        SysOptBridge.getFactory().getPowerManager().init(this.mContext, this);
        this.mLowPowerStandbyController = this.mInjector.createLowPowerStandbyController(this.mContext, Looper.getMainLooper());
        this.mInattentiveSleepWarningOverlayController = this.mInjector.createInattentiveSleepWarningController();
        this.mPermissionCheckerWrapper = this.mInjector.createPermissionCheckerWrapper();
        this.mPowerPropertiesWrapper = this.mInjector.createPowerPropertiesWrapper();
        this.mDeviceConfigProvider = this.mInjector.createDeviceConfigParameterProvider();
        this.mPowerGroupWakefulnessChangeListener = new PowerGroupWakefulnessChangeListener(this, r5);
        this.mUseAutoSuspend = this.mContext.getResources().getBoolean(R.bool.config_useVolumeKeySounds);
        float min = this.mContext.getResources().getFloat(R.dimen.emphasized_button_stroke_width);
        float max = this.mContext.getResources().getFloat(R.dimen.edit_text_inset_top_material);
        float def = this.mContext.getResources().getFloat(R.dimen.edit_text_inset_horizontal_material);
        float dim = this.mContext.getResources().getFloat(R.dimen.dropdownitem_text_padding_left);
        if (min != (-2.0f)) goto L13;
    L18:
        this.mScreenBrightnessMinimum = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_showOperatorNameDefault));
        this.mScreenBrightnessMaximum = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_shortPressOnSleepBehavior));
        this.mScreenBrightnessDefault = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_shortPressOnPowerBehavior));
    L20:
        if (dim != (-2.0f)) goto L22;
        this.mScreenBrightnessDim = BrightnessSynchronizer.brightnessIntToFloat(this.mContext.getResources().getInteger(R.integer.config_selected_udfps_touch_detection));
    L23:
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mBootingSuspendBlocker = this.mInjector.createSuspendBlocker(this, "PowerManagerService.Booting");     // Catch: Throwable -> L28
        this.mWakeLockSuspendBlocker = this.mInjector.createSuspendBlocker(this, "PowerManagerService.WakeLocks");     // Catch: Throwable -> L28
        this.mDisplaySuspendBlocker = this.mInjector.createSuspendBlocker(this, "PowerManagerService.Display");     // Catch: Throwable -> L28
        if (this.mBootingSuspendBlocker == null) goto L31;
        this.mBootingSuspendBlocker.acquire();     // Catch: Throwable -> L28
        this.mHoldingBootingSuspendBlocker = true;     // Catch: Throwable -> L28
    L31:
        if (this.mDisplaySuspendBlocker == null) goto L33;
        this.mDisplaySuspendBlocker.acquire(HOLDING_DISPLAY_SUSPEND_BLOCKER);     // Catch: Throwable -> L28
        this.mHoldingDisplaySuspendBlocker = true;     // Catch: Throwable -> L28
    L33:
        this.mHalAutoSuspendModeEnabled = false;     // Catch: Throwable -> L28
        this.mHalInteractiveModeEnabled = true;     // Catch: Throwable -> L28
        this.mWakefulnessRaw = 1;     // Catch: Throwable -> L28
        sQuiescent = this.mSystemProperties.get(SYSTEM_PROPERTY_QUIESCENT, "0").equals("1");     // Catch: Throwable -> L28
        this.mNativeWrapper.nativeInit(this);     // Catch: Throwable -> L28
        this.mNativeWrapper.nativeSetAutoSuspend(false);     // Catch: Throwable -> L28
        this.mNativeWrapper.nativeSetPowerMode(7, true);     // Catch: Throwable -> L28
        this.mNativeWrapper.nativeSetPowerMode(0, false);     // Catch: Throwable -> L28
        this.mInjector.invalidateIsInteractiveCaches();     // Catch: Throwable -> L28
        monitor-exit(r6);     // Catch: Throwable -> L28
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswPowerManagerService(this, this.mContext, this.mHandler, this.mLock, new PrivateMethodCaller(this, r5));
        return;
    L28:
        th = move-exception;
        throw th;
    L22:
        this.mScreenBrightnessDim = dim;
        goto L23
    L13:
        if (max == (-2.0f)) goto L18;
        if (def == (-2.0f)) goto L18;
        this.mScreenBrightnessMinimum = min;
        this.mScreenBrightnessMaximum = max;
        this.mScreenBrightnessDefault = def;
        goto L20
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private void onFlip(boolean isFaceDown) {
        long millisUntilNormalTimeout = 0;
        Object r9 = this.mLock;
        monitor-enter(r9);
    L8:
        th = th;
    L26:
        monitor-exit(r9);     // Catch: Throwable -> L8
        throw th;
    L5:
        if (this.mBootCompleted == true) goto L10;
        monitor-exit(r9);     // Catch: Throwable -> L8
        return;
    L10:
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L8
        r4.append("onFlip(): Face ");     // Catch: Throwable -> L8
        if (isFaceDown == false) goto L13;
        String r5 = "down.";
    L14:
        r4.append(r5);     // Catch: Throwable -> L8
        Slog.i(TAG, r4.toString());     // Catch: Throwable -> L8
        this.mIsFaceDown = isFaceDown;     // Catch: Throwable -> L8
        if (isFaceDown == false) goto L22;
        long currentTime = this.mClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mLastFlipTime = currentTime;     // Catch: Throwable -> L8
        long sleepTimeout = getSleepTimeoutLocked(-1);     // Catch: Throwable -> L8
        long screenOffTimeout = getScreenOffTimeoutLocked(sleepTimeout, -1);     // Catch: Throwable -> L8
        PowerGroup powerGroup = this.mPowerGroups.get(0);     // Catch: Throwable -> L8
        long millisUntilNormalTimeout2 = (powerGroup.getLastUserActivityTimeLocked() + screenOffTimeout) - currentTime;
        userActivityInternal(0, currentTime, 5, 1, 1000);     // Catch: Throwable -> L20
        millisUntilNormalTimeout = millisUntilNormalTimeout2;
    L20:
        th = th;
    L22:
        monitor-exit(r9);     // Catch: Throwable -> L8
        if (isFaceDown == false) goto L31;
        this.mFaceDownDetector.setMillisSaved(millisUntilNormalTimeout);
        return;
    L31:
        return;
    L13:
        r5 = "up.";
        goto L14
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("power", this.mBinderService, false, 1);
        publishLocalService(PowerManagerInternal.class, this.mLocalService);
        Watchdog.getInstance().addMonitor(this);
        Watchdog.getInstance().addThread(this.mHandler);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        systemReady();
        return;
    L6:
        if (phase != 600) goto L9;
        incrementBootCount();
        return;
    L9:
        if (phase != 1000) goto L29;
        Object r7 = this.mLock;
        monitor-enter(r7);
        long now = this.mClock.uptimeMillis();     // Catch: Throwable -> L15
        this.mBootCompleted = true;     // Catch: Throwable -> L15
        this.mDirty |= 16;     // Catch: Throwable -> L15
        if (this.mBatterySaverSupported == false) goto L17;
        this.mBatterySaverStateMachine.onBootCompleted();     // Catch: Throwable -> L15
    L17:
        userActivityNoUpdateLocked(now, 0, 0, 1000);     // Catch: Throwable -> L15
        updatePowerStateLocked();     // Catch: Throwable -> L15
        if (sQuiescent == false) goto L20;
        sleepPowerGroupLocked(this.mPowerGroups.get(0), this.mClock.uptimeMillis(), 10, 1000);     // Catch: Throwable -> L15
    L20:
        ((DeviceStateManager) this.mContext.getSystemService(DeviceStateManager.class)).registerCallback(new HandlerExecutor(this.mHandler), new DeviceStateListener(this));     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void systemReady() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mSystemReady = true;     // Catch: Throwable -> L8
        this.mDreamManager = (DreamManagerInternal) getLocalService(DreamManagerInternal.class);     // Catch: Throwable -> L8
        this.mDisplayManagerInternal = (DisplayManagerInternal) getLocalService(DisplayManagerInternal.class);     // Catch: Throwable -> L8
        this.mPolicy = (WindowManagerPolicy) getLocalService(WindowManagerPolicy.class);     // Catch: Throwable -> L8
        this.mBatteryManagerInternal = (BatteryManagerInternal) getLocalService(BatteryManagerInternal.class);     // Catch: Throwable -> L8
        this.mDisplayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);     // Catch: Throwable -> L8
        this.mAttentionDetector.systemReady(this.mContext);     // Catch: Throwable -> L8
        this.mZswExt.onSystemReady();     // Catch: Throwable -> L8
        SensorManager sensorManager = new SystemSensorManager(this.mContext, this.mHandler.getLooper());     // Catch: Throwable -> L8
        this.mSmtEx.initProximitySensorHelper(sensorManager);     // Catch: Throwable -> L8
        this.mBatteryStats = BatteryStatsService.getService();     // Catch: Throwable -> L8
        this.mNotifier = this.mInjector.createNotifier(Looper.getMainLooper(), this.mContext, this.mBatteryStats, this.mInjector.createSuspendBlocker(this, "PowerManagerService.Broadcasts"), this.mPolicy, this.mFaceDownDetector, this.mScreenUndimDetector, BackgroundThread.getExecutor(), this.mFeatureFlags);     // Catch: Throwable -> L8
        this.mPowerGroups.append(0, new PowerGroup(1, this.mPowerGroupWakefulnessChangeListener, this.mNotifier, this.mDisplayManagerInternal, this.mClock.uptimeMillis(), this.mFeatureFlags));     // Catch: Throwable -> L8
        PowerManagerServiceIA r3 = null;
        DisplayGroupPowerChangeListener displayGroupPowerChangeListener = new DisplayGroupPowerChangeListener(this, r3);     // Catch: Throwable -> L8
        this.mDisplayManagerInternal.registerDisplayGroupListener(displayGroupPowerChangeListener);     // Catch: Throwable -> L8
        if (this.mFeatureFlags.isScreenTimeoutPolicyListenerApiEnabled() == false) goto L10;
        this.mDisplayManager.registerDisplayListener(new DisplayListener(this, r3), this.mHandler);     // Catch: Throwable -> L8
    L10:
        this.mZswExt.registerPowerGroupListener(0, this.mPowerGroups.get(0));     // Catch: Throwable -> L8
        if (this.mDreamManager == null) goto L13;
        this.mDreamManager.registerDreamManagerStateListener(new DreamManagerStateListener(this, r3));     // Catch: Throwable -> L8
    L13:
        this.mWirelessChargerDetector = this.mInjector.createWirelessChargerDetector(sensorManager, this.mInjector.createSuspendBlocker(this, "PowerManagerService.WirelessChargerDetector"), this.mHandler);     // Catch: Throwable -> L8
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);     // Catch: Throwable -> L8
        this.mLightsManager = (LightsManager) getLocalService(LightsManager.class);     // Catch: Throwable -> L8
        this.mAttentionLight = this.mLightsManager.getLight(5);     // Catch: Throwable -> L8
        updateDeviceConfigLocked();     // Catch: Throwable -> L8
        this.mDeviceConfigProvider.addOnPropertiesChangedListener(BackgroundThread.getExecutor(), new PowerManagerService$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L8
        this.mDisplayManagerInternal.initPowerManagement(this.mDisplayPowerCallbacks, this.mHandler, sensorManager);     // Catch: Throwable -> L8
        addPowerGroupsForNonDefaultDisplayGroupLocked();     // Catch: Throwable -> L8
        ForegroundProfileObserver observer = new ForegroundProfileObserver(this, r3);     // Catch: Throwable -> L8 RemoteException -> L16
        ActivityManager.getService().registerUserSwitchObserver(observer, TAG);     // Catch: Throwable -> L8 RemoteException -> L16
    L17:
        this.mLowPowerStandbyController.systemReady();     // Catch: Throwable -> L8
        this.mSmtEx.initOtherManagerSmtEx((WindowManagerInternalSmtEx) getLocalService(WindowManagerInternalSmtEx.class));     // Catch: Throwable -> L8
        SysOptBridge.getFactory().getPowerManager().systemReady();     // Catch: Throwable -> L8
        readConfigurationLocked();     // Catch: Throwable -> L8
        updateSettingsLocked();     // Catch: Throwable -> L8
        if (this.mFeatureFlags.isEarlyScreenTimeoutDetectorEnabled() == false) goto L20;
        this.mScreenTimeoutOverridePolicy = new ScreenTimeoutOverridePolicy(this.mContext, this.mMinimumScreenOffTimeoutConfig, new PowerManagerService$$ExternalSyntheticLambda4(this));     // Catch: Throwable -> L8
    L20:
        this.mDirty |= 256;     // Catch: Throwable -> L8
        updatePowerStateLocked();     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        ContentResolver resolver = this.mContext.getContentResolver();
        this.mConstants.start(resolver);
        if (this.mBatterySaverSupported == false) goto L25;
        this.mBatterySaverStateMachine.systemReady();
    L25:
        this.mFaceDownDetector.systemReady(this.mContext);
        this.mScreenUndimDetector.systemReady(this.mContext);
        resolver.registerContentObserver(Settings.Secure.getUriFor("screensaver_enabled"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("screensaver_activate_on_sleep"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("screensaver_activate_on_dock"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("screensaver_activate_on_postured"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.System.getUriFor("screen_off_timeout"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("sleep_timeout"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("attentive_timeout"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Global.getUriFor("stay_on_while_plugged_in"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.System.getUriFor("screen_brightness_mode"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.System.getUriFor("screen_auto_brightness_adj"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Global.getUriFor("theater_mode_on"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("doze_always_on"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("double_tap_to_wake"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Global.getUriFor("device_demo_mode"), false, this.mSettingsObserver, 0);
        resolver.registerContentObserver(Settings.Global.getUriFor("stay_on_alltime"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.Global.getUriFor("feature_phone_mode"), false, this.mSettingsObserver, -1);
        resolver.registerContentObserver(Settings.System.getUriFor("screen_brightness_temp"), false, this.mSettingsObserver, -1);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_CHANGED");
        filter.setPriority(1000);
        this.mContext.registerReceiver(new BatteryReceiver(this), filter, null, this.mHandler);
        IntentFilter filter2 = new IntentFilter();
        filter2.addAction("android.intent.action.DREAMING_STARTED");
        filter2.addAction("android.intent.action.DREAMING_STOPPED");
        this.mContext.registerReceiver(new DreamReceiver(this, r3), filter2, null, this.mHandler);
        IntentFilter filter3 = new IntentFilter();
        filter3.addAction("android.intent.action.USER_SWITCHED");
        this.mContext.registerReceiver(new UserSwitchedReceiver(this), filter3, null, this.mHandler);
        if (com.android.server.common.Constants.ENABLE_GAME_SCREEN_SAVER == false) goto L28;
        this.mHandler.postDelayed(new PowerManagerService$$ExternalSyntheticLambda5(this), 500);
    L28:
        IntentFilter filter4 = new IntentFilter();
        filter4.addAction("android.intent.action.DOCK_EVENT");
        this.mContext.registerReceiver(new DockReceiver(this, r3), filter4, null, this.mHandler);
        this.mSmtEx.mPSMController.init();
        this.mExt.systemReady();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$systemReady$0(DeviceConfig.Properties properties) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateDeviceConfigLocked();     // Catch: Throwable -> L7
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$systemReady$1(int releaseReason) {
        Message msg = this.mHandler.obtainMessage(6);
        msg.arg1 = releaseReason;
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private /* synthetic */ void lambda$systemReady$2() {
        IGameScreenSaver screenSaver = (IGameScreenSaver) LocalServices.getService(IGameScreenSaver.class);
        if (screenSaver != null) goto L6;
        Slog.w(TAG, "Not get screenSaver");
        return;
    L6:
        screenSaver.setDozeBrightnessFunction(new PowerManagerService$$ExternalSyntheticLambda2(this));
    }

    void readConfigurationLocked() {
        Resources resources = this.mContext.getResources();
        this.mDecoupleHalAutoSuspendModeFromDisplayConfig = resources.getBoolean(R.bool.config_rawContactsAccountRestrictionEnabled);
        this.mDecoupleHalInteractiveModeFromDisplayConfig = resources.getBoolean(R.bool.config_reduceBrightColorsAvailable);
        this.mWakeUpWhenPluggedOrUnpluggedConfig = resources.getBoolean(R.bool.config_useLegacySplit);
        this.mWakeUpWhenPluggedOrUnpluggedInTheaterModeConfig = resources.getBoolean(R.bool.config_allowTheaterModeWakeFromUnplug);
        this.mSuspendWhenScreenOffDueToProximityConfig = resources.getBoolean(R.bool.config_trackerAppNeedsPermissions);
        this.mAttentiveTimeoutConfig = resources.getInteger(R.integer.config_audio_alarm_min_vol);
        this.mAttentiveWarningDurationConfig = resources.getInteger(R.integer.config_audio_notif_vol_default);
        this.mDreamsSupportedConfig = resources.getBoolean(R.bool.config_eap_sim_based_auth_supported);
        this.mDreamsEnabledByDefaultConfig = resources.getBoolean(R.bool.config_dreamsSupported);
        this.mDreamsActivatedOnSleepByDefaultConfig = resources.getBoolean(R.bool.config_dreamsEnabledOnBattery);
        this.mDreamsActivatedOnDockByDefaultConfig = resources.getBoolean(R.bool.config_dreamsDisabledByAmbientModeSuppressionConfig);
        this.mDreamsActivatedWhilePosturedByDefaultConfig = resources.getBoolean(R.bool.config_dreamsEnabledByDefault);
        this.mDreamsEnabledOnBatteryConfig = resources.getBoolean(R.bool.config_dropboxmanager_persistent_logging_enabled);
        this.mDreamsBatteryLevelMinimumWhenPoweredConfig = resources.getInteger(R.integer.config_fingerprintMaxTemplatesPerUser);
        this.mDreamsBatteryLevelMinimumWhenNotPoweredConfig = resources.getInteger(R.integer.config_faceMaxTemplatesPerUser);
        this.mDreamsBatteryLevelDrainCutoffConfig = resources.getInteger(R.integer.config_extraFreeKbytesAdjust);
        this.mDreamsDisabledByAmbientModeSuppressionConfig = resources.getBoolean(R.bool.config_dreamsOnlyEnabledForDockUser);
        this.mDozeAfterScreenOff = resources.getBoolean(R.bool.config_dozePickupGestureEnabled);
        this.mBrightWhenDozingConfig = resources.getBoolean(R.bool.config_buttonTextAllCaps);
        this.mMinimumScreenOffTimeoutConfig = resources.getInteger(R.integer.config_networkWakeupPacketMark);
        this.mMaximumScreenDimDurationConfig = resources.getInteger(R.integer.config_multiuserMaximumUsers);
        this.mMaximumScreenDimRatioConfig = resources.getFraction(R.fraction.config_maximumScreenDimRatio, 1, 1);
        this.mSupportsDoubleTapWakeConfig = resources.getBoolean(R.bool.config_supportsCamToggle);
    }

    private void updateSettingsLocked() {
        ContentResolver r0 = this.mContext.getContentResolver();
        boolean r2 = true;
        if (Settings.Secure.getIntForUser(r0, "screensaver_enabled", this.mDreamsEnabledByDefaultConfig ? 1 : 0, -2) == 0) goto L5;
        boolean r1 = true;
    L6:
        this.mDreamsEnabledSetting = r1;
        if (Settings.Secure.getIntForUser(r0, "screensaver_activate_on_sleep", this.mDreamsActivatedOnSleepByDefaultConfig ? 1 : 0, -2) == 0) goto L9;
        boolean r3 = true;
    L10:
        this.mDreamsActivateOnSleepSetting = r3;
        if (Settings.Secure.getIntForUser(r0, "screensaver_activate_on_dock", this.mDreamsActivatedOnDockByDefaultConfig ? 1 : 0, -2) == 0) goto L13;
        boolean r4 = true;
    L14:
        this.mDreamsActivateOnDockSetting = r4;
        if (Settings.Secure.getIntForUser(r0, "screensaver_activate_on_postured", this.mDreamsActivatedWhilePosturedByDefaultConfig ? 1 : 0, -2) == 0) goto L17;
        boolean r5 = true;
    L18:
        this.mDreamsActivateWhilePosturedSetting = r5;
        this.mScreenOffTimeoutSetting = Settings.System.getIntForUser(r0, "screen_off_timeout", 15000, -2);
        this.mSleepTimeoutSetting = Settings.Secure.getIntForUser(r0, "sleep_timeout", -1, -2);
        this.mAttentiveTimeoutSetting = Settings.Secure.getIntForUser(r0, "attentive_timeout", this.mAttentiveTimeoutConfig, -2);
        this.mStayOnWhilePluggedInSetting = Settings.Global.getInt(r0, "stay_on_while_plugged_in", 1);
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "theater_mode_on", 0) != 1) goto L21;
        boolean r6 = true;
    L22:
        this.mTheaterModeEnabled = r6;
        this.mAlwaysOnEnabled = this.mAmbientDisplayConfiguration.alwaysOnEnabled(-2);
        this.mStayOnAlltimeSetting = Settings.Global.getInt(r0, "stay_on_alltime", 0);
        PowerManagerServiceSmtEx r7 = this.mSmtEx;
        if (Settings.Global.getInt(r0, "feature_phone_mode", 0) == 0) goto L25;
        boolean r8 = true;
    L26:
        r7.mFeaturePhoneModeEnabled = r8;
        int r9 = this.mScreenBrightnessModeSetting;
        this.mScreenBrightnessModeSetting = Settings.System.getIntForUser(r0, "screen_brightness_mode", 0, -2);
        if (this.mScreenBrightnessModeSetting == r9) goto L29;
        boolean r10 = true;
    L30:
        this.mScreenBrightnessModeSettingChanged = r10;
        if (this.mSupportsDoubleTapWakeConfig == false) goto L40;
        if (Settings.Secure.getIntForUser(r0, "double_tap_to_wake", 0, -2) != 0) goto L37;
        r2 = false;
    L37:
        if (r2 == this.mDoubleTapWakeEnabled) goto L40;
        this.mDoubleTapWakeEnabled = r2;
        this.mNativeWrapper.nativeSetPowerMode(0, this.mDoubleTapWakeEnabled);
    L40:
        if (UserManager.isDeviceInDemoMode(this.mContext) == false) goto L42;
        String r11 = "1";
    L44:
        if (r11.equals(this.mSystemProperties.get(SYSTEM_PROPERTY_RETAIL_DEMO_ENABLED, null)) == true) goto L46;
        this.mSystemProperties.set(SYSTEM_PROPERTY_RETAIL_DEMO_ENABLED, r11);
    L46:
        this.mDirty |= 32;
        return;
    L42:
        r11 = "0";
        goto L44
    L29:
        r10 = false;
        goto L30
    L25:
        r8 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    void handleSettingsChangedLocked() {
        updateSettingsLocked();
        updatePowerStateLocked();
    }

    private void updateDeviceConfigLocked() {
        this.mDisableScreenWakeLocksWhileCached = this.mDeviceConfigProvider.isDisableScreenWakeLocksWhileCachedFeatureEnabled();
    }

    private void acquireWakeLockInternal(IBinder lock, int displayId, int flags, String tag, String packageName, WorkSource ws, String historyTag, int uid, int pid, IWakeLockCallback callback) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        long t0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        if (displayId != (-1)) goto L7;
    L22:
        int index = findWakeLockIndexLocked(lock);     // Catch: Throwable -> L9
        if (index >= 0) goto L66;
        UidState state = this.mUidState.get(uid);     // Catch: Throwable -> L9
        if (state != null) goto L37;
        state = new UidState(uid);     // Catch: Throwable -> L9
        state.mProcState = 20;     // Catch: Throwable -> L9
        this.mUidState.put(uid, state);     // Catch: Throwable -> L9
    L37:
        state.mNumWakeLocks++;     // Catch: Throwable -> L9
        PowerManagerService r1 = this;
        int r6 = uid;
        WakeLock wakeLock = new WakeLock(r1, lock, displayId, flags, tag, packageName, ws, historyTag, uid, pid, state, callback);     // Catch: Throwable -> L62
        r1.mWakeLocks.add(wakeLock);     // Catch: Throwable -> L9
        r1.setWakeLockDisabledStateLocked(wakeLock);     // Catch: Throwable -> L9
        boolean notifyAcquire = true;
    L42:
        long t1 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        r1.mExt.acquireWakeLockInternal(wakeLock);     // Catch: Throwable -> L9
        long t2 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        r1.applyWakeLockFlagsOnAcquireLocked(wakeLock);     // Catch: Throwable -> L9
        long t3 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        r1.mDirty |= 1;     // Catch: Throwable -> L9
        r1.updatePowerStateLocked();     // Catch: Throwable -> L9
        long t4 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        if (notifyAcquire == false) goto L45;
        r1.notifyWakeLockAcquiredLocked(wakeLock);     // Catch: Throwable -> L9
    L45:
        long t5 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        long dur = t5 - t0;     // Catch: Throwable -> L9
        if (dur < 1000) goto L60;
        if ((t5 - r1.mLastSlowWlLog) < JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY) goto L60;
        r1.mLastSlowWlLog = t5;     // Catch: Throwable -> L9
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L9
        r2.append("Slow acquireWakeLock dur=");     // Catch: Throwable -> L9
        r2.append(dur);     // Catch: Throwable -> L9
        r2.append("ms prep=");     // Catch: Throwable -> L9
        r2.append(t1 - t0);     // Catch: Throwable -> L9
        r2.append(" oem=");     // Catch: Throwable -> L9
        r2.append(t2 - t1);     // Catch: Throwable -> L9
        r2.append(" af=");     // Catch: Throwable -> L9
        r2.append(t3 - t2);     // Catch: Throwable -> L9
        r2.append(" pwr=");     // Catch: Throwable -> L9
        r2.append(t4 - t3);     // Catch: Throwable -> L9
        r2.append(" notify=");     // Catch: Throwable -> L9
        r2.append(t5 - t4);     // Catch: Throwable -> L9
        r2.append(" tag=");     // Catch: Throwable -> L9
        r2.append(tag);     // Catch: Throwable -> L56
        r2.append(" pkg=");     // Catch: Throwable -> L56
        r2.append(packageName);     // Catch: Throwable -> L54
        r2.append(" uid=");     // Catch: Throwable -> L54
        r2.append(r6);     // Catch: Throwable -> L54
        r2.append(" ");     // Catch: Throwable -> L54
        r2.append(Thread.currentThread().getName());     // Catch: Throwable -> L54
        Slog.w(TAG, r2.toString());     // Catch: Throwable -> L54
    L56:
        th = th;
    L64:
        monitor-exit(r13);     // Catch: Throwable -> L54
        throw th;
    L60:
        monitor-exit(r13);     // Catch: Throwable -> L54
        return;
    L62:
        th = th;
        goto L64
    L66:
        wakeLock = this.mWakeLocks.get(index);     // Catch: Throwable -> L30
        if (wakeLock.hasSameProperties(flags, tag, ws, uid, pid, callback) == true) goto L32;
        notifyWakeLockChangingLocked(wakeLock, flags, tag, packageName, uid, pid, ws, historyTag, callback);     // Catch: Throwable -> L30
        r6 = uid;
        wakeLock.updateProperties(flags, tag, packageName, ws, historyTag, r6, pid, callback);     // Catch: Throwable -> L9
        wakeLock = wakeLock;
        SysOptBridge.getFactory().getPowerManager().updateWakeLockAcquireStateLocked(wakeLock);     // Catch: Throwable -> L9
    L33:
        notifyAcquire = false;
        r1 = this;
        goto L42
    L32:
        r6 = uid;
    L30:
        th = th;
        goto L64
    L7:
        if (this.mSystemReady == false) goto L12;
        DisplayInfo displayInfo = this.mDisplayManagerInternal.getDisplayInfo(displayId);     // Catch: Throwable -> L9
    L13:
        if (displayInfo != null) goto L18;
        Slog.wtf(TAG, "Tried to acquire wake lock for invalid display: " + displayId);     // Catch: Throwable -> L9
        monitor-exit(r13);     // Catch: Throwable -> L9
        return;
    L18:
        if (displayInfo.hasAccess(uid) == true) goto L22;
        throw new SecurityException("Caller does not have access to display");     // Catch: Throwable -> L9
    L12:
        displayInfo = null;
    L54:
        th = th;
    L9:
        th = th;
        goto L64
    }

    private static boolean isScreenLock(WakeLock wakeLock) {
        return isScreenLock(wakeLock.mFlags);
    }

    public static boolean isScreenLock(int flags) {
        switch((65535 & flags)) {
            case 6: goto L6;
            case 10: goto L6;
            case 26: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    private static WorkSource.WorkChain getFirstNonEmptyWorkChain(WorkSource workSource) {
        if (workSource.getWorkChains() != null) goto L5;
        return null;
    L5:
        Iterator r0 = workSource.getWorkChains().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WorkSource.WorkChain workChain = (WorkSource.WorkChain) r0.next();
        if (workChain.getSize() <= 0) goto L7;
        return workChain;
    L12:
        return null;
    }

    private boolean isAcquireCausesWakeupFlagAllowed(String opPackageName, int opUid, int opPid) {
        if (opPackageName != null) goto L6;
        return false;
    L6:
        if (this.mPermissionCheckerWrapper.checkPermissionForDataDelivery(this.mContext, "android.permission.TURN_SCREEN_ON", opPid, new AttributionSource(opUid, opPackageName, null), "ACQUIRE_CAUSES_WAKEUP for " + opPackageName) != 0) goto L10;
        Slog.i(TAG, "Allowing device wake-up from app " + opPackageName);
        return true;
    L10:
        if (CompatChanges.isChangeEnabled(REQUIRE_TURN_SCREEN_ON_PERMISSION, opUid) == true) goto L16;
        if (this.mPowerPropertiesWrapper.waive_target_sdk_check_for_turn_screen_on() == true) goto L16;
        Slog.i(TAG, "Allowing device wake-up without android.permission.TURN_SCREEN_ON for " + opPackageName);
        return true;
    L16:
        if (this.mPowerPropertiesWrapper.permissionless_turn_screen_on() == false) goto L19;
        Slog.d(TAG, "Device wake-up allowed by debug.power.permissionless_turn_screen_on");
        return true;
    L19:
        Slog.w(TAG, "Not allowing device wake-up for " + opPackageName);
        return false;
    }

    private void applyWakeLockFlagsOnAcquireLocked(WakeLock wakeLock) {
        if ((wakeLock.mFlags & 268435456) != 0) goto L5;
        return;
    L5:
        if (isScreenLock(wakeLock) == false) goto L38;
        int opPid = -1;
        if (wakeLock.mWorkSource != null) goto L9;
    L19:
        String opPackageName = wakeLock.mPackageName;
        int opUid = wakeLock.mOwnerUid;
        opPid = wakeLock.mOwnerPid;
        String opPackageName2 = opPackageName;
        int opUid2 = opUid;
    L20:
        Integer powerGroupId = wakeLock.getPowerGroupId();
        if (powerGroupId != null) goto L23;
        return;
    L23:
        if (isAcquireCausesWakeupFlagAllowed(opPackageName2, opUid2, opPid) == true) goto L25;
        return;
    L25:
        if (powerGroupId.intValue() != (-1)) goto L33;
        int idx = 0;
    L28:
        if (idx >= this.mPowerGroups.size()) goto L31;
        wakePowerGroupLocked(this.mPowerGroups.valueAt(idx), this.mClock.uptimeMillis(), 2, wakeLock.mTag, opUid2, opPackageName2, opUid2);
        idx = idx + 1;
        goto L28
    L31:
        return;
    L33:
        if (this.mPowerGroups.contains(powerGroupId.intValue()) == false) goto L41;
        wakePowerGroupLocked(this.mPowerGroups.get(powerGroupId.intValue()), this.mClock.uptimeMillis(), 2, wakeLock.mTag, opUid2, opPackageName2, opUid2);
        return;
    L41:
        return;
    L9:
        if (wakeLock.mWorkSource.isEmpty() == true) goto L19;
        WorkSource workSource = wakeLock.mWorkSource;
        WorkSource.WorkChain workChain = getFirstNonEmptyWorkChain(workSource);
        if (workChain == null) goto L14;
        String opPackageName3 = workChain.getAttributionTag();
        int opUid3 = workChain.getAttributionUid();
    L18:
        opPackageName2 = opPackageName3;
        opUid2 = opUid3;
        goto L20
    L14:
        if (workSource.getPackageName(0) == null) goto L16;
        String opPackageName4 = workSource.getPackageName(0);
    L17:
        String r12 = opPackageName4;
        opUid3 = workSource.getUid(0);
        opPackageName3 = r12;
        goto L18
    L16:
        opPackageName4 = wakeLock.mPackageName;
        goto L17
    }

    private void releaseWakeLockInternal(IBinder lock, int flags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = findWakeLockIndexLocked(lock);     // Catch: Throwable -> L8
        if (index >= 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        WakeLock wakeLock = this.mWakeLocks.get(index);     // Catch: Throwable -> L8
        this.mExt.releaseWakeLockInternal(wakeLock);     // Catch: Throwable -> L8
        if ((flags & 1) == 0) goto L13;
        this.mRequestWaitForNegativeProximity = true;     // Catch: Throwable -> L8
    L13:
        wakeLock.unlinkToDeath();     // Catch: Throwable -> L8
        wakeLock.setDisabled(true);     // Catch: Throwable -> L8
        removeWakeLockLocked(wakeLock, index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleWakeLockDeath(WakeLock wakeLock) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = this.mWakeLocks.indexOf(wakeLock);     // Catch: Throwable -> L8
        if (index >= 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        removeWakeLockDeathLocked(wakeLock, index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void removeWakeLockNoUpdateLocked(WakeLock wakeLock, int index) {
        removeWakeLockNoUpdateLocked(wakeLock, index, -1);
    }

    private void removeWakeLockNoUpdateLocked(WakeLock wakeLock, int index, int releaseReason) {
        this.mWakeLocks.remove(index);
        UidState state = wakeLock.mUidState;
        state.mNumWakeLocks--;
        if (state.mNumWakeLocks <= 0) goto L5;
    L7:
        notifyWakeLockReleasedLocked(wakeLock, releaseReason);
        applyWakeLockFlagsOnReleaseLocked(wakeLock);
        this.mDirty |= 1;
        return;
    L5:
        if (state.mProcState != 20) goto L7;
        this.mUidState.remove(state.mUid);
        goto L7
    }

    private void removeWakeLockLocked(WakeLock wakeLock, int index) {
        removeWakeLockNoUpdateLocked(wakeLock, index);
        updatePowerStateLocked();
    }

    private void removeWakeLockDeathLocked(WakeLock wakeLock, int index) {
        removeWakeLockNoUpdateLocked(wakeLock, index, 8);
        updatePowerStateLocked();
    }

    private void applyWakeLockFlagsOnReleaseLocked(WakeLock wakeLock) {
        if ((wakeLock.mFlags & 536870912) != 0) goto L5;
        return;
    L5:
        if (isScreenLock(wakeLock) == false) goto L9;
        userActivityNoUpdateLocked(this.mClock.uptimeMillis(), 0, 1, wakeLock.mOwnerUid);
        return;
    }

    private void updateWakeLockWorkSourceInternal(IBinder lock, WorkSource ws, String historyTag, int callingUid) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        int index = findWakeLockIndexLocked(lock);     // Catch: Throwable -> L9
        if (index < 0) goto L13;
        WakeLock wakeLock = this.mWakeLocks.get(index);     // Catch: Throwable -> L9
        if (wakeLock.hasSameWorkSource(ws) == true) goto L11;
        notifyWakeLockChangingLocked(wakeLock, wakeLock.mFlags, wakeLock.mTag, wakeLock.mPackageName, wakeLock.mOwnerUid, wakeLock.mOwnerPid, ws, historyTag, null);     // Catch: Throwable -> L9
        wakeLock.mHistoryTag = historyTag;     // Catch: Throwable -> L9
        wakeLock.updateWorkSource(ws);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getPowerManager().updateWakeLockAcquireStateLocked(wakeLock);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L13:
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L9
        r2.append("Wake lock not active: ");     // Catch: Throwable -> L9
        r2.append(lock);     // Catch: Throwable -> L9
        r2.append(" from uid ");     // Catch: Throwable -> L9
        r2.append(callingUid);     // Catch: Throwable -> L17
        throw new IllegalArgumentException(r2.toString());     // Catch: Throwable -> L17
    L17:
        th = th;
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L17
        throw th;
    L9:
        th = th;
        goto L18
    }

    private void updateWakeLockCallbackInternal(IBinder lock, IWakeLockCallback callback, int callingUid) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        int index = findWakeLockIndexLocked(lock);     // Catch: Throwable -> L9
        if (index < 0) goto L14;
        WakeLock wakeLock = this.mWakeLocks.get(index);     // Catch: Throwable -> L9
        if (isSameCallback(callback, wakeLock.mCallback) == true) goto L11;
        notifyWakeLockChangingLocked(wakeLock, wakeLock.mFlags, wakeLock.mTag, wakeLock.mPackageName, wakeLock.mOwnerUid, wakeLock.mOwnerPid, wakeLock.mWorkSource, wakeLock.mHistoryTag, callback);     // Catch: Throwable -> L9
        wakeLock.mCallback = callback;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L14:
        throw new IllegalArgumentException("Wake lock not active: " + lock + " from uid " + callingUid);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private int findWakeLockIndexLocked(IBinder lock) {
        int count = this.mWakeLocks.size();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        if (this.mWakeLocks.get(i).mLock == lock) goto L6;
        i = i + 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    WakeLock findWakeLockLocked(IBinder lock) {
        int index = findWakeLockIndexLocked(lock);
        if (index != (-1)) goto L7;
        return null;
    L7:
        return this.mWakeLocks.get(index);
    }

    protected void notifyWakeLockAcquiredLocked(WakeLock wakeLock) {
        if (this.mSystemReady == true) goto L5;
        return;
    L5:
        if (wakeLock.mDisabled == true) goto L9;
        wakeLock.mNotifiedAcquired = true;
        this.mNotifier.onWakeLockAcquired(wakeLock.mFlags, wakeLock.mTag, wakeLock.mPackageName, wakeLock.mOwnerUid, wakeLock.mOwnerPid, wakeLock.mWorkSource, wakeLock.mHistoryTag, wakeLock.mCallback);
        restartNofifyLongTimerLocked(wakeLock);
        return;
    }

    private void enqueueNotifyLongMsgLocked(long time) {
        this.mNotifyLongScheduled = time;
        Message msg = this.mHandler.obtainMessage(4);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageAtTime(msg, time);
    }

    private void restartNofifyLongTimerLocked(WakeLock wakeLock) {
        wakeLock.mAcquireTime = this.mClock.uptimeMillis();
        if ((wakeLock.mFlags & 65535) == 1) goto L5;
        return;
    L5:
        if (this.mNotifyLongScheduled != 0) goto L9;
        enqueueNotifyLongMsgLocked(wakeLock.mAcquireTime + 60000);
        return;
    }

    private void notifyWakeLockLongStartedLocked(WakeLock wakeLock) {
        if (this.mSystemReady == true) goto L5;
        return;
    L5:
        if (wakeLock.mDisabled == true) goto L9;
        wakeLock.mNotifiedLong = true;
        this.mNotifier.onLongPartialWakeLockStart(wakeLock.mTag, wakeLock.mOwnerUid, wakeLock.mWorkSource, wakeLock.mHistoryTag);
        return;
    }

    private void notifyWakeLockLongFinishedLocked(WakeLock wakeLock) {
        if (wakeLock.mNotifiedLong == false) goto L6;
        wakeLock.mNotifiedLong = false;
        this.mNotifier.onLongPartialWakeLockFinish(wakeLock.mTag, wakeLock.mOwnerUid, wakeLock.mWorkSource, wakeLock.mHistoryTag);
        return;
    }

    private void notifyWakeLockChangingLocked(WakeLock wakeLock, int flags, String tag, String packageName, int uid, int pid, WorkSource ws, String historyTag, IWakeLockCallback callback) {
        if (this.mSystemReady == true) goto L5;
        return;
    L5:
        if (wakeLock.mNotifiedAcquired == false) goto L9;
        this.mNotifier.onWakeLockChanging(wakeLock.mFlags, wakeLock.mTag, wakeLock.mPackageName, wakeLock.mOwnerUid, wakeLock.mOwnerPid, wakeLock.mWorkSource, wakeLock.mHistoryTag, wakeLock.mCallback, flags, tag, packageName, uid, pid, ws, historyTag, callback);
        notifyWakeLockLongFinishedLocked(wakeLock);
        restartNofifyLongTimerLocked(wakeLock);
        return;
    }

    protected void notifyWakeLockReleasedLocked(WakeLock wakeLock) {
        notifyWakeLockReleasedLocked(wakeLock, -1);
    }

    private void notifyWakeLockReleasedLocked(WakeLock wakeLock, int releaseReason) {
        if (this.mSystemReady == false) goto L8;
        if (wakeLock.mNotifiedAcquired == false) goto L8;
        wakeLock.mNotifiedAcquired = false;
        wakeLock.mAcquireTime = 0;
        this.mNotifier.onWakeLockReleased(wakeLock.mFlags, wakeLock.mTag, wakeLock.mPackageName, wakeLock.mOwnerUid, wakeLock.mOwnerPid, wakeLock.mWorkSource, wakeLock.mHistoryTag, wakeLock.mCallback, releaseReason);
        notifyWakeLockLongFinishedLocked(wakeLock);
        return;
    }

    private boolean isWakeLockLevelSupportedInternal(int level, int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = true;
        switch(level) {
            case 1: goto L28;
            case 6: goto L28;
            case 10: goto L28;
            case 26: goto L28;
            case 32: goto L21;
            case 64: goto L28;
            case 128: goto L28;
            case 256: goto L11;
            default: goto L6;
        };
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L11:
        if (this.mSystemReady == true) goto L13;
    L17:
        r1 = false;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L13:
        if (this.mFeatureFlags.isEarlyScreenTimeoutDetectorEnabled() == false) goto L17;
        if (this.mScreenTimeoutOverridePolicy == null) goto L17;
    L21:
        if (this.mSystemReady == true) goto L23;
    L25:
        r1 = false;
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L23:
        if (this.mDisplayManagerInternal.isProximitySensorAvailable(displayId) == false) goto L25;
    L8:
        th = move-exception;
        throw th;
    }

    private void userActivityFromNative(long eventTime, int event, int displayId, int flags) {
        userActivityInternal(displayId, eventTime, event, flags, 1000);
    }

    private void userActivityInternal(int displayId, long eventTime, int event, int flags, int uid) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (displayId == (-1)) goto L8;
        DisplayInfo displayInfo = this.mDisplayManagerInternal.getDisplayInfo(displayId);     // Catch: Throwable -> L10
        if (displayInfo != null) goto L18;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L18:
        int groupId = displayInfo.displayGroupId;     // Catch: Throwable -> L10
        if (groupId != (-1)) goto L35;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L35:
        if (userActivityNoUpdateLocked(this.mPowerGroups.get(groupId), eventTime, event, flags, uid) == false) goto L28;
        updatePowerStateLocked();     // Catch: Throwable -> L10
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L30:
        th = move-exception;
        Throwable r11 = th;
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r11;
    L8:
        if (userActivityNoUpdateLocked(eventTime, event, flags, uid) == false) goto L12;
        updatePowerStateLocked();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        r11 = th;
        goto L32
    }

    private void napInternal(long eventTime, int uid, boolean allowWake) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        dreamPowerGroupLocked(this.mPowerGroups.get(0), eventTime, uid, allowWake);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    private void onUserAttention() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (userActivityNoUpdateLocked(this.mPowerGroups.get(0), this.mClock.uptimeMillis(), 4, 0, 1000) == false) goto L9;
        updatePowerStateLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
    }

    private boolean userActivityNoUpdateLocked(long eventTime, int event, int flags, int uid) {
        boolean updatePowerState = false;
        int idx = 0;
    L4:
        if (idx >= this.mPowerGroups.size()) goto L10;
        long eventTime2 = eventTime;
        int event2 = event;
        int flags2 = flags;
        int uid2 = uid;
        if (userActivityNoUpdateLocked(this.mPowerGroups.valueAt(idx), eventTime2, event2, flags2, uid2) == false) goto L8;
        updatePowerState = true;
    L8:
        idx = idx + 1;
        eventTime = eventTime2;
        event = event2;
        flags = flags2;
        uid = uid2;
        goto L4
    L10:
        return updatePowerState;
    }

    private boolean userActivityNoUpdateLocked(PowerGroup powerGroup, long eventTime, int event, int flags, int uid) {
        powerGroup.getGroupId();
        if (eventTime >= powerGroup.getLastSleepTimeLocked()) goto L5;
    L55:
        return false;
    L5:
        if (eventTime < powerGroup.getLastWakeTimeLocked()) goto L55;
        if (this.mSystemReady == false) goto L55;
        Trace.traceBegin(131072, "userActivity");
    L15:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    L11:
        if (eventTime > this.mLastInteractivePowerHintTime) goto L13;
    L18:
        this.mNotifier.onUserActivity(powerGroup.getGroupId(), event, uid);     // Catch: Throwable -> L15
        this.mAttentionDetector.onUserActivity(eventTime, event);     // Catch: Throwable -> L15
        if (this.mScreenTimeoutOverridePolicy == null) goto L22;
        this.mScreenTimeoutOverridePolicy.onUserActivity(this.mWakeLockSummary, event);     // Catch: Throwable -> L15
    L22:
        if (this.mUserInactiveOverrideFromWindowManager == false) goto L24;
        this.mUserInactiveOverrideFromWindowManager = false;     // Catch: Throwable -> L15
        this.mOverriddenTimeout = -1;     // Catch: Throwable -> L15
    L24:
        int wakefulness = powerGroup.getWakefulnessLocked();     // Catch: Throwable -> L15
        if (wakefulness == 0) goto L51;
        if (wakefulness == 3) goto L51;
        if ((flags & 2) != 0) goto L51;
        maybeUpdateForegroundProfileLastActivityLocked(eventTime);     // Catch: Throwable -> L15
        if ((flags & 1) == 0) goto L43;
        if (eventTime > powerGroup.getLastUserActivityTimeNoChangeLightsLocked()) goto L36;
    L49:
        Trace.traceEnd(131072);
        return false;
    L36:
        if (eventTime <= powerGroup.getLastUserActivityTimeLocked()) goto L49;
        powerGroup.setLastUserActivityTimeNoChangeLightsLocked(eventTime, event);     // Catch: Throwable -> L15
        this.mDirty |= 4;     // Catch: Throwable -> L15
        if (event != 1) goto L40;
        this.mDirty |= 4096;     // Catch: Throwable -> L15
    L40:
        Trace.traceEnd(131072);
        return true;
    L43:
        if (eventTime <= powerGroup.getLastUserActivityTimeLocked()) goto L49;
        powerGroup.setLastUserActivityTimeLocked(eventTime, event);     // Catch: Throwable -> L15
        this.mDirty |= 4;     // Catch: Throwable -> L15
        if (event != 1) goto L47;
        this.mDirty |= 4096;     // Catch: Throwable -> L15
    L47:
        Trace.traceEnd(131072);
        return true;
    L51:
        Trace.traceEnd(131072);
        return false;
    L13:
        if (SysOptBridge.getFactory().getDynamicRefreshRateService().shouldInterceptPowerBoost("user_activity_no_update") == true) goto L17;
        setPowerBoostInternal(0, 0);     // Catch: Throwable -> L15
    L17:
        this.mLastInteractivePowerHintTime = eventTime;     // Catch: Throwable -> L15
        goto L18
    }

    private void maybeUpdateForegroundProfileLastActivityLocked(long eventTime) {
        ProfilePowerState profile = this.mProfilePowerState.get(this.mForegroundProfile);
        if (profile != null) goto L5;
        return;
    L5:
        if (eventTime <= profile.mLastUserActivityTime) goto L9;
        profile.mLastUserActivityTime = eventTime;
        return;
    }

    public void wakePowerGroupLocked(PowerGroup powerGroup, long eventTime, int reason, String details, int uid, String opPackageName, int opUid) {
        if (this.mForceSuspendActive == false) goto L5;
        return;
    L5:
        if (this.mSystemReady == false) goto L21;
        if (powerGroup != null) goto L9;
        return;
    L9:
        if (this.mSmtEx.mInCall == true) goto L11;
    L18:
        powerGroup.wakeUpLocked(eventTime, reason, details, uid, opPackageName, opUid, LatencyTracker.getInstance(this.mContext));
        return;
    L11:
        if (this.mSleepingForPsensor == false) goto L18;
        if ("bytedance.single.wakeup".equals(details) == false) goto L15;
    L16:
        Slog.i(TAG, "InCall P-Sensor enabled when click");
        return;
    L15:
        if ("bytedance.pickup.wakeup".equals(details) == false) goto L18;
    }

    private boolean dreamPowerGroupLocked(PowerGroup powerGroup, long eventTime, int uid, boolean allowWake) {
        if (this.mBootCompleted == true) goto L5;
        return false;
    L5:
        if (this.mSystemReady == true) goto L8;
        return false;
    L8:
        return powerGroup.dreamLocked(eventTime, uid, allowWake);
    }

    private boolean dozePowerGroupLocked(PowerGroup powerGroup, long eventTime, int reason, int uid) {
        if (this.mSystemReady == true) goto L5;
        return false;
    L5:
        if (this.mBootCompleted == true) goto L8;
        return false;
    L8:
        return powerGroup.dozeLocked(eventTime, uid, reason);
    }

    protected boolean sleepPowerGroupLocked(PowerGroup powerGroup, long eventTime, int reason, int uid) {
        if (this.mBootCompleted == true) goto L5;
        return false;
    L5:
        if (this.mSystemReady == true) goto L8;
        return false;
    L8:
        return powerGroup.sleepLocked(eventTime, uid, reason);
    }

    void setWakefulnessLocked(int groupId, int wakefulness, long eventTime, int uid, int reason, int opUid, String opPackageName, String details) {
        this.mPowerGroups.get(groupId).setWakefulnessLocked(wakefulness, eventTime, uid, reason, opUid, opPackageName, details);
    }

    private void updateGlobalWakefulnessLocked(long eventTime, int reason, int uid, int opUid, String opPackageName, String details) {
        int newWakefulness = recalculateGlobalWakefulnessLocked();
        int currentWakefulness = getGlobalWakefulnessLocked();
        if (currentWakefulness != newWakefulness) goto L5;
        return;
    L5:
        boolean r11 = true;
        switch(newWakefulness) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            default: goto L8;
        };
    L9:
        String traceMethodName = "goToSleep";
        Slog.i(TAG, "Going to sleep due to " + PowerManager.sleepReasonToString(reason) + " (uid " + uid + ", screenOffTimeout=" + this.mScreenOffTimeoutSetting + ", activityTimeoutWM=" + this.mUserActivityTimeoutOverrideFromWindowManager + ", maxDimRatio=" + this.mMaximumScreenDimRatioConfig + ", maxDimDur=" + this.mMaximumScreenDimDurationConfig + ")...");
        this.mLastGlobalSleepTime = eventTime;
        this.mLastGlobalSleepReason = reason;
        this.mLastGlobalSleepTimeRealtime = this.mClock.elapsedRealtime();
        this.mDozeStartInProgress = true;
    L16:
        if (com.android.server.common.Constants.ENABLE_GAME_ASSIST == false) goto L18;
        int newWakefulness2 = newWakefulness;
        SystemWakefulnessEventDispatcher.getInstance().notifyGlobalWakefulnessChanged(newWakefulness2, eventTime, uid, reason, details, opPackageName);
    L19:
        Trace.traceBegin(131072, traceMethodName);
        this.mInjector.invalidateIsInteractiveCaches();     // Catch: Throwable -> L28
        this.mWakefulnessRaw = newWakefulness2;     // Catch: Throwable -> L28
        this.mWakefulnessChanging = true;     // Catch: Throwable -> L28
        this.mDirty |= 2;     // Catch: Throwable -> L28
        boolean r2 = this.mDozeStartInProgress;     // Catch: Throwable -> L28
        if (newWakefulness2 == 3) goto L24;
        r11 = false;
    L24:
        this.mDozeStartInProgress = r2 & r11;     // Catch: Throwable -> L28
        if (this.mNotifier == null) goto L56;
        this.mNotifier.onGlobalWakefulnessChangeStarted(newWakefulness2, reason, details, eventTime);     // Catch: Throwable -> L28
    L56:
        this.mAttentionDetector.onWakefulnessChangeStarted(newWakefulness2);     // Catch: Throwable -> L37
        switch(newWakefulness2) {
            case 0: goto L40;
            case 1: goto L34;
            case 2: goto L50;
            case 3: goto L40;
            default: goto L50;
        };     // Catch: Throwable -> L37
    L34:
        this.mNotifier.onWakeUp(reason, details, uid, opPackageName, opUid);     // Catch: Throwable -> L37
        if (sQuiescent == false) goto L50;
        this.mDirty |= 4096;     // Catch: Throwable -> L37
    L50:
        Trace.traceEnd(131072);
        return;
    L40:
        if (PowerManagerInternal.isInteractive(currentWakefulness) == false) goto L50;
        int numWakeLocksCleared = 0;
        int numWakeLocks = this.mWakeLocks.size();     // Catch: Throwable -> L37
        int i = 0;
    L43:
        if (i >= numWakeLocks) goto L49;
        WakeLock wakeLock = this.mWakeLocks.get(i);     // Catch: Throwable -> L37
        switch((wakeLock.mFlags & 65535)) {
            case 6: goto L47;
            case 10: goto L47;
            case 26: goto L47;
            default: goto L48;
        };     // Catch: Throwable -> L37
    L47:
        numWakeLocksCleared = numWakeLocksCleared + 1;     // Catch: Throwable -> L37
    L48:
        i = i + 1;     // Catch: Throwable -> L37
        goto L43
    L49:
        EventLogTags.writePowerSleepRequested(numWakeLocksCleared);     // Catch: Throwable -> L37
    L37:
        th = th;
    L52:
        Trace.traceEnd(131072);
        throw th;
    L28:
        th = th;
        goto L52
    L18:
        newWakefulness2 = newWakefulness;
        goto L19
    L10:
        traceMethodName = "nap";
        Slog.i(TAG, "Nap time (uid " + uid + ")...");
        goto L16
    L11:
        traceMethodName = "wakeUp";
        Slog.i(TAG, "Waking up from " + PowerManagerInternal.wakefulnessToString(currentWakefulness) + " (uid=" + uid + ", reason=" + PowerManager.wakeReasonToString(reason) + ", details=" + details + ")...");
        StringBuilder r7 = new StringBuilder();
        r7.append("reason=");
        r7.append(uid);
        r7.append(",");
        r7.append(reason);
        r7.append(",");
        r7.append(details);
        String payload = r7.toString();
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWakeUpReason(1, payload);
        this.mLastGlobalWakeTime = eventTime;
        this.mLastGlobalWakeReason = reason;
        this.mLastGlobalWakeTimeRealtime = this.mClock.elapsedRealtime();
        goto L16
    L12:
        traceMethodName = "reallyGoToSleep";
        Slog.i(TAG, "Sleeping (uid " + uid + ")...");
        if (currentWakefulness == 3) goto L16;
        this.mLastGlobalSleepTime = eventTime;
        this.mLastGlobalSleepReason = reason;
        goto L16
    L8:
        throw new IllegalArgumentException("Unexpected wakefulness: " + newWakefulness);
    }

    int getGlobalWakefulnessLocked() {
        return this.mWakefulnessRaw;
    }

    int getWakefulnessLocked(int groupId) {
        return this.mPowerGroups.get(groupId).getWakefulnessLocked();
    }

    int recalculateGlobalWakefulnessLocked() {
        int deviceWakefulness = 0;
        int i = 0;
    L4:
        if (i >= this.mPowerGroups.size()) goto L18;
        int wakefulness = this.mPowerGroups.valueAt(i).getWakefulnessLocked();
        if (wakefulness == 1) goto L7;
        if (wakefulness != 2) goto L13;
        if (deviceWakefulness == 0) goto L12;
        if (deviceWakefulness != 3) goto L13;
    L12:
        deviceWakefulness = 2;
    L16:
        i = i + 1;
    L13:
        if (wakefulness != 3) goto L16;
        if (deviceWakefulness != 0) goto L16;
        deviceWakefulness = 3;
        goto L16
    L7:
        return 1;
    L18:
        return deviceWakefulness;
    }

    void onPowerGroupEventLocked(int event, PowerGroup powerGroup) {
        this.mWakefulnessChanging = true;
        this.mDirty |= 2;
        int groupId = powerGroup.getGroupId();
        if (event != 1) goto L5;
        this.mPowerGroups.delete(groupId);
    L5:
        int oldWakefulness = getGlobalWakefulnessLocked();
        int newWakefulness = recalculateGlobalWakefulnessLocked();
        if (event != 0) goto L9;
        if (newWakefulness != 1) goto L9;
        userActivityNoUpdateLocked(powerGroup, this.mClock.uptimeMillis(), 0, 0, 1000);
        int newWakefulness2 = newWakefulness;
        this.mNotifier.onGroupWakefulnessChangeStarted(groupId, powerGroup.getWakefulnessLocked(), 10, this.mClock.uptimeMillis());
    L14:
        if (oldWakefulness == newWakefulness2) goto L28;
        int reason = 11;
        switch(newWakefulness2) {
            case 1: goto L22;
            case 2: goto L17;
            case 3: goto L18;
            default: goto L17;
        };
    L17:
        int reason2 = 0;
    L26:
        updateGlobalWakefulnessLocked(this.mClock.uptimeMillis(), reason2, 1000, 1000, this.mContext.getOpPackageName(), "groupId: " + groupId);
        goto L28
    L18:
        if (event == 1) goto L21;
        reason = 12;
    L21:
        reason2 = reason;
        goto L26
    L22:
        if (event != 0) goto L25;
        reason = 10;
    L25:
        reason2 = reason;
    L28:
        this.mDirty |= 65536;
        updatePowerStateLocked();
        return;
    L9:
        newWakefulness2 = newWakefulness;
        if (event != 1) goto L12;
        this.mNotifier.onGroupRemoved(groupId);
        goto L14
    L12:
        if (event != 2) goto L14;
        this.mNotifier.onGroupChanged();
        goto L14
    }

    private void logSleepTimeoutRecapturedLocked() {
        long now = this.mClock.uptimeMillis();
        long savedWakeTimeMs = this.mOverriddenTimeout - now;
        if (savedWakeTimeMs < 0) goto L6;
        EventLogTags.writePowerSoftSleepRequested(savedWakeTimeMs);
        this.mOverriddenTimeout = -1;
        return;
    }

    private void finishWakefulnessChangeIfNeededLocked() {
        if (this.mWakefulnessChanging == true) goto L5;
        return;
    L5:
        if (areAllPowerGroupsReadyLocked() == true) goto L7;
        return;
    L7:
        if (getGlobalWakefulnessLocked() == 3) goto L9;
    L11:
        this.mDozeStartInProgress = false;
        if (getGlobalWakefulnessLocked() != 3) goto L14;
    L15:
        logSleepTimeoutRecapturedLocked();
    L16:
        this.mWakefulnessChanging = false;
        this.mNotifier.onWakefulnessChangeFinished();
        return;
    L14:
        if (getGlobalWakefulnessLocked() != 0) goto L16;
    L9:
        if ((this.mWakeLockSummary & 64) != 0) goto L11;
    }

    private boolean areAllPowerGroupsReadyLocked() {
        int size = this.mPowerGroups.size();
        int i = 0;
    L3:
        if (i >= size) goto L9;
        if (this.mPowerGroups.valueAt(i).isReadyLocked() == false) goto L6;
        i = i + 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    protected void updatePowerStateLocked() {
        if (this.mSystemReady == true) goto L5;
        return;
    L5:
        if (this.mDirty != 0) goto L7;
        return;
    L7:
        if (this.mUpdatePowerStateInProgress == false) goto L10;
        return;
    L10:
        if (Thread.holdsLock(this.mLock) == true) goto L12;
        Slog.wtf(TAG, "Power manager lock was not held when calling updatePowerStateLocked");
    L12:
        Trace.traceBegin(131072, "updatePowerState");
        this.mUpdatePowerStateInProgress = true;
        updateIsPoweredLocked(this.mDirty);     // Catch: Throwable -> L19
        updateStayOnLocked(this.mDirty);     // Catch: Throwable -> L19
        updateScreenBrightnessBoostLocked(this.mDirty);     // Catch: Throwable -> L19
        long now = this.mClock.uptimeMillis();     // Catch: Throwable -> L19
        int dirtyPhase2 = 0;
    L14:
        int dirtyPhase1 = this.mDirty;     // Catch: Throwable -> L19
        dirtyPhase2 = dirtyPhase2 | dirtyPhase1;     // Catch: Throwable -> L19
        this.mDirty = 0;     // Catch: Throwable -> L19
        updateWakeLockSummaryLocked(dirtyPhase1);     // Catch: Throwable -> L19
        updateUserActivitySummaryLocked(now, dirtyPhase1);     // Catch: Throwable -> L19
        updateAttentiveStateLocked(now, dirtyPhase1);     // Catch: Throwable -> L19
        if (updateWakefulnessLocked(dirtyPhase1) == true) goto L14;
        updateProfilesLocked(now);     // Catch: Throwable -> L19
        boolean powerGroupsBecameReady = updatePowerGroupsLocked(dirtyPhase2);     // Catch: Throwable -> L19
        updateDreamLocked(dirtyPhase2, powerGroupsBecameReady);     // Catch: Throwable -> L19
        finishWakefulnessChangeIfNeededLocked();     // Catch: Throwable -> L19
        notifyScreenTimeoutPolicyChangesLocked();     // Catch: Throwable -> L19
        updateSuspendBlockerLocked();     // Catch: Throwable -> L19
        Trace.traceEnd(131072);
        this.mUpdatePowerStateInProgress = false;
        return;
    L19:
        th = move-exception;
        Trace.traceEnd(131072);
        this.mUpdatePowerStateInProgress = false;
        throw th;
    }

    private void updateProfilesLocked(long now) {
        int numProfiles = this.mProfilePowerState.size();
        int i = 0;
    L3:
        if (i >= numProfiles) goto L12;
        ProfilePowerState profile = this.mProfilePowerState.valueAt(i);
        if (isProfileBeingKeptAwakeLocked(profile, now) == false) goto L8;
        profile.mLockingNotified = false;
    L10:
        i = i + 1;
        goto L3
    L8:
        if (profile.mLockingNotified == true) goto L10;
        profile.mLockingNotified = true;
        this.mNotifier.onProfileTimeout(profile.mUserId);
        goto L10
    }

    private boolean isProfileBeingKeptAwakeLocked(ProfilePowerState profile, long now) {
        if ((profile.mLastUserActivityTime + profile.mScreenOffTimeout) <= now) goto L5;
    L12:
        return true;
    L5:
        if ((profile.mWakeLockSummary & 32) != 0) goto L12;
        if (this.mProximityPositive == true) goto L9;
    L11:
        return false;
    L9:
        if ((profile.mWakeLockSummary & 16) == 0) goto L11;
        goto L11
    }

    private void updateIsPoweredLocked(int dirty) {
        if ((dirty & 256) == 0) goto L36;
        boolean wasPowered = this.mIsPowered;
        int oldPlugType = this.mPlugType;
        this.mIsPowered = this.mBatteryManagerInternal.isPowered(15);
        this.mPlugType = this.mBatteryManagerInternal.getPlugType();
        int oldBatteryLevel = this.mBatteryLevel;
        this.mBatteryLevel = this.mBatteryManagerInternal.getBatteryLevel();
        this.mBatteryLevelLow = this.mBatteryManagerInternal.getBatteryLevelLow();
        if (this.mBatteryManagerInternal.getBatteryHealth() != 3) goto L7;
        boolean r1 = true;
    L8:
        boolean isOverheat = r1;
        if (isOverheat == true) goto L15;
        if (oldBatteryLevel <= 0) goto L15;
        if (getGlobalWakefulnessLocked() != 2) goto L15;
        this.mDreamsBatteryLevelDrain += oldBatteryLevel - this.mBatteryLevel;
    L15:
        if (wasPowered == this.mIsPowered) goto L17;
    L18:
        this.mDirty |= 64;
        boolean dockedOnWirelessCharger = this.mWirelessChargerDetector.update(this.mIsPowered, this.mPlugType);
        long now = this.mClock.uptimeMillis();
        if (shouldWakeUpWhenPluggedOrUnpluggedLocked(wasPowered, oldPlugType, dockedOnWirelessCharger) == false) goto L21;
        wakePowerGroupLocked(this.mPowerGroups.get(0), now, 3, "android.server.power:PLUGGED:" + this.mIsPowered, 1000, this.mContext.getOpPackageName(), 1000);
    L21:
        userActivityNoUpdateLocked(this.mPowerGroups.get(0), now, 0, 0, 1000);
        if (this.mBootCompleted == true) goto L24;
    L33:
        if (this.mBatterySaverSupported == false) goto L37;
        this.mBatterySaverStateMachine.setBatteryStatus(this.mIsPowered, this.mBatteryLevel, this.mBatteryLevelLow);
        return;
    L37:
        return;
    L24:
        if (this.mIsPowered == true) goto L26;
    L30:
        if (dockedOnWirelessCharger == false) goto L33;
        this.mNotifier.onWirelessChargingStarted(this.mBatteryLevel, this.mUserId);
        goto L33
    L26:
        if (BatteryManager.isPlugWired(oldPlugType) == true) goto L30;
        if (BatteryManager.isPlugWired(this.mPlugType) == false) goto L30;
        this.mNotifier.onWiredChargingStarted(this.mUserId);
        goto L33
    L17:
        if (oldPlugType == this.mPlugType) goto L33;
    L7:
        r1 = false;
        goto L8
    }

    private boolean shouldWakeUpWhenPluggedOrUnpluggedLocked(boolean wasPowered, int oldPlugType, boolean dockedOnWirelessCharger) {
        if (this.mWakeUpWhenPluggedOrUnpluggedConfig == true) goto L6;
        return false;
    L6:
        if (this.mKeepDreamingWhenUnplugging == false) goto L14;
        if (getGlobalWakefulnessLocked() != 2) goto L14;
        if (wasPowered == false) goto L14;
        if (this.mIsPowered == true) goto L14;
        return false;
    L14:
        if (wasPowered == true) goto L16;
    L21:
        if (wasPowered == true) goto L29;
        if (this.mIsPowered == false) goto L29;
        if (this.mPlugType != 4) goto L29;
        if (dockedOnWirelessCharger == true) goto L29;
        return false;
    L29:
        if (this.mIsPowered == false) goto L34;
        if (getGlobalWakefulnessLocked() != 2) goto L34;
        return false;
    L34:
        if (this.mTheaterModeEnabled == true) goto L36;
    L38:
        this.mExt.shouldWakeUpWhenPluggedOrUnpluggedLocked(wasPowered, this.mIsPowered, oldPlugType, this.mPlugType, dockedOnWirelessCharger, getGlobalWakefulnessLocked());
        return true;
    L36:
        if (this.mWakeUpWhenPluggedOrUnpluggedInTheaterModeConfig == true) goto L38;
        return false;
    L16:
        if (this.mIsPowered == true) goto L21;
        if (oldPlugType != 4) goto L21;
        if (this.mExt.shouldWakeUpWhenUndockedFromWirelessCharger() == true) goto L21;
        return false;
    }

    private void updateStayOnLocked(int dirty) {
        if ((dirty & 288) == 0) goto L20;
        boolean wasStayOn = this.mStayOn;
        if (this.mStayOnWhilePluggedInSetting != 0) goto L7;
    L9:
        this.mStayOn = false;
    L11:
        if (this.mStayOnAlltimeSetting == 0) goto L17;
        if (isScreenLocked() == false) goto L15;
        this.mStayOn = false;
        goto L17
    L15:
        this.mStayOn = true;
    L17:
        if (this.mStayOn == wasStayOn) goto L21;
        this.mDirty |= 128;
        return;
    L21:
        return;
    L7:
        if (isMaximumScreenOffTimeoutFromDeviceAdminEnforcedLocked() == true) goto L9;
        this.mStayOn = this.mBatteryManagerInternal.isPowered(this.mStayOnWhilePluggedInSetting);
        goto L11
    }

    private void updateWakeLockSummaryLocked(int dirty) {
        if ((65539 & dirty) == 0) goto L41;
        this.mWakeLockSummary = 0;
        int numProfiles = this.mProfilePowerState.size();
        int i = 0;
    L5:
        if (i >= numProfiles) goto L7;
        this.mProfilePowerState.valueAt(i).mWakeLockSummary = 0;
        i = i + 1;
        goto L5
    L7:
        int idx = 0;
    L9:
        if (idx >= this.mPowerGroups.size()) goto L11;
        this.mPowerGroups.valueAt(idx).setWakeLockSummaryLocked(0);
        idx = idx + 1;
        goto L9
    L11:
        int invalidGroupWakeLockSummary = 0;
        int numWakeLocks = this.mWakeLocks.size();
        int i2 = 0;
    L12:
        if (i2 >= numWakeLocks) goto L32;
        WakeLock wakeLock = this.mWakeLocks.get(i2);
        Integer groupId = wakeLock.getPowerGroupId();
        if (groupId == null) goto L30;
        if (groupId.intValue() != (-1)) goto L18;
    L20:
        PowerGroup powerGroup = this.mPowerGroups.get(groupId.intValue());
        int wakeLockFlags = getWakeLockSummaryFlags(wakeLock);
        this.mWakeLockSummary |= wakeLockFlags;
        if (groupId.intValue() == (-1)) goto L23;
        int wakeLockSummary = powerGroup.getWakeLockSummaryLocked();
        powerGroup.setWakeLockSummaryLocked(wakeLockSummary | wakeLockFlags);
    L24:
        int j = 0;
    L25:
        if (j >= numProfiles) goto L30;
        ProfilePowerState profile = this.mProfilePowerState.valueAt(j);
        if (wakeLockAffectsUser(wakeLock, profile.mUserId) == false) goto L29;
        profile.mWakeLockSummary |= wakeLockFlags;
    L29:
        j = j + 1;
        goto L25
    L23:
        invalidGroupWakeLockSummary = invalidGroupWakeLockSummary | wakeLockFlags;
        goto L24
    L18:
        if (this.mPowerGroups.contains(groupId.intValue()) == true) goto L20;
    L30:
        i2 = i2 + 1;
        goto L12
    L32:
        if (this.mScreenTimeoutOverridePolicy == null) goto L34;
        this.mScreenTimeoutOverridePolicy.checkScreenWakeLock(this.mWakeLockSummary);
    L34:
        int idx2 = 0;
    L36:
        if (idx2 >= this.mPowerGroups.size()) goto L38;
        PowerGroup powerGroup2 = this.mPowerGroups.valueAt(idx2);
        int wakeLockSummary2 = adjustWakeLockSummary(powerGroup2.getWakefulnessLocked(), powerGroup2.getWakeLockSummaryLocked() | invalidGroupWakeLockSummary, !this.mSmtEx.mInCall);
        powerGroup2.setWakeLockSummaryLocked(wakeLockSummary2);
        idx2 = idx2 + 1;
        goto L36
    L38:
        int idx3 = getGlobalWakefulnessLocked();
        this.mWakeLockSummary = adjustWakeLockSummary(idx3, this.mWakeLockSummary, !this.mSmtEx.mInCall);
        int i3 = 0;
    L39:
        if (i3 >= numProfiles) goto L52;
        ProfilePowerState profile2 = this.mProfilePowerState.valueAt(i3);
        profile2.mWakeLockSummary = adjustWakeLockSummary(getGlobalWakefulnessLocked(), profile2.mWakeLockSummary, !this.mSmtEx.mInCall);
        i3 = i3 + 1;
        goto L39
    L52:
        return;
    }

    private static int adjustWakeLockSummary(int wakefulness, int wakeLockSummary, boolean notInCall) {
        if (wakefulness == 3) goto L5;
        wakeLockSummary = wakeLockSummary & (-193);
    L5:
        if (wakefulness != 0) goto L7;
    L8:
        wakeLockSummary = wakeLockSummary & (-15);
        if (wakefulness != 0) goto L13;
        if (notInCall == false) goto L13;
        wakeLockSummary = wakeLockSummary & (-17);
    L13:
        if ((wakeLockSummary & 6) == 0) goto L21;
        if (wakefulness != 1) goto L18;
        wakeLockSummary = wakeLockSummary | 33;
        goto L21
    L18:
        if (wakefulness != 2) goto L21;
        wakeLockSummary = wakeLockSummary | 1;
    L21:
        if ((wakeLockSummary & 128) != 0) goto L23;
        return wakeLockSummary;
    L23:
        return wakeLockSummary | 1;
    L7:
        if ((wakeLockSummary & 64) == 0) goto L13;
        goto L8
    }

    private int getWakeLockSummaryFlags(WakeLock wakeLock) {
        if (wakeLock.mDisabled == false) goto L6;
        return 0;
    L6:
        switch((wakeLock.mFlags & 65535)) {
            case 1: goto L22;
            case 6: goto L20;
            case 10: goto L18;
            case 26: goto L16;
            case 32: goto L14;
            case 64: goto L12;
            case 128: goto L10;
            case 256: goto L8;
            default: goto L7;
        };
    L7:
        return 0;
    L8:
        return 256;
    L10:
        return 128;
    L12:
        return 64;
    L14:
        PowerManagerServiceSmtEx r0 = this.mSmtEx;
        r0.mInCall = this.mSmtEx.isCallProxLock(wakeLock);
        return 16;
    L16:
        return 10;
    L18:
        return 2;
    L20:
        return 4;
    L22:
        return 1;
    }

    private boolean wakeLockAffectsUser(WakeLock wakeLock, int userId) {
        if (wakeLock.mWorkSource == null) goto L21;
        int k = 0;
    L6:
        if (k >= wakeLock.mWorkSource.size()) goto L11;
        int uid = wakeLock.mWorkSource.getUid(k);
        if (userId == UserHandle.getUserId(uid)) goto L9;
        k = k + 1;
        goto L6
    L9:
        return true;
    L11:
        List<WorkSource.WorkChain> workChains = wakeLock.mWorkSource.getWorkChains();
        if (workChains == null) goto L21;
        int k2 = 0;
    L15:
        if (k2 >= workChains.size()) goto L21;
        int uid2 = workChains.get(k2).getAttributionUid();
        if (userId == UserHandle.getUserId(uid2)) goto L18;
        k2 = k2 + 1;
        goto L15
    L18:
        return true;
    L21:
        if (userId == UserHandle.getUserId(wakeLock.mOwnerUid)) goto L29;
        return false;
    L29:
        return true;
    }

    void checkForLongWakeLocks() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long now = this.mClock.uptimeMillis();     // Catch: Throwable -> L15
        this.mNotifyLongDispatched = now;     // Catch: Throwable -> L15
        long when = now - 60000;     // Catch: Throwable -> L15
        long nextCheckTime = Long.MAX_VALUE;
        int numWakeLocks = this.mWakeLocks.size();     // Catch: Throwable -> L15
        int i = 0;
    L5:
        if (i >= numWakeLocks) goto L21;
        WakeLock wakeLock = this.mWakeLocks.get(i);     // Catch: Throwable -> L15
        if ((wakeLock.mFlags & 65535) != 1) goto L20;
        if (wakeLock.mNotifiedAcquired == false) goto L20;
        if (wakeLock.mNotifiedLong == true) goto L20;
        if (wakeLock.mAcquireTime >= when) goto L17;
        notifyWakeLockLongStartedLocked(wakeLock);     // Catch: Throwable -> L15
        goto L20
    L17:
        long checkTime = wakeLock.mAcquireTime + 60000;     // Catch: Throwable -> L15
        if (checkTime >= nextCheckTime) goto L20;
        nextCheckTime = checkTime;
    L20:
        i = i + 1;     // Catch: Throwable -> L15
        goto L5
    L21:
        this.mNotifyLongScheduled = 0;     // Catch: Throwable -> L15
        this.mHandler.removeMessages(4);     // Catch: Throwable -> L15
        if (nextCheckTime == Long.MAX_VALUE) goto L24;
        this.mNotifyLongNextCheck = nextCheckTime;     // Catch: Throwable -> L15
        enqueueNotifyLongMsgLocked(nextCheckTime);     // Catch: Throwable -> L15
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L24:
        this.mNotifyLongNextCheck = 0;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void updateUserActivitySummaryLocked(long now, int dirty) {
        if ((dirty & 81959) != 0) goto L5;
        return;
    L5:
        this.mHandler.removeMessages(1);
        long attentiveTimeout = getAttentiveTimeoutLocked();
        long defaultSleepTimeout = getSleepTimeoutLocked(attentiveTimeout);
        long defaultScreenOffTimeout = getScreenOffTimeoutLocked(defaultSleepTimeout, attentiveTimeout);
        long defaultScreenDimDuration = getScreenDimDurationLocked(defaultScreenOffTimeout);
        boolean userInactiveOverride = this.mUserInactiveOverrideFromWindowManager;
        long nextTimeout = -1;
        boolean hasUserActivitySummary = false;
        int idx = 0;
    L6:
        boolean userInactiveOverride2 = userInactiveOverride;
        if (idx >= this.mPowerGroups.size()) goto L79;
        long groupNextTimeout = 0;
        int groupUserActivitySummary = 0;
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);
        int wakefulness = powerGroup.getWakefulnessLocked();
        long screenOffTimeout = defaultScreenOffTimeout;
        long sleepTimeout = defaultSleepTimeout;
        if (powerGroup.getGroupId() != 0) goto L11;
        long attentiveTimeout2 = attentiveTimeout;
        int idx2 = idx;
        long screenOffTimeout2 = defaultSleepTimeout;
        long screenOffTimeout3 = getDefaultGroupScreenOffTimeoutOverrideLocked(screenOffTimeout, defaultScreenDimDuration);
        long screenDimDuration = getScreenDimDurationLocked(screenOffTimeout3);
    L17:
        if (wakefulness == 0) goto L77;
        long screenOffTimeout4 = screenOffTimeout3;
        long lastUserActivityTime = powerGroup.getLastUserActivityTimeLocked();
        long defaultScreenOffTimeout2 = defaultScreenOffTimeout;
        int idx3 = idx2;
        long lastUserActivityTimeNoChangeLights = powerGroup.getLastUserActivityTimeNoChangeLightsLocked();
        if (lastUserActivityTime < powerGroup.getLastWakeTimeLocked()) goto L26;
        groupNextTimeout = (lastUserActivityTime + screenOffTimeout4) - screenDimDuration;
        if (now >= groupNextTimeout) goto L23;
        groupUserActivitySummary = 1;
        goto L26
    L23:
        groupNextTimeout = lastUserActivityTime + screenOffTimeout4;
        if (now >= groupNextTimeout) goto L26;
        groupUserActivitySummary = 2;
    L26:
        if (groupUserActivitySummary == 0) goto L28;
    L37:
        if (groupUserActivitySummary == 0) goto L39;
        long lastUserActivityTime2 = groupNextTimeout;
        int groupUserActivitySummary2 = groupUserActivitySummary;
    L49:
        if (groupUserActivitySummary2 == 4) goto L58;
        if (userInactiveOverride2 == false) goto L58;
        if ((groupUserActivitySummary2 & 3) == 0) goto L57;
        if (this.mOverriddenTimeout != (-1)) goto L57;
        this.mOverriddenTimeout = lastUserActivityTime2;
    L57:
        int groupUserActivitySummary3 = 4;
        lastUserActivityTime2 = -1;
    L60:
        if ((groupUserActivitySummary3 & 1) == 0) goto L65;
        if ((powerGroup.getWakeLockSummaryLocked() & 32) != 0) goto L65;
        lastUserActivityTime2 = this.mAttentionDetector.updateUserActivity(lastUserActivityTime2, screenDimDuration);
    L65:
        if (isAttentiveTimeoutExpired(powerGroup, now) == false) goto L67;
        groupUserActivitySummary3 = 0;
        lastUserActivityTime2 = -1;
    L67:
        if (groupUserActivitySummary3 == 0) goto L69;
        boolean r9 = true;
    L70:
        boolean hasUserActivitySummary2 = r9 | hasUserActivitySummary;
        if (nextTimeout != (-1)) goto L74;
        nextTimeout = lastUserActivityTime2;
        hasUserActivitySummary = hasUserActivitySummary2;
    L78:
        powerGroup.setUserActivitySummaryLocked(groupUserActivitySummary3);
        idx = idx3 + 1;
        userInactiveOverride = userInactiveOverride2;
        defaultSleepTimeout = screenOffTimeout2;
        attentiveTimeout = attentiveTimeout2;
        defaultScreenOffTimeout = defaultScreenOffTimeout2;
        goto L6
    L74:
        if (lastUserActivityTime2 == (-1)) goto L76;
        nextTimeout = Math.min(nextTimeout, lastUserActivityTime2);
        hasUserActivitySummary = hasUserActivitySummary2;
        goto L78
    L76:
        hasUserActivitySummary = hasUserActivitySummary2;
        goto L78
    L69:
        r9 = false;
    L58:
        groupUserActivitySummary3 = groupUserActivitySummary2;
        goto L60
    L39:
        if (sleepTimeout < 0) goto L46;
        long anyUserActivity = Math.max(lastUserActivityTime, lastUserActivityTimeNoChangeLights);
        if (anyUserActivity < powerGroup.getLastWakeTimeLocked()) goto L45;
        groupNextTimeout = anyUserActivity + sleepTimeout;
        if (now >= groupNextTimeout) goto L45;
        groupUserActivitySummary = 4;
    L45:
        lastUserActivityTime2 = groupNextTimeout;
        groupUserActivitySummary2 = groupUserActivitySummary;
        goto L49
    L46:
        lastUserActivityTime2 = -1;
        groupUserActivitySummary2 = 4;
        goto L49
    L28:
        if (lastUserActivityTimeNoChangeLights < powerGroup.getLastWakeTimeLocked()) goto L37;
        groupNextTimeout = lastUserActivityTimeNoChangeLights + screenOffTimeout4;
        if (now >= groupNextTimeout) goto L37;
        if (powerGroup.isPolicyBrightLocked() == false) goto L35;
        groupUserActivitySummary = 1;
        goto L37
    L35:
        if (powerGroup.isPolicyDimLocked() == false) goto L37;
        groupUserActivitySummary = 2;
        goto L37
    L77:
        defaultScreenOffTimeout2 = defaultScreenOffTimeout;
        idx3 = idx2;
        groupUserActivitySummary3 = 0;
        goto L78
    L11:
        attentiveTimeout2 = attentiveTimeout;
        idx2 = idx;
        screenOffTimeout2 = defaultSleepTimeout;
        screenOffTimeout3 = powerGroup.getScreenOffTimeoutOverrideLocked(screenOffTimeout);
        long screenDimDuration2 = powerGroup.getScreenDimDurationOverrideLocked(defaultScreenDimDuration);
        if (sleepTimeout > 0) goto L14;
    L16:
        sleepTimeout = sleepTimeout;
        screenDimDuration = screenDimDuration2;
        goto L17
    L14:
        if (screenOffTimeout3 <= 0) goto L16;
        sleepTimeout = Math.max(sleepTimeout, screenOffTimeout3);
        screenDimDuration = screenDimDuration2;
        goto L17
    L79:
        long nextProfileTimeout = getNextProfileTimeoutLocked(now);
        if (nextProfileTimeout <= 0) goto L82;
        nextTimeout = Math.min(nextTimeout, nextProfileTimeout);
    L82:
        if (hasUserActivitySummary == true) goto L84;
        return;
    L84:
        if (nextTimeout < 0) goto L93;
        scheduleUserInactivityTimeout(nextTimeout);
        return;
    }

    private void scheduleUserInactivityTimeout(long timeMs) {
        Message msg = this.mHandler.obtainMessage(1);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageAtTime(msg, timeMs);
    }

    private void scheduleAttentiveTimeout(long timeMs) {
        Message msg = this.mHandler.obtainMessage(5);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageAtTime(msg, timeMs);
    }

    private long getNextProfileTimeoutLocked(long now) {
        long nextTimeout = -1;
        int numProfiles = this.mProfilePowerState.size();
        int i = 0;
    L3:
        if (i >= numProfiles) goto L13;
        ProfilePowerState profile = this.mProfilePowerState.valueAt(i);
        long timeout = profile.mLastUserActivityTime + profile.mScreenOffTimeout;
        if (timeout <= now) goto L11;
        if (nextTimeout != (-1)) goto L9;
    L10:
        nextTimeout = timeout;
        goto L11
    L9:
        if (timeout < nextTimeout) goto L10;
    L11:
        i = i + 1;
        goto L3
    L13:
        return nextTimeout;
    }

    private void updateAttentiveStateLocked(long now, int dirty) {
        long attentiveTimeout = getAttentiveTimeoutLocked();
        long goToSleepTime = this.mPowerGroups.get(0).getLastUserActivityTimeLocked() + attentiveTimeout;
        long showWarningTime = goToSleepTime - this.mAttentiveWarningDurationConfig;
        boolean warningDismissed = maybeHideInattentiveSleepWarningLocked(now, showWarningTime);
        if (attentiveTimeout < 0) goto L22;
        if (warningDismissed == false) goto L6;
    L7:
        this.mHandler.removeMessages(5);
        if (getGlobalWakefulnessLocked() != 0) goto L10;
        return;
    L10:
        if (isBeingKeptFromInattentiveSleepLocked() == true) goto L23;
        long nextTimeout = -1;
        if (now >= showWarningTime) goto L16;
        nextTimeout = showWarningTime;
    L19:
        if (nextTimeout < 0) goto L25;
        scheduleAttentiveTimeout(nextTimeout);
        return;
    L25:
        return;
    L16:
        if (now >= goToSleepTime) goto L19;
        this.mInattentiveSleepWarningOverlayController.show();
        nextTimeout = goToSleepTime;
        goto L19
    L23:
        return;
    L6:
        if ((dirty & 19122) != 0) goto L7;
        return;
    }

    private boolean maybeHideInattentiveSleepWarningLocked(long now, long showWarningTime) {
        long attentiveTimeout = getAttentiveTimeoutLocked();
        if (this.mInattentiveSleepWarningOverlayController.isShown() == true) goto L6;
        return false;
    L6:
        if (getGlobalWakefulnessLocked() != 0) goto L10;
        this.mInattentiveSleepWarningOverlayController.dismiss(false);
        return true;
    L10:
        if (attentiveTimeout >= 0) goto L12;
    L17:
        this.mInattentiveSleepWarningOverlayController.dismiss(true);
        return true;
    L12:
        if (isBeingKeptFromInattentiveSleepLocked() == true) goto L17;
        if (now < showWarningTime) goto L17;
        return false;
    }

    private boolean isAttentiveTimeoutExpired(PowerGroup powerGroup, long now) {
        long attentiveTimeout = getAttentiveTimeoutLocked();
        if (powerGroup.getGroupId() == 0) goto L5;
    L9:
        return false;
    L5:
        if (attentiveTimeout < 0) goto L9;
        if (now < (powerGroup.getLastUserActivityTimeLocked() + attentiveTimeout)) goto L9;
        return true;
    }

    private void handleUserActivityTimeout() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDirty |= 4;     // Catch: Throwable -> L7
        updatePowerStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleAttentiveTimeout() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDirty |= 16384;     // Catch: Throwable -> L7
        updatePowerStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private long getAttentiveTimeoutLocked() {
        long timeout = this.mAttentiveTimeoutSetting;
        if (timeout > 0) goto L7;
        return -1;
    L7:
        return Math.max(timeout, this.mMinimumScreenOffTimeoutConfig);
    }

    private long getSleepTimeoutLocked(long attentiveTimeout) {
        long timeout = this.mSleepTimeoutSetting;
        if (timeout > 0) goto L7;
        return -1;
    L7:
        if (attentiveTimeout < 0) goto L10;
        timeout = Math.min(timeout, attentiveTimeout);
    L10:
        return Math.max(timeout, this.mMinimumScreenOffTimeoutConfig);
    }

    private long getScreenOffTimeoutLocked(long sleepTimeout, long attentiveTimeout) {
        long timeout = this.mScreenOffTimeoutSetting;
        if (isMaximumScreenOffTimeoutFromDeviceAdminEnforcedLocked() == false) goto L6;
        timeout = Math.min(timeout, this.mMaximumScreenOffTimeoutFromDeviceAdmin);
    L6:
        if (this.mUserActivityTimeoutOverrideFromWindowManager < 0) goto L9;
        timeout = Math.min(timeout, this.mUserActivityTimeoutOverrideFromWindowManager);
    L9:
        if (sleepTimeout < 0) goto L12;
        timeout = Math.min(timeout, sleepTimeout);
    L12:
        if (attentiveTimeout < 0) goto L15;
        timeout = Math.min(timeout, attentiveTimeout);
    L15:
        return Math.max(timeout, this.mMinimumScreenOffTimeoutConfig);
    }

    private long getScreenDimDurationLocked(long screenOffTimeout) {
        return Math.min(this.mMaximumScreenDimDurationConfig, (long) (screenOffTimeout * this.mMaximumScreenDimRatioConfig));
    }

    long getDefaultGroupScreenOffTimeoutOverrideLocked(long screenOffTimeout, long screenDimDuration) {
        long shortestScreenOffTimeout = screenOffTimeout;
        if (this.mScreenTimeoutOverridePolicy == null) goto L6;
        shortestScreenOffTimeout = this.mScreenTimeoutOverridePolicy.getScreenTimeoutOverrideLocked(this.mWakeLockSummary, screenOffTimeout);
    L6:
        if (this.mIsFaceDown == true) goto L8;
        return shortestScreenOffTimeout;
    L8:
        return Math.min(screenDimDuration, shortestScreenOffTimeout);
    }

    private boolean updateWakefulnessLocked(int dirty) {
        boolean changed = false;
        if ((151223 & dirty) != 0) goto L5;
        return false;
    L5:
        long time = this.mClock.uptimeMillis();
        int idx = 0;
    L7:
        if (idx >= this.mPowerGroups.size()) goto L22;
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);
        if (powerGroup.getWakefulnessLocked() != 1) goto L20;
        if (isItBedTimeYetLocked(powerGroup) == false) goto L20;
        if (isAttentiveTimeoutExpired(powerGroup, time) == false) goto L17;
        changed = sleepPowerGroupLocked(powerGroup, time, 9, 1000);
        goto L20
    L17:
        if (shouldNapAtBedTimeLocked(powerGroup) == false) goto L19;
        changed = dreamPowerGroupLocked(powerGroup, time, 1000, false);
        goto L20
    L19:
        changed = dozePowerGroupLocked(powerGroup, time, 2, 1000);
    L20:
        idx = idx + 1;
        goto L7
    L22:
        return changed;
    }

    private boolean shouldNapAtBedTimeLocked(PowerGroup powerGroup) {
        if (powerGroup.supportsSandmanLocked() == true) goto L6;
        return false;
    L6:
        if (this.mDreamsActivateOnSleepSetting == false) goto L8;
    L15:
        return true;
    L8:
        if (this.mDreamsActivateOnDockSetting == false) goto L12;
        if (this.mDockState != 0) goto L15;
    L12:
        if (this.mDreamsActivateWhilePosturedSetting == true) goto L14;
        return false;
    L14:
        if (this.mDevicePostured == true) goto L15;
        return false;
    }

    private boolean isItBedTimeYetLocked(PowerGroup powerGroup) {
        if (this.mBootCompleted == true) goto L6;
        return false;
    L6:
        long now = this.mClock.uptimeMillis();
        if (isAttentiveTimeoutExpired(powerGroup, now) == false) goto L11;
        return !isBeingKeptFromInattentiveSleepLocked();
    L11:
        return !isBeingKeptAwakeLocked(powerGroup);
    }

    private boolean isBeingKeptAwakeLocked(PowerGroup powerGroup) {
        if (this.mStayOn == false) goto L5;
    L14:
        return true;
    L5:
        if (this.mProximityPositive == true) goto L14;
        if ((powerGroup.getWakeLockSummaryLocked() & 32) != 0) goto L14;
        if ((powerGroup.getUserActivitySummaryLocked() & 3) != 0) goto L14;
        if (this.mScreenBrightnessBoostInProgress == true) goto L14;
        return false;
    }

    private boolean isBeingKeptFromInattentiveSleepLocked() {
        if (this.mStayOn == false) goto L5;
    L12:
        return true;
    L5:
        if (this.mScreenBrightnessBoostInProgress == true) goto L12;
        if (this.mProximityPositive == true) goto L12;
        if (this.mBootCompleted == false) goto L12;
        return false;
    }

    private void updateDreamLocked(int dirty, boolean powerGroupBecameReady) {
        if ((dirty & 17407) != 0) goto L6;
        if (powerGroupBecameReady == true) goto L6;
        return;
    L6:
        if (areAllPowerGroupsReadyLocked() == false) goto L10;
        scheduleSandmanLocked();
        return;
    }

    private void scheduleSandmanLocked() {
        if (this.mSandmanScheduled == true) goto L11;
        this.mSandmanScheduled = true;
        int idx = 0;
    L6:
        if (idx >= this.mPowerGroups.size()) goto L15;
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);
        if (powerGroup.supportsSandmanLocked() == false) goto L10;
        Message msg = this.mHandler.obtainMessage(2);
        msg.arg1 = powerGroup.getGroupId();
        msg.setAsynchronous(true);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    L10:
        idx = idx + 1;
        goto L6
    L15:
        return;
    }

    private void handleSandman(int groupId) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mSandmanScheduled = false;     // Catch: Throwable -> L9
        if (this.mPowerGroups.contains(groupId) == true) goto L11;
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L11:
        PowerGroup powerGroup = this.mPowerGroups.get(groupId);     // Catch: Throwable -> L9
        int wakefulness = powerGroup.getWakefulnessLocked();     // Catch: Throwable -> L9
        boolean r5 = true;
        if (powerGroup.isSandmanSummonedLocked() == true) goto L14;
    L23:
        boolean startDreaming = false;
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L9
        if (this.mDreamManager == null) goto L34;
        if (startDreaming == false) goto L33;
        this.mDreamManager.stopDream(false, "power manager request before starting dream");
        DreamManagerInternal r3 = this.mDreamManager;
        if (wakefulness == 3) goto L32;
        r5 = false;
    L32:
        r3.startDream(r5, "power manager request");
    L33:
        boolean isDreaming = this.mDreamManager.isDreaming();
    L36:
        if (com.android.server.common.Constants.ENABLE_GAME_ASSIST == false) goto L38;
        SystemWakefulnessEventDispatcher.getInstance().notifyWakefulnessChanged(groupId, wakefulness);
    L38:
        this.mDozeStartInProgress = false;
        Object r14 = this.mLock;
        monitor-enter(r14);
    L44:
        th = move-exception;
        throw th;
    L41:
        if (this.mPowerGroups.contains(groupId) == true) goto L46;
        monitor-exit(r14);     // Catch: Throwable -> L44
        return;
    L46:
        if (startDreaming == false) goto L52;
        if (isDreaming == false) goto L52;
        this.mDreamsBatteryLevelDrain = 0;     // Catch: Throwable -> L44
        if (wakefulness != 3) goto L51;
        Slog.i(TAG, "Dozing...");     // Catch: Throwable -> L44
        goto L52
    L51:
        Slog.i(TAG, "Dreaming...");     // Catch: Throwable -> L44
    L52:
        PowerGroup powerGroup2 = this.mPowerGroups.get(groupId);     // Catch: Throwable -> L44
        if (powerGroup2.isSandmanSummonedLocked() == false) goto L55;
    L90:
        monitor-exit(r14);     // Catch: Throwable -> L44
        return;
    L55:
        if (powerGroup2.getWakefulnessLocked() != wakefulness) goto L90;
        long now = this.mClock.uptimeMillis();     // Catch: Throwable -> L44
        if (wakefulness != 2) goto L78;
        if (isDreaming == false) goto L72;
        if (canDreamLocked(powerGroup2) == false) goto L72;
        if (this.mDreamsBatteryLevelDrainCutoffConfig >= 0) goto L65;
    L69:
        monitor-exit(r14);     // Catch: Throwable -> L44
        return;
    L65:
        if (this.mDreamsBatteryLevelDrain <= this.mDreamsBatteryLevelDrainCutoffConfig) goto L69;
        if (isBeingKeptAwakeLocked(powerGroup2) == true) goto L69;
        Slog.i(TAG, "Stopping dream because the battery appears to be draining faster than it is charging.  Battery level drained while dreaming: " + this.mDreamsBatteryLevelDrain + "%.  Battery level now: " + this.mBatteryLevel + "%.");     // Catch: Throwable -> L44
    L72:
        if (isItBedTimeYetLocked(powerGroup2) == true) goto L74;
        wakePowerGroupLocked(powerGroup2, now, 13, "android.server.power:DREAM_FINISHED", 1000, this.mContext.getOpPackageName(), 1000);     // Catch: Throwable -> L44
    L84:
        monitor-exit(r14);     // Catch: Throwable -> L44
        if (isDreaming == true) goto L87;
        return;
    L87:
        if (this.mDreamManager == null) goto L99;
        this.mDreamManager.stopDream(false, "power manager request");
        return;
    L99:
        return;
    L74:
        if (isAttentiveTimeoutExpired(powerGroup2, now) == false) goto L76;
        sleepPowerGroupLocked(powerGroup2, now, 2, 1000);     // Catch: Throwable -> L44
        goto L84
    L76:
        dozePowerGroupLocked(powerGroup2, now, 2, 1000);     // Catch: Throwable -> L44
        goto L84
    L78:
        if (wakefulness != 3) goto L84;
        if (isDreaming == false) goto L82;
        monitor-exit(r14);     // Catch: Throwable -> L44
        return;
    L82:
        sleepPowerGroupLocked(powerGroup2, now, 2, 1000);     // Catch: Throwable -> L44
        goto L84
    L34:
        isDreaming = false;
        goto L36
    L14:
        if (powerGroup.isReadyLocked() == false) goto L23;
        if (canDreamLocked(powerGroup) == true) goto L21;
        if (canDozeLocked(powerGroup) == true) goto L21;
        boolean startDreaming2 = false;
    L22:
        powerGroup.setSandmanSummonedLocked(false);     // Catch: Throwable -> L9
        startDreaming = startDreaming2;
    L21:
        startDreaming2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private void onDreamSuppressionChangedLocked(boolean isSuppressed) {
        if (this.mDreamsDisabledByAmbientModeSuppressionConfig == true) goto L5;
        return;
    L5:
        PowerGroup defaultPowerGroup = this.mPowerGroups.get(0);
        if (isSuppressed == false) goto L8;
    L18:
        if (isSuppressed == false) goto L22;
        this.mDirty |= 32;
        updatePowerStateLocked();
        return;
    L22:
        return;
    L8:
        if (this.mIsPowered == false) goto L18;
        if (this.mDreamsSupportedConfig == false) goto L18;
        if (this.mDreamsEnabledSetting == false) goto L18;
        if (shouldNapAtBedTimeLocked(defaultPowerGroup) == false) goto L18;
        if (isItBedTimeYetLocked(defaultPowerGroup) == false) goto L18;
        napInternal(SystemClock.uptimeMillis(), 1000, true);
    }

    private boolean canDreamLocked(PowerGroup powerGroup) {
        if (this.mDreamsDisabledByAmbientModeSuppressionConfig == true) goto L5;
    L7:
        boolean dreamsSuppressed = false;
    L9:
        if (this.mBootCompleted == false) goto L46;
        if (dreamsSuppressed == true) goto L46;
        if (getGlobalWakefulnessLocked() != 2) goto L46;
        if (this.mDreamsSupportedConfig == false) goto L46;
        if (this.mDreamsEnabledSetting == false) goto L46;
        if (powerGroup.isBrightOrDimLocked() == false) goto L46;
        if ((powerGroup.getUserActivitySummaryLocked() & 7) == 0) goto L46;
        if (isBeingKeptAwakeLocked(powerGroup) == false) goto L25;
        return true;
    L25:
        if (this.mIsPowered == true) goto L30;
        if (this.mDreamsEnabledOnBatteryConfig == true) goto L30;
        return false;
    L30:
        if (this.mIsPowered == true) goto L37;
        if (this.mDreamsBatteryLevelMinimumWhenNotPoweredConfig < 0) goto L37;
        if (this.mBatteryLevel >= this.mDreamsBatteryLevelMinimumWhenNotPoweredConfig) goto L37;
        return false;
    L37:
        if (this.mIsPowered == true) goto L39;
        return true;
    L39:
        if (this.mDreamsBatteryLevelMinimumWhenPoweredConfig >= 0) goto L41;
        return true;
    L41:
        if (this.mBatteryLevel < this.mDreamsBatteryLevelMinimumWhenPoweredConfig) goto L44;
        return true;
    L44:
        return false;
    L46:
        return false;
    L5:
        if (this.mAmbientDisplaySuppressionController.isSuppressed() == false) goto L7;
        dreamsSuppressed = true;
        goto L9
    }

    private boolean canDozeLocked(PowerGroup powerGroup) {
        if (powerGroup.supportsSandmanLocked() == true) goto L5;
    L7:
        return false;
    L5:
        if (powerGroup.getWakefulnessLocked() != 3) goto L7;
        return true;
    }

    private boolean updatePowerGroupsLocked(int dirty) {
        boolean oldPowerGroupsReady = areAllPowerGroupsReadyLocked();
        boolean r5 = false;
        if ((88127 & dirty) != 0) goto L5;
        boolean r13 = false;
        boolean r12 = true;
    L38:
        if (areAllPowerGroupsReadyLocked() == false) goto L42;
        if (oldPowerGroupsReady == true) goto L42;
        return r12;
    L42:
        return r13;
    L5:
        if ((dirty & 4096) != 0) goto L7;
    L10:
        int idx = 0;
    L12:
        if (idx >= this.mPowerGroups.size()) goto L35;
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);
        int groupId = powerGroup.getGroupId();
        if (this.mBootCompleted == true) goto L16;
        float screenBrightnessOverride = this.mScreenBrightnessDefault;
        CharSequence overrideTag = "boot";
        float screenBrightnessOverride2 = screenBrightnessOverride;
    L17:
        boolean r10 = powerGroup.mDisplayPowerRequest.useProximitySensor;
        this.mDozeAfterScreenOff = this.mExt.updateDozeAfterScreenOff(powerGroup, this.mDozeAfterScreenOff);
        powerGroup.mDisplayPowerRequest.inCall = this.mSmtEx.mInCall;
        if (this.mZswExt.useFakeSleepBrightness(groupId) == false) goto L20;
        screenBrightnessOverride2 = this.mZswExt.getFakeSleepBrightness();
    L20:
        boolean oldUseProximitySensor = shouldUseProximitySensorLocked();
        boolean oldUseProximitySensor2 = shouldBoostScreenBrightness();
        int r14 = this.mDozeScreenStateOverrideFromDreamManager;
        int r15 = this.mDozeScreenStateOverrideReasonFromDreamManager;
        float r16 = this.mDozeScreenBrightnessOverrideFromDreamManagerFloat;
        boolean oldUseProximitySensor3 = this.mUseNormalBrightnessForDoze;
        boolean oldUseProximitySensor4 = this.mDrawWakeLockOverrideFromSidekick;
        if (this.mBatterySaverSupported == false) goto L23;
        PowerSaveState r17 = this.mBatterySaverStateMachine.getBatterySaverPolicy().getBatterySaverPolicy(7);
    L24:
        boolean r18 = sQuiescent;
        boolean oldUseProximitySensor5 = this.mDozeAfterScreenOff;
        boolean r4 = this.mBootCompleted;
        boolean oldUseProximitySensor6 = this.mScreenBrightnessBoostInProgress;
        boolean oldUseProximitySensor7 = this.mRequestWaitForNegativeProximity;
        boolean oldUseProximitySensor8 = this.mBrightWhenDozingConfig;
        boolean ready = powerGroup.updateLocked(screenBrightnessOverride2, overrideTag, oldUseProximitySensor, oldUseProximitySensor2, r14, r15, r16, oldUseProximitySensor3, oldUseProximitySensor4, r17, r18, oldUseProximitySensor5, r4, oldUseProximitySensor6, oldUseProximitySensor7, oldUseProximitySensor8);
        int wakefulness = powerGroup.getWakefulnessLocked();
        boolean displayReadyStateChanged = powerGroup.setReadyLocked(ready);
        boolean poweringOn = powerGroup.isPoweringOnLocked();
        if (ready == false) goto L34;
        if (displayReadyStateChanged == false) goto L34;
        if (poweringOn == false) goto L34;
        if (wakefulness != 1) goto L34;
        powerGroup.setIsPoweringOnLocked(false);
        LatencyTracker.getInstance(this.mContext).onActionEnd(5);
        Trace.asyncTraceEnd(131072, TRACE_SCREEN_ON, groupId);
        int latencyMs = (int) (this.mClock.uptimeMillis() - powerGroup.getLastPowerOnTimeLocked());
        if (latencyMs < 200) goto L34;
        Slog.w(TAG, "Screen on took " + latencyMs + " ms");
    L34:
        this.mScreenBrightnessModeSettingChanged = false;
        idx = idx + 1;
        r5 = false;
        goto L12
    L23:
        r17 = new PowerSaveState.Builder().build();
        goto L24
    L16:
        overrideTag = null;
        screenBrightnessOverride2 = Float.NaN;
        goto L17
    L35:
        r13 = r5;
        r12 = true;
        this.mRequestWaitForNegativeProximity = r13;
        goto L38
    L7:
        if (areAllPowerGroupsReadyLocked() == false) goto L9;
        sQuiescent = false;
        goto L10
    L9:
        this.mDirty |= 4096;
        goto L10
    }

    private void updateScreenBrightnessBoostLocked(int dirty) {
        if ((dirty & 2048) != 0) goto L5;
        return;
    L5:
        if (this.mScreenBrightnessBoostInProgress == false) goto L15;
        long now = this.mClock.uptimeMillis();
        this.mHandler.removeMessages(3);
        if (this.mLastScreenBrightnessBoostTime <= this.mLastGlobalSleepTime) goto L12;
        long boostTimeout = this.mLastScreenBrightnessBoostTime + 5000;
        if (boostTimeout <= now) goto L12;
        Message msg = this.mHandler.obtainMessage(3);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageAtTime(msg, boostTimeout);
        return;
    L12:
        this.mScreenBrightnessBoostInProgress = false;
        userActivityNoUpdateLocked(now, 0, 0, 1000);
        return;
    }

    private boolean shouldBoostScreenBrightness() {
        return this.mScreenBrightnessBoostInProgress;
    }

    protected static boolean isValidBrightness(float value) {
        if (value >= 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (value > 1.0f) goto L7;
        return true;
    }

    int getDreamsBatteryLevelDrain() {
        return this.mDreamsBatteryLevelDrain;
    }

    private boolean shouldUseProximitySensorLocked() {
        if ((this.mPowerGroups.get(0).getWakeLockSummaryLocked() & 16) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void notifyScreenTimeoutPolicyChangesLocked() {
        if (this.mFeatureFlags.isScreenTimeoutPolicyListenerApiEnabled() == true) goto L5;
        return;
    L5:
        int idx = 0;
    L7:
        if (idx >= this.mPowerGroups.size()) goto L10;
        int powerGroupId = this.mPowerGroups.keyAt(idx);
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);
        int screenTimeoutPolicy = powerGroup.getScreenTimeoutPolicy();
        this.mNotifier.notifyScreenTimeoutPolicyChanges(powerGroupId, screenTimeoutPolicy);
        idx = idx + 1;
        goto L7
    }

    private void updateSuspendBlockerLocked() {
        if ((this.mWakeLockSummary & 1) == 0) goto L5;
        boolean needWakeLockSuspendBlocker = true;
    L6:
        boolean needDisplaySuspendBlocker = needSuspendBlockerLocked();
        boolean autoSuspend = !needDisplaySuspendBlocker;
        boolean interactive = false;
        int idx = 0;
    L8:
        if (idx >= this.mPowerGroups.size()) goto L11;
        if (interactive == true) goto L11;
        interactive = this.mPowerGroups.valueAt(idx).isBrightOrDimLocked();
        idx = idx + 1;
    L11:
        if (autoSuspend == true) goto L16;
        if (this.mDecoupleHalAutoSuspendModeFromDisplayConfig == false) goto L16;
        setHalAutoSuspendModeLocked(false);
    L16:
        if (this.mBootCompleted == false) goto L18;
    L20:
        if (needWakeLockSuspendBlocker == false) goto L25;
        if (this.mHoldingWakeLockSuspendBlocker == true) goto L25;
        this.mWakeLockSuspendBlocker.acquire();
        this.mHoldingWakeLockSuspendBlocker = true;
    L25:
        if (needDisplaySuspendBlocker == false) goto L30;
        if (this.mHoldingDisplaySuspendBlocker == true) goto L30;
        this.mDisplaySuspendBlocker.acquire(HOLDING_DISPLAY_SUSPEND_BLOCKER);
        this.mHoldingDisplaySuspendBlocker = true;
    L30:
        if (this.mDecoupleHalInteractiveModeFromDisplayConfig == false) goto L36;
        if (interactive == false) goto L33;
    L34:
        setHalInteractiveModeLocked(interactive);
        goto L36
    L33:
        if (areAllPowerGroupsReadyLocked() == true) goto L34;
    L36:
        if (this.mBootCompleted == true) goto L38;
    L40:
        if (needWakeLockSuspendBlocker == false) goto L42;
    L44:
        if (needDisplaySuspendBlocker == false) goto L46;
    L48:
        if (autoSuspend == true) goto L50;
        return;
    L50:
        if (this.mDecoupleHalAutoSuspendModeFromDisplayConfig == false) goto L56;
        setHalAutoSuspendModeLocked(true);
        return;
    L56:
        return;
    L46:
        if (this.mHoldingDisplaySuspendBlocker == false) goto L48;
        this.mDisplaySuspendBlocker.release(HOLDING_DISPLAY_SUSPEND_BLOCKER);
        this.mHoldingDisplaySuspendBlocker = false;
        goto L48
    L42:
        if (this.mHoldingWakeLockSuspendBlocker == false) goto L44;
        this.mWakeLockSuspendBlocker.release();
        this.mHoldingWakeLockSuspendBlocker = false;
        goto L44
    L38:
        if (this.mHoldingBootingSuspendBlocker == false) goto L40;
        this.mBootingSuspendBlocker.release();
        this.mHoldingBootingSuspendBlocker = false;
        goto L40
    L18:
        if (this.mHoldingBootingSuspendBlocker == true) goto L20;
        this.mBootingSuspendBlocker.acquire();
        this.mHoldingBootingSuspendBlocker = true;
        goto L20
    L5:
        needWakeLockSuspendBlocker = false;
        goto L6
    }

    private boolean needSuspendBlockerLocked() {
        if (areAllPowerGroupsReadyLocked() == true) goto L6;
        return true;
    L6:
        if (this.mScreenBrightnessBoostInProgress == false) goto L9;
        return true;
    L9:
        if (getGlobalWakefulnessLocked() == 3) goto L11;
    L13:
        int idx = 0;
    L15:
        if (idx >= this.mPowerGroups.size()) goto L20;
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);
        if (powerGroup.needSuspendBlockerLocked(this.mProximityPositive, this.mSuspendWhenScreenOffDueToProximityConfig) == true) goto L18;
        idx = idx + 1;
        goto L15
    L18:
        return true;
    L20:
        return false;
    L11:
        if (this.mDozeStartInProgress == false) goto L13;
        return true;
    }

    private void setHalAutoSuspendModeLocked(boolean enable) {
        if (this.mUseAutoSuspend == true) goto L6;
        return;
    L6:
        if (enable == this.mHalAutoSuspendModeEnabled) goto L13;
        this.mHalAutoSuspendModeEnabled = enable;
        Trace.traceBegin(131072, "setHalAutoSuspend(" + enable + ")");
        this.mNativeWrapper.nativeSetAutoSuspend(enable);     // Catch: Throwable -> L10
        Trace.traceEnd(131072);
        return;
    L10:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    }

    private void setHalInteractiveModeLocked(boolean enable) {
        if (enable == this.mHalInteractiveModeEnabled) goto L10;
        this.mHalInteractiveModeEnabled = enable;
        Trace.traceBegin(131072, "setHalInteractive(" + enable + ")");
        this.mNativeWrapper.nativeSetPowerMode(7, enable);     // Catch: Throwable -> L7
        Trace.traceEnd(131072);
        return;
    L7:
        th = move-exception;
        Trace.traceEnd(131072);
        throw th;
    }

    boolean isGloballyInteractiveInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = PowerManagerInternal.isInteractive(getGlobalWakefulnessLocked());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isInteractiveInternal(int displayId, int uid) {
        if (this.mZswExt.isInFakeSleep() == false) goto L6;
        Slog.d(TAG, "ZTE_FAKE_SLEEP: isInteractiveInternal(): in fakesleep, return false");
        return false;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mSystemReady == true) goto L15;
        boolean r1 = isGloballyInteractiveInternal();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L15:
        DisplayInfo displayInfo = this.mDisplayManagerInternal.getDisplayInfo(displayId);     // Catch: Throwable -> L13
        if (displayInfo != null) goto L21;
        Slog.w(TAG, "Did not find DisplayInfo for displayId " + displayId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L21:
        if (displayInfo.hasAccess(uid) == false) goto L31;
        PowerGroup powerGroup = this.mPowerGroups.get(displayInfo.displayGroupId);     // Catch: Throwable -> L13
        if (powerGroup != null) goto L27;
        Slog.w(TAG, "Did not find PowerGroup for displayId " + displayId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L27:
        boolean r2 = PowerManagerInternal.isInteractive(powerGroup.getWakefulnessLocked());     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L31:
        throw new SecurityException("uid " + uid + " does not have access to display " + displayId);     // Catch: Throwable -> L13
    }

    private boolean setLowPowerModeInternal(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSmtEx.mFeaturePhoneModeEnabled == false) goto L12;
        Slog.d(TAG, "phone mode setLowPowerModeInternal " + enabled + " mIsPowered=" + this.mIsPowered);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L12:
        this.mBatterySaverStateMachine.setBatterySaverEnabledManually(enabled);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    }

    boolean isDeviceIdleModeInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDeviceIdleMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isLightDeviceIdleModeInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mLightDeviceIdleMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleBatteryStateChangedLocked() {
        this.mDirty |= 256;
        updatePowerStateLocked();
    }

    private void shutdownOrRebootInternal(final int haltMode, final boolean confirm, final String reason, boolean wait) {
        if ("userspace".equals(reason) == false) goto L10;
        if (PowerManager.isRebootingUserspaceSupportedImpl() == true) goto L10;
        throw new UnsupportedOperationException("Attempted userspace reboot on a device that doesn't support it");
    L10:
        if (this.mHandler == null) goto L14;
        if (this.mSystemReady == false) goto L14;
    L16:
        Runnable runnable = new AnonymousClass2(this, haltMode, confirm, reason);
        Message msg = Message.obtain(UiThread.getHandler(), runnable);
        msg.setAsynchronous(true);
        UiThread.getHandler().sendMessage(msg);
        if (wait == false) goto L26;
        monitor-enter(runnable);
    L29:
        runnable.wait();     // Catch: Throwable -> L21 InterruptedException -> L24
    L21:
        th = move-exception;
        throw th;
    L26:
        return;
    L14:
        if (PackageWatchdog.isRecoveryTriggeredReboot() == false) goto L28;
        lowLevelReboot(reason);
        goto L16
    L28:
        throw new IllegalStateException("Too early to call shutdown() or reboot()");
    }

    private void crashInternal(final String message) {
        final String r1 = "PowerManagerService.crash()";
        Thread t = new AnonymousClass3(this, r1, message);
        t.start();     // Catch: InterruptedException -> L5
        t.join();     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    void setStayOnSettingInternal(int val) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "stay_on_while_plugged_in", val);
    }

    void setMaximumScreenOffTimeoutFromDeviceAdminInternal(int userId, long timeMs) {
        if (userId >= 0) goto L5;
        Slog.wtf(TAG, "Attempt to set screen off timeout for invalid user: " + userId);
        return;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (userId != 0) goto L13;
        this.mMaximumScreenOffTimeoutFromDeviceAdmin = timeMs;     // Catch: Throwable -> L10
    L38:
    L30:
        this.mDirty |= 32;     // Catch: Throwable -> L24
        updatePowerStateLocked();     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L13:
        if (timeMs == Long.MAX_VALUE) goto L29;
        if (timeMs == 0) goto L29;
        ProfilePowerState profile = this.mProfilePowerState.get(userId);     // Catch: Throwable -> L26
        if (profile == null) goto L21;
        profile.mScreenOffTimeout = timeMs;     // Catch: Throwable -> L10
        goto L38
    L21:
        this.mProfilePowerState.put(userId, new ProfilePowerState(userId, timeMs, this.mClock.uptimeMillis()));     // Catch: Throwable -> L24
        this.mDirty |= 1;     // Catch: Throwable -> L24
    L26:
        th = th;
    L33:
        monitor-exit(r1);     // Catch: Throwable -> L24
        throw th;
    L29:
        this.mProfilePowerState.delete(userId);     // Catch: Throwable -> L24
    L24:
        th = th;
    L10:
        th = th;
        goto L33
    }

    boolean setDeviceIdleModeInternal(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.mDeviceIdleMode != enabled) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        this.mDeviceIdleMode = enabled;     // Catch: Throwable -> L8
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L8
        if (this.mDeviceIdleMode == false) goto L13;
    L14:
        r2 = true;
    L15:
        setPowerModeInternal(8, r2);     // Catch: Throwable -> L8
        SysOptBridge.getFactory().getPowerManager().updateDeviceIdleModeTimeLocked(enabled);     // Catch: Throwable -> L8
        if (enabled == false) goto L18;
        SysMonitorSvcBridge.getFactory().getMemoryStrategy().enterIdleStateInform(enabled);     // Catch: Throwable -> L8
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (enabled == false) goto L21;
        EventLogTags.writeDeviceIdleOnPhase("power");
    L22:
        return true;
    L21:
        EventLogTags.writeDeviceIdleOffPhase("power");
        goto L22
    L13:
        if (this.mLightDeviceIdleMode == false) goto L15;
    L8:
        th = move-exception;
        throw th;
    }

    boolean setLightDeviceIdleModeInternal(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.mLightDeviceIdleMode == enabled) goto L17;
        this.mLightDeviceIdleMode = enabled;     // Catch: Throwable -> L11
        boolean r1 = this.mDeviceIdleMode;     // Catch: Throwable -> L11
        if (this.mDeviceIdleMode == true) goto L13;
        if (this.mLightDeviceIdleMode == true) goto L13;
    L14:
        setPowerModeInternal(8, r2);     // Catch: Throwable -> L11
        SysOptBridge.getFactory().getPowerManager().updateLightDeviceIdleModeTimeLocked(enabled);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L13:
        r2 = true;
        goto L14
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    void setDeviceIdleWhitelistInternal(int[] appids) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDeviceIdleWhitelist = appids;     // Catch: Throwable -> L7
        if (doesIdleStateBlockWakeLocksLocked() == false) goto L9;
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setDeviceIdleTempWhitelistInternal(int[] appids) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDeviceIdleTempWhitelist = appids;     // Catch: Throwable -> L7
        if (doesIdleStateBlockWakeLocksLocked() == false) goto L9;
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setLowPowerStandbyAllowlistInternal(int[] uids) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLowPowerStandbyAllowlist = uids;     // Catch: Throwable -> L7
        if (this.mLowPowerStandbyActive == false) goto L9;
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setLowPowerStandbyActiveInternal(boolean active) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLowPowerStandbyActive == active) goto L9;
        this.mLowPowerStandbyActive = active;     // Catch: Throwable -> L7
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void startUidChangesInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidsChanging = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void finishUidChangesInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidsChanging = false;     // Catch: Throwable -> L8
        if (this.mUidsChanged == false) goto L10;
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L8
        this.mUidsChanged = false;     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    protected void handleUidStateChangeLocked() {
        if (this.mUidsChanging == false) goto L5;
        this.mUidsChanged = true;
        return;
    L5:
        updateWakeLockDisabledStatesLocked();
    }

    void updateUidProcStateInternal(int uid, int procState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UidState state = this.mUidState.get(uid);     // Catch: Throwable -> L7
        if (state != null) goto L9;
        state = new UidState(uid);     // Catch: Throwable -> L7
        this.mUidState.put(uid, state);     // Catch: Throwable -> L7
    L9:
        boolean r3 = false;
        if (state.mProcState > 11) goto L12;
        boolean oldShouldAllow = true;
    L13:
        state.mProcState = procState;     // Catch: Throwable -> L7
        if (state.mNumWakeLocks > 0) goto L16;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L16:
        if (doesIdleStateBlockWakeLocksLocked() == true) goto L26;
        if (this.mLowPowerStandbyActive == true) goto L26;
        if (state.mActive == true) goto L27;
        if (procState > 11) goto L24;
        r3 = true;
    L24:
        if (oldShouldAllow == r3) goto L27;
        handleUidStateChangeLocked();     // Catch: Throwable -> L7
    L26:
        handleUidStateChangeLocked();     // Catch: Throwable -> L7
        goto L27
    L12:
        oldShouldAllow = false;
    L7:
        th = move-exception;
        throw th;
    }

    void uidGoneInternal(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = this.mUidState.indexOfKey(uid);     // Catch: Throwable -> L11
        if (index < 0) goto L16;
        UidState state = this.mUidState.valueAt(index);     // Catch: Throwable -> L11
        state.mProcState = 20;     // Catch: Throwable -> L11
        state.mActive = false;     // Catch: Throwable -> L11
        this.mUidState.removeAt(index);     // Catch: Throwable -> L11
        if (doesIdleStateBlockWakeLocksLocked() == true) goto L14;
        if (this.mLowPowerStandbyActive == false) goto L16;
    L14:
        if (state.mNumWakeLocks <= 0) goto L16;
        handleUidStateChangeLocked();     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void uidActiveInternal(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UidState state = this.mUidState.get(uid);     // Catch: Throwable -> L7
        if (state != null) goto L9;
        state = new UidState(uid);     // Catch: Throwable -> L7
        state.mProcState = 19;     // Catch: Throwable -> L7
        this.mUidState.put(uid, state);     // Catch: Throwable -> L7
    L9:
        state.mActive = true;     // Catch: Throwable -> L7
        if (state.mNumWakeLocks <= 0) goto L12;
        handleUidStateChangeLocked();     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void uidIdleInternal(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UidState state = this.mUidState.get(uid);     // Catch: Throwable -> L9
        if (state == null) goto L11;
        state.mActive = false;     // Catch: Throwable -> L9
        if (state.mNumWakeLocks <= 0) goto L11;
        handleUidStateChangeLocked();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean doesIdleStateBlockWakeLocksLocked() {
        if (this.mDeviceIdleMode == true) goto L5;
        boolean r0 = this.mLightDeviceIdleMode;
        return false;
    L5:
        return true;
    }

    private void updateWakeLockDisabledStatesLocked() {
        boolean changed = false;
        int numWakeLocks = this.mWakeLocks.size();
        int i = 0;
    L4:
        if (i >= numWakeLocks) goto L17;
        WakeLock wakeLock = this.mWakeLocks.get(i);
        if ((wakeLock.mFlags & 65535) == 1) goto L10;
        if (isScreenLock(wakeLock) == true) goto L10;
    L15:
        i = i + 1;
    L10:
        if (setWakeLockDisabledStateLocked(wakeLock) == false) goto L15;
        changed = true;
        if (wakeLock.mDisabled == false) goto L14;
        notifyWakeLockReleasedLocked(wakeLock);
        goto L15
    L14:
        notifyWakeLockAcquiredLocked(wakeLock);
        goto L15
    L17:
        if (changed == false) goto L25;
        this.mDirty |= 1;
        updatePowerStateLocked();
        return;
    }

    protected boolean setWakeLockDisabledStateLocked(WakeLock wakeLock) {
        boolean r1 = false;
        if ((wakeLock.mFlags & 65535) != 1) goto L43;
        boolean disabled = false;
        int appid = UserHandle.getAppId(wakeLock.mOwnerUid);
        if (appid < 10000) goto L41;
        if (this.mConstants.NO_CACHED_WAKE_LOCKS == false) goto L19;
        if (this.mForceSuspendActive == false) goto L11;
    L16:
        r1 = true;
    L17:
        disabled = r1;
        goto L19
    L11:
        if (wakeLock.mUidState.mActive == true) goto L17;
        if (wakeLock.mUidState.mProcState == 20) goto L17;
        if (wakeLock.mUidState.mProcState <= 11) goto L17;
    L19:
        if (doesIdleStateBlockWakeLocksLocked() == false) goto L29;
        UidState state = wakeLock.mUidState;
        if (Arrays.binarySearch(this.mDeviceIdleWhitelist, appid) >= 0) goto L29;
        if (Arrays.binarySearch(this.mDeviceIdleTempWhitelist, appid) >= 0) goto L29;
        if (state.mProcState == 20) goto L29;
        if (state.mProcState <= 5) goto L29;
        disabled = true;
    L29:
        if (disabled == true) goto L32;
        disabled = SysOptBridge.getFactory().getPowerManager().controlPartialWakeLock(wakeLock);
    L32:
        if (this.mLowPowerStandbyActive == false) goto L41;
        UidState state2 = wakeLock.mUidState;
        if (Arrays.binarySearch(this.mLowPowerStandbyAllowlist, wakeLock.mOwnerUid) >= 0) goto L41;
        if (state2.mProcState == 20) goto L41;
        if (state2.mProcState <= 3) goto L41;
        disabled = true;
    L41:
        return wakeLock.setDisabled(disabled);
    L43:
        if (this.mDisableScreenWakeLocksWhileCached == true) goto L45;
    L58:
        return false;
    L45:
        if (isScreenLock(wakeLock) == false) goto L58;
        boolean disabled2 = false;
        int appid2 = UserHandle.getAppId(wakeLock.mOwnerUid);
        UidState state3 = wakeLock.mUidState;
        if (this.mConstants.NO_CACHED_WAKE_LOCKS == false) goto L57;
        if (appid2 < 10000) goto L57;
        if (state3.mActive == true) goto L57;
        if (state3.mProcState == 20) goto L57;
        if (state3.mProcState < 12) goto L57;
        disabled2 = true;
    L57:
        return wakeLock.setDisabled(disabled2);
    }

    private boolean isMaximumScreenOffTimeoutFromDeviceAdminEnforcedLocked() {
        if (this.mMaximumScreenOffTimeoutFromDeviceAdmin >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mMaximumScreenOffTimeoutFromDeviceAdmin >= Long.MAX_VALUE) goto L7;
        return true;
    }

    private void setAttentionLightInternal(boolean on, int color) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSystemReady == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        LogicalLight light = this.mAttentionLight;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (light != null) goto L14;
        return;
    L14:
        if (on == false) goto L16;
        int r2 = 3;
    L17:
        light.setFlashing(color, 2, r2, 0);
        return;
    L16:
        r2 = 0;
        goto L17
    }

    private void setDozeAfterScreenOffInternal(boolean on) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDozeAfterScreenOff = on;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void boostScreenBrightnessInternal(long eventTime, int uid) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L16:
        th = move-exception;
        Throwable r10 = th;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw r10;
    L18:
        th = move-exception;
        r10 = th;
        goto L23
    L5:
        if (this.mSystemReady == false) goto L21;
        if (getGlobalWakefulnessLocked() == 0) goto L21;
        if (eventTime < this.mLastScreenBrightnessBoostTime) goto L21;
        Slog.i(TAG, "Brightness boost activated (uid " + uid + ")...");     // Catch: Throwable -> L18
        this.mLastScreenBrightnessBoostTime = eventTime;     // Catch: Throwable -> L18
        this.mScreenBrightnessBoostInProgress = true;     // Catch: Throwable -> L18
        this.mDirty = this.mDirty | 2048;     // Catch: Throwable -> L18
        userActivityNoUpdateLocked(this.mPowerGroups.get(0), eventTime, 0, 0, uid);     // Catch: Throwable -> L16
        updatePowerStateLocked();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L16
    }

    private boolean isScreenBrightnessBoostedInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mScreenBrightnessBoostInProgress;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleScreenBrightnessBoostTimeout() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDirty |= 2048;     // Catch: Throwable -> L7
        updatePowerStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setUserInactiveOverrideFromWindowManagerInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserInactiveOverrideFromWindowManager = true;     // Catch: Throwable -> L8
        this.mDirty |= 4;     // Catch: Throwable -> L8
        updatePowerStateLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void setDevicePosturedInternal(boolean isPostured) {
    }

    private void setUserActivityTimeoutOverrideFromWindowManagerInternal(long timeoutMillis) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserActivityTimeoutOverrideFromWindowManager == timeoutMillis) goto L9;
        Slog.d(TAG, "userActivitytimeoutMillis=" + this.mUserActivityTimeoutOverrideFromWindowManager + "->" + timeoutMillis);     // Catch: Throwable -> L7
        this.mUserActivityTimeoutOverrideFromWindowManager = timeoutMillis;     // Catch: Throwable -> L7
        EventLogTags.writeUserActivityTimeoutOverride(timeoutMillis);     // Catch: Throwable -> L7
        this.mDirty = this.mDirty | 32;     // Catch: Throwable -> L7
        updatePowerStateLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void setDozeOverrideFromDreamManagerInternal(int screenState, int reason, float screenBrightnessFloat, int screenBrightnessInt, boolean useNormalBrightnessForDoze) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L25:
        th = th;
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L25
        throw th;
    L27:
        th = th;
        goto L29
    L5:
        if (this.mDozeScreenStateOverrideFromDreamManager == screenState) goto L33;
    L16:
        this.mDozeScreenStateOverrideFromDreamManager = screenState;     // Catch: Throwable -> L27
        this.mDozeScreenStateOverrideReasonFromDreamManager = reason;     // Catch: Throwable -> L27
        this.mDozeScreenBrightnessOverrideFromDreamManager = screenBrightnessInt;     // Catch: Throwable -> L27
        if (BrightnessUtils.isValidBrightnessValue(screenBrightnessFloat) == false) goto L19;
        float r0 = screenBrightnessFloat;
    L20:
        this.mDozeScreenBrightnessOverrideFromDreamManagerFloat = r0;     // Catch: Throwable -> L27
        this.mUseNormalBrightnessForDoze = useNormalBrightnessForDoze;     // Catch: Throwable -> L27
        this.mDozeScreenBrightnessOverrideFromDreamManagerFloat = this.mExt.setDozeOverrideFromDreamManagerInternal(screenState, reason, screenBrightnessFloat, screenBrightnessInt, useNormalBrightnessForDoze, this.mDozeScreenBrightnessOverrideFromDreamManagerFloat);     // Catch: Throwable -> L25
        this.mDirty |= 32;     // Catch: Throwable -> L25
        updatePowerStateLocked();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L25
        return;
    L19:
        r0 = BrightnessSynchronizer.brightnessIntToFloat(screenBrightnessInt);     // Catch: Throwable -> L27
        goto L20
    L33:
    L14:
        th = th;
        goto L29
    L7:
        if (this.mDozeScreenBrightnessOverrideFromDreamManager != screenBrightnessInt) goto L16;
        if (BrightnessSynchronizer.floatEquals(this.mDozeScreenBrightnessOverrideFromDreamManagerFloat, screenBrightnessFloat) == false) goto L16;
        if (this.mUseNormalBrightnessForDoze == useNormalBrightnessForDoze) goto L23;
        goto L16
    }

    private void setDrawWakeLockOverrideFromSidekickInternal(boolean keepState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDrawWakeLockOverrideFromSidekick == keepState) goto L9;
        this.mDrawWakeLockOverrideFromSidekick = keepState;     // Catch: Throwable -> L7
        this.mDirty |= 32;     // Catch: Throwable -> L7
        updatePowerStateLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void setPowerBoostInternal(int boost, int durationMs) {
        this.mNativeWrapper.nativeSetPowerBoost(boost, durationMs);
    }

    protected boolean setPowerModeInternal(int mode, boolean enabled) {
        if (mode != 5) goto L12;
        if (enabled == false) goto L12;
        if (this.mBatterySaverStateMachine == null) goto L12;
        if (this.mBatterySaverStateMachine.getBatterySaverController().isLaunchBoostDisabled() == false) goto L12;
        return false;
    L12:
        return this.mNativeWrapper.nativeSetPowerMode(mode, enabled);
    }

    boolean wasDeviceIdleForInternal(long ms) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if ((this.mPowerGroups.get(0).getLastUserActivityTimeLocked() + ms) >= this.mClock.uptimeMillis()) goto L7;
        r2 = true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    void onUserActivity() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPowerGroups.get(0).setLastUserActivityTimeLocked(this.mClock.uptimeMillis(), 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean forceSuspendInternal(int uid) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mForceSuspendActive = true;     // Catch: Throwable -> L13
        int idx = 0;
    L7:
        if (idx >= this.mPowerGroups.size()) goto L15;
        PowerManagerService r4 = this;
        int uid2 = uid;
        r4.sleepPowerGroupLocked(this.mPowerGroups.valueAt(idx), this.mClock.uptimeMillis(), 8, uid2);     // Catch: Throwable -> L11
        idx = idx + 1;     // Catch: Throwable -> L11
        uid = uid2;
    L11:
        th = move-exception;
        Throwable r11 = th;
    L24:
        r4.mForceSuspendActive = false;     // Catch: Throwable -> L22
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L22
        throw r11;     // Catch: Throwable -> L22
    L15:
        r4 = this;
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L11
        Slog.i(TAG, "Force-Suspending (uid " + uid + ")...");     // Catch: Throwable -> L11
        boolean success = r4.mNativeWrapper.nativeForceSuspend();     // Catch: Throwable -> L11
        if (success == true) goto L19;
        Slog.i(TAG, "Force-Suspending failed in native.");     // Catch: Throwable -> L11
    L19:
        r4.mForceSuspendActive = false;     // Catch: Throwable -> L22
        updateWakeLockDisabledStatesLocked();     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return success;
    L22:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        r4 = this;
        r11 = th;
        goto L24
    }

    private void addPowerGroupsForNonDefaultDisplayGroupLocked() {
        IntArray displayGroupIds = this.mDisplayManagerInternal.getDisplayGroupIds();
        if (displayGroupIds != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= displayGroupIds.size()) goto L16;
        int displayGroupId = displayGroupIds.get(i);
        if (displayGroupId == 0) goto L15;
        if (this.mPowerGroups.contains(displayGroupId) == false) goto L14;
        Slog.e(TAG, "Tried to add already existing group:" + displayGroupId);
        goto L15
    L14:
        PowerGroup powerGroup = new PowerGroup(displayGroupId, this.mPowerGroupWakefulnessChangeListener, this.mNotifier, this.mDisplayManagerInternal, 1, false, false, this.mClock.uptimeMillis(), this.mFeatureFlags);
        this.mPowerGroups.append(displayGroupId, powerGroup);
    L15:
        i = i + 1;
        goto L7
    L16:
        int i2 = this.mDirty;
        this.mDirty = i2 | 65536;
    }

    public static void lowLevelShutdown(String reason) {
        Slog.d(TAG, "lowLevelShutdown reason=" + reason);
        if (reason != null) goto L5;
        reason = "";
    L5:
        SystemProperties.set("sys.powerctl", "shutdown," + reason);
    }

    public static void lowLevelReboot(String reason) {
        if (reason != null) goto L5;
        reason = "";
    L5:
        if (reason.equals("quiescent") == false) goto L8;
        sQuiescent = true;
        reason = "";
    L11:
        if (reason.equals("recovery") == false) goto L13;
    L14:
        reason = "recovery";
    L16:
        if (sQuiescent == true) goto L18;
    L21:
        Slog.d(TAG, "lowLevelReboot reason=" + reason);
        SystemProperties.set("sys.powerctl", "reboot," + reason);
        Thread.sleep(20000);     // Catch: InterruptedException -> L24
    L26:
        Slog.wtf(TAG, "Unexpected return from lowLevelReboot!");
        return;
    L25:
        Thread.currentThread().interrupt();
        goto L26
    L18:
        if ("".equals(reason) == true) goto L20;
        reason = reason + ",";
    L20:
        reason = reason + "quiescent";
        goto L21
    L13:
        if (reason.equals("recovery-update") == false) goto L16;
    L8:
        if (reason.endsWith(",quiescent") == false) goto L11;
        sQuiescent = true;
        reason = reason.substring(0, (reason.length() - "quiescent".length()) - 1);
        goto L11
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @NeverCompile
    private void dumpInternal(PrintWriter pw) {
        pw.println("POWER MANAGER (dumpsys power)\n");
        Object r3 = this.mLock;
        monitor-enter(r3);
        pw.println("Power Manager State:");     // Catch: Throwable -> L11
        this.mConstants.dump(pw);     // Catch: Throwable -> L11
        pw.println("  mDirty=0x" + Integer.toHexString(this.mDirty));     // Catch: Throwable -> L11
        pw.println("  mWakefulness=" + PowerManagerInternal.wakefulnessToString(getGlobalWakefulnessLocked()));     // Catch: Throwable -> L11
        pw.println("  mWakefulnessChanging=" + this.mWakefulnessChanging);     // Catch: Throwable -> L11
        pw.println("  mIsPowered=" + this.mIsPowered);     // Catch: Throwable -> L11
        pw.println("  mPlugType=" + this.mPlugType);     // Catch: Throwable -> L11
        pw.println("  mBatteryLevel=" + this.mBatteryLevel);     // Catch: Throwable -> L11
        pw.println("  mDreamsBatteryLevelDrain=" + this.mDreamsBatteryLevelDrain);     // Catch: Throwable -> L11
        pw.println("  mDockState=" + this.mDockState);     // Catch: Throwable -> L11
        pw.println("  mStayOn=" + this.mStayOn);     // Catch: Throwable -> L11
        pw.println("  mProximityPositive=" + this.mProximityPositive);     // Catch: Throwable -> L11
        pw.println("  mBootCompleted=" + this.mBootCompleted);     // Catch: Throwable -> L11
        pw.println("  mSystemReady=" + this.mSystemReady);     // Catch: Throwable -> L11
        Object r4 = this.mEnhancedDischargeTimeLock;     // Catch: Throwable -> L11
        monitor-enter(r4);     // Catch: Throwable -> L11
        pw.println("  mEnhancedDischargeTimeElapsed=" + this.mEnhancedDischargeTimeElapsed);     // Catch: Throwable -> L68
        pw.println("  mLastEnhancedDischargeTimeUpdatedElapsed=" + this.mLastEnhancedDischargeTimeUpdatedElapsed);     // Catch: Throwable -> L68
        pw.println("  mEnhancedDischargePredictionIsPersonalized=" + this.mEnhancedDischargePredictionIsPersonalized);     // Catch: Throwable -> L68
        monitor-exit(r4);     // Catch: Throwable -> L68
        pw.println("  mUseAutoSuspend=" + this.mUseAutoSuspend);     // Catch: Throwable -> L11
        pw.println("  mHalAutoSuspendModeEnabled=" + this.mHalAutoSuspendModeEnabled);     // Catch: Throwable -> L11
        pw.println("  mHalInteractiveModeEnabled=" + this.mHalInteractiveModeEnabled);     // Catch: Throwable -> L11
        pw.println("  mWakeLockSummary=0x" + Integer.toHexString(this.mWakeLockSummary));     // Catch: Throwable -> L11
        pw.print("  mNotifyLongScheduled=");     // Catch: Throwable -> L11
        if (this.mNotifyLongScheduled != 0) goto L13;
        pw.print("(none)");     // Catch: Throwable -> L11
    L14:
        pw.println();     // Catch: Throwable -> L11
        pw.print("  mNotifyLongDispatched=");     // Catch: Throwable -> L11
        if (this.mNotifyLongDispatched != 0) goto L17;
        pw.print("(none)");     // Catch: Throwable -> L11
    L18:
        pw.println();     // Catch: Throwable -> L11
        pw.print("  mNotifyLongNextCheck=");     // Catch: Throwable -> L11
        if (this.mNotifyLongNextCheck != 0) goto L21;
        pw.print("(none)");     // Catch: Throwable -> L11
    L22:
        pw.println();     // Catch: Throwable -> L11
        pw.println("  mRequestWaitForNegativeProximity=" + this.mRequestWaitForNegativeProximity);     // Catch: Throwable -> L11
        pw.println("  mInterceptedPowerKeyForProximity=" + this.mInterceptedPowerKeyForProximity);     // Catch: Throwable -> L11
        pw.println("  mSandmanScheduled=" + this.mSandmanScheduled);     // Catch: Throwable -> L11
        pw.println("  mBatteryLevelLow=" + this.mBatteryLevelLow);     // Catch: Throwable -> L11
        pw.println("  mLightDeviceIdleMode=" + this.mLightDeviceIdleMode);     // Catch: Throwable -> L11
        pw.println("  mDeviceIdleMode=" + this.mDeviceIdleMode);     // Catch: Throwable -> L11
        pw.println("  mDeviceIdleWhitelist=" + Arrays.toString(this.mDeviceIdleWhitelist));     // Catch: Throwable -> L11
        pw.println("  mDeviceIdleTempWhitelist=" + Arrays.toString(this.mDeviceIdleTempWhitelist));     // Catch: Throwable -> L11
        pw.println("  mLowPowerStandbyActive=" + this.mLowPowerStandbyActive);     // Catch: Throwable -> L11
        pw.println("  mLastWakeTime=" + TimeUtils.formatUptime(this.mLastGlobalWakeTime));     // Catch: Throwable -> L11
        pw.println("  mLastSleepTime=" + TimeUtils.formatUptime(this.mLastGlobalSleepTime));     // Catch: Throwable -> L11
        pw.println("  mLastSleepReason=" + PowerManager.sleepReasonToString(this.mLastGlobalSleepReason));     // Catch: Throwable -> L11
        pw.println("  mLastGlobalWakeTimeRealtime=" + TimeUtils.formatUptime(this.mLastGlobalWakeTimeRealtime));     // Catch: Throwable -> L11
        pw.println("  mLastGlobalSleepTimeRealtime=" + TimeUtils.formatUptime(this.mLastGlobalSleepTimeRealtime));     // Catch: Throwable -> L11
        pw.println("  mLastInteractivePowerHintTime=" + TimeUtils.formatUptime(this.mLastInteractivePowerHintTime));     // Catch: Throwable -> L11
        pw.println("  mLastScreenBrightnessBoostTime=" + TimeUtils.formatUptime(this.mLastScreenBrightnessBoostTime));     // Catch: Throwable -> L11
        pw.println("  mScreenBrightnessBoostInProgress=" + this.mScreenBrightnessBoostInProgress);     // Catch: Throwable -> L11
        pw.println("  mHoldingWakeLockSuspendBlocker=" + this.mHoldingWakeLockSuspendBlocker);     // Catch: Throwable -> L11
        pw.println("  mHoldingDisplaySuspendBlocker=" + this.mHoldingDisplaySuspendBlocker);     // Catch: Throwable -> L11
        pw.println("  mLastFlipTime=" + this.mLastFlipTime);     // Catch: Throwable -> L11
        pw.println("  mIsFaceDown=" + this.mIsFaceDown);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Settings and Configuration:");     // Catch: Throwable -> L11
        pw.println("  mDecoupleHalAutoSuspendModeFromDisplayConfig=" + this.mDecoupleHalAutoSuspendModeFromDisplayConfig);     // Catch: Throwable -> L11
        pw.println("  mDecoupleHalInteractiveModeFromDisplayConfig=" + this.mDecoupleHalInteractiveModeFromDisplayConfig);     // Catch: Throwable -> L11
        pw.println("  mWakeUpWhenPluggedOrUnpluggedConfig=" + this.mWakeUpWhenPluggedOrUnpluggedConfig);     // Catch: Throwable -> L11
        pw.println("  mWakeUpWhenPluggedOrUnpluggedInTheaterModeConfig=" + this.mWakeUpWhenPluggedOrUnpluggedInTheaterModeConfig);     // Catch: Throwable -> L11
        pw.println("  mTheaterModeEnabled=" + this.mTheaterModeEnabled);     // Catch: Throwable -> L11
        pw.println("  mAlwaysOnEnabled=" + this.mAlwaysOnEnabled);     // Catch: Throwable -> L11
        pw.println("  mKeepDreamingWhenUnplugging=" + this.mKeepDreamingWhenUnplugging);     // Catch: Throwable -> L11
        pw.println("  mSuspendWhenScreenOffDueToProximityConfig=" + this.mSuspendWhenScreenOffDueToProximityConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsSupportedConfig=" + this.mDreamsSupportedConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsEnabledByDefaultConfig=" + this.mDreamsEnabledByDefaultConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsActivatedOnSleepByDefaultConfig=" + this.mDreamsActivatedOnSleepByDefaultConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsActivatedOnDockByDefaultConfig=" + this.mDreamsActivatedOnDockByDefaultConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsActivatedWhilePosturedByDefaultConfig=" + this.mDreamsActivatedWhilePosturedByDefaultConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsEnabledOnBatteryConfig=" + this.mDreamsEnabledOnBatteryConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsBatteryLevelMinimumWhenPoweredConfig=" + this.mDreamsBatteryLevelMinimumWhenPoweredConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsBatteryLevelMinimumWhenNotPoweredConfig=" + this.mDreamsBatteryLevelMinimumWhenNotPoweredConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsBatteryLevelDrainCutoffConfig=" + this.mDreamsBatteryLevelDrainCutoffConfig);     // Catch: Throwable -> L11
        pw.println("  mDreamsEnabledSetting=" + this.mDreamsEnabledSetting);     // Catch: Throwable -> L11
        pw.println("  mDreamsActivateOnSleepSetting=" + this.mDreamsActivateOnSleepSetting);     // Catch: Throwable -> L11
        pw.println("  mDreamsActivateOnDockSetting=" + this.mDreamsActivateOnDockSetting);     // Catch: Throwable -> L11
        pw.println("  mDreamsActivateWhilePosturedSetting=" + this.mDreamsActivateWhilePosturedSetting);     // Catch: Throwable -> L11
        pw.println("  mDozeAfterScreenOff=" + this.mDozeAfterScreenOff);     // Catch: Throwable -> L11
        pw.println("  mBrightWhenDozingConfig=" + this.mBrightWhenDozingConfig);     // Catch: Throwable -> L11
        pw.println("  mMinimumScreenOffTimeoutConfig=" + this.mMinimumScreenOffTimeoutConfig);     // Catch: Throwable -> L11
        pw.println("  mMaximumScreenDimDurationConfig=" + this.mMaximumScreenDimDurationConfig);     // Catch: Throwable -> L11
        pw.println("  mMaximumScreenDimRatioConfig=" + this.mMaximumScreenDimRatioConfig);     // Catch: Throwable -> L11
        pw.println("  mAttentiveTimeoutConfig=" + this.mAttentiveTimeoutConfig);     // Catch: Throwable -> L11
        pw.println("  mAttentiveTimeoutSetting=" + this.mAttentiveTimeoutSetting);     // Catch: Throwable -> L11
        pw.println("  mAttentiveWarningDurationConfig=" + this.mAttentiveWarningDurationConfig);     // Catch: Throwable -> L11
        pw.println("  mScreenOffTimeoutSetting=" + this.mScreenOffTimeoutSetting);     // Catch: Throwable -> L11
        pw.println("  mSleepTimeoutSetting=" + this.mSleepTimeoutSetting);     // Catch: Throwable -> L11
        pw.println("  mMaximumScreenOffTimeoutFromDeviceAdmin=" + this.mMaximumScreenOffTimeoutFromDeviceAdmin + " (enforced=" + isMaximumScreenOffTimeoutFromDeviceAdminEnforcedLocked() + ")");     // Catch: Throwable -> L11
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L11
        r0.append("  mStayOnWhilePluggedInSetting=");     // Catch: Throwable -> L11
        r0.append(this.mStayOnWhilePluggedInSetting);     // Catch: Throwable -> L11
        pw.println(r0.toString());     // Catch: Throwable -> L11
        pw.println("  mStayOnAlltimeSetting=" + this.mStayOnAlltimeSetting);     // Catch: Throwable -> L11
        pw.println("  mUserActivityTimeoutOverrideFromWindowManager=" + this.mUserActivityTimeoutOverrideFromWindowManager);     // Catch: Throwable -> L11
        pw.println("  mUserInactiveOverrideFromWindowManager=" + this.mUserInactiveOverrideFromWindowManager);     // Catch: Throwable -> L11
        pw.println("  mDozeScreenStateOverrideFromDreamManager=" + this.mDozeScreenStateOverrideFromDreamManager);     // Catch: Throwable -> L11
        pw.println("  mDrawWakeLockOverrideFromSidekick=" + this.mDrawWakeLockOverrideFromSidekick);     // Catch: Throwable -> L11
        pw.println("  mDozeScreenBrightnessOverrideFromDreamManager=" + this.mDozeScreenBrightnessOverrideFromDreamManager);     // Catch: Throwable -> L11
        pw.println("  mUseNormalBrightnessForDoze=" + this.mUseNormalBrightnessForDoze);     // Catch: Throwable -> L11
        pw.println("  mScreenBrightnessMinimum=" + this.mScreenBrightnessMinimum);     // Catch: Throwable -> L11
        pw.println("  mScreenBrightnessMaximum=" + this.mScreenBrightnessMaximum);     // Catch: Throwable -> L11
        pw.println("  mScreenBrightnessDefault=" + this.mScreenBrightnessDefault);     // Catch: Throwable -> L11
        pw.println("  mDoubleTapWakeEnabled=" + this.mDoubleTapWakeEnabled);     // Catch: Throwable -> L11
        pw.println("  mForegroundProfile=" + this.mForegroundProfile);     // Catch: Throwable -> L11
        pw.println("  mUserId=" + this.mUserId);     // Catch: Throwable -> L11
        long attentiveTimeout = getAttentiveTimeoutLocked();     // Catch: Throwable -> L11
        long sleepTimeout = getSleepTimeoutLocked(attentiveTimeout);     // Catch: Throwable -> L11
        long screenOffTimeout = getScreenOffTimeoutLocked(sleepTimeout, attentiveTimeout);     // Catch: Throwable -> L11
        long screenDimDuration = getScreenDimDurationLocked(screenOffTimeout);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Attentive timeout: " + attentiveTimeout + " ms");     // Catch: Throwable -> L11
        pw.println("Sleep timeout: " + sleepTimeout + " ms");     // Catch: Throwable -> L11
        pw.println("Screen off timeout: " + screenOffTimeout + " ms");     // Catch: Throwable -> L11
        pw.println("Screen dim duration: " + screenDimDuration + " ms");     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.print("UID states (changing=");     // Catch: Throwable -> L11
        pw.print(this.mUidsChanging);     // Catch: Throwable -> L11
        pw.print(" changed=");     // Catch: Throwable -> L11
        pw.print(this.mUidsChanged);     // Catch: Throwable -> L11
        pw.println("):");     // Catch: Throwable -> L11
        int i = 0;
    L24:
        if (i >= this.mUidState.size()) goto L30;
        UidState state = this.mUidState.valueAt(i);     // Catch: Throwable -> L11
        pw.print("  UID ");     // Catch: Throwable -> L11
        UserHandle.formatUid(pw, this.mUidState.keyAt(i));     // Catch: Throwable -> L11
        pw.print(": ");     // Catch: Throwable -> L11
        if (state.mActive == false) goto L28;
        pw.print("  ACTIVE ");     // Catch: Throwable -> L11
    L29:
        pw.print(" count=");     // Catch: Throwable -> L11
        pw.print(state.mNumWakeLocks);     // Catch: Throwable -> L11
        pw.print(" state=");     // Catch: Throwable -> L11
        pw.println(state.mProcState);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L24
    L28:
        pw.print("INACTIVE ");     // Catch: Throwable -> L11
        goto L29
    L30:
        pw.println();     // Catch: Throwable -> L11
        pw.println("Looper state:");     // Catch: Throwable -> L11
        this.mHandler.getLooper().dump(new PrintWriterPrinter(pw), "  ");     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Wake Locks: size=" + this.mWakeLocks.size());     // Catch: Throwable -> L11
        Iterator<WakeLock> r1 = this.mWakeLocks.iterator();     // Catch: Throwable -> L11
    L32:
        if (r1.hasNext() == false) goto L34;
        WakeLock wl = r1.next();     // Catch: Throwable -> L11
        pw.println("  " + wl);     // Catch: Throwable -> L11
        goto L32
    L34:
        pw.println();     // Catch: Throwable -> L11
        pw.println("Suspend Blockers: size=" + this.mSuspendBlockers.size());     // Catch: Throwable -> L11
        Iterator<SuspendBlocker> r2 = this.mSuspendBlockers.iterator();     // Catch: Throwable -> L11
    L36:
        if (r2.hasNext() == false) goto L38;
        SuspendBlocker sb = r2.next();     // Catch: Throwable -> L11
        pw.println("  " + sb);     // Catch: Throwable -> L11
        goto L36
    L38:
        pw.println();     // Catch: Throwable -> L11
        pw.println("Display Power: " + this.mDisplayPowerCallbacks);     // Catch: Throwable -> L11
        if (this.mBatterySaverSupported == false) goto L41;
        this.mBatterySaverStateMachine.getBatterySaverPolicy().dump(pw);     // Catch: Throwable -> L11
        this.mBatterySaverStateMachine.dump(pw);     // Catch: Throwable -> L11
    L42:
        this.mAttentionDetector.dump(pw);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        int numProfiles = this.mProfilePowerState.size();     // Catch: Throwable -> L11
        pw.println("Profile power states: size=" + numProfiles);     // Catch: Throwable -> L11
        int i2 = 0;
    L43:
        if (i2 >= numProfiles) goto L45;
        ProfilePowerState profile = this.mProfilePowerState.valueAt(i2);     // Catch: Throwable -> L11
        pw.print("  mUserId=");     // Catch: Throwable -> L11
        pw.print(profile.mUserId);     // Catch: Throwable -> L11
        pw.print(" mScreenOffTimeout=");     // Catch: Throwable -> L11
        pw.print(profile.mScreenOffTimeout);     // Catch: Throwable -> L11
        pw.print(" mWakeLockSummary=");     // Catch: Throwable -> L11
        pw.print(profile.mWakeLockSummary);     // Catch: Throwable -> L11
        pw.print(" mLastUserActivityTime=");     // Catch: Throwable -> L11
        pw.print(profile.mLastUserActivityTime);     // Catch: Throwable -> L11
        pw.print(" mLockingNotified=");     // Catch: Throwable -> L11
        pw.println(profile.mLockingNotified);     // Catch: Throwable -> L11
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L43
    L45:
        pw.println("Display Group User Activity:");     // Catch: Throwable -> L11
        int idx = 0;
    L47:
        if (idx >= this.mPowerGroups.size()) goto L49;
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);     // Catch: Throwable -> L11
        pw.println("  displayGroupId=" + powerGroup.getGroupId());     // Catch: Throwable -> L11
        pw.println("  userActivitySummary=0x" + Integer.toHexString(powerGroup.getUserActivitySummaryLocked()));     // Catch: Throwable -> L11
        pw.println("  lastUserActivityTime=" + TimeUtils.formatUptime(powerGroup.getLastUserActivityTimeLocked()));     // Catch: Throwable -> L11
        pw.println("  lastUserActivityTimeNoChangeLights=" + TimeUtils.formatUptime(powerGroup.getLastUserActivityTimeNoChangeLightsLocked()));     // Catch: Throwable -> L11
        pw.println("  mWakeLockSummary=0x" + Integer.toHexString(powerGroup.getWakeLockSummaryLocked()));     // Catch: Throwable -> L11
        idx = idx + 1;     // Catch: Throwable -> L11
        goto L47
    L49:
        WirelessChargerDetector wcd = this.mWirelessChargerDetector;     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        if (wcd == null) goto L54;
        wcd.dump(pw);
    L54:
        if (this.mNotifier == null) goto L56;
        this.mNotifier.dump(pw);
    L56:
        this.mFaceDownDetector.dump(pw);
        this.mAmbientDisplaySuppressionController.dump(pw);
        this.mLowPowerStandbyController.dump(pw);
        Object r5 = this.mLock;
        monitor-enter(r5);
    L61:
        th = move-exception;
        throw th;
    L59:
        if (this.mScreenTimeoutOverridePolicy == null) goto L63;
        this.mScreenTimeoutOverridePolicy.dump(pw);     // Catch: Throwable -> L61
    L63:
        monitor-exit(r5);     // Catch: Throwable -> L61
        this.mFeatureFlags.dump(pw);
        return;
    L41:
        pw.println("Battery Saver: DISABLED");     // Catch: Throwable -> L11
        goto L42
    L21:
        TimeUtils.formatDuration(this.mNotifyLongNextCheck, this.mClock.uptimeMillis(), pw);     // Catch: Throwable -> L11
        goto L22
    L17:
        TimeUtils.formatDuration(this.mNotifyLongDispatched, this.mClock.uptimeMillis(), pw);     // Catch: Throwable -> L11
        goto L18
    L13:
        TimeUtils.formatDuration(this.mNotifyLongScheduled, this.mClock.uptimeMillis(), pw);     // Catch: Throwable -> L11
        goto L14
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void dumpProto(FileDescriptor fd) {
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mConstants.dumpProto(proto);     // Catch: Throwable -> L56
        proto.write(1120986464258L, this.mDirty);     // Catch: Throwable -> L56
        proto.write(1159641169923L, getGlobalWakefulnessLocked());     // Catch: Throwable -> L56
        proto.write(1133871366148L, this.mWakefulnessChanging);     // Catch: Throwable -> L56
        proto.write(1133871366149L, this.mIsPowered);     // Catch: Throwable -> L56
        proto.write(1159641169926L, this.mPlugType);     // Catch: Throwable -> L56
        proto.write(1120986464263L, this.mBatteryLevel);     // Catch: Throwable -> L56
        proto.write(1120986464313L, this.mDreamsBatteryLevelDrain);     // Catch: Throwable -> L56
        proto.write(1159641169929L, this.mDockState);     // Catch: Throwable -> L56
        proto.write(1133871366154L, this.mStayOn);     // Catch: Throwable -> L56
        proto.write(1133871366155L, this.mProximityPositive);     // Catch: Throwable -> L56
        proto.write(1133871366156L, this.mBootCompleted);     // Catch: Throwable -> L56
        proto.write(1133871366157L, this.mSystemReady);     // Catch: Throwable -> L56
        Object r13 = this.mEnhancedDischargeTimeLock;     // Catch: Throwable -> L56
        monitor-enter(r13);     // Catch: Throwable -> L56
        proto.write(1112396529716L, this.mEnhancedDischargeTimeElapsed);     // Catch: Throwable -> L101
        proto.write(1112396529717L, this.mLastEnhancedDischargeTimeUpdatedElapsed);     // Catch: Throwable -> L101
        proto.write(1133871366198L, this.mEnhancedDischargePredictionIsPersonalized);     // Catch: Throwable -> L101
        monitor-exit(r13);     // Catch: Throwable -> L101
        proto.write(1133871366158L, this.mHalAutoSuspendModeEnabled);     // Catch: Throwable -> L56
        proto.write(1133871366159L, this.mHalInteractiveModeEnabled);     // Catch: Throwable -> L56
        long activeWakeLocksToken = proto.start(1146756268048L);     // Catch: Throwable -> L56
        boolean r15 = true;
        if ((this.mWakeLockSummary & 1) == 0) goto L11;
        boolean r0 = true;
    L12:
        long r11 = 1133871366145L;
        proto.write(1133871366145L, r0);     // Catch: Throwable -> L56
        if ((this.mWakeLockSummary & 2) == 0) goto L15;
        boolean r1 = true;
    L16:
        proto.write(1133871366146L, r1);     // Catch: Throwable -> L56
        if ((this.mWakeLockSummary & 4) == 0) goto L19;
        boolean r2 = true;
    L20:
        proto.write(1133871366147L, r2);     // Catch: Throwable -> L56
        if ((this.mWakeLockSummary & 8) == 0) goto L23;
        boolean r3 = true;
    L24:
        proto.write(1133871366148L, r3);     // Catch: Throwable -> L56
        if ((this.mWakeLockSummary & 16) == 0) goto L27;
        boolean r5 = true;
    L28:
        proto.write(1133871366149L, r5);     // Catch: Throwable -> L56
        if ((this.mWakeLockSummary & 32) == 0) goto L31;
        boolean r6 = true;
    L32:
        proto.write(1133871366150L, r6);     // Catch: Throwable -> L56
        if ((this.mWakeLockSummary & 64) == 0) goto L35;
        boolean r7 = true;
    L36:
        proto.write(1133871366151L, r7);     // Catch: Throwable -> L56
        if ((this.mWakeLockSummary & 128) == 0) goto L39;
        boolean r8 = true;
    L40:
        proto.write(1133871366152L, r8);     // Catch: Throwable -> L56
        proto.end(activeWakeLocksToken);     // Catch: Throwable -> L56
        proto.write(1112396529681L, this.mNotifyLongScheduled);     // Catch: Throwable -> L56
        proto.write(1112396529682L, this.mNotifyLongDispatched);     // Catch: Throwable -> L56
        proto.write(1112396529683L, this.mNotifyLongNextCheck);     // Catch: Throwable -> L56
        int idx = 0;
    L42:
        if (idx >= this.mPowerGroups.size()) goto L58;
        PowerGroup powerGroup = this.mPowerGroups.valueAt(idx);     // Catch: Throwable -> L56
        long userActivityToken = proto.start(2246267895828L);     // Catch: Throwable -> L56
        proto.write(1120986464262L, powerGroup.getGroupId());     // Catch: Throwable -> L56
        long userActivitySummary = powerGroup.getUserActivitySummaryLocked();     // Catch: Throwable -> L56
        if ((userActivitySummary & 1) == 0) goto L46;
        boolean r10 = true;
    L47:
        proto.write(r11, r10);     // Catch: Throwable -> L56
        if ((userActivitySummary & 2) == 0) goto L50;
        boolean r12 = true;
    L51:
        proto.write(1133871366146L, r12);     // Catch: Throwable -> L56
        if ((4 & userActivitySummary) == 0) goto L54;
        boolean r14 = true;
    L55:
        proto.write(1133871366147L, r14);     // Catch: Throwable -> L56
        proto.write(1112396529668L, powerGroup.getLastUserActivityTimeLocked());     // Catch: Throwable -> L56
        proto.write(1112396529669L, powerGroup.getLastUserActivityTimeNoChangeLightsLocked());     // Catch: Throwable -> L56
        proto.end(userActivityToken);     // Catch: Throwable -> L56
        idx = idx + 1;     // Catch: Throwable -> L56
        r11 = 1133871366145L;
        goto L42
    L54:
        r14 = false;
        goto L55
    L50:
        r12 = false;
        goto L51
    L46:
        r10 = false;
        goto L47
    L58:
        proto.write(1133871366165L, this.mRequestWaitForNegativeProximity);     // Catch: Throwable -> L56
        proto.write(1133871366166L, this.mSandmanScheduled);     // Catch: Throwable -> L56
        proto.write(1133871366168L, this.mBatteryLevelLow);     // Catch: Throwable -> L56
        proto.write(1133871366169L, this.mLightDeviceIdleMode);     // Catch: Throwable -> L56
        proto.write(1133871366170L, this.mDeviceIdleMode);     // Catch: Throwable -> L56
        int[] r9 = this.mDeviceIdleWhitelist;     // Catch: Throwable -> L56
        int r16 = r9.length;     // Catch: Throwable -> L56
        int r17 = 0;
    L59:
        if (r17 >= r16) goto L61;
        int id = r9[r17];     // Catch: Throwable -> L56
        proto.write(2220498092059L, id);     // Catch: Throwable -> L56
        r17 = r17 + 1;     // Catch: Throwable -> L56
        goto L59
    L61:
        int[] r18 = this.mDeviceIdleTempWhitelist;     // Catch: Throwable -> L56
        int r19 = r18.length;     // Catch: Throwable -> L56
        int r20 = 0;
    L62:
        if (r20 >= r19) goto L64;
        int id2 = r18[r20];     // Catch: Throwable -> L56
        proto.write(2220498092060L, id2);     // Catch: Throwable -> L56
        r20 = r20 + 1;     // Catch: Throwable -> L56
        goto L62
    L64:
        proto.write(1133871366199L, this.mLowPowerStandbyActive);     // Catch: Throwable -> L56
        proto.write(1112396529693L, this.mLastGlobalWakeTime);     // Catch: Throwable -> L56
        proto.write(1112396529694L, this.mLastGlobalSleepTime);     // Catch: Throwable -> L56
        proto.write(1112396529697L, this.mLastInteractivePowerHintTime);     // Catch: Throwable -> L56
        proto.write(1112396529698L, this.mLastScreenBrightnessBoostTime);     // Catch: Throwable -> L56
        proto.write(1133871366179L, this.mScreenBrightnessBoostInProgress);     // Catch: Throwable -> L56
        proto.write(1133871366181L, this.mHoldingWakeLockSuspendBlocker);     // Catch: Throwable -> L56
        proto.write(1133871366182L, this.mHoldingDisplaySuspendBlocker);     // Catch: Throwable -> L56
        long settingsAndConfigurationToken = proto.start(1146756268071L);     // Catch: Throwable -> L56
        proto.write(1133871366145L, this.mDecoupleHalAutoSuspendModeFromDisplayConfig);     // Catch: Throwable -> L56
        proto.write(1133871366146L, this.mDecoupleHalInteractiveModeFromDisplayConfig);     // Catch: Throwable -> L56
        proto.write(1133871366147L, this.mWakeUpWhenPluggedOrUnpluggedConfig);     // Catch: Throwable -> L56
        proto.write(1133871366148L, this.mWakeUpWhenPluggedOrUnpluggedInTheaterModeConfig);     // Catch: Throwable -> L56
        proto.write(1133871366149L, this.mTheaterModeEnabled);     // Catch: Throwable -> L56
        proto.write(1133871366150L, this.mSuspendWhenScreenOffDueToProximityConfig);     // Catch: Throwable -> L56
        proto.write(1133871366151L, this.mDreamsSupportedConfig);     // Catch: Throwable -> L56
        proto.write(1133871366152L, this.mDreamsEnabledByDefaultConfig);     // Catch: Throwable -> L56
        proto.write(1133871366153L, this.mDreamsActivatedOnSleepByDefaultConfig);     // Catch: Throwable -> L56
        proto.write(1133871366154L, this.mDreamsActivatedOnDockByDefaultConfig);     // Catch: Throwable -> L56
        proto.write(1133871366155L, this.mDreamsEnabledOnBatteryConfig);     // Catch: Throwable -> L56
        proto.write(1172526071820L, this.mDreamsBatteryLevelMinimumWhenPoweredConfig);     // Catch: Throwable -> L56
        proto.write(1172526071821L, this.mDreamsBatteryLevelMinimumWhenNotPoweredConfig);     // Catch: Throwable -> L56
        proto.write(1172526071822L, this.mDreamsBatteryLevelDrainCutoffConfig);     // Catch: Throwable -> L56
        proto.write(1133871366159L, this.mDreamsEnabledSetting);     // Catch: Throwable -> L56
        proto.write(1133871366160L, this.mDreamsActivateOnSleepSetting);     // Catch: Throwable -> L56
        proto.write(1133871366161L, this.mDreamsActivateOnDockSetting);     // Catch: Throwable -> L56
        proto.write(1133871366162L, this.mDozeAfterScreenOff);     // Catch: Throwable -> L56
        proto.write(1120986464275L, this.mMinimumScreenOffTimeoutConfig);     // Catch: Throwable -> L56
        proto.write(1120986464276L, this.mMaximumScreenDimDurationConfig);     // Catch: Throwable -> L56
        proto.write(1108101562389L, this.mMaximumScreenDimRatioConfig);     // Catch: Throwable -> L56
        proto.write(1120986464278L, this.mScreenOffTimeoutSetting);     // Catch: Throwable -> L56
        proto.write(1172526071831L, this.mSleepTimeoutSetting);     // Catch: Throwable -> L56
        proto.write(1172526071845L, this.mAttentiveTimeoutSetting);     // Catch: Throwable -> L56
        proto.write(1172526071846L, this.mAttentiveTimeoutConfig);     // Catch: Throwable -> L56
        proto.write(1172526071847L, this.mAttentiveWarningDurationConfig);     // Catch: Throwable -> L56
        proto.write(1120986464280L, Math.min(this.mMaximumScreenOffTimeoutFromDeviceAdmin, 2147483647L));     // Catch: Throwable -> L56
        proto.write(1133871366169L, isMaximumScreenOffTimeoutFromDeviceAdminEnforcedLocked());     // Catch: Throwable -> L56
        long stayOnWhilePluggedInToken = proto.start(1146756268058L);     // Catch: Throwable -> L56
        if ((this.mStayOnWhilePluggedInSetting & 1) == 0) goto L67;
        boolean r21 = true;
    L68:
        proto.write(1133871366145L, r21);     // Catch: Throwable -> L56
        if ((this.mStayOnWhilePluggedInSetting & 2) == 0) goto L71;
        boolean r22 = true;
    L72:
        proto.write(1133871366146L, r22);     // Catch: Throwable -> L56
        if ((this.mStayOnWhilePluggedInSetting & 4) == 0) goto L75;
        boolean r23 = true;
    L76:
        proto.write(1133871366147L, r23);     // Catch: Throwable -> L56
        if ((this.mStayOnWhilePluggedInSetting & 8) != 0) goto L80;
        r15 = false;
    L80:
        proto.write(1133871366148L, r15);     // Catch: Throwable -> L56
        proto.end(stayOnWhilePluggedInToken);     // Catch: Throwable -> L56
        proto.write(1176821039133L, this.mUserActivityTimeoutOverrideFromWindowManager);     // Catch: Throwable -> L56
        proto.write(1133871366174L, this.mUserInactiveOverrideFromWindowManager);     // Catch: Throwable -> L56
        proto.write(1159641169951L, this.mDozeScreenStateOverrideFromDreamManager);     // Catch: Throwable -> L56
        proto.write(1133871366180L, this.mDrawWakeLockOverrideFromSidekick);     // Catch: Throwable -> L56
        proto.write(1108101562400L, this.mDozeScreenBrightnessOverrideFromDreamManager);     // Catch: Throwable -> L56
        long screenBrightnessSettingLimitsToken = proto.start(1146756268065L);     // Catch: Throwable -> L56
        proto.write(1108101562372L, this.mScreenBrightnessMinimum);     // Catch: Throwable -> L56
        proto.write(1108101562373L, this.mScreenBrightnessMaximum);     // Catch: Throwable -> L56
        proto.write(1108101562374L, this.mScreenBrightnessDefault);     // Catch: Throwable -> L56
        proto.end(screenBrightnessSettingLimitsToken);     // Catch: Throwable -> L56
        proto.write(1133871366178L, this.mDoubleTapWakeEnabled);     // Catch: Throwable -> L56
        proto.end(settingsAndConfigurationToken);     // Catch: Throwable -> L56
        long attentiveTimeout = getAttentiveTimeoutLocked();     // Catch: Throwable -> L56
        long sleepTimeout = getSleepTimeoutLocked(attentiveTimeout);     // Catch: Throwable -> L56
        long screenOffTimeout = getScreenOffTimeoutLocked(sleepTimeout, attentiveTimeout);     // Catch: Throwable -> L56
        long screenDimDuration = getScreenDimDurationLocked(screenOffTimeout);     // Catch: Throwable -> L56
        proto.write(1172526071859L, attentiveTimeout);     // Catch: Throwable -> L56
        proto.write(1172526071848L, sleepTimeout);     // Catch: Throwable -> L56
        proto.write(1120986464297L, screenOffTimeout);     // Catch: Throwable -> L56
        long screenDimDuration2 = screenDimDuration;
        proto.write(1120986464298L, screenDimDuration2);     // Catch: Throwable -> L56
        proto.write(1133871366187L, this.mUidsChanging);     // Catch: Throwable -> L56
        proto.write(1133871366188L, this.mUidsChanged);     // Catch: Throwable -> L56
        int i = 0;
    L82:
        if (i >= this.mUidState.size()) goto L85;
        UidState state = this.mUidState.valueAt(i);     // Catch: Throwable -> L56
        long screenDimDuration3 = screenDimDuration2;
        long uIDToken = proto.start(2246267895853L);     // Catch: Throwable -> L56
        int uid = this.mUidState.keyAt(i);     // Catch: Throwable -> L56
        proto.write(1120986464257L, uid);     // Catch: Throwable -> L56
        proto.write(1138166333442L, UserHandle.formatUid(uid));     // Catch: Throwable -> L56
        proto.write(1133871366147L, state.mActive);     // Catch: Throwable -> L56
        proto.write(1120986464260L, state.mNumWakeLocks);     // Catch: Throwable -> L56
        proto.write(1159641169925L, ActivityManager.processStateAmToProto(state.mProcState));     // Catch: Throwable -> L56
        proto.end(uIDToken);     // Catch: Throwable -> L56
        i = i + 1;     // Catch: Throwable -> L56
        screenDimDuration2 = screenDimDuration3;
        screenOffTimeout = screenOffTimeout;
        attentiveTimeout = attentiveTimeout;
        goto L82
    L85:
        if (this.mBatterySaverSupported == false) goto L87;
        this.mBatterySaverStateMachine.dumpProto(proto, 1146756268082L);     // Catch: Throwable -> L56
    L87:
        this.mHandler.getLooper().dumpDebug(proto, 1146756268078L);     // Catch: Throwable -> L56
        Iterator<WakeLock> r24 = this.mWakeLocks.iterator();     // Catch: Throwable -> L56
    L89:
        if (r24.hasNext() == false) goto L91;
        WakeLock wl = r24.next();     // Catch: Throwable -> L56
        wl.dumpDebug(proto, 2246267895855L);     // Catch: Throwable -> L56
        goto L89
    L91:
        Iterator<SuspendBlocker> r25 = this.mSuspendBlockers.iterator();     // Catch: Throwable -> L56
    L93:
        if (r25.hasNext() == false) goto L95;
        SuspendBlocker sb = r25.next();     // Catch: Throwable -> L56
        sb.dumpDebug(proto, 2246267895856L);     // Catch: Throwable -> L56
        goto L93
    L95:
        WirelessChargerDetector wcd = this.mWirelessChargerDetector;     // Catch: Throwable -> L56
        monitor-exit(r4);     // Catch: Throwable -> L56
        if (wcd == null) goto L99;
        wcd.dumpDebug(proto, 1146756268081L);
    L99:
        this.mLowPowerStandbyController.dumpProto(proto, 1146756268088L);
        proto.flush();
        return;
    L75:
        r23 = false;
        goto L76
    L71:
        r22 = false;
        goto L72
    L67:
        r21 = false;
        goto L68
    L39:
        r8 = false;
        goto L40
    L35:
        r7 = false;
        goto L36
    L31:
        r6 = false;
        goto L32
    L27:
        r5 = false;
        goto L28
    L23:
        r3 = false;
        goto L24
    L19:
        r2 = false;
        goto L20
    L15:
        r1 = false;
        goto L16
    L11:
        r0 = false;
        goto L12
    L101:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    }

    private void incrementBootCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int count = Settings.Global.getInt(getContext().getContentResolver(), "boot_count");     // Catch: Throwable -> L6 Settings.SettingNotFoundException -> L8
    L11:
        Settings.Global.putInt(getContext().getContentResolver(), "boot_count", count + 1);     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L9:
        count = 0;
        goto L11
    }

    private static WorkSource copyWorkSource(WorkSource workSource) {
        if (workSource != null) goto L6;
        return null;
    L6:
        return new WorkSource(workSource);
    }

    BinderService getBinderServiceInstance() {
        return this.mBinderService;
    }

    LocalService getLocalServiceInstance() {
        return this.mLocalService;
    }

    int getLastShutdownReasonInternal() {
        String line = this.mSystemProperties.get(SYSTEM_PROPERTY_REBOOT_REASON, null);
        switch(line.hashCode()) {
            case -2117951935: goto L21;
            case -1099647817: goto L18;
            case -934938715: goto L15;
            case -852189395: goto L12;
            case -169343402: goto L9;
            case 1218064802: goto L6;
            default: goto L23;
        };
    L23:
        byte r1 = -1;
    L24:
        switch(r1) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L26;
            default: goto L25;
        };
    L25:
        return 0;
    L26:
        return 6;
    L28:
        return 5;
    L29:
        return 4;
    L30:
        return 3;
    L31:
        return 2;
    L32:
        return 1;
    L6:
        if (line.equals(REASON_BATTERY_THERMAL_STATE) == false) goto L23;
        r1 = 5;
        goto L24
    L9:
        if (line.equals(REASON_SHUTDOWN) == false) goto L23;
        r1 = 0;
        goto L24
    L12:
        if (line.equals(REASON_USERREQUESTED) == false) goto L23;
        r1 = 2;
        goto L24
    L15:
        if (line.equals(REASON_REBOOT) == false) goto L23;
        r1 = 1;
        goto L24
    L18:
        if (line.equals(REASON_LOW_BATTERY) == false) goto L23;
        r1 = 4;
        goto L24
    L21:
        if (line.equals(REASON_THERMAL_SHUTDOWN) == false) goto L23;
        r1 = 3;
        goto L24
    }

    int getPowerGroupSize() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mPowerGroups.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private int getLastSleepReasonInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mLastGlobalSleepReason;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private PowerManager.WakeData getLastWakeupInternal() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        PowerManager.WakeData r2 = new PowerManager.WakeData(this.mLastGlobalWakeTime, this.mLastGlobalWakeReason, this.mLastGlobalWakeTimeRealtime - this.mLastGlobalSleepTimeRealtime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private PowerManager.SleepData getLastGoToSleepInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PowerManager.SleepData r1 = new PowerManager.SleepData(this.mLastGlobalSleepTime, this.mLastGlobalSleepReason);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean interceptPowerKeyDownInternal(KeyEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mProximityPositive == true) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L7:
        if (this.mInterceptedPowerKeyForProximity == true) goto L13;
        this.mDisplayManagerInternal.ignoreProximitySensorUntilChanged();     // Catch: Throwable -> L11
        this.mInterceptedPowerKeyForProximity = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    }

    private void goToSleepInternal(IntArray groupIds, long eventTime, int reason, int flags) {
        PowerManagerService r1 = this;
        long now = r1.mClock.uptimeMillis();
        if (eventTime > now) goto L54;
        r1.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        r1.mExt.goToSleepInternal(groupIds, eventTime, reason, flags);
        if ((flags & 1) == 0) goto L7;
        boolean r0 = true;
    L8:
        boolean isNoDoze = r0;
        int uid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        Object r12 = r1.mLock;     // Catch: Throwable -> L50
        monitor-enter(r12);     // Catch: Throwable -> L50
        int i = 0;
    L58:
        if (i >= groupIds.size()) goto L41;
        int groupId = groupIds.get(i);     // Catch: Throwable -> L24
        PowerGroup powerGroup = r1.mPowerGroups.get(groupId);     // Catch: Throwable -> L24
        if (powerGroup == null) goto L39;
        if ((flags & 2) != 0) goto L20;
    L30:
        if (isNoDoze == false) goto L34;
        r1.sleepPowerGroupLocked(powerGroup, eventTime, reason, uid);     // Catch: Throwable -> L24
    L62:
        i = i + 1;     // Catch: Throwable -> L36
        r1 = this;
    L36:
        th = th;
    L46:
        monitor-exit(r12);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L48
    L48:
        th = th;
    L52:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L34:
        dozePowerGroupLocked(powerGroup, eventTime, reason, uid);     // Catch: Throwable -> L36
        goto L62
    L20:
        if (r1.mFoldGracePeriodProvider.isEnabled() == false) goto L28;
        if (powerGroup.hasWakeLockKeepingScreenOnLocked() == true) goto L26;
        Slog.d(TAG, "Showing dismissible keyguard");     // Catch: Throwable -> L24
        r1.mNotifier.showDismissibleKeyguard();     // Catch: Throwable -> L24
        goto L62
    L26:
        Slog.i(TAG, "There is a screen wake lock present: sleep request will be ignored");     // Catch: Throwable -> L24
        goto L62
    L28:
        if (powerGroup.hasWakeLockKeepingScreenOnLocked() == false) goto L30;
    L39:
        throw new IllegalArgumentException("power group(" + groupId + ") doesn't exist");     // Catch: Throwable -> L36
    L24:
        th = th;
        goto L46
    L41:
        monitor-exit(r12);     // Catch: Throwable -> L36
        Binder.restoreCallingIdentity(ident);
        return;
    L44:
        th = th;
    L50:
        th = th;
        goto L52
    L7:
        r0 = false;
        goto L8
    L54:
        Slog.e(TAG, "Event time " + eventTime + " cannot be newer than " + now);
        throw new IllegalArgumentException("event time must not be in the future");
    }

    private void forceDisplaySleepInternal() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SystemProperties.getBoolean("config.enable_qti_suspend_manager", false) == true) goto L11;
        Slog.e(TAG, "forceDisplaySleep is not enabled!");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        this.mForceSuspendActive = true;     // Catch: Throwable -> L9
        goToSleepInternal(DEFAULT_DISPLAY_GROUP_IDS, this.mClock.uptimeMillis(), 8, 0);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    private void wakeupFromForceDisplaySleepInternal() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SystemProperties.getBoolean("config.enable_qti_suspend_manager", false) == true) goto L11;
        Slog.e(TAG, "wakeupFromForceDisplay is not enabled!");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        this.mForceSuspendActive = false;     // Catch: Throwable -> L9
        wakePowerGroupLocked(this.mPowerGroups.get(0), this.mClock.uptimeMillis(), 0, "wakeupFromForceDisplaySleepInternal", 1000, this.mContext.getOpPackageName(), 1000);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    static boolean isSameCallback(IWakeLockCallback callback1, IWakeLockCallback callback2) {
        if (callback1 != callback2) goto L5;
        return true;
    L5:
        if (callback1 == null) goto L10;
        if (callback2 != null) goto L8;
        return false;
    L8:
        if (callback1.asBinder() != callback2.asBinder()) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    private void releaseAllOverrideWakeLocks(int releaseReason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mWakeLocks.size();     // Catch: Throwable -> L9
        boolean change = false;
        int i = size - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        WakeLock wakeLock = this.mWakeLocks.get(i);     // Catch: Throwable -> L9
        if ((wakeLock.mFlags & 65535) != 256) goto L11;
        removeWakeLockNoUpdateLocked(wakeLock, i, releaseReason);     // Catch: Throwable -> L9
        change = true;
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        if (change == false) goto L15;
        updatePowerStateLocked();     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private int getDisplayGroupId(int displayId) {
        DisplayInfo displayInfo = this.mDisplayManagerInternal.getDisplayInfo(displayId);
        if (displayInfo != null) goto L7;
        return -1;
    L7:
        return displayInfo.displayGroupId;
    }

    public PowerManagerServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    private boolean isScreenLocked() {
        if (this.mBootCompleted == true) goto L6;
        return false;
    L6:
        KeyguardManager keyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public IExtPowerManagerService getExt() {
        return this.mExt;
    }
}

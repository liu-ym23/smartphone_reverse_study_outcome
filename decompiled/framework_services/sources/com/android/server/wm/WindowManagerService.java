package com.android.server.wm;

import android.R;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityMetricsData;
import android.app.ActivityThread;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.app.IApplicationThread;
import android.app.IAssistDataReceiver;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.TestUtilityService;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.hardware.configstore.V1_0.OptionalBool;
import android.hardware.configstore.V1_1.ISurfaceFlingerConfigs;
import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateManager;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.InputConstants;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.StabTrace;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.SystemService;
import android.os.Trace;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.provider.DeviceConfigInterface;
import android.provider.Settings;
import android.service.vr.IVrManager;
import android.service.vr.IVrStateCallbacks;
import android.sysprop.SurfaceFlingerProperties;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.IntArray;
import android.util.MergedConfiguration;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.proto.ProtoOutputStream;
import android.view.Choreographer;
import android.view.ContentRecordingSession;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.IAppTransitionAnimationSpecsFuture;
import android.view.ICrossWindowBlurEnabledListener;
import android.view.IDecorViewGestureListener;
import android.view.IDisplayChangeWindowController;
import android.view.IDisplayFoldListener;
import android.view.IDisplayWindowInsetsController;
import android.view.IDisplayWindowListener;
import android.view.IInputFilter;
import android.view.IObricWindowManager;
import android.view.IOnKeyguardExitResult;
import android.view.IPinnedTaskListener;
import android.view.IRotationWatcher;
import android.view.IScrollCaptureResponseListener;
import android.view.ISystemGestureExclusionListener;
import android.view.IWallpaperVisibilityListener;
import android.view.IWindow;
import android.view.IWindowId;
import android.view.IWindowManager;
import android.view.IWindowManagerExt;
import android.view.IWindowManagerSmtEx;
import android.view.IWindowSession;
import android.view.IWindowSessionCallback;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputWindowHandle;
import android.view.InsetsFrameProvider;
import android.view.InsetsSourceControl;
import android.view.InsetsState;
import android.view.KeyboardShortcutGroup;
import android.view.MagnificationSpec;
import android.view.RemoteAnimationAdapter;
import android.view.ScrollCaptureResponse;
import android.view.SurfaceControl;
import android.view.SurfaceControlViewHost;
import android.view.ViewDebug;
import android.view.WindowContentFrameStats;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import android.view.WindowManagerPolicyConstants;
import android.view.WindowRelayoutResult;
import android.view.displayhash.DisplayHash;
import android.view.displayhash.VerifiedDisplayHash;
import android.view.inputmethod.ImeTracker;
import android.widget.Toast;
import android.window.ActivityWindowInfo;
import android.window.AddToSurfaceSyncGroupResult;
import android.window.ClientWindowFrames;
import android.window.ConfigurationChangeSetting;
import android.window.DesktopModeFlags;
import android.window.IGlobalDragListener;
import android.window.IScreenRecordingCallback;
import android.window.ISurfaceSyncGroupCompletedListener;
import android.window.ITaskFpsCallback;
import android.window.ITrustedPresentationListener;
import android.window.InputTransferToken;
import android.window.ScreenCapture;
import android.window.SystemPerformanceHinter;
import android.window.TaskSnapshot;
import android.window.TrustedPresentationThresholds;
import android.window.WindowContainerToken;
import android.window.WindowContextInfo;
import android.window.WindowProviderService;
import com.android.internal.os.IResultReceiver;
import com.android.internal.os.TransferPipe;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.policy.IKeyguardLockedStateListener;
import com.android.internal.policy.IShortcutService;
import com.android.internal.policy.KeyInterceptionInfo;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FastPrintWriter;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.LatencyTracker;
import com.android.internal.util.ToBooleanFunction;
import com.android.server.AnimationThread;
import com.android.server.DisplayThread;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.LockGuard;
import com.android.server.SysOptBridge;
import com.android.server.UiThread;
import com.android.server.Watchdog;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.am.ProcessFreezerManager;
import com.android.server.am.ProcessList;
import com.android.server.input.InputManagerService;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.location.settings.SettingsStore$$ExternalSyntheticLambda0;
import com.android.server.pm.UserManagerInternal;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.power.ShutdownThread;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import com.android.server.utils.PriorityDump;
import com.android.server.voiceinteraction.DatabaseHelper;
import com.obric.utils.ObricImplFactory;
import dalvik.annotation.optimization.NeverCompile;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.Socket;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes3.dex */
public class WindowManagerService extends IWindowManager.Stub implements Watchdog.Monitor, WindowManagerPolicy.WindowManagerFuncs {
    private static final int ANIMATION_COMPLETED_TIMEOUT_MS = 5000;
    private static final int ANIMATION_DURATION_SCALE = 2;
    private static final int BOOT_ANIMATION_POLL_INTERVAL = 50;
    private static final String BOOT_ANIMATION_SERVICE = "bootanim";
    private static final String DENSITY_OVERRIDE = "ro.config.density_override";
    static final boolean ENABLE_FIXED_ROTATION_TRANSFORM = false;
    private static final int INPUT_DEVICES_READY_FOR_SAFE_MODE_DETECTION_TIMEOUT_MILLIS = 1000;
    static final int LAST_ANR_LIFETIME_DURATION_MSECS = 7200000;
    static final int LAYOUT_REPEAT_THRESHOLD = 4;
    static final int LOGTAG_INPUT_FOCUS = 62001;
    static final int MAX_ANIMATION_DURATION = 10000;
    static final int MY_PID = 0;
    static final int MY_UID = 0;
    private static final int POINTER_DOWN_OUTSIDE_FOCUS_TIMEOUT_MS = 50;
    private static final String PROPERTY_EMULATOR_CIRCULAR = "ro.boot.emulator.circular";
    private static final String SIZE_OVERRIDE = "ro.config.size_override";
    private static final int SYNC_INPUT_TRANSACTIONS_TIMEOUT_MS = 5000;
    private static final String SYSTEM_DEBUGGABLE = "ro.debuggable";
    private static final String SYSTEM_SECURE = "ro.secure";
    private static final String TAG = "WindowManager";
    private static final int TRACE_MAX_SECTION_NAME_LENGTH = 127;
    private static final int TRANSITION_ANIMATION_SCALE = 1;
    static final int UPDATE_FOCUS_NORMAL = 0;
    static final int UPDATE_FOCUS_PLACING_SURFACES = 2;
    static final int UPDATE_FOCUS_REMOVING_FOCUS = 4;
    static final int UPDATE_FOCUS_WILL_ASSIGN_LAYERS = 1;
    static final int UPDATE_FOCUS_WILL_PLACE_SURFACES = 3;
    private static final int WINDOW_ANIMATION_SCALE = 0;
    static final int WINDOW_FREEZE_TIMEOUT_DURATION = 2000;
    static WindowState mFocusingWindow;
    public static final boolean sEnableShellTransitions = false;
    static WindowManagerThreadPriorityBooster sThreadPriorityBooster;
    final AccessibilityController mAccessibilityController;
    final IActivityManager mActivityManager;
    final WindowManagerInternal.AppTransitionListener mActivityManagerAppTransitionNotifier;
    final boolean mAllowAnimationsInLowPowerMode;
    final boolean mAllowBootMessages;
    boolean mAllowTheaterModeWakeFromLayout;
    final ActivityManagerInternal mAmInternal;
    final Handler mAnimationHandler;
    final ArrayMap<AnimationAdapter, SurfaceAnimator> mAnimationTransferMap;
    private boolean mAnimationsDisabled;
    final WindowAnimator mAnimator;
    private float mAnimatorDurationScaleSetting;
    final AnrController mAnrController;
    final AppCompatConfiguration mAppCompatConfiguration;
    final AppOpsManager mAppOps;
    final boolean mAssistantOnTopOfDream;
    final ActivityTaskManagerService mAtmService;
    final BlurController mBlurController;
    boolean mBootAnimationStopped;
    long mBootWaitForWindowsStartTime;
    private final BroadcastReceiver mBroadcastReceiver;
    private final IntArray mCaptureBlockedToastShownUids;
    final int mConfigTypes;
    final WindowManagerConstants mConstants;
    final ContentRecordingController mContentRecordingController;
    final Context mContext;
    int mCurrentUserId;
    final int mDecorTypes;
    final ArrayList<WindowState> mDestroySurface;
    private DeviceStateCallback mDeviceStateCallback;
    private DeviceStateManager mDeviceStateManager;
    private volatile boolean mDisableSecureWindows;
    boolean mDisableTransitionAnimation;
    private boolean mDispatchedKeyguardLockedState;
    private final DisplayAreaPolicy.Provider mDisplayAreaPolicyProvider;
    IDisplayChangeWindowController mDisplayChangeController;
    private final IBinder.DeathRecipient mDisplayChangeControllerDeath;
    boolean mDisplayEnabled;
    private final DisplayHashController mDisplayHashController;
    volatile Map<Integer, Integer> mDisplayImePolicyCache;
    final DisplayManager mDisplayManager;
    final DisplayManagerInternal mDisplayManagerInternal;
    final DisplayWindowListenerController mDisplayNotificationController;
    boolean mDisplayReady;
    final DisplayWindowSettings mDisplayWindowSettings;
    final DisplayWindowSettingsProvider mDisplayWindowSettingsProvider;
    final DragDropController mDragDropController;
    final long mDrawLockTimeoutMillis;
    final EmbeddedWindowController mEmbeddedWindowController;
    EmulatorDisplayOverlay mEmulatorDisplayOverlay;
    private boolean mEventDispatchingEnabled;
    final WindowManagerFlags mFlags;
    boolean mFocusMayChange;
    private InputTarget mFocusedInputTarget;
    String mFocusingActivity;
    boolean mForceDesktopModeOnExternalDisplays;
    boolean mForceDisplayEnabled;
    final ArrayList<WindowState> mForceRemoves;
    final ArrayList<WindowState> mFrameChangingWindows;
    final WindowManagerGlobalLock mGlobalLock;
    final H mH;
    boolean mHardKeyboardAvailable;
    WindowManagerInternal.OnHardKeyboardStatusChangeListener mHardKeyboardStatusChangeListener;
    private boolean mHasHdrSupport;
    final boolean mHasPermanentDpad;
    private boolean mHasWideColorGamutSupport;
    private ArrayList<WindowState> mHidingNonSystemOverlayWindows;
    private final ArrayMap<Integer, Integer> mHidingNonSystemOverlayWindowsCountPerUid;
    final HighRefreshRateDenylist mHighRefreshRateDenylist;
    private IExtWindowManagerService mIExt;
    final InputManagerService mInputManager;
    final InputManagerCallback mInputManagerCallback;
    final HashMap<IBinder, WindowState> mInputToWindowMap;
    boolean mIsFakeTouchDevice;
    private boolean mIsIgnoreOrientationRequestDisabled;
    boolean mIsPc;
    boolean mIsTouchDevice;
    final Map<IBinder, KeyInterceptionInfo> mKeyInterceptionInfoForToken;
    private final KeyguardDisableHandler mKeyguardDisableHandler;
    private final RemoteCallbackList<IKeyguardLockedStateListener> mKeyguardLockedStateListeners;
    String mLastANRState;
    final LatencyTracker mLatencyTracker;
    final boolean mLimitedAlphaCompositing;
    final int mMaxUiWidth;
    volatile float mMaximumObscuringOpacityForTouch;
    private IObricWindowManagerService mObricExt;
    WindowManagerInternal.OnImeRequestedChangedListener mOnImeRequestedChangedListener;
    private final List<WindowManagerInternal.OnWindowRemovedListener> mOnWindowRemovedListeners;
    private final SparseIntArray mOrientationMapping;
    final int mOverrideConfigTypes;
    final int mOverrideDecorTypes;
    boolean mPerDisplayFocusEnabled;
    private BoostFramework mPerf;
    final PackageManagerInternal mPmInternal;
    private Runnable mPointerDownOutsideFocusRunnable;
    boolean mPointerLocationEnabled;
    WindowManagerPolicy mPolicy;
    final PossibleDisplayInfoMapper mPossibleDisplayInfoMapper;
    PowerManager mPowerManager;
    PowerManagerInternal mPowerManagerInternal;
    final PresentationController mPresentationController;
    private final PriorityDump.PriorityDumper mPriorityDumper;
    final ArrayList<WindowState> mResizingWindows;
    final RootWindowContainer mRoot;
    final RotationWatcherController mRotationWatcherController;
    boolean mSafeMode;
    private final ScreenRecordingCallbackController mScreenRecordingCallbackController;
    final SensitiveContentPackages mSensitiveContentPackages;
    private long mSensitiveContentProtectionSessionId;
    final ArraySet<Session> mSessions;
    SettingsObserver mSettingsObserver;
    boolean mShowAlertWindowNotifications;
    boolean mShowingBootMessages;
    boolean mSkipActivityRelaunchWhenDocking;
    private WindowManagerServiceSmtEx mSmtEx;
    final SnapshotController mSnapshotController;
    final StartingSurfaceController mStartingSurfaceController;
    StrictModeFlash mStrictModeFlash;
    final boolean mSupportsHighPerfTransitions;
    SurfaceAnimationRunner mSurfaceAnimationRunner;
    Supplier<SurfaceControl.Builder> mSurfaceControlFactory;
    private final SurfaceSyncGroupController mSurfaceSyncGroupController;
    boolean mSwitchingUser;
    final BLASTSyncEngine mSyncEngine;
    boolean mSystemBooted;
    SystemPerformanceHinter mSystemPerformanceHinter;
    boolean mSystemReady;
    final TaskFpsCallbackController mTaskFpsCallbackController;
    final TaskSnapshotController mTaskSnapshotController;
    final TaskSystemBarsListenerController mTaskSystemBarsListenerController;
    private WindowContentFrameStats mTempWindowRenderStats;
    private final TestUtilityService mTestUtilityService;
    final Rect mTmpRect;
    private final SurfaceControl.Transaction mTransaction;
    Supplier<SurfaceControl.Transaction> mTransactionFactory;
    int mTransactionSequence;
    private float mTransitionAnimationScaleSetting;
    final TransitionTracer mTransitionTracer;
    final TrustedPresentationListenerController mTrustedPresentationListenerController;
    final UserManagerInternal mUmInternal;
    private ViewServer mViewServer;
    int mVr2dDisplayId;
    boolean mVrModeEnabled;
    private final IVrStateCallbacks mVrStateCallbacks;
    final ArrayMap<WindowContainer<?>, Message> mWaitingForDrawnCallbacks;
    final WallpaperVisibilityListeners mWallpaperVisibilityListeners;
    Watermark mWatermark;
    private float mWindowAnimationScaleSetting;
    final ArrayList<WindowChangeListener> mWindowChangeListeners;
    final WindowContextListenerController mWindowContextListenerController;
    final ArrayList<WindowManagerInternal.WindowFocusChangeListener> mWindowFocusChangeListeners;
    final HashMap<IBinder, WindowState> mWindowMap;
    final WindowSurfacePlacer mWindowPlacerLocked;
    final WindowTracing mWindowTracing;
    boolean mWindowsChanged;
    int mWindowsInsetsChanged;

    private final class ConfigurationChangeSettingInternalImpl implements ConfigurationChangeSetting.ConfigurationChangeSettingInternal {
        final /* synthetic */ WindowManagerService this$0;

        private final class DensitySettingImpl extends ConfigurationChangeSetting.DensitySetting {
            final /* synthetic */ ConfigurationChangeSettingInternalImpl this$1;

            /* synthetic */ DensitySettingImpl(ConfigurationChangeSettingInternalImpl r1, Parcel r2, WindowManagerServiceIA r3) {
                this(r1, r2);
            }

            private DensitySettingImpl(ConfigurationChangeSettingInternalImpl r1, Parcel in) {
                this.this$1 = r1;
                super(in);
            }

            public void apply(int userId) {
                WindowManagerService.m10445$$Nest$msetForcedDensityLockedInternal(this.this$1.this$0, ((ConfigurationChangeSetting.DensitySetting) this).mDisplayId, ((ConfigurationChangeSetting.DensitySetting) this).mDensity, userId);
            }
        }

        private final class FontScaleSettingImpl extends ConfigurationChangeSetting.FontScaleSetting {
            final /* synthetic */ ConfigurationChangeSettingInternalImpl this$1;

            /* synthetic */ FontScaleSettingImpl(ConfigurationChangeSettingInternalImpl r1, Parcel r2, WindowManagerServiceIA r3) {
                this(r1, r2);
            }

            private FontScaleSettingImpl(ConfigurationChangeSettingInternalImpl r1, Parcel in) {
                this.this$1 = r1;
                super(in);
            }

            public void apply(int userId) {
                Settings.System.putFloat(this.this$1.this$0.mContext.getContentResolver(), "font_scale", ((ConfigurationChangeSetting.FontScaleSetting) this).mFontScaleFactor);
                this.this$1.this$0.mAtmService.updateFontScaleIfNeeded(userId);
            }
        }

        /* synthetic */ ConfigurationChangeSettingInternalImpl(WindowManagerService r1, WindowManagerServiceIA r2) {
            this(r1);
        }

        private ConfigurationChangeSettingInternalImpl(WindowManagerService r1) {
            this.this$0 = r1;
        }

        public ConfigurationChangeSetting createImplFromParcel(int settingType, Parcel in) {
            WindowManagerServiceIA r0 = null;
            switch(settingType) {
                case 0: goto L9;
                case 1: goto L7;
                default: goto L5;
            };
        L5:
            throw new IllegalArgumentException("Unknown setting type " + settingType);
        L7:
            return new FontScaleSettingImpl(this, in, r0);
        L9:
            return new DensitySettingImpl(this, in, r0);
        }
    }

    private class DeviceStateCallback implements DeviceStateManager.DeviceStateCallback {
        private DeviceState mCurrentDeviceState;

        /* synthetic */ DeviceStateCallback(WindowManagerService r1, WindowManagerServiceIA r2) {
            this(r1);
        }

        private DeviceStateCallback(WindowManagerService r1) {
        }

        public void onDeviceStateChanged(DeviceState state) {
            this.mCurrentDeviceState = state;
        }

        boolean isInRearDisplayOuterDefaultState() {
            if (this.mCurrentDeviceState != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mCurrentDeviceState.hasProperties(new int[]{1001}) == false) goto L7;
            return true;
        }
    }

    final class H extends Handler {
        public static final int BOOT_TIMEOUT = 23;
        public static final int CHECK_IF_BOOT_ANIMATION_FINISHED = 37;
        public static final int ENABLE_SCREEN = 16;
        public static final int INSETS_CHANGED = 66;
        public static final int NEW_ANIMATOR_SCALE = 34;
        public static final int NOTIFY_ACTIVITY_DRAWN = 32;
        public static final int ON_POINTER_DOWN_OUTSIDE_FOCUS = 62;
        public static final int PERSIST_ANIMATION_SCALE = 14;
        public static final int RECOMPUTE_FOCUS = 61;
        public static final int REPARENT_TASK_TO_DEFAULT_DISPLAY = 65;
        public static final int REPORT_HARD_KEYBOARD_STATUS_CHANGE = 22;
        public static final int REPORT_WINDOWS_CHANGE = 19;
        public static final int RESET_ANR_MESSAGE = 38;
        public static final int SET_HAS_OVERLAY_UI = 58;
        public static final int SHOW_EMULATOR_DISPLAY_OVERLAY = 36;
        public static final int SHOW_STRICT_MODE_VIOLATION = 25;
        public static final int UNUSED = 0;
        public static final int UPDATE_ANIMATION_SCALE = 51;
        public static final int UPDATE_MULTI_WINDOW_STACKS = 41;
        public static final int WAITING_FOR_DRAWN_TIMEOUT = 24;
        public static final int WALLPAPER_DRAW_PENDING_TIMEOUT = 39;
        public static final int WINDOW_HIDE_TIMEOUT = 52;
        public static final int WINDOW_STATE_BLAST_SYNC_TIMEOUT = 64;
        final /* synthetic */ WindowManagerService this$0;

        H(WindowManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (WindowManagerDebugConfig.DEBUG_WINDOW_TRACE == false) goto L5;
            Slog.v(WindowManagerService.TAG, "handleMessage: entry what=" + msg.what);
        L5:
            boolean isUpdateSystem = false;
            switch(msg.what) {
                case 14: goto L207;
                case 16: goto L206;
                case 19: goto L196;
                case 22: goto L194;
                case 23: goto L193;
                case 24: goto L172;
                case 25: goto L171;
                case 32: goto L159;
                case 34: goto L127;
                case 36: goto L126;
                case 37: goto L111;
                case 38: goto L102;
                case 39: goto L88;
                case 41: goto L76;
                case 51: goto L69;
                case 52: goto L60;
                case 58: goto L56;
                case 61: goto L47;
                case 62: goto L38;
                case 64: goto L29;
                case 65: goto L20;
                case 66: goto L8;
                default: goto L209;
            };
        L8:
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L13:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L11:
            if (this.this$0.mWindowsInsetsChanged <= 0) goto L15;
            this.this$0.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            goto L209
        L20:
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            Task task = (Task) msg.obj;     // Catch: Throwable -> L25
            task.reparent(this.this$0.mRoot.getDefaultTaskDisplayArea(), true);     // Catch: Throwable -> L25
            task.resumeNextFocusAfterReparent();     // Catch: Throwable -> L25
            monitor-exit(r1);     // Catch: Throwable -> L25
            WindowManagerService.resetPriorityAfterLockedSection();
        L25:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L29:
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            WindowState ws = (WindowState) msg.obj;     // Catch: Throwable -> L34
            Slog.i(WindowManagerService.TAG, "Blast sync timeout: " + ws);     // Catch: Throwable -> L34
            ws.immediatelyNotifyBlastSync();     // Catch: Throwable -> L34
            monitor-exit(r2);     // Catch: Throwable -> L34
            WindowManagerService.resetPriorityAfterLockedSection();
        L34:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L38:
            WindowManagerGlobalLock r3 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r3);
            IBinder touchedToken = (IBinder) msg.obj;     // Catch: Throwable -> L43
            WindowManagerService.m10443$$Nest$monPointerDownOutsideFocusLocked(this.this$0, this.this$0.getInputTargetFromToken(touchedToken), true);     // Catch: Throwable -> L43
            monitor-exit(r3);     // Catch: Throwable -> L43
            WindowManagerService.resetPriorityAfterLockedSection();
        L43:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L47:
            WindowManagerGlobalLock r4 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r4);
            this.this$0.updateFocusedWindowLocked(0, true);     // Catch: Throwable -> L52
            monitor-exit(r4);     // Catch: Throwable -> L52
            WindowManagerService.resetPriorityAfterLockedSection();
        L52:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L56:
            ActivityManagerInternal r5 = this.this$0.mAmInternal;
            int r6 = msg.arg1;
            if (msg.arg2 != 1) goto L59;
            isUpdateSystem = true;
        L59:
            r5.setHasOverlayUi(r6, isUpdateSystem);
            goto L209
        L60:
            WindowState window = (WindowState) msg.obj;
            WindowManagerGlobalLock r7 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r7);
            window.mAttrs.flags &= -129;     // Catch: Throwable -> L65
            window.hidePermanentlyLw();     // Catch: Throwable -> L65
            window.setDisplayLayoutNeeded();     // Catch: Throwable -> L65
            this.this$0.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L65
            monitor-exit(r7);     // Catch: Throwable -> L65
            WindowManagerService.resetPriorityAfterLockedSection();
        L65:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L69:
            int mode = msg.arg1;
            switch(mode) {
                case 0: goto L74;
                case 1: goto L73;
                case 2: goto L72;
                default: goto L209;
            };
        L72:
            WindowManagerService.m10430$$Nest$fputmAnimatorDurationScaleSetting(this.this$0, WindowManagerService.m10438$$Nest$mgetAnimatorDurationScaleSetting(this.this$0));
            this.this$0.dispatchNewAnimatorScaleLocked(null);
            goto L209
        L73:
            WindowManagerService.m10433$$Nest$fputmTransitionAnimationScaleSetting(this.this$0, WindowManagerService.m10440$$Nest$mgetTransitionAnimationScaleSetting(this.this$0));
            goto L209
        L74:
            WindowManagerService.m10434$$Nest$fputmWindowAnimationScaleSetting(this.this$0, WindowManagerService.m10441$$Nest$mgetWindowAnimationScaleSetting(this.this$0));
            goto L209
        L76:
            WindowManagerGlobalLock r8 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r8);
            DisplayContent displayContent = (DisplayContent) msg.obj;     // Catch: Throwable -> L81
            if (displayContent == null) goto L83;
            displayContent.adjustForImeIfNeeded();     // Catch: Throwable -> L81
        L83:
            monitor-exit(r8);     // Catch: Throwable -> L81
            WindowManagerService.resetPriorityAfterLockedSection();
        L81:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L88:
            WindowManagerGlobalLock r9 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r9);
            WallpaperController wallpaperController = (WallpaperController) msg.obj;     // Catch: Throwable -> L95
            if (wallpaperController != null) goto L93;
        L97:
            monitor-exit(r9);     // Catch: Throwable -> L95
            WindowManagerService.resetPriorityAfterLockedSection();
            goto L209
        L93:
            if (wallpaperController.processWallpaperDrawPendingTimeout() == false) goto L97;
            this.this$0.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L95
        L95:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L102:
            WindowManagerGlobalLock r10 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r10);
            this.this$0.mLastANRState = null;     // Catch: Throwable -> L107
            this.this$0.mAtmService.mLastANRState = null;     // Catch: Throwable -> L107
            monitor-exit(r10);     // Catch: Throwable -> L107
            WindowManagerService.resetPriorityAfterLockedSection();
        L107:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L111:
            WindowManagerGlobalLock r11 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r11);
        L116:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L114:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L118;
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -2240705227895260140L, 0, null);     // Catch: Throwable -> L116
        L118:
            boolean bootAnimationComplete = WindowManagerService.m10435$$Nest$mcheckBootAnimationCompleteLocked(this.this$0);     // Catch: Throwable -> L116
            monitor-exit(r11);     // Catch: Throwable -> L116
            WindowManagerService.resetPriorityAfterLockedSection();
            if (bootAnimationComplete == false) goto L209;
            WindowManagerService.m10444$$Nest$mperformEnableScreen(this.this$0);
            goto L209
        L126:
            this.this$0.showEmulatorDisplayOverlay();
            goto L209
        L127:
            float scale = Float.intBitsToFloat(msg.arg1);
            if (msg.arg2 != 1) goto L130;
            isUpdateSystem = true;
        L130:
            if (isUpdateSystem == false) goto L132;
            ValueAnimator.setDurationScale(scale);
        L132:
            Session session = (Session) msg.obj;
            if (session != null) goto L214;
            ArrayList<IWindowSessionCallback> callbacks = new ArrayList();
            WindowManagerGlobalLock r12 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r12);
            int i = 0;
        L228:
        L144:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L142:
            if (i >= this.this$0.mSessions.size()) goto L147;
            callbacks.add(this.this$0.mSessions.valueAt(i).mCallback);     // Catch: Throwable -> L144
            i = i + 1;     // Catch: Throwable -> L144
            goto L228
        L147:
            monitor-exit(r12);     // Catch: Throwable -> L144
            WindowManagerService.resetPriorityAfterLockedSection();
            int i2 = 0;
        L150:
            if (i2 >= callbacks.size()) goto L209;
            callbacks.get(i2).onAnimatorScaleChanged(scale);     // Catch: RemoteException -> L153
        L154:
            i2 = i2 + 1;
            goto L150
        L214:
            session.mCallback.onAnimatorScaleChanged(scale);     // Catch: RemoteException -> L136
            goto L209
        L159:
            ActivityRecord activity = (ActivityRecord) msg.obj;
            WindowManagerGlobalLock r13 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r13);
        L164:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L162:
            if (activity.isAttached() == false) goto L166;
            activity.getRootTask().notifyActivityDrawnLocked(activity);     // Catch: Throwable -> L164
        L166:
            monitor-exit(r13);     // Catch: Throwable -> L164
            WindowManagerService.resetPriorityAfterLockedSection();
            goto L209
        L171:
            WindowManagerService.m10446$$Nest$mshowStrictModeViolation(this.this$0, msg.arg1, msg.arg2);
            goto L209
        L172:
            WindowContainer<?> container = (WindowContainer) msg.obj;
            WindowManagerGlobalLock r14 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r14);
        L177:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L175:
            if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L180;
            String protoLogParam0 = String.valueOf(container.mWaitingForDrawn);     // Catch: Throwable -> L177
            ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 5830724144971462783L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L177
        L180:
            if (Trace.isTagEnabled(32) == false) goto L185;
            int i3 = 0;
        L183:
            if (i3 >= container.mWaitingForDrawn.size()) goto L185;
            WindowManagerService.m10449$$Nest$mtraceEndWaitingForWindowDrawn(this.this$0, container.mWaitingForDrawn.get(i3));     // Catch: Throwable -> L177
            i3 = i3 + 1;     // Catch: Throwable -> L177
        L185:
            container.mWaitingForDrawn.clear();     // Catch: Throwable -> L177
            Message callback = this.this$0.mWaitingForDrawnCallbacks.remove(container);     // Catch: Throwable -> L177
            monitor-exit(r14);     // Catch: Throwable -> L177
            WindowManagerService.resetPriorityAfterLockedSection();
            if (callback == null) goto L209;
            callback.sendToTarget();
            goto L209
        L193:
            this.this$0.performBootTimeout();
            goto L209
        L194:
            this.this$0.notifyHardKeyboardStatusChange();
            goto L209
        L206:
            WindowManagerService.m10444$$Nest$mperformEnableScreen(this.this$0);
            goto L209
        L207:
            Settings.Global.putFloat(this.this$0.mContext.getContentResolver(), "window_animation_scale", WindowManagerService.m10428$$Nest$fgetmWindowAnimationScaleSetting(this.this$0));
            Settings.Global.putFloat(this.this$0.mContext.getContentResolver(), "transition_animation_scale", WindowManagerService.m10427$$Nest$fgetmTransitionAnimationScaleSetting(this.this$0));
            Settings.Global.putFloat(this.this$0.mContext.getContentResolver(), "animator_duration_scale", WindowManagerService.m10419$$Nest$fgetmAnimatorDurationScaleSetting(this.this$0));
            goto L209
        L196:
            if (this.this$0.mWindowsChanged == false) goto L209;
            WindowManagerGlobalLock r15 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r15);
            this.this$0.mWindowsChanged = false;     // Catch: Throwable -> L202
            monitor-exit(r15);     // Catch: Throwable -> L202
            WindowManagerService.resetPriorityAfterLockedSection();
            WindowManagerService.m10442$$Nest$mnotifyWindowsChanged(this.this$0);
        L202:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L209:
            if (WindowManagerDebugConfig.DEBUG_WINDOW_TRACE == false) goto L249;
            Slog.v(WindowManagerService.TAG, "handleMessage: exit");
            return;
        }

        void sendNewMessageDelayed(int what, Object obj, long delayMillis) {
            removeMessages(what, obj);
            sendMessageDelayed(obtainMessage(what, obj), delayMillis);
        }
    }

    private final class ImeTargetVisibilityPolicyImpl extends ImeTargetVisibilityPolicy {
        final /* synthetic */ WindowManagerService this$0;

        /* synthetic */ ImeTargetVisibilityPolicyImpl(WindowManagerService r1, WindowManagerServiceIA r2) {
            this(r1);
        }

        private ImeTargetVisibilityPolicyImpl(WindowManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.wm.ImeTargetVisibilityPolicy
        public boolean showImeScreenshot(IBinder imeTarget, int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState imeTargetWindow = this.this$0.mWindowMap.get(imeTarget);     // Catch: Throwable -> L9
            if (imeTargetWindow != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L11:
            DisplayContent dc = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
            if (dc != null) goto L17;
            Slog.w(WindowManagerService.TAG, "Invalid displayId:" + displayId + ", fail to show ime screenshot");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L17:
            dc.showImeScreenshot(imeTargetWindow);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return true;
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.ImeTargetVisibilityPolicy
        public boolean removeImeScreenshot(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            DisplayContent dc = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
            if (dc != null) goto L12;
            Slog.w(WindowManagerService.TAG, "Invalid displayId:" + displayId + ", fail to remove ime screenshot");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L12:
            dc.removeImeSurfaceImmediately();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return true;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    private final class LocalService extends WindowManagerInternal {
        final /* synthetic */ WindowManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$9FCOImbIiD2uo8xfZd-RIJEUT0o, reason: not valid java name */
        public static /* synthetic */ void m10453$r8$lambda$9FCOImbIiD2uo8xfZdRIJEUT0o(LocalService r0, WindowState r1) {
            r0.lambda$addBlockScreenCaptureForApps$5(r1);
        }

        public static /* synthetic */ void $r8$lambda$C6zi28HNoW0nZ1F0apCWSSTp_aE(int r0, DisplayContent r1) {
            lambda$updateInputMethodTargetWindow$1(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$DmFe7RzaK4sM8AgRQhkQVLCFJlk(String r0, float r1, float r2, DisplayContent r3) {
            lambda$addRefreshRateRangeForPackage$2(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$QNsHYJ-MA8douw77NPph-woYBJc, reason: not valid java name */
        public static /* synthetic */ void m10454$r8$lambda$QNsHYJMA8douw77NPphwoYBJc(String r0, DisplayContent r1) {
            lambda$removeRefreshRateRangeForPackage$3(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$Vg_e8dcGWMAPWCZMn3LihEPEF_8(int r0, WindowState r1) {
            return lambda$takeContextualSearchScreenshot$6(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$lk-ezvC20UqC557MIWFnPJCqHrs, reason: not valid java name */
        public static /* synthetic */ void m10455$r8$lambda$lkezvC20UqC557MIWFnPJCqHrs(LocalService r0, int r1) {
            r0.lambda$onDisplayManagerReceivedDeviceState$0(r1);
        }

        public static /* synthetic */ boolean $r8$lambda$snfFB65OTxbIwG2XAmXiF0ePWiQ(ActivityRecord r0) {
            return lambda$addBlockScreenCaptureForApps$4(r0);
        }

        LocalService(WindowManagerService r1) {
            this.this$0 = r1;
            super(r1.mRoot);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public WindowManagerInternal.AccessibilityControllerInternal getAccessibilityController() {
            return AccessibilityController.getAccessibilityControllerInternal(this.this$0);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void clearSnapshotCache() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mTaskSnapshotController.clearSnapshotCache();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void requestTraversalFromDisplayManager() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.requestTraversal();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void onDisplayManagerReceivedDeviceState(final int deviceState) {
            this.this$0.mH.post(new WindowManagerService$LocalService$$ExternalSyntheticLambda0(this, deviceState));
        }

        private /* synthetic */ void lambda$onDisplayManagerReceivedDeviceState$0(int deviceState) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRoot.onDisplayManagerReceivedDeviceState(deviceState);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setMagnificationSpec(int displayId, MagnificationSpec spec) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mAccessibilityController.hasCallbacks() == false) goto L13;
            this.this$0.mAccessibilityController.setMagnificationSpec(displayId, spec);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            throw new IllegalStateException("Magnification callbacks not set!");     // Catch: Throwable -> L10
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setFullscreenMagnificationActivated(int displayId, boolean activated) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mAccessibilityController.hasCallbacks() == false) goto L13;
            this.this$0.mAccessibilityController.setFullscreenMagnificationActivated(displayId, activated);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            throw new IllegalStateException("Magnification callbacks not set!");     // Catch: Throwable -> L10
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void getMagnificationRegion(int displayId, Region magnificationRegion) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mAccessibilityController.hasCallbacks() == false) goto L13;
            this.this$0.mAccessibilityController.getMagnificationRegion(displayId, magnificationRegion);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            throw new IllegalStateException("Magnification callbacks not set!");     // Catch: Throwable -> L10
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean setMagnificationCallbacks(int displayId, WindowManagerInternal.MagnificationCallbacks callbacks) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean r1 = this.this$0.mAccessibilityController.setMagnificationCallbacks(displayId, callbacks);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setWindowsForAccessibilityCallback(int displayId, WindowManagerInternal.WindowsForAccessibilityCallback callback) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mAccessibilityController.setWindowsForAccessibilityCallback(displayId, callback);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setInputFilter(IInputFilter filter) {
            Slog.d(WindowManagerService.TAG, "setInputFilter filter=" + filter);
            this.this$0.mInputManager.setInputFilter(filter);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public IBinder getFocusedWindowToken() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            IBinder r1 = this.this$0.mAccessibilityController.getFocusedWindowToken();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public IBinder getFocusedWindowTokenFromWindowStates() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState windowState = this.this$0.getFocusedWindowLocked();     // Catch: Throwable -> L10
            if (windowState == null) goto L12;
            IBinder r2 = windowState.mClient.asBinder();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void moveDisplayToTopIfAllowed(int displayId) {
            this.this$0.moveDisplayToTopIfAllowed(displayId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void requestWindowFocus(IBinder windowToken) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            InputTarget inputTarget = this.this$0.getInputTargetFromWindowTokenLocked(windowToken);     // Catch: Throwable -> L8
            WindowManagerService.m10443$$Nest$monPointerDownOutsideFocusLocked(this.this$0, inputTarget, false);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isKeyguardLocked() {
            return this.this$0.isKeyguardLocked();
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isKeyguardShowingAndNotOccluded() {
            return this.this$0.isKeyguardShowingAndNotOccluded();
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isKeyguardSecure(int userId) {
            return this.this$0.mPolicy.isKeyguardSecure(userId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void showGlobalActions() {
            this.this$0.showGlobalActions();
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void getWindowFrame(IBinder token, Rect outBounds) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState windowState = this.this$0.mWindowMap.get(token);     // Catch: Throwable -> L7
            if (windowState == null) goto L9;
            outBounds.set(windowState.getFrame());     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L9:
            outBounds.setEmpty();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public Pair<Matrix, MagnificationSpec> getWindowTransformationMatrixAndMagnificationSpec(IBinder token) {
            return this.this$0.mAccessibilityController.getWindowTransformationMatrixAndMagnificationSpec(token);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void waitForAllWindowsDrawn(Message message, long timeout, int displayId) {
            message.getTarget().getClass();
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            boolean allWindowsDrawn = waitForAllWindowsDrawnLocked(message, timeout, displayId);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            if (allWindowsDrawn == false) goto L16;
            message.sendToTarget();
            return;
        L16:
            return;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private boolean waitForAllWindowsDrawnLocked(Message message, long timeout, int displayId) {
            if (displayId != (-1)) goto L5;
            WindowContainer<?> container = this.this$0.mRoot;
        L7:
            if (container != null) goto L10;
            return true;
        L10:
            if (displayId == (-1)) goto L12;
        L14:
            container.waitForAllWindowsDrawn();
            this.this$0.mWindowPlacerLocked.requestTraversal();
            this.this$0.mH.removeMessages(24, container);
            if (container.mWaitingForDrawn.isEmpty() == false) goto L18;
            return true;
        L18:
            if (Trace.isTagEnabled(32) == false) goto L23;
            int i = 0;
        L21:
            if (i >= container.mWaitingForDrawn.size()) goto L23;
            WindowManagerService.m10450$$Nest$mtraceStartWaitingForWindowDrawn(this.this$0, container.mWaitingForDrawn.get(i));
            i = i + 1;
        L23:
            this.this$0.mWaitingForDrawnCallbacks.put(container, message);
            this.this$0.mH.sendNewMessageDelayed(24, container, timeout);
            this.this$0.checkDrawnWindowsLocked();
            return false;
        L12:
            if (this.this$0.mRoot.getDefaultDisplay().mDisplayUpdater.waitForTransition(message) == false) goto L14;
            return false;
        L5:
            container = this.this$0.mRoot.getDisplayContent(displayId);
            goto L7
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setForcedDisplaySize(int displayId, int width, int height) {
            this.this$0.setForcedDisplaySize(displayId, width, height);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void clearForcedDisplaySize(int displayId) {
            this.this$0.clearForcedDisplaySize(displayId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void addWindowToken(IBinder token, int type, int displayId, Bundle options) {
            this.this$0.addWindowToken(token, type, displayId, options);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void removeWindowToken(IBinder binder, boolean removeWindows, boolean animateExit, int displayId) {
            this.this$0.removeWindowToken(binder, removeWindows, animateExit, displayId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void moveWindowTokenToDisplay(IBinder binder, int displayId) {
            this.this$0.moveWindowTokenToDisplay(binder, displayId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void registerAppTransitionListener(WindowManagerInternal.AppTransitionListener listener) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mAtmService.getTransitionController().registerLegacyListener(listener);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void registerTaskSystemBarsListener(WindowManagerInternal.TaskSystemBarsListener listener) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mTaskSystemBarsListenerController.registerListener(listener);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void unregisterTaskSystemBarsListener(WindowManagerInternal.TaskSystemBarsListener listener) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mTaskSystemBarsListenerController.unregisterListener(listener);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void reportPasswordChanged(int userId) {
            WindowManagerService.m10422$$Nest$fgetmKeyguardDisableHandler(this.this$0).updateKeyguardEnabled(userId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public int getInputMethodWindowVisibleHeight(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            DisplayContent dc = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L8
            int r2 = dc.getInputMethodWindowVisibleHeight();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setDismissImeOnBackKeyPressed(boolean dismissImeOnBackKeyPressed) {
            this.this$0.mPolicy.setDismissImeOnBackKeyPressed(dismissImeOnBackKeyPressed);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void updateInputMethodTargetWindow(IBinder imeTargetWindowToken) {
            if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L5;
            Slog.w(WindowManagerService.TAG, "updateInputMethodTargetWindow: imeTargetWindowToken=" + imeTargetWindowToken);
        L5:
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            InputTarget imeTarget = this.this$0.getInputTargetFromWindowTokenLocked(imeTargetWindowToken);     // Catch: Throwable -> L14
            if (imeTarget == null) goto L16;
            imeTarget.getDisplayContent().updateImeInputAndControlTarget(imeTarget);     // Catch: Throwable -> L14
            WindowState imeWindowState = imeTarget.getWindowState();     // Catch: Throwable -> L14
            if (imeWindowState == null) goto L16;
            InsetsControlTarget fallback = imeTarget.getDisplayContent().getImeHostOrFallback(imeWindowState);     // Catch: Throwable -> L14
            if (imeWindowState == fallback) goto L16;
            final int currentDisplayId = imeTarget.getDisplayContent().getDisplayId();     // Catch: Throwable -> L14
            this.this$0.mRoot.forAllDisplays(new WindowManagerService$LocalService$$ExternalSyntheticLambda4(currentDisplayId));     // Catch: Throwable -> L14
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L14
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L14:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private static /* synthetic */ void lambda$updateInputMethodTargetWindow$1(int currentDisplayId, DisplayContent display) {
            if (display.getDisplayId() == currentDisplayId) goto L6;
            display.setImeInputTarget(null);
            return;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isHardKeyboardAvailable() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean r1 = this.this$0.mHardKeyboardAvailable;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setOnHardKeyboardStatusChangeListener(WindowManagerInternal.OnHardKeyboardStatusChangeListener listener) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mHardKeyboardStatusChangeListener = listener;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setOnImeRequestedChangedListener(WindowManagerInternal.OnImeRequestedChangedListener listener) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mOnImeRequestedChangedListener = listener;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void computeWindowsForAccessibility(int displayId) {
            this.this$0.mAccessibilityController.performComputeChangedWindowsNot(displayId, true);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setVr2dDisplayId(int vr2dDisplayId) {
            if (WindowManagerDebugConfig.DEBUG_DISPLAY == false) goto L5;
            Slog.d(WindowManagerService.TAG, "setVr2dDisplayId called for: " + vr2dDisplayId);
        L5:
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mVr2dDisplayId = vr2dDisplayId;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void registerDragDropControllerCallback(WindowManagerInternal.IDragDropCallback callback) {
            this.this$0.mDragDropController.registerCallback(callback);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void lockNow() {
            this.this$0.lockNow(null);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public int getWindowOwnerUserId(IBinder token) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState window = this.this$0.mWindowMap.get(token);     // Catch: Throwable -> L10
            if (window == null) goto L12;
            int r2 = window.mShowUserId;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return ProcessList.INVALID_ADJ;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setWallpaperShowWhenLocked(IBinder binder, boolean showWhenLocked) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowToken token = this.this$0.mRoot.getWindowToken(binder);     // Catch: Throwable -> L13
            if (token == null) goto L16;
            if (token.asWallpaperToken() == null) goto L16;
            token.asWallpaperToken().setShowWhenLocked(showWhenLocked);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L16:
            if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L18;
            String protoLogParam0 = String.valueOf(binder);     // Catch: Throwable -> L13
            ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 5770211341769258866L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L13
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setWallpaperCropHints(IBinder binder, SparseArray<Rect> cropHints) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowToken token = this.this$0.mRoot.getWindowToken(binder);     // Catch: Throwable -> L13
            if (token == null) goto L16;
            if (token.asWallpaperToken() == null) goto L16;
            token.asWallpaperToken().setCropHints(cropHints);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L16:
            if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L18;
            String protoLogParam0 = String.valueOf(binder);     // Catch: Throwable -> L13
            ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 698926505694016512L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L13
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isUidFocused(int uid) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            int i = this.this$0.mRoot.getChildCount() - 1;     // Catch: Throwable -> L13
        L5:
            if (i < 0) goto L17;
            DisplayContent displayContent = this.this$0.mRoot.getChildAt(i);     // Catch: Throwable -> L13
            if (displayContent.mCurrentFocus == null) goto L15;
            if (uid != displayContent.mCurrentFocus.getOwningUid()) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return true;
        L15:
            i = i - 1;
            goto L5
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L13:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public int hasInputMethodClientFocus(IBinder windowToken, int uid, int pid, int displayId) {
            int r1 = -1;
            if (displayId != (-1)) goto L5;
            return -3;
        L5:
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            DisplayContent displayContent = this.this$0.mRoot.getTopFocusedDisplayContent();     // Catch: Throwable -> L12
            InputTarget target = this.this$0.getInputTargetFromWindowTokenLocked(windowToken);     // Catch: Throwable -> L12
            if (target != null) goto L14;
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return -1;
        L14:
            int result = WindowManagerService.m10423$$Nest$fgetmObricExt(this.this$0).hasInputMethodClientFocus(displayId);     // Catch: Throwable -> L12
            if (result == (-5)) goto L20;
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return result;
        L20:
            int tokenDisplayId = target.getDisplayContent().getDisplayId();     // Catch: Throwable -> L12
            if (tokenDisplayId == displayId) goto L26;
            Slog.e(WindowManagerService.TAG, "isInputMethodClientFocus: display ID mismatch. from client: " + displayId + " from window: " + tokenDisplayId);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return -2;
        L26:
            if (displayContent != null) goto L28;
        L60:
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return -3;
        L28:
            if (displayContent.getDisplayId() != displayId) goto L60;
            if (displayContent.hasAccess(uid) == false) goto L60;
            if (target.isInputMethodClientFocus(uid, pid) == false) goto L37;
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return 0;
        L37:
            WindowState currentFocus = displayContent.mCurrentFocus;     // Catch: Throwable -> L12
            if (currentFocus != null) goto L40;
        L57:
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return -1;
        L40:
            if (currentFocus.mSession.mUid != uid) goto L57;
            if (currentFocus.mSession.mPid != pid) goto L57;
            if (currentFocus.getTask() == null) goto L51;
            if (currentFocus.getTask().getExt().isMiniMode() == false) goto L51;
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return -1;
        L51:
            if (currentFocus.canBeImeTarget() == false) goto L54;
            r1 = 0;
        L54:
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L12:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void showImePostLayout(IBinder imeTargetWindowToken, ImeTracker.Token statsToken) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            InputTarget imeTarget = this.this$0.getInputTargetFromWindowTokenLocked(imeTargetWindowToken);     // Catch: Throwable -> L10
            if (imeTarget != null) goto L12;
            ImeTracker.forLogging().onFailed(statsToken, 20);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L12:
            WindowState imeTargetWindow = imeTarget.getWindowState();     // Catch: Throwable -> L10
            if (imeTargetWindow != null) goto L15;
        L20:
            ImeTracker.forLogging().onProgress(statsToken, 20);     // Catch: Throwable -> L10
            InsetsControlTarget controlTarget = imeTarget.getImeControlTarget();     // Catch: Throwable -> L10
            InputTarget imeTarget2 = controlTarget.getWindow();     // Catch: Throwable -> L10
            if (imeTarget2 == null) goto L23;
            DisplayContent dc = imeTarget2.getDisplayContent();     // Catch: Throwable -> L10
        L24:
            dc.getInsetsStateController().getImeSourceProvider().scheduleShowImePostLayout(controlTarget, statsToken);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L23:
            dc = this.this$0.getDefaultDisplayContentLocked();     // Catch: Throwable -> L10
            goto L24
        L15:
            if (imeTargetWindow.getExt().shouldSkipShowIme() == false) goto L20;
            ImeTracker.forLogging().onFailed(statsToken, 20);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void hideIme(IBinder imeTargetWindowToken, int displayId, ImeTracker.Token statsToken) {
            Trace.traceBegin(32, "WMS.hideIme");
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState imeTarget = this.this$0.mWindowMap.get(imeTargetWindowToken);     // Catch: Throwable -> L7
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L9;
            String protoLogParam0 = String.valueOf(imeTarget);     // Catch: Throwable -> L7
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, -7428028317216329062L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L7
        L9:
            DisplayContent dc = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L7
            if (imeTarget == null) goto L16;
            WindowState imeTarget2 = imeTarget.getImeControlTarget().getWindow();     // Catch: Throwable -> L7
            if (imeTarget2 == null) goto L14;
            dc = imeTarget2.getDisplayContent();     // Catch: Throwable -> L7
        L14:
            dc.getInsetsStateController().getImeSourceProvider().abortShowImePostLayout();     // Catch: Throwable -> L7
        L16:
            if (dc != null) goto L18;
        L23:
            ImeTracker.forLogging().onFailed(statsToken, 20);     // Catch: Throwable -> L7
        L24:
            if (dc == null) goto L26;
            dc.getInsetsStateController().getImeSourceProvider().setImeShowing(false);     // Catch: Throwable -> L7
        L26:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            Trace.traceEnd(32);
            return;
        L18:
            if (dc.getImeTarget(2) == null) goto L23;
            ImeTracker.forLogging().onProgress(statsToken, 20);     // Catch: Throwable -> L7
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L22;
            String protoLogParam1 = String.valueOf(dc.getImeTarget(2));     // Catch: Throwable -> L7
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, 1006302987953651112L, 0, new Object[]{protoLogParam1});     // Catch: Throwable -> L7
        L22:
            dc.getImeTarget(2).hideInsets(WindowInsets.Type.ime(), true, statsToken);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isUidAllowedOnDisplay(int displayId, int uid) {
            boolean r0 = true;
            if (displayId != 0) goto L6;
            return true;
        L6:
            if (displayId != (-1)) goto L8;
            return false;
        L8:
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            DisplayContent displayContent = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L15
            if (displayContent != null) goto L13;
        L17:
            r0 = false;
        L18:
            monitor-exit(r1);     // Catch: Throwable -> L15
            WindowManagerService.resetPriorityAfterLockedSection();
            return r0;
        L13:
            if (displayContent.hasAccess(uid) == false) goto L17;
        L15:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public int getDisplayIdForWindow(IBinder windowToken) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState window = this.this$0.mWindowMap.get(windowToken);     // Catch: Throwable -> L10
            if (window == null) goto L12;
            int r2 = window.getDisplayContent().getDisplayId();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return -1;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public int getTopFocusedDisplayId() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            int r1 = this.this$0.mRoot.getTopFocusedDisplayContent().getDisplayId();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public Context getTopFocusedDisplayUiContext() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Context r1 = this.this$0.mRoot.getTopFocusedDisplayContent().getDisplayUiContext();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setNonDefaultDisplayRotation(int displayId, int rotation, String caller) {
            if (displayId != 0) goto L4;
        L23:
            Slog.w(WindowManagerService.TAG, "Cannot set rotation for display with id: " + displayId);
            return;
        L4:
            if (displayId == (-1)) goto L23;
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            DisplayContent displayContent = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L14
            if (displayContent != null) goto L16;
            Slog.w(WindowManagerService.TAG, "Cannot set rotation for display " + displayId + " due to missing DisplayContent");     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L16:
            displayContent.getDisplayRotation().setUserRotation(displayContent.getDisplayRotation().getUserRotationMode(), rotation, caller);     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L14:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setHomeSupportedOnDisplay(String displayUniqueId, int displayType, boolean supported) {
            long origId = Binder.clearCallingIdentity();
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;     // Catch: Throwable -> L10
            WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
            monitor-enter(r2);     // Catch: Throwable -> L10
            this.this$0.mDisplayWindowSettings.setHomeSupportedOnDisplayLocked(displayUniqueId, displayType, supported);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(origId);
            return;
        L12:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isHomeSupportedOnDisplay(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            DisplayContent displayContent = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
            if (displayContent == null) goto L7;
            boolean r2 = displayContent.isHomeSupported();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L7:
            if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L11;
            long protoLogParam0 = displayId;
            ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 5213970642134448962L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setIgnoreActivitySizeRestrictionsOnDisplay(String displayUniqueId, int displayType, boolean enabled) {
            long origId = Binder.clearCallingIdentity();
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;     // Catch: Throwable -> L10
            WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
            monitor-enter(r2);     // Catch: Throwable -> L10
            this.this$0.mDisplayWindowSettings.setIgnoreActivitySizeRestrictionsOnDisplayLocked(displayUniqueId, displayType, enabled);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(origId);
            return;
        L12:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void clearDisplaySettings(String displayUniqueId, int displayType) {
            long origId = Binder.clearCallingIdentity();
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;     // Catch: Throwable -> L10
            WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L10
            monitor-enter(r2);     // Catch: Throwable -> L10
            this.this$0.mDisplayWindowSettings.clearDisplaySettings(displayUniqueId, displayType);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(origId);
            return;
        L12:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public int getDisplayImePolicy(int displayId) {
            return this.this$0.getDisplayImePolicy(displayId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void addRefreshRateRangeForPackage(final String packageName, final float minRefreshRate, final float maxRefreshRate) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRoot.forAllDisplays(new WindowManagerService$LocalService$$ExternalSyntheticLambda1(packageName, minRefreshRate, maxRefreshRate));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private static /* synthetic */ void lambda$addRefreshRateRangeForPackage$2(String packageName, float minRefreshRate, float maxRefreshRate, DisplayContent dc) {
            dc.getDisplayPolicy().getRefreshRatePolicy().addRefreshRateRangeForPackage(packageName, minRefreshRate, maxRefreshRate);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void removeRefreshRateRangeForPackage(final String packageName) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.mRoot.forAllDisplays(new WindowManagerService$LocalService$$ExternalSyntheticLambda3(packageName));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private static /* synthetic */ void lambda$removeRefreshRateRangeForPackage$3(String packageName, DisplayContent dc) {
            dc.getDisplayPolicy().getRefreshRatePolicy().removeRefreshRateRangeForPackage(packageName);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isTouchOrFaketouchDevice() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L11:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (this.this$0.mIsTouchDevice == false) goto L13;
            if (this.this$0.mIsFakeTouchDevice == true) goto L13;
            throw new IllegalStateException("touchscreen supported device must report faketouch.");     // Catch: Throwable -> L11
        L13:
            boolean r1 = this.this$0.mIsFakeTouchDevice;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            WindowManagerService.resetPriorityAfterLockedSection();
            return r1;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public KeyInterceptionInfo getKeyInterceptionInfoFromToken(IBinder inputToken) {
            return this.this$0.mKeyInterceptionInfoForToken.get(inputToken);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setAccessibilityIdToSurfaceMetadata(IBinder windowToken, int accessibilityWindowId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState state = this.this$0.mWindowMap.get(windowToken);     // Catch: Throwable -> L10
            if (state != null) goto L12;
            Slog.w(WindowManagerService.TAG, "Cannot find window which accessibility connection is added to");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L12:
            WindowManagerService.m10426$$Nest$fgetmTransaction(this.this$0).setMetadata(state.mSurfaceControl, 5, accessibilityWindowId).apply();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public String getWindowName(IBinder binder) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState w = this.this$0.mWindowMap.get(binder);     // Catch: Throwable -> L7
            if (w == null) goto L9;
            String r2 = w.getName();     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L9:
            r2 = null;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public WindowManagerInternal.ImeTargetInfo onToggleImeRequested(boolean show, IBinder focusedToken, IBinder requestToken, int displayId) {
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            WindowState focusedWin = this.this$0.mWindowMap.get(focusedToken);     // Catch: Throwable -> L9
            if (focusedWin == null) goto L12;
            String r4 = focusedWin.getName();     // Catch: Throwable -> L9
        L13:
            String focusedWindowName = r4;
            WindowState requestWin = this.this$0.mWindowMap.get(requestToken);     // Catch: Throwable -> L19
            if (requestWin == null) goto L21;
            String r5 = requestWin.getName();     // Catch: Throwable -> L19
        L18:
            String requestWindowName = r5;
            DisplayContent dc = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L31
            if (dc == null) goto L48;
            InsetsControlTarget controlTarget = dc.getImeTarget(2);     // Catch: Throwable -> L31
            if (controlTarget == null) goto L35;
            WindowState w = InsetsControlTarget.asWindowOrNull(controlTarget);     // Catch: Throwable -> L31
            if (w == null) goto L33;
            String imeControlTargetName = w.getName();     // Catch: Throwable -> L31
        L36:
            InsetsControlTarget target = dc.getImeTarget(0);     // Catch: Throwable -> L31
            if (target == null) goto L39;
            String imeLayerTargetName = target.getWindow().getName();     // Catch: Throwable -> L31
        L40:
            SurfaceControl imeParent = dc.mInputMethodSurfaceParent;     // Catch: Throwable -> L31
            if (imeParent == null) goto L43;
            String imeSurfaceParentName = imeParent.toString();     // Catch: Throwable -> L31
        L45:
            if (show == false) goto L47;
            dc.onShowImeRequested();     // Catch: Throwable -> L31
        L47:
            String imeControlTargetName2 = imeControlTargetName;
            String imeLayerTargetName2 = imeLayerTargetName;
            String imeControlTargetName3 = imeSurfaceParentName;
        L49:
            monitor-exit(r2);     // Catch: Throwable -> L31
            WindowManagerService.resetPriorityAfterLockedSection();
            return new WindowManagerInternal.ImeTargetInfo(focusedWindowName, requestWindowName, imeControlTargetName2, imeLayerTargetName2, imeControlTargetName3);
        L43:
            imeSurfaceParentName = "null";
            goto L45
        L39:
            imeLayerTargetName = "null";
            goto L40
        L33:
            imeControlTargetName = controlTarget.toString();     // Catch: Throwable -> L31
            goto L36
        L35:
            imeControlTargetName = "null";
            goto L36
        L48:
            imeControlTargetName2 = "no-display";
            imeLayerTargetName2 = "no-display";
            imeControlTargetName3 = "no-display";
            goto L49
        L21:
            r5 = "null";
        L19:
            th = th;
        L54:
            monitor-exit(r2);     // Catch: Throwable -> L31
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L12:
            r4 = "null";
        L9:
            th = th;
        L52:
            th = th;
        L31:
            th = th;
            goto L54
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean shouldRestoreImeVisibility(IBinder imeTargetWindowToken) {
            return this.this$0.shouldRestoreImeVisibility(imeTargetWindowToken);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void addTrustedTaskOverlay(int taskId, SurfaceControlViewHost.SurfacePackage overlay) {
            if (overlay == null) goto L25;
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L15:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L6:
            if (overlay.getSurfaceControl() == null) goto L20;
            if (overlay.getSurfaceControl().isValid() == false) goto L20;
            Task task = this.this$0.mRoot.getRootTask(taskId);     // Catch: Throwable -> L15
            if (task == null) goto L18;
            task.addTrustedOverlay(overlay, task.getTopVisibleAppMainWindow());     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L18:
            throw new IllegalArgumentException("no task with taskId" + taskId);     // Catch: Throwable -> L15
        L20:
            throw new IllegalArgumentException("Invalid overlay surfacecontrol passed in for task=" + taskId);     // Catch: Throwable -> L15
        L25:
            throw new IllegalArgumentException("Invalid overlay passed in for task=" + taskId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void removeTrustedTaskOverlay(int taskId, SurfaceControlViewHost.SurfacePackage overlay) {
            if (overlay == null) goto L25;
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L15:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L6:
            if (overlay.getSurfaceControl() == null) goto L20;
            if (overlay.getSurfaceControl().isValid() == false) goto L20;
            Task task = this.this$0.mRoot.getRootTask(taskId);     // Catch: Throwable -> L15
            if (task == null) goto L18;
            task.removeTrustedOverlay(overlay);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L18:
            throw new IllegalArgumentException("no task with taskId" + taskId);     // Catch: Throwable -> L15
        L20:
            throw new IllegalArgumentException("Invalid overlay surfacecontrol passed in for task=" + taskId);     // Catch: Throwable -> L15
        L25:
            throw new IllegalArgumentException("Invalid overlay passed in for task=" + taskId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public SurfaceControl getHandwritingSurfaceForDisplay(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            DisplayContent dc = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
            if (dc != null) goto L12;
            Slog.e(WindowManagerService.TAG, "Failed to create a handwriting surface on display: " + displayId + " - DisplayContent not found.");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L12:
            SurfaceControl inputOverlay = dc.getInputOverlayLayer();     // Catch: Throwable -> L10
            if (inputOverlay != null) goto L18;
            Slog.e(WindowManagerService.TAG, "Failed to create a gesture monitor on display: " + displayId + " - Input overlay layer is not initialized.");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L18:
            SurfaceControl r2 = this.this$0.makeSurfaceBuilder().setContainerLayer().setName("IME Handwriting Surface").setCallsite("getHandwritingSurfaceForDisplay").setParent(inputOverlay).build();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean isPointInsideWindow(IBinder windowToken, int displayId, float displayX, float displayY) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowState w = this.this$0.mWindowMap.get(windowToken);     // Catch: Throwable -> L13
            if (w == null) goto L15;
            if (w.getDisplayId() != displayId) goto L15;
            boolean r2 = w.getBounds().contains((int) displayX, (int) displayY);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L13:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean setContentRecordingSession(ContentRecordingSession incomingSession) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            if (incomingSession != null) goto L28;
        L21:
            this.this$0.mContentRecordingController.setContentRecordingSessionLocked(incomingSession, this.this$0);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            WindowManagerService.resetPriorityAfterLockedSection();
            return true;
        L28:
        L15:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L7:
            if (incomingSession.getContentToRecord() != 1) goto L21;
            WindowContainerInfo wci = this.this$0.getTaskWindowContainerInfoForRecordingSession(incomingSession);     // Catch: Throwable -> L15
            if (wci != null) goto L17;
            Slog.w(WindowManagerService.TAG, "Handling a new recording session; unable to find the WindowContainerToken");     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L17:
            incomingSession.setTokenToRecord(wci.getToken().asBinder());     // Catch: Throwable -> L15
            incomingSession.setTargetUid(wci.getUid());     // Catch: Throwable -> L15
            this.this$0.mContentRecordingController.setContentRecordingSessionLocked(incomingSession, this.this$0);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            WindowManagerService.resetPriorityAfterLockedSection();
            return true;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public SurfaceControl getA11yOverlayLayer(int displayId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            DisplayContent dc = this.this$0.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
            if (dc == null) goto L13;
            SurfaceControl r2 = dc.getA11yOverlayLayer();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return null;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void captureDisplay(int displayId, ScreenCapture.CaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener listener) {
            this.this$0.captureDisplay(displayId, captureArgs, listener);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean hasNavigationBar(int displayId) {
            return this.this$0.hasNavigationBar(displayId);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setOrientationRequestPolicy(boolean respected, int[] fromOrientations, int[] toOrientations) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.setOrientationRequestPolicy(respected, fromOrientations, toOrientations);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public IBinder getTargetWindowTokenFromInputToken(IBinder inputToken) {
            InputTarget inputTarget = this.this$0.getInputTargetFromToken(inputToken);
            if (inputTarget != null) goto L6;
            return null;
        L6:
            return inputTarget.getWindowToken();
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setBlockScreenCaptureForAppsSessionId(long sessionId) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (WindowManagerService.m10425$$Nest$fgetmSensitiveContentProtectionSessionId(this.this$0) == sessionId) goto L9;
            WindowManagerService.m10432$$Nest$fputmSensitiveContentProtectionSessionId(this.this$0, sessionId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void addBlockScreenCaptureForApps(ArraySet<SensitiveContentPackages.PackageInfo> packageInfos) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean modified = this.this$0.mSensitiveContentPackages.addBlockScreenCaptureForApps(packageInfos);     // Catch: Throwable -> L7
            if (modified == false) goto L9;
            this.this$0.refreshScreenCaptureDisabled();     // Catch: Throwable -> L7
            this.this$0.mRoot.forAllWindows(new WindowManagerService$LocalService$$ExternalSyntheticLambda5(this), true);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private /* synthetic */ void lambda$addBlockScreenCaptureForApps$5(WindowState w) {
            if (w.isVisible() == false) goto L6;
            WindowManagerService.m10447$$Nest$mshowToastIfBlockingScreenCapture(this.this$0, w);
            return;
        L6:
            if (shouldInvalidateSnapshot(w) == false) goto L14;
            Task task = w.getTask();
            ActivityRecord baseActivity = task.getActivity(new WindowManagerService$LocalService$$ExternalSyntheticLambda6(), false);
            if (baseActivity == null) goto L10;
            int baseActivityUid = baseActivity.getUid();
        L11:
            this.this$0.mTaskSnapshotController.removeAndDeleteSnapshot(task.mTaskId, task.mUserId, baseActivityUid);
            task.onSnapshotInvalidated();
            return;
        L10:
            baseActivityUid = task.effectiveUid;
            goto L11
        }

        private static /* synthetic */ boolean lambda$addBlockScreenCaptureForApps$4(ActivityRecord r) {
            return !r.finishing;
        }

        private boolean shouldInvalidateSnapshot(WindowState w) {
            if (w == null) goto L13;
            if (w.getDisplayInfo() == null) goto L13;
            if (ActivityStarterHook.CAR_DISPLAY_NAME2.equals(w.getDisplayInfo().name) == false) goto L9;
        L10:
            Slog.d(WindowManagerService.TAG, "this is car play, so validate Snapshot");
            return false;
        L9:
            if (ActivityStarterHook.CAR_DISPLAY_NAME.equals(w.getDisplayInfo().name) == true) goto L10;
        L13:
            if (w.getTask() != null) goto L15;
            return false;
        L15:
            if (this.this$0.mSensitiveContentPackages.shouldBlockScreenCaptureForApp(w.getOwningPackage(), w.getOwningUid(), w.getWindowToken()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void removeBlockScreenCaptureForApps(ArraySet<SensitiveContentPackages.PackageInfo> packageInfos) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean modified = this.this$0.mSensitiveContentPackages.removeBlockScreenCaptureForApps(packageInfos);     // Catch: Throwable -> L7
            if (modified == false) goto L9;
            this.this$0.refreshScreenCaptureDisabled();     // Catch: Throwable -> L7
        L9:
            int i = 0;
        L11:
            if (i >= packageInfos.size()) goto L16;
            int uid = packageInfos.valueAt(i).getUid();     // Catch: Throwable -> L7
            if (WindowManagerService.m10420$$Nest$fgetmCaptureBlockedToastShownUids(this.this$0).contains(uid) == false) goto L15;
            WindowManagerService.m10420$$Nest$fgetmCaptureBlockedToastShownUids(this.this$0).remove(WindowManagerService.m10420$$Nest$fgetmCaptureBlockedToastShownUids(this.this$0).indexOf(uid));     // Catch: Throwable -> L7
        L15:
            i = i + 1;     // Catch: Throwable -> L7
            goto L11
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void clearBlockedApps() {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean modified = this.this$0.mSensitiveContentPackages.clearBlockedApps();     // Catch: Throwable -> L7
            if (modified == false) goto L9;
            this.this$0.refreshScreenCaptureDisabled();     // Catch: Throwable -> L7
        L9:
            WindowManagerService.m10420$$Nest$fgetmCaptureBlockedToastShownUids(this.this$0).clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void registerWindowFocusChangeListener(WindowManagerInternal.WindowFocusChangeListener listener) {
            this.this$0.addWindowFocusChangeListener(listener);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void unregisterWindowFocusChangeListener(WindowManagerInternal.WindowFocusChangeListener listener) {
            this.this$0.removeWindowFocusChangeListener(listener);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void registerOnWindowRemovedListener(WindowManagerInternal.OnWindowRemovedListener listener) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowManagerService.m10424$$Nest$fgetmOnWindowRemovedListeners(this.this$0).add(listener);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void unregisterOnWindowRemovedListener(WindowManagerInternal.OnWindowRemovedListener listener) {
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowManagerService.m10424$$Nest$fgetmOnWindowRemovedListeners(this.this$0).remove(listener);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public boolean moveFocusToAdjacentEmbeddedActivityIfNeeded() {
            boolean focusMoved = false;
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            WindowState focusedWindow = WindowManagerService.m10439$$Nest$mgetFocusedWindow(this.this$0);     // Catch: Throwable -> L9
            if (focusedWindow != null) goto L12;
            monitor-exit(r1);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return false;
        L12:
            if (this.this$0.moveFocusToAdjacentEmbeddedWindow(focusedWindow) == false) goto L14;
            focusMoved = true;
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            if (focusMoved == false) goto L18;
            this.this$0.syncInputTransactions(false);
        L18:
            return focusMoved;
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public ScreenCapture.ScreenshotHardwareBuffer takeAssistScreenshot() {
            return WindowManagerService.m10448$$Nest$mtakeAssistScreenshot(this.this$0, null);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public ScreenCapture.ScreenshotHardwareBuffer takeContextualSearchScreenshot(final int uid) {
            return WindowManagerService.m10448$$Nest$mtakeAssistScreenshot(this.this$0, new WindowManagerService$LocalService$$ExternalSyntheticLambda2(uid));
        }

        private static /* synthetic */ boolean lambda$takeContextualSearchScreenshot$6(int uid, WindowState win) {
            switch(win.getWindowType()) {
                case 2000: goto L9;
                case 2018: goto L9;
                case 2019: goto L9;
                case 2024: goto L9;
                case 2038: goto L6;
                default: goto L4;
            };
        L4:
            return true;
        L9:
            return false;
        L6:
            if (uid != win.getOwningUid()) goto L8;
            return false;
        L8:
            return true;
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public void setResolutionScaleByPkgName(String pkgName, float scale) {
            this.this$0.getExt().setResolutionScaleByPkgName(pkgName, scale);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public float getResolutionScaleByToken(IBinder windowToken) {
            return this.this$0.getExt().getResolutionScaleByToken(windowToken);
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public ExtWindowManagerInternal getInternalExt() {
            return this.this$0.getExt().getLocalService();
        }

        @Override // com.android.server.wm.WindowManagerInternal
        public IObricWindowManagerInternal getObricWindowManagerInternal() {
            return WindowManagerService.m10423$$Nest$fgetmObricExt(this.this$0).getLocalService();
        }
    }

    final class SettingsObserver extends ContentObserver {
        private final Uri mAnimationDurationScaleUri;
        private final Uri mDevEnableNonResizableMultiWindowUri;
        private final Uri mDevelopmentOverrideDesktopExperienceUri;
        private final Uri mDisableSecureWindowsUri;
        private final Uri mDisplayInversionEnabledUri;
        private final Uri mDisplaySettingsPathUri;
        private final Uri mForceDesktopModeOnExternalDisplaysUri;
        private final Uri mForceResizableUri;
        private final Uri mFreeformWindowUri;
        private final Uri mImmersiveModeConfirmationsUri;
        private final Uri mMaximumObscuringOpacityForTouchUri;
        private final Uri mPolicyControlUri;
        private final Uri mReverseTransitionEnabledUri;
        private final Uri mTransitionAnimationScaleUri;
        private final Uri mWindowAnimationScaleUri;
        final /* synthetic */ WindowManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$RRs-_oANo_9P6n2JjOZNjIz6nas, reason: not valid java name */
        public static /* synthetic */ void m10456$r8$lambda$RRs_oANo_9P6n2JjOZNjIz6nas(SettingsObserver r0, DisplayContent r1) {
            r0.lambda$updateDisplaySettingsLocation$0(r1);
        }

        public SettingsObserver(WindowManagerService this$0) {
            this.this$0 = this$0;
            super(new Handler());
            this.mDisplayInversionEnabledUri = Settings.Secure.getUriFor("accessibility_display_inversion_enabled");
            this.mWindowAnimationScaleUri = Settings.Global.getUriFor("window_animation_scale");
            this.mTransitionAnimationScaleUri = Settings.Global.getUriFor("transition_animation_scale");
            this.mAnimationDurationScaleUri = Settings.Global.getUriFor("animator_duration_scale");
            this.mImmersiveModeConfirmationsUri = Settings.Secure.getUriFor("immersive_mode_confirmations");
            this.mDisableSecureWindowsUri = Settings.Secure.getUriFor("disable_secure_windows");
            this.mPolicyControlUri = Settings.Global.getUriFor("policy_control");
            this.mForceDesktopModeOnExternalDisplaysUri = Settings.Global.getUriFor("force_desktop_mode_on_external_displays");
            this.mFreeformWindowUri = Settings.Global.getUriFor("enable_freeform_support");
            this.mForceResizableUri = Settings.Global.getUriFor("force_resizable_activities");
            this.mDevEnableNonResizableMultiWindowUri = Settings.Global.getUriFor("enable_non_resizable_multi_window");
            this.mDisplaySettingsPathUri = Settings.Global.getUriFor("wm_display_settings_path");
            this.mMaximumObscuringOpacityForTouchUri = Settings.Global.getUriFor("maximum_obscuring_opacity_for_touch");
            this.mDevelopmentOverrideDesktopExperienceUri = Settings.Global.getUriFor("override_desktop_experience_features");
            this.mReverseTransitionEnabledUri = Settings.System.getUriFor("obric_interrupt_animations");
            ContentResolver resolver = this$0.mContext.getContentResolver();
            resolver.registerContentObserver(this.mDisplayInversionEnabledUri, false, this, -1);
            resolver.registerContentObserver(this.mWindowAnimationScaleUri, false, this, -1);
            resolver.registerContentObserver(this.mTransitionAnimationScaleUri, false, this, -1);
            resolver.registerContentObserver(this.mAnimationDurationScaleUri, false, this, -1);
            resolver.registerContentObserver(this.mImmersiveModeConfirmationsUri, false, this, -1);
            resolver.registerContentObserver(this.mDisableSecureWindowsUri, false, this, -1);
            resolver.registerContentObserver(this.mPolicyControlUri, false, this, -1);
            resolver.registerContentObserver(this.mForceDesktopModeOnExternalDisplaysUri, false, this, -1);
            resolver.registerContentObserver(this.mFreeformWindowUri, false, this, -1);
            resolver.registerContentObserver(this.mForceResizableUri, false, this, -1);
            resolver.registerContentObserver(this.mDevEnableNonResizableMultiWindowUri, false, this, -1);
            resolver.registerContentObserver(this.mDisplaySettingsPathUri, false, this, -1);
            resolver.registerContentObserver(this.mMaximumObscuringOpacityForTouchUri, false, this, -1);
            resolver.registerContentObserver(this.mDevelopmentOverrideDesktopExperienceUri, false, this, -1);
            resolver.registerContentObserver(this.mReverseTransitionEnabledUri, false, this, -1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (uri != null) goto L5;
            return;
        L5:
            if (this.mForceDesktopModeOnExternalDisplaysUri.equals(uri) == false) goto L9;
            updateForceDesktopModeOnExternalDisplays();
            return;
        L9:
            if (this.mFreeformWindowUri.equals(uri) == false) goto L13;
            updateFreeformWindowManagement();
            return;
        L13:
            if (this.mForceResizableUri.equals(uri) == false) goto L17;
            updateForceResizableTasks();
            return;
        L17:
            if (this.mDevEnableNonResizableMultiWindowUri.equals(uri) == false) goto L21;
            updateDevEnableNonResizableMultiWindow();
            return;
        L21:
            if (this.mDisplaySettingsPathUri.equals(uri) == false) goto L25;
            updateDisplaySettingsLocation();
            return;
        L25:
            if (this.mMaximumObscuringOpacityForTouchUri.equals(uri) == false) goto L29;
            updateMaximumObscuringOpacityForTouch();
            return;
        L29:
            if (this.mDisableSecureWindowsUri.equals(uri) == false) goto L33;
            updateDisableSecureWindows();
            return;
        L33:
            if (this.mDevelopmentOverrideDesktopExperienceUri.equals(uri) == false) goto L37;
            updateDevelopmentOverrideDesktopExperience();
            return;
        L37:
            if (this.mReverseTransitionEnabledUri.equals(uri) == false) goto L41;
            this.this$0.getExt().updateReverseTransitionEnabled(this.this$0.mContext);
            return;
        L41:
            if (this.mWindowAnimationScaleUri.equals(uri) == false) goto L44;
            int mode = 0;
        L49:
            Message m = this.this$0.mH.obtainMessage(51, mode, 0);
            this.this$0.mH.sendMessage(m);
            return;
        L44:
            if (this.mTransitionAnimationScaleUri.equals(uri) == false) goto L47;
            mode = 1;
            goto L49
        L47:
            if (this.mAnimationDurationScaleUri.equals(uri) == false) goto L51;
            mode = 2;
            goto L49
        }

        void loadSettings() {
            updateMaximumObscuringOpacityForTouch();
            updateDisableSecureWindows();
        }

        void updateMaximumObscuringOpacityForTouch() {
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            WindowManagerService r1 = this.this$0;
            r1.mMaximumObscuringOpacityForTouch = Settings.Global.getFloat(resolver, "maximum_obscuring_opacity_for_touch", 0.8f);
            if (this.this$0.mMaximumObscuringOpacityForTouch >= 0.0f) goto L5;
        L6:
            this.this$0.mMaximumObscuringOpacityForTouch = 0.8f;
            return;
        L5:
            if (this.this$0.mMaximumObscuringOpacityForTouch > 1.0f) goto L6;
        }

        void updateForceDesktopModeOnExternalDisplays() {
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            boolean enableForceDesktopMode = false;
            if (Settings.Global.getInt(resolver, "force_desktop_mode_on_external_displays", 0) == 0) goto L6;
            enableForceDesktopMode = true;
        L6:
            if (this.this$0.mForceDesktopModeOnExternalDisplays != enableForceDesktopMode) goto L8;
            return;
        L8:
            this.this$0.setForceDesktopModeOnExternalDisplays(enableForceDesktopMode);
        }

        void updateFreeformWindowManagement() {
            if (Features.FEAT_QUICK_WIN == false) goto L5;
            return;
        L5:
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            if (this.this$0.mContext.getPackageManager().hasSystemFeature("android.software.freeform_window_management") == true) goto L9;
            boolean freeformWindowManagement = false;
            if (Settings.Global.getInt(resolver, "enable_freeform_support", 0) != 0) goto L9;
        L11:
            if (this.this$0.mAtmService.mSupportsFreeformWindowManagement == freeformWindowManagement) goto L21;
            this.this$0.mAtmService.mSupportsFreeformWindowManagement = freeformWindowManagement;
            WindowManagerGlobalLock r1 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            this.this$0.mRoot.onSettingsRetrieved();     // Catch: Throwable -> L17
            monitor-exit(r1);     // Catch: Throwable -> L17
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L17:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L21:
            return;
        L9:
            freeformWindowManagement = true;
            goto L11
        }

        void updateForceResizableTasks() {
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            boolean forceResizable = false;
            if (Settings.Global.getInt(resolver, "force_resizable_activities", 0) == 0) goto L5;
            forceResizable = true;
        L5:
            this.this$0.mAtmService.mForceResizableActivities = forceResizable;
        }

        void updateDevelopmentOverrideDesktopExperience() {
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            int overrideDesktopMode = Settings.Global.getInt(resolver, "override_desktop_experience_features", DesktopModeFlags.ToggleOverride.OVERRIDE_UNSET.getSetting());
            SystemProperties.set("persist.wm.debug.desktop_experience_devopts", Integer.toString(overrideDesktopMode));
        }

        void updateDevEnableNonResizableMultiWindow() {
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            boolean devEnableNonResizableMultiWindow = false;
            if (Settings.Global.getInt(resolver, "enable_non_resizable_multi_window", 0) == 0) goto L5;
            devEnableNonResizableMultiWindow = true;
        L5:
            this.this$0.mAtmService.mDevEnableNonResizableMultiWindow = devEnableNonResizableMultiWindow;
        }

        void updateDisplaySettingsLocation() {
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            String filePath = Settings.Global.getString(resolver, "wm_display_settings_path");
            WindowManagerGlobalLock r2 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            this.this$0.mDisplayWindowSettingsProvider.setBaseSettingsFilePath(filePath);     // Catch: Throwable -> L8
            this.this$0.mRoot.forAllDisplays(new WindowManagerService$SettingsObserver$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private /* synthetic */ void lambda$updateDisplaySettingsLocation$0(DisplayContent display) {
            this.this$0.mDisplayWindowSettings.applySettingsToDisplayLocked(display);
            display.reconfigureDisplayLocked();
        }

        void updateDisableSecureWindows() {
            boolean disableSecureWindows = false;
            if (SystemProperties.getBoolean(WindowManagerService.SYSTEM_DEBUGGABLE, false) == true) goto L26;
            return;
        L26:
            if (Settings.Secure.getIntForUser(this.this$0.mContext.getContentResolver(), "disable_secure_windows", 0) == 0) goto L12;
            disableSecureWindows = true;
        L12:
            if (WindowManagerService.m10421$$Nest$fgetmDisableSecureWindows(this.this$0) != disableSecureWindows) goto L14;
            return;
        L14:
            WindowManagerGlobalLock r0 = this.this$0.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            WindowManagerService.m10431$$Nest$fputmDisableSecureWindows(this.this$0, disableSecureWindows);     // Catch: Throwable -> L20
            this.this$0.mRoot.refreshSecureSurfaceState();     // Catch: Throwable -> L20
            monitor-exit(r0);     // Catch: Throwable -> L20
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L20:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L10:
            disableSecureWindows = false;
            goto L12
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface UpdateAnimationScaleMode {
    }

    interface WindowChangeListener {
        void windowsChanged();
    }

    static class WindowContainerInfo {
        private final WindowContainerToken mToken;
        private final int mUid;

        /* synthetic */ WindowContainerInfo(int r1, WindowContainerToken r2, WindowManagerServiceIA r3) {
            this(r1, r2);
        }

        private WindowContainerInfo(int uid, WindowContainerToken token) {
            this.mUid = uid;
            this.mToken = token;
        }

        public int getUid() {
            return this.mUid;
        }

        public WindowContainerToken getToken() {
            return this.mToken;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-bQ6CmQAuiq_gUo93BGmDKXFdYM, reason: not valid java name */
    public static /* synthetic */ void m10406$r8$lambda$bQ6CmQAuiq_gUo93BGmDKXFdYM(WindowToken r0, SurfaceControl.Transaction r1) {
        lambda$hideUntilNextDraw$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$0aE1bUQ5UezvnmZanVzH9Ud1ZkE(WindowManagerService[] r0, Context r1, InputManagerService r2, boolean r3, WindowManagerPolicy r4, ActivityTaskManagerService r5, DisplayWindowSettingsProvider r6, Supplier r7, Supplier r8, AppCompatConfiguration r9) {
        lambda$main$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: $r8$lambda$2VnAF-EPqcH09BitQpbkgYnbPy8, reason: not valid java name */
    public static /* synthetic */ boolean m10407$r8$lambda$2VnAFEPqcH09BitQpbkgYnbPy8(int r0, WindowState r1) {
        return lambda$findWindow$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$4l8QvCle_k2xjtV0u-T_n-dnyHo, reason: not valid java name */
    public static /* synthetic */ void m10408$r8$lambda$4l8QvCle_k2xjtV0uT_ndnyHo(long[] r0, ActivityRecord[] r1, TaskFragment r2) {
        lambda$getMostRecentActivityInAdjacent$28(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$7Ck9ccqzI1JOkNOJjSgqYK9ftE4(WindowManagerService r0, InputTarget r1, InputTarget r2) {
        r0.lambda$onPointerDownOutsideFocusLocked$25(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$9J1ItkHbsJZb1AAGVWR8INKKU_s(WindowManagerService r0, WindowState r1) {
        r0.lambda$forceReportResizing$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$9eEBd0j0RK3nzv2mtAM6ROSGw8g(WindowManagerService r0) {
        r0.lambda$dispatchKeyguardLockedState$6();
    }

    /* JADX INFO: renamed from: $r8$lambda$9y0QewHWWZnSHyA7GVLdQ-FtzN0, reason: not valid java name */
    public static /* synthetic */ void m10409$r8$lambda$9y0QewHWWZnSHyA7GVLdQFtzN0(SurfaceControl.Transaction r0, DisplayContent r1) {
        lambda$syncInputTransactions$23(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$AW70L7q4wp_lQ36-dfG0vx9T_h4, reason: not valid java name */
    public static /* synthetic */ void m10410$r8$lambda$AW70L7q4wp_lQ36dfG0vx9T_h4(WindowState r0, ActivityRecord r1, ArrayList r2, WindowState r3) {
        lambda$saveANRStateLocked$18(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$B72vG03GVIHFv6VYlXbm0sTT5Ok(WindowManagerService r0) {
        r0.lambda$showToastIfBlockingScreenCapture$32();
    }

    public static /* synthetic */ void $r8$lambda$EQU6HbEko3rd2tEgmQCMa1ATEaw(WindowManagerInternal.OnWindowRemovedListener[] r0, IBinder r1) {
        lambda$notifyWindowRemovedListeners$11(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$InMiiAcTfqszFgrEO-yJv4BzyiI, reason: not valid java name */
    public static /* synthetic */ void m10411$r8$lambda$InMiiAcTfqszFgrEOyJv4BzyiI(PrintWriter r0, FileDescriptor r1, long r2, WindowState r4) {
        lambda$dumpVisibleWindowClients$34(r0, r1, r2, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$IxwdlwAMhqsvZHSnzWieHJ1VHIs(int r0, Task r1) {
        return lambda$getTaskWindowContainerInfoForRecordingSession$27(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$JXZ7Q_t2GjRTWMgPucgME7Xizjk(TaskFragment[] r0, TaskFragment r1) {
        return lambda$moveFocusToAdjacentWindow$29(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$MESHWCtvvLcPaaDK_9W5cfDCSRI(Task r0) {
        return lambda$setRecentsAppBehindSystemBars$30(r0);
    }

    public static /* synthetic */ void $r8$lambda$My32_uOs8xwhiOo8fGetm9I3eKo(IAssistDataReceiver r0, Bitmap r1) {
        lambda$requestAssistScreenshot$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$NEd8kAeChwGMQgvqzY2s5N7ej8A(DisplayContent r0) {
        lambda$onOverlayChanged$20(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$PHV_yqBoVbu_MXrV1i9czawVFvc(IBinder r0, ActivityRecord r1) {
        return lambda$getTaskWindowContainerInfoForRecordingSession$26(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$SEfvk2QvJpokKeRXepp0JNhkK2Y(PrintWriter r0, TaskDisplayArea r1) {
        lambda$saveANRStateLocked$17(r0, r1);
    }

    public static /* synthetic */ SurfaceControl $r8$lambda$V0mclAyV10Fp_iT31miErRplJGE(WindowManagerService r0, int r1) {
        return r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Y1szv9-7pauCndCM8P5pWlJajbA, reason: not valid java name */
    public static /* synthetic */ void m10412$r8$lambda$Y1szv97pauCndCM8P5pWlJajbA(PrintWriter r0, WindowContainer r1, Message r2) {
        lambda$dumpWindowsLocked$14(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZR-LMxopMcDzrng8JJEIcBlhvuc, reason: not valid java name */
    public static /* synthetic */ void m10413$r8$lambda$ZRLMxopMcDzrng8JJEIcBlhvuc(WindowManagerService r0, WindowState r1) {
        r0.lambda$updateNonSystemOverlayWindowsVisibilityIfNeeded$22(r1);
    }

    public static /* synthetic */ void $r8$lambda$fnMYXeJTKwwWfDPtZm0aGPWAl0I(boolean r0, WindowState r1) {
        lambda$dispatchScreenRecordingState$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$kbWlQpeEfICAZv0W88KCG2Prvrk(ArrayList r0, WindowState r1) {
        lambda$dumpVisibleWindowClients$33(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$n5TcFl6HuYIczvg5dIZKT3gOFZw(ArraySet r0, ActivityRecord r1) {
        lambda$notifyScreenshotListeners$31(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$oO5bgww2SiOCuie183T3Xu-2gsU, reason: not valid java name */
    public static /* synthetic */ void m10414$r8$lambda$oO5bgww2SiOCuie183T3Xu2gsU(IBinder r0, boolean r1, int r2) {
        lambda$dispatchImeInputTargetVisibilityChanged$8(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$qzQYVv9ltHGERKtofgbqAGFlNaQ(boolean r0, DisplayPolicy r1) {
        lambda$onPowerKeyDown$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$sA-Y3_D_70aW1I0H-5RhTgIguXQ, reason: not valid java name */
    public static /* synthetic */ void m10415$r8$lambda$sAY3_D_70aW1I0H5RhTgIguXQ(boolean r0, int r1) {
        lambda$dispatchImeTargetOverlayVisibilityChanged$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$tJYwIUYeZtkiUBr6A45xZ6MYG5U(PrintWriter r0, WindowState r1) {
        lambda$doDump$19(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tl8D-4b-NG-OCtKKVqEC1O4LACo, reason: not valid java name */
    public static /* synthetic */ void m10416$r8$lambda$tl8D4bNGOCtKKVqEC1O4LACo(boolean r0, boolean r1, ArrayList r2, WindowState r3) {
        lambda$dumpWindows$16(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$tyfF32m6_OJWPjfTlD_E_gpc3eo(WindowManagerService r0, DisplayContent r1) {
        r0.lambda$displayReady$13(r1);
    }

    public static /* synthetic */ void $r8$lambda$v25XvOTPKD8YzF4cXE0xCy3h0vI(PrintWriter r0, DisplayContent r1) {
        lambda$dumpWindowsLocked$15(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$wHVFVbv8unljaEad-KtMsNwhP1g, reason: not valid java name */
    public static /* synthetic */ void m10417$r8$lambda$wHVFVbv8unljaEadKtMsNwhP1g(ArrayList r0, WindowState r1) {
        lambda$viewServerListWindows$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xzelAtadYwjrv5onYZq07nxkC3E(WindowManagerService r0, InputTarget r1, InputTarget r2) {
        r0.lambda$onPointerDownOutsideFocusLocked$24(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$z8mRbZ0vJxlM8_OStZi36vRvzVI(WindowManagerService r0) {
        r0.lambda$onOverlayChanged$21();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAnimationsDisabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10418$$Nest$fgetmAnimationsDisabled(WindowManagerService r0) {
        return r0.mAnimationsDisabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAnimatorDurationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10419$$Nest$fgetmAnimatorDurationScaleSetting(WindowManagerService r0) {
        return r0.mAnimatorDurationScaleSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCaptureBlockedToastShownUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntArray m10420$$Nest$fgetmCaptureBlockedToastShownUids(WindowManagerService r0) {
        return r0.mCaptureBlockedToastShownUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisableSecureWindows, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10421$$Nest$fgetmDisableSecureWindows(WindowManagerService r0) {
        return r0.mDisableSecureWindows;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardDisableHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyguardDisableHandler m10422$$Nest$fgetmKeyguardDisableHandler(WindowManagerService r0) {
        return r0.mKeyguardDisableHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObricExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IObricWindowManagerService m10423$$Nest$fgetmObricExt(WindowManagerService r0) {
        return r0.mObricExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnWindowRemovedListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m10424$$Nest$fgetmOnWindowRemovedListeners(WindowManagerService r0) {
        return r0.mOnWindowRemovedListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensitiveContentProtectionSessionId, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m10425$$Nest$fgetmSensitiveContentProtectionSessionId(WindowManagerService r2) {
        return r2.mSensitiveContentProtectionSessionId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTransaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ SurfaceControl.Transaction m10426$$Nest$fgetmTransaction(WindowManagerService r0) {
        return r0.mTransaction;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTransitionAnimationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10427$$Nest$fgetmTransitionAnimationScaleSetting(WindowManagerService r0) {
        return r0.mTransitionAnimationScaleSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowAnimationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10428$$Nest$fgetmWindowAnimationScaleSetting(WindowManagerService r0) {
        return r0.mWindowAnimationScaleSetting;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAnimationsDisabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10429$$Nest$fputmAnimationsDisabled(WindowManagerService r0, boolean r1) {
        r0.mAnimationsDisabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAnimatorDurationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10430$$Nest$fputmAnimatorDurationScaleSetting(WindowManagerService r0, float r1) {
        r0.mAnimatorDurationScaleSetting = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisableSecureWindows, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10431$$Nest$fputmDisableSecureWindows(WindowManagerService r0, boolean r1) {
        r0.mDisableSecureWindows = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSensitiveContentProtectionSessionId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10432$$Nest$fputmSensitiveContentProtectionSessionId(WindowManagerService r0, long r1) {
        r0.mSensitiveContentProtectionSessionId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTransitionAnimationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10433$$Nest$fputmTransitionAnimationScaleSetting(WindowManagerService r0, float r1) {
        r0.mTransitionAnimationScaleSetting = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWindowAnimationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10434$$Nest$fputmWindowAnimationScaleSetting(WindowManagerService r0, float r1) {
        r0.mWindowAnimationScaleSetting = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckBootAnimationCompleteLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10435$$Nest$mcheckBootAnimationCompleteLocked(WindowManagerService r0) {
        return r0.checkBootAnimationCompleteLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoDump, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10436$$Nest$mdoDump(WindowManagerService r0, FileDescriptor r1, PrintWriter r2, String[] r3, boolean r4) {
        r0.doDump(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpVisibleWindowClients, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10437$$Nest$mdumpVisibleWindowClients(WindowManagerService r0, FileDescriptor r1, PrintWriter r2, long r3) {
        r0.dumpVisibleWindowClients(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAnimatorDurationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10438$$Nest$mgetAnimatorDurationScaleSetting(WindowManagerService r0) {
        return r0.getAnimatorDurationScaleSetting();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFocusedWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m10439$$Nest$mgetFocusedWindow(WindowManagerService r0) {
        return r0.getFocusedWindow();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTransitionAnimationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10440$$Nest$mgetTransitionAnimationScaleSetting(WindowManagerService r0) {
        return r0.getTransitionAnimationScaleSetting();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetWindowAnimationScaleSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10441$$Nest$mgetWindowAnimationScaleSetting(WindowManagerService r0) {
        return r0.getWindowAnimationScaleSetting();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyWindowsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10442$$Nest$mnotifyWindowsChanged(WindowManagerService r0) {
        r0.notifyWindowsChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$monPointerDownOutsideFocusLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10443$$Nest$monPointerDownOutsideFocusLocked(WindowManagerService r0, InputTarget r1, boolean r2) {
        r0.onPointerDownOutsideFocusLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mperformEnableScreen, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10444$$Nest$mperformEnableScreen(WindowManagerService r0) {
        r0.performEnableScreen();
    }

    /* JADX INFO: renamed from: -$$Nest$msetForcedDensityLockedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10445$$Nest$msetForcedDensityLockedInternal(WindowManagerService r0, int r1, int r2, int r3) {
        r0.setForcedDensityLockedInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowStrictModeViolation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10446$$Nest$mshowStrictModeViolation(WindowManagerService r0, int r1, int r2) {
        r0.showStrictModeViolation(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowToastIfBlockingScreenCapture, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10447$$Nest$mshowToastIfBlockingScreenCapture(WindowManagerService r0, WindowState r1) {
        r0.showToastIfBlockingScreenCapture(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtakeAssistScreenshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScreenCapture.ScreenshotHardwareBuffer m10448$$Nest$mtakeAssistScreenshot(WindowManagerService r0, ToBooleanFunction r1) {
        return r0.takeAssistScreenshot(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtraceEndWaitingForWindowDrawn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10449$$Nest$mtraceEndWaitingForWindowDrawn(WindowManagerService r0, WindowState r1) {
        r0.traceEndWaitingForWindowDrawn(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtraceStartWaitingForWindowDrawn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10450$$Nest$mtraceStartWaitingForWindowDrawn(WindowManagerService r0, WindowState r1) {
        r0.traceStartWaitingForWindowDrawn(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAppOpsState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10451$$Nest$mupdateAppOpsState(WindowManagerService r0) {
        r0.updateAppOpsState();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateHiddenWhileSuspendedState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10452$$Nest$mupdateHiddenWhileSuspendedState(WindowManagerService r0, ArraySet r1, boolean r2) {
        r0.updateHiddenWhileSuspendedState(r1, r2);
    }

    static {
        MY_PID = Process.myPid();
        MY_UID = Process.myUid();
        sEnableShellTransitions = getShellTransitEnabled();
        ENABLE_FIXED_ROTATION_TRANSFORM = SystemProperties.getBoolean("persist.wm.fixed_rotation_transform", true);
        sThreadPriorityBooster = new WindowManagerThreadPriorityBooster();
    }

    static void boostPriorityForLockedSection() {
        sThreadPriorityBooster.boost();
    }

    static void resetPriorityAfterLockedSection() {
        sThreadPriorityBooster.reset();
    }

    public static WindowManagerService main(Context context, InputManagerService im, boolean showBootMsgs, WindowManagerPolicy policy, ActivityTaskManagerService atm) {
        AppCompatConfiguration appCompat = new AppCompatConfiguration(ActivityThread.currentActivityThread().getSystemUiContext());
        WindowManagerService wms = main(context, im, showBootMsgs, policy, atm, new DisplayWindowSettingsProvider(), new WindowManagerService$$ExternalSyntheticLambda19(), new WindowManagerService$$ExternalSyntheticLambda20(), appCompat);
        WindowManagerGlobal.setWindowManagerServiceForSystemProcess(wms);
        return wms;
    }

    static WindowManagerService main(final Context context, final InputManagerService im, final boolean showBootMsgs, final WindowManagerPolicy policy, final ActivityTaskManagerService atm, final DisplayWindowSettingsProvider displayWindowSettingsProvider, final Supplier<SurfaceControl.Transaction> transactionFactory, final Supplier<SurfaceControl.Builder> surfaceControlFactory, final AppCompatConfiguration appCompat) {
        final WindowManagerService[] wms = new WindowManagerService[1];
        DisplayThread.getHandler().runWithScissors(new WindowManagerService$$ExternalSyntheticLambda33(wms, context, im, showBootMsgs, policy, atm, displayWindowSettingsProvider, transactionFactory, surfaceControlFactory, appCompat), 0);
        return wms[0];
    }

    private static /* synthetic */ void lambda$main$0(WindowManagerService[] wms, Context context, InputManagerService im, boolean showBootMsgs, WindowManagerPolicy policy, ActivityTaskManagerService atm, DisplayWindowSettingsProvider displayWindowSettingsProvider, Supplier transactionFactory, Supplier surfaceControlFactory, AppCompatConfiguration appCompat) {
        wms[0] = new WindowManagerService(context, im, showBootMsgs, policy, atm, displayWindowSettingsProvider, transactionFactory, surfaceControlFactory, appCompat);
    }

    private void initPolicy() {
        UiThread.getHandler().runWithScissors(new AnonymousClass6(this), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver result) {
        new WindowManagerShellCommand(this).exec(this, in, out, err, args, callback, result);
    }

    private WindowManagerService(Context context, InputManagerService inputManager, boolean showBootMsgs, WindowManagerPolicy policy, ActivityTaskManagerService atm, DisplayWindowSettingsProvider displayWindowSettingsProvider, Supplier<SurfaceControl.Transaction> transactionFactory, Supplier<SurfaceControl.Builder> surfaceControlFactory, AppCompatConfiguration appCompat) {
        WindowManagerServiceIA r8 = null;
        this.mPerf = null;
        this.mKeyguardLockedStateListeners = new RemoteCallbackList();
        this.mOnWindowRemovedListeners = new ArrayList();
        boolean r9 = false;
        this.mDispatchedKeyguardLockedState = false;
        this.mVr2dDisplayId = -1;
        this.mVrModeEnabled = false;
        this.mKeyInterceptionInfoForToken = Collections.synchronizedMap(new ArrayMap());
        this.mVrStateCallbacks = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.mPriorityDumper = new AnonymousClass3(this);
        this.mShowAlertWindowNotifications = true;
        this.mSessions = new ArraySet();
        this.mWindowMap = new HashMap();
        this.mInputToWindowMap = new HashMap();
        this.mResizingWindows = new ArrayList();
        this.mFrameChangingWindows = new ArrayList();
        this.mDisplayImePolicyCache = Collections.unmodifiableMap(new ArrayMap());
        this.mDestroySurface = new ArrayList();
        this.mForceRemoves = new ArrayList();
        this.mWaitingForDrawnCallbacks = new ArrayMap();
        this.mHidingNonSystemOverlayWindows = new ArrayList();
        this.mHidingNonSystemOverlayWindowsCountPerUid = new ArrayMap();
        this.mOrientationMapping = new SparseIntArray();
        this.mTmpRect = new Rect();
        this.mDisplayEnabled = false;
        this.mSystemBooted = false;
        this.mForceDisplayEnabled = false;
        this.mShowingBootMessages = false;
        this.mSystemReady = false;
        this.mBootAnimationStopped = false;
        this.mBootWaitForWindowsStartTime = -1;
        this.mWallpaperVisibilityListeners = new WallpaperVisibilityListeners();
        this.mDisplayChangeController = null;
        this.mDisplayChangeControllerDeath = new AnonymousClass4(this);
        this.mSwitchingUser = false;
        this.mWindowsInsetsChanged = 0;
        this.mH = new H(this);
        this.mAnimationHandler = new Handler(AnimationThread.getHandler().getLooper());
        this.mMaximumObscuringOpacityForTouch = 0.8f;
        this.mWindowContextListenerController = new WindowContextListenerController();
        this.mContentRecordingController = new ContentRecordingController();
        this.mSurfaceSyncGroupController = new SurfaceSyncGroupController();
        this.mTrustedPresentationListenerController = new TrustedPresentationListenerController();
        this.mWindowAnimationScaleSetting = 1.0f;
        this.mTransitionAnimationScaleSetting = 1.0f;
        this.mAnimatorDurationScaleSetting = 1.0f;
        this.mAnimationsDisabled = false;
        this.mPointerLocationEnabled = false;
        this.mAnimationTransferMap = new ArrayMap();
        this.mWindowChangeListeners = new ArrayList();
        this.mWindowFocusChangeListeners = new ArrayList();
        this.mWindowsChanged = false;
        this.mSensitiveContentProtectionSessionId = 0;
        this.mSensitiveContentPackages = new SensitiveContentPackages();
        this.mCaptureBlockedToastShownUids = new IntArray();
        this.mObricExt = (IObricWindowManagerService) ObricImplFactory.getImpl(IObricWindowManagerService.class, new Object[]{this});
        this.mActivityManagerAppTransitionNotifier = new AnonymousClass5(this);
        this.mDisableSecureWindows = false;
        this.mInputManagerCallback = new InputManagerCallback(this);
        this.mSmtEx = new WindowManagerServiceSmtEx(this);
        this.mIExt = (IExtWindowManagerService) ExtImplFactory.getImpl(IExtWindowManagerService.class, new Object[]{this});
        LockGuard.installLock(this, 5);
        this.mGlobalLock = atm.getGlobalLock();
        this.mAtmService = atm;
        this.mContext = context;
        this.mFlags = new WindowManagerFlags();
        this.mIsPc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        this.mAllowBootMessages = showBootMsgs;
        this.mLimitedAlphaCompositing = context.getResources().getBoolean(R.bool.config_showPercentageTextDuringRebootToUpdate);
        this.mHasPermanentDpad = context.getResources().getBoolean(R.bool.config_hotswapCapable);
        this.mDrawLockTimeoutMillis = context.getResources().getInteger(R.integer.config_externalDisplayPeakRefreshRate);
        this.mAllowAnimationsInLowPowerMode = context.getResources().getBoolean(R.bool.config_allowAnimationsInLowPowerMode);
        this.mMaxUiWidth = context.getResources().getInteger(R.integer.config_mobile_mtu);
        this.mSupportsHighPerfTransitions = context.getResources().getBoolean(R.bool.config_device_volte_available);
        this.mDisableTransitionAnimation = context.getResources().getBoolean(R.bool.config_disable_all_cb_messages);
        this.mPerDisplayFocusEnabled = context.getResources().getBoolean(R.bool.config_perDisplayFocusEnabled);
        this.mAssistantOnTopOfDream = context.getResources().getBoolean(R.bool.config_assistantOnTopOfDream);
        this.mSkipActivityRelaunchWhenDocking = context.getResources().getBoolean(R.bool.config_sms_force_7bit_encoding);
        if (context.getResources().getBoolean(R.bool.config_defaultBinderHeavyHitterAutoSamplerEnabled) == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean isScreenSizeDecoupledFromStatusBarAndCutout = r2;
        if (this.mFlags.mInsetsDecoupledConfiguration == false) goto L11;
        this.mDecorTypes = 0;
        this.mConfigTypes = 0;
    L12:
        if (isScreenSizeDecoupledFromStatusBarAndCutout == true) goto L14;
    L16:
        this.mOverrideConfigTypes = (WindowInsets.Type.displayCutout() | WindowInsets.Type.statusBars()) | WindowInsets.Type.navigationBars();
        this.mOverrideDecorTypes = WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars();
    L17:
        this.mAppCompatConfiguration = appCompat;
        this.mInputManager = inputManager;
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mPossibleDisplayInfoMapper = new PossibleDisplayInfoMapper(this.mDisplayManagerInternal);
        this.mSurfaceControlFactory = surfaceControlFactory;
        this.mTransactionFactory = transactionFactory;
        this.mTransaction = this.mTransactionFactory.get();
        this.mPolicy = policy;
        this.mAnimator = new WindowAnimator(this);
        this.mRoot = new RootWindowContainer(this);
        ContentResolver resolver = context.getContentResolver();
        this.mSyncEngine = new BLASTSyncEngine(this);
        this.mWindowPlacerLocked = new WindowSurfacePlacer(this);
        this.mSnapshotController = new SnapshotController(this);
        this.mTaskSnapshotController = this.mSnapshotController.mTaskSnapshotController;
        this.mWindowTracing = WindowTracing.createDefaultAndStartLooper(this, Choreographer.getInstance());
        this.mTransitionTracer = new PerfettoTransitionTracer();
        LocalServices.addService(WindowManagerPolicy.class, this.mPolicy);
        this.mDisplayManager = (DisplayManager) context.getSystemService("display");
        this.mKeyguardDisableHandler = KeyguardDisableHandler.create(this.mContext, this.mPolicy, this.mH);
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        this.mDeviceStateManager = (DeviceStateManager) context.getSystemService(DeviceStateManager.class);
        this.mDeviceStateCallback = new DeviceStateCallback(this, r8);
        this.mDeviceStateManager.registerCallback(new HandlerExecutor(this.mH), this.mDeviceStateCallback);
        if (this.mPowerManagerInternal == null) goto L20;
        this.mPowerManagerInternal.registerLowPowerModeObserver(new AnonymousClass7(this));
        this.mAnimationsDisabled = this.mPowerManagerInternal.getLowPowerState(3).batterySaverEnabled;
    L20:
        this.mRotationWatcherController = new RotationWatcherController(this);
        this.mDisplayNotificationController = new DisplayWindowListenerController(this);
        this.mTaskSystemBarsListenerController = new TaskSystemBarsListenerController();
        this.mActivityManager = ActivityManager.getService();
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mUmInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mAppOps = (AppOpsManager) context.getSystemService("appops");
        AppOpsManager.OnOpChangedListener r5 = new AnonymousClass8(this);
        this.mAppOps.startWatchingMode(24, null, r5);
        this.mAppOps.startWatchingMode(45, null, r5);
        this.mPmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mTestUtilityService = (TestUtilityService) LocalServices.getService(TestUtilityService.class);
        IntentFilter suspendPackagesFilter = new IntentFilter();
        suspendPackagesFilter.addAction("android.intent.action.PACKAGES_SUSPENDED");
        suspendPackagesFilter.addAction("android.intent.action.PACKAGES_UNSUSPENDED");
        context.registerReceiverAsUser(new AnonymousClass9(this), UserHandle.ALL, suspendPackagesFilter, null, null);
        this.mWindowAnimationScaleSetting = getWindowAnimationScaleSetting();
        this.mTransitionAnimationScaleSetting = getTransitionAnimationScaleSetting();
        setAnimatorDurationScale(getAnimatorDurationScaleSetting());
        if (Settings.Global.getInt(resolver, "force_desktop_mode_on_external_displays", 0) == 0) goto L23;
        r9 = true;
    L23:
        this.mForceDesktopModeOnExternalDisplays = r9;
        String displaySettingsPath = Settings.Global.getString(resolver, "wm_display_settings_path");
        this.mDisplayWindowSettingsProvider = displayWindowSettingsProvider;
        if (displaySettingsPath == null) goto L26;
        this.mDisplayWindowSettingsProvider.setBaseSettingsFilePath(displaySettingsPath);
    L26:
        this.mDisplayWindowSettings = new DisplayWindowSettings(this, this.mDisplayWindowSettingsProvider);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED");
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, null);
        this.mLatencyTracker = LatencyTracker.getInstance(context);
        this.mSettingsObserver = new SettingsObserver(this);
        this.mSurfaceAnimationRunner = new SurfaceAnimationRunner(this.mTransactionFactory, this.mPowerManagerInternal);
        this.mAllowTheaterModeWakeFromLayout = context.getResources().getBoolean(R.bool.config_allowTheaterModeWakeFromWindowLayout);
        this.mDragDropController = new DragDropController(this, this.mH.getLooper());
        this.mHighRefreshRateDenylist = HighRefreshRateDenylist.create(context.getResources());
        this.mConstants = new WindowManagerConstants(this, DeviceConfigInterface.REAL);
        this.mConstants.start(new HandlerExecutor(this.mH));
        LocalServices.addService(WindowManagerInternal.class, new LocalService(this));
        LocalServices.addService(ImeTargetVisibilityPolicy.class, new ImeTargetVisibilityPolicyImpl(this, null));
        this.mEmbeddedWindowController = new EmbeddedWindowController(this.mAtmService, inputManager);
        this.mDisplayAreaPolicyProvider = DisplayAreaPolicy.Provider.fromResources(this.mContext.getResources());
        this.mDisplayHashController = new DisplayHashController(this.mContext);
        setGlobalShadowSettings();
        this.mAnrController = new AnrController(this);
        this.mStartingSurfaceController = new StartingSurfaceController(this);
        this.mPresentationController = new PresentationController();
        this.mBlurController = new BlurController(this.mContext, this.mPowerManager);
        this.mTaskFpsCallbackController = new TaskFpsCallbackController();
        this.mAccessibilityController = new AccessibilityController(this);
        this.mScreenRecordingCallbackController = new ScreenRecordingCallbackController(this);
        this.mSystemPerformanceHinter = new SystemPerformanceHinter(this.mContext, new WindowManagerService$$ExternalSyntheticLambda23(this), this.mTransactionFactory);
        this.mSystemPerformanceHinter.mTraceTag = 32;
        SysOptBridge.getFactory().getDynamicRefreshRateService().setWindowManagerServiceSmtEx(this.mSmtEx);
        LocalServices.addService(ConfigurationChangeSetting.ConfigurationChangeSettingInternal.class, new ConfigurationChangeSettingInternalImpl(this, null));
        this.mSmtEx.initLocalServices();
        getExt().init();
        return;
    L14:
        if (this.mFlags.mInsetsDecoupledConfiguration == true) goto L16;
        this.mOverrideConfigTypes = 0;
        this.mOverrideDecorTypes = 0;
        goto L17
    L11:
        this.mDecorTypes = WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars();
        this.mConfigTypes = (WindowInsets.Type.displayCutout() | WindowInsets.Type.statusBars()) | WindowInsets.Type.navigationBars();
        goto L12
    L5:
        if (this.mFlags.mAllowsScreenSizeDecoupledFromStatusBarAndCutout == false) goto L7;
        r2 = true;
        goto L8
    }

    private /* synthetic */ SurfaceControl lambda$new$1(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L11
        if (dc != null) goto L7;
        SurfaceControl r2 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r2;
    L7:
        r2 = dc.getSurfaceControl();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    DisplayAreaPolicy.Provider getDisplayAreaPolicyProvider() {
        return this.mDisplayAreaPolicyProvider;
    }

    private void setGlobalShadowSettings() {
        TypedArray a = this.mContext.obtainStyledAttributes(null, com.android.internal.R.styleable.Lighting, 0, 0);
        float lightY = a.getDimension(3, 0.0f);
        float lightZ = a.getDimension(4, 0.0f);
        float lightRadius = a.getDimension(2, 0.0f);
        float ambientShadowAlpha = a.getFloat(0, 0.0f);
        float spotShadowAlpha = a.getFloat(1, 0.0f);
        a.recycle();
        float[] ambientColor = {0.0f, 0.0f, 0.0f, ambientShadowAlpha};
        float[] spotColor = {0.0f, 0.0f, 0.0f, spotShadowAlpha};
        SurfaceControl.setGlobalShadowSettings(ambientColor, spotColor, lightY, lightZ, lightRadius);
    }

    private float getTransitionAnimationScaleSetting() {
        return WindowManager.fixScale(Settings.Global.getFloat(this.mContext.getContentResolver(), "transition_animation_scale", this.mContext.getResources().getFloat(R.dimen.datepicker_list_year_activated_label_size)));
    }

    private float getAnimatorDurationScaleSetting() {
        return WindowManager.fixScale(Settings.Global.getFloat(this.mContext.getContentResolver(), "animator_duration_scale", this.mAnimatorDurationScaleSetting));
    }

    private float getWindowAnimationScaleSetting() {
        return WindowManager.fixScale(Settings.Global.getFloat(this.mContext.getContentResolver(), "window_animation_scale", this.mWindowAnimationScaleSetting));
    }

    public void onInitReady() {
        initPolicy();
        Watchdog.getInstance().addMonitor(this);
        createWatermark();
        showEmulatorDisplayOverlayIfNeeded();
    }

    public InputManagerCallback getInputManagerCallback() {
        return this.mInputManagerCallback;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
    L7:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L11;
    L13:
        throw e;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[5] == false) goto L13;
        String protoLogParam0 = String.valueOf(e);
        ProtoLogImpl_798997914.wtf(WmProtoLogGroups.WM_ERROR, 3655576047584951173L, 0, new Object[]{protoLogParam0});
        goto L13
    L3:
        if (super.onTransact(code, data, reply, flags) == true) goto L16;
        return this.mIExt.onTransact(code, data, reply, flags);
    L16:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x00d1: MOVE (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('callingUid' int)]), block:B:41:0x00ca */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v41, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v49 */
    /* JADX WARN: Type inference failed for: r13v50 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r33v11 */
    public int addWindow(Session r38, IWindow r39, WindowManager.LayoutParams r40, int r41, int r42, int r43, int r44, InputChannel r45, InsetsState r46, InsetsSourceControl.Array r47, Rect r48, float[] r49) {
        r47.set(null, false);
        int[] r6 = new int[1];
        if ((r40.privateFlags & 1048576) == 0) goto L5;
        boolean r4 = true;
    L6:
        int r20 = this.mPolicy.checkAddPermission(r40.type, r4, r40.packageName, r6, r42);
        if (r20 == 0) goto L9;
        return r20;
    L9:
        WindowState r3 = null;
        int r14 = Binder.getCallingUid();
        int r5 = Binder.getCallingPid();
        long r22 = Binder.clearCallingIdentity();
        boolean r7 = r4;
        int r8 = r40.type;
        WindowManagerGlobalLock r9 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r9);
    L467:
        th = th;
    L468:
        monitor-exit(r26);     // Catch: Throwable -> L467
        resetPriorityAfterLockedSection();
        throw th;
    L462:
        th = th;
        WindowManagerGlobalLock r26 = r9;
        goto L468
    L12:
        if (this.mDisplayReady == false) goto L466;
        boolean r13 = r38.isClientDead();     // Catch: Throwable -> L462
        if (r13 == false) goto L30;
    L23:
        th = th;
        r26 = r9;
        goto L468
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L25;
        int r17 = r5;
        boolean r25 = r7;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -3029436704707366221L, 0, new Object[]{String.valueOf(r38)});     // Catch: Throwable -> L21
    L26:
        monitor-exit(r9);     // Catch: Throwable -> L21
        resetPriorityAfterLockedSection();
        return -4;
    L21:
        th = th;
        r26 = r9;
        goto L468
    L25:
        r17 = r5;
        r25 = r7;
        goto L26
    L30:
        if (r8 >= 1000) goto L32;
    L60:
        int r18 = r14;
        ?? r15 = r13;
    L59:
        WindowState r10 = r3;
        if (r10 == null) goto L499;
        DisplayContent r11 = r10.mDisplayContent;     // Catch: Throwable -> L64
    L68:
        if (r11 != null) goto L505;
        r15 = "the displayId is " + r42 + ", use default display";     // Catch: Throwable -> L64
        Slog.e(TAG, r15);     // Catch: Throwable -> L64
        r11 = getDisplayContentOrCreate(0, r40.token);     // Catch: Throwable -> L64
    L505:
        if (r11 == null) goto L516;
        r26 = r9;
    L457:
        th = th;
        goto L468
    L87:
        if (r11.hasAccess(r38.mUid) == true) goto L95;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L91;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 8039410207325630747L, 1, new Object[]{Long.valueOf(r11.getDisplayId())});     // Catch: Throwable -> L77
    L91:
        monitor-exit(r26);     // Catch: Throwable -> L77
        resetPriorityAfterLockedSection();
        return -9;
    L95:
        if (this.mWindowMap.containsKey(r39.asBinder()) == false) goto L105;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L101;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -3451016577701561221L, 0, new Object[]{String.valueOf(r39)});     // Catch: Throwable -> L77
    L101:
        monitor-exit(r26);     // Catch: Throwable -> L77
        resetPriorityAfterLockedSection();
        return -5;
    L105:
        if (r8 == 2030) goto L492;
        int r12 = r18;
    L122:
        if (r8 == 2037) goto L124;
    L471:
        int r16 = UserHandle.getUserId(r38.mUid);     // Catch: Throwable -> L455
        if (r43 != r16) goto L525;
        int r19 = 3;
        boolean r21 = true;
        int r110 = r5;
        int r111 = r16;
        int r112 = r12;
    L158:
        if (r10 == null) goto L160;
        boolean r23 = r21;
    L162:
        if (r23 == false) goto L519;
        IBinder r24 = r10.mAttrs.token;     // Catch: Throwable -> L150
    L166:
        WindowToken r27 = r11.getWindowToken(r24);     // Catch: Throwable -> L453
        Pair<WindowToken, DisplayContent> r28 = this.mObricExt.findSuitableWindowTokenLocked(r23, r10, r40, r27);     // Catch: Throwable -> L453
        if (r28 != null) goto L169;
    L173:
        DisplayContent r0 = r11;
        WindowToken r29 = r27;
    L174:
        if (r23 == false) goto L177;
        int r30 = r10.mAttrs.type;     // Catch: Throwable -> L150
    L178:
        boolean r113 = false;
        IBinder r31 = r40.mWindowContextToken;     // Catch: Throwable -> L453
        int r210 = r19;
        if (r29 != null) goto L218;
        boolean r211 = r23;
        int r32 = r30;
        int r33 = r112;
        boolean r34 = unprivilegedAppCanCreateTokenWith(r10, r33, r8, r32, r40.token, r40.packageName);     // Catch: Throwable -> L214
        int r2 = r33;
        int r35 = r8;
        if (r34 == true) goto L193;
        monitor-exit(r26);     // Catch: Throwable -> L191
        resetPriorityAfterLockedSection();
        return -1;
    L193:
        if (r211 == true) goto L195;
    L206:
        th = th;
        goto L468
    L197:
        if (this.mWindowContextListenerController.hasListener(r31) == true) goto L199;
        Session r36 = r38;
        ActivityRecord r37 = null;
        if (r40.token == null) goto L211;
        IBinder r50 = r40.token;     // Catch: Throwable -> L191
    L213:
        int r51 = r32;
        r10 = r10;
        WindowToken r52 = new WindowToken.Builder(this, r50, r35).setDisplayContent(r0).setOwnerCanManageAppTokens(r36.mCanAddInternalSystemWindow).setRoundedCornerOverlay(r7).build();     // Catch: Throwable -> L191
        IBinder r310 = r31;
        int r311 = r110;
        boolean r53 = true;
    L350:
        DisplayContent r54 = r0;
        boolean r212 = r53;
        int r114 = r2;
        WindowState r55 = r10;
        int r115 = r35;
        WindowState r1 = new WindowState(this, r36, r39, r52, r55, r6[0], r40, r41, r36.mUid, r111, r36.mCanAddInternalSystemWindow);     // Catch: Throwable -> L447
        WindowToken r56 = r52;
        DisplayPolicy r57 = r54.getDisplayPolicy();     // Catch: Throwable -> L391
        r57.adjustWindowParamsLw(r1, r1.mAttrs);     // Catch: Throwable -> L391
        int r58 = r311;
        r40.flags = sanitizeFlagSlippery(r40.flags, r1.getName(), r114, r58);     // Catch: Throwable -> L445
        r40.inputFeatures = sanitizeInputFeatures(r40.inputFeatures, r1.getName(), r114, r58, r1.isTrustedOverlay());     // Catch: Throwable -> L393
        if ((r40.flags & 8) != 8) goto L369;
        Slog.d(TAG, "addWindow " + r1.getName() + ",token=" + r56 + ",flags=" + r40.flags + "not focusable inputFeatures = " + r40.inputFeatures);     // Catch: Throwable -> L366
    L366:
        th = th;
    L369:
        r1.setRequestedVisibleTypes(r44);     // Catch: Throwable -> L393
        this.mObricExt.updateWindowStateShowWhenKeyguard(r40, r58, r114, r1);     // Catch: Throwable -> L393
        int r59 = r57.validateAddingWindowLw(r40, r58, r114);     // Catch: Throwable -> L393
        if (r59 == 0) goto L375;
        monitor-exit(r26);     // Catch: Throwable -> L366
        resetPriorityAfterLockedSection();
        return r59;
    L375:
        if (r45 != null) goto L377;
    L379:
        r212 = false;
    L381:
        if (r212 == false) goto L383;
        r1.openInputChannel(r45);     // Catch: Throwable -> L366
    L383:
        if (r115 != 2005) goto L416;
        this.mAtmService.setToastWindow();     // Catch: Throwable -> L393
        DisplayContent r60 = r54;
        if (r60.canAddToastWindowForUid(r114) == true) goto L400;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[r210] == false) goto L396;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1161056447389155729L, 0, null);     // Catch: Throwable -> L391
    L396:
        monitor-exit(r26);     // Catch: Throwable -> L391
        resetPriorityAfterLockedSection();
        return -5;
    L400:
        if (r113 == true) goto L402;
    L406:
        if (r113 == true) goto L415;
        if ((r40.flags & 8) == 0) goto L415;
        if (r60.mCurrentFocus == null) goto L415;
        if (r60.mCurrentFocus.mOwnerUid != r114) goto L415;
    L418:
        if (r1.isChildWindow() == true) goto L435;
        IBinder r61 = r310;
        if (this.mWindowContextListenerController.hasListener(r61) == false) goto L436;
        int r62 = this.mWindowContextListenerController.getWindowType(r61);     // Catch: Throwable -> L391
        Bundle r63 = this.mWindowContextListenerController.getOptions(r61);     // Catch: Throwable -> L391
        if (r115 == r62) goto L433;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[r210] == false) goto L428;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -7518552252637236411L, 5, new Object[]{Long.valueOf(r115), Long.valueOf(r62)});     // Catch: Throwable -> L391
    L428:
        if (WindowProviderService.isWindowProviderService(r63) == true) goto L436;
        monitor-exit(r26);     // Catch: Throwable -> L391
        resetPriorityAfterLockedSection();
        return -10;
    L433:
        this.mWindowContextListenerController.updateContainerForWindowContextListener(r61, r56);     // Catch: Throwable -> L391
    L436:
        SysOptBridge.getFactory().getProcessIntercept().markAppForBecomeVisible(r114);     // Catch: Throwable -> L391
        if (r60.mCurrentFocus != null) goto L439;
        r60.mWinAddedSinceNullFocus.add(r1);     // Catch: Throwable -> L391
    L439:
        r1.mSession.onWindowAdded(r1);     // Catch: Throwable -> L391
        this.mWindowMap.put(r39.asBinder(), r1);     // Catch: Throwable -> L391
        r1.initAppOpsState();     // Catch: Throwable -> L391
        r1.setHiddenWhileSuspended(this.mPmInternal.isPackageSuspended(r1.getOwningPackage(), UserHandle.getUserId(r1.getOwningUid())));     // Catch: Throwable -> L391
        r1.setForceHideNonSystemOverlayWindowIfNeeded(shouldHideNonSystemOverlayWindow(r1));     // Catch: Throwable -> L391
        int r213 = r59 | addWindowInner(r1, r57, r37, r60, r46, r48, r47, r39, r49, r40, r114);     // Catch: Throwable -> L391
        monitor-exit(r26);     // Catch: Throwable -> L391
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(r22);
        return r213;
    L435:
        r61 = r310;
    L415:
        this.mH.sendMessageDelayed(this.mH.obtainMessage(52, r1), r1.mAttrs.hideTimeoutMilliseconds);     // Catch: Throwable -> L391
        goto L418
    L402:
        if (r56.isEmpty() == true) goto L406;
        monitor-exit(r26);     // Catch: Throwable -> L391
        resetPriorityAfterLockedSection();
        return -1;
    L416:
        r60 = r54;
        goto L418
    L377:
        if ((r40.inputFeatures & 1) != 0) goto L379;
    L393:
        th = th;
    L443:
        th = th;
    L445:
        th = th;
    L391:
        th = th;
    L447:
        th = th;
    L449:
        th = th;
        goto L468
    L211:
        r50 = r39.asBinder();     // Catch: Throwable -> L191
        goto L213
    L199:
        if (r40.token == null) goto L202;
        IBinder r64 = r40.token;     // Catch: Throwable -> L191
    L203:
        Bundle r65 = this.mWindowContextListenerController.getOptions(r31);     // Catch: Throwable -> L206
        WindowToken.Builder r116 = new WindowToken.Builder(this, r64, r35).setDisplayContent(r0);     // Catch: Throwable -> L206
        r37 = null;
        r36 = r38;
        r51 = r32;
        r10 = r10;
        r52 = r116.setOwnerCanManageAppTokens(r36.mCanAddInternalSystemWindow).setRoundedCornerOverlay(r7).setFromClientToken(true).setOptions(r65).build();     // Catch: Throwable -> L191
        r310 = r31;
        r311 = r110;
        r53 = true;
        goto L350
    L202:
        r64 = r31;
        goto L203
    L195:
        r36 = r38;
        r51 = r32;
        r52 = r10.mToken;     // Catch: Throwable -> L191
        r310 = r31;
        r311 = r110;
        r37 = null;
        r53 = true;
        r10 = r10;
    L191:
        th = th;
    L214:
        th = th;
    L216:
        th = th;
        goto L468
    L218:
        r51 = r30;
        r35 = r8;
        r2 = r112;
        r37 = null;
        r36 = r38;
        if (r51 >= 1) goto L221;
    L265:
        r310 = r31;
        r311 = r110;
        if (r51 != 2011) goto L277;
        if (r29.windowType != 2011) goto L270;
        r53 = true;
        r210 = 3;
    L349:
        r52 = r29;
        goto L350
    L270:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L272;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -5450131464624918523L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L229
    L272:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -1;
    L277:
        if (r51 != 2031) goto L288;
        if (r29.windowType != 2031) goto L281;
        r53 = true;
        r210 = 3;
        goto L349
    L281:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L283;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -6484128707849211138L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L229
    L283:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -1;
    L288:
        if (r51 != 2013) goto L299;
        if (r29.windowType != 2013) goto L292;
        r53 = true;
        r210 = 3;
        goto L349
    L292:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L294;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 7768591536609704658L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L229
    L294:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -1;
    L299:
        if (r51 != 2032) goto L310;
        if (r29.windowType != 2032) goto L303;
        r53 = true;
        r210 = 3;
        goto L349
    L303:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L305;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 7497077135474110999L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L229
    L305:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -1;
    L310:
        if (r35 != 2005) goto L324;
        r113 = doesAddToastWindowRequireToken(r40.packageName, r2, r10);     // Catch: Throwable -> L229
        if (r113 == false) goto L322;
        if (r29.windowType == 2005) goto L322;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L318;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 8957851092580119204L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L229
    L318:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -1;
    L322:
        r51 = r51;
        r10 = r10;
        r52 = r29;
        r53 = true;
        r210 = 3;
        goto L350
    L324:
        if (r35 == 2035) goto L326;
        if (r29.asActivityRecord() != null) goto L490;
        r53 = true;
        r210 = 3;
        goto L349
    L490:
        r210 = 3;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L345;
        r10 = r10;
        r53 = true;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 3419934373251134563L, 1, new Object[]{Long.valueOf(r51)});     // Catch: Throwable -> L341
    L346:
        r40.token = null;     // Catch: Throwable -> L341
        r52 = new WindowToken.Builder(this, r39.asBinder(), r35).setDisplayContent(r0).setOwnerCanManageAppTokens(r36.mCanAddInternalSystemWindow).build();     // Catch: Throwable -> L341
    L341:
        th = th;
        goto L468
    L345:
        r10 = r10;
        r53 = true;
    L343:
        th = th;
    L451:
        th = th;
        goto L468
    L326:
        if (r29.windowType != 2035) goto L328;
        r53 = true;
        r210 = 3;
        goto L349
    L328:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L330;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1945746969404688952L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L229
    L330:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -1;
    L221:
        if (r51 > 99) goto L265;
        ActivityRecord r66 = r29.asActivityRecord();     // Catch: Throwable -> L231
        if (r66 == null) goto L225;
        r310 = r31;
        r311 = r110;
        if (r66.getParent() != null) goto L247;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[r210] == false) goto L243;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -6507147599943157469L, 0, new Object[]{String.valueOf(r29)});     // Catch: Throwable -> L229
    L243:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -4;
    L247:
        if (r35 == r210) goto L249;
    L264:
        r51 = r51;
        r52 = r29;
        r37 = r66;
        r53 = true;
        r210 = 3;
        r10 = r10;
        goto L350
    L249:
        if (r66.mStartingWindow == null) goto L257;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[r210] == false) goto L253;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1409483453189443362L, 0, null);     // Catch: Throwable -> L229
    L253:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -5;
    L257:
        if (r66.mStartingData != null) goto L264;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L261;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1806907994917883598L, 0, null);     // Catch: Throwable -> L229
    L261:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -5;
    L225:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[r210] == false) goto L234;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 3713874359318494804L, 0, new Object[]{String.valueOf(r29)});     // Catch: Throwable -> L229
    L234:
        monitor-exit(r26);     // Catch: Throwable -> L229
        resetPriorityAfterLockedSection();
        return -3;
    L231:
        th = th;
    L229:
        th = th;
    L453:
        th = th;
        goto L468
    L177:
        r30 = r8;
        goto L178
    L169:
        if (r28.first == null) goto L173;
        if (r28.second == null) goto L173;
        WindowToken r67 = (WindowToken) r28.first;     // Catch: Throwable -> L150
        r0 = (DisplayContent) r28.second;     // Catch: Throwable -> L150
        r29 = r67;
        goto L174
    L519:
        r24 = r40.token;     // Catch: Throwable -> L453
        goto L166
    L160:
        r23 = false;
        goto L162
    L525:
        r110 = r5;
        int r117 = r12;
        r19 = 3;
        this.mAmInternal.handleIncomingUser(r110, r117, r43, false, 0, null, null);     // Catch: Throwable -> L138 Exception -> L140
        r112 = r117;
        r111 = r43;
        r21 = true;
        goto L158
    L138:
        th = th;
    L148:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[r19] == false) goto L153;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -2546047231197102533L, 1, new Object[]{Long.valueOf(r43)});     // Catch: Throwable -> L150
    L153:
        monitor-exit(r26);     // Catch: Throwable -> L150
        resetPriorityAfterLockedSection();
        return -11;
    L142:
        th = th;
    L145:
        r19 = 3;
    L150:
        th = th;
    L455:
        th = th;
        goto L468
    L124:
        if (this.mPresentationController.canPresent(null, r11, r8, r12) == true) goto L471;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L128;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 7599690046549866326L, 0, null);     // Catch: Throwable -> L113
    L128:
        monitor-exit(r26);     // Catch: Throwable -> L113
        resetPriorityAfterLockedSection();
        return -9;
    L492:
        r12 = r18;
    L113:
        th = th;
        goto L468
    L109:
        if (this.mPresentationController.canPresent(null, r11, r8, r12) == true) goto L122;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L115;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1075040941127814341L, 0, null);     // Catch: Throwable -> L113
    L115:
        monitor-exit(r26);     // Catch: Throwable -> L113
        resetPriorityAfterLockedSection();
        return -8;
    L118:
        th = th;
        goto L468
    L516:
    L79:
        th = th;
        r26 = r9;
        goto L468
    L73:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L81;
        int r118 = -9;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1303710477998542095L, 1, new Object[]{Long.valueOf(r42)});     // Catch: Throwable -> L77
    L82:
        monitor-exit(r9);     // Catch: Throwable -> L77
        resetPriorityAfterLockedSection();
        return r118;
    L81:
        r118 = -9;
    L77:
        th = th;
    L64:
        th = th;
        r26 = r9;
        goto L468
    L499:
        r11 = getDisplayContentOrCreate(r42, r40.token);     // Catch: Throwable -> L460
    L460:
        th = th;
        r26 = r9;
        goto L468
    L32:
        if (r8 > 1999) goto L60;
        r3 = windowForClientLocked(null, r40.token, false);     // Catch: Throwable -> L42
        if (r3 == null) goto L36;
        r18 = r14;
        int r119 = r3.mAttrs.type;     // Catch: Throwable -> L40
        r15 = r119;
        if (r119 < 1000) goto L59;
        r15 = r119;
        if (r3.mAttrs.type > 1999) goto L59;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L56;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -8579305050440451727L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L40
    L56:
        monitor-exit(r9);     // Catch: Throwable -> L40
        resetPriorityAfterLockedSection();
        return -2;
    L36:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L44;
        int r120 = -2;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 7245919222637411747L, 0, new Object[]{String.valueOf(r40.token)});     // Catch: Throwable -> L40
    L45:
        monitor-exit(r9);     // Catch: Throwable -> L40
        resetPriorityAfterLockedSection();
        return r120;
    L44:
        r120 = -2;
    L40:
        th = th;
        r26 = r9;
    L42:
        th = th;
        r26 = r9;
        goto L468
    L466:
        throw new IllegalStateException("Display has not been initialialized");     // Catch: Throwable -> L467
    L5:
        r4 = false;
        goto L6
    }

    private int addWindowInner(WindowState win, DisplayPolicy displayPolicy, ActivityRecord activity, DisplayContent displayContent, InsetsState outInsetsState, Rect outAttachedFrame, InsetsSourceControl.Array outActiveControls, IWindow client, float[] outSizeCompatScale, WindowManager.LayoutParams attrs, int uid) {
        int type = attrs.type;
        boolean imMayMove = true;
        win.mToken.addWindow(win);
        displayPolicy.addWindowLw(win, attrs);
        displayPolicy.setDropInputModePolicy(win, win.mAttrs);
        if (type != 3) goto L9;
        if (activity == null) goto L9;
        activity.attachStartingWindow(win);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(activity);
        String protoLogParam1 = String.valueOf(win);
        int res = 0;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -6055615852717459196L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L26:
        WindowStateAnimator winAnimator = win.mWinAnimator;
        winAnimator.mEnterAnimationPending = true;
        winAnimator.mEnteringAnimation = true;
        if (displayPolicy.areSystemBarsForcedConsumedLw() == false) goto L29;
        int res2 = res | 4;
    L31:
        if (displayContent.isInTouchMode() == false) goto L34;
        res2 = res2 | 1;
    L34:
        if (win.mActivityRecord != null) goto L36;
    L39:
        int res3 = res2 | 2;
    L40:
        displayContent.getInputMonitor().setUpdateInputWindowsNeededLw();
        if (win.canReceiveKeys() == false) goto L46;
        boolean focusChanged = updateFocusedWindowLocked(1, false);
        if (focusChanged == false) goto L45;
        boolean focusChanged2 = focusChanged;
        boolean imMayMove2 = false;
    L47:
        if (imMayMove2 == false) goto L52;
        displayContent.computeImeTarget(true);
        if (win.isImeOverlayLayeringTarget() == false) goto L52;
        dispatchImeTargetOverlayVisibilityChanged(client.asBinder(), win.mAttrs.type, win.isVisibleRequestedOrAdding(), false, displayContent.getDisplayId());
    L52:
        if (win.mActivityRecord != null) goto L54;
    L56:
        win.getParent().assignChildLayers();
    L57:
        if (focusChanged2 == false) goto L59;
        displayContent.getInputMonitor().setInputFocusLw(displayContent.mCurrentFocus, false);
    L59:
        displayContent.getInputMonitor().updateInputWindowsLw(false);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L62;
        String protoLogParam2 = String.valueOf(client.asBinder());
        String protoLogParam3 = String.valueOf(win);
        String protoLogParam4 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -2829980616540274784L, 0, new Object[]{protoLogParam2, protoLogParam3, protoLogParam4});
    L62:
        getExt().traceAddWindow(win);
        if (win.isVisibleRequestedOrAdding() == true) goto L65;
    L67:
        boolean needToSendNewConfiguration = false;
    L69:
        if (win.providesDisplayDecorInsets() == false) goto L71;
        needToSendNewConfiguration = needToSendNewConfiguration | displayPolicy.updateDecorInsetsInfo();
    L71:
        if (needToSendNewConfiguration == false) goto L73;
        displayContent.sendNewConfiguration();
    L73:
        displayContent.getInsetsStateController().updateAboveInsetsState(false);
        win.fillInsetsState(outInsetsState, true);
        getInsetsSourceControls(win, outActiveControls);
        if (win.mLayoutAttached == false) goto L78;
        outAttachedFrame.set(win.getParentWindow().getFrame());
        if (win.mInvGlobalScale == 1.0f) goto L79;
        outAttachedFrame.scale(win.mInvGlobalScale);
    L79:
        outSizeCompatScale[0] = win.getCompatScaleForClient();
        String title = null;
        if (win.mInputWindowHandle != null) goto L82;
    L90:
        if (title == null) goto L92;
        SysOptBridge.getFactory().getProcessIntercept().isOnePixelWindow(attrs, title);
    L92:
        if (res3 < 0) goto L97;
        if (win.isPresentation() == false) goto L97;
        this.mPresentationController.onPresentationAdded(win, uid);
    L97:
        return res3;
    L82:
        if (win.mInputWindowHandle.mHandle == null) goto L90;
        if (win.mInputWindowHandle.mHandle.name == null) goto L90;
        String[] titles = win.mInputWindowHandle.mHandle.name.split(SliceClientPermissions.SliceAuthority.DELIMITER);
        if (titles == null) goto L90;
        if (titles.length <= 1) goto L90;
        title = titles[1];
        goto L90
    L78:
        outAttachedFrame.set(0, 0, -1, -1);
        goto L79
    L65:
        if (displayContent.updateOrientation() == false) goto L67;
        needToSendNewConfiguration = true;
        goto L69
    L54:
        if (win.mActivityRecord.isEmbedded() == false) goto L56;
        win.getTask().assignChildLayers();
        goto L57
    L45:
        focusChanged2 = focusChanged;
        imMayMove2 = imMayMove;
        goto L47
    L46:
        focusChanged2 = false;
        imMayMove2 = imMayMove;
        goto L47
    L36:
        if (win.mActivityRecord.isClientVisible() == true) goto L39;
        res3 = res2;
        goto L40
    L29:
        res2 = res;
        goto L31
    L8:
        res = 0;
    L9:
        res = 0;
        if (type != 2011) goto L15;
        if ((win.mAttrs.flags & 16) != 0) goto L15;
        displayContent.setInputMethodWindowLocked(win);
        imMayMove = false;
    L15:
        if (type != 2012) goto L18;
        displayContent.computeImeTarget(true);
        imMayMove = false;
        goto L26
    L18:
        if (type != 2013) goto L21;
        displayContent.mWallpaperController.clearLastWallpaperTimeoutTime();
        displayContent.pendingLayoutChanges |= 4;
        goto L26
    L21:
        if (win.hasWallpaper() == false) goto L24;
        displayContent.pendingLayoutChanges |= 4;
        goto L26
    L24:
        if (displayContent.mWallpaperController.isBelowWallpaperTarget(win) == false) goto L26;
        displayContent.pendingLayoutChanges |= 4;
        goto L26
    }

    private boolean unprivilegedAppCanCreateTokenWith(WindowState parentWindow, int callingUid, int type, int rootType, IBinder tokenForLog, String packageName) {
        if (rootType < 1) goto L11;
        if (rootType > 99) goto L11;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L9;
        String protoLogParam0 = String.valueOf(tokenForLog);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -7315179333005789167L, 0, new Object[]{protoLogParam0});
    L9:
        return false;
    L11:
        if (rootType != 2011) goto L17;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        String protoLogParam1 = String.valueOf(tokenForLog);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -7547709658889961930L, 0, new Object[]{protoLogParam1});
    L15:
        return false;
    L17:
        if (rootType != 2031) goto L23;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L21;
        String protoLogParam2 = String.valueOf(tokenForLog);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 3009864422591182484L, 0, new Object[]{protoLogParam2});
    L21:
        return false;
    L23:
        if (rootType != 2013) goto L29;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L27;
        String protoLogParam3 = String.valueOf(tokenForLog);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -2639914438438144071L, 0, new Object[]{protoLogParam3});
    L27:
        return false;
    L29:
        if (rootType != 2035) goto L35;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L33;
        String protoLogParam4 = String.valueOf(tokenForLog);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -7529563697886120786L, 0, new Object[]{protoLogParam4});
    L33:
        return false;
    L35:
        if (rootType != 2032) goto L41;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L39;
        String protoLogParam5 = String.valueOf(tokenForLog);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 4253401518117961686L, 0, new Object[]{protoLogParam5});
    L39:
        return false;
    L41:
        if (type == 2005) goto L43;
    L48:
        return true;
    L43:
        if (doesAddToastWindowRequireToken(packageName, callingUid, parentWindow) == false) goto L48;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L47;
        String protoLogParam6 = String.valueOf(tokenForLog);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 5834230650841873680L, 0, new Object[]{protoLogParam6});
    L47:
        return false;
    }

    private DisplayContent getDisplayContentOrCreate(int displayId, IBinder token) {
        if (token == null) goto L8;
        WindowToken wToken = this.mRoot.getWindowToken(token);
        if (wToken == null) goto L8;
        return wToken.getDisplayContent();
    L8:
        return this.mRoot.getDisplayContentOrCreate(displayId);
    }

    private boolean doesAddToastWindowRequireToken(String packageName, int callingUid, WindowState attachedWindow) {
        if (attachedWindow != null) goto L5;
        ApplicationInfo appInfo = this.mPmInternal.getApplicationInfo(packageName, 0, 1000, UserHandle.getUserId(callingUid));
        if (appInfo == null) goto L19;
        if (this.mPmInternal.isSameApp(packageName, callingUid, UserHandle.getUserId(callingUid)) == false) goto L19;
        if (appInfo.targetSdkVersion >= 26) goto L17;
        return false;
    L17:
        return true;
    L19:
        throw new SecurityException("Package " + packageName + " not in UID " + callingUid);
    L5:
        if (attachedWindow.mActivityRecord != null) goto L7;
        return false;
    L7:
        if (attachedWindow.mActivityRecord.mTargetSdk >= 26) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean shouldHideNonSystemOverlayWindow(WindowState win) {
        if (this.mHidingNonSystemOverlayWindows.isEmpty() == false) goto L6;
        return false;
    L6:
        if (this.mHidingNonSystemOverlayWindowsCountPerUid.size() == 1) goto L8;
    L10:
        return true;
    L8:
        if (this.mHidingNonSystemOverlayWindowsCountPerUid.containsKey(Integer.valueOf(win.getOwningUid())) == false) goto L10;
        return false;
    }

    public void refreshScreenCaptureDisabled() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != MY_UID) goto L15;
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mRoot.refreshSecureSurfaceState();     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L15:
        throw new SecurityException("Only system can call refreshScreenCaptureDisabled.");
    }

    void removeClientToken(Session session, IBinder client) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = windowForClientLocked(session, client, false);     // Catch: Throwable -> L11
        if (win == null) goto L13;
        win.removeIfPossible();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L13:
        this.mEmbeddedWindowController.remove(client);     // Catch: Throwable -> L11
        if (Features.FEAT_QUICK_WIN == false) goto L16;
        getExt().removeClientToken(client);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void postWindowRemoveCleanupLocked(WindowState win) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(win);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 5265273548711408921L, 0, new Object[]{protoLogParam0});
    L5:
        IBinder client = win.mClient.asBinder();
        this.mWindowMap.remove(client);
        notifyWindowRemovedListeners(client);
        DisplayContent dc = win.getDisplayContent();
        win.resetAppOpsState();
        if (dc == null) goto L9;
        dc.clearScreenshotSourceWindowIfMatch(client);
    L9:
        if (dc.mCurrentFocus != null) goto L11;
        dc.mWinRemovedSinceNullFocus.add(win);
    L11:
        this.mEmbeddedWindowController.onWindowRemoved(win);
        dc.getObricExt().onWindowRemoved(win);
        this.mResizingWindows.remove(win);
        updateNonSystemOverlayWindowsVisibilityIfNeeded(win, false);
        this.mWindowsChanged = true;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_MOVEMENT_enabled[1] == false) goto L14;
        String protoLogParam1 = String.valueOf(win);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, -3847568084407666790L, 0, new Object[]{protoLogParam1});
    L14:
        DisplayContent displayContent = win.getDisplayContent();
        if (displayContent.mInputMethodWindow != win) goto L17;
        displayContent.setInputMethodWindowLocked(null);
    L17:
        WindowToken token = win.mToken;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L20;
        String protoLogParam2 = String.valueOf(win);
        String protoLogParam3 = String.valueOf(token);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 1419572818243106725L, 0, new Object[]{protoLogParam2, protoLogParam3});
    L20:
        getExt().traceRemoveWindow(win);
        if (token.isEmpty() == false) goto L26;
        if (token.mPersistOnEmpty == true) goto L26;
        token.removeIfPossible();
    L26:
        if (win.mActivityRecord == null) goto L29;
        win.mActivityRecord.postWindowRemoveStartingWindowCleanup(win);
    L29:
        if (win.mAttrs.type != 2013) goto L32;
        dc.mWallpaperController.clearLastWallpaperTimeoutTime();
        dc.pendingLayoutChanges |= 4;
    L35:
        if (this.mWindowPlacerLocked.isInLayout() == true) goto L39;
        dc.assignWindowLayers(true);
        this.mWindowPlacerLocked.performSurfacePlacement();
        if (win.mActivityRecord == null) goto L39;
        win.mActivityRecord.updateReportedVisibilityLocked();
    L39:
        dc.getInputMonitor().updateInputWindowsLw(true);
        return;
    L32:
        if (dc.mWallpaperController.isWallpaperTarget(win) == false) goto L35;
        dc.pendingLayoutChanges |= 4;
        goto L35
    }

    private void updateHiddenWhileSuspendedState(ArraySet<String> packages, boolean suspended) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mRoot.updateHiddenWhileSuspendedState(packages, suspended);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private void updateAppOpsState() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mRoot.updateAppOpsState();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    static void logSurface(WindowState w, String msg, boolean withStackTrace) {
        String str = "  SURFACE " + msg + ": " + w;
        if (withStackTrace == false) goto L5;
        logWithStack(TAG, str);
        return;
    L5:
        Slog.i(TAG, str);
    }

    static void logWithStack(String tag, String s) {
        RuntimeException e = null;
        if (WindowManagerDebugConfig.SHOW_STACK_CRAWLS == false) goto L5;
        e = new RuntimeException();
        e.fillInStackTrace();
    L5:
        Slog.i(tag, s, e);
    }

    void clearTouchableRegion(Session session, IWindow client) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L11
        boostPriorityForLockedSection();     // Catch: Throwable -> L11
        monitor-enter(r2);     // Catch: Throwable -> L11
        WindowState w = windowForClientLocked(session, client, false);     // Catch: Throwable -> L13
        w.clearClientTouchableRegion();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(origId);
        return;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    void setInsetsWindow(Session session, IWindow client, int touchableInsets, Rect contentInsets, Rect visibleInsets, Region touchableRegion) {
        int uid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L37
        boostPriorityForLockedSection();     // Catch: Throwable -> L37
        monitor-enter(r3);     // Catch: Throwable -> L37
        WindowState w = windowForClientLocked(session, client, false);     // Catch: Throwable -> L9
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L11;
        Slog.d(TAG, "setInsetsWindow " + w + ", contentInsets=" + w.mGivenContentInsets + " -> " + contentInsets + ", visibleInsets=" + w.mGivenVisibleInsets + " -> " + visibleInsets + ", touchableRegion=" + w.mGivenTouchableRegion + " -> " + touchableRegion + ", touchableInsets " + w.mTouchableInsets + " -> " + touchableInsets);     // Catch: Throwable -> L9
    L11:
        if (w == null) goto L33;
        boolean wasGivenInsetsPending = w.mGivenInsetsPending;     // Catch: Throwable -> L9
        w.mGivenInsetsPending = false;     // Catch: Throwable -> L9
        if (wasGivenInsetsPending == false) goto L17;
        if (w.hasInsetsSourceProvider() == false) goto L17;
    L27:
        w.mGivenContentInsets.set(contentInsets);     // Catch: Throwable -> L9
        w.mGivenVisibleInsets.set(visibleInsets);     // Catch: Throwable -> L9
        w.mGivenTouchableRegion.set(touchableRegion);     // Catch: Throwable -> L9
        w.mTouchableInsets = touchableInsets;     // Catch: Throwable -> L9
        if (w.mGlobalScale == 1.0f) goto L30;
        w.mGivenContentInsets.scale(w.mGlobalScale);     // Catch: Throwable -> L9
        w.mGivenVisibleInsets.scale(w.mGlobalScale);     // Catch: Throwable -> L9
        w.mGivenTouchableRegion.scale(w.mGlobalScale);     // Catch: Throwable -> L9
    L30:
        w.setDisplayLayoutNeeded();     // Catch: Throwable -> L9
        w.updateSourceFrame(w.getFrame());     // Catch: Throwable -> L9
        this.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L9
        w.getDisplayContent().getInputMonitor().updateInputWindowsLw(true);     // Catch: Throwable -> L9
        if (this.mAccessibilityController.hasCallbacks() == false) goto L33;
        this.mAccessibilityController.onSomeWindowResizedOrMovedWithCallingUid(uid, new int[]{w.getDisplayContent().getDisplayId()});     // Catch: Throwable -> L9
    L17:
        if (w.mTouchableInsets != touchableInsets) goto L27;
        if (w.mGivenContentInsets.equals(contentInsets) == false) goto L27;
        if (w.mGivenVisibleInsets.equals(visibleInsets) == false) goto L27;
        if (w.mGivenTouchableRegion.equals(touchableRegion) == false) goto L27;
        monitor-exit(r3);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L33:
        monitor-exit(r3);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L37
        Binder.restoreCallingIdentity(origId);
        return;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void onRectangleOnScreenRequested(IBinder token, Rect rectangle) {
        AccessibilityController.AccessibilityControllerInternalImpl a11yControllerInternal = AccessibilityController.getAccessibilityControllerInternal(this);
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (a11yControllerInternal.hasWindowManagerEventDispatcher() == false) goto L11;
        WindowState window = this.mWindowMap.get(token);     // Catch: Throwable -> L9
        if (window == null) goto L11;
        a11yControllerInternal.onRectangleOnScreenRequested(window.getDisplayId(), rectangle);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
    }

    public IWindowId getWindowId(IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState window = this.mWindowMap.get(token);     // Catch: Throwable -> L7
        if (window == null) goto L9;
        WindowState.WindowId r2 = window.mWindowId;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void pokeDrawLock(Session session, IBinder token) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState window = windowForClientLocked(session, token, false);     // Catch: Throwable -> L8
        if (window == null) goto L10;
        window.pokeDrawLockLw(this.mDrawLockTimeoutMillis);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private boolean hasStatusBarPermission(int pid, int uid) {
        if (this.mContext.checkPermission("android.permission.STATUS_BAR", pid, uid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean cancelDraw(Session session, IWindow client) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = windowForClientLocked(session, client, false);     // Catch: Throwable -> L10
        if (win != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return false;
    L12:
        boolean r1 = win.cancelAndRedraw();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r1;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int relayoutWindow(Session r49, IWindow r50, WindowManager.LayoutParams r51, int r52, int r53, int r54, int r55, int r56, int r57, WindowRelayoutResult r58) {
        if (r58 == null) goto L5;
        ClientWindowFrames r0 = r58.frames;
        MergedConfiguration r2 = r58.mergedConfiguration;
        SurfaceControl r3 = r58.surfaceControl;
        InsetsState r4 = r58.insetsState;
        ClientWindowFrames r16 = r0;
        MergedConfiguration r17 = r2;
        SurfaceControl r15 = r3;
        InsetsSourceControl.Array r5 = r58.activeControls;
    L7:
        if (r5 == null) goto L10;
        r5.set(null, false);
    L10:
        if (StabTrace.isEnable() == false) goto L12;
        long r22 = Process.getCpuClocks();
    L13:
        boolean r26 = false;
        int r6 = Binder.getCallingPid();
        int r27 = 0;
        int r7 = Binder.getCallingUid();
        long r28 = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r8 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r8);
        InsetsSourceControl.Array r31 = r5;
        WindowState r19 = windowForClientLocked(r49, r50, false);     // Catch: Throwable -> L598
        if (r19 == null) goto L20;
    L595:
        th = th;
    L597:
        WindowManagerGlobalLock r30 = r8;
    L651:
        monitor-exit(r30);     // Catch: Throwable -> L603
        resetPriorityAfterLockedSection();
        throw th;
    L603:
        th = th;
        goto L651
    L36:
        if (r19.mRelayoutSeq >= r56) goto L40;
        r19.mRelayoutSeq = r56;     // Catch: Throwable -> L24
        int r32 = 0;
    L57:
        if (r19.cancelAndRedraw() == true) goto L59;
    L61:
        DisplayContent r1 = r19.getDisplayContent();     // Catch: Throwable -> L595
        DisplayPolicy r110 = r1.getDisplayPolicy();     // Catch: Throwable -> L595
        WindowStateAnimator r9 = r19.mWinAnimator;     // Catch: Throwable -> L595
        if (r54 == 8) goto L66;
        r19.setRequestedSize(r52, r53);     // Catch: Throwable -> L24
    L66:
        if (r51 != null) goto L666;
        WindowStateAnimator r13 = r9;
        InsetsState r38 = r4;
        int r34 = r6;
        DisplayContent r14 = r1;
        InsetsSourceControl.Array r37 = r31;
        DisplayPolicy r36 = r110;
        WindowManagerService r10 = this;
        WindowState r11 = r19;
        int r33 = r32;
        r30 = r8;
        int r12 = 0;
        int r18 = 0;
    L675:
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L657;
        Slog.v(TAG, "Relayout " + r11 + ": viewVisibility=" + r54 + " req=" + r52 + "x" + r53 + " " + r11.mAttrs);     // Catch: Throwable -> L227
    L227:
        th = th;
    L657:
    L591:
        th = th;
        goto L651
    L232:
        if (r11.getActivityRecord() != null) goto L234;
    L259:
        int r111 = 4;
    L261:
        if ((r12 & 128) == 0) goto L263;
        r13.mAlpha = r51.alpha;     // Catch: Throwable -> L227
    L263:
        r11.setWindowScale(r11.mRequestedWidth, r11.mRequestedHeight);     // Catch: Throwable -> L591
        if (r11.mAttrs.surfaceInsets.left != 0) goto L272;
        if (r11.mAttrs.surfaceInsets.top != 0) goto L272;
        if (r11.mAttrs.surfaceInsets.right != 0) goto L272;
        if (r11.mAttrs.surfaceInsets.bottom != 0) goto L272;
    L273:
        int r20 = r11.mViewVisibility;     // Catch: Throwable -> L591
        if (r20 != r111) goto L276;
    L277:
        if (r54 != 0) goto L279;
        boolean r21 = true;
    L280:
        boolean r35 = r21;
        if ((131080 & r18) != 0) goto L285;
        if (r35 == true) goto L285;
        boolean r23 = false;
    L287:
        if (r11.mViewVisibility == r54) goto L289;
    L294:
        boolean r24 = true;
    L297:
        if (r11.mViewVisibility != r54) goto L299;
    L301:
        boolean r25 = false;
    L303:
        if ((r18 & 1048576) == 0) goto L305;
        boolean r29 = true;
    L306:
        boolean r39 = r25 | r29;
        if (r10.getExt() == null) goto L313;
        r39 = r39 | r10.getExt().isNeedRedoWallpaperLayout(r11, r54, r10.mPolicy.isKeyguardShowing());
    L313:
        r10.getExt().traceRelayoutWindow(r11, r39, r54);     // Catch: Throwable -> L591
        if ((r18 & 8192) == 0) goto L317;
        r11.setSecureLocked(r11.isSecureLocked());     // Catch: Throwable -> L227
    L317:
        boolean r40 = r11.isVisible();     // Catch: Throwable -> L591
        boolean r42 = r39;
        r11.mRelayoutCalled = true;     // Catch: Throwable -> L591
        r11.mInRelayout = true;     // Catch: Throwable -> L591
        r11.setViewVisibility(r54);     // Catch: Throwable -> L591
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[2] == false) goto L321;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, 8312693933819247897L, 20, new Object[]{String.valueOf(r11), Long.valueOf(r20), Long.valueOf(r54), String.valueOf(new RuntimeException().fillInStackTrace())});     // Catch: Throwable -> L227
    L321:
        if (r35 == false) goto L323;
        r10.onWindowVisible(r11);     // Catch: Throwable -> L227
    L323:
        r11.setDisplayLayoutNeeded();     // Catch: Throwable -> L591
        if ((r55 & 1) == 0) goto L326;
        boolean r41 = true;
    L327:
        r11.mGivenInsetsPending = r41;     // Catch: Throwable -> L591
        if (r54 == 0) goto L331;
    L337:
        boolean r210 = false;
    L338:
        boolean r43 = r210;
        if (r43 == false) goto L341;
    L354:
        r27 = r27;
    L355:
        if (r43 == false) goto L390;
        if (r15 == null) goto L390;
        int r44 = r10.createSurfaceControl(r15, r27, r11, r13);     // Catch: Throwable -> L350 Exception -> L359
    L350:
        th = th;
    L636:
        r10.mWindowPlacerLocked.performSurfacePlacement(true);     // Catch: Throwable -> L589
        if (r11.mHaveFrame == true) goto L399;
    L396:
        th = th;
        goto L651
    L394:
        if (r14.mWaitingForConfig == false) goto L399;
        r11.mLayoutSeq = r14.mLayoutSeq;     // Catch: Throwable -> L396
    L399:
        if (r43 == 0) goto L415;
        Trace.traceBegin(32, "relayoutWindow: viewVisibility_1");     // Catch: Throwable -> L396
        int r45 = r11.relayoutVisibleWindow(r44);     // Catch: Throwable -> L396
        if ((r45 & 1) == 0) goto L404;
        boolean r46 = true;
    L634:
    L410:
        th = th;
        goto L651
    L406:
        if (r11.mAttrs.type == 2011) goto L408;
    L412:
        r11.adjustStartingWindowFlags();     // Catch: Throwable -> L410
        Trace.traceEnd(32);     // Catch: Throwable -> L410
        r44 = r45;
        r24 = r46;
    L431:
        if (r24 == true) goto L434;
    L436:
        boolean r47 = false;
    L438:
        if ((r44 & 1) == 0) goto L440;
        boolean r48 = true;
    L441:
        boolean r112 = r48;
        if (r23 == true) goto L617;
    L449:
        if (r42 == false) goto L615;
        r14.pendingLayoutChanges |= 4;     // Catch: Throwable -> L447
    L615:
        if (r11.mActivityRecord == null) goto L455;
        r14.mUnknownAppVisibilityController.notifyRelayouted(r11.mActivityRecord);     // Catch: Throwable -> L447
    L447:
        th = th;
    L455:
        int r59 = r44;
        Trace.traceBegin(32, "relayoutWindow: updateOrientation");     // Catch: Throwable -> L585
        boolean r211 = r26 | r14.updateOrientation();     // Catch: Throwable -> L585
        Trace.traceEnd(32);     // Catch: Throwable -> L585
        if (r112 == false) goto L465;
    L462:
        th = th;
        goto L651
    L459:
        if (r11.mIsWallpaper == false) goto L465;
        r14.mWallpaperController.updateWallpaperOffset(r11, false);     // Catch: Throwable -> L462
    L465:
        if (r11.mActivityRecord == null) goto L467;
        r11.mActivityRecord.updateReportedVisibilityLocked();     // Catch: Throwable -> L462
    L467:
        if (r36.areSystemBarsForcedConsumedLw() == false) goto L470;
        r59 = r59 | 8;
    L470:
        if (r16 == null) goto L495;
        if (r17 == null) goto L495;
        if (r58 != null) goto L474;
    L476:
        boolean r60 = false;
    L478:
        if (r60 == false) goto L481;
        ActivityWindowInfo r113 = new ActivityWindowInfo();     // Catch: Throwable -> L462
    L482:
        WindowState r114 = r11;
        r114.fillClientWindowFramesAndConfiguration(r16, r17, r113, false, r43);     // Catch: Throwable -> L493
        WindowState r61 = r114;
        ActivityWindowInfo r62 = r113;
        if (r60 == false) goto L490;
        WindowRelayoutResult r63 = r58;
        r63.activityWindowInfo = r62;     // Catch: Throwable -> L488
    L491:
        r61.onResizeHandled();     // Catch: Throwable -> L488
    L496:
        InsetsState r64 = r38;
        if (r64 != null) goto L638;
    L661:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == true) goto L673;
        int r115 = r59;
    L632:
    L581:
        th = th;
        goto L651
    L519:
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L522;
        Slog.v(TAG, "Relayout complete " + r61 + ": outFrames=" + r16);     // Catch: Throwable -> L511
    L511:
        th = th;
    L522:
        r61.mInRelayout = false;     // Catch: Throwable -> L581
        if (r61.isVisible() == r40) goto L525;
        boolean r65 = true;
    L526:
        boolean r66 = r65;
        if (r61.isImeOverlayLayeringTarget() == false) goto L537;
        if (r66 == false) goto L537;
        IBinder r67 = r50.asBinder();     // Catch: Throwable -> L535
        int r68 = r61.mAttrs.type;     // Catch: Throwable -> L535
        boolean r69 = r61.isVisible();     // Catch: Throwable -> L535
        int r70 = r61.getDisplayId();     // Catch: Throwable -> L535
        int r116 = r115;
        WindowManagerService r71 = this;
        r71.dispatchImeTargetOverlayVisibilityChanged(r67, r68, r69, false, r70);     // Catch: Throwable -> L533
    L619:
        WindowState r72 = r61;
        if (r61.getDisplayContent().getImeInputTarget() != r72) goto L542;
        boolean r73 = true;
    L543:
        if (r73 == false) goto L548;
        if (r66 == false) goto L548;
        r71.dispatchImeInputTargetVisibilityChanged(r72.mClient.asBinder(), r72.isVisible(), false, r72.getDisplayId());     // Catch: Throwable -> L533
    L548:
        if (r58 == 0) goto L567;
        int r74 = -1;
        if (r72.syncNextBuffer() == false) goto L565;
        if (r54 != 0) goto L565;
        if (r72.mSyncSeqId <= r57) goto L565;
        if (r14.mWaitingForConfig == true) goto L565;
        if (r72.shouldSyncWithBuffers() == false) goto L561;
        r74 = r72.mSyncSeqId;     // Catch: Throwable -> L533
    L561:
        r58.syncSeqId = r74;     // Catch: Throwable -> L533
        r72.markRedrawForSyncReported();     // Catch: Throwable -> L533
    L565:
        r58.syncSeqId = -1;     // Catch: Throwable -> L533
    L562:
        th = th;
    L567:
        if (r211 == false) goto L569;
        Trace.traceBegin(32, "relayoutWindow: postNewConfigurationToHandler");     // Catch: Throwable -> L533
        r14.sendNewConfiguration();     // Catch: Throwable -> L533
        Trace.traceEnd(32);     // Catch: Throwable -> L533
    L569:
        InsetsSourceControl.Array r75 = r37;
        if (r75 != null) goto L613;
    L574:
        monitor-exit(r30);     // Catch: Throwable -> L572
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(r28);
        if (StabTrace.isEnable() == false) goto L578;
        StabTrace.traceInfo(16, "relayout:callPid=" + r34 + ",res=" + r116 + "updateFocus=" + r47 + "seq=" + r56, r22, Process.getCpuClocks());
    L578:
        return r116;
    L572:
        th = th;
        goto L651
    L613:
        r71.getInsetsSourceControls(r72, r75);     // Catch: Throwable -> L572
        goto L574
    L542:
        r73 = false;
    L579:
        th = th;
    L533:
        th = th;
    L535:
        th = th;
    L537:
        r116 = r115;
        r71 = this;
        goto L619
    L525:
        r65 = false;
        goto L526
    L673:
        r115 = r59;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, 212929172223901460L, 12, new Object[]{String.valueOf(r61), Boolean.valueOf(r24)});     // Catch: Throwable -> L511
    L513:
        th = th;
    L515:
        th = th;
    L583:
        th = th;
        goto L651
    L638:
        r61.fillInsetsState(r64, true);     // Catch: Throwable -> L501
    L501:
        th = th;
    L488:
        th = th;
        goto L651
    L490:
        r63 = r58;
    L493:
        th = th;
        goto L651
    L481:
        r113 = null;
        goto L482
    L474:
        if (r11.mLastReportedActivityWindowInfo == null) goto L476;
        r60 = true;
    L495:
        r63 = r58;
        r61 = r11;
    L585:
        th = th;
    L587:
        th = th;
        goto L651
    L617:
        r14.computeImeTarget(true);     // Catch: Throwable -> L447
        if (r112 == false) goto L449;
        r14.assignWindowLayers(false);     // Catch: Throwable -> L447
        goto L449
    L440:
        r48 = false;
        goto L441
    L434:
        if (r10.updateFocusedWindowLocked(0, true) == false) goto L436;
        r23 = false;
        r47 = true;
        goto L438
    L408:
        if (r14.mInputMethodWindow != null) goto L412;
        r14.setInputMethodWindowLocked(r11);     // Catch: Throwable -> L410
        r23 = true;
        goto L412
    L404:
        r46 = r24;
        goto L634
    L415:
        Trace.traceBegin(32, "relayoutWindow: viewVisibility_2");     // Catch: Throwable -> L589
        r13.mEnterAnimationPending = false;     // Catch: Throwable -> L589
        r13.mEnteringAnimation = false;     // Catch: Throwable -> L589
        if (r15 == null) goto L430;
        if (r54 != 0) goto L422;
        if (r13.hasSurface() == false) goto L422;
        Trace.traceBegin(32, "relayoutWindow: getSurface");     // Catch: Throwable -> L396
        r13.getSurfaceControl(r15);     // Catch: Throwable -> L396
        Trace.traceEnd(32);     // Catch: Throwable -> L396
    L422:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L630;
        Slog.i(TAG, "Releasing surface in: " + r11);     // Catch: Throwable -> L396
    L630:
        Trace.traceBegin(32, "wmReleaseOutSurface_" + r11.mAttrs.getTitle());     // Catch: Throwable -> L426
        r15.release();     // Catch: Throwable -> L426
        Trace.traceEnd(32);     // Catch: Throwable -> L396
        goto L430
    L426:
        th = move-exception;
        Trace.traceEnd(32);     // Catch: Throwable -> L396
        throw th;     // Catch: Throwable -> L396
    L430:
        Trace.traceEnd(32);     // Catch: Throwable -> L589
    L589:
        th = th;
    L359:
        e = move-exception;
        r14.getInputMonitor().updateInputWindowsLw(true);     // Catch: Throwable -> L388
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L369;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 8319702790708803735L, 0, new Object[]{String.valueOf(r50), String.valueOf(r11.mAttrs.getTitle()), String.valueOf(e)});     // Catch: Throwable -> L227
    L365:
        th = th;
    L369:
        Binder.restoreCallingIdentity(r28);     // Catch: Throwable -> L227
        if (StabTrace.isEnable() == false) goto L385;
        StringBuilder r76 = new StringBuilder();     // Catch: Throwable -> L227
        r76.append("relayoutWindow:fail creating surface:");     // Catch: Throwable -> L227
        r76.append(r11.getWindowTag());     // Catch: Throwable -> L227
        r76.append("callPid=");     // Catch: Throwable -> L227
        if (r49 == null) goto L374;
        Object r77 = Integer.valueOf(r49.mPid);     // Catch: Throwable -> L227
    L375:
        r76.append(r77);     // Catch: Throwable -> L227
        r76.append("CallUid=");     // Catch: Throwable -> L227
        if (r49 == null) goto L378;
        Object r78 = Integer.valueOf(r49.mUid);     // Catch: Throwable -> L227
    L379:
        r76.append(r78);     // Catch: Throwable -> L227
        r76.append("seq=");     // Catch: Throwable -> L227
        r76.append(r56);     // Catch: Throwable -> L382
        StabTrace.traceInfo(16, r76.toString(), r22, Process.getCpuClocks());     // Catch: Throwable -> L382
    L382:
        th = th;
        goto L651
    L378:
        r78 = "0";
        goto L379
    L374:
        r77 = "0";
    L385:
        resetPriorityAfterLockedSection();
        return 0;
    L388:
        th = th;
    L390:
        r44 = r27;
        goto L636
    L341:
        if (r13.hasSurface() == false) goto L354;
        if (r11.mAnimatingExit == true) goto L354;
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L347;
        Slog.i(TAG, "Relayout invis " + r11 + ": mAnimatingExit=" + r11.mAnimatingExit);     // Catch: Throwable -> L227
    L347:
        r27 = r27 | 2;
        if (r42 == true) goto L625;
    L352:
        r10.tryStartExitingAnimation(r11, r13);     // Catch: Throwable -> L350
        goto L355
    L625:
        r14.mWallpaperController.adjustWallpaperWindows();     // Catch: Throwable -> L350
        goto L352
    L331:
        if (r11.mActivityRecord != null) goto L333;
    L336:
        r210 = true;
        goto L338
    L333:
        if (r11.mAttrs.type == 3) goto L336;
        if (r11.mActivityRecord.isClientVisible() == false) goto L337;
    L326:
        r41 = false;
        goto L327
    L305:
        r29 = false;
        goto L306
    L299:
        if (r11.hasWallpaper() == false) goto L301;
        r25 = true;
        goto L303
    L289:
        if ((r18 & 8) != 0) goto L294;
        if (r11.mRelayoutCalled == false) goto L294;
        r24 = false;
    L285:
        r23 = true;
    L279:
        r21 = false;
        goto L280
    L276:
        if (r20 != 8) goto L279;
    L272:
        r13.setOpaqueLocked(r33);     // Catch: Throwable -> L591
        goto L273
    L234:
        if (r11.mAttrs == null) goto L259;
        r111 = 4;
        if (r11.mAttrs.type != 1) goto L238;
    L239:
        Configuration r79 = r11.getConfiguration();     // Catch: Throwable -> L227
        if (r79 != null) goto L242;
        boolean r410 = 0;
    L247:
        boolean r80 = r14.isDefaultDisplay;     // Catch: Throwable -> L227
        if ((r11.mAttrs.flags & 1024) != 0) goto L253;
        if ((r11.mAttrs.subtreeSystemUiVisibility & 4) != 0) goto L253;
        boolean r411 = r33;
    L255:
        if ((r11.mAttrs.flags & 2) == 0) goto L257;
        boolean r412 = 1;
    L258:
        SysOptBridge.getFactory().getOAutoHelper().onAppRelayoutWindow(r11.getActivityRecord().mActivityComponent, r80, r411, r412, r410);     // Catch: Throwable -> L227
        goto L261
    L257:
        r412 = r33;
    L253:
        r411 = 1;
        goto L255
    L242:
        if (r79.orientation != 2) goto L244;
        int r81 = 1;
    L245:
        r410 = r81;
        goto L247
    L244:
        r81 = r33;
        goto L245
    L238:
        if (r11.mAttrs.type != 2) goto L261;
    L593:
        th = th;
        goto L651
    L666:
        r110.adjustWindowParamsLw(r19, r51);     // Catch: Throwable -> L220
        r36 = r110;
        r14 = r1;
        r37 = r31;
        WindowStateAnimator r117 = r9;
        r38 = r4;
        r33 = r32;
        r30 = r8;
        WindowManagerService r82 = this;
        int r83 = r7;
        r51.privateFlags = r82.sanitizePrivateFlags(r51.privateFlags, r19.mAttrs.privateFlags, r19.getName(), r7, r6);     // Catch: Throwable -> L214
        r51.flags = r82.sanitizeFlagSlippery(r51.flags, r19.getName(), r83, r6);     // Catch: Throwable -> L214
        int r84 = r6;
        r51.inputFeatures = r82.sanitizeInputFeatures(r51.inputFeatures, r19.getName(), r83, r6, r19.isTrustedOverlay());     // Catch: Throwable -> L134
        int r85 = (r51.systemUiVisibility | r51.subtreeSystemUiVisibility) & 134152192;
        if (r85 != 0) goto L609;
    L84:
        r11 = r19;
        r11.mDisableFlags = r85;     // Catch: Throwable -> L134
        if (r11.mAttrs.type != r51.type) goto L213;
        if (r11.mAttrs.providedInsets != null) goto L94;
        if (r51.providedInsets != null) goto L94;
        r34 = r84;
    L137:
        boolean r86 = r11.isWindowTrustedOverlay();     // Catch: Throwable -> L122
        int r87 = r11.mAttrs.flags ^ r51.flags;     // Catch: Throwable -> L122
        int r88 = r11.mAttrs.privateFlags ^ r51.privateFlags;     // Catch: Throwable -> L122
        int r89 = r11.mAttrs.copyFrom(r51);     // Catch: Throwable -> L122
        if ((r89 & 1) == 0) goto L140;
        int r118 = 1;
    L141:
        int r310 = r118;
        if (r310 != 0) goto L146;
        int r413 = r87;
        if ((r89 & 16384) != 0) goto L147;
    L148:
        if (r310 == 0) goto L153;
        if (r11.providesDisplayDecorInsets() == false) goto L153;
        r26 = r36.updateDecorInsetsInfo();     // Catch: Throwable -> L122
    L153:
        if (r86 == r11.isWindowTrustedOverlay()) goto L156;
        r11.updateTrustedOverlay();     // Catch: Throwable -> L122
    L156:
        if (r11.mActivityRecord == null) goto L163;
        if ((r413 & 524288) == 0) goto L160;
    L161:
        r11.mActivityRecord.checkKeyguardFlagsChanged();     // Catch: Throwable -> L122
        goto L163
    L160:
        if ((r413 & 4194304) != 0) goto L161;
    L163:
        if ((r88 & 524288) == 0) goto L166;
        r82.updateNonSystemOverlayWindowsVisibilityIfNeeded(r11, r11.mWinAnimator.getShown());     // Catch: Throwable -> L122
    L166:
        if ((131072 & r89) == 0) goto L173;
        if ((r11.mAttrs.privateFlags & 16777216) == 0) goto L170;
        boolean r90 = 1;
    L171:
        r117.setColorSpaceAgnosticLocked(r90);     // Catch: Throwable -> L122
        goto L173
    L170:
        r90 = r33;
    L173:
        if (r14.mDwpcHelper.hasController() == false) goto L208;
        if (r11.mActivityRecord == null) goto L208;
        if (r11.mRelayoutCalled == false) goto L183;
        if (r413 != 0) goto L183;
        if (r88 == 0) goto L208;
    L183:
        if (r11.mRelayoutCalled == true) goto L185;
        int r91 = r11.mAttrs.flags;     // Catch: Throwable -> L122
    L186:
        int r414 = r91;
        if (r11.mRelayoutCalled == true) goto L189;
        int r415 = r11.mAttrs.privateFlags;     // Catch: Throwable -> L122
    L191:
        if (r14.mDwpcHelper.keepActivityOnWindowFlagsChanged(r11.mActivityRecord.info, r414, r415, r11.mAttrs.flags, r11.mAttrs.privateFlags) == true) goto L208;
        r82.mH.sendMessage(r82.mH.obtainMessage(65, r11.mActivityRecord.getTask()));     // Catch: Throwable -> L122
        Slog.w(TAG, "Activity " + r11.mActivityRecord + " window flag changed, can't remain on display " + r14.getDisplayId());     // Catch: Throwable -> L122
        if (StabTrace.isEnable() == false) goto L203;
        StringBuilder r92 = new StringBuilder();     // Catch: Throwable -> L122
        r92.append("relayoutWindow fail:");     // Catch: Throwable -> L122
        r92.append(r11.getWindowTag());     // Catch: Throwable -> L122
        r92.append("callPid=");     // Catch: Throwable -> L122
        if (r49 == null) goto L197;
        Object r93 = Integer.valueOf(r49.mPid);     // Catch: Throwable -> L122
    L198:
        r92.append(r93);     // Catch: Throwable -> L122
        r92.append("CallUid=");     // Catch: Throwable -> L122
        if (r49 == null) goto L201;
        Object r94 = Integer.valueOf(r49.mUid);     // Catch: Throwable -> L122
    L202:
        r92.append(r94);     // Catch: Throwable -> L122
        r92.append("seq=");     // Catch: Throwable -> L122
        r92.append(r56);     // Catch: Throwable -> L122
        StabTrace.traceInfo(16, r92.toString(), r22, Process.getCpuClocks());     // Catch: Throwable -> L122
        goto L203
    L201:
        r94 = "0";
        goto L202
    L197:
        r93 = "0";
    L203:
        monitor-exit(r30);     // Catch: Throwable -> L122
        resetPriorityAfterLockedSection();
        return r33;
    L189:
        r415 = r88;
        goto L191
    L185:
        r91 = r413;
    L208:
        r12 = r89;
        r18 = r413;
        r10 = r82;
        r13 = r117;
    L147:
        r11.mLayoutNeeded = true;     // Catch: Throwable -> L122
        goto L148
    L146:
        r413 = r87;
        goto L147
    L140:
        r118 = r33;
    L82:
        th = th;
    L94:
        if (r11.mAttrs.providedInsets == null) goto L211;
        if (r51.providedInsets == null) goto L211;
        if (r11.mAttrs.providedInsets.length != r51.providedInsets.length) goto L211;
        int r95 = r51.providedInsets.length;     // Catch: Throwable -> L134
        int r96 = 0;
    L100:
        if (r96 >= r95) goto L136;
        int r119 = r95;
        int r311 = r84;
    L130:
        th = th;
        goto L651
    L104:
        if (r11.mAttrs.providedInsets[r96].idEquals(r51.providedInsets[r96]) == false) goto L133;
        InsetsFrameProvider.InsetsSizeOverride[] r97 = r11.mAttrs.providedInsets[r96].getInsetsSizeOverrides();     // Catch: Throwable -> L130
        InsetsFrameProvider.InsetsSizeOverride[] r98 = r51.providedInsets[r96].getInsetsSizeOverrides();     // Catch: Throwable -> L130
        if (r97 != null) goto L110;
        if (r98 != null) goto L110;
    L125:
        r96 = r96 + 1;     // Catch: Throwable -> L122
        r95 = r119;
        r84 = r311;
        r83 = r83;
    L110:
        if (r97 == null) goto L129;
        if (r98 == null) goto L129;
        if (r97.length != r98.length) goto L129;
        int r99 = r97.length;     // Catch: Throwable -> L122
        int r100 = 0;
    L116:
        if (r100 >= r99) goto L125;
        InsetsFrameProvider.InsetsSizeOverride[] r416 = r97;
        InsetsFrameProvider.InsetsSizeOverride[] r417 = r98;
        if (r97[r100].getWindowType() != r98[r100].getWindowType()) goto L121;
        r100 = r100 + 1;     // Catch: Throwable -> L122
        r97 = r416;
        r98 = r417;
        goto L116
    L121:
        throw new IllegalArgumentException("Insets override types can not be changed after the window is added.");     // Catch: Throwable -> L122
    L129:
        throw new IllegalArgumentException("Insets override types can not be changed after the window is added.");     // Catch: Throwable -> L122
    L133:
        throw new IllegalArgumentException("Insets ID can not be changed after the window is added.");     // Catch: Throwable -> L122
    L136:
        r34 = r84;
    L211:
        throw new IllegalArgumentException("Insets amount can not be changed after the window is added.");     // Catch: Throwable -> L122
    L213:
        throw new IllegalArgumentException("Window type can not be changed after the window is added.");     // Catch: Throwable -> L122
    L122:
        th = th;
        goto L651
    L609:
        if (r82.hasStatusBarPermission(r84, r83) == true) goto L84;
        r85 = 0;
    L134:
        th = th;
    L214:
        th = th;
    L216:
        th = th;
    L218:
        th = th;
        r30 = r8;
    L220:
        th = th;
        r30 = r8;
        goto L651
    L59:
        if (r19.mPrepareSyncSeqId > r57) goto L61;
        r27 = 0 | 16;
        goto L61
    L40:
        if (r19.mRelayoutSeq > r56) goto L42;
        r32 = 0;
        goto L57
    L42:
        if (StabTrace.isEnable() == false) goto L52;
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L24
        r101.append("relayoutWindow:fail:");     // Catch: Throwable -> L24
        r101.append(r19.getWindowTag());     // Catch: Throwable -> L24
        r101.append("callPid=");     // Catch: Throwable -> L24
        if (r49 == null) goto L46;
        Object r102 = Integer.valueOf(r49.mPid);     // Catch: Throwable -> L24
    L47:
        r101.append(r102);     // Catch: Throwable -> L24
        r101.append("CallUid=");     // Catch: Throwable -> L24
        if (r49 == null) goto L50;
        Object r103 = Integer.valueOf(r49.mUid);     // Catch: Throwable -> L24
    L51:
        r101.append(r103);     // Catch: Throwable -> L24
        r101.append("seq=");     // Catch: Throwable -> L24
        r101.append(r56);     // Catch: Throwable -> L24
        r101.append("relayoutSeq=");     // Catch: Throwable -> L24
        r101.append(r19.mRelayoutSeq);     // Catch: Throwable -> L24
        StabTrace.traceInfo(16, r101.toString(), r22, Process.getCpuClocks());     // Catch: Throwable -> L24
        goto L52
    L50:
        r103 = "0";
        goto L51
    L46:
        r102 = "0";
    L52:
        monitor-exit(r8);     // Catch: Throwable -> L24
        resetPriorityAfterLockedSection();
        return 0;
    L20:
        if (StabTrace.isEnable() == false) goto L32;
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L24
        r104.append("relayoutWindow:fail look window callPid=");     // Catch: Throwable -> L24
        if (r49 == null) goto L26;
        Object r105 = Integer.valueOf(r49.mPid);     // Catch: Throwable -> L24
    L27:
        r104.append(r105);     // Catch: Throwable -> L24
        r104.append("CallUid=");     // Catch: Throwable -> L24
        if (r49 == null) goto L30;
        Object r106 = Integer.valueOf(r49.mUid);     // Catch: Throwable -> L24
    L31:
        r104.append(r106);     // Catch: Throwable -> L24
        r104.append("seq=");     // Catch: Throwable -> L24
        r104.append(r56);     // Catch: Throwable -> L24
        r104.append("lastSyncSeqId=");     // Catch: Throwable -> L24
        r104.append(r57);     // Catch: Throwable -> L24
        StabTrace.traceInfo(16, r104.toString(), r22, Process.getCpuClocks());     // Catch: Throwable -> L24
        goto L32
    L30:
        r106 = "0";
        goto L31
    L26:
        r105 = "0";
    L32:
        monitor-exit(r8);     // Catch: Throwable -> L24
        resetPriorityAfterLockedSection();
        return 0;
    L24:
        th = th;
        r30 = r8;
    L598:
        th = th;
        goto L597
    L12:
        r22 = 0;
        goto L13
    L5:
        r4 = null;
        r16 = null;
        r17 = null;
        r15 = null;
        r5 = null;
        goto L7
    }

    private void getInsetsSourceControls(WindowState win, InsetsSourceControl.Array outArray) {
        win.fillInsetsSourceControls(outArray, true);
        outArray.setParcelableFlags(1);
    }

    private void tryStartExitingAnimation(WindowState win, WindowStateAnimator winAnimator) {
        int transit = 2;
        if (win.mAttrs.type != 3) goto L6;
        transit = 5;
    L6:
        if (win.isVisible() == false) goto L32;
        if (win.isDisplayed() == false) goto L32;
        if (win.mDisplayContent.okToAnimate() == false) goto L32;
        String reason = null;
        if (winAnimator.applyAnimationLocked(transit, false) == false) goto L15;
        reason = "applyAnimation";
    L27:
        if (reason == null) goto L32;
        win.mAnimatingExit = true;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[0] == false) goto L32;
        String protoLogParam0 = String.valueOf(reason);
        String protoLogParam1 = String.valueOf(win);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ANIM, -255991894956556845L, 0, new Object[]{protoLogParam0, protoLogParam1});
        goto L32
    L15:
        if (win.isSelfAnimating(0, 16) == false) goto L18;
        reason = "selfAnimating";
        goto L27
    L18:
        if (win.mTransitionController.isShellTransitionsEnabled() == false) goto L25;
        if (win.mActivityRecord == null) goto L27;
        if (win.mActivityRecord.inTransition() == false) goto L27;
        win.mTransitionController.mAnimatingExitWindows.add(win);
        reason = "inTransition";
        goto L27
    L25:
        if (win.isAnimating(3, 1) == false) goto L27;
        reason = "inLegacyTransition";
    L32:
        if (win.mAnimatingExit == true) goto L42;
        if (win.mActivityRecord != null) goto L36;
    L39:
        boolean stopped = true;
    L40:
        win.mDestroying = true;
        win.destroySurface(false, stopped);
        goto L42
    L36:
        if (win.mActivityRecord.mAppStopped == true) goto L39;
        stopped = false;
    L42:
        if (this.mAccessibilityController.hasCallbacks() == false) goto L45;
        this.mAccessibilityController.onWindowTransition(win, transit);
        return;
    }

    private int createSurfaceControl(SurfaceControl outSurfaceControl, int result, WindowState win, WindowStateAnimator winAnimator) {
        if (win.mHasSurface == true) goto L20;
        result = result | 2;
    L20:
        Trace.traceBegin(32, "createSurfaceControl");     // Catch: Throwable -> L17
        SurfaceControl surfaceControl = winAnimator.createSurfaceLocked();     // Catch: Throwable -> L17
        Trace.traceEnd(32);
        if (surfaceControl == null) goto L13;
        winAnimator.getSurfaceControl(outSurfaceControl);
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L16;
        String protoLogParam0 = String.valueOf(outSurfaceControl);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, 6555160513135851764L, 0, new Object[]{protoLogParam0});
    L16:
        return result;
    L13:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        String protoLogParam1 = String.valueOf(win);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -196459205494031145L, 0, new Object[]{protoLogParam1});
    L15:
        outSurfaceControl.release();
    L17:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    public boolean outOfMemoryWindow(Session session, IWindow client) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L20
        boostPriorityForLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        WindowState win = windowForClientLocked(session, client, false);     // Catch: Throwable -> L11
        if (win != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L13:
        boolean r3 = this.mRoot.reclaimSomeSurfaceMemory(win.mWinAnimator, "from-client", false);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r3;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    void finishDrawingWindow(Session session, IWindow client, SurfaceControl.Transaction postDrawTransaction, int seqId) {
        finishDrawingWindow(session, client, postDrawTransaction, seqId, null);
    }

    void finishDrawingWindow(Session session, IWindow client, SurfaceControl.Transaction postDrawTransaction, int seqId, ActivityMetricsData data) {
        ProcessFreezerManager freezer = ProcessFreezerManager.getInstance();
        if (freezer != null) goto L5;
    L7:
        if (postDrawTransaction == null) goto L9;
        postDrawTransaction.sanitize(Binder.getCallingPid(), Binder.getCallingUid());
    L9:
        getSmtEx().notifyStartEventToResManager(session.mUid, session.mPid, 1, "");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r8 = this.mGlobalLock;     // Catch: Throwable -> L56
        boostPriorityForLockedSection();     // Catch: Throwable -> L56
        monitor-enter(r8);     // Catch: Throwable -> L56
        WindowState win = windowForClientLocked(session, client, false);     // Catch: Throwable -> L27
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[0] == false) goto L30;
        String protoLogParam0 = String.valueOf(win);     // Catch: Throwable -> L27
        if (win != null) goto L62;
        String r12 = "null";
    L22:
        String protoLogParam1 = String.valueOf(r12);     // Catch: Throwable -> L27
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -5512006943172316333L, 0, new Object[]{protoLogParam0, protoLogParam1});     // Catch: Throwable -> L25
    L25:
        th = th;
    L53:
        monitor-exit(r8);     // Catch: Throwable -> L43
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L62:
        r12 = win.mWinAnimator.drawStateToString();     // Catch: Throwable -> L19
    L19:
        th = th;
    L30:
        if (data == null) goto L33;
        this.mAtmService.mTaskSupervisor.getActivityMetricsLogger().notifyActivityMetrics(win.getActivityRecord(), data);     // Catch: Throwable -> L25
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().notifyAppFirstFrame(session.mPackageName, session.mUid);     // Catch: Throwable -> L25
    L33:
        if (WindowManagerDebugConfig.DEBUG == false) goto L35;
        Slog.i(TAG, "finishDrawingWindow: transaction=" + postDrawTransaction + " record=" + win.getActivityRecord() + "data=" + data);     // Catch: Throwable -> L25
    L35:
        getExt().traceFinishDrawing(win);     // Catch: Throwable -> L25
        if (win == null) goto L47;
        if (win.finishDrawing(postDrawTransaction, seqId) == false) goto L47;
        if (win.hasWallpaper() == false) goto L45;
        win.getDisplayContent().pendingLayoutChanges |= 4;     // Catch: Throwable -> L43
    L45:
        win.setDisplayLayoutNeeded();     // Catch: Throwable -> L43
        this.mWindowPlacerLocked.requestTraversal();     // Catch: Throwable -> L43
    L47:
        monitor-exit(r8);     // Catch: Throwable -> L43
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(origId);
        return;
    L43:
        th = th;
    L27:
        th = th;
    L51:
        th = th;
    L58:
        Binder.restoreCallingIdentity(origId);
        throw th;
    L56:
        th = th;
        goto L58
    L5:
        if (freezer.useFreezerManager() == false) goto L7;
        freezer.startUnfreeze(session.mPackageName, 0);
        goto L7
    }

    boolean checkCallingPermission(String permission, String func) {
        return checkCallingPermission(permission, func, true);
    }

    boolean checkCallingPermission(String permission, String func, boolean printLog) {
        if (Binder.getCallingPid() != MY_PID) goto L6;
        return true;
    L6:
        if (this.mContext.checkCallingPermission(permission) != 0) goto L8;
        return true;
    L8:
        if (printLog == true) goto L10;
        return false;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        String protoLogParam0 = String.valueOf(func);
        long protoLogParam1 = Binder.getCallingPid();
        long protoLogParam2 = Binder.getCallingUid();
        String protoLogParam3 = String.valueOf(permission);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -2577785761087081584L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2), protoLogParam3});
        return false;
    L15:
        return false;
    }

    public void addWindowToken(IBinder binder, int type, int displayId, Bundle options) {
        if (checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "addWindowToken()") == false) goto L39;
        WindowManagerGlobalLock r9 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r9);
        DisplayContent dc = getDisplayContentOrCreate(displayId, null);     // Catch: Throwable -> L12
        if (dc == null) goto L10;
        WindowToken token = dc.getWindowToken(binder);     // Catch: Throwable -> L12
        if (token == null) goto L26;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L22;
        String protoLogParam0 = String.valueOf(binder);     // Catch: Throwable -> L12
        String protoLogParam1 = String.valueOf(token);     // Catch: Throwable -> L12
        long protoLogParam2 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -972832559831959983L, 16, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L12
    L22:
        monitor-exit(r9);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L26:
        if (type != 2013) goto L30;
        new WallpaperWindowToken(this, binder, true, dc, true, options);     // Catch: Throwable -> L12
    L31:
        monitor-exit(r9);     // Catch: Throwable -> L34
        resetPriorityAfterLockedSection();
        return;
    L30:
        new WindowToken.Builder(this, binder, type).setDisplayContent(dc).setPersistOnEmpty(true).setOwnerCanManageAppTokens(true).setOptions(options).build();     // Catch: Throwable -> L34
        goto L31
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L14;
        String protoLogParam3 = String.valueOf(binder);     // Catch: Throwable -> L12
        long protoLogParam4 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 4547566763172245740L, 4, new Object[]{protoLogParam3, Long.valueOf(protoLogParam4)});     // Catch: Throwable -> L12
    L14:
        monitor-exit(r9);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L34:
        th = th;
    L35:
        monitor-exit(r9);     // Catch: Throwable -> L34
        resetPriorityAfterLockedSection();
        throw th;
    L12:
        th = th;
        goto L35
    L39:
        throw new SecurityException("Requires MANAGE_APP_TOKENS permission");
    }

    public WindowContextInfo attachWindowContextToDisplayArea(IApplicationThread appThread, IBinder clientToken, int type, int displayId, Bundle options) {
        appThread.getClass();
        clientToken.getClass();
        boolean callerCanManageAppTokens = checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "attachWindowContextToDisplayArea", false);
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r9 = this.mGlobalLock;     // Catch: Throwable -> L47
        boostPriorityForLockedSection();     // Catch: Throwable -> L47
        monitor-enter(r9);     // Catch: Throwable -> L47
        WindowProcessController wpc = this.mAtmService.getProcessController(appThread);     // Catch: Throwable -> L29
        if (wpc != null) goto L20;
    L13:
        th = th;
    L42:
        monitor-exit(r9);     // Catch: Throwable -> L27
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = th;
    L49:
        Binder.restoreCallingIdentity(origId);
        throw th;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        long protoLogParam0 = callingPid;
        long protoLogParam1 = callingUid;
        WindowContextInfo r16 = null;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 8372202339190060748L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: Throwable -> L13
    L16:
        monitor-exit(r9);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r16;
    L15:
        r16 = null;
        goto L16
    L20:
        DisplayContent dc = this.mRoot.getDisplayContentOrCreate(displayId);     // Catch: Throwable -> L29
        if (dc != null) goto L36;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L32;
        long protoLogParam2 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 1904306629015452865L, 1, new Object[]{Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L27
    L32:
        monitor-exit(r9);     // Catch: Throwable -> L27
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L36:
        DisplayArea<?> da = dc.findAreaForWindowType(type, options, callerCanManageAppTokens, false);     // Catch: Throwable -> L27
        this.mWindowContextListenerController.registerWindowContainerListener(wpc, clientToken, da, type, options, false);     // Catch: Throwable -> L27
        WindowContextInfo r4 = new WindowContextInfo(da.getConfiguration(), displayId);     // Catch: Throwable -> L27
        monitor-exit(r9);     // Catch: Throwable -> L27
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r4;
    L29:
        th = th;
    L40:
        th = th;
    L27:
        th = th;
    L47:
        th = th;
        goto L49
    }

    public WindowContextInfo attachWindowContextToDisplayContent(IApplicationThread appThread, IBinder clientToken, int displayId) {
        appThread.getClass();
        clientToken.getClass();
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r7 = this.mGlobalLock;     // Catch: Throwable -> L43
        boostPriorityForLockedSection();     // Catch: Throwable -> L43
        monitor-enter(r7);     // Catch: Throwable -> L43
        WindowProcessController wpc = this.mAtmService.getProcessController(appThread);     // Catch: Throwable -> L16
        if (wpc != null) goto L23;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L18;
        long protoLogParam0 = callingPid;
        long protoLogParam1 = callingUid;
        WindowContextInfo r16 = null;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -6845859096032432107L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: Throwable -> L14
    L19:
        monitor-exit(r7);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r16;
    L18:
        r16 = null;
        goto L19
    L23:
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L14
        if (dc == null) goto L26;
        this.mWindowContextListenerController.registerWindowContainerListener(wpc, clientToken, dc, -1, null, false);     // Catch: Throwable -> L14
        WindowContextInfo r0 = new WindowContextInfo(dc.getConfiguration(), displayId);     // Catch: Throwable -> L14
        monitor-exit(r7);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r0;
    L26:
        if (callingPid != MY_PID) goto L31;
        monitor-exit(r7);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L31:
        throw new IllegalArgumentException("attachWindowContextToDisplayContent: trying to attach to a non-existing display:" + displayId);     // Catch: Throwable -> L14
    L16:
        th = th;
    L38:
        monitor-exit(r7);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = th;
    L45:
        Binder.restoreCallingIdentity(origId);
        throw th;
    L36:
        th = th;
    L14:
        th = th;
    L43:
        th = th;
        goto L45
    }

    public WindowContextInfo attachWindowContextToWindowToken(IApplicationThread appThread, IBinder clientToken, IBinder token) {
        appThread.getClass();
        clientToken.getClass();
        token.getClass();
        boolean callerCanManageAppTokens = checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "attachWindowContextToWindowToken", false);
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r14 = this.mGlobalLock;     // Catch: Throwable -> L61
        boostPriorityForLockedSection();     // Catch: Throwable -> L61
        monitor-enter(r14);     // Catch: Throwable -> L61
        WindowProcessController wpc = this.mAtmService.getProcessController(appThread);     // Catch: Throwable -> L29
        if (wpc != null) goto L20;
    L13:
        th = th;
    L56:
        monitor-exit(r14);     // Catch: Throwable -> L27
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L59:
        th = th;
    L63:
        Binder.restoreCallingIdentity(origId);
        throw th;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        long protoLogParam0 = callingPid;
        long protoLogParam1 = callingUid;
        WindowContextInfo r16 = null;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 1473791807245791604L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: Throwable -> L13
    L16:
        monitor-exit(r14);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r16;
    L15:
        r16 = null;
        goto L16
    L20:
        WindowToken windowToken = this.mRoot.getWindowToken(token);     // Catch: Throwable -> L29
        if (windowToken != null) goto L36;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L32;
        String protoLogParam2 = String.valueOf(token);     // Catch: Throwable -> L29
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -2056866750160555704L, 0, new Object[]{protoLogParam2});     // Catch: Throwable -> L27
    L32:
        monitor-exit(r14);     // Catch: Throwable -> L27
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L36:
        int type = this.mWindowContextListenerController.getWindowType(clientToken);     // Catch: Throwable -> L27
        if (type == (-1)) goto L53;
        if (type != windowToken.windowType) goto L51;
        if (this.mWindowContextListenerController.assertCallerCanModifyListener(clientToken, callerCanManageAppTokens, callingUid) == true) goto L45;
        monitor-exit(r14);     // Catch: Throwable -> L27
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L45:
        this.mWindowContextListenerController.registerWindowContainerListener(wpc, clientToken, windowToken, windowToken.windowType, windowToken.mOptions, false);     // Catch: Throwable -> L27
        WindowContextInfo r0 = new WindowContextInfo(windowToken.getConfiguration(), windowToken.getDisplayContent().getDisplayId());     // Catch: Throwable -> L27
        monitor-exit(r14);     // Catch: Throwable -> L27
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r0;
    L51:
        throw new IllegalArgumentException("The WindowToken's type should match the created WindowContext's type. WindowToken's type is " + windowToken.windowType + ", while WindowContext's is " + type);     // Catch: Throwable -> L27
    L53:
        throw new IllegalArgumentException("The clientToken:" + clientToken + " should have been attached.");     // Catch: Throwable -> L27
    L29:
        th = th;
    L54:
        th = th;
    L27:
        th = th;
    L61:
        th = th;
        origId = origId;
        goto L63
    }

    public void detachWindowContext(IBinder clientToken) {
        clientToken.getClass();
        boolean callerCanManageAppTokens = checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "detachWindowContext", false);
        int callingUid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r4 = this.mGlobalLock;     // Catch: Throwable -> L26
        boostPriorityForLockedSection();     // Catch: Throwable -> L26
        monitor-enter(r4);     // Catch: Throwable -> L26
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L6:
        if (this.mWindowContextListenerController.assertCallerCanModifyListener(clientToken, callerCanManageAppTokens, callingUid) == true) goto L12;
        monitor-exit(r4);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        WindowContainer<?> r5 = this.mWindowContextListenerController.getContainer(clientToken);     // Catch: Throwable -> L10
        this.mWindowContextListenerController.unregisterWindowContainerListener(clientToken);     // Catch: Throwable -> L10
        if (r5 == null) goto L15;
        WindowToken token = r5.asWindowToken();     // Catch: Throwable -> L10
    L16:
        if (token != null) goto L18;
    L22:
        monitor-exit(r4);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(origId);
        return;
    L18:
        if (token.isFromClient() == false) goto L22;
        if (token.getDisplayContent() == null) goto L22;
        removeWindowToken(token.token, token.getDisplayContent().getDisplayId());     // Catch: Throwable -> L10
        goto L22
    L15:
        token = null;
    L26:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public boolean reparentWindowContextToDisplayArea(IApplicationThread appThread, IBinder clientToken, int displayId) {
        appThread.getClass();
        clientToken.getClass();
        boolean callerCanManageAppTokens = checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "reparentWindowContextToDisplayArea", false);
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r15 = this.mGlobalLock;     // Catch: Throwable -> L51
        boostPriorityForLockedSection();     // Catch: Throwable -> L51
        monitor-enter(r15);     // Catch: Throwable -> L51
        WindowProcessController wpc = this.mAtmService.getProcessController(appThread);     // Catch: Throwable -> L10
        if (wpc != null) goto L17;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L13;
        long protoLogParam0 = callingPid;
        long protoLogParam1 = callingUid;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 1268323414887316830L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: Throwable -> L10
    L13:
        monitor-exit(r15);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return 0;
    L17:
        DisplayContent dc = this.mRoot.getDisplayContentOrCreate(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L26;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L22;
        long protoLogParam2 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 6048827564246643807L, 1, new Object[]{Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L10
    L22:
        monitor-exit(r15);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L26:
        if (this.mWindowContextListenerController.assertCallerCanReparentListener(clientToken, callerCanManageAppTokens, callingUid, displayId) == true) goto L30;
        monitor-exit(r15);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L30:
        WindowContainer<?> container = this.mWindowContextListenerController.getContainer(clientToken);     // Catch: Throwable -> L10
        if (container == null) goto L33;
        WindowToken token = container.asWindowToken();     // Catch: Throwable -> L10
    L34:
        if (token != null) goto L36;
    L44:
        int type = this.mWindowContextListenerController.getWindowType(clientToken);     // Catch: Throwable -> L10
        Bundle options = this.mWindowContextListenerController.getOptions(clientToken);     // Catch: Throwable -> L10
        DisplayArea<?> da = dc.findAreaForWindowType(type, options, callerCanManageAppTokens, false);     // Catch: Throwable -> L10
        this.mWindowContextListenerController.registerWindowContainerListener(wpc, clientToken, da, type, options, true);     // Catch: Throwable -> L10
        monitor-exit(r15);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return true;
    L36:
        if (token.isFromClient() == false) goto L44;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[0] == false) goto L40;
        long protoLogParam3 = displayId;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -1284414053893456497L, 1, new Object[]{Long.valueOf(protoLogParam3)});     // Catch: Throwable -> L10
    L40:
        dc.reParentWindowToken(token);     // Catch: Throwable -> L10
        hideUntilNextDraw(token);     // Catch: Throwable -> L10
        forceReportResizing(token);     // Catch: Throwable -> L10
        dc.setLayoutNeeded();     // Catch: Throwable -> L10
        requestTraversal();     // Catch: Throwable -> L10
        monitor-exit(r15);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return true;
    L33:
        token = null;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private void forceReportResizing(WindowContainer<?> wc) {
        wc.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda14(this), true);
    }

    private /* synthetic */ void lambda$forceReportResizing$2(WindowState w) {
        if (this.mResizingWindows.contains(w) == true) goto L6;
        this.mResizingWindows.add(w);
        return;
    }

    void dispatchScreenRecordingState(final boolean forceSdr) {
        this.mRoot.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda2(forceSdr), true);
    }

    private static /* synthetic */ void lambda$dispatchScreenRecordingState$3(boolean forceSdr, WindowState w) {
        w.notifyScreenRecordingState(forceSdr);
    }

    private void hideUntilNextDraw(final WindowToken token) {
        WindowState topChild = token.getTopChild();
        if (topChild == null) goto L6;
        this.mTransactionFactory.get().hide(token.mSurfaceControl).apply();
        topChild.applyWithNextDraw(new WindowManagerService$$ExternalSyntheticLambda21(token));
        return;
    }

    private static /* synthetic */ void lambda$hideUntilNextDraw$4(WindowToken token, SurfaceControl.Transaction t) {
        if (token.mSurfaceControl == null) goto L6;
        t.show(token.mSurfaceControl);
        return;
    }

    public boolean isWindowToken(IBinder binder) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mRoot.getWindowToken(binder) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void removeWindowToken(IBinder binder, boolean removeWindows, boolean animateExit, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (dc == null) goto L7;
        WindowToken token = dc.removeWindowToken(binder, animateExit);     // Catch: Throwable -> L9
        if (token == null) goto L17;
        if (removeWindows == false) goto L24;
        token.removeAllWindowsIfPossible();     // Catch: Throwable -> L9
    L24:
        dc.getInputMonitor().updateInputWindowsLw(true);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L19;
        String protoLogParam0 = String.valueOf(binder);     // Catch: Throwable -> L9
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 874825105313641295L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L9
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L7:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L11;
        String protoLogParam1 = String.valueOf(binder);     // Catch: Throwable -> L9
        long protoLogParam2 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1045756671264607145L, 4, new Object[]{protoLogParam1, Long.valueOf(protoLogParam2)});     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void removeWindowToken(IBinder binder, int displayId) {
        if (checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "removeWindowToken()") == false) goto L12;
        long origId = Binder.clearCallingIdentity();
        removeWindowToken(binder, false, true, displayId);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L12:
        throw new SecurityException("Requires MANAGE_APP_TOKENS permission");
    }

    public void moveWindowTokenToDisplay(IBinder binder, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mRoot.getDisplayContentOrCreate(displayId);     // Catch: Throwable -> L9
        if (dc == null) goto L7;
        WindowToken token = this.mRoot.getWindowToken(binder);     // Catch: Throwable -> L9
        if (token != null) goto L23;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L19;
        String protoLogParam0 = String.valueOf(binder);     // Catch: Throwable -> L9
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 6497954191906583839L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L9
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L23:
        if (token.getDisplayContent() == dc) goto L25;
        dc.reParentWindowToken(token);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L25:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L27;
        String protoLogParam1 = String.valueOf(binder);     // Catch: Throwable -> L9
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 2865882097969084039L, 0, new Object[]{protoLogParam1});     // Catch: Throwable -> L9
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L7:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L11;
        String protoLogParam2 = String.valueOf(binder);     // Catch: Throwable -> L9
        long protoLogParam3 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 5128669121055635771L, 4, new Object[]{protoLogParam2, Long.valueOf(protoLogParam3)});     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void overridePendingAppTransitionMultiThumbFuture(IAppTransitionAnimationSpecsFuture specsFuture, IRemoteCallback callback, boolean scaleUp, int displayId) {
    }

    public void overridePendingAppTransitionRemote(RemoteAnimationAdapter remoteAnimationAdapter, int displayId) {
    }

    public void endProlongedAnimations() {
    }

    public void executeAppTransition() {
        if (checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "executeAppTransition()") == false) goto L7;
        getDefaultDisplayContentLocked().executeAppTransition();
        return;
    L7:
        throw new SecurityException("Requires MANAGE_APP_TOKENS permission");
    }

    boolean isValidPictureInPictureAspectRatio(DisplayContent displayContent, float aspectRatio) {
        return displayContent.getPinnedTaskController().isValidPictureInPictureAspectRatio(aspectRatio);
    }

    boolean isValidExpandedPictureInPictureAspectRatio(DisplayContent displayContent, float aspectRatio) {
        return displayContent.getPinnedTaskController().isValidExpandedPictureInPictureAspectRatio(aspectRatio);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void notifyKeyguardTrustedChanged() {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L6:
        if (this.mAtmService.mKeyguardController.isKeyguardShowing(0) == false) goto L10;
        this.mRoot.ensureActivitiesVisible();     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void screenTurningOff(int displayId, WindowManagerPolicy.ScreenOffListener listener) {
        this.mTaskSnapshotController.screenTurningOff(displayId, listener);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void onKeyguardShowingAndNotOccludedChanged() {
        this.mH.sendEmptyMessage(61);
        dispatchKeyguardLockedState();
    }

    private static /* synthetic */ void lambda$onPowerKeyDown$5(boolean isScreenOn, DisplayPolicy p) {
        p.onPowerKeyDown(isScreenOn);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void onPowerKeyDown(final boolean isScreenOn) {
        this.mRoot.forAllDisplayPolicies(new WindowManagerService$$ExternalSyntheticLambda3(isScreenOn));
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void onUserSwitched() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mRoot.forAllDisplayPolicies(new WindowManagerService$$ExternalSyntheticLambda12());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void moveDisplayToTopIfAllowed(int displayId) {
        moveDisplayToTopInternal(displayId);
        syncInputTransactions(true);
    }

    void moveDisplayToTopInternal(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L13
        if (displayContent != null) goto L7;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        return;
    L7:
        if (this.mRoot.getTopChild() == displayContent) goto L22;
        if (displayContent.canStealTopFocus() == false) goto L11;
        Transition transition = null;
        displayContent.getParent().positionChildAt(Integer.MAX_VALUE, displayContent, true);     // Catch: Throwable -> L13
        if (0 == 0) goto L22;
        transition.setReady(displayContent, true);     // Catch: Throwable -> L13
        goto L22
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[2] == false) goto L15;
        long protoLogParam0 = displayId;
        long protoLogParam1 = this.mRoot.getTopFocusedDisplayContent().getDisplayId();     // Catch: Throwable -> L13
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -886583195545553099L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void disableKeyguard(IBinder token, String tag, int userId) {
        int userId2 = this.mAmInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 2, "disableKeyguard", null);
        if (this.mContext.checkCallingOrSelfPermission("android.permission.DISABLE_KEYGUARD") != 0) goto L12;
        int callingUid = Binder.getCallingUid();
        long origIdentity = Binder.clearCallingIdentity();
        this.mKeyguardDisableHandler.disableKeyguard(token, tag, callingUid, userId2);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(origIdentity);
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(origIdentity);
        throw th;
    L12:
        throw new SecurityException("Requires DISABLE_KEYGUARD permission");
    }

    public void reenableKeyguard(IBinder token, int userId) {
        int userId2 = this.mAmInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 2, "reenableKeyguard", null);
        if (this.mContext.checkCallingOrSelfPermission("android.permission.DISABLE_KEYGUARD") != 0) goto L12;
        token.getClass();
        int callingUid = Binder.getCallingUid();
        long origIdentity = Binder.clearCallingIdentity();
        this.mKeyguardDisableHandler.reenableKeyguard(token, callingUid, userId2);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(origIdentity);
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(origIdentity);
        throw th;
    L12:
        throw new SecurityException("Requires DISABLE_KEYGUARD permission");
    }

    public void exitKeyguardSecurely(final IOnKeyguardExitResult callback) {
        exitKeyguardSecurely_enforcePermission();
        if (callback == null) goto L7;
        this.mPolicy.exitKeyguardSecurely(new AnonymousClass10(this, callback));
        return;
    L7:
        throw new IllegalArgumentException("callback == null");
    }

    public boolean isKeyguardLocked() {
        return this.mPolicy.isKeyguardLocked();
    }

    public boolean isKeyguardShowingAndNotOccluded() {
        return this.mPolicy.isKeyguardShowingAndNotOccluded();
    }

    public boolean isKeyguardSecure(int userId) {
        if (userId != UserHandle.getCallingUserId()) goto L5;
    L9:
        long origId = Binder.clearCallingIdentity();
        boolean r2 = this.mPolicy.isKeyguardSecure(userId);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(origId);
        return r2;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L5:
        if (checkCallingPermission("android.permission.INTERACT_ACROSS_USERS", "isKeyguardSecure") == true) goto L9;
        throw new SecurityException("Requires INTERACT_ACROSS_USERS permission");
    }

    public void dismissKeyguard(IKeyguardDismissCallback callback, CharSequence message) {
        if (checkCallingPermission("android.permission.CONTROL_KEYGUARD", "dismissKeyguard") == false) goto L15;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        getDefaultDisplayContentLocked();     // Catch: Throwable -> L10
        this.mPolicy.dismissKeyguardLw(callback, message);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L15:
        throw new SecurityException("Requires CONTROL_KEYGUARD permission");
    }

    public void addKeyguardLockedStateListener(IKeyguardLockedStateListener listener) {
        enforceSubscribeToKeyguardLockedStatePermission();
        boolean registered = this.mKeyguardLockedStateListeners.register(listener);
        if (registered == true) goto L6;
        Slog.w(TAG, "Failed to register listener: " + listener);
        return;
    }

    public void removeKeyguardLockedStateListener(IKeyguardLockedStateListener listener) {
        enforceSubscribeToKeyguardLockedStatePermission();
        this.mKeyguardLockedStateListeners.unregister(listener);
    }

    private void enforceSubscribeToKeyguardLockedStatePermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.SUBSCRIBE_TO_KEYGUARD_LOCKED_STATE", "android.permission.SUBSCRIBE_TO_KEYGUARD_LOCKED_STATE permission required to subscribe to keyguard locked state changes");
    }

    private void dispatchKeyguardLockedState() {
        this.mH.post(new WindowManagerService$$ExternalSyntheticLambda32(this));
    }

    private /* synthetic */ void lambda$dispatchKeyguardLockedState$6() {
        boolean isKeyguardLocked = this.mPolicy.isKeyguardShowing();
        if (this.mDispatchedKeyguardLockedState != isKeyguardLocked) goto L5;
        return;
    L5:
        int n = this.mKeyguardLockedStateListeners.beginBroadcast();
        int i = 0;
    L6:
        if (i >= n) goto L11;
        this.mKeyguardLockedStateListeners.getBroadcastItem(i).onKeyguardLockedStateChanged(isKeyguardLocked);     // Catch: RemoteException -> L9
    L10:
        i = i + 1;
        goto L6
    L11:
        this.mKeyguardLockedStateListeners.finishBroadcast();
        this.mDispatchedKeyguardLockedState = isKeyguardLocked;
    }

    void dispatchImeTargetOverlayVisibilityChanged(IBinder token, int windowType, boolean visible, boolean removed, final int displayId) {
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L5;
        Slog.d(TAG, "onImeTargetOverlayVisibilityChanged, win=" + this.mWindowMap.get(token) + ", type=" + ViewDebug.intToString(WindowManager.LayoutParams.class, DatabaseHelper.SoundModelContract.KEY_TYPE, windowType) + "visible=" + visible + ", removed=" + removed + ", displayId=" + displayId);
    L5:
        if (visible == false) goto L10;
        if (removed == true) goto L10;
        if (windowType == 3) goto L10;
        final boolean hasOverlay = true;
    L11:
        this.mH.post(new WindowManagerService$$ExternalSyntheticLambda22(hasOverlay, displayId));
        return;
    L10:
        hasOverlay = false;
        goto L11
    }

    private static /* synthetic */ void lambda$dispatchImeTargetOverlayVisibilityChanged$7(boolean hasOverlay, int displayId) {
        InputMethodManagerInternal.get().setHasVisibleImeLayeringOverlay(hasOverlay, displayId);
    }

    void dispatchImeInputTargetVisibilityChanged(final IBinder token, boolean visible, boolean removed, final int displayId) {
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L5;
        Slog.d(TAG, "onImeInputTargetVisibilityChanged, win=" + this.mWindowMap.get(token) + "visible=" + visible + ", removed=" + removed + ", displayId=" + displayId);
    L5:
        if (visible == false) goto L8;
        if (removed == true) goto L8;
        final boolean visibleAndNotRemoved = true;
    L9:
        this.mH.post(new WindowManagerService$$ExternalSyntheticLambda18(token, visibleAndNotRemoved, displayId));
        return;
    L8:
        visibleAndNotRemoved = false;
        goto L9
    }

    private static /* synthetic */ void lambda$dispatchImeInputTargetVisibilityChanged$8(IBinder token, boolean visibleAndNotRemoved, int displayId) {
        InputMethodManagerInternal.get().onImeInputTargetVisibilityChanged(token, visibleAndNotRemoved, displayId);
    }

    public void setSwitchingUser(boolean switching) {
        if (checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "setSwitchingUser()") == false) goto L15;
        this.mPolicy.setSwitchingUser(switching);
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mSwitchingUser = switching;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L15:
        throw new SecurityException("Requires INTERACT_ACROSS_USERS_FULL permission");
    }

    public void showGlobalActions() {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "showGlobalActions()") == false) goto L7;
        this.mPolicy.showGlobalActions();
        return;
    L7:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void closeSystemDialogs(String reason) {
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        if (this.mAtmService.checkCanCloseSystemDialogs(callingPid, callingUid, null) == true) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mRoot.closeSystemDialogs(reason);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setAnimationScale(int which, float scale) {
        if (checkCallingPermission("android.permission.SET_ANIMATION_SCALE", "setAnimationScale()") == false) goto L13;
        float scale2 = WindowManager.fixScale(scale);
        switch(which) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            default: goto L10;
        };
    L7:
        this.mAnimatorDurationScaleSetting = scale2;
        goto L10
    L8:
        this.mTransitionAnimationScaleSetting = scale2;
        goto L10
    L9:
        this.mWindowAnimationScaleSetting = scale2;
    L10:
        this.mH.sendEmptyMessage(14);
        return;
    L13:
        throw new SecurityException("Requires SET_ANIMATION_SCALE permission");
    }

    public void setAnimationScales(float[] scales) {
        if (checkCallingPermission("android.permission.SET_ANIMATION_SCALE", "setAnimationScale()") == false) goto L17;
        if (scales != null) goto L6;
    L14:
        this.mH.sendEmptyMessage(14);
        return;
    L6:
        if (scales.length < 1) goto L9;
        this.mWindowAnimationScaleSetting = WindowManager.fixScale(scales[0]);
    L9:
        if (scales.length < 2) goto L12;
        this.mTransitionAnimationScaleSetting = WindowManager.fixScale(scales[1]);
    L12:
        if (scales.length < 3) goto L14;
        this.mAnimatorDurationScaleSetting = WindowManager.fixScale(scales[2]);
        dispatchNewAnimatorScaleLocked(null);
        goto L14
    L17:
        throw new SecurityException("Requires SET_ANIMATION_SCALE permission");
    }

    private void setAnimatorDurationScale(float scale) {
        this.mAnimatorDurationScaleSetting = scale;
        ValueAnimator.setDurationScale(scale);
    }

    private float animationScalesCheck(int which) {
        if (this.mAnimationsDisabled == false) goto L5;
        return 0.0f;
    L5:
        if ((-1.0f) != (-1.0f)) goto L14;
        switch(which) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L8;
            default: goto L18;
        };
    L8:
        float value = this.mAnimatorDurationScaleSetting;
        return value;
    L9:
        float value2 = this.mTransitionAnimationScaleSetting;
        return value2;
    L10:
        float value3 = this.mWindowAnimationScaleSetting;
        return value3;
    L18:
        return -1.0f;
    L14:
        return -1.0f;
    }

    public float getWindowAnimationScaleLocked() {
        return animationScalesCheck(0);
    }

    public float getTransitionAnimationScaleLocked() {
        return animationScalesCheck(1);
    }

    public float getAnimationScale(int which) {
        switch(which) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return 0.0f;
    L6:
        return this.mAnimatorDurationScaleSetting;
    L8:
        return this.mTransitionAnimationScaleSetting;
    L10:
        return this.mWindowAnimationScaleSetting;
    }

    public float[] getAnimationScales() {
        return new float[]{this.mWindowAnimationScaleSetting, this.mTransitionAnimationScaleSetting, this.mAnimatorDurationScaleSetting};
    }

    public float getCurrentAnimatorScale() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mAnimationsDisabled == false) goto L7;
        float r1 = 0.0f;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r1;
    L7:
        r1 = this.mAnimatorDurationScaleSetting;     // Catch: Throwable -> L11
        goto L8
    }

    void dispatchNewAnimatorScaleLocked(Session session) {
        dispatchNewAnimatorScaleLocked(session, getCurrentAnimatorScale(), true);
    }

    void dispatchNewAnimatorScaleLocked(Session r3, float r4, boolean r5) {
        Message r0 = this.mH.obtainMessage(34);
        r0.obj = r3;
        r0.arg1 = Float.floatToIntBits(r4);
        r0.arg2 = r5 ? 1 : 0;
        this.mH.sendMessage(r0);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void registerPointerEventListener(WindowManagerPolicyConstants.PointerEventListener listener, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L7
        if (displayContent == null) goto L9;
        displayContent.registerPointerEventListener(listener);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void unregisterPointerEventListener(WindowManagerPolicyConstants.PointerEventListener listener, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L7
        if (displayContent == null) goto L9;
        displayContent.unregisterPointerEventListener(listener);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public int getLidState() {
        int sw = this.mInputManager.getSwitchState(-1, -256, 0);
        if (sw <= 0) goto L5;
        return 0;
    L5:
        if (sw != 0) goto L8;
        return 1;
    L8:
        return -1;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void lockDeviceNow() {
        lockNow(null);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public int getCameraLensCoverState() {
        int sw = this.mInputManager.getSwitchState(-1, -256, 9);
        if (sw <= 0) goto L6;
        return 1;
    L6:
        if (sw != 0) goto L9;
        return 0;
    L9:
        return -1;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void shutdown(boolean confirm) {
        ShutdownThread.shutdown(ActivityThread.currentActivityThread().getSystemUiContext(), "userrequested", confirm);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void reboot(boolean confirm) {
        ShutdownThread.reboot(ActivityThread.currentActivityThread().getSystemUiContext(), "userrequested", confirm);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void rebootSafeMode(boolean confirm) {
        ShutdownThread.rebootSafeMode(ActivityThread.currentActivityThread().getSystemUiContext(), confirm);
    }

    public void setCurrentUser(int newUserId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        TransitionController controller = this.mAtmService.getTransitionController();     // Catch: Throwable -> L9
        if (controller.isCollecting() == false) goto L7;
    L11:
        this.mCurrentUserId = newUserId;     // Catch: Throwable -> L9
        this.mDisplayWindowSettingsProvider.setOverrideSettingsForUser(newUserId);     // Catch: Throwable -> L9
        this.mDisplayWindowSettingsProvider.removeStaleDisplaySettingsLocked(this, this.mRoot);     // Catch: Throwable -> L9
        this.mPolicy.setCurrentUserLw(newUserId);     // Catch: Throwable -> L9
        this.mKeyguardDisableHandler.setCurrentUser(newUserId);     // Catch: Throwable -> L9
        this.mRoot.switchUser(newUserId);     // Catch: Throwable -> L9
        this.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L9
        DisplayContent displayContent = getDefaultDisplayContentLocked();     // Catch: Throwable -> L9
        if (this.mDisplayReady == false) goto L18;
        int forcedDensity = getForcedDisplayDensityForUserLocked(newUserId);     // Catch: Throwable -> L9
        if (forcedDensity == 0) goto L16;
        int targetDensity = forcedDensity;
    L17:
        displayContent.setForcedDensity(targetDensity, -2);     // Catch: Throwable -> L9
        goto L18
    L16:
        targetDensity = displayContent.getInitialDisplayDensity();     // Catch: Throwable -> L9
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L7:
        if (controller.isShellTransitionsEnabled() == false) goto L11;
        controller.requestStartTransition(controller.createTransition(1), null, null, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    boolean isUserVisible(int userId) {
        return this.mUmInternal.isUserVisible(userId);
    }

    int getUserAssignedToDisplay(int displayId) {
        return this.mUmInternal.getUserAssignedToDisplay(displayId);
    }

    boolean shouldPlacePrimaryHomeOnDisplay(int displayId) {
        int userId = this.mUmInternal.getUserAssignedToDisplay(displayId);
        return shouldPlacePrimaryHomeOnDisplay(displayId, userId);
    }

    boolean shouldPlacePrimaryHomeOnDisplay(int displayId, int userId) {
        if (this.mUmInternal.getMainDisplayAssignedToUser(userId) != displayId) goto L5;
        return true;
    L5:
        return false;
    }

    public void enableScreenAfterBoot() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L10;
        boolean protoLogParam0 = this.mDisplayEnabled;     // Catch: Throwable -> L7
        boolean protoLogParam1 = this.mForceDisplayEnabled;     // Catch: Throwable -> L7
        boolean protoLogParam2 = this.mShowingBootMessages;     // Catch: Throwable -> L7
        boolean protoLogParam3 = this.mSystemBooted;     // Catch: Throwable -> L7
        String protoLogParam4 = String.valueOf(new RuntimeException("here").fillInStackTrace());     // Catch: Throwable -> L7
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -1557387535886241553L, 255, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), protoLogParam4});     // Catch: Throwable -> L7
    L10:
        if (this.mSystemBooted == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L15:
        this.mSystemBooted = true;     // Catch: Throwable -> L7
        hideBootMessagesLocked();     // Catch: Throwable -> L7
        this.mH.sendEmptyMessageDelayed(23, Build.HW_TIMEOUT_MULTIPLIER * 30000);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        this.mPolicy.systemBooted();
        performEnableScreen();
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void enableScreenIfNeeded() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        enableScreenIfNeededLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void enableScreenIfNeededLocked() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L5;
        boolean protoLogParam0 = this.mDisplayEnabled;
        boolean protoLogParam1 = this.mForceDisplayEnabled;
        boolean protoLogParam2 = this.mShowingBootMessages;
        boolean protoLogParam3 = this.mSystemBooted;
        String protoLogParam4 = String.valueOf(new RuntimeException("here").fillInStackTrace());
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -6467850045030187736L, 255, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), protoLogParam4});
    L5:
        boolean protoLogParam5 = this.mDisplayEnabled;
        if (protoLogParam5 == false) goto L9;
        return;
    L9:
        if (this.mSystemBooted == false) goto L11;
    L13:
        this.mH.sendEmptyMessage(16);
        return;
    L11:
        if (this.mShowingBootMessages == true) goto L13;
    }

    public void performBootTimeout() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mDisplayEnabled == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L14;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 179762478329442868L, 0, null);     // Catch: Throwable -> L9
    L14:
        this.mForceDisplayEnabled = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        performEnableScreen();
    }

    public void onSystemUiStarted() {
        this.mPolicy.onSystemUiStarted();
    }

    private void performEnableScreen() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L10;
        boolean protoLogParam0 = this.mDisplayEnabled;     // Catch: Throwable -> L7
        boolean protoLogParam1 = this.mForceDisplayEnabled;     // Catch: Throwable -> L7
        boolean protoLogParam2 = this.mShowingBootMessages;     // Catch: Throwable -> L7
        boolean protoLogParam3 = this.mSystemBooted;     // Catch: Throwable -> L7
        String protoLogParam4 = String.valueOf(new RuntimeException("here").fillInStackTrace());     // Catch: Throwable -> L7
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -3417569256875279779L, 255, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), protoLogParam4});     // Catch: Throwable -> L7
    L10:
        if (this.mDisplayEnabled == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L15:
        if (this.mSystemBooted == true) goto L22;
        if (this.mShowingBootMessages == true) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L22:
        if (this.mShowingBootMessages == true) goto L29;
        if (this.mPolicy.canDismissBootAnimation() == true) goto L29;
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L29:
        if (this.mForceDisplayEnabled == true) goto L48;
        if (this.mBootWaitForWindowsStartTime >= 0) goto L33;
        this.mBootWaitForWindowsStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
    L33:
        int i = this.mRoot.getChildCount() - 1;     // Catch: Throwable -> L7
    L34:
        if (i < 0) goto L42;
        if (this.mRoot.getChildAt(i).shouldWaitForSystemDecorWindowsOnBoot() == true) goto L37;
        i = i - 1;
        goto L34
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L42:
        long waitTime = SystemClock.elapsedRealtime() - this.mBootWaitForWindowsStartTime;     // Catch: Throwable -> L7
        this.mBootWaitForWindowsStartTime = -1;     // Catch: Throwable -> L7
        if (waitTime <= 10) goto L48;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L48;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -7516915153725082358L, 1, new Object[]{Long.valueOf(waitTime)});     // Catch: Throwable -> L7
    L48:
        if (this.mBootAnimationStopped == true) goto L51;
        Trace.asyncTraceBegin(32, "Stop bootanim", 0);     // Catch: Throwable -> L7
        SystemProperties.set("service.bootanim.exit", "1");     // Catch: Throwable -> L7
        this.mBootAnimationStopped = true;     // Catch: Throwable -> L7
        getExt().onBootAnimationFade(SystemClock.uptimeNanos());     // Catch: Throwable -> L7
    L51:
        if (this.mForceDisplayEnabled == true) goto L61;
        if (checkBootAnimationCompleteLocked() == true) goto L61;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L57;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -1541244520024033685L, 0, null);     // Catch: Throwable -> L7
    L57:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L61:
        if (SurfaceControl.bootFinished() == false) goto L63;
        EventLogTags.writeWmBootAnimationDone(SystemClock.uptimeMillis());     // Catch: Throwable -> L7
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_animation_done", SystemClock.elapsedRealtime());     // Catch: Throwable -> L7
        Trace.asyncTraceEnd(32, "Stop bootanim", 0);     // Catch: Throwable -> L7
        this.mDisplayEnabled = true;     // Catch: Throwable -> L7
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[2] == false) goto L71;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, 530628508916855904L, 0, null);     // Catch: Throwable -> L7
    L71:
        this.mInputManagerCallback.setEventDispatchingLw(this.mEventDispatchingEnabled);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        this.mActivityManager.bootAnimationComplete();     // Catch: RemoteException -> L76
    L77:
        this.mPolicy.enableScreenAfterBoot();
        updateRotationUnchecked(false, false);
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mAtmService.getTransitionController().mIsWaitingForDisplayEnabled = false;     // Catch: Throwable -> L82
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] == false) goto L84;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, 5477889324043875194L, 0, null);     // Catch: Throwable -> L82
    L84:
        monitor-exit(r1);     // Catch: Throwable -> L82
        resetPriorityAfterLockedSection();
        return;
    L82:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L63:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L65;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 2670150656385758826L, 0, null);     // Catch: Throwable -> L7
    L65:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
    }

    private boolean checkBootAnimationCompleteLocked() {
        if (SystemService.isRunning(BOOT_ANIMATION_SERVICE) == false) goto L9;
        this.mH.removeMessages(37);
        this.mH.sendEmptyMessageDelayed(37, 50);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L7;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -2061779801633179448L, 0, null);
    L7:
        return false;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L13;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -8177456840019985809L, 0, null);
        return true;
    L13:
        return true;
    }

    public void showBootMessage(CharSequence msg, boolean always) {
        boolean first = false;
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r2);
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L10;
        String protoLogParam0 = String.valueOf(msg);     // Catch: Throwable -> L7
        boolean protoLogParam2 = this.mAllowBootMessages;     // Catch: Throwable -> L7
        boolean protoLogParam3 = this.mShowingBootMessages;     // Catch: Throwable -> L7
        boolean protoLogParam4 = this.mSystemBooted;     // Catch: Throwable -> L7
        String protoLogParam5 = String.valueOf(new RuntimeException("here").fillInStackTrace());     // Catch: Throwable -> L7
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, -333924817004774456L, 1020, new Object[]{protoLogParam0, Boolean.valueOf(always), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), Boolean.valueOf(protoLogParam4), protoLogParam5});     // Catch: Throwable -> L7
    L10:
        if (this.mAllowBootMessages == true) goto L15;
        monitor-exit(r2);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L15:
        if (this.mShowingBootMessages == true) goto L22;
        if (always == true) goto L20;
        monitor-exit(r2);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L20:
        first = true;
    L22:
        if (this.mSystemBooted == false) goto L27;
        monitor-exit(r2);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L27:
        this.mShowingBootMessages = true;     // Catch: Throwable -> L7
        this.mPolicy.showBootMessage(msg, always);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        if (first == false) goto L37;
        performEnableScreen();
        return;
    }

    public void hideBootMessagesLocked() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[2] == false) goto L5;
        boolean protoLogParam0 = this.mDisplayEnabled;
        boolean protoLogParam1 = this.mForceDisplayEnabled;
        boolean protoLogParam2 = this.mShowingBootMessages;
        boolean protoLogParam3 = this.mSystemBooted;
        String protoLogParam4 = String.valueOf(new RuntimeException("here").fillInStackTrace());
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_BOOT, 2994810644159608200L, 255, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), protoLogParam4});
    L5:
        boolean protoLogParam5 = this.mShowingBootMessages;
        if (protoLogParam5 == false) goto L9;
        this.mShowingBootMessages = false;
        this.mPolicy.hideBootMessages();
        return;
    }

    public void setInTouchMode(boolean inTouch, int displayId) {
        WindowManagerGlobalLock r8 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r8);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (this.mPerDisplayFocusEnabled == false) goto L15;
        if (displayContent != null) goto L8;
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L8:
        if (displayContent.isInTouchMode() == inTouch) goto L12;
    L15:
        if (displayContent != null) goto L17;
    L19:
        boolean r0 = false;
    L20:
        boolean displayHasOwnTouchMode = r0;
        if (displayHasOwnTouchMode == true) goto L23;
    L27:
        int pid = Binder.getCallingPid();     // Catch: Throwable -> L10
        int uid = Binder.getCallingUid();     // Catch: Throwable -> L10
        boolean hasPermission = hasTouchModePermission(pid);     // Catch: Throwable -> L10
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
    L42:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L29:
        if (this.mPerDisplayFocusEnabled == true) goto L46;
        if (displayHasOwnTouchMode == true) goto L46;
        int displayCount = this.mRoot.mChildren.size();     // Catch: Throwable -> L42
        int i = 0;
    L33:
        if (i >= displayCount) goto L48;
        DisplayContent dc = (DisplayContent) this.mRoot.mChildren.get(i);     // Catch: Throwable -> L42
        if (dc.isInTouchMode() == inTouch) goto L44;
        if (dc.hasOwnFocus() == true) goto L44;
        if (this.mInputManager.setInTouchMode(inTouch, pid, uid, hasPermission, dc.mDisplayId) == false) goto L44;
        dc.setInTouchMode(inTouch);     // Catch: Throwable -> L42
    L44:
        i = i + 1;     // Catch: Throwable -> L42
    L48:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L46:
        if (this.mInputManager.setInTouchMode(inTouch, pid, uid, hasPermission, displayId) == false) goto L48;
        displayContent.setInTouchMode(inTouch);     // Catch: Throwable -> L42
        goto L48
    L23:
        if (displayContent.isInTouchMode() != inTouch) goto L27;
        monitor-exit(r8);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L17:
        if (displayContent.hasOwnFocus() == false) goto L19;
        r0 = true;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setInTouchModeOnAllDisplays(boolean inTouch) {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        boolean hasPermission = hasTouchModePermission(pid);
        long token = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r8 = this.mGlobalLock;     // Catch: Throwable -> L31
        boostPriorityForLockedSection();     // Catch: Throwable -> L31
        monitor-enter(r8);     // Catch: Throwable -> L31
        int i = 0;
    L38:
    L17:
        th = move-exception;
        Throwable r12 = th;
    L28:
        monitor-exit(r8);     // Catch: Throwable -> L15
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L26
        throw r12;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Throwable r13 = th;
    L33:
        Binder.restoreCallingIdentity(token);
        throw r13;
    L7:
        if (i >= this.mRoot.mChildren.size()) goto L22;
        DisplayContent dc = (DisplayContent) this.mRoot.mChildren.get(i);     // Catch: Throwable -> L17
        if (dc.isInTouchMode() == inTouch) goto L19;
        boolean inTouch2 = inTouch;
    L15:
        th = move-exception;
        r12 = th;
        goto L28
    L13:
        if (this.mInputManager.setInTouchMode(inTouch2, pid, uid, hasPermission, dc.mDisplayId) == false) goto L20;
        dc.setInTouchMode(inTouch2);     // Catch: Throwable -> L15
    L20:
        i = i + 1;     // Catch: Throwable -> L15
        inTouch = inTouch2;
        goto L38
    L19:
        inTouch2 = inTouch;
        goto L20
    L22:
        monitor-exit(r8);     // Catch: Throwable -> L15
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(token);
        return;
    L31:
        th = move-exception;
        r13 = th;
        goto L33
    }

    private boolean hasTouchModePermission(int pid) {
        if (this.mAtmService.instrumentationSourceHasPermission(pid, "android.permission.MODIFY_TOUCH_MODE_STATE") == false) goto L5;
    L6:
        return true;
    L5:
        if (checkCallingPermission("android.permission.MODIFY_TOUCH_MODE_STATE", "setInTouchMode()", false) == true) goto L6;
        return false;
    }

    public boolean isInTouchMode(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (displayContent != null) goto L12;
        boolean r2 = this.mContext.getResources().getBoolean(R.bool.config_defaultWindowFeatureContextMenu);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r2;
    L12:
        boolean r3 = displayContent.isInTouchMode();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r3;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void showEmulatorDisplayOverlayIfNeeded() {
        if (this.mContext.getResources().getBoolean(R.bool.device_idle_wait_for_unlock) == true) goto L5;
        return;
    L5:
        if (SystemProperties.getBoolean(PROPERTY_EMULATOR_CIRCULAR, false) == true) goto L7;
        return;
    L7:
        if (Build.IS_EMULATOR == false) goto L12;
        this.mH.sendMessage(this.mH.obtainMessage(36));
        return;
    }

    public void showEmulatorDisplayOverlay() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (WindowManagerDebugConfig.SHOW_LIGHT_TRANSACTIONS == false) goto L10;
        Slog.i(TAG, ">>> showEmulatorDisplayOverlay");     // Catch: Throwable -> L7
    L10:
        if (this.mEmulatorDisplayOverlay != null) goto L12;
        this.mEmulatorDisplayOverlay = new EmulatorDisplayOverlay(this.mContext, getDefaultDisplayContentLocked(), (this.mPolicy.getWindowLayerFromTypeLw(2018) * 10000) + 10, this.mTransaction);     // Catch: Throwable -> L7
    L12:
        this.mEmulatorDisplayOverlay.setVisibility(true, this.mTransaction);     // Catch: Throwable -> L7
        this.mTransaction.apply();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
    }

    public void showStrictModeViolation(boolean on) {
        int pid = Binder.getCallingPid();
        if (on == false) goto L5;
        this.mH.sendMessage(this.mH.obtainMessage(25, 1, pid));
        this.mH.sendMessageDelayed(this.mH.obtainMessage(25, 0, pid), 1000);
        return;
    L5:
        this.mH.sendMessage(this.mH.obtainMessage(25, 0, pid));
    }

    private void showStrictModeViolation(int arg, int pid) {
        if (arg == 0) goto L4;
        boolean on = true;
    L5:
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        if (on == false) goto L16;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L9:
        if (this.mRoot.canShowStrictModeViolation(pid) == true) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        return;
    L16:
        if (WindowManagerDebugConfig.SHOW_VERBOSE_TRANSACTIONS == false) goto L19;
        Slog.i(TAG, ">>> showStrictModeViolation");     // Catch: Throwable -> L13
    L19:
        if (this.mStrictModeFlash != null) goto L21;
        this.mStrictModeFlash = new StrictModeFlash(getDefaultDisplayContentLocked(), this.mTransaction);     // Catch: Throwable -> L13
    L21:
        this.mStrictModeFlash.setVisibility(on, this.mTransaction);     // Catch: Throwable -> L13
        this.mTransaction.apply();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        return;
    L4:
        on = false;
        goto L5
    }

    public void setStrictModeVisualIndicatorPreference(String value) {
        SystemProperties.set("persist.sys.strictmode.visual", value);
    }

    public Bitmap screenshotWallpaper() {
        if (checkCallingPermission("android.permission.READ_FRAME_BUFFER", "screenshotWallpaper()") == false) goto L19;
        Trace.traceBegin(32, "screenshotWallpaper");     // Catch: Throwable -> L15
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L15
        boostPriorityForLockedSection();     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        DisplayContent dc = this.mRoot.getDisplayContent(0);     // Catch: Throwable -> L11
        Bitmap r4 = dc.mWallpaperController.screenshotWallpaperLocked();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        Trace.traceEnd(32);
        return r4;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    L19:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    public SurfaceControl mirrorWallpaperSurface(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L8
        SurfaceControl r2 = dc.mWallpaperController.mirrorWallpaperSurface();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return r2;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private ScreenCapture.ScreenshotHardwareBuffer takeAssistScreenshot(ToBooleanFunction<WindowState> predicate) {
        if (checkCallingPermission("android.permission.READ_FRAME_BUFFER", "requestAssistScreenshot()") == false) goto L27;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(0);     // Catch: Throwable -> L11
        if (displayContent == null) goto L9;
        ScreenCapture.LayerCaptureArgs captureArgs = displayContent.getLayerCaptureArgs(predicate);     // Catch: Throwable -> L11
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        if (captureArgs == null) goto L19;
        ScreenCapture.SynchronousScreenCaptureListener syncScreenCapture = ScreenCapture.createSyncCaptureListener();
        ScreenCapture.captureLayers(captureArgs, syncScreenCapture);
        ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer = syncScreenCapture.getBuffer();
    L20:
        if (screenshotBuffer != null) goto L22;
        Slog.w(TAG, "Failed to take screenshot");
    L22:
        return screenshotBuffer;
    L19:
        screenshotBuffer = null;
        goto L20
    L9:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L13;
        Slog.i(TAG, "Screenshot returning null. No Display for displayId=0");     // Catch: Throwable -> L11
    L13:
        captureArgs = null;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L27:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    public boolean requestAssistScreenshot(final IAssistDataReceiver receiver) {
        final Bitmap bm = getObricExt().takeAssistScreenshotForTopApp();
        FgThread.getHandler().post(new WindowManagerService$$ExternalSyntheticLambda25(receiver, bm));
        return true;
    }

    private static /* synthetic */ void lambda$requestAssistScreenshot$9(IAssistDataReceiver receiver, Bitmap bm) {
        receiver.onHandleAssistScreenshot(bm);     // Catch: RemoteException -> L4
        return;
    }

    public Bitmap captureTaskBitmap(int taskId, ScreenCapture.LayerCaptureArgs.Builder layerCaptureArgsBuilder) {
        if (this.mTaskSnapshotController.shouldDisableSnapshots() == false) goto L5;
        return null;
    L5:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        Task task = this.mRoot.anyTaskForId(taskId);     // Catch: Throwable -> L12
        if (task != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return null;
    L14:
        task.getBounds(this.mTmpRect);     // Catch: Throwable -> L12
        this.mTmpRect.offsetTo(0, 0);     // Catch: Throwable -> L12
        SurfaceControl sc = task.getSurfaceControl();     // Catch: Throwable -> L12
        ScreenCapture.ScreenshotHardwareBuffer buffer = ScreenCapture.captureLayers(layerCaptureArgsBuilder.setLayer(sc).setSourceCrop(this.mTmpRect).build());     // Catch: Throwable -> L12
        if (buffer != null) goto L20;
        Slog.w(TAG, "Could not get screenshot buffer for taskId: " + taskId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return null;
    L20:
        Bitmap r1 = buffer.asBitmap();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r1;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void removeObsoleteTaskFiles(ArraySet<Integer> persistentTaskIds, int[] runningUserIds) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mTaskSnapshotController.removeObsoleteTaskFiles(persistentTaskIds, runningUserIds);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setFixedToUserRotation(int displayId, int fixedToUserRotation) {
        if (checkCallingPermission("android.permission.SET_ORIENTATION", "setFixedToUserRotation()") == false) goto L28;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L20
        boostPriorityForLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L13
        if (display != null) goto L15;
        Slog.w(TAG, "Trying to set fixed to user rotation for a missing display.");     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L15:
        display.getDisplayRotation().setFixedToUserRotation(fixedToUserRotation);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L28:
        throw new SecurityException("Requires SET_ORIENTATION permission");
    }

    int getFixedToUserRotation(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (display != null) goto L12;
        Slog.w(TAG, "Trying to get fixed to user rotation for a missing display.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return -1;
    L12:
        int r2 = display.getDisplayRotation().getFixedToUserRotationMode();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r2;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setIgnoreOrientationRequest(int displayId, boolean ignoreOrientationRequest) {
        if (checkCallingPermission("android.permission.SET_ORIENTATION", "setIgnoreOrientationRequest()") == false) goto L28;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L20
        boostPriorityForLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L13
        if (display != null) goto L15;
        Slog.w(TAG, "Trying to setIgnoreOrientationRequest() for a missing display.");     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L15:
        display.setIgnoreOrientationRequest(ignoreOrientationRequest);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(origId);
        return;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L28:
        throw new SecurityException("Requires SET_ORIENTATION permission");
    }

    public boolean getIgnoreOrientationRequest(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (display != null) goto L12;
        Slog.w(TAG, "Trying to getIgnoreOrientationRequest() for a missing display.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return false;
    L12:
        boolean r2 = display.getIgnoreOrientationRequest();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r2;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    Boolean resetIgnoreOrientationRequest(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return null;
    L12:
        display.mHasSetIgnoreOrientationRequest = false;     // Catch: Throwable -> L9
        this.mDisplayWindowSettings.setIgnoreOrientationRequest(display, null);     // Catch: Throwable -> L9
        this.mDisplayWindowSettings.applyRotationSettingsToDisplayLocked(display);     // Catch: Throwable -> L9
        Boolean r2 = Boolean.valueOf(display.getIgnoreOrientationRequest());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void setOrientationRequestPolicy(boolean isIgnoreOrientationRequestDisabled, int[] fromOrientations, int[] toOrientations) {
        this.mOrientationMapping.clear();
        if (fromOrientations == null) goto L12;
        if (toOrientations == null) goto L12;
        if (fromOrientations.length != toOrientations.length) goto L12;
        int i = 0;
    L9:
        if (i >= fromOrientations.length) goto L12;
        this.mOrientationMapping.put(fromOrientations[i], toOrientations[i]);
        i = i + 1;
    L12:
        if (isIgnoreOrientationRequestDisabled != this.mIsIgnoreOrientationRequestDisabled) goto L14;
        return;
    L14:
        this.mIsIgnoreOrientationRequestDisabled = isIgnoreOrientationRequestDisabled;
        int i2 = this.mRoot.getChildCount() - 1;
    L15:
        if (i2 < 0) goto L18;
        this.mRoot.getChildAt(i2).onIsIgnoreOrientationRequestDisabledChanged();
        i2 = i2 - 1;
        goto L15
    }

    int mapOrientationRequest(int requestedOrientation) {
        if (this.mIsIgnoreOrientationRequestDisabled == true) goto L6;
        return requestedOrientation;
    L6:
        return this.mOrientationMapping.get(requestedOrientation, requestedOrientation);
    }

    boolean isIgnoreOrientationRequestDisabled() {
        if (this.mIsIgnoreOrientationRequestDisabled == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mAppCompatConfiguration.isIgnoreOrientationRequestAllowed() == false) goto L8;
        return false;
    }

    public void freezeRotation(int rotation, String caller) {
        freezeDisplayRotation(0, rotation, caller);
    }

    public void freezeDisplayRotation(int displayId, int rotation, String caller) {
        if (checkCallingPermission("android.permission.SET_ORIENTATION", "freezeRotation()") == false) goto L37;
        if (rotation < (-1)) goto L35;
        if (rotation > 3) goto L35;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L11;
        long protoLogParam0 = getDefaultDisplayRotation();
        long protoLogParam1 = rotation;
        String protoLogParam2 = String.valueOf(caller);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -6625203651195752178L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), protoLogParam2});
    L11:
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L27
        boostPriorityForLockedSection();     // Catch: Throwable -> L27
        monitor-enter(r2);     // Catch: Throwable -> L27
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L20
        if (display != null) goto L22;
        Slog.w(TAG, "Trying to freeze rotation for a missing display.");     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L22:
        display.getDisplayRotation().freezeRotation(rotation, caller);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L27
        Binder.restoreCallingIdentity(origId);
        updateRotationUnchecked(false, false);
        return;
    L20:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L35:
        throw new IllegalArgumentException("Rotation argument must be -1 or a valid rotation constant.");
    L37:
        throw new SecurityException("Requires SET_ORIENTATION permission");
    }

    public void thawRotation(String caller) {
        thawDisplayRotation(0, caller);
    }

    public void thawDisplayRotation(int displayId, String caller) {
        if (checkCallingPermission("android.permission.SET_ORIENTATION", "thawRotation()") == false) goto L31;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L7;
        long protoLogParam0 = getDefaultDisplayRotation();
        String protoLogParam1 = String.valueOf(caller);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 8988910478484254861L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L7:
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L23
        boostPriorityForLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L16
        if (display != null) goto L18;
        Slog.w(TAG, "Trying to thaw rotation for a missing display.");     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L18:
        display.getDisplayRotation().thawRotation(caller);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(origId);
        updateRotationUnchecked(false, false);
        return;
    L16:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L31:
        throw new SecurityException("Requires SET_ORIENTATION permission");
    }

    public boolean isRotationFrozen() {
        return isDisplayRotationFrozen(0);
    }

    public boolean isDisplayRotationFrozen(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (display != null) goto L12;
        Slog.w(TAG, "Trying to check if rotation is frozen on a missing display.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return false;
    L12:
        boolean r2 = display.getDisplayRotation().isRotationFrozen();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r2;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public int getDisplayUserRotation(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (display != null) goto L12;
        Slog.w(TAG, "Trying to get user rotation of a missing display.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return -1;
    L12:
        int r2 = display.getDisplayRotation().getUserRotation();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r2;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public void updateRotation(boolean alwaysSendConfiguration, boolean forceRelayout) {
        updateRotationUnchecked(alwaysSendConfiguration, forceRelayout);
    }

    private void updateRotationUnchecked(boolean alwaysSendConfiguration, boolean forceRelayout) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L5;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 7261084872394224738L, 15, new Object[]{Boolean.valueOf(alwaysSendConfiguration), Boolean.valueOf(forceRelayout)});
    L5:
        Trace.traceBegin(32, "updateRotation");
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r0 = this.mGlobalLock;     // Catch: Throwable -> L38
        boostPriorityForLockedSection();     // Catch: Throwable -> L38
        monitor-enter(r0);     // Catch: Throwable -> L38
        boolean layoutNeeded = false;
        int displayCount = this.mRoot.mChildren.size();     // Catch: Throwable -> L14
        int i = 0;
    L10:
        if (i >= displayCount) goto L32;
        DisplayContent displayContent = (DisplayContent) this.mRoot.mChildren.get(i);     // Catch: Throwable -> L14
        Trace.traceBegin(32, "updateRotation: display");     // Catch: Throwable -> L14
        boolean rotationChanged = displayContent.updateRotationUnchecked();     // Catch: Throwable -> L14
        Trace.traceEnd(32);     // Catch: Throwable -> L14
        if (rotationChanged == false) goto L16;
        this.mAtmService.getTaskChangeNotificationController().notifyOnActivityRotation(displayContent.mDisplayId);     // Catch: Throwable -> L14
    L16:
        if (rotationChanged == true) goto L18;
    L22:
        boolean pendingRemoteDisplayChange = false;
    L24:
        if (pendingRemoteDisplayChange == true) goto L30;
        if (forceRelayout == false) goto L27;
        displayContent.setLayoutNeeded();     // Catch: Throwable -> L14
        layoutNeeded = true;
    L27:
        if (rotationChanged == true) goto L29;
        if (alwaysSendConfiguration == false) goto L30;
    L29:
        displayContent.sendNewConfiguration();     // Catch: Throwable -> L14
    L30:
        i = i + 1;     // Catch: Throwable -> L14
        goto L10
    L18:
        if (displayContent.mRemoteDisplayChangeController.isWaitingForRemoteDisplayChange() == false) goto L20;
    L21:
        pendingRemoteDisplayChange = true;
        goto L24
    L20:
        if (displayContent.mTransitionController.isCollecting() == false) goto L22;
    L32:
        if (layoutNeeded == false) goto L34;
        Trace.traceBegin(32, "updateRotation: performSurfacePlacement");     // Catch: Throwable -> L14
        this.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L14
        Trace.traceEnd(32);     // Catch: Throwable -> L14
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L38
        Binder.restoreCallingIdentity(origId);
        Trace.traceEnd(32);
        return;
    L14:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        Trace.traceEnd(32);
        throw th;
    }

    public int getDefaultDisplayRotation() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        int r1 = getDefaultDisplayContentLocked().getRotation();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setDisplayChangeWindowController(IDisplayChangeWindowController controller) {
        ActivityTaskManagerService.enforceTaskPermission("setDisplayWindowRotationController");
        WindowManagerGlobalLock r0 = this.mGlobalLock;     // Catch: RemoteException -> L14
        boostPriorityForLockedSection();     // Catch: RemoteException -> L14
        monitor-enter(r0);     // Catch: RemoteException -> L14
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: RemoteException -> L14
        throw th;     // Catch: RemoteException -> L14
    L6:
        if (this.mDisplayChangeController == null) goto L10;
        this.mDisplayChangeController.asBinder().unlinkToDeath(this.mDisplayChangeControllerDeath, 0);     // Catch: Throwable -> L8
        this.mDisplayChangeController = null;     // Catch: Throwable -> L8
    L10:
        controller.asBinder().linkToDeath(this.mDisplayChangeControllerDeath, 0);     // Catch: Throwable -> L8
        this.mDisplayChangeController = controller;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();     // Catch: RemoteException -> L14
        return;
    L14:
        e = move-exception;
        throw new RuntimeException("Unable to set rotation controller", e);
    }

    public SurfaceControl addShellRoot(int displayId, IWindow client, int shellRootLayer) {
        addShellRoot_enforcePermission();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L19
        boostPriorityForLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return null;
    L12:
        SurfaceControl r4 = dc.addShellRoot(client, shellRootLayer);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r4;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void setShellRootAccessibilityWindow(int displayId, int shellRootLayer, IWindow target) {
        setShellRootAccessibilityWindow_enforcePermission();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L22
        boostPriorityForLockedSection();     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        ShellRoot root = dc.mShellRoots.get(shellRootLayer);     // Catch: Throwable -> L10
        if (root != null) goto L17;
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L17:
        root.setAccessibilityWindow(target);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(origId);
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void setDisplayWindowInsetsController(int displayId, IDisplayWindowInsetsController insetsController) {
        setDisplayWindowInsetsController_enforcePermission();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L17
        boostPriorityForLockedSection();     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L12:
        dc.setRemoteInsetsController(insetsController);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(origId);
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void updateDisplayWindowRequestedVisibleTypes(int displayId, int visibleTypes, int mask, ImeTracker.Token statsToken) {
        updateDisplayWindowRequestedVisibleTypes_enforcePermission();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L15
        boostPriorityForLockedSection();     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L17
        if (dc == null) goto L19;
        if (dc.mRemoteInsetsControlTarget == null) goto L19;
        ImeTracker.forLogging().onProgress(statsToken, 69);     // Catch: Throwable -> L17
        int changedTypes = dc.mRemoteInsetsControlTarget.updateRequestedVisibleTypes(visibleTypes, mask);     // Catch: Throwable -> L17
        dc.getInsetsStateController().onRequestedVisibleTypesChanged(dc.mRemoteInsetsControlTarget, changedTypes, statsToken);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(origId);
        return;
    L19:
        ImeTracker.forLogging().onFailed(statsToken, 69);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L17:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public void updateDisplayWindowAnimatingTypes(int displayId, int animatingTypes, ImeTracker.Token statsToken) {
        updateDisplayWindowAnimatingTypes_enforcePermission();
    }

    public int watchRotation(IRotationWatcher watcher, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (displayContent == null) goto L13;
        this.mRotationWatcherController.registerDisplayRotationWatcher(watcher, displayId);     // Catch: Throwable -> L10
        int r2 = displayContent.getRotation();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r2;
    L13:
        throw new IllegalArgumentException("Trying to register rotation event for invalid display: " + displayId);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void removeRotationWatcher(IRotationWatcher watcher) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mRotationWatcherController.removeRotationWatcher(watcher);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public int registerProposedRotationListener(IBinder contextToken, IRotationWatcher listener) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowContainer<?> wc = this.mRotationWatcherController.getAssociatedWindowContainer(contextToken);     // Catch: Throwable -> L10
        if (wc != null) goto L12;
        Slog.w(TAG, "Register rotation listener from non-existing token, uid=" + Binder.getCallingUid());     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return 0;
    L12:
        this.mRotationWatcherController.registerProposedRotationListener(listener, contextToken);     // Catch: Throwable -> L10
        WindowOrientationListener orientationListener = wc.mDisplayContent.getDisplayRotation().getOrientationListener();     // Catch: Throwable -> L10
        if (orientationListener == null) goto L19;
        int rotation = orientationListener.getProposedRotation();     // Catch: Throwable -> L10
        if (rotation < 0) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return rotation;
    L19:
        int r3 = wc.getWindowConfiguration().getRotation();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r3;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean registerWallpaperVisibilityListener(IWallpaperVisibilityListener listener, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (displayContent == null) goto L13;
        this.mWallpaperVisibilityListeners.registerWallpaperVisibilityListener(listener, displayId);     // Catch: Throwable -> L10
        boolean r2 = displayContent.mWallpaperController.isWallpaperVisible();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return r2;
    L13:
        throw new IllegalArgumentException("Trying to register visibility event for invalid display: " + displayId);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void unregisterWallpaperVisibilityListener(IWallpaperVisibilityListener listener, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mWallpaperVisibilityListeners.unregisterWallpaperVisibilityListener(listener, displayId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void registerSystemGestureExclusionListener(ISystemGestureExclusionListener listener, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (displayContent == null) goto L13;
        displayContent.registerSystemGestureExclusionListener(listener);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L13:
        throw new IllegalArgumentException("Trying to register system gesture exclusion event for invalid display: " + displayId);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void unregisterSystemGestureExclusionListener(ISystemGestureExclusionListener listener, int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (displayContent == null) goto L13;
        displayContent.unregisterSystemGestureExclusionListener(listener);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L13:
        throw new IllegalArgumentException("Trying to unregister system gesture exclusion event for invalid display: " + displayId);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void registerDecorViewGestureListener(IDecorViewGestureListener listener, int displayId) {
        if (checkCallingPermission("android.permission.MONITOR_INPUT", "registerDecorViewGestureListener()") == false) goto L20;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent == null) goto L15;
        displayContent.registerDecorViewGestureListener(listener);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L15:
        throw new IllegalArgumentException("Trying to register DecorView gesture event listenerfor invalid display: " + displayId);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L20:
        throw new SecurityException("Requires MONITOR_INPUT permission");
    }

    public void unregisterDecorViewGestureListener(IDecorViewGestureListener listener, int displayId) {
        if (checkCallingPermission("android.permission.MONITOR_INPUT", "unregisterSystemGestureExclusionListener()") == false) goto L20;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent == null) goto L15;
        displayContent.unregisterDecorViewGestureListener(listener);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L15:
        throw new IllegalArgumentException("Trying to unregister DecorView gesture event listenerfor invalid display: " + displayId);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L20:
        throw new SecurityException("Requires MONITOR_INPUT permission");
    }

    void reportDecorViewGestureChanged(Session session, IWindow window, boolean intercepted) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = windowForClientLocked(session, window, false);     // Catch: Throwable -> L10
        if (win != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L12:
        win.getDisplayContent().updateDecorViewGestureIntercepted(win.mToken.token, intercepted);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void reportSystemGestureExclusionChanged(Session session, IWindow window, List<Rect> exclusionRects) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = windowForClientLocked(session, window, false);     // Catch: Throwable -> L11
        if (win != null) goto L14;
        Slog.i(TAG, "reportSystemGestureExclusionChanged(): No window state for package:" + session.mPackageName);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L14:
        if (win.setSystemGestureExclusion(exclusionRects) == false) goto L16;
        win.getDisplayContent().updateSystemGestureExclusion();     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void reportKeepClearAreasChanged(Session session, IWindow window, List<Rect> restricted, List<Rect> unrestricted) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = windowForClientLocked(session, window, false);     // Catch: Throwable -> L11
        if (win != null) goto L14;
        Slog.i(TAG, "reportKeepClearAreasChanged(): No window state for package:" + session.mPackageName);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L14:
        if (win.setKeepClearAreas(restricted, unrestricted) == false) goto L16;
        win.getDisplayContent().updateKeepClearAreas();     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void registerDisplayFoldListener(IDisplayFoldListener listener) {
        this.mPolicy.registerDisplayFoldListener(listener);
    }

    public void unregisterDisplayFoldListener(IDisplayFoldListener listener) {
        this.mPolicy.unregisterDisplayFoldListener(listener);
    }

    void setOverrideFoldedArea(Rect area) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SECURE_SETTINGS") != 0) goto L21;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L12
        boostPriorityForLockedSection();     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        this.mPolicy.setOverrideFoldedArea(area);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(origId);
        return;
    L14:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L21:
        throw new SecurityException("Must hold permission android.permission.WRITE_SECURE_SETTINGS");
    }

    Rect getFoldedArea() {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L13
        boostPriorityForLockedSection();     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        Rect r3 = this.mPolicy.getFoldedArea();     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r3;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public int[] registerDisplayWindowListener(IDisplayWindowListener listener) {
        ActivityTaskManagerService.enforceTaskPermission("registerDisplayWindowListener");
        long ident = Binder.clearCallingIdentity();
        int[] r2 = this.mDisplayNotificationController.registerListener(listener);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void unregisterDisplayWindowListener(IDisplayWindowListener listener) {
        ActivityTaskManagerService.enforceTaskPermission("unregisterDisplayWindowListener");
        this.mDisplayNotificationController.unregisterListener(listener);
    }

    public int getPreferredOptionsPanelGravity(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (displayContent != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return 81;
    L11:
        int r2 = displayContent.getPreferredOptionsPanelGravity();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean startViewServer(int port) {
        if (isSystemSecure() == false) goto L6;
        return false;
    L6:
        if (checkCallingPermission("android.permission.DUMP", "startViewServer") == true) goto L9;
        return false;
    L9:
        if (port >= 1024) goto L12;
        return false;
    L12:
        if (this.mViewServer != null) goto L14;
        this.mViewServer = new ViewServer(this, port);     // Catch: IOException -> L24
        return this.mViewServer.start();
    L26:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L28;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 8664813170125714536L, 0, null);
    L28:
        return false;
    L14:
        if (this.mViewServer.isRunning() == false) goto L29;
    L21:
        return false;
    L29:
        return this.mViewServer.start();
    L19:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L21;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 8664813170125714536L, 0, null);
        goto L21
    }

    private boolean isSystemSecure() {
        if ("1".equals(SystemProperties.get(SYSTEM_SECURE, "1")) == true) goto L5;
    L7:
        return false;
    L5:
        if ("0".equals(SystemProperties.get(SYSTEM_DEBUGGABLE, "0")) == false) goto L7;
        return true;
    }

    public boolean stopViewServer() {
        if (isSystemSecure() == false) goto L6;
        return false;
    L6:
        if (checkCallingPermission("android.permission.DUMP", "stopViewServer") == true) goto L9;
        return false;
    L9:
        if (this.mViewServer != null) goto L11;
        return false;
    L11:
        return this.mViewServer.stop();
    }

    public boolean isViewServerRunning() {
        if (isSystemSecure() == false) goto L6;
        return false;
    L6:
        if (checkCallingPermission("android.permission.DUMP", "isViewServerRunning") == true) goto L9;
        return false;
    L9:
        if (this.mViewServer != null) goto L11;
        return false;
    L11:
        if (this.mViewServer.isRunning() == false) goto L15;
        return true;
    L15:
        return false;
    }

    boolean viewServerListWindows(Socket client) {
        if (isSystemSecure() == false) goto L5;
        return false;
    L5:
        final ArrayList<WindowState> windows = new ArrayList();
        WindowManagerGlobalLock r3 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mRoot.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda15(windows), false);     // Catch: Throwable -> L34
        monitor-exit(r3);     // Catch: Throwable -> L34
        resetPriorityAfterLockedSection();
        BufferedWriter out = null;
        OutputStream clientStream = client.getOutputStream();     // Catch: Throwable -> L13 Exception -> L15
        out = new BufferedWriter(new OutputStreamWriter(clientStream), 8192);     // Catch: Throwable -> L13 Exception -> L15
        int count = windows.size();     // Catch: Throwable -> L13 Exception -> L15
        int i = 0;
    L11:
        if (i >= count) goto L17;
        WindowState w = windows.get(i);     // Catch: Throwable -> L13 Exception -> L15
        out.write(Integer.toHexString(System.identityHashCode(w)));     // Catch: Throwable -> L13 Exception -> L15
        out.write(32);     // Catch: Throwable -> L13 Exception -> L15
        out.append(w.mAttrs.getTitle());     // Catch: Throwable -> L13 Exception -> L15
        out.write(10);     // Catch: Throwable -> L13 Exception -> L15
        i = i + 1;     // Catch: Throwable -> L13 Exception -> L15
        goto L11
    L17:
        out.write("DONE.\n");     // Catch: Throwable -> L13 Exception -> L15
        out.flush();     // Catch: Throwable -> L13 Exception -> L15
        out.close();     // Catch: IOException -> L20
        return true;
    L13:
        th = move-exception;
        if (out != null) goto L41;
    L28:
        throw th;
    L41:
        out.close();     // Catch: IOException -> L26
    L21:
        return false;
    L30:
        if (out == null) goto L33;
        out.close();     // Catch: IOException -> L20
        return false;
    L33:
        return false;
    L34:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$viewServerListWindows$10(ArrayList windows, WindowState w) {
        windows.add(w);
    }

    boolean viewServerGetFocusedWindow(Socket client) {
        if (isSystemSecure() == false) goto L6;
        return false;
    L6:
        WindowState focusedWindow = getFocusedWindow();
        BufferedWriter out = null;
        OutputStream clientStream = client.getOutputStream();     // Catch: Throwable -> L10 Exception -> L12
        out = new BufferedWriter(new OutputStreamWriter(clientStream), 8192);     // Catch: Throwable -> L10 Exception -> L12
        if (focusedWindow == null) goto L14;
        out.write(Integer.toHexString(System.identityHashCode(focusedWindow)));     // Catch: Throwable -> L10 Exception -> L12
        out.write(32);     // Catch: Throwable -> L10 Exception -> L12
        out.append(focusedWindow.mAttrs.getTitle());     // Catch: Throwable -> L10 Exception -> L12
    L14:
        out.write(10);     // Catch: Throwable -> L10 Exception -> L12
        out.flush();     // Catch: Throwable -> L10 Exception -> L12
        out.close();     // Catch: IOException -> L17
        return true;
    L10:
        th = move-exception;
        if (out != null) goto L31;
    L25:
        throw th;
    L31:
        out.close();     // Catch: IOException -> L23
    L18:
        return false;
    L27:
        if (out == null) goto L30;
        out.close();     // Catch: IOException -> L17
        return false;
    L30:
        return false;
    }

    boolean viewServerWindowCommand(Socket client, String command, String parameters) {
        String parameters2 = parameters;
        if (isSystemSecure() == false) goto L5;
        return false;
    L5:
        boolean success = true;
        Parcel data = null;
        Parcel reply = null;
        BufferedWriter out = null;
        int index = parameters2.indexOf(32);     // Catch: Throwable -> L9 Exception -> L11
        if (index != (-1)) goto L13;
        int index2 = parameters2.length();     // Catch: Throwable -> L9 Exception -> L11
    L14:
        String code = parameters2.substring(0, index2);     // Catch: Throwable -> L9 Exception -> L11
        int hashCode = (int) Long.parseLong(code, 16);     // Catch: Throwable -> L9 Exception -> L11
        if (index2 >= parameters2.length()) goto L18;
        parameters2 = parameters2.substring(index2 + 1);     // Catch: Throwable -> L9 Exception -> L11
    L84:
        WindowState window = findWindow(hashCode);     // Catch: Throwable -> L48 Exception -> L50
        if (window != null) goto L32;
        if (0 == 0) goto L25;
        data.recycle();
    L25:
        if (0 == 0) goto L27;
        reply.recycle();
    L27:
        if (0 != 0) goto L80;
    L31:
        return false;
    L80:
        out.close();     // Catch: IOException -> L30
        goto L31
    L32:
        data = Parcel.obtain();     // Catch: Throwable -> L48 Exception -> L50
        data.writeInterfaceToken("android.view.IWindow");     // Catch: Throwable -> L48 Exception -> L50
        String r12 = command;
        data.writeString(r12);     // Catch: Throwable -> L38 Exception -> L40
        data.writeString(parameters2);     // Catch: Throwable -> L38 Exception -> L40
        data.writeInt(1);     // Catch: Throwable -> L38 Exception -> L40
        ParcelFileDescriptor.fromSocket(client).writeToParcel(data, 0);     // Catch: Throwable -> L38 Exception -> L40
        reply = Parcel.obtain();     // Catch: Throwable -> L38 Exception -> L40
        IBinder binder = window.mClient.asBinder();     // Catch: Throwable -> L38 Exception -> L40
        binder.transact(1, data, reply, 0);     // Catch: Throwable -> L38 Exception -> L40
        reply.readException();     // Catch: Throwable -> L38 Exception -> L40
        if (client.isOutputShutdown() == true) goto L42;
        out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));     // Catch: Throwable -> L38 Exception -> L40
        out.write("DONE\n");     // Catch: Throwable -> L38 Exception -> L40
        out.flush();     // Catch: Throwable -> L38 Exception -> L40
    L42:
        data.recycle();
        reply.recycle();
        if (out == null) goto L64;
        out.close();     // Catch: IOException -> L46
    L75:
    L40:
        e = e;
    L54:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L56;
        String protoLogParam0 = String.valueOf(r12);     // Catch: Throwable -> L38
        String protoLogParam1 = String.valueOf(parameters2);     // Catch: Throwable -> L38
        String protoLogParam2 = String.valueOf(e);     // Catch: Throwable -> L38
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -8019372496359375449L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});     // Catch: Throwable -> L38
    L56:
        success = false;
        if (data == null) goto L59;
        data.recycle();
    L59:
        if (reply == null) goto L61;
        reply.recycle();
    L61:
        if (out == null) goto L64;
        out.close();     // Catch: IOException -> L46
        goto L75
    L50:
        e = e;
        r12 = command;
    L48:
        th = move-exception;
        Throwable r2 = th;
    L65:
        if (data == null) goto L67;
        data.recycle();
    L67:
        if (0 == 0) goto L69;
        reply.recycle();
    L69:
        if (0 == 0) goto L87;
        out.close();     // Catch: IOException -> L72
        throw r2;
    L73:
        throw r2;
    L87:
        throw r2;
    L18:
        parameters2 = "";
        goto L84
    L13:
        index2 = index;
    L38:
        th = move-exception;
        r2 = th;
    L11:
        e = e;
        r12 = command;
    L9:
        th = move-exception;
        r2 = th;
    L64:
        return success;
    }

    void addWindowChangeListener(WindowChangeListener listener) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mWindowChangeListeners.add(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void removeWindowChangeListener(WindowChangeListener listener) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mWindowChangeListeners.remove(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void addWindowFocusChangeListener(WindowManagerInternal.WindowFocusChangeListener listener) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mWindowFocusChangeListeners.add(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void removeWindowFocusChangeListener(WindowManagerInternal.WindowFocusChangeListener listener) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mWindowFocusChangeListeners.remove(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private void notifyWindowRemovedListeners(final IBinder client) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mOnWindowRemovedListeners.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L11:
        final WindowManagerInternal.OnWindowRemovedListener[] windowRemovedListeners = new WindowManagerInternal.OnWindowRemovedListener[this.mOnWindowRemovedListeners.size()];     // Catch: Throwable -> L9
        this.mOnWindowRemovedListeners.toArray(windowRemovedListeners);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        this.mH.post(new WindowManagerService$$ExternalSyntheticLambda29(windowRemovedListeners, client));
    }

    private static /* synthetic */ void lambda$notifyWindowRemovedListeners$11(WindowManagerInternal.OnWindowRemovedListener[] windowRemovedListeners, IBinder client) {
        int size = windowRemovedListeners.length;
        int i = 0;
    L3:
        if (i >= size) goto L6;
        windowRemovedListeners[i].onWindowRemoved(client);
        i = i + 1;
        goto L3
    }

    private void notifyWindowsChanged() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mWindowChangeListeners.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L11:
        WindowChangeListener[] windowChangeListeners = new WindowChangeListener[this.mWindowChangeListeners.size()];     // Catch: Throwable -> L9
        WindowChangeListener[] windowChangeListeners2 = (WindowChangeListener[]) this.mWindowChangeListeners.toArray(windowChangeListeners);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        int N = windowChangeListeners2.length;
        int i = 0;
    L14:
        if (i >= N) goto L17;
        windowChangeListeners2[i].windowsChanged();
        i = i + 1;
        goto L14
    }

    private void notifyFocusChanged(IBinder focusedWindowToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mWindowFocusChangeListeners.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L11:
        WindowManagerInternal.WindowFocusChangeListener[] windowFocusChangeListeners = new WindowManagerInternal.WindowFocusChangeListener[this.mWindowFocusChangeListeners.size()];     // Catch: Throwable -> L9
        this.mWindowFocusChangeListeners.toArray(windowFocusChangeListeners);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        int N = windowFocusChangeListeners.length;
        int i = 0;
    L14:
        if (i >= N) goto L17;
        windowFocusChangeListeners[i].focusChanged(focusedWindowToken);
        i = i + 1;
        goto L14
    }

    private WindowState findWindow(final int hashCode) {
        if (hashCode == (-1)) goto L5;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState r1 = this.mRoot.getWindow(new WindowManagerService$$ExternalSyntheticLambda39(hashCode));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r1;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        return getFocusedWindow();
    }

    private static /* synthetic */ boolean lambda$findWindow$12(int hashCode, WindowState w) {
        if (System.identityHashCode(w) != hashCode) goto L5;
        return true;
    L5:
        return false;
    }

    public Configuration computeNewConfiguration(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        Configuration r1 = computeNewConfigurationLocked(displayId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private Configuration computeNewConfigurationLocked(int displayId) {
        if (this.mDisplayReady == true) goto L6;
        return null;
    L6:
        Configuration config = new Configuration();
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);
        displayContent.computeScreenConfiguration(config);
        return config;
    }

    void notifyHardKeyboardStatusChange() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowManagerInternal.OnHardKeyboardStatusChangeListener listener = this.mHardKeyboardStatusChangeListener;     // Catch: Throwable -> L10
        boolean available = this.mHardKeyboardAvailable;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        if (listener == null) goto L16;
        listener.onHardKeyboardStatusChange(available);
        return;
    L16:
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setEventDispatching(boolean enabled) {
        if (checkCallingPermission("android.permission.MANAGE_APP_TOKENS", "setEventDispatching()") == false) goto L18;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mEventDispatchingEnabled = enabled;     // Catch: Throwable -> L9
        if (this.mDisplayEnabled == false) goto L11;
        this.mInputManagerCallback.setEventDispatchingLw(enabled);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L18:
        throw new SecurityException("Requires MANAGE_APP_TOKENS permission");
    }

    private WindowState getFocusedWindow() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState r1 = getFocusedWindowLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    WindowState getFocusedWindowLocked() {
        return this.mRoot.getTopFocusedDisplayContent().mCurrentFocus;
    }

    Task getImeFocusRootTaskLocked() {
        DisplayContent topFocusedDisplay = this.mRoot.getTopFocusedDisplayContent();
        ActivityRecord focusedApp = topFocusedDisplay.mFocusedApp;
        if (focusedApp != null) goto L5;
    L7:
        return null;
    L5:
        if (focusedApp.getTask() == null) goto L7;
        return focusedApp.getTask().getRootTask();
    }

    public boolean detectSafeMode() {
        if (this.mInputManagerCallback.waitForInputDevicesReady(1000) == true) goto L8;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L8;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 1893303527772009363L, 1, new Object[]{1000L});
    L8:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "safe_boot_disallowed", 0) == 0) goto L10;
        return false;
    L10:
        int menuState = this.mInputManager.getKeyCodeState(-1, -256, 82);
        int sState = this.mInputManager.getKeyCodeState(-1, -256, 47);
        int dpadState = this.mInputManager.getKeyCodeState(-1, 513, 23);
        int trackballState = this.mInputManager.getScanCodeState(-1, 65540, 272);
        int volumeDownState = this.mInputManager.getKeyCodeState(-1, -256, 25);
        if (menuState > 0) goto L18;
        if (sState > 0) goto L18;
        if (dpadState > 0) goto L18;
        if (trackballState > 0) goto L18;
        if (volumeDownState > 0) goto L18;
        boolean r8 = false;
    L19:
        this.mSafeMode = r8;
        if (SystemProperties.getInt(ShutdownThread.REBOOT_SAFEMODE_PROPERTY, 0) == 0) goto L23;
    L27:
        this.mSafeMode = true;     // Catch: IllegalArgumentException -> L25
        SystemProperties.set(ShutdownThread.REBOOT_SAFEMODE_PROPERTY, "");     // Catch: IllegalArgumentException -> L25
        goto L30
    L23:
        if (SystemProperties.getInt(ShutdownThread.RO_SAFEMODE_PROPERTY, 0) != 0) goto L27;
    L30:
        if (this.mSafeMode == false) goto L39;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[2] == false) goto L36;
        long protoLogParam0 = menuState;
        long protoLogParam1 = sState;
        long protoLogParam2 = dpadState;
        long protoLogParam3 = trackballState;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_ERROR, -3652974372240081071L, 85, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3)});
    L36:
        if (SystemProperties.getInt(ShutdownThread.RO_SAFEMODE_PROPERTY, 0) != 0) goto L41;
        SystemProperties.set(ShutdownThread.RO_SAFEMODE_PROPERTY, "1");
    L41:
        this.mPolicy.setSafeMode(this.mSafeMode);
        return this.mSafeMode;
    L39:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[2] == false) goto L41;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_ERROR, 4945624619344146947L, 0, null);
    L18:
        r8 = true;
        goto L19
    }

    public void displayReady() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mMaxUiWidth <= 0) goto L9;
        this.mRoot.forAllDisplays(new WindowManagerService$$ExternalSyntheticLambda5(this));     // Catch: Throwable -> L7
    L9:
        applyForcedPropertiesForDefaultDisplay();     // Catch: Throwable -> L7
        this.mAnimator.ready();     // Catch: Throwable -> L7
        this.mDisplayReady = true;     // Catch: Throwable -> L7
        this.mHasWideColorGamutSupport = queryWideColorGamutSupport();     // Catch: Throwable -> L7
        this.mHasHdrSupport = queryHdrSupport();     // Catch: Throwable -> L7
        this.mIsTouchDevice = this.mContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen");     // Catch: Throwable -> L7
        this.mIsFakeTouchDevice = this.mContext.getPackageManager().hasSystemFeature("android.hardware.faketouch");     // Catch: Throwable -> L7
        this.mRoot.forAllDisplays(new WindowManagerService$$ExternalSyntheticLambda6());     // Catch: Throwable -> L7
        this.mDisplayWindowSettingsProvider.removeStaleDisplaySettingsLocked(this, this.mRoot);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
    }

    private /* synthetic */ void lambda$displayReady$13(DisplayContent dc) {
        if (dc.mDisplay.getType() != 1) goto L6;
        dc.setMaxUiWidth(this.mMaxUiWidth);
        return;
    }

    public void systemReady() {
        this.mSystemReady = true;
        this.mPolicy.systemReady();
        this.mRoot.forAllDisplayPolicies(new WindowManagerService$$ExternalSyntheticLambda16());
        this.mSnapshotController.systemReady();
        Handler r0 = UiThread.getHandler();
        final SettingsObserver r1 = this.mSettingsObserver;
        r1.getClass();
        r0.post(new WindowManagerService$$ExternalSyntheticLambda17(r1));
        IVrManager vrManager = IVrManager.Stub.asInterface(ServiceManager.getService("vrmanager"));
        if (vrManager != null) goto L21;
    L19:
        getSmtEx().systemReady();
        getExt().systemReady();
        return;
    L21:
        boolean vrModeEnabled = vrManager.getVrModeState();     // Catch: RemoteException -> L14
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: RemoteException -> L14
        boostPriorityForLockedSection();     // Catch: RemoteException -> L14
        monitor-enter(r2);     // Catch: RemoteException -> L14
        vrManager.registerListener(this.mVrStateCallbacks);     // Catch: Throwable -> L9
        if (vrModeEnabled == false) goto L11;
        this.mVrModeEnabled = vrModeEnabled;     // Catch: Throwable -> L9
        this.mVrStateCallbacks.onVrStateChanged(vrModeEnabled);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();     // Catch: RemoteException -> L14
        goto L19
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: RemoteException -> L14
        throw th;     // Catch: RemoteException -> L14
    }

    private static boolean queryWideColorGamutSupport() {
        Optional<Boolean> hasWideColorProp = SurfaceFlingerProperties.has_wide_color_display();
        if (hasWideColorProp.isPresent() == true) goto L5;
        ISurfaceFlingerConfigs surfaceFlinger = ISurfaceFlingerConfigs.getService();     // Catch: NoSuchElementException -> L10 RemoteException -> L12
        OptionalBool hasWideColor = surfaceFlinger.hasWideColorDisplay();     // Catch: NoSuchElementException -> L10 RemoteException -> L12
        if (hasWideColor == null) goto L22;
        return hasWideColor.value;
    L22:
        return false;
    L18:
        return false;
    L17:
        return false;
    L5:
        return hasWideColorProp.get().booleanValue();
    }

    private static boolean queryHdrSupport() {
        Optional<Boolean> hasHdrProp = SurfaceFlingerProperties.has_HDR_display();
        if (hasHdrProp.isPresent() == true) goto L5;
        ISurfaceFlingerConfigs surfaceFlinger = ISurfaceFlingerConfigs.getService();     // Catch: NoSuchElementException -> L10 RemoteException -> L12
        OptionalBool hasHdr = surfaceFlinger.hasHDRDisplay();     // Catch: NoSuchElementException -> L10 RemoteException -> L12
        if (hasHdr == null) goto L22;
        return hasHdr.value;
    L22:
        return false;
    L18:
        return false;
    L17:
        return false;
    L5:
        return hasHdrProp.get().booleanValue();
    }

    InputTarget getInputTargetFromToken(IBinder inputToken) {
        WindowState windowState = this.mInputToWindowMap.get(inputToken);
        if (windowState == null) goto L5;
        return windowState;
    L5:
        EmbeddedWindowController.EmbeddedWindow embeddedWindow = this.mEmbeddedWindowController.get(inputToken);
        if (embeddedWindow == null) goto L8;
        return embeddedWindow;
    L8:
        return null;
    }

    InputTarget getInputTargetFromWindowTokenLocked(IBinder windowToken) {
        InputTarget window = this.mWindowMap.get(windowToken);
        if (window == null) goto L6;
        return window;
    L6:
        return this.mEmbeddedWindowController.getByWindowToken(windowToken);
    }

    void reportFocusChanged(IBinder oldToken, IBinder newToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        InputTarget lastTarget = getInputTargetFromToken(oldToken);     // Catch: Throwable -> L11
        InputTarget newTarget = getInputTargetFromToken(newToken);     // Catch: Throwable -> L11
        if (newTarget != null) goto L13;
        if (lastTarget != null) goto L13;
        Slog.v(TAG, "Unknown focus tokens, dropping reportFocusChanged");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L13:
        if (newTarget != null) goto L15;
    L22:
        this.mFocusedInputTarget = newTarget;     // Catch: Throwable -> L11
        this.mAccessibilityController.onFocusChanged(lastTarget, newTarget);     // Catch: Throwable -> L11
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[2] == false) goto L25;
        String protoLogParam0 = String.valueOf(lastTarget);     // Catch: Throwable -> L11
        String protoLogParam1 = String.valueOf(newTarget);     // Catch: Throwable -> L11
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -3428027271337724889L, 0, new Object[]{protoLogParam0, protoLogParam1});     // Catch: Throwable -> L11
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        WindowState lastFocusedWindow = null;
        if (newTarget == null) goto L29;
        WindowState newFocusedWindow = newTarget.getWindowState();
    L30:
        if (newFocusedWindow != null) goto L32;
    L34:
        if (lastTarget == null) goto L36;
        lastFocusedWindow = lastTarget.getWindowState();
    L36:
        if (lastFocusedWindow != null) goto L38;
        return;
    L38:
        if (lastFocusedWindow.mInputChannelToken != oldToken) goto L46;
        lastFocusedWindow.reportFocusChangedSerialized(false);
        return;
    L46:
        return;
    L32:
        if (newFocusedWindow.mInputChannelToken != newToken) goto L34;
        this.mAnrController.onFocusChanged(newFocusedWindow);
        newFocusedWindow.reportFocusChangedSerialized(true);
        notifyFocusChanged(newTarget.getWindowToken());
        goto L34
    L29:
        newFocusedWindow = null;
        goto L30
    L15:
        if (newTarget.getDisplayContent() == null) goto L22;
        if ("PREFETCH_APP".equals(newTarget.getDisplayContent().getDisplay().getName()) == false) goto L22;
        Slog.i(TAG, "skip reportFocusChanged for prefetch. newTarget=" + newTarget + " display=" + newTarget.getDisplayContent().getDisplay());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public IWindowSession openSession(IWindowSessionCallback callback) {
        return new Session(this, callback);
    }

    public void getInitialDisplaySize(int displayId, Point size) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (displayContent != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L7:
        if (displayContent.hasAccess(Binder.getCallingUid()) == false) goto L11;
        size.x = displayContent.mInitialDisplayWidth;     // Catch: Throwable -> L9
        size.y = displayContent.mInitialDisplayHeight;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void getBaseDisplaySize(int displayId, Point size) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (displayContent != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L7:
        if (displayContent.hasAccess(Binder.getCallingUid()) == false) goto L11;
        size.x = displayContent.mBaseDisplayWidth;     // Catch: Throwable -> L9
        size.y = displayContent.mBaseDisplayHeight;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setForcedDisplaySize(int displayId, int width, int height) {
        setForcedDisplaySize_enforcePermission();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L8
        if (displayContent == null) goto L10;
        displayContent.setForcedSize(width, height);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void setForcedDisplayScalingMode(int displayId, int mode) {
        setForcedDisplayScalingMode_enforcePermission();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L8
        if (displayContent == null) goto L10;
        displayContent.setForcedScalingMode(mode);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void setSandboxDisplayApis(int displayId, boolean sandboxDisplayApis) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SECURE_SETTINGS") != 0) goto L24;
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L16
        boostPriorityForLockedSection();     // Catch: Throwable -> L16
        monitor-enter(r2);     // Catch: Throwable -> L16
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (displayContent == null) goto L12;
        displayContent.setSandboxDisplayApis(sandboxDisplayApis);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L24:
        throw new SecurityException("Must hold permission android.permission.WRITE_SECURE_SETTINGS");
    }

    private boolean applyForcedPropertiesForDefaultDisplay() {
        boolean changed = false;
        DisplayContent displayContent = getDefaultDisplayContentLocked();
        if (displayContent.getExt().restoreResolutionFromForcedProperties() == false) goto L5;
        return true;
    L5:
        String sizeStr = Settings.Global.getString(this.mContext.getContentResolver(), "display_size_forced");
        if (sizeStr != null) goto L8;
    L11:
        String sizeStr2 = SystemProperties.get(SIZE_OVERRIDE, null);
    L13:
        if (sizeStr2 != null) goto L15;
    L46:
        char r16 = 2;
    L47:
        int density = getForcedDisplayDensityForUserLocked(this.mCurrentUserId);
        if (density != 0) goto L50;
    L52:
        int mode = Settings.Global.getInt(this.mContext.getContentResolver(), "display_scaling_force", 0);
        boolean r5 = displayContent.mDisplayScalingDisabled;
        if (mode == 0) goto L55;
        boolean r6 = true;
    L56:
        if (r5 != r6) goto L58;
        return changed;
    L58:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[r16] == false) goto L60;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_ERROR, 3781141652793604337L, 0, null);
    L60:
        displayContent.mDisplayScalingDisabled = true;
        return true;
    L55:
        r6 = false;
        goto L56
    L50:
        if (density == displayContent.mBaseDisplayDensity) goto L52;
        displayContent.mBaseDisplayDensity = density;
        changed = true;
        goto L52
    L15:
        if (sizeStr2.length() <= 0) goto L46;
        int pos = sizeStr2.indexOf(44);
        if (pos > 0) goto L19;
    L45:
        r16 = 2;
        goto L47
    L19:
        if (sizeStr2.lastIndexOf(44) != pos) goto L45;
        Point size = displayContent.getValidForcedSize(Integer.parseInt(sizeStr2.substring(0, pos)), Integer.parseInt(sizeStr2.substring(pos + 1)));     // Catch: NumberFormatException -> L39
        int width = size.x;     // Catch: NumberFormatException -> L39
        int height = size.y;     // Catch: NumberFormatException -> L39
        if (displayContent.mBaseDisplayWidth != width) goto L29;
        if (displayContent.mBaseDisplayHeight != height) goto L29;
        r16 = 2;
    L27:
        r16 = 2;
    L29:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[2] == false) goto L41;
        long protoLogParam0 = width;
        long protoLogParam1 = height;
        r16 = 2;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_ERROR, 8641557333789260779L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1)});     // Catch: NumberFormatException -> L35
    L42:
        displayContent.updateBaseDisplayMetrics(width, height, displayContent.mBaseDisplayDensity, displayContent.mBaseDisplayPhysicalXDpi, displayContent.mBaseDisplayPhysicalYDpi);     // Catch: NumberFormatException -> L35
        changed = true;
        goto L47
    L41:
        r16 = 2;
    L40:
        r16 = 2;
        goto L47
    L8:
        if (sizeStr.length() == 0) goto L11;
        sizeStr2 = sizeStr;
        goto L13
    }

    public void clearForcedDisplaySize(int displayId) {
        clearForcedDisplaySize_enforcePermission();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L14
        boostPriorityForLockedSection();     // Catch: Throwable -> L14
        monitor-enter(r2);     // Catch: Throwable -> L14
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L8
        if (displayContent == null) goto L10;
        displayContent.setForcedSize(displayContent.mInitialDisplayWidth, displayContent.mInitialDisplayHeight, displayContent.mInitialPhysicalXDpi, displayContent.mInitialPhysicalYDpi);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public int getInitialDisplayDensity(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent != null) goto L7;
    L14:
        DisplayInfo info = this.mDisplayManagerInternal.getDisplayInfo(displayId);     // Catch: Throwable -> L12
        if (info != null) goto L17;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return -1;
    L17:
        if (info.hasAccess(Binder.getCallingUid()) == false) goto L22;
        int r3 = info.logicalDensityDpi;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r3;
    L7:
        if (displayContent.hasAccess(Binder.getCallingUid()) == false) goto L14;
        int r2 = displayContent.getInitialDisplayDensity();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r2;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public int getBaseDisplayDensity(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent != null) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return -1;
    L7:
        if (displayContent.hasAccess(Binder.getCallingUid()) == false) goto L14;
        int r2 = displayContent.mBaseDisplayDensity;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r2;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public int getDisplayIdByUniqueId(String uniqueId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(uniqueId);     // Catch: Throwable -> L12
        if (displayContent != null) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return -1;
    L7:
        if (displayContent.hasAccess(Binder.getCallingUid()) == false) goto L14;
        int r2 = displayContent.mDisplayId;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r2;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setForcedDisplayDensityForUser(int displayId, int density, int userId) {
        setForcedDisplayDensityForUser_enforcePermission();
        int targetUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "setForcedDisplayDensityForUser", null);
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r1 = this.mGlobalLock;     // Catch: Throwable -> L10
        boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r1);     // Catch: Throwable -> L10
        setForcedDensityLockedInternal(displayId, density, targetUserId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void setForcedDensityLockedInternal(int displayId, int density, int targetUserId) {
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);
        if (displayContent == null) goto L6;
        displayContent.setForcedDensity(density, targetUserId);
        return;
    L6:
        DisplayInfo info = this.mDisplayManagerInternal.getDisplayInfo(displayId);
        if (info == null) goto L9;
        this.mDisplayWindowSettings.setForcedDensity(info, density, targetUserId);
        return;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L14;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, 4530411005602904152L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        return;
    }

    public void clearForcedDisplayDensityForUser(int displayId, int userId) {
        clearForcedDisplayDensityForUser_enforcePermission();
        int callingUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "clearForcedDisplayDensityForUser", null);
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r1 = this.mGlobalLock;     // Catch: Throwable -> L27
        boostPriorityForLockedSection();     // Catch: Throwable -> L27
        monitor-enter(r1);     // Catch: Throwable -> L27
        setForcedDisplayDensityRatioInternal(displayId, 0.0f, userId);     // Catch: Throwable -> L12
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent == null) goto L14;
        displayContent.setForcedDensity(displayContent.getInitialDisplayDensity(), callingUserId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L14:
        DisplayInfo info = this.mDisplayManagerInternal.getDisplayInfo(displayId);     // Catch: Throwable -> L12
        if (info == null) goto L17;
        this.mDisplayWindowSettings.setForcedDensity(info, info.logicalDensityDpi, userId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L27
        Binder.restoreCallingIdentity(ident);
        return;
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L19;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, 2731677607884634244L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L12
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void setForcedDisplayDensityRatio(int displayId, float ratio, int userId) {
        setForcedDisplayDensityRatio_enforcePermission();
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L10
        boostPriorityForLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        setForcedDisplayDensityRatioInternal(displayId, ratio, userId);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void setForcedDisplayDensityRatioInternal(int displayId, float ratio, int userId) {
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);
        if (displayContent == null) goto L6;
        displayContent.setForcedDensityRatio(ratio, userId);
        return;
    L6:
        DisplayInfo info = this.mDisplayManagerInternal.getDisplayInfo(displayId);
        if (info == null) goto L9;
        this.mDisplayWindowSettings.setForcedDensityRatio(info, ratio);
        return;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L14;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, 4530411005602904152L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        return;
    }

    public void setConfigurationChangeSettingsForUser(List<ConfigurationChangeSetting> settings, int userId) {
        setConfigurationChangeSettingsForUser_enforcePermission();
        int callingUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "setConfigurationChangeSettingsForUser", null);
        long ident = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r1 = this.mGlobalLock;     // Catch: Throwable -> L19
        boostPriorityForLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        this.mAtmService.deferWindowLayout();     // Catch: Throwable -> L21
        int i = 0;
    L30:
    L11:
        th = move-exception;
        this.mAtmService.continueWindowLayout();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L8:
        if (i >= settings.size()) goto L14;
        settings.get(i).apply(callingUserId);     // Catch: Throwable -> L11
        i = i + 1;
        goto L30
    L14:
        this.mAtmService.continueWindowLayout();     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(ident);
        return;
    L21:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    int getForcedDisplayDensityForUserLocked(int userId) {
        String densityStr = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "display_density_forced", userId);
        if (densityStr != null) goto L5;
    L6:
        densityStr = SystemProperties.get(DENSITY_OVERRIDE, null);
    L7:
        if (densityStr != null) goto L9;
        return 0;
    L9:
        if (densityStr.length() <= 0) goto L18;
        return Integer.parseInt(densityStr);
    L13:
        return 0;
    L18:
        return 0;
    L5:
        if (densityStr.length() != 0) goto L7;
        goto L6
    }

    public void startWindowTrace() {
        this.mWindowTracing.startTrace(null);
    }

    public void stopWindowTrace() {
        this.mWindowTracing.stopTrace(null);
    }

    public void saveWindowTraceToFile() {
        this.mWindowTracing.saveForBugreport(null);
    }

    public boolean isWindowTraceEnabled() {
        return this.mWindowTracing.isEnabled();
    }

    public void startTransitionTrace() {
        this.mTransitionTracer.startTrace(null);
    }

    public void stopTransitionTrace() {
        this.mTransitionTracer.stopTrace(null);
    }

    public boolean isTransitionTraceEnabled() {
        return this.mTransitionTracer.isTracing();
    }

    public boolean registerCrossWindowBlurEnabledListener(ICrossWindowBlurEnabledListener listener) {
        return this.mBlurController.registerCrossWindowBlurEnabledListener(listener);
    }

    public void unregisterCrossWindowBlurEnabledListener(ICrossWindowBlurEnabledListener listener) {
        this.mBlurController.unregisterCrossWindowBlurEnabledListener(listener);
    }

    final WindowState windowForClientLocked(Session session, IWindow client, boolean throwOnError) {
        return windowForClientLocked(session, client.asBinder(), throwOnError);
    }

    final WindowState windowForClientLocked(Session session, IBinder client, boolean throwOnError) {
        WindowState win = this.mWindowMap.get(client);
        if (WindowManagerDebugConfig.DEBUG == false) goto L6;
        Slog.v(TAG, "Looking up client " + client + ": " + win);
    L6:
        if (win != null) goto L14;
        if (throwOnError == true) goto L13;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L11;
        String protoLogParam0 = String.valueOf(session);
        String protoLogParam1 = String.valueOf(Debug.getCallers(3));
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 4117606810523219596L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L11:
        return null;
    L13:
        throw new IllegalArgumentException("Requested window " + client + " does not exist");
    L14:
        if (session != null) goto L16;
    L24:
        return win;
    L16:
        if (win.mSession == session) goto L24;
        if (throwOnError == true) goto L23;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L21;
        String protoLogParam2 = String.valueOf(session);
        String protoLogParam3 = String.valueOf(Debug.getCallers(3));
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 4117606810523219596L, 0, new Object[]{protoLogParam2, protoLogParam3});
    L21:
        return null;
    L23:
        throw new IllegalArgumentException("Requested window " + client + " is in session " + win.mSession + ", not " + session);
    }

    void checkDrawnWindowsLocked() {
        if (this.mWaitingForDrawnCallbacks.isEmpty() == false) goto L5;
        return;
    L5:
        int i = this.mWaitingForDrawnCallbacks.size() - 1;
    L6:
        if (i < 0) goto L43;
        WindowContainer<?> container = this.mWaitingForDrawnCallbacks.keyAt(i);
        int j = container.mWaitingForDrawn.size() - 1;
    L8:
        if (j < 0) goto L36;
        WindowState win = container.mWaitingForDrawn.get(j);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[2] == false) goto L12;
        String protoLogParam0 = String.valueOf(win);
        boolean protoLogParam1 = win.mRemoved;
        boolean protoLogParam2 = win.isVisible();
        boolean protoLogParam3 = win.mHasSurface;
        long protoLogParam4 = win.mWinAnimator.mDrawState;
        int r16 = 0;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, -1716033239040181528L, TarConstants.XSTAR_MAGIC_OFFSET, new Object[]{protoLogParam0, Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), Long.valueOf(protoLogParam4)});
    L14:
        if (win.mRemoved == true) goto L29;
        if (win.mHasSurface == false) goto L29;
        if (win.isVisibleByPolicy() == false) goto L29;
        if (win.hasDrawn() == false) goto L34;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[r16] == false) goto L25;
        String protoLogParam5 = String.valueOf(win);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, -7561054602203220590L, r16, new Object[]{protoLogParam5});
    L25:
        container.mWaitingForDrawn.remove(win);
        if (Trace.isTagEnabled(32) == false) goto L34;
        traceEndWaitingForWindowDrawn(win);
    L34:
        j = j - 1;
    L29:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[3] == false) goto L31;
        String protoLogParam6 = String.valueOf(win);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, -4609828204247499633L, 0, new Object[]{protoLogParam6});
    L31:
        container.mWaitingForDrawn.remove(win);
        if (Trace.isTagEnabled(32) == false) goto L34;
        traceEndWaitingForWindowDrawn(win);
        goto L34
    L12:
        r16 = 0;
        goto L14
    L36:
        if (container.mWaitingForDrawn.isEmpty() == false) goto L41;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[0] == false) goto L40;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, 2809030008663191766L, 0, null);
    L40:
        this.mH.removeMessages(24, container);
        this.mWaitingForDrawnCallbacks.removeAt(i).sendToTarget();
    L41:
        i = i - 1;
        goto L6
    }

    private void traceStartWaitingForWindowDrawn(WindowState window) {
        String traceName = "waitForAllWindowsDrawn#" + window.getWindowTag();
        String shortenedTraceName = traceName.substring(0, Math.min(127, traceName.length()));
        Trace.asyncTraceBegin(32, shortenedTraceName, 0);
    }

    private void traceEndWaitingForWindowDrawn(WindowState window) {
        String traceName = "waitForAllWindowsDrawn#" + window.getWindowTag();
        String shortenedTraceName = traceName.substring(0, Math.min(127, traceName.length()));
        Trace.asyncTraceEnd(32, shortenedTraceName, 0);
    }

    void requestTraversal() {
        this.mWindowPlacerLocked.requestTraversal();
    }

    void scheduleAnimationLocked() {
        this.mAnimator.scheduleAnimation();
    }

    boolean updateFocusedWindowLocked(int mode, boolean updateInputWindows) {
        Trace.traceBegin(32, "wmUpdateFocus");
        boolean changed = this.mRoot.updateFocusedWindowLocked(mode, updateInputWindows);
        Trace.traceEnd(32);
        return changed;
    }

    static int getPropertyInt(String[] tokens, int index, int defUnits, int defDps, DisplayMetrics dm) {
        if (index >= tokens.length) goto L11;
        String str = tokens[index];
        if (str == null) goto L11;
        if (str.length() <= 0) goto L11;
        int val = Integer.parseInt(str);     // Catch: Exception -> L10
        return val;
    L11:
        if (defUnits != 0) goto L13;
        return defDps;
    L13:
        int val2 = (int) TypedValue.applyDimension(defUnits, defDps, dm);
        return val2;
    }

    void createWatermark() {
        if (this.mWatermark == null) goto L5;
        return;
    L5:
        File file = new File("/system/etc/setup.conf");
        FileInputStream in = null;
        DataInputStream ind = null;
        in = new FileInputStream(file);     // Catch: Throwable -> L14 IOException -> L16 FileNotFoundException -> L18
        ind = new DataInputStream(in);     // Catch: Throwable -> L14 IOException -> L16 FileNotFoundException -> L18
        String line = ind.readLine();     // Catch: Throwable -> L14 IOException -> L16 FileNotFoundException -> L18
        if (line == null) goto L21;
        String[] toks = line.split("%");     // Catch: Throwable -> L14 IOException -> L16 FileNotFoundException -> L18
        if (toks == null) goto L21;
        if (toks.length <= 0) goto L21;
        DisplayContent displayContent = getDefaultDisplayContentLocked();     // Catch: Throwable -> L14 IOException -> L16 FileNotFoundException -> L18
        this.mWatermark = new Watermark(displayContent, displayContent.mRealDisplayMetrics, toks, this.mTransaction);     // Catch: Throwable -> L14 IOException -> L16 FileNotFoundException -> L18
        this.mTransaction.apply();     // Catch: Throwable -> L14 IOException -> L16 FileNotFoundException -> L18
    L21:
        ind.close();     // Catch: IOException -> L23
        return;
    L14:
        th = move-exception;
        if (ind != null) goto L58;
        if (in != null) goto L53;
    L35:
        throw th;
    L53:
        in.close();     // Catch: IOException -> L29
        goto L35
    L58:
        ind.close();     // Catch: IOException -> L33
    L67:
        return;
    L46:
        if (ind == null) goto L49;
        ind.close();     // Catch: IOException -> L23
        return;
    L49:
        if (in == null) goto L63;
        in.close();     // Catch: IOException -> L43
    L55:
        return;
    L63:
        return;
    L37:
        if (ind == null) goto L40;
        ind.close();     // Catch: IOException -> L23
        return;
    L40:
        if (in == null) goto L62;
        in.close();     // Catch: IOException -> L43
        goto L55
    L62:
        return;
    }

    public void setRecentsVisibility(boolean visible) {
        if (checkCallingPermission("android.permission.STATUS_BAR", "setRecentsVisibility()") == false) goto L15;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mPolicy.setRecentsVisibilityLw(visible);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L15:
        throw new SecurityException("Requires STATUS_BAR permission");
    }

    public void hideTransientBars(int displayId) {
        if (checkCallingPermission("android.permission.STATUS_BAR", "hideTransientBars()") == false) goto L19;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (displayContent == null) goto L11;
        displayContent.getInsetsPolicy().hideTransient();     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L11:
        Slog.w(TAG, "hideTransientBars with invalid displayId=" + displayId);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L19:
        throw new SecurityException("Requires STATUS_BAR permission");
    }

    public void updateStaticPrivacyIndicatorBounds(int displayId, Rect[] staticBounds) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L7
        if (displayContent == null) goto L9;
        displayContent.updatePrivacyIndicatorBounds(staticBounds);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L9:
        Slog.w(TAG, "updateStaticPrivacyIndicatorBounds with invalid displayId=" + displayId);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setNavBarVirtualKeyHapticFeedbackEnabled(boolean enabled) {
        setNavBarVirtualKeyHapticFeedbackEnabled_enforcePermission();
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mPolicy.setNavBarVirtualKeyHapticFeedbackEnabledLw(enabled);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void createInputConsumer(IBinder token, String name, int displayId, InputChannel inputChannel) {
        if (this.mAtmService.isCallerRecents(Binder.getCallingUid()) == false) goto L5;
    L9:
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L18
        if (display == null) goto L21;
        display.getInputMonitor().createInputConsumer(token, name, inputChannel, Binder.getCallingPid(), Binder.getCallingUserHandle());     // Catch: Throwable -> L16
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L16
        resetPriorityAfterLockedSection();
        return;
    L16:
        th = move-exception;
        Throwable r9 = th;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L16
        resetPriorityAfterLockedSection();
        throw r9;
    L18:
        th = move-exception;
        r9 = th;
        goto L24
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INPUT_CONSUMER") == 0) goto L9;
        throw new SecurityException("createInputConsumer requires INPUT_CONSUMER permission");
    }

    public boolean destroyInputConsumer(IBinder token, int displayId) {
        if (this.mAtmService.isCallerRecents(Binder.getCallingUid()) == false) goto L5;
    L9:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent display = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L17
        if (display == null) goto L19;
        boolean r2 = display.getInputMonitor().destroyInputConsumer(token);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        resetPriorityAfterLockedSection();
        return r2;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L17
        resetPriorityAfterLockedSection();
        return false;
    L17:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INPUT_CONSUMER") == 0) goto L9;
        throw new SecurityException("destroyInputConsumer requires INPUT_CONSUMER permission");
    }

    public Region getCurrentImeTouchRegion() {
        getCurrentImeTouchRegion_enforcePermission();
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        Region r = new Region();     // Catch: Throwable -> L12
        int i = this.mRoot.mChildren.size() - 1;     // Catch: Throwable -> L12
    L5:
        if (i < 0) goto L16;
        DisplayContent displayContent = (DisplayContent) this.mRoot.mChildren.get(i);     // Catch: Throwable -> L12
        if (displayContent.mInputMethodWindow != null) goto L8;
        i = i - 1;
        goto L5
    L8:
        displayContent.mInputMethodWindow.getTouchableRegion(r);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean hasNavigationBar(int displayId) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (dc != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return false;
    L11:
        boolean r2 = dc.getDisplayPolicy().hasNavigationBar();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void lockNow(Bundle options) {
        this.mPolicy.lockNow(options);
    }

    public void showRecentApps() {
        this.mPolicy.showRecentApps();
    }

    public boolean isSafeModeEnabled() {
        return this.mSafeMode;
    }

    public boolean clearWindowContentFrameStats(IBinder token) {
        if (checkCallingPermission("android.permission.FRAME_STATS", "clearWindowContentFrameStats()") == false) goto L26;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState windowState = this.mWindowMap.get(token);     // Catch: Throwable -> L11
        if (windowState != null) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return false;
    L13:
        SurfaceControl surfaceControl = windowState.mWinAnimator.mSurfaceControl;     // Catch: Throwable -> L11
        if (surfaceControl != null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return false;
    L18:
        boolean r2 = surfaceControl.clearContentFrameStats();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r2;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L26:
        throw new SecurityException("Requires FRAME_STATS permission");
    }

    public WindowContentFrameStats getWindowContentFrameStats(IBinder token) {
        if (checkCallingPermission("android.permission.FRAME_STATS", "getWindowContentFrameStats()") == false) goto L33;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState windowState = this.mWindowMap.get(token);     // Catch: Throwable -> L11
        if (windowState != null) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return null;
    L13:
        SurfaceControl surfaceControl = windowState.mWinAnimator.mSurfaceControl;     // Catch: Throwable -> L11
        if (surfaceControl != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return null;
    L19:
        if (this.mTempWindowRenderStats != null) goto L21;
        this.mTempWindowRenderStats = new WindowContentFrameStats();     // Catch: Throwable -> L11
    L21:
        WindowContentFrameStats stats = this.mTempWindowRenderStats;     // Catch: Throwable -> L11
        if (surfaceControl.getContentFrameStats(stats) == true) goto L26;
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return null;
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return stats;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L33:
        throw new SecurityException("Requires FRAME_STATS permission");
    }

    private void dumpPolicyLocked(PrintWriter pw, String[] args) {
        pw.println("WINDOW MANAGER POLICY STATE (dumpsys window policy)");
        this.mPolicy.dump("    ", pw, args);
    }

    private void dumpAnimatorLocked(PrintWriter pw, boolean dumpAll) {
        pw.println("WINDOW MANAGER ANIMATOR STATE (dumpsys window animator)");
        this.mAnimator.dumpLocked(pw, "    ", dumpAll);
    }

    private void dumpTokensLocked(PrintWriter pw, boolean dumpAll) {
        pw.println("WINDOW MANAGER TOKENS (dumpsys window tokens)");
        this.mRoot.dumpTokens(pw, dumpAll);
    }

    private void dumpHighRefreshRateBlacklist(PrintWriter pw) {
        pw.println("WINDOW MANAGER HIGH REFRESH RATE BLACKLIST (dumpsys window refresh)");
        this.mHighRefreshRateDenylist.dump(pw);
    }

    private void dumpTraceStatus(PrintWriter pw) {
        pw.println("WINDOW MANAGER TRACE (dumpsys window trace)");
        pw.print(this.mWindowTracing.getStatus() + "\n");
    }

    private void dumpLogStatus(PrintWriter pw) {
        pw.println("WINDOW MANAGER LOGGING (dumpsys window logging)");
        pw.println("Deprecated legacy command. Use Perfetto commands instead.");
    }

    private void dumpSessionsLocked(PrintWriter pw) {
        pw.println("WINDOW MANAGER SESSIONS (dumpsys window sessions)");
        int i = 0;
    L4:
        if (i >= this.mSessions.size()) goto L7;
        Session s = this.mSessions.valueAt(i);
        pw.print("  Session ");
        pw.print(s);
        pw.println(':');
        s.dump(pw, "    ");
        i = i + 1;
        goto L4
    }

    void dumpDebugLocked(ProtoOutputStream proto, int logLevel) {
        Trace.traceBegin(32, "dumpDebugLocked");
        this.mPolicy.dumpDebug(proto, 1146756268033L);     // Catch: Throwable -> L6
        this.mRoot.dumpDebug(proto, 1146756268034L, logLevel);     // Catch: Throwable -> L6
        DisplayContent topFocusedDisplayContent = this.mRoot.getTopFocusedDisplayContent();     // Catch: Throwable -> L6
        if (topFocusedDisplayContent.mCurrentFocus == null) goto L9;
        topFocusedDisplayContent.mCurrentFocus.writeIdentifierToProto(proto, 1146756268035L);     // Catch: Throwable -> L6
    L9:
        if (topFocusedDisplayContent.mFocusedApp == null) goto L11;
        topFocusedDisplayContent.mFocusedApp.writeNameToProto(proto, 1138166333444L);     // Catch: Throwable -> L6
    L11:
        WindowState imeWindow = this.mRoot.getCurrentInputMethodWindow();     // Catch: Throwable -> L6
        if (imeWindow == null) goto L14;
        imeWindow.writeIdentifierToProto(proto, 1146756268037L);     // Catch: Throwable -> L6
    L14:
        proto.write(1120986464265L, topFocusedDisplayContent.getDisplayId());     // Catch: Throwable -> L6
        proto.write(1133871366154L, this.mHardKeyboardAvailable);     // Catch: Throwable -> L6
        proto.write(1133871366155L, true);     // Catch: Throwable -> L6
        this.mAtmService.mBackNavigationController.dumpDebug(proto, 1146756268044L);     // Catch: Throwable -> L6
        Trace.traceEnd(32);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private void dumpWindowsLocked(final PrintWriter pw, boolean dumpAll, ArrayList<WindowState> windows) {
        pw.println("WINDOW MANAGER WINDOWS (dumpsys window windows)");
        this.mRoot.dumpWindowsNoHeader(pw, dumpAll, windows);
        if (this.mHidingNonSystemOverlayWindows.isEmpty() == true) goto L12;
        pw.println();
        pw.println("  Hiding System Alert Windows:");
        int i = this.mHidingNonSystemOverlayWindows.size() - 1;
    L5:
        if (i < 0) goto L12;
        WindowState w = this.mHidingNonSystemOverlayWindows.get(i);
        pw.print("  #");
        pw.print(i);
        pw.print(' ');
        pw.print(w);
        if (dumpAll == false) goto L9;
        pw.println(":");
        w.dump(pw, "    ", true);
    L10:
        i = i - 1;
        goto L5
    L9:
        pw.println();
    L12:
        if (this.mForceRemoves == null) goto L23;
        if (this.mForceRemoves.isEmpty() == true) goto L23;
        pw.println();
        pw.println("  Windows force removing:");
        int i2 = this.mForceRemoves.size() - 1;
    L16:
        if (i2 < 0) goto L23;
        WindowState w2 = this.mForceRemoves.get(i2);
        pw.print("  Removing #");
        pw.print(i2);
        pw.print(' ');
        pw.print(w2);
        if (dumpAll == false) goto L20;
        pw.println(":");
        w2.dump(pw, "    ", true);
    L21:
        i2 = i2 - 1;
        goto L16
    L20:
        pw.println();
    L23:
        if (this.mDestroySurface.isEmpty() == true) goto L36;
        pw.println();
        pw.println("  Windows waiting to destroy their surface:");
        int i3 = this.mDestroySurface.size() - 1;
    L25:
        if (i3 < 0) goto L36;
        WindowState w3 = this.mDestroySurface.get(i3);
        if (windows != null) goto L29;
    L30:
        pw.print("  Destroy #");
        pw.print(i3);
        pw.print(' ');
        pw.print(w3);
        if (dumpAll == false) goto L33;
        pw.println(":");
        w3.dump(pw, "    ", true);
    L34:
        i3 = i3 - 1;
        goto L25
    L33:
        pw.println();
        goto L34
    L29:
        if (windows.contains(w3) == false) goto L34;
    L36:
        if (this.mResizingWindows.isEmpty() == true) goto L49;
        pw.println();
        pw.println("  Windows waiting to resize:");
        int i4 = this.mResizingWindows.size() - 1;
    L38:
        if (i4 < 0) goto L49;
        WindowState w4 = this.mResizingWindows.get(i4);
        if (windows != null) goto L42;
    L43:
        pw.print("  Resizing #");
        pw.print(i4);
        pw.print(' ');
        pw.print(w4);
        if (dumpAll == false) goto L46;
        pw.println(":");
        w4.dump(pw, "    ", true);
    L47:
        i4 = i4 - 1;
        goto L38
    L46:
        pw.println();
        goto L47
    L42:
        if (windows.contains(w4) == false) goto L47;
    L49:
        if (this.mWaitingForDrawnCallbacks.isEmpty() == true) goto L51;
        pw.println();
        pw.println("  Clients waiting for these windows to be drawn:");
        this.mWaitingForDrawnCallbacks.forEach(new WindowManagerService$$ExternalSyntheticLambda7(pw));
    L51:
        pw.println();
        pw.print("  mGlobalConfiguration=");
        pw.println(this.mRoot.getConfiguration());
        pw.print("  mHasPermanentDpad=");
        pw.println(this.mHasPermanentDpad);
        this.mRoot.dumpTopFocusedDisplayId(pw);
        this.mRoot.forAllDisplays(new WindowManagerService$$ExternalSyntheticLambda8(pw));
        pw.print("  mBlurEnabled=");
        pw.println(this.mBlurController.getBlurEnabled());
        pw.print("  mDisableSecureWindows=");
        pw.println(this.mDisableSecureWindows);
        this.mInputManagerCallback.dump(pw, "  ");
        this.mSnapshotController.dump(pw, " ");
        dumpAccessibilityController(pw, false);
        if (dumpAll == false) goto L72;
        WindowState imeWindow = this.mRoot.getCurrentInputMethodWindow();
        if (imeWindow == null) goto L56;
        pw.print("  mInputMethodWindow=");
        pw.println(imeWindow);
    L56:
        this.mWindowPlacerLocked.dump(pw, "  ");
        pw.print("  mSystemBooted=");
        pw.print(this.mSystemBooted);
        pw.print(" mDisplayEnabled=");
        pw.println(this.mDisplayEnabled);
        this.mRoot.dumpLayoutNeededDisplayIds(pw);
        pw.print("  mTransactionSequence=");
        pw.println(this.mTransactionSequence);
        DisplayContent defaultDisplayContent = getDefaultDisplayContentLocked();
        pw.print("  mRotation=");
        pw.println(defaultDisplayContent.getRotation());
        pw.print("  mLastOrientation=");
        pw.println(defaultDisplayContent.getLastOrientation());
        pw.print("  mWaitingForConfig=");
        pw.println(defaultDisplayContent.mWaitingForConfig);
        pw.print("  mWindowsInsetsChanged=");
        pw.println(this.mWindowsInsetsChanged);
        this.mRotationWatcherController.dump(pw);
        pw.print("  Animation settings: disabled=");
        pw.print(this.mAnimationsDisabled);
        pw.print(" window=");
        pw.print(this.mWindowAnimationScaleSetting);
        pw.print(" transition=");
        pw.print(this.mTransitionAnimationScaleSetting);
        pw.print(" animator=");
        pw.println(this.mAnimatorDurationScaleSetting);
        return;
    }

    private static /* synthetic */ void lambda$dumpWindowsLocked$14(PrintWriter pw, WindowContainer wc, Message callback) {
        pw.print("  WindowContainer ");
        pw.println(wc.getName());
        int i = wc.mWaitingForDrawn.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowState win = wc.mWaitingForDrawn.get(i);
        pw.print("  Waiting #");
        pw.print(i);
        pw.print(' ');
        pw.print(win);
        i = i - 1;
        goto L3
    }

    private static /* synthetic */ void lambda$dumpWindowsLocked$15(PrintWriter pw, DisplayContent dc) {
        int displayId = dc.getDisplayId();
        InsetsControlTarget imeLayeringTarget = dc.getImeTarget(0);
        InputTarget imeInputTarget = dc.getImeInputTarget();
        InsetsControlTarget imeControlTarget = dc.getImeTarget(2);
        if (imeLayeringTarget == null) goto L5;
        pw.print("  imeLayeringTarget in display# ");
        pw.print(displayId);
        pw.print(' ');
        pw.println(imeLayeringTarget);
    L5:
        if (imeInputTarget == null) goto L7;
        pw.print("  imeInputTarget in display# ");
        pw.print(displayId);
        pw.print(' ');
        pw.println(imeInputTarget);
    L7:
        if (imeControlTarget == null) goto L9;
        pw.print("  imeControlTarget in display# ");
        pw.print(displayId);
        pw.print(' ');
        pw.println(imeControlTarget);
    L9:
        pw.print("  Minimum task size of display#");
        pw.print(displayId);
        pw.print(' ');
        pw.println(dc.mMinSizeOfResizeableTaskDp);
    }

    private void dumpAccessibilityController(PrintWriter pw, boolean force) {
        boolean hasCallbacks = this.mAccessibilityController.hasCallbacks();
        if (hasCallbacks == true) goto L6;
        if (force == true) goto L6;
        return;
    L6:
        if (hasCallbacks == true) goto L8;
        pw.println("AccessibilityController doesn't have callbacks, but printing it anways:");
    L9:
        this.mAccessibilityController.dump(pw, "  ");
        return;
    L8:
        pw.println("AccessibilityController:");
        goto L9
    }

    private void dumpAccessibilityLocked(PrintWriter pw) {
        dumpAccessibilityController(pw, true);
    }

    private boolean dumpWindows(PrintWriter pw, String name, boolean dumpAll) {
        final ArrayList<WindowState> windows = new ArrayList();
        if ("apps".equals(name) == false) goto L5;
    L18:
        final boolean appsOnly = name.contains("apps");
        final boolean visibleOnly = name.contains("visible");
        WindowManagerGlobalLock r4 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r4);
        if (appsOnly == true) goto L46;
    L24:
        this.mRoot.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda37(visibleOnly, appsOnly, windows), true);     // Catch: Throwable -> L22
        monitor-exit(r4);     // Catch: Throwable -> L22
        resetPriorityAfterLockedSection();
    L28:
        if (windows.isEmpty() == false) goto L31;
        return false;
    L31:
        WindowManagerGlobalLock r5 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r5);
        dumpWindowsLocked(pw, dumpAll, windows);     // Catch: Throwable -> L37
        monitor-exit(r5);     // Catch: Throwable -> L37
        resetPriorityAfterLockedSection();
        return true;
    L37:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L22:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L46:
        this.mRoot.dumpDisplayContents(pw);     // Catch: Throwable -> L22
        goto L24
    L5:
        if ("visible".equals(name) == true) goto L18;
        if ("visible-apps".equals(name) == true) goto L18;
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mRoot.getWindowsByName(windows, name);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();
    L14:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$dumpWindows$16(boolean visibleOnly, boolean appsOnly, ArrayList windows, WindowState w) {
        if (visibleOnly == true) goto L4;
    L5:
        if (appsOnly == true) goto L7;
    L8:
        windows.add(w);
        return;
    L7:
        if (w.mActivityRecord != null) goto L8;
        return;
    L4:
        if (w.isVisible() == true) goto L5;
    }

    private void dumpLastANRLocked(PrintWriter pw) {
        pw.println("WINDOW MANAGER LAST ANR (dumpsys window lastanr)");
        if (this.mLastANRState != null) goto L5;
        pw.println("  <no ANR has occurred since boot>");
        return;
    L5:
        pw.println(this.mLastANRState);
    }

    void saveANRStateLocked(ActivityRecord activity, WindowState windowState, String reason) {
        StringWriter sw = new StringWriter();
        final PrintWriter pw = new FastPrintWriter(sw, false, 1024);
        pw.println("  ANR time: " + DateFormat.getDateTimeInstance().format(new Date()));
        if (activity == null) goto L5;
        pw.println("  Application at fault: " + activity.stringName);
    L5:
        if (windowState == null) goto L7;
        pw.println("  Window at fault: " + windowState.mAttrs.getTitle());
    L7:
        if (reason == null) goto L9;
        pw.println("  Reason: " + reason);
    L9:
        pw.println();
        final ArrayList<WindowState> relatedWindows = new ArrayList();
        int i = this.mRoot.getChildCount() - 1;
    L10:
        if (i < 0) goto L19;
        DisplayContent dc = this.mRoot.getChildAt(i);
        int displayId = dc.getDisplayId();
        final WindowState currentFocus = dc.mCurrentFocus;
        final ActivityRecord focusedApp = dc.mFocusedApp;
        pw.println("  Display #" + displayId + " currentFocus=" + currentFocus + " focusedApp=" + focusedApp);
        if (dc.mWinAddedSinceNullFocus.isEmpty() == true) goto L15;
        pw.println("  Windows added in display #" + displayId + " since null focus: " + dc.mWinAddedSinceNullFocus);
    L15:
        if (dc.mWinRemovedSinceNullFocus.isEmpty() == true) goto L17;
        pw.println("  Windows removed in display #" + displayId + " since null focus: " + dc.mWinRemovedSinceNullFocus);
    L17:
        pw.println("  Tasks in top down Z order:");
        dc.forAllTaskDisplayAreas(new WindowManagerService$$ExternalSyntheticLambda27(pw));
        dc.getInputMonitor().dump(pw, "  ");
        pw.println();
        dc.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda28(currentFocus, focusedApp, relatedWindows), true);
        i = i - 1;
        goto L10
    L19:
        if (windowState != null) goto L21;
    L23:
        this.mRoot.dumpWindowsNoHeader(pw, true, relatedWindows);
        pw.println();
        pw.close();
        this.mLastANRState = sw.toString();
        this.mH.removeMessages(38);
        this.mH.sendEmptyMessageDelayed(38, 7200000);
        return;
    L21:
        if (relatedWindows.contains(windowState) == true) goto L23;
        relatedWindows.add(windowState);
        goto L23
    }

    private static /* synthetic */ void lambda$saveANRStateLocked$17(PrintWriter pw, TaskDisplayArea tda) {
        tda.dump(pw, "    ", false);
    }

    private static /* synthetic */ void lambda$saveANRStateLocked$18(WindowState currentFocus, ActivityRecord focusedApp, ArrayList relatedWindows, WindowState w) {
        if (currentFocus != null) goto L4;
    L6:
        if (focusedApp != null) goto L8;
        return;
    L8:
        if (Objects.equals(w.mAttrs.packageName, focusedApp.packageName) == false) goto L12;
    L9:
        relatedWindows.add(w);
        return;
    L12:
        return;
    L4:
        if (Objects.equals(w.mAttrs.packageName, currentFocus.mAttrs.packageName) == true) goto L9;
        goto L6
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        PriorityDump.dump(this.mPriorityDumper, fd, pw, args);
    }

    @NeverCompile
    private void doDump(FileDescriptor fd, final PrintWriter pw, String[] args, boolean useProto) {
        boolean dumpAll = false;
        int opti = 0;
    L4:
        if (opti >= args.length) goto L21;
        String opt = args[opti];
        if (opt == null) goto L21;
        if (opt.length() <= 0) goto L21;
        if (opt.charAt(0) != '-') goto L21;
        opti = opti + 1;
        if ("-a".equals(opt) == true) goto L14;
        if ("-h".equals(opt) == true) goto L17;
        pw.println("Unknown argument: " + opt + "; use -h for help");
        goto L4
    L17:
        pw.println("Window manager dump options:");
        pw.println("  [-a] [-h] [cmd] ...");
        pw.println("  cmd may be one of:");
        pw.println("    l[astanr]: last ANR information");
        pw.println("    p[policy]: policy state");
        pw.println("    a[animator]: animator state");
        pw.println("    s[essions]: active sessions");
        pw.println("    surfaces: active surfaces (debugging enabled only)");
        pw.println("    d[isplays]: active display contents");
        pw.println("    t[okens]: token list");
        pw.println("    w[indows]: window list");
        pw.println("    a11y[accessibility]: accessibility-related state");
        pw.println("    package-config: installed packages having app-specific config");
        pw.println("    trace: print trace status and write Winscope trace to file");
        pw.println("  cmd may also be a NAME to dump windows.  NAME may");
        pw.println("    be a partial substring in a window name, a");
        pw.println("    Window hex object identifier, or");
        pw.println("    \"all\" for all windows, or");
        pw.println("    \"visible\" for the visible windows.");
        pw.println("    \"visible-apps\" for the visible app windows.");
        pw.println("  -a: include all available server state.");
        pw.println("  --proto: output dump in protocol buffer format.");
        return;
    L14:
        dumpAll = true;
    L21:
        if (useProto == false) goto L33;
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        WindowManagerGlobalLock r4 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r4);
        dumpDebugLocked(proto, 0);     // Catch: Throwable -> L28
        monitor-exit(r4);     // Catch: Throwable -> L28
        resetPriorityAfterLockedSection();
        proto.flush();
        return;
    L28:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L33:
        if (opti >= args.length) goto L202;
        String cmd = args[opti];
        int r5 = opti + 1;
        if (ActivityTaskManagerService.DUMP_LASTANR_CMD.equals(cmd) == false) goto L37;
    L192:
        WindowManagerGlobalLock r6 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r6);
        dumpLastANRLocked(pw);     // Catch: Throwable -> L198
        monitor-exit(r6);     // Catch: Throwable -> L198
        resetPriorityAfterLockedSection();
        return;
    L198:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L37:
        if ("l".equals(cmd) == true) goto L192;
        if ("policy".equals(cmd) == false) goto L42;
    L182:
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        dumpPolicyLocked(pw, args);     // Catch: Throwable -> L188
        monitor-exit(r1);     // Catch: Throwable -> L188
        resetPriorityAfterLockedSection();
        return;
    L188:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L42:
        if ("p".equals(cmd) == true) goto L182;
        if ("animator".equals(cmd) == false) goto L47;
    L172:
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r2);
        dumpAnimatorLocked(pw, true);     // Catch: Throwable -> L178
        monitor-exit(r2);     // Catch: Throwable -> L178
        resetPriorityAfterLockedSection();
        return;
    L178:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L47:
        if (ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD.equals(cmd) == true) goto L172;
        if ("sessions".equals(cmd) == false) goto L52;
    L162:
        WindowManagerGlobalLock r3 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r3);
        dumpSessionsLocked(pw);     // Catch: Throwable -> L168
        monitor-exit(r3);     // Catch: Throwable -> L168
        resetPriorityAfterLockedSection();
        return;
    L168:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L52:
        if ("s".equals(cmd) == true) goto L162;
        if ("displays".equals(cmd) == false) goto L57;
    L152:
        WindowManagerGlobalLock r7 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r7);
        this.mRoot.dumpDisplayContents(pw);     // Catch: Throwable -> L158
        monitor-exit(r7);     // Catch: Throwable -> L158
        resetPriorityAfterLockedSection();
        return;
    L158:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L57:
        if ("d".equals(cmd) == true) goto L152;
        if ("tokens".equals(cmd) == false) goto L62;
    L142:
        WindowManagerGlobalLock r8 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r8);
        dumpTokensLocked(pw, true);     // Catch: Throwable -> L148
        monitor-exit(r8);     // Catch: Throwable -> L148
        resetPriorityAfterLockedSection();
        return;
    L148:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L62:
        if ("t".equals(cmd) == true) goto L142;
        if ("windows".equals(cmd) == false) goto L67;
    L132:
        WindowManagerGlobalLock r9 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r9);
        dumpWindowsLocked(pw, true, null);     // Catch: Throwable -> L138
        monitor-exit(r9);     // Catch: Throwable -> L138
        resetPriorityAfterLockedSection();
        return;
    L138:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L67:
        if ("w".equals(cmd) == true) goto L132;
        if ("accessibility".equals(cmd) == false) goto L72;
    L122:
        WindowManagerGlobalLock r10 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r10);
        dumpAccessibilityLocked(pw);     // Catch: Throwable -> L128
        monitor-exit(r10);     // Catch: Throwable -> L128
        resetPriorityAfterLockedSection();
        return;
    L128:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L72:
        if ("a11y".equals(cmd) == true) goto L122;
        if (IZswContentProviderHelper.DUMP_ALL.equals(cmd) == false) goto L87;
        WindowManagerGlobalLock r11 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r11);
        dumpWindowsLocked(pw, true, null);     // Catch: Throwable -> L82
        monitor-exit(r11);     // Catch: Throwable -> L82
        resetPriorityAfterLockedSection();
        return;
    L82:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L87:
        if (ActivityTaskManagerService.DUMP_CONTAINERS_CMD.equals(cmd) == false) goto L99;
        WindowManagerGlobalLock r12 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r12);
        this.mRoot.dumpChildrenNames(pw, "");     // Catch: Throwable -> L94
        pw.println(" ");     // Catch: Throwable -> L94
        this.mRoot.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda35(pw), true);     // Catch: Throwable -> L94
        monitor-exit(r12);     // Catch: Throwable -> L94
        resetPriorityAfterLockedSection();
        return;
    L94:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L99:
        if ("trace".equals(cmd) == false) goto L103;
        dumpTraceStatus(pw);
        return;
    L103:
        if ("logging".equals(cmd) == false) goto L107;
        dumpLogStatus(pw);
        return;
    L107:
        if ("refresh".equals(cmd) == false) goto L111;
        dumpHighRefreshRateBlacklist(pw);
        return;
    L111:
        if ("constants".equals(cmd) == false) goto L115;
        this.mConstants.dump(pw);
        return;
    L115:
        if ("package-config".equals(cmd) == false) goto L119;
        this.mAtmService.dumpInstalledPackagesConfig(pw);
        return;
    L119:
        if (dumpWindows(pw, cmd, dumpAll) == true) goto L288;
        pw.println("Bad window command, or no windows match: " + cmd);
        pw.println("Use -h for help.");
        return;
    L288:
        return;
    L202:
        WindowManagerGlobalLock r13 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r13);
        pw.println();     // Catch: Throwable -> L207
        if (dumpAll == false) goto L209;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L209:
        dumpLastANRLocked(pw);     // Catch: Throwable -> L207
        pw.println();     // Catch: Throwable -> L207
        if (dumpAll == false) goto L212;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L212:
        dumpPolicyLocked(pw, args);     // Catch: Throwable -> L207
        pw.println();     // Catch: Throwable -> L207
        if (dumpAll == false) goto L215;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L215:
        dumpAnimatorLocked(pw, dumpAll);     // Catch: Throwable -> L207
        pw.println();     // Catch: Throwable -> L207
        if (dumpAll == false) goto L218;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L218:
        dumpSessionsLocked(pw);     // Catch: Throwable -> L207
        pw.println();     // Catch: Throwable -> L207
        if (dumpAll == false) goto L221;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L221:
        if (dumpAll == false) goto L223;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L223:
        this.mRoot.dumpDisplayContents(pw);     // Catch: Throwable -> L207
        pw.println();     // Catch: Throwable -> L207
        if (dumpAll == false) goto L226;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L226:
        dumpTokensLocked(pw, dumpAll);     // Catch: Throwable -> L207
        pw.println();     // Catch: Throwable -> L207
        if (dumpAll == false) goto L229;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L229:
        dumpWindowsLocked(pw, dumpAll, null);     // Catch: Throwable -> L207
        if (dumpAll == false) goto L232;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L232:
        dumpTraceStatus(pw);     // Catch: Throwable -> L207
        if (dumpAll == false) goto L235;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L235:
        dumpLogStatus(pw);     // Catch: Throwable -> L207
        if (dumpAll == false) goto L238;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L238:
        dumpHighRefreshRateBlacklist(pw);     // Catch: Throwable -> L207
        if (dumpAll == false) goto L241;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L241:
        this.mAtmService.dumpInstalledPackagesConfig(pw);     // Catch: Throwable -> L207
        if (dumpAll == false) goto L244;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L244:
        this.mConstants.dump(pw);     // Catch: Throwable -> L207
        if (dumpAll == false) goto L247;
        pw.println("-------------------------------------------------------------------------------");     // Catch: Throwable -> L207
    L247:
        this.mSystemPerformanceHinter.dump(pw, "");     // Catch: Throwable -> L207
        this.mTrustedPresentationListenerController.dump(pw);     // Catch: Throwable -> L207
        this.mSensitiveContentPackages.dump(pw);     // Catch: Throwable -> L207
        this.mScreenRecordingCallbackController.dump(pw);     // Catch: Throwable -> L207
        monitor-exit(r13);     // Catch: Throwable -> L207
        resetPriorityAfterLockedSection();
        return;
    L207:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$doDump$19(PrintWriter pw, WindowState w) {
        pw.println(w);
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return;
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    DisplayContent getDefaultDisplayContentLocked() {
        return this.mRoot.getDisplayContent(0);
    }

    DisplayContent getUserMainDisplayContentLocked(int userId) {
        int userMainDisplayId = this.mUmInternal.getMainDisplayAssignedToUser(userId);
        if (userMainDisplayId != (-1)) goto L7;
        return null;
    L7:
        return this.mRoot.getDisplayContent(userMainDisplayId);
    }

    public void onOverlayChanged() {
        this.mH.post(new WindowManagerService$$ExternalSyntheticLambda24(this));
    }

    private /* synthetic */ void lambda$onOverlayChanged$21() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAtmService.deferWindowLayout();     // Catch: Throwable -> L8
        this.mRoot.forAllDisplays(new WindowManagerService$$ExternalSyntheticLambda40());     // Catch: Throwable -> L8
        this.mAtmService.continueWindowLayout();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$onOverlayChanged$20(DisplayContent dc) {
        dc.getDisplayPolicy().onOverlayChanged();
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public Object getWindowManagerLock() {
        return this.mGlobalLock;
    }

    public int getDockedStackSide() {
        return 0;
    }

    void setForceDesktopModeOnExternalDisplays(boolean forceDesktopModeOnExternalDisplays) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mForceDesktopModeOnExternalDisplays = forceDesktopModeOnExternalDisplays;     // Catch: Throwable -> L8
        this.mRoot.updateDisplayImePolicyCache();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void setIsPc(boolean isPc) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mIsPc = isPc;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    static int dipToPixel(int dip, DisplayMetrics displayMetrics) {
        return (int) TypedValue.applyDimension(1, dip, displayMetrics);
    }

    public void registerPinnedTaskListener(int displayId, IPinnedTaskListener listener) {
        if (checkCallingPermission("android.permission.REGISTER_WINDOW_MANAGER_LISTENERS", "registerPinnedTaskListener()") == true) goto L6;
        return;
    L6:
        if (this.mAtmService.mSupportsPictureInPicture == true) goto L8;
        return;
    L8:
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L14
        displayContent.getPinnedTaskController().registerPinnedTaskListener(listener);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        resetPriorityAfterLockedSection();
        return;
    L14:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public KeyboardShortcutGroup getApplicationLaunchKeyboardShortcuts(int deviceId) {
        long token = Binder.clearCallingIdentity();
        KeyboardShortcutGroup r2 = this.mPolicy.getApplicationLaunchKeyboardShortcuts(deviceId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void requestAppKeyboardShortcuts(IResultReceiver receiver, int deviceId) {
        enforceRegisterWindowManagerListenersPermission("requestAppKeyboardShortcuts");
        WindowState focusedWindow = getFocusedWindow();
        if (focusedWindow != null) goto L5;
    L12:
        notifyReceiverWithEmptyBundle(receiver);
        return;
    L5:
        if (focusedWindow.mClient == null) goto L12;
        focusedWindow.mClient.requestAppKeyboardShortcuts(receiver, deviceId);     // Catch: RemoteException -> L9
        return;
    L10:
        notifyReceiverWithEmptyBundle(receiver);
    }

    public void requestImeKeyboardShortcuts(IResultReceiver receiver, int deviceId) {
        enforceRegisterWindowManagerListenersPermission("requestImeKeyboardShortcuts");
        WindowState imeWindow = this.mRoot.getCurrentInputMethodWindow();
        if (imeWindow != null) goto L5;
    L12:
        notifyReceiverWithEmptyBundle(receiver);
        return;
    L5:
        if (imeWindow.mClient == null) goto L12;
        imeWindow.mClient.requestAppKeyboardShortcuts(receiver, deviceId);     // Catch: RemoteException -> L9
        return;
    L10:
        notifyReceiverWithEmptyBundle(receiver);
    }

    private void enforceRegisterWindowManagerListenersPermission(String message) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.REGISTER_WINDOW_MANAGER_LISTENERS", message);
    }

    private static void notifyReceiverWithEmptyBundle(IResultReceiver receiver) {
        receiver.send(0, Bundle.EMPTY);     // Catch: RemoteException -> L5
        return;
    L7:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L12;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, 1010635158502326025L, 0, null);
        return;
    }

    public void getStableInsets(int displayId, Rect outInsets) throws RemoteException {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        getStableInsetsLocked(displayId, outInsets);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void getStableInsetsLocked(int displayId, Rect outInsets) {
        outInsets.setEmpty();
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);
        if (dc == null) goto L6;
        DisplayInfo di = dc.getDisplayInfo();
        outInsets.set(dc.getDisplayPolicy().getDecorInsetsInfo(di.rotation, di.logicalWidth, di.logicalHeight).mConfigInsets);
        return;
    }

    void updateTapExcludeRegion(IWindow client, Region region) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState callingWin = windowForClientLocked(null, client, false);     // Catch: Throwable -> L10
        if (callingWin == null) goto L8;
        callingWin.updateTapExcludeRegion(region);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L12;
        String protoLogParam0 = String.valueOf(client);     // Catch: Throwable -> L10
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 1278715281433572858L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void requestScrollCapture(int displayId, IBinder behindClient, int taskId, IScrollCaptureResponseListener listener) {
        if (checkCallingPermission("android.permission.READ_FRAME_BUFFER", "requestScrollCapture()") == false) goto L72;
        long token = Binder.clearCallingIdentity();
        ScrollCaptureResponse.Builder responseBuilder = new ScrollCaptureResponse.Builder();     // Catch: Throwable -> L59 RemoteException -> L61
        WindowManagerGlobalLock r10 = this.mGlobalLock;     // Catch: Throwable -> L59 RemoteException -> L61
        boostPriorityForLockedSection();     // Catch: Throwable -> L59 RemoteException -> L61
        monitor-enter(r10);     // Catch: Throwable -> L59 RemoteException -> L61
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L54
        if (dc != null) goto L25;
    L17:
        th = th;
    L56:
        monitor-exit(r10);     // Catch: Throwable -> L37
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L50 RemoteException -> L52
        throw th;     // Catch: Throwable -> L50 RemoteException -> L52
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L20;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, -6186782212018913664L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L15
    L20:
        responseBuilder.setDescription(String.format("bad displayId: %d", new Object[]{Integer.valueOf(displayId)}));     // Catch: Throwable -> L15
        listener.onScrollCaptureResponse(responseBuilder.build());     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(token);
        return;
    L25:
        if (behindClient != null) goto L27;
        WindowState topWindow = null;
    L31:
        WindowState targetWindow = dc.findScrollCaptureTargetWindow(topWindow, taskId);     // Catch: Throwable -> L37
        if (targetWindow != null) goto L76;
        responseBuilder.setDescription("findScrollCaptureTargetWindow returned null");     // Catch: Throwable -> L37
        listener.onScrollCaptureResponse(responseBuilder.build());     // Catch: Throwable -> L37
        monitor-exit(r10);     // Catch: Throwable -> L37
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(token);
        return;
    L76:
        targetWindow.mClient.requestScrollCapture(listener);     // Catch: Throwable -> L37 RemoteException -> L41
    L47:
        monitor-exit(r10);     // Catch: Throwable -> L37
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L50 RemoteException -> L52
    L49:
        Binder.restoreCallingIdentity(token);
        return;
    L41:
        e = move-exception;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L46;
        String protoLogParam1 = String.valueOf(targetWindow.mClient.asBinder());     // Catch: Throwable -> L37
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 51378282333944649L, 0, new Object[]{protoLogParam1});     // Catch: Throwable -> L37
    L46:
        responseBuilder.setWindowTitle(targetWindow.getName());     // Catch: Throwable -> L37
        responseBuilder.setPackageName(targetWindow.getOwningPackage());     // Catch: Throwable -> L37
        responseBuilder.setDescription(String.format("caught exception: %s", new Object[]{e}));     // Catch: Throwable -> L37
        listener.onScrollCaptureResponse(responseBuilder.build());     // Catch: Throwable -> L37
        goto L47
    L27:
        topWindow = windowForClientLocked(null, behindClient, false);     // Catch: Throwable -> L15
    L15:
        th = th;
    L54:
        th = th;
        goto L56
    L37:
        th = th;
    L52:
        e = e;
    L65:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L49;
        String protoLogParam2 = String.valueOf(e);     // Catch: Throwable -> L50
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -8972916676375201577L, 0, new Object[]{protoLogParam2});     // Catch: Throwable -> L50
    L50:
        th = th;
    L69:
        Binder.restoreCallingIdentity(token);
        throw th;
    L61:
        e = e;
    L59:
        th = th;
        goto L69
    L72:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    public int getWindowingMode(int displayId) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "getWindowingMode()") == false) goto L24;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L11
        if (displayContent == null) goto L9;
        int r2 = this.mDisplayWindowSettings.getWindowingModeLocked(displayContent);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L13;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -1875125162673622728L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return 0;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L24:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void setWindowingMode(int displayId, int mode) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "setWindowingMode()") == false) goto L33;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L25
        boostPriorityForLockedSection();     // Catch: Throwable -> L25
        monitor-enter(r2);     // Catch: Throwable -> L25
        DisplayContent displayContent = getDisplayContentOrCreate(displayId, null);     // Catch: Throwable -> L13
        if (displayContent == null) goto L11;
        int lastWindowingMode = displayContent.getWindowingMode();     // Catch: Throwable -> L13
        this.mDisplayWindowSettings.setWindowingModeLocked(displayContent, mode);     // Catch: Throwable -> L13
        displayContent.reconfigureDisplayLocked();     // Catch: Throwable -> L13
        if (lastWindowingMode == displayContent.getWindowingMode()) goto L21;
        displayContent.sendNewConfiguration();     // Catch: Throwable -> L13
        displayContent.executeAppTransition();     // Catch: Throwable -> L13
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(origId);
        return;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 3938331948687900219L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L13
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L33:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public int getRemoveContentMode(int displayId) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "getRemoveContentMode()") == false) goto L24;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L11
        if (displayContent == null) goto L9;
        int r2 = displayContent.getRemoveContentMode();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L13;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 4200292050699107329L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return 0;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L24:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void setRemoveContentMode(int displayId, int mode) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "setRemoveContentMode()") == false) goto L31;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L23
        boostPriorityForLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        DisplayContent displayContent = getDisplayContentOrCreate(displayId, null);     // Catch: Throwable -> L13
        if (displayContent == null) goto L11;
        this.mDisplayWindowSettings.setRemoveContentModeLocked(displayContent, mode);     // Catch: Throwable -> L13
        displayContent.reconfigureDisplayLocked();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(origId);
        return;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -5574580669790275797L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L13
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L31:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public boolean shouldShowWithInsecureKeyguard(int displayId) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "shouldShowWithInsecureKeyguard()") == false) goto L24;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L11
        if (displayContent == null) goto L9;
        boolean r2 = this.mDisplayWindowSettings.shouldShowWithInsecureKeyguardLocked(displayContent);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L13;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 525945815055875796L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return false;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L24:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void setShouldShowWithInsecureKeyguard(int displayId, boolean shouldShow) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "setShouldShowWithInsecureKeyguard()") == false) goto L31;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L23
        boostPriorityForLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        DisplayContent displayContent = getDisplayContentOrCreate(displayId, null);     // Catch: Throwable -> L13
        if (displayContent == null) goto L11;
        this.mDisplayWindowSettings.setShouldShowWithInsecureKeyguardLocked(displayContent, shouldShow);     // Catch: Throwable -> L13
        displayContent.reconfigureDisplayLocked();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(origId);
        return;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 8186524992939307511L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L13
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L31:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public boolean shouldShowSystemDecors(int displayId) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "shouldShowSystemDecors()") == false) goto L24;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L11
        if (displayContent == null) goto L9;
        boolean r2 = displayContent.isSystemDecorationsSupported();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L13;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, -600035824255550632L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return false;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L24:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public boolean isEligibleForDesktopMode(int displayId) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "isEligibleForDesktopMode()") == false) goto L34;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L11
        boolean r2 = true;
        if (displayContent != null) goto L17;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L13;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, -3939869449745711670L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return false;
    L17:
        if (displayContent.isSystemDecorationsSupported() == true) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return false;
    L22:
        if (displayContent.isDefaultDisplay == true) goto L27;
        if (displayContent.allowContentModeSwitch() == true) goto L27;
        r2 = false;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r2;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L34:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void setShouldShowSystemDecors(int displayId, boolean shouldShow) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "setShouldShowSystemDecors()") == false) goto L35;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L25
        boostPriorityForLockedSection();     // Catch: Throwable -> L25
        monitor-enter(r2);     // Catch: Throwable -> L25
        DisplayContent displayContent = getDisplayContentOrCreate(displayId, null);     // Catch: Throwable -> L13
        if (displayContent != null) goto L19;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 3056518663346732662L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L13
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L19:
        if (displayContent.isTrusted() == false) goto L28;
        this.mDisplayWindowSettings.setShouldShowSystemDecorsLocked(displayContent, shouldShow);     // Catch: Throwable -> L13
        displayContent.reconfigureDisplayLocked();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(origId);
        return;
    L28:
        throw new SecurityException("Attempted to set system decors flag to an untrusted virtual display: " + displayId);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L35:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public int getDisplayImePolicy(int displayId) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "getDisplayImePolicy()") == false) goto L13;
        Map<Integer, Integer> displayImePolicyCache = this.mDisplayImePolicyCache;
        if (displayImePolicyCache.containsKey(Integer.valueOf(displayId)) == true) goto L11;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L9;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 5177195624625618567L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L9:
        return 1;
    L11:
        return displayImePolicyCache.get(Integer.valueOf(displayId)).intValue();
    L13:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void setDisplayImePolicy(int displayId, int imePolicy) {
        if (checkCallingPermission("android.permission.INTERNAL_SYSTEM_WINDOW", "setDisplayImePolicy()") == false) goto L35;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L25
        boostPriorityForLockedSection();     // Catch: Throwable -> L25
        monitor-enter(r2);     // Catch: Throwable -> L25
        DisplayContent displayContent = getDisplayContentOrCreate(displayId, null);     // Catch: Throwable -> L13
        if (displayContent != null) goto L19;
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[3] == false) goto L15;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_ERROR, 3932627933834459400L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L13
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L19:
        if (displayContent.isTrusted() == false) goto L28;
        this.mDisplayWindowSettings.setDisplayImePolicy(displayContent, imePolicy);     // Catch: Throwable -> L13
        displayContent.reconfigureDisplayLocked();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(origId);
        return;
    L28:
        throw new SecurityException("Attempted to set IME policy to an untrusted virtual display: " + displayId);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L35:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void onNotificationShadeExpanded(IBinder token, boolean expanded) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState w = this.mWindowMap.get(token);     // Catch: Throwable -> L18
        if (w == null) goto L30;
        if (w != w.mDisplayContent.getDisplayPolicy().getNotificationShade()) goto L30;
        WindowProcessController topApp = this.mAtmService.mTopApp;     // Catch: Throwable -> L18
        int demoteTopAppReasons = this.mAtmService.mDemoteTopAppReasons;     // Catch: Throwable -> L18
        if (expanded == true) goto L12;
    L20:
        if (expanded == false) goto L22;
    L26:
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().notifyStatusBarDropStateChanged(expanded);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        resetPriorityAfterLockedSection();
        return;
    L22:
        if ((demoteTopAppReasons & 2) == 0) goto L26;
        int r7 = demoteTopAppReasons & (-3);     // Catch: Throwable -> L18
        this.mAtmService.mDemoteTopAppReasons = r7;     // Catch: Throwable -> L18
        Trace.instant(32, "cancel-demote-top-for-ns");     // Catch: Throwable -> L18
        if (topApp == null) goto L26;
        topApp.scheduleUpdateOomAdj();     // Catch: Throwable -> L18
        goto L26
    L12:
        if (this.mAtmService.mTopProcessState != 2) goto L20;
        if ((demoteTopAppReasons & 2) != 0) goto L20;
        int r8 = demoteTopAppReasons | 2;     // Catch: Throwable -> L18
        this.mAtmService.mDemoteTopAppReasons = r8;     // Catch: Throwable -> L18
        Trace.instant(32, "demote-top-for-ns");     // Catch: Throwable -> L18
        if (topApp == null) goto L26;
        topApp.scheduleUpdateOomAdj();     // Catch: Throwable -> L18
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L18
        resetPriorityAfterLockedSection();
        return;
    L18:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void registerShortcutKey(long shortcutCode, IShortcutService shortcutKeyReceiver) throws RemoteException {
        if (checkCallingPermission("android.permission.REGISTER_WINDOW_MANAGER_LISTENERS", "registerShortcutKey") == false) goto L7;
        this.mPolicy.registerShortcutKey(shortcutCode, shortcutKeyReceiver);
        return;
    L7:
        throw new SecurityException("Requires REGISTER_WINDOW_MANAGER_LISTENERS permission");
    }

    public void disableNonVrUi(boolean disable) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        if (disable == true) goto L7;
        boolean showAlertWindowNotifications = true;
    L25:
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L9:
        if (showAlertWindowNotifications != this.mShowAlertWindowNotifications) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        return;
    L15:
        this.mShowAlertWindowNotifications = showAlertWindowNotifications;     // Catch: Throwable -> L13
        int i = this.mSessions.size() - 1;     // Catch: Throwable -> L13
    L16:
        if (i < 0) goto L19;
        Session s = this.mSessions.valueAt(i);     // Catch: Throwable -> L13
        s.setShowingAlertWindowNotificationAllowed(this.mShowAlertWindowNotifications);     // Catch: Throwable -> L13
        i = i - 1;     // Catch: Throwable -> L13
        goto L16
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        return;
    L7:
        showAlertWindowNotifications = false;
        goto L25
    }

    boolean hasWideColorGamutSupport() {
        if (this.mHasWideColorGamutSupport == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getInt("persist.sys.sf.native_mode", 0) != 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean hasHdrSupport() {
        if (this.mHasHdrSupport == true) goto L5;
    L7:
        return false;
    L5:
        if (hasWideColorGamutSupport() == false) goto L7;
        return true;
    }

    void updateNonSystemOverlayWindowsVisibilityIfNeeded(WindowState win, boolean surfaceShown) {
        boolean changed = true;
        if (surfaceShown == true) goto L5;
    L7:
        boolean effective = false;
    L9:
        if (effective != this.mHidingNonSystemOverlayWindows.contains(win)) goto L11;
        return;
    L11:
        if (effective == false) goto L13;
        this.mHidingNonSystemOverlayWindows.add(win);
    L14:
        int uid = win.getOwningUid();
        int numUIDsPreUpdate = this.mHidingNonSystemOverlayWindowsCountPerUid.size();
        int r5 = this.mHidingNonSystemOverlayWindowsCountPerUid.getOrDefault(Integer.valueOf(uid), 0).intValue();
        if (effective == false) goto L17;
        int r6 = 1;
    L18:
        int newCount = r5 + r6;
        if (newCount > 0) goto L21;
        this.mHidingNonSystemOverlayWindowsCountPerUid.remove(Integer.valueOf(uid));
    L22:
        int numUIDsPostUpdate = this.mHidingNonSystemOverlayWindowsCountPerUid.size();
        if (numUIDsPostUpdate == numUIDsPreUpdate) goto L27;
        if (numUIDsPostUpdate <= 1) goto L29;
        if (numUIDsPreUpdate > 1) goto L27;
    L29:
        if (changed == false) goto L32;
        this.mRoot.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda41(this), false);
        return;
    L32:
        return;
    L27:
        changed = false;
        goto L29
    L21:
        this.mHidingNonSystemOverlayWindowsCountPerUid.put(Integer.valueOf(uid), Integer.valueOf(newCount));
        goto L22
    L17:
        r6 = -1;
        goto L18
    L13:
        this.mHidingNonSystemOverlayWindows.remove(win);
        goto L14
    L5:
        if (win.hideNonSystemOverlayWindowsWhenVisible() == false) goto L7;
        effective = true;
        goto L9
    }

    private /* synthetic */ void lambda$updateNonSystemOverlayWindowsVisibilityIfNeeded$22(WindowState w) {
        w.setForceHideNonSystemOverlayWindowIfNeeded(shouldHideNonSystemOverlayWindow(w));
    }

    public void applyMagnificationSpecLocked(int displayId, MagnificationSpec spec) {
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);
        if (displayContent == null) goto L6;
        displayContent.applyMagnificationSpec(spec);
        return;
    }

    SurfaceControl.Builder makeSurfaceBuilder() {
        return this.mSurfaceControlFactory.get();
    }

    public void syncInputTransactions(boolean waitForAnimations) {
        long token = Binder.clearCallingIdentity();
        if (waitForAnimations == true) goto L25;
    L9:
        final SurfaceControl.Transaction t = this.mTransactionFactory.get();     // Catch: Throwable -> L5 InterruptedException -> L7
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L5 InterruptedException -> L7
        boostPriorityForLockedSection();     // Catch: Throwable -> L5 InterruptedException -> L7
        monitor-enter(r3);     // Catch: Throwable -> L5 InterruptedException -> L7
        this.mWindowPlacerLocked.performSurfacePlacementIfScheduled();     // Catch: Throwable -> L15
        this.mRoot.forAllDisplays(new WindowManagerService$$ExternalSyntheticLambda26(t));     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L5 InterruptedException -> L7
        CountDownLatch countDownLatch = new CountDownLatch(1);     // Catch: Throwable -> L5 InterruptedException -> L7
        t.addWindowInfosReportedListener(new SettingsStore$$ExternalSyntheticLambda0(countDownLatch)).apply();     // Catch: Throwable -> L5 InterruptedException -> L7
        countDownLatch.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L5 InterruptedException -> L7
    L14:
        Binder.restoreCallingIdentity(token);
        return;
    L15:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L5 InterruptedException -> L7
        throw th;     // Catch: Throwable -> L5 InterruptedException -> L7
    L25:
        waitForAnimationsToComplete();     // Catch: Throwable -> L5 InterruptedException -> L7
    L7:
        exception = move-exception;
        Slog.e(TAG, "Exception thrown while waiting for window infos to be reported", exception);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private static /* synthetic */ void lambda$syncInputTransactions$23(SurfaceControl.Transaction t, DisplayContent displayContent) {
        displayContent.getInputMonitor().updateInputWindowsImmediately(t);
    }

    private void waitForAnimationsToComplete() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        long timeoutRemaining = 5000;
        this.mAnimator.mNotifyWhenNoAnimation = true;     // Catch: Throwable -> L13
        boolean animateStarting = false;
    L6:
        int r8 = 0;
        if (timeoutRemaining <= 0) goto L34;
        if (this.mAtmService.getTransitionController().isShellTransitionsEnabled() == false) goto L11;
    L15:
        boolean r5 = false;
    L16:
        animateStarting = r5;
        if (this.mAnimator.isAnimationScheduled() == false) goto L19;
    L23:
        boolean isAnimating = true;
    L25:
        if (isAnimating == false) goto L27;
    L29:
        long startTime = System.currentTimeMillis();     // Catch: Throwable -> L13
        this.mGlobalLock.wait(timeoutRemaining);     // Catch: Throwable -> L13 InterruptedException -> L32
    L33:
        timeoutRemaining = timeoutRemaining - (System.currentTimeMillis() - startTime);     // Catch: Throwable -> L13
        goto L6
    L27:
        if (this.mAtmService.getTransitionController().inTransition() == true) goto L29;
    L19:
        if (this.mRoot.isAnimating(5, -1) == true) goto L23;
        if (animateStarting == true) goto L23;
        isAnimating = false;
        goto L25
    L11:
        if (this.mRoot.forAllActivities(new WindowManagerService$$ExternalSyntheticLambda4()) == false) goto L15;
        r5 = true;
    L34:
        this.mAnimator.mNotifyWhenNoAnimation = false;     // Catch: Throwable -> L13
        WindowContainer animatingContainer = this.mRoot.getAnimatingContainer(5, -1);     // Catch: Throwable -> L13
        if (this.mAnimator.isAnimationScheduled() == true) goto L38;
        if (animatingContainer != null) goto L38;
        if (animateStarting == true) goto L38;
    L43:
        monitor-exit(r0);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        return;
    L38:
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L13
        r6.append("Timed out waiting for animations to complete, animatingContainer=");     // Catch: Throwable -> L13
        r6.append(animatingContainer);     // Catch: Throwable -> L13
        r6.append(" animationType=");     // Catch: Throwable -> L13
        if (animatingContainer == null) goto L42;
        r8 = animatingContainer.mSurfaceAnimator.getAnimationType();     // Catch: Throwable -> L13
    L42:
        r6.append(SurfaceAnimator.animationTypeToString(r8));     // Catch: Throwable -> L13
        r6.append(" animateStarting=");     // Catch: Throwable -> L13
        r6.append(animateStarting);     // Catch: Throwable -> L13
        Slog.w(TAG, r6.toString());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void onAnimationFinished() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mGlobalLock.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void clearPointerDownOutsideFocusRunnable() {
        if (this.mPointerDownOutsideFocusRunnable != null) goto L5;
        return;
    L5:
        this.mH.removeCallbacks(this.mPointerDownOutsideFocusRunnable);
        this.mPointerDownOutsideFocusRunnable = null;
    }

    private void onPointerDownOutsideFocusLocked(final InputTarget t, boolean fromHandler) {
        if (t != null) goto L4;
        return;
    L4:
        if (t.receiveFocusFromTapOutside() == false) goto L38;
        ActivityRecord touchedApp = t.getActivityRecord();
        if (touchedApp == null) goto L21;
        if (touchedApp.getTask() == null) goto L21;
        ActivityRecord top = touchedApp.getTask().topRunningActivity();
        if (top == null) goto L18;
        if (top == touchedApp) goto L18;
        if (top.getTaskFragment().getBounds().contains(touchedApp.getTaskFragment().getBounds()) == false) goto L18;
        Slog.w(TAG, "onPointerDownOutsideFocusLocked, drop event because " + touchedApp + " is occluded and should not be focused.");
        return;
    L18:
        if (getExt().dropEventIfNeeded(touchedApp) == false) goto L21;
        return;
    L21:
        if (this.mDeviceStateCallback.isInRearDisplayOuterDefaultState() == false) goto L28;
        Display[] rearDisplays = this.mDisplayManager.getDisplays("android.hardware.display.category.REAR");
        if (rearDisplays.length <= 0) goto L28;
        if (rearDisplays[0].getDisplayId() != t.getDisplayId()) goto L28;
        Slog.w(TAG, "Ignoring focus change because device is in RDM.");
        return;
    L28:
        clearPointerDownOutsideFocusRunnable();
        final InputTarget focusedInputTarget = this.mFocusedInputTarget;
        if (shouldDelayTouchOutside(t) == false) goto L31;
        this.mPointerDownOutsideFocusRunnable = new WindowManagerService$$ExternalSyntheticLambda30(this, t, focusedInputTarget);
        this.mH.postDelayed(this.mPointerDownOutsideFocusRunnable, 50);
        return;
    L31:
        if (fromHandler == true) goto L33;
        this.mPointerDownOutsideFocusRunnable = new WindowManagerService$$ExternalSyntheticLambda31(this, t, focusedInputTarget);
        this.mH.post(this.mPointerDownOutsideFocusRunnable);
        return;
    L33:
        handlePointerDownOutsideFocus(t, focusedInputTarget);
        return;
    }

    private /* synthetic */ void lambda$onPointerDownOutsideFocusLocked$24(InputTarget t, InputTarget focusedInputTarget) {
        handlePointerDownOutsideFocus(t, focusedInputTarget);
    }

    private /* synthetic */ void lambda$onPointerDownOutsideFocusLocked$25(InputTarget t, InputTarget focusedInputTarget) {
        handlePointerDownOutsideFocus(t, focusedInputTarget);
    }

    private boolean shouldDelayTouchOutside(InputTarget t) {
        ActivityRecord activity = t.getActivityRecord();
        if (activity == null) goto L5;
        Task task = activity.getTask();
    L7:
        if (this.mFocusedInputTarget != t) goto L9;
    L11:
        boolean isInputTargetNotFocused = false;
    L13:
        if (this.mFocusedInputTarget != null) goto L15;
    L17:
        boolean isTouchOnFocusedDisplay = false;
    L19:
        if (isInputTargetNotFocused == false) goto L41;
        if (isTouchOnFocusedDisplay == false) goto L41;
        if (activity != null) goto L24;
    L28:
        boolean shouldDelayTouchForEmbeddedActivity = false;
    L30:
        if (task != null) goto L32;
    L34:
        boolean shouldDelayTouchForFreeform = false;
    L36:
        if (shouldDelayTouchForEmbeddedActivity == true) goto L42;
        if (shouldDelayTouchForFreeform == false) goto L40;
        return true;
    L40:
        return false;
    L42:
        return true;
    L32:
        if (task.getWindowingMode() != 5) goto L34;
        shouldDelayTouchForFreeform = true;
        goto L36
    L24:
        if (activity.isEmbedded() == false) goto L28;
        if (activity.getTaskFragment().hasAdjacentTaskFragment() == false) goto L28;
        shouldDelayTouchForEmbeddedActivity = true;
    L41:
        return false;
    L15:
        if (t.getDisplayId() != this.mFocusedInputTarget.getDisplayId()) goto L17;
        isTouchOnFocusedDisplay = true;
        goto L19
    L9:
        if (this.mFocusedInputTarget == null) goto L11;
        isInputTargetNotFocused = true;
        goto L13
    L5:
        task = null;
        goto L7
    }

    private void handlePointerDownOutsideFocus(InputTarget t, InputTarget focusedInputTarget) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState w = t.getWindowState();     // Catch: Throwable -> L12
        if (this.mFocusedInputTarget != focusedInputTarget) goto L43;
        if (w == null) goto L15;
        if (w.getActivityRecord() == null) goto L15;
        if (w.getActivityRecord().isVisibleRequested() == false) goto L43;
    L15:
        if (this.mPointerDownOutsideFocusRunnable != null) goto L17;
    L21:
        clearPointerDownOutsideFocusRunnable();     // Catch: Throwable -> L12
        if (w == null) goto L31;
        Task task = w.getTask();     // Catch: Throwable -> L12
        if (task == null) goto L31;
        if (w.mTransitionController.isTransientHide(task) == false) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L31:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[2] == false) goto L34;
        String protoLogParam0 = String.valueOf(t);     // Catch: Throwable -> L12
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -2065144681579661392L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L12
    L34:
        if (this.mFocusedInputTarget != t) goto L36;
    L38:
        this.mAtmService.mTaskSupervisor.mUserLeaving = true;     // Catch: Throwable -> L12
        t.handleTapOutsideFocusInsideSelf();     // Catch: Throwable -> L12
        this.mAtmService.mTaskSupervisor.mUserLeaving = false;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L36:
        if (this.mFocusedInputTarget == null) goto L38;
        this.mFocusedInputTarget.handleTapOutsideFocusOutsideSelf();     // Catch: Throwable -> L12
        goto L38
    L17:
        if (this.mH.hasCallbacks(this.mPointerDownOutsideFocusRunnable) == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L43:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[2] == false) goto L45;
        String protoLogParam1 = String.valueOf(t);     // Catch: Throwable -> L12
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, 9034950957651148580L, 0, new Object[]{protoLogParam1});     // Catch: Throwable -> L12
    L45:
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void handleTaskFocusChange(Task task, ActivityRecord touchedActivity) {
        if (task != null) goto L5;
        return;
    L5:
        if (task.isActivityTypeHome() == false) goto L14;
        TaskDisplayArea homeTda = task.getDisplayArea();
        WindowState curFocusedWindow = getFocusedWindow();
        if (curFocusedWindow == null) goto L14;
        if (homeTda == null) goto L14;
        if (curFocusedWindow.inFreeformWindowingMode() == true) goto L14;
        if (curFocusedWindow.isDescendantOf(homeTda) == false) goto L14;
        return;
    L14:
        this.mAtmService.setFocusedTask(task.mTaskId, touchedActivity);
    }

    WindowContainerInfo getTaskWindowContainerInfoForRecordingSession(ContentRecordingSession session) {
        WindowContainerToken taskWindowContainerToken = null;
        Task targetTask = null;
        if (session.getTokenToRecord() == null) goto L11;
        final IBinder launchCookie = session.getTokenToRecord();
        ActivityRecord targetActivity = this.mRoot.getActivity(new WindowManagerService$$ExternalSyntheticLambda0(launchCookie));
        if (targetActivity != null) goto L8;
        Slog.w(TAG, "Unable to find the activity for this launch cookie");
        goto L11
    L8:
        if (targetActivity.getTask() != null) goto L10;
        Slog.w(TAG, "Unable to find the task for this launch cookie");
        goto L11
    L10:
        targetTask = targetActivity.getTask();
        taskWindowContainerToken = targetTask.mRemoteToken.toWindowContainerToken();
    L11:
        if (taskWindowContainerToken == null) goto L13;
    L18:
        WindowManagerServiceIA r3 = null;
        if (taskWindowContainerToken != null) goto L23;
        Slog.w(TAG, "Unable to find the WindowContainerToken for ContentRecordingSession");
        return null;
    L23:
        return new WindowContainerInfo(targetTask.effectiveUid, taskWindowContainerToken, r3);
    L13:
        if (session.getTaskId() == (-1)) goto L18;
        final int targetTaskId = session.getTaskId();
        targetTask = this.mRoot.getTask(new WindowManagerService$$ExternalSyntheticLambda1(targetTaskId));
        if (targetTask != null) goto L17;
        Slog.w(TAG, "Unable to find the task for this projection");
        goto L18
    L17:
        taskWindowContainerToken = targetTask.mRemoteToken.toWindowContainerToken();
        goto L18
    }

    private static /* synthetic */ boolean lambda$getTaskWindowContainerInfoForRecordingSession$26(IBinder launchCookie, ActivityRecord activity) {
        if (activity.mLaunchCookie != launchCookie) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$getTaskWindowContainerInfoForRecordingSession$27(int targetTaskId, Task task) {
        return task.isTaskId(targetTaskId);
    }

    private int sanitizeFlagSlippery(int flags, String windowName, int callingUid, int callingPid) {
        if ((536870912 & flags) != 0) goto L5;
        return flags;
    L5:
        int permissionResult = this.mContext.checkPermission("android.permission.ALLOW_SLIPPERY_TOUCHES", callingPid, callingUid);
        if (permissionResult == 0) goto L9;
        Slog.w(TAG, "Removing FLAG_SLIPPERY from '" + windowName + "' because it doesn't have ALLOW_SLIPPERY_TOUCHES permission");
        return (-536870913) & flags;
    L9:
        return flags;
    }

    private int sanitizeInputFeatures(int inputFeatures, String windowName, int callingUid, int callingPid, boolean isTrustedOverlay) {
        if ((inputFeatures & 4) == 0) goto L9;
        int permissionResult = this.mContext.checkPermission("android.permission.MONITOR_INPUT", callingPid, callingUid);
        if (permissionResult == 0) goto L9;
        throw new IllegalArgumentException("Cannot use INPUT_FEATURE_SPY from '" + windowName + "' because it doesn't the have MONITOR_INPUT permission");
    L9:
        int permissionResult2 = inputFeatures & 8;
        if (permissionResult2 == 0) goto L14;
        if (isTrustedOverlay == true) goto L14;
        Slog.w(TAG, "Removing INPUT_FEATURE_SENSITIVE_FOR_PRIVACY from '" + windowName + "' because it isn't a trusted overlay");
        return inputFeatures & (-9);
    L14:
        return inputFeatures;
    }

    private boolean hasFlags(int flags, int mask) {
        if ((flags & mask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasPermission(String permission, int callingPid, int callingUid) {
        if (this.mContext.checkPermission(permission, callingPid, callingUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int sanitizePrivateFlags(int newPrivateFlags, int oldPrivateFlags, String windowName, int callingUid, int callingPid) {
        int addedPrivateFlags = (~oldPrivateFlags) & newPrivateFlags;
        int sanitizedFlags = newPrivateFlags;
        if (hasFlags(addedPrivateFlags, 537919488) == false) goto L8;
        if (hasPermission("android.permission.INTERNAL_SYSTEM_WINDOW", callingUid, callingPid) == true) goto L8;
        Slog.w(TAG, "Removing PRIVATE_FLAG_IS_ROUNDED_CORNERS_OVERLAY or PRIVATE_FLAG_TRUSTED_OVERLAY from '" + windowName + "' because it doesn't have INTERNAL_SYSTEM_WINDOW permission");
        sanitizedFlags = sanitizedFlags & (-537919489);
    L8:
        if (hasFlags(addedPrivateFlags, Integer.MIN_VALUE) == true) goto L10;
        return sanitizedFlags;
    L10:
        if (hasPermission("android.permission.MANAGE_ACTIVITY_TASKS", callingUid, callingPid) == true) goto L14;
        Slog.w(TAG, "Removing PRIVATE_FLAG_INTERCEPT_GLOBAL_DRAG_AND_DROP from '" + windowName + "' because it doesn't have MANAGE_ACTIVITY_TASKS permission");
        return sanitizedFlags & Integer.MAX_VALUE;
    L14:
        return sanitizedFlags;
    }

    void grantInputChannel(Session session, int callingUid, int callingPid, int displayId, SurfaceControl surface, IBinder clientToken, InputTransferToken hostInputTransferToken, int flags, int privateFlags, int inputFeatures, int type, IBinder windowToken, InputTransferToken inputTransferToken, String inputHandleName, InputChannel outInputChannel) {
        int sanitizedType = sanitizeWindowType(session, displayId, windowToken, type);
        outInputChannel.getClass();
        inputTransferToken.getClass();
        WindowManagerGlobalLock r13 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r13);
        if (hostInputTransferToken != null) goto L31;
        WindowState r0 = null;
    L6:
        WindowState hostWindowState = r0;
        if ((flags & 8) != 0) goto L14;
        boolean r3 = true;
    L15:
        EmbeddedWindowController.EmbeddedWindow win = new EmbeddedWindowController.EmbeddedWindow(session, this, clientToken, hostWindowState, callingUid, callingPid, sanitizedType, displayId, inputTransferToken, inputHandleName, r3);     // Catch: Throwable -> L7
        win.openInputChannel(outInputChannel);     // Catch: Throwable -> L7
        this.mEmbeddedWindowController.add(outInputChannel.getToken(), win);     // Catch: Throwable -> L7
        InputApplicationHandle applicationHandle = win.getApplicationHandle();     // Catch: Throwable -> L7
        String name = win.toString();     // Catch: Throwable -> L7
        if (Features.FEAT_QUICK_WIN == true) goto L29;
        SurfaceControl r6 = surface;
        IBinder r14 = clientToken;
    L23:
        monitor-exit(r13);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        updateInputChannel(outInputChannel.getToken(), callingUid, callingPid, displayId, r6, name, applicationHandle, flags, privateFlags, inputFeatures, sanitizedType, null, r14);
        return;
    L29:
        r6 = surface;
        r14 = clientToken;
        getExt().grantInputChannel(r14, r6, name);     // Catch: Throwable -> L7
    L20:
        th = th;
    L26:
        monitor-exit(r13);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        throw th;
    L14:
        r3 = false;
        goto L15
    L31:
        r0 = this.mInputToWindowMap.get(hostInputTransferToken.getToken());     // Catch: Throwable -> L7
    L7:
        th = th;
        goto L26
    }

    public boolean transferTouchGesture(InputTransferToken transferFromToken, InputTransferToken transferToToken) {
        transferFromToken.getClass();
        transferToToken.getClass();
        int callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L15
        boostPriorityForLockedSection();     // Catch: Throwable -> L15
        monitor-enter(r3);     // Catch: Throwable -> L15
        WindowState windowStateTo = this.mInputToWindowMap.get(transferToToken.getToken());     // Catch: Throwable -> L8
        if (windowStateTo == null) goto L10;
        boolean didTransfer = this.mEmbeddedWindowController.transferToHost(callingUid, transferFromToken, windowStateTo);     // Catch: Throwable -> L8
    L11:
        monitor-exit(r3);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);
        return didTransfer;
    L10:
        WindowState windowStateFrom = this.mInputToWindowMap.get(transferFromToken.getToken());     // Catch: Throwable -> L8
        didTransfer = this.mEmbeddedWindowController.transferToEmbedded(callingUid, windowStateFrom, transferToToken);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void updateInputChannel(IBinder channelToken, int callingUid, int callingPid, int displayId, SurfaceControl surface, String name, InputApplicationHandle applicationHandle, int flags, int privateFlags, int inputFeatures, int type, Region region, IBinder clientToken) {
        InputWindowHandle h = new InputWindowHandle(applicationHandle, displayId);
        h.token = channelToken;
        h.setWindowToken(clientToken);
        h.name = name;
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r2);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent == null) goto L15;
        if ("PREFETCH_APP".equals(displayContent.getDisplay().getName()) == false) goto L15;
        Slog.i(TAG, "skip updateInputChannel. displayId " + displayId + " for prefetch");     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        if ((privateFlags & 536870912) == 0) goto L19;
        boolean isTrustedOverlay = true;
    L20:
        int flags2 = sanitizeFlagSlippery(flags, name, callingUid, callingPid);
        int inputFeatures2 = sanitizeInputFeatures(inputFeatures, name, callingUid, callingPid, isTrustedOverlay);
        int sanitizedLpFlags = (537133080 & flags2) | 32;
        h.layoutParamsType = type;
        h.layoutParamsFlags = sanitizedLpFlags;
        h.inputConfig = InputConfigAdapter.getInputConfigFromWindowParams(type, sanitizedLpFlags, inputFeatures2);
        if ((flags2 & 8) == 0) goto L23;
        h.inputConfig |= 4;
    L23:
        h.dispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
        h.ownerUid = callingUid;
        h.ownerPid = callingPid;
        if (region != null) goto L26;
        h.replaceTouchableRegionWithCrop(null);
    L29:
        SurfaceControl.Transaction t = this.mTransactionFactory.get();
        h.setTrustedOverlay(t, surface, isTrustedOverlay);
        t.setInputWindowInfo(surface, h);
        t.apply();
        t.close();
        surface.release();
        return;
    L26:
        h.touchableRegion.set(region);
        h.replaceTouchableRegionWithCrop = false;
        int permissionResult = this.mContext.checkPermission("android.permission.MANAGE_ACTIVITY_TASKS", callingPid, callingUid);
        if (permissionResult == 0) goto L29;
        h.setTouchableRegionCrop(surface);
        goto L29
    L19:
        isTrustedOverlay = false;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    void updateInputChannel(IBinder channelToken, int displayId, SurfaceControl surface, int flags, int privateFlags, int inputFeatures, Region region) {
        WindowManagerGlobalLock r2 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r2);
        EmbeddedWindowController.EmbeddedWindow win = this.mEmbeddedWindowController.get(channelToken);     // Catch: Throwable -> L10
        if (win != null) goto L12;
        Slog.e(TAG, "Couldn't find window for provided channelToken.");     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        return;
    L12:
        String name = win.toString();     // Catch: Throwable -> L10
        InputApplicationHandle applicationHandle = win.getApplicationHandle();     // Catch: Throwable -> L10
        if ((flags & 8) != 0) goto L15;
        boolean r4 = true;
    L16:
        win.setIsFocusable(r4);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        updateInputChannel(channelToken, win.mOwnerUid, win.mOwnerPid, displayId, surface, name, applicationHandle, flags, privateFlags, inputFeatures, win.mWindowType, region, win.mClient);
        return;
    L15:
        r4 = false;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    ActivityRecord getMostRecentActivityInAdjacent(ActivityRecord focusedActivity) {
        if (Features.FEAT_QUICK_WIN == false) goto L7;
        ActivityRecord ar = getExt().getMostRecentActivityInAdjacent(focusedActivity);
        if (ar == null) goto L7;
        return ar;
    L7:
        TaskFragment taskFragment = focusedActivity.getTaskFragment();
        if (taskFragment != null) goto L11;
        return focusedActivity;
    L11:
        if (focusedActivity.isEmbedded() == true) goto L14;
        return focusedActivity;
    L14:
        if (taskFragment.hasAdjacentTaskFragment() == true) goto L16;
        return focusedActivity;
    L16:
        final ActivityRecord[] mostRecentActiveActivity = {focusedActivity};
        final long[] mostRecentActiveTime = {focusedActivity.getLastWindowCreateTime()};
        taskFragment.forOtherAdjacentTaskFragments(new WindowManagerService$$ExternalSyntheticLambda13(mostRecentActiveTime, mostRecentActiveActivity));
        return mostRecentActiveActivity[0];
    }

    private static /* synthetic */ void lambda$getMostRecentActivityInAdjacent$28(long[] mostRecentActiveTime, ActivityRecord[] mostRecentActiveActivity, TaskFragment adjacentTaskFragment) {
        ActivityRecord adjacentTopActivity = adjacentTaskFragment.topRunningActivity();
        if (adjacentTopActivity == null) goto L8;
        long lastWindowCreateTime = adjacentTopActivity.getLastWindowCreateTime();
        if (lastWindowCreateTime <= mostRecentActiveTime[0]) goto L9;
        mostRecentActiveTime[0] = lastWindowCreateTime;
        mostRecentActiveActivity[0] = adjacentTopActivity;
        return;
    L9:
        return;
    }

    WindowState getMostRecentUsedEmbeddedWindowForBack(WindowState focusedWindow) {
        ActivityRecord focusedActivity = focusedWindow.getActivityRecord();
        if (focusedActivity != null) goto L5;
        return focusedWindow;
    L5:
        ActivityRecord mostRecentActivityInAdjacent = getMostRecentActivityInAdjacent(focusedActivity);
        if (mostRecentActivityInAdjacent != focusedActivity) goto L8;
        return focusedWindow;
    L8:
        WindowState candidate = mostRecentActivityInAdjacent.getDisplayContent().findFocusedWindow(mostRecentActivityInAdjacent);
        if (candidate == null) goto L12;
        return candidate;
    L12:
        return focusedWindow;
    }

    boolean moveFocusToAdjacentEmbeddedWindow(WindowState focusedWindow) {
        ActivityRecord activity = focusedWindow.getActivityRecord();
        if (activity != null) goto L5;
        return false;
    L5:
        if (activity.isVisible() == false) goto L11;
        ActivityRecord mostRecentActivityInAdjacent = getMostRecentActivityInAdjacent(activity);
        moveFocusToActivity(mostRecentActivityInAdjacent);
        return !focusedWindow.isFocused();
    L11:
        return false;
    }

    boolean moveFocusToAdjacentWindow(WindowState fromWin, int direction) {
        if (fromWin.isFocused() == true) goto L5;
        return false;
    L5:
        TaskFragment fromFragment = fromWin.getTaskFragment();
        if (fromFragment != null) goto L8;
    L41:
        return false;
    L8:
        if (fromFragment.asTask() != null) goto L41;
        if (fromFragment.hasAdjacentTaskFragment() == true) goto L14;
        return false;
    L14:
        if (fromFragment.getAdjacentTaskFragments().size() > 2) goto L40;
        final TaskFragment[] tmpAdjacent = new TaskFragment[1];
        fromFragment.forOtherAdjacentTaskFragments(new WindowManagerService$$ExternalSyntheticLambda11(tmpAdjacent));
        TaskFragment adjacentFragment = tmpAdjacent[0];
        if (adjacentFragment.isIsolatedNav() == false) goto L18;
        return false;
    L18:
        Rect fromBounds = fromFragment.getBounds();
        Rect adjacentBounds = adjacentFragment.getBounds();
        switch(direction) {
            case 1: goto L34;
            case 2: goto L34;
            case 17: goto L31;
            case 33: goto L28;
            case 66: goto L25;
            case 130: goto L22;
            default: goto L20;
        };
    L20:
        return false;
    L34:
        ActivityRecord topRunningActivity = adjacentFragment.topRunningActivity(true);
        if (topRunningActivity != null) goto L37;
        return false;
    L37:
        moveFocusToActivity(topRunningActivity);
        return !fromWin.isFocused();
    L22:
        if (adjacentBounds.bottom > fromBounds.bottom) goto L34;
        return false;
    L25:
        if (adjacentBounds.right > fromBounds.right) goto L34;
        return false;
    L28:
        if (adjacentBounds.top < fromBounds.top) goto L34;
        return false;
    L31:
        if (adjacentBounds.left < fromBounds.left) goto L34;
        return false;
    L40:
        throw new IllegalStateException("Not yet support 3+ adjacent for non-Task TFs");
    }

    private static /* synthetic */ boolean lambda$moveFocusToAdjacentWindow$29(TaskFragment[] tmpAdjacent, TaskFragment adjacentTF) {
        tmpAdjacent[0] = adjacentTF;
        return true;
    }

    void moveFocusToActivity(ActivityRecord activity) {
        moveDisplayToTopInternal(activity.getDisplayId());
        handleTaskFocusChange(activity.getTask(), activity);
    }

    public boolean isLayerTracing() {
        if (checkCallingPermission("android.permission.DUMP", "isLayerTracing()") == false) goto L40;
        long token = Binder.clearCallingIdentity();
        Parcel data = null;
        Parcel reply = null;
        IBinder sf = ServiceManager.getService("SurfaceFlinger");     // Catch: Throwable -> L13 RemoteException -> L15
        if (sf == null) goto L18;
        reply = Parcel.obtain();     // Catch: Throwable -> L13 RemoteException -> L15
        data = Parcel.obtain();     // Catch: Throwable -> L13 RemoteException -> L15
        data.writeInterfaceToken("android.ui.ISurfaceComposer");     // Catch: Throwable -> L13 RemoteException -> L15
        sf.transact(UsbTerminalTypes.TERMINAL_BIDIR_HEADSET, data, reply, 0);     // Catch: Throwable -> L13 RemoteException -> L15
        boolean r4 = reply.readBoolean();     // Catch: Throwable -> L13 RemoteException -> L15
        data.recycle();     // Catch: Throwable -> L11
        reply.recycle();     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return r4;
        goto L24
    L18:
        if (0 == 0) goto L20;
        data.recycle();     // Catch: Throwable -> L11
    L20:
        if (0 == 0) goto L29;
    L21:
        reply.recycle();     // Catch: Throwable -> L11
    L29:
        Binder.restoreCallingIdentity(token);
        return false;
    L13:
        th = move-exception;
        if (data == null) goto L33;
        data.recycle();     // Catch: Throwable -> L11
    L33:
        if (reply == null) goto L36;
        reply.recycle();     // Catch: Throwable -> L11
    L36:
        throw th;     // Catch: Throwable -> L11
    L24:
        Slog.e(TAG, "Failed to get layer tracing");     // Catch: Throwable -> L13
        if (data == null) goto L27;
        data.recycle();     // Catch: Throwable -> L11
    L27:
        if (reply == null) goto L29;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L40:
        throw new SecurityException("Requires DUMP permission");
    }

    public void setLayerTracing(boolean enabled) {
        if (checkCallingPermission("android.permission.DUMP", "setLayerTracing()") == false) goto L35;
        long token = Binder.clearCallingIdentity();
        Parcel data = null;
        IBinder sf = ServiceManager.getService("SurfaceFlinger");     // Catch: Throwable -> L13 RemoteException -> L15
        if (sf == null) goto L17;
        data = Parcel.obtain();     // Catch: Throwable -> L13 RemoteException -> L15
        data.writeInterfaceToken("android.ui.ISurfaceComposer");     // Catch: Throwable -> L13 RemoteException -> L15
        if (enabled == false) goto L10;
        int r5 = 1;
    L11:
        data.writeInt(r5);     // Catch: Throwable -> L13 RemoteException -> L15
        sf.transact(UsbTerminalTypes.TERMINAL_BIDIR_HANDSET, data, null, 0);     // Catch: Throwable -> L13 RemoteException -> L15
        goto L23
    L10:
        r5 = 0;
    L17:
        if (data == null) goto L26;
    L18:
        data.recycle();     // Catch: Throwable -> L20
    L26:
        Binder.restoreCallingIdentity(token);
        return;
    L13:
        th = move-exception;
        if (data == null) goto L31;
        data.recycle();     // Catch: Throwable -> L20
    L31:
        throw th;     // Catch: Throwable -> L20
    L23:
        Slog.e(TAG, "Failed to set layer tracing");     // Catch: Throwable -> L13
        if (data == null) goto L26;
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L35:
        throw new SecurityException("Requires DUMP permission");
    }

    public void setLayerTracingFlags(int flags) {
        if (checkCallingPermission("android.permission.DUMP", "setLayerTracingFlags") == false) goto L31;
        long token = Binder.clearCallingIdentity();
        Parcel data = null;
        IBinder sf = ServiceManager.getService("SurfaceFlinger");     // Catch: Throwable -> L9 RemoteException -> L11
        if (sf == null) goto L13;
        data = Parcel.obtain();     // Catch: Throwable -> L9 RemoteException -> L11
        data.writeInterfaceToken("android.ui.ISurfaceComposer");     // Catch: Throwable -> L9 RemoteException -> L11
        data.writeInt(flags);     // Catch: Throwable -> L9 RemoteException -> L11
        sf.transact(1033, data, null, 0);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        if (data == null) goto L22;
    L14:
        data.recycle();     // Catch: Throwable -> L16
    L22:
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        if (data == null) goto L27;
        data.recycle();     // Catch: Throwable -> L16
    L27:
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L19:
        Slog.e(TAG, "Failed to set layer tracing flags");     // Catch: Throwable -> L9
        if (data == null) goto L22;
    L31:
        throw new SecurityException("Requires DUMP permission");
    }

    public void setActiveTransactionTracing(boolean active) {
        if (checkCallingPermission("android.permission.DUMP", "setActiveTransactionTracing()") == false) goto L35;
        long token = Binder.clearCallingIdentity();
        Parcel data = null;
        IBinder sf = ServiceManager.getService("SurfaceFlinger");     // Catch: Throwable -> L13 RemoteException -> L15
        if (sf == null) goto L17;
        data = Parcel.obtain();     // Catch: Throwable -> L13 RemoteException -> L15
        data.writeInterfaceToken("android.ui.ISurfaceComposer");     // Catch: Throwable -> L13 RemoteException -> L15
        if (active == false) goto L10;
        int r5 = 1;
    L11:
        data.writeInt(r5);     // Catch: Throwable -> L13 RemoteException -> L15
        sf.transact(FrameworkStatsLog.ADVANCED_PROTECTION_SUPPORT_DIALOG_DISPLAYED, data, null, 0);     // Catch: Throwable -> L13 RemoteException -> L15
        goto L23
    L10:
        r5 = 0;
    L17:
        if (data == null) goto L26;
    L18:
        data.recycle();     // Catch: Throwable -> L20
    L26:
        Binder.restoreCallingIdentity(token);
        return;
    L13:
        th = move-exception;
        if (data == null) goto L31;
        data.recycle();     // Catch: Throwable -> L20
    L31:
        throw th;     // Catch: Throwable -> L20
    L23:
        Slog.e(TAG, "Failed to set transaction tracing");     // Catch: Throwable -> L13
        if (data == null) goto L26;
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L35:
        throw new SecurityException("Requires DUMP permission");
    }

    public boolean mirrorDisplay(int displayId, SurfaceControl outSurfaceControl) {
        if (checkCallingPermission("android.permission.READ_FRAME_BUFFER", "mirrorDisplay()") == false) goto L22;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent != null) goto L14;
        Slog.e(TAG, "Invalid displayId " + displayId + " for mirrorDisplay");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return false;
    L14:
        SurfaceControl displaySc = displayContent.getWindowingLayer();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        SurfaceControl mirror = SurfaceControl.mirrorSurface(displaySc);
        outSurfaceControl.copyFrom(mirror, "WMS.mirrorDisplay");
        mirror.release();
        return true;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L22:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    public boolean getWindowInsets(int displayId, IBinder token, InsetsState outInsetsState) {
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L18
        boostPriorityForLockedSection();     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
        DisplayContent dc = getDisplayContentOrCreate(displayId, token);     // Catch: Throwable -> L11
        if (dc == null) goto L14;
        WindowToken winToken = dc.getWindowToken(token);     // Catch: Throwable -> L11
        dc.getInsetsPolicy().getInsetsForWindowMetrics(winToken, outInsetsState);     // Catch: Throwable -> L11
        boolean r5 = dc.getDisplayPolicy().areSystemBarsForcedConsumedLw();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r5;
    L14:
        throw new WindowManager.InvalidDisplayException("Display#" + displayId + "could not be found!");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    public List<DisplayInfo> getPossibleDisplayInfo(int displayId) {
        int callingUid = Binder.getCallingUid();
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r3 = this.mGlobalLock;     // Catch: Throwable -> L22
        boostPriorityForLockedSection();     // Catch: Throwable -> L22
        monitor-enter(r3);     // Catch: Throwable -> L22
    L13:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L6:
        if (this.mAtmService.isCallerRecents(callingUid) == false) goto L8;
    L15:
        List<DisplayInfo> r4 = this.mPossibleDisplayInfoMapper.getPossibleDisplayInfos(displayId);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r4;
    L8:
        if (callingUid == 1000) goto L15;
        Slog.e(TAG, "Unable to verify uid for getPossibleDisplayInfo on uid " + callingUid);     // Catch: Throwable -> L13
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return r5;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    List<DisplayInfo> getPossibleDisplayInfoLocked(int displayId) {
        return this.mPossibleDisplayInfoMapper.getPossibleDisplayInfos(displayId);
    }

    void grantEmbeddedWindowFocus(Session session, InputTransferToken inputTransferToken, boolean grantFocus) {
        WindowManagerGlobalLock r3 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r3);
        EmbeddedWindowController.EmbeddedWindow embeddedWindow = this.mEmbeddedWindowController.getByInputTransferToken(inputTransferToken);     // Catch: Throwable -> L12
        if (embeddedWindow != null) goto L15;
        Slog.e(TAG, "Embedded window not found");     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L15:
        if (embeddedWindow.mSession == session) goto L20;
        Slog.e(TAG, "Window not in session:" + session);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L20:
        IBinder inputToken = embeddedWindow.getInputChannelToken();     // Catch: Throwable -> L12
        if (inputToken != null) goto L26;
        Slog.e(TAG, "Focus token found but input channel token not found");     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L26:
        SurfaceControl.Transaction t = this.mTransactionFactory.get();     // Catch: Throwable -> L12
        int displayId = embeddedWindow.mDisplayId;     // Catch: Throwable -> L12
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if ("PREFETCH_APP".equals(displayContent.getDisplay().getName()) == false) goto L33;
        Slog.i(TAG, " skip setFocusedWindow for displayId:" + displayId + " window:" + embeddedWindow.toString());     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L33:
        if (grantFocus == false) goto L35;
        t.setFocusedWindow(inputToken, embeddedWindow.toString(), displayId).apply();     // Catch: Throwable -> L12
        EventLog.writeEvent(LOGTAG_INPUT_FOCUS, new Object[]{"Focus request " + embeddedWindow, "reason=grantEmbeddedWindowFocus(true)"});     // Catch: Throwable -> L12
    L45:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L47;
        String protoLogParam0 = String.valueOf(embeddedWindow);     // Catch: Throwable -> L12
        String protoLogParam1 = String.valueOf(grantFocus);     // Catch: Throwable -> L12
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, -6056928081282320632L, 0, new Object[]{protoLogParam0, protoLogParam1});     // Catch: Throwable -> L12
    L47:
        monitor-exit(r3);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L35:
        WindowState newFocusTarget = displayContent.findFocusedWindow();     // Catch: Throwable -> L12
        if (newFocusTarget != null) goto L43;
        t.setFocusedWindow(null, null, displayId).apply();     // Catch: Throwable -> L12
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L40;
        String protoLogParam2 = String.valueOf(embeddedWindow);     // Catch: Throwable -> L12
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, -7394143854567081754L, 0, new Object[]{protoLogParam2});     // Catch: Throwable -> L12
    L40:
        monitor-exit(r3);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return;
    L43:
        t.setFocusedWindow(newFocusTarget.mInputChannelToken, newFocusTarget.getName(), displayId).apply();     // Catch: Throwable -> L12
        EventLog.writeEvent(LOGTAG_INPUT_FOCUS, new Object[]{"Focus request " + newFocusTarget, "reason=grantEmbeddedWindowFocus(false)"});     // Catch: Throwable -> L12
    L12:
        th = th;
    L52:
        monitor-exit(r3);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        throw th;
    L50:
        th = th;
        goto L52
    }

    void grantEmbeddedWindowFocus(Session session, IWindow callingWindow, InputTransferToken inputTransferToken, boolean grantFocus) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState hostWindow = windowForClientLocked(session, callingWindow, false);     // Catch: Throwable -> L11
        if (hostWindow != null) goto L14;
        Slog.e(TAG, "Host window not found");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L14:
        if (hostWindow.mInputChannelToken != null) goto L19;
        Slog.e(TAG, "Host window does not have an input channel");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L19:
        EmbeddedWindowController.EmbeddedWindow embeddedWindow = this.mEmbeddedWindowController.getByInputTransferToken(inputTransferToken);     // Catch: Throwable -> L11
        if (embeddedWindow != null) goto L26;
        Slog.e(TAG, "Embedded window not found");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L26:
        if (embeddedWindow.mHostWindowState == hostWindow) goto L32;
        Slog.e(TAG, "Embedded window does not belong to the host");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L32:
        if (grantFocus == false) goto L34;
        hostWindow.mInputWindowHandle.setFocusTransferTarget(embeddedWindow.getInputChannelToken());     // Catch: Throwable -> L11
        EventLog.writeEvent(LOGTAG_INPUT_FOCUS, new Object[]{"Transfer focus request " + embeddedWindow, "reason=grantEmbeddedWindowFocus(true)"});     // Catch: Throwable -> L11
    L35:
        DisplayContent dc = this.mRoot.getDisplayContent(hostWindow.getDisplayId());     // Catch: Throwable -> L11
        if (dc == null) goto L39;
        dc.getInputMonitor().updateInputWindowsLw(true);     // Catch: Throwable -> L11
    L39:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L41;
        String protoLogParam0 = String.valueOf(embeddedWindow);     // Catch: Throwable -> L11
        String protoLogParam1 = String.valueOf(grantFocus);     // Catch: Throwable -> L11
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, -6056928081282320632L, 0, new Object[]{protoLogParam0, protoLogParam1});     // Catch: Throwable -> L11
    L41:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L34:
        hostWindow.mInputWindowHandle.setFocusTransferTarget(null);     // Catch: Throwable -> L11
        EventLog.writeEvent(LOGTAG_INPUT_FOCUS, new Object[]{"Transfer focus request " + hostWindow, "reason=grantEmbeddedWindowFocus(false)"});     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void holdLock(IBinder token, int durationMs) {
        this.mTestUtilityService.verifyHoldLockToken(token);
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        SystemClock.sleep(durationMs);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public String[] getSupportedDisplayHashAlgorithms() {
        return this.mDisplayHashController.getSupportedHashAlgorithms();
    }

    public VerifiedDisplayHash verifyDisplayHash(DisplayHash displayHash) {
        return this.mDisplayHashController.verifyDisplayHash(displayHash);
    }

    public void setDisplayHashThrottlingEnabled(boolean enable) {
        if (checkCallingPermission("android.permission.READ_FRAME_BUFFER", "setDisplayHashThrottle()") == false) goto L7;
        this.mDisplayHashController.setDisplayHashThrottlingEnabled(enable);
        return;
    L7:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    public boolean isTaskSnapshotSupported() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mTaskSnapshotController.shouldDisableSnapshots() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void generateDisplayHash(Session session, IWindow window, Rect boundsInWindow, String hashAlgorithm, RemoteCallback callback) {
        Rect boundsInDisplay = new Rect(boundsInWindow);
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        WindowState win = windowForClientLocked(session, window, false);     // Catch: Throwable -> L11
        if (win != null) goto L14;
        Slog.w(TAG, "Failed to generate DisplayHash. Invalid window");     // Catch: Throwable -> L11
        this.mDisplayHashController.sendDisplayHashError(callback, -3);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L14:
        if (win.mActivityRecord == null) goto L34;
        if (win.mActivityRecord.isState(ActivityRecord.State.RESUMED) == false) goto L34;
        DisplayContent displayContent = win.getDisplayContent();     // Catch: Throwable -> L11
        if (displayContent != null) goto L24;
        Slog.w(TAG, "Failed to generate DisplayHash. Window is not on a display");     // Catch: Throwable -> L11
        this.mDisplayHashController.sendDisplayHashError(callback, -4);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L24:
        SurfaceControl displaySurfaceControl = displayContent.getSurfaceControl();     // Catch: Throwable -> L11
        this.mDisplayHashController.calculateDisplayHashBoundsLocked(win, boundsInWindow, boundsInDisplay);     // Catch: Throwable -> L11
        if (boundsInDisplay.isEmpty() == false) goto L31;
        Slog.w(TAG, "Failed to generate DisplayHash. Bounds are not on screen");     // Catch: Throwable -> L11
        this.mDisplayHashController.sendDisplayHashError(callback, -4);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        int uid = session.mUid;
        ScreenCapture.LayerCaptureArgs.Builder args = new ScreenCapture.LayerCaptureArgs.Builder(displaySurfaceControl).setUid(uid).setSourceCrop(boundsInDisplay);
        this.mDisplayHashController.generateDisplayHash(args, boundsInWindow, hashAlgorithm, uid, callback);
        return;
    L34:
        this.mDisplayHashController.sendDisplayHashError(callback, -3);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    boolean shouldRestoreImeVisibility(IBinder imeTargetWindowToken) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState imeTargetWindow = this.mWindowMap.get(imeTargetWindowToken);     // Catch: Throwable -> L9
        boolean r2 = false;
        if (imeTargetWindow != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return false;
    L11:
        Task imeTargetWindowTask = imeTargetWindow.getTask();     // Catch: Throwable -> L9
        if (imeTargetWindowTask != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return false;
    L17:
        if (imeTargetWindow.mActivityRecord != null) goto L19;
    L23:
        TaskSnapshot snapshot = this.mTaskSnapshotController.getSnapshot(imeTargetWindowTask.mTaskId, false);     // Catch: Throwable -> L9
        if (snapshot != null) goto L26;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return r2;
    L26:
        if (snapshot.hasImeSurface() == false) goto L28;
        r2 = true;
        goto L28
    L19:
        if (imeTargetWindow.mActivityRecord.mLastImeShown == false) goto L23;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return true;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public int getImeDisplayId() {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mRoot.getTopFocusedDisplayContent();     // Catch: Throwable -> L7
        if (dc.getImePolicy() != 0) goto L9;
        int r2 = dc.getDisplayId();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterLockedSection();
        return r2;
    L9:
        r2 = 0;
    L7:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public void setTaskSnapshotEnabled(boolean enabled) {
        this.mTaskSnapshotController.setSnapshotEnabled(enabled);
    }

    public void registerTaskFpsCallback(int taskId, ITaskFpsCallback callback) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_FPS_COUNTER") != 0) goto L18;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
    L11:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L7:
        if (this.mRoot.anyTaskForId(taskId) == null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterLockedSection();
        this.mTaskFpsCallbackController.registerListener(taskId, callback);
        return;
    L14:
        throw new IllegalArgumentException("no task with taskId: " + taskId);     // Catch: Throwable -> L11
    L18:
        int pid = Binder.getCallingPid();
        throw new SecurityException("Access denied to process: " + pid + ", must have permission android.permission.ACCESS_FPS_COUNTER");
    }

    public void unregisterTaskFpsCallback(ITaskFpsCallback callback) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_FPS_COUNTER") != 0) goto L6;
        this.mTaskFpsCallbackController.unregisterListener(callback);
        return;
    L6:
        int pid = Binder.getCallingPid();
        throw new SecurityException("Access denied to process: " + pid + ", must have permission android.permission.ACCESS_FPS_COUNTER");
    }

    public Bitmap snapshotTaskForRecents(int taskId) {
        if (checkCallingPermission("android.permission.READ_FRAME_BUFFER", "snapshotTaskForRecents()") == false) goto L36;
        long token = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L15
        boostPriorityForLockedSection();     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        Task task = this.mRoot.anyTaskForId(taskId, 1);     // Catch: Throwable -> L26
        if (task == null) goto L29;
        Supplier<TaskSnapshot> supplier = this.mTaskSnapshotController.captureSnapshot(task, true);     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        if (supplier == null) goto L17;
        TaskSnapshot taskSnapshot = supplier.get();     // Catch: Throwable -> L15
    L18:
        Binder.restoreCallingIdentity(token);
        if (taskSnapshot != null) goto L21;
    L25:
        return null;
    L21:
        if (taskSnapshot.getHardwareBuffer() == null) goto L25;
        return Bitmap.wrapHardwareBuffer(taskSnapshot.getHardwareBuffer(), taskSnapshot.getColorSpace());
    L17:
        taskSnapshot = null;
        goto L18
    L29:
        throw new IllegalArgumentException("Failed to find matching task for taskId=" + taskId);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L36:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    public void setRecentsAppBehindSystemBars(boolean behindSystemBars) {
        if (checkCallingPermission("android.permission.START_TASKS_FROM_RECENTS", "setRecentsAppBehindSystemBars()") == false) goto L25;
        long token = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L17
        boostPriorityForLockedSection();     // Catch: Throwable -> L17
        monitor-enter(r2);     // Catch: Throwable -> L17
        Task recentsApp = this.mRoot.getTask(new WindowManagerService$$ExternalSyntheticLambda38());     // Catch: Throwable -> L10
        if (recentsApp == null) goto L12;
        recentsApp.getTask().setCanAffectSystemUiFlags(behindSystemBars);     // Catch: Throwable -> L10
        this.mWindowPlacerLocked.requestTraversal();     // Catch: Throwable -> L10
    L12:
        InputMethodManagerInternal.get().maybeFinishStylusHandwriting();     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L25:
        throw new SecurityException("Requires START_TASKS_FROM_RECENTS permission");
    }

    private static /* synthetic */ boolean lambda$setRecentsAppBehindSystemBars$30(Task task) {
        if (task.isActivityTypeHomeOrRecents() == true) goto L5;
    L7:
        return false;
    L5:
        if (task.getTopVisibleActivity() == null) goto L7;
        return true;
    }

    public int getLetterboxBackgroundColorInArgb() {
        return this.mAppCompatConfiguration.getLetterboxBackgroundColor().toArgb();
    }

    public boolean isLetterboxBackgroundMultiColored() {
        int letterboxBackgroundType = this.mAppCompatConfiguration.getLetterboxBackgroundType();
        switch(letterboxBackgroundType) {
            case 0: goto L8;
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L8:
        return false;
    L5:
        throw new AssertionError("Unexpected letterbox background type: " + letterboxBackgroundType);
    }

    public void captureDisplay(int displayId, ScreenCapture.CaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener listener) {
        Slog.d(TAG, "captureDisplay");
        if (checkCallingPermission("android.permission.READ_FRAME_BUFFER", "captureDisplay()") == false) goto L20;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (dc == null) goto L11;
        dc.recordScreenshotSourceWindow();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        ScreenCapture.LayerCaptureArgs layerCaptureArgs = getCaptureArgs(displayId, captureArgs);
        ScreenCapture.captureLayers(layerCaptureArgs, listener);
        this.mObricExt.onDisplayCaptured(displayId);
        if (Binder.getCallingUid() == 1000) goto L23;
        layerCaptureArgs.release();
        return;
    L23:
        return;
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L20:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    ScreenCapture.LayerCaptureArgs getCaptureArgs(int displayId, ScreenCapture.CaptureArgs captureArgs) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L9
        if (displayContent == null) goto L19;
        SurfaceControl displaySurfaceControl = displayContent.getSurfaceControl();     // Catch: Throwable -> L9
        if (captureArgs != null) goto L12;
        captureArgs = new ScreenCapture.CaptureArgs.Builder().build();     // Catch: Throwable -> L9
    L12:
        if (captureArgs.mSourceCrop.isEmpty() == false) goto L14;
        displayContent.getBounds(this.mTmpRect);     // Catch: Throwable -> L9
        this.mTmpRect.offsetTo(0, 0);     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterLockedSection();
        return new ScreenCapture.LayerCaptureArgs.Builder(displaySurfaceControl, captureArgs).setSourceCrop(this.mTmpRect).build();
    L14:
        this.mTmpRect.set(captureArgs.mSourceCrop);     // Catch: Throwable -> L9
        goto L15
    L19:
        throw new IllegalArgumentException("Trying to screenshot and invalid display: " + displayId);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isGlobalKey(int keyCode) {
        return this.mPolicy.isGlobalKey(keyCode);
    }

    private int sanitizeWindowType(Session session, int displayId, IBinder windowToken, int type) {
        if (type != 2032) goto L14;
        if (windowToken == null) goto L14;
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);
        WindowToken token = displayContent.getWindowToken(windowToken);
        if (token != null) goto L9;
        boolean isTypeValid = false;
    L18:
        if (isTypeValid == true) goto L21;
        return 0;
    L21:
        return type;
    L9:
        if (type != token.getWindowType()) goto L11;
        isTypeValid = true;
        goto L18
    L11:
        isTypeValid = false;
    L14:
        if (session.mCanAddInternalSystemWindow == true) goto L17;
        if (type == 0) goto L17;
        Slog.w(TAG, "Requires INTERNAL_SYSTEM_WINDOW permission if assign type to input. New type will be 0.");
        isTypeValid = false;
    L17:
        isTypeValid = true;
        goto L18
    }

    public boolean addToSurfaceSyncGroup(IBinder syncGroupToken, boolean parentSyncGroupMerge, ISurfaceSyncGroupCompletedListener completedListener, AddToSurfaceSyncGroupResult outAddToSyncGroupResult) {
        return this.mSurfaceSyncGroupController.addToSyncGroup(syncGroupToken, parentSyncGroupMerge, completedListener, outAddToSyncGroupResult);
    }

    public void markSurfaceSyncGroupReady(IBinder syncGroupToken) {
        this.mSurfaceSyncGroupController.markSyncGroupReady(syncGroupToken);
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public List<ComponentName> notifyScreenshotListeners(int displayId) {
        if (checkCallingPermission("android.permission.STATUS_BAR_SERVICE", "notifyScreenshotListeners()") == false) goto L22;
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent displayContent = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent != null) goto L14;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r2;
    L14:
        final ArraySet<ComponentName> notifiedApps = new ArraySet();     // Catch: Throwable -> L12
        displayContent.forAllActivities(new WindowManagerService$$ExternalSyntheticLambda34(notifiedApps), true);     // Catch: Throwable -> L12
        List<ComponentName> r3 = List.copyOf(notifiedApps);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        return r3;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    L22:
        throw new SecurityException("Requires STATUS_BAR_SERVICE permission");
    }

    private static /* synthetic */ void lambda$notifyScreenshotListeners$31(ArraySet notifiedApps, ActivityRecord ar) {
        if (notifiedApps.contains(ar.mActivityComponent) == false) goto L5;
        return;
    L5:
        if (ar.isVisible() == true) goto L7;
        return;
    L7:
        if (ar.isRegisteredForScreenCaptureCallback() == false) goto L12;
        ar.reportScreenCaptured();
        notifiedApps.add(ar.mActivityComponent);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public boolean isCallerVirtualDeviceOwner(int displayId, int callingUid) {
        long identity = Binder.clearCallingIdentity();
        boolean r2 = this.mAtmService.mTaskSupervisor.isDeviceOwnerUid(displayId, callingUid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowManagerFuncs
    public boolean isDisplayTrusted(int displayId) {
        long identity = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L19
        boostPriorityForLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        DisplayContent dc = this.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L8;
    L12:
        boolean r4 = false;
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L10
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(identity);
        return r4;
    L8:
        if (dc.isTrusted() == false) goto L12;
        r4 = true;
    L10:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean replaceContentOnDisplay(int displayId, SurfaceControl sc) {
        if (checkCallingPermission("android.permission.ACCESS_SURFACE_FLINGER", "replaceDisplayContent()") == false) goto L25;
        long origId = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mGlobalLock;     // Catch: Throwable -> L21
        boostPriorityForLockedSection();     // Catch: Throwable -> L21
        monitor-enter(r2);     // Catch: Throwable -> L21
        DisplayContent dc = this.mRoot.getDisplayContentOrCreate(displayId);     // Catch: Throwable -> L12
        if (dc != null) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return false;
    L14:
        dc.replaceContent(sc);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return true;
    L12:
        th = move-exception;
        resetPriorityAfterLockedSection();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L25:
        throw new SecurityException("Requires ACCESS_SURFACE_FLINGER permission");
    }

    void resetFreezeRecentTaskListReordering() {
        if (checkCallingPermission("android.permission.MANAGE_ACTIVITY_TASKS", "resetFreezeRecentTaskListReordering()") == false) goto L7;
        this.mAtmService.getRecentTasks().resetFreezeTaskListReorderingOnTimeout();
        return;
    L7:
        throw new SecurityException("Requires MANAGE_ACTIVITY_TASKS permission");
    }

    public void registerTrustedPresentationListener(IBinder window, ITrustedPresentationListener listener, TrustedPresentationThresholds thresholds, int id) {
        this.mTrustedPresentationListenerController.registerListener(window, listener, thresholds, id);
    }

    public void unregisterTrustedPresentationListener(ITrustedPresentationListener listener, int id) {
        this.mTrustedPresentationListenerController.unregisterListener(listener, id);
    }

    public boolean registerScreenRecordingCallback(IScreenRecordingCallback callback) {
        registerScreenRecordingCallback_enforcePermission();
        return this.mScreenRecordingCallbackController.register(callback);
    }

    public boolean hasAlertWindow(int callingUid, int callingPid) {
        if (this.mSessions.isEmpty() == false) goto L6;
        return false;
    L6:
        boolean hasAlertWindow = false;
        Iterator<Session> r1 = this.mSessions.iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        Session session = r1.next();
        if (session.mUid != callingUid) goto L8;
        if (session.mPid != callingPid) goto L8;
        if (session.isAlertWindowEmpty() == true) goto L8;
        Slog.d(TAG, "Found session for callingPid=" + callingPid + " callingUid=" + callingUid);
        hasAlertWindow = true;
        goto L8
    L17:
        return hasAlertWindow;
    }

    public void unregisterScreenRecordingCallback(IScreenRecordingCallback callback) {
        unregisterScreenRecordingCallback_enforcePermission();
        this.mScreenRecordingCallbackController.unregister(callback);
    }

    void onProcessActivityVisibilityChanged(int uid, boolean visible) {
        this.mScreenRecordingCallbackController.onProcessActivityVisibilityChanged(uid, visible);
    }

    public void setGlobalDragListener(IGlobalDragListener listener) throws RemoteException {
        ActivityTaskManagerService.enforceTaskPermission("setUnhandledDragListener");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mDragDropController.setGlobalDragListener(listener);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    boolean getDisableSecureWindows() {
        return this.mDisableSecureWindows;
    }

    private void onWindowVisible(WindowState w) {
        showToastIfBlockingScreenCapture(w);
    }

    private void showToastIfBlockingScreenCapture(WindowState w) {
        int uid = w.getOwningUid();
        if (this.mCaptureBlockedToastShownUids.contains(uid) == false) goto L6;
        return;
    L6:
        if (w.getDisplayInfo() == null) goto L14;
        if (ActivityStarterHook.CAR_DISPLAY_NAME2.equals(w.getDisplayInfo().name) == false) goto L10;
    L11:
        Slog.d(TAG, "this is car play, so should't showToast BlockScreen Capture.");
        return;
    L10:
        if (ActivityStarterHook.CAR_DISPLAY_NAME.equals(w.getDisplayInfo().name) == true) goto L11;
    L14:
        if (this.mSensitiveContentPackages.shouldBlockScreenCaptureForApp(w.getOwningPackage(), uid, w.getWindowToken()) == false) goto L19;
        this.mCaptureBlockedToastShownUids.add(uid);
        this.mH.post(new WindowManagerService$$ExternalSyntheticLambda36(this));
        if (this.mSensitiveContentPackages.shouldBlockScreenCaptureForApp(w.getOwningPackage(), uid, null) == false) goto L20;
        FrameworkStatsLog.write(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_APPLIED, this.mSensitiveContentProtectionSessionId, uid);
        return;
    L20:
        return;
    }

    private /* synthetic */ void lambda$showToastIfBlockingScreenCapture$32() {
        Toast.makeText(this.mContext, Looper.getMainLooper(), this.mContext.getString(R.string.usb_midi_notification_title), 1).show();
    }

    private static boolean getShellTransitEnabled() {
        return true;
    }

    private void dumpVisibleWindowClients(final FileDescriptor fd, final PrintWriter pw, final long timeout) {
        final ArrayList<WindowState> systemWindows = new ArrayList();
        WindowManagerGlobalLock r1 = this.mGlobalLock;
        boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mRoot.forAllWindows(new WindowManagerService$$ExternalSyntheticLambda9(systemWindows), false);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        resetPriorityAfterLockedSection();
        systemWindows.forEach(new WindowManagerService$$ExternalSyntheticLambda10(pw, fd, timeout));
        return;
    L8:
        th = move-exception;
        resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$dumpVisibleWindowClients$33(ArrayList systemWindows, WindowState w) {
        if (w.isActivityWindow() == false) goto L5;
        return;
    L5:
        if (w.isVisibleNow() == false) goto L9;
        systemWindows.add(w);
        return;
    }

    private static /* synthetic */ void lambda$dumpVisibleWindowClients$34(PrintWriter pw, FileDescriptor fd, long timeout, WindowState w) {
        pw.println("---------------------------------");
        pw.println(w.toString());
        pw.flush();
        TransferPipe tp = new TransferPipe();     // Catch: RemoteException -> L7 IOException -> L9
        w.mClient.dumpWindow(tp.getWriteFd());     // Catch: Throwable -> L11
        tp.go(fd, timeout);     // Catch: Throwable -> L11
        tp.close();     // Catch: RemoteException -> L7 IOException -> L9
        return;
    L11:
        th = move-exception;
        tp.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: RemoteException -> L7 IOException -> L9
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L7 IOException -> L9
    L9:
        e = move-exception;
        pw.println("Failure while dumping the window: " + e);
        return;
    L17:
        pw.println("Got a RemoteException while dumping the window");
    }

    public WindowManagerServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IWindowManagerSmtEx getISmtEx() {
        return null;
    }

    public IWindowManagerExt getIExt() {
        return getExt().getIExt();
    }

    public HardwareBuffer screenShotAppWindows(int displayId, Rect rect, float scale) {
        return this.mIExt.screenShotAppWindows(displayId, rect, scale);
    }

    public boolean focusedWindowIsSecure() {
        return this.mIExt.focusedWindowIsSecure();
    }

    public IExtWindowManagerService getExt() {
        return this.mIExt;
    }

    public boolean isGlobalActionShown() {
        return ((PhoneWindowManager) this.mPolicy).getISmtEx().isGlobalActionShown();
    }

    public int getSideCutout() {
        return getDefaultDisplayContentLocked().getDisplayPolicy().getExt().getSideCutout();
    }

    public IObricWindowManager getIObricExt() {
        return this.mObricExt.getIObricExt();
    }

    public IObricWindowManagerService getObricExt() {
        return this.mObricExt;
    }

    public void updateInterceptKeyAndAnimationState(boolean homeEnabled, boolean backEnabled, int recentAnimationState, int focusTaskId, IBinder runner) {
        this.mIExt.updateInterceptKeyAndAnimationState(homeEnabled, backEnabled, recentAnimationState, focusTaskId, runner);
    }
}

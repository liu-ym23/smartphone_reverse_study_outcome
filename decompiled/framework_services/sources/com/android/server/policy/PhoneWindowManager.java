package com.android.server.policy;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityTaskManager;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.app.IUiModeManager;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.hardware.SensorPrivacyManager;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.hdmi.HdmiAudioSystemClient;
import android.hardware.hdmi.HdmiControlManager;
import android.hardware.hdmi.HdmiPlaybackClient;
import android.hardware.input.AppLaunchData;
import android.hardware.input.InputManager;
import android.hardware.input.InputSettings;
import android.hardware.input.KeyGestureEvent;
import android.media.AudioManagerInternal;
import android.media.AudioSystem;
import android.media.IAudioService;
import android.media.session.MediaSessionLegacyHelper;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeviceIdleManager;
import android.os.FactoryTest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UEventObserver;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.Vibrator;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.service.dreams.DreamManagerInternal;
import android.service.dreams.IDreamManager;
import android.service.vr.IPersistentVrStateCallbacks;
import android.telecom.TelecomManager;
import android.util.Log;
import android.util.LostModeUtil;
import android.util.MathUtils;
import android.util.MutableBoolean;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.IDisplayFoldListener;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManagerPolicyConstants;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManagerInternal;
import android.widget.Toast;
import android.widget.ToastSmtEx;
import bytedanceos.api.VibratorSmt;
import com.android.internal.accessibility.AccessibilityShortcutController;
import com.android.internal.display.BrightnessUtils;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.os.RoSystemProperties;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.policy.IShortcutService;
import com.android.internal.policy.KeyInterceptionInfo;
import com.android.internal.policy.LogDecelerateInterpolator;
import com.android.internal.policy.PhoneWindow;
import com.android.internal.policy.TransitionAnimation;
import com.android.internal.statusbar.IStatusBarService;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.AccessibilityManagerInternal;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.DockObserverInternal;
import com.android.server.ExtconStateObserver;
import com.android.server.ExtconUEventObserver;
import com.android.server.GestureLauncherService;
import com.android.server.LocalServices;
import com.android.server.SystemServiceManager;
import com.android.server.UiThread;
import com.android.server.am.HostingRecord;
import com.android.server.input.InputManagerInternal;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.inputmethod.InputMethodManagerService$HandwritingRequest$$ExternalSyntheticRecord0;
import com.android.server.pm.UserManagerInternal;
import com.android.server.policy.keyguard.KeyguardServiceDelegate;
import com.android.server.power.teardown.hwteardown.HwTeardownResult;
import com.android.server.redmagic.GameKeysCtrl;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.usb.descriptors.UsbACInterface;
import com.android.server.vibrator.HapticFeedbackVibrationProvider;
import com.android.server.vr.VrManagerInternal;
import com.android.server.wallpaper.WallpaperManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.DisplayPolicy;
import com.android.server.wm.DisplayRotation;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneWindowManager implements WindowManagerPolicy {
    private static final String ACTION_VOICE_ASSIST_RETAIL = "android.intent.action.VOICE_ASSIST_RETAIL";
    private static final int BRIGHTNESS_STEPS = 10;
    private static final long BUGREPORT_TV_GESTURE_TIMEOUT_MILLIS = 1000;
    private static final boolean DEBUG_FORCE_POWEROFF = false;
    static final boolean DEBUG_INPUT = false;
    static final boolean DEBUG_KEYGUARD = false;
    static final boolean DEBUG_WAKEUP = true;
    static final int DOUBLE_PRESS_PRIMARY_LAUNCH_DEFAULT_FITNESS_APP = 2;
    static final int DOUBLE_PRESS_PRIMARY_NOTHING = 0;
    static final int DOUBLE_PRESS_PRIMARY_SWITCH_RECENT_APP = 1;
    static final int DOUBLE_TAP_HOME_NOTHING = 0;
    static final int DOUBLE_TAP_HOME_PIP_MENU = 2;
    static final int DOUBLE_TAP_HOME_RECENT_SYSTEM_UI = 1;
    static final boolean ENABLE_DESK_DOCK_HOME_CAPTURE = false;
    static final boolean ENABLE_VR_HEADSET_HOME_CAPTURE = true;
    public static final String EXTRA_TRIGGER_HUB = "extra_trigger_hub";
    public static final String FACTORY_TEST_KEY_ACTIVITY = "com.bytedance.mmi.testcase.Key.KeyActivity";
    public static final String[] FACTORY_TEST_KEY_ACTIVITYS = null;
    private static final String FORCE_POWEROFF_INTERFACE_TOKEN = "android.stab.IBStabService";
    private static final int FORCE_POWEROFF_TRANSACTION_CODE = 24;
    private static final float KEYGUARD_SCREENSHOT_CHORD_DELAY_MULTIPLIER = 2.5f;
    static final int LAST_LONG_PRESS_HOME_BEHAVIOR = 3;
    static final int LAST_SETTINGS_KEY_BEHAVIOR = 2;
    private static final long LOG_CAPTURE_COOLDOWN_MS = 20000;
    static final int LONG_PRESS_BACK_GO_TO_VOICE_ASSIST = 1;
    static final int LONG_PRESS_BACK_NOTHING = 0;
    static final int LONG_PRESS_HOME_ALL_APPS = 1;
    static final int LONG_PRESS_HOME_ASSIST = 2;
    static final int LONG_PRESS_HOME_NOTHING = 0;
    static final int LONG_PRESS_HOME_NOTIFICATION_PANEL = 3;
    static final int LONG_PRESS_POWER_ASSISTANT = 5;
    static final int LONG_PRESS_POWER_GLOBAL_ACTIONS = 1;
    static final int LONG_PRESS_POWER_GO_TO_VOICE_ASSIST = 4;
    static final int LONG_PRESS_POWER_NOTHING = 0;
    static final int LONG_PRESS_POWER_SHUT_OFF = 2;
    static final int LONG_PRESS_POWER_SHUT_OFF_NO_CONFIRM = 3;
    static final int LONG_PRESS_PRIMARY_LAUNCH_VOICE_ASSISTANT = 1;
    static final int LONG_PRESS_PRIMARY_NOTHING = 0;
    private static final int MSG_ACCESSIBILITY_SHORTCUT = 17;
    private static final int MSG_ACCESSIBILITY_TV = 19;
    private static final int MSG_BUGREPORT_TV = 18;
    private static final int MSG_DISPATCH_BACK_KEY_TO_AUTOFILL = 20;
    private static final int MSG_DISPATCH_MEDIA_KEY_REPEAT_WITH_WAKE_LOCK = 4;
    private static final int MSG_DISPATCH_MEDIA_KEY_WITH_WAKE_LOCK = 3;
    private static final int MSG_DISPATCH_SHOW_GLOBAL_ACTIONS = 10;
    private static final int MSG_DISPATCH_SHOW_RECENTS = 9;
    private static final int MSG_HANDLE_ALL_APPS = 22;
    private static final int MSG_HIDE_BOOT_MESSAGE = 11;
    private static final int MSG_KEYGUARD_DRAWN_COMPLETE = 5;
    private static final int MSG_KEYGUARD_DRAWN_TIMEOUT = 6;
    private static final int MSG_LAUNCH_ASSIST = 23;
    private static final int MSG_LAUNCH_VOICE_ASSIST_WITH_WAKE_LOCK = 12;
    private static final int MSG_RINGER_TOGGLE_CHORD = 24;
    private static final int MSG_SCREENSHOT_CHORD = 16;
    private static final int MSG_SET_DEFERRED_KEY_ACTIONS_EXECUTABLE = 27;
    private static final int MSG_SHOW_PICTURE_IN_PICTURE_MENU = 15;
    private static final int MSG_SHOW_TOAST_DISABLE_FUNCTION_IN_POWERSAVE_MODEL = 31;
    private static final int MSG_SWITCH_KEYBOARD_LAYOUT = 25;
    private static final int MSG_SYSTEM_KEY_PRESS = 21;
    private static final int MSG_WINDOW_MANAGER_DRAWN_COMPLETE = 7;
    static final int MULTI_PRESS_POWER_BRIGHTNESS_BOOST = 2;
    static final int MULTI_PRESS_POWER_LAUNCH_TARGET_ACTIVITY = 3;
    static final int MULTI_PRESS_POWER_NOTHING = 0;
    static final int MULTI_PRESS_POWER_THEATER_MODE = 1;
    static final int PENDING_KEY_NULL = -1;
    private static final int POWER_BUTTON_SUPPRESSION_DELAY_DEFAULT_MILLIS = 800;
    private static final long POWER_LONG_PRESS_TIMEOUT_MS = 2000;
    public static final int POWER_MULTI_PRESS_TIMEOUT_MILLIS = 0;
    static final int POWER_VOLUME_UP_BEHAVIOR_GLOBAL_ACTIONS = 2;
    static final int POWER_VOLUME_UP_BEHAVIOR_MUTE = 1;
    static final int POWER_VOLUME_UP_BEHAVIOR_NOTHING = 0;
    static final int SEARCH_KEY_BEHAVIOR_DEFAULT_SEARCH = 0;
    static final int SEARCH_KEY_BEHAVIOR_TARGET_ACTIVITY = 1;
    static final int SETTINGS_KEY_BEHAVIOR_NOTHING = 2;
    static final int SETTINGS_KEY_BEHAVIOR_NOTIFICATION_PANEL = 1;
    static final int SETTINGS_KEY_BEHAVIOR_SETTINGS_ACTIVITY = 0;
    static final int SHORT_PRESS_POWER_CLOSE_IME_OR_GO_HOME = 5;
    static final int SHORT_PRESS_POWER_DREAM_OR_AWAKE_OR_SLEEP = 9;
    static final int SHORT_PRESS_POWER_DREAM_OR_SLEEP = 7;
    static final int SHORT_PRESS_POWER_GO_HOME = 4;
    static final int SHORT_PRESS_POWER_GO_TO_SLEEP = 1;
    static final int SHORT_PRESS_POWER_HUB_OR_DREAM_OR_SLEEP = 8;
    static final int SHORT_PRESS_POWER_LOCK_OR_SLEEP = 6;
    static final int SHORT_PRESS_POWER_NOTHING = 0;
    static final int SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP = 2;
    static final int SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP_AND_GO_HOME = 3;
    static final int SHORT_PRESS_PRIMARY_LAUNCH_ALL_APPS = 1;
    static final int SHORT_PRESS_PRIMARY_LAUNCH_TARGET_ACTIVITY = 2;
    static final int SHORT_PRESS_PRIMARY_NOTHING = 0;
    static final int SHORT_PRESS_SLEEP_GO_TO_SLEEP = 0;
    static final int SHORT_PRESS_SLEEP_GO_TO_SLEEP_AND_GO_HOME = 1;
    static final int SHORT_PRESS_WINDOW_NOTHING = 0;
    static final int SHORT_PRESS_WINDOW_PICTURE_IN_PICTURE = 1;
    private static final String STAB_SERVICE_NAME = "stabservice";
    public static final String SYSTEM_DIALOG_REASON_ASSIST = "assist";
    public static final String SYSTEM_DIALOG_REASON_GESTURE_NAV = "gestureNav";
    public static final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
    public static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    public static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    public static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    public static final String SYSTEM_DIALOG_REASON_SCREENSHOT = "screenshot";
    static final String TAG = "WindowManager";
    public static final int TOAST_WINDOW_ANIM_BUFFER = 600;
    public static final int TOAST_WINDOW_TIMEOUT = 4100;
    public static final String TRACE_WAIT_FOR_ALL_WINDOWS_DRAWN_METHOD = "waitForAllWindowsDrawn";
    static final int TRIPLE_PRESS_PRIMARY_NOTHING = 0;
    static final int TRIPLE_PRESS_PRIMARY_TOGGLE_ACCESSIBILITY = 1;
    private static final Object UPLOAD_LOCK = null;
    static final int VERY_LONG_PRESS_POWER_GLOBAL_ACTIONS = 1;
    static final int VERY_LONG_PRESS_POWER_NOTHING = 0;
    static final int WAITING_FOR_DRAWN_TIMEOUT = 1000;
    private static final int[] WINDOW_TYPES_WHERE_HOME_DOESNT_WORK = null;
    private static volatile Handler forcePoweroffHandler = null;
    private static volatile Runnable forcePoweroffRunnable = null;
    private static volatile long lastLogCaptureTime = 0;
    static final boolean localLOGV = false;
    private static volatile boolean powerKeyDown;
    AccessibilityManager mAccessibilityManager;
    AccessibilityManagerInternal mAccessibilityManagerInternal;
    private AccessibilityShortcutController mAccessibilityShortcutController;
    ActivityManagerInternal mActivityManagerInternal;
    IActivityManager mActivityManagerService;
    ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private HashSet<Integer> mAllowLockscreenWhenOnDisplays;
    boolean mAllowStartActivityForLongPressOnPowerDuringSetup;
    AppOpsManager mAppOpsManager;
    AudioManagerInternal mAudioManagerInternal;
    AutofillManagerInternal mAutofillManagerInternal;
    volatile boolean mBackKeyHandled;
    private ActivityManager.RecentTaskInfo mBackgroundRecentTaskInfoOnStemPrimarySingleKeyUp;
    volatile boolean mBootAnimationDismissable;
    boolean mBootMessageNeedsHiding;
    ProgressDialog mBootMsgDialog;
    PowerManager.WakeLock mBroadcastWakeLock;
    BurnInProtectionHelper mBurnInProtectionHelper;
    private ButtonOverridePermissionChecker mButtonOverridePermissionChecker;
    int mCameraLensCoverState;
    Intent mCarDockIntent;
    private final SparseArray<Set<Integer>> mConsumedKeysForDevice;
    Context mContext;
    private int mCurrentUserId;
    Display mDefaultDisplay;
    DisplayPolicy mDefaultDisplayPolicy;
    DisplayRotation mDefaultDisplayRotation;
    private final DeferredKeyActionExecutor mDeferredKeyActionExecutor;
    Intent mDeskDockIntent;
    volatile boolean mDeviceGoingToSleep;
    private volatile boolean mDismissImeOnBackKeyPressed;
    private DisplayFoldController mDisplayFoldController;
    private final SparseArray<DisplayHomeButtonHandler> mDisplayHomeButtonHandlers;
    DisplayManager mDisplayManager;
    DisplayManagerInternal mDisplayManagerInternal;
    DockObserverInternal mDockObserverInternal;
    BroadcastReceiver mDockReceiver;
    int mDoublePressOnPowerBehavior;
    private int mDoublePressOnStemPrimaryBehavior;
    int mDoubleTapOnHomeBehavior;
    DreamManagerInternal mDreamManagerInternal;
    boolean mEnableBugReportKeyboardShortcut;
    private boolean mEnableCarDockHomeCapture;
    volatile boolean mEndCallKeyHandled;
    private final Runnable mEndCallLongPress;
    int mEndcallBehavior;
    private IExtPhoneWindowManager mExt;
    private UEventObserver mExtEventObserver;
    private ActivityTaskManager.RootTaskInfo mFocusedTaskInfoOnStemPrimarySingleKeyUp;
    private GameKeysCtrl mGameKeysCtrl;
    private GestureLauncherService mGestureLauncherService;
    private GlobalActions mGlobalActions;
    private Supplier<GlobalActions> mGlobalActionsFactory;
    GlobalKeyManager mGlobalKeyManager;
    private boolean mGoToSleepOnButtonPressTheaterMode;
    private UEventObserver mHDMIObserver;
    private UEventObserver mHDMISwitchObserver;
    boolean mHandleVolumeKeysInWM;
    private Handler mHandler;
    protected HapticFeedbackVibrationProvider mHapticFeedbackVibrationProvider;
    private boolean mHasFeatureAuto;
    private boolean mHasFeatureHdmiCec;
    private boolean mHasFeatureLeanback;
    private boolean mHasFeatureWatch;
    boolean mHasSoftInput;
    boolean mHaveBuiltInKeyboard;
    boolean mHavePendingMediaKeyRepeatWithWakeLock;
    HdmiControl mHdmiControl;
    Intent mHomeIntent;
    int mIncallBackBehavior;
    int mIncallPowerBehavior;
    InputManager mInputManager;
    InputManagerInternal mInputManagerInternal;
    volatile boolean mIsGoingToSleepDefaultDisplay;
    private KeyCombinationManager mKeyCombinationManager;
    private boolean mKeyguardBound;
    KeyguardServiceDelegate mKeyguardDelegate;
    final KeyguardServiceDelegate.DrawnListener mKeyguardDrawnCallback;
    private boolean mKeyguardDrawnOnce;
    private int mKeyguardDrawnTimeout;
    private boolean mKeyguardOccludedChanged;
    boolean mKidsModeEnabled;
    int mLidKeyboardAccessibility;
    int mLidNavigationAccessibility;
    private final Object mLock;
    private boolean mLockAfterDreamingTransitionFinished;
    private boolean mLockNowPending;
    LockPatternUtils mLockPatternUtils;
    int mLockScreenTimeout;
    boolean mLockScreenTimerActive;
    private final LogDecelerateInterpolator mLogDecelerateInterpolator;
    MetricsLogger mLogger;
    int mLongPressOnBackBehavior;
    int mLongPressOnHomeBehavior;
    long mLongPressOnPowerAssistantTimeoutMs;
    int mLongPressOnPowerBehavior;
    private int mLongPressOnStemPrimaryBehavior;
    ModifierShortcutManager mModifierShortcutManager;
    BroadcastReceiver mMultiuserReceiver;
    volatile boolean mNavBarVirtualKeyHapticFeedbackEnabled;
    private IObricPhoneWindowManager mObricExt;
    PackageManager mPackageManager;
    boolean mPendingCapsLockToggle;
    private boolean mPendingKeyguardOccluded;
    boolean mPendingMetaAction;
    volatile int mPendingWakeKey;
    final IPersistentVrStateCallbacks mPersistentVrModeListener;
    volatile boolean mPictureInPictureVisible;
    volatile boolean mPowerButtonLaunchGestureTriggered;
    volatile boolean mPowerButtonLaunchGestureTriggeredDuringGoingToSleep;
    private int mPowerButtonSuppressionDelayMillis;
    ComponentName mPowerDoublePressTargetActivity;
    private volatile boolean mPowerKeyConsumedByInCall;
    volatile boolean mPowerKeyHandled;
    PowerManager.WakeLock mPowerKeyWakeLock;
    PowerManager mPowerManager;
    PowerManagerInternal mPowerManagerInternal;
    int mPowerVolUpBehavior;
    boolean mPreloadedRecentApps;
    ComponentName mPrimaryShortPressTargetActivity;
    int mRecentAppsHeldModifiers;
    volatile boolean mRecentsVisible;
    volatile boolean mRequestedOrSleepingDefaultDisplay;
    int mRingerToggleChord;
    boolean mSafeMode;
    final ScreenLockTimeout mScreenLockTimeout;
    private final SparseArray<WindowManagerPolicy.ScreenOnListener> mScreenOnListeners;
    int mSearchKeyBehavior;
    ComponentName mSearchKeyTargetActivity;
    SensorPrivacyManager mSensorPrivacyManager;
    final Object mServiceAcquireLock;
    int mSettingsKeyBehavior;
    SettingsObserver mSettingsObserver;
    int mShortPressOnPowerBehavior;
    int mShortPressOnSleepBehavior;
    private int mShortPressOnStemPrimaryBehavior;
    int mShortPressOnWindowBehavior;
    private boolean mShouldEarlyShortPressOnPower;
    boolean mShouldEarlyShortPressOnStemPrimary;
    SideFpsEventHandler mSideFpsEventHandler;
    boolean mSilenceRingerOnSleepKey;
    private SingleKeyGestureDetector mSingleKeyGestureDetector;
    private PhoneWindowManagerSmtEx mSmtEx;
    StatusBarManagerInternal mStatusBarManagerInternal;
    IStatusBarService mStatusBarService;
    boolean mStylusButtonsEnabled;
    private boolean mSupportLongPressPowerWhenNonInteractive;
    private boolean mSupportShortPressPowerWhenDefaultDisplayOn;
    boolean mSystemBooted;
    boolean mSystemNavigationKeysEnabled;
    boolean mSystemReady;
    private TalkbackShortcutController mTalkbackShortcutController;
    private volatile int mTopFocusedDisplayId;
    int mTriplePressOnPowerBehavior;
    private int mTriplePressOnStemPrimaryBehavior;
    int mUiMode;
    IUiModeManager mUiModeManager;
    boolean mUseTvRouting;
    UserManagerInternal mUserManagerInternal;
    int mVeryLongPressOnPowerBehavior;
    Vibrator mVibrator;
    private final boolean mVisibleBackgroundUsersEnabled;
    private VoiceAccessShortcutController mVoiceAccessShortcutController;
    Intent mVrHeadsetHomeIntent;
    volatile VrManagerInternal mVrManagerInternal;
    boolean mWakeGestureEnabledSetting;
    MyWakeGestureListener mWakeGestureListener;
    boolean mWakeOnAssistKeyPress;
    boolean mWakeOnBackKeyPress;
    boolean mWakeOnDpadKeyPress;
    long mWakeUpToLastStateTimeout;
    private WallpaperManagerInternal mWallpaperManagerInternal;
    WindowManagerPolicy.WindowManagerFuncs mWindowManagerFuncs;
    WindowManagerInternal mWindowManagerInternal;
    private WindowWakeUpPolicy mWindowWakeUpPolicy;
    private IZswPhoneWindowManager mZswExt;

    private final class AIKeyRule extends SingleKeyGestureDetector.SingleKeyRule {
        final /* synthetic */ PhoneWindowManager this$0;

        AIKeyRule(PhoneWindowManager r1) {
            this.this$0 = r1;
            super(FrameworkStatsLog.BINDER_LATENCY_REPORTED);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        boolean supportLongPress() {
            return true;
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        int getMaxMultiPressCount() {
            return 2;
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onPress(long downTime, int displayId) {
            PhoneWindowManager.m7239$$Nest$monAiKeyPress(this.this$0, downTime, false, 1);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onLongPress(long eventTime) {
            PhoneWindowManager.m7239$$Nest$monAiKeyPress(this.this$0, eventTime, true, 1);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onMultiPress(long downTime, int count, int displayId) {
            PhoneWindowManager.m7239$$Nest$monAiKeyPress(this.this$0, downTime, false, count);
        }
    }

    private final class BackKeyRule extends SingleKeyGestureDetector.SingleKeyRule {
        final /* synthetic */ PhoneWindowManager this$0;

        BackKeyRule(PhoneWindowManager r1) {
            this.this$0 = r1;
            super(4);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        boolean supportLongPress() {
            return PhoneWindowManager.m7228$$Nest$mhasLongPressOnBackBehavior(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        int getMaxMultiPressCount() {
            return 1;
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onPress(long downTime, int unusedDisplayId) {
            this.this$0.mBackKeyHandled |= PhoneWindowManager.m7207$$Nest$mbackKeyPress(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onLongPress(long downTime) {
            PhoneWindowManager.m7208$$Nest$mbackLongPress(this.this$0);
        }
    }

    static class ButtonOverridePermissionChecker {
        ButtonOverridePermissionChecker() {
        }

        boolean canAppOverrideSystemKey(Context context, int uid) {
            if (PermissionChecker.checkPermissionForDataDelivery(context, "android.permission.OVERRIDE_SYSTEM_KEY_BEHAVIOR_IN_FOCUSED_WINDOW", -1, uid, null, null, null) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private class DisplayHomeButtonHandler {
        private final int mDisplayId;
        private boolean mHomeConsumed;
        private final Runnable mHomeDoubleTapTimeoutRunnable;
        private boolean mHomePressed;
        private KeyEvent mPendingHomeKeyEvent;
        final /* synthetic */ PhoneWindowManager this$0;

        public static /* synthetic */ void $r8$lambda$VJu21P62ozAAVHOW8NhsCaa7GAM(DisplayHomeButtonHandler r0, KeyEvent r1) {
            r0.lambda$handleHomeButton$2(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$kUgY5x-80NChwKfMDBkKp8OE1MY, reason: not valid java name */
        public static /* synthetic */ void m7253$r8$lambda$kUgY5x80NChwKfMDBkKp8OE1MY(DisplayHomeButtonHandler r0, KeyEvent r1) {
            r0.lambda$handleHomeButton$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$nwPlpR08fs1zFdefRqCgt1Vp15s(DisplayHomeButtonHandler r0, KeyEvent r1) {
            r0.lambda$handleHomeButton$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingHomeKeyEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ KeyEvent m7254$$Nest$fgetmPendingHomeKeyEvent(DisplayHomeButtonHandler r0) {
            return r0.mPendingHomeKeyEvent;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmPendingHomeKeyEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7255$$Nest$fputmPendingHomeKeyEvent(DisplayHomeButtonHandler r0, KeyEvent r1) {
            r0.mPendingHomeKeyEvent = r1;
        }

        DisplayHomeButtonHandler(PhoneWindowManager r1, int displayId) {
            this.this$0 = r1;
            this.mHomeDoubleTapTimeoutRunnable = new AnonymousClass1(this);
            this.mDisplayId = displayId;
        }

        boolean handleHomeButton(IBinder focusedToken, final KeyEvent event) {
            boolean keyguardOn = this.this$0.keyguardOn();
            int repeatCount = event.getRepeatCount();
            int r3 = 0;
            if (event.getAction() != 0) goto L5;
            boolean down = true;
        L6:
            boolean canceled = event.isCanceled();
            if (down == false) goto L9;
            KeyInterceptionInfo info = this.this$0.mWindowManagerInternal.getKeyInterceptionInfoFromToken(focusedToken);
            if (info != null) goto L31;
        L45:
            if (repeatCount != 0) goto L55;
            this.mHomePressed = true;
            if (this.mPendingHomeKeyEvent == null) goto L50;
            this.mPendingHomeKeyEvent = null;
            PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mHomeDoubleTapTimeoutRunnable);
            PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).post(new PhoneWindowManager$DisplayHomeButtonHandler$$ExternalSyntheticLambda1(this, event));
        L58:
            return true;
        L50:
            if (this.this$0.mDoubleTapOnHomeBehavior != 1) goto L58;
            if (this.mDisplayId != 0) goto L58;
            PhoneWindowManager.m7242$$Nest$mpreloadRecentApps(this.this$0);
            goto L58
        L55:
            if ((event.getFlags() & 128) == 0) goto L58;
            if (keyguardOn == true) goto L58;
            PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).post(new PhoneWindowManager$DisplayHomeButtonHandler$$ExternalSyntheticLambda2(this, event));
            goto L58
        L31:
            if (info.layoutParamsType != 2009) goto L33;
        L44:
            return false;
        L33:
            if (info.layoutParamsType == 2040) goto L35;
        L37:
            int[] r7 = PhoneWindowManager.m7252$$Nest$sfgetWINDOW_TYPES_WHERE_HOME_DOESNT_WORK();
            int r8 = r7.length;
        L39:
            if (r3 >= r8) goto L45;
            int t = r7[r3];
            if (info.layoutParamsType == t) goto L42;
            r3 = r3 + 1;
            goto L39
        L42:
            return true;
        L35:
            if (this.this$0.isKeyguardShowing() == false) goto L37;
        L9:
            if (this.mDisplayId != 0) goto L11;
            PhoneWindowManager.m7213$$Nest$mcancelPreloadRecentApps(this.this$0);
        L11:
            this.mHomePressed = false;
            if (this.mHomeConsumed == false) goto L15;
            this.mHomeConsumed = false;
            return true;
        L15:
            if (canceled == false) goto L19;
            Log.i(PhoneWindowManager.TAG, "Ignoring HOME; event canceled.");
            return true;
        L19:
            if (this.this$0.mDoubleTapOnHomeBehavior != 0) goto L21;
        L26:
            PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).post(new PhoneWindowManager$DisplayHomeButtonHandler$$ExternalSyntheticLambda0(this, event));
            return true;
        L21:
            if (this.this$0.mDoubleTapOnHomeBehavior == 2) goto L23;
        L24:
            PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mHomeDoubleTapTimeoutRunnable);
            this.mPendingHomeKeyEvent = event;
            PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).postDelayed(this.mHomeDoubleTapTimeoutRunnable, ViewConfiguration.getDoubleTapTimeout());
            return true;
        L23:
            if (this.this$0.mPictureInPictureVisible == false) goto L26;
        L5:
            down = false;
            goto L6
        }

        private /* synthetic */ void lambda$handleHomeButton$0(KeyEvent event) {
            PhoneWindowManager.m7238$$Nest$mnotifyKeyGestureCompleted(this.this$0, event, 1);
            PhoneWindowManager.m7225$$Nest$mhandleShortPressOnHome(this.this$0, event.getDisplayId());
        }

        private /* synthetic */ void lambda$handleHomeButton$1(KeyEvent event) {
            handleDoubleTapOnHome(event);
        }

        private /* synthetic */ void lambda$handleHomeButton$2(KeyEvent event) {
            handleLongPressOnHome(event);
        }

        private void handleDoubleTapOnHome(KeyEvent event) {
            if (this.mHomeConsumed == false) goto L6;
            return;
        L6:
            switch(this.this$0.mDoubleTapOnHomeBehavior) {
                case 1: goto L13;
                case 2: goto L9;
                default: goto L7;
            };
        L7:
            Log.w(PhoneWindowManager.TAG, "No action or undefined behavior for double tap home: " + this.this$0.mDoubleTapOnHomeBehavior);
            return;
        L9:
            if (PhoneWindowManager.m7236$$Nest$misKeyEventForCurrentUser(this.this$0, event.getDisplayId(), event.getKeyCode(), "showPictureInPictureMenu") == false) goto L19;
            this.mHomeConsumed = true;
            PhoneWindowManager.m7245$$Nest$mshowPictureInPictureMenuInternal(this.this$0);
            return;
        L19:
            return;
        L13:
            if (PhoneWindowManager.m7236$$Nest$misKeyEventForCurrentUser(this.this$0, event.getDisplayId(), event.getKeyCode(), "toggleRecentApps") == false) goto L20;
            PhoneWindowManager.m7238$$Nest$mnotifyKeyGestureCompleted(this.this$0, event, 4);
            this.mHomeConsumed = true;
            PhoneWindowManager.m7250$$Nest$mtoggleRecentApps(this.this$0);
            return;
        }

        private void handleLongPressOnHome(KeyEvent event) {
            if (this.mHomeConsumed == false) goto L6;
            return;
        L6:
            if (this.this$0.mLongPressOnHomeBehavior != 0) goto L8;
            return;
        L8:
            this.mHomeConsumed = true;
            this.this$0.performHapticFeedback(0, "Home - Long Press");
            switch(this.this$0.mLongPressOnHomeBehavior) {
                case 1: goto L19;
                case 2: goto L16;
                case 3: goto L12;
                default: goto L10;
            };
        L10:
            Log.w(PhoneWindowManager.TAG, "Undefined long press on home behavior: " + this.this$0.mLongPressOnHomeBehavior);
            return;
        L19:
            PhoneWindowManager.m7238$$Nest$mnotifyKeyGestureCompleted(this.this$0, event, 21);
            if (PhoneWindowManager.m7236$$Nest$misKeyEventForCurrentUser(this.this$0, event.getDisplayId(), event.getKeyCode(), "launchAllAppsViaA11y") == false) goto L26;
            PhoneWindowManager.m7237$$Nest$mlaunchAllAppsAction(this.this$0);
            return;
        L26:
            return;
        L12:
            if (PhoneWindowManager.m7236$$Nest$misKeyEventForCurrentUser(this.this$0, event.getDisplayId(), event.getKeyCode(), "toggleNotificationPanel") == false) goto L27;
            PhoneWindowManager.m7238$$Nest$mnotifyKeyGestureCompleted(this.this$0, event, 8);
            PhoneWindowManager.m7249$$Nest$mtoggleNotificationPanel(this.this$0);
            return;
        L27:
            return;
        L16:
            if (PhoneWindowManager.m7236$$Nest$misKeyEventForCurrentUser(this.this$0, event.getDisplayId(), event.getKeyCode(), "launchAssistAction") == false) goto L28;
            PhoneWindowManager.m7238$$Nest$mnotifyKeyGestureCompleted(this.this$0, event, 5);
            this.this$0.launchAssistAction(null, event.getDeviceId(), event.getEventTime(), 5);
            return;
        }

        public String toString() {
            return String.format("mDisplayId = %d, mHomePressed = %b", new Object[]{Integer.valueOf(this.mDisplayId), Boolean.valueOf(this.mHomePressed)});
        }
    }

    private static class HdmiControl {
        private final HdmiPlaybackClient mClient;

        /* synthetic */ HdmiControl(HdmiPlaybackClient r1, PhoneWindowManagerIA r2) {
            this(r1);
        }

        private HdmiControl(HdmiPlaybackClient client) {
            this.mClient = client;
        }

        public void turnOnTv() {
            if (this.mClient != null) goto L5;
            return;
        L5:
            this.mClient.oneTouchPlay(new AnonymousClass1(this));
        }
    }

    private class HdmiVideoExtconUEventObserver extends ExtconStateObserver<Boolean> {
        private static final String DP_EXIST = "DP=1";
        private static final String HDMI_EXIST = "HDMI=1";
        private static final String NAME = "hdmi";
        final /* synthetic */ PhoneWindowManager this$0;

        /* JADX INFO: renamed from: -$$Nest$minit, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7256$$Nest$minit(HdmiVideoExtconUEventObserver r0, ExtconUEventObserver.ExtconInfo r1) {
            return r0.init(r1);
        }

        /* synthetic */ HdmiVideoExtconUEventObserver(PhoneWindowManager r1, PhoneWindowManagerIA r2) {
            this(r1);
        }

        private HdmiVideoExtconUEventObserver(PhoneWindowManager r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.ExtconStateObserver
        public /* bridge */ /* synthetic */ Boolean parseState(ExtconUEventObserver.ExtconInfo r1, String r2) {
            return parseState(r1, r2);
        }

        @Override // com.android.server.ExtconStateObserver
        public /* bridge */ /* synthetic */ void updateState(ExtconUEventObserver.ExtconInfo r1, String r2, Boolean r3) {
            updateState2(r1, r2, r3);
        }

        private boolean init(ExtconUEventObserver.ExtconInfo hdmi) {
            boolean plugged = false;
            plugged = parseStateFromFile(hdmi).booleanValue();     // Catch: IOException -> L6 FileNotFoundException -> L8
        L12:
            startObserving(hdmi);
            return plugged;
        L8:
            e = move-exception;
            Slog.w(PhoneWindowManager.TAG, hdmi.getStatePath() + " not found while attempting to determine initial state", e);
        L6:
            e = move-exception;
            Slog.e(PhoneWindowManager.TAG, "Error reading " + hdmi.getStatePath() + " while attempting to determine initial state", e);
            goto L12
        }

        /* JADX INFO: renamed from: updateState, reason: avoid collision after fix types in other method */
        public void updateState2(ExtconUEventObserver.ExtconInfo extconInfo, String eventName, Boolean state) {
            this.this$0.mDefaultDisplayPolicy.setHdmiPlugged(state.booleanValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.ExtconStateObserver
        public Boolean parseState(ExtconUEventObserver.ExtconInfo extconIfno, String state) {
            if (state.contains(HDMI_EXIST) == false) goto L5;
        L8:
            boolean r0 = true;
        L10:
            return Boolean.valueOf(r0);
        L5:
            if (state.contains(DP_EXIST) == true) goto L8;
            r0 = false;
            goto L10
        }
    }

    static class Injector {
        private final Context mContext;
        private final WindowManagerPolicy.WindowManagerFuncs mWindowManagerFuncs;

        public static /* synthetic */ GlobalActions $r8$lambda$b00RGJpCf1JGHPQ5VnktvrvGBgA(Injector r0) {
            return r0.lambda$getGlobalActionsFactory$0();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerFuncs, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowManagerPolicy.WindowManagerFuncs m7257$$Nest$fgetmWindowManagerFuncs(Injector r0) {
            return r0.mWindowManagerFuncs;
        }

        Injector(Context context, WindowManagerPolicy.WindowManagerFuncs funcs) {
            this.mContext = context;
            this.mWindowManagerFuncs = funcs;
        }

        Context getContext() {
            return this.mContext;
        }

        WindowManagerPolicy.WindowManagerFuncs getWindowManagerFuncs() {
            return this.mWindowManagerFuncs;
        }

        Looper getLooper() {
            return Looper.myLooper();
        }

        AccessibilityShortcutController getAccessibilityShortcutController(Context context, Handler handler, int initialUserId) {
            return new AccessibilityShortcutController(context, handler, initialUserId);
        }

        private /* synthetic */ GlobalActions lambda$getGlobalActionsFactory$0() {
            return new GlobalActions(this.mContext, this.mWindowManagerFuncs);
        }

        Supplier<GlobalActions> getGlobalActionsFactory() {
            return new PhoneWindowManager$Injector$$ExternalSyntheticLambda0(this);
        }

        KeyguardServiceDelegate getKeyguardServiceDelegate() {
            return new KeyguardServiceDelegate(this.mContext, new AnonymousClass1(this));
        }

        IActivityManager getActivityManagerService() {
            return ActivityManager.getService();
        }

        LockPatternUtils getLockPatternUtils() {
            return new LockPatternUtils(this.mContext);
        }

        ButtonOverridePermissionChecker getButtonOverridePermissionChecker() {
            return new ButtonOverridePermissionChecker();
        }

        TalkbackShortcutController getTalkbackShortcutController() {
            return new TalkbackShortcutController(this.mContext);
        }

        VoiceAccessShortcutController getVoiceAccessShortcutController() {
            return new VoiceAccessShortcutController(this.mContext);
        }

        WindowWakeUpPolicy getWindowWakeUpPolicy() {
            return new WindowWakeUpPolicy(this.mContext);
        }
    }

    class MyWakeGestureListener extends WakeGestureListener {
        final /* synthetic */ PhoneWindowManager this$0;

        MyWakeGestureListener(PhoneWindowManager this$0, Context context, Handler handler) {
            this.this$0 = this$0;
            super(context, handler);
        }

        @Override // com.android.server.policy.WakeGestureListener
        public void onWakeUp() {
            Object r0 = PhoneWindowManager.m7192$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (PhoneWindowManager.m7244$$Nest$mshouldEnableWakeGestureLp(this.this$0) == false) goto L9;
            this.this$0.performHapticFeedback(1, "Wake Up");     // Catch: Throwable -> L7
            PhoneWindowManager.m7201$$Nest$fgetmWindowWakeUpPolicy(this.this$0).wakeUpFromWakeGesture();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    private class PolicyHandler extends Handler {
        private Toast mPowerSaveToast;
        final /* synthetic */ PhoneWindowManager this$0;

        /* synthetic */ PolicyHandler(PhoneWindowManager r1, Looper r2, PhoneWindowManagerIA r3) {
            this(r1, r2);
        }

        private PolicyHandler(PhoneWindowManager r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 3: goto L43;
                case 4: goto L42;
                case 5: goto L41;
                case 6: goto L40;
                case 7: goto L39;
                case 8: goto L73;
                case 9: goto L38;
                case 10: goto L37;
                case 11: goto L36;
                case 12: goto L35;
                case 13: goto L73;
                case 14: goto L73;
                case 15: goto L34;
                case 16: goto L33;
                case 17: goto L32;
                case 18: goto L31;
                case 19: goto L29;
                case 20: goto L27;
                case 21: goto L26;
                case 22: goto L23;
                case 23: goto L22;
                case 24: goto L21;
                case 25: goto L20;
                case 26: goto L73;
                case 27: goto L19;
                case 28: goto L73;
                case 29: goto L73;
                case 30: goto L73;
                case 31: goto L18;
                case 32: goto L15;
                case 33: goto L10;
                case 34: goto L6;
                case 35: goto L5;
                default: goto L73;
            };
        L5:
            this.this$0.getExt().handleMemoryAction();
            return;
        L6:
            Slog.d(PhoneWindowManager.TAG, "MSG_LAUNCH_ASSIST_ACTION_CANCEL mSmtEx.mAiKeyHandled=" + PhoneWindowManager.m7198$$Nest$fgetmSmtEx(this.this$0).mAiKeyHandled + " hasMsg=" + PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).hasMessages(32));
            PhoneWindowManager.m7198$$Nest$fgetmSmtEx(this.this$0).mAiKeyHandled = true;
            if (PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).hasMessages(32) == false) goto L9;
            PhoneWindowManager.m7191$$Nest$fgetmHandler(this.this$0).removeMessages(32);
            this.this$0.launchAssistAction(null, -1, SystemClock.uptimeMillis(), 20);
        L9:
            this.this$0.launchAssistAction(null, -1, SystemClock.uptimeMillis(), 22);
            return;
        L10:
            Slog.d(PhoneWindowManager.TAG, "MSG_LAUNCH_ASSIST_ACTION_UP mSmtEx.mAiKeyHandled=" + PhoneWindowManager.m7198$$Nest$fgetmSmtEx(this.this$0).mAiKeyHandled);
            if (PhoneWindowManager.m7198$$Nest$fgetmSmtEx(this.this$0).mAiKeyHandled == false) goto L14;
            PhoneWindowManager.m7198$$Nest$fgetmSmtEx(this.this$0).mAiKeyHandled = false;
            return;
        L14:
            long assistUpTime = ((Long) msg.obj).longValue();
            this.this$0.launchAssistAction(null, -1, assistUpTime, 21);
            return;
        L15:
            Slog.d(PhoneWindowManager.TAG, "MSG_LAUNCH_ASSIST_ACTION_DOWN mSmtEx.mAiKeyHandled=" + PhoneWindowManager.m7198$$Nest$fgetmSmtEx(this.this$0).mAiKeyHandled);
            if (PhoneWindowManager.m7198$$Nest$fgetmSmtEx(this.this$0).mAiKeyHandled == true) goto L48;
            long assistDownTime = ((Long) msg.obj).longValue();
            this.this$0.launchAssistAction(null, -1, assistDownTime, 20);
            return;
        L48:
            return;
        L18:
            showDisableFunctionInPowerSaveAlert();
            return;
        L19:
            int keyCode = msg.arg1;
            long downTime = ((Long) msg.obj).longValue();
            PhoneWindowManager.m7189$$Nest$fgetmDeferredKeyActionExecutor(this.this$0).setActionsExecutable(keyCode, downTime);
            return;
        L20:
            SwitchKeyboardLayoutMessageObject object = (SwitchKeyboardLayoutMessageObject) msg.obj;
            PhoneWindowManager.m7226$$Nest$mhandleSwitchKeyboardLayout(this.this$0, SwitchKeyboardLayoutMessageObject.m7260$$Nest$fgetdisplayId(object), SwitchKeyboardLayoutMessageObject.m7259$$Nest$fgetdirection(object), SwitchKeyboardLayoutMessageObject.m7261$$Nest$fgetfocusedToken(object));
            return;
        L21:
            PhoneWindowManager.m7223$$Nest$mhandleRingerChordGesture(this.this$0);
            return;
        L22:
            int deviceId = msg.arg1;
            Long eventTime = (Long) msg.obj;
            this.this$0.launchAssistAction(null, deviceId, eventTime.longValue(), 7);
            return;
        L23:
            KeyEvent keyEvent = (KeyEvent) msg.obj;
            if (PhoneWindowManager.m7236$$Nest$misKeyEventForCurrentUser(this.this$0, keyEvent.getDisplayId(), keyEvent.getKeyCode(), "launchAllAppsViaA11y") == false) goto L55;
            PhoneWindowManager.m7237$$Nest$mlaunchAllAppsAction(this.this$0);
            return;
        L55:
            return;
        L26:
            KeyEvent event = (KeyEvent) msg.obj;
            PhoneWindowManager.m7243$$Nest$msendSystemKeyToStatusBar(this.this$0, event);
            event.recycle();
            return;
        L27:
            this.this$0.mAutofillManagerInternal.onBackKeyPressed();
            return;
        L31:
            this.this$0.requestBugreportForTv();
            return;
        L32:
            PhoneWindowManager.m7206$$Nest$maccessibilityShortcutActivated(this.this$0);
            return;
        L33:
            PhoneWindowManager.m7224$$Nest$mhandleScreenShot(this.this$0, msg.arg1);
            return;
        L34:
            PhoneWindowManager.m7245$$Nest$mshowPictureInPictureMenuInternal(this.this$0);
            return;
        L35:
            this.this$0.launchVoiceAssistWithWakeLock();
            return;
        L36:
            PhoneWindowManager.m7221$$Nest$mhandleHideBootMessage(this.this$0);
            return;
        L37:
            this.this$0.showGlobalActionsInternal();
            return;
        L38:
            PhoneWindowManager.m7246$$Nest$mshowRecentApps(this.this$0, false);
            return;
        L39:
            int displayId = msg.arg1;
            Slog.w(PhoneWindowManager.TAG, "All windows drawn on display " + displayId);
            Trace.asyncTraceEnd(32, PhoneWindowManager.TRACE_WAIT_FOR_ALL_WINDOWS_DRAWN_METHOD, displayId);
            PhoneWindowManager.m7215$$Nest$mfinishWindowsDrawn(this.this$0, displayId);
            return;
        L40:
            Slog.w(PhoneWindowManager.TAG, "Keyguard drawn timeout. Setting mKeyguardDrawComplete");
            PhoneWindowManager.m7214$$Nest$mfinishKeyguardDrawn(this.this$0);
            return;
        L41:
            Slog.w(PhoneWindowManager.TAG, "Setting mKeyguardDrawComplete");
            PhoneWindowManager.m7214$$Nest$mfinishKeyguardDrawn(this.this$0);
            return;
        L42:
            this.this$0.dispatchMediaKeyRepeatWithWakeLock((KeyEvent) msg.obj);
            return;
        L43:
            this.this$0.dispatchMediaKeyWithWakeLock((KeyEvent) msg.obj);
            return;
        L73:
            return;
        L29:
            if (PhoneWindowManager.m7188$$Nest$fgetmAccessibilityShortcutController(this.this$0).isAccessibilityShortcutAvailable(false) == false) goto L59;
            PhoneWindowManager.m7206$$Nest$maccessibilityShortcutActivated(this.this$0);
            return;
        }

        private void showDisableFunctionInPowerSaveAlert() {
            if (this.mPowerSaveToast == null) goto L5;
            this.mPowerSaveToast.cancel();
        L5:
            this.mPowerSaveToast = ToastSmtEx.makeText(this.this$0.mContext, this.this$0.mContext.getResources().getString(R.string.android_upgrading_complete), 1, 2006);
            this.mPowerSaveToast.show();
        }
    }

    private final class PowerKeyRule extends SingleKeyGestureDetector.SingleKeyRule {
        final /* synthetic */ PhoneWindowManager this$0;

        PowerKeyRule(PhoneWindowManager r1) {
            this.this$0 = r1;
            super(26);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        boolean supportLongPress() {
            return PhoneWindowManager.m7229$$Nest$mhasLongPressOnPowerBehavior(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        boolean supportVeryLongPress() {
            return PhoneWindowManager.m7231$$Nest$mhasVeryLongPressOnPowerBehavior(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        int getMaxMultiPressCount() {
            return PhoneWindowManager.m7217$$Nest$mgetMaxMultiPressPowerCount(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onPress(long downTime, int displayId) {
            if (PhoneWindowManager.m7196$$Nest$fgetmShouldEarlyShortPressOnPower(this.this$0) == false) goto L5;
            return;
        L5:
            this.this$0.powerPress(downTime, 1, displayId);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        long getLongPressTimeoutMs() {
            if (PhoneWindowManager.m7219$$Nest$mgetResolvedLongPressOnPowerBehavior(this.this$0) != 5) goto L7;
            return this.this$0.mLongPressOnPowerAssistantTimeoutMs;
        L7:
            return super.getLongPressTimeoutMs();
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onLongPress(long eventTime) {
            if (PhoneWindowManager.m7197$$Nest$fgetmSingleKeyGestureDetector(this.this$0).beganFromNonInteractive() == false) goto L9;
            if (PhoneWindowManager.m7199$$Nest$fgetmSupportLongPressPowerWhenNonInteractive(this.this$0) == true) goto L9;
            Slog.v(PhoneWindowManager.TAG, "Not support long press power when device is not interactive.");
            return;
        L9:
            if (LostModeUtil.beingLostModeEnabled(this.this$0.mContext) == false) goto L11;
            return;
        L11:
            PhoneWindowManager.m7240$$Nest$mpowerLongPress(this.this$0, eventTime);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onVeryLongPress(long eventTime) {
            this.this$0.mActivityManagerInternal.prepareForPossibleShutdown();
            if (LostModeUtil.beingLostModeEnabled(this.this$0.mContext) == false) goto L5;
            return;
        L5:
            PhoneWindowManager.m7241$$Nest$mpowerVeryLongPress(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onMultiPress(long downTime, int count, int displayId) {
            this.this$0.powerPress(downTime, count, displayId);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onKeyUp(long eventTime, int count, int displayId, int deviceId, int metaState) {
            if (PhoneWindowManager.m7196$$Nest$fgetmShouldEarlyShortPressOnPower(this.this$0) == true) goto L5;
            return;
        L5:
            if (count != 1) goto L9;
            this.this$0.powerPress(eventTime, 1, displayId);
            return;
        }
    }

    class ScreenLockTimeout implements Runnable {
        Bundle options;
        final /* synthetic */ PhoneWindowManager this$0;

        ScreenLockTimeout(PhoneWindowManager this$0) {
            this.this$0 = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.this$0.mKeyguardDelegate == null) goto L8;
            this.this$0.mKeyguardDelegate.doKeyguardTimeout(this.options);     // Catch: Throwable -> L6
        L8:
            this.this$0.mLockScreenTimerActive = false;     // Catch: Throwable -> L6
            PhoneWindowManager.m7205$$Nest$fputmLockNowPending(this.this$0, false);     // Catch: Throwable -> L6
            this.options = null;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
        }

        public void setLockOptions(Bundle options) {
            this.options = options;
        }
    }

    class SettingsObserver extends ContentObserver {
        final /* synthetic */ PhoneWindowManager this$0;

        SettingsObserver(PhoneWindowManager this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        void observe() {
            ContentResolver resolver = this.this$0.mContext.getContentResolver();
            resolver.registerContentObserver(Settings.System.getUriFor("end_button_behavior"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("incall_power_button_behavior"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("incall_back_button_behavior"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("wake_gesture_enabled"), false, this, -1);
            resolver.registerContentObserver(Settings.System.getUriFor("screen_off_timeout"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("default_input_method"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("volume_hush_gesture"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("system_navigation_keys_enabled"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("power_button_short_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("power_button_double_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("power_button_triple_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("power_button_long_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("power_button_long_press_duration_ms"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("power_button_very_long_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("stem_primary_button_short_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("stem_primary_button_double_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("stem_primary_button_triple_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("stem_primary_button_long_press"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("key_chord_power_volume_up"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("power_button_suppression_delay_after_gesture_wake"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("stylus_buttons_enabled"), false, this, -1);
            resolver.registerContentObserver(Settings.Secure.getUriFor("nav_bar_kids_mode"), false, this, -1);
            this.this$0.getExt().onObserveSettings(this);
            this.this$0.getISmtEx().onObserveSettings(this);
            PhoneWindowManager.m7251$$Nest$mupdateSettings(this.this$0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            PhoneWindowManager.m7251$$Nest$mupdateSettings(this.this$0);
        }
    }

    private final class StemPrimaryKeyRule extends SingleKeyGestureDetector.SingleKeyRule {
        final /* synthetic */ PhoneWindowManager this$0;

        public static /* synthetic */ void $r8$lambda$Ipp8VL7RVf6_VLMzK05AtllNhzs(StemPrimaryKeyRule r0) {
            r0.lambda$onKeyUp$3();
        }

        /* JADX INFO: renamed from: $r8$lambda$JVHy5f_3UKtAAlxz-tLRtoanuO8, reason: not valid java name */
        public static /* synthetic */ void m7258$r8$lambda$JVHy5f_3UKtAAlxztLRtoanuO8(StemPrimaryKeyRule r0, int r1) {
            r0.lambda$onMultiPress$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$JoYv1zuZQq9ZUPbSv7Frj_uHDhQ(StemPrimaryKeyRule r0, long r1) {
            r0.lambda$onLongPress$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$nSwvshhJVDdt9yjlaj0c6KqKPsA(StemPrimaryKeyRule r0) {
            r0.lambda$onPress$0();
        }

        StemPrimaryKeyRule(PhoneWindowManager r1) {
            this.this$0 = r1;
            super(264);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        boolean supportLongPress() {
            return PhoneWindowManager.m7230$$Nest$mhasLongPressOnStemPrimaryBehavior(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        int getMaxMultiPressCount() {
            return PhoneWindowManager.m7218$$Nest$mgetMaxMultiPressStemPrimaryCount(this.this$0);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onPress(long downTime, int unusedDisplayId) {
            if (shouldHandleStemPrimaryEarlyShortPress() == false) goto L5;
            return;
        L5:
            PhoneWindowManager.m7189$$Nest$fgetmDeferredKeyActionExecutor(this.this$0).queueKeyAction(264, downTime, new PhoneWindowManager$StemPrimaryKeyRule$$ExternalSyntheticLambda1(this));
        }

        private /* synthetic */ void lambda$onPress$0() {
            PhoneWindowManager.m7248$$Nest$mstemPrimaryPress(this.this$0, 1);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onLongPress(final long eventTime) {
            if (PhoneWindowManager.m7194$$Nest$fgetmLongPressOnStemPrimaryBehavior(this.this$0) != 1) goto L5;
            PhoneWindowManager.m7247$$Nest$mstemPrimaryLongPress(this.this$0, eventTime);
            return;
        L5:
            PhoneWindowManager.m7189$$Nest$fgetmDeferredKeyActionExecutor(this.this$0).queueKeyAction(264, eventTime, new PhoneWindowManager$StemPrimaryKeyRule$$ExternalSyntheticLambda0(this, eventTime));
        }

        private /* synthetic */ void lambda$onLongPress$1(long eventTime) {
            PhoneWindowManager.m7247$$Nest$mstemPrimaryLongPress(this.this$0, eventTime);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onMultiPress(long downTime, final int count, int unusedDisplayId) {
            if (count == 3) goto L5;
        L7:
            PhoneWindowManager.m7189$$Nest$fgetmDeferredKeyActionExecutor(this.this$0).queueKeyAction(264, downTime, new PhoneWindowManager$StemPrimaryKeyRule$$ExternalSyntheticLambda2(this, count));
            return;
        L5:
            if (PhoneWindowManager.m7200$$Nest$fgetmTriplePressOnStemPrimaryBehavior(this.this$0) != 1) goto L7;
            PhoneWindowManager.m7189$$Nest$fgetmDeferredKeyActionExecutor(this.this$0).cancelQueuedAction(264);
            undoEarlySinglePress();
            PhoneWindowManager.m7248$$Nest$mstemPrimaryPress(this.this$0, count);
        }

        private /* synthetic */ void lambda$onMultiPress$2(int count) {
            PhoneWindowManager.m7248$$Nest$mstemPrimaryPress(this.this$0, count);
        }

        private void undoEarlySinglePress() {
            if (shouldHandleStemPrimaryEarlyShortPress() == true) goto L5;
            return;
        L5:
            if (PhoneWindowManager.m7190$$Nest$fgetmFocusedTaskInfoOnStemPrimarySingleKeyUp(this.this$0) == null) goto L14;
            this.this$0.mActivityManagerService.startActivityFromRecents(PhoneWindowManager.m7190$$Nest$fgetmFocusedTaskInfoOnStemPrimarySingleKeyUp(this.this$0).taskId, null);     // Catch: Throwable -> L8
            return;
        L8:
            e = move-exception;
            Slog.e(PhoneWindowManager.TAG, "Failed to start task " + PhoneWindowManager.m7190$$Nest$fgetmFocusedTaskInfoOnStemPrimarySingleKeyUp(this.this$0).taskId + " from recents", e);
            return;
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onKeyUp(long eventTime, int count, int displayId, int deviceId, int metaState) {
            if (count != 1) goto L8;
            PhoneWindowManager.m7202$$Nest$fputmBackgroundRecentTaskInfoOnStemPrimarySingleKeyUp(this.this$0, this.this$0.mActivityTaskManagerInternal.getMostRecentTaskFromBackground());
            PhoneWindowManager.m7203$$Nest$fputmFocusedTaskInfoOnStemPrimarySingleKeyUp(this.this$0, null);
            if (shouldHandleStemPrimaryEarlyShortPress() == false) goto L9;
            PhoneWindowManager.m7189$$Nest$fgetmDeferredKeyActionExecutor(this.this$0).queueKeyAction(264, eventTime, new PhoneWindowManager$StemPrimaryKeyRule$$ExternalSyntheticLambda3(this));
            return;
        L9:
            return;
        }

        private /* synthetic */ void lambda$onKeyUp$3() {
            Slog.d(PhoneWindowManager.TAG, "StemPrimaryKeyRule: executing deferred onKeyUp");
            PhoneWindowManager.m7203$$Nest$fputmFocusedTaskInfoOnStemPrimarySingleKeyUp(this.this$0, this.this$0.mActivityManagerService.getFocusedRootTaskInfo());     // Catch: RemoteException -> L5
        L7:
            PhoneWindowManager.m7248$$Nest$mstemPrimaryPress(this.this$0, 1);
            return;
        L5:
            e = move-exception;
            Slog.e(PhoneWindowManager.TAG, "StemPrimaryKeyRule: onKeyUp: error while getting focused task info.", e);
            goto L7
        }

        private boolean shouldHandleStemPrimaryEarlyShortPress() {
            if (this.this$0.mShouldEarlyShortPressOnStemPrimary == true) goto L5;
        L7:
            return false;
        L5:
            if (PhoneWindowManager.m7195$$Nest$fgetmShortPressOnStemPrimaryBehavior(this.this$0) != 1) goto L7;
            return true;
        }
    }

    private final class StylusTailButtonRule extends SingleKeyGestureDetector.SingleKeyRule {
        final /* synthetic */ PhoneWindowManager this$0;

        StylusTailButtonRule(PhoneWindowManager r1) {
            this.this$0 = r1;
            super(311);
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        int getMaxMultiPressCount() {
            return 2;
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onPress(long downTime, int displayId) {
        }

        @Override // com.android.server.policy.SingleKeyGestureDetector.SingleKeyRule
        void onKeyUp(long eventTime, int pressCount, int displayId, int deviceId, int metaState) {
            if (pressCount == 1) goto L5;
            return;
        L5:
            PhoneWindowManager.m7222$$Nest$mhandleKeyGestureInKeyGestureController(this.this$0, 33, deviceId, 311, metaState);
        }
    }

    private static final class SwitchKeyboardLayoutMessageObject extends Record {
        private final int direction;
        private final int displayId;
        private final IBinder focusedToken;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof SwitchKeyboardLayoutMessageObject) == false) goto L12;
            SwitchKeyboardLayoutMessageObject r4 = (SwitchKeyboardLayoutMessageObject) r3;
            if (this.displayId == r4.displayId) goto L7;
            return false;
        L7:
            if (this.direction == r4.direction) goto L9;
            return false;
        L9:
            if (Objects.equals(this.focusedToken, r4.focusedToken) == false) goto L16;
            return true;
        L16:
            return false;
        L12:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Integer.valueOf(this.displayId), this.focusedToken, Integer.valueOf(this.direction)};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetdirection, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7259$$Nest$fgetdirection(SwitchKeyboardLayoutMessageObject r0) {
            return r0.direction;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetdisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7260$$Nest$fgetdisplayId(SwitchKeyboardLayoutMessageObject r0) {
            return r0.displayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetfocusedToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m7261$$Nest$fgetfocusedToken(SwitchKeyboardLayoutMessageObject r0) {
            return r0.focusedToken;
        }

        /* synthetic */ SwitchKeyboardLayoutMessageObject(int r1, IBinder r2, int r3, PhoneWindowManagerIA r4) {
            this(r1, r2, r3);
        }

        private SwitchKeyboardLayoutMessageObject(int displayId, IBinder focusedToken, int direction) {
            this.displayId = displayId;
            this.focusedToken = focusedToken;
            this.direction = direction;
        }

        public int direction() {
            return this.direction;
        }

        public int displayId() {
            return this.displayId;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        public IBinder focusedToken() {
            return this.focusedToken;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return InputMethodManagerService$HandwritingRequest$$ExternalSyntheticRecord0.m(this.displayId, this.direction, this.focusedToken);
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), SwitchKeyboardLayoutMessageObject.class, "displayId;focusedToken;direction");
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$HsdZ1AfL-mrHwMvboPYQ-e8DrWU, reason: not valid java name */
    public static /* synthetic */ void m7185$r8$lambda$HsdZ1AfLmrHwMvboPYQe8DrWU(PhoneWindowManager r0, long r1) {
        r0.lambda$powerPress$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$Nxxt3y6WeKPeZnoQW6vajtugk2M(PhoneWindowManager r0, int r1) {
        r0.lambda$handleKeyGestureEvent$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$QC2bbpvSHd9xWq-lQP6GZkyB6v8, reason: not valid java name */
    public static /* synthetic */ void m7186$r8$lambda$QC2bbpvSHd9xWqlQP6GZkyB6v8(PhoneWindowManager r0, long r1) {
        r0.lambda$powerPress$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$SYyE1zL8sE6Vki4QtTK5Eta0l5w(PhoneWindowManager r0) {
        r0.lambda$handleForcePoweroffKeyEvent$6();
    }

    public static /* synthetic */ void $r8$lambda$cjpFuuMQpoXRPvhwWotLtmxoXSs(PhoneWindowManager r0, long r1) {
        r0.lambda$powerPress$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$i3CqPQzHWdNR5T-X9ij8ApdRfuo, reason: not valid java name */
    public static /* synthetic */ boolean m7187$r8$lambda$i3CqPQzHWdNR5TX9ij8ApdRfuo(int r0) {
        return lambda$handleKeyGestureEvent$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$o1IbWpGnvS7oTobWCvMjpoMMPso(PhoneWindowManager r0) {
        r0.lambda$updateSettings$3();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityShortcutController, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityShortcutController m7188$$Nest$fgetmAccessibilityShortcutController(PhoneWindowManager r0) {
        return r0.mAccessibilityShortcutController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeferredKeyActionExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeferredKeyActionExecutor m7189$$Nest$fgetmDeferredKeyActionExecutor(PhoneWindowManager r0) {
        return r0.mDeferredKeyActionExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFocusedTaskInfoOnStemPrimarySingleKeyUp, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManager.RootTaskInfo m7190$$Nest$fgetmFocusedTaskInfoOnStemPrimarySingleKeyUp(PhoneWindowManager r0) {
        return r0.mFocusedTaskInfoOnStemPrimarySingleKeyUp;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7191$$Nest$fgetmHandler(PhoneWindowManager r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7192$$Nest$fgetmLock(PhoneWindowManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockAfterDreamingTransitionFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7193$$Nest$fgetmLockAfterDreamingTransitionFinished(PhoneWindowManager r0) {
        return r0.mLockAfterDreamingTransitionFinished;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLongPressOnStemPrimaryBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7194$$Nest$fgetmLongPressOnStemPrimaryBehavior(PhoneWindowManager r0) {
        return r0.mLongPressOnStemPrimaryBehavior;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShortPressOnStemPrimaryBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7195$$Nest$fgetmShortPressOnStemPrimaryBehavior(PhoneWindowManager r0) {
        return r0.mShortPressOnStemPrimaryBehavior;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShouldEarlyShortPressOnPower, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7196$$Nest$fgetmShouldEarlyShortPressOnPower(PhoneWindowManager r0) {
        return r0.mShouldEarlyShortPressOnPower;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSingleKeyGestureDetector, reason: not valid java name */
    static /* bridge */ /* synthetic */ SingleKeyGestureDetector m7197$$Nest$fgetmSingleKeyGestureDetector(PhoneWindowManager r0) {
        return r0.mSingleKeyGestureDetector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSmtEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ PhoneWindowManagerSmtEx m7198$$Nest$fgetmSmtEx(PhoneWindowManager r0) {
        return r0.mSmtEx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportLongPressPowerWhenNonInteractive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7199$$Nest$fgetmSupportLongPressPowerWhenNonInteractive(PhoneWindowManager r0) {
        return r0.mSupportLongPressPowerWhenNonInteractive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTriplePressOnStemPrimaryBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7200$$Nest$fgetmTriplePressOnStemPrimaryBehavior(PhoneWindowManager r0) {
        return r0.mTriplePressOnStemPrimaryBehavior;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowWakeUpPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowWakeUpPolicy m7201$$Nest$fgetmWindowWakeUpPolicy(PhoneWindowManager r0) {
        return r0.mWindowWakeUpPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBackgroundRecentTaskInfoOnStemPrimarySingleKeyUp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7202$$Nest$fputmBackgroundRecentTaskInfoOnStemPrimarySingleKeyUp(PhoneWindowManager r0, ActivityManager.RecentTaskInfo r1) {
        r0.mBackgroundRecentTaskInfoOnStemPrimarySingleKeyUp = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFocusedTaskInfoOnStemPrimarySingleKeyUp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7203$$Nest$fputmFocusedTaskInfoOnStemPrimarySingleKeyUp(PhoneWindowManager r0, ActivityTaskManager.RootTaskInfo r1) {
        r0.mFocusedTaskInfoOnStemPrimarySingleKeyUp = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLockAfterDreamingTransitionFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7204$$Nest$fputmLockAfterDreamingTransitionFinished(PhoneWindowManager r0, boolean r1) {
        r0.mLockAfterDreamingTransitionFinished = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLockNowPending, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7205$$Nest$fputmLockNowPending(PhoneWindowManager r0, boolean r1) {
        r0.mLockNowPending = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maccessibilityShortcutActivated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7206$$Nest$maccessibilityShortcutActivated(PhoneWindowManager r0) {
        r0.accessibilityShortcutActivated();
    }

    /* JADX INFO: renamed from: -$$Nest$mbackKeyPress, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7207$$Nest$mbackKeyPress(PhoneWindowManager r0) {
        return r0.backKeyPress();
    }

    /* JADX INFO: renamed from: -$$Nest$mbackLongPress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7208$$Nest$mbackLongPress(PhoneWindowManager r0) {
        r0.backLongPress();
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelAccessibilityGestureTv, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7209$$Nest$mcancelAccessibilityGestureTv(PhoneWindowManager r0) {
        r0.cancelAccessibilityGestureTv();
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelBugreportGestureTv, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7210$$Nest$mcancelBugreportGestureTv(PhoneWindowManager r0) {
        r0.cancelBugreportGestureTv();
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelPendingAccessibilityShortcutAction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7211$$Nest$mcancelPendingAccessibilityShortcutAction(PhoneWindowManager r0) {
        r0.cancelPendingAccessibilityShortcutAction();
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelPendingScreenshotChordAction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7212$$Nest$mcancelPendingScreenshotChordAction(PhoneWindowManager r0) {
        r0.cancelPendingScreenshotChordAction();
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelPreloadRecentApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7213$$Nest$mcancelPreloadRecentApps(PhoneWindowManager r0) {
        r0.cancelPreloadRecentApps();
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishKeyguardDrawn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7214$$Nest$mfinishKeyguardDrawn(PhoneWindowManager r0) {
        r0.finishKeyguardDrawn();
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishWindowsDrawn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7215$$Nest$mfinishWindowsDrawn(PhoneWindowManager r0, int r1) {
        r0.finishWindowsDrawn(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDreamManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ DreamManagerInternal m7216$$Nest$mgetDreamManagerInternal(PhoneWindowManager r0) {
        return r0.getDreamManagerInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMaxMultiPressPowerCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7217$$Nest$mgetMaxMultiPressPowerCount(PhoneWindowManager r0) {
        return r0.getMaxMultiPressPowerCount();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMaxMultiPressStemPrimaryCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7218$$Nest$mgetMaxMultiPressStemPrimaryCount(PhoneWindowManager r0) {
        return r0.getMaxMultiPressStemPrimaryCount();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetResolvedLongPressOnPowerBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7219$$Nest$mgetResolvedLongPressOnPowerBehavior(PhoneWindowManager r0) {
        return r0.getResolvedLongPressOnPowerBehavior();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetScreenshotChordLongPressDelay, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7220$$Nest$mgetScreenshotChordLongPressDelay(PhoneWindowManager r2) {
        return r2.getScreenshotChordLongPressDelay();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleHideBootMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7221$$Nest$mhandleHideBootMessage(PhoneWindowManager r0) {
        r0.handleHideBootMessage();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleKeyGestureInKeyGestureController, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7222$$Nest$mhandleKeyGestureInKeyGestureController(PhoneWindowManager r0, int r1, int r2, int r3, int r4) {
        r0.handleKeyGestureInKeyGestureController(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRingerChordGesture, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7223$$Nest$mhandleRingerChordGesture(PhoneWindowManager r0) {
        r0.handleRingerChordGesture();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScreenShot, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7224$$Nest$mhandleScreenShot(PhoneWindowManager r0, int r1) {
        r0.handleScreenShot(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleShortPressOnHome, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7225$$Nest$mhandleShortPressOnHome(PhoneWindowManager r0, int r1) {
        r0.handleShortPressOnHome(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSwitchKeyboardLayout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7226$$Nest$mhandleSwitchKeyboardLayout(PhoneWindowManager r0, int r1, int r2, IBinder r3) {
        r0.handleSwitchKeyboardLayout(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleTransitionForKeyguardLw, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7227$$Nest$mhandleTransitionForKeyguardLw(PhoneWindowManager r0, boolean r1, boolean r2) {
        return r0.handleTransitionForKeyguardLw(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasLongPressOnBackBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7228$$Nest$mhasLongPressOnBackBehavior(PhoneWindowManager r0) {
        return r0.hasLongPressOnBackBehavior();
    }

    /* JADX INFO: renamed from: -$$Nest$mhasLongPressOnPowerBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7229$$Nest$mhasLongPressOnPowerBehavior(PhoneWindowManager r0) {
        return r0.hasLongPressOnPowerBehavior();
    }

    /* JADX INFO: renamed from: -$$Nest$mhasLongPressOnStemPrimaryBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7230$$Nest$mhasLongPressOnStemPrimaryBehavior(PhoneWindowManager r0) {
        return r0.hasLongPressOnStemPrimaryBehavior();
    }

    /* JADX INFO: renamed from: -$$Nest$mhasVeryLongPressOnPowerBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7231$$Nest$mhasVeryLongPressOnPowerBehavior(PhoneWindowManager r0) {
        return r0.hasVeryLongPressOnPowerBehavior();
    }

    /* JADX INFO: renamed from: -$$Nest$minterceptAccessibilityGestureTv, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7232$$Nest$minterceptAccessibilityGestureTv(PhoneWindowManager r0) {
        r0.interceptAccessibilityGestureTv();
    }

    /* JADX INFO: renamed from: -$$Nest$minterceptAccessibilityShortcutChord, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7233$$Nest$minterceptAccessibilityShortcutChord(PhoneWindowManager r0) {
        r0.interceptAccessibilityShortcutChord();
    }

    /* JADX INFO: renamed from: -$$Nest$minterceptBugreportGestureTv, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7234$$Nest$minterceptBugreportGestureTv(PhoneWindowManager r0) {
        r0.interceptBugreportGestureTv();
    }

    /* JADX INFO: renamed from: -$$Nest$minterceptScreenshotChord, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7235$$Nest$minterceptScreenshotChord(PhoneWindowManager r0, int r1, long r2) {
        r0.interceptScreenshotChord(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misKeyEventForCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7236$$Nest$misKeyEventForCurrentUser(PhoneWindowManager r0, int r1, int r2, String r3) {
        return r0.isKeyEventForCurrentUser(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mlaunchAllAppsAction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7237$$Nest$mlaunchAllAppsAction(PhoneWindowManager r0) {
        r0.launchAllAppsAction();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyKeyGestureCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7238$$Nest$mnotifyKeyGestureCompleted(PhoneWindowManager r0, KeyEvent r1, int r2) {
        r0.notifyKeyGestureCompleted(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monAiKeyPress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7239$$Nest$monAiKeyPress(PhoneWindowManager r0, long r1, boolean r3, int r4) {
        r0.onAiKeyPress(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mpowerLongPress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7240$$Nest$mpowerLongPress(PhoneWindowManager r0, long r1) {
        r0.powerLongPress(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpowerVeryLongPress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7241$$Nest$mpowerVeryLongPress(PhoneWindowManager r0) {
        r0.powerVeryLongPress();
    }

    /* JADX INFO: renamed from: -$$Nest$mpreloadRecentApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7242$$Nest$mpreloadRecentApps(PhoneWindowManager r0) {
        r0.preloadRecentApps();
    }

    /* JADX INFO: renamed from: -$$Nest$msendSystemKeyToStatusBar, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7243$$Nest$msendSystemKeyToStatusBar(PhoneWindowManager r0, KeyEvent r1) {
        r0.sendSystemKeyToStatusBar(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldEnableWakeGestureLp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7244$$Nest$mshouldEnableWakeGestureLp(PhoneWindowManager r0) {
        return r0.shouldEnableWakeGestureLp();
    }

    /* JADX INFO: renamed from: -$$Nest$mshowPictureInPictureMenuInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7245$$Nest$mshowPictureInPictureMenuInternal(PhoneWindowManager r0) {
        r0.showPictureInPictureMenuInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mshowRecentApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7246$$Nest$mshowRecentApps(PhoneWindowManager r0, boolean r1) {
        r0.showRecentApps(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstemPrimaryLongPress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7247$$Nest$mstemPrimaryLongPress(PhoneWindowManager r0, long r1) {
        r0.stemPrimaryLongPress(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstemPrimaryPress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7248$$Nest$mstemPrimaryPress(PhoneWindowManager r0, int r1) {
        r0.stemPrimaryPress(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtoggleNotificationPanel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7249$$Nest$mtoggleNotificationPanel(PhoneWindowManager r0) {
        r0.toggleNotificationPanel();
    }

    /* JADX INFO: renamed from: -$$Nest$mtoggleRecentApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7250$$Nest$mtoggleRecentApps(PhoneWindowManager r0) {
        r0.toggleRecentApps();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7251$$Nest$mupdateSettings(PhoneWindowManager r0) {
        r0.updateSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetWINDOW_TYPES_WHERE_HOME_DOESNT_WORK, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m7252$$Nest$sfgetWINDOW_TYPES_WHERE_HOME_DOESNT_WORK() {
        return WINDOW_TYPES_WHERE_HOME_DOESNT_WORK;
    }

    public PhoneWindowManager() {
        this.mLock = new Object();
        this.mScreenOnListeners = new SparseArray();
        this.mServiceAcquireLock = new Object();
        this.mEnableBugReportKeyboardShortcut = false;
        this.mEnableCarDockHomeCapture = true;
        this.mKeyguardDrawnCallback = new AnonymousClass1(this);
        this.mNavBarVirtualKeyHapticFeedbackEnabled = true;
        this.mPendingWakeKey = -1;
        this.mGameKeysCtrl = null;
        this.mCameraLensCoverState = -1;
        this.mStylusButtonsEnabled = true;
        this.mHasSoftInput = false;
        this.mAllowLockscreenWhenOnDisplays = new HashSet();
        this.mRingerToggleChord = 0;
        this.mConsumedKeysForDevice = new SparseArray();
        this.mLogDecelerateInterpolator = new LogDecelerateInterpolator(100, 0);
        this.mDeferredKeyActionExecutor = new DeferredKeyActionExecutor();
        this.mTopFocusedDisplayId = -1;
        this.mPowerButtonSuppressionDelayMillis = 800;
        this.mLockNowPending = false;
        this.mKeyguardDrawnTimeout = 1000;
        this.mVisibleBackgroundUsersEnabled = UserManager.isVisibleBackgroundUsersEnabled();
        this.mHDMIObserver = new AnonymousClass2(this);
        this.mHDMISwitchObserver = new AnonymousClass3(this);
        this.mExtEventObserver = new AnonymousClass4(this);
        this.mPersistentVrModeListener = new AnonymousClass5(this);
        this.mObricExt = (IObricPhoneWindowManager) ObricImplFactory.getImpl(IObricPhoneWindowManager.class, new Object[]{this});
        this.mEndCallLongPress = new AnonymousClass6(this);
        this.mDisplayHomeButtonHandlers = new SparseArray();
        this.mDockReceiver = new AnonymousClass17(this);
        this.mMultiuserReceiver = new AnonymousClass18(this);
        this.mBootMsgDialog = null;
        this.mScreenLockTimeout = new ScreenLockTimeout(this);
        this.mExt = (IExtPhoneWindowManager) ExtImplFactory.getImpl(IExtPhoneWindowManager.class, new Object[]{this});
        this.mSmtEx = new PhoneWindowManagerSmtEx(this, this.mHandler);
    }

    static {
        POWER_MULTI_PRESS_TIMEOUT_MILLIS = ViewConfiguration.getMultiPressTimeout();
        powerKeyDown = false;
        lastLogCaptureTime = 0;
        forcePoweroffHandler = null;
        forcePoweroffRunnable = null;
        UPLOAD_LOCK = new Object();
        WINDOW_TYPES_WHERE_HOME_DOESNT_WORK = new int[]{2003, 2010};
        FACTORY_TEST_KEY_ACTIVITYS = new String[]{FACTORY_TEST_KEY_ACTIVITY, "com.zte.zftdoctor.testitem.KeyTest"};
    }

    private void handleRingerChordGesture() {
        if (this.mRingerToggleChord != 0) goto L5;
        return;
    L5:
        getAudioManagerInternal();
        this.mAudioManagerInternal.silenceRingerModeInternal("volume_hush");
        Settings.Secure.putInt(this.mContext.getContentResolver(), "hush_gesture_used", 1);
        this.mLogger.action(1440, this.mRingerToggleChord);
    }

    IStatusBarService getStatusBarService() {
        Object r0 = this.mServiceAcquireLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mStatusBarService != null) goto L9;
        this.mStatusBarService = IStatusBarService.Stub.asInterface(ServiceManager.getService("statusbar"));     // Catch: Throwable -> L7
    L9:
        IStatusBarService r1 = this.mStatusBarService;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    StatusBarManagerInternal getStatusBarManagerInternal() {
        Object r0 = this.mServiceAcquireLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mStatusBarManagerInternal != null) goto L9;
        this.mStatusBarManagerInternal = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Throwable -> L7
    L9:
        StatusBarManagerInternal r1 = this.mStatusBarManagerInternal;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    AudioManagerInternal getAudioManagerInternal() {
        Object r0 = this.mServiceAcquireLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioManagerInternal != null) goto L9;
        this.mAudioManagerInternal = (AudioManagerInternal) LocalServices.getService(AudioManagerInternal.class);     // Catch: Throwable -> L7
    L9:
        AudioManagerInternal r1 = this.mAudioManagerInternal;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    AccessibilityManagerInternal getAccessibilityManagerInternal() {
        Object r0 = this.mServiceAcquireLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAccessibilityManagerInternal != null) goto L9;
        this.mAccessibilityManagerInternal = (AccessibilityManagerInternal) LocalServices.getService(AccessibilityManagerInternal.class);     // Catch: Throwable -> L7
    L9:
        AccessibilityManagerInternal r1 = this.mAccessibilityManagerInternal;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    private boolean backKeyPress() {
        this.mLogger.count("key_back_press", 1);
        boolean handled = this.mBackKeyHandled;
        if (this.mHasFeatureWatch == false) goto L17;
        TelecomManager telecomManager = getTelecommService();
        if (telecomManager == null) goto L17;
        if (telecomManager.isRinging() == false) goto L11;
        telecomManager.silenceRinger();
        return false;
    L11:
        if ((1 & this.mIncallBackBehavior) == 0) goto L17;
        if (telecomManager.isInCall() == false) goto L17;
        return telecomManager.endCall();
    L17:
        if (this.mAutofillManagerInternal == null) goto L19;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(20));
    L19:
        return handled;
    }

    private void interceptPowerKeyDown(KeyEvent event, boolean interactive, boolean isKeyGestureTriggered) {
        if (this.mPowerKeyWakeLock.isHeld() == true) goto L5;
        this.mPowerKeyWakeLock.acquire();
    L5:
        this.mWindowManagerFuncs.onPowerKeyDown(interactive);
        TelecomManager telecomManager = getTelecommService();
        boolean hungUp = false;
        boolean r2 = false;
        this.mPowerKeyConsumedByInCall = false;
        if (telecomManager != null) goto L8;
    L16:
        boolean handledByPowerManager = this.mPowerManagerInternal.interceptPowerKeyDown(event);
        sendSystemKeyToStatusBarAsync(event);
        if (this.mPowerKeyHandled == true) goto L23;
        if (hungUp == true) goto L23;
        if (handledByPowerManager == true) goto L23;
        if (isKeyGestureTriggered == true) goto L23;
        if (this.mKeyCombinationManager.isPowerKeyIntercepted() == true) goto L23;
    L24:
        this.mPowerKeyHandled = r2;
        if (this.mZswExt.interceptPowerKeyDown(event) == false) goto L29;
        this.mPowerKeyHandled = true;
        return;
    L29:
        if (this.mPowerKeyHandled == true) goto L33;
        if (interactive == true) goto L36;
        wakeUpFromWakeKey(event);
        return;
    L36:
        return;
    L33:
        if (this.mSingleKeyGestureDetector.isKeyIntercepted(26) == false) goto L38;
        Slog.d(TAG, "Skip power key gesture for other policy has handled it.");
        this.mSingleKeyGestureDetector.reset();
        return;
    L38:
        return;
    L23:
        r2 = true;
        goto L24
    L8:
        if (telecomManager.isRingerRinging() == false) goto L11;
        this.mPowerKeyConsumedByInCall = true;
        telecomManager.silenceRinger();
        goto L16
    L11:
        if ((this.mIncallPowerBehavior & 2) == 0) goto L16;
        if (telecomManager.isInCall() == false) goto L16;
        if (interactive == false) goto L16;
        hungUp = telecomManager.endCall();
        goto L16
    }

    private void interceptPowerKeyUp(KeyEvent event, boolean canceled) {
        if (this.mZswExt.interceptPowerKeyUp() == false) goto L6;
        finishPowerKeyPress();
        return;
    L6:
        sendSystemKeyToStatusBarAsync(event);
        finishPowerKeyPress();
    }

    private void finishPowerKeyPress() {
        this.mPowerKeyHandled = false;
        if (this.mPowerKeyWakeLock.isHeld() == false) goto L6;
        this.mPowerKeyWakeLock.release();
        return;
    }

    void powerPress(final long eventTime, int count, int displayId) {
        if (this.mZswExt.interceptPowerPress() == false) goto L6;
        return;
    L6:
        if (count != 1) goto L9;
        this.mSideFpsEventHandler.notifyPowerPressed();
    L9:
        if (this.mDefaultDisplayPolicy.isScreenOnEarly() == true) goto L11;
    L14:
        boolean interactive = this.mDefaultDisplayPolicy.isAwake();
        Slog.d(TAG, "powerPress: eventTime=" + eventTime + " interactive=" + interactive + " count=" + count + " mShortPressOnPowerBehavior=" + this.mShortPressOnPowerBehavior);
        if (count != 2) goto L18;
        powerMultiPressAction(eventTime, interactive, this.mDoublePressOnPowerBehavior);
        return;
    L18:
        if (count != 3) goto L20;
        powerMultiPressAction(eventTime, interactive, this.mTriplePressOnPowerBehavior);
        return;
    L20:
        if (count > 3) goto L22;
    L24:
        if (count == 1) goto L26;
        return;
    L26:
        if (shouldHandleShortPressPowerAction(interactive, eventTime) == true) goto L28;
        return;
    L28:
        switch(this.mShortPressOnPowerBehavior) {
            case 0: goto L94;
            case 1: goto L73;
            case 2: goto L72;
            case 3: goto L70;
            case 4: goto L68;
            case 5: goto L65;
            case 6: goto L54;
            case 7: goto L52;
            case 8: goto L32;
            case 9: goto L30;
            default: goto L94;
        };
    L30:
        attemptToDreamOrAwakeFromShortPowerButtonPress(true, true, new PhoneWindowManager$$ExternalSyntheticLambda2(this, eventTime));
        return;
    L52:
        attemptToDreamOrAwakeFromShortPowerButtonPress(true, false, new PhoneWindowManager$$ExternalSyntheticLambda0(this, eventTime));
        return;
    L68:
        shortPressPowerGoHome();
        return;
    L72:
        sleepDefaultDisplayFromPowerButton(eventTime, 1);
        return;
    L73:
        sleepDefaultDisplayFromPowerButton(eventTime, 0);
        return;
    L94:
        return;
    L32:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "glanceable_hub_enabled", 1, this.mCurrentUserId) != 1) goto L34;
        boolean hubEnabled = true;
    L35:
        DreamManagerInternal dreamManagerInternal = getDreamManagerInternal();
        if (dreamManagerInternal != null) goto L39;
        return;
    L39:
        if (dreamManagerInternal.isDreaming() == false) goto L41;
    L51:
        sleepDefaultDisplayFromPowerButton(eventTime, 0);
        return;
    L41:
        if (isKeyguardShowing() == true) goto L51;
        boolean keyguardAvailable = !this.mLockPatternUtils.isLockScreenDisabled(this.mCurrentUserId);
        if (this.mUserManagerInternal.isUserUnlocked(this.mCurrentUserId) == false) goto L50;
        if (hubEnabled == false) goto L50;
        if (keyguardAvailable == false) goto L50;
        if (dreamManagerInternal.dreamConditionActive() == false) goto L50;
        Bundle options = new Bundle();
        options.putBoolean(EXTRA_TRIGGER_HUB, true);
        lockNow(options);
        return;
    L50:
        attemptToDreamOrAwakeFromShortPowerButtonPress(true, false, new PhoneWindowManager$$ExternalSyntheticLambda1(this, eventTime));
        return;
    L34:
        hubEnabled = false;
        goto L35
    L54:
        if (this.mKeyguardDelegate != null) goto L56;
    L63:
        sleepDefaultDisplayFromPowerButton(eventTime, 0);
        return;
    L56:
        if (this.mKeyguardDelegate.hasKeyguard() == false) goto L63;
        if (this.mKeyguardDelegate.isSecure(this.mCurrentUserId) == false) goto L63;
        if (keyguardOn() == true) goto L63;
        lockNow(null);
        return;
    L65:
        if (this.mDismissImeOnBackKeyPressed == false) goto L67;
        InputMethodManagerInternal.get().hideInputMethod(17, displayId);
        return;
    L67:
        shortPressPowerGoHome();
        return;
    L70:
        if (sleepDefaultDisplayFromPowerButton(eventTime, 1) == false) goto L90;
        launchHomeFromHotKey(0);
        return;
    L90:
        return;
    L22:
        if (count > getMaxMultiPressPowerCount()) goto L24;
        Slog.d(TAG, "No behavior defined for power press count " + count);
        return;
    L11:
        if (this.mDefaultDisplayPolicy.isScreenOnFully() == true) goto L14;
        Slog.i(TAG, "Suppressed redundant power key press while already in the process of turning the screen on.");
    }

    private /* synthetic */ void lambda$powerPress$0(long eventTime) {
        sleepDefaultDisplayFromPowerButton(eventTime, 0);
    }

    private /* synthetic */ void lambda$powerPress$1(long eventTime) {
        sleepDefaultDisplayFromPowerButton(eventTime, 0);
    }

    private /* synthetic */ void lambda$powerPress$2(long eventTime) {
        sleepDefaultDisplayFromPowerButton(eventTime, 0);
    }

    private boolean shouldHandleShortPressPowerAction(boolean interactive, long eventTime) {
        if (this.mSupportShortPressPowerWhenDefaultDisplayOn == false) goto L11;
        boolean defaultDisplayOn = Display.isOnState(this.mDefaultDisplay.getState());
        boolean beganFromDefaultDisplayOn = this.mSingleKeyGestureDetector.beganFromDefaultDisplayOn();
        if (defaultDisplayOn == false) goto L9;
        if (beganFromDefaultDisplayOn == false) goto L9;
        return true;
    L9:
        Slog.v(TAG, "Ignoring short press of power button because the default display is not on. defaultDisplayOn=" + defaultDisplayOn + ", beganFromDefaultDisplayOn=" + beganFromDefaultDisplayOn);
        return false;
    L11:
        boolean beganFromNonInteractive = this.mSingleKeyGestureDetector.beganFromNonInteractive();
        if (interactive == false) goto L20;
        if (beganFromNonInteractive == true) goto L20;
        if (this.mSideFpsEventHandler.shouldConsumeSinglePress(eventTime) == false) goto L19;
        Slog.i(TAG, "Suppressing power key because the user is interacting with the fingerprint sensor");
        return false;
    L19:
        return true;
    L20:
        Slog.v(TAG, "Ignoring short press of power button because the device is not interactive. interactive=" + interactive + ", beganFromNonInteractive=" + beganFromNonInteractive);
        return false;
    }

    private void attemptToDreamOrAwakeFromShortPowerButtonPress(boolean isScreenOn, boolean awakeWhenDream, Runnable noDreamAction) {
        if (this.mShortPressOnPowerBehavior != 7) goto L5;
    L10:
        DreamManagerInternal dreamManagerInternal = getDreamManagerInternal();
        if (dreamManagerInternal != null) goto L15;
        Slog.d(TAG, "Can't access dream manager dreaming when attempting to start or stop dream from short power press (isScreenOn=" + isScreenOn + ", awakeWhenDream=" + awakeWhenDream + ")");
        noDreamAction.run();
        return;
    L15:
        if (dreamManagerInternal.canStartDreaming(isScreenOn) == true) goto L23;
        if (awakeWhenDream == true) goto L18;
    L21:
        Slog.d(TAG, "Can't start dreaming and the device is not dreaming when attempting to start or stop dream from short power press (isScreenOn=" + isScreenOn + ", awakeWhenDream=" + awakeWhenDream + ")");
        noDreamAction.run();
        return;
    L18:
        if (dreamManagerInternal.isDreaming() == false) goto L21;
        dreamManagerInternal.stopDream(false, "short press power");
        return;
    L23:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mLockAfterDreamingTransitionFinished = this.mLockPatternUtils.getPowerButtonInstantlyLocks(this.mCurrentUserId);     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        dreamManagerInternal.requestDream();
        return;
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.mShortPressOnPowerBehavior == 8) goto L10;
        if (this.mShortPressOnPowerBehavior == 9) goto L10;
        noDreamAction.run();
    }

    private boolean sleepDefaultDisplayFromPowerButton(long eventTime, int flags) {
        PowerManager.WakeData lastWakeUp = this.mPowerManagerInternal.getLastWakeup();
        if (lastWakeUp == null) goto L17;
        if (lastWakeUp.wakeReason != 4) goto L7;
    L10:
        long now = SystemClock.uptimeMillis();
        if (this.mPowerButtonSuppressionDelayMillis <= 0) goto L17;
        if (now >= (lastWakeUp.wakeTime + ((long) this.mPowerButtonSuppressionDelayMillis))) goto L17;
        Slog.i(TAG, "Sleep from power button suppressed. Time since gesture: " + (now - lastWakeUp.wakeTime) + "ms");
        return false;
    L7:
        if (lastWakeUp.wakeReason == 16) goto L10;
        if (lastWakeUp.wakeReason == 17) goto L10;
    L17:
        if (this.mPowerKeyConsumedByInCall == false) goto L19;
        return false;
    L19:
        sleepDefaultDisplay(eventTime, 4, flags);
        return true;
    }

    private void sleepDefaultDisplay(long eventTime, int reason, int flags) {
        this.mRequestedOrSleepingDefaultDisplay = true;
        this.mPowerManager.goToSleep(eventTime, reason, flags);
    }

    private void shortPressPowerGoHome() {
        launchHomeFromHotKey(0, true, false);
        if (isKeyguardShowingAndNotOccluded() == false) goto L6;
        this.mKeyguardDelegate.onShortPowerPressedGoHome();
        return;
    }

    private void powerMultiPressAction(long eventTime, boolean interactive, int behavior) {
        switch(behavior) {
            case 0: goto L31;
            case 1: goto L11;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L31;
        };
    L5:
        launchTargetActivityOnMultiPressPower();
        return;
    L6:
        Slog.i(TAG, "Starting brightness boost.");
        if (interactive == true) goto L9;
        wakeUpFromWakeKey(eventTime, 26, false);
    L9:
        this.mPowerManager.boostScreenBrightness(eventTime);
        return;
    L31:
        return;
    L11:
        if (isUserSetupComplete() == true) goto L14;
        Slog.i(TAG, "Ignoring toggling theater mode - device not setup.");
        return;
    L14:
        if (isTheaterModeEnabled() == false) goto L18;
        Slog.i(TAG, "Toggling theater mode off.");
        Settings.Global.putInt(this.mContext.getContentResolver(), "theater_mode_on", 0);
        if (interactive == true) goto L26;
        wakeUpFromWakeKey(eventTime, 26, false);
        return;
    L26:
        return;
    L18:
        Slog.i(TAG, "Toggling theater mode on.");
        Settings.Global.putInt(this.mContext.getContentResolver(), "theater_mode_on", 1);
        if (this.mGoToSleepOnButtonPressTheaterMode == false) goto L28;
        if (interactive == false) goto L29;
        sleepDefaultDisplay(eventTime, 4, 0);
        return;
    L29:
        return;
    }

    private void launchTargetActivityOnMultiPressPower() {
        if (this.mPowerDoublePressTargetActivity == null) goto L19;
        Intent intent = new Intent();
        intent.setComponent(this.mPowerDoublePressTargetActivity);
        boolean keyguardActive = false;
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfo != null) goto L7;
        Slog.e(TAG, "Could not resolve activity with : " + this.mPowerDoublePressTargetActivity.flattenToString() + " name.");
        return;
    L7:
        if (this.mKeyguardDelegate != null) goto L9;
    L12:
        intent.addFlags(270532608);
        if (keyguardActive == true) goto L15;
        startActivityAsUser(intent, UserHandle.CURRENT_OR_SELF);
        return;
    L15:
        this.mKeyguardDelegate.dismissKeyguardToLaunch(intent);
        return;
    L9:
        if (this.mKeyguardDelegate.isShowing() == false) goto L12;
        keyguardActive = true;
        goto L12
    }

    private int getLidBehavior() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "lid_behavior", 0);
    }

    private int getMaxMultiPressPowerCount() {
        if (this.mHasFeatureWatch == false) goto L9;
        if (GestureLauncherService.isEmergencyGestureSettingEnabled(this.mContext, ActivityManager.getCurrentUser()) == false) goto L9;
        return 5;
    L9:
        if (this.mTriplePressOnPowerBehavior == 0) goto L13;
        return 3;
    L13:
        if (this.mDoublePressOnPowerBehavior != 0) goto L15;
        return 1;
    L15:
        if (this.mGestureLauncherService.getExt().isDoubleTapLaunchWalletEnableZTE(this.mContext) == false) goto L18;
        return 2;
    L18:
        return 1;
    }

    private void powerLongPress(long eventTime) {
        int behavior = getResolvedLongPressOnPowerBehavior();
        Slog.d(TAG, "powerLongPress: eventTime=" + eventTime + " mLongPressOnPowerBehavior=" + this.mLongPressOnPowerBehavior);
        boolean r3 = true;
        switch(behavior) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L21;
        };
    L5:
        this.mPowerKeyHandled = true;
        launchAssistAction(null, -2, eventTime, 6);
        return;
    L10:
        this.mPowerKeyHandled = true;
        if (ActivityManager.isUserAMonkey() == true) goto L27;
        performHapticFeedback(10003, "Power - Long Press - Shut Off");
        sendCloseSystemWindows(SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS);
        WindowManagerPolicy.WindowManagerFuncs r10 = this.mWindowManagerFuncs;
        if (behavior == 2) goto L17;
        r3 = false;
    L17:
        r10.shutdown(r3);
        return;
    L27:
        return;
    L18:
        this.mPowerKeyHandled = true;
        performHapticFeedback(10003, "Power - Long Press - Global Actions");
        showGlobalActions();
        return;
    L21:
        return;
    L7:
        if (this.mPowerManager.getSmtEx().isFeaturePhoneMode() == false) goto L9;
        Slog.d(TAG, "LONG_PRESS_POWER_GO_TO_VOICE_ASSIST:FeaturePhoneMode true");
        return;
    L9:
        this.mPowerKeyHandled = true;
        performHapticFeedback(10003, "Power - Long Press - Go To Voice Assist");
        launchVoiceAssist(this.mAllowStartActivityForLongPressOnPowerDuringSetup);
        return;
    }

    private void powerVeryLongPress() {
        switch(this.mVeryLongPressOnPowerBehavior) {
            case 0: goto L8;
            case 1: goto L5;
            default: goto L8;
        };
    L5:
        this.mPowerKeyHandled = true;
        VibratorSmt.vibrateEffectWithHapticPlayer(this.mVibrator, 2);
        showGlobalActions();
    L8:
        if (this.mLongPressOnPowerBehavior != 5) goto L11;
        launchAssistAction(null, -2, SystemClock.uptimeMillis(), -2);
        return;
    }

    private void backLongPress() {
        this.mBackKeyHandled = true;
        switch(this.mLongPressOnBackBehavior) {
            case 0: goto L8;
            case 1: goto L5;
            default: goto L8;
        };
    L5:
        launchVoiceAssist(false);
        return;
    }

    private void accessibilityShortcutActivated() {
        this.mAccessibilityShortcutController.performAccessibilityShortcut();
    }

    private void sleepPress() {
        if (this.mShortPressOnSleepBehavior != 1) goto L6;
        launchHomeFromHotKey(0, false, true);
        return;
    }

    private void sleepRelease(long eventTime) {
        if (this.mSilenceRingerOnSleepKey == false) goto L11;
        TelecomManager telecomManager = getTelecommService();
        if (telecomManager == null) goto L11;
        if (telecomManager.isRinging() == false) goto L11;
        telecomManager.silenceRinger();
        Slog.i(TAG, "sleepRelease() silence ringer");
        return;
    L11:
        switch(this.mShortPressOnSleepBehavior) {
            case 0: goto L13;
            case 1: goto L13;
            default: goto L15;
        };
    L13:
        Slog.i(TAG, "sleepRelease() calling goToSleep(GO_TO_SLEEP_REASON_SLEEP_BUTTON)");
        sleepDefaultDisplay(eventTime, 6, 0);
        return;
    }

    private int getResolvedLongPressOnPowerBehavior() {
        if (FactoryTest.isLongPressOnPowerOffEnabled() == false) goto L7;
        return 3;
    L7:
        if (this.mLongPressOnPowerBehavior != 5) goto L12;
        if (isDeviceProvisioned() == true) goto L12;
        return 0;
    L12:
        if (this.mLongPressOnPowerBehavior != 4) goto L17;
        if (isLongPressToAssistantEnabled(this.mContext) == true) goto L17;
        return 0;
    L17:
        return this.mLongPressOnPowerBehavior;
    }

    private void stemPrimaryPress(int count) {
        Slog.d(TAG, "stemPrimaryPress: " + count);
        if (count != 3) goto L6;
        stemPrimaryTriplePressAction(this.mTriplePressOnStemPrimaryBehavior);
        return;
    L6:
        if (count != 2) goto L9;
        stemPrimaryDoublePressAction(this.mDoublePressOnStemPrimaryBehavior);
        return;
    L9:
        if (count != 1) goto L14;
        stemPrimarySinglePressAction(this.mShortPressOnStemPrimaryBehavior);
        return;
    }

    private void stemPrimarySinglePressAction(int behavior) {
        Slog.d(TAG, "stemPrimarySinglePressAction: behavior=" + behavior);
        if (behavior != 0) goto L6;
        return;
    L6:
        if (this.mKeyguardDelegate != null) goto L8;
    L10:
        boolean keyguardActive = false;
    L11:
        if (keyguardActive == false) goto L14;
        this.mKeyguardDelegate.onSystemKeyPressed(264);
        Slog.d(TAG, "stemPrimarySinglePressAction: skip due to keyguard");
        return;
    L14:
        switch(behavior) {
            case 1: goto L24;
            case 2: goto L17;
            default: goto L27;
        };
    L24:
        Intent allAppsIntent = new Intent("android.intent.action.ALL_APPS");
        allAppsIntent.addFlags(270532608);
        startActivityAsUser(allAppsIntent, UserHandle.CURRENT_OR_SELF);
        return;
    L27:
        return;
    L17:
        if (this.mPrimaryShortPressTargetActivity == null) goto L23;
        Intent targetActivityIntent = new Intent();
        targetActivityIntent.setComponent(this.mPrimaryShortPressTargetActivity);
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveActivity(targetActivityIntent, 0);
        if (resolveInfo == null) goto L21;
        targetActivityIntent.addFlags(270548992);
        startActivityAsUser(targetActivityIntent, UserHandle.CURRENT_OR_SELF);
        return;
    L21:
        Slog.wtf(TAG, "Could not resolve activity with : " + this.mPrimaryShortPressTargetActivity.flattenToString() + " name.");
        return;
    L23:
        Slog.wtf(TAG, "mPrimaryShortPressTargetActivity must not be null and correctly specified");
        return;
    L8:
        if (this.mKeyguardDelegate.isShowing() == false) goto L10;
        keyguardActive = true;
        goto L11
    }

    private void stemPrimaryDoublePressAction(int behavior) {
        Slog.d(TAG, "stemPrimaryDoublePressAction: " + behavior);
        boolean keyguardActive = false;
        switch(behavior) {
            case 0: goto L17;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L17;
        };
    L5:
        handleKeyGestureInKeyGestureController(50, -2, 264, 0);
        return;
    L17:
        return;
    L7:
        if (this.mKeyguardDelegate == null) goto L11;
        keyguardActive = this.mKeyguardDelegate.isShowing();
    L11:
        if (keyguardActive == true) goto L15;
        performStemPrimaryDoublePressSwitchToRecentTask();
        return;
    }

    private void stemPrimaryTriplePressAction(int behavior) {
        Slog.d(TAG, "stemPrimaryTriplePressAction: " + behavior);
        switch(behavior) {
            case 0: goto L11;
            case 1: goto L5;
            default: goto L11;
        };
    L5:
        this.mTalkbackShortcutController.toggleTalkback(this.mCurrentUserId, TalkbackShortcutController.ShortcutSource.GESTURE);
        if (this.mTalkbackShortcutController.isTalkBackShortcutGestureEnabled() == false) goto L9;
        performHapticFeedback(16, "Stem primary - Triple Press - Toggle Accessibility");
        return;
    L9:
        return;
    }

    private void stemPrimaryLongPress(long eventTime) {
        Slog.d(TAG, "stemPrimaryLongPress: " + this.mLongPressOnStemPrimaryBehavior);
        switch(this.mLongPressOnStemPrimaryBehavior) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L8;
        };
    L5:
        launchAssistAction(null, -2, eventTime, 0);
        return;
    L8:
        return;
    }

    void performStemPrimaryDoublePressSwitchToRecentTask() {
        ActivityManager.RecentTaskInfo targetTask = this.mBackgroundRecentTaskInfoOnStemPrimarySingleKeyUp;
        if (targetTask != null) goto L11;
        goHome();
        return;
    L11:
        this.mActivityManagerService.startActivityFromRecents(targetTask.persistentId, null);     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to start task " + targetTask.persistentId + " from recents", e);
    }

    private int getMaxMultiPressStemPrimaryCount() {
        switch(this.mTriplePressOnStemPrimaryBehavior) {
            case 0: goto L11;
            case 1: goto L6;
            default: goto L11;
        };
    L6:
        if (this.mTalkbackShortcutController.isTalkBackShortcutGestureEnabled() == false) goto L11;
        return 3;
    L11:
        if (this.mDoublePressOnStemPrimaryBehavior == 0) goto L14;
        return 2;
    L14:
        return 1;
    }

    private boolean hasLongPressOnPowerBehavior() {
        if (getResolvedLongPressOnPowerBehavior() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasVeryLongPressOnPowerBehavior() {
        if (this.mVeryLongPressOnPowerBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasLongPressOnBackBehavior() {
        if (this.mLongPressOnBackBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasLongPressOnStemPrimaryBehavior() {
        if (this.mLongPressOnStemPrimaryBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasStemPrimaryBehavior() {
        int defaultShortPressOnStemPrimaryBehavior = this.mContext.getResources().getInteger(R.integer.config_tapTimeoutMillis);
        int defaultLongPressOnStemPrimaryBehavior = this.mContext.getResources().getInteger(R.integer.config_maxUiWidth);
        if (getMaxMultiPressStemPrimaryCount() > 1) goto L9;
        if (defaultLongPressOnStemPrimaryBehavior != 0) goto L10;
        if (defaultShortPressOnStemPrimaryBehavior != 0) goto L11;
        return false;
    L11:
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    private void interceptScreenshotChord(int source, long pressDelay) {
        this.mHandler.removeMessages(16);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(16, source, 0), pressDelay);
    }

    private void interceptAccessibilityShortcutChord() {
        this.mHandler.removeMessages(17);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(17), getAccessibilityShortcutTimeout());
    }

    private void interceptRingerToggleChord() {
        this.mHandler.removeMessages(24);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(24), getRingerToggleChordDelay());
    }

    private long getAccessibilityShortcutTimeout() {
        ViewConfiguration config = ViewConfiguration.get(this.mContext);
        boolean skipTimeoutRestriction = false;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_shortcut_dialog_shown", 0, this.mCurrentUserId) == 0) goto L5;
        boolean hasDialogShown = true;
    L7:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "skip_accessibility_shortcut_dialog_timeout_restriction", 0, this.mCurrentUserId) == 0) goto L9;
        skipTimeoutRestriction = true;
    L9:
        if (hasDialogShown == true) goto L14;
        if (skipTimeoutRestriction == true) goto L14;
        return config.getAccessibilityShortcutKeyTimeout();
    L14:
        return config.getAccessibilityShortcutKeyTimeoutAfterConfirmation();
    L5:
        hasDialogShown = false;
        goto L7
    }

    private long getScreenshotChordLongPressDelay() {
        long delayMs = DeviceConfig.getLong("systemui", "screenshot_keychord_delay", ViewConfiguration.get(this.mContext).getScreenshotChordKeyTimeout());
        if (this.mKeyguardDelegate.isShowing() == true) goto L5;
        return delayMs;
    L5:
        return (long) (delayMs * KEYGUARD_SCREENSHOT_CHORD_DELAY_MULTIPLIER);
    }

    private long getRingerToggleChordDelay() {
        return ViewConfiguration.getTapTimeout();
    }

    private void cancelPendingScreenshotChordAction() {
        this.mHandler.removeMessages(16);
    }

    private void cancelPendingAccessibilityShortcutAction() {
        this.mHandler.removeMessages(17);
    }

    private void cancelPendingRingerToggleChordAction() {
        this.mHandler.removeMessages(24);
    }

    private void handleScreenShot(int source) {
        if (LostModeUtil.beingLostModeEnabled(this.mContext) == false) goto L6;
        return;
    L6:
        if (this.mPowerManager.getSmtEx().isFeaturePhoneMode() == false) goto L9;
        this.mHandler.sendEmptyMessage(31);
        return;
    L9:
        this.mDefaultDisplayPolicy.takeScreenshot(1, source);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void showGlobalActions() {
        this.mHandler.removeMessages(10);
        this.mHandler.sendEmptyMessage(10);
    }

    void showGlobalActionsInternal() {
        if (this.mGlobalActions != null) goto L5;
        this.mGlobalActions = this.mGlobalActionsFactory.get();
    L5:
        boolean keyguardShowing = isKeyguardShowingAndNotOccluded();
        this.mGlobalActions.showDialog(keyguardShowing, isDeviceProvisioned());
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), false);
    }

    private void cancelGlobalActionsAction() {
        this.mHandler.removeMessages(10);
    }

    boolean isDeviceProvisioned() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "device_provisioned", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isUserSetupComplete() {
        boolean isSetupComplete = false;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "user_setup_complete", 0, -2) == 0) goto L6;
        isSetupComplete = true;
    L6:
        if (this.mHasFeatureLeanback == false) goto L9;
        return isSetupComplete & isTvUserSetupComplete();
    L9:
        if (this.mHasFeatureAuto == true) goto L11;
        return isSetupComplete;
    L11:
        return isSetupComplete & isAutoUserSetupComplete();
    }

    private boolean isAutoUserSetupComplete() {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "android.car.SETUP_WIZARD_IN_PROGRESS", 0, -2) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isTvUserSetupComplete() {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "tv_user_setup_complete", 0, -2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void handleShortPressOnHome(int displayId) {
        HdmiControl hdmiControl = getHdmiControl();
        if (hdmiControl == null) goto L5;
        hdmiControl.turnOnTv();
    L5:
        DreamManagerInternal dreamManagerInternal = getDreamManagerInternal();
        if (dreamManagerInternal != null) goto L8;
    L11:
        launchHomeFromHotKey(displayId);
        return;
    L8:
        if (dreamManagerInternal.isDreaming() == false) goto L11;
        dreamManagerInternal.stopDream(false, "short press on home");
    }

    private HdmiControl getHdmiControl() {
        if (this.mHdmiControl != null) goto L12;
        PhoneWindowManagerIA r1 = null;
        if (this.mHasFeatureHdmiCec == true) goto L7;
        return null;
    L7:
        HdmiControlManager manager = (HdmiControlManager) this.mContext.getSystemService("hdmi_control");
        HdmiPlaybackClient client = null;
        if (manager == null) goto L10;
        client = manager.getPlaybackClient();
    L10:
        this.mHdmiControl = new HdmiControl(client, r1);
    L12:
        return this.mHdmiControl;
    }

    private void launchAllAppsAction() {
        if (this.mHasFeatureLeanback == false) goto L5;
    L10:
        Intent intent = new Intent("android.intent.action.ALL_APPS");
        if (this.mHasFeatureLeanback == false) goto L15;
        Intent intentLauncher = new Intent("android.intent.action.MAIN");
        intentLauncher.addCategory("android.intent.category.HOME");
        ResolveInfo resolveInfo = this.mPackageManager.resolveActivityAsUser(intentLauncher, 1048576, this.mCurrentUserId);
        if (resolveInfo == null) goto L15;
        intent.setPackage(resolveInfo.activityInfo.packageName);
    L15:
        startActivityAsUser(intent, UserHandle.CURRENT);
    L16:
        dismissKeyboardShortcutsMenu();
        return;
    L5:
        if (this.mHasFeatureWatch == true) goto L10;
        AccessibilityManagerInternal accessibilityManager = getAccessibilityManagerInternal();
        if (accessibilityManager == null) goto L16;
        accessibilityManager.performSystemAction(14);
        goto L16
    }

    private void toggleNotificationPanel() {
        IStatusBarService statusBarService = getStatusBarService();
        if (isUserSetupComplete() == false) goto L11;
        if (statusBarService == null) goto L12;
        statusBarService.togglePanel();     // Catch: RemoteException -> L7
        return;
    L8:
        return;
    L12:
        return;
    }

    private void showSystemSettings() {
        startActivityAsUser(new Intent("android.settings.SETTINGS"), UserHandle.CURRENT_OR_SELF);
    }

    private void showPictureInPictureMenu(KeyEvent event) {
        this.mHandler.removeMessages(15);
        Message msg = this.mHandler.obtainMessage(15);
        msg.setAsynchronous(true);
        msg.sendToTarget();
    }

    private void showPictureInPictureMenuInternal() {
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.showPictureInPictureMenu();
        return;
    }

    private boolean isRoundWindow() {
        return this.mContext.getResources().getConfiguration().isScreenRound();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setDefaultDisplay(WindowManagerPolicy.DisplayContentInfo displayContentInfo) {
        this.mDefaultDisplay = displayContentInfo.getDisplay();
        this.mDefaultDisplayRotation = displayContentInfo.getDisplayRotation();
        this.mDefaultDisplayPolicy = this.mDefaultDisplayRotation.getDisplayPolicy();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void init(Context context, WindowManagerPolicy.WindowManagerFuncs funcs) {
        init(new Injector(context, funcs));
    }

    void init(Injector injector) {
        this.mContext = injector.getContext();
        this.mWindowManagerFuncs = injector.getWindowManagerFuncs();
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mActivityManagerService = injector.getActivityManagerService();
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mInputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);
        this.mDreamManagerInternal = (DreamManagerInternal) LocalServices.getService(DreamManagerInternal.class);
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mSensorPrivacyManager = (SensorPrivacyManager) this.mContext.getSystemService(SensorPrivacyManager.class);
        this.mDisplayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mPackageManager = this.mContext.getPackageManager();
        this.mHasFeatureWatch = this.mPackageManager.hasSystemFeature("android.hardware.type.watch");
        this.mHasFeatureLeanback = this.mPackageManager.hasSystemFeature("android.software.leanback");
        this.mHasFeatureAuto = this.mPackageManager.hasSystemFeature("android.hardware.type.automotive");
        this.mHasFeatureHdmiCec = this.mPackageManager.hasSystemFeature("android.hardware.hdmi.cec");
        this.mAccessibilityShortcutController = injector.getAccessibilityShortcutController(this.mContext, new Handler(), this.mCurrentUserId);
        this.mGlobalActionsFactory = injector.getGlobalActionsFactory();
        this.mLockPatternUtils = injector.getLockPatternUtils();
        this.mLogger = new MetricsLogger();
        Resources res = this.mContext.getResources();
        this.mWakeOnDpadKeyPress = res.getBoolean(R.bool.config_windowOverscanByDefault);
        this.mWakeOnAssistKeyPress = res.getBoolean(R.bool.config_windowManagerPauseRotationWhenUnfolding);
        this.mWakeOnBackKeyPress = res.getBoolean(R.bool.config_windowNoTitleDefault);
        boolean burnInProtectionEnabled = this.mContext.getResources().getBoolean(R.bool.config_enableCrossTaskScaleUpAnimation);
        final int r5 = 0;
        boolean burnInProtectionDevMode = SystemProperties.getBoolean("persist.debug.force_burn_in", false);
        if (burnInProtectionEnabled == true) goto L5;
        if (burnInProtectionDevMode == true) goto L5;
    L13:
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswPhoneWindowManager(this);
        this.mHandler = new PolicyHandler(this, injector.getLooper(), null);
        this.mWakeGestureListener = new MyWakeGestureListener(this, this.mContext, this.mHandler);
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        getExt().init(this.mContext, this.mHandler);
        this.mSmtEx = new PhoneWindowManagerSmtEx(this, this.mHandler);
        getISmtEx().init(this.mContext);
        this.mZswExt.init(this.mContext);
        this.mSettingsObserver.observe();
        this.mModifierShortcutManager = new ModifierShortcutManager(this.mContext, this.mHandler, UserHandle.of(this.mCurrentUserId));
        this.mUiMode = this.mContext.getResources().getInteger(R.integer.config_displayWhiteBalanceBrightnessFilterHorizon);
        this.mHomeIntent = new Intent("android.intent.action.MAIN", null);
        this.mHomeIntent.addCategory("android.intent.category.HOME");
        this.mHomeIntent.addFlags(270532608);
        this.mEnableCarDockHomeCapture = this.mContext.getResources().getBoolean(R.bool.config_enableDefaultHdrConversionPassthrough);
        this.mCarDockIntent = new Intent("android.intent.action.MAIN", null);
        this.mCarDockIntent.addCategory("android.intent.category.CAR_DOCK");
        this.mCarDockIntent.addFlags(270532608);
        this.mDeskDockIntent = new Intent("android.intent.action.MAIN", null);
        this.mDeskDockIntent.addCategory("android.intent.category.DESK_DOCK");
        this.mDeskDockIntent.addFlags(270532608);
        this.mVrHeadsetHomeIntent = new Intent("android.intent.action.MAIN", null);
        this.mVrHeadsetHomeIntent.addCategory("android.intent.category.VR_HOME");
        this.mVrHeadsetHomeIntent.addFlags(270532608);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        boolean r8 = true;
        this.mBroadcastWakeLock = this.mPowerManager.newWakeLock(1, "PhoneWindowManager.mBroadcastWakeLock");
        this.mPowerKeyWakeLock = this.mPowerManager.newWakeLock(1, "PhoneWindowManager.mPowerKeyWakeLock");
        this.mEnableBugReportKeyboardShortcut = "1".equals(SystemProperties.get("ro.debuggable"));
        this.mLidKeyboardAccessibility = this.mContext.getResources().getInteger(R.integer.config_lowMemoryKillerMinFreeKbytesAbsolute);
        this.mLidNavigationAccessibility = this.mContext.getResources().getInteger(R.integer.config_lowMemoryKillerMinFreeKbytesAdjust);
        this.mGoToSleepOnButtonPressTheaterMode = this.mContext.getResources().getBoolean(R.bool.config_hasRecents);
        this.mSupportLongPressPowerWhenNonInteractive = this.mContext.getResources().getBoolean(R.bool.config_supportsConcurrentInternalDisplays);
        this.mSupportShortPressPowerWhenDefaultDisplayOn = this.mContext.getResources().getBoolean(R.bool.config_supportsMicToggle);
        this.mLongPressOnBackBehavior = this.mContext.getResources().getInteger(R.integer.config_maxNumVisibleRecentTasks_lowRam);
        this.mLongPressOnPowerBehavior = this.mContext.getResources().getInteger(R.integer.config_maxScanTasksForHomeVisibility);
        this.mLongPressOnPowerAssistantTimeoutMs = this.mContext.getResources().getInteger(R.integer.config_maxShortcutTargetsPerApp);
        this.mVeryLongPressOnPowerBehavior = this.mContext.getResources().getInteger(R.integer.config_zen_repeat_callers_threshold);
        this.mPowerDoublePressTargetActivity = ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.config_mt_sms_polling_text));
        this.mPrimaryShortPressTargetActivity = ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.config_wearMediaSessionsPackage));
        this.mShortPressOnSleepBehavior = this.mContext.getResources().getInteger(R.integer.config_supportsNonResizableMultiWindow);
        this.mSilenceRingerOnSleepKey = this.mContext.getResources().getBoolean(R.bool.config_smppsim_response_via_ims);
        this.mAllowStartActivityForLongPressOnPowerDuringSetup = this.mContext.getResources().getBoolean(R.bool.config_allowStartActivityForLongPressOnPowerInSetup);
        this.mShortPressOnStemPrimaryBehavior = this.mContext.getResources().getInteger(R.integer.config_tapTimeoutMillis);
        this.mLongPressOnStemPrimaryBehavior = this.mContext.getResources().getInteger(R.integer.config_maxUiWidth);
        this.mDoublePressOnStemPrimaryBehavior = this.mContext.getResources().getInteger(R.integer.config_dreamCloseAnimationDuration);
        this.mTriplePressOnStemPrimaryBehavior = this.mContext.getResources().getInteger(R.integer.config_wait_for_satellite_enabling_response_timeout_millis);
        if (AudioSystem.getPlatformType(this.mContext) == 2) goto L17;
        r8 = false;
    L17:
        this.mUseTvRouting = r8;
        this.mHandleVolumeKeysInWM = this.mContext.getResources().getBoolean(R.bool.config_hotspotNetworksEnabledForService);
        this.mWakeUpToLastStateTimeout = this.mContext.getResources().getInteger(R.integer.device_idle_idle_factor);
        this.mSearchKeyBehavior = this.mContext.getResources().getInteger(R.integer.config_soundEffectVolumeDb);
        this.mSearchKeyTargetActivity = ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.connected_display_unavailable_notification_content));
        readConfigurationDependentBehaviors();
        this.mDisplayFoldController = DisplayFoldController.create(this.mContext, 0);
        this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService(AccessibilityManager.class);
        IntentFilter filter = new IntentFilter();
        filter.addAction(UiModeManager.ACTION_ENTER_CAR_MODE);
        filter.addAction(UiModeManager.ACTION_EXIT_CAR_MODE);
        filter.addAction(UiModeManager.ACTION_ENTER_DESK_MODE);
        filter.addAction(UiModeManager.ACTION_EXIT_DESK_MODE);
        filter.addAction("android.intent.action.DOCK_EVENT");
        this.mContext.registerReceiver(this.mDockReceiver, filter);
        this.mContext.registerReceiver(this.mMultiuserReceiver, new IntentFilter("android.intent.action.USER_SWITCHED"));
        this.mVibrator = (Vibrator) this.mContext.getSystemService("vibrator");
        this.mGlobalKeyManager = new GlobalKeyManager(this.mContext);
        initializeHdmiState();
        if (this.mPowerManager.isInteractive() == true) goto L20;
        startedGoingToSleep(0, 2);
        finishedGoingToSleep(0, 2);
    L20:
        this.mWindowManagerInternal.registerAppTransitionListener(new AnonymousClass7(this, r5));
        this.mKeyguardDrawnTimeout = this.mContext.getResources().getInteger(R.integer.config_longPressOnHomeBehavior);
        this.mKeyguardDelegate = injector.getKeyguardServiceDelegate();
        this.mTalkbackShortcutController = injector.getTalkbackShortcutController();
        this.mVoiceAccessShortcutController = injector.getVoiceAccessShortcutController();
        this.mWindowWakeUpPolicy = injector.getWindowWakeUpPolicy();
        this.mGameKeysCtrl = GameKeysCtrl.getInstance(this.mContext, this, this.mWindowManagerFuncs, this.mCurrentUserId);
        initKeyCombinationRules();
        initSingleKeyGestureRules(injector.getLooper());
        initKeyGestures();
        this.mButtonOverridePermissionChecker = injector.getButtonOverridePermissionChecker();
        this.mSideFpsEventHandler = new SideFpsEventHandler(this.mContext, this.mHandler, this.mPowerManager);
        return;
    L5:
        if (burnInProtectionDevMode == true) goto L7;
        Resources resources = this.mContext.getResources();
        int minHorizontal = resources.getInteger(R.integer.config_customizedMaxCachedProcesses);
        int maxHorizontal = resources.getInteger(R.integer.config_chooser_max_targets_per_row);
        int minVertical = resources.getInteger(R.integer.config_datagram_wait_for_connected_state_for_last_message_timeout_millis);
        int maxVertical = resources.getInteger(R.integer.config_cursorWindowSize);
        int minHorizontal2 = minHorizontal;
        int maxHorizontal2 = maxHorizontal;
        int minVertical2 = minVertical;
        int maxVertical2 = maxVertical;
        int maxRadius = resources.getInteger(R.integer.config_criticalBatteryWarningLevel);
    L12:
        this.mBurnInProtectionHelper = new BurnInProtectionHelper(this.mContext, minHorizontal2, maxHorizontal2, minVertical2, maxVertical2, maxRadius);
        goto L13
    L7:
        if (isRoundWindow() == false) goto L9;
        int r10 = 6;
    L10:
        minHorizontal2 = -8;
        maxHorizontal2 = 8;
        minVertical2 = -8;
        maxVertical2 = -4;
        maxRadius = r10;
        goto L12
    L9:
        r10 = -1;
        goto L10
    }

    private void initKeyCombinationRules() {
        this.mKeyCombinationManager = new KeyCombinationManager(this.mHandler);
        if (InputSettings.doesKeyGestureEventHandlerSupportMultiKeyGestures() == false) goto L5;
        return;
    L5:
        boolean screenshotChordEnabled = this.mContext.getResources().getBoolean(R.bool.config_enableTelephonyTimeZoneDetection);
        final int r1 = 24;
        final int r2 = 25;
        if (screenshotChordEnabled == false) goto L10;
        final int r5 = 26;
        this.mKeyCombinationManager.addRule(new AnonymousClass8(this, r2, r5));
        this.mKeyCombinationManager.addRule(new AnonymousClass9(this, r1, r5));
        KeyCombinationManager r3 = this.mKeyCombinationManager;
        final int r6 = FrameworkStatsLog.BINDER_LATENCY_REPORTED;
        r3.addRule(new AnonymousClass10(this, r6, r1));
        this.mKeyCombinationManager.addRule(new AnonymousClass11(this, r6, r2));
        if (this.mHasFeatureWatch == false) goto L10;
        final int r7 = 264;
        this.mKeyCombinationManager.addRule(new AnonymousClass12(this, r5, r7));
    L10:
        this.mKeyCombinationManager.addRule(new AnonymousClass13(this, r2, r1));
        if (this.mHasFeatureLeanback == false) goto L14;
        final int r4 = 20;
        final int r8 = 4;
        this.mKeyCombinationManager.addRule(new AnonymousClass14(this, r8, r4));
        final int r9 = 23;
        this.mKeyCombinationManager.addRule(new AnonymousClass15(this, r9, r8));
        return;
    }

    private void initSingleKeyGestureRules(Looper looper) {
        this.mSingleKeyGestureDetector = SingleKeyGestureDetector.get(this.mContext, looper);
        this.mSingleKeyGestureDetector.addRule(new PowerKeyRule(this));
        if (hasLongPressOnBackBehavior() == false) goto L6;
        this.mSingleKeyGestureDetector.addRule(new BackKeyRule(this));
    L6:
        if (hasStemPrimaryBehavior() == false) goto L8;
        this.mSingleKeyGestureDetector.addRule(new StemPrimaryKeyRule(this));
    L8:
        this.mSingleKeyGestureDetector.addRule(new StylusTailButtonRule(this));
    }

    private void readConfigurationDependentBehaviors() {
        Resources res = this.mContext.getResources();
        this.mLongPressOnHomeBehavior = res.getInteger(R.integer.config_maxResolverActivityColumns);
        if (this.mLongPressOnHomeBehavior >= 0) goto L5;
    L6:
        this.mLongPressOnHomeBehavior = 0;
    L7:
        this.mDoubleTapOnHomeBehavior = res.getInteger(R.integer.config_dreamsBatteryLevelDrainCutoff);
        if (this.mDoubleTapOnHomeBehavior >= 0) goto L10;
    L11:
        this.mDoubleTapOnHomeBehavior = 0;
    L12:
        this.mShortPressOnWindowBehavior = 0;
        if (this.mPackageManager.hasSystemFeature("android.software.picture_in_picture") == false) goto L15;
        this.mShortPressOnWindowBehavior = 1;
    L15:
        this.mSettingsKeyBehavior = res.getInteger(R.integer.config_stableDeviceDisplayWidth);
        if (this.mSettingsKeyBehavior >= 0) goto L18;
    L19:
        this.mSettingsKeyBehavior = 0;
        return;
    L18:
        if (this.mSettingsKeyBehavior > 2) goto L19;
        return;
    L10:
        if (this.mDoubleTapOnHomeBehavior <= 2) goto L12;
    L5:
        if (this.mLongPressOnHomeBehavior <= 3) goto L7;
        goto L6
    }

    private void updateSettings() {
        updateSettings(null);
    }

    void updateSettings(Handler handler) {
        if (handler == null) goto L6;
        handler.post(new PhoneWindowManager$$ExternalSyntheticLambda6(this));
        return;
    L6:
        ContentResolver resolver = this.mContext.getContentResolver();
        boolean updateRotation = false;
        boolean updateKidsModeSettings = false;
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mEndcallBehavior = Settings.System.getIntForUser(resolver, "end_button_behavior", 2, -2);     // Catch: Throwable -> L15
        this.mIncallPowerBehavior = Settings.Secure.getIntForUser(resolver, "incall_power_button_behavior", 1, -2);     // Catch: Throwable -> L15
        this.mIncallBackBehavior = Settings.Secure.getIntForUser(resolver, "incall_back_button_behavior", 0, -2);     // Catch: Throwable -> L15
        if (Settings.Secure.getIntForUser(resolver, "system_navigation_keys_enabled", 0, -2) != 1) goto L11;
        boolean r0 = true;
    L12:
        this.mSystemNavigationKeysEnabled = r0;     // Catch: Throwable -> L15
        this.mRingerToggleChord = Settings.Secure.getIntForUser(resolver, "volume_hush_gesture", 0, -2);     // Catch: Throwable -> L15
        this.mPowerButtonSuppressionDelayMillis = Settings.Global.getInt(resolver, "power_button_suppression_delay_after_gesture_wake", 800);     // Catch: Throwable -> L15
        if (this.mContext.getResources().getBoolean(R.bool.config_windowActionBarSupported) == true) goto L18;
        this.mRingerToggleChord = 0;     // Catch: Throwable -> L15
    L18:
        if (Settings.Secure.getIntForUser(resolver, "wake_gesture_enabled", 0, -2) == 0) goto L20;
        boolean wakeGestureEnabledSetting = true;
    L22:
        if (this.mWakeGestureEnabledSetting == wakeGestureEnabledSetting) goto L24;
        this.mWakeGestureEnabledSetting = wakeGestureEnabledSetting;     // Catch: Throwable -> L15
        updateWakeGestureListenerLp();     // Catch: Throwable -> L15
    L24:
        this.mLockScreenTimeout = Settings.System.getIntForUser(resolver, "screen_off_timeout", 0, -2);     // Catch: Throwable -> L15
        String imId = Settings.Secure.getStringForUser(resolver, "default_input_method", -2);     // Catch: Throwable -> L15
        if (imId != null) goto L27;
    L29:
        boolean hasSoftInput = false;
    L31:
        if (this.mHasSoftInput == hasSoftInput) goto L33;
        this.mHasSoftInput = hasSoftInput;     // Catch: Throwable -> L15
        updateRotation = true;
    L33:
        this.mShortPressOnPowerBehavior = Settings.Global.getInt(resolver, "power_button_short_press", this.mContext.getResources().getInteger(R.integer.config_storageManagerDaystoRetainDefault));     // Catch: Throwable -> L15
        this.mDoublePressOnPowerBehavior = Settings.Global.getInt(resolver, "power_button_double_press", this.mContext.getResources().getInteger(R.integer.config_drawLockTimeoutMillis));     // Catch: Throwable -> L15
        this.mTriplePressOnPowerBehavior = Settings.Global.getInt(resolver, "power_button_triple_press", this.mContext.getResources().getInteger(R.integer.config_wait_for_datagram_sending_response_timeout_millis));     // Catch: Throwable -> L15
        int longPressOnPowerBehavior = Settings.Global.getInt(resolver, "power_button_long_press", this.mContext.getResources().getInteger(R.integer.config_maxScanTasksForHomeVisibility));     // Catch: Throwable -> L15
        int veryLongPressOnPowerBehavior = Settings.Global.getInt(resolver, "power_button_very_long_press", this.mContext.getResources().getInteger(R.integer.config_zen_repeat_callers_threshold));     // Catch: Throwable -> L15
        if (this.mLongPressOnPowerBehavior == longPressOnPowerBehavior) goto L36;
    L37:
        this.mLongPressOnPowerBehavior = longPressOnPowerBehavior;     // Catch: Throwable -> L15
        this.mVeryLongPressOnPowerBehavior = veryLongPressOnPowerBehavior;     // Catch: Throwable -> L15
    L38:
        this.mLongPressOnPowerAssistantTimeoutMs = Settings.Global.getLong(this.mContext.getContentResolver(), "power_button_long_press_duration_ms", this.mContext.getResources().getInteger(R.integer.config_maxShortcutTargetsPerApp));     // Catch: Throwable -> L15
        this.mPowerVolUpBehavior = Settings.Global.getInt(resolver, "key_chord_power_volume_up", this.mContext.getResources().getInteger(R.integer.config_lockSoundVolumeDb));     // Catch: Throwable -> L15
        this.mShortPressOnStemPrimaryBehavior = Settings.Global.getInt(resolver, "stem_primary_button_short_press", this.mContext.getResources().getInteger(R.integer.config_tapTimeoutMillis));     // Catch: Throwable -> L15
        this.mDoublePressOnStemPrimaryBehavior = Settings.Global.getInt(resolver, "stem_primary_button_double_press", this.mContext.getResources().getInteger(R.integer.config_dreamCloseAnimationDuration));     // Catch: Throwable -> L15
        this.mTriplePressOnStemPrimaryBehavior = Settings.Global.getInt(resolver, "stem_primary_button_triple_press", this.mContext.getResources().getInteger(R.integer.config_wait_for_satellite_enabling_response_timeout_millis));     // Catch: Throwable -> L15
        this.mLongPressOnStemPrimaryBehavior = Settings.Global.getInt(resolver, "stem_primary_button_long_press", this.mContext.getResources().getInteger(R.integer.config_maxUiWidth));     // Catch: Throwable -> L15
        this.mShouldEarlyShortPressOnPower = this.mContext.getResources().getBoolean(R.bool.config_showUserSwitcherByDefault);     // Catch: Throwable -> L15
        this.mShouldEarlyShortPressOnStemPrimary = this.mContext.getResources().getBoolean(R.bool.config_shutdownIfNoPower);     // Catch: Throwable -> L15
        if (Settings.Secure.getIntForUser(resolver, "stylus_buttons_enabled", 1, -2) != 1) goto L41;
        boolean r7 = true;
    L42:
        this.mStylusButtonsEnabled = r7;     // Catch: Throwable -> L15
        this.mInputManagerInternal.setStylusButtonMotionEventsEnabled(this.mStylusButtonsEnabled);     // Catch: Throwable -> L15
        boolean kidsModeEnabled = false;
        if (Settings.Secure.getIntForUser(resolver, "nav_bar_kids_mode", 0, -2) != 1) goto L46;
        kidsModeEnabled = true;
    L46:
        if (this.mKidsModeEnabled == kidsModeEnabled) goto L48;
        this.mKidsModeEnabled = kidsModeEnabled;     // Catch: Throwable -> L15
        updateKidsModeSettings = true;
    L48:
        getExt().onUpdateSettings();     // Catch: Throwable -> L15
        getISmtEx().onUpdateSettings();     // Catch: Throwable -> L15
        monitor-exit(r6);     // Catch: Throwable -> L15
        if (updateKidsModeSettings == false) goto L52;
        updateKidsModeSettings(kidsModeEnabled);
    L52:
        if (updateRotation == false) goto L59;
        updateRotation(true);
        return;
    L59:
        return;
    L41:
        r7 = false;
        goto L42
    L36:
        if (this.mVeryLongPressOnPowerBehavior == veryLongPressOnPowerBehavior) goto L38;
    L27:
        if (imId.length() <= 0) goto L29;
        hasSoftInput = true;
        goto L31
    L20:
        wakeGestureEnabledSetting = false;
        goto L22
    L11:
        r0 = false;
    L15:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$updateSettings$3() {
        updateSettings(null);
    }

    private void updateKidsModeSettings(boolean kidsModeEnabled) {
        if (kidsModeEnabled == true) goto L5;
        this.mWindowManagerInternal.setOrientationRequestPolicy(false, null, null);
        return;
    L5:
        if (this.mContext.getResources().getBoolean(R.bool.config_screen_off_udfps_enabled) == false) goto L7;
        this.mWindowManagerInternal.setOrientationRequestPolicy(true, new int[]{0, 8}, new int[]{6, 6});
        return;
    L7:
        this.mWindowManagerInternal.setOrientationRequestPolicy(true, null, null);
    }

    private DreamManagerInternal getDreamManagerInternal() {
        if (this.mDreamManagerInternal != null) goto L6;
        this.mDreamManagerInternal = (DreamManagerInternal) LocalServices.getService(DreamManagerInternal.class);
    L6:
        return this.mDreamManagerInternal;
    }

    private void updateWakeGestureListenerLp() {
        if (shouldEnableWakeGestureLp() == false) goto L5;
        this.mWakeGestureListener.requestWakeUpTrigger();
        return;
    L5:
        this.mWakeGestureListener.cancelWakeUpTrigger();
    }

    private boolean shouldEnableWakeGestureLp() {
        if (this.mWakeGestureEnabledSetting == true) goto L5;
    L13:
        return false;
    L5:
        if (this.mDefaultDisplayPolicy.isAwake() == true) goto L13;
        if (getLidBehavior() != 1) goto L11;
        if (this.mDefaultDisplayPolicy.getLidState() == 0) goto L13;
    L11:
        if (this.mWakeGestureListener.isSupported() == false) goto L13;
        return true;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public int checkAddPermission(int type, boolean isRoundedCornerOverlay, String packageName, int[] outAppOp, int displayId) {
        if (isRoundedCornerOverlay == true) goto L5;
    L7:
        outAppOp[0] = -1;
        if (type >= 1) goto L10;
    L11:
        if (type >= 1000) goto L13;
    L14:
        if (type < 2000) goto L79;
        if (type > 2999) goto L88;
    L17:
        if (type < 2000) goto L78;
        if (type > 2999) goto L78;
        if (WindowManager.LayoutParams.isSystemAlertWindowType(type) == true) goto L33;
        switch(type) {
            case 2000: goto L32;
            case 2005: goto L30;
            case 2011: goto L32;
            case 2013: goto L32;
            case 2017: goto L32;
            case 2019: goto L32;
            case 2024: goto L32;
            case 2030: goto L32;
            case 2031: goto L32;
            case 2032: goto L28;
            case 2033: goto L32;
            case 2035: goto L32;
            case 2037: goto L32;
            case 2040: goto L32;
            case 2041: goto L32;
            default: goto L24;
        };
    L28:
        outAppOp[0] = 138;
        return 0;
    L30:
        outAppOp[0] = 45;
        return 0;
    L32:
        return 0;
    L24:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERNAL_SYSTEM_WINDOW") == 0) goto L27;
        return -8;
    L27:
        return 0;
    L33:
        outAppOp[0] = 24;
        int callingUid = Binder.getCallingUid();
        if (UserHandle.getAppId(callingUid) != 1000) goto L81;
        return 0;
    L81:
        String r13 = packageName;
        ApplicationInfo appInfo = this.mPackageManager.getApplicationInfoAsUser(r13, 0, UserHandle.getUserId(callingUid));     // Catch: PackageManager.NameNotFoundException -> L40
    L45:
        if (appInfo == null) goto L74;
        if (type == 2038) goto L52;
        if (appInfo.targetSdkVersion >= 26) goto L74;
    L52:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.SYSTEM_APPLICATION_OVERLAY") != 0) goto L55;
        return 0;
    L55:
        if (this.mWindowManagerFuncs.isCallerVirtualDeviceOwner(displayId, callingUid) == true) goto L57;
    L61:
        int mode = this.mAppOpsManager.noteOpNoThrow(outAppOp[0], callingUid, r13, null, "check-add");
        switch(mode) {
            case 0: goto L72;
            case 1: goto L72;
            case 2: goto L69;
            default: goto L64;
        };
    L72:
        return 0;
    L64:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) goto L67;
        return -8;
    L67:
        return 0;
    L69:
        if (appInfo.targetSdkVersion >= 23) goto L71;
        return 0;
    L71:
        return -8;
    L57:
        if (this.mWindowManagerFuncs.isDisplayTrusted(displayId) == false) goto L61;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CREATE_VIRTUAL_DEVICE") != 0) goto L61;
        return 0;
    L74:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERNAL_SYSTEM_WINDOW") == 0) goto L77;
        return -8;
    L77:
        return 0;
    L44:
        appInfo = null;
    L43:
        r13 = packageName;
    L78:
        return 0;
    L88:
        return -10;
    L79:
        return -10;
    L13:
        if (type <= 1999) goto L17;
    L10:
        if (type <= 99) goto L17;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERNAL_SYSTEM_WINDOW") == 0) goto L7;
        return -8;
    }

    void readLidState() {
        this.mDefaultDisplayPolicy.setLidState(this.mWindowManagerFuncs.getLidState());
    }

    private void readCameraLensCoverState() {
        this.mCameraLensCoverState = this.mWindowManagerFuncs.getCameraLensCoverState();
    }

    private boolean isHidden(int accessibilityMode) {
        int lidState = this.mDefaultDisplayPolicy.getLidState();
        switch(accessibilityMode) {
            case 1: goto L9;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        if (lidState != 1) goto L8;
        return true;
    L8:
        return false;
    L9:
        if (lidState != 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void adjustConfigurationLw(Configuration config, int keyboardPresence, int navigationPresence) {
        if ((keyboardPresence & 1) == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mHaveBuiltInKeyboard = r0;
        readConfigurationDependentBehaviors();
        readLidState();
        if (config.keyboard == 1) goto L11;
        if (keyboardPresence != 1) goto L15;
        if (isHidden(this.mLidKeyboardAccessibility) == true) goto L11;
    L15:
        if (config.navigation == 1) goto L19;
        if (navigationPresence == 1) goto L18;
        return;
    L18:
        if (isHidden(this.mLidNavigationAccessibility) == true) goto L19;
        return;
    L19:
        config.navigationHidden = 2;
        return;
    L11:
        config.hardKeyboardHidden = 2;
        if (this.mHasSoftInput == true) goto L15;
        config.keyboardHidden = 2;
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardHostWindow(WindowManager.LayoutParams attrs) {
        if (attrs.type != 2040) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public Animation createHiddenByKeyguardExit(boolean onWallpaper, boolean goingToNotificationShade, boolean subtleAnimation) {
        return TransitionAnimation.createHiddenByKeyguardExit(this.mContext, this.mLogDecelerateInterpolator, onWallpaper, goingToNotificationShade, subtleAnimation);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public Animation createKeyguardWallpaperExit(boolean goingToNotificationShade) {
        if (goingToNotificationShade == false) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(this.mContext, R.anim.progress_indeterminate_horizontal_rect1);
    }

    private static void awakenDreams() {
        IDreamManager dreamManager = getDreamManager();
        if (dreamManager == null) goto L10;
        dreamManager.awaken();     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    static IDreamManager getDreamManager() {
        return IDreamManager.Stub.asInterface(ServiceManager.checkService("dreams"));
    }

    TelecomManager getTelecommService() {
        return (TelecomManager) this.mContext.getSystemService("telecom");
    }

    NotificationManager getNotificationService() {
        return (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
    }

    static IAudioService getAudioService() {
        IAudioService audioService = IAudioService.Stub.asInterface(ServiceManager.checkService("audio"));
        if (audioService != null) goto L5;
        Log.w(TAG, "Unable to find IAudioService interface.");
    L5:
        return audioService;
    }

    boolean keyguardOn() {
        if (isKeyguardShowingAndNotOccluded() == false) goto L5;
    L8:
        return true;
    L5:
        if (inKeyguardRestrictedKeyInputMode() == true) goto L8;
        return false;
    }

    private void notifyKeyGestureCompletedOnActionUp(KeyEvent event, int gestureType) {
        if (event.getAction() == 1) goto L5;
        return;
    L5:
        notifyKeyGestureCompleted(event, gestureType);
    }

    private void notifyKeyGestureCompletedOnActionDown(KeyEvent event, int gestureType) {
        if (event.getAction() == 0) goto L5;
        return;
    L5:
        notifyKeyGestureCompleted(event, gestureType);
    }

    private void notifyKeyGestureCompleted(KeyEvent event, int gestureType) {
        if (gestureType != 0) goto L4;
        return;
    L4:
        this.mInputManagerInternal.notifyKeyGestureCompleted(event.getDeviceId(), new int[]{event.getKeyCode()}, event.getMetaState(), gestureType);
    }

    private void handleKeyGestureInKeyGestureController(int gestureType, int deviceId, int keyCode, int metaState) {
        if (gestureType != 0) goto L4;
        return;
    L4:
        this.mInputManagerInternal.handleKeyGestureInKeyGestureController(deviceId, new int[]{keyCode}, metaState, gestureType);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public KeyboardShortcutGroup getApplicationLaunchKeyboardShortcuts(int deviceId) {
        return this.mModifierShortcutManager.getApplicationLaunchKeyboardShortcuts(deviceId);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public long interceptKeyBeforeDispatching(IBinder focusedToken, KeyEvent event, int policyFlags) {
        int keyCode = event.getKeyCode();
        int flags = event.getFlags();
        int deviceId = event.getDeviceId();
        if (InputSettings.doesKeyGestureEventHandlerSupportMultiKeyGestures() == true) goto L13;
        KeyEvent r11 = event;
        if (this.mKeyCombinationManager.isKeyConsumed(r11) == false) goto L8;
        return -1;
    L8:
        if ((flags & 1024) != 0) goto L14;
        long now = SystemClock.uptimeMillis();
        long interceptTimeout = this.mKeyCombinationManager.getKeyInterceptTimeout(keyCode);
        if (now >= interceptTimeout) goto L14;
        return interceptTimeout - now;
    L14:
        Set<Integer> consumedKeys = this.mConsumedKeysForDevice.get(deviceId);
        if (consumedKeys != null) goto L18;
        consumedKeys = new HashSet();
        this.mConsumedKeysForDevice.put(deviceId, consumedKeys);
    L18:
        if (interceptSystemKeysAndShortcuts(focusedToken, event) == true) goto L20;
    L25:
        boolean needToConsumeKey = consumedKeys.contains(Integer.valueOf(keyCode));
        if (r11.getAction() != 1) goto L28;
    L29:
        consumedKeys.remove(Integer.valueOf(keyCode));
        if (consumedKeys.isEmpty() == false) goto L32;
        this.mConsumedKeysForDevice.remove(deviceId);
    L32:
        if (needToConsumeKey == true) goto L36;
        return 0;
    L36:
        return -1;
    L28:
        if (r11.isCanceled() == false) goto L32;
    L20:
        if (r11.getAction() != 0) goto L25;
        if (r11.getRepeatCount() != 0) goto L25;
        consumedKeys.add(Integer.valueOf(keyCode));
        return -1;
    L13:
        r11 = event;
        goto L14
    }

    private boolean interceptSystemKeysAndShortcuts(IBinder focusedToken, KeyEvent event) {
        return interceptSystemKeysAndShortcutsOld(focusedToken, event);
    }

    private boolean interceptSystemKeysAndShortcutsOld(IBinder focusedToken, KeyEvent event) {
        boolean keyguardOn = keyguardOn();
        int keyCode = event.getKeyCode();
        int repeatCount = event.getRepeatCount();
        int metaState = event.getMetaState();
        int r2 = 0;
        if (event.getAction() != 0) goto L5;
        boolean r0 = true;
    L6:
        boolean down = r0;
        boolean canceled = event.isCanceled();
        int displayId = event.getDisplayId();
        int deviceId = event.getDeviceId();
        if (down == false) goto L10;
        if (repeatCount != 0) goto L10;
        boolean r1 = true;
    L11:
        boolean firstDown = r1;
        if (this.mPendingMetaAction == false) goto L17;
        if (KeyEvent.isMetaKey(keyCode) == true) goto L17;
        this.mPendingMetaAction = false;
    L17:
        if (this.mPendingCapsLockToggle == false) goto L24;
        if (KeyEvent.isMetaKey(keyCode) == true) goto L24;
        if (KeyEvent.isAltKey(keyCode) == true) goto L24;
        this.mPendingCapsLockToggle = false;
    L24:
        if (isUserSetupComplete() == false) goto L34;
        if (keyguardOn == true) goto L34;
        if (this.mModifierShortcutManager.interceptKey(event) == false) goto L34;
        if (isKeyEventForCurrentUser(event.getDisplayId(), event.getKeyCode(), "dismissKeyboardShortcutsMenu") == false) goto L31;
        dismissKeyboardShortcutsMenu();
    L31:
        this.mPendingMetaAction = false;
        this.mPendingCapsLockToggle = false;
        return true;
    L34:
        switch(keyCode) {
            case 3: goto L341;
            case 10: goto L317;
            case 11: goto L307;
            case 12: goto L300;
            case 13: goto L288;
            case 19: goto L277;
            case 20: goto L267;
            case 21: goto L258;
            case 22: goto L251;
            case 24: goto L236;
            case 25: goto L236;
            case 29: goto L230;
            case 36: goto L227;
            case 37: goto L218;
            case 40: goto L213;
            case 42: goto L208;
            case 47: goto L203;
            case 48: goto L328;
            case 57: goto L187;
            case 58: goto L187;
            case 61: goto L171;
            case 66: goto L227;
            case 67: goto L154;
            case 76: goto L147;
            case 83: goto L142;
            case 84: goto L134;
            case 111: goto L128;
            case 115: goto L125;
            case 117: goto L106;
            case 118: goto L106;
            case 164: goto L236;
            case 176: goto L96;
            case 187: goto L88;
            case 204: goto L79;
            case 219: goto L77;
            case 220: goto L65;
            case 221: goto L65;
            case 231: goto L63;
            case 264: goto L59;
            case 284: goto L54;
            case 305: goto L51;
            case 306: goto L48;
            case 307: goto L45;
            case 308: goto L43;
            case 309: goto L43;
            case 310: goto L43;
            case 311: goto L43;
            case 312: goto L40;
            case 318: goto L37;
            case 322: goto L36;
            case 324: goto L36;
            case 325: goto L36;
            default: goto L328;
        };
    L36:
        return true;
    L37:
        if (firstDown == false) goto L39;
        interceptScreenshotChord(2, 0);
    L39:
        return true;
    L40:
        if (firstDown == false) goto L42;
        showRecentApps(false);
        notifyKeyGestureCompleted(event, 2);
    L42:
        return true;
    L43:
        Slog.wtf(TAG, "KEYCODE_STYLUS_BUTTON_* should be handled in interceptKeyBeforeQueueing");
        return true;
    L45:
        if (down == true) goto L47;
        notifyKeyGestureCompleted(event, 17);
    L47:
        return true;
    L48:
        if (down == false) goto L50;
        this.mInputManagerInternal.incrementKeyboardBacklight(event.getDeviceId());
        notifyKeyGestureCompleted(event, 15);
    L50:
        return true;
    L51:
        if (down == false) goto L53;
        this.mInputManagerInternal.decrementKeyboardBacklight(event.getDeviceId());
        notifyKeyGestureCompleted(event, 16);
    L53:
        return true;
    L54:
        if (firstDown == false) goto L57;
        this.mHandler.removeMessages(22);
        Message msg = this.mHandler.obtainMessage(22, new KeyEvent(event));
        msg.setAsynchronous(true);
        msg.sendToTarget();
        notifyKeyGestureCompleted(event, 21);
        return true;
    L57:
        return true;
    L63:
        Slog.wtf(TAG, "KEYCODE_VOICE_ASSIST should be handled in interceptKeyBeforeQueueing");
        return true;
    L65:
        if (down == true) goto L67;
        return true;
    L67:
        if (keyCode != 221) goto L69;
        int direction = 1;
    L70:
        changeDisplayBrightnessValue(displayId, direction);
        if (keyCode != 220) goto L73;
        int gestureType = 14;
    L74:
        notifyKeyGestureCompleted(event, gestureType);
        return true;
    L73:
        gestureType = 13;
        goto L74
    L69:
        direction = -1;
        goto L70
    L77:
        Slog.wtf(TAG, "KEYCODE_ASSIST should be handled in interceptKeyBeforeQueueing");
        return true;
    L79:
        if (firstDown == false) goto L328;
        if ((metaState & 193) == 0) goto L83;
        int direction2 = -1;
    L84:
        sendSwitchKeyboardLayout(displayId, focusedToken, direction2);
        notifyKeyGestureCompleted(event, 23);
        return true;
    L83:
        direction2 = 1;
        goto L84
    L203:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        interceptScreenshotChord(2, 0);
        notifyKeyGestureCompleted(event, 10);
        return true;
    L208:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        toggleNotificationPanel();
        notifyKeyGestureCompleted(event, 8);
        return true;
    L213:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        lockNow(null);
        notifyKeyGestureCompleted(event, 32);
        return true;
    L218:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (isUserSetupComplete() == false) goto L328;
        if (keyguardOn == true) goto L328;
        showSystemSettings();
        notifyKeyGestureCompleted(event, 7);
        return true;
    L230:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        launchAssistAction("android.intent.extra.ASSIST_INPUT_HINT_KEYBOARD", deviceId, event.getEventTime(), 0);
        notifyKeyGestureCompleted(event, 5);
        return true;
    L251:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isCtrlPressed() == false) goto L328;
        moveFocusedTaskToStageSplit(getTargetDisplayIdForKeyEvent(event), false);
        notifyKeyGestureCompleted(event, 28);
        return true;
    L258:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isCtrlPressed() == false) goto L264;
        moveFocusedTaskToStageSplit(getTargetDisplayIdForKeyEvent(event), true);
        notifyKeyGestureCompleted(event, 27);
        return true;
    L264:
        notifyKeyGestureCompleted(event, 3);
        injectBackGesture(event.getDownTime());
        return true;
    L267:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isCtrlPressed() == false) goto L328;
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L328;
        statusbar.moveFocusedTaskToDesktop(getTargetDisplayIdForKeyEvent(event));
        notifyKeyGestureCompleted(event, 52);
        return true;
    L277:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isCtrlPressed() == false) goto L328;
        StatusBarManagerInternal statusbar2 = getStatusBarManagerInternal();
        if (statusbar2 == null) goto L328;
        statusbar2.moveFocusedTaskToFullscreen(getTargetDisplayIdForKeyEvent(event));
        notifyKeyGestureCompleted(event, 53);
        return true;
    L307:
        boolean stickyKeysEnabled = InputSettings.isAccessibilityMouseKeysFeatureFlagEnabled();
        if (stickyKeysEnabled == false) goto L328;
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isAltPressed() == false) goto L328;
        boolean mouseKeysEnabled = InputSettings.isAccessibilityMouseKeysEnabled(this.mContext);
        InputSettings.setAccessibilityMouseKeysEnabled(this.mContext, !mouseKeysEnabled);
        notifyKeyGestureCompleted(event, 67);
        return true;
    L328:
        boolean bounceKeysEnabled = isValidGlobalKey(keyCode);
        if (bounceKeysEnabled == true) goto L331;
        boolean r17 = true;
    L337:
        if ((65536 & metaState) != 0) goto L339;
        return false;
    L339:
        return r17;
    L331:
        if (this.mGlobalKeyManager.handleGlobalKey(this.mContext, keyCode, event) == false) goto L334;
        return true;
    L334:
        r17 = true;
        goto L337
    L288:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isAltPressed() == false) goto L328;
        boolean slowKeysEnabled = InputSettings.isAccessibilitySlowKeysEnabled(this.mContext);
        Context r4 = this.mContext;
        if (slowKeysEnabled == true) goto L297;
        r2 = 500;
    L297:
        InputSettings.setAccessibilitySlowKeysThreshold(r4, r2);
        notifyKeyGestureCompleted(event, 66);
        return true;
    L300:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isAltPressed() == false) goto L328;
        boolean stickyKeysEnabled2 = InputSettings.isAccessibilityStickyKeysEnabled(this.mContext);
        InputSettings.setAccessibilityStickyKeysEnabled(this.mContext, !stickyKeysEnabled2);
        notifyKeyGestureCompleted(event, 64);
        return true;
    L317:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isAltPressed() == false) goto L328;
        boolean bounceKeysEnabled2 = InputSettings.isAccessibilityBounceKeysEnabled(this.mContext);
        Context r5 = this.mContext;
        if (bounceKeysEnabled2 == true) goto L326;
        r2 = 500;
    L326:
        InputSettings.setAccessibilityBounceKeysThreshold(r5, r2);
        notifyKeyGestureCompleted(event, 65);
        return true;
    L59:
        if (prepareToSendSystemKeyToApplication(focusedToken, event) == false) goto L61;
        return false;
    L61:
        sendSystemKeyToStatusBarAsync(event);
        return true;
    L88:
        if (keyguardOn == true) goto L347;
        if (firstDown == false) goto L91;
        preloadRecentApps();
        return true;
    L91:
        if (down == true) goto L349;
        toggleRecentApps();
        notifyKeyGestureCompleted(event, 4);
        return true;
    L349:
        return true;
    L347:
        return true;
    L96:
        if (firstDown == true) goto L98;
        return true;
    L98:
        if (this.mSettingsKeyBehavior != 1) goto L101;
        toggleNotificationPanel();
        notifyKeyGestureCompleted(event, 8);
        return true;
    L101:
        if (this.mSettingsKeyBehavior != 0) goto L352;
        showSystemSettings();
        notifyKeyGestureCompleted(event, 7);
        return true;
    L352:
        return true;
    L106:
        if (down == false) goto L112;
        if (event.isAltPressed() == false) goto L110;
        this.mPendingCapsLockToggle = true;
        this.mPendingMetaAction = false;
        return true;
    L110:
        this.mPendingCapsLockToggle = false;
        this.mPendingMetaAction = true;
        return true;
    L112:
        if (this.mPendingCapsLockToggle == false) goto L115;
        this.mInputManagerInternal.toggleCapsLock(event.getDeviceId());
        this.mPendingCapsLockToggle = false;
        notifyKeyGestureCompleted(event, 25);
        return true;
    L115:
        if (this.mPendingMetaAction == false) goto L356;
        if (canceled == false) goto L118;
    L121:
        this.mPendingMetaAction = false;
        return true;
    L118:
        if (isKeyEventForCurrentUser(event.getDisplayId(), event.getKeyCode(), "launchAllAppsViaA11y") == false) goto L120;
        launchAllAppsAction();
    L120:
        notifyKeyGestureCompleted(event, 21);
        goto L121
    L356:
        return true;
    L125:
        if (down == true) goto L328;
        notifyKeyGestureCompleted(event, 25);
        goto L328
    L128:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        notifyKeyGestureCompleted(event, 3);
        injectBackGesture(event.getDownTime());
        return true;
    L134:
        if (firstDown == false) goto L328;
        if (keyguardOn == true) goto L328;
        switch(this.mSearchKeyBehavior) {
            case 1: goto L139;
            default: goto L328;
        };
    L139:
        launchTargetSearchActivity();
        notifyKeyGestureCompleted(event, 22);
        return true;
    L142:
        if (down == true) goto L357;
        toggleNotificationPanel();
        notifyKeyGestureCompleted(event, 8);
        return true;
    L357:
        return true;
    L147:
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (keyguardOn == true) goto L328;
        toggleKeyboardShortcutsMenu(event.getDeviceId());
        notifyKeyGestureCompleted(event, 12);
        return true;
    L154:
        if (this.mEnableBugReportKeyboardShortcut == false) goto L328;
        if (firstDown == false) goto L328;
        if (event.isMetaPressed() == false) goto L328;
        if (event.isCtrlPressed() == false) goto L328;
    L164:
        e = move-exception;
        Slog.d(TAG, "Error taking bugreport", e);
    L168:
        notifyKeyGestureCompleted(event, 31);
        return true;
    L161:
        if (this.mActivityManagerService.launchBugReportHandlerApp() == true) goto L168;
        this.mActivityManagerService.requestInteractiveBugReport();     // Catch: RemoteException -> L164
        goto L168
    L171:
        if (firstDown == false) goto L328;
        if (keyguardOn == true) goto L328;
        if (isUserSetupComplete() == false) goto L328;
        if (event.isMetaPressed() == false) goto L180;
        showRecentApps(false);
        notifyKeyGestureCompleted(event, 2);
        return true;
    L180:
        if (this.mRecentAppsHeldModifiers != 0) goto L328;
        int shiftlessModifiers = event.getModifiers() & (-194);
        if (KeyEvent.metaStateHasModifiers(shiftlessModifiers, 2) == false) goto L328;
        this.mRecentAppsHeldModifiers = shiftlessModifiers;
        showRecentApps(true);
        notifyKeyGestureCompleted(event, 2);
        return true;
    L187:
        if (down == false) goto L193;
        if (event.isMetaPressed() == false) goto L191;
        this.mPendingCapsLockToggle = true;
        this.mPendingMetaAction = false;
        goto L328
    L191:
        this.mPendingCapsLockToggle = false;
        goto L328
    L193:
        if (this.mRecentAppsHeldModifiers == 0) goto L199;
        if ((this.mRecentAppsHeldModifiers & metaState) != 0) goto L199;
        this.mRecentAppsHeldModifiers = 0;
        hideRecentApps(true, false);
        return true;
    L199:
        if (this.mPendingCapsLockToggle == false) goto L328;
        this.mInputManagerInternal.toggleCapsLock(event.getDeviceId());
        this.mPendingCapsLockToggle = false;
        notifyKeyGestureCompleted(event, 25);
        return true;
    L227:
        if (event.isMetaPressed() == false) goto L328;
        return handleHomeShortcuts(focusedToken, event);
    L236:
        if (this.mUseTvRouting == false) goto L238;
    L249:
        dispatchDirectAudioEvent(event);
        return true;
    L238:
        if (this.mHandleVolumeKeysInWM == true) goto L249;
        if (this.mDefaultDisplayPolicy.isPersistentVrModeEnabled() == false) goto L328;
        InputDevice d = event.getDevice();
        if (d == null) goto L328;
        if (d.isExternal() == true) goto L328;
        return true;
    L341:
        return handleHomeShortcuts(focusedToken, event);
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private boolean interceptSystemKeysAndShortcutsNew(IBinder focusedToken, KeyEvent event) {
        int keyCode = event.getKeyCode();
        int metaState = event.getMetaState();
        switch(keyCode) {
            case 3: goto L35;
            case 24: goto L11;
            case 25: goto L11;
            case 164: goto L11;
            case 264: goto L6;
            default: goto L24;
        };
    L6:
        if (prepareToSendSystemKeyToApplication(focusedToken, event) == false) goto L8;
        return false;
    L8:
        sendSystemKeyToStatusBarAsync(event);
        return true;
    L11:
        if (this.mUseTvRouting == false) goto L13;
    L32:
        dispatchDirectAudioEvent(event);
        return true;
    L13:
        if (this.mHandleVolumeKeysInWM == true) goto L32;
        if (this.mDefaultDisplayPolicy.isPersistentVrModeEnabled() == false) goto L24;
        InputDevice d = event.getDevice();
        if (d == null) goto L24;
        if (d.isExternal() == true) goto L24;
        return true;
    L35:
        return handleHomeShortcuts(focusedToken, event);
    L24:
        if (isValidGlobalKey(keyCode) == false) goto L29;
        if (this.mGlobalKeyManager.handleGlobalKey(this.mContext, keyCode, event) == false) goto L29;
        return true;
    L29:
        if ((65536 & metaState) != 0) goto L31;
        return false;
    L31:
        return true;
    }

    private void initKeyGestures() {
    }

    void handleKeyGestureEvent(KeyGestureEvent event, IBinder focusedToken) {
        int r2 = 0;
        int direction = 1;
        if (event.getAction() != 1) goto L5;
        boolean r0 = true;
    L6:
        boolean start = r0;
        if (event.getAction() == 2) goto L9;
    L11:
        boolean r1 = false;
    L12:
        boolean complete = r1;
        int deviceId = event.getDeviceId();
        int gestureType = event.getKeyGestureType();
        final int displayId = event.getDisplayId();
        int modifierState = event.getModifierState();
        boolean keyguardOn = keyguardOn();
        if (isUserSetupComplete() == false) goto L16;
        if (keyguardOn == true) goto L16;
        boolean r3 = true;
    L17:
        boolean canLaunchApp = r3;
        if (event.isCancelled() == true) goto L23;
        if (Arrays.stream(event.getKeycodes()).anyMatch(new PhoneWindowManager$$ExternalSyntheticLambda3()) == false) goto L23;
        this.mPowerKeyHandled = true;
    L23:
        switch(gestureType) {
            case 1: goto L183;
            case 2: goto L180;
            case 3: goto L177;
            case 4: goto L171;
            case 5: goto L166;
            case 6: goto L166;
            case 7: goto L161;
            case 8: goto L157;
            case 10: goto L153;
            case 11: goto L149;
            case 12: goto L145;
            case 13: goto L137;
            case 14: goto L137;
            case 21: goto L131;
            case 22: goto L126;
            case 23: goto L119;
            case 27: goto L115;
            case 28: goto L111;
            case 31: goto L98;
            case 32: goto L94;
            case 51: goto L84;
            case 52: goto L78;
            case 53: goto L71;
            case 54: goto L67;
            case 56: goto L63;
            case 57: goto L59;
            case 59: goto L55;
            case 60: goto L49;
            case 61: goto L45;
            case 63: goto L41;
            case 75: goto L29;
            case 76: goto L26;
            default: goto L24;
        };
    L24:
        Log.w(TAG, "Received a key gesture " + event + " that was not registered by this handler");
        return;
    L29:
        NotificationManager nm = getNotificationService();
        if (nm == null) goto L192;
        if (nm.getZenMode() == 0) goto L34;
        boolean isEnabled = true;
    L35:
        if (isEnabled == true) goto L38;
        r2 = 1;
    L38:
        nm.setZenMode(r2, null, "Key gesture DND", true);
        return;
    L34:
        isEnabled = false;
        goto L35
    L192:
        return;
    L84:
        AppLaunchData data = event.getAppLaunchData();
        if (complete == false) goto L213;
        if (canLaunchApp == false) goto L213;
        if (data == null) goto L213;
        if (this.mModifierShortcutManager.launchApplication(data) == false) goto L212;
        dismissKeyboardShortcutsMenu();
        return;
    L212:
        return;
    L213:
        return;
    L26:
        if (complete == false) goto L190;
        this.mVoiceAccessShortcutController.toggleVoiceAccess(this.mCurrentUserId);
        return;
    L190:
        return;
    L41:
        if (complete == false) goto L194;
        this.mTalkbackShortcutController.toggleTalkback(this.mCurrentUserId, TalkbackShortcutController.ShortcutSource.KEYBOARD);
        return;
    L194:
        return;
    L45:
        if (complete == false) goto L196;
        this.mContext.closeSystemDialogs();
        return;
    L196:
        return;
    L49:
        if (complete == false) goto L198;
        if (this.mAccessibilityShortcutController.isAccessibilityShortcutAvailable(isKeyguardLocked()) == false) goto L198;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(17));
        return;
    L198:
        return;
    L55:
        if (start == false) goto L57;
        interceptBugreportGestureTv();
        return;
    L57:
        cancelBugreportGestureTv();
        return;
    L59:
        if (start == false) goto L61;
        performHapticFeedback(10003, "KEY_GESTURE_TYPE_GLOBAL_ACTIONS - Global Actions");
        showGlobalActions();
        return;
    L61:
        cancelGlobalActionsAction();
        return;
    L63:
        if (start == false) goto L65;
        interceptRingerToggleChord();
        return;
    L65:
        cancelPendingRingerToggleChordAction();
        return;
    L67:
        if (start == false) goto L69;
        showRecentApps(true);
        return;
    L69:
        hideRecentApps(true, false);
        return;
    L71:
        if (complete == false) goto L208;
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L207;
        statusbar.moveFocusedTaskToFullscreen(getTargetDisplayIdForKeyGestureEvent(event));
    L207:
        return;
    L208:
        return;
    L78:
        if (complete == false) goto L210;
        StatusBarManagerInternal statusbar2 = getStatusBarManagerInternal();
        if (statusbar2 == null) goto L209;
        statusbar2.moveFocusedTaskToDesktop(getTargetDisplayIdForKeyGestureEvent(event));
    L209:
        return;
    L210:
        return;
    L94:
        if (complete == false) goto L215;
        lockNow(null);
        return;
    L215:
        return;
    L98:
        if (complete == false) goto L217;
        if (this.mEnableBugReportKeyboardShortcut == false) goto L217;
    L105:
        e = move-exception;
        Slog.d(TAG, "Error taking bugreport", e);
    L216:
        return;
    L102:
        if (this.mActivityManagerService.launchBugReportHandlerApp() == true) goto L216;
        this.mActivityManagerService.requestInteractiveBugReport();     // Catch: RemoteException -> L105
    L217:
        return;
    L111:
        if (complete == false) goto L219;
        moveFocusedTaskToStageSplit(getTargetDisplayIdForKeyGestureEvent(event), false);
        return;
    L219:
        return;
    L115:
        if (complete == false) goto L221;
        moveFocusedTaskToStageSplit(getTargetDisplayIdForKeyGestureEvent(event), true);
        return;
    L221:
        return;
    L119:
        if (complete == false) goto L223;
        if ((modifierState & 193) == 0) goto L123;
        direction = -1;
    L123:
        sendSwitchKeyboardLayout(displayId, focusedToken, direction);
        return;
    L223:
        return;
    L126:
        if (complete == false) goto L225;
        if (canLaunchApp == false) goto L225;
        launchTargetSearchActivity();
        return;
    L225:
        return;
    L131:
        if (complete == false) goto L227;
        if (isKeyEventForCurrentUser(event.getDisplayId(), event.getKeycodes()[0], "launchAllAppsViaA11y") == false) goto L227;
        launchAllAppsAction();
        return;
    L227:
        return;
    L137:
        if (complete == false) goto L229;
        if (gestureType == 13) goto L142;
        direction = -1;
    L142:
        changeDisplayBrightnessValue(displayId, direction);
        return;
    L229:
        return;
    L145:
        if (complete == false) goto L231;
        toggleKeyboardShortcutsMenu(deviceId);
        return;
    L231:
        return;
    L149:
        if (start == false) goto L151;
        interceptScreenshotChord(1, getScreenshotChordLongPressDelay());
        return;
    L151:
        cancelPendingScreenshotChordAction();
        return;
    L153:
        if (complete == false) goto L235;
        interceptScreenshotChord(2, 0);
        return;
    L235:
        return;
    L157:
        if (complete == false) goto L237;
        toggleNotificationPanel();
        return;
    L237:
        return;
    L161:
        if (complete == false) goto L239;
        if (canLaunchApp == false) goto L239;
        showSystemSettings();
        return;
    L239:
        return;
    L166:
        if (complete == false) goto L241;
        if (canLaunchApp == false) goto L241;
        launchAssistAction("android.intent.extra.ASSIST_INPUT_HINT_KEYBOARD", deviceId, SystemClock.uptimeMillis(), 0);
        return;
    L241:
        return;
    L171:
        if (keyguardOn == true) goto L242;
        if (start == false) goto L174;
        preloadRecentApps();
        return;
    L174:
        if (complete == false) goto L244;
        toggleRecentApps();
        return;
    L244:
        return;
    L242:
        return;
    L177:
        if (complete == false) goto L246;
        injectBackGesture(SystemClock.uptimeMillis());
        return;
    L246:
        return;
    L180:
        if (complete == false) goto L248;
        showRecentApps(false);
        return;
    L248:
        return;
    L183:
        if (complete == false) goto L250;
        this.mHandler.post(new PhoneWindowManager$$ExternalSyntheticLambda4(this, displayId));
        return;
    L250:
        return;
    L16:
        r3 = false;
        goto L17
    L9:
        if (event.isCancelled() == true) goto L11;
        r1 = true;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private static /* synthetic */ boolean lambda$handleKeyGestureEvent$4(int keycode) {
        if (keycode != 26) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$handleKeyGestureEvent$5(int displayId) {
        handleShortPressOnHome(displayId);
    }

    private void changeDisplayBrightnessValue(int displayId, int direction) {
        if (displayId >= 0) goto L5;
        int screenDisplayId = 0;
    L6:
        float minLinearBrightness = this.mPowerManager.getBrightnessConstraint(screenDisplayId, 0);
        float maxLinearBrightness = this.mPowerManager.getBrightnessConstraint(screenDisplayId, 1);
        float linearBrightness = this.mDisplayManager.getBrightness(screenDisplayId);
        float gammaBrightness = BrightnessUtils.convertLinearToGamma(linearBrightness);
        float adjustedGammaBrightness = (direction * 0.1f) + gammaBrightness;
        float adjustedLinearBrightness = BrightnessUtils.convertGammaToLinear(MathUtils.constrain(adjustedGammaBrightness, 0.0f, 1.0f));
        this.mDisplayManager.setBrightness(screenDisplayId, MathUtils.constrain(adjustedLinearBrightness, minLinearBrightness, maxLinearBrightness));
        Intent intent = new Intent("com.android.intent.action.SHOW_BRIGHTNESS_DIALOG");
        intent.addFlags(327680);
        intent.putExtra("android.intent.extra.FROM_BRIGHTNESS_KEY", true);
        startActivityAsUser(intent, UserHandle.CURRENT_OR_SELF);
        return;
    L5:
        screenDisplayId = displayId;
        goto L6
    }

    private boolean prepareToSendSystemKeyToApplication(IBinder focusedToken, KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (event.isSystem() == true) goto L7;
        Log.wtf(TAG, "Illegal keycode provided to prepareToSendSystemKeyToApplication: " + KeyEvent.keyCodeToString(keyCode));
        return false;
    L7:
        if (event.getAction() != 0) goto L9;
        boolean isDown = true;
    L10:
        if (isDown == true) goto L12;
    L20:
        Set<Integer> consumedKeys = this.mConsumedKeysForDevice.get(event.getDeviceId());
        if (consumedKeys != null) goto L23;
    L25:
        boolean wasConsumed = false;
    L26:
        if (wasConsumed == false) goto L28;
        return false;
    L28:
        return true;
    L23:
        if (consumedKeys.contains(Integer.valueOf(keyCode)) == false) goto L25;
        wasConsumed = true;
        goto L26
    L12:
        if (event.getRepeatCount() != 0) goto L20;
        KeyInterceptionInfo info = this.mWindowManagerInternal.getKeyInterceptionInfoFromToken(focusedToken);
        if (info != null) goto L16;
    L18:
        setDeferredKeyActionsExecutableAsync(keyCode, event.getDownTime());
        return false;
    L16:
        if (this.mButtonOverridePermissionChecker.canAppOverrideSystemKey(this.mContext, info.windowOwnerUid) == false) goto L18;
        return true;
    L9:
        isDown = false;
        goto L10
    }

    private void setDeferredKeyActionsExecutableAsync(int keyCode, long downTime) {
        Message msg = Message.obtain(this.mHandler, 27);
        msg.arg1 = keyCode;
        msg.obj = Long.valueOf(downTime);
        msg.setAsynchronous(true);
        msg.sendToTarget();
    }

    private void injectBackGesture(long downtime) {
        if (this.mActivityTaskManagerInternal.requestBackGesture() == false) goto L5;
        return;
    L5:
        KeyEvent downEvent = new KeyEvent(downtime, downtime, 0, 4, 0, 0, -1, 0, 72, 257);
        this.mInputManager.injectInputEvent(downEvent, 0);
        KeyEvent upEvent = KeyEvent.changeAction(downEvent, 1);
        this.mInputManager.injectInputEvent(upEvent, 0);
        downEvent.recycle();
        upEvent.recycle();
    }

    private boolean handleHomeShortcuts(IBinder focusedToken, KeyEvent event) {
        DisplayHomeButtonHandler handler = this.mDisplayHomeButtonHandlers.get(event.getDisplayId());
        if (handler != null) goto L6;
        handler = new DisplayHomeButtonHandler(this, event.getDisplayId());
        this.mDisplayHomeButtonHandlers.put(event.getDisplayId(), handler);
    L6:
        return handler.handleHomeButton(focusedToken, event);
    }

    private void toggleMicrophoneMuteFromKey() {
        if (this.mSensorPrivacyManager.supportsSensorToggle(1, 1) == false) goto L10;
        boolean isEnabled = this.mSensorPrivacyManager.isSensorPrivacyEnabled(1, 1);
        this.mSensorPrivacyManager.setSensorPrivacy(5, 1, !isEnabled, this.mCurrentUserId);
        if (isEnabled == false) goto L7;
        int toastTextResId = R.string.notification_history_title_placeholder;
    L8:
        Toast.makeText(this.mContext, UiThread.get().getLooper(), this.mContext.getString(toastTextResId), 0).show();
        return;
    L7:
        toastTextResId = R.string.notification_hidden_text;
        goto L8
    }

    private void interceptBugreportGestureTv() {
        this.mHandler.removeMessages(18);
        Message msg = Message.obtain(this.mHandler, 18);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageDelayed(msg, 1000);
    }

    private void cancelBugreportGestureTv() {
        this.mHandler.removeMessages(18);
    }

    private void interceptAccessibilityGestureTv() {
        this.mHandler.removeMessages(19);
        Message msg = Message.obtain(this.mHandler, 19);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageDelayed(msg, getAccessibilityShortcutTimeout());
    }

    private void cancelAccessibilityGestureTv() {
        this.mHandler.removeMessages(19);
    }

    void requestBugreportForTv() {
    L6:
        e = move-exception;
        Slog.e(TAG, "Error taking bugreport", e);
        return;
    L3:
        if (ActivityManager.getService().launchBugReportHandlerApp() == true) goto L13;
        ActivityManager.getService().requestInteractiveBugReport();     // Catch: RemoteException -> L6
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean interceptUnhandledKey(KeyEvent event, IBinder focusedToken) {
        int keyCode = event.getKeyCode();
        int repeatCount = event.getRepeatCount();
        if (event.getAction() != 0) goto L5;
        boolean down = true;
    L6:
        int metaState = event.getModifiers();
        if (keyCode != 264) goto L11;
        handleUnhandledSystemKey(event);
        sendSystemKeyToStatusBarAsync(event);
        return true;
    L11:
        switch(keyCode) {
            case 54: goto L33;
            case 62: goto L23;
            case 111: goto L17;
            case 120: goto L13;
            default: goto L40;
        };
    L13:
        if (down == false) goto L40;
        if (repeatCount != 0) goto L40;
        interceptScreenshotChord(2, 0);
        return true;
    L17:
        if (down == false) goto L40;
        if (KeyEvent.metaStateHasNoModifiers(metaState) == false) goto L40;
        if (repeatCount != 0) goto L40;
        this.mContext.closeSystemDialogs();
        return true;
    L23:
        if (down == false) goto L40;
        if (repeatCount != 0) goto L40;
        if (KeyEvent.metaStateHasModifiers(metaState & (-194), 4096) == false) goto L40;
        if ((metaState & 193) == 0) goto L30;
        int direction = -1;
    L31:
        sendSwitchKeyboardLayout(event.getDisplayId(), focusedToken, direction);
        return true;
    L30:
        direction = 1;
        goto L31
    L33:
        if (down == false) goto L40;
        if (KeyEvent.metaStateHasModifiers(metaState, UsbACInterface.FORMAT_II_AC3) == false) goto L40;
        if (this.mAccessibilityShortcutController.isAccessibilityShortcutAvailable(isKeyguardLocked()) == false) goto L40;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(17));
        return true;
    L40:
        return false;
    L5:
        down = false;
        goto L6
    }

    private void handleUnhandledSystemKey(KeyEvent event) {
        if (event.isSystem() == true) goto L7;
        Log.wtf(TAG, "Illegal keycode provided to handleUnhandledSystemKey: " + KeyEvent.keyCodeToString(event.getKeyCode()));
        return;
    L7:
        if (event.getAction() == 0) goto L9;
        return;
    L9:
        if (event.getRepeatCount() != 0) goto L13;
        setDeferredKeyActionsExecutableAsync(event.getKeyCode(), event.getDownTime());
        return;
    }

    private void sendSwitchKeyboardLayout(int displayId, IBinder focusedToken, int direction) {
        SwitchKeyboardLayoutMessageObject object = new SwitchKeyboardLayoutMessageObject(displayId, focusedToken, direction, null);
        this.mHandler.obtainMessage(25, object).sendToTarget();
    }

    private void handleSwitchKeyboardLayout(int displayId, int direction, IBinder focusedToken) {
        IBinder targetWindowToken = this.mWindowManagerInternal.getTargetWindowTokenFromInputToken(focusedToken);
        InputMethodManagerInternal.get().onSwitchKeyboardLayoutShortcut(direction, displayId, targetWindowToken);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setTopFocusedDisplay(int displayId) {
        this.mTopFocusedDisplayId = displayId;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void registerDisplayFoldListener(IDisplayFoldListener listener) {
        if (this.mDisplayFoldController == null) goto L6;
        this.mDisplayFoldController.registerDisplayFoldListener(listener);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void unregisterDisplayFoldListener(IDisplayFoldListener listener) {
        if (this.mDisplayFoldController == null) goto L6;
        this.mDisplayFoldController.unregisterDisplayFoldListener(listener);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setOverrideFoldedArea(Rect area) {
        if (this.mDisplayFoldController == null) goto L6;
        this.mDisplayFoldController.setOverrideFoldedArea(area);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public Rect getFoldedArea() {
        if (this.mDisplayFoldController == null) goto L7;
        return this.mDisplayFoldController.getFoldedArea();
    L7:
        return new Rect();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void onDefaultDisplayFocusChangedLw(WindowManagerPolicy.WindowState newFocus) {
        if (this.mDisplayFoldController == null) goto L10;
        DisplayFoldController r0 = this.mDisplayFoldController;
        if (newFocus == null) goto L7;
        String r1 = newFocus.getOwningPackage();
    L8:
        r0.onDefaultDisplayFocusChanged(r1);
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void registerShortcutKey(long shortcutCode, IShortcutService shortcutService) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mModifierShortcutManager.registerShortcutKey(shortcutCode, shortcutService);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void togglePowerAndAiKey(boolean enable) {
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void onKeyguardOccludedChangedLw(boolean occluded) {
        if (this.mKeyguardDelegate == null) goto L6;
        this.mPendingKeyguardOccluded = occluded;
        this.mKeyguardOccludedChanged = true;
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public int applyKeyguardOcclusionChange() {
        if (setKeyguardOccludedLw(this.mPendingKeyguardOccluded) == false) goto L6;
        return 5;
    L6:
        return 0;
    }

    private int handleTransitionForKeyguardLw(boolean startKeyguardExitAnimation, boolean notifyOccluded) {
        int redoLayout = 0;
        if (notifyOccluded == false) goto L5;
        redoLayout = applyKeyguardOcclusionChange();
    L5:
        if (startKeyguardExitAnimation == false) goto L7;
        startKeyguardExitAnimation(SystemClock.uptimeMillis());
    L7:
        return redoLayout;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void showDismissibleKeyguard() {
        this.mKeyguardDelegate.showDismissibleKeyguard();
    }

    protected void launchAssistAction(String hint, int deviceId, long eventTime, int invocationType) {
        if (this.mUserManagerInternal.isUserUnlocked(0) == true) goto L6;
        return;
    L6:
        if (isUserSetupComplete() == true) goto L8;
        return;
    L8:
        Bundle args = new Bundle();
        if (deviceId == (-2)) goto L11;
        args.putInt("android.intent.extra.ASSIST_INPUT_DEVICE_ID", deviceId);
    L11:
        if (hint == null) goto L13;
        args.putBoolean(hint, true);
    L13:
        args.putLong("android.intent.extra.TIME", eventTime);
        args.putInt("invocation_type", invocationType);
        args.putBoolean("toggle_ai_button", getExt().isTogglePowerAndAiKey());
        this.mObricExt.adjustAssistBundle(args);
        SearchManager searchManager = (SearchManager) this.mContext.getSystemService(SearchManager.class);
        if (searchManager == null) goto L16;
        searchManager.launchAssist(args);
        return;
    L16:
        StatusBarManagerInternal statusBar = getStatusBarManagerInternal();
        if (statusBar == null) goto L21;
        statusBar.startAssist(args);
        return;
    }

    private void launchVoiceAssist(boolean allowDuringSetup) {
        if (this.mKeyguardDelegate != null) goto L5;
    L7:
        boolean keyguardActive = false;
    L9:
        if (keyguardActive == true) goto L11;
        startActivityAsUser(new Intent("android.intent.action.VOICE_ASSIST"), null, UserHandle.CURRENT_OR_SELF, allowDuringSetup);
        return;
    L11:
        this.mKeyguardDelegate.dismissKeyguardToLaunch(new Intent("android.intent.action.VOICE_ASSIST"));
        return;
    L5:
        if (this.mKeyguardDelegate.isShowing() == false) goto L7;
        keyguardActive = true;
        goto L9
    }

    private boolean isInRetailMode() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "device_demo_mode", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void startActivityAsUser(Intent intent, UserHandle handle) {
        startActivityAsUser(intent, null, handle);
    }

    private void startActivityAsUser(Intent intent, Bundle bundle, UserHandle handle) {
        startActivityAsUser(intent, bundle, handle, false);
    }

    private void startActivityAsUser(Intent intent, Bundle bundle, UserHandle handle, boolean allowDuringSetup) {
        if (allowDuringSetup == false) goto L4;
    L7:
        this.mContext.startActivityAsUser(intent, bundle, handle);
        dismissKeyboardShortcutsMenu();
        return;
    L4:
        if (isUserSetupComplete() == true) goto L7;
        Slog.i(TAG, "Not starting activity because user setup is in progress: " + intent);
    }

    private void preloadRecentApps() {
        this.mPreloadedRecentApps = true;
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.preloadRecentApps();
        return;
    }

    private void cancelPreloadRecentApps() {
        if (this.mPreloadedRecentApps == false) goto L8;
        this.mPreloadedRecentApps = false;
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L9;
        statusbar.cancelPreloadRecentApps();
        return;
    L9:
        return;
    }

    private void toggleTaskbar() {
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.toggleTaskbar();
        return;
    }

    private void toggleRecentApps() {
        this.mPreloadedRecentApps = false;
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.toggleRecentApps();
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void showRecentApps() {
        this.mHandler.removeMessages(9);
        this.mHandler.obtainMessage(9).sendToTarget();
    }

    private void showRecentApps(boolean triggeredFromAltTab) {
        this.mPreloadedRecentApps = false;
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L5;
        statusbar.showRecentApps(triggeredFromAltTab);
    L5:
        dismissKeyboardShortcutsMenu();
    }

    private void toggleKeyboardShortcutsMenu(int deviceId) {
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.toggleKeyboardShortcutsMenu(deviceId);
        return;
    }

    private void dismissKeyboardShortcutsMenu() {
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.dismissKeyboardShortcutsMenu();
        return;
    }

    private void hideRecentApps(boolean triggeredFromAltTab, boolean triggeredFromHome) {
        this.mPreloadedRecentApps = false;
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.hideRecentApps(triggeredFromAltTab, triggeredFromHome);
        return;
    }

    private void moveFocusedTaskToStageSplit(int displayId, boolean leftOrTop) {
        StatusBarManagerInternal statusbar = getStatusBarManagerInternal();
        if (statusbar == null) goto L6;
        statusbar.moveFocusedTaskToStageSplit(displayId, leftOrTop);
        return;
    }

    void launchHomeFromHotKey(int displayId) {
        launchHomeFromHotKey(displayId, true, true);
    }

    void launchHomeFromHotKey(final int displayId, final boolean awakenFromDreams, boolean respectKeyguard) {
        if (respectKeyguard == false) goto L13;
        if (isKeyguardShowingAndNotOccluded() == false) goto L7;
        return;
    L7:
        if (isKeyguardOccluded() == true) goto L13;
        if (this.mKeyguardDelegate.isInputRestricted() == false) goto L13;
        this.mKeyguardDelegate.verifyUnlock(new AnonymousClass16(this, displayId, awakenFromDreams));
        return;
    L13:
        if (this.mRecentsVisible == true) goto L15;
    L24:
        startDockOrHome(displayId, true, awakenFromDreams);
        return;
    L15:
        if (this.mVisibleBackgroundUsersEnabled == false) goto L26;
        if (displayId != 0) goto L24;
    L26:
        ActivityManager.getService().stopAppSwitches();     // Catch: RemoteException -> L19
    L21:
        if (awakenFromDreams == false) goto L23;
        awakenDreams();
    L23:
        hideRecentApps(false, true);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setRecentsVisibilityLw(boolean visible) {
        this.mRecentsVisible = visible;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setPipVisibilityLw(boolean visible) {
        this.mPictureInPictureVisible = visible;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setNavBarVirtualKeyHapticFeedbackEnabledLw(boolean enabled) {
        this.mNavBarVirtualKeyHapticFeedbackEnabled = enabled;
    }

    private boolean setKeyguardOccludedLw(boolean isOccluded) {
        this.mKeyguardOccludedChanged = false;
        this.mPendingKeyguardOccluded = isOccluded;
        this.mKeyguardDelegate.setOccluded(isOccluded, true);
        return this.mKeyguardDelegate.isShowing();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void notifyLidSwitchChanged(long r6, boolean r8) {
        if (r8 != this.mDefaultDisplayPolicy.getLidState()) goto L5;
        return;
    L5:
        this.mDefaultDisplayPolicy.setLidState(r8 ? 1 : 0);
        applyLidSwitchState();
        updateRotation(true);
        if (r8 == false) goto L9;
        this.mWindowWakeUpPolicy.wakeUpFromLid();
        return;
    L9:
        if (getLidBehavior() == 1) goto L13;
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), false);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void notifyCameraLensCoverSwitchChanged(long r7, boolean r9) {
        if (this.mCameraLensCoverState != r9) goto L6;
        return;
    L6:
        if (this.mContext.getResources().getBoolean(R.bool.config_letterboxIsHorizontalReachabilityEnabled) == true) goto L9;
        return;
    L9:
        if (this.mCameraLensCoverState != 1) goto L20;
        if (r9 == true) goto L20;
        if (this.mKeyguardDelegate != null) goto L14;
        boolean r1 = false;
    L16:
        if (r1 == false) goto L18;
        Intent r2 = new Intent("android.media.action.STILL_IMAGE_CAMERA_SECURE");
    L19:
        this.mWindowWakeUpPolicy.wakeUpFromCameraCover(r7 / 1000000);
        startActivityAsUser(r2, UserHandle.CURRENT_OR_SELF);
        goto L20
    L18:
        r2 = new Intent("android.media.action.STILL_IMAGE_CAMERA");
        goto L19
    L14:
        r1 = this.mKeyguardDelegate.isShowing();
    L20:
        this.mCameraLensCoverState = r9 ? 1 : 0;
    }

    void initializeHdmiState() {
        int oldMask = StrictMode.allowThreadDiskReadsMask();
        initializeHdmiStateInternal();     // Catch: Throwable -> L6
        StrictMode.setThreadPolicyMask(oldMask);
        return;
    L6:
        th = move-exception;
        StrictMode.setThreadPolicyMask(oldMask);
        throw th;
    }

    void initializeHdmiStateInternal() {
        boolean plugged = false;
        this.mExtEventObserver.startObserving("mdss_mdp/drm/card");
        this.mHDMISwitchObserver.startObserving("change@/devices/virtual/graphics/fb2");
        boolean r4 = false;
        if (new File("/sys/devices/virtual/switch/hdmi/state").exists() == false) goto L38;
        this.mHDMIObserver.startObserving("DEVPATH=/devices/virtual/switch/hdmi");
        FileReader reader = null;
        reader = new FileReader("/sys/class/switch/hdmi/state");     // Catch: Throwable -> L11 NumberFormatException -> L13 IOException -> L15
        char[] buf = new char[15];     // Catch: Throwable -> L11 NumberFormatException -> L13 IOException -> L15
        int n = reader.read(buf);     // Catch: Throwable -> L11 NumberFormatException -> L13 IOException -> L15
        if (n <= 1) goto L18;
        if (Integer.parseInt(new String(buf, 0, n - 1)) == 0) goto L10;
        r4 = true;
    L10:
        plugged = r4;
        goto L18
    L18:
        reader.close();     // Catch: IOException -> L20
    L13:
        ex = move-exception;
        Slog.w(TAG, "Couldn't read hdmi state from /sys/class/switch/hdmi/state: " + ex);     // Catch: Throwable -> L11
        if (reader == null) goto L41;
        reader.close();     // Catch: IOException -> L20
    L15:
        ex = move-exception;
        Slog.w(TAG, "Couldn't read hdmi state from /sys/class/switch/hdmi/state: " + ex);     // Catch: Throwable -> L11
        if (reader == null) goto L41;
        reader.close();     // Catch: IOException -> L20
    L11:
        th = move-exception;
        if (0 != 0) goto L44;
    L37:
        throw th;
    L44:
        reader.close();     // Catch: IOException -> L36
    L41:
        this.mDefaultDisplayPolicy.setHdmiPlugged(plugged, true);
        return;
    L38:
        List<ExtconUEventObserver.ExtconInfo> extcons = ExtconUEventObserver.ExtconInfo.getExtconInfoForTypes(new String[]{ExtconUEventObserver.ExtconInfo.EXTCON_HDMI});
        if (extcons.isEmpty() == true) goto L41;
        HdmiVideoExtconUEventObserver observer = new HdmiVideoExtconUEventObserver(this, null);
        plugged = HdmiVideoExtconUEventObserver.m7256$$Nest$minit(observer, extcons.get(0));
        this.mHDMIObserver = observer;
        goto L41
    }

    private void notifyForcePowerOff() {
        Parcel data = null;
        IBinder stabdProxy = ServiceManager.getService(STAB_SERVICE_NAME);     // Catch: Throwable -> L7 RemoteException -> L9
        if (stabdProxy == null) goto L11;
        data = Parcel.obtain();     // Catch: Throwable -> L7 RemoteException -> L9
        data.writeInterfaceToken(FORCE_POWEROFF_INTERFACE_TOKEN);     // Catch: Throwable -> L7 RemoteException -> L9
        long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L7 RemoteException -> L9
        long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7 RemoteException -> L9
        data.writeLong(currentTime);     // Catch: Throwable -> L7 RemoteException -> L9
        data.writeLong(uptime);     // Catch: Throwable -> L7 RemoteException -> L9
        stabdProxy.transact(24, data, null, 0);     // Catch: Throwable -> L7 RemoteException -> L9
    L11:
        if (data == null) goto L17;
    L12:
        data.recycle();
        return;
    L17:
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "[ForcePowerOff] notifyForcePowerOff failure:" + e);     // Catch: Throwable -> L7
        if (data != null) goto L12;
        return;
    L7:
        th = move-exception;
        if (data == null) goto L20;
        data.recycle();
    L20:
        throw th;
    }

    private void handleForcePoweroffKeyEvent(int keyCode, boolean down, long downtime) {
        if (keyCode == 26) goto L5;
        return;
    L5:
        powerKeyDown = down;
        if (forcePoweroffHandler != null) goto L19;
        Object r0 = UPLOAD_LOCK;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (forcePoweroffHandler != null) goto L14;
        HandlerThread forcePoweroffThread = new HandlerThread("ForcePoweroffThread");     // Catch: Throwable -> L12
        forcePoweroffThread.start();     // Catch: Throwable -> L12
        forcePoweroffHandler = new Handler(forcePoweroffThread.getLooper());     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
    L19:
        if (powerKeyDown == false) goto L28;
        if (forcePoweroffRunnable != null) goto L33;
        long currentTime = SystemClock.uptimeMillis();
        long timeToLastLog = currentTime - lastLogCaptureTime;
        if (timeToLastLog > LOG_CAPTURE_COOLDOWN_MS) goto L26;
        Slog.i(TAG, "[ForcePowerOff] Skip log capture, last capture time: " + lastLogCaptureTime + ", currTime: " + currentTime);
        return;
    L26:
        forcePoweroffRunnable = new PhoneWindowManager$$ExternalSyntheticLambda5(this);
        forcePoweroffHandler.postDelayed(forcePoweroffRunnable, 2000);
        return;
    L33:
        return;
    L28:
        if (forcePoweroffRunnable == null) goto L35;
        forcePoweroffHandler.removeCallbacks(forcePoweroffRunnable);
        forcePoweroffRunnable = null;
        return;
    }

    private /* synthetic */ void lambda$handleForcePoweroffKeyEvent$6() {
        if (powerKeyDown == false) goto L6;
        lastLogCaptureTime = SystemClock.uptimeMillis();
        Slog.i(TAG, "[ForcePowerOff] capture force power log, time: " + lastLogCaptureTime);
        notifyForcePowerOff();
        Slog.i(TAG, "[ForcePowerOff] end capture force power log, time: " + SystemClock.uptimeMillis());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.policy.WindowManagerPolicy
    public int interceptKeyBeforeQueueing(KeyEvent r38, int r39) {
        int r4 = r38.getKeyCode();
        if (r38.getAction() != 0) goto L5;
        boolean r0 = true;
    L6:
        boolean r7 = r0;
        if ((r39 & 1) == 0) goto L9;
    L12:
        boolean r1 = true;
    L14:
        if ((262144 & r39) == 0) goto L16;
        boolean r8 = true;
    L18:
        if (r4 != 26) goto L21;
        handleForcePoweroffKeyEvent(r4, r7, r38.getDownTime());
    L21:
        if (this.mVisibleBackgroundUsersEnabled == false) goto L28;
        if (KeyEvent.isVisibleBackgroundUserAllowedKey(r4) == true) goto L28;
        if (isKeyEventForCurrentUser(r38.getDisplayId(), r4, null) == true) goto L28;
        return 0;
    L28:
        if (this.mSystemBooted == true) goto L47;
        boolean r6 = false;
        if (r7 == false) goto L34;
        if (r4 == 26) goto L33;
        if (r4 != 177) goto L34;
    L33:
        wakeUpFromWakeKey(r38);
        r6 = true;
    L41:
        if (r6 == false) goto L45;
        HdmiControl r9 = getHdmiControl();
        if (r9 == null) goto L45;
        r9.turnOnTv();
    L45:
        return 0;
    L34:
        if (r7 == false) goto L41;
        if (r1 == true) goto L39;
        if (r4 != 224) goto L41;
    L39:
        if (isWakeKeyWhenScreenOff(r4) == false) goto L41;
        wakeUpFromWakeKey(r38);
        r6 = true;
        goto L41
    L47:
        if (this.mGameKeysCtrl == null) goto L52;
        int r10 = this.mGameKeysCtrl.interceptKeyBeforeQueueing(r38, r39, isScreenOn());
        if (this.mGameKeysCtrl.isFinishKeyBeforQueueing(r10) == false) goto L52;
        return r10;
    L52:
        if (26 == r38.getKeyCode()) goto L56;
        if (342 == r38.getKeyCode()) goto L56;
    L60:
        if (this.mExt.interceptKeyBeforeQueueing(r38, r4) == false) goto L63;
        return 0;
    L63:
        if ((536870912 & r39) == 0) goto L65;
        boolean r11 = true;
    L66:
        boolean r14 = r38.isCanceled();
        int r15 = r38.getDisplayId();
        if ((r39 & 16777216) == 0) goto L69;
        Object[] r16 = true;
    L71:
        if (this.mKeyguardDelegate == null) goto L79;
        if (r11 == false) goto L77;
        if (isKeyguardShowingAndNotOccluded() == false) goto L79;
    L78:
        boolean r12 = true;
    L80:
        Log.d(TAG, "interceptKeyTq keycode=" + r4 + " interactive=" + r11 + " keyguardActive=" + r12 + " policyFlags=" + Integer.toHexString(r39));
        if (r11 == true) goto L98;
        if (r16 == false) goto L86;
        if (r1 == false) goto L98;
    L86:
        if (shouldDispatchInputWhenNonInteractive(r15, r4) == false) goto L88;
        int r13 = 1;
        this.mPendingWakeKey = -1;
        boolean r17 = r1;
    L107:
        if (isValidGlobalKey(r4) == true) goto L109;
    L119:
        HdmiControlManager r22 = getHdmiControlManager();
        if (r4 == 177) goto L122;
    L129:
        boolean r18 = Display.isOnState(this.mDefaultDisplay.getState());
        boolean r23 = this.mDefaultDisplayPolicy.isAwake();
        if (r11 == false) goto L133;
        if (r23 == false) goto L133;
        boolean r2 = true;
    L134:
        boolean r24 = r2;
        if (r8 == false) goto L138;
        this.mSingleKeyGestureDetector.reset();
        boolean r3 = r24;
    L145:
        if ((r38.getFlags() & 64) == 0) goto L147;
        boolean r5 = true;
    L148:
        boolean r20 = r5;
        if (r7 == true) goto L151;
    L158:
        boolean r19 = false;
    L159:
        boolean r25 = r19;
        switch(r4) {
            case 4: goto L321;
            case 5: goto L313;
            case 6: goto L291;
            case 24: goto L238;
            case 25: goto L238;
            case 26: goto L234;
            case 79: goto L228;
            case 85: goto L228;
            case 86: goto L228;
            case 87: goto L228;
            case 88: goto L228;
            case 89: goto L228;
            case 90: goto L228;
            case 91: goto L223;
            case 126: goto L228;
            case 127: goto L228;
            case 130: goto L228;
            case 164: goto L238;
            case 171: goto L214;
            case 177: goto L209;
            case 219: goto L201;
            case 222: goto L228;
            case 223: goto L193;
            case 224: goto L192;
            case 231: goto L189;
            case 264: goto L181;
            case 276: goto L176;
            case 280: goto L175;
            case 281: goto L175;
            case 282: goto L175;
            case 283: goto L175;
            case 289: goto L174;
            case 290: goto L174;
            case 291: goto L174;
            case 292: goto L174;
            case 293: goto L174;
            case 294: goto L174;
            case 295: goto L174;
            case 296: goto L174;
            case 297: goto L174;
            case 298: goto L174;
            case 299: goto L174;
            case 300: goto L174;
            case 301: goto L174;
            case 302: goto L174;
            case 303: goto L174;
            case 304: goto L174;
            case 308: goto L170;
            case 309: goto L170;
            case 310: goto L170;
            case 311: goto L170;
            case 313: goto L169;
            case 314: goto L169;
            case 315: goto L169;
            case 316: goto L169;
            case 319: goto L168;
            case 320: goto L168;
            case 321: goto L168;
            case 323: goto L168;
            case 326: goto L168;
            case 327: goto L168;
            case 328: goto L168;
            case 329: goto L168;
            case 330: goto L168;
            case 331: goto L168;
            case 332: goto L168;
            case 333: goto L168;
            case 334: goto L168;
            case 335: goto L168;
            case 336: goto L168;
            case 337: goto L168;
            case 338: goto L167;
            case 339: goto L166;
            case 342: goto L162;
            default: goto L161;
        };
    L161:
        r11 = r11;
    L339:
        if (r25 == true) goto L341;
    L347:
        if (r17 == false) goto L349;
        wakeUpFromWakeKey(r38);
    L349:
        if (r11 == true) goto L356;
        if (r16 == false) goto L356;
        if (r17 == true) goto L356;
        if ((r13 & 1) == 0) goto L356;
        Slog.i(TAG, "Drop injected non-wake key when non-interactive: keyCode=" + r4 + " policyFlags=" + Integer.toHexString(r39));
        r13 = r13 & (-2);
    L356:
        if ((r13 & 1) != 0) goto L358;
    L362:
        return r13;
    L358:
        if (r15 == (-1)) goto L362;
        if (r15 == this.mTopFocusedDisplayId) goto L362;
        Log.i(TAG, "Attempting to move non-focused display " + r15 + " to top because a key is targeting it");
        this.mWindowManagerFuncs.moveDisplayToTopIfAllowed(r15);
        goto L362
    L341:
        if (r4 != 4) goto L343;
    L346:
        performHapticFeedback(1, "Virtual Key - Press");
        goto L347
    L343:
        if (r4 == 3) goto L346;
        if (r4 != 187) goto L347;
    L162:
        if (r7 == false) goto L165;
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), false);
    L165:
        r13 = r13 & (-2);
        r11 = r11;
        goto L339
    L166:
        getExt().onHandleKeycodeClick(r38);
        r11 = r11;
        goto L339
    L167:
        getExt().onHandleKeycodeDoubleClick(r7, r38.getEventTime());
        r11 = r11;
        goto L339
    L168:
        r11 = r11;
        goto L339
    L169:
        r13 = r13 & (-2);
        r11 = r11;
        goto L339
    L170:
        Slog.i(TAG, "Stylus buttons event: " + r4 + " received. Should handle event? " + this.mStylusButtonsEnabled);
        if (this.mStylusButtonsEnabled == false) goto L173;
        sendSystemKeyToStatusBarAsync(r38);
    L173:
        r13 = r13 & (-2);
        r11 = r11;
        goto L339
    L174:
        r13 = r13 & (-2);
        r11 = r11;
        goto L339
    L175:
        notifyKeyGestureCompletedOnActionUp(r38, 35);
        r13 = r13 & (-2);
        interceptSystemNavigationKey(r38);
        r11 = r11;
        goto L339
    L176:
        notifyKeyGestureCompletedOnActionUp(r38, 36);
        r13 = r13 & (-2);
        r17 = false;
        if (r7 == true) goto L179;
        this.mPowerManagerInternal.setUserInactiveOverrideFromWindowManager();
    L179:
        sendSystemKeyToStatusBarAsync(r38);
        r11 = r11;
        goto L339
    L192:
        notifyKeyGestureCompletedOnActionUp(r38, 37);
        r13 = r13 & (-2);
        r17 = true;
        r11 = r11;
        goto L339
    L193:
        notifyKeyGestureCompletedOnActionUp(r38, 36);
        r13 = r13 & (-2);
        r17 = false;
        if (this.mPowerManager.isInteractive() == true) goto L196;
        r25 = false;
    L196:
        if (r7 == false) goto L198;
        sleepPress();
    L199:
        sendSystemKeyToStatusBarAsync(r38);
        r11 = r11;
        goto L339
    L198:
        sleepRelease(r38.getEventTime());
        goto L199
    L209:
        r11 = r11;
        notifyKeyGestureCompletedOnActionUp(r38, 34);
        r13 = r13 & (-2);
        r17 = false;
        if (r7 == false) goto L339;
        if (r22 == null) goto L339;
        r22.toggleAndFollowTvPower();
        goto L339
    L214:
        r11 = r11;
        if (this.mShortPressOnWindowBehavior != 1) goto L339;
        if (this.mPictureInPictureVisible == false) goto L339;
        if (r7 == true) goto L220;
        showPictureInPictureMenu(r38);
    L220:
        r13 = r13 & (-2);
        goto L339
    L223:
        r11 = r11;
        r13 = r13 & (-2);
        if (r7 == false) goto L339;
        if (r38.getRepeatCount() != 0) goto L339;
        notifyKeyGestureCompleted(r38, 26);
        toggleMicrophoneMuteFromKey();
        goto L339
    L228:
        r11 = r11;
        notifyKeyGestureCompletedOnActionUp(r38, 38);
        if (MediaSessionLegacyHelper.getHelper(this.mContext).isGlobalPriorityActive() == false) goto L232;
        r13 = r13 & (-2);
    L232:
        if ((r13 & 1) != 0) goto L339;
        this.mBroadcastWakeLock.acquire();
        Message r21 = this.mHandler.obtainMessage(3, new KeyEvent(r38));
        r21.setAsynchronous(true);
        r21.sendToTarget();
        goto L339
    L234:
        r11 = r11;
        notifyKeyGestureCompletedOnActionUp(r38, 34);
        String r26 = KeyEvent.actionToString(r38.getAction());
        boolean r27 = this.mPowerKeyHandled;
        EventLogTags.writeInterceptPower(r26, r27 ? 1 : 0, this.mSingleKeyGestureDetector.getKeyPressCounter(26));
        r13 = r13 & (-2);
        r17 = false;
        if (r7 == false) goto L237;
        interceptPowerKeyDown(r38, r3, r8);
        goto L339
    L237:
        interceptPowerKeyUp(r38, r14);
        goto L339
    L238:
        r11 = r11;
        if (r4 != 25) goto L242;
        int r28 = 19;
    L245:
        notifyKeyGestureCompletedOnActionDown(r38, r28);
        if (r7 == false) goto L283;
        sendSystemKeyToStatusBarAsync(r38);
        NotificationManager r29 = getNotificationService();
        if (r29 != null) goto L250;
    L252:
        TelecomManager r110 = getTelecommService();
        if (r110 != null) goto L255;
    L259:
        AtomicInteger r30 = new AtomicInteger(r13);
        if (this.mExt.interceptVolumeKeyWhenIsDreaming(r30, r38) == false) goto L363;
        r13 = r30.get();
    L363:
        int r31 = getAudioService().getMode();     // Catch: Exception -> L265
    L267:
        if (r110 == null) goto L271;
        if (r110.isInCall() == false) goto L271;
    L272:
        boolean r32 = true;
    L274:
        if (r32 == false) goto L279;
        if ((r13 & 1) != 0) goto L279;
        MediaSessionLegacyHelper.getHelper(this.mContext).sendVolumeKeyEvent(r38, Integer.MIN_VALUE, false);
    L279:
        if (this.mExt.interceptVolumeKeyWhenNotPassToUser(r13, r38) == false) goto L283;
    L271:
        if (r31 == 3) goto L272;
        r32 = false;
    L265:
        e = move-exception;
        Log.e(TAG, "Error getting AudioService in interceptKeyBeforeQueueing.", e);
        r31 = 0;
        goto L267
    L255:
        if (this.mHandleVolumeKeysInWM == true) goto L259;
        if (r110.isRinging() == false) goto L259;
        Log.i(TAG, "interceptKeyBeforeQueueing: VOLUME key-down while ringing: Silence ringer!");
        r110.silenceRinger();
        r13 = r13 & (-2);
        goto L339
    L250:
        if (this.mHandleVolumeKeysInWM == true) goto L252;
        r29.silenceNotificationSound();
    L283:
        if (this.mUseTvRouting == false) goto L285;
    L290:
        r13 = r13 | 1;
        goto L339
    L285:
        if (this.mHandleVolumeKeysInWM == true) goto L290;
        if ((r13 & 1) != 0) goto L339;
        MediaSessionLegacyHelper.getHelper(this.mContext).sendVolumeKeyEvent(r38, Integer.MIN_VALUE, true);
        goto L339
    L242:
        if (r4 != 24) goto L244;
        r28 = 18;
        goto L245
    L244:
        r28 = 20;
        goto L245
    L291:
        r11 = r11;
        r13 = r13 & (-2);
        if (r7 == false) goto L302;
        TelecomManager r33 = getTelecommService();
        boolean r34 = false;
        if (r33 == null) goto L296;
        r34 = r33.endCall();
    L296:
        if (r11 == false) goto L299;
        if (r34 == true) goto L299;
        this.mEndCallKeyHandled = false;
        this.mHandler.postDelayed(this.mEndCallLongPress, ViewConfiguration.get(this.mContext).getDeviceGlobalActionKeyTimeout());
    L299:
        this.mEndCallKeyHandled = true;
        goto L339
    L302:
        if (this.mEndCallKeyHandled == true) goto L339;
        this.mHandler.removeCallbacks(this.mEndCallLongPress);
        if (r14 == true) goto L339;
        if ((this.mEndcallBehavior & 1) == 0) goto L311;
        if (goHome() == true) goto L339;
    L311:
        if ((this.mEndcallBehavior & 2) == 0) goto L339;
        sleepDefaultDisplay(r38.getEventTime(), 4, 0);
        r17 = false;
        goto L339
    L313:
        r11 = r11;
        if (r7 == false) goto L339;
        TelecomManager r35 = getTelecommService();
        if (r35 == null) goto L339;
        if (r35.isRinging() == false) goto L339;
        Log.i(TAG, "interceptKeyBeforeQueueing: CALL key-down while ringing: Answer the call!");
        r35.acceptRingingCall();
        r13 = r13 & (-2);
        goto L339
    L321:
        r11 = r11;
        notifyKeyGestureCompletedOnActionUp(r38, 3);
        if (getISmtEx().isGlobalActionShown() == false) goto L324;
    L327:
        Slog.d(TAG, "sendCloseSystemWindows due to backkey");
        if (r7 == false) goto L330;
        sendCloseSystemWindows("backkey");
    L330:
        r13 = r13 & (-2);
    L331:
        if (r7 == false) goto L334;
        this.mWindowManagerInternal.moveFocusToAdjacentEmbeddedActivityIfNeeded();
        this.mBackKeyHandled = false;
        goto L339
    L334:
        if (hasLongPressOnBackBehavior() == true) goto L337;
        this.mBackKeyHandled |= backKeyPress();
    L337:
        if (this.mBackKeyHandled == false) goto L339;
        r13 = r13 & (-2);
        goto L339
    L324:
        if (this.mDefaultDisplayPolicy.mScreenshotHelper == null) goto L331;
        if (this.mDefaultDisplayPolicy.mScreenshotHelper.isScreenshotVisible() == false) goto L331;
    L181:
        if (r7 == true) goto L183;
    L187:
        r11 = r11;
        goto L339
    L183:
        if (r38.getRepeatCount() != 0) goto L187;
        if ((r13 & 1) != 0) goto L187;
        setDeferredKeyActionsExecutableAsync(r4, r38.getDownTime());
        r11 = r11;
        goto L339
    L189:
        if (r7 == true) goto L191;
        this.mBroadcastWakeLock.acquire();
        Message r36 = this.mHandler.obtainMessage(12);
        r36.setAsynchronous(true);
        r36.sendToTarget();
        notifyKeyGestureCompleted(r38, 6);
    L191:
        r13 = r13 & (-2);
        r11 = r11;
        goto L339
    L201:
        if (r38.getRepeatCount() <= 0) goto L203;
        boolean r37 = true;
    L204:
        if (r7 == false) goto L208;
        if (r37 == true) goto L208;
        Message r40 = this.mHandler.obtainMessage(23, r38.getDeviceId(), 0, Long.valueOf(r38.getEventTime()));
        r40.setAsynchronous(true);
        r40.sendToTarget();
        notifyKeyGestureCompleted(r38, 5);
    L208:
        r13 = r13 & (-2);
        goto L339
    L203:
        r37 = false;
        goto L204
    L151:
        if ((r39 & 2) == 0) goto L158;
        if (r20 == false) goto L156;
        if (this.mNavBarVirtualKeyHapticFeedbackEnabled == false) goto L158;
    L156:
        if (r38.getRepeatCount() != 0) goto L158;
        r19 = true;
        goto L159
    L147:
        r5 = false;
        goto L148
    L138:
        if ((r38.getFlags() & 1024) == 0) goto L140;
        r3 = r24;
        goto L145
    L140:
        if (r38.getKeyCode() != 342) goto L142;
        this.mSmtEx.interceptAiKey(r38, r7);
    L142:
        r3 = r24;
        handleKeyGesture(r38, r3, r18);
    L133:
        r2 = false;
        goto L134
    L122:
        if (this.mHasFeatureLeanback == false) goto L129;
        if (r22 == null) goto L128;
        if (r22.shouldHandleTvPowerKey() == true) goto L129;
    L128:
        return interceptKeyBeforeQueueing(KeyEvent.obtain(r38.getDownTime(), r38.getEventTime(), r38.getAction(), 26, r38.getRepeatCount(), r38.getMetaState(), r38.getDeviceId(), r38.getScanCode(), r38.getFlags(), r38.getSource(), r38.getDisplayId(), null), r39);
    L109:
        if (this.mGlobalKeyManager.shouldHandleGlobalKey(r4) == false) goto L119;
        if (r11 == true) goto L116;
        if (r17 == false) goto L116;
        if (r7 == false) goto L116;
        if (this.mGlobalKeyManager.shouldDispatchFromNonInteractive(r4) == false) goto L116;
        this.mGlobalKeyManager.setBeganFromNonInteractive();
        r13 = 1;
        this.mPendingWakeKey = -1;
    L116:
        if (r17 == false) goto L118;
        wakeUpFromWakeKey(r38);
    L118:
        return r13;
    L88:
        r13 = 0;
        if (r1 == false) goto L94;
        if (r7 == true) goto L92;
    L93:
        r1 = false;
        goto L94
    L92:
        if (isWakeKeyWhenScreenOff(r4) == false) goto L93;
    L94:
        if (r1 == false) goto L97;
        if (r7 == false) goto L97;
        this.mPendingWakeKey = r4;
    L97:
        r17 = r1;
    L98:
        r13 = 1;
        if (r11 == true) goto L101;
        r17 = false;
        goto L107
    L101:
        if (r4 != this.mPendingWakeKey) goto L104;
        if (r7 == true) goto L104;
        r13 = 0;
    L104:
        this.mPendingWakeKey = -1;
        r17 = false;
        goto L107
    L77:
        if (this.mKeyguardDelegate.isShowing() == true) goto L78;
    L79:
        r12 = false;
        goto L80
    L69:
        r16 = false;
        goto L71
    L65:
        r11 = false;
    L56:
        if (FACTORY_TEST_KEY_ACTIVITY.equals(getTopActivityName(this.mContext)) == false) goto L60;
        Log.w(TAG, "factorykittest power or QMMI KeyActivity power");
        return 1;
    L16:
        r8 = false;
        goto L18
    L9:
        if (r38.isWakeKey() == true) goto L12;
        r1 = false;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    private void handleKeyGesture(KeyEvent event, boolean interactive, boolean defaultDisplayOn) {
        if (InputSettings.doesKeyGestureEventHandlerSupportMultiKeyGestures() == true) goto L9;
        if (this.mKeyCombinationManager.interceptKey(event, interactive) == false) goto L9;
        this.mSingleKeyGestureDetector.reset();
        return;
    L9:
        if (event.getKeyCode() == 26) goto L11;
    L16:
        this.mSingleKeyGestureDetector.interceptKey(event, interactive, defaultDisplayOn);
        return;
    L11:
        if (event.getAction() != 0) goto L16;
        this.mPowerKeyHandled = handleCameraGesture(event, interactive);
        if (this.mPowerKeyHandled == false) goto L16;
        this.mSingleKeyGestureDetector.reset();
    }

    private boolean handleCameraGesture(KeyEvent event, boolean interactive) {
        if (this.mGestureLauncherService != null) goto L5;
        return false;
    L5:
        this.mPowerButtonLaunchGestureTriggered = false;
        MutableBoolean outLaunched = new MutableBoolean(false);
        boolean intercept = this.mGestureLauncherService.interceptPowerKeyDown(event, interactive, outLaunched);
        if (outLaunched.value == true) goto L8;
        return intercept;
    L8:
        this.mPowerButtonLaunchGestureTriggered = true;
        if (this.mRequestedOrSleepingDefaultDisplay == false) goto L11;
        this.mPowerButtonLaunchGestureTriggeredDuringGoingToSleep = true;
        this.mWindowWakeUpPolicy.wakeUpFromPowerKeyCameraGesture();
    L11:
        return true;
    }

    private void interceptSystemNavigationKey(KeyEvent event) {
        if (event.getAction() == 1) goto L5;
        return;
    L5:
        if (this.mAccessibilityManager.isEnabled() == false) goto L9;
        if (this.mAccessibilityManager.sendFingerprintGesture(event.getKeyCode()) == false) goto L9;
        return;
    L9:
        if (this.mSystemNavigationKeysEnabled == false) goto L14;
        sendSystemKeyToStatusBarAsync(event);
        return;
    }

    private void sendSystemKeyToStatusBar(KeyEvent key) {
        if (isKeyEventForCurrentUser(key.getDisplayId(), key.getKeyCode(), "handleSystemKey") == true) goto L5;
        return;
    L5:
        IStatusBarService statusBar = getStatusBarService();
        if (statusBar == null) goto L13;
        statusBar.handleSystemKey(key);     // Catch: RemoteException -> L9
        return;
    L10:
        return;
    }

    private void sendSystemKeyToStatusBarAsync(KeyEvent keyEvent) {
        Message message = this.mHandler.obtainMessage(21, KeyEvent.obtain(keyEvent));
        message.setAsynchronous(true);
        this.mHandler.sendMessage(message);
    }

    static boolean isValidGlobalKey(int keyCode) {
        switch(keyCode) {
            case 26: goto L5;
            case 223: goto L5;
            case 224: goto L5;
            default: goto L3;
        };
    L3:
        return true;
    L5:
        return false;
    }

    private boolean isWakeKeyWhenScreenOff(int keyCode) {
        switch(keyCode) {
            case 4: goto L12;
            case 19: goto L10;
            case 20: goto L10;
            case 21: goto L10;
            case 22: goto L10;
            case 23: goto L10;
            case 219: goto L8;
            case 308: goto L6;
            case 309: goto L6;
            case 310: goto L6;
            case 311: goto L6;
            default: goto L3;
        };
    L3:
        return true;
    L6:
        return this.mStylusButtonsEnabled;
    L8:
        return this.mWakeOnAssistKeyPress;
    L10:
        return this.mWakeOnDpadKeyPress;
    L12:
        return this.mWakeOnBackKeyPress;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public int interceptMotionBeforeQueueingNonInteractive(int displayId, int source, int action, long whenNanos, int policyFlags) {
        if ((policyFlags & 1) == 0) goto L12;
        WindowWakeUpPolicy r5 = this.mWindowWakeUpPolicy;
        long r7 = whenNanos / 1000000;
        if (action != 0) goto L7;
        boolean r10 = true;
    L9:
        if (r5.wakeUpFromMotion(displayId, r7, source, r10, this.mDeviceGoingToSleep) == false) goto L12;
        return 1;
    L7:
        r10 = false;
    L12:
        if (shouldDispatchInputWhenNonInteractive(displayId, 0) == false) goto L15;
        return 1;
    L15:
        if (isTheaterModeEnabled() == true) goto L17;
    L25:
        return 0;
    L17:
        if ((policyFlags & 1) == 0) goto L25;
        WindowWakeUpPolicy r6 = this.mWindowWakeUpPolicy;
        long r8 = whenNanos / 1000000;
        if (action != 0) goto L21;
        boolean r11 = true;
    L23:
        if (r6.wakeUpFromMotion(displayId, r8, source, r11, this.mDeviceGoingToSleep) == false) goto L25;
        return 1;
    L21:
        r11 = false;
        goto L23
    }

    protected boolean shouldDispatchInputWhenNonInteractive(int displayId, int keyCode) {
        if (displayId != 0) goto L5;
    L8:
        boolean isDefaultDisplay = true;
    L9:
        if (isDefaultDisplay == false) goto L11;
        Display display = this.mDefaultDisplay;
    L13:
        if (display != null) goto L15;
    L18:
        boolean displayOff = true;
    L20:
        if (displayOff == false) goto L23;
        return false;
    L23:
        if (isKeyguardShowingAndNotOccluded() == false) goto L25;
        return true;
    L25:
        if (isDefaultDisplay == false) goto L34;
        IDreamManager dreamManager = getDreamManager();
        if (dreamManager == null) goto L34;
        if (dreamManager.isDreaming() == false) goto L34;
        return true;
    L31:
        e = move-exception;
        Slog.e(TAG, "RemoteException when checking if dreaming", e);
    L34:
        return false;
    L15:
        if (display.getState() == 1) goto L18;
        displayOff = false;
        goto L20
    L11:
        display = this.mDisplayManager.getDisplay(displayId);
        goto L13
    L5:
        if (displayId == (-1)) goto L8;
        isDefaultDisplay = false;
        goto L9
    }

    void dispatchDirectAudioEvent(KeyEvent event) {
        HdmiControlManager hdmiControlManager = getHdmiControlManager();
        if (hdmiControlManager != null) goto L5;
    L21:
        getAudioService().handleVolumeKey(event, this.mUseTvRouting, this.mContext.getOpPackageName(), TAG);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Log.e(TAG, "Error dispatching volume key in handleVolumeKey for event:" + event, e);
        return;
    L5:
        if (hdmiControlManager.getSystemAudioMode() == true) goto L21;
        if (shouldCecAudioDeviceForwardVolumeKeysSystemAudioModeOff() == false) goto L21;
        HdmiAudioSystemClient audioSystemClient = hdmiControlManager.getAudioSystemClient();
        if (audioSystemClient == null) goto L21;
        int r0 = event.getKeyCode();
        if (event.getAction() != 0) goto L13;
        boolean r3 = true;
    L14:
        audioSystemClient.sendKeyEvent(r0, r3);
        return;
    L13:
        r3 = false;
        goto L14
    }

    private HdmiControlManager getHdmiControlManager() {
        if (this.mHasFeatureHdmiCec == true) goto L7;
        return null;
    L7:
        return (HdmiControlManager) this.mContext.getSystemService(HdmiControlManager.class);
    }

    private boolean shouldCecAudioDeviceForwardVolumeKeysSystemAudioModeOff() {
        return RoSystemProperties.CEC_AUDIO_DEVICE_FORWARD_VOLUME_KEYS_SYSTEM_AUDIO_MODE_OFF;
    }

    void dispatchMediaKeyWithWakeLock(KeyEvent event) {
        if (this.mHavePendingMediaKeyRepeatWithWakeLock == false) goto L5;
        this.mHandler.removeMessages(4);
        this.mHavePendingMediaKeyRepeatWithWakeLock = false;
        this.mBroadcastWakeLock.release();
    L5:
        dispatchMediaKeyWithWakeLockToAudioService(event);
        if (event.getAction() == 0) goto L8;
    L10:
        this.mBroadcastWakeLock.release();
        return;
    L8:
        if (event.getRepeatCount() != 0) goto L10;
        this.mHavePendingMediaKeyRepeatWithWakeLock = true;
        Message msg = this.mHandler.obtainMessage(4, event);
        msg.setAsynchronous(true);
        this.mHandler.sendMessageDelayed(msg, ViewConfiguration.getKeyRepeatTimeout());
    }

    void dispatchMediaKeyRepeatWithWakeLock(KeyEvent event) {
        this.mHavePendingMediaKeyRepeatWithWakeLock = false;
        KeyEvent repeatEvent = KeyEvent.changeTimeRepeat(event, SystemClock.uptimeMillis(), 1, event.getFlags() | 128);
        dispatchMediaKeyWithWakeLockToAudioService(repeatEvent);
        this.mBroadcastWakeLock.release();
    }

    void dispatchMediaKeyWithWakeLockToAudioService(KeyEvent event) {
        if (this.mActivityManagerInternal.isSystemReady() == false) goto L6;
        MediaSessionLegacyHelper.getHelper(this.mContext).sendMediaButtonEvent(event, true);
        return;
    }

    void launchVoiceAssistWithWakeLock() {
        sendCloseSystemWindows(SYSTEM_DIALOG_REASON_ASSIST);
        if (keyguardOn() == true) goto L5;
        Intent voiceIntent = new Intent("android.speech.action.WEB_SEARCH");
    L9:
        startActivityAsUser(voiceIntent, UserHandle.CURRENT_OR_SELF);
        this.mBroadcastWakeLock.release();
        return;
    L5:
        DeviceIdleManager dim = (DeviceIdleManager) this.mContext.getSystemService(DeviceIdleManager.class);
        if (dim == null) goto L8;
        dim.endIdle("voice-search");
    L8:
        Intent voiceIntent2 = new Intent("android.speech.action.VOICE_SEARCH_HANDS_FREE");
        voiceIntent2.putExtra("android.speech.extras.EXTRA_SECURE", true);
        voiceIntent = voiceIntent2;
        goto L9
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void startedWakingUpGlobal(int reason) {
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void finishedWakingUpGlobal(int reason) {
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void startedGoingToSleepGlobal(int reason) {
        this.mDeviceGoingToSleep = true;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void finishedGoingToSleepGlobal(int reason) {
        this.mDeviceGoingToSleep = false;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void startedGoingToSleep(int displayGroupId, int pmSleepReason) {
        Slog.i(TAG, "Started going to sleep... (groupId=" + displayGroupId + " why=" + WindowManagerPolicyConstants.offReasonToString(WindowManagerPolicyConstants.translateSleepReasonToOffReason(pmSleepReason)) + ")");
        if (displayGroupId == 0) goto L5;
        return;
    L5:
        this.mRequestedOrSleepingDefaultDisplay = true;
        this.mIsGoingToSleepDefaultDisplay = true;
        if (this.mKeyguardDelegate != null) goto L8;
        return;
    L8:
        if (pmSleepReason == 20) goto L12;
        this.mKeyguardDelegate.onStartedGoingToSleep(pmSleepReason);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void finishedGoingToSleep(int displayGroupId, int pmSleepReason) {
        if (displayGroupId == 0) goto L4;
        return;
    L4:
        EventLogTags.writeScreenToggled(0);
        Slog.i(TAG, "Finished going to sleep... (groupId=" + displayGroupId + " why=" + WindowManagerPolicyConstants.offReasonToString(WindowManagerPolicyConstants.translateSleepReasonToOffReason(pmSleepReason)) + ")");
        MetricsLogger.histogram(this.mContext, "screen_timeout", this.mLockScreenTimeout / 1000);
        this.mRequestedOrSleepingDefaultDisplay = false;
        this.mIsGoingToSleepDefaultDisplay = false;
        this.mDefaultDisplayPolicy.setAwake(false);
        Object r1 = this.mLock;
        monitor-enter(r1);
        updateWakeGestureListenerLp();     // Catch: Throwable -> L16
        updateLockScreenTimeout();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        this.mDefaultDisplayRotation.updateOrientationListener();
        if (this.mKeyguardDelegate == null) goto L12;
        this.mKeyguardDelegate.onFinishedGoingToSleep(pmSleepReason, this.mPowerButtonLaunchGestureTriggeredDuringGoingToSleep);
    L12:
        if (this.mDisplayFoldController == null) goto L14;
        this.mDisplayFoldController.finishedGoingToSleep();
    L14:
        this.mPowerButtonLaunchGestureTriggeredDuringGoingToSleep = false;
        this.mPowerButtonLaunchGestureTriggered = false;
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void startedWakingUp(int displayGroupId, int pmWakeReason) {
        Slog.i(TAG, "Started waking up... (groupId=" + displayGroupId + " why=" + WindowManagerPolicyConstants.onReasonToString(WindowManagerPolicyConstants.translateWakeReasonToOnReason(pmWakeReason)) + ")");
        if (displayGroupId == 0) goto L5;
        return;
    L5:
        EventLogTags.writeScreenToggled(1);
        this.mIsGoingToSleepDefaultDisplay = false;
        this.mDefaultDisplayPolicy.setAwake(true);
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateWakeGestureListenerLp();     // Catch: Throwable -> L14
        updateLockScreenTimeout();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.mDefaultDisplayRotation.updateOrientationListener();
        if (this.mKeyguardDelegate == null) goto L12;
        this.mKeyguardDelegate.onStartedWakingUp(pmWakeReason, this.mPowerButtonLaunchGestureTriggered);
    L12:
        this.mPowerButtonLaunchGestureTriggered = false;
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void finishedWakingUp(int displayGroupId, int pmWakeReason) {
        Slog.i(TAG, "Finished waking up... (groupId=" + displayGroupId + " why=" + WindowManagerPolicyConstants.onReasonToString(WindowManagerPolicyConstants.translateWakeReasonToOnReason(pmWakeReason)) + ")");
        if (displayGroupId == 0) goto L6;
        return;
    L6:
        if (this.mKeyguardDelegate == null) goto L9;
        this.mKeyguardDelegate.onFinishedWakingUp();
    L9:
        if (this.mDisplayFoldController == null) goto L12;
        this.mDisplayFoldController.finishedWakingUp();
        return;
    }

    private boolean shouldWakeUpWithHomeIntent() {
        if (this.mWakeUpToLastStateTimeout > 0) goto L5;
        return false;
    L5:
        long sleepDurationRealtime = this.mPowerManagerInternal.getLastWakeup().sleepDurationRealtime;
        Log.i(TAG, "shouldWakeUpWithHomeIntent: sleepDurationRealtime= " + sleepDurationRealtime + " mWakeUpToLastStateTimeout= " + this.mWakeUpToLastStateTimeout);
        if (sleepDurationRealtime <= this.mWakeUpToLastStateTimeout) goto L9;
        return true;
    L9:
        return false;
    }

    private void wakeUpFromWakeKey(KeyEvent event) {
        if (isKeyEventForCurrentUser(event.getDisplayId(), event.getKeyCode(), "wakeUpFromWakeKey") == true) goto L5;
        return;
    L5:
        long r0 = event.getEventTime();
        int r2 = event.getKeyCode();
        if (event.getAction() != 0) goto L8;
        boolean r3 = true;
    L9:
        wakeUpFromWakeKey(r0, r2, r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    private void wakeUpFromWakeKey(long eventTime, int keyCode, boolean isDown) {
        if (this.mWindowWakeUpPolicy.wakeUpFromKey(0, eventTime, keyCode, isDown) == true) goto L5;
        return;
    L5:
        if (keyCode != 3) goto L7;
    L10:
        boolean keyCanLaunchHome = true;
    L12:
        if (shouldWakeUpWithHomeIntent() == false) goto L20;
        if (keyCanLaunchHome == false) goto L21;
        if (keyCode != 3) goto L16;
        boolean r7 = true;
    L17:
        startDockOrHome(0, r7, true, "Wake from " + KeyEvent.keyCodeToString(keyCode));
        return;
    L16:
        r7 = false;
        goto L17
    L21:
        return;
    L20:
        return;
    L7:
        if (keyCode == 26) goto L10;
        keyCanLaunchHome = false;
        goto L12
    }

    private void finishKeyguardDrawn() {
        if (this.mDefaultDisplayPolicy.finishKeyguardDrawn() == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mKeyguardDelegate == null) goto L12;
        this.mHandler.removeMessages(6);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        Trace.asyncTraceBegin(32, TRACE_WAIT_FOR_ALL_WINDOWS_DRAWN_METHOD, -1);
        this.mWindowManagerInternal.waitForAllWindowsDrawn(this.mHandler.obtainMessage(7, -1, 0), 1000, -1);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void screenTurnedOff(int displayId, boolean isSwappingDisplay) {
        Slog.i(TAG, HwTeardownResult.COMPONENT_DISPLAY + displayId + " turned off...");
        if (displayId == 0) goto L5;
        return;
    L5:
        if (isSwappingDisplay == true) goto L7;
    L10:
        boolean acquireSleepToken = true;
    L11:
        this.mRequestedOrSleepingDefaultDisplay = false;
        this.mDefaultDisplayPolicy.screenTurnedOff(acquireSleepToken);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (this.mKeyguardDelegate == null) goto L18;
        this.mKeyguardDelegate.onScreenTurnedOff();     // Catch: Throwable -> L16
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L16
        this.mDefaultDisplayRotation.updateOrientationListener();
        reportScreenStateToVrManager(false);
        return;
    L7:
        if (this.mIsGoingToSleepDefaultDisplay == true) goto L10;
        acquireSleepToken = false;
        goto L11
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void onDisplaySwitchStart(int displayId) {
        if (displayId != 0) goto L5;
        this.mDefaultDisplayPolicy.onDisplaySwitchStart();
        return;
    }

    private long getKeyguardDrawnTimeout() {
        boolean bootCompleted = ((SystemServiceManager) LocalServices.getService(SystemServiceManager.class)).isBootCompleted();
        if (bootCompleted == true) goto L7;
        return 5000;
    L7:
        return this.mKeyguardDrawnTimeout;
    }

    private WallpaperManagerInternal getWallpaperManagerInternal() {
        if (this.mWallpaperManagerInternal != null) goto L6;
        this.mWallpaperManagerInternal = (WallpaperManagerInternal) LocalServices.getService(WallpaperManagerInternal.class);
    L6:
        return this.mWallpaperManagerInternal;
    }

    private void reportScreenTurningOnToWallpaper(int displayId) {
        WallpaperManagerInternal wallpaperManagerInternal = getWallpaperManagerInternal();
        if (wallpaperManagerInternal == null) goto L6;
        wallpaperManagerInternal.onScreenTurningOn(displayId);
        return;
    }

    private void reportScreenTurnedOnToWallpaper(int displayId) {
        WallpaperManagerInternal wallpaperManagerInternal = getWallpaperManagerInternal();
        if (wallpaperManagerInternal == null) goto L6;
        wallpaperManagerInternal.onScreenTurnedOn(displayId);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void screenTurningOn(int displayId, WindowManagerPolicy.ScreenOnListener screenOnListener) {
        Slog.i(TAG, "Display " + displayId + " turning on...");
        reportScreenTurningOnToWallpaper(displayId);
        if (displayId != 0) goto L18;
        Trace.asyncTraceBegin(32, "screenTurningOn", 0);
        this.mDefaultDisplayPolicy.screenTurningOn(screenOnListener);
        this.mBootAnimationDismissable = false;
        Object r3 = this.mLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mKeyguardDelegate != null) goto L9;
    L13:
        Slog.d(TAG, "null mKeyguardDelegate: setting mKeyguardDrawComplete.");     // Catch: Throwable -> L11
        this.mHandler.sendEmptyMessage(5);     // Catch: Throwable -> L11
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L11
        return;
    L9:
        if (this.mKeyguardDelegate.hasKeyguard() == false) goto L13;
        this.mHandler.removeMessages(6);     // Catch: Throwable -> L11
        this.mHandler.sendEmptyMessageDelayed(6, getKeyguardDrawnTimeout());     // Catch: Throwable -> L11
        this.mKeyguardDelegate.onScreenTurningOn(this.mKeyguardDrawnCallback);     // Catch: Throwable -> L11
        goto L14
    L18:
        this.mScreenOnListeners.put(displayId, screenOnListener);
        Trace.asyncTraceBegin(32, TRACE_WAIT_FOR_ALL_WINDOWS_DRAWN_METHOD, displayId);
        this.mWindowManagerInternal.waitForAllWindowsDrawn(this.mHandler.obtainMessage(7, displayId, 0), 1000, displayId);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void screenTurnedOn(int displayId) {
        Slog.i(TAG, "Display " + displayId + " turned on...");
        reportScreenTurnedOnToWallpaper(displayId);
        if (displayId == 0) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mKeyguardDelegate == null) goto L12;
        this.mKeyguardDelegate.onScreenTurnedOn();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mDefaultDisplayPolicy.screenTurnedOn();
        reportScreenStateToVrManager(true);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void screenTurningOff(int displayId, WindowManagerPolicy.ScreenOffListener screenOffListener) {
        this.mWindowManagerFuncs.screenTurningOff(displayId, screenOffListener);
        if (displayId == 0) goto L5;
        return;
    L5:
        this.mRequestedOrSleepingDefaultDisplay = true;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mKeyguardDelegate == null) goto L12;
        this.mKeyguardDelegate.onScreenTurningOff();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private void reportScreenStateToVrManager(boolean isScreenOn) {
        if (this.mVrManagerInternal != null) goto L5;
        return;
    L5:
        this.mVrManagerInternal.onScreenStateChanged(isScreenOn);
    }

    private void finishWindowsDrawn(int displayId) {
        if (displayId == 0) goto L10;
        if (displayId == (-1)) goto L10;
        WindowManagerPolicy.ScreenOnListener screenOnListener = (WindowManagerPolicy.ScreenOnListener) this.mScreenOnListeners.removeReturnOld(displayId);
        if (screenOnListener == null) goto L14;
        screenOnListener.onScreenOn();
        return;
    L14:
        return;
    L10:
        if (this.mDefaultDisplayPolicy.finishWindowsDrawn() == true) goto L12;
        return;
    L12:
        finishScreenTurningOn();
    }

    private void finishScreenTurningOn() {
        this.mDefaultDisplayRotation.updateOrientationListener();
        WindowManagerPolicy.ScreenOnListener listener = this.mDefaultDisplayPolicy.getScreenOnListener();
        if (this.mDefaultDisplayPolicy.finishScreenTurningOn() == true) goto L5;
        return;
    L5:
        Trace.asyncTraceEnd(32, "screenTurningOn", 0);
        enableScreen(listener, true);
    }

    private void enableScreen(WindowManagerPolicy.ScreenOnListener listener, boolean report) {
        boolean awake = this.mDefaultDisplayPolicy.isAwake();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mKeyguardDrawnOnce == true) goto L12;
        if (awake == false) goto L12;
        this.mKeyguardDrawnOnce = true;     // Catch: Throwable -> L10
        boolean enableScreen = true;
        if (this.mBootMessageNeedsHiding == false) goto L13;
        this.mBootMessageNeedsHiding = false;     // Catch: Throwable -> L10
        hideBootMessages();     // Catch: Throwable -> L10
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (report == false) goto L17;
        if (listener == null) goto L17;
        listener.onScreenOn();
    L17:
        if (enableScreen == false) goto L24;
        this.mWindowManagerFuncs.enableScreenIfNeeded();
        return;
    L24:
        return;
    L12:
        enableScreen = false;
        goto L13
    }

    private void handleHideBootMessage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mKeyguardDrawnOnce == true) goto L11;
        this.mBootMessageNeedsHiding = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (this.mBootMsgDialog == null) goto L19;
        Slog.d(TAG, "handleHideBootMessage: dismissing");
        this.mBootMsgDialog.dismiss();
        this.mBootMsgDialog = null;
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isScreenOn() {
        return this.mDefaultDisplayPolicy.isScreenOnEarly();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean okToAnimate(boolean ignoreScreenOn) {
        if (ignoreScreenOn == true) goto L6;
        if (isScreenOn() == true) goto L6;
    L8:
        return false;
    L6:
        if (this.mDeviceGoingToSleep == true) goto L8;
        return true;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void enableKeyguard(boolean enabled) {
        if (this.mKeyguardDelegate == null) goto L6;
        this.mKeyguardDelegate.setKeyguardEnabled(enabled);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void exitKeyguardSecurely(WindowManagerPolicy.OnKeyguardExitResult callback) {
        if (this.mKeyguardDelegate == null) goto L6;
        this.mKeyguardDelegate.verifyUnlock(callback);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardShowing() {
        if (this.mKeyguardDelegate != null) goto L7;
        return false;
    L7:
        return this.mKeyguardDelegate.isShowing();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardShowingAndNotOccluded() {
        if (this.mKeyguardDelegate != null) goto L6;
        return false;
    L6:
        if (this.mKeyguardDelegate.isShowing() == true) goto L8;
        return false;
    L8:
        if (isKeyguardOccluded() == true) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardTrustedLw() {
        if (this.mKeyguardDelegate != null) goto L7;
        return false;
    L7:
        return this.mKeyguardDelegate.isTrusted();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardLocked() {
        return keyguardOn();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardSecure(int userId) {
        if (this.mKeyguardDelegate != null) goto L7;
        return false;
    L7:
        return this.mKeyguardDelegate.isSecure(userId);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardOccluded() {
        if (this.mKeyguardDelegate != null) goto L7;
        return false;
    L7:
        return this.mKeyguardDelegate.isOccluded();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean inKeyguardRestrictedKeyInputMode() {
        if (this.mKeyguardDelegate != null) goto L7;
        return false;
    L7:
        return this.mKeyguardDelegate.isInputRestricted();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void dismissKeyguardLw(IKeyguardDismissCallback callback, CharSequence message) {
        if (this.mKeyguardDelegate != null) goto L5;
    L7:
        if (callback == null) goto L16;
        callback.onDismissError();     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to call callback", e);
        return;
    L16:
        return;
    L5:
        if (this.mKeyguardDelegate.isShowing() == false) goto L7;
        this.mKeyguardDelegate.dismiss(callback, message);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isKeyguardDrawnLw() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mKeyguardDrawnOnce;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void startKeyguardExitAnimation(long startTime) {
        if (this.mKeyguardDelegate == null) goto L6;
        this.mKeyguardDelegate.startKeyguardExitAnimation(startTime);
        return;
    }

    void sendCloseSystemWindows() {
        PhoneWindow.sendCloseSystemWindows(this.mContext, null);
    }

    void sendCloseSystemWindows(String reason) {
        PhoneWindow.sendCloseSystemWindows(this.mContext, reason);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setSafeMode(boolean safeMode) {
        this.mSafeMode = safeMode;
        if (safeMode == false) goto L6;
        performHapticFeedback(10001, "Safe Mode Enabled", 2);
        return;
    }

    private void bindKeyguard() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mKeyguardBound == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mKeyguardBound = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mKeyguardDelegate.bindService(this.mContext);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void onSystemUiStarted() {
        bindKeyguard();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void systemReady() {
        this.mKeyguardDelegate.onSystemReady();
        this.mModifierShortcutManager.onSystemReady();
        this.mVrManagerInternal = (VrManagerInternal) LocalServices.getService(VrManagerInternal.class);
        if (this.mVrManagerInternal == null) goto L5;
        this.mVrManagerInternal.addPersistentVrModeStateListener(this.mPersistentVrModeListener);
    L5:
        this.mDockObserverInternal = (DockObserverInternal) LocalServices.getService(DockObserverInternal.class);
        if (this.mDockObserverInternal == null) goto L8;
        int dockMode = this.mDockObserverInternal.getActualDockState();
        this.mDefaultDisplayPolicy.setDockMode(dockMode);
    L8:
        readCameraLensCoverState();
        updateUiMode();
        this.mDefaultDisplayRotation.updateOrientationListener();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemReady = true;     // Catch: Throwable -> L14
        updateSettings(this.mHandler);     // Catch: Throwable -> L14
        if (this.mSystemBooted == false) goto L16;
        this.mKeyguardDelegate.onBootCompleted();     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.mAutofillManagerInternal = (AutofillManagerInternal) LocalServices.getService(AutofillManagerInternal.class);
        this.mGestureLauncherService = (GestureLauncherService) LocalServices.getService(GestureLauncherService.class);
        getExt().onSystemReady();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void systemBooted() {
        bindKeyguard();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemBooted = true;     // Catch: Throwable -> L8
        if (this.mSystemReady == false) goto L10;
        this.mKeyguardDelegate.onBootCompleted();     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mSideFpsEventHandler.onFingerprintSensorReady();
        startedWakingUp(0, 0);
        finishedWakingUp(0, 0);
        int defaultDisplayState = this.mDisplayManager.getDisplay(0).getState();
        if (defaultDisplayState != 2) goto L14;
        boolean defaultDisplayOn = true;
    L16:
        if (this.mDefaultDisplayPolicy.getScreenOnListener() == null) goto L18;
        boolean defaultScreenTurningOn = true;
    L19:
        if (defaultDisplayOn == true) goto L23;
        if (defaultScreenTurningOn == true) goto L23;
        this.mBootAnimationDismissable = true;
        enableScreen(null, false);
        return;
    L23:
        screenTurningOn(0, this.mDefaultDisplayPolicy.getScreenOnListener());
        screenTurnedOn(0);
        return;
    L18:
        defaultScreenTurningOn = false;
        goto L19
    L14:
        defaultDisplayOn = false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean canDismissBootAnimation() {
        if (this.mDefaultDisplayPolicy.isKeyguardDrawComplete() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mBootAnimationDismissable == true) goto L8;
        return false;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void showBootMessage(final CharSequence msg, boolean always) {
        this.mHandler.post(new AnonymousClass19(this, msg));
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void hideBootMessages() {
        this.mHandler.sendEmptyMessage(11);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void userActivity(int displayGroupId, int event) {
        if (displayGroupId == 0) goto L4;
    L6:
        ScreenLockTimeout r0 = this.mScreenLockTimeout;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mLockScreenTimerActive == false) goto L13;
        this.mHandler.removeCallbacks(this.mScreenLockTimeout);     // Catch: Throwable -> L11
        this.mHandler.postDelayed(this.mScreenLockTimeout, this.mLockScreenTimeout);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L4:
        if (event != 2) goto L6;
        this.mDefaultDisplayPolicy.onUserActivityEventTouch();
        goto L6
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void lockNow(Bundle options) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        this.mHandler.removeCallbacks(this.mScreenLockTimeout);
        if (options == null) goto L5;
        this.mScreenLockTimeout.setLockOptions(options);
    L5:
        this.mHandler.post(this.mScreenLockTimeout);
        ScreenLockTimeout r0 = this.mScreenLockTimeout;
        monitor-enter(r0);
        this.mLockNowPending = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setAllowLockscreenWhenOn(int displayId, boolean allow) {
        if (this.mVisibleBackgroundUsersEnabled == true) goto L5;
    L7:
        if (allow == false) goto L9;
        this.mAllowLockscreenWhenOnDisplays.add(Integer.valueOf(displayId));
    L10:
        updateLockScreenTimeout();
        return;
    L9:
        this.mAllowLockscreenWhenOnDisplays.remove(Integer.valueOf(displayId));
        goto L10
    L5:
        if (this.mUserManagerInternal.getUserAssignedToDisplay(displayId) == this.mCurrentUserId) goto L7;
    }

    private void updateLockScreenTimeout() {
        ScreenLockTimeout r0 = this.mScreenLockTimeout;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mLockNowPending == false) goto L12;
        Log.w(TAG, "lockNow pending, ignore updating lockscreen timeout");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mAllowLockscreenWhenOnDisplays.isEmpty() == false) goto L14;
    L20:
        boolean enable = false;
    L22:
        if (this.mLockScreenTimerActive == enable) goto L27;
        if (enable == false) goto L25;
        this.mHandler.removeCallbacks(this.mScreenLockTimeout);     // Catch: Throwable -> L9
        this.mHandler.postDelayed(this.mScreenLockTimeout, this.mLockScreenTimeout);     // Catch: Throwable -> L9
    L26:
        this.mLockScreenTimerActive = enable;     // Catch: Throwable -> L9
        goto L27
    L25:
        this.mHandler.removeCallbacks(this.mScreenLockTimeout);     // Catch: Throwable -> L9
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        if (this.mDefaultDisplayPolicy.isAwake() == false) goto L20;
        if (this.mKeyguardDelegate == null) goto L20;
        if (this.mKeyguardDelegate.isSecure(this.mCurrentUserId) == false) goto L20;
        enable = true;
        goto L22
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void enableScreenAfterBoot() {
        readLidState();
        applyLidSwitchState();
        updateRotation(true);
    }

    private void applyLidSwitchState() {
        int lidState = this.mDefaultDisplayPolicy.getLidState();
        if (lidState != 0) goto L9;
        int lidBehavior = getLidBehavior();
        switch(lidBehavior) {
            case 1: goto L8;
            case 2: goto L7;
            default: goto L9;
        };
    L7:
        this.mWindowManagerFuncs.lockDeviceNow();
        goto L9
    L8:
        sleepDefaultDisplay(SystemClock.uptimeMillis(), 3, 1);
    L9:
        Object r1 = this.mLock;
        monitor-enter(r1);
        updateWakeGestureListenerLp();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void updateUiMode() {
        if (this.mUiModeManager != null) goto L9;
        this.mUiModeManager = IUiModeManager.Stub.asInterface(ServiceManager.getService("uimode"));
    L9:
        this.mUiMode = this.mUiModeManager.getCurrentModeType();     // Catch: RemoteException -> L7
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public int getUiMode() {
        return this.mUiMode;
    }

    void updateRotation(boolean alwaysSendConfiguration) {
        this.mWindowManagerFuncs.updateRotation(alwaysSendConfiguration, false);
    }

    Intent createHomeDockIntent() {
        Intent intent = null;
        if (this.mUiMode != 3) goto L8;
        if (this.mEnableCarDockHomeCapture == false) goto L23;
        intent = this.mCarDockIntent;
    L23:
        if (intent != null) goto L25;
        return null;
    L25:
        ActivityInfo ai = null;
        ResolveInfo info = this.mPackageManager.resolveActivityAsUser(intent, 65664, this.mCurrentUserId);
        if (info == null) goto L28;
        ai = info.activityInfo;
    L28:
        if (ai != null) goto L30;
    L35:
        return null;
    L30:
        if (ai.metaData == null) goto L35;
        if (ai.metaData.getBoolean("android.dock_home") == false) goto L35;
        Intent intent2 = new Intent(intent);
        intent2.setClassName(ai.packageName, ai.name);
        return intent2;
    L8:
        if (this.mUiMode == 2) goto L23;
        if (this.mUiMode != 6) goto L20;
        int dockMode = this.mDefaultDisplayPolicy.getDockMode();
        if (dockMode != 1) goto L15;
    L17:
        intent = this.mDeskDockIntent;
        goto L23
    L15:
        if (dockMode == 4) goto L17;
        if (dockMode != 3) goto L23;
    L20:
        if (this.mUiMode != 7) goto L23;
        intent = this.mVrHeadsetHomeIntent;
        goto L23
    }

    void startDockOrHome(int displayId, boolean fromHomeKey, boolean awakenFromDreams, String startReason) {
        ActivityManager.getService().stopAppSwitches();     // Catch: RemoteException -> L4
    L6:
        sendCloseSystemWindows(SYSTEM_DIALOG_REASON_HOME_KEY);
        if (awakenFromDreams == false) goto L10;
        awakenDreams();
    L10:
        if (this.mHasFeatureAuto == false) goto L12;
    L15:
        Intent dock = createHomeDockIntent();
        if (dock == null) goto L23;
        if (fromHomeKey == true) goto L25;
    L21:
        startActivityAsUser(dock, UserHandle.CURRENT);     // Catch: ActivityNotFoundException -> L19
        return;
    L25:
        dock.putExtra("android.intent.extra.FROM_HOME_KEY", fromHomeKey);     // Catch: ActivityNotFoundException -> L19
    L23:
        Log.d(TAG, "startDockOrHome: startReason= " + startReason);
        int userId = this.mUserManagerInternal.getUserAssignedToDisplay(displayId);
        this.mActivityTaskManagerInternal.startHomeOnDisplay(userId, startReason, displayId, true, fromHomeKey);
        return;
    L12:
        if (isUserSetupComplete() == true) goto L15;
        Slog.i(TAG, "Not going home because user setup is in progress.");
    }

    void startDockOrHome(int displayId, boolean fromHomeKey, boolean awakenFromDreams) {
        startDockOrHome(displayId, fromHomeKey, awakenFromDreams, "startDockOrHome");
    }

    boolean goHome() {
        if (isUserSetupComplete() == true) goto L22;
        Slog.i(TAG, "Not going home because user setup is in progress.");
        return false;
    L22:
        if (SystemProperties.getInt("persist.sys.uts-test-mode", 0) != 1) goto L12;
        Log.d(TAG, "UTS-TEST-MODE");     // Catch: RemoteException -> L10
    L17:
        int result = ActivityTaskManager.getService().startActivityAsUser(null, this.mContext.getOpPackageName(), this.mContext.getAttributionTag(), this.mHomeIntent, this.mHomeIntent.resolveTypeIfNeeded(this.mContext.getContentResolver()), null, null, 0, 1, null, null, -2);     // Catch: RemoteException -> L10
        if (result != 1) goto L21;
        return false;
    L12:
        ActivityManager.getService().stopAppSwitches();     // Catch: RemoteException -> L10
        sendCloseSystemWindows();     // Catch: RemoteException -> L10
        Intent dock = createHomeDockIntent();     // Catch: RemoteException -> L10
        if (dock == null) goto L17;
        int result2 = ActivityTaskManager.getService().startActivityAsUser(null, this.mContext.getOpPackageName(), this.mContext.getAttributionTag(), dock, dock.resolveTypeIfNeeded(this.mContext.getContentResolver()), null, null, 0, 1, null, null, -2);     // Catch: RemoteException -> L10
        if (result2 != 1) goto L17;
        return false;
    L21:
        return true;
    }

    private boolean isTheaterModeEnabled() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "theater_mode_on", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    protected void performHapticFeedback(int effectId, String reason) {
        performHapticFeedback(effectId, reason, 0);
    }

    private void performHapticFeedback(int effectId, String reason, int flags) {
        this.mVibrator.performHapticFeedback(effectId, reason, flags, 0);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean isGlobalKey(int keyCode) {
        return this.mGlobalKeyManager.shouldHandleGlobalKey(keyCode);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void keepScreenOnStartedLw() {
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void keepScreenOnStoppedLw() {
        if (isKeyguardShowingAndNotOccluded() == false) goto L6;
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), false);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public boolean hasNavigationBar() {
        return this.mDefaultDisplayPolicy.hasNavigationBar();
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setDismissImeOnBackKeyPressed(boolean newValue) {
        this.mDismissImeOnBackKeyPressed = newValue;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setCurrentUserLw(int newUserId) {
        this.mCurrentUserId = newUserId;
        if (this.mKeyguardDelegate == null) goto L6;
        this.mKeyguardDelegate.setCurrentUser(newUserId);
    L6:
        if (this.mAccessibilityShortcutController == null) goto L8;
        this.mAccessibilityShortcutController.setCurrentUser(newUserId);
    L8:
        StatusBarManagerInternal statusBar = getStatusBarManagerInternal();
        if (statusBar == null) goto L11;
        statusBar.setCurrentUser(newUserId);
    L11:
        this.mModifierShortcutManager.setCurrentUser(UserHandle.of(newUserId));
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void setSwitchingUser(boolean switching) {
        this.mKeyguardDelegate.setSwitchingUser(switching);
        if (switching == false) goto L6;
        dismissKeyboardShortcutsMenu();
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1159641169922L, this.mDefaultDisplayRotation.getUserRotationMode());
        proto.write(1159641169923L, this.mDefaultDisplayRotation.getUserRotation());
        proto.write(1159641169924L, this.mDefaultDisplayRotation.getCurrentAppOrientation());
        proto.write(1133871366149L, this.mDefaultDisplayPolicy.isScreenOnFully());
        proto.write(1133871366150L, this.mDefaultDisplayPolicy.isKeyguardDrawComplete());
        proto.write(1133871366151L, this.mDefaultDisplayPolicy.isWindowManagerDrawComplete());
        proto.write(1133871366156L, isKeyguardOccluded());
        proto.write(1133871366157L, this.mKeyguardOccludedChanged);
        proto.write(1133871366158L, this.mPendingKeyguardOccluded);
        if (this.mKeyguardDelegate == null) goto L5;
        this.mKeyguardDelegate.dumpDebug(proto, 1146756268052L);
    L5:
        proto.end(token);
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public void dump(String prefix, PrintWriter pw, String[] args) {
        pw.print(prefix);
        pw.print("mSafeMode=");
        pw.print(this.mSafeMode);
        pw.print(" mSystemReady=");
        pw.print(this.mSystemReady);
        pw.print(" mSystemBooted=");
        pw.println(this.mSystemBooted);
        pw.print(prefix);
        pw.print("mCameraLensCoverState=");
        pw.println(WindowManagerPolicy.WindowManagerFuncs.cameraLensStateToString(this.mCameraLensCoverState));
        pw.print(prefix);
        pw.print("mWakeGestureEnabledSetting=");
        pw.println(this.mWakeGestureEnabledSetting);
        pw.print(prefix);
        pw.print("mUiMode=");
        pw.print(Configuration.uiModeToString(this.mUiMode));
        pw.print("mEnableCarDockHomeCapture=");
        pw.println(this.mEnableCarDockHomeCapture);
        pw.print(prefix);
        pw.print("mLidKeyboardAccessibility=");
        pw.print(this.mLidKeyboardAccessibility);
        pw.print(" mLidNavigationAccessibility=");
        pw.print(this.mLidNavigationAccessibility);
        pw.print(" getLidBehavior=");
        pw.println(lidBehaviorToString(getLidBehavior()));
        pw.print(prefix);
        pw.print("mLongPressOnBackBehavior=");
        pw.println(longPressOnBackBehaviorToString(this.mLongPressOnBackBehavior));
        pw.print(prefix);
        pw.print("mLongPressOnHomeBehavior=");
        pw.println(longPressOnHomeBehaviorToString(this.mLongPressOnHomeBehavior));
        pw.print(prefix);
        pw.print("mDoubleTapOnHomeBehavior=");
        pw.println(doubleTapOnHomeBehaviorToString(this.mDoubleTapOnHomeBehavior));
        pw.print(prefix);
        pw.print("mShortPressOnPowerBehavior=");
        pw.println(shortPressOnPowerBehaviorToString(this.mShortPressOnPowerBehavior));
        pw.print(prefix);
        pw.print("mLongPressOnPowerBehavior=");
        pw.println(longPressOnPowerBehaviorToString(this.mLongPressOnPowerBehavior));
        pw.print(prefix);
        pw.print("mSettingsKeyBehavior=");
        pw.println(settingsKeyBehaviorToString(this.mSettingsKeyBehavior));
        pw.print(prefix);
        pw.print("mLongPressOnPowerAssistantTimeoutMs=");
        pw.println(this.mLongPressOnPowerAssistantTimeoutMs);
        pw.print(prefix);
        pw.print("mVeryLongPressOnPowerBehavior=");
        pw.println(veryLongPressOnPowerBehaviorToString(this.mVeryLongPressOnPowerBehavior));
        pw.print(prefix);
        pw.print("mDoublePressOnPowerBehavior=");
        pw.println(multiPressOnPowerBehaviorToString(this.mDoublePressOnPowerBehavior));
        pw.print(prefix);
        pw.print("mTriplePressOnPowerBehavior=");
        pw.println(multiPressOnPowerBehaviorToString(this.mTriplePressOnPowerBehavior));
        pw.print(prefix);
        pw.print("mSupportShortPressPowerWhenDefaultDisplayOn=");
        pw.println(this.mSupportShortPressPowerWhenDefaultDisplayOn);
        pw.print(prefix);
        pw.print("mPowerVolUpBehavior=");
        pw.println(powerVolumeUpBehaviorToString(this.mPowerVolUpBehavior));
        pw.print(prefix);
        pw.print("mShortPressOnSleepBehavior=");
        pw.println(shortPressOnSleepBehaviorToString(this.mShortPressOnSleepBehavior));
        pw.print(prefix);
        pw.print("mShortPressOnWindowBehavior=");
        pw.println(shortPressOnWindowBehaviorToString(this.mShortPressOnWindowBehavior));
        pw.print(prefix);
        pw.print("mShortPressOnStemPrimaryBehavior=");
        pw.println(shortPressOnStemPrimaryBehaviorToString(this.mShortPressOnStemPrimaryBehavior));
        pw.print(prefix);
        pw.print("mDoublePressOnStemPrimaryBehavior=");
        pw.println(doublePressOnStemPrimaryBehaviorToString(this.mDoublePressOnStemPrimaryBehavior));
        pw.print(prefix);
        pw.print("mTriplePressOnStemPrimaryBehavior=");
        pw.println(triplePressOnStemPrimaryBehaviorToString(this.mTriplePressOnStemPrimaryBehavior));
        pw.print(prefix);
        pw.print("mLongPressOnStemPrimaryBehavior=");
        pw.println(longPressOnStemPrimaryBehaviorToString(this.mLongPressOnStemPrimaryBehavior));
        pw.print(prefix);
        pw.print("mAllowStartActivityForLongPressOnPowerDuringSetup=");
        pw.println(this.mAllowStartActivityForLongPressOnPowerDuringSetup);
        pw.print(prefix);
        pw.print("mHasSoftInput=");
        pw.println(this.mHasSoftInput);
        pw.print(prefix);
        pw.print("mDismissImeOnBackKeyPressed=");
        pw.print(this.mDismissImeOnBackKeyPressed);
        pw.print(" mIncallPowerBehavior=");
        pw.println(incallPowerBehaviorToString(this.mIncallPowerBehavior));
        pw.print(prefix);
        pw.print("mIncallBackBehavior=");
        pw.print(incallBackBehaviorToString(this.mIncallBackBehavior));
        pw.print(" mEndcallBehavior=");
        pw.println(endcallBehaviorToString(this.mEndcallBehavior));
        pw.print(prefix);
        pw.println("mDisplayHomeButtonHandlers=");
        int i = 0;
    L4:
        if (i >= this.mDisplayHomeButtonHandlers.size()) goto L6;
        int key = this.mDisplayHomeButtonHandlers.keyAt(i);
        pw.print(prefix);
        pw.print("  ");
        pw.println(this.mDisplayHomeButtonHandlers.get(key));
        i = i + 1;
        goto L4
    L6:
        pw.print(prefix);
        pw.print("mKeyguardOccluded=");
        pw.print(isKeyguardOccluded());
        pw.print(" mKeyguardOccludedChanged=");
        pw.print(this.mKeyguardOccludedChanged);
        pw.print(" mPendingKeyguardOccluded=");
        pw.println(this.mPendingKeyguardOccluded);
        pw.print(prefix);
        pw.print("mAllowLockscreenWhenOnDisplays=");
        pw.print(!this.mAllowLockscreenWhenOnDisplays.isEmpty());
        pw.print(" mLockScreenTimeout=");
        pw.print(this.mLockScreenTimeout);
        pw.print(" mLockScreenTimerActive=");
        pw.println(this.mLockScreenTimerActive);
        pw.print(prefix);
        pw.print("mKidsModeEnabled=");
        pw.println(this.mKidsModeEnabled);
        this.mGlobalKeyManager.dump(prefix, pw);
        this.mKeyCombinationManager.dump(prefix, pw);
        this.mSingleKeyGestureDetector.dump(prefix, pw);
        this.mDeferredKeyActionExecutor.dump(prefix, pw);
        if (this.mWakeGestureListener == null) goto L10;
        this.mWakeGestureListener.dump(pw, prefix);
    L10:
        if (this.mBurnInProtectionHelper == null) goto L13;
        this.mBurnInProtectionHelper.dump(prefix, pw);
    L13:
        if (this.mKeyguardDelegate == null) goto L15;
        this.mKeyguardDelegate.dump(prefix, pw);
    L15:
        pw.print(prefix);
        pw.println("Looper state:");
        this.mHandler.getLooper().dump(new PrintWriterPrinter(pw), prefix + "  ");
        this.mModifierShortcutManager.dump(prefix, pw);
    }

    private static String endcallBehaviorToString(int behavior) {
        StringBuilder sb = new StringBuilder();
        if ((behavior & 1) == 0) goto L6;
        sb.append("home|");
    L6:
        if ((behavior & 2) == 0) goto L8;
        sb.append("sleep|");
    L8:
        int N = sb.length();
        if (N != 0) goto L13;
        return "<nothing>";
    L13:
        return sb.substring(0, N - 1);
    }

    private static String incallPowerBehaviorToString(int behavior) {
        if ((behavior & 2) == 0) goto L6;
        return "hangup";
    L6:
        return "sleep";
    }

    private static String incallBackBehaviorToString(int behavior) {
        if ((behavior & 1) == 0) goto L6;
        return "hangup";
    L6:
        return "<nothing>";
    }

    private static String longPressOnBackBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "LONG_PRESS_BACK_GO_TO_VOICE_ASSIST";
    L7:
        return "LONG_PRESS_BACK_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String longPressOnHomeBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "LONG_PRESS_HOME_NOTIFICATION_PANEL";
    L7:
        return "LONG_PRESS_HOME_ASSIST";
    L9:
        return "LONG_PRESS_HOME_ALL_APPS";
    L11:
        return "LONG_PRESS_HOME_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String doubleTapOnHomeBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "DOUBLE_TAP_HOME_PIP_MENU";
    L7:
        return "DOUBLE_TAP_HOME_RECENT_SYSTEM_UI";
    L9:
        return "DOUBLE_TAP_HOME_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String shortPressOnPowerBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "SHORT_PRESS_POWER_CLOSE_IME_OR_GO_HOME";
    L7:
        return "SHORT_PRESS_POWER_GO_HOME";
    L9:
        return "SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP_AND_GO_HOME";
    L11:
        return "SHORT_PRESS_POWER_REALLY_GO_TO_SLEEP";
    L13:
        return "SHORT_PRESS_POWER_GO_TO_SLEEP";
    L15:
        return "SHORT_PRESS_POWER_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String longPressOnPowerBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "LONG_PRESS_POWER_ASSISTANT";
    L7:
        return "LONG_PRESS_POWER_GO_TO_VOICE_ASSIST";
    L9:
        return "LONG_PRESS_POWER_SHUT_OFF_NO_CONFIRM";
    L11:
        return "LONG_PRESS_POWER_SHUT_OFF";
    L13:
        return "LONG_PRESS_POWER_GLOBAL_ACTIONS";
    L15:
        return "LONG_PRESS_POWER_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String settingsKeyBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "SETTINGS_KEY_BEHAVIOR_NOTHING";
    L7:
        return "SETTINGS_KEY_BEHAVIOR_NOTIFICATION_PANEL";
    L9:
        return "SETTINGS_KEY_BEHAVIOR_SETTINGS_ACTIVITY";
    L4:
        return Integer.toString(behavior);
    }

    private static String veryLongPressOnPowerBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "VERY_LONG_PRESS_POWER_GLOBAL_ACTIONS";
    L7:
        return "VERY_LONG_PRESS_POWER_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String powerVolumeUpBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "POWER_VOLUME_UP_BEHAVIOR_GLOBAL_ACTIONS";
    L7:
        return "POWER_VOLUME_UP_BEHAVIOR_MUTE";
    L9:
        return "POWER_VOLUME_UP_BEHAVIOR_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String multiPressOnPowerBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "MULTI_PRESS_POWER_LAUNCH_TARGET_ACTIVITY";
    L7:
        return "MULTI_PRESS_POWER_BRIGHTNESS_BOOST";
    L9:
        return "MULTI_PRESS_POWER_THEATER_MODE";
    L11:
        return "MULTI_PRESS_POWER_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String shortPressOnSleepBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "SHORT_PRESS_SLEEP_GO_TO_SLEEP_AND_GO_HOME";
    L7:
        return "SHORT_PRESS_SLEEP_GO_TO_SLEEP";
    L4:
        return Integer.toString(behavior);
    }

    private static String shortPressOnWindowBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "SHORT_PRESS_WINDOW_PICTURE_IN_PICTURE";
    L7:
        return "SHORT_PRESS_WINDOW_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String shortPressOnStemPrimaryBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "SHORT_PRESS_PRIMARY_LAUNCH_TARGET_ACTIVITY";
    L7:
        return "SHORT_PRESS_PRIMARY_LAUNCH_ALL_APPS";
    L9:
        return "SHORT_PRESS_PRIMARY_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String doublePressOnStemPrimaryBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "DOUBLE_PRESS_PRIMARY_LAUNCH_DEFAULT_FITNESS_APP";
    L7:
        return "DOUBLE_PRESS_PRIMARY_SWITCH_RECENT_APP";
    L9:
        return "DOUBLE_PRESS_PRIMARY_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String triplePressOnStemPrimaryBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "TRIPLE_PRESS_PRIMARY_TOGGLE_ACCESSIBILITY";
    L7:
        return "TRIPLE_PRESS_PRIMARY_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String longPressOnStemPrimaryBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        return "LONG_PRESS_PRIMARY_LAUNCH_VOICE_ASSISTANT";
    L7:
        return "LONG_PRESS_PRIMARY_NOTHING";
    L4:
        return Integer.toString(behavior);
    }

    private static String lidBehaviorToString(int behavior) {
        switch(behavior) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "LID_BEHAVIOR_LOCK";
    L7:
        return "LID_BEHAVIOR_SLEEP";
    L9:
        return "LID_BEHAVIOR_NONE";
    L4:
        return Integer.toString(behavior);
    }

    public static boolean isLongPressToAssistantEnabled(Context context) {
        ContentResolver resolver = context.getContentResolver();
        int longPressToAssistant = Settings.System.getIntForUser(resolver, "clockwork_long_press_to_assistant_enabled", 1, -2);
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        Log.d(TAG, "longPressToAssistant = " + longPressToAssistant);
    L5:
        if (longPressToAssistant == 1) goto L9;
        return false;
    L9:
        return true;
    }

    private void launchTargetSearchActivity() {
        if (this.mSearchKeyTargetActivity == null) goto L5;
        Intent intent = new Intent();
        intent.setComponent(this.mSearchKeyTargetActivity);
    L6:
        intent.addFlags(270532608);
        startActivityAsUser(intent, UserHandle.CURRENT_OR_SELF);     // Catch: ActivityNotFoundException -> L9
        return;
    L10:
        Slog.e(TAG, "Could not resolve activity with : " + intent.getComponent().flattenToString() + " name.");
        return;
    L5:
        intent = new Intent("android.intent.action.WEB_SEARCH");
        goto L6
    }

    private int getTargetDisplayIdForKeyEvent(KeyEvent event) {
        if (event.getDisplayId() == (-1)) goto L7;
        return event.getDisplayId();
    L7:
        if (this.mTopFocusedDisplayId != (-1)) goto L9;
        return 0;
    L9:
        return this.mTopFocusedDisplayId;
    }

    private int getTargetDisplayIdForKeyGestureEvent(KeyGestureEvent event) {
        if (event.getDisplayId() == (-1)) goto L7;
        return event.getDisplayId();
    L7:
        if (this.mTopFocusedDisplayId != (-1)) goto L9;
        return 0;
    L9:
        return this.mTopFocusedDisplayId;
    }

    private boolean isKeyEventForCurrentUser(int displayId, int keyCode, String purpose) {
        if (this.mVisibleBackgroundUsersEnabled == true) goto L5;
        return true;
    L5:
        int assignedUser = this.mUserManagerInternal.getUserAssignedToDisplay(displayId);
        if (assignedUser != this.mCurrentUserId) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean checkInFactoryTest(String topActivityClassName) {
        String[] r0 = FACTORY_TEST_KEY_ACTIVITYS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String activity = r0[r3];
        if (activity.equals(topActivityClassName) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public String getTopActivityName(Context context) {
        if (this.mSystemBooted == true) goto L6;
        Log.e(TAG, "getTopActivityName::it is not bootcompleted, return empty string.");
        return "";
    L6:
        ActivityManager activityManager = (ActivityManager) context.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = activityManager.getRunningTasks(1);
        if (runningTaskInfos != null) goto L9;
        return null;
    L9:
        if (runningTaskInfos.isEmpty() == true) goto L13;
        ComponentName f = runningTaskInfos.get(0).topActivity;
        String topActivityClassName = f.getClassName();
        return topActivityClassName;
    L13:
        return null;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public IExtPhoneWindowManager getExt() {
        return this.mExt;
    }

    @Override // com.android.server.policy.WindowManagerPolicy
    public IObricPhoneWindowManager getObricExt() {
        return this.mObricExt;
    }

    protected boolean setKeyguardOccludedLwExt(boolean isOccluded) {
        return setKeyguardOccludedLw(isOccluded);
    }

    public PhoneWindowManagerSmtEx getISmtEx() {
        return this.mSmtEx;
    }

    private void onAiKeyPress(long eventTime, boolean isLongPress, int count) {
        Slog.d(TAG, "onAiKeyPress, press isLongPress = " + isLongPress + " count = " + count);
        if (LostModeUtil.beingLostModeEnabled(this.mContext) == false) goto L6;
        Slog.i(TAG, "Not support long press ai key when lost mode enabled.");
        return;
    L6:
        performHapticFeedback(4096, "Power - Long Press - Go To Assistant");
        if (isLongPress == false) goto L11;
        launchAssistAction(null, -2, eventTime, 10);
        return;
    L11:
        if (count != 1) goto L13;
        launchAssistAction(null, -2, eventTime, 7);
        return;
    L13:
        launchAssistAction(null, -2, eventTime, 9);
    }
}

package com.android.server.accessibility;

import android.R;
import android.accessibilityservice.AccessibilityGestureEvent;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityShortcutInfo;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.accessibilityservice.MagnificationConfig;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.app.admin.DevicePolicyManager;
import android.app.ecm.EnhancedConfirmationManager;
import android.appwidget.AppWidgetManagerInternal;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.IFingerprintService;
import android.hardware.input.InputManager;
import android.hardware.input.InputSettings;
import android.hardware.input.KeyGestureEvent;
import android.media.AudioManagerInternal;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PermissionEnforcer;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.provider.SettingsStringUtil;
import android.safetycenter.SafetyCenterManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.IInputFilter;
import android.view.IWindow;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MagnificationSpec;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.WindowInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowAttributes;
import android.view.accessibility.AccessibilityWindowInfo;
import android.view.accessibility.IAccessibilityInteractionConnection;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.accessibility.IAccessibilityManager;
import android.view.accessibility.IAccessibilityManagerClient;
import android.view.accessibility.IMagnificationConnection;
import android.view.accessibility.IUserInitializationCompleteCallback;
import android.view.inputmethod.EditorInfo;
import android.window.ScreenCapture;
import com.android.internal.accessibility.AccessibilityShortcutController;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.android.internal.accessibility.dialog.AccessibilityButtonChooserActivity;
import com.android.internal.accessibility.dialog.AccessibilityShortcutChooserActivity;
import com.android.internal.accessibility.util.AccessibilityStatsLogUtils;
import com.android.internal.accessibility.util.AccessibilityUtils;
import com.android.internal.accessibility.util.ShortcutUtils;
import com.android.internal.content.PackageMonitor;
import com.android.internal.inputmethod.IAccessibilityInputMethodSession;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FunctionalUtils;
import com.android.internal.util.IntPair;
import com.android.internal.util.Preconditions;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.modules.expresslog.Counter;
import com.android.server.AccessibilityManagerInternal;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.accessibility.magnification.MagnificationConnectionManager;
import com.android.server.accessibility.magnification.MagnificationController;
import com.android.server.accessibility.magnification.MagnificationProcessor;
import com.android.server.accessibility.magnification.MagnificationScaleProvider;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.usb.descriptors.UsbACInterface;
import com.android.server.utils.Slogf;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.utils.ObricImplFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityManagerService extends IAccessibilityManager.Stub implements AbstractAccessibilityServiceConnection.SystemSupport, AccessibilityUserState.ServiceInfoChangeListener, AccessibilityWindowManager.AccessibilityEventSender, AccessibilitySecurityPolicy.AccessibilityUserManager, SystemActionPerformer.SystemActionsChangedListener, SystemActionPerformer.DisplayUpdateCallBack, ProxyManager.SystemSupport {
    static final String ACTION_LAUNCH_HEARING_DEVICES_DIALOG = "com.android.systemui.action.LAUNCH_HEARING_DEVICES_DIALOG";
    private static final char COMPONENT_NAME_SEPARATOR = ':';
    private static final boolean DEBUG = false;
    private static final String FUNCTION_REGISTER_UI_TEST_AUTOMATION_SERVICE = "registerUiTestAutomationService";
    private static final String GET_WINDOW_TOKEN = "getWindowToken";
    public static final int INVALID_SERVICE_ID = -1;
    private static final String LOG_TAG = "AccessibilityManagerService";
    public static final int MAGNIFICATION_GESTURE_HANDLER_ID = 0;
    static final String METRIC_ID_QS_SHORTCUT_ADD = "accessibility.value_qs_shortcut_add";
    static final String METRIC_ID_QS_SHORTCUT_REMOVE = "accessibility.value_qs_shortcut_remove";
    private static final String OBRIC_ASSISTANT_ACCESSIBILITY_CHANGE = "obric_accessibility_state_change";
    private static final String OBRIC_ASSISTANT_PACKAGE_NAME = "com.obric.assistant";
    private static final String OBRIC_INPUT_METHOD_PACKAGE_NAME = "com.bytedance.android.doubaoime";
    private static final int OWN_PROCESS_ID = 0;
    private static final int POSTPONE_WINDOW_STATE_CHANGED_EVENT_TIMEOUT_MILLIS = 500;
    private static final String SET_PIP_ACTION_REPLACEMENT = "setPictureInPictureActionReplacingConnection";
    private static final int WAIT_FOR_USER_STATE_FULLY_INITIALIZED_MILLIS = 3000;
    private static final int WAIT_INPUT_FILTER_INSTALL_TIMEOUT_MS = 1000;
    private static int sIdCounter;
    private final AccessibilityDisplayListener mA11yDisplayListener;
    private SparseArray<SurfaceControl> mA11yOverlayLayers;
    private final AccessibilityWindowManager mA11yWindowManager;
    private final ActivityTaskManagerInternal mActivityTaskManagerService;
    private final CaptioningManagerImpl mCaptioningManagerImpl;
    private final Context mContext;
    private int mCurrentUserId;
    EditorInfo mEditorInfo;
    private AlertDialog mEnableTouchExplorationDialog;
    private FingerprintGestureDispatcher mFingerprintGestureDispatcher;
    private final FlashNotificationsController mFlashNotificationsController;
    private final RemoteCallbackList<IAccessibilityManagerClient> mGlobalClients;
    private boolean mHasInputFilter;
    private final HearingDevicePhoneCallNotificationController mHearingDeviceNotificationController;
    private boolean mInitialized;
    private boolean mInputBound;
    private AccessibilityInputFilter mInputFilter;
    private boolean mInputFilterInstalled;
    private final InputManager mInputManager;
    boolean mInputSessionRequested;
    private InteractionBridge mInteractionBridge;
    private boolean mIsAccessibilityButtonShown;
    private KeyEventDispatcher mKeyEventDispatcher;
    private InputManager.KeyGestureEventHandler mKeyGestureEventHandler;
    private final Object mLock;
    private final MagnificationController mMagnificationController;
    private final MagnificationProcessor mMagnificationProcessor;
    private final Handler mMainHandler;
    private SparseArray<MotionEventInjector> mMotionEventInjectors;
    private IObricAccessibilityManagerService mObricExt;
    private final PackageManager mPackageManager;
    private PackageMonitor mPackageMonitor;
    private final PowerManager mPowerManager;
    private final ProxyManager mProxyManager;
    private int mRealCurrentUserId;
    IRemoteAccessibilityInputConnection mRemoteInputConnection;
    boolean mRestarting;
    private final AccessibilitySecurityPolicy mSecurityPolicy;
    private final List<SendWindowStateChangedEventRunnable> mSendWindowStateChangedEventRunnables;
    private final TextUtils.SimpleStringSplitter mStringColonSplitter;
    private SystemActionPerformer mSystemActionPerformer;
    private final Set<ComponentName> mTempComponentNameSet;
    private final IntArray mTempIntArray;
    private Point mTempPoint;
    private final Rect mTempRect;
    private final Rect mTempRect1;
    private final AccessibilityTraceManager mTraceManager;
    private final UiAutomationManager mUiAutomationManager;
    private final UserManagerInternal mUmi;
    final HashSet<IUserInitializationCompleteCallback> mUserInitializationCompleteCallbacks;
    private final UserManager mUserManager;
    final SparseArray<AccessibilityUserState> mUserStates;
    private final SparseBooleanArray mVisibleBgUserIds;
    private final WindowManagerInternal mWindowManagerService;

    private final class AccessibilityContentObserver extends ContentObserver {
        private final Uri mAccessibilityButtonComponentIdUri;
        private final Uri mAccessibilityButtonTargetsUri;
        private final Uri mAccessibilityGestureTargetsUri;
        private final Uri mAccessibilityKeyGestureTargetsUri;
        private final Uri mAccessibilityShortcutServiceIdUri;
        private final Uri mAccessibilitySoftKeyboardModeUri;
        private final Uri mAlwaysOnMagnificationUri;
        private final Uri mAudioDescriptionByDefaultUri;
        private final Uri mAutoclickEnabledUri;
        private final Uri mEnabledAccessibilityServicesUri;
        private final Uri mHighTextContrastUri;
        private final Uri mMagnificationCapabilityUri;
        private final Uri mMagnificationFollowTypingUri;
        private final Uri mMagnificationModeUri;
        private final Uri mMagnificationTwoFingerTripleTapEnabledUri;
        private final Uri mMagnificationmSingleFingerTripleTapEnabledUri;
        private final Uri mMouseKeysUri;
        private final Uri mNavigationModeUri;
        private final Uri mRepeatKeysEnabledUri;
        private final Uri mRepeatKeysTimeoutMsUri;
        private final Uri mShowImeWithHardKeyboardUri;
        private final Uri mTouchExplorationEnabledUri;
        private final Uri mTouchExplorationGrantedAccessibilityServicesUri;
        private final Uri mUserInteractiveUiTimeoutUri;
        private final Uri mUserNonInteractiveUiTimeoutUri;
        private final Uri mUserSetupCompleteUri;
        final /* synthetic */ AccessibilityManagerService this$0;

        public AccessibilityContentObserver(AccessibilityManagerService r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
            this.mTouchExplorationEnabledUri = Settings.Secure.getUriFor("touch_exploration_enabled");
            this.mMagnificationmSingleFingerTripleTapEnabledUri = Settings.Secure.getUriFor("accessibility_display_magnification_enabled");
            this.mMagnificationTwoFingerTripleTapEnabledUri = Settings.Secure.getUriFor("accessibility_magnification_two_finger_triple_tap_enabled");
            this.mAutoclickEnabledUri = Settings.Secure.getUriFor("accessibility_autoclick_enabled");
            this.mEnabledAccessibilityServicesUri = Settings.Secure.getUriFor("enabled_accessibility_services");
            this.mTouchExplorationGrantedAccessibilityServicesUri = Settings.Secure.getUriFor("touch_exploration_granted_accessibility_services");
            this.mHighTextContrastUri = Settings.Secure.getUriFor("high_text_contrast_enabled");
            this.mAudioDescriptionByDefaultUri = Settings.Secure.getUriFor("enabled_accessibility_audio_description_by_default");
            this.mAccessibilitySoftKeyboardModeUri = Settings.Secure.getUriFor("accessibility_soft_keyboard_mode");
            this.mShowImeWithHardKeyboardUri = Settings.Secure.getUriFor("show_ime_with_hard_keyboard");
            this.mAccessibilityShortcutServiceIdUri = Settings.Secure.getUriFor("accessibility_shortcut_target_service");
            this.mAccessibilityButtonComponentIdUri = Settings.Secure.getUriFor("accessibility_button_target_component");
            this.mAccessibilityButtonTargetsUri = Settings.Secure.getUriFor("accessibility_button_targets");
            this.mAccessibilityGestureTargetsUri = Settings.Secure.getUriFor("accessibility_gesture_targets");
            this.mAccessibilityKeyGestureTargetsUri = Settings.Secure.getUriFor("accessibility_key_gesture_targets");
            this.mUserNonInteractiveUiTimeoutUri = Settings.Secure.getUriFor("accessibility_non_interactive_ui_timeout_ms");
            this.mUserInteractiveUiTimeoutUri = Settings.Secure.getUriFor("accessibility_interactive_ui_timeout_ms");
            this.mMagnificationModeUri = Settings.Secure.getUriFor("accessibility_magnification_mode");
            this.mMagnificationCapabilityUri = Settings.Secure.getUriFor("accessibility_magnification_capability");
            this.mMagnificationFollowTypingUri = Settings.Secure.getUriFor("accessibility_magnification_follow_typing_enabled");
            this.mAlwaysOnMagnificationUri = Settings.Secure.getUriFor("accessibility_magnification_always_on_enabled");
            this.mMouseKeysUri = Settings.Secure.getUriFor("accessibility_mouse_keys_enabled");
            this.mNavigationModeUri = Settings.Secure.getUriFor("navigation_mode");
            this.mUserSetupCompleteUri = Settings.Secure.getUriFor("user_setup_complete");
            this.mRepeatKeysEnabledUri = Settings.Secure.getUriFor("key_repeat_enabled");
            this.mRepeatKeysTimeoutMsUri = Settings.Secure.getUriFor("key_repeat_timeout");
        }

        public void register(ContentResolver contentResolver) {
            contentResolver.registerContentObserver(this.mTouchExplorationEnabledUri, false, this, -1);
            contentResolver.registerContentObserver(this.mMagnificationmSingleFingerTripleTapEnabledUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAutoclickEnabledUri, false, this, -1);
            contentResolver.registerContentObserver(this.mEnabledAccessibilityServicesUri, false, this, -1);
            contentResolver.registerContentObserver(this.mTouchExplorationGrantedAccessibilityServicesUri, false, this, -1);
            contentResolver.registerContentObserver(this.mHighTextContrastUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAudioDescriptionByDefaultUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAccessibilitySoftKeyboardModeUri, false, this, -1);
            contentResolver.registerContentObserver(this.mShowImeWithHardKeyboardUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAccessibilityShortcutServiceIdUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAccessibilityButtonComponentIdUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAccessibilityButtonTargetsUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAccessibilityGestureTargetsUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAccessibilityKeyGestureTargetsUri, false, this, -1);
            contentResolver.registerContentObserver(this.mUserNonInteractiveUiTimeoutUri, false, this, -1);
            contentResolver.registerContentObserver(this.mUserInteractiveUiTimeoutUri, false, this, -1);
            contentResolver.registerContentObserver(this.mMagnificationModeUri, false, this, -1);
            contentResolver.registerContentObserver(this.mMagnificationCapabilityUri, false, this, -1);
            contentResolver.registerContentObserver(this.mMagnificationFollowTypingUri, false, this, -1);
            contentResolver.registerContentObserver(this.mAlwaysOnMagnificationUri, false, this, -1);
            contentResolver.registerContentObserver(this.mMouseKeysUri, false, this, -1);
            contentResolver.registerContentObserver(this.mNavigationModeUri, false, this, -1);
            contentResolver.registerContentObserver(this.mUserSetupCompleteUri, false, this, -1);
            if (InputSettings.isRepeatKeysFeatureFlagEnabled() == false) goto L6;
            contentResolver.registerContentObserver(this.mRepeatKeysEnabledUri, false, this, -1);
            contentResolver.registerContentObserver(this.mRepeatKeysTimeoutMsUri, false, this, -1);
            return;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            Object r0 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            AccessibilityUserState userState = AccessibilityManagerService.m593$$Nest$mgetCurrentUserStateLocked(this.this$0);     // Catch: Throwable -> L9
            if (this.mTouchExplorationEnabledUri.equals(uri) == false) goto L12;
            if (AccessibilityManagerService.m615$$Nest$mreadTouchExplorationEnabledSettingLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
        L110:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (this.mMagnificationmSingleFingerTripleTapEnabledUri.equals(uri) == false) goto L17;
            if (AccessibilityManagerService.m613$$Nest$mreadMagnificationEnabledSettingsLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L17:
            if (this.mAutoclickEnabledUri.equals(uri) == false) goto L22;
            if (AccessibilityManagerService.m608$$Nest$mreadAutoclickEnabledSettingLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L22:
            if (this.mEnabledAccessibilityServicesUri.equals(uri) == false) goto L27;
            if (AccessibilityManagerService.m610$$Nest$mreadEnabledAccessibilityServicesLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m584$$Nest$fgetmSecurityPolicy(this.this$0).onEnabledServicesChangedLocked(userState.mUserId, userState.mEnabledServices);     // Catch: Throwable -> L9
            userState.removeDisabledServicesFromTemporaryStatesLocked();     // Catch: Throwable -> L9
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L27:
            if (this.mTouchExplorationGrantedAccessibilityServicesUri.equals(uri) == false) goto L32;
            if (AccessibilityManagerService.m616$$Nest$mreadTouchExplorationGrantedAccessibilityServicesLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L32:
            if (this.mHighTextContrastUri.equals(uri) == false) goto L37;
            if (AccessibilityManagerService.m611$$Nest$mreadHighTextContrastEnabledSettingLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L37:
            if (this.mAudioDescriptionByDefaultUri.equals(uri) == false) goto L42;
            if (AccessibilityManagerService.m607$$Nest$mreadAudioDescriptionEnabledSettingLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L42:
            if (this.mAccessibilitySoftKeyboardModeUri.equals(uri) == false) goto L44;
        L109:
            userState.reconcileSoftKeyboardModeWithSettingsLocked();     // Catch: Throwable -> L9
            goto L110
        L44:
            if (this.mShowImeWithHardKeyboardUri.equals(uri) == true) goto L109;
            if (this.mAccessibilityShortcutServiceIdUri.equals(uri) == false) goto L52;
            if (AccessibilityManagerService.m606$$Nest$mreadAccessibilityShortcutTargetsLocked(this.this$0, userState, 2) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L52:
            if (this.mAccessibilityButtonComponentIdUri.equals(uri) == false) goto L57;
            if (AccessibilityManagerService.m605$$Nest$mreadAccessibilityButtonTargetComponentLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L57:
            if (this.mAccessibilityButtonTargetsUri.equals(uri) == false) goto L62;
            if (AccessibilityManagerService.m606$$Nest$mreadAccessibilityShortcutTargetsLocked(this.this$0, userState, 1) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L62:
            if (this.mAccessibilityGestureTargetsUri.equals(uri) == false) goto L67;
            if (AccessibilityManagerService.m606$$Nest$mreadAccessibilityShortcutTargetsLocked(this.this$0, userState, 32) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L67:
            if (this.mAccessibilityKeyGestureTargetsUri.equals(uri) == false) goto L72;
            if (AccessibilityManagerService.m606$$Nest$mreadAccessibilityShortcutTargetsLocked(this.this$0, userState, 64) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L72:
            if (this.mUserNonInteractiveUiTimeoutUri.equals(uri) == false) goto L74;
        L108:
            AccessibilityManagerService.m617$$Nest$mreadUserRecommendedUiTimeoutSettingsLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L74:
            if (this.mUserInteractiveUiTimeoutUri.equals(uri) == true) goto L108;
            if (this.mMagnificationModeUri.equals(uri) == false) goto L82;
            if (AccessibilityManagerService.m614$$Nest$mreadMagnificationModeForDefaultDisplayLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m625$$Nest$mupdateMagnificationModeChangeSettingsLocked(this.this$0, userState, 0);     // Catch: Throwable -> L9
            goto L110
        L82:
            if (this.mMagnificationCapabilityUri.equals(uri) == false) goto L87;
            if (AccessibilityManagerService.m612$$Nest$mreadMagnificationCapabilitiesLocked(this.this$0, userState) == false) goto L110;
            AccessibilityManagerService.m623$$Nest$mupdateMagnificationCapabilitiesSettingsChangeLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L87:
            if (this.mMagnificationFollowTypingUri.equals(uri) == false) goto L90;
            this.this$0.readMagnificationFollowTypingLocked(userState);     // Catch: Throwable -> L9
            goto L110
        L90:
            if (this.mAlwaysOnMagnificationUri.equals(uri) == false) goto L93;
            this.this$0.readAlwaysOnMagnificationLocked(userState);     // Catch: Throwable -> L9
            goto L110
        L93:
            if (this.mMouseKeysUri.equals(uri) == false) goto L98;
            if (this.this$0.readMouseKeysEnabledLocked(userState) == false) goto L110;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.this$0, userState);     // Catch: Throwable -> L9
            goto L110
        L98:
            if (this.mNavigationModeUri.equals(uri) == true) goto L107;
            if (this.mUserSetupCompleteUri.equals(uri) == true) goto L107;
            if (this.mRepeatKeysEnabledUri.equals(uri) == false) goto L105;
        L106:
            this.this$0.readRepeatKeysSettingsLocked(userState);     // Catch: Throwable -> L9
            goto L110
        L105:
            if (this.mRepeatKeysTimeoutMsUri.equals(uri) == false) goto L110;
        L107:
            this.this$0.updateShortcutsForCurrentNavigationMode();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    public class AccessibilityDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManagerWrapper mDisplayManager;
        private final ArrayList<Display> mDisplaysList;
        private int mSystemUiUid;
        final /* synthetic */ AccessibilityManagerService this$0;

        static class DisplayManagerWrapper {
            private final DisplayManager mDm;

            DisplayManagerWrapper(Context context) {
                this.mDm = (DisplayManager) context.getSystemService(DisplayManager.class);
            }

            public void registerDisplayListener(DisplayManager.DisplayListener listener, Handler handler) {
                this.mDm.registerDisplayListener(listener, handler);
            }

            public Display[] getDisplays() {
                return this.mDm.getDisplays();
            }

            public Display getDisplay(int displayId) {
                return this.mDm.getDisplay(displayId);
            }
        }

        AccessibilityDisplayListener(AccessibilityManagerService this$0, DisplayManagerWrapper displayManager, Handler handler) {
            this.this$0 = this$0;
            this.mDisplaysList = new ArrayList();
            boolean isMainHandler = false;
            this.mSystemUiUid = 0;
            if (handler.getLooper() != Looper.getMainLooper()) goto L6;
            isMainHandler = true;
        L6:
            if (Build.IS_USERDEBUG == false) goto L8;
        L12:
            Preconditions.checkArgument(isMainHandler, "AccessibilityDisplayListener must use the main handler");
        L13:
            this.mDisplayManager = displayManager;
            this.mDisplayManager.registerDisplayListener(this, handler);
            initializeDisplayList();
            PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            if (pm == null) goto L17;
            this.mSystemUiUid = pm.getPackageUid(pm.getSystemUiServiceComponent().getPackageName(), DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES, AccessibilityManagerService.m576$$Nest$fgetmCurrentUserId(this$0));
            return;
        L17:
            return;
        L8:
            if (Build.IS_ENG == true) goto L12;
            if (isMainHandler == true) goto L13;
            Slog.e(AccessibilityManagerService.LOG_TAG, "AccessibilityDisplayListener must use the main handler");
            goto L13
        }

        public ArrayList<Display> getValidDisplayList() {
            Object r0 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            ArrayList<Display> r1 = this.mDisplaysList;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private void initializeDisplayList() {
            Display[] displays = this.mDisplayManager.getDisplays();
            Object r1 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            this.mDisplaysList.clear();     // Catch: Throwable -> L10
            int i = 0;
        L6:
            if (i >= displays.length) goto L14;
            Display display = displays[i];     // Catch: Throwable -> L10
            if (isValidDisplay(display) == false) goto L12;
            this.mDisplaysList.add(display);     // Catch: Throwable -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L10
            goto L6
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
            boolean isMainThread = Looper.getMainLooper().isCurrentThread();
            if (Build.IS_USERDEBUG == false) goto L5;
        L9:
            Preconditions.checkArgument(isMainThread, "onDisplayAdded must be called from the main thread");
        L10:
            Display display = this.mDisplayManager.getDisplay(displayId);
            if (isValidDisplay(display) == true) goto L13;
            return;
        L13:
            Object r3 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
            this.mDisplaysList.add(display);     // Catch: Throwable -> L18
            AccessibilityManagerService.m572$$Nest$fgetmA11yOverlayLayers(this.this$0).put(displayId, AccessibilityManagerService.m590$$Nest$fgetmWindowManagerService(this.this$0).getA11yOverlayLayer(displayId));     // Catch: Throwable -> L18
            if (AccessibilityManagerService.m578$$Nest$fgetmInputFilter(this.this$0) == null) goto L20;
            AccessibilityManagerService.m578$$Nest$fgetmInputFilter(this.this$0).onDisplayAdded(display);     // Catch: Throwable -> L18
        L20:
            AccessibilityUserState userState = AccessibilityManagerService.m593$$Nest$mgetCurrentUserStateLocked(this.this$0);     // Catch: Throwable -> L18
            List<AccessibilityServiceConnection> services = new ArrayList(userState.mBoundServices);     // Catch: Throwable -> L18
            AccessibilityManagerService.m624$$Nest$mupdateMagnificationLocked(this.this$0, userState);     // Catch: Throwable -> L18
            AccessibilityManagerService.m626$$Nest$mupdateWindowsForAccessibilityCallbackLocked(this.this$0, userState);     // Catch: Throwable -> L18
            this.this$0.notifyClearAccessibilityCacheLocked();     // Catch: Throwable -> L18
            monitor-exit(r3);     // Catch: Throwable -> L18
            if (displayId == 0) goto L27;
            int i = 0;
        L25:
            if (i >= services.size()) goto L33;
            AccessibilityServiceConnection boundClient = services.get(i);
            boundClient.addWindowTokenForDisplay(displayId);
            i = i + 1;
            goto L25
        L33:
            return;
        L27:
            return;
        L18:
            th = move-exception;
            throw th;
        L5:
            if (Build.IS_ENG == true) goto L9;
            if (isMainThread == true) goto L10;
            Slog.e(AccessibilityManagerService.LOG_TAG, "onDisplayAdded must be called from the main thread");
            goto L10
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
            boolean isMainThread = Looper.getMainLooper().isCurrentThread();
            if (Build.IS_USERDEBUG == false) goto L5;
        L9:
            Preconditions.checkArgument(isMainThread, "onDisplayRemoved must be called from the main thread");
        L10:
            Object r2 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
        L16:
            th = move-exception;
            throw th;
        L13:
            if (removeDisplayFromList(displayId) == true) goto L18;
            monitor-exit(r2);     // Catch: Throwable -> L16
            return;
        L18:
            AccessibilityManagerService.m572$$Nest$fgetmA11yOverlayLayers(this.this$0).remove(displayId);     // Catch: Throwable -> L16
            if (AccessibilityManagerService.m578$$Nest$fgetmInputFilter(this.this$0) == null) goto L21;
            AccessibilityManagerService.m578$$Nest$fgetmInputFilter(this.this$0).onDisplayRemoved(displayId);     // Catch: Throwable -> L16
        L21:
            AccessibilityUserState userState = AccessibilityManagerService.m593$$Nest$mgetCurrentUserStateLocked(this.this$0);     // Catch: Throwable -> L16
            if (displayId == 0) goto L27;
            List<AccessibilityServiceConnection> services = userState.mBoundServices;     // Catch: Throwable -> L16
            int i = 0;
        L25:
            if (i >= services.size()) goto L27;
            AccessibilityServiceConnection boundClient = services.get(i);     // Catch: Throwable -> L16
            boundClient.onDisplayRemoved(displayId);     // Catch: Throwable -> L16
            i = i + 1;     // Catch: Throwable -> L16
        L27:
            monitor-exit(r2);     // Catch: Throwable -> L16
            AccessibilityManagerService.m580$$Nest$fgetmMagnificationController(this.this$0).onDisplayRemoved(displayId);
            AccessibilityManagerService.m573$$Nest$fgetmA11yWindowManager(this.this$0).stopTrackingWindows(displayId);
            return;
        L5:
            if (Build.IS_ENG == true) goto L9;
            if (isMainThread == true) goto L10;
            Slog.e(AccessibilityManagerService.LOG_TAG, "onDisplayRemoved must be called from the main thread");
            goto L10
        }

        private boolean removeDisplayFromList(int displayId) {
            int i = 0;
        L4:
            if (i >= this.mDisplaysList.size()) goto L10;
            if (this.mDisplaysList.get(i).getDisplayId() == displayId) goto L7;
            i = i + 1;
            goto L4
        L7:
            this.mDisplaysList.remove(i);
            return true;
        L10:
            return false;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
        }

        void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            pw.println("Accessibility Display Listener:");
            pw.println("    SystemUI uid: " + this.mSystemUiUid);
            int size = this.mDisplaysList.size();
            Integer r1 = Integer.valueOf(size);
            if (size != 1) goto L5;
            String r2 = "";
        L6:
            pw.printf("    %d valid display%s: ", new Object[]{r1, r2});
            int i = 0;
        L7:
            if (i >= size) goto L12;
            pw.print(this.mDisplaysList.get(i).getDisplayId());
            if (i >= (size - 1)) goto L11;
            pw.print(", ");
        L11:
            i = i + 1;
            goto L7
        L12:
            pw.println();
            return;
        L5:
            r2 = "s";
            goto L6
        }

        private boolean isValidDisplay(Display display) {
            if (display != null) goto L6;
            return false;
        L6:
            if (display.getType() == 5) goto L8;
            return true;
        L8:
            if ((display.getFlags() & 4) != 0) goto L10;
            return true;
        L10:
            if (display.getOwnerUid() == this.mSystemUiUid) goto L15;
            return false;
        L15:
            return true;
        }
    }

    class Client {
        final IAccessibilityManagerClient mCallback;
        int mDeviceId;
        int mLastSentRelevantEventTypes;
        final String[] mPackageNames;
        int mUid;

        /* synthetic */ Client(AccessibilityManagerService r1, IAccessibilityManagerClient r2, int r3, AccessibilityUserState r4, int r5, AccessibilityManagerServiceIA r6) {
            this(r1, r2, r3, r4, r5);
        }

        private Client(AccessibilityManagerService this$0, IAccessibilityManagerClient callback, int clientUid, AccessibilityUserState userState, int deviceId) {
            this.mDeviceId = 0;
            this.mCallback = callback;
            this.mPackageNames = AccessibilityManagerService.m582$$Nest$fgetmPackageManager(this$0).getPackagesForUid(clientUid);
            this.mUid = clientUid;
            this.mDeviceId = deviceId;
            Object r0 = AccessibilityManagerService.m579$$Nest$fgetmLock(this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (AccessibilityManagerService.m583$$Nest$fgetmProxyManager(this$0).isProxyedDeviceId(deviceId) == false) goto L9;
            this.mLastSentRelevantEventTypes = AccessibilityManagerService.m583$$Nest$fgetmProxyManager(this$0).computeRelevantEventTypesLocked(this);     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            this.mLastSentRelevantEventTypes = AccessibilityManagerService.m591$$Nest$mcomputeRelevantEventTypesLocked(this$0, userState, this);     // Catch: Throwable -> L7
            goto L10
        }
    }

    private final class InteractionBridge {
        private final ComponentName COMPONENT_NAME;
        private final AccessibilityInteractionClient mClient;
        private final int mConnectionId;
        private final Display mDefaultDisplay;
        final /* synthetic */ AccessibilityManagerService this$0;

        public InteractionBridge(final AccessibilityManagerService r18) {
            this.this$0 = r18;
            this.COMPONENT_NAME = new ComponentName("com.android.server.accessibility", "InteractionBridge");
            final AccessibilityServiceInfo info = new AccessibilityServiceInfo();
            info.setCapabilities(1);
            info.flags |= 64;
            info.flags |= 2;
            info.setAccessibilityTool(true);
            Object r2 = AccessibilityManagerService.m579$$Nest$fgetmLock(r18);
            monitor-enter(r2);
            final AccessibilityUserState userState = AccessibilityManagerService.m593$$Nest$mgetCurrentUserStateLocked(r18);     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
            final Context r3 = AccessibilityManagerService.m575$$Nest$fgetmContext(r18);
            final ComponentName r4 = this.COMPONENT_NAME;
            final int r6 = AccessibilityManagerService.m627$$Nest$sfgetsIdCounter();
            AccessibilityManagerService.m628$$Nest$sfputsIdCounter(r6 + 1);
            final Handler r7 = AccessibilityManagerService.m581$$Nest$fgetmMainHandler(r18);
            final Object r8 = AccessibilityManagerService.m579$$Nest$fgetmLock(r18);
            final AccessibilitySecurityPolicy r9 = AccessibilityManagerService.m584$$Nest$fgetmSecurityPolicy(r18);
            final AccessibilityTraceManager r11 = r18.getTraceManager();
            final WindowManagerInternal r12 = AccessibilityManagerService.m590$$Nest$fgetmWindowManagerService(r18);
            final SystemActionPerformer r13 = AccessibilityManagerService.m595$$Nest$mgetSystemActionPerformer(r18);
            final AccessibilityWindowManager r14 = AccessibilityManagerService.m573$$Nest$fgetmA11yWindowManager(r18);
            final ActivityTaskManagerInternal r15 = AccessibilityManagerService.m574$$Nest$fgetmActivityTaskManagerService(r18);
            AccessibilityServiceConnection service = new AnonymousClass1(this, userState, r3, r4, info, r6, r7, r8, r9, r18, r11, r12, r13, r14, r15, r18);
            this.mConnectionId = service.mId;
            this.mClient = AccessibilityInteractionClient.getInstance(AccessibilityManagerService.m575$$Nest$fgetmContext(r18));
            AccessibilityInteractionClient.addConnection(this.mConnectionId, service, false);
            DisplayManager displayManager = (DisplayManager) AccessibilityManagerService.m575$$Nest$fgetmContext(r18).getSystemService("display");
            this.mDefaultDisplay = displayManager.getDisplay(0);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        boolean getAccessibilityFocusClickPointInScreen(Point outPoint) {
            return AccessibilityManagerService.m594$$Nest$mgetInteractionBridge(this.this$0).getAccessibilityFocusClickPointInScreenNotLocked(outPoint);
        }

        public boolean performActionOnAccessibilityFocusedItemNotLocked(AccessibilityNodeInfo.AccessibilityAction action) {
            AccessibilityNodeInfo focus = getAccessibilityFocusNotLocked();
            if (focus != null) goto L5;
            return false;
        L5:
            if (focus.getActionList().contains(action) == true) goto L8;
            return false;
        L8:
            return focus.performAction(action.getId());
        }

        public boolean getAccessibilityFocusClickPointInScreenNotLocked(Point outPoint) {
            AccessibilityNodeInfo focus = getAccessibilityFocusNotLocked();
            if (focus != null) goto L5;
            return false;
        L5:
            Object r2 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            Rect boundsInScreenBeforeMagnification = AccessibilityManagerService.m587$$Nest$fgetmTempRect(this.this$0);     // Catch: Throwable -> L12
            focus.getBoundsInScreen(boundsInScreenBeforeMagnification);     // Catch: Throwable -> L12
            Point nodeCenter = new Point(boundsInScreenBeforeMagnification.centerX(), boundsInScreenBeforeMagnification.centerY());     // Catch: Throwable -> L12
            Pair<float[], MagnificationSpec> pair = this.this$0.getWindowTransformationMatrixAndMagnificationSpec(focus.getWindowId());     // Catch: Throwable -> L12
            MagnificationSpec spec = null;
            if (pair != null) goto L10;
        L14:
            if (spec != null) goto L16;
        L18:
            Rect windowBounds = AccessibilityManagerService.m588$$Nest$fgetmTempRect1(this.this$0);     // Catch: Throwable -> L12
            AccessibilityWindowInfo window = focus.getWindow();     // Catch: Throwable -> L12
            if (window == null) goto L22;
            window.getBoundsInScreen(windowBounds);     // Catch: Throwable -> L12
        L22:
            if (boundsInScreenBeforeMagnification.intersect(windowBounds) == true) goto L25;
            monitor-exit(r2);     // Catch: Throwable -> L12
            return false;
        L25:
            Point screenSize = AccessibilityManagerService.m586$$Nest$fgetmTempPoint(this.this$0);     // Catch: Throwable -> L12
            this.mDefaultDisplay.getRealSize(screenSize);     // Catch: Throwable -> L12
            if (boundsInScreenBeforeMagnification.intersect(0, 0, screenSize.x, screenSize.y) == true) goto L29;
            monitor-exit(r2);     // Catch: Throwable -> L12
            return false;
        L29:
            outPoint.set(nodeCenter.x, nodeCenter.y);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            return true;
        L16:
            if (spec.isNop() == true) goto L18;
            boundsInScreenBeforeMagnification.offset((int) (-spec.offsetX), (int) (-spec.offsetY));     // Catch: Throwable -> L12
            boundsInScreenBeforeMagnification.scale(1.0f / spec.scale);     // Catch: Throwable -> L12
            goto L18
        L10:
            if (pair.second == null) goto L14;
            spec = new MagnificationSpec();     // Catch: Throwable -> L12
            spec.setTo((MagnificationSpec) pair.second);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        private AccessibilityNodeInfo getAccessibilityFocusNotLocked() {
            Object r0 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int focusedWindowId = AccessibilityManagerService.m573$$Nest$fgetmA11yWindowManager(this.this$0).getFocusedWindowId(2);     // Catch: Throwable -> L9
            if (focusedWindowId != (-1)) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return getAccessibilityFocusNotLocked(focusedWindowId);
        L9:
            th = move-exception;
            throw th;
        }

        private AccessibilityNodeInfo getAccessibilityFocusNotLocked(int windowId) {
            return this.mClient.findFocus(this.mConnectionId, windowId, AccessibilityNodeInfo.ROOT_NODE_ID, 2);
        }
    }

    public static final class Lifecycle extends SystemService {
        private final AccessibilityManagerService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new AccessibilityManagerService(context);
        }

        public Lifecycle(Context context, AccessibilityManagerService service) {
            super(context);
            this.mService = service;
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            LocalServices.addService(AccessibilityManagerInternal.class, new LocalServiceImpl(this.mService));
            publishBinderService("accessibility", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            AccessibilityManagerService.m599$$Nest$monBootPhase(this.mService, phase);
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
            super.onUserSwitching(from, to);
        }
    }

    private static final class LocalServiceImpl extends AccessibilityManagerInternal {
        private final AccessibilityManagerService mService;

        LocalServiceImpl(AccessibilityManagerService service) {
            this.mService = service;
        }

        @Override // com.android.server.AccessibilityManagerInternal
        public void setImeSessionEnabled(SparseArray<IAccessibilityInputMethodSession> sessions, boolean enabled) {
            this.mService.scheduleSetImeSessionEnabled(sessions, enabled);
        }

        @Override // com.android.server.AccessibilityManagerInternal
        public void unbindInput() {
            this.mService.scheduleUnbindInput();
        }

        @Override // com.android.server.AccessibilityManagerInternal
        public void bindInput() {
            this.mService.scheduleBindInput();
        }

        @Override // com.android.server.AccessibilityManagerInternal
        public void createImeSession(ArraySet<Integer> ignoreSet) {
            this.mService.scheduleCreateImeSession(ignoreSet);
        }

        @Override // com.android.server.AccessibilityManagerInternal
        public void startInput(IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, EditorInfo editorInfo, boolean restarting) {
            this.mService.scheduleStartInput(remoteAccessibilityInputConnection, editorInfo, restarting);
        }

        @Override // com.android.server.AccessibilityManagerInternal
        public void performSystemAction(int actionId) {
            AccessibilityManagerService.m595$$Nest$mgetSystemActionPerformer(this.mService).performSystemAction(actionId);
        }

        @Override // com.android.server.AccessibilityManagerInternal
        public boolean isTouchExplorationEnabled(int userId) {
            Object r0 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.mService);
            monitor-enter(r0);
            boolean r1 = AccessibilityManagerService.m596$$Nest$mgetUserStateLocked(this.mService, userId).isTouchExplorationEnabledLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class MainHandler extends Handler {
        public static final int MSG_SEND_KEY_EVENT_TO_INPUT_FILTER = 8;
        final /* synthetic */ AccessibilityManagerService this$0;

        public MainHandler(AccessibilityManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 8) goto L17;
            KeyEvent event = (KeyEvent) msg.obj;
            int policyFlags = msg.arg1;
            Object r2 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (AccessibilityManagerService.m577$$Nest$fgetmHasInputFilter(this.this$0) == true) goto L9;
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L11
            event.recycle();
            return;
        L9:
            if (AccessibilityManagerService.m578$$Nest$fgetmInputFilter(this.this$0) == null) goto L13;
            AccessibilityManagerService.m578$$Nest$fgetmInputFilter(this.this$0).sendInputEvent(event, policyFlags);     // Catch: Throwable -> L11
            goto L13
        }
    }

    public static class ManagerPackageMonitor extends PackageMonitor {
        private final AccessibilityManagerService mManagerService;

        public static /* synthetic */ boolean $r8$lambda$Bop3hOfSsyTTVh4uqhghkHVpW6s(String r0, ComponentName r1) {
            return lambda$onPackageUpdateFinished$0(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$RSPJeTjsuoqAPUWUkwoupUzsuO4(ComponentName r0, String r1) {
            return lambda$onHandleForceStop$2(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$V1BE6ithcLF5P-OqA3TXks0qHec, reason: not valid java name */
        public static /* synthetic */ boolean m629$r8$lambda$V1BE6ithcLF5POqA3TXks0qHec(String r0, ComponentName r1) {
            return lambda$onPackageUpdateFinished$1(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$eNpjW43pGVN4cMeU_g-MYPC-bGY, reason: not valid java name */
        public static /* synthetic */ boolean m630$r8$lambda$eNpjW43pGVN4cMeU_gMYPCbGY(String[] r0, ComponentName r1) {
            return lambda$onHandleForceStop$3(r0, r1);
        }

        public ManagerPackageMonitor(AccessibilityManagerService managerService) {
            super(true);
            this.mManagerService = managerService;
        }

        public void onSomePackagesChanged() {
            if (AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).isA11yTracingEnabledForTypes(32768) == false) goto L5;
            AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).logTrace("AccessibilityManagerService.PM.onSomePackagesChanged", 32768);
        L5:
            int userId = getChangingUserId();
            List<AccessibilityServiceInfo> parsedAccessibilityServiceInfos = AccessibilityManagerService.m603$$Nest$mparseAccessibilityServiceInfos(this.mManagerService, userId);
            List<AccessibilityShortcutInfo> parsedAccessibilityShortcutInfos = AccessibilityManagerService.m604$$Nest$mparseAccessibilityShortcutInfos(this.mManagerService, userId);
            Set<ComponentName> validA11yTileServices = AccessibilityTileUtils.getValidA11yTileServices(AccessibilityManagerService.m575$$Nest$fgetmContext(this.mManagerService), (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), parsedAccessibilityServiceInfos, parsedAccessibilityShortcutInfos, userId);
            Object r4 = this.mManagerService.getLock();
            monitor-enter(r4);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (userId == this.mManagerService.getCurrentUserIdLocked()) goto L14;
            monitor-exit(r4);     // Catch: Throwable -> L11
            return;
        L14:
            if (AccessibilityManagerService.m597$$Nest$misServiceInitializedLocked(this.mManagerService) == true) goto L18;
            Slog.w(AccessibilityManagerService.LOG_TAG, "onSomePackagesChanged: service not initialized, skip the callback.");     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            return;
        L18:
            AccessibilityManagerService.m601$$Nest$monSomePackagesChangedLocked(this.mManagerService, parsedAccessibilityServiceInfos, parsedAccessibilityShortcutInfos, validA11yTileServices);     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
        }

        public void onPackageUpdateFinished(final String packageName, int uid) {
            if (AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).isA11yTracingEnabledForTypes(32768) == false) goto L5;
            AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).logTrace("AccessibilityManagerService.PM.onPackageUpdateFinished", 32768, "packageName=" + packageName + ";uid=" + uid);
        L5:
            int userId = getChangingUserId();
            List<AccessibilityServiceInfo> parsedAccessibilityServiceInfos = AccessibilityManagerService.m603$$Nest$mparseAccessibilityServiceInfos(this.mManagerService, userId);
            List<AccessibilityShortcutInfo> parsedAccessibilityShortcutInfos = AccessibilityManagerService.m604$$Nest$mparseAccessibilityShortcutInfos(this.mManagerService, userId);
            Set<ComponentName> validA11yTileServices = AccessibilityTileUtils.getValidA11yTileServices(AccessibilityManagerService.m575$$Nest$fgetmContext(this.mManagerService), (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), parsedAccessibilityServiceInfos, parsedAccessibilityShortcutInfos, userId);
            Object r4 = this.mManagerService.getLock();
            monitor-enter(r4);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (userId == this.mManagerService.getCurrentUserIdLocked()) goto L13;
            monitor-exit(r4);     // Catch: Throwable -> L11
            return;
        L13:
            AccessibilityUserState userState = AccessibilityManagerService.m596$$Nest$mgetUserStateLocked(this.mManagerService, userId);     // Catch: Throwable -> L11
            if (userState.getBindingServicesLocked().removeIf(new AccessibilityManagerService$ManagerPackageMonitor$$ExternalSyntheticLambda0(packageName)) == false) goto L16;
        L19:
            boolean reboundAService = true;
        L20:
            userState.mInstalledServices.clear();     // Catch: Throwable -> L11
            boolean configurationChanged = AccessibilityManagerService.m609$$Nest$mreadConfigurationForUserStateLocked(this.mManagerService, userState, parsedAccessibilityServiceInfos, parsedAccessibilityShortcutInfos, validA11yTileServices);     // Catch: Throwable -> L11
            if (reboundAService == true) goto L23;
            if (configurationChanged == true) goto L23;
        L24:
            AccessibilityManagerService.m598$$Nest$mmigrateAccessibilityButtonSettingsIfNecessaryLocked(this.mManagerService, userState, packageName, 0);     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            return;
        L23:
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.mManagerService, userState);     // Catch: Throwable -> L11
            goto L24
        L16:
            if (userState.mCrashedServices.removeIf(new AccessibilityManagerService$ManagerPackageMonitor$$ExternalSyntheticLambda1(packageName)) == true) goto L19;
            reboundAService = false;
            goto L20
        }

        private static /* synthetic */ boolean lambda$onPackageUpdateFinished$0(String packageName, ComponentName component) {
            if (component != null) goto L4;
        L6:
            return false;
        L4:
            if (component.getPackageName().equals(packageName) == false) goto L6;
            return true;
        }

        private static /* synthetic */ boolean lambda$onPackageUpdateFinished$1(String packageName, ComponentName component) {
            if (component != null) goto L4;
        L6:
            return false;
        L4:
            if (component.getPackageName().equals(packageName) == false) goto L6;
            return true;
        }

        public void onPackageRemoved(String packageName, int uid) {
            if (AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).isA11yTracingEnabledForTypes(32768) == false) goto L5;
            AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).logTrace("AccessibilityManagerService.PM.onPackageRemoved", 32768, "packageName=" + packageName + ";uid=" + uid);
        L5:
            Object r0 = this.mManagerService.getLock();
            monitor-enter(r0);
            int userId = getChangingUserId();     // Catch: Throwable -> L11
            if (userId == this.mManagerService.getCurrentUserIdLocked()) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            AccessibilityManagerService.m600$$Nest$monPackageRemovedLocked(this.mManagerService, packageName);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean onHandleForceStop(Intent intent, final String[] packages, int uid, boolean doit) {
            if (AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).isA11yTracingEnabledForTypes(32768) == false) goto L5;
            AccessibilityManagerService.m589$$Nest$fgetmTraceManager(this.mManagerService).logTrace("AccessibilityManagerService.PM.onHandleForceStop", 32768, "intent=" + intent + ";packages=" + Arrays.toString(packages) + ";uid=" + uid + ";doit=" + doit);
        L5:
            Object r0 = this.mManagerService.getLock();
            monitor-enter(r0);
            int userId = getChangingUserId();     // Catch: Throwable -> L11
            if (userId == this.mManagerService.getCurrentUserIdLocked()) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        L13:
            AccessibilityUserState userState = AccessibilityManagerService.m596$$Nest$mgetUserStateLocked(this.mManagerService, userId);     // Catch: Throwable -> L11
            if (doit == true) goto L19;
            boolean r3 = userState.mEnabledServices.stream().anyMatch(new AccessibilityManagerService$ManagerPackageMonitor$$ExternalSyntheticLambda3(packages));     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r3;
        L19:
            if (this.mManagerService.onPackagesForceStoppedLocked(packages, userState) == false) goto L21;
            AccessibilityManagerService.m602$$Nest$monUserStateChangedLocked(this.mManagerService, userState);     // Catch: Throwable -> L11
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        L11:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ boolean lambda$onHandleForceStop$3(String[] packages, final ComponentName comp) {
            return Arrays.stream(packages).anyMatch(new AccessibilityManagerService$ManagerPackageMonitor$$ExternalSyntheticLambda2(comp));
        }

        private static /* synthetic */ boolean lambda$onHandleForceStop$2(ComponentName comp, String pkg) {
            return pkg.equals(comp.getPackageName());
        }

        public boolean onPackageChanged(String packageName, int uid, String[] components) {
            return true;
        }
    }

    private final class SendWindowStateChangedEventRunnable implements Runnable {
        private final AccessibilityEvent mPendingEvent;
        private final int mWindowId;
        final /* synthetic */ AccessibilityManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$mgetWindowId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m631$$Nest$mgetWindowId(SendWindowStateChangedEventRunnable r0) {
            return r0.getWindowId();
        }

        /* JADX INFO: renamed from: -$$Nest$msendPendingEventLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m632$$Nest$msendPendingEventLocked(SendWindowStateChangedEventRunnable r0) {
            r0.sendPendingEventLocked();
        }

        SendWindowStateChangedEventRunnable(AccessibilityManagerService r1, AccessibilityEvent event) {
            this.this$0 = r1;
            this.mPendingEvent = event;
            this.mWindowId = event.getWindowId();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = AccessibilityManagerService.m579$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Slog.w(AccessibilityManagerService.LOG_TAG, " wait for adding window timeout: " + this.mWindowId);     // Catch: Throwable -> L7
            sendPendingEventLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void sendPendingEventLocked() {
            AccessibilityManagerService.m585$$Nest$fgetmSendWindowStateChangedEventRunnables(this.this$0).remove(this);
            AccessibilityManagerService.m592$$Nest$mdispatchAccessibilityEventLocked(this.this$0, this.mPendingEvent);
        }

        private int getWindowId() {
            return this.mWindowId;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-GB1y0gd8LNs9Vp3jGe9WBDySM0, reason: not valid java name */
    public static /* synthetic */ boolean m545$r8$lambda$GB1y0gd8LNs9Vp3jGe9WBDySM0(ArrayList r0, String r1) {
        return lambda$onPackagesForceStoppedLocked$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$0O2rQTJlkLko4GWdb9xa8O-RN88, reason: not valid java name */
    public static /* synthetic */ boolean m546$r8$lambda$0O2rQTJlkLko4GWdb9xa8ORN88(ArraySet r0, ComponentName r1) {
        return lambda$notifyQuickSettingsTilesChanged$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$1PR6ml_tL6uKaEr5vn8_vVPfceM(AccessibilityManagerService r0, int r1) {
        r0.requestDelegatingInternal(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$3VvH2ROFG9nWjiZB3GRL2PX2LM4(String r0, ComponentName r1) {
        return lambda$onPackagesForceStoppedLocked$5(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$4VPD6WAAxpJCTBHJTQUJbsReOMw(List r0, AccessibilityShortcutInfo r1) {
        return lambda$readInstalledAccessibilityShortcutLocked$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$5j_fAHf7yG7gPkZMZetpjo5F7fg(AccessibilityManagerService r0, AccessibilityUserState r1, Client r2) {
        r0.lambda$updateRelevantEventsLocked$19(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$5xHpaNUCOA2l74Zy0beLPKMnKW4(AccessibilityManagerService r0, AccessibilityEvent r1) {
        r0.sendAccessibilityEventToInputFilter(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$6m1VITGT1Rakbxsv4ZB-hc6Ilrs, reason: not valid java name */
    public static /* synthetic */ boolean m547$r8$lambda$6m1VITGT1Rakbxsv4ZBhc6Ilrs(Set r0, ComponentName r1) {
        return lambda$onPackagesForceStoppedLocked$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$807oSU31V42pxXEUNu07UmGul_8(AccessibilityManagerService r0, Intent r1, Bundle r2, int r3) {
        r0.lambda$showAccessibilityTargetsSelection$16(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$CjA67pnoYlCWbAdI3y6zECyh0-U, reason: not valid java name */
    public static /* synthetic */ void m548$r8$lambda$CjA67pnoYlCWbAdI3y6zECyh0U(AccessibilityManagerService r0, int r1, Object r2) {
        r0.lambda$sendStateToClients$26(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$EHrBudcq4yFlHS_l05G9N-k-DjY, reason: not valid java name */
    public static /* synthetic */ boolean m549$r8$lambda$EHrBudcq4yFlHS_l05G9NkDjY(AccessibilityManagerService r0, ComponentName r1) {
        return r0.lambda$updateServicesLocked$25(r1);
    }

    public static /* synthetic */ void $r8$lambda$FCnKv_Ut84T3aNcEnU4D12D8l6Y(AccessibilityManagerService r0, RemoteCallbackList r1, long r2) {
        r0.sendServicesStateChanged(r1, r2);
    }

    public static /* synthetic */ ComponentName $r8$lambda$IVN1Po59hSlqZd_064o3iBKncpw(String r0) {
        return lambda$readComponentNamesFromStringLocked$22(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$J1_Y72KF2O09X0dlZxgt-JoFfhY, reason: not valid java name */
    public static /* synthetic */ void m550$r8$lambda$J1_Y72KF2O09X0dlZxgtJoFfhY(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.lambda$updateRelevantEventsLocked$20(r1);
    }

    public static /* synthetic */ void $r8$lambda$JB6TZPFG0N2h7zdKOCgM4OOCpf8(AccessibilityManagerService r0, IRemoteAccessibilityInputConnection r1, EditorInfo r2, boolean r3) {
        r0.startInput(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$KDkUkVoir8xr8jfeezF_ApFpPrE(AccessibilityManagerService r0, int r1, boolean r2) {
        r0.lambda$new$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$KFC275e1a0Nf4HzkH5ujj0liXIg(AccessibilityManagerService r0, int r1, int r2) {
        r0.sendStateToClients(r1, r2);
    }

    public static /* synthetic */ ComponentName $r8$lambda$KG9vcLxlIrM8_unQKhY_s9H1JTM(String r0) {
        return lambda$readComponentNamesFromSettingLocked$21(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$KfrZyDTSdCqhS-6SY_8RFDQDcNQ, reason: not valid java name */
    public static /* synthetic */ boolean m551$r8$lambda$KfrZyDTSdCqhS6SY_8RFDQDcNQ(ComponentName r0, String r1) {
        return lambda$restoreShortcutTargets$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$LOsPRWSQw_6aOpWxH0oEAY9FD88(AccessibilityManagerService r0, int r1) {
        r0.lambda$persistMagnificationModeSettingsLocked$42(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$La-BLHbgALe4tcEWYMX7nFW1fco, reason: not valid java name */
    public static /* synthetic */ String m552$r8$lambda$LaBLHbgALe4tcEWYMX7nFW1fco(String r0) {
        return lambda$updateAccessibilityShortcutTargetsLocked$30(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$MUdW9WWPg_0AZd-g9ONMSwqzpeE, reason: not valid java name */
    public static /* synthetic */ String m553$r8$lambda$MUdW9WWPg_0AZdg9ONMSwqzpeE(String r0) {
        return lambda$onPackagesForceStoppedLocked$7(r0);
    }

    public static /* synthetic */ String $r8$lambda$NFExAkF3UHTVDCPvDXKprTCxHVg(String r0) {
        return lambda$removeShortcutTargetForUnboundServiceLocked$35(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$NnE01Yr1pVYuCQHn2ZgmQmyq-RQ, reason: not valid java name */
    public static /* synthetic */ void m554$r8$lambda$NnE01Yr1pVYuCQHn2ZgmQmyqRQ(AccessibilityManagerService r0, AccessibilityServiceConnection r1) {
        r0.bindAndStartInputForConnection(r1);
    }

    public static /* synthetic */ void $r8$lambda$OkBmdc4YBk21wEp9qXhLJJPapUg(AccessibilityManagerService r0, int r1, int r2) {
        r0.requestDraggingInternal(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Qha0yO4BlErsZ1OeDWa1PxGEaNA(AccessibilityManagerService r0, ArraySet r1) {
        r0.createImeSession(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$RexcBeq-vRIqlSnY_M-NSroyMQ8, reason: not valid java name */
    public static /* synthetic */ void m555$r8$lambda$RexcBeqvRIqlSnY_MNSroyMQ8(AccessibilityManagerService r0, AccessibilityServiceConnection r1) {
        r0.createSessionForConnection(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$SfBo9mHwtUXbxdHni-xpUiWBZEw, reason: not valid java name */
    public static /* synthetic */ String m556$r8$lambda$SfBo9mHwtUXbxdHnixpUiWBZEw(String r0) {
        return lambda$restoreShortcutTargets$14(r0);
    }

    public static /* synthetic */ void $r8$lambda$SknwGcwcMDmGxwG60sVoT7zfy1c(AccessibilityManagerService r0, KeyGestureEvent r1, IBinder r2) {
        r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$UNs_lJpq-hli2-6MIRQkxPwYXLc, reason: not valid java name */
    public static /* synthetic */ void m557$r8$lambda$UNs_lJpqhli26MIRQkxPwYXLc(AccessibilityManagerService r0, AccessibilityServiceConnection r1) {
        r0.unbindInputForConnection(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$VKjlp648ix59dgFu8AF51E3dYJg(Set r0, String r1) {
        return lambda$updateA11yTileServicesInQuickSettingsPanel$38(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Whte7PSa5Ig8KoUhtaFoVm3QBC0(AccessibilityManagerService r0, AccessibilityServiceConnection r1) {
        r0.showEnableTouchExplorationDialog(r1);
    }

    public static /* synthetic */ void $r8$lambda$XQ4GLBALxOr8jduskNTp9QCV1fQ(String r0, AccessibilityUserState r1, Set r2, Set r3, Set r4, Set r5, ComponentName r6) {
        lambda$migrateAccessibilityButtonSettingsIfNecessaryLocked$33(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$XpL8pm9VEQwLAqYA1AVZJvP4ZkA(AccessibilityManagerService r0) {
        r0.bindInput();
    }

    public static /* synthetic */ void $r8$lambda$Y3w54xED7XVYtOWOW0empDazmx0(AccessibilityManagerService r0, int r1) {
        r0.onDoubleTapInternal(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$YLEkfjtTlLTZ1-a_Pi0p4C0EU8s, reason: not valid java name */
    public static /* synthetic */ void m558$r8$lambda$YLEkfjtTlLTZ1a_Pi0p4C0EU8s(Map r0, Set r1, StatusBarManagerInternal r2, String r3) {
        lambda$updateA11yTileServicesInQuickSettingsPanel$41(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$YlT_cQFJkDvmLSRcxA4KbKan2IM(AccessibilityManagerService r0, int r1, Region r2) {
        r0.setGestureDetectionPassthroughRegionInternal(r1, r2);
    }

    public static /* synthetic */ String $r8$lambda$ZZQ18NCDGqpbjIwaHP7owqjTuT4(String r0) {
        return lambda$restoreShortcutTargets$15(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Zv7Y_tLjzzPTWHBU-90nEo3JS94, reason: not valid java name */
    public static /* synthetic */ String m559$r8$lambda$Zv7Y_tLjzzPTWHBU90nEo3JS94(String r0) {
        return lambda$readAccessibilityShortcutTargetsLocked$28(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$_gBIiOvr-Vr0gJkDVFAi3JBURXE, reason: not valid java name */
    public static /* synthetic */ void m560$r8$lambda$_gBIiOvrVr0gJkDVFAi3JBURXE(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.updateFingerprintGestureHandling(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$aEE8NeOeH3NuOiOGAXduArN-Eb0, reason: not valid java name */
    public static /* synthetic */ boolean m561$r8$lambda$aEE8NeOeH3NuOiOGAXduArNEb0(Set r0, ComponentName r1) {
        return lambda$notifyQuickSettingsTilesChanged$11(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$aEwIVkYDmEusGF-XmVIW_0m0yE0, reason: not valid java name */
    public static /* synthetic */ boolean m562$r8$lambda$aEwIVkYDmEusGFXmVIW_0m0yE0(Map r0, String r1) {
        return lambda$enableShortcutForTargets$36(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$c2sb4fePdTUn6QD12AOuX4CLSEw(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.updateInputFilter(r1);
    }

    public static /* synthetic */ String $r8$lambda$cpRPp7yq8ZVMPFLBhFR8AKp0jl4(ComponentName r0) {
        return lambda$persistComponentNamesToSettingLocked$23(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$czhOEGR2q2561FoNgPS876IjrnM(AccessibilityManagerService r0, ComponentName r1) {
        return r0.lambda$updateServicesLocked$24(r1);
    }

    public static /* synthetic */ void $r8$lambda$dY4yIRypTdlwjnc0yXrQf16UUpA(AccessibilityManagerService r0) {
        r0.unbindInput();
    }

    public static /* synthetic */ void $r8$lambda$fVgcwwCbIB6pV8sFlk2TYvFf4dg(AccessibilityManagerService r0, Set r1, Set r2, int r3) {
        r0.updateA11yTileServicesInQuickSettingsPanel(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$foBFhwDRlWbn_g-FDknUjGU0yfo, reason: not valid java name */
    public static /* synthetic */ void m563$r8$lambda$foBFhwDRlWbn_gFDknUjGU0yfo(AccessibilityManagerService r0, int r1, Region r2) {
        r0.setTouchExplorationPassthroughRegionInternal(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$iR8DsRkilHf9uZb0muHsJdQFDKI(AccessibilityManagerService r0, int r1) {
        r0.requestTouchExplorationInternal(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jTPaQFE-339QdxwB2Mi-TY5z2lM, reason: not valid java name */
    public static /* synthetic */ void m564$r8$lambda$jTPaQFE339QdxwB2MiTY5z2lM(Map r0, Set r1, StatusBarManagerInternal r2, String r3) {
        lambda$updateA11yTileServicesInQuickSettingsPanel$39(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$kr_zUCWFY6tQ3HY-tBhIm0ImA9o, reason: not valid java name */
    public static /* synthetic */ String m565$r8$lambda$kr_zUCWFY6tQ3HYtBhIm0ImA9o(String r0) {
        return lambda$updateShortcutTargetSets$31(r0);
    }

    public static /* synthetic */ String $r8$lambda$l31mFMlDfcR1mKvmqxxc5OgHvGE(AccessibilityShortcutInfo r0) {
        return lambda$readInstalledAccessibilityShortcutLocked$18(r0);
    }

    public static /* synthetic */ void $r8$lambda$n1v0EHa3vGwtD1eUDHqBlQnLIho(AccessibilityManagerService r0, SparseArray r1, boolean r2) {
        r0.setImeSessionEnabled(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$nrua3enkMb2_cNQG8nUuoZiUGqE(AccessibilityManagerService r0, int r1, boolean r2) {
        r0.setServiceDetectsGesturesInternal(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$p1awZzkw3tQaXOYBFrrZx5_PAC0(AccessibilityManagerService r0, int r1, int r2) {
        r0.sendStateToAllClients(r1, r2);
    }

    public static /* synthetic */ String $r8$lambda$ptXpwZbTMPwvXra334xH3tejUb0(String r0) {
        return lambda$restoreLegacyDisplayMagnificationNavBarIfNeededLocked$8(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$qVXwVz5kwbGQqyOhKn52nbOV-WI, reason: not valid java name */
    public static /* synthetic */ void m566$r8$lambda$qVXwVz5kwbGQqyOhKn52nbOVWI(AccessibilityManagerService r0, int r1, int r2, String r3) {
        r0.performAccessibilityShortcutInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$qzezmfsN62Y8t0uku-ohmmBGuW0, reason: not valid java name */
    public static /* synthetic */ String m567$r8$lambda$qzezmfsN62Y8t0ukuohmmBGuW0(String r0) {
        return lambda$migrateAccessibilityButtonSettingsIfNecessaryLocked$34(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$r-k8oRnZ92oF2qLGSlv21pg7RDA, reason: not valid java name */
    public static /* synthetic */ void m568$r8$lambda$rk8oRnZ92oF2qLGSlv21pg7RDA(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.lambda$updateFocusAppearanceDataLocked$44(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$riMcHg7tWtpoIdTmWnbZqrlKdUo(String r0, AccessibilityUserState r1, String r2) {
        return lambda$migrateAccessibilityButtonSettingsIfNecessaryLocked$32(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$rmfzQ6A_fuQuqgDTBlUvCS0NCxw(AccessibilityManagerService r0, AccessibilityUserState r1, Client r2) {
        r0.lambda$updateFocusAppearanceDataLocked$43(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$rpqmcpakiPBgnyfwrh5AxTq-amY, reason: not valid java name */
    public static /* synthetic */ boolean m569$r8$lambda$rpqmcpakiPBgnyfwrh5AxTqamY(AccessibilityServiceInfo r0) {
        return lambda$onPackagesForceStoppedLocked$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$sMt2_5gu0TFU5w4cmS1Bt5488-s, reason: not valid java name */
    public static /* synthetic */ boolean m570$r8$lambda$sMt2_5gu0TFU5w4cmS1Bt5488s(String r0, ComponentName r1) {
        return lambda$onPackageRemovedLocked$2(r0, r1);
    }

    public static /* synthetic */ String $r8$lambda$sSou1oMwVRrho7XCqJlxd3Rev64(String r0) {
        return lambda$restoreLegacyDisplayMagnificationNavBarIfNeededLocked$9(r0);
    }

    public static /* synthetic */ void $r8$lambda$sqvHmgUA4_3bPY9fhY5KyeAhJBk(AccessibilityManagerService r0, int r1) {
        r0.onDoubleTapAndHoldInternal(r1);
    }

    public static /* synthetic */ void $r8$lambda$tIdPDX1yFQphAm81USE6LbzuZ94(AccessibilityManagerService r0, long r1, Object r3) {
        r0.lambda$notifyClientsOfServicesStateChange$27(r1, r3);
    }

    public static /* synthetic */ String $r8$lambda$uNYzK_7HMtUb7g0N8RDB37pWqh8(String r0) {
        return lambda$enableShortcutForTargets$37(r0);
    }

    public static /* synthetic */ String $r8$lambda$vvPG9eYETjg1WDpQ4JVlQosH9TU(String r0) {
        return lambda$restoreShortcutTargets$12(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$wIGVV54bdurXfl9-riIjTyo9Pq4, reason: not valid java name */
    public static /* synthetic */ boolean m571$r8$lambda$wIGVV54bdurXfl9riIjTyo9Pq4(AccessibilityUserState r0, String r1) {
        return lambda$updateAccessibilityShortcutTargetsLocked$29(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wYPfPbaBszuUF6sjhczksiy53FI(AccessibilityManagerService r0, int r1) {
        r0.notifyRefreshMagnificationModeToInputFilter(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$xXMGQ2GvmJaW075i259f2H_FbvQ(Set r0, String r1) {
        return lambda$updateA11yTileServicesInQuickSettingsPanel$40(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmA11yOverlayLayers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m572$$Nest$fgetmA11yOverlayLayers(AccessibilityManagerService r0) {
        return r0.mA11yOverlayLayers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmA11yWindowManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityWindowManager m573$$Nest$fgetmA11yWindowManager(AccessibilityManagerService r0) {
        return r0.mA11yWindowManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m574$$Nest$fgetmActivityTaskManagerService(AccessibilityManagerService r0) {
        return r0.mActivityTaskManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m575$$Nest$fgetmContext(AccessibilityManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m576$$Nest$fgetmCurrentUserId(AccessibilityManagerService r0) {
        return r0.mCurrentUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasInputFilter, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m577$$Nest$fgetmHasInputFilter(AccessibilityManagerService r0) {
        return r0.mHasInputFilter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputFilter, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityInputFilter m578$$Nest$fgetmInputFilter(AccessibilityManagerService r0) {
        return r0.mInputFilter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m579$$Nest$fgetmLock(AccessibilityManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMagnificationController, reason: not valid java name */
    static /* bridge */ /* synthetic */ MagnificationController m580$$Nest$fgetmMagnificationController(AccessibilityManagerService r0) {
        return r0.mMagnificationController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMainHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m581$$Nest$fgetmMainHandler(AccessibilityManagerService r0) {
        return r0.mMainHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m582$$Nest$fgetmPackageManager(AccessibilityManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProxyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProxyManager m583$$Nest$fgetmProxyManager(AccessibilityManagerService r0) {
        return r0.mProxyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecurityPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilitySecurityPolicy m584$$Nest$fgetmSecurityPolicy(AccessibilityManagerService r0) {
        return r0.mSecurityPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSendWindowStateChangedEventRunnables, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m585$$Nest$fgetmSendWindowStateChangedEventRunnables(AccessibilityManagerService r0) {
        return r0.mSendWindowStateChangedEventRunnables;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempPoint, reason: not valid java name */
    static /* bridge */ /* synthetic */ Point m586$$Nest$fgetmTempPoint(AccessibilityManagerService r0) {
        return r0.mTempPoint;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempRect, reason: not valid java name */
    static /* bridge */ /* synthetic */ Rect m587$$Nest$fgetmTempRect(AccessibilityManagerService r0) {
        return r0.mTempRect;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempRect1, reason: not valid java name */
    static /* bridge */ /* synthetic */ Rect m588$$Nest$fgetmTempRect1(AccessibilityManagerService r0) {
        return r0.mTempRect1;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTraceManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityTraceManager m589$$Nest$fgetmTraceManager(AccessibilityManagerService r0) {
        return r0.mTraceManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m590$$Nest$fgetmWindowManagerService(AccessibilityManagerService r0) {
        return r0.mWindowManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$mcomputeRelevantEventTypesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m591$$Nest$mcomputeRelevantEventTypesLocked(AccessibilityManagerService r0, AccessibilityUserState r1, Client r2) {
        return r0.computeRelevantEventTypesLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchAccessibilityEventLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m592$$Nest$mdispatchAccessibilityEventLocked(AccessibilityManagerService r0, AccessibilityEvent r1) {
        r0.dispatchAccessibilityEventLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityUserState m593$$Nest$mgetCurrentUserStateLocked(AccessibilityManagerService r0) {
        return r0.getCurrentUserStateLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetInteractionBridge, reason: not valid java name */
    static /* bridge */ /* synthetic */ InteractionBridge m594$$Nest$mgetInteractionBridge(AccessibilityManagerService r0) {
        return r0.getInteractionBridge();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSystemActionPerformer, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemActionPerformer m595$$Nest$mgetSystemActionPerformer(AccessibilityManagerService r0) {
        return r0.getSystemActionPerformer();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityUserState m596$$Nest$mgetUserStateLocked(AccessibilityManagerService r0, int r1) {
        return r0.getUserStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misServiceInitializedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m597$$Nest$misServiceInitializedLocked(AccessibilityManagerService r0) {
        return r0.isServiceInitializedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mmigrateAccessibilityButtonSettingsIfNecessaryLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m598$$Nest$mmigrateAccessibilityButtonSettingsIfNecessaryLocked(AccessibilityManagerService r0, AccessibilityUserState r1, String r2, int r3) {
        r0.migrateAccessibilityButtonSettingsIfNecessaryLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monBootPhase, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m599$$Nest$monBootPhase(AccessibilityManagerService r0, int r1) {
        r0.onBootPhase(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemovedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m600$$Nest$monPackageRemovedLocked(AccessibilityManagerService r0, String r1) {
        r0.onPackageRemovedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monSomePackagesChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m601$$Nest$monSomePackagesChangedLocked(AccessibilityManagerService r0, List r1, List r2, Set r3) {
        r0.onSomePackagesChangedLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m602$$Nest$monUserStateChangedLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.onUserStateChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mparseAccessibilityServiceInfos, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m603$$Nest$mparseAccessibilityServiceInfos(AccessibilityManagerService r0, int r1) {
        return r0.parseAccessibilityServiceInfos(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mparseAccessibilityShortcutInfos, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m604$$Nest$mparseAccessibilityShortcutInfos(AccessibilityManagerService r0, int r1) {
        return r0.parseAccessibilityShortcutInfos(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadAccessibilityButtonTargetComponentLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m605$$Nest$mreadAccessibilityButtonTargetComponentLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readAccessibilityButtonTargetComponentLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadAccessibilityShortcutTargetsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m606$$Nest$mreadAccessibilityShortcutTargetsLocked(AccessibilityManagerService r0, AccessibilityUserState r1, int r2) {
        return r0.readAccessibilityShortcutTargetsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadAudioDescriptionEnabledSettingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m607$$Nest$mreadAudioDescriptionEnabledSettingLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readAudioDescriptionEnabledSettingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadAutoclickEnabledSettingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m608$$Nest$mreadAutoclickEnabledSettingLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readAutoclickEnabledSettingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadConfigurationForUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m609$$Nest$mreadConfigurationForUserStateLocked(AccessibilityManagerService r0, AccessibilityUserState r1, List r2, List r3, Set r4) {
        return r0.readConfigurationForUserStateLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadEnabledAccessibilityServicesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m610$$Nest$mreadEnabledAccessibilityServicesLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readEnabledAccessibilityServicesLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadHighTextContrastEnabledSettingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m611$$Nest$mreadHighTextContrastEnabledSettingLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readHighTextContrastEnabledSettingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadMagnificationCapabilitiesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m612$$Nest$mreadMagnificationCapabilitiesLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readMagnificationCapabilitiesLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadMagnificationEnabledSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m613$$Nest$mreadMagnificationEnabledSettingsLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readMagnificationEnabledSettingsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadMagnificationModeForDefaultDisplayLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m614$$Nest$mreadMagnificationModeForDefaultDisplayLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readMagnificationModeForDefaultDisplayLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadTouchExplorationEnabledSettingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m615$$Nest$mreadTouchExplorationEnabledSettingLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readTouchExplorationEnabledSettingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadTouchExplorationGrantedAccessibilityServicesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m616$$Nest$mreadTouchExplorationGrantedAccessibilityServicesLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readTouchExplorationGrantedAccessibilityServicesLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadUserRecommendedUiTimeoutSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m617$$Nest$mreadUserRecommendedUiTimeoutSettingsLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        return r0.readUserRecommendedUiTimeoutSettingsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m618$$Nest$mremoveUser(AccessibilityManagerService r0, int r1) {
        r0.removeUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrestoreLegacyDisplayMagnificationNavBarIfNeededLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m619$$Nest$mrestoreLegacyDisplayMagnificationNavBarIfNeededLocked(AccessibilityManagerService r0, String r1, int r2, int r3) {
        r0.restoreLegacyDisplayMagnificationNavBarIfNeededLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mrestoreShortcutTargets, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m620$$Nest$mrestoreShortcutTargets(AccessibilityManagerService r0, String r1, int r2, int r3) {
        r0.restoreShortcutTargets(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetNonA11yToolNotificationToMatchSafetyCenter, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m621$$Nest$msetNonA11yToolNotificationToMatchSafetyCenter(AccessibilityManagerService r0) {
        r0.setNonA11yToolNotificationToMatchSafetyCenter();
    }

    /* JADX INFO: renamed from: -$$Nest$munlockUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m622$$Nest$munlockUser(AccessibilityManagerService r0, int r1) {
        r0.unlockUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMagnificationCapabilitiesSettingsChangeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m623$$Nest$mupdateMagnificationCapabilitiesSettingsChangeLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.updateMagnificationCapabilitiesSettingsChangeLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMagnificationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m624$$Nest$mupdateMagnificationLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.updateMagnificationLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMagnificationModeChangeSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m625$$Nest$mupdateMagnificationModeChangeSettingsLocked(AccessibilityManagerService r0, AccessibilityUserState r1, int r2) {
        r0.updateMagnificationModeChangeSettingsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateWindowsForAccessibilityCallbackLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m626$$Nest$mupdateWindowsForAccessibilityCallbackLocked(AccessibilityManagerService r0, AccessibilityUserState r1) {
        r0.updateWindowsForAccessibilityCallbackLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsIdCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m627$$Nest$sfgetsIdCounter() {
        return sIdCounter;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsIdCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m628$$Nest$sfputsIdCounter(int r0) {
        sIdCounter = r0;
    }

    static {
        OWN_PROCESS_ID = Process.myPid();
        sIdCounter = 1;
    }

    private AccessibilityUserState getCurrentUserStateLocked() {
        return getUserStateLocked(this.mCurrentUserId);
    }

    public void changeMagnificationMode(int displayId, int magnificationMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (displayId != 0) goto L8;
        persistMagnificationModeSettingsLocked(magnificationMode);     // Catch: Throwable -> L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L6
        int currentMode = userState.getMagnificationModeLocked(displayId);     // Catch: Throwable -> L6
        if (magnificationMode == currentMode) goto L11;
        userState.setMagnificationModeLocked(displayId, magnificationMode);     // Catch: Throwable -> L6
        updateMagnificationModeChangeSettingsLocked(userState, displayId);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0(KeyGestureEvent event, IBinder focusedToken) {
        handleKeyGestureEvent(event);
    }

    AccessibilityManagerService(Context context, Handler handler, PackageManager packageManager, AccessibilitySecurityPolicy securityPolicy, SystemActionPerformer systemActionPerformer, AccessibilityWindowManager a11yWindowManager, AccessibilityDisplayListener.DisplayManagerWrapper displayManagerWrapper, MagnificationController magnificationController, AccessibilityInputFilter inputFilter, ProxyManager proxyManager, PermissionEnforcer permissionEnforcer, HearingDevicePhoneCallNotificationController hearingDeviceNotificationController) {
        super(permissionEnforcer);
        this.mLock = new Object();
        this.mStringColonSplitter = new TextUtils.SimpleStringSplitter(COMPONENT_NAME_SEPARATOR);
        this.mTempRect = new Rect();
        this.mTempRect1 = new Rect();
        this.mTempComponentNameSet = new HashSet();
        this.mTempIntArray = new IntArray(0);
        this.mGlobalClients = new RemoteCallbackList();
        this.mUserStates = new SparseArray();
        this.mUiAutomationManager = new UiAutomationManager(this.mLock);
        this.mSendWindowStateChangedEventRunnables = new ArrayList();
        this.mUserInitializationCompleteCallbacks = new HashSet();
        this.mCurrentUserId = 0;
        this.mRealCurrentUserId = -2;
        this.mTempPoint = new Point();
        this.mA11yOverlayLayers = new SparseArray();
        this.mObricExt = (IObricAccessibilityManagerService) ObricImplFactory.getImpl(IObricAccessibilityManagerService.class, new Object[]{this});
        this.mKeyGestureEventHandler = new AccessibilityManagerService$$ExternalSyntheticLambda33(this);
        this.mContext = context;
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mWindowManagerService = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mTraceManager = AccessibilityTraceManager.getInstance(this.mWindowManagerService.getAccessibilityController(), this, this.mLock);
        this.mMainHandler = handler;
        this.mActivityTaskManagerService = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mPackageManager = packageManager;
        this.mSecurityPolicy = securityPolicy;
        this.mSystemActionPerformer = systemActionPerformer;
        this.mA11yWindowManager = a11yWindowManager;
        this.mA11yDisplayListener = new AccessibilityDisplayListener(this, displayManagerWrapper, new MainHandler(this, Looper.getMainLooper()));
        this.mMagnificationController = magnificationController;
        this.mMagnificationProcessor = new MagnificationProcessor(this.mMagnificationController);
        this.mCaptioningManagerImpl = new CaptioningManagerImpl(this.mContext);
        this.mProxyManager = proxyManager;
        if (inputFilter == null) goto L5;
        this.mInputFilter = inputFilter;
        this.mHasInputFilter = true;
    L5:
        this.mFlashNotificationsController = new FlashNotificationsController(this.mContext);
        this.mUmi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mVisibleBgUserIds = null;
        this.mInputManager = (InputManager) context.getSystemService(InputManager.class);
        this.mHearingDeviceNotificationController = hearingDeviceNotificationController;
        init();
    }

    public AccessibilityManagerService(Context context) {
        super(PermissionEnforcer.fromContext(context));
        this.mLock = new Object();
        this.mStringColonSplitter = new TextUtils.SimpleStringSplitter(COMPONENT_NAME_SEPARATOR);
        this.mTempRect = new Rect();
        this.mTempRect1 = new Rect();
        this.mTempComponentNameSet = new HashSet();
        this.mTempIntArray = new IntArray(0);
        this.mGlobalClients = new RemoteCallbackList();
        this.mUserStates = new SparseArray();
        this.mUiAutomationManager = new UiAutomationManager(this.mLock);
        this.mSendWindowStateChangedEventRunnables = new ArrayList();
        this.mUserInitializationCompleteCallbacks = new HashSet();
        this.mCurrentUserId = 0;
        this.mRealCurrentUserId = -2;
        this.mTempPoint = new Point();
        this.mA11yOverlayLayers = new SparseArray();
        this.mObricExt = (IObricAccessibilityManagerService) ObricImplFactory.getImpl(IObricAccessibilityManagerService.class, new Object[]{this});
        this.mKeyGestureEventHandler = new AccessibilityManagerService$$ExternalSyntheticLambda33(this);
        this.mContext = context;
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        this.mWindowManagerService = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mTraceManager = AccessibilityTraceManager.getInstance(this.mWindowManagerService.getAccessibilityController(), this, this.mLock);
        this.mMainHandler = new MainHandler(this, this.mContext.getMainLooper());
        this.mActivityTaskManagerService = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mPackageManager = this.mContext.getPackageManager();
        PolicyWarningUIController policyWarningUIController = new PolicyWarningUIController(this.mMainHandler, context, new PolicyWarningUIController.NotificationController(context));
        this.mSecurityPolicy = new AccessibilitySecurityPolicy(policyWarningUIController, this.mContext, this, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class));
        this.mA11yWindowManager = new AccessibilityWindowManager(this.mLock, this.mMainHandler, this.mWindowManagerService, this, this.mSecurityPolicy, this, this.mTraceManager);
        this.mA11yDisplayListener = new AccessibilityDisplayListener(this, new AccessibilityDisplayListener.DisplayManagerWrapper(this.mContext), this.mMainHandler);
        this.mMagnificationController = new MagnificationController(this, this.mLock, this.mContext, new MagnificationScaleProvider(this.mContext), Executors.newSingleThreadExecutor(), this.mContext.getMainLooper());
        this.mMagnificationProcessor = new MagnificationProcessor(this.mMagnificationController);
        this.mCaptioningManagerImpl = new CaptioningManagerImpl(this.mContext);
        this.mProxyManager = new ProxyManager(this.mLock, this.mA11yWindowManager, this.mContext, this.mMainHandler, this.mUiAutomationManager, this);
        this.mFlashNotificationsController = new FlashNotificationsController(this.mContext);
        this.mUmi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mInputManager = (InputManager) context.getSystemService(InputManager.class);
        if (UserManager.isVisibleBackgroundUsersEnabled() == false) goto L5;
        this.mVisibleBgUserIds = new SparseBooleanArray();
        this.mUmi.addUserVisibilityListener(new AccessibilityManagerService$$ExternalSyntheticLambda38(this));
    L6:
        this.mHearingDeviceNotificationController = new HearingDevicePhoneCallNotificationController(context);
        init();
        return;
    L5:
        this.mVisibleBgUserIds = null;
        goto L6
    }

    private /* synthetic */ void lambda$new$1(int u, boolean v) {
        onUserVisibilityChanged(u, v);
    }

    private void init() {
        this.mSecurityPolicy.setAccessibilityWindowManager(this.mA11yWindowManager);
        registerBroadcastReceivers();
        new AccessibilityContentObserver(this, this.mMainHandler).register(this.mContext.getContentResolver());
        if (this.mHearingDeviceNotificationController == null) goto L5;
        this.mHearingDeviceNotificationController.startListenForCallState();
    L5:
        disableAccessibilityMenuToMigrateIfNeeded();
    }

    boolean unsafeIsLockHeld() {
        return Thread.holdsLock(this.mLock);
    }

    private boolean isServiceInitializedLocked() {
        return this.mInitialized;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport, com.android.server.accessibility.AccessibilitySecurityPolicy.AccessibilityUserManager
    public int getCurrentUserIdLocked() {
        return this.mCurrentUserId;
    }

    @Override // com.android.server.accessibility.AccessibilitySecurityPolicy.AccessibilityUserManager
    public SparseBooleanArray getVisibleUserIdsLocked() {
        return this.mVisibleBgUserIds;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public boolean isAccessibilityButtonShown() {
        return this.mIsAccessibilityButtonShown;
    }

    void handleKeyGestureEvent(KeyGestureEvent event) {
        if (event.getAction() == 2) goto L5;
    L7:
        boolean complete = false;
    L8:
        int gestureType = event.getKeyGestureType();
        if (complete == true) goto L11;
        return;
    L11:
        switch(gestureType) {
            case 72: goto L34;
            case 73: goto L14;
            default: goto L12;
        };
    L12:
        Slog.w(LOG_TAG, "Received a key gesture " + event + " that was not registered by this handler");
        return;
    L14:
        String targetName = this.mContext.getString(R.string.config_headlineFontFamily);
        if (targetName.isEmpty() == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(targetName) == false) goto L20;
        ComponentName targetServiceComponent = null;
    L21:
        Object r5 = this.mLock;
        monitor-enter(r5);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L31
        AccessibilityServiceInfo accessibilityServiceInfo = userState.getInstalledServiceInfoLocked(targetServiceComponent);     // Catch: Throwable -> L31
        monitor-exit(r5);     // Catch: Throwable -> L31
        if (accessibilityServiceInfo != null) goto L28;
        return;
    L28:
        if (isAccessibilityServiceWarningRequired(accessibilityServiceInfo) == false) goto L35;
        Slog.w(LOG_TAG, "Accessibility warning is required before this service can be activated automatically via KEY_GESTURE shortcut.");
        return;
    L35:
        List<String> shortcutTargets = getAccessibilityShortcutTargets(64);
        if (shortcutTargets.contains(targetName) == true) goto L47;
        Object r6 = this.mLock;
        monitor-enter(r6);
        int userId = this.mCurrentUserId;     // Catch: Throwable -> L43
        monitor-exit(r6);     // Catch: Throwable -> L43
        enableShortcutForTargets(true, 64, List.of(targetName), userId);
        return;
    L43:
        th = move-exception;
        throw th;
    L47:
        if (event.getDisplayId() == (-1)) goto L49;
        int displayId = event.getDisplayId();
    L50:
        performAccessibilityShortcutInternal(displayId, 64, targetName);
        return;
    L49:
        displayId = getLastNonProxyTopFocusedDisplayId();
    L31:
        th = move-exception;
        throw th;
    L20:
        targetServiceComponent = ComponentName.unflattenFromString(targetName);
        goto L21
    L34:
        targetName = "com.android.server.accessibility.MagnificationController";
        goto L35
    L5:
        if (event.isCancelled() == true) goto L7;
        complete = true;
        goto L8
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public Pair<float[], MagnificationSpec> getWindowTransformationMatrixAndMagnificationSpec(int windowId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowInfo windowInfo = this.mA11yWindowManager.findWindowInfoByIdLocked(windowId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        if (windowInfo == null) goto L9;
        MagnificationSpec spec = new MagnificationSpec();
        spec.setTo(windowInfo.mMagnificationSpec);
        return new Pair(windowInfo.mTransformMatrix, spec);
    L9:
        Object r2 = this.mLock;
        monitor-enter(r2);
        IBinder token = this.mA11yWindowManager.getWindowTokenForUserAndWindowIdLocked(this.mCurrentUserId, windowId);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        Pair<Matrix, MagnificationSpec> pair = this.mWindowManagerService.getWindowTransformationMatrixAndMagnificationSpec(token);
        float[] outTransformationMatrix = new float[9];
        Matrix tmpMatrix = (Matrix) pair.first;
        MagnificationSpec spec2 = (MagnificationSpec) pair.second;
        if (spec2.isNop() == true) goto L16;
        tmpMatrix.postScale(spec2.scale, spec2.scale);
        tmpMatrix.postTranslate(spec2.offsetX, spec2.offsetY);
    L16:
        tmpMatrix.getValues(outTransformationMatrix);
        return new Pair(outTransformationMatrix, (MagnificationSpec) pair.second);
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    }

    public IAccessibilityManager.WindowTransformationSpec getWindowTransformationSpec(int windowId) {
        IAccessibilityManager.WindowTransformationSpec windowTransformationSpec = new IAccessibilityManager.WindowTransformationSpec();
        Pair<float[], MagnificationSpec> result = getWindowTransformationMatrixAndMagnificationSpec(windowId);
        windowTransformationSpec.transformationMatrix = (float[]) result.first;
        windowTransformationSpec.magnificationSpec = (MagnificationSpec) result.second;
        return windowTransformationSpec;
    }

    @Override // com.android.server.accessibility.AccessibilityUserState.ServiceInfoChangeListener
    public void onServiceInfoChangedLocked(AccessibilityUserState userState) {
        this.mSecurityPolicy.onBoundServicesChangedLocked(userState.mUserId, userState.mBoundServices);
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public FingerprintGestureDispatcher getFingerprintGestureDispatcher() {
        return this.mFingerprintGestureDispatcher;
    }

    public void onInputFilterInstalled(boolean installed) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInputFilterInstalled = installed;     // Catch: Throwable -> L7
        this.mLock.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onBootPhase(int phase) {
        if (phase != 500) goto L8;
        if (this.mPackageManager.hasSystemFeature("android.software.app_widgets") == false) goto L8;
        this.mSecurityPolicy.setAppWidgetManager((AppWidgetManagerInternal) LocalServices.getService(AppWidgetManagerInternal.class));
    L8:
        if (phase != 600) goto L11;
        setNonA11yToolNotificationToMatchSafetyCenter();
        return;
    }

    private void setNonA11yToolNotificationToMatchSafetyCenter() {
        boolean sendNotification = !((SafetyCenterManager) this.mContext.getSystemService(SafetyCenterManager.class)).isSafetyCenterEnabled();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mSecurityPolicy.setSendingNonA11yToolNotificationLocked(sendNotification);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Object getLock() {
        return this.mLock;
    }

    AccessibilityUserState getCurrentUserState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState r1 = getCurrentUserStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private AccessibilityUserState getUserState(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState r1 = getUserStateLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private AccessibilityUserState getUserStateLocked(int userId) {
        AccessibilityUserState state = this.mUserStates.get(userId);
        if (state != null) goto L6;
        AccessibilityUserState state2 = new AccessibilityUserState(userId, this.mContext, this);
        this.mUserStates.put(userId, state2);
        return state2;
    L6:
        return state;
    }

    boolean getBindInstantServiceAllowed(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L7
        boolean r2 = userState.getBindInstantServiceAllowedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    void setBindInstantServiceAllowed(int userId, boolean allowed) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_BIND_INSTANT_SERVICE", "setBindInstantServiceAllowed");
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L7
        if (allowed == userState.getBindInstantServiceAllowedLocked()) goto L9;
        userState.setBindInstantServiceAllowedLocked(allowed);     // Catch: Throwable -> L7
        onUserStateChangedLocked(userState);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onSomePackagesChangedLocked(List<AccessibilityServiceInfo> parsedAccessibilityServiceInfos, List<AccessibilityShortcutInfo> parsedAccessibilityShortcutInfos, Set<ComponentName> validA11yTileServices) {
        AccessibilityUserState userState = getCurrentUserStateLocked();
        userState.mInstalledServices.clear();
        if (readConfigurationForUserStateLocked(userState, parsedAccessibilityServiceInfos, parsedAccessibilityShortcutInfos, validA11yTileServices) == false) goto L6;
        onUserStateChangedLocked(userState);
        return;
    }

    private void onPackageRemovedLocked(final String packageName) {
        AccessibilityUserState userState = getCurrentUserState();
        Predicate<ComponentName> filter = new AccessibilityManagerService$$ExternalSyntheticLambda1(packageName);
        userState.mBindingServices.removeIf(filter);
        userState.mCrashedServices.removeIf(filter);
        Iterator<ComponentName> it = userState.mEnabledServices.iterator();
        boolean anyServiceRemoved = false;
    L4:
        if (it.hasNext() == false) goto L9;
        ComponentName comp = it.next();
        String compPkg = comp.getPackageName();
        if (compPkg.equals(packageName) == false) goto L4;
        it.remove();
        userState.mTouchExplorationGrantedServices.remove(comp);
        anyServiceRemoved = true;
        goto L4
    L9:
        if (anyServiceRemoved == false) goto L17;
        persistComponentNamesToSettingLocked("enabled_accessibility_services", userState.mEnabledServices, this.mCurrentUserId);
        persistComponentNamesToSettingLocked("touch_exploration_granted_accessibility_services", userState.mTouchExplorationGrantedServices, this.mCurrentUserId);
        onUserStateChangedLocked(userState);
        return;
    }

    private static /* synthetic */ boolean lambda$onPackageRemovedLocked$2(String packageName, ComponentName component) {
        if (component != null) goto L4;
    L6:
        return false;
    L4:
        if (component.getPackageName().equals(packageName) == false) goto L6;
        return true;
    }

    boolean onPackagesForceStoppedLocked(String[] packages, AccessibilityUserState userState) {
        final Set<String> packageSet = new HashSet(List.of(packages));
        final ArrayList<ComponentName> continuousServices = new ArrayList(userState.mInstalledServices.stream().filter(new AccessibilityManagerService$$ExternalSyntheticLambda43()).map(new AccessibilityManagerService$$ExternalSyntheticLambda44()).toList());
        continuousServices.removeIf(new AccessibilityManagerService$$ExternalSyntheticLambda45(packageSet));
        boolean enabledServicesChanged = false;
        Iterator<ComponentName> it = userState.mEnabledServices.iterator();
    L4:
        if (it.hasNext() == false) goto L9;
        ComponentName comp = it.next();
        String compPkg = comp.getPackageName();
        if (packageSet.contains(compPkg) == false) goto L4;
        it.remove();
        userState.getBindingServicesLocked().remove(comp);
        userState.getCrashedServicesLocked().remove(comp);
        enabledServicesChanged = true;
        goto L4
    L9:
        if (enabledServicesChanged == false) goto L11;
        persistComponentNamesToSettingLocked("enabled_accessibility_services", userState.mEnabledServices, userState.mUserId);
    L11:
        ArraySet<String> r5 = userState.getShortcutTargetsLocked(1);
        boolean buttonTargetsChanged = r5.removeIf(new AccessibilityManagerService$$ExternalSyntheticLambda46(continuousServices));
        if (buttonTargetsChanged == false) goto L14;
        userState.updateShortcutTargetsLocked(r5, 1);
        persistColonDelimitedSetToSettingLocked(ShortcutUtils.convertToKey(1), userState.mUserId, r5, new AccessibilityManagerService$$ExternalSyntheticLambda47());
    L14:
        if (enabledServicesChanged == true) goto L24;
        if (buttonTargetsChanged == true) goto L25;
        return false;
    L25:
        return true;
    L24:
        return true;
    }

    private static /* synthetic */ boolean lambda$onPackagesForceStoppedLocked$3(AccessibilityServiceInfo service) {
        if ((service.flags & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$onPackagesForceStoppedLocked$4(Set packageSet, ComponentName continuousName) {
        return !packageSet.contains(continuousName.getPackageName());
    }

    private static /* synthetic */ boolean lambda$onPackagesForceStoppedLocked$6(ArrayList continuousServices, final String target) {
        return continuousServices.stream().anyMatch(new AccessibilityManagerService$$ExternalSyntheticLambda42(target));
    }

    private static /* synthetic */ boolean lambda$onPackagesForceStoppedLocked$5(String target, ComponentName continuousName) {
        return continuousName.flattenToString().equals(target);
    }

    private static /* synthetic */ String lambda$onPackagesForceStoppedLocked$7(String str) {
        return str;
    }

    PackageMonitor getPackageMonitor() {
        return this.mPackageMonitor;
    }

    void setPackageMonitor(PackageMonitor monitor) {
        this.mPackageMonitor = monitor;
    }

    private void registerBroadcastReceivers() {
        this.mPackageMonitor = new ManagerPackageMonitor(this);
        HandlerThread packageMonitorThread = new HandlerThread("AccessibilityManagerService PackageMonitor", 10);
        packageMonitorThread.start();
        Looper packageMonitorLooper = packageMonitorThread.getLooper();
        this.mPackageMonitor.register(this.mContext, packageMonitorLooper, UserHandle.ALL, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_SWITCHED");
        intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        intentFilter.addAction("android.intent.action.USER_REMOVED");
        intentFilter.addAction("android.os.action.SETTING_RESTORED");
        Handler receiverHandler = BackgroundThread.getHandler();
        this.mContext.registerReceiverAsUser(new AnonymousClass1(this), UserHandle.ALL, intentFilter, null, receiverHandler);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.safetycenter.action.SAFETY_CENTER_ENABLED_CHANGED");
        BroadcastReceiver receiver = new AnonymousClass2(this);
        this.mContext.registerReceiverAsUser(receiver, UserHandle.ALL, filter, null, this.mMainHandler, 2);
    }

    private void disableAccessibilityMenuToMigrateIfNeeded() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userId = this.mCurrentUserId;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        ComponentName menuToMigrate = AccessibilityUtils.getAccessibilityMenuComponentToMigrate(this.mPackageManager, userId);
        if (menuToMigrate == null) goto L15;
        PackageManager userPackageManager = this.mContext.createContextAsUser(UserHandle.of(userId), 0).getPackageManager();
        userPackageManager.setComponentEnabledSetting(menuToMigrate, 2, 1);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void restoreLegacyDisplayMagnificationNavBarIfNeededLocked(String newSetting, int restoreFromSdkInt, int userId) {
        if (restoreFromSdkInt < 30) goto L21;
        return;
    L21:
        if (Integer.parseInt(newSetting) != 1) goto L9;
        boolean displayMagnificationNavBarEnabled = true;
    L10:
        AccessibilityUserState userState = getUserStateLocked(userId);
        ArraySet r3 = new ArraySet();
        readColonDelimitedSettingToSet("accessibility_button_targets", userState.mUserId, new AccessibilityManagerService$$ExternalSyntheticLambda66(), r3);
        boolean targetsContainMagnification = r3.contains("com.android.server.accessibility.MagnificationController");
        if (targetsContainMagnification != displayMagnificationNavBarEnabled) goto L13;
        return;
    L13:
        if (displayMagnificationNavBarEnabled == false) goto L15;
        r3.add("com.android.server.accessibility.MagnificationController");
    L16:
        persistColonDelimitedSetToSettingLocked("accessibility_button_targets", userState.mUserId, r3, new AccessibilityManagerService$$ExternalSyntheticLambda67());
        readAccessibilityShortcutTargetsLocked(userState, 1);
        onUserStateChangedLocked(userState);
        return;
    L15:
        r3.remove("com.android.server.accessibility.MagnificationController");
        goto L16
    L9:
        displayMagnificationNavBarEnabled = false;
    L18:
        e = move-exception;
        Slog.w(LOG_TAG, "number format is incorrect" + e);
    }

    private static /* synthetic */ String lambda$restoreLegacyDisplayMagnificationNavBarIfNeededLocked$8(String str) {
        return str;
    }

    private static /* synthetic */ String lambda$restoreLegacyDisplayMagnificationNavBarIfNeededLocked$9(String str) {
        return str;
    }

    public long addClient(IAccessibilityManagerClient callback, int userId) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.addClient", 4, "callback=" + callback + ";userId=" + userId);
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L32
        AccessibilityUserState userState = getUserStateLocked(resolvedUserId);     // Catch: Throwable -> L32
        int deviceId = this.mProxyManager.getFirstDeviceIdForUidLocked(Binder.getCallingUid());     // Catch: Throwable -> L32
        Client client = new Client(this, callback, Binder.getCallingUid(), userState, deviceId, null);     // Catch: Throwable -> L16
        if (this.mSecurityPolicy.isCallerInteractingAcrossUsers(userId) == false) goto L20;
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L18;
        long r9 = IntPair.of(this.mProxyManager.getStateLocked(deviceId), client.mLastSentRelevantEventTypes);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r9;
    L18:
        this.mGlobalClients.register(callback, client);     // Catch: Throwable -> L16
    L25:
        this.mObricExt.handleClientAdded(client, this.mMainHandler);     // Catch: Throwable -> L16
        if (resolvedUserId != this.mCurrentUserId) goto L28;
        int r12 = getClientStateLocked(userState);     // Catch: Throwable -> L16
    L29:
        long r10 = IntPair.of(r12, client.mLastSentRelevantEventTypes);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r10;
    L28:
        r12 = 0;
        goto L29
    L20:
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L24;
        long r11 = IntPair.of(this.mProxyManager.getStateLocked(deviceId), client.mLastSentRelevantEventTypes);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r11;
    L24:
        userState.mUserClients.register(callback, client);     // Catch: Throwable -> L16
    L32:
        th = move-exception;
        Throwable r13 = th;
    L34:
        monitor-exit(r1);     // Catch: Throwable -> L16
        throw r13;
    L16:
        th = move-exception;
        r13 = th;
        goto L34
    }

    public boolean removeClient(IAccessibilityManagerClient callback, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L9
        AccessibilityUserState userState = getUserStateLocked(resolvedUserId);     // Catch: Throwable -> L9
        if (this.mSecurityPolicy.isCallerInteractingAcrossUsers(userId) == false) goto L11;
        boolean unregistered = this.mGlobalClients.unregister(callback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return unregistered;
    L11:
        boolean unregistered2 = userState.mUserClients.unregister(callback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return unregistered2;
    L9:
        th = move-exception;
        throw th;
    }

    public void sendAccessibilityEvent(AccessibilityEvent event, int userId) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.sendAccessibilityEvent", 4, "event=" + event + ";userId=" + userId);
    L5:
        boolean dispatchEvent = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (event.getWindowId() != (-3)) goto L14;
        AccessibilityWindowInfo pip = this.mA11yWindowManager.getPictureInPictureWindowLocked();     // Catch: Throwable -> L12
        if (pip == null) goto L14;
        int pipId = pip.getId();     // Catch: Throwable -> L12
        event.setWindowId(pipId);     // Catch: Throwable -> L12
    L14:
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L12
        event.setPackageName(this.mSecurityPolicy.resolveValidReportedPackageLocked(event.getPackageName(), UserHandle.getCallingAppId(), resolvedUserId, IAccessibilityManager.Stub.getCallingPid()));     // Catch: Throwable -> L12
        if (resolvedUserId == this.mCurrentUserId) goto L17;
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L12
        if (dispatchEvent == false) goto L60;
        boolean shouldComputeWindows = false;
        int displayId = event.getDisplayId();
        int windowId = event.getWindowId();
        if (windowId == (-1)) goto L30;
        if (displayId != (-1)) goto L30;
        int displayId2 = this.mA11yWindowManager.getDisplayIdByUserIdAndWindowId(resolvedUserId, windowId);
        event.setDisplayId(displayId2);
        int displayId3 = displayId2;
    L31:
        Object r7 = this.mLock;
        monitor-enter(r7);
    L39:
        th = move-exception;
        throw th;
    L34:
        if (event.getEventType() != 32) goto L41;
        if (displayId3 == (-1)) goto L41;
        if (this.mA11yWindowManager.isTrackingWindowsLocked(displayId3) == false) goto L41;
        shouldComputeWindows = true;
    L41:
        monitor-exit(r7);     // Catch: Throwable -> L39
        if (shouldComputeWindows == true) goto L44;
    L49:
        Object r5 = this.mLock;
        monitor-enter(r5);
        dispatchAccessibilityEventLocked(event);     // Catch: Throwable -> L54
        monitor-exit(r5);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    L44:
        if (this.mTraceManager.isA11yTracingEnabledForTypes(512) == false) goto L46;
        this.mTraceManager.logTrace("WindowManagerInternal.computeWindowsForAccessibility", 512, "display=" + displayId3);
    L46:
        WindowManagerInternal wm = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        wm.computeWindowsForAccessibility(displayId3);
        if (postponeWindowStateEvent(event) == false) goto L49;
        return;
    L30:
        displayId3 = displayId;
    L60:
        if (OWN_PROCESS_ID == Binder.getCallingPid()) goto L71;
        event.recycle();
        return;
    L71:
        return;
    L17:
        if (this.mSecurityPolicy.canDispatchAccessibilityEventLocked(this.mCurrentUserId, event) == false) goto L20;
        this.mA11yWindowManager.updateActiveAndAccessibilityFocusedWindowLocked(this.mCurrentUserId, event.getWindowId(), event.getSourceNodeId(), event.getEventType(), event.getAction());     // Catch: Throwable -> L12
        this.mSecurityPolicy.updateEventSourceLocked(event);     // Catch: Throwable -> L12
        dispatchEvent = true;
    L20:
        if (this.mHasInputFilter == false) goto L24;
        if (this.mInputFilter == null) goto L24;
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda3(), this, AccessibilityEvent.obtain(event)));     // Catch: Throwable -> L12
        goto L24
    }

    private void dispatchAccessibilityEventLocked(AccessibilityEvent event) {
        if (this.mProxyManager.isProxyedDisplay(event.getDisplayId()) == false) goto L5;
        this.mProxyManager.sendAccessibilityEventLocked(event);
    L6:
        this.mUiAutomationManager.sendAccessibilityEventLocked(event);
        return;
    L5:
        notifyAccessibilityServicesDelayedLocked(event, false);
        notifyAccessibilityServicesDelayedLocked(event, true);
        goto L6
    }

    private void sendAccessibilityEventToInputFilter(AccessibilityEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        event.recycle();
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.notifyAccessibilityEvent(event);     // Catch: Throwable -> L9
        goto L11
    }

    public void registerSystemAction(RemoteAction action, int actionId) {
        registerSystemAction_enforcePermission();
        UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.registerSystemAction", 4, "action=" + action + ";actionId=" + actionId);
    L5:
        getSystemActionPerformer().registerSystemAction(actionId, action);
    }

    public void unregisterSystemAction(int actionId) {
        unregisterSystemAction_enforcePermission();
        UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.unregisterSystemAction", 4, "actionId=" + actionId);
    L5:
        getSystemActionPerformer().unregisterSystemAction(actionId);
    }

    private SystemActionPerformer getSystemActionPerformer() {
        if (this.mSystemActionPerformer != null) goto L5;
        AccessibilityManagerService r5 = this;
        r5.mSystemActionPerformer = new SystemActionPerformer(this.mContext, this.mWindowManagerService, null, r5, this);
    L7:
        return r5.mSystemActionPerformer;
    L5:
        r5 = this;
        goto L7
    }

    public ParceledListSlice<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(int userId) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.getInstalledAccessibilityServiceList", 4, "userId=" + userId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = this.mProxyManager.getFirstDeviceIdForUidLocked(Binder.getCallingUid());     // Catch: Throwable -> L12
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L14;
        ParceledListSlice<AccessibilityServiceInfo> r2 = new ParceledListSlice(this.mProxyManager.getInstalledAndEnabledServiceInfosLocked(-1, deviceId));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L12
        List<AccessibilityServiceInfo> serviceInfos = new ArrayList(getUserStateLocked(resolvedUserId).mInstalledServices);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (Binder.getCallingPid() == OWN_PROCESS_ID) goto L19;
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int callingUid = Binder.getCallingUid();
        int i = serviceInfos.size() - 1;
    L21:
        if (i < 0) goto L27;
        AccessibilityServiceInfo serviceInfo = serviceInfos.get(i);
        if (pm.filterAppAccess(serviceInfo.getComponentName().getPackageName(), callingUid, resolvedUserId) == false) goto L25;
        serviceInfos.remove(i);
    L25:
        i = i - 1;
        goto L21
    L27:
        return new ParceledListSlice(serviceInfos);
    L19:
        return new ParceledListSlice(serviceInfos);
    L12:
        th = move-exception;
        throw th;
    }

    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int feedbackType, int userId) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.getEnabledAccessibilityServiceList", 4, "feedbackType=" + feedbackType + ";userId=" + userId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = this.mProxyManager.getFirstDeviceIdForUidLocked(Binder.getCallingUid());     // Catch: Throwable -> L12
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L14;
        List<AccessibilityServiceInfo> r2 = this.mProxyManager.getInstalledAndEnabledServiceInfosLocked(feedbackType, deviceId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L12
        AccessibilityUserState userState = getUserStateLocked(resolvedUserId);     // Catch: Throwable -> L12
        if (this.mUiAutomationManager.suppressingAccessibilityServicesLocked() == false) goto L19;
        List<AccessibilityServiceInfo> r4 = Collections.emptyList();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L19:
        List<AccessibilityServiceConnection> services = userState.mBoundServices;     // Catch: Throwable -> L12
        int serviceCount = services.size();     // Catch: Throwable -> L12
        List<AccessibilityServiceInfo> result = new ArrayList(serviceCount);     // Catch: Throwable -> L12
        int i = 0;
    L20:
        if (i >= serviceCount) goto L28;
        AccessibilityServiceConnection service = services.get(i);     // Catch: Throwable -> L12
        if ((service.mFeedbackType & feedbackType) == 0) goto L24;
    L25:
        result.add(service.getServiceInfo());     // Catch: Throwable -> L12
    L26:
        i = i + 1;     // Catch: Throwable -> L12
        goto L20
    L24:
        if (feedbackType != (-1)) goto L26;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return result;
    L12:
        th = move-exception;
        throw th;
    }

    public void interrupt(int userId) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.interrupt", 4, "userId=" + userId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L11
        if (resolvedUserId == this.mCurrentUserId) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        int deviceId = this.mProxyManager.getFirstDeviceIdForUidLocked(Binder.getCallingUid());     // Catch: Throwable -> L11
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L16;
        List<IAccessibilityServiceClient> interfacesToInterrupt = new ArrayList();     // Catch: Throwable -> L11
        this.mProxyManager.addServiceInterfacesLocked(interfacesToInterrupt, deviceId);     // Catch: Throwable -> L11
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L11
        int i = 0;
        int count = interfacesToInterrupt.size();
    L27:
        if (i >= count) goto L38;
        if (this.mTraceManager.isA11yTracingEnabledForTypes(2) == false) goto L33;
        this.mTraceManager.logTrace("AccessibilityManagerService.IAccessibilityServiceClient.onInterrupt", 2);     // Catch: RemoteException -> L31
    L33:
        interfacesToInterrupt.get(i).onInterrupt();     // Catch: RemoteException -> L31
    L36:
        i = i + 1;
    L31:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending interrupt request to " + interfacesToInterrupt.get(i), re);
        goto L36
    L38:
        return;
    L16:
        List<AccessibilityServiceConnection> services = getUserStateLocked(resolvedUserId).mBoundServices;     // Catch: Throwable -> L11
        List<IAccessibilityServiceClient> interfacesToInterrupt2 = new ArrayList(services.size());     // Catch: Throwable -> L11
        int i2 = 0;
    L18:
        if (i2 >= services.size()) goto L24;
        AccessibilityServiceConnection service = services.get(i2);     // Catch: Throwable -> L11
        IBinder a11yServiceBinder = service.mClientBinder;     // Catch: Throwable -> L11
        IAccessibilityServiceClient a11yServiceInterface = service.mClient;     // Catch: Throwable -> L11
        if (a11yServiceBinder == null) goto L23;
        if (a11yServiceInterface == null) goto L23;
        interfacesToInterrupt2.add(a11yServiceInterface);     // Catch: Throwable -> L11
    L23:
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L18
    L24:
        interfacesToInterrupt = interfacesToInterrupt2;
    L11:
        th = move-exception;
        throw th;
    }

    public int addAccessibilityInteractionConnection(IWindow windowToken, IBinder leashToken, IAccessibilityInteractionConnection connection, String packageName, int userId) throws RemoteException {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        AccessibilityTraceManager r0 = this.mTraceManager;
        StringBuilder r3 = new StringBuilder();
        r3.append("windowToken=");
        r3.append(windowToken);
        r3.append("leashToken=");
        r3.append(leashToken);
        r3.append(";connection=");
        r3.append(connection);
        r3.append("; packageName=");
        r3.append(packageName);
        r3.append(";userId=");
        int r10 = userId;
        r3.append(r10);
        r0.logTrace("AccessibilityManagerService.addAccessibilityInteractionConnection", 4, r3.toString());
    L7:
        return this.mA11yWindowManager.addAccessibilityInteractionConnection(windowToken, leashToken, connection, packageName, r10);
    L5:
        r10 = userId;
        goto L7
    }

    public void removeAccessibilityInteractionConnection(IWindow window) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.removeAccessibilityInteractionConnection", 4, "window=" + window);
    L5:
        this.mA11yWindowManager.removeAccessibilityInteractionConnection(window);
    }

    public void setPictureInPictureActionReplacingConnection(IAccessibilityInteractionConnection connection) throws RemoteException {
        setPictureInPictureActionReplacingConnection_enforcePermission();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.setPictureInPictureActionReplacingConnection", 4, "connection=" + connection);
    L5:
        this.mA11yWindowManager.setPictureInPictureActionReplacingConnection(connection);
    }

    public void registerUiTestAutomationService(IBinder owner, IAccessibilityServiceClient serviceClient, AccessibilityServiceInfo accessibilityServiceInfo, int userId, int flags) {
        registerUiTestAutomationService_enforcePermission();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        AccessibilityTraceManager r0 = this.mTraceManager;
        StringBuilder r4 = new StringBuilder();
        r4.append("owner=");
        r4.append(owner);
        r4.append(";serviceClient=");
        r4.append(serviceClient);
        r4.append(";accessibilityServiceInfo=");
        r4.append(accessibilityServiceInfo);
        r4.append(";flags=");
        int r13 = flags;
        r4.append(r13);
        r0.logTrace("AccessibilityManagerService.registerUiTestAutomationService", 4, r4.toString());
    L6:
        Object r14 = this.mLock;
        monitor-enter(r14);
        changeCurrentUserForTestAutomationIfNeededLocked(userId);     // Catch: Throwable -> L12
        UiAutomationManager r1 = this.mUiAutomationManager;     // Catch: Throwable -> L12
        Context r3 = this.mContext;     // Catch: Throwable -> L12
        int r5 = sIdCounter;     // Catch: Throwable -> L12
        sIdCounter = r5 + 1;     // Catch: Throwable -> L12
        r1.registerUiTestAutomationServiceLocked(owner, serviceClient, r3, accessibilityServiceInfo, r5, this.mMainHandler, this.mSecurityPolicy, this, getTraceManager(), this.mWindowManagerService, getSystemActionPerformer(), this.mA11yWindowManager, r13);     // Catch: Throwable -> L12
        onUserStateChangedLocked(getCurrentUserStateLocked());     // Catch: Throwable -> L12
        monitor-exit(r14);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r13 = flags;
        goto L6
    }

    public void unregisterUiTestAutomationService(IAccessibilityServiceClient serviceClient) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.unregisterUiTestAutomationService", 4, "serviceClient=" + serviceClient);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUiAutomationManager.unregisterUiTestAutomationServiceLocked(serviceClient);     // Catch: Throwable -> L10
        restoreCurrentUserAfterTestAutomationIfNeededLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void changeCurrentUserForTestAutomationIfNeededLocked(int userId) {
        if (this.mVisibleBgUserIds != null) goto L7;
        Slogf.d(LOG_TAG, "changeCurrentUserForTestAutomationIfNeededLocked(%d): ignoring because device doesn't support visible background users", new Object[]{Integer.valueOf(userId)});
        return;
    L7:
        if (this.mVisibleBgUserIds.get(userId) == true) goto L11;
        Slogf.wtf(LOG_TAG, "changeCurrentUserForTestAutomationIfNeededLocked(): cannot change current user to %d as it's not visible (mVisibleUsers=%s)", new Object[]{Integer.valueOf(userId), this.mVisibleBgUserIds});
        return;
    L11:
        if (this.mCurrentUserId != userId) goto L14;
        Slogf.d(LOG_TAG, "changeCurrentUserForTestAutomationIfNeededLocked(): NOT changing current user for test automation purposes as it is already %d", new Object[]{Integer.valueOf(this.mCurrentUserId)});
        return;
    L14:
        Slogf.i(LOG_TAG, "changeCurrentUserForTestAutomationIfNeededLocked(): changing current user from %d to %d for test automation purposes", new Object[]{Integer.valueOf(this.mCurrentUserId), Integer.valueOf(userId)});
        this.mRealCurrentUserId = this.mCurrentUserId;
        switchUser(userId);
    }

    private void restoreCurrentUserAfterTestAutomationIfNeededLocked() {
        if (this.mVisibleBgUserIds != null) goto L7;
        Slogf.d(LOG_TAG, "restoreCurrentUserForTestAutomationIfNeededLocked(): ignoring because device doesn't support visible background users");
        return;
    L7:
        if (this.mRealCurrentUserId != (-2)) goto L10;
        Slogf.d(LOG_TAG, "restoreCurrentUserForTestAutomationIfNeededLocked(): ignoring because mRealCurrentUserId is already USER_CURRENT");
        return;
    L10:
        Slogf.i(LOG_TAG, "restoreCurrentUserForTestAutomationIfNeededLocked(): restoring current user to %d after using %d for test automation purposes", new Object[]{Integer.valueOf(this.mRealCurrentUserId), Integer.valueOf(this.mCurrentUserId)});
        int currentUserId = this.mRealCurrentUserId;
        this.mRealCurrentUserId = -2;
        switchUser(currentUserId);
    }

    public IBinder getWindowToken(int windowId, int userId) {
        getWindowToken_enforcePermission();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.getWindowToken", 4, "windowId=" + windowId + ";userId=" + userId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L11
        if (resolvedUserId == this.mCurrentUserId) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L13:
        AccessibilityWindowInfo accessibilityWindowInfo = this.mA11yWindowManager.findA11yWindowInfoByIdLocked(windowId);     // Catch: Throwable -> L11
        if (accessibilityWindowInfo != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L17:
        IBinder r3 = this.mA11yWindowManager.getWindowTokenForUserAndWindowIdLocked(userId, accessibilityWindowInfo.getId());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    public void notifyAccessibilityButtonClicked(int displayId, String targetName) {
        notifyAccessibilityButtonClicked_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        int currentUserId = this.mCurrentUserId;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L9;
        this.mTraceManager.logTrace("AccessibilityManagerService.notifyAccessibilityButtonClicked", 4, "displayId=" + displayId + ";targetName=" + targetName);
    L9:
        if (targetName != null) goto L18;
        Object r1 = this.mLock;
        monitor-enter(r1);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L15
        targetName = userState.getTargetAssignedToAccessibilityButton();     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda63(), this, Integer.valueOf(displayId), Integer.valueOf(getShortcutTypeForGenericShortcutCalls(currentUserId)), targetName));
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void notifyAccessibilityButtonLongClicked(int displayId) {
        notifyAccessibilityButtonLongClicked_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userId = this.mCurrentUserId;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        showAccessibilityTargetsSelection(displayId, getShortcutTypeForGenericShortcutCalls(userId), userId);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void notifyAccessibilityButtonVisibilityChanged(boolean shown) {
        notifyAccessibilityButtonVisibilityChanged_enforcePermission();
        UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.notifyAccessibilityButtonVisibilityChanged", 4, "shown=" + shown);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifyAccessibilityButtonVisibilityChangedLocked(shown);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void notifyQuickSettingsTilesChanged(int userId, List<ComponentName> tileComponentNames) {
        notifyQuickSettingsTilesChanged_enforcePermission();
        Slog.d(LOG_TAG, String.format("notifyQuickSettingsTilesChanged userId: %s, tileComponentNames: %s", new Object[]{Integer.valueOf(userId), tileComponentNames}));
        final Set<ComponentName> newTileComponentNames = new ArraySet(tileComponentNames);
        Object r5 = this.mLock;
        monitor-enter(r5);
        AccessibilityUserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L10
        Map<ComponentName, AccessibilityServiceInfo> tileServiceToA11yServiceInfo = userState.getTileServiceToA11yServiceInfoMapLocked();     // Catch: Throwable -> L10
        Map<ComponentName, ComponentName> a11yFeatureToTileService = userState.getA11yFeatureToTileService();     // Catch: Throwable -> L10
        final ArraySet<ComponentName> currentTiles = userState.getA11yQsTilesInQsPanel();     // Catch: Throwable -> L10
        Set<ComponentName> addedTiles = (Set) newTileComponentNames.stream().filter(new AccessibilityManagerService$$ExternalSyntheticLambda71(currentTiles)).collect(Collectors.toSet());     // Catch: Throwable -> L10
        Set<ComponentName> removedTiles = (Set) currentTiles.stream().filter(new AccessibilityManagerService$$ExternalSyntheticLambda72(newTileComponentNames)).collect(Collectors.toSet());     // Catch: Throwable -> L10
        if (addedTiles.isEmpty() == true) goto L7;
    L12:
        userState.updateA11yTilesInQsPanelLocked(newTileComponentNames);     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        List<String> a11yFeaturesToEnable = new ArrayList();
        List<String> a11yFeaturesToRemove = new ArrayList();
        Iterator r8 = ShortcutConstants.A11Y_FEATURE_TO_FRAMEWORK_TILE.entrySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L24;
        Map.Entry<ComponentName, ComponentName> frameworkFeatureWithTile = (Map.Entry) r8.next();
        String a11yFeature = frameworkFeatureWithTile.getKey().flattenToString();
        ComponentName tile = frameworkFeatureWithTile.getValue();
        if (addedTiles.contains(tile) == true) goto L19;
        if (removedTiles.contains(tile) == false) goto L16;
        a11yFeaturesToRemove.add(a11yFeature);
        goto L16
    L19:
        a11yFeaturesToEnable.add(a11yFeature);
        goto L16
    L24:
        Iterator<Map.Entry<ComponentName, ComponentName>> r9 = a11yFeatureToTileService.entrySet().iterator();
    L26:
        if (r9.hasNext() == false) goto L41;
        Map.Entry<ComponentName, ComponentName> a11yFeatureWithTileService = r9.next();
        String a11yFeature2 = a11yFeatureWithTileService.getKey().flattenToString();
        ComponentName tileService = a11yFeatureWithTileService.getValue();
        if (addedTiles.contains(tileService) == true) goto L29;
        if (removedTiles.contains(tileService) == false) goto L26;
        a11yFeaturesToRemove.add(a11yFeature2);
        goto L26
    L29:
        AccessibilityServiceInfo serviceInfo = tileServiceToA11yServiceInfo.getOrDefault(tileService, null);
        if (serviceInfo == null) goto L34;
        if (isAccessibilityServiceWarningRequired(serviceInfo) == false) goto L34;
        logMetricForQsShortcutConfiguration(true, 1);
    L34:
        a11yFeaturesToEnable.add(a11yFeature2);
        goto L26
    L41:
        if (a11yFeaturesToEnable.isEmpty() == true) goto L44;
        enableShortcutForTargets(true, 16, a11yFeaturesToEnable, userId);
    L44:
        if (a11yFeaturesToRemove.isEmpty() == true) goto L70;
        enableShortcutForTargets(false, 16, a11yFeaturesToRemove, userId);
        return;
    L70:
        return;
    L7:
        if (removedTiles.isEmpty() == false) goto L12;
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$notifyQuickSettingsTilesChanged$10(ArraySet currentTiles, ComponentName tileComponentName) {
        return !currentTiles.contains(tileComponentName);
    }

    private static /* synthetic */ boolean lambda$notifyQuickSettingsTilesChanged$11(Set newTileComponentNames, ComponentName tileComponentName) {
        return !newTileComponentNames.contains(tileComponentName);
    }

    public boolean onGesture(AccessibilityGestureEvent gestureEvent) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean handled = notifyGestureLocked(gestureEvent, false);     // Catch: Throwable -> L8
        if (handled == true) goto L10;
        handled = notifyGestureLocked(gestureEvent, true);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return handled;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean sendMotionEventToListeningServices(MotionEvent event) {
        boolean result = scheduleNotifyMotionEvent(MotionEvent.obtain(event));
        return result;
    }

    public boolean onTouchStateChanged(int displayId, int state) {
        return scheduleNotifyTouchState(displayId, state);
    }

    @Override // com.android.server.accessibility.SystemActionPerformer.SystemActionsChangedListener
    public void onSystemActionsChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState state = getCurrentUserStateLocked();     // Catch: Throwable -> L7
        notifySystemActionsChangedLocked(state);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.SystemActionPerformer.DisplayUpdateCallBack
    public void moveNonProxyTopFocusedDisplayToTopIfNeeded() {
        this.mA11yWindowManager.moveNonProxyTopFocusedDisplayToTopIfNeeded();
    }

    @Override // com.android.server.accessibility.SystemActionPerformer.DisplayUpdateCallBack
    public int getLastNonProxyTopFocusedDisplayId() {
        return this.mA11yWindowManager.getLastNonProxyTopFocusedDisplayId();
    }

    void notifySystemActionsChangedLocked(AccessibilityUserState userState) {
        int i = userState.mBoundServices.size() - 1;
    L3:
        if (i < 0) goto L6;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);
        service.notifySystemActionsChangedLocked();
        i = i - 1;
        goto L3
    }

    public boolean notifyKeyEvent(KeyEvent event, int policyFlags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AccessibilityServiceConnection> boundServices = getCurrentUserStateLocked().mBoundServices;     // Catch: Throwable -> L9
        if (boundServices.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = getKeyEventDispatcher().notifyKeyEventLocked(event, policyFlags, boundServices);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void notifyMagnificationChanged(int displayId, Region region, MagnificationConfig config) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        notifyClearAccessibilityCacheLocked();     // Catch: Throwable -> L7
        notifyMagnificationChangedLocked(displayId, region, config);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setMotionEventInjectors(SparseArray<MotionEventInjector> motionEventInjectors) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMotionEventInjectors = motionEventInjectors;     // Catch: Throwable -> L7
        this.mLock.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public MotionEventInjector getMotionEventInjectorForDisplayLocked(int displayId) {
        long endMillis = SystemClock.uptimeMillis() + 1000;
    L4:
        if (this.mMotionEventInjectors != null) goto L12;
        if (SystemClock.uptimeMillis() >= endMillis) goto L12;
        this.mLock.wait(endMillis - SystemClock.uptimeMillis());     // Catch: InterruptedException -> L9
    L12:
        if (this.mMotionEventInjectors != null) goto L14;
        Slog.e(LOG_TAG, "MotionEventInjector installation timed out");
        return null;
    L14:
        MotionEventInjector motionEventInjector = this.mMotionEventInjectors.get(displayId);
        return motionEventInjector;
    }

    public boolean getAccessibilityFocusClickPointInScreen(Point outPoint) {
        return getInteractionBridge().getAccessibilityFocusClickPointInScreenNotLocked(outPoint);
    }

    public boolean performActionOnAccessibilityFocusedItem(AccessibilityNodeInfo.AccessibilityAction action) {
        return getInteractionBridge().performActionOnAccessibilityFocusedItemNotLocked(action);
    }

    public boolean accessibilityFocusOnlyInActiveWindow() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mA11yWindowManager.accessibilityFocusOnlyInActiveWindowLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean getWindowBounds(int windowId, Rect outBounds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IBinder token = getWindowToken(windowId, this.mCurrentUserId);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (this.mTraceManager.isA11yTracingEnabledForTypes(512) == false) goto L9;
        this.mTraceManager.logTrace("WindowManagerInternal.getWindowFrame", 512, "token=" + token + ";outBounds=" + outBounds);
    L9:
        this.mWindowManagerService.getWindowFrame(token, outBounds);
        if (outBounds.isEmpty() == true) goto L13;
        return true;
    L13:
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public int getActiveWindowId() {
        return this.mA11yWindowManager.getActiveWindowId(this.mCurrentUserId);
    }

    public void onTouchInteractionStart() {
        this.mA11yWindowManager.onTouchInteractionStart();
    }

    public void onTouchInteractionEnd() {
        this.mA11yWindowManager.onTouchInteractionEnd();
    }

    void switchUser(int userId) {
        this.mMagnificationController.updateUserIdIfNeeded(userId);
        List<AccessibilityServiceInfo> parsedAccessibilityServiceInfos = parseAccessibilityServiceInfos(userId);
        List<AccessibilityShortcutInfo> parsedAccessibilityShortcutInfos = parseAccessibilityShortcutInfos(userId);
        Set<ComponentName> validA11yTileServices = AccessibilityTileUtils.getValidA11yTileServices(this.mContext, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), parsedAccessibilityServiceInfos, parsedAccessibilityShortcutInfos, userId);
        Object r3 = this.mLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUserId == userId) goto L7;
    L13:
        AccessibilityUserState oldUserState = getCurrentUserStateLocked();     // Catch: Throwable -> L11
        oldUserState.onSwitchToAnotherUserLocked();     // Catch: Throwable -> L11
        if (oldUserState.mUserClients.getRegisteredCallbackCount() <= 0) goto L16;
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda53(), this, 0, Integer.valueOf(oldUserState.mUserId)));     // Catch: Throwable -> L11
    L16:
        this.mCurrentUserId = userId;     // Catch: Throwable -> L11
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L11
        readConfigurationForUserStateLocked(userState, parsedAccessibilityServiceInfos, parsedAccessibilityShortcutInfos, validA11yTileServices);     // Catch: Throwable -> L11
        this.mSecurityPolicy.onSwitchUserLocked(this.mCurrentUserId, userState.mEnabledServices);     // Catch: Throwable -> L11
        onUserStateChangedLocked(userState);     // Catch: Throwable -> L11
        migrateAccessibilityButtonSettingsIfNecessaryLocked(userState, null, 0);     // Catch: Throwable -> L11
        disableAccessibilityMenuToMigrateIfNeeded();     // Catch: Throwable -> L11
        updateShortcutsForCurrentNavigationMode();     // Catch: Throwable -> L11
        Iterator<IUserInitializationCompleteCallback> r6 = this.mUserInitializationCompleteCallbacks.iterator();     // Catch: Throwable -> L11
    L18:
        if (r6.hasNext() == false) goto L25;
        IUserInitializationCompleteCallback callback = r6.next();     // Catch: Throwable -> L11
        callback.onUserInitializationComplete(this.mCurrentUserId);     // Catch: Throwable -> L11 RemoteException -> L22
    L22:
        re = move-exception;
        Log.e(LOG_TAG, "Error while dispatching userInitializationComplete callback: ", re);     // Catch: Throwable -> L11
        goto L18
    L25:
        monitor-exit(r3);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mInitialized == false) goto L13;
        Slog.w(LOG_TAG, String.format("userId: %d is already initialized", new Object[]{Integer.valueOf(userId)}));     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
    }

    private void unlockUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int parentUserId = this.mSecurityPolicy.resolveProfileParentLocked(userId);     // Catch: Throwable -> L7
        if (parentUserId != this.mCurrentUserId) goto L9;
        AccessibilityUserState userState = getUserStateLocked(this.mCurrentUserId);     // Catch: Throwable -> L7
        onUserStateChangedLocked(userState);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserStates.remove(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        getMagnificationController().onUserRemoved(userId);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void restoreEnabledAccessibilityServicesLocked(String oldSetting, String newSetting, int restoreFromSdkInt, int userId) {
        readComponentNamesFromStringLocked(oldSetting, this.mTempComponentNameSet, false);
        readComponentNamesFromStringLocked(newSetting, this.mTempComponentNameSet, true);
        AccessibilityUserState userState = getUserStateLocked(userId);
        userState.mEnabledServices.clear();
        userState.mEnabledServices.addAll(this.mTempComponentNameSet);
        persistComponentNamesToSettingLocked("enabled_accessibility_services", userState.mEnabledServices, userState.mUserId);
        onUserStateChangedLocked(userState);
        migrateAccessibilityButtonSettingsIfNecessaryLocked(userState, null, restoreFromSdkInt);
    }

    private void restoreShortcutTargets(String newValue, int shortcutType, int userId) {
        assertNoTapShortcut(shortcutType);
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L7
        if (shortcutType != 2) goto L9;
        ArraySet<String> r3 = new ArraySet(ShortcutUtils.getShortcutTargetsFromSettings(this.mContext, shortcutType, userState.mUserId));     // Catch: Throwable -> L7
    L11:
        if (shortcutType != 2) goto L31;
        String defaultService = this.mContext.getString(R.string.config_defaultWellbeingPackage);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(defaultService) == false) goto L15;
        final ComponentName defaultServiceComponent = null;
    L16:
        if (defaultServiceComponent != null) goto L18;
    L20:
        boolean shouldClearDefaultService = false;
    L21:
        readColonDelimitedStringToSet(newValue, new AccessibilityManagerService$$ExternalSyntheticLambda74(), r3, true);     // Catch: Throwable -> L7
        if (shouldClearDefaultService == false) goto L27;
        if (stringSetContainsComponentName(r3, defaultServiceComponent) == false) goto L27;
        Slog.i(LOG_TAG, "Removing default service " + defaultService + " from restore of accessibility_shortcut_target_service");     // Catch: Throwable -> L7
        r3.removeIf(new AccessibilityManagerService$$ExternalSyntheticLambda75(defaultServiceComponent));     // Catch: Throwable -> L7
    L27:
        if (r3.isEmpty() == false) goto L32;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L32:
        userState.updateShortcutTargetsLocked(r3, shortcutType);     // Catch: Throwable -> L7
        persistColonDelimitedSetToSettingLocked(ShortcutUtils.convertToKey(shortcutType), userState.mUserId, r3, new AccessibilityManagerService$$ExternalSyntheticLambda77());     // Catch: Throwable -> L7
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);     // Catch: Throwable -> L7
        onUserStateChangedLocked(userState);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L18:
        if (stringSetContainsComponentName(r3, defaultServiceComponent) == true) goto L20;
        shouldClearDefaultService = true;
        goto L21
    L15:
        defaultServiceComponent = ComponentName.unflattenFromString(defaultService);     // Catch: Throwable -> L7
        goto L16
    L31:
        readColonDelimitedStringToSet(newValue, new AccessibilityManagerService$$ExternalSyntheticLambda76(), r3, true);     // Catch: Throwable -> L7
        goto L32
    L9:
        r3 = userState.getShortcutTargetsLocked(shortcutType);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String lambda$restoreShortcutTargets$12(String str) {
        return str;
    }

    private static /* synthetic */ boolean lambda$restoreShortcutTargets$13(ComponentName defaultServiceComponent, String str) {
        return defaultServiceComponent.equals(ComponentName.unflattenFromString(str));
    }

    private static /* synthetic */ String lambda$restoreShortcutTargets$14(String str) {
        return str;
    }

    private static /* synthetic */ String lambda$restoreShortcutTargets$15(String str) {
        return str;
    }

    private String getRawShortcutSetting(int userId, int shortcutType) {
        return Settings.Secure.getStringForUser(this.mContext.getContentResolver(), ShortcutUtils.convertToKey(shortcutType), userId);
    }

    private boolean stringSetContainsComponentName(Set<String> set, ComponentName componentName) {
        if (componentName == null) goto L6;
        Stream<R> r0 = set.stream().map(new AccessibilityManagerService$$ExternalSyntheticLambda57());
        componentName.getClass();
        if (r0.anyMatch(new AccessibilityManagerService$$ExternalSyntheticLambda58(componentName)) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private int getClientStateLocked(AccessibilityUserState userState) {
        return userState.getClientStateLocked(this.mUiAutomationManager.canIntrospect(), this.mTraceManager.getTraceStateForAccessibilityManagerClientState());
    }

    private InteractionBridge getInteractionBridge() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mInteractionBridge != null) goto L9;
        this.mInteractionBridge = new InteractionBridge(this);     // Catch: Throwable -> L7
    L9:
        InteractionBridge r1 = this.mInteractionBridge;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    private boolean notifyGestureLocked(AccessibilityGestureEvent gestureEvent, boolean isDefault) {
        AccessibilityUserState state = getCurrentUserStateLocked();
        int i = state.mBoundServices.size() - 1;
    L3:
        if (i < 0) goto L11;
        AccessibilityServiceConnection service = state.mBoundServices.get(i);
        if (service.mRequestTouchExplorationMode == false) goto L10;
        if (service.mIsDefault != isDefault) goto L10;
        service.notifyGesture(gestureEvent);
        return true;
    L10:
        i = i - 1;
        goto L3
    L11:
        return false;
    }

    private boolean scheduleNotifyMotionEvent(MotionEvent event) {
        boolean result = false;
        int displayId = event.getDisplayId();
        Object r2 = this.mLock;
        monitor-enter(r2);
        AccessibilityUserState state = getCurrentUserStateLocked();     // Catch: Throwable -> L13
        int i = state.mBoundServices.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (i < 0) goto L18;
        AccessibilityServiceConnection service = state.mBoundServices.get(i);     // Catch: Throwable -> L13
        if (service.wantsGenericMotionEvent(event) == false) goto L9;
    L15:
        service.notifyMotionEvent(event);     // Catch: Throwable -> L13
        result = true;
    L16:
        i = i - 1;     // Catch: Throwable -> L13
        goto L5
    L9:
        if (event.isFromSource(UsbACInterface.FORMAT_II_AC3) == false) goto L16;
        if (service.isServiceDetectsGesturesEnabled(displayId) == false) goto L16;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return result;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean scheduleNotifyTouchState(int displayId, int touchState) {
        boolean result = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        AccessibilityUserState state = getCurrentUserStateLocked();     // Catch: Throwable -> L9
        int i = state.mBoundServices.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        AccessibilityServiceConnection service = state.mBoundServices.get(i);     // Catch: Throwable -> L9
        if (service.isServiceDetectsGesturesEnabled(displayId) == false) goto L11;
        service.notifyTouchState(displayId, touchState);     // Catch: Throwable -> L9
        result = true;
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return result;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.ProxyManager.SystemSupport
    public void notifyClearAccessibilityCacheLocked() {
        AccessibilityUserState state = getCurrentUserStateLocked();
        int i = state.mBoundServices.size() - 1;
    L3:
        if (i < 0) goto L5;
        AccessibilityServiceConnection service = state.mBoundServices.get(i);
        service.notifyClearAccessibilityNodeInfoCache();
        i = i - 1;
        goto L3
    L5:
        this.mProxyManager.clearCacheLocked();
    }

    void updateShortcutsForCurrentNavigationMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L8
        if (AccessibilityUtils.isUserSetupCompleted(this.mContext) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int r3 = 0;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "navigation_mode", -1, userState.mUserId) != 2) goto L13;
        boolean isInGesturalNavigation = true;
    L14:
        Set r7 = userState.getShortcutTargetsLocked(32);     // Catch: Throwable -> L8
        ArraySet<String> r8 = userState.getShortcutTargetsLocked(1);     // Catch: Throwable -> L8
        int buttonMode = ShortcutUtils.getButtonMode(this.mContext, userState.mUserId);     // Catch: Throwable -> L8
        if (isInGesturalNavigation == false) goto L20;
        if (buttonMode != 2) goto L18;
        r7.addAll(r8);     // Catch: Throwable -> L8
        r8.clear();     // Catch: Throwable -> L8
    L18:
        buttonMode = 1;
    L26:
        updateShortcutTargetSets(userState, Set.of(Pair.create(r7, 32), Pair.create(r8, 1)));     // Catch: Throwable -> L8
        ShortcutUtils.setButtonMode(this.mContext, buttonMode, userState.mUserId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L20:
        if (r7.isEmpty() == true) goto L26;
        if (r8.isEmpty() == true) goto L25;
        r3 = 1;
    L25:
        buttonMode = r3;
        r8.addAll(r7);     // Catch: Throwable -> L8
        r7.clear();     // Catch: Throwable -> L8
        goto L26
    L13:
        isInGesturalNavigation = false;
    L8:
        th = move-exception;
        throw th;
    }

    private void notifyMagnificationChangedLocked(int displayId, Region region, MagnificationConfig config) {
        AccessibilityUserState state = getCurrentUserStateLocked();
        int i = state.mBoundServices.size() - 1;
    L3:
        if (i < 0) goto L6;
        AccessibilityServiceConnection service = state.mBoundServices.get(i);
        service.notifyMagnificationChangedLocked(displayId, region, config);
        i = i - 1;
        goto L3
    }

    private void notifyMagnificationShortcutTriggered(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.notifyMagnificationShortcutTriggered(displayId);     // Catch: Throwable -> L9
        goto L11
    }

    private void showAccessibilityTargetsSelection(int displayId, int shortcutType, final int userId) {
        final Intent intent = new Intent("com.android.internal.intent.action.CHOOSE_ACCESSIBILITY_BUTTON");
        if (shortcutType != 2) goto L5;
        String chooserClassName = AccessibilityShortcutChooserActivity.class.getName();
    L6:
        intent.setClassName(PackageManagerService.PLATFORM_PACKAGE_NAME, chooserClassName);
        intent.addFlags(268468224);
        intent.putExtra("TYPE", shortcutType);
        final Bundle bundle = ActivityOptions.makeBasic().setLaunchDisplayId(displayId).toBundle();
        this.mMainHandler.post(new AccessibilityManagerService$$ExternalSyntheticLambda73(this, intent, bundle, userId));
        return;
    L5:
        chooserClassName = AccessibilityButtonChooserActivity.class.getName();
        goto L6
    }

    private /* synthetic */ void lambda$showAccessibilityTargetsSelection$16(Intent intent, Bundle bundle, int userId) {
        this.mContext.startActivityAsUser(intent, bundle, UserHandle.of(userId));
    }

    private void launchShortcutTargetActivity(int displayId, ComponentName name) {
        Intent intent = new Intent();
        Bundle bundle = ActivityOptions.makeBasic().setLaunchDisplayId(displayId).toBundle();
        intent.setComponent(name);
        intent.addFlags(268435456);
        this.mContext.startActivityAsUser(intent, bundle, UserHandle.of(this.mCurrentUserId));     // Catch: ActivityNotFoundException -> L5
        return;
    }

    private void launchAccessibilitySubSettings(int displayId, ComponentName name) {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_DETAILS_SETTINGS");
        Bundle bundle = ActivityOptions.makeBasic().setLaunchDisplayId(displayId).toBundle();
        intent.addFlags(AudioFormat.AAC_ADIF);
        intent.putExtra("android.intent.extra.COMPONENT_NAME", name.flattenToString());
        this.mContext.startActivityAsUser(intent, bundle, UserHandle.of(this.mCurrentUserId));     // Catch: ActivityNotFoundException -> L5
        return;
    }

    private void launchHearingDevicesDialog() {
        Intent intent = new Intent(ACTION_LAUNCH_HEARING_DEVICES_DIALOG);
        intent.setFlags(268435456);
        intent.setPackage(this.mContext.getString(R.string.config_systemUi));
        this.mContext.sendBroadcastAsUser(intent, UserHandle.SYSTEM);
    }

    private void notifyAccessibilityButtonVisibilityChangedLocked(boolean available) {
        AccessibilityUserState state = getCurrentUserStateLocked();
        this.mIsAccessibilityButtonShown = available;
        int i = state.mBoundServices.size() - 1;
    L3:
        if (i < 0) goto L9;
        AccessibilityServiceConnection clientConnection = state.mBoundServices.get(i);
        if (clientConnection.mRequestAccessibilityButton == false) goto L7;
        clientConnection.notifyAccessibilityButtonAvailabilityChangedLocked(clientConnection.isAccessibilityButtonAvailableLocked(state));
    L7:
        i = i - 1;
        goto L3
    }

    private List<AccessibilityServiceInfo> parseAccessibilityServiceInfos(int userId) {
        List<AccessibilityServiceInfo> result = new ArrayList();
        int flags = 819332;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (getUserStateLocked(userId).getBindInstantServiceAllowedLocked() == false) goto L7;
        flags = 819332 | 8388608;     // Catch: Throwable -> L23
    L7:
        monitor-exit(r2);     // Catch: Throwable -> L23
        List<ResolveInfo> installedServices = this.mPackageManager.queryIntentServicesAsUser(new Intent("android.accessibilityservice.AccessibilityService"), flags, userId);
        int i = 0;
        int count = installedServices.size();
    L9:
        if (i >= count) goto L22;
        ResolveInfo resolveInfo = installedServices.get(i);
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (this.mSecurityPolicy.canRegisterService(serviceInfo) == false) goto L20;
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo(resolveInfo, this.mContext);     // Catch: Throwable -> L18
        if (accessibilityServiceInfo.isWithinParcelableSize() == true) goto L17;
        Slog.e(LOG_TAG, "Skipping service " + accessibilityServiceInfo.getResolveInfo().getComponentInfo() + " because service info size is larger than safe parcelable limits.");
        goto L20
    L17:
        result.add(accessibilityServiceInfo);
    L18:
        xppe = move-exception;
        Slog.e(LOG_TAG, "Error while initializing AccessibilityServiceInfo", xppe);
    L20:
        i = i + 1;
        goto L9
    L22:
        return result;
    }

    private boolean readInstalledAccessibilityServiceLocked(AccessibilityUserState userState, List<AccessibilityServiceInfo> parsedAccessibilityServiceInfos, Set<ComponentName> validA11yTileServices) {
        int i = 0;
        int count = parsedAccessibilityServiceInfos.size();
    L3:
        if (i >= count) goto L8;
        AccessibilityServiceInfo accessibilityServiceInfo = parsedAccessibilityServiceInfos.get(i);
        if (userState.mCrashedServices.contains(accessibilityServiceInfo.getComponentName()) == false) goto L7;
        accessibilityServiceInfo.crashed = true;
    L7:
        i = i + 1;
        goto L3
    L8:
        boolean serviceInfosChanged = false;
        if (parsedAccessibilityServiceInfos.equals(userState.mInstalledServices) == true) goto L11;
        userState.mInstalledServices.clear();
        userState.mInstalledServices.addAll(parsedAccessibilityServiceInfos);
        serviceInfosChanged = true;
    L11:
        userState.updateTileServiceMapForAccessibilityServiceLocked(validA11yTileServices);
        return serviceInfosChanged;
    }

    private List<AccessibilityShortcutInfo> parseAccessibilityShortcutInfos(int userId) {
        return AccessibilityManager.getInstance(this.mContext).getInstalledAccessibilityShortcutListAsUser(this.mContext, userId);
    }

    private boolean readInstalledAccessibilityShortcutLocked(AccessibilityUserState userState, final List<AccessibilityShortcutInfo> parsedAccessibilityShortcutInfos, Set<ComponentName> validA11yTileServices) {
        boolean shortcutInfosChanged = false;
        if (parsedAccessibilityShortcutInfos.equals(userState.mInstalledShortcuts) == true) goto L8;
        List<String> componentNames = userState.mInstalledShortcuts.stream().filter(new AccessibilityManagerService$$ExternalSyntheticLambda48(parsedAccessibilityShortcutInfos)).map(new AccessibilityManagerService$$ExternalSyntheticLambda49()).toList();
        if (componentNames.isEmpty() == true) goto L7;
        enableShortcutsForTargets(false, 127, componentNames, userState.mUserId);
    L7:
        userState.mInstalledShortcuts.clear();
        userState.mInstalledShortcuts.addAll(parsedAccessibilityShortcutInfos);
        shortcutInfosChanged = true;
    L8:
        userState.updateTileServiceMapForAccessibilityActivityLocked(validA11yTileServices);
        return shortcutInfosChanged;
    }

    private static /* synthetic */ boolean lambda$readInstalledAccessibilityShortcutLocked$17(List parsedAccessibilityShortcutInfos, AccessibilityShortcutInfo a11yActivity) {
        return !parsedAccessibilityShortcutInfos.contains(a11yActivity);
    }

    private static /* synthetic */ String lambda$readInstalledAccessibilityShortcutLocked$18(AccessibilityShortcutInfo a11yActivity) {
        return a11yActivity.getComponentName().flattenToString();
    }

    private boolean readEnabledAccessibilityServicesLocked(AccessibilityUserState userState) {
        this.mTempComponentNameSet.clear();
        readComponentNamesFromSettingLocked("enabled_accessibility_services", userState.mUserId, this.mTempComponentNameSet);
        if (this.mTempComponentNameSet.equals(userState.mEnabledServices) == true) goto L6;
        userState.mEnabledServices.clear();
        userState.mEnabledServices.addAll(this.mTempComponentNameSet);
        this.mTempComponentNameSet.clear();
        return true;
    L6:
        this.mTempComponentNameSet.clear();
        return false;
    }

    private boolean readTouchExplorationGrantedAccessibilityServicesLocked(AccessibilityUserState userState) {
        this.mTempComponentNameSet.clear();
        readComponentNamesFromSettingLocked("touch_exploration_granted_accessibility_services", userState.mUserId, this.mTempComponentNameSet);
        if (this.mTempComponentNameSet.equals(userState.mTouchExplorationGrantedServices) == true) goto L6;
        userState.mTouchExplorationGrantedServices.clear();
        userState.mTouchExplorationGrantedServices.addAll(this.mTempComponentNameSet);
        this.mTempComponentNameSet.clear();
        return true;
    L6:
        this.mTempComponentNameSet.clear();
        return false;
    }

    private void notifyAccessibilityServicesDelayedLocked(AccessibilityEvent event, boolean isDefault) {
        AccessibilityUserState state = getCurrentUserStateLocked();     // Catch: IndexOutOfBoundsException -> L8
        int i = 0;
        int count = state.mBoundServices.size();     // Catch: IndexOutOfBoundsException -> L8
    L3:
        if (i >= count) goto L18;
        AccessibilityServiceConnection service = state.mBoundServices.get(i);     // Catch: IndexOutOfBoundsException -> L8
        if (service.mIsDefault != isDefault) goto L10;
        service.notifyAccessibilityEvent(event);     // Catch: IndexOutOfBoundsException -> L8
    L10:
        i = i + 1;
        goto L3
    L18:
        return;
    }

    private void updateRelevantEventsLocked(final AccessibilityUserState userState) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(2) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.updateRelevantEventsLocked", 2, "userState=" + userState);
    L5:
        this.mMainHandler.post(new AccessibilityManagerService$$ExternalSyntheticLambda26(this, userState));
    }

    private /* synthetic */ void lambda$updateRelevantEventsLocked$20(final AccessibilityUserState userState) {
        broadcastToClients(userState, FunctionalUtils.ignoreRemoteException(new AccessibilityManagerService$$ExternalSyntheticLambda64(this, userState)));
    }

    private /* synthetic */ void lambda$updateRelevantEventsLocked$19(AccessibilityUserState userState, Client client) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int relevantEventTypes = computeRelevantEventTypesLocked(userState, client);     // Catch: Throwable -> L9
        if (this.mProxyManager.isProxyedDeviceId(client.mDeviceId) == false) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (client.mLastSentRelevantEventTypes == relevantEventTypes) goto L11;
        client.mLastSentRelevantEventTypes = relevantEventTypes;     // Catch: Throwable -> L9
        client.mCallback.setRelevantEventTypes(relevantEventTypes);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private int computeRelevantEventTypesLocked(AccessibilityUserState userState, Client client) {
        int relevantEventTypes = 0;
        int serviceCount = userState.mBoundServices.size();
        int i = 0;
    L3:
        int r3 = 0;
        if (i >= serviceCount) goto L11;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);
        if (isClientInPackageAllowlist(service.getServiceInfo(), client) == false) goto L9;
        r3 = service.getRelevantEventTypes();
    L9:
        relevantEventTypes = relevantEventTypes | r3;
        i = i + 1;
        goto L3
    L11:
        if (isClientInPackageAllowlist(this.mUiAutomationManager.getServiceInfo(), client) == false) goto L15;
        r3 = this.mUiAutomationManager.getRelevantEventTypes();
    L15:
        return relevantEventTypes | r3;
    }

    private void updateMagnificationModeChangeSettingsLocked(AccessibilityUserState userState, int displayId) {
        if (userState.mUserId == this.mCurrentUserId) goto L6;
        return;
    L6:
        if (fallBackMagnificationModeSettingsLocked(userState, displayId) == false) goto L8;
        return;
    L8:
        this.mMagnificationController.transitionMagnificationModeLocked(displayId, userState.getMagnificationModeLocked(displayId), new AccessibilityManagerService$$ExternalSyntheticLambda36(this));
    }

    void onMagnificationTransitionEndedLocked(int displayId, boolean success) {
        AccessibilityUserState userState = getCurrentUserStateLocked();
        int previousMode = userState.getMagnificationModeLocked(displayId) ^ 3;
        if (success == true) goto L8;
        if (previousMode == 0) goto L8;
        userState.setMagnificationModeLocked(displayId, previousMode);
        if (displayId != 0) goto L10;
        persistMagnificationModeSettingsLocked(previousMode);
        return;
    L10:
        return;
    L8:
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda41(), this, Integer.valueOf(displayId)));
    }

    private void notifyRefreshMagnificationModeToInputFilter(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayList<Display> displays = getValidDisplayList();     // Catch: Throwable -> L8
        int i = 0;
    L12:
        if (i >= displays.size()) goto L22;
        Display display = displays.get(i);     // Catch: Throwable -> L8
        if (display == null) goto L20;
        if (display.getDisplayId() != displayId) goto L20;
        this.mInputFilter.refreshMagnificationMode(display);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L20:
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    static boolean isClientInPackageAllowlist(AccessibilityServiceInfo serviceInfo, Client client) {
        int r0 = 0;
        if (serviceInfo != null) goto L5;
        return false;
    L5:
        String[] clientPackages = client.mPackageNames;
        boolean result = ArrayUtils.isEmpty(serviceInfo.packageNames);
        if (result == true) goto L16;
        if (clientPackages == null) goto L19;
        int r3 = clientPackages.length;
    L10:
        if (r0 >= r3) goto L21;
        String packageName = clientPackages[r0];
        if (ArrayUtils.contains(serviceInfo.packageNames, packageName) == true) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return true;
    L21:
        return result;
    L19:
        return result;
    L16:
        return result;
    }

    private void broadcastToClients(AccessibilityUserState userState, Consumer<Client> clientAction) {
        this.mGlobalClients.broadcastForEachCookie(clientAction);
        userState.mUserClients.broadcastForEachCookie(clientAction);
    }

    void readComponentNamesFromSettingLocked(String settingName, int userId, Set<ComponentName> outComponentNames) {
        readColonDelimitedSettingToSet(settingName, userId, new AccessibilityManagerService$$ExternalSyntheticLambda32(), outComponentNames);
    }

    private static /* synthetic */ ComponentName lambda$readComponentNamesFromSettingLocked$21(String str) {
        return ComponentName.unflattenFromString(str);
    }

    private static /* synthetic */ ComponentName lambda$readComponentNamesFromStringLocked$22(String str) {
        return ComponentName.unflattenFromString(str);
    }

    private void readComponentNamesFromStringLocked(String names, Set<ComponentName> outComponentNames, boolean doMerge) {
        readColonDelimitedStringToSet(names, new AccessibilityManagerService$$ExternalSyntheticLambda19(), outComponentNames, doMerge);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void persistComponentNamesToSettingLocked(String settingName, Set<ComponentName> componentNames, int userId) {
        persistColonDelimitedSetToSettingLocked(settingName, userId, componentNames, new AccessibilityManagerService$$ExternalSyntheticLambda13());
    }

    private static /* synthetic */ String lambda$persistComponentNamesToSettingLocked$23(ComponentName componentName) {
        return componentName.flattenToShortString();
    }

    <T> void readColonDelimitedSettingToSet(String settingName, int userId, Function<String, T> toItem, Set<T> outSet) {
        String settingValue = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), settingName, userId);
        readColonDelimitedStringToSet(settingValue, toItem, outSet, false);
    }

    private <T> void readColonDelimitedStringToSet(String names, Function<String, T> toItem, Set<T> outSet, boolean doMerge) {
        if (doMerge == true) goto L5;
        outSet.clear();
    L5:
        if (TextUtils.isEmpty(names) == true) goto L16;
        TextUtils.SimpleStringSplitter splitter = this.mStringColonSplitter;
        splitter.setString(names);
    L8:
        if (splitter.hasNext() == false) goto L24;
        String str = splitter.next();
        if (TextUtils.isEmpty(str) == true) goto L8;
        T item = toItem.apply(str);
        if (item == null) goto L8;
        outSet.add(item);
        goto L8
    L24:
        return;
    }

    <T> void persistColonDelimitedSetToSettingLocked(String settingName, int userId, Set<T> set, Function<T, String> toString) {
        persistColonDelimitedSetToSettingLocked(settingName, userId, set, toString, null);
    }

    private <T> void persistColonDelimitedSetToSettingLocked(String settingName, int userId, Set<T> set, Function<T, String> toString, String defaultEmptyString) {
        StringBuilder builder = new StringBuilder();
        Iterator<T> r1 = set.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        T item = r1.next();
        if (item == null) goto L8;
        String str = toString.apply(item);
    L10:
        if (TextUtils.isEmpty(str) == true) goto L4;
        if (builder.length() <= 0) goto L15;
        builder.append(COMPONENT_NAME_SEPARATOR);
    L15:
        builder.append(str);
        goto L4
    L8:
        str = null;
        goto L10
    L16:
        String builderValue = builder.toString();
        if (TextUtils.isEmpty(builderValue) == false) goto L19;
        String settingValue = defaultEmptyString;
    L20:
        String currentValue = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), settingName, userId);
        if (Objects.equals(settingValue, currentValue) == false) goto L23;
        return;
    L23:
        long identity = Binder.clearCallingIdentity();
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), settingName, settingValue, userId);     // Catch: Throwable -> L27
        Binder.restoreCallingIdentity(identity);
        return;
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L19:
        settingValue = builderValue;
        goto L20
    }

    private void persistIntToSetting(int userId, String settingName, int settingValue) {
        long identity = Binder.clearCallingIdentity();
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), settingName, settingValue, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void updateServicesLocked(AccessibilityUserState userState) {
        Map<ComponentName, AccessibilityServiceConnection> componentNameToServiceMap = userState.mComponentNameToServiceMap;
        boolean isUnlockingOrUnlocked = this.mUmi.isUserUnlockingOrUnlocked(userState.mUserId);
        this.mTempComponentNameSet.clear();
        int i = 0;
        int count = userState.mInstalledServices.size();
    L3:
        if (i >= count) goto L34;
        AccessibilityServiceInfo installedService = userState.mInstalledServices.get(i);
        ComponentName componentName = ComponentName.unflattenFromString(installedService.getId());
        this.mTempComponentNameSet.add(componentName);
        AccessibilityServiceConnection service = componentNameToServiceMap.get(componentName);
        if (isUnlockingOrUnlocked == true) goto L10;
        if (installedService.isDirectBootAware() == true) goto L10;
        Slog.d(LOG_TAG, "Ignoring non-encryption-aware service " + componentName);
        i = i;
        count = count;
        componentNameToServiceMap = componentNameToServiceMap;
    L33:
        i = i + 1;
        count = count;
        componentNameToServiceMap = componentNameToServiceMap;
    L10:
        if (userState.getBindingServicesLocked().contains(componentName) == false) goto L12;
        i = i;
        count = count;
        componentNameToServiceMap = componentNameToServiceMap;
        goto L33
    L12:
        if (userState.getCrashedServicesLocked().contains(componentName) == false) goto L15;
        i = i;
        count = count;
        componentNameToServiceMap = componentNameToServiceMap;
        goto L33
    L15:
        if (userState.mEnabledServices.contains(componentName) == false) goto L30;
        if (this.mUiAutomationManager.suppressingAccessibilityServicesLocked() == true) goto L30;
        if (isAccessibilityTargetAllowed(componentName.getPackageName(), installedService.getResolveInfo().serviceInfo.applicationInfo.uid, userState.mUserId) == true) goto L21;
        Slog.d(LOG_TAG, "Skipping enabling service disallowed by device admin policy: " + componentName);
        disableAccessibilityServiceLocked(componentName, userState.mUserId);
        i = i;
        count = count;
        componentNameToServiceMap = componentNameToServiceMap;
        goto L33
    L21:
        if (service != null) goto L23;
        int count2 = count;
        Context r2 = this.mContext;
        int r5 = sIdCounter;
        sIdCounter = r5 + 1;
        i = i;
        count = count2;
        componentNameToServiceMap = componentNameToServiceMap;
        AccessibilityServiceConnection service2 = new AccessibilityServiceConnection(userState, r2, componentName, installedService, r5, this.mMainHandler, this.mLock, this.mSecurityPolicy, this, getTraceManager(), this.mWindowManagerService, getSystemActionPerformer(), this.mA11yWindowManager, this.mActivityTaskManagerService);
    L27:
        service2.bindLocked();
        goto L33
    L23:
        i = i;
        count = count;
        componentNameToServiceMap = componentNameToServiceMap;
        if (userState.mBoundServices.contains(service) == true) goto L33;
        service2 = service;
    L30:
        if (service == 0) goto L33;
        service.unbindLocked();
        removeShortcutTargetForUnboundServiceLocked(userState, service);
        goto L33
    L34:
        int count3 = userState.mBoundServices.size();
        this.mTempIntArray.clear();
        int i2 = 0;
    L35:
        if (i2 >= count3) goto L40;
        ResolveInfo resolveInfo = userState.mBoundServices.get(i2).mAccessibilityServiceInfo.getResolveInfo();
        if (resolveInfo == null) goto L39;
        this.mTempIntArray.add(resolveInfo.serviceInfo.applicationInfo.uid);
    L39:
        i2 = i2 + 1;
        goto L35
    L40:
        AudioManagerInternal audioManager = (AudioManagerInternal) LocalServices.getService(AudioManagerInternal.class);
        if (audioManager == null) goto L43;
        audioManager.setAccessibilityServiceUids(this.mTempIntArray);
    L43:
        this.mActivityTaskManagerService.setAccessibilityServiceUids(this.mTempIntArray);
        if (userState.mEnabledServices.removeIf(new AccessibilityManagerService$$ExternalSyntheticLambda34(this)) == false) goto L46;
    L49:
        boolean anyServiceRemoved = true;
    L51:
        if (anyServiceRemoved == false) goto L53;
        persistComponentNamesToSettingLocked("enabled_accessibility_services", userState.mEnabledServices, userState.mUserId);
        persistComponentNamesToSettingLocked("touch_exploration_granted_accessibility_services", userState.mTouchExplorationGrantedServices, userState.mUserId);
    L53:
        updateAccessibilityEnabledSettingLocked(userState);
        return;
    L46:
        if (userState.mTouchExplorationGrantedServices.removeIf(new AccessibilityManagerService$$ExternalSyntheticLambda35(this)) == true) goto L49;
        anyServiceRemoved = false;
        goto L51
    }

    private /* synthetic */ boolean lambda$updateServicesLocked$24(ComponentName comp) {
        return !this.mTempComponentNameSet.contains(comp);
    }

    private /* synthetic */ boolean lambda$updateServicesLocked$25(ComponentName comp) {
        return !this.mTempComponentNameSet.contains(comp);
    }

    void scheduleUpdateClientsIfNeededLocked(AccessibilityUserState userState) {
        scheduleUpdateClientsIfNeededLocked(userState, false);
    }

    void scheduleUpdateClientsIfNeededLocked(AccessibilityUserState userState, boolean forceUpdate) {
        int clientState = getClientStateLocked(userState);
        if (userState.getLastSentClientStateLocked() != clientState) goto L6;
        if (forceUpdate == true) goto L6;
        return;
    L6:
        if (this.mGlobalClients.getRegisteredCallbackCount() <= 0) goto L8;
    L9:
        userState.setLastSentClientStateLocked(clientState);
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda40(), this, Integer.valueOf(clientState), Integer.valueOf(userState.mUserId)));
        return;
    L8:
        if (userState.mUserClients.getRegisteredCallbackCount() > 0) goto L9;
    }

    private void sendStateToAllClients(int clientState, int userId) {
        sendStateToClients(clientState, this.mGlobalClients);
        sendStateToClients(clientState, userId);
    }

    private void sendStateToClients(int clientState, int userId) {
        sendStateToClients(clientState, getUserState(userId).mUserClients);
    }

    private void sendStateToClients(final int clientState, RemoteCallbackList<IAccessibilityManagerClient> clients) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(8) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.sendStateToClients", 8, "clientState=" + clientState);
    L5:
        clients.broadcastForEachCookie(FunctionalUtils.ignoreRemoteException(new AccessibilityManagerService$$ExternalSyntheticLambda7(this, clientState)));
    }

    private /* synthetic */ void lambda$sendStateToClients$26(int clientState, Object client) throws RemoteException {
        Client managerClient = (Client) client;
        if (this.mProxyManager.isProxyedDeviceId(managerClient.mDeviceId) == true) goto L6;
        managerClient.mCallback.setState(clientState);
        return;
    }

    private void scheduleNotifyClientsOfServicesStateChangeLocked(AccessibilityUserState userState) {
        updateRecommendedUiTimeoutLocked(userState);
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda27(), this, userState.mUserClients, Long.valueOf(getRecommendedTimeoutMillisLocked(userState))));
    }

    private void sendServicesStateChanged(RemoteCallbackList<IAccessibilityManagerClient> userClients, long uiTimeout) {
        notifyClientsOfServicesStateChange(this.mGlobalClients, uiTimeout);
        notifyClientsOfServicesStateChange(userClients, uiTimeout);
    }

    private void notifyClientsOfServicesStateChange(RemoteCallbackList<IAccessibilityManagerClient> clients, final long uiTimeout) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(8) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.notifyClientsOfServicesStateChange", 8, "uiTimeout=" + uiTimeout);
    L5:
        clients.broadcastForEachCookie(FunctionalUtils.ignoreRemoteException(new AccessibilityManagerService$$ExternalSyntheticLambda12(this, uiTimeout)));
    }

    private /* synthetic */ void lambda$notifyClientsOfServicesStateChange$27(long uiTimeout, Object client) throws RemoteException {
        Client managerClient = (Client) client;
        if (this.mProxyManager.isProxyedDeviceId(managerClient.mDeviceId) == true) goto L6;
        managerClient.mCallback.notifyServicesStateChanged(uiTimeout);
        return;
    }

    private void scheduleUpdateInputFilter(AccessibilityUserState userState) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda62(), this, userState));
    }

    private void scheduleUpdateFingerprintGestureHandling(AccessibilityUserState userState) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda65(), this, userState));
    }

    private void updateInputFilter(AccessibilityUserState userState) {
        if (this.mUiAutomationManager.suppressingAccessibilityServicesLocked() == false) goto L5;
        return;
    L5:
        boolean setInputFilter = false;
        IInputFilter r1 = null;
        Object r2 = this.mLock;
        monitor-enter(r2);
        int flags = 0;
    L30:
        th = move-exception;
        throw th;
    L9:
        if (userState.isMagnificationSingleFingerTripleTapEnabledLocked() == false) goto L12;
        flags = 0 | 1;     // Catch: Throwable -> L30
    L12:
        if (userState.isShortcutMagnificationEnabledLocked() == false) goto L15;
        flags = flags | 64;     // Catch: Throwable -> L30
    L15:
        if (userHasMagnificationServicesLocked(userState) == false) goto L18;
        flags = flags | 32;     // Catch: Throwable -> L30
    L18:
        if (userState.isHandlingAccessibilityEventsLocked() == false) goto L33;
        if (userState.isTouchExplorationEnabledLocked() == false) goto L33;
        flags = flags | 2;     // Catch: Throwable -> L30
        if (userState.isServiceHandlesDoubleTapEnabledLocked() == false) goto L25;
        flags = flags | 128;     // Catch: Throwable -> L30
    L25:
        if (userState.isMultiFingerGesturesEnabledLocked() == false) goto L28;
        flags = flags | 256;     // Catch: Throwable -> L30
    L28:
        if (userState.isTwoFingerPassthroughEnabledLocked() == false) goto L33;
        flags = flags | 512;     // Catch: Throwable -> L30
    L33:
        if (userState.isFilterKeyEventsEnabledLocked() == false) goto L36;
        flags = flags | 4;     // Catch: Throwable -> L30
    L36:
        if (userState.isSendMotionEventsEnabled() == false) goto L39;
        flags = flags | 1024;     // Catch: Throwable -> L30
    L39:
        if (userState.isAutoclickEnabledLocked() == false) goto L42;
        flags = flags | 8;     // Catch: Throwable -> L30
    L42:
        if (userState.isPerformGesturesEnabledLocked() == false) goto L44;
        flags = flags | 16;     // Catch: Throwable -> L30
    L44:
        int combinedGenericMotionEventSources = 0;
        int combinedMotionEventObservedSources = 0;
        Iterator<AccessibilityServiceConnection> r6 = userState.mBoundServices.iterator();     // Catch: Throwable -> L30
    L46:
        if (r6.hasNext() == false) goto L48;
        AccessibilityServiceConnection connection = r6.next();     // Catch: Throwable -> L30
        combinedGenericMotionEventSources = combinedGenericMotionEventSources | connection.mGenericMotionEventSources;     // Catch: Throwable -> L30
        combinedMotionEventObservedSources = combinedMotionEventObservedSources | connection.mObservedMotionEventSources;     // Catch: Throwable -> L30
        goto L46
    L48:
        if (combinedGenericMotionEventSources == 0) goto L51;
        flags = flags | 2048;     // Catch: Throwable -> L30
    L51:
        if (userState.isMouseKeysEnabled() == false) goto L53;
        flags = flags | 8192;     // Catch: Throwable -> L30
    L53:
        if (flags == 0) goto L62;
        if (this.mHasInputFilter == true) goto L60;
        this.mHasInputFilter = true;     // Catch: Throwable -> L30
        if (this.mInputFilter != null) goto L59;
        this.mInputFilter = new AccessibilityInputFilter(this.mContext, this);     // Catch: Throwable -> L30
    L59:
        r1 = this.mInputFilter;     // Catch: Throwable -> L30
        setInputFilter = true;
    L60:
        this.mInputFilter.setUserAndEnabledFeatures(userState.mUserId, flags);     // Catch: Throwable -> L30
        this.mInputFilter.setCombinedGenericMotionEventSources(combinedGenericMotionEventSources);     // Catch: Throwable -> L30
        this.mInputFilter.setCombinedMotionEventObservedSources(combinedMotionEventObservedSources);     // Catch: Throwable -> L30
    L70:
        Slog.d(LOG_TAG, "updateInputFilter setInputFilter=" + setInputFilter + " inputFilter=" + r1 + " flags=" + flags);     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        if (setInputFilter == true) goto L74;
        return;
    L74:
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4608) == false) goto L76;
        this.mTraceManager.logTrace("WindowManagerInternal.setInputFilter", 4608, "inputFilter=" + r1);
    L76:
        this.mWindowManagerService.setInputFilter(r1);
        this.mProxyManager.setAccessibilityInputFilter(r1);
        return;
    L62:
        if (this.mHasInputFilter == false) goto L70;
        this.mHasInputFilter = false;     // Catch: Throwable -> L30
        this.mInputFilter.setUserAndEnabledFeatures(userState.mUserId, 0);     // Catch: Throwable -> L30
        this.mInputFilter.resetServiceDetectsGestures();     // Catch: Throwable -> L30
        if (userState.isTouchExplorationEnabledLocked() == false) goto L69;
        ArrayList<Display> displays = getValidDisplayList();     // Catch: Throwable -> L30
        Iterator<Display> r7 = displays.iterator();     // Catch: Throwable -> L30
    L67:
        if (r7.hasNext() == false) goto L69;
        Display display = r7.next();     // Catch: Throwable -> L30
        int displayId = display.getDisplayId();     // Catch: Throwable -> L30
        boolean mode = userState.isServiceDetectsGesturesEnabled(displayId);     // Catch: Throwable -> L30
        this.mInputFilter.setServiceDetectsGesturesEnabled(displayId, mode);     // Catch: Throwable -> L30
    L69:
        r1 = null;
        setInputFilter = true;
        goto L70
    }

    private void showEnableTouchExplorationDialog(final AccessibilityServiceConnection service) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String label = service.getServiceInfo().getResolveInfo().loadLabel(this.mContext.getPackageManager()).toString();     // Catch: Throwable -> L8
        final AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L8
        if (userState.isTouchExplorationEnabledLocked() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mEnableTouchExplorationDialog != null) goto L13;
    L16:
        this.mEnableTouchExplorationDialog = new AlertDialog.Builder(this.mContext).setIconAttribute(R.attr.alertDialogIcon).setPositiveButton(R.string.ok, new AnonymousClass4(this, userState, service)).setNegativeButton(R.string.cancel, new AnonymousClass3(this)).setTitle(R.string.face_error_hw_not_available).setMessage(this.mContext.getString(R.string.face_error_canceled, new Object[]{label})).create();     // Catch: Throwable -> L8
        this.mEnableTouchExplorationDialog.getWindow().setType(2003);     // Catch: Throwable -> L8
        this.mEnableTouchExplorationDialog.getWindow().getAttributes().privateFlags |= 16;     // Catch: Throwable -> L8
        this.mEnableTouchExplorationDialog.setCanceledOnTouchOutside(true);     // Catch: Throwable -> L8
        this.mEnableTouchExplorationDialog.show();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (this.mEnableTouchExplorationDialog.isShowing() == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onUserVisibilityChanged(int userId, boolean visible) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (visible == false) goto L8;
        this.mVisibleBgUserIds.put(userId, visible);     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        this.mVisibleBgUserIds.delete(userId);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void onUserStateChangedLocked(AccessibilityUserState userState) {
        onUserStateChangedLocked(userState, false);
    }

    private void onUserStateChangedLocked(AccessibilityUserState userState, boolean forceUpdate) {
        Slog.v(LOG_TAG, String.format("onUserStateChangedLocked for userId: %d, forceUpdate: %s", new Object[]{Integer.valueOf(userState.mUserId), Boolean.valueOf(forceUpdate)}));
        this.mInitialized = true;
        updateLegacyCapabilitiesLocked(userState);
        updateServicesLocked(userState);
        updateWindowsForAccessibilityCallbackLocked(userState);
        updateFilterKeyEventsLocked(userState);
        updateTouchExplorationLocked(userState);
        updatePerformGesturesLocked(userState);
        updateMagnificationLocked(userState);
        scheduleUpdateFingerprintGestureHandling(userState);
        scheduleUpdateInputFilter(userState);
        updateRelevantEventsLocked(userState);
        scheduleUpdateClientsIfNeededLocked(userState, forceUpdate);
        updateAccessibilityShortcutTargetsLocked(userState, 2);
        updateAccessibilityShortcutTargetsLocked(userState, 1);
        updateAccessibilityShortcutTargetsLocked(userState, 32);
        updateAccessibilityShortcutTargetsLocked(userState, 16);
        updateAccessibilityShortcutTargetsLocked(userState, 64);
        updateMagnificationCapabilitiesSettingsChangeLocked(userState);
        updateMagnificationModeChangeSettingsForAllDisplaysLocked(userState);
        updateFocusAppearanceDataLocked(userState);
    }

    private void updateMagnificationModeChangeSettingsForAllDisplaysLocked(AccessibilityUserState userState) {
        ArrayList<Display> displays = getValidDisplayList();
        int i = 0;
    L4:
        if (i >= displays.size()) goto L7;
        int displayId = displays.get(i).getDisplayId();
        updateMagnificationModeChangeSettingsLocked(userState, displayId);
        i = i + 1;
        goto L4
    }

    private void updateWindowsForAccessibilityCallbackLocked(AccessibilityUserState userState) {
        if (this.mUiAutomationManager.canRetrieveInteractiveWindowsLocked() == false) goto L5;
    L8:
        boolean observingWindows = true;
    L9:
        List<AccessibilityServiceConnection> boundServices = userState.mBoundServices;
        int boundServiceCount = boundServices.size();
        int i = 0;
    L10:
        if (observingWindows == true) goto L16;
        if (i >= boundServiceCount) goto L16;
        AccessibilityServiceConnection boundService = boundServices.get(i);
        if (boundService.canRetrieveInteractiveWindowsLocked() == false) goto L15;
        userState.setAccessibilityFocusOnlyInActiveWindow(false);
        observingWindows = true;
    L15:
        i = i + 1;
    L16:
        userState.setAccessibilityFocusOnlyInActiveWindow(true);
        ArrayList<Display> displays = getValidDisplayList();
        int i2 = 0;
    L18:
        if (i2 >= displays.size()) goto L33;
        Display display = displays.get(i2);
        if (display == null) goto L31;
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L24;
    L28:
        if (observingWindows == false) goto L30;
        this.mA11yWindowManager.startTrackingWindows(display.getDisplayId(), this.mProxyManager.isProxyedDisplay(display.getDisplayId()));
        goto L31
    L30:
        this.mA11yWindowManager.stopTrackingWindows(display.getDisplayId());
        goto L31
    L24:
        if (this.mProxyManager.isProxyedDisplay(display.getDisplayId()) == true) goto L28;
        if (this.mUmi.isUserVisible(this.mCurrentUserId, display.getDisplayId()) == true) goto L28;
    L31:
        i2 = i2 + 1;
        goto L18
    L33:
        return;
    L5:
        if (this.mProxyManager.canRetrieveInteractiveWindowsLocked() == true) goto L8;
        observingWindows = false;
        goto L9
    }

    private void updateLegacyCapabilitiesLocked(AccessibilityUserState userState) {
        int installedServiceCount = userState.mInstalledServices.size();
        int i = 0;
    L3:
        if (i >= installedServiceCount) goto L13;
        AccessibilityServiceInfo serviceInfo = userState.mInstalledServices.get(i);
        ResolveInfo resolveInfo = serviceInfo.getResolveInfo();
        if ((serviceInfo.getCapabilities() & 2) != 0) goto L11;
        if (resolveInfo.serviceInfo.applicationInfo.targetSdkVersion > 17) goto L11;
        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        if (userState.mTouchExplorationGrantedServices.contains(componentName) == false) goto L11;
        serviceInfo.setCapabilities(serviceInfo.getCapabilities() | 2);
    L11:
        i = i + 1;
        goto L3
    }

    private void updatePerformGesturesLocked(AccessibilityUserState userState) {
        int serviceCount = userState.mBoundServices.size();
        int i = 0;
    L3:
        if (i >= serviceCount) goto L9;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);
        if ((service.getCapabilities() & 32) != 0) goto L6;
        i = i + 1;
        goto L3
    L6:
        userState.setPerformGesturesEnabledLocked(true);
        return;
    L9:
        userState.setPerformGesturesEnabledLocked(false);
    }

    private void updateFilterKeyEventsLocked(AccessibilityUserState userState) {
        int serviceCount = userState.mBoundServices.size();
        int i = 0;
    L3:
        if (i >= serviceCount) goto L11;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);
        if (service.mRequestFilterKeyEvents == false) goto L10;
        if ((service.getCapabilities() & 8) == 0) goto L10;
        userState.setFilterKeyEventsEnabledLocked(true);
        return;
    L10:
        i = i + 1;
        goto L3
    L11:
        userState.setFilterKeyEventsEnabledLocked(false);
    }

    private boolean readConfigurationForUserStateLocked(AccessibilityUserState userState, List<AccessibilityServiceInfo> parsedAccessibilityServiceInfos, List<AccessibilityShortcutInfo> parsedAccessibilityShortcutInfos, Set<ComponentName> validA11yTileServices) {
        boolean somethingChanged = readInstalledAccessibilityServiceLocked(userState, parsedAccessibilityServiceInfos, validA11yTileServices);
        return ((((((((((((((((((((somethingChanged | readInstalledAccessibilityShortcutLocked(userState, parsedAccessibilityShortcutInfos, validA11yTileServices)) | readEnabledAccessibilityServicesLocked(userState)) | readTouchExplorationGrantedAccessibilityServicesLocked(userState)) | readTouchExplorationEnabledSettingLocked(userState)) | readHighTextContrastEnabledSettingLocked(userState)) | readAudioDescriptionEnabledSettingLocked(userState)) | readMagnificationEnabledSettingsLocked(userState)) | readAutoclickEnabledSettingLocked(userState)) | readAccessibilityShortcutTargetsLocked(userState, 2)) | readAccessibilityShortcutTargetsLocked(userState, 16)) | readAccessibilityShortcutTargetsLocked(userState, 1)) | readAccessibilityShortcutTargetsLocked(userState, 32)) | readAccessibilityShortcutTargetsLocked(userState, 64)) | readAccessibilityButtonTargetComponentLocked(userState)) | readUserRecommendedUiTimeoutSettingsLocked(userState)) | readMagnificationModeForDefaultDisplayLocked(userState)) | readMagnificationCapabilitiesLocked(userState)) | readMagnificationFollowTypingLocked(userState)) | readAlwaysOnMagnificationLocked(userState)) | readMouseKeysEnabledLocked(userState)) | readRepeatKeysSettingsLocked(userState);
    }

    private void updateAccessibilityEnabledSettingLocked(AccessibilityUserState userState) {
        int r1 = 1;
        if (this.mUiAutomationManager.canIntrospect() == false) goto L5;
    L8:
        boolean isA11yEnabled = true;
    L9:
        long identity = Binder.clearCallingIdentity();
        ContentResolver r5 = this.mContext.getContentResolver();     // Catch: Throwable -> L17
        if (isA11yEnabled == true) goto L14;
        r1 = 0;
    L14:
        Settings.Secure.putIntForUser(r5, "accessibility_enabled", r1, userState.mUserId);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(identity);
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        if (userState.isHandlingAccessibilityEventsLocked() == true) goto L8;
        isA11yEnabled = false;
        goto L9
    }

    private boolean readTouchExplorationEnabledSettingLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "touch_exploration_enabled", 0, userState.mUserId) != 1) goto L5;
        boolean touchExplorationEnabled = true;
    L7:
        if (touchExplorationEnabled == userState.isTouchExplorationEnabledLocked()) goto L10;
        userState.setTouchExplorationEnabledLocked(touchExplorationEnabled);
        return true;
    L10:
        return false;
    L5:
        touchExplorationEnabled = false;
        goto L7
    }

    private boolean readMagnificationEnabledSettingsLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_display_magnification_enabled", 0, userState.mUserId) != 1) goto L5;
        boolean magnificationSingleFingerTripleTapEnabled = true;
    L7:
        if (magnificationSingleFingerTripleTapEnabled == userState.isMagnificationSingleFingerTripleTapEnabledLocked()) goto L10;
        userState.setMagnificationSingleFingerTripleTapEnabledLocked(magnificationSingleFingerTripleTapEnabled);
        return true;
    L10:
        return false;
    L5:
        magnificationSingleFingerTripleTapEnabled = false;
        goto L7
    }

    private boolean readMagnificationTwoFingerTripleTapSettingsLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_magnification_two_finger_triple_tap_enabled", 0, userState.mUserId) != 1) goto L5;
        boolean magnificationTwoFingerTripleTapEnabled = true;
    L7:
        if (magnificationTwoFingerTripleTapEnabled == userState.isMagnificationTwoFingerTripleTapEnabledLocked()) goto L10;
        userState.setMagnificationTwoFingerTripleTapEnabledLocked(magnificationTwoFingerTripleTapEnabled);
        return true;
    L10:
        return false;
    L5:
        magnificationTwoFingerTripleTapEnabled = false;
        goto L7
    }

    private boolean readAutoclickEnabledSettingLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_autoclick_enabled", 0, userState.mUserId) != 1) goto L5;
        boolean autoclickEnabled = true;
    L7:
        if (autoclickEnabled == userState.isAutoclickEnabledLocked()) goto L10;
        userState.setAutoclickEnabledLocked(autoclickEnabled);
        return true;
    L10:
        return false;
    L5:
        autoclickEnabled = false;
        goto L7
    }

    private boolean readHighTextContrastEnabledSettingLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "high_text_contrast_enabled", 0, userState.mUserId) != 1) goto L5;
        boolean highTextContrastEnabled = true;
    L7:
        if (highTextContrastEnabled == userState.isTextHighContrastEnabledLocked()) goto L10;
        userState.setTextHighContrastEnabledLocked(highTextContrastEnabled);
        return true;
    L10:
        return false;
    L5:
        highTextContrastEnabled = false;
        goto L7
    }

    private boolean readAudioDescriptionEnabledSettingLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "enabled_accessibility_audio_description_by_default", 0, userState.mUserId) != 1) goto L5;
        boolean audioDescriptionByDefaultEnabled = true;
    L7:
        if (audioDescriptionByDefaultEnabled == userState.isAudioDescriptionByDefaultEnabledLocked()) goto L10;
        userState.setAudioDescriptionByDefaultEnabledLocked(audioDescriptionByDefaultEnabled);
        return true;
    L10:
        return false;
    L5:
        audioDescriptionByDefaultEnabled = false;
        goto L7
    }

    private void updateTouchExplorationLocked(AccessibilityUserState userState) {
        boolean touchExplorationEnabled = this.mUiAutomationManager.isTouchExplorationEnabledLocked();
        boolean serviceHandlesDoubleTapEnabled = false;
        boolean requestMultiFingerGestures = false;
        boolean requestTwoFingerPassthrough = false;
        boolean sendMotionEvents = false;
        int serviceCount = userState.mBoundServices.size();
        int i = 0;
    L3:
        if (i >= serviceCount) goto L9;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);
        if (canRequestAndRequestsTouchExplorationLocked(service, userState) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        touchExplorationEnabled = true;
        serviceHandlesDoubleTapEnabled = service.isServiceHandlesDoubleTapEnabled();
        requestMultiFingerGestures = service.isMultiFingerGesturesEnabled();
        requestTwoFingerPassthrough = service.isTwoFingerPassthroughEnabled();
        sendMotionEvents = service.isSendMotionEventsEnabled();
    L9:
        if (touchExplorationEnabled == userState.isTouchExplorationEnabledLocked()) goto L20;
        userState.setTouchExplorationEnabledLocked(touchExplorationEnabled);
        long identity = Binder.clearCallingIdentity();
        ContentResolver r6 = this.mContext.getContentResolver();     // Catch: Throwable -> L17
        if (touchExplorationEnabled == false) goto L14;
        int r11 = 1;
    L15:
        Settings.Secure.putIntForUser(r6, "touch_exploration_enabled", r11, userState.mUserId);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(identity);
        goto L20
    L14:
        r11 = 0;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L20:
        userState.resetServiceDetectsGestures();
        ArrayList<Display> displays = getValidDisplayList();
        Iterator<AccessibilityServiceConnection> r8 = userState.mBoundServices.iterator();
    L22:
        if (r8.hasNext() == false) goto L31;
        AccessibilityServiceConnection service2 = r8.next();
        Iterator<Display> r10 = displays.iterator();
    L25:
        if (r10.hasNext() == false) goto L22;
        Display display = r10.next();
        int displayId = display.getDisplayId();
        if (service2.isServiceDetectsGesturesEnabled(displayId) == false) goto L25;
        userState.setServiceDetectsGesturesEnabled(displayId, true);
        goto L25
    L31:
        userState.setServiceHandlesDoubleTapLocked(serviceHandlesDoubleTapEnabled);
        userState.setMultiFingerGesturesLocked(requestMultiFingerGestures);
        userState.setTwoFingerPassthroughLocked(requestTwoFingerPassthrough);
        userState.setSendMotionEventsEnabled(sendMotionEvents);
    }

    private boolean readAccessibilityShortcutTargetsLocked(AccessibilityUserState userState, int shortcutType) {
        assertNoTapShortcut(shortcutType);
        String settingValue = getRawShortcutSetting(userState.mUserId, shortcutType);
        ArraySet r1 = new ArraySet();
        if (shortcutType != 2) goto L11;
        if (settingValue != null) goto L11;
        String defaultService = this.mContext.getString(R.string.config_defaultWellbeingPackage);
        if (TextUtils.isEmpty(defaultService) == true) goto L13;
        ComponentName name = ComponentName.unflattenFromString(defaultService);
        if (name == null) goto L13;
        r1.add(name.flattenToString());
    L13:
        if (userState.updateShortcutTargetsLocked(r1, shortcutType) == false) goto L16;
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);
        return true;
    L16:
        return false;
    L11:
        readColonDelimitedStringToSet(settingValue, new AccessibilityManagerService$$ExternalSyntheticLambda56(), r1, false);
        goto L13
    }

    private static /* synthetic */ String lambda$readAccessibilityShortcutTargetsLocked$28(String str) {
        return str;
    }

    private boolean readAccessibilityButtonTargetComponentLocked(AccessibilityUserState userState) {
        String componentId = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "accessibility_button_target_component", userState.mUserId);
        if (TextUtils.isEmpty(componentId) == false) goto L10;
        if (userState.getTargetAssignedToAccessibilityButton() != null) goto L7;
        return false;
    L7:
        userState.setTargetAssignedToAccessibilityButton(null);
        return true;
    L10:
        if (componentId.equals(userState.getTargetAssignedToAccessibilityButton()) == false) goto L12;
        return false;
    L12:
        userState.setTargetAssignedToAccessibilityButton(componentId);
        return true;
    }

    private boolean readUserRecommendedUiTimeoutSettingsLocked(AccessibilityUserState userState) {
        int nonInteractiveUiTimeout = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_non_interactive_ui_timeout_ms", 0, userState.mUserId);
        int interactiveUiTimeout = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_interactive_ui_timeout_ms", 0, userState.mUserId);
        this.mProxyManager.updateTimeoutsIfNeeded(nonInteractiveUiTimeout, interactiveUiTimeout);
        if (nonInteractiveUiTimeout == userState.getUserNonInteractiveUiTimeoutLocked()) goto L5;
    L8:
        userState.setUserNonInteractiveUiTimeoutLocked(nonInteractiveUiTimeout);
        userState.setUserInteractiveUiTimeoutLocked(interactiveUiTimeout);
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);
        return true;
    L5:
        if (interactiveUiTimeout != userState.getUserInteractiveUiTimeoutLocked()) goto L8;
        return false;
    }

    private boolean canRequestAndRequestsTouchExplorationLocked(AccessibilityServiceConnection service, AccessibilityUserState userState) {
        if (service.canReceiveEventsLocked() == true) goto L5;
    L21:
        return false;
    L5:
        if (service.mRequestTouchExplorationMode == false) goto L21;
        if (service.getServiceInfo().getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion > 17) goto L18;
        if (userState.mTouchExplorationGrantedServices.contains(service.mComponentName) == false) goto L13;
        return true;
    L13:
        if (this.mEnableTouchExplorationDialog != null) goto L15;
    L16:
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda68(), this, service));
    L20:
        return false;
    L15:
        if (this.mEnableTouchExplorationDialog.isShowing() == true) goto L20;
    L18:
        if ((service.getCapabilities() & 2) == 0) goto L20;
        return true;
    }

    private void updateMagnificationLocked(AccessibilityUserState userState) {
        if (userState.mUserId == this.mCurrentUserId) goto L6;
        return;
    L6:
        if (this.mUiAutomationManager.suppressingAccessibilityServicesLocked() == true) goto L8;
    L11:
        ArrayList<Display> displays = getValidDisplayList();
        if (userState.isMagnificationSingleFingerTripleTapEnabledLocked() == false) goto L14;
    L28:
        int i = 0;
    L30:
        if (i >= displays.size()) goto L33;
        Display display = displays.get(i);
        getMagnificationController().getFullScreenMagnificationController().register(display.getDisplayId());
        i = i + 1;
        goto L30
    L33:
        return;
    L14:
        if (userState.isShortcutMagnificationEnabledLocked() == true) goto L28;
        int i2 = 0;
    L18:
        if (i2 >= displays.size()) goto L27;
        Display display2 = displays.get(i2);
        int displayId = display2.getDisplayId();
        if (userHasListeningMagnificationServicesLocked(userState, displayId) == false) goto L23;
        getMagnificationController().getFullScreenMagnificationController().register(displayId);
    L25:
        i2 = i2 + 1;
        goto L18
    L23:
        if (this.mMagnificationController.isFullScreenMagnificationControllerInitialized() == false) goto L25;
        getMagnificationController().getFullScreenMagnificationController().unregister(displayId);
        goto L25
    L27:
        return;
    L8:
        if (this.mMagnificationController.isFullScreenMagnificationControllerInitialized() == false) goto L11;
        getMagnificationController().getFullScreenMagnificationController().unregisterAll();
    }

    private void updateMagnificationConnectionIfNeeded(AccessibilityUserState userState) {
        if (this.mMagnificationController.supportWindowMagnification() == true) goto L6;
        return;
    L6:
        if (this.mUmi.isVisibleBackgroundFullUser(userState.mUserId) == false) goto L8;
        return;
    L8:
        boolean connect = true;
        if (userState.isShortcutMagnificationEnabledLocked() == false) goto L11;
    L13:
        boolean shortcutEnabled = true;
    L15:
        if (shortcutEnabled == false) goto L17;
    L20:
        getMagnificationConnectionManager().requestConnection(connect);
        return;
    L17:
        if (userHasMagnificationServicesLocked(userState) == true) goto L20;
        connect = false;
        goto L20
    L11:
        if (userState.isMagnificationSingleFingerTripleTapEnabledLocked() == true) goto L13;
        shortcutEnabled = false;
        goto L15
    }

    private boolean userHasMagnificationServicesLocked(AccessibilityUserState userState) {
        List<AccessibilityServiceConnection> services = userState.mBoundServices;
        int i = 0;
        int count = services.size();
    L3:
        if (i >= count) goto L9;
        AccessibilityServiceConnection service = services.get(i);
        if (this.mSecurityPolicy.canControlMagnification(service) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean userHasListeningMagnificationServicesLocked(AccessibilityUserState userState, int displayId) {
        List<AccessibilityServiceConnection> services = userState.mBoundServices;
        int i = 0;
        int count = services.size();
    L3:
        if (i >= count) goto L11;
        AccessibilityServiceConnection service = services.get(i);
        if (this.mSecurityPolicy.canControlMagnification(service) == false) goto L10;
        if (service.isMagnificationCallbackEnabled(displayId) == false) goto L10;
        return true;
    L10:
        i = i + 1;
        goto L3
    L11:
        return false;
    }

    private void updateFingerprintGestureHandling(AccessibilityUserState userState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AccessibilityServiceConnection> services = userState.mBoundServices;     // Catch: Throwable -> L17
        if (this.mFingerprintGestureDispatcher == null) goto L7;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (this.mFingerprintGestureDispatcher == null) goto L37;
        this.mFingerprintGestureDispatcher.updateClientList(services);
        return;
    L37:
        return;
    L7:
        if (this.mPackageManager.hasSystemFeature("android.hardware.fingerprint") == false) goto L23;
        int numServices = services.size();     // Catch: Throwable -> L17
        int i = 0;
    L9:
        if (i >= numServices) goto L23;
        if (services.get(i).isCapturingFingerprintGestures() == false) goto L22;
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
        IFingerprintService service = IFingerprintService.Stub.asInterface(ServiceManager.getService("fingerprint"));     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L17
        if (service == null) goto L22;
        this.mFingerprintGestureDispatcher = new FingerprintGestureDispatcher(service, this.mContext.getResources(), this.mLock);     // Catch: Throwable -> L17
        goto L23
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L22:
        i = i + 1;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private void updateAccessibilityShortcutTargetsLocked(final AccessibilityUserState userState, int shortcutType) {
        if (shortcutType != 1) goto L10;
        int i = userState.mBoundServices.size() - 1;
    L5:
        if (i < 0) goto L10;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);
        if (service.mRequestAccessibilityButton == false) goto L9;
        service.notifyAccessibilityButtonAvailabilityChangedLocked(service.isAccessibilityButtonAvailableLocked(userState));
    L9:
        i = i - 1;
    L10:
        ArraySet<String> r0 = userState.getShortcutTargetsLocked(shortcutType);
        r0.removeIf(new AccessibilityManagerService$$ExternalSyntheticLambda59(userState));
        if (shortcutType != 16) goto L22;
        Set<ComponentName> enabledServices = userState.getEnabledServicesLocked();
        Map<ComponentName, ComponentName> a11yFeatureToTileService = userState.getA11yFeatureToTileService();
        Set<ComponentName> currentA11yTilesInQsPanel = userState.getA11yQsTilesInQsPanel();
        Iterator<ComponentName> r4 = enabledServices.iterator();
    L14:
        if (r4.hasNext() == false) goto L22;
        ComponentName enabledService = r4.next();
        ComponentName tileService = a11yFeatureToTileService.getOrDefault(enabledService, null);
        if (tileService == null) goto L14;
        if (currentA11yTilesInQsPanel.contains(tileService) == false) goto L14;
        r0.add(enabledService.flattenToString());
    L22:
        if (userState.updateShortcutTargetsLocked(r0, shortcutType) == true) goto L24;
        return;
    L24:
        persistColonDelimitedSetToSettingLocked(ShortcutUtils.convertToKey(shortcutType), userState.mUserId, r0, new AccessibilityManagerService$$ExternalSyntheticLambda60());
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);
    }

    private static /* synthetic */ boolean lambda$updateAccessibilityShortcutTargetsLocked$29(AccessibilityUserState userState, String name) {
        return !userState.isShortcutTargetInstalledLocked(name);
    }

    private static /* synthetic */ String lambda$updateAccessibilityShortcutTargetsLocked$30(String str) {
        return str;
    }

    private void updateShortcutTargetSets(AccessibilityUserState userState, Set<Pair<Set<String>, Integer>> targetSets) {
        boolean somethingChanged = false;
        Iterator<Pair<Set<String>, Integer>> r1 = targetSets.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Pair<Set<String>, Integer> pair = r1.next();
        Set<String> targets = (Set) pair.first;
        int type = ((Integer) pair.second).intValue();
        if (userState.updateShortcutTargetsLocked(targets, type) == false) goto L4;
        somethingChanged = true;
        persistColonDelimitedSetToSettingLocked(ShortcutUtils.convertToKey(type), userState.mUserId, targets, new AccessibilityManagerService$$ExternalSyntheticLambda69());
        goto L4
    L9:
        if (somethingChanged == false) goto L17;
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);
        return;
    }

    private static /* synthetic */ String lambda$updateShortcutTargetSets$31(String str) {
        return str;
    }

    private void migrateAccessibilityButtonSettingsIfNecessaryLocked(final AccessibilityUserState userState, final String packageName, int restoreFromSdkInt) {
        if (restoreFromSdkInt <= 29) goto L5;
        return;
    L5:
        final ArraySet<String> r5 = userState.getShortcutTargetsLocked(1);
        r5.removeIf(new AccessibilityManagerService$$ExternalSyntheticLambda4(packageName, userState));
        final Set<String> shortcutKeyTargets = userState.getShortcutTargetsLocked(2);
        final Set<String> qsShortcutTargets = userState.getShortcutTargetsLocked(16);
        final Set<String> shortcutTargets = userState.getShortcutTargetsLocked(127);
        userState.mEnabledServices.forEach(new AccessibilityManagerService$$ExternalSyntheticLambda5(packageName, userState, shortcutTargets, r5, shortcutKeyTargets, qsShortcutTargets));
        if (userState.updateShortcutTargetsLocked(r5, 1) == true) goto L8;
        return;
    L8:
        persistColonDelimitedSetToSettingLocked("accessibility_button_targets", userState.mUserId, r5, new AccessibilityManagerService$$ExternalSyntheticLambda6());
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);
    }

    private static /* synthetic */ boolean lambda$migrateAccessibilityButtonSettingsIfNecessaryLocked$32(String packageName, AccessibilityUserState userState, String name) {
        if (packageName == null) goto L8;
        if (name == null) goto L8;
        if (name.contains(packageName) == true) goto L8;
        return false;
    L8:
        ComponentName componentName = ComponentName.unflattenFromString(name);
        if (componentName != null) goto L11;
        return false;
    L11:
        AccessibilityServiceInfo serviceInfo = userState.getInstalledServiceInfoLocked(componentName);
        if (serviceInfo != null) goto L15;
        return false;
    L15:
        if (serviceInfo.getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion > 29) goto L19;
        Slog.v(LOG_TAG, "Legacy service " + componentName + " should not in the button");
        return true;
    L19:
        if ((serviceInfo.flags & 256) == 0) goto L21;
        boolean requestA11yButton = true;
    L22:
        if (requestA11yButton == true) goto L24;
    L27:
        return false;
    L24:
        if (userState.mEnabledServices.contains(componentName) == true) goto L27;
        Slog.v(LOG_TAG, "Service requesting a11y button and be assigned to the button" + componentName + " should be enabled state");
        return true;
    L21:
        requestA11yButton = false;
        goto L22
    }

    private static /* synthetic */ void lambda$migrateAccessibilityButtonSettingsIfNecessaryLocked$33(String packageName, AccessibilityUserState userState, Set shortcutTargets, Set buttonTargets, Set shortcutKeyTargets, Set qsShortcutTargets, ComponentName componentName) {
        if (packageName == null) goto L7;
        if (componentName == null) goto L7;
        if (packageName.equals(componentName.getPackageName()) == true) goto L7;
        return;
    L7:
        AccessibilityServiceInfo serviceInfo = userState.getInstalledServiceInfoLocked(componentName);
        if (serviceInfo != null) goto L11;
        return;
    L11:
        if ((serviceInfo.flags & 256) == 0) goto L13;
        boolean requestA11yButton = true;
    L15:
        if (serviceInfo.getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion <= 29) goto L26;
        if (requestA11yButton == false) goto L27;
        String serviceName = componentName.flattenToString();
        if (TextUtils.isEmpty(serviceName) == false) goto L22;
        return;
    L22:
        if (AccessibilityUserState.doesShortcutTargetsStringContain(shortcutTargets, serviceName) == false) goto L24;
        return;
    L24:
        Slog.v(LOG_TAG, "A enabled service requesting a11y button " + componentName + " should be assign to the button or shortcut.");
        buttonTargets.add(serviceName);
        return;
    L27:
        return;
    L26:
        return;
    L13:
        requestA11yButton = false;
        goto L15
    }

    private static /* synthetic */ String lambda$migrateAccessibilityButtonSettingsIfNecessaryLocked$34(String str) {
        return str;
    }

    private void removeShortcutTargetForUnboundServiceLocked(AccessibilityUserState userState, AccessibilityServiceConnection service) {
        if (service.mRequestAccessibilityButton == true) goto L5;
        return;
    L5:
        if (service.getServiceInfo().getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion <= 29) goto L34;
        List<Integer> shortcutTypes = new ArrayList(4);
        shortcutTypes.add(2);
        shortcutTypes.add(1);
        shortcutTypes.add(16);
        shortcutTypes.add(32);
        shortcutTypes.add(64);
        ComponentName serviceName = service.getComponentName();
        Iterator<Integer> r3 = shortcutTypes.iterator();
    L9:
        if (r3.hasNext() == false) goto L21;
        Integer shortcutType = r3.next();
        String shortcutSettingName = ShortcutUtils.convertToKey(shortcutType.intValue());
        if (userState.removeShortcutTargetLocked(shortcutType.intValue(), serviceName) == false) goto L9;
        ArraySet<String> r6 = userState.getShortcutTargetsLocked(shortcutType.intValue());
        persistColonDelimitedSetToSettingLocked(shortcutSettingName, userState.mUserId, r6, new AccessibilityManagerService$$ExternalSyntheticLambda10());
        if (shortcutType.intValue() != 16) goto L9;
        ComponentName tileService = userState.getA11yFeatureToTileService().getOrDefault(serviceName, null);
        StatusBarManagerInternal statusBarManagerInternal = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        if (statusBarManagerInternal == null) goto L9;
        if (tileService == null) goto L9;
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda11(), statusBarManagerInternal, tileService));
        goto L9
    L21:
        return;
    }

    private static /* synthetic */ String lambda$removeShortcutTargetForUnboundServiceLocked$35(String str) {
        return str;
    }

    private void updateRecommendedUiTimeoutLocked(AccessibilityUserState userState) {
        int newNonInteractiveUiTimeout = userState.getUserNonInteractiveUiTimeoutLocked();
        int newInteractiveUiTimeout = userState.getUserInteractiveUiTimeoutLocked();
        if (newNonInteractiveUiTimeout == 0) goto L5;
        if (newInteractiveUiTimeout == 0) goto L5;
    L20:
        userState.setNonInteractiveUiTimeoutLocked(newNonInteractiveUiTimeout);
        userState.setInteractiveUiTimeoutLocked(newInteractiveUiTimeout);
        return;
    L5:
        int serviceNonInteractiveUiTimeout = 0;
        int serviceInteractiveUiTimeout = 0;
        List<AccessibilityServiceConnection> services = userState.mBoundServices;
        int i = 0;
    L7:
        if (i >= services.size()) goto L16;
        int timeout = services.get(i).getServiceInfo().getInteractiveUiTimeoutMillis();
        if (serviceInteractiveUiTimeout >= timeout) goto L11;
        serviceInteractiveUiTimeout = timeout;
    L11:
        int timeout2 = services.get(i).getServiceInfo().getNonInteractiveUiTimeoutMillis();
        if (serviceNonInteractiveUiTimeout >= timeout2) goto L14;
        serviceNonInteractiveUiTimeout = timeout2;
    L14:
        i = i + 1;
        goto L7
    L16:
        if (newNonInteractiveUiTimeout != 0) goto L18;
        newNonInteractiveUiTimeout = serviceNonInteractiveUiTimeout;
    L18:
        if (newInteractiveUiTimeout != 0) goto L20;
        newInteractiveUiTimeout = serviceInteractiveUiTimeout;
        goto L20
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public KeyEventDispatcher getKeyEventDispatcher() {
        if (this.mKeyEventDispatcher != null) goto L6;
        this.mKeyEventDispatcher = new KeyEventDispatcher(this.mMainHandler, 8, this.mLock, this.mPowerManager);
    L6:
        return this.mKeyEventDispatcher;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public PendingIntent getPendingIntentActivity(Context context, int requestCode, Intent intent, int flags) {
        return PendingIntent.getActivity(context, requestCode, intent, flags);
    }

    public void performAccessibilityShortcut(int displayId, int shortcutType, String targetName) {
        performAccessibilityShortcut_enforcePermission();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.performAccessibilityShortcut", 4, "targetName=" + targetName);
    L5:
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda63(), this, Integer.valueOf(displayId), Integer.valueOf(shortcutType), targetName));
    }

    private void performAccessibilityShortcutInternal(int displayId, int shortcutType, String targetName) {
        List<String> shortcutTargets = getAccessibilityShortcutTargetsInternal(shortcutType);
        if (shortcutTargets.isEmpty() == false) goto L7;
        Slog.d(LOG_TAG, "No target to perform shortcut, shortcutType=" + shortcutType);
        return;
    L7:
        if (targetName == null) goto L12;
        if (AccessibilityUserState.doesShortcutTargetsStringContain(shortcutTargets, targetName) == true) goto L12;
        Slog.v(LOG_TAG, "Perform shortcut failed, invalid target name:" + targetName);
        targetName = null;
    L12:
        if (targetName != null) goto L19;
        if (shortcutTargets.size() <= 1) goto L17;
        showAccessibilityTargetsSelection(displayId, shortcutType, getCurrentUserState().mUserId);
        return;
    L17:
        targetName = shortcutTargets.get(0);
    L19:
        if (targetName.equals("com.android.server.accessibility.MagnificationController") == false) goto L22;
        boolean enabled = !getMagnificationController().getFullScreenMagnificationController().isActivated(displayId);
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, AccessibilityShortcutController.MAGNIFICATION_COMPONENT_NAME, shortcutType, enabled);
        notifyMagnificationShortcutTriggered(displayId);
        return;
    L22:
        ComponentName targetComponentName = ComponentName.unflattenFromString(targetName);
        if (targetComponentName != null) goto L27;
        Slog.d(LOG_TAG, "Perform shortcut failed, invalid target name:" + targetName);
        return;
    L27:
        if (performAccessibilityFrameworkFeature(displayId, targetComponentName, shortcutType) == false) goto L30;
        return;
    L30:
        if (performAccessibilityShortcutTargetActivity(displayId, targetComponentName) == false) goto L34;
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, targetComponentName, shortcutType);
        return;
    L34:
        if (performAccessibilityShortcutTargetService(displayId, shortcutType, targetComponentName) == false) goto L36;
        return;
    }

    private boolean performAccessibilityFrameworkFeature(int displayId, ComponentName assignedTarget, int shortcutType) {
        Map<ComponentName, AccessibilityShortcutController.FrameworkFeatureInfo> frameworkFeatureMap = AccessibilityShortcutController.getFrameworkShortcutFeaturesMap();
        if (frameworkFeatureMap.containsKey(assignedTarget) == true) goto L5;
        return false;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int userId = this.mCurrentUserId;     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        AccessibilityShortcutController.FrameworkFeatureInfo r2 = frameworkFeatureMap.get(assignedTarget);
        SettingsStringUtil.SettingStringHelper setting = new SettingsStringUtil.SettingStringHelper(this.mContext.getContentResolver(), r2.getSettingKey(), this.mCurrentUserId);
        if ((r2 instanceof AccessibilityShortcutController.LaunchableFrameworkFeatureInfo) == false) goto L14;
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, assignedTarget, shortcutType, true);
        launchAccessibilityFrameworkFeature(displayId, assignedTarget);
        return true;
    L14:
        if ((r2 instanceof AccessibilityShortcutController.ExtraDimFrameworkFeatureInfo) == false) goto L18;
        boolean serviceEnabled = ((AccessibilityShortcutController.ExtraDimFrameworkFeatureInfo) r2).activateShortcut(this.mContext, userId);
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, assignedTarget, shortcutType, serviceEnabled);
        return true;
    L18:
        if (TextUtils.equals(r2.getSettingOnValue(), setting.read()) == true) goto L20;
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, assignedTarget, shortcutType, true);
        setting.write(r2.getSettingOnValue());
    L21:
        return true;
    L20:
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, assignedTarget, shortcutType, false);
        setting.write(r2.getSettingOffValue());
    L22:
        th = move-exception;
        throw th;
    }

    private boolean performAccessibilityShortcutTargetActivity(int displayId, ComponentName assignedTarget) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L14
        int i = 0;
    L6:
        if (i >= userState.mInstalledShortcuts.size()) goto L17;
        AccessibilityShortcutInfo shortcutInfo = userState.mInstalledShortcuts.get(i);     // Catch: Throwable -> L14
        if (shortcutInfo.getComponentName().equals(assignedTarget) == true) goto L10;
        i = i + 1;     // Catch: Throwable -> L14
        goto L6
    L10:
        launchShortcutTargetActivity(displayId, assignedTarget);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    private boolean performAccessibilityShortcutTargetService(int displayId, int shortcutType, ComponentName assignedTarget) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L9
        AccessibilityServiceInfo installedServiceInfo = userState.getInstalledServiceInfoLocked(assignedTarget);     // Catch: Throwable -> L9
        if (installedServiceInfo != null) goto L11;
        Slog.d(LOG_TAG, "Perform shortcut failed, invalid component name:" + assignedTarget);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        AccessibilityServiceConnection serviceConnection = userState.getServiceConnectionLocked(assignedTarget);     // Catch: Throwable -> L9
        int targetSdk = installedServiceInfo.getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion;     // Catch: Throwable -> L9
        if ((installedServiceInfo.flags & 256) == 0) goto L14;
        boolean requestA11yButton = true;
    L16:
        if (targetSdk > 29) goto L18;
        if (shortcutType != 2) goto L18;
    L20:
        if (serviceConnection != null) goto L22;
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, assignedTarget, shortcutType, true);     // Catch: Throwable -> L9
        enableAccessibilityServiceLocked(assignedTarget, this.mCurrentUserId);     // Catch: Throwable -> L9
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L22:
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, assignedTarget, shortcutType, false);     // Catch: Throwable -> L9
        disableAccessibilityServiceLocked(assignedTarget, this.mCurrentUserId);     // Catch: Throwable -> L9
    L18:
        if (targetSdk <= 29) goto L25;
        if (requestA11yButton == false) goto L20;
    L25:
        if (shortcutType != 2) goto L33;
        if (targetSdk <= 29) goto L33;
        if (requestA11yButton == false) goto L33;
        if (userState.getEnabledServicesLocked().contains(assignedTarget) == true) goto L33;
        enableAccessibilityServiceLocked(assignedTarget, this.mCurrentUserId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L33:
        if (serviceConnection != null) goto L35;
    L42:
        Slog.d(LOG_TAG, "Perform shortcut failed, service is not ready:" + assignedTarget);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L35:
        if (userState.mBoundServices.contains(serviceConnection) == false) goto L42;
        if (serviceConnection.mRequestAccessibilityButton == false) goto L42;
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, assignedTarget, shortcutType, true);     // Catch: Throwable -> L9
        serviceConnection.notifyAccessibilityButtonClickedLocked(displayId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L14:
        requestA11yButton = false;
    L9:
        th = move-exception;
        throw th;
    }

    private void launchAccessibilityFrameworkFeature(int displayId, ComponentName assignedTarget) {
        if (assignedTarget.equals(AccessibilityShortcutController.ACCESSIBILITY_HEARING_AIDS_COMPONENT_NAME) == false) goto L6;
        launchHearingDevicesDialog();
        return;
    }

    public void enableShortcutsForTargets(boolean enable, int shortcutTypes, List<String> shortcutTargets, int userId) {
        enableShortcutsForTargets_enforcePermission();
        int[] r0 = ShortcutConstants.USER_SHORTCUT_TYPES;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int shortcutType = r0[r2];
        if ((shortcutTypes & shortcutType) != shortcutType) goto L7;
        enableShortcutForTargets(enable, shortcutType, shortcutTargets, userId);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private void enableShortcutForTargets(boolean r16, int r17, List<String> r18, int r19) {
        Slog.d(LOG_TAG, String.format("enableShortcutForTargets: enable %s, shortcutType: %s, shortcutTargets: %s, userId: %s", new Object[]{Boolean.valueOf(r16), Integer.valueOf(r17), r18, Integer.valueOf(r19)}));
        if (r17 == 32) goto L5;
    L5:
        if (r17 != 64) goto L8;
        Slog.w(LOG_TAG, "KEY_GESTURE type shortcuts are disabled by feature flag");
        return;
    L8:
        String r5 = ShortcutUtils.convertToKey(r17);
        if (r17 != 4) goto L11;
    L56:
        Iterator<String> r0 = r18.iterator();
    L58:
        if (r0.hasNext() == false) goto L64;
        String r7 = r0.next();
        if ("com.android.server.accessibility.MagnificationController".equals(r7) == true) goto L61;
        Slog.w(LOG_TAG, "Triple tap or two-fingers double-tap is not supported for " + r7);
        goto L58
    L61:
        persistIntToSetting(r19, r5, r16 ? 1 : 0);
        goto L58
    L64:
        return;
    L11:
        if (r17 == 8) goto L56;
        final Map<ComponentName, ComponentName> r10 = getA11yFeatureToTileMapInternal(r19);
        Object r11 = this.mLock;
        monitor-enter(r11);
        AccessibilityUserState r1 = getUserStateLocked(r19);     // Catch: Throwable -> L18
        Set r4 = ShortcutUtils.getShortcutTargetsFromSettings(this.mContext, r17, r19);     // Catch: Throwable -> L18
        ArraySet r6 = new ArraySet(r4);     // Catch: Throwable -> L18
        if (r16 == false) goto L20;
        r6.addAll(r18);     // Catch: Throwable -> L18
    L22:
        if (r17 != 16) goto L24;
        Set<String> r8 = (Set) r6.stream().filter(new AccessibilityManagerService$$ExternalSyntheticLambda23(r10)).collect(Collectors.toUnmodifiableSet());     // Catch: Throwable -> L18
    L26:
        if (r4.equals(r8) == false) goto L30;
        Slog.d(LOG_TAG, String.format("shortcutTargets are the same: skip modifying: target: %s, shortcutType: %s", new Object[]{r8, Integer.valueOf(r17)}));     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        return;
    L30:
        persistColonDelimitedSetToSettingLocked(r5, r19, r8, new AccessibilityManagerService$$ExternalSyntheticLambda24(), "");     // Catch: Throwable -> L18
        if (r17 != 16) goto L33;
        logMetricForQsShortcutConfiguration(r16, Math.abs(r4.size() - r8.size()));     // Catch: Throwable -> L18
        r1.updateShortcutTargetsLocked(r8, 16);     // Catch: Throwable -> L18
        scheduleNotifyClientsOfServicesStateChangeLocked(r1);     // Catch: Throwable -> L18
        onUserStateChangedLocked(r1);     // Catch: Throwable -> L18
    L33:
        monitor-exit(r11);     // Catch: Throwable -> L18
        long r9 = Binder.clearCallingIdentity();
        ShortcutUtils.updateInvisibleToggleAccessibilityServiceEnableState(this.mContext, new ArraySet(r18), r19);     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(r9);
        if (r17 != 16) goto L39;
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda25(), this, r8, r4, Integer.valueOf(r19)));
    L39:
        if (r16 == true) goto L42;
        return;
    L42:
        if (r17 != 2) goto L44;
        skipVolumeShortcutDialogTimeoutRestriction(r19);
        persistIntToSetting(r19, "accessibility_shortcut_dialog_shown", 1);
        return;
    L44:
        if (r17 == 1) goto L46;
        return;
    L46:
        if (r18.contains("com.android.server.accessibility.MagnificationController") == true) goto L48;
        return;
    L48:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_floating_menu_size", -1, r19) != (-1)) goto L77;
        persistIntToSetting(r19, "accessibility_floating_menu_size", 1);
        return;
    L77:
        return;
    L51:
        th = move-exception;
        Binder.restoreCallingIdentity(r9);
        throw th;
    L24:
        r8 = r6;
        goto L26
    L20:
        r6.removeAll(r18);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$enableShortcutForTargets$36(Map featureToTileMap, String target) {
        ComponentName targetComponent = ComponentName.unflattenFromString(target);
        return featureToTileMap.containsKey(targetComponent);
    }

    private static /* synthetic */ String lambda$enableShortcutForTargets$37(String str) {
        return str;
    }

    private void updateA11yTileServicesInQuickSettingsPanel(final Set<String> newQsTargets, final Set<String> currentQsTargets, int userId) {
        Slog.d(LOG_TAG, String.format("updateA11yTileServicesInQuickSettingsPanel: newQsTargets: %s , currentQsTargets: %s, userId: %s", new Object[]{newQsTargets, currentQsTargets, Integer.valueOf(userId)}));
        final StatusBarManagerInternal statusBarManagerInternal = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        if (statusBarManagerInternal != null) goto L5;
        return;
    L5:
        final Map<ComponentName, ComponentName> a11yFeatureToTileMap = getA11yFeatureToTileMapInternal(userId);
        final Set<String> targetWithNoTile = new ArraySet();
        newQsTargets.stream().filter(new AccessibilityManagerService$$ExternalSyntheticLambda14(currentQsTargets)).forEach(new AccessibilityManagerService$$ExternalSyntheticLambda15(a11yFeatureToTileMap, targetWithNoTile, statusBarManagerInternal));
        currentQsTargets.stream().filter(new AccessibilityManagerService$$ExternalSyntheticLambda16(newQsTargets)).forEach(new AccessibilityManagerService$$ExternalSyntheticLambda17(a11yFeatureToTileMap, targetWithNoTile, statusBarManagerInternal));
        if (targetWithNoTile.isEmpty() == true) goto L9;
        Slog.e(LOG_TAG, "Unable to add/remove Tiles for a11y features: " + targetWithNoTile + "as the Tiles aren't provided");
        return;
    }

    private static /* synthetic */ boolean lambda$updateA11yTileServicesInQuickSettingsPanel$38(Set currentQsTargets, String target) {
        return !currentQsTargets.contains(target);
    }

    private static /* synthetic */ void lambda$updateA11yTileServicesInQuickSettingsPanel$39(Map a11yFeatureToTileMap, Set targetWithNoTile, StatusBarManagerInternal statusBarManagerInternal, String target) {
        ComponentName targetComponent = ComponentName.unflattenFromString(target);
        if (targetComponent != null) goto L5;
    L12:
        targetWithNoTile.add(target);
        return;
    L5:
        if (a11yFeatureToTileMap.containsKey(targetComponent) == false) goto L12;
        if (ShortcutConstants.A11Y_FEATURE_TO_FRAMEWORK_TILE.containsKey(targetComponent) == false) goto L10;
        return;
    L10:
        statusBarManagerInternal.addQsTileToFrontOrEnd((ComponentName) a11yFeatureToTileMap.get(targetComponent), true);
    }

    private static /* synthetic */ boolean lambda$updateA11yTileServicesInQuickSettingsPanel$40(Set newQsTargets, String target) {
        return !newQsTargets.contains(target);
    }

    private static /* synthetic */ void lambda$updateA11yTileServicesInQuickSettingsPanel$41(Map a11yFeatureToTileMap, Set targetWithNoTile, StatusBarManagerInternal statusBarManagerInternal, String target) {
        ComponentName targetComponent = ComponentName.unflattenFromString(target);
        if (targetComponent != null) goto L5;
    L12:
        targetWithNoTile.add(target);
        return;
    L5:
        if (a11yFeatureToTileMap.containsKey(targetComponent) == false) goto L12;
        if (ShortcutConstants.A11Y_FEATURE_TO_FRAMEWORK_TILE.containsKey(targetComponent) == false) goto L10;
        return;
    L10:
        statusBarManagerInternal.removeQsTile((ComponentName) a11yFeatureToTileMap.get(targetComponent));
    }

    public Bundle getA11yFeatureToTileMap(int userId) {
        getA11yFeatureToTileMap_enforcePermission();
        Bundle bundle = new Bundle();
        Map<ComponentName, ComponentName> a11yFeatureToTile = getA11yFeatureToTileMapInternal(userId);
        Iterator<Map.Entry<ComponentName, ComponentName>> r2 = a11yFeatureToTile.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<ComponentName, ComponentName> entry = r2.next();
        bundle.putParcelable(entry.getKey().flattenToString(), entry.getValue());
        goto L4
    L6:
        return bundle;
    }

    private Map<ComponentName, ComponentName> getA11yFeatureToTileMapInternal(int userId) {
        Map<ComponentName, ComponentName> a11yFeatureToTile = new ArrayMap();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int resolvedUserId = this.mSecurityPolicy.resolveCallingUserIdEnforcingPermissionsLocked(userId);     // Catch: Throwable -> L21
        AccessibilityUserState userState = getUserStateLocked(resolvedUserId);     // Catch: Throwable -> L21
        Map<ComponentName, ComponentName> a11yFeatureToTileService = userState.getA11yFeatureToTileService();     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        if (Binder.getCallingPid() == OWN_PROCESS_ID) goto L9;
        boolean shouldFilterAppAccess = true;
    L10:
        int callingUid = Binder.getCallingUid();
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        Iterator<Map.Entry<ComponentName, ComponentName>> r6 = a11yFeatureToTileService.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L19;
        Map.Entry<ComponentName, ComponentName> entry = r6.next();
        if (shouldFilterAppAccess == false) goto L18;
        if (pm.filterAppAccess(entry.getKey().getPackageName(), callingUid, resolvedUserId) == true) goto L12;
    L18:
        a11yFeatureToTile.put(entry.getKey(), entry.getValue());
        goto L12
    L19:
        a11yFeatureToTile.putAll(ShortcutConstants.A11Y_FEATURE_TO_FRAMEWORK_TILE);
        return a11yFeatureToTile;
    L9:
        shouldFilterAppAccess = false;
    L21:
        th = move-exception;
        throw th;
    }

    public List<String> getAccessibilityShortcutTargets(int shortcutType) {
        getAccessibilityShortcutTargets_enforcePermission();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L6;
        this.mTraceManager.logTrace("AccessibilityManagerService.getAccessibilityShortcutTargets", 4, "shortcutType=" + shortcutType);
    L6:
        return getAccessibilityShortcutTargetsInternal(shortcutType);
    }

    private List<String> getAccessibilityShortcutTargetsInternal(int shortcutType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L8
        ArrayList<String> shortcutTargets = new ArrayList(userState.getShortcutTargetsLocked(shortcutType));     // Catch: Throwable -> L8
        if (shortcutType == 1) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return shortcutTargets;
    L10:
        int i = userState.mBoundServices.size() - 1;     // Catch: Throwable -> L8
    L11:
        if (i < 0) goto L21;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);     // Catch: Throwable -> L8
        if (service.mRequestAccessibilityButton == false) goto L20;
        if (service.getServiceInfo().getResolveInfo().serviceInfo.applicationInfo.targetSdkVersion > 29) goto L20;
        String serviceName = service.getComponentName().flattenToString();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(serviceName) == true) goto L20;
        shortcutTargets.add(serviceName);     // Catch: Throwable -> L8
    L20:
        i = i - 1;     // Catch: Throwable -> L8
        goto L11
    L21:
        userState.updateShortcutTargetsLocked(Set.copyOf(shortcutTargets), shortcutType);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return shortcutTargets;
    L8:
        th = move-exception;
        throw th;
    }

    private void enableAccessibilityServiceLocked(ComponentName componentName, int userId) {
        this.mTempComponentNameSet.clear();
        readComponentNamesFromSettingLocked("enabled_accessibility_services", userId, this.mTempComponentNameSet);
        this.mTempComponentNameSet.add(componentName);
        persistComponentNamesToSettingLocked("enabled_accessibility_services", this.mTempComponentNameSet, userId);
        AccessibilityUserState userState = getUserStateLocked(userId);
        if (userState.mEnabledServices.add(componentName) == false) goto L6;
        onUserStateChangedLocked(userState);
        return;
    }

    private void disableAccessibilityServiceLocked(ComponentName componentName, int userId) {
        this.mTempComponentNameSet.clear();
        readComponentNamesFromSettingLocked("enabled_accessibility_services", userId, this.mTempComponentNameSet);
        this.mTempComponentNameSet.remove(componentName);
        persistComponentNamesToSettingLocked("enabled_accessibility_services", this.mTempComponentNameSet, userId);
        AccessibilityUserState userState = getUserStateLocked(userId);
        if (userState.mEnabledServices.remove(componentName) == false) goto L6;
        onUserStateChangedLocked(userState);
        return;
    }

    @Override // com.android.server.accessibility.AccessibilityWindowManager.AccessibilityEventSender
    public void sendAccessibilityEventForCurrentUserLocked(AccessibilityEvent event) {
        if (event.getWindowChanges() != 1) goto L5;
        sendPendingWindowStateChangedEventsForAvailableWindowLocked(event.getWindowId());
    L5:
        sendAccessibilityEventLocked(event, this.mCurrentUserId);
    }

    private void sendAccessibilityEventLocked(AccessibilityEvent event, int userId) {
        event.setEventTime(SystemClock.uptimeMillis());
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda30(), this, event, Integer.valueOf(userId)));
    }

    public boolean sendFingerprintGesture(int gestureKeyCode) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(131076) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.sendFingerprintGesture", 131076, "gestureKeyCode=" + gestureKeyCode);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (this.mFingerprintGestureDispatcher != null) goto L15;
        return false;
    L15:
        return this.mFingerprintGestureDispatcher.onFingerprintGesture(gestureKeyCode);
    L19:
        throw new SecurityException("Only SYSTEM can call sendFingerprintGesture");     // Catch: Throwable -> L16
    }

    public int getAccessibilityWindowId(IBinder windowToken) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.getAccessibilityWindowId", 4, "windowToken=" + windowToken);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L15;
        int r1 = this.mA11yWindowManager.findWindowIdLocked(this.mCurrentUserId, windowToken);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L15:
        throw new SecurityException("Only SYSTEM can call getAccessibilityWindowId");     // Catch: Throwable -> L12
    }

    public long getRecommendedTimeoutMillis() {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.getRecommendedTimeoutMillis", 4);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = this.mProxyManager.getFirstDeviceIdForUidLocked(Binder.getCallingUid());     // Catch: Throwable -> L12
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L14;
        long r2 = this.mProxyManager.getRecommendedTimeoutMillisLocked(deviceId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L12
        long r3 = getRecommendedTimeoutMillisLocked(userState);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    private long getRecommendedTimeoutMillisLocked(AccessibilityUserState userState) {
        return IntPair.of(userState.getInteractiveUiTimeoutLocked(), userState.getNonInteractiveUiTimeoutLocked());
    }

    public void setMagnificationConnection(IMagnificationConnection connection) throws RemoteException {
        setMagnificationConnection_enforcePermission();
        if (this.mTraceManager.isA11yTracingEnabledForTypes(132) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.setMagnificationConnection", 132, "connection=" + connection);
    L5:
        getMagnificationConnectionManager().setConnection(connection);
        if (connection == null) goto L8;
        return;
    L8:
        if (this.mMagnificationController.isFullScreenMagnificationControllerInitialized() == false) goto L15;
        ArrayList<Display> displays = getValidDisplayList();
        int i = 0;
    L11:
        if (i >= displays.size()) goto L16;
        Display display = displays.get(i);
        getMagnificationController().getFullScreenMagnificationController().reset(display.getDisplayId(), false);
        i = i + 1;
        goto L11
    L16:
        return;
    }

    public MagnificationConnectionManager getMagnificationConnectionManager() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MagnificationConnectionManager r1 = this.mMagnificationController.getMagnificationConnectionManager();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    MagnificationController getMagnificationController() {
        return this.mMagnificationController;
    }

    public void associateEmbeddedHierarchy(IBinder host, IBinder embedded) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.associateEmbeddedHierarchy", 4, "host=" + host + ";embedded=" + embedded);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mA11yWindowManager.associateEmbeddedHierarchyLocked(host, embedded);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void disassociateEmbeddedHierarchy(IBinder token) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.disassociateEmbeddedHierarchy", 4, "token=" + token);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mA11yWindowManager.disassociateEmbeddedHierarchyLocked(token);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int getFocusStrokeWidth() {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.getFocusStrokeWidth", 4);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = this.mProxyManager.getFirstDeviceIdForUidLocked(Binder.getCallingUid());     // Catch: Throwable -> L12
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L14;
        int r2 = this.mProxyManager.getFocusStrokeWidthLocked(deviceId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L12
        int r3 = userState.getFocusStrokeWidthLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public int getFocusColor() {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.getFocusColor", 4);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = this.mProxyManager.getFirstDeviceIdForUidLocked(Binder.getCallingUid());     // Catch: Throwable -> L12
        if (this.mProxyManager.isProxyedDeviceId(deviceId) == false) goto L14;
        int r2 = this.mProxyManager.getFocusColorLocked(deviceId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L12
        int r3 = userState.getFocusColorLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean isAudioDescriptionByDefaultEnabled() {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.isAudioDescriptionByDefaultEnabled", 4);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L10
        boolean r2 = userState.isAudioDescriptionByDefaultEnabledLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public void setAccessibilityWindowAttributes(int displayId, int windowId, int userId, AccessibilityWindowAttributes attributes) {
        if (this.mTraceManager.isA11yTracingEnabledForTypes(4) == false) goto L5;
        this.mTraceManager.logTrace("AccessibilityManagerService.setAccessibilityWindowAttributes", 4);
    L5:
        this.mA11yWindowManager.setAccessibilityWindowAttributes(displayId, windowId, userId, attributes);
    }

    public void setSystemAudioCaptioningEnabled(boolean isEnabled, int userId) {
        setSystemAudioCaptioningEnabled_enforcePermission();
        this.mCaptioningManagerImpl.setSystemAudioCaptioningEnabled(isEnabled, userId);
    }

    public boolean isSystemAudioCaptioningUiEnabled(int userId) {
        return this.mCaptioningManagerImpl.isSystemAudioCaptioningUiEnabled(userId);
    }

    public void setSystemAudioCaptioningUiEnabled(boolean isEnabled, int userId) {
        setSystemAudioCaptioningUiEnabled_enforcePermission();
        this.mCaptioningManagerImpl.setSystemAudioCaptioningUiEnabled(isEnabled, userId);
    }

    public boolean registerProxyForDisplay(IAccessibilityServiceClient client, int displayId) throws RemoteException {
        registerProxyForDisplay_enforcePermission();
        this.mSecurityPolicy.checkForAccessibilityPermissionOrRole();
        UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
        if (client != null) goto L6;
        return false;
    L6:
        if (displayId < 0) goto L39;
        if (isTrackedDisplay(displayId) == false) goto L37;
        if (this.mProxyManager.isProxyedDisplay(displayId) == true) goto L35;
        if (this.mProxyManager.displayBelongsToCaller(Binder.getCallingUid(), displayId) == false) goto L33;
        long identity = Binder.clearCallingIdentity();
        ProxyManager r3 = this.mProxyManager;     // Catch: Throwable -> L28
        int r6 = sIdCounter;     // Catch: Throwable -> L28
        sIdCounter = r6 + 1;     // Catch: Throwable -> L28
        r3.registerProxy(client, displayId, r6, this.mSecurityPolicy, this, getTraceManager(), this.mWindowManagerService);     // Catch: Throwable -> L26
        Object r12 = this.mLock;     // Catch: Throwable -> L26
        monitor-enter(r12);     // Catch: Throwable -> L26
        notifyClearAccessibilityCacheLocked();     // Catch: Throwable -> L22
        monitor-exit(r12);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(identity);
        return true;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Throwable r13 = th;
    L30:
        Binder.restoreCallingIdentity(identity);
        throw r13;
    L28:
        th = move-exception;
        r13 = th;
        goto L30
    L33:
        throw new SecurityException("The display " + displayId + " does not belong to the caller.");
    L35:
        throw new IllegalArgumentException("The display " + displayId + " is already being proxy-ed");
    L37:
        throw new IllegalArgumentException("The display " + displayId + " does not exist or is not tracked by accessibility.");
    L39:
        throw new IllegalArgumentException("The display id " + displayId + " is invalid.");
    }

    public boolean unregisterProxyForDisplay(int displayId) {
        unregisterProxyForDisplay_enforcePermission();
        this.mSecurityPolicy.checkForAccessibilityPermissionOrRole();
        long identity = Binder.clearCallingIdentity();
        boolean r2 = this.mProxyManager.unregisterProxy(displayId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    boolean isDisplayProxyed(int displayId) {
        return this.mProxyManager.isProxyedDisplay(displayId);
    }

    public boolean startFlashNotificationSequence(String opPkg, int reason, IBinder token) {
        startFlashNotificationSequence_enforcePermission();
        return this.mFlashNotificationsController.startFlashNotificationSequence(opPkg, reason, token);
    }

    public boolean stopFlashNotificationSequence(String opPkg) {
        stopFlashNotificationSequence_enforcePermission();
        return this.mFlashNotificationsController.stopFlashNotificationSequence(opPkg);
    }

    public boolean startFlashNotificationEvent(String opPkg, int reason, String reasonPkg) {
        startFlashNotificationEvent_enforcePermission();
        return this.mFlashNotificationsController.startFlashNotificationEvent(opPkg, reason, reasonPkg);
    }

    public boolean isAccessibilityTargetAllowed(String packageName, int uid, int userId) {
        long identity = Binder.clearCallingIdentity();
        DevicePolicyManager dpm = (DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class);     // Catch: Throwable -> L9
        List<String> permittedServices = dpm.getPermittedAccessibilityServices(userId);     // Catch: Throwable -> L9
        if (permittedServices == null) goto L11;
        if (permittedServices.contains(packageName) == true) goto L11;
        boolean r4 = false;
    L12:
        Binder.restoreCallingIdentity(identity);
        return r4;
    L11:
        r4 = true;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean sendRestrictedDialogIntent(String packageName, int uid, int userId) {
        if (isAccessibilityTargetAllowed(packageName, uid, userId) == false) goto L6;
        return false;
    L6:
        RestrictedLockUtils.EnforcedAdmin admin = RestrictedLockUtilsInternal.checkIfAccessibilityServiceDisallowed(this.mContext, packageName, userId);
        if (admin == null) goto L16;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, admin);
        return true;
    L16:
        Intent settingDialogIntent = ((EnhancedConfirmationManager) this.mContext.getSystemService(EnhancedConfirmationManager.class)).createRestrictedSettingDialogIntent(packageName, "android:bind_accessibility_service");     // Catch: PackageManager.NameNotFoundException -> L13
        this.mContext.startActivity(settingDialogIntent);     // Catch: PackageManager.NameNotFoundException -> L13
    L15:
        return true;
    L13:
        e = move-exception;
        Log.e(LOG_TAG, "Exception when retrieving package:" + packageName, e);
        goto L15
    }

    public boolean isAccessibilityServiceWarningRequired(AccessibilityServiceInfo info) {
        isAccessibilityServiceWarningRequired_enforcePermission();
        if (info != null) goto L6;
        Log.e(LOG_TAG, "Called isAccessibilityServiceWarningRequired with null service info");
        return true;
    L6:
        ComponentName componentName = info.getComponentName();
        Object r2 = this.mLock;
        monitor-enter(r2);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L12
        if (userState.getEnabledServicesLocked().contains(componentName) == false) goto L15;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return false;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L12
        int[] r3 = ShortcutConstants.USER_SHORTCUT_TYPES;
        int r4 = r3.length;
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L23;
        int shortcutType = r3[r5];
        if (getAccessibilityShortcutTargets(shortcutType).contains(componentName.flattenToString()) == true) goto L20;
        r5 = r5 + 1;
        goto L17
    L20:
        return false;
    L23:
        if (isAccessibilityServicePreinstalledAndTrusted(info) == false) goto L25;
        return false;
    L25:
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean isAccessibilityServicePreinstalledAndTrusted(AccessibilityServiceInfo info) {
        ComponentName componentName = info.getComponentName();
        boolean isPreinstalled = info.getResolveInfo().serviceInfo.applicationInfo.isSystemApp();
        if (isPreinstalled == false) goto L8;
        String[] trustedAccessibilityServices = this.mContext.getResources().getStringArray(R.array.device_state_notification_thermal_titles);
        Stream r3 = Arrays.stream(trustedAccessibilityServices).map(new AccessibilityManagerService$$ExternalSyntheticLambda57());
        componentName.getClass();
        if (r3.anyMatch(new AccessibilityManagerService$$ExternalSyntheticLambda58(componentName)) == false) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, LOG_TAG, pw) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("ACCESSIBILITY MANAGER (dumpsys accessibility)");     // Catch: Throwable -> L12
        pw.println();     // Catch: Throwable -> L12
        pw.append("currentUserId=").append(String.valueOf(this.mCurrentUserId));     // Catch: Throwable -> L12
        if (this.mRealCurrentUserId != (-2)) goto L10;
    L14:
        pw.println();     // Catch: Throwable -> L12
        if (this.mVisibleBgUserIds == null) goto L17;
        pw.append("visibleBgUserIds=").append(this.mVisibleBgUserIds.toString());     // Catch: Throwable -> L12
        pw.println();     // Catch: Throwable -> L12
    L17:
        pw.append("hasMagnificationConnection=").append(String.valueOf(getMagnificationConnectionManager().isConnected()));     // Catch: Throwable -> L12
        pw.println();     // Catch: Throwable -> L12
        this.mMagnificationProcessor.dump(pw, getValidDisplayList());     // Catch: Throwable -> L12
        int userCount = this.mUserStates.size();     // Catch: Throwable -> L12
        int i = 0;
    L18:
        if (i >= userCount) goto L21;
        this.mUserStates.valueAt(i).dump(fd, pw, args);     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L18
    L21:
        if (this.mUiAutomationManager.isUiAutomationRunningLocked() == false) goto L23;
        this.mUiAutomationManager.dumpUiAutomationService(fd, pw, args);     // Catch: Throwable -> L12
        pw.println();     // Catch: Throwable -> L12
    L23:
        this.mA11yWindowManager.dump(fd, pw, args);     // Catch: Throwable -> L12
        if (this.mHasInputFilter == true) goto L26;
    L28:
        pw.println("Global client list info:{");     // Catch: Throwable -> L12
        this.mGlobalClients.dump(pw, "    Client list ");     // Catch: Throwable -> L12
        pw.println("    Registered clients:{");     // Catch: Throwable -> L12
        int i2 = 0;
    L30:
        if (i2 >= this.mGlobalClients.getRegisteredCallbackCount()) goto L32;
        Client client = (Client) this.mGlobalClients.getRegisteredCallbackCookie(i2);     // Catch: Throwable -> L12
        pw.append(Arrays.toString(client.mPackageNames));     // Catch: Throwable -> L12
        i2 = i2 + 1;     // Catch: Throwable -> L12
        goto L30
    L32:
        pw.println();     // Catch: Throwable -> L12
        this.mProxyManager.dump(fd, pw, args);     // Catch: Throwable -> L12
        this.mA11yDisplayListener.dump(fd, pw, args);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L26:
        if (this.mInputFilter == null) goto L28;
        this.mInputFilter.dump(fd, pw, args);     // Catch: Throwable -> L12
        goto L28
    L10:
        if (this.mCurrentUserId == this.mRealCurrentUserId) goto L14;
        pw.append(" (set for UiAutomation purposes; \"real\" current user is ").append(String.valueOf(this.mRealCurrentUserId)).append(")");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public MagnificationProcessor getMagnificationProcessor() {
        return this.mMagnificationProcessor;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void onClientChangeLocked(boolean serviceInfoChanged) {
        onClientChangeLocked(serviceInfoChanged, false);
    }

    public void onClientChangeLocked(boolean serviceInfoChanged, boolean forceUpdate) {
        AccessibilityUserState userState = getUserStateLocked(this.mCurrentUserId);
        onUserStateChangedLocked(userState, forceUpdate);
        if (serviceInfoChanged == false) goto L6;
        scheduleNotifyClientsOfServicesStateChangeLocked(userState);
        return;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void onProxyChanged(int deviceId) {
        this.mProxyManager.onProxyChanged(deviceId);
    }

    @Override // com.android.server.accessibility.ProxyManager.SystemSupport
    public void removeDeviceIdLocked(int deviceId) {
        resetClientsLocked(deviceId, getCurrentUserStateLocked().mUserClients);
        resetClientsLocked(deviceId, this.mGlobalClients);
        onClientChangeLocked(true, true);
    }

    private void resetClientsLocked(int deviceId, RemoteCallbackList<IAccessibilityManagerClient> clients) {
        if (clients != null) goto L4;
        return;
    L4:
        if (clients.getRegisteredCallbackCount() == 0) goto L28;
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L23:
    L14:
        th = move-exception;
        throw th;
    L10:
        if (i >= clients.getRegisteredCallbackCount()) goto L18;
        Client appClient = (Client) clients.getRegisteredCallbackCookie(i);     // Catch: Throwable -> L14
        if (appClient.mDeviceId != deviceId) goto L16;
        appClient.mDeviceId = 0;     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L23
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    }

    @Override // com.android.server.accessibility.ProxyManager.SystemSupport
    public void updateWindowsForAccessibilityCallbackLocked() {
        updateWindowsForAccessibilityCallbackLocked(getUserStateLocked(this.mCurrentUserId));
    }

    @Override // com.android.server.accessibility.ProxyManager.SystemSupport
    public RemoteCallbackList<IAccessibilityManagerClient> getGlobalClientsLocked() {
        return this.mGlobalClients;
    }

    @Override // com.android.server.accessibility.ProxyManager.SystemSupport
    public RemoteCallbackList<IAccessibilityManagerClient> getCurrentUserClientsLocked() {
        return getCurrentUserState().mUserClients;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new AccessibilityShellCommand(this.mContext, this, this.mSystemActionPerformer).exec(this, in, out, err, args, callback, resultReceiver);
    }

    public ArrayList<Display> getValidDisplayList() {
        return this.mA11yDisplayListener.getValidDisplayList();
    }

    private boolean isTrackedDisplay(int displayId) {
        ArrayList<Display> displays = getValidDisplayList();
        Iterator<Display> r1 = displays.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Display display = r1.next();
        if (display.getDisplayId() != displayId) goto L4;
        return true;
    L10:
        return false;
    }

    private void updateMagnificationCapabilitiesSettingsChangeLocked(AccessibilityUserState userState) {
        ArrayList<Display> displays = getValidDisplayList();
        int i = 0;
    L4:
        if (i >= displays.size()) goto L9;
        int displayId = displays.get(i).getDisplayId();
        if (fallBackMagnificationModeSettingsLocked(userState, displayId) == false) goto L8;
        updateMagnificationModeChangeSettingsLocked(userState, displayId);
    L8:
        i = i + 1;
        goto L4
    L9:
        updateMagnificationConnectionIfNeeded(userState);
        if (userState.isMagnificationSingleFingerTripleTapEnabledLocked() == true) goto L14;
        if (userState.isShortcutMagnificationEnabledLocked() == true) goto L14;
    L15:
        int i2 = 0;
    L17:
        if (i2 >= displays.size()) goto L24;
        int displayId2 = displays.get(i2).getDisplayId();
        getMagnificationConnectionManager().removeMagnificationButton(displayId2);
        i2 = i2 + 1;
        goto L17
    L24:
        return;
    L14:
        if (userState.getMagnificationCapabilitiesLocked() != 3) goto L15;
    }

    private boolean fallBackMagnificationModeSettingsLocked(AccessibilityUserState userState, int displayId) {
        if (userState.isValidMagnificationModeLocked(displayId) == false) goto L6;
        return false;
    L6:
        Slog.w(LOG_TAG, "displayId " + displayId + ", invalid magnification mode:" + userState.getMagnificationModeLocked(displayId));
        int capabilities = userState.getMagnificationCapabilitiesLocked();
        userState.setMagnificationModeLocked(displayId, capabilities);
        if (displayId != 0) goto L11;
        persistMagnificationModeSettingsLocked(capabilities);
        return true;
    L11:
        return true;
    }

    private void persistMagnificationModeSettingsLocked(final int mode) {
        BackgroundThread.getHandler().post(new AccessibilityManagerService$$ExternalSyntheticLambda0(this, mode));
    }

    private /* synthetic */ void lambda$persistMagnificationModeSettingsLocked$42(int mode) {
        long identity = Binder.clearCallingIdentity();
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "accessibility_magnification_mode", mode, this.mCurrentUserId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public int getMagnificationMode(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = getCurrentUserStateLocked().getMagnificationModeLocked(displayId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean readMagnificationModeForDefaultDisplayLocked(AccessibilityUserState userState) {
        int magnificationMode = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_magnification_mode", 1, userState.mUserId);
        if (magnificationMode == userState.getMagnificationModeLocked(0)) goto L6;
        userState.setMagnificationModeLocked(0, magnificationMode);
        return true;
    L6:
        return false;
    }

    private boolean readMagnificationCapabilitiesLocked(AccessibilityUserState userState) {
        int capabilities = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_magnification_capability", 1, userState.mUserId);
        if (capabilities == userState.getMagnificationCapabilitiesLocked()) goto L6;
        userState.setMagnificationCapabilitiesLocked(capabilities);
        this.mMagnificationController.setMagnificationCapabilities(capabilities);
        return true;
    L6:
        return false;
    }

    boolean readMagnificationFollowTypingLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_magnification_follow_typing_enabled", 1, userState.mUserId) != 1) goto L5;
        boolean followTypeEnabled = true;
    L7:
        if (followTypeEnabled == userState.isMagnificationFollowTypingEnabled()) goto L10;
        userState.setMagnificationFollowTypingEnabled(followTypeEnabled);
        this.mMagnificationController.setMagnificationFollowTypingEnabled(followTypeEnabled);
        return true;
    L10:
        return false;
    L5:
        followTypeEnabled = false;
        goto L7
    }

    public void updateAlwaysOnMagnification() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        readAlwaysOnMagnificationLocked(getCurrentUserState());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean readAlwaysOnMagnificationLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_magnification_always_on_enabled", 1, userState.mUserId) != 1) goto L5;
        boolean isSettingsAlwaysOnEnabled = true;
    L6:
        boolean isAlwaysOnFeatureFlagEnabled = this.mMagnificationController.isAlwaysOnMagnificationFeatureFlagEnabled();
        if (isAlwaysOnFeatureFlagEnabled == false) goto L10;
        if (isSettingsAlwaysOnEnabled == false) goto L10;
        boolean isAlwaysOnEnabled = true;
    L12:
        if (isAlwaysOnEnabled == userState.isAlwaysOnMagnificationEnabled()) goto L15;
        userState.setAlwaysOnMagnificationEnabled(isAlwaysOnEnabled);
        this.mMagnificationController.setAlwaysOnMagnificationEnabled(isAlwaysOnEnabled);
        return true;
    L15:
        return false;
    L10:
        isAlwaysOnEnabled = false;
        goto L12
    L5:
        isSettingsAlwaysOnEnabled = false;
        goto L6
    }

    boolean readRepeatKeysSettingsLocked(AccessibilityUserState userState) {
        if (InputSettings.isRepeatKeysFeatureFlagEnabled() == false) goto L10;
        boolean isRepeatKeysEnabled = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "key_repeat_enabled", 1, userState.mUserId) == 1) goto L8;
        isRepeatKeysEnabled = false;
    L8:
        int repeatKeysTimeoutMs = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "key_repeat_timeout", 400, userState.mUserId);
        this.mMagnificationController.setRepeatKeysEnabled(isRepeatKeysEnabled);
        this.mMagnificationController.setRepeatKeysTimeoutMs(repeatKeysTimeoutMs);
        return false;
    L10:
        return false;
    }

    boolean readMouseKeysEnabledLocked(AccessibilityUserState userState) {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_mouse_keys_enabled", 0, userState.mUserId) != 1) goto L5;
        boolean isMouseKeysEnabled = true;
    L7:
        if (isMouseKeysEnabled == userState.isMouseKeysEnabled()) goto L10;
        userState.setMouseKeysEnabled(isMouseKeysEnabled);
        return true;
    L10:
        return false;
    L5:
        isMouseKeysEnabled = false;
        goto L7
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void setGestureDetectionPassthroughRegion(int displayId, Region region) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda9(), this, Integer.valueOf(displayId), region));
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void setTouchExplorationPassthroughRegion(int displayId, Region region) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda8(), this, Integer.valueOf(displayId), region));
    }

    private void setTouchExplorationPassthroughRegionInternal(int displayId, Region region) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.setTouchExplorationPassthroughRegion(displayId, region);     // Catch: Throwable -> L9
        goto L11
    }

    private void setGestureDetectionPassthroughRegionInternal(int displayId, Region region) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.setGestureDetectionPassthroughRegion(displayId, region);     // Catch: Throwable -> L9
        goto L11
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void setServiceDetectsGesturesEnabled(int displayId, boolean mode) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda21(), this, Integer.valueOf(displayId), Boolean.valueOf(mode)));
    }

    private void setServiceDetectsGesturesInternal(int displayId, boolean mode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        getCurrentUserStateLocked().setServiceDetectsGesturesEnabled(displayId, mode);     // Catch: Throwable -> L9
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.setServiceDetectsGesturesEnabled(displayId, mode);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void requestTouchExploration(int displayId) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda39(), this, Integer.valueOf(displayId)));
    }

    private void requestTouchExplorationInternal(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.requestTouchExploration(displayId);     // Catch: Throwable -> L9
        goto L11
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void requestDragging(int displayId, int pointerId) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda22(), this, Integer.valueOf(displayId), Integer.valueOf(pointerId)));
    }

    private void requestDraggingInternal(int displayId, int pointerId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.requestDragging(displayId, pointerId);     // Catch: Throwable -> L9
        goto L11
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void requestDelegating(int displayId) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda61(), this, Integer.valueOf(displayId)));
    }

    private void requestDelegatingInternal(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.requestDelegating(displayId);     // Catch: Throwable -> L9
        goto L11
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void onDoubleTap(int displayId) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda52(), this, Integer.valueOf(displayId)));
    }

    private void onDoubleTapInternal(int displayId) {
        AccessibilityInputFilter inputFilter = null;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (inputFilter == null) goto L19;
        inputFilter.onDoubleTap(displayId);
        return;
    L19:
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        inputFilter = this.mInputFilter;     // Catch: Throwable -> L9
        goto L11
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void onDoubleTapAndHold(int displayId) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda31(), this, Integer.valueOf(displayId)));
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void requestImeLocked(AbstractAccessibilityServiceConnection connection) {
        if ((connection instanceof AccessibilityServiceConnection) == true) goto L5;
        return;
    L5:
        if ((connection instanceof ProxyAccessibilityServiceConnection) == true) goto L10;
        AccessibilityServiceConnection realConnection = (AccessibilityServiceConnection) connection;
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda50(), this, realConnection));
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda51(), this, realConnection));
        return;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void unbindImeLocked(AbstractAccessibilityServiceConnection connection) {
        if ((connection instanceof AccessibilityServiceConnection) == true) goto L5;
        return;
    L5:
        if ((connection instanceof ProxyAccessibilityServiceConnection) == true) goto L10;
        AccessibilityServiceConnection realConnection = (AccessibilityServiceConnection) connection;
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda54(), this, realConnection));
        return;
    }

    private void createSessionForConnection(AccessibilityServiceConnection connection) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputSessionRequested == false) goto L9;
        connection.createImeSessionLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void bindAndStartInputForConnection(AccessibilityServiceConnection connection) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputBound == false) goto L9;
        connection.bindInputLocked();     // Catch: Throwable -> L7
        connection.startInputLocked(this.mRemoteInputConnection, this.mEditorInfo, this.mRestarting);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void unbindInputForConnection(AccessibilityServiceConnection connection) {
        InputMethodManagerInternal.get().unbindAccessibilityFromCurrentClient(connection.mId, connection.mUserId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        connection.unbindInputLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onDoubleTapAndHoldInternal(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasInputFilter == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mInputFilter == null) goto L11;
        this.mInputFilter.onDoubleTapAndHold(displayId);     // Catch: Throwable -> L9
        goto L11
    }

    private void updateFocusAppearanceDataLocked(final AccessibilityUserState userState) {
        if (userState.mUserId == this.mCurrentUserId) goto L6;
        return;
    L6:
        if (this.mTraceManager.isA11yTracingEnabledForTypes(2) == false) goto L8;
        this.mTraceManager.logTrace("AccessibilityManagerService.updateFocusAppearanceDataLocked", 2, "userState=" + userState);
    L8:
        this.mMainHandler.post(new AccessibilityManagerService$$ExternalSyntheticLambda2(this, userState));
    }

    private /* synthetic */ void lambda$updateFocusAppearanceDataLocked$44(final AccessibilityUserState userState) {
        broadcastToClients(userState, FunctionalUtils.ignoreRemoteException(new AccessibilityManagerService$$ExternalSyntheticLambda29(this, userState)));
    }

    private /* synthetic */ void lambda$updateFocusAppearanceDataLocked$43(AccessibilityUserState userState, Client client) throws RemoteException {
        if (this.mProxyManager.isProxyedDeviceId(client.mDeviceId) == true) goto L6;
        client.mCallback.setFocusAppearance(userState.getFocusStrokeWidthLocked(), userState.getFocusColorLocked());
        return;
    }

    public AccessibilityTraceManager getTraceManager() {
        return this.mTraceManager;
    }

    public void scheduleBindInput() {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda20(), this));
    }

    private void bindInput() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInputBound = true;     // Catch: Throwable -> L10
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L10
        int i = userState.mBoundServices.size() - 1;     // Catch: Throwable -> L10
    L6:
        if (i < 0) goto L14;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);     // Catch: Throwable -> L10
        if (service.requestImeApis() == false) goto L12;
        service.bindInputLocked();     // Catch: Throwable -> L10
    L12:
        i = i - 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void scheduleUnbindInput() {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda55(), this));
    }

    private void unbindInput() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInputBound = false;     // Catch: Throwable -> L10
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L10
        int i = userState.mBoundServices.size() - 1;     // Catch: Throwable -> L10
    L6:
        if (i < 0) goto L14;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);     // Catch: Throwable -> L10
        if (service.requestImeApis() == false) goto L12;
        service.unbindInputLocked();     // Catch: Throwable -> L10
    L12:
        i = i - 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void scheduleStartInput(IRemoteAccessibilityInputConnection connection, EditorInfo editorInfo, boolean restarting) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda37(), this, connection, editorInfo, Boolean.valueOf(restarting)));
    }

    private void startInput(IRemoteAccessibilityInputConnection connection, EditorInfo editorInfo, boolean restarting) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRemoteInputConnection = connection;     // Catch: Throwable -> L9
        this.mEditorInfo = editorInfo;     // Catch: Throwable -> L9
        this.mRestarting = restarting;     // Catch: Throwable -> L9
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L9
        int i = userState.mBoundServices.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);     // Catch: Throwable -> L9
        if (service.requestImeApis() == false) goto L11;
        service.startInputLocked(connection, editorInfo, restarting);     // Catch: Throwable -> L9
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

    public void scheduleCreateImeSession(ArraySet<Integer> ignoreSet) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda18(), this, ignoreSet));
    }

    private void createImeSession(ArraySet<Integer> ignoreSet) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInputSessionRequested = true;     // Catch: Throwable -> L12
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L12
        int i = userState.mBoundServices.size() - 1;     // Catch: Throwable -> L12
    L6:
        if (i < 0) goto L16;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);     // Catch: Throwable -> L12
        if (ignoreSet.contains(Integer.valueOf(service.mId)) == true) goto L14;
        if (service.requestImeApis() == false) goto L14;
        service.createImeSessionLocked();     // Catch: Throwable -> L12
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void scheduleSetImeSessionEnabled(SparseArray<IAccessibilityInputMethodSession> sessions, boolean enabled) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda70(), this, sessions, Boolean.valueOf(enabled)));
    }

    private void setImeSessionEnabled(SparseArray<IAccessibilityInputMethodSession> sessions, boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AccessibilityUserState userState = getCurrentUserStateLocked();     // Catch: Throwable -> L11
        int i = userState.mBoundServices.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        AccessibilityServiceConnection service = userState.mBoundServices.get(i);     // Catch: Throwable -> L11
        if (sessions.contains(service.mId) == false) goto L13;
        if (service.requestImeApis() == false) goto L13;
        service.setImeSessionEnabledLocked(sessions.get(service.mId), enabled);     // Catch: Throwable -> L11
    L13:
        i = i - 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void registerUserInitializationCompleteCallback(IUserInitializationCompleteCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserInitializationCompleteCallbacks.add(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterUserInitializationCompleteCallback(IUserInitializationCompleteCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserInitializationCompleteCallbacks.remove(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void injectInputEventToInputFilter(InputEvent event) {
        injectInputEventToInputFilter_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        long endMillis = SystemClock.uptimeMillis() + 1000;     // Catch: Throwable -> L12
    L6:
        if (this.mInputFilterInstalled == true) goto L16;
        if (SystemClock.uptimeMillis() >= endMillis) goto L16;
        this.mLock.wait(endMillis - SystemClock.uptimeMillis());     // Catch: Throwable -> L12 InterruptedException -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (this.mInputFilterInstalled == true) goto L20;
    L22:
        Slog.w(LOG_TAG, "Cannot injectInputEventToInputFilter because the AccessibilityInputFilter is not installed.");
        return;
    L20:
        if (this.mInputFilter == null) goto L22;
        this.mInputFilter.onInputEvent(event, 1090519040);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void sendPendingWindowStateChangedEventsForAvailableWindowLocked(int windowId) {
        int eventSize = this.mSendWindowStateChangedEventRunnables.size();
        int i = eventSize - 1;
    L3:
        if (i < 0) goto L9;
        SendWindowStateChangedEventRunnable runnable = this.mSendWindowStateChangedEventRunnables.get(i);
        if (SendWindowStateChangedEventRunnable.m631$$Nest$mgetWindowId(runnable) != windowId) goto L7;
        this.mMainHandler.removeCallbacks(runnable);
        SendWindowStateChangedEventRunnable.m632$$Nest$msendPendingEventLocked(runnable);
    L7:
        i = i - 1;
        goto L3
    }

    private boolean postponeWindowStateEvent(AccessibilityEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int resolvedWindowId = this.mA11yWindowManager.resolveParentWindowIdLocked(event.getWindowId());     // Catch: Throwable -> L9
        if (this.mA11yWindowManager.findWindowInfoByIdLocked(resolvedWindowId) == null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        SendWindowStateChangedEventRunnable pendingRunnable = new SendWindowStateChangedEventRunnable(this, new AccessibilityEvent(event));     // Catch: Throwable -> L9
        this.mMainHandler.postDelayed(pendingRunnable, 500);     // Catch: Throwable -> L9
        this.mSendWindowStateChangedEventRunnables.add(pendingRunnable);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    public void attachAccessibilityOverlayToDisplay(int displayId, SurfaceControl sc) {
        attachAccessibilityOverlayToDisplay_enforcePermission();
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda28(), this, -1, Integer.valueOf(displayId), sc, null));
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void attachAccessibilityOverlayToDisplay(int interactionId, int displayId, SurfaceControl sc, IAccessibilityInteractionConnectionCallback callback) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new AccessibilityManagerService$$ExternalSyntheticLambda28(), this, Integer.valueOf(interactionId), Integer.valueOf(displayId), sc, callback));
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public int performScreenCapture(ScreenCapture.LayerCaptureArgs captureArgs, ScreenCapture.ScreenCaptureListener captureListener) {
        return ScreenCapture.captureLayers(captureArgs, captureListener);
    }

    int getShortcutTypeForGenericShortcutCalls(int userId) {
        int navigationMode = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "navigation_mode", -1, userId);
        if (navigationMode != 2) goto L5;
        return 32;
    L5:
        return 1;
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void setMinumumIntervalObric(String targetPackageName, int eventType, int interval, AbstractAccessibilityServiceConnection connection) {
        this.mObricExt.setMinumumIntervalObric(targetPackageName, eventType, interval, connection);
    }

    @Override // com.android.server.accessibility.AbstractAccessibilityServiceConnection.SystemSupport
    public void clearFrequencyLimit(AbstractAccessibilityServiceConnection connection) {
        this.mObricExt.clearFrequencyLimit(connection);
    }

    void attachAccessibilityOverlayToDisplayInternal(int interactionId, int displayId, SurfaceControl sc, IAccessibilityInteractionConnectionCallback callback) {
        if (this.mA11yOverlayLayers.contains(displayId) == true) goto L5;
        this.mA11yOverlayLayers.put(displayId, this.mWindowManagerService.getA11yOverlayLayer(displayId));
    L5:
        SurfaceControl parent = this.mA11yOverlayLayers.get(displayId);
        if (parent != null) goto L8;
        Slog.e(LOG_TAG, "Unable to get accessibility overlay SurfaceControl.");
        this.mA11yOverlayLayers.remove(displayId);
        int result = 2;
    L9:
        if (callback == null) goto L17;
        callback.sendAttachOverlayResult(result, interactionId);     // Catch: RemoteException -> L12
        return;
    L12:
        re = move-exception;
        Slog.e(LOG_TAG, "Exception while attaching overlay.", re);
        return;
    L17:
        return;
    L8:
        SurfaceControl.Transaction t = new SurfaceControl.Transaction();
        t.reparent(sc, parent).setTrustedOverlay(sc, true).apply();
        t.close();
        result = 0;
        goto L9
    }

    private void skipVolumeShortcutDialogTimeoutRestriction(int userId) {
        persistIntToSetting(userId, "skip_accessibility_shortcut_dialog_timeout_restriction", 1);
    }

    private void logMetricForQsShortcutConfiguration(boolean enable, int numOfFeatures) {
        if (numOfFeatures > 0) goto L4;
        return;
    L4:
        if (enable == false) goto L6;
        String metricId = METRIC_ID_QS_SHORTCUT_ADD;
    L7:
        Counter.logIncrementWithUid(metricId, Binder.getCallingUid(), numOfFeatures);
        return;
    L6:
        metricId = METRIC_ID_QS_SHORTCUT_REMOVE;
        goto L7
    }

    private void assertNoTapShortcut(int shortcutType) {
        if ((shortcutType & 12) != 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Tap shortcuts are not supported.");
    }
}

package com.android.server.wm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.ActivityThread;
import android.app.LoadedApk;
import android.app.ResourcesManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.Slog;
import android.util.SparseArray;
import android.view.DisplayInfo;
import android.view.InsetsFlags;
import android.view.InsetsFrameProvider;
import android.view.InsetsSource;
import android.view.InsetsState;
import android.view.PrivacyIndicatorBounds;
import android.view.Surface;
import android.view.ViewDebug;
import android.view.ViewRootImpl;
import android.view.WindowInsets;
import android.view.WindowLayout;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.window.ClientWindowFrames;
import android.window.DesktopExperienceFlags;
import android.window.DesktopModeFlags;
import com.android.internal.os.BackgroundThread;
import com.android.internal.policy.ForceShowNavBarSettingsObserver;
import com.android.internal.policy.GestureNavigationSettingsObserver;
import com.android.internal.policy.ScreenDecorationsUtils;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.statusbar.LetterboxDetails;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.ScreenshotHelper;
import com.android.internal.util.ScreenshotRequest;
import com.android.internal.util.function.TriFunction;
import com.android.internal.view.AppearanceRegion;
import com.android.internal.widget.PointerLocationView;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.UiThread;
import com.android.server.input.InputManagerService;
import com.android.server.notification.NotificationManagerInternal;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.redmagic.GameKeysPatch;
import com.android.server.resmng.BoostHintType;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.wallpaper.WallpaperManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayPolicy {
    static final int ANIMATION_NONE = -1;
    static final int ANIMATION_STYLEABLE = 0;
    private static final int INSETS_OVERRIDE_INDEX_INVALID = -1;
    private static final int MSG_DISABLE_POINTER_LOCATION = 5;
    private static final int MSG_ENABLE_POINTER_LOCATION = 4;
    private static final int NAV_BAR_FORCE_TRANSPARENT = 2;
    private static final int NAV_BAR_OPAQUE_WHEN_FREEFORM_OR_DOCKED = 0;
    private static final int NAV_BAR_TRANSLUCENT_WHEN_FREEFORM_OPAQUE_OTHERWISE = 1;
    private static final long PANIC_GESTURE_EXPIRATION = 30000;
    private static boolean SCROLL_BOOST_SS_ENABLE = false;
    private static final int SHOW_TYPES_FOR_PANIC = 0;
    private static final int SHOW_TYPES_FOR_SWIPE = 0;
    private static boolean SILKY_SCROLLS_ENABLE = false;
    private static boolean SILKY_SCROLLS_LITE_ENABLE = false;
    private static final String TAG = "WindowManager";
    private static final boolean USE_CACHED_INSETS_FOR_DISPLAY_SWITCH = false;
    private static boolean isLowRAM;
    private static final ClientWindowFrames sTmpClientFrames = null;
    private static final Rect sTmpDisplayCutoutSafe = null;
    private static final Rect sTmpRect = null;
    private static final Rect sTmpRect2 = null;
    private final AccessibilityManager mAccessibilityManager;
    private boolean mAllowLockscreenWhenOn;
    private final WindowManagerInternal.AppTransitionListener mAppTransitionListener;
    private volatile boolean mAwake;
    private WindowState mBottomGestureHost;
    private DecorInsets.Cache mCachedDecorInsets;
    private boolean mCanSystemBarsBeShownByUser;
    private final boolean mCarDockEnablesAccelerometer;
    private final Context mContext;
    private Resources mCurrentUserResources;
    final DecorInsets mDecorInsets;
    private final boolean mDeskDockEnablesAccelerometer;
    final DisplayContent mDisplayContent;
    private volatile int mDockMode;
    private boolean mDreamingLockscreen;
    private IExtDisplayPolicy mExt;
    private String mFocusedApp;
    private WindowState mFocusedWindow;
    private final ForceShowNavBarSettingsObserver mForceShowNavBarSettingsObserver;
    private boolean mForceShowNavigationBarEnabled;
    private int mForciblyShownTypes;
    private final GestureNavigationSettingsObserver mGestureNavigationSettingsObserver;
    private final Handler mHandler;
    private boolean mHasBottomNavigationBar;
    private volatile boolean mHasNavigationBar;
    private volatile boolean mHasStatusBar;
    private volatile boolean mHdmiPlugged;
    private final Runnable mHiddenNavPanic;
    private boolean mImeInsetsConsumed;
    private boolean mImmersiveConfirmationWindowExists;
    private final ArraySet<WindowState> mInsetsSourceWindowsExceptIme;
    private boolean mIsFreeformWindowOverlappingWithNavBar;
    private boolean mIsImmersiveMode;
    private boolean mIsPerfBoostFlingAcquired;
    private WindowState mIslandWindow;
    private volatile boolean mKeyguardDrawComplete;
    private int mLastAppearance;
    private int mLastBehavior;
    private int mLastDisableFlags;
    private boolean mLastFocusIsFullscreen;
    private WindowState mLastFocusedWindow;
    private LetterboxDetails[] mLastLetterboxDetails;
    private int mLastRequestedVisibleTypes;
    private boolean mLastShowingDream;
    private AppearanceRegion[] mLastStatusBarAppearanceRegions;
    private WindowState mLeftGestureHost;
    private int mLeftGestureInset;
    private final ArrayList<LetterboxDetails> mLetterboxDetails;
    private volatile int mLidState;
    private final Object mLock;
    private WindowState mNavBarBackgroundWindowCandidate;
    private WindowState mNavBarColorWindowCandidate;
    protected int mNavBarOpacityMode;
    WindowState mNavigationBar;
    private volatile boolean mNavigationBarAlwaysShowOnSideGesture;
    private volatile boolean mNavigationBarCanMove;
    private volatile WindowState mNotificationShade;
    private IObricDisplayPolicy mObricExt;
    private final long mPanicThresholdMs;
    private long mPanicTime;
    private long mPendingPanicGestureUptime;
    BoostFramework mPerf;
    BoostFramework mPerfBoostDrag;
    BoostFramework mPerfBoostFling;
    BoostFramework mPerfBoostPrefling;
    private volatile boolean mPersistentVrModeEnabled;
    private PointerLocationView mPointerLocationView;
    private RefreshRatePolicy mRefreshRatePolicy;
    private final ArraySet<ActivityRecord> mRelaunchingSystemBarColorApps;
    private boolean mRemoteInsetsControllerControlsSystemBars;
    private WindowState mRightGestureHost;
    private int mRightGestureInset;
    private volatile boolean mScreenOnEarly;
    private volatile boolean mScreenOnFully;
    private volatile WindowManagerPolicy.ScreenOnListener mScreenOnListener;
    public final ScreenshotHelper mScreenshotHelper;
    protected final WindowManagerService mService;
    private final Object mServiceAcquireLock;
    private boolean mShouldAttachNavBarToAppDuringTransition;
    private boolean mShowingDream;
    WindowState mStatusBar;
    private final ArrayList<AppearanceRegion> mStatusBarAppearanceRegionList;
    private final Rect mStatusBarBackgroundCheckedBounds;
    private final ArrayList<WindowState> mStatusBarBackgroundWindows;
    private final Rect mStatusBarColorCheckedBounds;
    private StatusBarManagerInternal mStatusBarManagerInternal;
    private final ArraySet<ActivityRecord> mSystemBarColorApps;
    private SystemGesturesPointerEventListener mSystemGestures;
    private WindowState mSystemUiControllingWindow;
    private WindowState mTopFullscreenOpaqueWindowState;
    private WindowState mTopGestureHost;
    private boolean mTopIsFullscreen;
    private final Context mUiContext;
    private final WindowLayout mWindowLayout;
    private volatile boolean mWindowManagerDrawComplete;

    /* JADX INFO: renamed from: com.android.server.wm.DisplayPolicy$1, reason: invalid class name */
    class AnonymousClass1 implements SystemGesturesPointerEventListener.Callbacks {
        private static final long MOUSE_GESTURE_DELAY_MS = 500;
        private Runnable mOnSwipeFromBottom;
        private Runnable mOnSwipeFromLeft;
        private Runnable mOnSwipeFromRight;
        private Runnable mOnSwipeFromTop;
        final /* synthetic */ DisplayPolicy this$0;
        final /* synthetic */ DisplayContent val$displayContent;

        AnonymousClass1(DisplayPolicy this$0, DisplayContent r2) {
            this.this$0 = this$0;
            this.val$displayContent = r2;
            this.mOnSwipeFromLeft = new DisplayPolicy$1$$ExternalSyntheticLambda0(this);
            this.mOnSwipeFromTop = new DisplayPolicy$1$$ExternalSyntheticLambda1(this);
            this.mOnSwipeFromRight = new DisplayPolicy$1$$ExternalSyntheticLambda2(this);
            this.mOnSwipeFromBottom = new DisplayPolicy$1$$ExternalSyntheticLambda3(this);
        }

        private Insets getControllableInsets(WindowState win) {
            if (win == null) goto L4;
            InsetsSourceProvider provider = win.getControllableInsetProvider();
            if (provider != null) goto L10;
            return Insets.NONE;
        L10:
            return provider.getSource().calculateInsets(win.getBounds(), true);
        L4:
            return Insets.NONE;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onSwipeFromTop() {
            Object r0 = DisplayPolicy.m9929$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            DisplayPolicy r1 = this.this$0;     // Catch: Throwable -> L11
            WindowState r2 = DisplayPolicy.m9933$$Nest$fgetmTopGestureHost(this.this$0);     // Catch: Throwable -> L11
            if (getControllableInsets(DisplayPolicy.m9933$$Nest$fgetmTopGestureHost(this.this$0)).top <= 0) goto L7;
            boolean r3 = true;
        L8:
            r1.requestTransientBars(r2, r3);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            r3 = false;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onSwipeFromBottom() {
            Object r0 = DisplayPolicy.m9929$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            DisplayPolicy r1 = this.this$0;     // Catch: Throwable -> L11
            WindowState r2 = DisplayPolicy.m9924$$Nest$fgetmBottomGestureHost(this.this$0);     // Catch: Throwable -> L11
            if (getControllableInsets(DisplayPolicy.m9924$$Nest$fgetmBottomGestureHost(this.this$0)).bottom <= 0) goto L7;
            boolean r3 = true;
        L8:
            r1.requestTransientBars(r2, r3);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            r3 = false;
        L11:
            th = move-exception;
            throw th;
        }

        private boolean allowsSideSwipe(Region excludedRegion) {
            if (DisplayPolicy.m9930$$Nest$fgetmNavigationBarAlwaysShowOnSideGesture(this.this$0) == true) goto L5;
        L7:
            return false;
        L5:
            if (DisplayPolicy.m9932$$Nest$fgetmSystemGestures(this.this$0).currentGestureStartedInRegion(excludedRegion) == true) goto L7;
            return true;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onSwipeFromRight() {
            Region excludedRegion = Region.obtain();
            Object r1 = DisplayPolicy.m9929$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            this.this$0.mDisplayContent.calculateSystemGestureExclusion(excludedRegion, null);     // Catch: Throwable -> L12
            if (getControllableInsets(DisplayPolicy.m9931$$Nest$fgetmRightGestureHost(this.this$0)).right <= 0) goto L7;
            boolean hasWindow = true;
        L8:
            if (hasWindow == true) goto L14;
            if (allowsSideSwipe(excludedRegion) == true) goto L14;
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L12
            excludedRegion.recycle();
            return;
        L14:
            this.this$0.requestTransientBars(DisplayPolicy.m9931$$Nest$fgetmRightGestureHost(this.this$0), hasWindow);     // Catch: Throwable -> L12
            goto L15
        L7:
            hasWindow = false;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onSwipeFromLeft() {
            Region excludedRegion = Region.obtain();
            Object r1 = DisplayPolicy.m9929$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            this.this$0.mDisplayContent.calculateSystemGestureExclusion(excludedRegion, null);     // Catch: Throwable -> L12
            if (getControllableInsets(DisplayPolicy.m9928$$Nest$fgetmLeftGestureHost(this.this$0)).left <= 0) goto L7;
            boolean hasWindow = true;
        L8:
            if (hasWindow == true) goto L14;
            if (allowsSideSwipe(excludedRegion) == true) goto L14;
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L12
            excludedRegion.recycle();
            return;
        L14:
            this.this$0.requestTransientBars(DisplayPolicy.m9928$$Nest$fgetmLeftGestureHost(this.this$0), hasWindow);     // Catch: Throwable -> L12
            goto L15
        L7:
            hasWindow = false;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onFling(int duration) {
            if (this.this$0.mService.mPowerManagerInternal == null) goto L6;
            this.this$0.mService.mPowerManagerInternal.setPowerBoost(0, duration);
            return;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onDebug() {
        }

        private WindowOrientationListener getOrientationListener() {
            DisplayRotation rotation = this.this$0.mDisplayContent.getDisplayRotation();
            if (rotation != null) goto L7;
            return null;
        L7:
            return rotation.getOrientationListener();
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onDown() {
            WindowOrientationListener listener = getOrientationListener();
            if (listener == null) goto L6;
            listener.onTouchStart();
            return;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onVerticalFling(int duration) {
            String currentPackage = DisplayPolicy.m9939$$Nest$mgetAppPackageName(this.this$0);
            if (currentPackage != null) goto L6;
            Slog.e(DisplayPolicy.TAG, "Error: package name null");
            return;
        L6:
            String currentActivity = DisplayPolicy.m9938$$Nest$mgetActivityName(this.this$0);
            if (currentActivity != null) goto L11;
            Slog.e(DisplayPolicy.TAG, "Error: activity name null");
            return;
        L11:
            if (DisplayPolicy.m9942$$Nest$sfgetSCROLL_BOOST_SS_ENABLE() == true) goto L13;
            return;
        L13:
            if (this.this$0.mPerfBoostFling != null) goto L16;
            this.this$0.mPerfBoostFling = new BoostFramework();
            DisplayPolicy.m9934$$Nest$fputmIsPerfBoostFlingAcquired(this.this$0, false);
        L16:
            if (this.this$0.mPerfBoostFling != null) goto L19;
            Slog.e(DisplayPolicy.TAG, "Error: boost object null");
            return;
        L19:
            boolean isGame = DisplayPolicy.m9941$$Nest$misTopAppGame(this.this$0, currentPackage, this.this$0.mPerfBoostFling);
            boolean isBoostLimit = false;
            if (this.this$0.mDisplayContent != null) goto L22;
        L26:
            if (isGame == true) goto L37;
            if (isBoostLimit == false) goto L29;
            return;
        L29:
            if (this.this$0.mPerfBoostFling.board_first_api_lvl <= 202404) goto L31;
        L33:
            this.this$0.mPerfBoostFling.perfHint(4224, currentActivity, duration + 160, 1);
            DisplayPolicy.m9934$$Nest$fputmIsPerfBoostFlingAcquired(this.this$0, true);
        L34:
            SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquireType(BoostHintType.RESMNG_HINT_SCROLL_CPU_BOOST, 0, Math.min(duration + 160, 1000));
            return;
        L31:
            if (this.this$0.mPerfBoostFling.board_api_lvl > 202404) goto L33;
            this.this$0.mPerfBoostFling.perfHint(4224, currentPackage, duration + 160, 1);
            DisplayPolicy.m9934$$Nest$fputmIsPerfBoostFlingAcquired(this.this$0, true);
            goto L34
        L37:
            return;
        L22:
            if (this.this$0.mDisplayContent.getExt().isObricVirtualDisplay() == false) goto L26;
            String currentPackageOnDisplay = DisplayPolicy.m9940$$Nest$mgetAppPackageNameByDisplayId(this.this$0, this.this$0.mDisplayContent.getDisplayId());
            if (SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().isBoostLimitForOAutoPkg(currentPackageOnDisplay) == false) goto L26;
            isBoostLimit = true;
            Slog.i(DisplayPolicy.TAG, "FEAT_OAUTO_POWER_CTRL, ignore verticalscroll boost, pkg:" + currentPackageOnDisplay);
            goto L26
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onHorizontalFling(int duration) {
            String currentPackage = DisplayPolicy.m9939$$Nest$mgetAppPackageName(this.this$0);
            if (currentPackage != null) goto L6;
            Slog.e(DisplayPolicy.TAG, "Error: package name null");
            return;
        L6:
            String currentActivity = DisplayPolicy.m9938$$Nest$mgetActivityName(this.this$0);
            if (currentActivity != null) goto L11;
            Slog.e(DisplayPolicy.TAG, "Error: activity name null");
            return;
        L11:
            if (DisplayPolicy.m9942$$Nest$sfgetSCROLL_BOOST_SS_ENABLE() == true) goto L13;
            return;
        L13:
            if (this.this$0.mPerfBoostFling != null) goto L16;
            this.this$0.mPerfBoostFling = new BoostFramework();
            DisplayPolicy.m9934$$Nest$fputmIsPerfBoostFlingAcquired(this.this$0, false);
        L16:
            if (this.this$0.mPerfBoostFling != null) goto L19;
            Slog.e(DisplayPolicy.TAG, "Error: boost object null");
            return;
        L19:
            boolean isGame = DisplayPolicy.m9941$$Nest$misTopAppGame(this.this$0, currentPackage, this.this$0.mPerfBoostFling);
            boolean isBoostLimit = false;
            if (this.this$0.mDisplayContent != null) goto L22;
        L26:
            if (isGame == true) goto L37;
            if (isBoostLimit == false) goto L29;
            return;
        L29:
            if (this.this$0.mPerfBoostFling.board_first_api_lvl <= 202404) goto L31;
        L33:
            this.this$0.mPerfBoostFling.perfHint(4224, currentActivity, duration + 160, 2);
            DisplayPolicy.m9934$$Nest$fputmIsPerfBoostFlingAcquired(this.this$0, true);
        L34:
            SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquireType(BoostHintType.RESMNG_HINT_SCROLL_CPU_BOOST, 0, Math.min(duration + 160, 1000));
            return;
        L31:
            if (this.this$0.mPerfBoostFling.board_api_lvl > 202404) goto L33;
            this.this$0.mPerfBoostFling.perfHint(4224, currentPackage, duration + 160, 2);
            DisplayPolicy.m9934$$Nest$fputmIsPerfBoostFlingAcquired(this.this$0, true);
            goto L34
        L37:
            return;
        L22:
            if (this.this$0.mDisplayContent.getExt().isObricVirtualDisplay() == false) goto L26;
            String currentPackageOnDisplay = DisplayPolicy.m9940$$Nest$mgetAppPackageNameByDisplayId(this.this$0, this.this$0.mDisplayContent.getDisplayId());
            if (SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().isBoostLimitForOAutoPkg(currentPackageOnDisplay) == false) goto L26;
            isBoostLimit = true;
            Slog.i(DisplayPolicy.TAG, "FEAT_OAUTO_POWER_CTRL, ignore horizontal scroll boost, pkg:" + currentPackageOnDisplay);
            goto L26
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onScroll(boolean started) {
            String currentPackage = DisplayPolicy.m9939$$Nest$mgetAppPackageName(this.this$0);
            if (currentPackage != null) goto L6;
            Slog.e(DisplayPolicy.TAG, "Error: package name null");
            return;
        L6:
            String currentActivity = DisplayPolicy.m9938$$Nest$mgetActivityName(this.this$0);
            if (currentActivity != null) goto L11;
            Slog.e(DisplayPolicy.TAG, "Error: activity name null");
            return;
        L11:
            if (this.this$0.mPerfBoostDrag != null) goto L14;
            this.this$0.mPerfBoostDrag = new BoostFramework();
        L14:
            if (this.this$0.mPerfBoostDrag != null) goto L17;
            Slog.e(DisplayPolicy.TAG, "Error: boost object null");
            return;
        L17:
            boolean isBoostLimit = false;
            if (this.this$0.mDisplayContent == null) goto L25;
            if (this.this$0.mDisplayContent.getExt().isObricVirtualDisplay() == false) goto L25;
            String currentPackageOnDisplay = DisplayPolicy.m9940$$Nest$mgetAppPackageNameByDisplayId(this.this$0, this.this$0.mDisplayContent.getDisplayId());
            if (SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().isBoostLimitForOAutoPkg(currentPackageOnDisplay) == false) goto L25;
            isBoostLimit = true;
            Slog.i(DisplayPolicy.TAG, "FEAT_OAUTO_POWER_CTRL, ignore scroll boost, pkg:" + currentPackageOnDisplay);
        L25:
            if (DisplayPolicy.m9942$$Nest$sfgetSCROLL_BOOST_SS_ENABLE() == false) goto L43;
            if (started == false) goto L43;
            if (this.this$0.mPerfBoostPrefling != null) goto L31;
            this.this$0.mPerfBoostPrefling = new BoostFramework();
        L31:
            if (this.this$0.mPerfBoostPrefling != null) goto L34;
            Slog.e(DisplayPolicy.TAG, "Error: boost object null");
            return;
        L34:
            boolean isGame = DisplayPolicy.m9941$$Nest$misTopAppGame(this.this$0, currentPackage, this.this$0.mPerfBoostPrefling);
            if (isGame == true) goto L43;
            if (isBoostLimit == true) goto L43;
            if (this.this$0.mPerfBoostPrefling.board_first_api_lvl <= 202404) goto L40;
        L42:
            this.this$0.mPerfBoostPrefling.perfHint(4224, currentActivity, -1, 4);
            goto L43
        L40:
            if (this.this$0.mPerfBoostPrefling.board_api_lvl > 202404) goto L42;
            this.this$0.mPerfBoostPrefling.perfHint(4224, currentPackage, -1, 4);
        L43:
            boolean isGame2 = DisplayPolicy.m9941$$Nest$misTopAppGame(this.this$0, currentPackage, this.this$0.mPerfBoostDrag);
            if (isGame2 == true) goto L62;
            if (isBoostLimit == true) goto L62;
            if (started == false) goto L62;
            if (DisplayPolicy.m9943$$Nest$sfgetSILKY_SCROLLS_ENABLE() == false) goto L56;
            if (this.this$0.mPerfBoostDrag.board_first_api_lvl <= 202404) goto L52;
        L54:
            this.this$0.mPerfBoostDrag.perfEvent(4177, currentActivity);
            goto L56
        L52:
            if (this.this$0.mPerfBoostDrag.board_api_lvl > 202404) goto L54;
            this.this$0.mPerfBoostDrag.perfEvent(4177, currentPackage);
        L56:
            if (this.this$0.mPerfBoostDrag.board_first_api_lvl <= 202404) goto L58;
        L60:
            this.this$0.mPerfBoostDrag.perfHint(4231, currentActivity, -1, 1);
            return;
        L58:
            if (this.this$0.mPerfBoostDrag.board_api_lvl > 202404) goto L60;
            this.this$0.mPerfBoostDrag.perfHint(4231, currentPackage, -1, 1);
            return;
        L62:
            if (DisplayPolicy.m9943$$Nest$sfgetSILKY_SCROLLS_ENABLE() == true) goto L70;
            if (DisplayPolicy.m9944$$Nest$sfgetSILKY_SCROLLS_LITE_ENABLE() == true) goto L70;
            if (this.this$0.mPerfBoostDrag.board_first_api_lvl < 202404) goto L75;
            this.this$0.mPerfBoostDrag.perfHintRelease();
        L75:
            this.this$0.mPerfBoostDrag.perfLockRelease();
            return;
        L70:
            if (this.this$0.mPerfBoostDrag.board_first_api_lvl <= 202404) goto L72;
        L74:
            this.this$0.mPerfBoostDrag.perfEvent(4178, currentActivity);
            goto L75
        L72:
            if (this.this$0.mPerfBoostDrag.board_api_lvl > 202404) goto L74;
            this.this$0.mPerfBoostDrag.perfEvent(4178, currentPackage);
            goto L75
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onUpOrCancel() {
            WindowOrientationListener listener = getOrientationListener();
            if (listener == null) goto L6;
            listener.onTouchEnd();
            return;
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseHoverAtLeft() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromLeft);
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).postDelayed(this.mOnSwipeFromLeft, 500);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseHoverAtTop() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromTop);
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).postDelayed(this.mOnSwipeFromTop, 500);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseHoverAtRight() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromRight);
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).postDelayed(this.mOnSwipeFromRight, 500);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseHoverAtBottom() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromBottom);
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).postDelayed(this.mOnSwipeFromBottom, 500);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseLeaveFromLeft() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromLeft);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseLeaveFromTop() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromTop);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseLeaveFromRight() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromRight);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public void onMouseLeaveFromBottom() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mOnSwipeFromBottom);
        }

        @Override // com.android.server.wm.SystemGesturesPointerEventListener.Callbacks
        public boolean onSwipeFromIsland() {
            Object r0 = DisplayPolicy.m9929$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (DisplayPolicy.m9927$$Nest$fgetmIslandWindow(this.this$0) != null) goto L7;
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return false;
        L7:
            if (DisplayPolicy.m9927$$Nest$fgetmIslandWindow(this.this$0).isVisibleNow() == false) goto L23;
            if (this.this$0.isKeyguardShowing() == true) goto L11;
        L17:
            boolean transferred = DisplayPolicy.m9927$$Nest$fgetmIslandWindow(this.this$0).transferTouch();     // Catch: Throwable -> L15
            if (transferred == true) goto L20;
            Slog.i(DisplayPolicy.TAG, "Could not transfer touch to the island window");     // Catch: Throwable -> L15
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return true;
        L11:
            if (this.val$displayContent.getExt().hasFocusedWindowAboveKeyguard() == false) goto L17;
            Slog.i(DisplayPolicy.TAG, "skip transferring touch due to focused window above keyguard");     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return false;
        }
    }

    /* JADX INFO: renamed from: com.android.server.wm.DisplayPolicy$2, reason: invalid class name */
    class AnonymousClass2 extends WindowManagerInternal.AppTransitionListener {
        private Runnable mAppTransitionCancelled;
        private Runnable mAppTransitionFinished;
        private Runnable mAppTransitionPending;
        final /* synthetic */ DisplayPolicy this$0;
        final /* synthetic */ int val$displayId;

        public static /* synthetic */ void $r8$lambda$CXhKWmWGy4Pshrr9kG2TtfP0hiw(AnonymousClass2 r0, int r1) {
            r0.lambda$$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$LNgePaZheD4TlU5IrmvA1klqhxA(AnonymousClass2 r0, int r1) {
            r0.lambda$$2(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$_oCBJp-Ybw1Pg_ZtEZnsleQENV8, reason: not valid java name */
        public static /* synthetic */ void m9945$r8$lambda$_oCBJpYbw1Pg_ZtEZnsleQENV8(AnonymousClass2 r0, long r1, long r3) {
            r0.lambda$onAppTransitionStartingLocked$3(r1, r3);
        }

        public static /* synthetic */ void $r8$lambda$qveQftqQbx73evHdRr8UoP4AtdU(AnonymousClass2 r0, int r1) {
            r0.lambda$$0(r1);
        }

        AnonymousClass2(DisplayPolicy this$0, int displayId, int r4) {
            this.this$0 = this$0;
            this.val$displayId = r4;
            super(displayId);
            final int r5 = this.val$displayId;
            this.mAppTransitionPending = new DisplayPolicy$2$$ExternalSyntheticLambda1(this, r5);
            final int r6 = this.val$displayId;
            this.mAppTransitionCancelled = new DisplayPolicy$2$$ExternalSyntheticLambda2(this, r6);
            final int r7 = this.val$displayId;
            this.mAppTransitionFinished = new DisplayPolicy$2$$ExternalSyntheticLambda3(this, r7);
        }

        private /* synthetic */ void lambda$$0(int displayId) {
            StatusBarManagerInternal statusBar = this.this$0.getStatusBarManagerInternal();
            if (statusBar == null) goto L6;
            statusBar.appTransitionPending(displayId);
            return;
        }

        private /* synthetic */ void lambda$$1(int displayId) {
            StatusBarManagerInternal statusBar = this.this$0.getStatusBarManagerInternal();
            if (statusBar == null) goto L6;
            statusBar.appTransitionCancelled(displayId);
            return;
        }

        private /* synthetic */ void lambda$$2(int displayId) {
            StatusBarManagerInternal statusBar = this.this$0.getStatusBarManagerInternal();
            if (statusBar == null) goto L6;
            statusBar.appTransitionFinished(displayId);
            return;
        }

        @Override // com.android.server.wm.WindowManagerInternal.AppTransitionListener
        public void onAppTransitionPendingLocked() {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).post(this.mAppTransitionPending);
        }

        @Override // com.android.server.wm.WindowManagerInternal.AppTransitionListener
        public int onAppTransitionStartingLocked(final long statusBarAnimationStartTime, final long statusBarAnimationDuration) {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).post(new DisplayPolicy$2$$ExternalSyntheticLambda0(this, statusBarAnimationStartTime, statusBarAnimationDuration));
            return 0;
        }

        private /* synthetic */ void lambda$onAppTransitionStartingLocked$3(long statusBarAnimationStartTime, long statusBarAnimationDuration) {
            StatusBarManagerInternal statusBar = this.this$0.getStatusBarManagerInternal();
            if (statusBar == null) goto L6;
            statusBar.appTransitionStarting(DisplayPolicy.m9925$$Nest$fgetmContext(this.this$0).getDisplayId(), statusBarAnimationStartTime, statusBarAnimationDuration);
            return;
        }

        @Override // com.android.server.wm.WindowManagerInternal.AppTransitionListener
        public void onAppTransitionCancelledLocked(boolean keyguardGoingAwayCancelled) {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).post(this.mAppTransitionCancelled);
        }

        @Override // com.android.server.wm.WindowManagerInternal.AppTransitionListener
        public void onAppTransitionFinishedLocked(IBinder token) {
            DisplayPolicy.m9926$$Nest$fgetmHandler(this.this$0).post(this.mAppTransitionFinished);
        }
    }

    static class DecorInsets {
        private final DisplayContent mDisplayContent;
        private final Info[] mInfoForRotation;
        final Info mTmpInfo;

        private static class Cache {
            static final int ID_UPDATING_CONFIG = -1;
            static final int TYPE_REGULAR_BARS = 0;
            boolean mActive;
            final DecorInsets mDecorInsets;
            int mPreserveId;
            ArrayList<InsetsSource> mPreservedInsets;
            PrivacyIndicatorBounds mPrivacyIndicatorBounds;
            ArrayList<InsetsSource> mRegularBarsInsets;

            static {
                TYPE_REGULAR_BARS = WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars();
            }

            Cache(DisplayContent dc) {
                this.mDecorInsets = new DecorInsets(dc);
            }

            boolean canPreserve() {
                if (this.mPreserveId != (-1)) goto L5;
            L8:
                return true;
            L5:
                if (DecorInsets.m9946$$Nest$fgetmDisplayContent(this.mDecorInsets).mTransitionController.inTransition(this.mPreserveId) == true) goto L8;
                return false;
            }

            static ArrayList<InsetsSource> copyRegularBarInsets(InsetsState srcState) {
                ArrayList<InsetsSource> state = new ArrayList();
                int i = srcState.sourceSize() - 1;
            L3:
                if (i < 0) goto L9;
                InsetsSource source = srcState.sourceAt(i);
                if ((source.getType() & TYPE_REGULAR_BARS) == 0) goto L7;
                state.add(new InsetsSource(source));
            L7:
                i = i - 1;
                goto L3
            L9:
                return state;
            }
        }

        static class Info {
            final Rect mConfigFrame;
            final Rect mConfigInsets;
            private boolean mNeedUpdate;
            final Rect mNonDecorFrame;
            final Rect mNonDecorInsets;
            final Rect mOverrideConfigFrame;
            final Rect mOverrideConfigInsets;
            final Rect mOverrideNonDecorFrame;
            final Rect mOverrideNonDecorInsets;

            /* JADX INFO: renamed from: -$$Nest$fgetmNeedUpdate, reason: not valid java name */
            static /* bridge */ /* synthetic */ boolean m9948$$Nest$fgetmNeedUpdate(Info r0) {
                return r0.mNeedUpdate;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmNeedUpdate, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m9949$$Nest$fputmNeedUpdate(Info r0, boolean r1) {
                r0.mNeedUpdate = r1;
            }

            Info() {
                this.mNonDecorInsets = new Rect();
                this.mConfigInsets = new Rect();
                this.mOverrideConfigInsets = new Rect();
                this.mOverrideNonDecorInsets = new Rect();
                this.mNonDecorFrame = new Rect();
                this.mConfigFrame = new Rect();
                this.mOverrideConfigFrame = new Rect();
                this.mOverrideNonDecorFrame = new Rect();
                this.mNeedUpdate = true;
            }

            InsetsState update(DisplayContent dc, int rotation, int w, int h) {
                DisplayFrames df = new DisplayFrames();
                dc.updateDisplayFrames(df, rotation, w, h);
                dc.getDisplayPolicy().simulateLayoutDisplay(df);
                InsetsState insetsState = df.mInsetsState;
                Rect displayFrame = insetsState.getDisplayFrame();
                Insets decor = insetsState.calculateInsets(displayFrame, dc.mWmService.mDecorTypes, true);
                if (dc.mWmService.mConfigTypes != dc.mWmService.mDecorTypes) goto L5;
                Insets configInsets = decor;
            L7:
                if (dc.mWmService.mConfigTypes != dc.mWmService.mOverrideConfigTypes) goto L9;
                Insets overrideConfigInsets = configInsets;
            L11:
                if (dc.mWmService.mDecorTypes != dc.mWmService.mOverrideDecorTypes) goto L13;
                Insets overrideDecorInsets = decor;
            L14:
                this.mNonDecorInsets.set(decor.left, decor.top, decor.right, decor.bottom);
                this.mConfigInsets.set(configInsets.left, configInsets.top, configInsets.right, configInsets.bottom);
                this.mOverrideConfigInsets.set(overrideConfigInsets.left, overrideConfigInsets.top, overrideConfigInsets.right, overrideConfigInsets.bottom);
                this.mOverrideNonDecorInsets.set(overrideDecorInsets.left, overrideDecorInsets.top, overrideDecorInsets.right, overrideDecorInsets.bottom);
                this.mNonDecorFrame.set(displayFrame);
                this.mNonDecorFrame.inset(this.mNonDecorInsets);
                this.mConfigFrame.set(displayFrame);
                this.mConfigFrame.inset(this.mConfigInsets);
                this.mOverrideConfigFrame.set(displayFrame);
                this.mOverrideConfigFrame.inset(this.mOverrideConfigInsets);
                this.mOverrideNonDecorFrame.set(displayFrame);
                this.mOverrideNonDecorFrame.inset(this.mOverrideNonDecorInsets);
                this.mNeedUpdate = false;
                return insetsState;
            L13:
                overrideDecorInsets = insetsState.calculateInsets(displayFrame, dc.mWmService.mOverrideDecorTypes, true);
                goto L14
            L9:
                overrideConfigInsets = insetsState.calculateInsets(displayFrame, dc.mWmService.mOverrideConfigTypes, true);
                goto L11
            L5:
                configInsets = insetsState.calculateInsets(displayFrame, dc.mWmService.mConfigTypes, true);
                goto L7
            }

            void set(Info other) {
                this.mNonDecorInsets.set(other.mNonDecorInsets);
                this.mConfigInsets.set(other.mConfigInsets);
                this.mOverrideConfigInsets.set(other.mOverrideConfigInsets);
                this.mOverrideNonDecorInsets.set(other.mOverrideNonDecorInsets);
                this.mNonDecorFrame.set(other.mNonDecorFrame);
                this.mConfigFrame.set(other.mConfigFrame);
                this.mOverrideConfigFrame.set(other.mOverrideConfigFrame);
                this.mOverrideNonDecorFrame.set(other.mOverrideNonDecorFrame);
                this.mNeedUpdate = false;
            }

            public String toString() {
                StringBuilder tmpSb = new StringBuilder(32);
                return "{nonDecorInsets=" + this.mNonDecorInsets.toShortString(tmpSb) + ", overrideNonDecorInsets=" + this.mOverrideNonDecorInsets.toShortString(tmpSb) + ", configInsets=" + this.mConfigInsets.toShortString(tmpSb) + ", overrideConfigInsets=" + this.mOverrideConfigInsets.toShortString(tmpSb) + ", nonDecorFrame=" + this.mNonDecorFrame.toShortString(tmpSb) + ", overrideNonDecorFrame=" + this.mOverrideNonDecorFrame.toShortString(tmpSb) + ", configFrame=" + this.mConfigFrame.toShortString(tmpSb) + ", overrideConfigFrame=" + this.mOverrideConfigFrame.toShortString(tmpSb) + '}';
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDisplayContent, reason: not valid java name */
        static /* bridge */ /* synthetic */ DisplayContent m9946$$Nest$fgetmDisplayContent(DecorInsets r0) {
            return r0.mDisplayContent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInfoForRotation, reason: not valid java name */
        static /* bridge */ /* synthetic */ Info[] m9947$$Nest$fgetmInfoForRotation(DecorInsets r0) {
            return r0.mInfoForRotation;
        }

        DecorInsets(DisplayContent dc) {
            this.mInfoForRotation = new Info[4];
            this.mTmpInfo = new Info();
            this.mDisplayContent = dc;
            int i = this.mInfoForRotation.length - 1;
        L3:
            if (i < 0) goto L6;
            this.mInfoForRotation[i] = new Info();
            i = i - 1;
            goto L3
        }

        Info get(int rotation, int w, int h) {
            Info info = this.mInfoForRotation[rotation];
            if (Info.m9948$$Nest$fgetmNeedUpdate(info) == false) goto L5;
            info.update(this.mDisplayContent, rotation, w, h);
        L5:
            return info;
        }

        void invalidate() {
            Info[] r0 = this.mInfoForRotation;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            Info info = r0[r2];
            Info.m9949$$Nest$fputmNeedUpdate(info, true);
            r2 = r2 + 1;
            goto L3
        }

        void setTo(DecorInsets src) {
            int i = this.mInfoForRotation.length - 1;
        L3:
            if (i < 0) goto L6;
            this.mInfoForRotation[i].set(src.mInfoForRotation[i]);
            i = i - 1;
            goto L3
        }

        void dump(String prefix, PrintWriter pw) {
            int rotation = 0;
        L4:
            if (rotation >= this.mInfoForRotation.length) goto L7;
            Info info = this.mInfoForRotation[rotation];
            pw.println(prefix + Surface.rotationToString(rotation) + "=" + info);
            rotation = rotation + 1;
            goto L4
        }

        static boolean hasInsetsFrameDiff(InsetsState s1, InsetsState s2, int insetsTypes) {
            int insetsCount1 = 0;
            int i = s1.sourceSize() - 1;
        L3:
            if (i < 0) goto L14;
            InsetsSource source1 = s1.sourceAt(i);
            if ((source1.getType() & insetsTypes) == 0) goto L12;
            insetsCount1 = insetsCount1 + 1;
            InsetsSource source2 = s2.peekSource(source1.getId());
            if (source2 == null) goto L13;
            if (source2.getFrame().equals(source1.getFrame()) == true) goto L12;
        L13:
            return true;
        L12:
            i = i - 1;
            goto L3
        L14:
            int insetsCount2 = 0;
            int i2 = s2.sourceSize() - 1;
        L15:
            if (i2 < 0) goto L21;
            if ((s2.sourceAt(i2).getType() & insetsTypes) == 0) goto L19;
            insetsCount2 = insetsCount2 + 1;
        L19:
            i2 = i2 - 1;
            goto L15
        L21:
            if (insetsCount1 != insetsCount2) goto L33;
            return false;
        L33:
            return true;
        }
    }

    private class PolicyHandler extends Handler {
        final /* synthetic */ DisplayPolicy this$0;

        PolicyHandler(DisplayPolicy r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 4: goto L6;
                case 5: goto L5;
                default: goto L9;
            };
        L5:
            DisplayPolicy.m9936$$Nest$mdisablePointerLocation(this.this$0);
            return;
        L6:
            DisplayPolicy.m9937$$Nest$menablePointerLocation(this.this$0);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$0D3qSFTs4ZGrtzHlfTiLEIQETeU(DisplayPolicy r0, Consumer r1) {
        r0.lambda$callStatusBarSafely$9(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$77M0WC5DVTFJWkt-VSvKuBKWmLs, reason: not valid java name */
    public static /* synthetic */ void m9919$r8$lambda$77M0WC5DVTFJWktVSvKuBKWmLs(int r0, int r1, String r2, StatusBarManagerInternal r3) {
        lambda$updateSystemBarAttributes$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$8LdvEordfxTTSy9wu2U7CmjSry4(DisplayPolicy r0) {
        r0.lambda$notifyDisplayAddSystemDecorations$5();
    }

    /* JADX INFO: renamed from: $r8$lambda$AdJ1gMBLzNWLf1c9rz5iLY-Z5Po, reason: not valid java name */
    public static /* synthetic */ Integer m9920$r8$lambda$AdJ1gMBLzNWLf1c9rz5iLYZ5Po(DisplayFrames r0, WindowContainer r1, Rect r2) {
        return lambda$getImeSourceFrameProvider$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$BKTr9ZjdQgcFR5eJzDS_qFVcM9Q(DisplayPolicy r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ boolean $r8$lambda$GRfdgAecI7OT2glQOBoKxEYtuTw(Task r0) {
        return lambda$updateSystemBarsLw$10(r0);
    }

    public static /* synthetic */ void $r8$lambda$NZzAQnlrSr5c31KvymgfhHHJdsA(DisplayPolicy r0) {
        r0.updateForceShowNavBarSettings();
    }

    /* JADX INFO: renamed from: $r8$lambda$OYiNZTKrLZN0J-F0iJMDMc00nbQ, reason: not valid java name */
    public static /* synthetic */ void m9921$r8$lambda$OYiNZTKrLZN0JF0iJMDMc00nbQ(int r0, int r1, AppearanceRegion[] r2, boolean r3, int r4, int r5, String r6, LetterboxDetails[] r7, StatusBarManagerInternal r8) {
        lambda$updateSystemBarAttributes$8(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Integer $r8$lambda$WrdAsexcVfs8v_wSDSxSFmYy5EE(WindowState r0, int r1, int r2, DisplayFrames r3, WindowContainer r4, Rect r5) {
        return lambda$getFrameProvider$1(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$cwQIVBNfOd9lUcZu_4zrQu6oD1s(DisplayPolicy r0, int r1, boolean r2, WindowState r3, StatusBarManagerInternal r4) {
        r0.lambda$updateSystemBarsLw$11(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$ha0oEYT1NWF3FgSX1TFp2tFnhcU(DisplayPolicy r0) {
        r0.lambda$notifyDisplayRemoveSystemDecorations$6();
    }

    /* JADX INFO: renamed from: $r8$lambda$qs4Rqs-Mm2GUBkf9Pjp3ZXa02kk, reason: not valid java name */
    public static /* synthetic */ void m9922$r8$lambda$qs4RqsMm2GUBkf9Pjp3ZXa02kk(DisplayPolicy r0, boolean r1, int r2, boolean r3, boolean r4) {
        r0.lambda$notifyDisplayAddSystemDecorations$4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$v8wJWTcVhOMmJgm9Sq80-TCQWoU, reason: not valid java name */
    public static /* synthetic */ void m9923$r8$lambda$v8wJWTcVhOMmJgm9Sq80TCQWoU(DisplayPolicy r0) {
        r0.lambda$onOverlayChanged$3();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBottomGestureHost, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m9924$$Nest$fgetmBottomGestureHost(DisplayPolicy r0) {
        return r0.mBottomGestureHost;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9925$$Nest$fgetmContext(DisplayPolicy r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9926$$Nest$fgetmHandler(DisplayPolicy r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIslandWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m9927$$Nest$fgetmIslandWindow(DisplayPolicy r0) {
        return r0.mIslandWindow;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLeftGestureHost, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m9928$$Nest$fgetmLeftGestureHost(DisplayPolicy r0) {
        return r0.mLeftGestureHost;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9929$$Nest$fgetmLock(DisplayPolicy r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNavigationBarAlwaysShowOnSideGesture, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9930$$Nest$fgetmNavigationBarAlwaysShowOnSideGesture(DisplayPolicy r0) {
        return r0.mNavigationBarAlwaysShowOnSideGesture;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRightGestureHost, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m9931$$Nest$fgetmRightGestureHost(DisplayPolicy r0) {
        return r0.mRightGestureHost;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemGestures, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemGesturesPointerEventListener m9932$$Nest$fgetmSystemGestures(DisplayPolicy r0) {
        return r0.mSystemGestures;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTopGestureHost, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m9933$$Nest$fgetmTopGestureHost(DisplayPolicy r0) {
        return r0.mTopGestureHost;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsPerfBoostFlingAcquired, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9934$$Nest$fputmIsPerfBoostFlingAcquired(DisplayPolicy r0, boolean r1) {
        r0.mIsPerfBoostFlingAcquired = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingPanicGestureUptime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9935$$Nest$fputmPendingPanicGestureUptime(DisplayPolicy r0, long r1) {
        r0.mPendingPanicGestureUptime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdisablePointerLocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9936$$Nest$mdisablePointerLocation(DisplayPolicy r0) {
        r0.disablePointerLocation();
    }

    /* JADX INFO: renamed from: -$$Nest$menablePointerLocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9937$$Nest$menablePointerLocation(DisplayPolicy r0) {
        r0.enablePointerLocation();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetActivityName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9938$$Nest$mgetActivityName(DisplayPolicy r0) {
        return r0.getActivityName();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAppPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9939$$Nest$mgetAppPackageName(DisplayPolicy r0) {
        return r0.getAppPackageName();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAppPackageNameByDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9940$$Nest$mgetAppPackageNameByDisplayId(DisplayPolicy r0, int r1) {
        return r0.getAppPackageNameByDisplayId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misTopAppGame, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9941$$Nest$misTopAppGame(DisplayPolicy r0, String r1, BoostFramework r2) {
        return r0.isTopAppGame(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSCROLL_BOOST_SS_ENABLE, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9942$$Nest$sfgetSCROLL_BOOST_SS_ENABLE() {
        return SCROLL_BOOST_SS_ENABLE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSILKY_SCROLLS_ENABLE, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9943$$Nest$sfgetSILKY_SCROLLS_ENABLE() {
        return SILKY_SCROLLS_ENABLE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSILKY_SCROLLS_LITE_ENABLE, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9944$$Nest$sfgetSILKY_SCROLLS_LITE_ENABLE() {
        return SILKY_SCROLLS_LITE_ENABLE;
    }

    static {
        SHOW_TYPES_FOR_SWIPE = WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars();
        SHOW_TYPES_FOR_PANIC = WindowInsets.Type.navigationBars();
        USE_CACHED_INSETS_FOR_DISPLAY_SWITCH = SystemProperties.getBoolean("persist.wm.debug.cached_insets_switch", true);
        SCROLL_BOOST_SS_ENABLE = false;
        SILKY_SCROLLS_ENABLE = false;
        SILKY_SCROLLS_LITE_ENABLE = false;
        isLowRAM = false;
        sTmpRect = new Rect();
        sTmpRect2 = new Rect();
        sTmpDisplayCutoutSafe = new Rect();
        sTmpClientFrames = new ClientWindowFrames();
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

    private String getAppPackageName() {
        ActivityManager.RunningTaskInfo rti = (ActivityManager.RunningTaskInfo) ActivityTaskManager.getService().getTasks(1, false, false, -1).get(0);     // Catch: Exception -> L4
        String currentPackage = rti.topActivity.getPackageName();     // Catch: Exception -> L4
        return currentPackage;
    L5:
        return null;
    }

    private String getAppPackageNameByDisplayId(int displayId) {
        ActivityManager.RunningTaskInfo rti = (ActivityManager.RunningTaskInfo) ActivityTaskManager.getService().getTasks(1, false, false, displayId).get(0);     // Catch: Exception -> L4
        String currentPackage = rti.topActivity.getPackageName();     // Catch: Exception -> L4
        return currentPackage;
    L5:
        return null;
    }

    private String getActivityName() {
        ActivityManager.RunningTaskInfo rti = (ActivityManager.RunningTaskInfo) ActivityTaskManager.getService().getTasks(1, false, false, -1).get(0);     // Catch: Exception -> L4
        String activityName = rti.topActivity.flattenToShortString();     // Catch: Exception -> L4
        return activityName;
    L5:
        return null;
    }

    private boolean isTopAppGame(String currentPackage, BoostFramework BoostType) {
        boolean r2 = true;
        if (isLowRAM == false) goto L20;
        ApplicationInfo ai = this.mContext.getPackageManager().getApplicationInfo(currentPackage, 0);     // Catch: Exception -> L13
        if (ai != null) goto L7;
        return false;
    L7:
        if (ai.category == 0) goto L15;
        if ((ai.flags & 33554432) == 33554432) goto L15;
        r2 = false;
    L15:
        boolean isGame = r2;
        return isGame;
    L18:
        return false;
    L20:
        if (BoostType.perfGetFeedback(5633, currentPackage) == 2) goto L23;
        r2 = false;
    L23:
        boolean isGame2 = r2;
        return isGame2;
    }

    DisplayPolicy(WindowManagerService service, DisplayContent displayContent) {
        this.mObricExt = (IObricDisplayPolicy) ObricImplFactory.getImpl(IObricDisplayPolicy.class, new Object[]{this});
        ScreenshotHelper r0 = null;
        this.mPerfBoostDrag = null;
        this.mPerfBoostFling = null;
        this.mPerfBoostPrefling = null;
        this.mPerf = new BoostFramework();
        this.mServiceAcquireLock = new Object();
        this.mLidState = -1;
        this.mDockMode = 0;
        this.mStatusBar = null;
        this.mIslandWindow = null;
        this.mNavigationBar = null;
        this.mHasBottomNavigationBar = true;
        this.mInsetsSourceWindowsExceptIme = new ArraySet();
        this.mSystemBarColorApps = new ArraySet();
        this.mRelaunchingSystemBarColorApps = new ArraySet();
        this.mStatusBarAppearanceRegionList = new ArrayList();
        this.mStatusBarBackgroundWindows = new ArrayList();
        this.mLetterboxDetails = new ArrayList();
        this.mLastRequestedVisibleTypes = WindowInsets.Type.defaultVisible();
        this.mStatusBarColorCheckedBounds = new Rect();
        this.mStatusBarBackgroundCheckedBounds = new Rect();
        this.mLastFocusIsFullscreen = false;
        this.mWindowLayout = new WindowLayout();
        this.mNavBarOpacityMode = 0;
        this.mHiddenNavPanic = new AnonymousClass3(this);
        this.mExt = (IExtDisplayPolicy) ExtImplFactory.getImpl(IExtDisplayPolicy.class, new Object[]{this});
        this.mService = service;
        if (displayContent.isDefaultDisplay == false) goto L5;
        Context r3 = service.mContext;
    L6:
        this.mContext = r3;
        if (displayContent.isDefaultDisplay == false) goto L9;
        Context r4 = service.mAtmService.getUiContext();
    L10:
        this.mUiContext = r4;
        this.mDisplayContent = displayContent;
        this.mDecorInsets = new DecorInsets(displayContent);
        this.mLock = service.getWindowManagerLock();
        int displayId = displayContent.getDisplayId();
        Resources r = this.mContext.getResources();
        this.mCarDockEnablesAccelerometer = r.getBoolean(R.bool.config_carrier_vt_available);
        this.mDeskDockEnablesAccelerometer = r.getBoolean(R.bool.config_device_respects_hold_carrier_config);
        if (r.getBoolean(R.bool.config_remoteInsetsControllerControlsSystemBars) == true) goto L13;
    L16:
        boolean r5 = true;
    L17:
        this.mCanSystemBarsBeShownByUser = r5;
        this.mPanicThresholdMs = r.getInteger(R.integer.config_letterboxActivityCornersRadius);
        this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        if (displayContent.isDefaultDisplay == true) goto L21;
        this.mAwake = true;
        this.mScreenOnEarly = true;
        this.mScreenOnFully = true;
    L21:
        if (this.mPerf == null) goto L23;
        SCROLL_BOOST_SS_ENABLE = Boolean.parseBoolean(this.mPerf.perfGetProp("vendor.perf.gestureflingboost.enable", "false"));
        SILKY_SCROLLS_ENABLE = Boolean.parseBoolean(this.mPerf.perfGetProp("ro.vendor.perf.ss", "false"));
        SILKY_SCROLLS_LITE_ENABLE = Boolean.parseBoolean(this.mPerf.perfGetProp("ro.vendor.perf.silkyscrolls_lite", "false"));
    L23:
        isLowRAM = SystemProperties.getBoolean("ro.config.low_ram", false);
        Looper looper = UiThread.getHandler().getLooper();
        this.mHandler = new PolicyHandler(this, looper);
        if (ViewRootImpl.CLIENT_TRANSIENT == true) goto L26;
        SystemGesturesPointerEventListener.Callbacks gesturesPointerEventCallbacks = new AnonymousClass1(this, displayContent);
        this.mSystemGestures = new SystemGesturesPointerEventListener(this.mUiContext, this.mHandler, gesturesPointerEventCallbacks);
        displayContent.registerPointerEventListener(this.mSystemGestures);
    L26:
        this.mAppTransitionListener = new AnonymousClass2(this, displayId, displayId);
        displayContent.mTransitionController.registerLegacyListener(this.mAppTransitionListener);
        if (displayContent.isDefaultDisplay == false) goto L30;
        r0 = new ScreenshotHelper(this.mContext);
    L30:
        this.mScreenshotHelper = r0;
        if (this.mDisplayContent.isDefaultDisplay == false) goto L39;
        this.mHasStatusBar = true;
        this.mHasNavigationBar = this.mContext.getResources().getBoolean(R.bool.config_skipActivityRelaunchWhenDocking);
        String navBarOverride = SystemProperties.get("qemu.hw.mainkeys");
        if ("1".equals(navBarOverride) == false) goto L36;
        this.mHasNavigationBar = false;
    L40:
        this.mRefreshRatePolicy = new RefreshRatePolicy(this.mService, this.mDisplayContent.getDisplayInfo(), this.mService.mHighRefreshRateDenylist);
        this.mGestureNavigationSettingsObserver = new GestureNavigationSettingsObserver(this.mHandler, BackgroundThread.getHandler(), this.mContext, new DisplayPolicy$$ExternalSyntheticLambda2(this));
        Handler r1 = this.mHandler;
        final GestureNavigationSettingsObserver r2 = this.mGestureNavigationSettingsObserver;
        r2.getClass();
        r1.post(new DisplayPolicy$$ExternalSyntheticLambda3(r2));
        this.mForceShowNavBarSettingsObserver = new ForceShowNavBarSettingsObserver(this.mHandler, this.mContext);
        this.mForceShowNavBarSettingsObserver.setOnChangeRunnable(new DisplayPolicy$$ExternalSyntheticLambda4(this));
        this.mForceShowNavigationBarEnabled = this.mForceShowNavBarSettingsObserver.isEnabled();
        Handler r6 = this.mHandler;
        final ForceShowNavBarSettingsObserver r7 = this.mForceShowNavBarSettingsObserver;
        r7.getClass();
        r6.post(new DisplayPolicy$$ExternalSyntheticLambda5(r7));
        this.mExt.onInit(this.mDisplayContent, this.mContext, this.mHandler);
        this.mObricExt.onInit(this.mDisplayContent, this.mContext, this.mHandler);
        return;
    L36:
        if ("0".equals(navBarOverride) == false) goto L40;
        this.mHasNavigationBar = true;
        goto L40
    L39:
        this.mHasStatusBar = false;
        this.mHasNavigationBar = this.mDisplayContent.isSystemDecorationsSupported();
        goto L40
    L13:
        if (r.getBoolean(R.bool.config_safe_sound_dosage_enabled) == true) goto L16;
        r5 = false;
        goto L17
    L9:
        r4 = service.mAtmService.mSystemThread.getSystemUiContext(displayContent.getDisplayId());
        goto L10
    L5:
        r3 = service.mContext.createDisplayContext(displayContent.getDisplay());
        goto L6
    }

    private /* synthetic */ void lambda$new$0() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onConfigurationChanged();     // Catch: Throwable -> L7
        if (ViewRootImpl.CLIENT_TRANSIENT == true) goto L9;
        this.mSystemGestures.onConfigurationChanged();     // Catch: Throwable -> L7
    L9:
        this.mDisplayContent.updateSystemGestureExclusion();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateForceShowNavBarSettings() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mForceShowNavigationBarEnabled = this.mForceShowNavBarSettingsObserver.isEnabled();     // Catch: Throwable -> L7
        updateSystemBarAttributes();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void systemReady() {
        if (ViewRootImpl.CLIENT_TRANSIENT == true) goto L6;
        this.mSystemGestures.systemReady();
    L6:
        if (this.mService.mPointerLocationEnabled == false) goto L9;
        setPointerLocationEnabled(true);
        return;
    }

    private int getDisplayId() {
        return this.mDisplayContent.getDisplayId();
    }

    public void setHdmiPlugged(boolean plugged) {
        setHdmiPlugged(plugged, false);
    }

    public void setHdmiPlugged(boolean plugged, boolean force) {
        if (force == false) goto L4;
    L5:
        this.mHdmiPlugged = plugged;
        this.mService.updateRotation(true, true);
        Intent intent = new Intent("android.intent.action.HDMI_PLUGGED");
        intent.addFlags(67108864);
        intent.putExtra("state", plugged);
        this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);
        return;
    L4:
        if (this.mHdmiPlugged != plugged) goto L5;
    }

    boolean isHdmiPlugged() {
        return this.mHdmiPlugged;
    }

    boolean isCarDockEnablesAccelerometer() {
        return this.mCarDockEnablesAccelerometer;
    }

    boolean isDeskDockEnablesAccelerometer() {
        return this.mDeskDockEnablesAccelerometer;
    }

    public void setPersistentVrModeEnabled(boolean persistentVrModeEnabled) {
        this.mPersistentVrModeEnabled = persistentVrModeEnabled;
    }

    public boolean isPersistentVrModeEnabled() {
        return this.mPersistentVrModeEnabled;
    }

    public void setDockMode(int dockMode) {
        this.mDockMode = dockMode;
    }

    public int getDockMode() {
        return this.mDockMode;
    }

    public boolean hasNavigationBar() {
        return this.mHasNavigationBar;
    }

    void updateHasNavigationBarIfNeeded() {
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == true) goto L6;
        Slog.e(TAG, "mHasNavigationBar shouldn't be updated when the flag is off.");
    L6:
        if (this.mDisplayContent.isDefaultDisplay == false) goto L8;
        return;
    L8:
        this.mHasNavigationBar = this.mDisplayContent.isSystemDecorationsSupported();
    }

    public boolean hasStatusBar() {
        return this.mHasStatusBar;
    }

    boolean hasSideGestures() {
        if (this.mHasNavigationBar == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mLeftGestureInset <= 0) goto L7;
    L8:
        return true;
    L7:
        if (this.mRightGestureInset <= 0) goto L9;
        goto L8
    }

    public boolean navigationBarCanMove() {
        return this.mNavigationBarCanMove;
    }

    public void setLidState(int lidState) {
        this.mLidState = lidState;
    }

    public int getLidState() {
        return this.mLidState;
    }

    private void onDisplaySwitchFinished() {
        this.mDisplayContent.mDisplayUpdater.onDisplaySwitching(false);
    }

    public void setAwake(boolean awake) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (awake != this.mAwake) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mAwake = awake;     // Catch: Throwable -> L8
        if (this.mDisplayContent.isDefaultDisplay == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        if (awake == false) goto L17;
        this.mService.mAtmService.mVisibleDozeUiProcess = null;     // Catch: Throwable -> L8
    L21:
        this.mService.mAtmService.mKeyguardController.updateDeferTransitionForAod(this.mAwake);     // Catch: Throwable -> L8
        if (awake == true) goto L30;
        onDisplaySwitchFinished();     // Catch: Throwable -> L8
        if (this.mScreenOnEarly == true) goto L30;
        if (this.mScreenOnFully == true) goto L30;
        if (this.mDisplayContent.isSleeping() == true) goto L30;
        Slog.w(TAG, "Late acquire sleep token for " + this.mDisplayContent);     // Catch: Throwable -> L8
        this.mService.mRoot.mDisplayOffTokenAcquirer.acquire(this.mDisplayContent.mDisplayId);     // Catch: Throwable -> L8
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        if (this.mScreenOnFully == false) goto L21;
        if (this.mNotificationShade == null) goto L21;
        this.mService.mAtmService.mVisibleDozeUiProcess = this.mNotificationShade.getProcess();     // Catch: Throwable -> L8
        goto L21
    }

    public boolean isAwake() {
        return this.mAwake;
    }

    public boolean isScreenOnEarly() {
        return this.mScreenOnEarly;
    }

    public boolean isScreenOnFully() {
        return this.mScreenOnFully;
    }

    public boolean isKeyguardDrawComplete() {
        return this.mKeyguardDrawComplete;
    }

    public boolean isWindowManagerDrawComplete() {
        return this.mWindowManagerDrawComplete;
    }

    public boolean isForceShowNavigationBarEnabled() {
        return this.mForceShowNavigationBarEnabled;
    }

    public WindowManagerPolicy.ScreenOnListener getScreenOnListener() {
        return this.mScreenOnListener;
    }

    boolean isRemoteInsetsControllerControllingSystemBars() {
        return this.mRemoteInsetsControllerControlsSystemBars;
    }

    void setRemoteInsetsControllerControlsSystemBars(boolean remoteInsetsControllerControlsSystemBars) {
        this.mRemoteInsetsControllerControlsSystemBars = remoteInsetsControllerControlsSystemBars;
    }

    public void screenTurningOn(WindowManagerPolicy.ScreenOnListener screenOnListener) {
        WindowProcessController visibleDozeUiProcess = null;
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mService.mRoot.mDisplayOffTokenAcquirer.release(this.mDisplayContent.mDisplayId);     // Catch: Throwable -> L9
        this.mScreenOnEarly = true;     // Catch: Throwable -> L9
        this.mScreenOnFully = false;     // Catch: Throwable -> L9
        this.mKeyguardDrawComplete = false;     // Catch: Throwable -> L9
        this.mWindowManagerDrawComplete = false;     // Catch: Throwable -> L9
        this.mScreenOnListener = screenOnListener;     // Catch: Throwable -> L9
        if (this.mAwake == false) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (visibleDozeUiProcess == null) goto L19;
        Trace.instant(32, "screenTurnedOnWhileDozing");
        this.mService.mAtmService.setProcessAnimatingWhileDozing(visibleDozeUiProcess);
        return;
    L19:
        return;
    L7:
        if (this.mNotificationShade == null) goto L11;
        visibleDozeUiProcess = this.mNotificationShade.getProcess();     // Catch: Throwable -> L9
        this.mService.mAtmService.mVisibleDozeUiProcess = visibleDozeUiProcess;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void screenTurnedOn() {
        onDisplaySwitchFinished();
    }

    public void screenTurnedOff(boolean acquireSleepToken) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (acquireSleepToken == true) goto L13;
    L8:
        this.mScreenOnEarly = false;     // Catch: Throwable -> L6
        this.mScreenOnFully = false;     // Catch: Throwable -> L6
        this.mKeyguardDrawComplete = false;     // Catch: Throwable -> L6
        this.mWindowManagerDrawComplete = false;     // Catch: Throwable -> L6
        this.mScreenOnListener = null;     // Catch: Throwable -> L6
        this.mService.mAtmService.mVisibleDozeUiProcess = null;     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L13:
        this.mService.mRoot.mDisplayOffTokenAcquirer.acquire(this.mDisplayContent.mDisplayId);     // Catch: Throwable -> L6
        goto L8
    }

    public boolean finishKeyguardDrawn() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mScreenOnEarly == false) goto L14;
        if (this.mKeyguardDrawComplete == true) goto L14;
        this.mKeyguardDrawComplete = true;     // Catch: Throwable -> L12
        this.mWindowManagerDrawComplete = false;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    public boolean finishWindowsDrawn() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mScreenOnEarly == false) goto L14;
        if (this.mWindowManagerDrawComplete == true) goto L14;
        this.mWindowManagerDrawComplete = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    public boolean finishScreenTurningOn() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[0] == false) goto L10;
        boolean protoLogParam0 = this.mAwake;     // Catch: Throwable -> L7
        boolean protoLogParam1 = this.mScreenOnEarly;     // Catch: Throwable -> L7
        boolean protoLogParam2 = this.mScreenOnFully;     // Catch: Throwable -> L7
        boolean protoLogParam3 = this.mKeyguardDrawComplete;     // Catch: Throwable -> L7
        boolean protoLogParam4 = this.mWindowManagerDrawComplete;     // Catch: Throwable -> L7
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, -6228339285356824882L, 1023, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), Boolean.valueOf(protoLogParam4)});     // Catch: Throwable -> L7
    L10:
        if (this.mScreenOnFully == true) goto L26;
        if (this.mScreenOnEarly == false) goto L26;
        if (this.mWindowManagerDrawComplete == false) goto L26;
        if (this.mAwake == false) goto L21;
        if (this.mKeyguardDrawComplete == false) goto L26;
    L21:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[2] == false) goto L23;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, -6028033043540330282L, 0, null);     // Catch: Throwable -> L7
    L23:
        this.mScreenOnListener = null;     // Catch: Throwable -> L7
        this.mScreenOnFully = true;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return true;
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return false;
    }

    public void adjustWindowParamsLw(WindowState win, WindowManager.LayoutParams attrs) {
        switch(attrs.type) {
            case 1: goto L16;
            case 2005: goto L8;
            case 2006: goto L6;
            case 2013: goto L5;
            case 2015: goto L6;
            default: goto L29;
        };
    L5:
        attrs.layoutInDisplayCutoutMode = 3;
        goto L29
    L6:
        attrs.flags |= 24;
        attrs.flags &= -262145;
        goto L29
    L8:
        if (attrs.hideTimeoutMilliseconds >= 0) goto L10;
    L11:
        attrs.hideTimeoutMilliseconds = 4100;
    L12:
        attrs.hideTimeoutMilliseconds = this.mAccessibilityManager.getRecommendedTimeoutMillis((int) attrs.hideTimeoutMilliseconds, 2);
        attrs.flags |= 16;
        if (win.mSession.mCanAddInternalSystemWindow == true) goto L29;
        attrs.windowAnimations = R.style.Animation.Toast;
        goto L29
    L10:
        if (attrs.hideTimeoutMilliseconds <= 4100) goto L12;
    L16:
        if (attrs.isFullscreen() == false) goto L29;
        if (win.mActivityRecord == null) goto L29;
        if (win.mActivityRecord.fillsParent() == false) goto L29;
        if ((attrs.privateFlags & 32768) == 0) goto L29;
        if (attrs.getFitInsetsTypes() == 0) goto L29;
        throw new IllegalArgumentException("Illegal attributes: Main window of " + win.mActivityRecord.getName() + " that isn't translucent trying to fit insets. fitInsetsTypes=" + WindowInsets.Type.toString(attrs.getFitInsetsTypes()));
    L29:
        if ((attrs.insetsFlags.appearance & 512) == 0) goto L32;
        attrs.insetsFlags.appearance |= 16;
    L32:
        if (WindowManager.LayoutParams.isSystemAlertWindowType(attrs.type) == false) goto L41;
        float maxOpacity = this.mService.mMaximumObscuringOpacityForTouch;
        if (attrs.alpha <= maxOpacity) goto L41;
        if ((attrs.flags & 16) == 0) goto L41;
        if (win.isTrustedOverlay() == true) goto L41;
        Slog.w(TAG, String.format("App %s has a system alert window (type = %d) with FLAG_NOT_TOUCHABLE and LayoutParams.alpha = %.2f > %.2f, setting alpha to %.2f to let touches pass through (if this is isn't desirable, remove flag FLAG_NOT_TOUCHABLE).", new Object[]{attrs.packageName, Integer.valueOf(attrs.type), Float.valueOf(attrs.alpha), Float.valueOf(maxOpacity), Float.valueOf(maxOpacity)}));
        attrs.alpha = maxOpacity;
        win.mWinAnimator.mAlpha = maxOpacity;
    L41:
        if (win.mSession.mCanSetUnrestrictedGestureExclusion == true) goto L43;
        attrs.privateFlags &= -33;
    L43:
        this.mExt.adjustWindowParamsLw(win, attrs);
    }

    public void setDropInputModePolicy(WindowState win, WindowManager.LayoutParams attrs) {
        if (attrs.type == 2005) goto L5;
        return;
    L5:
        if ((attrs.privateFlags & 536870912) != 0) goto L9;
        this.mService.mTransactionFactory.get().setDropInputMode(win.getSurfaceControl(), 1).apply();
        return;
    }

    int validateAddingWindowLw(WindowManager.LayoutParams attrs, int callingPid, int callingUid) {
        if ((attrs.privateFlags & 536870912) == 0) goto L6;
        this.mContext.enforcePermission("android.permission.INTERNAL_SYSTEM_WINDOW", callingPid, callingUid, "DisplayPolicy");
    L6:
        if ((attrs.privateFlags & Integer.MIN_VALUE) == 0) goto L9;
        this.mContext.enforcePermission("android.permission.MANAGE_ACTIVITY_TASKS", callingPid, callingUid, "DisplayPolicy");
    L9:
        if (this.mService.isCallerVirtualDeviceOwner(this.mDisplayContent.getDisplayId(), callingUid) == true) goto L11;
    L13:
        String systemUiPermission = "android.permission.STATUS_BAR_SERVICE";
    L15:
        switch(attrs.type) {
            case 2000: goto L30;
            case 2014: goto L28;
            case 2017: goto L27;
            case 2019: goto L22;
            case 2024: goto L27;
            case 2033: goto L27;
            case 2040: goto L17;
            case 2041: goto L27;
            default: goto L36;
        };
    L17:
        this.mContext.enforcePermission(systemUiPermission, callingPid, callingUid, "DisplayPolicy");
        if (this.mNotificationShade == null) goto L36;
        if (this.mNotificationShade.isAlive() == false) goto L36;
        return -7;
    L22:
        this.mContext.enforcePermission(systemUiPermission, callingPid, callingUid, "DisplayPolicy");
        if (this.mNavigationBar == null) goto L36;
        if (this.mNavigationBar.isAlive() == false) goto L36;
        return -7;
    L27:
        this.mContext.enforcePermission(systemUiPermission, callingPid, callingUid, "DisplayPolicy");
        goto L36
    L28:
        return -10;
    L30:
        this.mContext.enforcePermission(systemUiPermission, callingPid, callingUid, "DisplayPolicy");
        if (this.mStatusBar == null) goto L36;
        if (this.mStatusBar.isAlive() == false) goto L36;
        return -7;
    L36:
        if (attrs.providedInsets != null) goto L38;
        return 0;
    L38:
        if (this.mService.mAtmService.isCallerRecents(callingUid) == true) goto L43;
        this.mContext.enforcePermission(systemUiPermission, callingPid, callingUid, "DisplayPolicy");
        return 0;
    L43:
        return 0;
    L11:
        if (this.mDisplayContent.isTrusted() == false) goto L13;
        systemUiPermission = "android.permission.CREATE_VIRTUAL_DEVICE";
        goto L15
    }

    void addWindowLw(WindowState win, WindowManager.LayoutParams attrs) {
        switch(attrs.type) {
            case 2000: goto L8;
            case 2019: goto L7;
            case 2040: goto L6;
            case 2998: goto L5;
            default: goto L10;
        };
    L5:
        this.mIslandWindow = win;
        goto L10
    L6:
        this.mNotificationShade = win;
        goto L10
    L7:
        this.mNavigationBar = win;
        goto L10
    L8:
        this.mStatusBar = win;
    L10:
        if ((attrs.privateFlags & 131072) == 0) goto L13;
        this.mImmersiveConfirmationWindowExists = true;
    L13:
        if (attrs.providedInsets == null) goto L24;
        int i = attrs.providedInsets.length - 1;
    L15:
        if (i < 0) goto L24;
        InsetsFrameProvider provider = attrs.providedInsets[i];
        TriFunction<DisplayFrames, WindowContainer, Rect, Integer> frameProvider = getFrameProvider(win, i, -1);
        InsetsFrameProvider.InsetsSizeOverride[] overrides = provider.getInsetsSizeOverrides();
        if (overrides == null) goto L22;
        SparseArray<TriFunction<DisplayFrames, WindowContainer, Rect, Integer>> overrideProviders = new SparseArray();
        int j = overrides.length - 1;
    L19:
        if (j < 0) goto L23;
        overrideProviders.put(overrides[j].getWindowType(), getFrameProvider(win, i, j));
        j = j - 1;
    L23:
        InsetsSourceProvider sourceProvider = this.mDisplayContent.getInsetsStateController().getOrCreateSourceProvider(provider.getId(), provider.getType());
        sourceProvider.getSource().setFlags(provider.getFlags());
        sourceProvider.setWindowContainer(win, frameProvider, overrideProviders);
        this.mInsetsSourceWindowsExceptIme.add(win);
        i = i - 1;
        goto L15
    L22:
        overrideProviders = null;
    L24:
        this.mExt.onAddWindowLw(win, attrs);
    }

    private static TriFunction<DisplayFrames, WindowContainer, Rect, Integer> getFrameProvider(final WindowState win, final int index, final int overrideIndex) {
        return new DisplayPolicy$$ExternalSyntheticLambda0(win, index, overrideIndex);
    }

    private static /* synthetic */ Integer lambda$getFrameProvider$1(WindowState win, int index, int overrideIndex, DisplayFrames displayFrames, WindowContainer windowContainer, Rect inOutFrame) {
        WindowManager.LayoutParams lp = win.mAttrs.forRotation(displayFrames.mRotation);
        InsetsFrameProvider ifp = lp.providedInsets[index];
        Rect displayFrame = displayFrames.mUnrestricted;
        Rect safe = displayFrames.mDisplayCutoutSafe;
        boolean extendByCutout = false;
        switch(ifp.getSource()) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L14;
        };
    L5:
        inOutFrame.set(ifp.getArbitraryRectangle());
        goto L14
    L11:
        inOutFrame.set(windowContainer.getBounds());
        goto L14
    L12:
        inOutFrame.set(displayFrame);
        goto L14
    L7:
        if ((lp.privateFlags & 4096) == 0) goto L9;
        boolean r5 = true;
    L10:
        extendByCutout = r5;
        goto L14
    L9:
        r5 = false;
    L14:
        if (overrideIndex != (-1)) goto L16;
        Insets insetsSize = ifp.getInsetsSize();
    L18:
        if (ifp.getMinimalInsetsSizeInDisplayCutoutSafe() == null) goto L20;
        sTmpRect2.set(inOutFrame);
    L20:
        calculateInsetsFrame(inOutFrame, insetsSize);
        if (extendByCutout == false) goto L25;
        if (insetsSize == null) goto L25;
        WindowLayout.extendFrameByCutout(safe, displayFrame, inOutFrame, sTmpRect);
    L25:
        if (ifp.getMinimalInsetsSizeInDisplayCutoutSafe() == null) goto L30;
        calculateInsetsFrame(sTmpRect2, ifp.getMinimalInsetsSizeInDisplayCutoutSafe());
        WindowLayout.extendFrameByCutout(safe, displayFrame, sTmpRect2, sTmpRect);
        if (sTmpRect2.contains(inOutFrame) == false) goto L30;
        inOutFrame.set(sTmpRect2);
    L30:
        return Integer.valueOf(ifp.getFlags());
    L16:
        insetsSize = ifp.getInsetsSizeOverrides()[overrideIndex].getInsetsSize();
        goto L18
    }

    private static void calculateInsetsFrame(Rect inOutFrame, Insets insetsSize) {
        if (insetsSize != null) goto L5;
        return;
    L5:
        if (insetsSize.left == 0) goto L8;
        inOutFrame.right = inOutFrame.left + insetsSize.left;
        return;
    L8:
        if (insetsSize.top == 0) goto L11;
        inOutFrame.bottom = inOutFrame.top + insetsSize.top;
        return;
    L11:
        if (insetsSize.right == 0) goto L14;
        inOutFrame.left = inOutFrame.right - insetsSize.right;
        return;
    L14:
        if (insetsSize.bottom == 0) goto L16;
        inOutFrame.top = inOutFrame.bottom - insetsSize.bottom;
        return;
    L16:
        inOutFrame.setEmpty();
    }

    TriFunction<DisplayFrames, WindowContainer, Rect, Integer> getImeSourceFrameProvider() {
        return new DisplayPolicy$$ExternalSyntheticLambda16();
    }

    private static /* synthetic */ Integer lambda$getImeSourceFrameProvider$2(DisplayFrames displayFrames, WindowContainer windowContainer, Rect inOutFrame) {
        WindowState windowState = windowContainer.asWindowState();
        if (windowState == null) goto L7;
        inOutFrame.inset(windowState.mGivenContentInsets);
        return 0;
    L7:
        throw new IllegalArgumentException("IME insets must be provided by a window.");
    }

    void removeWindowLw(WindowState win) {
        if (this.mStatusBar != win) goto L6;
        this.mStatusBar = null;
    L12:
        if (this.mIslandWindow != win) goto L15;
        this.mIslandWindow = null;
    L15:
        if (this.mLastFocusedWindow != win) goto L18;
        this.mLastFocusedWindow = null;
    L18:
        if (win.hasInsetsSourceProvider() == false) goto L22;
        SparseArray<InsetsSourceProvider> providers = win.getInsetsSourceProviders();
        InsetsStateController controller = this.mDisplayContent.getInsetsStateController();
        int index = providers.size() - 1;
    L20:
        if (index < 0) goto L22;
        InsetsSourceProvider provider = providers.valueAt(index);
        provider.setWindowContainer(null, null, null);
        controller.removeSourceProvider(provider.getSource().getId());
        index = index - 1;
    L22:
        this.mInsetsSourceWindowsExceptIme.remove(win);
        if ((win.mAttrs.privateFlags & 131072) == 0) goto L25;
        this.mImmersiveConfirmationWindowExists = false;
    L25:
        this.mExt.onRemoveWindowLw(win);
        return;
    L6:
        if (this.mNavigationBar != win) goto L9;
        this.mNavigationBar = null;
        goto L12
    L9:
        if (this.mNotificationShade != win) goto L12;
        this.mNotificationShade = null;
        goto L12
    }

    WindowState getStatusBar() {
        return this.mStatusBar;
    }

    WindowState getNotificationShade() {
        return this.mNotificationShade;
    }

    WindowState getNavigationBar() {
        return this.mNavigationBar;
    }

    boolean isImmersiveMode() {
        return this.mIsImmersiveMode;
    }

    int selectAnimation(WindowState win, int transit) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[2] == false) goto L6;
        String protoLogParam0 = String.valueOf(win);
        long protoLogParam1 = transit;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ANIM, -7427596081878257508L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L6:
        if (transit == 5) goto L8;
    L30:
        return 0;
    L8:
        if (win.hasAppShownWindows() == false) goto L30;
        if (win.isActivityTypeHome() == false) goto L14;
        return -1;
    L14:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[2] == false) goto L17;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ANIM, -6269658847003264525L, 0, null);
    L17:
        if (win.getExt().isSplashStartingWindow() == false) goto L21;
        return R.anim.btn_checkbox_to_checked_box_inner_merged_animation;
    L21:
        if (this.mDisplayContent.getImeInputTarget() != null) goto L23;
        return R.anim.input_method_extract_enter;
    L23:
        if (this.mDisplayContent.mWmService.shouldRestoreImeVisibility(this.mDisplayContent.getImeInputTarget().getWindowToken()) == true) goto L25;
        return R.anim.input_method_extract_enter;
    L25:
        if (this.mDisplayContent.mTransitionController.getExt().isTransitionKeyguardGoingAway() == true) goto L32;
        return R.anim.input_method_exit;
    L32:
        return R.anim.input_method_extract_enter;
    }

    public boolean areSystemBarsForcedConsumedLw() {
        return false;
    }

    void simulateLayoutDisplay(DisplayFrames displayFrames) {
        sTmpClientFrames.attachedFrame = null;
        int i = this.mInsetsSourceWindowsExceptIme.size() - 1;
    L3:
        if (i < 0) goto L9;
        WindowState win = this.mInsetsSourceWindowsExceptIme.valueAt(i);
        this.mWindowLayout.computeFrames(win.mAttrs.forRotation(displayFrames.mRotation), displayFrames.mInsetsState, displayFrames.mDisplayCutoutSafe, displayFrames.mUnrestricted, win.getWindowingMode(), -1, -1, win.getRequestedVisibleTypes(), win.mGlobalScale, sTmpClientFrames);
        SparseArray<InsetsSourceProvider> providers = win.getInsetsSourceProviders();
        InsetsState state = displayFrames.mInsetsState;
        int index = providers.size() - 1;
    L5:
        if (index < 0) goto L7;
        state.addSource(providers.valueAt(index).createSimulatedSource(displayFrames, sTmpClientFrames.frame));
        index = index - 1;
        goto L5
    L7:
        i = i - 1;
        goto L3
    }

    void onDisplayInfoChanged(DisplayInfo info) {
        if (ViewRootImpl.CLIENT_TRANSIENT == true) goto L6;
        this.mSystemGestures.onDisplayInfoChanged(info);
        return;
    }

    public void layoutWindowLw(WindowState win, WindowState attached, DisplayFrames displayFrames) {
        if (win.skipLayout() == false) goto L5;
        return;
    L5:
        DisplayFrames displayFrames2 = win.getDisplayFrames(displayFrames);
        WindowManager.LayoutParams attrs = win.mAttrs.forRotation(displayFrames2.mRotation);
        this.mExt.adjustLayoutWindowParamsForLandscapeCutout(win, attrs);
        ClientWindowFrames r3 = sTmpClientFrames;
        if (attached == null) goto L8;
        Rect r4 = attached.getFrame();
    L9:
        r3.attachedFrame = r4;
        if (attrs != win.mAttrs) goto L12;
        boolean trustedSize = true;
    L13:
        int r5 = -1;
        if (trustedSize == false) goto L16;
        int requestedWidth = win.mRequestedWidth;
    L17:
        if (trustedSize == false) goto L19;
        r5 = win.mRequestedHeight;
    L19:
        int requestedHeight = r5;
        this.mWindowLayout.computeFrames(attrs, win.getInsetsState(), displayFrames2.mDisplayCutoutSafe, win.getBounds(), win.getWindowingMode(), requestedWidth, requestedHeight, win.getRequestedVisibleTypes(), win.mGlobalScale, sTmpClientFrames);
        win.setFrames(sTmpClientFrames, win.mRequestedWidth, win.mRequestedHeight);
        return;
    L16:
        requestedWidth = -1;
        goto L17
    L12:
        trustedSize = false;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    WindowState getTopFullscreenOpaqueWindow() {
        return this.mTopFullscreenOpaqueWindowState;
    }

    boolean isTopLayoutFullscreen() {
        return this.mTopIsFullscreen;
    }

    public void beginPostLayoutPolicyLw() {
        this.mLeftGestureHost = null;
        this.mTopGestureHost = null;
        this.mRightGestureHost = null;
        this.mBottomGestureHost = null;
        this.mTopFullscreenOpaqueWindowState = null;
        this.mNavBarColorWindowCandidate = null;
        this.mNavBarBackgroundWindowCandidate = null;
        this.mStatusBarAppearanceRegionList.clear();
        this.mLetterboxDetails.clear();
        this.mStatusBarBackgroundWindows.clear();
        this.mStatusBarColorCheckedBounds.setEmpty();
        this.mStatusBarBackgroundCheckedBounds.setEmpty();
        this.mSystemBarColorApps.clear();
        this.mAllowLockscreenWhenOn = false;
        this.mShowingDream = false;
        this.mIsFreeformWindowOverlappingWithNavBar = false;
        this.mForciblyShownTypes = 0;
        this.mImeInsetsConsumed = false;
    }

    public void applyPostLayoutPolicyLw(WindowState win, WindowManager.LayoutParams attrs, WindowState attached, WindowState imeTarget) {
        if (attrs.type != 2019) goto L5;
        this.mHasBottomNavigationBar = hasBottomNavigationBar();
    L5:
        boolean affectsSystemUi = win.canAffectSystemUiFlags();
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L8;
        Slog.i(TAG, "Win " + win + ": affectsSystemUi=" + affectsSystemUi);
    L8:
        applyKeyguardPolicy(win, imeTarget);
        boolean exitingStartingWindow = true;
        if (this.mIsFreeformWindowOverlappingWithNavBar == true) goto L18;
        if (win.inFreeformWindowingMode() == false) goto L18;
        if (win.mActivityRecord == null) goto L18;
        if (isOverlappingWithNavBar(win) == false) goto L18;
        this.mIsFreeformWindowOverlappingWithNavBar = true;
    L18:
        if (win.hasInsetsSourceProvider() == false) goto L55;
        SparseArray<InsetsSourceProvider> providers = win.getInsetsSourceProviders();
        Rect bounds = win.getBounds();
        int index = providers.size() - 1;
    L20:
        if (index < 0) goto L55;
        InsetsSourceProvider provider = providers.valueAt(index);
        InsetsSource source = provider.getSource();
        if ((source.getType() & (WindowInsets.Type.systemGestures() | WindowInsets.Type.mandatorySystemGestures())) == 0) goto L53;
        if (this.mLeftGestureHost != null) goto L27;
    L33:
        Insets insets = source.calculateInsets(bounds, false);
        if (this.mLeftGestureHost != null) goto L39;
        if (insets.left <= 0) goto L39;
        this.mLeftGestureHost = win;
    L39:
        if (this.mTopGestureHost != null) goto L44;
        if (insets.top <= 0) goto L44;
        this.mTopGestureHost = win;
    L44:
        if (this.mRightGestureHost != null) goto L49;
        if (insets.right <= 0) goto L49;
        this.mRightGestureHost = win;
    L49:
        if (this.mBottomGestureHost != null) goto L53;
        if (insets.bottom <= 0) goto L53;
        this.mBottomGestureHost = win;
        goto L53
    L27:
        if (this.mTopGestureHost == null) goto L33;
        if (this.mRightGestureHost == null) goto L33;
        if (this.mBottomGestureHost == null) goto L33;
    L53:
        index = index - 1;
    L55:
        if (win.mSession.mCanForceShowingInsets == false) goto L58;
        this.mForciblyShownTypes |= win.mAttrs.forciblyShownTypes;
    L58:
        if (win.mImeInsetsConsumed == this.mImeInsetsConsumed) goto L66;
        win.mImeInsetsConsumed = this.mImeInsetsConsumed;
        WindowState imeWin = this.mDisplayContent.mInputMethodWindow;
        if (win.isReadyToDispatchInsetsState() == false) goto L66;
        if (imeWin == null) goto L66;
        if (imeWin.isVisible() == false) goto L66;
        win.notifyInsetsChanged();
    L66:
        if ((attrs.privateFlags & 33554432) != 0) goto L68;
    L70:
        if (affectsSystemUi == true) goto L73;
        return;
    L73:
        if (attrs.type >= 1) goto L75;
    L77:
        boolean appWindow = false;
    L79:
        if (this.mTopFullscreenOpaqueWindowState != null) goto L96;
        int fl = attrs.flags;
        if (win.isDreamWindow() == true) goto L83;
    L89:
        if (appWindow == false) goto L96;
        if (attached != null) goto L96;
        if (attrs.isFullscreen() == false) goto L96;
        if ((fl & 1) == 0) goto L96;
        this.mAllowLockscreenWhenOn = true;
        goto L96
    L83:
        if (this.mDreamingLockscreen == true) goto L85;
    L88:
        this.mShowingDream = true;
        appWindow = true;
        goto L89
    L85:
        if (win.isVisible() == false) goto L89;
        if (win.hasDrawn() == false) goto L89;
    L96:
        if (appWindow == false) goto L101;
        if (attached != null) goto L101;
        if (attrs.isFullscreen() == false) goto L101;
    L103:
        if (attrs.type == 3) goto L105;
    L107:
        exitingStartingWindow = false;
    L109:
        if (this.mTopFullscreenOpaqueWindowState != null) goto L113;
        if (exitingStartingWindow == true) goto L113;
        this.mTopFullscreenOpaqueWindowState = win;
    L113:
        if (this.mStatusBar == null) goto L122;
        if (sTmpRect.setIntersect(win.getFrame(), this.mStatusBar.getFrame()) == false) goto L122;
        if (this.mStatusBarBackgroundCheckedBounds.contains(sTmpRect) == true) goto L122;
        this.mStatusBarBackgroundWindows.add(win);
        this.mStatusBarBackgroundCheckedBounds.union(sTmpRect);
        if (this.mStatusBarColorCheckedBounds.contains(sTmpRect) == true) goto L122;
        this.mStatusBarAppearanceRegionList.add(new AppearanceRegion(win.mAttrs.insetsFlags.appearance & 8, new Rect(win.getFrame())));
        this.mStatusBarColorCheckedBounds.union(sTmpRect);
        addSystemBarColorApp(win);
    L122:
        if (isOverlappingWithNavBar(win) == true) goto L124;
    L129:
        ActivityRecord currentActivity = win.getActivityRecord();
        if (currentActivity == null) goto L181;
        LetterboxDetails currentLetterboxDetails = currentActivity.mAppCompatController.getLetterboxPolicy().getLetterboxDetails();
        if (currentLetterboxDetails == null) goto L182;
        this.mLetterboxDetails.add(currentLetterboxDetails);
        return;
    L182:
        return;
    L181:
        return;
    L124:
        if (this.mNavBarColorWindowCandidate != null) goto L127;
        this.mNavBarColorWindowCandidate = win;
        addSystemBarColorApp(win);
    L127:
        if (this.mNavBarBackgroundWindowCandidate != null) goto L129;
        this.mNavBarBackgroundWindowCandidate = win;
        goto L129
    L105:
        if (win.mAnimatingExit == false) goto L107;
    L101:
        if (attrs.type == 2031) goto L103;
        if (win.isDimming() == true) goto L138;
    L151:
        if (appWindow == false) goto L175;
        if (attached == null) goto L154;
        return;
    L154:
        if (this.mNavBarColorWindowCandidate == null) goto L158;
        if (this.mNavBarBackgroundWindowCandidate == null) goto L158;
        return;
    L158:
        if (win.getFrame().contains(getBarContentFrameForWindow(win, WindowInsets.Type.navigationBars())) == true) goto L160;
        return;
    L160:
        if (this.mNavBarColorWindowCandidate != null) goto L163;
        this.mNavBarColorWindowCandidate = win;
        addSystemBarColorApp(win);
    L163:
        if (this.mNavBarBackgroundWindowCandidate != null) goto L179;
        this.mNavBarBackgroundWindowCandidate = win;
        return;
    L179:
        return;
    L175:
        return;
    L138:
        if (this.mService.getObricExt().isAssistWindow(win) == true) goto L151;
        if (this.mStatusBar == null) goto L147;
        int statusBarLayer = this.mStatusBar.mToken.getWindowLayerFromType();
        int targetWindowLayer = win.mToken.getWindowLayerFromType();
        if (targetWindowLayer >= statusBarLayer) goto L147;
        if (addStatusBarAppearanceRegionsForDimmingWindow(win.mAttrs.insetsFlags.appearance & 8, this.mStatusBar.getFrame(), win.getBounds(), win.getFrame()) == false) goto L147;
        addSystemBarColorApp(win);
    L147:
        if (isOverlappingWithNavBar(win) == true) goto L149;
        return;
    L149:
        if (this.mNavBarColorWindowCandidate != null) goto L173;
        this.mNavBarColorWindowCandidate = win;
        addSystemBarColorApp(win);
        return;
    L173:
        return;
    L75:
        if (attrs.type >= 2000) goto L77;
        appWindow = true;
        goto L79
    L68:
        if (win.isVisible() == false) goto L70;
        this.mImeInsetsConsumed = true;
        goto L70
    }

    private boolean addStatusBarAppearanceRegionsForDimmingWindow(int appearance, Rect statusBarFrame, Rect winBounds, Rect winFrame) {
        if (sTmpRect.setIntersect(winBounds, statusBarFrame) == true) goto L6;
        return false;
    L6:
        if (this.mStatusBarColorCheckedBounds.contains(sTmpRect) == false) goto L9;
        return false;
    L9:
        if (appearance != 0) goto L11;
    L25:
        this.mStatusBarAppearanceRegionList.add(new AppearanceRegion(0, new Rect(winBounds)));
        this.mStatusBarColorCheckedBounds.union(sTmpRect);
        return true;
    L11:
        if (sTmpRect2.setIntersect(winFrame, statusBarFrame) == false) goto L25;
        this.mStatusBarAppearanceRegionList.add(new AppearanceRegion(appearance, new Rect(winFrame)));
        if (sTmpRect.equals(sTmpRect2) == false) goto L16;
    L23:
        this.mStatusBarColorCheckedBounds.union(sTmpRect);
        return true;
    L16:
        if (sTmpRect.height() != sTmpRect2.height()) goto L23;
        if (sTmpRect.left == sTmpRect2.left) goto L21;
        this.mStatusBarAppearanceRegionList.add(new AppearanceRegion(0, new Rect(winBounds.left, winBounds.top, sTmpRect2.left, winBounds.bottom)));
    L21:
        if (sTmpRect.right == sTmpRect2.right) goto L23;
        this.mStatusBarAppearanceRegionList.add(new AppearanceRegion(0, new Rect(sTmpRect2.right, winBounds.top, winBounds.right, winBounds.bottom)));
        goto L23
    }

    private void addSystemBarColorApp(WindowState win) {
        ActivityRecord app = win.mActivityRecord;
        if (app == null) goto L6;
        this.mSystemBarColorApps.add(app);
        return;
    }

    public void finishPostLayoutPolicyLw() {
        if (this.mShowingDream == true) goto L5;
        this.mDreamingLockscreen = this.mService.mPolicy.isKeyguardShowingAndNotOccluded();
    L5:
        updateSystemBarAttributes();
        if (this.mShowingDream == this.mLastShowingDream) goto L8;
        this.mLastShowingDream = this.mShowingDream;
        this.mDisplayContent.notifyKeyguardFlagsChanged();
    L8:
        this.mService.mPolicy.setAllowLockscreenWhenOn(getDisplayId(), this.mAllowLockscreenWhenOn);
        this.mExt.onFinishPostLayoutPolicyLw();
    }

    boolean areTypesForciblyShownTransiently(int types) {
        if ((this.mForciblyShownTypes & types) != types) goto L5;
        return true;
    L5:
        return false;
    }

    private void applyKeyguardPolicy(WindowState win, WindowState imeTarget) {
        if (win.canBeHiddenByKeyguard() == false) goto L11;
        boolean shouldBeHiddenByKeyguard = shouldBeHiddenByKeyguard(win, imeTarget);
        if (win.mIsImWindow == false) goto L8;
        this.mDisplayContent.getInsetsStateController().getImeSourceProvider().setFrozen(shouldBeHiddenByKeyguard);
    L8:
        if (shouldBeHiddenByKeyguard == false) goto L10;
        win.hide(false, true);
        goto L11
    L10:
        win.show(false, true);
    L11:
        this.mExt.onApplyKeyguardPolicy(win);
    }

    private boolean shouldBeHiddenByKeyguard(WindowState win, WindowState imeTarget) {
        if (this.mDisplayContent.isDefaultDisplay == true) goto L5;
    L37:
        return false;
    L5:
        if (isKeyguardShowing() == false) goto L37;
        if (imeTarget != null) goto L10;
    L18:
        boolean showImeOverKeyguard = false;
    L20:
        if (showImeOverKeyguard == false) goto L23;
        return false;
    L23:
        if (isKeyguardOccluded() == true) goto L25;
    L29:
        boolean allowShowWhenLocked = false;
    L31:
        if (win.mAttrs.type == 2005) goto L33;
        if (allowShowWhenLocked == false) goto L36;
        return false;
    L36:
        return true;
    L33:
        return true ^ getObricExt().checkAllowShowToastWhenLocked(win, allowShowWhenLocked);
    L25:
        if (win.canShowWhenLocked() == false) goto L27;
    L28:
        allowShowWhenLocked = true;
        goto L31
    L27:
        if ((win.mAttrs.privateFlags & 256) == 0) goto L29;
    L10:
        if (win.mIsImWindow == false) goto L18;
        if (imeTarget.isDisplayed() == false) goto L18;
        if (imeTarget.canShowWhenLocked() == false) goto L16;
    L17:
        showImeOverKeyguard = true;
        goto L20
    L16:
        if (imeTarget.canBeHiddenByKeyguard() == true) goto L18;
        goto L17
    }

    boolean topAppHidesSystemBar(int type) {
        if (this.mTopFullscreenOpaqueWindowState != null) goto L5;
        return false;
    L5:
        if (getInsetsPolicy().areTypesForciblyShowing(type) == false) goto L8;
        return false;
    L8:
        return !this.mTopFullscreenOpaqueWindowState.isRequestedVisible(type);
    }

    public void switchUser() {
        updateCurrentUserResources();
        updateForceShowNavBarSettings();
    }

    void onOverlayChanged() {
        updateCurrentUserResources();
        this.mDisplayContent.requestDisplayUpdate(new DisplayPolicy$$ExternalSyntheticLambda10(this));
    }

    private /* synthetic */ void lambda$onOverlayChanged$3() {
        onConfigurationChanged();
        if (ViewRootImpl.CLIENT_TRANSIENT == true) goto L6;
        this.mSystemGestures.onConfigurationChanged();
        return;
    }

    public void onConfigurationChanged() {
        Resources res = getCurrentUserResources();
        this.mNavBarOpacityMode = res.getInteger(R.integer.config_notificationWarnRemoteViewSizeBytes);
        this.mLeftGestureInset = this.mGestureNavigationSettingsObserver.getLeftSensitivity(res);
        this.mRightGestureInset = this.mGestureNavigationSettingsObserver.getRightSensitivity(res);
        this.mNavigationBarAlwaysShowOnSideGesture = res.getBoolean(R.bool.config_noHomeScreen);
        this.mRemoteInsetsControllerControlsSystemBars = res.getBoolean(R.bool.config_remoteInsetsControllerControlsSystemBars);
        updateConfigurationAndScreenSizeDependentBehaviors();
        if (res.getBoolean(R.bool.config_autoPowerModePreferWristTilt) == false) goto L5;
        boolean shouldAttach = true;
    L7:
        if (this.mShouldAttachNavBarToAppDuringTransition == shouldAttach) goto L9;
        this.mShouldAttachNavBarToAppDuringTransition = shouldAttach;
    L9:
        getExt().onConfigurationChanged();
        return;
    L5:
        shouldAttach = false;
        goto L7
    }

    void updateConfigurationAndScreenSizeDependentBehaviors() {
        Resources res = getCurrentUserResources();
        if (this.mDisplayContent.mBaseDisplayWidth != this.mDisplayContent.mBaseDisplayHeight) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.mNavigationBarCanMove = r1;
        this.mDisplayContent.getDisplayRotation().updateUserDependentConfiguration(res);
        return;
    L5:
        if (res.getBoolean(R.bool.config_notificationBadging) == false) goto L7;
        r1 = true;
        goto L8
    }

    private void updateCurrentUserResources() {
        int userId = this.mService.mAmInternal.getCurrentUserId();
        Context uiContext = getSystemUiContext();
        if (userId != 0) goto L6;
        this.mCurrentUserResources = uiContext.getResources();
        return;
    L6:
        LoadedApk pi = ActivityThread.currentActivityThread().getPackageInfo(uiContext.getPackageName(), null, 0, userId);
        this.mCurrentUserResources = ResourcesManager.getInstance().getResources(uiContext.getWindowContextToken(), pi.getResDir(), null, pi.getOverlayDirs(), pi.getOverlayPaths(), pi.getApplicationInfo().sharedLibraryFiles, Integer.valueOf(this.mDisplayContent.getDisplayId()), null, uiContext.getResources().getCompatibilityInfo(), null, null);
    }

    Resources getCurrentUserResources() {
        if (this.mCurrentUserResources != null) goto L6;
        updateCurrentUserResources();
    L6:
        return this.mCurrentUserResources;
    }

    Context getContext() {
        return this.mContext;
    }

    Context getSystemUiContext() {
        return this.mUiContext;
    }

    void setCanSystemBarsBeShownByUser(boolean canBeShown) {
        this.mCanSystemBarsBeShownByUser = canBeShown;
    }

    void notifyDisplayAddSystemDecorations() {
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == false) goto L14;
        final int displayId = getDisplayId();
        final boolean isSystemDecorationsSupported = this.mDisplayContent.isSystemDecorationsSupported();
        final boolean isHomeSupported = this.mDisplayContent.isHomeSupported();
        if (isSystemDecorationsSupported == true) goto L7;
    L12:
        boolean r0 = false;
    L11:
        final boolean eligibleForDesktopMode = r0;
        this.mHandler.post(new DisplayPolicy$$ExternalSyntheticLambda14(this, isSystemDecorationsSupported, displayId, isHomeSupported, eligibleForDesktopMode));
        return;
    L7:
        if (this.mDisplayContent.isDefaultDisplay == false) goto L9;
    L10:
        r0 = true;
        goto L11
    L9:
        if (this.mDisplayContent.allowContentModeSwitch() == false) goto L12;
    L14:
        this.mHandler.post(new DisplayPolicy$$ExternalSyntheticLambda15(this));
    }

    private /* synthetic */ void lambda$notifyDisplayAddSystemDecorations$4(boolean isSystemDecorationsSupported, int displayId, boolean isHomeSupported, boolean eligibleForDesktopMode) {
        if (isSystemDecorationsSupported == false) goto L6;
        StatusBarManagerInternal statusBar = getStatusBarManagerInternal();
        if (statusBar == null) goto L6;
        statusBar.onDisplayAddSystemDecorations(displayId);
    L6:
        if (isHomeSupported == false) goto L10;
        WallpaperManagerInternal wpMgr = (WallpaperManagerInternal) LocalServices.getService(WallpaperManagerInternal.class);
        if (wpMgr == null) goto L10;
        wpMgr.onDisplayAddSystemDecorations(displayId);
    L10:
        if (eligibleForDesktopMode == false) goto L13;
        this.mService.mDisplayNotificationController.dispatchDesktopModeEligibleChanged(displayId);
        return;
    }

    private /* synthetic */ void lambda$notifyDisplayAddSystemDecorations$5() {
        int displayId = getDisplayId();
        StatusBarManagerInternal statusBar = getStatusBarManagerInternal();
        if (statusBar == null) goto L5;
        statusBar.onDisplayAddSystemDecorations(displayId);
    L5:
        WallpaperManagerInternal wpMgr = (WallpaperManagerInternal) LocalServices.getService(WallpaperManagerInternal.class);
        if (wpMgr == null) goto L9;
        wpMgr.onDisplayAddSystemDecorations(displayId);
        return;
    }

    void notifyDisplayRemoveSystemDecorations() {
        this.mHandler.post(new DisplayPolicy$$ExternalSyntheticLambda13(this));
    }

    private /* synthetic */ void lambda$notifyDisplayRemoveSystemDecorations$6() {
        int displayId = getDisplayId();
        StatusBarManagerInternal statusBar = getStatusBarManagerInternal();
        if (statusBar == null) goto L5;
        statusBar.onDisplayRemoveSystemDecorations(displayId);
    L5:
        WallpaperManagerInternal wpMgr = (WallpaperManagerInternal) LocalServices.getService(WallpaperManagerInternal.class);
        if (wpMgr == null) goto L8;
        wpMgr.onDisplayRemoveSystemDecorations(displayId);
    L8:
        this.mService.mDisplayNotificationController.dispatchDesktopModeEligibleChanged(displayId);
        NotificationManagerInternal notificationManager = (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class);
        if (notificationManager == null) goto L12;
        notificationManager.onDisplayRemoveSystemDecorations(displayId);
        return;
    }

    float getWindowCornerRadius() {
        if (this.mDisplayContent.getDisplay().getType() == 1) goto L7;
        return 0.0f;
    L7:
        return ScreenDecorationsUtils.getWindowCornerRadius(this.mContext);
    }

    boolean isShowingDreamLw() {
        return this.mShowingDream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean updateDecorInsetsInfo() {
        int r2 = 0;
        if (shouldKeepCurrentDecorInsets() == false) goto L5;
        return false;
    L5:
        DisplayFrames displayFrames = this.mDisplayContent.mDisplayFrames;
        int rotation = displayFrames.mRotation;
        int dw = displayFrames.mWidth;
        int dh = displayFrames.mHeight;
        DecorInsets.Info newInfo = this.mDecorInsets.mTmpInfo;
        InsetsState newInsetsState = newInfo.update(this.mDisplayContent, rotation, dw, dh);
        DecorInsets.Info currentInfo = getDecorInsetsInfo(rotation, dw, dh);
        boolean sameConfigFrame = newInfo.mConfigFrame.equals(currentInfo.mConfigFrame);
        int r10 = 1;
        if (sameConfigFrame == false) goto L33;
        if (newInfo.mOverrideConfigFrame.equals(currentInfo.mOverrideConfigFrame) == false) goto L33;
        InsetsState currentInsetsState = this.mDisplayContent.mDisplayFrames.mInsetsState;
        if (DecorInsets.hasInsetsFrameDiff(newInsetsState, currentInsetsState, this.mService.mConfigTypes) == false) goto L29;
        int i = DecorInsets.m9947$$Nest$fgetmInfoForRotation(this.mDecorInsets).length - 1;
    L12:
        if (i < 0) goto L27;
        if (i == rotation) goto L26;
        if (((i + rotation) % 2) != r10) goto L17;
        int r13 = r10;
    L18:
        if (r13 == 0) goto L20;
        int w = dh;
    L21:
        if (r13 == 0) goto L23;
        int h = dw;
    L24:
        DecorInsets.m9947$$Nest$fgetmInfoForRotation(this.mDecorInsets)[i].update(this.mDisplayContent, i, w, h);
        goto L26
    L23:
        h = dh;
        goto L24
    L20:
        w = dw;
        goto L21
    L17:
        r13 = r2;
    L26:
        i = i - 1;
        r2 = r2;
        r10 = r10;
        goto L12
    L27:
        boolean r16 = r2;
        DecorInsets.m9947$$Nest$fgetmInfoForRotation(this.mDecorInsets)[rotation].set(newInfo);
        return r16;
    L29:
        return false;
    L33:
        if (this.mCachedDecorInsets != null) goto L35;
    L39:
        this.mDecorInsets.invalidate();
        DecorInsets.m9947$$Nest$fgetmInfoForRotation(this.mDecorInsets)[rotation].set(newInfo);
        if (this.mService.mDisplayEnabled == true) goto L43;
        return 1;
    L43:
        return !sameConfigFrame;
    L35:
        if (this.mCachedDecorInsets.canPreserve() == true) goto L39;
        if (this.mScreenOnFully == false) goto L39;
        this.mCachedDecorInsets = null;
        goto L39
    }

    DecorInsets.Info getDecorInsetsInfo(int rotation, int w, int h) {
        DecorInsets.Info info = this.mObricExt.getDecorInsetsInfo(rotation, w, h);
        if (info == null) goto L7;
        Slog.d(TAG, "return special obric virtuald display info");
        return info;
    L7:
        return this.mDecorInsets.get(rotation, w, h);
    }

    boolean shouldKeepCurrentDecorInsets() {
        if (this.mCachedDecorInsets != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mCachedDecorInsets.mActive == false) goto L9;
        if (this.mCachedDecorInsets.canPreserve() == false) goto L9;
        return true;
    }

    void physicalDisplayChanged() {
        if (USE_CACHED_INSETS_FOR_DISPLAY_SWITCH == false) goto L6;
        updateCachedDecorInsets();
        return;
    }

    void updateCachedDecorInsets() {
        DecorInsets prevCache = null;
        PrivacyIndicatorBounds privacyIndicatorBounds = null;
        if (this.mCachedDecorInsets != null) goto L5;
        this.mCachedDecorInsets = new DecorInsets.Cache(this.mDisplayContent);
    L6:
        this.mCachedDecorInsets.mPreserveId = -1;
        this.mCachedDecorInsets.mDecorInsets.setTo(this.mDecorInsets);
        this.mCachedDecorInsets.mRegularBarsInsets = null;
        this.mCachedDecorInsets.mPrivacyIndicatorBounds = null;
        if (prevCache == null) goto L13;
        this.mDecorInsets.setTo(prevCache);
        if (privacyIndicatorBounds == null) goto L11;
        this.mDisplayContent.mCurrentPrivacyIndicatorBounds = privacyIndicatorBounds;
    L11:
        this.mCachedDecorInsets.mActive = true;
        return;
    L13:
        return;
    L5:
        prevCache = new DecorInsets(this.mDisplayContent);
        prevCache.setTo(this.mCachedDecorInsets.mDecorInsets);
        privacyIndicatorBounds = this.mCachedDecorInsets.mPrivacyIndicatorBounds;
        DecorInsets.Cache r2 = this.mCachedDecorInsets;
        r2.mPreservedInsets = this.mCachedDecorInsets.mRegularBarsInsets;
        goto L6
    }

    InsetsState replaceInsetsSourcesIfNeeded(InsetsState originalState, boolean copyState) {
        if (this.mCachedDecorInsets != null) goto L5;
    L21:
        return originalState;
    L5:
        if (this.mCachedDecorInsets.mPreservedInsets == null) goto L21;
        if (shouldKeepCurrentDecorInsets() == false) goto L21;
        ArrayList<InsetsSource> preservedSources = this.mCachedDecorInsets.mPreservedInsets;
        if (copyState == false) goto L12;
        InsetsState state = new InsetsState(originalState);
    L13:
        int i = preservedSources.size() - 1;
    L14:
        if (i < 0) goto L20;
        InsetsSource cacheSource = preservedSources.get(i);
        if (state.peekSource(cacheSource.getId()) == null) goto L18;
        state.addSource(new InsetsSource(cacheSource));
    L18:
        i = i - 1;
        goto L14
    L20:
        return state;
    L12:
        state = originalState;
        goto L13
    }

    void physicalDisplayUpdated() {
        if (this.mCachedDecorInsets != null) goto L6;
        return;
    L6:
        if (this.mDisplayContent.mTransitionController.isCollecting() == true) goto L9;
        this.mCachedDecorInsets = null;
        return;
    L9:
        DecorInsets.Cache r0 = this.mCachedDecorInsets;
        r0.mPreserveId = this.mDisplayContent.mTransitionController.getCollectingTransitionId();
    }

    public void onDisplaySwitchStart() {
        this.mDisplayContent.mDisplayUpdater.onDisplaySwitching(true);
    }

    boolean hasBottomNavigationBar() {
        Insets navBarInsets = this.mDisplayContent.getInsetsStateController().getRawInsetsState().calculateInsets(this.mDisplayContent.mDisplayFrames.mUnrestricted, WindowInsets.Type.navigationBars(), true);
        if (navBarInsets.bottom > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void focusChangedLw(WindowState lastFocus, WindowState newFocus) {
        this.mFocusedWindow = newFocus;
        this.mLastFocusedWindow = lastFocus;
        if (this.mDisplayContent.isDefaultDisplay == false) goto L5;
        this.mService.mPolicy.onDefaultDisplayFocusChangedLw(newFocus);
    L5:
        updateSystemBarAttributes();
    }

    void requestTransientBars(WindowState swipeTarget, boolean isGestureOnSystemBar) {
        GameKeysPatch gameKeysPatch = GameKeysPatch.getInstance();
        boolean r1 = true;
        if (gameKeysPatch == null) goto L16;
        Context r3 = this.mContext;
        if (swipeTarget != this.mStatusBar) goto L7;
        boolean r4 = true;
    L9:
        if (swipeTarget != this.mNavigationBar) goto L11;
        boolean r5 = true;
    L13:
        if (gameKeysPatch.interceptRequestTransientBars(r3, r4, r5) == false) goto L16;
        return;
    L11:
        r5 = false;
        goto L13
    L7:
        r4 = false;
    L16:
        if (ViewRootImpl.CLIENT_TRANSIENT == false) goto L18;
        return;
    L18:
        if (swipeTarget != null) goto L20;
        return;
    L20:
        if (this.mService.mPolicy.isUserSetupComplete() == true) goto L23;
        return;
    L23:
        if (this.mCanSystemBarsBeShownByUser == true) goto L26;
        Slog.d(TAG, "Remote insets controller disallows showing system bars - ignoring request");
        return;
    L26:
        InsetsSourceProvider provider = swipeTarget.getControllableInsetProvider();
        if (provider == null) goto L29;
        InsetsControlTarget controlTarget = provider.getControlTarget();
    L30:
        if (controlTarget != null) goto L32;
        return;
    L32:
        if (controlTarget == getNotificationShade()) goto L76;
        WindowState win = controlTarget.getWindow();
        if (win != null) goto L37;
    L39:
        int restorePositionTypes = (WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars()) & controlTarget.getRequestedVisibleTypes();
        InsetsSourceProvider sp = swipeTarget.getControllableInsetProvider();
        if (sp == null) goto L48;
        if (sp.getSource().getType() != WindowInsets.Type.navigationBars()) goto L48;
        if ((WindowInsets.Type.navigationBars() & restorePositionTypes) == 0) goto L48;
        controlTarget.showInsets(WindowInsets.Type.navigationBars(), false, null);
        return;
    L48:
        if (controlTarget.canShowTransient() == false) goto L67;
        if (gameKeysPatch == null) goto L66;
        Context r6 = this.mContext;
        if (swipeTarget != this.mStatusBar) goto L53;
        boolean r9 = true;
    L55:
        if (swipeTarget == this.mNavigationBar) goto L58;
        r1 = false;
    L58:
        int swipeTargetType = gameKeysPatch.antiMisporatetToastAndType(r6, r9, r1, hasSideGestures());
        if (WindowInsets.Type.statusBars() != swipeTargetType) goto L62;
        this.mDisplayContent.getInsetsPolicy().showTransient(WindowInsets.Type.statusBars(), isGestureOnSystemBar);
    L65:
        controlTarget.showInsets(restorePositionTypes, false, null);
    L72:
        this.mStatusBarManagerInternal.confirmImmersivePrompt();
        return;
    L62:
        if (WindowInsets.Type.navigationBars() != swipeTargetType) goto L64;
        this.mDisplayContent.getInsetsPolicy().showTransient(WindowInsets.Type.navigationBars(), isGestureOnSystemBar);
        goto L65
    L64:
        this.mDisplayContent.getInsetsPolicy().showTransient(SHOW_TYPES_FOR_SWIPE, isGestureOnSystemBar);
        goto L65
    L53:
        r9 = false;
        goto L55
    L66:
        this.mDisplayContent.getInsetsPolicy().showTransient(SHOW_TYPES_FOR_SWIPE, isGestureOnSystemBar);
        controlTarget.showInsets(restorePositionTypes, false, null);
        goto L72
    L67:
        controlTarget.showInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars(), false, null);
        if (swipeTarget != this.mStatusBar) goto L72;
        boolean transferred = this.mStatusBar.transferTouch();
        if (transferred == true) goto L72;
        Slog.i(TAG, "Could not transfer touch to the status bar");
        goto L72
    L37:
        if (win.isActivityTypeDream() == false) goto L39;
        return;
    L76:
        return;
    L29:
        controlTarget = null;
        goto L30
    }

    boolean isKeyguardShowing() {
        return this.mService.mPolicy.isKeyguardShowing();
    }

    private boolean isKeyguardOccluded() {
        return this.mService.mPolicy.isKeyguardOccluded();
    }

    InsetsPolicy getInsetsPolicy() {
        return this.mDisplayContent.getInsetsPolicy();
    }

    void addRelaunchingApp(ActivityRecord app) {
        if (this.mSystemBarColorApps.contains(app) == true) goto L5;
        return;
    L5:
        if (app.hasStartingWindow() == true) goto L9;
        this.mRelaunchingSystemBarColorApps.add(app);
        return;
    }

    void removeRelaunchingApp(ActivityRecord app) {
        boolean removed = this.mRelaunchingSystemBarColorApps.remove(app);
        if ((this.mRelaunchingSystemBarColorApps.isEmpty() & removed) == false) goto L6;
        updateSystemBarAttributes();
        return;
    }

    void resetSystemBarAttributes() {
        this.mLastDisableFlags = 0;
        updateSystemBarAttributes();
    }

    void updateSystemBarAttributes() {
        if (this.mFocusedWindow == null) goto L5;
        WindowState winCandidate = this.mFocusedWindow;
    L7:
        if (winCandidate != null) goto L10;
        return;
    L10:
        if ((winCandidate.mAttrs.privateFlags & 131072) != 0) goto L12;
    L24:
        WindowState win = winCandidate;
        this.mSystemUiControllingWindow = win;
        final int displayId = getDisplayId();
        final int disableFlags = win.getDisableFlags();
        int opaqueAppearance = updateSystemBarsLw(win, disableFlags);
        if (this.mRelaunchingSystemBarColorApps.isEmpty() == true) goto L27;
        return;
    L27:
        WindowState navColorWin = chooseNavigationColorWindowLw(this.mNavBarColorWindowCandidate, this.mDisplayContent.mInputMethodWindow, this.mHasBottomNavigationBar);
        if (navColorWin != null) goto L30;
    L32:
        final boolean isNavbarColorManagedByIme = false;
    L33:
        final int appearance = updateLightNavigationBarLw(win.mAttrs.insetsFlags.appearance, navColorWin) | opaqueAppearance;
        if (topAppHidesSystemBar(WindowInsets.Type.navigationBars()) == false) goto L36;
        WindowState r8 = this.mTopFullscreenOpaqueWindowState;
    L37:
        WindowState navBarControlWin = r8;
        final int behavior = navBarControlWin.mAttrs.insetsFlags.behavior;
        final String focusedApp = win.mAttrs.packageName;
        if (win.isRequestedVisible(WindowInsets.Type.statusBars()) == true) goto L40;
    L43:
        boolean isFullscreen = true;
    L44:
        final AppearanceRegion[] statusBarAppearanceRegions = new AppearanceRegion[this.mStatusBarAppearanceRegionList.size()];
        this.mStatusBarAppearanceRegionList.toArray(statusBarAppearanceRegions);
        if (this.mLastDisableFlags == disableFlags) goto L47;
        this.mLastDisableFlags = disableFlags;
        final String cause = win.toString();
        callStatusBarSafely(new DisplayPolicy$$ExternalSyntheticLambda8(displayId, disableFlags, cause));
    L47:
        final int requestedVisibleTypes = win.getRequestedVisibleTypes();
        final LetterboxDetails[] letterboxDetails = new LetterboxDetails[this.mLetterboxDetails.size()];
        this.mLetterboxDetails.toArray(letterboxDetails);
        if (this.mLastAppearance != appearance) goto L63;
        if (this.mLastBehavior != behavior) goto L63;
        if (this.mLastRequestedVisibleTypes != requestedVisibleTypes) goto L63;
        if (Objects.equals(this.mFocusedApp, focusedApp) == false) goto L63;
        if (this.mLastFocusIsFullscreen != isFullscreen) goto L63;
        if (Arrays.equals(this.mLastStatusBarAppearanceRegions, statusBarAppearanceRegions) == false) goto L63;
        if (Arrays.equals(this.mLastLetterboxDetails, letterboxDetails) == false) goto L63;
        return;
    L63:
        if (this.mDisplayContent.isDefaultDisplay == false) goto L79;
        if (this.mLastFocusIsFullscreen == isFullscreen) goto L67;
    L70:
        InputManagerService r1 = this.mService.mInputManager;
        if (isFullscreen == false) goto L73;
    L76:
        boolean r2 = true;
    L77:
        r1.setSystemUiLightsOut(r2);
        goto L79
    L73:
        if ((appearance & 4) != 0) goto L76;
        r2 = false;
        goto L77
    L67:
        if (((this.mLastAppearance ^ appearance) & 4) != 0) goto L70;
    L79:
        this.mLastAppearance = appearance;
        this.mLastBehavior = behavior;
        this.mLastRequestedVisibleTypes = requestedVisibleTypes;
        this.mFocusedApp = focusedApp;
        this.mLastFocusIsFullscreen = isFullscreen;
        this.mLastStatusBarAppearanceRegions = statusBarAppearanceRegions;
        this.mLastLetterboxDetails = letterboxDetails;
        if (this.mDisplayContent.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L82;
        this.mService.getObricExt().onDisplayStatusBarChanged(displayId, appearance);
    L82:
        callStatusBarSafely(new DisplayPolicy$$ExternalSyntheticLambda9(displayId, appearance, statusBarAppearanceRegions, isNavbarColorManagedByIme, behavior, requestedVisibleTypes, focusedApp, letterboxDetails));
        if (displayId <= 0) goto L92;
        if (ActivityStarterHook.CAR_DISPLAY_NAME.equals(this.mDisplayContent.getDisplay().getName()) == false) goto L94;
        Slog.d(TAG, "updateSystemBarAttributes:" + displayId + ", appearance:" + appearance);
        int curAppearance = appearance;
        int pre = Settings.Global.getInt(this.mContext.getContentResolver(), "sysbar_appearance", -1);
        if (curAppearance != pre) goto L89;
        curAppearance = curAppearance | 2048;
    L89:
        Settings.Global.putInt(this.mContext.getContentResolver(), "sysbar_appearance", curAppearance);
        return;
    L94:
        return;
    L92:
        return;
    L40:
        if (win.isRequestedVisible(WindowInsets.Type.navigationBars()) == false) goto L43;
        isFullscreen = false;
        goto L44
    L36:
        r8 = win;
        goto L37
    L30:
        if (navColorWin != this.mDisplayContent.mInputMethodWindow) goto L32;
        isNavbarColorManagedByIme = true;
        goto L33
    L12:
        if (this.mNotificationShade == null) goto L17;
        if (this.mNotificationShade.canReceiveKeys() == false) goto L17;
        winCandidate = this.mNotificationShade;
    L22:
        if (winCandidate != null) goto L24;
        return;
    L17:
        if (this.mLastFocusedWindow != null) goto L19;
    L21:
        winCandidate = this.mTopFullscreenOpaqueWindowState;
        goto L22
    L19:
        if (this.mLastFocusedWindow.canReceiveKeys() == false) goto L21;
        winCandidate = this.mLastFocusedWindow;
        goto L22
    L5:
        winCandidate = this.mTopFullscreenOpaqueWindowState;
        goto L7
    }

    private static /* synthetic */ void lambda$updateSystemBarAttributes$7(int displayId, int disableFlags, String cause, StatusBarManagerInternal statusBar) {
        statusBar.setDisableFlags(displayId, disableFlags, cause);
    }

    private static /* synthetic */ void lambda$updateSystemBarAttributes$8(int displayId, int appearance, AppearanceRegion[] statusBarAppearanceRegions, boolean isNavbarColorManagedByIme, int behavior, int requestedVisibleTypes, String focusedApp, LetterboxDetails[] letterboxDetails, StatusBarManagerInternal statusBar) {
        statusBar.onSystemBarAttributesChanged(displayId, appearance, statusBarAppearanceRegions, isNavbarColorManagedByIme, behavior, requestedVisibleTypes, focusedApp, letterboxDetails);
    }

    private void callStatusBarSafely(final Consumer<StatusBarManagerInternal> consumer) {
        this.mHandler.post(new DisplayPolicy$$ExternalSyntheticLambda1(this, consumer));
    }

    private /* synthetic */ void lambda$callStatusBarSafely$9(Consumer consumer) {
        StatusBarManagerInternal statusBar = getStatusBarManagerInternal();
        if (statusBar == null) goto L6;
        consumer.accept(statusBar);
        return;
    }

    static WindowState chooseNavigationColorWindowLw(WindowState candidate, WindowState imeWindow, boolean hasBottomNavigationBar) {
        if (imeWindow != null) goto L4;
    L9:
        boolean imeWindowCanNavColorWindow = false;
    L11:
        if (imeWindowCanNavColorWindow == true) goto L13;
        return candidate;
    L13:
        if (candidate != null) goto L15;
    L20:
        return imeWindow;
    L15:
        if (candidate.isDimming() == false) goto L20;
        if (WindowManager.LayoutParams.mayUseInputMethod(candidate.mAttrs.flags) == false) goto L19;
        return imeWindow;
    L19:
        return candidate;
    L4:
        if (imeWindow.isVisible() == false) goto L9;
        if (hasBottomNavigationBar == false) goto L9;
        if ((imeWindow.mAttrs.flags & Integer.MIN_VALUE) == 0) goto L9;
        imeWindowCanNavColorWindow = true;
        goto L11
    }

    int updateLightNavigationBarLw(int appearance, WindowState navColorWin) {
        if (navColorWin == null) goto L9;
        if (isLightBarAllowed(navColorWin, WindowInsets.Type.navigationBars()) == false) goto L9;
        return (appearance & (-17)) | (navColorWin.mAttrs.insetsFlags.appearance & 16);
    L9:
        return appearance & (-17);
    }

    private int updateSystemBarsLw(final WindowState win, int disableFlags) {
        TaskDisplayArea defaultTaskDisplayArea = this.mDisplayContent.getDefaultTaskDisplayArea();
        if (defaultTaskDisplayArea.getRootTask(new DisplayPolicy$$ExternalSyntheticLambda11()) == null) goto L5;
        boolean adjacentTasksVisible = true;
    L6:
        Task topFreeformTask = defaultTaskDisplayArea.getTopRootTaskInWindowingMode(5);
        if (topFreeformTask != null) goto L9;
    L11:
        boolean freeformRootTaskVisible = false;
    L13:
        if (freeformRootTaskVisible == true) goto L15;
    L17:
        boolean inNonFullscreenFreeformMode = false;
    L18:
        InsetsPolicy r9 = getInsetsPolicy();
        if (DesktopModeFlags.ENABLE_FULLY_IMMERSIVE_IN_DESKTOP.isTrue() == false) goto L21;
        boolean r10 = inNonFullscreenFreeformMode;
    L22:
        r9.updateSystemBars(win, adjacentTasksVisible, r10);
        boolean topAppHidesStatusBar = topAppHidesSystemBar(WindowInsets.Type.statusBars());
        if (getStatusBar() == null) goto L28;
        StatusBarManagerInternal statusBar = getStatusBarManagerInternal();
        if (statusBar == null) goto L28;
        statusBar.setTopAppHidesStatusBar(getDisplayId(), topAppHidesStatusBar);
    L28:
        if (topAppHidesStatusBar == true) goto L30;
    L34:
        boolean r11 = false;
    L35:
        this.mTopIsFullscreen = r11;
        int appearance = configureStatusBarOpacity(3);
        int appearance2 = this.mExt.adjustNavBarAppearance(win, configureNavBarOpacity(appearance, adjacentTasksVisible, freeformRootTaskVisible));
        boolean wasImmersiveMode = this.mIsImmersiveMode;
        final boolean isImmersiveMode = isImmersiveMode(win);
        if (wasImmersiveMode == isImmersiveMode) goto L42;
        this.mIsImmersiveMode = isImmersiveMode;
        RootDisplayArea root = win.getRootDisplayArea();
        if (root != null) goto L40;
        final int rootDisplayAreaId = -1;
    L41:
        callStatusBarSafely(new DisplayPolicy$$ExternalSyntheticLambda12(this, rootDisplayAreaId, isImmersiveMode, win));
        goto L42
    L40:
        rootDisplayAreaId = root.mFeatureId;
    L42:
        boolean requestHideNavBar = !win.isRequestedVisible(WindowInsets.Type.navigationBars());
        long now = SystemClock.uptimeMillis();
        if (this.mPendingPanicGestureUptime != 0) goto L45;
    L47:
        boolean pendingPanic = false;
    L48:
        DisplayPolicy defaultDisplayPolicy = this.mService.getDefaultDisplayContentLocked().getDisplayPolicy();
        if (pendingPanic == false) goto L57;
        if (requestHideNavBar == false) goto L57;
        if (isImmersiveMode == false) goto L57;
        if (defaultDisplayPolicy.isKeyguardDrawComplete() == false) goto L57;
        this.mPendingPanicGestureUptime = 0;
        if (isNavBarEmpty(disableFlags) == true) goto L57;
        this.mDisplayContent.getInsetsPolicy().showTransient(SHOW_TYPES_FOR_PANIC, true);
    L57:
        return appearance2;
    L45:
        if ((now - this.mPendingPanicGestureUptime) > 30000) goto L47;
        pendingPanic = true;
        goto L48
    L30:
        if (this.mNotificationShade != null) goto L32;
    L33:
        r11 = true;
        goto L35
    L32:
        if (this.mNotificationShade.isVisible() == true) goto L34;
    L21:
        r10 = freeformRootTaskVisible;
        goto L22
    L15:
        if (topFreeformTask.getBounds().equals(this.mDisplayContent.getBounds()) == true) goto L17;
        inNonFullscreenFreeformMode = true;
        goto L18
    L9:
        if (topFreeformTask.isVisible() == false) goto L11;
        freeformRootTaskVisible = true;
        goto L13
    L5:
        adjacentTasksVisible = false;
        goto L6
    }

    private static /* synthetic */ boolean lambda$updateSystemBarsLw$10(Task task) {
        if (task.isVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (task.getTopLeafTask().hasAdjacentTask() == false) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$updateSystemBarsLw$11(int rootDisplayAreaId, boolean isImmersiveMode, WindowState win, StatusBarManagerInternal statusBar) {
        statusBar.immersiveModeChanged(getDisplayId(), rootDisplayAreaId, isImmersiveMode, win.getWindowType());
    }

    private static boolean isLightBarAllowed(WindowState win, int type) {
        if (win != null) goto L6;
        return false;
    L6:
        return intersectsAnyInsets(win.getFrame(), win.getInsetsState(), type);
    }

    private Rect getBarContentFrameForWindow(WindowState win, int type) {
        DisplayFrames displayFrames = win.getDisplayFrames(this.mDisplayContent.mDisplayFrames);
        InsetsState state = displayFrames.mInsetsState;
        Rect df = displayFrames.mUnrestricted;
        Rect safe = sTmpDisplayCutoutSafe;
        Insets waterfallInsets = state.getDisplayCutout().getWaterfallInsets();
        Rect outRect = new Rect();
        Rect sourceContent = sTmpRect;
        safe.set(displayFrames.mDisplayCutoutSafe);
        int i = state.sourceSize() - 1;
    L3:
        if (i < 0) goto L24;
        InsetsSource source = state.sourceAt(i);
        if (source.getType() != type) goto L22;
        if (type != WindowInsets.Type.statusBars()) goto L21;
        safe.set(displayFrames.mDisplayCutoutSafe);
        Insets insets = source.calculateInsets(df, true);
        if (insets.left <= 0) goto L13;
        safe.left = Math.max(df.left + waterfallInsets.left, df.left);
        goto L21
    L13:
        if (insets.top <= 0) goto L16;
        safe.top = Math.max(df.top + waterfallInsets.top, df.top);
        goto L21
    L16:
        if (insets.right <= 0) goto L19;
        safe.right = Math.max(df.right - waterfallInsets.right, df.right);
        goto L21
    L19:
        if (insets.bottom <= 0) goto L21;
        safe.bottom = Math.max(df.bottom - waterfallInsets.bottom, df.bottom);
    L21:
        sourceContent.set(source.getFrame());
        sourceContent.intersect(safe);
        outRect.union(sourceContent);
    L22:
        i = i - 1;
        goto L3
    L24:
        return outRect;
    }

    boolean isFullyTransparentAllowed(WindowState win, int type) {
        if (win != null) goto L6;
        return true;
    L6:
        return win.isFullyTransparentBarAllowed(getBarContentFrameForWindow(win, type));
    }

    private static boolean drawsBarBackground(WindowState win) {
        if (win != null) goto L6;
        return true;
    L6:
        if ((win.mAttrs.flags & Integer.MIN_VALUE) == 0) goto L8;
        boolean drawsSystemBars = true;
    L10:
        if ((win.mAttrs.privateFlags & 32768) == 0) goto L12;
        boolean forceDrawsSystemBars = true;
    L13:
        if (forceDrawsSystemBars == true) goto L18;
        if (drawsSystemBars == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return true;
    L12:
        forceDrawsSystemBars = false;
        goto L13
    L8:
        drawsSystemBars = false;
        goto L10
    }

    private int configureStatusBarOpacity(int appearance) {
        boolean drawBackground = true;
        boolean isFullyTransparentAllowed = true;
        int i = this.mStatusBarBackgroundWindows.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowState window = this.mStatusBarBackgroundWindows.get(i);
        drawBackground = drawBackground & drawsBarBackground(window);
        isFullyTransparentAllowed = isFullyTransparentAllowed & isFullyTransparentAllowed(window, WindowInsets.Type.statusBars());
        i = i - 1;
        goto L3
    L6:
        if (drawBackground == false) goto L8;
        appearance = appearance & (-2);
    L8:
        if (isFullyTransparentAllowed == false) goto L10;
        return appearance;
    L10:
        return appearance | 32;
    }

    private int configureNavBarOpacity(int appearance, boolean multiWindowTaskVisible, boolean freeformRootTaskVisible) {
        WindowState navBackgroundWin = chooseNavigationBackgroundWindow(this.mNavBarBackgroundWindowCandidate, this.mDisplayContent.mInputMethodWindow, this.mHasBottomNavigationBar);
        if (navBackgroundWin == null) goto L5;
    L8:
        boolean drawBackground = true;
    L10:
        if (this.mNavBarOpacityMode != 2) goto L14;
        if (drawBackground == false) goto L28;
        appearance = clearNavBarOpaqueFlag(appearance);
    L28:
        if (isFullyTransparentAllowed(navBackgroundWin, WindowInsets.Type.navigationBars()) == false) goto L30;
        return appearance;
    L30:
        return appearance | 64;
    L14:
        if (this.mNavBarOpacityMode != 0) goto L24;
        if (multiWindowTaskVisible == true) goto L21;
        if (freeformRootTaskVisible == true) goto L21;
        if (drawBackground == false) goto L28;
        appearance = clearNavBarOpaqueFlag(appearance);
    L21:
        if (this.mIsFreeformWindowOverlappingWithNavBar == false) goto L28;
        appearance = clearNavBarOpaqueFlag(appearance);
        goto L28
    L24:
        if (this.mNavBarOpacityMode != 1) goto L28;
        if (freeformRootTaskVisible == false) goto L28;
        appearance = clearNavBarOpaqueFlag(appearance);
        goto L28
    L5:
        if (this.mNavBarBackgroundWindowCandidate == null) goto L8;
        drawBackground = false;
        goto L10
    }

    private int clearNavBarOpaqueFlag(int appearance) {
        return appearance & (-3);
    }

    static WindowState chooseNavigationBackgroundWindow(WindowState candidate, WindowState imeWindow, boolean hasBottomNavigationBar) {
        if (imeWindow == null) goto L10;
        if (imeWindow.isVisible() == false) goto L10;
        if (hasBottomNavigationBar == false) goto L10;
        if (drawsBarBackground(imeWindow) == false) goto L10;
        return imeWindow;
    L10:
        if (drawsBarBackground(candidate) == false) goto L12;
        return candidate;
    L12:
        return null;
    }

    private boolean isImmersiveMode(WindowState win) {
        if (win != null) goto L6;
        return false;
    L6:
        if (win.mPolicy.getWindowLayerLw(win) <= win.mPolicy.getWindowLayerFromTypeLw(2000)) goto L8;
    L12:
        return false;
    L8:
        if (win.isActivityTypeDream() == true) goto L12;
        return getInsetsPolicy().hasHiddenSources(WindowInsets.Type.navigationBars());
    }

    private static boolean isNavBarEmpty(int systemUiFlags) {
        if ((systemUiFlags & 23068672) != 23068672) goto L5;
        return true;
    L5:
        return false;
    }

    void onPowerKeyDown(boolean isScreenOn) {
        boolean panic = isPowerKeyDownPanic(isScreenOn, SystemClock.elapsedRealtime(), isImmersiveMode(this.mSystemUiControllingWindow), isNavBarEmpty(this.mLastDisableFlags));
        if (panic == false) goto L6;
        this.mHandler.post(this.mHiddenNavPanic);
        return;
    }

    private boolean isPowerKeyDownPanic(boolean isScreenOn, long time, boolean inImmersiveMode, boolean navBarEmpty) {
        if (isScreenOn == false) goto L4;
    L7:
        if (isScreenOn == false) goto L11;
        if (inImmersiveMode == false) goto L11;
        if (navBarEmpty == true) goto L11;
        this.mPanicTime = time;
        return false;
    L11:
        this.mPanicTime = 0;
        return false;
    L4:
        if ((time - this.mPanicTime) >= this.mPanicThresholdMs) goto L7;
        return !this.mImmersiveConfirmationWindowExists;
    }

    public void onUserActivityEventTouch() {
        if (this.mAwake == false) goto L5;
        return;
    L5:
        WindowState w = this.mNotificationShade;
        ActivityTaskManagerService r1 = this.mService.mAtmService;
        if (w == null) goto L8;
        WindowProcessController r2 = w.getProcess();
    L9:
        r1.setProcessAnimatingWhileDozing(r2);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public void takeScreenshot(int screenshotType, int source) {
        if (this.mScreenshotHelper == null) goto L6;
        ScreenshotRequest request = new ScreenshotRequest.Builder(screenshotType, source).build();
        this.mScreenshotHelper.takeScreenshot(request, this.mHandler, null);
        return;
    }

    RefreshRatePolicy getRefreshRatePolicy() {
        return this.mRefreshRatePolicy;
    }

    void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.println("DisplayPolicy");
        String prefix2 = prefix + "  ";
        String prefixInner = prefix2 + "  ";
        pw.print(prefix2);
        pw.print("mCarDockEnablesAccelerometer=");
        pw.print(this.mCarDockEnablesAccelerometer);
        pw.print(" mDeskDockEnablesAccelerometer=");
        pw.println(this.mDeskDockEnablesAccelerometer);
        pw.print(prefix2);
        pw.print("mDockMode=");
        pw.print(Intent.dockStateToString(this.mDockMode));
        pw.print(" mLidState=");
        pw.println(WindowManagerPolicy.WindowManagerFuncs.lidStateToString(this.mLidState));
        pw.print(prefix2);
        pw.print("mAwake=");
        pw.print(this.mAwake);
        pw.print(" mScreenOnEarly=");
        pw.print(this.mScreenOnEarly);
        pw.print(" mScreenOnFully=");
        pw.println(this.mScreenOnFully);
        pw.print(prefix2);
        pw.print("mKeyguardDrawComplete=");
        pw.print(this.mKeyguardDrawComplete);
        pw.print(" mWindowManagerDrawComplete=");
        pw.println(this.mWindowManagerDrawComplete);
        pw.print(prefix2);
        pw.print("mHdmiPlugged=");
        pw.println(this.mHdmiPlugged);
        if (this.mLastDisableFlags == 0) goto L6;
        pw.print(prefix2);
        pw.print("mLastDisableFlags=0x");
        pw.println(Integer.toHexString(this.mLastDisableFlags));
    L6:
        if (this.mLastAppearance == 0) goto L9;
        pw.print(prefix2);
        pw.print("mLastAppearance=");
        pw.println(ViewDebug.flagsToString(InsetsFlags.class, "appearance", this.mLastAppearance));
    L9:
        if (this.mLastBehavior == 0) goto L11;
        pw.print(prefix2);
        pw.print("mLastBehavior=");
        pw.println(ViewDebug.flagsToString(InsetsFlags.class, "behavior", this.mLastBehavior));
    L11:
        pw.print(prefix2);
        pw.print("mShowingDream=");
        pw.print(this.mShowingDream);
        pw.print(" mDreamingLockscreen=");
        pw.println(this.mDreamingLockscreen);
        if (this.mStatusBar == null) goto L15;
        pw.print(prefix2);
        pw.print("mStatusBar=");
        pw.println(this.mStatusBar);
    L15:
        if (this.mNotificationShade == null) goto L17;
        pw.print(prefix2);
        pw.print("mExpandedPanel=");
        pw.println(this.mNotificationShade);
    L17:
        pw.print(prefix2);
        pw.print("isKeyguardShowing=");
        pw.println(isKeyguardShowing());
        if (this.mNavigationBar == null) goto L21;
        pw.print(prefix2);
        pw.print("mNavigationBar=");
        pw.println(this.mNavigationBar);
        pw.print(prefix2);
        pw.print("mNavBarOpacityMode=");
        pw.println(this.mNavBarOpacityMode);
        pw.print(prefix2);
        pw.print("mNavigationBarCanMove=");
        pw.println(this.mNavigationBarCanMove);
        pw.print(prefix2);
        pw.print("mHasBottomNavigationBar=");
        pw.println(this.mHasBottomNavigationBar);
    L21:
        if (this.mLeftGestureHost == null) goto L24;
        pw.print(prefix2);
        pw.print("mLeftGestureHost=");
        pw.println(this.mLeftGestureHost);
    L24:
        if (this.mTopGestureHost == null) goto L27;
        pw.print(prefix2);
        pw.print("mTopGestureHost=");
        pw.println(this.mTopGestureHost);
    L27:
        if (this.mRightGestureHost == null) goto L30;
        pw.print(prefix2);
        pw.print("mRightGestureHost=");
        pw.println(this.mRightGestureHost);
    L30:
        if (this.mBottomGestureHost == null) goto L33;
        pw.print(prefix2);
        pw.print("mBottomGestureHost=");
        pw.println(this.mBottomGestureHost);
    L33:
        if (this.mFocusedWindow == null) goto L36;
        pw.print(prefix2);
        pw.print("mFocusedWindow=");
        pw.println(this.mFocusedWindow);
    L36:
        if (this.mTopFullscreenOpaqueWindowState == null) goto L39;
        pw.print(prefix2);
        pw.print("mTopFullscreenOpaqueWindowState=");
        pw.println(this.mTopFullscreenOpaqueWindowState);
    L39:
        if (this.mSystemBarColorApps.isEmpty() == true) goto L42;
        pw.print(prefix2);
        pw.print("mSystemBarColorApps=");
        pw.println(this.mSystemBarColorApps);
    L42:
        if (this.mRelaunchingSystemBarColorApps.isEmpty() == true) goto L45;
        pw.print(prefix2);
        pw.print("mRelaunchingSystemBarColorApps=");
        pw.println(this.mRelaunchingSystemBarColorApps);
    L45:
        if (this.mNavBarColorWindowCandidate == null) goto L48;
        pw.print(prefix2);
        pw.print("mNavBarColorWindowCandidate=");
        pw.println(this.mNavBarColorWindowCandidate);
    L48:
        if (this.mNavBarBackgroundWindowCandidate == null) goto L51;
        pw.print(prefix2);
        pw.print("mNavBarBackgroundWindowCandidate=");
        pw.println(this.mNavBarBackgroundWindowCandidate);
    L51:
        if (this.mLastStatusBarAppearanceRegions == null) goto L56;
        pw.print(prefix2);
        pw.println("mLastStatusBarAppearanceRegions=");
        int i = this.mLastStatusBarAppearanceRegions.length - 1;
    L53:
        if (i < 0) goto L56;
        pw.print(prefixInner);
        pw.println(this.mLastStatusBarAppearanceRegions[i]);
        i = i - 1;
    L56:
        if (this.mLastLetterboxDetails == null) goto L61;
        pw.print(prefix2);
        pw.println("mLastLetterboxDetails=");
        int i2 = this.mLastLetterboxDetails.length - 1;
    L58:
        if (i2 < 0) goto L61;
        pw.print(prefixInner);
        pw.println(this.mLastLetterboxDetails[i2]);
        i2 = i2 - 1;
    L61:
        if (this.mStatusBarBackgroundWindows.isEmpty() == true) goto L65;
        pw.print(prefix2);
        pw.println("mStatusBarBackgroundWindows=");
        int i3 = this.mStatusBarBackgroundWindows.size() - 1;
    L63:
        if (i3 < 0) goto L65;
        WindowState win = this.mStatusBarBackgroundWindows.get(i3);
        pw.print(prefixInner);
        pw.println(win);
        i3 = i3 - 1;
    L65:
        pw.print(prefix2);
        pw.print("mTopIsFullscreen=");
        pw.println(this.mTopIsFullscreen);
        pw.print(prefix2);
        pw.print("mImeInsetsConsumed=");
        pw.println(this.mImeInsetsConsumed);
        pw.print(prefix2);
        pw.print("mForceShowNavigationBarEnabled=");
        pw.print(this.mForceShowNavigationBarEnabled);
        pw.print(" mAllowLockscreenWhenOn=");
        pw.println(this.mAllowLockscreenWhenOn);
        pw.print(prefix2);
        pw.print("mRemoteInsetsControllerControlsSystemBars=");
        pw.println(this.mRemoteInsetsControllerControlsSystemBars);
        pw.print(prefix2);
        pw.println("mDecorInsetsInfo:");
        this.mDecorInsets.dump(prefixInner, pw);
        if (this.mCachedDecorInsets == null) goto L69;
        pw.print(prefix2);
        pw.println("mCachedDecorInsets:");
        this.mCachedDecorInsets.mDecorInsets.dump(prefixInner, pw);
    L69:
        if (ViewRootImpl.CLIENT_TRANSIENT == true) goto L75;
        this.mSystemGestures.dump(pw, prefix2);
        return;
    }

    private boolean supportsPointerLocation() {
        if (this.mDisplayContent.isDefaultDisplay == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDisplayContent.isPrivate() == false) goto L8;
        return false;
    }

    void setPointerLocationEnabled(boolean pointerLocationEnabled) {
        if (supportsPointerLocation() == true) goto L5;
        return;
    L5:
        Handler r0 = this.mHandler;
        if (pointerLocationEnabled == false) goto L8;
        int r1 = 4;
    L9:
        r0.sendEmptyMessage(r1);
        return;
    L8:
        r1 = 5;
        goto L9
    }

    private void enablePointerLocation() {
        if (this.mPointerLocationView == null) goto L5;
        return;
    L5:
        this.mPointerLocationView = new PointerLocationView(this.mContext);
        this.mPointerLocationView.setPrintCoords(false);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.type = 2015;
        lp.flags = FrameworkStatsLog.TV_CAS_SESSION_OPEN_STATUS;
        lp.privateFlags |= 16;
        lp.setFitInsetsTypes(0);
        lp.layoutInDisplayCutoutMode = 3;
        if (ActivityManager.isHighEndGfx() == false) goto L8;
        lp.flags |= 16777216;
        lp.privateFlags |= 2;
    L8:
        lp.format = -3;
        lp.setTitle("PointerLocation - display " + getDisplayId());
        lp.inputFeatures = lp.inputFeatures | 1;
        WindowManager wm = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        wm.addView(this.mPointerLocationView, lp);
        this.mDisplayContent.registerPointerEventListener(this.mPointerLocationView);
    }

    private void disablePointerLocation() {
        if (this.mPointerLocationView != null) goto L6;
        return;
    L6:
        if (this.mDisplayContent.isRemoved() == true) goto L8;
        this.mDisplayContent.unregisterPointerEventListener(this.mPointerLocationView);
    L8:
        WindowManager wm = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        wm.removeView(this.mPointerLocationView);
        this.mPointerLocationView = null;
    }

    boolean isWindowExcludedFromContent(WindowState w) {
        if (w != null) goto L5;
    L10:
        return false;
    L5:
        if (this.mPointerLocationView == null) goto L10;
        if (w.mClient != this.mPointerLocationView.getWindowToken()) goto L11;
        return true;
    L11:
        return false;
    }

    void release() {
        this.mDisplayContent.mTransitionController.unregisterLegacyListener(this.mAppTransitionListener);
        Handler r0 = this.mHandler;
        final GestureNavigationSettingsObserver r1 = this.mGestureNavigationSettingsObserver;
        r1.getClass();
        r0.post(new DisplayPolicy$$ExternalSyntheticLambda6(r1));
        Handler r2 = this.mHandler;
        final ForceShowNavBarSettingsObserver r3 = this.mForceShowNavBarSettingsObserver;
        r3.getClass();
        r2.post(new DisplayPolicy$$ExternalSyntheticLambda7(r3));
        if (this.mService.mPointerLocationEnabled == false) goto L6;
        setPointerLocationEnabled(false);
        return;
    }

    static boolean isOverlappingWithNavBar(WindowState win) {
        if (win.isVisible() == true) goto L7;
        return false;
    L7:
        if (win.isDimming() == false) goto L9;
        Rect r0 = win.getBounds();
    L11:
        return intersectsAnyInsets(r0, win.getInsetsState(), WindowInsets.Type.navigationBars());
    L9:
        r0 = win.getFrame();
        goto L11
    }

    private static boolean intersectsAnyInsets(Rect bounds, InsetsState insetsState, int insetsType) {
        int i = insetsState.sourceSize() - 1;
    L3:
        if (i < 0) goto L11;
        InsetsSource source = insetsState.sourceAt(i);
        if ((source.getType() & insetsType) == 0) goto L10;
        if (Rect.intersects(bounds, source.getFrame()) == false) goto L10;
        return true;
    L10:
        i = i - 1;
        goto L3
    L11:
        return false;
    }

    boolean shouldAttachNavBarToAppDuringTransition() {
        if (this.mShouldAttachNavBarToAppDuringTransition == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNavigationBar == null) goto L7;
        return true;
    }

    public IExtDisplayPolicy getExt() {
        return this.mExt;
    }

    public IObricDisplayPolicy getObricExt() {
        return this.mObricExt;
    }
}
